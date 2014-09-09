<%@page pageEncoding="UTF-8" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<logic:present name="chua_cong_bo_quyet_dinh">
	<script language="javascript">
		alert('Cuộc Thanh tra Kiểm tra chưa được công bố quyết định !');
		window.close();
	</script>
</logic:present>
<%@ include file="/top_bar.jsp"%>
<h3 class="Header">BIÊN BẢN CHI TIẾT</h3>
<html:form action="bien_ban_chi_tiet.do" method="POST" enctype="multipart/form-data">
	<fieldset>
	<table width="100%">
		<tr>
			<td width="24%" align="right">
				Download file mẫu
			</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%">
				<a href="#" onclick="download();" style="text-decoration: none;">
				<font color=blue>File biên bản chi tiết</font>
				</a>
			</td>
			<td width="24%" align="right"></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"></td>
		</tr>
		<tr>
			<td width="24%" align="right">Người lập <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:select property="idNguoiLap" onchange="changeThanhVienDoan(this)" style="width:100%">
				<html:options collection="dsThanhVienDoan" property="idCanBo" labelProperty="tenCanBo" />
			</html:select> <html:hidden property="tenNguoiLap" /></td>
			<td width="24%" align="right">Ngày trưởng đoàn phân công <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text onblur="if(!isDate(this)) return;validateRequiredDate(this);" onkeypress="return formatDate(event, this)" property="ngayPhanCongCuaTd" styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td width="24%" align="right">Thời gian tiến hành: Từ ngày <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%" align="left"><html:text onchange="if(!isDate(this)) return;validateRequiredDate(this);" onkeypress="return formatDate(event, this)" property="tgianThTuNgay" styleClass="text" >
			</html:text></td>
			<td width="24%" align="right">Đến ngày <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%" align="left"><html:text onblur="if(!isDate(this)) return;validateRequiredDate(this);" onkeypress="return formatDate(event, this)" property="tgianThDenNgay" styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td width="24%" align="right">Thanh tra Kiểm tra tại <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4"><html:text property="ttktTai" styleClass="text" style="width: 100%">
			</html:text></td>
		</tr>
		<tr>
			<td width="24%" align="right">Thời gian lập biên bản <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text  property="thoiDiemLapBb" styleClass="text" onchange="if(!isTime(this)) return;validateRequiredDate(this);" onkeypress="return formatTime(event, this)" >
			</html:text></td>
			<td width="24%" align="right">Địa điểm <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="diaDiemLapBb" styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td width="24%" align="right">Thời điểm thông qua <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text  property="thoiDiemThongQua" styleClass="text" onblur="if(!isTime(this)) return;validateRequiredDate(this);" onkeypress="return formatTime(event, this)"></html:text></td>
			<td width="24%" align="right">		
				<div id="fileDinhKem1">
				</div>
				File đính kèm <font color="red">*</font>
			</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:file property="fileDinhKem">
			</html:file></td>
		</tr>
		
	</table>
	</fieldset>
	<fieldset>
	<DIV align="center" style="text-align: center;"><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></DIV>
	</fieldset>
	<html:hidden property="idCuocTtkt" />
	<html:hidden property="id" />
</html:form>
<%@ include file="/bottom.jsp"%>
<script type="text/javascript">
function validateRequiredDate(dateElement){
var ngayRaQuyetDinh = '<%=request.getAttribute("ngayRaQuyetDinh")%>';
var thoiDiemCongBo = '<%=request.getAttribute("thoiDiemCongBo")%>';
	if(ngayRaQuyetDinh!=null&&ngayRaQuyetDinh!=""){
	if(dateElement.name!=""){
		switch(dateElement.name){
		case "tgianThTuNgay":
			if(dateElement.value!=null&&dateElement.value!=""){
				if(d2n(dateElement.value)<d2n(thoiDiemCongBo)){
					alert("Thời gian tiến hành phải sau ngày công bố quyết định");
					dateElement.focus();
				}
			}
			break;
		case "ngayPhanCongCuaTd":
			if(dateElement.value!=null&&dateElement.value!=""){
				if(d2n(dateElement.value)<d2n(ngayRaQuyetDinh)){
					alert("Ngày phân công của trưởng đoàn phải sau ngày ra quyết định");
					dateElement.focus();
				}
			}
			break;
		case "tgianThDenNgay":
			if(dateElement.value!=null&&dateElement.value!=""){
				if(d2n(dateElement.value)<d2n(thoiDiemCongBo)){
					alert("Thời gian  đến ngày phải sau ngày công bố quyết định");
					dateElement.focus();
				}
			}
			break;
		case "thoiDiemLapBb":
			if(dateElement.value!=null&&dateElement.value!=""){
				if(d2n(dateElement.value.split(' ')[1])<d2n(thoiDiemCongBo)){
					alert("Thời điểm lập biên bản phải sau ngày công bố quyết định");
					dateElement.focus();
				}
			}
			break;
		case "thoiDiemThongQua":
			if(dateElement.value!=null&&dateElement.value!=""){
				if(d2n(dateElement.value.split(' ')[1])<d2n(thoiDiemCongBo)){
					alert("Thời điểm thông qua biên bản phải sau ngày công bố quyết định");
					dateElement.focus();
				}
			}
			break;
		default:
			break;
		}
		}
	}
}
</script>
<%String cucsses = (String) request.getAttribute("cucsses");
if ("cucsses".equals(cucsses)) {
	
	String updateType = (String) request.getAttribute("updateType");
	if ("insert".equals(updateType)) {%>
<script language="javascript">
	alert("lưu thành công");
	tenNguoiLap = document.getElementsByName('tenNguoiLap')[0].value
	ttktTai = document.getElementsByName('ttktTai')[0].value;
	thoiDiemLapBb = document.getElementsByName('thoiDiemLapBb')[0].value;
	diaDiemLapBb = document.getElementsByName('diaDiemLapBb')[0].value;
	tgianThTuNgay = document.getElementsByName('tgianThTuNgay')[0].value;
	tgianThDenNgay = document.getElementsByName('tgianThDenNgay')[0].value;
	thoiDiemThongQua = document.getElementsByName('thoiDiemThongQua')[0].value;
	fileId = document.getElementsByName('id')[0].value;
	//ngayPhanCongCuaTd = document.getElementsByName('ngayPhanCongCuaTd')[0].value;
	window.opener.addBienBanChiTietRow(tenNguoiLap, ttktTai, thoiDiemLapBb, diaDiemLapBb, tgianThTuNgay, tgianThDenNgay, thoiDiemThongQua, fileId);
				//insertParent();
				window.close();
			</script>
<%} else {%>
<script language="javascript">
	alert("lưu thành công");
	cbNguoiLap = document.getElementsByName('idNguoiLap')[0];
	tenNguoiLap = cbNguoiLap[cbNguoiLap.selectedIndex].text;	
	ttktTai = document.getElementsByName('ttktTai')[0].value;
	thoiDiemLapBb = document.getElementsByName('thoiDiemLapBb')[0].value;
	diaDiemLapBb = document.getElementsByName('diaDiemLapBb')[0].value;
	tgianThTuNgay = document.getElementsByName('tgianThTuNgay')[0].value;
	tgianThDenNgay = document.getElementsByName('tgianThDenNgay')[0].value;
	thoiDiemThongQua = document.getElementsByName('thoiDiemThongQua')[0].value;
	fileId = document.getElementsByName('id')[0].value;
	//ngayPhanCongCuaTd = document.getElementsByName('ngayPhanCongCuaTd')[0].value;
	window.opener.upDateBienBanChiTietRow(tenNguoiLap, ttktTai, thoiDiemLapBb, diaDiemLapBb, tgianThTuNgay, tgianThDenNgay, thoiDiemThongQua, fileId);
				//updateParent();
				window.close();
			</script>
<%}
}
%>
<script language="javascript">
function selfClose(){ 
	window.close();
}
window.onload = function(){
	changeThanhVienDoan(document.getElementsByName('idNguoiLap')[0]);
	if($('[name="id"]')[0].value==null||$('[name="id"]')[0].value==""||$('[name="id"]')[0].value=="null"){
	$('#fileDinhKem1').hide();
	}else{
		$('#fileDinhKem1').show();
		$('#fileDinhKem1').append('<div id="file" style="text-align: right;color:blue; cursor: pointer">File biên bản chi tiết</div> ');
		$('#file').click(function() {
 		 	downloadBienBanChiTiet1($('[name="id"]')[0].value);
		});
	}
}
function changeThanhVienDoan(cbBox){
	document.getElementsByName('tenNguoiLap')[0].value = cbBox[cbBox.selectedIndex].text;
}
function insertParent(){
	tenNguoiLap = document.getElementsByName('tenNguoiLap')[0].value
	ttktTai = document.getElementsByName('ttktTai')[0].value;
	thoiDiemLapBb = document.getElementsByName('thoiDiemLapBb')[0].value;
	diaDiemLapBb = document.getElementsByName('diaDiemLapBb')[0].value;
	tgianThTuNgay = document.getElementsByName('tgianThTuNgay')[0].value;
	tgianThDenNgay = document.getElementsByName('tgianThDenNgay')[0].value;
	thoiDiemThongQua = document.getElementsByName('thoiDiemThongQua')[0].value;
	fileId = document.getElementsByName('id')[0].value;
	window.opener.addBienBanChiTietRow(tenNguoiLap, ttktTai, thoiDiemLapBb, diaDiemLapBb, tgianThTuNgay, tgianThDenNgay, thoiDiemThongQua, fileId);
	
}
function updateParent(){
	cbNguoiLap = document.getElementsByName('idNguoiLap')[0];
	tenNguoiLap = cbNguoiLap[cbNguoiLap.selectedIndex].text;	
	ttktTai = document.getElementsByName('ttktTai')[0].value;
	thoiDiemLapBb = document.getElementsByName('thoiDiemLapBb')[0].value;
	diaDiemLapBb = document.getElementsByName('diaDiemLapBb')[0].value;
	tgianThTuNgay = document.getElementsByName('tgianThTuNgay')[0].value;
	tgianThDenNgay = document.getElementsByName('tgianThDenNgay')[0].value;
	thoiDiemThongQua = document.getElementsByName('thoiDiemThongQua')[0].value;
	fileId = document.getElementsByName('id')[0].value;
	window.opener.upDateBienBanChiTietRow(tenNguoiLap, ttktTai, thoiDiemLapBb, diaDiemLapBb, tgianThTuNgay, tgianThDenNgay, thoiDiemThongQua, fileId);
}
function validateForm(){    
	if(!isRequired(document.getElementsByName('ngayPhanCongCuaTd')[0]))
		return false;
	if(!isRequired(document.getElementsByName('tgianThTuNgay')[0]))
		return false;
	if(!isRequired(document.getElementsByName('tgianThDenNgay')[0]))
		return false;
	if(!compareDate(document.getElementsByName('tgianThTuNgay')[0], document.getElementsByName('tgianThDenNgay')[0]))
		return false;
	if(!isRequired(document.getElementsByName('ttktTai')[0]))
		return false;
	if(!isRequired(document.getElementsByName('thoiDiemLapBb')[0]))
		return false;
	if(!isRequired(document.getElementsByName('diaDiemLapBb')[0]))
		return false;
	if(!isRequired(document.getElementsByName('thoiDiemThongQua')[0]))
		return false;
	if(!compareTime(document.getElementsByName('thoiDiemLapBb')[0], document.getElementsByName('thoiDiemThongQua')[0], '<', 'Thời điểm thông qua phải sau thời điểm lập biên bản!'))
		return false;
	if(!isRequired(document.getElementsByName('fileDinhKem')[0]))
		return false;	
	var tgianThDenNgay = d2n(document.getElementsByName('tgianThDenNgay')[0].value);
	var thoiDiemThongQua = d2n(document.getElementsByName('thoiDiemThongQua')[0].value.split(" ")[1]);
	return true;
}
function downloadBienBanChiTiet1(bbchiTietId){
		downLoadWinDow = window.open('UploadAction.do?method=downLoadBienBan&ma_file='+bbchiTietId);
		downLoadWinDow.focus();
	}
function download(){
		downLoadWinDow = window.open('bien_ban_chi_tiet.do?method=downLoadMau');
		downLoadWinDow.focus();
	}
</script>