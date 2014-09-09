<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Chuyển giao hồ sơ</h3>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="/kntc_giay_bn.do?method=cghs" method="post">
<div id="super-tabs">
<ul>
	<li><a href="#super-tab0" onclick="redirectNoId('kntc_tiep_dan.do?method=show');"><span>SỔ TIẾP DÂN</span></a></li>
	<li><a href="#super-tab1" onclick="redirectNoId('kntc_tim_kiem_chuyen_ho_so.do?method=show&action=chuyenHS');"><span>CHUYỂN HS SANG BỘ PHẬN HÀNH CHÍNH</span></a></li>	
</ul>
	<div id="super-tab0"></div>
	<div id="super-tab1">
	<html:hidden property="maHoSo" />
	<html:hidden property="ma" />
	<fieldset><legend>Cơ quan Thuế</legend>
	<TABLE width="100%">
		<tr>
			<td width="15%" align="right">Cơ quan thuế</td>
			<td width="35%"><html:hidden property="dvGiaoMa" /> <html:text property="dvGiaoTen" style="width:100%" /></td>
			<td width="15%" align="right">Đơn vị tiếp nhận</td>
			<td width="35%"><html:hidden property="dvNhanMa" /> <html:text property="dvNhanTen" style="width:100%" /></td>
		</tr>
	</TABLE>
	</fieldset>
	<fieldset><legend>Thông tin phiếu</legend>
	<TABLE width="100%">
		<tr>
			<td width="15%" align="right">Thời điểm</td>
			<td width="35%"><html:text property="ngay" style="width:100%" styleId="idThoiDiem" onblur="isTime(this)" onkeypress="return formatTime(event, this)" /></td>
			<td width="15%" align="right">Địa điểm</td>
			<td width="35%"><html:text property="diaDiem" style="width:100%" /></td>
		</tr>
		<tr>
			<td></td>
			<td align="left" style="font-weight: bold; font-size: 11px;">Người nhận hồ sơ</td>
			<td></td>
			<td align="left" style="font-weight: bold; font-size: 11px;">Người giao hồ sơ</td>
		</tr>
		<tr>
			<td align="right">Họ tên <font color="red">*</font></td>
			<td><html:hidden property="nguoiNhanMa" /> <html:text property="nguoiNhanTen" style="width:85%" /> 
			<input type="button" class="button" name="btnCb" style="width: 30px" value="..." onclick="showLovCanbo('1')"></<input></td>
			<td align="right">Họ tên <font color="red">*</font></td>
			<td><html:hidden property="nguoiGiaoMa" /> <html:text property="nguoiGiaoTen" style="width:85%" /> 
			<input type="button" class="button" name="btnCb2" style="width: 30px" value="..." onclick="showLovCanbo('2')" /></td>
		</tr>
		<tr>
			<td align="right">Chức vụ <font color="red">*</font></td>
			<td><html:text property="nguoiNhanCV" style="width:100%"/></td>
			<td align="right">Chức vụ</td>
			<td><html:text property="nguoiGiaoCV" style="width:100%"/></td>
		</tr>
		<tr>
			<td align="right">Đơn vị</td>
			<td><html:text property="nguoiNhanDV" style="width:100%"/></td>
			<td align="right">Đơn vị</td>
			<td><html:text property="nguoiGiaoDV" style="width:100%"/></td>
		</tr>
		<tr>
			<td align="right">Hồ sơ bàn giao <font color="red">*</font></td>
			<td colspan="3"><html:textarea property="noiDungBG" onkeypress="imposeMaxLength(this);" style="width:100%;height:80px;" /></td>
		</tr>
	</TABLE>
	</fieldset>
	<br>
	<table width="100%">
		<tr align="right">
			<td align="center"><input type="button" name="btnSave" class="button" value='Lưu' onclick="ghi();"> <INPUT type="button" id="btnKetXuat" name="btnPrint" class="button" value="Kết xuất" onclick="print();"> <!--<INPUT type="button" name="btnDel" class="button" value="Xóa" onclick="xoa();">-->
			<INPUT type="button" name="btnOut" class="button" value="Đóng" onclick="goHomeKntc();"></td>
		</tr>
	</table>
	<jsp:include page="/kntc2/other_action/tiep_dan.jsp"></jsp:include>
</div>
</html:form>

<script type="text/javascript" charset="utf-8"> 
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
});
var globalIdx = 0;
function showLovCanbo(index)
{
	globalIdx = index;
	if(globalIdx=='1')
		value = document.forms[0].nguoiNhanTen.value;
	else if(globalIdx=='2')
		value = document.forms[0].nguoiGiaoTen.value;
	if(value!=null && value!='' && value!='null')
		openWindow("danhmuc_canbo.do?method=lov&r=1&txtSearch="+value);
	else
		openWindow("danhmuc_canbo.do?method=lov&r=1");
}
function setData(values){
	var str_val= values.split("@@"); 
 	if(globalIdx=='1'){
	 	document.forms[0].nguoiNhanMa.value = str_val[0];
	 	document.forms[0].nguoiNhanTen.value = str_val[1];
	 	document.forms[0].nguoiNhanCV.value = str_val[2];		
	 	document.forms[0].nguoiNhanDV.value = str_val[4];	
	}else if(globalIdx=='2'){
	 	document.forms[0].nguoiGiaoMa.value = str_val[0];
	 	document.forms[0].nguoiGiaoTen.value = str_val[1];
	 	document.forms[0].nguoiGiaoCV.value = str_val[2];	
	 	document.forms[0].nguoiGiaoDV.value = str_val[4];
	}
}

function ghi(){
	if(validForm()){
	document.forms[0].action="kntc_giay_bn.do?method=saveCghs";
	document.forms[0].submit();}
}
function print(){
	if(validForm()){
	document.forms[0].action="kntc_giay_bn.do?method=inCghs";
	document.forms[0].submit();}
}
function validForm() {
	if(!isRequired(document.forms[0].elements['nguoiNhanTen'], 'Chưa nhập họ tên người nhận'))
		return false;
	if(!isRequired(document.forms[0].elements['nguoiNhanCV'],'Chưa nhập chức vụ người nhận'))
		return false;
	if(!isRequired(document.forms[0].elements['nguoiGiaoTen'],'Chưa nhập họ tên người giao'))
		return false;
	if(!isRequired(document.forms[0].noiDungBG,'Chưa nhập nội dung bàn giao'))
		return false;
	if(!validDateTime(document.forms[0].idThoiDiem))
		return false;
	return true;
}
</script>
<%@ include file="/bottom.jsp"%>