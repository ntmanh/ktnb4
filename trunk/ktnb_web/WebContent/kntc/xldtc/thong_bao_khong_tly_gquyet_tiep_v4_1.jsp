<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ include file="/top_bar.jsp"%>
<h3 class="Header">THÔNG BÁO KHÔNG THỤ LÝ GIẢI QUYẾT TIẾP - MẪU SỐ
05/TC</h3>
<html:form action="kntc_dxxltc.do" method="POST"
	enctype="multipart/form-data">
	<html:hidden property="tbKhongThuLyTiep.id" />
	<div style="text-align: center; width: 100%"><font
		style="font-size: 14px; color: red">Số hồ sơ</font> <html:text
		property="tbKhongThuLyTiep.soHoSo" styleId="soHs" style="width:250px"
		readonly="true" /></div>
	<div id="super-tabs"><br>
	<fieldset><legend>Thông tin chung</legend>
	<table width="100%">
		<tr>
			<td width="24%" align="right">Địa điểm</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="tbKhongThuLyTiep.diaDiem"
				styleClass="text"></html:text></td>
			<td width="24%" align="right">Ngày lập</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text
				property="tbKhongThuLyTiep.ngayLapStr"
				onblur="if(!isDate(this)) return; validateNgayLapDeCuong()"
				onkeypress="return formatDate(event, this)" style="width:100%">
			</html:text></td>
		</tr>
		<tr>
			<td width="24%" align="right">Số phiếu<font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text
				property="tbKhongThuLyTiep.soThongBao" styleClass="text"></html:text>
			</td>
			<td width="24%" align="right">Cơ quan, tổ chức, đơn vị, chuyển
			đơn tố cáo tiếp</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="2" width="25%"><html:text
				property="tbKhongThuLyTiep.dviChuyenTiepBc" style="width:100%"
				onkeypress="imposeMaxLength(this);" />
			<td width="25%"></td>
		</tr>
		<tr>
			<td align="right" width="24%">Người đã giải quyết theo thẩm
			quyền</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text styleId="nguoiGQ"
				property="tbKhongThuLyTiep.dviBanHanh" style="width:100%" /></td>
			<td colspan="2"><input type="button" class="button" name="btnCb"
				value="..." onclick="showLovCanbo(1)" /></td>
		</tr>
		<tr>
			<td width="24%" align="right">Thông tin văn bản giải quyết tố
			cáo</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:text
				property="tbKhongThuLyTiep.noiDung" style="width:100%"></html:text></td>
		</tr>
		<tr>
			<td width="24%" align="right">Lý do tố cáo tiếp</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea
				property="tbKhongThuLyTiep.lyDo" onkeypress="imposeMaxLength(this);"
				styleClass="textareaTitle" styleClass="textareaTitle"></html:textarea></td>
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
function showLovCanbo(index)
{
		openWindow("danhmuc_canbo.do?method=lov&r=1");	
}
function setData(values){
	var str_val= values.split("@@");	
<!--	if(!test(str_val[0])) return;-->
<!--	document.getElementById('maCanBo'+cRowID).value = str_val[0];	-->
 	document.getElementById('nguoiGQ').value= str_val[1];
}
function KetXuatTb()
{
	document.forms[0].action="kntc_dxxltc.do?method=inTbKoThuLyGqTiep&id="+ $('#soHs').val();
	document.forms[0].submit();
}
</script>
<%
if (request.getAttribute("save") != null) {
%>
<script language="javascript">
		alert('L\u01B0u th\u00E0nh c\u00F4ng');
		window.location  = 'kntc_dxxltc.do?method=show&action=view&type=tbKoGquyetTiep&id=' + $('#soHs').val();
	</script>
<%
}
%>
