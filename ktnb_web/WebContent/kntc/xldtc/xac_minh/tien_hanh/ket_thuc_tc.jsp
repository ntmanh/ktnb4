<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<html:form action="/kntc_kq_xm.do">
	<h3 class="Header">Báo cáo/Kết quả giải quyết hồ sơ tố cáo</h3>
	<html:hidden property="maHidden" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red">Số hồ sơ</font> <html:text property="maHoSo" styleClass="text" style="width:250px" readonly="true" /></div>
	<div id="super-tabs">
	<ul>
		<li><a href="#super-tab0" onclick="redirect('phieu_dxxl_kn.do?method=show&action=phanloaiHSTC&id=');"><span>PHÂN LOẠI ĐỀ XUẤT XỬ LÝ TỐ CÁO</span></a></li>
		<li><a href="#super-tab1" onclick="redirect('kntc_xac_minh.do?method=xacMinh&action=xacMinhToCao&id=');"><span>TIẾN HÀNH XÁC MINH</span></a></li>
		<li><a href="#super-tab2" onclick="redirect('kntc_kq_xm.do?method=ketThuc&action=ketThucToCao&id=');"><span>KẾT THÚC GIẢI QUYẾT</span></a></li>
	</ul>	
	<div id="super-tab0"></div>	
	<div id="super-tab1"></div>
	<div id="super-tab2">	
	<div id="tab_xac_minh" style="background-color: transparent; float: left;">
	<ul>
		<li><a href="#tab_bcxm" class="tabTitle">Kết luận nội dung TC - Mẫu 24/KNTC</a></li>
		<li><a href="#tab_qdgq" class="tabTitle">Thông báo kết quả giải quyết TC - Mẫu 26/KNTC</a></li>
		<li><a href="#tab_bckq" class="tabTitle">Báo cáo kết quả thực hiện giải quyết TC</a></li>
	</ul> 
	<div id="tab_bcxm"><jsp:include page="ket_luan_noi_dung_tc.jsp"></jsp:include></div>
	<div id="tab_qdgq"><jsp:include page="thong_bao_ket_qua_gqtc.jsp"></jsp:include></div>
	<div id="tab_bckq"><jsp:include page="bao_cao_ket_qua_giai_quyet_tc.jsp"></jsp:include></div>
	</div>	
	</div>
<jsp:include page="/kntc2/other_action/to_cao.jsp"></jsp:include>
</div>
</html:form>
<script type="text/javascript" charset="utf-8"> 
var super_tab;
$(function(){	
  super_tab=$("#super-tabs");
  super_tab.tabs();
  super_tab.tabs("select" , 2);
  var tab_select=jQuery.fn.readCookie("TABII");
  var tabOpts={selected:tab_select,select:function(event,tab){jQuery.fn.createCookie("TABII",tab.index);}}; 
  $("#tab_xac_minh").tabs(tabOpts);
  $("#tab_xac_minh").removeClass("ui-corner-all");
  $("#tab_xac_minh").children().removeClass("ui-corner-all");  
});
function openBm(link){
	link = link + '<%=request.getParameter("id")%>';
	openWindow(link,800,600,false);
}
</script>
<%@ include file="/bottom.jsp"%>