<%@page pageEncoding="UTF-8" %>
<%@ include file="/top_bar.jsp"%>
<script language="javascript">
	var type = '<%=(String)request.getAttribute("type")%>'
</script>
<logic:equal name="type" value="thayDoiThanhVienDoan">
	<fieldset>
	<table style="width: 100%" id="tdTvd">
		<tr class="TdHeaderList">
			<td>Số quyết định</td>
			<td>Ngày ra quyết định</td>
			<td>Người đề nghị</td>
			<td>Loại thay đổi</td>
			<td>Danh sách thành viên cũ</td>
			<td>Danh sách thành viên mới</td>
			<td align="center">Chọn</td>
		</tr>
		<logic:present name="dsThayDoiTvd">
			<logic:iterate id="thayDoiTvd" name="dsThayDoiTvd" indexId="index">
				<tr class='row<%=(index.intValue() % 2)+1 %>'>
					<td><A href="#" onclick="xemChiTietThayDoi('<bean:write property="id" name="thayDoiTvd" />')"><bean:write property="soQd" name="thayDoiTvd" /></A></td>
					<td><bean:write property="ngayRaQd" name="thayDoiTvd" format="dd/MM/yyyy" /></td>
					<td><bean:write property="tenNguoiDeNghi" name="thayDoiTvd" /></td>
					<td><logic:equal property="loaiThayDoi" name="thayDoiTvd" value="truong_doan">
						<script language="javascript">
							document.write('Trưởng đoàn');
						</script>
					</logic:equal> <logic:equal property="loaiThayDoi" name="thayDoiTvd" value="thanh_vien_doan">
						<script language="javascript">
							document.write('Thành viên đoàn');
						</script>
					</logic:equal> <logic:equal property="loaiThayDoi" name="thayDoiTvd" value="bo_sung_thanh_vien_doan">
						<script language="javascript">
							document.write('Bổ sung thành viên');
						</script>
					</logic:equal></td>
					<td><a href="#" onclick="xemDanhSachTvById('<bean:write property="idDstvCu" name="thayDoiTvd" />')">Danh sách thành viên cũ</a></td>
					<td><a href="#" onclick="xemDanhSachTvById('<bean:write property="idDstvMoi" name="thayDoiTvd" />')">Danh sách thành viên mới</a></td>
					<td align="center"><INPUT type="radio" name="giaHan" onclick="setSelectedItem('<bean:write property="id"
					name="thayDoiTvd" />', '<bean:write property="soQd" name="thayDoiTvd" />')"></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	<script language="javascript">
function xemChiTietThayDoi(idThayDoi){
	detailWindow = window.open('thay_doi_thanh_vien_doan.do?id=' + idThayDoi);
	detailWindow.focus();
}
function xemDanhSachTvById(idDsTv){
	openWindow('danh_sach_tv.do?id=' + idDsTv, '600','200', 'menubar=no,toolbar=no,location=no,status=no,scrollbars=no,resizable=no');
	
}


</script>
</fieldset>
</logic:equal> <logic:equal name="type" value="yeucaucungcapHSTL">
	<TABLE width="100%" id="tblYeucaucungcapHSTL">
		<tr class="TdHeaderList">
			<td>Ngày Lập phiếu</td>
			<td>Người lập phiếu</td>
			<td>Người nhận phiếu</td>
			<td>Ngày nhận phiếu</td>
			<td>Lần</td>
			<td>Thời điểm cung cấp</td>
			<td>Địa điểm cung cấp</td>
			<td align="center">Chọn</td>
		</tr>
		<logic:present name="dsYeuCauBaoCaoHsTl">
			<logic:iterate id="ttptDoanTtkt" name="dsYeuCauBaoCaoHsTl" indexId="index">
				<tr class='row<%=(index.intValue() % 2)+1 %>'>
					<td><A href="#" onclick="window.open('yeu_cau_cung_cap_tai_lieu.do?method=view&id=' + '<bean:write property="id"
							name="ttptDoanTtkt" />')"><bean:write property="ngayLapYeuCau" name="ttptDoanTtkt" format="dd/MM/yyyy" /></A></td>
					<td><bean:write property="tenCanBoYeuCau" name="ttptDoanTtkt" /></td>
					<td><bean:write property="tenNguoiNhanPhieuYc" name="ttptDoanTtkt" /></td>
					<td><bean:write property="thoiDiemNhanPhieuYc" name="ttptDoanTtkt" format="dd/MM/yyyy" /></td>
					<td><bean:write property="lanYeuCau" name="ttptDoanTtkt" /></td>
					<td><bean:write property="thoiDiemCungCap" format="mm:hh dd/MM/yyyy" name="ttptDoanTtkt" /></td>
					<td><bean:write property="diaDiemCungCap" name="ttptDoanTtkt" /></td>
					<td align="center"><INPUT type="radio" name="giaHan" onclick="setSelectedItem('<bean:write property="id"
							name="ttptDoanTtkt" />')"></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
</logic:equal> <logic:equal name="type" value="bienBanLamViecTrongQTTienHanh">
	<TABLE width="100%" id="tblBienBanLamViecTT">
		<tr class="TdHeaderList">
			<td>Loại biên bản</td>
			<td>Ngày làm việc</td>
			<td>Địa điểm làm việc</td>
			<td>Làm việc với</td>
			<td align="center">Chọn</td>
		</tr>
		<logic:present name="dsBienBanLamViec">
			<logic:iterate id="bbLamViec" name="dsBienBanLamViec" indexId="index">
				<tr class='row<%=(index.intValue() % 2)+1 %>'>
					<td><A href="#" onclick="window.open('bien_ban_lam_viec.do?method=view&id=' + '<bean:write property="id"
							name="bbLamViec" />')"><bean:write property="loai" name="bbLamViec" /></A></td>
					<td><bean:write property="thoiDiemBatDau" name="bbLamViec" format="dd/MM/yyyy" /></td>
					<td><bean:write property="diaDiem" name="bbLamViec" /></td>
					<td><bean:write property="lamViecVoi" name="bbLamViec" /></td>
					<td align="center"><INPUT type="radio" name="giaHan" onclick="setSelectedItem('<bean:write property="id"
							name="bbLamViec" />')"></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
</logic:equal> <logic:equal name="type" value="niemPhongHSTL">
	<fieldset><legend>Kết quả tìm kiếm</legend>
	<TABLE align="center" width="100%" id="tblNiemPhongHSTL">
		<tr class="TdHeaderList">
			<td align="center">STT</td>
			<td>Ngày ra quyết định</td>
			<td>Nơi ra quyết định</td>
			<td>Ngày tiến hành</td>
			<td>Đơn vị cá nhân thực hiện</td>
			<td>Đơn vị cá nhân bảo quản</td>
			<td align="center">Chọn</td>
		</tr>
		<logic:present name="dsNiemPhongHsTl">
			<logic:iterate id="niemphonghstl" name="dsNiemPhongHsTl" indexId="index">
				<tr class='row<%=(index.intValue() % 2)+1 %>'>
					<td align="center"><%=index.intValue() + 1%></td>
					<td><A href="#" onclick="window.open('niem_phong_ho_so_tai_lieu.do?method=view&id=' + '<bean:write property="id"
							name="niemphonghstl" />')"><bean:write property="ngayRaQd" name="niemphonghstl" format="dd/MM/yyyy" /></A></td>
					<td><bean:write property="noiRaQd" name="niemphonghstl" /></td>
					<td><bean:write property="tgNiemPhongTu" name="niemphonghstl" format="dd/MM/yyyy" /></td>
					<td><bean:write property="tenDviCnhanThucHien" name="niemphonghstl" format="dd/MM/yyyy" /></td>
					<td><bean:write property="tenDviCnhanBaoQuan" name="niemphonghstl" format="dd/MM/yyyy" /></td>
					<td align="center"><INPUT type="radio" name="niemphonghstl" onclick="setSelectedItem('<bean:write property="id"
						name="niemphonghstl" />')"></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</fieldset>
</logic:equal> <logic:equal name="type" value="yeuCauGiaiTrinh">
	<fieldset>
	<TABLE width="100%" id="tblYeuCauGiaiTrinh">
		<tr class="TdHeaderList">
			<td align="center">STT</td>
			<td>Ngày yêu cầu</td>
			<td>Ngày Giải trình</td>
			<td>Người giải trình</td>
			<td>File đính kèm</td>
			<td align="center">Chọn</td>
		</tr>
		<logic:present name="dsYCGiaiTrinh">
			<logic:iterate id="yeucauGT" name="dsYCGiaiTrinh" indexId="index">
				<tr class='row<%=(index.intValue() % 2)+1 %>'>
					<td align="center"><%=index.intValue() + 1%></td>
					<td><bean:write property="ngayLapPhieu" name="yeucauGT" format="dd/MM/yyyy" /></td>
					<td><bean:write property="thoiGianGuiGiaiTrinh" format="dd/MM/yyyy" name="yeucauGT" /></td>
					<td><bean:write property="tenNguoiGiaiTrinh" name="yeucauGT" format="dd/MM/yyyy" /></td>
					<td><A href="#" onclick="downloadBienBanChiTiet1('<bean:write name="yeucauGT"
						property='id'/>')">Xem File</A></td> 
					<td align="center"><INPUT type="radio" name="giaHan" onclick="setSelectedItem('<bean:write property="id"
						name="yeucauGT" />')"></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
</fieldset>
</logic:equal> 

<logic:equal name="type" value="ktXacMinh">
	<fieldset><legend>Kết quả tìm kiếm</legend>
	<TABLE align="center" width="100%" id="tblKtXacMinh">
		<tr class="TdHeaderList">
			<td align="center" width="10%">STT</td>
			<td align="center" width="40%">Sự việc được thẩm tra xác minh</td>
			<td align="center" width="25%">Thời gian thực hiện</td>
			<td align="center" width="25%">Địa điểm</td>
			<td align="center">Chọn</td>
		</tr>
		<logic:present name="dsKTXacMinh">
			<logic:iterate id="kiemtraXM" name="dsKTXacMinh" indexId="index">
				<tr class='row<%=(index.intValue() % 2)+1 %>'>
					<td align="center"><%=index.intValue() + 1%></td>
					<td><A href="#" onclick="window.open('kiem_tra_xac_minh.do?method=view&id=' + '<bean:write property="id"
							name="kiemtraXM" />')"><bean:write property="suViecDuocKtxm" name="kiemtraXM" /></A></td>
					<td align="center"><bean:write property="thoiGian" name="kiemtraXM" format="dd/MM/yyyy" /></td>
					<td align="center"><bean:write property="diaDiem" name="kiemtraXM" /></td>
					<td align="center"><INPUT type="radio" name="kiemtraXM" onclick="setSelectedItem('<bean:write property="id"
						name="kiemtraXM" />')"></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</fieldset>
</logic:equal> 

<logic:equal name="type" value="tcGiamDinh">
	<fieldset><legend>Kết quả tìm kiếm</legend>
	<TABLE align="center" width="100%" id="tblTcGiamDinh">
		<tr class="TdHeaderList">
			<td align="center" width="10%">STT</td>
			<td align="center" width="25%">Thời gian trưng cầu giám định</td>
			<td align="center" width="75%">Nội dung trưng cầu</td>
			<td width="5%"></td>
		</tr>
		<logic:present name="dsTCGiamDinh">
			<logic:iterate id="trungcauGD" name="dsTCGiamDinh" indexId="index">
				<tr class='row<%=(index.intValue() % 2)+1 %>'>
					<td align="center" width="10%"><%=index.intValue() + 1%></td>
					<td align="center" width="25%"><bean:write property="ngayLap" name="trungcauGD" format="dd/MM/yyyy" /></td>
					<td align="center" width="75%"><bean:write property="noiDung" name="trungcauGD" /></td>
					<td align="center"><INPUT type="radio" name="trungcauGD" onclick="setSelectedItem('<bean:write property="id" name="trungcauGD" />')"></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</fieldset>
</logic:equal> <logic:equal name="type" value="bgHsVv">
	<fieldset><legend>Kết quả tìm kiếm</legend>
	<TABLE align="center" width="100%" id="tblBanGiaoHSVV">
		<tr class="TdHeaderList">
			<td align="center" width="10%">STT</td>
			<td align="center" width="25%">Ngày lập phiếu</td>
			<td align="center" width="20%">Nơi lập</td>
			<td align="center" width="20%">Ngày nhận</td>
			<td align="center" width="20%">Nơi nhận</td>
			<td align="center">Chọn</td>
		</tr>
		<logic:present name="dsBGHoSoVuViec">
			<logic:iterate id="bangiaoHSVV" name="dsBGHoSoVuViec" indexId="index">
				<tr class='row<%=(index.intValue() % 2)+1 %>'>
					<td align="center" width="10%"><%=index.intValue() + 1%></td>
					<td align="center" width="25%"><bean:write property="thoiGian" name="bangiaoHSVV" format="dd/MM/yyyy" /></td>
					<td align="center" width="20%"><bean:write property="diaDiemLapHs" name="bangiaoHSVV" /></td>
					<td align="center" width="20%"><bean:write property="thoiGianGiaoNhan" name="bangiaoHSVV" format="dd/MM/yyyy" /></td>
					<td align="center" width="20%"><bean:write property="diaDiem" name="bangiaoHSVV" /></td>
					<td align="center"><INPUT type="radio" name="bangiaoHSVV" onclick="setSelectedItem('<bean:write property="id" name="bangiaoHSVV" />')"></td>
				</tr>
			</logic:iterate>
		</logic:present>    
	</table>
	</fieldset>
</logic:equal> <logic:equal name="type" value="giaHan">
	<fieldset>
	<TABLE align="center" width="100%" id="tblGiaHan">
		<tr class="TdHeaderList">
			<td>Số quyết định</td>
			<td>Ngày lập phiếu</td>
			<td>Nơi lập phiếu</td>
			<td>Ngày phê duyệt</td>
			<td>Thời gian gia hạn</td>
			<td align="center">Chọn</td>
		</tr>
		<logic:iterate id="giaHan" name="dsGiaHan" indexId="index">
			<tr class='row<%=(index.intValue() % 2)+1 %>'>
				<td><A href="#" onclick="window.open('gia_han.do?id='+'<bean:write property="id"name="giaHan" />').focus();"> <bean:write property="soQd" name="giaHan" /> </A></td>
				<td><bean:write property="ngayTrinh" name="giaHan" format="dd/MM/yyyy" /></td>
				<td><bean:write property="noiTrinh" name="giaHan" /></td>
				<td><bean:write property="ngayPheDuyet" name="giaHan" format="dd/MM/yyyy" /></td>
				<td><bean:write property="soNgayGiaHan" name="giaHan" /> Ngày</td>
				<td align="center"><INPUT type="radio" name="giaHan" onclick="setSelectedItem('<bean:write property="id"
						name="giaHan" />', '<bean:write property="soQd" name="giaHan" />')"></td>
			</tr>
		</logic:iterate>
	</table>
	</fieldset>
</logic:equal> <logic:equal name="type" value="kkTS">
	<fieldset><legend>Kết quả tìm kiếm</legend>
	<TABLE align="center" width="100%" id="tblKiemKe">
		<tr class="TdHeaderList">
			<td align="center" width="4%">STT</td>
			<td align="center" width="13%">Nơi ra quyết định</td>
			<td align="center" width="14%">Ngày ra quyết định</td>
			<td align="center" width="14%">Ngày tiến hành</td>
			<td align="center" width="25%">Đơn vị tiến hành</td>
			<td align="center" width="25%">Đơn vị cá nhân bảo quản</td>
			<td align="center">Chọn</td>
		</tr>
		<logic:present name="dsKkTs">
			<logic:iterate id="kkTS" name="dsKkTs" indexId="index">
				<tr class='row<%=(index.intValue() % 2)+1 %>'>
					<td align="center" width="4%"><%=index.intValue() + 1%></td>
					<td><A href="#" onclick="window.open('kiem_ke.do?method=view&id='+'<bean:write property="id"name="kkTS" />').focus();"> <bean:write property="noiRaQd" name="kkTS" /> </A></td>
					<td align="center" width="14%"><bean:write property="ngayRaQd" name="kkTS" format="dd/MM/yyyy" /></td>
					<td align="center" width="14%"><bean:write property="thoiGianKk" format="dd/MM/yyyy" name="kkTS" /></td>
					<td align="center" width="25%"><bean:write property="dviCnhanDuocKk" name="kkTS" /></td>
					<td align="center" width="25%"><bean:write property="dviCnhanDuocGiaoBaoQuan" name="kkTS" /></td>
					<td align="center"><INPUT type="radio" name="kkTS" onclick="setSelectedItem('<bean:write property="id"
						name="kkTS" />')"></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</TABLE>
	</fieldset>
</logic:equal> <logic:equal name="type" value="phucTra">
	<fieldset><legend>Kết quả tìm kiếm</legend>
	<TABLE align="center" width="100%" id="phucTra">
		<tr class="TdHeaderList">
			<td align="center">STT</td>
			<td align="center">Nơi lập tờ trình</td>
			<td align="center">Ngày lập tờ trình</td>
			<td align="center">Quyết định TTKT</td>
			<td align="center">Phúc tra tại</td>
			<td align="center">Chọn</td>
		</tr>
		<logic:present name="dsPhucTra">
			<logic:iterate id="pT" name="dsPhucTra" indexId="index">
				<tr class='row<%=(index.intValue() % 2)+1 %>'>
					<td align="center"><%=index.intValue() + 1%></td>
					<td><A href="#" onclick="window.open('phuc_tra.do?method=view&id='+'<bean:write property="id"name="pT" />').focus();"> <bean:write property="noiTrinh" name="pT" /> </A></td>
					<td align="center"><bean:write property="ngayTrinh" name="pT" format="dd/MM/yyyy" /></td>
					<td align="center"><bean:write property="soQdTtktCanPhucTra" name="pT" /></td>
					<td align="center"><bean:write property="tenCqtCanPhucTra" name="pT" /></td>
					<td align="center"><INPUT type="radio" name="pT" onclick="setSelectedItem('<bean:write property="id"
						name="pT" />', '<bean:write property="soQdTtktCanPhucTra" name="pT" />')"></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</fieldset>
</logic:equal>
<fieldset style="margin-top: 10px; padding: 10px">
<DIV style="text-align: center;"><INPUT type="button" value="Thêm mới " class="button" style="width: auto" onclick="addNew()" id="them_moi"> <INPUT type="button" value="Sửa" class="button" style="width: auto" onclick="edit()" id="sua"> <INPUT type="button"
	value="Xóa " class="button" style="width: auto" onclick="del()" id="xoa"> <INPUT type="button" value="Đóng" class="button" style="width: auto" onclick="window.close()"></DIV>
</fieldset>
<script language="javascript">
var selectedId;
var soQd;

var tblThaydoiTvd;
var tblYeucaucungcapHSTL;
var tblKiemKe;
var tblNiemPhongHSTL;
var tblBienBanLamViecTT;
var tblGiaHan;
var tblYeuCauGiaiTrinh;
var phucTra;
var tblKtXacMinh;
var tblTcGiamDinh;
var tblBanGiaoHSVV;

function setSelectedItem(p_selectedId, p_soQd){
	selectedId = p_selectedId;
	soQd = p_soQd;
}
var cuocTtktId
var type
var feedback
window.onload = function(){
	cuocTtktId = getUrlParam("cuocTtktId");
	cuocTtktId  = '<%=request.getAttribute("idCuocTtkt")%>';
}
function downloadBienBanChiTiet1(bbchiTietId){
	downLoadWinDow = window.open('UploadAction.do?method=downLoadYeuCauGiaiTrinh&ma_file='+bbchiTietId);
	downLoadWinDow.focus();
}
function getAction(type){
	if(type == "phucTra")
		return "phuc_tra";
	else if(type == "giaHan")
		return "gia_han";
	else if(type == "thayDoiThanhVienDoan")
		return "thay_doi_thanh_vien_doan";
	else if(type == "yeucaucungcapHSTL")
		return "yeu_cau_cung_cap_tai_lieu";
	else if(type == "bienBanLamViecTrongQTTienHanh")
		return "bien_ban_lam_viec";
	else if(type == "yeuCauGiaiTrinh")
		return "yeu_cau_giai_trinh";
	else if(type == "kkTS")
		return "kiem_ke";
	//else if(type == "kktXacMinh")
	else if(type == "ktXacMinh")
		return "kiem_tra_xac_minh";
	else if(type == "tcGiamDinh")
		return "trung_cau_giam_dinh";
	else if(type == "bgHsVv")
		return "ban_giao_ho_so_vu_viec";
	else if(type == "niemPhongHSTL")
		return "niem_phong_ho_so_tai_lieu";
}
function edit(){	
	if(type == "giaHan" || type == "thayDoiThanhVienDoan"){
		if(!isEmpty(soQd)){
			alert('Đã có quyết định, không thể sửa!');
			return;
		}
	}
	if(type == "giaHan"){
		tblGiaHan = new TableObjectExtra('tblGiaHan', false);
		if(tblGiaHan.getNumOfSelectedRow()==0){		
		alert('Bạn chưa chọn bản ghi nào!');
		return;
		}else{
		window.open(getAction(type)+ '.do?id='+selectedId+'&method=edit').focus();	
		return;	
		}
	}
	if(type == "thayDoiThanhVienDoan"){
		tblThaydoiTvd = new TableObjectExtra('tdTvd', false);
		if(tblThaydoiTvd.getNumOfSelectedRow()==0){		
		alert('Bạn chưa chọn bản ghi nào!');
		return;
		}
	}
	if(type == "yeucaucungcapHSTL"){
		tblYeucaucungcapHSTL = new TableObjectExtra('tblYeucaucungcapHSTL', false);
		if(tblYeucaucungcapHSTL.getNumOfSelectedRow()==0){		
		alert('Bạn chưa chọn bản ghi nào!');
		return;
		}
	}
	if(type == "yeuCauGiaiTrinh"){
		tblYeuCauGiaiTrinh = new TableObjectExtra('tblYeuCauGiaiTrinh', false);
		if(tblYeuCauGiaiTrinh.getNumOfSelectedRow()==0){		
		alert('Bạn chưa chọn bản ghi nào!');
		return;
		}
	}
	if(type == "bienBanLamViecTrongQTTienHanh"){
		tblBienBanLamViecTT = new TableObjectExtra('tblBienBanLamViecTT', false);
		if(tblBienBanLamViecTT.getNumOfSelectedRow()==0){		
		alert('Bạn chưa chọn bản ghi nào!');
		return;
		}
	}
	if(type == "kkTS"){
		tblKiemKe = new TableObjectExtra('tblKiemKe', false);
		if(tblKiemKe.getNumOfSelectedRow()==0){		
		alert('Bạn chưa chọn bản ghi nào!');
		return;
		}
	}
	if(type == "tcGiamDinh"){
		tblTcGiamDinh = new TableObjectExtra('tblTcGiamDinh', false);
		if(tblTcGiamDinh.getNumOfSelectedRow()==0){		
		alert('Bạn chưa chọn bản ghi nào!');
		return;
		}
	}
	if(type == "ktXacMinh"){
		tblKtXacMinh = new TableObjectExtra('tblKtXacMinh', false);
		if(tblKtXacMinh.getNumOfSelectedRow()==0){		
		alert('Bạn chưa chọn bản ghi nào!');
		return;
		}
	}
	if(type == "phucTra"){
		phucTra = new TableObjectExtra('phucTra', false);
		if(phucTra.getNumOfSelectedRow()==0){		
		alert('Bạn chưa chọn bản ghi nào!');
		return;
		}
	}
	if(type == "bgHsVv"){
		tblBanGiaoHSVV = new TableObjectExtra('tblBanGiaoHSVV', false);
		if(tblBanGiaoHSVV.getNumOfSelectedRow()==0){		
		alert('Bạn chưa chọn bản ghi nào!');
		return;
		}
	}
	if(type == "niemPhongHSTL"){
		tblNiemPhongHSTL = new TableObjectExtra('tblNiemPhongHSTL', false);
		if(tblNiemPhongHSTL.getNumOfSelectedRow()==0){		
		alert('Bạn chưa chọn bản ghi nào!');
		return;
		}
	}
	window.open(getAction(type)+ '.do?id='+selectedId).focus();		
}
function addNew(){
	
	if(type == "thayDoiThanhVienDoan"){
		if(!isApproveAllTvd()){			
			alert('Không thể thêm mới do tồn tại thay đổi thành viên đoàn chưa được duyệt!');
				return;
		}
		
	}
	window.open(getAction(type) + '.do?method=addnew&idCuocTtkt='+cuocTtktId).focus();		
}
function isApproveAllTvd(){
	tblRows = document.getElementById('tdTvd').rows;
	for(var i = 1; i< tblRows.length; i++){
		if(isEmpty(tblRows[i].cells[0].childNodes[0].innerHTML))
			return false;
	}
	return true;
}
function del(){
	if(!isEmpty(soQd)){
		alert('Đã có quyết định, không thể xóa!');
		return;
	}
	
	var xmlHttpReq = false;
	
		
		if (window.XMLHttpRequest) {
		        xmlHttpReq = new XMLHttpRequest(); 
		    }
		    else if (window.ActiveXObject) {
		        xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
		    } 
		    xmlHttpReq.open("POST", "danh_sach_tim_kiem.do?id="+selectedId+"&idCuocTtkt="+cuocTtktId+"&type="+type+"&act=delete", true); 
		    xmlHttpReq.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=UTF-8");
		    xmlHttpReq.onreadystatechange = function() {
		    	if (xmlHttpReq.readyState==4 && xmlHttpReq.status==200){
					var saveStatus = xmlHttpReq.responseText;
				  	if(saveStatus == 'cucsess')
				  	alert('Xóa thành công ');				
				  	window.location.reload();				  	
				}		    	
		    }
		    xmlHttpReq.send();
}
</script>
<logic:present name="readOnly">
	<script language="javascript">
		$("#them_moi").attr("disabled","true");
		$("#sua").attr("disabled","true");
		$("#xoa").attr("disabled","true");
	</script>
</logic:present>
