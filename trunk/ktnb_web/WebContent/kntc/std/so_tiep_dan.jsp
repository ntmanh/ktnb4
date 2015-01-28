<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<fieldset style="font-size: 8pt;"><legend>Hồ sơ</legend>
<TABLE width="100%">
	<tr>
		<td width="15%" style="text-align: right;">Mã số hồ sơ</td>
		<td width="35%"><html:text property="maHoSo" style="width:100%" readonly="true" /></td>
		<td width="15%" style="text-align: right;">Lượt tiếp</td>
		<td width="35%"><html:text property="luotTiep" style="width:100%" onkeypress="return nokeypress(event);" onchange="checkLuotTiep(this)" onblur="isNumber(this,'i')" /></td>
	</tr>
</TABLE>
</fieldset>
<fieldset><legend>Hình thức tiếp dân</legend>
<TABLE width="100%">
	<td width="15%" style="text-align: right;">&nbsp;</td>
	<td width="30%"><html:radio property="hinhThuc" value="1" />Tiếp thường xuyên &nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td width="30%"><html:radio property="hinhThuc" value="2" />Tiếp định kỳ và đột xuất của lãnh đạo</td>
	<td width="25%"></td>
</TABLE>
</fieldset>
<fieldset><legend>Xử lý sơ bộ khi công dân đến trụ sở cơ quan</legend>
<table width="100%">
	<tr>
		<td width="15%" style="text-align: right;">&nbsp;</td>
		<td width="30%"><html:radio property="gayRoi" value="0" />Không gây rối</td>
		<td width="30%"><html:radio property="gayRoi" value="1" />Có gây rối</td>
		<td width="25%"></td>
	</tr>  
	<tr>
		<td width="15%" style="text-align: right;">&nbsp;</td>
		<td width="30%"><html:radio property="doanKNTC" value="1" onclick="changeDoanKntc(this.value);"  />Một người</td>
		<td width="30%"><html:radio property="doanKNTC" value="2" onclick="changeDoanKntc(this.value);" />Đông người có cử đại diện</td>
		<td width="25%"><html:radio property="doanKNTC" value="3" onclick="changeDoanKntc(this.value);"  />Đông người không cử đại diện <font color="red">(Xử lý từng người giống trường hợp một người)</font></td>
	</tr>
</table>
<DIV id="idDivSl" style="display: none">
<table width="100%">
	<tr>
		<td width="15%" style="text-align: right;">Số lượng người</td>
		<td width="35%"><html:text property="doanKNTCSoLuong" maxlength="5"/></td>
		<td width="15%" style="text-align: right;"></td>
		<td width="35%"></td>
	</tr>
</table>
</DIV>
</fieldset>
<fieldset><legend>Trường hợp đến KNTC</legend>
<table width="100%">
	<tr>
		<td width="15%" style="text-align: right;">Phân loại đơn</td>
		<td width="35%"><html:select property="thamQuyenDon" style="width:100%" styleId="thamQuyenDon" >
			<html:option value="1">Thuộc thẩm giải quyết của CQT nhận đơn</html:option>
			<html:option value="0">Không thuộc thẩm quyền của CQT nhận đơn</html:option>
		</html:select></td>
		<td width="15%" style="text-align: right;"></td>
		<td width="35%"></td>
	</tr>
	<tr>
		<td width="15%" style="text-align: right;">Trường hợp</td>
		<td width="35%"><html:select property="loaiKNTC" style="width:100%" styleId="loaiKNTC" onchange="changeKNTC()">
			<html:option value="1">Khiếu nại</html:option>
			<html:option value="2">Tố cáo</html:option>
			<html:option value="4">Phản ánh,kiến nghị</html:option>
			<html:option value="3">Trường hợp khác</html:option>
		</html:select></td>
		<td width="15%" style="text-align: right;"></td>
		<td width="35%"></td>
	</tr>
	<tr>
		<td></td>
		<td>
		<div id="idKNType"><html:checkbox property="isKNTCTrucTiep" value="1" onclick="changeKNTCTrucTiep();" /> Không phải Khiếu nại trực tiếp</div>
		</td>
		<td style="text-align: right;"></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td>
		<div id="idUyQuyen"><html:select property="uyQuyen" style="width:100%" styleId="uyQuyen" onchange="changeUyQuyen();">
			<html:option value="1">Được ủy quyền của cá nhân</html:option>
			<html:option value="2">Đại diện cho cơ quan, tổ chức</html:option>
		</html:select></div>
		</td>
		<td></td>
		<td></td>
	</tr>
</table>
</fieldset>
<fieldset><legend>Thông tin công dân</legend>
<table width="100%">
	<tr>
		<td width="15%" style="text-align: right;">Ngày tiếp <font color="red">*</font></td>
		<td width="35%"><html:text property="ngayTiep" maxlength="10" style="width: 40%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /> <A href="#" onclick="openDsHoSo();"><font color="red"> Kiểm tra hồ sơ liên quan </font></A></td>
		<td width="15%" style="text-align: right;">Địa chỉ <font color="red">*</font></td>
		<td width="35%"><html:text property="congdanDiaChi" style="width: 100%" styleId="congdanDiaChi" /></td>
	</tr>
	<tr>
		<td style="text-align: right;">Họ tên <font color="red">*</font></td>
		<td><html:text property="congdanTen" style="width: 100%" styleId="condanTen" /></td>
		<td style="text-align: right;">Điện thoại</td>
		<td><html:text property="congdanDienThoai" style="width: 100%" maxlength="20"/></td>
	</tr>
	<tr>
		<td style="text-align: right;">Chức vụ</td>
		<td><html:text property="congdanChucVu" style="width: 100%" /></td>
		<td style="text-align: right;">CMT/Hộ chiếu</td>
		<td><html:text property="congdanCMT" style="width: 100%" /></td>
	</tr>
	<tr>
		<td style="text-align: right;">Nơi công tác</td>
		<td><html:text property="congdanNoiCongTac" style="width: 100%" /></td>
		<td style="text-align: right;">Ngày cấp CMND/Hộ chiếu</td>
		<td><html:text property="congdanCMTNgayCap" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
	</tr>
	<tr>
		<td style="text-align: right;">Mã số thuế</td>
		<td><html:text property="congdanMST" style="width: 100%" /></td>
		<td style="text-align: right;">Nơi cấp CMND/Hộ chiếu</td>
		<td><html:text property="congdanCMTNoiCap" style="width: 100%" /></td>
	</tr>
	<tr>
		<td style="text-align: right;">Có luật sư đi cùng</td> 
		<td><html:checkbox property="coLuatSu" value="1" onclick="changeLuatSu();" /></td> 
		<td style="text-align: right;display: none;" class="daiDienBs" >Thông tin nhiều người đại diện</td>
		<td class="daiDienBs"  style="display: none"><html:checkbox property="coThemDaiDien" value="1" onclick="changeBoSungDd();" /></td> 
	</tr>
</table>
</fieldset>
<DIV id="idDivLS" style="display: none">
<fieldset><legend>Thông tin luật sư (tư vấn)</legend>
<table width="100%">
	<tr>
		<td width="15%" style="text-align: right;">Họ tên <font color="red">*</font></td>
		<td width="35%"><html:hidden property="luatsuMa" /> <html:text property="luatsuTen" style="width: 100%" /></td>
		<td width="15%" style="text-align: right;">Địa chỉ</td>
		<td width="35%"><html:text property="luatsuDiaChi" style="width: 100%" /></td>
	</tr>
	<tr>
		<td style="text-align: right;">Nơi công tác</td>
		<td><html:text property="luatsuNoiCongTac" style="width: 100%" /></td>
		<td style="text-align: right;">Điện thoại</td>
		<td><html:text property="luatsuDienThoai" style="width: 100%" /></td>
	</tr>
	<tr>
		<td style="text-align: right;">CMT/Hộ chiếu <font color="red">*</font></td>
		<td><html:text property="luatsuCMT" style="width: 100%" /></td>
		<td style="text-align: right;">Số thẻ</td>
		<td><html:text property="luatsuSoThe" style="width: 100%" /></td>
	</tr>
</table>
<fieldset><legend>Thông tin giấy yêu cầu</legend>
<table width="100%">
	<tr>
		<td width="15%" style="text-align: right;">Số giấy yêu cầu</td>
		<td width="35%"><html:text property="luatsuHDMa" style="width: 100%" /></td>
		<td width="15%" style="text-align: right;">Nội dung yêu cầu</td>
		<td width="35%"><html:textarea property="luatsuHDNoiDung" onkeypress="imposeMaxLength(this);" style="width: 100%;height:40px" /></td>
	</tr>
</table>
</fieldset>
</fieldset>
</DIV>

<!-- thong tin bo sung dai dien -->
<DIV id="idDivDd" style="display: none">
<fieldset><legend>Thông tin người đại diện bổ sung</legend>
<table width="100%">
	<tr>
		<td><html:textarea property="daiDienBsNoiDung" onkeypress="imposeMaxLength(this);" style="width: 100%;height:100px" /></td>
	</tr>
</table>
</fieldset>
</DIV>
<fieldset><legend>Thông tin cán bộ tiếp dân</legend>
<table width="100%">
	<tr>
		<td width="15%" style="text-align: right;">Nơi tiếp dân</td>
		<td width="35%"><html:text property="noiTiepDan" style="width: 100%" readonly="true" /></td>
		<td width="15%" style="text-align: right;">Chức vụ</td>
		<td width="35%"><html:text property="canBoChucVu" style="width: 100%" readonly="true" /></td>
	</tr>
	<tr>
		<td style="text-align: right;">Họ tên</td>
		<td><html:hidden property="canBoMa" /> <html:text property="canBoTen" readonly="true" style="width:100%" /></td>
		<td style="text-align: right;">Bộ phận công tác</td>
		<td><html:text property="canBoNoiCongTac" readonly="true" style="width: 100%" /></td>
	</tr>
</table>
</fieldset>
