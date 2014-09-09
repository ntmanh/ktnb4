<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="/phieu_dxxl_kn.do?method=show" method="post" styleId="form">
	<h3 class="Header">Đề xuất xử lý đơn khiếu nại - Mẫu 04/KNTC</h3>
	<div style="text-align: center; width: 100%"><font
		style="font-size: 14px; color: red">Số hồ sơ</font> <html:text
		property="maHoSo" styleId="ma" style="width:250px" readonly="true" /></div>
	<div id="super-tabs">
	<ul>
		<li><a href="#super-tab0" onclick="redirect('phieu_dxxl_kn.do?method=show&action=phanloaiHSKN&id=');"><span>PHÂN LOẠI ĐỀ XUẤT XỬ LÝ KN</span></a></li>
		<li><a href="#super-tab1" onclick="redirect('kntc_xac_minh.do?method=xacMinh&action=xacMinhKhieuNai&id=');"><span>TIẾN HÀNH XÁC MINH</span></a></li>
		<li><a href="#super-tab2" onclick="redirect('kntc_kq_xm.do?method=ketThuc&action=ketThucKhieuNai&id=');"><span>KẾT THÚC GIẢI QUYẾT</span></a></li>
	</ul>	
	<div id="super-tab0">
	<html:hidden property="ma" />
	<html:hidden property="arrDms" />
	<html:hidden property="strListIdBieuMau" />
	<!-- <html:hidden property="deXuatXL" />  -->
	<html:hidden property="arrTenTl" styleId="arrTenTl" />
	<html:hidden property="luuDon" />
	<div id="tabs">
	<ul>
		<li><a href="#tab0"><span>Đề xuất xử lý</span></a></li>
		<li><a href="#tab1"><span>Biểu mẫu phụ</span></a></li>
		<li><a href="#tab2"><span>Thông tin ký duyệt</span></a></li>
	</ul>
	<div id="tab0">
	<fieldset><legend>Thông tin phân loại</legend>
	<div id="divThamQuyen">
	<TABLE width="100%">
		<tr>
			<td width="15%" align="right">Chọn thẩm quyền <font style="color: red">*</font></td>
			<td colspan="3" width="85%"><html:select property="thamQuyen"
				style="width:100%;" onchange="changeThamQuyen(this.value);">
				<html:option value="0">Chọn thẩm quyền</html:option>
				<html:optionsCollection property="thamQuyenList" label="label" value="value" />
			</html:select></td>
		</tr>
		<tr>
			<td width="15%" align="right">Trường hợp cụ thể <font style="color: red">*</font></td>
			<td colspan="3" width="85%"><html:select property="thuLy" style="width:100%;" onchange="saveNoValidate();">
				<html:option value="0">Chọn trường hợp cụ thể</html:option>
				<html:optionsCollection property="thuLyList" label="label" value="value"/>
			</html:select></td>
		</tr>	
	</TABLE>
	</div>
	<div id="textThongBaoLuuDon" style="color: red;width: 100%; text-align: center">Đơn sẽ lưu sau khi duyệt đề xuất</div>
	<TABLE width="100%">	
		<tr>
			<td width="15%" align="right">Cán bộ giải quyết</td>
			<td width="35%"><html:text style="width:100%" property="canBoTL"
				readonly="true" /></td>
			<td width="15%" align="right">Ngày đề xuất</td>
			<td width="35%"><html:text property="ngayDx" style="width:100%"
				onkeypress="return formatDate(event, this)" maxlength="10"
				onblur="isDate(this);dateValid();" /></td>
		</tr>
		<tr>
			<td align="right">Nhập địa danh</td>
			<td><html:text style="width:100%" property="diaDiem" /></td>
			<td></td>
			<td></td>
		</tr>
	</TABLE>
	<div id="divQuaHan">	
		<table width="100%">
		<tr>
			<td width="15%" align="right"><font style="font-size: 12px; color: red">Hồ sơ quá hạn</font></td>
			<td width="85%" colspan="3"><html:radio property="quaHan" value="1">Có</html:radio>
			<html:radio property="quaHan" value="0">Không </html:radio></td>
		</tr>
		</table>
	</div>
	<div id="divGiaiQuyetNgay" style="font-size:12px;">
		<tr width="100%">
			<td width="15%" align="right"><font style="font-size: 12px; color: red">Phương
			án giải quyết</font></td>
			<td width="85%" colspan="3">
				<html:radio property="giaiQuyetNgay" value="1">Giải quyết ngay </html:radio>
				<html:radio property="giaiQuyetNgay" value="0">Phải xác minh &nbsp;&nbsp;&nbsp;&nbsp; </html:radio>
			</td>
		</tr>
		</table>
	</div>
	</fieldset>
	<fieldset><legend>Thông tin hồ sơ</legend>
	<TABLE width="100%">
		<tr>
			<td width="15%" style="text-align: right;"></td>
			<td width="35%"><b>Người khiếu nại</b></td>
			<td width="15%" style="text-align: right;"></td>
			<td width="35%"><b>Người bị khiếu nại</b></td>
		</tr>
		<tr>
			<td style="text-align: right;">Họ tên</td>
			<td><html:text style="width:100%" property="nguoiKNTC" /></td>
			<td style="text-align: right;">Họ tên</td>
			<td><html:text style="width:100%" property="nguoiBiKNTC" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">Chức danh</td>
			<td><html:text style="width:100%" property="chuDanhNguoiKNTC" /></td>
			<td style="text-align: right;">Chức danh</td>
			<td><html:text style="width:100%" property="chuDanhNguoiBiKNTC" /></td>
		</tr>
		<tr>
			<td style="text-align: right;">Địa chỉ</td>
			<td><html:text style="width:100%" property="dcNguoiKNTC" /></td>
			<td style="text-align: right;">Địa chỉ</td>
			<td><html:text style="width:100%" property="dcNguoiBiKNTC" /></td>
		</tr>
	</TABLE>
	<!--Thong tin ho so-->
	<TABLE width="100%">
		<tr>
			<td width="15%" style="text-align: right;">Đơn giải quyết lần <font style="color: red">*</font></td>
			<td width="35%"><html:select property="lanGui" onchange="changeLanXuLy();">
				<html:option value="0">Chọn lần giải quyết</html:option>
				<html:option value="1">1</html:option>
				<html:option value="2">2</html:option>
				<!--<html:option value="3">3</html:option>-->
			</html:select></td>
			<td width="15%"></td>
			<td width="35%"></td>
		</tr>
	</TABLE>
	</fieldset>
	<!--Co quan da giai quyet-->
	<div id="divCQDGQ">
	<fieldset><legend>Cơ quan đã giải quyết</legend>
	<TABLE width="100%">
		<tr>
			<td width="15%" align="right">Tên cơ quan đã giải quyết</td>
			<td width="35%"><html:text property="cqDaQG" style="width:100%;" /></td>
			<td width="15%"></td>
			<td width="35%"></td>
		</tr>
		<tr>
			<td align="right">Kết quả đã giải quyết</td>
			<td colspan="3"><html:textarea property="ndDaQG" onkeypress="imposeMaxLength(this);" style="width:100%;height:40px" /></td>
		</tr>
	</TABLE>
	</fieldset>
	</div>
	<!--Tom tat noi dung don-->
	<fieldset><legend>Nội dung, phân loại đơn</legend>
	<TABLE width="100%">
		<tr>
			<td style="width: 15%" align="right">Nội dung đơn tóm tắt</td>
			<td style="width: 35%"><html:textarea property="donTomTat" onkeypress="imposeMaxLength(this);" style="width:100%;height: 60px" /></td>
			<td rowspan="2" style="width: 50%"><div style="margin-left: 20%;overflow: auto;" id="tt"></div></td>
		</tr>
		<tr>
			<td align="right">Khiếu nại các nội dung</td>
			<td><html:textarea property="noiDungKNTC" onkeypress="imposeMaxLength(this);" style="width:100%;height: 60px" /></td>			
		</tr>
	</TABLE>
	</fieldset>
	<!--Tai lieu chung cu kem theo-->
	<fieldset><legend>Hồ sơ, tài liệu kèm theo</legend>
	<TABLE width="100%">
		<tr>
			<td style="width: 15%"></td>
			<td style="width: 85%">
			<table cellpadding="0" cellspacing="0" border="0" id="tbl_ListTL"
				class="display">
				<thead>
					<tr>
						<th width="40%">Tên tài liệu</th>
						<th width="20%">Số trang</th>
						<th width="40%">Tình trạng</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td width="50%"><input type="text" name="tenTL" id="tenTL0"
							style="width: 100%"></td>
						<td width="20%"><input type="text" name="soTrangTL"
							id="soTrangTL0" style="width: 100%" maxlength="3"
							onblur="isNumber(this,'i');" /></td>
						<td width="30%"><select id="tinhTrang0">
							<option value="Bản chính">Bản chính</option>
							<option value="Bản sao">Bản sao</option>
							<option value="Bản sao có công chứng">Bản sao có công
							chứng</option>
						</select></td>
					</tr>
				</tbody>
			</table>
			<div
				style="text-align: right; width: 100%; font-size: 8pt; font-weight: bold;"><INPUT
				type="button" class="button" name="btnAdd"
				onclick="fnClickAddRow();" value="Thêm"> <INPUT
				type="button" class="button" name="btnXoa" id="deleteRow"
				value="Xóa"></div>
			</td>
		</tr>
	</TABLE>
	</fieldset>
	<fieldset><legend>Đề xuất xử lý</legend>
	<TABLE width="100%">
		<tr>
			<td style="width: 15%" align="right">Nội dung đề xuất <font style="color: red">*</font></td>
			<td colspan="3">
			<html:textarea property="deXuatXL" onkeypress="imposeMaxLength(this);" style="width:100%;height: 60px" /></td>
		</tr>
		<tr>
			<td style="width: 15%" align="right">Nhập file đề xuất</td>
			<td colspan="2"><a href="#" onclick="openUploadFile(maHoSo);">File "đề xuất xử lý" đính kèm</a></td>
		</tr>
	</TABLE>
	</fieldset>
	</div>
	<div id="tab1">
	<fieldset><legend>Danh sách biểu mẫu phụ</legend> 
		<table border="1" width="100%">
		<tr>
			<td width="25">STT</td>
			<td>Biểu mẫu</td>
		</tr>
		<logic:present name="bm">
			<logic:iterate id="aBm" name="bm" indexId="idx">
				<tr>
					<td><%=idx.intValue() + 1%></td>
					<td><a href="#" onclick="openBm('<bean:write name="aBm" property="url" /><%="&action=" + request.getParameter("action")%><%="&r=" + request.getParameter("r")%>');">
					<bean:write name="aBm" property="name" /> </a></td>
				</tr>
		</logic:iterate>
		</logic:present>
	</table>
	</fieldset>
	</div>
	<div id="tab2">
		<!-- Thông tin ban hành -->

		<!-- Thông tin ký duyệt -->
		<jsp:include page="../thong_tin_ky_duyet.jsp" />
	</div>
	</div>
	<jsp:include page="../../button_bar_kntc.jsp" />
	</div>
<div id="super-tab1"></div>
<div id="super-tab2"></div>
<jsp:include page="/kntc2/other_action/khieu_nai.jsp"></jsp:include>
</div>
</html:form>
<script language="javascript">
	var oTable;
	var giCount;
	//bkLib.onDomLoaded(function() {
	//	new nicEditor({maxHeight : 200}).panelInstance('deXuatXLmce');
	//});	
	var super_tab;
	var tabs;
	
	$(function(){
		super_tab=$("#super-tabs");
		super_tab.tabs();
		super_tab.tabs("select" , 0);
		tabs=$("#tabs");
		tabs.tabs();
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
		if(document.forms[0].thamQuyen.value=='15020102'){
			hide("divQuaHan");
			hide("divGiaiQuyetNgay");
		}else{
			show("divQuaHan");
			show("divGiaiQuyetNgay");
		}
		//Xử lý lưu đơn
		if(document.forms[0].luuDon.value=='true'){
			document.forms[0].thamQuyen.value = "15020104";
			document.forms[0].thuLy.value = "1502010401";
			hide("divThamQuyen");
			show("textThongBaoLuuDon");
			hide("divGiaiQuyetNgay");
			$("#super-tabs").tabs("option", "disabled", [1,2]);
			$("#tabs").tabs("option", "disabled", [1]);
		}else{
			show("divThamQuyen");
			show("divGiaiQuyetNgay");
			hide("textThongBaoLuuDon");
		}
		//Ẩn tab nếu đơn không thuộc thẩm quyền
		if(document.forms[0].thamQuyen.value == "15020102"){
			$("#super-tabs").tabs("option", "disabled", [1,2]);
		}
		//Nếu chọn giải quyết ngay => Ẩn tab xác minh
		else if(getCheckedValue(document.forms[0].giaiQuyetNgay)==1){
			$("#super-tabs").tabs("option", "disabled", [1]);
		}
		//Ẩn tab cuối nếu đơn kết thúc ngay.		
		if('1502020101,1502020102,1502020203,1502020201,1502020202,1502020301,1502010203,1502010204,1502010201,1502010202,1502010305,1502010301,1502010105,1502010101,1502020304,1502020305,1502010401'.indexOf(document.forms[0].thuLy.value) != -1){
			$("#super-tabs").tabs("option", "disabled", [1,2]);
		}
		//Nếu chọn giải quyết ngay => Ẩn tab xác minh 
		else if(getCheckedValue(document.forms[0].giaiQuyetNgay)==1){
			$("#super-tabs").tabs("option", "disabled", [1]);
		}
		//Xử lý tài liệu
		var url='phieu_dxxl_kn.do?method=getListTL&id='+$('#ma').val();
	  	oTable = $('#tbl_ListTL').dataTable(
		{"bJQueryUI":true,"bPaginate": false,
		"bInfo": false,"sDom":'T<"clear">lfrtip',"bSort": false,"sAjaxSource":url,
		"bFilter":false,"oLanguage":language});
	    $("#tbl_ListTL tbody").click(function(event) {
			$(oTable.fnSettings().aoData).each(function (){
				$(this.nTr).removeClass('row_selected');
			});
			$(event.target.parentNode).addClass('row_selected');				
		});
		$('#deleteRow').click( function() {
				giCount = oTable.fnGetData().length;
				var anSelected = fnGetSelected( oTable );
				if(anSelected.length>0) {
					oTable.fnDeleteRow( anSelected[0] );
					giCount--;
				}
				else showMessage(chua_chon_ban_ghi);		
			});			
	});

	var noiDung='';
	var listNoiDung='';	
	$(function() {				
		var id = document.forms[0].maHoSo.value;
		var node = 13;
		var act = '<%=request.getParameter("action")%>';
		if('phanloaiHSTC'==act) node = 14;
		var urlx = "jsonstore.do?method=treeDm&id="+id+"&node="+node+"&rls=04/KNTC";
		$('#tt').tree({
			//onClick:function(node){ $('#tt').tree('beginEdit', node.target);}, url:urlx, checkbox:true
			url:urlx, checkbox:true
		});		
		changeLanXuLy();
	});
	//window.onload = function() {
		//window.setTimeout("nicEditors.findEditor('deXuatXLmce').setContent(document.forms[0].deXuatXL.value)",250);
	//};
	//Chọn thẩm quyền
	function changeThamQuyen(loai){	
		//Khong thuoc tham quyen co quan thue nhan don		
		var maHS = document.forms[0].maHoSo.value;
		var action = '<%="&action=" + request.getParameter("action")%>';
		document.forms[0].action="phieu_dxxl_kn.do?method=show&id="+maHS+"&thamquyen="+loai+action;
		document.forms[0].submit();
	}
	function changeLanXuLy(){
		if(document.forms[0].lanGui.value >= 2)
			show("divCQDGQ"); 
		else
			hide("divCQDGQ");
	}
	function ghi(){		
		var arTL='';
		var action = '<%="&action=" + request.getParameter("action")%>';
		for(i=0;i<oTable.fnGetData().length;i++){
			arTL +=$('#tenTL'+i).val()+'###'+$('#soTrangTL'+i).val()+'###'+$('#tinhTrang'+i).val();
			if(i<oTable.fnGetData().length-1) arTL +='@@';
		}	
		if(document.forms[0].luuDon.value!='true'){		
			if(document.forms[0].thamQuyen.value==0 || document.forms[0].thuLy.value==0){
				alert('Phải chọn thẩm quyền và trường hợp cụ thể');
				return false;
			}
		}
		document.forms[0].arrTenTl.value=arTL;
		//document.forms[0].deXuatXL.value = nicEditors.findEditor('deXuatXLmce').getContent();
		document.forms[0].arrDms.value = getCheckedSave();
		if(!isEmpty(document.forms[0].ngayDuyet.value)){			
			if(document.forms[0].arrDms.value.length <=0){
				alert('Phải phân loại nội dung');
				return false;
			}		
			if(document.forms[0].lanGui.value ==0){
				alert('Phải chọn lần giải quyết đơn');
				return false;
			}
			else if(!isRequired(document.forms[0].deXuatXL, 'Phải nhập nội dung đề xuất')){
				return false;
			}
			//else if(document.forms[0].ngayDx.value != document.forms[0].ngayDuyet.value){	
				else if(!compareDate(document.forms[0].ngayDx,document.forms[0].ngayDuyet,'Ngày duyệt đề xuất phải cùng hoặc sau ngày lập đề xuất')){
					return false;
				}
			//}
			else if(confirm ("Sau khi duyệt đề xuất không thể sửa thông tin phân loại, bạn có chắc chắn lưu??")){
				document.forms[0].action="phieu_dxxl_kn.do?method=saveDeXuatXuLyKN&id="+document.forms[0].maHoSo.value+action;
				document.forms[0].submit();
			}			
		}else{		
			document.forms[0].action="phieu_dxxl_kn.do?method=saveDeXuatXuLyKN&id="+document.forms[0].maHoSo.value+action;
			document.forms[0].submit();
		}		
	}	
	//Lưu để reload các thông tin liên quan đến việc phân loại.
	function saveNoValidate(){
		var arTL='';
		var action = '<%="&action=" + request.getParameter("action")%>';
		for(i=0;i<oTable.fnGetData().length;i++){
			arTL +=$('#tenTL'+i).val()+'###'+$('#soTrangTL'+i).val()+'###'+$('#tinhTrang'+i).val();
			if(i<oTable.fnGetData().length-1) arTL +='@@';
		}			
		document.forms[0].arrTenTl.value=arTL;
		document.forms[0].action="phieu_dxxl_kn.do?method=saveDeXuatXuLyKN&id="+document.forms[0].maHoSo.value+action+"&warning=no";
		document.forms[0].submit();
	}
	function getChecked(){
		var nodes = $('#tt').tree('getChecked');
		for(var i=0; i<nodes.length; i++){
			if (noiDung != '') noiDung += ',';
			noiDung += nodes[i].id;
		}
	}
	function getCheckedSave(){
		var nodes = $('#tt').tree('getChecked');
		var s='';
		for(var i=0; i<nodes.length; i++){
			if (s != '') s += ',';
			s += nodes[i].id;
		}
		return s;
	}
	function fnClickAddRow() {
		giCount = oTable.fnGetData().length;
	
		var newRowId = giCount+1;
		for(i=0;i<=giCount;i++){
			if(!isExist('tenTL'+i)) {
				newRowId = i;
				break;
			}
		}
		
		var row = '<tr><td width="60%"><input type="text" style="width: 100%" name="tenTL" id="tenTL'+newRowId+'"></td>'
					+'<td width="20%"><input type="text" name="soTrangTL" id="soTrangTL'+newRowId+'" maxlength="3" onkeypress="return nokeypress(event);" onblur="isNumber(this,"i");" style="width: 100%"></td>'
					+'<td width="20%">'
					+'<select id="tinhTrang'+newRowId+'">'
							+'<option value="Bản chính">Bản chính</option>'
							+'<option value="Bản sao">Bản sao</option>'
							+'<option value="Bản sao có công chứng">Bản sao có công chứng</option>'
					  +'</select>'
					+'</td></tr>';
		oTable.fnAddTr( $(row)[0] );
		giCount++;
	}
	function print(){		
		//document.forms[0].deXuatXL.value = nicEditors.findEditor('deXuatXLmce').getContent();
		document.forms[0].arrDms.value = getCheckedSave();
		document.forms[0].action="phieu_dxxl_kn.do?method=in";
		document.forms[0].submit();
	}	
	function openUploadFile(){
		var view='';
		var method = '<%=request.getParameter("method")%>';
		if(method == 'view') view = 'view';
		var r = '<%=request.getParameter("r")%>';
		if(r == 'rol') view = 'view';
		
	    var maHS = document.forms[0].maHoSo.value;
	    if(maHS!=null && maHS!='' && maHS!='null')
			openWindow("UploadAction.do?parentId="+maHS+"&nv=KNTC/DXXL&view="+view);
		else
			alert("Chưa có thông tin về hồ sơ!");	
	}
	function openBm(link){
		openWindow(link,screen.width,screen.height,false);
	}
</script>
<%@ include file="/bottom.jsp"%>
