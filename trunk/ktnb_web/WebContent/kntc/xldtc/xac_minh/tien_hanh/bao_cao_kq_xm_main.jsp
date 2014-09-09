<%@ include file="/top_bar.jsp"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="/kntc_kq_xm_tc.do?method=bcKqXmTc" method="post" styleId="form">
	<html:hidden property="maHoSo" />
	<html:hidden property="maHidden" />
	<h3 class="Header">B&#193;O C&#193;O K&#7870;T QU&#7842; X&#193;C MINH N&#7896;I DUNG T&#7888; C&#193;O - M&#7850;U 23/KNTC</h3>
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red">S&#7889; quy&#7871;t &#273;&#7883;nh</font> <html:text property="soQd" styleClass="text" style="width:250px" readonly="true" /></div>
	<div id="tabs">
	<ul>
		<li><a href="#tab0"><span>Th&#244;ng tin b&#225;o c&#225;o</span></a></li>
		<li><a href="#tab1"><span>K&#7871;t qu&#7843; x&#225;c minh</span></a></li>
		<li><a href="#tab2"><span>K&#7871;t lu&#7853;n & Ki&#7871;n ngh&#7883;</span></a></li>
	</ul>
	<div id="tab0"><jsp:include page="bao_cao_kq_xm_tt_chung.jsp" /></div>
	<div id="tab1"><jsp:include page="bao_cao_kq_xm_kqxm.jsp" /></div>
	<div id="tab2"><jsp:include page="bao_cao_kq_xm_klkn.jsp" /></div>
	</div>
	<br>
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" class="button" value='L&#432;u' name="save" onclick="ghi();"> <input type="button" class="button" value='&#272;&#243;ng' name="exit" onclick="goHomeKntc();"></td>
		</tr>
	</table>
</html:form>
<script language="JavaScript">
var tab;
var giCount = 1;
var oTable;
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
$(document).ready(function() {
    tab=$("#tabs");
	tab.tabs();
	//Table
	$("#example tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');	   
	});					
	/* Add a click handler for the delete row */
	$('#delete').click( function() {
		var anSelected = fnGetSelected( oTable );
		oTable.fnDeleteRow( anSelected[0] );
	});			
	oTable = $('#example').dataTable({"bJQueryUI":true,"bPaginate": false,"bInfo": false,"sDom":'T<"clear">lfrtip',"bSort": false,"bFilter":false,"oLanguage":language});
	var ghiTC = "";
	 <logic:present name="ghiThanhcong">
	     	ghiTC = '<%=request.getAttribute("ghiThanhcong")%>';
	 </logic:present>
	 if(ghiTC=='1')
	   alert('L\u01B0u th\u00E0nh c\u00F4ng!'); 
	 else  if(ghiTC=='0')
	   alert('L\u1ED7i khi ghi d\u1EEF li\u1EC7u!!!');  
});
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

function openUploadFile(){
	var view='';
	var method = '<%=request.getParameter("method")%>';
	if(method == 'view') view = 'view';
	var r = '<%=request.getParameter("r")%>';
	if(r == 'rol') view = 'view';
	
    var maHS = document.forms[0].maHoSo.value;
    if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+maHS+"&nv=KNTC/BCKQXMTC&view="+view);
	else
		alert("Ch\u01B0a c\u00F3 th\u00F4ng tin v\u1EC1 h\u1ED3 s\u01A1!");	
}

function showDiv(aValue){	
    var divs = document.getElementById("divNd").getElementsByTagName("div");     
    for(i=0;i<divs.length;i++){
    	hide(divs[i].id); 
    }
    show(aValue);
    
}
function print(){		
		document.forms[0].action="kntc_kq_xm_tc.do?method=inBcKqXmTc";
		document.forms[0].submit();
	}
function ghi(){
	if(validForm()) {
		document.forms[0].action="kntc_kq_xm_tc.do?method=saveBcKqXmTc";
		document.forms[0].submit();
	}
}

function validForm() {
	if(!isRequired(document.forms[0].diaDiem,'Ch\u01B0a nh\u1EADp \u0111\u1ECBa \u0111i\u1EC3m')) return false;
	if(!isRequired(document.forms[0].thoiDiem,'Ch\u01B0a nh\u1EADp ng\u00E0y l\u1EADp')) return false;
	return true;
}
</script>
<%@ include file="/bottom.jsp"%>
