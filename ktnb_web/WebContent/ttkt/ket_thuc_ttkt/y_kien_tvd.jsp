<%@page pageEncoding="UTF-8" %>
<%@ include file="/top_bar.jsp"%>
<h3 class="Header">Ý kiến của thành viên đoàn về dự thảo báo cáo kết quả</h3>
<html:form action="/y_kien_tvd.do">
	<html:hidden property="idCuocTtKt" />
	<fieldset>
	<table width="100%" align="center" id="table2">
		<tr class=TdHeaderList>
			<td width="5%" align="center">STT</td>
			<td width="20%" align="left">Thành viên đoàn <font color=red>*</font></td>
			<td width="50%" align="left">Ý kiến <font color=red>*</font></td>
			<td width="5%" align="center"><input type="checkbox" onclick="chonTat2()"></td>
		</tr>
		<logic:present name="YkienTVDForm" property="dsChiTietTVD">
			<logic:iterate name="YkienTVDForm" id="dsTpTdDuocKtXm" property="dsChiTietTVD" indexId="index">
				<tr class='row<%=(index.intValue() % 2)+1 %>'>
					<td align="center"><%=index.intValue() + 1%></td>
					<td><html:select name="YkienTVDForm" property='<%="dsChiTietTVD[" + index + "].idCanBo"%>' onclick="existCheck1(dsTVDoanDuocKtXm,this)">
						<html:options collection="dsThanhVienDoan" property="idCanBo" labelProperty="tenCanBo" />
					</html:select> <html:hidden property='<%="dsChiTietTVD[" + index + "].tenCanBo"%>' /></td>
					<td><html:textarea name="YkienTVDForm" onkeypress="imposeMaxLength(this);"  property='<%="dsChiTietTVD[" + index + "].ykien"%>' style="width: 100%">
					</html:textarea></td>
					<td align="center"><INPUT type="checkbox"></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	<table align="right">
		<tr align="right">
			<td align="right"><INPUT type="button" class="button" onclick="AddRowTable2()" value="Thêm"> <INPUT type="button" class="button" name="btnXoa" value="Xóa" id="delrowtable2"></td>
		</tr>
	</table>
	</fieldset>
</html:form>
<fieldset><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></fieldset>
<%@ include file="/bottom.jsp"%>
<script language="javascript">

var cbDsThanhVienDoan;
window.onload = function(){
	getDsThanhVienDoan();
	//thêm dòng trống trước các danh sách
	if($('#table2 tbody tr').length==1){
		AddRowTable2();
	}
}
function getDsThanhVienDoan(){    
	cbDsThanhVienDoan = '<%=request.getAttribute("cbChiTietDsTvd")%>'
	dsTenTpTdDuocKtXm = '<%=(String) request.getAttribute("dsTenTpTdDoanCoTlNp")%>';
	dsTenTpTdDuocKtXm = dsTenTpTdDuocKtXm.split(',');
	if(dsTenTpTdDuocKtXm.length != null){
	for(var i = 0;i<dsTenTpTdDuocKtXm.length;i++)
		{
		if(document.getElementsByName('dsChiTietTVD['+ i +'].idCanBo')[0]!=null){
			loadDsTenDvTh(document.getElementsByName('dsChiTietTVD['+ i +'].idCanBo')[0],dsTenTpTdDuocKtXm[i]);
			}
		}
	}
	
}

function loadDsTenDvTh(cbDsCanbo1,value){

		for(var i=0;i<cbDsCanbo1.length;i++ )
		 {
		 	if(cbDsCanbo1.options[i].text == value)
		 		cbDsCanbo1.selectedIndex = i;
		 }	
				 
	}
var dsTVDoanDuocKtXm = new TableObject('table2', true,'delrowtable2');
 function AddRowTable2() {
	dsTVDoanDuocKtXm.addRow(createNewTptdTVD2());	 	
}
function createNewTptdTVD2(){
	arReturnRow = new Array();
	index = dsTVDoanDuocKtXm.numOfRow - 1;
	arReturnRow[0] = '<select name = "dsChiTietTVD['+ index +'].idCanBo" onclick="existCheck1(dsTVDoanDuocKtXm,this)">'
	arReturnRow[0] += cbDsThanhVienDoan;
	arReturnRow[0] += '</select>'
	arReturnRow[0] += '<input type="hidden" name="dsChiTietTVD[' + index + '].tenCanBo" >';
	arReturnRow[1] = '<textarea = "text" onkeypress="imposeMaxLength(this);"  name = "dsChiTietTVD['+ index +'].ykien" style="width: 100%;">';
	arReturnRow[2] = '<INPUT type=checkbox>';
	return arReturnRow;
}
function deleteThanhVienDoan(){
	dsTVDoanDuocKtXm.deleteSelectedRow();
}
function chonTat2(){
	dsTVDoanDuocKtXm.selectAllRow();
}

function validateForm(){
	for(var i = 1; i< dsTVDoanDuocKtXm.numOfRow; i++){
		if(!isRequired(document.getElementsByName('dsChiTietTVD['+ eval(i-1) +'].idCanBo')[0]))
			return false;
		if(!isRequired(document.getElementsByName('dsChiTietTVD['+ eval(i-1) +'].ykien')[0]))
			return false;
		
	}
	if(dsTVDoanDuocKtXm.numOfRow == 1){
			alert('Bạn chưa có dữ liệu để lưu');
			return false;
		}
	
	return true;
}
function existCheck1(table, thisCbo){
	
	
}
function existCheck(table, thisCbo){
	for(i =1;i<table.numOfRow-1;i++){
		var	cbo =  document.getElementsByName('dsChiTietTVD['+ eval(i-1) +'].idCanBo')[0] ;
		if(cbo.value == thisCbo.value){
		alert('Dữ liệu đã tồn tại');
		thisCbo.selectedIndex = 0;
		return false;
		}
	}
	
} 
function selfClose(){
		window.close();
	}
</script>
<%if(request.getAttribute("save") != null){%>
<script language="javascript">
		alert('Lưu thành công');
		selfClose();
	</script>
<%}%>