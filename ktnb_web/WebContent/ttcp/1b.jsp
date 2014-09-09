<%@page pageEncoding="UTF-8"%>    
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">BÁO CÁO CÔNG TÁC QUẢN LÝ NHÀ NƯỚC VỀ KIỂM TRA NỘI BỘ 1B/KNTC</h3>
<html:form action="/bc1b.do?method=show">
	<html:hidden property="maCqt" />	
	<html:hidden property="ngayCuoiThang" />
	<table>
	<tr>
		<td colspan="4" style="background-color:#CCE7FC"><b>Chọn thời điểm xem số liệu</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">&nbsp</td>
		<td width="30%">
			Năm <html:text property="nam" style="width:50px" onchange="search();"/> 
			Tháng <html:select property="thang" style="width:50px" styleId="thang" onchange="search();">
					<html:option value="1">1</html:option>
					<html:option value="2">2</html:option>
					<html:option value="3">3</html:option>
					<html:option value="4">4</html:option>
					<html:option value="5">5</html:option>
					<html:option value="6">6</html:option>
					<html:option value="7">7</html:option>
					<html:option value="8">8</html:option>
					<html:option value="9">9</html:option>
					<html:option value="10">10</html:option>
					<html:option value="11">11</html:option>
					<html:option value="12">12</html:option>
				</html:select>
			<!-- <input type="button" value="Xem" id="btnSearch" onclick="search();"/> -->
		</td>
		<td width="20%" style="text-align: right;">&nbsp</td>
		<td width="30%">&nbsp</td>		
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Ban hành văn bản quản lý, chỉ đạo (Bộ, ngành, tỉnh, TP) về công tác kiểm tra nội bộ</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số văn bản ban hành mới</td>
		<td width="30%"><html:text property="vbBhMoi" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Số văn bản được sửa đổi, bổ sung</td>
		<td width="30%"><html:text property="vbBhBoSung" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Tập huấn, tuyên truyền, giáo dục pháp luật về thanh tra cho cán bộ, công chức, viên chức, nhân dân</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số lớp tập huấn pháp luật về kiểm tra nội bộ</td>
		<td width="30%"><html:text property="thKtnbLop" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Số người tập huấn pháp luật về kiểm tra nội bộ</td>
		<td width="30%"><html:text property="thKtnbNg" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số lớp tập huấn pháp luật về kiểm tra nội bộ, KNTC, PCTN</td>
		<td width="30%"><html:text property="thKntcLop" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Số người tập huấn pháp luật về kiểm tra nội bộ, KNTC, PCTN</td>
		<td width="30%"><html:text property="thKntcNg" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Kiểm tra nội bộ về nội dung</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số cuộc thanh tra, kiểm tra</td>
		<td width="30%"><html:text property="ndTtktSoCuoc" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Số đơn vị thanh tra, kiểm tra</td>
		<td width="30%"><html:text property="ndTtktSoDv" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số cuộc thanh tra, kiểm tra, KNTC, PCTN</td>
		<td width="30%"><html:text property="ndKntcSoCuoc" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Số đơn vị thanh tra, kiểm tra, KNTC, PCTN</td>
		<td width="30%"><html:text property="ndKntcSoDv" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số đơn vị có vi phạm</td>
		<td width="30%"><html:text property="ndDvViPham" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Kiến nghị xử lý kiểm điểm, rút kinh nghiệm(Số người)</td>
		<td width="30%"><html:text property="ndXlySoNg" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số vụ kiến nghị xử lý hành chính</td>
		<td width="30%"><html:text property="ndXlyHcSoVu" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Số người kiến nghị xử lý hành chính</td>
		<td width="30%"><html:text property="ndXlyHcSoNg" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Kiểm tra việc thực hiện kết luận KTNB</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Tổng số KLKTNB đã kiểm tra</td>
		<td width="30%"><html:text property="thTongSo" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Kết quả kiểm tra đã kiểm điểm, rút kinh nghiệm</td>
		<td width="30%"><html:text property="thKqKd" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Kết quả kiểm tra số vụ đã xử lý hành chính</td>
		<td width="30%"><html:text property="thKqHcVu" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Kết quả kiểm tra số người đã xử lý hành chính</td>
		<td width="30%"><html:text property="thKqHcNg" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">&nbsp</td>
		<td width="30%">
			<input type="button" value="Lưu số liệu" id="btnSearch" onclick="save();"/>
			<input type="button"  value='Đóng' onclick="goHomeTTCP();">
		</td>
		<td width="20%" style="text-align: right;">&nbsp</td>
		<td width="30%">&nbsp</td>		
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
function search(){	
	document.forms[0].action='bc1b.do?method=show';
	document.forms[0].submit();
}
function save(){
	document.forms[0].action="bc1b.do?method=save";
	document.forms[0].submit();
}
</script>
<%@ include file="/bottom.jsp"%>