<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<fieldset><legend>Th&#244;ng tin quy&#7871;t &#273;&#7883;nh x&#225;c minh</legend>
<table width="100%">
	<tr>
		<td width="15%" align="right">&#272;&#7883;a &#273;i&#7875;m<font style="color: red">*</font></td>
		<td width="35%"><html:text property="diaDiem" style="width: 100%" /></td>
		<td width="15%" align="right">Ng&#224;y l&#7853;p <font style="color: red">*</font></td>
		<td width="35%"><html:text property="thoiDiem" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
	</tr>
	<tr>
		<td align="right">Nh&#7853;p file k&#7871;t qu&#7843; x&#225;c minh TC</td>
		<td colspan="3"><A href="#" onclick="openUploadFile(maHoSo);">File "K&#7871;t qu&#7843; x&#225;c minh TC" &#273;&#237;nh k&#232;m</A></td>
	</tr>
</table>
</fieldset>
<br>
<!--<jsp:include page="../../../thong_tin_ky_duyet.jsp" />-->
