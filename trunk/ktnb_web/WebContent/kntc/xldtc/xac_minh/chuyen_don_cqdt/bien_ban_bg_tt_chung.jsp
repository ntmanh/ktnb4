<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<fieldset><legend>Th&#244;ng tin b&#224;n giao h&#7891; s&#417;</legend>
<table width="100%">
	<tr>
		<td width="15%">&#272;&#7883;a &#273;i&#7875;m<font style="color: red">*</font></td>
		<td width="35%"><html:text property="diaDiem" style="width: 100%" /></td>
		<td width="15%">Th&#7901;i gian <font style="color: red">*</font></td>
		<td width="35%"><html:text property="thoiDiem" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
	</tr>
</table>
<fieldset><legend>&#272;&#417;n v&#7883; b&#224;n giao h&#7891; s&#417; v&#7909; vi&#7879;c</legend> &#272;&#7841;i di&#7879;n <html:text property="donViBanGiao" style="width:80%" /> <br />
<table cellpadding="0" cellspacing="0" border="0" id="tbl_donViBanGiao" class="display">
	<thead>
		<tr>
			<th width="10%">STT</th>
			<th width="70%">Th&#224;nh vi&#234;n</th>
			<th width="20%">Ch&#7913;c v&#7909;</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="text-align: center"></td>
			<td><input type="hidden" name="maCanBo1" id="maCanBo1" /> <input type="text" name="tenCanBo" id="tenCanBo1" style="width: 88%" />&nbsp;<input type="button" class="button" name="btnCb" value="..." onclick="showLovCanbo(1)" size="15%"></td>
			<td><input type="text" name="chucVu" id="chucVu1" style="width: 100%" readonly="readonly"></td>
		</tr>
	</tbody>
</table>
<div style="text-align: right; width: 100%"><INPUT type="button" class="button" name="btnAdd" onclick="fnClickAddRowDvBg();" value="Th&#234;m"> <INPUT type="button" class="button" name="btnXoa" id="deleteRow1" value="X&#243;a"></div>
</fieldset>
<fieldset><legend>C&#417; quan &#273;i&#7873;u tra (ho&#7863;c vi&#7879;n ki&#7875;m so&#225;t)</legend> &#272;&#7841;i di&#7879;n <html:text property="coQuanDieuTra" style="width:80%" /> <br />
<table cellpadding="0" cellspacing="0" border="0" id="tbl_coQuanDieuTra" class="display">
	<thead>
		<tr>
			<th width="10%">STT</th>
			<th width="70%">Th&#224;nh vi&#234;n</th>
			<th width="20%">Ch&#7913;c v&#7909;</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="text-align: center"></td>
			<td><input type="text" name="tenTv" id="tenTv1" style="width: 85%" /></td>
			<td><input type="text" name="cv" id="cv1" style="width: 100%" readonly="readonly"></td>
		</tr>
	</tbody>
</table>
<div style="text-align: right; width: 100%"><INPUT type="button" class="button" name="btnAdd" onclick="fnClickAddRowCqdt();" value="Th&#234;m"> <INPUT type="button" class="button" name="btnXoa" id="deleteRow2" value="X&#243;a"></div>
</fieldset>
<table width="100%">
	<tr>
		<td width="15%">S&#7889; trang t&#224;i li&#7879;u <font style="color: red">*</font></td>
		<td width="35%"><html:text property="soTrangTl" style="width: 100%" /></td>
		<td width="15%">S&#7889; b&#7857;ng ch&#7913;ng <font style="color: red">*</font></td>
		<td width="35%"><html:text property="soBangChung" style="width: 100%" /></td>
	</tr>
	<tr>
		<td>Vi&#7879;c giao nh&#7853;n ho&#224;n th&#224;nh v&#224;o l&#250;c <font style="color: red">*</font></td>
		<td colspan="3"><html:text property="thoiDiemHoanThanh" style="width: 100%" onblur="isTime(this)" onkeypress="return formatTime(event, this)" /></td>
	</tr>
</table>
</fieldset>
<script language="JavaScript">
var oTableCQDT; /*P: Object table*/
var giCount2 = 1; /*P: Tong so row tren table*/
$(function(){
	//P: init datatable
  	oTableCQDT=$("#tbl_coQuanDieuTra").dataTable({
     	"bJQueryUI":true,"sDom":'<"H"fr>t<"F"p>',"bSort": true,	"bFilter": false,"oLanguage":language,
     	/P: Hien thi so thu tu tren table
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
    $("#tbl_coQuanDieuTra tbody").click(function(event) {
		$(oTableCQDT.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	});
	//P: Delete row when click button id="deleteRow"
	$('#deleteRow2').click( function() {
		var anSelected = fnGetSelected( oTable );
		if(anSelected.length>0) {
			oTableCQDT.fnDeleteRow( anSelected[0] );
			giCount2--;
		}
		else showMessage(chua_chon_ban_ghi);
	});
    var url='';    
});
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
function fnClickAddRowCqdt() {
	giCount2++;
	   var row= '<tr><td style="text-align: center"></td> <td><input type="text" name="tenTv" id="tenTv'+giCount2+'" style="width: 85%" /></td> <td><input type="text" name="cv" id="cv'+giCount2+'" style="width:100%" readonly="readonly"></td></tr>';
	oTableCQDT.fnAddTr( $(row)[0] );	
}
</script>
