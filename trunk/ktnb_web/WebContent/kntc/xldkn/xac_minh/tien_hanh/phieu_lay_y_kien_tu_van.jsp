<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Phiếu lấy ý kiến tư vấn - 12/KN</h3>
<html:form action="/kntc_xm_phieu_yc.do?method=yktv">
	<html:hidden property="maHoSo" />
	<html:hidden property="ma" styleId="ma" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red"> Số Quyết định</font> <html:text property="kntcQdinhXm" styleId="soQD" styleClass="text" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Danh sách các phiếu đã lập</legend>
	<table cellpadding="0" cellspacing="0" border="0" class="display" id="tbl_listPhieuHen">
		<thead>
			<tr>
				<th>Mã phiếu</th>
				<th>Ngày lập phiếu</th>
				<th>Cơ quan, đơn vị tham gia ý kiến</th>
			</tr>
		</thead>
		<tbody>
			<tr align="center">
				<td colspan="3" class="dataTables_empty">.....</td>
			</tr>
		</tbody>
	</table>
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" id="btnXem" class="button" value='Xem' onclick="xem();" /> <input type="button" class="button" value='Tạo mới' onclick="taomoi();" /> <input type="button" class="button" value='Xóa' onclick="xoa();" /> <input type="button"
				class="button" value='Đóng' onclick="window.close();"></td>
		</tr>
	</table>
	</fieldset>
	<div id="divContent">
	<fieldset><legend>Thông tin phiếu</legend>
	<TABLE width="100%">
		<TBODY>
			<tr>
				<td width="15%" style="text-align: right;">Địa điểm lập phiếu <font color="red">*</font></td>
				<td width="35%"><html:text property="diaDiem" style="width:100%" /></td>
				<td width="15%" style="text-align: right;">Ngày lập phiếu <font color="red">*</font></td>
				<td width="35%"><html:text property="ngayLap" style="width:100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Số phiếu <font color="red">*</font></td>
				<td><html:text property="maPhieu" style="width:100%" /></td>
				<td style="text-align: right;"></td>
				<td></td>
			</tr>
			<tr>
				<td style="text-align: right;">Ý kiến về việc<font color="red">*</font></td>
				<td colspan="3"><html:text property="yKienVeViec" style="width:100%" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Cơ quan,đơn vị tham gia ý kiến<font color="red">*</font></td>
				<td colspan="3"><html:text property="donViYkien" style="width:100%" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Nội dung <font color="red">*</font></td>
				<td colspan="3"><html:textarea property="yeuCauYcgt" onkeypress="imposeMaxLength(this);" style="width:100%;height:80px;" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Thời hạn xin ý kiến <font color="red">*</font></td>
				<td><html:text property="thoiDiemYcgt" style="width:100%;" onblur="isDate(this)" onkeypress="return formatDate(event, this)" /></td>
				<td style="text-align: right;"></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="3"><A href="#" onclick="openUploadFile();">File đính kèm phiếu lấy ý kiến</A></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
	<jsp:include page="../../../../button_bar_kntc_mau_phu.jsp" /></div>
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
    <%request.removeAttribute("ghiThanhcong");%>
    var xoaTC = "";
	 <logic:present name="xoaThanhcong">
	     	xoaTC = '<%=request.getAttribute("xoaThanhcong")%>';
	 </logic:present>
	 if(xoaTC=='1')
	   alert('Xóa dữ liệu thành công!'); 
	 else  if(xoaTC=='0')
	   alert('Lỗi khi xóa dữ liệu!!!');
    
    $("#tbl_listPhieuHen tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
		var iPos=oTable.fnGetPosition(event.target.parentNode);
		var aData=oTable.fnGetData(iPos);
		pId = aData[0];
	});
    var url='kntc_xm_phieu_yc.do?method=getListPhieu&maHs='+encodeURL(document.forms[0].maHoSo.value)+'&t=15A/KNTC';
  	oTable=$("#tbl_listPhieuHen").dataTable({
     	"bJQueryUI":true,
		"sDom":'<"H"fr>t<"F"p>',
		"bSort": false,
		"bFilter": false,
		"bProcessing": true,
		"bServerSide": true,
		"sAjaxSource":url,
		"oLanguage":language		
	}).fnSetFilteringDelay(500);
	
	var method = '<%=request.getParameter("method")%>';
	if(method == 'xemYktv' || method == 'taoMoiYktv')
		show('divContent');
	else hide('divContent');
});
function ghi(){
	if(validForm()){	
		if(pId=='undefined' || pId == null || 'taoMoiYcgt'=='<%=request.getParameter("method")%>'){			
			if(	'null' == '<%=request.getParameter("pId")%>'){
				document.forms[0].action="kntc_xm_phieu_yc.do?method=saveYktv&id="+document.forms[0].maHoSo.value+"&action="+'<%=request.getParameter("action")%>';	
			}else{
				document.forms[0].action="kntc_xm_phieu_yc.do?method=saveYktv&id="+document.forms[0].maHoSo.value+"&pId="+'<%=request.getParameter("pId")%>'+"&action="+'<%=request.getParameter("action")%>';
			}
		}
		else{
			document.forms[0].action="kntc_xm_phieu_yc.do?method=saveYktv&id="+document.forms[0].maHoSo.value+"&pId="+pId+"&action="+'<%=request.getParameter("action")%>';		
		}		
		document.forms[0].submit();
	}	
}
function print(){
    document.forms[0].action="kntc_xm_phieu_yc.do?method=in&type=15/KTNB&action="+'<%=request.getParameter("action")%>';
    document.forms[0].submit();
}
function xem(){
	var r = '<%=request.getParameter("r")%>';
	var anSelected = fnGetSelected( oTable );
	if(anSelected.length>0) {
		document.forms[0].action="kntc_xm_phieu_yc.do?method=xemYktv&id="+document.forms[0].maHoSo.value+"&pId="+pId+"&action="+'<%=request.getParameter("action")%>'+"&r="+r;
		//alert("kntc_xm_phieu_yc.do?method=xemYcgt&id="+document.forms[0].soQD.value+"&pId="+pId);
		document.forms[0].submit();
	}
	else showMessage(chua_chon_ban_ghi);
}

function taomoi(){
	document.forms[0].action="kntc_xm_phieu_yc.do?method=taoMoiYktv&id="+document.forms[0].maHoSo.value+"&action="+'<%=request.getParameter("action")%>';
	document.forms[0].submit();
}

function xoa(){
	var anSelected = fnGetSelected( oTable );
	if(anSelected.length>0) {
		if(confirm ("Bạn chắc chắn muốn xóa bản ghi đang chọn?")){
			document.forms[0].action="kntc_xm_phieu_yc.do?method=xoaYktv&id="+document.forms[0].maHoSo.value+"&pId="+pId+"&action="+'<%=request.getParameter("action")%>';
			document.forms[0].submit();
		}
	}
	else showMessage(chua_chon_ban_ghi);
}
function showLovCanbo()
{	
	valueD = document.forms[0].nguoiNhanBc.value;
	if(valueD!=null && valueD!='' && valueD!='null')
		openWindow("danhmuc_canbo.do?method=lov&txtSearch="+valueD);
	else
		openWindow("danhmuc_canbo.do?method=lov");
}
function setData(values){
	var str_val= values.split("@@"); 
 	document.forms[0].nguoiNhanBc.value = str_val[1];				
}

function validForm() {
	//if(!isRequired(document.forms[0].diaDiem,'Chưa nhập địa điểm lập phiếu')) return false;
//	if(!isRequired(document.forms[0].ngayLap,'Chưa nhập ngày lập phiếu')) return false;
	if(!isRequired(document.forms[0].donViYkien,'Chưa nhập đơn vị, tổ chức lấy ý kiến')) return false;
	if(!isRequired(document.forms[0].yeuCauYcgt,'Chưa nhập nội dung lấy ý kiến')) return false;
	//if(!isRequired(document.forms[0].thoiDiemYcgt,'Chưa nhập yêu cầu giải trình')) return false;
	return true;
}
function openUploadFile(){
	if(validForm())
	{
		var view='';
		var method = '<%=request.getParameter("method")%>';
		if(method == 'view') view = 'view';
		var r = '<%=request.getParameter("r")%>';
		if(r == 'rol') view = 'view';
		
	    var maHS = document.forms[0].maHoSo.value;
	    var act = '<%=request.getParameter("action")%>';    
	    if(maHS!=null && maHS!='' && maHS!='null')
			openWindow("UploadAction.do?parentId="+maHS+"&nv=KNTC/PLYK&view="+view);
		else
			alert("Chưa có thông tin về hồ sơ!");	
	}
}
</script>
</html:form>
<%@include file="/bottom.jsp"%>
