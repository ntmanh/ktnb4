<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ include file="/top_bar.jsp"%>
<h3 class="Header">QUYẾT ĐỊNH TẠM ĐÌNH CHỈ KHIẾU NẠI</h3>
<html:form action="kntc_qd_tam_dinh_chi_thi_hanh.do" method="POST"
	enctype="multipart/form-data">
	<html:hidden property="tamDinhChiKn.id" />
	<div style="text-align: center; width: 100%"><font
		style="font-size: 14px; color: red"> Mã hồ sơ</font> <html:text
		property="tamDinhChiKn.soHs" styleClass="text" style="width:250px"
		readonly="true" /></div>
	<br>
	<fieldset><legend>Danh sách các phiếu đã lập</legend>
	<table cellpadding="0" cellspacing="0" border="0" class="display"
		id="tbl_listData">
		<thead>
			<tr>
				<th>Mã phiếu</th>
				<th>Số quyết định</th>
				<th>Ngày ban hành</th>
				<th>File đính kèm</th>
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
	<fieldset><legend>Thông tin phiếu</legend>
	<TABLE width="100%">
		<TBODY>
			<tr>
				<td width="15%" style="text-align: right;">Số quyết định</td>
				<td width="35%"><html:text styleId="thoiGianBatDauStr"
					property="tamDinhChiKn.soQd" style="width:100%" /></td>
				<td width="15%" style="text-align: left;">Ngày ban hành</td>
				<td width="35%"><html:text styleId="tamDinhChiKn.ngayBanHanhstr"
					property="tamDinhChiKn.ngayBanHanhstr" style="width:100%"
					onblur="isDate(this)" onkeypress="return formatDate(event, this)" /></td>
			</tr>
			<tr>
				<td style="width: 15%" align="right">Nhập file đính kèm</td>
				<td colspan="2"><a href="#" onclick="openUploadFile();">File "đề xuất xử lý" đính kèm</a></td>
			</tr>
		</TBODY>
	</TABLE>
	</fieldset>
	<table width="100%">
		<tr align="center">
			<td align="center"><input type="button" class="button"
				id="btnKetXuat" value='Kết xuất' name="export" onclick="print();">
			<input type="button" id="btnSave" class="button" value='Lưu'
				name="save" onclick="ghi();"> <input type="button"
				id="btnClose" class="button" value='Đóng' name="exit"
				onclick="window.close();"></td>
		</tr>
	</table>
</html:form>
<%@ include file="/bottom.jsp"%>
<script type="text/javascript">

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
	    var url='kntc_qd_tam_dinh_chi_thi_hanh.do?method=getListBienBan&id=<%=request.getParameter("id") %>';
	  	oTable=$("#tbl_listData").dataTable({
	     	"bJQueryUI":true, "sDom":'<"H"fr>t<"F"p>', "bSort": true, "bFilter": false,"bSort": false,"oLanguage":language,
			"aoColumnDefs": [{"bSortable": false, "aTargets": [ 0 ]}],"sAjaxSource":url,"aaSorting": [[ 1, 'asc' ]]	
		}).fnSetFilteringDelay(500);
		var method = '<%=request.getParameter("method")%>';
	if(method == 'xemBienBan' || method == 'taoBienBan')
		show('divContent');
	else hide('divContent');
		$("#tbl_listData tbody").click(function(event) {
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
			document.forms[0].action="kntc_qd_tam_dinh_chi_thi_hanh.do?method=show&action=save&type=tam&id="+id+"&r="+r;
			document.forms[0].submit();
		}
	}
	
	function validForm(){
		
		return true;	
	}
	 
	function openUploadFile(){
		var view='';
		var method = '<%=request.getParameter("method")%>';
		if(method == 'view') view = 'view';
		var r = '<%=request.getParameter("r")%>';
		if(r == 'rol') view = 'view';
		
	    var maHS = id; 
	    if(maHS!=null && maHS!='' && maHS!='null')
			openWindow("UploadAction.do?parentId="+id+"&nv=KNTC/XM/QDTDC&view="+view);
		else
			alert("Chưa có thông tin về hồ sơ!");	
	}
	
	function xem(){
		var anSelected = fnGetSelected( oTable ); 
		if(anSelected.length>0) {
			document.forms[0].action="kntc_qd_tam_dinh_chi_thi_hanh.do?method=xemBienBan&id="+id+"&pId="+pId+"&r="+r;
			document.forms[0].submit();
		}
		else showMessage(chua_chon_ban_ghi);	
	}
	 
	function taomoi(){
		document.forms[0].action="kntc_qd_tam_dinh_chi_thi_hanh.do?method=taoBienBan&id="+id+"&r="+r;
		document.forms[0].submit();
	}

	function xoa(){
		var anSelected = fnGetSelected( oTable );
		if(anSelected.length>0) {
			if(confirm ("Bạn chắc chắn muốn xóa bản ghi đang chọn?")){
				document.forms[0].action="kntc_qd_tam_dinh_chi_thi_hanh.do?method=xoaBienBan&id="+id+"&pId="+pId;
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
