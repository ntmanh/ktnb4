<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page import="cmc.com.ktnb.util.Constants"%>
<%
String formName = request.getParameter("form");
%>
<html:hidden name='<%=formName%>' property="checkIsTCT" />
<html:hidden name='<%=formName%>' property="updated" />
<html:hidden name='<%=formName%>' property="inserted" />
<html:hidden name='<%=formName%>' property="deleted" />
<html:hidden name='<%=formName%>' property="exited" />
<html:hidden name='<%=formName%>' property="currentData" />
<html:hidden name='<%=formName%>' property="storeObjs" />
<script language="JavaScript">
function checkPublicAuthorization(){
	try{
	var isUpdated = document.forms[0].updated.value;
	var isInserted = document.forms[0].inserted.value;
	var isDeleted = document.forms[0].deleted.value;
	var isTCT = document.forms[0].checkIsTCT.value;
	
	if(isTCT == '<%=Constants.isNotTCT%>'){
		disableText();
		disableInsert();
		disableDelete();
		disableSave();
	}	
	if(isUpdated == '<%=Constants.FALSE%>'){
		disableText();
		disableUpdate();
	}
	if(isInserted == '<%=Constants.FALSE%>'){
		disableInsert();
	}
	if(isDeleted == '<%=Constants.FALSE%>'){
		disableDelete();
	}
	if(isUpdated=='<%=Constants.FALSE%>' && isInserted=='<%=Constants.FALSE%>'){
		disableSave();
	}
	}catch(e){}
}
function disableText(){
	var element;
	var strName;
	var inx = 0;
	
	for(var i=0;i<document.forms[0].elements.length;i++){
      	element = document.forms[0].elements[i];
      	strName = element.type;   
		if(strName == "text")
			element.readOnly = true;
		else if(strName == "checkbox")
			element.disabled = true;
    }
}

function disableControl(ctrNme){
	var element;
	element = document.forms[0].elements[ctrNme];
	if(element != null){
		if(element.type != null)
			element.disabled = true;
		else if(element.length > 0)	{
			for(var i=0; i< element.length; i++){
				element[i].disabled = true;
			}
		}
	}
}

function disableControlInGrid(gridNme,propName){
	var element;
	var inx=0;
	var type;
	try {
      	while (true) {
	    	element = document.forms[0].elements[gridNme+'['+inx+'].'+propName];
			type = element.type;
			if(type == "text")
				element.readOnly = true;
			else if(type == "select-one")
				element.disabled = true;
			else if(type == "checkbox")
				element.disabled = true;

	    	inx++;
		}		   	
    }
    catch (Exception) { 
    }
}

function disableUpdate(){
	var element;
	element = document.forms[0].elements["update"];
	if(element != null){
		if(element.type != null)
			element.disabled = true;
		else if(element.length > 0)	{
			for(var i=0; i< element.length; i++){
				element[i].disabled = true;
			}
		}
	}
}

function disableInsert(){
	var element;
	element = document.forms[0].elements["insert"];
	if(element != null){
		if(element.type != null)
			element.disabled = true;
		else if(element.length > 0)	{
			for(var i=0; i< element.length; i++){
				element[i].disabled = true;
			}
		}
	}
}

function disableDelete(){
	var element;
	element = document.forms[0].elements["delete"];
	if(element != null){
		if(element.type != null)
			element.disabled = true;
		else if(element.length > 0)	{
			for(var i=0; i< element.length; i++){
				element[i].disabled = true;
			}
		}
	}
}

function disableSave(){
	var element;
	element = document.forms[0].elements["save"];
	if(element != null){
		if(element.type != null)
			element.disabled = true;
		else if(element.length > 0)	{
			for(var i=0; i< element.length; i++){
				element[i].disabled = true;
			}
		}
	}
}

function checkUpdate(ctr){
	var checkIsTCT = document.forms[0].checkIsTCT.value;
	if(checkIsTCT == '<%=Constants.isNotTCT%>'){
		ctr.blur();
	}
	var isUpdated = document.forms[0].updated.value;
	if(isUpdated == '<%=Constants.FALSE%>'){
		ctr.blur();
    }
}
</script>
