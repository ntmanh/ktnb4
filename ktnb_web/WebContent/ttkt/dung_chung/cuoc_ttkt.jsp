<%@page pageEncoding="UTF-8" %>
<%@page import="cmc.com.ktnb.util.KtnbUtil"%>    
<%@page import="cmc.com.ktnb.web.ttkt.dung_chung.form.CuocTtktForm"%>
<%@page import="cmc.com.ktnb.util.Formater"%>
<%@ include file="/top_bar.jsp"%>
<script language="javascript">
	function selfClose(){
		if(window.opener != null){ 
			window.close();			         
		}	
		else{
			window.location = 'ttkt_index.do';
		}	 
	}
	function xuLySauSaveThanhCong(){
	
	}
	
	function  chonCqtDuocTtkt(){
		showLovCqt();
	}
	
	function validateHeader(){
		// Nien do
		if(!isRequired(document.forms[0].elements['nienDoTuNgay']))  
			return false;
		if(!isRequired(document.forms[0].elements['nienDoDenNgay'])) 
			return false; 
		if(!compareDate(document.forms[0].elements['nienDoTuNgay'], document.forms[0].elements['nienDoDenNgay'])){
			document.forms[0].elements['nienDoDenNgay'].focus();
			return false;
		}	
		if(document.getElementsByName('thoiGianDuKienTuNgay')[0].value.split("/")[2]!=document.getElementsByName('namKh')[0].value){
			alert("Thời gian dự kiến từ ngày phải thuộc năm "+document.getElementsByName('namKh')[0].value+"!");
			$(document.getElementsByName('thoiGianDuKienTuNgay')[0]).select().effect("highlight",3000).focus();
			return false;
		}
		if(document.getElementsByName('thoiGianDuKienDenNgay')[0].value.split("/")[2]!=document.getElementsByName('namKh')[0].value){
			alert("Thời gian dự kiến đến ngày phải thuộc năm "+document.getElementsByName('namKh')[0].value+"!");
			$(document.getElementsByName('thoiGianDuKienDenNgay')[0]).select().effect("highlight",3000).focus();
			return false;
		}	
		// Lay nam tien hanh theo ma
		//var strTmp = document.getElementsByName('maKhTtkt')[0].value.split('/');
		//var strNamTienHanh = strTmp[strTmp.length - 2];			
		var strNamTienHanh = document.getElementsByName('namKh')[0].value;	
		// Thoi gian du kien
		if(!isRequired(document.forms[0].elements['thoiGianDuKien']))
			return false;
		if(!isRequired(document.forms[0].elements['thoiGianDuKienTuNgay']))
			return false;
		
		// Thoi ky den ngay phai nho hon thoi gian du kien tu ngay
		if(!compareDate(document.forms[0].elements['nienDoDenNgay'], document.forms[0].elements['thoiGianDuKienTuNgay'], 'Niên độ đến ngày phải nhỏ hơn hoặc bằng ngày bắt đầu tiến hành dự kiến!')){
			document.forms[0].elements['nienDoDenNgay'].focus();
			return false;
		}
		
		// Hinh thuc
		if(!isRequired(document.forms[0].elements['hinhThuc']))
			return false;
		
		return true;
	}
	
	function openChuanBiTienHanh(){
		window.open('chuan_bi_tien_hanh.do?method=view&cuocTtktId=' + document.getElementsByName('id')[0].value);
	}
	function openTienHanh(){
		window.open('tien_hanh_ttkt.do?method=view&cuocTtktId=' + document.getElementsByName('id')[0].value);
	}
	function ketThuc(){
		window.open('ket_thuc_ttkt.do?method=view&cuocTtktId=' + document.getElementsByName('id')[0].value);
	}
	function xemLichTrinhDuKien(){
		openWindow('lich_trinh_du_kien_ttkt.do?idCuocTtkt=' + document.getElementsByName('id')[0].value, '500','250','menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no');
	}
	function openHuy(){
		window.open('huy_ttkt.do?idCuocTtkt=' + document.getElementsByName('id')[0].value);
	}
	
	var tblNoiDungTtkt;	
	var tblTtktCqtTrucThuoc;
	var oldValue;
	function getOldValue(control){
		oldValue = control.value;
	}
	
	function setTenCqtDuocTtkt(maCqtConTrol, index){
		if(existCqt(maCqtConTrol)){
			alert('Đơn vị đã được chọn, chọn đơn vị khác!');
			maCqtConTrol.value = oldValue;
			maCqtConTrol.focus();
			return;
		}
		
		maCqt = maCqtConTrol.value;
		tenCqt = maCqtConTrol[maCqtConTrol.selectedIndex].text;
		document.getElementsByName('arrNoiDungTtktCqtTrucThuoc[' + index + '].tenDonViBi')[0].value = tenCqt;
		index ++;
		while (true){
			maCqtConTrol = document.getElementsByName('arrNoiDungTtktCqtTrucThuoc[' + index + '].idDonViBi')[0];
			if(maCqtConTrol != null && maCqtConTrol.value == oldValue){
				maCqtConTrol.value = maCqt;
				document.getElementsByName('arrNoiDungTtktCqtTrucThuoc[' + index + '].tenDonViBi')[0].value = tenCqt;
			}
			else
				return;
		}	
	}
	
	function existCqt(maCqtConTrol){
		if(isEmpty(maCqtConTrol.value))
			return false;
		for(index = 0; index < tblTtktCqtTrucThuoc.numOfRow; index++){
			element = document.getElementsByName('arrNoiDungTtktCqtTrucThuoc[' + index + '].idDonViBi')[0];
			if(element != null && element != maCqtConTrol && element.value == maCqtConTrol.value)
				return true;
		}
		return false;
	}
	
	var selectedIndex;
	var dsCacNoiDungDaChonId;
	var chiTietNoiDungDaChonId;
	function selectNoiDungTtkt(lovBtn){
		var index = getIndex(lovBtn);
		selectedIndex = parseInt(index, 10); // Cache row
					
		// Kiem tra da chon cqt chua
		maCqtConTrol = document.getElementsByName('arrNoiDungTtktCqtTrucThuoc' + '[' + index + '].idDonViBi')[0];				
		if(maCqtConTrol.selectedIndex == 0){ 
			alert('Chưa chọn cơ quan thuế!');
			maCqtConTrol.focus();
			return;
		}
		
		// Xay dung danh sach cac noi dung da chon	
		dsCacNoiDungDaChonId = new Array();
		chiTietNoiDungDaChonId = new Array();
		var currentNoiDung = document.getElementsByName('arrNoiDungTtktCqtTrucThuoc' + '[' + index + '].idNoiDung')[0].value;
		var currentchiTietNoiDung = document.getElementsByName('arrNoiDungTtktCqtTrucThuoc' + '[' + index + '].chiTietNoiDung')[0].value;
		
		if(!isEmpty(currentNoiDung)){
			dsCacNoiDungDaChonId.push(currentNoiDung);
			chiTietNoiDungDaChonId.push(currentchiTietNoiDung);
		}
			
			//dsCacNoiDungDaChonId += currentNoiDung + ',';	
		while(true){
			index++;
			if(index == tblTtktCqtTrucThuoc.numOfRow || document.getElementsByName('arrNoiDungTtktCqtTrucThuoc' + '[' + index + '].idDonViBi')[0] != null)
				break;
			chiTietNoiDungDaChonId.push(document.getElementsByName('arrNoiDungTtktCqtTrucThuoc' + '[' + index + '].chiTietNoiDung')[0].value);
			dsCacNoiDungDaChonId.push(document.getElementsByName('arrNoiDungTtktCqtTrucThuoc' + '[' + index + '].idNoiDung')[0].value);
		}
		var rootId = '<%=cmc.com.ktnb.util.Constants.DM_TTKT%>';
		openWindow("chi_tiet_noi_dung.do?method=execute&root="+rootId,"600","600","menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no");
	}		
	function getIndex(selectedBtn){
		sltRow = selectedBtn.parentNode.parentNode;		
		for(var i = 0; i< sltRow.cells[1].childNodes.length; i++){
			if(!isEmpty(sltRow.cells[1].childNodes[i].name) && sltRow.cells[1].childNodes[i].name.indexOf('tenNoiDung') >= 0)
					return parseInt(sltRow.cells[1].childNodes[i].name.split('[')[1].split(']')[0], 10);
		}	
	}
	
	function checkTrangthai(value, controlName){		
		document.forms[0].elements[controlName].value = value;	
	}
	function xoaCqtTrucThuoc1(){
		var tblTtktCqtTrucThuocAbc = document.getElementById("tblTtktCqtTrucThuocAbc");
		var length = tblTtktCqtTrucThuocAbc.rows.length;
		var numOfCell = 7;
		var noidung = new Object();
		noidung.list = new Array();
		for(var i =0; i <length;i++){
			if(tblTtktCqtTrucThuocAbc.rows[i].cells[numOfCell - 1].childNodes[0].checked){
				if(i!=length-1){
					if(tblTtktCqtTrucThuocAbc.rows[i + 1].cells[0].innerHTML == '' && tblTtktCqtTrucThuocAbc.rows[i].cells[0].innerHTML != ''){
						tblTtktCqtTrucThuocAbc.rows[i + 1].cells[0].innerHTML = tblTtktCqtTrucThuocAbc.rows[i].cells[0].innerHTML.replace("arrNoiDungTtktCqtTrucThuoc["+i+"]","arrNoiDungTtktCqtTrucThuoc["+i+1+"]");
						var childsOfNexRow = tblTtktCqtTrucThuocAbc.rows[i + 1].cells[1].childNodes;							
						for(var k =0; k< childsOfNexRow.length; k++){
							if(childsOfNexRow[k].value == '...')
								childsOfNexRow[k].disabled = false;
						}
					}
				}
			}else{
				noidung.list.push(tblTtktCqtTrucThuocAbc.rows[i]);
			}
		}
		if(noidung.list.length==0){
			document.forms[0].action = "cuoc_ttkt.do?method=changeDonViDuocTtkt";		
			document.forms[0].submit();		
			return;	
		}
		//xóa hết
		$('#div2').empty();
		//vẽ lại từ đầu
		var newTable = '<table width="1100" id="tblTtktCqtTrucThuocAbc" style="vertical-align: bottom;"><tbody>';
		for(var i =0; i < noidung.list.length;i++){
			newTable+='<tr class="row'+i%2+'">';
			newTable+=noidung.list[i].innerHTML+"</tr>";
		}
		newTable+="</tbody></table>";
		$('#div2').append(newTable);
	}
	function xoaCqtTrucThuoc(){
		deleteTable = document.getElementById('tblTtktCqtTrucThuocAbc');
		//numOfCell = deleteTable.rows[0].cells.length;
		numOfCell = 7;
		var index = 0;
		while(true){
			if(index == tblTtktCqtTrucThuoc.numOfRow)
				break;
			if(deleteTable.rows[index].cells[numOfCell - 1].childNodes[0].checked){// Neu duoc check
				// Chinh lai dong duoi no
				if(index < tblTtktCqtTrucThuoc.numOfRow - 1){
					if(deleteTable.rows[index + 1].cells[0].innerHTML == '' && deleteTable.rows[index].cells[0].innerHTML != ''){
						// Combo co quan thue
						deleteTable.rows[index + 1].cells[0].innerHTML = deleteTable.rows[index].cells[0].innerHTML;
						// Lov noi dung
						var childsOfNexRow = deleteTable.rows[index + 1].cells[1].childNodes;							
						for(var k =0; k< childsOfNexRow.length; k++){
							if(childsOfNexRow[k].value == '...')
								childsOfNexRow[k].disabled = false;
						}
					}
				}						
				deleteTable.deleteRow(index);
				try{
					tblTtktCqtTrucThuoc = new TableObject('tblTtktCqtTrucThuocAbc', false, 'xoaTtktCqtTrucThuoc');			
					tblTtktCqtTrucThuoc.reFormatStyleIncludeHeader();	
					index = 0;
				}catch(err){// Truong hop xoa het table
					document.forms[0].action = "cuoc_ttkt.do?method=changeDonViDuocTtkt";		
					document.forms[0].submit();		
					return;	
				}				
			}else{
				index++;
			}
			tblTtktCqtTrucThuoc = new TableObject('tblTtktCqtTrucThuocAbc', false, 'xoaTtktCqtTrucThuoc');			
				tblTtktCqtTrucThuoc.reFormatStyleIncludeHeader();	
			
		}		
		// Cache cac dong truoc khi xoa bo toan bo
		arrDeletedRow = new Array();
		for(var i = 0; i< tblTtktCqtTrucThuoc.numOfRow; i++){
			arrDeletedRow.push(copyRow(tblTtktCqtTrucThuoc.innerTable.rows[i], i));
		}
		// Them lai dong dau tien truoc khi xoa ke khong vo form
		tblTtktCqtTrucThuoc.addRow(arrDeletedRow[0], 0);
		// Xoa cac dong bi sai chi so tu dong thu 1		
		while(true){
			try{				
				tblTtktCqtTrucThuoc.deleteRowByIndex(1);
			}catch(err){
				break;
			}
		}
				
		// Thay bang cac dong hop le
		for(i = 1; i< arrDeletedRow.length; i++)
			tblTtktCqtTrucThuoc.addRow(arrDeletedRow[i]);
			
		tblTtktCqtTrucThuoc.reFormatStyleIncludeHeader();	
		// can thang hang
		for(i = 0; i< document.getElementById('tblTtktCqtTrucThuocAbc').rows.length; i++){
			document.getElementById('tblTtktCqtTrucThuocAbc').rows[i].style.verticalAlign = "bottom";
			document.getElementById('tblTtktCqtTrucThuocAbc').rows[i].cells[4].align = "center";
		}
	}	
	
	function themNoiDung(){		
		if(!validateDsNoiDungTtkt())
			return;
		tblNoiDungTtkt.addRow(createNewRowNoiDungTtkt());  
		document.getElementById('tblNoiDungTtktAbc').rows[tblNoiDungTtkt.numOfRow - 1].cells[0].childNodes[1].focus();	
	}

	
	function themCqtTrucThuoc(){
		if(!validateDsTtktCqtTrucThuoc())
			return;
		tblTtktCqtTrucThuoc.addRow(createNewRowTtktCqtTrucThuoc());
		tblTtktCqtTrucThuoc.reFormatStyleIncludeHeader();	
		document.getElementById('tblTtktCqtTrucThuocAbc').rows[tblTtktCqtTrucThuoc.numOfRow - 1].cells[0].childNodes[0].focus();	
		// can thang hang
		for(i = 0; i< document.getElementById('tblTtktCqtTrucThuocAbc').rows.length; i++){
			document.getElementById('tblTtktCqtTrucThuocAbc').rows[i].style.verticalAlign = "bottom";
			document.getElementById('tblTtktCqtTrucThuocAbc').rows[i].cells[4].align = "center";
		}
	}
	
	function createNewRowTtktCqtTrucThuoc1(idNoiDung, tenNoiDung, index){
		arrRowDescription = new Array();
		if(!index){
			index = tblTtktCqtTrucThuoc.numOfRow;
		}
		if(isEmpty(tenNoiDung)){			
			arrRowDescription[0] = '<select name="arrNoiDungTtktCqtTrucThuoc[' + index + '].idDonViBi" onclick="getOldValue(this)" onchange="setTenCqtDuocTtkt(this, ' + index + ')" style = "width:100%">';
			arrRowDescription[0] += document.getElementsByName('propertyOfUtilCombo')[0].innerHTML;
			arrRowDescription[0] += "</select>";
			arrRowDescription[0] += '<input type="hidden" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].tenDonViBi">';
			
			arrRowDescription[1] = '<input type="hidden" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].idNoiDung">';
			arrRowDescription[1] += "<textarea name = 'arrNoiDungTtktCqtTrucThuoc[" + index + "].tenNoiDung' style='WIDTH: 88%' readonly='true'></textarea>";
			arrRowDescription[1] += '<INPUT type="button" onclick="selectNoiDungTtkt(this)" value = "..." class="lovButton";>';		
			
		}else{
			arrRowDescription[0] = '';
			arrRowDescription[1] = '<input type="hidden" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].idNoiDung" value="' + idNoiDung + '">';			
			arrRowDescription[1] += "<textarea name = 'arrNoiDungTtktCqtTrucThuoc[" + index + "].tenNoiDung' style='WIDTH: 88%' readonly='true'>" + tenNoiDung + "</textarea>";
			arrRowDescription[1] += '<INPUT type="button" onclick="selectNoiDungTtkt(this)" value = "..." class="lovButton"; disabled = "true">';
		}						

		arrRowDescription[2] = '<input type="text" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].chiTietNoiDung" value="" readonly="readonly"  class="text" style = "width: 95">';
		arrRowDescription[2] += '<INPUT type="button" value="..." class="lovButton" onclick="chonNoiDungChiTiet('+ index +')"/>';
		arrRowDescription[2] += '<input type="hidden" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].tenChiTietNoiDung" value="">';
		arrRowDescription[3] = '<input type="text"  style = "WIDTH: 63" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].nienDoTuNgayStr" class="text" onblur="if(!isDate(this)) return; " onkeypress="return formatDate(event, this);" value = "'+ document.getElementsByName('nienDoTuNgay')[0].value + '"> - ';
		arrRowDescription[3] += '<input type="text"  style = "WIDTH: 63" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].nienDoDenNgayStr" class="text" onblur="if(!isDate(this)) return; "  onkeypress="return formatDate(event, this);" value = "' + document.getElementsByName('nienDoDenNgay')[0].value + '">';
		arrRowDescription[4] = '<input type="text" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].thoiGianDuKienStr" value="' + document.getElementsByName('thoiGianDuKien')[0].value + '" onblur="if(!isNumber(this, \'i\')) return;  caculateDate(this.name.replace(\'thoiGianDuKienStr\', \'thoiGianDuKienTuNgayStr\'), this.name.replace(\'thoiGianDuKienStr\', \'thoiGianDuKienDenNgayStr\'), this.value)" style="width: 35" class="text">&nbsp; ngày';
		arrRowDescription[5] = '<input type="text" style="WIDTH: 63px" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].thoiGianDuKienTuNgayStr" class="text" onblur="if(!isDate(this)) return ;  caculateDate(this.name, this.name.replace(\'thoiGianDuKienTuNgayStr\',\'thoiGianDuKienDenNgayStr\'), document.getElementsByName(this.name.replace(\'thoiGianDuKienTuNgayStr\', \'thoiGianDuKienStr\'))[0].value)" onkeypress="return formatDate(event, this);" value = "'+ document.getElementsByName('thoiGianDuKienTuNgay')[0].value + '"> - ';
		arrRowDescription[5] += '<input type="text" style="WIDTH: 63px" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].thoiGianDuKienDenNgayStr" class="text" readOnly = "true" value = "' + document.getElementsByName('thoiGianDuKienDenNgay')[0].value + '">';
		arrRowDescription[5] += '<input type="hidden" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].hinhThucStr">';
		arrRowDescription[6] = '<INPUT type="checkbox">';
		return arrRowDescription;
		
	}
	function createNewRowTtktCqtTrucThuoc(returnTree, index){
		var idNoiDung = index?returnTree.ma:'';
		var tenNoiDung = index?returnTree.name:'';
		var chiTiet = index?returnTree.selectedChildIds:'';
		arrRowDescription = new Array();
		if(!index)
			index = tblTtktCqtTrucThuoc.numOfRow;
		if(isEmpty(tenNoiDung)){			
			arrRowDescription[0] = '<select name="arrNoiDungTtktCqtTrucThuoc[' + index + '].idDonViBi" onclick="getOldValue(this)" onchange="setTenCqtDuocTtkt(this, ' + index + ')" style = "width:100%">';
			arrRowDescription[0] += document.getElementsByName('propertyOfUtilCombo')[0].innerHTML;
			arrRowDescription[0] += "</select>";
			arrRowDescription[0] += '<input type="hidden" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].tenDonViBi">';
			
			arrRowDescription[1] = '<input type="hidden" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].idNoiDung">';
			arrRowDescription[1] += "<textarea name = 'arrNoiDungTtktCqtTrucThuoc[" + index + "].tenNoiDung' style='WIDTH: 88%' readonly='true'></textarea>";
			arrRowDescription[1] += '<INPUT type="button" onclick="selectNoiDungTtkt(this)" value = "..." class="lovButton";>';			
			
		}else{
			arrRowDescription[0] = '';
			arrRowDescription[1] = '<input type="hidden" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].idNoiDung" value="' + idNoiDung + '">';			
			arrRowDescription[1] += "<textarea name = 'arrNoiDungTtktCqtTrucThuoc[" + index + "].tenNoiDung' style='WIDTH: 88%' readonly='true'>" + tenNoiDung + "</textarea>";
			arrRowDescription[1] += '<INPUT type="button" onclick="selectNoiDungTtkt(this)" value = "..." class="lovButton"; disabled = "true">';
		}						
		arrRowDescription[2] = '<input type="text" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].chiTietNoiDung" value="'+ chiTiet +'" readonly="readonly"  class="text1" style = "width: 95">';
		arrRowDescription[2] += '<INPUT type="button" value="..." class="lovButton" onclick="chonNoiDungChiTiet('+ index +')"/>';
		arrRowDescription[2] += '<input type="hidden" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].tenChiTietNoiDung" value="">';
		arrRowDescription[3] = '<input type="text"  style = "WIDTH: 63" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].nienDoTuNgayStr" class="text1" onblur="if(!isDate(this)) return; " onkeypress="return formatDate(event, this);" value = "'+ document.getElementsByName('nienDoTuNgay')[0].value + '"> - ';
		arrRowDescription[3] += '<input type="text"  style = "WIDTH: 63" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].nienDoDenNgayStr" class="text1" onblur="if(!isDate(this)) return; "  onkeypress="return formatDate(event, this);" value = "' + document.getElementsByName('nienDoDenNgay')[0].value + '">';
		arrRowDescription[4] = '<input type="text" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].thoiGianDuKienStr" value="' + document.getElementsByName('thoiGianDuKien')[0].value + '" onblur="if(!isNumber(this, \'i\')) return;  caculateDate(this.name.replace(\'thoiGianDuKienStr\', \'thoiGianDuKienTuNgayStr\'), this.name.replace(\'thoiGianDuKienStr\', \'thoiGianDuKienDenNgayStr\'), this.value)" style="width: 35" class="text1">&nbsp; ngày';
		arrRowDescription[5] = '<input type="text" style="WIDTH: 63px" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].thoiGianDuKienTuNgayStr" class="text1" onblur="if(!isDate(this)) return ;  caculateDate(this.name, this.name.replace(\'thoiGianDuKienTuNgayStr\',\'thoiGianDuKienDenNgayStr\'), document.getElementsByName(this.name.replace(\'thoiGianDuKienTuNgayStr\', \'thoiGianDuKienStr\'))[0].value)" onkeypress="return formatDate(event, this);" value = "'+ document.getElementsByName('thoiGianDuKienTuNgay')[0].value + '"> - ';
		arrRowDescription[5] += '<input type="text" style="WIDTH: 63px" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].thoiGianDuKienDenNgayStr" class="text1" readOnly = "true" value = "' + document.getElementsByName('thoiGianDuKienDenNgay')[0].value + '">';
		arrRowDescription[5] += '<input type="hidden" name="arrNoiDungTtktCqtTrucThuoc[' + index + '].hinhThucStr">';
		
		arrRowDescription[6] = '<INPUT type="checkbox">';
		return arrRowDescription;
	}
	
	function createNewRowNoiDungTtkt(idNoiDung, tenNoiDung, index){
		arrRowDescription = new Array();
		if(!index)
			index = tblNoiDungTtkt.numOfRow;
		if(tenNoiDung == null || tenNoiDung == ''){
			arrRowDescription[0] = '<input type="hidden" name="dsNoiDungTtkt[' + index + '].idNoiDung">';
			arrRowDescription[0] += "<textarea name = 'dsNoiDungTtkt[" + index + "].tenNoiDung' style='width: 89%' readonly='true'></textarea>";
			arrRowDescription[0] += '<INPUT type="button" onclick="selectNoiDungTtkt(this, \'dsNoiDungTtkt\')" value = "..." class="lovButton">';
		}else{
			arrRowDescription[0] = '<input type="hidden" name="dsNoiDungTtkt[' + index + '].idNoiDung" value="' + idNoiDung + '">';			
			arrRowDescription[0] += "<textarea name = 'dsNoiDungTtkt[" + index + "].tenNoiDung' style='width: 89%' readonly='true'>" + tenNoiDung + "</textarea>";
			arrRowDescription[0] += '<INPUT type="button" onclick="selectNoiDungTtkt(this, \'dsNoiDungTtkt\')" value = "..." class="lovButton" disabled = "true">';
		}						
		arrRowDescription[1] = '<input type="text" name="dsNoiDungTtkt[' + index + '].chiTietNoiDung" value="" readonly="readonly" class="text" style = "width: 95"> ';
		arrRowDescription[1] += '<INPUT type="button" value="..." class="lovButton" onclick="chonNoiDungChiTiet('+ index +')"/>';
		arrRowDescription[1] += '<input type="hidden" name="dsNoiDungTtkt[' + index + '].tenChiTietNoiDung" value="">';
		
		arrRowDescription[2] = '<input type="text" style="WIDTH: 63px" name="dsNoiDungTtkt[' + index + '].nienDoTuNgayStr" class="text" onblur="if(!isDate(this)) return; " onkeypress="return formatDate(event, this);" value = "'+ document.getElementsByName('nienDoTuNgay')[0].value + '"> - ';
		arrRowDescription[2] += '<input type="text" style="WIDTH: 63px" name="dsNoiDungTtkt[' + index + '].nienDoDenNgayStr" class="text" onblur="if(!isDate(this)) return; "  onkeypress="return formatDate(event, this);" value = "' + document.getElementsByName('nienDoDenNgay')[0].value + '">';
		
		arrRowDescription[3] = '<input type="text" name="dsNoiDungTtkt[' + index + '].thoiGianDuKienStr" value="' + document.getElementsByName('thoiGianDuKien')[0].value + '" onblur="if(!isNumber(this, \'i\')) return; caculateDate(this.name.replace(\'thoiGianDuKienStr\',\'thoiGianDuKienTuNgayStr\'), this.name.replace(\'thoiGianDuKienStr\',\thoiGianDuKienDenNgayStr\'), this.value)" style="width: 35" class="text">&nbsp; ngày';
		
		arrRowDescription[4] = '<input type="text" style="WIDTH: 63px" name="dsNoiDungTtkt[' + index + '].thoiGianDuKienTuNgayStr" class="text" onblur="if(!isDate(this)) return ; caculateDate(this.name, this.name.replace(\'thoiGianDuKienTuNgayStr\', \'thoiGianDuKienDenNgayStr\'), document.getElementsByName(this.name.replace(\'thoiGianDuKienTuNgayStr\',\'thoiGianDuKienStr\'))[0].value)" onkeypress="return formatDate(event, this);" value = "'+ document.getElementsByName('thoiGianDuKienTuNgay')[0].value + '"> - ';
		arrRowDescription[4] += '<input type="text" style="WIDTH: 63px" name="dsNoiDungTtkt[' + index + '].thoiGianDuKienDenNgayStr" class="text" readonly="true" value = "' + document.getElementsByName('thoiGianDuKienDenNgay')[0].value + '">';
	
		arrRowDescription[5] = '<select name="dsNoiDungTtkt[' + index + '].hinhThucStr" class="combobox">';
		if(document.getElementsByName('hinhThuc')[0].value == '0'){
			arrRowDescription[5] += '<option selected value="0" >Thanh tra</option>';
			arrRowDescription[5] += '<option value="1">Kiểm tra</option></select>';
		}else{
			arrRowDescription[5] += '<option value="0" >Thanh tra</option>';
			arrRowDescription[5] += '<option selected value="1">Kiểm tra</option></select>';			
		}
		return arrRowDescription;
	}
	
	function validateWithThoiKyChung(controlToValidate){		
		if(d2n(controlToValidate.value) < d2n(document.forms[0].elements['nienDoTuNgay'].value) || d2n(controlToValidate.value) > d2n(document.forms[0].elements['nienDoDenNgay'].value)){
			alert('Ngày nhập phải thuộc thời kỳ Thanh tra Kiểm tra!');
			controlToValidate.focus();
			return false;
		}
		return true;
		
	}
	function validateWithThoiGianDuKienChung(controlToValidate){		
		if(d2n(controlToValidate.value) < d2n(document.forms[0].elements['thoiGianDuKienTuNgay'].value) || d2n(controlToValidate.value) > d2n(document.forms[0].elements['thoiGianDuKienDenNgay'].value)){
			alert('Ngày nhập phải nằm trong thời gian dự kiến của cuộc Thanh tra Kiểm tra!');
			controlToValidate.focus();
			return false;
		}
		return true;
		
	}
	function validateDsNoiDungTtkt(){						
		try{
			index = 0;
			while (true){				
				if(!isRequired(document.forms[0].elements['dsNoiDungTtkt['+ index +'].tenNoiDung']))
					return false;
										
				// Nien do
				if(!isRequired(document.forms[0].elements['dsNoiDungTtkt['+ index +'].nienDoTuNgayStr']))
					return false;				
				if(!validateWithThoiKyChung(document.forms[0].elements['dsNoiDungTtkt['+ index +'].nienDoTuNgayStr']))
					return false;
						
				if(!isRequired(document.forms[0].elements['dsNoiDungTtkt['+ index +'].nienDoDenNgayStr']))
					return false;
				// Lay nam tien hanh theo ma
				//var strTmp = document.getElementsByName('maKhTtkt')[0].value.split('/');
				//var strNamTienHanh = strTmp[strTmp.length - 2];
				var strNamTienHanh = document.getElementsByName('namKh')[0].value;
				if(!compareToTheYear(document.forms[0].elements['dsNoiDungTtkt['+ index +'].nienDoDenNgayStr'], strNamTienHanh, '<='))
					return false;
				if(!validateWithThoiKyChung(document.forms[0].elements['dsNoiDungTtkt['+ index +'].nienDoDenNgayStr']))
					return false;	
				
				if(!compareDate(document.forms[0].elements['dsNoiDungTtkt['+ index +'].nienDoTuNgayStr'], document.forms[0].elements['dsNoiDungTtkt['+ index +'].nienDoDenNgayStr'])){
					
					document.getElementsByName('dsNoiDungTtkt['+ index +'].nienDoDenNgayStr')[0].focus();
					return false;
				}		
				
				// Thoi gian du kien
				if(!isRequired(document.forms[0].elements['dsNoiDungTtkt['+ index +'].thoiGianDuKienStr']))
					return false;
				
				if(!isRequired(document.forms[0].elements['dsNoiDungTtkt['+ index +'].thoiGianDuKienTuNgayStr']))
					return false;				
				if(!validateWithThoiGianDuKienChung(document.forms[0].elements['dsNoiDungTtkt['+ index +'].thoiGianDuKienTuNgayStr'])){
					return false;				}
				
				if(!validateWithThoiGianDuKienChung(document.forms[0].elements['dsNoiDungTtkt['+ index +'].thoiGianDuKienDenNgayStr'])){
					return false;
				}
				
				index++;
			}
		}catch(err1){
			return true;
		}
		
	}
	function validateDsTtktCqtTrucThuoc(){						
		for(index = 0; index < tblTtktCqtTrucThuoc.numOfRow; index++){
			try{
				if(!isRequired(document.forms[0].elements['arrNoiDungTtktCqtTrucThuoc['+ index +'].idDonViBi']))	
					return false;
				if(!isRequired(document.forms[0].elements['arrNoiDungTtktCqtTrucThuoc['+ index +'].tenNoiDung']))
					return false;
			}catch(err){
			
			}
				
			// Nien do
			try{
			if(!isRequired(document.forms[0].elements['arrNoiDungTtktCqtTrucThuoc['+ index +'].nienDoTuNgayStr']))
				return false;
			if(!validateWithThoiKyChung(document.forms[0].elements['arrNoiDungTtktCqtTrucThuoc['+ index +'].nienDoTuNgayStr']))
				return false;				
			
			if(!isRequired(document.forms[0].elements['arrNoiDungTtktCqtTrucThuoc['+ index +'].nienDoDenNgayStr']))
				return false;
			if(!validateWithThoiKyChung(document.forms[0].elements['arrNoiDungTtktCqtTrucThuoc['+ index +'].nienDoDenNgayStr']))
				return false;
			
			
			if(!compareDate(document.forms[0].elements['arrNoiDungTtktCqtTrucThuoc['+ index +'].nienDoTuNgayStr'], document.forms[0].elements['arrNoiDungTtktCqtTrucThuoc['+ index +'].nienDoDenNgayStr'])){
				document.forms[0].elements['arrNoiDungTtktCqtTrucThuoc['+ index +'].nienDoDenNgayStr'].focus();
				return false;
			}		
			
			// Thoi gian du kien				
			if(!isRequired(document.forms[0].elements['arrNoiDungTtktCqtTrucThuoc['+ index +'].thoiGianDuKienStr']))
				return false;
			if(parseInt(document.getElementsByName('arrNoiDungTtktCqtTrucThuoc['+ index +'].thoiGianDuKienStr')[0].value) > parseInt(document.getElementsByName('thoiGianDuKien')[0].value)){
				alert('Thời gian dự kiến của nội dung phải nhỏ hơn hoặc bằng thời gian dự kiến của cuộc!');
				document.getElementsByName('arrNoiDungTtktCqtTrucThuoc['+ index +'].thoiGianDuKienStr')[0].focus();
				
				return false;
			}
			
			
			if(!isRequired(document.forms[0].elements['arrNoiDungTtktCqtTrucThuoc['+ index +'].thoiGianDuKienTuNgayStr']))
				return false;
				
			if(!validateWithThoiGianDuKienChung(document.forms[0].elements['arrNoiDungTtktCqtTrucThuoc['+ index +'].thoiGianDuKienTuNgayStr'])){
				return false;
			}
			
			if(!validateWithThoiGianDuKienChung(document.forms[0].elements['arrNoiDungTtktCqtTrucThuoc['+ index +'].thoiGianDuKienDenNgayStr'])){
				return false;
			}
			}catch(err){
			}
		}
		return true;
	}
	function validateGrid(){		
		return validateDsTtktCqtTrucThuoc();
	}
	function checkYear(){
		// Lay nam tien hanh theo ma
		//var strTmp = document.getElementsByName('maKhTtkt')[0].value.split('/');
		//var strNamTienHanh = strTmp[strTmp.length - 2];	
		var strNamTienHanh = document.getElementsByName('namKh')[0].value;
		if(!compareToTheYear(document.forms[0].elements['nienDoDenNgay'], strNamTienHanh, '<=')){
			alert('Niên độ không được sau năm tiến hành!');
			document.forms[0].elements['nienDoDenNgay'].focus();
			return false;
		}
	}
	
	function validateForm(){
		if(isEmpty(document.getElementsByName('idDonViBi')[0].value)){					
			alert('Chưa chọn đơn vị được Thanh tra Kiểm tra!');
			document.getElementsByName('donViBiName')[0].focus();
			return false;
		}
			
		if(!validateHeader())
			return false;			
		if(tblTtktCqtTrucThuoc == null){
			alert('Chưa chọn nội dung Thanh tra Kiểm tra!');
			return false;
		}
		if(!validateGrid())
			return false;			
		return true; 
	}
	
	function getCqtFromLov(ma, ten){
		document.forms[0].elements['idDonViBi'].value = ma;
		document.forms[0].elements['donViBiName'].value = ten;	
		//remove noi dung
		$('#noiDung').remove();
		//document.forms[0].action = "cuoc_ttkt.do?method=changeDonViDuocTtkt";		
		//document.forms[0].submit();
	}
	function addNewCuocTtKt(){
		if(isEmpty(document.forms[0].elements['idDonViBi'].value)||isEmpty(document.forms[0].elements['donViBiName'].value))
		{
			alert('Chưa chọn đơn vị được Thanh tra Kiểm tra!');
			return;
		}
		else
		{
			document.forms[0].action = "cuoc_ttkt.do?method=changeDonViDuocTtkt";		
			document.forms[0].submit();
		}
	}
	function chonNoiDungChoChiCuc(){
		if(!validateHeader())
			return;
		document.forms[0].action = "cuoc_ttkt.do?method=changeDonViDuocTtkt";		
		document.forms[0].submit();
	}
	function changNoiDungTtkt(newValue, controlNoiDungTtktName){
		//document.getElementsByName(controlNoiDungTtktName)[0].value = newValue;
	}
	var getReturnValueControlName; 
	function chonNoiDungChiTiet(index){	
		getReturnValueControlName = 'arrNoiDungTtktCqtTrucThuoc' + '[' + index + '].chiTietNoiDung';
		maNdControl = 	document.getElementsByName('arrNoiDungTtktCqtTrucThuoc' + '[' + index + '].idNoiDung')[0];
		if(maNdControl.value == null || maNdControl.value == ""){
			alert('Chua chon noi dung Ttkt'); 
			maNdControl.focus();
			return;
		}
		chiTietNoiDungDaChonId = document.getElementsByName('arrNoiDungTtktCqtTrucThuoc' + '[' + index + '].chiTietNoiDung')[0].value.split(',');
		openWindow("chi_tiet_noi_dung.do?method=chonChiTiet&root=" + maNdControl.value,"600","590","menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no");   
		//window.open("chi_tiet_noi_dung.do?method=chonChiTiet&root=" + maNdControl.value).focus();
	}
	function copyRow(sltRow, newIndex){
		for(var j = 0; j< sltRow.cells[1].childNodes.length; j++){
			if(!isEmpty(sltRow.cells[1].childNodes[j].name) && sltRow.cells[1].childNodes[j].name.indexOf('tenNoiDung') >= 0){
				oldIndex = sltRow.cells[1].childNodes[j].name.split('[')[1].split(']')[0];
			}
		}
		arrRowDescription = new Array();
		for(var iCellIndex = 0; iCellIndex< sltRow.cells.length; iCellIndex++){
			arrRowDescription[iCellIndex] = replaceAll(sltRow.cells[iCellIndex].innerHTML, '['+ oldIndex +']', '['+ newIndex +']');
			arrRowDescription[iCellIndex] = replaceAll(arrRowDescription[iCellIndex], '('+ oldIndex +')', '('+ newIndex +')');
		}			
		return arrRowDescription;
	}
	function chonDanhMucGoc1(selectedIds, selectedNames){		
		if(isEmpty(selectedIds))
			return;			
		document.getElementsByName('arrNoiDungTtktCqtTrucThuoc' + '[' + selectedIndex + '].idNoiDung')[0].value = selectedIds[0];
		document.getElementsByName('arrNoiDungTtktCqtTrucThuoc' + '[' + selectedIndex + '].tenNoiDung')[0].value = selectedNames[0];			
		
		// Xoa cac noi dung cu 		
		if(dsCacNoiDungDaChonId != null && dsCacNoiDungDaChonId != ''){
			for(var i = 0; i< dsCacNoiDungDaChonId.split(',').length - 1; i++)
				tblTtktCqtTrucThuoc.deleteRowByIndex(eval(selectedIndex + 1)) 			
		}
		// Them cac noi dung moi 
		for(var i = 1; i< selectedIds.length; i++){
			tblTtktCqtTrucThuoc.addRow(createNewRowTtktCqtTrucThuoc(selectedIds[i], selectedNames[i], selectedIndex + i), selectedIndex + i); 
		}
		
		// Cache lai cac dong index bi sai de xoa
		arrDeletedRow = new Array();
		for(var i = selectedIndex + selectedIds.length; i< tblTtktCqtTrucThuoc.numOfRow; i++){
			arrDeletedRow.push(copyRow(tblTtktCqtTrucThuoc.innerTable.rows[i], i));
		}	
		
		// Xoa cac dong bi sai chi so		
		while(true){
			try{				
				tblTtktCqtTrucThuoc.deleteRowByIndex(selectedIndex + selectedIds.length);
			}catch(err){
				break;
			}
		}
		// Thay bang cac dong hop le
		for(i = 0; i< arrDeletedRow.length; i++)
			tblTtktCqtTrucThuoc.addRow(arrDeletedRow[i]);
			
		tblTtktCqtTrucThuoc.reFormatStyleIncludeHeader();	
		// can thang hang
		for(i = 0; i< document.getElementById('tblTtktCqtTrucThuocAbc').rows.length; i++){
			document.getElementById('tblTtktCqtTrucThuocAbc').rows[i].style.verticalAlign = "bottom";
			document.getElementById('tblTtktCqtTrucThuocAbc').rows[i].cells[4].align = "center";
		}
		document.getElementsByName('arrNoiDungTtktCqtTrucThuoc[' +  eval (selectedIndex + selectedIds.length - 1) +'].tenNoiDung')[0].focus();
	}
	function chonDanhMucGoc(arrReturnTree){		
		if(isEmpty(arrReturnTree))
			return;			
		document.getElementsByName('arrNoiDungTtktCqtTrucThuoc' + '[' + selectedIndex + '].idNoiDung')[0].value = arrReturnTree[0].ma;
		document.getElementsByName('arrNoiDungTtktCqtTrucThuoc' + '[' + selectedIndex + '].tenNoiDung')[0].value = arrReturnTree[0].name;			
		document.getElementsByName('arrNoiDungTtktCqtTrucThuoc' + '[' + selectedIndex + '].chiTietNoiDung')[0].value = arrReturnTree[0].selectedChildIds;			
		
		// Xoa cac noi dung cu 		
		if(dsCacNoiDungDaChonId != null && dsCacNoiDungDaChonId.length != 0){
			for(var i = 0; i< dsCacNoiDungDaChonId.length - 1; i++)
				tblTtktCqtTrucThuoc.deleteRowByIndex(eval(selectedIndex + 1)) 			
		}
		// Them cac noi dung moi 
		for(var i = 1; i< arrReturnTree.length; i++){
			tblTtktCqtTrucThuoc.addRow(createNewRowTtktCqtTrucThuoc(arrReturnTree[i], selectedIndex + i), selectedIndex + i); 
		}
		
		// Cache lai cac dong index bi sai de xoa
		arrDeletedRow = new Array();
		for(var i = selectedIndex + arrReturnTree.length; i< tblTtktCqtTrucThuoc.numOfRow; i++){
			arrDeletedRow.push(copyRow(tblTtktCqtTrucThuoc.innerTable.rows[i], i));
		}	
		
		// Xoa cac dong bi sai chi so		
		while(true){
			try{				
				tblTtktCqtTrucThuoc.deleteRowByIndex(selectedIndex + arrReturnTree.length);
			}catch(err){
				break;
			}
		}
		
		
		// Thay bang cac dong hop le
		for(i = 0; i< arrDeletedRow.length; i++)
			tblTtktCqtTrucThuoc.addRow(arrDeletedRow[i]);
			
		tblTtktCqtTrucThuoc.reFormatStyleIncludeHeader();	
		// can thang hang
		for(i = 0; i< document.getElementById('tblTtktCqtTrucThuocAbc').rows.length; i++){
			document.getElementById('tblTtktCqtTrucThuocAbc').rows[i].style.verticalAlign = "bottom";
			document.getElementById('tblTtktCqtTrucThuocAbc').rows[i].cells[4].align = "center";
		}
		document.getElementsByName('arrNoiDungTtktCqtTrucThuoc[' +  eval (selectedIndex + arrReturnTree.length - 1) +'].tenNoiDung')[0].focus();
		
		
			
	}
	function selectChiTietDanhMuc(selectedIds){
		document.forms[0].elements[getReturnValueControlName].value = selectedIds;
		//document.forms[0].elements['selectedChiTietNoiDungTtktIds'].value = selectedIds;,,
		
	}
	
	window.onload = function(){
		var title = "<%=request.getAttribute("title")%>";
		if(title=="Thay đổi nội dung Kiểm tra so với kế hoạch"){
			$($('.lovButton')[0]).attr("disabled", true);
			$($('[name="donViBiName"]')[0]).attr("readonly", true);
			//$($('[name="nienDoTuNgay"]')[0]).attr("readonly", true);
			//$($('[name="thoiGianDuKien"]')[0]).attr("readonly", true);
			//$($('[name="loai"]')[0]).attr("readonly", true);
			//$($('[name="nienDoDenNgay"]')[0]).attr("readonly", true);
			//$($('[name="thoiGianDuKienTuNgay"]')[0]).attr("readonly", true);
			//$($('[name="thoiiGianDuKienDenNgay"]')[0]).attr("readonly", true);
			$($('.button')[0]).attr("disabled", true);
		}
		try{
			tblTtktCqtTrucThuoc = new TableObject('tblTtktCqtTrucThuocAbc', false, 'xoaTtktCqtTrucThuoc');
			tblRows = document.getElementById('tblTtktCqtTrucThuocAbc').rows;
			maCqt = '';
			index = 0; 
			while (true){
				element = document.getElementsByName('arrNoiDungTtktCqtTrucThuoc[' + index + '].idDonViBi')[0];		
				
				if(element.value == maCqt && maCqt != ''){
					//element.style.display = "none";
					element.parentNode.innerHTML = '' 
					cell1Childs = tblRows[index].cells[1].childNodes;
					for(var k =0; k< cell1Childs.length; k++){
						if(cell1Childs[k].value == '...')
							cell1Childs[k].disabled = true;
					}
					//tblRows[index].cells[7].childNodes[0].disabled = true;
				}else{
					maCqt = element.value;
				} 	
				index++;
				if(index == tblTtktCqtTrucThuoc.numOfRow)
					break;
			}
			//tblTtktCqtTrucThuoc.innerTable.rows[0].cells[tblTtktCqtTrucThuoc.numOfColumn - 1].childNodes[0].disabled = true;
		}catch(err){
			return;
		}		
	}
	
</script>
<%
if(cmc.com.ktnb.util.Constants.MSG_KHG_SUA.equals((String)request.getAttribute("Action status"))){%>
<script language="javascript">
		alert('<%=cmc.com.ktnb.util.Constants.MSG_KHG_SUA%>');
		window.close();
	</script>
<%}%>

<logic:present name="cuoc_ttkt_da_ra_qd">
	<script language="javascript">
		alert('Cuộc Thanh tra Kiểm tra đã ra quyết định không thể chỉnh sửa nội dung!');
		window.close();
	</script>
</logic:present>
<logic:present name="save_status">
	<logic:present name="idCuocTtktMoi">
		<script language="javascript">
			var idCuocTtktMoi = '<%=request.getAttribute("idCuocTtktMoi")%>'			
			window.opener.location = window.opener.location.href.replace(getUrlParam('cuocTtktId', window.opener.location.href), idCuocTtktMoi);
			window.close();
			}
		</script>
	</logic:present>
	<logic:notPresent name="idCuocTtktMoi">
		<logic:present name="ma moi">
			<script language="javascript">
				var maMoi = '<%=request.getAttribute("ma moi")%>'
				alert('Mã cuộc Thanh tra kiểm tra vừa tạo đã tồn tại, hệ thống sinh ra mã mới là: ' + maMoi);
				try{
					window.opener.search(); 
				}catch(err){ 
				}
				selfClose();
			</script>
		</logic:present>
		<logic:notPresent name="ma moi">
			<script language="javascript">
			var save_status = '<%=request.getAttribute("save_status")%>';
			if(save_status=="cuccess"){
				alert('Lưu thành công!');
				try{
					window.opener.search(); 
				}catch(err){ 
				}
				}else{
			alert("Lưu không thành công!\nKiểm tra lại niên độ hoặc nội dung thanh tra kiểm tra");
			}
				selfClose();	
			</script>
		</logic:notPresent>
	</logic:notPresent>
</logic:present>
<% String tiTle = "Tìm kiếm cuộc Thanh tra Kiểm Tra";
if (request.getAttribute("title") == null || !"".equals(request.getAttribute("title")))
tiTle = (String) request.getAttribute("title");%>
<h3 class="Header"><%=request.getAttribute("title")%></h3>
<script type="text/javascript" src="<html:rewrite page='/include/js/ttkt/tim_kiem.js'/>"></script>
<script language="javascript">
    var method;
    if(window.location.href.indexOf("view") > 0)
    	method = "view";
    else if(window.location.href.indexOf("edit") > 0)
    	method = "edit";
	var isView = window.location.href.indexOf("view") > 0? true:false; 
	
	
	function compareNienDoTuNgayAndNienDoDenNgay(control){
		nienDoTuNgay = document.forms[0].elements['nienDoTuNgay'];
		nienDoDenNgay = document.forms[0].elements['nienDoDenNgay'];
		if(nienDoTuNgay.value == '' || nienDoDenNgay.value == '')
			return true;
		if(!compare2Date(nienDoTuNgay, nienDoDenNgay)){
			control.focus();
			return false;
		}
			
		
	}	

</script>
<logic:present name="daSuaThongTinCuocTtkt">
	<script language="javascript">
		alert('Cuộc Thanh tra Kiểm tra đã được chỉnh sửa nội dung!');		
		window.close();
	</script>
</logic:present>
<logic:present name="Action error">
	<script language="javascript">
		var actionError = '<%=request.getAttribute("Action error")%>'
		alert(actionError);
		window.close();
	</script>
</logic:present>
<html:form action="cuoc_ttkt.do">
	<html:hidden property="id" />
	<html:hidden property="noiDungTtktGoc" />
	<html:hidden property="maCqtChon" />
	<html:hidden property="idDonViTh" />
	<html:hidden property="idCuocTtktTrongKh" />
	<html:hidden property="thoiDiem" />
	<html:hidden property="maCuocTtktTrongKh" />
	<html:hidden property="loaiChinhSua" />
	<html:hidden property="idCuocKhCu" />
	<html:hidden property="idCuocKhMoi" />
	<html:hidden property="loaiCuocTtktKeHoachNam" />
	<html:hidden property="idCuocQdCu" />
	<html:hidden property="idCuocQdMoi" />
	<html:hidden property="loaiCuocTtktQuyetDinh" />
	<html:hidden property="trangThai" />
	<html:hidden property="selectedNoiDungTtktIds" />
	<html:hidden property="selectedChiTietNoiDungTtktIds" />
	<html:hidden property="namKh" />
	<logic:present name="dmCqtTrucThuoc">
		<html:select property="propertyOfUtilCombo" style="display: none;">
			<html:option value="">
			</html:option>
			<logic:notPresent name="tu_ttkt">
				<html:options collection="dmCqtTrucThuoc" property="ma" labelProperty="ten" />
			</logic:notPresent>
			<logic:present name="tu_ttkt">
				<html:options collection="dmCqtTrucThuoc" property="id" labelProperty="name" />
			</logic:present>
		</html:select>
	</logic:present>
	<logic:notEqual name="trangThaiTienHanh" value="chuaTienHanh">
		<logic:notEqual name="trangThaiTienHanh" value="cbTienHanh">
			<DIV style="margin-left: 5px"><B><a href="#" onclick="xemLichTrinhDuKien();">Lịch trình dự kiến</a></B></DIV>
		</logic:notEqual>
	</logic:notEqual>
	<div>
	<Fieldset>
	<table align="center" width="100%" id="cuocTtkt">
		<tr>
			<td width="20%" align="right"><bean:message key="label.don_vi_duoc_ttkt" /> <font color=red>*</font></td>
			<td style="width: 1%; min-width: 5px" align="right"></td>
			<%if(KtnbUtil.isChiCuc(ac)){%>
			<td width="29%" align="left"><html:hidden property="idDonViBi" /> <html:text styleClass="text" readonly="true" style="width: 86%" property="donViBiName" onchange="chonCqtDuocTtkt();">
			</html:text> <input type="button" class="lovButton" value='...' onclick="chonCqtDuocTtkt();" disabled="disabled"></td>
			<%}else{%>
			<td width="29%" align="left"><html:hidden property="idDonViBi" /> <html:text styleClass="text" readonly="true" property="donViBiName" style="width: 86%" onchange="chonCqtDuocTtkt();">
			</html:text> <input type="button" class="lovButton" value='...' onclick="chonCqtDuocTtkt();" /></td>
			<%}%>
			<td width="20%" align="right"></td>
			<td style="width: 1%; min-width: 5px" align="right"></td>
			<td width="29%" align="left"><html:hidden property="maKhTtkt" /></td>			
		</tr>
		<tr>
			<td width="20%" align="right">Thời kỳ: Từ ngày <font color=red>*</font></td>
			<td width="1%" align="right"></td>
			<td width="29%" align="left"><html:text styleClass="text" property="nienDoTuNgay" onkeypress="return formatDate(event,this);" onblur="if(!isDate(this)) return;" onchange="changeGridForEdit();" style="width: 80%" /></td>
			<td width="20%" align="right"><bean:message key="label.den_ngay" /> <font color=red>*</font></td>
			<td width="1%" align="right"></td>
			<td width="29%" align="left"><html:text styleClass="text" property="nienDoDenNgay" onkeypress="return formatDate(event, this);" onblur="if(!isDate(this)) return; checkYear()" onchange="changeGridForEdit();" style="width: 100%" /></td>
		</tr>
		<tr>
			<td width="20%" align="right">Thời gian dự kiến<font color=red>*</font></td>
			<td width="1%" align="right"></td>
			<td width="29%" align="left"><html:text styleClass="text" style="width: 35" property="thoiGianDuKien" onchange="changeGridForEdit();" onkeypress="return formatInt(event);" onblur="if(!isNumber(this, 'i')) return; if(!isValidTime()) return; caculateDate('thoiGianDuKienTuNgay', 'thoiGianDuKienDenNgay', this.value);" /> &nbsp; ngày</td>
			<td width="20%" align="right">Từ ngày - đến ngày <font color=red>*</font></td>
			<td width="1%" align="right"></td>
			<td width="29%" align="left">
			<table style="margin: 0" border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
				<tr>
					<td align="left" width="45%" style="margin: 0"><html:text styleClass="text" property="thoiGianDuKienTuNgay" onkeypress="return formatDate(event,this);"
						onblur="if(!isDate(this)) return ; caculateDate('thoiGianDuKienTuNgay', 'thoiGianDuKienDenNgay', document.getElementsByName('thoiGianDuKien')[0].value); changeGridForEdit();"/></td>
					<td width="10%" align="center" style="text-align: center; margin: 0">-</td>
					<td align="right" width="45%" style="margin: 0"><html:text styleClass="text" styleClass="text" property="thoiGianDuKienDenNgay" onkeypress="return formatDate(event, this);"
						onblur="if(!isDate(this)) return; if(!compareDate(document.getElementsByName('thoiGianDuKienTuNgay')[0], this)) this.focus();" /></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td width="20%" align="right"><bean:message key="label.loai" /></td>
			<td width="1%" align="right"></td>
			<td width="29%" align="left"><logic:present name="CuocTtktForm" property="type">
				<html:hidden property="type" />
				<html:hidden name="CuocTtktForm" property="loai" />
				<html:select styleClass="combobox" disabled="true" styleClass="combobox" property="loai">
					<html:option value="0">
						<bean:message key="label.dinh_ky" />
					</html:option>
					<html:option value="1">
						<bean:message key="label.dot_xuat" />
					</html:option>
				</html:select>
			</logic:present> <logic:notPresent name="CuocTtktForm" property="type">
				<html:select styleClass="combobox" styleClass="combobox" property="loai">
					<html:option value="0">
						<bean:message key="label.dinh_ky" />
					</html:option>
					<html:option value="1">
						<bean:message key="label.dot_xuat" />
					</html:option>
				</html:select>
			</logic:notPresent></td>
			<td><html:hidden property="hinhThuc" /></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><INPUT type="button" class="button" onclick="chonNoiDungChoChiCuc()" value="Chọn nội dung"></td>
		</tr>
	</table>
	</fieldset>
	<logic:present name="CuocTtktForm" property="arrNoiDungTtktCqtTrucThuoc">
		<fieldset style="overflow: auto; width: 100%" id="noiDung"><legend> <!-- Nội dung Thanh tra Kiểm tra --> Nội dung Kiểm tra </legend>
		<DIV style="width: 100%; height: 370; overflow: hidden;">
		<DIV id="div1" style="border: 1px solid lightgrey; padding: 0px; background-color: whitesmoke; position: relative; width: 100%; height: 60; text-align: left; overflow: scroll;">
		<table width="1100" height="45">
			<tr class="TdHeaderList" height="45">
				<td align="left" width="15%">Tên cơ quan <font color=red>*</font></td>
				<td align="left" width="20%"><bean:message key="label.noi_dung" /> <font color=red>*</font></td>
				<td align="left" width="9%">Chi tiết</td>
				<td align="left" width="10%"><bean:message key="label.thoi_ky" /> <font color=red>*</font></td>
				<td align="left" width="7%">Thời gian dự kiến <font color=red>*</font></td>
				<td align="left" width="10%">Từ ngày - đến ngày <font color=red>*</font></td>
				<!-- <td align="left" width="5%"><bean:message key="label.hinh_thuc" /></td> -->
				<td align="center" width="2%">Chọn</td>
			</tr>
		</table>
		</DIV>
		<DIV id="div2" style="border: 1px solid lightgrey; padding: 0px; background-color: whitesmoke; position: relative; width: 100%; height: 300; top: -20; text-align: left; overflow: scroll;" onscroll="document.getElementById('div1').scrollLeft = this.scrollLeft;">
		<table width="1100" id="tblTtktCqtTrucThuocAbc" style="vertical-align: bottom;">
			<logic:iterate id="arrNoiDungTtktCqtTrucThuoc" name="CuocTtktForm" property="arrNoiDungTtktCqtTrucThuoc" indexId="index">
				<tr class='row<%=(index.intValue() % 2)+1 %>'>
					<!--Co quan thue-->
					<td align="left" width="15%"><!--Ma co quan thue--> <html:select onclick="getOldValue(this)" onchange='<%="setTenCqtDuocTtkt(this," + index + ")"%>' name="CuocTtktForm" property='<%="arrNoiDungTtktCqtTrucThuoc[" + index + "].idDonViBi"%>' style="width: 100%">
						<html:option value=""></html:option>
						<logic:present name="tu_ttkt">
							<html:options property="id" labelProperty="name" collection="dmCqtTrucThuoc" />
						</logic:present>
						<logic:notPresent name="tu_ttkt">
							<html:options property="ma" labelProperty="ten" collection="dmCqtTrucThuoc" />
						</logic:notPresent>
					</html:select> <!--Ten co quan thue--> <html:hidden name="CuocTtktForm" property='<%="arrNoiDungTtktCqtTrucThuoc[" + index + "].tenDonViBi"%>' /></td>
					<!--Noi dung-->
					<td align="left" style="vertical-align: bottom" width="20%"><!--Ma noi dung--> <html:hidden name="CuocTtktForm" property='<%="arrNoiDungTtktCqtTrucThuoc[" + index + "].idNoiDung"%>' /> <!--Ten noi dung--> <html:textarea style="WIDTH: 88%" readonly="true" name="CuocTtktForm"
						property='<%="arrNoiDungTtktCqtTrucThuoc[" + index + "].tenNoiDung"%>' /> <INPUT type="button" onclick="selectNoiDungTtkt(this)" value="..." class="lovButton"></td>
					<!--Chi tiet noi dung-->
					<td align="left" style="vertical-align: bottom; overflow: hidden" width="9%"><!--Ma chi tiet noi dung--> <html:text readonly="true" style="width: 95" name="CuocTtktForm" styleClass="text1" property='<%="arrNoiDungTtktCqtTrucThuoc[" + index + "].chiTietNoiDung"%>' /> <INPUT type="button"
						value="..." class="lovButton" onclick="chonNoiDungChiTiet(<%=index%>)" /> <!--Ten chi tiet noi dung--> <html:hidden name="CuocTtktForm" property='<%="arrNoiDungTtktCqtTrucThuoc[" + index + "].tenChiTietNoiDung"%>' /></td>
					<!--Thoi ky-->
					<td align="left" width="10%"><!--Tu ngay--> <html:text onblur="if(!isDate(this)) return; " onkeypress="return formatDate(event, this);" name="CuocTtktForm" styleClass="text1" style="WIDTH: 63" property='<%="arrNoiDungTtktCqtTrucThuoc[" + index + "].nienDoTuNgayStr"%>' /> - <!--Den ngay-->
					<html:text styleClass="text1" onblur="if(!isDate(this)) return; " onkeypress="return formatDate(event, this);" name="CuocTtktForm" property='<%="arrNoiDungTtktCqtTrucThuoc[" + index + "].nienDoDenNgayStr"%>' style="WIDTH: 63" /></td>
					<!--Thoi gian-->
					<td align="center" width="7%"><html:text name="CuocTtktForm" property='<%="arrNoiDungTtktCqtTrucThuoc[" + index + "].thoiGianDuKienStr"%>'
						onblur="if(!isNumber(this, 'i')) return;  caculateDate(this.name.replace('thoiGianDuKienStr', 'thoiGianDuKienTuNgayStr'), this.name.replace('thoiGianDuKienStr', 'thoiGianDuKienDenNgayStr'), this.value)" styleClass="text1" style="width: 35">
					</html:text>&nbsp; ngày</td>
					<!--Tu ngay, den ngay-->
					<td align="left" width="10%"><html:text name="CuocTtktForm" property='<%="arrNoiDungTtktCqtTrucThuoc[" + index + "].thoiGianDuKienTuNgayStr"%>' styleClass="text1" style="width: 63"
						onblur="if(!isDate(this)) return ;  caculateDate(this.name, this.name.replace('thoiGianDuKienTuNgayStr','thoiGianDuKienDenNgayStr'), document.getElementsByName(this.name.replace('thoiGianDuKienTuNgayStr', 'thoiGianDuKienStr'))[0].value)" onkeypress="return formatDate(event,this);">
					</html:text> - <html:text name="CuocTtktForm" property='<%="arrNoiDungTtktCqtTrucThuoc[" + index + "].thoiGianDuKienDenNgayStr"%>' styleClass="text1" style="width: 63" readonly="true">
					</html:text> <html:hidden property='<%="arrNoiDungTtktCqtTrucThuoc[" + index + "].hinhThucStr"%>' /></td>
					<td width="2%" align="center"><INPUT type="checkbox"></td>
				</tr>
			</logic:iterate>
		</table>
		</DIV>
		<DIV align="right" style="text-align: right; position: relative; top:-15px;clear: both;"><INPUT type="button" class="button" onclick="themCqtTrucThuoc()" value="Thêm"> <INPUT type="button" class="button" onclick="xoaCqtTrucThuoc()" value="Xóa"> <INPUT type="button"
			style="display: none;" id="xoaTtktCqtTrucThuoc">&nbsp;</DIV>
		</DIV>
		</fieldset>
	</logic:present> <logic:equal name="trangThaiTienHanh" value="cbTienHanh">
		<br>
		<DIV align="left" style="width: 100%;margin-left: 5px"><B><a href="#" onclick="openChuanBiTienHanh()">Chuẩn bị tiến hành</a></B></DIV>
	</logic:equal> <logic:equal name="trangThaiTienHanh" value="tienHanh">
		<br>
		<DIV align="left" style="width: 100%;margin-left: 5px"><B><a href="#" onclick="openChuanBiTienHanh()">Chuẩn bị tiến hành |</a> <a href="#" onclick="openTienHanh()">Tiến hành</a></B></DIV>
	</logic:equal> <logic:equal name="trangThaiTienHanh" value="ketThuc">
		<br>
		<DIV align="left" style="width: 100%;margin-left: 5px"><B><a href="#" onclick="openChuanBiTienHanh()">Chuẩn bị tiến hành |</a> <a href="#" onclick="openTienHanh()">Tiến hành |</a> <a href="#" onclick="ketThuc()">Kết thúc</a></B></DIV>
	</logic:equal> <logic:equal name="trangThaiTienHanh" value="huy">
		<br>
		<DIV align="left" style="width: 100%;margin-left: 5px"><B><a href="#" onclick="openHuy()">Hủy Thanh tra Kiểm tra</a></B></DIV>
	</logic:equal>   
	<br />
	<div style="width: 100%">
	<DIV align="center" style="width: 100%"><%@ include file="/ttkt/dung_chung/action_bar.jsp"%></DIV>
	</div>
</html:form>
<logic:present name="idCuocTtktMoi">
	<script language="javascript">
		var idCuocTtktMoi = '<%=request.getAttribute("idCuocTtktMoi")%>';
	</script>
</logic:present>
<logic:present name="thoiGianDuKien">
	<script language="javascript">
		var thoiGianDuKien = '<%=request.getAttribute("thoiGianDuKien")%>';
		function isValidTime(){
			thoiHan = document.getElementsByName('hinhThuc')[0].value == "0"? thoiGianDuKien.split(',')[0]:thoiGianDuKien.split(',')[1];	
			loai = document.getElementsByName('hinhThuc')[0].value == "0"? 'Thanh tra ':'Kiểm tra ';
			if(parseInt(document.getElementsByName('thoiGianDuKien')[0].value) > parseInt(thoiHan)){
				alert('Thời gian dự kiến ' + loai + 'không được quá ' + thoiHan + ' ngày!');
				document.getElementsByName('thoiGianDuKien')[0].focus();
				return false;
			}
			return true;
		}
	</script>
</logic:present>
<script language="javascript">	
	function reNewMaCuocTtkt(){
		if(document.forms[0].elements['hinhThuc'].value == "0")
			document.forms[0].elements['maKhTtkt'].value = document.forms[0].elements['maKhTtkt'].value.replace("/KT", "/TT");		
		else
			document.forms[0].elements['maKhTtkt'].value = document.forms[0].elements['maKhTtkt'].value.replace("/TT", "/KT");		
	}
	function changeGridForEdit(){
		//document.getElementsByName('arrNoiDungTtktCqtTrucThuoc' + '[' + selectedIndex + '].tenNoiDung')[0].value = selectedNames[0];
		//document.getElementsByName(nienDoTuNgayStr
		var inputs = document.getElementsByTagName("input");
		for(var i = 0; i < inputs.length; i++) {
		    if(inputs[i].name.indexOf('.nienDoTuNgayStr') > -1) {
		        inputs[i].value = document.getElementsByName('nienDoTuNgay')[0].value;
		    }
		    else if(inputs[i].name.indexOf('.nienDoDenNgayStr') > -1) {
		        inputs[i].value = document.getElementsByName('nienDoDenNgay')[0].value;
		    }
		    else if(inputs[i].name.indexOf('.thoiGianDuKienStr') > -1) {
		        inputs[i].value = document.getElementsByName('thoiGianDuKien')[0].value;
		    }
		    else if(inputs[i].name.indexOf('.thoiGianDuKienTuNgayStr') > -1) {
		        inputs[i].value = document.getElementsByName('thoiGianDuKienTuNgay')[0].value;
		    }
		    else if(inputs[i].name.indexOf('.thoiGianDuKienDenNgayStr') > -1) {
		        inputs[i].value = document.getElementsByName('thoiGianDuKienDenNgay')[0].value;
		    }
		}
	}	
</script>
<%@ include file="/bottom.jsp"%>