<%@ page pageEncoding="UTF-8"%>
<TABLE style="width:305px;border:1px solid #f1f1f1;padding:1px" >
	<tr class="TdHeaderList" align="center">
		<td width="20%"><input id="ctrlCqtBox" name="selectAll" type="CHECKBOX" onclick="check(cqtCB,ctrlCqtBox);"/></td>
		<td width="80%">Tên CQT</td>
	</tr>
</table>
<table style="width:305px;height:110px;display:block;overflow:auto;border:1px solid #f1f1f1;padding:1px">
	<logic:present name="cqts">
			<logic:iterate name="cqts" id="cqt" indexId="index">
			<tr align="center" class="row<%=(index.intValue() % 2)+1 %>">
				<td width="20%"><input id="cqtCB" name="selectCqt" type="CHECKBOX" onclick="checkUncheck(this);" value="<bean:write name="cqt" property="ma" />"  /></td>
				<td width="80%" align="left"><bean:write name="cqt" property="ten" /></td>					
			</tr>
			</logic:iterate>
	   </logic:present>	
</table>
<script type="text/javascript" charset="utf-8">  
function checkUncheck(control){
	if(!control.checked){
		document.getElementById("ctrlCqtBox").checked = false;
	}
}
</script>