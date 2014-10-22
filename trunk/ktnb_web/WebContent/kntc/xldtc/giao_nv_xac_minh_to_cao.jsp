<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ include file="/top_bar.jsp"%>
<h3 class="Header">GIAO NHIỆM VỤ XÁC MINH TỐ CÁO</h3>
<html:form action="kntc_dxxltc.do" method="POST"
	enctype="multipart/form-data">
	<html:hidden property="giaoNvXmTc.id"/> 
	<html:hidden property="giaoNvXmTc.soHoSo" styleId="soHs"/>
	<br>
	<fieldset><legend>Thông tin quyết định</legend>
	<table width="100%">
		<tr>
			<td width="24%" align="right">Số quyết định <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%">
				<html:text property="giaoNvXmTc.soQuyetDinh" styleClass="text"></html:text>
			</td>
			<td width="24%" align="right">Ngày ban hành <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="giaoNvXmTc.ngayBanHanhStr" onblur="if(!isDate(this)) return; validateNgayLapDeCuong()" onkeypress="return formatDate(event, this)"
				styleClass="text">
			</html:text></td>
			
		</tr>
		<tr>
			<td width="24%" align="right">Địa điểm <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%">
				<html:text property="giaoNvXmTc.diaDiem" styleClass="text"></html:text>
			</td>
		</tr>
		<tr>
			<td align="right" width="24%">Căn cứ văn bản <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="giaoNvXmTc.canCuVanBan"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td align="right" width="24%">Xét đề nghị của <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="giaoNvXmTc.nguoiDeNghi"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Người ra quyết định <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="giaoNvXmTc.nguoiRaQdTen" style="width:77%" styleId="nguoiRaQdTen" ></html:text> 
				<input type="button" class="button" name="btnCb" value="..." onclick="showLovCanbo('1')" size="15%"></<input>
			</td>
			<td width="24%" align="right">Chức vụ <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="giaoNvXmTc.nguoiRaQdCvu" styleId="nguoiRaQdCvu"
				styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td width="24%" align="right">Nội dung tố cáo được thụ lý<font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="giaoNvXmTc.noiDungDuocThuLy"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Người giải quyết tố cáo <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="giaoNvXmTc.nguoiGqTcTen" styleId="nguoiGqTcTen" style="width:77%"></html:text> 
				<input type="button" class="button" name="btnCb" value="..." onclick="showLovCanbo('2')" size="15%"></<input>
			</td>
			<td width="24%" align="right">Chức vụ <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="giaoNvXmTc.nguoiGqTcChucVu" styleId="nguoiGqTcChucVu"
				styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td align="right" width="24%">Cơ quan, tổ chức, đơn vị được giao xác minh tố cáo <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="giaoNvXmTc.donViDuocGiaoXm"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Nội dung/ yêu cầu khác<font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="giaoNvXmTc.yeuCauKhac"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
	</table>
	</fieldset>
	<fieldset><legend>Thông tin ký duyệt</legend>
	<table width="100%">
		<tr>
			<td width="24%" align="right">Ngày trình trưởng bộ phận ký <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="giaoNvXmTc.ngayTrinhTruongBoPhanKyStr" onblur="if(!isDate(this)) return; validateNgayLapDeCuong()" onkeypress="return formatDate(event, this)"
				styleClass="text">
			</html:text></td>
			<td width="24%" align="right">Ngày trưởng bộ phận ký <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="giaoNvXmTc.ngayTruongBoPhanKyStr" onblur="if(!isDate(this)) return; validateNgayLapDeCuong()" onkeypress="return formatDate(event, this)"
				styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td align="right" width="24%">Ý kiến của trưởng bộ phận <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="giaoNvXmTc.ykienCuaTruongBoPhan"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Ngày trình thủ trưởng duyệt <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%">
				<html:text property="giaoNvXmTc.ngayTrinhThuTruongDuyetStr" styleClass="text" onblur="if(!isDate(this)) return; validateNgayLapDeCuong()" onkeypress="return formatDate(event, this)" ></html:text>
			</td>
			<td width="24%" align="right">Ngày thủ trưởng phê duyệt <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="giaoNvXmTc.ngayThuTruongDuyetStr" onblur="if(!isDate(this)) return; validateNgayLapDeCuong()" onkeypress="return formatDate(event, this)" styleClass="text"></html:text></td>
		</tr>
		<tr>
			<td align="right" width="24%">Ý kiến của thủ trưởng <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="giaoNvXmTc.ykienThuTruong"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<%@ include file="button_execute.jsp"%>
	</table>
	</fieldset>
	
</html:form>

<%@ include file="/bottom.jsp"%>
<script type="text/javascript">
var iType;
function showLovCanbo(index)
{
		iType=index;
		openWindow("danhmuc_canbo.do?method=lov&r=1");
}
function setData(values){
	var str_val= values.split("@@"); 
 	
	 	// document.forms[0].nguoiNhanMa.value = str_val[0];		
	 	$('#nguoiBhQdTen').val(str_val[1]);
	 	$('#nguoiBhQdChucVu').val(str_val[2]);
	 	if(iType=='1')
	 	{
	 		$('#nguoiRaQdTen').val(str_val[1]);
	 		$('#nguoiRaQdCvu').val(str_val[2]);
	 	}
	 	else if(iType=='2')
	 	{
	 		$('#nguoiGqTcTen').val(str_val[1]);
	 		$('#nguoiGqTcChucVu').val(str_val[2]);
	 	}
}
function exportDoc()
{
	document.forms[0].action="kntc_dxxltc.do?method=show&action=exportDoc&type=giaoNhiemVu";
	document.forms[0].submit();
}
function saveObject()
{
	document.forms[0].action='kntc_dxxltc.do?method=show&action=save&type=giaoNhiemVu';
	document.forms[0].submit();
}
function validateForm(){    
	return true;
}

</script>
<%if(request.getAttribute("save") != null){%>
<script language="javascript">
		alert('L\u01B0u th\u00E0nh c\u00F4ng');
		window.location  = 'kntc_dxxltc.do?method=show&action=view&type=giaoNhiemVu&id=' + $('#soHs').val();
	</script>
<%}%>