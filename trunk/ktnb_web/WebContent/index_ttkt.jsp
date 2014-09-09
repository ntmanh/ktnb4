<%@page pageEncoding="UTF-8"%>    
<%@ include file="/top_bar.jsp"%>
<%@ page import="cmc.com.ktnb.util.KtnbUtil" %> 
<TABLE align="left" width="100%" cellpadding="10">  
	<tr>
		<td valign="top" align="left" width="50%">
		<UL class="liMenu">
			<li><a href="ke_hoach_nam.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Kế hoạch năm</a></li>
			<% if(!KtnbUtil.isChiCuc(ac)) { %>
			<li><a href="khttkt_cqt_cap_duoi.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Kế hoạch năm của các cơ quan thuế trực thuộc</a></li>
			<% }%>
			<% if(!KtnbUtil.isTongCuc(ac)) { %>
			<li><a href="khttkt_cqt_cap_tren.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Kế hoạch năm của các cơ quan thuế cấp trên</a></li>
			<% }%>			
			<li><!-- <a href="ttkt_dot_xuat.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Thanh tra Kiểm tra đột xuất</a> --> <a href="ttkt_dot_xuat.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Kiểm tra đột xuất</a></li>
			<li><a href="tim_kiem_cuoc_ttkt.do?act=pcTruongDoan"><font color="FF3600" size="2"><span>&raquo;</span></font> Chỉ định trưởng đoàn</a></li>
		</UL>
		</td>
		<td valign="top" align="left" width="50%">
		<ul class="liMenu">
			<li><!-- <a href="tim_kiem_cuoc_ttkt.do?act=timKiem"><font color="FF3600" size="2"><span>&raquo;</span></font> Tìm kiếm cuộc Thanh tra Kiểm tra</a> --> <a href="tim_kiem_cuoc_ttkt.do?act=timKiem"><font color="FF3600" size="2"><span>&raquo;</span></font> Tìm
			kiếm</a></li>
			<li><a href="tim_kiem_cuoc_ttkt.do?act=cbTienHanh"><font color="FF3600" size="2"><span>&raquo;</span></font> Chuẩn bị tiến hành </a></li>
			<li><a href="tim_kiem_cuoc_ttkt.do?act=tienhanh"><font color="FF3600" size="2"><span>&raquo;</span></font> Tiến hành</a></li>
			<li><a href="tim_kiem_cuoc_ttkt.do?act=ketthuc"><font color="FF3600" size="2"><span>&raquo;</span></font> Kết thúc</a></li>
			<li><a href="thong_ke_can_bo.do?method=view"><font color="FF3600" size="2"><span>&raquo;</span></font> Thống kê cán bộ</a></li>
		</ul>
		</td>
	</tr>
</TABLE>
<%@ include file="/bottom.jsp"%>