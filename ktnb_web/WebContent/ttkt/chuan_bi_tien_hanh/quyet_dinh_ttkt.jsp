<%@ page pageEncoding="UTF-8"  %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="chuan_bi_tien_hanh.do?method=save&type=qd" method="POST" styleId="quyetDinhForm">
	<logic:notPresent name="readOnly">
		<logic:notPresent name="da_co_lich_trinh_du_kien">
			<fieldset style="margin: 0"><legend> Nội dung kiểm tra </legend>
			<table>
				<tr>
					<td align="right" width="19%">Không thay đổi nội dung Kiểm tra</td>
					<td style="width: 1%; min-width: 5px"></td>
					<td align="left" width="80%"><input type="checkbox" id="chkBoxThayDoiNoiDungKt" onclick="document.getElementById('lnkChinhSuaNoiDung').style.display=this.checked?'none':'inline'">&nbsp; <A class="linkCnPhu" href="#" onclick="chinhSuaNoiDungTtkt()" id="lnkChinhSuaNoiDung"><font
						color="blue">Thay đổi nội dung Kiểm tra</font></A></td>
				</tr>
			</table>
			</fieldset>
		</logic:notPresent>
	</logic:notPresent>
	<table align="center" width="100%">
		<tr>
			<td align="right" width="19%">Số quyết định</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="soQuyetDinh"></html:text></td>
			<td align="right" width="19%">Địa điểm ra quyết định</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="diaDiemRaQuyetDinh"></html:text></td>
		</tr>
		<tr>
			<td align="right" width="19%">Ngày ra quyết định</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="30%"><html:text onkeypress="return formatDate(event, this)" onblur="if(!isDate(this)) return;validateDateRequired(this);"  styleClass="text" property="ngayRaQuyetDnh"></html:text></td>
			<td width="19%" align="right">Căn cứ luật số</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="30%"><html:textarea property="canCuLuatSo" styleClass="text"></html:textarea></td>
		</tr>
		<tr> 
			<td align="right" width="24%">Căn cứ quyết định</td>
			<td style="width: 1%; min-width: 5px;"/>
			<td colspan="4"><html:textarea property="canCuQd" style="width: 155%">Căn cứ Quyết định số 1722/QĐ-TCT ngày 08 tháng 10 năm 2014</html:textarea></td>
		</tr>
		<tr>
			<td align="right" width="19%">Văn bản quy định chức năng nhiệm vụ<font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4"><html:select property="vanBanQuyDinhCnangNvuQd" style="width: 100%" styleClass="combobox">
				<html:option value=""></html:option>
				<html:options collection="dmtly" property="value" labelProperty="label" />
			</html:select></td>
		</tr>
		<logic:present name="showVbChiDao">
			<tr>
				<td align="right" width="19%">Văn bản chỉ đạo/quyết định của người có thẩm quyền</td>
				<td style="width: 1%; min-width: 5px"></td>
				<td colspan="4"><html:textarea property="vanBanKeHoach" onkeypress="imposeMaxLength(this);"  styleClass="textareaTitle"></html:textarea></td>
			</tr>
		</logic:present>
		<tr>
			<td align="right" width="19%">Người chỉ đạo giám sát</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="30%">
			<table style="margin: 0" border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
				<tr>
					<td align="left" width="90%" style="margin: 0"><html:hidden property="idNguoiChiDaoGiamSat" /><html:text property="tenNguoiChiDaoGiamSat" styleClass="text" onchange="chonNguoiChiDaoGiamSat()" style="width:100%"></html:text></td>
					<td align="left" width="10%" style="margin: 0"><INPUT type="button" onclick="chonNguoiChiDaoGiamSat()" value="..." class="lovButton"></td>
				</tr>
			</table>
			</td>
			<td align="right" width="19%">Chức vụ</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="30%"><html:text property="chucVuNguoiChiDaoGiamSat" styleClass="text"></html:text></td>
		</tr>
		<tr>
			<td align="right" width="19%">Thủ trưởng các đơn vị liên quan</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4"><html:textarea property="thuTruongCacDvLienQuan" onkeypress="imposeMaxLength(this);"  styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td align="right" width="25%"><INPUT type="button" class="button1" onclick="inQuyetDinh()" value="In quyết định"></td>
		</tr>
	</table>
	<html:hidden property="idQuyetDinh" />
	<html:hidden property="isChangeQuyetDinh" />
</html:form>
<script language="javascript">
	function chonNguoiChiDaoGiamSat(){
		lovType = 'chonNguoiChiDaoDamSat'
		idCanBoConTrol = document.getElementsByName('idNguoiChiDaoGiamSat')[0];
		// Ten 
		tenCanBoConTrol = document.getElementsByName('tenNguoiChiDaoGiamSat')[0];
		
		// Chuc vu
		chucVuConTrol = document.getElementsByName('chucVuNguoiChiDaoGiamSat')[0];
		showLovNhanVien(maCqt, tenCanBoConTrol);	
		
	}     
	function inQuyetDinh(){
		if(!validateQuyetDinh())               
			return;	
			
		var thongTinIn = "";
		var qdForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=qd');	 
		for(var i = 0; i< qdForm.elements.length; i++){
			if(qdForm.elements[i].name != null && qdForm.elements[i].name != '' && qdForm.elements[i].value != null && qdForm.elements[i].value != '')
			thongTinIn += "&" + qdForm.elements[i].name + "=" + encodeURIComponent(qdForm.elements[i].value);
		}		
		//thongTinIn = thongTinIn.substring(0, thongTinIn.length - 1);  
		//window.open('chuan_bi_tien_hanh.do?method=in&type=qd&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value + '&' + thongTinIn);
		var printfForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=qd'); 
		printfForm.action = 'chuan_bi_tien_hanh.do?method=in&type=qd&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value + thongTinIn;
		printfForm.submit();
		printfForm.action = '/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=qd'; 
	}
	function ngayRaQuyetDnh(){
	} 
	function validateQuyetDinh(){		
	  <logic:notPresent name="da_co_lich_trinh_du_kien">		
		if(!isEmpty(document.getElementsByName('soQuyetDinh')[0].value)){
			if(!document.getElementById('chkBoxThayDoiNoiDungKt').checked){
				alert('Bạn phải chắc chắn Không thay đổi nội dung Kiểm tra trước khi ra quyết định!');
				document.getElementById('chkBoxThayDoiNoiDungKt').focus();
				return false;
			}
			if(!isRequired(document.getElementsByName('diaDiemRaQuyetDinh')[0], 'Phải nhập địa điểm ra quyết định cùng với số quyết định!'))
				return false;  
			if(!isRequired(document.getElementsByName('ngayRaQuyetDnh')[0], 'Phải nhập ngày ra quyết định cùng với số quyết định!'))
				return false; 
		}
	  </logic:notPresent> 		
		
		if(!isRequired(document.getElementsByName('vanBanQuyDinhCnangNvuQd')[0])) 
			return false;
		//if(!isRequired(document.getElementsByName('tenNguoiChiDaoGiamSat')[0]))
			//return false;
		//if(!isRequired(document.getElementsByName('chucVuNguoiChiDaoGiamSat')[0]))
			//return false;
		
		
			
		return true;
	}
	function chinhSuaNoiDungTtkt(){		
		window.open('cuoc_ttkt.do?method=edit&cuocTtktId=' + document.getElementsByName('idCuocTtkt')[0].value + '&thoiDiem=raQuyetDinh').focus();
	}
	
</script>
