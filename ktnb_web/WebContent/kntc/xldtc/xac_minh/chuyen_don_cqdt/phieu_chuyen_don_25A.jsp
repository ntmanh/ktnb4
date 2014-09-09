<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Phiếu chuyển sang cơ quan điều tra - Mẫu 25A/KNTC</h3>
<html:form action="/kntc_dxxl.do?method=chuyenDieuTra">
	<html:hidden property="maHidden" />
	<html:hidden property="loaiPhieu" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red"> Số hồ sơ</font> <html:text property="maHoSo" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Thông tin phiếu</legend>
	<table width="100%">
		<tr>
			<td width="15%" style="text-align: right;">Địa điểm<span style="color: red;">*</span></td>
			<td width="35%"><html:text property="diaDiem" style="width: 100%" /></td>
			<td width="15%" style="text-align: right;">Ngày lập<span style="color: red;">*</span></td>
			<td width="35%"><html:text property="thoiDiem" style="width:100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">Số phiếu</td>
			<td><html:text property="maPhieu" style="width: 100%" /></td>
			<td style="text-align: right;">Cơ quan có thẩm quyền giải quyết<font style="color: red;">*</font></td>
			<td><html:hidden property="cqtGqMa" /> <html:text property="cqtGqTen" style="width:100%" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">Tóm tắt hành vi vi phạm</td>
			<td colspan="3"><html:textarea property="hanhViViPham" onkeypress="imposeMaxLength(this);" style="width:100%;height:80px;" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">Hành vi có dấu hiệu tội phạm</td>
			<td colspan="3"><html:textarea property="dauHieuToiPham" onkeypress="imposeMaxLength(this);" style="width:100%;height:80px" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">Nơi nhận<span style="color: red;">*</span></td>
			<td><html:text property="noiNhan" style="width: 100%" /></td>
			<td style="text-align: right;">Số người liên quan<span style="color: red;">*</span></td>
			<td><html:text property="soNguoiLienQuan" style="width: 100%" /></td>
		</tr>
	</table>
	</fieldset>
	<br>
	<jsp:include page="../../../thong_tin_ky_duyet.jsp" />
	<jsp:include page="../../../../button_bar_kntc_mau_phu.jsp" />
</html:form>
<script type="text/javascript" charset="utf-8"> 
$(document).ready(function() {
    var ghiTC = "";
	 <logic:present name="ghiThanhcong">
	     	ghiTC = '<%=request.getAttribute("ghiThanhcong")%>';
	 </logic:present>
	 if(ghiTC=='1'){
		alert('Lưu thành công'); 
	 }
	 else  if(ghiTC=='0'){
		alert('Lỗi khi ghi dữ liệu!!!'); 
	 }  
	 <%request.removeAttribute("ghiThanhcong");%>
});
function print(){
	//if(validForm()) {
		document.forms[0].action="kntc_dxxl.do?method=in";
		document.forms[0].submit();
	//}
}

function ghi(){
	//if (validForm(){
	document.forms[0].action="kntc_dxxl.do?method=save";
	document.forms[0].submit();
	//}
}

function validForm(){
	if(!isRequired(document.forms[0].elements['diaDiem'], 'Chưa nhập địa điểm lập phiếu'))
		return false;
	if(!isRequired(document.forms[0].elements['thoiDiem'], 'Chưa nhập ngày nhập phiếu'))
		return false;
	if(!isRequired(document.forms[0].elements['cqtGqTen'], 'Chưa chọn cơ quan thuế có thẩm quyền giải quyết'))
		return false;
	return true;
}
</script>
<%@ include file="/bottom.jsp"%>
