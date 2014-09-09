<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<SELECT id="thchiTietDsTvd" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="chiTietDsTvd" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<html:form action="tien_hanh_ttkt.do?method=save&type=congBoQd">
	<TABLE width="100%">
		<tr>
			<td width="19%" align="right">Thời điểm công bố <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="30%"><html:text styleClass="text" property="thoiDiemCbTu" onblur="if(!isTime(this)) return; validateRequiredDate(this);" onkeypress="return formatTime(event, this)"></html:text></td>
			<td width="19%" align="right">Địa điểm <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="30%"><html:text styleClass="text" property="diaDiem"></html:text></td>
		</tr>
		<tr>
			<td align="right">Đại diện cơ quan ban hành quyết định</td>
			<td></td>
			<td colspan="4">
			<fieldset style="margin: 0">
			<DIV>
			<TABLE id="daiDienCoQuanBanHanhQuyetDinh" width="100%">
				<tr class="TdHeaderList">
					<td align="center" width="10%">STT</td>
					<td width="40%">Ông/Bà <font color=red>*</font></td>
					<td width="40%">Chức vụ <font color=red>*</font></td>
					<td align="center" width="10%"><INPUT type="checkbox"></td>
				</tr>
				<logic:present name="TienHanhTtktForm" property="arrDaiDienCqtBanHanhQD">
					<logic:iterate id="ttptCqtBanHanhQd" name="TienHanhTtktForm" property="arrDaiDienCqtBanHanhQD" indexId="index">
						<tr class='row<%=(index.intValue() % 2)+1 %>'>
							<td align="center"><%=index.intValue() + 1%></td>
							<td><html:hidden name="TienHanhTtktForm" property='<%="arrDaiDienCqtBanHanhQD[" + index + "].idCanBo"%>' /> <html:text styleClass="text" readonly="readonly" name="TienHanhTtktForm" style="width:75%" property='<%="arrDaiDienCqtBanHanhQD[" + index + "].hoTen"%>'
								onchange='<%="chonNhanVienCqtBanHanh(" + index + ")"%>'>
							</html:text> <INPUT type="button" value="..." onclick="chonNhanVienCqtBanHanh(<%=index%>)" class="lovButton"></td>
							<td><html:text styleClass="text1" name="TienHanhTtktForm" property='<%="arrDaiDienCqtBanHanhQD[" + index + "].chucVu"%>' style="border-bottom:none; width:100%" readonly="true">
							</html:text></td>
							<td align="center"><INPUT type="checkbox"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</TABLE>
			</DIV>
			<DIV align="right" style="width: 100%; text-align: right;"><INPUT type="button" onclick="themTtptCqtBanHanhQd()" value="Thêm"> <INPUT type="button" id="xoaTtptCqtBanHanhQd" value="Xóa"></DIV>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td align="right">Đại diện cơ quan quản lý cấp trên</td>
			<td></td>
			<td colspan="4">
			<fieldset style="width: 100%; margin: 0">
			<DIV>
			<TABLE id="daiDienCqqlCapTren" width="100%">
				<tr class="TdHeaderList">
					<td width="10%" align="center">STT</td>
					<td width="40%">Ông/Bà <font color=red>*</font></td>
					<td width="40%">Chức vụ <font color=red>*</font></td>
					<td align="center" width="10%"><INPUT type="checkbox"></td>
				</tr>
				<logic:present name="TienHanhTtktForm" property="arrDaiDienCqqlCapTren">
					<logic:iterate id="ttptCqqlCapTren" name="TienHanhTtktForm" property="arrDaiDienCqqlCapTren" indexId="index">
						<tr class='row<%=(index.intValue() % 2)+1 %>'>
							<td align="center"><%=index.intValue() + 1%></td>
							<td><html:hidden name="TienHanhTtktForm" property='<%="arrDaiDienCqqlCapTren[" + index + "].idCanBo"%>' /> <html:text styleClass="text" readonly="readonly" name="TienHanhTtktForm" property='<%="arrDaiDienCqqlCapTren[" + index + "].hoTen"%>' style="width:85%">
							</html:text></td>
							<td><html:text styleClass="text" readonly="readonly" name="TienHanhTtktForm" property='<%="arrDaiDienCqqlCapTren[" + index + "].chucVu"%>' style="width:85%">
							</html:text></td>
							<td align="center"><INPUT type="checkbox"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</TABLE>
			</DIV>
			<DIV align="right" style="text-align: right; width: 100%"><INPUT type="button" onclick="themTtptCqqlCapTren()" value="Thêm"> <INPUT type="button" id="xoaTtptCqqlCapTren" value="Xóa"></DIV>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td align="right"><!-- Đại diện đoàn Thanh tra
			Kiểm tra --> Đại diện đoàn Kiểm tra <font color=red>*</font></td>
			<td></td>
			<td colspan="4">
			<fieldset style="margin: 0">
			<DIV>
			<TABLE id="daiDienDoanTtkt" width="100%">
				<tr class="TdHeaderList">
					<td width="10%" align="center">STT</td>
					<td width="40%">Ông/Bà <font color=red>*</font></td>
					<td width="40%">Chức vụ trong đoàn <font color=red>*</font></td>
					<td align="center" width="10%"><INPUT type="checkbox"></td>
				</tr>
				<logic:present name="TienHanhTtktForm" property="arrDaiDienDoanTtkt">
					<logic:iterate id="ttptDoanTtkt" name="TienHanhTtktForm" property="arrDaiDienDoanTtkt" indexId="index">
						<tr class='row<%=(index.intValue() % 2)+1 %>'>
							<td align="center"><%=index.intValue() + 1%></td>
							<td><html:select name="TienHanhTtktForm" property='<%="arrDaiDienDoanTtkt[" + index + "].idCanBo"%>' onclick="cacheOldValue(this)" onchange="chonThanhVienDoan(this)" style="width:90%">
								<html:options collection="chiTietDsTvd" property="idCanBo" labelProperty="tenCanBo" />
							</html:select> <html:hidden name="TienHanhTtktForm" property='<%="arrDaiDienDoanTtkt[" + index + "].hoTen"%>' /></td>
							<td><html:text styleClass="text1" readonly="readonly" name="TienHanhTtktForm" property='<%="arrDaiDienDoanTtkt[" + index + "].chucVu"%>' style="border-bottom:none; width:100%" readonly="true">
							</html:text></td>
							<td align="center"><INPUT type="checkbox"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</TABLE>
			</DIV>
			<DIV align="right" style="text-align: right; width: 100%"><INPUT type="button" onclick="themTtptDoanTtkt()" value="Thêm" id="chuaNhapDaiDienDoanTt"> <INPUT type="button" value="Xóa" id="xoaDaiDienDoanTtkt"></DIV>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td align="right"><!-- Đại diện đơn vị
			được Thanh tra Kiểm tra --> Đại diện đơn vị được Kiểm tra <font color=red>*</font></td>
			<td></td>
			<td colspan="4">
			<fieldset style="margin: 0">
			<DIV>
			<TABLE id="daiDienDonViDuocTtkt" width="100%">
				<tr class="TdHeaderList">
					<td align="center" width="10%">STT</td>
					<td width="40%">Ông/Bà <font color=red>*</font></td>
					<td width="40%">Chức vụ <font color=red>*</font></td>
					<td align="center" width="10%"><INPUT type="checkbox"></td>
				</tr>
				<logic:present name="TienHanhTtktForm" property="arrDaiDienDonViDuocTtkt">
					<logic:iterate id="ttptDonViDuocTtkt" name="TienHanhTtktForm" property="arrDaiDienDonViDuocTtkt" indexId="index">
						<tr class='row<%=(index.intValue() % 2)+1 %>'>
							<td align="center"><%=index.intValue() + 1%></td>
							<td><html:hidden name="TienHanhTtktForm" property='<%="arrDaiDienDonViDuocTtkt[" + index + "].idCanBo"%>' /> 
							<html:text styleClass="text" readonly="readonly" name="TienHanhTtktForm" property='<%="arrDaiDienDonViDuocTtkt[" + index + "].hoTen"%>'
								style="width:75%">
							</html:text> 
							<!-- <INPUT type="button" class="lovButton" value="..." onclick='<%="chonNhanVienCqtBi(" + index + ")"%>'> -->
							</td>
							<td><html:text name="TienHanhTtktForm" property='<%="arrDaiDienDonViDuocTtkt[" + index + "].chucVu"%>' style="border-bottom:none; width:100%">
							</html:text></td>
							<td align="center"><INPUT type="checkbox"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</TABLE>
			</DIV>
			<DIV align="right" style="text-align: right; width: 100%"><INPUT type="button" onclick="themTtptDonViDuocTtkt()" id="chuaNhapDaiDienDvDuocTtkt" value="Thêm"> <INPUT type="button" value="Xóa" id="xoaDaiDienDonViDuocTtkt"></DIV>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td width="19%" align="right">Ý kiến phát biểu</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" align="left"><html:textarea styleClass="textareaContent" property="ykienPhatBieu" onkeypress="imposeMaxLength(this);" >
			</html:textarea></td>
		</tr>
		<tr>
			<td width="19%" align="right">Thời điểm kết thúc <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left"><html:text styleClass="text" property="thoiDiemCbDen" onblur="isTime(this)" onkeypress="return formatTime(event, this)">
			</html:text></td>
			<td colspan="2"></td>
			<td align="right"><INPUT type="button" class="button1" onclick="inBienBanCongBo()" value="In biên bản công bố"></td>
		</tr>
	</TABLE>
	<html:hidden property="idDonViDuocTtkt" styleId="idDonViDuocTtkt"/>
	<html:hidden property="idDonViTienHanh" styleId="idDonViTienHanh"/>
	<html:hidden property="idCongBoQuyetDinh" />
	<html:hidden property="idDaiDienCqqlCapTren" />
	<html:hidden property="idDaiDienDoanTtkt" />
	<html:hidden property="idDaiDienDonViDuocTtkt" />
	<html:hidden property="idDaiDienCqBanHanhQd" />
</html:form>
<script language="javascript">
function inBienBanCongBo(){
	if(!validateCongBoQuyetDinh())
		return;
	var printfForm = findForm('/' + contextRoot + '/tien_hanh_ttkt.do?method=save&type=congBoQd');	
	printfForm.action = 'tien_hanh_ttkt.do?method=in&type=congBoQd&' + 'idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	printfForm.submit();
	printfForm.action = '/' + contextRoot + '/tien_hanh_ttkt.do?method=save&type=congBoQd'; 
}
var ngayRaQd;
var ngayCongBoDuKien;
var thoiHanCongBo;
function onLoadCongBoQuyetDinh(){
	ngayRaQd = '<%=(String) request.getAttribute("ngayRaQd")%>';
	ngayCongBoDuKien = '<%=(String) request.getAttribute("ngayCongBoDuKien")%>'; 
	thoiHanCongBo = '<%=(String) request.getAttribute("thoiHanCongBo")%>';
	
	
}
function validateGridDaiDienCqtBanHanhQd(){
	gridDaiDienCqtBanHanhQd = document.getElementById('daiDienCoQuanBanHanhQuyetDinh');
		for(i = 1; i < gridDaiDienCqtBanHanhQd.rows.length; i++){
			if(!isRequired(document.getElementsByName('arrDaiDienCqtBanHanhQD['+ eval(i - 1) +'].hoTen')[0]))
				return false;
			if(!isRequired(document.getElementsByName('arrDaiDienCqtBanHanhQD['+ eval(i - 1) +'].chucVu')[0]))
				return false;
		}
	return true;
}
function validateGridDaiDienCoQuanQlCapTren(){
	gridDaiDienCqqlCapTren = document.getElementById('daiDienCqqlCapTren');
		for(i = 1; i < gridDaiDienCqqlCapTren.rows.length; i++){
			if(!isRequired(document.getElementsByName('arrDaiDienCqqlCapTren['+ eval(i - 1) +'].hoTen')[0]))
				return false;
			if(!isRequired(document.getElementsByName('arrDaiDienCqqlCapTren['+ eval(i - 1) +'].chucVu')[0]))
				return false;
		}
	return true;
}
function validateGridDaiDienDoanTtkt(){
	if(tableDaiDienDoanTtkt.numOfRow <= 1){
		alert('Chưa nhập đại diện đoàn thanh tra!');
		document.getElementById('chuaNhapDaiDienDoanTt').focus();
		return false; 
	}
	gridDaiDienDoanTtkt = document.getElementById('daiDienDoanTtkt');
		for(i = 1; i < gridDaiDienDoanTtkt.rows.length; i++){
			if(!isRequired(document.getElementsByName('arrDaiDienDoanTtkt['+ eval(i - 1) +'].idCanBo')[0]))
				return false;
			if(!isRequired(document.getElementsByName('arrDaiDienDoanTtkt['+ eval(i - 1) +'].chucVu')[0]))
				return false;
		}
	return true;
}
function validateGridDaiDienDonViDuocTtkt(){
	if(tableDaiDienDonViDuocTtkt.numOfRow <= 1){
		alert('Chưa nhập đại diện đơn vị được Thanh tra Kiểm tra!');
		document.getElementById('chuaNhapDaiDienDvDuocTtkt').focus();
		return false;
	}

	gridDaiDienDviDuocTtkt = document.getElementById('daiDienDonViDuocTtkt');
		for(i = 1; i < gridDaiDienDviDuocTtkt.rows.length; i++){
			if(!isRequired(document.getElementsByName('arrDaiDienDonViDuocTtkt['+ eval(i - 1) +'].hoTen')[0]))
				return false;
			if(!isRequired(document.getElementsByName('arrDaiDienDonViDuocTtkt['+ eval(i - 1) +'].chucVu')[0]))
				return false;
		}
	return true; 
}
function validateCongBoQuyetDinh(){
	if(!isRequired(document.getElementsByName('thoiDiemCbTu')[0]))
		return false;		
	if(!isRequired(document.getElementsByName('diaDiem')[0]))
		return false;
	if(!validateGridDaiDienCqtBanHanhQd())
		return false;
	if(!validateGridDaiDienCoQuanQlCapTren())
		return false;
	if(!validateGridDaiDienDoanTtkt())
		return false;
	if(!validateGridDaiDienDonViDuocTtkt())
		return false;
	if(!isRequired(document.getElementsByName('thoiDiemCbDen')[0]))
		return false;
	if(!compareTime(document.getElementsByName('thoiDiemCbTu')[0], document.getElementsByName('thoiDiemCbDen')[0], '<', 'Thời điểm kết thúc phải sau thời điểm bắt đầu!'))
		return false;
	return true;
	
	
}
var tableDaiDienCoQuanBanHanhQuyetDinh = new TableObject('daiDienCoQuanBanHanhQuyetDinh', true, 'xoaTtptCqtBanHanhQd');
function themTtptCqtBanHanhQd(){
	tableDaiDienCoQuanBanHanhQuyetDinh.addRow(createNewDaiDienCoQuanBanHanhQuyetDinh());
}
function createNewDaiDienCoQuanBanHanhQuyetDinh(){ 
	arrDaiDienCqBanHanhQD = new Array(); 
	index = tableDaiDienCoQuanBanHanhQuyetDinh.numOfRow - 1;
	arrDaiDienCqBanHanhQD[0] = '<input type="hidden" name="arrDaiDienCqtBanHanhQD[' + index + '].idCanBo">'
	arrDaiDienCqBanHanhQD[0] += '<input type="text" onchange = "chonNhanVienCqtBanHanh(' + index + ')" style="width:75%" name="arrDaiDienCqtBanHanhQD[' + index + '].hoTen" class="text">'				
	arrDaiDienCqBanHanhQD[0] += '<Input type="button" value="..." class = "lovButton" onclick="chonNhanVienCqtBanHanh(' + index + ')">'
	arrDaiDienCqBanHanhQD[1] = '<input type="text" name="arrDaiDienCqtBanHanhQD[' + index + '].chucVu" class="text1" style="border-bottom:none; width:100%" readonly="true">'				
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
	arrDaiDienCqqlCapTren[0] += '<input type="text" name="arrDaiDienCqqlCapTren[' + index + '].hoTen" class="text" style="width:85%">'				
	arrDaiDienCqqlCapTren[1] = '<input type="text" name="arrDaiDienCqqlCapTren[' + index + '].chucVu" class="text" style="width:85%">'				
	arrDaiDienCqqlCapTren[2] = '<input type="checkBox">'				
	return arrDaiDienCqqlCapTren; 
}
var tableDaiDienDoanTtkt = new TableObject('daiDienDoanTtkt', true, 'xoaDaiDienDoanTtkt');
function themTtptDoanTtkt(){
	tableDaiDienDoanTtkt.addRow(createNewDaiDienDoanTtkt()); 
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
		element = document.getElementsByName('arrDaiDienDoanTtkt[' + i + '].idCanBo')[0];
		if(element != null && element != controlIdTvd && element.value == controlIdTvd.value)
			return true;			
	}
	return false;
}
function chonThanhVienDoan(controlIdTvd){
	if(existInSelected(controlIdTvd)){
		alert('Thành viên đoàn này đã tồn tại!');
		//controlIdTvd.value = '';
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
	//document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = getChucVuTvd(controlIdTvd.value)
	//document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = controlIdTvd[controlIdTvd.selectedIndex].text;
}
function createNewDaiDienDoanTtkt(){
	arrDaiDienDoanTtkt = new Array();   
	temp =  '<%=request.getAttribute("cbChiTietDsTvd")%>';
	index = tableDaiDienDoanTtkt.numOfRow - 1;
	arrDaiDienDoanTtkt[0] = '<SELECT name="arrDaiDienDoanTtkt[' + index + '].idCanBo" onclick="cacheOldValue(this)" onchange="chonThanhVienDoan(this)" style="width:90%">';	
	arrDaiDienDoanTtkt[0] += temp;
	arrDaiDienDoanTtkt[0] += '</SELECT>';
	arrDaiDienDoanTtkt[0] += '<INPUT type="hidden" name="arrDaiDienDoanTtkt[' + index + '].hoTen"> ';
	
	arrDaiDienDoanTtkt[1] = '<INPUT type="text" class="text1" readonly="true" name="arrDaiDienDoanTtkt[' + index + '].chucVu" style="border-bottom:none; width:100%"> ';
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
	arrDaiDienDonViDuocTtkt[0] = '<input type="hidden" name="arrDaiDienDonViDuocTtkt[' + index + '].idCanBo" value="'+Math.uuid(10, 10)+'">'
	arrDaiDienDonViDuocTtkt[0] += '<input type="text" name="arrDaiDienDonViDuocTtkt[' + index + '].hoTen" class="text" style="width:75%">'				
	//arrDaiDienDonViDuocTtkt[0] += '<Input type="button" class = "lovButton" value="..." onclick="chonNhanVienCqtBi(' + index + ')">'
	arrDaiDienDonViDuocTtkt[1] = '<input type="text" name="arrDaiDienDonViDuocTtkt[' + index + '].chucVu" style="border-bottom:none; width:100%">'				
	arrDaiDienDonViDuocTtkt[2] = '<input type="checkBox">'				
	return arrDaiDienDonViDuocTtkt;
}

function validateForm(){
	return true;
}		 


function chonNhanVienCqtBi(index){

	// id, ten	
	hiddenIdCanBo = document.getElementsByName('arrDaiDienDonViDuocTtkt[' + index + '].idCanBo')[0];
	txtTenCanBo = document.getElementsByName('arrDaiDienDonViDuocTtkt[' + index + '].hoTen')[0];
	// Chuc vu
	txtChucVu = document.getElementsByName('arrDaiDienDonViDuocTtkt[' + index + '].chucVu')[0];
	// Type
	type = 'dvDuocKt';
	if($('#idDonViDuocTtkt').val()!=$('#idDonViTienHanh').val())
		showLovNhanVienWithCQTrucThuoc(document.getElementsByName('idDonViDuocTtkt')[0].value, txtTenCanBo);	
	else
		showLovNhanVien(maCqt, txtTenCanBo.value);	
	
	
} 
var type;
function chonNhanVienCqtBanHanh(index){ 
	// id, ten	
	hiddenIdCanBo = document.getElementsByName('arrDaiDienCqtBanHanhQD[' + index + '].idCanBo')[0];
	txtTenCanBo = document.getElementsByName('arrDaiDienCqtBanHanhQD[' + index + '].hoTen')[0];
	
	// Chuc vu
	txtChucVu = document.getElementsByName('arrDaiDienCqtBanHanhQD[' + index + '].chucVu')[0];
	
	// type
	type = 'cqtBh'
	
	showLovNhanVien(maCqt, txtTenCanBo);	
	
	
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
	
	
	showLovNhanVien(maCqt, txtTenCanBo.value);	
	
}
var hiddenIdCanBo;
var txtTenCanBo;
var txtChucVu;
function setThongTinNhanVienFromLov(ma, ten, chucVu){	
	var isExistCb = false;
	if(type == 'cqtBh'){
		for(var i = 0; i< tableDaiDienCoQuanBanHanhQuyetDinh.numOfRow - 1; i++){
			element = document.getElementsByName('arrDaiDienCqtBanHanhQD[' + i + '].idCanBo')[0];
			if(element != null && element != hiddenIdCanBo && element.value == ma)
				isExistCb = true;
				
		}
	}else if(type == 'dvDuocKt'){
		for(var i = 0; i< tableDaiDienDonViDuocTtkt.numOfRow - 1; i++){
			element = document.getElementsByName('arrDaiDienDonViDuocTtkt[' + i + '].idCanBo')[0];
			if(element != null && element != hiddenIdCanBo && element.value == ma){
				isExistCb = true;
			}				
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
</script>