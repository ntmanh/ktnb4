<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<BODY>
<TABLE width="100%" align="center" cellpadding="5">
	<logic:notPresent name="readOnly">
		<tr>
			<td width="50%" align="right"><input type="button" style="width: 60" class="button" name="btnSave" value='<bean:message  key="luu"/>' onclick="save();"></td>
			<td width="50%" align="left"><input type="button" name="closetheForm" style="width: 60" class="button" value='<bean:message key="dong"/>' onclick="closeContainWindow();"></td>
		</tr>
	</logic:notPresent>
	<logic:present name="readOnly">
		<td width="100%" align="center"><input type="button" style="width: 60" class="button" name="btnSave" value='<bean:message  key="luu"/>' onclick="save();" disabled="disabled"> <input type="button" name="closetheForm" style="width: 60" class="button" value='<bean:message key="dong"/>'
			onclick="closeContainWindow();"></td>
	</logic:present>
</TABLE>
<script language="javascript">		
	var activeTab = null;
 	function save(){
 		try{
 			saveActiveTab(); 
 		}catch(err){
 			//Code kieu gi da Error con Submit ha NTDUNG???
 			if(!validateForm())
	 			return false;
	 		action = document.forms[0].action;
	 		action = action.split('?')[0];  		
	 		document.forms[0].action += "?method=save";
	 		document.forms[0].submit();
	 		/*dhphuc sua lai => alert loi de biet, khong submit*/	 		
	        //var text = "Error description: " + err.message + "\n\n";        
	        //alert(text);
 		}
 	} 	
 	function closeContainWindow(){ 
 		try{
 			// Cac form tu cai dat phuong thuc dong
 			selfClose();
 		}catch(err){  			
 			// Neu khong tu dong se chuyen ve trang chu
 			window.location = 'ttkt_index.do';
 		} 		
 	}
</script>
</BODY>
<%if (request.getAttribute("readOnly") != null) {%>
<script language="javascript"> 
// Input fields
var allInputFields = document.getElementsByTagName('input') 
	for(i = 0; i< allInputFields.length; i++){		 
		if(allInputFields[i].type.toLowerCase()=='button'&&allInputFields[i].className.toLowerCase()!="button1"){ // Button
			if(allInputFields[i].name != 'closetheForm')
				allInputFields[i].disabled = true; 
				
		}else if(allInputFields[i].type.toLowerCase()=='text'){ // Text
			allInputFields[i].readOnly = true;
		}else if(allInputFields[i].type.toLowerCase()=='radio'){ // Radio
			allInputFields[i].disabled = true;
		}else if(allInputFields[i].type.toLowerCase()=='checkbox'){ // Checkbox
			allInputFields[i].disabled = true;
		}
	}
allSelect = document.getElementsByTagName('select'); // Select
for(i = 0; i< allSelect.length; i++)
	allSelect[i].disabled = true;
	
allTextArea = document.getElementsByTagName('TEXTAREA')// Text area
for(i = 0; i< allTextArea.length; i++)
	allTextArea[i].readOnly = true;
</script>
<%}%>
<logic:present name="strDateHoliday">
	<script language="javascript">
		strHolidayDay = '<%=request.getAttribute("strDateHoliday")%>';	
	</script>
</logic:present>
<logic:present name="saveStatus">
	<script language="javascript">
		alert('L\u01B0u th\u00E0nh c\u00F4ng!');
		try{
			xuLySauSaveThanhCong(); 
		}catch(err){
			
		}
		// Sau khi save thanh cong chac chan se dong form.
		selfClose();
		
	</script>
</logic:present>
