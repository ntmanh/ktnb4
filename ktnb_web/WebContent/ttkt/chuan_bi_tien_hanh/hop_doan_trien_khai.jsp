<%@page pageEncoding="UTF-8" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<SELECT id="cbDsTvdHopDoanTrienKhai" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="dsTvdHopTrienKhai" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<html:form action="chuan_bi_tien_hanh.do?method=save&type=hdtk" method="POST">
	<table align="left" width="100%">
		<tr>
			<td align="right" width="19%">Thời điểm bắt đầu <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="30%"><html:text styleClass="text" onkeypress="return formatTime(event, this)" onblur="if(!isTime(this)) return;validateDateRequired(this);" property="thoiDiemBatDau"></html:text></td>
			<td align="right" width="19%">Địa điểm họp <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="diaDiemHop"></html:text></td>
		</tr>
		<tr>
			<td align="right" width="19%">Về việc <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="100%" colspan="4"><html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  style="width: 100%" property="veViec"></html:textarea></td>
		</tr>
		<tr>
			<td align="right">Thành phần tham dự <font color=red>*</font></td>
			<td></td>
			<td align="left" width="100%" colspan="4">
			<fieldset id="FIELDSET" style="width: 100%; margin: 0">
			<TABLE id="tb_DS_TPTD" width="100%">
				<tr class="TdHeaderList">
					<TH width="10%">STT</TH>
					<TH width="40%">Ông (bà) <font color=red>*</font></TH>
					<TH width="40%">Chức vụ <font color=red>*</font></TH>
					<TH width="10%"><INPUT type="checkbox" name="selectAll" onclick="selectAll123xxxxxxxxxxxxx(this)"></TH>
				</tr>
				<logic:present name="ChuanBiTienHanhForm" property="thanhPhanThamDuHopDoanTrienKhai">
					<logic:iterate name="ChuanBiTienHanhForm" property="thanhPhanThamDuHopDoanTrienKhai" indexId="index" id="thanhVienDoan">
						<tr class='row<%=(index.intValue() % 2)+1 %>'>
							<td align="center"><%=index.intValue() + 1%></td>
							<td><html:select name="ChuanBiTienHanhForm" property='<%="thanhPhanThamDuHopDoanTrienKhai[" + index + "].idCanBo"%>' onclick="cacheOldValue(this)" onchange="chonThanhVienDoan(this)" style="width:80%">
								<html:options collection="dsTvdHopTrienKhai" property="idCanBo" labelProperty="tenCanBo" />
							</html:select> <html:hidden name="ChuanBiTienHanhForm" property='<%="thanhPhanThamDuHopDoanTrienKhai[" + index + "].hoTen"%>' /></td>
							<td><html:text name="ChuanBiTienHanhForm" property='<%="thanhPhanThamDuHopDoanTrienKhai[" + index + "].chucVu"%>' styleClass="text1" readonly="true" style="border-bottom:none; width:100%">
							</html:text></td>
							<td align="center"><INPUT type="checkbox" name="checkBoxTpTD" onclick="chonThanhPhanThamDu(this)"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</TABLE>
			<DIV align="right" style="text-align: right;"><INPUT type="button" onclick="themThanhPhanThamDu()" value="Thêm" id="addRow"> <INPUT type="button" onclick="xoaThanhVienThamDuHopDoanTrienKhai()" value="Xóa" id="xoaTblTpTdHopDoanTrienKhai"></DIV>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td align="right" width="19%">Nội dung <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="100%" colspan="4"><html:textarea styleClass="textareaContent" onkeypress="imposeMaxLength(this);"  property="noiDungHopDoanTrienKhai" style="width: 100%"></html:textarea></td>
		</tr>
		<tr>
			<td align="right" width="19%">Thời điểm kết thúc <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="30%"><html:text styleClass="text" onkeypress="return formatTime(event, this)" onblur="if(!isTime(this)) return;validateDateRequired(this);"  property="thoiDiemKetThuc"></html:text></td>
			<td align="right" width="19%"></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="right" width="30%"><INPUT type="button" class="button1" onclick="inBienBanHopDoanTrienKhai()" value="In biên bản"></td>
		</tr>
	</table>
	<html:hidden property="idBienBanHopTrienKhaiDoan" />
	<html:hidden property="isChangeHopDoanTrienKhai" />
	<html:hidden property="idDsTvdHopTrienKhai" />
	<html:select property="dsTvdHopTrienKhai" style="display: none;">
		<html:option value=""></html:option>
		<html:options collection="dsTvdHopTrienKhai" property="idCanBo" labelProperty="tenCanBo" />
	</html:select>
</html:form>
<script language="javascript">
function inBienBanHopDoanTrienKhai(){
	if(!validateHopDoanTrienKhai())    
			return;
	var thongTinQd = "";
	var qdForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=qd');	 
	for(var i = 0; i< qdForm.elements.length; i++){
		if(qdForm.elements[i].name != null && qdForm.elements[i].name != '' && qdForm.elements[i].value != null && qdForm.elements[i].value != '')
		thongTinQd += qdForm.elements[i].name + "=" + encodeURIComponent(qdForm.elements[i].value) + "&";
	}		
	thongTinQd += 'idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	
	var printfForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=hdtk');	
	printfForm.action = 'chuan_bi_tien_hanh.do?method=in&type=hdtk&' + thongTinQd;
	printfForm.submit();
	printfForm.action = '/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=hdtk'; 
}
var selectedThanhPhanThamDu = "";
var bangThanhPhanThamDu = new TableObject('tb_DS_TPTD', true, 'xoaTblTpTdHopDoanTrienKhai');
function selectAll123xxxxxxxxxxxxx(chkBxSelectAll){
	bangThanhPhanThamDu.selectAllRow();
}
function getCaNhanId(checkBox){
	return checkBox.parentNode.parentNode.childNodes[1].childNodes[0].value;
}

function xoaThanhVienThamDuHopDoanTrienKhai(){
	bangThanhPhanThamDu.deleteSelectedRow();
}

function themThanhPhanThamDu() {	
	bangThanhPhanThamDu.addRow(createNewThanhPhanThamDuRow());
}
function changeThanhPhanThamDu(cbThanhPhanThamDu){
	document.getElementsByName(cbThanhPhanThamDu.name.replace('.idCanBo', '.chucVu'))[0].value = getChucVuTrongDoan(cbThanhPhanThamDu.value);	
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
	arrNewThanhPhanThamDu[0] = '<SELECT name="thanhPhanThamDuHopDoanTrienKhai[' + index + '].idCanBo" onclick="cacheOldValue(this)" onchange="chonThanhVienDoan(this)" style="width:80%">';	
	arrNewThanhPhanThamDu[0] += document.getElementsByName('dsTvdHopTrienKhai')[0].innerHTML;
	arrNewThanhPhanThamDu[0] += '</SELECT>';
	arrNewThanhPhanThamDu[0] += '<INPUT type="hidden" name="thanhPhanThamDuHopDoanTrienKhai[' + index + '].hoTen">'
	
	arrNewThanhPhanThamDu[1] = '<INPUT type="text" class="text1" readonly="true" style="border-bottom:none; width:100%" name="thanhPhanThamDuHopDoanTrienKhai[' + index + '].chucVu"> ';
	arrNewThanhPhanThamDu[2] = '<INPUT type=checkbox>';
	return arrNewThanhPhanThamDu; 
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
	for(var i = 0; i< bangThanhPhanThamDu.numOfRow - 1; i++){
		element = document.getElementsByName('thanhPhanThamDuHopDoanTrienKhai[' + i + '].idCanBo')[0];
		if(element != null && element != controlIdTvd && element.value == controlIdTvd.value)
			return true;			
	}
	return false;
}
function chonThanhVienDoan(controlIdTvd){	
	if(existInSelected(controlIdTvd)){
		alert('Thành viên này đã được chọn!');
		controlIdTvd.value = tmpIdCanBo;
		document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = tmpTenCanBo;
		document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = tmpChucVu;
		controlIdTvd.focus();
		return;
	}
	dsCanBoHopDoanTk = document.getElementById('cbDsTvdHopDoanTrienKhai');
	for(var i = 0; i< dsCanBoHopDoanTk.length; i++){
		if(dsCanBoHopDoanTk[i].value == controlIdTvd.value){
			chucVuEn = dsCanBoHopDoanTk[i].title;
			document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = dsCanBoHopDoanTk[i].text;
			document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = getChucVuCoDau(chucVuEn);			
			return;
		}
	}	
}

function onloadHopDoanTrienKhai(){

}
function validateGridThanhPhanThamDuHopDoanTrienKhai(){
	if(document.getElementById('tb_DS_TPTD').rows.length <= 1){
		alert('Không có thành phần tham dự họp đoàn triển khai!');
		document.getElementById('tb_DS_TPTD').focus();
		return false;
	}
	return true;
		
	
}
function validateHopDoanTrienKhai(){
	if(!isRequired(document.getElementsByName('thoiDiemBatDau')[0]))
		return false;
	if(!isRequired(document.getElementsByName('diaDiemHop')[0]))
		return false;
	if(!isRequired(document.getElementsByName('veViec')[0]))
		return false;
	if(!validateGridThanhPhanThamDuHopDoanTrienKhai())
		return false;
	if(!isRequired(document.getElementsByName('noiDungHopDoanTrienKhai')[0]))
		return false;
	if(!checkNvarchar2('noiDungHopDoanTrienKhai', 'Chỉ được nhập tối đa 4000 ký tự!'))
		return false;		
	if(!isRequired(document.getElementsByName('thoiDiemKetThuc')[0]))
		return false;
	if(!compareTime(document.getElementsByName('thoiDiemBatDau')[0], document.getElementsByName('thoiDiemKetThuc')[0], '<', 'Thời điểm kết thúc phải sau thời điểm bắt đầu!'))
		return false;
	return true;
}

</script>