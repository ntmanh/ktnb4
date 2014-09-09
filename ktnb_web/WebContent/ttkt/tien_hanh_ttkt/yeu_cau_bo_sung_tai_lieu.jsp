<%@page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%>
<%@page import="cmc.com.ktnb.util.Constants"%>
<%@page import="cmc.com.ktnb.util.ApplicationContext"%>      
<h3 class="Header">Yêu cầu cung cấp báo cáo hồ sơ tài liệu</h3>
<script language="javascript">                   
	var tenCqt = '<%=((ApplicationContext) request.getSession()
						.getAttribute(Constants.APP_CONTEXT)).getTenCqt().replaceAll("'","\'")%>'                 
	var maCqt = '<%=((ApplicationContext) request.getSession()
						.getAttribute(Constants.APP_CONTEXT)).getMaCqt()%>'                 
	function selfClose(){		
		window.close();              
	}                                                                                                                                                                     
	function getChucVuCoDau(chucVuKhongDau){ 
		if(chucVuKhongDau == "Truong doan") 
			return "Trưởng đoàn";
		else if(chucVuKhongDau == "Pho doan")
			return "Phó đoàn";
		else
			return "Thành viên đoàn";
	}
</script>
<div id="tab">
<ul>
	<li><a href="#tabPhieuYeuCau"><b>Phiếu yêu cầu</b></a></li>
	<li><a href="#tabBienBanGiaoNhan"><b>Biên bản giao nhận</b></a></li>
	<li><a href="#tabBienBanGiaoTra"><b>Biên bản giao trả</b></a></li>
</ul>
<DIV id="tabPhieuYeuCau">
<fieldset><html:form
	action="yeu_cau_cung_cap_tai_lieu.do?method=save&type=phieuyeucau"
	method="post">
	<%@ include file="/ttkt/tien_hanh_ttkt/YcCcHsTl_phieu_yeu_cau.jsp"%>    
</html:form></fieldset>
</DIV>     
<DIV id="tabBienBanGiaoNhan">    
<fieldset><html:form
	action="yeu_cau_cung_cap_tai_lieu.do?method=save&type=bbgiaonhan"
	method="post">
	<%@ include file="/ttkt/tien_hanh_ttkt/YcCcHsTl_bien_ban_giao_nhan.jsp"%>
</html:form></fieldset>
</DIV>
<DIV id="tabBienBanGiaoTra">
<fieldset><html:form
	action="yeu_cau_cung_cap_tai_lieu.do?method=save&type=bbgiaotra"
	method="post">
	<%@ include file="/ttkt/tien_hanh_ttkt/YcCcHsTl_bien_ban_giao_tra.jsp"%>
</html:form></fieldset>
</DIV>
</div>
<br>
<fieldset style="width: 100%; margin: 0">
<TABLE align="center">
	<tr>
		<td width="100%" align="center"><%@ include
			file="/ttkt/dung_chung/action_bar.jsp"%></td>
	</tr>
</TABLE>
</fieldset>
<html:form action="yeu_cau_cung_cap_tai_lieu.do" method="post">
	<html:hidden property="idDonViTienHanh" />
	<html:hidden property="idCuocTtKtl" />
	<html:hidden property="idDsTvdPhieuYc" />
</html:form>
<%@ include file="/bottom.jsp"%>
<script language="javascript">  
function validateDateRequired(dateElement){
	var thoiDiemRaQD = '<%=request.getAttribute("thoiDiemRaQD")%>';
	if(thoiDiemRaQD!=null&&thoiDiemRaQD!=""&&dateElement.value!=""&&dateElement.value!=null){
		switch(dateElement.name){
			case "ngayLapYeuCau":
				if(d2n(thoiDiemRaQD)>d2n(dateElement.value)){
					alert("Ngày lập phiếu phải sau ngày công bố ("+thoiDiemRaQD+")!");
					$(dateElement).focus().select();
				}
				break;
			default:
				if(d2n(thoiDiemRaQD)>d2n(dateElement.value.split(" ")[1])){
					alert("Ngày lập phiếu phải sau ngày công bố ("+thoiDiemRaQD+")!");
					$(dateElement).focus().select();
				}
				break;
		}
	}
}
//window.onbeforeunload = function(){
//	$('[name="ngayLapYeuCau"]')[0].value="";
///	$('[name="thoiDiemNhanPhieuYc"]')[0].value="";
//	$('[name="thoiDiemCungCap"]')[0].value="";
//	$('[name="thoiDiemBatDauBanGianHoSoLuuTru"]')[0].value="";
//	$('[name="thoiDiemKTBBGN"]')[0].value="";
//	$('[name="thoiDiemBatDauBanGiaoHoSo"]')[0].value="";
//	$('[name="thoiDiemKTBBGT"]')[0].value="";
//}
var contextRoot = document.forms[0].action.split('/')[1];
var url; 
function findForm(formAction){ 
	for(i = 0; i< document.forms.length; i++){
		if(document.forms[i].action == formAction)
			return document.forms[i];
	}
	return null;
} 
function getThongTinChung(){
	thongTinChung = "";  
	thongTinChungForm = findForm('/' + contextRoot + '/yeu_cau_cung_cap_tai_lieu.do');  
	for(i = 0; i< thongTinChungForm.elements.length; i++)
		if(thongTinChungForm.elements[i].name != null && thongTinChungForm.elements[i].name != '' && thongTinChungForm.elements[i].value != null && thongTinChungForm.elements[i].value != '')
			thongTinChung += thongTinChungForm.elements[i].name + "=" + encodeURIComponent(thongTinChungForm.elements[i].value) + "&"; 
	thongTinChung += 'idYeuCau=' + encodeURIComponent(document.getElementsByName('idYeuCau')[0].value);
	//thongTinChung = thongTinChung.substring(0, thongTinChung.length - 1); 
	return thongTinChung;      
}                                             
function createSubmitString(){      
	reVal = "";     
	activeForm = findForm(url); 
	for(i = 0; i< activeForm.elements.length; i++){
		if(activeForm.elements[i].name != null && activeForm.elements[i].name != '' && activeForm.elements[i].value != null && activeForm.elements[i].value != '')
			reVal += activeForm.elements[i].name + "=" + encodeURIComponent(activeForm.elements[i].value) + "&";
	}
	// collect thong tin chung.
	if(getThongTinChung() != null && getThongTinChung() != '')
		reVal += getThongTinChung();
	else
		reVal = reVal.substring(0, reVal.length - 1);   	
	return reVal;    
}   
function saveActiveTab(){	
	if(activeTab == 0){ 
		if(!validatePhieuYeuCau())            
			return; 
		url = 'yeu_cau_cung_cap_tai_lieu.do?method=save&type=phieuyeucau'; 
	}else if(activeTab == 1){		
		if(!validateBanGiaoNhan())               
			return;     
		url = 'yeu_cau_cung_cap_tai_lieu.do?method=save&type=bbgiaonhan';	  
	}else if(activeTab == 2){ 
		
		if(!validateBanGiaoTra()) 
			return;   
		url = 'yeu_cau_cung_cap_tai_lieu.do?method=save&type=bbgiaotra';  
	}else throw "Err1";  
	
	url = '/' + contextRoot + '/' + url; 
	xmlhttpPost(url); 
}
function xuLySaveThanhCongCuaTungForm(saveStatus){
	if(activeTab == 0)
		document.getElementsByName("idYeuCau")[0].value = saveStatus;
	else if(activeTab == 2){
		window.close();
		window.opener.location.reload();
	}
	
}
window.onload = function(){ 
	numOfTab = 3;
//thêm dòng trống trước các danh sách
if($('#tblDaiDienBenNhanHsTL tbody tr').length==1){
	themDaiDienBenNhanHstl();
}
if($('#tblDaiDienBenGiaoHsTL tbody tr').length==1){
	themDaiDienBenGiaoHstl();
}
if($('#tblDaiDienBenGiao tbody tr').length==1){
	themGiaoHstl();
}
if($('#tblDaiDienBenNhan tbody tr').length==1){
	themNhanHstl();
}
}     
                        
var maCqtTh = '<%=((ApplicationContext) request.getSession()
						.getAttribute(Constants.APP_CONTEXT)).getMaCqt()%>'                 
var maCqtDuocTtkt = '<%=request.getAttribute("maCqtDuocTtkt")%>';

var hiddenIdCanBo;
var txtTenCanBo;
var txtChucVu;
function setThongTinNhanVienFromLov(ma, ten, chucVu, tenPhong, tenCqt){
	var isExistCb = false;
	if(type == 'daidienBBGT'){
		for(var i = 0; i< bangNhan.numOfRow - 1; i++){
			element = document.getElementsByName('arrDaiDienBenNhanHstl[' + i + '].idCanBo')[0];
			if(element != null && element != hiddenIdCanBo && element.value == ma)
				isExistCb = true;
				
		}
	}else if(type == 'daidienBBGN'){
		for(var i = 0; i< bangDaiDienBenNhan.numOfRow - 1; i++){
			element = document.getElementsByName('arrDaiDienBenNhanHstlLuuTru[' + i + '].idCanBo')[0];
			if(element != null && element != hiddenIdCanBo && element.value == ma){
				isExistCb = true;
			}				
		}		
	}
	if(isExistCb){
		window.focus();
		hiddenIdCanBo.value = '';
		txtTenCanBo.value = '';
		txtChucVu.value = '';
		return 'Cán bộ này đã tồn tại!';;
	}
	hiddenIdCanBo.value = ma;
	txtTenCanBo.value = ten;
	txtChucVu.value =  chucVu;
	return '';
}    
function getTabIndexInCookKie(){ 
	return "yeuCauBsHsTl";  
}
function setActiveTab(tabIndex){   
	activeTab = tabIndex;   
}
$(function()             
{     
  var tab_select=jQuery.fn.readCookie(getTabIndexInCookKie());
  //khi chua luu vao cookie
  if(tab_select==null)
    tab_select = 0; 
  setActiveTab(tab_select); 
  var tabOpts={selected:tab_select,select:function(event,tab){jQuery.fn.createCookie(getTabIndexInCookKie(), tab.index); setActiveTab(tab.index)}};                
  $("#tab").tabs(tabOpts);
});


	 
		    
var cbDsThanhVienDoan;        
var dsIdThanhVienDoan;                       
var dsChucVuTrongDoan; 
function getDsThanhVienDoan(){               
	cbDsThanhVienDoan = '<%=request.getAttribute("cbChiTietDsTvd")%>'   
	dsIdThanhVienDoan = '<%=request.getAttribute("dsIdThanhVienDoan")%>' 
	dsIdThanhVienDoan = dsIdThanhVienDoan.split(',');
	dsChucVuTrongDoan = '<%=request.getAttribute("dsChucVuTrongDoan")%>'   
	dsChucVuTrongDoan = dsChucVuTrongDoan.split(',');	                     
}                       
function getChucVuTvd(tvdId){ 
	 var chucVuVn = document.getElementsByName(tvdId.name.replace('.idCanBo', '.chucVu'))[0];
	chucVu = findChucVuById(tvdId.value);
	var tenHiddenTag = 	document.getElementsByName(tvdId.name.replace('.idCanBo','.hoTen'))[0];
	tenHiddenTag.value =  tvdId.options[tvdId.selectedIndex].text;
			if(tvdId[tvdId.selectedIndex].text == ""){        
			chucVuVn.value = '';
			return;
		} 
	switch (chucVu){           
		case "Truong doan":            
			chucVuVn.value = "Trưởng đoàn"
			break;     
		case "Pho doan":
			chucVuVn.value = "Phó đoàn"
			break;
		default:      
			chucVuVn.value = "Thành viên đoàn"
			break;            
	}                  
}                              
function findChucVuById(idCanBo){
	for(var i = 0; i< dsIdThanhVienDoan.length; i++)
		if(dsIdThanhVienDoan[i] == idCanBo)
			return dsChucVuTrongDoan[i];         
}	       
function createOptionsFromDsThanhVien(){                  
		cbDsThanhVienDoan = '<option value = ""></option>';            
		var allRowDsThanhVien = document.getElementById('bodyDsTvd').rows;       
		for(var i = 0; i< allRowDsThanhVien.length; i++){    
			var rowThanhVien = allRowDsThanhVien[i];                 
			var colTenThanhVien = rowThanhVien.cells[1];     
			if(colTenThanhVien.childNodes[0].value != null && colTenThanhVien.childNodes[0].value != ''){ 
				if(i==0) 
					cbDsThanhVienDoan += '<option value="' + colTenThanhVien.childNodes[0].value + '">' + colTenThanhVien.childNodes[2].value + '</option>';
				else
					cbDsThanhVienDoan += '<option value="' + colTenThanhVien.childNodes[0].value + '">' + colTenThanhVien.childNodes[2].value + '</option>';
			}	                
		}                                                           
	}                                    
var cbDsThanhVienDoan;
function selfClose(){
		window.close();
	}
</script>
<%
if (request.getAttribute("save") != null) {
%>
<script language="javascript">
		alert('Lưu thành công!');
		window.location = 'danh_sach_tim_kiem.do?idCuocTtkt=' + document.getElementsByName('idCuocTtKtl')[0].value +'&type=yeucaucungcapHSTL';
	</script>
<%
}
%>
