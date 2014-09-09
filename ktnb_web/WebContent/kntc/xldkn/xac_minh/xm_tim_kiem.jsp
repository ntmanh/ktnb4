<%@ page pageEncoding="UTF-8"%>
<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Tra cứu Quyết định xác minh</h3>
<fieldset><html:form action="/kntc_tim_kiem.do?method=show">
	<html:hidden property="arrCqt" />
	<html:hidden styleId="data" property="data" />
	<legend class="legend">Thông tin tìm kiếm</legend>
	<table width="100%">
		<tr>
			<td>
			<table width="100%">
				<tr>
					<td width="15%" style="text-align: right;">Số hồ sơ</td>
					<td width="35%"><html:text styleClass="textbox_Style" styleId="ma" style="width:100%" property="maHoSo" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">Loại hồ sơ</td>
					<td><html:select property="loaiHoSo" styleId="loai" style="width: 100%">
						<html:options collection="dmkntc" property="value" labelProperty="label" />
					</html:select></td>
				</tr>
				<tr>
					<td style="text-align: right;">Trạng thái</td>
					<td><html:select property="trangThai" styleClass="combobox" style="width:100%" styleId="tt">
						<html:options collection="dmtt" property="value" labelProperty="label" />
					</html:select></td>
				</tr>
				<tr>
					<td width="15%" style="text-align: right;">Số quyết định</td>
					<td width="35%"><html:text styleClass="textbox_Style" styleId="maQd" style="width:100%" property="maQd" /></td>
				</tr>
				<tr>
					<td style="text-align: right;">Ngày nộp đơn từ ngày</td>
					<td><input style="width: 100%" type="text" id="sDate" name="sDate" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this);validDate();"></td>
				</tr>
				<tr>
					<td style="text-align: right;">Đến ngày</td>
					<td><input style="width: 100%" type="text" id="fDate" name="fDate" maxlength="10" onkeypress="return formatDate(event, this)" onblur="isDate(this);validDate();"></td>
				</tr>
			</table>
			<td width="45%"><%@ include file="../../../include/cqt.jsp"%></td>
		</tr>
	</table></fieldset>
<table width="100%">
	<tr>
		<td align="right" width="100%" style="text-align: center;"><input type="button" class="button" value='Tìm kiếm' name="B2" onclick="filter();"></td>
	</tr>
</table>
<div>
<table cellpadding="0" cellspacing="0" class="display" id="hs_table">
	<thead>
		<tr class="TdHeaderList" align="center">
			<!--<th width="5%">STT</th>-->
			<th width="15%">Mã hồ sơ</th>
			<th width="30%">Tên người/đơn vị KNTC</th>
			<th width="15%">Số quyết định</th>
			<th width="20%">Xác minh từ ngày</th>
			<th width="20%">Xác minh đến ngày</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan="6" class="dataTables_empty">Loading data from server...</td>
		</tr>
	</tbody>
</table>
</div>
<table width="100%">
	<tr>
		<!--P: Cac nut chuc nang. Hien thi tuy thuoc vao action-->
		<td align="center"><logic:present name="action">
			<logic:equal name="action" value="phieuYcHsTlKN">
				<input type="button" style="width: 200" class="button" value='Lập phiếu yêu cầu cung cấp HS,TL' id="phieuYcHsTlKN" onclick="executeAction('phieuYcHsTlKN')">
			</logic:equal>
			<logic:equal name="action" value="phieuYcHsTlTC">
				<input type="button" style="width: 200" class="button" value='Lập phiếu yêu cầu cung cấp HS,TL' id="phieuYcHsTlTC" onclick="executeAction('phieuYcHsTlTC')">
			</logic:equal>
			<logic:equal name="action" value="bbYeuCauBoSungHSTLTC">
				<input type="button" class="button" value='Lập biên bản làm việc' name="B2" onclick="executeAction('bbYeuCauBoSungHSTLTC')">
			</logic:equal>
			<logic:equal name="action" value="bbLamViecNguoiBiTC">
				<input type="button" class="button" value='Lập biên bản làm việc' name="B2" onclick="executeAction('bbLamViecNguoiBiTC')">
			</logic:equal>
			<logic:equal name="action" value="bbLamViecNguoiTC">
				<input type="button" class="button" value='Lập biên bản làm việc' name="B2" onclick="executeAction('bbLamViecNguoiTC')">
			</logic:equal>
			<logic:equal name="action" value="phieuYcGtKN">
				<input type="button" style="width: 200" class="button" value='Lập phiếu yêu cầu giải trình' id="phieuYcGtKN" onclick="executeAction('phieuYcGtKN')">
			</logic:equal>
			<logic:equal name="action" value="phieuYcGtTC">
				<input type="button" style="width: 200" class="button" value='Lập phiếu yêu cầu giải trình' id="phieuYcGtTC" onclick="executeAction('phieuYcGtTC')">
			</logic:equal>
			<logic:equal name="action" value="bbLamViecNguoiKN">
				<input type="button" class="button" value='Lập biên bản làm việc' name="B2" onclick="executeAction('bbLamViecNguoiKN')">
			</logic:equal>
			<logic:equal name="action" value="bbLamViecNguoiBiKN">
				<input type="button" class="button" value='Lập biên bản làm việc' name="B2" onclick="executeAction('bbLamViecNguoiBiKN')">
			</logic:equal>
			<logic:equal name="action" value="baoCaoGtKN">
				<input type="button" style="width: 200" class="button" value='Lập Báo cáo Giải trình' id="baoCaoGtKN" onclick="executeAction('baoCaoGtKN')">
			</logic:equal>
			<logic:equal name="action" value="baoCaoGtTC">
				<input type="button" style="width: 200" class="button" value='Lập Báo cáo Giải trình' id="baoCaoGtTC" onclick="executeAction('baoCaoGtTC')">
			</logic:equal>
			<logic:equal name="action" value="yktvKN">
				<input type="button" style="width: 200" class="button" value='Lập phiếu lấy ý kiến tư vấn' id="yktvKN" onclick="executeAction('yktvKN')">
			</logic:equal>
			<logic:equal name="action" value="yktvTC">
				<input type="button" style="width: 200" class="button" value='Lập phiếu lấy ý kiến tư vấn' id="yktvTC" onclick="executeAction('yktvTC')">
			</logic:equal>
			<logic:equal name="action" value="ycgdKN">
				<input type="button" style="width: 200" class="button" value='Lập phiếu giám định' id="ykgdKN" onclick="executeAction('ycgdKN')">
			</logic:equal>
			<logic:equal name="action" value="ycgdTC">
				<input type="button" style="width: 200" class="button" value='Lập phiếu giám định' id="ykgdTC" onclick="executeAction('ycgdTC')">
			</logic:equal>
			<logic:equal name="action" value="giahanKN">
				<input type="button" style="width: 200" class="button" value='Gia hạn thời gian xác minh' id="giahanKN" onclick="executeAction('giahanKN')">
			</logic:equal>
			<logic:equal name="action" value="giahanTC">
				<input type="button" style="width: 200" class="button" value='Gia hạn thời gian xác minh' id="giahanTC" onclick="executeAction('giahanTC')">
			</logic:equal>
			<logic:equal name="action" value="kqxmKN">
				<input type="button" style="width: 200" class="button" value='Báo cáo kết quả xác minh nội dung' id="kqxmKN" onclick="executeAction('kqxmKN')">
			</logic:equal>
			<logic:equal name="action" value="bckqxmTC">
				<input type="button" style="width: 200" class="button" value='Báo cáo kết quả xác minh nội dung' id="bckqxmTC" onclick="executeAction('bckqxmTC')">
			</logic:equal>
		</logic:present> <input type="button" style="width: 60" class="button" value='Đóng' name="B3" onclick="goHomeKntc();"></td>
	</tr>
</table>
</html:form>
<script type="text/javascript" charset="utf-8"> 
var oTable;
$(function(){	
	$('#data').val('');	
	$("#hs_table tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	    var iPos=oTable.fnGetPosition(event.target.parentNode);
		var aData=oTable.fnGetData(iPos);
	 	$('#data').val(aData[0]);
	});		
	var act = '<%=request.getParameter("action")%>';
    var url=encodeURI('xm_tim_kiem.do?method=search&maHs='+$('#data').val()+'&tt='+$('#tt').val()+'&loai='+$('#loai').val()+'&sDate='+$('#sDate').val()+'&fDate='+$('#fDate').val()+'&action='+act);
   	//var url=encodeURI('kntc_tim_kiem.do?method=search&maHs='+$('#data').val()+'&nnd='+$('#nguoiNopDon').val()+'&nuq='+$('#nguoiUyQuyen').val()+'&tSearch='+$('#textSearch').val()+'&tt='+$('#tt').val()+'&loai='+$('#loai').val()+'&sDate='+$('#sDate').val()+'&fDate='+$('#fDate').val()+'&action='+act);
   	oTable=$("#hs_table").dataTable({ 
   		"bJQueryUI":true,
   		"bProcessing": true,
   		"bServerSide": true,
   		'iDisplayLength': 10,
		"sDom":'<"H"fr>t<"F"p>', 
		"bSort": false,
		"bFilter": false, 
		"sAjaxSource":url, 
   	    "oLanguage":language,
   	    "sPaginationType": "full_numbers" }).fnSetFilteringDelay(2000);	   	   	
});
function executeAction(action){	
	var ma=$('#data').val();
  	if (isEmpty(ma)){
  	  alert(chua_chon_ban_ghi);
      return false;
  	}
  	if('phieuYcHsTlKN'==action) window.location = encodeURI("kntc_xm_phieu_yc.do?method=show&action=phieuYcHsTlKN&id="+ma);
  	else if('phieuYcHsTlTC'==action) window.location = encodeURI("kntc_xm_phieu_yc.do?method=show&action=phieuYcHsTlTC&id="+ma);
	else if('phieuYcGtKN'==action) window.location = encodeURI("kntc_xm_phieu_yc.do?method=ycgt&action=phieuYcGtKN&id="+ma);
	else if('phieuYcGtTC'==action) window.location = encodeURI("kntc_xm_phieu_yc.do?method=ycgt&action=phieuYcGtTC&id="+ma);
	else if('baoCaoGtKN'==action) window.location = encodeURI("kntc_xm_bao_cao.do?method=show&action=baoCaoGtKN&id="+ma);
	else if('baoCaoGtTC'==action) window.location = encodeURI("kntc_xm_bao_cao.do?method=show&action=baoCaoGtTC&id="+ma);
	else if('yktvKN'==action) window.location = encodeURI("kntc_xm_phieu_yc.do?method=yktv&action=yktvKN&id="+ma);
	else if('yktvTC'==action) window.location = encodeURI("kntc_xm_phieu_yc.do?method=yktv&action=yktvTC&id="+ma);
	else if('ycgdKN'==action) window.location = encodeURI("kntc_xm_phieu_yc.do?method=tcgd&action=ycgdKN&id="+ma);
	else if('ycgdTC'==action) window.location = encodeURI("kntc_xm_phieu_yc.do?method=tcgd&action=ycgdTC&id="+ma);
	else if('bbYeuCauBoSungHSTLTC'==action) window.location = encodeURI("kntc_khxm.do?method=bb&action=bbYeuCauBoSungHSTLTC&id="+ma);
	else if('giahanKN'==action) window.location = encodeURI("kntc_xm_gia_han.do?method=giahan&action=giahanKN&id="+ma);
	else if('giahanTC'==action) window.location = encodeURI("kntc_xm_gia_han.do?method=giahan&action=giahanTC&id="+ma);
	else if('kqxmKN'==action) window.location = encodeURI("kntc_xac_minh.do?method=bbKqXm&action=kqxmKN&id="+ma);
	else if('bbLamViecNguoiKN'==action) window.location = encodeURI("kntc_khxm.do?method=bb&action=bbLamViecNguoiKN&id="+ma);
	else if('bbLamViecNguoiBiKN'==action) window.location = encodeURI("kntc_khxm.do?method=bb&action=bbLamViecNguoiBiKN&id="+ma);
	else if('bckqxmTC'==action) window.location = encodeURI("kntc_kq_xm_tc.do?method=bcKqXmTc&action=bckqxmTC&id="+ma);
	else if('bbLamViecNguoiTC'==action) window.location = encodeURI("kntc_khxm.do?method=bb&action=bbLamViecNguoiTC&id="+ma);
	else if('bbLamViecNguoiBiTC'==action) window.location = encodeURI("kntc_khxm.do?method=bb&action=bbLamViecNguoiBiTC&id="+ma);	
}
function filter(){
	obj =document.forms[0].selectCqt;	
	var s="";
    if (isArray(obj)){
    	for(i=0;i<obj.length;i++) {
        	if (obj[i].checked)  s=s+','+obj[i].value;
        }
    }
    else {
      if (obj.checked) s=s+','+obj.value;
    }
	var oSettings =oTable.fnSettings();
	var act = '<%=request.getParameter("action")%>';
    var url=encodeURI('xm_tim_kiem.do?method=search&maHs='+$('#ma').val()+'&tt='+$('#tt').val()+'&loai='+$('#loai').val()+'&sDate='+$('#sDate').val()+'&fDate='+$('#fDate').val()+'&cqt='+s.substring(1)+'&action='+act);
	oSettings.sAjaxSource=url;
	oTable.fnDraw();
	//alert(url);
}

function validDate() {
	if(!compareDate(document.forms[0].sDate,document.forms[0].fDate)) return false;
	return true;
}
</script>
</body>
</html>