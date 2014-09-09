<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Phi&#7871;u y&#234;u c&#7847;u gi&#7843;i tr&#236;nh - 14A/KNTC</h3>
<html:form action="/kntc_xm_phieu_yc.do?method=ycgt">
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red"> S&#7889; Quy&#7871;t &#273;&#7883;nh</font> <html:text property="kntcQdinhXm" styleClass="text" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Danh sách các phi&#x1EBF;u &#x111;ã l&#x1EAD;p</legend>
	<table cellpadding="0" cellspacing="0" border="0" class="display" id="tbl_listPhieuHen">
		<thead>
			<tr>
				<th>Mã phi&#7871;u</th>
				<th>Ng&#224;y l&#x1EAD;p phi&#x1EBF;u</th>
				<th>&#272;&#417;n v&#7883; t&#7893; ch&#7913;c c&#225; nh&#226;n &#273;&#432;&#7907;c y&#234;u c&#7847;u gi&#7843;i tr&#236;nh</th>
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
	<fieldset><legend>Th&#244;ng tin phi&#7871;u y&#234;u c&#7847;u</legend>
	<TABLE width="100%">
		<TBODY>
			<tr>
				<td>&#x110;&#x1ECB;a &#x111;i&#x1EC3;m l&#7853;p phi&#7871;u <font color="red">*</font></td>
				<td><html:text property="diaDiem" /></td>
				<td>Ng&#224;y l&#7853;p phi&#7871;u <font color="red">*</font></td>
				<td><html:text property="ngayLap" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			</tr>
			<tr>
				<td>&#272;&#417;n v&#7883; t&#7893; ch&#7913;c c&#225; nh&#226;n &#273;&#432;&#7907;c y&#234;u c&#7847;u gi&#7843;i tr&#236;nh<font color="red">*</font></td>
				<td colspan="3"><html:text property="donViYcgt" style="width:100%" /></td>
			</tr>
			<tr>
				<td>Y&#234;u c&#7847;u gi&#7843;i tr&#236;nh <font color="red">*</font></td>
				<td colspan="3"><html:textarea property="yeuCauYcgt" onkeypress="imposeMaxLength(this);" style="width:100%" /></td>
			</tr>
			<tr>
				<td>Th&#7901;i gian cung c&#7845;p gi&#7843;i tr&#236;nh <font color="red">*</font></td>
				<td><html:text property="thoiDiemYcgt" onblur="isTime(this)" onkeypress="return formatTime(event, this)" /></td>
				<td>&#272;&#7883;a &#273;i&#7875;m cung c&#7845;p</td>
				<td><html:text property="diaDiemYcgt" /></td>
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
    var url='kntc_xm_phieu_yc.do?method=getListPhieu&maHs='+document.forms[0].kntcQdinhXm.value+'&t=14A/KNTC';
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
	if(validForm()) {
		document.forms[0].action="kntc_xm_phieu_yc.do?method=saveYcgt";
		document.forms[0].submit();
	}
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


function validForm() {	
//	if(!isRequired(document.forms[0].diaDiem,'Ch\u01B0a nh\u1EADp \u0111\u1ECBa \u0111i\u1EC3m l\u1EADp phi\u1EBFu')) return false;
//	if(!isRequired(document.forms[0].ngayLap,'Ch\u01B0a nh\u1EADp ng\u00E0y l\u1EADp phi\u1EBFu')) return false;
	if(!isRequired(document.forms[0].donViYcgt,'Ch\u01B0a nh\u1EADp \u0111\u01A1n v\u1ECB, t\u1ED5 ch\u1EE9c c\u00E1c nh\u00E2n \u0111\u01B0\u1EE3c y\u00EAu c\u1EA7u gi\u1EA3i tr\u00ECnh')) return false;
	if(!isRequired(document.forms[0].yeuCauYcgt,'Ch\u01B0a nh\u1EADp y\u00EAu c\u1EA7u gi\u1EA3i tr\u00ECnh')) return false;
	if(!isRequired(document.forms[0].thoiDiemYcgt,'Ch\u01B0a nh\u1EADp th\u1EDDi gian cung c\u1EA5p gi\u1EA3i tr\u00ECnh')) return false;
	return true;
}
</script>
</html:form>
<%@include file="/bottom.jsp"%>
