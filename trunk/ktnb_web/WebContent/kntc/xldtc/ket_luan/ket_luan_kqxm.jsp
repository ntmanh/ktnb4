<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<fieldset><legend>Th&#244;ng tin k&#7871;t qu&#7843; x&#225;c minh n&#7897;i dung t&#7889; c&#225;o</legend>
<table width="100%">
	<tr>
		<td><html:textarea property="noiDungToCao" onkeypress="imposeMaxLength(this);" style="width: 100%;height:80px" /></td>
	</tr>
</table>
</fieldset>
