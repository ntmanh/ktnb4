package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;

import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktThNhatKy entity. @author MyEclipse Persistence Tools
 */

public class TtktThNhatKy extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idCuocTtkt;
	private String idThanhVienDoan;
	private String tenThanhVienDoan;
	private Date ngayBatDau;
	private String ngayBatDauStr;
	private Date ngayKetThuc;
	private String ngayKetThucStr;
	private String diaDiemLamViec;
	private String congViecThucHien;
	private String chucVuTrongDoan;
	private String isChange = "0";
	private Date ngay;
	private String ngayStr;
	private String noiDung;
	
	
	// static fields 
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
	public TtktThNhatKy() {
	}

	/** full constructor */
	public TtktThNhatKy(String id, String idCuocTtkt, String idThanhVienDoan,
			String tenThanhVienDoan, Date ngayBatDau, Date ngayKetThuc,
			String diaDiemLamViec, String congViecThucHien) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.idThanhVienDoan = idThanhVienDoan;
		this.tenThanhVienDoan = tenThanhVienDoan;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.diaDiemLamViec = diaDiemLamViec;
		this.congViecThucHien = congViecThucHien;
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

	public String getIdThanhVienDoan() {
		return this.idThanhVienDoan;
	}

	public void setIdThanhVienDoan(String idThanhVienDoan) {
		this.idThanhVienDoan = idThanhVienDoan;
	}

	public String getTenThanhVienDoan() {
		return this.tenThanhVienDoan;
	}

	public void setTenThanhVienDoan(String tenThanhVienDoan) {
		this.tenThanhVienDoan = tenThanhVienDoan;
	}

	public Date getNgayBatDau() {
		return this.ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return this.ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getDiaDiemLamViec() {
		return this.diaDiemLamViec;
	}

	public void setDiaDiemLamViec(String diaDiemLamViec) {
		this.diaDiemLamViec = diaDiemLamViec;
	}

	public String getCongViecThucHien() {
		return this.congViecThucHien;
	}

	public void setCongViecThucHien(String congViecThucHien) {
		this.congViecThucHien = congViecThucHien;
	}

	/**
	 * @return
	 */
	public String getChucVuTrongDoan() {
		return chucVuTrongDoan;
	}

	/**
	 * @param string
	 */
	public void setChucVuTrongDoan(String string) {
		chucVuTrongDoan = string;
	}

	/**
	 * @return
	 */
	public String getIsChange() {
		return isChange;
	}

	/**
	 * @param string
	 */
	public void setIsChange(String string) {
		isChange = string;
	}

	/**
	 * @return
	 */
	public String getNgayBatDauStr() {
		return ngayBatDauStr;
	}

	

	/**
	 * @param string
	 */
	public void setNgayBatDauStr(String string) {
		ngayBatDauStr = string;
	}

	

	/**
	 * @return
	 */
	public String getNgayKetThucStr() {
		return ngayKetThucStr;
	}

	/**
	 * @param string
	 */
	public void setNgayKetThucStr(String string) {
		ngayKetThucStr = string;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getNgayStr() {
		return ngayStr;
	}

	public void setNgayStr(String ngayStr) {
		this.ngayStr = ngayStr;
	}

}