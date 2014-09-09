<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<SELECT id="cbDsTvd" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="dsTvd" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<html:form action="kiem_ke.do?method=save&type=bbkk" method="POST">
	<html:hidden property="idDsTvd" />
	<html:hidden property="idBBKK" />
	<table align="center">
		<tr>
			<td width="19%" align="right">Th&#7901;i &#273;i&#7875;m l&#7853;p bi&#234;n b&#7843;n <font color=red>*</font></td>
			<td width="1%"></td>
			<td width="30%" align="left"><html:text styleClass="text" property="thoiDiemLapBb" onblur="isTime(this)" onkeypress="return formatTime(event, this)"></html:text></td>
			<td width="19%" align="right">Th&#7901;i &#273;i&#7875;m ki&#7875;m k&#234; <font color=red>*</font></td>
			<td width="1%"></td>
			<td width="30%" align="left"><html:text styleClass="text" property="thoiDiemKk" onblur="isTime(this)" onkeypress="return formatTime(event, this)"></html:text></td>
		</tr>
		<tr>
			<td width="19%" align="right">Th&#7901;i gian b&#7855;t &#273;&#7847;u <font color=red>*</font></td>
			<td width="1%"></td>
			<td width="30%" align="left"><html:text styleClass="text" property="thoiGianBatDau" onblur="isTime(this)" onkeypress="return formatTime(event, this)"></html:text></td>
			<td width="19%" align="right">Th&#7901;i gian k&#7871;t th&#250;c <font color=red>*</font></td>
			<td width="1%"></td>
			<td width="30%" align="left"><html:text styleClass="text" property="thoiGianKetThuc" onblur="isTime(this)" onkeypress="return formatTime(event, this)"></html:text></td>
		</tr>
		<tr>
			<td align="right">Th&#224;nh ph&#7847;n tham d&#7921; &#272;o&#224;n ki&#7875;m tra</td>
			<td></td>
			<td colspan="4">
			<fieldset style="margin: 0">
			<table width="100%" id="doanTTKT">
				<thead>
					<tr class=TdHeaderList>
						<th width="10%" align="center">STT</th>
						<th width="40%" align="left">H&#7885; t&#234;n</th>
						<th width="40%" align="left">Ch&#7913;c v&#7909;</th>
						<th width="10%" align="center"><input type="checkbox" onclick="chonTat()"></th>
					</tr>
				</thead>
				<tbody>
					<logic:present name="KiemKeForm" property="donViTtKt">
						<logic:iterate id="nhanVien" name="KiemKeForm" property="donViTtKt" indexId="index">
							<tr class='row<%=(index.intValue() % 2)+1 %>'>
								<td align="center"><%=index.intValue() + 1%></td>
								<td><html:select name="KiemKeForm" property='<%="donViTtKt[" + index + "].idCanBo"%>' onclick="cacheOldValue(this)" onchange='setChucVuByIdCabBo(this)' style="width:85%">
									<html:option value=""></html:option>
									<html:options collection="dsTvd" property="idCanBo" labelProperty="tenCanBo" />
								</html:select> <html:hidden property='<%="donViTtKt[" + index + "].hoTen"%>' /></td>
								<td><html:text styleClass="text1" name="KiemKeForm" property='<%="donViTtKt[" + index + "].chucVu"%>' readonly="true" style="border-bottom:none; width:100%">
								</html:text></td>
								<td align="center"><INPUT type="checkbox"></td>
							</tr>
						</logic:iterate>
					</logic:present>
				</tbody>
			</table>
			<div style="text-align: right; width: 100%"><INPUT type="button" class="button" onclick="AddRowTable1()" value="Th&#234;m"> <INPUT type="button" class="button" name="btnXoa" value="X&#243;a" id="xoaThanhVienDoan123"></div>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td align="right">Th&#224;nh ph&#7847;n tham d&#7921; &#272;&#417;n v&#7883; c&#225; nh&#226;n c&#243; t&#224;i s&#7843;n ki&#7875;m k&#234;</td>
			<td></td>
			<td colspan="4">
			<fieldset style="margin: 0">
			<table width="100%" id="dvDuocTTKT">
				<thead>
					<tr class=TdHeaderList>
						<th width="10%" align="center">STT</th>
						<th width="40%" align="left">H&#7885; t&#234;n <font color=red>*</font></th>
						<th width="40%" align="left">Ch&#7913;c v&#7909; <font color=red>*</font></th>
						<th width="10%" align="center"><INPUT type="checkbox" onclick="chonTat2()"></th>
					</tr>
				</thead>
				<tbody>
					<logic:present name="KiemKeForm" property="donViCoTaiSanDuocKK">
						<logic:iterate id="nhanVien" name="KiemKeForm" property="donViCoTaiSanDuocKK" indexId="index">
							<tr class='row<%=(index.intValue() % 2)+1 %>'>
								<td align="center"><%=index.intValue() + 1%></td>
								<td><html:text styleClass="text" name="KiemKeForm" property='<%="donViCoTaiSanDuocKK[" + index + "].hoTen"%>' style="width:85%" /></td>
								<td><html:text styleClass="text" name="KiemKeForm" property='<%="donViCoTaiSanDuocKK[" + index + "].chucVu"%>' style="width:85%" /></td>
								<td align="center"><INPUT type="checkbox"></td>
							</tr>
						</logic:iterate>
					</logic:present>
				</tbody>
			</table>
			<div style="text-align: right; width: 100%"><INPUT type="button" class="button" onclick="AddRowTable2()" value="Th&#234;m"> <INPUT type="button" class="button" value="X&#243;a" id="donviCoTsKK1"></div>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td width="19%" align="right">&#272;&#417;n v&#7883; c&#225; nh&#226;n &#273;&#432;&#7907;c giao b&#7843;o qu&#7843;n t&#224;i s&#7843;n</td>
			<td width="1%"></td>
			<td align="left" colspan="4"><html:textarea property="dvDuocGiaoBQTS" onkeypress="imposeMaxLength(this);"  styleClass="textareaTitle">
			</html:textarea></td>
		</tr>
		<tr>
			<td width="19%" align="right">S&#7889; l&#432;&#7907;ng, ch&#7911;ng lo&#7841;i, xu&#7845;t x&#7913; t&#236;nh tr&#7841;ng t&#224;i s&#7843;n ki&#7875;m k&#234;</td>
			<td width="1%"><font color=red>*</font></td>
			<td align="left" colspan="4"><html:textarea property="soluongChungloaiXs" onkeypress="imposeMaxLength(this);"  styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td align="right"><INPUT type="button" class="button1" onclick="inBbkk()" value="In bi&#xEA;n b&#x1EA3;n"></td>
		</tr>
	</table>
</html:form>
<script language="javascript">
function inbbkk(){
		document.forms[0].action = 'kiem_ke.do?method=in&type=bbkk';
		document.forms[0].submit();
	}
	
window.onload = function(){
	cbDsThanhVienDoan = '<%=request.getAttribute("cbChiTietDsTvd")%>'
	dsIdThanhVienDoan = '<%=request.getAttribute("dsIdThanhVienDoan")%>'
	//dsIdThanhVienDoan = dsIdThanhVienDoan.split(',');
	dsChucVuTrongDoan = '<%=request.getAttribute("dsChucVuTrongDoan")%>'
	//dsChucVuTrongDoan = dsChucVuTrongDoan.split(',');
	var dsTenTpTdDoan = '<%=(String)request.getAttribute("dsTenTpTdDoan")%>';
	var dsTenTpTdDuocKtXm = '<%=(String)request.getAttribute("dsTenTpTdDoanCoTlNp")%>';
	}
var dsTVDoanTtkt = new TableObject('doanTTKT', true, 'xoaThanhVienDoan123');
var dvCoTSDuocKK = new  TableObject('dvDuocTTKT', true, 'donviCoTsKK1');

function AddRowTable1() {
	dsTVDoanTtkt.addRow(createNewTptdTVD());
	 	
} 
function AddRowTable2() {
	dvCoTSDuocKK.addRow(createDVCOTSDuocKK());
	 	
}
function createNewTptdTVD(){
	arReturnRow = new Array();
	index = dsTVDoanTtkt.numOfRow - 1;
	arReturnRow[0] = '<select name = "donViTtKt['+ index +'].idCanBo" onclick="cacheOldValue(this)" onchange = "setChucVuByIdCabBo(this)" style="width:85%">'
	arReturnRow[0] += document.getElementById("cbDsTvd").innerHTML;
	arReturnRow[0] += '</select>'
	arReturnRow[0] += '<input type="hidden" name="donViTtKt['+ index +'].hoTen">'
	arReturnRow[1] = '<input type = "text" class="text1" name = "donViTtKt['+ index +'].chucVu" readonly="true" style="border-bottom:none; width:100%">';
	arReturnRow[2] = '<INPUT type=checkbox>';
	return arReturnRow;
	
}
function createDVCOTSDuocKK()
{
	arReturnRow = new Array();
	index = dvCoTSDuocKK.numOfRow - 1;
	arReturnRow[0] = '<INPUT type="text" class="text" name = "donViCoTaiSanDuocKK['+ index +'].hoTen" style="width:85%">'
	arReturnRow[1] = '<input type = "text" class="text" name = "donViCoTaiSanDuocKK['+ index +'].chucVu" style="width:85%">';
	arReturnRow[2] = '<INPUT type=checkbox>';
	return arReturnRow; 
}
function deleteDVCoTaiSanDuocKK()
{
	dvCoTSDuocKK.deleteSelectedRow();
}
function deleteThanhVienDoan(){
	dsTVDoanTtkt.deleteSelectedRow();
}
function chonTat(){
	dsTVDoanTtkt.selectAllRow();
}
function chonTat2(){
	dvCoTSDuocKK.selectAllRow();
}


function getChucVuById(idCanBo){
	var arrIdThanhVienDoan = dsIdThanhVienDoan.split(',');
	var arrChucVu = dsChucVuTrongDoan.split(',');
	for(i = 0; i < arrIdThanhVienDoan.length; i++){
		if(arrIdThanhVienDoan[i] == idCanBo)
			return arrChucVu[i];
	}
	return "code loi";
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
	for(var i = 0; i< dsTVDoanTtkt.numOfRow - 1; i++){
		element = document.getElementsByName('donViTtKt[' + i + '].idCanBo')[0];
		if(element != null && element != controlIdTvd && element.value == controlIdTvd.value)
			return true;			
	}
	return false;
}
function setChucVuByIdCabBo(controlIdTvd){  
		if(existInSelected(controlIdTvd)){
			alert('Th\u00E0nh vi\u00EAn n\u00E0y \u0111\u00E3 \u0111\u01B0\u1EE3c ch\u1ECDn!');
			controlIdTvd.value = tmpIdCanBo;
			document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = tmpTenCanBo;
			document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = tmpChucVu;
			controlIdTvd.focus();
			return;
		}
		cbDsTvd123 = document.getElementById('cbDsTvd');
		for(var i = 0; i< cbDsTvd123.length; i++){
			if(cbDsTvd123[i].value == controlIdTvd.value){
				chucVuEn = cbDsTvd123[i].title;
				document.getElementsByName(controlIdTvd.name.replace('.idCanBo', '.chucVu'))[0].value = getChucVuCoDau(chucVuEn);
				document.getElementsByName(controlIdTvd.name.replace('.idCanBo', '.hoTen'))[0].value = cbDsTvd123[i].text;
				return;
			}
		}
		
	}
	
function validateGridThanhPhanThamDuCoTaiSanKiemKe(){
	if(document.getElementById('dvDuocTTKT').rows.length <= 1){
		alert('Kh\u00F4ng c\u00F3 th\u00E0nh ph\u1EA7n tham d\u1EF1 \u0110\u01A1n v\u1ECB c\u00E1 nh\u00E2n c\u00F3 t\u00E0i s\u1EA3n ki\u1EC3m k\u00EA!');
		document.getElementById('dvDuocTTKT').focus();
		return false;
	}
	return true;
		
	
}

function validateNgayRaQDKK(){
	ngaylp = document.getElementsByName('ngayRaQd')[0].value;
	if(d2n(ngaylp) > d2n(document.getElementsByName('thoiDiemLapBb')[0].value.split(' ')[1])){
		alert('Ng\u00E0y l\u1EADp bi\u00EAn b\u1EA3n ki\u1EC3m k\u00EA kh\u00F4ng \u0111\u01B0\u1EE3c tr\u01B0\u1EDBc ng\u00E0y ra quy\u1EBFt \u0111\u1ECBnh ki\u1EC3m k\u00EA!');
		document.getElementsByName('thoiDiemLapBb')[0].focus();
		return false;		
	}
	return true;
}

function validateBienBan()
	{
		if(!isRequired(document.getElementsByName('thoiDiemLapBb')[0]))
			return false;
		if(!validateNgayRaQDKK())
			return false;
		if(!isRequired(document.getElementsByName('thoiDiemKk')[0]))
		return false;
		if(!isRequired(document.getElementsByName('thoiGianBatDau')[0]))
		return false;
		if(!isRequired(document.getElementsByName('thoiGianKetThuc')[0]))
		return false;
		if(!validateGridThanhPhanThamDuCoTaiSanKiemKe())
		return false;
		if(!isRequired(document.getElementsByName('soluongChungloaiXs')[0]))
		return false;
		if(!compareTime(document.getElementsByName('thoiGianBatDau')[0], document.getElementsByName('thoiGianKetThuc')[0], '<', 'Th\u1EDDi \u0111i\u1EC3m b\u1EAFt \u0111\u1EA7u ph\u1EA3i sau th\u1EDDi \u0111i\u1EC3m k\u1EBFt th\u00FAc!'))
		return false;
	return true;
}

function inBbkk(){
		if(!validateBienBan()) return fasle;
		//document.forms[0].action = 'kiem_ke.do?method=in&type=bbkk';
		//document.forms[0].submit();
		//document.forms[0].action = 'kiem_ke.do';
		var qdkkForm = findForm('/' + contextRoot + '/kiem_ke.do?method=save&type=qdkk'); 	 
	    var thongTinQd = '';
	    for(var i = 0; i< qdkkForm.elements.length; i++){
	    	element = qdkkForm.elements[i];
	    	if(!isEmpty(element.name) && !isEmpty(element.value)){
	    		thongTinQd += '&' + element.name + "=" + element.value;
	    	}
	    }	     
		var printfForm = findForm('/' + contextRoot + '/kiem_ke.do?method=save&type=bbkk'); 	   
	    printfForm.action = 'kiem_ke.do?method=in&type=bbkk&idCuocTtkt='+document.getElementsByName('idCuocTtkt')[0].value+thongTinQd;
	    printfForm.submit();                                    
	    printfForm.action = '/' + contextRoot + '/kiem_ke.do?method=save&type=bbkk'; 
	}
</script>