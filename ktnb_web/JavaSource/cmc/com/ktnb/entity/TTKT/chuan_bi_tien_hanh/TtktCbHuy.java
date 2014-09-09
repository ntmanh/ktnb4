package cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh;

import java.util.Date;
import cmc.com.ktnb.pl.hb.entity.PersistentObject;
/**
 * TtktCbHuy entity. @author MyEclipse Persistence Tools
 */

public class TtktCbHuy extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idCuocTtkt;
	private String soQd;
	private String noiRaQd;
	private Date ngayRaQd;
	private String vbQdinhCnangNvu;
	private String soQdHuy;
	private Date ngayHieuLuc;
	private String idNguoiDeNghiHuy;
	private String tenNguoiDeNghiHuy;
	private String chucVuNguoiDeNghi;
	public static String IdCuocTtkt = "idCuocTtkt";

	// Constructors
	private String idNguoiCapNat;
	 private String tenNguoiCapNhat;
	 private Date ngayCapNhat;
	 public String getIdNguoiCapNat() {
	  return idNguoiCapNat;
	 }

	 public void setIdNguoiCapNat(String idNguoiCapNat) {
	  this.idNguoiCapNat = idNguoiCapNat;
	 }

	 public Date getNgayCapNhat() {
	  return ngayCapNhat;
	 }

	 public void setNgayCapNhat(Date ngayCapNhat) {
	  this.ngayCapNhat = ngayCapNhat;
	 }

	 public String getTenNguoiCapNhat() {
	  return tenNguoiCapNhat;
	 }

	 public void setTenNguoiCapNhat(String tenNguoiCapNhat) {
	  this.tenNguoiCapNhat = tenNguoiCapNhat;
	 }
	/** default constructor */
	public TtktCbHuy() {
	}

	/** full constructor */
	public TtktCbHuy(String id, String idCuocTtkt, String soQd, String noiRaQd,
			Date ngayRaQd, String vbQdinhCnangNvu, String soQdHuy,
			Date ngayHieuLuc, String idNguoiDeNghiHuy,
			String tenNguoiDeNghiHuy, String chucVuNguoiDeNghi) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.soQd = soQd;
		this.noiRaQd = noiRaQd;
		this.ngayRaQd = ngayRaQd;
		this.vbQdinhCnangNvu = vbQdinhCnangNvu;
		this.soQdHuy = soQdHuy;
		this.ngayHieuLuc = ngayHieuLuc;
		this.idNguoiDeNghiHuy = idNguoiDeNghiHuy;
		this.tenNguoiDeNghiHuy = tenNguoiDeNghiHuy;
		this.chucVuNguoiDeNghi = chucVuNguoiDeNghi;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdCuocTtkt() {
		return this.idCuocTtkt;
	}

	public void setIdCuocTtkt(String idCuocTtkt) {
		this.idCuocTtkt = idCuocTtkt;
	}

	public String getSoQd() {
		return this.soQd;
	}

	public void setSoQd(String soQd) {
		this.soQd = soQd;
	}

	public String getNoiRaQd() {
		return this.noiRaQd;
	}

	public void setNoiRaQd(String noiRaQd) {
		this.noiRaQd = noiRaQd;
	}

	public Date getNgayRaQd() {
		return this.ngayRaQd;
	}

	public void setNgayRaQd(Date ngayRaQd) {
		this.ngayRaQd = ngayRaQd;
	}

	public String getVbQdinhCnangNvu() {
		return this.vbQdinhCnangNvu;
	}

	public void setVbQdinhCnangNvu(String vbQdinhCnangNvu) {
		this.vbQdinhCnangNvu = vbQdinhCnangNvu;
	}

	public String getSoQdHuy() {
		return this.soQdHuy;
	}

	public void setSoQdHuy(String soQdHuy) {
		this.soQdHuy = soQdHuy;
	}

	public Date getNgayHieuLuc() {
		return this.ngayHieuLuc;
	}

	public void setNgayHieuLuc(Date ngayHieuLuc) {
		this.ngayHieuLuc = ngayHieuLuc;
	}

	public String getIdNguoiDeNghiHuy() {
		return this.idNguoiDeNghiHuy;
	}

	public void setIdNguoiDeNghiHuy(String idNguoiDeNghiHuy) {
		this.idNguoiDeNghiHuy = idNguoiDeNghiHuy;
	}

	public String getTenNguoiDeNghiHuy() {
		return this.tenNguoiDeNghiHuy;
	}

	public void setTenNguoiDeNghiHuy(String tenNguoiDeNghiHuy) {
		this.tenNguoiDeNghiHuy = tenNguoiDeNghiHuy;
	}

	public String getChucVuNguoiDeNghi() {
		return this.chucVuNguoiDeNghi;
	}

	public void setChucVuNguoiDeNghi(String chucVuNguoiDeNghi) {
		this.chucVuNguoiDeNghi = chucVuNguoiDeNghi;
	}

}