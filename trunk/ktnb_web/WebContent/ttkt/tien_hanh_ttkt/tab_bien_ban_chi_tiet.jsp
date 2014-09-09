<%@page pageEncoding="UTF-8" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="tien_hanh_ttkt.do?method=save&type=bienBanChiTiet">
	<table width="100%" id="tblBbChiTiet">
		<tr class="TdHeaderList">
			<td>Người lập</td>
			<td><!-- Thanh tra Kiểm tra tại --> Kiểm tra tại</td>
			<td>Thời gian thực hiện</td>
			<td>Thời điểm lập</td>
			<td>Nơi lập</td>
			<td>Thời điểm thông qua</td>
			<td>File đính kèm</td>
			<td align="center">Chọn</td>
		</tr>
		<logic:present name="TienHanhTtktForm" property="arrBienBanChiTiet">
			<logic:iterate name="TienHanhTtktForm" property="arrBienBanChiTiet" indexId="index" id="bienBanChiTiet">
				<tr class='row<%=(index.intValue() % 2)+1 %>'>
					<td><html:hidden name="TienHanhTtktForm" property='<%="arrBienBanChiTiet[" + index + "].id"%>' /> <bean:write name="TienHanhTtktForm" property='<%="arrBienBanChiTiet[" + index + "].tenNguoiLap"%>' /></td>
					<td><bean:write name="TienHanhTtktForm" property='<%="arrBienBanChiTiet[" + index + "].ttktTai"%>' /></td>
					<td><bean:write name="TienHanhTtktForm" property='<%="arrBienBanChiTiet[" + index + "].tgianThTuNgayStr"%>' />-<bean:write name="TienHanhTtktForm" property='<%="arrBienBanChiTiet[" + index + "].tgianThDenNgayStr"%>' /></td>
					<td><bean:write name="TienHanhTtktForm" property='<%="arrBienBanChiTiet[" + index + "].thoiDiemLapBbStr"%>' /></td>
					<td><bean:write name="TienHanhTtktForm" property='<%="arrBienBanChiTiet[" + index + "].diaDiemLapBb"%>' /></td>
					<td><bean:write name="TienHanhTtktForm" property='<%="arrBienBanChiTiet[" + index + "].thoiDiemThongQuaStr"%>' /></td>
					<td><A href="#" onclick="downloadBienBanChiTiet1('<bean:write name="TienHanhTtktForm" property='<%="arrBienBanChiTiet[" + index + "].id"%>'/>');">File đính kèm</A></td>
					<td align="center"><INPUT type="radio" name="xxx"></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	<DIV style="text-align: right" align="center"><INPUT type="button" value="Thêm" onclick="themBienBanChiTiet()"> <INPUT type="button" value="Sửa" onclick="suaBienBanChiTiet()"> <INPUT type="button" value="Xóa" id="xoaBbChiTiet123" style="display: none;">
	<INPUT type="button" value="Xóa" onclick="xoaBbChiTiet456()"></DIV>
</html:form>
<script language="javascript">     
var isSaveItem = false;  

function xoaBbChiTiet456(){  
	if(tblBbChiTiet.getNumOfSelectedRow()==0){		
		alert('Bạn chưa chọn bản ghi nào!');
		return;
	}
	idBienBanChiTiet = document.getElementsByName('arrBienBanChiTiet[' + eval(tblBbChiTiet.getSelectedIndex() - 1) + '].id')[0].value;
	var xmlHttpReq = false;
	if (window.XMLHttpRequest)
		xmlHttpReq = new XMLHttpRequest(); 
    else if (window.ActiveXObject)
    	xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
    xmlHttpReq.open("POST", "tien_hanh_ttkt.do?method=xoaBbChiTiet&id=" + idBienBanChiTiet, true); 
    xmlHttpReq.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=UTF-8");
    xmlHttpReq.onreadystatechange = function() {
    	if (xmlHttpReq.readyState==4 && xmlHttpReq.status==200){
			var saveStatus = xmlHttpReq.responseText;
		  	if(saveStatus == 'cucsess'){
		  		alert('Xóa thành công!');				
		  		tblBbChiTiet.deleteSelectedRow();
		  	}
		  		
		}		    	
    }
    xmlHttpReq.send();
	
	
	
}
function validateBienBanChiTiet(){
	return true;
}
function suaBienBanChiTiet(){
	if(tblBbChiTiet.getNumOfSelectedRow()==0){		
		alert('Bạn chưa chọn bản ghi nào!');
		return;
	}
	var selectedRow = tblBbChiTiet.getSelectedRow();
	var id = selectedRow.cells[0].childNodes[0].value;
	window.open('bien_ban_chi_tiet.do?id=' + id);
} 
function addBienBanChiTietRow(tenNguoiLap, ttktTai, thoiDiemLapBb, diaDiemLapBb, tgianThTuNgay, tgianThDenNgay, thoiDiemThongQua, fileId){
	tblBbChiTiet.addRow(createRowDescription(tenNguoiLap, ttktTai, thoiDiemLapBb, diaDiemLapBb, tgianThTuNgay, tgianThDenNgay, thoiDiemThongQua, fileId));	
	
}
function createRowDescription(tenNguoiLap, ttktTai, thoiDiemLapBb, diaDiemLapBb, tgianThTuNgay, tgianThDenNgay, thoiDiemThongQua, fileId){
	arrReturn = new Array();
	arrReturn[0] = '<INPUT value= "'+ fileId + '" type=hidden name=arrBienBanChiTiet[' + tblBbChiTiet.numOfRow + '].id>' + tenNguoiLap;
	arrReturn[1] = ttktTai; 
	arrReturn[2] = tgianThTuNgay.substring(0,5) + '-' + tgianThDenNgay; 
	arrReturn[3] = thoiDiemLapBb;
	arrReturn[4] = diaDiemLapBb;

	arrReturn[5] = thoiDiemThongQua;
	arrReturn[6] = '<a href = "#" onclick = "downloadBienBanChiTiet1(' +"'"+ fileId +"'"+');">File đính kèm</a>'
	arrReturn[7] = '<INPUT type="radio" name = "xxx">'
	return arrReturn;
} 
function upDateBienBanChiTietRow(tenNguoiLap, ttktTai, thoiDiemLapBb, diaDiemLapBb, tgianThTuNgay, tgianThDenNgay, thoiDiemThongQua, fileId){
	fileId+="";
	tblBbChiTiet.updateRow(createRowDescription(tenNguoiLap, ttktTai, thoiDiemLapBb, diaDiemLapBb, tgianThTuNgay, tgianThDenNgay, thoiDiemThongQua, fileId));
	
}
 
function downloadBienBanChiTiet1(bbchiTietId){
	downLoadWinDow = window.open('UploadAction.do?method=downLoadBienBan&ma_file='+bbchiTietId);
	downLoadWinDow.focus();
}
var tblBbChiTiet = new TableObject('tblBbChiTiet', false, 'xoaBbChiTiet123');
function downLoadAttackment(){
}
function themBienBanChiTiet(){	
	window.open('bien_ban_chi_tiet.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);
}
function xoaBienBanChiTiet(){
	document.getElementById('xoaBbChiTiet123').onclick();
	document.getElementsByName('btnSave')[0].onclick();	
}
</script>