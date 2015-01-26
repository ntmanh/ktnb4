<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="/kntc_tiep_dan.do?method=show" method="post"
	styleId="form">
	<div id="super-tabs">
	<ul>
		<li><a href="#super-tab0"
			onclick="redirectNoId('kntc_tiep_dan.do?method=show');"><span>SỔ
		TIẾP DÂN</span></a></li>
		<li><a href="#super-tab1"
			onclick="redirectNoId('kntc_tim_kiem_chuyen_ho_so.do?method=show&action=chuyenHS');"><span>CHUYỂN
		HS SANG BỘ PHẬN HÀNH CHÍNH</span></a></li>
	</ul>
	<div id="super-tab0"><html:hidden property="maHidden" /> <html:hidden
		property="first" value="1" /> <html:hidden property="arrTenTl"
		styleId="arrTenTl" />
	<h3 class="Header">Sổ tiếp dân</h3>
	<div id="tabs" style="float: left; width: 776px;">
	<ul>
		<li><a href="#tab0"><span>Thông tin chung</span></a></li>
		<li><a href="#tab1"><span>Nội dung đơn</span></a></li>
		<li><a href="#tab2"><span>Thông tin ủy quyền</span></a></li>
		<li id="liXuLy" style="visibility: hidden;"><a href="#tab3"><span>Thông
		tin xử lý</span></a></li>
	</ul>
	<div id="tab0"><jsp:include page="so_tiep_dan.jsp" /></div>
	<div id="tab1"><jsp:include page="so_tiep_dan_don.jsp" /></div>
	<div id="tab2"><jsp:include page="so_tiep_dan_nuq.jsp" /></div>
	<div id="tab3"><jsp:include page="ho_so_xu_ly_td.jsp" /></div>
	</div>
	<br>
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" id="btnSave"
				class="button" value='Lưu' name="save" onclick="ghi();"> <input
				type="button" class="button" value='Đóng' name="exit"
				onclick="goHomeKntc();"></td>
		</tr>
	</table>
	</div>
	<div id="super-tab1"></div>
	<jsp:include page="/kntc2/other_action/tiep_dan.jsp"></jsp:include></div>

</html:form>
<script language="JavaScript">
var giCount = 1;
var oTable;
var luotTiepRecent;
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
var super_tab;
var tab;
$(document).ready(function() {
    tab=$("#tabs"); 
	tab.tabs();
	super_tab=$("#super-tabs");
	super_tab.tabs();
	
	// Check status DdBs
	checkStatusDd();
	//Table
	$('#arrTenTl').val('');
	$('#soTrangTL').val('');
	$('#tinhTrang').val('');
	$("#example tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');	   
	});
						
	/* Add a click handler for the delete row */
	$('#deleteRow').click( function() {
		giCount = oTable.fnGetData().length;
		var anSelected = fnGetSelected( oTable );
		if(anSelected.length>0) {
			oTable.fnDeleteRow( anSelected[0] );
			giCount--;
		}
		else showMessage(chua_chon_ban_ghi);		
	});		
	var url='phieu_dxxl_kn.do?method=getListTL&id='+document.forms[0].maHoSo.value;	
	oTable = $('#example').dataTable(
		{"bJQueryUI":true,"bPaginate": false,
		"bInfo": false,"sDom":'T<"clear">lfrtip',"bSort": false,"sAjaxSource":url,
		"bFilter":false,"oLanguage":language});
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
	 checkDivOnLoad(); 
});

function checkStatusDd()
{  
	if(document.forms[0].maHidden.value!="")
	{
		if(document.getElementsByName("doanKNTC")[0].checked || document.getElementsByName("doanKNTC")[2].checked)
		{
			hide("idDivSl");	
			$(".daiDienBs").hide();
			hide("idDivDd"); 
		}
		else
		{
			show("idDivSl"); 
			$(".daiDienBs").show();
			document.forms[0].coThemDaiDien.checked=true;
			show("idDivDd"); 
		}
	}
}
function checkSln()
{
	// alert(parseInt(document.forms[0].doanKNTCSoLuong.value));
	var slNguoi=parseInt(document.forms[0].doanKNTCSoLuong.value);
	if(slNguoi>=5)
	{
		$(".daiDienBs").show();
		if(document.forms[0].coThemDaiDien.checked)
			show("idDivDd");
	}
	else
	{
		$(".daiDienBs").hide();
		hide("idDivDd");
	}
}
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
function fnClickAddRow() {
	giCount = oTable.fnGetData().length;

	var newRowId = giCount+1;
	for(i=0;i<=giCount;i++){
		if(!isExist('tenTL'+i)) {
			newRowId = i;
			break;
		}
	}
	
	var row = '<tr><td width="60%"><input type="text" style="width: 100%" name="tenTL" id="tenTL'+newRowId+'"></td>'
				+'<td width="20%"><input type="text" name="soTrangTL" id="soTrangTL'+newRowId+'" maxlength="3" onkeypress="return nokeypress(event);" onblur="isNumber(this,"i");" style="width: 100%"></td>'
				+'<td width="20%">'
				+'<select id="tinhTrang'+newRowId+'">'
						+'<option value="Bản chính">Bản chính</option>'
						+'<option value="Bản sao">Bản sao</option>'
						+'<option value="Bản sao có công chứng">Bản sao có công chứng</option>'
				  +'</select>'
				+'</td></tr>';
	oTable.fnAddTr( $(row)[0] );
	giCount++;
}

function changeDoanKntc(aValue){
	if(aValue=='1' || aValue=='3') 
	{
		$(".daiDienBs").hide();
		hide("idDivSl");
		hide("idDivDd");	
	}
	else
	{  
		show("idDivSl");
		checkSln();
		if(document.forms[0].doanKNTCSoLuong.value=='null') 
			document.forms[0].doanKNTCSoLuong.value='';
	}
}

function openDsHoSo(){
	var tenNnd = document.forms[0].congdanTen.value;
	if(tenNnd!=null && tenNnd!=''&& tenNnd!='undefied')
		openWindow("kntc_tim_kiem.do?method=lov&nnd="+normalizeString4SQL(tenNnd));
	else
		alert('Chưa nhập họ tên công dân');	
}
function changeLuatSu(){
	if(document.forms[0].coLuatSu.checked)
		show("idDivLS");	 
	else
		hide("idDivLS");  
}
function changeLoaiKNTC(loaiTq){
	document.forms[0].action="kntc_tiep_dan.do?method=show&tq="+loaiTq;
	document.forms[0].first.value = "2";
 	document.forms[0].submit();
}
function changeKNTC(){
	var method = '<%=request.getParameter("method")%>';
	if(method=='edit') {				
		alert('Không được thay đổi tính chất hồ sơ');
		alert(loaiHs);
	}else{
		if(document.forms[0].loaiKNTC.value == 2 | document.forms[0].loaiKNTC.value == 3){			
			hide('idUyQuyen');
			hide('idKNType');
			$("#tabs").tabs("option", "disabled", [2])
		}else if(document.forms[0].loaiKNTC.value == 1){
			show('idUyQuyen');
			show('idKNType');
			$("#tabs").tabs("option", "disabled", [])
		}else if(document.forms[0].loaiKNTC.value == 4){
			hide('idUyQuyen');
			hide('idKNType');
			$("#tabs").tabs("option", "disabled", [1,2])
		}
		document.forms[0].first.value = "2";
	 	document.forms[0].submit();
	 }
}
function changeUyQuyen(){
	document.forms[0].first.value = "2";
	document.forms[0].submit();
}

function changeKNTCTrucTiep(){
	if(document.forms[0].isKNTCTrucTiep.checked) {
		show("idUyQuyen");
		show("uyQuyen");
		$("#tabs").tabs("option", "disabled", []);	
	}else{
		hide("idUyQuyen");
		hide("uyQuyen");
		$("#tabs").tabs("option", "disabled", [2]);	
	}
}

function checkDivOnLoad(){
	if(document.forms[0].loaiKNTC.value == 2 | document.forms[0].loaiKNTC.value == 3){
		hide("idUyQuyen");
		hide('idKNType');
		$("#tabs").tabs("option", "disabled", [2]);
	}else if(document.forms[0].loaiKNTC.value == 1){
		show("idUyQuyen");
		show('idKNType');
		$("#tabs").tabs("option", "disabled", []);
		changeKNTCTrucTiep();
	}else if(document.forms[0].loaiKNTC.value == 4){
		hide('idUyQuyen');
		hide('idKNType');
		$("#tabs").tabs("option", "disabled", [1,2]);
	}
	changeLuatSu();
	changePhieuHen();
	luotTiepRecent = document.forms[0].luotTiep.value;		
	
	var method = '<%=request.getParameter("method")%>';
	var act = '<%=request.getParameter("action")%>';
	if(method=='view'){
		document.getElementById("liXuLy").style.visibility='visible'; 
		document.getElementById("btnSave").style.visibility='hidden'; 
		document.getElementById("loaiKNTC").disabled = true;
		document.getElementById("btnAdd").disabled = true;
		document.getElementById("deleteRow").disabled = true;
		$("#super-tabs").tabs("option", "disabled", [0,1,2]);
	}
	if(method=='edit' || method=='save'){
		document.forms[0].loaiKNTC.disabled = true;
		document.forms[0].ngayTiep.disabled = true;		
	}
	if(act=='tktiepdan' || act=='suaHSTD' || act=='chuyenHS' || act=='bosungHS'){
		document.getElementById("liXuLy").style.visibility='hidden'; 
	}	
}
function changePhieuHen(){
	if(document.forms[0].boSungTaiLieu.checked)
		show("divLapPhieu");	
	else
		hide("divLapPhieu");
}

function changeBoSungDd()
{
	if(document.forms[0].coThemDaiDien.checked)
		show("idDivDd");
	else  
		hide("idDivDd"); 
}
function ghi(){		
	if(validTTChungTab()){         
			if(document.getElementById('loaiKNTC').value != 4){
				var arTL='';
				for(i=0;i<oTable.fnGetData().length+1;i++){
					if(isExist('tenTL'+i)){
						if(!isEmpty(document.getElementById('tenTL'+i).value)){
							arTL +=$('#tenTL'+i).val()+'###'+$('#soTrangTL'+i).val()+'###'+$('#tinhTrang'+i).val()+'@@';				
						}
					}
				}	
				document.forms[0].arrTenTl.value=arTL;
			}
		document.forms[0].loaiKNTC.disabled = false;
		document.forms[0].ngayTiep.disabled = false;	
		if(document.forms[0].doanKNTC[0].checked | document.forms[0].doanKNTC[2].checked)
		{
			document.forms[0].daiDienBsNoiDung.value='';
			alert(document.forms[0].daiDienBsNoiDung.value);
		}
		document.forms[0].action="kntc_tiep_dan.do?method=save";
		document.forms[0].submit();
	}
}
function checkLuotTiep(ctrName){
	var ctr=eval(ctrName);
	if(ctr.value-luotTiepRecent==1) {
		return true;
	}else{
		ctr.value = luotTiepRecent;
		alert('Lượt tiếp chỉ được tăng thêm 1 mỗi lần thay đổi!');
		ctr.focus(); 
		return false;
	}
}
function validTTChungTab(){	
	if(!isRequired(document.forms[0].ngayTiep, 'Chưa nhập ngày tiếp')) {
		tab.tabs("select" , 0);
		document.forms[0].ngayTiep.select();
		return false;
		}
	if(!isRequired(document.forms[0].congdanTen, 'Chưa nhập họ tên công dân')) {
		tab.tabs("select" , 0);
		document.forms[0].congdanTen.select();
		return false;
		}
	if(!isRequired(document.forms[0].congdanDiaChi, 'Chưa nhập địa chỉ công dân')){
		tab.tabs("select" , 0);
		document.forms[0].congdanDiaChi.select();
		return false;
		}
	if (document.forms[0].coLuatSu.checked) {
		if(!isRequired(document.forms[0].luatsuTen, 'Chưa nhập tên luật sư')) {
			tab.tabs("select" , 0);
			document.forms[0].luatsuTen.select();
			return false;
			}
		if(!isRequired(document.forms[0].luatsuCMT, 'Chưa nhập CMND/Hộ chiếu luật sư')){		
			tab.tabs("select" , 0);
			document.forms[0].luatsuCMT.select();
			return false;
			}
		}
	if(document.forms[0].loaiKNTC.value != 4){	
	if (document.forms[0].isKNTCTrucTiep.checked) {	
		if(document.forms[0].nuqTen.value=="")
		{			
			alert('Chưa nhập họ tên người ủy quyền');
			tab.tabs("select" , 2);
			document.forms[0].nuqTen.select();
			return false;
		}
		if(!compareDate(document.forms[0].guqTuNgay,document.forms[0].guqDenNgay))
			return false;
		if(!isRequired(document.forms[0].nuqCMT, 'Chưa nhập CMND/Hộ chiếu người ủy quyền')) {
			tab.tabs("select" , 1);
			document.forms[0].nuqCMT.select();
			return false;
		}		
	}
	if(!isRequired(document.forms[0].canBoBiKNTCTen, 'Chưa nhập họ tên người bị KN/TC')){
		tab.tabs("select" , 1);
		document.forms[0].canBoBiKNTCTen.select();
		return false;
	}
	if(!isRequired(document.forms[0].noiDungDon, 'Chưa có thông tin nội dung đơn')){
		tab.tabs("select" , 1);
		document.forms[0].noiDungDon.select();
		return false;
	}}
	return true;	
}
</script>
<%@ include file="/bottom.jsp"%>
