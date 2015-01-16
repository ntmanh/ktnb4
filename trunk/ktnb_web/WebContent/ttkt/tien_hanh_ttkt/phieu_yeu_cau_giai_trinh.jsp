<%@page pageEncoding="UTF-8" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<TABLE width="100%" align="center">
	<TBODY>
		<tr>
			<td style="width: 19%" align="right">Ngày lập phiếu <font color=red>*</font></td>
			<td style="width: 1%"></td>
			<td style="width: 30%" align="left"><html:text styleClass="text" property="ngaylapPhieu" onblur="if(!isDate(this)) return;validateDateRequired(this);"  onkeypress="return formatDate(event, this)">
			</html:text></td>
			<td style="width: 19%" align="right">Nơi lập phiếu <font color=red>*</font></td>
			<td style="width: 1%"></td>
			<td style="width: 30%" align="left"><html:text styleClass="text" property="noiLapPhieu">
			</html:text></td>
		</tr>
		<tr>
			<td colspan="6">
			<fieldset style="margin: 0"><legend>Người giải trình </legend>
			<TABLE align="center" width="100%">
				<TBODY>
					<tr>
						<td style="width: 18%" align="right">Họ và tên <font color=red>*</font></td>
						<td style="width: 1%"></td>
						<td style="width: 31%" align="left"><html:text styleClass="text" property="tenNguoiGT"></html:text></td>
						<td style="width: 20%" align="right">Chức vụ <font color=red>*</font></td>
						<td style="width: 1%"></td>
						<td style="width: 29%" align="left"><html:text styleClass="text" property="cvNguoiLapPhieu" styleId="cvNguoiLapPhieu">
						</html:text></td>
					</tr>
					<tr>
						<td style="width: 18%" align="right">Đơn vị công tác <font color=red>*</font></td>
						<td style="width: 1%"></td>
						<td style="width: 31%" align="left"><html:text styleClass="text" property="dvNguoiGT">
						</html:text></td>
						<td style="width: 20%" align="right">Năm sinh <font color=red>*</font></td>
						<td style="width: 1%"></td>
						<td style="width: 29%" align="left"><html:text styleClass="text" property="nsNguoiGT" onblur="if(!isDate(this)) return;"  onkeypress="return formatDate(event, this)">
						</html:text></td>
					</tr>
					</TBODY>
			</TABLE>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td style="width: 19%" align="right">Qua kiểm tra hồ sơ, tài liệu <font color=red>*</font></td>
			<td style="width: 1%"></td>
			<td colspan="4" align="left"><html:textarea property="hoSoTaiLieuBC" onkeypress="imposeMaxLength(this);"  styleClass="textareaTitle" /></td>
		</tr>
		<tr>
			<td style="width: 19%" align="right">Nội dung giải trình <font color=red>*</font></td>
			<td style="width: 1%"></td>
			<td colspan="4" align="left"><html:textarea property="ndungGT" onkeypress="imposeMaxLength(this);"  styleClass="textareaContent" /></td>
		</tr>
		<tr>
			<td style="width: 19%" align="right">Thời gian gửi giải trình <font color=red>*</font></td>
			<td style="width: 1%"></td>
			<td style="width: 30%" align="left"><html:text styleClass="text" property="ngayGuiGT" onblur="if(!isTime(this)) return;validateDateRequired(this);"  onkeypress="return formatTime(event, this)">
			</html:text></td>
			<td style="width: 19%" align="right">Nơi gửi giải trình <font color=red>*</font></td>
			<td style="width: 1%"></td>
			<td style="width: 30%" align="left"><html:text styleClass="text" property="noiGuiGT"></html:text></td>
		</tr>
		<tr>
			<td colspan="6" align="right"><INPUT type="button" class="button1" value="In phiếu yêu cầu" onclick="inPhieuYeuCau()"></td>
		</tr>
	</TBODY>
</TABLE>
<script language="javascript">
	
function inPhieuYeuCau()
	{
		if(!isRequired(document.getElementsByName('noiLapPhieu')[0]))
			return false;
		if(!isRequired(document.getElementsByName('ngayGuiGT')[0]))
			return false;
		if(!isRequired(document.getElementsByName('noiGuiGT')[0]))
			return false;
		document.forms[0].action = 'yeu_cau_giai_trinh.do?method=in&type=inPhieuYeuCau&idCuocTtkt='+document.getElementsByName('idCuocTtKt')[0].value;
		document.forms[0].submit();
		document.forms[0].action = 'yeu_cau_giai_trinh.do';
	}
	
</script>
