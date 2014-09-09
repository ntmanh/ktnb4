<%@page pageEncoding="UTF-8" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html:form action="tien_hanh_ttkt.do?method=save&type=banGiaoHstlChoTd">
	<table width="100%" id="tblBanGiaoHstlChoTruongDoan">
		<tr class="TdHeaderList">
			<td>Địa điểm bàn giao <font color=red>*</font></td>
			<td>Cán bộ bàn giao <font color=red>*</font></td>
			<td>Chức vụ <font color=red>*</font></td>
			<td>Thời điểm bắt đầu <font color=red>*</font></td>
			<td>Thời điểm kết thúc <font color=red>*</font></td>
			<td align="center">Chọn</td>
		</tr>
		<logic:present name="TienHanhTtktForm" property="arrBanGiaoHstlChoTruongDoan">
			<logic:iterate name="TienHanhTtktForm" property="arrBanGiaoHstlChoTruongDoan" indexId="index" id="banGiaoHstl">
				<tr class='row<%=(index.intValue() % 2)+1 %>'>
					<td><html:text styleClass="text2" name="TienHanhTtktForm" property='<%="arrBanGiaoHstlChoTruongDoan[" + index + "].diaDiemBanGiao"%>'>
					</html:text></td>
					<td>
						<html:hidden name="TienHanhTtktForm" property='<%="arrBanGiaoHstlChoTruongDoan[" + index + "].id"%>' /> 
						<html:select name="TienHanhTtktForm" property='<%="arrBanGiaoHstlChoTruongDoan[" + index + "].idCanBo"%>' onchange="thayDoiThanhVienDoan(this)" styleClass="duanIdCanBo">
							<html:options collection="dsTvd" property="idCanBo" labelProperty="tenCanBo" />
						</html:select> 
						<html:hidden name="TienHanhTtktForm" property='<%="arrBanGiaoHstlChoTruongDoan[" + index + "].tenCanBo"%>' />
					</td>
					<td><html:text styleClass="text1" readonly="true" name="TienHanhTtktForm" property='<%="arrBanGiaoHstlChoTruongDoan[" + index + "].chucVuTrongDoan"%>' style="border-bottom:none; width:100%">
					</html:text></td>
					<td><html:text styleClass="text" onblur="isTime(this)" onkeypress="return formatTime(event, this)" name="TienHanhTtktForm" property='<%="arrBanGiaoHstlChoTruongDoan[" + index + "].thoiDiemBatDauBanGiaoStr"%>' onblur="if(!isTime(this)) return; validateRequiredDate(this);" onkeypress="return formatTime(event, this)">
					</html:text></td>
					<td><html:text styleClass="text" onblur="isTime(this)" onkeypress="return formatTime(event, this)" name="TienHanhTtktForm" property='<%="arrBanGiaoHstlChoTruongDoan[" + index + "].thoiDiemKetThucBanGiaoStr"%>' onblur="if(!isTime(this)) return; validateRequiredDate(this);" onkeypress="return formatTime(event, this)">
					</html:text> <html:hidden name="TienHanhTtktForm" property='<%="arrBanGiaoHstlChoTruongDoan[" + index + "].baoCao"%>' /> <html:hidden name="TienHanhTtktForm" property='<%="arrBanGiaoHstlChoTruongDoan[" + index + "].hoSoTaiLieu"%>' /></td>
					<td align="center"><INPUT type="radio" onclick="viewBcHstl(<%=index%>)" name="rd"></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	<div style="text-align: right; width: 100%" align="right"><INPUT type="button" onclick="themBanGiaoHsTl()" value="Thêm"> <INPUT type="button" value="Xóa" onclick="xoaBanGiaoHstlChoTd()"> <input type="button" style="display: none;" id="xoaBanGiaoHsTl123"><INPUT type="button" class="button1"onclick="inBienBan()" value="In biên bản bàn giao"></div>
	<fieldset id="bcHstl" style="margin: 0"><legend>Nội dung bàn giao <font color=red>*</font></legend>
	<table width="100%">
		<tr>
			<td style="width: 19%" align="right">Báo cáo</td>
			<td style="width: 1%" align="right"></td>
			<td style="width: 80%" align="left"><html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  style="width: 100%" name="TienHanhTtktForm" property="baoCao" onchange="applyBaoCao()"></html:textarea></td>
		</tr>
		<tr>
			<td style="width: 19%" align="right">Hồ sơ tài liệu</td>
			<td style="width: 1%" align="right"></td>
			<td style="width: 80%" align="left"><html:textarea styleClass="textareaTitle" onkeypress="imposeMaxLength(this);"  style="width: 100%" name="TienHanhTtktForm" property="hoSoTaiLieu" onchange="applyHstl()"></html:textarea></td>
		</tr>
	</table>
	</fieldset>
</html:form>
<script language="javascript">
function thayDoiThanhVienDoan(cbThanhVienDoan){
	document.getElementsByName(cbThanhVienDoan.name.replace('.idCanBo','.chucVuTrongDoan'))[0].value = getChucVuTvd(cbThanhVienDoan.value)
	document.getElementsByName(cbThanhVienDoan.name.replace('.idCanBo','.tenCanBo'))[0].value = cbThanhVienDoan[cbThanhVienDoan.selectedIndex].text;
}
function applyBaoCao(){   
	document.getElementsByName('arrBanGiaoHstlChoTruongDoan['+ indexOfSelectedRow + '].baoCao')[0].value = document.getElementsByName('baoCao')[0].value;
}
function applyHstl(){
	document.getElementsByName('arrBanGiaoHstlChoTruongDoan['+ indexOfSelectedRow + '].hoSoTaiLieu')[0].value = document.getElementsByName('hoSoTaiLieu')[0].value;
}
function onLoadBanGiaoHstl(){
	allRd = document.getElementsByName('rd');
	for(var i = 0; i< allRd.length; i++)   
		allRd[i].disabled = false;
	//document.getElementsByName('rd')[0].disabled = false;
	if(document.getElementsByName('tblBanGiaoHstlChoTruongDoan')[0].rows.length <= 1)
		document.getElementById("bcHstl").style.display = "none";
	else{
		selectedRadio = document.getElementsByName('tblBanGiaoHstlChoTruongDoan')[0].rows[1].cells[banGiaoHstlTable.numOfColumn-1].childNodes[0];
		selectedRadio.checked = true;
		selectedRadio.onclick(); 
	}
} 
var banGiaoHstlTable = new TableObject('tblBanGiaoHstlChoTruongDoan', false, 'xoaBanGiaoHsTl123');
function themBanGiaoHsTl(){	 
	banGiaoHstlTable.addRow(createNewRowBanGiaoHstl());
	newSelectedRadio = document.getElementsByName('tblBanGiaoHstlChoTruongDoan')[0].rows[banGiaoHstlTable.numOfRow-1].cells[banGiaoHstlTable.numOfColumn-1].childNodes[0];
	newSelectedRadio.checked = true;
	newSelectedRadio.onclick(); 
	
}  
var isSaveItem = false; 
function xoaBanGiaoHstlChoTd(){
	if(banGiaoHstlTable.getSelectedRow() == null){
		alert('Bạn chưa chọn bản ghi nào!');
		return;
	}
	idBgHstlChoTd = document.getElementsByName('arrBanGiaoHstlChoTruongDoan[' + eval(banGiaoHstlTable.getSelectedIndex() - 1) + '].id')[0].value;
	if(isEmpty(idBgHstlChoTd)){
		banGiaoHstlTable.deleteSelectedRow();
		return;
	}
	var xmlHttpReq = false;
	if (window.XMLHttpRequest) 
		xmlHttpReq = new XMLHttpRequest(); 
    else if (window.ActiveXObject)
    	xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
    xmlHttpReq.open("POST", "tien_hanh_ttkt.do?method=xoaBgHstlChoTd&id=" + idBgHstlChoTd, true); 
    xmlHttpReq.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=UTF-8");
    xmlHttpReq.onreadystatechange = function() {
    	if (xmlHttpReq.readyState==4 && xmlHttpReq.status==200){
			var saveStatus = xmlHttpReq.responseText;
		  	if(saveStatus == 'cucsess'){
		  		alert('Xóa thành công!');		
		  		banGiaoHstlTable.deleteSelectedRow();
		  		document.getElementsByName('baoCao')[0].value = '';
		  		document.getElementsByName('hoSoTaiLieu')[0].value = '';
		  	}
		  		
		}		    	
    }
    xmlHttpReq.send();
	
	
}


function inBienBan(){
	if(banGiaoHstlTable.getSelectedRow() == null){
		alert('Bạn chưa chọn bản ghi nào!');
		return;
	}
	
	if(!validateSelectedRow())
		return;
	var printfForm = findForm('/' + contextRoot + '/tien_hanh_ttkt.do?method=save&type=banGiaoHstlChoTd');	
	printfForm.action = 'tien_hanh_ttkt.do?method=in&type=banGiaoHstlChoTd&idTvd=' + document.getElementsByName('arrBanGiaoHstlChoTruongDoan[' + indexOfSelectedRow + '].idCanBo')[0].value + '&idCuocTtkt=' + document.getElementsByName('idCuocTtkt')[0].value;
	printfForm.submit();
	printfForm.action = '/' + contextRoot + '/tien_hanh_ttkt.do?method=save&type=banGiaoHstlChoTd';
}
function getSubmitString(rowIndex){
	var reVal = "";
	
	diaDiemBanGiao = document.getElementsByName('arrBanGiaoHstlChoTruongDoan[' + rowIndex + '].diaDiemBanGiao')[0].value;
	reVal += 'diaDiemBanGiao=' + encodeURIComponent(diaDiemBanGiao);
	
	id = document.getElementsByName('arrBanGiaoHstlChoTruongDoan[' + rowIndex + '].id')[0].value;
	reVal += '&id=' + encodeURIComponent(id);
	
	idCanBo = document.getElementsByName('arrBanGiaoHstlChoTruongDoan[' + rowIndex + '].idCanBo')[0].value;
	reVal += '&idCanBo=' + encodeURIComponent(idCanBo);
	
	tenCanBo = document.getElementsByName('arrBanGiaoHstlChoTruongDoan[' + rowIndex + '].tenCanBo')[0].value;
	reVal += '&tenCanBo=' + encodeURIComponent(tenCanBo);
	
	chucVuTrongDoan = document.getElementsByName('arrBanGiaoHstlChoTruongDoan[' + rowIndex + '].chucVuTrongDoan')[0].value;
	reVal += '&chucVuTrongDoan=' + encodeURIComponent(chucVuTrongDoan);
	
	thoiDiemBatDauBanGiaoStr = document.getElementsByName('arrBanGiaoHstlChoTruongDoan[' + rowIndex + '].thoiDiemBatDauBanGiaoStr')[0].value;
	reVal += '&thoiDiemBatDauBanGiaoStr=' + encodeURIComponent(thoiDiemBatDauBanGiaoStr);
	
	thoiDiemKetThucBanGiaoStr = document.getElementsByName('arrBanGiaoHstlChoTruongDoan[' + rowIndex + '].thoiDiemKetThucBanGiaoStr')[0].value;
	reVal += '&thoiDiemKetThucBanGiaoStr=' + encodeURIComponent(thoiDiemKetThucBanGiaoStr);
	
	baoCao = document.getElementsByName('baoCao')[0].value;
	reVal += '&baoCao=' + encodeURIComponent(baoCao);
	
	hstl = document.getElementsByName('hoSoTaiLieu')[0].value;
	reVal += '&hstl=' + encodeURIComponent(hstl);
	
	idCuocTtkt = document.getElementsByName('idCuocTtkt')[0].value;
	reVal += '&idCuocTtkt=' + encodeURIComponent(idCuocTtkt);
	
	return reVal;  
}
function luuBbBanGiao(){
	if(banGiaoHstlTable.getSelectedRow() == null){
		alert('Bạn chưa chọn bản ghi nào!');
		return;
	}	
	if(!validateSelectedRow())
		return;
	var submitString = getSubmitString(indexOfSelectedRow)
	var xmlHttpReq = false;
    if (window.XMLHttpRequest) {
        xmlHttpReq = new XMLHttpRequest(); 
    }
    else if (window.ActiveXObject) {  
        xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
    } 

    xmlHttpReq.open('POST', 'tien_hanh_ttkt.do?method=saveBbHsTlChoTd&' + submitString, true); 
    xmlHttpReq.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=UTF-8");  
    xmlHttpReq.onreadystatechange = function() {
    	if (xmlHttpReq.readyState==4 && xmlHttpReq.status==200){
			var saveStatus = xmlHttpReq.responseText;
			if(saveStatus == "1")
				alert('Chưa nhập biên bản chi tiết!')
			else{
				alert('Lưu thành công!')				
				document.getElementsByName('arrBanGiaoHstlChoTruongDoan[' + indexOfSelectedRow + '].id')[0].value = saveStatus; 
				level1ActiveTab++;
				var tempTab={selected:level1ActiveTab,select:function(event,level1Tab){jQuery.fn.createCookie(getTab2IndexInCookKie(),level1Tab.index); setLevel1ActiveTab(level1Tab.index)}};                
				$("#level1Tab").tabs(tempTab);
			}
				
		}
    }
    xmlHttpReq.send();
}

function validateSelectedRow(){
	if(!isRequired(document.getElementsByName('arrBanGiaoHstlChoTruongDoan[' + indexOfSelectedRow + '].diaDiemBanGiao')[0]))
		return false;	
	
	idCanBo = document.getElementsByName('arrBanGiaoHstlChoTruongDoan[' + indexOfSelectedRow + '].idCanBo')[0];
	if(!isRequired(idCanBo))
		return false;
	thoiDiemBatDauBanGiaoStr = document.getElementsByName('arrBanGiaoHstlChoTruongDoan[' + indexOfSelectedRow + '].thoiDiemBatDauBanGiaoStr')[0];
	if(!isRequired(thoiDiemBatDauBanGiaoStr))
		return false;
	thoiDiemKetThucBanGiaoStr = document.getElementsByName('arrBanGiaoHstlChoTruongDoan[' + indexOfSelectedRow + '].thoiDiemKetThucBanGiaoStr')[0];
	if(!isRequired(thoiDiemKetThucBanGiaoStr))
		return false;
	if(!compareTime(thoiDiemBatDauBanGiaoStr, thoiDiemKetThucBanGiaoStr, '<='))
		return false;
	baoCao = document.getElementsByName('baoCao')[0];	
	hoSoTaiLieu = document.getElementsByName('hoSoTaiLieu')[0];
	if(isEmpty(baoCao.value) && isEmpty(hoSoTaiLieu.value)){
		alert('Bạn phải nhập ít nhất một trong hai trường Báo cáo hoặc Hồ sơ tài liệu!');
		baoCao.focus();
		return false;
	}
	return true;   
}


function createNewRowBanGiaoHstl(){   
	arrBanGiaoHstl = new Array(); 
	index = banGiaoHstlTable.numOfRow - 1;
	

	arrBanGiaoHstl[0] = '<INPUT type="text" class=text2 name="arrBanGiaoHstlChoTruongDoan[' + index + '].diaDiemBanGiao">'
		
	
	arrBanGiaoHstl[1] = '<input type="hidden" name="arrBanGiaoHstlChoTruongDoan[' + index + '].id">';
	arrBanGiaoHstl[1] += '<SELECT name="arrBanGiaoHstlChoTruongDoan[' + index + '].idCanBo" onchange="thayDoiThanhVienDoan(this)">';
	arrBanGiaoHstl[1] += cbDstvd;
	arrBanGiaoHstl[1] += '</SELECT>';
	arrBanGiaoHstl[1] += '<input type="hidden" name="arrBanGiaoHstlChoTruongDoan[' + index + '].tenCanBo">';
	arrBanGiaoHstl[2] = '<INPUT type="text" class="text1" name="arrBanGiaoHstlChoTruongDoan[' + index + '].chucVuTrongDoan" readonly="true" style="border-bottom:none; width:100%"> ';		
	arrBanGiaoHstl[3] = '<INPUT type="text" class="text" onblur = "isTime(this)" onkeypress="return formatTime(event, this)" name="arrBanGiaoHstlChoTruongDoan[' + index + '].thoiDiemBatDauBanGiaoStr">';		
	arrBanGiaoHstl[4] = '<INPUT type="text" class="text" onblur = "isTime(this)" onkeypress="return formatTime(event, this)" name="arrBanGiaoHstlChoTruongDoan[' + index + '].thoiDiemKetThucBanGiaoStr">';			
	arrBanGiaoHstl[4] += '<INPUT type="hidden" name="arrBanGiaoHstlChoTruongDoan[' + index + '].baoCao">';		
	arrBanGiaoHstl[4] += '<INPUT type="hidden" name="arrBanGiaoHstlChoTruongDoan[' + index + '].hoSoTaiLieu">';		
	arrBanGiaoHstl[5] = '<INPUT type="radio" onclick="viewBcHstl(' + index + ')" name = "rd">' 
	return arrBanGiaoHstl;
} 
var indexOfSelectedRow = "";
function viewBcHstl(index){
	document.getElementById("bcHstl").style.display = "inline";
	indexOfSelectedRow = index;
	document.getElementsByName('baoCao')[0].value = document.getElementsByName('arrBanGiaoHstlChoTruongDoan['+ index + '].baoCao')[0].value;
	document.getElementsByName('hoSoTaiLieu')[0].value = document.getElementsByName('arrBanGiaoHstlChoTruongDoan['+ index + '].hoSoTaiLieu')[0].value;	
}
function downLoadAttackment(){
}

function xoaBienBanChiTiet(){
}
function validateBanGiaoHstlChoTd(){
	return true;
}
</script>