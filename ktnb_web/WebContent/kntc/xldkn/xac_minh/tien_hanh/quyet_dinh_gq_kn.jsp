<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar_tab.jsp"%>
<!-- Mẫu 19/KNTC. Tương tự mẫu 26/KNTC -->
<html:form action="/kntc_qdgq.do">
	<html:hidden property="maHidden" />
	<html:hidden property="maHoSo" />
	<html:hidden property="lanGiaiQuyet" styleId="lanGiaiQuyet" />
	<fieldset><legend>Thông tin quyết định</legend>
	<table width="100%">
		<tr>
			<td width="15%" align="right">Số quyết định<font
				style="color:red">*</font></td>
			<td width="35%"><html:text property="soQd" style="width: 150px" /></td>
			<td width="20%" align="right">Ngày ban hành<font
				style="color:red">*</font></td>
			<td width="30%"><html:text property="thoiDiem"
				style="width: 150px" onkeypress="return formatDate(event, this)"
				maxlength="10" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td align="right">File mẫu</td>
			<!--  <td colspan="3"><A href="filemau/KNTC19.doc"> <font
				color=blue>Download File</font> </A></td> -->
			<td colspan="1" id="16a"><A href="docin/v4/filemau/KN16A.doc">
			<font color=blue>Download File 16A/KN </font> </A></td>
			<td colspan="1" id="16b"><A href="docin/v4/filemau/KN16B.doc">
			<font color=blue>Download File 16B/KN </font> </A></td>
		</tr>
		<tr>
			<td style="text-align: right;">File lưu trữ</td>
			<td><A href="#" onclick="openUploadFile_19();"><font
				color=blue>Quyết định giải quyết KN mẫu 19/KNTC</font></A></td>
			<!-- <td align="right">Kết thúc QĐ giải quyết</td>
			<td><html:checkbox property="ketThuc" value="1"/></td> -->
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td align="right">Phân tích kết quả</td>
			<td colspan="3"><html:radio property="knDungSai" value="1" />Đúng
			<html:radio property="knDungSai" value="0" />Sai <html:radio
				property="knDungSai" value="2" />Có đúng, có sai</td>
		</tr>
		<tr>
			<td align="right">Lý do chậm</td>
			<td colspan="3"><html:textarea property="ghiChu"
				onkeypress="imposeMaxLength(this);" style="width:100%" /></td>
		</tr>
	</table>
	</fieldset>
	<jsp:include page="../../../thong_tin_ky_duyet.jsp" />
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" class="button"
				value='Lưu' name="saveQd" onclick="ghi_qd();"> <input
				type="button" id="btnClose2" class="button" value='Đóng' name="exit"
				onclick="goHomeKntc();"></td>
		</tr>
	</table>
</html:form>
<script type="text/javascript" charset="utf-8"> 
$(document).ready(function() {
	checkLanGiaiQuyet();
    var ghiTC = "";
	 <logic:present name="ghiThanhcong">
	     	ghiTC = '<%=request.getAttribute("ghiThanhcong")%>';
	 </logic:present>
	 if(ghiTC=='1'){
		alert('Lưu thành công'); 
	 }
	 else  if(ghiTC=='0'){
		alert('Lỗi khi ghi dữ liệu!!!'); 
	 }  
	 <%request.removeAttribute("ghiThanhcong");%>
});
function checkLanGiaiQuyet()
{
	var lanGq=$("#lanGiaiQuyet").val();
	if(lanGq>=2)
		$("#16b").show();
	else 
		$("#16b").hide();
}
function warningKt(){
 if(document.forms[1].ketThuc.value==1)
 	alert('Sau khi kết thúc, bạn không thể sửa thông tin tiến hành xác minh!');
}
function openUploadFile_19(){
	var view='';
	var method = '<%=request.getParameter("method")%>';
	if(method == 'view') view = 'view';
	var r = '<%=request.getParameter("r")%>';
	if(r == 'rol') view = 'view';
	
    var maHS = document.forms[1].maHoSo.value;
    if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+maHS+"&nv=KNTC/QDGQ19&view="+view);
	else
		alert("Chưa có thông tin về hồ sơ!");	
}
function ghi_qd(){
	var maHS = document.getElementsByName("maHoSo")[0].value;
	if(validForm_19()){
		if(confirm ("Vui lòng kiểm tra lại thông tin phân tích kết quả trước khi lưu? \n\n Ấn OK để xác nhận lưu\n Ấn Cancel để hủy và kiểm tra lại thông tin")){
			document.forms[1].action="kntc_qdgq.do?method=saveQdgq&id="+maHS;
			document.forms[1].submit();	
		}
	}
}
function downloadFile_19(){
	try{
		document.forms[1].action="kntc_qdgq.do?method=inKntc19";
		document.forms[1].submit();
	}catch(e){
		alert(e)
	}
}
function validForm_19() {
	//if(!isRequired(document.forms[1].canCuTheo,'Chưa nhập căn cứ theo')) return false;
	//if(!isRequired(document.forms[1].ketLuan,'Chưa nhập kết luận')) return false;
	//if(!isRequired(document.forms[1].knDungSai,'Phải nhập phân tích kết quả')) return false;
	//if(!isRequired(document.forms[1].knDungSai,'Phải nhập phân tích kết quả')) return false;
	//if(document.forms[1].ngayDuyet.value != null){		
	if(!isRequired(document.forms[1].soQd,'Phải nhập số quyết định')) return false;
	if(!isRequired(document.forms[1].thoiDiem,'Phải nhập ngày ban hành')) return false;
	//}
	return true;
}
</script>
</div>
</div>
</body>
</html>
