<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<SELECT id="cbDsTvdBbMoNiemPhong" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="dsTvdBbMoNiemPhong" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<html:form action="niem_phong_ho_so_tai_lieu.do?method=save&type=bbMoNiemPhong" method="post">
	<html:hidden property="idBbMoNiemPhong" />
	<TABLE width="100%" align="center">
		<TBODY>
			<tr>
				<td width="19%" align="right">V&#224;o l&#250;c <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text property="vaoLucBienBanMoNP" styleClass="text" onblur="isTime(this)" onkeypress="return formatTime(event, this)">
				</html:text></td>
				<td width="19%" align="right">N&#417;i m&#7903; ni&#234;m phong <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text styleClass="text" property="diaDiemBienBanMoNP">
				</html:text></td>
			</tr>
			<tr>
				<td width="19%" align="right">&#272;o&#224;n ki&#7875;m tra</td>
				<td width="1%"></td>
				<td width="80%" colspan="4">
				<fieldset style="margin: 0">
				<table width="100%" id="bbMoNP1">
					<tr class=TdHeaderList>
						<td width="10%" align="center">STT</td>
						<td width="40%" align="left">H&#7885; t&#234;n</td>
						<td width="40%" align="left">Ch&#7913;c v&#7909;</td>
						<td width="10%" align="center"><input type="checkbox" onclick="chonTat()"></td>
					</tr>
					<logic:present name="NiemPhongHoSoTaiLieuForm" property="dsTVD2">
						<logic:iterate id="nhanVien" name="NiemPhongHoSoTaiLieuForm" property="dsTVD2" indexId="index">
							<tr class='row<%=(index.intValue() % 2)+1 %>'>
								<td align="center"><%=index.intValue() + 1%></td>
								<td><html:select name="NiemPhongHoSoTaiLieuForm" styleId='<%="dsTVD2["+ index + "].hoTen"%>' property='<%="dsTVD2[" + index + "].idCanBo"%>' onclick="cacheOldValue(this)" onchange="setChucVuById(this)" style="width:85%">
									<html:option value="" />
									<html:options collection="dsTvdBbMoNiemPhong" property="idCanBo" labelProperty="tenCanBo" />
								</html:select> <html:hidden property='<%="dsTVD2[" + index + "].hoTen"%>' styleId='<%="dsTVD2[" + index + "].Ten"%>' /></td>
								<td><html:text styleClass="text1" name="NiemPhongHoSoTaiLieuForm" property='<%="dsTVD2[" + index + "].chucVu"%>' readonly="true" style="border-bottom:none; width:100%">
								</html:text></td>
								<td align="center"><INPUT type="checkbox"></td>
							</tr>
						</logic:iterate>
					</logic:present>
				</table>
				<div style="text-align: right; width: 100%"><INPUT type="button" class="button" onclick="AddRowBBMoNP1()" value="Th&#234;m"> <INPUT type="button" class="button" name="btnXoa" value="X&#243;a" id="delrowBBMoNP1"></div>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td width="19%" align="right">V&#224; c&#225;c &#244;ng b&#224;</td>
				<td width="1%"></td>
				<td width="80%" colspan="4">
				<fieldset style="margin: 0">
				<table width="100%" id="bbMoNP2">
					<tr class=TdHeaderList>
						<td width="10%" align="center">STT</td>
						<td width="40%" align="left">H&#7885; t&#234;n <font color=red>*</font></td>
						<td width="40%" align="left">Ch&#7913;c v&#7909; <font color=red>*</font></td>
						<td width="10%" align="center"><input type="checkbox" onclick="chonTat2()"></td>
					</tr>
					<logic:present name="NiemPhongHoSoTaiLieuForm" property="dsCacOb">
						<logic:iterate id="nhanVien" name="NiemPhongHoSoTaiLieuForm" property="dsCacOb" indexId="index">
							<tr class='row<%=(index.intValue() % 2)+1 %>'>
								<td align="center"><%=index.intValue() + 1%></td>
								<td><html:text styleClass="text" property='<%="dsCacOb[" + index + "].hoTen"%>' style="width:85%"></html:text> <html:hidden property='<%="dsCacOb[" + index + "].idCanBo"%>' /></td>
								<td><html:text name="NiemPhongHoSoTaiLieuForm" styleClass="text" property='<%="dsCacOb[" + index + "].chucVu"%>' style="width:85%">
								</html:text></td>
								<td align="center"><INPUT type="checkbox"></td>
							</tr>
						</logic:iterate>
					</logic:present>
				</table>
				<div style="text-align: right; width: 100%"><INPUT type="button" class="button" onclick="AddRowBBMoNP2()" value="Th&#234;m"> <INPUT type="button" class="button" name="btnXoa" value="X&#243;a" id="delrowBBMoNP2"></div>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td width="19%" align="right">T&#236;nh tr&#7841;ng d&#7845;u ni&#234;m phong <font color=red>*</font></td>
				<td width="1%"></td>
				<td colspan="4" width="25%" align="left"><html:textarea property="tinhTrangDauNiemPhong" onkeypress="imposeMaxLength(this);"  styleClass="textareaContent"></html:textarea></td>
			</tr>
			<tr>
				<td width="19%" align="right">Th&#7901;i gian ho&#224;n th&#224;nh m&#7903; ni&#234;m phong <font color=red>*</font></td>
				<td width="1%"></td>
				<td colspan="3" width="25%" align="left"><html:text property="thoiGianHoanThanhMoNP" styleClass="text" onblur="isTime(this)" onkeypress="return formatTime(event, this)"></html:text></td>
				<td align="right"><INPUT type="button" class="button1" value="In bi&#234;n b&#7843;n" onclick="inBienBanMo()"></td>
			</tr>
		</TBODY>
	</TABLE>
	<html:hidden property="idThanhPhanThamDuDoanTtktBBMNP" />
	<html:hidden property="idThanhPhanThamDuCacOngBaBBMNP" />
	<html:hidden property="idDsTvdBbMoNiemPhong" />
</html:form>
<script language="javascript">
var dsTVDoanMoNP = new TableObject('bbMoNP1', true, 'delrowBBMoNP1');
var dsTVCacOngBa = new TableObject('bbMoNP2', true,'delrowBBMoNP2');
var dsTenTpTdDoanBBMNP = '<%=(String)request.getAttribute("dsTenTpTdDoanBBMNP")%>';
var dsTenTpTdDoanOngBaBBMNP = '<%=(String)request.getAttribute("dsTenTpTdDoanOngBaBBMNP")%>';

function onLoadBbMoNiemPhong()
{
	
	
}





function AddRowBBMoNP1() {
	dsTVDoanMoNP.addRow(createNewTptdTVD());	 	
}
 function AddRowBBMoNP2() {
	dsTVCacOngBa.addRow(createNewDsCacOb());	 	
}
function createNewTptdTVD(){
	arReturnRow = new Array();
	index = dsTVDoanMoNP.numOfRow - 1;
	arReturnRow[0] = '<select name = "dsTVD2['+ index +'].idCanBo" onclick="cacheOldValue(this)" onchange = "setChucVuById(this)" style="width:85%">'
	arReturnRow[0] += document.getElementById('cbDsTvdBbMoNiemPhong').innerHTML;
	arReturnRow[0] += '</select>'
	arReturnRow[0] += '<input type="hidden" id ="dsTVD2['+ index +'].Ten" name="dsTVD2['+ index +'].hoTen" > ';
	arReturnRow[1] = '<input type = "text" class = "text1" name = "dsTVD2['+ index +'].chucVu" readonly="true" style="border-bottom:none; width:100%">';
	arReturnRow[2] = '<INPUT type="checkbox">';
	
	return arReturnRow;
	
}
function createNewDsCacOb(){
	arReturnRow = new Array();
	index = dsTVCacOngBa.numOfRow - 1;
	arReturnRow[0] = '<input type = "text"  class = "text" name = "dsCacOb['+ index +'].hoTen" onchange = "setChucVuById(this)" style="width:85%">';
	arReturnRow[0] += '<input type="hidden"  name="dsCacOb['+ index +'].idCanBo" > ';
	arReturnRow[1] = '<input type = "text" class = "text" name = "dsCacOb['+ index +'].chucVu" style="width:85%">';
	arReturnRow[2] = '<INPUT type="checkbox">';
	return arReturnRow;
}


function deleteThanhVienDoan(){
	dsTVDoanTtkt.deleteSelectedRow();
}
function chonTat(){
	dsTVDoanTtkt.selectAllRow();
}
function chonTat2(){
	dsTVCacOngBa.selectAllRow();
}
function validatetable22(){
		if(dsTVCacOngBa.numOfRow == 1){
		alert('B\u1EA1n c\u1EA7n nh\u1EADp Danh s\u00E1ch c\u00E1c \u00D4ng b\u00E0 c\u1EE7a Bi\u00EAn b\u1EA3n m\u1EDF ni\u00EAm phong');
		return false;
	}
	for(i = 1; i< dsTVCacOngBa.numOfRow; i++){
		if(!isRequired(document.getElementsByName('dsCacOb['+ eval(i-1) +'].hoTen')[0]))
			return false;
		if(!isRequired(document.getElementsByName('dsCacOb['+ eval(i-1) +'].chucVu')[0]))
			return false;
	}		
	return true;
}
function validatetable21(){
	for(i = 1; i< dsTVDoanMoNP.numOfRow; i++){
		if(!isRequired(document.getElementsByName('dsTVD2['+ eval(i-1) +'].idCanBo')[0]))
			return false;
	}		
	return true;
}
function validateBbMoNp(){
	if(!validatetable21())
		return false;
	if(!validatetable22())
		return false;
	if(!isRequired(document.getElementsByName('vaoLucBienBanMoNP')[0]))
		return false;
	if(!isRequired(document.getElementsByName('diaDiemBienBanMoNP')[0]))
		return false;
	if(!isRequired(document.getElementsByName('tinhTrangDauNiemPhong')[0]))
		return false;
	if(!isRequired(document.getElementsByName('thoiGianHoanThanhMoNP')[0]))
		return false;
	if(!compareTime(document.getElementsByName('vaoLucBienBanMoNP')[0], document.getElementsByName('thoiGianHoanThanhMoNP')[0], '<', 'Th\u1EDDi \u0111i\u1EC3m l\u1EADp bi\u00EAn b\u1EA3n m\u1EDF ni\u00EAm phong ph\u1EA3i sau th\u1EDDi \u0111i\u1EC3m ho\u00E0n th\u00E0nh bi\u00EAn b\u1EA3n m\u1EDF ni\u00EAm phong!'))
		return false;
	return true;
}
	
	
function getChucVuById(idCanBo){
	var arrIdThanhVienDoan = dsIdThanhVienDoan.split(',');
	var arrChucVu = dsChucThanhVienDoan.split(',');
	for(i = 0; i < arrIdThanhVienDoan.length; i++){
		if(arrIdThanhVienDoan[i] == idCanBo)
			return arrChucVu[i];
	}
	return "code loi";      
}

function existInSelectedT(controlIdTvd){
	for(var i = 0; i< dsTVDoanMoNP.numOfRow - 1; i++){
		element = document.getElementsByName('dsTVD2[' + i + '].idCanBo')[0];
		if(element != null && element != controlIdTvd && element.value == controlIdTvd.value)
			return true;			
	}
	return false;
}
function setChucVuById(controlIdTvd){ 
	if(existInSelectedT(controlIdTvd)){
		alert('Th\u00E0nh vi\u00EAn n\u00E0y \u0111\u00E3 \u0111\u01B0\u1EE3c ch\u1ECDn!');
		controlIdTvd.value = tmpIdCanBo;
		document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = tmpTenCanBo;
		document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = tmpChucVu;
		controlIdTvd.focus();
		return;
	}
	dsCanBoHopDoanTk = document.getElementById('cbDsTvdBbMoNiemPhong');
	for(var i = 0; i< dsCanBoHopDoanTk.length; i++){
		if(dsCanBoHopDoanTk[i].value == controlIdTvd.value){
			chucVuEn = dsCanBoHopDoanTk[i].title;
			document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = dsCanBoHopDoanTk[i].text;
			document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = getChucVuCoDau(chucVuEn);			
			return;
		}
	}
}
function setChucVuById_old(cbThanhVienDoan){ 
		cbDsTvdBbMoNiemPhong123 = document.getElementById('cbDsTvdBbNiemPhong');
		for(var i = 0; i< cbDsTvdBbMoNiemPhong123.length; i++){
			if(cbDsTvdBbMoNiemPhong123[i].value == document.getElementsByName('dsTVD2[' + index + '].idCanBo')[0].value){
				chucVuEn = cbDsTvdBbMoNiemPhong123[i].title;
				document.getElementsByName(cbThanhVienDoan.name.replace('.idCanBo', '.chucVu'))[0].value = getChucVuCoDau(chucVuEn);
				document.getElementsByName(cbThanhVienDoan.name.replace('.idCanBo', '.hoTen'))[0].value = cbDsTvdBbMoNiemPhong123[i].text;
				return;
			}
		}		
}
function inBienBanMo(){
	if(!validateBbMoNp())
		return false;
	var qdmnpForm = findForm('/' + contextRoot + '/niem_phong_ho_so_tai_lieu.do?method=save&type=qdMoNiemPhong'); 	 
	    var thongTinQd = '';
	    for(var i = 0; i< qdmnpForm.elements.length; i++){
	    	element = qdmnpForm.elements[i];
	    	if(!isEmpty(element.name) && !isEmpty(element.value)){
	    		thongTinQd += '&' + element.name + "=" + element.value;
	    	}
	    }
	    
	qdmnpForm = findForm('/' + contextRoot + '/niem_phong_ho_so_tai_lieu.do?method=save&type=bbNiemPhong'); 	 
	    var thongTinBbQd = '';
	    for(var i = 0; i< qdmnpForm.elements.length; i++){
	    	element = qdmnpForm.elements[i];
	    	if(!isEmpty(element.name) && !isEmpty(element.value)){
	    		thongTinBbQd += '&' + element.name + "=" + element.value;
	    	}
	    }
	//document.forms[0].action = 'niem_phong_ho_so_tai_lieu.do?method=in&type=inBienBanMo'     
	//document.forms[0].submit();
	//document.forms[0].action = 'niem_phong_ho_so_tai_lieu.do';
	var printfForm = findForm('/' + contextRoot + '/niem_phong_ho_so_tai_lieu.do?method=save&type=bbMoNiemPhong'); 	   
	printfForm.action = 'niem_phong_ho_so_tai_lieu.do?method=in&type=inBienBanMo&idCuocTtkt='+document.getElementsByName('idCuocTtkt')[0].value + thongTinQd + thongTinBbQd;
	printfForm.submit();                                  
	printfForm.action = '/' + contextRoot + '/niem_phong_ho_so_tai_lieu.do?method=save&type=bbMoNiemPhong';         
}     
</script>