<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="cong_bo_quyet_dinh.do">
	<TABLE width="100%">
		<tr>
			<td width="24%" align="right">Th&#7901;i &#273;i&#7875;m c&#244;ng b&#7889; <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><input type="text" name="thoiDiemCbTu" onblur="isDate(this)" onkeypress="return formatDate(event, this)" class="text"></td>
			<td width="24%" align="right">&#272;&#7883;a &#273;i&#7875;m <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><input type="text" name="diaDiem" onblur="isDate(this)" class="text"></td>
		</tr>
		<tr>
			<td colspan="6">
			<fieldset><legend>&#272;&#7841;i di&#7879;n c&#417; quan ban h&#224;nh quy&#7871;t &#273;&#7883;nh </legend>
			<TABLE id="daiDienCoQuanBanHanhQuyetDinh" width="100%">
				<tr class="TdHeaderList">
					<td align="center" width="10%">STT</td>
					<td width="40%">&#212;ng/B&#224; <font color=red>*</font></td>
					<td width="40%">Ch&#7913;c v&#7909; <font color=red>*</font></td>
					<td align="center" width="10%"><INPUT type="checkbox"></td>
				</tr>
				<logic:present name="CongBoQuyetDinhForm" property="arrDaiDienCqtBanHanhQD">
					<logic:iterate id="ttptCqtBanHanhQd" name="CongBoQuyetDinhForm" property="arrDaiDienCqtBanHanhQD" indexId="index">
						<tr class='row<%=(index.intValue() % 2)+1 %>'>
							<td align="center"><%=index.intValue() + 1%></td>
							<td><html:hidden name="CongBoQuyetDinhForm" property='<%="arrDaiDienCqtBanHanhQD[" + index + "].idCanBo"%>' /> <html:text styleClass="text" readonly="readonly" name="CongBoQuyetDinhForm" property='<%="arrDaiDienCqtBanHanhQD[" + index + "].hoTen"%>'>
							</html:text> <INPUT type="button" onclick="chonCanBo(<%=index%>)"></td>
							<td><html:text styleClass="text" readonly="readonly" name="CongBoQuyetDinhForm" property='<%="arrDaiDienCqtBanHanhQD[" + index + "].chucVu"%>'>
							</html:text></td>
							<td align="center"><INPUT type="checkbox"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</TABLE>
			<DIV align="right" style="width: 100%"><INPUT type="button" onclick="themTtptCqtBanHanhQd()" value="Th&#234;m"> <INPUT type="button" id="xoaTtptCqtBanHanhQd" value="X&#243;a"></DIV>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td colspan="6">
			<fieldset><legend>&#272;&#7841;i di&#7879;n c&#417; quan qu&#7843;n l&#253; c&#7845;p tr&#234;n</legend>
			<TABLE id="daiDienCqqlCapTren" width="100%">
				<tr class="TdHeaderList">
					<td width="10%" align="center">STT</td>
					<td width="40%">&#212;ng/B&#224; <font color=red>*</font></td>
					<td width="40%">Ch&#7913;c v&#7909; <font color=red>*</font></td>
					<td align="center" width="10%"><INPUT type="checkbox"></td>
				</tr>
				<logic:present name="CongBoQuyetDinhForm" property="arrDaiDienCqqlCapTren">
					<logic:iterate id="ttptCqqlCapTren" name="CongBoQuyetDinhForm" property="arrDaiDienCqqlCapTren" indexId="index">
						<tr class='row<%=(index.intValue() % 2)+1 %>'>
							<td align="center"><%=index.intValue() + 1%></td>
							<td><html:hidden name="CongBoQuyetDinhForm" property='<%="arrDaiDienCqqlCapTren[" + index + "].idCanBo"%>' /> <html:text styleClass="text" readonly="readonly" name="CongBoQuyetDinhForm" property='<%="arrDaiDienCqqlCapTren[" + index + "].hoTen"%>'>
							</html:text></td>
							<td><html:text styleClass="text" readonly="readonly" name="CongBoQuyetDinhForm" property='<%="arrDaiDienCqqlCapTren[" + index + "].chucVu"%>'>
							</html:text></td>
							<td align="center"><INPUT type="checkbox"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</TABLE>
			<DIV align="right" style="width: 100%"><INPUT type="button" onclick="themTtptCqqlCapTren()" value="Th&#234;m"> <INPUT type="button" id="xoaTtptCqqlCapTren" value="X&#243;a"></DIV>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td colspan="6">
			<fieldset><legend>&#272;&#7841;i di&#7879;n &#273;o&#224;n Thanh tra Ki&#7875;m tra</legend>
			<TABLE id="daiDienDoanTtkt" width="100%">
				<tr class="TdHeaderList">
					<td width="10%" align="center">STT</td>
					<td width="40%">&#212;ng/B&#224; <font color=red>*</font></td>
					<td width="40%">Ch&#7913;c v&#7909; trong &#273;o&#224;n <font color=red>*</font></td>
					<td align="center" width="10%"><INPUT type="checkbox"></td>
				</tr>
				<logic:present name="CongBoQuyetDinhForm" property="arrDaiDienDoanTtkt">
					<logic:iterate id="ttptDoanTtkt" name="CongBoQuyetDinhForm" property="arrDaiDienDoanTtkt" indexId="index">
						<tr class='row<%=(index.intValue() % 2)+1 %>'>
							<td align="center"><%=index.intValue() + 1%></td>
							<td><html:select name="CongBoQuyetDinhForm" property='<%="arrDaiDienDoanTtkt[" + index + "].idCanBo"%>' onchange="document.getElementsByName(this.name.replace('.idCanBo', '.chucVu'))[0].value = getChucVuTvd(this.value)">
								<html:options collection="chiTietDsTvd" property="idCanBo" labelProperty="tenCanBo" />
							</html:select></td>
							<td><html:text styleClass="text" readonly="readonly" name="CongBoQuyetDinhForm" property='<%="arrDaiDienDoanTtkt[" + index + "].dsChucVuTrongDoan"%>'>
							</html:text></td>
							<td align="center"><INPUT type="checkbox"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</TABLE>
			<DIV align="right" style="width: 100%"><INPUT type="button" onclick="themTtptDoanTtkt()" value="Th&#234;m"> <INPUT type="button" value="X&#243;a" id="xoaDaiDienDoanTtkt"></DIV>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td colspan="6">
			<fieldset><legend>&#272;&#7841;i di&#7879;n &#273;&#417;n v&#7883; &#273;&#432;&#7907;c Thanh tra Ki&#7875;m tra</legend>
			<TABLE id="daiDienDonViDuocTtkt" width="100%">
				<tr class="TdHeaderList">
					<td align="center" width="10%">STT</td>
					<td width="40%">&#212;ng/B&#224; <font color=red>*</font></td>
					<td width="40%">Ch&#7913;c v&#7909; <font color=red>*</font></td>
					<td align="center" width="10%"><INPUT type="checkbox"></td>
				</tr>
				<logic:present name="CongBoQuyetDinhForm" property="arrDaiDienDonViDuocTtkt">
					<logic:iterate id="ttptDonViDuocTtkt" name="CongBoQuyetDinhForm" property="arrDaiDienDonViDuocTtkt" indexId="index">
						<tr class='row<%=(index.intValue() % 2)+1 %>'>
							<td align="center"><%=index.intValue() + 1%></td>
							<td><html:hidden name="CongBoQuyetDinhForm" property='<%="arrDaiDienDonViDuocTtkt[" + index + "].idCanBo"%>' /> <html:text styleClass="text" readonly="readonly" name="CongBoQuyetDinhForm" property='<%="arrDaiDienDonViDuocTtkt[" + index + "].hoTen"%>'>
							</html:text></td>
							<td><html:text styleClass="text" readonly="readonly" name="CongBoQuyetDinhForm" property='<%="arrDaiDienDonViDuocTtkt[" + index + "].chucVu"%>'>
							</html:text></td>
							<td align="center"><INPUT type="checkbox"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</TABLE>
			<DIV align="right" style="width: 100%"><INPUT type="button" onclick="themTtptDonViDuocTtkt()" value="Th&#234;m"> <INPUT type="button" value="X&#243;a" id="xoaDaiDienDonViDuocTtkt"></DIV>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td width="24%" align="right">&#221; ki&#7871;n ph&#225;t bi&#7875;u</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" align="left"><html:textarea style="width: 100%" property="ykienPhatBieu">
			</html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Th&#7901;i &#273;i&#7875;m k&#7871;t th&#250;c</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" align="left"><html:text styleClass="text" property="thoiDiemCbDen" onblur="isDate(this)" onkeypress="return formatDate(event, this)">
			</html:text></td>
		</tr>
	</TABLE>
	<html:hidden property="idDonViDuocTtkt" />
	<html:hidden property="idDonViTienHanh" />
</html:form>
<script language="javascript">
var tableDaiDienCoQuanBanHanhQuyetDinh = new TableObject('daiDienCoQuanBanHanhQuyetDinh', true, 'xoaTtptCqtBanHanhQd');
function themTtptCqtBanHanhQd(){
	tableDaiDienCoQuanBanHanhQuyetDinh.addRow(createNewDaiDienCoQuanBanHanhQuyetDinh());
}
function createNewDaiDienCoQuanBanHanhQuyetDinh(){
	arrDaiDienCqBanHanhQD = new Array(); 
	index = tableDaiDienCoQuanBanHanhQuyetDinh.numOfRow - 1;
	arrDaiDienCqBanHanhQD[0] = '<input type="hidden" name="arrDaiDienCqtBanHanhQD[' + index + '].idCanBo">'
	arrDaiDienCqBanHanhQD[0] += '<input type="text" name="arrDaiDienCqtBanHanhQD[' + index + '].tenCanBo" class="text" readonly="readonly">'				
	arrDaiDienCqBanHanhQD[0] += '<Input type="button" value="..." onclick="chonNhanVienCqtBanHanh(this)">'
	arrDaiDienCqBanHanhQD[1] = '<input type="text" name="arrDaiDienCqtBanHanhQD[' + index + '].chucVu" class="text" readonly="readonly">'				
	arrDaiDienCqBanHanhQD[2] = '<input type="checkBox">'				
	return arrDaiDienCqBanHanhQD;
}
var tableDaiDienCqqlCapTren = new TableObject('daiDienCqqlCapTren', true, 'xoaTtptCqqlCapTren');
function themTtptCqqlCapTren(){
	tableDaiDienCqqlCapTren.addRow(createNewDaiDienCqqlCapTren());
}
function createNewDaiDienCqqlCapTren(){
	arrDaiDienCqqlCapTren = new Array(); 
	index = tableDaiDienCqqlCapTren.numOfRow - 1;
	arrDaiDienCqqlCapTren[0] = '<input type="hidden" name="arrDaiDienCqqlCapTren[' + index + '].idCanBo">'
	arrDaiDienCqqlCapTren[0] += '<input type="text" name="arrDaiDienCqqlCapTren[' + index + '].chucVu" class="text">'				
	arrDaiDienCqqlCapTren[1] = '<input type="text" name="arrDaiDienCqqlCapTren[' + index + '].chucVu" class="text">'				
	arrDaiDienCqqlCapTren[2] = '<input type="checkBox">'				
	return arrDaiDienCqqlCapTren;
}
var tableDaiDienDoanTtkt = new TableObject('daiDienDoanTtkt', true, 'xoaDaiDienDoanTtkt');
function themTtptDoanTtkt(){
	tableDaiDienDoanTtkt.addRow(createNewDaiDienDoanTtkt());
}
function createNewDaiDienDoanTtkt(){
	arrDaiDienDoanTtkt = new Array();
	index = tableDaiDienDoanTtkt.numOfRow - 1;
	arrDaiDienDoanTtkt[0] = '<SELECT name="arrDaiDienDoanTtkt[' + index + '].idCanBo" onchange="document.getElementsByName(this.name.replace(\'.idCanBo\', \'.chucVu\'))[0].value = getChucVuTvd(this.value)">';	
	arrDaiDienDoanTtkt[0] += cbDsThanhVienDoan;
	arrDaiDienDoanTtkt[0] += '</SELECT>';
	arrDaiDienDoanTtkt[1] = '<INPUT type="text" class="text" name="arrDaiDienDoanTtkt[' + index + '].chucVu"> ';
	arrDaiDienDoanTtkt[2] = '<INPUT type=checkbox>';
	return arrDaiDienDoanTtkt;
}
var tableDaiDienDonViDuocTtkt = new TableObject('daiDienDonViDuocTtkt', true, 'xoaDaiDienDonViDuocTtkt');
function themTtptDonViDuocTtkt(){
	tableDaiDienDonViDuocTtkt.addRow(createNewDaiDienDonViDuocTtkt());
}
function createNewDaiDienDonViDuocTtkt(){
	arrDaiDienDonViDuocTtkt = new Array(); 
	index = tableDaiDienDonViDuocTtkt.numOfRow - 1;
	arrDaiDienDonViDuocTtkt[0] = '<input type="hidden" name="arrDaiDienDonViDuocTtkt[' + index + '].idCanBo">'
	arrDaiDienDonViDuocTtkt[0] += '<input type="text" name="arrDaiDienDonViDuocTtkt[' + index + '].tenCanBo" class="text" readonly="readonly">'				
	arrDaiDienDonViDuocTtkt[0] += '<Input type="button" value="..." onclick="chonNhanVienCqtBi(this)">'
	arrDaiDienDonViDuocTtkt[1] = '<input type="text" name="arrDaiDienDonViDuocTtkt[' + index + '].chucVu" class="text" readonly="readonly">'				
	arrDaiDienDonViDuocTtkt[2] = '<input type="checkBox">'				
	return arrDaiDienDonViDuocTtkt;
}

function validateForm(){
	return true;
}		


function chonNhanVienCqtBi(lovButton){
	
	selectedRow = lovButton.parentNode.parentNode;	 
	// id, ten
	canBoCol = selectedRow.childNodes[1]; 
	hiddenIdCanBo = canBoCol.childNodes[0];
	txtTenCanBo = canBoCol.childNodes[1];
	
	// Chuc vu
	chucVuCongTacCol = selectedRow.childNodes[3];
	txtChucVu = chucVuCongTacCol.childNodes[0];
	url = "tim_kiem_canBo.do?method=execute&select=nhanviencqt&tenNhanVien=" + txtTenCanBo.value + "&macqt=" + document.getElementsByName('idDonViDuocTtkt')[0].value;
	win = window.open(url,"","menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no,height=600,width=600,top=0,left=0");
	
	win.focus(); 
	
}
function chonNhanVienCqtBanHanh(lovButton){
	
	selectedRow = lovButton.parentNode.parentNode;	
	// id, ten
	canBoCol = selectedRow.childNodes[1]; 
	hiddenIdCanBo = canBoCol.childNodes[0];
	txtTenCanBo = canBoCol.childNodes[1];
	
	// Chuc vu
	chucVuCongTacCol = selectedRow.childNodes[3];
	txtChucVu = chucVuCongTacCol.childNodes[0];
	url = "tim_kiem_canBo.do?method=execute&select=nhanviencqt&tenNhanVien=" + txtTenCanBo.value + "&macqt=" + document.getElementsByName('idDonViTienHanh')[0].value;
	win = window.open(url,"","menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no,height=600,width=600,top=0,left=0");	
	win.focus(); 
	
}
function chonNhanVien(lovButton){
	selectedRow = lovButton.parentNode.parentNode;	
	// id, ten
	canBoCol = selectedRow.childNodes[1]; 
	hiddenIdCanBo = canBoCol.childNodes[0];
	txtTenCanBo = canBoCol.childNodes[1];
	
	// Chuc vu
	chucVuCongTacCol = selectedRow.childNodes[3];
	txtChucVu = chucVuCongTacCol.childNodes[0];
	//win = window.open("tim_kiem_canBo.do?method=execute&select=nhanviencqt&tenNhanVien=" + txtTenCanBo.value,"","menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no,height=600,width=600,top=0,left=0");
	win = window.open("tim_kiem_canBo.do?method=execute&select=nhanviencqt&tenNhanVien=" + txtTenCanBo.value,"","");
	win.focus(); 
}
var hiddenIdCanBo;
var txtTenCanBo;
var txtChucVu;
function setThongTinNhanVienFromLov(ma, ten, chucVu){
	hiddenIdCanBo.value = ma;
	txtTenCanBo.value = ten;
	txtChucVu.value = chucVu;
}
</script>