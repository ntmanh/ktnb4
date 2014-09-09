<%@ include file="/top_bar.jsp"%> 
<%@ page pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
%>
<div id="tab_kntc" style="background-color: transparent">
<ul>
	<li><a href="#tab_tiep_dan" class="tabTitle">Tiếp dân</a></li>
	<li><a href="#tab_xu_ly_ho_so_van_thu" class="tabTitle">Xử lý hồ sơ qua đường văn thư</a></li>
	<li><a href="#tab_phan_loai_xu_ly_KN" class="tabTitle">Phân loại-xử lý đơn KN</a></li>
	<li><a href="#tab_phan_loai_xu_ly_TC" class="tabTitle">Phân loại-xử lý đơn TC</a></li>
	<li><a href="#tab_chuc_nang_khac" class="tabTitle">Các chức năng khác</a></li>
</ul>
<div id="tab_tiep_dan">
<table class="tableMenu">
	<tr>
		<td><img src="images/icons/sotiepdan.png" /><a href="kntc_tiep_dan.do?method=show">Sổ tiếp dân</a></td>
		<td><img src="images/icons/bosunghoso.png" /><a href="kntc_tim_kiem.do?method=show&action=bosungHS">Bổ sung hồ sơ, tài liệu</a></td>
	</tr>
	<tr>
		<td><img src="images/icons/sotiepdan.png" /><a href="kntc_tim_kiem.do?method=show&action=suaHSTD">Sửa sổ tiếp dân</a></td>
		<td><img src="images/icons/chuyenhoso.png" /><a href="kntc_tim_kiem.do?method=show&action=chuyenHS">Chuyển giao sang bộ phận hành chính lưu trữ</a></td>
	</tr>
	<tr>
		<td><img src="images/icons/timkiem.png" /><a href="kntc_tim_kiem.do?method=show&action=tktiepdan">Tra cứu hồ sơ tiếp dân</a></td>
		<td><img src="images/icons/timkiem.png" /><a href="kntc_tim_kiem.do?method=show&action=gopHs">Gộp hồ sơ liên quan</a></td>
	</tr>
</table>
</div>
<div id="tab_xu_ly_ho_so_van_thu">
<table class="tableMenu">
	<tr>
		<td><img src="images/icons/chuanhan.png" /><a href="kntc_tiep_dan_van_thu.do?method=show&l=v">Nhập hồ sơ giải quyết lần đầu</a></td>
		<td><img src="images/icons/phancongcanbo.png" /><a href="kntc_tim_kiem.do?method=show&action=phancongHS">Thay cán bộ xử lý</a></td>
	</tr>
	<tr>
		<td><img src="images/icons/nhanmotlan.png" /><a href="kntc_tim_kiem.do?method=show&action=chonXLHS1Lan">Nhập hồ sơ do CQT khác hoặc từ tiếp dân chuyển đến</a></td>
		<td><img src="images/icons/tachdon.png" /><a href="kntc_tim_kiem.do?method=show&action=tachDon">Tách nội dung đơn khiếu tố</a></td>
	</tr>
	<tr>
		<td><img src="images/icons/timkiem.png" /><a href="kntc_tim_kiem.do?method=show&action=copyHs">Xử lý đơn KN lần 2/Copy đơn KN từ cấp dưới</a></td>
		<td><img src="images/icons/sotiepdan.png" /><a href="kntc_tim_kiem.do?method=show&action=suaHSVT">Sửa hồ sơ văn thư</a></td>
	</tr>
	<tr>
		<td><img src="images/icons/timkiem.png" /><a href="kntc_tim_kiem.do?method=show&action=tkxuly">Tra cứu hồ sơ</a></td>
		<td><img src="images/icons/timkiem.png" /><a href="kntc_da_tiep_nhan.do?method=gopHs">Gộp hồ sơ/Nhập hồ sơ cùng nội dung</a></td>
	</tr>
</table>
</div>
<div id="tab_phan_loai_xu_ly_KN">
<table class="tableMenu">
	<tr>
		<td><img src="images/icons/phancongcanbo.png" /><a href="kntc_tim_kiem.do?method=show&action=phanloaiHSKN">Phân loại lập đề xuất xử lý đơn khiếu nại</a></td>
		<td><img src="images/icons/lichtrinh.png" /><a href="kntc_tim_kiem.do?method=show&action=lichTrinhDKKN">Xem lịch trình dự kiến</a></td>
	</tr>
	<tr>
		<td><img src="images/icons/phieu.png" /><a href="kntc_tim_kiem.do?method=show&action=bbLamViecNguoiKN0">Biên bản làm việc với người Khiếu Nại - Mẫu 12/KNTC</a></td>
		<td><img src="images/icons/bosunghoso.png" /><a href="kntc_tim_kiem.do?method=show&action=bosungHS">Bổ sung hồ sơ, tài liệu</a></td>
	</tr>
	<tr>
		<td><img src="images/icons/rutdon.png" /><a href="kntc_tim_kiem.do?method=show&action=rutdon">Rút/Đóng đơn KN</a></td>
		<td><img src="images/icons/lichtrinh.png" /><a href="kntc_tim_kiem.do?method=show&action=xacMinhKhieuNai">Tiền hành xác minh</a></td>
	</tr>
	<tr>
		<td><img src="images/icons/theodoi.png" /><a href="kntc_tim_kiem.do?method=show&action=theodoiKN">Theo dõi thi hành KN</a></td>
		<td><img src="images/icons/lichtrinh.png" /><a href="kntc_tim_kiem.do?method=show&action=ketThucKhieuNai">Kết thúc giải quyết KN</a></td>
	</tr>
	<tr>
		<td><img src="images/icons/timkiem.png" /><a href="kntc_tim_kiem.do?method=show&action=tkxuly">Tra cứu hồ sơ</a></td>
		<td></td>
	</tr>
</table>
</div>
<div id="tab_phan_loai_xu_ly_TC">
<table class="tableMenu">
	<tr>
		<td><img src="images/icons/phancongcanbo.png" /><a href="kntc_tim_kiem.do?method=show&action=phanloaiHSTC">Phân loại lập đề xuất xử lý đơn tố cáo</a></td>
		<td><img src="images/icons/lichtrinh.png" /><a href="kntc_tim_kiem.do?method=show&action=lichTrinhDKTC">Xem lịch trình dự kiến</a></td>
	</tr>
	<tr>
		<td><img src="images/icons/phieu.png" /><a href="kntc_tim_kiem.do?method=show&action=bbLamViecNguoiTC0">Biên bản làm việc với người Tố Cáo - Mẫu 12/KNTC</a></td>
		<td><img src="images/icons/bosunghoso.png" /><a href="kntc_tim_kiem.do?method=show&action=bosungHS">Bổ sung hồ sơ, tài liệu</a></td>
	</tr>
	<tr>
		<td><img src="images/icons/phieu.png" /><a href="kntc_tim_kiem.do?method=show&action=25A">Phiếu chuyển sang cơ quan điều tra - Mẫu 25A/KNTC</a></td>
		<td><img src="images/icons/lichtrinh.png" /><a href="kntc_tim_kiem.do?method=show&action=xacMinhToCao">Tiến hành xác minh</a></td>
	</tr>
	<tr>
		<td><img src="images/icons/phieu.png" /><a href="kntc_tim_kiem.do?method=show&action=25B">Biên bản bàn giao hs vụ việc có dấu hiệu tội phạm - Mẫu 25B/KNTC</a></td>
		<td><img src="images/icons/phieu.png" /><a href="kntc_tim_kiem.do?method=show&action=ketLuanTC">Kết luận nội dung TC - Mẫu 24/KNTC</a></td>
	</tr>
	<tr>
		<td><img src="images/icons/theodoi.png" /><a href="kntc_tim_kiem.do?method=show&action=theodoiTC">Theo dõi thi hành TC</a></td>
		<td><img src="images/icons/phieu.png" /><a href="kntc_tim_kiem.do?method=show&action=bbThongBaoDuThaoTC">Biên bản thông báo dự thảo kl nội dung Tố Cáo - Mẫu 12/KNTC</a></td>
	</tr>
	<tr>
		<td><img src="images/icons/phieu.png" /><a href="kntc_tim_kiem.do?method=show&action=tbkqgqtc">Thông báo kết quả giải quyết TC - Mẫu 26/KNTC</a></td>
		<td><img src="images/icons/lichtrinh.png" /><a href="kntc_tim_kiem.do?method=show&action=ketThucToCao">Kết thúc giải quyết TC</a></td>
	</tr>
	<tr>
		<td><img src="images/icons/timkiem.png" /><a href="kntc_tim_kiem.do?method=show&action=tkxuly">Tra cứu hồ sơ</a></td>
		<td></td>
	</tr>
</table>
</div>
<div id="tab_chuc_nang_khac">
<ul class="liMenu">
	<li><img src="images/icons/loptaphuan.png" /><a href="kntc_tg.do?method=lopDt">Quản lý lớp tập huấn, tuyên truyền KNTC</a></li>
</ul>
</div>
</div>
<script>
$(function()
{
  var tab_select=jQuery.fn.readCookie("TABI");
  var tabOpts={selected:tab_select,select:function(event,tab){jQuery.fn.createCookie("TABI",tab.index);}}; 
  $("#tab_kntc").tabs(tabOpts);
  $("#tab_kntc").removeClass("ui-corner-all");
  $("#tab_kntc").children().removeClass("ui-corner-all");  
});
</script>
<%@ include file="/bottom.jsp"%>