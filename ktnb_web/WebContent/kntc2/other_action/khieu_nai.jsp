<%@ page pageEncoding="UTF-8"%>
<fieldset style=""><legend>Xử lý phụ</legend>
	<table width="100%">
		<tr>
			<td width="50%"><a href="#" onclick="openBm2('lich_trinh_du_kien.do?method=show&action=lichTrinhDKKN&id=');">Lịch trình dự kiến</a></td>
			<td><a href="#" onclick="openBm2('kntc_khxm.do?method=bb&action=bbLamViecNguoiKN0&id=');">Biên bản làm việc với người KN</a></td>
		</tr>		
		<tr>
			<td><a href="#" onclick="openBm2('kntc_qdgq.do?method=rutdon&id=');">Rút / Đóng đơn</a></td>			
			<td></td>
		</tr>
	</table>
</fieldset>
<script language="javascript">
	function openBm(link){
		openWindow(link,screen.width,screen.height,false);
	}
	function openBm2(link){
		link = link + '<%=request.getParameter("id")%>';
		var r = '<%=request.getParameter("r")%>';
		if(r=='rol') link = link +'&r=rol';
		openWindow(link,800,600,false);
	}
</script>