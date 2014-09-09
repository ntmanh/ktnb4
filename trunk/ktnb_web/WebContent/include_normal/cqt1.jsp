<%@ page pageEncoding="UTF-8"%>
<table style="width:305px;height:120px;display:block;overflow:auto;border:1px solid #f1f1f1;padding:1px">
	<logic:present name="cqts">
			<logic:iterate name="cqts" id="cqt" indexId="index">
			<tr align="center" class="row<%=(index.intValue() % 2)+1 %>">
				<td width="20%"><input id="cqtCB" name="selectCqt" type="CHECKBOX" value="<bean:write name="cqt" property="ma" />"  /></td>
				<td width="80%" align="left"><bean:write name="cqt" property="ten" /></td>					
			</tr>
			</logic:iterate>
	   </logic:present>	
</table>