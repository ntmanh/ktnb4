<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<SELECT id="cbDsTvdBbNiemPhong" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="dsTvdBbNiemPhong" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<html:form action="niem_phong_ho_so_tai_lieu.do?method=save&type=bbNiemPhong" method="POST">
	<html:hidden property="idBbNiemPhong" />
	<TABLE width="100%" align="center">
		<TBODY>
			<tr>
				<td width="19%" align="right">Vào lúc <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text property="vaoLucBienBanNP" styleClass="text" onblur="isTime(this)" onkeypress="return formatTime(event, this)"></html:text></td>
				<td width="19%" align="right">Tại <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text property="taiDiaDiemNP" styleClass="text"></html:text></td>
			</tr>
			<tr>
				<td width="19%" align="right">Đoàn kiểm tra</td>
				<td width="1%"></td>
				<td width="80%" colspan="4">
				<fieldset style="margin: 0">
				<table width="100%" id="bbNP1">
					<thead>
						<tr class=TdHeaderList>
							<th width="10%" align="center">STT</th>
							<th width="40%" align="left">Họ tên</th>
							<th width="40%" align="left">Chức vụ</th>
							<th width="10%" align="center"><input type="checkbox" onclick="chonTat()"></th>
						</tr>
					</thead>
					<tbody>
						<logic:present name="NiemPhongHoSoTaiLieuForm" property="dsTVD">
							<logic:iterate id="nhanVien" name="NiemPhongHoSoTaiLieuForm" property="dsTVD" indexId="index">
								<tr class='row<%=(index.intValue() % 2)+1 %>'>
									<td align="center"><%=index.intValue() + 1%></td>
									<td><html:select name="NiemPhongHoSoTaiLieuForm" styleId='<%="dsTVD[" + index + "].hoTen"%>' property='<%="dsTVD[" + index + "].idCanBo"%>' onclick="cacheOldValue(this)" onchange="setChucVuByIdCabBo(this)" style="width:85%">
										<html:option value="" />
										<html:options collection="dsTvdBbNiemPhong" property="idCanBo" labelProperty="tenCanBo" />
									</html:select> <html:hidden property='<%="dsTVD[" + index + "].hoTen"%>' styleId='<%="dsTVD[" + index + "].Ten"%>' /></td>
									<td><html:text name="NiemPhongHoSoTaiLieuForm" styleClass="text1" property='<%="dsTVD[" + index + "].chucVu"%>' readonly="true" style="border-bottom:none; width:100%">
									</html:text></td>
									<td align="center"><INPUT type="checkbox"></td>
								</tr>
							</logic:iterate>
						</logic:present>
					</tbody>
				</table>
				<div style="text-align: right; width: 100%"><INPUT type="button" class="button" onclick="AddRowBBNP1()" value="Thêm"> <INPUT type="button" class="button" name="btnXoa" value="Xóa" id="delrowBBNP1"></div>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td width="19%" align="right">Đơn vị, các nhân có tài liệu niêm phong</td>
				<td width="1%"></td>
				<td width="80%" colspan="4">
				<fieldset style="margin: 0">
				<table width="100%" id="bbNP2">
					<thead>
						<tr class=TdHeaderList>
							<th width="10%" align="center">STT</th>
							<th width="40%" align="left">Họ tên <font color=red>*</font></th>
							<th width="40%" align="left">Chức vụ <font color=red>*</font></th>
							<th width="10%" align="center"><input type="checkbox" onclick="chonTat2()"></th>
						</tr>
					</thead>
					<tbody>
						<logic:present name="NiemPhongHoSoTaiLieuForm" property="dsDvCoTlnp">
							<logic:iterate id="nhanVien" name="NiemPhongHoSoTaiLieuForm" property="dsDvCoTlnp" indexId="index">
								<tr class='row<%=(index.intValue() % 2)+1 %>'>
									<td align="center"><%=index.intValue() + 1%></td>
									<td><html:hidden property='<%="dsDvCoTlnp[" + index + "].idCanBo"%>' /> <html:text property='<%="dsDvCoTlnp[" + index + "].hoTen"%>' styleClass="text" style="width:75%"></html:text> <input type="button" class="lovButton" value="..." onclick="chonNhanVienCqtBi('<%=index.intValue()%>')">
									</td>
									<td><html:text name="NiemPhongHoSoTaiLieuForm" property='<%="dsDvCoTlnp[" + index + "].chucVu"%>' styleClass="text1" readonly="true" style="border-bottom:none; width:100%">
									</html:text></td>
									<td align="center"><INPUT type="checkbox"></td>
								</tr>
							</logic:iterate>
						</logic:present>
					</tbody>
				</table>
				<div style="text-align: right; width: 100%"><INPUT type="button" class="button" onclick="AddRowBBNP2()" value="Thêm"> <INPUT type="button" class="button" name="btnXoa" value="Xóa" id="delrowBBNP2"></div>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td width="19%" align="right">Tiến hành niêm phong các tài liệu sau <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" colspan="4" align="left"><html:textarea property="tienHanhNPCacTaiLieu" onkeypress="imposeMaxLength(this);"  styleClass="textareaContent"></html:textarea></td>
			</tr>
			<tr>
				<td width="19%" align="right">Đơn vị cá nhân được giao bảo quản <font color=red>*</font></td>
				<td width="1%"></td>
				<td colspan="4" width="25%" align="left"><html:text styleClass="text" property="dinViCaNhanBaoQuanBbNp" style="width:100%"></html:text></td>
			</tr>
			<tr>
				<td width="19%" align="right">Thời gian niêm phong hoàn thành <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text property="thoiGianHoanThanhNP" styleClass="text" onblur="isTime(this)" onkeypress="return formatTime(event, this)"></html:text></td>
				<td align="right" colspan="3"><input type="button" class="button1" value="In biên bản" onclick="inBienBan()"></td>
			</tr>
		</TBODY>
	</TABLE>
	<html:hidden property="idThanhPhanThamDuDoanTtktBBNP" />
	<html:hidden property="idThanhPhanThamDuCacOngBaBBNP" />
	<html:hidden property="idDsTvdBbNiemPhong" />
</html:form>
<script language="javascript">

var dsTVDoanTtkt = new TableObject('bbNP1', true, 'delrowBBNP1');
var dsTVDoanCoTLNP = new TableObject('bbNP2', true,'delrowBBNP2');

function onLoadBbNiemPhong(){

	
}

	
function validateTable12(){
	if(dsTVDoanCoTLNP.numOfRow == 1){
		alert('Bạn cần nhập Đơn vị, cá nhân có tài liệu niêm phong của Biên bản niêm phong');
		return false;
	}
	for(i = 1; i< dsTVDoanCoTLNP.numOfRow; i++){
		if(!isRequired(document.getElementsByName('dsDvCoTlnp['+ eval(i-1) +'].idCanBo')[0]))
			return false;
	}
		
	return true;
}
function validateTable11(){
	for(i = 1; i< dsTVDoanTtkt.numOfRow; i++){
		if(!isRequired(document.getElementsByName('dsTVD['+ eval(i-1) +'].idCanBo')[0]))
			return false; 
	}
		
	return true;
}
function validateBbNp(){
	if(isEmpty(document.getElementsByName('idQdNiemPhong')[0].value)){
		alert('Chưa lưu quyết định niêm phong!');
		return false;
	}	
	if(!isRequired(document.getElementsByName('vaoLucBienBanNP')[0]))
		return false;
	if(!isRequired(document.getElementsByName('taiDiaDiemNP')[0]))
		return false;
	if(!validateTable11())
		return false;
	if(!validateTable12())
		return false;
	if(!isRequired(document.getElementsByName('tienHanhNPCacTaiLieu')[0]))  
		return false;
	if(!isRequired(document.getElementsByName('dinViCaNhanBaoQuanBbNp')[0]))
		return false;
	if(!isRequired(document.getElementsByName('thoiGianHoanThanhNP')[0]))
		return false;
	if(!compareTime(document.getElementsByName('vaoLucBienBanNP')[0], document.getElementsByName('thoiGianHoanThanhNP')[0], '<', 'Thời điểm lập biên bản niêm phong phải sau thời điểm hoàn thành biên bản niêm phong!'))
		return false;
	return true;
}
function AddRowBBNP1() {
	dsTVDoanTtkt.addRow(createNewTptdTVD1());	 	
}
 function AddRowBBNP2() {
	dsTVDoanCoTLNP.addRow(createNewDsDvCoTlnp());	 	
}
function createNewTptdTVD1(){
	arReturnRow = new Array();
	index = dsTVDoanTtkt.numOfRow - 1;
	arReturnRow[0] = '<select name = "dsTVD['+ index +'].idCanBo" onclick="cacheOldValue(this)" onchange = "setChucVuByIdCabBo(this)" style="width:85%">'
	arReturnRow[0] += document.getElementById('cbDsTvdBbNiemPhong').innerHTML;
	arReturnRow[0] += '</select>'
	arReturnRow[0] += '<input type="hidden" id ="dsTVD['+ index +'].Ten" name="dsTVD['+ index +'].hoTen" > ';
	arReturnRow[1] = '<input type = "text" class = "text1" name = "dsTVD['+ index +'].chucVu" readonly="true" style="border-bottom:none; width:100%">';
	arReturnRow[2] = '<INPUT type="checkbox">';
	return arReturnRow;
}
	 
function chonNhanVienCqtBi(index){
	 
	// id, ten
	hiddenIdCanBo = document.getElementsByName('dsDvCoTlnp['+ index + '].idCanBo')[0];
	txtTenCanBo = document.getElementsByName('dsDvCoTlnp['+ index + '].hoTen')[0];
	
	// Chuc vu
	chucVuCongTacCol = document.getElementsByName('dsDvCoTlnp['+ index + '].chucVu')[0];
	txtChucVu = document.getElementsByName('dsDvCoTlnp['+ index + '].chucVu')[0];
	
	showLovNhanVien(document.getElementsByName("idCqtBi")[0].value, txtTenCanBo);
	
} 
function createNewDsDvCoTlnp(){
	arReturnRow = new Array();
	index = dsTVDoanCoTLNP.numOfRow - 1;
	arReturnRow[0] = '<input type="hidden" name="dsDvCoTlnp[' + index + '].idCanBo">'
	arReturnRow[0] += '<input type="text" class = "text" name="dsDvCoTlnp[' + index + '].hoTen" class="text" onchange = "chonNhanVienCqtBi(' + index + ')" style="width:75%">'				
	arReturnRow[0] += '<Input type="button" class = "lovButton" value="..." onclick="chonNhanVienCqtBi('+ index +')">'
	arReturnRow[1] = '<input type="text" name="dsDvCoTlnp[' + index + '].chucVu" class="text1" readonly="true" style="border-bottom:none; width:100%">'	
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
	dsTVDoanCoTLNP.selectAllRow();
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
		element = document.getElementsByName('dsTVD[' + i + '].idCanBo')[0];
		if(element != null && element != controlIdTvd && element.value == controlIdTvd.value)
			return true;			
	}
	return false;
}	

function setChucVuByIdCabBo(controlIdTvd){  
	if(existInSelected(controlIdTvd)){
		alert('Thành viên này đã được chọn!');
		controlIdTvd.value = tmpIdCanBo;
		document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = tmpTenCanBo;
		document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = tmpChucVu;
		controlIdTvd.focus();
		return;
	}
	dsCanBoHopDoanTk = document.getElementById('cbDsTvdBbNiemPhong');
	for(var i = 0; i< dsCanBoHopDoanTk.length; i++){
		if(dsCanBoHopDoanTk[i].value == controlIdTvd.value){
			chucVuEn = dsCanBoHopDoanTk[i].title;
			document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.hoTen'))[0].value = dsCanBoHopDoanTk[i].text;
			document.getElementsByName(controlIdTvd.name.replace('.idCanBo','.chucVu'))[0].value = getChucVuCoDau(chucVuEn);			
			return;
		}
	}			
}
function setChucVuByIdCabBo_old(cbThanhVienDoan){  
		cbDsTvdBbNiemPhong123 = document.getElementById('cbDsTvdBbNiemPhong');
		for(var i = 0; i< cbDsTvdBbNiemPhong123.length; i++){
			if(cbDsTvdBbNiemPhong123[i].value == document.getElementsByName('dsTVD[' + index + '].idCanBo')[0].value){
				chucVuEn = cbDsTvdBbNiemPhong123[i].title;
				document.getElementsByName(cbThanhVienDoan.name.replace('.idCanBo', '.chucVu'))[0].value = getChucVuCoDau(chucVuEn);
				document.getElementsByName(cbThanhVienDoan.name.replace('.idCanBo', '.hoTen'))[0].value = cbDsTvdBbNiemPhong123[i].text;
				return;
			}
		}		
}
	function inBienBan(){
	    if(!validateBbNp()) 
	    	return false; 
	    var qdnpForm = findForm('/' + contextRoot + '/niem_phong_ho_so_tai_lieu.do?method=save&type=qdNiemPhong'); 	 
	    var thongTinQd = '';
	    for(var i = 0; i< qdnpForm.elements.length; i++){
	    	element = qdnpForm.elements[i];
	    	if(!isEmpty(element.name) && !isEmpty(element.value)){
	    		thongTinQd += '&' + element.name + "=" + element.value;
	    	}
	    }	     
	    var printfForm = findForm('/' + contextRoot + '/niem_phong_ho_so_tai_lieu.do?method=save&type=bbNiemPhong'); 	   
	    printfForm.action = 'niem_phong_ho_so_tai_lieu.do?method=in&type=inBienBan&idCuocTtkt='+document.getElementsByName('idCuocTtkt')[0].value + thongTinQd;
	    printfForm.submit();                                    
	    printfForm.action = '/' + contextRoot + '/niem_phong_ho_so_tai_lieu.do?method=save&type=bbNiemPhong';      
	}

</script>