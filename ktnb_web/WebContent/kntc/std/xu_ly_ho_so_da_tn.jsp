<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Nhập số công văn đến</h3>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="/kntc_da_tiep_nhan.do?method=show" method="post">
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red">Số hồ sơ</font> <html:text property="maHoSo" styleId="ma" style="width:250px" readonly="true" /></div>
	<fieldset><legend>Thông tin công văn</legend>
	<table width="100%">
		<tr>
			<td width="50%" align="right">Ngày bộ phận văn thư nhận được công văn<font style="color: red;">*</font></td>
			<td><html:text property="ngayNhanVT" style="width:50%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" maxlength="10" /></td>
		</tr>
		<tr>
			<td align="right">Số công văn đến của bộ phận văn thư<font style="color: red;">*</font></td>
			<td><html:text property="soCVDenVT" style="width:50%" /></td>
		</tr>
		<tr>
			<td align="right">Ngày bộ phận xử lý nhận được công văn<font style="color: red;">*</font></td>
			<td><html:text property="ngayNhanXL" style="width:50%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" maxlength="10" /></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
	</table>
	</fieldset>
	<table width="100%">
		<tr>
			<td align="center"><input type="button" style="width: 60px" name="btnSave" class="button" onclick="ghi();" value="Lưu" /> <input type="button" style="width: 60px" name="btnCancel" class="button" onclick="goHomeKntc();" value="Đóng" /></td>
		</tr>
	</table>
</html:form>
<script language="JavaScript">
	$(document).ready(function(){
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
	function ghi(){
		if(validForm()){
			document.forms[0].action="kntc_da_tiep_nhan.do?method=save&id="+document.forms[0].maHoSo.value;;
			document.forms[0].submit();
		}
	}
	function validForm(){
		if(!isRequired(document.forms[0].ngayNhanVT,'Chưa nhập ngày bộ phận văn thư nhận được công văn'))
			return false;
		if(!isRequired(document.forms[0].soCVDenVT,'Chưa nhập số công văn đến của bộ phận văn thư'))
			return false;
		if(!isRequired(document.forms[0].ngayNhanXL,'Chưa nhập ngày bộ phận xử lý nhận được công văn'))
			return false;	
		return true;
	}
</script>
<%@ include file="/bottom.jsp"%>
