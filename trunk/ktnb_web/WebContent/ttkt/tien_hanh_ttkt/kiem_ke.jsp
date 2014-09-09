<%@page pageEncoding="UTF-8" %>
<%@ include file="/top_bar.jsp"%>
<script type="text/javascript" src="<html:rewrite page='/include/js/ttkt/ttkt.js'/>"></script>
<%@page import="cmc.com.ktnb.util.Constants"%>
<%@page import="cmc.com.ktnb.util.ApplicationContext"%>
<script language="javascript">

	       
	function xuLySauSaveThanhCong(){
		if(window.opener.location.href.indexOf('danh_sach_tim_kiem.do') > 0){
			window.opener.location.reload();	
		}else{
			window.close();  
		}
	}
	                                              
</script>
<h3 class="Header">Kiểm kê tài sản</h3>
<div id="tab">
<ul>
	<li><a href="#tabQuyetDinh"><b>Quyết định kiểm kê</b></a></li>
	<li><a href="#tabBienBan"><b>Biên bản kiểm kê</b></a></li>
</ul>
<DIV id="tabQuyetDinh">
<fieldset><%@ include file="/ttkt/tien_hanh_ttkt/quyet_dinh_kk.jsp"%></fieldset>
</DIV>
<DIV id="tabBienBan">
<fieldset><%@ include file="/ttkt/tien_hanh_ttkt/bien_ban_kk.jsp"%></fieldset>
</DIV>
</div>
<fieldset style="width: 100%; margin: 0">
<TABLE align="center">
	<tr>
		<td width="100%" align="center"><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></td>
	</tr>
</TABLE>
</fieldset>
<html:form action="kiem_ke.do" method="POST">
	<html:hidden property="idCuocTtkt" />
	<html:hidden property="idDaiDienDoanTTKT" />
	<html:hidden property="idDaiDienDVCOTSTKK" />
</html:form>
<%@ include file="/bottom.jsp"%>
<script language="javascript"> 
var contextRoot = document.forms[0].action.split('/')[1];      
var activeTab;
var numOfTab = 2;
var url;
        
function saveActiveTab(){
	if(activeTab==0){
		if(!validateQuyetdinh()) 
			return;    
		url = 'kiem_ke.do?method=save&type=qdkk';       
	}else if(activeTab==1){
		if(!validateBienBan())
			return;
		url = 'kiem_ke.do?method=save&type=bbkk'; 
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
	if(url.indexOf('type=qdkk') >=0){
		reVal += 'idCuocTtkt='+ encodeURIComponent(document.getElementsByName('idCuocTtkt')[0].value);     
	}else 
		reVal += 'idQdKk='+ encodeURIComponent(document.getElementsByName('idQdKk')[0].value);
	return reVal;               	    
}

function xuLySaveThanhCongCuaTungForm(returnValue){
	if(window.opener.location.href.indexOf('danh_sach_tim_kiem')>=0)
		window.opener.location.reload();
	if(activeTab == 0){
		document.getElementsByName('idQdKk')[0].value = returnValue;
	}else if(activeTab == 1){
		window.close();           
	}
	
}

function xuLySaveKhongThanhCongCuaTungForm(maLoi){
	alert('Chưa lưu quyết định kiểm kê!');
}
           
window. ad = function(){
	if(activeTab == null)
		activeTab = 0;  
}                             
$(function(){     
  var tab_select=jQuery.fn.readCookie(getTabIndexInCookKie());  
  if(tab_select==null)
  	tab_select = 0;  
  setActiveTab(tab_select); 
  var tabOpts={selected:tab_select,select:function(event,tab){jQuery.fn.createCookie(getTabIndexInCookKie(), tab.index); setActiveTab(tab.index)}};                
  $("#tab").tabs(tabOpts);
  //thêm dòng trống trước các danh sách
	if($('#doanTTKT tbody tr').length==0){
		AddRowTable1();
	}
	if($('#dvDuocTTKT tbody tr').length==0){
		AddRowTable2();
	}
});
		
function setActiveTab(tabIndex){   
	activeTab = tabIndex;   
}
function getTabIndexInCookKie(){
	return "TABI";
}   		  
           
     
function changeActiveTab(tabIndex){
		var tabOpts={selected:tabIndex,select:function(event,tab){jQuery.fn.createCookie("TABI",tab.index);}}; 
	  	$("#tab").tabs(tabOpts); 
}
	
function validateQuyetdinh(){
		if(!isRequired(document.getElementsByName('noiRaQd')[0]))
			return false;
		if(!isRequired(document.getElementsByName('ngayRaQd')[0]))
			return false;
		if(!isRequired(document.getElementsByName('thoiGianKk')[0]))
			return false;
		if(!isRequired(document.getElementsByName('taiSanCanKiemKe')[0]))
			return false;
		if(!isRequired(document.getElementsByName('donViDangBaoQuan')[0]))
			return false;
		if(!isRequired(document.getElementsByName('diaDiemCoTsKk')[0]))
			return false;
		if(!isRequired(document.getElementsByName('donViCaNhanDuocKk')[0]))
			return false;
		if(!isRequired(document.getElementsByName('donViCaNhanBaoQuan')[0]))
			return false;	
		if(!compareDateAndTime(document.getElementsByName('ngayRaQd')[0], document.getElementsByName('thoiGianKk')[0], '>=', 'Ng\u00E0y ra quy\u1EBFt \u0111\u1ECBnh ki\u1EC3m k\u00EA ph\u1EA3i tr\u01B0\u1EDBc th\u1EDDi \u0111i\u1EC3m ki\u1EC3m k\u00EA!'))
			return false;	
		return true;	
	}
	
	
function validateForm(){
	if(!validateQuyetdinh())
		return false;
	if(!validateBienBan())
		return false;
	
	return true;
}
function selfClose(){
		window.close();        
}
		                                 
</script>
<%if(request.getAttribute("save") != null){%>
<script language="javascript">
		alert('L\u01B0u th\u00E0nh c\u00F4ng');
		window.location  = 'danh_sach_tim_kiem.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value +'&type=kkTS';
	</script>
<%}%>