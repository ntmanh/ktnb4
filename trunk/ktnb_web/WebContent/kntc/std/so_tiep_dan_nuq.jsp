<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<logic:present name="tiepDanForm" property="uyQuyen">
	<logic:equal name="tiepDanForm" property="uyQuyen" value="1">
		<fieldset><legend>Thông tin Người ủy quyền</legend>
		<table width="100%">
			<tr>
				<td width="15%" style="text-align: right;">Họ tên <font color="red">*</font></td>
				<td width="35%"><html:hidden property="nuqMa" /> <html:text property="nuqTen" style="width: 100%"></html:text></td>
				<td width="15%" style="text-align: right;">Địa chỉ</td>
				<td width="35%"><html:text property="nuqDiaChi" style="width: 100%" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Nơi công tác</td>
				<td><html:text property="nuqNoiCongTac" style="width: 100%" /></td>
				<td style="text-align: right;">Chức vụ</td>
				<td><html:text property="nuqChucVu" style="width: 100%" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">CMT/Hộ chiếu <font color="red">*</font></td>
				<td><html:text property="nuqCMT" style="width: 100%" /></td>
				<td style="text-align: right;">Điện thoại</td>
				<td><html:text property="nuqDienThoai" style="width: 100%" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Nơi cấp</td>
				<td><html:text property="nuqCMTNoiCap" style="width: 100%" /></td>
				<td style="text-align: right;">Ngày cấp</td>
				<td><html:text property="nuqCMTNgayCap" style="width: 100%" maxlength="10" style="width:100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			</tr>
		</table>
		</fieldset>
		<fieldset><legend>Nội dung giấy ủy quyền</legend>
		<table width="100%">
			<tr>
				<td width="15%" style="text-align: right;">Thời gian ủy quyền từ ngày</td>
				<td width="35%"><html:text property="guqTuNgay" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
				<td width="15%" style="text-align: right;">Đến ngày</td>
				<td width="35%"><html:text property="guqDenNgay" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Nội dung</td>
				<td colspan="3"><html:textarea property="guqNoiDung" style="width: 100%;height:80px" onkeypress="imposeMaxLength(this);"/></td>
			</tr>
			<tr>
				<td style="text-align: right;">Ngày xác nhận của chính quyền địa phương</td>
				<td><html:text property="guqNgayXacNhan" maxlength="10" style="width:100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
				<td></td>
				<td></td>
			</tr>
		</table>
		</fieldset>
	</logic:equal>
	<logic:equal name="tiepDanForm" property="uyQuyen" value="2">
		<fieldset><legend>Thông tin cơ quan, tổ chức ủy quyền</legend>
		<table width="100%">
			<tr>
				<td width="15%" style="text-align: right;">Tên <font color="red">*</font></td>
				<td width="35%"><html:hidden property="nuqMa" /> <html:text property="nuqTen" style="width:100%"></html:text></td>
				<td width="15%" style="text-align: right;">Điện thoại</td>
				<td width="35%"><html:text property="nuqDienThoai" style="width:100%" /></td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right;">Địa chỉ</td>
				<td width="35%"><html:text property="nuqDiaChi" style="width:100%" /></td>
				<td width="15%" style="text-align: right;">FAX</td>
				<td width="35%"><html:text property="nuqFAX" /></td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right;">Mã số thuế <font color="red">*</font></td>
				<td width="35%"><html:text property="nuqCMT" style="width:100%" /></td>
			</tr>
		</table>
		</fieldset>
		<fieldset><legend>Nội dung giấy ủy quyền</legend>
		<table width="100%">
			<tr>
				<td width="15%" style="text-align: right;">Thời gian ủy quyền từ ngày <font color="red">*</font></td>
				<td width="35%"><html:text property="guqTuNgay" readonly="readonly" style="width:100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
				<td width="15%" style="text-align: right;">Đến ngày <font color="red">*</font></td>
				<td width="35%"><html:text property="guqDenNgay" maxlength="10" style="width:100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right;">Người ủy quyền <font color="red">*</font></td>
				<td><html:text property="guqNuqTen" style="width:100%" /></td>
				<td width="15%" style="text-align: right;">Chức danh</td>
				<td><html:text property="guqNuqChucVu" style="width:100%" /></td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right;">Nội dung</td>
				<td><html:textarea property="guqNoiDung" style="width:100%;height:80px;" onkeypress="imposeMaxLength(this);"/></td>
				<td width="15%" style="text-align: right;">Ngày xác nhận của cơ quan, tổ chức</td>
				<td><html:text property="guqNgayXacNhan" style="width:100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			</tr>
		</table>
		</fieldset>
	</logic:equal>
</logic:present>