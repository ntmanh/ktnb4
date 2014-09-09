<%@ include file="/top_bar.jsp"%>
<logic:present name="khong_co_cuoc_kh">
	<script language="javascript">
	alert('Kh\u00F4ng th\u1EC3 duy\u1EC7t do ch\u01B0a c\u00F3 cu\u1ED9c Ki\u1EC3m tra n\u00E0o!');
	window.close();
</script>
</logic:present>
<%@page import="cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt"%>
<h3 class="Header">Duy&#x1EC7;t k&#x1EBF; ho&#x1EA1;ch n&#x103;m</h3>
<div><html:form action="duyet_ke_hoach.do" style="margin-right: 5px;">
	<table width="100%" align="center" cellspacing="5">
		<tr>
			<td align="right" width="19%">N&#x1A1;i k&#xFD; tr&#xEC;nh</td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="noiKyTrinh" style="width: 100%">
			</html:text></td>
			<td align="right" width="19%">Ng&#xE0;y k&#xFD; tr&#xEC;nh</td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%"><html:text styleClass="text" onblur="if(!isDate(this)) return;" onkeypress="return formatDate(event,this);" property="ngayKyTrinh" style="width: 100%">
			</html:text></td>
		</tr>
		<tr>
			<td align="right" width="19%">N&#x1A1;i ph&#xEA; duy&#x1EC7;t <font color=red>*</font></td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="noiPheDuyet" style="width: 100%">
			</html:text></td>
			<td align="right" width="19%">Ng&#xE0;y ph&#xEA; duy&#x1EC7;t <font color=red>*</font></td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="ngayPheDuyet" onblur="if(!isDate(this)) return;" onkeypress="return formatDate(event,this);" style="width: 100%">
			</html:text></td>
		</tr>
		<tr>
			<td align="right" width="19%">&#xDD; ki&#x1EBF;n ph&#xEA; duy&#x1EC7;t</td>
			<td align="right" width="1%"></td>
			<td align="left" colspan="4"><html:textarea property="ykienPheDuyet" onkeypress="imposeMaxLength(this);"  style="width: 100%">
			</html:textarea></td>
		</tr>
	</table>
	<html:hidden property="id" />
	<html:hidden property="keHoachNam" />
</html:form></div>
<div style="text-align: center;"><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></div>
<%@ include file="/bottom.jsp"%>
<script language="javascript">
$(function(){
	if($('[name="id"]')[0].value!=null&&$('[name="id"]')[0].value!=""&&$('[name="id"]')[0].value!="null"&&$('[name="id"]')[0].value!=" "){
		$($('[name="btnSave"]')[0]).attr("disabled", "disabled");
	}
})
function validateForm(){			
	if(!isRequired(document.getElementsByName('noiPheDuyet')[0]))
		return false;
	if(!isRequired(document.getElementsByName('ngayPheDuyet')[0]))
		return false;
	if(!compareDate(document.getElementsByName('ngayKyTrinh')[0], document.getElementsByName('ngayPheDuyet')[0], 'Ng\u00E0y ph\u00EA duy\u1EC7t ph\u1EA3i l\u1EDBn h\u01A1n ho\u1EB7c b\u1EB1ng ng\u00E0y k\u00FD tr\u00ECnh')){
		document.getElementsByName('ngayPheDuyet')[0].focus();
		return false;
	}
	if (!confirm("Sau khi duy\u1EC7t s\u1EBD kh\u00F4ng \u0111\u01B0\u1EE3c s\u1EEDa \u0111\u1ED5i k\u1EBF ho\u1EA1ch n\u0103m!"))
		return false;
	return true;
}
function selfClose(){
	
	window.close();
}
</script>
<%
	if(request.getAttribute("save") != null){%>
<script language="javascript">
		alert('L\u01B0u th\u00E0nh c\u00F4ng!');
		window.opener.duyet();
		selfClose();
	</script>
<%}	
%>
