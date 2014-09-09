<%@ page errorPage="/unsecure/error.jsp" import="java.util.List,com.ibm.etools.utc.Tree,com.ibm.etools.utc.Resource,com.ibm.etools.utc.view.*,com.ibm.etools.utc.model.*" contentType="text/html; charset=utf-8" %>
<jsp:useBean id="parameterView" scope="session" class="com.ibm.etools.utc.view.ParameterView"/>
<jsp:useBean id="modelManager" scope="session" class="com.ibm.etools.utc.ClassModelManager"/>
<jsp:useBean id="resultView" scope="session" class="com.ibm.etools.utc.view.ResultView"/>
<jsp:useBean id="fieldView" scope="session" class="com.ibm.etools.utc.view.FieldView"/>
<%@ taglib uri="/utc" prefix="utc" %>

 <!-- *************** Results Section *************** -->

<a name="result"/>
<table cellpadding=1 cellspacing=0 width=100% border=0 class="results">
  <tr><td>
  <% if (resultView.isExpanded()) { %>
    <a href="/UTC/results?action=close&random=<%= Math.random() %>"><img src="/UTC/unsecure/images/twist_open.gif" width="11" height="10" border=0></a>
  <% } else { %>
    <a href="/UTC/results?action=open&random=<%= Math.random() %>"><img src="/UTC/unsecure/images/twist_close.gif" width="11" height="10" border=0></a>
  <% } %>
  <% if (!resultView.showSource()) { %>
    <utc:resource key="ejbPageParameterViewResults"/></td></tr>
  <% } else { %>
    <utc:resource key="ejbPageParameterViewSource"/> <img src="<%= resultView.getSourceImage() %>" width=16 height=16/><%= resultView.getSource() %>
  <% } %>
  </td></tr>
</table>
  
  <% if (resultView.isExpanded()) { %>

<!-- Result Page --->
<% if (resultView.isValid()) { %>

  <% if (resultView.isErrorResult()) { %>
    <font color=red><%= resultView.getError() %></font>
  <% } else if (resultView.isVoidResult()) { %>
    <utc:resource key="ejbPageResultViewVoid"/>
  <% } else if (resultView.isNullResult()) { %>
    <utc:resource key="ejbPageResultViewNull"/>
  <% } else if (resultView.isExceptionResult()) { %>
    <img src="/UTC/unsecure/images/error.gif" width=16 height=16 align="top"/>
    <%= resultView.getExceptionMessage() %>
  <% } else { %>
    <% if (resultView.getModel() instanceof ObjectModel) { %>
      <img src="/UTC/unsecure/images/object.gif" width=16 height=16 align="top"/>&nbsp;<%= resultView.getObjectValue() %>&nbsp;(<%= resultView.getModelFullName() %>)<p/>
    <% } else { %>
      <img src="/UTC/unsecure/images/class.gif" width=16 height=16 align="top"/>&nbsp;<%= resultView.getModelFullName() %>
    <% } %>
  <% } %>

  <% if (resultView.isExceptionResult() || resultView.isObjectResult()) { %>
    <% if (modelManager.contains(resultView.getModel())) { %>
      <utc:resource key="ejbPageResultViewInUse"/><p/>
    <% } else { %>
      <form name="work" action="/UTC/addObject" method="get" target="navigation">
      <input type="hidden" name="random" value="<%= Math.random() %>"/>
      <input type=submit value="<utc:resource key="ejbPageResultViewUse"/>" class="button"/>
      </form>
    <% } %>
    
    <% if (resultView.isCollection()) { %>
      <form name="workAll" action="/UTC/addAllObjects" method="get" target="navigation">
      <input type="hidden" name="random" value="<%= Math.random() %>"/>
      <input type=submit value="<utc:resource key="ejbPageResultViewUseAll"/>" class="longbutton"/>
      </form>
    <% } %>
    <% if (resultView.getModel() instanceof ObjectModel) { %>
      <% fieldView.cacheFieldsTree(modelManager); %>
      <%= Tree.getTableTree(request, "_self", "/secure/details.jsp", fieldView.getFieldsTreeRoot()) %>
    <% } %>
  <% } %>

  <% if (resultView.isExceptionResult()) { %>
    <pre class="exception"><% resultView.printException(out); %></pre>
  <% } %>

<% } else { %>
  <utc:resource key="ejbPageResultViewInvalid"/>
<% } %>

<% } %>