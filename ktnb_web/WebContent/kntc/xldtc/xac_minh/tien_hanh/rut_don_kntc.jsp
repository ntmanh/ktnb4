<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">TH&#212;NG TIN R&#218;T &#272;&#416;N</h3>
<html:form action="/kntc_qdgq.do?method=rutdon">
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red">S&#7889; h&#7891; s&#417;</font> <a href="chuaco.do" target="#"><html:text property="maHoSo" styleClass="text" style="width:250px" readonly="true" /></a></div>
	<br>
	<fieldset><legend>Th&#244;ng tin r&#250;t &#273;&#417;n</legend>
	<table width="100%">
		<tr>
			<td width="192">Ng&#224;y r&#250;t &#273;&#417;n <font color="Red">*</font></td>
			<td width="313"><html:text property="thoiDiem" style="width: 50%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			<td width="103"></td>
			<td width="322"></td>
		</tr>
		<tr>
			<td width="192">L&#253; do r&#250;t &#273;&#417;n <font color="Red">*</font></td>
			<td colspan="3"><html:textarea property="noiDungDon" style="width: 100%" onkeypress="imposeMaxLength(this);" /></td>
		</tr>
	</table>
	</fieldset>
	<br>
	<jsp:include page="../../../button_bar_kntc.jsp" />
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
	document.forms[0].action="kntc_qdgq.do?method=saveRutdon";
	document.forms[0].submit();
}
</script>
<%@ include file="/bottom.jsp"%>
