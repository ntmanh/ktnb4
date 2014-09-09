<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<fieldset><legend>Th&#244;ng tin b&#225;o c&#225;o</legend>
<table width="100%">
	<tr>
		<td width="15%" align="right">Ph&#226;n t&#237;ch k&#7871;t qu&#7843;</td>
		<td colspan="3"><html:radio property="phanTichKq" value="1" />&#272;&#250;ng <html:radio property="phanTichKq" value="0" />Sai <html:radio property="phanTichKq" value="2" />C&#243; &#273;&#250;ng, c&#243; sai</td>
	</tr>
	<tr>
		<td width="15%" align="right">X&#7917; l&#253; h&#224;nh ch&#237;nh</td>
		<td width="35%"><html:text property="xlySoNguoi" maxlength="3" onkeypress="return formatInt(event);" style="width: 50%" /></td>
		<td width="15%" align="right">S&#7889; ng&#432;&#7901;i, &#273;&#417;n v&#7883; &#273;&#432;&#7907;c tr&#7843; l&#7841;i quy&#7873;n l&#7907;i</td>
		<td width="35%"><html:text property="denBuSoNguoi" maxlength="3" onkeypress="return formatInt(event);" style="width: 50%" /></td>
	</tr>
	<tr>
		<td width="15%" align="right">Bi&#7879;n ph&#225;p kh&#225;c ph&#7909;c h&#7853;u qu&#7843;</td>
		<td colspan="3"><html:textarea property="xlyHinhThuc" onkeypress="imposeMaxLength(this);" style="width: 100%" /></td>
	</tr>
</Table>
<fieldset><legend>Ki&#7871;n ngh&#7883; thu h&#7891;i cho nh&#224; n&#432;&#7899;c</legend>
<table width="100%">
	<tr>
		<td width="15%" align="right">Ti&#7873;n</td>
		<td width="35%"><html:text property="knthNnSoTien" style="width: 90%" />VN&#272;</td>
		<td width="15%" align="right">&#272;&#7845;t</td>
		<td width="35%"><html:text property="knthNnDat" style="width: 90%" />m2</td>
	</tr>
	<tr>
		<td width="15%" align="right">Lo&#7841;i kh&#225;c</td>
		<td width="35%"><html:textarea property="knthNnLoai" onkeypress="imposeMaxLength(this);" style="width: 90%" /></td>
		<td width="15%" align="right">Tr&#7883; gi&#225;</td>
		<td width="35%"><html:text property="knthNnTriGia" style="width: 90%" />VN&#272;</td>
	</tr>
</table>
</fieldset>
<fieldset><legend>Ho&#224;n tr&#7843; cho c&#244;ng d&#226;n</legend>
<table width="100%">
	<tr>
		<td width="15%" align="right">Ti&#7873;n</td>
		<td width="35%"><html:text property="htcdTien" style="width: 90%" />VN&#272;</td>
		<td width="15%" align="right">&#272;&#7845;t</td>
		<td width="35%"><html:text property="htcdDat" style="width: 90%" />m2</td>
	</tr>
	<tr>
		<td width="15%" align="right">Lo&#7841;i kh&#225;c</td>
		<td width="35%"><html:textarea property="htcdLoai" onkeypress="imposeMaxLength(this);" style="width: 90%" /></td>
		<td width="15%" align="right">Tr&#7883; gi&#225;</td>
		<td width="35%"><html:text property="htcdTriGia" style="width: 90%" />VN&#272;</td>
	</tr>
</table>
</fieldset>
</fieldset>
