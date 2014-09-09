<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="ket_thuc_ttkt.do?method=save&type=thongBaoKetThuc">
	<TABLE width="100%">
		<tr>
			<td width="19%" align="right">Nơi ra thông báo <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="30%"><html:text styleClass="text" property="noiRaThongBaoKetThuc" /></td>
			<td width="19%" align="right">Ngày ra thông báo <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="30%"><html:text styleClass="text" property="ngayRaThongBaoKetThuc" onblur="if(!isDate(this)) return; validateNgayThongBao();" onkeypress="return formatDate(event, this)">
			</html:text></td>
		</tr>
		<tr>
			<td width="19%" align="right">Ngày kết thúc <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="30%"><html:text styleClass="text" property="ngayKetThuc" onblur="if(!isDate(this)) return; validateNgayKetThuc();" onkeypress="return formatDate(event, this)"/></td>
			<td width="19%" align="right"></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="30%"><INPUT type="button" class="button1" onclick="inThongBaoKetThuc()" value="In thông báo kết thúc"></td>
		</tr>
	</TABLE>
	<html:hidden property="hanKetThuc" />
</html:form>
<logic:present name="readOnly">
	<logic:present name="to_chuc_thong_bao_ket_thuc">
		<div style="width: 100%"><!-- <a href="#" onclick="toChucLamViecThongBaoKetThuc();" class="linkCnPhu">Tổ chức thông báo kết thúc với đơn vị được Thanh tra Kiểm tra</a> --> <a href="#"
			onclick="toChucLamViecThongBaoKetThuc();" class="linkCnPhu">Tổ chức thông báo kết thúc với đơn vị được Kiểm tra</a></div>
	</logic:present>
</logic:present>
<logic:notPresent name="readOnly">
	<div style="width: 100%"><!-- <a href="#" onclick="toChucLamViecThongBaoKetThuc();" class="linkCnPhu">Tổ chức thông báo kết thúc với đơn vị được Thanh tra Kiểm tra</a> --> <a href="#"
		onclick="toChucLamViecThongBaoKetThuc();" class="linkCnPhu">Tổ chức thông báo kết thúc với đơn vị được Kiểm tra</a></div>
</logic:notPresent>
<script language="javascript">
function validateNgayThongBao(){
	if(!compareDate(ngayCongBo, document.getElementsByName('ngayRaThongBaoKetThuc')[0], 'Ngày ra thông báo phải sau ngày công bố quyết định TTKT!'))
		return false;
	return true;
}
function validateNgayKetThuc(){
	if(d2n(ngayCongBo) > d2n(document.getElementsByName('ngayKetThuc')[0].value)){
		alert('Ngày thông báo kết thúc phải sau ngày công bố quyết định TTKT!');
		document.getElementsByName('ngayKetThuc')[0].focus();
		return false;
	}
	compareDate(document.getElementsByName('ngayKetThuc')[0], document.getElementsByName('hanKetThuc')[0], 'Cảnh báo quá hạn:Ngày kết thúc sau ngày công bố ('+ngayCongBo+') quá ' + thoiHanKt + ' ngày!');
	return true;
}
function inThongBaoKetThuc(){
	if(!validateThongBaoKetThuc())
		return;
	var printfForm = findForm('/' + contextRoot + '/ket_thuc_ttkt.do?method=save&type=thongBaoKetThuc');	
	printfForm.action = 'ket_thuc_ttkt.do?method=in&type=thongBaoKetThuc&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	printfForm.submit();
	printfForm.action = '/' + contextRoot + '/ket_thuc_ttkt.do?method=save&type=thongBaoKetThuc';
}
function toChucLamViecThongBaoKetThuc(){
	window.open('to_chuc_lam_viec_thong_bap_ket_thuc.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value+'&type=thongbaokethtuc');
}
var ngayCongBo;
var thoiHanKt;
function onLoadThongBaoKetThuc(){
	ngayCongBo = '<%=(String)request.getAttribute("ngayCongBo")%>'
	thoiHanKt = '<%=(String)request.getAttribute("thoiHanKt")%>'
}
function validateThongBaoKetThuc(){
	if(!isRequired(document.getElementsByName('noiRaThongBaoKetThuc')[0]))
		return false;
	if(!isRequired(document.getElementsByName('ngayRaThongBaoKetThuc')[0]))
		return false;
	if(!isRequired(document.getElementsByName('ngayKetThuc')[0]))
		return false;
	if(!compareDate( document.getElementsByName('ngayRaThongBaoKetThuc')[0],document.getElementsByName('ngayKetThuc')[0], 'Ngày kết thúc phải sau ngày ra thông báo kết thúc!'))
	return false;
	return true;
}
</script>