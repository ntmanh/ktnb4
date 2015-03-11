<%@page pageEncoding="UTF-8"%>        
<%@ include file="/top_bar.jsp"%>
<script type="text/javascript" src="<html:rewrite page='/include/js/ttkt/ttkt.js'/>"></script>
<%@page import="cmc.com.ktnb.util.Constants"%>
<%@page import="cmc.com.ktnb.util.ApplicationContext"%>            
<script language="javascript">              
	var tenCqt = "<%=((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getTenCqt()%>";
	var maCqt = '<%=((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getMaCqt()%>'                      
</script>    
<!-- <h3 class="Header">Tiến hành Thanh tra Kiểm tra</h3>  -->   
<h3 class="Header">Tiến hành - Mã cuộc <bean:write name="TienHanhTtktForm" property="maCuocTtkt"/></h3>
<DIV style="padding-bottom: 5px"><B><a href="#" onclick="xemThongTinChung();">Thông tin chung</a> |</B> <B><a href="#" onclick="xemLichTrinhDuKien();">Lịch trình dự kiến</a></B></DIV>
<div id="level1Tab">
<ul>   
	<li><a href="#tabTBKetThuc">Thông báo kết thúc</a></li>
	<li><a href="#tabCBQD">Công bố quyết định</a></li> 
	<!-- <li><a href="#tabNhatKyTtkt">Nhật ký Thanh tra Kiểm 
	tra</a></li> --> 
	<li><a href="#tabNhatKyTtkt">Nhật ký đoàn kiểm tra</a></li>
	<li><a href="#tabBbChiTiet">Biên bản chi tiết</a></li>
	<li><a href="#tabBanGiaoHstlChoTd">Bàn giao HSTL cho trưởng đoàn</a></li>     
	<li><a href="#level2Tab">Biên bản tổng hợp</a></li>       
</ul>        
<DIV id="tabTBKetThuc">
<fieldset style="width: 100%"><%@ include
	file="/ttkt/tien_hanh_ttkt/thong_bao_ket_thuc.jsp"%></fieldset>  
</DIV>
<DIV id="tabCBQD">
<div style="width: 100%;"><%@ include file="/ttkt/tien_hanh_ttkt/cong_bo_quyet_dinh.jsp"%></div>   
</DIV>   
<DIV id="tabNhatKyTtkt">   
<fieldset style="width: 99%"><%@ include file="/ttkt/tien_hanh_ttkt/nhat_ky.jsp"%></fieldset>
</DIV>
<DIV id="tabBbChiTiet">   
<fieldset style="width: 100%"><%@ include file="/ttkt/tien_hanh_ttkt/tab_bien_ban_chi_tiet.jsp"%></fieldset>
</DIV>              
<DIV id="tabBanGiaoHstlChoTd">   
<fieldset style="width: 100%"><%@ include file="/ttkt/tien_hanh_ttkt/ban_giao_ho_so_tai_lieu_cho_truong_doan.jsp"%></fieldset>
</DIV>
<div id="level2Tab">   
<ul>   
	<li><a href="#tabDuThaoBienbanTongHop">Dự thảo biên bản tổng hợp</a></li>   
	<li><a href="#tabBienbanTongHopKetQuaGuiChoDvDuocTtkt">Biên	bản tổng hợp gửi đơn vị được Kiểm tra</a></li>     
	<li><a href="#tabBienbanTongHop">Biên bản tổng hợp kết quả</a></li>   
</ul>
<FIELDSET style="width: 100%"><%@ include file="/ttkt/tien_hanh_ttkt/tab_bien_ban_tong_hop_ket_qua.jsp"%>
</FIELDSET>  
</DIV>
<logic:present name="readOnly">
	<script language="javascript"> 
		var lastLabelId = '';
	</script>
	<DIV id='dvCnPhu'><logic:present name="bien ban lam viec"> 
		<a href="#" onclick="bienBanLamViec();" class="linkCnPhu"><font color="blue">Biên bản làm việc</font></a>
		<label id="bien ban lam viec">&nbsp;|</label>
		<script language="javascript">
				lastLabelId = 'bien ban lam viec';      
			</script>
	</logic:present> <logic:present name="yeu cau bo sung hstl">
		<a href="#" onclick="yeuCauCungCapTaiLieu();" class="linkCnPhu"><font color="blue">Yêu cầu cung cấp báo cáo, hồ sơ, tài liệu</font></a>
		<label id="yeu cau bo sung hstl">&nbsp;|</label>
		<script language="javascript">
				lastLabelId = 'yeu cau bo sung hstl';
			</script>
	</logic:present> <logic:present name="kiem ke tai san">
		<a href="#" onclick="kiemKeTaiSan();" class="linkCnPhu"><font color="blue">Kiểm kê tài sản</font></a>
		<label id="kiem ke tai san">&nbsp;|</label>
		<script language="javascript"> 
			lastLabelId = 'kiem ke tai san'; 
		</script>
	</logic:present> <logic:present name="niem phong ho so tai lieu">
		<a href="#" onclick="niemPhongHoSoTaiLieu();" class="linkCnPhu"><font color="blue">Niêm phong hồ sơ, tài liệu</font></a>
		<label id="niem phong ho so tai lieu">&nbsp;|</label>
		<script language="javascript">
			lastLabelId = 'niem phong ho so tai lieu';
		</script>
	</logic:present> <logic:present name="phuc tra">
		<a href="#" onclick="phucTra();" class="linkCnPhu"><font color="blue">Phúc tra</font></a>
		<label id="phuc tra">&nbsp;|</label>
		<script language="javascript">
			lastLabelId = 'phuc tra';
		</script>
	</logic:present> <logic:present name="Yeu cau giai trinh">
		<a href="#" onclick="yeuCauGiaiTrinh();" class="linkCnPhu"><font color="blue">Yêu cầu giải trình</font></a>
		<label id="Yeu cau giai trinh">&nbsp;|</label>
		<script language="javascript">
			lastLabelId = 'Yeu cau giai trinh';
		</script>
	</logic:present> <logic:present name="Kiem tra xac minh">
		<a href="#" onclick="kiemTraXacMinh();" class="linkCnPhu"><font color="blue">Kiểm tra, xác minh</font></a>
		<label id="Kiem tra xac minh">&nbsp;|</label>
		<script language="javascript">
			lastLabelId = 'Kiem tra xac minh';
		</script>
	</logic:present> <logic:present name="Trung cau giam dinh">
		<a href="#" onclick="trungCauGiamDinh();" class="linkCnPhu"><font color="blue">Trưng cầu giám định</font></a>
		<label id="Trung cau giam dinh">&nbsp;|</label>
		<script language="javascript">
			lastLabelId = 'Trung cau giam dinh';
		</script>
	</logic:present> <logic:present name="Chuyen giao ho so vu viec">
		<a href="#" onclick="chuyenGiaoHoSoVuViec();" class="linkCnPhu"><font color="blue">Chuyển giao hồ sơ vụ việc sang cơ quan điều tra</font></a>
		<label id="Chuyen giao ho so vu viec">&nbsp;|</label>
		<script language="javascript">
			lastLabelId = 'Chuyen giao ho so vu viec';
		</script>
	</logic:present> <logic:present name="Gia han thanh tra kiem tra">
		<a href="#" onclick="giaHan();" class="linkCnPhu"><font color="blue">Gia hạn</font></a>
		<label id="Gia han thanh tra kiem tra">&nbsp;|</label>
		<script language="javascript">
			lastLabelId = 'Gia han thanh tra kiem tra';
		</script>
	</logic:present> <logic:present name="Thay doi thanh vien doan">
		<a href="#" onclick="thayDoiThanhVien();" class="linkCnPhu"><font color="blue">Thay đổi thành viên đoàn</font></a>
		<label id="Thay doi thanh vien doan">&nbsp;|</label>
		<script language="javascript">
			lastLabelId = 'Thay doi thanh vien doan';
		</script>
	</logic:present></DIV>
	<script language="javascript">
		if(lastLabelId != '')
			document.getElementById(lastLabelId).innerHTML = '';
	</script>
</logic:present> <logic:notPresent name="readOnly">
	<DIV id='dvCnPhu'><a href="#" onclick="bienBanLamViec();" class="linkCnPhu"><font color=blue>Biên bản làm việc</font></a> | <a href="#" onclick="yeuCauCungCapTaiLieu();" class="linkCnPhu"> <font color=blue> Yêu cầu cung cấp báo
	cáo, hồ sơ, tài liệu </font></a> | <a href="#" onclick="kiemKeTaiSan();" class="linkCnPhu"><font color=blue>Kiểm kê tài sản</font></a> | <a href="#" onclick="niemPhongHoSoTaiLieu();" class="linkCnPhu"><font color=blue>Niêm phong hồ
	sơ, tài liệu</font></a> | <a href="#" onclick="phucTra();" class="linkCnPhu"><font color="blue">Phúc tra</font></a> | <a href="#" onclick="yeuCauGiaiTrinh();" class="linkCnPhu"><font color="blue">Yêu cầu giải trình</font></a> | <a href="#" onclick="kiemTraXacMinh();"
		class="linkCnPhu"><font color="blue">Kiểm tra, xác minh</font></a> | <a href="#" onclick="trungCauGiamDinh();" class="linkCnPhu"><font color="blue">Trưng cầu giám định</font></a> | <a href="#" onclick="chuyenGiaoHoSoVuViec();" class="linkCnPhu"><font
		color="blue">Chuyển giao hồ sơ vụ việc sang cơ quan điều tra</font></a> | <a href="#" onclick="giaHan();" class="linkCnPhu"><font color="blue">Gia hạn</font></a> | <a href="#" onclick="thayDoiThanhVien();" class="linkCnPhu"><font color="blue">Thay
	đổi thành viên đoàn</font></a></DIV>
</logic:notPresent></div>
<html:form action="tien_hanh_ttkt.do" method="POST">
	<html:hidden property="idCuocTtkt" />
	<html:hidden property="diaDiem" />
</html:form>
<div style="width: 100%; margin: 0"><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></div>
<%@ include file="/bottom.jsp"%>
<script language="javascript">   
var isLevel2TabActive = false; 
var level1ActiveTab =0;      
var level2ActiveTab =0;  
$(function()    
{    
  var idCongBoQuyetDinh = $('[name="idCongBoQuyetDinh"]')[0].value;
  if(idCongBoQuyetDinh==""||idCongBoQuyetDinh=="null"){
  tab_level1_select=0;
  var tabOpts={selected:tab_level1_select,select:function(event,level1Tab){jQuery.fn.createCookie("tienHanh",level1Tab.index); setLevel1ActiveTab(level1Tab.index)}};                
  $("#level1Tab").tabs(tabOpts); 
  }else{
  var tab_level1_select=jQuery.fn.readCookie("tienHanh");       
  if(tab_level1_select == null)
  	tab_level1_select = 0;
  level1ActiveTab = tab_level1_select;
  var tabOpts={selected:tab_level1_select,select:function(event,level1Tab){jQuery.fn.createCookie("tienHanh",level1Tab.index); setLevel1ActiveTab(level1Tab.index)}};                
  $("#level1Tab").tabs(tabOpts); 
  }
  var tab_level2_select = jQuery.fn.readCookie("tienHanh/BbTongHop");       
  if(tab_level2_select == null||$('[name="idDuThaoBbTongHop"]')[0].value==""||$('[name="idDuThaoBbTongHop"]')[0].value==null)
  	tab_level2_select = 0;
  level2ActiveTab = tab_level2_select;
  var tabBbTongHop={selected:tab_level2_select,select:function(event,level2Tab){jQuery.fn.createCookie("tienHanh/BbTongHop",level2Tab.index); setLevel2ActiveTab(level2Tab.index)}};                  
  $("#level2Tab").tabs(tabBbTongHop); 
      
});
function validateRequiredDate(dateElement){
if(dateElement.value!=""){
	var ngayRaQuyetDnh = '<%=request.getAttribute("ngayRaQuyetDnh")%>';
	var ngayCbQuyetDnh =  $('[name="thoiDiemCbTu"]')[0].value;
	try{
		if(dateElement.name.split('.')[1]=="ngayStr"){
			if(d2n(ngayCbQuyetDnh.split(' ')[1]) > d2n(dateElement.value)){
					alert('Thời gian phải sau thời gian công bố quyết định('+ngayCbQuyetDnh+')');
					$(dateElement).focus().select();
					return;
				}
		}
	}catch(e){
	}
	try{
	if(d2n(ngayRaQuyetDnh) > d2n(dateElement.value.split(' ')[1])){
				alert('Thời gian phải sau thời gian ra quyết định('+ngayRaQuyetDnh+')');
				$(dateElement).focus().select();
			}
			}catch(e){
				if(d2n(ngayRaQuyetDnh) > d2n(dateElement.value)){
					alert('Thời gian phải sau thời gian ra quyết định('+ngayRaQuyetDnh+')');
					$(dateElement).focus().select();
				}
			}
	}
}
function xuLySaveKhongThanhCongCuaTungForm(maLoi){
	//alert('Cuộc Thanh tra Kiểm tra chưa được công bố quyết định !');
	alert('Cuộc Kiểm tra chưa được công bố quyết định !');
}
function chuaCongBoQd(){ 
	if(!isEmpty(document.getElementsByName('idCongBoQuyetDinh')[0].value))
		return false;  
	var xmlHttpReq = false; 
    if (window.XMLHttpRequest) {
        xmlHttpReq = new XMLHttpRequest(); 
    }
    else if (window.ActiveXObject) { 
        xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP"); 
    }   
    
    xmlHttpReq.open('POST', 'tien_hanh_ttkt.do?method=checkCongBoQd&cuocTtktId=' + document.getElementsByName('idCuocTtkt')[0].value, true); 
    xmlHttpReq.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=UTF-8");
    xmlHttpReq.onreadystatechange = function() {
    	if (xmlHttpReq.readyState==4 && xmlHttpReq.status==200){
		  	if(xmlHttpReq.responseText == 'true'){
		  		return true;
		  	}	
		  	else {
		  		return false;
		  	}
		}    	
    }
    xmlHttpReq.send();
}
function selfClose(){
	if(window.opener != null) 
		window.close();
	else
		throw err;		
}
function getTab1IndexInCookKie(){
	return "tienHanh";
}
function getTab2IndexInCookKie(){ 
	return "tienHanh/BbTongHop";
}
function setLevel2ActiveTab(tabLevel2Index){  
	level2ActiveTab = tabLevel2Index
}
function setLevel1ActiveTab(tabLevel1Index){
	if(tabLevel1Index != 4)
		isLevel2TabActive = false; 
	else
		isLevel2TabActive = true;   
	level1ActiveTab = tabLevel1Index; 
}
var contextRoot = document.forms[0].action.split('/')[1];
function saveActiveTab(){ 		
	if(level1ActiveTab == 0){      
		if(!validateCongBoQuyetDinh())        
			return;
		url = 'tien_hanh_ttkt.do?method=save&type=thongBaoKetThuc';
	}else if(level1ActiveTab == 1){      
		if(!validateCongBoQuyetDinh())        
			return;
		url = 'tien_hanh_ttkt.do?method=save&type=congBoQd';
	}else if(level1ActiveTab == 2){ 
		if(!validateNhatKy())    
			return;   
		url = 'tien_hanh_ttkt.do?method=save&type=nhatKy';               
	}else if(level1ActiveTab == 3){  
		level1ActiveTab++;
		var tempTab={selected:level1ActiveTab,select:function(event,level1Tab){jQuery.fn.createCookie(getTab2IndexInCookKie(),level1Tab.index); setLevel1ActiveTab(level1Tab.index)}};                
		$("#level1Tab").tabs(tempTab);
		return; 
		
	}else if(level1ActiveTab == 4){  
		luuBbBanGiao()   
		return; 
	}else if(level1ActiveTab == 5){ 
		var saveResultDivName;
		if(level2ActiveTab == 1) {
			if(!validateDuThaoBbTongHop())      
				return;   
			url = 'tien_hanh_ttkt.do?method=save&type=duThaoBienBanTongHop';    
			saveResultDivName = 'saveDuThaoBbTongHopKqResult'
		}else if(level2ActiveTab == 2) {
			if(!validateBbTongHopGuiDvDuocTtkt())      
				return;       
			url = 'tien_hanh_ttkt.do?method=save&type=bienBanTongHopKetQuaGuiDvDuocTtkt';    
			saveResultDivName = 'saveBbTongHopKqGuiDvDuocTtktResult'
		}else if(level2ActiveTab == 3) {
			if(!validateBbTongHop())      
				return; 
			url = 'tien_hanh_ttkt.do?method=save&type=bienBanTongHop';    
			saveResultDivName = 'saveBbTongHopKqResult' 
		}else throw "Err2";  
		url = '/' + contextRoot + '/' + url;
		urlWithAllParam = url + '&' + getThongTinChung();
		bienBanTongHopForm = findForm(url);
		if(bienBanTongHopForm == null)
			bienBanTongHopForm = findForm(urlWithAllParam);
		formObj = new DHTMLSuite.form({ formRef:bienBanTongHopForm,action:urlWithAllParam, responseEl: saveResultDivName});
		formObj.submit();
		return;
		
	}else throw "Err1";  
	url = '/' + contextRoot + '/' + url;
	//alert(url);
	xmlhttpPost(url);
		                      
}
var formObj = new DHTMLSuite.form({ formRef:'TienHanhTtktForm',action:'tien_hanh_ttkt.do',responseEl:'getReturn'});
function getThongTinChung(){
	thongTinChung = "";  
	thongTinChungForm = findForm('/' + contextRoot + '/tien_hanh_ttkt.do');
	for(i = 0; i< thongTinChungForm.elements.length; i++)
		if(thongTinChungForm.elements[i].name != null && thongTinChungForm.elements[i].name != '' && thongTinChungForm.elements[i].value != null && thongTinChungForm.elements[i].value != '')
			thongTinChung += thongTinChungForm.elements[i].name + "=" + encodeURIComponent(thongTinChungForm.elements[i].value) + "&"; 
	thongTinChung = thongTinChung.substring(0, thongTinChung.length - 1); 
	return thongTinChung;  
}             
        

function xemLichTrinhDuKien(){ 
	openWindow('lich_trinh_du_kien_ttkt.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value, '500','250','menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no');
	
}
function bienBanLamViec(){
	url = 'bien_ban_lam_viec.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	window.open(url).focus();
}
function yeuCauCungCapTaiLieu(){
	url = 'yeu_cau_cung_cap_tai_lieu.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	window.open(url).focus();	
}
function kiemKeTaiSan(){  
	url = 'kiem_ke.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	window.open(url).focus();	
}
function niemPhongHoSoTaiLieu(){
	url = 'niem_phong_ho_so_tai_lieu.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	window.open(url).focus();
	
}
function phucTra(){
	url = 'phuc_tra.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	window.open(url).focus();
}
function yeuCauGiaiTrinh(){ 
	url = 'yeu_cau_giai_trinh.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value +'&type=yeuCauGiaiTrinh';
	window.open(url).focus();	
}
function kiemTraXacMinh(){
	url = 'kiem_tra_xac_minh.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	window.open(url).focus();	
}
function trungCauGiamDinh(){
	url = 'trung_cau_giam_dinh.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	window.open(url).focus();	
}
function giaHan(){   
	window.open('gia_han.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value).focus();	
} 
function thayDoiThanhVien(){    
	window.open('thay_doi_thanh_vien_doan.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value).focus();	
	 
} 
function chuyenGiaoHoSoVuViec(){
	url = 'ban_giao_ho_so_vu_viec.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	window.open(url).focus();	

}


function setActiveTab(tabIndex){  
//	alert(tabIndex);
	activeTab = tabIndex; 
}       

var url; 
var submitString = "";
function getThongTinChung(){
	thongTinChung = "";  
	thongTinChungForm = findForm('/' + contextRoot + '/tien_hanh_ttkt.do');
	for(i = 0; i< thongTinChungForm.elements.length; i++)
		if(thongTinChungForm.elements[i].name != null && thongTinChungForm.elements[i].name != '' && thongTinChungForm.elements[i].value != null && thongTinChungForm.elements[i].value != '')
			thongTinChung += thongTinChungForm.elements[i].name + "=" + encodeURIComponent(thongTinChungForm.elements[i].value) + "&"; 
	thongTinChung = thongTinChung.substring(0, thongTinChung.length - 1);
	return thongTinChung;  
}
function createSubmitString(){ 
	
	reVal = "";  
	activeForm = findForm(url); 
	if(url != '/' + contextRoot + '/tien_hanh_ttkt.do?method=save&type=bienBanTongHop'){
		for(i = 0; i< activeForm.elements.length; i++)
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
	onLoadCongBoQuyetDinh();     
	onLoadBanGiaoHstl(); 
	onLoadDuThaoBbTongHop();
	onLoadBbTongHopGuiDvDuocTtkt();
	onLoadBbTongHop();	
	if(level1ActiveTab != 4)
		isLevel2TabActive = false;
	else
		isLevel2TabActive = true;
	numOfLevel1Tab = document.getElementById('level1Tab').childNodes[0].childNodes.length;
	numOfLevel2Tab = document.getElementById('level2Tab').childNodes[0].childNodes.length;
	getDsThanhVienDoan();
	method = getUrlParam('method')
	if('view' == method){
		setVisibleButton();
	}
	try{
		if(document.getElementsByName('thoiDiemCbTu')[0].value)
			document.getElementById('dvCnPhu').style.display = 'inline'
		else
			document.getElementById('dvCnPhu').style.display = 'none'
			
	}catch(err){
	}
	var arr = $(".duanIdCanBo");
	for(var i = 0;i<arr.length;i++){
		thayDoiThanhVienDoan(arr[i]);
	}       
	//để một dòng trống trước các danh sách
	if($('#daiDienCoQuanBanHanhQuyetDinh tbody tr').length==1){
		themTtptCqtBanHanhQd();
	}
	if($('#daiDienCqqlCapTren tbody tr').length==1){
		themTtptCqqlCapTren();
	}
	if($('#daiDienDoanTtkt tbody tr').length==1){
		themTtptDoanTtkt();
	}
	if($('#daiDienDonViDuocTtkt tbody tr').length==1){
		themTtptDonViDuocTtkt();
	}
	if($('#tblNhatKyTtkt tbody tr').length==1){
		themNhatKy();
	}
	if($('#tblBanGiaoHstlChoTruongDoan tbody tr').length==1){
		themBanGiaoHsTl();
	}
}   
var cbDsThanhVienDoan;  
var dsIdThanhVienDoan; 
var dsChucVuTrongDoan; 
var cbDstvd;   
function getDsThanhVienDoan(){
	cbDstvd='<%=request.getAttribute("cbDstvd")%>';
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
function xuLySaveKhongThanhCongCuaTungForm(maLoi){     
	switch (maLoi){
		case "1": 
			alert('Chưa nhập bàn giao hồ sơ tài liệu cho trưởng đoàn!');
			break;		
		default: 
			break;          
	}	
}
function xuLySaveThanhCongCuaTungForm(){
	if(level1ActiveTab==0)
		document.getElementById('dvCnPhu').style.display = 'inline';	
	if(level1ActiveTab == 4){
		if(level2ActiveTab == 2){
			if(window.confirm('Bạn đã nhập xong dữ liệu cho bước Tiến hành! Bạn có muốn nhập tiếp thông tin cho bước Kết thúc không?')){
				window.location = 'ket_thuc_ttkt.do?cuocTtktId=' + document.getElementsByName('idCuocTtkt')[0].value;
				return;
			}				  
		}
		window.location.reload();
	}
var cbDstvdNotTd;

}</script>