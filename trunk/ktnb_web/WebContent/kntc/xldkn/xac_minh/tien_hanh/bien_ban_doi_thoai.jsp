<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ include file="/top_bar.jsp"%>
<h3 class="Header">BIÊN BẢN ĐỐI THOẠI</h3>
<html:form action="kntc_xm_bb_doi_thoai.do" method="POST"
	enctype="multipart/form-data">
	<html:hidden property="bbDoiThoai.id"/> 
	<div style="text-align: center; width: 100%"><font
		style="font-size: 14px; color: red"> Số Quyết định</font> <html:text
		property="bbDoiThoai.soQD" styleClass="text" style="width:250px"
		readonly="true" /></div>
	<br>
	<table width="100%">
		<tr>
			<td width="24%" align="right">Địa điểm <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="bbDoiThoai.diaDiem" styleClass="text">
			</html:text></td>
			<td width="24%" align="right">Thời gian bắt đầu <font
				color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%" align="left"><html:text
				onblur="isTime(this)" onkeypress="return formatTime(event, this)" property="bbDoiThoai.thoiGianBatDauStr"
				styleClass="text">
			</html:text></td>
		</tr>
	</table>
	<fieldset><legend>Người giải quyết khiếu nại hoặc
	người có trách nhiệm xác minh</legend>
	<table width="100%">
		<tr>
			<td width="24%" align="right">Ông/bà <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="bbDoiThoai.nguoiGqTen"style="width:77%"></html:text> 
				<input type="button" class="button" name="btnCb" value="..." onclick="showLovCanbo()" size="15%"></<input>
			</td>
			<td width="24%" align="right">Chức vụ <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="bbDoiThoai.nguoiGqChucVu"
				styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td width="24%" align="right">Cơ quan, tổ chức đơn vị <font
				color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="bbDoiThoai.nguoiGqCoQuan"
				styleClass="text">
			</html:text></td>
		</tr>
	</table>
	</fieldset>
	<fieldset><legend>Người ghi biên bản</legend>
	<table width="100%">
		<tr>
			<td width="24%" align="right">Ông/bà <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="bbDoiThoai.nguoiGhiBbTen"
				styleClass="text">
			</html:text></td>
			<td width="24%" align="right">Chức vụ <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="bbDoiThoai.nguoiGhiBbChucVu"
				styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td width="24%" align="right">Cơ quan, tổ chức đơn vị <font
				color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="bbDoiThoai.nguoiGhiBbCoQuan"
				styleClass="text">
			</html:text></td>
		</tr>
	</table>
	</fieldset>
	<fieldset><legend>Người có quyền, nghĩa vụ liên
	quan</legend>
	<table width="100%">
		<tr>
			<td width="24%" align="right">Ông/bà <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="bbDoiThoai.nguoiLqTen"
				styleClass="text">
			</html:text></td>
			<td width="24%" align="right">Số CMTD/Hộ chiếu <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="bbDoiThoai.nguoiLqCmt"
				styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td width="24%" align="right">Nơi cấp <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="bbDoiThoai.nguoiLqCmtNoiCap"
				styleClass="text">
			</html:text></td>
			<td width="24%" align="right">Ngày cấp <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="bbDoiThoai.nguoiLqCmtNgayStr" onblur="if(!isDate(this)) return; validateNgayLapDeCuong()" onkeypress="return formatDate(event, this)"
				styleClass="text">
			</html:text></td>
		</tr>
	</table>
	</fieldset>
	<fieldset><legend>Đại diện cơ quan, tổ chức, cá
	nhân có liên quan</legend>
	<table width="100%">
		<tr>
			<td width="24%" align="right">Ông/bà <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="bbDoiThoai.daiDienTen"
				styleClass="text">
			</html:text></td>
			<td width="24%" align="right">Địa chỉ <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="bbDoiThoai.daiDienDiaChi"
				styleClass="text">
			</html:text></td>
		</tr>
	</table>
	</fieldset>
	<table align="center" width="100%">
		<tr>
			<td align="right" width="19%">Nội dung đối thoại <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="bbDoiThoai.noiDung"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td align="right" width="19%">Kết quả đối thoại <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="bbDoiThoai.ketQua"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Thời gian kết thúc <font
				color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="bbDoiThoai.thoiGianKetThucStr" onblur="isTime(this)" onkeypress="return formatTime(event, this)"
				styleClass="text">
			</html:text></td>
		</tr>
		<%@ include file="../../../xldtc/button_execute.jsp"%>
	</table>
</html:form>
<%@ include file="/bottom.jsp"%>
<script type="text/javascript">

function exportDoc()
{
	document.forms[0].action="kntc_xm_bb_doi_thoai.do?method=show&action=exportDoc";
	document.forms[0].submit();
}
function saveObject()
{
	document.forms[0].action='kntc_xm_bb_doi_thoai.do?method=show&action=save';
	document.forms[0].submit();
}
function showLovCanbo()
{
		openWindow("danhmuc_canbo.do?method=lov&r=1");
}
function setData(values){
	var str_val= values.split("@@"); 
 	
	 	// document.forms[0].nguoiNhanMa.value = str_val[0];
	 	document.forms[0].nguoiGqTen.value = str_val[1];
	 	document.forms[0].nguoiGqChucVu.value = str_val[2];		
	 	document.forms[0].nguoiGqDonVi.value = str_val[4];	
}

function validateForm(){    
	return true;
}

</script>
<%if(request.getAttribute("save") != null){%>
<script language="javascript">
		alert('L\u01B0u th\u00E0nh c\u00F4ng');
		window.location  = 'kntc_xm_bb_doi_thoai.do?method=show&action=view&id=' + document.getElementsByName('canCuQd')[0].value;
	</script>
<%}%>