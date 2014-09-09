<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Quản lý lớp tập huấn, tuyên truyền KNTC</h3>
<html:form action="/kntc_tg.do?method=lopDt">
	<fieldset><legend>Danh sách lớp tập huấn, tuyên truyền</legend>
	<table cellpadding="0" cellspacing="0" border="0" class="display" id="tbl_listPhieuHen">
		<thead>
			<tr>
				<th width="25%">Tên lớp</th>
				<th width="25%">Địa điểm</th>
				<th width="20%">Từ ngày - Đến ngày</th>
				<th width="20%" align="right" nowrap="nowrap">Số người tham gia</th>
				<th width="10%">Chọn</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="5" class="dataTables_empty">.....</td>
			</tr>
		</tbody>
	</table>
	<TABLE width="100%">
		<tr>
			<td align="right"><input type="button" style="width: 60" class="button" value='Xóa' name="del" onclick="del();"> <input type="button" style="width: 60" class="button" value='Sửa' name="edit" onclick="goHomeKntc();"></td>
		</tr>
	</TABLE>
	</fieldset>
	<br>
	<fieldset><legend>Thông tin lớp</legend>
	<table width="100%">
		<tr>
			<td width="15%" style="text-align: right;">Tên lớp <font color="red">*</font></td>
			<td colspan="3"><html:text property="tenLop" style="width: 100%" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">Địa điểm <font color="red">*</font></td>
			<td width="35%"><html:text property="diaDiem" style="width: 100%" /></td>
			<td width="15%" style="text-align: right;">Số người tham gia <font color="red">*</font></td>
			<td width="35%"><html:text property="soNguoi" style="width: 100%" maxlength="5" onblur="isNumberInt(this);" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">Từ ngày <font color="red">*</font></td>
			<td><html:text property="tuNgay" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this);dateValid();" /></td>
			<td style="text-align: right;">Đến ngày <font color="red">*</font></td>
			<td><html:text property="denNgay" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this);dateValid();" /></td>
		</tr>
	</table>
	</fieldset>
	<jsp:include page="../../button_bar_kntc.jsp" />
	<script language="JavaScript">
var oTable;
$(function(){
	var ghiTC = "";
	 <logic:present name="ghiThanhcong">
	     	ghiTC = '<%=request.getAttribute("ghiThanhcong")%>';
	 </logic:present>
	 if(ghiTC=='1')
	   alert('Lưu thành công'); 
	 else  if(ghiTC=='0')
	   alert('Lỗi khi ghi dữ liệu!!!'); 
    $("#tbl_listPhieuHen tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	});
	var url='kntc_tg.do?method=getListLopDt';
  	oTable=$("#tbl_listPhieuHen").dataTable({ "bJQueryUI":true, "sDom":'<"H"fr>t<"F"p>', "bSort": false, "bProcessing": true, "bServerSide": true, "sAjaxSource":url, "oLanguage":language}).fnSetFilteringDelay(500);
});
function dateValid(){
	if(compareDate(document.forms[0].tuNgay,document.forms[0].denNgay))
		return false;
	return true;	
}
function ghi(){	
	if(isRequired(document.forms[0].tenLop,'Chưa có thông tin lớp học')
	&& isRequired(document.forms[0].diaDiem,'Chưa có thông tin địa điểm')
	&& isRequired(document.forms[0].soNguoi,'Chưa có thông tin số người tham gia')
	&& isRequired(document.forms[0].tuNgay,'Chưa có thông tin ngày bắt đầu')
	&& isRequired(document.forms[0].denNgay,'Chưa có thông tin ngày kết thúc')
	)
	{
		document.forms[0].action="kntc_tg.do?method=savelopDt";
		document.forms[0].submit(); 
	}
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
</script>
</html:form>
<%@include file="/bottom.jsp"%>
