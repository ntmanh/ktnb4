<%@page pageEncoding="UTF-8" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:hidden property="idDaiDienBenGiaoBanGianHoSoLuuTru" />
<html:hidden property="idDaiDienBenNhanBanGianHoSoLuuTru" />
<html:hidden property="idBanGiaoHoSoLuuTru" />
<html:hidden property="loaiBanGianHoSoLuuTru" />
<html:hidden property="idDsTvdGiaoNhan" />
<SELECT id="cbDsTvdGiaoNhan" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="dsTvdGiaoNhan" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<TABLE width="100%" align="center">
	<tr>
		<td width="19%" align="right">Thời điểm bắt đầu bàn giao <font color=red>*</font></td>
		<td style="width: 1%; min-width: 5px"></td>
		<td width="30%"><html:text styleClass="text" property="thoiDiemBatDauBanGianHoSoLuuTru" onblur="if(!isTime(this)) return;validateDateRequired(this);" onkeypress="return formatTime(event, this)"></html:text></td>
		<td width="19%" align="right">Địa điểm <font color=red>*</font></td>
		<td style="width: 1%; min-width: 5px"></td>
		<td width="30%"><html:text styleClass="text" property="diaDiemBBGN"></html:text></td>
	</tr>
	<tr>
		<td align="right">Đại diện bên giao báo cáo, hồ sơ, tài liệu <font color=red>*</font></td>
		<td style="width: 1%; min-width: 5px"></td>
		<td colspan="4">
		<fieldset style="margin: 0">
		<TABLE width="100%" id="tblDaiDienBenNhanHsTL" style="margin-top: 10px">
			<tr class="TdHeaderList">
				<td align="center" width="10%">STT</td>
				<td width="40%">Ông/Bà</td>
				<td width="40%">Chức vụ</td>
				<td align="center" width="10%"><INPUT type="checkbox"></td>
			</tr>
			<logic:present name="YeuCauCungCapHstlForm" property="arrDaiDienBenNhanHstlLuuTru">
				<logic:iterate id="ttptCqtBanHanhQd" name="YeuCauCungCapHstlForm" property="arrDaiDienBenNhanHstlLuuTru" indexId="index">
					<tr class='row<%=(index.intValue() % 2)+1 %>'>
						<td align="center"><%=index.intValue() + 1%></td>
						<td><html:hidden name="YeuCauCungCapHstlForm" property='<%="arrDaiDienBenNhanHstlLuuTru[" + index + "].idCanBo"%>' /> <html:text styleClass="text" name="YeuCauCungCapHstlForm" property='<%="arrDaiDienBenNhanHstlLuuTru[" + index + "].hoTen"%>' style="width:75%">
						</html:text> <INPUT type="button" onclick="<%="chonNhanVienCqtBanHanh(" + index+ ")"%>" value="..." class="lovButton"></td>
						<td><html:text styleClass="text1" name="YeuCauCungCapHstlForm" property='<%="arrDaiDienBenNhanHstlLuuTru[" + index + "].chucVu"%>' readonly="true" style="border-bottom:none; width:100%">
						</html:text></td>
						<td align="center"><INPUT type="checkbox"></td>
					</tr>
				</logic:iterate>
			</logic:present>
		</TABLE>
		<DIV style="text-align: right; width: 100%"><INPUT type="button" onclick="themDaiDienBenNhanHstl()" value="Thêm" class="button"> <INPUT type="button" id="xoaDaiDienBenNhanHsTL" value="Xóa" class="button"></DIV>
		</fieldset>
		</td>
	</tr>
	<tr>
		<td align="right">Đại diện bên nhận báo cáo, hồ sơ, tài liệu <font color=red>*</font></td>
		<td></td>
		<td colspan="4">
		<fieldset style="margin: 0">
		<TABLE width="100%" id="tblDaiDienBenGiaoHsTL" style="margin-top: 10px">
			<tr class="TdHeaderList">
				<td align="center" width="10%">STT</td>
				<td width="40%">Ông/Bà <font color=red>*</font></td>
				<td width="40%">Chức vụ <font color=red>*</font></td>
				<td align="center" width="10%"><INPUT type="checkbox"></td>
			</tr>
			<logic:present name="YeuCauCungCapHstlForm" property="arrDaiDienBenGiaoHstlLuuTru">
				<logic:iterate id="ttptCqtBanHanhQd" name="YeuCauCungCapHstlForm" property="arrDaiDienBenGiaoHstlLuuTru" indexId="index">
					<tr class='row<%=(index.intValue() % 2)+1 %>'>
						<td align="center"><%=index.intValue() + 1%></td>
						<td><html:select property='<%="arrDaiDienBenGiaoHstlLuuTru[" + index + "].idCanBo"%>' onclick="cacheOldValue(this)" onchange="getChucVuNguoiDaiDienBenGiao(this)" style="width:85%">
							<OPTION value=""></OPTION>
							<html:options collection="dsTvdGiaoNhan" property="idCanBo" labelProperty="tenCanBo" />
						</html:select> <html:hidden property='<%="arrDaiDienBenGiaoHstlLuuTru[" + index + "].hoTen"%>' /></td>
						<td><html:text styleClass="text1" name="YeuCauCungCapHstlForm" property='<%="arrDaiDienBenGiaoHstlLuuTru[" + index + "].chucVu"%>' readonly="true" style="border-bottom:none; width:100%">
						</html:text></td>
						<td align="center"><INPUT type="checkbox"></td>
					</tr>
				</logic:iterate>
			</logic:present>
		</TABLE>
		<DIV style="text-align: right; width: 100%"><INPUT type="button" onclick="themDaiDienBenGiaoHstl()" value="Thêm" class="button"> <INPUT type="button" id="xoaDaiDienBenGiaoHsTL" value="Xóa" class="button"></DIV>
		</fieldset>
		</td>
	</tr>
	<tr>
		<td align="right" width="19%">Báo cáo</td>
		<td width="1%"></td>
		<td width="80%" colspan="4"><html:textarea styleClass="textareaContent" property="baoCaoBanGianHoSoLuuTru" onkeypress="imposeMaxLength(this);" /></td>
	</tr>
	<tr>
		<td align="right" width="19%">Hồ sơ tài liệu</td>
		<td width="1%"></td>
		<td width="80%" colspan="4"><html:textarea styleClass="textareaContent" property="hoSoBanGianHoSoLuuTru" onkeypress="imposeMaxLength(this);" /></td>
	</tr>
	<tr>
		<td width="19%" align="right">Thời điểm kết thúc <font color=red>*</font></td>
		<td style="width: 1%; min-width: 5px"></td>
		<td width="30%"><html:text styleClass="text" property="thoiDiemKTBBGN" onblur="if(!isTime(this)) return;validateDateRequired(this);"  onkeypress="return formatTime(event, this)"></html:text></td>
		<td align="right" colspan="3"><INPUT type="button" class="button1" onclick="inBBGiaoNhan()" value="In biên bản bàn giao"></td>
	</tr>
</TABLE>
<script language="javascript">
var tmpIdCanBo;
var tmpTenCanBo;
var tmpChucVu;
function cacheOldValue(controlIdTvd){
	tmpIdCanBo = controlIdTvd.value;
	tmpTenCanBo = document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value;
	tmpChucVu = document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value;
}


function existInSelected(controlIdTvd){
	for(var i = 0; i< bangDaiDienBenGiao.numOfRow - 1; i++){
		element = document.getElementsByName('arrDaiDienBenGiaoHstlLuuTru[' + i + '].idCanBo')[0];
		if(element != null && element != controlIdTvd && element.value == controlIdTvd.value)
			return true;			
	}
	return false;
}

function getChucVuNguoiDaiDienBenGiao(controlIdTvd){
	if(existInSelected(controlIdTvd)){
		alert('Thành viên đoàn này đã tồn tại!');
		//controlIdTvd.value = '';
		controlIdTvd.value = tmpIdCanBo;
		document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = tmpChucVu;
		document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = tmpTenCanBo;
		controlIdTvd.focus();    
		return;              
	}
	dschitietTvd = document.getElementById('cbDsTvdGiaoNhan');
	for(var i = 0; i< dschitietTvd.length; i++){
		if(dschitietTvd[i].value == controlIdTvd.value){
			chucVuEn = dschitietTvd[i].title;
			document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = dschitietTvd[i].text;
			document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = getChucVuCoDau(chucVuEn);			
			return;
		}        
	}
	
}

function getChucVuNguoiDaiDienBenGiao_old(index){
	cbCanBoGiaoNhan = document.getElementById('cbDsTvdGiaoNhan');
	for(var i = 0; i< cbCanBoGiaoNhan.length; i++){
		if(cbCanBoGiaoNhan[i].value == document.getElementsByName('arrDaiDienBenGiaoHstlLuuTru[' + index + '].idCanBo')[0].value){
			chucVuEn = cbCanBoGiaoNhan[i].title;
			document.getElementsByName('arrDaiDienBenGiaoHstlLuuTru[' + index + '].chucVu')[0].value = getChucVuCoDau(chucVuEn);
			document.getElementsByName('arrDaiDienBenGiaoHstlLuuTru[' + index + '].hoTen')[0].value = cbCanBoGiaoNhan[i].text;     
			return;
		}
	}
}


function validateNgayLapPhieu(){
	ngaylp = document.getElementsByName('ngayLapYeuCau')[0].value;
	if(d2n(ngaylp) > d2n(document.getElementsByName('thoiDiemBatDauBanGianHoSoLuuTru')[0].value.split(' ')[1])){
		alert('Ngày bàn giao biên bản giao nhận không được trước ngày lập phiếu!');
		document.getElementsByName('thoiDiemBatDauBanGianHoSoLuuTru')[0].focus();
		return false;		
	}
	return true;
}

var bangDaiDienBenGiao = new TableObject("tblDaiDienBenGiaoHsTL", true, "xoaDaiDienBenGiaoHsTL");
var bangDaiDienBenNhan = new TableObject("tblDaiDienBenNhanHsTL", true, "xoaDaiDienBenNhanHsTL");
function inBienBanBanGiao(){
}
function themDaiDienBenNhanHstl(){
	bangDaiDienBenNhan.addRow(createNewDaiDienBenNhanHstl());
}
function createNewDaiDienBenNhanHstl(){
	arrDaiDienCqBanHanhQD = new Array(); 
	index = bangDaiDienBenNhan.numOfRow - 1; 
	arrDaiDienCqBanHanhQD[0] = '<input type="hidden" name="arrDaiDienBenNhanHstlLuuTru[' + index + '].idCanBo">'
	arrDaiDienCqBanHanhQD[0] += '<input type="text" name="arrDaiDienBenNhanHstlLuuTru[' + index + '].hoTen" class="text" onchange = "chonNhanVienCqtBanHanh1(' + index + ')" style="width:75%">'				
	arrDaiDienCqBanHanhQD[0] += '<Input type="button" class = "lovButton" value="..." onclick="chonNhanVienCqtBanHanh1('+index+')">'
	arrDaiDienCqBanHanhQD[1] = '<input type="text" name="arrDaiDienBenNhanHstlLuuTru[' + index + '].chucVu" class="text1" readonly="true" style="border-bottom:none; width:100%">'				
	arrDaiDienCqBanHanhQD[2] = '<input type="checkBox">'				
	return arrDaiDienCqBanHanhQD;
}
function themDaiDienBenGiaoHstl(){
	bangDaiDienBenGiao.addRow(createNewDaiDienDoanTtkt());
}
function createNewDaiDienDoanTtkt(){
	arrDaiDienDoanTtkt = new Array();
	index = bangDaiDienBenGiao.numOfRow - 1;
	arrDaiDienDoanTtkt[0] = '<SELECT name="arrDaiDienBenGiaoHstlLuuTru[' + index + '].idCanBo" onclick="cacheOldValue(this)" onchange="getChucVuNguoiDaiDienBenGiao(this)" style="width:85%">';	
	arrDaiDienDoanTtkt[0] += document.getElementById('cbDsTvdGiaoNhan').innerHTML;
	arrDaiDienDoanTtkt[0] += '</SELECT>';
	arrDaiDienDoanTtkt[0] += '<input type="hidden" name="arrDaiDienBenGiaoHstlLuuTru['+ index +'].hoTen" > ';
	arrDaiDienDoanTtkt[1] = '<INPUT type="text" class="text1" readonly="true" style="border-bottom:none; width:100%" name="arrDaiDienBenGiaoHstlLuuTru[' + index + '].chucVu"> ';
	arrDaiDienDoanTtkt[2] = '<INPUT type=checkbox>';
	return arrDaiDienDoanTtkt;
}
function onLoadBanGiaoHsLuuTru(){
}



       
function chonNhanVienCqtBanHanh1(index){
	// id, ten
	hiddenIdCanBo = document.getElementsByName('arrDaiDienBenNhanHstlLuuTru['+ index + '].idCanBo')[0];
	txtTenCanBo = document.getElementsByName('arrDaiDienBenNhanHstlLuuTru['+ index + '].hoTen')[0];
	// Chuc vu
	chucVuCongTacCol = document.getElementsByName('arrDaiDienBenNhanHstlLuuTru['+ index + '].chucVu')[0];
	txtChucVu = document.getElementsByName('arrDaiDienBenNhanHstlLuuTru['+ index + '].chucVu')[0];
	
	type = 'daidienBBGN';
	showLovNhanVien(maCqtDuocTtkt, txtTenCanBo);
	
}

function validateDaiDienBenGiaoNhan(){
	if(bangDaiDienBenGiao.numOfRow == 1){
		alert('Bạn phải nhập đại diện bên giao của Biên bản giao nhận');
		return false;
	}
	for(i = 1; i< bangDaiDienBenGiao.numOfRow; i++){
		if(!isRequired(document.getElementsByName('arrDaiDienBenGiaoHstlLuuTru['+ eval(i-1) +'].idCanBo')[0]))
			return false;
	}
		
	return true;
}
function validateBanGiaoNhan(){
		if(isEmpty(document.getElementsByName('idYeuCau')[0].value)){
			alert('Phải lưu phiếu yêu cầu trước!');
			return false;
		}
		if(!validateNgayLapPhieu()){
			return false;
		}
		
		if(!isRequired(document.getElementsByName('thoiDiemBatDauBanGianHoSoLuuTru')[0]))
		return false;
		if(!isRequired(document.getElementsByName('diaDiemBBGN')[0]))
		return false;
		if( !validateDaiDienBenGiaoNhan())
		return false;
		if(!isRequired(document.getElementsByName('thoiDiemKTBBGN')[0]))
		return false;
		if(!compareTime(document.getElementsByName('thoiDiemBatDauBanGianHoSoLuuTru')[0], document.getElementsByName('thoiDiemKTBBGN')[0], '<', 'Thời điểm kết thúc phải sau thời điểm bắt đầu!'))
		return false;
	return true;
	}
function existCheck2(table, thisCbo){
	for(i =1;i<table.numOfRow-1;i++){
		var	cbo =  document.getElementsByName('arrDaiDienBenGiaoHstlLuuTru['+ eval(i-1) +'].idCanBo')[0] ;
		if(cbo.value == thisCbo.value){
		alert('Dữ liệu đã tồn tại');
		thisCbo.selectedIndex = 0;
		return false;
		}
	}
}
function inBBGiaoNhan()
{		
		if(!validateBanGiaoNhan()) return false;
		//document.forms[0].action = 'yeu_cau_cung_cap_tai_lieu.do?method=in&type=bbGiaoNhan'
		//document.forms[0].submit();
		//document.forms[0].action = 'yeu_cau_cung_cap_tai_lieu.do';   
		var printfForm = findForm('/' + contextRoot + '/yeu_cau_cung_cap_tai_lieu.do?method=save&type=bbgiaonhan'); 	   
		printfForm.action = 'yeu_cau_cung_cap_tai_lieu.do?method=in&type=bbGiaoNhan&idCuocTtkt='+document.getElementsByName('idCuocTtKtl')[0].value;     
		printfForm.submit();                                                           
		printfForm.action = '/' + contextRoot + '/yeu_cau_cung_cap_tai_lieu.do?method=save&type=bbgiaonhan'; 
}
</script>
