<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<div id="saveKetLuanSangBaoCao" style="display: none;"></div>
<html:form action="ket_thuc_ttkt.do?method=save&type=ketLuanSangBaoCao" method="post">
	<div class="content_base">
	    <div style="margin-left:20px;margin-top:10px;margin-right:30px;float:left">Download biểu mẫu</div>
	    <div style="margin-top:10px;float:left"><a href="#" onclick="downLoadBieuMau()" ><font color="blue">Mẫu 37/TTNB</font></a></div>	      			
	<table style="width:100%;">
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Số liệu chuyển sang báo cáo</b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số đơn vị được TTKT</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcSoDonViTTKT" onkeypress="return formatNumber(event, this)" styleClass="text"></html:text></td>
		<td width="20%" style="text-align: right;">Số đơn vị sai phạm</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcSoDonViSaiPham" onkeypress="return formatNumber(event, this)" styleClass="text"></html:text></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;"></td>
		<td width="30%"><html:checkbox name="KetThucTtktForm" property="dcKiemTraSauTTKT" value="1" onclick="showHide()" styleId="ck"></html:checkbox>Kiểm tra sau TTKT</td>
		<td width="20%" style="text-align: right;"></td>
		<td width="30%"></td>		
	</tr>
	<tr id ="soTienDaThu">
		<td width="20%" style="text-align: right;">Tổng số KL TTKT và QĐ xử lý đã kiểm tra</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcTsKlTtktQdxlDaKtra" onkeypress="return formatNumber(event, this)" styleClass="text"></html:text></td>
		<td width="20%" style="text-align: right;">Số tiền đã thu</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="soTienDaThuHauKiem" onkeypress="return formatNumber(event, this)" onblur="isNumber(this, 'double')"  styleClass="text" style="width:70%"></html:text>(Nghìn đồng)</td>				
	</tr>
	<tr>
		<td colspan="4" style="background-color:#CCC"><b>Sai phạm phải thu hồi và hoàn trả</b></td>
	</tr>	
	<tr>
		<td colspan="4" style="background-color:#DDD"><b><i>Tổng số tiền sai phạm và hoàn trả</i></b></td>
	</tr>
	<tr>
		<td colspan="4" style="background-color:#DDD"><i>Công chức Thuế</i></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số tiền phải thu</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcTSTienThuCongChucThue"  onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" styleClass="text" style="width:70%"></html:text>(Nghìn đồng)</td>
		<td width="20%" style="text-align: right;">Số phải hoàn trả</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcTSTienTraCongChucThue" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" styleClass="text" style="width:70%"></html:text>(Nghìn đồng)</td>				
	</tr>
	<tr>
		<td colspan="4" style="background-color:#DDD"><i>Người nộp Thuế</i></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số tiền phải thu</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcTSTienThuNguoiNopThue" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" styleClass="text" style="width:70%"></html:text>(Nghìn đồng)</td>
		<td width="20%" style="text-align: right;">Số phải hoàn trả</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcTSTienTraNguoiNopThue" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" styleClass="text" style="width:70%"></html:text>(Nghìn đồng)</td>				
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số tiền sai phạm phải thu hồi và hoàn trả khác</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcTsTienThuHtraSpKhac" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" styleClass="text" style="width:70%"></html:text>(Nghìn đồng)</td>
		<td width="20%" style="text-align: right;"></td>
		<td width="30%"></td>				
	</tr>
	<tr>
		<td colspan="4" style="background-color:#DDD"><i>Đối tượng thu khác</i></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số tiền phải thu</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcSoTienThuDoiTuongKhac" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" styleClass="text" style="width:70%"></html:text>(Nghìn đồng)</td>
		<td width="20%" style="text-align: right;">Số phải hoàn trả</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcSoTienNopDoiTuongKhac" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" styleClass="text" style="width:70%"></html:text>(Nghìn đồng)</td>				
	</tr>
	
	<tr>
		<td colspan="4" style="background-color:#DDD"><b><i>Số tiền kiến nghị thu hồi và hoàn trả</i></b></td>
	</tr>
	<tr>
		<td colspan="4" style="background-color:#DDD"><i>Công chức Thuế</i></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số tiền phải thu</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcSoTienThuCongChucThue"  onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" styleClass="text" style="width:70%"></html:text>(Nghìn đồng)</td>
		<td width="20%" style="text-align: right;">Số phải hoàn trả</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcSoTienNopCongChucTHue" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" styleClass="text" style="width:70%"></html:text>(Nghìn đồng)</td>				
	</tr>
	<tr>
		<td colspan="4" style="background-color:#DDD"><i>Người nộp Thuế</i></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số tiền phải thu</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcSoTienThuNguoiNopThue" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" styleClass="text" style="width:70%"></html:text>(Nghìn đồng)</td>
		<td width="20%" style="text-align: right;">Số phải hoàn trả</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcSoTienNopNguoiNopThue" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" styleClass="text" style="width:70%"></html:text>(Nghìn đồng)</td>				
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số tiền sai phạm phải thu hồi và hoàn trả khác</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcSoTienKnghiThuHtraSpKhac" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)" styleClass="text" style="width:70%"></html:text>(Nghìn đồng)</td>
		<td width="20%" style="text-align: right;"></td>
		<td width="30%"></td>				
	</tr>
	<tr>
		<td colspan="4" style="background-color:#DDD"><b><i>Cá nhân sai phạm</i></b></td>
	</tr>
	<tr>
		<td colspan="4" style="background-color:#DDD"><i>Kiến nghị xử lí hành chính</i></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Công chức viên chức Thuế</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcXuLiHanhChinhCongVienChucThue" onkeypress="return formatNumber(event, this)" styleClass="text"></html:text></td>
		<td width="20%" style="text-align: right;">Đối tượng khác</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcXuLiHanhChinhDoiTuongKhac" onkeypress="return formatNumber(event, this)" styleClass="text"></html:text></td>		
	</tr>
	<tr>
		<td colspan="4" style="background-color:#DDD"><i>Kiến nghị xử lí hình sự</i></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Số vụ việc</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcXLHSSoVuViec" onkeypress="return formatNumber(event, this)" styleClass="text"></html:text></td>
		<td width="20%" style="text-align: right;">Số người</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcXLHSSoNguoi" onkeypress="return formatNumber(event, this)" styleClass="text"></html:text></td>		
	</tr>
	<tr>
		<td colspan="4" style="background-color:#DDD"><b><i>Sai phạm khác</i></b></td>
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Sửa đổi bổ sung văn bản pháp quy</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcSoSDBS_VPBQ" onkeypress="return formatNumber(event, this)" styleClass="text"></html:text></td>
		<td width="20%" style="text-align: right;">Sửa đổi bổ sung quy trình quy chế</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcSoSDBC_QTQC" onkeypress="return formatNumber(event, this)" styleClass="text"></html:text></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Thanh tra kiểm tra lại về thuế</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcSoTTKTThue" onkeypress="return formatNumber(event, this)" styleClass="text"></html:text></td>
		<td width="20%" style="text-align: right;">Kiến nghị khác</td>
		<td width="30%"><html:text name="KetThucTtktForm" property="dcKienNghiKhac" onkeypress="return formatNumber(event, this)" styleClass="text"></html:text></td>		
	</tr>
	<tr>
		<td width="20%" style="text-align: right;">Được mô tả</td>
		<td width="80%" colspan="3"><html:textarea name="KetThucTtktForm" onkeypress="imposeMaxLength(this);"  property="dcMoTa" style="width:100%;"></html:textarea><html:hidden property="dcID" /></td>		
	</tr>
	</table>
	</div>
</html:form>
<script language="javascript">    
function validateNDLTKetLuan(){	
	if($('[name="soKetLuan"]')[0].value.length<1){
		alert("Chưa có kết luận!");
		return false;
	}
	if($('[name="dcSoDonViTTKT"]')[0].value<$('[name="dcSoDonViSaiPham"]')[0].value){
		alert("Số đơn vị sai phạm phải nhỏ hơn số đơn vị được thanh tra kiểm tra!");
		$($('[name="dcSoDonViTTKT"]')[0]).effect('highlight',null,1000);
		$($('[name="dcSoDonViSaiPham"]')[0]).effect('highlight',null,1000);
		return false;
	}
	return true;
}
$(function(){
	if($('#ck').attr('checked'))
	{
		$('#soTienDaThu').show();
	}else{
		$('#soTienDaThu').hide();
	}
});
function showHide(){
 $("#soTienDaThu").toggle(100);
 if(!$('#ck').attr('checked')){ 	
 	$('[name="dcKiemTraSauTTKT"]')[0].value = 0;
 }
}
</script>
