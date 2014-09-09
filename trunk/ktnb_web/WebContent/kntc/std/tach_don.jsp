<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<html:form action="/kntc_tach_don.do?method=tachDon" method="post">
	<html:hidden property="arrTlktKN" styleId="arrTlktKN" />
	<html:hidden property="arrTlktTC" styleId="arrTlktTC" />
	<h3 class="Header">Tách nội dung KNTC</h3>
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red"> Số hồ sơ</font><html:text property="maHoSo" style="width:250px" readonly="true" /></div>
	<fieldset><legend>Nội dung tóm tắt đơn</legend> <html:textarea property="noiDungDon" onkeypress="imposeMaxLength(this);" style="width:100%;height:80px" readonly="true" /></fieldset>
Số hồ sơ KN
<html:text property="maHoSoKN" style="width:50%" readonly="true" />
	<br>
	<fieldset><legend>Nội dung đơn KN</legend> <html:textarea property="noiDungKN" onkeypress="imposeMaxLength(this);" style="width:100%;height:80px;" /> <br />
	<table width="100%" cellpadding="0" cellspacing="0" border="0" class="display" id="tlktKN">
		<thead>
			<tr>
				<th width="20%">Tên tài liệu</th>
				<th width="25%">Số trang</th>
				<th width="20%">Tình trạng</th>
				<th width="25%">Chọn</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="4" class="dataTables_empty">Đang lấy dữ liệu...</td>
			</tr>
		</tbody>
	</table>
	</fieldset>	
	Số hồ sơ TC
	<html:text property="maHoSoTC" style="width:50%" readonly="true" />
	<br>
	<fieldset><legend>Nội dung đơn TC</legend> <html:textarea property="noiDungTC" onkeypress="imposeMaxLength(this);" style="width:100%;height:80px;" /> <br />
	<table width="100%" cellpadding="0" cellspacing="0" border="0" class="display" id="tlktTC">
		<thead>
			<tr>
				<th width="20%">Tên tài liệu</th>
				<th width="25%">Số trang</th>
				<th width="20%">Tình trạng</th>
				<th width="25%">Chọn</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="4" class="dataTables_empty">Đang lấy dữ liệu...</td>
			</tr>
		</tbody>
	</table>
	</fieldset>
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" class="button" value='Lưu' name="save" onclick="ghi();"> <input type="button" class="button" value='Đóng' name="exit" onclick="goHomeKntc();"></td>
		</tr>
	</table>
</html:form>
<script language="JavaScript">
var oTableKN; 
var oTableTC;
var giCount = 0; 
var giCountTC = 0;
$(function(){
	 var ghiTC = "";
	 <logic:present name="ghiThanhcong">
	     	ghiTC = '<%=request.getAttribute("ghiThanhcong")%>';
	 </logic:present>
	 if(ghiTC=='1'){
		alert('Lưu thành công'); 
	 }
	 else  if(ghiTC=='0'){
		alert('Lỗi khi ghi dữ liệu!!!'); 
	 } 
	<%request.removeAttribute("ghiThanhcong");%>
	$('#arrTlktKN').val('');
	//P: init datatable
	var url='kntc_tach_don.do?method=getListTlktKnTachDon&id='+document.forms[0].maHoSo.value;
  	oTableKN=$("#tlktKN").dataTable({"bJQueryUI":true,"sDom":'<"H"fr>t<"F"p>',"bSort": false,	"sScrollY": "100px","sScrollX": "750px","bScrollCollapse": true,"bPaginate": false,"bFilter": false,	"bProcessing": true,	"bServerSide": true,	"sAjaxSource":url,	"oLanguage":language}).fnSetFilteringDelay(200);
 
    $('#arrTlktTC').val('');
	//P: init datatable
  	var url='kntc_tach_don.do?method=getListTlktTcTachDon&id='+document.forms[0].maHoSo.value;
  	oTableTC=$("#tlktTC").dataTable({"bJQueryUI":true,"sDom":'<"H"fr>t<"F"p>',"bSort": false,	"sScrollY": "100px","sScrollX": "750px","bScrollCollapse": true,"bPaginate": false,"bFilter": false,	"bProcessing": true,	"bServerSide": true,	"sAjaxSource":url,	"oLanguage":language}).fnSetFilteringDelay(200);
});
function ghi(){	
	try{
	var arrKN='';
	obj = document.forms[0].dmTlKN;	
    if (isArray(obj))
      for(i=0;i<obj.length;i++)
        if (obj[i].checked)  arrKN=arrKN+','+obj[i].value;
    else
      if (obj.checked)      arrKN=arrKN+','+obj.value;
    document.forms[0].arrTlktKN.value = arrKN;
	//alert(arrKN);	
	var arrTC='';
	obj =document.forms[0].dmTlTC;	
    if (isArray(obj))
      for(i=0;i<obj.length;i++)
        if (obj[i].checked)  arrTC=arrTC+','+obj[i].value;
    else
      if (obj.checked)      arrTC=arrTC+','+obj.value;
    document.forms[0].arrTlktTC.value = arrTC;
	}catch(e){}
	//alert(arrTC);
	document.forms[0].action="kntc_tach_don.do?method=saveTachDon";
	document.forms[0].submit();	
}
</script>
<%@ include file="/bottom.jsp"%>
