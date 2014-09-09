package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KtnbCaNhan entity. @author MyEclipse Persistence Tools
 */

public class KtnbCaNhan extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements
		java.io.Serializable {

	// Fields

	private String maCaNhan;
	private String hoTen;
	private String diaChi;
	private String dienThoai;
	private String cmtHc;
	private Date cmcNgayCap;
	private String cmcNoiCap;
	private Long loai;
	private Date ngayCapNhat;
	private String nguoiCapNhat;
	private String cqThue;
	private String maSoThue;
	private String chucVu;
	private String noiCongTac;

	// Constructors

	/** default constructor */
	public KtnbCaNhan() {
	}

	/** minimal constructor */
	public KtnbCaNhan(String maCaNhan) {
		this.maCaNhan = maCaNhan;
	}

	/** full constructor */
	public KtnbCaNhan(String maCaNhan, String hoTen, String diaChi,
			String dienThoai, String cmtHc, Date cmcNgayCap, String cmcNoiCap,
			Long loai, Date ngayCapNhat, String nguoiCapNhat,
			String cqThue, String maSoThue, String chucVu, String noiCongTac) {
		this.maCaNhan = maCaNhan;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.cmtHc = cmtHc;
		this.cmcNgayCap = cmcNgayCap;
		this.cmcNoiCap = cmcNoiCap;
		this.loai = loai;
		this.ngayCapNhat = ngayCapNhat;
		this.nguoiCapNhat = nguoiCapNhat;
		this.cqThue = cqThue;
		this.maSoThue = maSoThue;
		this.chucVu = chucVu;
		this.noiCongTac = noiCongTac;
	}

	// Property accessors

	public String getMaCaNhan() {
		return this.maCaNhan;
	}

	public void setMaCaNhan(String maCaNhan) {
		this.maCaNhan = maCaNhan;
	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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

	public String getCmtHc() {
		return this.cmtHc;
	}

	public void setCmtHc(String cmtHc) {
		this.cmtHc = cmtHc;
	}

	public Date getCmcNgayCap() {
		return this.cmcNgayCap;
	}

	public void setCmcNgayCap(Date cmcNgayCap) {
		this.cmcNgayCap = cmcNgayCap;
	}

	public String getCmcNoiCap() {
		return this.cmcNoiCap;
	}

	public void setCmcNoiCap(String cmcNoiCap) {
		this.cmcNoiCap = cmcNoiCap;
	}

	public Long getLoai() {
		return this.loai;
	}

	public void setLoai(Long loai) {
		this.loai = loai;
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

	public String getMaSoThue() {
		return this.maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public String getChucVu() {
		return this.chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getNoiCongTac() {
		return this.noiCongTac;
	}

	public void setNoiCongTac(String noiCongTac) {
		this.noiCongTac = noiCongTac;
	}

}