package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

import cmc.com.ktnb.util.Formater;

public class KntcBbDoiThoai extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
	//Fields    
	private String id;

	private String diaDiem;

	private Date thoiGianBatDau;

	private Date thoiGianKetThuc;

	private String nguoiGqMa;

	private String nguoiGqTen;

	private String nguoiGqChucVu;

	private String nguoiGqCoQuan;

	private String nguoiGhiBbTen;

	private String nguoiGhiBbChucVu;

	private String nguoiGhiBbCoQuan;

	private String nguoiLqTen;

	private String nguoiLqCmt;

	private String nguoiLqCmtNoiCap;

	private Date nguoiLqCmtNgay;

	private String daiDienTen;

	private String daiDienDiaChi;

	private String noiDung;

	private String ketQua;
	private String soQD;

	private String thoiGianBatDauStr,thoiGianKetThucStr,nguoiLqCmtNgayStr;

	// Constructors

	/** default constructor */
	public KntcBbDoiThoai() {
	}

	/** minimal constructor */
	public KntcBbDoiThoai(String id) {
		this.id = id;
	}

	/** full constructor */
	public KntcBbDoiThoai(String id, String diaDiem, Date thoiGianBatDau, Date thoiGianKetThuc, String nguoiGqMa, String nguoiGqTen, String nguoiGqChucVu, String nguoiGqCoQuan, String nguoiGhiBbTen,
			String nguoiGhiBbChucVu, String nguoiGhiBbCoQuan, String nguoiLqTen, String nguoiLqCmt, String nguoiLqCmtNoiCap, Date nguoiLqCmtNgay, String daiDienTen, String daiDienDiaChi,
			String noiDung, String ketQua,String soQD) {
		this.id = id;
		this.diaDiem = diaDiem;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.nguoiGqMa = nguoiGqMa;
		this.nguoiGqTen = nguoiGqTen;
		this.nguoiGqChucVu = nguoiGqChucVu;
		this.nguoiGqCoQuan = nguoiGqCoQuan;
		this.nguoiGhiBbTen = nguoiGhiBbTen;
		this.nguoiGhiBbChucVu = nguoiGhiBbChucVu;
		this.nguoiGhiBbCoQuan = nguoiGhiBbCoQuan;
		this.nguoiLqTen = nguoiLqTen;
		this.nguoiLqCmt = nguoiLqCmt;
		this.nguoiLqCmtNoiCap = nguoiLqCmtNoiCap;
		this.nguoiLqCmtNgay = nguoiLqCmtNgay;
		this.nguoiLqCmtNoiCap = nguoiLqCmtNoiCap;
		this.daiDienTen = daiDienTen;
		this.daiDienDiaChi = daiDienDiaChi;
		this.noiDung = noiDung;
		this.ketQua = ketQua;
		this.soQD=soQD;
	}

	public String getDaiDienDiaChi() {
		return daiDienDiaChi;
	}

	public void setDaiDienDiaChi(String daiDienDiaChi) {
		this.daiDienDiaChi = daiDienDiaChi;
	}

	public String getDaiDienTen() {
		return daiDienTen;
	}

	public void setDaiDienTen(String daiDienTen) {
		this.daiDienTen = daiDienTen;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKetQua() {
		return ketQua;
	}

	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}

	public String getNguoiGhiBbChucVu() {
		return nguoiGhiBbChucVu;
	}

	public void setNguoiGhiBbChucVu(String nguoiGhiBbChucVu) {
		this.nguoiGhiBbChucVu = nguoiGhiBbChucVu;
	}

	public String getNguoiGhiBbCoQuan() {
		return nguoiGhiBbCoQuan;
	}

	public void setNguoiGhiBbCoQuan(String nguoiGhiBbCoQuan) {
		this.nguoiGhiBbCoQuan = nguoiGhiBbCoQuan;
	}

	public String getNguoiGhiBbTen() {
		return nguoiGhiBbTen;
	}

	public void setNguoiGhiBbTen(String nguoiGhiBbTen) {
		this.nguoiGhiBbTen = nguoiGhiBbTen;
	}

	public String getNguoiGqChucVu() {
		return nguoiGqChucVu;
	}

	public void setNguoiGqChucVu(String nguoiGqChucVu) {
		this.nguoiGqChucVu = nguoiGqChucVu;
	}

	public String getNguoiGqCoQuan() {
		return nguoiGqCoQuan;
	}

	public void setNguoiGqCoQuan(String nguoiGqCoQuan) {
		this.nguoiGqCoQuan = nguoiGqCoQuan;
	}

	public String getNguoiGqMa() {
		return nguoiGqMa;
	}

	public void setNguoiGqMa(String nguoiGqMa) {
		this.nguoiGqMa = nguoiGqMa;
	}

	public String getNguoiGqTen() {
		return nguoiGqTen;
	}

	public void setNguoiGqTen(String nguoiGqTen) {
		this.nguoiGqTen = nguoiGqTen;
	}

	public String getNguoiLqCmt() {
		return nguoiLqCmt;
	}

	public void setNguoiLqCmt(String nguoiLqCmt) {
		this.nguoiLqCmt = nguoiLqCmt;
	}

	public Date getNguoiLqCmtNgay() {
		return nguoiLqCmtNgay;
	}

	public void setNguoiLqCmtNgay(Date nguoiLqCmtNgay) {
		this.nguoiLqCmtNgay = nguoiLqCmtNgay;
		this.nguoiLqCmtNgayStr=Formater.date2str(nguoiLqCmtNgay);
	}

	public String getNguoiLqCmtNoiCap() {
		return nguoiLqCmtNoiCap;
	}

	public void setNguoiLqCmtNoiCap(String nguoiLqCmtNoiCap) {
		this.nguoiLqCmtNoiCap = nguoiLqCmtNoiCap;
	}

	public String getNguoiLqTen() {
		return nguoiLqTen;
	}

	public void setNguoiLqTen(String nguoiLqTen) {
		this.nguoiLqTen = nguoiLqTen;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Date getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Date thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianBatDauStr=Formater.date2strDateTimeForNV(thoiGianBatDau);
	}

	public Date getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.thoiGianKetThucStr=Formater.date2strDateTimeForNV(thoiGianKetThuc);
	}

	public String getSoQD() {
		return soQD;
	}

	public void setSoQD(String soQD) {
		this.soQD = soQD;
	}

	public String getThoiGianBatDauStr() {
		return thoiGianBatDauStr;
	}

	public void setThoiGianBatDauStr(String thoiGianBatDauStr) throws Exception {
		this.thoiGianBatDauStr = thoiGianBatDauStr;
		this.thoiGianBatDau=Formater.str2dateForNV(thoiGianBatDauStr);
	}

	public String getThoiGianKetThucStr() {
		return thoiGianKetThucStr;
	}

	public void setThoiGianKetThucStr(String thoiGianKetThucStr) throws Exception {
		this.thoiGianKetThucStr = thoiGianKetThucStr;
		this.thoiGianKetThuc=Formater.str2dateForNV(thoiGianKetThucStr);
	}

	public String getNguoiLqCmtNgayStr() {
		return nguoiLqCmtNgayStr;
	}

	public void setNguoiLqCmtNgayStr(String nguoiLqCmtNgayStr) throws Exception {
		this.nguoiLqCmtNgayStr = nguoiLqCmtNgayStr;
		this.nguoiLqCmtNgay=Formater.str2date(nguoiLqCmtNgayStr);
	}
	

	// Property accessors
}
