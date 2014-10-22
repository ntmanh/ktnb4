<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ include file="/top_bar.jsp"%>
<h3 class="Header">QUYẾT ĐỊNH ĐÌNH CHỈ KHIẾU NẠI</h3>
<html:form action="kntc_qd_dinh_chi_kn.do" method="POST"
	enctype="multipart/form-data">
	<html:hidden property="qdDinhChiKN.id"/> 
	<html:hidden property="qdDinhChiKN.soHoSo"/>
	<br>
	<fieldset><legend>Thông tin quyết định</legend>
	<table width="100%">
		<tr>
			<td width="24%" align="right">Số quyết định <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="qdDinhChiKN.soQuyetDinh"
				styleClass="text">
			</html:text></td>
			<td width="24%" align="right">Ngày ban hành <font
				color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="qdDinhChiKN.ngayBanHanhStr" onblur="if(!isDate(this)) return; validateNgayLapDeCuong()" onkeypress="return formatDate(event, this)" styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td width="24%" align="right">Địa điểm <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="qdDinhChiKN.diaDiem"
				styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td align="right" width="19%">Xét đề nghị của :  <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="qdDinhChiKN.nguoiDeNghi"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Người ra quyết định đình chỉ <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="qdDinhChiKN.nguoiQdTen"style="width:77%"></html:text> 
				<input type="button" class="button" name="btnCb" value="..." onclick="showLovCanbo()" size="15%"></<input>
			</td>
			<td width="24%" align="right">Chức vụ <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="qdDinhChiKN.nguoiQdChucVu"
				styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td align="right" width="19%">Lý do đình chỉ :  <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="qdDinhChiKN.lyDo"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td align="right" width="19%">Cơ quan, tổ chức, đơn vị, cá nhân có trách nhiệm thi hành quyết định :  <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="qdDinhChiKN.cqThiHanh"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
			<%@ include file="../../xldtc/button_execute.jsp"%>
	</table>
	</fieldset>
	</TABLE>
</html:form>
<%@ include file="/bottom.jsp"%>
<script type="text/javascript">

function exportDoc()
{
	document.forms[0].action='kntc_qd_dinh_chi_kn.do?method=show&action=exportDoc';
	document.forms[0].submit();
}
function saveObject()
{
	document.forms[0].action='kntc_qd_dinh_chi_kn.do?method=show&action=save';
	document.forms[0].submit();
}
function showLovCanbo()
{
		openWindow("danhmuc_canbo.do?method=lov&r=1");
}
function setData(values){
	var str_val= values.split("@@"); 
 	
	 	// document.forms[0].nguoiNhanMa.value = str_val[0];
	 	document.forms[0].nguoiQdTen.value = str_val[1];
	 	document.forms[0].nguoiQdChucVu.value = str_val[2];		
}
function validateForm(){    
	if(!isRequired(document.getElementsByName('ngayPhanCongCuaTd')[0]))
		return false;
	if(!isRequired(document.getElementsByName('tgianThTuNgay')[0]))
		return false;
	if(!isRequired(document.getElementsByName('tgianThDenNgay')[0]))
		return false;
	if(!compareDate(document.getElementsByName('tgianThTuNgay')[0], document.getElementsByName('tgianThDenNgay')[0]))
		return false;
	if(!isRequired(document.getElementsByName('ttktTai')[0]))
		return false;
	if(!isRequired(document.getElementsByName('thoiDiemLapBb')[0]))
		return false;
	if(!isRequired(document.getElementsByName('diaDiemLapBb')[0]))
		return false;
	if(!isRequired(document.getElementsByName('thoiDiemThongQua')[0]))
		return false;
	if(!compareTime(document.getElementsByName('thoiDiemLapBb')[0], document.getElementsByName('thoiDiemThongQua')[0], '<', 'Thời điểm thông qua phải sau thời điểm lập biên bản!'))
		return false;
	if(!isRequired(document.getElementsByName('fileDinhKem')[0]))
		return false;	
	var tgianThDenNgay = d2n(document.getElementsByName('tgianThDenNgay')[0].value);
	var thoiDiemThongQua = d2n(document.getElementsByName('thoiDiemThongQua')[0].value.split(" ")[1]);
	return true;
}

</script>
<%if(request.getAttribute("save") != null){%>
<script language="javascript">
		alert('L\u01B0u th\u00E0nh c\u00F4ng');
		window.location  = 'kntc_qd_dinh_chi_kn.do?method=show&action=view&id=' + document.getElementsByName('canCuQd')[0].value;
	</script>
<%}%>