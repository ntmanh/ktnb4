<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="ket_thuc_ttkt.do?method=save&type=duThaoKetQua" method="POST" enctype="multipart/form-data">
	<div id="saveDuThaoKetQua" style="display: none;"></div>
	<table align="center" width="100%">
		<logic:notPresent name="readOnly">
			<tr>
				<td align="right" width="49%">Download bi&#7875;u m&#7851;u</td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><A href="#" onclick="downLoadBieuMau36()"> <font color=blue>M&#7851;u s&#7889; 36/TTNB</font> </A></td>
				<!-- <td align="left" width="49%"><A href="#" onclick="downLoadBieuMau37()"> <font color=blue>M&#7851;u s&#7889; 37/TTNB</font> </A></td> -->
			</tr>
			<tr id='colTitleDuThaoKq'>
				<td align="right" width="49%">File &#x111;&#xED;nh k&#xE8;m</td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><A href="#" onclick="downLoadBienBan(document.getElementsByName('idDuThaoKetQua')[0].value);"><font color=blue>D&#x1EF1; th&#x1EA3;o b&#xE1;o c&#xE1;o k&#x1EBF;t qu&#x1EA3;</font></A></td>
			</tr>
			<tr>
				<td align="right" width="49%" id="tileFileDinhKemDuThaoKetQua"></td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><html:file property="fileDuThaoKetQua" /></td>
			</tr>
		</logic:notPresent>
		<logic:present name="readOnly">
			<logic:equal name="KetThucTtktForm" property="idDuThaoKetQua" value=" ">
				<tr id='colTitleDuThaoKq'>
					<td align="center">Ch&#x1B0;a c&#xF3; bi&#xEA;n b&#x1EA3;n t&#x1ED5;ng h&#x1EE3;p.</td>
				</tr>
			</logic:equal>
			<logic:notEqual name="KetThucTtktForm" property="idDuThaoKetQua" value=" ">
				<tr id='colTitleDuThaoKq'>
					<td align="right" width="49%">File &#x111;&#xED;nh k&#xE8;m</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><A href="#" onclick="downLoadBienBan(document.getElementsByName('idDuThaoKetQua')[0].value);"><font color=blue>D&#x1EF1; th&#x1EA3;o b&#xE1;o c&#xE1;o k&#x1EBF;t qu&#x1EA3;</font></A></td>
				</tr>
			</logic:notEqual>
		</logic:present>
	</Table>
	<html:hidden property="idDuThaoKetQua" />
</html:form>
<logic:notPresent name="readOnly">
	<div style="width: 100%"><a href="#" onclick="yKienThanhVienDoanVeDuThaoKetQua();" class="linkCnPhu">&#xDD; ki&#x1EBF;n tham gia c&#x1EE7;a th&#xE0;nh vi&#xEA;n &#x111;o&#xE0;n v&#x1EC1; d&#x1EF1; th&#x1EA3;o k&#x1EBF;t qu&#x1EA3;</a></div>
</logic:notPresent>
<logic:present name="readOnly">
	<logic:present name="Y kien tham gia cua cac thanh vien ve du thao ket qua">
		<div style="width: 100%"><a href="#" onclick="yKienThanhVienDoanVeDuThaoKetQua();" class="linkCnPhu">&#xDD; ki&#x1EBF;n tham gia c&#x1EE7;a th&#xE0;nh vi&#xEA;n &#x111;o&#xE0;n v&#x1EC1; d&#x1EF1; th&#x1EA3;o k&#x1EBF;t qu&#x1EA3;</a></div>
	</logic:present>
</logic:present>
<script language="javascript">

function onLoadDuThaoKetQua(){
	maFile = document.getElementsByName('idDuThaoKetQua')[0].value;
	if(maFile == null || maFile == ''){
		document.getElementById('tileFileDinhKemDuThaoKetQua').innerHTML = 'File &#x111;&#xED;nh k&#xE8;m';
		document.getElementById('colTitleDuThaoKq').style.display = 'none';
		
	}	
	else{
		document.getElementById('tileFileDinhKemDuThaoKetQua').innerHTML = 'C&#x1EAD;p nh&#x1EAD;t file &#x111;&#xED;nh k&#xE8;m';
		document.getElementById('colTitleDuThaoKq').style.display = 'inline';
	}
}
function yKienThanhVienDoanVeDuThaoKetQua(){
	window.open('y_kien_tvd.do?cuocTtktId=' + document.getElementsByName('idCuocTtkt')[0].value);
}
function downLoadBieuMauKetQuaTtkt(){
}
function downLoadDuThaoBaoCaoKetQua(){
}
function validateDuThaoKetQua(){
	if(!isRequired(document.getElementsByName('fileDuThaoKetQua')[0]))
		return false;
	return true;
}      

function downLoadBieuMau36(){
	//downLoadWinDow = window.open('UploadAction.do?method=downLoadFileById&ma_file=ttnb37');
	//downLoadWinDow.focus();
	var printfForm = findForm('/' + contextRoot + '/ket_thuc_ttkt.do?method=save&type=duThaoKetQua');	
	printfForm.action = 'ket_thuc_ttkt.do?method=in&type=downloadMau36&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	printfForm.submit();
	printfForm.action = '/' + contextRoot + '/ket_thuc_ttkt.do?method=save&type=duThaoKetQua'; 
}
</script> 
