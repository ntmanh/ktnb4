package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KtnbTlieuKemTheo entity. @author MyEclipse Persistence Tools
 */

public class KtnbTlieuKemTheo extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {

	// Fields
	public static final String TLKT_SO_TIEP_DAN="STD";
	private String maHoSo;
	private String maTlieu;
	private String tenTlieu;	
	private String loaiTlieu;	
	private Short soTrang;
	private Date ngayCapNhat;
	private String nguoiCapNhat;
	private String tinhTrang;
	private String chungCu;
	private String loaiThongTin; 

	// Constructors

	/** default constructor */
	public KtnbTlieuKemTheo() {
	}

	/** full constructor */
	public KtnbTlieuKemTheo(String maTlieu, String tenTlieu, Date ngayCapNhat, String nguoiCapNhat, String loaiTlieu, String maHoSo, Short soTrang, String loaiThongTin) {
		this.maTlieu = maTlieu;
		this.tenTlieu = tenTlieu;
		this.ngayCapNhat = ngayCapNhat;
		this.nguoiCapNhat = nguoiCapNhat;
		this.loaiTlieu = loaiTlieu;
		this.maHoSo = maHoSo;
		this.soTrang = soTrang;
		this.loaiThongTin = loaiThongTin;
	}

	// Property accessors
	
	

	public String getMaTlieu() {
		return this.maTlieu;
	}

	public void setMaTlieu(String maTlieu) {
		this.maTlieu = maTlieu;
	}

	public String getTenTlieu() {
		return this.tenTlieu;
	}

	public void setTenTlieu(String tenTlieu) {
		this.tenTlieu = tenTlieu;
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

	public String getLoaiTlieu() {
		return this.loaiTlieu;
	}

	public void setLoaiTlieu(String loaiTlieu) {
		this.loaiTlieu = loaiTlieu;
	}

	public String getMaHoSo() {
		return this.maHoSo;
	}

	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}

	public Short getSoTrang() {
		return this.soTrang;
	}

	public void setSoTrang(Short soTrang) {
		this.soTrang = soTrang;
	}

	/**
	 * @return
	 */
	public String getChungCu() {
		return chungCu;
	}

	/**
	 * @return
	 */
	public String getTinhTrang() {
		return tinhTrang;
	}

	/**
	 * @param string
	 */
	public void setChungCu(String string) {
		chungCu = string;
	}

	/**
	 * @param string
	 */
	public void setTinhTrang(String string) {
		tinhTrang = string;
	}

	public String getLoaiThongTin() {
		return loaiThongTin;
	}

	public void setLoaiThongTin(String loaiThongTin) {
		this.loaiThongTin = loaiThongTin;
	}

}