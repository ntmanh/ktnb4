<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Quy&#7871;t &#273;&#7883;nh gia h&#7841;n th&#7901;i gian x&#225;c minh - M&#7851;u 16/KNTC</h3>
<html:form action="/kntc_xac_minh.do?method=show">
	<html:hidden property="maHoSo" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red"> S&#7889; h&#7891; s&#417;</font> <html:text property="maHoSo" styleClass="text" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Th&#244;ng tin quy&#7871;t &#273;&#7883;nh x&#225;c minh</legend>
	<table width="100%">
		<tr>
			<td width="15%">&#272;&#7883;a &#273;i&#7875;m</td>
			<td width="35%"><html:text property="diaDiem" /></td>
			<td width="15%">Ng&#224;y ra quy&#7871;t &#273;&#7883;nh</td>
			<td width="35%"><html:text property="thoiDiem" /></td>
		</tr>
		<tr>
			<td>S&#7889; quy&#7871;t &#273;&#7883;nh</td>
			<td><html:text property="soQd" /></td>
			<td>C&#259;n c&#7913; v&#259;n b&#7843;n</td>
			<td><html:text property="canCuVanBan" /></td>
		</tr>
		<tr>
			<td>Th&#7901;i gian x&#225;c minh</td>
			<td colspan="3"><html:text property="thoiGian" onblur="isNumber(this);" />Ng&#224;y (K&#7875; t&#7915; ng&#224;y c&#244;ng b&#7889; quy&#7871;t &#273;&#7883;nh)</td>
		</tr>
		<tr>
			<td>Th&#224;nh vi&#234;n &#273;o&#224;n</td>
			<td colspan="3"><a href="#" onclick="openDanhSachTvd();">Danh s&#225;ch Th&#224;nh vi&#234;n &#273;o&#224;n</a></td>
		</tr>
		<tr>
			<td>N&#7897;i dung x&#225;c minh</td>
			<td colspan="3"><html:textarea property="noidung" onkeypress="imposeMaxLength(this);"/></td>
		</tr>
		<tr>
			<td>C&#225;c b&#234;n li&#234;n quan</td>
			<td colspan="3"><html:textarea property="benLienQuan" onkeypress="imposeMaxLength(this);"/></td>
		</tr>
		<tr>
			<td>Th&#7911; tr&#432;&#7903;ng c&#225;c b&#234;n li&#234;n quan</td>
			<td colspan="3"><html:textarea property="benLienQuanThuTruong" onkeypress="imposeMaxLength(this);"/></td>
		</tr>
	</table>
	</fieldset>
	<jsp:include page="../../../thong_tin_ky_duyet.jsp" />
	<jsp:include page="../../../../button_bar_kntc.jsp" />
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
function openDanhSachTvd()
{
    var maHS = document.forms[0].maHoSo.value;
	if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("kntc_phan_cong_can_bo.do?method=tvd&parentId="+maHS,800,600);
	else
		alert("Ch\u01B0a c\u00F3 th\u00F4ng tin v\u1EC1 h\u1ED3 s\u01A1!");	
} 
function ghi(){
	document.forms[0].action="kntc_xac_minh.do?method=save";
	document.forms[0].submit();
}
function print(){
   document.forms[0].action="kntc_xm_phieu_yc.do?method=in&type=15B/KTNB";
		document.forms[0].submit();
}
</script>
<%@ include file="/bottom.jsp"%>
