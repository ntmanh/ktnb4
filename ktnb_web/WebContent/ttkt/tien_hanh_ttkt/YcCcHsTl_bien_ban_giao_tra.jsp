<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:hidden property="idDaiDienBenGiaoHoSo" />
<html:hidden property="idDaiDienBenNhanHoSo" />
<html:hidden property="idHoSoTra" />
<html:hidden property="loaiHoSoLuuTru" />
<html:hidden property="idDsTvdGiaoTra" />
<SELECT id="cbDsTvdGiaoTra" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="dsTvdGiaoTra" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<TABLE width="100%" align="center"">
	<tr>
		<td width="19%" align="right">Th&#x1EDD;i &#x111;i&#x1EC3;m b&#x1EAF;t &#x111;&#x1EA7;u b&#xE0;n giao <font color=red>*</font></td>
		<td style="width: 1%; min-width: 5px"></td>
		<td width="30%"><html:text styleClass="text" property="thoiDiemBatDauBanGiaoHoSo" onblur="if(!isTime(this)) return;validateDateRequired(this);"  onkeypress="return formatTime(event, this)"></html:text></td>
		<td width="19%" align="right">&#272;&#7883;a &#273;i&#7875;m <font color=red>*</font></td>
		<td style="width: 1%; min-width: 5px"></td>
		<td width="30%"><html:text styleClass="text" property="diaDiemBBGT"></html:text></td>
	</tr>
	<tr>
		<td align="right">&#272;&#7841;i di&#7879;n b&#234;n giao tr&#7843;, b&#225;o c&#225;o, h&#7891; s&#417;, t&#224;i li&#7879;u <font color=red>*</font></td>
		<td></td>
		<td colspan="4">
		<fieldset style="margin: 0">
		<TABLE width="100%" id="tblDaiDienBenGiao" style="margin-top: 10px">
			<tr class="TdHeaderList">
				<td align="center" width="10%">STT</td>
				<td width="40%">&#212;ng/B&#224; <font color=red>*</font></td>
				<td width="40%">Ch&#7913;c v&#7909; <font color=red>*</font></td>
				<td align="center" width="10%"><INPUT type="checkbox"></td>
			</tr>
			<logic:present name="YeuCauCungCapHstlForm" property="arrDaiDienBenGiaoHstl">
				<logic:iterate id="ttptCqtBanHanhQd" name="YeuCauCungCapHstlForm" property="arrDaiDienBenGiaoHstl" indexId="index">
					<tr class='row<%=(index.intValue() % 2)+1 %>'>
						<td align="center"><%=index.intValue() + 1%></td>
						<td><html:select onclick="cacheOldValue(this)" onchange="getChucVuNguoiDaiDienBenTra(this)" property='<%="arrDaiDienBenGiaoHstl[" + index + "].idCanBo"%>' style="width:85%">
							<OPTION value=""></OPTION>
							<html:options collection="dsTvdGiaoTra" property="idCanBo" labelProperty="tenCanBo" />
						</html:select> <html:hidden property='<%="arrDaiDienBenGiaoHstl[" + index + "].hoTen"%>' /></td>
						<td><html:text styleClass="text1" name="YeuCauCungCapHstlForm" property='<%="arrDaiDienBenGiaoHstl[" + index + "].chucVu"%>' readonly="true" style="border-bottom:none; width:100%">
						</html:text></td>
						<td align="center"><INPUT type="checkbox"></td>
					</tr>
				</logic:iterate>
			</logic:present>
		</TABLE>
		<DIV style="text-align: right; width: 100%"><INPUT type="button" onclick="themGiaoHstl()" value="Th&#xEA;m" class="button"> <INPUT type="button" id="xoaDaiDienBenGiao" value="X&#xF3;a" class="button"></DIV>
		</fieldset>
		</td>
	</tr>
	<tr>
		<td align="right">&#272;&#7841;i di&#7879;n b&#234;n giao nh&#7853;n, b&#225;o c&#225;o, h&#7891; s&#417;, t&#224;i li&#7879;u <font color=red>*</font></td>
		<td></td>
		<td colspan="4">
		<fieldset style="margin: 0">
		<TABLE width="100%" id="tblDaiDienBenNhan" style="margin-top: 10px">
			<tr class="TdHeaderList">
				<td align="center" width="10%">STT</td>
				<td width="40%">&#212;ng/B&#224;</td>
				<td width="40%">Ch&#7913;c v&#7909;</td>
				<td align="center" width="10%"><INPUT type="checkbox"></td>
			</tr>
			<logic:present name="YeuCauCungCapHstlForm" property="arrDaiDienBenNhanHstl">
				<logic:iterate id="ttptCqtBanHanhQd" name="YeuCauCungCapHstlForm" property="arrDaiDienBenNhanHstl" indexId="index">
					<tr class='row<%=(index.intValue() % 2)+1 %>'>
						<td align="center"><%=index.intValue() + 1%></td>
						<td><html:hidden name="YeuCauCungCapHstlForm" property='<%="arrDaiDienBenNhanHstl[" + index + "].idCanBo"%>' /> <html:text styleClass="text" readonly="readonly" name="YeuCauCungCapHstlForm" property='<%="arrDaiDienBenNhanHstl[" + index + "].hoTen"%>' style="width:75%">
						</html:text> <INPUT type="button" onclick="chonNhanVienCqtBanHanh('+index+')" value="..." class="lovButton"></td>
						<td><html:text styleClass="text1" name="YeuCauCungCapHstlForm" property='<%="arrDaiDienBenNhanHstl[" + index + "].chucVu"%>' readonly="true" style="border-bottom:none; width:100%">
						</html:text></td>
						<td align="center"><INPUT type="checkbox"></td>
					</tr>
				</logic:iterate>
			</logic:present>
		</TABLE>
		<DIV style="text-align: right; width: 100%"><INPUT type="button" onclick="themNhanHstl()" value="Th&#xEA;m" class="button"> <INPUT type="button" id="xoaDaiDienBenNhan" value="X&#xF3;a" class="button"></DIV>
		</fieldset>
		</td>
	</tr>
	<tr>
		<td align="right" width="19%">B&#xE1;o c&#xE1;o</td>
		<td width="1%"></td>
		<td width="80%" align="left" colspan="4"><html:textarea styleClass="textareaContent" property="baoCaoHoSoTra">
		</html:textarea></td>
	</tr>
	<tr>
		<td align="right" width="19%">H&#x1ED3; s&#x1A1; t&#xE0;i li&#x1EC7;u</td>
		<td width="1%"></td>
		<td width="80%" align="left" colspan="4"><html:textarea styleClass="textareaContent" property="hoSoTra">
		</html:textarea></td>
	</tr>
	<tr>
		<td width="19%" align="right">Th&#7901;i &#273;i&#7875;m k&#7871;t th&#250;c <font color=red>*</font></td>
		<td style="width: 1%; min-width: 5px"></td>
		<td width="30%"><html:text styleClass="text" property="thoiDiemKTBBGT" onblur="if(!isTime(this)) return;validateDateRequired(this);"  onkeypress="return formatTime(event, this)"></html:text></td>
		<td align="right" width="50%" colspan="3"><INPUT type="button" class="button1" onclick="inBBGiaoTra()" value="In bi&#xEA;n b&#x1EA3;n b&#xE0;n giao"></td>
	</tr>
</TABLE>
<script language="javascript">

function existInSelectedT(controlIdTvd){
	for(var i = 0; i< bangGiao.numOfRow - 1; i++){
		element = document.getElementsByName('arrDaiDienBenGiaoHstl[' + i + '].idCanBo')[0];
		if(element != null && element != controlIdTvd && element.value == controlIdTvd.value)
			return true;			
	}
	return false;
}

function getChucVuNguoiDaiDienBenTra(controlIdTvd){
	if(existInSelectedT(controlIdTvd)){
		alert('Th\u00E0nh vi\u00EAn \u0111o\u00E0n n\u00E0y \u0111\u00E3 t\u1ED3n t\u1EA1i!');
		//controlIdTvd.value = '';
		controlIdTvd.value = tmpIdCanBo;
		document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = tmpChucVu;
		document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = tmpTenCanBo;
		controlIdTvd.focus();    
		return;              
	}
	dschitietTvd = document.getElementById('cbDsTvdGiaoTra');
	for(var i = 0; i< dschitietTvd.length; i++){
		if(dschitietTvd[i].value == controlIdTvd.value){
			chucVuEn = dschitietTvd[i].title;
			document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = dschitietTvd[i].text;
			document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = getChucVuCoDau(chucVuEn);			
			return;
		}        
	}
}

function getChucVuNguoiDaiDienBenTra_old(index){
	cbCanBoDaiDienBenGiao = document.getElementById('cbDsTvdGiaoTra');
	for(var i = 0; i< cbCanBoDaiDienBenGiao.length; i++){
		if(cbCanBoDaiDienBenGiao[i].value == document.getElementsByName('arrDaiDienBenGiaoHstl[' + index + '].idCanBo')[0].value){
			chucVuEn = cbCanBoDaiDienBenGiao[i].title;
			document.getElementsByName('arrDaiDienBenGiaoHstl[' + index + '].chucVu')[0].value = getChucVuCoDau(chucVuEn);
			document.getElementsByName('arrDaiDienBenGiaoHstl[' + index + '].hoTen')[0].value = cbCanBoDaiDienBenGiao[i].text;
			return;
		}
	}
}
var bangGiao = new TableObject("tblDaiDienBenGiao", true, "xoaDaiDienBenGiao");
var bangNhan = new TableObject("tblDaiDienBenNhan", true, "xoaDaiDienBenNhan"); 
function inBienBanBanGiao(){
}
function themNhanHstl(){
	bangNhan.addRow(createNhanHstl());
}
function createNhanHstl(){
	arrDaiDienCqBanHanhQD = new Array(); 
	index = bangNhan.numOfRow - 1; 
	arrDaiDienCqBanHanhQD[0] = '<input type="hidden" name="arrDaiDienBenNhanHstl[' + index + '].idCanBo">'
	arrDaiDienCqBanHanhQD[0] += '<input type="text" name="arrDaiDienBenNhanHstl[' + index + '].hoTen" class="text" style="width:75%"  onchange = "chonNhanVienCqtBanHanh(' + index + ')">'				
	arrDaiDienCqBanHanhQD[0] += '<Input type="button" class = "lovButton" value="..." onclick="chonNhanVienCqtBanHanh('+index+')">'
	arrDaiDienCqBanHanhQD[1] = '<input type="text" name="arrDaiDienBenNhanHstl[' + index + '].chucVu" class="text1" readonly="true" style="border-bottom:none; width:100%">'				
	arrDaiDienCqBanHanhQD[2] = '<input type="checkBox">'				
	return arrDaiDienCqBanHanhQD;
}
function themGiaoHstl(){
	bangGiao.addRow(createDoanTtkt());
}
function createDoanTtkt(){
	arrDaiDienDoanTtkt = new Array();
	index = bangGiao.numOfRow - 1;
	arrDaiDienDoanTtkt[0] = '<SELECT name="arrDaiDienBenGiaoHstl[' + index + '].idCanBo" onclick="cacheOldValue(this)" onchange="getChucVuNguoiDaiDienBenTra(this)" style="width:85%">';	
	arrDaiDienDoanTtkt[0] += document.getElementById('cbDsTvdGiaoTra').innerHTML;
	arrDaiDienDoanTtkt[0] += '</SELECT>';
	arrDaiDienDoanTtkt[0] += '<input type="hidden" name="arrDaiDienBenGiaoHstl['+ index +'].hoTen" > ';
	arrDaiDienDoanTtkt[1] = '<INPUT type="text" class="text1" readonly="true" name="arrDaiDienBenGiaoHstl[' + index + '].chucVu" style="border-bottom:none; width:100%"> ';
	arrDaiDienDoanTtkt[2] = '<INPUT type=checkbox>';
	return arrDaiDienDoanTtkt;
}

var type;
function chonNhanVienCqtBanHanh(index){
	
	// id, ten
	hiddenIdCanBo = document.getElementsByName('arrDaiDienBenNhanHstl['+ index + '].idCanBo')[0];
	txtTenCanBo = document.getElementsByName('arrDaiDienBenNhanHstl['+ index + '].hoTen')[0];
	
	// Chuc vu
	chucVuCongTacCol = document.getElementsByName('arrDaiDienBenNhanHstl['+ index + '].chucVu')[0];
	txtChucVu = document.getElementsByName('arrDaiDienBenNhanHstl['+ index + '].chucVu')[0];
	
	type = 'daidienBBGT';
	showLovNhanVien(maCqtDuocTtkt, txtTenCanBo);
	
}

 function validateDaiDienBenGiaoTra(){
	if(bangGiao.numOfRow == 1){
		alert('B\u1EA1n ph\u1EA3i nh\u1EADp \u0111\u1EA1i di\u1EC7n b\u00EAn giao c\u1EE7a Bi\u00EAn b\u1EA3n giao tr\u1EA3');
		return false;
	}
	for(i = 1; i< bangGiao.numOfRow; i++){
		if(!isRequired(document.getElementsByName('arrDaiDienBenGiaoHstl['+ eval(i-1) +'].idCanBo')[0]))
		return false;
	}
	
	return true;
 }
function validateBanGiaoTra(){
	if(isEmpty(document.getElementsByName('idYeuCau')[0].value)){
		alert('Ph\u1EA3i l\u01B0u phi\u1EBFu y\u00EAu c\u1EA7u tr\u01B0\u1EDBc!');
		return false;
	}
	if(!isRequired(document.getElementsByName('thoiDiemBatDauBanGiaoHoSo')[0]))
		return false;
	if(!isRequired(document.getElementsByName('diaDiemBBGT')[0]))
		return false;
	if(!validateDaiDienBenGiaoTra())
		return false;
	if(!isRequired(document.getElementsByName('thoiDiemKTBBGT')[0]))
		return false;
	if(!compareTime(document.getElementsByName('thoiDiemBatDauBanGiaoHoSo')[0], document.getElementsByName('thoiDiemKTBBGT')[0], '<', 'Th\u1EDDi \u0111i\u1EC3m k\u1EBFt th\u00FAc ph\u1EA3i sau th\u1EDDi \u0111i\u1EC3m b\u1EAFt \u0111\u1EA7u!'))
		return false;
	return true;
}
function existCheck1(table, thisCbo){
	for(i =1;i<table.numOfRow-1;i++){
		var	cbo =  document.getElementsByName('arrDaiDienBenGiaoHstl['+ eval(i-1) +'].idCanBo')[0] ;
		if(cbo.value == thisCbo.value){
		alert('D\u1EEF li\u1EC7u \u0111\u00E3 t\u1ED3n t\u1EA1i');
		thisCbo.selectedIndex = 0;
		return false;
		}
	}
}
function inBBGiaoTra()
{
	if(!validateBanGiaoTra()) return false;
	//document.forms[0].action = 'yeu_cau_cung_cap_tai_lieu.do?method=in&type=bbGiaoTra'
	//document.forms[0].submit();
	//document.forms[0].action = 'yeu_cau_cung_cap_tai_lieu.do';
	var printfForm = findForm('/' + contextRoot + '/yeu_cau_cung_cap_tai_lieu.do?method=save&type=bbgiaotra'); 	   
	printfForm.action = 'yeu_cau_cung_cap_tai_lieu.do?method=in&type=bbGiaoTra&idCuocTtkt='+document.getElementsByName('idCuocTtKtl')[0].value;     
	printfForm.submit();                                                           
	printfForm.action = '/' + contextRoot + '/yeu_cau_cung_cap_tai_lieu.do?method=save&type=bbgiaotra';    
}


</script>
