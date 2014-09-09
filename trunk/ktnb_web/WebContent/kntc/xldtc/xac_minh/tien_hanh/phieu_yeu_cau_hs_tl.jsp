<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Phiếu yêu cầu cung cấp báo cáo hồ sơ, tài liệu - 13/KNTC</h3>
<html:form action="/kntc_xm_phieu_yc.do?method=show">
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red"> Số Quyết định</font> <html:text property="kntcQdinhXm" styleClass="text" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Danh sách các phiếu đã lập</legend>
	<table cellpadding="0" cellspacing="0" border="0" class="display" id="tbl_listPhieuHen">
		<thead>
			<tr>
				<th>Mã phiếu</th>
				<th>Ngày lập phiếu</th>
				<th>Người nhận phiếu</th>
				<th>Người nhận tài liệu</th>
			</tr>
		</thead>
		<tbody>
			<tr align="center">
				<td colspan="4" class="dataTables_empty">.....</td>
			</tr>
		</tbody>
	</table>
	</fieldset>
	<br>
	<fieldset><legend>Thông tin phiếu yêu cầu</legend>
	<TABLE width="100%">
		<TBODY>
			<tr>
				<td>Địa điểm lập phiếu <font color="red">*</font></td>
				<td><html:text property="diaDiem" /></td>
				<td>Ngày lập phiếu <font color="red">*</font></td>
				<td><html:text property="ngayLap" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			</tr>
			<tr>
				<td>Đơn vị tổ chức cá nhân được yêu cầu cung cấp <font color="red">*</font></td>
				<td colspan="3"><html:text property="donViYcgt" style="width:100%" /></td>
			</tr>
			<tr>
				<td>Các báo cáo cần cung cấp <font color="red">*</font></td>
				<td colspan="3"><html:textarea property="ycBaoCao" onkeypress="imposeMaxLength(this);" style="width:100%" /></td>
			</tr>
			<tr>
				<td>Các hồ sơ, tài liệu cần cung cấp <font color="red">*</font></td>
				<td colspan="3"><html:textarea property="ycHoSo" onkeypress="imposeMaxLength(this);" style="width:100%" /></td>
			</tr>
			<tr>
				<td>Thời gian cung cấp tài liệu <font color="red">*</font></td>
				<td><html:text property="thoiDiemYcgt" onblur="isTime(this)" onkeypress="return formatTime(event, this)" /></td>
				<td>Địa điểm cung cấp</td>
				<td><html:text property="diaDiemYcgt" /></td>
			</tr>
			<tr>
				<td>Người nhận báo cáo, hồ sơ, tài liệu <font color="red">*</font></td>
				<td><html:text property="nguoiNhanBc" /> <input type="button" class="button" name="btnCb" style="width: 10%" value="..." onclick="showLovCanbo()" /></td>
				<td>Chức vụ</td>
				<td><html:text property="nguoiNhanBcChucVu" /></td>
			</tr>
			<tr>
				<td>Người nhận phiếu yêu cầu <font color="red">*</font></td>
				<td><html:text property="nguoiNhanPhieu" /></td>
				<td>Chức vụ</td>
				<td><html:text property="nguoiNhanPhieuChucVu" /></td>
			</tr>
			<tr>
				<td>Thời gian giao phiếu <font color="red">*</font></td>
				<td><html:text property="thoiGianNhanPhieu" onblur="isTime(this)" onkeypress="return formatTime(event, this)" /></td>
				<td>Lần yêu cầu <font color="red">*</font></td>
				<td><html:text property="lanYc" maxlength="2" onblur="isNumber(this,'i') " /></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
	<br>
	<jsp:include page="../../../button_bar_kntc_mau_phu.jsp" />
	<script language="JavaScript">
var oTable;
$(function(){
    $("#tbl_listPhieuHen tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	});
    var url='kntc_xm_phieu_yc.do?method=getListPhieu&maHs='+document.forms[0].kntcQdinhXm.value+'&t=13/KNTC';
  	oTable=$("#tbl_listPhieuHen").dataTable({
     	"bJQueryUI":true,
		"sDom":'<"H"fr>t<"F"p>',
		"bSort": false,
		"bProcessing": true,
		"bServerSide": true,
		"sAjaxSource":url,
		"oLanguage":language		
	}).fnSetFilteringDelay(500);
});
	
$(document).ready(function(){
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
 }
);
function ghi(){
	document.forms[0].action="kntc_xm_phieu_yc.do?method=save";
	document.forms[0].submit();
}
function print(){
    var maHS = document.forms[0].maHoSo.value;
    //alert(maHS);
	if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+value);
	else
		alert("Chưa có thông tin về hồ sơ!");	
}
function xoa(){
    var maHS = document.forms[0].maHoSo.value;
    //alert(maHS);
	if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+value);
	else
		alert("Chưa có thông tin về hồ sơ!");	
}
function showLovCanbo()
{	
	valueD = document.forms[0].nguoiNhanBc.value;
	if(valueD!=null && valueD!='' && valueD!='null')
		openWindow("danhmuc_canbo.do?method=lov&txtSearch="+valueD);
	else
		openWindow("danhmuc_canbo.do?method=lov");
}
function setData(values){
	var str_val= values.split("@@"); 
 	document.forms[0].nguoiNhanBc.value = str_val[1];				
}

</script>
</html:form>
<%@include file="/bottom.jsp"%>
