<%@page pageEncoding="UTF-8" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<SELECT id="cbDsTvdBanGiaoLTHS" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="dsThanhVienDoan" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<html:form action="ket_thuc_ttkt.do?method=save&type=banGiaoHoSoLuuTru" method="POST">
	<TABLE width="100%">
		<tr>
			<td width="19%" align="right">Thời điểm bắt đầu bàn giao <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="30%"><html:text styleClass="text" property="thoiDiemBatDauBanGianHoSoLuuTru" onblur="if(!isTime(this)) return; validateNgayBgHsLuuTru()" onkeypress="return formatTime(event, this)"></html:text></td>
			<td width="19%" align="right">Địa điểm <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="30%"><html:text styleClass="text" property="diaDiemBanGiaoHoSoLuuTru">
			</html:text></td>
		</tr>
		<tr>
			<td align="right">Đại diện bên giao</td>
			<td></td>
			<td colspan="4">
			<fieldset style="margin: 0">
			<TABLE width="100%" id="tblDaiDienBenGiaoHsTL">
				<tr class="TdHeaderList">
					<td align="center" width="10%">STT</td>
					<td width="40%">Ông/Bà <font color=red>*</font></td>
					<td width="40%">Chức vụ <font color=red>*</font></td>
					<td align="center" width="10%"><INPUT type="checkbox"></td>
				</tr>
				<logic:present name="KetThucTtktForm" property="arrDaiDienBenGiaoHstlLuuTru">
					<logic:iterate id="ttptCqtBanHanhQd" name="KetThucTtktForm" property="arrDaiDienBenGiaoHstlLuuTru" indexId="index">
						<tr class='row<%=(index.intValue() % 2)+1 %>'>
							<td align="center"><%=index.intValue() + 1%></td>
							<td><html:select property='<%="arrDaiDienBenGiaoHstlLuuTru[" + index + "].idCanBo"%>' onclick="cacheOldValue(this)" onchange="changeThanhVienDoan(this)" style="width:85%">
								<html:options collection="dsThanhVienDoan" property="idCanBo" labelProperty="tenCanBo" />
							</html:select> <html:hidden name="KetThucTtktForm" property='<%="arrDaiDienBenGiaoHstlLuuTru[" + index + "].hoTen"%>' /></td>
							<td><html:text styleClass="text1" name="KetThucTtktForm" property='<%="arrDaiDienBenGiaoHstlLuuTru[" + index + "].chucVu"%>' style="border-bottom:none; width:100%" readonly="true">
							</html:text></td>
							<td align="center"><INPUT type="checkbox"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</TABLE>
			<DIV style="text-align: right; width: 100%;" align="right"><INPUT type="button" onclick="themDaiDienBenGiaoHstl()" value="Thêm"> <INPUT type="button" id="xoaDaiDienBenGiaoHsTL" value="Xóa"></DIV>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td align="right">Đại diện bên nhận</td>
			<td></td>
			<td colspan="4">
			<fieldset style="margin: 0">
			<TABLE width="100%" id="tblDaiDienBenNhanHsTL">
				<tr class="TdHeaderList">
					<td align="center" width="10%">STT</td>
					<td width="40%">Ông/Bà <font color=red>*</font></td>
					<td width="40%">Chức vụ <font color=red>*</font></td>
					<td align="center" width="10%"><INPUT type="checkbox"></td>
				</tr>
				<logic:present name="KetThucTtktForm" property="arrDaiDienBenNhanHstlLuuTru">
					<logic:iterate id="ttptCqtBanHanhQd" name="KetThucTtktForm" property="arrDaiDienBenNhanHstlLuuTru" indexId="index">
						<tr class='row<%=(index.intValue() % 2)+1 %>'>
							<td align="center"><%=index.intValue() + 1%></td>
							<td><html:hidden name="KetThucTtktForm" property='<%="arrDaiDienBenNhanHstlLuuTru[" + index + "].idCanBo"%>' /> <html:text styleClass="text" name="KetThucTtktForm" onchange='<%="chonNhanVienCqtBanHanh(" + index + ")"%>' property='<%="arrDaiDienBenNhanHstlLuuTru[" + index + "].hoTen"%>'
								style="width:75%">
							</html:text> <INPUT type="button" class="lovButton" onclick="chonNhanVienCqtBanHanh(<%=index%>)" value="..."></td>
							<td><html:text styleClass="text1" name="KetThucTtktForm" property='<%="arrDaiDienBenNhanHstlLuuTru[" + index + "].chucVu"%>' style="border-bottom:none; width:100%" readonly="true">
							</html:text></td>
							<td align="center"><INPUT type="checkbox"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</TABLE>
			<DIV style="text-align: right; width: 100%;" align="right"><INPUT type="button" onclick="themDaiDienBenNhanHstl()" value="Thêm"> <INPUT type="button" id="xoaDaiDienBenNhanHsTL" value="Xóa"></DIV>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td align="right">Báo cáo</td>
			<td align="right"></td>
			<td colspan="4">
				<html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  style="width: 100%" property="baoCaoBanGianHoSoLuuTru"></html:textarea>
			</td>
		</tr>
		<tr>
			<td align="right">Hồ sơ tài liệu</td>
			<td align="right"></td>
			<td colspan="4"><html:textarea styleClass="textareaTitle"  onkeypress="imposeMaxLength(this);"  style="width: 100%" property="hoSoBanGianHoSoLuuTru">
			</html:textarea></td>
		</tr>
		<tr>
			<td width="19%" align="right">Thời điểm kết thúc bàn giao <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="30%"><html:text styleClass="text" property="thoiDiemKetThucBanGianHoSoLuuTru" onblur="isTime(this)" onkeypress="return formatTime(event, this)">
			</html:text></td>
			<td width="19%" align="right"></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="30%"><INPUT type="button" class="button1" onclick="inBienBanBanGiao()" value="In biên bản bàn giao"></td>
		</tr>
	</TABLE>
	<html:hidden property="idDaiDienBenGiaoBanGianHoSoLuuTru" />
	<html:hidden property="idDaiDienBenNhanBanGianHoSoLuuTru" />
	<html:hidden property="idBanGiaoHoSoLuuTru" />
	<INPUT name="ngayTam" type="hidden">
	<INPUT name="ngayTam2" type="hidden">
</html:form>
<script language="javascript"> 
function validateNgayBgHsLuuTru(){	
	caculateDate('ngayRaKetLuan','ngayTam', strThoiHanBanGiaoHsLuuTru);
	document.getElementsByName("ngayTam2")[0].value = document.getElementsByName('thoiDiemBatDauBanGianHoSoLuuTru')[0].value.split(' ')[1];
	compareDate(document.getElementsByName('ngayTam2')[0], document.getElementsByName('ngayTam')[0], 'Cảnh báo quá hạn: Ngày bàn giao hồ sơ lưu trữ sau ngày ra kết luận quá ' + strThoiHanBanGiaoHsLuuTru + ' ngày!');		
}
var bangDaiDienBenGiao = new TableObject("tblDaiDienBenGiaoHsTL", true, "xoaDaiDienBenGiaoHsTL");
var bangDaiDienBenNhan = new TableObject("tblDaiDienBenNhanHsTL", true, "xoaDaiDienBenNhanHsTL");
function inBienBanBanGiao(){ 
	if(!validateBanGiaoHoSoLuuTru())
		return;
	var printfForm = findForm('/' + contextRoot + '/ket_thuc_ttkt.do?method=save&type=banGiaoHoSoLuuTru');	
	printfForm.action = 'ket_thuc_ttkt.do?method=in&type=banGiaoHoSoLuuTru&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	printfForm.submit();
	printfForm.action = '/' + contextRoot + '/ket_thuc_ttkt.do?method=save&type=banGiaoHoSoLuuTru';
}
function themDaiDienBenNhanHstl(){
	bangDaiDienBenNhan.addRow(createNewDaiDienBenNhanHstl());
}
function createNewDaiDienBenNhanHstl(){ 
	arrDaiDienCqBanHanhQD = new Array(); 
	index = bangDaiDienBenNhan.numOfRow - 1; 
	arrDaiDienCqBanHanhQD[0] = '<input type="hidden" name="arrDaiDienBenNhanHstlLuuTru[' + index + '].idCanBo">'
	arrDaiDienCqBanHanhQD[0] += '<input type="text" name="arrDaiDienBenNhanHstlLuuTru[' + index + '].hoTen" class="text" style="width:75%" onchange = "chonNhanVienCqtBanHanh('+ index + ')">'				
	arrDaiDienCqBanHanhQD[0] += '<Input type="button" class="lovButton" value="..." onclick="chonNhanVienCqtBanHanh('+ index + ')">'
	arrDaiDienCqBanHanhQD[1] = '<input type="text" name="arrDaiDienBenNhanHstlLuuTru[' + index + '].chucVu" class="text1" style="border-bottom:none; width:100%" readonly="true">'				
	arrDaiDienCqBanHanhQD[2] = '<input type="checkBox">'				
	return arrDaiDienCqBanHanhQD;
}
function themDaiDienBenGiaoHstl(){
	bangDaiDienBenGiao.addRow(createNewDaiDienDoanTtkt());
}


function existInSelected(controlIdTvd){
	for(var i = 0; i< bangDaiDienBenGiao.numOfRow - 1; i++){
		element = document.getElementsByName('arrDaiDienBenGiaoHstlLuuTru[' + i + '].idCanBo')[0];
		if(element != null && element != controlIdTvd && element.value == controlIdTvd.value)
			return true;			
	}
	return false;
}

function changeThanhVienDoan(controlIdTvd){
	if(existInSelected(controlIdTvd)){
		alert('Thành viên đoàn này đã tồn tại!');
		//controlIdTvd.value = '';
		controlIdTvd.value = tmpIdCanBo;
		document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = tmpChucVu;
		document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = tmpTenCanBo;
		controlIdTvd.focus();    
		return;              
	}
	dschitietTvd = document.getElementById('cbDsTvdBanGiaoLTHS');
	for(var i = 0; i< dschitietTvd.length; i++){
		if(dschitietTvd[i].value == controlIdTvd.value){
			chucVuEn = dschitietTvd[i].title;
			document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = dschitietTvd[i].text;
			document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = getChucVuCoDau(chucVuEn);			
			return;
		}        
	}
	//document.getElementsByName(cbThanhPhanThamDu.name.replace('.idCanBo', '.chucVu'))[0].value = getChucVuTvd(cbThanhPhanThamDu.value);	
	//document.getElementsByName(cbThanhPhanThamDu.name.replace('.idCanBo', '.hoTen'))[0].value = cbThanhPhanThamDu[cbThanhPhanThamDu.selectedIndex].text;	
}
function createNewDaiDienDoanTtkt(){
	arrDaiDienDoanTtkt = new Array();
	index = bangDaiDienBenGiao.numOfRow - 1;
	arrDaiDienDoanTtkt[0] = '<SELECT name="arrDaiDienBenGiaoHstlLuuTru[' + index + '].idCanBo" onclick="cacheOldValue(this)" onchange="changeThanhVienDoan(this)" style="width:85%">';	
	arrDaiDienDoanTtkt[0] += cbDsThanhVienDoan;
	arrDaiDienDoanTtkt[0] += '</SELECT>';
	arrDaiDienDoanTtkt[0] += '<INPUT type="hidden" name="arrDaiDienBenGiaoHstlLuuTru[' + index + '].hoTen"> ';
	arrDaiDienDoanTtkt[1] = '<INPUT type="text" class="text1" readonly="true" name="arrDaiDienBenGiaoHstlLuuTru[' + index + '].chucVu" style="border-bottom:none; width:100%"> ';
	arrDaiDienDoanTtkt[2] = '<INPUT type=checkbox>';
	return arrDaiDienDoanTtkt;
}
var strThoiHanBanGiaoHsLuuTru;
function onLoadBanGiaoHsLuuTru(){
	strThoiHanBanGiaoHsLuuTru = <%=(String)request.getAttribute("thoiHanBanGiaoHsLuuTru")%>
}
function setThongTinNhanVienFromLov(ma, ten, chucVu){
	var isExistCb = false;
	if(type == 'cqtBh'){
		for(var i = 0; i< bangDaiDienBenNhan.numOfRow - 1; i++){
			element = document.getElementsByName('arrDaiDienBenNhanHstlLuuTru[' + i + '].idCanBo')[0];
			if(element != null && element != hiddenIdCanBo && element.value == ma)
				isExistCb = true;
				
		}
	}
	if(isExistCb){
		window.focus();
		hiddenIdCanBo.value = '';
		txtTenCanBo.value = '';
		txtChucVu.value = '';
		return 'Cán bộ này đã tồn tại!';;
	}
	hiddenIdCanBo.value = ma;
	txtTenCanBo.value = ten;
	txtChucVu.value = chucVu;
	return '';
}
var hiddenIdCanBo;
var txtTenCanBo;
var txtChucVu;
var chucVuCongTacCol;
var type;
function chonNhanVienCqtBanHanh(index){	    
	// id, ten	
	hiddenIdCanBo = document.getElementsByName('arrDaiDienBenNhanHstlLuuTru[' + index + '].idCanBo')[0];
	txtTenCanBo = document.getElementsByName('arrDaiDienBenNhanHstlLuuTru[' + index + '].hoTen')[0];
		
	// Chuc vu cong tac
	chucVuCongTacCol = document.getElementsByName('arrDaiDienBenNhanHstlLuuTru[' + index + '].chucVu')[0];
	
	// Chuc vu
	txtChucVu = document.getElementsByName('arrDaiDienBenNhanHstlLuuTru[' + index + '].chucVu')[0];
	
	type = 'cqtBh';
	var maCqtBi = '<%=request.getAttribute("maCqtTh")%>';
	try{
	showLovNhanVien(maCqtBi, txtTenCanBo);	
	}catch(e){
	showLovNhanVien(maCqt, txtTenCanBo);	
	}
	
}
function validateDaiDienBenGiao(){
	if(bangDaiDienBenGiao.numOfRow <= 1){
		alert('Bạn phải nhập đại diện bên giao');
		return false;
	}
	for(i = 1; i< bangDaiDienBenGiao.numOfRow; i++){
		if(!isRequired(document.getElementsByName('arrDaiDienBenGiaoHstlLuuTru['+ eval(i-1) +'].idCanBo')[0]))
			return false;
	}
	return true;
}
function validateDaiDienBenNhan(){
	if(bangDaiDienBenNhan.numOfRow <= 1){
		alert('Bạn phải nhập đại diện bên nhận!');
		return false;
	}
	for(i = 1; i< bangDaiDienBenNhan.numOfRow; i++){
		if(!isRequired(document.getElementsByName('arrDaiDienBenNhanHstlLuuTru['+ eval(i-1) +'].hoTen')[0]))
			return false;
		if(!isRequired(document.getElementsByName('arrDaiDienBenNhanHstlLuuTru['+ eval(i-1) +'].chucVu')[0]))
			return false;
	}
	return true;
}
function validateBanGiaoHoSoLuuTru(){
	if(!isRequired(document.getElementsByName('thoiDiemBatDauBanGianHoSoLuuTru')[0]))
		return false;
	if(d2n(document.getElementsByName('thoiDiemBatDauBanGianHoSoLuuTru')[0].value.split(' ')[1]) < d2n(document.getElementsByName('ngayRaKetLuan')[0].value)){
		alert('Ngày bàn giao hồ sơ lưu trữ phải sau ngày ra kết luận!');
		document.getElementsByName('thoiDiemBatDauBanGianHoSoLuuTru')[0].focus();
		return false;
	}
	if(!isRequired(document.getElementsByName('diaDiemBanGiaoHoSoLuuTru')[0]))
		return false;
	if(!validateDaiDienBenGiao())
		return false;
	if(!validateDaiDienBenNhan())
		return false;
	if(!isRequired(document.getElementsByName('diaDiemBanGiaoHoSoLuuTru')[0]))
		return false;
	if(!isRequired(document.getElementsByName('thoiDiemKetThucBanGianHoSoLuuTru')[0]))
		return false;
	if(!compareTime(document.getElementsByName('thoiDiemBatDauBanGianHoSoLuuTru')[0], document.getElementsByName('thoiDiemKetThucBanGianHoSoLuuTru')[0], '<')){
		return false;
	}
	return true;
}
</script>
