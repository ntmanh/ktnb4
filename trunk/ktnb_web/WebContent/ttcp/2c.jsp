<%@page pageEncoding="UTF-8"%>    
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">TỔNG HỢP KẾT QUẢ GIẢI QUYẾT ĐƠN KHIẾU NẠI 2C/KNTC</h3>
<html:form action="/bc2c.do?method=show">
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
		<td colspan="4" style="background-color:#CCC"><b>Đơn khiếu nại thuộc thẩm quyền</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Tổng số đơn KN</td>
		<td width="30%"><html:text property="TONG_SO_DON_KN" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Trong đó đơn nhận trong kỳ báo cáo</td>
		<td width="30%"><html:text property="DON_NHAN_TRONG_KY" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Đơn tồn kỳ  trước chuyển sang</td>
		<td width="30%"><html:text property="DON_TON_KY_TRUOC" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Tổng số vụ việc</td>
		<td width="30%"><html:text property="SO_VU_VIEC" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số đơn thuộc thẩm quyền đã giải quyết</td>
		<td width="30%"><html:text property="SO_DON_THUOC_THAM_QUYEN" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Số vụ việc thuộc thẩm quyền đã giải quyết</td>
		<td width="30%"><html:text property="SO_VU_VIEC_THUOC_THAM_QUYEN" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số vụ việc giải quyết bằng QĐ hành chính</td>
		<td width="30%"><html:text property="SO_VU_VIEC_GQ_QUA_QDHC" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Số vụ việc rút đơn thông qua giải thích, thuyết phục</td>
		<td width="30%"><html:text property="DGQ_SVV_RUT_DON" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Kết quả giải quyết</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Phân tích kết quả khiếu nại đúng</td>
		<td width="30%"><html:text property="KQ_DUNG" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Phân tích kết quả khiếu nại sai</td>
		<td width="30%"><html:text property="KQ_SAI" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Phân tích kết quả khiếu nại đúng một phần</td>
		<td width="30%"><html:text property="KQ_DUNG_SAI" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Phân tích kết quả giải quyết lần l</td>
		<td width="30%"><html:text property="GQ_LAN1" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Công nhận quyết định giải quyết lần 1</td>
		<td width="30%"><html:text property="GQ_LAN2_CONG_NHAN" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Huỷ sửa quyết định giải quyết lần 1</td>
		<td width="30%"><html:text property="GQ_LAN2_HUY" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Kiến nghị thu hồi cho Nhà nước</td>
		<td width="30%"><html:text property="GQ_THU_HOI_CHO_NN" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Trả lại cho công dân</td>
		<td width="30%"><html:text property="GQ_TRA_LAI_CD" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số người được trả lại quyền lợi</td>
		<td width="30%"><html:text property="GQ_SO_NGUOI_DUOC_TRA_QUYEN_LOI" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
	<td width="20%" style="text-align: right;">Tổng số người kiến nghị xử lý hành chính</td>
		<td width="30%"><html:text property="GQ_XL_HC_NGUOI" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Kiến nghị xử lý hành chính số người đã bị xử lý</td>
		<td width="30%"><html:text property="soNguoiDaBiXly" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Chuyển cơ quan điều tra khởi tố số vụ</td>
		<td width="30%"><html:text property="chuyenDtSoVu" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Chuyển cơ quan điều tra khởi tố số đối tượng</td>
		<td width="30%"><html:text property="chuyenDtSoNguoi" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Kết quả số vụ đã khởi tố</td>
		<td width="30%"><html:text property="chuyenDtKqSoVu" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Kết quả số đối tượng đã khởi tố</td>
		<td width="30%"><html:text property="chuyenDtKqSoNguoi" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Chấp hành thời gian giải quyết theo quy định</b></td>
	</tr>
	<td width="20%" style="text-align: right;">Số vụ việc giải quyết đúng thời hạn</td>
		<td width="30%"><html:text property="CHAP_HANH_DUNG_HAN" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Số vụ việc giải quyết quá thời hạn</td>
		<td width="30%"><html:text property="CHAP_HANH_QUA_HAN" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Việc thi hành quyết định giải quyết khiếu nại</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Tổng số quyết định phải tổ chức thực hiện trong kỳ báo cáo</td>
		<td width="30%"><html:text property="TH_SQD_PHAI_THUC_HIEN_TRONG_KY" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Đã thực hiện</td>
		<td width="30%"><html:text property="TH_SQD_DA_THUC_HIEN" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Thu hồi cho Nhà nước phải thu</td>
		<td width="30%"><html:text property="thuHoiPhaiThu" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Thu hồi cho Nhà nước đã thu</td>
		<td width="30%"><html:text property="thuHoiDaThu" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Trả lại cho công dân phải trả</td>
		<td width="30%"><html:text property="traLaiPhaiTra" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Trả lại cho công dân đã trả</td>
		<td width="30%"><html:text property="traLaiDaTra" style="width:250px" onblur="isNumber(this,'i')"/></td>
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
	document.forms[0].action='bc2c.do?method=show';
	document.forms[0].submit();
}
function save(){
	document.forms[0].action="bc2c.do?method=save";
	document.forms[0].submit();
}
</script>
<%@ include file="/bottom.jsp"%>