<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">L&#7853;p th&#244;ng b&#225;o k&#7871;t qu&#7843; gi&#7843;i quy&#7871;t t&#7889; c&#225;o - M&#7851;u 26/KNTC</h3>
<html:form action="/tb_kqgq_tc.do?method=show">
	<html:hidden property="ma" />
	<html:hidden property="maHoSo" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red"> S&#7889; h&#7891; s&#417;</font> <a href='kntc_tiep_dan.do?method=view&id=<bean:write property="maHoSo" name="thongBaoKQGQToCaoForm" />' target="#"><html:text property="maHoSo" style="width:250px"
		readonly="true" /></a></div>
	<fieldset><legend>Th&#244;ng tin th&#244;ng b&#225;o</legend>
	<TABLE width="100%">
		<TBODY>
			<tr>
				<td width="15%" style="text-align: right;">N&#417;i l&#7853;p th&#244;ng b&#225;o</td>
				<td width="35%"><html:text property="diaDiem" style="width:100%" /></td>
				<td width="15%" style="text-align: right;">Ng&#224;y l&#7853;p th&#244;ng b&#225;o</td>
				<td width="35%"><html:text property="thoiDiem" style="width:100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">S&#7889; th&#244;ng b&#225;o</td>
				<td><html:text property="soThongBao" style="width:100%" /></td>
				<td style="text-align: right;">Ng&#432;&#7901;i b&#7883; t&#7889; c&#225;o</td>
				<td><html:text property="nguoiBiToCao" style="width:100%" readonly="true" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Ng&#432;&#7901;i t&#7889; c&#225;o</td>
				<td><html:text property="nguoiToCao" style="width:100%" readonly="true" /></td>
				<td style="text-align: right;">Ch&#7913;c v&#7909; ng&#432;&#7901;i b&#7883; t&#7889; c&#225;o</td>
				<td><html:text property="chucVuNguoiBiToCao" style="width:100%" readonly="true" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">T&#243;m t&#7855;t n&#7897;i dung t&#7889; c&#225;o</td>
				<td colspan="3"><html:textarea property="noiDungToCao" style="width:100%;height: 80px;" readonly="true" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">K&#7871;t qu&#7843; gi&#7843;i quy&#7871;t t&#7889; c&#225;o</td>
				<td colspan="3"><html:textarea property="ketQuaGiaiQuyet" onkeypress="imposeMaxLength(this);" style="width:100%;height: 80px;" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">C&#417; quan t&#7893; ch&#7913;c li&#234;n quan</td>
				<td colspan="3"><html:textarea property="benLienQuan" onkeypress="imposeMaxLength(this);" style="width:100%;height: 80px;" /></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
	<jsp:include page="../../thong_tin_ky_duyet.jsp" />
	<jsp:include page="../../../button_bar_kntc.jsp" />
</html:form>
<script language="JavaScript">
	 $(function(){
	 var ghiTC = "";
	 <logic:present name="ghiThanhcong">
	     	ghiTC = '<%=request.getAttribute("ghiThanhcong")%>';
	 </logic:present>
	 if(ghiTC=='1')
	   alert('L\u01B0u th\u00E0nh c\u00F4ng!'); 
	 else  if(ghiTC=='0')
	   alert('L\u1ED7i khi ghi d\u1EEF li\u1EC7u!!!');
	 });
	
	function ghi(){
		//if(validForm()) {
			document.forms[0].action="tb_kqgq_tc.do?method=save";
			document.forms[0].submit();		
		//}
	}
	function print(){
	    document.forms[0].action="tb_kqgq_tc.do?method=in";
		document.forms[0].submit();
	}
	function validForm() {
		if(!isRequired(documemt.forms[0].diaDiem,'Ch\u01B0a nh\u1EADp \u0111\u1ECBa \u0111i\u1EC3m l\u1EADp phi\u1EBFu')) return false;
		if(!isRequired(documemt.forms[0].ngayLap,'Ch\u01B0a nh\u1EADp ng\u00E0y l\u1EADp phi\u1EBFu')) return false;
		if(!isRequired(documemt.forms[0].donViYcgt,'Ch\u01B0a nh\u1EADp \u0111\u01A1n v\u1ECB t\u1ED5 ch\u1EE9c c\u00E1 nh\u00E2n \u0111\u01B0\u1EE3c y\u00EAu c\u1EA7u gi\u1EA3i tr\u00ECnh')) return false;
		if(!isRequired(documemt.forms[0].yeuCauYcgt,'Ch\u01B0a nh\u1EADp y\u00EAu c\u1EA7u gi\u1EA3i')) return false;
		if(!isRequired(documemt.forms[0].thoiDiemYcgt,'Ch\u01B0a nh\u1EADp th\u1EDDi gian cung c\u1EA5p gi\u1EA3i tr\u00ECnh')) return false;
		return true;
	}
	</script>
<%@include file="/bottom.jsp"%>
