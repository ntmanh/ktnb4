<%@page pageEncoding="UTF-8" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="tien_hanh_ttkt.do?method=save&type=nhatKy">
	<div style="margin: 5px; font-size: 12"><div>Nội dung nhật kí</div>
	<table width="100%" id="tblNhatKyTtkt">
		<tr class="TdHeaderList">
			<td align="left" style="width: 12%">Ngày <font color=red>*</font></td>
			<td align="left" style="width: 85%">Nội dung <font color=red>*</font></td>
			<td align="center" style="width: 3%"><INPUT type="checkbox"></td>
		</tr>
		<logic:present property="arrNhatKy" name="TienHanhTtktForm">
			<logic:iterate property="arrNhatKy" name="TienHanhTtktForm" indexId="index" id="nhatKy">
				<tr class='row<%=(index.intValue() % 2)+1 %>'>
					<td style="width: 12%"><html:hidden name="TienHanhTtktForm" property='<%="arrNhatKy[" + index + "].id"%>' /> <html:text styleClass="text" name="TienHanhTtktForm" property='<%="arrNhatKy[" + index + "].ngayStr"%>' onblur="if(!isDate(this)) return;validateNhatki(this)" onkeypress="return formatDate(event, this)">
					</html:text></td style="width: 85%">
					<td><html:textarea styleClass="textareaTitle" name="TienHanhTtktForm" onkeypress="imposeMaxLength(this);"  property='<%="arrNhatKy[" + index + "].noiDung"%>'>
					</html:textarea></td style="width: 3%">
					<td align="center"><INPUT type="checkbox"></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	<div style="text-align: right; width: 100%" align="right"><INPUT type="button" onclick="themNhatKy()" value="Thêm"> <INPUT type="button" value="Xóa" id="xoaNhatKy"></div>
	</div>
	<div style="margin: 5px; font-size: 12"><div>Nội dung khác (Khó khăn, vướng mắc...)</div> <html:textarea property="ndKhac" onkeypress="imposeMaxLength(this);"  styleClass="textareaContent"></html:textarea></div>
	<div style="text-align: right; width: 100%" align="right"><br>
	<INPUT type="button" value="In nhật kí" class="button1" onclick="inNhatKy()"></div>
</html:form>
<script language="javascript">	
function inNhatKy(){
	if(!validateNhatKy())
		return;
	var printfForm = findForm('/' + contextRoot + '/tien_hanh_ttkt.do?method=save&type=nhatKy');	
	printfForm.action = 'tien_hanh_ttkt.do?method=in&type=nhatKy&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	printfForm.submit();
	printfForm.action = '/' + contextRoot + '/tien_hanh_ttkt.do?method=save&type=nhatKy';
}
var nhatKyTtktTable = new TableObject('tblNhatKyTtkt', false, 'xoaNhatKy');
function themNhatKy(){
	nhatKyTtktTable.addRow(createNewNhatKyTtkt()); 
	
}
function createNewNhatKyTtkt(){   
	arrNhatKy = new Array();   
	index = nhatKyTtktTable.numOfRow - 1;
	arrNhatKy[0] = '<INPUT type="hidden" name="arrNhatKy[' + index + '].id">'
	arrNhatKy[0] += '<INPUT type="text" class = "text"  name="arrNhatKy[' + index + '].ngayStr" onblur="if(!isDate(this)) return;validateRequiredDate(this);" onkeypress="return formatDate(event, this)">'
	arrNhatKy[1] = '<TEXTAREA class="textareaTitle" onkeypress="imposeMaxLength(this);"  name="arrNhatKy[' + index + '].noiDung"></TEXTAREA>';	
	arrNhatKy[2] = '<input type="checkBox">'				
	return arrNhatKy;
}
function selectTvdNhatKy(){  
  
}
function validateNhatKy(){  
	gridNhatKyTtkt = document.getElementById('tblNhatKyTtkt');
	if(gridNhatKyTtkt.rows.length <= 1){
		alert('Bạn chưa nhập nội dung nhật ký!');
		return false;
	}else{
		for(i = 1; i < gridNhatKyTtkt.rows.length; i++){
			if(!isRequired(document.getElementsByName('arrNhatKy['+ eval(i - 1) +'].ngayStr')[0]))
				return false;
			if(!isRequired(document.getElementsByName('arrNhatKy['+ eval(i - 1) +'].noiDung')[0]))
				return false;
		}
	}	
	return true;  
}
function changeTvd(cbThanhVienDoan){
	// Chuc vu tvd
	document.getElementsByName(cbThanhVienDoan.name.replace('.idThanhVienDoan', '.chucVuTrongDoan'))[0].value = getChucVuTvd(cbThanhVienDoan.value)
	// Ten tvd
	selectedIndex = cbThanhVienDoan.selectedIndex;
	document.getElementsByName(cbThanhVienDoan.name.replace('.idThanhVienDoan', '.tenThanhVienDoan'))[0].value = cbThanhVienDoan[selectedIndex].text;
	// Thay doi du lieu
	document.getElementsByName(cbThanhVienDoan.name.replace('.idThanhVienDoan', '.isChange'))[0].value = '1';	
} 
function validateNhatki(dateElement){
var ngayRaQuyetDnh = '<%=request.getAttribute("ngayRaQuyetDnh")%>';
var ngayCbQuyetDnh =  $('[name="thoiDiemCbTu"]')[0].value;
if(d2n(ngayRaQuyetDnh) > d2n(dateElement.value)){
				alert('Thời gian phải sau thời gian ra quyết định('+ngayRaQuyetDnh+')');
				$(dateElement).focus().select();
			}
}
</script>