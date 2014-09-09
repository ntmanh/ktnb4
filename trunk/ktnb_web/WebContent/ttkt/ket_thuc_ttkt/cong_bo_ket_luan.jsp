<%@page pageEncoding="UTF-8" %>
<%@ include file="/top_bar.jsp"%>
<%@page import="cmc.com.ktnb.util.Constants"%>
<%@page import="cmc.com.ktnb.util.ApplicationContext"%>
<script language="javascript">               
	var tenCqt = "<%=((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getTenCqt()%>";
	var maCqt = '<%=((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getMaCqt()%>';                             
</script>
<SELECT id="cbDsTvd" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="chiTietDsTvd" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<h3 class="Header">Biên bản công bố kết luận</h3>
<fieldset><html:form action="cong_bo_ket_luan.do">
	<TABLE width="100%" align="center">
		<tr>
			<td width="19%" align="right">Nơi lập biên bản <font color="red">*</font></td>
			<td width="1%"></td>
			<td width="30%"><html:text property="noiLap" styleClass="text"></html:text></td>
			<td width="19%" align="right">Ngày lập <font color="red">*</font></td>
			<td width="1%"></td>
			<td width="30%"><html:text property="ngayLap" styleClass="text" onblur="if(!isDate(this)) return;validateDateRequired(this);"  onkeypress="return formatDate(event, this)">
			</html:text></td>
		</tr>
		<tr>
			<td width="19%" align="right">Thời điểm công bố</td>
			<td style="width: 1%; min-width: 5px"><font color="red">*</font></td>
			<td width="30%"><html:text property="thoiDiemCongBo" styleClass="text" onblur="if(!isTime(this)) return;validateDateRequired(this);"  onkeypress="return formatTime(event, this)"></html:text></td>
			<td width="19%" align="right">Địa điểm <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="30%"><html:text property="diaDiem" styleClass="text"></html:text></td>
		</tr>
		<tr>
			<td align="right">Đại diện cơ quan thuế tiến hành kiểm tra</td>
			<td></td>
			<td colspan="4">
			<fieldset style="margin: 0">
			<TABLE id="daiDienCoQuanBanHanhQuyetDinh" width="100%">
				<tr class="TdHeaderList">
					<td align="center" width="10%">STT</td>
					<td width="40%">Ông/Bà <font color=red>*</font></td>
					<td width="40%">Chức vụ <font color=red>*</font></td>
					<td align="center" width="10%"><INPUT type="checkbox"></td>
				</tr>
				<logic:present name="CongBoKetLuanForm" property="arrDaiDienCqtBanHanhQD">
					<logic:iterate id="ttptCqtBanHanhQd" name="CongBoKetLuanForm" property="arrDaiDienCqtBanHanhQD" indexId="index">
						<tr class='row<%=(index.intValue() % 2)+1 %>'>
							<td align="center"><%=index.intValue() + 1%></td>
							<td><html:hidden name="CongBoKetLuanForm" property='<%="arrDaiDienCqtBanHanhQD[" + index + "].idCanBo"%>' /> <html:text styleClass="text" readonly="readonly" name="CongBoKetLuanForm" property='<%="arrDaiDienCqtBanHanhQD[" + index + "].hoTen"%>' style="width:75%">
							</html:text> <Input type="button" value="..." onclick="chonNhanVienCqtBanHanh(<%=index%>)" class="lovButton"></td>
							<td><html:text styleClass="text1" name="CongBoKetLuanForm" property='<%="arrDaiDienCqtBanHanhQD[" + index + "].chucVu"%>' style="border-bottom:none; width:100%" readonly="true">
							</html:text></td>
							<td align="center"><INPUT type="checkbox"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</TABLE>
			<DIV style="text-align: right"><INPUT type="button" class="button" style="width: auto" onclick="themTtptCqtBanHanhQd()" value="Thêm"> <INPUT type="button" id="xoaTtptCqtBanHanhQd" value="Xóa" class="button"></DIV>
			</fieldset>
			</td>
		</tr>
		<tr align="right">
			<td>Đại diện cơ quan tổ chức có liên quan</td>
			<td></td>
			<td colspan="4">
			<fieldset style="margin: 0">
			<TABLE id="daiDienCqqlCapTren" width="100%">
				<tr class="TdHeaderList">
					<td width="10%" align="center">STT</td>
					<td width="40%">Ông/Bà <font color=red>*</font></td>
					<td width="40%">Chức vụ <font color=red>*</font></td>
					<td align="center" width="10%"><INPUT type="checkbox"></td>
				</tr>
				<logic:present name="CongBoKetLuanForm" property="arrDaiDienCqqlCapTren">
					<logic:iterate id="ttptCqqlCapTren" name="CongBoKetLuanForm" property="arrDaiDienCqqlCapTren" indexId="index">
						<tr class='row<%=(index.intValue() % 2)+1 %>'>
							<td align="center"><%=index.intValue() + 1%></td>
							<td><html:hidden name="CongBoKetLuanForm" property='<%="arrDaiDienCqqlCapTren[" + index + "].idCanBo"%>' /> <html:text styleClass="text" readonly="readonly" name="CongBoKetLuanForm" property='<%="arrDaiDienCqqlCapTren[" + index + "].hoTen"%>' style="width: 85%">
							</html:text></td>
							<td><html:text styleClass="text" readonly="readonly" name="CongBoKetLuanForm" property='<%="arrDaiDienCqqlCapTren[" + index + "].chucVu"%>' style="width: 85%">
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
			<td align="right">Đại diện đoàn thanh tra, kiểm tra <font color=red>*</font></td>
			<td></td>
			<td colspan="4">
			<fieldset style="margin: 0">
			<TABLE id="daiDienDoanTtkt" width="100%">
				<tr class="TdHeaderList">
					<td width="10%" align="center">STT</td>
					<td width="40%">Ông/Bà <font color=red>*</font></td>
					<td width="40%">Chức vụ trong đoàn <font color=red>*</font></td>
					<td align="center" width="10%"><INPUT type="checkbox"></td>
				</tr>
				<logic:present name="CongBoKetLuanForm" property="arrDaiDienDoanTtkt">
					<logic:iterate id="ttptDoanTtkt" name="CongBoKetLuanForm" property="arrDaiDienDoanTtkt" indexId="index">
						<tr class='row<%=(index.intValue() % 2)+1 %>'>
							<td align="center"><%=index.intValue() + 1%></td>
							<td><html:select name="CongBoKetLuanForm" property='<%="arrDaiDienDoanTtkt[" + index + "].idCanBo"%>' onchange="getChucVuTvd(this)" onclick="cacheOldValue(this)" style="width: 85%">
								<html:options collection="chiTietDsTvd" property="idCanBo" labelProperty="tenCanBo" />
							</html:select> <html:hidden property='<%="arrDaiDienDoanTtkt[" + index + "].hoTen"%>' /></td>
							<td><html:text styleClass="text1" readonly="true" name="CongBoKetLuanForm" property='<%="arrDaiDienDoanTtkt[" + index + "].chucVu"%>' style="border-bottom:none; width:100%">
							</html:text></td>
							<td align="center"><INPUT type="checkbox"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</TABLE>
			<DIV style="text-align: right"><INPUT type="button" class="button" style="width: auto" onclick="themTtptDoanTtkt()" value="Thêm"> <INPUT type="button" class="button" style="width: auto" value="Xóa" id="xoaDaiDienDoanTtkt"></DIV>
			</fieldset>
			</td>
		</tr>
		<tr align="right">
			<td>Đại diện đơn vị được thanh tra, kiểm tra <font color=red>*</font></td>
			<td></td>
			<td colspan="4">
			<fieldset style="margin: 0"><!--dai dien co quan thue duoc thanh tra kiem tra -->
			<TABLE id="daiDienDonViDuocTtkt" width="100%">
				<tr class="TdHeaderList">
					<td align="center" width="10%">STT</td>
					<td width="40%">Ông/Bà <font color=red>*</font></td>
					<td width="40%">Chức vụ <font color=red>*</font></td>
					<td align="center" width="10%"><INPUT type="checkbox"></td>
				</tr>
				<logic:present name="CongBoKetLuanForm" property="arrDaiDienDonViDuocTtkt">
					<logic:iterate id="ttptDonViDuocTtkt" name="CongBoKetLuanForm" property="arrDaiDienDonViDuocTtkt" indexId="index">
						<tr class='row<%=(index.intValue() % 2)+1 %>'>
							<td align="center"><%=index.intValue() + 1%></td>
							<td><html:hidden name="CongBoKetLuanForm" property='<%="arrDaiDienDonViDuocTtkt[" + index + "].idCanBo"%>' /> <html:text styleClass="text" readonly="readonly" name="CongBoKetLuanForm" property='<%="arrDaiDienDonViDuocTtkt[" + index + "].hoTen"%>' style="width: 75%">
							</html:text> <Input type="button" class="lovButton" value="..." onclick="chonNhanVienCqtBi(<%=index%>)"></td>
							<td><html:text styleClass="text1" name="CongBoKetLuanForm" property='<%="arrDaiDienDonViDuocTtkt[" + index + "].chucVu"%>' style="border-bottom:none; width:100%" readonly="true">
							</html:text></td>
							<td align="center"><INPUT type="checkbox"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</TABLE>
			<DIV style="text-align: right"><INPUT type="button" class="button" style="width: auto" onclick="themTtptDonViDuocTtkt()" value="Thêm"> <INPUT class="button" style="width: auto" type="button" value="Xóa" id="xoaDaiDienDonViDuocTtkt"></DIV>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td align="right">Ý kiến của đại diện cơ quan tiến hành thanh tra</td>
			<td></td>
			<td colspan="4"><html:textarea onkeypress="imposeMaxLength(this);"  style="width: 100%" property="ykienPhatBieu">
			</html:textarea></td>
		</tr>
		<tr>
			<td align="right">Ý kiến đại diện cơ quan quản lý cấp trên trực tiếp của đối tượng</td>
			<td></td>
			<td colspan="4"><html:textarea onkeypress="imposeMaxLength(this);"  style="width: 100%" property="ykCqqlCapTrenCuaDtuong">
			</html:textarea></td>
		</tr>
		<tr>
			<td align="right">Ý kiến của đại diện cơ quan được thanh tra kiểm tra</td>
			<td></td>
			<td colspan="4"><html:textarea onkeypress="imposeMaxLength(this);"  style="width: 100%" property="ykDaiDienCqtBiTtkt">
			</html:textarea></td>
		</tr>
		<tr>
			<td width="19%" align="right">Thời điểm kết thúc <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left"><html:text property="thoiDiemKetThuc" styleClass="text" onblur="if(!isTime(this)) return;validateDateRequired(this);" onkeypress="return formatTime(event, this)">
			</html:text></td>
			<td colspan="2"></td>
			<td><INPUT type="button" onclick="inBienBan()" class="button1" style="width: auto" value="In biên bản công bố"></td>
		</tr>
	</TABLE>
	<html:hidden property="idDonViDuocTtkt" />
	<html:hidden property="idDonViTienHanh" />
	<html:hidden property="idCongBoQuyetDinh" />
	<html:hidden property="idCuocTtkt" />
	<html:hidden property="idDaiDienCqqlCapTren" />
	<html:hidden property="idDaiDienDoanTtkt" />
	<html:hidden property="idDaiDienDonViDuocTtkt" />
	<html:hidden property="idDaiDienCqBanHanhQd" />
</html:form></fieldset>
<fieldset><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></fieldset>
<%@ include file="/bottom.jsp"%>
<script language="javascript">

function inBienBanCongBo(){
	window.open('report.do?rp=ttnb16'); 
}


function validateTable1(){
	if(tableDaiDienCoQuanBanHanhQuyetDinh.numOfRow > 1){
		for(i = 1; i< tableDaiDienCoQuanBanHanhQuyetDinh.numOfRow; i++){
			if(!isRequired(document.getElementsByName('arrDaiDienCqtBanHanhQD['+ eval(i-1) +'].hoTen')[0]))
				return false;
		}
	}		
	return true;
}
function validateTable2(){
	if(tableDaiDienDoanTtkt.numOfRow == 1){
		alert('Bạn cần nhập Đại diện đoàn thanh tra, kiểm tra');
		return false;
	}
	for(i = 1; i< tableDaiDienDoanTtkt.numOfRow; i++){
		if(!isRequired(document.getElementsByName('arrDaiDienDoanTtkt['+ eval(i-1) +'].idCanBo')[0]))
			return false;
	}	
	return true;
}
function validateTable3(){

	if(tableDaiDienDonViDuocTtkt.numOfRow == 1){
		alert('Bạn cần nhập Đại diện đơn vị được thanh tra, kiểm tra');
		return false;
	}
	for(i = 1; i< tableDaiDienDonViDuocTtkt.numOfRow; i++){
		if(!isRequired(document.getElementsByName('arrDaiDienDonViDuocTtkt['+ eval(i-1) +'].hoTen')[0]))
			return false;
	}	
	return true;
}
function validateTable4(){
	if(tableDaiDienCqqlCapTren.numOfRow > 1){
		for(i = 1; i< tableDaiDienCqqlCapTren.numOfRow; i++){
			if(!isRequired(document.getElementsByName('arrDaiDienCqqlCapTren['+ eval(i-1) +'].hoTen')[0]))
				return false;
		}
		for(i = 1; i< tableDaiDienCqqlCapTren.numOfRow; i++){
			if(!isRequired(document.getElementsByName('arrDaiDienCqqlCapTren['+ eval(i-1) +'].chucVu')[0]))
				return false;
		}
	}
		
	return true;

}
function validateCongBoQuyetDinh(){
	if(!isRequired(document.getElementsByName('noiLap')[0]))
		return false;
	if(!isRequired(document.getElementsByName('ngayLap')[0]))
		return false;
	if(!isRequired(document.getElementsByName('thoiDiemCongBo')[0]))
		return false;
	if(!isRequired(document.getElementsByName('diaDiem')[0]))
		return false;
	if(!validateTable1())
		return false;
	if(!validateTable2())
		return false;
	if(!validateTable3())
		return false;
	if(!validateTable4())
		return false;			
	if(!isRequired(document.getElementsByName('thoiDiemKetThuc')[0]))
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
	arrDaiDienCqBanHanhQD[0] += '<input type="text" name="arrDaiDienCqtBanHanhQD[' + index + '].hoTen" class="text" onchange = "chonNhanVienCqtBanHanh(' + index + ')" style="width:75%">'				
	arrDaiDienCqBanHanhQD[0] += '<Input type="button" value="..." onclick="chonNhanVienCqtBanHanh(' + index + ')" class = "lovButton">'
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
function createNewDaiDienDoanTtkt(){
	arrDaiDienDoanTtkt = new Array();
	index = tableDaiDienDoanTtkt.numOfRow - 1;
	arrDaiDienDoanTtkt[0] = '<SELECT name="arrDaiDienDoanTtkt[' + index + '].idCanBo" onchange="getChucVuTvd(this)" onclick="cacheOldValue(this)" style="width:85%">';	
	arrDaiDienDoanTtkt[0] += cbDsThanhVienDoan;
	arrDaiDienDoanTtkt[0] += '</SELECT>';
	arrDaiDienDoanTtkt[0] += '<input type="hidden" name="arrDaiDienDoanTtkt['+ index +'].hoTen" >';
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
	arrDaiDienDonViDuocTtkt[0] = '<input type="hidden" name="arrDaiDienDonViDuocTtkt[' + index + '].idCanBo">'
	arrDaiDienDonViDuocTtkt[0] += '<input type="text" name="arrDaiDienDonViDuocTtkt[' + index + '].hoTen" class="text" onchange = "chonNhanVienCqtBi(' + index + ')" style="width:75%">'				
	arrDaiDienDonViDuocTtkt[0] += '<Input type="button" class = "lovButton" value="..." onclick="chonNhanVienCqtBi('+ index +')">'
	arrDaiDienDonViDuocTtkt[1] = '<input type="text" name="arrDaiDienDonViDuocTtkt[' + index + '].chucVu" class="text1" style="border-bottom:none; width:100%" readonly="true">'				
	arrDaiDienDonViDuocTtkt[2] = '<input type="checkBox">'				
	return arrDaiDienDonViDuocTtkt;
}
function validateForm(){
	if(!validateCongBoQuyetDinh())
	return false;
	
	return true;
}		

var maCqtTh = '<%=request.getAttribute("maCqtTh")%>';
var maCqtDuocTtkt = '<%=request.getAttribute("maCqtDuocTtkt")%>';
var type;
function chonNhanVienCqtBi(index){
	
	// id, ten
	hiddenIdCanBo = document.getElementsByName('arrDaiDienDonViDuocTtkt['+ index + '].idCanBo')[0];
	txtTenCanBo = document.getElementsByName('arrDaiDienDonViDuocTtkt['+ index + '].hoTen')[0];
	
	// Chuc vu
	chucVuCongTacCol = document.getElementsByName('arrDaiDienDonViDuocTtkt['+ index + '].chucVu')[0];
	txtChucVu = document.getElementsByName('arrDaiDienDonViDuocTtkt['+ index + '].chucVu')[0];
	type = 'dvDuocKt';
	showLovNhanVien(maCqtDuocTtkt, txtTenCanBo);
	
} 

function chonNhanVienCqtBanHanh(index){
	// id, ten
	hiddenIdCanBo = document.getElementsByName('arrDaiDienCqtBanHanhQD['+ index + '].idCanBo')[0];
	txtTenCanBo = document.getElementsByName('arrDaiDienCqtBanHanhQD['+ index + '].hoTen')[0];
	
	// Chuc vu
	chucVuCongTacCol = document.getElementsByName('arrDaiDienCqtBanHanhQD['+ index + '].chucVu')[0];
	txtChucVu = document.getElementsByName('arrDaiDienCqtBanHanhQD['+ index + '].chucVu')[0];
	type = 'cqtBh';
	showLovNhanVien(maCqtTh, txtTenCanBo);
	
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

var cbDsThanhVienDoan;  
var dsIdThanhVienDoan; 
var dsChucVuTrongDoan; 
function getDsThanhVienDoan(){
	cbDsThanhVienDoan = '<%=request.getAttribute("cbChiTietDsTvd")%>'
	dsIdThanhVienDoan = '<%=request.getAttribute("dsIdThanhVienDoan")%>'
	dsChucVuTrongDoan = '<%=request.getAttribute("dsChucVuTrongDoan")%>'
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

function getChucVuTvd_old(cbThanhVienDoan){
		var chucVuConTrol = document.getElementsByName(cbThanhVienDoan.name.replace('.idCanBo', '.chucVu'))[0];
		var tenHiddenTag = 	document.getElementsByName(cbThanhVienDoan.name.replace('.idCanBo', '.hoTen'))[0];
		var chucVu = getChucVuById(cbThanhVienDoan.value);
		if(cbThanhVienDoan[cbThanhVienDoan.selectedIndex].text == ""){
			chucVuConTrol.value = '';
			return;
		} 
		tenHiddenTag.value =  cbThanhVienDoan.options[cbThanhVienDoan.selectedIndex].text;
		
		switch (chucVu){
		case 'Truong doan':
			chucVuConTrol.value = 'Trưởng đoàn';
			break;
		case 'Pho doan'	:	
			chucVuConTrol.value = 'Phó đoàn';
			break;
		default:
			chucVuConTrol.value = 'Thành viên đoàn';
		}
		
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


window.onload = function(){
getDsThanhVienDoan();
//thêm dòng trống trước các danh sách
if($('#daiDienCoQuanBanHanhQuyetDinh tbody tr').length==1){
	themTtptCqtBanHanhQd();
}
if($('#daiDienCqqlCapTren tbody tr').length==1){
	themTtptCqqlCapTren();
}
if($('#daiDienDoanTtkt tbody tr').length==1){
	themTtptDoanTtkt();
}
if($('#daiDienDonViDuocTtkt tbody tr').length==1){
	themTtptDonViDuocTtkt();
}
}

function selfClose(){
		window.close();
	}
function inBienBan()
	{
		if(!validateForm()) return false;
		document.forms[0].action = 'cong_bo_ket_luan.do?method=in';
		document.forms[0].submit();
		document.forms[0].action = 'cong_bo_ket_luan.do';
	}
function GetURLParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
    }
}
function validateDateRequired(dateElement){
	var ngayRaKetLuan = GetURLParameter("ngayRaKetLuan");
	var ngayRaKetLuanSv = '<%=request.getAttribute("ngayRaKetLuanSv")%>';
	if(dateElement.value!=null&&dateElement.value!=""){
		switch(dateElement.name){
		case "ngayLap":
			if((ngayRaKetLuan==""||ngayRaKetLuan=='null')&&(ngayRaKetLuanSv==""||ngayRaKetLuanSv=='null'))
			{
				alert("chưa có ngày ra kết luận");
				$(dateElement).focus().select();
			}else{
				var selectDate= (ngayRaKetLuan==""||ngayRaKetLuan==null)?ngayRaKetLuanSv:ngayRaKetLuan;
				if(d2n(selectDate)>d2n(dateElement.value)){
					alert("Thời điểm phải sau khi ra kết luận (" + selectDate + ")!");
					$(dateElement).focus().select();
				}
			}
		break;
		default :
			if((ngayRaKetLuan==""||ngayRaKetLuan=='null')&&(ngayRaKetLuanSv==""||ngayRaKetLuanSv=='null'))
			{
				alert("chưa có ngày ra kết luận");
				$(dateElement).focus().select();
			}else{
				var selectDate= (ngayRaKetLuan==""||ngayRaKetLuan==null)?ngayRaKetLuanSv:ngayRaKetLuan;
				if(d2n(selectDate)>d2n(dateElement.value.split(" ")[1])){
					alert("Thời điểm phải sau khi ra kết luận (" + selectDate + ")!");
					$(dateElement).focus().select();
				}
			}
		break;
		}
	}
}
//window.onbeforeunload = function(){
//$('[name="ngayLap"]')[0].value="";
//$('[name="thoiDiemCongBo"]')[0].value="";
//$('[name="thoiDiemKetThuc"]')[0].value="";
//}
</script>
<%
if (request.getAttribute("save") != null) {
%>
<script language="javascript">
		alert('Lưu thành công!');
		window.opener.location.reload();
		selfClose();
	</script>
<%
}
%>
