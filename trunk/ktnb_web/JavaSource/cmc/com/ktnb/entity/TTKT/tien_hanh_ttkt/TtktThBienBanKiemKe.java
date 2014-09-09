package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;

import java.util.Collection;
import java.util.Date;
import cmc.com.ktnb.pl.hb.entity.PersistentObject;
/**
 * TtktThBienBanKiemKe entity. @author MyEclipse Persistence Tools
 */

public class TtktThBienBanKiemKe extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idQdKk;
	private Date thoiGianBatDau;
	private Date thoiGianKetThuc;
	private String soluongChungloaiXs;
	private Date thoiDiemLapBb;
	private Date thoiDiemKk;
	private String dviCnhanDuocGiaoBaoQuan;
	private String idDaiDienDoanTtkt;
	private String idDaiDienDviCnhanCoTskk;
	private Collection dsDoanTtkt;
	private Collection dsDonViCoTsKk;
	private String idDsTvd;

	public static String IdQdKk= "idQdKk";
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
	public TtktThBienBanKiemKe() {
	}

	/** full constructor */
	public TtktThBienBanKiemKe(String id, String idQdKk, Date thoiGianBatDau,
			Date thoiGianKetThuc, String soluongChungloaiXs,
			Date thoiDiemLapBb, Date thoiDiemKk,
			String dviCnhanDuocGiaoBaoQuan, String idDaiDienDoanTtkt,
			String idDaiDienDviCnhanCoTskk) {
		this.id = id;
		this.idQdKk = idQdKk;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.soluongChungloaiXs = soluongChungloaiXs;
		this.thoiDiemLapBb = thoiDiemLapBb;
		this.thoiDiemKk = thoiDiemKk;
		this.dviCnhanDuocGiaoBaoQuan = dviCnhanDuocGiaoBaoQuan;
		this.idDaiDienDoanTtkt = idDaiDienDoanTtkt;
		this.idDaiDienDviCnhanCoTskk = idDaiDienDviCnhanCoTskk;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdQdKk() {
		return this.idQdKk;
	}

	public void setIdQdKk(String idQdKk) {
		this.idQdKk = idQdKk;
	}

	public Date getThoiGianBatDau() {
		return this.thoiGianBatDau;
	}

	public void setThoiGianBatDau(Date thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public Date getThoiGianKetThuc() {
		return this.thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public String getSoluongChungloaiXs() {
		return this.soluongChungloaiXs;
	}

	public void setSoluongChungloaiXs(String soluongChungloaiXs) {
		this.soluongChungloaiXs = soluongChungloaiXs;
	}

	public Date getThoiDiemLapBb() {
		return this.thoiDiemLapBb;
	}

	public void setThoiDiemLapBb(Date thoiDiemLapBb) {
		this.thoiDiemLapBb = thoiDiemLapBb;
	}

	public Date getThoiDiemKk() {
		return this.thoiDiemKk;
	}

	public void setThoiDiemKk(Date thoiDiemKk) {
		this.thoiDiemKk = thoiDiemKk;
	}

	public String getDviCnhanDuocGiaoBaoQuan() {
		return this.dviCnhanDuocGiaoBaoQuan;
	}

	public void setDviCnhanDuocGiaoBaoQuan(String dviCnhanDuocGiaoBaoQuan) {
		this.dviCnhanDuocGiaoBaoQuan = dviCnhanDuocGiaoBaoQuan;
	}

	public String getIdDaiDienDoanTtkt() {
		return this.idDaiDienDoanTtkt;
	}

	public void setIdDaiDienDoanTtkt(String idDaiDienDoanTtkt) {
		this.idDaiDienDoanTtkt = idDaiDienDoanTtkt;
	}

	public String getIdDaiDienDviCnhanCoTskk() {
		return this.idDaiDienDviCnhanCoTskk;
	}

	public void setIdDaiDienDviCnhanCoTskk(String idDaiDienDviCnhanCoTskk) {
		this.idDaiDienDviCnhanCoTskk = idDaiDienDviCnhanCoTskk;
	}

	/**
	 * @return
	 */
	public Collection getDsDoanTtkt() {
		return dsDoanTtkt;
	}

	/**
	 * @return
	 */
	public Collection getDsDonViCoTsKk() {
		return dsDonViCoTsKk;
	}

	/**
	 * @param collection
	 */
	public void setDsDoanTtkt(Collection collection) {
		dsDoanTtkt = collection;
	}

	/**
	 * @param collection
	 */
	public void setDsDonViCoTsKk(Collection collection) {
		dsDonViCoTsKk = collection;
	}

	public String getIdDsTvd() {
		return idDsTvd;
	}

	public void setIdDsTvd(String idDsTvd) {
		this.idDsTvd = idDsTvd;
	}

}