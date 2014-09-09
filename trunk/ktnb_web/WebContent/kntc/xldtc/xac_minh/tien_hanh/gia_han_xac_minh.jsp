<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Quy&#7871;t &#273;&#7883;nh gia h&#7841;n th&#7901;i gian x&#225;c minh - 16/KNTC</h3>
<html:form action="/kntc_xm_gia_han.do?method=giahan">
	<div style="text-align: center; width: 100%"><font style="font-size: 12px; color: red"> S&#7889; Quy&#7871;t &#273;&#7883;nh</font> <html:text property="maQdxm" styleClass="text" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Danh sách các phi&#x1EBF;u &#x111;ã l&#x1EAD;p</legend>
	<table cellpadding="0" cellspacing="0" border="0" class="display" id="tbl_listPhieuHen">
		<thead>
			<tr>
				<th>Mã phi&#7871;u</th>
				<th>Ng&#224;y l&#x1EAD;p phi&#x1EBF;u</th>
				<th>Ng&#432;&#7901;i l&#7853;p</th>
			</tr>
		</thead>
		<tbody>
			<tr align="center">
				<td colspan="3" class="dataTables_empty">.....</td>
			</tr>
		</tbody>
	</table>
	</fieldset>
	<br>
	<fieldset><legend>Th&#244;ng tin quy&#7871;t &#273;&#7883;nh</legend>
	<table width="100%">
		<tr>
			<td>&#272;&#7883;a &#273;i&#7875;m <font color="red">*</font></td>
			<td><html:text property="diaDiem" /></td>
			<td>Ng&#224;y l&#7853;p quy&#7871;t &#273;&#7883;nh <font color="red">*</font></td>
			<td><html:text property="ngayLap" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td>S&#7889; phi&#7871;u <font color="red">*</font></td>
			<td><html:text property="soPhieu" /></td>
			<td>Ng&#224;y ra quy&#7871;t &#273;&#7883;nh <font color="red">*</font></td>
			<td><html:text property="ngayRaQd" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td>C&#259;n c&#7913; v&#259;n b&#7843;n <font color="red">*</font></td>
			<td><html:text property="canCuVb" /></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Gia h&#7841;n t&#7915; ng&#224;y <font color="red">*</font></td>
			<td><html:text property="giaHanTuNgay" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			<td>&#272;&#7871;n ng&#224;y <font color="red">*</font></td>
			<td><html:text property="giaHanDenNgay" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
	</table>
	</fieldset>
	<jsp:include page="../../../button_bar_kntc.jsp" />
	<script language="JavaScript">
var oTable;
$(function(){
	var ghiTC = "";
	 <logic:present name="ghiThanhcong">
	     	ghiTC = '<%=request.getAttribute("ghiThanhcong")%>';
	 </logic:present>
	 if(ghiTC=='1')
	   alert('L\u01B0u th\u00E0nh c\u00F4ng!'); 
	 else  if(ghiTC=='0')
	   alert('L\u1ED7i khi ghi d\u1EEF li\u1EC7u!!!'); 
    $("#tbl_listPhieuHen tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	});
	var url='kntc_xm_gia_han.do?method=getListQd&id='+document.forms[0].maQdxm.value;
  	oTable=$("#tbl_listPhieuHen").dataTable({ "bJQueryUI":true, "sDom":'<"H"fr>t<"F"p>', "bSort": false, "bProcessing": true, "bServerSide": true, "sAjaxSource":url, "oLanguage":language}).fnSetFilteringDelay(500);
});
function ghi(){
	document.forms[0].action="kntc_xm_gia_han.do?method=saveGh";
	document.forms[0].submit();
}
function print(){
    var maHS = document.forms[0].maHoSo.value;
    //alert(maHS);
	if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+value);
	else
		alert("Ch\u01B0a c\u00F3 th\u00F4ng tin v\u1EC1 h\u1ED3 s\u01A1!");	
}
function xoa(){
    var maHS = document.forms[0].maHoSo.value;
    //alert(maHS);
	if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+value);
	else
		alert("Ch\u01B0a c\u00F3 th\u00F4ng tin v\u1EC1 h\u1ED3 s\u01A1!");	
}
</script>
</html:form>
<%@include file="/bottom.jsp"%>
