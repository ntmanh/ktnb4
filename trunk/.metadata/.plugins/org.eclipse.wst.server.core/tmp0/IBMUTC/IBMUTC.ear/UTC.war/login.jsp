<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
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
	  <meta http-equiv="Content-Style-Type" content="text/css" />
	  <meta http-equiv="Pragma" content="no-cache" />
	  <meta http-equiv="Cache-Control" content="no-cache" />
	  <meta http-equiv="expires" content="0" />
      <link rel=stylesheet type="text/css" href="/UTC/unsecure/css/dynamic.css" />
      <link rel="shortcut icon" href="/UTC/unsecure/images/websphere.ico" type="image/x-icon" />
	  <title><utc:resource key="utcTitle"/></title>
	</head>
	<body class="loginBody">
	  <table border="0" cellpadding="5" cellspacing="0" width="100%" height="100%">
	    <tr>
	      <td align="left" width="100%">
            <!--   <form action="/UTC/j_security_check" method="post" target="_top" name="loginForm"> -->
            <form action="/UTC/authenticator" method="post" target="_top" name="loginForm">
              <input type="hidden" name="redirectUrl" value="<jsp:getProperty name="loginBean" property="url" />" />
              <table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%" class="loginTable">
                <tr> 
                  <th align="left" class="loginHeadText" width="100%" colspan="2">
                    <utc:resource key="loginMessage"/>
                  </th>
                </tr>
                <tr>
                  <td colspan="2" width="100%">
                    &nbsp;
                  </td>
                </tr>
                <tr> 
                  <td align="left" class="loginText" width="33%">
                    <label for="j_username"><utc:resource key="loginUserId"/></label>
                  </td>
                  <td width="66%">
                    &nbsp;
                  </td>
                </tr>
                <tr>
                  <td align="left" width="33%">
                    <input type="text" class="textenter" name="j_username" id="j_username" />
                  </td>
                  <td width="66%">
                    &nbsp;
                  </td>
                </tr>
                <tr>
                  <td align="left" class="loginText" width="33%">
                    <label for="j_password"><utc:resource key="loginPassword"/></label>
                   </td>
                  <td width="66%">
                    &nbsp;
                  </td>
                </tr>
                <tr>
                  <td align="left" width="33%">
                    <input type="password" class="textenter" name="j_password" id="j_password" />
                  </td>
                  <td width="66%">
                    &nbsp;
                  </td>
                </tr>
                <tr>
                  <td colspan="2" width="100%">
                    &nbsp;
                  </td>
                </tr>
                <tr>
                  <td align="center" class="loginText" width="33%">
                    <input class="loginSubmitButton" type="submit" name="submit" value="<utc:resource key="loginSubmitButton"/>" />
                  </td>
                  <td width="66%">
                    &nbsp;
                  </td>
                </tr>
              </table>
            </form>	      
	      </td>
	    </tr>
	  </table>
      <script type="text/javascript"> 
      <!--
        document.loginForm.j_username.focus();
      //-->
      </script>
	</body>
</html>