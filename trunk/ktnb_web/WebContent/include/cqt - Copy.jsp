<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<fieldset>
	<legend class="legend">Danh s&#225;ch C&#417; quan Thu&#7871;</legend>
	<div>	
   	 	<TABLE width="96%" border="0" >
			<tr class="TdHeaderList" align="center">
				<td width="20%">M&#227;</td>
				<td width="70%">T&#234;n</td>
				<td width="10%"><input id="ctrlCqtBox" name="selectAll" type="CHECKBOX" onclick="check(cqtCB,ctrlCqtBox);" /></td>
			</tr>
		</table>
		</div>
		<div style="overflow-y:scroll;height:140px;width:100%">
		<table width="100%" border="0">
			<logic:present name="cqts">
			<logic:iterate name="cqts" id="cqt" indexId="index">
			<tr align="center" class="row1">
				<td width="20%"><bean:write name="cqt" property="ma" /></td>
				<td width="70%" align="left"><bean:write name="cqt" property="ten" /></td>
				<td width="10%"><input id="cqtCB" name="selectCqt" type="CHECKBOX" value="<bean:write name="cqt" property="ma" />"  /></td>
			</tr>
			</logic:iterate>
		  </logic:present>
		</table>
	</div>
</fieldset>