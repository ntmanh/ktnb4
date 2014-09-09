<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Phiếu yêu cầu cung cấp báo cáo hồ sơ, tài liệu - 13/KNTC</h3>
<html:form action="/kntc_xm_phieu_yc.do?method=show">
	<html:hidden property="maHoSo" styleId="maHoSo" />
	<html:hidden property="ma" styleId="ma" />
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red"> Số Quyết định</font> <html:text property="kntcQdinhXm" styleId="soQD" styleClass="text" style="width:250px" readonly="true" /></div>
	<br>
	<fieldset><legend>Danh sách các phiếu đã lập</legend>
	<table cellpadding="0" cellspacing="0" border="0" class="display" id="tbl_listPhieuHen">
		<thead>
			<tr>
				<th>Mã</th>
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
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" id="btnXem" class="button" value='Xem' onclick="xem();" /> <input type="button" class="button" value='Tạo mới' onclick="taomoi();" /> <input type="button" class="button" value='Xóa' onclick="xoa();" /> <input type="button"
				class="button" value='Đóng' onclick="window.close();"></td>
		</tr>
	</table>
	</fieldset>
	<div id="divContent">
	<fieldset><legend>Thông tin phiếu yêu cầu</legend>
	<TABLE width="100%">
		<TBODY>
			<tr>
				<td width="15%" style="text-align: right;">Địa điểm lập phiếu <font color="red">*</font></td>
				<td width="35%"><html:text property="diaDiem" style="width:100%" /></td>
				<td width="15%" style="text-align: right;">Ngày lập phiếu <font color="red">*</font></td>
				<td width="35%"><html:text property="ngayLap" maxlength="10" style="width:100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right;">Đơn vị, tổ chức, cá nhân được yêu cầu cung cấp <font color="red">*</font></td>
				<td><html:text property="donViYcgt" style="width:100%" /></td>
				<td style="text-align: right;">Lần yêu cầu</td>
				<td><html:text property="lanYc" style="width:100%" maxlength="2" onblur="isNumber(this,'i') " /></td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right;">Các báo cáo cần cung cấp</td>
				<td colspan="3"><html:textarea property="ycBaoCao" onkeypress="imposeMaxLength(this);" style="width:100%;height:80px;" /></td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right;">Các hồ sơ, tài liệu cần cung cấp</td>
				<td colspan="3"><html:textarea property="ycHoSo" onkeypress="imposeMaxLength(this);" style="width:100%;height:80px;" /></td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right;">Thời gian cung cấp tài liệu <font color="red">*</font></td>
				<td><html:text property="thoiDiemYcgt" style="width:100%" onblur="isTime(this)" onkeypress="return formatTime(event, this)" /></td>
				<td width="15%" style="text-align: right;">Địa điểm cung cấp</td>
				<td><html:text property="diaDiemYcgt" style="width:100%" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Người nhận báo cáo, hồ sơ, tài liệu <font color="red">*</font></td>
				<td><html:select property="nguoiNhanBc" styleClass="combobox" style="width:100%">
					<html:options collection="dmcb" property="value" labelProperty="label" />
				</html:select></td>
				<td style="text-align: right;"></td>
				<td></td>
			</tr>
			<tr>
				<td style="text-align: right;">Người nhận phiếu yêu cầu <font color="red">*</font></td>
				<td><html:text property="nguoiNhanPhieu" style="width:100%" /></td>
				<td style="text-align: right;">Chức vụ</td>
				<td><html:text property="nguoiNhanPhieuChucVu" style="width:100%" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Thời gian giao phiếu <font color="red">*</font></td>
				<td><html:text property="thoiGianNhanPhieu" style="width:100%" onblur="isTime(this)" onkeypress="return formatTime(event, this)" /></td>
				<td style="text-align: right;"></td>
				<td></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
	<jsp:include page="../../../../button_bar_kntc_mau_phu.jsp" /></div>
	<script language="JavaScript">
var oTable;
var pId;
$(function(){
	$("#tbl_listPhieuHen tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
		var iPos=oTable.fnGetPosition(event.target.parentNode);
		var aData=oTable.fnGetData(iPos);
		pId = aData[0];
	});
    var url='kntc_xm_phieu_yc.do?method=getListPhieu&maHs='+encodeURL(document.forms[0].maHoSo.value)+'&t=13/KNTC';
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
	if(method == 'xemPycHstl' || method == 'taoMoiPycHstl')
		show('divContent');
	else hide('divContent');
});
	
$(document).ready(function(){
	 var ghiTC = "";
	 <logic:present name="ghiThanhcong">
	     	ghiTC = '<%=request.getAttribute("ghiThanhcong")%>';
	 </logic:present>
	 if(ghiTC=='1')
	   alert('Lưu thành công'); 
	 else  if(ghiTC=='0')
	   alert('Lỗi khi ghi dữ liệu!!!');  
	  /*document.forms[0].lanYc.value = $('#tbl_listPhieuHen tr').length + 1;*/
	  var xoaTC = "";
	 <logic:present name="xoaThanhcong">
	     	xoaTC = '<%=request.getAttribute("xoaThanhcong")%>';
	 </logic:present>
	 if(xoaTC=='1')
	   alert('Xóa dữ liệu thành công!'); 
	 else  if(xoaTC=='0')
	   alert('Lỗi khi xóa dữ liệu!!!');
 }
);
function ghi(){
	if(validRequid()) {
		document.forms[0].action="kntc_xm_phieu_yc.do?method=savePyc";
		
		if(pId=='undefined' || pId == null || 'taoMoiPycHstl'=='<%=request.getParameter("method")%>'){		
		//alert('<%=request.getParameter("pId")%>');	
			if(	'null' == '<%=request.getParameter("pId")%>'){
				document.forms[0].action="kntc_xm_phieu_yc.do?method=savePyc&id="+document.forms[0].maHoSo.value+"&action="+'<%=request.getParameter("action")%>';	
			}else{
				document.forms[0].action="kntc_xm_phieu_yc.do?method=savePyc&id="+document.forms[0].maHoSo.value+"&pId="+'<%=request.getParameter("pId")%>'+"&action="+'<%=request.getParameter("action")%>';
			}
		}
		else{
			document.forms[0].action="kntc_xm_phieu_yc.do?method=savePyc&id="+document.forms[0].maHoSo.value+"&pId="+pId+"&action="+'<%=request.getParameter("action")%>';		
		}
		
		document.forms[0].submit();
	}	
}

function print(){
	document.forms[0].action="kntc_xm_phieu_yc.do?method=in&type=13/KTNB&action="+'<%=request.getParameter("action")%>';
	document.forms[0].submit();
}

function xem(){
	var r = '<%=request.getParameter("r")%>';
	var anSelected = fnGetSelected( oTable );
	if(anSelected.length>0) {
	document.forms[0].action="kntc_xm_phieu_yc.do?method=xemPycHstl&id="+document.forms[0].maHoSo.value+"&pId="+pId+"&action="+'<%=request.getParameter("action")%>'+"&r="+r;
	document.forms[0].submit();
	}
	else showMessage(chua_chon_ban_ghi);
}

function taomoi(){
	document.forms[0].action="kntc_xm_phieu_yc.do?method=taoMoiPycHstl&id="+document.forms[0].maHoSo.value+"&action="+'<%=request.getParameter("action")%>';
	document.forms[0].submit();
}

function xoa(){
	var anSelected = fnGetSelected( oTable );
	if(anSelected.length>0) {
		if(confirm ("Bạn chắc chắn muốn xóa bản ghi đang chọn?")){
			document.forms[0].action="kntc_xm_phieu_yc.do?method=xoaPycHstl&id="+document.forms[0].maHoSo.value+"&pId="+pId+"&action="+'<%=request.getParameter("action")%>';
			document.forms[0].submit();
		}
	}
	else showMessage(chua_chon_ban_ghi);
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
// diaDiem, ngayLap, donViYcgt, ycBaoCao, ycHoSo,thoiDiemYcgt, nguoiNhanBc, nguoiNhanPhieu, thoiGianNhanPhieu, lanYc
function validRequid() {
//	if(!isRequired(document.forms[0].diaDiem,'Chưa nhập địa điểm lập phiếu')) return false;
	//if(!isRequired(document.forms[0].ngayLap,'Chưa nhập ngày lập phiếu')) return false;
	if(!isRequired(document.forms[0].donViYcgt,'Chưa nhập đơn vị tổ chức cá nhân được yêu cầu cung cấp')) return false;
	//if(!isRequired(document.forms[0].ycBaoCao,'Chưa nhập các báo cáo cần cung cấp')) return false;
	//if(!isRequired(document.forms[0].ycHoSo,'Chưa nhập các hồ sơ tài liệu cần cung cấp')) return false;
	if(!isRequired(document.forms[0].thoiDiemYcgt,'Chưa nhập thời gian cung cấp tài liệu')) return false;
	if(!isRequired(document.forms[0].nguoiNhanBc,'Chưa nhập người nhận báo cáo hồ sơ tài liệu')) return false;
	if(!isRequired(document.forms[0].nguoiNhanPhieu,'Chưa nhập người nhận phiếu yêu cầu')) return false;
	if(!isRequired(document.forms[0].thoiGianNhanPhieu,'Chưa nhập thời gian giao phiếu')) return false;
	//if(!isRequired(document.forms[0].lanYc,'Chưa nhập lần yêu cầu')) return false;
	return true;	
}
</script>
</html:form>
<%@include file="/bottom.jsp"%>
