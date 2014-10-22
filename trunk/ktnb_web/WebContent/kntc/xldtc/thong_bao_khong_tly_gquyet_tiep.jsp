<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ include file="/top_bar.jsp"%>
<h3 class="Header">THÔNG BÁO KHÔNG THỤ LÝ GIẢI QUYẾT TIẾP</h3>
<html:form action="kntc_dxxltc.do" method="POST"
	enctype="multipart/form-data">
	<html:hidden property="tbKhongThuLyTiep.id"/> 
	<html:hidden property="tbKhongThuLyTiep.soHoSo" styleId="soHs"/>
	<br>
	<fieldset><legend>Thông tin quyết định</legend>
	<table width="100%">
		<tr>
			<td width="24%" align="right">Số thông báo<font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%">
				<html:text property="tbKhongThuLyTiep.soThongBao" styleClass="text"></html:text>
			</td>
			<td width="24%" align="right">Ngày lập <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="tbKhongThuLyTiep.ngayLapStr" onblur="if(!isDate(this)) return; validateNgayLapDeCuong()" onkeypress="return formatDate(event, this)"
				styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td width="24%" align="right">Địa điểm <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%">
				<html:text property="tbKhongThuLyTiep.diaDiem" styleClass="text"></html:text>
			</td>
		</tr>
		<tr>
			<td align="right" width="24%">Người, tổ chức, cơ quan, đơn vị ban hành thông báo <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="tbKhongThuLyTiep.dviBanHanh"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Nội dung tố cáo tiếp<font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="tbKhongThuLyTiep.noiDung"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Lý do tố cáo tiếp<font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="tbKhongThuLyTiep.lyDo"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Tên cơ quan, tổ chức, đơn vị, cá nhân đã chuyển tố cáo đến người có thẩm quyền giải quyết lại tố cáo <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="tbKhongThuLyTiep.dviChuyenTiepBc"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Người đã giải quyết tố cáo theo thẩm quyền <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="tbKhongThuLyTiep.nguoiGqTheoThamQuyen"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Số bản in<font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="tbKhongThuLyTiep.soBanIn" styleId="soBanIn" styleClass="text">
			</html:text></td>
		</tr>
		<%@ include file="button_execute.jsp"%>
	</table>
	</fieldset>
	
</html:form>

<%@ include file="/bottom.jsp"%>
<script type="text/javascript">
function saveObject()
{
	document.forms[0].action='kntc_dxxltc.do?method=show&action=save&type=tbKoGquyetTiep';
	document.forms[0].submit();
}
function exportDoc()
{
	document.forms[0].action="kntc_dxxltc.do?method=show&action=exportDoc&type=tbKoGquyetTiep";
	document.forms[0].submit();
}
function validateForm(){    
	return true;
}

</script>
<%if(request.getAttribute("save") != null){%>
<script language="javascript">
		alert('L\u01B0u th\u00E0nh c\u00F4ng');
		window.location  = 'kntc_dxxltc.do?method=show&action=view&type=tbKoGquyetTiep&id=' + $('#soHs').val();
	</script>
<%}%>