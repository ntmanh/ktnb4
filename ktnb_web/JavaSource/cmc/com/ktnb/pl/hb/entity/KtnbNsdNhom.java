package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KtnbNsdNhom entity. @author MyEclipse Persistence Tools
 */

public class KtnbNsdNhom extends cmc.com.ktnb.pl.hb.entity.PersistentObject
		implements java.io.Serializable {

	// Fields

	private KtnbNsdNhomId id;
	private Date ngayHluc;
	private Date ngayHetHluc;

	// Constructors

	/** default constructor */
	public KtnbNsdNhom() {
	}

	/** minimal constructor */
	public KtnbNsdNhom(KtnbNsdNhomId id) {
		this.id = id;
	}

	/** full constructor */
	public KtnbNsdNhom(KtnbNsdNhomId id, Date ngayHluc, Date ngayHetHluc) {
		this.id = id;
		this.ngayHluc = ngayHluc;
		this.ngayHetHluc = ngayHetHluc;
	}

	// Property accessors

	public KtnbNsdNhomId getId() {
		return this.id;
	}

	public void setId(KtnbNsdNhomId id) {
		this.id = id;
	}

	public Date getNgayHluc() {
		return this.ngayHluc;
	}

	public void setNgayHluc(Date ngayHluc) {
		this.ngayHluc = ngayHluc;
	}

	public Date getNgayHetHluc() {
		return this.ngayHetHluc;
	}

	public void setNgayHetHluc(Date ngayHetHluc) {
		this.ngayHetHluc = ngayHetHluc;
	}

}