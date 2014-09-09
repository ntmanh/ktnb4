<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="ket_thuc_ttkt.do?method=save&type=ketLuan" method="POST" enctype="multipart/form-data">
	<div id="saveKetLuan" style="display: none;"></div>
	<table align="center" width="100%">
		<logic:notPresent name="readOnly">
			<tr>
				<td align="right" width="49%">Download biểu mẫu</td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><A href="#" onclick="downLoadBieuMau()"> <font color=blue>Mẫu số 38/TTNB</font> </A></td>
			</tr>
			<tr id='colTitleKL'>
				<td align="right" width="49%">File đính kèm</td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><!-- <A href="#" onclick="downLoadBienBan(document.getElementsByName('idKetLuan')[0].value);"><font color=blue>Kết luân Thanh tra Kiểm tra</font></A> --> <A href="#" onclick="downLoadBienBan(document.getElementsByName('idKetLuan')[0].value);"><font
					color=blue>Kết luận Kiểm tra</font></A></td>
			</tr>
			<tr>
				<td align="right" width="49%" id="tileFileDinhKemKetLuan"></td>
				<td style="width: 2%; min-width: 5px;"></td>
				<td align="left" width="49%"><html:file property="fileKetLuan" /></td>
			</tr>
		</logic:notPresent>
		<logic:present name="readOnly">
			<logic:equal name="KetThucTtktForm" property="idKetLuan" value=" ">
				<tr id='colTitleKL'>
					<td align="center">Chưa có biên bản tổng hợp.</td>
				</tr>
			</logic:equal>
			<logic:notEqual name="KetThucTtktForm" property="idKetLuan" value=" ">
				<tr id='colTitleKL'>
					<td align="right" width="49%">File đính kèm</td>
					<td style="width: 2%; min-width: 5px;"></td>
					<td align="left" width="49%"><!-- <A href="#" onclick="downLoadBienBan(document.getElementsByName('idKetLuan')[0].value);"><font color=blue>Kết luân Thanh tra Kiểm tra</font></A> --> <A href="#" onclick="downLoadBienBan(document.getElementsByName('idKetLuan')[0].value);"><font
						color=blue>Kết luận Kiểm tra</font></A></td>
				</tr>
			</logic:notEqual>
		</logic:present>
		<tr>
			<td align="right" width="49%">Số kết luận<font color=red>*</font></td>
			<td style="width: 2%; min-width: 5px;"></td>
			<td align="left"><html:text name="KetThucTtktForm" property="soKetLuan" /> </td>
		</tr>
		<tr>
			<td align="right" width="49%">Ngày ra kết luận <font color=red>*</font></td>
			<td style="width: 2%; min-width: 5px;"></td>
			<td align="left"><html:text onblur="if(!isDate(this)) return; validateNgayRaKetLuan()" onkeypress="return formatDate(event, this)" property="ngayRaKetLuan" styleClass="text" /></td>
		</tr>
	</Table>
	<html:hidden property="idKetLuan" />
	<INPUT name="ngayTam" type="hidden">
</html:form>
<logic:notPresent name="readOnly">
	<DIV><a href="#" onclick="congBoKetLuan();" class="linkCnPhu">Công bố kết luận</a> | <a href="#" onclick="chuyenGiaoHoSoVuViec();" class="linkCnPhu">Chuyển giao hồ sơ vụ việc sang cơ quan điều tra</a></DIV>
</logic:notPresent>
<logic:present name="readOnly">
	<script language="javascript">
		var lastLabelId = '';
	</script>
	<logic:present name="cong_bo_ket_luan">
		<a href="#" onclick="congBoKetLuan();" class="linkCnPhu">Công bố kết luận</a>
		<label id="cong_bo_ket_luan">&nbsp;|</label>
		<script language="javascript">
			lastLabelId = 'cong_bo_ket_luan';
		</script>
	</logic:present>  
	<logic:present name="Chuyen giao hsvv">
		<a href="#" onclick="chuyenGiaoHoSoVuViec();" class="linkCnPhu">Chuyển giao hồ sơ vụ việc sang cơ quan điều tra</a>
		<label id="Chuyen giao hsvv">&nbsp;|</label>
		<script language="javascript">
			lastLabelId = 'Chuyen giao hsvv';
		</script>
	</logic:present>
	<script language="javascript">
		if(lastLabelId != '')
			document.getElementById(lastLabelId).innerHTML = '';
	</script>
</logic:present>
<script language="javascript">
function validateNgayRaKetLuan(){	
	caculateDate('ngayGuiBaoCaoKetQuaVaDuThaoKetLuan','ngayTam', strThoiHanRaKetLuan); 	
	compareDate(document.getElementsByName('ngayRaKetLuan')[0], document.getElementsByName('ngayTam')[0], 'Cảnh báo quá hạn: Ngày ra kết luận sau ngày báo cáo kết quả quá ' + strThoiHanRaKetLuan + ' ngày!');	
}   
function congBoKetLuan(){
	window.open('cong_bo_ket_luan.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value+'&ngayRaKetLuan='+$('[name="ngayRaKetLuan"]')[0].value);
}     
function chuyenGiaoHoSoVuViec(){   
	url = 'ban_giao_ho_so_vu_viec.do?idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	window.open(url).focus();	    
}
function downLoadKetLuanTtkt(){   
}
function downLoadBieuMauKetLuanTtkt(){
}
var strThoiHanRaKetLuan;
function onLoadKetLuan(){
	strThoiHanRaKetLuan = <%=(String)request.getAttribute("thoiHanRaKetLuan")%> 
	maFile = document.getElementsByName('idKetLuan')[0].value;
	if(maFile == null || maFile == ''){
		document.getElementById('tileFileDinhKemKetLuan').innerHTML = 'File đính kèm <font color=red>*</font>';
		document.getElementById('colTitleKL').style.display = 'none';		
	}	
	else{
		document.getElementById('tileFileDinhKemKetLuan').innerHTML = 'Cập nhật file đính kèm';
		document.getElementById('colTitleKL').style.display = 'inline';
	}
}      
function validateKetLuan(){
	if($('[name="idDuThaoKetQua"]')[0].value==""||$('[name="idDuThaoKetQua"]')[0].value==null){
		alert("Chưa có dự thảo báo cáo kết quả!");
		return false;
	}
	if(isEmpty(document.getElementsByName('idKetLuan')[0].value)){
		if(!isRequired(document.getElementsByName('fileKetLuan')[0]))
			return false;
	}
	if(!isRequired(document.getElementsByName('ngayRaKetLuan')[0]))
			return false;	
	if(!isRequired(document.getElementsByName('soKetLuan')[0]))
	return false;	
	if(!compareDate(document.getElementsByName('ngayGuiBaoCaoKetQuaVaDuThaoKetLuan')[0], document.getElementsByName('ngayRaKetLuan')[0], 'Ngày ra kết luận không được trước ngày báo cáo kết quả!')){
		document.getElementsByName('ngayRaKetLuan')[0].focus();
		return false;
	}
	return true;
}
</script>
