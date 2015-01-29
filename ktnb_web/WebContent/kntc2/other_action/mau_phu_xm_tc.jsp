<%@ page pageEncoding="UTF-8"%>
<fieldset><legend>Biễu mẫu phụ</legend>
	<table width="100%">
		<tr>
			<td width="50%"><a href="#" onclick="openBm2('kntc_khxm.do?method=bb&action=bbxmtc&id=');">Biên bản công bố quyết định xác minh Tố cáo - Mẫu 12/KNTC</a></td>
			<td><a href="#" onclick="openBm2('kntc_xm_phieu_yc.do?method=ycgt&action=phieuYcGtTC&id=');">Phiếu yêu cầu giải trình - Mẫu 12/TC</a></td>
		</tr>
		<tr>
			<td><a href="#" onclick="openBm2('kntc_khxm.do?method=bb&action=bbLamViecNguoiTC&id=');">Biên bản làm việc với người Tố cáo - Mẫu 09/TC</a></td>
			<td><a href="#" onclick="openBm2('kntc_xm_phieu_yc.do?method=yktv&action=yktvTC&id=');">Lập phiếu lấy ý kiến tư vấn - Mẫu 14/TC</a></td>
		</tr>
		<tr>
			<td><a href="#" onclick="openBm2('kntc_khxm.do?method=bb&action=bbLamViecNguoiBiTC&id=');">Biên bản làm việc với người bị Tố cáo - Mẫu 12/KNTC</a></td>
			<td><a href="#" onclick="openBm2('kntc_xm_phieu_yc.do?method=tcgd&action=ycgdTC&id=');">Lập phiếu yêu cầu, trưng cầu giám định - Mẫu 15/TC</a></td>
		</tr>
		<tr>
			<td><a href="#" onclick="openBm2('kntc_xm_phieu_yc.do?method=show&action=phieuYcHsTlTC&id=');">Phiếu yêu cầu cung cấp báo cáo hồ sơ, tài liệu - Mẫu 13/KNTC</a></td>
			<td><a href="#" onclick="openBm2('kntc_xm_gia_han.do?method=giahan&action=giahanTC&id=');">Quyết định gia hạn thời gian xác minh - Mẫu 16/TC</a></td>
		</tr>
		<tr>
			<td><a href="#" onclick="openBm2('kntc_khxm.do?method=bb&action=bbYeuCauBoSungHSTLTC&id=');">Biên bản làm việc yêu cầu bổ sung hồ sơ, tài liệu - Mẫu 12/KNTC </a></td>
			<td></td>
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