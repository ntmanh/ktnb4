<%@page pageEncoding="UTF-8" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="chuan_bi_tien_hanh.do?method=save&type=kh" method="POST" enctype="multipart/form-data">
	<div id="getReturnKh" style="display: none;"></div>
	<table align="center" width="100%">
		<tr>
			<td>
			<fieldset><legend>Thông tin chung</legend>
			<table width="100%">
				<tr>
					<td align="right" width="19%">Địa điểm lập <font color=red>*</font></td>
					<td style="width: 1%; min-width: 5px"></td>
					<td align="left" width="30%"><html:text styleClass="text" property="diaDiemLapKeHoach"></html:text></td>
					<td align="right" width="19%">Ngày lập <font color=red>*</font></td>
					<td style="width: 1%; min-width: 5px"></td>
					<td align="left" width="30%"><html:text styleClass="text" onkeypress="return formatDate(event, this)" onblur="if(!isDate(this)) return; validateNgayLapKeHoach();" property="ngayLapKeHoach"></html:text></td>
				</tr>
				<tr>
					<td align="right" width="19%">Nơi phê duyệt</td>
					<td style="width: 1%; min-width: 5px"></td>
					<td align="left" width="30%"><html:text styleClass="text" property="noiPheDuyetKeHoach"></html:text></td>
					<td align="right" width="19%">Ngày phê duyệt</td>
					<td style="width: 1%; min-width: 5px"></td>
					<td align="left" width="30%"><html:text styleClass="text" onkeypress="return formatDate(event, this)" onblur="if(!isDate(this)) return;  validateNgayDuyetKeHoach();" property="ngayPheDuyetKeHoach"></html:text></td>
				</tr>
				<!--Y kien phe duyet-->
				<tr>
					<td align="right" width="19%">Ý kiến phê duyệt</td>
					<td style="width: 1%; min-width: 5px"></td>
					<td align="left" colspan="4"><html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  style="width: 100%" property="ykienPheDuyetKh"></html:textarea></td>
				</tr>
				<!--Muc dich-->
				<tr>
					<td align="right" width="19%">Mục đích</td>
					<td style="width: 1%; min-width: 5px"></td>
					<td align="left" colspan="4"><html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  style="width: 100%" property="mucDich"></html:textarea></td>
				</tr>
				<!--Yeu cau-->
				<tr>
					<td align="right" width="19%">Yêu cầu</td>
					<td style="width: 1%; min-width: 5px"></td>
					<td align="left" colspan="4"><html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  style="width: 100%" property="yeuCau"></html:textarea></td>
				</tr>
				<!--Noi dung-->
				<tr>
					<td align="right" width="19%">Nội dung</td>
					<td style="width: 1%; min-width: 5px"></td>
					<td align="left" colspan="4"><html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  style="width: 100%" property="noiDung"></html:textarea></td>
				</tr>
				<!--Phuong phap tien hanh-->
				<tr>
					<td align="right" width="19%">Phương pháp tiến hành</td>
					<td style="width: 1%; min-width: 5px"></td>
					<td align="left" colspan="4"><html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  style="width: 100%" property="phuongPhapTienHanh"></html:textarea></td>
				</tr>
			</table>	
			</fieldset>
			</td>
		</tr>
		<tr>
			<td>
			<fieldset style="margin: 0"><legend>Tổ chức thực hiện</legend>
			<table width="100%">
				<!--To chuc thuc hien-->
				<tr>
					<td align="right" width="19%">Tiến độ thực hiện</td>
					<td style="width: 1%; min-width: 5px"></td>
					<td align="left" colspan="4"><html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  style="width: 100%" property="toChucThucHien"></html:textarea></td>
				</tr>
				<!--Che do thong tin bao cao-->
				<tr>
					<td align="right" width="19%">Chế độ thông tin báo cáo</td>
					<td style="width: 1%; min-width: 5px"></td>
					<td align="left" colspan="4"><html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  style="width: 100%" property="cheDoThongTinBaoCao"></html:textarea></td>
				</tr>
				<!--Dieu kien vat chat dam bao-->
				<tr>
					<td align="right" width="19%">Điều kiện vật chất đảm bảo</td>
					<td style="width: 1%; min-width: 5px"></td>
					<td align="left" colspan="4"><html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  style="width: 100%" property="dieuKienVatChatDamBao"></html:textarea></td>
				</tr>
				<!--Nhung dieu kien khac-->
				<tr>
					<td align="right" width="19%">Những điều kiện khác</td>
					<td style="width: 1%; min-width: 5px"></td>
					<td align="left" colspan="4"><html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  style="width: 100%" property="nhungDieuKienKhac"></html:textarea></td>
				</tr>
			</table>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td align="right"><INPUT type="button" class="button1" value="In kế hoạch" onclick="inKeHoach()"></td>
		</tr>
	</table>
	<table width="100%">
		<!--<tr>
			<td align="right" width="19%">Đính kèm file</td>
			<td style="width: 1%; min-width: 5px"></td>
			<td align="left" colspan="4" width="100%"><logic:present name="ChuanBiTienHanhForm" property="maFileKeHoach">
				<input type="checkbox" onclick="checkAttackKeHoach()" checked id="checkAttackFile" />
			</logic:present> <logic:notPresent name="ChuanBiTienHanhForm" property="maFileKeHoach">
				<input type="checkbox" onclick="checkAttackKeHoach()" id="checkAttackFile" />
			</logic:notPresent></td>
		</tr> -->
		<tr>
			<td colspan="6" width="100%">
			<fieldset>
			<table width="100%">
				<logic:notPresent name="readOnly">
					<tr>
						<td align="right" width="49%">Download biểu mẫu</td>
						<td style="width: 2%; min-width: 5px;"></td>
						<td align="left" width="49%"><A href="filemau/TTNB12.doc"> <font color=blue>Download File</font> </A></td>
					</tr>
				</logic:notPresent>
				<!--<logic:present name="ChuanBiTienHanhForm" property="maFileKeHoach">
					<tr>
						<td align="right" width="49%">File đính kèm</td>
						<td style="width: 2%; min-width: 5px;"></td>
						<td align="left" width="49%"><a href="#" onclick="window.open('UploadAction.do?method=downLoadKeHoachTtkt&ma_file='+document.getElementsByName('maFileKeHoach')[0].value).focus()"><font color="blue">Kế hoạch Thanh tra Kiểm tra</font></a></td>
					</tr>
				</logic:present>
				<logic:notPresent name="readOnly">
					<tr>
						<td align="right" width="49%"><logic:present name="ChuanBiTienHanhForm" property="maFileKeHoach">
									Cập nhật file đính kèm
								</logic:present> <logic:notPresent name="ChuanBiTienHanhForm" property="maFileKeHoach">
									File đính kèm
								</logic:notPresent></td>
						<td style="width: 2%; min-width: 5px;"></td>
						<td align="left" width="49%"><html:file name="ChuanBiTienHanhForm" property="fileDinhKemKeHoach"></html:file></td>
					</tr>
				</logic:notPresent>-->
			<tr>
				<td align="right" width="49%">File kế hoạch</td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><A href="#" onclick="openUploadFile();"><font color=blue>File "kế hoạch" đính kèm</font></A></td>
			</tr>	
			</table>
			</fieldset>
			</td>
		</tr>
	</table>
	<html:hidden property="idKeHoach" /> <html:hidden property="isChangeKeHoach" /> 
	<html:hidden property="maFileKeHoach" /> 
	<html:hidden property="isAttackKeHoach" />
</html:form>
<script language="javascript">	
	function openUploadFile(){
		var view='';
		var method = '<%=request.getParameter("method")%>';
		if(method == 'view') view = 'view';
		var r = '<%=request.getParameter("r")%>';
		if(r == 'rol') view = 'view';		
		var maHS = document.getElementsByName('idCuocTtkt')[0].value;
		openWindow("UploadAction.do?parentId="+maHS+"&nv=TTKT/CB/KH&view="+view);		
	}
	function onLoadKeHoach(){
		//document.getElementById('trDinhKemFile').style.display = isEmpty(document.getElementsByName('maFileKeHoach')[0].value)? 'none': 'inline';
	}
	function downLoadBieuMauKeHoach(){
		var thongTinQd = "";
		var qdForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=qd');	 
		for(var i = 0; i< qdForm.elements.length; i++){
			if(qdForm.elements[i].name != null && qdForm.elements[i].name != '' && qdForm.elements[i].value != null && qdForm.elements[i].value != '')
			thongTinQd += qdForm.elements[i].name + "=" + encodeURIComponent(qdForm.elements[i].value) + "&";
		}		
		thongTinQd += 'idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
		
		var printfForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=kh');	
		thongTinKh = "";
		for(var i = 0; i< printfForm.elements.length; i++){
			if(printfForm.elements[i].name != null && printfForm.elements[i].name != '' && printfForm.elements[i].name != 'fileDinhKemKeHoach' && printfForm.elements[i].value != null && printfForm.elements[i].value != '')
				thongTinKh += printfForm.elements[i].name + "=" + encodeURIComponent(printfForm.elements[i].value) + "&";
		}
		printfForm.action = 'chuan_bi_tien_hanh.do?method=in&type=bmkh&' + thongTinKh + "&" + thongTinQd;
		printfForm.submit();
		printfForm.action = '/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=kh'; 
	}
	function checkAttackKeHoach(){
		if(document.getElementById('trDinhKemFile').style.display == 'inline')
			document.getElementById('trDinhKemFile').style.display = 'none';
		else
			document.getElementById('trDinhKemFile').style.display = 'inline';
			
	}
	function validateNgayDuyetKeHoach(){
		if(isEmpty(document.getElementsByName('ngayLapKeHoach')[0].value)){   
			alert('Chưa nhập ngày lập kế hoạch!');
			document.getElementsByName('ngayPheDuyetKeHoach')[0].value = '';
			document.getElementsByName('ngayLapKeHoach')[0].focus();
		}
		if(d2n(document.getElementsByName('ngayLapKeHoach')[0].value) > d2n(document.getElementsByName('ngayPheDuyetKeHoach')[0].value)){
			alert('Ngày phê duyệt kế hoạch không được nhỏ hơn ngày lập!');
			document.getElementsByName('ngayLapKeHoach')[0].focus();
		}
		caculateDate('ngayLapKeHoach', 'truongGiuNgayTam', strNgayDuyetKeHoach);
		if(d2n(document.getElementsByName('ngayPheDuyetKeHoach')[0].value) > d2n(document.getElementsByName('truongGiuNgayTam')[0].value)){
			alert('Thời hạn phê duyệt kế hoạch là ' + strNgayDuyetKeHoach + ' ngày!');
		}
	} 
	function validateNgayLapKeHoach(){
		if(d2n(document.getElementsByName('ngayLapKeHoach')[0].value) < d2n(document.getElementsByName('ngayRaQuyetDnh')[0].value)){
			alert('Ngày lập kế hoạch không được trước ngày ra quyết định!');
			document.getElementsByName('ngayLapKeHoach')[0].focus();
		}
		caculateDate('ngayRaQuyetDnh', 'truongGiuNgayTam', strNgayLapKeHoach);
		if(d2n(document.getElementsByName('ngayLapKeHoach')[0].value) > d2n(document.getElementsByName('truongGiuNgayTam')[0].value)){
			alert('Cảnh báo quá hạn: Kế hoạch lập sau quyết định quá '+ strNgayLapKeHoach + ' ngày!');
			//document.getElementsByName('ngayLapKeHoach')[0].focus();
		}
	}
	function inKeHoach(){ 
		if(!validateKeHoach()) 
			return;   
		var thongTinQd = "";
		var qdForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=qd');	 
		for(var i = 0; i< qdForm.elements.length; i++){
			if(qdForm.elements[i].name != null && qdForm.elements[i].name != '' && qdForm.elements[i].value != null && qdForm.elements[i].value != '')
			thongTinQd += qdForm.elements[i].name + "=" + encodeURIComponent(qdForm.elements[i].value) + "&";
		}		
		thongTinQd += 'idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;  
		
		var printfForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=kh');	
		thongTinKh = "";
		for(var i = 0; i< printfForm.elements.length; i++){
			if(printfForm.elements[i].name != null && printfForm.elements[i].name != '' && printfForm.elements[i].name != 'fileDinhKemKeHoach' && printfForm.elements[i].value != null && printfForm.elements[i].value != '')
				thongTinKh += printfForm.elements[i].name + "=" + encodeURIComponent(printfForm.elements[i].value) + "&";
		}
		printfForm.action = 'chuan_bi_tien_hanh.do?method=in&type=kh&' + thongTinQd;
		printfForm.submit();
		printfForm.action = '/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=kh'; 
	}
	function getThongTinKeHoach(){
		var thongTinKh = '';
		var khForm = findForm('/' + contextRoot + '/chuan_bi_tien_hanh.do?method=save&type=kh');	 
		for(var i = 0; i< khForm.elements.length; i++){
			if(khForm.elements[i].name != null && khForm.elements[i].name != '' && khForm.elements[i].value != null && khForm.elements[i].value != '')
			thongTinKh += khForm.elements[i].name + "=" + encodeURIComponent(khForm.elements[i].value) + "&";
		}
		thongTinKh = thongTinKh.substring(0, thongTinKh.length - 1); 
		return thongTinKh;
	}
	function validateInKeHoach(){
		if(!isRequired(document.getElementsByName('diaDiemLapKeHoach')[0]))
			return false;
		if(!isRequired(document.getElementsByName('ngayLapKeHoach')[0]))
			return false;
		
		if(!compareDate(document.getElementsByName('ngayRaQuyetDnh')[0], document.getElementsByName('ngayLapKeHoach')[0], 'Ngày lập kế hoạch phải lớn hơn hoặc bằng ngày ra quyết định!')){
			document.getElementsByName('ngayLapKeHoach')[0].focus();
			return false;
		}
		
		if(!compareDate(document.getElementsByName('ngayLapKeHoach')[0], document.getElementsByName('ngayPheDuyetKeHoach')[0], 'Ngày duyệt phải lớn hơn hoặc bằng ngày lập!')){
			document.getElementsByName('ngayPheDuyetKeHoach')[0].focus();
			return false;
		}
		if(!checkNvarchar2('ykienPheDuyetKh'))
			return false;	
		if(!checkNvarchar2('mucDich'))
			return false;	
		if(!checkNvarchar2('yeuCau'))
			return false;
		if(!checkNvarchar2('noiDung'))
			return false;
		if(!checkNvarchar2('phuongPhapTienHanh'))  
			return false;	
		if(!checkNvarchar2('toChucThucHien'))
			return false;	
		if(!checkNvarchar2('cheDoThongTinBaoCao'))    
			return false;	
		if(!checkNvarchar2('dieuKienVatChatDamBao'))
			return false;	
		if(!checkNvarchar2('nhungDieuKienKhac'))  
			return false;
		return true;  
	}
	function validateKeHoach(){  
		// Neu chon dinh kem file va chua co file ke hoach thi bat buoc nhap file dinh kem
		/*if(document.getElementById('checkAttackFile').checked){
			if(isEmpty(document.getElementsByName('maFileKeHoach')[0].value))  
				if(!isRequired(document.getElementsByName('fileDinhKemKeHoach')[0]))
					return false;
			document.getElementsByName('isAttackKeHoach')[0].value = "true";
		}			
		else{
			document.getElementsByName('isAttackKeHoach')[0].value = "false";
			if(!validateInKeHoach())
			return false;
			//document.getElementsByName('fileDinhKemKeHoach')[0].value = "";
			//document.getElementsByName('maFileKeHoach')[0].value = "";
		}*/
		return true;
	}
	function saveKeHoach(){
		for(i = 0; i< document.forms.length; i++){
			if(document.forms[i].action == 'chuan_bi_tien_hanh.do?method=save&type=kh')
				document.forms[i].submit();
		}
}
</script>
<logic:notPresent name="readOnly">
	<script language="javascript">
		var strNgayLapKeHoach = <%=(String)request.getAttribute("ngay_lap_ke_hoach")%>
		var strNgayDuyetKeHoach = <%=(String)request.getAttribute("ngay_duyet_hoach")%>
	</script>
</logic:notPresent>
