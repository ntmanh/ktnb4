<%@page pageEncoding="UTF-8"  %>
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
<h3 class="Header">Biên bản làm việc</h3>
<SELECT id="cbDsTvd" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="dsTvd" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<fieldset><html:form action="bien_ban_lam_viec.do">
	<html:hidden property="id" />
	<html:hidden property="idCuocTtKt" />
	<html:hidden property="idDoanTtKt" />
	<html:hidden property="idThanhphanKhac" />
	<html:hidden property="idDsTvd" />
	<TABLE width="100%" align="center">
		<TBODY>
			<tr>
				<td align="right" width="19%">Loại biên bản <font color=red>*</font></td>
				<td width="1%"></td>
				<td colspan="4"><html:select property="loaiBB">
					<html:option value=""></html:option>
					<html:options collection="loaiBienBan" property="label" labelProperty="value" />
				</html:select></td>
			</tr>
			<tr>
				<td align="right" width="19%">Thời điểm bắt đầu <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%"><html:text property="thoiDiemBatDau" onblur="if(!isTime(this)) return;validateDateRequired(this); " onkeypress="return formatTime(event, this)" styleClass="text"></html:text></td>
				<td width="19%" align="right">Địa điểm làm việc <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text property="diaDiem" styleClass="text"></html:text></td>
			</tr>
			<tr>
				<td align="right" width="19%">Làm việc với <font color=red>*</font></td>
				<td width="1%"></td>
				<td colspan="4" align="left"><html:text property="lamViecVoi" styleClass="text" style="width: 100%"></html:text></td>
			</tr>
			<tr>
				<!-- <td align="right" width="24%">Thành phần tham dự Đoàn thanh tra, kiểm tra <font color=red>*</font></td> -->
				<td align="right" width="19%">Thành phần tham dự Đoàn kiểm tra <font color=red>*</font></td>
				<td width="1%"></td>
				<td colspan="4" align="left">
				<fieldset style="margin: 0">
				<TABLE id="daiDienDoanTtkt" width="100%">
					<tr class="TdHeaderList">
						<td width="10%" align="center">STT</td>
						<td width="40%">Ông/Bà <font color=red>*</font></td>
						<td width="40%">Chức vụ trong đoàn <font color=red>*</font></td>
						<td align="center" width="10%"><INPUT type="checkbox"></td>
					</tr>
					<logic:present name="BienBanLamViecForm" property="dsDoanTtKt">
						<logic:iterate id="ttptDoanTtkt" name="BienBanLamViecForm" property="dsDoanTtKt" indexId="index">
							<tr class='row<%=(index.intValue() % 2)+1 %>'>
								<td align="center"><%=index.intValue() + 1%></td>
								<td><html:select name="BienBanLamViecForm" property='<%="dsDoanTtKt[" + index + "].idCanBo"%>' onclick="cacheOldValue(this)" onchange="getChucVuTvd(this)" style="width:80%">
									<html:options collection="dsTvd" property="idCanBo" labelProperty="tenCanBo" />
									<html:hidden property='<%="dsDoanTtKt[" + index + "].hoTen"%>' />
								</html:select></td>
								<td><html:text styleClass="text1" readonly="readonly" name="BienBanLamViecForm" property='<%="dsDoanTtKt[" + index + "].chucVu"%>' style="border-bottom:none; width:100%">
								</html:text></td>
								<td align="center"><INPUT type="checkbox"></td>
							</tr>
						</logic:iterate>
					</logic:present>
				</TABLE>
				<DIV style="text-align: right;"><INPUT type="button" class="button" style="width: auto" onclick="themTtptDoanTtkt()" value="Thêm"> <INPUT type="button" class="button" style="width: auto" value="Xóa" id="xoaDaiDienDoanTtkt"></DIV>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td align="right" width="19%">Thành phần làm việc với Đoàn kiểm tra <font color=red>*</font></td>
				<td width="1%"></td>
				<td colspan="4" align="left">
				<fieldset style="margin: 0">
				<TABLE id="daiDienCqKhac" width="100%">
					<tr class="TdHeaderList">
						<td width="10%" align="center">STT</td>
						<td width="40%">Ông/Bà <font color=red>*</font></td>
						<td width="40%">Chức vụ <font color=red>*</font></td>
						<td align="center" width="10%"><INPUT type="checkbox"></td>
					</tr>
					<logic:present name="BienBanLamViecForm" property="dsThanhPhanKhac">
						<logic:iterate id="ttptCqqlCapTren" name="BienBanLamViecForm" property="dsThanhPhanKhac" indexId="index">
							<tr class='row<%=(index.intValue() % 2)+1 %>'>
								<td align="center"><%=index.intValue() + 1%></td>
								<td><html:hidden name="BienBanLamViecForm" property='<%="dsThanhPhanKhac[" + index + "].idCanBo"%>' /> <html:text styleClass="text" readonly="readonly" name="BienBanLamViecForm" property='<%="dsThanhPhanKhac[" + index + "].hoTen"%>' style="width: 80%">
								</html:text></td>
								<td><html:text styleClass="text" readonly="readonly" name="BienBanLamViecForm" property='<%="dsThanhPhanKhac[" + index + "].chucVu"%>' style="width: 80%">
								</html:text></td>
								<td align="center"><INPUT type="checkbox"></td>
							</tr>
						</logic:iterate>
					</logic:present>
				</TABLE>
				<DIV style="text-align: right"><INPUT type="button" class="button" style="width: auto" onclick="themTtptCqqlCapTren()" value="Thêm"> <INPUT type="button" id="xoaTtptCqqlCapTren" value="Xóa" class="button" style="width: auto"></DIV>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td align="right" width="19%">Nội dung làm việc <font color=red>*</font></td>
				<td width="1%"></td>
				<td colspan="4"><html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  property="noiDungLamViec"></html:textarea></td>
			</tr>
			<tr>
				<td align="right" width="19%">Diễn biến, kết quả <font color=red>*</font></td>
				<td width="1%"></td>
				<td colspan="4"><html:textarea styleClass="textareaContent" onkeypress="imposeMaxLength(this);"  property="ketQua"></html:textarea></td>
			</tr>
			<tr>
				<td align="right" width="19%">Thời điểm kết thúc <font color=red>*</font></td>
				<td width="1%"></td>
				<td align="left" width="30%"><html:text property="thoiDiemKetThuc" onblur="if(!isTime(this)) return;validateDateRequired(this);" onkeypress="return formatTime(event, this)" styleClass="text"></html:text></td>
				<td colspan="3" align="right"><INPUT type="button" value="In biên bản" class="button1" style="width: auto" onclick="inBienBan()"></td>
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
	arrDaiDienDoanTtkt[0] = '<SELECT name="dsDoanTtKt[' + index + '].idCanBo" onclick="cacheOldValue(this)" onchange="getChucVuTvd(this)" style="width:80%">';	
	arrDaiDienDoanTtkt[0] += document.getElementById('cbDsTvd').innerHTML;
	arrDaiDienDoanTtkt[0] += '</SELECT>';
	arrDaiDienDoanTtkt[0] += '<input type="hidden" name="dsDoanTtKt['+ index +'].hoTen" > ';
	arrDaiDienDoanTtkt[1] = '<INPUT type="text" class="text1" readonly="readonly" name="dsDoanTtKt[' + index + '].chucVu" style="border-bottom:none; width:100%"> ';
	arrDaiDienDoanTtkt[2] = '<INPUT type=checkbox>';
	return arrDaiDienDoanTtkt;
}

function createNewDaiDienCqqlCapTren(){
	arrDaiDienCqqlCapTren = new Array(); 
	index = tableDaiDienCqqlCapTren.numOfRow - 1;
	arrDaiDienCqqlCapTren[0] = '<input type="hidden" name="dsThanhPhanKhac[' + index + '].idCanBo">'
	arrDaiDienCqqlCapTren[0] += '<input type="text" name="dsThanhPhanKhac[' + index + '].hoTen" class="text" style="width:80%">'				
	arrDaiDienCqqlCapTren[1] = '<input type="text" name="dsThanhPhanKhac[' + index + '].chucVu" class="text" style="width:80%">'				
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
function getChucVuTvd_old(index){
	cbDsTvd123 = document.getElementById('cbDsTvd');
	for(var i = 0; i< cbDsTvd123.length; i++){
		if(cbDsTvd123[i].value == document.getElementsByName('dsDoanTtKt[' + index + '].idCanBo')[0].value){
			chucVuEn = cbDsTvd123[i].title;
			document.getElementsByName('dsDoanTtKt[' + index + '].chucVu')[0].value = getChucVuCoDau(chucVuEn);
			document.getElementsByName('dsDoanTtKt[' + index + '].hoTen')[0].value = cbDsTvd123[i].text;
			return;
		}
	}
	
}
function findChucVuById(idCanBo){
	for(var i = 0; i< dsIdThanhVienDoan.length; i++)
		if(dsIdThanhVienDoan[i] == idCanBo)
			return dsChucVuTrongDoan[i]; 
}

window.onload = function(){
getDsThanhVienDoan();
//thêm dòng trống trước các danh sách
if($('#daiDienDoanTtkt tbody tr').length==1){
	themTtptDoanTtkt();
}
if($('#daiDienCqKhac tbody tr').length==1){
	themTtptCqqlCapTren();
}
}

function validateForm(){
	if(!isRequired(document.getElementsByName('loaiBB')[0]))
		return false;
	if(!isRequired(document.getElementsByName('thoiDiemBatDau')[0]))
		return false;
	if(!isRequired(document.getElementsByName('diaDiem')[0]))
		return false;
	if(!isRequired(document.getElementsByName('lamViecVoi')[0]))
		return false;
	if(tableDaiDienDoanTtkt.numOfRow <=1){
		alert('Chưa nhập thành phần tham dự đoàn Thanh tra!');
		return false;			
	}
	if(tableDaiDienCqqlCapTren.numOfRow <=1){
		alert('Chưa nhập thành phần tham dự khác!');
		return false;			
	}
	if(!isRequired(document.getElementsByName('noiDungLamViec')[0]))
		return false;
	if(!isRequired(document.getElementsByName('ketQua')[0]))
		return false;
	if(!isRequired(document.getElementsByName('thoiDiemKetThuc')[0]))
		return false;
	if(!compareTime(document.getElementsByName("thoiDiemBatDau")[0], document.getElementsByName('thoiDiemKetThuc')[0], '<', 'Thời điểm bắt đầu phải nhỏ hơn thời điểm kết thúc!'))
		return false;
	return true;
}		


function inBienBan()
	{
		if(!validateForm()) return false;
		document.forms[0].action = 'to_chuc_lam_viec_thong_bap_ket_thuc.do?method=in&type=inBienBan'
		document.forms[0].submit();
		document.forms[0].action = 'to_chuc_lam_viec_thong_bap_ket_thuc.do';
	}
	function validateDateRequired(dateElement){
		if(dateElement.value!=null&&dateElement.value!=""&&dateElement.value!="null"&&dateElement.value!=" "){
			var tgRaQuyetDinh = '<%=request.getAttribute("tgRaQuyetDinh")%>';
			if(tgRaQuyetDinh!=null&&tgRaQuyetDinh!=""&&tgRaQuyetDinh!="null"&&tgRaQuyetDinh!=" "){
				if( d2n(tgRaQuyetDinh)>d2n(dateElement.value.split(" ")[1])){
					alert("Thời điểm phải sau thời gian ra quyết định ("+ tgRaQuyetDinh +")!");
					$(dateElement).focus().select();
				}
			}
		}
	}
	</script>
<%if(request.getAttribute("save") != null){%>
<script language="javascript">
		alert('Lưu thành công!');
		selfClose();
	</script>
<%}%>