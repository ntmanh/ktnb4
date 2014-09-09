<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<fieldset><legend>Th&#244;ng tin k&#253; duy&#7879;t</legend>
<table width="100%">
	<tr>
		<td width="15%" align="right">Ng&#224;y tr&#236;nh tr&#432;&#7903;ng b&#7897; ph&#7853;n k&#253;</td>
		<td width="35%"><html:text property="ngayTrinhKy" style="width:100%" onkeypress="return formatDate(event, this)" maxlength="10" onblur="isDate(this);dateValid();" /></td>
		<td width="15%" align="right">Ng&#224;y tr&#432;&#7903;ng b&#7897; ph&#7853;n k&#253;</td>
		<td width="35%"><html:text property="ngayKy" style="width: 100%" onkeypress="return formatDate(event, this)" maxlength="10" onblur="isDate(this);dateValid();" /></td>
	</tr>
	<tr>
		<td width="15%" align="right">&#221; ki&#7871;n c&#7911;a tr&#432;&#7903;ng b&#7897; ph&#7853;n</td>
		<td colspan="3"><html:textarea property="kienTrinh" onkeypress="imposeMaxLength(this);" style="width:100%;height:40px;" /></td>
	</tr>
	<tr>
		<td width="15%" align="right">Ng&#224;y tr&#236;nh th&#7911; tr&#432;&#7903;ng k&#253;</td>
		<td width="35%"><html:text property="ngayTrinhDuyet" style="width:100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this);dateValid();" /></td>
		<td width="15%" align="right">Ng&#224;y th&#7911; tr&#432;&#7903;ng k&#253;</td>
		<td width="312" align="right"><html:text property="ngayDuyet" style="width: 100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this);dateValid();" /></td>
	</tr>
	<tr>
		<td width="15%" align="right">&#221; ki&#7871;n c&#7911;a th&#7911; tr&#432;&#7903;ng</td>
		<td colspan="3"><html:textarea property="kienDuyet" onkeypress="imposeMaxLength(this);" style="width:100%;height:40px;" /></td>
	</tr>
</table>
</fieldset>
<script type="text/javascript" charset="UTF-8"> 
function dateValid(){
	if(!compareDate(document.forms[0].ngayTrinhKy,document.forms[0].ngayKy))
		return false;
	if(!compareDate(document.forms[0].ngayTrinhDuyet,document.forms[0].ngayDuyet))
		return false;
	if(!compareDate(document.forms[0].ngayKy,document.forms[0].ngayTrinhDuyet))
		return false;
	return true;	
}
</script>