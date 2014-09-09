<%@page import="cmc.com.ktnb.util.KtnbUtil"%>
<%@page import="cmc.com.ktnb.web.ttkt.dung_chung.form.NoiDungTtktForm"%>
<%@page import="cmc.com.ktnb.util.Formater"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%boolean bShowListCqtTrucThuoc = true;
boolean bShowListNoiDungTtkt = true;
if (bShowListCqtTrucThuoc) {%>
<logic:present name="KeHoachNamForm" property="dsTtktCqtTrucThuoc">
	<fieldset><legend>N&#x1ED9;i dung Thanh tra Ki&#x1EC3;m tra</legend>
	<div style="overflow: scroll; width: 100%">
	<table width="100%">
		<tr class="TdHeaderList">
			<td align="center">T&#xEA;n c&#x1A1; quan</td>
			<td align="center"><bean:message key="label.noi_dung" /></td>
			<td align="center">Chi ti&#x1EBF;t</td>
			<td align="center"><bean:message key="label.thoi_ky" /></td>
			<td align="center"><bean:message key="label.thoi_gian_du_kien" /></td>
			<td align="center"><bean:message key="label.hinh_thuc" /></td>
			<td align="center"><bean:message key="label.loai" /></td>
			<td align="center"><input type="checkbox" onclick="selectAllCheckBox(this.checked)"></td>
		</tr>
		<logic:iterate id="dsTtktCqtTrucThuoc" name="KeHoachNamForm" property="dsTtktCqtTrucThuoc" indexId="index">
			<tr class='row<%=(index.intValue() % 2)+1 %>'>
				<!--Co quan thue-->
				<td align="center"><!--Ma co quan thue--> <html:select name="KeHoachNamForm" property='<%="dsTtktCqtTrucThuoc[" + index + "].col1"%>'>
					<html:option value=""></html:option>
					<html:options property="ma" labelProperty="ten" collection="dmCqtTrucThuoc" />
				</html:select> <!--Ten co quan thue--> <html:hidden name="KeHoachNamForm" property='<%="dsTtktCqtTrucThuoc[" + index + "].col2"%>' /></td>
				<!--Noi dung-->
				<td align="center" style="display: inline;"><!--Ma noi dung--> <html:hidden name="KeHoachNamForm" property='<%="dsTtktCqtTrucThuoc[" + index + "].col3"%>' /> <!--Ten noi dung--> <html:textarea name="KeHoachNamForm" onkeypress="imposeMaxLength(this);"  property='<%="dsTtktCqtTrucThuoc[" + index + "].col4"%>'></html:textarea> <INPUT
					type="button" style="display: inline;" value="..." onclick="selectNoiDungTtkt(<%=index%>, 'dsTtktCqtTrucThuoc')"></td>
				<!--Chi tiet noi dung-->
				<td align="center" style="display: inline;"><!--Ma chi tiet noi dung--> <html:text name="KeHoachNamForm" styleClass="text" property='<%="dsTtktCqtTrucThuoc[" + index + "].col5"%>' /> <INPUT type="button" value="..." style="display: inline;" class="button"
					onclick="chonNoiDungChiTiet('<%=index%>', 'dsTtktCqtTrucThuoc')" /> <!--Ten chi tiet noi dung--> <html:hidden name="KeHoachNamForm" property='<%="dsTtktCqtTrucThuoc[" + index + "].col6"%>' /></td>
				<!--Thoi ky-->
				<td align="center"><!--Tu ngay--> <html:text name="KeHoachNamForm" styleClass="text" property='<%="dsTtktCqtTrucThuoc[" + index + "].col7"%>' /> - <!--Den ngay--> <html:text styleClass="text" name="KeHoachNamForm" property='<%="dsTtktCqtTrucThuoc[" + index + "].col8"%>' /></td>
				<!--Thoi gian du kien-->
				<td align="center"><html:text name="KeHoachNamForm" property='<%="dsTtktCqtTrucThuoc[" + index + "].col9"%>' styleClass="text">
				</html:text></td>
				<!--Hinh thuc-->
				<td align="center"><html:select styleClass="combobox" name="KeHoachNamForm" property='<%="dsTtktCqtTrucThuoc[" + index + "].col10"%>'>
					<html:option value="0">
						<bean:message key="label.thanh_tra" />
					</html:option>
					<html:option value="1">
						<bean:message key="label.kiem_tra" />
					</html:option>
				</html:select></td>
				<!--Loai-->
				<td align="center"><html:select styleClass="combobox" styleClass="combobox" name="KeHoachNamForm" property='<%="dsTtktCqtTrucThuoc[" + index + "].col11"%>'>
					<html:option value="0">
						<bean:message key="label.dinh_ky" />
					</html:option>
					<html:option value="1">
						<bean:message key="label.dot_xuat" />
					</html:option>
				</html:select></td>
				<td align=center><logic:equal name="KeHoachNamForm" property='<%="dsTtktCqtTrucThuoc[" + index + "].active"%>' value="true">
					<INPUT type="checkbox" name="checkBoxItem" onclick="checkTrangthai(this.checked, '<%="dsTtktCqtTrucThuoc[" + index + "].active"%>');" checked="checked">
				</logic:equal> <logic:equal name="KeHoachNamForm" property='<%="dsTtktCqtTrucThuoc[" + index + "].active"%>' value="false">
					<INPUT type="checkbox" name="checkBoxItem" onclick="checkTrangthai(this.checked, '<%="dsTtktCqtTrucThuoc[" + index + "].active"%>');">
				</logic:equal> <html:hidden property='<%="dsTtktCqtTrucThuoc[" + index + "].active"%>' /></td>
			</tr>
		</logic:iterate>
	</table>
	</div>
	</fieldset>
</logic:present>
<%}%>
<%if (bShowListNoiDungTtkt) {%>
<logic:present name="KeHoachNamForm" property="dsNoiDungTtkt">
	<fieldset><legend>N&#x1ED9;i dung Thanh tra Ki&#x1EC3;m tra</legend>
	<div style="overflow: scroll; width: 100%">
	<table width="100%">
		<tr class="TdHeaderList">
			<td align="center"><bean:message key="label.noi_dung" /></td>
			<td align="center">Chi ti&#x1EBF;t</td>
			<td align="center"><bean:message key="label.thoi_ky" /></td>
			<td align="center"><bean:message key="label.thoi_gian_du_kien" /></td>
			<td align="center"><bean:message key="label.hinh_thuc" /></td>
			<td align="center"><bean:message key="label.loai" /></td>
			<td align="center"><input type="checkbox" onclick="selectAllCheckBox(this.checked)"></td>
		</tr>
		<logic:iterate id="dsNoiDungTtkt" name="KeHoachNamForm" property="dsNoiDungTtkt" indexId="index">
			<tr class='row<%=(index.intValue() % 2)+1 %>'>				
				<!--Noi dung-->
				<td align="center" style="display: inline;"><!--Ma noi dung--> <html:hidden name="KeHoachNamForm" property='<%="dsNoiDungTtkt[" + index + "].col3"%>' /> <!--Ten noi dung--> <html:textarea name="KeHoachNamForm" onkeypress="imposeMaxLength(this);" property='<%="dsNoiDungTtkt[" + index + "].col4"%>'></html:textarea> <INPUT
					type="button" style="display: inline;" onclick="selectNoiDungTtkt(<%=index%>, 'dsNoiDungTtkt')" value="..."></td>
				<!--Chi tiet noi dung-->
				<td align="center" style="display: inline;"><!--Ma chi tiet noi dung--> <html:text name="KeHoachNamForm" styleClass="text" property='<%="dsNoiDungTtkt[" + index + "].col5"%>' /> <INPUT type="button" value="..." class="button" style="display: inline;"
					onclick="chonNoiDungChiTiet('<%=index%>', 'dsNoiDungTtkt')" /> <!--Ten chi tiet noi dung--> <html:hidden name="KeHoachNamForm" property='<%="dsNoiDungTtkt[" + index + "].col6"%>' /></td>
				<!--Thoi ky-->
				<td align="center"><!--Tu ngay--> <html:text name="KeHoachNamForm" styleClass="text" property='<%="dsNoiDungTtkt[" + index + "].col7"%>' /> - <!--Den ngay--> <html:text styleClass="text" name="KeHoachNamForm" property='<%="dsNoiDungTtkt[" + index + "].col8"%>' /></td>
				<!--Thoi gian du kien-->
				<td align="center"><html:text name="KeHoachNamForm" property='<%="dsNoiDungTtkt[" + index + "].col9"%>' styleClass="text">
				</html:text></td>
				<!--Hinh thuc-->
				<td align="center"><html:select styleClass="combobox" name="KeHoachNamForm" property='<%="dsNoiDungTtkt[" + index + "].col10"%>'>
					<html:option value="0">
						<bean:message key="label.thanh_tra" />
					</html:option>
					<html:option value="1">
						<bean:message key="label.kiem_tra" />
					</html:option>
				</html:select></td>
				<!--Loai-->
				<td align="center"><html:select styleClass="combobox" styleClass="combobox" name="KeHoachNamForm" property='<%="dsNoiDungTtkt[" + index + "].col11"%>'>
					<html:option value="0">
						<bean:message key="label.dinh_ky" />
					</html:option>
					<html:option value="1">
						<bean:message key="label.dot_xuat" />
					</html:option>
				</html:select></td>
				<td align=center><logic:equal name="KeHoachNamForm" property='<%="dsNoiDungTtkt[" + index + "].active"%>' value="true">
					<INPUT type="checkbox" name="checkBoxItem" onclick="checkTrangthai(this.checked, '<%="dsNoiDungTtkt[" + index + "].active"%>');" checked="checked">
				</logic:equal> <logic:equal name="KeHoachNamForm" property='<%="dsNoiDungTtkt[" + index + "].active"%>' value="false">
					<INPUT type="checkbox" name="checkBoxItem" onclick="checkTrangthai(this.checked, '<%="dsNoiDungTtkt[" + index + "].active"%>');">
				</logic:equal></td>
			</tr>
		</logic:iterate>
	</table>
	</div>
	</fieldset>
</logic:present>
<%}%>
<script language="javascript">	
	function checkTrangthai(value, controlName){
		document.forms[0].elements[controlName].value = value;	
	}
	function xoaNoiDung(){
		document.forms[0].action = "cuoc_ttkt.do?method=xoaNoiDung";
		document.forms[0].selectedItems.value = selectedItems;
		document.forms[0].submit();
	}
	function themNoiDung(){
		document.forms[0].action = "cuoc_ttkt.do?method=themNoiDung";
		document.forms[0].submit();
	}

	function xoaCqtTrucThuoc(){
		document.forms[0].action = "cuoc_ttkt.do?method=xoaCqtTrucThuoc";
		document.forms[0].selectedItems.value = selectedItems;
		document.forms[0].submit();
	}
	function themCqtTrucThuoc(){
		document.forms[0].action = "cuoc_ttkt.do?method=themCqtTrucThuoc";
		document.forms[0].submit(); 
	}
	function validateForm(){
		if(selectedItems == ""){
			alert(chua_chon_noi_dung);
			return false;
		}			
		document.forms[0].elements['selectedItems'].value = selectedItems;
		if(!isRequired(document.forms[0].elements['nienDoTuNgay'], khong_duoc_de_trong_from_date))
			return false;
		if(!isRequired(document.forms[0].elements['nienDoDenNgay'], khong_duoc_de_trong_to_date))
			return false;
		return true; 
	}
	// menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no,height=600,width=600,top=0,left=0
	function  showLovCqt(){
		win=window.open("tim_kiem_cqt.do?method=execute&donviBiName=" + document.getElementsByName('donViBiName')[0].value,"","menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no,height=600,width=600,top=0,left=0");
	}
	function setDonviDuocTTKT(ma, ten){
		if(document.forms[0].elements['idDonViBi'].value != ma){
			document.forms[0].elements['idDonViBi'].value = ma;
			document.forms[0].elements['donViBiName'].value = ten;	
			document.forms[0].action = "cuoc_ttkt.do?method=changeDonViDuocTtkt";		
			document.forms[0].submit();
		}
	}
	function changNoiDungTtkt(newValue, controlNoiDungTtktName){
		//document.getElementsByName(controlNoiDungTtktName)[0].value = newValue;
	}
	var getValueFromChild;
	function chonNoiDungChiTiet(controlNdGocMaName, controlNdGocName, controlNdChiTietLabel, controlNdChiTietId){	
		getValueFromChild = controlNdChiTietId;
		maNd = 	document.getElementsByName(controlNdGocMaName)[0];
		if(maNd.value == null || maNd.value == ""){
			alert('Chua chon noi dung Ttkt');
			maNd.focus();
			return;
		}else{
			win=window.open("chi_tiet_noi_dung.do?method=execute&noidungId=" + maNd.value,"","menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no,height=600,width=600,top=0,left=0");
			//win=window.open("chi_tiet_noi_dung.do?method=execute&noidungId=" + maNd.value,"");
			win.focus();
		}
		
			
	}
	function selectChiTietDanhMuc(selectedIds){
		document.forms[0].elements[getValueFromChild].value = selectedIds;
	}
</script>