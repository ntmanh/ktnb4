<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Báo cáo kết quả giải quyết KN - 18/KNTC</h3>
<html:form action="/kntc_kq_xm.do?method=baocao">
	<html:hidden property="maHoSo" />
	<html:hidden property="maHidden" />
	<html:hidden property="ketQuaXm" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red">Số quyết định</font> <html:text property="soQd" styleClass="text" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Thông tin kết quả giải quyết</legend>
	<table width="100%">
		<tr>
			<td width="15%" align="right">Địa điểm</td>
			<td width="35%"><html:text property="diaDiem" style="width: 100%" /></td>
			<td width="15%" align="right">Ngày lập</td>
			<td width="35%"><html:text property="thoiDiem" style="width: 100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td align="right">Thời gian giải quyết từ ngày</td>
			<td><html:text property="tuNgay" style="width: 100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			<td align="right">đến ngày</td>
			<td><html:text property="denNgay" style="width: 100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td align="right">Quyết định hành chính, hành vi hành chính bị KN</td>
			<td colspan="3"><html:textarea property="noiDungViPham" style="width: 100%" rows="5" /></td>
		</tr>
		<tr>
			<td align="right">Tóm tắt nội dung vụ việc, quá trình giải quyết</td>
			<td colspan="3"><html:textarea property="noiDungDon" style="width: 100%" rows="5" readonly="true" /></td>
		</tr>
		<tr>
			<td align="right">Kết quả và Kiến nghị<font style="color: red">*</font></td>
			<td colspan="3"><textarea id="ketQuaXmMCE" cols="80"></textarea></td>
		</tr>
	</table>
	</fieldset>
	<fieldset><legend>Thông tin báo cáo</legend>
	<table width="100%">
		<tr>
			<td align="right">Phân tích kết quả</td>
			<td colspan="3"><html:radio property="phanTichKq" value="1" />Đúng <html:radio property="phanTichKq" value="0" />Sai <html:radio property="phanTichKq" value="2" />Có đúng, có sai</td>
		</tr>
		<tr>
			<td width="15%" align="right">Xử lý hành chính</td>
			<td width="35%"><html:text property="xlySoNguoi" maxlength="2" style="width: 85%" onblur="isNumber(this,'i');" />người</td>
			<td width="15%" align="right">Số người, đơn vị được trả lại quyền lợi</td>
			<td width="35%"><html:text property="denBuSoNguoi" maxlength="2" style="width: 85%" onblur="isNumber(this,'i');" />người</td>
		</tr>
		<tr>
			<td align="right">Biện pháp khác phục hậu quả</td>
			<td colspan="3"><html:textarea property="xlyHinhThuc" style="width: 100%" /></td>
		</tr>
	</Table>
	<fieldset><legend>Kiến nghị thu hồi cho nhà nước</legend>
	<table width="100%">
		<tr>
			<td width="15%" align="right">Tiền</td>
			<td width="35%"><html:text property="knthNnSoTien" style="width: 85%" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" />VNĐ</td>
			<td width="15%" align="right">Đất</td>
			<td width="35%"><html:text property="knthNnDat" style="width: 85%" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" />m2</td>
		</tr>
		<tr>
			<td align="right">Loại khác</td>
			<td><html:textarea property="knthNnLoai" style="width: 85%" /></td>
			<td align="right">Trị giá</td>
			<td><html:text property="knthNnTriGia" style="width: 85%" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" />VNĐ</td>
		</tr>
	</table>
	</fieldset>
	<fieldset><legend>Hoàn trả cho công dân</legend>
	<table width="100%">
		<tr>
			<td width="15%" align="right">Tiền</td>
			<td width="35%"><html:text property="htcdTien" style="width: 85%" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" /> VNĐ</td>
			<td width="15%" align="right">Đất</td>
			<td width="35%"><html:text property="htcdDat" style="width: 85%" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" />m2</td>
		</tr>
		<tr>
			<td align="right">Loại khác</td>
			<td><html:textarea property="htcdLoai" style="width: 85%" /></td>
			<td align="right">Trị giá</td>
			<td><html:text property="htcdTriGia" style="width: 85%" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" />VNĐ</td>
		</tr>
	</table>
	</fieldset>
	<br>
	<table width="100%">
		<tr>
			<td width="15%" align="right">Tài liệu báo cáo KQGQ</td>
			<td colspan="3"><A href="#" onclick="openUploadFile();">File "Báo cáo kết quả giải quyết KN" đính kèm</A></td>
		</tr>
	</table>
	</fieldset>
	<br>
	<jsp:include page="../../../thong_tin_ky_duyet.jsp" />
	<jsp:include page="../../../../button_bar_no_print.jsp" />
</html:form>
<script type="text/javascript" charset="utf-8"> 
bkLib.onDomLoaded(function() {
	new nicEditor({maxHeight : 200}).panelInstance('ketQuaXmMCE');
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
	window.setTimeout("nicEditors.findEditor('ketQuaXmMCE').setContent(document.forms[0].ketQuaXm.value)",250);
}
function openUploadFile(){
    var maHS = document.forms[0].maHoSo.value;
    if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+maHS+"&nv=KNTC/BCKQXM18");
	else
		alert("Chưa có thông tin về hồ sơ!");	
}
function print(){
	document.forms[0].ketQuaXm.value = nicEditors.findEditor('ketQuaXmMCE').getContent();
	document.forms[0].action="kntc_kq_xm.do?method=in";
	document.forms[0].submit();
}
function ghi(){
	document.forms[0].ketQuaXm.value = nicEditors.findEditor('ketQuaXmMCE').getContent();
	if(validForm()) {
		document.forms[0].action="kntc_kq_xm.do?method=saveBaoCao";
		document.forms[0].submit();
	}
}

function validForm() {
	//if(!isRequired(document.forms[0].diaDiem,'Chưa nhập địa điểm')) return false;
	//if(!isRequired(document.forms[0].thoiDiem,'Chưa nhập ngày lập')) return false;
	if(!isRequired(document.forms[0].ketQuaXm,'Chưa nhập kết quả xác minh')) {
		document.forms[0].ketQuaXmMCE.focus();
		return false;
	}
	return true;
}
</script>
<%@ include file="/bottom.jsp"%>
