package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

import cmc.com.ktnb.util.Formater;

public class KntcQdHuyTamDinhChiKN extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
	// Fields
	private String id;

	private String soHoSo;

	private String soQd;

	private Date ngayBanHanh;

	private String diaDiem;

	private String vanBanCanCu;

	private String nguoiDeNghi;

	private String nguoiBhHuyTen;

	private String nguoiBhChucVu;

	private String tenQdHuy;

	private String lyDoHuy;

	private String nguoiBhQdHcTen;

	private String nguoiBhQdHcCvu;

	private String donViThiHanh;

	private String donViLienQuan;
	private String ngayBanHanhstr;

	// Constructors

	/** default constructor */
	public KntcQdHuyTamDinhChiKN() {
	}

	/** minimal constructor */
	public KntcQdHuyTamDinhChiKN(String id) {
		this.id = id;
	}

	/** full constructor */
	public KntcQdHuyTamDinhChiKN(String id, String soHoSo, String soQd, Date ngayBanHanh, String diaDiem, String vanBanCanCu, String nguoiDeNghi, String nguoiBhHuyTen, String nguoiBhChucVu,
			String tenQdHuy, String lyDoHuy, String nguoiBhQdHcTen, String nguoiBhQdHcCvu, String donViThiHanh, String donViLienQuan) {
		this.id = id;
		this.soHoSo = soHoSo;
		this.soQd = soQd;
		this.ngayBanHanh = ngayBanHanh;
		this.diaDiem = diaDiem;
		this.vanBanCanCu = vanBanCanCu;
		this.nguoiDeNghi = nguoiDeNghi;
		this.nguoiBhHuyTen = nguoiBhHuyTen;
		this.nguoiBhChucVu = nguoiBhChucVu;
		this.tenQdHuy = tenQdHuy;
		this.lyDoHuy = lyDoHuy;
		this.nguoiBhQdHcTen = nguoiBhQdHcTen;
		this.nguoiBhQdHcCvu = nguoiBhQdHcCvu;
		this.donViThiHanh = donViThiHanh;
		this.donViLienQuan = donViLienQuan;
	}

	// Property accessors

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getDonViLienQuan() {
		return donViLienQuan;
	}

	public void setDonViLienQuan(String donViLienQuan) {
		this.donViLienQuan = donViLienQuan;
	}

	public String getDonViThiHanh() {
		return donViThiHanh;
	}

	public void setDonViThiHanh(String donViThiHanh) {
		this.donViThiHanh = donViThiHanh;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLyDoHuy() {
		return lyDoHuy;
	}

	public void setLyDoHuy(String lyDoHuy) {
		this.lyDoHuy = lyDoHuy;
	}

	public Date getNgayBanHanh() {
		return ngayBanHanh;
	}

	public void setNgayBanHanh(Date ngayBanHanh) {
		this.ngayBanHanh = ngayBanHanh;
		this.ngayBanHanhstr=Formater.date2str(ngayBanHanh);
	}

	public String getNguoiBhChucVu() {
		return nguoiBhChucVu;
	}

	public void setNguoiBhChucVu(String nguoiBhChucVu) {
		this.nguoiBhChucVu = nguoiBhChucVu;
	}

	public String getNguoiBhHuyTen() {
		return nguoiBhHuyTen;
	}

	public void setNguoiBhHuyTen(String nguoiBhHuyTen) {
		this.nguoiBhHuyTen = nguoiBhHuyTen;
	}

	public String getNguoiBhQdHcCvu() {
		return nguoiBhQdHcCvu;
	}

	public void setNguoiBhQdHcCvu(String nguoiBhQdHcCvu) {
		this.nguoiBhQdHcCvu = nguoiBhQdHcCvu;
	}

	public String getNguoiBhQdHcTen() {
		return nguoiBhQdHcTen;
	}

	public void setNguoiBhQdHcTen(String nguoiBhQdHcTen) {
		this.nguoiBhQdHcTen = nguoiBhQdHcTen;
	}

	public String getNguoiDeNghi() {
		return nguoiDeNghi;
	}

	public void setNguoiDeNghi(String nguoiDeNghi) {
		this.nguoiDeNghi = nguoiDeNghi;
	}

	public String getSoHoSo() {
		return soHoSo;
	}

	public void setSoHoSo(String soHoSo) {
		this.soHoSo = soHoSo;
	}

	public String getSoQd() {
		return soQd;
	}

	public void setSoQd(String soQd) {
		this.soQd = soQd;
	}

	public String getTenQdHuy() {
		return tenQdHuy;
	}

	public void setTenQdHuy(String tenQdHuy) {
		this.tenQdHuy = tenQdHuy;
	}

	public String getVanBanCanCu() {
		return vanBanCanCu;
	}

	public void setVanBanCanCu(String vanBanCanCu) {
		this.vanBanCanCu = vanBanCanCu;
	}

	public String getNgayBanHanhstr() {
		return ngayBanHanhstr;
	}

	public void setNgayBanHanhstr(String ngayBanHanhstr) throws Exception {
		this.ngayBanHanhstr = ngayBanHanhstr;
		this.ngayBanHanh=Formater.str2date(ngayBanHanhstr);
	}

}
