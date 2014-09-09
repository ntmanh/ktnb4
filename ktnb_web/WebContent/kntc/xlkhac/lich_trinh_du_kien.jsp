<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<h3 class="Header">Lịch trình dự kiến</h3>
<html:form action="lich_trinh_du_kien.do?method=show" method="post" styleId="form">
	<fieldset><legend>Thông tin hồ sơ</legend>
	<TABLE width="100%">
		<tr>
			<td width="15%" align="right">Mã số hồ sơ</td>
			<td width="35%"><html:text property="maHoSo" styleId="ma" style="width:100%" readonly="true" /></td>
			<!--<td width="15%" align="right">Tên hồ sơ</td>
			<td width="35%"><html:text property="tenHoSo" style="width:100%"
				readonly="true" /></td>-->
			<td width="15%" align="right">Cán bộ thụ lý</td>
			<td width="35%"><html:text property="canBoThuLy" style="width:100%" readonly="true" /></td>
		</tr>
		<tr>
			<td align="right">Ngày công văn đến</td>
			<td><html:text property="ngayCVDen" style="width:100%" readonly="true" /></td>
			<td align="right"></td>
			<td></td>
		</tr>
		<tr>
			<td align="right"></td>
			<td colspan="3"></td>
		</tr>
	</TABLE>
	</fieldset>
	<fieldset><legend>Lịch trình dự kiến</legend>
	<table width="50%" cellpadding="0" cellspacing="0" border="0" class="display" id="tblLichTrinh">
		<thead>
			<tr>
				<th>Giai đoạn</th>
				<th>Ngày bắt đầu</th>
				<th>Thời hạn</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="3" style="text-align: center">Loading data from server.....</td>
			</tr>
		</tbody>
	</table>
	</fieldset>
	<TABLE width="100%">
		<tr>
			<td align="center"><INPUT type="button" name="btnCancel" value="Đóng" style="width: 60px" class="button" onclick="window.close();"></td>
		</tr>
	</TABLE>
</html:form>
<script type="text/javascript" charset="utf-8">
var oTable;
$(function(){	
	//$('#ma').val('');
	$("#tblLichTrinh tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	    var iPos=oTable.fnGetPosition(event.target.parentNode);
		var aData=oTable.fnGetData(iPos);
	});		
    var url='lich_trinh_du_kien.do?method=getLichTrinh&id='+$('#ma').val();
   	oTable=$("#tblLichTrinh").dataTable({ "bJQueryUI":true,
   		//"bProcessing": true,"bServerSide": true,
   		//'iDisplayLength': 10,
		"sDom":'<"H"fr>t<"F"p>', "bSort": false,
		"bFilter": false, 
		"sAjaxSource":url, 
   	    "oLanguage":language}).fnSetFilteringDelay(2000);	   	   	
});
</script>
<%@ include file="/bottom.jsp"%>
