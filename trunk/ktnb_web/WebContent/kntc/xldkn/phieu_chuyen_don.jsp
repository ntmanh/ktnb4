<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">PHIẾU CHUYỂN ĐƠN</h3>
<html:form action="/kntc_dxxl.do?method=phieuCd">
	<html:hidden property="maHidden" />
	<html:hidden property="loaiPhieu" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red">Số hồ sơ</font> <html:text property="maHoSo" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Danh sách các phiếu đã lập</legend>
	<table cellpadding="0" cellspacing="0" border="0" class="display" id="tblDanhSachPhieu">
		<thead>
			<tr>
				<th>Mã phiếu chuyển</th>
				<th>Ngày ban hành</th>
				<th>Đơn vị nhận phiếu</th>
			</tr>
		</thead>
		<tbody>
			<tr align="center">
				<td colspan="4" class="dataTables_empty">Loading data from server...</td>
			</tr>
		</tbody>
	</table>
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" class="button" id="btnXem" value='Xem' onclick="xem();" /> <input type="button" class="button" value='Tạo mới' onclick="taomoi();" /> <input type="button" class="button" value='Xóa' onclick="xoa();" /> <input type="button"
				class="button" id="btnClose2" value='Đóng' onclick="window.close();"></td>
		</tr>
	</table>
	</fieldset>
	<div id="divContent">
	<fieldset><legend>Thông tin phiếu</legend>
	<table width="100%">
		<tr>
			<td width="15%" style="text-align: right">Địa điểm</td>
			<td width="35%"><html:text property="diaDiem" style="width: 100%" /></td>
			<td width="15%" style="text-align: right">Ngày ban hành</td>
			<td width="35%"><html:text property="thoiDiem" style="width: 100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td style="text-align: right">Số phiếu</td>
			<td><html:text property="maPhieu" style="width: 100%" /></td>
			<td style="text-align: right">CQ có thẩm quyền GQ<font style="color: red;">*</font></td>
			<td><html:hidden property="cqtGqMa" /> <html:text property="cqtGqTen" style="width: 87%" /> <input type="button" class="button" name="btnCb" style="width: 10%" value="..." onclick="showLovCqt()"></td>
		</tr>
		<tr>
			<td style="text-align: right">Ngày công văn đến</td>
			<td><html:text property="congVanNgay" maxlength="10" style="width: 100%" readonly="true" /></td>
			<td style="text-align: right">Theo dấu công văn đến</td>
			<td><html:text property="congVanDenSo" style="width: 100%" readonly="true" /></td>
		</tr>
		<tr>
			<td style="text-align: right">Đơn, công văn đề ngày</td>
			<td><html:text property="donCvDeNgay" style="width: 100%" readonly="true" /></td>
			<td style="text-align: right">Đơn, công văn số</td>
			<td><html:text property="congVanSo" style="width: 100%" readonly="true" /></td>
		</tr>
		<tr>
			<td style="text-align: right">Người, cơ quan, đơn vị Khiếu nại</td>
			<td><html:text property="nguoiCqDvKn" style="width: 100%" readonly="true" /></td>
			<td style="text-align: right">Địa chỉ người, cơ quan, đơn vị Khiếu nại</td>
			<td><html:text property="diaChiCqDvKn" style="width: 100%" readonly="true" /></td>
		</tr>
		<tr>
			<td style="text-align: right">Tóm tắt nội dung đơn</td>
			<td colspan="3"><html:textarea property="noiDungDon" rows="5" onkeypress="imposeMaxLength(this);" style="width: 100%" /></td>
		</tr>
	</table>
	</fieldset>
	<jsp:include page="../../button_bar_kntc_mau_phu.jsp" /></div>
</html:form>
<script type="text/javascript" charset="utf-8"> 
var oTable;
var pId;
$(function(){	
	$("#tblDanhSachPhieu tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	    var iPos=oTable.fnGetPosition(event.target.parentNode);
		var aData=oTable.fnGetData(iPos);
		pId = aData[0];
	});
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
    
    var url='kntc_dxxl.do?method=getListPhieuChuyen&maHs='+document.forms[0].maHoSo.value;
  	oTable=$("#tblDanhSachPhieu").dataTable({
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
	if(method == 'xemPhieuChuyen' || method == 'taoMoiPhieuChuyen')
		show('divContent');
	else hide('divContent');
});

function xem(){
	var r = '<%=request.getParameter("r")%>';
	var anSelected = fnGetSelected( oTable );
	if(anSelected.length>0) {
		document.forms[0].action="kntc_dxxl.do?method=xemPhieuChuyen&action=bbxmkn&id="+document.forms[0].maHoSo.value+"&pId="+pId+"&r="+r;
		document.forms[0].submit();
	}
	else showMessage(chua_chon_ban_ghi);	
}

function taomoi(){
	document.forms[0].action="kntc_dxxl.do?method=taoMoiPhieuChuyen&id="+document.forms[0].maHoSo.value;
	document.forms[0].submit();
}

function xoa(){
	var anSelected = fnGetSelected( oTable );
	if(anSelected.length>0) {
		if(confirm ("Bạn chắc chắn muốn xóa bản ghi đang chọn?")){
			document.forms[0].action="kntc_dxxl.do?method=xoaPhieuChuyen&id="+document.forms[0].maHoSo.value+"&pId="+pId;
			document.forms[0].submit();
		}
	}
	else showMessage(chua_chon_ban_ghi);
}


function showLovCqt()
{
	tenCB = document.forms[0].cqtGqTen.value;
	if(tenCB!=null && tenCB!='' && tenCB!='null')
		openWindow("danhmuc_canbo.do?method=lovCqt&txtSearch="+normalizeString4SQL(tenCB));
	else
		openWindow("danhmuc_canbo.do?method=lovCqt");
}
function setData(values){
	var str_val= values.split("@@");  	
 	document.forms[0].cqtGqMa.value= str_val[0];
 	document.forms[0].cqtGqTen.value= str_val[1];	 	
}
function ghi(){
	if (validForm()){
	document.forms[0].action="kntc_dxxl.do?method=save";
	document.forms[0].submit();
	}
}

function validForm(){
	//if(!isRequired(document.forms[0].elements['diaDiem'], 'Chưa nhập địa điểm lập phiếu'))
		//return false;
	//if(!isRequired(document.forms[0].elements['thoiDiem'], 'Chưa nhập ngày nhập phiếu'))
		//return false;
	if(!isRequired(document.forms[0].elements['cqtGqTen'], 'Chưa chọn cơ quan thuế có thẩm quyền giải quyết'))
		return false;
	return true;
}
function print(){		
		document.forms[0].action="kntc_dxxl.do?method=in";
		document.forms[0].submit();
}
</script>
<%@ include file="/bottom.jsp"%>
