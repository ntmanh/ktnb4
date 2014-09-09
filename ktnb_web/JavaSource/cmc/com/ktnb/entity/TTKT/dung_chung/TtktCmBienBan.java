package cmc.com.ktnb.entity.TTKT.dung_chung;

import java.util.Collection;
import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * KtnbBb entity. @author MyEclipse Persistence Tools
 */

public class TtktCmBienBan extends PersistentObject
implements java.io.Serializable{

	// Fields

	private String id;
	private String idCuocTtkt;
	private String loai;
	private Date thoiDiemBatDau;
	private Date thoiDiemKetThuc;
	private String diaDiem;
	private String noiDung;
	private String veViec;
	private Collection thanhPhanThamDu;
	private Collection doanTtKt;
	private String tpThamDuDoanTtkt;
	private String tpThamDuKhac;
	private String idDsTvd;
	
	private String dienBienKetQua;
	private String lamViecVoi;
	
	
	// Static fields
	public static final String IdCuocTtkt = "idCuocTtkt";
	public static final String Loai = "loai";

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
	public TtktCmBienBan() {
	}

	/** minimal constructor */
	public TtktCmBienBan(String id) {
		this.id = id;
	}

	/** full constructor */
	public TtktCmBienBan(String id, String idCuocTtkt, String loai, Date thoiDiemBatDau,
			Date thoiDiemKetThuc, String diaDiem, String noiDung) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.loai = loai;
		this.thoiDiemBatDau = thoiDiemBatDau;
		this.thoiDiemKetThuc = thoiDiemKetThuc;
		this.diaDiem = diaDiem;
		this.noiDung = noiDung;
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

	public String getLoai() {
		return this.loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public Date getThoiDiemBatDau() {
		return this.thoiDiemBatDau;
	}

	public void setThoiDiemBatDau(Date thoiDiemBatDau) {
		this.thoiDiemBatDau = thoiDiemBatDau;
	}

	public Date getThoiDiemKetThuc() {
		return this.thoiDiemKetThuc;
	}

	public void setThoiDiemKetThuc(Date thoiDiemKetThuc) {
		this.thoiDiemKetThuc = thoiDiemKetThuc;
	}

	public String getDiaDiem() {
		return this.diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
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
	public String getVeViec() {
		return veViec;
	}

	/**
	 * @param string
	 */
	public void setVeViec(String string) {
		veViec = string;
	}

	/**
	 * @return
	 */
	public Collection getThanhPhanThamDu() {
		return thanhPhanThamDu;
	}

	/**
	 * @param collection
	 */
	public void setThanhPhanThamDu(Collection collection) {
		thanhPhanThamDu = collection;
	}

	

	/**
	 * @return
	 */
	public Collection getDoanTtKt() {
		return doanTtKt;
	}

	/**
	 * @param collection
	 */
	public void setDoanTtKt(Collection collection) {
		doanTtKt = collection;
	}
	
	public String getTpThamDuDoanTtkt() {
		return this.tpThamDuDoanTtkt;
	}
	
	public void setTpThamDuDoanTtkt(String tpThamDuDoanTtkt) {
		this.tpThamDuDoanTtkt = tpThamDuDoanTtkt;
	}
	
	public String getTpThamDuKhac() {
		return this.tpThamDuKhac;
	}

	public void setTpThamDuKhac(String tpThamDuKhac) {
		this.tpThamDuKhac = tpThamDuKhac;
	}
	
	public String getDienBienKetQua() {
		return this.dienBienKetQua;
	}

	public void setDienBienKetQua(String dienBienKetQua) {
		this.dienBienKetQua = dienBienKetQua;
	}

	public String getLamViecVoi() {
		return this.lamViecVoi;
	}

	public void setLamViecVoi(String lamViecVoi) {
		this.lamViecVoi = lamViecVoi;
	}
	/**
	 * @return
	 */
	public String getIdDsTvd() {
		return idDsTvd;
	}

	/**
	 * @param string
	 */
	public void setIdDsTvd(String string) {
		idDsTvd = string;
	}

}