<%@page pageEncoding="UTF-8"%>    
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">TỔNG HỢP KẾT QUẢ GIẢI QUYẾT ĐƠN TỐ CÁO 2D/KNTC</h3>
<html:form action="/bc2d.do?method=show">
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
		<td colspan="4" style="background-color:#CCC"><b>Đơn tố cáo thuộc thẩm quyền</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Tổng số đơn tố cáo</td>
		<td width="30%"><html:text property="TONG_SO_DON" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Đơn nhận trong kỳ báo cáo</td>
		<td width="30%"><html:text property="DON_NHAN_TRONG_KY" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Đơn tồn kỳ trước chuyển sang</td>
		<td width="30%"><html:text property="DON_TON_KY_TRUOC" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Tổng số vụ việc</td>
		<td width="30%"><html:text property="SO_VU_VIEC" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Kết quả giải quyết</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Đã giải quyết số đơn thuộc thẩm quyền</td>
		<td width="30%"><html:text property="DA_GIAI_QUYET_SO_DON" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Đã giải quyết số vụ việc thuộc thẩm quyền</td>
		<td width="30%"><html:text property="DA_GIAI_QUYET_SO_VU_VIEC" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Tố cáo đúng</td>
		<td width="30%"><html:text property="KQ_DUNG" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Tố cáo sai</td>
		<td width="30%"><html:text property="KQ_SAI" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Tố cáo đúng một phần</td>
		<td width="30%"><html:text property="KQ_DUNG_SAI" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Kiến nghị thu hồi cho Nhà nước</td>
		<td width="30%"><html:text property="GQ_THU_HOI_CHO_NN" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Trả lại cho công dân</td>
		<td width="30%"><html:text property="GQ_TRA_LAI_CD" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Số người được bảo vệ quyền lợi</td>
		<td width="30%"><html:text property="snDuocBv" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>		
		<td width="20%" style="text-align: right;">Tổng số người kiến nghị xử lý hành chính</td>
		<td width="30%"><html:text property="snBiXly" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Số người đã bị xử lý hành chính</td>
		<td width="30%"><html:text property="GQ_XL_HC_NGUOI_DA_XL" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<td width="20%" style="text-align: right;">Số vụ chuyển cơ quan điều tra, khởi tố</td>
		<td width="30%"><html:text property="GQ_DT_SO_VU" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Số đối tượng chuyển cơ quan điều tra, khởi tố</td>
		<td width="30%"><html:text property="GQ_DT_SO_DOI_TUONG" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Kết quả số vụ đã khởi tố</td>
		<td width="30%"><html:text property="chuyenDtSoVuDkt" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Kết quả số đối tượng đã khởi tố</td>
		<td width="30%"><html:text property="chuyenDtSoNgDkt" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Chấp hành thời gian giải quyết theo quy định</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số vụ việc giải quyết đúng thời hạn</td>
		<td width="30%"><html:text property="CHAP_HANH_DUNG_HAN" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Số vụ việc giải quyết quá thời hạn</td>
		<td width="30%"><html:text property="CHAP_HANH_QUA_HAN" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Việc thi hành quyết định xử lý tố cáo</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Tổng số quyết định phải tổ chức thực hiện trong kỳ báo cáo</td>
		<td width="30%"><html:text property="TH_SQD_PHAI_THUC_HIEN_TRONG_KY" style="width:250px; background-color: #CCC" readonly="true"/></td>
		<td width="20%" style="text-align: right;">Đã thực hiện xong</td>
		<td width="30%"><html:text property="TH_SQD_DA_THUC_HIEN" style="width:250px; background-color: #CCC" readonly="true"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Thu hồi cho Nhà nước phải thu</td>
		<td width="30%"><html:text property="thThuHoiPhaiThu" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Thu hồi cho Nhà nước đã thu</td>
		<td width="30%"><html:text property="thThuHoiDaThu" style="width:250px" onblur="isNumber(this,'i')"/></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Trả lại cho công dân phải trả</td>
		<td width="30%"><html:text property="thTraLaiPhaiTra" style="width:250px" onblur="isNumber(this,'i')"/></td>
		<td width="20%" style="text-align: right;">Trả lại cho công dân đã trả</td>
		<td width="30%"><html:text property="thTraLaiDaTra" style="width:250px" onblur="isNumber(this,'i')"/></td>
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
	document.forms[0].action='bc2d.do?method=show';
	document.forms[0].submit();
}
function save(){
	document.forms[0].action="bc2d.do?method=save";
	document.forms[0].submit();
}
</script>
<%@ include file="/bottom.jsp"%>