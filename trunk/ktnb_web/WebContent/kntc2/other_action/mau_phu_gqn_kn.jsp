<%@ page pageEncoding="UTF-8"%>
<fieldset><legend>Biễu mẫu phụ</legend>
	<table width="100%">
		<tr>
			<td><a href="#" onclick="openBm2('kntc_khxm.do?method=bb&action=bbLamViecNguoiKN0&id=');">Biên bản làm việc với người Khiếu Nại - Mẫu 12/KNTC</a></td>
			<td><a href="#" onclick="openBm2('kntc_xm_phieu_yc.do?method=yktv&action=yktvKN&id=');">Lập phiếu lấy ý kiến tư vấn - Mẫu 15A/KNTC</a></td>
		</tr>
		<tr>
			<td><a href="#" onclick="openBm2('kntc_khxm.do?method=bb&action=bbDoiThoaiKN&id=');">Biên bản đối thoại - Mẫu 12/KNTC</a></td>
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