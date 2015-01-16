<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%>                             
<script type="text/javascript" src="<html:rewrite page='/include/js/ttkt/ttkt.js'/>"></script>
<%@page import="cmc.com.ktnb.util.Constants"%> 
<%@page import="cmc.com.ktnb.util.ApplicationContext"%>     
<script language="javascript">                       
	var tenCqt = "<%=((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getTenCqt()%>";
	var maCqt = '<%=((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getMaCqt()%>';                 
</script>   
<h3 class="Header">Kết thúc Thanh tra Kiểm tra - Mã cuộc <bean:write name="KetThucTtktForm" property="maCuocTtkt"/></h3>                              
<html:form action="ket_thuc_ttkt.do" method="POST">           
	<html:hidden property="idCuocTtkt" />              
	<html:hidden property="idDonViTienHanh" />          
</html:form>
<DIV style="padding-bottom: 5px"><B><a href="#" onclick="xemThongTinChung();">Thông tin chung</a> |</B> <B><a href="#" onclick="xemLichTrinhDuKien();">Lịch trình dự kiến</a></B></DIV>
<div id="level1Tab">              
<ul>
	<li><a href="#tabThongBaoKetThuc"><b>Thông báo kết thúc</b></a></li>        
	<li><a href="#xxxxxxxxxxxxx"><b>Kết quả, kết luận</b></a></li>    
	<li><a href="#tabHopRutKinhNghiem"><b>Họp rút kinh nghiệm đoàn</b></a></li>
	<li><a href="#tabBanGiaoLuuTruHoSoTtkt"><b>Bàn giao, lưu trữ hồ sơ</b></a></li>
	<li><a href="#tabChuyenDuLieuSangBaoCao"><b>Kết quả thực hiện kết luận</b></a></li>                           
</ul>                                                                             
<DIV id="tabThongBaoKetThuc">  
<fieldset style="width: 100%"><%@ include file="/ttkt/ket_thuc_ttkt/thong_bao_ket_thuc.jsp"%></fieldset>       
</DIV>          
<DIV id="xxxxxxxxxxxxx">                                  
<fieldset style="width: 100%"><%@ include file="/ttkt/ket_thuc_ttkt/tab_ket_qua_ket_luan_ttkt.jsp"%></fieldset>
</DIV>   
<DIV id="tabHopRutKinhNghiem">  
<fieldset style="width: 100%"><%@ include file="/ttkt/ket_thuc_ttkt/hop_rut_kinh_nghiem.jsp"%></fieldset>
</DIV> 
<DIV id="tabBanGiaoLuuTruHoSoTtkt">  
<fieldset style="width: 100%"><%@ include file="/ttkt/ket_thuc_ttkt/ban_giao_luu_tru_ho_so_ttkt.jsp"%></fieldset>
</DIV>     
<DIV id="tabChuyenDuLieuSangBaoCao">
<div style="width: 100%"><%@ include file="/ttkt/ket_thuc_ttkt/chuyen_du_lieu_sang_bao_cao.jsp"%></div>
</DIV>
</div>
<div style="width: 100%; margin: 0"><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></div>      
<script language="javascript">     
$(function()    
{          
  var noiRaThongBaoKetThuc = $('[name="noiRaThongBaoKetThuc"]')[0].value;
  var ngayKetThuc = $('[name="ngayKetThuc"]')[0].value;
  var ngayRaThongBaoKetThuc = $('[name="ngayRaThongBaoKetThuc"]')[0].value;
  if((noiRaThongBaoKetThuc==null||noiRaThongBaoKetThuc=="")||(ngayKetThuc==null||ngayKetThuc=="")||(ngayRaThongBaoKetThuc==null||ngayRaThongBaoKetThuc==""))
  {
  tab_level1_select = 0;  
  var tabOpts={selected:tab_level1_select,select:function(event,level1Tab){jQuery.fn.createCookie("ketthuc",level1Tab.index); setLevel1ActiveTab(level1Tab.index)}};                
  $("#level1Tab").tabs(tabOpts);
  }else{
  var tab_level1_select=jQuery.fn.readCookie("ketthuc");          
  if(tab_level1_select == null) 
  	tab_level1_select = 0;    
  level1ActiveTab = tab_level1_select;   
  var tabOpts={selected:tab_level1_select,select:function(event,level1Tab){jQuery.fn.createCookie("ketthuc",level1Tab.index); setLevel1ActiveTab(level1Tab.index)}};                
  $("#level1Tab").tabs(tabOpts);
  }
  var tab_level2_select = jQuery.fn.readCookie("ketthuc/tabKetQuaKetLuan");         
  if(tab_level2_select == null) 
  	tab_level2_select = 0;
  level2ActiveTab = tab_level2_select;
  var tabBbTongHop={selected:tab_level2_select,select:function(event,level2Tab){jQuery.fn.createCookie("ketthuc/tabKetQuaKetLuan",level2Tab.index); setLevel2ActiveTab(level2Tab.index)}};                  
  $("#level2Tab").tabs(tabBbTongHop); 
});    
function selfClose(){  
	if(window.opener != null)    
		window.close();
	else
		throw err;		
}
var url;
var submitString = ""; 
function createSubmitString(){ 
	reVal = "";  
	activeForm = findForm(url);  
	for(i = 0; i< activeForm.elements.length; i++)
		if(activeForm.elements[i].name != null && activeForm.elements[i].name != '' && activeForm.elements[i].value != null && activeForm.elements[i].value != '')
			reVal += activeForm.elements[i].name + "=" + encodeURIComponent(activeForm.elements[i].value) + "&";
	// collect thong tin chung. 
	activeForm = findForm('/' + contextRoot + '/ket_thuc_ttkt.do');
	for(i = 0; i< activeForm.elements.length; i++)
		if(activeForm.elements[i].name != null && activeForm.elements[i].name != '' && activeForm.elements[i].value != null && activeForm.elements[i].value != '')
			reVal += activeForm.elements[i].name + "=" + encodeURIComponent(activeForm.elements[i].value) + "&"; 
	reVal = reVal.substring(0, reVal.length - 1);  
	return reVal; 
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
function validateForm(){    
	return true;   
}		 

var cbDsThanhVienDoan;    
var dsIdThanhVienDoan; 
var dsChucVuTrongDoan;   
       
function getChucVuTvd(tvdId){ 
	chucVu = findChucVuById(tvdId); 
	chucVuVn = "";
	switch (chucVu){
		case "Truong doan":
			chucVuVn = "Trưởng đoàn"
			break;
		case "Pho doan":
			chucVuVn = "Phó đoàn"
			break;
		default:
			chucVuVn = "Thành viên đoàn"
			break;
	}
	return chucVuVn;
} 
function findChucVuById(idCanBo){   
	for(var i = 0; i< dsIdThanhVienDoan.length; i++)   
		if(dsIdThanhVienDoan[i] == idCanBo)
			return dsChucVuTrongDoan[i]; 
} 
function getTab1IndexInCookKie(){
	return "tienHanh";
}
function getTab2IndexInCookKie(){ 
	return "tienHanh/BbTongHop";  
}
var isLevel2TabActive = false;
var level1ActiveTab;  
var level2ActiveTab;
function setLevel2ActiveTab(tabLevel2Index){  
	level2ActiveTab = tabLevel2Index
} 
function setLevel1ActiveTab(tabLevel1Index){
	if(tabLevel1Index != 1)
		isLevel2TabActive = false;  
	else
		isLevel2TabActive = true;   
	level1ActiveTab = tabLevel1Index;    
}
var contextRoot = document.forms[0].action.split('/')[1]; 
function saveActiveTab(){        
	var isKqThuchienKL = false;	
	var isketLuanSangBaoCao = false;
	if(level1ActiveTab == 0||level1ActiveTab==""||level1ActiveTab=='null'||level1ActiveTab==null){      
		if(!validateThongBaoKetThuc())              
			return;
		url = 'ket_thuc_ttkt.do?method=save&type=thongBaoKetThuc';
	}else if(level1ActiveTab == 1){ 
		var saveResultDivName;     
		if(level2ActiveTab == 0) { 
			if(!validateDuThaoKetQua())      
				return; 
			url = 'ket_thuc_ttkt.do?method=save&type=duThaoKetQua';    
			saveResultDivName = 'saveDuThaoKetQua'
		}else if(level2ActiveTab == 1) {
			if(!validateKeQua())      
				return; 
			url = 'ket_thuc_ttkt.do?method=save&type=ketQua';    
			saveResultDivName = 'saveKetQua'  
		}else if(level2ActiveTab == 2) {
			if(!validateDuThaoKetLuan())      
				return; 
			url = 'ket_thuc_ttkt.do?method=save&type=duThaoKetLuan';    
			saveResultDivName = 'saveDuThaoKetLuan' 
		}else if(level2ActiveTab == 3){
			if(!validateKetLuan())      
				return; 
			url = 'ket_thuc_ttkt.do?method=save&type=ketLuan';    
			saveResultDivName = 'saveKetLuan' 
		}else if(level2ActiveTab == 4){
			if(!validateNDLTKetLuan())      
				return; 
			url = 'ket_thuc_ttkt.do?method=save&type=ketLuanSangBaoCao';     
			saveResultDivName = 'saveKetLuanSangBaoCao';   
			isketLuanSangBaoCao = true;
		}else throw "Err2";  
		url = '/' + contextRoot + '/' + url;
		if(isketLuanSangBaoCao){
			xmlhttpPost(url);
			//alert('isketLuanSangBaoCao');
		}else{    
			urlWithAllParam = url + '&' + getThongTinChung();
			ketThucTtktForm = findForm(url);
			if(ketThucTtktForm == null)
				ketThucTtktForm = findForm(urlWithAllParam);
			formObj = new DHTMLSuite.form({ formRef:ketThucTtktForm,action:urlWithAllParam, responseEl: saveResultDivName});
			formObj.submit();
		}
		return;		
	}else if(level1ActiveTab == 2){   
		if(!validateHopRutKinhNghiemDoan())          
			return;    
		url = 'ket_thuc_ttkt.do?method=save&type=hopRutKinhNghiemDoan';	  
	}else if(level1ActiveTab == 3){  
		if(!validateBanGiaoHoSoLuuTru())    
			return;  
		url = 'ket_thuc_ttkt.do?method=save&type=banGiaoHoSoLuuTru';    
	}else if(level1ActiveTab == 4){
		if(!validateChuyenDuLieuSangBaoCao())   
			return;  
		url = 'ket_thuc_ttkt.do?method=save&type=chuyenDuLieuSangBaoCao';  
		isKqThuchienKL = true;  
	}else throw "Err1";  
	url = '/' + contextRoot + '/' + url;
	if(isKqThuchienKL){
		saveResultDivName = 'saveKqThuchienKL';
		urlWithAllParam = url + '&' + getThongTinChung();
		ketThucTtktForm = findForm(url);
		if(ketThucTtktForm == null)
			ketThucTtktForm = findForm(urlWithAllParam);
		formObj = new DHTMLSuite.form({ formRef:ketThucTtktForm,action:urlWithAllParam, responseEl: saveResultDivName});
		formObj.submit();
		//alert('L\u01B0u th\u00E0nh c\u00F4ng');
	}else{
		xmlhttpPost(url);
	}
}
var formObj = new DHTMLSuite.form({ formRef:'KetThucTtktForm',action:'ket_thuc_ttkt.do',responseEl:'getReturn'});

function getThongTinChung(){
	thongTinChung = "";  
	thongTinChungForm = findForm('/' + contextRoot + '/ket_thuc_ttkt.do');
	for(i = 0; i< thongTinChungForm.elements.length; i++)
		if(thongTinChungForm.elements[i].name != null && thongTinChungForm.elements[i].name != '' && thongTinChungForm.elements[i].value != null && thongTinChungForm.elements[i].value != '')
			thongTinChung += thongTinChungForm.elements[i].name + "=" + encodeURIComponent(thongTinChungForm.elements[i].value) + "&"; 
	thongTinChung = thongTinChung.substring(0, thongTinChung.length - 1);
	return thongTinChung; 
}
function xemLichTrinhDuKien(){ 
	openWindow('lich_trinh_du_kien_ttkt.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value, '500','250','menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no');
}
function yeuCauCungCapTaiLieu(){ 
	window.open('yeu_cau_cung_cap_tai_lieu.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);
}
function kiemKeTaiSan(){   
	window.open('kiem_ke.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);
}
function niemPhongHoSoTaiLieu(){ 
	window.open('niem_phong_ho_so_tai_lieu.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);
}      
function phucTra(){
	window.open('phuc_tra?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);
}
function yeuCauGiaiTrinh(){ 
	window.open('yeu_cau_giai_trinh.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);
}
function kiemTraXacMinh(){    
	window.open('kiem_tra_xac_minh.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);
}
function trungCauGiamDinh(){
	window.open('trung_cau_giam_dinh.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);
}
function giaHan(){
	window.open('gia_han.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);
}
function thayDoiThanhVien(){ 
	window.open('thay_doi_thanh_vien_doan.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);
} 
function setActiveTab(tabIndex){  
	activeTab = tabIndex; 
}  
function findForm(formAction){ 
	for(i = 0; i< document.forms.length; i++){
		if(document.forms[i].action == formAction){ 
			return document.forms[i]  
		}
	}
	return null;
}
var url; 
var submitString = "";
function getThongTinChung(){
	thongTinChung = "";  
	thongTinChungForm = findForm('/' + contextRoot + '/ket_thuc_ttkt.do');
	for(i = 0; i< thongTinChungForm.elements.length; i++)
		if(thongTinChungForm.elements[i].name != null && thongTinChungForm.elements[i].name != '' && thongTinChungForm.elements[i].value != null && thongTinChungForm.elements[i].value != '')
			thongTinChung += thongTinChungForm.elements[i].name + "=" + encodeURIComponent(thongTinChungForm.elements[i].value) + "&"; 
	thongTinChung = thongTinChung.substring(0, thongTinChung.length - 1);
	return thongTinChung;  
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
function validateForm(){ 
	return true;  
}		
window.onload = function(){
	if(level1ActiveTab != 1)
		isLevel2TabActive = false;
	else
		isLevel2TabActive = true;
	numOfLevel1Tab = document.getElementById('level1Tab').childNodes[0].childNodes.length;
	numOfLevel2Tab = document.getElementById('level2Tab').childNodes[0].childNodes.length;
	getDsThanhVienDoan();
	onLoadThongBaoKetThuc();
	onLoadKetLuanKetQua();
	onLoadHopRutKinhNghiemDoan();
	onLoadBanGiaoHsLuuTru();
	onLoadChuyenDuLieuSangBaoCao();
	method = getUrlParam('method')
	if('view' == method){
		setVisibleButton();
	}	
	//thêm dòng trắng
	if($('#tb_DS_TPTD tbody tr').length==1){
		themThanhPhanThamDu();
	}
	if($('#tblDaiDienBenGiaoHsTL tbody tr').length==1){
		themDaiDienBenGiaoHstl();
	}
	if($('#tblDaiDienBenNhanHsTL tbody tr').length==1){
		themDaiDienBenNhanHstl();
	}
}
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
	chucVu = findChucVuById(tvdId);
	chucVuVn = "";
	switch (chucVu){
		case "Truong doan":
			chucVuVn = "Trưởng đoàn"
			break;
		case "Pho doan":
			chucVuVn = "Phó đoàn"
			break;
		default:
			chucVuVn = "Thành viên đoàn"
			break;
	}
	return chucVuVn;
}
function findChucVuById(idCanBo){
	for(var i = 0; i< dsIdThanhVienDoan.length; i++)
		if(dsIdThanhVienDoan[i] == idCanBo)
			return dsChucVuTrongDoan[i]; 
}
function xuLySaveThanhCongCuaTungForm(){ 
		window.location.reload();
}
function xuLySaveKhongThanhCongCuaTungForm(maLoi){
	switch (maLoi){
		case "1": 
			alert('Chưa nhập thông báo kết thúc!');
			break;		
		case "2": 
			alert('Chưa nhập kết quả Thanh tra Kiểm tra!');
			break;
		case "3":  
			alert('Chưa nhập kết luận Thanh tra Kiểm tra!');
			break;
		case "4": 
			alert('Chưa nhập họp rút kinh nghiệm đoàn!');
			break;
		case "5": 
			alert('Chưa nhập bàn giao hồ sơ lưu trữ!');
			break;
		default: 
			break; 
	}	
}	                      
function validateDateRequired(dateElement){  
	if(dateElement.value!=null&&dateElement.value!=""){
		switch(dateElement.name){
		case "thoiDiemBatDauHopRutKinhNghiem":
			var ngayRaKetLuanSv = '<%=request.getAttribute("ngayRaKetLuan")%>';
			var ngayRaKetLuan = $('[name="ngayRaKetLuan"]')[0].value;
			ngayRaKetLuan = (ngayRaKetLuanSv==""||ngayRaKetLuanSv==null||ngayRaKetLuanSv=='null')?ngayRaKetLuan:ngayRaKetLuanSv;
			if(ngayRaKetLuan==""||ngayRaKetLuan==null||ngayRaKetLuan=='null'){
				alert("Chưa có ngày ra kết luận");
			}else{
				if(d2n(ngayRaKetLuan)>d2n(dateElement.value.split(" ")[1])){
					alert("Thời điểm họp rút kinh nhiệm đoàn phải sau thời gian ra quyết định (" + ngayRaKetLuan + ")!");
				}
			}
			
			break;
		case "thoiDiemBatDauBanGianHoSoLuuTru","thoiDiemKetThucBanGianHoSoLuuTru":
			var ngayRaKetLuanSv = '<%=request.getAttribute("ngayRaKetLuan")%>';
				var ngayRaKetLuan = $('[name="ngayRaKetLuan"]')[0].value;
				ngayRaKetLuan = (ngayRaKetLuanSv==""||ngayRaKetLuanSv==null||ngayRaKetLuanSv=='null')?ngayRaKetLuan:ngayRaKetLuanSv;
				if(ngayRaKetLuan==""||ngayRaKetLuan==null||ngayRaKetLuan=='null'){
					alert("Chưa có ngày ra kết luận");
				}else{
					if(d2n(ngayRaKetLuan)>d2n(dateElement.value.split(" ")[1])){
						alert("Thời điểm bàn giao hồ sơ phải sau thời gian ra quyết định (" + ngayRaKetLuan + ")!");
					}
				}
			break;
		default:
			break;
		}	
	}
}                            
</script>  
<%@ include file="/bottom.jsp"%>
