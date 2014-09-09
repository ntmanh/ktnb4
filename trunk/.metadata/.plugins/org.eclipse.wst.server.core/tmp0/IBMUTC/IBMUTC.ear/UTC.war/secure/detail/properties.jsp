<%@ page errorPage="/unsecure/error.jsp" import="java.util.Properties,java.util.Iterator" contentType="text/html; charset=utf-8" %>
<jsp:useBean id="jndiInfo" scope="session" class="com.ibm.etools.utc.view.JNDIInfo"/>
<%@ taglib uri="/utc" prefix="utc" %>

<table cellspacing=0 cellpadding=4 border=0 width=100%>
<form action="/UTC/jndiProperties" method="post" enctype="multipart/form-data">
<input type="hidden" name="random" value="<%= Math.random() %>"/>
<input type="hidden" name="action" value="set"/>
<tr valign="top">
  <td nowrap><label for="factory"><utc:resource key="propertiesPageInitialFactory"/></label><br/><span class="info">(INITIAL_CONTEXT_FACTORY)</span></td>
  <td width=40%><input type="text" id="factory" class="textenter" name="initialFactory" value="<%= jndiInfo.getInitialContextFactory() %>" size=50/></td>
  <td></td>
</tr>
<tr>
  <td nowrap><label for="url"><utc:resource key="propertiesPageProviderURL"/></label><br/><span class="info">(PROVIDER_URL)</span></td>
  <td><input type="text" id="url" class="textenter" name="providerURL" value="<%= jndiInfo.getProviderURL() %>" size=50/></td>
  <td></td>
</tr>
<tr>
  <td nowrap><label for="user"><utc:resource key="propertiesPageUser"/></label><br/><span class="info">(SECURITY_PRINCIPAL)</span></td>
  <td><input type="text" id="user" class="textenter" name="user" value="<%= jndiInfo.getUser() %>" size=30/></td>
  <td></td>
</tr>
<tr>
  <td nowrap><label for="password"><utc:resource key="propertiesPagePassword"/></label><br/><span class="info">(SECURITY_CREDENTIALS)</span></td>
  <td><input type="password" id="password" class="textenter" name="password" value="<%= jndiInfo.getPassword() %>" size=30/></td>
  <td><input type=submit value="<utc:resource key="propertiesPageSet"/>" class="button"/></td>
</tr>
</form>
<% String message = jndiInfo.getMessage();
  if (message != null) { %>
<tr>
  <td><utc:resource key="propertiesPageStatus"/></td>
</tr>
<tr>
  <td colspan=3><%= message %></td>
</tr>
<% } %>


<tr><td height=30></td></tr>
<tr>
  <td colspan="3" class="line"><utc:resource key="propertiesPageAdditionalProperties"/></td>
</tr>

<tr>
  <form action="/UTC/jndiProperties" method="post" enctype="multipart/form-data">
  <input type="hidden" name="random" value="<%= Math.random() %>"/>
  <input type="hidden" name="action" value="add"/>
  <td width=30%><label for="nameentry"><utc:resource key="propertiesPageName"/></label>&nbsp;<input type="text" id="nameentry" name="property" class="textenter2"/></td>
  <td width=30%><label for="valueentry"><utc:resource key="propertiesPageValue"/></label>&nbsp;<input type="text" id="valueentry" name="value" class="textenter2"/></td>
  <td><input type=submit value="<utc:resource key="propertiesPageAdd"/>" class="button"/></td>
  </form>
</tr>

<% Properties p = jndiInfo.getAdditionalProperties(); 
Iterator iterator = p.keySet().iterator(); 
while (iterator.hasNext()) {
  String property = (String) iterator.next();
  String value = p.getProperty(property); %>

<tr>
  <form action="/UTC/jndiProperties" method="post" enctype="multipart/form-data">
  <input type="hidden" name="random" value="<%= Math.random() %>"/>
  <input type="hidden" name="action" value="remove"/>
  <input type="hidden" name="property" value="<%= property %>"/>
  <td><%= property %></td>
  <td><%= value %></td>
  <td><input type=submit value="<utc:resource key="propertiesPageRemove"/>" class="button"/></td>
  </form>
</tr>
<% } %>

<% String message2 = jndiInfo.getMessage2();
  if (message2 != null) { %>
<tr>
  <td><utc:resource key="propertiesPageStatus"/></td>
</tr>
<tr>
  <td colspan=3><%= message2 %></td>
</tr>
<% } %>

</table>