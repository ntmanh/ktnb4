<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Qu&#7843;n l&#253; v&#259;n b&#7843;n ch&#7881; &#273;&#7841;o c&#244;ng t&#225;c KNTC</h3>
<html:form action="/kntc_tg.do?method=vb">
	<fieldset><legend>Danh sách l&#253; v&#259;n b&#7843;n ch&#7881; &#273;&#7841;o</legend>
	<table cellpadding="0" cellspacing="0" border="0" class="display" id="tbl_listPhieuHen">
		<thead>
			<tr>
				<th width="25%">T&#234;n l&#7899;p</th>
				<th width="25%">&#272;&#7883;a &#273;i&#7875;m</th>
				<th width="20%">T&#7915; ng&#224;y - &#272;&#7871;n ng&#224;y</th>
				<th width="20%" align="right" nowrap="nowrap">S&#7889; ng&#432;&#7901;i tham gia</th>
				<th width="10%">Ch&#7885;n</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="5" class="dataTables_empty">.....</td>
			</tr>
		</tbody>
	</table>
	<TABLE width="100%">
		<tr>
			<td colspan="5" align="right"><input type="button" style="width: 60" class="button" value='X&#243;a' name="del" onclick="del();"> <input type="button" style="width: 60" class="button" value='S&#7917;a' name="edit" onclick="goHomeKntc();"></td>
		</tr>
	</TABLE>
	</fieldset>
	<br>
	<fieldset><legend>Th&#244;ng tin v&#259;n b&#7843;n</legend>
	<table width="100%">
		<tr>
			<td>T&#234;n v&#259;n b&#7843;n <font color="red">*</font></td>
			<td colspan="3"><html:text property="tenLop" style="width: 100%" /></td>
		</tr>
		<tr>
			<td width="15%">&#272;&#7883;a &#273;i&#7875;m <font color="red">*</font></td>
			<td width="35%"><html:text property="diaDiem" style="width: 100%" /></td>
			<td width="15%">S&#7889; ng&#432;&#7901;i tham gia <font color="red">*</font></td>
			<td width="35%"><html:text property="soNguoi" style="width: 100%" maxlength="5" onkeypress=" return formatNumber(event,this);" onblur="isNumber(this);" /></td>
		</tr>
		<tr>
			<td>T&#7915; ng&#224;y <font color="red">*</font></td>
			<td><html:text property="tuNgay" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this);dateValid();" /></td>
			<td>&#272;&#7871;n ng&#224;y <font color="red">*</font></td>
			<td><html:text property="denNgay" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this);dateValid();" /></td>
		</tr>
	</table>
	</fieldset>
	<jsp:include page="../../button_bar_kntc.jsp" />
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
	var url='kntc_tg.do?method=getListLopDt';
  	oTable=$("#tbl_listPhieuHen").dataTable({ "bJQueryUI":true, "sDom":'<"H"fr>t<"F"p>', "bSort": false, "bProcessing": true, "bServerSide": true, "sAjaxSource":url, "oLanguage":language}).fnSetFilteringDelay(500);
});
function dateValid(){
	if(compareDate(document.forms[0].tuNgay,document.forms[0].denNgay))
		return false;
	return true;	
}
function ghi(){	
	if(isRequired(document.forms[0].tenLop,'Ch\u01B0a c\u00F3 th\u00F4ng tin l\u1EDBp h\u1ECDc')
	&& isRequired(document.forms[0].diaDiem,'Ch\u01B0a c\u00F3 th\u00F4ng tin \u0111\u1ECBa \u0111i\u1EC3m')
	&& isRequired(document.forms[0].soNguoi,'Ch\u01B0a c\u00F3 th\u00F4ng tin s\u1ED1 ng\u01B0\u1EDDi tham gia')
	&& isRequired(document.forms[0].tuNgay,'Ch\u01B0a c\u00F3 th\u00F4ng tin ng\u00E0y b\u1EAFt \u0111\u1EA7u')
	&& isRequired(document.forms[0].denNgay,'Ch\u01B0a c\u00F3 th\u00F4ng tin ng\u00E0y k\u1EBFt th\u00FAc')
	)
	{
		document.forms[0].action="kntc_tg.do?method=savelopDt";
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
</script>
</html:form>
<%@include file="/bottom.jsp"%>
