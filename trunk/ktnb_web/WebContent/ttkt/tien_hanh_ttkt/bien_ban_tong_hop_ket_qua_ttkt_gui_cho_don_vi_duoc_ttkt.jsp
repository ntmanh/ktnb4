<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="tien_hanh_ttkt.do?method=save&type=bienBanTongHopKetQuaGuiDvDuocTtkt" method="POST" enctype="multipart/form-data">
	<div id="saveBbTongHopKqGuiDvDuocTtktResult" style="display: none;"></div>
	<html:hidden name="TienHanhTtktForm" property="idBbTongHopGuiDonViDuocTtkt" />
	<html:hidden name="TienHanhTtktForm" property="idBbTongHopGuiDonViDuocTtktYk" />
	<TABLE width="100%" align="center">
		<logic:notPresent name="readOnly">
			<tr>
				<td align="right" width="49%">Download biểu mẫu</td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><A href="#" onclick="downLoadBieuMau()"> <font color=blue>Mẫu số 33/TTNB</font> </A></td>
				<!-- <td align="left" width="49%"><A href="#" onclick="downLoadBieuMau()"> <font color=blue>Mẫu số 33/TTNB</font> </A></td> -->
			</tr>
			<logic:present name="TienHanhTtktForm" property="idBbTongHopGuiDonViDuocTtkt">
				<tr>
					<td align="right" width="49%">File đính kèm</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><A href="#" onclick="downLoadBienBan(document.getElementsByName('idBbTongHopGuiDonViDuocTtkt')[0].value);"> <font color=blue>Biên bản tổng hợp kết quả gửi đơn vị
					được Kiểm tra </font> </A></td>
				</tr>
				<tr>
					<td align="right" width="49%">Cập nhật file đính kèm</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><html:file name="TienHanhTtktForm" property="fileDinhKemBbTongHopGuiDonViDuocTtkt" /></td>
				</tr>
			</logic:present>
			<logic:notPresent name="TienHanhTtktForm" property="idBbTongHopGuiDonViDuocTtkt">
				<tr>
					<td align="right" width="49%">File đính kèm</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><html:file name="TienHanhTtktForm" property="fileDinhKemBbTongHopGuiDonViDuocTtkt" /></td>
				</tr>
			</logic:notPresent>
			<tr>
				<td align="right">Đơn vị được Kiểm tra đóng góp ý kiến</td>
				<td></td>
				<td align="left"><html:checkbox name="TienHanhTtktForm" property="dvDuocTtktDongGopYkien" onclick="changeDisplayYkDongGop(this)" value="true">
				</html:checkbox></td>
			</tr>
			<logic:present name="TienHanhTtktForm" property="idBbTongHopGuiDonViDuocTtktYk">
				<tr id="dwYienDongGop">
					<td align="right" width="49%">File đính kèm</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><A href="#" onclick="downLoadBienBan(document.getElementsByName('idBbTongHopGuiDonViDuocTtktYk')[0].value);"> <font color=blue>Ý kiến đóng góp của đơn vị được Kiểm tra </font> </A></td>
				</tr>
				<tr id='capNhatYkDongGop'>
					<td align="right" width="49%">Cập nhật file đính kèm</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><html:file name="TienHanhTtktForm" property="ykienOfDvDcTtKt" /></td>
				</tr>
			</logic:present>
			<logic:notPresent name="TienHanhTtktForm" property="idBbTongHopGuiDonViDuocTtktYk">
				<tr id='ulYkienDongGop'>
					<td align="right" width="49%">File đính kèm</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><html:file name="TienHanhTtktForm" property="ykienOfDvDcTtKt" /></td>
				</tr>
			</logic:notPresent>
		</logic:notPresent>
		<logic:present name="readOnly">
			<logic:notPresent name="TienHanhTtktForm" property="idBbTongHopGuiDonViDuocTtkt">
				<tr>
					<td align="center" colspan="3">Chưa có biên bản tổng hợp.</td>
				</tr>
			</logic:notPresent>
			<logic:present name="TienHanhTtktForm" property="idBbTongHopGuiDonViDuocTtkt">
				<tr>
					<td align="right" width="49%">File đính kèm</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><A href="#" onclick="downLoadBienBan(document.getElementsByName('idBbTongHopGuiDonViDuocTtkt')[0].value);"> <font color=blue>Biên bản tổng hợp kết quả gửi đơn vị
					được Kiểm tra </font> </A></td>
				</tr>
			</logic:present>
			<logic:present name="TienHanhTtktForm" property="idBbTongHopGuiDonViDuocTtktYk">
				<tr>
					<td align="right" width="49%">File đính kèm</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><A href="#" onclick="downLoadBienBan(document.getElementsByName('idBbTongHopGuiDonViDuocTtktYk')[0].value);"> <font color=blue>Ý kiến đóng góp của đơn vị được Kiểm tra </font> </A></td>
				</tr>
			</logic:present>
		</logic:present>
	</TABLE>
</html:form>
<script language="javascript">
function changeDisplayYkDongGop(chkYkDongGop){
	try{
		document.getElementById('dwYienDongGop').style.display = chkYkDongGop.checked?'inline':'none';
	}catch(err){
	}
	try{
		document.getElementById('capNhatYkDongGop').style.display = chkYkDongGop.checked?'inline':'none';
	}catch(err){
	}
	try{
		document.getElementById('ulYkienDongGop').style.display = chkYkDongGop.checked?'inline':'none';
	}catch(err){
	}
}
function onLoadBbTongHopGuiDvDuocTtkt(){
	document.getElementsByName('dvDuocTtktDongGopYkien')[0].onclick();
}
function yKienDongGopCuaDonViVeBbTongHopKq(){
}
function validateBbTongHop(){
	return true;
}
function validateBbTongHopGuiDvDuocTtkt(){	 
	if(isEmpty(document.getElementsByName('idBbTongHopGuiDonViDuocTtkt')[0].value)){
		if(!isRequired(document.getElementsByName('fileDinhKemBbTongHopGuiDonViDuocTtkt')[0]))
			return false;
	}
	if(document.getElementsByName("dvDuocTtktDongGopYkien")[0].checked){
		if(isEmpty(document.getElementsByName('idBbTongHopGuiDonViDuocTtktYk')[0].value)){
			if(!isRequired(document.getElementsByName('ykienOfDvDcTtKt')[0]))
				return false;
		}
	}
	if(isEmpty(document.getElementsByName('fileDinhKemBbTongHopGuiDonViDuocTtkt')[0].value) && document.getElementsByName("dvDuocTtktDongGopYkien")[0].checked && isEmpty(document.getElementsByName('ykienOfDvDcTtKt')[0].value)){		
		alert('Phải nhập biên bản hoặc ý kiến tham gia của đơn vị được Kiểm tra!');
			return false;
	}
	
	return true;
}
function downLoadBieuMau(){
	//downLoadWinDow = window.open('UploadAction.do?method=downLoadFileById&ma_file=ttnb34');
	//downLoadWinDow.focus();
	var printfForm = findForm('/' + contextRoot + '/tien_hanh_ttkt.do?method=save&type=bienBanTongHopKetQuaGuiDvDuocTtkt');	
	printfForm.action = 'tien_hanh_ttkt.do?method=in&type=downloadMau33&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	printfForm.submit();
	printfForm.action = '/' + contextRoot + '/tien_hanh_ttkt.do?method=save&type=bienBanTongHopKetQuaGuiDvDuocTtkt';
}

</script>
