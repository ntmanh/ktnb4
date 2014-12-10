<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar_tab.jsp"%>
<html:form action="/kntc_khxm.do?method=khxm">
	<html:hidden property="arrDm" styleId="arrDm" name="khxmForm" />
	<html:hidden property="maQd" name="khxmForm" />
	<html:hidden property="maHiddenKh" name="khxmForm" />
	<html:hidden property="maHoSo" name="khxmForm" />
	<fieldset><legend>Thông tin kế hoạch</legend>
	<table width="100%">
		<tr>
			<td width="15%" style="text-align: right;">Địa điểm <font style="color: red">*</font></td>
			<td width="35%"><html:text property="diaDiem" style="width: 100%" name="khxmForm" /></td>
			<td width="15%" style="text-align: right;">Ngày lập kế hoạch <font style="color: red">*</font></td>
			<td width="35%"><html:text property="thoiDiem" name="khxmForm" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">Cán bộ lập kế hoạch</td>
			<td colspan="3"><html:select property="canBoTen" styleClass="combobox123" style="width:100%">
				<html:options collection="dmcb" property="value" labelProperty="label" />
			</html:select></td>
		</tr>
		<tr>
			<td align="right">File mẫu</td>
			<td colspan="3"><A href="filemau/KN07.doc"> <font color=blue>Download File</font> </A></td>
		</tr>
		<tr>
			<td style="text-align: right;">File lưu trữ</td>
			<td colspan="3"><A href="#" onclick="openUploadFile_kh();"><font color=blue>Kế hoạch xác minh mẫu 07/KN</font></A></td>
		</tr>
	</table>
	</fieldset>
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" class="button" value='Lưu' name="saveKh" onclick="ghi_kh();"> <input type="button" id="btnClose2" class="button" value='Đóng' name="exit" onclick="goHomeKntc();"></td>
		</tr>
	</table>
</html:form>
<script type="text/javascript" charset="utf-8"> 
$(function(){	
	var ghiTC_kh = "";
	 <logic:present name="ghiThanhcong_kh">
	     	ghiTC_kh = '<%=request.getAttribute("ghiThanhcong_kh")%>';
	 </logic:present>
	 if(ghiTC_kh=='1'){
		alert('Lưu thành công');
	 }
	 else  if(ghiTC_kh=='0'){
		alert('Lỗi khi ghi dữ liệu!!!');
	 } 	
	 <%request.removeAttribute("ghiThanhcong_kh");%>
});

function ghi_kh(){
	var maHS = document.getElementsByName("maHoSo")[0].value;
	if(validRequired_kh()) {
		document.forms['khxmForm'].action="kntc_khxm.do?method=saveKeHoachXm&id="+maHS;
		document.forms['khxmForm'].submit();
	}
}
function print_kh(){		
	document.forms['khxmForm'].action="kntc_khxm.do?method=inKhXm";
	document.forms['khxmForm'].submit();
}
function validRequired_kh() {
	if(!isRequired(document.forms['khxmForm'].diaDiem,'Chưa nhập địa điểm')) return false;
	if(!isRequired(document.forms['khxmForm'].thoiDiem,'Chưa nhập ngày ra quyết định')) return false;
	return true;
}
function openUploadFile_kh(){
	var view='';
	var method = '<%=request.getParameter("method")%>';
	if(method == 'view') view = 'view';
	var r = '<%=request.getParameter("r")%>';
	if(r == 'rol') view = 'view';
	
    var maHS = document.forms['khxmForm'].maHoSo.value;
    if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+maHS+"&nv=KNTC/KHXM&view="+view);
	else
		alert("Chưa có thông tin về hồ sơ!");	
}
function downloadFile_11(){
	document.forms['khxmForm'].action="kntc_khxm.do?method=inKhXm";
	document.forms['khxmForm'].submit();
}
</script>
</div>
</div>
</body>
</html>