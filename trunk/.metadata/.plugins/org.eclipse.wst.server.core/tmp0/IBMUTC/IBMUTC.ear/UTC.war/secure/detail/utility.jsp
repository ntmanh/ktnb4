<%@ page errorPage="/unsecure/error.jsp" import="java.util.List,com.ibm.etools.utc.Tree,com.ibm.etools.utc.Resource,com.ibm.etools.utc.view.*,com.ibm.etools.utc.model.*" contentType="text/html; charset=utf-8" %>
<jsp:useBean id="parameterView" scope="session" class="com.ibm.etools.utc.view.ParameterView"/>
<jsp:useBean id="modelManager" scope="session" class="com.ibm.etools.utc.ClassModelManager"/>
<jsp:useBean id="utilityView" scope="session" class="com.ibm.etools.utc.view.UtilityView"/>
<%@ taglib uri="/utc" prefix="utc" %>

<% parameterView.loadManagerObjects(modelManager);
  parameterView.loadManagerClasses(modelManager); %>

<% if (utilityView.isLoadClassView()) { %>
<!-- *************** Load class *************** -->
<form name="newClassForm" action="/UTC/utility" method="post" target="details" enctype="multipart/form-data">
<input type="hidden" name="random" value="<%= Math.random() %>"/>
<input type="hidden" name="utility" value="2"/>
<table cellpadding=3 cellspacing=0 border=0 bgcolor=white width=100%>
<tr>
  <td width=20%><label for="text"><utc:resource key="ejbPageParameterViewLoadClass"/></label></td>
  <td width=*><input type="text" id="text" class="textenter" name="class" size=25/></td>
  <td width=15%><input type=submit value="<utc:resource key="ejbPageParameterViewLoad"/>" class="button"/></td>
</tr>

</table>
</form>

<% } else if (utilityView.isClassCastView()) { %>
<!-- *************** Class Cast *************** -->
<form name="newClassForm" action="/UTC/utility" method="post" target="details" enctype="multipart/form-data">
<input type="hidden" name="random" value="<%= Math.random() %>"/>
<input type="hidden" name="utility" value="0"/>
<table cellpadding=3 cellspacing=0 border=0 bgcolor=white width=100%>
<tr>
  <td width=20%><label for="object"><utc:resource key="ejbPageParameterViewObject"/></label></td>
  <td>
<select name="object" class="selectlist" id="object">
<% List castObjects = parameterView.getManagerObjects();
  int size = castObjects.size();
  for (int j = 0; j < size; j++) {
  ObjectModel model = (ObjectModel) castObjects.get(j); %>
  <option value="<%= j %>"><%= model.getName() %></option>
<% } %>
</select>
  </td>
  <td></td>
</tr>
<tr>
  <td><label for="class"><utc:resource key="ejbPageParameterViewCastType"/></label></td>
  <td>

<select name="class" class="selectlist" id="class">
<% List castClasses = parameterView.getManagerClasses();
  size = castClasses.size();
  for (int j = 0; j < size; j++) {
  ClassModel model = (ClassModel) castClasses.get(j); %>
  <option value="<%= j %>"><%= model.getName() %></option>
  <% } %>
</select>
  </td>
  <td width=15%><input type=submit value="<utc:resource key="ejbPageParameterViewCast"/>" class="button"/></td>
</tr>

</table>
</form>

<% } else if (utilityView.isArrayView()) { %>
<!-- *************** Array Creation *************** -->
<form name="createArrayForm" action="/UTC/utility" method="post" target="details" enctype="multipart/form-data">
<input type="hidden" name="random" value="<%= Math.random() %>"/>
<input type="hidden" name="utility" value="1"/>
<table cellpadding=3 cellspacing=0 border=0 bgcolor=white width=100%>
<tr>
  <td width=20%><label for="class"><utc:resource key="ejbPageParameterViewArrayType"/></label></td>
  <td>
<select name="class" class="selectlist" id="class">
<% List castClasses = parameterView.getManagerClasses();
  int size = castClasses.size();
  for (int j = 0; j < size; j++) {
  ClassModel model = (ClassModel) castClasses.get(j); %>
  <option value="<%= j %>"><%= model.getName() %></option>
  <% } %>
</select>

  </td>
  <td width=15%></td>
</tr>
<tr>
  <td><label for="size"><utc:resource key="ejbPageParameterViewArraySize"/></label></td>
  <td><input type="text" id="size" class="textenter" name="size" value="1" size=5/></td>
  <td><input type=submit value="<utc:resource key="ejbPageParameterViewArrayCreate"/>" class="button"/></td>
</tr>

</table>
</form>

<% } else if (utilityView.isCollectionToArrayView()) { %>
<!-- *************** Collection To Array *************** -->
<% parameterView.loadManagerCollections(modelManager); %>
<form name="collectionToArrayForm" action="/UTC/utility" method="post" target="details" enctype="multipart/form-data">
<input type="hidden" name="random" value="<%= Math.random() %>"/>
<input type="hidden" name="utility" value="3"/>
<table cellpadding=3 cellspacing=0 border=0 bgcolor=white width=100%>
<tr>
  <td width=20%><label for="collection"><utc:resource key="ejbPageParameterViewCollection"/></label></td>
  <td>
<select name="collection" class="selectlist" id="collection">
<% List collections = parameterView.getManagerCollections();
  int size = collections.size();
  for (int j = 0; j < size; j++) {
  ClassModel model = (ClassModel) collections.get(j); %>
  <option value="<%= j %>"><%= model.getName() %></option>
  <% } %>
</select>
  </td>
  <td width=15%><input type=submit value="<utc:resource key="ejbPageParameterViewConvert"/>" class="button"/></td>
</tr>

</table>
</form>

<% } else if (utilityView.isArrayToListView()) { %>
<!-- *************** Array To List *************** -->
<% parameterView.loadManagerArrays(modelManager); %>
<form name="arrayToListForm" action="/UTC/utility" method="post" target="details" enctype="multipart/form-data">
<input type="hidden" name="random" value="<%= Math.random() %>"/>
<input type="hidden" name="utility" value="4"/>
<table cellpadding=3 cellspacing=0 border=0 bgcolor=white width=100%>
<tr>
  <td width=20%><label for="array"><utc:resource key="ejbPageParameterViewArray"/></label></td>
  <td>
<select name="array" class="selectlist" id="array">
<% List arrays = parameterView.getManagerArrays();
  int size = arrays.size();
  for (int j = 0; j < size; j++) {
  ClassModel model = (ClassModel) arrays.get(j); %>
  <option value="<%= j %>"><%= model.getName() %></option>
  <% } %>
</select>
  </td>
  <td width=15%><input type=submit value="<utc:resource key="ejbPageParameterViewConvert"/>" class="button"/></td>
</tr>

</table>
</form>

<% } else if (utilityView.isSetArrayElementView()) { %>
<!-- *************** Set Array Element *************** -->
<% parameterView.loadManagerArrays(modelManager); %>
<% parameterView.loadManagerObjects(modelManager); %>
<form name="arrayElementForm" action="/UTC/utility" method="post" target="details" enctype="multipart/form-data">
<input type="hidden" name="random" value="<%= Math.random() %>"/>
<input type="hidden" name="utility" value="5"/>
<table cellpadding=3 cellspacing=0 border=0 bgcolor=white width=100%>
<tr>
  <td width=20%><label for="array"><utc:resource key="ejbPageParameterViewArray"/></label></td>
  <td>
<select name="array" class="selectlist" id="array">
<% List arrays = parameterView.getManagerArrays();
  int size = arrays.size();
  for (int j = 0; j < size; j++) {
  ClassModel model = (ClassModel) arrays.get(j); %>
  <option value="<%= j %>"><%= model.getName() %></option>
  <% } %>
</select>
  </td>
  <td width=15%></td>
</tr>
<tr>
  <td><label for="element"><utc:resource key="ejbPageParameterViewElement"/></label></td>
  <td><input type="text" class="textenter" id="element" name="element" value="0" size=5/></td>
  <td></td>
</tr>
<tr>
  <td><label for="object"><utc:resource key="ejbPageParameterViewObject"/></label></td>
  <td>
<select name="object" class="selectlist" id="object">
<% List objects = parameterView.getManagerObjects();
  size = objects.size();
  for (int j = 0; j < size; j++) {
  ClassModel model = (ClassModel) objects.get(j); %>
  <option value="<%= j %>"><%= model.getName() %></option>
  <% } %>
</select>
  </td>
  <td><input type=submit value="<utc:resource key="ejbPageParameterViewSet"/>" class="button"/></td>
</tr>

</table>
</form>
<% } else if (utilityView.isSetClasspathView()) { %>

<!-- *************** Set classpath *************** -->
<form name="newClassForm" action="/UTC/utility" method="post" target="details" enctype="multipart/form-data">
<input type="hidden" name="random" value="<%= Math.random() %>"/>
<input type="hidden" name="utility" value="6"/>
<table cellpadding=3 cellspacing=0 border=0 bgcolor=white width=100%>
<tr>
  <td width=20%><label for="text">Classpath:</label></td>
  <td width=*><input type="text" id="text" class="textenter" name="classpath" size=25/></td>
  <td width=15%><input type=submit value="Set" class="button"/></td>
</tr>

</table>
</form>

<% } else if (utilityView.isSendMessageView()) { %>
<!-- *************** Load class *************** -->
<form name="newClassForm" action="/UTC/utility" method="post" target="details" enctype="multipart/form-data">
<input type="hidden" name="random" value="<%= Math.random() %>"/>
<input type="hidden" name="utility" value="7"/>
<table cellpadding=3 cellspacing=0 border=0 bgcolor=white width=100%>
<tr>
  <td width=20%><label for="text"><utc:resource key="utilityJMSQueue"/></label></td>
  <td width=*><input type="text" id="text" class="textenter" name="queueName" size=25/></td>
</tr>
<tr>
  <td width=20%><label for="text"><utc:resource key="utilityJMSQueueCF"/></label></td>
  <td width=*><input type="text" id="text" class="textenter" name="queueCFName" size=25/></td>
</tr>
<tr>
  <td width=20%><label for="text"><utc:resource key="utilityJMSMessage"/></label></td>
  <td width=*><input type="text" id="text" class="textenter" name="message" size=25/></td>
  <td width=15%><input type=submit value="<utc:resource key="utilityJMSSend"/>" class="button"/></td>
</tr>

</table>
</form>

<% } else if (utilityView.isPostMessageView()) { %>
<!-- *************** Load class *************** -->
<form name="newClassForm" action="/UTC/utility" method="post" target="details" enctype="multipart/form-data">
<input type="hidden" name="random" value="<%= Math.random() %>"/>
<input type="hidden" name="utility" value="8"/>
<table cellpadding=3 cellspacing=0 border=0 bgcolor=white width=100%>
<tr>
  <td width=20%><label for="text"><utc:resource key="utilityJMSTopic"/></label></td>
  <td width=*><input type="text" id="text" class="textenter" name="topicName" size=25/></td>
</tr>
<tr>
  <td width=20%><label for="text"><utc:resource key="utilityJMSTopicCF"/></label></td>
  <td width=*><input type="text" id="text" class="textenter" name="topicCFName" size=25/></td>
</tr>
<tr>
  <td width=20%><label for="text"><utc:resource key="utilityJMSMessage"/></label></td>
  <td width=*><input type="text" id="text" class="textenter" name="message" size=25/></td>
  <td width=15%><input type=submit value="<utc:resource key="utilityJMSPost"/>" class="button"/></td>
</tr>

</table>
</form>

<% } %>

<jsp:include page="results.jsp" flush="true"/>