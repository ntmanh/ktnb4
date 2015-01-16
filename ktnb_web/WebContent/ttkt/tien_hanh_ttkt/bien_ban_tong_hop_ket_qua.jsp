<%@ page pageEncoding="UTF-8"%>  
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="tien_hanh_ttkt.do?method=save&type=bienBanTongHop" method="POST" enctype="multipart/form-data">
	<div id="saveBbTongHopKqResult" style="display: none;"></div>
	<html:hidden name="TienHanhTtktForm" property="idBbTongHop" />
	<html:hidden name="TienHanhTtktForm" property="tenFile" />

	<TABLE width="100%" align="center">
		<logic:notPresent name="readOnly">
			<tr>
				<td align="right" width="49%">Download biểu mẫu</td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><A href="#" onclick="downLoadBieuMau2()"> <font color=blue>Mẫu số 33/TTNB</font> </A></td>
				<!-- <td align="left" width="49%"><A href="#" onclick="downLoadBieuMau2()"> <font color=blue>Mẫu số 33/TTNB</font> </A></td> -->
			</tr>
			<logic:present name="TienHanhTtktForm" property="idBbTongHop">
				<tr>
					<td align="right" width="49%">File đính kèm</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><A href="#" onclick="downLoadBienBan(document.getElementsByName('idBbTongHop')[0].value);"><font color=blue>Biên bản tổng hợp kết quả</font></A></td>
				</tr>
				<tr>
					<td align="right" width="49%">Cập nhật file đính kèm</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><html:file name="TienHanhTtktForm" property="fileDinhKemBbTongHop" /></td>
				</tr>
			</logic:present>
			<logic:notPresent name="TienHanhTtktForm" property="idBbTongHop">
				<tr>
					<td align="right" width="49%">File đính kèm <font color=red>*</font></td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><html:file name="TienHanhTtktForm" property="fileDinhKemBbTongHop" /></td>
				</tr>
			</logic:notPresent>
		</logic:notPresent>
		<logic:present name="readOnly">
			<logic:notPresent name="TienHanhTtktForm" property="idBbTongHop">
				<tr id='fileBienBanTongHop'>
					<td align="center">Chưa có biên bản tổng hợp.</td>
				</tr>
			</logic:notPresent>
			<logic:present name="TienHanhTtktForm" property="idBbTongHop">
				<tr id='fileBienBanTongHop'>
					<td align="right" width="49%">File đính kèm</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><A href="#" onclick="downLoadBienBan(document.getElementsByName('idBbTongHop')[0].value);"><font color=blue>Biên bản tổng hợp kết quả</font></A></td>
				</tr>
			</logic:present>
		</logic:present>
	</TABLE>
</html:form>
<logic:notPresent name="readOnly">
	<!-- <a href="#" onclick="toChucThongQuaBienBanTongHop();" class="linkCnPhu">Tổ chức thông qua với đơn vị được Thanh tra Kiểm tra</a> -->
	<a href="#" onclick="toChucThongQuaBienBanTongHop();" class="linkCnPhu">Tổ chức thông qua với đơn vị được Kiểm tra</a> |
	<a href="#" onclick="chamThongQuaBbTongHop();" class="linkCnPhu">Chậm thông qua biên bản tổng hợp</a>
</logic:notPresent>
<logic:present name="readOnly">
	<logic:present name="To_chuc_thong_qua">
		<!-- <a href="#" onclick="toChucThongQuaBienBanTongHop();" class="linkCnPhu">Tổ chức thông qua với đơn vị được Thanh tra Kiểm tra</a> -->
		<a href="#" onclick="toChucThongQuaBienBanTongHop();" class="linkCnPhu">Tổ chức thông qua với đơn vị được Kiểm tra</a> |
	</logic:present>
	<logic:present name="Cham_thong_qua">
		<a href="#" onclick="chamThongQuaBbTongHop();" class="linkCnPhu">Chậm thông qua biên bản tổng hợp</a>
	</logic:present>
</logic:present>
<script language="javascript">           
function onLoadBbTongHop(){
	
}
function toChucThongQuaBienBanTongHop(){
	window.open('to_chuc_thong_qua.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value+'&type=tochucthongqua');
	 
}
function chamThongQuaBbTongHop(){
window.open('cham_thong_qua.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value+'&type=chamthongqua');
}
function validateBbTongHop(){
	if(document.getElementsByName('tenFile')[0]==null)
	{
		if(!isRequired(document.getElementsByName('fileDinhKemBbTongHop')[0]))
			return false;
	}
	return true;
}
function downLoadBieuMau2(){
	//downLoadWinDow = window.open('UploadAction.do?method=downLoadFileById&ma_file=ttnb34');
	//downLoadWinDow.focus();
	var printfForm = findForm('/' + contextRoot + '/tien_hanh_ttkt.do?method=save&type=bienBanTongHop');	
	printfForm.action = 'tien_hanh_ttkt.do?method=in&type=downloadMau33&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	printfForm.submit();
	printfForm.action = '/' + contextRoot + '/tien_hanh_ttkt.do?method=save&type=bienBanTongHop';
}
</script>