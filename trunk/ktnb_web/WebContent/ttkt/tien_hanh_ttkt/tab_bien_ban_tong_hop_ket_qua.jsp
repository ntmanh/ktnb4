<%@page import="cmc.com.ktnb.util.Constants"%>   
<%@page import="cmc.com.ktnb.util.ApplicationContext"%>                
<script language="javascript">              
	var tenCqt = "<%=((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getTenCqt()%>";
</script>
<DIV id="tabDuThaoBienbanTongHop">   
<fieldset style="width: 100%"><%@ include file="/ttkt/tien_hanh_ttkt/du_thao_bien_ban_tong_hop_ket_qua.jsp"%></fieldset>
</DIV>
<DIV id="tabBienbanTongHopKetQuaGuiChoDvDuocTtkt">
<fieldset style="width: 100%"><%@ include file="/ttkt/tien_hanh_ttkt/bien_ban_tong_hop_ket_qua_ttkt_gui_cho_don_vi_duoc_ttkt.jsp"%></fieldset>
</DIV>
<DIV id="tabBienbanTongHop">
<fieldset style="width: 100%"><%@ include file="/ttkt/tien_hanh_ttkt/bien_ban_tong_hop_ket_qua.jsp"%></fieldset>
</DIV>
<script language="javascript"> 
</script>
