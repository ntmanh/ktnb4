<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<!--
 Licensed Material - Property of IBM 
 (C) Copyright IBM Corp. 2001 - All Rights Reserved. 
 US Government Users Restricted Rights - Use, duplication or disclosure 
 restricted by GSA ADP Schedule Contract with IBM Corp. 
-->

<%@ page errorPage="/unsecure/error.jsp" import="com.ibm.etools.utc.view.Toolbar" contentType="text/html; charset=utf-8" %>
<jsp:useBean id="toolbar" scope="session" class="com.ibm.etools.utc.view.Toolbar"/>
<%@ taglib uri="/utc" prefix="utc" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel=stylesheet type="text/css" href="/UTC/unsecure/css/dynamic.css">
  <link rel="shortcut icon" href="/UTC/unsecure/images/websphere.ico" type="image/x-icon" />
  <title><utc:resource key="detailsTitle"/></title>
</head>

<body class="details">

<%
   if (toolbar == null)
     toolbar = new Toolbar();
   int pg = toolbar.getPage();
   try {
     pg = Integer.parseInt(request.getParameter("page"));
     toolbar.setPage(pg);
   } catch (Exception e) { }
   session.setAttribute("toolbar", toolbar);
%>

<table width="100%" cellpadding="0" cellspacing="0" border="0" class="toolbar2">
<tr>
<td valign="middle" align="left" height="16" class="toolbar2" nowrap><%= Toolbar.getTitle(pg) %></td>
<td valign="middle" align="center" width="*">&nbsp;</td>

<%= Toolbar.getExtraToolbarItems(request, pg) %>

<td valign="middle" align="center" width="10">&nbsp;</td>
</tr>
</table>

<jsp:include page="<%= Toolbar.getPage(pg) %>" flush="true"/>

</body>
</html>