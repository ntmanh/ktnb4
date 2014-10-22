<%@ page pageEncoding="UTF-8"%>
<script language="Javascript">
$(function() 
{});
function save()
{
	saveObject();
}
function xuatDoc()
{
	exportDoc();
}
</script>
</div>
<TABLE width="100%" align="center" cellpadding="5">
		<logic:notPresent name="readOnly">
			<tr>
				<td width="50%" align="right">
					<input type="button" style="width: 60" class="button" name="BBDoiThoai" value='Kết xuất' onclick="xuatDoc();">
					<input type="button" style="width: 60" class="button" name="btnSave" value='<bean:message  key="luu"/>' onclick="save();">
				</td>
				<td width="50%" align="left">
					<input type="button" name="closetheForm" style="width: 60" class="button"value='<bean:message key="dong"/>' onclick="window.close();">
				</td>
			</tr>
		</logic:notPresent>
		<logic:present name="readOnly">
			<td width="100%" align="center"><input type="button"
				style="width: 60" class="button" name="btnSave"
				value='<bean:message  key="luu"/>' onclick="save();"
				disabled="disabled"> <input type="button"
				name="closetheForm" style="width: 60" class="button"
				value='<bean:message key="dong"/>' onclick="window.close();"></td>
		</logic:present>
	</TABLE>
</body>
</html>
<script language="Javascript">
// style js ui
//$(function(){
//	$.each($('[type="button"]'),function(index,value){
//		$(value).button();
//		$(value).css("font-size","11");
//	})
//})
</script>