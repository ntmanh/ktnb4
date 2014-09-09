<%@page pageEncoding="UTF-8" %>
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
<h3 class="Header">Chuyển giao hồ sơ vụ việc sang cơ quan điều tra</h3>
<fieldset style="margin: 0"><html:form action="ban_giao_ho_so_vu_viec.do">
	<html:hidden property="id" />
	<html:hidden property="idCuocTtKt" />
	<html:hidden property="idDsDaiDien" />
	<html:hidden property="idDsDaiDienCqDt" />
	<table align="center" style="width: 100%">
		<tr>
			<td>
			<fieldset style="padding: 15px"><legend>Văn bản chuyển giao hồ sơ tài liệu cho cơ quan điều tra</legend>
			<TABLE width="100%" align="center">
				<TBODY>
					<tr>
						<td width="19%" align="right">Địa điểm lập hồ sơ</td>
						<td width="1%"><font color=red>*</font></td>
						<td width="30%" align="left"><html:text styleClass="text" property="diaDiemNopHs"></html:text></td>
						<td width="19%" align="right">Thời gian</td>
						<td width="1%"><font color=red>*</font></td>
						<td width="30%" align="left"><html:text styleClass="text" property="thoiGian" onkeypress="return formatTime(event, this)" onblur="isTime(this)"></html:text></td>
					</tr>
					<tr>
						<td width="19%" align="right">Số công văn</td>
						<td width="1%"></td>
						<td width="30%"><html:text styleClass="text" property="soHs" style="width: 50%"></html:text></td>
						<td width="19%" align="right">Tên cơ quan điều tra</td>
						<td width="1%"><font color=red>*</font></td>
						<td width="30%" align="left"><html:text styleClass="text" property="tenCqDieuTra"></html:text></td>
					</tr>
					<tr>
						<td width="19%" align="right">Tóm tắt hành vi vi phạm</td>
						<td width="1%"><font color=red>*</font></td>
						<td colspan="4" align="left"><html:textarea property="tomTatHvVp" onkeypress="imposeMaxLength(this);"  styleClass="textareaContent"></html:textarea></td>
					</tr>
					<tr>
						<td width="19%" align="right">Hành vi vi phạm có dấu hiệu phạm tội</td>
						<td width="1%"><font color=red>*</font></td>
						<td colspan="4" align="left"><html:textarea property="hanhViVp" onkeypress="imposeMaxLength(this);"  styleClass="textareaContent"></html:textarea></td>
					</tr>
					<tr>
						<td width="19%" align="right">Chức danh người ký</td>
						<td width="1%"><font color=red>*</font></td>
						<td colspan="4" align="left"><html:text styleClass="text" property="chucDanhNguoiKy"></html:text></td>
					</tr>
					<tr>
						<td colspan="6" align="right"><INPUT type="button" value="In văn bản" class="button1" style="width: auto" onclick="inVanBan()"></td>
					</tr>
				</TBODY>
			</TABLE>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td>
			<fieldset style="padding: 15px"><legend>Biên bản giao nhận</legend>
			<div>
			  <TABLE width="100%">
				<TBODY>
					<tr>
						<td width="19%" align="right">Thời gian giao nhận</td>
						<td width="1%"><font color=red>*</font></td>
						<td width="30%" align="left"><html:text styleClass="text" property="tgGiaoNhan" onkeypress="return formatTime(event, this)" onblur="isTime(this)"></html:text></td>
						<td width="19%" align="right">Địa điểm</td>
						<td width="1%"><font color=red>*</font></td>
						<td width="30%" align="left"><html:text styleClass="text" property="diaDiemGiaoNhan"></html:text></td>
					</tr>
					<tr>
						<td width="19%" align="right">Đại diện bên giao</td>
						<td width="1%"></td>
						<td colspan="4">
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
								<logic:present name="BanGiaoHsVvForm" property="dsDaiDien">
									<logic:iterate id="nhanVien" name="BanGiaoHsVvForm" property="dsDaiDien" indexId="index">
										<tr class='row<%=(index.intValue() % 2)+1 %>'>
											<td align="center"><%=index.intValue() + 1%></td>
											<td><html:text styleClass="text" name="BanGiaoHsVvForm" property='<%="dsDaiDien["+index+"].hoTen"%>' style="width: 85%"></html:text></td>
											<td><html:text styleClass="text" name="BanGiaoHsVvForm" property='<%="dsDaiDien["+index+"].chucVu"%>' style="width: 85%">
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
						<td width="19%" align="right">Đại diện cơ quan điều tra</td>
						<td width="1%"></td>
						<td colspan="4">
						<fieldset style="margin: 0"><legend>Đại diện cơ quan điều tra</legend>
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
								<logic:present name="BanGiaoHsVvForm" property="dsDaiDienCqDt">
									<logic:iterate id="nhanVien" name="BanGiaoHsVvForm" property="dsDaiDienCqDt" indexId="index">
										<tr class='row<%=(index.intValue() % 2)+1 %>'>
											<td align="center"><%=index.intValue() + 1%></td>
											<td><html:text styleClass="text" name="BanGiaoHsVvForm" property='<%="dsDaiDienCqDt[" + index + "].hoTen"%>' style="width:85%" /></td>
											<td><html:text styleClass="text" name="BanGiaoHsVvForm" property='<%="dsDaiDienCqDt[" + index + "].chucVu"%>' style="width:85%" /></td>
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
						<td width="19%" align="right">Hồ sơ gồm có</td>
						<td width="1%"><font color=red>*</font></td>
						<td colspan="4" align="left"><html:textarea property="baoGomCacTl" styleClass="textareaContent"></html:textarea></td>
					</tr>
					<tr>
						<td width="19%" align="right">Tổng số</td>
						<td width="1%"></td>
						<td colspan="4" align="left"><html:text styleClass="text" property="soTrang" style="width: 10%" onkeypress="return formatInt(event);" onblur="isNumber(this,'i')"></html:text> trang</td>
					</tr>
					<tr>
						<td width="19%" align="right">Thời gian kết thúc</td>
						<td width="1%"><font color=red>*</font></td>
						<td colspan="4" width="25%"><html:text styleClass="text" property="thoiDiemKt" onkeypress="return formatTime(event, this)" onblur="isTime(this)"></html:text></td>
					</tr>
					<tr>
						<td colspan="6" align="right"><INPUT type="button" class="button1" onclick="inBienBan()" style="width: auto" value="In biên bản"></td>
					</tr>
				</TBODY>
			</TABLE>
			</div></fieldset>
			</td>
		</tr>
	</table>
</html:form>
</fieldset>
<br />
<fieldset style="margin: 0"><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></fieldset>
<%@ include file="/bottom.jsp"%>
<script language="javascript">

var cbDsThanhVienDoan;  
var dsIdThanhVienDoan; 
var dsChucVuTrongDoan; 

window.onload = function(){
	getDsThanhVienDoan();
	//onLoadYeuCau();   
	//thêm dòng trống trước các danh sách
	if($('#bbNP1 tbody tr').length==0){
		AddRowBBNP1();
	}
	if($('#bbNP2 tbody tr').length==0){
		AddRowBBNP2();
	}
}
function getDsThanhVienDoan(){    
	cbDsThanhVienDoan = '<%=request.getAttribute("cbChiTietDsTvd")%>'
	dsIdThanhVienDoan = '<%=request.getAttribute("dsIdThanhVienDoan")%>'
	dsIdThanhVienDoan = dsIdThanhVienDoan.split(',');
	dsChucVuTrongDoan = '<%=request.getAttribute("dsChucVuTrongDoan")%>'
	dsChucVuTrongDoan = dsChucVuTrongDoan.split(',');
	
}

var dsDaiDien = new TableObject('bbNP1', true, 'delrowBBNP1');
var dsDaiDienCqDt = new TableObject('bbNP2', true,'delrowBBNP2'); 
	function AddRowBBNP1() {
	dsDaiDien.addRow(createNewTptdTVD1());	 	
}
 function AddRowBBNP2() {
	dsDaiDienCqDt.addRow(createNewTptdTVD2());	 	
}
function createNewTptdTVD1(){
	arReturnRow = new Array();
	index = dsDaiDien.numOfRow - 1;
	arReturnRow[0] = '<input type="text" class = "text"  name="dsDaiDien['+ index +'].hoTen" style="width:85%"> ';
	arReturnRow[1] = '<input type = "text" class = "text" name = "dsDaiDien['+ index +'].chucVu" style="width:85%">';
	arReturnRow[2] = '<INPUT type="checkbox">';
	return arReturnRow;
}

function createNewTptdTVD2(){
	index = dsDaiDienCqDt.numOfRow - 1;
	arReturnRow = new Array();
	arReturnRow[0] = '<INPUT type="text" class = "text" name = "dsDaiDienCqDt['+ index +'].hoTen" style="width:85%">'
	arReturnRow[1] = '<input type = "text" class = "text" name = "dsDaiDienCqDt['+ index +'].chucVu" style="width:85%">';
	arReturnRow[2] = '<INPUT type=checkbox>';
	return arReturnRow;
}
function deleteThanhVienDoan(){
	dsDaiDien.deleteSelectedRow();
}

function chonTat(){
	dsDaiDien.selectAllRow();
}
function chonTat(){
	dsDaiDienCqDt.selectAllRow();
}


function selfClose(){
		window.close();
	}
	
function validateTable1(){
	for(i = 1; i< dsDaiDien.numOfRow; i++){
		if(!isRequired(document.getElementsByName('dsDaiDien['+ eval(i-1) +'].hoTen')[0]))
			return false;
			if(!isRequired(document.getElementsByName('dsDaiDien['+ eval(i-1) +'].chucVu')[0]))
			return false;
	}
		
	return true;
}
function validateTable2(){
	if(dsDaiDienCqDt.numOfRow == 1){
		alert('Bạn cần nhập Đại diện cơ quan điều tra');
		return false;
	}
	for(i = 1; i< dsDaiDienCqDt.numOfRow; i++){
		if(!isRequired(document.getElementsByName('dsDaiDienCqDt['+ eval(i-1) +'].hoTen')[0]))
		return false;
		if(!isRequired(document.getElementsByName('dsDaiDienCqDt['+ eval(i-1) +'].chucVu')[0]))
		return false;
	}
		
	return true;
}
function validateVanBan(){
	if(!isRequired(document.getElementsByName('diaDiemNopHs')[0]))
		return false;
	if(!isRequired(document.getElementsByName('thoiGian')[0]))
		return false;
	if(!isRequired(document.getElementsByName('tenCqDieuTra')[0]))
		return false;
	if(!isRequired(document.getElementsByName('tomTatHvVp')[0]))
		return false;
	if(!isRequired(document.getElementsByName('chucDanhNguoiKy')[0]))
		return false;
	return true;
}

function validateBienBan(){
	if(!isRequired(document.getElementsByName('tgGiaoNhan')[0]))
		return false;
	if(!isRequired(document.getElementsByName('diaDiemGiaoNhan')[0]))
		return false;
	if(!validateTable1())
		return false;
	if(!validateTable2())
		return false;
	if(!isRequired(document.getElementsByName('soTrang')[0]))
		return false;
	if(!isRequired(document.getElementsByName('thoiDiemKt')[0]))
		return false;
	return true;

}
function validateForm(){
	if(!validateVanBan()) return false;
	if(!validateBienBan()) return false;
		
return true;

}

function inVanBan()
{
	if(!validateVanBan()) return false;
	document.forms[0].action = 'ban_giao_ho_so_vu_viec.do?method=in&type=bbChuyenGiao';
	document.forms[0].submit();
	document.forms[0].action = 'ban_giao_ho_so_vu_viec.do';
}
function inBienBan()
{
	if(!validateBienBan()) return false;
	document.forms[0].action = 'ban_giao_ho_so_vu_viec.do?method=in&type=bbGiaoNhan';
	document.forms[0].submit();
	document.forms[0].action = 'ban_giao_ho_so_vu_viec.do';
}
function selfClose(){
		window.close();
	}
</script>
<%
if (request.getAttribute("save") != null) {
%>
<script language="javascript">
		alert('Lưu thành công');
		window.location ='danh_sach_tim_kiem.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value +'&type=bgHsVv';
	</script>
<%
}
%>
