<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">B&#225;o c&#225;o gi&#7843;i tr&#236;nh - 14B/KNTC</h3>
<html:form action="/kntc_xm_bao_cao.do?method=show">
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red"> S&#7889; Quy&#7871;t &#273;&#7883;nh</font> <html:text property="kntcQdinhXm" styleClass="text" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Danh sách các phi&#x1EBF;u &#x111;ã l&#x1EAD;p</legend>
	<table cellpadding="0" cellspacing="0" border="0" class="display" id="tbl_listPhieuHen">
		<thead>
			<tr>
				<th>Mã</th>
				<th>Ng&#224;y l&#x1EAD;p</th>
				<th>Ng&#432;&#7901;i l&#7853;p B&#225;o c&#225;o gi&#7843;i tr&#236;nh</th>
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
	<fieldset><legend>Th&#244;ng tin b&#225;o c&#225;o gi&#7843;i tr&#236;nh</legend>
	<TABLE width="100%">
		<TBODY>
			<tr>
				<td>&#x110;&#x1ECB;a &#x111;i&#x1EC3;m l&#7853;p b&#225;o c&#225;o <font color="red">*</font></td>
				<td><html:text property="diaDiem" /></td>
				<td>Ng&#224;y l&#7853;p b&#225;o c&#225;o <font color="red">*</font></td>
				<td><html:text property="ngayLap" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			</tr>
			<tr>
				<td>T&#234;n &#273;o&#224;n/t&#7893; x&#225;c minh<font color="red">*</font></td>
				<td><html:text property="doanXm" style="width:100%" /></td>
				<td>Theo phi&#7871;u y&#234;u c&#7847;u gi&#7843;i tr&#236;nh ng&#224;y <font color="red">*</font></td>
				<td><html:textarea property="ngayPhieuYcgt" style="width:100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			</tr>
			<tr>
				<td>Ng&#432;&#7901;i l&#7853;p b&#225;o c&#225;o gi&#7843;i tr&#236;nh <font color="red">*</font></td>
				<td><html:text property="nguoiLapBc" /></td>
				<td>Ch&#7913;c v&#7909;</td>
				<td><html:text property="nguoiLapBcChucVu" /></td>
			</tr>
			<tr>
				<td>&#272;&#417;n v&#7883; c&#244;ng t&#225;c <font color="red">*</font></td>
				<td colspan="3"><html:textarea property="nguoiLapBcDvCt" onkeypress="imposeMaxLength(this);" style="width:100%" /></td>
			</tr>
			<tr>
				<td>N&#7897;i dung gi&#7843;i tr&#236;nh <font color="red">*</font></td>
				<td colspan="3"><html:textarea property="noiDungGt" onkeypress="imposeMaxLength(this);" style="width:100%" /></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
	<br>
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
    var url='kntc_xm_bao_cao.do?method=getListPhieu&maHs='+document.forms[0].kntcQdinhXm.value+'&t=14B/KNTC';
  	oTable=$("#tbl_listPhieuHen").dataTable({
     	"bJQueryUI":true,
		"sDom":'<"H"fr>t<"F"p>',
		"bSort": false,
		"bProcessing": true,
		"bServerSide": true,
		"sAjaxSource":url,
		"oLanguage":language		
	}).fnSetFilteringDelay(500);
});
function ghi(){
	document.forms[0].action="kntc_xm_bao_cao.do?method=save";
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
function showLovCanbo()
{	
	valueD = document.forms[0].nguoiNhanBc.value;
	if(valueD!=null && valueD!='' && valueD!='null')
		openWindow("danhmuc_canbo.do?method=lov&txtSearch="+valueD);
	else
		openWindow("danhmuc_canbo.do?method=lov");
}
function setData(values){
	var str_val= values.split("@@"); 
 	document.forms[0].nguoiNhanBc.value = str_val[1];				
}

</script>
</html:form>
<%@include file="/bottom.jsp"%>
