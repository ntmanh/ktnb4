package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KtnbNsd entity. @author MyEclipse Persistence Tools
 */

public class KtnbNsd extends cmc.com.ktnb.pl.hb.entity.PersistentObject
		implements java.io.Serializable {

	// Fields

	private String maCanBo;
	private String tenNsd;
	private String matKhau;
	private String active;
	private Date ngayHluc;
	private Date ngayHetHluc;

	// Constructors

	/** default constructor */
	public KtnbNsd() {
	}

	/** minimal constructor */
	public KtnbNsd(String maCanBo, String tenNsd, String matKhau,
			String active, Date ngayHluc) {
		this.maCanBo = maCanBo;
		this.tenNsd = tenNsd;
		this.matKhau = matKhau;
		this.active = active;
		this.ngayHluc = ngayHluc;
	}

	/** full constructor */
	public KtnbNsd(String maCanBo, String tenNsd, String matKhau,
			String active, Date ngayHluc, Date ngayHetHluc) {
		this.maCanBo = maCanBo;
		this.tenNsd = tenNsd;
		this.matKhau = matKhau;
		this.active = active;
		this.ngayHluc = ngayHluc;
		this.ngayHetHluc = ngayHetHluc;
	}

	// Property accessors

	public String getMaCanBo() {
		return this.maCanBo;
	}

	public void setMaCanBo(String maCanBo) {
		this.maCanBo = maCanBo;
	}

	public String getTenNsd() {
		return this.tenNsd;
	}

	public void setTenNsd(String tenNsd) {
		this.tenNsd = tenNsd;
	}

	public String getMatKhau() {
		return this.matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
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