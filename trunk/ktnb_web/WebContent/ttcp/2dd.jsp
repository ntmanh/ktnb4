<%@page pageEncoding="UTF-8"%>    
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">CÔNG TÁC QUẢN LÝ NHÀ NƯỚC VỀ KHIẾU NẠI, TỐ CÁO 2Đ/KNTC</h3>
<html:form action="/bc2dd.do?method=show">
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
		<td colspan="4" style="background-color:#CCC"><b>Ban hành văn bản quản lý, chỉ đạo (Bộ, ngành, tỉnh, TP) về công tác KNTC</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số văn bản ban hành mới</td>
		<td width="30%"><html:text property="vbMoiBh" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Số văn bản được sửa đổi, bổ sung</td>
		<td width="30%"><html:text property="vbBoSung" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Tập huấn, tuyên truyền, giáo dục pháp luật về KNTC cho cán bộ, công chức, viên chức, nhân dân</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Pháp luật về khiếu nại, tố cáo theo lớp</td>
		<td width="30%"><html:text property="thLop" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Pháp luật về khiếu nại, tố cáo theo người</td>
		<td width="30%"><html:text property="thNguoi" style="width:250px" onblur="isNumber(this,'i')"/></td>		
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Thanh tra, kiểm tra trách nhiệm</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số cuộc thực hiện pháp luật về KNTC</td>
		<td width="30%"><html:text property="ttktSoCuoc" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Số đơn vị thực hiện pháp luật về KNTC</td>
		<td width="30%"><html:text property="ttktSoDonVi" style="width:250px" onblur="isNumber(this,'i')"/></td>	
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số đơn vị có vi phạm</td>
		<td width="30%"><html:text property="ttktSoDvViPham" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Tổ chức kiến nghị xử lý, kiểm điểm, rút kinh nghiệm</td>
		<td width="30%"><html:text property="ttktKdToChuc" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Cá nhân kiến nghị xử lý, kiểm điểm, rút kinh nghiệm</td>
		<td width="30%"><html:text property="ttktKdCaNhan" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Tổ chức kiến nghị xử lý hành chính</td>
		<td width="30%"><html:text property="ttktHcToChuc" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Cá nhân kiến nghị xử lý hành chính</td>
		<td width="30%"><html:text property="ttktHcCaNhan" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Kiểm tra việc thực hiện kết luận thanh tra trách nhiệm, quyết định xử lý</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Tổng số KLTT và QĐ xử lý đã kiểm tra</td>
		<td width="30%"><html:text property="ktthTongSo" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Tổ chức đã kiểm điểm, rút kinh nghiệm</td>
		<td width="30%"><html:text property="ktthKdToChuc" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Cá nhân đã kiểm điểm, rút kinh nghiệm</td>
		<td width="30%"><html:text property="ktthKdCaNhan" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Tổ chức đã xử lý hành chính</td>
		<td width="30%"><html:text property="ktthHcToChuc" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Cá nhân đã xử lý hành chính</td>
		<td width="30%"><html:text property="ktthHcCaNhan" style="width:250px" onblur="isNumber(this,'i')"/></td>
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
	document.forms[0].action='bc2dd.do?method=show';
	document.forms[0].submit();
}
function save(){
	document.forms[0].action="bc2dd.do?method=save";
	document.forms[0].submit();
}
</script>
<%@ include file="/bottom.jsp"%>