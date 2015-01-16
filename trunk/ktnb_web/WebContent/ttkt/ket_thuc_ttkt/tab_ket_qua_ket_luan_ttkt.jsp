<%@ page pageEncoding="UTF-8"%> 
<%@page import="cmc.com.ktnb.util.Constants"%>
<%@page import="cmc.com.ktnb.util.ApplicationContext"%>     
<script language="javascript">              
	var tenCqt = "<%=((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getTenCqt()%>";                            
</script>
<DIV id="level2Tab">  
<ul>
	<li><a href="#tabDuThaoKetQua"><b>Dự thảo báo cáo kết quả</b></a></li>       
	<li><a href="#tabBaoCaoKetQua"><b>Báo cáo kết quả</b></a></li>
	<li><a href="#tabDuThaoKetLuan"><b>Dự thảo kết luận</b></a></li>              
	<li><a href="#tabKetLuan"><b>Kết luận</b></a></li>    
	<li><a href="#tabChuyenKetluanSangBaoCao"><b>Nhập dữ liệu trên kết luận</b></a></li>          
</ul>
</DIV>                
<DIV id="tabDuThaoKetQua">          
<fieldset style="width: 100%"><%@ include file="/ttkt/ket_thuc_ttkt/du_thao_ket_qua.jsp"%></fieldset>
</DIV>      
<DIV id="tabBaoCaoKetQua">
<fieldset style="width: 100%"><%@ include file="/ttkt/ket_thuc_ttkt/ket_qua_ttkt.jsp"%></fieldset>
</DIV>
<DIV id="tabDuThaoKetLuan">
<fieldset style="width: 100%"><%@ include file="/ttkt/ket_thuc_ttkt/du_thao_ket_luan.jsp"%></fieldset>
</DIV>      
<DIV id="tabKetLuan">
<fieldset style="width: 100%"><%@ include file="/ttkt/ket_thuc_ttkt/ket_luan_ttkt.jsp"%></fieldset>
</DIV>
<DIV id="tabChuyenKetluanSangBaoCao">   
<div style="width: 100%"><%@ include file="/ttkt/ket_thuc_ttkt/ket_luan_chuyen_bao_cao.jsp"%></div>
</DIV>     
<script language="javascript">    
function onLoadKetLuanKetQua(){
	onLoadDuThaoKetQua();
	onLoadKetQua();
	onLoadDuThaoKetLuan();
	onLoadKetLuan();
}
</script>
