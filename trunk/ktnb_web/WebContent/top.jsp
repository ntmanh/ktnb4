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
	cmc.com.ktnb.util.ApplicationContext ac = (cmc.com.ktnb.util.ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
%>
<html>
<head>
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, no-store, must-revalidate">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
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
<script type='text/javascript' src='extjs/adapter/ext/ext-base.js'></script>
<script type='text/javascript' src='extjs/ext-all.js'></script>
<script type='text/javascript' src='extjs/examples/ux/SearchField.js'></script>
<script type='text/javascript' src='extjs/examples/ux/RowEditor.js'></script>
<script type='text/javascript' src='extjs/examples/ux/CheckColumn.js'></script>
<script type='text/javascript' src='extjs/examples/ux/Spinner.js'></script>
<script type='text/javascript' src='extjs/examples/ux/SpinnerField.js'></script>
<script type='text/javascript' src='extjs/examples/ux/statusbar/StatusBar.js'></script>
<script type='text/javascript' src='extjs/SuperBoxSelect.js'></script>
<script type='text/javascript' src='extjs/ext-ktnb.js'></script>
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
<body>
<div id="container">