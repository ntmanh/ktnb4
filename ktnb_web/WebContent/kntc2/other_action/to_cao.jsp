<%@ page pageEncoding="UTF-8"%>
<fieldset style=""><legend>Xử lý phụ</legend>
	<table width="100%">
		<tr>
			<td width="50%"><a href="#" onclick="openBm2('lich_trinh_du_kien.do?method=show&action=lichTrinhDKTC&id=');">Lịch trình dự kiến</a></td>
			<td><a href="#" onclick="openBm2('kntc_khxm.do?method=bb&action=bbLamViecNguoiTC0&id=');">Biên bản làm việc với người TC</a></td>
		</tr>		
		<tr>
			<td><a href="#" onclick="openBm2('kntc_khxm.do?method=bb&action=bbThongBaoDuThaoTC&id=');">Biên bản thông báo dự thảo kết luận nội dung Tố Cáo - Mẫu 12/KNTC</a></td>			
			<td><a href="#" onclick="openBm2('kntc_dxxl.do?method=chuyenDieuTra&action=25A&id=');">Phiếu chuyển sang CQ điều tra 25A/KNTC</a></td>
		</tr>
		<tr>
			<td><a href="#" onclick="openBm2('kntc_bb.do?method=bb25B&action=25B&id=');">Biên bản bàn giao hồ sơ vụ việc 25B/KNTC</a></td>
			<td><!-- <a href="#" onclick="openBm2('kntc_qdgq.do?method=rutdon&id=');">Rút / Đóng đơn</a> --></td>
			
		</tr>
		<tr>
			<td><a href="#" onclick="openBm2('kntc_dxxltc.do?method=show&action=view&type=bBanNdung&id=');">Biên bản ghi nội dung tố cáo trực tiếp</a></td>			
			<td><a href="#" onclick="openBm2('kntc_dxxltc.do?method=show&action=view&type=tbKoGquyetTiep&id=');">Lập thông báo về việc không thụ lý giải quyết tiếp</a></td>			
		</tr>
		<tr>
			<td><a href="#" onclick="openBm2('kntc_dxxltc.do?method=show&action=view&type=tbKoThuLyGq&id=');">Lập thông báo về việc không thụ lý giải quyết</a></td>			
			<td><a href="#" onclick="openBm2('kntc_dxxltc.do?method=show&action=view&type=giaoNhiemVu&id=');">Giao nhiệm vụ xác minh tố cáo</a></td>			
		</tr>
	</table>
</fieldset>
<script language="javascript">
function openBm2(link){
		link = link + '<%=request.getParameter("id")%>';
		var r = '<%=request.getParameter("r")%>';
		if(r=='rol') link = link +'&r=rol';
		openWindow(link,800,600,false);
	}
</script>