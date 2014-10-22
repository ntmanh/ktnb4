<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ include file="/top_bar.jsp"%>
<h3 class="Header">QUYẾT ĐỊNH TẠM ĐÌNH CHỈ KHIẾU NẠI</h3>
<html:form action="kntc_qd_tam_dinh_chi_thi_hanh.do" method="POST"
	enctype="multipart/form-data">
	<html:hidden property="tamDinhChiKn.id"/> 
	<html:hidden property="tamDinhChiKn.soHs" styleId="soHs"/>
	<br>
	<fieldset><legend>Thông tin quyết định</legend>
	<table width="100%">
		<tr>
			<td width="24%" align="right">Số quyết định <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%">
				<html:text property="tamDinhChiKn.soQd" styleClass="text"></html:text>
			</td>
			<td width="24%" align="right">Ngày ban hành <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="tamDinhChiKn.ngayBanHanhstr" onblur="if(!isDate(this)) return;" onkeypress="return formatDate(event, this)" styleClass="text"></html:text></td>
		</tr>
		<tr>
			<td width="24%" align="right">Địa điểm <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="tamDinhChiKn.diaDiem" styleClass="text"></html:text></td>
			
		</tr>
		<tr>
			<td align="right" width="24%">Căn cứ văn bản  <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%">
				<html:select property="tamDinhChiKn.canCuVanBan" style="width:100%" styleId="loaiKNTC" onchange="changeKNTC()">
					<html:option value="1">Căn cứ văn bản luật KNTC</html:option>
					<html:option value="2">Căn cứ văn bản hành chính KNTC</html:option>
				</html:select>
			</td>
		</tr>
		<tr>
			<td width="24%" align="right">Xét đề nghị của <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="tamDinhChiKn.nguoiDeNghi"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Người ban hành quyết định <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="tamDinhChiKn.nguoiBhQdTen" style="width:77%" styleId="nguoiBhQdTen"></html:text> 
				<input type="button" class="button" name="btnCb" value="..." onclick="showLovCanbo()" size="15%"></<input>
			</td>
			<td width="24%" align="right">Chức vụ <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="tamDinhChiKn.nguoiBhQdChucVu" styleId="nguoiBhQdChucVu" styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td align="right" width="19%">Tạm đình chỉ việc thi hành quyết định<font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="tamDinhChiKn.qdDinhChiTen"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td align="right" width="19%">Lý do đình chỉ<font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="tamDinhChiKn.lyDo"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td align="right" width="19%">Tên cơ quan, tổ chức, đơn vị ban hành quyết định<font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="tamDinhChiKn.donViBhQd"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td align="right" width="19%">Cơ quan, tổ chức, đơn vị có trách nhiệm thi hành quyết định<font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="tamDinhChiKn.donViThiHanh"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td align="right" width="19%">Tên cơ quan, tổ chức, đơn vị, cá nhân có liên quan<font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="tamDinhChiKn.donViLienQuan"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<%@ include file="../../xldtc/button_execute.jsp" %>
	</table>
	</fieldset>
</html:form>
<%@ include file="/bottom.jsp"%>
<script type="text/javascript">
function exportDoc()
{
	document.forms[0].action="kntc_qd_tam_dinh_chi_thi_hanh.do?method=exportDoc&type=tam";
	document.forms[0].submit();
}
function saveObject()
{
	document.forms[0].action='kntc_qd_tam_dinh_chi_thi_hanh.do?method=show&action=save&type=tam';
	document.forms[0].submit();
}
function showLovCanbo()
{
		openWindow("danhmuc_canbo.do?method=lov&r=1");
}
function setData(values){
	var str_val= values.split("@@"); 
 	
	 	// document.forms[0].nguoiNhanMa.value = str_val[0];		
	 	$('#nguoiBhQdTen').val(str_val[1]);
	 	$('#nguoiBhQdChucVu').val(str_val[2]);
}
function validateForm(){    
	return true;
}

</script>
<%if(request.getAttribute("save") != null){%>
<script language="javascript">
		alert('L\u01B0u th\u00E0nh c\u00F4ng');
		window.location  = 'kntc_qd_tam_dinh_chi_thi_hanh.do?method=show&action=view&type=tam&id=' + $('#soHs').val();
	</script>
<%}%>
