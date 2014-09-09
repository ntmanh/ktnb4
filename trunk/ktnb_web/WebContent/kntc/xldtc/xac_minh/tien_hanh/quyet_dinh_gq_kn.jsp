<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Quy&#7871;t &#273;&#7883;nh gi&#7843;i quy&#7871;t KN - 19/KNTC</h3>
<html:form action="/kntc_qdgq.do?method=qdgq">
	<html:hidden property="maHidden" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red">S&#7889; h&#7891; s&#417;</font> <a href="chuaco.do" target="#"><html:text property="maHoSo" styleClass="text" style="width:250px" readonly="true" /></a></div>
	<br>
	<fieldset><legend>Th&#244;ng tin quy&#7871;t &#273;&#7883;nh</legend>
	<table width="100%">
		<tr>
			<td width="192">S&#7889; quy&#7871;t &#273;&#7883;nh <font color="Red">*</font></td>
			<td colspan="3"><html:text property="soQd" style="width: 100%" /></td>
		</tr>
		<tr>
			<td width="192">&#272;&#7883;a &#273;i&#7875;m <font color="Red">*</font></td>
			<td width="313"><html:text property="diaDiem" style="width: 100%" /></td>
			<td width="103">Ng&#224;y l&#7853;p <font color="Red">*</font></td>
			<td width="322"><html:text property="thoiDiem" style="width: 50%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td width="192">Quy&#7871;t &#273;&#7883;nh h&#224;nh ch&#237;nh, h&#224;nh vi h&#224;nh ch&#237;nh b&#7883; KN</td>
			<td colspan="3"><html:textarea property="noiDungViPham" style="width: 100%" onkeypress="imposeMaxLength(this);" /></td>
		</tr>
		<tr>
			<td width="192">T&#243;m t&#7855;t n&#7897;i dung &#273;&#417;n</td>
			<td colspan="3"><html:textarea property="noiDungDon" style="width: 100%" readonly="true" /></td>
		</tr>
		<tr>
			<td width="192">K&#7871;t qu&#7843; x&#225;c minh</td>
			<td colspan="3"><html:textarea property="ketQuaXm" style="width: 100%" readonly="true" /></td>
		</tr>
		<tr>
			<td width="192">C&#259;n c&#7913; theo <font color="Red">*</font></td>
			<td colspan="3"><html:textarea property="canCuTheo" style="width: 100%" onkeypress="imposeMaxLength(this);" /></td>
		</tr>
		<tr>
			<td width="192">K&#7871;t lu&#7853;n <font color="Red">*</font></td>
			<td colspan="3"><html:textarea property="ketLuan" style="width: 100%" onkeypress="imposeMaxLength(this);" /></td>
		</tr>
	</table>
	</fieldset>
	<fieldset><legend>Quy&#7871;t &#273;&#7883;nh</legend>
	<table width="100%">
		<tr>
			<td width="224">&#272;i&#7873;u 1</td>
			<td colspan="3" width="866"><html:textarea property="dieu1" style="width: 100%" onkeypress="imposeMaxLength(this);" /></td>
		</tr>
		<tr>
			<td width="224">&#272;i&#7873;u 2</td>
			<td colspan="3" width="866"><html:textarea property="dieu2" style="width: 100%" onkeypress="imposeMaxLength(this);" /></td>
		</tr>
		<tr>
			<td width="224">&#272;i&#7873;u 3</td>
			<td colspan="3" width="866">
			<table width="90%">
				<tr>
					<td width="190">Th&#7901;i h&#7841;n gi&#7843;i quy&#7871;t</td>
					<td width="310"><html:text property="dieu3ThoiHan" style="width: 60%" /> Ng&#224;y</td>
					<td width="110">Ng&#432;&#7901;i c&#243; th&#7849;m quy&#7873;n gi&#7843;i quy&#7871;t l&#7847;n hai</td>
					<td width="310"><html:text property="dieu3NguoiQgTen" style="width: 80%" /></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td width="224">&#272;i&#7873;u 4</td>
			<td colspan="3" width="866"><html:textarea property="dieu4" style="width: 100%" onkeypress="imposeMaxLength(this);" /></td>
		</tr>
	</Table>
	</fieldset>
	<br>
	<table width="100%">
		<tr>
			<td width="192">T&#224;i li&#7879;u b&#225;o c&#225;o k&#7871;t qu&#7843; gi&#7843;i quy&#7871;t KN</td>
			<td colspan="3"><A href="#" onclick="openUploadFile();">File "B&#225;o c&#225;o k&#7871;t qu&#7843; gi&#7843;i quy&#7871;t KN" &#273;&#237;nh k&#232;m</A></td>
		</tr>
	</table>
	<br>
	<jsp:include page="../../thong_tin_ky_duyet.jsp" />
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
function openUploadFile(){
	var view='';
	var method = '<%=request.getParameter("method")%>';
	if(method == 'view') view = 'view';
	var r = '<%=request.getParameter("r")%>';
	if(r == 'rol') view = 'view';
	
    var maHS = document.forms[0].maHoSo.value;
    if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+maHS+"&nv=KNTC/QDGQTC&view="+view);
	else
		alert("Ch\u01B0a c\u00F3 th\u00F4ng tin v\u1EC1 h\u1ED3 s\u01A1!");	
}
function ghi(){
	document.forms[0].action="kntc_qdgq.do?method=saveQdgq";
	document.forms[0].submit();
}
</script>
<%@ include file="/bottom.jsp"%>
