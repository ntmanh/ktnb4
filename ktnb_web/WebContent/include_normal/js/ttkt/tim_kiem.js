var selectedItems
function selectAll(isSelect){		
		selectedItems = "";
		checkBoxList = getAllCheckBox();				
		for(i = 0; i< checkBoxList.length; i++){
			checkBoxList[i].checked = isSelect;
			if(isSelect)
				selectedItems += checkBoxList[i].id + ',';
		}
		if(selectedItems!="")
			selectedItems = selectedItems.substring(0, selectedItems.length-1);
		
	}
	function getAllCheckBox(){
		return document.getElementsByName('checkboxItem');
	}
	function selectItem(control){		
		if(control.checked){		
			if (selectedItems == null || selectedItems == '')
				selectedItems = control.id;
			else	
				selectedItems += ',' + control.id;
		}			 
		else{
			if(selectedItems.indexOf(',') < 0){
				selectedItems = "";
				return;
			}	
			else if(selectedItems.indexOf(control.id)==0)
				strReplace = control.id + ",";
			else
				strReplace = "," + control.id;

			selectedItems = selectedItems.replace(strReplace, "");
		}	
		
	}
	function selectAllCheckBox(isSelect){
		for(i = 0; i< document.forms[0].elements.length; i++){
			element = document.forms[0].elements[i];
			try{
				if(element.name.indexOf('].active') > 0)
					element.value = isSelect;
				else if(element.name == "checkBoxItem")
					element.checked = isSelect;
			}
			catch(err){
			}
			
			
		}
		
	}