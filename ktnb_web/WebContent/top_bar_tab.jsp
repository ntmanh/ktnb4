<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page pageEncoding="UTF-8"%>
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
<HTA:APPLICATION ID="Ulti" APPLICATIONNAME="Ultimater" BORDER="thick" BORDERSTYLE="sunken" INNERBORDER="yes" CONTEXTMENU="yes" CAPTION="yes" MAXIMIZEBUTTON="yes" MINIMIZEBUTTON="yes" NAVIGABLE="no" SCROLL="yes" SCROLLFLAT="no" SELECTION="yes" SINGLEINSTANCE="no" SHOWINTASKBAR="yes"
	SINGLEINSTANCE="yes" SYSMENU="yes" WINDOWSTATE="normal">
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
	<script type="text/javascript" src="<html:rewrite page='/include/js/jquery.pngFix.pack.js'/>"></script>
	<script type="text/javascript" src="<html:rewrite page='/include/js/pluginpage.js'/>"></script>
	<!-- <script type="text/javascript" src="<html:rewrite page='/include/nicEdit/nicEdit.js'/>"></script> -->
	<script type="text/javascript" src="<html:rewrite page='/include/js/FixedColumn.js'/>"></script>
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
<div id="container_tab">
<div id="content_tab">