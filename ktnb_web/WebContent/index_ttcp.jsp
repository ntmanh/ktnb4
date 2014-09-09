<%@page pageEncoding="UTF-8"%>    
<%@ include file="/top_bar.jsp"%>
<%@ page import="cmc.com.ktnb.util.KtnbUtil" %> 
<TABLE align="left" width="100%">  
	<tr>		
		<td valign="top" align="left" width="43%">
		<ul class="liMenu">
			<li><b>BÁO CÁO KNTC</b></li>
			<li><a href="bc2a.do?method=show"><font color="FF3600"><span>&raquo;</span></font>Số liệu bổ sung cho BC 2A/KNTC</a></li>
			<li><a href="bc2b.do?method=show"><font color="FF3600"><span>&raquo;</span></font>Số liệu bổ sung cho BC 2B/KNTC</a></li>
			<li><a href="bc2c.do?method=show"><font color="FF3600"><span>&raquo;</span></font>Số liệu bổ sung cho BC 2C/KNTC</a></li>
			<li><a href="bc2d.do?method=show"><font color="FF3600"><span>&raquo;</span></font>Số liệu bổ sung cho BC 2D/KNTC</a></li>
			<li><a href="bc2dd.do?method=show"><font color="FF3600"><span>&raquo;</span></font>Số liệu bổ sung cho BC 2Đ/KNTC</a></li>
		</ul>
		</td>
		<td valign="top" align="left" width="57%">
		<UL class="liMenu">
			<li>&nbsp</li>
			<li><a href="kntc_rp.do?method=bc2a"><font color="FF3600"><span>&raquo;</span></font>Tổng hợp kết quả công tác tiếp dân - Mẫu số 2A/KNTC</a></li>
			<li><a href="kntc_rp.do?method=bc2b"><font color="FF3600"><span>&raquo;</span></font>Tổng hợp kết quả xử lý đơn thư KNTC - Mẫu số 2B/KNTC</a></li>
			<li><a href="kntc_rp.do?method=bc2c"><font color="FF3600"><span>&raquo;</span></font>Tổng hợp kết quả giải quyết đơn khiếu nại - Mẫu số 2C/KNTC</a></li>
			<li><a href="kntc_rp.do?method=bc2d"><font color="FF3600"><span>&raquo;</span></font>Tổng hợp kết quả giải quyết đơn tố cáo - Mẫu số 2D/KNTC</a></li>
			<li><a href="kntc_rp.do?method=bc2dd"><font color="FF3600"><span>&raquo;</span></font>Công tác quản lý nhà nước về KNTC - Mẫu số 2Đ/KNTC</a></li>
		</UL>
		</td>		
	</tr>
	<tr>	
		<td valign="top" align="left" width="43%">
		<ul class="liMenu">			
			<li><b>BÁO CÁO TTKT</b></li>
			<li><a href="bc1a.do?method=show"><font color="FF3600"><span>&raquo;</span></font>Số liệu bổ sung cho BC 1A/TTNB</a></li>	
			<li><a href="bc1b.do?method=show"><font color="FF3600"><span>&raquo;</span></font>Số liệu bổ sung cho BC 1B/TTNB</a></li>		
		</ul>
		</td>	
		<td valign="top" align="left" width="57%">
		<UL class="liMenu">		
			<li>&nbsp</li>	
			<li><a href="kntc_rp.do?method=bc1a"><font color="FF3600"><span>&raquo;</span></font>Báo cáo kết quả công tác kiểm tra nội bộ ngành - Mẫu số 1A/TTNB</a></li>	
			<li><a href="kntc_rp.do?method=bc1b"><font color="FF3600"><span>&raquo;</span></font>Báo cáo công tác quản lý nhà nước về KTNB - Mẫu số 1B/TTNB</a></li>	
		</UL>
		</td>		
	</tr>
</TABLE>
<%@ include file="/bottom.jsp"%>