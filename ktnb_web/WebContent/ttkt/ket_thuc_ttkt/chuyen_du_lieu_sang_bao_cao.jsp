<%@page pageEncoding="UTF-8" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<!--begin-->
<div id="saveKqThuchienKL" style="display: none;"></div>
<html:form action="ket_thuc_ttkt.do?method=save&type=chuyenDuLieuSangBaoCao" method="post" enctype="multipart/form-data">                           
	<div class="content1">
		<div class="label" style="margin-right: 1px">Ngày nhận báo cáo kết quả<font color="red">*</font></div>
		<html:text name="KetThucTtktForm" property="ngayNhanBckq" styleClass="style1" onblur="if(!isDate(this)) return;validateNgayNhanBckq();" onkeypress="return formatDate(event, this)"></html:text>
		<html:checkbox name="KetThucTtktForm" property="ketThucTdoiThanh"></html:checkbox>Kết thúc theo dõi thi hành
		
		<!-- <div class="label">Kết thúc theo dõi thi hành</div> -->
	</div>
	<div class="content1">
			<div class="label">File đính kèm</div>
			<A href="#" onclick="downloadBienBanChiTiet1(document.getElementsByName('idKqThucHienKl')[0].value);">
			<font color=blue>Báo cáo kết quả thực hiện kết luận</font></A>
	</div>
	<logic:notPresent name="readOnly">
		<div class="content1">
			<div class="label">Báo cáo kết quả đính kèm</div>
			<html:file property="baoCaoKqDinhKem"  />
		</div>
	</logic:notPresent>
		<table style="width:100%;">
			<tr>
				<td colspan="6" style="background-color:#CCC"><b>Số liệu chuyển báo cáo</b></td>             
			</tr>
			<tr>
				<td width="20%" style="text-align: right;">Số đơn vị được thanh tra kiểm tra</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="soDviDuocTtkt" styleClass="text" style="width:70%" onkeypress="return formatNumber(event, this)"></html:text>(Đơn vị)</td>
				<td width="20%" style="text-align: right;">Số đơn vị sai phạm</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="soDviSaiPham" styleClass="text" style="width:70%" onkeypress="return formatNumber(event, this)"></html:text>(Đơn vị)</td>
			</tr>
			<tr>
				<td colspan="6" style="background-color:#CCC"><b>Sai phạm đã thu hồi và hoàn trả</b></td>
			</tr>
			<tr>
				<td colspan="6" style="background-color:#DDD"><b>Tổng số tiền sai phạm đã thu hồi hoàn trả</b></td>
			</tr>
			<tr>
				<td colspan="6" style="background-color:#DDD"><b>Công chức Thuế</b></td>
			</tr>
			<tr>
				<td width="20%" style="text-align: right;">Số tiền đã thu</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="tienPhaiThuCongChucThue" styleClass="text" style="width:70%" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)"></html:text>(Nghìn đồng)</td>
				<td width="20%" style="text-align: right;">Số tiền đã hoàn trả</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="tienHoanTraCongChucThue" styleClass="text" style="width:70%" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)"></html:text>(Nghìn đồng)</td>
			</tr>
			<tr>
				<td colspan="6" style="background-color:#DDD"><b>Người nộp Thuế</b></td>
			</tr>
			<tr>
				<td width="20%" style="text-align: right;">Số tiền đã thu</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="tienPhaiThuNguoiNopThue" styleClass="text" style="width:70%" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)"></html:text>(Nghìn đồng)</td>
				<td width="20%" style="text-align: right;">Số tiền đã hoàn trả</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="tienHoanTraNguoiNopThue" styleClass="text" style="width:70%" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)"></html:text>(Nghìn đồng)</td>
			</tr>
			<tr>
				<td width="20%" style="text-align: right;">Số tiền đã thu hồi và hoàn trả khác</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="soTienThuHtraSpKhac" styleClass="text" style="width:70%" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)"></html:text></td>
			</tr>
			<tr>
				<td colspan="6" style="background-color:#CCC"><b>Cá nhân sai phạm đã xử lí</b></td>
			</tr>
			<tr>
				<td colspan="6" style="background-color:#DDD"><b>Xử lí hành chính</b></td>
			</tr>
			<tr>
				<td width="20%" style="text-align: right;">Kiểm điểm rút kinh nghiệm</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="soKiemDiem" styleClass="text" style="width:70%" onkeypress="return formatNumber(event, this)"></html:text>(Người)</td>
				<td width="20%" style="text-align: right;">Giáng chức</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="soGiangChuc"styleClass="text" style="width:70%" onkeypress="return formatNumber(event, this)"></html:text>(Người)</td>
			</tr>
			<tr>
				<td width="20%" style="text-align: right;">Khiển trách</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="soKhienTrach" styleClass="text" style="width:70%" onkeypress="return formatNumber(event, this)"></html:text>(Người)</td>
				<td width="20%" style="text-align: right;">Cách chức</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="soCachChuc"styleClass="text" style="width:70%" onkeypress="return formatNumber(event, this)"></html:text>(Người)</td>
			</tr>
			<tr>
				<td width="20%" style="text-align: right;">Cảnh cáo</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="soCanhCao" styleClass="text" style="width:70%" onkeypress="return formatNumber(event, this)"></html:text>(Người)</td>
				<td width="20%" style="text-align: right;">Buộc thôi việc</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="soThoiViec"styleClass="text" style="width:70%" onkeypress="return formatNumber(event, this)"></html:text>(Người)</td>
			</tr>
			<tr>
				<td width="20%" style="text-align: right;">Hạ bậc lương</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="soHaBacLuong" styleClass="text" style="width:70%" onkeypress="return formatNumber(event, this)"></html:text>(Người)</td>
				<td width="20%" style="text-align: right;">Khác</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="soKhac" styleClass="text" style="width:70%" onkeypress="return formatNumber(event, this)"></html:text>(Người)</td>
			</tr>
			<tr>
				<td width="20%" style="text-align: right;">Xử lí hình sự (có án)</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="soXlhsCoAn" styleClass="text" style="width:70%" onkeypress="return formatNumber(event, this)"></html:text>(Người)</td>
			</tr>
			<tr>
				<td colspan="6" style="background-color:#DDD"><b>Sai phạm khác đã xử lí</b></td>
			</tr>
			<tr>
				<td width="20%" style="text-align: right;">Sửa đổi bổ sung văn bản pháp quy</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="soSdbsVbpq" styleClass="text" style="width:70%" onkeypress="return formatNumber(event, this)"></html:text>(Số lượng)</td>
			</tr>
			<tr>
				<td width="20%" style="text-align: right;">Sửa đổi bổ sung quy trình quy chế</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="soSdbsQtqc" styleClass="text" style="width:70%" onkeypress="return formatNumber(event, this)"></html:text>(Số lượng)</td>
			</tr>
			<tr>
				<td colspan="6" style="background-color:#DDD"><b>Thanh tra kiểm tra lại về Thuế</b></td>
			</tr>
			<tr>
				<td width="20%" style="text-align: right;">Số lượng</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="soTtktThue" styleClass="text" style="width:70%" onkeypress="return formatNumber(event, this)"></html:text>(Số lượng)</td>
			</tr>
			<tr>
				<td width="20%" style="text-align: right;">Số tiền đã thu</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="tienPhaiThuTtktThue" styleClass="text" style="width:70%" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)"></html:text>(Nghìn đồng)</td>
				<td width="20%" style="text-align: right;">Số tiền đã hoàn trả</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="tienHoanTraTtktThue" styleClass="text" style="width:70%" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)"></html:text>(Nghìn đồng)</td>
			</tr>
			<tr>
				<td width="20%" style="text-align: right;">Kiến nghị khác</td>
				<td width="30%"><html:text name="KetThucTtktForm" property="kienNghiKhac" styleClass="text" style="width:70%" onkeypress="return formatNumber(event, this)"></html:text>(Số lượng)</td>
			</tr>
		</table>
	<html:hidden property="idKqThucHienKl" />
</html:form>
<!--end-->
<script language="javascript">  
function onLoadChuyenDuLieuSangBaoCao(){  
	   
}
function downloadBienBanChiTiet1(bbchiTietId){
		downLoadWinDow = window.open('UploadAction.do?method=downLoadKetLuanChuyenBaoCao&ma_file='+bbchiTietId);
		downLoadWinDow.focus();
	}
function validateNgayNhanBckq(){
	if(d2n($('[name=ngayNhanBckq]')[0].value)!=null&&d2n($('[name=ngayNhanBckq]')[0].value)!=""){
		if(d2n($('[name=ngayKetThuc]')[0].value)>d2n($('[name=ngayNhanBckq]')[0].value)){
			alert("Ngày nhận báo cáo kết quả sau ngày thông báo kết thúc");
			$($('[name=ngayNhanBckq]')[0]).select().focus().effect("highlight",3000);
		}
	}
}
function validateChuyenDuLieuSangBaoCao(){
	if($('[name=ketThucTdoiThanh]')[0].checked){
		if(d2n($('[name=ngayNhanBckq]')[0].value)==null || d2n($('[name=ngayNhanBckq]')[0].value)==""){
			alert("Để kết thúc theo dõi thi hành phải nhập ngày nhận báo cáo kết quả");
			return false;	
		}		
	}
	return true;
}
</script>