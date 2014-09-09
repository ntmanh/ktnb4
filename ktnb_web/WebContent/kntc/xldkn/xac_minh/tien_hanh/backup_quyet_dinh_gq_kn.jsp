<%@ page pageEncoding="UTF-8"%>

<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Quyết định giải quyết KN - 19/KNTC</h3>
<html:form action="/kntc_kq_xm.do?method=qdgq">
	<html:hidden property="maHidden" />
	<html:hidden property="ketLuan" />
	<html:hidden property="dieu1" />
	<html:hidden property="dieu2" />
	<html:hidden property="dieu4" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red">Số hồ sơ</font> <html:text property="maHoSo" styleClass="text" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Thông tin quyết định</legend>
	<table width="100%">
		<tr>
			<td width="15%" align="right">Số quyết định</td>
			<td colspan="3"><html:text property="soQd" style="width: 150px" /></td>
		</tr>
		<tr>
			<td width="15%" align="right">Địa điểm</td>
			<td width="35%"><html:text property="diaDiem" style="width: 150px" /></td>
			<td width="15%" align="right">Ngày lập</td>
			<td width="35%"><html:text property="thoiDiem" style="width: 150px" onkeypress="return formatDate(event, this)" maxlength="10" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td width="15%" align="right">Quyết định hành chính, hành vi hành chính bị KN</td>
			<td colspan="3"><html:textarea property="noiDungViPham" style="width: 100%" rows="5" /></td>
		</tr>
		<tr>
			<td width="15%" align="right">Tóm tắt nội dung đơn</td>
			<td colspan="3"><html:textarea property="noiDungDon" style="width: 100%" rows="5" /></td>
		</tr>
		<tr>
			<td width="15%" align="right">Kết quả xác minh</td>
			<td colspan="3"><html:textarea property="ketQuaXm" style="width: 100%" rows="5" /></td>
		</tr>
		<tr>
			<td width="15%" align="right">Văn bản quy định chức năng, nhiệm vụ</td>
			<td colspan="3"><html:select property="vanBanQd" styleClass="combobox" style="width:100%">
				<html:options collection="dmtly" property="value" labelProperty="label" />
			</html:select></td>
		</tr>
	</table>
	</fieldset>
	<fieldset><legend>Kết luận</legend>
	<table width="100%">
		<tr>
			<td width="15%" align="right">Căn cứ pháp luật <font color="Red">*</font></td>
			<td colspan="3"><html:textarea property="canCuTheo" style="width: 100%" /></td>
		</tr>
		<tr>
			<td width="15%" align="right">Kết luận <font color="Red">*</font></td>
			<td colspan="3"><textarea id="ketLuanMCE" cols="80"></textarea></td>
		</tr>
	</table>
	</fieldset>
	<fieldset><legend>Quyết định</legend>
	<table width="100%">
		<tr>
			<td width="15%" align="right">Điều 1</td>
			<td colspan="3"><textarea id="dieu1MCE" cols="80"></textarea></td>
		</tr>
		<tr>
			<td width="15%" align="right">Điều 2</td>
			<td colspan="3"><textarea id="dieu2MCE" cols="80"></textarea></td>
		</tr>
		<tr>
			<td width="15%" align="right">Điều 3</td>
			<td colspan="3">
			<table width="100%">
				<tr>
					<td width="20%" align="right">Thời hạn giải quyết</td>
					<td width="30%"><html:text property="dieu3ThoiHan" style="width: 50px" /> Ngày</td>
					<td width="15%" align="right">Người có thẩm quyền giải quyết lần hai</td>
					<td width="35%"><html:text property="dieu3NguoiQgTen" style="width: 100%" /></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td width="15%" align="right">Điều 4</td>
			<td colspan="3"><textarea id="dieu4MCE" cols="80"></textarea></td>
		</tr>
	</Table>
	</fieldset>
	<br>
	<table width="100%">
		<tr>
			<td width="15%" align="right">Tài liệu QDGQ KN</td>
			<td colspan="3"><A href="#" onclick="openUploadFile();">File "Quyết định giải quyết KN" đính kèm</A></td>
		</tr>
	</table>
	<br>
	<jsp:include page="../../../thong_tin_ky_duyet.jsp" />
	<jsp:include page="../../../../button_bar_no_print.jsp" />
</html:form>
<script type="text/javascript" charset="utf-8"> 
bkLib.onDomLoaded(function() {
	new nicEditor({maxHeight : 200}).panelInstance('ketLuanMCE');
	new nicEditor({maxHeight : 200}).panelInstance('dieu1MCE');
	new nicEditor({maxHeight : 200}).panelInstance('dieu2MCE');
	new nicEditor({maxHeight : 200}).panelInstance('dieu4MCE');
});
$(document).ready(function() {
    var ghiTC = "";
	 <logic:present name="ghiThanhcong">
	     	ghiTC = '<%=request.getAttribute("ghiThanhcong")%>';
	 </logic:present>
	 if(ghiTC=='1')
	   alert('Lưu thành công'); 
	 else  if(ghiTC=='0')
	   alert('Lỗi khi ghi dữ liệu!!!');  
});

window.onload = function() {
	window.setTimeout("nicEditors.findEditor('ketLuanMCE').setContent(document.forms[0].ketLuan.value)",250);
	window.setTimeout("nicEditors.findEditor('dieu1MCE').setContent(document.forms[0].dieu1.value)",250);
	window.setTimeout("nicEditors.findEditor('dieu2MCE').setContent(document.forms[0].dieu2.value)",250);
	window.setTimeout("nicEditors.findEditor('dieu4MCE').setContent(document.forms[0].dieu4.value)",250);
}

function openUploadFile(){
    var maHS = document.forms[0].maHoSo.value;
    if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+maHS+"&nv=KNTC/QDGQ19");
	else
		alert("Chưa có thông tin về hồ sơ!");	
}
function ghi(){
	document.forms[0].ketLuan.value = nicEditors.findEditor('ketLuanMCE').getContent();
	document.forms[0].dieu1.value = nicEditors.findEditor('dieu1MCE').getContent();
	document.forms[0].dieu2.value = nicEditors.findEditor('dieu2MCE').getContent();
	document.forms[0].dieu4.value = nicEditors.findEditor('dieu4MCE').getContent();
	if(validForm()) {
		document.forms[0].action="kntc_kq_xm.do?method=saveQdgq";
		document.forms[0].submit();
	}
}
function print(){
	try{
	document.forms[0].ketLuan.value = nicEditors.findEditor('ketLuanMCE').getContent();
	document.forms[0].dieu1.value = nicEditors.findEditor('dieu1MCE').getContent();
	document.forms[0].dieu2.value = nicEditors.findEditor('dieu2MCE').getContent();
	document.forms[0].dieu4.value = nicEditors.findEditor('dieu4MCE').getContent();
	document.forms[0].action="kntc_kq_xm.do?method=inKntc19";
	document.forms[0].submit();
	}catch(e){alert(e)}
}
function validForm() {
	//if(!isRequired(document.forms[0].soQd,'Chưa nhập số quyết định')) return false;
	//if(!isRequired(document.forms[0].diaDiem,'Chưa nhập địa điểm')) return false;
	//if(!isRequired(document.forms[0].thoiDiem,'Chưa nhập ngày lập')) return false;
	if(!isRequired(document.forms[0].canCuTheo,'Chưa nhập căn cứ theo')) return false;
	if(!isRequired(document.forms[0].ketLuan,'Chưa nhập kết luận')) return false;
	return true;
}
</script>
<%@ include file="/bottom.jsp"%>
