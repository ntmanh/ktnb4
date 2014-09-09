<%@ page pageEncoding="UTF-8"%> 
<%@ include file="/top_bar.jsp"%>
<div id="tab_kntc" style="background-color: transparent">
<ul>
	<li><a href="#tab_bc_kntc"><b>Báo cáo KNTC</b></a></li>
	<li><a href="#tab_bc_ttkt"><b>Báo cáo TTKT</b></a></li>
</ul>
<div id="tab_bc_kntc">
<ul class="liMenu">
	<li><img src="images/icons/report1.png" /><a href="kntc_rp.do?method=bc28">Báo cáo tổng hợp kết quả công tác tiếp dân và quản lý nhà nước về KNTC - Mẫu số 28/BC/KNTC</a></li>
	<li><img src="images/icons/report1.png" /><a href="kntc_rp.do?method=bcKn">Báo cáo tổng hợp kết quả giải quyết đơn KN - Mẫu số 29/BC/KNTC</a></li>
	<li><img src="images/icons/report1.png" /><a href="kntc_rp.do?method=bcKnNd">Báo cáo tổng hợp đơn KN theo nội dung - Mẫu số 29C/BC/KNTC</a></li>
	<li><img src="images/icons/report1.png" /><a href="kntc_rp.do?method=bcTc">Báo cáo tổng hợp kết quả giải quyết đơn TC - Mẫu số 30/BC/KNTC</a></li>
	<li><img src="images/icons/report1.png" /><a href="kntc_rp.do?method=bcTcNd">Báo cáo tổng hợp đơn Tố cáo theo nội dung - Mẫu số 30C/BC/KNTC</a></li>
</ul>
</div>
<div id="tab_bc_ttkt">
<ul class="liMenu">
	<li><img src="images/icons/report3.png" /><a href="kntc_rp.do?method=bcTtKt&tenBc=bctt02">Báo cáo kế hoạch Thanh tra, Kiểm tra nội bộ ngành - Mẫu số 02/TTNB</a></li>
	<li><img src="images/icons/report3.png" /><a href="kntc_rp.do?method=bcTtKt">Báo cáo công tác Thanh tra, Kiểm tra nội bộ ngành - Mẫu số 43/TTNB</a></li>
	<li><img src="images/icons/report3.png" /><a href="kntc_rp.do?method=bcTtKt43E">Báo cáo thực hiện kế hoạch Thanh tra, Kiểm tra nội bộ theo nội dung – Mẫu 43E</a></li>
	<li><img src="images/icons/report3.png" /><a href="kntc_rp.do?method=bcTtKt&tenBc=bctt43f">Báo cáo thống kê cán bộ – Mẫu 43F</a></li>	
</ul>
</div>
</div>
<script>
$(function()
{
  var tab_select=jQuery.fn.readCookie("TABI");
  var tabOpts={selected:tab_select,select:function(event,tab){jQuery.fn.createCookie("TABI",tab.index);}}; 
  $("#tab_kntc").tabs(tabOpts);
  $("#tab_kntc").removeClass("ui-corner-all");
  $("#tab_kntc").children().removeClass("ui-corner-all");
});
</script>
<%@ include file="/bottom.jsp"%>