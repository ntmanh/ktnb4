package cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh;

import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * KtnbFile entity. @author MyEclipse Persistence Tools
 */

public class KtnbFile extends PersistentObject implements java.io.Serializable {

	// Fields

	private String maFile;
	private String tenFile;
	private Date ngayCapNhat;
	private String nguoiCapNhat;
	private String loaiFile;
	private String maDon;
	private Short soTrang;
	private String noiDung;
	private String nghiepVuPath;
	
	// Static fields
	public static String MaDon = "maDon";
	public static String NghiepVuPath = "nghiepVuPath";

	// Constructors

	/** default constructor */
	public KtnbFile() {
	}

	/** full constructor */
	public KtnbFile(String maFile, String tenFile, Date ngayCapNhat,
			String nguoiCapNhat, String loaiFile, String maDon, Short soTrang,
			String noiDung) {
		this.maFile = maFile;
		this.tenFile = tenFile;
		this.ngayCapNhat = ngayCapNhat;
		this.nguoiCapNhat = nguoiCapNhat;
		this.loaiFile = loaiFile;
		this.maDon = maDon;
		this.soTrang = soTrang;
		this.noiDung = noiDung;
	}

	// Property accessors

	public String getMaFile() {
		return this.maFile;
	}

	public void setMaFile(String maFile) {
		this.maFile = maFile;
	}

	public String getTenFile() {
		return this.tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
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

	public String getLoaiFile() {
		return this.loaiFile;
	}

	public void setLoaiFile(String loaiFile) {
		this.loaiFile = loaiFile;
	}

	public String getMaDon() {
		return this.maDon;
	}

	public void setMaDon(String maDon) {
		this.maDon = maDon;
	}

	public Short getSoTrang() {
		return this.soTrang;
	}

	public void setSoTrang(Short soTrang) {
		this.soTrang = soTrang;
	}

	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	/**
	 * @return
	 */
	public String getNghiepVuPath() {
		return nghiepVuPath;
	}

	/**
	 * @param string
	 */
	public void setNghiepVuPath(String string) {
		nghiepVuPath = string;
	}

}