<%@ include file="/top_bar.jsp"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<h3 class="Header">Th&#244;ng tin thi h&#224;nh gi&#7843;i quy&#7871;t</h3>
<html:form action="/kntc_qdgq.do?method=theodoi">
	<fieldset><legend>Th&#244;ng tin thi h&#224;nh gi&#7843;i quy&#7871;t</legend>
	<TABLE width="100%">
		<TBODY>
			<tr>
				<td width="10%">Mã h&#x1ED3; s&#x1A1;</td>
				<td width="40%"><html:text styleClass="text" property="maHoSo" style="width:100%" readonly="true" /></td>
				<td width="50%"><html:checkbox property="ketLuan" value="1" />K&#7871;t th&#250;c thi h&#224;nh gi&#7843;i quy&#7871;t</td>
			</tr>
			<tr>
				<td>Ng&#224;y l&#7853;p <font color="red">*</font></td>
				<td><html:text property="thoiDiem" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Chi ti&#7871;t <font color="red">*</font></td>
				<td colspan="3"><html:textarea property="noidung" onkeypress="imposeMaxLength(this);" style="width:100%" /></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
	<br>
	<fieldset><legend>Th&#244;ng tin thi h&#224;nh</legend>
	<table cellpadding="0" cellspacing="0" border="0" id="tbl_theodoi" class="display">
		<thead>
			<tr>
				<th width="15%">M&#227;</th>
				<th width="15%">Ng&#224;y</th>
				<th width="70%">Chi ti&#7871;t</th>
			</tr>
		</thead>
		<tbody>
			<tr align="center">
				<td colspan="3" class="dataTables_empty">.....</td>
			</tr>
		</tbody>
	</table>
	</fieldset>
	<table width="100%">
		<tr align="center">
			<td align="center"><INPUT type="button" class="button" name="btnSave" value="Ghi" onclick="fnSave()"> <INPUT type="button" class="button" name="btnClose" value="&#272;&#243;ng" onclick="goHomeKntc();"></td>
		</tr>
	</table>
</html:form>
<script language="JavaScript">
var oTable; /*P: Object table*/
var cRowID = 1; /*P: get current row id*/
var giCount = 1; /*P: Tong so row tren table*/
$(function(){
	//P: init datatable
	var url='kntc_qdgq.do?method=getListHsTheoDoi&maHs='+document.forms[0].maHoSo.value;
  	oTable=$("#tbl_theodoi").dataTable({
     	"bJQueryUI":true,
		"sDom":'<"H"fr>t<"F"p>',
		"bSort": false,
		"bFilter": false,
		"bProcessing": true,
		"bServerSide": true,
		"sAjaxSource":url,
		"oLanguage":language,
		"fnDrawCallback": function ( oSettings ) {
			/* Need to redo the counters if filtered or sorted */
			if ( oSettings.bSorted || oSettings.bFiltered )
			{
				for ( var i=0, iLen=oSettings.aiDisplay.length ; i<iLen ; i++ )
				{
					$('td:eq(0)', oSettings.aoData[ oSettings.aiDisplay[i] ].nTr ).html( i+1 );
				}
			}
		}	
	}).fnSetFilteringDelay(500);
    $("#tbl_theodoi tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	});
});
//Show message sau khi save thong tin. Thanh cong hoac khong thanh cong
$(document).ready(function(){
	 var ghiTC = "";
	 <logic:present name="ghiThanhcong">
	     	ghiTC = '<%=request.getAttribute("ghiThanhcong")%>';
	 </logic:present>
	 if(ghiTC=='1')
	   alert('L\u01B0u th\u00E0nh c\u00F4ng!'); 
	 else  if(ghiTC=='0')
	   alert('L\u1ED7i khi ghi d\u1EEF li\u1EC7u!!!');  		
 }
);

//P: Datatable Function
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
	   var row= '<tr><td><input type="text" name="ma'+giCount+'" id="ma'+giCount+'" readonly="readonly"/></td><td><input type="text" id="ngay'+giCount+'"  name="ngay'+giCount+'" onkeypress="return formatDate(event, this)" onblur="isDate(this)"/></td><td><TEXTAREA NAME="chitiet'+giCount+'" id="chitiet'+giCount+'" COLS=140 ROWS=2 ></TEXTAREA></td></tr>';
	oTable.fnAddTr( $(row)[0] );	
}

//Save data to DB
function fnSave(){
	document.forms[0].action="kntc_qdgq.do?method=saveTheodoi";
	document.forms[0].submit();
}

</script>
<%@include file="/bottom.jsp"%>