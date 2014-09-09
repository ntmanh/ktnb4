<%@ page pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="cmc.com.ktnb.util.URLUTF8Encoder"%>
<html>
<body>
<%
  String errCode= URLUTF8Encoder.encode((String)  request.getAttribute("errCode")); 
  String errCodeCause = URLUTF8Encoder.encode((String)request.getAttribute("errCodeCause"));
  String errCodeAction = URLUTF8Encoder.encode((String)request.getAttribute("errCodeAction"));
%>
<script language="javascript">
    window.showModalDialog("<html:rewrite page='/error/show_error.jsp'/>?errCode=<%=errCode%>&errCodeCause=<%=errCodeCause%>&errCodeAction=<%=errCodeAction%>","","dialogHeight:200px;dialogWidth:450 px;status:no;");
    history.back();
</script>
</body>
</html>

