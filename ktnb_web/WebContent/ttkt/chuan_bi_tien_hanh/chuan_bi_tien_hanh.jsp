<%@page pageEncoding="UTF-8"%>                    
<%@ include file="/top_bar.jsp"%>      
<script type="text/javascript" src="<html:rewrite page='/include/js/ttkt/ttkt.js'/>"></script>
<%@page import="cmc.com.ktnb.util.Constants"%>
<%@page import="cmc.com.ktnb.util.ApplicationContext"%> 
<script language="javascript">                  
	var tenCqt = "<%=((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getTenCqt()%>";
	var maCqt = '<%=((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getMaCqt()%>';                 
</script> 
<h3 class="Header">Chuẩn bị tiến hành - Mã cuộc <bean:write name="ChuanBiTienHanhForm" property="maCuocTtkt"/> </h3>
<html:form action="chuan_bi_tien_hanh.do" method="POST" styleId="cbthForm">
	<html:hidden property="idCuocTtkt" />
	<html:hidden property="diaDiem" />  
</html:form>
<DIV id="chua_co_lich_trinh_du_kien"><B><a href="#" onclick="xemThongTinChung();">Thông tin chung</a></B></DIV>
<DIV id="da_co_lich_trinh_du_kien"><B><a href="#" onclick="xemThongTinChung();">Thông tin chung</a><label>&nbsp;|</label></B> <B><a href="#" onclick="xemLichTrinhDuKien();">Lịch trình dự kiến</a></B></DIV>
</br>
<div id="tab" style="margin: 5px 5px 5px 5px">
<ul>
	<li><a href="#tabBCKS"><b>Báo cáo khảo sát</b></a></li>
	<li><a href="#tabTVDoan"><b>Thành viên đoàn</b></a></li>
	<li><a href="#tabQuyetDinh"><b>Quyết định</b></a></li>           
	<li><a href="#tabKH"><b>Kế hoạch</b></a></li>
	<li><a href="#tabDeCuong"><b>Đề cương</b></a></li>    
	<li><a href="#tabHopDoanTrienKhai"><b>Họp đoàn triển khai</b></a></li>   
</ul>
<DIV id="tabBCKS">    
<fieldset style="width: 100%"><%@ include file="/ttkt/chuan_bi_tien_hanh/bao_cao_ks.jsp"%></fieldset>   
</DIV>     
<DIV id="tabTVDoan">     
<fieldset style="width: 100%"><%@ include file="/ttkt/chuan_bi_tien_hanh/chi_dinh_thanh_vien.jsp"%></fieldset>    
</DIV>
<DIV id="tabQuyetDinh">
<fieldset style="width: 100%"><%@ include file="/ttkt/chuan_bi_tien_hanh/quyet_dinh_ttkt.jsp"%></fieldset>
</DIV>
<DIV id="tabKH">
<fieldset style="width: 100%"><%@ include file="/ttkt/chuan_bi_tien_hanh/ke_hoach_ttkt.jsp"%></fieldset>
</DIV>
<DIV id="tabDeCuong">
<fieldset style="width: 100%"><%@ include file="/ttkt/chuan_bi_tien_hanh/de_cuong_ttkt.jsp"%></fieldset>
</DIV>
<DIV id="tabHopDoanTrienKhai">
<fieldset style="width: 100%"><%@ include file="/ttkt/chuan_bi_tien_hanh/hop_doan_trien_khai.jsp"%></fieldset>
</DIV>
<logic:present name="readOnly">    
	<script language="javascript">     
		var lastLabelId = '';       
	</script>
	<DIV><logic:present name="hoan">
		<!-- <a href="#" onclick="hoan();" class="linkCnPhu"><font color=blue>Hoãn Thanh tra Kiểm tra</font></a><label id="hoan">&nbsp;|</label> -->
		<a href="#" onclick="hoan();" class="linkCnPhu"><font color=blue>Hoãn Kiểm tra</font></a>
		<label id="hoan">&nbsp;|</label>
		<script language="javascript">   
				lastLabelId = 'hoan';
			</script>    
	</logic:present> <logic:present name="gia han">
		<!-- <a href="#" onclick="giaHan();" class="linkCnPhu"><font color=blue>Gia hạn Thanh tra Kiểm tra</font></a><label id="gia_han">&nbsp;|</label> -->
		<a href="#" onclick="giaHan();" class="linkCnPhu"><font color=blue>Gia hạn Kiểm tra</font></a>
		<label id="gia_han">&nbsp;|</label>
		<script language="javascript">
				lastLabelId = 'gia_han';  
			</script> 
	</logic:present> <logic:present name="thay doi thanh vien doan">
		<a href="#" onclick="thayDoiThanhVien();" class="linkCnPhu"><font color=blue>Thay đổi thành viên đoàn</font></a>
		<label id="thay_doi_thanh_vien_doan">&nbsp;|</label>
		<script language="javascript">
				lastLabelId = 'thay_doi_thanh_vien_doan';
			</script>
	</logic:present></DIV>  
	<script language="javascript">
		if(lastLabelId != '')
			document.getElementById(lastLabelId).innerHTML = '';
	</script>    
</logic:present> <logic:notPresent name="readOnly">
	<logic:present name="da_co_lich_trinh_du_kien">
		<DIV id="divThongTinPhu" style="display: inline;"><!-- <a href="#" onclick="huy();" class="linkCnPhu"><font color=blue>Hủy Thanh tra Kiểm tra</font></a> |
			<a href="#" onclick="hoan();" class="linkCnPhu"><font color=blue>Hoãn Thanh tra Kiểm tra</font></a> |
			<a href="#" onclick="giaHan();" class="linkCnPhu"><font color=blue>Gia hạn Thanh tra Kiểm tra</font></a> |
			<a href="#" onclick="thayDoiThanhVien();" class="linkCnPhu"><font color=blue>Thay đổi thành viên đoàn</font></a> --> <a href="#" onclick="huy();" class="linkCnPhu"><font color=blue>Hủy Kiểm tra</font></a> | <a href="#" onclick="hoan();" class="linkCnPhu"><font
			color=blue>Hoãn Kiểm tra</font></a> | <a href="#" onclick="giaHan();" class="linkCnPhu"><font color=blue>Gia hạn Kiểm tra</font></a> | <a href="#" onclick="thayDoiThanhVien();" class="linkCnPhu"><font color=blue>Thay đổi thành viên đoàn</font></a>
		</DIV>
	</logic:present>     
</logic:notPresent></div>
<br/>
<div style="width: 100%; margin: 0"><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></div>
<%@ include file="/bottom.jsp"%>

<INPUT type="hidden" name="truongGiuNgayTam"> 
<script language="javascript">     
function selfClose(){
	if(window.opener != null)
		window.close();
	else
		throw err;		
}
function huy(){ 
window.open('huy_ttkt.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);
}     
function hoan(){
window.open('hoan_ttkt.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);
}     
function giaHan(){ 
	window.open('gia_han.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);
} 
function thayDoiThanhVien(){
	window.open('thay_doi_thanh_vien_doan.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value);
}  
    
var cbDsThanhVienDoan; 
$(function()             
{
 var  idQD = document.getElementsByName('maFileBCKS')[0].value;
  //alert(idQD);
  if(idQD== null || idQD ==''||idQD ==" "){
  	activeTab =0;
  }	
  else{
	  var tab_select = jQuery.fn.readCookie(getTabIndexInCookKie());      
	  setActiveTab(tab_select); 
  }  
  var tabOpts={selected:activeTab ,select:function(event,tab){jQuery.fn.createCookie(getTabIndexInCookKie(), tab.index ); setActiveTab(tab.index)}};                
  $("#tab").tabs(tabOpts);   
  dsIdThanhVienDoan = '<%=request.getAttribute("dsIdThanhVienDoan")%>'
	dsIdThanhVienDoan = dsIdThanhVienDoan.split(',');
	dsChucVuTrongDoan = '<%=request.getAttribute("dsChucVuTrongDoan")%>'   
	dsChucVuTrongDoan = dsChucVuTrongDoan.split(',');
	onloadChiDinhThanhVienDoan();
	onLoadKeHoach();
	onloadDeCuong(); 
	onLoadBaoCaoKs();
	if(activeTab == null)
		activeTab = 0; 
	numOfTab = document.getElementById('tab').childNodes[0].childNodes.length;
	createOptionsFromDsThanhVien();      
	method = getUrlParam('method')
	if('view' == method){
		setVisibleButton();
	}      
	hideContents();
	//để một dòng trống trước các danh sách
	if($('#tblDsTvd tbody tr').length==1){
		themThanhVienDoan();
	} 
	if($('#tblBaoCao tbody tr').length==1){
		themBaoCao(); 
	}
	if($('#tblHsTl tbody tr').length==1){
		themHoSoTl();
	}
	if($('#tb_DS_TPTD tbody tr').length==1){
		themThanhPhanThamDu();
	}
});
var formObj = new DHTMLSuite.form({ formRef:'ChuanBiTienHanhForm',action:'chuan_bi_tien_hanh.do',responseEl:'getReturn'}); 
function getTabIndexInCookKie(){ 
	return "chuanBiTienHanh";  
} 
function setActiveTab(tabIndex){  
	//alert(tabIndex); 
	activeTab = tabIndex;   
}   
function findForm(formAction){ 
	//alert("tim form :"+formAction);
	for(i = 0; i< document.forms.length; i++){
		//alert(i+ " :"+ document.forms[i].action);
		if(document.forms[i].action == formAction || document.forms[i].action.indexOf(formAction) >=0)
			return document.forms[i];
	}
	return null;
} 
var url;   
var submitString = "";
var contextRoot = document.forms[0].action.split('/')[1];
function saveActiveTab(){
	var saveResultDivName;
	if(activeTab == 0){
		saveResultDivName = "getReturnBcks";
		if(!validateBaoCaoKhaoSat())       
			return; 
		url = 'chuan_bi_tien_hanh.do?method=save&type=bcks';  
	}else if(activeTab == 1){ 
		if(!validateThanhVienDoan())     
			return; 
		url = 'chuan_bi_tien_hanh.do?method=save&type=tvd';
	}else if(activeTab == 2){   
		if(!isEmpty(document.getElementsByName('soQuyetDinh')[0].value)){
			var r=confirm("Sau khi lưu quyết định, các thông tin trước sẽ không được sửa!")
			if (r==false)
				return;		      
		}
		if(!validateQuyetDinh())               
			return;     
		url = 'chuan_bi_tien_hanh.do?method=save&type=qd';	  
	}else if(activeTab == 3){ 
		saveResultDivName = "getReturnKh";		
		if(!validateKeHoach())     
			return;       
		url = 'chuan_bi_tien_hanh.do?method=save&type=kh';  
	}else if(activeTab == 4){  
		saveResultDivName = "getReturnDc";		
		if(!validateDeCuong())                
			return;  
		url = 'chuan_bi_tien_hanh.do?method=save&type=dc';   
	}else if(activeTab == 5){         
		if(!validateHopDoanTrienKhai())                              
			return;  
		if(checkRequired())
		return;    
		url = 'chuan_bi_tien_hanh.do?method=save&type=hdtk';            
	}else throw "Err1";      
	if(contextRoot.length > 0){
		url = '/' + contextRoot + '/' + url; 
	}
	if(url.indexOf('type=dc') >=0  || url.indexOf('type=bcks') >=0 || url.indexOf('type=kh') >=0){    
		urlWithAllParam = url + '&' + getThongTinChung();	
		smbForm = findForm(url);    
		if(smbForm == null)        
			smbForm = findForm(urlWithAllParam);					
		if(url.indexOf('type=dc') >=0 || url.indexOf('type=kh') >=0){
			xmlhttpPost(urlWithAllParam); 	
		}
		else{
			formObj = new DHTMLSuite.form({ formRef:smbForm,action:urlWithAllParam, responseEl:saveResultDivName});		
			formObj.submit();
		}
	}else
	xmlhttpPost(url);               
}       
function xuLySaveThanhCongCuaTungForm(){	
	if(activeTab == 0 ||activeTab == 1 || activeTab == 2 || activeTab == 3 || activeTab == 4){     
		window.location.reload();
	}else if(activeTab == 5){
		if(window.confirm('Bạn đã nhập xong dữ liệu cho bước Chuẩn bị tiến hành! Bạn có muốn nhập tiếp thông tin cho bước Tiến hành không?'))
			window.location = 'tien_hanh_ttkt.do?cuocTtktId=' + document.getElementsByName('idCuocTtkt')[0].value;
	}	   
} 
function xuLySaveKhongThanhCongCuaTungForm(maLoi){
	switch (maLoi){
		case "1":
			alert('Chưa nhập báo cáo khảo sát!');
			break;
		case "2":
			alert('Chưa chỉ định hoặc chưa nhập thông tin phê duyệt danh sách thành viên!');
			break;
		case "3":
			alert('Chưa có quyết định!');
			break; 
		case "4":
			alert('Chưa lập kế hoạch hoặc chưa nhập thông tin phê duyệt kế hoạch!');
			break; 
		case "5":
			alert('Chưa lập đề cương!');
			break; 
		default:
			break;
	}	
}
function readOnlyTabBCKS(){
	try{
		document.getElementsByName('fileBCKS')[0].disabled = true;
	}catch(err){
	}	
}
function readOnlyTabChiDinhThanhVienDoan(){
	$("div#tabTVDoan .text").attr("readOnly", true); 
	$("div#tabTVDoan .textareaTitle").attr("readOnly", true); 
	$("div#tabTVDoan .button").attr("disabled", true);   
	$("div#tabTVDoan .lovButton").attr("disabled", true);
	$("div#tabTVDoan .checkbox").attr("disabled", true); 
	$("div#tabTVDoan .combobox").attr("disabled", true); 
	//$("div#tabTVDoan .textarea").attr("disabled", true); 
	//$("div#tabTVDoan .textarea").attr("disabled", true); 	
}
function readOnlyTabQuyetDinh(){ 
	$("div#tabQuyetDinh .text").attr("readOnly", true); 
	//$("div#tabQuyetDinh .button").attr("disabled", true); 
	$("div#tabQuyetDinh .lovButton").attr("disabled", true);
	$("div#tabQuyetDinh .checkbox").attr("disabled", true); 
	$("div#tabQuyetDinh .combobox").attr("disabled", true); 
	$("div#tabQuyetDinh .textareaTitle").attr("readOnly", true); 
 	           
}
function readOnlyAllPreFieldOfQd(){                   
	readOnlyTabBCKS();
	readOnlyTabChiDinhThanhVienDoan();
	readOnlyTabQuyetDinh();
}   
var formObj;
function getThongTinChung(){ 
	thongTinChung = "";  
	//thongTinChungForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do');  
	//thongTinChungForm = findForm('/ktnb/chuan_bi_tien_hanh.do');  
	thongTinChungForm = document.getElementById('cbthForm');
	for(i = 0; i< thongTinChungForm.elements.length; i++)
		if(thongTinChungForm.elements[i].name != null && thongTinChungForm.elements[i].name != '' && thongTinChungForm.elements[i].value != null && thongTinChungForm.elements[i].value != '')
			thongTinChung += thongTinChungForm.elements[i].name + "=" + encodeURIComponent(thongTinChungForm.elements[i].value) + "&"; 
	thongTinChung = thongTinChung.substring(0, thongTinChung.length - 1); 
	return thongTinChung; 
}     
function createSubmitString(){      
	reVal = "";      
	activeForm = findForm(url);     
	if(url.indexOf('type=bcks') < 0){ 
		if(url.indexOf('type=dc') >= 0){
			//var temptext = '';
			for(i = 0; i< activeForm.elements.length; i++){
				//temptext+=activeForm.elements[i].name+':'+activeForm.elements[i].value+'\n';
				if(activeForm.elements[i].name != null 
				&& activeForm.elements[i].name != '' 
				&& activeForm.elements[i].name != 'fileDinhKemDeCuong'
				//&& activeForm.elements[i].name.indexOf("dsHoSoTl") <= -1 				
				&& activeForm.elements[i].value != null 
				&& activeForm.elements[i].value != '')
					reVal += activeForm.elements[i].name + "=" + encodeURIComponent(activeForm.elements[i].value) + "&";
			}
			//alert(temptext);
		}else{
			for(i = 0; i< activeForm.elements.length; i++){
				if(activeForm.elements[i].name != null 
				&& activeForm.elements[i].name != '' 
				&& activeForm.elements[i].value != null 
				&& activeForm.elements[i].value != '')
					reVal += activeForm.elements[i].name + "=" + encodeURIComponent(activeForm.elements[i].value) + "&";
			}
		}
	} 
	// collect thong tin chung.
	if(getThongTinChung() != null && getThongTinChung() != '')
		reVal = getThongTinChung()+'&'+reVal;
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
 

function xemLichTrinhDuKien(){
	openWindow('lich_trinh_du_kien_ttkt.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value, '500','250','menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no');
}
var lovType;
function setThongTinNhanVienFromLov(maCanBo, tenCanBo, chucVu, tenPhong, tenCqt){ 
	if(lovType == 'tvd'){
		if(exist(maCanBo)){ 
			idCanBoConTrol.value = "";
			tenCanBoConTrol.value = ""; 			    
			if(tenCanBoConTrol.name.indexOf('chiTietDsTvd') >=0)
				return;
		} 
		idCanBoConTrol.value = maCanBo;
		tenCanBoConTrol.value = tenCanBo; 
		if(!isEmpty(tenPhong)){ 
			donViCongTacControl.value = tenPhong;
			if(!isEmpty(tenCqt)){  
				donViCongTacControl.value += ', ' + tenCqt;
			}
		}else if(isEmpty(tenCqt)){
			donViCongTacControl.value += tenCqt;   
		}			
		if(chucVu != null && chucVu != '') 
			chucVuConTrol.value = chucVu;	
	}else if('chonNguoiChiDaoDamSat' == lovType){
		idCanBoConTrol.value = maCanBo;
		// Ten 
		tenCanBoConTrol.value = tenCanBo;		
		// Chuc vu
		chucVuConTrol.value = chucVu;
	}          
}	

function validateDateRequired(dateElement){
	if(dateElement.value==""||dateElement.value==null)
	return;
	var ngayLapDsTvd = $('[name="ngayLapDsTvd"]')[0].value;
	switch(dateElement.name){
		case "ngayRaQuyetDnh":
			if(d2n(dateElement.value)<d2n(ngayLapDsTvd)){
				alert("Ngày ra quyết định phải sau ngày lập tờ trình");
				$(dateElement).focus().select();
			}
			break;
		case "thoiDiemBatDau":
			if($('[name="ngayRaQuyetDnh"]')[0].value!=""&& d2n(dateElement.value.split(" ")[1])<d2n($('[name="ngayRaQuyetDnh"]')[0].value)){
				alert("Ngày họp phải sau ngày ra quyết định");
				$(dateElement).focus().select();
			}
			break; 
		case "thoiDiemKetThuc":
			if($('[name="ngayRaQuyetDnh"]')[0].value!=""&& d2n(dateElement.value.split(" ")[1])<d2n($('[name="ngayRaQuyetDnh"]')[0].value)){
				alert("Ngày kết thúc họp đoàn phải sau ngày ra quyết định");
				$(dateElement).focus().select();
			}
			break;
			
	}
}  
</script>
<logic:present name="da_co_lich_trinh_du_kien">
	<script language="javascript"> 		
		$("#da_co_lich_trinh_du_kien").css("display","inline"); 
		$("#chua_co_lich_trinh_du_kien").css("display","none"); 
		readOnlyAllPreFieldOfQd();
	</script>
</logic:present>
<logic:notPresent name="da_co_lich_trinh_du_kien">
	<script language="javascript"> 
		$("#da_co_lich_trinh_du_kien").css("display","none"); 
		$("#chua_co_lich_trinh_du_kien").css("display","inline");		
	</script>
</logic:notPresent>

