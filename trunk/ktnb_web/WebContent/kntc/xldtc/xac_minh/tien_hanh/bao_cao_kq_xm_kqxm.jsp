<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<fieldset><legend>Th&#244;ng tin quy&#7871;t &#273;&#7883;nh x&#225;c minh</legend>
<table width="100%">
	<tr>
		<td width="263">T&#243;m t&#7855;t n&#7897;i dung &#273;&#417;n TC</td>
		<td colspan="3" width="1031"><html:textarea property="noiDungDon" onkeypress="imposeMaxLength(this);" style="width: 100%" readonly="true" /></td>
	</tr>
	<tr>
		<td width="263">L&#253; do ng&#432;&#7901;i t&#7889; c&#225;o bi&#7871;t h&#224;nh vi b&#7883; t&#7889; c&#225;o</td>
		<td colspan="3" width="1031"><html:textarea property="lyDoNtc" onkeypress="imposeMaxLength(this);" style="width: 100%" /></td>
	</tr>
	<tr>
		<td style="text-align: right;">C&#225;c n&#7897;i dung c&#7909; th&#7875; c&#7847;n x&#225;c minh</td>
		<td colspan="3"><html:textarea property="noiDungToCao" onkeypress="imposeMaxLength(this);" style="width: 100%;height:80px" /></td>
	</tr>
	<tr>
		<td width="263">&#221; ki&#7871;n kh&#225;c nhau trong &#273;o&#224;n(t&#7893;) x&#225;c minh</td>
		<td colspan="3" width="1031"><html:textarea property="kienKhacTrongDoan" onkeypress="imposeMaxLength(this);" style="width: 100%" /></td>
	</tr>
	<tr>
		<td width="263">C&#243; &#253; ki&#7871;n kh&#225;c nhau gi&#7919;a Tr&#432;&#7903;ng &#273;o&#224;n x&#225;c minh v&#224; Th&#7911; tr&#432;&#7903;ng &#273;&#417;n v&#7883; ch&#7911; tr&#236; x&#225;c minh</td>
		<td colspan="3" width="1031"><html:textarea property="kienTdTtcqt" onkeypress="imposeMaxLength(this);" style="width: 100%" /></td>
	</tr>
</table>
</fieldset>
