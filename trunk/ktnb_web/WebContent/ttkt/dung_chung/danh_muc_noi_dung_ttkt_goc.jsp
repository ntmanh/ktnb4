<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="chi_tiet_noi_dung.do">
	<fieldset style="width: 549; margin: 0; height: 520; overflow: scroll">
		<table width="100%" border="0">
			<tr class="TdHeaderList">
				<td width="50"><b>Mã</b></td>
				<td><b>Tên danh mục</b></td>
				<td align="center"><INPUT type="checkbox" name='checkAll' onclick="selectAll(this.checked)"></td>
			</tr>
		</table>		
			<div style="margin-left: 20%;overflow: auto;" id="tt">
	</fieldset>
	<br>
	<fieldset style="width: 549; margin: 0">
	<div align="center" style="text-align: center; width: 548; vertical-align: middle; padding: 10"><INPUT type='button' onclick='selectChiTietDanhMuc();' value='Chọn'> <INPUT type='button' onclick='window.close();' value='Đóng'></div>
	</fieldset>
</html:form>
<script language="javascript"> 
var tableDmGoc;
var allTableRow;
$(function() {				
		var urlx = "jsonstore.do?method=treeDm&id=10";
		$('#tt').tree({
			//onClick:function(node){ $('#tt').tree('beginEdit', node.target);}, url:urlx, checkbox:true
			url:urlx, checkbox:true
		});		
		//changeLanXuLy();
	});
function selectAll(isSelect){
	for(i = 1; allTableRow.length - 1; i++)
		allTableRow[i].cells[2].childNodes[0].checked = isSelect;
}
function selectChiTietDanhMuc(){
	var selectedIds = new Array();
	var selectedNames = new Array();
	
	for(i = 1; i< allTableRow.length; i++){
		cellCheckBox = allTableRow[i].cells[2];
		if(cellCheckBox.childNodes[0].checked){
			selectedIds.push(cellCheckBox.id);
			selectedNames.push(allTableRow[i].cells[1].innerHTML);	
		}			
	}	
	window.close();
	window.opener.chonDanhMucGoc(selectedIds, selectedNames);
}	
</script>