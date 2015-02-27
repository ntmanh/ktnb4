package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

import cmc.com.ktnb.util.Formater;

/**
 * KntcBaoCao entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class KntcChuyenCqDieuTra extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {

	// Fields
	private String maPhieu;

	private String maHoSo;

	private String soCongVanChuyen;

	private Date ngayBanHanh;

	private String soNguoi;

	private String taiLieu;

	private String soThongBaoKhoiTo;

	private Date ngayBanHanhKhoiTo;

	private String soDoiTuongKhoiTo;

	private Date ngayTrinhBoTruongKy;

	private Date ngayBoTruongKy;

	private String ykienBoTruong;

	private Date ngayTrinhThuTruong;

	private Date ngayThuTruongKy;

	private String ykienThuTruong;

	private String trangThai;
	
	private String daKhoiTo;

	private String ngayBanHanhStr, ngayBanHanhKhoiToStr, ngayTrinhBoTruongKyStr, ngayBoTruongKyStr, ngayThuTruongKyStr, ngayTrinhThuTruongStr;

	// Constructors

	/** default constructor */
	public KntcChuyenCqDieuTra() {
	}

	/** minimal constructor */
	public KntcChuyenCqDieuTra(String maPhieu) {
		this.maPhieu = maPhieu;
	}

	/** full constructor */
	public KntcChuyenCqDieuTra(String maPhieu, String maHoSo, String soCongVanChuyen, Date ngayBanHanh, String soNguoi, String taiLieu, String soThongBaoKhoiTo, Date ngayBanHanhKhoiTo,
			String soDoiTuongKhoiTo, Date ngayTrinhBoTruongKy, Date ngayBoTruongKy, String ykienBoTruong, Date ngayTrinhThuTruong, Date ngayThuTruongKy, String ykienThuTruong, String trangThai,
			String ngayBanHanhStr, String ngayBanHanhKhoiToStr, String ngayTrinhBoTruongKyStr, String ngayBoTruongKyStr, String ngayTrinhThuTruongStr, String ngayThuTruongKyStr, String daKhoiTo) {
		this.maPhieu = maPhieu;
		this.maHoSo = maHoSo;
		this.soCongVanChuyen = soCongVanChuyen;
		this.ngayBanHanh = ngayBanHanh;
		this.soNguoi = soNguoi;
		this.taiLieu = taiLieu;
		this.soThongBaoKhoiTo = soThongBaoKhoiTo;
		this.ngayBanHanhKhoiTo = ngayBanHanhKhoiTo;
		this.soDoiTuongKhoiTo = soDoiTuongKhoiTo;
		this.ngayTrinhBoTruongKy = ngayTrinhBoTruongKy;
		this.ngayBoTruongKy = ngayBoTruongKy;
		this.ykienBoTruong = ykienBoTruong;
		this.ngayTrinhThuTruong = ngayTrinhThuTruong;
		this.ngayThuTruongKy = ngayThuTruongKy;
		this.ykienThuTruong = ykienThuTruong;
		this.trangThai = trangThai;
		this.ngayBanHanhStr = ngayBanHanhStr;
		this.ngayBanHanhKhoiToStr = ngayBanHanhKhoiToStr;
		this.ngayTrinhBoTruongKyStr = ngayTrinhBoTruongKyStr;
		this.ngayBoTruongKyStr = ngayBoTruongKyStr;
		this.ngayTrinhThuTruongStr = ngayTrinhThuTruongStr;
		this.ngayThuTruongKyStr = ngayThuTruongKyStr;
		this.daKhoiTo=daKhoiTo;
	}

	// Property accessors
	public String getMaHoSo() {
		return maHoSo;
	}

	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}

	public String getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}

	public Date getNgayBanHanh() {
		return ngayBanHanh;
	}

	public void setNgayBanHanh(Date ngayBanHanh) {
		this.ngayBanHanh = ngayBanHanh;
		this.ngayBanHanhStr = Formater.date2str(this.ngayBanHanh);
	}

	public Date getNgayBanHanhKhoiTo() {
		return ngayBanHanhKhoiTo;
	}

	public void setNgayBanHanhKhoiTo(Date ngayBanHanhKhoiTo) {
		this.ngayBanHanhKhoiTo = ngayBanHanhKhoiTo;
		this.ngayBanHanhKhoiToStr = Formater.date2str(this.ngayBanHanhKhoiTo);
	}

	public Date getNgayBoTruongKy() {
		return ngayBoTruongKy;
	}

	public void setNgayBoTruongKy(Date ngayBoTruongKy) {
		this.ngayBoTruongKy = ngayBoTruongKy;
		this.ngayBoTruongKyStr = Formater.date2str(ngayBoTruongKy);
	}

	public Date getNgayThuTruongKy() {
		return ngayThuTruongKy;
	}

	public void setNgayThuTruongKy(Date ngayThuTruongKy) {
		this.ngayThuTruongKy = ngayThuTruongKy;
		this.ngayThuTruongKyStr = Formater.date2str(ngayThuTruongKy);
	}

	public Date getNgayTrinhBoTruongKy() {
		return ngayTrinhBoTruongKy;
	}

	public void setNgayTrinhBoTruongKy(Date ngayTrinhBoTruongKy) {
		this.ngayTrinhBoTruongKy = ngayTrinhBoTruongKy;
		this.ngayTrinhBoTruongKyStr = Formater.date2str(this.ngayTrinhBoTruongKy);
	}

	public Date getNgayTrinhThuTruong() {
		return ngayTrinhThuTruong;
	}

	public void setNgayTrinhThuTruong(Date ngayTrinhThuTruong) {
		this.ngayTrinhThuTruong = ngayTrinhThuTruong;
		this.ngayTrinhThuTruongStr = Formater.date2str(this.ngayTrinhThuTruong);
	}

	public String getSoCongVanChuyen() {
		return soCongVanChuyen;
	}

	public void setSoCongVanChuyen(String soCongVanChuyen) {
		this.soCongVanChuyen = soCongVanChuyen;
	}

	public String getSoDoiTuongKhoiTo() {
		return soDoiTuongKhoiTo;
	}

	public void setSoDoiTuongKhoiTo(String soDoiTuongKhoiTo) {
		this.soDoiTuongKhoiTo = soDoiTuongKhoiTo;
	}

	public String getSoNguoi() {
		return soNguoi;
	}

	public void setSoNguoi(String soNguoi) {
		this.soNguoi = soNguoi;
	}

	public String getSoThongBaoKhoiTo() {
		return soThongBaoKhoiTo;
	}

	public void setSoThongBaoKhoiTo(String soThongBaoKhoiTo) {
		this.soThongBaoKhoiTo = soThongBaoKhoiTo;
	}

	public String getTaiLieu() {
		return taiLieu;
	}

	public void setTaiLieu(String taiLieu) {
		this.taiLieu = taiLieu;
	}

	public String getYkienBoTruong() {
		return ykienBoTruong;
	}

	public void setYkienBoTruong(String ykienBoTruong) {
		this.ykienBoTruong = ykienBoTruong;
	}

	public String getYkienThuTruong() {
		return ykienThuTruong;
	}

	public void setYkienThuTruong(String ykienThuTruong) {
		this.ykienThuTruong = ykienThuTruong;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getNgayBanHanhKhoiToStr() {
		return ngayBanHanhKhoiToStr;
	}

	public void setNgayBanHanhKhoiToStr(String ngayBanHanhKhoiToStr) throws Exception {
		this.ngayBanHanhKhoiToStr = ngayBanHanhKhoiToStr;
		this.ngayBanHanhKhoiTo = Formater.str2date(this.ngayBanHanhKhoiToStr);
	}

	public String getNgayBanHanhStr() {
		return ngayBanHanhStr;
	}

	public void setNgayBanHanhStr(String ngayBanHanhStr) throws Exception {
		this.ngayBanHanhStr = ngayBanHanhStr;
		this.ngayBanHanh = Formater.str2date(this.ngayBanHanhStr);
	}

	public String getNgayBoTruongKyStr() {
		return ngayBoTruongKyStr;
	}

	public void setNgayBoTruongKyStr(String ngayBoTruongKyStr) throws Exception {
		this.ngayBoTruongKyStr = ngayBoTruongKyStr;
		this.ngayBoTruongKy = Formater.str2date(this.ngayBoTruongKyStr);
	}

	public String getNgayThuTruongKyStr() {
		return ngayThuTruongKyStr;
	}

	public void setNgayThuTruongKyStr(String ngayThuTruongKyStr) throws Exception {
		this.ngayThuTruongKyStr = ngayThuTruongKyStr;
		this.ngayThuTruongKy = Formater.str2date(ngayThuTruongKyStr);
	}

	public String getNgayTrinhBoTruongKyStr() {
		return ngayTrinhBoTruongKyStr;
	}

	public void setNgayTrinhBoTruongKyStr(String ngayTrinhBoTruongKyStr) throws Exception {
		this.ngayTrinhBoTruongKyStr = ngayTrinhBoTruongKyStr;
		this.ngayTrinhBoTruongKy = Formater.str2date(this.ngayTrinhBoTruongKyStr);
	}

	public String getNgayTrinhThuTruongStr() {
		return ngayTrinhThuTruongStr;
	}

	public void setNgayTrinhThuTruongStr(String ngayTrinhThuTruongStr) throws Exception {
		this.ngayTrinhThuTruongStr = ngayTrinhThuTruongStr;
		this.ngayTrinhThuTruong = Formater.str2date(ngayTrinhThuTruongStr);
	}

	public String getDaKhoiTo() {
		return daKhoiTo;
	}

	public void setDaKhoiTo(String daKhoiTo) {
		this.daKhoiTo = daKhoiTo;
	}

}