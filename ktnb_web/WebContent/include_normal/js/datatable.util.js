//datatable.util.js
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
function fnGetSelected(oTable)
{
	var aReturn = new Array();
	var aTrs = oTable.fnGetNodes();		
	for ( var i=0 ; i<aTrs.length ; i++ ) {
		if ( $(aTrs[i]).hasClass('row_selected') ) {
			aReturn.push( aTrs[i] );
		}
	}
	return aReturn;	
}
//P: Delete row
function fnDeleteRow(oTable){
	var anSelected = fnGetSelected( oTable );
	if(anSelected.length>0)oTable.fnDeleteRow( anSelected[0] );//P: neu co row dc chon thi xoa
	else alert(chua_chon_ban_ghi);//P: neu khong co row dc chon thi hien thong bao
}