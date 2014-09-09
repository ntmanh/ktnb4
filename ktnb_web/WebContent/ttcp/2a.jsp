<%@page pageEncoding="UTF-8"%>    
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Số liệu bổ sung báo cáo TCCP Tổng hợp công tác Tiếp Dân 2A/KNTC</h3>
<html:form action="/bc2a.do?method=show">
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
		<td colspan="4" style="background-color:#CCC"><b>Tiếp thường xuyên</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số lượt</td>
		<td width="30%"><html:text property="ttxLuot" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Số người</td>
		<td width="30%"><html:text property="ttxNguoi" style="width:250px; background-color: #CCC" readonly="true"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Vụ việc cũ</td>
		<td width="30%"><html:text property="ttxVuViecCu" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Vụ việc mới</td>
		<td width="30%"><html:text property="ttxVuViecMoi" style="width:250px" onblur="isNumber(this,'i')"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số lượt đoàn đông người</td>
		<td width="30%"><html:text property="ttxDnnSoDoan" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Số người trong đoàn đông người</td>
		<td width="30%"><html:text property="ttxDnnNguoi" style="width:250px; background-color: #CCC" readonly="true"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Đông người Vụ việc cũ</td>
		<td width="30%"><html:text property="ttxDdnVuViecCu" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Đông người Vụ việc mới</td>
		<td width="30%"><html:text property="ttxDdnVuViecMoi" style="width:250px" onblur="isNumber(this,'i')"/></td>		
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Tiếp định kỳ và đột xuất của lãnh đạo</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số lượt</td>
		<td width="30%"><html:text property="tdxLuot" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Số người</td>
		<td width="30%"><html:text property="tdxNguoi" style="width:250px; background-color: #CCC" readonly="true"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Vụ việc cũ</td>
		<td width="30%"><html:text property="tdxVuViecCu" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Vụ việc mới</td>
		<td width="30%"><html:text property="tdxVuViecMoi" style="width:250px" onblur="isNumber(this,'i')"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số lượt đoàn đông người</td>
		<td width="30%"><html:text property="tdxDnnSoDoan" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Số người trong đoàn đông người</td>
		<td width="30%"><html:text property="tdxDnnNguoi" style="width:250px; background-color: #CCC" readonly="true"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Đông người Vụ việc cũ</td>
		<td width="30%"><html:text property="tdxDdnVuViecCu" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Đông người Vụ việc mới</td>
		<td width="30%"><html:text property="tdxDdnVuViecMoi" style="width:250px" onblur="isNumber(this,'i')"/></td>		
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Nội dung tiếp công dân</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Khiếu nại về chính sách</td>
		<td width="30%"><html:text property="ndKnChinhSach" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Khiếu nại về nhà,tài sản</td>
		<td width="30%"><html:text property="ndKnNhaTaiSan" style="width:250px" onblur="isNumber(this,'i')"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Khiếu nại về chế độ CC,VC</td>
		<td width="30%"><html:text property="ndKnCheDo" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Phản ánh, kiến nghị khác</td>
		<td width="30%"><html:text property="ndKhac" style="width:250px" onblur="isNumber(this,'i')"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Tố cáo hành chính</td>
		<td width="30%"><html:text property="ndTcHanhChinh" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Tố cáo tham nhũng</td>
		<td width="30%"><html:text property="ndTcThamNhung" style="width:250px" onblur="isNumber(this,'i')"/></td>		
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Kết quả qua tiếp dân</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Chưa được giải quyết</td>
		<td width="30%"><html:text property="kqChuaGiaiQuyet" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Chưa có QĐ giải quyết</td>
		<td width="30%"><html:text property="kqDaGiaiQuyetChuaCoQD" style="width:250px" onblur="isNumber(this,'i')"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Đã có QĐ giải quyết lần 1,2, cuối cùng</td>
		<td width="30%"><html:text property="kqDaGiaiQuyetDaCoQD" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Đã có bản án của Toà án</td>
		<td width="30%"><html:text property="kqDaGiaiQuyetDaCoBanAn" style="width:250px" onblur="isNumber(this,'i')"/></td>		
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
	document.forms[0].action='bc2a.do?method=show';
	document.forms[0].submit();
}
function save(){
	document.forms[0].action="bc2a.do?method=save";
	document.forms[0].submit();
}
</script>
<%@ include file="/bottom.jsp"%>