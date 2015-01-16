<%@ include file="/top_bar.jsp"%>      
<h3 class="Header">Ni&#234;m phong h&#7891; s&#417; t&#224;i li&#7879;u</h3>
<script type="text/javascript" src="<html:rewrite page='/include/js/ttkt/ttkt.js'/>"></script>
<%@page import="cmc.com.ktnb.util.Constants"%>     
<%@page import="cmc.com.ktnb.util.ApplicationContext"%>             
<div id="tab">
<ul>
	<li><a href="#tabQuyetDinhNiemPhong"><b>Quy&#7871;t &#273;&#7883;nh ni&#234;m phong</b></a></li>
	<li><a href="#tabBienBanNiemPhong"><b>Bi&#234;n b&#7843;n ni&#234;m phong</b></a></li>
	<li><a href="#tabQuyetDinhMoNiemPhong"><b>Quy&#7871;t &#273;&#7883;nh m&#7903; ni&#234;m phong</b></a></li>
	<li><a href="#tabBienBanNoNiemPhong"><b>Bi&#234;n b&#7843;n m&#7903; ni&#234;m phong</b></a></li>
</ul>
<DIV id="tabQuyetDinhNiemPhong">
<fieldset><%@ include file="/ttkt/tien_hanh_ttkt/quyet_dinh_niem_phong.jsp"%></fieldset>
</DIV>
<DIV id="tabBienBanNiemPhong">
<fieldset><%@ include file="/ttkt/tien_hanh_ttkt/bien_ban_niem_phong.jsp"%></fieldset>
</DIV>
<DIV id="tabQuyetDinhMoNiemPhong">
<fieldset><%@ include file="/ttkt/tien_hanh_ttkt/quyet_dinh_mo_niem_phong.jsp"%></fieldset>
</DIV>
<DIV id="tabBienBanNoNiemPhong">
<fieldset><%@ include file="/ttkt/tien_hanh_ttkt/bien_ban_mo_niem_phong.jsp"%></fieldset>
</DIV>
</div>
<br />
<fieldset style="width: 100%; margin: 0">
<TABLE align="center">
	<tr>
		<td width="100%" align="center"><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></td>
	</tr>
</TABLE>
</fieldset>
<html:form action="niem_phong_ho_so_tai_lieu.do" method="POST">
	<html:hidden property="idCuocTtkt" />
	<html:hidden property="idCqtBi" />
	<html:hidden property="optionTag" />  
</html:form>
<%@ include file="/bottom.jsp"%>
<script language="javascript">   
var contextRoot = document.forms[0].action.split('/')[1];            
var activeTab;
var numOfTab = 4;
var url;   
var ngayraQDNP;
function saveActiveTab(){
	if(activeTab==0){
		if(!validateQdNp()) 
			return;    
		url = 'niem_phong_ho_so_tai_lieu.do?method=save&type=qdNiemPhong';
	}else if(activeTab==1){
		if(!validateBbNp())
			return;
		url = 'niem_phong_ho_so_tai_lieu.do?method=save&type=bbNiemPhong'; 
	}else if(activeTab==2){  
		if(!validateQdMoNp()) 
			return;
		url = 'niem_phong_ho_so_tai_lieu.do?method=save&type=qdMoNiemPhong';
	}
	else if(activeTab==3){
		if(!validateBbMoNp())
			return;
		url = 'niem_phong_ho_so_tai_lieu.do?method=save&type=bbMoNiemPhong';
	}else throw "Err1";  
	url = '/' + contextRoot + '/' + url;
	xmlhttpPost(url);
} 
function findForm(formAction){ 
	for(i = 0; i< document.forms.length; i++){
		if(document.forms[i].action == formAction)
			return document.forms[i];
	}
	return null;
} 
function createSubmitString(){ 
	reVal = "";       
	activeForm = findForm(url); 
	for(i = 0; i< activeForm.elements.length; i++)
		if(activeForm.elements[i].name != null && activeForm.elements[i].name != '' && activeForm.elements[i].value != null && activeForm.elements[i].value != '')
			reVal += activeForm.elements[i].name + "=" + encodeURIComponent(activeForm.elements[i].value) + "&";
	if(url.indexOf('type=qdNiemPhong') >=0){
		reVal += 'idCuocTtkt='+ encodeURIComponent(document.getElementsByName('idCuocTtkt')[0].value);     
	}else 
		reVal += 'idQdNiemPhong='+ encodeURIComponent(document.getElementsByName('idQdNiemPhong')[0].value);
	return reVal;               
	    
}
function xuLySaveThanhCongCuaTungForm(returnValue){
	if(window.opener.location.href.indexOf('danh_sach_tim_kiem')>=0)
		window.opener.location.reload();
	if(activeTab == 0){
		document.getElementsByName('idQdNiemPhong')[0].value = returnValue;
	}else if(activeTab == 1){
		document.getElementsByName('idBbNiemPhong')[0].value = returnValue;
	}else if(activeTab == 2){
		document.getElementsByName('nguoiMoNp')[0].value = returnValue;
	}else if(activeTab == 3){
		window.close();           
	}
	
}
function xuLySaveKhongThanhCongCuaTungForm(maLoi){
	alert('Ch\u01B0a l\u01B0u quy\u1EBFt \u0111\u1ECBnh m\u1EDF ni\u00EAm phong!');
}

window.onload = function(){
	if(activeTab == null)
		activeTab = 0;
	onLoadQdNiemPhong();  
	onLoadQdMoNiemPhong(); 
	onLoadBbNiemPhong();     
	onLoadBbMoNiemPhong();  
	//them dong trang truoc cac danh sach
	if($('#bbNP1 tbody tr').length==0){
		AddRowBBNP1();
	}
	if($('#bbNP2 tbody tr').length==0){
		AddRowBBNP2();
	}
	if($('#bbMoNP1 tbody tr').length==1){
		AddRowBBMoNP1();
	}
	if($('#bbMoNP2 tbody tr').length==1){
		AddRowBBMoNP2();
	}
	             
}                             
              
$(function(){     
  var tab_select=jQuery.fn.readCookie(getTabIndexInCookKie());    
  if(tab_select==null)
  	tab_select = 0;
  setActiveTab(tab_select); 
  var tabOpts={selected:tab_select,select:function(event,tab){jQuery.fn.createCookie(getTabIndexInCookKie(), tab.index); setActiveTab(tab.index)}};                
  $("#tab").tabs(tabOpts);
});
		
function setActiveTab(tabIndex){   
	activeTab = tabIndex;   
}
function getTabIndexInCookKie(){
	return "ttkt/th/nphstl";
}   		  

function setThongTinNhanVienFromLov(ma, ten, chucVu, tenPhong, tenCqt){
	hiddenIdCanBo.value = ma;
	txtTenCanBo.value = ten;
	txtChucVu.value =  chucVu;
	
}

function selfClose(){		
	window.close();     
}
</script>
<%if(request.getAttribute("save") != null){%>
<script language="javascript">
		alert('L\u01B0u th\u00E0nh c\u00F4ng!');
		window.location ='danh_sach_tim_kiem.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value +'&type=niemPhongHSTL';         
	</script>
<%}%>
