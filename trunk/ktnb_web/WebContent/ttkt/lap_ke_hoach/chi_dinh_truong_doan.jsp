<%@page pageEncoding="UTF-8" %>
<%@ include file="/top_bar.jsp"%>
<%@page import="cmc.com.ktnb.web.ttkt.dung_chung.form.TimKiemCuocTtktForm"%>
<%@page import="cmc.com.ktnb.util.Constants"%>
<%@page import="cmc.com.ktnb.util.ApplicationContext"%>
<script language="javascript">                  
	var tenCqt = "<%=((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getTenCqt()%>";
	var maCqt = "<%=((ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT)).getMaCqt()%>";                 
</script>
<%
	//String tiTle = "T&#236;m ki&#7871;m cu&#7897;c Thanh tra Ki&#7875;m Tra";
	String tiTle = "T&#236;m ki&#7871;m";
	if(request.getAttribute("title") == null || !"".equals(request.getAttribute("title")))
		tiTle = (String)request.getAttribute("title");
	String nghiepVu = ((TimKiemCuocTtktForm)request.getAttribute("TimKiemCuocTtktForm")).getNghiepVu();
	
	
%>
<h3 class="Header"><%=tiTle%></h3>
<%@page import="cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt"%>
<script type="text/javascript" src="<html:rewrite page='/include/js/ttkt/tim_kiem.js'/>">
</script>
<logic:present name="save_status">
	<logic:equal name="save_status" value="success">
		<script language="javascript">
			alert('Lưu thành công!');
		</script>
	</logic:equal>
</logic:present>
<html:form action="tim_kiem_cuoc_ttkt.do">
	<fieldset style="margin: 5px"><legend><bean:message key="label.thong_tin_tim_kiem" /></legend>
	<table width="100%" align="center" cellspacing="5">
		<tr>
			<td align="right" width="19%"><bean:message key="label.ma_cuoc_ttkt" /></td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="ma_cuoc_ttkt"/></td>
			<td align="right" width="19%"><bean:message key="label.don_vi_duoc_ttkt" /></td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="don_vi_duoc_ttkt"/></td>
		</tr>
		<tr>
			<td align="right">Th&#x1EDD;i k&#x1EF3;: T&#x1EEB; ng&#xE0;y</td>
			<td align="right"></td>
			<td align="left"><html:text styleClass="text" property="tu_ngay" onblur="if(!isDate(this)) return; compareDate(this, document.getElementsByName('den_ngay')[0])" onkeypress="return formatDate(event,this);"/></td>
			<td align="right"><bean:message key="label.den_ngay" /></td>
			<td align="right"></td>
			<td align="left"><html:text styleClass="text" property="den_ngay" onblur="if(!isDate(this)) return; compareDate(document.getElementsByName('tu_ngay')[0], this)" onkeypress="return formatDate(event,this);"/></td>
		</tr>
		<tr>
			<td width="19%" align="right">Th&#x1EDD;i gian d&#x1EF1; ki&#x1EBF;n</td>
			<td width="1%" align="right"></td>
			<td width="30%" align="left"><html:text styleClass="text" style="width: 40" property="thoiGianDuKien" onkeypress="return formatInt(event);" onblur="if(!isNumber(this, 'i')) return;" /> Ng&#xE0;y</td>
			<td width="19%" align="right">T&#x1EEB; ng&#xE0;y - &#x111;&#x1EBF;n ng&#xE0;y</td>
			<td width="1%" align="right"></td>
			<td width="30%" align="center">
			<table style="margin: 0" border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
				<tr>
					<td align="left" width="45%" style="margin: 0"><html:text styleClass="text" style="width: 100%" property="thoiGianDuKienTuNgay" onkeypress="return formatDate(event,this);" onblur="if(!isDate(this)) return; compareDate(this, document.getElementsByName('thoiGianDuKienDenNgay')[0]);" /></td>
					<td width="10%" align="center" style="text-align: center; margin: 0">-</td>
					<td align="right" width="45%" style="margin: 0"><html:text styleClass="text" style="width: 100%" styleClass="text" property="thoiGianDuKienDenNgay" onkeypress="return formatDate(event, this);"
						onblur="if(!isDate(this)) return; compareDate(document.getElementsByName('thoiGianDuKienTuNgay')[0], this);" /></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<!-- <td align="right"><bean:message key="label.hinh_thuc" />				
			</td>
			<td align="right">
			<td align="left">
				<html:select styleClass="combobox"
					property="hinh_thuc">					
					<html:option value="all">
						<bean:message key="label.tat_ca" />
					</html:option>
					<html:option value="0">
						<bean:message key="label.thanh_tra" />
					</html:option>
					<html:option value="1">
						<bean:message key="label.kiem_tra" />
					</html:option>
				</html:select>
			</td> -->
			<td align="right"><bean:message key="label.loai" /></td>
			<td align="right"></td>
			<td align="left"><html:select styleClass="combobox" property="loai">
				<!--Dot xuat, dinh ky-->
				<html:option value="all">
					<bean:message key="label.tat_ca" />
				</html:option>
				<html:option value="0">
					<bean:message key="label.dinh_ky" />
				</html:option>
				<html:option value="1">
					<bean:message key="label.dot_xuat" />
				</html:option>
			</html:select></td>
			<td align="right">Tr&#7841;ng th&#225;i</td>
			<td align="right"></td>
			<td align="left"><html:select property="trangThaiPhanCongTruongDoan" style="width: 100%">
				<html:option value="">T&#7845;t c&#7843;</html:option>
				<html:option value="0">Ch&#432;a ph&#226;n c&#244;ng tr&#432;&#7903;ng &#273;o&#224;n</html:option>
				<html:option value="1">&#272;&#227; ph&#226;n c&#244;ng tr&#432;&#7903;ng &#273;o&#224;n</html:option>
			</html:select></td>
		</tr>
		<tr>
			<td align="right" width="19%">Tên trưởng đoàn</td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%"><html:text property="tenTruongDoan"></html:text></td>
			<td align="right" width="19%"></td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%"></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td align="right"></td>
			<td align="left"></td>
			<td align="left"><%@ include file="/ttkt/dung_chung/tim_kiem.jsp"%></td>
		</tr>
	</table>
	</fieldset>
	<Fieldset style="margin: 5px"><legend><bean:message key="label.ket_qua_tim_kiem" /> </legend>
	<table width="100%" align="center">
		<tr class="TdHeaderListOfSearch">
			<td><bean:message key="label.ma_cuoc_ttkt" /></td>
			<td width="17%"><bean:message key="label.don_vi_duoc_ttkt" /></td>
			<td><bean:message key="label.thoi_ky" /></td>
			<td align="center">Th&#x1EDD;i gian d&#x1EF1; ki&#x1EBF;n</td>
			<td>T&#x1EEB; ng&#xE0;y - &#x111;&#x1EBF;n ng&#xE0;y</td>
			<td><bean:message key="label.loai" /></td>
			<td align="center" width="17%">Tr&#432;&#7903;ng &#273;o&#224;n</td>
		</tr>
		<logic:present name="TimKiemCuocTtktForm" property="dsCuocTtkt">
			<logic:iterate id="dsCuocTtkt" name="TimKiemCuocTtktForm" property="dsCuocTtkt" indexId="index">
				<tr class='row<%=(index.intValue() % 2)+1 %>'>
					<td><!--Id cuoc ttkt--> <html:hidden name="TimKiemCuocTtktForm" property='<%="dsCuocTtkt[" + index + "].col0"%>' /> <A href="#" onclick="openWindow('cuoc_ttkt.do?method=view&cuocTtktId=<%=((cmc.com.ktnb.util.DetailInformation) dsCuocTtkt).getCol0()%>')"> <bean:write
						name="TimKiemCuocTtktForm" property='<%="dsCuocTtkt[" + index + "].col1"%>' /> <html:hidden name="TimKiemCuocTtktForm" property='<%="dsCuocTtkt[" + index + "].col0"%>' /> </A></td>
					<td><!--Ten don vi bi--> <bean:write name="TimKiemCuocTtktForm" property='<%="dsCuocTtkt[" + index + "].col5"%>' /></td>
					<td><!--Nien do--> <script language="javascript">
							document.write('<bean:write name="TimKiemCuocTtktForm" property='<%="dsCuocTtkt[" + index + "].col6"%>'/>'.substring(0,10) + '-' + '<bean:write name="TimKiemCuocTtktForm" property='<%="dsCuocTtkt[" + index + "].col7"%>'/>'.substring(0,10));
						</script></td>
					<td align="center"><!--Thoi gian du kien--> <bean:write name="TimKiemCuocTtktForm" property='<%="dsCuocTtkt[" + index + "].col16"%>' /></td>
					<td><!--Thoi gian du kien--> <bean:write name="TimKiemCuocTtktForm" property='<%="dsCuocTtkt[" + index + "].col8"%>' /></td>
					<td><logic:equal name="TimKiemCuocTtktForm" property='<%="dsCuocTtkt[" + index + "].col10"%>' value="0">
						<bean:message key="label.dinh_ky" />
					</logic:equal> <logic:equal name="TimKiemCuocTtktForm" property='<%="dsCuocTtkt[" + index + "].col10"%>' value="1">
						<bean:message key="label.dot_xuat" />
					</logic:equal></td>
					<td align="left"><!--Id truong doan--> <html:hidden name="TimKiemCuocTtktForm" property='<%="dsCuocTtkt[" + index + "].col11"%>' /> <!--Ten truong doan--> <html:text style="width: 75%" onchange='<%="chonTruongDoan(" + index + ", \'dsCuocTtkt\')"%>' styleClass="text"
						name="TimKiemCuocTtktForm" property='<%="dsCuocTtkt[" + index + "].col12"%>'>
					</html:text> <INPUT type="button" value="..." onclick="document.getElementsByName('<%="dsCuocTtkt[" + index + "].col11"%>')[0].value = ''; document.getElementsByName('<%="dsCuocTtkt[" + index + "].col12"%>')[0].value = ''; chonTruongDoan('<%=index%>', 'dsCuocTtkt')"> <!--Id danh sach thanh vien doan-->
					<html:hidden name="TimKiemCuocTtktForm" property='<%="dsCuocTtkt[" + index + "].col13"%>' /> <html:hidden name="TimKiemCuocTtktForm" property='<%="dsCuocTtkt[" + index + "].col15"%>' /></td>
				</tr>
			</logic:iterate>
		</logic:present>
		<tr>
			<td colspan="7" align="center"><bean:write name="tableKetQuaTimKiem" property="navigationBar" filter="false" /></td>
		</tr>
	</table>
	</fieldset>
	<BR>
	<TABLE width="30%" align="center">
		<tr align="center">
			<%if ("ke_hoach_nam.do".equals(nghiepVu)) {%>
			<td width="20%" align="center"><INPUT type="button" class="button" value="Th&#xEA;m m&#x1EDB;i" onclick="addNew()" /></td>
			<td width="20%" align="center"><INPUT type="button" class="button" value="Copy" onclick="copy()"></td>
			<td width="20%" align="center"><INPUT type="button" class="button" value="S&#x1EED;a" onclick="sua()"></td>
			<td width="20%" align="center"><INPUT type="button" class="button" value="X&#xF3;a" onclick="xoa()"></td>
			<td width="20%" align="center"><INPUT type="button" class="button1" value="In" onclick="inKeHoachNam()"></td>
			<td width="20%" align="center"><INPUT type="button" class="button" value="&#x110;&#xF3;ng" onclick="close123();"></td>
			<%} else if ("pcTruongDoan".equals(nghiepVu)) {%>
			<td align="center"><%@ include file="/ttkt/dung_chung/action_bar.jsp"%> <%}else{%>
			
			<td width="20%" align="center"><INPUT type="button" class="button" value="&#x110;&#xF3;ng" onclick="close123();">
			<%}%>
			</td>
		</tr>
	</TABLE>
	<html:hidden name="TimKiemCuocTtktForm" property="nghiepVu" />
	<html:hidden name="TimKiemCuocTtktForm" property="maCqtTienHanh" />
</html:form>
<%@ include file="/bottom.jsp"%>
<script language="javascript">           
$(function(){
	var state = '<%= request.getAttribute("statte")%>';
	if(state=="success"){
		alert("Lưu thành công");
	}
	if(state=="fail"){
		alert("Lỗi khi lưu!");
	}
})
function close123(){
 		try{
 			selfClose();
 		}catch(err){  			
 			window.location = 'ttkt_index.do';
 		} 		
 	}

var returnId;
var returnName;
var returnChucVuCongTac;
function chonTruongDoan(index, gridName){	
	returnId = document.getElementsByName(gridName + '[' + index + '].col11')[0];
	returnName = document.getElementsByName(gridName + '[' + index + '].col12')[0];
	returnChucVuCongTac = document.getElementsByName(gridName + '[' + index + '].col15')[0];	
	showLovNhanVien(maCqt, returnName, "true" );//Show cac can bo la NSD	
}
function setThongTinNhanVienFromLov(ma, ten, chucVu, tenPhong, tenCqt){
	
	returnId.value = ma;
	returnName.value = ten;
	returnChucVuCongTac.value = chucVu;
}


function getTruongDoan(ma, ten){
	returnId.value = ma;
	returnName.value = ten;
}
function getThongTinTruongDoan(id, name){
	document.getElementsByName(returnId)[0].value = id;
	document.getElementsByName(returnName)[0].value = name;
}
function inKeHoachNam(){
}
function getSelectedCuocTtktId(){
	allRadio = document.getElementsByName('cuocTtktFocus');
	for(var i = 0; i< allRadio.length; i++){
		if(allRadio[i].checked)
			return allRadio[i].value;
	}
	return '';
}
var cuocTtktId;
function validateForm(){
	if(!compareDate(document.getElementsByName('tu_ngay')[0], document.getElementsByName('den_ngay')[0]))
		return false;
	if(!compareDate(document.getElementsByName('thoiGianDuKienTuNgay')[0], document.getElementsByName('thoiGianDuKienDenNgay')[0]))
		return false;
	return true;
}
function addNew(){
	window.location = 'cuoc_ttkt.do?method=add'; 
}
function copy(){
	cuocTtktId = getSelectedCuocTtktId();
	if(cuocTtktId == null || cuocTtktId == '' ){
		alert('Ch\u01B0a ch\u1ECDn b\u1EA3n ghi n\u00E0o!');
		return;
	}
	window.location = 'cuoc_ttkt.do?method=copy&cuocTtktId='+ cuocTtktId;    
}	 

function sua(){ 
	cuocTtktId = getSelectedCuocTtktId();
	if(cuocTtktId == null || cuocTtktId == '' ){
		alert('Ch\u01B0a ch\u1ECDn b\u1EA3n ghi n\u00E0o!');
		return;
	}
	window.location = 'cuoc_ttkt.do?method=edit&cuocTtktId='+ cuocTtktId;
}
function viewThisItem(control){
	
	cuocTtktId = control.value;
	document.forms[0].elements['cuocTtktFocus'].value = cuocTtktId;
}
function xoa(){
	cuocTtktId = getSelectedCuocTtktId();
	if(cuocTtktId == null || cuocTtktId == '' ){
		alert('Ch\u01B0a ch\u1ECDn b\u1EA3n ghi n\u00E0o!');
		return;
	}
	document.forms[0].action = 'ke_hoach_nam.do?method=delete&cuocTtktId = '+ cuocTtktId;
	document.forms[0].submit();
			
}
	
</script>