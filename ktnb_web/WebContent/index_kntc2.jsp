<%@ page pageEncoding="UTF-8"%> 
<%@ include file="/top_bar.jsp"%>
<table align="left" width="100%" cellpadding="10">
	<tr>
		<td valign="top" align="left" width="50%">
			<ul class="liMenu">
				<li><a href="kntc_tiep_dan.do?method=show"><font color="FF3600" size="2"><span>&raquo;</span></font>Sổ tiếp dân</a></li>
				<li><a href="kntc_tim_kiem.do?method=show&action=tktiepdan"><font color="FF3600" size="2"><span>&raquo;</span></font>Tìm kiếm hồ sơ tiếp dân</a></li>
				<li><a href="kntc_tiep_dan_van_thu.do?method=show&l=v"><font color="FF3600" size="2"><span>&raquo;</span></font>Xử lý hồ sơ văn thư</a></li>
				<li><a href="kntc_tim_kiem.do?method=show&action=tkxuly"><font color="FF3600" size="2"><span>&raquo;</span></font>Tìm kiếm hồ sơ văn thư</a></li>
			</ul>
		</td>
		<td valign="top" align="left" width="50%">
			<ul class="liMenu">
				<li><a href="kntc_tim_kiem.do?method=show&action=xuLyKhieuNai"><font color="FF3600" size="2"><span>&raquo;</span></font>Xử lý khiếu nại</a></li>
				<li><a href="kntc_tim_kiem.do?method=show&action=xuLyToCao"><font color="FF3600" size="2"><span>&raquo;</span></font>Xử lý tố cáo</a></li>		
				<li><a href="kntc_tg.do?method=lopDt"><font color="FF3600" size="2"><span>&raquo;</span></font>Quản lý lớp tập huấn</a></li>
			</ul>
		</td>
	<tr/>
</table>
<%@ include file="/bottom.jsp"%>