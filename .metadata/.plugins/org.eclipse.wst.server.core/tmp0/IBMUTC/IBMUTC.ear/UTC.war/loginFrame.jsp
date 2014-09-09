<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<!--
 Licensed Material - Property of IBM 
 (C) Copyright IBM Corp. 2008 - All Rights Reserved. 
 US Government Users Restricted Rights - Use, duplication or disclosure 
 restricted by GSA ADP Schedule Contract with IBM Corp. 
-->
<%@ page errorPage="/unsecure/error.jsp" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/utc" prefix="utc" %>
<jsp:useBean id="loginBean" class="com.ibm.etools.utc.LoginBean" scope="request" />
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <link rel="shortcut icon" href="/UTC/unsecure/images/websphere.ico" type="image/x-icon" />
    <title><utc:resource key="utcTitle"/></title>
  </head>
  <frameset rows="28,*" border="0">
    <frame name="globalnav" src="/UTC/unsecure/banner.jsp" marginwidth="0" marginheight="0" scrolling="no" noresize="noresize" />
    <frame name="details" src="/UTC/login?redirectUrl=<jsp:getProperty name="loginBean" property="url" />" marginwidth="0" marginheight="0" scrolling="auto" />
  </frameset>
</html>