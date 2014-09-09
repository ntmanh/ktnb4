
<%@ page errorPage="/unsecure/error.jsp" import="java.util.List,com.ibm.etools.utc.Tree,com.ibm.etools.utc.view.*,com.ibm.etools.utc.model.*" contentType="text/html; charset=utf-8" %>
<jsp:useBean id="fieldView" scope="session" class="com.ibm.etools.utc.view.FieldView"/>
<jsp:useBean id="modelManager" scope="session" class="com.ibm.etools.utc.ClassModelManager"/>
<%@ taglib uri="/utc" prefix="utc" %>

<utc:resource key="infoFields"/> <%= fieldView.getModel().getName() %><p/>

<% fieldView.cacheFieldsTree(modelManager); %>
<%= Tree.getTableTree(request, "_self", "/secure/details.jsp", fieldView.getFieldsTreeRoot()) %>
