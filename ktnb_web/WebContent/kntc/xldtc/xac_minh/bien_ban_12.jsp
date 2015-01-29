<%@ page pageEncoding="UTF-8"%>

<%@ include file="/top_bar.jsp"%>
<!--TODO: P: Sua header tuy theo bieu mau -->
<h3 class="Header">Biên bản làm việc - Mẫu 12/KNTC</h3>
<html:form action="kntc_khxm.do?method=bb">
	<html:hidden property="act" styleId="act" />
	<div style="text-align: center; width: 100%"><font
		style="font-size: 14px; color: red">Số hồ sơ</font> <html:text
		property="maHoSo" styleId="maHoSo" styleClass="text"
		style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Danh sách các phiếu đã lập</legend>
	<table cellpadding="0" cellspacing="0" border="0" class="display"
		id="tblDanhSachPhieu">
		<thead>
			<tr>
				<th>Mã phiếu</th>
				<th>Địa điểm</th>
				<th>Thời gian bắt đầu</th>
				<th>Thời gian kết thúc</th>
				<th>File lưu trữ</th>
			</tr>
		</thead>
		<tbody>
			<tr align="center">
				<td colspan="4" class="dataTables_empty">Loading data from
				server...</td>
			</tr>
		</tbody>
	</table>
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" class="button"
				id="btnXem" value='Xem' onclick="xem();" /> <input type="button"
				class="button" value='Tạo mới' onclick="taomoi();" /> <input
				type="button" class="button" value='Xóa' onclick="xoa();" /> <input
				type="button" class="button" id="btnClose2" value='Đóng'
				onclick="window.close();"></td>
		</tr>
	</table>
	</fieldset>
	<div id="divContent">
	<fieldset><legend>Biên bản làm việc</legend>
	<table width="100%">
		<tr>
			<td width="15%" style="text-align: right;">Địa điểm họp<font
				style="color: red">*</font></td>
			<td width="289"><html:text property="diaDiem" style="width:100%" maxlength="1000"/></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">Thời gian bắt đầu<font
				style="color: red">*</font></td>
			<td width="312"><html:text property="thoiDiem"
				style="width: 100%" onblur="isTime(this)"
				onkeypress="return formatTime(event, this)" /></td>
			<td width="15%" style="text-align: right;">Thời gian kết thúc<font
				style="color: red">*</font></td>
			<td width="312"><html:text property="thoiDiemHoanThanh"
				style="width: 100%" onblur="isTime(this)"
				onkeypress="return formatTime(event, this)" /></td>

		</tr>
		<tr>
			<td style="text-align: right;">File lưu trữ</td>
			<td><html:text property="soBanIn" value="2" style="width:78%" />
			<input type="button" style="width: 20%" value='Tải lên' onclick="openUploadFile();" /></td>
			<td colspan="2"></td>
		</tr>
	</table>
	</fieldset>
	<jsp:include page="../../../button_bar_kntc_mau_phu.jsp" /></div>
</html:form>
<script type="text/javascript" language="JavaScript" charset="utf-8">
var oTable;
var pId;
$(function(){	
	$("#tblDanhSachPhieu tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	    var iPos=oTable.fnGetPosition(event.target.parentNode);
		var aData=oTable.fnGetData(iPos);
		pId = aData[0];
	});
	
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
	var xoaTC = "";
	 <logic:present name="xoaThanhcong">
	     	xoaTC = '<%=request.getAttribute("xoaThanhcong")%>';
	 </logic:present>
	 if(xoaTC=='1')
	   alert('Xóa dữ liệu thành công!'); 
	 else  if(xoaTC=='0')
	   alert('Lỗi khi xóa dữ liệu!!!');	
    
    var url='kntc_khxm.do?method=getListBienBan&maHs='+document.forms[0].maHoSo.value+'&action='+document.forms[0].act.value;
  	oTable=$("#tblDanhSachPhieu").dataTable({
     	"bJQueryUI":true, "sDom":'<"H"fr>t<"F"p>', "bSort": false, "bFilter": false,
		"bProcessing": true, "bServerSide": true, "sAjaxSource":url, "oLanguage":language		
	}).fnSetFilteringDelay(500);
	
	var method = '<%=request.getParameter("method")%>';
	if(method == 'xemBblv' || method == 'taoMoiBblv')
		show('divContent');
	else hide('divContent');
});
function print(){
	document.forms[0].action="kntc_khxm.do?method=inBbQdxm";
	document.forms[0].submit();
}
function ghi(){
	if(validForm()) {
		if(pId=='undefined' || pId == null || 'taoMoiBblv'=='<%=request.getParameter("method")%>'){			
			if(	'null' == '<%=request.getParameter("pId")%>'){
				document.forms[0].action="kntc_khxm.do?method=saveBblv&id="+document.forms[0].maHoSo.value;	
			}else{
				document.forms[0].action="kntc_khxm.do?method=saveBblv&id="+document.forms[0].maHoSo.value+"&pId="+'<%=request.getParameter("pId")%>';
			}
		}
		else{
			document.forms[0].action="kntc_khxm.do?method=saveBblv&id="+document.forms[0].maHoSo.value+"&pId="+pId;		
		}
		document.forms[0].submit();
	}
}
function xem(){
	var r = '<%=request.getParameter("r")%>';
	var anSelected = fnGetSelected( oTable );
	if(anSelected.length>0) {
		document.forms[0].action="kntc_khxm.do?method=xemBblv&action=bbxmtc&id="+document.forms[0].maHoSo.value+"&pId="+pId+"&r="+r;
		document.forms[0].submit();
	}
	else showMessage(chua_chon_ban_ghi);	
}

function taomoi(){
	document.forms[0].action="kntc_khxm.do?method=taoMoiBblv&action=bbxmtc&id="+document.forms[0].maHoSo.value;
	document.forms[0].submit();
}

function xoa(){
	var anSelected = fnGetSelected( oTable );
	if(anSelected.length>0) {
		if(confirm ("Bạn chắc chắn muốn xóa bản ghi đang chọn?")){
			document.forms[0].action="kntc_khxm.do?method=xoaBblv&action=bbxmtc&id="+document.forms[0].maHoSo.value+"&pId="+pId;
			document.forms[0].submit();
		}
	}
	else showMessage(chua_chon_ban_ghi);
}

function validForm() {
	if(!isRequired(document.forms[0].diaDiem,'Chưa nhập địa điểm')) return false;
	if(!isRequired(document.forms[0].thoiDiem,'Chưa nhập thời gian bắt đầu')) return false;
	if(!isRequired(document.forms[0].thoiDiemHoanThanh,'Chưa nhập thời gian kết thúc')) return false;
	//if(!isRequired(document.forms[0].noiDung,'Chưa nhập nội dung làm việc')) return false;
	//if(!isRequired(document.forms[0].thanhPhan,'Chưa nhập các bên liên quan')) return false;
	return true;
}
function openUploadFile(){
	if(validForm())
	{
		var view='';
		var method = '<%=request.getParameter("method")%>';
		if(method == 'view') view = 'view';
		var r = '<%=request.getParameter("r")%>';
		if(r == 'rol') view = 'view';
		
	    var maHS = document.forms[0].maHoSo.value;
	    var act = '<%=request.getParameter("action")%>';    
	    if(maHS!=null && maHS!='' && maHS!='null')
			openWindow("UploadAction.do?parentId="+maHS+"&nv="+act+"&view="+view);
		else
			alert("Chưa có thông tin về hồ sơ!");	
	}
}
</script>
<%@ include file="/bottom.jsp"%>
