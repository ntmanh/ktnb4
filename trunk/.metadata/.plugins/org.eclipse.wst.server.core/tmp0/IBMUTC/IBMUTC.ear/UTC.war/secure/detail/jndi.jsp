<%@ page errorPage="/unsecure/error.jsp" import="com.ibm.etools.utc.Tree" contentType="text/html; charset=utf-8" %>
<jsp:useBean id="jndiView" scope="session" class="com.ibm.etools.utc.view.JNDIView"/>
<%@ taglib uri="/utc" prefix="utc" %>

<form action="/UTC/jndiLookup" method="post" target="_parent" enctype="multipart/form-data">
<input type="hidden" name="random" value="<%= Math.random() %>"/>

<table cellpadding=4 cellspacing=0 border=0 width=100%>
<tr>
  <td width=15% nowrap><label for="name"><utc:resource key="jndiLookupPageJNDIName"/></label></td>
  <td width=*><input type="text" name="name" id="name" value="" class="textenter" size=50/></td>
  <td width=20%><input type=submit class="button" value="<utc:resource key="jndiLookupPageLookup"/>"/></td>
</tr>

<% if (jndiView.isError()) { %>
<tr>
  <td valign=top><utc:resource key="jndiLookupPageError"/></td>
  <td colspan=2><img src="/UTC/unsecure/images/error.gif" width=16 height=16><span class=error><%= jndiView.getError() %></span></td>
</tr>
<% } %>

</table>
</form>

<% jndiView.cacheJNDINamespace(request, application); %>

<%= Tree.getTableTree(request, "details", "/secure/details.jsp", jndiView.getJNDIRoot()) %>