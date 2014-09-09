<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%>
<%@page import="cmc.com.ktnb.web.ttkt.dung_chung.form.TimKiemCuocTtktForm"%>
<%//String tiTle = "Tìm kiếm cuộc Thanh tra Kiểm Tra";
String tiTle = "Tìm kiếm";   
if (request.getAttribute("title") == null || !"".equals(request.getAttribute("title")))
	tiTle = (String) request.getAttribute("title");
String nghiepVu = ((TimKiemCuocTtktForm) request.getAttribute("TimKiemCuocTtktForm")).getNghiepVu();
%>
<h3 class="Header">Thông tin Thanh tra Kiểm tra</h3>
<%@page import="cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt"%>
<script type="text/javascript" src="<html:rewrite page='/include/js/ttkt/tim_kiem.js'/>">
</script>
<html:form action="tim_kiem_cuoc_ttkt.do">
	<fieldset style="margin: 5px"><legend><bean:message key="label.thong_tin_tim_kiem" /></legend>
	<table width="100%" align="center" cellspacing="5">
		<%if ("timKiem".equals(nghiepVu)) {%>
		<tr>
			<td align="right" width="19%">Năm tiến hành</td>
			<td width="1%"></td>
			<td align="left" width="30%"><html:text property="namTienHanh" styleClass="text" onkeypress="return formatInt(event);">
			</html:text></td>
			<td align="right" width="19%">Đơn vị tiến hành</td>
			<td width="1%"></td>
			<td><html:text property="tenCqtTienHanh" styleClass="text"/></td>
		</tr>
		<%}%>
		<tr>
			<td width="19%" align="right"><bean:message key="label.ma_cuoc_ttkt" /></td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="ma_cuoc_ttkt"/></td>
			<td width="19%" align="right"><bean:message key="label.don_vi_duoc_ttkt" /></td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="don_vi_duoc_ttkt" /></td>
		</tr>
		<tr>
			<td align="right">Thời kỳ: Từ ngày</td>
			<td align="right"></td>
			<td align="left"><html:text styleClass="text" property="tu_ngay" onkeypress="return formatDate(event,this);" onblur="isDate(this)" /></td>
			<td align="right"><bean:message key="label.den_ngay" /></td>
			<td align="right"></td>
			<td align="left"><html:text styleClass="text" property="den_ngay" onkeypress="return formatDate(event,this);" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td width="19%" align="right">Thời gian dự kiến</td>
			<td width="1%" align="right"></td>
			<td width="30%" align="left"><html:text styleClass="text" style="width: 40" property="thoiGianDuKien" onkeypress="return formatInt(event);" onblur="if(!isNumber(this, 'i')) return;" /> Ngày</td>
			<td width="19%" align="right">Từ ngày - đến ngày</td>
			<td width="1%" align="right"></td>
			<td width="30%" align="left">
			<table style="margin: 0" border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
				<tr>
					<td align="left" width="45%" style="margin: 0"><html:text styleClass="text" property="thoiGianDuKienTuNgay" onkeypress="return formatDate(event,this);" onblur="if(!isDate(this)) return; compareDate(this, document.getElementsByName('thoiGianDuKienDenNgay')[0]);" /></td>
					<td width="10%" align="center" style="text-align: center; margin: 0">-</td>
					<td align="right" width="45%" style="margin: 0"><html:text styleClass="text" styleClass="text" property="thoiGianDuKienDenNgay" onkeypress="return formatDate(event, this);" onblur="if(!isDate(this)) return; compareDate(document.getElementsByName('thoiGianDuKienTuNgay')[0], this);" /></td>
				</tr>
			</table>
			</td>
		</tr>
		
		<tr>
			<td width="19%" align="right">Tên trưởng đoàn</td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="tenTruongDoan"/></td>
			<td width="19%" align="right">Sắp xếp</td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%">
					<html:select property="sapXep" style="width: 100%">
						<html:option value="TangThoiGian">Tăng theo thời gian thực hiện</html:option>
						<html:option value="GiamThoiGian">Giảm theo thời gian thực hiện</html:option>
						<html:option value="TangThuTu">Tăng theo thứ tự cuộc TTKT</html:option>						
						<html:option value="GiamThuTu">Giảm theo thứ tự cuộc TTKT</html:option>
					</html:select>
			</td>
		</tr>
		<tr>
			<td align="right"><bean:message key="label.loai" /></td>
			<td align="right"></td>
			<td align="left"><html:select styleClass="combobox" property="loai">
				<!--Dot xuat, dinh ky-->
				<html:option value="all">
					<bean:message key="label.tat_ca" />
				</html:option>
				<html:option value="0">
					<bean:message key="label.dinh_ky" />
				</html:option>
				<html:option value="1">
					<bean:message key="label.dot_xuat" />
				</html:option>
			</html:select></td>
			<%if ("timKiem".equals(nghiepVu)) {%>
			<td align="right">
			<%if ("timKiem".equals(nghiepVu)) {%> Trạng thái <%}%>
			</td>
			<td align="left"></td>
			<td>
			<%if ("timKiem".equals(nghiepVu)) {%> <html:select property="trangThai" style="width: 100%">
				<html:option value="">Tất cả</html:option>
				<html:options name="dsTrangThaiTtkt" />
			</html:select> <%} else {%> <%@ include file="/ttkt/dung_chung/tim_kiem.jsp"%> <%}%>
			</td>
			<%}else{%>
			<td></td>
			<td></td>
			<td><%@ include file="/ttkt/dung_chung/tim_kiem.jsp"%></td>
			<%}%>
		</tr>
		<%if ("timKiem".equals(nghiepVu)) {%>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><%@ include file="/ttkt/dung_chung/tim_kiem.jsp"%></td>
		</tr>
		<%}%>
	</table>
	</fieldset>
	<Fieldset style="margin: 5px"><legend>Tổng số: <%=request.getAttribute("countResult")%> </legend>
	<table width="100%" align="center">
		<tr class="TdHeaderListOfSearch">
			<td width="10%">Mã</td>
			<td align="left" width="15%">Đơn vị tiến hành</td>
			<td align="left" width="15%">Đơn vị được kiểm tra</td>
			<td width="17%">Thời kỳ</td>
			<td align="center" width="8%">Thời gian</td>
			<td width="13%">Từ ngày - đến ngày</td>
			<td width="7%">Loại</td>
			<td align="left" width="15%">Trạng thái</td>
		</tr>
		<logic:iterate id="cuocTTKT" name="tableKetQuaTimKiem" property="data" indexId="index">
			<tr class='row<%=(index.intValue() % 2)+1 %>'>
				<td><A href="#" onclick="openNghiepVu('<bean:write name="cuocTTKT" property="id"/>')"> <bean:write name="cuocTTKT" property="ma" /> </A></td>
				<td align="left"><bean:write name="cuocTTKT" property="tenDonViTh" /></td>
				<td align="left"><bean:write name="cuocTTKT" property="tenDonViBi" /></td>
				<td><script language="javascript">
						document.write('<bean:write name="cuocTTKT" property="nienDoTuNgayStr"/>' + '-' + '<bean:write name="cuocTTKT" property="nienDoDenNgayStr"/>');
					</script></td>
				<td align="center"><script language="javascript">
						document.write('<bean:write name="cuocTTKT" property="thoiGianDuKien"/>');
						document.write(' ngày');
					</script></td>
				<td><script language="javascript">
						document.write('<bean:write name="cuocTTKT" property="thoiGianDuKienTuNgayStr"/>'.substring(0,5) + '-' + '<bean:write name="cuocTTKT" property="thoiGianDuKienDenNgayStr"/>');
					</script></td>
				<td><logic:equal name="cuocTTKT" property="loai" value="true">
					<bean:message key="label.dot_xuat" />
				</logic:equal> <logic:equal name="cuocTTKT" property="loai" value="false">
					<bean:message key="label.dinh_ky" />
				</logic:equal></td>
				<td align="left"><bean:write name="cuocTTKT" property="trangThai" /></td>
			</tr>
		</logic:iterate>
		<tr>
			<td colspan="8" align="center"><bean:write name="tableKetQuaTimKiem" property="navigationBar" filter="false" /></td>
		</tr>
	</table>
	</fieldset>
	<BR>
	<TABLE width="30%" align="center">
		<tr align="center">
			<td width="20%" align="center"><INPUT type="button" class="button" value="Đóng" onclick="window.location = 'ttkt_index.do';"></td>
		</tr>
	</TABLE>
	<html:hidden name="TimKiemCuocTtktForm" property="nghiepVu" />
</html:form>
<%@ include file="/bottom.jsp"%>
<script language="javascript">
function openNghiepVu(cuocTtktId){	
	if('cbTienHanh' == document.forms[0].elements['nghiepVu'].value){
		window.location = "chuan_bi_tien_hanh.do?cuocTtktId=" + cuocTtktId;
	}else if('tienhanh' == document.forms[0].elements['nghiepVu'].value){
		window.location = "tien_hanh_ttkt.do?cuocTtktId=" + cuocTtktId;	
	}else if('ketthuc' == document.forms[0].elements['nghiepVu'].value){
		window.location = "ket_thuc_ttkt.do?cuocTtktId=" + cuocTtktId;	
	}else if('timKiem' == document.forms[0].elements['nghiepVu'].value){
		window.location = 'cuoc_ttkt.do?method=view&cuocTtktId=' + cuocTtktId;
	}		
}


var returnId;
var returnName;
function chonTruongDoan(index, gridName){	
	returnId = document.forms[0].elements[gridName + '[' + index + '].col11'];
	returnName = document.forms[0].elements[gridName + '[' + index + '].col12'];
	win = window.open("tim_kiem_canBo.do?method=execute&select=tvd&tenNhanVien=" + returnName.value,"","menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no,height=360,width=600,top=0,left=0");
	win.focus(); 
}
function getTruongDoan(ma, ten){
	returnId.value = ma;
	returnName.value = ten;
}
function getThongTinTruongDoan(id, name){
	document.getElementsByName(returnId)[0].value = id;
	document.getElementsByName(returnName)[0].value = name;
}
function inKeHoachNam(){
}
function getSelectedCuocTtktId(){
	allRadio = document.getElementsByName('cuocTtktFocus');
	for(var i = 0; i< allRadio.length; i++){
		if(allRadio[i].checked)
			return allRadio[i].value;
	}
	return '';
}
var cuocTtktId;
function validateForm(){
	if(!compareDate(document.getElementsByName('tu_ngay')[0], document.getElementsByName('den_ngay')[0]))
		return false;
	if(!compareDate(document.getElementsByName('thoiGianDuKienTuNgay')[0], document.getElementsByName('thoiGianDuKienDenNgay')[0]))
		return false;
		
	return true;
}
function addNew(){
	window.location = 'cuoc_ttkt.do?method=add'; 
}
function copy(){
	cuocTtktId = getSelectedCuocTtktId();
	if(cuocTtktId == null || cuocTtktId == '' ){
		alert('Chưa chọn bản ghi nào!');
		return;
	}
	window.location = 'cuoc_ttkt.do?method=copy&cuocTtktId='+ cuocTtktId;    
}	 

function sua(){ 
	cuocTtktId = getSelectedCuocTtktId();
	if(cuocTtktId == null || cuocTtktId == '' ){
		alert('Chưa chọn bản ghi nào!');
		return;
	}
	window.location = 'cuoc_ttkt.do?method=edit&cuocTtktId='+ cuocTtktId;
}
function viewThisItem(control){
	
	cuocTtktId = control.value;
	document.forms[0].elements['cuocTtktFocus'].value = cuocTtktId;
}
function xoa(){
	cuocTtktId = getSelectedCuocTtktId();
	if(cuocTtktId == null || cuocTtktId == '' ){
		alert('Chưa chọn bản ghi nào!');
		return;
	}
	document.forms[0].action = 'ke_hoach_nam.do?method=delete&cuocTtktId = '+ cuocTtktId;
	document.forms[0].submit();			
}	
var countResult='<%=request.getAttribute("countResult")%>';
</script>