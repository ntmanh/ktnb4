<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ include file="/top_bar.jsp"%>
<h3 class="Header">THÔNG BÁO KHÔNG THỤ LÝ GIẢI QUYẾT TỐ CÁO - MẪU SỐ 04/TC</h3>
<html:form action="kntc_dxxltc.do" method="POST"
	enctype="multipart/form-data">
	<html:hidden property="tbKoThuLyGq.id"/>
	<html:hidden property="tbKoThuLyGq.noiDungBcKoThuLy"/>
	<html:hidden property="tbKoThuLyGq.dviBanHanh"/>
	<div style="text-align: center; width: 100%"><font
		style="font-size: 14px; color: red">Số hồ sơ</font> <html:text
		property="tbKoThuLyGq.soHoSo" styleId="soHs" style="width:250px" readonly="true" /></div>
	<div id="super-tabs">
	<br>
	<fieldset><legend>Thông tin quyết định</legend>
	<table width="100%">
		<tr>
			<td width="24%" align="right">Địa điểm <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%">
				<html:text property="tbKoThuLyGq.diaDiem" styleClass="text"></html:text>
			</td>
			<td width="24%" align="right">Ngày lập <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="tbKoThuLyGq.ngayLapStr" onblur="if(!isDate(this)) return; validateNgayLapDeCuong()" onkeypress="return formatDate(event, this)"
				styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td width="24%" align="right">Số phiếu <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%">
				<html:text property="tbKoThuLyGq.soThongBao" styleClass="text"></html:text></td>
			<td width="24%" align="right">Cơ quan, tổ chức, đơn vị, chuyển đơn đến</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:textarea property="tbKoThuLyGq.donViChuyenBc"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Lý do không thụ lý giải quyết<font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="tbKoThuLyGq.lyDoApDungKoThuLy"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<%@ include file="button_execute.jsp"%>
	</table>

	</fieldset>
		
</html:form>

<%@ include file="/bottom.jsp"%>
<script type="text/javascript">
function saveObject()
{
	document.forms[0].action='kntc_dxxltc.do?method=show&action=save&type=tbKoThuLyGq';
	document.forms[0].submit();
}
function exportDoc()
{
	document.forms[0].action="kntc_dxxltc.do?method=show&type=tbKoThuLyGq&action=exportDoc";
	document.forms[0].submit();
}
function KetXuatTb()
{
	document.forms[0].action="kntc_dxxltc.do?method=inTbKoThuLyGq&id="+ $('#soHs').val();
	document.forms[0].submit();
}
function validateForm(){    
	return true;
}

</script>
<%if(request.getAttribute("save") != null){%>
<script language="javascript">
		alert('L\u01B0u th\u00E0nh c\u00F4ng');
		window.location  = 'kntc_dxxltc.do?method=show&action=view&type=tbKoThuLyGq&id=' + $('#soHs').val();
	</script>
<%}%>