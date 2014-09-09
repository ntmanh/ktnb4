<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<logic:present name="SoTiepDanVanThuForm" property="loaiKNTC">
	<logic:equal name="SoTiepDanVanThuForm" property="loaiKNTC" value="1">
		<!--Don khieu nai-->
		<fieldset><legend>Nội dung đơn</legend>
		<table width="100%">
			<tr>
				<td width="15%" style="text-align: right;">Số đơn</td>
				<td width="35%"><html:text property="soDon" style="width: 100%" /></td>
				<td width="15%" style="text-align: right;">Đơn đề ngày</td>
				<td width="35%"><html:text property="donDeNgay" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Họ tên người bị KN <font color="red">*</font></td>
				<td><!-- <html:hidden property="canBoBiKNTCMa" /> --> <html:text property="canBoBiKNTCTen" style="width: 100%" /></td>
				<td style="text-align: right;">Địa chỉ</td>
				<td><html:text property="canBoBiKNTCDiaChi" style="width: 100%" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Chức vụ</td>
				<td><html:text property="canBoBiKNTCChucVu" style="width: 100%" /></td>
				<td style="text-align: right;">Nơi công tác</td>
				<td><html:text property="canBoBiKNTCNoiCongTac" style="width: 100%" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Nội dung tóm tắt đơn <font style="color: red">*</font></td>
				<td colspan="3"><html:textarea property="noiDungDon" onkeypress="imposeMaxLength(this);" style="width:100%;height:70px" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">File đơn</td>
				<td colspan="3"><A href="#" onclick="openUploadFile();">File "đơn" đính kèm</A></td>
			</tr>
		</table>
		</fieldset>
		<fieldset><!-- Tai lieu kem theo --> <legend>Tài liệu, chứng cứ kèm theo</legend>
		<table width="50%" cellpadding="0" cellspacing="0" border="0" class="display" id="example">
			<thead>
				<tr>
					<th>Tên tài liệu</th>
					<th>Số trang</th>
					<th>Tình trạng</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td width="60%"><input type="text" name="tenTL" id="tenTL0" style="width: 100%"></td>
					<td width="20%"><input type="text" name="soTrangTL" id="soTrangTL0" style="width: 100%" maxlength="3" onkeypress="return nokeypress(event);" onblur="isNumber(this,'i');" /></td>
					<td width="20%"><select id="tinhTrang0">
						<option value="Bản chính">Bản chính</option>
						<option value="Bản sao">Bản sao</option>
						<option value="Bản sao có công chứng">Bản sao có công chứng</option>
					</select></td>
				</tr>
			</tbody>
		</table>
		<div style="text-align: right; width: 100%; font-size: 8pt; font-weight: bold;"><INPUT type="button" name="btnAdd" class="button" onclick="fnClickAddRow();" value="Thêm"> <INPUT type="button" name="btnXoa" class="button" id="deleteRow" value="Xóa"></div>
		</fieldset>
		<fieldset><!-- Ghi chu --> <legend>Ghi chú</legend>
		<table width="100%">
			<tr>
				<td><html:textarea property="ghiChu" onkeypress="imposeMaxLength(this);" style="width:100%;height:70px" /></td>
			</tr>
		</table>
		</fieldset>
	</logic:equal>
	<!--Don To Cao-->
	<logic:equal name="SoTiepDanVanThuForm" property="loaiKNTC" value="2">
		<fieldset><legend>Nội dung đơn</legend>
		<table width="100%">
			<tr>
				<td width="15%" style="text-align: right;">Số đơn</td>
				<td width="35%"><html:text property="soDon" style="width:100%" /></td>
				<td width="15%" style="text-align: right;">Đơn đề ngày</td>
				<td width="35%"><html:text property="donDeNgay" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Họ tên người bị TC<font style="color: red">*</font></td>
				<td><html:text property="canBoBiKNTCTen" style="width:100%" /> <!--		
			<html:hidden property="canBoBiKNTCMa" />
			<input type="button" class="button" name="btnCb" style="width: 10%" value="..." onclick="showLovCanbo()">
			--></td>
				<td style="text-align: right;">Địa chỉ</td>
				<td><html:text property="canBoBiKNTCDiaChi" style="width:100%" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Chức vụ</td>
				<td><html:text property="canBoBiKNTCChucVu" style="width:100%" /></td>
				<td style="text-align: right;">Nơi công tác</td>
				<td><html:text property="canBoBiKNTCNoiCongTac" style="width:100%" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Nội dung tóm tắt đơn <font style="color: red">*</font></td>
				<td colspan="3"><html:textarea property="noiDungDon" onkeypress="imposeMaxLength(this);" style="width:100%;height:70px" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">File đơn</td>
				<td colspan="3"><A href="#" onclick="openUploadFile();">Chọn file </A></td>
			</tr>
		</table>
		</fieldset>
		<fieldset><!-- Tai lieu kem theo --> <legend>Tài liệu, chứng cứ kèm theo</legend>
		<table width="50%" cellpadding="0" cellspacing="0" border="0" class="display" id="example">
			<thead>
				<tr>
					<th>Tên tài liệu</th>
					<th>Số trang</th>
					<th>Tình trạng</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td width="60%"><input type="text" name="tenTL" id="tenTL0" style="width: 100%"></td>
					<td width="20%"><input type="text" name="soTrangTL" id="soTrangTL0" style="width: 100%" maxlength="3" onkeypress="return nokeypress(event);" onblur="isNumber(this,'i');" /></td>
					<td width="20%"><select id="tinhTrang0">
						<option value="Bản chính">Bản chính</option>
						<option value="Bản sao">Bản sao</option>
						<option value="Bản sao có công chứng">Bản sao có công chứng</option>
					</select></td>
				</tr>
			</tbody>
		</table>
		<div style="text-align: right; width: 100%; font-size: 8pt; font-weight: bold;"><INPUT type="button" name="btnAdd" class="button" onclick="fnClickAddRow();" value="Thêm"> <INPUT type="button" name="btnXoa" class="button" id="deleteRow" value="Xóa"></div>
		</fieldset>
		<fieldset><!-- Ghi chu --> <legend>Ghi chú</legend>
		<table width="100%">
			<tr>
				<td><html:textarea property="ghiChu" onkeypress="imposeMaxLength(this);" style="width:100%;height:70px" /></td>
			</tr>
		</table>
		</fieldset>
	</logic:equal>
	<!--Don Khac-->
	<logic:equal name="SoTiepDanVanThuForm" property="loaiKNTC" value="3">
		<fieldset><legend>Nội dung đơn</legend>
		<table width="100%">
			<tr>
				<td width="15%" style="text-align: right;">Số đơn</td>
				<td width="35%"><html:text property="soDon" style="width:100%" /></td>
				<td width="15%" style="text-align: right;">Đơn đề ngày</td>
				<td width="35%"><html:text property="donDeNgay" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Họ tên người bị KNTC<font style="color: red">*</font></td>
				<td><html:text property="canBoBiKNTCTen" style="width:100%" /> <!--  
				<html:hidden property="canBoBiKNTCMa" />
				<input type="button" class="button" name="btnCb" style="width: 10%" value="..." onclick="showLovCanbo()">
				--></td>
				<td style="text-align: right;">Địa chỉ</td>
				<td><html:text property="canBoBiKNTCDiaChi" style="width:100%" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Chức vụ</td>
				<td><html:text property="canBoBiKNTCChucVu" style="width:100%" /></td>
				<td style="text-align: right;">Nơi công tác</td>
				<td><html:text property="canBoBiKNTCNoiCongTac" style="width:100%" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Nội dung tóm tắt đơn <font style="color: red">*</font></td>
				<td colspan="3"><html:textarea property="noiDungDon" onkeypress="imposeMaxLength(this);" style="width:100%;height:70px" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">File đơn</td>
				<td colspan="3"><A href="#" onclick="openUploadFile();">Chọn file </A></td>
			</tr>
		</table>
		</fieldset>
		<fieldset><!-- Tai lieu kem theo --> <legend>Tài liệu, chứng cứ kèm theo</legend>
		<table width="50%" cellpadding="0" cellspacing="0" border="0" class="display" id="example">
			<thead>
				<tr>
					<th>Tên tài liệu</th>
					<th>Số trang</th>
					<th>Tình trạng</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td width="60%"><input type="text" name="tenTL" id="tenTL0" style="width: 100%"></td>
					<td width="20%"><input type="text" name="soTrangTL" id="soTrangTL0" style="width: 100%" maxlength="3" onkeypress="return nokeypress(event);" onblur="isNumber(this,'i');" /></td>
					<td width="20%"><select id="tinhTrang0">
						<option value="Bản chính">Bản chính</option>
						<option value="Bản sao">Bản sao</option>
						<option value="Bản sao có công chứng">Bản sao có công chứng</option>
					</select></td>
				</tr>
			</tbody>
		</table>
		<div style="text-align: right; width: 100%; font-size: 8pt; font-weight: bold;">
		<INPUT type="button" name="btnAdd" id="btnAdd" class="button" onclick="fnClickAddRow();" value="Thêm"> 
		<INPUT type="button" name="btnXoa" class="button" id="deleteRow" value="Xóa"></div>
		</fieldset>
		<fieldset><!-- Ghi chu --> <legend>Ghi chú</legend>
		<table width="100%">
			<tr>
				<td><html:textarea property="ghiChu" onkeypress="imposeMaxLength(this);" style="width:100%;height:70px" /></td>
			</tr>
		</table>
		</fieldset>
	</logic:equal>
<script language="JavaScript">
function openUploadFile(){
	var view='';
	var method = '<%=request.getParameter("method")%>';
	if(method == 'view') view = 'view';
	var r = '<%=request.getParameter("r")%>';
	if(r == 'rol') view = 'view';
	
    var maHS = document.forms[0].maHoSo.value;
    //alert(maHS);
	if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+maHS+"&nv=KNTC/STD&view="+view);
	else
		alert("Bạn phải lưu hồ sơ trước khi gửi file đính kèm!");
}

function giayBienNhan(){
  var maHS = document.forms[0].maHoSo.value;
  //alert(maHS);
  if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("kntc_giay_bn.do?method=show&id="+maHS);
	else
		alert("Bạn phải lưu hồ sơ trước khi lập giấy biên nhận!");
}
function lapPhieuHen(){
  var maHS = document.forms[0].maHoSo.value;
//    alert(maHS);
  if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("kntc_phieu_hen.do?method=show&id="+maHS);
	else
		alert("Bạn phải lưu hồ sơ trước khi lập phiếu hẹn!");
}
function showLovCanbo(index)
{
	tenCB = document.forms[0].canBoBiKNTCTen.value;
	if(tenCB!=null && tenCB!='' && tenCB!='null')
		openWindow("danhmuc_canbo.do?method=lov&txtSearch="+normalizeString4SQL(tenCB));
	else
		openWindow("danhmuc_canbo.do?method=lov");
}
function setData(values){
	var str_val= values.split("@@");  	
 	document.forms[0].canBoBiKNTCMa.value= str_val[0];
 	document.forms[0].canBoBiKNTCTen.value= str_val[1];	
 	document.forms[0].canBoBiKNTCChucVu.value= str_val[2];
 	document.forms[0].canBoBiKNTCNoiCongTac.value= str_val[4];	
}
</script>
</logic:present>
