<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ include file="/top_bar.jsp"%>
<h3 class="Header">BIÊN BẢN NỘI DUNG BÁO CÁO TRỰC TIẾP</h3>
<html:form action="kntc_dxxltc.do" method="POST"
	enctype="multipart/form-data">
	<html:hidden property="tctt.id"/> 
	<html:hidden property="tctt.soHoSo" styleId="soHs"/>
	<br>
	<fieldset><legend>Thông tin quyết định</legend>
	<table width="100%">
		<tr>
			<td width="24%" align="right">Địa điểm <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%">
				<html:text property="tctt.diaDiem" styleClass="text"></html:text>
			</td>
			<td width="24%" align="right">Thời gian bắt đầu <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="tctt.thoiGianBatDauStr" onblur="isTime(this)" onkeypress="return formatTime(event, this)" styleClass="text"></html:text></td>
		</tr>
		<tr>
			<td align="right" width="24%">Các bên liên quan <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="tctt.cacBenLquan"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td align="right" width="24%">Nội dung tố cáo <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="tctt.ndungToCao"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Thông tin tài liệu, bằng chứng do người tố cáo cung cấp<font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="tctt.bangChungCc"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Yêu cầu người tố cáo<font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="tctt.yeuCauNtc"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Thời gian kết thúc <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="tctt.thoiGianKetThucStr" onblur="isTime(this)" onkeypress="return formatTime(event, this)" styleClass="text"></html:text></td>
		</tr>
		<tr>
			<td width="24%" align="right">Số bản in<font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="tctt.soBanIn" styleId="soBanIn" styleClass="text">
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
	document.forms[0].action='kntc_dxxltc.do?method=show&action=save&type=bBanNdung';
	document.forms[0].submit();
}
function exportDoc()
{
	document.forms[0].action="kntc_dxxltc.do?method=show&action=exportDoc&type=bBanNdung";
	document.forms[0].submit();
}
function validateForm(){    
	return true;
}

</script>
<%if(request.getAttribute("save") != null){%>
<script language="javascript">
		alert('L\u01B0u th\u00E0nh c\u00F4ng');
		window.location  = 'kntc_dxxltc.do?method=show&action=view&type=bBanNdung&id=' + $('#soHs').val();
	</script>
<%}%>