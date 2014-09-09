<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="/kntc_da_tiep_nhan.do?method=gopHs" method="post">
	<div id="super-tabs">
	<ul>
		<li><a href="#super-tab0" onclick="redirectNoId('kntc_tiep_dan_van_thu.do?method=show&l=v');"><span>NHẬP HỒ SƠ GIẢI QUYẾT LẦN ĐẦU</span></a></li>
		<li><a href="#super-tab1" onclick="redirectNoId('kntc_tim_kiem_1lan.do?method=show&action=chonXLHS1Lan');"><span>NHẬP HỒ SƠ DO CQT KHÁC HOẶC TỪ TIẾP DÂN CHUYỂN ĐẾN</span></a></li>
		<li><a href="#super-tab2" onclick="redirectNoId('kntc_da_tiep_nhan.do?method=gopHs');"><span>NHẬP HỒ SƠ CÙNG NỘI DUNG</span></a></li>	
	</ul>
	<div id="super-tab0">
	</div>
	<div id="super-tab1">
	</div>
	<div id="super-tab2">
		<h3 class="Header">Gộp hồ sơ cùng vụ việc</h3>	
		<div style="text-align: center; width: 100%">
		<font style="font-size: 14px; color: red">Số hồ sơ gốc</font> 
		<html:text property="maHoSo" styleId="ma" style="width:250px;"/>
		<html:hidden property="trangThai" />
		<html:hidden property="loaiHoSo" />
		<input type="button" class="button" name="btnCb" value="..." onclick="showLovHs('1')"></div>
		<div id="thongBao" style="text-align:center; width:100%;"></div>
		<fieldset><legend>Thông tin hồ sơ</legend>
		<table width="100%">
			<tr>
				<td width="15%"></td>
				<td width="35%">
					<input type="checkbox" name="checkTonTai" value="no-value" checked="checked" onclick="changeTonTai();">Hồ sơ cần gộp đã có trên hệ thống
				</td>
				<td width="15%" style="text-align: right;">
					<div id="hoSoCuTitle" style="text-align: right;">Mã hồ sơ cần gộp<font style="color: red;">*</font></div>
				</td>
				<td width="30%">
					<div id="hoSoCu">						
						<html:text property="soHsGop" style="width:50%" />
						<input type="button" class="button" name="btnCb" value="..." onclick="showLovHs('2')">
					</div>
				</td>				
			</tr>
			<tr>
				<td align="right">Nơi chuyển đơn</td>
				<td align="left"><html:text property="noiChuyenDon" style="width:80%" /></td>
				<td align="right">Số ghi trên đơn</td>
				<td align="left"><html:text property="soDon" style="width:80%" /></td>
			</tr>
			<tr>
				<td align="right">Ngày ghi trên đơn</td>
				<td align="left"><html:text property="ngayGuiDon" style="width:80%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" maxlength="10"/></td>
				<td align="right">Số công văn đến của bộ phận văn thư<font style="color: red;">*</font></td>
				<td align="left"><html:text property="soCVDenVT" style="width:80%" /></td>
			</tr>
			<tr>
				<td align="right">Ngày nhận đơn văn thư<font style="color: red;">*</font></td>
				<td align="left"><html:text property="ngayNhanVT" style="width:80%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" maxlength="10" /></td>
				<td align="right">Ngày bộ phận xử lý nhận được công văn<font style="color: red;">*</font></td>
				<td align="left"><html:text property="ngayNhanXL" style="width:80%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" maxlength="10" /></td>
			</tr>			
		</table>
		</fieldset>
		<table width="100%">
			<tr>
				<td align="center"><input type="button" style="wdith: 60px" name="btnSave" class="button" onclick="ghi();" value="Lưu" /> <input type="button" style="width: 60px" name="btnCancel" class="button" onclick="goHomeKntc();" value="Đóng" /></td>
			</tr>
		</table>
	</div>
	<jsp:include page="/kntc2/other_action/van_thu.jsp"></jsp:include>
</html:form>
<script language="JavaScript">
var super_tab;
	$(document).ready(function(){
	super_tab=$("#super-tabs");
	super_tab.tabs();
	super_tab.tabs("select" , 2);
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
	 document.forms[0].maHoSo.readOnly = true;
	 document.forms[0].soHsGop.readOnly = true;
	 });	
	function ghi(){
		if(validForm()){
			document.forms[0].action="kntc_da_tiep_nhan.do?method=saveGopHs";
			document.forms[0].submit();
		}
	}
	function changeTonTai(){	
		if(document.forms[0].checkTonTai.checked) {
			show("hoSoCu");
			show("hoSoCuTitle");			
		}else{
			hide("hoSoCu");			
			hide("hoSoCuTitle");			
		}
	}
	function validForm(){
		if(!isRequired(document.forms[0].maHoSo,'Chưa chọn hồ sơ gốc! để thực hiện! '))
		return false;	
		/*
		if(!isRequired(document.forms[0].soHsGop,'Chưa chọn hồ sơ cần gộp để thực hiện! '))
		return false;	
		*/
		if(!isRequired(document.forms[0].ngayNhanVT,'Chưa nhập ngày bộ phận văn thư nhận được công văn'))
			return false;
		if(!isRequired(document.forms[0].soCVDenVT,'Chưa nhập số công văn đến của bộ phận văn thư'))
			return false;
		if(!isRequired(document.forms[0].ngayNhanXL,'Chưa nhập ngày bộ phận xử lý nhận được công văn'))
			return false;	
		return true;
	}
	function setData(values,trangthai,loaihoso){
		if(gIndex==1)
		{
			if(values==document.forms[0].soHsGop.value)
			{
				alert('Bạn phải chọn hồ sơ khác hồ sơ cần gộp!');
				document.forms[0].maHoSo.value="";
				return false; 
			}
			document.forms[0].maHoSo.value= values;
			document.forms[0].trangThai.value = trangthai;
			document.forms[0].loaiHoSo.value = loaihoso;
			//alert(trangthai);
			if(trangthai >= 1615){				
				document.getElementById('thongBao').innerHTML = '<span style="color:red">Chú ý:</span> Hồ sơ gốc đã kết thúc, hệ thống sẽ thực hiện lưu hồ sơ bên dưới.<br/><span style="color:red">Cần hoàn thiện đề xuất xử lý để kết thúc hồ sơ lưu</span>';
			}else{
				document.getElementById('thongBao').innerHTML = '<span style="color:red">Chú ý:</span> Hồ sơ gốc đang xử lý, hệ thống sẽ thực hiện gộp hồ sơ bên dưới.';
			}
		}
		else if(gIndex==2)	
		{
			if(values==document.forms[0].maHoSo.value)
			{
				alert('Bạn phải chọn hồ sơ khác hồ sơ gốc!');
				document.forms[0].soHsGop.value="";
				return false;
			}
			document.forms[0].soHsGop.value= values;
		}
	}
	gIndex = 0;
	function showLovHs(des){
		gIndex=des;
		uri = "";
		if(gIndex==1)
			uri="kntc_tim_kiem.do?method=lov";
		else if(gIndex==2)
		{
			if(isEmpty(document.forms[0].maHoSo.value)){
				alert('C\u1EA7n ch\u1ECDn h\u1ED3 s\u01A1 g\u1ED1c tr\u01B0\u1EDBc khi x\u1EED l\u00FD');
				return false;
			}						
			uri="kntc_tim_kiem.do?method=lov&tt=y&loai="+document.forms[0].loaiHoSo.value;
		}
		openWindow(uri);
	}
</script>
<%@ include file="/bottom.jsp"%>
