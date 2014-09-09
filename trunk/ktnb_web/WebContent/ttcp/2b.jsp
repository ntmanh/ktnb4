<%@page pageEncoding="UTF-8"%>    
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">TỔNG HỢP KẾT QUẢ XỬ LÝ ĐƠN THƯ KHIẾU NẠI, TỐ CÁO 2B/KNTC</h3>
<html:form action="/bc2b.do?method=show">
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
		<td colspan="4" style="background-color:#CCC"><b>Tiếp nhận</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Tổng số</td>
		<td width="30%"><html:text property="tnTongSo" style="width:250px;"/></td>
		<td width="20%" style="text-align: right;">Đủ điều kiện xử lý</td>
		<td width="30%"><html:text property="tnDuDkXly" style="width:250px;"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Trong kỳ nhiều người đứng tên</td>
		<td width="30%"><html:text property="tnTkNhieuNguoi" style="width:250px;"/></td>
		<td width="20%" style="text-align: right;">Trong kỳ 1 người đứng tên</td>
		<td width="30%"><html:text property="tnTrongKyMotNguoi" style="width:250px;"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Kỳ trước nhiều người đứng tên</td>
		<td width="30%"><html:text property="tnKtNhieuNguoi" style="width:250px;"/></td>
		<td width="20%" style="text-align: right;">Kỳ trước 1 người đứng tên</td>
		<td width="30%"><html:text property="tnKtMotNguoi" style="width:250px;"/></td>		
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Phân loại đơn khiếu nại, tố cáo (số đơn)</b></td>
	</tr>
	<tr>
		<td colspan="4" style="background-color:#DDD;"><b><i>Theo nội dung</i></b></td>
	</tr>	
	<tr>
		<td colspan="4" style="background-color:#DDD"><i>Khiếu nại</i></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Hành chính - Tổng số</td>
		<td width="30%"><html:text property="ndKnHcTong" style="width:250px;"/></td>
		<td width="20%" style="text-align: right;">Hành chính - Về tài sản</td>
		<td width="30%"><html:text property="ndKnHcTaiSan" style="width:250px;"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Hành chính - Về chính sách, chế độ CC,VC</td>
		<td width="30%"><html:text property="ndKnHcChinhSach" style="width:250px;"/></td>
		<td width="20%" style="text-align: right;">Hành chính - Lĩnh vực CT,VH,XH khác</td>
		<td width="30%"><html:text property="ndKnKhac" style="width:250px;"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Về Đảng</td>
		<td width="30%"><html:text property="ndKnDang" style="width:250px;"/></td>
		<td width="20%" style="text-align: right;"></td>
		<td width="30%">&nbsp</td>		
	</tr>
	<tr>
		<td colspan="4" style="background-color:#DDD"><i>Tố cáo</i></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Tổng số</td>
		<td width="30%"><html:text property="ndTcTong" style="width:250px;"/></td>
		<td width="20%" style="text-align: right;">Lĩnh vực hành chính</td>
		<td width="30%"><html:text property="ndTcHc" style="width:250px;"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Tham nhũng</td>
		<td width="30%"><html:text property="ndTcThamNhung" style="width:250px;"/></td>
		<td width="20%" style="text-align: right;">Về Đảng</td>
		<td width="30%"><html:text property="ndTcDang" style="width:250px;"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Lĩnh vực khác</td>
		<td width="30%"><html:text property="ndTcKhac" style="width:250px;"/></td>
		<td width="20%" style="text-align: right;"></td>
		<td width="30%"></td>		
	</tr>
	<tr>
		<td colspan="4" style="background-color:#DDD;"><b><i>Theo Thẩm quyền</i></b></td>
	</tr>	
	<tr>
		<td width="20%" style="text-align: right;">Của các cơ quan hành chính các cấp</td>
		<td width="30%"><html:text property="tqCqHanhChinh" style="width:250px;"/></td>
		<td width="20%" style="text-align: right;">Của cơ quan Đảng</td>
		<td width="30%"><html:text property="tqCqDang" style="width:250px;"/></td>		
	</tr>
	<tr>
		<td colspan="4" style="background-color:#DDD;"><b><i>Theo trình tự giải quyết</i></b></td>
	</tr>	
	<tr>
		<td width="20%" style="text-align: right;">Chưa được giải quyết</td>
		<td width="30%"><html:text property="ttgqChuaGq" style="width:250px;"/></td>
		<td width="20%" style="text-align: right;">Đã được giải quyết lần đầu</td>
		<td width="30%"><html:text property="ttgqDaGqLanDau" style="width:250px;"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Đã được giải quyết nhiều lần</td>
		<td width="30%"><html:text property="ttgqDaGqNhieuLan" style="width:250px;"/></td>
		<td width="20%" style="text-align: right;"></td>
		<td width="30%"></td>		
	</tr>
		
	<tr>
		<td colspan="4" style="background-color:#DDD"><i>Đơn khác</i></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Đơn khác (kiến nghị, phản ánh, đơn nặc danh)</td>
		<td width="30%"><html:text property="donKhac" style="width:250px;"/></td>
		<td width="20%" style="text-align: right;"></td>
		<td width="30%"></td>		
	</tr>	
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Kết quả xử lý đơn khiếu nại, tố cáo</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số văn bản hướng dẫn</td>
		<td width="30%"><html:text property="kqSoVanBan" style="width:250px;"/></td>
		<td width="20%" style="text-align: right;">Số chuyển cơ quan có thẩm quyền</td>
		<td width="30%"><html:text property="kqSoChuyenCq" style="width:250px;"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số công văn đôn đốc việc giải quyết</td>
		<td width="30%"><html:text property="kqSoCvDonDoc" style="width:250px;"/></td>
		<td width="20%" style="text-align: right;">Đơn thuộc thẩm quyền Khiếu nại</td>
		<td width="30%"><html:text property="kqThuocTqKn" style="width:250px;"/></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Đơn thuộc thẩm quyền Tố cáo</td>
		<td width="30%"><html:text property="kqThuocTqTc" style="width:250px;"/></td>
		<td width="20%" style="text-align: right;"></td>
		<td width="30%"></td>		
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
	document.forms[0].action='bc2b.do?method=show';
	document.forms[0].submit();
}
function save(){
	document.forms[0].action="bc2b.do?method=save";
	document.forms[0].submit();
}
</script>
<%@ include file="/bottom.jsp"%>