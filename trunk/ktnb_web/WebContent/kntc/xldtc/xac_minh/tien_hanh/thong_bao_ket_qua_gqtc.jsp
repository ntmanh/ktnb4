<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar_tab.jsp"%>
<!-- Mẫu 26/KNTC. Tương tự mẫu 19/KNTC -->
<html:form action="/kntc_qdgq.do">
	<html:hidden property="maHidden" />
	<html:hidden property="maHoSo" />
	<fieldset><legend>Thông tin quyết định</legend>
	<table width="100%">
		<tr>
			<td width="15%" align="right">Số thông báo<font style="color:red">*</font></td>
			<td width="35%"><html:text property="soQd" style="width: 150px" /></td>
			<td width="20%" align="right">Ngày ban hành<font style="color:red">*</font></td>
			<td width="30%"><html:text property="thoiDiem"
				style="width: 150px" onkeypress="return formatDate(event, this)"
				maxlength="10" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td align="right">File mẫu</td>
			<td colspan="3"><A href="filemau/TC21.doc"> <font
				color=blue>Download File</font> </A></td>
		</tr>
		<tr>
			<td style="text-align: right;">File lưu trữ</td>
			<td><A href="#" onclick="openUploadFile_26();"><font
				color=blue>Thông báo kết quả giải quyết tố cáo 21/TC</font></A></td>
			<!-- <td align="right">Kết thúc TB giải quyết</td>
			<td><html:checkbox property="ketThuc" value="1"/></td>  -->
			<td></td>
			<td></td>
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
    var ghiTC_26 = "";
	 <logic:present name="ghiThanhcong_26">
	     	ghiTC_26 = '<%=request.getAttribute("ghiThanhcong_26")%>';
	 </logic:present>
	 if(ghiTC_26=='1'){
		alert('Lưu thành công');
	 }
	 else  if(ghiTC_26=='0'){
		alert('Lỗi khi ghi dữ liệu!!!');
	 }  
	 <%request.removeAttribute("ghiThanhcong_26");%>
});
function warningKt(){
 if(document.forms[1].ketThuc.value==1)
 	alert('Sau khi kết thúc, bạn không thể sửa thông tin tiến hành xác minh!');
}
function openUploadFile_26(){
	var view='';
	var method = '<%=request.getParameter("method")%>';
	if(method == 'view') view = 'view';
	var r = '<%=request.getParameter("r")%>';
	if(r == 'rol') view = 'view';
	
    var maHS = document.forms[1].maHoSo.value;
    if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+maHS+"&nv=KNTC/TBKQ26&view="+view);
	else
		alert("Chưa có thông tin về hồ sơ!");	
}
function ghi_qd(){
	var maHS = document.getElementsByName("maHoSo")[0].value;
	if(validForm_26()){
		document.forms[1].action="kntc_qdgq.do?method=saveQdgq&id="+maHS;
		document.forms[1].submit();	
	}
}
function downloadFile_26(){
	try{
	document.forms[1].action="kntc_qdgq.do?method=inKntc19";
	document.forms[1].submit();
	}catch(e){alert(e)}
}
function validForm_26() {
	if(!isRequired(document.forms[1].soQd,'Phải nhập số quyết định')) return false;
	if(!isRequired(document.forms[1].thoiDiem,'Phải nhập ngày ban hành')) return false;
	return true;
}
</script>
</div>
</div>
</body>
</html>
