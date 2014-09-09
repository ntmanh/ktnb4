<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar_tab.jsp"%>
<html:form action="/kntc_kq_xm.do">
	<html:hidden property="maHoSo" />
	<html:hidden property="maHidden" />
	<html:hidden property="ketQuaXm" />
	<fieldset><legend>Thông tin kết quả giải quyết</legend>
	<table width="100%">
		<tr>
			<td width="15%" align="right">Địa điểm</td>
			<td width="35%"><html:text property="diaDiem" style="width: 100%" /></td>
			<td width="15%" align="right">Ngày ban hành<font style="color:red">*</font></td>
			<td width="35%"><html:text property="thoiDiem" style="width: 100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td align="right">File mẫu</td>
			<td colspan="3"><A href="filemau/KNTC18.doc"> <font color=blue>Download File</font> </A></td>
		</tr>
		<tr>
			<td style="text-align: right;">File lưu trữ</td>
			<td colspan="3"><A href="#" onclick="openUploadFile_18();"><font color=blue>Báo cáo kết quả giải quyết KN mẫu 18/KNTC</font></A></td>
		</tr>
	</table>
	</fieldset>	
	<jsp:include page="../../../thong_tin_ky_duyet.jsp" />
	<jsp:include page="../../../../button_bar_no_print.jsp" />
</html:form>
<script type="text/javascript" charset="utf-8"> 
$(document).ready(function() {
    var ghiTC_18 = "";
	 <logic:present name="ghiThanhcong_18">
	     	ghiTC_18 = '<%=request.getAttribute("ghiThanhcong_18")%>';
	 </logic:present>
	 if(ghiTC_18=='1'){
		alert('Lưu thành công'); 
	 }
	 else  if(ghiTC_18=='0'){
		alert('Lỗi khi ghi dữ liệu!!!'); 
	 }  	
	 <%request.removeAttribute("ghiThanhcong_18");%> 	 
});

function openUploadFile_18(){
	var view='';
	var method = '<%=request.getParameter("method")%>';
	if(method == 'view') view = 'view';
	var r = '<%=request.getParameter("r")%>';
	if(r == 'rol') view = 'view';
	
    var maHS = document.forms[1].maHoSo.value;
    //alert(maHS);
    if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+maHS+"&nv=KNTC/BCKQXM18&view="+view);
	else
		alert("Chưa có thông tin về hồ sơ!");	
}
function downloadFile_18(){
	//document.forms[0].ketQuaXm.value = nicEditors.findEditor('ketQuaXmMCE').getContent();
	document.forms[0].action="kntc_kq_xm.do?method=download_18";
	document.forms[0].submit();
}
function ghi(){
	var maHS = document.getElementsByName("maHoSo")[0].value;
	//alert('xxx');
	//document.forms[0].ketQuaXm.value = nicEditors.findEditor('ketQuaXmMCE').getContent();
	if(validForm()) {
		document.forms[0].action="kntc_kq_xm.do?method=saveBaoCao&id="+maHS;
		document.forms[0].submit();
	}
}

function validForm() {
	//if(!isRequired(document.forms[0].diaDiem,'Chưa nhập địa điểm')) return false;
	//if(!isRequired(document.forms[0].thoiDiem,'Chưa nhập ngày ban hành')) return false;
	//if(!isRequired(document.forms[0].ketQuaXm,'Chưa nhập kết quả xác minh')) {
		//document.forms[0].ketQuaXmMCE.focus();
		//return false;
	//}
	if(document.forms[1].ngayDuyet.value != null){
		if(!isRequired(document.forms[1].thoiDiem,'Để duyệt báo cáo kết quả phải nhập ngày ban hành')) return false;
	}
	return true;
}
</script>
</div>
</div>
</body>
</html>
