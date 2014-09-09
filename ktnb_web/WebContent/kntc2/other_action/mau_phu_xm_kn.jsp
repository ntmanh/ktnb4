<%@ page pageEncoding="UTF-8"%>
<fieldset><legend>Biễu mẫu phụ</legend>
	<table width="100%">
		<tr>
			<td width="50%"><a href="#" onclick="openBm2('kntc_khxm.do?method=bb&action=bbxmkn&id=');">Biên bản công bố quyết định xác minh Khiếu Nại - Mẫu 12/KNTC</a></td>
			<td><a href="#" onclick="openBm2('kntc_xm_phieu_yc.do?method=ycgt&action=phieuYcGtKN&id=');">Phiếu yêu cầu giải trình - Mẫu 14A/KNTC</a></td>
		</tr>
		<tr>
			<td><a href="#" onclick="openBm2('kntc_khxm.do?method=bb&action=bbLamViecNguoiKN&id=');">Biên bản làm việc với người Khiếu Nại - Mẫu 12/KNTC</a></td>
			<td><a href="#" onclick="openBm2('kntc_xm_phieu_yc.do?method=yktv&action=yktvKN&id=');">Lập phiếu lấy ý kiến tư vấn - Mẫu 15A/KNTC</a></td>
		</tr>
		<tr>
			<td><a href="#" onclick="openBm2('kntc_khxm.do?method=bb&action=bbLamViecNguoiBiKN&id=');">Biên bản làm việc với người bị Khiếu Nại - Mẫu 12/KNTC</a></td>
			<td><a href="#" onclick="openBm2('kntc_xm_phieu_yc.do?method=tcgd&action=ycgdKN&id=');">Lập phiếu yêu cầu, trưng cầu giám định - Mẫu 15B/KNTC</a></td>
		</tr>
		<tr>
			<td><a href="#" onclick="openBm2('kntc_xm_phieu_yc.do?method=show&action=phieuYcHsTlKN&id=');">Phiếu yêu cầu cung cấp báo cáo hồ sơ, tài liệu - Mẫu 13/KNTC</a></td>
			<td><a href="#" onclick="openBm2('kntc_xm_gia_han.do?method=giahan&action=giahanKN&id=');">Quyết định gia hạn thời gian xác minh - Mẫu 16/KNTC</a></td>
		</tr>
	</table>
</fieldset>
<script type="text/javascript" charset="utf-8">
function openBm2(link){
		link = link + '<%=request.getParameter("id")%>';
		var r = '<%=request.getParameter("r")%>';
		if(r=='rol') link = link +'&r=rol';
		openWindow(link,800,600,false);
	}
</script>