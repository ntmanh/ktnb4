<%@page pageEncoding="UTF-8"%>
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
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>"
			title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write
			name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<h3 class="Header">Kiểm tra, xác minh</h3>
<html:form action="kiem_tra_xac_minh.do">
	<html:hidden property="optionTag" />
	<html:hidden property="idTpTdDoanTtKt" />
	<html:hidden property="idTpTdDuocKtXm" />
	<html:hidden property="idCuocTtKt" />
	<html:hidden property="idKtXm" />
	<fieldset>
	<TABLE width="100%" align="center">
		<TBODY>
			<tr>
				<td width="19%" align="right">Sự việc kiểm tra xác minh <font
					color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%"><html:text styleClass="text"
					property="skDuocKtXm"></html:text></td>
				<td width="19%" align="right">Thời gian lập biên bản <font
					color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text property="thoiGian"
					styleClass="text"
					onblur="if(!isTime(this)) return;validateDateRequired(this); "			
					onkeypress="return formatTime(event, this)"></html:text></td>
			</tr>
			<tr>
				<td width="19%" align="right">Địa điểm <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%"><html:text property="diaDiem" styleClass="text"></html:text></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td width="19%" align="right">Đơn vị kiểm tra <font color=red>*</font></td>
				<td width="1%"></td>
				<td colspan="4" align="left">
				<fieldset style="margin: 0">
				<table width="100%" id="table1">
					<thead>   
						<tr class=TdHeaderList>
							<th width="10%" align="center">STT</th>
							<th width="40%" align="left">Họ tên</th>
							<th width="40%" align="left">Chức vụ</th>
							<th width="10%" align="center"><input type="checkbox"
								onclick="chonTat()"></th>
						</tr>
					</thead>
					<tbody>
						<logic:present name="KiemTraXacMinhForm" property="dsTpTdDoanTtKt">
							<logic:iterate name="KiemTraXacMinhForm" id="dsTpTdDoanTtKt"
								property="dsTpTdDoanTtKt" indexId="index">
								<tr class='row<%=(index.intValue() % 2) + 1%>'>
									<td align="center"><%=index.intValue() + 1%></td>
									<td><html:select name="KiemTraXacMinhForm"
										styleClass="combobox"
										styleId='<%="dsTpTdDoanTtKt[" + index + "].hoTen"%>'
										property='<%="dsTpTdDoanTtKt[" + index + "].idCanBo"%>'
										onclick="cacheOldValue(this)"
										onchange="setChucVuByIdCabBo(this)" style="width: 85%">
										<html:option value="" />
										<html:options collection="dsTvd" property="idCanBo"
											labelProperty="tenCanBo" />
									</html:select> <html:hidden
										property='<%="dsTpTdDoanTtKt[" + index + "].hoTen"%>'
										styleId='<%="dsTpTdDoanTtKt[" + index + "].Ten"%>' /></td>
									<td><html:text name="KiemTraXacMinhForm"
										property='<%="dsTpTdDoanTtKt[" + index + "].chucVu"%>'
										styleClass="text1" readonly="true"
										style="border-bottom:none; width:100%">
									</html:text></td>
									<td align="center"><INPUT type="checkbox"></td>
								</tr>
							</logic:iterate>
						</logic:present>
					</tbody>
				</table>
				<div style="text-align: right; width: 100%"><INPUT
					type="button" class="button" onclick="AddRowTable1()" value="Thêm">
				<INPUT type="button" class="button" name="btnXoa" value="Xóa"
					id="delrowtable1"></div>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td align="right" width="19%">Đơn vị xác minh <font color=red>*</font></td>
				<td width="1%"></td>
				<td align="left" colspan="4" width="100%">
				<fieldset style="margin: 0">
				<table width="100%" id="table2">
					<thead>
						<tr class=TdHeaderList>
							<th width="10%" align="center">STT</th>
							<th width="40%" align="left">Họ tên <font color=red>*</font></th>
							<th width="40%" align="left">Chức vụ <font color=red>*</font></th>
							<th width="10%" align="center"><input type="checkbox"
								onclick="chonTat2()"></th>
						</tr>
					</thead>
					<tbody>
						<logic:present name="KiemTraXacMinhForm" property="dsTpTdDuocKtXm">
							<logic:iterate name="KiemTraXacMinhForm" id="dsTpTdDuocKtXm"
								property="dsTpTdDuocKtXm" indexId="index">
								<tr class='row<%=(index.intValue() % 2) + 1%>'>
									<td align="center"><%=index.intValue() + 1%></td>
									<td><html:text
										property='<%="dsTpTdDuocKtXm[" + index + "].hoTen"%>'
										styleClass="text" style="width: 85%" /></td>
									<td><html:text name="KiemTraXacMinhForm"
										property='<%="dsTpTdDuocKtXm[" + index + "].chucVu"%>'
										styleClass="text" style="width: 85%">
									</html:text></td>
									<td align="center"><INPUT type="checkbox"></td>
								</tr>
							</logic:iterate>
						</logic:present>
					</tbody>
				</table>
				<div style="text-align: right; width: 100%"><INPUT
					type="button" class="button" onclick="AddRowTable2()" value="Thêm">
				<INPUT type="button" class="button" name="btnXoa" value="Xóa"
					id="delrowtable2"></div>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td width="19%" align="right">Nội dung <font color=red>*</font></td>
				<td width="1%"></td>
				<td colspan="4" width="30%"><html:textarea property="noiDung"
					onkeypress="imposeMaxLength(this);" styleClass="textareaContent" /></td>
			</tr>
			<tr>
				<td colspan="6" align="right"><INPUT type="button"
					class="button1" value="In biên bản" onclick="print()"></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
</html:form>
<fieldset style="margin: 0"><%@ include
	file="/ttkt/dung_chung/action_bar.jsp"%></fieldset>
<%@ include file="/bottom.jsp"%>
<script language="javascript">
	var dsTVDoanTtkt = new TableObject('table1', true, 'delrowtable1');
	var dsTVDoanDuocKtXm = new TableObject('table2', true,'delrowtable2');
	var	dsIdThanhVienDoan
	var	dsChucThanhVienDoan
function validateDateRequired(dateElement){
	var ngayRaQuyetDnh = '<%=request.getAttribute("ngayRaQuyetDnh")%>';
	if(ngayRaQuyetDnh!=null&&ngayRaQuyetDnh!=""){
		if(dateElement.value!=""){
			if(d2n(ngayRaQuyetDnh)>=d2n(dateElement.value.split(" ")[1])){
				alert("Ngày lập biên bản phải sau ngày ra quyết định ("+ngayRaQuyetDnh+")!");
				dateElement.focus();			
			}
		}
	}
}
function validateTable2(){
	if(dsTVDoanDuocKtXm.numOfRow == 1){
		alert('Bạn cần nhập Đơn vị được kiểm tra, xác minh');
		return false;
	}
	for(i = 1; i< dsTVDoanDuocKtXm.numOfRow; i++){
		if(!isRequired(document.getElementsByName('dsTpTdDuocKtXm['+ eval(i-1) +'].hoTen')[0]))
			return false;
		if(!isRequired(document.getElementsByName('dsTpTdDuocKtXm['+ eval(i-1) +'].chucVu')[0]))
			return false;
	}
		
	return true;
}
function validateTable1(){
	for(i = 1; i< dsTVDoanTtkt.numOfRow; i++){
		if(!isRequired(document.getElementsByName('dsTpTdDoanTtKt['+ eval(i-1) +'].idCanBo')[0]))
			return false;
	}
		
	return true;
}

function validateForm(){
		if(!isRequired(document.getElementsByName('skDuocKtXm')[0]))
			return false;
		if(!isRequired(document.getElementsByName('thoiGian')[0]))
			return false;
		if(!isRequired(document.getElementsByName('diaDiem')[0]))
			return false;
		if(!validateTable1())
			return false;
		if(!validateTable2())
			return false;
		if(!isRequired(document.getElementsByName('noiDung')[0]))
			return false;
		
		return true;
	}

	window.onload = function(){
	//thêm dòng trống trước các danh sách
		if($('#table1 tbody tr').length==0){
			AddRowTable1();
		}
		if($('#table2 tbody tr').length==0){
			AddRowTable2();
		}
	} 

	function loadDsTenDvTh(cbDsCanbo1,value){
		 for(var i=0;i<cbDsCanbo1.length;i++ )
		 {
		 	if(cbDsCanbo1.options[i].text == value)
		 		cbDsCanbo1.selectedIndex = i;
		 }
		 
	}

function AddRowTable1() {
	dsTVDoanTtkt.addRow(createNewTptdTVD1());	 	
}
 function AddRowTable2() {
	dsTVDoanDuocKtXm.addRow(createNewTptdTVD2());	 	
}
function createNewTptdTVD1(){
	arReturnRow = new Array();
	index = dsTVDoanTtkt.numOfRow - 1;
	arReturnRow[0] = '<select name = "dsTpTdDoanTtKt['+ index +'].idCanBo" onclick="cacheOldValue(this)" onchange = "setChucVuByIdCabBo(this)" class="combobox" style="width:85%">'
	arReturnRow[0] += document.getElementById('cbDsTvd').innerHTML;
	arReturnRow[0] += '</select>'
	arReturnRow[0] += '<input type="hidden" id ="dsTpTdDoanTtKt['+ index +'].Ten" name="dsTpTdDoanTtKt['+ index +'].hoTen" > ';
	arReturnRow[1] = '<input type = "text" name = "dsTpTdDoanTtKt['+ index +'].chucVu" class="text1" readonly="true" style="border-bottom:none; width:100%">';
	arReturnRow[2] = '<INPUT type="checkbox">';
	return arReturnRow;
}
	 

function createNewTptdTVD2(){
	arReturnRow = new Array();
	index = dsTVDoanDuocKtXm.numOfRow - 1;
	arReturnRow[0] = '<input type="text"  name= "dsTpTdDuocKtXm['+ index +'].hoTen" class="text" style="width:85%"> ';
	arReturnRow[1] = '<input type = "text" name = "dsTpTdDuocKtXm['+ index +'].chucVu"  class="text" style="width:85%">';
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
	dsTVDoanDuocKtXm.selectAllRow();
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
		element = document.getElementsByName('dsTpTdDoanTtKt[' + i + '].idCanBo')[0];
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
			if(cbDsTvd123[i].value == cbThanhVienDoan.value){
				chucVuEn = cbDsTvd123[i].title;
				document.getElementsByName(cbThanhVienDoan.name.replace('.idCanBo', '.chucVu'))[0].value = getChucVuCoDau(chucVuEn);
				document.getElementsByName(cbThanhVienDoan.name.replace('.idCanBo', '.hoTen'))[0].value = cbDsTvd123[i].text;
				return;
			}
		}
		
	}
function print(){	
		if(!validateForm()) return false;	
		document.forms[0].action="kiem_tra_xac_minh.do?method=in";
		document.forms[0].submit();
		document.forms[0].action="kiem_tra_xac_minh.do";
}	
	

function selfClose(){
		window.close();
	}
</script>
<%
if (request.getAttribute("save") != null) {
%>
<script language="javascript">
		alert('Lưu thành công!');
	window.location =  'danh_sach_tim_kiem.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value +'&type=ktXacMinh';
	</script>
<%
}
%>
