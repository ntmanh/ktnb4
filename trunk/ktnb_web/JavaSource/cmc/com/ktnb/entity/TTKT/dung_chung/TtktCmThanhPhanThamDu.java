package cmc.com.ktnb.entity.TTKT.dung_chung;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;
import java.util.Date;
/**
 * KtnbThanhPhanThamDu entity. @author MyEclipse Persistence Tools
 */

public class TtktCmThanhPhanThamDu extends PersistentObject
implements java.io.Serializable{

	// Fields

	private String id;
	private String idMaster;
	private String idCanBo;
	private String hoTen;
	private String chucVu;
	private int phanLoai;
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

	
	// Static fields
	public static final String IdMaster = "idMaster";

	// Constructors

	/** default constructor */
	public TtktCmThanhPhanThamDu() {
	}

	/** minimal constructor */
	public TtktCmThanhPhanThamDu(String id, String idMaster) {
		this.id = id;
		this.idMaster = idMaster;
	}

	/** full constructor */
	public TtktCmThanhPhanThamDu(String id, String idMaster, String hoTen,
			String chucVu) {
		this.id = id;
		this.idMaster = idMaster;
		this.hoTen = hoTen;
		this.chucVu = chucVu;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdMaster() {
		return this.idMaster;
	}

	public void setIdMaster(String idMaster) {
		this.idMaster = idMaster;
	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getChucVu() {
		return this.chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	/**
	 * @return
	 */
	public String getIdCanBo() {
		return idCanBo;
	}

	/**
	 * @param string
	 */
	public void setIdCanBo(String string) {
		idCanBo = string;
	}

	/**
	 * @return
	 */
	public int getPhanLoai() {
		return phanLoai;
	}

	/**
	 * @param i
	 */
	public void setPhanLoai(int i) {
		phanLoai = i;
	}

}