<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="chuan_bi_tien_hanh.do?method=save&type=dc" method="POST" enctype="multipart/form-data" styleId="deCuongForm">
	<div id="getReturnDc" style="display: none;"></div>
	<table align="center" width="100%">
		<tr>
			<td align="right" width="19%">Địa điểm lập <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="noiLapDeCuong"></html:text></td>
			<td align="right" width="19%">Ngày lập <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" width="30%"><html:text styleClass="text" property="ngayLapDeCuong" onblur="if(!isDate(this)) return; validateNgayLapDeCuong()" onkeypress="return formatDate(event, this)"></html:text></td>
		</tr>
		<tr>
			<td align="right" width="19%">Báo cáo phải chuẩn bị cung cấp <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4"><html:textarea property="bcPhaiCbiCungCap" onkeypress="imposeMaxLength(this);"  styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<tr>
			<td align="right" width="19%">Hồ sơ tài liệu phải chuẩn bị và cung cấp <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px"></td>
			<td colspan="4"><html:textarea property="hsPhaiCbiCungCap" onkeypress="imposeMaxLength(this);"  styleClass="textareaTitle"></html:textarea></td>
		</tr>
		<!--Nhung van de khac-->
		<tr>			
			<td align="left" colspan="6">
				<fieldset> <legend>Những vấn đề khác</legend>
					<html:textarea styleClass="textareaContent" onkeypress="imposeMaxLength(this);"  style="width: 100%" property="nhungVanDeKhac"></html:textarea>
				</fieldset>
			</td>			
		</tr>
		<tr>
			<td colspan="5"></td>
			<td align="right"><INPUT type="button" class="button1" value="In đề cương" onclick="inDeCuong()"></td>
		</tr>
	</table>
	<table width="100%">
		<!-- <tr>
			<td align="right" width="19%">Đính kèm file</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" colspan="4"><logic:present name="ChuanBiTienHanhForm" property="maFileDeCuong">
				<input type="checkbox" style="margin: 0" onclick="checkAttackDeCuong()" checked id="checkAttackFileDC" />
			</logic:present> <logic:notPresent name="ChuanBiTienHanhForm" property="maFileDeCuong">
				<input type="checkbox" style="margin: 0" onclick="checkAttackDeCuong()" id="checkAttackFileDC" />
			</logic:notPresent></td>
		</tr> --> 
		<tr>
			<td colspan="6" width="100%">
			<fieldset>
			<table width="100%">
				<!--<logic:notPresent name="readOnly">-->
				<tr>
					<td align="right" width="49%">Download biểu mẫu</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><A href="filemau/TTNB13.doc"> <font color=blue>Download File</font> </A></td>
				</tr>
				<!--</logic:notPresent>-->
				<!--<logic:present name="ChuanBiTienHanhForm" property="maFileDeCuong">
					<tr>
						<td align="right" width="49%">File đính kèm</td>
						<td style="width: 2%; min-width: 5px;"></td>
						<td align="left" width="49%"><a href="#" onclick="window.open('UploadAction.do?method=downLoadDeCuongTtkt&ma_file='+document.getElementsByName('maFileDeCuong')[0].value).focus()"><font color="blue">Đề cương Thanh tra Kiểm tra</font></a></td>
					</tr>
				</logic:present>
				<logic:notPresent name="readOnly">
					<tr>
						<td align="right" width="49%">
						<logic:present name="ChuanBiTienHanhForm" property="maFileDeCuong">
									Cập nhật file đính kèm
						</logic:present> 
						<logic:notPresent name="ChuanBiTienHanhForm" property="maFileDeCuong">
									File đính kèm
						</logic:notPresent></td>
						<td style="width: 2%; min-width: 5px;"></td>
						<td align="left" width="49%">
						<html:file name="ChuanBiTienHanhForm" property="fileDinhKemDeCuong"></html:file>						
						</td>
					</tr>
				</logic:notPresent>-->
				<tr>
					<td align="right" width="49%">File đề cương</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><A href="#" onclick="openUploadFile();"><font color=blue>File "đề cương" đính kèm</font></A></td>
				</tr>
			</table>
			</fieldset>
			</td>
		</tr>
	<div id="Contents" style="display: none; width: 200px; height: 100px; position: absolute;">
	<textarea id="Area" rows="3" cols="50" onkeypress="imposeMaxLength(this);"  onblur="changeContents(this);"></textarea></div>
	</table>
	<html:hidden property="idDecuong" /> 
	<html:hidden property="isChangeDeCuong" /> 
	<html:hidden property="idBaoCaoPhaiCbiCungCap_DC" /> 
	<html:hidden property="idHstlPhaiCbiCungCap_DC" /> 
	<html:hidden property="idDsTvdLapDeCuong" /> 
	<html:hidden property="maFileDeCuong" /> 
	<html:hidden property="isAttackDeCuong" /> 
		<html:select property="dsTvdLapDeCuong" style="display: none;">
		<%--<html:option value=""></html:option>--%>
		<html:options collection="dsTvdLapDeCuong" property="idCanBo" labelProperty="tenCanBo" />
	</html:select>
</html:form>
<script>
	var contextRoot = document.forms[0].action.split('/')[1];
	function openUploadFile(){
		var view='';
		var method = '<%=request.getParameter("method")%>';
		if(method == 'view') view = 'view';
		var r = '<%=request.getParameter("r")%>';
		if(r == 'rol') view = 'view';		
		var maHS = document.getElementsByName('idCuocTtkt')[0].value;
		openWindow("UploadAction.do?parentId="+maHS+"&nv=TTKT/DC&view="+view);		
	}
	function getTen(controlId){ 
		document.getElementsByName(controlId.name.replace('nguoiNhanId', 'nguoiNhanName'))[0].value = controlId[controlId.selectedIndex].text;
	}
	$(document).ready(function(){
 		var arr = $(".decuong");
 		for ( var i = 0; i < arr.length; i = i + 1 ) {
    		getTen(arr[i]);
		};
	});
	function downLoadBieuMauDeCuong(){
		//var fullPath = window.location.protocol + "//" + window.location.host + "" + window.location.pathname+""+window.location.search;		
		var thongTinQd = "";
		//var qdForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=qd');	 
		var qdForm = document.getElementById('quyetDinhForm');
		for(var i = 0; i< qdForm.elements.length; i++){
			if(qdForm.elements[i].name != null && qdForm.elements[i].name != '' && qdForm.elements[i].value != null && qdForm.elements[i].value != '')
			thongTinQd += qdForm.elements[i].name + "=" + encodeURIComponent(qdForm.elements[i].value) + "&";
		}		
		thongTinQd += 'idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
		//var printfForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=dc');	
		var printfForm =document.getElementById('deCuongForm');
		thongTinDc = "";
		for(var i = 0; i< printfForm.elements.length; i++){
			if(printfForm.elements[i].name != null 
			&& printfForm.elements[i].name != '' 
			&& printfForm.elements[i].name != 'fileDinhKemDeCuong' 
			&& printfForm.elements[i].value != null 
			&& printfForm.elements[i].value != '')
				thongTinDc += printfForm.elements[i].name + "=" + encodeURIComponent(printfForm.elements[i].value) + "&";				
		}
		console.log(printfForm);
		printfForm.action = 'chuan_bi_tien_hanh.do?method=in&type=bmdc&' + thongTinQd ;//+ '&' + thongTinDc;
		//alert(thongTinDc);
		printfForm.submit();
		printfForm.action = '/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=dc';
		//window.location = fullPath;
		//location.reload();
	}
	function checkAttackDeCuong(){
		if(document.getElementById('trDinhKemFileDC').style.display == 'inline')
			document.getElementById('trDinhKemFileDC').style.display = 'none';
		else
			document.getElementById('trDinhKemFileDC').style.display = 'inline';
	}
	function validateNgayLapDeCuong(){
		var thoi_gian_gia_han = '<%=request.getAttribute("thoi_gian_gia_han")%>';
		if(thoi_gian_gia_han!=null&&thoi_gian_gia_han!='null'&&thoi_gian_gia_han!=''&thoi_gian_gia_han!=' '){
		if(d2n(document.getElementsByName('ngayLapDeCuong')[0].value) < d2n(thoi_gian_gia_han)){
			alert('Cảnh báo: Ngày lập đề cương không được trước ngày ra hạn ('+thoi_gian_gia_han+')!');
			//document.getElementsByName('ngayLapDeCuong')[0].focus();
		}
		caculateDate('ngayRaQuyetDnh', 'truongGiuNgayTam', strNgayLapDeCuong);
		if(d2n(document.getElementsByName('ngayLapDeCuong')[0].value) > d2n(document.getElementsByName('truongGiuNgayTam')[0].value)){			
			alert('Cảnh báo quá hạn: Đề cương lập sau quyết định quá '+ strNgayLapKeHoach + ' ngày!');
		}
		}
	}
	function inDeCuong(){ 
		if(!validateInDeCuong())        
			return;
		var thongTinQd = "";
		var qdForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=qd');	 
		for(var i = 0; i< qdForm.elements.length; i++){
			if(qdForm.elements[i].name != null && qdForm.elements[i].name != '' && qdForm.elements[i].value != null && qdForm.elements[i].value != '')
			thongTinQd += qdForm.elements[i].name + "=" + encodeURIComponent(qdForm.elements[i].value) + "&";
		}		
		thongTinQd += 'idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
		var printfForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=dc');	
		thongTinDc = "";
		for(var i = 0; i< printfForm.elements.length; i++){
			if(printfForm.elements[i].name != null && printfForm.elements[i].name != '' && printfForm.elements[i].name != 'fileDinhKemDeCuong' && printfForm.elements[i].value != null && printfForm.elements[i].value != '')
				thongTinDc += printfForm.elements[i].name + "=" + encodeURIComponent(printfForm.elements[i].value) + "&";
		}
		printfForm.action = 'chuan_bi_tien_hanh.do?method=in&type=dc&' + thongTinQd;// + '&' + thongTinDc;
		printfForm.submit();
		printfForm.action = '/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=dc'; 
	}
	function selectAllBaoCao(chkBxSelectAll){
		bangBaoCao.selectAllRow();
	}
	function selectBaoCao(chckBox){
	}	
	function selectHsTl(chckBox){ 
	}	
	var bangBaoCao = new TableObject('tblBaoCao', false, 'xoaTblBaoCao');
	var index = 0;	
	function themBaoCao(){
		bangBaoCao.addRow(createNewBaoCaoRow());
		try{
			var strThoiGianBanGiao = document.getElementsByName("dsBaoCao[" + eval(index-1) + "].strThoiGianBanGiao")[0].value;
			document.getElementsByName("dsBaoCao[" + eval(index) + "].strThoiGianBanGiao")[0].value = strThoiGianBanGiao;
			
			var oldObj =  document.getElementsByName("dsBaoCao[" + eval(index-1) + "].nguoiNhanId")[0];
			var curObj =  document.getElementsByName("dsBaoCao[" + eval(index) + "].nguoiNhanId")[0];
			curObj[oldObj.selectedIndex].selected = "selected";
		}catch(Exception){}
	}
	
	function xoaBaoCao(){
		bangBaoCao.deleteSelectedRow();
	}	
	function createNewBaoCaoRow(){		
		arrNewBaoCaoRow = new Array();
		index = bangBaoCao.numOfRow - 1;
		arrNewBaoCaoRow[0] = '<input type="text" id="ten' + index +'" name="dsBaoCao[' + index + '].ten" class="text1" onclick="showContents(event);">'												
		arrNewBaoCaoRow[1] = '<input type="text" id="noiDung' + index +'" name="dsBaoCao[' + index + '].noiDung" class="text1" onkeypress="showContents(event);" onchange="showContents(event);" onclick="showContents(event);" >'									
		arrNewBaoCaoRow[2] = '<input type="text" style = "width:65" onkeypress="return formatDate(event, this)" onblur="isDate(this)" name="dsBaoCao[' + index + '].strThoiKyTu" class="text1" > - '						
		arrNewBaoCaoRow[2] += '<input type="text" style = "width:65" onkeypress="return formatDate(event, this)" onblur="isDate(this)" name="dsBaoCao[' + index + '].strThoiKyDen" class="text1" >'						
		arrNewBaoCaoRow[3] = '<input type="text" name="dsBaoCao[' + index + '].hinhThuc" class="text1" >'						
		arrNewBaoCaoRow[4] = '<input type="text" onkeypress="return formatDate(event, this)" onblur="isDate(this)" name="dsBaoCao[' + index + '].strThoiGianBanGiao" class="text1" >'						
		arrNewBaoCaoRow[5] = '<input type="text" name="dsBaoCao[' + index + '].diaDiemNhanName" class="text1" value = "' + document.getElementsByName('diaDiem')[0].value + '">'						
		arrNewBaoCaoRow[6] = '<select name = "dsBaoCao[' + index + '].nguoiNhanId" onchange="getTen(this)">'
		arrNewBaoCaoRow[6] += document.getElementsByName('dsTvdLapDeCuong')[0].innerHTML;
		arrNewBaoCaoRow[6] += '</select>'		
		arrNewBaoCaoRow[6] += '<INPUT type="hidden" name="dsBaoCao[' + index + '].nguoiNhanName">'
		arrNewBaoCaoRow[7] = '<INPUT type="checkbox" onclick="selectBaoCao(this)">'	
		return arrNewBaoCaoRow;
	}
	var bangHsTl = new TableObject('tblHsTl', false, 'xoaTblHsTl');
	function themHoSoTl(){
		bangHsTl.addRow(createNewHsTlRow());
		try{
			var strThoiGianBanGiao = document.getElementsByName("dsHoSoTl[" + eval(index-1) + "].strThoiGianBanGiao")[0].value;
			document.getElementsByName("dsHoSoTl[" + eval(index) + "].strThoiGianBanGiao")[0].value = strThoiGianBanGiao;
			
			var oldObj =  document.getElementsByName("dsHoSoTl[" + eval(index-1) + "].nguoiNhanId")[0];
			var curObj =  document.getElementsByName("dsHoSoTl[" + eval(index) + "].nguoiNhanId")[0];
			curObj[oldObj.selectedIndex].selected = "selected";
			getTen(document.getElementsByName("dsHoSoTl[" + eval(index) + "].nguoiNhanId")[0]);
			//alert(document.getElementsByName("dsHoSoTl[" + eval(index) + "].nguoiNhanName")[0].value);
		}catch(Exception){}
	}  
	
	function createNewHsTlRow(){
		arrNewHsTlRow = new Array();
		index = bangHsTl.numOfRow - 1;
		arrNewHsTlRow[0] = '<input type="text" id="dsHoSoTl_ten_' + index +'"  name="dsHoSoTl[' + index + '].ten" class="text1" onclick="showContents(event);">'						
		arrNewHsTlRow[1] = '<input type="text" onkeypress="return formatDate(event, this)" onblur="isDate(this)" name="dsHoSoTl[' + index + '].strThoiGianBanGiao" class="text1" >'
		arrNewHsTlRow[2] = '<input type="text" name="dsHoSoTl[' + index + '].diaDiemNhanName" class="text1" value = "' + document.getElementsByName('diaDiem')[0].value + '">'						
		arrNewHsTlRow[3] = '<select name = "dsHoSoTl[' + index + '].nguoiNhanId" onchange="getTen(this)" onload="getTen(this)">'
		arrNewHsTlRow[3] += document.getElementsByName('dsTvdLapDeCuong')[0].innerHTML;	
		arrNewHsTlRow[3] += '</select>'	
		arrNewHsTlRow[3] += '<INPUT type="hidden" name="dsHoSoTl[' + index + '].nguoiNhanName">'		
		arrNewHsTlRow[4] = '<INPUT type="checkbox" onclick="selectHsTl(this)">'		
		return arrNewHsTlRow;
	}
	
	function selectAllHsTl(chkBxSelectAll){
		bangHsTl.selectAllRow();  
	}
	
	
	
	function onloadDeCuong(){ 
		//document.getElementById('trDinhKemFileDC').style.display = isEmpty(document.getElementsByName('maFileDeCuong')[0].value)? 'none': 'inline';		 
	}
	function validateInDeCuong(){
		if(!isRequired(document.getElementsByName('noiLapDeCuong')[0]))
			return false;
		if(!isRequired(document.getElementsByName('ngayLapDeCuong')[0]))
			return false;
		if(!isRequired(document.getElementsByName('bcPhaiCbiCungCap')[0]))
			return false;
		if(!isRequired(document.getElementsByName('hsPhaiCbiCungCap')[0]))
			return false;
		if(!compareDate(document.getElementsByName('ngayRaQuyetDnh')[0], document.getElementsByName('ngayLapDeCuong')[0], 'Ngày đề cương phải lớn hơn hoặc bằng ngày ra quyết định!')){
			document.getElementsByName('ngayLapDeCuong')[0].focus();
			return false;
		}
		
		return true;
	}
	function validateDeCuong(){
		if(!validateInDeCuong()) 
			return false; 
		// Neu chon dinh kem file va chua co file ke hoach thi bat buoc nhap file dinh kem
		/*if(document.getElementById('checkAttackFileDC').checked){
			if(isEmpty(document.getElementsByName('maFileDeCuong')[0].value))  
				if(!isRequired(document.getElementsByName('fileDinhKemDeCuong')[0]))
					return false;
			document.getElementsByName('isAttackDeCuong')[0].value = "true";
		}			
		else{
			document.getElementsByName('isAttackDeCuong')[0].value = "false";
		}*/
		if(!checkNvarchar2('nhungVanDeKhac', 'Chỉ được nhập tối đa 4000 ký tự!'))
		return false;
		return true;
	}
	
	function validateGridBaoCao(){
		if(bangBaoCao.numOfRow <= 1) 
			return true;
		for(i = 1; i < bangBaoCao.numOfRow; i++){
			if(!isRequired(document.getElementsByName('dsBaoCao['+ eval(i - 1) +'].ten')[0]))
				return false;
			if(!isRequired(document.getElementsByName('dsBaoCao['+ eval(i - 1) +'].strThoiGianBanGiao')[0]))			
				return false;
			if(!isRequired(document.getElementsByName('dsBaoCao['+ eval(i - 1) +'].diaDiemNhanName')[0]))
				return false;
			if(!isRequired(document.getElementsByName('dsBaoCao['+ eval(i - 1) +'].nguoiNhanId')[0]))
				return false;
		}
		return true; 
	}
	function validateGridHsTl(){
		if(bangHsTl.numOfRow <= 1)
			return true;
		for(i = 1; i < bangHsTl.numOfRow; i++){
			if(!isRequired(document.getElementsByName('dsHoSoTl['+ eval(i - 1)  +'].ten')[0]))
				return false;
			if(!isRequired(document.getElementsByName('dsHoSoTl['+ eval(i - 1) +'].strThoiGianBanGiao')[0]))
				return false;
			if(!isRequired(document.getElementsByName('dsHoSoTl['+ eval(i - 1) +'].diaDiemNhanName')[0]))
				return false;
			if(!isRequired(document.getElementsByName('dsHoSoTl['+ eval(i - 1) +'].nguoiNhanId')[0]))
				return false;
		}
		return true;
	}
	
	var idContents = "";
	function showContents(event){
		var ecurObj;
		var ev;
		if(!window.Event){
	    	curObj = event.srcElement;
	    	ev = event;
	    }
	    else{
	    	curObj = e.target;
	    	ev = e;
	   	}
	   	
	   	idContents = curObj.id;
		document.getElementById("Contents").style.top = ev.y;
		document.getElementById("Contents").style.left = ev.x;
		document.getElementById("Contents").style.display = "block";
		document.getElementById("Contents").style.width = "500px";
		document.getElementById("Contents").style.height = "200px";
		document.getElementById("Area").value = curObj.value;
		document.getElementById("Area").style.width = "500px";
		document.getElementById("Area").style.height = "200px";
		
		document.getElementById("Area").focus();
	}
	
	function hideContents(){
		document.getElementById("Contents").style.display = "none";
	}
	function validateForm(){
		return true;
	}
	function changeContents(obj){
		document.getElementById(idContents).value = obj.value;
		document.getElementById(idContents).focus();
		hideContents();
	}
</script>
<logic:notPresent name="readOnly">
	<script language="javascript">
		var strNgayLapDeCuong = <%=(String)request.getAttribute("ngay_lap_de_cuong")%>
	</script>
</logic:notPresent>
