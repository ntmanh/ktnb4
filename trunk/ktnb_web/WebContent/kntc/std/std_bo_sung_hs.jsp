<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Bổ sung hồ sơ tài liệu</h3>
<html:form action="/kntc_bo_sung_hs.do?method=showTlkt" method="post">
	<html:hidden property="arrTenTl" />
	<!-- Ma Ho So -->
	<div style="text-align: center; width: 100%"><font style="font-size: 14px; color: red"> Số hồ sơ</font> <html:text property="maHoSo" style="width:250px" readonly="true" /></div>
	<!-- Tai lieu cu -->
	<fieldset><legend>Tài liệu, đã nộp</legend>
	<table width="50%" cellpadding="0" cellspacing="0" border="0" class="display" id="tblTaiLieu">
		<thead>
			<tr>
				<th>Tên tài liệu</th>
				<th>Loại thông tin</th>
				<th>Vật mang tin</th>
				<th>Số trang</th>
				<th>Tình trạng</th>
			</tr>
		</thead>
		<tbody>
			<tr align="center">
				<td colspan="4" class="dataTables_empty">Loading data from server...</td>
			</tr>
		</tbody>
	</table>
	</fieldset>
	<!-- Tai lieu bo sung -->
	<fieldset><legend>Tài liệu, bổ sung</legend>
	<table width="50%" cellpadding="0" cellspacing="0" border="0" class="display" id="tblTaiLieuMoi">
		<thead>
			<tr>
				<th>Tên tài liệu</th>
				<th>Loại thông tin</th>
				<th>Vật mang tin</th>
				<th>Số trang</th>
				<th>Tình trạng</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td width="30%"><input type="text" id="tenTL1" style="width: 100%" /></td>
				<td width="10%"><select id="loai1">
					<option value="Thông tin">Thông tin</option>
					<option value="Tài liệu">Tài liệu</option>
					<option value="Bằng chứng">Bằng chứng</option>
				<td width="20%"><input type="text" id="vatMT1" style="width: 100%" /></td>
				<td width="20%"><input type="text" id="soTrangTL1" style="width: 100%" maxlength="3" onblur="isNumber(this,'i');" /></td>
				<td width="20%"><select id="tinhTrang1">
					<option value="Bản chính">Bản chính</option>
					<option value="Bản sao">Bản sao</option>
					<option value="Bản sao có công chứng">Bản sao có công chứng</option>
				</select></td>
			</tr>
		</tbody>
	</table>
	<table width="100%">
		<tr>
			<td width="30%"><input type="checkbox" id="checkKetThuc">Kết thúc bổ sung HSTL</input></td>
			<td width="70%" style="text-align: right;"><INPUT type="button" class="button" name="btnAdd" onclick="fnClickAddRow();" value="Thêm"> <INPUT type="button" class="button" name="btnXoa" id="deleteRow" value="Xóa"></td>
		</tr>
	</table>
	</fieldset>
	<!-- Action -->
	<table width="100%">
		<tr align="right">
			<td align="center"><input type="button" class="button" value='Lưu' name="save" onclick="ghi();"> <input type="button" class="button" name="inGiayBienNhan" value="In giấy biên nhận" onclick="giayBienNhan();" /> <input type="button" class="button" value="Đóng" onclick="goHomeKntc();"></td>
		</tr>
	</table>
</html:form>
<script language="JavaScript">
var oTable; //Old table
var oTable2;//New table
var cRowID = 1; //get current row id
var giCount = 1; //Tong so row tren table
$(function(){
	//P: init datatable
	var url='kntc_tiep_dan.do?method=getListTlKt&maHs='+document.forms[0].maHoSo.value;
  	oTable=$("#tblTaiLieu").dataTable({
     	"bJQueryUI":true, "bFilter": false,"bSort": false, "bPaginate": false, "sAjaxSource":url, "oLanguage":language, "aaSorting": [[ 1, 'asc' ]]	
	}).fnSetFilteringDelay(500);
	oTable2=$("#tblTaiLieuMoi").dataTable({
     	"bJQueryUI":true, "bFilter": false,"bSort": false, "bPaginate": false, "oLanguage":language, "aaSorting": [[ 1, 'asc' ]]	
	}).fnSetFilteringDelay(500);
    $("#tblTaiLieuMoi tbody").click(function(event) {
		$(oTable2.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
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
	 if('<%=request.getParameter("kt")%>'=='true'){
	 	document.getElementById('checkKetThuc').checked = true;
	 }else{
	 	document.getElementById('checkKetThuc').checked = false;
	 }
});
//P: Delete row when click button id="deleteRow"
	$('#deleteRow').click( function() {
		var anSelected = fnGetSelected( oTable2 );
		if(anSelected.length>0) {
			oTable2.fnDeleteRow( anSelected[0] );
			giCount--;
		}
		else showMessage(chua_chon_ban_ghi);
	});
//P: Datatable Function
$.fn.dataTableExt.oApi.fnAddTr = function ( oSettings, nTr, bRedraw ) {
	if ( typeof bRedraw == 'undefined' ){
		bRedraw = true;
	}	
	var nTds = nTr.getElementsByTagName('td');
	if ( nTds.length != oSettings.aoColumns.length )
	{
		alert( 'Warning: not adding new TR - columns and TD elements must match' );
		return;
	}	
	var aData = [];
	for ( var i=0 ; i<nTds.length ; i++ )
	{
		aData.push( nTds[i].innerHTML );
	}	
	/* Add the data and then replace DataTable's generated TR with ours */
	var iIndex = this.oApi._fnAddData( oSettings, aData );
	oSettings.aoData[ iIndex ].nTr = nTr;	
	oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();	
	if ( bRedraw )
	{
		this.oApi._fnReDraw( oSettings );
	}
}
//P: Them row moi cho table
function fnClickAddRow() {
	giCount++;
	    var row= '<tr><td width="30%"><input type="text" id="tenTL'+giCount+'" style="width: 100%"></td>'
	    		+'<td width="10%">'
				+'<select id="loai'+giCount+'">'
						+'<option value="Thông tin">Thông tin</option>'
						+'<option value="Tài liệu">Tài liệu</option>'
						+'<option value="Bằng chứng">Bằng chứng</option>'
				  +'</select>'
				+'</td>' 
	    		+'<td width="20%"><input type="text" id="vatMT'+giCount+'" style="width: 100%" maxlength="3" onblur="isNumber(this,"i");" /></td>'
	   			+'<td width="20%"><input type="text" id="soTrangTL'+giCount+'" style="width: 100%" maxlength="3" onblur="isNumber(this,"i");" /></td>'
				+'<td width="20%">'
				+'<select id="tinhTrang'+giCount+'">'
						+'<option value="Bản chính">Bản chính</option>'
						+'<option value="Bản sao">Bản sao</option>'
						+'<option value="Bản sao có công chứng">Bản sao có công chứng</option>'
				  +'</select>'
				+'</td></tr>';
	oTable2.fnAddTr( $(row)[0] );	
}
//Ghi
function ghi(){
	if(confirm ("Bạn cần kiểm tra in biên nhận và tải về máy tính trước khi lưu thông tin tài liệu đính kèm,Sau khi lưu sẽ không in được biên nhận!!!\n\n Ấn OK để xác nhận lưu\n Ấn Cancel thực hiện chức năng khác")){
		var arrTl='';
		for(i=1;i<=giCount;i++){
			if(!isEmpty(document.getElementById('tenTL'+i).value))
			{
				arrTl += document.getElementById('tenTL'+i).value+',';
				arrTl += document.getElementById('loai'+i).value+',';
				arrTl += document.getElementById('vatMT'+i).value+',';
				arrTl += document.getElementById('soTrangTL'+i).value+',';
				arrTl += document.getElementById('tinhTrang'+i).value+'';				
				arrTl += '@@';			
			}		
		}	
		//alert(arrTl);
		if(arrTl.length==0 && (document.forms[0].checkKetThuc.checked==false)){
			alert('Không có dữ liệu để cập nhật!');
			return false;
		}
		document.forms[0].arrTenTl.value = arrTl;
		//document.forms[0].countCanBo.value = giCount;
		//showMessage(document.forms[0].arrCanBo.value);
		if(document.forms[0].checkKetThuc.checked==true){
			document.forms[0].action="kntc_bo_sung_hs.do?method=saveTlkt&kt=true&del=false";
		} else {
			document.forms[0].action="kntc_bo_sung_hs.do?method=saveTlkt&kt=false&del=false";
		}
		document.forms[0].submit();
	}
}
function giayBienNhan(){	
var arrTl='';
	for(i=1;i<=giCount;i++){
		if(!isEmpty(document.getElementById('tenTL'+i).value))
		{
			arrTl += document.getElementById('tenTL'+i).value+'%%';
			arrTl += document.getElementById('loai'+i).value+'%%';
			arrTl += document.getElementById('vatMT'+i).value+'%%';
			arrTl += document.getElementById('soTrangTL'+i).value+'%%';
			arrTl += document.getElementById('tinhTrang'+i).value+'%%';				
			arrTl += '@@';			
		}		
	}	 
	//alert(arrTl);
	if(arrTl.length==0 && (document.forms[0].checkKetThuc.checked==false)){
		alert('Không có dữ liệu để cập nhật!');
		return false;
	}
	document.forms[0].arrTenTl.value = arrTl;
	document.forms[0].action="kntc_tiep_dan.do?method=inGbn&id="+document.forms[0].maHoSo.value;;
	document.forms[0].submit();
}
</script>
<%@ include file="/bottom.jsp"%>
