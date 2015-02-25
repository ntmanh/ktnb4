<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<html:form action="/kntc_xac_minh.do">
<h3 class="Header">Xác minh hồ sơ khiếu nại</h3> 
	<div style="text-align: center;"><font style="font-size: 14px; color: red">Số hồ sơ</font> <html:text property="maHoSo" name="xacMinhForm" styleClass="text" style="width:250px" readonly="true" /></div>
	<div id="super-tabs">
	<ul>
		<li><a href="#super-tab0" onclick="redirect('phieu_dxxl_kn.do?method=show&action=phanloaiHSKN&id=');"><span>PHÂN LOẠI ĐỀ XUẤT XỬ LÝ KN</span></a></li>
		<li><a href="#super-tab1" onclick="redirect('kntc_xac_minh.do?method=xacMinh&action=xacMinhKhieuNai&id=');"><span>TIẾN HÀNH XÁC MINH</span></a></li>
		<li><a href="#super-tab2" onclick="redirect('kntc_kq_xm.do?method=ketThuc&action=ketThucKhieuNai&id=');"><span>KẾT THÚC GIẢI QUYẾT</span></a></li>
	</ul>	
	<div id="super-tab0"></div>
	<div id="super-tab1">		
	<div id="tab_xac_minh" style="background-color: transparent; float: left;">
	<ul>
		<li><a href="#tab_qdxm" class="tabTitle">Quyết định xác minh - Mẫu 06/KN</a></li> 
		<li><a href="#tab_khxm" class="tabTitle">Kế hoạch xác minh - Mẫu 07/KN</a></li>
		<!--
		<li><a href="#tab_kqxm" class="tabTitle">Báo cáo kết quả xác minh - Mẫu 15/KN</a></li>
		-->
	</ul>
	<div id="tab_qdxm"><jsp:include page="xm_quyet_dinh.jsp"></jsp:include></div> 
	<div id="tab_khxm"><jsp:include page="ke_hoach.jsp"></jsp:include></div>
	
	
	<jsp:include page="/kntc2/other_action/mau_phu_xm_kn.jsp"></jsp:include>
	</div>
<div id="super-tab2"></div>
<jsp:include page="/kntc2/other_action/khieu_nai.jsp"></jsp:include>
</div>
</html:form>
<script type="text/javascript" charset="utf-8"> 
var super_tab;
$(function()
{
  super_tab=$("#super-tabs");
  super_tab.tabs();
  super_tab.tabs("select" , 1);
  var tab_select=jQuery.fn.readCookie("TABII");
  if(tab_select==null)
  	tab_select = 0;
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