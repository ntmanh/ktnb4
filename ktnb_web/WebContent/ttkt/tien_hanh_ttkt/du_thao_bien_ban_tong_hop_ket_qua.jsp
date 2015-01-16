<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="tien_hanh_ttkt.do?method=save&type=duThaoBienBanTongHop" method="POST" enctype="multipart/form-data">
	<div id="saveDuThaoBbTongHopKqResult" style="display: none;"></div>
	<html:hidden name="TienHanhTtktForm" property="idDuThaoBbTongHop" />
	<div>
	<TABLE width="100%" align="center">
		<logic:notPresent name="readOnly">
			<tr>
				<td align="right" width="49%">Download biểu mẫu</td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><A href="#" onclick="downLoadBieuMau1()"> <font color=blue>Mẫu số 33/TTNB</font> </A></td>
				<!-- <td align="left" width="49%"><A href="#" onclick="downLoadBieuMau1()"> <font color=blue>Mẫu số 34/TTNB</font> </A></td> -->
			</tr>
			<logic:present name="TienHanhTtktForm" property="idDuThaoBbTongHop">
				<tr>
					<td align="right" width="49%">File đính kèm</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><A href="#" onclick="downLoadBienBan(document.getElementsByName('idDuThaoBbTongHop')[0].value);"><font color=blue>Dự thảo biên bản tổng hợp kết quả</font></A></td>
				</tr>
				<tr>
					<td align="right" width="49%">Cập nhật file đính kèm</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><html:file name="TienHanhTtktForm" property="fileDinhKemDuThaoBbTongHop" /></td>
				</tr>
			</logic:present>
			<logic:notPresent name="TienHanhTtktForm" property="idDuThaoBbTongHop">
				<tr>
					<td align="right" width="49%">File đính kèm</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><html:file name="TienHanhTtktForm" property="fileDinhKemDuThaoBbTongHop" /></td>
				</tr>
			</logic:notPresent>
		</logic:notPresent>
		<logic:present name="readOnly">
			<logic:present name="TienHanhTtktForm" property="idDuThaoBbTongHop">
				<tr id='fileDuThaoBienBanTongHop'>
					<td align="right" width="49%">File đính kèm</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><A href="#" onclick="downLoadBienBan(document.getElementsByName('idDuThaoBbTongHop')[0].value);"><font color=blue>Dự thảo biên bản tổng hợp kết quả</font></A></td>
				</tr>
			</logic:present>
			<logic:notPresent name="TienHanhTtktForm" property="idDuThaoBbTongHop">
				<tr>
					<td align="center">Chưa có dự thảo biên bản tổng hợp.</td>
				</tr>
			</logic:notPresent>
		</logic:present>
	</TABLE>
	</div>
</html:form>
<logic:notPresent name="readOnly">
	<a href="#" onclick="yKienDongGopCuaTvdVeDuThao();" class="linkCnPhu">Ý kiến của thành viên đoàn về dự thảo biên bản tổng hợp kết quả</a>
</logic:notPresent>
<logic:present name="readOnly">
	<logic:present name="y_kien_thanh_vien_doan">
		<a href="#" onclick="yKienDongGopCuaTvdVeDuThao();" class="linkCnPhu">Ý kiến của thành viên đoàn về dự thảo biên bản tổng hợp kết quả</a>
	</logic:present>
</logic:present>   
<script language="javascript"> 
function onLoadDuThaoBbTongHop(){
	
}

function yKienDongGopCuaTvdVeDuThao(){
	window.open('y_kien_tvd.do?cuocTtktId=' + document.getElementsByName('idCuocTtkt')[0].value);
	//window.open('th_bbth_dt_y_kien_tvd.do?method=tienHanhHopDoan&id=' + document.getElementsByName('idCuocTtkt')[0].value);
}
function validateBbTongHop(){
	return true;
}
function validateDuThaoBbTongHop(){
	if(!isRequired(document.getElementsByName('fileDinhKemDuThaoBbTongHop')[0])){
			return false;
			}
	return true;
}
function downLoadBieuMau1(){
	//downLoadWinDow = window.open('UploadAction.do?method=downLoadFileById&ma_file=ttnb34');
	//downLoadWinDow.focus();
	var printfForm = findForm('/' + contextRoot + '/tien_hanh_ttkt.do?method=save&type=duThaoBienBanTongHop');	
	printfForm.action = 'tien_hanh_ttkt.do?method=in&type=downloadMau33&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	printfForm.submit();
	printfForm.action = '/' + contextRoot + '/tien_hanh_ttkt.do?method=save&type=duThaoBienBanTongHop';
}
</script>