<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies.
	cmc.com.ktnb.util.ApplicationContext ac=(cmc.com.ktnb.util.ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
	if (ac==null){
%>
<jsp:forward page="login.do" />
<%}%>
<html>
<head>
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, no-store, must-revalidate">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>HỆ THỐNG KIỂM TRA NỘI BỘ</title>
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