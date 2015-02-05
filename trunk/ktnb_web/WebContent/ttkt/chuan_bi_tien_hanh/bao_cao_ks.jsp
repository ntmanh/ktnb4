<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@page import="cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.form.ChuanBiTienHanhForm"%>
<script type="text/javascript" src="<html:rewrite page='/ttkt/chuan_bi_tien_hanh/webtoolkit.aim.js'/>"></script>
<html:form action="chuan_bi_tien_hanh.do?method=save&type=bcks" method="POST" enctype="multipart/form-data">
	<div id="getReturnBcks" style="display: none;"></div>
	<html:hidden property="maFileBCKS" />
	<html:hidden property="isChangeBCKS" />
	<TABLE width="100%" align="center">
		<logic:notPresent name="readOnly">
			<tr>
				<td align="right" width="49%">Download bi&#7875;u m&#7851;u</td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><A href="#" onclick="downLoadBieuMau()"> <font color=blue>M&#7851;u s&#7889; 03/KTNB</font> </A></td>
			</tr>
			<tr id='fileBaoCaoKhaoSatCu'>
				<td align="right" width="49%">File &#x111;&#xED;nh k&#xE8;m</td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><A href="#" onclick="downLoadBcks()"><font color=blue>B&#225;o c&#225;o kh&#7843;o s&#225;t</font></A></td>
			</tr>
			<tr>
				<td align="right" width="49%" id="labelAttachmentFile"></td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><html:file property="fileBCKS" /></td>
			</tr>
		</logic:notPresent>
		<logic:present name="readOnly">
			<logic:equal name="ChuanBiTienHanhForm" property="maFileBCKS" value=" ">
				<tr>
					<td align="center">Ch&#x1B0;a c&#xF3; b&#xE1;o c&#xE1;o kh&#x1EA3;o s&#xE1;t.</td>
				</tr>
			</logic:equal>
			<logic:notEqual name="ChuanBiTienHanhForm" property="maFileBCKS" value=" ">
				<tr>
					<td align="right" width="49%">File &#x111;&#xED;nh k&#xE8;m</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><A href="#" onclick="downLoadBcks()"><font color=blue>B&#225;o c&#225;o kh&#7843;o s&#225;t</font></A></td>
				</tr>
			</logic:notEqual>
		</logic:present>
	</TABLE>
</html:form>
<logic:notPresent name="readOnly">
	<script language="javascript">
		maFile = document.getElementsByName('maFileBCKS')[0].value;
		if(maFile == null || maFile == ' '){
			document.getElementById('fileBaoCaoKhaoSatCu').style.display = 'none';
			document.getElementById('labelAttachmentFile').innerHTML = 'File &#x111;&#xED;nh k&#xE8;m';
		}	
		else{
			document.getElementById('fileBaoCaoKhaoSatCu').style.display = 'inline';
			document.getElementById('labelAttachmentFile').innerHTML = 'C&#x1EAD;p nh&#x1EAD;t file &#x111;&#xED;nh k&#xE8;m';
		}
	</script>
</logic:notPresent>
<script>
function onLoadBaoCaoKs(){

}
function downLoadBcks(){ 
	downLoadWinDow = window.open('UploadAction.do?method=downLoadFileById&ma_file='+document.getElementsByName('maFileBCKS')[0].value);
	downLoadWinDow.focus();
}
function downLoadBieuMau(){
	//downLoadWinDow = window.open('UploadAction.do?method=downLoadFileById&ma_file=ttnb03');
	//downLoadWinDow.focus();
	var printfForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=bcks');	
	printfForm.action = 'chuan_bi_tien_hanh.do?method=in&type=bcks&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	printfForm.submit();
	printfForm.action = '/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=bcks';      
}    
function validateBaoCaoKhaoSat(){
	if(!isRequired(document.getElementsByName('fileBCKS')[0]))
		return false;
	return true;
}
</script>
