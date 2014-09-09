<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
 Licensed Material - Property of IBM 
 (C) Copyright IBM Corp. 2008 - All Rights Reserved. 
 US Government Users Restricted Rights - Use, duplication or disclosure 
 restricted by GSA ADP Schedule Contract with IBM Corp. 
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	  <table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">
	    <tr>
	      <td align="left" width="100%">
		    <form action="/UTC/loginFrame" method="post" target="_top" name="loginFormError">
              <input type="hidden" name="redirectUrl" value="<jsp:getProperty name="loginBean" property="url" />" />
		      <table>
                <tr>
                  <td width="100%">
                    &nbsp;
                  </td>
                </tr>
                <tr>
                  <td width="100%">
                    &nbsp;
                  </td>
                </tr>
		        <tr>
		          <td width="100%">
		            <img alt="<utc:resource key="loginFailed" />" align="baseline" height="16" width="16" src="/UTC/unsecure/images/error.gif" /><utc:resource key="loginFailed" />
		          </td>
		        </tr>
                <tr>
                  <td width="100%">
                    &nbsp;
                  </td>
                </tr>
		        <tr>
		          <td width="100%">
        	        <input type="submit" name="submitButton" class="loginSubmitButton" alt="<utc:resource key="loginFailedButton" />" value="<utc:resource key="loginFailedButton" />" />
		          </td>
		        </tr>
		      </table>
		    </form>
		  </td>
	  </table>
      <script type="text/javascript"> 
      <!--
        document.loginFormError.submitButton.focus();
      //-->
      </script>
	</body>
</html>