<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="cmc.com.ktnb.util.KtnbUtil" %> 
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	cmc.com.ktnb.util.ApplicationContext ac = (cmc.com.ktnb.util.ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
	if (ac == null) {
%>
<jsp:forward page="login.do" />
<%}%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, no-store, must-revalidate">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<link rel="shortcut icon" type="image/ico" href="<html:rewrite page='/image/favicon.ico'/>" />
<title>HỆ THỐNG KIỂM TRA NỘI BỘ</title>
<link type="text/css" href="<html:rewrite page='/stylesheet/ktnb.css'/>" rel="stylesheet">
<link type="text/css" href="<html:rewrite page='/stylesheet/base/jquery-ui.css'/>" rel="stylesheet">
<!--  <link type="text/css" href="<html:rewrite page='/stylesheet/base/jquery.treeTable.css'/>" rel="stylesheet">	-->
<link type="text/css" href="<html:rewrite page='/stylesheet/verticaltabs.css'/>" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="include/js/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="include/js/themes/icon.css">
<script type="text/javascript" src="<html:rewrite page='/include/js/jquery-1.4.2.min.js'/>"></script>
<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.easyui.min.js'/>"></script>
<script type="text/javascript" src="<html:rewrite page='/include/js/jquery-ui-1.8.2.custom.min.js'/>"></script>
<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.dataTables.min.js'/>"></script>
<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.jeditable.mini.js'/>"></script>
<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.ui.datepicker-vi.min.js'/>"></script>
<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.jixedbar.js'/>"></script>
<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.hotkeys.js'/>"></script>
<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.treeTable.js'/>"></script>
<script type="text/javascript" src="<html:rewrite page='/include/js/ktnb.js'/>"></script>
<script type="text/javascript" src="<html:rewrite page='/include/js/datatable.util.js'/>"></script>
<script type="text/javascript" src="<html:rewrite page='/include/js/date.format.js'/>"></script>
<script type="text/javascript" src="<html:rewrite page='/include/js/verticaltabs.js'/>"></script>
<script type="text/javascript" src="<html:rewrite page='/include/js/verticaltabs.pack.js'/>"></script>
<link rel='stylesheet' type='text/css' href='extjs/resources/css/ext-all.css' />
<link rel='stylesheet' type='text/css' href='extjs/xtheme-gray-extend.css' />
<link rel='stylesheet' type='text/css' href='extjs/examples/ux/css/RowEditor.css' />
<link rel='stylesheet' type='text/css' href='extjs/examples/ux/css/Spinner.css' />
<link rel='stylesheet' type='text/css' href='extjs/examples/ux/statusbar/css/statusbar.css' />
<link rel='stylesheet' type='text/css' href='extjs/superboxselect.css' />
<script type='text/javascript' src='extjs/adapter/ext/ext-base-debug.js'></script>
<script type='text/javascript' src='extjs/ext-all-debug.js'></script>
<script type='text/javascript' src='extjs/examples/ux/SearchField.js'></script>
<script type='text/javascript' src='extjs/examples/ux/RowEditor.js'></script>
<script type='text/javascript' src='extjs/examples/ux/CheckColumn.js'></script>
<script type='text/javascript' src='extjs/examples/ux/Spinner.js'></script>
<script type='text/javascript' src='extjs/examples/ux/SpinnerField.js'></script>
<script type='text/javascript' src='extjs/examples/ux/statusbar/StatusBar.js'></script>
<script type='text/javascript' src='extjs/SuperBoxSelect.js'></script>
<script type='text/javascript' src='extjs/ext-ktnb.js'></script>
<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.pngFix.pack.js'/>"></script>
<script type="text/javascript" src="<html:rewrite page='/include/js/pluginpage.js'/>"></script>
<script>
		var cuc=<%=ac.getCuc()%>;
		var tenNsd="<%=ac.getTenNsd()%>";
		var tenPhong="<%=ac.getTenPhong()%>";
		var tenCqt="<%=ac.getTenCqt()%>";
		var tenCuc="<%=ac.getTenCuc()%>";
		var maPhong="<%=ac.getMaPhong()%>";
		var maCqt="<%=ac.getMaCqt()%>";
		var maCuc="<%=ac.getMaCuc()%>";
	</script>
</head>
<body style="text-align: center;">
<div id="container"><script>
$(function() 
{
  //$("#ktnb-bar").jixedbar();
  //$("#text_display").html(day+","+date_transaction);
  $('#container').pngFix( );
});
</script>
<div id="topbar">     
<div class="item"><a href="index.do" onclick="window.location='index.do';"><img src="image/home.png" alt="" />Trang chủ</a></div>
<div class="item"><a href="ftp://ftp.tct.vn/Public/VPTCT/KTNB/Tailieudaotao.rar"><img src="image/information.png" alt="" />Trợ giúp</a></div>
<div class="item"><a href="index_kntc.do"><img src="image/blogs.png" alt="" />Khiếu nại tố cáo</a></div>
<div class="item"><a href="ttkt_index.do"><img src="image/feed.png" alt="" />Kiểm tra nội bộ</a></div>
<div class="item"><a href="index_report.do"><img src="image/report2.png" alt="" />Báo cáo</a></div>
<div class="item"><a href="index_ttcp.do"><img src="image/report2.png" alt="" />Báo cáo TTCP</a></div>
<div class="item"><a href="index_system.do"><img src="image/system.png" alt="" />Hệ thống</a></div>
<div class="item"><a href="pass.do"><img src="image/password.png" alt="" />Đổi MK</a></div>
<div class="item"><a href="thoat.do" onclick="window.location='thoat.do';"><img src="image/exit.png" alt="" />Thoát</a></div>
</div>
<div id="logo">
<div id="loginStatus"><b>CÁN BỘ:</b> <%=ac.getTenCanbo()%> - <b>NƠI CÔNG TÁC:</b> <%=ac.getTenPhong()%> - <%=ac.getTenCqt()%></div>
</div>
<div id="content">
<% if(KtnbUtil.isTongCuc(ac)) { %>
<table align="center" width="100%" cellpadding="10"> 
	<tr>
		<td valign="top" align="left" width="50%" style="padding-left: 75px;">
		<UL class="liMenu">
			<li><a href="danh_muc_chung.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Danh mục chung</a></li>
			<li><a href="danh_muc_can_bo.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Danh mục cán bộ</a></li>
			<li><a href="danh_muc_phong_ban.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Danh mục phòng ban</a></li>		
			<li><a href="danh_muc_thoi_han.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Danh mục thời hạn</a></li>
		</UL>
		</td>
		<td valign="top" align="left" width="50%" style="padding-left: 75px;">
		<ul class="liMenu">
			<li><a href="danh_muc_cqt.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Danh mục cơ quan thuế</a></li>
			<li><a href="danh_muc_ngay_nghi.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Danh mục ngày nghỉ </a></li>
			<li><a href="dong_bo_so_lieu.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Đồng bộ số liệu</a></li>
		</ul>
		</td>
	</tr>
</table>
<% }%>
<% if(!KtnbUtil.isTongCuc(ac)) { %>
<table align="center" width="100%" cellpadding="10">
	<tr>
		<td valign="top" align="left" width="50%" style="padding-left: 75px;">
		<UL class="liMenu">			
			<li><a href="danh_muc_can_bo.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Danh mục cán bộ</a></li>
			<!-- <li><a href="danh_muc_chung.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Danh mục chung</a></li>
			<li><a href="danh_muc_thoi_han.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Danh mục thời hạn</a></li> -->
		</UL>
		</td>
		<td valign="top" align="left" width="50%" style="padding-left: 75px;">
		<ul class="liMenu">
			<li><a href="danh_muc_phong_ban.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Danh mục phòng ban</a></li>	
			<!-- <li><a href="danh_muc_cqt.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Danh mục cơ quan thuế</a></li>
			<li><a href="danh_muc_ngay_nghi.do"><font color="FF3600" size="2"><span>&raquo;</span></font> Danh mục ngày nghỉ </a></li> -->	
		</ul>
		</td>
	</tr>
</table>
<% }%>
 <%@ include file="/bottom.jsp"%>