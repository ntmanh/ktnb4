<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="ket_thuc_ttkt.do?method=save&type=ketQua" method="POST" enctype="multipart/form-data">
	<div id="saveKetQua" style="display: none;"></div>
	<table align="center" width="100%">
		<logic:notPresent name="readOnly">
			<tr>
				<td align="right" width="49%">Download bi&#7875;u m&#7851;u</td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><A href="#" onclick="downLoadBieuMau36()"> <font color=blue>M&#7851;u s&#7889; 36/TTNB</font> </A></td>
				<!-- <td align="left" width="49%"><A href="#" onclick="downLoadBieuMau37()"> <font color=blue>M&#7851;u s&#7889; 37/TTNB</font> </A></td> -->
			</tr>
			<tr id='colTitleKq'>
				<td align="right" width="49%">File &#x111;&#xED;nh k&#xE8;m</td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><!-- <A href="#" onclick="downLoadBienBan(document.getElementsByName('idKetQua')[0].value);"><font color=blue>K&#x1EBF;t qu&#x1EA3; Thanh tra Ki&#x1EC3;m tra</font></A> --> <A href="#" onclick="downLoadBienBan(document.getElementsByName('idKetQua')[0].value);"><font
					color=blue>K&#x1EBF;t qu&#x1EA3; Ki&#x1EC3;m tra</font></A></td>
			</tr>
			<tr> 
				<td align="right" width="49%" id="tileFileDinhKemKetQua"></td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><html:file property="fileKetQua" /></td>
			</tr>
		</logic:notPresent>
		<logic:present name="readOnly">
			<logic:equal name="KetThucTtktForm" property="idKetQua" value=" ">
				<tr id='colTitleKq'>
					<td align="center">Ch&#x1B0;a c&#xF3; bi&#xEA;n b&#x1EA3;n t&#x1ED5;ng h&#x1EE3;p.</td>
				</tr>
			</logic:equal>
			<logic:notEqual name="KetThucTtktForm" property="idKetQua" value=" ">
				<tr id='colTitleKq'>
					<td align="right" width="49%">File &#x111;&#xED;nh k&#xE8;m</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><!-- <A href="#" onclick="downLoadBienBan(document.getElementsByName('idKetQua')[0].value);"><font color=blue>K&#x1EBF;t qu&#x1EA3; Thanh tra Ki&#x1EC3;m tra</font></A> --> <A href="#" onclick="downLoadBienBan(document.getElementsByName('idKetQua')[0].value);"><font
						color=blue>K&#x1EBF;t qu&#x1EA3; Ki&#x1EC3;m tra</font></A></td>
				</tr>
			</logic:notEqual>
		</logic:present>
		<tr>
			<td align="right" width="49%">Ng&#xE0;y g&#x1EED;i b&#xE1;o c&#xE1;o k&#x1EBF;t qu&#x1EA3; v&#xE0; d&#x1EF1; th&#x1EA3;o k&#x1EBF;t lu&#x1EAD;n <font color=red>*</font></td>
			<td style="width: 2%; min-width: 5px;"></td>
			<td align="left" width="49%"><html:text onblur="if(!isDate(this)) return; validateNgayBaoCaoKQ()" onkeypress="return formatDate(event, this)" property="ngayGuiBaoCaoKetQuaVaDuThaoKetLuan" styleClass="text">
			</html:text></td>
		</tr>
	</Table>
	<html:hidden property="idKetQua" />
	<INPUT name="ngayTam" type="hidden">
</html:form>
<script language="javascript">
function validateNgayBaoCaoKQ(){
	
	
	caculateDate('ngayKetThuc','ngayTam', thoiHanGuiKetQuaVaDuThaoKL); 
	if(!compareDate(document.getElementsByName('ngayGuiBaoCaoKetQuaVaDuThaoKetLuan')[0], document.getElementsByName('ngayTam')[0], 'Ng\u00E0y g\u1EEDi k\u1EBFt qu\u1EA3 v\u00E0 d\u1EF1 th\u1EA3o k\u1EBFt lu\u1EADn ph\u1EA3i sau ng\u00E0y k\u1EBFt th\u00FAc ' + thoiHanGuiKetQuaVaDuThaoKL + ' ng\u00E0y!'))
	
		return false;
	
}
function downLoadBaoCaoKetQua(){
	   
}
var thoiHanGuiKetQuaVaDuThaoKL;
function onLoadKetQua(){ 
	thoiHanGuiKetQuaVaDuThaoKL = <%=(String)request.getAttribute("thoiHanGuiKetQuaVaDuThaoKL")%>
	maFile = document.getElementsByName('idKetQua')[0].value;
	if(maFile == null || maFile == ''){
		document.getElementById('tileFileDinhKemKetQua').innerHTML = 'File &#x111;&#xED;nh k&#xE8;m <font color=red>*</font>';
		document.getElementById('colTitleKq').style.display = 'none';
		
	}	
	else{
		document.getElementById('tileFileDinhKemKetQua').innerHTML = 'C&#x1EAD;p nh&#x1EAD;t file &#x111;&#xED;nh k&#xE8;m';
		document.getElementById('colTitleKq').style.display = 'inline';
	}
}       
function validateKeQua(){
	if($('[name="idDuThaoKetQua"]')[0].value==""||$('[name="idDuThaoKetQua"]')[0].value==null){
		alert("Ch\u01B0a c\u00F3 d\u1EF1 th\u1EA3o b\u00E1o c\u00E1o k\u1EBFt qu\u1EA3!");
		return false;
	}
	if(isEmpty(document.getElementsByName('idKetQua')[0].value)){
		if(!isRequired(document.getElementsByName('fileKetQua')[0])) 
			return false;
		
	}
	if(!isRequired(document.getElementsByName('ngayGuiBaoCaoKetQuaVaDuThaoKetLuan')[0]))
			return false;
	if(d2n(document.getElementsByName('ngayGuiBaoCaoKetQuaVaDuThaoKetLuan')[0].value) < d2n(document.getElementsByName('ngayKetThuc')[0].value)){
		alert('Ng\u00E0y b\u00E1o c\u00E1o k\u1EBFt qu\u1EA3 ph\u1EA3i sau ng\u00E0y k\u1EBFt th\u00FAc l\u00E0m vi\u1EC7c t\u1EA1i \u0111\u01A1n v\u1ECB!');
		document.getElementsByName('ngayGuiBaoCaoKetQuaVaDuThaoKetLuan')[0].focus();
		return false;
	}
	
	return true;
}


</script>
