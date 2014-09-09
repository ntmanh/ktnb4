<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">B&#225;o c&#225;o k&#7871;t qu&#7843; x&#225;c minh n&#7897;i dung KN - 17/KNTC</h3>
<html:form action="/kntc_xac_minh.do?method=bbKqXm">
	<html:hidden property="maHoSo" />
	<html:hidden property="maHidden" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red">S&#7889; quy&#7871;t &#273;&#7883;nh</font> <html:text property="soQd" styleClass="text" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Th&#244;ng tin quy&#7871;t &#273;&#7883;nh x&#225;c minh</legend>
	<table width="100%">
		<tr>
			<td width="15%" style="text-align: right;">&#272;&#7883;a &#273;i&#7875;m</td>
			<td width="35%"><html:text property="diaDiem" style="width:100%" /></td>
			<td width="15%" style="text-align: right;">Ng&#224;y l&#7853;p</td>
			<td width="35%"><html:text property="thoiDiem" style="width:100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">Quy&#7871;t &#273;&#7883;nh h&#224;nh ch&#237;nh, h&#224;nh vi h&#224;nh ch&#237;nh b&#7883; KN</td>
			<td colspan="3"><html:textarea property="noiDungViPham" onkeypress="imposeMaxLength(this);" style="width:100%;height:80px;" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">T&#243;m t&#7855;t n&#7897;i dung &#273;&#417;n</td>
			<td colspan="3"><html:textarea property="noiDungDon" style="width:100%;height:80px;" readonly="true" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">K&#7871;t qu&#7843; x&#225;c minh</td>
			<td colspan="3"><html:textarea property="ketQuaXm" onkeypress="imposeMaxLength(this);" style="width:100%;height:80px;" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">Ki&#7871;n ngh&#7883;</td>
			<td colspan="3"><html:textarea property="kienNghi" onkeypress="imposeMaxLength(this);" style="width:100%;height:80px;" /></td>
		</tr>
	</table>
	</fieldset>
	<br>
	<jsp:include page="../thong_tin_ky_duyet.jsp" />
	<jsp:include page="../../button_bar_no_print.jsp" />
</html:form>
<script type="text/javascript" charset="utf-8"> 
$(document).ready(function() {
    var ghiTC = "";
	 <logic:present name="ghiThanhcong">
	     	ghiTC = '<%=request.getAttribute("ghiThanhcong")%>';
	 </logic:present>
	 if(ghiTC=='1')
	   alert('L\u01B0u th\u00E0nh c\u00F4ng!'); 
	 else  if(ghiTC=='0')
	   alert('L\u1ED7i khi ghi d\u1EEF li\u1EC7u!!!');  
});

function ghi(){
	document.forms[0].action="kntc_xac_minh.do?method=saveBbKqXm";
	document.forms[0].submit();
}
</script>
<%@ include file="/bottom.jsp"%>
