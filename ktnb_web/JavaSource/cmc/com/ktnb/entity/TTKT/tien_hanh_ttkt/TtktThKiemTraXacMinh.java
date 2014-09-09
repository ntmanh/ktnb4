package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;

import java.util.Collection;
import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktThKiemTraXacMinh entity. @author MyEclipse Persistence Tools
 */

public class TtktThKiemTraXacMinh extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idCuocTtkt;
	private String suViecDuocKtxm;
	private Date thoiGian;
	private String diaDiem;
	private String thanhPhanThamDuDoanTtkt;
	private String thanhPhanThamDuDoanDonVi;
	private String noiDung;
	private String idDsTvd;
	public static String IdCuocTtkt = "idCuocTtkt";
	public static String Id = "id";

	private Collection dsDoanTtKt;
	private Collection dsDvDuocKtXm;
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
	public TtktThKiemTraXacMinh() {
	}

	/** full constructor */
	public TtktThKiemTraXacMinh(String id, String idCuocTtkt,
			String suViecDuocKtxm, Date thoiGian, String diaDiem,
			String thanhPhanThamDuDoanTtkt, String thanhPhanThamDuDoanDonVi,
			String noiDung) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.suViecDuocKtxm = suViecDuocKtxm;
		this.thoiGian = thoiGian;
		this.diaDiem = diaDiem;
		this.thanhPhanThamDuDoanTtkt = thanhPhanThamDuDoanTtkt;
		this.thanhPhanThamDuDoanDonVi = thanhPhanThamDuDoanDonVi;
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

	public String getSuViecDuocKtxm() {
		return this.suViecDuocKtxm;
	}

	public void setSuViecDuocKtxm(String suViecDuocKtxm) {
		this.suViecDuocKtxm = suViecDuocKtxm;
	}

	public Date getThoiGian() {
		return this.thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getDiaDiem() {
		return this.diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getThanhPhanThamDuDoanTtkt() {
		return this.thanhPhanThamDuDoanTtkt;
	}

	public void setThanhPhanThamDuDoanTtkt(String thanhPhanThamDuDoanTtkt) {
		this.thanhPhanThamDuDoanTtkt = thanhPhanThamDuDoanTtkt;
	}

	public String getThanhPhanThamDuDoanDonVi() {
		return this.thanhPhanThamDuDoanDonVi;
	}

	public void setThanhPhanThamDuDoanDonVi(String thanhPhanThamDuDoanDonVi) {
		this.thanhPhanThamDuDoanDonVi = thanhPhanThamDuDoanDonVi;
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
	public Collection getDsDoanTtKt() {
		return dsDoanTtKt;
	}

	/**
	 * @return
	 */
	public Collection getDsDvDuocKtXm() {
		return dsDvDuocKtXm;
	}

	/**
	 * @param collection
	 */
	public void setDsDoanTtKt(Collection collection) {
		dsDoanTtKt = collection;
	}

	/**
	 * @param collection
	 */
	public void setDsDvDuocKtXm(Collection collection) {
		dsDvDuocKtXm = collection;
	}

	public String getIdDsTvd() {
		return idDsTvd;
	}

	public void setIdDsTvd(String idDsTvd) {
		this.idDsTvd = idDsTvd;
	}

}