<%@ page errorPage="/unsecure/error.jsp" import="java.util.List,com.ibm.etools.utc.Tree,com.ibm.etools.utc.Resource,com.ibm.etools.utc.view.*,com.ibm.etools.utc.model.*" contentType="text/html; charset=utf-8" %>
<jsp:useBean id="parameterView" scope="session" class="com.ibm.etools.utc.view.ParameterView"/>
<jsp:useBean id="modelManager" scope="session" class="com.ibm.etools.utc.ClassModelManager"/>
<jsp:useBean id="resultView" scope="session" class="com.ibm.etools.utc.view.ResultView"/>
<%@ taglib uri="/utc" prefix="utc" %>

<% parameterView.loadManagerObjects(modelManager);
  parameterView.loadManagerClasses(modelManager); %>

<% if (parameterView.isJNDIObjectView()) { %>
<!-- *************** JNDI Object view *************** -->
<% if (parameterView.isTransactionCurrent()) { %>

<% TransactionObject transaction = (TransactionObject) parameterView.getCurrent(); %>

<br>
<b><utc:resource key="jndiObjectsPageTransactionStatus"/></b> <%= transaction.getStatus() %>
<p>

<table cellpadding=3 cellspacing=0 border=0>
<tr>
<% if (transaction.showBeginAction()) { %>
<form action="/UTC/userTransaction" method="get">
  <td><input type=hidden name="action" value="begin">
  <input type=submit value="<utc:resource key="jndiObjectsPageTransactionBegin"/>" id="begin" class="button"></td>
</form>

<% } %>

<% if (transaction.showStateActions()) { %>
<form action="/UTC/userTransaction" method="get">
  <td><input type=hidden name="action" value="commit">
  <input type=submit value="<utc:resource key="jndiObjectsPageTransactionCommit"/>" id="commit" class="button"></td>
</form>
<p>
<form action="/UTC/userTransaction" method="get">
  <td>
    <input type=hidden name="action" value="rollback">
    <input type=submit value="<utc:resource key="jndiObjectsPageTransactionRollback"/>" id="rollback" class="button">
  </td>
</form>
<p>
<form action="/UTC/userTransaction" method="get">
  <td><input type=hidden name="action" value="rollbackOnly">
  <input type=submit value="<utc:resource key="jndiObjectsPageTransactionRollbackOnly"/>" id="rollbackonly" class="button"></td>
</form>

<% } %>
</tr>
</table>

<% } else if (parameterView.isDataSourceCurrent()) { %>

<% DataSourceObject dataSource = (DataSourceObject) parameterView.getCurrent(); %>

<div class="datasource">
<table cellpadding=3 cellspacing=0 border=0>
<tr>
  <td><utc:resource key="jndiObjectsPageDataSourceDriver"/></td>
  <td><%= dataSource.getDatabaseProductName() %>, <%= dataSource.getDatabaseProductVersion() %></td>
</tr>
<tr class="alternating">
  <td><utc:resource key="jndiObjectsPageDataSourceDriver"/></td>
  <td><%= dataSource.getDriverName() %>, <%= dataSource.getDriverVersion() %></td>
</tr>
<tr>
  <td><utc:resource key="jndiObjectsPageDataSourceUser"/></td>
  <td><%= dataSource.getUserName() %></td>
</tr>
<tr class="alternating">
  <td><utc:resource key="jndiObjectsPageDataSourceMaxConnections"/></td>
  <td><%= dataSource.getMaxConnections() %></td>
</tr>
<tr>
  <td><utc:resource key="jndiObjectsPageDataSourceURL"/></td>
  <td><%= dataSource.getURL() %></td>
</tr>
</table>
</div>

<% } else { %>
  <utc:resource key="jndiObjectsPageInvalid"/>
<% } %>

<% } else { %>
<!-- *************** Constructor/Method Invocation *************** -->
<div class="parameterPage">
<% if (parameterView.isValid()) { 
String form = parameterView.getHTMLForm(modelManager);
%>
<%=form%>

<% } %>

<% } %>

<jsp:include page="results.jsp" flush="true"/>
