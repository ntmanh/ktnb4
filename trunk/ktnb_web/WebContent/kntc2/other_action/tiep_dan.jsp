<%@ page pageEncoding="UTF-8"%>
<fieldset style=""><legend>Xử lý phụ</legend>
	<table width="100%">
		<tr>
			<td width="50%"><a href="kntc_tim_kiem.do?method=show&action=bosungHS">Bổ sung hồ sơ, tài liệu</a></td>
			<td><a href="kntc_tim_kiem.do?method=show&action=suaHSTD">Sửa sổ tiếp dân</a></td>
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