package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KntcPhieuHdNkn entity. @author MyEclipse Persistence Tools
 */

public class KntcPhieuHdNkn extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {

	// Fields    
	private String ma;
	private String maPhieu;
	private String maHs;
	private String diaDiem;
	private Date ngayLap;
	private String maCqt;
	private String congVanSo;
	private Date congVanNgay;
	private Date ngayTrinhKy;
	private Date ngayKy;
	private String YKienTrinh;
	private Date ngayTrinhDuyet;
	private Date ngayDuyet;
	private String YKienDuyet;
	private String cqtGqTen;
	private String cqtGqMa;
	// Constructors

	/** default constructor */
	public KntcPhieuHdNkn() {
	}

	/** minimal constructor */
	public KntcPhieuHdNkn(String maPhieu, String maHs) {
		this.maPhieu = maPhieu;
		this.maHs = maHs;
	}
	public String getMaPhieu() {
		return this.maPhieu;
	}

	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}

	public String getMaHs() {
		return this.maHs;
	}

	public void setMaHs(String maHs) {
		this.maHs = maHs;
	}

	public String getDiaDiem() {
		return this.diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public Date getNgayLap() {
		return this.ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getMaCqt() {
		return this.maCqt;
	}

	public void setMaCqt(String maCqt) {
		this.maCqt = maCqt;
	}

	public String getCongVanSo() {
		return this.congVanSo;
	}

	public void setCongVanSo(String congVanSo) {
		this.congVanSo = congVanSo;
	}

	public Date getCongVanNgay() {
		return this.congVanNgay;
	}

	public void setCongVanNgay(Date congVanNgay) {
		this.congVanNgay = congVanNgay;
	}

	/**
	 * @return
	 */
	public String getMa() {
		return ma;
	}

	/**
	 * @param string
	 */
	public void setMa(String string) {
		ma = string;
	}

	/**
	 * @return
	 */
	public Date getNgayDuyet() {
		return ngayDuyet;
	}

	/**
	 * @return
	 */
	public Date getNgayKy() {
		return ngayKy;
	}

	/**
	 * @return
	 */
	public Date getNgayTrinhDuyet() {
		return ngayTrinhDuyet;
	}

	/**
	 * @return
	 */
	public Date getNgayTrinhKy() {
		return ngayTrinhKy;
	}

	/**
	 * @return
	 */
	public String getYKienDuyet() {
		return YKienDuyet;
	}

	/**
	 * @return
	 */
	public String getYKienTrinh() {
		return YKienTrinh;
	}

	/**
	 * @param date
	 */
	public void setNgayDuyet(Date date) {
		ngayDuyet = date;
	}

	/**
	 * @param date
	 */
	public void setNgayKy(Date date) {
		ngayKy = date;
	}

	/**
	 * @param date
	 */
	public void setNgayTrinhDuyet(Date date) {
		ngayTrinhDuyet = date;
	}

	/**
	 * @param date
	 */
	public void setNgayTrinhKy(Date date) {
		ngayTrinhKy = date;
	}

	/**
	 * @param string
	 */
	public void setYKienDuyet(String string) {
		YKienDuyet = string;
	}

	/**
	 * @param string
	 */
	public void setYKienTrinh(String string) {
		YKienTrinh = string;
	}

	/**
	 * @return
	 */
	public String getCqtGqMa() {
		return cqtGqMa;
	}

	/**
	 * @return
	 */
	public String getCqtGqTen() {
		return cqtGqTen;
	}

	/**
	 * @param string
	 */
	public void setCqtGqMa(String string) {
		cqtGqMa = string;
	}

	/**
	 * @param string
	 */
	public void setCqtGqTen(String string) {
		cqtGqTen = string;
	}

}