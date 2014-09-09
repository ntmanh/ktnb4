<%@ include file="/top_bar.jsp"%>
<%@page import="cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt"%>
<html:form action='khttkt_cqt_cap_duoi.do'>
	<logic:present name="isChiCuc">
		<script language="javascript">
			alert('Chi c\u1EE5c kh\u00F4ng c\u00F3 c\u01A1 quan thu\u1EBF tr\u1EF1c thu\u1ED9c!');
			window.location = 'ttkt_index.do';
		</script>
	</logic:present>
	<div style="margin: 5px;">
	<table>
		<tr>
			<td align="right" width="24%">K&#x1EBF; ho&#x1EA1;ch ki&#x1EC3;m tra n&#x103;m <font color=red>*</font></td>
			<td width="1%"></td>
			<td align="left" width="10%"><html:text styleClass="text" property="namKeHoach" onblur="changeNamKeHoach(this)" onkeypress="return formatInt(event);"></html:text></td>
			<logic:notPresent name="chua_co_cqt_truc_thuoc">
				<td width="19%" align="right">C&#417; quan thu&#7871;</td>
				<td width="1%"></td>
				<td align="left"><html:select property="selectedCqt" onchange="changeSelectedCqt(this.value)">
					<html:options collection="dsCqtTrucThuoc" property="maCqt" labelProperty="tenCqt" />
				</html:select></td>
			</logic:notPresent>
			<logic:present name="chua_co_cqt_truc_thuoc">
				<td width="19%" align="right"></td>
				<td width="1%"></td>
				<td align="left"></td>
			</logic:present>
		</tr>
	</table>
	</div>
	<logic:present name="chua_co_cqt_truc_thuoc">
		<br>
		<fieldset style="margin: 5px; text-align: center; vertical-align: middle"><font color="red" size="5">Ch&#x1B0;a c&#xF3; c&#x1A1; quan thu&#x1EBF; tr&#x1EF1;c thu&#x1ED9;c n&#xE0;o c&#xF3; k&#x1EBF; ho&#x1EA1;ch n&#x103;m <script language="javascript">document.write(document.getElementsByName('namKeHoach')[0].value)</script>!</font>
		</fieldset>
	</logic:present> <logic:notPresent name="chua_co_cqt_truc_thuoc">
		<fieldset style="margin: 5px"><legend>K&#7871; ho&#7841;ch n&#259;m</legend>
		<table width="100%" align="center">
			<tr class="TdHeaderListOfSearch">
				<td><bean:message key="label.ma_cuoc_ttkt" /></td>
				<td align="left" width="21%"><bean:message key="label.don_vi_duoc_ttkt" /></td>
				<td><bean:message key="label.thoi_ky" /></td>
				<td align="center">Th&#x1EDD;i gian d&#x1EF1; ki&#x1EBF;n</td>
				<td>T&#x1EEB; ng&#xE0;y - &#x111;&#x1EBF;n ng&#xE0;y</td>
				<!-- <td><bean:message key="label.hinh_thuc" /></td> -->
				<td align="left" width="14%">Tr&#x1EA1;ng th&#xE1;i</td>
			</tr>
			<logic:present name="dscttkt" property="data">
				<logic:iterate id="cuocTTKT" name="dscttkt" property="data" indexId="index">
					<tr class='row<%=(index.intValue() % 2)+1 %>'>
						<td><A href="#" onclick="window.open('cuoc_ttkt.do?method=view&cuocTtktId=<bean:write name="cuocTTKT" property="id"/>');"> <bean:write name="cuocTTKT" property="ma" /> </A></td>
						<td align="left" width="21%"><bean:write name="cuocTTKT" property="tenDonViBi" /></td>
						<td><script language="javascript">
								document.write('<bean:write name="cuocTTKT" property="nienDoTuNgayStr"/>' + ' - ' + '<bean:write name="cuocTTKT" property="nienDoDenNgayStr"/>');
							</script></td>
						<td align="center"><script language="javascript">
								document.write('<bean:write name="cuocTTKT" property="thoiGianDuKien"/>');
								document.write(' ng&#xE0;y');
							</script></td>
						<td><script language="javascript">
								document.write('<bean:write name="cuocTTKT" property="thoiGianDuKienTuNgayStr"/>'.substring(0,5) + ' - ' + '<bean:write name="cuocTTKT" property="thoiGianDuKienDenNgayStr"/>');
							</script></td>
						<!-- <td><logic:equal name="cuocTTKT" property="hinhThuc" value="false">
							<bean:message key="label.thanh_tra" />
						</logic:equal> <logic:equal name="cuocTTKT" property="hinhThuc"
							value="true">
							<bean:message key="label.kiem_tra" />
						</logic:equal></td> -->
						<td align="left" width="14%"><bean:write name="cuocTTKT" property="trangThai" /></td>
					</tr>
				</logic:iterate>
			</logic:present>
		</table>
		<logic:present name="dscttkt">
			<DIV style="text-align: center; width: 100%" align="center"><bean:write name="dscttkt" property="navigationBar" filter="false" /></DIV>
		</logic:present></fieldset>
	</logic:notPresent>
	<br>
	<DIV style="text-align: center;"><INPUT type="button" onclick="window.location = 'ttkt_index.do';" value="<bean:message  key = 'label.dong'/>" class="button" style="WIDTH: 60px"></DIV>
	<html:hidden property="selectedCqt" />
</html:form>
<%@ include file="/bottom.jsp"%>
<script language="javascript">
	var nam;
	window.onload = function(){
		nam = document.getElementsByName('namKeHoach')[0].value;
		
	}
	function changeNamKeHoach(namKeHoachCtr){		
		if(!isRequired(namKeHoachCtr))
			return;
		if(namKeHoachCtr.value.length != 4){
			alert('N\u0103m ph\u1EA3i c\u00F3 4 ch\u1EEF s\u1ED1'); 
			namKeHoachCtr.focus();
			return;
		}
		if(nam != document.getElementsByName('namKeHoach')[0].value){
			nam = document.getElementsByName('namKeHoach')[0].value;
			document.forms[0].submit();
		}
		
	}
	function changeSelectedCqt(cqtId){
		document.forms[0].elements['selectedCqt'].value = cqtId;
		document.forms[0].submit();
		
		
	}
	function print(){	
		document.forms[0].action='khttkt_cqt_cap_duoi.do?method=printf';
		document.forms[0].submit();
	}
</script>