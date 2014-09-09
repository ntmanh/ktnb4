<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar_tab.jsp"%>
<html:form action="kntc_bckqth.do">
	<html:hidden property="ma" />
	<html:hidden property="maHs" />
	<table>
		<tr>
			<td width="20%" align="right">Ngày nhập báo cáo<font color="red">*</font></td>
			<td width="30%"><html:text property="ngayNhanBckq" style="width: 150px" onkeypress="return formatDate(event, this)" maxlength="10" onblur="isDate(this)" /></td>
			<td align="right">Kết thúc theo dõi thi hành</td>
			<td><html:checkbox value="1" property="ketThucTdoiThiHanh" /></td>
		</tr>
	</table>
	<fieldset style="width: 760px"><legend>Dữ liệu chuyển báo cáo</legend>
	<table>
		<tr>
			<td colspan="4"><b>Kiến nghị thu hồi cho nhà nước</b></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right">Tiền</td>
			<td width="35%"><html:text property="soTienKnghiThuHoi" style="width: 150px" onblur="isNumber(this,'i');"/>(nghìn đồng)</td>
			<td width="15%" style="text-align: right">Tài sản khác</td>
			<td width="35%"><html:text property="taiSanKhacKnghiThuHoi" style="width: 150px" onblur="isNumber(this,'i');"/>(nghìn đồng)</td>
		</tr>
		<tr>
			<td colspan="4"><b>Trả lại cho công dân</b></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right">Tiền</td>
			<td width="35%"><html:text property="soTienTraCdan" style="width: 150px" onblur="isNumber(this,'i');"/>(nghìn đồng)</td>
			<td width="15%" style="text-align: right">Tài sản khác</td>
			<td width="35%"><html:text property="taiSanKhacTraCdan" style="width: 150px" onblur="isNumber(this,'i');"/>(nghìn đồng)</td>
		</tr>
		<tr>
			<td colspan="4"><b>Thông tin khác</b></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right">Số người, đơn vị được trả lại quyền lợi</td>
			<td width="35%"><html:text property="soNknHoanTra" style="width: 150px" onblur="isNumber(this,'i');"/>(người)</td>
			<td width="15%" style="text-align: right">Số tiền được hoàn trả</td>
			<td width="35%"><html:text property="soTienHoanTraNkn" style="width: 150px" onblur="isNumber(this,'i');"/>(nghìn đồng)</td>
		</tr>
		<tr>
			<td width="15%">Kiến nghị xử lý hành chính</td>
			<td width="35%"><html:text property="soNguoiXlhc" style="width: 150px" onblur="isNumber(this,'i');"/>(người)</td>
			<td width="15%" style="text-align: right">Số người chuyển CQĐT</td>
			<td width="35%"><html:text property="soNguoiChuyenCqDtra" style="width: 150px" onblur="isNumber(this,'i');"/>(người)</td>			
		</tr>
	</table>
	</fieldset>

	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" class="button" value='Lưu' name="saveQd" onclick="ghi_baocaothihanh();"> 
			<input type="button" id="btnClose3" class="button" value='Đóng' name="exit" onclick="goHomeKntc();"></td>
		</tr>
	</table>
</html:form>
<script type="text/javascript" charset="utf-8"> 
$(document).ready(function() {
    var ghiTC2 = "";
	 <logic:present name="ghiThanhcong2">
	     	ghiTC2 = '<%=request.getAttribute("ghiThanhcong2")%>';
	 </logic:present>
	 if(ghiTC2=='1'){
		alert('Lưu thành công'); 
	 }
	 else  if(ghiTC2=='0'){
		alert('Lỗi khi ghi dữ liệu!!!'); 
	 }  
	 <%request.removeAttribute("ghiThanhcong2");%>
});

function ghi_baocaothihanh(){
	if(validForm_2()){
		var maHS = document.getElementsByName("maHs")[0].value;
		document.forms[2].action="kntc_bckqth.do?method=saveBaoCaoThiHanhKhieuNai&id="+maHS;
		document.forms[2].submit();	
	}
}

function validForm_2() {
	if(!isRequired(document.forms[2].ngayNhanBckq,'Cần nhập ngày nhập báo cáo')) return false;
	return true;
}
</script>
</div>
</div>
</body>
</html>
