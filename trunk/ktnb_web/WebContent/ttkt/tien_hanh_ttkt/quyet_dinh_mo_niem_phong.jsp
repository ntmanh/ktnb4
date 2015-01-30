<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<SELECT id="cbDsTvdQdMoNiemPhong" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="dsTvdQdMoNiemPhong" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<html:form action="niem_phong_ho_so_tai_lieu.do?method=save&type=qdMoNiemPhong" method="post">
	<TABLE width="100%" align="center">
		<TBODY>
			<tr>
				<td width="19%" align="right">N&#417;i ra quy&#7871;t &#273;&#7883;nh <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text property="noiRaQDMoNP" styleClass="text"></html:text></td>
				<td width="19%" align="right">Ng&#224;y ra quy&#7871;t &#273;&#7883;nh <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text styleClass="text" property="ngayRaQDMoNP" onblur="isDate(this)" onkeypress="return formatDate(event, this)"></html:text></td>
			</tr>
			<tr>
				<td width="19%" align="right">&#272;&#417;n v&#7883; c&#225; nh&#226;n &#273;&#432;&#7907;c giao b&#7843;o qu&#7843;n <font color=red>*</font></td>
				<td width="1%"></td>
				<td colspan="4" width="25%" align="left"><html:textarea property="donViBaoQuanSauNP" onkeypress="imposeMaxLength(this);"  styleClass="textareaContent" /></td>
			</tr>
			<tr>
				<td width="19%" align="right">C&#x103;n c&#x1EE9; Quy&#x1EBF;t &#x111;&#x1ECB;nh</td>
				<td width="1%"></td>
				<td colspan="4" width="25%" align="left"><html:textarea property="canCuQd" style="width: 100%">C&#x103;n c&#x1EE9; Quy&#x1EBF;t &#x111;&#x1ECB;nh s&#x1ED1; 1722/Q&#x110;-TCT ng&#xE0;y 08 th&#xE1;ng 10 n&#x103;m 2014</html:textarea></td>
			</tr>
			<tr>
				<td colspan="6">
				<fieldset style="margin: 0px;"><legend>Ng&#432;&#7901;i m&#7903; ni&#234;m phong</legend>
				<table width="100%" border="0">
					<tr>
						<td width="18%" align="right">H&#7885; t&#234;n <font color=red>*</font></td>
						<td width="1%"></td>
						<td width="31%" align="left"><html:select property="nguoiMoNP" styleId="nguoiMoNP" onchange="setChucVu(this)" style="width:100%">
							<html:option value=""></html:option>
							<html:options collection="dsTvdQdMoNiemPhong" property="idCanBo" labelProperty="tenCanBo" />
						</html:select> <html:hidden property="tenNguoiMoNp" styleId="tenNguoiMoNp" /></td>
						<td width="19%" align="right">Ch&#7913;c v&#7909;</td>
						<td width="1%"></td>
						<td width="30%" align="left"><html:text styleClass="text" property="chucVuNguoiMoNP" readonly="true">
						</html:text></td>
					</tr>
				</table>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td colspan="6" align="right"><INPUT type="button" class="button1" value="In quy&#7871;t &#273;&#7883;nh" onclick="inQDMoNP()"></td>
			</tr>
		</TBODY>
	</TABLE>
	<html:hidden property="idDsTvdQdMoNiemPhong" />
</html:form>
<script language="javascript">
var y = document.getElementById('tenNguoiMoNp').value; 
function selectTenNguoiMoNp(cbDsCanbo){
	document.getElementsByName('tenNguoiMoNp')[0].value = cbDsCanbo[cbDsCanbo.selectedIndex].text;
}
function validateQdMoNp(){
	if(isEmpty(document.getElementsByName('idBbNiemPhong')[0].value)){
		alert('Ch\u01B0a l\u01B0u bi\u00EAn b\u1EA3n ni\u00EAm phong!');
		return false;
	}
	if(!isRequired(document.getElementsByName('noiRaQDMoNP')[0]))
		return false;
	if(!isRequired(document.getElementsByName('ngayRaQDMoNP')[0]))
		return false;
	if(!isRequired(document.getElementsByName('donViBaoQuanSauNP')[0]))
		return false;
	if(!isRequired(document.getElementsByName('nguoiMoNP')[0]))
		return false;
	
	return true;
}
		
function onLoadQdMoNiemPhong(){
	

}
	
function loadTen(cbDsCanbo){
		 for(var i=0;i< cbDsCanbo.length;i++ )
		 {
		 	if(cbDsCanbo.options[i].text == y)
		 		cbDsCanbo.selectedIndex = i;
		 }
	}
function getChucVuById(idCanBo){
			var arrIdThanhVienDoan = dsIdThanhVienDoan.split(',');
			var arrChucVu = dsChucThanhVienDoan.split(',');
			for(i = 0; i < arrIdThanhVienDoan.length; i++){
				if(arrIdThanhVienDoan[i] == idCanBo)
					return arrChucVu[i];
	}
	return "code loi";
	}


function setChucVu(cbThanhVienDoan){  
	if(isEmpty(cbThanhVienDoan.value)){
		document.getElementsByName('chucVuNguoiMoNP')[0].value = '';		
		return;
	}
	selectTenNguoiMoNp(cbThanhVienDoan);
		cbDsTvdQdMoNiemPhong123 = document.getElementById('cbDsTvdQdNiemPhong');
		for(var i = 0; i< cbDsTvdQdMoNiemPhong123.length; i++){
			if(cbDsTvdQdMoNiemPhong123[i].value == document.getElementsByName('nguoiMoNP')[0].value){
				chucVuEn = cbDsTvdQdMoNiemPhong123[i].title;
				document.getElementsByName('chucVuNguoiMoNP')[0].value = getChucVuCoDau(chucVuEn);
				return;
			}
		}
		setTenDvCaNhaThucHien(cbThanhVienDoan);
	}
function inQDMoNP(){
	if(!validateQdMoNp())  return false;
	//document.forms[0].action = 'niem_phong_ho_so_tai_lieu.do?method=in&type=inQDMoNP'
	//document.forms[0].submit();
	//document.forms[0].action = 'niem_phong_ho_so_tai_lieu.do';
	var printfForm = findForm('/' + contextRoot + '/niem_phong_ho_so_tai_lieu.do?method=save&type=qdMoNiemPhong'); 	   
	printfForm.action = 'niem_phong_ho_so_tai_lieu.do?method=in&type=inQDMoNP&ngayQDNP='+ngayraQDNP+'&idCuocTtkt='+document.getElementsByName('idCuocTtkt')[0].value;
	printfForm.submit();                                  
	printfForm.action = '/' + contextRoot + '/niem_phong_ho_so_tai_lieu.do?method=save&type=qdMoNiemPhong';    
}
	
</script>