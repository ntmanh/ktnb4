<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar_tab.jsp"%>
<!-- kết luận nội dung tố cáo - mẫu 24/kntc -->
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
			<td align="right">Phân tích kết quả<font style="color:red">*</font></td>
			<td colspan="3">
				<html:radio property="phanTichKq" value="1" />Đúng 
				<html:radio property="phanTichKq" value="0" />Sai 
				<html:radio property="phanTichKq" value="2" />Có đúng, có sai
			</td>
		</tr>
		<tr>
			<td align="right">Lý do chậm</td>
			<td colspan="3"><html:textarea property="lyDoNtc" style="width:100%" onkeypress="imposeMaxLength(this);" /></td>
		</tr>
		<tr>
			<td align="right">File mẫu</td>
			<td colspan="3"><A href="filemau/TC18.doc"> <font color=blue>Download File</font> </A></td>
		</tr>
		<tr>
			<td style="text-align: right;">File lưu trữ</td>
			<td colspan="3"><A href="#" onclick="openUploadFile_24();"><font color=blue>Kết luận nội dung Tố cáo mẫu 18/TC</font></A></td>
		</tr>
	</table>
	</fieldset>	
	<jsp:include page="../../../thong_tin_ky_duyet.jsp" />
	<jsp:include page="../../../../button_bar_no_print.jsp" />
</html:form>
<script type="text/javascript" charset="utf-8"> 
$(document).ready(function() {
    var ghiTC_24 = "";
	 <logic:present name="ghiThanhcong_24">
	     	ghiTC_24 = '<%=request.getAttribute("ghiThanhcong_24")%>';
	 </logic:present>
	 if(ghiTC_24=='1'){
		alert('Lưu thành công'); 
	 }
	 else  if(ghiTC_24=='0'){
		alert('Lỗi khi ghi dữ liệu!!!'); 
	 }  	 
	 <%request.removeAttribute("ghiThanhcong_24");%>	 
});

function openUploadFile_24(){
	var view='';
	var method = '<%=request.getParameter("method")%>';
	if(method == 'view') view = 'view';
	var r = '<%=request.getParameter("r")%>';
	if(r == 'rol') view = 'view';
	
    var maHS = document.forms[1].maHoSo.value;
    //alert(maHS);
    if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+maHS+"&nv=KNTC/KLNDTC24&view="+view);
	else
		alert("Chưa có thông tin về hồ sơ!");	
}
function downloadFile_24(){
	//document.forms[0].ketQuaXm.value = nicEditors.findEditor('ketQuaXmMCE').getContent();
	document.forms[0].action="kntc_kq_xm.do?method=download_24";
	document.forms[0].submit();
}
function ghi(){
	var maHS = document.getElementsByName("maHoSo")[0].value;
	//alert('xxx');
	//document.forms[0].ketQuaXm.value = nicEditors.findEditor('ketQuaXmMCE').getContent();
	if(validForm_24()) {
		if(confirm ("Vui lòng kiểm tra lại thông tin phân tích kết quả trước khi lưu? \n\n Ấn OK để xác nhận lưu\n Ấn Cancel để hủy và kiểm tra lại thông tin")){
			document.forms[0].action="kntc_kq_xm.do?method=saveBaoCao&id="+maHS;
			document.forms[0].submit();
		}
	}
}

function validForm_24() {	
	//alert(document.getElementsByName("phanTichKq")[1].value);
	//if(!isRequired(document.forms[0].phanTichKq,'Phải nhập phân tích kết quả')) return false;
	if(!isRequired(document.forms[0].thoiDiem,'Chưa nhập ngày ban hành')) return false;
	//if(!isRequired(document.forms[0].ketQuaXm,'Chưa nhập kết quả xác minh')) {
		//document.forms[0].ketQuaXmMCE.focus();
		//return false;
	//}
	return true;
}
</script>
</div>
</div>
</body>
</html>
