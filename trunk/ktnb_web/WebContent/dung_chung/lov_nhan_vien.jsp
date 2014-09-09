<%@page pageEncoding="UTF-8" %>
<%@ include file="/top.jsp"%>
<BODY>

<script language="javascript">   
	var tenCqtVaChuVu = '';
</script>
<logic:present name="tenCqtvaChucVu"> 
	<script language="javascript">
		tenCqtVaChuVu = '<%=(String)request.getAttribute("tenCqtvaChucVu")%>'
	</script>	
</logic:present>
<script language="javascript"> 
function setReturn(tenCqtVaChuVu){
	ma = tenCqtVaChuVu.split('&')[0];
	ten = tenCqtVaChuVu.split('&')[1];
	chucVu = tenCqtVaChuVu.split('&')[2];
	tenPhong = tenCqtVaChuVu.split('&')[3];
	tenCqt = tenCqtVaChuVu.split('&')[4];								
	error = window.opener.setThongTinNhanVienFromLov(ma, ten, chucVu, tenPhong, tenCqt);
	if(!isEmpty(error)){
		alert(error);
	}else{
	var type = '<%=request.getAttribute("type")%>';
	if(type!="view"){
		window.close();
		}
	}
}
window.onload = function(){
	if(!isEmpty(tenCqtVaChuVu)){
		setReturn(tenCqtVaChuVu);			
		
	}
}
function getTenPhongByMa(maPhong){
		cbMaPhong = document.getElementsByName('maPhong')[0];
		if(cbMaPhong == null)
			return;
		for(i = 0; i < cbMaPhong.length; i++){
			if(cbMaPhong[i].value == maPhong)
				return cbMaPhong[i].text;
		}
		return 'Khong tim thay';
	}
</script>
<html:form action="tim_kiem_canBo.do" styleId="theForm">
	<%String select = request.getParameter("select");%>
	<fieldSet style="width: 595; text-align: center;">		
	<fieldSet style="text-align: center;width: 590;"><legend><bean:message key="label.thong_tin_tim_kiem" /></legend>
	<TABLE width="99%">
		<html:hidden property="searchCqtTrucThuoc"/>
		<logic:present name="dsCqtTrucThuoc">
				<tr>
					<td width="18%" align="right">Cơ quan thuế trực thuộc</td>
					<td width="2%" style="min-width: 5"></td>
					<td width="30%" align="left">
						<html:select name = "LovNhanVienForm" property="maCqtTrucThuoc" styleId="maCqtTrucThuoc" style="width: 170" onchange="changCqt()">
							<html:option value = ""></html:option>
							<html:options collection="dsCqtTrucThuoc" property="ma" labelProperty="ten" />
						</html:select>
					</td>			
					<td width="18%" align="right"></td>
					<td width="2%" style="min-width: 5"></td>
					<td width="30%" align="left"></td>
				</tr>
			</logic:present>	
		
		<tr>
			<td width="18%" align="right">Phòng</td>
			<td width="2%" style="min-width: 5"></td>
			<td width="30%" align="left">
				<html:select name = "LovNhanVienForm" property="maPhong" style="width: 170">
					<html:option value = ""></html:option>
					<html:options collection="dsPhongBanTrucThuoc" property="id"
						labelProperty="name" />
				</html:select>
			</td>
			
			<td width="18%" align="right">Họ tên</td>
			<td width="2%" style="min-width: 5"></td>
			<td width="30%" align="left"><html:text name = "LovNhanVienForm" property="tenNhanVien" styleClass="text">
			</html:text></td>
		</tr>
		
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td align="left">
				<%@ include file="/ttkt/dung_chung/tim_kiem.jsp"%>
			</td>
		</tr>
	</table>
	</fieldSet>
	<fieldset style="width: 590; text-align: center;"><legend> <bean:message
		key="label.ket_qua_tim_kiem" /></legend>
	<DIV style="width: 100%; overflow: auto; height: 250">
		<table width="99%" align="center">
		<tr class="TdHeaderList">
			<td width="25%">Mã nhân viên</td>

			<td width="35%">Tên nhân viên</td>
			<td width="40%">Phòng</td>
		</tr>
		<logic:present name="dsNhanVien" >
			<logic:present name="dsNhanVien" property="data">
			<logic:iterate id="nhanVien" name="dsNhanVien"
				property="data" indexId="index">
				<%if (index.intValue() % 2 == 0) {%>
				<tr class="row1">
					<%} else {%>
				<tr class="row2">
					<%}%>
					<!--Ma nhan vien-->
					<td align="left" width="20%">
						<A href="#" onclick="chonCanBo('<bean:write name="nhanVien" property="ma"/>');">
							<bean:write name="nhanVien" property="ma"/>
						</A> 
					</td>
					<!--Ten nhan vien-->
					<td align="left" width="20%">
						<bean:write name="nhanVien" property="ten"/>
					</td>
					<!--Phong-->
					<td align="left" width="20%">
						<script language = "javascript">
							document.write(getTenPhongByMa('<%=(String)((cmc.com.ktnb.pl.hb.entity.KtnbDmCanbo)nhanVien).getMaPhong()%>'));						
						</script>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
		</logic:present>
		
		<logic:present name="dsNhanVien">
			<tr>
				<td colspan="3" align="center"><bean:write name="dsNhanVien"
					property="navigationBar" filter="false" /></td>
			</tr>
		</logic:present>
	</TABLE>
	</DIV>
	
	</fieldset>
	</fieldSet>
	<fieldSet style="text-align: center; width: 595;">
		<legend>
		</legend>
		<INPUT type="button" onclick="window.close()" value="Đóng">	
	</fieldSet>
	<html:hidden property="maNhanVien"/>
	<html:hidden property="chucVu"/>	
	<html:hidden property="tenPhong"/>
	<html:hidden property="maCqt"/>
	<html:hidden property="tenCqt"/>	
	<html:hidden property="isNSD"/>
	<html:hidden property="cqtt"/>
</html:form>
</BODY>
<script language="javascript">		
	function selfSearch(){
		if($('#searchCqtTrucThuoc').length >0){
			if($('#maCqtTrucThuoc').val().trim().length ==0){
				alert('Bạn phải nhập cơ quan thuế');
				$('#maCqtTrucThuoc').focus();
				return;
			}
			
		}
		document.forms[0].action += '?method=search';
		document.forms[0].submit();
	}
	function selectCqtTrucThuoc(){
		document.forms[0].action += '?method=loadCqtTrucThuoc';
//		$('#theForm').action += '?method=loadCqtTrucThuoc';
//		alert($('#theForm').action);
		document.forms[0].submit();
	}
	function changCqt(){
				document.forms[0].action += '?method=selectCqtTrucThuoc';
				document.forms[0].submit();
	}
	function selectCanBo(ma, ten, maPhong){ 
		document.getElementsByName('maNhanVien')[0].value = ma;
		document.getElementsByName('tenNhanVien')[0].value = ten;		
		document.forms[0].action = 'tim_kiem_canBo.do?method=searchThongTinCanBo&idCanBo=' + ma;
		document.forms[0].submit();
		
	}
	function setThongTinTVD(ma, ten){
		idCanBo = ma;
		tenCanBo = ten;
		chucVu = "";
		maPhongControl = document.forms[0].elements['maPhong'];
		idPhong = maPhongControl.value;
		selectedIndex = maPhongControl.selectedIndex;
		
		tenPhong = maPhongControl[selectedIndex].text;
		window.opener.setThongTinTVD(idCanBo, tenCanBo, chucVu, idPhong, tenPhong)
	}
	function setThanhVienDoan(ma, ten){
		window.opener.getTruongDoan(ma, ten);
		window.close();
	}
	function validateForm(){
		return true;
	}
	function changeCqt(parentId){
		document.forms[0].elements['maCqtChon'] = parentId;
		document.forms[0].action = 'tim_kiem_cqt.do?method=changeCqt';				
		document.forms[0].submit();
	}
	function selectNhanVien(ma, ten){	
		window.opener.setNhanVien(ma, ten);
		window.close();		
	}
	function setThongTinTVD(){
	}
	function selectAll(){
	} 
	function chonCanBo(ma){
		var xmlHttpReq = false;
	    if (window.XMLHttpRequest) {
	        xmlHttpReq = new XMLHttpRequest(); 
	    }
	    else if (window.ActiveXObject) {
	        xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	    } 
	    xmlHttpReq.open('POST', 'tim_kiem_canBo.do?method=chonCanBo&idCanBo=' + ma, true); 
	    xmlHttpReq.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=UTF-8");   
	    xmlHttpReq.onreadystatechange = function(){
	    	if (xmlHttpReq.readyState==4 && xmlHttpReq.status==200){
	    		setReturn(xmlHttpReq.responseText); 
				
	    	}
	    } 
	    xmlHttpReq.send();
	}
	
	
</script>

