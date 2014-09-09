<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%>
<script>
	function selfClose(){
		window.close();
	}
	function xuLySauSaveThanhCong(){
	if(window.opener.location.href.indexOf('danh_sach_tim_kiem.do') > 0){
		window.opener.location.reload();	
	}else{
		window.close();
	}
}
	
</script>
<SELECT id="cbDsTvd" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="dsTvd" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<SELECT id="cbNoiDungTtkt" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="dsNoiDung" id="noiDung">
		<OPTION value="<bean:write name="noiDung" property="idNoiDung"/>"><bean:write name="noiDung" property="tenNoiDung" /></OPTION>
	</logic:iterate>
</SELECT>
<h3 class="Header">Phúc tra</h3>
<html:form action="phuc_tra.do">
	<html:hidden property="id" />
	<html:hidden property="idCuocTtKt" />
	<html:hidden property="idCoQuanThueCanPhucTra" />
	<html:hidden property="idNoiDungPhucTra" />
	<html:hidden property="idDVThucHien" />
	<html:hidden property="idDsTvd" />
	<html:hidden property="loaiND" />
	<html:hidden property="loaiNDHidden" />
	<fieldset>
	<TABLE width="100%" align="center">
		<TBODY>
			<tr>
				<td align="right" width="19%">Số quyết định <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text styleClass="text" property="soQuyetDinh"></html:text></td>
				<td width="19%" align="right">Ngày ra quyết định <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text styleClass="text" property="ngayRaQuyetDinh" onblur="if(!isDate(this)) return;validateDateRequired(this);"  onkeypress="return formatDate(event, this)"></html:text></td>
			</tr>
			<tr>
				<td align="right" width="19%">Nơi ký trình <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text styleClass="text" property="noiTrinh"></html:text></td>
				<td width="19%" align="right">Ngày ký trình <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text styleClass="text" property="ngayTrinh" onblur="if(!isDate(this)) return;validateDateRequired(this);"  onkeypress="return formatDate(event, this)"></html:text></td>
			</tr>
			<tr>
				<td align="right" width="19%">Nơi phê duyệt <font color=red>*</font></td>
				<td width="1%"></td>
				<td align="left" width="30%"><html:text styleClass="text" property="noiPheDuyet"></html:text></td>
				<td align="right" width="19%">Ngày phê duyệt <font color=red>*</font></td>
				<td width="1%"></td>
				<td align="left" width="30%"><html:text styleClass="text" property="ngayPheDuyet" onblur="if(!isDate(this)) return;validateDateRequired(this);"  onkeypress="return formatDate(event, this)"></html:text></td>
			</tr>
			<tr>
				<td align="right" width="19%">Ý kiến phê duyệt</td>
				<td width="1%"></td>
				<td colspan="4"><html:textarea property="kienPheDuyet" onkeypress="imposeMaxLength(this);"  styleClass="textareaTitle"></html:textarea></td>
			</tr>
			<tr>
				<td align="right" width="19%">Người đề nghị phúc tra <font color=red>*</font></td>
				<td width="1%"></td>
				<td align="left" width="30%">
				<table style="margin: 0" border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
					<tr>
						<td align="left" width="90%" style="margin: 0"><html:text styleClass="text" property="tenNguoiDeNghiPT" style="width: 100%"></html:text></td>
						<td align="left" width="10%" style="margin: 0"><input type="button" value="..." onclick="chonNguoiDeNghiPT()"> <html:hidden property="idNguoiDeNghiPT" /></td>
					</tr>
				</table>
				</td>
				<td align="right" width="19%">Chức vụ</td>
				<td width="1%"></td>
				<td align="left" width="30%"><html:text styleClass="text" property="cvNguoiDeNghiPT"></html:text> <html:hidden property="cqNguoiDeNghiPT" /></td>
			</tr>
			<tr>
				<td colspan="6">
				<fieldset style="margin: 0"><legend>Thông tin phúc tra</legend>
				<TABLE width="100%">
					<TBODY>
						<tr>
							<td align="right" width="19%">Kính gửi <font color=red>*</font></td>
							<td width="1%"></td>
							<td align="left" width="30%"><html:text styleClass="text" property="tenNguoiRaQd"></html:text></td>
							<td align="right" width="19%">Chức vụ</td>
							<td width="1%"></td>
							<td align="left" width="30%"><html:text styleClass="text" property="chucDanhNguoiRaQd"></html:text></td>
						</tr>
						<tr>
							<td align="right" width="19%">Đề nghị phúc tra tại <font color=red>*</font></td>
							<td width="1%"></td>
							<td align="left" width="30%"><html:text styleClass="text" property="tenCoQuanTueCanPhucTra"></html:text></td>
							<td colspan="3"></td>
						</tr>
						<tr>
							<td align="right" width="19%">Nội dung sai phạm <font color=red>*</font></td>
							<td width="1%"></td>
							<td colspan="4"><html:textarea property="noiDungNghiVan" onkeypress="imposeMaxLength(this);"  styleClass="textareaContent" /></td>
						</tr>
						<tr>
							<td colspan="6">
							<fieldset style="margin: 0"><legend>Quyết định kiểm tra cần phúc tra</legend>
							<TABLE width="100%">
								<TBODY>
									<tr>
										<td align="right" width="19%">Số quyết định</td>
										<td width="1%"></td>
										<td align="left" width="30%"><html:text styleClass="text" property="soQdTtKtCanPhucTra"></html:text></td>
										<td align="right" width="19%">Ngày ban hành</td>
										<td width="1%"></td>
										<td align="left" width="30%"><html:text styleClass="text" property="ngayLap" onblur="if(!isDate(this)) return;validateDateRequired(this);"  onkeypress="return formatDate(event, this)"></html:text></td>
									</tr>
									<tr>
										<td align="right" width="19%">Chức danh người ra quyết định</td>
										<td width="1%"></td>
										<td colspan="4"><html:text styleClass="text" property="chucDanhNguoiRaQd"></html:text></td>
									</tr>
								</TBODY>
							</TABLE>
							</fieldset>
							</td>
						</tr>
						<tr>
							<td colspan="6">
							<fieldset style="margin: 0"><legend>Nội dung phúc tra</legend>
							<table align="center">
								<tr>
									<td align="right" width="5%"><html:radio property="loaiND" value="NoiBo" onclick="radio(true)"></html:radio></td>
									<td width="2%"></td>
									<td align="left" width="25%">Phúc tra việc thực hiện công tác kiểm tra nội bộ</td>
									<td align="right" width="5%"><html:radio property="loaiND" value="Ngoai" onclick="radio(false)"></html:radio></td>
									<td width="2%"></td>
									<td align="left" width="25%">Phúc tra việc kiểm tra người nộp thuế</td>
								</tr>
							</table>
							<table id="NDPT2" width="100%">
								<tr>
									<td><html:textarea property="noiDungPhucTraNgoaiNganhThue" styleClass="textareaContent"></html:textarea></td>
								</tr>
							</table>
							<table id="NDPT" width="100%">
								<tr class=TdHeaderList>
									<td align="center" width="10%">STT</td>
									<td>Nội dung phúc tra</td>
									<td align="center" width="10%"><input type="checkbox" onclick="chonTat()"></td>
								</tr>
								<logic:present name="PhucTraForm" property="noiDungPhucTra">
									<logic:iterate id="nhanVien" name="PhucTraForm" property="noiDungPhucTra" indexId="index">
										<tr class='row<%=(index.intValue() % 2)+1 %>'>
											<td align="center"><%=index.intValue() + 1%></td>
											<td>
												<html:select name="PhucTraForm" property='<%="noiDungPhucTra[" + index + "].idNoiDung"%>' onchange="getTenNoiDung(this)">
													<html:option value="" />
													<html:options collection="dsNoiDung" property="idNoiDung" labelProperty="tenNoiDung" />
												</html:select> 
												<html:hidden property='<%="noiDungPhucTra[" + index + "].tenNoiDung"%>' />
											</td>
											<td align="center"><INPUT type="checkbox"></td>
										</tr>
									</logic:iterate>
								</logic:present>
							</table>
							<div class="pt-ndpt" style="text-align: right; width: 100%"><INPUT type="button" class="button" onclick="AddRowBBNP1()" value="Thêm"> <INPUT type="button" class="button" name="btnXoa" value="Xóa" id="delrowBBNP1"></div>
							</fieldset>
							</td>
						</tr>
						<tr>
							<td align="right" width="19%">Niên độ phúc tra từ <font color=red>*</font></td>
							<td width="1%"></td>
							<td align="left" width="30%"><html:text styleClass="text" property="nienDoTuNgay" onblur="if(!isDate(this)) return;validateDateRequired(this);"  onkeypress="return formatDate(event, this)"></html:text></td>
							<td align="right" width="19%">Đến <font color=red>*</font></td>
							<td width="1%"></td>
							<td align="left" width="30%"><html:text styleClass="text" property="nienDoDenNgay" onblur="if(!isDate(this)) return;validateDateRequired(this);" onkeypress="return formatDate(event, this)"></html:text></td>
						</tr>
						<tr>
							<td align="right" width="19%">Thời gian phúc tra <font color=red>*</font></td>
							<td width="1%"></td>
							<td colspan="4"><html:text styleClass="text" property="thoiGian" onblur="if(!isNumber(this,'i')) return;" onkeypress="return formatInt(event);" style="width:7%"></html:text> ngày</td>
						</tr>
						<tr>
							<td colspan="6">
							<fieldset style="margin: 0"><legend>Danh sách cán bộ thực hiện phúc tra</legend>
							<table id="TPTD" width="100%">
								<thead>
									<tr class=TdHeaderList>
										<th width="10%" align="center">STT</th>
										<th width="40%" align="left">Họ tên</th>
										<th width="40%" align="left">Chức vụ</th>
										<th width="10%" align="center"><input type="checkbox" onclick="chonTat2()"></th>
									</tr>
								</thead>
								<tbody>
									<logic:present name="PhucTraForm" property="dsCanBoThucHien">
										<logic:iterate id="ttptCqtBanHanhQd" name="PhucTraForm" property="dsCanBoThucHien" indexId="index">
											<tr class='row<%=(index.intValue() % 2)+1 %>'>
												<td align="center"><%=index.intValue() + 1%></td>
												<td><html:select property='<%="dsCanBoThucHien[" + index + "].idCanBo"%>' onclick="cacheOldValue(this)" onchange="setChucVuByIdCabBo(this)" style="width: 85%">
													<html:option value=""></html:option>
													<html:options collection="dsTvd" property="idCanBo" labelProperty="tenCanBo" />
												</html:select> <html:hidden property='<%="dsCanBoThucHien[" + index + "].hoTen"%>' /></td>
												<td><html:text styleClass="text1" name="PhucTraForm" property='<%="dsCanBoThucHien[" + index + "].chucVu"%>' readonly="true" style="border-bottom:none; width:100%">
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
					</TBODY>
				</TABLE>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td colspan="6" align="right"><INPUT type="button" value="In quyết định" class="button1" onclick="inQD()"></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
</html:form>
<fieldset style="margin: 0"><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></fieldset>
<%@ include file="/bottom.jsp"%>
<script language="javascript">
function getTenNoiDung(cbIdNoiDung){
	if(!exitNoiDung(cbIdNoiDung)){
	document.getElementsByName(cbIdNoiDung.name.replace('idNoiDung', 'tenNoiDung'))[0].value = cbIdNoiDung[cbIdNoiDung.selectedIndex].text;
	}
}
function exitNoiDung(id){
	var domDanhsachNoiDung = $('#NDPT tr td select');
	var pivort = 0;
	for(var i=0;i<domDanhsachNoiDung.length;i++){
		if(domDanhsachNoiDung[i].value!=""&& domDanhsachNoiDung[i].value==id.value){
			pivort ++;
		}
	}
	if(pivort>=2){
	alert("Đã chọn nội dung phúc tra này!");
	id.value="";
	return true;
	}
	return false;
}
 function tinhDenNgay(){
    	caculateDate('nienDoTuNgay', 'nienDoDenNgay', document.getElementsByName('thoiGian')[0].value);
    }

window.onload = function(){
	if(document.getElementsByName('loaiND')[0].value=='NoiBo')	
		radio(true);
	else
		radio(false);
	loaiPhucTra = document.getElementsByName('loaiND')[0].value;
	//thêm dòng trống trước các danh sách
	if($('#TPTD tbody tr').length==0){
		AddRowBBNP2();
	}
	if($('#NDPT tbody tr').length==1){
		AddRowBBNP1();
	}
}

	
var dsNoiDung = new TableObject('NDPT', true, 'delrowBBNP1');
var dsTPTD = new TableObject('TPTD', true, 'delrowBBNP2');
//------- validate table ---------------------------
function validateTable1(){
	if(dsNoiDung.numOfRow <= 1){
		alert('Chưa nhập nội dung phúc tra!');
		return false;
	}
	for(i = 1; i< dsNoiDung.numOfRow; i++){
		if(!isRequired(document.getElementsByName('noiDungPhucTra['+ eval(i-1) +'].idNoiDung')[0]))
			return false;
	}
		
	return true;
}
function validateTable2(){
	if(dsTPTD.numOfRow <= 1){
		alert('Chưa nhập danh sách cán bộ thực hiện!');
		return false;
	}
	for(i = 1; i< dsTPTD.numOfRow; i++){
		if(!isRequired(document.getElementsByName('dsCanBoThucHien['+ eval(i-1) +'].idCanBo')[0]))
			return false;
	}
		
	return true;
}

function existCheck1(table, thisCbo){
	for(i =1;i<table.numOfRow-1;i++){
		var	cbo =  document.getElementsByName('dsCanBoThucHien['+ eval(i-1) +'].idCanBo')[0] ;
		if(cbo.value == thisCbo.value){
		alert('Dữ liệu đã tồn tại');
		thisCbo.selectedIndex = 0;
		return false;
		}
	}
	
}
//-------------------------------------------------
// chon nguoi de nghi phuc tra
var maCqtTh = '<%=((cmc.com.ktnb.util.ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT)).getMaCqt()%>';

function chonNguoiDeNghiPT(){
	showLovNhanVien(maCqtTh, document.getElementsByName('tenNguoiDeNghiPT')[0]);
}

function setThongTinNhanVienFromLov(ma, ten, chucVu, tenPhong, tenCqt){
	 document.getElementsByName('idNguoiDeNghiPT')[0].value = ma;
	document.getElementsByName('tenNguoiDeNghiPT')[0].value = ten;
	 document.getElementsByName('cvNguoiDeNghiPT')[0].value =  chucVu;
	document.getElementsByName('cqNguoiDeNghiPT')[0].value = tenCqt;
}

//-------------------------------------------------
function AddRowBBNP1() {
	dsNoiDung.addRow(createNewTptdTVD1());	
} 
function AddRowBBNP2(){
	dsTPTD.addRow(createNewTptdTVD2());	
} 
function createNewTptdTVD2(){
	arrDaiDienDoanTtkt = new Array();
	index = dsTPTD.numOfRow - 1;
	arrDaiDienDoanTtkt[0] = '<SELECT name="dsCanBoThucHien[' + index + '].idCanBo" onclick="cacheOldValue(this)" onchange="setChucVuByIdCabBo(this)" style="width:85%">';	
	arrDaiDienDoanTtkt[0] += document.getElementById('cbDsTvd').innerHTML;
	arrDaiDienDoanTtkt[0] += '</SELECT>';
	arrDaiDienDoanTtkt[0] += '<input type="hidden" name="dsCanBoThucHien['+ index +'].hoTen" > ';
	arrDaiDienDoanTtkt[1] = '<INPUT type="text" class="text1"  name="dsCanBoThucHien[' + index + '].chucVu" readonly="true" style="border-bottom:none; width:100%"> ';
	arrDaiDienDoanTtkt[2] = '<INPUT type=checkbox>';
	return arrDaiDienDoanTtkt;
}


function createNewTptdTVD1(){
	arReturnRow = new Array();
	index = dsNoiDung.numOfRow - 1;		
	arReturnRow[0] = '<SELECT name="noiDungPhucTra[' + index + '].idNoiDung" onchange = "getTenNoiDung(this)">';	
	arReturnRow[0] += document.getElementById("cbNoiDungTtkt").innerHTML;
	arReturnRow[0] += '</SELECT>';
	arReturnRow[0] += '<input type="hidden" name="noiDungPhucTra['+ index +'].tenNoiDung" > ';
	arReturnRow[1] = '<INPUT type=checkbox>';
	
	return arReturnRow;
}	
function deleteThanhVienDoan(){
	dsNoiDung.deleteSelectedRow();
}


function chonTat(){
	dsNoiDung.selectAllRow();
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
function radio(loai){
	
	if(loai){
		loaiPhucTra = "NoiBo";
		$("#NDPT2").css("display","none"); 	
		$("#NDPT").css("display","inline");
		$(".pt-ndpt").css("display","inline");
		$('[name="loaiND"]')[0].value="NoiBo";

	}else{
		loaiPhucTra = "Ngoai";
		$("#NDPT").css("display","none"); 
		$("#NDPT2").css("display","inline");
		$(".pt-ndpt").css("display","none");		
		$('[name="loaiND"]')[0].value="Ngoai";
	}
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
	for(var i = 0; i< dsTPTD.numOfRow - 1; i++){
		element = document.getElementsByName('dsCanBoThucHien[' + i + '].idCanBo')[0];
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
	dsCanBoHopDoanTk = document.getElementById('cbDsTvd');
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
		cbDsTvd123 = document.getElementById('cbDsTvd');
		for(var i = 0; i< cbDsTvd123.length; i++){
			if(cbDsTvd123[i].value == document.getElementsByName('dsCanBoThucHien[' + index + '].idCanBo')[0].value){
				chucVuEn = cbDsTvd123[i].title;
				document.getElementsByName(cbThanhVienDoan.name.replace('.idCanBo', '.chucVu'))[0].value = getChucVuCoDau(chucVuEn);
				document.getElementsByName(cbThanhVienDoan.name.replace('.idCanBo', '.hoTen'))[0].value = cbDsTvd123[i].text;
				return;
			}
		}    
}  
function validateForm(){
	if(!isRequired(document.getElementsByName('ngayRaQuyetDinh')[0]))
		return false;
	if(!isRequired(document.getElementsByName('soQuyetDinh')[0]))
		return false;
	if(!isRequired(document.getElementsByName('noiTrinh')[0]))
		return false;
	if(!isRequired(document.getElementsByName('ngayTrinh')[0]))
		return false;
	if(!isRequired(document.getElementsByName('noiPheDuyet')[0]))
		return false;
	if(!isRequired(document.getElementsByName('ngayPheDuyet')[0]))
		return false;
	if(!isRequired(document.getElementsByName('tenNguoiDeNghiPT')[0]))
		return false;
	if(!isRequired(document.getElementsByName('tenNguoiRaQd')[0]))
		return false;
			
	if(!isRequired(document.getElementsByName('tenCoQuanTueCanPhucTra')[0]))
		return false;
	if(!isRequired(document.getElementsByName('noiDungNghiVan')[0]))
		return false;
	
	if(loaiPhucTra == "NoiBo"){
		if(!validateTable1())
			return false;
	}else{
		if(!isRequired(document.getElementsByName('noiDungPhucTraNgoaiNganhThue')[0]))
			return false;
	}
	if(!isRequired(document.getElementsByName('nienDoTuNgay')[0]))
		return false;
	if(!isRequired(document.getElementsByName('nienDoDenNgay')[0]))
		return false;		
	if(!compareDate(document.getElementsByName('nienDoTuNgay')[0], document.getElementsByName('nienDoDenNgay')[0],'Niên độ từ ngày phải trước đến ngày!'))
		return false;
	if(!compareDate(document.getElementsByName('ngayTrinh')[0], document.getElementsByName('ngayPheDuyet')[0], 'Ngày trình phải trước ngày phê duyệt!'))
		return false;
	if(!isRequired(document.getElementsByName('thoiGian')[0]))
		return false;
	if(!validateTable2())
		return false;
	
	

	return true;
}
function selfClose(){
		window.close();
	}
function inQD(){
	document.forms[0].loaiNDHidden.value=loaiPhucTra;
	document.forms[0].action = 'phuc_tra.do?method=in&type=inQD';
	document.forms[0].submit();
	document.forms[0].action = 'phuc_tra.do';
}
function inTT(){
	document.forms[0].action = 'phuc_tra.do?method=in&type=inTT'
	document.forms[0].submit();
	document.forms[0].action = 'phuc_tra.do';
}
function validateDateRequired(dateElement){
	var ngayRaQuyetDnh = '<%=request.getAttribute("ngayRaQuyetDnh")%>';
	if(ngayRaQuyetDnh!=null&&ngayRaQuyetDnh!=""){
		if(dateElement.value!=""){
		switch(dateElement.name){
		case "ngayLap":
			break;
		case "nienDoTuNgay":
			break;
		case "nienDoDenNgay":
			break;
		default:
			if((d2n(ngayRaQuyetDnh)>=d2n(dateElement.value))){  
				alert("Thời điểm phải sau ngày ra quyết định (" + ngayRaQuyetDnh + ")!");
				$(dateElement).focus().select();		
				onMouse	= false;
			}
			break;
			}
	}
}
}
//window.onbeforeunload = function(){
//	$('[name="nienDoTuNgay"]')[0].value="";
//	$('[name="nienDoDenNgay"]')[0].value="";
//	$('[name="ngayTrinh"]')[0].value="";
//	$('[name="ngayPheDuyet"]')[0].value="";
//	$('[name="ngayLap"]')[0].value="";
//}          
</script>
<logic:present name="strDateHoliday">
	<script language="javascript">
	strDateHoliday = <%=(String)request.getAttribute("strDateHoliday")%>
	</script>
</logic:present>
