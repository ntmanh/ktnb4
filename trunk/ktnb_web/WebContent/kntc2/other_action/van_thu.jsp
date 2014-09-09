<%@ page pageEncoding="UTF-8"%>
<fieldset style=""><legend>Xử lý phụ</legend>
	<table width="100%">
		<tr>
			<td width="50%"><a href="kntc_tim_kiem.do?method=show&action=phancongHS">Thay cán bộ xử lý</a></td>
			<td><a href="kntc_tim_kiem.do?method=show&action=tachDon">Tách nội dung đơn khiếu tố</a></td>
		</tr>
		<tr>
			<td><a href="#" onclick="openCheckForEdit();">Sửa hồ sơ văn thư</a></td>
			<td></td>
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
	function openCheckForEdit(){
		var id = '<%=request.getParameter("id")%>';
		if(id == 'null' || id.length == 0){
			//Chưa có thì phải tìm kiếm
			openBm('kntc_tim_kiem.do?method=show&action=suaHSVT');
		}else{			
			//Đang thao tác => edit luôn
			var link = 'kntc_tiep_dan_van_thu.do?method=edit&action=suaHSVT&id='+id;
			window.location = link;
		}
	}
</script>