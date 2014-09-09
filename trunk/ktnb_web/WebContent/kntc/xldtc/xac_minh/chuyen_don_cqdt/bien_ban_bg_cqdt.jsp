<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<h3 class="Header">Biên bản bàn giao hồ sơ vụ việc có dấu hiệu tội phạm - Mẫu 25B/KNTC</h3>
<html:form action="/kntc_bb.do?method=bb25B" method="post" styleId="form">
	<!--<html:hidden property="thanhPhan" />
	<html:hidden property="noiDung" />
	<html:hidden property="daiDien" />-->
	<html:hidden property="act" styleId="act" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red">Số hồ sơ</font> <html:text property="maHoSo" styleId="maHoSo" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Biên bản bàn giao</legend>
	<table width="100%">
		<tr>
			<td width="15%" style="text-align: right;">Địa điểm <font style="color: red">*</font></td>
			<td width="289"><html:text property="diaDiem" style="width:100%" /></td>
			<td width="15%" style="text-align: right;">Thời gian làm việc<font style="color: red">*</font></td>
			<td width="312"><html:text property="thoiDiem" style="width: 100%" onblur="isTime(this)" onkeypress="return formatTime(event, this)" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">Tên đơn vị bàn giao hồ sơ vụ việc<font style="color: red">*</font></td>
			<td colspan="3"><html:textarea property="daiDien" style="width:660px"/></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">Tên cơ quan điều tra (hoặc Viện Kiểm sát)<font style="color: red">*</font></td>
			<td colspan="3"><html:textarea property="thanhPhan" style="width:660px"/></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">Tài liệu, chứng cứ kèm theo <font style="color: red">*</font></td>
			<td colspan="3"><html:textarea property="noiDung" style="width:660px"/></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">Số trang tài liệu <font style="color: red">*</font></td>
			<td width="35%"><html:text property="soTrangTl" style="width: 100%" onblur="isNumber(this,'i');"/></td>
			<td width="15%" style="text-align: right;">Số bằng chứng <font style="color: red">*</font></td>
			<td width="35%"><html:text property="soBangChung" style="width: 100%" onblur="isNumber(this,'i');"/></td>
		</tr>
		<tr>
			<td>Việc giao nhận hoàn thành vào lúc <font style="color: red">*</font></td>
			<td colspan="3"><html:text property="thoiDiemHoanThanh" style="width: 100%" onblur="isTime(this)" onkeypress="return formatTime(event, this)" /></td>
		</tr>
	</table>
	</fieldset>
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" id="btnKetXuat" class="button" value='Kết xuất' name="in" onclick="print();"> 
			<input type="button" class="button" value='Lưu' name="save" onclick="ghi();"> 
			<input type="button" class="button" value='Đóng' name="exit" onclick="window.close();"></td>
		</tr>
	</table>
</html:form>
<script type="text/javascript" language="JavaScript" charset="utf-8">
var oTable;
/*bkLib.onDomLoaded(function() {
	new nicEditor({maxHeight : 200}).panelInstance('daiDienmce');
	new nicEditor({maxHeight : 200}).panelInstance('thanhPhanmce');
	new nicEditor({maxHeight : 200}).panelInstance('noiDungmce');
});*/
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
});

window.onload=function(){
	//window.setTimeout("nicEditors.findEditor('daiDienmce').setContent(document.forms[0].daiDien.value)",250);
	//window.setTimeout("nicEditors.findEditor('thanhPhanmce').setContent(document.forms[0].thanhPhan.value)",250);
	//window.setTimeout("nicEditors.findEditor('noiDungmce').setContent(document.forms[0].noidung.value)",250);
};
function print(){	
	//document.forms[0].daiDien.value = nicEditors.findEditor('daiDienmce').getContent();
	//document.forms[0].thanhPhan.value = nicEditors.findEditor('thanhPhanmce').getContent();
	//document.forms[0].noidung.value =  nicEditors.findEditor('noiDungmce').getContent();
	document.forms[0].action="kntc_bb.do?method=inBb25B";
	document.forms[0].submit();
}
function ghi(){
	//document.forms[0].daiDien.value = nicEditors.findEditor('daiDienmce').getContent();
	//document.forms[0].thanhPhan.value = nicEditors.findEditor('thanhPhanmce').getContent();
	//document.forms[0].noidung.value =  nicEditors.findEditor('noiDungmce').getContent();		
	if(validForm()) {	
		document.forms[0].action="kntc_bb.do?method=saveBb25&id="+document.forms[0].maHoSo.value;
		document.forms[0].submit();
	}
}
function validForm() {
//	if(!isRequired(document.forms[0].diaDiem,'Chưa nhập địa điểm')) return false;
//	if(!isRequired(document.forms[0].thoiDiem,'Chưa nhập ngày ra QĐ')) return false;
	if(!isRequired(document.forms[0].noiDung,'Chưa nhập nội dung làm việc')) return false;
	if(!isRequired(document.forms[0].thanhPhan,'Chưa nhập các bên liên quan')) return false;
	return true;
}
</script>
<%@ include file="/bottom.jsp"%>
