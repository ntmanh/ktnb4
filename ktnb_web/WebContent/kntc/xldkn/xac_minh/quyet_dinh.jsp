<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Bi&#234;n b&#7843;n c&#244;ng b&#7889; Quy&#7871;t &#273;&#7883;nh x&#225;c minh - M&#7851;u 12/KNTC</h3>
<html:form action="/kntc_xac_minh.do?method=bb">
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red"> S&#7889; h&#7891; s&#417;</font> <a href="../../xac_minh/chuaco.do" target="#"><html:text property="maHoSo" styleClass="text" style="width:250px" value="110104071418000000000000005902" readonly="true" /></a>
	</div>
	<br>
	<fieldset><legend>Bi&#234;n b&#7843;n l&#224;m vi&#7879;c</legend>
	<table width="100%">
		<tr>
			<td width="15%" style="text-align: right;">&#272;&#7883;a &#273;i&#7875;m</td>
			<td width="35%"><html:text property="diaDiem" style="width:100%" /></td>
			<td width="15%" style="text-align: right;">Ng&#224;y ra quy&#7871;t &#273;&#7883;nh</td>
			<td width="35%"><html:text property="thoiDiem" style="width:100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">N&#7897;i dung l&#224;m vi&#7879;c</td>
			<td colspan="3"><html:textarea property="noidung" onkeypress="imposeMaxLength(this);" style="width:100%;height:80px" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">S&#7889; b&#7843;n in ra</td>
			<td width="35%"><html:text property="soBanIn" value="2" style="width:100%" /></td>
			<td width="15%" style="text-align: right;">S&#7889; b&#234;n l&#224;m vi&#7879;c</td>
			<td width="35%"><html:text property="soBen" value="2" style="width:100%" /></td>
		</tr>
	</table>
	<fieldset><legend>C&#225;c b&#234;n li&#234;n quan</legend>
	<table width="50%" cellpadding="0" cellspacing="0" border="0" class="display" id="example">
		<thead>
			<tr>
				<th>Th&#244;ng tin &#272;&#7841;i di&#7879;n <font color="Red">*</font></th>
				<th>Chi ti&#7871;t danh s&#225;ch th&#224;nh vi&#234;n tham gia <font color="Red">*</font></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td align="center"><input type="text" name="daiDien1" id="daiDien1" maxlength="50" style="width: 80%" value="&#272;o&#224;n (t&#7893;) x&#225;c minh"></td>
				<td align="center"><a href="#" onclick="openDanhSachTvd();" id="tvd1" style="width: 80%">Danh s&#225;ch c&#225;n b&#7897; (ng&#432;&#7901;i) li&#234;n quan</a></td>
			</tr>
			<tr>
				<td align="center"><input type="text" name="daiDien2" id="daiDien2" maxlength="50" style="width: 80%" value="Ng&#432;&#7901;i b&#7883; khi&#7871;u n&#7841;i"></td>
				<td align="center"><a href="#" onclick="openDanhSachTvd();" id="tvd2" style="width: 80%">Danh s&#225;ch c&#225;n b&#7897; (ng&#432;&#7901;i) li&#234;n quan</a></td>
			</tr>
		</tbody>
	</table>
	<div style="text-align: right; width: 100%"><INPUT type="button" class="button" name="btnAdd" onclick="fnClickAddRow();" value="Th&#234;m"> <INPUT type="button" class="button" name="btnXoa" id="deleteRow" value="X&#243;a"></div>
	</fieldset>
	</fieldset>
	<jsp:include page="../../../button_bar_kntc.jsp" />
</html:form>
<script type="text/javascript" charset="utf-8"> 
var oTable;
var cRowID = 1; /*P: get current row id*/
var giCount = 2; /*P: Tong so row tren table*/
$(document).ready(function() {	
	$("#example tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');	   
	});					
	/* Add a click handler for the delete row */
	$('#deleteRow').click( function() {
		var anSelected = fnGetSelected( oTable );
		oTable.fnDeleteRow( anSelected[0] );
	});			
	oTable = $('#example').dataTable({"bJQueryUI":true,"bPaginate": false,"bInfo": false,"sDom":'T<"clear">lfrtip',"bSort": false,"fnDrawCallback": function ( oSettings ) {
			/* Need to redo the counters if filtered or sorted */
			if ( oSettings.bSorted || oSettings.bFiltered )
			{
				for ( var i=0, iLen=oSettings.aiDisplay.length ; i<iLen ; i++ )
				{
					$('td:eq(0)', oSettings.aoData[ oSettings.aiDisplay[i] ].nTr ).html( i+1 );
				}
			}
		},"bFilter":false,"oLanguage":language});

	//Check ghi thanh cong
    var ghiTC = "";
	 <logic:present name="ghiThanhcong">
	     	ghiTC = '<%=request.getAttribute("ghiThanhcong")%>';
	 </logic:present>
	 if(ghiTC=='1')
	   alert('L\u01B0u th\u00E0nh c\u00F4ng!'); 
	 else  if(ghiTC=='0')
	   alert('L\u1ED7i khi ghi d\u1EEF li\u1EC7u!!!');  
});
function openDanhSachTvd()
{
    var maHS = document.forms[0].maHoSo.value;
	if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("kntc_phan_cong_can_bo.do?method=tvd&parentId="+maHS,800,600);
	else
		alert("Ch\u01B0a c\u00F3 th\u00F4ng tin v\u1EC1 h\u1ED3 s\u01A1!");	
} 
function ghi(){
	document.forms[0].action="kntc_xac_minh.do?method=saveBbQdxm";
	document.forms[0].submit();
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
	   var row= '<tr><td align="center"><input type="text" name="daiDien" id="daiDien'+giCount+'" maxlength="50" style="width:80%"></td><td align="center"><a href="#" onclick="openDanhSachTvd();" id="tvd'+giCount+'" >Danh s&#225;ch c&#225;n b&#7897; (ng&#432;&#7901;i) li&#234;n quan</a></td></tr>';
	oTable.fnAddTr( $(row)[0] );	
}
</script>
<%@ include file="/bottom.jsp"%>
