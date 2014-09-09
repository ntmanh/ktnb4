<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<h3 class="Header">Phân công cán bộ xử lý</h3>
<html:form action="/kntc_phan_cong_can_bo.do?method=show">
	<html:hidden property="countCanBo" />
	<html:hidden property="arrCanBo" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red">Số hồ sơ</font> <html:text property="maHoSo" styleId="ma" style="width:250px" readonly="true" /></div>
	<fieldset><legend>Danh sách cán bộ xử lý</legend>
	<div style="width: 100%;">Ngày phân công <html:text property="ngayPhanCong"></html:text></div>
	<br />
	<table cellpadding="0" cellspacing="0" border="0" id="tbl_listCBXL" class="display">
		<thead>
			<tr>
				<th>Thành viên</th>
				<th>Đơn vị</th>
				<th>Chức vụ</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="text" id="maCanBo1" style="display: none" /> <input type="text" name="tenCanBo" id="tenCanBo1" size="15%">&nbsp; <input type="button" class="button" name="btnCb" value="..." onclick="showLovCanbo(1)" size="15%"></td>
				<td><input type="text" name="donVi" id="donVi1" size="30%" readonly="true"></td>
				<td><input type="text" name="chucVu" id="chucVu1" size="30%" readonly="true"></td>
			</tr>
		</tbody>
	</table>
	<div style="text-align: right; width: 100%; visibility: hidden;"><INPUT type="button" class="button" name="btnAdd" onclick="fnClickAddRow();" value="Thêm"> <INPUT type="button" class="button" name="btnXoa" id="deleteRow" value="Xóa"></div>
	</fieldset>
	<fieldset style="text-align: center"><INPUT type="button" class="button" name="btnSave" value="Ghi" onclick="fnSave()"> <INPUT type="button" class="button" name="btnClose" value="Đóng" onclick="javascript:history.go(-1)"></fieldset>
	<!--Lich su phan cong-->
	<fieldset><legend>Lịch sử phân công</legend>
	<table cellpadding="0" cellspacing="0" border="0" id="tbl_lichSuCBXL" class="display">
		<thead>
			<tr>
				<th width="15%">Lần thay đổi</th>
				<th width="25%">Thành viên</th>
				<th width="25%">Đơn vị</th>
				<th width="20%">Chức vụ</th>
				<th width="15%">Ngày cập nhật</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="5" style="text-align: center;">Loading data from server.....</td>
			</tr>
		</tbody>
	</table>
	</fieldset>
</html:form>
<script language="JavaScript">
var oTableNew;
var oTable;
var cRowID = 1;
var giCount = 1;
$(function(){
  	oTableNew=$("#tbl_listCBXL").dataTable({
     	"bJQueryUI":true, "sDom":'<"H"fr>t<"F"p>',"bFilter": false,"bSort": false, "oLanguage":language,
		"aoColumnDefs": [{"bSortable": false, "aTargets": [ 0 ]}], "aaSorting": [[ 1, 'asc' ]]	
	}).fnSetFilteringDelay(500);
    $("#tbl_listCBXL tbody").click(function(event) {
		$(oTableNew.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	});
	$('#deleteRow').click( function() {
		var anSelected = fnGetSelected( oTableNew );
		if(anSelected.length>0) {
			oTableNew.fnDeleteRow( anSelected[0] );
			giCount--;
		}
		else showMessage(chua_chon_ban_ghi);
	});    
	
	var url='kntc_phan_cong_can_bo.do?method=getLichSu&id='+$('#ma').val();
  	oTable=$("#tbl_lichSuCBXL").dataTable({
     	"bJQueryUI":true, "sDom":'<"H"fr>t<"F"p>', "bSort": true, "bFilter": false,"bSort": false,"oLanguage":language,
		"aoColumnDefs": [{"bSortable": false, "aTargets": [ 0 ]}],"sAjaxSource":url,"aaSorting": [[ 1, 'asc' ]]	
	}).fnSetFilteringDelay(500);
    $("#tbl_lichSuCBXL tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	});
});

$(document).ready(function(){
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
 }
);

function showLovCanbo(index)
{
	cRowID = index;
	tenCB = document.forms[0].tenCanBo.value;
	if(tenCB!=null && tenCB!='' && tenCB!='null')
		openWindow("danhmuc_canbo.do?method=lov&txtSearch="+normalizeString4SQL(tenCB));
	else
		openWindow("danhmuc_canbo.do?method=lov");	
}

$.fn.dataTableExt.oApi.fnAddTr = function ( oSettings, nTr, bRedraw ) {
	if ( typeof bRedraw == 'undefined' ){
		bRedraw = true;
	}	
	var nTds = nTr.getElementsByTagName('td');
	if ( nTds.length != oSettings.aoColumns.length )
	{
		alert( 'Warning: not adding new TR - columns and TD elements must match' );
		return;
	}	
	var aData = [];
	for ( var i=0 ; i<nTds.length ; i++ )
	{
		aData.push( nTds[i].innerHTML );
	}	
	/* Add the data and then replace DataTable's generated TR with ours */
	var iIndex = this.oApi._fnAddData( oSettings, aData );
	oSettings.aoData[ iIndex ].nTr = nTr;	
	oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();	
	if ( bRedraw )
	{
		this.oApi._fnReDraw( oSettings );
	}
}
//P: Get selected row
function fnGetSelected( oTableLocal )
{
	var aReturn = new Array();
	var aTrs = oTableLocal.fnGetNodes();		
	for ( var i=0 ; i<aTrs.length ; i++ ) {
		if ( $(aTrs[i]).hasClass('row_selected') ) {
			aReturn.push( aTrs[i] );
		}
	}
	return aReturn;
}
//P: Them row moi cho table
function fnClickAddRow() {
	giCount++;
	   var row= '<tr><td><input type="text" id="maCanBo'+giCount+'" style="display: none;"/><input type="text" name="tenCanBo" id="tenCanBo'
	   +giCount+'" size="15%">&nbsp<input type="button" class="button" name="btnCb" value="..."onclick="showLovCanbo('
	   +giCount+')" size="15%"></td><td><input type="text" name="donVi" size="30%" id="donVi'
	   +giCount+'" readonly="true"></td><td><input type="text" name="chucVu" size="30%" id="chucVu'
	   +giCount+'" readonly="true"></td></tr>';
	oTableNew.fnAddTr( $(row)[0] );	
}
//P: Set data tu form child sang form parent
function setData(values){
	var str_val= values.split("@@");	  	
	document.getElementById('maCanBo'+cRowID).value = str_val[0];	
 	document.getElementById('tenCanBo'+cRowID).value= str_val[1];
 	document.getElementById('chucVu'+cRowID).value= str_val[2];
 	document.getElementById('donVi'+cRowID).value= str_val[4];
// 	document.forms[0].canBoBiKNTCTen.value= str_val[1];	
}
//Save data to DB
function fnSave(){
	var arrCB='';
	for(i=1;i<=giCount;i++){
		if(!isEmpty(document.getElementById('tenCanBo'+i).value))//P: bo qua neu row khong co thong tin can bo
		{
			arrCB += document.getElementById('maCanBo'+i).value+',';//ma can bo
			arrCB += document.getElementById('tenCanBo'+i).value+',';
			arrCB += document.getElementById('donVi'+i).value+',';	
			arrCB += document.getElementById('chucVu'+i).value;	
			if(i<giCount)
				arrCB += ',@@'; //vai tro			
		}
	}	
	document.forms[0].arrCanBo.value = arrCB;
	//alert(arrCB);
	document.forms[0].countCanBo.value = giCount;
	//showMessage(document.forms[0].arrCanBo.value);
	document.forms[0].action="kntc_phan_cong_can_bo.do?method=saveListCanBo";
	document.forms[0].submit();
}
</script>
<%@include file="/bottom.jsp"%>
