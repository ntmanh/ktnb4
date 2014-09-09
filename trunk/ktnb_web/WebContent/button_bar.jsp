<%@ page pageEncoding="UTF-8"%>
<table width="100%">
	<tr align="center">
		<td align="center"><input type="button" id="btnKetXuat" class="button" value='K&#7871;t xu&#7845;t' name="in" onclick="print();"> <input type="button" class="button" value='L&#432;u' name="save" onclick="ghi();"> <!--<input type="button" class="button" value='X&#243;a' name="delete" onclick="del();">-->
		<input type="button" id="btnClose" class="button" value='&#272;&#243;ng' name="exit" onclick="window.history.back();"></td>
	</tr>
</table>
<script language="javascript">
	function close123(){
 		try{
 			selfClose();
 		}catch(err){  			
 			window.location = 'ttkt_index.do';
 		} 		
 	}
</script>