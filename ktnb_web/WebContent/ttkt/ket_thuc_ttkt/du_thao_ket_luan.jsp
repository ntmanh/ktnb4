<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="ket_thuc_ttkt.do?method=save&type=duThaoKetLuan" method="POST" enctype="multipart/form-data">
	<div id="saveDuThaoKetLuan" style="display: none;"></div>
	<table align="center" width="100%">
		<logic:notPresent name="readOnly">
			<tr>
				<td align="right" width="49%">Download bi&#7875;u m&#7851;u</td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><A href="#" onclick="downLoadBieuMau()"> <font color=blue>M&#7851;u s&#7889; 37/TTNB</font> </A></td>
			</tr>
			<tr id='colTitleDuThaoKL'>
				<td align="right" width="49%">File &#x111;&#xED;nh k&#xE8;m</td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><A href="#" onclick="downLoadBienBan(document.getElementsByName('idDuThaoKetLuan')[0].value);"><font color=blue>D&#x1EF1; th&#x1EA3;o k&#x1EBF;t lu&#xE2;n Thanh tra Ki&#x1EC3;m tra</font></A></td>
			</tr>
			<tr>
				<td align="right" width="49%" id="tileFileDinhKemDuThaoKetLuan"></td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><html:file property="fileDuThaoKetLuan" /></td>
			</tr>
		</logic:notPresent>
		<logic:present name="readOnly">
			<logic:equal name="KetThucTtktForm" property="idDuThaoKetLuan" value="">
				<tr id='colTitleDuThaoKL'>
					<td align="center">Ch&#x1B0;a c&#xF3; bi&#xEA;n b&#x1EA3;n t&#x1ED5;ng h&#x1EE3;p.</td>
				</tr>
			</logic:equal>
			<logic:notEqual name="KetThucTtktForm" property="idDuThaoKetLuan" value=" ">
				<tr id='colTitleDuThaoKL'>
					<td align="right" width="49%">File &#x111;&#xED;nh k&#xE8;m</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><A href="#" onclick="downLoadBienBan(document.getElementsByName('idDuThaoKetLuan')[0].value);"><font color=blue>D&#x1EF1; th&#x1EA3;o k&#x1EBF;t lu&#xE2;n Thanh tra Ki&#x1EC3;m tra</font></A></td>
				</tr>
			</logic:notEqual>
		</logic:present>
	</Table>
	<html:hidden property="idDuThaoKetLuan" />
</html:form>
<script language="javascript">        
function downLoadDuThaoKetLuanTtkt(){
}
function downLoadBieuMauKetLuanTtkt(){
}
function onLoadDuThaoKetLuan(){
	maFile = document.getElementsByName('idDuThaoKetLuan')[0].value;
	if(maFile == null || maFile == ''){
		document.getElementById('tileFileDinhKemDuThaoKetLuan').innerHTML = 'File &#x111;&#xED;nh k&#xE8;m';
		document.getElementById('colTitleDuThaoKL').style.display = 'none';
		
	}	
	else{
		document.getElementById('tileFileDinhKemDuThaoKetLuan').innerHTML = 'C&#x1EAD;p nh&#x1EAD;t file &#x111;&#xED;nh k&#xE8;m';
		document.getElementById('colTitleDuThaoKL').style.display = 'inline';
	}
}
function validateDuThaoKetLuan(){
	if($('[name="idDuThaoKetQua"]')[0].value==""||$('[name="idDuThaoKetQua"]')[0].value==null){
		alert("Ch\u01B0a c\u00F3 d\u1EF1 th\u1EA3o b\u00E1o c\u00E1o k\u1EBFt qu\u1EA3!");
		return false;
		}
	if(!isRequired(document.getElementsByName('fileDuThaoKetLuan')[0]))
			return false;
	return true;
}

function  downLoadBieuMau(){
	//downLoadWinDow = window.open('UploadAction.do?method=downLoadFileById&ma_file=ttnb38');
	//downLoadWinDow.focus();
	var printfForm = findForm('/' + contextRoot + '/ket_thuc_ttkt.do?method=save&type=duThaoKetLuan');	
	printfForm.action = 'ket_thuc_ttkt.do?method=in&type=downloadMau37&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	printfForm.submit();
	printfForm.action = '/' + contextRoot + '/ket_thuc_ttkt.do?method=save&type=duThaoKetLuan'; 
}
</script>
