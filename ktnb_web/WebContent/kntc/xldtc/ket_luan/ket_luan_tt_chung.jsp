<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<fieldset><legend>Th&#244;ng tin k&#7871;t lu&#7853;n</legend>
<table width="100%">
	<tr>
		<td width="15%" align="right">&#272;&#7883;a &#273;i&#7875;m <font style="color: red">*</font></td>
		<td width="35%"><html:text property="diaDiem" style="width: 100%" /></td>
		<td width="15%" align="right">Ng&#224;y l&#7853;p k&#7871;t lu&#7853;n <font style="color: red">*</font></td>
		<td width="35%"><html:text property="thoiDiem" style="width: 100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
	</tr>
	<tr>
		<td align="right">S&#7889; <font style="color: red">*</font></td>
		<td><html:text property="maKq" style="width: 100%" /></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td align="right">Nh&#7853;p file k&#7871;t lu&#7853;n n&#7897;i dung</td>
		<td colspan="3"><A href="#" onclick="openUploadFile(maHoSo);">Th&#244;ng tin file k&#7871;t lu&#7853;n n&#7897;i dung</A></td>
	</tr>
</table>
</fieldset>
<br>
<jsp:include page="../../thong_tin_ky_duyet.jsp" />
