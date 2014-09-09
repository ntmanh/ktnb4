package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;
import cmc.com.ktnb.pl.hb.entity.PersistentObject;

import java.util.Collection;
import java.util.Date;

/**
 * TtktThBbMoNiemPhong entity. @author MyEclipse Persistence Tools
 */

public class TtktThBbMoNiemPhong extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idQdMoNiemPhong;
	private Date thoiDiemMoNiemPhong;
	private String diaDiemMoNiemPhong;
	private String idTpThamDuDoanTtkt;
	private String idTpThamDuCacOngBa;
	private String tinhTrangDauNphong;
	private Date thoiDiemKetThucMoNphong;
	private Date moNiemPhongCuaNgay;
	private Collection dsDoanTtkt;
	private Collection dsCacOba;
	private String idDsTvd;
	
	public static String IdQuyetMoDinhNp = "idQdMoNiemPhong";

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
	public TtktThBbMoNiemPhong() {
	}


	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdQdMoNiemPhong() {
		return this.idQdMoNiemPhong;
	}

	public void setIdQdMoNiemPhong(String idQdMoNiemPhong) {
		this.idQdMoNiemPhong = idQdMoNiemPhong;
	}

	public Date getThoiDiemMoNiemPhong() {
		return this.thoiDiemMoNiemPhong;
	}

	public void setThoiDiemMoNiemPhong(Date thoiDiemMoNiemPhong) {
		this.thoiDiemMoNiemPhong = thoiDiemMoNiemPhong;
	}

	public String getDiaDiemMoNiemPhong() {
		return this.diaDiemMoNiemPhong;
	}

	public void setDiaDiemMoNiemPhong(String diaDiemMoNiemPhong) {
		this.diaDiemMoNiemPhong = diaDiemMoNiemPhong;
	}

	public String getIdTpThamDuDoanTtkt() {
		return this.idTpThamDuDoanTtkt;
	}

	public void setIdTpThamDuDoanTtkt(String idTpThamDuDoanTtkt) {
		this.idTpThamDuDoanTtkt = idTpThamDuDoanTtkt;
	}

	public String getIdTpThamDuCacOngBa() {
		return this.idTpThamDuCacOngBa;
	}

	public void setIdTpThamDuCacOngBa(String idTpThamDuCacOngBa) {
		this.idTpThamDuCacOngBa = idTpThamDuCacOngBa;
	}

	public String getTinhTrangDauNphong() {
		return this.tinhTrangDauNphong;
	}

	public void setTinhTrangDauNphong(String tinhTrangDauNphong) {
		this.tinhTrangDauNphong = tinhTrangDauNphong;
	}

	public Date getThoiDiemKetThucMoNphong() {
		return this.thoiDiemKetThucMoNphong;
	}

	public void setThoiDiemKetThucMoNphong(Date thoiDiemKetThucMoNphong) {
		this.thoiDiemKetThucMoNphong = thoiDiemKetThucMoNphong;
	}

	public Date getMoNiemPhongCuaNgay() {
		return this.moNiemPhongCuaNgay;
	}

	public void setMoNiemPhongCuaNgay(Date moNiemPhongCuaNgay) {
		this.moNiemPhongCuaNgay = moNiemPhongCuaNgay;
	}

	/**
	 * @return
	 */
	public Collection getDsCacOba() {
		return dsCacOba;
	}

	/**
	 * @return
	 */
	public Collection getDsDoanTtkt() {
		return dsDoanTtkt;
	}

	/**
	 * @param collection
	 */
	public void setDsCacOba(Collection collection) {
		dsCacOba = collection;
	}

	/**
	 * @param collection
	 */
	public void setDsDoanTtkt(Collection collection) {
		dsDoanTtkt = collection;
	}


	public String getIdDsTvd() {
		return idDsTvd;
	}


	public void setIdDsTvd(String idDsTvd) {
		this.idDsTvd = idDsTvd;
	}

}