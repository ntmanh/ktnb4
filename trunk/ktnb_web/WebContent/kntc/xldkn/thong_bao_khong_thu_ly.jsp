<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">L&#7852;P TH&#212;NG B&#193;O KH&#212;NG TH&#7908; L&#221; KHI&#7870;U N&#7840;I - M&#7850;U S&#7888; 04/KN</h3>
<html:form action="/kntc_dxxl.do?method=thongBaoKThuLy">
	<html:hidden property="maHidden" />
	<html:hidden property="loaiPhieu" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red">S&#7889; h&#7891; s&#417;</font> <html:text property="maHoSo" style="width:250px" readonly="true" /></a></div>
	<br>
	<fieldset><legend>Th&#244;ng tin chung</legend>
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
			<td style="text-align: right;">C&#417; quan, t&#7893; ch&#7913;c chuy&#7875;n &#273;&#417;n &#273;&#7871;n</td>
			<td><html:text property="cqtGqTen" style="width: 100%" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">C&#259;n c&#7913;</td>
			<td colspan="3"><html:textarea property="canCuQuyetDinh" onkeypress="imposeMaxLength(this);" style="width: 100%" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">L&#253; do kh&#244;ng th&#7909; l&#253; gi&#7843;i quy&#7871;t</td>
			<td colspan="3"><html:textarea property="lyDo" onkeypress="imposeMaxLength(this);" style="width: 100%" /></td>
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
