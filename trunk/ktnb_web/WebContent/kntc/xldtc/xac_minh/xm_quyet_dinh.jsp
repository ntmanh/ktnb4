<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar_tab.jsp"%>
<!-- Mẫu 22/KNTC . Tương tự mẫu 10 -->
<html:form action="/kntc_xac_minh.do">
	<html:hidden property="countCanBo" />
	<html:hidden property="arrCanBo" />
	<html:hidden property="maHidden" />	
	<html:hidden property="maHoSo" />	
	<fieldset><legend>Thông tin quyết định xác minh</legend>
	<table width="100%">
		<tr>
			<td style="text-align: right;">Số quyết định</td>
			<td><html:text property="soQd" style="width: 100%" /></td>
			<td width="15%" style="text-align: right;">Ngày ban hành</td>
			<td width="35%"><html:text property="thoiDiem" maxlength="10" style="width: 100%" onkeypress="return formatDate(event, this)" onblur="isDate(this)" /></td>
		</tr>
		<tr>
			<td width="15%" style="text-align: right;">Địa điểm</td>
			<td width="35%"><html:text styleClass="textbox_Style" style="width: 100%" property="diaDiem" /></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td style="text-align: right;">Căn cứ văn bản</td>
			<td colspan="3"><html:select property="canCuVanBan" styleClass="combobox" style="width:100%">
				<html:options collection="dmtly" property="value" labelProperty="label" />
			</html:select></td>
		</tr>
		<tr>
			<td style="text-align: right;">Căn cứ nhiệm vụ<br />
			(Nếu có)</td>
			<td colspan="3"><html:textarea property="canCuNhiemVu" style="width: 100%" rows="3"></html:textarea></td>
		</tr>
		<tr>
			<td style="text-align: right;">Hành vi của người bị tố cáo</td>
			<td colspan="3"><html:textarea property="nguoiBiTcHanhVi" style="width: 100%" rows="3"></html:textarea></td>
		</tr>
		<tr>
			<td style="text-align: right;">Thời gian xác minh <font style="color: red">*</font></td>
			<td colspan="3"><html:text property="soNgayXm" maxlength="2" style="width:40px" onkeypress="return formatInt(event);" onblur="validDateXm()" />
			 &nbsp; &nbsp;Ngày &nbsp; &nbsp; Kể từ ngày 
			 <html:text property="tuNgayXm" style="width:120px" maxlength="10"
				onkeypress="return formatDate(event, this)" onblur="isDate(this);validDateXm()" />
			 &nbsp; &nbsp; Đến ngày 
			 <html:text property="denNgayXm" style="width:120px" maxlength="10" readonly="true" /></td>
		</tr>
		<tr>
			<td></td>
			<td colspan="3">
			<fieldset style="margin: 0"><legend>Thành viên đoàn (tổ) xác minh</legend>
			<table cellpadding="0" cellspacing="0" border="0" id="tbl_listCBXL" class="display">
				<thead>
					<tr>
						<th>Thành viên</th>
						<th>Đơn vị</th>
						<th>Chức vụ</th>
						<th>Vai trò</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" id="maCanBo1" style="display: none; width: 0px;" /> <input type="text" name="tenCanBo" id="tenCanBo1" style="width: 120px;" />&nbsp; <input type="button" class="button" name="btnCb" value="..." onclick="showLovCanbo(1)" /></td>
						<td><input type="text" name="donVi" id="donVi1" readonly="true" style="width: 120px;" /></td>
						<td><input type="text" name="chucVu" id="chucVu1" readonly="true" style="width: 120px;" /></td>
						<td><!--<input type="text" name="vaiTro" id="vaiTro1" style="width: 120px;"/>--> <select id="vaiTro1" onchange="checkTD(this);">
							<option value="Trưởng đoàn">Trưởng đoàn</option>
							<option value="Phó đoàn">Phó đoàn</option>
							<option value="Thành viên đoàn">Thành viên đoàn</option>
						</select></td>
					</tr>
				</tbody>
			</table>
			<div style="text-align: right; width: 100%"><INPUT type="button" class="button" name="btnAdd" onclick="fnClickAddRow();" value="Thêm"> <INPUT type="button" class="button" name="btnXoa" id="deleteRow" value="Xóa"></div>
			</fieldset>
			</td>
		</tr>
		</tr>
		<tr>
			<td style="text-align: right;">Nội dung tố cáo được thụ lý <font style="color: red">*</font></td>
			<td colspan="3"><html:textarea property="noiDung" style="width:100%;height:80px" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">Tên thủ trưởng cơ quan,đơn vị liên quan</td>
			<td colspan="3"><html:textarea property="benLienQuanThuTruong" style="width:100%;height:80px" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">Cá nhân,cơ quan,tổ chức liên quan</td>
			<td colspan="3"><html:textarea property="benLienQuan" style="width:100%;height:80px" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">Nhập file quyết định xác minh</td>
			<td colspan="3"><A href="#" onclick="openUploadFile(maHoSo);">File "Quyết định xác minh" đính kèm</A></td>
		</tr>
	</table>
	</fieldset>
	<jsp:include page="../../thong_tin_ky_duyet.jsp" />
	<jsp:include page="../../../button_bar_kntc.jsp" />
	<logic:present name="strDateHoliday">
		<script language="javascript">
			strHolidayDay = '<%=request.getAttribute("strDateHoliday")%>';	
		</script>
	</logic:present>
</html:form>
<script type="text/javascript" charset="utf-8"> 
var oTableNew;
var cRowID = 1;
var giCount = 1;
$(function(){
	var url='kntc_xac_minh.do?method=getListTVD&id=<%=request.getParameter("id")%>';
  	oTableNew=$("#tbl_listCBXL").dataTable({ "bJQueryUI":true, "sDom":'<"H"fr>t<"F"p>', "bFilter": false, "bSort": false, "oLanguage":language,"sAjaxSource":url
	}).fnSetFilteringDelay(500);
    $("#tbl_listCBXL tbody").click(function(event) {
		$(oTableNew.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	});

	$('#deleteRow').click( function() {
		giCount = oTableNew.fnGetData().length;
		//alert(oTableNew.fnGetData().length);
		var anSelected = fnGetSelected( oTableNew );
		if(anSelected.length>0) {
			oTableNew.fnDeleteRow( anSelected[0] );
			giCount--;
		}
		else showMessage(chua_chon_ban_ghi);
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
});

function showLovCanbo(index)
{
	cRowID = index;
	tenCB = document.forms[0].tenCanBo.value;
	if(tenCB!=null && tenCB!='' && tenCB!='null')
		openWindow("danhmuc_canbo.do?method=lov&r=1&txtSearch="+normalizeString4SQL(tenCB));
	else
		openWindow("danhmuc_canbo.do?method=lov&r=1");	
}

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

	var iIndex = this.oApi._fnAddData( oSettings, aData );
	oSettings.aoData[ iIndex ].nTr = nTr;	
	oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();	
	if ( bRedraw )
	{
		this.oApi._fnReDraw( oSettings );
	}
}

function fnGetSelected( oTableLocal )
{
	var aReturn = new Array();
	var aTrs = oTableLocal.fnGetNodes();		
	for ( var i=0 ; i<aTrs.length ; i++ ) {
		if ( $(aTrs[i]).hasClass('row_selected') ) {
			aReturn.push( aTrs[i] );
		}
	}
	return aReturn;
}

function fnClickAddRow() {	
	giCount = oTableNew.fnGetData().length;
	giCount++;
	   var row= '<tr><td><input type="text" id="maCanBo'+giCount+'" style="display: none;width: 0px;"/><input type="text" name="tenCanBo" id="tenCanBo'
	   +giCount+'" style="width: 120px;"/>&nbsp<input type="button" class="button" name="btnCb" value="..."onclick="showLovCanbo('
	   +giCount+')"></td><td><input type="text" name="donVi" id="donVi'
	   +giCount+'" readonly="true" style="width: 120px;"/></td><td><input type="text" name="chucVu" id="chucVu'
	   +giCount+'" readonly="true" style="width: 120px;"/></td><td>'
	   +'<select id="vaiTro'+giCount+'" onchange="checkTD(this);" >'
		+'<option value="Trưởng đoàn">Trưởng đoàn</option>'
		+'<option value="Phó đoàn">Phó đoàn</option>'
		+'<option value="Thành viên đoàn">Thành viên đoàn</option>'
		+'</select>'
	   +'</td></tr>';
	oTableNew.fnAddTr( $(row)[0] );
}

function setData(values){
	var str_val= values.split("@@");	
	if(!test(str_val[0])) return;  	
	document.getElementById('maCanBo'+cRowID).value = str_val[0];	
 	document.getElementById('tenCanBo'+cRowID).value= str_val[1];
 	document.getElementById('chucVu'+cRowID).value= str_val[2];
 	document.getElementById('donVi'+cRowID).value= str_val[4];
 	document.getElementById('vaiTro'+cRowID).value = "Thành viên đoàn";
}
function checkTD(elem) {
	giCount = oTableNew.fnGetData().length;
	for(i=1; i<=giCount; i++) {
		if(isExist('vaiTro'+i)) {
			var id = "vaiTro"+i;
			if(id != elem.id)
			{	
				if (document.getElementById(id).value == "Trưởng đoàn")
				{					
					if (elem.value == "Trưởng đoàn" ){
						alert("Chỉ cho phép có một trưởng đoàn!");
						elem.value = "Thành viên đoàn";
					}					
					return;
				}
			} 
		}
	}
}
function test(maCB) {
	//alert("Dang test macanbo");
	giCount = oTableNew.fnGetData().length;
	for (i=1;i<=giCount;i++) {
		if(isExist('tenCanBo'+i)) {
			if(document.getElementById('maCanBo'+i).value == maCB) {
				alert("Thành viên đã được chọn!");
				return false;
			}
		}
	}
	return true;	
}
function openUploadFile(){
	var view='';
	var method = '<%=request.getParameter("method")%>';
	if(method == 'view') view = 'view';
	var r = '<%=request.getParameter("r")%>';
	if(r == 'rol') view = 'view';
	
    var maHS = document.getElementsByName("maHoSo")[0].value;
    if(maHS!=null && maHS!='' && maHS!='null')
		openWindow("UploadAction.do?parentId="+maHS+"&nv=KNTC/QDXM&view="+view);
	else
		alert("Chưa có thông tin về hồ sơ!");	
}
function ghi(){
	var maHS = document.getElementsByName("maHoSo")[0].value;
	giCount = oTableNew.fnGetData().length;
	if(validForm_xm_quyet_dinh()) {
		var arrCB='';	
		for(i=1;i<=giCount;i++){
			if(isExist('tenCanBo'+i)){
			if(!isEmpty(document.getElementById('tenCanBo'+i).value))
			{
				arrCB += document.getElementById('maCanBo'+i).value+',';
				arrCB += document.getElementById('tenCanBo'+i).value+',';
				arrCB += document.getElementById('donVi'+i).value+',';	
				arrCB += document.getElementById('chucVu'+i).value+',';	
				arrCB += document.getElementById('vaiTro'+i).value;	
				if(i<giCount)
					arrCB += '@@';	
			}
		}
	}	
	//alert(arrCB);
	document.forms[0].arrCanBo.value = arrCB;		
		document.forms[0].countCanBo.value = oTableNew.fnGetData().length;	
		document.forms[0].action="kntc_xac_minh.do?method=save&id="+maHS;
		document.forms[0].submit();
	}
}

function validDateXm()
{	
	/*if(convertStringToNumber(document.forms[0].soNgayGH.value)>30){
		alert('Số ngày gia hạn không được quá 60 ngày!');
		document.forms[0].soNgayGH.select();
		return false;
	}*/
	caculateDate('tuNgayXm', 'denNgayXm', document.forms[0].soNgayXm.value);
	//alert('xx');
	//if(!compareDate(document.forms[0].ngayRaQd,document.forms[0].giaHanTuNgay)) return false;
	//if(!compareDate(document.forms[0].giaHanTuNgay,document.forms[0].giaHanDenNgay)) return false;
	return true;
}

function validForm_xm_quyet_dinh() {
	//if(!isRequired(document.forms[0].diaDiem,'Chưa nhập địa điểm')) return false;
	//if(!isRequired(document.forms[0].thoiDiem,'Chưa nhập ban hành')) return false;
	if(!isRequired(document.forms[0].soNgayXm,'Chưa nhập thời gian xác minh')) return false;
	if(!isRequired(document.forms[0].noiDung,'Chưa nhập nội dung')) return false;
	if(oTableNew.fnGetData().length < 1){
		alert('Cần chọn ít nhất một cán bộ vào thành viên đoàn xác minh');
		return false;
	}
	return true;
}
function print(){		
	var arrCB='';
	giCount = oTableNew.fnGetData().length;
	for(i=1;i<=giCount;i++){
		if(!isEmpty(document.getElementById('tenCanBo'+i).value))
		{
			arrCB += document.getElementById('maCanBo'+i).value+',';
			arrCB += document.getElementById('tenCanBo'+i).value+',';
			arrCB += document.getElementById('donVi'+i).value+',';	
			arrCB += document.getElementById('chucVu'+i).value+',';	
			arrCB += document.getElementById('vaiTro'+i).value;	
			if(i<giCount)
				arrCB += '@@';	
		}
	}	
	document.forms[0].arrCanBo.value = arrCB;
	document.forms[0].countCanBo.value = giCount;
	document.forms[0].action="kntc_xac_minh.do?method=in";
	document.forms[0].submit();
}
</script>
</div>
</div>
</body>
</html>