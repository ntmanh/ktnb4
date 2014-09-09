<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top.jsp"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="/kntc_giay_bn.do?method=show">
<div id="super-tabs">
<ul>
	<li><a href="#super-tab0" onclick="redirectNoId('kntc_tiep_dan.do?method=show');"><span>SỔ TIẾP DÂN</span></a></li>
	<li><a href="#super-tab1" onclick="redirectNoId('kntc_tim_kiem_chuyen_ho_so.do?method=show&action=chuyenHS');"><span>CHUYỂN HS SANG BỘ PHẬN HÀNH CHÍNH</span></a></li>	
</ul>
	<div id="super-tab0"></div>
	<div id="super-tab1">
	<html:hidden property="maHoSo" />
	<br>
	<fieldset><legend>Thông tin Giấy biên nhận</legend>
	<TABLE width="100%">
		<TBODY>
			<tr>
				<td width="103">Số giấy biên nhận</td>
				<td width="183"><html:text property="ma" /></td>
				<td width="103">Thời điểm lập phiếu</td>
				<td width="198"><html:text property="ngay" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
	<br>
	<TABLE width="100%">
		<TBODY>
			<tr>
				<td width="100%" align="center"><INPUT type="button" name="inGiayBienNhan0" style="width: 60" class="button" value="Lưu" onclick="ghi();"> <INPUT type="button" name="inGiayBienNhan1" class="button" value="In" onclick="print();"> <!--<INPUT type="button" name="inGiayBienNhan2"   class="button" value="Xóa" onclick="xoa();">-->
				<INPUT type="button" name="inGiayBienNhan" class="button" value="Đóng" onclick="window.close();"></td>
			</tr>
		</TBODY>
	</TABLE>
	</div>
</html:form>
<script language="JavaScript">
var super_tab;
$(document).ready(function(){
	super_tab=$("#super-tabs");
	super_tab.tabs();
	super_tab.tabs("select" , 1);
	var ghiTC = "";
	 <logic:present name="ghiThanhcong">
	     	ghiTC = '<%=request.getAttribute("ghiThanhcong")%>';
	 </logic:present>
	 if(ghiTC=='1'){
		alert('Lưu thành công'); 
	 }
	 else  if(ghiTC=='0'){
		alert('Lỗi khi ghi dữ liệu!!!'); 
	 }  
	 <%request.removeAttribute("ghiThanhcong");%>		
 }
);
function ghi(){
	document.forms[0].action="kntc_giay_bn.do?method=save";
	document.forms[0].submit();
}
function print(){
document.forms[0].action="kntc_giay_bn.do?method=inGbn";
	document.forms[0].submit();}
function xoa(){
    var maHS = document.forms[0].maHoSo.value;
   // alert(maHS);
	if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+value);
	else
		alert("Chưa có thông tin về hồ sơ!");	
}
</script>
<%@include file="/bottom.jsp"%>