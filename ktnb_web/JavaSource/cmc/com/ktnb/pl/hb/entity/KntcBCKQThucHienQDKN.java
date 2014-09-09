package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KntcBaoCao entity. @author MyEclipse Persistence Tools
 */

public class KntcBCKQThucHienQDKN extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {

	// Fields
	private String ma;

	private String maHs;

	private String maCqt;

	private Long soTienKnghiThuHoi;

	private Long taiSanKhacKnghiThuHoi;

	private Long soTienTraCdan;

	private Long taiSanKhacTraCdan;

	private Long soNknHoanTra;

	private Long soTienHoanTraNkn;

	private Long soNguoiXlhc;

	private Long chuyenCquanDtra;

	private Long ketThucTdoiThiHanh;

	private Date ngayNhanBckq;

	private Date ngayCapNhat;

	private String nguoiCapNhat;

	private Long soMinhOan;

	private Long soNguoiChuyenCqDtra;

	private Long loaiKntc;

	public KntcBCKQThucHienQDKN() {
		// TODO Auto-generated constructor stub
	}

	public Long getChuyenCquanDtra() {
		return chuyenCquanDtra;
	}

	public void setChuyenCquanDtra(Long chuyenCquanDtra) {
		this.chuyenCquanDtra = chuyenCquanDtra;
	}

	public Long getKetThucTdoiThiHanh() {
		return ketThucTdoiThiHanh;
	}

	public void setKetThucTdoiThiHanh(Long ketThucTdoiThiHanh) {
		this.ketThucTdoiThiHanh = ketThucTdoiThiHanh;
	}

	public Long getLoaiKntc() {
		return loaiKntc;
	}

	public void setLoaiKntc(Long loaiKntc) {
		this.loaiKntc = loaiKntc;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getMaCqt() {
		return maCqt;
	}

	public void setMaCqt(String maCqt) {
		this.maCqt = maCqt;
	}

	public String getMaHs() {
		return maHs;
	}

	public void setMaHs(String maHs) {
		this.maHs = maHs;
	}

	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public Date getNgayNhanBckq() {
		return ngayNhanBckq;
	}

	public void setNgayNhanBckq(Date ngayNhanBckq) {
		this.ngayNhanBckq = ngayNhanBckq;
	}

	public String getNguoiCapNhat() {
		return nguoiCapNhat;
	}

	public void setNguoiCapNhat(String nguoiCapNhat) {
		this.nguoiCapNhat = nguoiCapNhat;
	}

	public Long getSoMinhOan() {
		return soMinhOan;
	}

	public void setSoMinhOan(Long soMinhOan) {
		this.soMinhOan = soMinhOan;
	}

	public Long getSoNguoiChuyenCqDtra() {
		return soNguoiChuyenCqDtra;
	}

	public void setSoNguoiChuyenCqDtra(Long soNguoiChuyenCqDtra) {
		this.soNguoiChuyenCqDtra = soNguoiChuyenCqDtra;
	}

	public Long getSoNguoiXlhc() {
		return soNguoiXlhc;
	}

	public void setSoNguoiXlhc(Long soNguoiXlhc) {
		this.soNguoiXlhc = soNguoiXlhc;
	}

	public Long getSoNknHoanTra() {
		return soNknHoanTra;
	}

	public void setSoNknHoanTra(Long soNknHoanTra) {
		this.soNknHoanTra = soNknHoanTra;
	}

	public Long getSoTienHoanTraNkn() {
		return soTienHoanTraNkn;
	}

	public void setSoTienHoanTraNkn(Long soTienHoanTraNkn) {
		this.soTienHoanTraNkn = soTienHoanTraNkn;
	}

	public Long getSoTienKnghiThuHoi() {
		return soTienKnghiThuHoi;
	}

	public void setSoTienKnghiThuHoi(Long soTienKnghiThuHoi) {
		this.soTienKnghiThuHoi = soTienKnghiThuHoi;
	}

	public Long getSoTienTraCdan() {
		return soTienTraCdan;
	}

	public void setSoTienTraCdan(Long soTienTraCdan) {
		this.soTienTraCdan = soTienTraCdan;
	}

	public Long getTaiSanKhacKnghiThuHoi() {
		return taiSanKhacKnghiThuHoi;
	}

	public void setTaiSanKhacKnghiThuHoi(Long taiSanKhacKnghiThuHoi) {
		this.taiSanKhacKnghiThuHoi = taiSanKhacKnghiThuHoi;
	}

	public Long getTaiSanKhacTraCdan() {
		return taiSanKhacTraCdan;
	}

	public void setTaiSanKhacTraCdan(Long taiSanKhacTraCdan) {
		this.taiSanKhacTraCdan = taiSanKhacTraCdan;
	}	
	
}