<%@ include file="/top_bar.jsp"%> 
<h3 class="Header">Tra c&#7913;u h&#7891; s&#417; ti&#7871;p d&#226;n</h3>
<fieldset><html:form action="/std_tim_kiem.do?method=show">
	<html:hidden property="arrCqt" />
	<legend class="legend">Th&#244;ng tin t&#236;m ki&#7871;m</legend>
	<table width="100%">
		<tr>
			<td width="15%">M&#227; h&#7891; s&#417;</td>
			<td width="35%"><html:text styleClass="textbox_Style" styleId="ma" style="width:80%" property="maHoSo" /></td>
			<td width="15%">Lo&#7841;i h&#7891; s&#417;</td>
			<td width="35%"><html:select property="loaiHoSo" styleId="loai">
				<html:option value="1">Khi&#7871;u n&#7841;i</html:option>
				<html:option value="2">T&#7889; c&#225;o</html:option>
				<html:option value="3">Tr&#432;&#7901;ng h&#7907;p kh&#225;c</html:option>
			</html:select></td>
		</tr>
		<tr>
			<td>Tr&#7841;ng th&#225;i</td>
			<td><html:select property="trangThai" styleClass="combobox" style="width:80%" styleId="tt">
				<html:options collection="dmtt" property="value" labelProperty="label" />
			</html:select></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Ng&#224;y n&#7897;p &#273;&#417;n t&#7915; ng&#224;y</td>
			<td><input type="text" id="sDate" name="sDate" onkeypress="return formatDate(event, this)" onblur="isDate(this)"></td>
			<td>&#272;&#7871;n ng&#224;y</td>
			<td><input type="text" id="fDate" name="fDate" onkeypress="return formatDate(event, this)" onblur="isDate(this)"></td>
		</tr>
	</table></fieldset>
<table width="100%">
	<tr>
		<td align="right" width="10%"><input type="button" style="width: 60" class="button" value='T&#236;m ki&#7871;m' name="B2" onclick="filter();"></td>
	</tr>
</table>
<div>
<table cellpadding="0" cellspacing="0" class="display" id="hs_table">
	<thead>
		<tr class="TdHeaderList" align="center">
			<th width="5%">STT</th>
			<th width="10%">M&#227;</th>
			<th width="15%">Ng&#432;&#7901;i n&#7897;p &#273;&#417;n</th>
			<th width="15%">&#7910;y quy&#7873;n</th>
			<th width="10%">Ng&#224;y nh&#7853;n &#273;&#417;n</th>
			<th width="15%">C&#225;n b&#7897; nh&#7853;n &#273;&#417;n</th>
			<th width="15%">&#272;&#417;n v&#7883; nh&#7853;n &#273;&#417;n</th>
			<th width="10%">Tr&#7841;ng th&#225;i</th>
			<th width="5%">Lo&#7841;i</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan="9" class="dataTables_empty">Loading data from server...</td>
		</tr>
	</tbody>
</table>
</div>
<table width="100%">
	<tr>
		<td align="right"><logic:present name="action">
			<logic:equal name="action" value="phancongHS">
				<input type="button" style="width: 100" class="button" value='Ph&#226;n c&#244;ng' id="phancongHs" onclick="phancongHS()" name="B1">
			</logic:equal>
			<logic:equal name="action" value="bosungHS">
				<input type="button" style="width: 100" class="button" value='B&#x1ED5; sung h&#x1ED3; s&#x1A1;' id="bosungHoSo" onclick="bosungHS();" name="B1">
			</logic:equal>
			<logic:equal name="action" value="chuyenHS">
				<input type="button" style="width: 100" class="button" value='Chuy&#7875;n h&#7891; s&#417;' id="chuyenHoSo" onclick="chuyenHS();" name="B1">
			</logic:equal>
			<logic:equal name="action" value="xemLichTrinh">
				<input type="button" style="width: 100" class="button" value='Xem l&#7883;ch tr&#236;nh' name="B2" onclick="xemLichTrinh();">
			</logic:equal>
		</logic:present> <input type="button" style="width: 60" class="button" value='&#272;&#243;ng' name="B3" onclick="goHomeKntc();"></td>
	</tr>
</table>
</html:form>
<script type="text/javascript" charset="utf-8"> 
var oTable;
$(function(){	
	$('#ma').val('');	
	$("#hs_table tbody").click(function(event) {
		$(oTable.fnSettings().aoData).each(function (){
			$(this.nTr).removeClass('row_selected');
		});
		$(event.target.parentNode).addClass('row_selected');
	    var iPos=oTable.fnGetPosition(event.target.parentNode);
		var aData=oTable.fnGetData(iPos);
	 	$('#ma').val(aData[1]);
	});		
    var url='std_tim_kiem.do?method=search';
   	oTable=$("#hs_table").dataTable({ "bJQueryUI":true,"sDom":'T<"clear">lfrtip', "bSort": false,"bFilter":false, "bProcessing": true,"bServerSide": true, "sAjaxSource":url, "oLanguage":language,"sPaginationType": "full_numbers" }).fnSetFilteringDelay(2000);	   	   	
});
function chuyenHS(){
	var ma=$('#ma').val();
  	if (isEmpty(ma)){
  	  alert(chua_chon_ban_ghi);
      return false;
  	}
	window.location = "kntc_giay_bn.do?method=cghs&id="+ma;
		//oTable.fnDeleteRow( anSelected[0] );
	
}
function phancongHS(){
	
}
function bosungHS(){
	
}
function xemLichTrinh(){
	var maHS  = getValRadio(document.forms[0].selectValue);
	window.location = "kntc_giay_bn.do?method=cghs&id="+maHS;	
}
function phancongCBXly(){
	var maHS  = getValRadio(document.forms[0].selectValue);
	window.location = "kntc_phan_cong.do?method=show&id="+maHS;	
}
function filter(){
	var oSettings =oTable.fnSettings();
    var url='std_tim_kiem.do?method=search&maHs='+$('#ma').val()+'&tt='+$('#tt').val()+'&loai='+$('#loai').val()+'&sDate='+$('#sDate').val()+'&fDate='+$('#fDate').val();
	oSettings.sAjaxSource=url;
	oTable.fnDraw();
}

</script>
</body>
</html>
