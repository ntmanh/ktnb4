<%@ page errorPage="/unsecure/error.jsp" import="java.util.List,com.ibm.etools.utc.Tree,com.ibm.etools.utc.Resource,com.ibm.etools.utc.view.*,com.ibm.etools.utc.model.*" contentType="text/html; charset=utf-8" %>
<jsp:useBean id="hierarchyView" scope="session" class="com.ibm.etools.utc.view.HierarchyView"/>
<jsp:useBean id="modelManager" scope="session" class="com.ibm.etools.utc.ClassModelManager"/>
<%@ taglib uri="/utc" prefix="utc" %>

<utc:resource key="ejbPageParameterVisibility"/> <%= hierarchyView.getHierarchyClassFullName() %><br>

<form action="/UTC/setHierarchy" target="navigation" method="post" enctype="multipart/form-data">
<input type="hidden" name="random" value="<%= Math.random() %>"/>

<div class="hierarchy">
<table cellpadding=3 cellspacing=0 border=0 width=100%>

<tr>
  <td colspan="2" class="line"><utc:resource key="ejbPageParameterVisibilitySuperclasses"/></td>
</tr>
<%= hierarchyView.getHierarchySuperclassForm() %>

<tr><td height=20></td></tr>

<tr>
  <td colspan="2" class="line"><utc:resource key="ejbPageParameterVisibilitySuperinterfaces"/></td>
</tr>
<%= hierarchyView.getHierarchyInterfaceForm() %>

</table>
</div>
<br>

<input type=submit value="<utc:resource key="ejbPageParameterVisibilitySet"/>" class="button"/>

</form>