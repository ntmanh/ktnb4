<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%>
<style type="text/css">
.dataTables_paginate
{
 	float:left;width:100%;
}
td {word-wrap: break-word}
</style>
<h3 class="Header">Log truy cập</h3>
<html:form action="/viewlog.do?method=show">
	<div
		style="width: 100%;overflow: scroll; border: 1px solid #CCC; text-align: left;">
		<div>
		Từ ngày: <input type="text" id="tuNgay" onblur="isDate(this);validDateRange()" onkeypress="return formatDate(event, this)"/>
		Đến ngày: <input type="text" id="denNgay" onblur="isDate(this);validDateRange()" onkeypress="return formatDate(event, this)"/>
		Cán bộ: <input type="text" id="canBo"/>
		<input id="btnSearch" type="button" class="button" value='Xem Log' name="B2" onclick="filter();">
		</div>
	<table cellpadding="0" cellspacing="0" border="0" class="display"
		id="tblLog">
		<thead>
			<tr>
				<th>ID</th>
				<th>Ngày</th>
				<th>User</th>
				<th>Mã CB</th>
				<th>URL</th>
				<th>Thông tin</th>
				<th>CQT</th>
			</tr>
		</thead>
		<tbody>
			<tr align="center">
				<td colspan="4" class="dataTables_empty">Loading data from
				server...</td>
			</tr>
		</tbody>
	</table>
	</div>
</html:form>
<script type="text/javascript" charset="utf-8"> 
var oTable;
$(function(){	
    var url='viewlog.do?method=getLog';
  	oTable=$("#tblLog").dataTable({
     	"bJQueryUI":true,
		"sDom":'<"H"fr>t<"F"p>',
		"bSort": true,
		"bFilter": true,
		"bProcessing": true,
		"bJQueryUI":true,"bLengthChange": false,
		"bServerSide": true,
		"sAjaxSource":url,
		"oLanguage":language,
		"iDisplayLength": 10,
		"sDom":'<"H"fr>t<"F"p>',
		//"sPaginationType": "full_numbers",
		"aoColumns" : [
       { sClass: "hiddenall"},   
       { sClass: "hideextra" },
       { sClass: "hideextra" },
       { sClass: "hideextra" },
       { sClass: "hideextra" },
       { sClass: "hideextra" },
       { sClass: "hideextra" }]
	}).fnSetFilteringDelay(500);
});
function changeIDisplayStart(){
	var oSettings = oTable.fnSettings();
	oSettings._iDisplayStart = 0;
}
function filter(){
	var oSettings =oTable.fnSettings();
    var url=encodeURI('viewlog.do?method=getLog&tuNgay='+$('#tuNgay').val()+'&denNgay='+$('#denNgay').val()+'&canBo='+$('#canBo').val());
    changeIDisplayStart();
	oSettings.sAjaxSource=url;
	oTable.fnDraw();
}
function validDateRange(){
	if(!compareDate(document.forms[0].tuNgay,document.forms[0].denNgay))
	return false;
	return true;
}
</script>
<%@ include file="/bottom.jsp"%>
