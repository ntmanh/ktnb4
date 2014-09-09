package cmc.com.ktnb.web.ttkt.ket_thuc_ttkt.form;

import org.apache.struts.upload.FormFile;

import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.web.BaseActionForm;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */

public class KetThucTtktForm extends BaseActionForm {
	// Thong tin chung
	private String idDonViTienHanh;

	// Thong bao ket thuc
	private String idCuocTtkt;
	private String noiRaThongBaoKetThuc;
	private String ngayRaThongBaoKetThuc;
	private String ngayKetThuc;
	private String hanKetThuc;

	// Du thao ket qua
	private String idDuThaoKetQua;
	private FormFile fileDuThaoKetQua;
	
	

	// Ket qua
	private String idKetQua;
	private FormFile fileKetQua;
	private String ngayGuiBaoCaoKetQuaVaDuThaoKetLuan;
	

	// Du thao ket luan
	private String idDuThaoKetLuan;
	private FormFile fileDuThaoKetLuan;
	private String ngayRaKetLuan;

	// Ket luan
	private String idKetLuan;
	private FormFile fileKetLuan;

	//	Hop rut kinh nghiem
	private String idBienBanHopRutKinhNghiem;
	private String loaiBienBanHopRutKinhNghiem;
	private String thoiDiemBatDauHopRutKinhNghiem;
	private String thoiDiemKetThucHopRutKinhNghiem;
	private String diaDiemHopRutKinhNghiem;
	private String noiDungHopRutKinhNghiem;
	private String veViecHopRutKinhNghiem;
	
	private TtktCmThanhPhanThamDu[] thanhPhanThamDuHopRutKinhNghiem;

	// Ban giao ho so luu tru
	private String idBanGiaoHoSoLuuTru;
	private String baoCaoBanGianHoSoLuuTru;
	private String hoSoBanGianHoSoLuuTru;
	private String idDaiDienBenGiaoBanGianHoSoLuuTru;
	private String idDaiDienBenNhanBanGianHoSoLuuTru;
	private String loaiBanGianHoSoLuuTru;
	private String thoiDiemBatDauBanGianHoSoLuuTru;
	private String thoiDiemKetThucBanGianHoSoLuuTru;
	private String diaDiemBanGiaoHoSoLuuTru;
	private TtktCmThanhPhanThamDu[] arrDaiDienBenGiaoHstlLuuTru;
	private TtktCmThanhPhanThamDu[] arrDaiDienBenNhanHstlLuuTru;

	// Chuyen du lieu sang bao cao
	private String idChuyenDuLieuSangBc;
	private String saiPhamTienMat;
	private String saiPhamKhac;
	private FormFile kienNghiCuaDoan;
	private String thuHoiTienMat;
	private String thuHoiKhac;
	private String daThuHoiTienMat;
	private String daThuHoiKhac;
	private String kienNghiKhac;
	private String soNguoiBiKienNghiXuLy;
	private String soCchucThueBiXlyHchinh;
	private String soDtuongKhacBiXlyHchinh;
	private String soNguoiChuyenCqDieuTra;
	private String soVuChuyenCqDieuTra;
	
	private String soNguoiDaXly;
	private String kiemDiemRutKn;
	private String khienTrach;
	private String canhCao;
	private String haBacLuong;
	private String giangChuc;
	private String cachChuc;
	private String buocThoiViec;
	private String xlyHinhSuCoAn;
	private String kiemTraSauTtkt;
	private String tienDaThuHoiSauTtkt;
	private String soDvSaiPham;
	private String chuaXuLy;
	private String soKlQdDaKt;
	private String ketThucNhapLieu;
	
	// Ket luan chuyen sang bao cao
	private String dcID;
	private String dcSoDonViTTKT;
	private String dcSoDonViSaiPham;
	private String dcTSTienThuCongChucThue;
	private String dcTSTienTraCongChucThue;
	private String dcTSTienThuNguoiNopThue;
	private String dcTSTienTraNguoiNopThue;
	private String dcSoTienThuCongChucThue;
	private String dcSoTienNopCongChucTHue;
	private String dcSoTienThuNguoiNopThue;
	private String dcSoTienNopNguoiNopThue;
	private String dcXuLiHanhChinhCongVienChucThue;
	private String dcXuLiHanhChinhDoiTuongKhac;
	private String dcXLHSSoVuViec;
	private String dcXLHSDoiTuongKhac;
	private String dcXLHSSoNguoi;
	private String dcSoSDBS_VPBQ;
	private String dcSoSDBC_QTQC;
	private String dcSoTTKTThue;
	private String dcKienNghiKhac;
	private String dcMoTa,soKetLuan;
	private String dcKiemTraSauTTKT;
	private String dcTsKlTtktQdxlDaKtra;
	private String dcTsTienThuHtraSpKhac;
	private String dcSoTienKnghiThuHtraSpKhac;
	private String dcSoTienThuDoiTuongKhac;
	private String dcSoTienNopDoiTuongKhac;
	
	// Ket qua thuc hien ket luan
	private String idKqThucHienKl;
	private String soDviDuocTtkt;
	private String soDviSaiPham;
	private String tienPhaiThuCongChucThue;
	private String tienHoanTraCongChucThue;
	private String tienPhaiThuNguoiNopThue;
	private String tienHoanTraNguoiNopThue;
	private String soKiemDiem;
	private String soHaBacLuong;
	private String soKhienTrach;
	private String soThoiViec;
	private String soCanhCao;
	private String soSdbsVbpq;
	private String soSdbsQtqc;
	private String soTtktThue;
	private String tienPhaiThuTtktThue;
	private String tienHoanTraTtktThue;
	private String ngayNhanBckq;
	private String soTienThuHtraSpKhac;
	private String soGiangChuc;
	private String soCachChuc;
	private String soKhac;
	private String soXlhsCoAn;
	private boolean ketThucTdoiThanh;
	private FormFile baoCaoKqDinhKem;
	private String idNguoiCapNhat;
	private String tenNguoiCapNhap;
	private String ngayCapNhat;
	private String soTienDaThuHauKiem;

	public String getSoDvSaiPham() {
		return soDvSaiPham;
	}

	public void setSoDvSaiPham(String soDvSaiPham) {
		this.soDvSaiPham = soDvSaiPham;
	}

	public String getSoNguoiChuyenCqDieuTra() {
		return soNguoiChuyenCqDieuTra;
	}

	public void setSoNguoiChuyenCqDieuTra(String soNguoiChuyenCqDieuTra) {
		this.soNguoiChuyenCqDieuTra = soNguoiChuyenCqDieuTra;
	}

	public String getSoVuChuyenCqDieuTra() {
		return soVuChuyenCqDieuTra;
	}

	public void setSoVuChuyenCqDieuTra(String soVuChuyenCqDieuTra) {
		this.soVuChuyenCqDieuTra = soVuChuyenCqDieuTra;
	}

	/**
	 * @return
	 */
	public FormFile getFileDuThaoKetLuan() {
		return fileDuThaoKetLuan;
	}

	/**
	 * @return
	 */
	public FormFile getFileDuThaoKetQua() {
		return fileDuThaoKetQua;
	}

	/**
	 * @return
	 */
	public FormFile getFileKetLuan() {
		return fileKetLuan;
	}

	/**
	 * @return
	 */
	public FormFile getFileKetQua() {
		return fileKetQua;
	}

	

	/**
	 * @return
	 */
	public String getIdCuocTtkt() {
		return idCuocTtkt;
	}

	/**
	 * @return
	 */
	public String getIdDuThaoKetLuan() {
		return idDuThaoKetLuan;
	}

	/**
	 * @return
	 */
	public String getIdDuThaoKetQua() {
		return idDuThaoKetQua;
	}

	/**
	 * @return
	 */
	public String getIdKetLuan() {
		return idKetLuan;
	}

	/**
	 * @return
	 */
	public String getIdKetQua() {
		return idKetQua;
	}

	

	/**
	 * @return
	 */
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}

	/**
	 * @return
	 */
	public String getNgayRaThongBaoKetThuc() {
		return ngayRaThongBaoKetThuc;
	}

	
	/**
	 * @return
	 */
	public String getNoiRaThongBaoKetThuc() {
		return noiRaThongBaoKetThuc;
	}

	
	

	/**
	 * @param file
	 */
	public void setFileDuThaoKetLuan(FormFile file) {
		fileDuThaoKetLuan = file;
	}

	/**
	 * @param file
	 */
	public void setFileDuThaoKetQua(FormFile file) {
		fileDuThaoKetQua = file;
	}

	/**
	 * @param file
	 */
	public void setFileKetLuan(FormFile file) {
		fileKetLuan = file;
	}

	/**
	 * @param file
	 */
	public void setFileKetQua(FormFile file) {
		fileKetQua = file;
	}

	

	/**
	 * @param string
	 */
	public void setIdCuocTtkt(String string) {
		idCuocTtkt = string;
	}

	/**
	 * @param string
	 */
	public void setIdDuThaoKetLuan(String string) {
		idDuThaoKetLuan = string;
	}

	/**
	 * @param string
	 */
	public void setIdDuThaoKetQua(String string) {
		idDuThaoKetQua = string;
	}

	/**
	 * @param string
	 */
	public void setIdKetLuan(String string) {
		idKetLuan = string;
	}

	/**
	 * @param string
	 */
	public void setIdKetQua(String string) {
		idKetQua = string;
	}


	/**
	 * @param string
	 */
	public void setNgayKetThuc(String string) {
		ngayKetThuc = string;
	}

	/**
	 * @param string
	 */
	public void setNgayRaThongBaoKetThuc(String string) {
		ngayRaThongBaoKetThuc = string;
	}

	

	/**
	 * @param string
	 */
	public void setNoiRaThongBaoKetThuc(String string) {
		noiRaThongBaoKetThuc = string;
	}


	
	/**
	 * @return
	 */
	public String getBaoCaoBanGianHoSoLuuTru() {
		return baoCaoBanGianHoSoLuuTru;
	}

	

	/**
	 * @return
	 */
	public String getDaThuHoiKhac() {
		return daThuHoiKhac;
	}

	/**
	 * @return
	 */
	public String getDaThuHoiTienMat() {
		return daThuHoiTienMat;
	}

	/**
	 * @return
	 */
	public String getHoSoBanGianHoSoLuuTru() {
		return hoSoBanGianHoSoLuuTru;
	}

	/**
	 * @return
	 */
	public String getIdBanGiaoHoSoLuuTru() {
		return idBanGiaoHoSoLuuTru;
	}

	/**
	 * @return
	 */
	public String getIdChuyenDuLieuSangBc() {
		return idChuyenDuLieuSangBc;
	}

	/**
	 * @return
	 */
	public String getIdDaiDienBenGiaoBanGianHoSoLuuTru() {
		return idDaiDienBenGiaoBanGianHoSoLuuTru;
	}

	/**
	 * @return
	 */
	public String getIdDaiDienBenNhanBanGianHoSoLuuTru() {
		return idDaiDienBenNhanBanGianHoSoLuuTru;
	}

	/**
	 * @return
	 */
	public FormFile getKienNghiCuaDoan() {
		return kienNghiCuaDoan;
	}

	/**
	 * @return
	 */
	public String getKienNghiKhac() {
		return kienNghiKhac;
	}

	/**
	 * @return
	 */
	public String getSaiPhamKhac() {
		return saiPhamKhac;
	}

	/**
	 * @return
	 */
	public String getSaiPhamTienMat() {
		return saiPhamTienMat;
	}

	/**
	 * @return
	 */
	public String getSoCchucThueBiXlyHchinh() {
		return soCchucThueBiXlyHchinh;
	}

	/**
	 * @return
	 */
	public String getSoDtuongKhacBiXlyHchinh() {
		return soDtuongKhacBiXlyHchinh;
	}

	/**
	 * @return
	 */
	public String getSoNguoiBiKienNghiXuLy() {
		return soNguoiBiKienNghiXuLy;
	}

	/**
	 * @return
	 */
	public String getThoiDiemBatDauBanGianHoSoLuuTru() {
		return thoiDiemBatDauBanGianHoSoLuuTru;
	}

	/**
	 * @return
	 */
	public String getThoiDiemKetThucBanGianHoSoLuuTru() {
		return thoiDiemKetThucBanGianHoSoLuuTru;
	}

	/**
	 * @return
	 */
	public String getThuHoiKhac() {
		return thuHoiKhac;
	}

	/**
	 * @return
	 */
	public String getThuHoiTienMat() {
		return thuHoiTienMat;
	}

	/**
	 * @param string
	 */
	public void setBaoCaoBanGianHoSoLuuTru(String string) {
		baoCaoBanGianHoSoLuuTru = string;
	}

	

	/**
	 * @param string
	 */
	public void setDaThuHoiKhac(String string) {
		daThuHoiKhac = string;
	}

	/**
	 * @param string
	 */
	public void setDaThuHoiTienMat(String string) {
		daThuHoiTienMat = string;
	}

	/**
	 * @param string
	 */
	public void setHoSoBanGianHoSoLuuTru(String string) {
		hoSoBanGianHoSoLuuTru = string;
	}

	/**
	 * @param string
	 */
	public void setIdBanGiaoHoSoLuuTru(String string) {
		idBanGiaoHoSoLuuTru = string;
	}

	/**
	 * @param string
	 */
	public void setIdChuyenDuLieuSangBc(String string) {
		idChuyenDuLieuSangBc = string;
	}

	/**
	 * @param string
	 */
	public void setIdDaiDienBenGiaoBanGianHoSoLuuTru(String string) {
		idDaiDienBenGiaoBanGianHoSoLuuTru = string;
	}

	/**
	 * @param string
	 */
	public void setIdDaiDienBenNhanBanGianHoSoLuuTru(String string) {
		idDaiDienBenNhanBanGianHoSoLuuTru = string;
	}

	/**
	 * @param string
	 */
	public void setKienNghiCuaDoan(FormFile string) {
		kienNghiCuaDoan = string;
	}

	/**
	 * @param string
	 */
	public void setKienNghiKhac(String string) {
		kienNghiKhac = string;
	}

	/**
	 * @param string
	 */
	public void setSaiPhamKhac(String string) {
		saiPhamKhac = string;
	}

	/**
	 * @param string
	 */
	public void setSaiPhamTienMat(String string) {
		saiPhamTienMat = string;
	}

	/**
	 * @param string
	 */
	public void setSoCchucThueBiXlyHchinh(String string) {
		soCchucThueBiXlyHchinh = string;
	}

	/**
	 * @param string
	 */
	public void setSoDtuongKhacBiXlyHchinh(String string) {
		soDtuongKhacBiXlyHchinh = string;
	}

	/**
	 * @param string
	 */
	public void setSoNguoiBiKienNghiXuLy(String string) {
		soNguoiBiKienNghiXuLy = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemBatDauBanGianHoSoLuuTru(String string) {
		thoiDiemBatDauBanGianHoSoLuuTru = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemKetThucBanGianHoSoLuuTru(String string) {
		thoiDiemKetThucBanGianHoSoLuuTru = string;
	}

	/**
	 * @param string
	 */
	public void setThuHoiKhac(String string) {
		thuHoiKhac = string;
	}

	/**
	 * @param string
	 */
	public void setThuHoiTienMat(String string) {
		thuHoiTienMat = string;
	}

	/**
	 * @return
	 */
	public String getDiaDiemBanGiaoHoSoLuuTru() {
		return diaDiemBanGiaoHoSoLuuTru;
	}

	/**
	 * @param string
	 */
	public void setDiaDiemBanGiaoHoSoLuuTru(String string) {
		diaDiemBanGiaoHoSoLuuTru = string;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getArrDaiDienBenGiaoHstlLuuTru() {
		return arrDaiDienBenGiaoHstlLuuTru;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getArrDaiDienBenNhanHstlLuuTru() {
		return arrDaiDienBenNhanHstlLuuTru;
	}

	/**
	 * @param dus
	 */
	public void setArrDaiDienBenGiaoHstlLuuTru(TtktCmThanhPhanThamDu[] dus) {
		arrDaiDienBenGiaoHstlLuuTru = dus;
	}

	/**
	 * @param dus
	 */
	public void setArrDaiDienBenNhanHstlLuuTru(TtktCmThanhPhanThamDu[] dus) {
		arrDaiDienBenNhanHstlLuuTru = dus;
	}

	/**
	 * @return
	 */
	public String getLoaiBanGianHoSoLuuTru() {
		return loaiBanGianHoSoLuuTru;
	}

	/**
	 * @param string
	 */
	public void setLoaiBanGianHoSoLuuTru(String string) {
		loaiBanGianHoSoLuuTru = string;
	}

	/**
	 * @return
	 */
	public String getDiaDiemHopRutKinhNghiem() {
		return diaDiemHopRutKinhNghiem;
	}

	/**
	 * @return
	 */
	public String getIdBienBanHopRutKinhNghiem() {
		return idBienBanHopRutKinhNghiem;
	}

	/**
	 * @return
	 */
	public String getLoaiBienBanHopRutKinhNghiem() {
		return loaiBienBanHopRutKinhNghiem;
	}

	/**
	 * @return
	 */
	public String getThoiDiemBatDauHopRutKinhNghiem() {
		return thoiDiemBatDauHopRutKinhNghiem;
	}

	/**
	 * @return
	 */
	public String getThoiDiemKetThucHopRutKinhNghiem() {
		return thoiDiemKetThucHopRutKinhNghiem;
	}

	
	/**
	 * @param string
	 */
	public void setDiaDiemHopRutKinhNghiem(String string) {
		diaDiemHopRutKinhNghiem = string;
	}

	/**
	 * @param string
	 */
	public void setIdBienBanHopRutKinhNghiem(String string) {
		idBienBanHopRutKinhNghiem = string;
	}

	/**
	 * @param string
	 */
	public void setLoaiBienBanHopRutKinhNghiem(String string) {
		loaiBienBanHopRutKinhNghiem = string;
	}

	

	/**
	 * @param string
	 */
	public void setThoiDiemBatDauHopRutKinhNghiem(String string) {
		thoiDiemBatDauHopRutKinhNghiem = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemKetThucHopRutKinhNghiem(String string) {
		thoiDiemKetThucHopRutKinhNghiem = string;
	}

	/**
	 * @return
	 */
	public String getVeViecHopRutKinhNghiem() {
		return veViecHopRutKinhNghiem;
	}

	/**
	 * @param string
	 */
	public void setVeViecHopRutKinhNghiem(String string) {
		veViecHopRutKinhNghiem = string;
	}

	/**
	 * @return
	 */
	public String getNoiDungHopRutKinhNghiem() {
		return noiDungHopRutKinhNghiem;
	}

	/**
	 * @param string
	 */
	public void setNoiDungHopRutKinhNghiem(String string) {
		noiDungHopRutKinhNghiem = string;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getThanhPhanThamDuHopRutKinhNghiem() {
		return thanhPhanThamDuHopRutKinhNghiem;
	}

	/**
	 * @param dus
	 */
	public void setThanhPhanThamDuHopRutKinhNghiem(TtktCmThanhPhanThamDu[] dus) {
		thanhPhanThamDuHopRutKinhNghiem = dus;
	}

	

	/**
	 * @return
	 */
	public String getIdDonViTienHanh() {
		return idDonViTienHanh;
	}

	/**
	 * @param string
	 */
	public void setIdDonViTienHanh(String string) {
		idDonViTienHanh = string;
	}

	/**
	 * @return
	 */
	public String getHanKetThuc() {
		return hanKetThuc;
	}

	/**
	 * @param string
	 */
	public void setHanKetThuc(String string) {
		hanKetThuc = string;
	}

	/**
	 * @return
	 */
	public String getNgayGuiBaoCaoKetQuaVaDuThaoKetLuan() {
		return ngayGuiBaoCaoKetQuaVaDuThaoKetLuan;
	}

	/**
	 * @param string
	 */
	public void setNgayGuiBaoCaoKetQuaVaDuThaoKetLuan(String string) {
		ngayGuiBaoCaoKetQuaVaDuThaoKetLuan = string;
	}

	
	/**
	 * @return
	 */
	public String getNgayRaKetLuan() {
		return ngayRaKetLuan;
	}

	/**
	 * @param string
	 */
	public void setNgayRaKetLuan(String string) {
		ngayRaKetLuan = string;
	}

	public String getBuocThoiViec() {
		return buocThoiViec;
	}

	public void setBuocThoiViec(String buocThoiViec) {
		this.buocThoiViec = buocThoiViec;
	}

	public String getCachChuc() {
		return cachChuc;
	}

	public void setCachChuc(String cachChuc) {
		this.cachChuc = cachChuc;
	}

	public String getCanhCao() {
		return canhCao;
	}

	public void setCanhCao(String canhCao) {
		this.canhCao = canhCao;
	}

	public String getGiangChuc() {
		return giangChuc;
	}

	public void setGiangChuc(String giangChuc) {
		this.giangChuc = giangChuc;
	}

	public String getHaBacLuong() {
		return haBacLuong;
	}

	public void setHaBacLuong(String haBacLuong) {
		this.haBacLuong = haBacLuong;
	}

	public String getKhienTrach() {
		return khienTrach;
	}

	public void setKhienTrach(String khienTrach) {
		this.khienTrach = khienTrach;
	}

	public String getKiemDiemRutKn() {
		return kiemDiemRutKn;
	}

	public void setKiemDiemRutKn(String kiemDiemRutKn) {
		this.kiemDiemRutKn = kiemDiemRutKn;
	}

	public String getKiemTraSauTtkt() {
		return kiemTraSauTtkt;
	}

	public void setKiemTraSauTtkt(String kiemTraSauTtkt) {
		this.kiemTraSauTtkt = kiemTraSauTtkt;
	}

	public String getSoNguoiDaXly() {
		return soNguoiDaXly;
	}

	public void setSoNguoiDaXly(String soNguoiDaXly) {
		this.soNguoiDaXly = soNguoiDaXly;
	}

	public String getTienDaThuHoiSauTtkt() {
		return tienDaThuHoiSauTtkt;
	}

	public void setTienDaThuHoiSauTtkt(String tienDaThuHoiSauTtkt) {
		this.tienDaThuHoiSauTtkt = tienDaThuHoiSauTtkt;
	}

	public String getXlyHinhSuCoAn() {
		return xlyHinhSuCoAn;
	}

	public void setXlyHinhSuCoAn(String xlyHinhSuCoAn) {
		this.xlyHinhSuCoAn = xlyHinhSuCoAn;
	}

	public String getChuaXuLy() {
		return chuaXuLy;
	}

	public void setChuaXuLy(String chuaXuLy) {
		this.chuaXuLy = chuaXuLy;
	}

	public String getSoKlQdDaKt() {
		return soKlQdDaKt;
	}

	public void setSoKlQdDaKt(String soKlQdDaKt) {
		this.soKlQdDaKt = soKlQdDaKt;
	}

	public String getKetThucNhapLieu() {
		return ketThucNhapLieu;
	}

	public void setKetThucNhapLieu(String ketThucNhapLieu) {
		this.ketThucNhapLieu = ketThucNhapLieu;
	}
	
	public String getDcID() {
		return dcID;
	}
	public void setDcID(String dcID) {
		this.dcID = dcID;
	}
	
	public String getDcKienNghiKhac() {
		return dcKienNghiKhac;
	}
	public void setDcKienNghiKhac(String dcKienNghiKhac) {
		this.dcKienNghiKhac = dcKienNghiKhac;
	}
	public String getDcMoTa() {
		return dcMoTa;
	}
	public void setDcMoTa(String dcMoTa) {
		this.dcMoTa = dcMoTa;
	}
	
	public String getDcSoDonViSaiPham() {
		return dcSoDonViSaiPham;
	}
	public void setDcSoDonViSaiPham(String dcSoDonViSaiPham) {
		this.dcSoDonViSaiPham = dcSoDonViSaiPham;
	}
	public String getDcSoDonViTTKT() {
		return dcSoDonViTTKT;
	}
	public void setDcSoDonViTTKT(String dcSoDonViTTKT) {
		this.dcSoDonViTTKT = dcSoDonViTTKT;
	}
	public String getDcSoSDBC_QTQC() {
		return dcSoSDBC_QTQC;
	}
	public void setDcSoSDBC_QTQC(String dcSoSDBC_QTQC) {
		this.dcSoSDBC_QTQC = dcSoSDBC_QTQC;
	}
	public String getDcSoSDBS_VPBQ() {
		return dcSoSDBS_VPBQ;
	}
	public void setDcSoSDBS_VPBQ(String dcSoSDBS_VPBQ) {
		this.dcSoSDBS_VPBQ = dcSoSDBS_VPBQ;
	}
	public String getDcSoTienNopCongChucTHue() {
		return dcSoTienNopCongChucTHue;
	}
	public void setDcSoTienNopCongChucTHue(String dcSoTienNopCongChucTHue) {
		this.dcSoTienNopCongChucTHue = dcSoTienNopCongChucTHue;
	}
	public String getDcSoTienNopNguoiNopThue() {
		return dcSoTienNopNguoiNopThue;
	}
	public void setDcSoTienNopNguoiNopThue(String dcSoTienNopNguoiNopThue) {
		this.dcSoTienNopNguoiNopThue = dcSoTienNopNguoiNopThue;
	}
	public String getDcSoTienThuCongChucThue() {
		return dcSoTienThuCongChucThue;
	}
	public void setDcSoTienThuCongChucThue(String dcSoTienThuCongChucThue) {
		this.dcSoTienThuCongChucThue = dcSoTienThuCongChucThue;
	}
	public String getDcSoTienThuNguoiNopThue() {
		return dcSoTienThuNguoiNopThue;
	}
	public void setDcSoTienThuNguoiNopThue(String dcSoTienThuNguoiNopThue) {
		this.dcSoTienThuNguoiNopThue = dcSoTienThuNguoiNopThue;
	}
	public String getDcSoTTKTThue() {
		return dcSoTTKTThue;
	}
	public void setDcSoTTKTThue(String dcSoTTKTThue) {
		this.dcSoTTKTThue = dcSoTTKTThue;
	}
	
	public String getDcTSTienThuCongChucThue() {
		return dcTSTienThuCongChucThue;
	}
	public void setDcTSTienThuCongChucThue(String dcTSTienThuCongChucThue) {
		this.dcTSTienThuCongChucThue = dcTSTienThuCongChucThue;
	}
	public String getDcTSTienThuNguoiNopThue() {
		return dcTSTienThuNguoiNopThue;
	}
	public void setDcTSTienThuNguoiNopThue(String dcTSTienThuNguoiNopThue) {
		this.dcTSTienThuNguoiNopThue = dcTSTienThuNguoiNopThue;
	}
	public String getDcTSTienTraCongChucThue() {
		return dcTSTienTraCongChucThue;
	}
	public void setDcTSTienTraCongChucThue(String dcTSTienTraCongChucThue) {
		this.dcTSTienTraCongChucThue = dcTSTienTraCongChucThue;
	}
	public String getDcTSTienTraNguoiNopThue() {
		return dcTSTienTraNguoiNopThue;
	}
	public void setDcTSTienTraNguoiNopThue(String dcTSTienTraNguoiNopThue) {
		this.dcTSTienTraNguoiNopThue = dcTSTienTraNguoiNopThue;
	}
	public String getDcXLHSDoiTuongKhac() {
		return dcXLHSDoiTuongKhac;
	}
	public void setDcXLHSDoiTuongKhac(String dcXLHSDoiTuongKhac) {
		this.dcXLHSDoiTuongKhac = dcXLHSDoiTuongKhac;
	}
	public String getDcXLHSSoNguoi() {
		return dcXLHSSoNguoi;
	}
	public void setDcXLHSSoNguoi(String dcXLHSSoNguoi) {
		this.dcXLHSSoNguoi = dcXLHSSoNguoi;
	}
	public String getDcXLHSSoVuViec() {
		return dcXLHSSoVuViec;
	}
	public void setDcXLHSSoVuViec(String dcXLHSSoVuViec) {
		this.dcXLHSSoVuViec = dcXLHSSoVuViec;
	}
	public String getDcXuLiHanhChinhCongVienChucThue() {
		return dcXuLiHanhChinhCongVienChucThue;
	}
	public void setDcXuLiHanhChinhCongVienChucThue(String dcXuLiHanhChinhCongVienChucThue) {
		this.dcXuLiHanhChinhCongVienChucThue = dcXuLiHanhChinhCongVienChucThue;
	}
	public String getDcXuLiHanhChinhDoiTuongKhac() {
		return dcXuLiHanhChinhDoiTuongKhac;
	}
	public void setDcXuLiHanhChinhDoiTuongKhac(String dcXuLiHanhChinhDoiTuongKhac) {
		this.dcXuLiHanhChinhDoiTuongKhac = dcXuLiHanhChinhDoiTuongKhac;
	}

	public String getDcSoTienKnghiThuHtraSpKhac() {
		return dcSoTienKnghiThuHtraSpKhac;
	}

	public void setDcSoTienKnghiThuHtraSpKhac(String dcSoTienKnghiThuHtraSpKhac) {
		this.dcSoTienKnghiThuHtraSpKhac = dcSoTienKnghiThuHtraSpKhac;
	}

	public String getDcTsKlTtktQdxlDaKtra() {
		return dcTsKlTtktQdxlDaKtra;
	}

	public void setDcTsKlTtktQdxlDaKtra(String dcTsKlTtktQdxlDaKtra) {
		this.dcTsKlTtktQdxlDaKtra = dcTsKlTtktQdxlDaKtra;
	}

	public String getDcTsTienThuHtraSpKhac() {
		return dcTsTienThuHtraSpKhac;
	}

	public void setDcTsTienThuHtraSpKhac(String dcTsTienThuHtraSpKhac) {
		this.dcTsTienThuHtraSpKhac = dcTsTienThuHtraSpKhac;
	}

	public String getDcKiemTraSauTTKT() {
		return dcKiemTraSauTTKT;
	}

	public void setDcKiemTraSauTTKT(String dcKiemTraSauTTKT) {
		this.dcKiemTraSauTTKT = dcKiemTraSauTTKT;
	}

	public FormFile getBaoCaoKqDinhKem() {
		return baoCaoKqDinhKem;
	}

	public void setBaoCaoKqDinhKem(FormFile file) {
		this.baoCaoKqDinhKem = file;
	}

	public String getIdKqThucHienKl() {
		return idKqThucHienKl;
	}

	public void setIdKqThucHienKl(String idKqThucHienKl) {
		this.idKqThucHienKl = idKqThucHienKl;
	}

	public String getNgayNhanBckq() {
		return ngayNhanBckq;
	}

	public void setNgayNhanBckq(String ngayNhanBckq) {
		this.ngayNhanBckq = ngayNhanBckq;
	}

	public String getSoCachChuc() {
		return soCachChuc;
	}

	public void setSoCachChuc(String soCachChuc) {
		this.soCachChuc = soCachChuc;
	}

	public String getSoCanhCao() {
		return soCanhCao;
	}

	public void setSoCanhCao(String soCanhCao) {
		this.soCanhCao = soCanhCao;
	}

	public String getSoDviDuocTtkt() {
		return soDviDuocTtkt;
	}

	public void setSoDviDuocTtkt(String soDviDuocTtkt) {
		this.soDviDuocTtkt = soDviDuocTtkt;
	}

	public String getSoDviSaiPham() {
		return soDviSaiPham;
	}

	public void setSoDviSaiPham(String soDviSaiPham) {
		this.soDviSaiPham = soDviSaiPham;
	}

	public String getSoGiangChuc() {
		return soGiangChuc;
	}

	public void setSoGiangChuc(String soGiangChuc) {
		this.soGiangChuc = soGiangChuc;
	}

	public String getSoHaBacLuong() {
		return soHaBacLuong;
	}

	public void setSoHaBacLuong(String soHaBacLuong) {
		this.soHaBacLuong = soHaBacLuong;
	}

	public String getSoKhac() {
		return soKhac;
	}

	public void setSoKhac(String soKhac) {
		this.soKhac = soKhac;
	}

	public String getSoKhienTrach() {
		return soKhienTrach;
	}

	public void setSoKhienTrach(String soKhienTrach) {
		this.soKhienTrach = soKhienTrach;
	}

	public String getSoKiemDiem() {
		return soKiemDiem;
	}

	public void setSoKiemDiem(String soKiemDiem) {
		this.soKiemDiem = soKiemDiem;
	}

	public String getSoSdbsQtqc() {
		return soSdbsQtqc;
	}

	public void setSoSdbsQtqc(String soSdbsQtqc) {
		this.soSdbsQtqc = soSdbsQtqc;
	}

	public String getSoSdbsVbpq() {
		return soSdbsVbpq;
	}

	public void setSoSdbsVbpq(String soSdbsVbpq) {
		this.soSdbsVbpq = soSdbsVbpq;
	}

	public String getSoThoiViec() {
		return soThoiViec;
	}

	public void setSoThoiViec(String soThoiViec) {
		this.soThoiViec = soThoiViec;
	}

	public String getSoTienThuHtraSpKhac() {
		return soTienThuHtraSpKhac;
	}

	public void setSoTienThuHtraSpKhac(String soTienThuHtraSpKhac) {
		this.soTienThuHtraSpKhac = soTienThuHtraSpKhac;
	}

	public String getSoTtktThue() {
		return soTtktThue;
	}

	public void setSoTtktThue(String soTtktThue) {
		this.soTtktThue = soTtktThue;
	}

	public String getSoXlhsCoAn() {
		return soXlhsCoAn;
	}

	public void setSoXlhsCoAn(String soXlhsCoAn) {
		this.soXlhsCoAn = soXlhsCoAn;
	}

	public String getTienHoanTraCongChucThue() {
		return tienHoanTraCongChucThue;
	}

	public void setTienHoanTraCongChucThue(String tienHoanTraCongChucThue) {
		this.tienHoanTraCongChucThue = tienHoanTraCongChucThue;
	}

	public String getTienHoanTraNguoiNopThue() {
		return tienHoanTraNguoiNopThue;
	}

	public void setTienHoanTraNguoiNopThue(String tienHoanTraNguoiNopThue) {
		this.tienHoanTraNguoiNopThue = tienHoanTraNguoiNopThue;
	}

	public String getTienHoanTraTtktThue() {
		return tienHoanTraTtktThue;
	}

	public void setTienHoanTraTtktThue(String tienHoanTraTtktThue) {
		this.tienHoanTraTtktThue = tienHoanTraTtktThue;
	}

	public String getTienPhaiThuCongChucThue() {
		return tienPhaiThuCongChucThue;
	}

	public void setTienPhaiThuCongChucThue(String tienPhaiThuCongChucThue) {
		this.tienPhaiThuCongChucThue = tienPhaiThuCongChucThue;
	}

	public String getTienPhaiThuNguoiNopThue() {
		return tienPhaiThuNguoiNopThue;
	}

	public void setTienPhaiThuNguoiNopThue(String tienPhaiThuNguoiNopThue) {
		this.tienPhaiThuNguoiNopThue = tienPhaiThuNguoiNopThue;
	}

	public String getTienPhaiThuTtktThue() {
		return tienPhaiThuTtktThue;
	}

	public void setTienPhaiThuTtktThue(String tienPhaiThuTtktThue) {
		this.tienPhaiThuTtktThue = tienPhaiThuTtktThue;
	}

	public boolean isKetThucTdoiThanh() {
		return ketThucTdoiThanh;
	}

	public void setKetThucTdoiThanh(boolean ketThucTdoiThanh) {
		this.ketThucTdoiThanh = ketThucTdoiThanh;
	}

	public String getIdNguoiCapNhat() {
		return idNguoiCapNhat;
	}  

	public void setIdNguoiCapNhat(String idNguoiCapNhat) {
		this.idNguoiCapNhat = idNguoiCapNhat;
	}

	public String getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(String ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public String getTenNguoiCapNhap() {
		return tenNguoiCapNhap;
	}

	public void setTenNguoiCapNhap(String tenNguoiCapNhap) {
		this.tenNguoiCapNhap = tenNguoiCapNhap;
	}

	public String getSoKetLuan() {
		return soKetLuan;
	}

	public void setSoKetLuan(String soKetLuan) {
		this.soKetLuan = soKetLuan;
	}

	public String getSoTienDaThuHauKiem() {
		return soTienDaThuHauKiem;
	}

	public void setSoTienDaThuHauKiem(String soTienDaThuHauKiem) {
		this.soTienDaThuHauKiem = soTienDaThuHauKiem;
	}
	
	public String getDcSoTienNopDoiTuongKhac() {
		return dcSoTienNopDoiTuongKhac;
	}

	public void setDcSoTienNopDoiTuongKhac(String dcSoTienNopDoiTuongKhac) {
		this.dcSoTienNopDoiTuongKhac = dcSoTienNopDoiTuongKhac;
	}

	public String getDcSoTienThuDoiTuongKhac() {
		return dcSoTienThuDoiTuongKhac;
	}

	public void setDcSoTienThuDoiTuongKhac(String dcSoTienThuDoiTuongKhac) {
		this.dcSoTienThuDoiTuongKhac = dcSoTienThuDoiTuongKhac;
	}

	private String maCuocTtkt;




	public String getMaCuocTtkt() {
		return maCuocTtkt;
	}

	public void setMaCuocTtkt(String maCuocTtkt) {
		this.maCuocTtkt = maCuocTtkt;
	}
}