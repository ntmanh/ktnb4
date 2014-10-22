package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

import cmc.com.ktnb.util.Formater;

public class KntcQdTamDinhChiKn extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
//	Fields    
	private String id;
	private String soHs;
	private String soQd;
	private Date ngayBanHanh;
	private String diaDiem;
	private String canCuVanBan;
	private String nguoiDeNghi;
	private String nguoiBhQdTen;
	private String nguoiBhQdChucVu;
	private String qdDinhChiTen;
	private String lyDo;
	private String donViBhQd;
	private String donViThiHanh;
	private String donViLienQuan;
	private String ngayBanHanhstr;

	// Constructors

	/** default constructor */
	public KntcQdTamDinhChiKn() {
	}

	/** minimal constructor */
	public KntcQdTamDinhChiKn(String id) {
		this.id = id;
	}

	/** full constructor */
	public KntcQdTamDinhChiKn(String id, String soHs, String soQd, Date ngayBanHanh, String diaDiem, String canCuVanBan, String nguoiDeNghi, String nguoiBhQdTen, String nguoiBhQdChucVu,
			String qdDinhChiTen, String lyDo, String donViBhQd, String donViThiHanh, String donViLienQuan) {
		this.id = id;
		this.soHs = soHs;
		this.soQd = soQd;
		this.ngayBanHanh = ngayBanHanh;
		this.diaDiem = diaDiem;
		this.canCuVanBan = canCuVanBan;
		this.nguoiDeNghi = nguoiDeNghi;
		this.nguoiBhQdTen = nguoiBhQdTen;
		this.nguoiBhQdChucVu = nguoiBhQdChucVu;
		this.qdDinhChiTen = qdDinhChiTen;
		this.lyDo = lyDo;
		this.donViBhQd = donViBhQd;
		this.donViThiHanh = donViThiHanh;
		this.donViLienQuan=donViLienQuan;
	}
	// Property accessors

	public String getCanCuVanBan() {
		return canCuVanBan;
	}

	public void setCanCuVanBan(String canCuVanBan) {
		this.canCuVanBan = canCuVanBan;
	}

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

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public Date getNgayBanHanh() {
		return ngayBanHanh;
	}

	public void setNgayBanHanh(Date ngayBanHanh) {
		this.ngayBanHanh = ngayBanHanh;
		this.ngayBanHanhstr=Formater.date2str(this.ngayBanHanh);
	}

	public String getDonViBhQd() {
		return donViBhQd;
	}

	public void setDonViBhQd(String donViBhQd) {
		this.donViBhQd = donViBhQd;
	}

	public String getNguoiBhQdChucVu() {
		return nguoiBhQdChucVu;
	}

	public void setNguoiBhQdChucVu(String nguoiBhQdChucVu) {
		this.nguoiBhQdChucVu = nguoiBhQdChucVu;
	}

	public String getNguoiBhQdTen() {
		return nguoiBhQdTen;
	}

	public void setNguoiBhQdTen(String nguoiBhQdTen) {
		this.nguoiBhQdTen = nguoiBhQdTen;
	}

	public String getNguoiDeNghi() {
		return nguoiDeNghi;
	}

	public void setNguoiDeNghi(String nguoiDeNghi) {
		this.nguoiDeNghi = nguoiDeNghi;
	}
	
	public String getQdDinhChiTen() {
		return qdDinhChiTen;
	}

	public void setQdDinhChiTen(String qdDinhChiTen) {
		this.qdDinhChiTen = qdDinhChiTen;
	}

	public String getSoHs() {
		return soHs;
	}

	public void setSoHs(String soHs) {
		this.soHs = soHs;
	}

	public String getSoQd() {
		return soQd;
	}

	public void setSoQd(String soQd) {
		this.soQd = soQd;
	}

	public String getNgayBanHanhstr() {
		return ngayBanHanhstr;
	}

	public void setNgayBanHanhstr(String ngayBanHanhstr) throws Exception {
		this.ngayBanHanhstr = ngayBanHanhstr;
		this.ngayBanHanh=Formater.str2date(this.ngayBanHanhstr);
	}
	
}
