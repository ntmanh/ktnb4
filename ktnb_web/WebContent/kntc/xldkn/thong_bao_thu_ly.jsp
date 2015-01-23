<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">L&#7852;P TH&#212;NG B&#193;O TH&#7908; L&#221;</h3>
<html:form action="/kntc_dxxl.do?method=thongBaoThuLy">
	<html:hidden property="maHidden" />
	<html:hidden property="loaiPhieu" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red">S&#7889; h&#7891; s&#417;</font> <html:text property="maHoSo" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Th&#244;ng tin chung</legend>
	<table width="100%">
		<tr>
			<td width="15%" style="text-align: right">&#272;&#7883;a &#273;i&#7875;m</td>
			<td width="35%"><html:text property="diaDiem" style="width: 100%" /></td>
			<td width="15%" style="text-align: right">Ng&#224;y l&#7853;p</td>
			<td width="35%"><html:text property="thoiDiem" style="width: 100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td style="text-align: right">S&#7889; th&#244;ng b&#225;o</td>
			<td><html:text property="maPhieu" style="width: 100%" /></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td style="text-align: right">T&#243;m t&#7855;t n&#7897;i dung v&#7909; vi&#7879;c</td>
			<td colspan="3"><html:textarea property="noiDungDon" onkeypress="imposeMaxLength(this);" rows="5" style="width: 100%" /></td>
		</tr>
		<tr>
			<td style="text-align: right">&#272;&#417;n v&#7883;, c&#225; nh&#226;n c&#243; th&#226;m quy&#7873;n chuy&#7875;n khi&#7871;u n&#7841;i &#273;&#7871;n</td>
			<td><html:text property="donViCoThamQuyenChuyenDen" style="width: 100%" /></td>
			<td></td>
			<td></td>
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
