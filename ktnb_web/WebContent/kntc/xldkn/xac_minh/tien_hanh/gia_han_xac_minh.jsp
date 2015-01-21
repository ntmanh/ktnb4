<%@ page pageEncoding="UTF-8"%>

<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Quyết định gia hạn thời gian xác minh - 14/KN</h3> 
<html:form action="/kntc_xm_gia_han.do?method=giahan">
	<html:hidden property="maHoSo" />
	<html:hidden property="ma" styleId="ma" />
	<html:hidden property="trangThaiHoSo" />
	<html:hidden property="choSua" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red"> Số Quyết định</font> <html:text property="canCuQd" styleId="soQD" styleClass="text" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Danh sách các QĐ đã lập</legend>
	<table cellpadding="0" cellspacing="0" border="0" class="display" id="tbl_listPhieuHen">
		<thead>
			<tr>
				<th>Mã</th>
				<th>Số QĐ gia hạn</th> 
				<th>Ngày ban hành</th>
				<th>Người lập</th>
			</tr>
		</thead>
		<tbody>
			<tr align="center">
				<td colspan="4" class="dataTables_empty">.....</td>
			</tr>
		</tbody>
	</table>
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" id="btnXem" class="button" value='Xem' onclick="xem();" /> 
			<input type="button" id="btnNew" class="button" value='Tạo mới' onclick="taomoi();" /> 
			<input type="button" id="btnDel" class="button" value='Xóa' onclick="xoa();" /> 
			<input type="button" class="button" value='Đóng' onclick="window.close();"></td>
		</tr>
	</table>
	</fieldset>
	<div id="divContent">
	<fieldset><legend>Thông tin quyết định</legend>
	<table width="100%">
		<tr>
			<td style="text-align: right">Số quyết định<font color="red">*</font></td>
			<td><html:text property="soPhieu" style="width:100%" /></td>
			<td width="15%" style="text-align: right">Ngày ban hành quyết định</td>
			<td width="35%"><html:text property="ngayLap" style="width:100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right">Địa điểm <font color="red">*</font></td>
			<td width="35%"><html:text property="diaDiem" style="width:100%" /></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td style="text-align: right">Quyết định XM</td>
			<td><html:text property="canCuQd" style="width:100%" readonly="true" /></td>
			<td style="text-align: right">Ngày kết thúc xác minh</td>
			<td><html:text property="ngayKThucXM" style="width:100%" readonly="true" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">Căn cứ văn bản</td>
			<td colspan="3"><html:select property="canCuVb" styleClass="combobox" style="width:100%">
				<html:options collection="dmtly" property="value" labelProperty="label" />
			</html:select></td>
		</tr>
		<tr>
			<td style="text-align: right">Thời gian gia hạn <font color="red">*</font></td>
			<td colspan="3"><html:text property="soNgayGH" maxlength="2" style="width:10%" onkeypress="return formatInt(event);" onblur="validDateXm()" /> 
				Từ ngày<font color="red">*</font> 
				<html:text property="giaHanTuNgay" maxlength="10" style="width:30%" onkeypress="return formatDate(event, this)" onblur="isDate(this);validDateXm()" /> 
				Đến ngày 
				<html:text property="giaHanDenNgay" maxlength="10" style="width:30%"/></td>
		</tr>
	</table>
	</fieldset>
	<jsp:include page="../../../../button_bar_kntc_mau_phu.jsp" /> 
	<logic:present name="strDateHoliday">
		<script language="javascript">
			strHolidayDay = '<%=request.getAttribute("strDateHoliday")%>';	
		</script>
	</logic:present></div>
	<script language="JavaScript">
var oTable;
var pId;
$(function(){
	var ghiTC = "";
	 <logic:present name="ghiThanhcong">
	     	ghiTC = '<%=request.getAttribute("ghiThanhcong")%>';
	 </logic:present>
	 if(ghiTC=='1'){
		alert('Lưu thành công'); 
	 }
	 else  if(ghiTC=='0'){
		alert('Lỗi khi ghi dữ liệu!!!'); 
	 } 
	//Check không cho sửa nếu mẫu quyết định gia hạn đã duyệt
	if(document.forms[0].choSua.value == "false"){
		document.getElementById("btnSave").disabled = true;
	}
    <%request.removeAttribute("ghiThanhcong");%>
    var xoaTC = "";
	 <logic:present name="xoaThanhcong">
	     	xoaTC = '<%=request.getAttribute("xoaThanhcong")%>';
	 </logic:present>
	 if(xoaTC=='1')
	   alert('Xóa dữ liệu thành công!'); 
	 else  if(xoaTC=='0')
	   alert('Lỗi khi xóa dữ liệu!!!');
	//xử lý nút lưu và tạo mới nếu trạng thái khác xác minh 1611
	if(document.forms[0].trangThaiHoSo.value != "1611"){
		document.getElementById("btnSave").disabled = true;
		document.getElementById("btnNew").disabled = true;
		document.getElementById("btnDel").disabled = true; 
	}
    //xử lý table phiếu hẹn
    $("#tbl_listPhieuHen tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
		var iPos=oTable.fnGetPosition(event.target.parentNode);
		var aData=oTable.fnGetData(iPos);
		pId = aData[0];
	});
	var url='kntc_xm_gia_han.do?method=getListQd&id='+encodeURL(document.forms[0].maHoSo.value);
  	oTable=$("#tbl_listPhieuHen").dataTable({ 
  		"bJQueryUI":true, "sDom":'<"H"fr>t<"F"p>', 
  		"bSort": false,"bFilter": false, 
  		"bProcessing": true, "bServerSide": true, "sAjaxSource":url, "oLanguage":language
  	}).fnSetFilteringDelay(500);
  	
  	var method = '<%=request.getParameter("method")%>';
	if(method == 'xemQdgh' || method == 'taoMoiQdgh')
		show('divContent');
	else hide('divContent');
});

function ghi(){
	if(validForm()) {
		if(confirm ("Vui lòng kiểm tra lại thông tin nhập, Sau khi lưu thông tin quyết định gia hạn, bạn sẽ không thể sửa, xóa quyết định gia hạn?\n\n Ấn OK để xác nhận lưu quyết định\n Ấn Cancel để hủy và kiểm tra lại thông tin")){
			if(pId=='undefined' || pId == null || 'taoMoiQdgh'=='<%=request.getParameter("method")%>'){			
				if(	'null' == '<%=request.getParameter("pId")%>'){
					document.forms[0].action="kntc_xm_gia_han.do?method=saveGh&id="+document.forms[0].maHoSo.value+"&action="+'<%=request.getParameter("action")%>';	
				}else{
					document.forms[0].action="kntc_xm_gia_han.do?method=saveGh&id="+document.forms[0].maHoSo.value+"&pId="+'<%=request.getParameter("pId")%>'+"&action="+'<%=request.getParameter("action")%>';
				}
			}
			else{
				document.forms[0].action="kntc_xm_gia_han.do?method=saveGh&id="+document.forms[0].maHoSo.value+"&pId="+pId+"&action="+'<%=request.getParameter("action")%>';		
			}		
			document.forms[0].submit();	
		}
	}
}
function print(){
   document.forms[0].action="kntc_xm_gia_han.do?method=inGhXm&action="+'<%=request.getParameter("action")%>';
		document.forms[0].submit();
}

function xem(){
	var r = '<%=request.getParameter("r")%>';
	var anSelected = fnGetSelected( oTable );
	if(anSelected.length>0) {
		document.forms[0].action="kntc_xm_gia_han.do?method=xemQdgh&id="+document.forms[0].maHoSo.value+"&pId="+pId+"&action="+'<%=request.getParameter("action")%>'+"&r="+r;
		//alert("kntc_xm_phieu_yc.do?method=xemYcgt&id="+document.forms[0].soQD.value+"&pId="+pId);
		document.forms[0].submit();
	}
	else showMessage(chua_chon_ban_ghi);
}

function taomoi(){
	document.forms[0].action="kntc_xm_gia_han.do?method=taoMoiQdgh&id="+document.forms[0].maHoSo.value+"&action="+'<%=request.getParameter("action")%>';
	document.forms[0].submit();
}

function xoa(){
	var anSelected = fnGetSelected( oTable );
	if(anSelected.length>0) {
		if(confirm ("Bạn chắc chắn muốn xóa bản ghi đang chọn?")){
			document.forms[0].action="kntc_xm_gia_han.do?method=xoaQdgh&id="+document.forms[0].maHoSo.value+"&pId="+pId+"&action="+'<%=request.getParameter("action")%>';
			document.forms[0].submit();
		}
	}
	else showMessage(chua_chon_ban_ghi);
}

function validDateXm()
{	
	if(convertStringToNumber(document.forms[0].soNgayGH.value)>60){
		alert('Số ngày gia hạn không được quá 60 ngày!');
		document.forms[0].soNgayGH.select();
		return false;
	}
	caculateDate('giaHanTuNgay', 'giaHanDenNgay', document.forms[0].soNgayGH.value);
	//alert(document.forms[0].giaHanDenNgay.value);	
	if(!compareDate(document.forms[0].ngayRaQd,document.forms[0].giaHanTuNgay)) return false;
	if(!compareDate(document.forms[0].giaHanTuNgay,document.forms[0].giaHanDenNgay)) return false;
	return true;
}
function  validForm() {	
	//	if(!isRequired(document.forms[0].diaDiem,'Chưa nhập địa điểm')) return false;
	if(!isRequired(document.forms[0].soPhieu,'Chưa nhập số phiếu')) return false;
	if(!isRequired(document.forms[0].soNgayGH,'Chưa nhập số ngày gia hạn')) return false;
	//if(!isRequired(document.forms[0].ngayLap,'Chưa nhập ngày lập quyết định')) return false;	
	//if(!isRequired(document.forms[0].ngayRaQd,'Chưa nhập ngày ra quyết định')) return false;
	if(!isRequired(document.forms[0].canCuVb,'Chưa nhập căn cứ văn bản')) return false;
	if(!isRequired(document.forms[0].giaHanTuNgay,'Chưa nhập từ ngày')) return false;
	if(!isRequired(document.forms[0].giaHanDenNgay,'Chưa nhập đến ngày')) return false;
	if(!compareDate(document.forms[0].giaHanTuNgay,document.forms[0].giaHanDenNgay)) return false;
	if(!compareDate(document.forms[0].giaHanTuNgay,document.forms[0].ngayKThucXM,'Ngày bắt đầu gia hạn phải trước hoặc bằng ngày kết thúc xác minh')) return false;
	if(!compareDate(document.forms[0].ngayKThucXM,document.forms[0].giaHanDenNgay,'Ngày kết thúc gia hạn phải sau ngày kết thúc xác minh')) return false;
	return true;
}
</script>
</html:form>
<%@include file="/bottom.jsp"%>
