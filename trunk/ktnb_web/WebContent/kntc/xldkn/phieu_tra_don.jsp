<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">L&#7853;p phi&#7871;u tr&#7843; &#273;&#417;n KHI&#7870;U N&#7840;I - M&#7850;U S&#7888; 08/KNTC</h3>
<html:form action="/kntc_dxxl.do?method=phieuTd">
	<html:hidden property="maHidden" />
	<html:hidden property="loaiPhieu" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red">S&#7889; h&#7891; s&#417;</font> <html:text property="maHoSo" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Th&#244;ng tin phi&#7871;u</legend>
	<table width="100%">
		<tr>
			<td width="15%" style="text-align: right;">&#272;&#7883;a &#273;i&#7875;m</td>
			<td width="35%"><html:text property="diaDiem" style="width: 100%" /></td>
			<td width="15%" style="text-align: right;">Ng&#224;y l&#7853;p</td>
			<td width="322"><html:text property="thoiDiem" style="width: 100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">S&#7889; phi&#7871;u</td>
			<td width="35%"><html:text property="maPhieu" style="width: 100%" /></td>
			<td width="15%" style="text-align: right;">C&#417; quan, t&#7893; ch&#7913;c chuy&#7875;n &#273;&#417;n &#273;&#7871;n</td>
			<td width="35%"><html:hidden property="cqtGqMa" /> <html:text property="cqtGqTen" style="width: 100%" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">Ng&#224;y c&#244;ng v&#259;n &#273;&#7871;n</td>
			<td width="35%"><html:text property="congVanNgay" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			<td width="15%" style="text-align: right;">Theo d&#7845;u c&#244;ng v&#259;n &#273;&#7871;n</td>
			<td width="35%"><html:text property="congVanDenSo" style="width: 100%" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">&#272;&#417;n, c&#244;ng v&#259;n &#273;&#7873; ng&#224;y</td>
			<td width="35%"><html:text property="donCvDeNgay" style="width: 100%" /></td>
			<td width="15%" style="text-align: right;">&#272;&#417;n, c&#244;ng v&#259;n s&#7889;</td>
			<td width="35%"><html:text property="congVanSo" style="width: 100%" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">Ng&#432;&#7901;i, c&#417; quan, &#273;&#417;n v&#7883; KN</td>
			<td width="35%"><html:text property="nguoiCqDvKn" style="width: 100%" /></td>
			<td width="15%" style="text-align: right;">&#272;&#7883;a ch&#7881; ng&#432;&#7901;i, c&#417; quan, &#273;&#417;n v&#7883; KN</td>
			<td width="35%"><html:text property="diaChiCqDvKn" style="width: 100%" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">T&#243;m t&#7855;t n&#7897;i dung &#273;&#417;n</td>
			<td colspan="3"><html:textarea property="noiDungDon" style="width:100%;height:80px;" readonly="true" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">L&#253; do kh&#244;ng th&#7909; l&#253; gi&#7843;i quy&#7871;t</td>
			<td colspan="3"><html:textarea property="lyDo" onkeypress="imposeMaxLength(this);" style="width:100%;height:80px" /></td>
		</tr>
	</table>
	</fieldset>
	<jsp:include page="../../button_bar_kntc_mau_phu.jsp" />
</html:form>
<script type="text/javascript"> 
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
	//if(validForm()){
	document.forms[0].action="kntc_dxxl.do?method=save";
	document.forms[0].submit();
	//}
}

function validForm(){
	//if(!isRequired(document.forms[0].diaDiem,'Ch\u01B0a nh\u1EADp \u0111\u1ECBa \u0111i\u1EC3m'))return false;
	//if(!isRequired(document.forms[0].thoiDiem,'Ch\u01B0a nh\u1EADp ng\u00E0y l\u1EADp'))	return false;
	//if(!isRequired(document.forms[0].lyDo,'Ch\u01B0a nh\u1EADp l\u00FD do kh\u00F4ng th\u1EE5 l\u00FD'))
		//return false;	
	return true;	
}
function print(){		
		document.forms[0].action="kntc_dxxl.do?method=in";
		document.forms[0].submit();
	}
</script>
<%@ include file="/bottom.jsp"%>
