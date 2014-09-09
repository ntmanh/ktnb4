<table width="100%">
	<tr align="right">
		<td align="right"><input type="button" style="width: 60"
			class="button" value='<bean:message key="luu"/>'
			onclick="save()"> <input type="button" style="width: 60"
			class="button" value='<bean:message  key="dong"/>'
			onclick="close()"></td>
	</tr>
</table>
<script language="javascript"> 
function close(){

}
function save(){
	if(!validateForm())
 			return;
 	action = document.forms[0].action;
 	action = action.split('?')[0];
 	document.forms[0].action += "?method=save";
 	document.forms[0].submit();		
}
</script>