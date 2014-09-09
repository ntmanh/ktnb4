<%@page pageEncoding="UTF-8" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<TABLE width="100%" align="center">
	<TBODY>
		<tr>
			<td align="right" style="width: 19%">Thời gian gửi giải trình <font color=red>*</font></td>
			<td style="width: 1%"></td>
			<td style="width: 30%"><html:text styleClass="text" property="tgBCGT" onkeypress="return formatTime(event, this)" onblur="if(!isTime(this))return;validateDateRequired(this);" ></html:text></td>
			<td align="right" style="width: 19%">Địa điểm <font color=red>*</font></td>
			<td style="width: 1%"></td>
			<td style="width: 30%"><html:text styleClass="text" property="diadiemBCGT"></html:text></td>
		</tr>
		<tr>
			<td align="right" style="width: 19%">Nội dung gửi giải trình</td>
			<td style="width: 1%"></td>
			<td colspan="4"><html:textarea styleClass="textareaContent" property="noidungBCGT"></html:textarea></td>
		</tr>
		<logic:present property="id" name="YeuCauGiaiTrinhForm">
		<tr>
			<td align="right" style="width: 19%;"><div style="text-align: right;color:blue; cursor: pointer" onclick="downloadBienBanChiTiet1('<bean:write name="YeuCauGiaiTrinhForm" property="id"/>')">File báo cáo giải trình</div></td>
		</tr>
		</logic:present>
		<tr>
			<td align="right" style="width: 19%">Báo cáo gửi giải trình đính kèm</td>
			<td style="width: 1%"></td>
			<td colspan="3"><html:file property="baoCao"></html:file></td>
			<td align="right"><INPUT class="button1" type="button" value="In báo cáo" onclick="inBaoCaoGT()"></td>
		</tr>
	</TBODY>
</TABLE>
<script language="javascript">
function inBaoCaoGT(){
	if(!isRequired(document.getElementsByName('tgBCGT')[0]))
		return false;
	if(!isRequired(document.getElementsByName('diadiemBCGT')[0]))
		return false;
	document.forms[0].action = 'yeu_cau_giai_trinh.do?method=in&type=inBaoCaoGT&idCuocTtkt='+document.getElementsByName('idCuocTtKt')[0].value;
 	document.forms[0].submit();
 	document.forms[0].action = 'yeu_cau_giai_trinh.do';
}
function downloadBienBanChiTiet1(bbchiTietId){
		downLoadWinDow = window.open('UploadAction.do?method=downLoadYeuCauGiaiTrinh&ma_file='+bbchiTietId);
		downLoadWinDow.focus();
	}
	
</script>