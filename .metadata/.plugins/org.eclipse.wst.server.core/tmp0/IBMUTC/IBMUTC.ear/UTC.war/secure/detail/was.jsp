<%@ page errorPage="/unsecure/error.jsp" import="com.ibm.etools.utc.Tree" contentType="text/html; charset=utf-8" %>
<jsp:useBean id="wasSupport" scope="session" class="com.ibm.etools.utc.was.WASClassLoaderSupport"/>
<%@ taglib uri="/utc" prefix="utc" %>

<% wasSupport.cacheTree(); %>

<table cellspacing=0 cellpadding=4 border=0 width=100%>
<form action="/UTC/classloader" method="post" enctype="multipart/form-data">
<tr>
  <td nowrap><label for="user"><utc:resource key="propertiesPageUser"/></label></td>
  <td width=30%><input type="text" id="user" class="textenter" name="user" value="<%= wasSupport.getUser() %>" size=30/></td>
  <td></td>
</tr>
<tr>
  <td nowrap><label for="password"><utc:resource key="propertiesPagePassword"/></label></td>
  <td><input type="password" id="password" class="textenter" name="password" value="<%= wasSupport.getPassword() %>" size=30/></td>
  <td><input type=submit value="<utc:resource key="propertiesPageSet"/>" class="button"/></td>
</tr>
</form>
</table>
<p/>

<b><utc:resource key="wasClasspath"/></b><br/>

<utc:resource key="wasClasspathDescription"/><br/>

<%= Tree.getTableTree(request, "details", "/secure/details.jsp", wasSupport.getClasspathTreeRoot()) %>

<p/>

<utc:resource key="wasOffClasspathDescription"/><br/>

<%= Tree.getTableTree(request, "details", "/secure/details.jsp", wasSupport.getOffClasspathTreeRoot()) %>

<p/>

<utc:resource key="propertiesPageStatus"/> <%= wasSupport.getStatus() %>

<p/>
<utc:resource key="wasClasspathDirections"/>
