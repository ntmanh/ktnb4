<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<SELECT id="cbDsTvdQdNiemPhong" style="display: none;">
	<OPTION value=""></OPTION>
	<logic:iterate name="dsTvdQdNiemPhong" id="tvd">
		<OPTION value="<bean:write name="tvd" property="idCanBo"/>" title="<bean:write name="tvd" property="chucVuTrongDoan"/>"><bean:write name="tvd" property="tenCanBo" /></OPTION>
	</logic:iterate>
</SELECT>
<html:form action="niem_phong_ho_so_tai_lieu.do?method=save&type=qdNiemPhong" method="POST">
	<html:hidden property="idQdNiemPhong" />
	<TABLE width="100%" align="center">
		<TBODY>
			<tr>
				<td width="19%" align="right">N&#417;i ra quy&#7871;t &#273;&#7883;nh <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text property="noiRaQDNP" styleClass="text"></html:text></td>
				<td width="19%" align="right">Ng&#224;y ra quy&#7871;t &#273;&#7883;nh <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text property="ngayRaQDNP" styleClass="text" onblur="isDate(this)" onkeypress="return formatDate(event, this)">
				</html:text></td>
			</tr>
			<tr>
				<td width="19%" align="right">Lo&#7841;i t&#224;i li&#7879;u &#273;&#432;&#7907;c ni&#234;m phong, th&#7901;i gian ni&#234;m phong<font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left" colspan="4"><html:textarea property="loaiTaiLieuQDNP" onkeypress="imposeMaxLength(this);"  styleClass="textareaContent" /></td>
			</tr>
			<tr>
				<td width="19%" align="right">Th&#7901;i gian ni&#234;m phong t&#7915; <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left" colspan="4"><html:text property="thoiGianNPTu" styleClass="text" onblur="isTime(this)" onkeypress="return formatTime(event, this)"></html:text></td>
			</tr>
			<tr>
				<td width="19%" align="right">&#272;&#417;n v&#7883; c&#225; nh&#226;n &#273;&#432;&#7907;c giao th&#7921;c hi&#7879;n <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:select property="dinViCaNhanThucHien" styleId="dinViCaNhanThucHien" onchange="setChucVu1(this)" style="width:100%">
					<html:option value=""></html:option>
					<html:options collection="dsTvdQdNiemPhong" property="idCanBo" labelProperty="tenCanBo" />
				</html:select> <html:hidden property="tenCanBoDvCnTh" styleId="tenCanBoDvCnTh" />
				</td>
				<td width="19%" align="right">Ch&#x1EE9;c v&#x1EE5; trong &#x111;o&#xE0;n</td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text property="chucVuTrongDoanQDNP" styleClass="text" readonly="true"></html:text></td>
			</tr>
			<tr>
				<td width="19%" align="right">&#272;&#417;n v&#7883; c&#225; nh&#226;n &#273;&#432;&#7907;c giao b&#7843;o qu&#7843;n <font color=red>*</font></td>
				<td width="1%"></td>
				<td width="30%" align="left"><html:text styleClass="text" property="dinViCaNhanBaoQuanQdNp"></html:text></td>
				<td></td>
				<td></td>
				<td width="30%" align="right" colspan="3"><INPUT type="button" class="button1" value="In quy&#7871;t &#273;&#7883;nh" onclick="inQDNP()"></td>
			</tr>
		</TBODY>
	</TABLE>
	<html:hidden property="idDsTvdQdNiemPhong" />
</html:form>
<script language="javascript">
	var x = document.getElementById('tenCanBoDvCnTh').value;
	ngayraQDNP=document.getElementById('ngayRaQDNP').value; 
	function onLoadQdNiemPhong(){
		
		
	}

	//set ten cho don vi ca nhan thuc hien
	function setTenDvCaNhaThucHien(cbDsCanbo){
		document.getElementsByName('tenCanBoDvCnTh')[0].value = cbDsCanbo[cbDsCanbo.selectedIndex].text;
	}

	function loadTenDvCaNhaThucHien(cbDsCanbo){
		 for(var i=0;i< cbDsCanbo.length;i++ )
		 {
		 	if(cbDsCanbo.options[i].text == x)
		 		cbDsCanbo.selectedIndex = i;
		 }
	}
	
function validateQdNp(){
	if(!isRequired(document.getElementsByName('noiRaQDNP')[0]))
		return false;
	if(!isRequired(document.getElementsByName('ngayRaQDNP')[0]))
		return false;
	if(!isRequired(document.getElementsByName('loaiTaiLieuQDNP')[0]))
		return false;
	if(!isRequired(document.getElementsByName('thoiGianNPTu')[0]))
		return false;
	if(!isRequired(document.getElementsByName('dinViCaNhanThucHien')[0]))		
		return false;		
	if(!isRequired(document.getElementsByName('dinViCaNhanBaoQuanQdNp')[0]))
		return false;
	var ngayRaQDNP = d2n(document.getElementsByName('ngayRaQDNP')[0].value);
	var thoiGianNPTu = d2n(document.getElementsByName('thoiGianNPTu')[0].value.split(" ")[1]);
	if(ngayRaQDNP>thoiGianNPTu){
		alert('Ng\u00E0y ra quy\u1EBFt \u0111\u1ECBnh ni\u00EAm phong ph\u1EA3i tr\u01B0\u1EDBc th\u1EDDi \u0111i\u1EC3m ni\u00EAm phong!');
		return false;
	}
	return true;
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
  
    
function setChucVu1(cbThanhVienDoan){   
	if(isEmpty(document.getElementsByName('dinViCaNhanThucHien')[0].value)){
		document.getElementsByName('chucVuTrongDoanQDNP')[0].value = '';
		return;
	}
		
	cbDsTvdQdNiemPhong123 = document.getElementById('cbDsTvdQdNiemPhong');
	for(var i = 0; i< cbDsTvdQdNiemPhong123.length; i++){
		if(cbDsTvdQdNiemPhong123[i].value == document.getElementsByName('dinViCaNhanThucHien')[0].value){
			chucVuEn = cbDsTvdQdNiemPhong123[i].title;
			document.getElementsByName('chucVuTrongDoanQDNP')[0].value = getChucVuCoDau(chucVuEn);
			break;
		}
	}
	document.getElementsByName('tenCanBoDvCnTh')[0].value = cbThanhVienDoan[cbThanhVienDoan.selectedIndex].text;
	    
}
function inQDNP(){        
	if(!validateQdNp())return false;
	var printfForm = findForm('/' + contextRoot + '/niem_phong_ho_so_tai_lieu.do?method=save&type=qdNiemPhong'); 	   
	printfForm.action = 'niem_phong_ho_so_tai_lieu.do?method=in&type=inQDNP&idCuocTtkt='+document.getElementsByName('idCuocTtkt')[0].value;
	printfForm.submit();                                  
	printfForm.action = '/' + contextRoot + '/niem_phong_ho_so_tai_lieu.do?method=save&type=qdNiemPhong';                       
}
</script>