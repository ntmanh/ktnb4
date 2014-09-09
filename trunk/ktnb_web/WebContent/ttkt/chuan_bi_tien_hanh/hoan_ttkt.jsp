<%@page pageEncoding="UTF-8" %>
<%@ include file="/top_bar.jsp"%>
<h3 class="Header">Hoãn Kiểm Tra</h3>
<!-- <h3 class="Header">Hoãn Thanh Tra Kiểm Tra</h3> -->
<script language="javascript">
	function selfClose(){
		window.close();
	}
</script>
<html:form action="hoan_ttkt.do" method="POST" enctype="multipart/form-data">
	<fieldset><legend> Thông tin hoãn </legend> <html:hidden property="id" /> <html:hidden property="idCuocTtKt" /> <html:hidden property="trangThai" /> <html:hidden property="idVbHoan" /> <html:hidden property="cqtDeNghi" /> <html:hidden property="idVbTraLoi" /> <html:hidden
		property="idVbThongBaoHoan" />
	<TABLE width="100%" align="center">
		<TBODY>
			<tr>
				<td colspan="6">
				<fieldset style="padding: 10px"><legend>Đơn vị hoãn </legend>
				<TABLE width="100%" align="center">
					<tr>
						<td align="center"><!-- <html:radio property="cqtDeNghi" value="true" onclick="donViTienHanhDeNghi(true)">Đơn vị tiến hành TTKT</html:radio> --> <html:radio property="cqtDeNghi" value="true" onclick="donViTienHanhDeNghi(true)">Đơn vị tiến hành Kiểm Tra</html:radio>
						</td>
						<td align="center"><!-- <html:radio property="cqtDeNghi" value="false" onclick="donViTienHanhDeNghi(false)">Đơn vị được TTKT</html:radio> --> <html:radio property="cqtDeNghi" value="false" onclick="donViTienHanhDeNghi(false)">Đơn vị được Kiểm Tra</html:radio>
						</td>
					</tr>
				</TABLE>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td width="19%" align="right">Ngày hoãn <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text styleClass="text" property="ngayHoan" onblur="isDate(this)" onkeypress="formatDate(event, this)"></html:text></td>
				<td width="19%" align="right">Ngày dự kiến bắt đầu lại <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text styleClass="text" property="ngayBatDauLai" onblur="if(!isDate(this)) return; document.getElementsByName('ngayBatDauThucTe')[0].value = this.value;" onkeypress="formatDate(event, this)"></html:text></td>
			</tr>
			<tr>
				<td align="right">Lý do hoãn <font color=red>*</font></td>
				<td></td>
				<td colspan="4" align="left"><html:textarea styleClass="textareaContent" onkeypress="imposeMaxLength(this);"  property="lyDoHoan" style="height: 70px;width: 100%"/></td>
			</tr>
			<tr id="trThongBaoHoan">
				<td colspan="6">
				<fieldset style="width: 100%"><legend> Công văn thông báo hoãn </legend>
				<TABLE width="100%">
					<logic:present name="readOnly">
						<logic:present name="HoanThanhTraKiemTraForm" property="idVbThongBaoHoan">
							<tr>
								<td align="right" width="49%">File đính kèm</td>
								<td width="2%"></td>
								<td align="left" width="49%"><A href="#" onclick="downLoadThongBaoHoan()">Công văn thông báo hoãn</A></td>
							</tr>
						</logic:present>
						<logic:notPresent name="HoanThanhTraKiemTraForm" property="idVbThongBaoHoan">
							<tr>
								<td colspan="3"><A href="#">Chưa có file đính kèm</A></td>
							</tr>
						</logic:notPresent>
					</logic:present>
					<logic:notPresent name="readOnly">
						<logic:present name="HoanThanhTraKiemTraForm" property="idVbThongBaoHoan">
							<tr>
								<td align="right" width="49%">File đính kèm</td>
								<td width="2%"></td>
								<td align="left" width="49%"><A href="#" onclick="downLoadThongBaoHoan()">Công văn thông báo hoãn</A></td>
							</tr>
							<tr>
								<td align="right">Cập nhật file đính kèm <font color=red>*</font></td>
								<td></td>
								<td align="left"><html:file property="vbThongBaoHoan"></html:file></td>
							</tr>
						</logic:present>
						<logic:notPresent name="HoanThanhTraKiemTraForm" property="idVbThongBaoHoan">
							<tr>
								<td align="right" width="49%">File đính kèm <font color=red>*</font></td>
								<td width="2%"></td>
								<td align="left" width="49%"><html:file property="vbThongBaoHoan"></html:file></td>
							</tr>
						</logic:notPresent>
					</logic:notPresent>
				</TABLE>
				</fieldset>
				</td>
			</tr>
			<tr id="trVanBanXinHoan">
				<td colspan="6">
				<fieldset style="width: 100%"><legend> <!-- Văn bản xin hoãn của đơn vị được Thanh tra Kiểm tra --> Văn bản xin hoãn của đơn vị được
				Kiểm tra </legend>
				<TABLE width="100%">
					<logic:present name="readOnly">
						<logic:present name="HoanThanhTraKiemTraForm" property="idVbHoan">
							<tr>
								<td align="right" width="49%">File đính kèm</td>
								<td width="2%"></td>
								<td align="left" width="49%"><A href="#" onclick="downLoadVanBanXinHoan()">Văn bản xin hoãn</A></td>
							</tr>
						</logic:present>
						<logic:notPresent name="HoanThanhTraKiemTraForm" property="idVbHoan">
							<tr>
								<td colspan="3"><A href="#">Chưa có file đính kèm</A></td>
							</tr>
						</logic:notPresent>
					</logic:present>
					<logic:notPresent name="readOnly">
						<logic:present name="HoanThanhTraKiemTraForm" property="idVbHoan">
							<tr>
								<td align="right" width="49%">File đính kèm</td>
								<td width="2%"></td>
								<td align="left" width="49%"><A href="#" onclick="downLoadVanBanXinHoan()">Văn bản xin hoãn</A></td>
							</tr>
							<tr>
								<td align="right">Cập nhật file đính kèm <font color=red>*</font></td>
								<td></td>
								<td align="left"><html:file property="vbXinHoanCuaDvDuocTtKt"></html:file></td>
							</tr>
						</logic:present>
						<logic:notPresent name="HoanThanhTraKiemTraForm" property="idVbHoan">
							<tr>
								<td align="right" width="49%">File đính kèm <font color=red>*</font></td>
								<td width="2%"></td>
								<td align="left" width="49%"><html:file property="vbXinHoanCuaDvDuocTtKt"></html:file></td>
							</tr>
						</logic:notPresent>
					</logic:notPresent>
				</TABLE>
				</fieldset>
				</td>
			</tr>
			<tr id="trVanBanTraLoi">
				<td colspan="6">
				<fieldset style="width: 100%"><legend> Văn bản trả lời hoãn của đơn vị tiến hành </legend>
				<TABLE width="100%">
					<logic:present name="readOnly">
						<logic:present name="HoanThanhTraKiemTraForm" property="idVbTraLoi">
							<tr>
								<td align="right" width="49%">File đính kèm</td>
								<td width="2%"></td>
								<td align="left" width="49%"><A href="#" onclick="downLoadVanBanTraLoiHoan()">Văn bản trả lời hoãn</A></td>
							</tr>
						</logic:present>
						<logic:notPresent name="HoanThanhTraKiemTraForm" property="idVbTraLoi">
							<tr>
								<td colspan="3"><A href="#">Chưa có file đính kèm</A></td>
							</tr>
						</logic:notPresent>
					</logic:present>
					<logic:notPresent name="readOnly">
						<logic:present name="HoanThanhTraKiemTraForm" property="idVbTraLoi">
							<tr>
								<td align="right" width="49%">File đính kèm</td>
								<td width="2%"></td>
								<td align="left" width="49%"><A href="#" onclick="downLoadVanBanTraLoiHoan()"> <LABEL id="file_thong_bao_hoan">Văn bản trả lời hoãn</LABEL> </A></td>
							</tr>
							<tr>
								<td align="right">Cập nhật file đính kèm <font color=red>*</font></td>
								<td></td>
								<td><html:file property="vbTraLoiCuaDvTh"></html:file></td>
							</tr>
						</logic:present>
						<logic:notPresent name="HoanThanhTraKiemTraForm" property="idVbTraLoi">
							<tr>
								<td align="right" width="49%">File đính kèm <font color=red>*</font></td>
								<td width="2%"></td>
								<td align="left" width="49%"><html:file property="vbTraLoiCuaDvTh"></html:file></td>
							</tr>
						</logic:notPresent>
					</logic:notPresent>
				</TABLE>
				</fieldset>
				</td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
	<fieldset><legend> Thông tin bắt đầu lại </legend>
	<TABLE width="100%" border="0">
		<tr>
			<td width="19%" align="right">Ngày bắt đầu lại <font color=red>*</font></td>
			<td width="1%"></td>
			<td width="30%" align="left"><html:text styleClass="text" onblur="isDate(this)" onkeypress="formatDate(event, this)" property="ngayBatDauThucTe"></html:text></td>
			<td width="19%" align="right"></td>
			<td width="1%"></td>
			<td width="30%" align="left"></td>
		</tr>
	</TABLE>
	</fieldset>
</html:form>
<div style="text-align: center;"><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></div>
<%@ include file="/bottom.jsp"%>
<script language="javascript">

window.onload = function(){
	if(document.getElementsByName('cqtDeNghi')[0].value == 'true')
		donViTienHanhDeNghi(true);
	else
		donViTienHanhDeNghi(false);
}
function donViTienHanhDeNghi(bDonViThDeNghi){
	if(bDonViThDeNghi){		
		$("#trThongBaoHoan").css("display","inline"); 		
		$("#trVanBanTraLoi").css("display","none"); 
		$("#trVanBanXinHoan").css("display","none"); 
		document.getElementsByName('cqtDeNghi')[0].value = "true";
		
		
	}else{
		$("#trThongBaoHoan").css("display","none"); 		
		$("#trVanBanTraLoi").css("display","inline"); 
		$("#trVanBanXinHoan").css("display","inline");		
		document.getElementsByName('cqtDeNghi')[0].value = "false";
	}
}
function downLoadVanBanXinHoan(){
	window.open('UploadAction.do?method=downLoadVbXinHoan&idCuocTtKt='+document.getElementsByName('idCuocTtKt')[0].value).focus();
}
function downLoadVanBanTraLoiHoan(){
	window.open('UploadAction.do?method=downLoadVbTraLoiHoan&idCuocTtKt='+document.getElementsByName('idCuocTtKt')[0].value).focus();
}
function downLoadThongBaoHoan(){
	window.open('UploadAction.do?method=downLoadVbThongBaoHoan&idCuocTtKt='+document.getElementsByName('idCuocTtKt')[0].value).focus();
}
function validateForm(){
	if(!isRequired(document.getElementsByName('ngayHoan')[0]))
		return false;
	if(!isRequired(document.getElementsByName('ngayBatDauLai')[0]))
		return false;
	if(!compareDate(document.getElementsByName('ngayHoan')[0], document.getElementsByName('ngayBatDauLai')[0], 'Ngày bắt đầu lại phải sau ngày hoãn!'))
		return false;
	if(!isRequired(document.getElementsByName('lyDoHoan')[0]))
		return false;
	if(document.getElementsByName('cqtDeNghi')[0].value == "false"){
		if(!isRequired(document.getElementsByName('vbXinHoanCuaDvDuocTtKt')[0]))
			return false;
		if(!isRequired(document.getElementsByName('vbTraLoiCuaDvTh')[0]))
			return false;
	}else{
		if(!isRequired(document.getElementsByName('vbThongBaoHoan')[0]))
			return false;
	}
	if(!isRequired(document.getElementsByName('ngayBatDauThucTe')[0]))
		return false;	
	if(!compareDate(document.getElementsByName('ngayHoan')[0], document.getElementsByName('ngayBatDauThucTe')[0], 'Ngày bắt đầu lại thực tế phải sau ngày hoãn!'))
		return false;
	return true;
}
</script>

