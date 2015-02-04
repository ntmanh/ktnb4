<%@page pageEncoding="UTF-8" %>
<%@ include file="/top_bar.jsp"%>
<%@page import="cmc.com.ktnb.util.Formater"%>
<%@page import="jxl.write.DateTime"%>
<script type="text/javascript" src="<html:rewrite page='/include/js/ttkt/ttkt.js'/>"></script>
<script language="javascript">
	dsIdThanhVienDoan = '<%=request.getAttribute("dsIdThanhVienDoan")%>'
	dsIdThanhVienDoan = dsIdThanhVienDoan.split(',');
	dsChucVuTrongDoan = '<%=request.getAttribute("dsChucVuTrongDoan")%>'
	dsChucVuTrongDoan = dsChucVuTrongDoan.split(',');
	dsTenThanhVienDoan = '<%=request.getAttribute("dsTenThanhVienDoan")%>'
	dsTenThanhVienDoan = dsTenThanhVienDoan.split(',');
</script>
<SELECT id="cbDsThanhVienDoan" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="dsThanhVienDoan" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<%@page import="cmc.com.ktnb.util.Constants"%>
<%@page import="cmc.com.ktnb.util.ApplicationContext"%>
<script language="javascript">                
	var tenCqt = "<%=((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getTenCqt()%>";
	var maCqt = '<%=((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getMaCqt()%>';                 
	function selfClose(){
		window.close();
	}
	function xuLySauSaveThanhCong(){
		if(document.getElementsByName('loaiThayDoi')[0].value == 'truong_doan'){
			if(window.opener.location.href.indexOf('danh_sach_tim_kiem.do') > 0){// Truong hop mo tu form tim kiem
				try{
					window.opener.close();
				}catch(err){				 
				}
				try{
					window.opener.opener.location = 'ttkt_index.do';
				}catch(err){
					
				}
								
			}else{
				try{
					window.opener.location = 'ttkt_index.do';
				}catch(err){
				}
			}	
			
		}else{
			try{
				window.opener.location.reload();// Reload form tim kiem (Neu mo truc tiep thi reload form main)
			}catch(err){
			}
			try{
				window.opener.opener.location.reload();// Reload form main
			}catch(err){
			}		
		}
		
		
	}
</script>
<h3 class="Header">Thay đổi thành viên đoàn</h3>
<html:form action="thay_doi_thanh_vien_doan.do">
	<table width="100%" align="center" cellspacing="5">
		<tr style="height: 1">
			<td align="right" width="24%"></td>
			<td align="right" width="1%"></td>
			<td align="left" width="25%"></td>
			<td align="right" width="24%"></td>
			<td align="right" width="1%"></td>
			<td align="left" width="25%"></td>
		</tr>
		<tr>
			<td colspan="6">
			<fieldset><legend>Thông tin quyết định </legend>
			<TABLE width="100%">
				<tr>
					<td align="right" width="24%">Số quyết định</td>
					<td align="right" width="1%"></td>
					<td align="left" width="25%"><html:text styleClass="text" property="soQd"/></td>
					<td align="right" width="24%">Ngày ra quyết định</td>
					<td align="right" width="1%"></td>
					<td align="left" width="25%"><html:text styleClass="text" property="ngayRaQd" onblur="if(!isDate(this)) return; validateNgayRaQD(this)" onkeypress="return formatDate(event, this)">
					</html:text></td>
				</tr>
				<tr>
					<td align="right" width="24%">Nơi ra quyết định</td>
					<td align="right" width="1%"></td>
					<td align="left" width="25%"><html:text styleClass="text" property="noiRaQd"/></td>
					<td align="right" width="24%">Người đề nghị <font color=red>*</font></td>
					<td align="right" width="1%"></td>
					<td align="left" width="25%">
					<table style="margin: 0" border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
						<tr>
							<td align="left" width="90%" style="margin: 0"><html:text styleClass="text" property="tenNguoiDeNghi" onchange="chonNguoiDeNghi()" style="width:100%"></html:text></td>
							<td align="left" width="10%" style="margin: 0"><INPUT type="button" onclick="chonNguoiDeNghi()" value="..." class="lovButton"> <html:hidden property="idNguoiDeNghi" /></td>
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<td align="right" width="24%">Loại thay đổi <font color=red>*</font></td>
					<td align="right" width="1%"></td>
					<td align="left" width="25%"><html:select property="loaiThayDoi" onchange="thayDoiLoaiThayDoi(this.value)" style="width: 100%">
						<html:option value=""></html:option>
						<html:option value="truong_doan">Thay đổi trưởng đoàn</html:option>
						<html:option value="thanh_vien_doan">Thay đổi thành viên đoàn</html:option>
						<html:option value="bo_sung_thanh_vien_doan">Bổ sung thành viên đoàn</html:option>
					</html:select></td>
					<td align="right" width="24%">Chức vụ người đề nghị</td>
					<td align="right" width="1%"></td>
					<td align="left" width="25%"><html:text styleClass="text" property="chucVuNguoiDeNghi" readonly="true"></html:text></td>
				</tr>
				<tr>
					<td align="right" width="24%">Căn cứ luật số</td>
					<td align="right" width="1%"></td>
					<td align="left" width="25%"><html:textarea property="canCuLuatSo" styleClass="text"></html:textarea></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td align="right" width="24%">Căn cứ quyết định</td>
					<td align="right" width="1%"></td>
					<td colspan="4"><html:textarea property="canCuQdinh" style="width: 100%">Căn cứ Quyết định số 1722/QĐ-TCT ngày 08 tháng 10 năm 2014</html:textarea></td>
				</tr>
				<tr>
					<td align="right" width="24%">Văn bản quy định chức năng nhiệm vụ</td>
					<td align="right" width="1%"></td>
					<td colspan="4"><html:select property="vbanQdinhCnangNvu" style="width: 100%" styleClass="combobox">
						<html:option value=""></html:option>
						<html:options collection="dmtly" property="value" labelProperty="label" />
					</html:select></td>
				</tr>
				<tr>
					<td align="right" width="24%">Đơn vị, cá nhân liên quan đến việc tổ chức thực hiện</td>
					<td align="right" width="1%"></td>
					<td colspan="4"><html:textarea property="dvCnCoLquan"  onkeypress="imposeMaxLength(this);"  styleClass="textareaTitle">
					</html:textarea></td>
				</tr>
			</TABLE>
			</fieldset>
			</td>
		</tr>
		<tr id="thayDoi">
			<td colspan="6">
			<fieldset><legend>Thông tin thay đổi </legend>
			<TABLE width="100%">
				<tr>
					<td align="right" width="24%">Ngày thôi tham gia của thành viên cũ <font color=red>*</font></td>
					<td align="right" width="1%"></td>
					<td align="left" width="25%"><html:text styleClass="text" property="ngayThoiThamGia" onblur="if(!isDate(this)) return;validateNgayRaQD(this);" onkeypress="return formatDate(event, this)"></html:text></td>
					<td align="right" width="24%">Ngày bàn giao công việc <font color=red>*</font></td>
					<td align="right" width="1%"></td>
					<td align="left" width="25%"><html:text styleClass="text" property="ngayBanGiao" onblur="if(!isDate(this)) return;validateNgayRaQD(this);" onkeypress="return formatDate(event, this)"></html:text>
				</tr>
				<tr>
					<td align="right" width="24%">Ngày bắt đầu của thành viên mới <font color=red>*</font></td>
					<td align="right" width="1%"></td>
					<td align="left" width="25%"><html:text styleClass="text" property="ngayBdauCuaTvienMoi" onblur="if(!isDate(this)) return;validateNgayRaQD(this);" onkeypress="return formatDate(event, this)"></html:text></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</TABLE>
			</fieldset>
			</td>
		</tr>
		<tr id="thaydoitruongdoan">
			<td colspan="6">
			<fieldset><legend>Trưởng đoàn mới </legend>
			<table width="100%">
				<tr>
					<td align="right" width="24%">Trưởng đoàn mới <font color=red>*</font></td>
					<td align="right" width="1%">
					<td align="left" width="25%">
					<table style="margin: 0" border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
						<tr>
							<td align="left" width="90%" style="margin: 0"><html:text styleClass="text" property="tenThanhVienMoi" onchange="chonTruongDoanMoi()" style="width:100%">
							</html:text></td>
							<td align="left" width="10%" style="margin: 0"><INPUT type="button" value="..." onclick="chonTruongDoanMoi()" class="lovButton"> <html:hidden property="idThanhVienMoi" /></td>
						</tr>
					</table>
					</td>
					<td align="right" width="24%">Chức vụ công tác</td>
					<td align="right" width="1%">
					<td align="left" width="25%"><html:text styleClass="text" property="chucVuThanhVienMoi" readonly="true"></html:text></td>
				</tr>
				<tr>
					<td align="right" width="24%">Đơn vị công tác</td>
					<td align="right" width="1%">
					<td align="left" colspan="4" width="75%"><html:text styleClass="text" property="donViCongTacTvMoi" readonly="true">
					</html:text></td>
					<!-- 
					<td align="right" width="24%"></td>
					<td align="right" width="1%"></td>
					<td align="left" width="25%"></td>
					-->
				</tr>
			</table>
			</fieldset>
			</td>
		</tr>
		<tr id="thaydoithanhvien">
			<td colspan="6">
			<fieldset><legend>Danh sách thay đổi thành viên </legend>
			<TABLE id="tblThayDoiThanhVien" width="100%">
				<THEAD id="headerDsTvdtd">
					<tr class="TdHeaderList">
						<td>Thành viên cũ <font color=red>*</font></td>
						<td>Chức vụ trong đoàn <font color=red>*</font></td>
						<td width="20%">Thành viên mới <font color=red>*</font></td>
						<td>Đơn vị công tác</td>
						<td>Chức vụ công tác</td>
						<td align="center"><INPUT type="checkbox"></td>
					</tr>
				</THEAD>
				<TBODY id="bodyDsTvdtd">
					<logic:present name="ThayDoiThanhVienDoanForm" property="noiDungThayDoi">
						<logic:iterate id="thayDoi" name="ThayDoiThanhVienDoanForm" property="noiDungThayDoi" indexId="index">
							<tr class='row<%=(index.intValue() % 2)+1 %>'>
								<td><html:select styleClass="combobox" name="ThayDoiThanhVienDoanForm" property='<%="noiDungThayDoi[" + index + "].idThanhVienCu"%>' onchange="thayDoiThanhVienCu(this)" onclick="cacheOldValue(this)">
									<html:options collection="dsThanhVienDoan" property="idCanBo" labelProperty="tenCanBo" />
								</html:select> <html:hidden name="ThayDoiThanhVienDoanForm" property='<%="noiDungThayDoi[" + index + "].tenThanhVienCu"%>' /></td>
								<td><html:text readonly="true" styleClass="text1" name="ThayDoiThanhVienDoanForm" property='<%="noiDungThayDoi[" + index + "].chucVuThanhVienCu"%>' style="border-bottom:none;"></html:text></td>
								<td><html:hidden name="ThayDoiThanhVienDoanForm" property='<%="noiDungThayDoi[" + index + "].idThanhVienMoi"%>' /> <html:text readonly="true" styleClass="text" name="ThayDoiThanhVienDoanForm" property='<%="noiDungThayDoi[" + index + "].tenThanhVienMoi"%>' style="width:80%"></html:text>
								<INPUT type="button" onclick="chonThanhVienMoi(<%=index%>)" class="lovButton" value="..."></td>
								<td><html:text readonly="true" styleClass="text1" name="ThayDoiThanhVienDoanForm" property='<%="noiDungThayDoi[" + index + "].donViCongTacTvMoi"%>' style="border-bottom:none;"></html:text></td>
								<td><html:text readonly="true" styleClass="text1" name="ThayDoiThanhVienDoanForm" property='<%="noiDungThayDoi[" + index + "].chucVuThanhVienMoi"%>' style="border-bottom:none; width:100%"></html:text></td>
								<td align="center"><INPUT type="checkbox"></td>
							</tr>
						</logic:iterate>
					</logic:present>
				</TBODY>
			</TABLE>
			<DIV style="text-align: right"><INPUT type="button" class="button" onclick="themThayDoiThanhVien()" value="Thêm"> <INPUT type="button" class="button" id="xoaThayDoiThanhVien" value="Xóa"></DIV>
			</fieldset>
			</td>
		</tr>
		<tr id="bosungthanhvien">
			<td colspan="6">
			<fieldset><legend>Danh sách thành viên bổ sung </legend>
			<TABLE id="tblBoSungThanhVien" width="100%">
				<THEAD id="headerDsTvdbs">
					<tr class="TdHeaderList">
						<td align="center">STT</td>
						<td>Thành viên mới <font color=red>*</font></td>
						<td width="20%">Đơn vị công tác</td>
						<td>Chức vụ công tác</td>
						<td>Chức vụ trong đoàn</td>
						<td align="center"><INPUT type="checkbox"></td>
					</tr>
				</THEAD>
				<TBODY id="bodyDsTvdbs">
					<logic:present name="ThayDoiThanhVienDoanForm" property="noiDungBoSung">
						<logic:iterate id="thayDoi" name="ThayDoiThanhVienDoanForm" property="noiDungBoSung" indexId="index">
							<tr class='row<%=(index.intValue() % 2)+1 %>'>
								<td align="center"><%=index.intValue() + 1%></td>
								<td><html:hidden name="ThayDoiThanhVienDoanForm" property='<%="noiDungBoSung[" + index + "].idThanhVienMoi"%>' /> <html:text readonly="true" styleClass="text" name="ThayDoiThanhVienDoanForm" property='<%="noiDungBoSung[" + index + "].tenThanhVienMoi"%>' style="width:80%"></html:text> <INPUT
									type="button" value="..." class="lovButton" onclick="chonThanhVienMoi(<%=index%>)"></td>
								<td><html:text readonly="true" styleClass="text1" name="ThayDoiThanhVienDoanForm" property='<%="noiDungBoSung[" + index + "].donViCongTacTvMoi"%>' style="border-bottom:none; "></html:text></td>
								<td><html:text readonly="true" styleClass="text1" name="ThayDoiThanhVienDoanForm" property='<%="noiDungBoSung[" + index + "].chucVuThanhVienMoi"%>' style="border-bottom:none; width:100%"></html:text></td>
								<td><html:select name="ThayDoiThanhVienDoanForm" property='<%="noiDungBoSung[" + index + "].chucVuTrongDoanThanhVienMoi"%>'>
									<html:option value="Pho doan">Phó đoàn</html:option>
									<html:option value="Thanh vien doan">Thành viên đoàn</html:option>
								</html:select></td>
								<td align="center"><INPUT type="checkbox"></td>
							</tr>
						</logic:iterate>
					</logic:present>
				</TBODY>
			</TABLE>
			<DIV style="text-align: right"><INPUT type="button" class="button" onclick="themBoSungThanhVien()" value="Thêm"> <INPUT type="button" class="button" id="xoaBoSungThanhVien" value="Xóa"></DIV>
			</fieldset>
			</td>
		</tr>
	</table>
	<html:hidden property="id" />
	<html:hidden property="idCuocTtkt" />
	<html:hidden property="idDstvCu" />
	<html:hidden property="idDstvMoi" />
</html:form>
<DIV style="text-align: right;margin-right: 10px;"><INPUT type="button" class="button1" onclick="inQuyetDinh()" value="In quyết định" class="button1"></DIV>
<html:select name='ThayDoiThanhVienDoanForm' property='dungTieuSao' style="display: none;">
	<html:option value=""></html:option>
	<html:options collection="dsThanhVienDoan" property="idCanBo" labelProperty="tenCanBo" />
</html:select>
<div style="text-align: center"><%@ include file="action_bar.jsp"%></div>
<%@ include file="/bottom.jsp"%>
<script language="javascript">
// ham findIDTruongDoan() : lay ra ID cua truong doan
var ngayRaQuyetDnh = '<%=Formater.objectDate2Str(request.getAttribute("ngayRaQuyetDnh"))%>';
var idTruongDoan = findIDTruongDoan();

// tim kiem ID cua Truong doan - vietnd
function findIDTruongDoan(){
   var idTruongDoan ='';     
   for(var i=0;i<dsChucVuTrongDoan.length;i++){
      if('Truong doan'==dsChucVuTrongDoan[i]){
      		idTruongDoan =  dsIdThanhVienDoan[i];    
      		break;       
      }
   }
   return idTruongDoan;
}


var tmpIdCanBo;
var tmpTenCanBo;
var tmpChucVu;
function cacheOldValue(controlIdTvd){
	tmpIdCanBo = controlIdTvd.value;
	tmpTenCanBo = document.getElementsByName(controlIdTvd.name.replace('.idThanhVienCu','.tenThanhVienCu'))[0].value;
	tmpChucVu = document.getElementsByName(controlIdTvd.name.replace('.idThanhVienCu','.chucVuThanhVienCu'))[0].value;
}
function existInSelected(controlIdTvd){
	for(var i = 0; i< bangThayDoiThanhVien.numOfRow - 1; i++){
		element = document.getElementsByName('noiDungThayDoi[' + i + '].idThanhVienCu')[0];
		if(element != null && element != controlIdTvd && element.value == controlIdTvd.value)
			return true;			
	}
	return false;
}
function thayDoiThanhVienCu(controlIdTvd){         
	if(existInSelected(controlIdTvd)){
		alert('Thành viên này đã được chọn!');
		controlIdTvd.value = tmpIdCanBo;
		document.getElementsByName(controlIdTvd.name.replace('.idThanhVienCu','.tenThanhVienCu'))[0].value = tmpTenCanBo;
		document.getElementsByName(controlIdTvd.name.replace('.idThanhVienCu','.chucVuThanhVienCu'))[0].value = tmpChucVu;
		controlIdTvd.focus();
		return;
	}
	dsCanBoHopDoanTk = document.getElementById('cbDsThanhVienDoan');
	for(var i = 0; i< dsCanBoHopDoanTk.length; i++){
		if(dsCanBoHopDoanTk[i].value == controlIdTvd.value){
			chucVuEn = dsCanBoHopDoanTk[i].title;
			document.getElementsByName(controlIdTvd.name.replace('.idThanhVienCu','.tenThanhVienCu'))[0].value = dsCanBoHopDoanTk[i].text;
			document.getElementsByName(controlIdTvd.name.replace('.idThanhVienCu','.chucVuThanhVienCu'))[0].value = getChucVuCoDau(chucVuEn);			
			return;
		}
	}	
}

function thayDoiThanhVienCu_old(controlIdTvCu){    
	document.getElementsByName(controlIdTvCu.name.replace('idThanhVienCu','tenThanhVienCu'))[0].value = controlIdTvCu[controlIdTvCu.selectedIndex].text;
	cbBoxDstvd = document.getElementById("cbDsThanhVienDoan");
	
	for(var i = 0; i< cbBoxDstvd.length; i++){
		if(cbBoxDstvd[i].value == controlIdTvCu.value){
			chucVuEn = cbBoxDstvd[i].title;
			document.getElementsByName(controlIdTvCu.name.replace('idThanhVienCu','chucVuThanhVienCu'))[0].value = getChucVuCoDau(chucVuEn);
			
			return;
		}
	}
	
}
function getChucVuTvd(){
}
function inQuyetDinh(){
	if(!isRequired(document.getElementsByName('tenNguoiDeNghi')[0]))
		return false;
	if(!isRequired(document.forms[0].elements['loaiThayDoi']))
		return false;
	// 
	if(document.forms[0].elements['loaiThayDoi'].value=='truong_doan'){
		if(!isRequired(document.forms[0].elements['ngayThoiThamGia']))
			return false;
			
		if(!isRequired(document.forms[0].elements['ngayBanGiao']))
			return false;
		
		if(!isRequired(document.forms[0].elements['ngayBdauCuaTvienMoi']))
			return false;
		
		if(!isRequired(document.forms[0].elements['tenThanhVienMoi']))
			return false;	
		
	}else if(document.forms[0].elements['loaiThayDoi'].value=='thanh_vien_doan'){
		if(!isRequired(document.forms[0].elements['ngayThoiThamGia']))
			return false;
			
		if(!isRequired(document.forms[0].elements['ngayBanGiao']))
			return false;
		
		if(!isRequired(document.forms[0].elements['ngayBdauCuaTvienMoi']))
			return false;
			
		if(bangThayDoiThanhVien.numOfRow <=1){
			alert('Chưa nhập danh sách thay đổi');
			return false;
		}
		for(var i = 0; i< bangThayDoiThanhVien.numOfRow - 2; i++){
			if(!isRequired(document.forms[0].elements['noiDungThayDoi['+ i + '].idThanhVienCu']))
				return false;
				
			if(!isRequired(document.forms[0].elements['noiDungThayDoi['+ i + '].chucVuThanhVienCu']))
				return false;
				
			if(!isRequired(document.forms[0].elements['noiDungThayDoi['+ i + '].tenThanhVienMoi']))
				return false;			
		}
	
	}else if(document.forms[0].elements['loaiThayDoi'].value=='bo_sung_thanh_vien_doan'){
		if(bangBoSungThanhVien.numOfRow <=1){
			alert('Chưa nhập danh sách bổ sung!');
			return false;
		}
		for(var i = 0; i< bangBoSungThanhVien.numOfRow - 2; i++){
			if(!isRequired(document.forms[0].elements['noiDungBoSung['+ i + '].tenThanhVienMoi']))
				return false;		
		}
		
	}
	var action;
	var contextRoot = document.forms[0].action.split('/')[1];
	var thongTinIn = "";
		var qdForm = findForm('/' + contextRoot + '/thay_doi_thanh_vien_doan.do');	 
		for(var i = 0; i< qdForm.elements.length; i++){
			if(qdForm.elements[i].name != null && qdForm.elements[i].name != '' && qdForm.elements[i].value != null && qdForm.elements[i].value != '')
			thongTinIn += "&" + qdForm.elements[i].name + "=" + encodeURIComponent(qdForm.elements[i].value);
		}		
	if(document.forms[0].elements['loaiThayDoi'].value == 'truong_doan'){
		action = 'thay_doi_thanh_vien_doan.do?method=in&type=truongDoan';
	}else if(document.forms[0].elements['loaiThayDoi'].value == 'thanh_vien_doan'){
		action = 'thay_doi_thanh_vien_doan.do?method=in&type=thanhVienDoan';
	}else if(document.forms[0].elements['loaiThayDoi'].value == 'bo_sung_thanh_vien_doan'){
		action = 'thay_doi_thanh_vien_doan.do?method=in&type=boSungTv' + thongTinIn;
	}
	document.forms[0].action = action;
	document.forms[0].submit();
	document.forms[0].action = 'thay_doi_thanh_vien_doan.do';                 
}
var bangBoSungThanhVien = new TableObject('tblBoSungThanhVien', true, 'xoaBoSungThanhVien');
function themBoSungThanhVien(){
	bangBoSungThanhVien.addRow(createNewRowBoSungThanhVien());
}
function createNewRowBoSungThanhVien(){
	arrReturn = new Array(); 
	index = bangBoSungThanhVien.numOfRow - 1;
	
	arrReturn[0] = '<input type="hidden" name="noiDungBoSung[' + index + '].idThanhVienMoi">';
	arrReturn[0] += '<input type="text" name="noiDungBoSung[' + index + '].tenThanhVienMoi" class="text" style="width:80%">';
	arrReturn[0] += '<INPUT type="button" onclick="chonThanhVienMoi(' + index + ')" value = "..." class="lovButton">';
	
	arrReturn[1] = '<input type="text" readOnly = "true" name="noiDungBoSung[' + index + '].donViCongTacTvMoi" class="text1" style="border-bottom:none; ">';
	
	arrReturn[2] = '<input type="text" readOnly = "true" name="noiDungBoSung[' + index + '].chucVuThanhVienMoi" class="text1" style="border-bottom:none; width:100%">';
	
	arrReturn[3] = '<select name="noiDungBoSung[' + index + '].chucVuTrongDoanThanhVienMoi" >';
	arrReturn[3] += '<OPTION selected value="Pho doan">Phó đoàn</OPTION>';
	arrReturn[3] += '<OPTION value="Thanh vien doan">Thành viên đoàn</OPTION>';
	arrReturn[3] += '</select>'
	
	
										
	arrReturn[4] = '<INPUT type="checkbox">';	
									
	return arrReturn;
}
var bangThayDoiThanhVien = new TableObject('tblThayDoiThanhVien', false, 'xoaThayDoiThanhVien');
function themThayDoiThanhVien(){
	bangThayDoiThanhVien.addRow(createNewRowThayDoiThanhVien());
}
// ham khoi tao danh sach thanh vien doan , hok co Truong doan       
function createOptionDSThanhVien(){              
	var optionString = '<OPTION selected value=""></OPTION>';
	for(var i=0;i<dsIdThanhVienDoan.length;i++){    
		if(idTruongDoan!=dsIdThanhVienDoan[i]){
		   optionString += '<OPTION value="'+dsIdThanhVienDoan[i]+'">'+dsTenThanhVienDoan[i]+'</OPTION>';
		}
	} 
	return optionString;                  
}
         
function createNewRowThayDoiThanhVien(){
	arrReturn = new Array(); 
	index = bangThayDoiThanhVien.numOfRow - 1;
	
	arrReturn[0] = '<select class="combobox" name="noiDungThayDoi[' + index + '].idThanhVienCu" onclick="cacheOldValue(this)" onchange="thayDoiThanhVienCu(this)">';
	//arrReturn[0] += document.getElementById('dungTieuSao').innerHTML;          
	
	arrReturn[0] += createOptionDSThanhVien();    
	arrReturn[0] += '</select>';
	arrReturn[0] += '<input type="hidden" name="noiDungThayDoi[' + index + '].tenThanhVienCu">';
	
	arrReturn[1] = '<input type="text" name="noiDungThayDoi[' + index + '].chucVuThanhVienCu" class="text1" readonly="true" style="border-bottom:none;">';
	
	arrReturn[2] = '<input type="hidden" name="noiDungThayDoi[' + index + '].idThanhVienMoi">';
	arrReturn[2] += '<input type="text" name="noiDungThayDoi[' + index + '].tenThanhVienMoi" class="text" style="width:80%">';
	arrReturn[2] += '<INPUT type="button" onclick="chonThanhVienMoi(' + index + ')" value = "..." class="lovButton">';
	
	arrReturn[3] = '<input type="text" readOnly = "true" name="noiDungThayDoi[' + index + '].donViCongTacTvMoi" class="text1" style="border-bottom:none;">';
	
	arrReturn[4] = '<input type="text" readOnly = "true" name="noiDungThayDoi[' + index + '].chucVuThanhVienMoi" class="text1" style="border-bottom:none; width:100%">';
	
	arrReturn[5] = '<INPUT type="checkbox">';
	
									
	return arrReturn;
}
var idCanBoConTrol;
var tenCanBoConTrol;
var donViCongTacControl;
var chucVuConTrol;

function chonNguoiDeNghi(){
		lovType = 'chonNguoiDeNghi';
		// Id
		idCanBoConTrol = document.getElementsByName('idNguoiDeNghi')[0];
		// Ten
		tenCanBoConTrol = document.getElementsByName('tenNguoiDeNghi')[0];
		
		// Chuc vu
		chucVuConTrol = document.getElementsByName('chucVuNguoiDeNghi')[0];
		
		showLovNhanVien(maCqt, tenCanBoConTrol)
		
		win.focus(); 
}
function chonTruongDoanMoi(){
	lovType = 'chonTruongDoanMoi';
	// Id
	idCanBoConTrol = document.getElementsByName('idThanhVienMoi')[0];
	// Ten
	tenCanBoConTrol = document.getElementsByName('tenThanhVienMoi')[0];
	// Don vi cong tac
	donViCongTacControl = document.getElementsByName('donViCongTacTvMoi')[0];
	// Chuc vu
	chucVuConTrol = document.getElementsByName('chucVuThanhVienMoi')[0];
	showLovNhanVien(maCqt, tenCanBoConTrol,"true");//Thanh vien doan phai la nguoi su dung
}
function chonThanhVienMoi(index){
	if(document.forms[0].elements['loaiThayDoi'].value == 'thanh_vien_doan'){
		lovType = 'tvdtd';
		// Id
		idCanBoConTrol = document.getElementsByName('noiDungThayDoi[' + index + '].idThanhVienMoi')[0];
		// Ten
		tenCanBoConTrol = document.getElementsByName('noiDungThayDoi[' + index + '].tenThanhVienMoi')[0];
		// Don vi cong tac
		donViCongTacControl = document.getElementsByName('noiDungThayDoi[' + index + '].donViCongTacTvMoi')[0];
		// Chuc vu
		chucVuConTrol = document.getElementsByName('noiDungThayDoi[' + index + '].chucVuThanhVienMoi')[0];
	}else{
		lovType = 'tvdbs';
		// Id
		idCanBoConTrol = document.getElementsByName('noiDungBoSung[' + index + '].idThanhVienMoi')[0];
		// Ten
		tenCanBoConTrol = document.getElementsByName('noiDungBoSung[' + index + '].tenThanhVienMoi')[0];
		// Don vi cong tac
		donViCongTacControl = document.getElementsByName('noiDungBoSung[' + index + '].donViCongTacTvMoi')[0];
		// Chuc vu
		chucVuConTrol = document.getElementsByName('noiDungBoSung[' + index + '].chucVuThanhVienMoi')[0];
	}
	//showLovNhanVien(maCqt, tenCanBoConTrol)
	showLovNhanVienWithCQTrucThuoc(maCqt, tenCanBoConTrol);
}
function existTruongDoan(maCanBo){
	if(maCanBo == idTruongDoan){
		return true;
	}	 
	for(var i=0;i<dsIdThanhVienDoan.length;i++){
	    if(maCanBo == dsIdThanhVienDoan[i]){          
			return true;    
		}	     
	}     
	return false; 
}

// ham kiem tra ton tai ma can bo : elementID la ten cua phan tu id tren form , cell la o can check du lieu
// bien elementID lay 2 gia tri 'bodyDsTvdbs' va 'bodyDsTvdtd'
// bien cell t/ung lay 2 gia tri 1  va  2 
function existTVD(maCanBo,elementID,cell){
	var allRowDsThanhVien = document.getElementById(elementID).childNodes;
	// ktra trung tren table nhap
	for(var i = 0; i< allRowDsThanhVien.length; i++){
		var rowThanhVien = allRowDsThanhVien[i];
		var colTenThanhVien = rowThanhVien.cells[cell];
		if(maCanBo == colTenThanhVien.childNodes[0].value){
			return true;
		}	 
	}
	// ktra trung vs danh sach thanh vien cu hok 
	for(var i=0;i<dsIdThanhVienDoan.length;i++){
	    if(maCanBo == dsIdThanhVienDoan[i]){          
			return true;    
		}	     
	}
	return false; 
}

var lovType;
function setThongTinNhanVienFromLov(maCanBo, tenCanBo, chucVu, tenPhong, tenCqt){
	if('chonNguoiDeNghi' == lovType){     
		idCanBoConTrol.value = maCanBo;
		// Ten 
		tenCanBoConTrol.value = tenCanBo;
		// Chuc vu
		chucVuConTrol.value = chucVu;
	}else{
		if(existTVD(maCanBo,'bodyDsTvdtd',2)&&lovType=='tvdtd'){       
			idCanBoConTrol.value = "";
			tenCanBoConTrol.value = ""; 			     
			if(tenCanBoConTrol.name.indexOf('noiDungThayDoi') >=0){				
				return 'Cán bộ này đã tồn tại!';
			}
		} 
		if(existTVD(maCanBo,'bodyDsTvdbs',1)&&lovType=='tvdbs'){              
			idCanBoConTrol.value = "";
			tenCanBoConTrol.value = ""; 			
			if(tenCanBoConTrol.name.indexOf('noiDungBoSung') >=0){
				return 'Cán bộ này đã tồn tại!';
			}	
		} 
		if(existTruongDoan(maCanBo)&&lovType == 'chonTruongDoanMoi'){
			idCanBoConTrol.value = "";
			tenCanBoConTrol.value = "";
			chucVuConTrol.value = ""; 	
			donViCongTacControl.value = "";     
			return 'Cán bộ này trong danh sách thành viên cũ!';      
		}
		idCanBoConTrol.value = maCanBo;
		tenCanBoConTrol.value = tenCanBo; 	
		if(donViCongTacControl != null){
			if(!isEmpty(tenPhong)){
				donViCongTacControl.value = tenPhong;
				if(!isEmpty(tenCqt)){
					donViCongTacControl.value += ', ' + tenCqt;
				}
			}else if(!isEmpty(tenCqt)){
				donViCongTacControl.value = tenCqt;
			}	
		
		}
		if(chucVuConTrol!=null){
			chucVuConTrol.value = chucVu;	
		}	
	}
	
}       

function validateForm(){		
	if(!isRequired(document.getElementsByName('tenNguoiDeNghi')[0]))
		return false;
	if(!isRequired(document.forms[0].elements['loaiThayDoi']))
		return false;
	// 
	if(document.forms[0].elements['loaiThayDoi'].value=='truong_doan'){
		if(!isRequired(document.forms[0].elements['ngayThoiThamGia']))
			return false;
			
		if(!isRequired(document.forms[0].elements['ngayBanGiao']))
			return false;
		
		if(!isRequired(document.forms[0].elements['ngayBdauCuaTvienMoi']))
			return false;
		
		if(!isRequired(document.forms[0].elements['tenThanhVienMoi']))
			return false;	
		
	}else if(document.forms[0].elements['loaiThayDoi'].value=='thanh_vien_doan'){
		if(!isRequired(document.forms[0].elements['ngayThoiThamGia']))
			return false;
			
		if(!isRequired(document.forms[0].elements['ngayBanGiao']))
			return false;
		
		if(!isRequired(document.forms[0].elements['ngayBdauCuaTvienMoi']))
			return false;
			
		if(bangThayDoiThanhVien.numOfRow <=1){
			alert('Chưa nhập danh sách thay đổi');
			return false;
		}
		for(var i = 0; i< bangThayDoiThanhVien.numOfRow - 2; i++){
			if(!isRequired(document.forms[0].elements['noiDungThayDoi['+ i + '].idThanhVienCu']))
				return false;
				
			if(!isRequired(document.forms[0].elements['noiDungThayDoi['+ i + '].chucVuThanhVienCu']))
				return false;
				
			if(!isRequired(document.forms[0].elements['noiDungThayDoi['+ i + '].tenThanhVienMoi']))
				return false;			
		}
	
	}else if(document.forms[0].elements['loaiThayDoi'].value=='bo_sung_thanh_vien_doan'){
		if(bangBoSungThanhVien.numOfRow <=1){
			alert('Chưa nhập danh sách bổ sung!');
			return false;
		}
		for(var i = 0; i< bangBoSungThanhVien.numOfRow - 2; i++){
			if(!isRequired(document.forms[0].elements['noiDungBoSung['+ i + '].tenThanhVienMoi']))
				return false;		
		}
		
	}
	// validate thong tin chung
	if(!isEmpty(document.getElementsByName('soQd')[0].value)){
		if(!confirm('Đã có số quyết định thay đổi thành viên, sau khi lưu sẽ không thể sửa, xóa thông tin!'))
			return false;
		if(!isRequired(document.getElementsByName('ngayRaQd')[0], 'Cần nhập ngày ra quyết định cùng số quyết định!'))
			return false;
		if(!isRequired(document.getElementsByName('noiRaQd')[0], 'Cần nhập nơi ra quyết định cùng số quyết định!'))
			return false;
	}
	return true;
}
function validateNgayRaQD(dateElement){
if(dateElement.value != ""){
	if(d2n(dateElement.value) < d2n(ngayRaQuyetDnh)){
		alert('Thời gian phải sau ngày ra quyết định ('+ngayRaQuyetDnh+')!');
		$(dateElement).focus().select();
		return;		
	}
	}
}
function thayDoiLoaiThayDoi(type){
	if(type == 'truong_doan'){
		$("#thaydoithanhvien").css("display","none"); 
		$("#bosungthanhvien").css("display","none"); 
		$("#thaydoitruongdoan").css("display","inline"); 
		$("#thayDoi").css("display","inline"); 
		
	}else if(type == 'thanh_vien_doan'){
		$("#thaydoithanhvien").css("display","inline"); 
		$("#thayDoi").css("display","inline"); 
		$("#bosungthanhvien").css("display","none"); 
		$("#thaydoitruongdoan").css("display","none"); 
	}else if(type == 'bo_sung_thanh_vien_doan'){
		$("#thaydoithanhvien").css("display","none"); 
		$("#bosungthanhvien").css("display","inline"); 
		$("#thaydoitruongdoan").css("display","none"); 
		
		$("#thayDoi").css("display","none"); 
		
	}else{
		$("#thaydoithanhvien").css("display","none"); 
		$("#bosungthanhvien").css("display","none"); 
		
		$("#thaydoitruongdoan").css("display","none"); 

		$("#thayDoi").css("display","none"); 

	}
}
//để một dòng trống trước các danh sách
if($('#tblThayDoiThanhVien tbody tr').length==0){
		themThayDoiThanhVien();
	}
if($('#tblBoSungThanhVien tbody tr').length==0){
		themBoSungThanhVien();
	}
</script>
<script language="javascript">
	thayDoiLoaiThayDoi(document.getElementsByName('loaiThayDoi')[0].value);
</script>
<logic:present name="auditRight">
	<script language="javascript">
		alert('Chỉ được sửa lần thay đổi trưởng đoàn gần nhất!');
	</script>
</logic:present>