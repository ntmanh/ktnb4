<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:hidden property="idYeuCau" />
<html:hidden property="idDsTvdPhieuYc" />
<SELECT id="cbDsTvdPhieuYc" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="dsTvdYeuCau" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<TABLE width="100%" align="center">
	<TBODY>
		<tr>
			<td align="right" width="19%">Yêu cầu lần thứ <font color=red>*</font></td>
			<td width="1%"></td>
			<td colspan="4" align="left"><html:text property="lanYeuCau" styleClass="text" onkeypress="return nokeypress(event);" onblur="isNumber(this,'i')" style="width:7%">
			</html:text></td>
		</tr>
		<tr>
			<td align="right" width="19%">Nơi lập phiếu <font color=red>*</font></td>
			<td width="1%"></td>
			<td align="left" width="30%"><html:text property="noiLapYeuCau" styleClass="text"></html:text></td>
			<td align="right" width="19%">Ngày lập phiếu <font color=red>*</font></td>
			<td width="1%"></td>
			<td align="left" width="30%"><html:text property="ngayLapYeuCau" styleClass="text" onblur="if(!isDate(this)) return;validateDateRequired(this);"  onkeypress="return formatDate(event, this)"></html:text></td>
		</tr>
		<tr>
			<td colspan="6">
			<fieldset style="padding: 15px"><legend> Nội dung yêu cầu bổ sung</legend>
			<TABLE align="center" style="margin-top: 10px; width: 100%">
				<tr>
					<td align="right" style="width: 17%">Báo cáo</td>
					<td style="width: 1%"></td>
					<td align="left" style="width: 82%"><html:textarea styleClass="textareaContent" property="baoCao" onkeypress="imposeMaxLength(this);" /></td>
				</tr>
				<tr>
					<td align="right" style="width: 17%">Hồ sơ, tài liệu</td>
					<td style="width: 1%"></td>
					<td align="left" style="width: 82%"><html:textarea styleClass="textareaContent" property="hoSo" onkeypress="imposeMaxLength(this);" /></td>
				</tr>
			</TABLE>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td colspan="6">
			<table align="center" style="margin-top: 10px; width: 100%">
				<tr>
					<td align="right" style="width: 19%">Người nhận yêu cầu <font color=red>*</font></td>
					<td style="width: 1%"></td>
					<td align="left" style="width: 30%">
					<table style="margin: 0" border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
						<tr>
							<td align="left" width="90%" style="margin: 0"><html:text styleClass="text" onchange="chonNgNhanPhieuYc()" property="tenNgNhanPhieuYc" style="width:100%"></html:text></td>
							<td align="left" width="10%" style="margin: 0"><INPUT type="button" onclick="chonNgNhanPhieuYc()" value="..." class="lovButton"> <html:hidden property="idNgNhanPhieuYc" /></td>
						</tr>
					</table>
					</td>
					<td align="right" style="width: 19%">Chức vụ <font color=red>*</font></td>
					<td style="width: 1%"></td>
					<td align="left" style="width: 30%"><html:text styleClass="text" property="chucVuNgNhanPhieuYc" readonly="true"></html:text></td>
				</tr>
				<tr>
					<td align="right" style="width: 19%">Thời điểm nhận phiếu <font color=red>*</font></td>
					<td style="width: 1%"></td>
					<td align="left" style="width: 30%"><html:text styleClass="text" property="thoiDiemNhanPhieuYc" onblur="if(!isTime(this)) return;validateDateRequired(this);"  onkeypress="return formatTime(event, this)"></html:text></td>
					<td align="right" style="width: 19%">Địa điểm <font color=red>*</font></td>
					<td style="width: 1%"></td>
					<td align="left" style="width: 30%"><html:text styleClass="text" property="diaDiemNhanPhieuYc"></html:text></td>
				</tr>
				<tr>
					<td align="right" style="width: 19%">Thời điểm cung cấp <font color=red>*</font></td>
					<td style="width: 1%"></td>
					<td align="left" style="width: 30%"><html:text styleClass="text" property="thoiDiemCungCap" onblur="if(!isTime(this)) return;validateDateRequired(this);"  onkeypress="return formatTime(event, this)"></html:text></td>
					<td align="right" style="width: 19%">Địa điểm cung cấp <font color=red>*</font></td>
					<td style="width: 1%"></td>
					<td align="left" style="width: 30%"><html:text styleClass="text" property="diaDiemCungCap"></html:text></td>
				</tr>
				<tr>
					<td align="right" style="width: 19%">Người nhận báo cáo, hồ sơ, tài liệu<font color=red>*</font></td>
					<td style="width: 1%"></td>
					<td align="left" style="width: 30%"><html:select property="idNguoiNhanBc" styleId="idNguoiNhanBc" onchange="getChucVuNguoiNhanBc()" style="width:100%">
						<OPTION value=""></OPTION>
						<html:options collection="dsTvdYeuCau" property="idCanBo" labelProperty="tenCanBo" />
					</html:select> <html:hidden property="tenCbNhanBc" /></td>
					<td align="right" style="width: 19%">Chức vụ <font color=red>*</font></td>
					<td style="width: 1%"></td>
					<td align="left" style="width: 30%"><html:text styleClass="text" property="chucVuNgNhanBc" readonly="true"></html:text></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td colspan="6" align="right"><INPUT type="button" class="button1" onclick="inPhieuYeuCauxxxxxx()" value="In phiếu yêu cầu"></td>
		</tr>
	</TBODY>
</TABLE>
<script language="javascript">
function getChucVuCanBoYeuCau(){ 
	cbCanBoYeuCau = document.getElementById('cbDsTvdPhieuYc');
	for(var i = 0; i< cbCanBoYeuCau.length; i++){
		if(cbCanBoYeuCau[i].value == document.getElementsByName('idCbYeuCau')[0].value){
			chucVuEn = cbCanBoYeuCau[i].title;
			document.getElementsByName('chucVuCbYeuCau')[0].value = getChucVuCoDau(chucVuEn);
			document.getElementsByName('tenCbYeuCau')[0].value = cbCanBoYeuCau[i].text;
			return;
		}
	}
}
function getChucVuNguoiNhanBc(){
	cbCanBoYeuCau = document.getElementById('cbDsTvdPhieuYc');
	for(var i = 0; i< cbCanBoYeuCau.length; i++){
		if(cbCanBoYeuCau[i].value == document.getElementsByName('idNguoiNhanBc')[0].value){
			chucVuEn = cbCanBoYeuCau[i].title;
			document.getElementsByName('chucVuNgNhanBc')[0].value = getChucVuCoDau(chucVuEn);
			document.getElementsByName('tenCbNhanBc')[0].value = cbCanBoYeuCau[i].text;
			return;
		}
	}
}

function validatePhieuYeuCau(){
		if(!isRequired(document.getElementsByName('lanYeuCau')[0]))
		return false;
		if(!isRequired(document.getElementsByName('noiLapYeuCau')[0]))
		return false; 
		if(!isRequired(document.getElementsByName('ngayLapYeuCau')[0]))
		return false;
		if(!isRequired(document.getElementsByName('thoiDiemNhanPhieuYc')[0]))
		return false;
		if(!isRequired(document.getElementsByName('diaDiemCungCap')[0]))
		return false;
		if(!isRequired(document.getElementsByName('idNguoiNhanBc')[0]))
		return false;
		if(!isRequired(document.getElementsByName('chucVuNgNhanBc')[0]))
		return false;
		if(!isRequired(document.getElementsByName('thoiDiemCungCap')[0]))
		return false;
		if(!isRequired(document.getElementsByName('tenNgNhanPhieuYc')[0]))
		return false;
		if(!isRequired(document.getElementsByName('chucVuNgNhanPhieuYc')[0]))
		return false;
		return true;
}
function onLoadYeuCau(){
		//load du lieu cho the select don vi ca nhan thuc hien
		loadTenDvCaNhaThucHien(document.getElementById('idCbYeuCau'),document.getElementById('tenCbYeuCau'));
		loadTenDvCaNhaThucHien(document.getElementById('idNgNhanPhieuYc'),document.getElementById('tenNgNhanPhieuYc'));
		loadTenDvCaNhaThucHien(document.getElementById('idNguoiNhanBc'),document.getElementById('tenCbNhanBc'));
	}
var idCanBoConTrol;
var tenCanBoConTrol;
var donViCongTacControl;
var chucVuConTrol;
function chonNgNhanPhieuYc(){

		// Id
		hiddenIdCanBo = document.getElementsByName('idNgNhanPhieuYc')[0];
		// Ten
		txtTenCanBo = document.getElementsByName('tenNgNhanPhieuYc')[0];
		
		// Chuc vu
		txtChucVu = document.getElementsByName('chucVuNgNhanPhieuYc')[0];
		
		showLovNhanVien(maCqtDuocTtkt, txtTenCanBo)
		   
		win.focus(); 
}

var hiddenIdCanBo;
var txtTenCanBo;
var txtChucVu;
function setThongTinNhanVienFromLov(maCanBo, tenCanBo, chucVu, tenPhong, tenCqt){	
	hiddenIdCanBo.value = maCanBo;
	// Ten 
	txtTenCanBo.value = tenCanBo;
	// Chuc vu
	txtChucVu.value = chucVu;
}

function setTenDvCaNhaThucHien(cbDsCanbo,name){
		name.value = cbDsCanbo[cbDsCanbo.selectedIndex].text;
	}
	
function loadTenDvCaNhaThucHien(cbDsCanbo,ten){
		 for(var i=0;i< cbDsCanbo.length;i++ )
		 {
		 	if(cbDsCanbo.options[i].text == ten.value)
		 		cbDsCanbo.selectedIndex = i;
		 }
	}
	 
	
function getChucVu(cbThanhVienDoan,chucVuTextBox,name){ 
		//var chucVuVn = document.getElementsByName(chucVuTextBox)[0];
		var chucVu = findChucVuById(cbThanhVienDoan.value);
		setTenDvCaNhaThucHien(cbThanhVienDoan,name); 
   			if(cbThanhVienDoan[cbThanhVienDoan.selectedIndex].text == ""){
			chucVuTextBox.value = '';
			return;
		} 
	switch (chucVu){
		case "Truong doan":
			chucVuTextBox.value = "Trưởng đoàn"
			break;
		case "Pho doan":
			chucVuTextBox.value = "Phó đoàn"
			break;
		default:
			chucVuTextBox.value = "Thành viên đoàn"
			break;
	}
}
function inPhieuYeuCauxxxxxx(){   
	if(!validatePhieuYeuCau()) 
		return false ;  
	var printfForm = findForm('/' + contextRoot + '/yeu_cau_cung_cap_tai_lieu.do?method=save&type=phieuyeucau'); 	   
	printfForm.action = 'yeu_cau_cung_cap_tai_lieu.do?method=in&type=phieuYeuCau&idCuocTtkt='+document.getElementsByName('idCuocTtKtl')[0].value;     
	printfForm.submit();                                                           
	printfForm.action = '/' + contextRoot + '/yeu_cau_cung_cap_tai_lieu.do?method=save&type=phieuyeucau';   
}
</script>
