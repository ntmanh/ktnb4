<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top.jsp"%>
<style type="text/css">
span.description {
	display: inline-block;
	overflow: hidden;
	white-space: nowrap;
	width: 99%;
}
</style>
<html:form action="chi_tiet_noi_dung.do">
	<fieldset style="margin: 0; width: 597; height: 530;">
	<fieldset style="width: 100%; height: 10%; text-align: center;"><legend> Thông tin tìm kiếm </legend>
	<table width="100%">
		<tr>
			<td width="9%" align="right">Mã</td>
			<td width="1%"></td>
			<td width="20%" align="left"><input type="text" id='ma' style="width: 100%" onblur="search()" onkeypress="if(!formatInt(event)) return false; return true"></td>
			<td width="7%" align="right">Tên</td>
			<td width="1%"></td>
			<td width="62%" align="left"><input type="text" id='ten' onblur="search()" width="100%" style="width: 95%"></td>
		</tr>
	</table>
	</fieldset>
	<fieldset style="width: 100%; height: 90%;"><legend>Kết quả tìm kiếm</legend>
	<table width="576" border="0" height="30" style="table-layout: fixed">
		<tr class="TdHeaderList" id="<%=request.getAttribute("goc")%>">
			<td width="11%"><b>Mã</b></td>
			<td width="85%"><b>Tên</b></td>
			<td width="4%" align="center"><INPUT type="checkbox" onclick="selectAll(this.checked)"></td>
		</tr>
	</table>
	<div style="overflow: scroll; width: 100%; height: 435; margin: 0"><%=request.getAttribute("danhMucTtktTree")%></div>
	</fieldset>
	</fieldset>
	<br>
	<fieldset style="margin: 0; width: 597">
	<div align="center" style="text-align: center; vertical-align: middle; height: 40">
	<table align="center" width="100%" height="100%">
		<tr valign="middle">
			<td align="center" valign="middle""><INPUT type='button' class="button" onclick='selectChiTietDanhMuc();' value='Chọn'> <INPUT type='button' class="button" onclick='window.close();' value='Đóng'></td>
		</tr>
	</table>
	</div>
	</fieldset>
</html:form>

<!-- script cu -->
<script language="javascript">
$(function(){
    $('input').keydown(function(e){
        if (e.keyCode == 13) {
            search();
            return false;
        }
    });
});
var maDmGoc = getUrlParam('root');
var ma;
var ten;
function search(){
	ma = document.getElementById('ma').value;
	ten = document.getElementById('ten').value;	
	// Lay tat ca cac dong root
	var allHiden = document.getElementsByName('parentId' + maDmGoc);
	for(var i = 0; i < allHiden.length; i++){
		var searchingNode = new treeNode(allHiden[i].parentNode.parentNode);
		searchingNode.treeSearch();
	}	
	reFormatTable();	
}
function checkTree(){
	var treeLevel = 0;
	while (document.getElementsByName(treeLevel) != null && document.getElementsByName(treeLevel).length > 0){
		treeLevel++;
	}	  
	treeLevel--;
	var parentList = '';
	for(var lv = treeLevel; lv > 0; lv--){
		var childList = document.getElementsByName(lv);
		for(var i = 0; i< childList.length; i++){
			var tn = new treeNode(childList[i].parentNode.parentNode);
			if(parentList.indexOf(tn.parentId + ',') < 0){
				var parentNode = new treeNode(document.getElementById(tn.parentId));
				if(parentNode.isSelectAllChild())
					parentNode.setCheck(true);
				parentList += tn.parentId + ',';   
			}
		}
	}
}
	
window.onload = function(){
	reFormatTable();
	method = getUrlParam('method');
	if(method == 'chonChiTiet'){
		var chiTietNoiDungDaChonId = window.opener.chiTietNoiDungDaChonId;
		for(var i= 0; i< chiTietNoiDungDaChonId.length; i++){			
			var tn = new treeNode(document.getElementById(chiTietNoiDungDaChonId[i]));
			tn.setCheck(true);
			if(!tn.isRoot){
				var parent = new treeNode(document.getElementById(tn.parentId));
				parent.setDisplay(false);
				parent.expand();
			}
		}
		checkTree();
		return;
	}	
	// Mac dinh cac noi dung da chon
	chiTietNoiDungDaChonId = window.opener.chiTietNoiDungDaChonId;
	dsCacNoiDungDaChonId = window.opener.dsCacNoiDungDaChonId;	
	var root1;
	var root2;
	for(var i=0; i< dsCacNoiDungDaChonId.length; i++){	
		if(dsCacNoiDungDaChonId[i].toString().substring(0,4)=="1901"){			
			root1=true;
		}else if(dsCacNoiDungDaChonId[i].toString().substring(0,4)=="1903"){			
			root2=true;
		}
		document.getElementById(dsCacNoiDungDaChonId[i]+'check').checked = true;
		expandThisNode(dsCacNoiDungDaChonId[i]);
		var arrchiTietNoiDungDaChonId = chiTietNoiDungDaChonId[i].split(',');
		arrchiTietNoiDungDaChonId.unshift(dsCacNoiDungDaChonId[i]);
		for(var j = 0; j< arrchiTietNoiDungDaChonId.length; j++){		
			if(document.getElementById(arrchiTietNoiDungDaChonId[j])!=null){
			var tn = new treeNode(document.getElementById(arrchiTietNoiDungDaChonId[j]));
			tn.setCheck(true);
			if(!tn.isRoot){
				var parent = new treeNode(document.getElementById(tn.parentId));
				parent.setDisplay(false);
				parent.expand();
			}			
			}
		}
	}
	if(root1){
	var parent = new treeNode(document.getElementById(1901));
				parent.setCheck(true);
	}
	if(root2){
	var parent = new treeNode(document.getElementById(1903));
				parent.setCheck(true);
	}
	checkTree();
}
function reFormatTable(){
	var styleClass = 'row1';
	var rows = document.getElementById("tblChiTietNoiDung").rows;
	for(var i = 0; i < rows.length; i++){
		if(rows[i].style.display == 'inline'){
			rows[i].className  = styleClass;
			if(styleClass == 'row1')
				styleClass = 'row2'
			else
				styleClass = 'row1'
		}		
	}
	var numOfDisplay = 0;
	var tblRows = document.getElementById('tblChiTietNoiDung').rows;
	for(var i = 0; i< tblRows.length; i++){
		if(tblRows[i].style.display == 'inline')
			numOfDisplay++;
	}
	document.getElementById('tblChiTietNoiDung').style.height = numOfDisplay*20;
}
 
function selectAll(isSelect){	
	selectedIds = '';	
	var elements = document.getElementById('tblChiTietNoiDung').rows;
	for(i = 0; i< elements.length; i++){
		if(elements[i].id != null && elements[i].id != ''){
			tn = new treeNode(elements[i]);
			if(tn.isEnable)
				document.getElementById(elements[i].id + 'check').checked = isSelect;
			if(isSelect){				
				if(tn.isLeaf)
					selectedIds += tn.ma + ',';
			}			
		}			
	}
	if(isSelect)
		selectedIds = selectedIds.substring(0, selectedIds.length -1);		
}
function selectItem(ma){	
	tn = new treeNode(document.getElementById(ma));
	arrAffectedId = tn.click();
	// click node cha
	if(!tn.isRoot){
		var parentNode = tn.getParent();
		while(true){
			if(tn.checked){
				if(parentNode.isSelectAllChild()){
					parentNode.setCheck(true);
				}else{
					break;
				}
			}else{
				parentNode.setCheck(false);
			}
			if(parentNode.isRoot)
				break;
			parentNode = parentNode.getParent();
		}
		
	}
	
	// Lay danh sach cac phan tu duoc chon
	if(tn.checked){
		for(var i =0; i< arrAffectedId.length; i++){
			if(selectedIds.indexOf(arrAffectedId[i]) < 0){
				if(selectedIds == '')
					selectedIds = arrAffectedId[i];
				else
					selectedIds += ',' + arrAffectedId[i];
			}	
		}
	}else{
		for(var i =0; i< arrAffectedId.length; i++){
			if(selectedIds.indexOf(arrAffectedId[i]) > 0)
				selectedIds = selectedIds.replace(',' + arrAffectedId[i], '');
			else if(selectedIds.indexOf(arrAffectedId[i]) == 0){
				if(selectedIds == arrAffectedId[i])
					selectedIds = '';
				else
					selectedIds = selectedIds.replace(arrAffectedId[i] + ',', '');				
			}
				
		}
	}
	reFormatTable();
	
	
}
function expandThisNode(ma){
	var tn = new treeNode(document.getElementById(ma));
	if(tn.isLeaf)
		return;
	tn.expand();
}
function treeNode(theRow){	
	// Property
	// Read only
	this.tr =theRow;
	this.ma = theRow.id;	
	this.name = theRow.title;
	this.parentId = theRow.cells[0].childNodes[0].name.substr(8);	
	this.isRoot = (this.parentId == maDmGoc);
	this.isLeaf = document.getElementById(this.ma + '-') == null;
	this.level = theRow.cells[0].childNodes[1].name;	
	
	// Use
	this.isExpand = !this.isLeaf && document.getElementById(this.ma + '-').style.display == 'inline';
	this.checked = document.getElementById(this.ma + 'check').checked;
	this.isEnable = theRow.cells[0].childNodes[0].id=='enable'? true: false;
	
	// Method
	this.setDisplay = setDisplay;
	this.setEnable = setEnable;
	this.setCheck = setCheck;
	this.getChilds = getChilds;
	this.getSelectedChildIds = getSelectedChildIds;
	this.expand = expand;				
	this.click = click;
	this.setEnable = setEnable;
	this.enableAndDisplayOnlyMe = enableAndDisplayOnlyMe;
	this.enableOnlyMe = enableOnlyMe;
	this.displayOnlyMe = displayOnlyMe;
	this.treeSearch = treeSearch;
	this.isSelectAllChild = isSelectAllChild;
	this.unSelectAllChild = unSelectAllChild;
	this.getParent = getParent;
	
}
function getParent(){
	if(this.isRoot)
		return null;
	return new treeNode(document.getElementById(this.parentId))
}
function isSelectAllChild(){
	var allChilds = this.getChilds();
	for(var i = 0; i< allChilds.length; i++){
		if(!allChilds[i].checked)
			return false;
	}
	return true;
}
function unSelectAllChild(){
	var allChilds = this.getChilds();
	for(var i = 0; i< allChilds.length; i++){
		if(allChilds[i].checked)
			return false;
	}
	return true;
}
function setDisplay(isDisplay){
	this.isExpand = isDisplay;
	document.getElementById(this.ma + '-').style.display = isDisplay?'inline':'none';
	document.getElementById(this.ma + '+').style.display = isDisplay?'none':'inline';
}
function setCheck(isChecked){
	this.checked = isChecked; 
	document.getElementById(this.ma + 'check').checked = isChecked;
}
function setEnable(isEnable){
	this.isEnable = isEnable;
	this.tr.cells[0].childNodes[0].id==isEnable? 'enable': 'disable';
}

function getSelectedChildIds(){	
	if(this.isLeaf)
		return '';
	var childList = this.getChilds();
	var reval = '';
	for(var i = 0; i< childList.length; i++){
		if(childList[i].isLeaf){
			if(childList[i].checked)
				reval += childList[i].ma + ',';				
		}else{
			var temp = childList[i].getSelectedChildIds();
			if(!isEmpty(temp))
				reval += temp + ',';
		}
	}
	if(reval != '')
		reval = reval.substring(0, reval.length -1);	
	return reval;	
}
function enableOnlyMe(isTrue){
	this.tr.cells[0].childNodes[0].id = isTrue?"enable":"disable";
	//this.tr.style.display = isTrue?"inline":"none";
}
function displayOnlyMe(isTrue){
	this.tr.style.display = isTrue?"inline":"none";
	if(!this.isLeaf){
		document.getElementById(this.ma + '-').style.display = isTrue?"inline":"none";
		document.getElementById(this.ma + '+').style.display = isTrue?"none":"inline";
	}	
}
function enableAndDisplayOnlyMe(isTrue){
	this.tr.cells[0].childNodes[0].id = isTrue?"enable":"disable";
	this.tr.style.display = isTrue?"inline":"none";
	if(!this.isLeaf){
		document.getElementById(this.ma + '-').style.display = isTrue?"inline":"none";
		document.getElementById(this.ma + '+').style.display = isTrue?"none":"inline";
	}
	
}
function treeSearch(){
	if(((isEmpty(ma)) || (this.ma.indexOf(ma) >= 0))&&((isEmpty(ten))||(this.name.toLowerCase().indexOf(ten.toLowerCase()) >=0 ))){//Thoa man dieu kien tk
		//this.enableAndDisplayOnlyMe(true);
		this.setEnable(true);
		return true;
	}else{
		var bReturn = false;
		if(!this.isLeaf){
			var childList = this.getChilds();							
			for(var i = 0; i< childList.length; i++){
				if(childList[i].treeSearch()){
					if(!bReturn)
						bReturn = true;
				}
					
			}
		}		
		this.enableAndDisplayOnlyMe(bReturn);
		return bReturn;
	}
}
function setEnable(enb){	
	this.tr.cells[0].childNodes[0].id = enb?"enable":"disable";
	this.tr.style.display = enb?"inline":"none";
	if(!this.isLeaf){
		document.getElementById(this.ma + '-').style.display = enb?"inline":"none";
		document.getElementById(this.ma + '+').style.display = enb?"none":"inline";
	}
	
	if(this.isLeaf)
		return;
	var childList = this.getChilds()
	for(var i = 0; i < childList.length; i++){
		childList[i].setEnable(enb);
	}
}
var selectedIds = '';
function click(){
	if(this.isLeaf) 
		return new Array(this.ma);
	document.getElementById(this.ma + '-').style.display = 'inline';
	document.getElementById(this.ma + '+').style.display = 'none';
	var reval = new Array();
	var childList = this.getChilds();
	if(childList != null){
		for(var i = 0; i< childList.length; i++){
			if(childList[i].isEnable){
				document.getElementById(childList[i].ma + 'check').checked = this.checked;	
				childList[i].tr.style.display = 'inline';	
				childList[i].checked = this.checked;		
				if(childList[i].isLeaf)
					reval.push(childList[i].ma);
				else
					reval = reval.concat(childList[i].click());
			}
									
		}
	}			
	return reval;	
}
function getChilds(){
	if(this.isLeaf)
		return null;
	var arrReturn = new Array();
	var allHiddenField = document.getElementsByName('parentId' + this.ma);		
	for(var i = 0; i< allHiddenField.length; i++){
		//if(allHiddenField[i].nodeName != 'tr' && allHiddenField[i].nodeName != 'TR')
			arrReturn.push(new treeNode(allHiddenField[i].parentNode.parentNode))	
			
	}		
	return arrReturn;
}
function expand(){
	if(this.isLeaf)
		return;
	if(this.isExpand){// Dang mo
		// Doi dau - thanh dau +
		document.getElementById(this.ma + '+').style.display = 'inline';
		document.getElementById(this.ma + '-').style.display = 'none';
		var allTr = document.getElementsByTagName('tr');
		for(var i = 0; i< allTr.length; i++){
			if(allTr[i].id.indexOf(this.ma) == 0 && allTr[i].id != this.ma)
				allTr[i].style.display = 'none';
				
		}
	}else{// Dang dong
		document.getElementById(this.ma + '-').style.display = 'inline';
		document.getElementById(this.ma + '+').style.display = 'none';
		// Mo node con
		var allChilds = this.getChilds();
		for(var i = 0; i< allChilds.length; i++){
			if(allChilds[i].isEnable){
				allChilds[i].tr.style.display = 'inline';
				if(!allChilds[i].isLeaf && allChilds[i].isExpand){
					showChilds(allChilds[i]);
				}
			}
		}
	}
	reFormatTable();
	
}
function showChilds(element){
	var allChilds = element.getChilds();
	for(var i = 0; i< allChilds.length; i++){
		if(allChilds[i].isEnable){
			allChilds[i].tr.style.display = 'inline';
			if(!allChilds[i].isLeaf && allChilds[i].isExpand){
				showChilds(allChilds[i]);
			}
		}		
	}
}

function getAllRoot(){
	var arrRoot = new Array();
	var allHidden = document.getElementsByName('parentId' + 1901);
	for(var i = 0; i< allHidden.length; i++){
		arrRoot.push(new treeNode(allHidden[i].parentNode.parentNode));	
	}
	var allHidden = document.getElementsByName('parentId' + 1903);
	for(var i = 0; i< allHidden.length; i++){
		arrRoot.push(new treeNode(allHidden[i].parentNode.parentNode));	
	}
	return arrRoot;
}
function selectChiTietDanhMuc(){
	method = getUrlParam('method');
	if(method == 'chonChiTiet'){
		var selectedIds = select123();
		if(!isEmpty(selectedIds))
			window.opener.selectChiTietDanhMuc(selectedIds);	
		window.close();
		return;
	}	
	var arrReturn = new Array();
	var allRoot = getAllRoot();
	for(var i = 0; i< allRoot.length; i++ ){
		var selectedChildIds = allRoot[i].getSelectedChildIds();
		if(allRoot[i].checked || selectedChildIds != ''){
			arrReturn.push(new returnTree(allRoot[i], selectedChildIds));
		}
	}
	if(arrReturn.length ==0){
		alert('Bạn chưa chọn bản ghi nào!');
		return;
	}	
	window.opener.chonDanhMucGoc(arrReturn);	
	window.close();
}
function returnTree(tn, selectedChildChildIds){
	this.ma = tn.ma;
	this.name = tn.name;
	this.selectedChildIds = selectedChildChildIds;
}
function select123(){
	var reVal = '';
	var allTblRows = document.getElementById('tblChiTietNoiDung').rows;
	for(var i = 0; i< allTblRows.length; i++){
		var tn = new treeNode(allTblRows[i]);
		if(tn.isLeaf && tn.checked)
			reVal += allTblRows[i].id + ',';			
	}
	if(reVal != '')
		reVal = reVal.substring(0, reVal.length -1);	
	return reVal;	
}
</script>