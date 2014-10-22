<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ include file="/top_bar.jsp"%>
<h3 class="Header">QUYẾT ĐỊNH HỦY TẠM ĐÌNH CHỈ KHIẾU NẠI</h3>
<html:form action="kntc_qd_tam_dinh_chi_thi_hanh.do" method="POST"
	enctype="multipart/form-data">
	<html:hidden property="huyDinhChiKn.id"/> 
	<html:hidden property="huyDinhChiKn.soHoSo" styleId="soHs"/>
	<br>
	<fieldset><legend>Thông tin quyết định</legend>
	<table width="100%">
		<tr>
			<td width="24%" align="right">Số quyết định <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%">
				<html:text property="huyDinhChiKn.soQd" styleClass="text"></html:text>
			</td>
			<td width="24%" align="right">Ngày ban hành <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="huyDinhChiKn.ngayBanHanhstr" onblur="if(!isDate(this)) return;" onkeypress="return formatDate(event, this)" styleClass="text"></html:text></td>
		</tr>
		<tr>
			<td width="24%" align="right">Địa điểm <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="huyDinhChiKn.diaDiem" styleClass="text"></html:text></td>
			
		</tr>
		<tr>
			<td align="right" width="24%">Căn cứ văn bản  <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="huyDinhChiKn.vanBanCanCu"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Xét đề nghị của <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="huyDinhChiKn.nguoiDeNghi"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Người ban hành hủy bỏ quyết định tạm đình chỉ <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="huyDinhChiKn.nguoiBhHuyTen" style="width:77%" styleId="nguoiBhHuyTen"></html:text> 
				<input type="button" class="button" name="btnCb" value="..." onclick="showLovCanbo()" size="15%"></<input>
			</td>
			<td width="24%" align="right">Chức vụ <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="huyDinhChiKn.nguoiBhChucVu" styleId="nguoiBhChucVu" styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td align="right" width="19%">Hủy bỏ quyết định<font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="huyDinhChiKn.tenQdHuy"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td align="right" width="19%">Lý do hủy bỏ<font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="huyDinhChiKn.lyDoHuy"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td width="24%" align="right">Người ban hành quyết định hành chính bị khiếu nại <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="huyDinhChiKn.nguoiBhQdHcTen" style="width:77%" styleId="nguoiBhQdHcTen"></html:text> 
				<input type="button" class="button" name="btnCb" value="..." onclick="showLovCanbo()" size="15%"></<input>
			</td>
			<td width="24%" align="right">Chức vụ <font color="red">*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td width="25%"><html:text property="huyDinhChiKn.nguoiBhQdHcCvu" styleId="nguoiBhQdHcCvu" styleClass="text">
			</html:text></td>
		</tr>
		<tr>
			<td align="right" width="19%">Người, tổ chức, đơn vị chịu trách nhiệm thi hành<font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="huyDinhChiKn.donViThiHanh"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td align="right" width="19%">Tên cơ quan, tổ chức, đơn vị, cá nhân có liên quan<font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4" width="80%"><html:textarea property="huyDinhChiKn.donViLienQuan"
				onkeypress="imposeMaxLength(this);" styleClass="textareaTitle"></html:textarea></td>
		</tr>
	</table>
	<%@ include file="../../xldtc/button_execute.jsp" %>
	</fieldset>
</html:form>
<%@ include file="/bottom.jsp"%>
<script type="text/javascript">

function exportDoc()
{
	document.forms[0].action="kntc_qd_tam_dinh_chi_thi_hanh.do?method=show&action=exportDoc&type=huytam";
	document.forms[0].submit();
}
function saveObject()
{
	document.forms[0].action='kntc_qd_tam_dinh_chi_thi_hanh.do?method=show&action=save&type=huytam';
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
		window.location  = 'kntc_qd_tam_dinh_chi_thi_hanh.do?method=show&action=view&type=huytam&id=' + $('#soHs').val();
	</script>
<%}%>