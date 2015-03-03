<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%>
<h3 class="Header">Chuyển cơ quan điều tra</h3>
<html:form action="chuyen_co_quan_dieu_tra.do?method=show">
	<html:hidden property="chuyenCqDieuTra.maPhieu" styleId="ma" />
	<div style="text-align: center; width: 100%; display : none;"><font
		style="font-size: 14px; color: red"> Số Hồ Sơ</font> <html:text
		property="chuyenCqDieuTra.maHoSo" styleId="soQD" styleClass="text"
		style="width:250px" readonly="true" /></div>

	<div style="text-align: center; width: 100%; "><font
		style="font-size: 14px; color: red"> Số Hồ Sơ</font> <html:text
		property="chuyenCqDieuTra.maHoSo" styleId="maHoSo" styleClass="text"
		style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Danh sách các phiếu đã lập</legend>
	<table cellpadding="0" cellspacing="0" border="0" class="display"
		id="tbl_listPhieuHen">
		<thead>
			<tr>
				<th>Mã phiếu</th>
				<th>Số quyết định</th>
				<th>Ngày ban hành</th>
				<th>Số người</th>
				<th>File đính kèm</th>
			</tr>
		</thead>
		<tbody>
			<tr align="center">
				<td colspan="3" class="dataTables_empty">.....</td>
			</tr>
		</tbody>
	</table>
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" id="btnXem"
				class="button" value='Xem' onclick="xem();" /> <input type="button"
				class="button" value='Tạo mới' onclick="taomoi();" /> <input
				type="button" class="button" value='Xóa' onclick="xoa();" /> <input
				type="button" class="button" value='Đóng' onclick="window.close();"></td>
		</tr>
	</table>
	</fieldset>
	<div id="divContent">
	<fieldset><legend>Thông tin phiếu</legend>
	<TABLE width="100%">
		<TBODY>
			<tr>
				<td width="15%" style="text-align: right;">Số công văn quyết
				định <font color="red">*</font></td>
				<td width="35%"><html:text
					property="chuyenCqDieuTra.soCongVanChuyen" style="width:100%" /></td>
				<td width="15%" style="text-align: right;">Ngày ban hành <font
					color="red">*</font></td>
				<td width="35%"><html:text
					property="chuyenCqDieuTra.ngayBanHanhStr" style="width:100%"
					maxlength="10" onkeypress="return formatDate(event, this)"
					onblur="isDate(this)" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Số người <font color="red">*</font></td>
				<td><html:text property="chuyenCqDieuTra.soNguoi"
					style="width:100%" /></td>
				<td style="text-align: right;"></td>
				<td></td>
			</tr>
			<tr>
				<td style="text-align: right;">Tài liệu gửi kèm<font
					color="red">*</font></td>
				<td colspan="3"><html:text property="chuyenCqDieuTra.taiLieu"
					style="width:100%" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Đã khởi tố</td>
				<td><html:checkbox property="chuyenCqDieuTra.daKhoiTo" styleId="daKhoiTo" 
					onclick="showDivKhoiTo();" /></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="3"><A href="#" onclick="openUploadFile(1);">File
				đính kèm chuyển cơ quan điều tra</A></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>

	<fieldset><legend>Thông tin ký duyệt</legend>
	<TABLE width="100%">
		<TBODY>
			<tr>
				<td width="15%" align="right">Ng&#224;y tr&#236;nh
				tr&#432;&#7903;ng b&#7897; ph&#7853;n k&#253;</td>
				<td width="35%"><html:text
					property="chuyenCqDieuTra.ngayTrinhBoTruongKyStr" styleId="ngayTrinhBoTruongKyStr"
					style="width:100%" onkeypress="return formatDate(event, this)"
					maxlength="10" onblur="isDate(this);dateValid();" /></td>
				<td width="15%" align="right">Ng&#224;y tr&#432;&#7903;ng
				b&#7897; ph&#7853;n k&#253;</td>
				<td width="35%"><html:text
					property="chuyenCqDieuTra.ngayBoTruongKyStr" styleId="ngayBoTruongKyStr" style="width: 100%"
					onkeypress="return formatDate(event, this)" maxlength="10"
					onblur="isDate(this);dateValid();" /></td>
			</tr>
			<tr>
				<td width="15%" align="right">&#221; ki&#7871;n c&#7911;a
				tr&#432;&#7903;ng b&#7897; ph&#7853;n</td>
				<td colspan="3"><html:textarea
					property="chuyenCqDieuTra.ykienBoTruong"
					onkeypress="imposeMaxLength(this);" style="width:100%;height:40px;" /></td>
			</tr>
			<tr>
				<td width="15%" align="right">Ng&#224;y tr&#236;nh th&#7911;
				tr&#432;&#7903;ng k&#253;</td>
				<td width="35%"><html:text
					property="chuyenCqDieuTra.ngayTrinhThuTruongStr" styleId="ngayTrinhThuTruongStr" style="width:100%"
					maxlength="10" onkeypress="return formatDate(event, this)"
					onblur="isDate(this);dateValid();" /></td>
				<td width="15%" align="right">Ng&#224;y th&#7911;
				tr&#432;&#7903;ng k&#253;</td>
				<td width="312" align="right"><html:text
					property="chuyenCqDieuTra.ngayThuTruongKyStr" styleId="ngayThuTruongKyStr" style="width: 100%"
					maxlength="10" onkeypress="return formatDate(event, this)"
					onblur="isDate(this);dateValid();" /></td>
			</tr>
			<tr>
				<td width="15%" align="right">&#221; ki&#7871;n c&#7911;a
				th&#7911; tr&#432;&#7903;ng</td>
				<td colspan="3"><html:textarea
					property="chuyenCqDieuTra.ykienThuTruong"
					onkeypress="imposeMaxLength(this);" style="width:100%;height:40px;" /></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>

	<fieldset style="display: none;" id="divKhoito"><legend>Thông tin khởi tố</legend>
	<TABLE width="100%">
		<TBODY>
			<tr>
				<td width="15%" style="text-align: right;">Số thông báo/quyết
				định <font color="red">*</font></td>
				<td width="35%"><html:text
					property="chuyenCqDieuTra.soThongBaoKhoiTo" style="width:100%" /></td>
				<td width="15%" style="text-align: right;">Ngày ban hành <font
					color="red">*</font></td>
				<td width="35%"><html:text
					property="chuyenCqDieuTra.ngayBanHanhKhoiToStr" style="width:100%"
					maxlength="10" onkeypress="return formatDate(event, this)"
					onblur="isDate(this)" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Số đối tượng <font color="red">*</font></td>
				<td><html:text property="chuyenCqDieuTra.soDoiTuongKhoiTo"
					style="width:100%" /></td>
				<td style="text-align: right;"></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="3"><A href="#" onclick="openUploadFile(2);">File
				đính kèm khởi tố</A></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
	<table width="100%">
		<tr align="center">
			<td align="center">
<!--			<input type="button" class="button"-->
<!--				id="btnKetXuat" value='Kết xuất' name="export" onclick="print();">-->
			<input type="button" id="btnSave" class="button" value='Lưu'
				name="save" onclick="ghi();"> <input type="button"
				id="btnClose" class="button" value='Đóng' name="exit"
				onclick="window.close();"></td>
		</tr>
	</table>
	</div>
	<script language="JavaScript"><!--
var oTable;
var pId;
$(function(){
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
    
    $("#tbl_listPhieuHen tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
		var iPos=oTable.fnGetPosition(event.target.parentNode);
		var aData=oTable.fnGetData(iPos);
		pId = aData[0];
	});
    var url='chuyen_co_quan_dieu_tra.do?method=getListPhieuChuyen&maHs='+encodeURL(document.forms[0].maHoSo.value)+'&t=15A/KNTC';
  	oTable=$("#tbl_listPhieuHen").dataTable({
     	"bJQueryUI":true,
		"sDom":'<"H"fr>t<"F"p>',
		"bSort": false,
		"bFilter": false,
		"bProcessing": true,
		"bServerSide": true,
		"sAjaxSource":url,
		"oLanguage":language		
	}).fnSetFilteringDelay(500);
	
	var method = '<%=request.getParameter("method")%>';
	if(method == 'xemPhieu' || method == 'taoMoiPhieu')
		show('divContent');
	else hide('divContent');
	
	showDivKhoiTo();
});
function ghi(){
	if(validForm()){	  
		if(pId=='undefined' || pId == null || 'taoMoiYcgt'=='<%=request.getParameter("method")%>'){			
			if(	'null' == '<%=request.getParameter("pId")%>'){
				document.forms[0].action="chuyen_co_quan_dieu_tra.do?method=show&action=savePhieu&id="+document.forms[0].maHoSo.value+"&action="+'<%=request.getParameter("action")%>';	
			}else{
				document.forms[0].action="chuyen_co_quan_dieu_tra.do?method=show&action=savePhieu&id="+document.forms[0].maHoSo.value+"&pId="+'<%=request.getParameter("pId")%>'+"&action="+'<%=request.getParameter("action")%>';
			}
		}
		else{
			document.forms[0].action="chuyen_co_quan_dieu_tra.do?method=show&action=savePhieu&id="+document.forms[0].maHoSo.value+"&pId="+pId+"&action="+'<%=request.getParameter("action")%>';		
		}		 
		document.forms[0].submit();
	}	
}
function print(){
    document.forms[0].action="chuyen_co_quan_dieu_tra.do?method=in&type=15/KTNB&action="+'<%=request.getParameter("action")%>';
    document.forms[0].submit();
}
function xem(){
	var r = '<%=request.getParameter("r")%>';
	var anSelected = fnGetSelected( oTable );
	if(anSelected.length>0) {
		document.forms[0].action="chuyen_co_quan_dieu_tra.do?method=xemPhieu&id="+document.forms[0].maHoSo.value+"&pId="+pId+"&action="+'<%=request.getParameter("action")%>'+"&r="+r;
		//alert("kntc_xm_phieu_yc.do?method=xemYcgt&id="+document.forms[0].soQD.value+"&pId="+pId);
		document.forms[0].submit();
	}
	else showMessage(chua_chon_ban_ghi);
}

function taomoi(){
	document.forms[0].action="chuyen_co_quan_dieu_tra.do?method=taoMoiPhieu&id="+document.forms[0].maHoSo.value+"&action="+'<%=request.getParameter("action")%>';
	document.forms[0].submit();
}

function xoa(){
	var anSelected = fnGetSelected( oTable );
	if(anSelected.length>0) {
		if(confirm ("Bạn chắc chắn muốn xóa bản ghi đang chọn?")){
			document.forms[0].action="chuyen_co_quan_dieu_tra.do?method=show&action=xoaPhieu&id="+document.forms[0].maHoSo.value+"&pId="+pId+"&action="+'<%=request.getParameter("action")%>';
			document.forms[0].submit();
		}
	}
	else showMessage(chua_chon_ban_ghi);
}
function showDivKhoiTo()
{
	if(document.forms[0].daKhoiTo.checked)
		show("divKhoiTo");
	else 
		hide("divKhoiTo");
}
function dateValid(){
	if(!compareDate(document.forms[0].ngayTrinhBoTruongKyStr,document.forms[0].ngayBoTruongKyStr))
		return false;
	if(!compareDate(document.forms[0].ngayTrinhThuTruongStr,document.forms[0].ngayThuTruongKyStr))
		return false;
	if(!compareDate(document.forms[0].ngayBoTruongKyStr,document.forms[0].ngayTrinhThuTruongStr))
		return false;
	return true;	
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

function validForm() {
	//if(!isRequired(document.forms[0].diaDiem,'Chưa nhập địa điểm lập phiếu')) return false;
//	if(!isRequired(document.forms[0].ngayLap,'Chưa nhập ngày lập phiếu')) return false;
//	if(!isRequired(document.forms[0].donViYkien,'Chưa nhập đơn vị, tổ chức lấy ý kiến')) return false;
//	if(!isRequired(document.forms[0].yeuCauYcgt,'Chưa nhập nội dung lấy ý kiến')) return false;
	//if(!isRequired(document.forms[0].thoiDiemYcgt,'Chưa nhập yêu cầu giải trình')) return false;
	return true;
}

function openUploadFile(value){
	if(validForm())
	{   
		var view='';
		var method = '<%=request.getParameter("method")%>';
		if(method == 'view') view = 'view';
		var r = '<%=request.getParameter("r")%>';
		if(r == 'rol') view = 'view';
		
	    var maHS = document.forms[0].maHoSo.value;
	    var act = '<%=request.getParameter("action")%>';    
	    if(maHS!=null && maHS!='' && maHS!='null' && value == 1)
			openWindow("UploadAction.do?parentId="+maHS+"&nv=CCQ&view="+view);
		else if(maHS!=null && maHS!='' && maHS!='null' && value == 2)
			openWindow("UploadAction.do?parentId="+maHS+"&nv=CCQ/KT&view="+view);	
		else
			alert("Chưa có thông tin về hồ sơ!");	
	}
}
--></script>
</html:form>
<%@include file="/bottom.jsp"%>
