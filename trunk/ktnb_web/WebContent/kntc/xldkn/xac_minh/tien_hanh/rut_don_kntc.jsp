<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">THÔNG TIN XỬ LÝ ĐƠN</h3>
<html:form action="/kntc_qdgq.do?method=rutdon">
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red">Số hồ sơ</font> <html:text property="maHoSo" styleClass="text" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Thông tin xử lý</legend>
	<table width="100%">
		<tr>
			<td width="15%" style="text-align: right;">Ngày thực hiện <font color="Red">*</font></td>
			<td width="35%"><html:text property="thoiDiem" style="width:100%" onkeypress="return formatDate(event, this)" maxlength="10" onblur="isDate(this)" /></td>
			<td width="15%" style="text-align: right;"></td>
			<td width="35%"></td>
		</tr>
		<tr>
			<td style="text-align: right">Lý do <font color="Red">*</font></td>
			<td colspan="3"><html:textarea property="noiDungDon" onkeypress="imposeMaxLength(this);" style="width: 100%;height:80px" /></td>
		</tr>
	</table>
	</fieldset>
	<jsp:include page="../../../thong_tin_ky_duyet.jsp" />
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" class="button" value='Lưu' name="save" onclick="ghi();"> 
			<input type="button" class="button" value='Đóng' name="exit" onclick="window.close();"></td>
		</tr>
	</table>
</html:form>
<script type="text/javascript" charset="utf-8"> 
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

function ghi(){
	if(validForm()) {
		document.forms[0].action="kntc_qdgq.do?method=saveRutdon";
		document.forms[0].submit();
	}
}

function validForm() {
	if(!isRequired(document.forms[0].thoiDiem,'Chưa nhập ngày xử lý đơn')) return false;
	if(!isRequired(document.forms[0].noiDungDon,'Chưa nhập lý do xử lý đơn')) return false;
	return true;
}
</script>
<%@ include file="/bottom.jsp"%>
