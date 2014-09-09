<%@page pageEncoding="UTF-8" %>
<%@ include file="/top_bar.jsp"%>
<html:form action='khttkt_cqt_cap_tren.do'>
<!-- Nếu là tổng cục -->
	<logic:present name="isTongCuc">
		<script language="javascript">
			alert('Tổng cục không có cơ quan thuế cấp trên!');
			window.location = 'ttkt_index.do';
		</script>
	</logic:present>
	<div style="margin: 5px;">
	<table>
		<tr>
			<td align="right" width="24%">Kế hoạch kiểm tra năm<font color=red>*</font></td>
			<td width="1%"></td>
			<td align="left" width="10%"><html:text styleClass="text" property="namKeHoach" onblur="changeNamKeHoach(this)" onkeypress="return formatInt(event);"></html:text></td>
		</tr>
	</table>
	</div>
	<logic:present name="chua_co_cqt_truc_thuoc">
		<br>
		<fieldset style="margin: 5px; text-align: center; vertical-align: middle"><font color="red" size="5">Ch&#x1B0;a c&#xF3; c&#x1A1; quan thu&#x1EBF; tr&#x1EF1;c thu&#x1ED9;c n&#xE0;o c&#xF3; k&#x1EBF; ho&#x1EA1;ch n&#x103;m <script language="javascript">document.write(document.getElementsByName('namKeHoach')[0].value)</script>!</font>
		</fieldset>
	</logic:present> <logic:notPresent name="chua_co_cqt_truc_thuoc">
		<fieldset style="margin: 5px"><legend>Kế hoạch năm</legend>
		<table width="100%" align="center">
			<tr class="TdHeaderListOfSearch">
				<td><bean:message key="label.ma_cuoc_ttkt" /></td>
				<td align="left" width="21%">Đơn vị tiến hành</td>
				<td align="left" width="21%">Đơn vị được ttkt</td>
				<td><bean:message key="label.thoi_ky" /></td>
				<td align="center">Thời gian dự kiến</td>
				<td>Từ ngày - đến ngày</td>
				<!-- <td><bean:message key="label.hinh_thuc" /></td> -->
				<td align="left" width="14%">Trạng thái</td>
			</tr>
			<logic:present name="dscttkt" property="data">
				<logic:iterate id="cuocTTKT" name="dscttkt" property="data" indexId="index">
					<tr class='row<%=(index.intValue() % 2)+1 %>'>
						<td><A href="#" onclick="window.open('cuoc_ttkt.do?method=view&cuocTtktId=<bean:write name="cuocTTKT" property="id"/>');"> <bean:write name="cuocTTKT" property="ma" /> </A></td>
						<td align="left" width="21%"><bean:write name="cuocTTKT" property="tenDonViTh" /></td>
                        <td align="left" width="21%"><bean:write name="cuocTTKT" property="tenDonViBi" /></td>
						<td><script language="javascript">
								document.write('<bean:write name="cuocTTKT" property="nienDoTuNgayStr"/>' + ' - ' + '<bean:write name="cuocTTKT" property="nienDoDenNgayStr"/>');
							</script></td>
						<td align="center"><script language="javascript">
								document.write('<bean:write name="cuocTTKT" property="thoiGianDuKien"/>');
								document.write(' ngày');
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
			alert('Năm phải có 4 chữ số'); 
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
