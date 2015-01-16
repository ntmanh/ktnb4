<%@page pageEncoding="UTF-8" %>                     
<%@ include file="/top_bar.jsp"%>       
<h3 class="Header">Yêu cầu giải trình</h3>
<script language="javascript">   
	function selfClose(){              
		var currentTab = jQuery.fn.readCookie("TABYCGT");    
		if(currentTab=="1")
		{
			window.close(); 
		}else{
			var tabOpts={selected:"1",select:function(event,tab){jQuery.fn.createCookie("TABYCGT",tab.index);}}; 
	  		$("#tab").tabs(tabOpts); 
		}
		
	}
	function xuLySauSaveThanhCong(){
		try{
			var currentTab = jQuery.fn.readCookie("TABYCGT");    
			if(currentTab=="1"){
			window.opener.location.reload();// Reload form tim kiem (Neu mo truc tiep thi reload form main)
			}
		}catch(err){
		}
	}
</script>
<html:form action="yeu_cau_giai_trinh.do" method="POST" enctype="multipart/form-data">
	<html:hidden property="id" />
	<html:hidden property="idCuocTtKt" />
	<div id="tab">      
	<ul>
		<li><a href="#tabPhieuYeuCauGiaiTrinh"><b>Phiếu yêu cầu giải trình</b></a></li>
		<li><a href="#tabBaoCaoGiaiTrinh"><b>Báo cáo giải trình</b></a></li>
	</ul>      
	<DIV id="tabPhieuYeuCauGiaiTrinh">
	<fieldset><%@ include file="/ttkt/tien_hanh_ttkt/phieu_yeu_cau_giai_trinh.jsp"%></fieldset>
	</DIV>   
	<DIV id="tabBaoCaoGiaiTrinh">
	<fieldset><%@ include file="/ttkt/tien_hanh_ttkt/bao_cao_giai_trinh.jsp"%></fieldset>
	</DIV>
	</div>
</html:form>
<fieldset style="margin: 0"><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></fieldset>
<%@ include file="/bottom.jsp"%>
<script language="javascript">                   

	window.onload = function(){
		dsIdThanhVienDoan = '<%=request.getAttribute("dsIdThanhVienDoan")%>'
		dsIdThanhVienDoan = dsIdThanhVienDoan.split(',');
		dsChucVuTrongDoan = '<%=request.getAttribute("dsChucVuTrongDoan")%>'
		dsChucVuTrongDoan = dsChucVuTrongDoan.split(','); 
		  
}                      
	$(function()
	{ 
	  var tab_select=jQuery.fn.readCookie("TABYCGT");
	  if(tab_select==null)
  		tab_select = 0;
	  var tabOpts={selected:tab_select,select:function(event,tab){jQuery.fn.createCookie("TABYCGT",tab.index);}}; 
	  $("#tab").tabs(tabOpts); 
	});   
		   
	function changeActiveTab(tabIndex){
		var tabOpts={selected:tabIndex,select:function(event,tab){jQuery.fn.createCookie("TABYCGT",tab.index);}}; 
	  	$("#tab").tabs(tabOpts); 
	}	  		  
	function validatePhieuYC(){
		if(isEmpty(document.getElementsByName('ngaylapPhieu')[0].value))
			changeActiveTab(0);
		else if(isEmpty(document.getElementsByName('noiLapPhieu')[0].value))
			changeActiveTab(0);
		else if(isEmpty(document.getElementsByName('tenNguoiGT')[0].value))
			changeActiveTab(0);
		else if(isEmpty(document.getElementsByName('cvNguoiLapPhieu')[0].value))
			changeActiveTab(0);
		else if(isEmpty(document.getElementsByName('dvNguoiGT')[0].value))
			changeActiveTab(0);
		else if(isEmpty(document.getElementsByName('hoSoTaiLieuBC')[0].value))
			changeActiveTab(0);
		
		
		else if(isEmpty(document.getElementsByName('ndungGT')[0].value))
			changeActiveTab(0);
		else if(isEmpty(document.getElementsByName('ngayGuiGT')[0].value))
			changeActiveTab(0);
		else if(isEmpty(document.getElementsByName('noiGuiGT')[0].value))
			changeActiveTab(0);
			
			
		if(!isRequired(document.getElementsByName('ngaylapPhieu')[0]))
			return false;
		if(!isRequired(document.getElementsByName('noiLapPhieu')[0]))
			return false;
			
			
		if(!isRequired(document.getElementsByName('tenNguoiGT')[0]))
			return false;
		if(!isRequired(document.getElementsByName('cvNguoiLapPhieu')[0]))
			return false;
		if(!isRequired(document.getElementsByName('dvNguoiGT')[0]))
			return false;
			
		if(!isRequired(document.getElementsByName('hoSoTaiLieuBC')[0]))
			return false;
				
			
			
			
		if(!isRequired(document.getElementsByName('ndungGT')[0]))
			return false;
		if(!isRequired(document.getElementsByName('ngayGuiGT')[0]))
			return false;
		if(!isRequired(document.getElementsByName('noiGuiGT')[0]))
			return false;
		if(!compareDateAndTime(document.getElementsByName('ngaylapPhieu')[0], document.getElementsByName('ngayGuiGT')[0], '>', 'Thời điểm lập phiếu phải trước gửi giải trình!'))
		return false;
		return true;
	}	 			  
	function validateBC(){
		if(isEmpty(document.getElementsByName('tgBCGT')[0].value))
			changeActiveTab(1);
		else if(isEmpty(document.getElementsByName('diadiemBCGT')[0].value))
			changeActiveTab(1);
		if(!isRequired(document.getElementsByName('tgBCGT')[0]))
			return false;
		if(!isRequired(document.getElementsByName('diadiemBCGT')[0]))
			return false;
		return true;
	}	 			
	function validateForm(){            
		if(!validatePhieuYC()){
			return false;
			
		}else if(!validateBC()){
			return false;
		}
			
		return true;
		
	}
	function saveActiveTab(){ 		  
		var currentTab = jQuery.fn.readCookie("TABYCGT");    
		switch(currentTab){
		case "0":
			if(!validatePhieuYC())
	 		return false;
	 		break;
	 	case "1":
	 		if(!validatePhieuYC())
	 		return false;
	 		if(!validateBC())
	 		return false;
	 		break;
		}          
		action = document.forms[0].action;
 		action = action.split('?')[0]; 
 		document.forms[0].action += "?method=save";
 		document.forms[0].submit();	      
	}
	function validateDateRequired(dateElement){
		var ngayRaQuyetDnh = '<%=request.getAttribute("ngayRaQuyetDnh")%>';
		if(ngayRaQuyetDnh!=null&&ngayRaQuyetDnh!=""){
			if(dateElement.value!=""){
			switch(dateElement.name){
			case "ngaylapPhieu":
				if(d2n(ngayRaQuyetDnh)>=d2n(dateElement.value)){  
					alert("Ngày lập phiếu phải sau ngày ra quyết định (" + ngayRaQuyetDnh + ")!");
					$(dateElement).focus().select();			
				}
				break;
			default:
				if(d2n(ngayRaQuyetDnh)>=d2n(dateElement.value.split(" ")[1])){
					alert("thời gian phải sau ngày ra quyết định (" + ngayRaQuyetDnh + ")!");
					$(dateElement).focus().select();			
				}
				break;
			}
		}
	}
	}
	function downloadBienBanChiTiet1(bbchiTietId){
		downLoadWinDow = window.open('UploadAction.do?method=downLoadYeuCauGiaiTrinh&ma_file='+bbchiTietId);
		downLoadWinDow.focus();
	}
	//window.onbeforeunload = function(){
	//	$('[name="ngaylapPhieu"]')[0].value="";
	//	$('[name="ngayGuiGT"]')[0].value="";
	//	$('[name="tgBCGT"]')[0].value="";
	//}
	                        
</script>
<%if(request.getAttribute("save") != null){%>
<script language="javascript">
		alert('Lưu thành công!');
		window.location = 'danh_sach_tim_kiem.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value +'&type=yeuCauGiaiTrinh';
	</script>
<%}%>