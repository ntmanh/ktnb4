<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Phân loại hồ sơ Khiếu Nại Tố Cáo</h3>
<html:form action="/phan_loai_don.do">
	<html:hidden property="maDeXuat" />
	<div style="text-align: center; width: 100%"><font
		style="font-size: 14px; color: red"> Số hồ sơ</font> <html:text
		property="maHoSo" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Chọn xử lý</legend> Chọn thẩm quyền <html:select
		property="thamQuyen" style="width:100%;"
		onchange="changeLoaiHs(this.value);">
		<html:option value="0">Chọn thẩm quyền</html:option>
		<html:optionsCollection property="thamQuyenList" label="label" value="value" />
	</html:select> <br />
	Chọn trường hợp cụ thể <html:select property="thuLy"
		style="width:100%;">
		<html:option value="0">Chọn trường hợp cụ thể</html:option>
		<html:optionsCollection property="thuLyList" label="label"
			value="value" />
	</html:select> <font style="font-size: 14px; color: red">Hồ sơ quá hạn</font> <html:radio
		property="quaHan" value="1">Có</html:radio> <html:radio
		property="quaHan" value="0">Không </html:radio></fieldset>
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" class="button"
				value='Ghi thông tin phân loại' name="save" onclick="doSave();">
			<!--<input type="button"  class="button" value='Đóng' name="close" onclick="history.go(-1);return false;">--></td>
		</tr>
	</table>
	<fieldset><legend>Các biểu mẫu cần lập</legend>
	<table border="1" width="100%">
		<tr>
			<td width="25">STT</td>
			<td>Biểu mẫu</td>
		</tr>
		<logic:present name="bm">
			<logic:iterate id="aBm" name="bm" indexId="idx">
				<tr>
					<td><%=idx.intValue() + 1%></td>
					<td><a href="#"
						onclick="openBm('<bean:write name="aBm" property="url" /><%="&action=" + request.getParameter("action")%><%="&r=" + request.getParameter("r")%>');">
					<bean:write name="aBm" property="name" /> </a></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</fieldset>
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" class="button"
				value='Đóng' name="close2" onclick="goHomeKntc();"></td>
		</tr>
	</table>
</html:form>
<script type="text/javascript" charset="utf-8">  
$(document).ready(function(){
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
//function change value of second combobox
function addCombo() {
    var textb = document.getElementById("txtCombo");
    var combo = document.getElementById("combo");
    var option = document.createElement("option");
    option.text = textb.value;
    option.value = textb.value;
    try {
        combo.add(option, null); //Standard
    }catch(error) {
        combo.add(option); // IE only
    }
    textb.value = "";
}
//Change loai ho so
function changeLoaiHs(loai){	
	var maHS = document.forms[0].maHoSo.value;
	var action = '<%="&action=" + request.getParameter("action")%>';
	document.forms[0].action="phan_loai_don.do?method=show&id="+maHS+"&thamquyen="+loai+action;
	document.forms[0].submit();
}
function openBm(link){
	openWindow(link,screen.width,screen.height,false);
}
function doSave(){
	var maHS = document.forms[0].maHoSo.value;
	var action = '<%="&action=" + request.getParameter("action")%>';
	//alert(action);
	document.forms[0].action="phan_loai_don.do?method=saveLoaiHoSo&id="+maHS+action;
	document.forms[0].submit();
}
</script>
<%@ include file="/bottom.jsp"%>
