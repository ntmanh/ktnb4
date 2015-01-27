<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="kntc_tiep_dan_van_thu.do?method=show">
		<h3 class="Header">Nhận hồ sơ qua văn thư</h3>
		<html:hidden property="first" value="1" />
		<html:hidden property="maHidden" />
		<html:hidden property="loaiHoSo" />
		<html:hidden property="arrTenTl" styleId="arrTenTl" />
		<div id="tabs">
		<ul>
			<li><a href="#tab0"><span>Thông tin chung</span></a></li>
			<li><a href="#tab1"><span>Nội dung dơn</span></a></li>
			<li id="liXuLy" style="visibility: hidden;"><a href="#tab2"><span>Thông tin xử lý</span></a></li>
		</ul>
		<div id="tab0">
		<fieldset><legend>Hồ sơ</legend>
		<table width="100%">
			<tr>
				<td width="15%" style="text-align: right;">Mã số hồ sơ</td>
				<td width="35%"><html:text property="maHoSo" style="width:100%" readonly="true" /></td>
				<td width="15%"></td>
				<td width="35%"></td>
			</tr>
		</Table>
		</fieldset>
		<fieldset style="padding: 5px;"><!--Fieldset Truong hop den khieu nai-to cao--> <legend>Trường hợp khiếu nại tố cáo</legend>
		<TABLE width="100%">
			<tr>
				<td width="15%" style="text-align: right">Trường hợp</td>
				<td width="35%"><html:select property="loaiKNTC" style="width:90%;" styleId="loaiKNTC" onchange="changeKNTC();">
					<html:option value="1">Khiếu nại</html:option>
					<html:option value="2">Tố cáo</html:option>
					<html:option value="4">Kiến nghị, phản ánh</html:option>
					<html:option value="3">Trường hợp khác</html:option>
				</html:select></td>
				<td width="15%" style="text-align: right"></td>
				<td width="35%"></td>
			</tr>
		</TABLE>
		</fieldset>
		<fieldset style="padding: 5px;"><legend>Thông tin công văn đến</legend>
		<table width="100%">
			<tr>
				<td width="15%" style="text-align: right">Số công văn đến<font color="red">*</font></td>
				<td width="35%"><html:text property="soCongVanDen" style="width: 90%" /></td>
				<td width="15%" style="text-align: right">Ngày bộ phận văn thư nhận được công văn<font color="red">*</font></td>
				<td width="35%"><html:text onkeypress="return formatDate(event, this)" maxlength="10" onblur="isDate(this)" property="ngayNhanCongVanVT" style="width: 90%" /></td>
			</tr>
			<tr>
				<td style="text-align: right">Đơn vị nhận công văn<font color="red">*</font></td>
				<td><html:text property="donViNhanCongVan" style="width: 90%" /></td>
				<td width="15%" style="text-align: right">Ngày bộ phận xử lý nhận được công văn<font color="red">*</font></td>
				<td width="35%"><html:text onkeypress="return formatDate(event, this)" maxlength="10" onblur="isDate(this)" property="ngayNhanCongVan" style="width: 90%" /></td>
			</tr>
		</table>
		</fieldset>
		<logic:present name="SoTiepDanVanThuForm" property="loaiHoSo">
			<logic:equal value="3" name="SoTiepDanVanThuForm" property="loaiHoSo">
				<fieldset><legend>Thông tin cán bộ tiếp nhận</legend>
				<table width="100%">
					<tr>
						<td style="text-align: right;">Họ tên</td>
						<td><html:hidden property="canBoMa" /> <html:text property="canBoTen" style="width:100%" /></td>
						<td style="text-align: right;">Bộ phận công tác</td>
						<td><html:text property="canBoNoiCongTac" style="width: 100%" /></td>
					</tr>
					<tr>
						<td width="15%" style="text-align: right;">Chức vụ</td>
						<td width="35%"><html:text property="canBoChucVu" style="width: 100%" /></td>
						<td width="15%" style="text-align: right">Kênh tiếp nhận thông tin</td>
						<td width="35%"><html:select property="kenhNhanTin" style="width:100%;">
							<html:option value="Phone">Điện thoại</html:option>
							<html:option value="Email">Email</html:option>
						</html:select></td>
					</tr>
				</table>
				</fieldset>
			</logic:equal>
		</logic:present> <!--fieldset thong tin nguoi khieu nai-->
		<fieldset style="padding: 5px;"><legend>
		<div id="lblThongTinCongDan1">Thông tin người khiếu nại</div>
		</legend>
		<table width="100%">
			<tr>
				<td width="15%" style="text-align: right">
				<div id="lblThongTinCongDan2" style="width: 100%; text-align: right;">Người khiếu nại</div>
				</td>
				<td width="35%"><html:text property="congdanTen" style="width: 90%" /></td>
				<td width="15%" style="text-align: right">Địa chỉ</td>
				<td width="35%"><html:text property="congdanDiaChi" style="width: 90%" /></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"><A href="#" onclick="openDsHoSo();"><font color="red"> Kiểm tra hồ sơ liên quan </font></A></td>
				<td></td>
			</tr>
			<tr>
				<td style="text-align: right">Nơi công tác</td>
				<td><html:text property="congdanNoiCongTac" style="width: 90%" /></td>
				<td style="text-align: right">Số điện thoại</td>
				<td><html:text property="congdanDienThoai" style="width: 90%" maxlength="20"/></td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right">Chức vụ</td>
				<td width="35%"><html:text property="congdanChucVu" style="width: 90%" /></td>
				<td style="text-align: right">CMND/Hộ chiếu</td>
				<td><html:text property="congdanCMT" style="width: 90%" /></td>
			</tr>
			<tr>
				<td style="text-align: right">Mã số thuế</td>
				<td><html:text property="congdanMST" style="width: 90%" /></td>
				<td style="text-align: right">Nơi cấp CMND/Hộ chiếu</td>
				<td><html:text property="congdanCMTNoiCap" style="width: 90%" /></td>
			</tr>
			<tr>
				<td style="text-align: right"></td>
				<td></td>
				<td style="text-align: right">Ngày cấp CMND/Hộ chiếu</td>
				<td><html:text property="congdanCMTNgayCap" onkeypress="return formatDate(event, this)" onblur="isDate(this)" style="width: 90%" /></td>
			</tr>
		</table>
		</fieldset>
		</div>
		<!--End div#tab0-->
		<div id="tab1"><jsp:include page="so_tiep_dan_van_thu_don.jsp" /></div>
		<div id="tab2"><jsp:include page="ho_so_xu_ly_vt.jsp" /></div>
		</div>
		<!--End div#tabs-->
		<table width="100%">
			<tr align="center">
				<td align="center"><input type="button" id="btnSave" class="button" value='Lưu' name="save" onclick="ghi();"> <input type="button" class="button" value='Đóng' name="exit" onclick="goHomeKntc();"></td>
			</tr>
		</table>
</html:form>
<script language="Javascript" charset="utf-8">
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
var super_tab;
$(document).ready(function() {
    tab=$("#tabs");
	tab.tabs();
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
	if(document.forms[0].loaiKNTC.value == 1){
		lblThongTinCongDan1.innerHTML = "Thông tin người khiếu nại";
		lblThongTinCongDan2.innerHTML = "Người khiếu nại<font color='red'>*</font>";
	}else if(document.forms[0].loaiKNTC.value == 2){
		lblThongTinCongDan1.innerHTML = "Thông tin người tố cáo";
		lblThongTinCongDan2.innerHTML = "Người tố cáo<font color='red'>*</font>"; 
	}else if(document.forms[0].loaiKNTC.value == 3){
		lblThongTinCongDan1.innerHTML = "Thông tin người gửi đơn";
		lblThongTinCongDan2.innerHTML = "Người gửi đơn<font color='red'>*</font>"; 
	}else if(document.forms[0].loaiKNTC.value == 4){
		lblThongTinCongDan1.innerHTML = "Thông tin công dân";
		lblThongTinCongDan2.innerHTML = "Họ tên công dân<font color='red'>*</font>"; 
	}
	if(document.forms[0].loaiKNTC.value == 4){
		$("#tabs").tabs("option", "disabled", [1])
	}
	var method = '<%=request.getParameter("method")%>';
	if(method=='view'){
		document.getElementById("liXuLy").style.visibility='visible'; 
		document.getElementById("btnSave").style.visibility='hidden';
		$("#super_tab").tabs("option", "disabled", [0,1,2]);
	}
	if(method=='edit'){
		document.forms[0].loaiKNTC.disabled = true;
		document.forms[0].ngayNhanCongVanVT.disabled = true;
		document.forms[0].ngayNhanCongVan.disabled = true;	
		$("#super_tab").tabs("option", "disabled", [0,1,2]);		
	}
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

function changeLuatSu(){
	if(document.forms[0].coLuatSu.checked)
		show("idDivLS");	
	else
		hide("idDivLS");
}

function changeKNTC(){	
	document.forms[0].first.value = "2";
 	document.forms[0].submit();
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
		document.forms[0].ngayNhanCongVanVT.disabled = false;
		document.forms[0].ngayNhanCongVan.disabled = false;
		document.forms[0].action="kntc_tiep_dan_van_thu.do?method=save";
		document.forms[0].submit();
	}
}

function validTTChungTab(){
	if(!isRequired(document.forms[0].soCongVanDen, 'Chưa nhập số công văn đến')) {
		tab.tabs("select",0);
		document.forms[0].soCongVanDen.select();
		return false;
		}
	if(!isRequired(document.forms[0].ngayNhanCongVanVT, 'Chưa nhập ngày bộ phận văn thư nhận được công văn')) {
		tab.tabs("select",0);
		document.forms[0].ngayNhanCongVanVT.select();
		return false;
		}
	if(!isRequired(document.forms[0].ngayNhanCongVan, 'Chưa nhập ngày bộ phận xử lý nhận được công văn')) {
		tab.tabs("select",0);
		document.forms[0].ngayNhanCongVan.select();
		return false;
		}
	if(!isRequired(document.forms[0].donViNhanCongVan, 'Chưa nhập đơn vị nhận công văn')) {
		tab.tabs("select",0);
		document.forms[0].donViNhanCongVan.select();
		return false;
		}	
	if(!isRequired(document.forms[0].congdanTen, 'Chưa nhập tên công dân')) {
		tab.tabs("select",0);
		document.forms[0].congdanTen.select();
		return false;
		}
	if(document.forms[0].loaiKNTC.value != 4){
		if (!isRequired(document.forms[0].canBoBiKNTCTen,'Chưa nhập tên cán bộ bị KN/TC')) {
			tab.tabs("select",1);
			document.forms[0].canBoBiKNTCTen.select();
			return false;
			}
		if(!isRequired(document.forms[0].noiDungDon, 'Chưa có thông tin nội dung đơn')){
			tab.tabs("select" , 1);
			document.forms[0].noiDungDon.select();
			return false;
			}
	}
	return true;	
}
function openDsHoSo(){
	var tenNnd = document.forms[0].congdanTen.value;
	if(tenNnd!=null && tenNnd!=''&& tenNnd!='undefied')
		openWindow("kntc_tim_kiem.do?method=lov&nnd="+normalizeString4SQL(tenNnd));
	else
		alert('Chưa nhập họ tên công dân');	
}
</script>
<%@ include file="/bottom.jsp"%>