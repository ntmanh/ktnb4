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
		<fieldset><legend> Số liệu chuyển báo cáo </legend>
		<div class="content1">
			<div class="label" style="margin-right: 2px">Số đơn vị được thanh tra kiểm tra</div>
			<html:text name="KetThucTtktForm" property="soDviDuocTtkt" styleClass="style2" onkeypress="return formatNumber(event, this)"></html:text>
			<div class="note">(Đơn vị)</div>
			<div class="label1">Số đơn vị sai phạm</div>
			<html:text name="KetThucTtktForm" property="soDviSaiPham" styleClass="style2" onkeypress="return formatNumber(event, this)"></html:text>
			<div class="note">(Đơn vị)</div>
		</div>
		<fieldset><legend> Sai phạm đã thu hồi và hoàn trả </legend>
			<fieldset><legend> Tổng số tiền sai phạm đã thu hồi hoàn trả</legend>
				<fieldset><legend> Công chức Thuế</legend>
					<div class="content1">
						<div class="label" style="width: 24%;margin-right: 1px;">Số tiền đã thu</div>
						<html:text name="KetThucTtktForm" property="tienPhaiThuCongChucThue" styleClass="style2" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)"></html:text>
						<div class="note" style="margin-right: 14px;">(Nghìn đồng)</div>
						<div class="label1">Số tiền đã hoàn trả</div>
						<html:text name="KetThucTtktForm" property="tienHoanTraCongChucThue" styleClass="style2" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)"></html:text>
						<div class="note">(Nghìn đồng)</div>
					</div>
				</fieldset>
				<fieldset><legend> Người nộp Thuế</legend>
					<div class="content1">
						<div class="label" style="width: 24%;margin-right: 1px;">Số tiền đã thu</div>
						<html:text name="KetThucTtktForm" property="tienPhaiThuNguoiNopThue" styleClass="style2" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)"></html:text>
						<div class="note" style="margin-right: 14px;">(Nghìn đồng)</div>
						<div class="label1">Số tiền đã hoàn trả</div>
						<html:text name="KetThucTtktForm" property="tienHoanTraNguoiNopThue" styleClass="style2" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)"></html:text>
						<div class="note">(Nghìn đồng)</div>
					</div>
				</fieldset>
			</fieldset>
			<div class="content1">
				<div class="label" style="width: 24%; margin-right: 3px;">Số tiền đã thu hồi và hoàn trả khác</div>
				<html:text name="KetThucTtktForm" property="soTienThuHtraSpKhac" styleClass="style2" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)"></html:text>
			</div>
		</fieldset>
		<fieldset><legend> Cá nhân sai phạm đã xử lí </legend>
			<fieldset><legend> Xử lí hành chính </legend>
				<div class="content1">
					<div class="label" style="width: 24%;">Kiểm điểm rút kinh nghiệm</div>
					<html:text name="KetThucTtktForm" property="soKiemDiem" styleClass="style2" onkeypress="return formatNumber(event, this)"></html:text>
					<div class="note">(Người)</div>
					<div class="label1" style="width: 17%;">Giáng chức</div>
					<html:text name="KetThucTtktForm" property="soGiangChuc"styleClass="style2" onkeypress="return formatNumber(event, this)"></html:text>
					<div class="note">(Người)</div>
				</div>
				<div class="content1">
					<div class="label" style="width: 24%;">Khiển trách</div>
					<html:text name="KetThucTtktForm" property="soKhienTrach" styleClass="style2" onkeypress="return formatNumber(event, this)"></html:text>
					<div class="note">(Người)</div>
					<div class="label1" style="width: 17%;">Cách chức</div>
					<html:text name="KetThucTtktForm" property="soCachChuc"styleClass="style2" onkeypress="return formatNumber(event, this)"></html:text>
					<div class="note">(Người)</div>
				</div>
				<div class="content1">
					<div class="label" style="width: 24%;">Cảnh cáo</div>
					<html:text name="KetThucTtktForm" property="soCanhCao" styleClass="style2" onkeypress="return formatNumber(event, this)"></html:text>
					<div class="note">(Người)</div>
					<div class="label1" style="width: 17%;">Buộc thôi việc</div>
					<html:text name="KetThucTtktForm" property="soThoiViec"styleClass="style2" onkeypress="return formatNumber(event, this)"></html:text>
					<div class="note">(Người)</div>
				</div>
				<div class="content1">
					<div class="label" style="width: 24%;">Hạ bậc lương</div>
					<html:text name="KetThucTtktForm" property="soHaBacLuong" styleClass="style2" onkeypress="return formatNumber(event, this)"></html:text>
					<div class="note">(Người)</div>
					<div class="label1" style="width: 17%;">Khác</div>
					<html:text name="KetThucTtktForm" property="soKhac" styleClass="style2" onkeypress="return formatNumber(event, this)"></html:text>
					<div class="note">(Người)</div>
				</div>				
			</fieldset>
			<div class="content1">
				<div class="label" style="width: 24%; margin-right:1px; ">Xử lí hình sự (có án)</div>
				<html:text name="KetThucTtktForm" property="soXlhsCoAn" styleClass="style2" onkeypress="return formatNumber(event, this)"></html:text>
				<div class="note">(Người)</div>
			</div>				
		<fieldset><legend> Sai phạm khác đã xử lí</legend>
			<div class="content1">
				<div class="label" style="width: 24%;">Sửa đổi bổ sung văn bản pháp quy</div>
				<html:text name="KetThucTtktForm" property="soSdbsVbpq" styleClass="style2" onkeypress="return formatNumber(event, this)"></html:text>
				<div class="note">(Số lượng)</div>
			</div>
			<div class="content1">
				<div class="label" style="width: 24%;">Sửa đổi bổ sung quy trình quy chế</div>
				<html:text name="KetThucTtktForm" property="soSdbsQtqc" styleClass="style2" onkeypress="return formatNumber(event, this)"></html:text>
				<div class="note">(Số lượng)</div>
			</div>		
			<fieldset><legend> Thanh tra kiểm tra lại về Thuế</legend>
				<div class="content1">
					<div class="label" style="width:24%;">Số lượng</div>
					<html:text name="KetThucTtktForm" property="soTtktThue" styleClass="style2" onkeypress="return formatNumber(event, this)"></html:text>
					<div class="note">(Số lượng)</div>
				</div>   
				<div class="content1">
					<div class="label" style="width:24%;">Số tiền đã thu</div>
					<html:text name="KetThucTtktForm" property="tienPhaiThuTtktThue" styleClass="style2" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)"></html:text>
					<div class="note">(Nghìn đồng)</div>
					<div class="label1" style="width:17%;">Số tiền đã hoàn trả</div>
					<html:text name="KetThucTtktForm" property="tienHoanTraTtktThue" styleClass="style2" onblur="isNumber(this, 'double')" onkeypress="return formatNumber(event, this)"></html:text>
					<div class="note">(Nghìn đồng)</div>
				</div>   
			</fieldset>
			<div class="content1">
					<div class="label" style="width:24%;">Kiến nghị khác</div>
					<html:text name="KetThucTtktForm" property="kienNghiKhac" styleClass="style2" onkeypress="return formatNumber(event, this)"></html:text>
					<div class="note">(Số lượng)</div>
				</div>
		</fieldset>
	</fieldset>
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