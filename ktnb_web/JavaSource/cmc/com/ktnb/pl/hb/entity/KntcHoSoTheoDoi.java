package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KntcHoSoTheoDoi entity. @author MyEclipse Persistence Tools
 */

public class KntcHoSoTheoDoi extends cmc.com.ktnb.pl.hb.entity.PersistentObject
		implements java.io.Serializable {

	// Fields

	private String ma;
	private String maHs;
	private Date ngayLap;
	private String noiDung;
	private Long lanTd;
	private String nguoiLap;
	private String maCqt;

	// Constructors

	/** default constructor */
	public KntcHoSoTheoDoi() {
	}

	/** minimal constructor */
	public KntcHoSoTheoDoi(String ma) {
		this.ma = ma;
	}

	public String getMa() {
		return this.ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getMaHs() {
		return this.maHs;
	}

	public void setMaHs(String maHs) {
		this.maHs = maHs;
	}

	public Date getNgayLap() {
		return this.ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getNguoiLap() {
		return this.nguoiLap;
	}

	public void setNguoiLap(String nguoiLap) {
		this.nguoiLap = nguoiLap;
	}

	public String getMaCqt() {
		return this.maCqt;
	}

	public void setMaCqt(String maCqt) {
		this.maCqt = maCqt;
	}

	/**
	 * @return
	 */
	public Long getLanTd() {
		return lanTd;
	}

	/**
	 * @param long1
	 */
	public void setLanTd(Long long1) {
		lanTd = long1;
	}

}