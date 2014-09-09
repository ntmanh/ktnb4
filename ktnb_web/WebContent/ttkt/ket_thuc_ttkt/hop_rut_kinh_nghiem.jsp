<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<SELECT id="cbDsTvdHopRutKinhNghiem" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="chiTietDsTvd" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<html:form action="ket_thuc_ttkt.do?method=save&type=hopRutKinhNghiemDoan" method="POST">
	<table align="center" width="100%">
		<tr>
			<td align="right" width="19%">Th&#7901;i &#273;i&#7875;m b&#7855;t &#273;&#7847;u <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="30%"><html:text styleClass="text" onkeypress="return formatTime(event, this)" onblur="if(!isTime(this)) return;validateDateRequired(this);" property="thoiDiemBatDauHopRutKinhNghiem"></html:text></td>
			<td align="right" width="19%">&#272;&#7883;a &#273;i&#7875;m h&#7885;p <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="diaDiemHopRutKinhNghiem"></html:text></td>
		</tr>
		<tr>
			<td align="right" width="19%">V&#7873; vi&#7879;c <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="100%" colspan="4"><html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  style="width: 100%" property="veViecHopRutKinhNghiem"></html:textarea></td>
		</tr>
		<tr>
			<td align="right">Th&#224;nh ph&#7847;n tham d&#7921; <font color=red>*</font></td>
			<td></td>
			<td align="left" width="100%" colspan="4">
			<fieldset style="margin: 0" id="FIELDSET">
			<TABLE id="tb_DS_TPTD" width="100%">
				<tr class="TdHeaderList">
					<td width="10%" align="center">STT</td>
					<td width="40%">&#212;ng (b&#224;) <font color=red>*</font></td>
					<td width="40%">Ch&#7913;c v&#7909; <font color=red>*</font></td>
					<td align="center" width="10%"><INPUT type="checkbox"></td>
				</tr>
				<logic:present name="KetThucTtktForm" property="thanhPhanThamDuHopRutKinhNghiem">
					<logic:iterate name="KetThucTtktForm" property="thanhPhanThamDuHopRutKinhNghiem" indexId="index" id="thanhVienDoan">
						<tr class='row<%=(index.intValue() % 2)+1 %>'>
							<td align="center"><%=index.intValue() + 1%></td>
							<td><html:select name="KetThucTtktForm" onclick="cacheOldValue(this)" onchange="changeThanhVienDoanT(this)" property='<%="thanhPhanThamDuHopRutKinhNghiem[" + index + "].idCanBo"%>' style="width:85%">
								<html:options collection="chiTietDsTvd" property="idCanBo" labelProperty="tenCanBo" />
							</html:select> <html:hidden name="KetThucTtktForm" property='<%="thanhPhanThamDuHopRutKinhNghiem[" + index + "].hoTen"%>' /></td>
							<td><html:text styleClass="text1" name="KetThucTtktForm" property='<%="thanhPhanThamDuHopRutKinhNghiem[" + index + "].chucVu"%>' style="border-bottom:none; width:100%" readonly="true">
							</html:text></td>
							<td align="center"><INPUT type="checkbox"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</TABLE>
			<DIV align="right" style="text-align: right;"><INPUT type="button" onclick="themThanhPhanThamDu()" value="Th&#234;m" id="addRow"> <INPUT type="button" value="X&#243;a" id="xoaTblTpTdHopDoanTrienKhai"></DIV>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td align="right" width="19%">N&#7897;i dung <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="100%" colspan="4"><html:textarea styleClass="textareaContent" onkeypress="imposeMaxLength(this);"  property="noiDungHopRutKinhNghiem" style="width: 100%" /></td>
		</tr>
		<tr>
			<td align="right" width="19%">Th&#7901;i &#273;i&#7875;m k&#7871;t th&#250;c <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="30%"><html:text styleClass="text" onkeypress="return formatTime(event, this)" onblur="if(!isTime(this)) return;validateDateRequired(this);" property="thoiDiemKetThucHopRutKinhNghiem"></html:text></td>
			<td align="right" width="19%"></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="30%"><INPUT type="button" class="button1" onclick="inBienBan()" value="In bi&#234;n b&#7843;n"></td>
		</tr>
	</table>
	<html:hidden property="idBienBanHopRutKinhNghiem" />
	<html:hidden property="loaiBienBanHopRutKinhNghiem" />
</html:form>
<script language="javascript"> 
function inBienBan(){
	if(!validateHopRutKinhNghiemDoan())
		return;
	var printfForm = findForm('/' + contextRoot + '/ket_thuc_ttkt.do?method=save&type=hopRutKinhNghiemDoan');	
	printfForm.action = 'ket_thuc_ttkt.do?method=in&type=hopRutKinhNghiemDoan&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	printfForm.submit();
	printfForm.action = '/' + contextRoot + '/ket_thuc_ttkt.do?method=save&type=hopRutKinhNghiemDoan';
}
var selectedThanhPhanThamDu = "";
var bangThanhPhanThamDu = new TableObject('tb_DS_TPTD', true, 'xoaTblTpTdHopDoanTrienKhai');
function selectAll123xxxxxxxxxxxxx(chkBxSelectAll){
	bangThanhPhanThamDu.selectAllRow();
}
function getCaNhanId(checkBox){
	return checkBox.parentNode.parentNode.childNodes[1].childNodes[0].value;
}


function themThanhPhanThamDu() {	
	bangThanhPhanThamDu.addRow(createNewThanhPhanThamDuRow());
}

var tmpIdCanBo;
var tmpTenCanBo;
var tmpChucVu;
function cacheOldValue(controlIdTvd){
	tmpIdCanBo = controlIdTvd.value;
	tmpTenCanBo = document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value;
	tmpChucVu = document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value;
}


function existInSelectedT(controlIdTvd){
	for(var i = 0; i< bangThanhPhanThamDu.numOfRow - 1; i++){
		element = document.getElementsByName('thanhPhanThamDuHopRutKinhNghiem[' + i + '].idCanBo')[0];
		if(element != null && element != controlIdTvd && element.value == controlIdTvd.value)
			return true;			
	}
	return false;
}

function changeThanhVienDoanT(controlIdTvd){
	if(existInSelectedT(controlIdTvd)){
		alert('Th\u00E0nh vi\u00EAn \u0111o\u00E0n n\u00E0y \u0111\u00E3 t\u1ED3n t\u1EA1i!');
		//controlIdTvd.value = '';
		controlIdTvd.value = tmpIdCanBo;
		document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = tmpChucVu;
		document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = tmpTenCanBo;
		controlIdTvd.focus();    
		return;              
	}
	dschitietTvd = document.getElementById('cbDsTvdHopRutKinhNghiem');
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
function getChucVuTrongDoan(idCanBo){
	/*var tableDsThanhVienDoan = document.getElementById('tblDsTvd');
	var allRows = tableDsThanhVienDoan.rows;
	for(int i = 1; i< allRows.length; i++){
		if(allRows[i].cells[1].childNodes[0].value == idCanBo)
			return 
	}*/
	return "";
}

function createNewThanhPhanThamDuRow(){
	arrNewThanhPhanThamDu = new Array();
	index = bangThanhPhanThamDu.numOfRow - 1;
	arrNewThanhPhanThamDu[0] = '<SELECT name="thanhPhanThamDuHopRutKinhNghiem[' + index + '].idCanBo" onclick="cacheOldValue(this)" onchange = "changeThanhVienDoanT(this)" style="width:85%">';	
	arrNewThanhPhanThamDu[0] += cbDsThanhVienDoan;
	arrNewThanhPhanThamDu[0] += '</SELECT>';
	arrNewThanhPhanThamDu[0] += '<INPUT type="hidden" name="thanhPhanThamDuHopRutKinhNghiem[' + index + '].hoTen">'
	arrNewThanhPhanThamDu[1] = '<INPUT type="text" class="text1" name="thanhPhanThamDuHopRutKinhNghiem[' + index + '].chucVu" style="border-bottom:none; width:100%" readonly="true"> ';
	arrNewThanhPhanThamDu[2] = '<INPUT type=checkbox>';
	return arrNewThanhPhanThamDu;
}      



function onloadHopDoanTrienKhai(){

}
function validateGridthanhPhanThamDuHopRutKinhNghiem(){
	if(document.getElementById('tb_DS_TPTD').rows.length <= 1){
		alert('Kh\u00F4ng c\u00F3 th\u00E0nh ph\u1EA7n tham d\u1EF1 h\u1ECDp \u0111o\u00E0n tri\u1EC3n khai!');
		document.getElementById('tb_DS_TPTD').focus();
		return false;
	}
	return true;
		
	
} 
function validateHopRutKinhNghiemDoan(){
	if(!isRequired(document.getElementsByName('thoiDiemBatDauHopRutKinhNghiem')[0])) 
		return false;
	if(!isRequired(document.getElementsByName('diaDiemHopRutKinhNghiem')[0]))
		return false;
	if(!isRequired(document.getElementsByName('veViecHopRutKinhNghiem')[0]))
		return false;
	if(!validateGridthanhPhanThamDuHopRutKinhNghiem())
		return false;
	if(!isRequired(document.getElementsByName('noiDungHopRutKinhNghiem')[0]))
		return false;
	if(!isRequired(document.getElementsByName('thoiDiemKetThucHopRutKinhNghiem')[0]))
		return false;
	if(!compareTime(document.getElementsByName('thoiDiemBatDauHopRutKinhNghiem')[0], document.getElementsByName('thoiDiemKetThucHopRutKinhNghiem')[0], '<=', 'Th\u1EDDi \u0111i\u1EC3m b\u1EAFt \u0111\u1EA7u ph\u1EA3i nh\u1ECF h\u01A1n th\u1EDDi \u0111i\u1EC3m k\u1EBFt th\u00FAc!'))
		return false;	
	
	return true;
}
function onLoadHopRutKinhNghiemDoan(){
}

</script>
