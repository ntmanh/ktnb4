<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<% 
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies.
	cmc.com.ktnb.util.ApplicationContext ac=(cmc.com.ktnb.util.ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<HTA:APPLICATION ID="Ulti" APPLICATIONNAME="Ultimater" BORDER="thick" BORDERSTYLE="sunken" INNERBORDER="yes" CONTEXTMENU="yes" CAPTION="yes" MAXIMIZEBUTTON="yes" MINIMIZEBUTTON="yes" NAVIGABLE="no" SCROLL="yes" SCROLLFLAT="no" SELECTION="yes" SINGLEINSTANCE="no" SHOWINTASKBAR="yes"
	SINGLEINSTANCE="yes" SYSMENU="yes" WINDOWSTATE="normal">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<link rel="shortcut icon" type="image/ico" href="<html:rewrite page='/image/favicon.ico'/>" />
	<title>HỆ THỐNG KIỂM TRA NỘI BỘ</title>
	<link type="text/css" href="<html:rewrite page='/stylesheet/ktnb.css'/>" rel="stylesheet">
	<link type="text/css" href="<html:rewrite page='/stylesheet/base/jquery-ui.css'/>" rel="stylesheet">
	<!--  <link type="text/css" href="<html:rewrite page='/stylesheet/base/jquery.treeTable.css'/>" rel="stylesheet">	-->
	<link type="text/css" href="<html:rewrite page='/stylesheet/verticaltabs.css'/>" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="include/js/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="include/js/themes/icon.css">
	<link rel='stylesheet' type='text/css' href='extjs/resources/css/ext-all.css' />
	<link rel='stylesheet' type='text/css' href='extjs/xtheme-gray-extend.css' />
	<link rel='stylesheet' type='text/css' href='extjs/examples/ux/css/RowEditor.css' />
	<link rel='stylesheet' type='text/css' href='extjs/examples/ux/css/Spinner.css' />
	<link rel='stylesheet' type='text/css' href='extjs/examples/ux/statusbar/css/statusbar.css' />
	<link rel='stylesheet' type='text/css' href='extjs/superboxselect.css' />
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
	<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.pngFix.pack.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/js/pluginpage.js'/>"></script>
	<!-- <script type="text/javascript" src="<html:rewrite page='/include/nicEdit/nicEdit.js'/>"></script> -->
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
	<script>
	$(function() 
	{
		var readonly = '<%=request.getParameter("r") %>';
		if(readonly=='rol'){
			disableAllField();
			if(isExist('btnKetXuat'))
			document.getElementById('btnKetXuat').disabled = false;
			if(isExist('btnXem'))
			document.getElementById('btnXem').disabled = false;
			if(isExist('btnClose'))
			document.getElementById('btnClose').disabled = false;
			if(isExist('btnClose2'))
			document.getElementById('btnClose2').disabled = false;
			if(isExist('btnClose3'))
			document.getElementById('btnClose3').disabled = false;
		}	  	
		$('#container').pngFix( );
	});
  </script>
</head>
<body>
<div id="container">
<div id="topbar">
<div class="item"><a href="index.do" onclick="window.location='index.do';"><img src="image/home.png" alt="" />Trang chủ</a></div>
<div class="item"><a href="ftp://ftp.tct.vn/Public/VPTCT/KTNB/Tailieudaotao.rar"><img src="image/information.png" alt="" />Trợ giúp</a></div>
<div class="item"><a href="index_kntc.do"><img src="image/blogs.png" alt="" />Khiếu nại tố cáo</a></div>
<div class="item"><a href="ttkt_index.do"><img src="image/feed.png" alt="" />Thanh tra kiểm tra</a></div>
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