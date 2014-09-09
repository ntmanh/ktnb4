<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">PHI&#7870;U H&#431;&#7898;NG D&#7850;N CHO NG&#431;&#7900;I KN - M&#7850;U S&#7888; 05/KNTC</h3>
<html:form action="/kntc_dxxl.do?method=phieuHdNkn">
	<html:hidden property="maHidden" />
	<html:hidden property="loaiPhieu" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red">S&#7889; h&#7891; s&#417;</font> <html:text property="maHoSo" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Th&#244;ng tin phi&#7871;u h&#432;&#7899;ng d&#7851;n</legend>
	<table width="100%">
		<tr>
			<td width="15%" style="text-align: right;">&#272;&#7883;a &#273;i&#7875;m</td>
			<td width="35%"><html:text property="diaDiem" style="width: 100%" /></td>
			<td width="15%" style="text-align: right;">Ng&#224;y l&#7853;p</td>
			<td width="35%"><html:text property="thoiDiem" style="width: 100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">S&#7889; phi&#7871;u</td>
			<td><html:text property="maPhieu" style="width: 100%" /></td>
			<td style="text-align: right;">C&#417; quan c&#243; th&#7849;m quy&#7873;n gi&#7843;i quy&#7871;t khi&#7871;u n&#7841;i</td>
			<td><html:text property="cqtGqTen" style="width: 100%" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">T&#243;m t&#7855;t n&#7897;i dung &#273;&#417;n</td>
			<td colspan="3"><html:textarea property="noiDungDon" onkeypress="imposeMaxLength(this);" style="width: 100%" readonly="true" /></td>
		</tr>
	</table>
	</fieldset>
	<jsp:include page="../../button_bar_kntc_mau_phu.jsp" />
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
	document.forms[0].action="kntc_dxxl.do?method=save";
	document.forms[0].submit();
}
function print(){		
		document.forms[0].action="kntc_dxxl.do?method=in";
		document.forms[0].submit();
	}
</script>
<%@ include file="/bottom.jsp"%>
