package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KtnbToChuc entity. @author MyEclipse Persistence Tools
 */

public class KtnbToChuc extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements
		java.io.Serializable {

	// Fields

	private String maToChuc;
	private String tenTc;
	private String diaChi;
	private String dienThoai;
	private String maSoThue;
	private String fax;
	private Date ngayCapNhat;
	private String nguoiCapNhat;
	private String cqThue;

	// Constructors

	/** default constructor */
	public KtnbToChuc() {
	}

	/** minimal constructor */
	public KtnbToChuc(String maToChuc) {
		this.maToChuc = maToChuc;
	}

	/** full constructor */
	public KtnbToChuc(String maToChuc, String tenTc, String diaChi,
			String dienThoai, String maSoThue, String fax, Date ngayCapNhat,
			String nguoiCapNhat, String cqThue) {
		this.maToChuc = maToChuc;
		this.tenTc = tenTc;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.maSoThue = maSoThue;
		this.fax = fax;
		this.ngayCapNhat = ngayCapNhat;
		this.nguoiCapNhat = nguoiCapNhat;
		this.cqThue = cqThue;
	}

	// Property accessors

	public String getMaToChuc() {
		return this.maToChuc;
	}

	public void setMaToChuc(String maToChuc) {
		this.maToChuc = maToChuc;
	}

	public String getTenTc() {
		return this.tenTc;
	}

	public void setTenTc(String tenTc) {
		this.tenTc = tenTc;
	}

	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDienThoai() {
		return this.dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getMaSoThue() {
		return this.maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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

	public String getCqThue() {
		return this.cqThue;
	}

	public void setCqThue(String cqThue) {
		this.cqThue = cqThue;
	}

}