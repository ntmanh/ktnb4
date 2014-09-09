<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar_tab.jsp"%>
<!-- Báo cáo kết quả xác minh mẫu 23/KNTC - Tương tự mẫu 17/KNTC-->
<html:form action="/kntc_bc_kq_xm.do">
	<html:hidden property="maHiddenBb" name="baoCaoKqXmForm" />
	<html:hidden property="soQd" name="baoCaoKqXmForm" />
	<html:hidden property="maHoSo" name="baoCaoKqXmForm" />
	<fieldset><legend>Thông tin kết quả xác minh</legend>
	<table width="100%">
		<tr>
			<td width="15%" align="right">Địa điểm</td>
			<td width="35%"><html:text property="diaDiemBc" name="baoCaoKqXmForm" style="width: 100%" /></td>
			<td width="15%" align="right">Ngày ban hành</td>
			<td width="35%"><html:text property="thoiDiemBc" name="baoCaoKqXmForm" style="width:100%" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td align="right">File mẫu</td>
			<td colspan="3"><A href="filemau/KNTC23.doc"> <font color=blue>Download File</font> </A></td>
		</tr>
		<tr>
			<td align="right">File lưu trữ</td>
			<td><A href="#" onclick="openUploadFile_23(maHoSo);">Báo cáo kết quả xác minh mẫu số 23/KNTC</A></td>
			<td align="right">Kết thúc xác minh</td>
			<td><html:checkbox property="cbKetThuc" value="1"/></td>
		</tr>
	</table>
	</fieldset>
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" class="button" value='Lưu' name="saveBcKqXm" onclick="ghi_bc_kqxm();"> <input type="button" id="btnClose3" class="button" value='Đóng' name="exit" onclick="goHomeKntc();"></td>
		</tr>
	</table>
</html:form>
<script type="text/javascript" charset="utf-8"> 
$(document).ready(function() {
    var ghiTC_23 = "";
	 <logic:present name="ghiThanhcong_23">
	     	ghiTC_23 = '<%=request.getAttribute("ghiThanhcong_23")%>';
	 </logic:present>
	 if(ghiTC_23=='1'){
		alert('Lưu thành công');
	 }
	 else  if(ghiTC_23=='0'){
		alert('Lỗi khi ghi dữ liệu!!!');
	 }  	
	 <%request.removeAttribute("ghiThanhcong_23");%>
});
function warningKt(){
 if(document.forms[2].cbKetThuc.value==1)
 	alert('Sau khi kết thúc, bạn không thể sửa thông tin tiến hành xác minh!');
}
function ghi_bc_kqxm(){
	var maHS = document.getElementsByName("maHoSo")[0].value;
	//alert('S');
	document.forms[2].action="kntc_bc_kq_xm.do?method=saveBbKqXm&id="+maHS;
	document.forms[2].submit();
}

function validForm_23() {	
	if(!isRequired(document.forms[2].diaDiemBc,'Chưa nhập địa điểm')) return false;
	if(!isRequired(document.forms[2].thoiDiemBc,'Chưa nhập ngày ban hành')) return false;
	return true;
}
function openUploadFile_23(){
	var view='';
	var method = '<%=request.getParameter("method")%>';
	if(method == 'view') view = 'view';
	var r = '<%=request.getParameter("r")%>';
	if(r == 'rol') view = 'view';
	
    var maHS = document.forms[2].maHoSo.value;
    if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+maHS+"&nv=KNTC/BCKQXM23&view="+view);
	else
		alert("Chưa có thông tin về hồ sơ!");	
}
function downloadFile_23(){
	document.forms[2].action="kntc_bc_kq_xm.do?method=downloadKNTC23";
	document.forms[2].submit();
	//downLoadWinDow = window.open('kntc_xac_minh.do?method=downloadKNTC17');
	//downLoadWinDow.focus();
}
</script>
</div>
</div>
</body>
</html>