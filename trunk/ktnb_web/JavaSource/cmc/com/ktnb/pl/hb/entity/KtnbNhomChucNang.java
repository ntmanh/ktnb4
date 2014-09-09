package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KtnbNhomChucNang entity. @author MyEclipse Persistence Tools
 */

public class KtnbNhomChucNang extends cmc.com.ktnb.pl.hb.entity.PersistentObject
		implements java.io.Serializable {

	// Fields

	private KtnbNhomChucNangId id;
	private String quyen;
	private Date startDate;
	private Date endDate;

	// Constructors

	/** default constructor */
	public KtnbNhomChucNang() {
	}

	/** minimal constructor */
	public KtnbNhomChucNang(KtnbNhomChucNangId id) {
		this.id = id;
	}

	/** full constructor */
	public KtnbNhomChucNang(KtnbNhomChucNangId id, Date startDate, Date endDate) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	// Property accessors

	public KtnbNhomChucNangId getId() {
		return this.id;
	}

	public void setId(KtnbNhomChucNangId id) {
		this.id = id;
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

	/**
	 * @return
	 */
	public String getQuyen() {
		return quyen;
	}

	/**
	 * @param string
	 */
	public void setQuyen(String string) {
		quyen = string;
	}

}