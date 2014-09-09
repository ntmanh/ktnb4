<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%>   
<%@page import="cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt"%>
<script type="text/javascript" src="<html:rewrite page='/include/js/ttkt/tim_kiem.js'/>"></script>
<html:form action="ke_hoach_nam.do">
	<h3 class="Header"><%=(String)request.getAttribute("header")%> <html:select property="namKeHoach" onchange="changeNamKeHoach(this)" style="width: 50;">
		<html:options collection="lisOfNam" property="value" labelProperty="label" />
	</html:select> </h3>
	<%if(cmc.com.ktnb.util.Constants.MSG_KHG_XOA.equals((String)request.getAttribute("Action status"))){%>
	<script language="javascript">
		alert('<%=cmc.com.ktnb.util.Constants.MSG_KHG_XOA%>'); 
	</script>
	<%}%>
	<fieldset style="margin: 5px"><legend><bean:message key="label.thong_tin_tim_kiem" /> </legend>
	<table width="100%" align="center" cellspacing="3">
		<tr>
			<td align="right" width="19%"><bean:message key="label.ma_cuoc_ttkt" /></td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="ma_cuoc_ttkt" style="width: 100%">
			</html:text></td>
			<td align="right" width="19%"><bean:message key="label.don_vi_duoc_ttkt" /></td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="don_vi_duoc_ttkt" style="width: 100%" /></td>
		</tr>
		<tr>
			<td align="right">Thời kỳ: Từ ngày</td>
			<td align="right"></td>
			<td align="left"><html:text styleClass="text" property="tu_ngay" onblur="if(!isDate(this)) return; compareDate(this, document.getElementsByName('den_ngay')[0])" onkeypress="return formatDate(event,this);" style="width: 100%"></html:text></td>
			<td align="right"><bean:message key="label.den_ngay" /></td>
			<td align="right"></td>
			<td align="left"><html:text styleClass="text" property="den_ngay" onblur="if(!isDate(this)) return; compareDate(document.getElementsByName('tu_ngay')[0], this)" onkeypress="return formatDate(event,this);" style="width: 100%" /></td>
		</tr>
		<tr>
			<td align="right">Thời gian dự kiến</td>
			<td align="right"></td>
			<td align="left"><html:text styleClass="text" style="width: 40" property="thoiGianDuKien" onkeypress="return formatInt(event);" onblur="if(!isNumber(this, 'i')) return;" /> Ngày</td>
			<td align="right">Từ ngày - đến ngày</td>
			<td align="right"></td>
			<td align="left">
			<table style="margin: 0" border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
				<tr>
					<td align="left" width="45%" style="margin: 0"><html:text styleClass="text" property="thoiGianDuKienTuNgay" onkeypress="return formatDate(event,this);" onblur="if(!isDate(this)) return; compareDate(this, document.getElementsByName('thoiGianDuKienDenNgay')[0]);" /></td>
					<td width="10%" align="center" style="text-align: center; margin: 0">-</td>
					<td align="right" width="45%" style="margin: 0"><html:text styleClass="text" styleClass="text" property="thoiGianDuKienDenNgay" onkeypress="return formatDate(event, this);" onblur="if(!isDate(this)) return; compareDate(document.getElementsByName('thoiGianDuKienTuNgay')[0], this);" /></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td width="19%" align="right"></td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%"></td>
			<td width="19%" align="right">Sắp xếp</td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%">
					<html:select property="sapXep" style="width: 100%">
						<html:option value="TangThoiGian">Tăng theo thời gian thực hiện</html:option>
						<html:option value="GiamThoiGian">Giảm theo thời gian thực hiện</html:option>
						<html:option value="TangThuTu">Tăng theo thứ tự cuộc TTKT</html:option>						
						<html:option value="GiamThuTu">Giảm theo thứ tự cuộc TTKT</html:option>
					</html:select>
			</td>
		</tr>
		<tr>
			<!-- <td align="right"><bean:message key="label.hinh_thuc" /></td>
			<td align="right">
			<td align="left"><html:select styleClass="combobox"
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
			</html:select></td> -->
			<td></td>
			<td></td>
			<td></td>
			<td align="right"></td>
			<td align="right"></td>
			<td align="left"><%@ include file="/ttkt/dung_chung/tim_kiem.jsp"%></td>
		</tr>
	</table>
	</fieldset>
	<Fieldset style="margin: 5px"><legend><bean:message key="label.ket_qua_tim_kiem" /> </legend>
	<table width="100%" align="center" id="tblKqTimKiem">
		<tr class="TdHeaderListOfSearch">
			<td align="center" width="10%">Mã</td>
			<td align="left" width="15%">Đơn vị tiến hành</td>
			<td align="left" width="15%">Đơn vị được kiểm tra</td>
			<td width="16%">Thời kỳ</td>
			<td align="center" width="8%">Thời gian</td>
			<td align="center" width="15%">Từ ngày - đến ngày</td>
			<td align="left" width="16%">Trạng thái</td>
			<td align="center" width="5%">Chọn</td>
		</tr>
		<logic:iterate id="cuocTTKT" name="dscttkt" property="data" indexId="index">
			<tr class='row<%=(index.intValue() % 2)+1 %>'>
				<td><A href="#" onclick="window.open('cuoc_ttkt.do?method=view&cuocTtktId=<bean:write name="cuocTTKT" property="id"/>');"> <bean:write name="cuocTTKT" property="ma" /> </A></td>
				<td align="left"><bean:write name="cuocTTKT" property="tenDonViTh" /></td>
				<td align="left"><bean:write name="cuocTTKT" property="tenDonViBi" /></td>
				<td><script language="javascript">
						document.write('<bean:write name="cuocTTKT" property="nienDoTuNgayStr"/>' + '-' + '<bean:write name="cuocTTKT" property="nienDoDenNgayStr"/>');
					</script></td>
				<td><script language="javascript">
						document.write('<bean:write name="cuocTTKT" property="thoiGianDuKien"/>');
						document.write(' ngày');
					</script></td>
				<td><script language="javascript">
						document.write('<bean:write name="cuocTTKT" property="thoiGianDuKienTuNgayStr"/>'.substring(0,5) + '-' + '<bean:write name="cuocTTKT" property="thoiGianDuKienDenNgayStr"/>');
					</script></td>
				<td align="left"><bean:write name="cuocTTKT" property="trangThai" /></td>
				<td align=center><html:radio property="cuocTtktFocus" value='<%=((TtktKhCuocTtkt)cuocTTKT).getId()%>' onclick="viewThisItem(this)">
				</html:radio></td>
			</tr>
		</logic:iterate>
	</table>
	<DIV style="text-align: center; width: 100%" align="center"><bean:write name="dscttkt" property="navigationBar" filter="false" /></DIV>
	</fieldset>
	<DIV style="display: none;" id="divDuyet"><br>
	<div style="text-align: left;margin-left: 5px" align="left"><a href="#" onclick="duyetKeHoachNam()">Xem thông tin duyệt kế hoạch</a></div>
	</DIV>
	<logic:present name="duyet">
		<script language="javascript">
			document.getElementById('divDuyet').style.display = 'none';
		</script>
	</logic:present>
	<BR>
	<div style="text-align: center;padding-bottom: 15px"><INPUT type="button" class="button" id="add" value="Thêm" onclick="addNew()" /> <INPUT type="button" class="button" id="copy" value="Sao chép" onclick="copyxxxxx()"> <INPUT type="button" class="button" id="sua"
		value="Sửa" onclick="suaxxxxxxxxx()"> <INPUT type="button" class="button" id="xoa" value="Xóa" onclick="xoaxxxxxxxxxx()"> <INPUT type="button" class="button1" id="in" value="In kế hoạch" onclick="inKeHoachNam()"> <INPUT type="button" class="button"
		id="duyet" value="Duyệt" onclick="duyetKeHoachNam()"> <INPUT type="button" class="button" id="suaKH" value="Sửa kế hoạch năm" onclick="suaKHNam()"> <INPUT type="button" class="button" value="Đóng"
		onclick="window.location = 'ttkt_index.do';"></div>
	<html:hidden property="loai" />
</html:form>
<%@ include file="/bottom.jsp"%>
<script language="javascript">
	var nam;
	window.onload = function(){
		
		nam = document.getElementsByName('namKeHoach')[0].value;
		if(document.getElementById('duyet').style.display != 'none'){
			if(window.location.href.indexOf('ke_hoach_nam.do') > 0){

				$("#duyet").css("display", "inline");
			}	
			else{
				$("#duyet").css("display", "none");
				document.getElementById('in').value = 'In';
			}
			if(window.location.href.indexOf('ttkt_dot_xuat.do') > 0){
				$("#in").css("display", "none");
			}
		}
	}
	function changeNamKeHoach(namKeHoachCtr){		
		if(namKeHoachCtr.value.length != 4){
			alert('Năm phải có 4 chữ số'); 
			namKeHoachCtr.focus();
			return;
		}else{
			if(namKeHoachCtr.value != nam){
				nam = namKeHoachCtr.value;
				if(window.location.href.indexOf('ke_hoach_nam.do') >= 0){
					document.forms[0].action = "ke_hoach_nam.do";
				}else if(window.location.href.indexOf('ttkt_dot_xuat.do') >= 0){
					document.forms[0].action = "ttkt_dot_xuat.do";
				}		
				document.forms[0].submit();	
			}
		}
		
		
		
	}
	function duyetKeHoachNam(){
		newWindow = window.open('duyet_ke_hoach.do?nam=' + document.getElementsByName('namKeHoach')[0].value);
		newWindow.focus();
		//if(window.confirm(''));
		
	}
	function suaKHNam(){
		window.location = 'sua_ke_hoach_nam.do?nam=' + document.getElementsByName('namKeHoach')[0].value;
	}
	function selfSearch(){
		if(!isRequired(document.getElementsByName('namKeHoach')[0]))
			return;
		if(window.location.href.indexOf('ke_hoach_nam.do') >= 0){
			document.forms[0].action = "ke_hoach_nam.do";
		}else if(window.location.href.indexOf('ttkt_dot_xuat.do') >= 0){
			document.forms[0].action = "ttkt_dot_xuat.do";
		}		
		document.forms[0].submit();	
		
	}
	function inKeHoachNam(){
		
		document.forms[0].action = 'ke_hoach_nam.do?method=in';
		document.forms[0].submit();
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
	function duyet(){
		$("#add").css("display","none"); 
		$("#copy").css("display","none"); 
		$("#sua").css("display","none"); 
		$("#xoa").css("display","none"); 
		
		$("#duyet").css("display","none");
		$("#divDuyet").css("display","inline");
		$("#suaKH").css("display","inline");
		
	}
	function addNew(){
		if(window.location.href.indexOf('ke_hoach_nam.do') >= 0){
			newWinDow = window.open('cuoc_ttkt.do?method=add&type=dinhky&nam=' + document.getElementsByName('namKeHoach')[0].value);
			newWinDow.focus();
		}else{
			newWinDow = window.open('cuoc_ttkt.do?method=add&type=dotxuat&nam=' + document.getElementsByName('namKeHoach')[0].value);
			newWinDow.focus();
		}
	}
	function copyxxxxx(){
		cuocTtktId = getSelectedCuocTtktId();
		if(cuocTtktId == null || cuocTtktId == '' ){
			alert('Chưa chọn cuộc Thanh tra Kiểm tra nào!');
			return;
		}
		var strType;
		if(window.location.href.indexOf('ke_hoach_nam') >=0)
			strType = 'dinhky';
		else
			strType = 'dotxuat';			
		var win = window.open('cuoc_ttkt.do?method=copy&cuocTtktId='+ cuocTtktId + '&type=' + strType + '&nam=' + document.getElementsByName('namKeHoach')[0].value);
		win.focus();
	}	 

	function suaxxxxxxxxx(){ 
		cuocTtktId = getSelectedCuocTtktId();
		if(cuocTtktId == null || cuocTtktId == '' ){
			alert('Chưa chọn bản ghi nào!');
			return;
		}
		var win = window.open('cuoc_ttkt.do?method=edit&cuocTtktId='+ cuocTtktId);
		win.focus();
	}
	function viewThisItem(control){
		
		cuocTtktId = control.value;
		document.forms[0].elements['cuocTtktFocus'].value = cuocTtktId;
	}
	function xoaxxxxxxxxxx(){
		cuocTtktId = getSelectedCuocTtktId();
		if(cuocTtktId == null || cuocTtktId == '' ){
			alert('Chưa chọn bản ghi nào!');
			return;
		}
		if(window.location.href.indexOf('ke_hoach_nam') >=0)
			document.forms[0].action = 'ke_hoach_nam.do?method=delete&cuocTtktId = '+ cuocTtktId;
		else
			document.forms[0].action = 'ttkt_dot_xuat.do?method=delete&cuocTtktId = '+ cuocTtktId;
		document.forms[0].submit();
				
	}
	function validateForm(){
		if(!compareDate(document.getElementsByName('tu_ngay')[0], document.getElementsByName('den_ngay')[0]))
			return false;
		if(!compareDate(document.getElementsByName('thoiGianDuKienTuNgay')[0], document.getElementsByName('thoiGianDuKienDenNgay')[0]))
			return false;
		return true;
	}
	
</script>
<%
	if(request.getAttribute("duyet")!=null){%>
<script language="javascript">
			duyet();
		</script>
<%}else{%>
<script language="javascript">
			$("#suaKH").css("display","none"); 
		</script>
<%}
%>