package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KntcBienBan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class KntcBienBan extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {

	/*Mau 12*/
	public static final String BB_CONG_BO_QDXM_KN = "BB_CONG_BO_QDXM_KN";
	public static final String BB_CONG_BO_QDXM_TC = "BB_CONG_BO_QDXM_TC";
	public static final String BB_LAM_VIEC_NGUOI_KN0 = "BB_LAM_VIEC_NGUOI_KN0";
	public static final String BB_LAM_VIEC_NGUOI_KN = "BB_LAM_VIEC_NGUOI_KN";
	public static final String BB_LAM_VIEC_NGUOI_BI_KN = "BB_LAM_VIEC_NGUOI_BI_KN";
	public static final String BB_LAM_VIEC_NGUOI_TC0 = "BB_LAM_VIEC_NGUOI_TC0";
	public static final String BB_LAM_VIEC_NGUOI_TC = "BB_LAM_VIEC_NGUOI_TC";
	public static final String BB_LAM_VIEC_NGUOI_BI_TC = "BB_LAM_VIEC_NGUOI_BI_TC";
	public static final String BB_DOI_THOAI = "BB_DOI_THOAI";
	public static final String BB_DOI_THOAI_KN = "BB_DOI_THOAI_KN";
	public static final String BB_LAM_VIEC_YEU_CAU_CCTL = "BB_LAM_VIEC_YEU_CAU_CCTL";
	public static final String BB_LAM_VIEC_YEU_CAU_CCTLTC = "BB_LAM_VIEC_YEU_CAU_CCTLTC";
	public static final String BB_THONG_BAO_DU_THAO_GQTC = "BB_THONG_BAO_DU_THAO_GQTC";
	/*end Mau 12*/
	public static final String BB_CHUYEN_DIEU_TRA_TC = "25B/KNTC";
	// Fields
	private KntcBienBanId id;

	private Date thoiDiem;

	private String diaDiem;

	private Long soBenLviec;

	private String noiDung;

	private Long soBanIn;

	private Long soBangChung;

	private Date thoiDiemHoanThanh;

	private Long soTrangTl;

	private Date ngayCapNhat;

	private String nguoiCapNhat;

	private String maCqt;

	private String loaiBienBan, thanhPhan,daiDien;

	// private Long lanTd;
	// Constructors

	/** default constructor */
	public KntcBienBan() {
	}

	/** minimal constructor */
	public KntcBienBan(KntcBienBanId id) {
		this.id = id;
	}

	/** full constructor */
	public KntcBienBan(KntcBienBanId id, Date thoiDiem, String diaDiem, Long soBenLviec, String noiDung, Long soBanIn, Date ngayCapNhat, String nguoiCapNhat, String maCqt, Long soBangChung,
			Date thoiDiemHoanThanh, Long soTrangTl) {
		this.id = id;
		this.thoiDiem = thoiDiem;
		this.diaDiem = diaDiem;
		this.soBenLviec = soBenLviec;
		this.noiDung = noiDung;
		this.soBanIn = soBanIn;
		this.ngayCapNhat = ngayCapNhat;
		this.nguoiCapNhat = nguoiCapNhat;
		this.maCqt = maCqt;
		this.soBangChung = soBangChung;
		this.thoiDiemHoanThanh = thoiDiemHoanThanh;
		this.soTrangTl = soTrangTl;
	}

	// Property accessors

	public KntcBienBanId getId() {
		return this.id;
	}

	public void setId(KntcBienBanId id) {
		this.id = id;
	}

	public Date getThoiDiem() {
		return this.thoiDiem;
	}

	public void setThoiDiem(Date thoiDiem) {
		this.thoiDiem = thoiDiem;
	}

	public String getDiaDiem() {
		return this.diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public Long getSoBenLviec() {
		return this.soBenLviec;
	}

	public void setSoBenLviec(Long soBenLviec) {
		this.soBenLviec = soBenLviec;
	}

	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Long getSoBanIn() {
		return this.soBanIn;
	}

	public void setSoBanIn(Long soBanIn) {
		this.soBanIn = soBanIn;
	}

	public Date getNgayCapNhat() {
		return this.ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public String getNguoiCapNhat() {
		return this.nguoiCapNhat;
	}

	public void setNguoiCapNhat(String nguoiCapNhat) {
		this.nguoiCapNhat = nguoiCapNhat;
	}

	public String getMaCqt() {
		return this.maCqt;
	}

	public void setMaCqt(String maCqt) {
		this.maCqt = maCqt;
	}

	public Long getSoBangChung() {
		return this.soBangChung;
	}

	public void setSoBangChung(Long soBangChung) {
		this.soBangChung = soBangChung;
	}

	public Date getThoiDiemHoanThanh() {
		return this.thoiDiemHoanThanh;
	}

	public void setThoiDiemHoanThanh(Date thoiDiemHoanThanh) {
		this.thoiDiemHoanThanh = thoiDiemHoanThanh;
	}

	public Long getSoTrangTl() {
		return this.soTrangTl;
	}

	public void setSoTrangTl(Long soTrangTl) {
		this.soTrangTl = soTrangTl;
	}

	/**
	 * @return
	 */
	public String getLoaiBienBan() {
		return loaiBienBan;
	}

	/**
	 * @param string
	 */
	public void setLoaiBienBan(String string) {
		loaiBienBan = string;
	}

	/**
	 * @return
	 */
	// public Long getLanTd() {
	// return lanTd;
	// }
	//
	// /**
	// * @param long1
	// */
	// public void setLanTd(Long long1) {
	// lanTd = long1;
	// }
	public String getThanhPhan() {
		return thanhPhan;
	}

	public void setThanhPhan(String thanhPhan) {
		this.thanhPhan = thanhPhan;
	}

	public String getDaiDien() {
		return daiDien;
	}

	public void setDaiDien(String daiDien) {
		this.daiDien = daiDien;
	}

}