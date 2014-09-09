<%@page pageEncoding="UTF-8" %>
<%@ include file="/top_bar.jsp"%>
<logic:present name="Action error">
	<script language="javascript">
		var actionError = '<%=request.getAttribute("Action error")%>'
		alert(actionError);
	</script>   
</logic:present>
<%@page import="cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt"%>
<script type="text/javascript" src="<html:rewrite page='/include/js/ttkt/tim_kiem.js'/>"></script>
<h3 class="Header"><%=(String)request.getAttribute("header")%></h3>
<%if(cmc.com.ktnb.util.Constants.MSG_KHG_XOA.equals((String)request.getAttribute("Action status"))){%>
<script language="javascript">
		alert('<%=cmc.com.ktnb.util.Constants.MSG_KHG_XOA%>');
	</script>
<%}%>
<html:form action="sua_ke_hoach_nam.do">
	<fieldset style="margin: 5px"><legend><bean:message key="label.thong_tin_tim_kiem" /></legend>
	<table width="100%" align="center" cellspacing="5">
		<tr>
			<td align="right" width="19%"><bean:message key="label.ma_cuoc_ttkt" /></td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="ma_cuoc_ttkt" style="width: 100%" /></td>
			<td align="right" width="19%"><bean:message key="label.don_vi_duoc_ttkt" /></td>
			<td align="right" width="1%"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="don_vi_duoc_ttkt" style="width: 100%" /></td>
		</tr>
		<tr>
			<td align="right">Thời kỳ: Từ ngày</td>
			<td align="right"></td>
			<td align="left"><html:text styleClass="text" property="tu_ngay" onblur="if(!isDate(this)) return; compareDate(this, document.getElementsByName('den_ngay')[0])" style="width: 100%" onkeypress="return formatDate(event,this);"></html:text></td>
			<td align="right"><bean:message key="label.den_ngay" /></td>
			<td align="right"></td>
			<td align="left"><html:text styleClass="text" property="den_ngay" onblur="if(!isDate(this)) return; compareDate(document.getElementsByName('tu_ngay')[0], this)" style="width: 100%" onkeypress="return formatDate(event,this);">
			</html:text></td>
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
					<td align="left" width="45%" style="margin: 0"><html:text styleClass="text" property="thoiGianDuKienTuNgay" onkeypress="return formatDate(event,this);" onblur="if(!isDate(this)) return; if(!compareDate(this, document.getElementsByName('thoiGianDuKienDenNgay')[0]))this.focus();" /></td>
					<td width="10%" align="center" style="text-align: center; margin: 0">-</td>
					<td align="right" width="45%" style="margin: 0"><html:text styleClass="text" styleClass="text" property="thoiGianDuKienDenNgay" onkeypress="return formatDate(event, this);"
						onblur="if(!isDate(this)) return; if(!compareDate(document.getElementsByName('thoiGianDuKienTuNgay')[0], this)) this.focus();" /></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td align="right">Loại</td>
			<td align="right"></td>
			<td align="left"><html:select property="loaiCuocTtktSuaKH" style="width: 100%">
				<html:option value="tat_ca">Tất cả</html:option>
				<html:option value="ke_hoach_nam">Kế hoạch năm được duyệt</html:option>
				<html:option value="ke_hoach_chinh_sua">Kế hoạch năm</html:option>
				<html:option value="bo_sung">Bổ sung</html:option>
				<html:option value="sua">Sửa</html:option>
				<html:option value="xoa">Xóa</html:option>
			</html:select></td>
			<td></td>
			<td></td>
			<td><%@ include file="/ttkt/dung_chung/tim_kiem.jsp"%></td>
		</tr>
	</table>
	</fieldset>
	<Fieldset style="margin: 5px"><legend><%=request.getAttribute("countResult")%> Kết quả</legend>
	<table width="100%" align="center">
		<tr class="TdHeaderListOfSearch">
			<td width="9%">Mã</td>
			<td align="left" width="12%">Đơn vị tiến hành</td>
			<td align="left" width="12%">Đơn vị được kiểm tra</td>
			<td width="14%">Niên độ</td>
			<td align="center" width="11%">Thời gian</td>
			<td width="8%">Loại</td>
			<td width="7%">Cuộc TTKT gốc</td> 
			<td align="left" width="10%">Trạng thái</td>
			<td align="center" width="5%">Chọn</td>
		</tr>
		<logic:iterate id="cuocTTKT" name="dscttkt" property="data" indexId="index">
			<tr class='row<%=(index.intValue() % 2)+1 %>'>
				<td><A href="#" onclick="window.open('cuoc_ttkt.do?method=view&cuocTtktId=<bean:write name="cuocTTKT" property="id"/>');"> <bean:write name="cuocTTKT" property="ma" /> </A></td>
				<td><bean:write name="cuocTTKT" property="tenDonViTh" /></td>
				<td><bean:write name="cuocTTKT" property="tenDonViBi" /></td>
				<td><script language="javascript">
						document.write('<bean:write name="cuocTTKT" property="nienDoTuNgayStr"/>' + '-' + '<bean:write name="cuocTTKT" property="nienDoDenNgayStr"/>');
					</script></td>
				<td><script language="javascript">
						document.write('<bean:write name="cuocTTKT" property="thoiGianDuKienTuNgayStr"/>'.substring(0,5) + '-' + '<bean:write name="cuocTTKT" property="thoiGianDuKienDenNgayStr"/>');
					</script></td>
				<td><logic:notEqual name="cuocTTKT" property="loaiCuocTtktKeHoachNam" value="Ke hoach nam">
					<logic:equal name="cuocTTKT" property="loaiCuocTtktKeHoachNam" value="KHN">							 			
							Kế hoạch năm				
						</logic:equal>
					<logic:equal name="cuocTTKT" property="loaiCuocTtktKeHoachNam" value="TD">
							Thay đổi 
						</logic:equal>
					<logic:equal name="cuocTTKT" property="loaiCuocTtktKeHoachNam" value="BS">
							Bổ sung
						</logic:equal>
					<logic:notEqual name="cuocTTKT" property="loaiCuocTtktKeHoachNam" value="KHN">
						<logic:notEqual name="cuocTTKT" property="loaiCuocTtktKeHoachNam" value="TD">
							<logic:notEqual name="cuocTTKT" property="loaiCuocTtktKeHoachNam" value="BS">
								<script language="javascript">
										document.write('<bean:write name="cuocTTKT" property="loaiCuocTtktKeHoachNam"/>');
									</script>
							</logic:notEqual>
						</logic:notEqual>
					</logic:notEqual>
				</logic:notEqual></td>
				<td><logic:present name="cuocTTKT" property="idCuocKhCu">
					<A href="#" onclick="xemCuocTtktGoc('<bean:write name="cuocTTKT" property="idCuocKhCu"/>')">Xem</A>
				</logic:present></td>
				<td align="left"><bean:write name="cuocTTKT" property="trangThai" /></td>
				<td align=center><html:radio property="cuocTtktFocus" value='<%=((TtktKhCuocTtkt)cuocTTKT).getId()%>' onclick="viewThisItem(this)">
				</html:radio></td>
			</tr>
		</logic:iterate>
	</table>
	<DIV style="text-align: center; width: 100%" align="center"><bean:write name="dscttkt" property="navigationBar" filter="false" /></DIV>
	</fieldset>
	<DIV style="display: none;" id="divDuyet"><br>
	<div style="text-align: left;" align="left"><a href="#" onclick="duyetKeHoachNam()">Xem thông tin duyệt kế hoạch</a></div>
	</DIV>
	<logic:present name="duyet">
		<script language="javascript">
			document.getElementById('divDuyet').style.display = 'none';
		</script>
	</logic:present>
	<BR>
	<div style="text-align: center;margin-bottom: 5px"><INPUT type="button" class="button" id="add" value="Điều chỉnh tăng" onclick="addNew()" /> <INPUT type="button" class="button" id="copy" value="Sao chép" onclick="copyxxxxx()"> <INPUT type="button" class="button" id="sua"
		value="Sửa" onclick="suaxxxxxxxxx()" disabled="disabled"> <INPUT type="button" class="button" id="xoa" value="Điều chỉnh giảm" onclick="xoaxxxxxxxxxx()"> <INPUT type="button" class="button" value="Đóng" onclick="window.location = 'ttkt_index.do';"></div>
	<html:hidden property="namKeHoach" />
</html:form>
<%@ include file="/bottom.jsp"%>
<script language="javascript">	
	function xemCuocTtktGoc(idCuocTtktGoc){
		window.open('cuoc_ttkt.do?method=view&cuocTtktId=' + idCuocTtktGoc);
	}
	function duyetKeHoachNam(){
		newWindow = window.open('duyet_ke_hoach.do');
		newWindow.focus();
	}
	function suaKHNam(){
		window.location = 'sua_ke_hoach_nam.do';	
	}
	function selfSearch(){
		//strAction = window.location.href.substring(window.location.href.lastIndexOf('/')).split('?')[0];
		document.forms[0].action = window.location.href;
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
	
	function addNew(){
		newWinDow = window.open('cuoc_ttkt.do?method=add&type=dinhky&thoiDiem=suaKeHoachNam'+'&nam=' + document.getElementsByName('namKeHoach')[0].value);
		newWinDow.focus();
	}
	function copyxxxxx(){
		cuocTtktId = getSelectedCuocTtktId();
		if(cuocTtktId == null || cuocTtktId == '' ){
			//alert('Chưa chọn cuộc Thanh tra Kiểm tra nào!');
			alert('Chưa chọn cuộc Kiểm tra nào!');
			return;
		}		
		var win = window.open('cuoc_ttkt.do?method=copy&thoiDiem=suaKeHoachNam&cuocTtktId='+ cuocTtktId + '&type=dinhky'+'&nam=' + document.getElementsByName('namKeHoach')[0].value);
		win.focus();
	}	 

	function suaxxxxxxxxx(){ 
		cuocTtktId = getSelectedCuocTtktId();
		if(cuocTtktId == null || cuocTtktId == '' ){
			alert('Chưa chọn bản ghi nào!');
			return;
		}
		var win = window.open('cuoc_ttkt.do?method=edit&thoiDiem=suaKeHoachNam&cuocTtktId='+ cuocTtktId);
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
		document.forms[0].action = 'sua_ke_hoach_nam.do?method=delete&thoiDiem=suaKeHoachNam&cuocTtktId = '+ cuocTtktId;
		document.forms[0].submit();				
	}
	function validateForm(){
		return true;
	}
</script>
