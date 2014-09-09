package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KtnbThamSo entity. @author MyEclipse Persistence Tools
 */

public class KtnbThamSo extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements
		java.io.Serializable {

	// Fields

	private String ten;
	private String giaTri;
	private String kieuDlieu;
	private String ghiChu;
	private String capNhat;
	private Date startDate;
	private Date endDate;

	// Constructors

	/** default constructor */
	public KtnbThamSo() {
	}

	/** minimal constructor */
	public KtnbThamSo(String ten) {
		this.ten = ten;
	}

	/** full constructor */
	public KtnbThamSo(String ten, String giaTri, String kieuDlieu,
			String ghiChu, String capNhat, Date startDate, Date endDate) {
		this.ten = ten;
		this.giaTri = giaTri;
		this.kieuDlieu = kieuDlieu;
		this.ghiChu = ghiChu;
		this.capNhat = capNhat;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	// Property accessors

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getGiaTri() {
		return this.giaTri;
	}

	public void setGiaTri(String giaTri) {
		this.giaTri = giaTri;
	}

	public String getKieuDlieu() {
		return this.kieuDlieu;
	}

	public void setKieuDlieu(String kieuDlieu) {
		this.kieuDlieu = kieuDlieu;
	}

	public String getGhiChu() {
		return this.ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getCapNhat() {
		return this.capNhat;
	}

	public void setCapNhat(String capNhat) {
		this.capNhat = capNhat;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}