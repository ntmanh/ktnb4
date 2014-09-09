<%@ include file="/top_bar.jsp"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="/kntc_bb.do?method=bb25B" method="post" styleId="form">
	<html:hidden property="arrDvDt" />
	<html:hidden property="arrCqDt" />
	<html:hidden property="arrTlkt" styleId="arrTlkt" />
	<h3 class="Header">Bi&#234;n b&#7843;n b&#224;n giao h&#7891; s&#417; v&#7909; vi&#7879;c c&#243; d&#7845;u hi&#7879;u t&#7897;i ph&#7841;m - M&#7851;u 25B/KNTC</h3>
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red"> S&#7889; h&#7891; s&#417;</font> <html:text property="maHoSo" style="width:250px" readonly="true" /></div>
	<div id="tabs">
	<ul>
		<li><a href="#tab0"><span>N&#7897;i dung bi&#234;n b&#7843;n</span></a></li>
		<li><a href="#tab1"><span>M&#7909;c l&#7909;c h&#7891; s&#417;</span></a></li>
	</ul>
	<div id="tab0"><jsp:include page="bien_ban_bg_tt_chung.jsp" /></div>
	<div id="tab1"><jsp:include page="bien_ban_bg_tlkt.jsp" /></div>
	</div>
	<br>
	<jsp:include page="../../../../button_bar_kntc.jsp" />
</html:form>
<script language="JavaScript">
var tab;
var oTableCBXL; /*P: Object table*/
var cRowID = 1; /*P: get current row id*/
var giCount = 1; /*P: Tong so row tren table*/
var giCountTlkt = 1;
var oTableTlkt;
$(function(){
	tab=$("#tabs");
	tab.tabs();
	//P: init datatable
  	oTableCBXL=$("#tbl_donViBanGiao").dataTable({
     	"bJQueryUI":true,"sDom":'<"H"fr>t<"F"p>',"bSort": false,"bFilter": false,"oLanguage":language,
		//P: Hien thi so thu tu tren table
		"fnDrawCallback": function ( oSettings ) {
			/* Need to redo the counters if filtered or sorted */
			if ( oSettings.bSorted || oSettings.bFiltered )
			{
				for ( var i=0, iLen=oSettings.aiDisplay.length ; i<iLen ; i++ )
				{
					$('td:eq(0)', oSettings.aoData[ oSettings.aiDisplay[i] ].nTr ).html( i+1 );
				}
			}
		},
		"aoColumnDefs": [
			{ "bSortable": false, "aTargets": [ 0 ] }
		],
		"aaSorting": [[ 1, 'asc' ]]	
	}).fnSetFilteringDelay(500);
    $("#tbl_donViBanGiao tbody").click(function(event) {
		$(oTableCBXL.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	});
	//P: Delete row when click button id="deleteRow"
	$('#deleteRow1').click( function() {
		var anSelected = fnGetSelected( oTable );
		if(anSelected.length>0) {
			oTableCBXL.fnDeleteRow( anSelected[0] );
			giCount--;
		}
		else showMessage(chua_chon_ban_ghi);
	});
    var url='';    
    
    // Tai lieu kem theo
    //Table
	$('#arrTlkt').val('');	
	$("#tlkt tbody").click(function(event) {
		$(oTableTlkt.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');	   
	});					
	/* Add a click handler for the delete row */
	$('#deleteRow3').click( function() {
		var anSelected = fnGetSelected( oTableTlkt );
		if(anSelected.length>0) {
			oTableTlkt.fnDeleteRow( anSelected[0] );
			giCountTlkt--;
		}
		else showMessage(chua_chon_ban_ghi);		
	});			
	oTableTlkt = $("#tlkt").dataTable(
		{"bJQueryUI":true,"bPaginate": false,
		"bInfo": false,"sDom":'T<"clear">lfrtip',"bSort": false,
		"bFilter":false,"oLanguage":language});	
		
	 var ghiTC = "";
	 <logic:present name="ghiThanhcong">
	     	ghiTC = '<%=request.getAttribute("ghiThanhcong")%>';
	 </logic:present>
	 if(ghiTC=='1')
	   alert('L\u01B0u th\u00E0nh c\u00F4ng!'); 
	 else  if(ghiTC=='0')
	   alert('L\u1ED7i khi ghi d\u1EEF li\u1EC7u!!!');  
});

//P: Show lov can bo
function showLovCanbo(index)
{
	cRowID = index;
	tenCB = document.forms[0].tenCanBo.value;
	if(tenCB!=null && tenCB!='' && tenCB!='null')
		openWindow("danhmuc_canbo.do?method=lov&txtSearch="+normalizeString4SQL(tenCB));
	else
		openWindow("danhmuc_canbo.do?method=lov");
	
}
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
function fnClickAddRowDvBg() {
	giCount++;
	   var row= '<tr><td style="text-align: center"></td><td> <input type="hidden" name="maCanBo1" id="maCanBo'+giCount+'" /> <input type="text" name="tenCanBo" id="tenCanBo'
	   +giCount+'" style="width: 88%" />&nbsp<input type="button" class="button" name="btnCb" value="..."onclick="showLovCanbo('
	   +giCount+')" /></td><td><input type="text" name="chucVu" style="width: 100%" id="chucVu'
	   +giCount+'" readonly="true"></td></tr>';
	oTableCBXL.fnAddTr( $(row)[0] );	
}
//P: Set data tu form child sang form parent
function setData(values){
	var str_val= values.split("@@");	  	
	document.getElementById('maCanBo'+cRowID).value = str_val[0];	
 	document.getElementById('tenCanBo'+cRowID).value= str_val[1];
 	document.getElementById('chucVu'+cRowID).value= str_val[2];
// 	document.forms[0].canBoBiKNTCTen.value= str_val[1];	
}
//Save data to DB
function fnSave(){
	var arrCB='';
	for(i=1;i<=giCount;i++){
		if(!isEmpty(document.getElementById('tenTv'+i).value))//P: bo qua neu row khong co thong tin can bo
		{
			arrCB += document.getElementById('tenTV'+i).value;	//ma can bo
			arrCB += document.getElementById('cv'+i).value;	//ma can bo
			if(i<giCount)
				arrCB += ',@@'; //vai tro
		}
	}	
	document.forms[0].arrDvDt.value = arrCB;
	document.forms[0].action="kntc_bb.do?method=saveBb25B";
	document.forms[0].submit();
}

function ghi(){
	if(validForm()) {
		fnSave();
	}
}
function print(){
	//if(validForm()) {
		document.forms[0].action="kntc_bb.do?method=inBb25B";
		document.forms[0].submit();
	//}
}
function validForm() {
	if(!isRequired(document.forms[0].diaDiem,'Ch\u01B0a nh\u1EADp \u0111\u1ECBa \u0111i\u1EC3m')) return false;
	if(!isRequired(document.forms[0].thoiDiem,'Ch\u01B0a nh\u1EADp ng\u00E0y l\u1EADp')) return false;
	return true;
}

function fnClickAddRowTlkt() {
	var row = '<tr><td><input type="text" style="width: 100%" name="tenTL" id="tenTL'+giCountTlkt+'" maxlength="50"></td><td><input type="text" name="soTrangTL" id="soTrangTL'+giCountTlkt+'" maxlength="3" onblur="isNumber(this,"i");" style="width: 100%"></td><td><input type="text" name="tinhTrang" id="tinhTrang'+giCountTlkt+'" style="width: 100%"  /></td></tr>';
	oTableTlkt.fnAddTr( $(row)[0] );
	giCountTlkt++;
}

</script>
<%@ include file="/bottom.jsp"%>
