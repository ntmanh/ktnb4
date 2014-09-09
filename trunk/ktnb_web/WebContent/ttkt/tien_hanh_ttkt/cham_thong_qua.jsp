
<%@ include file="/top_bar.jsp"%>
<%if (request.getAttribute("save_status") != null) {%>
<script>
		alert('L\u01B0u th\u00E0nh c\u00F4ng');
		window.close();
	</script>
<%}%>
<SELECT id="thchiTietDsTvd" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="chiTietDsTvd" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<h3 class="Header">Ch&#7853;m th&#244;ng qua bi&#234;n b&#7843;n t&#7893;ng h&#7907;p</h3>
<fieldset><html:form action="cham_thong_qua.do">
	<html:hidden property="id" />
	<html:hidden property="idCuocTtKt" />
	<html:hidden property="idDoanTtKt" />
	<html:hidden property="idThanhphanKhac" />
	<html:hidden property="loaiBB" />
	<TABLE width="100%" align="center">
		<TBODY>
			<tr>
				<td align="right" width="19%">Th&#7901;i gian <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%"><html:text styleClass="text" property="thoiDiemBatDau" onblur="isTime(this)" onkeypress="return formatTime(event, this)"></html:text></td>
				<td width="19%" align="right">&#272;&#7883;a &#273;i&#7875;m l&#224;m vi&#7879;c <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text styleClass="text" property="diaDiem"></html:text></td>
			</tr>
			<tr>
				<td align="right" width="19%">L&#224;m vi&#7879;c v&#7899;i <font color=red>*</font></td>
				<td width="1%"></td>
				<td colspan="4" align="left"><html:text styleClass="text" property="lamViecVoi" style="width: 100%"></html:text></td>
			</tr>
			<tr>
				<td align="right" width="19%">&#x110;&#x1EA1;i di&#x1EC7;n &#x111;o&#xE0;n Thanh tra Ki&#x1EC3;m tra</td>
				<td width="1%"></td>
				<td colspan="4" align="left">
				<fieldset style="margin: 0">
				<TABLE id="daiDienDoanTtkt" width="100%">
					<tr class="TdHeaderList">
						<td width="10%" align="center">STT</td>
						<td width="40%">&#212;ng/B&#224; <font color=red>*</font></td>
						<td width="40%">Ch&#7913;c v&#7909; trong &#273;o&#224;n <font color=red>*</font></td>
						<td align="center" width="10%"><INPUT type="checkbox"></td>
					</tr>
					<logic:present name="BienBanLamViecForm" property="dsDoanTtKt">
						<logic:iterate id="ttptDoanTtkt" name="BienBanLamViecForm" property="dsDoanTtKt" indexId="index">
							<tr class='row<%=(index.intValue() % 2)+1 %>'>
								<td align="center"><%=index.intValue() + 1%></td>
								<td><html:select name="BienBanLamViecForm" property='<%="dsDoanTtKt[" + index + "].idCanBo"%>' onclick="cacheOldValue(this)" onchange="getChucVuTvd(this)" style="width: 85%">
									<html:options collection="chiTietDsTvd" property="idCanBo" labelProperty="tenCanBo" />
									<html:hidden property='<%="dsDoanTtKt[" + index + "].hoTen"%>' />
								</html:select></td>
								<td><html:text styleClass="text1" readonly="true" name="BienBanLamViecForm" property='<%="dsDoanTtKt[" + index + "].chucVu"%>' style="border-bottom:none; width:100%">
								</html:text></td>
								<td align="center"><INPUT type="checkbox"></td>
							</tr>
						</logic:iterate>
					</logic:present>
				</TABLE>
				<DIV style="text-align: right;"><INPUT type="button" class="button" style="width: auto" onclick="themTtptDoanTtkt()" value="Th&#234;m"> <INPUT type="button" class="button" style="width: auto" value="X&#243;a" id="xoaDaiDienDoanTtkt"></DIV>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td align="right" width="19%">&#x110;&#x1EA1;i di&#x1EC7;n c&#x1A1; quan, t&#x1ED5; ch&#x1EE9;c, c&#xE1; nh&#xE2;n</td>
				<td width="1%"></td>
				<td colspan="4" align="left">
				<fieldset style="margin: 0">
				<TABLE id="daiDienCqKhac" width="100%">
					<tr class="TdHeaderList">
						<td width="10%" align="center">STT</td>
						<td width="40%">&#212;ng/B&#224; <font color=red>*</font></td>
						<td width="40%">Ch&#7913;c v&#7909; <font color=red>*</font></td>
						<td align="center" width="10%"><INPUT type="checkbox"></td>
					</tr>
					<logic:present name="BienBanLamViecForm" property="dsThanhPhanKhac">
						<logic:iterate id="ttptCqqlCapTren" name="BienBanLamViecForm" property="dsThanhPhanKhac" indexId="index">
							<tr class='row<%=(index.intValue() % 2)+1 %>'>
								<td align="center"><%=index.intValue() + 1%></td>
								<td><html:hidden name="BienBanLamViecForm" property='<%="dsThanhPhanKhac[" + index + "].idCanBo"%>' /> <html:text styleClass="text" readonly="readonly" name="BienBanLamViecForm" property='<%="dsThanhPhanKhac[" + index + "].hoTen"%>' style="width:85%">
								</html:text></td>
								<td><html:text styleClass="text" readonly="readonly" name="BienBanLamViecForm" property='<%="dsThanhPhanKhac[" + index + "].chucVu"%>' style="width:85%">
								</html:text></td>
								<td align="center"><INPUT type="checkbox"></td>
							</tr>
						</logic:iterate>
					</logic:present>
				</TABLE>
				<DIV style="text-align: right"><INPUT type="button" class="button" style="width: auto" onclick="themTtptCqqlCapTren()" value="Th&#234;m"> <INPUT type="button" id="xoaTtptCqqlCapTren" value="X&#243;a" class="button" style="width: auto"></DIV>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td align="right" width="19%">N&#7897;i dung l&#224;m vi&#7879;c <font color=red>*</font></td>
				<td width="1%"></td>
				<td colspan="4"><html:textarea property="noiDungLamViec" onkeypress="imposeMaxLength(this);"  style="width: 100%;height: 70px"></html:textarea></td>
			</tr>
			<tr>
				<td align="right" width="19%">Di&#7877;n bi&#7871;n, k&#7871;t qu&#7843; <font color=red>*</font></td>
				<td width="1%"></td>
				<td colspan="4"><html:textarea property="ketQua" onkeypress="imposeMaxLength(this);"  style="width: 100%;height: 70px"></html:textarea></td>
			</tr>
			<tr>
				<td align="right" width="19%">Th&#7901;i &#273;i&#7875;m k&#7871;t th&#250;c <font color=red>*</font></td>
				<td width="1%"></td>
				<td align="left" width="30%"><html:text styleClass="text" property="thoiDiemKetThuc" onblur="isTime(this)" onkeypress="return formatTime(event, this)"></html:text></td>
				<td colspan="3" align="right"><INPUT type="button" value="In bi&#234;n b&#7843;n" class="button1" style="width: auto" onclick="inBienBan()"></td>
			</tr>
		</TBODY>
	</TABLE>
</html:form></fieldset>
<fieldset><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></fieldset>
<%@ include file="/bottom.jsp"%>
<script language="javascript">

var tableDaiDienCqqlCapTren = new TableObject('daiDienCqKhac', true, 'xoaTtptCqqlCapTren');
function themTtptCqqlCapTren(){
	tableDaiDienCqqlCapTren.addRow(createNewDaiDienCqqlCapTren());
}
var tableDaiDienDoanTtkt = new TableObject('daiDienDoanTtkt', true, 'xoaDaiDienDoanTtkt');
function themTtptDoanTtkt(){
	tableDaiDienDoanTtkt.addRow(createNewDaiDienDoanTtkt());
}

function createNewDaiDienDoanTtkt(){
	arrDaiDienDoanTtkt = new Array();
	index = tableDaiDienDoanTtkt.numOfRow - 1;
	arrDaiDienDoanTtkt[0] = '<SELECT name="dsDoanTtKt[' + index + '].idCanBo" onclick="cacheOldValue(this)" onchange="getChucVuTvd(this)" style="width:85%">';	
	arrDaiDienDoanTtkt[0] += cbDsThanhVienDoan;
	arrDaiDienDoanTtkt[0] += '</SELECT>';
	arrDaiDienDoanTtkt[0] += '<input type="hidden" name="dsDoanTtKt['+ index +'].hoTen" > ';
	arrDaiDienDoanTtkt[1] = '<INPUT type="text" class="text1" readonly="true" name="dsDoanTtKt[' + index + '].chucVu" style="border-bottom:none; width:100%"> ';
	arrDaiDienDoanTtkt[2] = '<INPUT type=checkbox>';
	return arrDaiDienDoanTtkt;
}

function createNewDaiDienCqqlCapTren(){
	arrDaiDienCqqlCapTren = new Array(); 
	index = tableDaiDienCqqlCapTren.numOfRow - 1;
	arrDaiDienCqqlCapTren[0] = '<input type="hidden" name="dsThanhPhanKhac[' + index + '].idCanBo">'
	arrDaiDienCqqlCapTren[0] += '<input type="text" name="dsThanhPhanKhac[' + index + '].hoTen" class="text" style="width:85%">'				
	arrDaiDienCqqlCapTren[1] = '<input type="text" name="dsThanhPhanKhac[' + index + '].chucVu" class="text" style="width:85%">'				
	arrDaiDienCqqlCapTren[2] = '<input type="checkBox">'				
	return arrDaiDienCqqlCapTren; 
}

var cbDsThanhVienDoan;  
var dsIdThanhVienDoan; 
var dsChucVuTrongDoan; 
function getDsThanhVienDoan(){
	cbDsThanhVienDoan = '<%=request.getAttribute("cbChiTietDsTvd")%>'
	dsIdThanhVienDoan = '<%=request.getAttribute("dsIdThanhVienDoan")%>'
	dsIdThanhVienDoan = dsIdThanhVienDoan.split(',');
	dsChucVuTrongDoan = '<%=request.getAttribute("dsChucVuTrongDoan")%>'
	dsChucVuTrongDoan = dsChucVuTrongDoan.split(',');	
}


var tmpIdCanBo;
var tmpTenCanBo;
var tmpChucVu;
function cacheOldValue(controlIdTvd){
	tmpIdCanBo = controlIdTvd.value;
	tmpTenCanBo = document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value;
	tmpChucVu = document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value;
}
function existInSelected(controlIdTvd){
	for(var i = 0; i< tableDaiDienDoanTtkt.numOfRow - 1; i++){
		element = document.getElementsByName('dsDoanTtKt[' + i + '].idCanBo')[0];
		if(element != null && element != controlIdTvd && element.value == controlIdTvd.value)
			return true;			
	}
	return false;
}
function getChucVuTvd(controlIdTvd){
	if(existInSelected(controlIdTvd)){
		alert('Th\u00E0nh vi\u00EAn \u0111o\u00E0n n\u00E0y \u0111\u00E3 t\u1ED3n t\u1EA1i!');
		controlIdTvd.value = tmpIdCanBo;
		document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = tmpChucVu;
		document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = tmpTenCanBo;
		controlIdTvd.focus();    
		return;              
	}
	dschitietTvd = document.getElementById('thchiTietDsTvd');
	for(var i = 0; i< dschitietTvd.length; i++){
		if(dschitietTvd[i].value == controlIdTvd.value){
			chucVuEn = dschitietTvd[i].title;
			document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = dschitietTvd[i].text;
			document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = getChucVuCoDau(chucVuEn);			
			return;
		}        
	}	        
}

function getChucVuTvd_old(tvdId){
	var chucVuVn = document.getElementsByName(tvdId.name.replace('.idCanBo', '.chucVu'))[0];
	chucVu = findChucVuById(tvdId.value);
	var tenHiddenTag = 	document.getElementsByName(tvdId.name.replace('.idCanBo','.hoTen'))[0];
	tenHiddenTag.value =  tvdId.options[tvdId.selectedIndex].text;
			if(tvdId[tvdId.selectedIndex].text == ""){        
			chucVuVn.value = '';
			return;
		}
	switch (chucVu){
		case "Truong doan":
			chucVuVn.value = "Tr\u01B0\u1EDFng \u0111o\u00E0n"
			break;
		case "Pho doan":
			chucVuVn.value = "Ph\u00F3 \u0111o\u00E0n"
			break;
		default:
			chucVuVn.value = 'Th\u00E0nh Vi\u00EAn \u0110o\u00E0n';
			break;
	} 
	
}
function findChucVuById(idCanBo){
	for(var i = 0; i< dsIdThanhVienDoan.length; i++)
		if(dsIdThanhVienDoan[i] == idCanBo)
			return dsChucVuTrongDoan[i]; 
}

window.onload = function(){
getDsThanhVienDoan();
}

function validateForm(){
	if(!isRequired(document.getElementsByName('thoiDiemBatDau')[0]))
		return false;
		if(!isRequired(document.getElementsByName('diaDiem')[0]))
		return false;
		if(!isRequired(document.getElementsByName('lamViecVoi')[0]))
		return false;
		if(!isRequired(document.getElementsByName('noiDungLamViec')[0]))
		return false;
		if(!isRequired(document.getElementsByName('ketQua')[0]))
		return false;
		if(!isRequired(document.getElementsByName('thoiDiemKetThuc')[0]))
		return false;
		if(!compareTime(document.getElementsByName('thoiDiemBatDau')[0], document.getElementsByName('thoiDiemKetThuc')[0], '<', 'Th\u1EDDi \u0111i\u1EC3m k\u1EBFt th\u00FAc ph\u1EA3i sau th\u1EDDi \u0111i\u1EC3m b\u1EAFt \u0111\u1EA7u!'))
		return false;
	return true;
}		

function selfClose(){
		window.close();
	}
function inBienBan()
	{
		if(!validateForm()) return false;
		document.forms[0].action = 'to_chuc_lam_viec_thong_bap_ket_thuc.do?method=in&type=inBienBan'
		document.forms[0].submit();
		document.forms[0].action = 'to_chuc_lam_viec_thong_bap_ket_thuc.do';
	}
	</script>
<%if(request.getAttribute("save") != null){%>
<script language="javascript">
		alert('L\u01B0u th\u00E0nh c\u00F4ng!');
		selfClose();
	</script>
<%}%>