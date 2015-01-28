<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="/kntc_phieu_hen.do?method=show">
	<html:hidden property="maHoSo" />
	<fieldset><legend>Danh sách các phiếu hẹn đã lập</legend>
	<table cellpadding="0" cellspacing="0" border="0" class="display"
		id="tbl_listPhieuHen">
		<thead>
			<tr>
				<th>Mã phiếu</th>
				<th>Thời điểm lập phiếu</th>
				<th>Thời điểm hẹn</th>
				<th>Địa điểm hẹn</th>
			</tr>
		</thead>
		<tbody>
			<tr align="center">
				<td colspan="5" class="dataTables_empty">Loading data from
				server</td>
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
	<fieldset><legend>Thông tin phiếu hẹn mới</legend>
	<TABLE width="100%">
		<TBODY>
			<tr>
				<!--<td>Số giấy biên nhận*</td>-->
				<!-- <td><html:text property="maPhieuHen" style="width:100%" /></td>  -->
				<td width="15%" style="text-align: right;">Thời điểm lập phiếu</td>
				<td width="35%"><html:text styleId="tdLapPhieu"
					property="ngayLapPhieu" style="width:100%" onblur="isTime(this)"
					onkeypress="return formatTime(event, this)" /></td>
				<td width="15%" style="text-align: left;">&nbsp</td>
				<td width="35%">&nbsp</td>
			</tr>
			<tr>
				<td style="text-align: right;">Cán bộ lập phiếu</td>
				<td><html:text property="canBoLapPhieuTen" style="width:100%"
					readonly="true" /></td>
				<td style="text-align: right;">Chức vụ</td>
				<td><html:text property="canBoLapPhieuCV" style="width:100%"
					readonly="true" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Bộ phận công tác</td>
				<td colspan="3"><html:text property="canBoLapPhieuDV"
					style="width:100%" readonly="true" /></td>
				<td style="text-align: right;"></td>
				<td></td>
			</tr>
			<tr>
				<td style="text-align: right;">Người nhận phiếu hẹn<font
					style="color: red;">*</font></td>
				<td><html:text property="nguoiNhanPhieuTen" style="width:100%" /></td>
				<td style="text-align: right;">Địa chỉ<font style="color: red;">*</font></td>
				<td><html:text property="nguoiNhanPhieuDC" style="width:100%" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Thời điểm hẹn<font
					style="color: red;">*</font></td>
				<td><html:text styleId="tdHen" property="thoiDiemHen"
					style="width:100%" onkeypress="return formatTime(event, this)"
					onblur="isTime(this)" /></td>
				<td style="text-align: right;">Địa điểm hẹn<font
					style="color: red;">*</font></td>
				<td><html:text property="diaDiemHen" style="width:100%" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">Mục đích cuộc hẹn<font
					style="color: red;">*</font></td>
				<td colspan="3"><html:textarea property="mucDichHen"
					onkeypress="imposeMaxLength(this);"
					style="width:100%; height:120px;" /></td>
			</tr>
			<html:hidden property="maPhieuHen" styleId="maPhieuHen" />
		</TBODY>
	</TABLE>
	</fieldset>
	<jsp:include page="../../button_bar_kntc_mau_phu.jsp" /></div>
	<script language="JavaScript">
	var oTable;
	var pId;
	var id = '<%=request.getParameter("id")%>';
		var nguoinhan= '<%= request.getParameter("nguoinhan")%>';
		var diachi= '<%= request.getParameter("diachi")%>';
		var r = '<%=request.getParameter("r")%>';
	$(document).ready(function() {
				oTable = $('#example').dataTable({
					"bJQueryUI": true,
					"sPaginationType": "full_numbers"
				});
			} );
	$(function(){
	    var url='kntc_phieu_hen.do?method=getListPhieuHen&id=<%=request.getParameter("id") %>';
	  	oTable=$("#tbl_listPhieuHen").dataTable({
	     	"bJQueryUI":true, "sDom":'<"H"fr>t<"F"p>', "bSort": true, "bFilter": false,"bSort": false,"oLanguage":language,
			"aoColumnDefs": [{"bSortable": false, "aTargets": [ 0 ]}],"sAjaxSource":url,"aaSorting": [[ 1, 'asc' ]]	
		}).fnSetFilteringDelay(500);
		var method = '<%=request.getParameter("method")%>';
	if(method == 'xemPhieuHen' || method == 'taoPhieuHen')
		show('divContent');
	else hide('divContent');
		$("#tbl_listPhieuHen tbody").click(function(event) {
			$(oTable.fnSettings().aoData).each(function (){
				$(this.nTr).removeClass('row_selected');
			});
			$(event.target.parentNode).addClass('row_selected');
			var iPos=oTable.fnGetPosition(event.target.parentNode);
			var aData=oTable.fnGetData(iPos);
			pId = aData[0];
		});
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
		if(validForm()){
			document.forms[0].action="kntc_phieu_hen.do?method=save&id="+id+"&pId="+pId+"&r="+r+"&nguoinhan="+nguoinhan+"&diachi="+diachi;
			document.forms[0].submit();
		}
	}
	function validForm(){
		if(!isRequired(document.forms[0].nguoiNhanPhieuTen,'Chưa nhập tên người nhận phiếu')) return false;
		if(!isRequired(document.forms[0].nguoiNhanPhieuDC,'Chưa nhập địa chỉ người nhận phiếu')) return false;
		if(!isRequired(document.forms[0].thoiDiemHen,'Chưa nhập thời điểm hẹn')) return false;
		if(!isRequired(document.forms[0].diaDiemHen,'Chưa nhập địa điểm hẹn')) return false;
		if(!isRequired(document.forms[0].mucDichHen,'Chưa nhập mục đích hẹn')) return false;	
		if(!compareTime(document.forms[0].tdLapPhieu,document.forms[0].tdHen,'<','Thời điểm hẹn phải sau thời điểm lập phiếu')) return false;
		return true;	
	}
	function print(){
	document.forms[0].action="kntc_phieu_hen.do?method=inPhieuHen";
		document.forms[0].submit();}
	function xoa(){
	    var maHS = document.forms[0].maHoSo.value;
	    //alert(maHS);
		if(maHS!=null && maHS!='' && maHS!='null')
			openWindow("UploadAction.do?parentId="+value);
		else
			alert("Chưa có thông tin về hồ sơ!");	
	}
	
	function xem(){
		var anSelected = fnGetSelected( oTable ); 
		if(anSelected.length>0) {
			document.forms[0].action="kntc_phieu_hen.do?method=xemPhieuHen&id="+id+"&pId="+pId+"&r="+r+"&nguoinhan="+nguoinhan+"&diachi="+diachi;
			document.forms[0].submit();
		}
		else showMessage(chua_chon_ban_ghi);	
	}
	 
	function taomoi(){
		clearAllText();
		document.forms[0].action="kntc_phieu_hen.do?method=taoPhieuHen&id="+id+"&r="+r+"&nguoinhan="+nguoinhan+"&diachi="+diachi;
		document.forms[0].submit();
	}

	function xoa(){
		var anSelected = fnGetSelected( oTable );
		if(anSelected.length>0) {
			if(confirm ("Bạn chắc chắn muốn xóa bản ghi đang chọn?")){
				document.forms[0].action="kntc_phieu_hen.do?method=xoaPhieuHen&id="+id+"&pId="+pId;
				document.forms[0].submit();
			}
		}
		else showMessage(chua_chon_ban_ghi);
	}
	
	function clearAllText()
	{
		$(':text').val("");
		$('textarea').empty();
	}
</script>
</html:form>
<%@include file="/bottom.jsp"%>
