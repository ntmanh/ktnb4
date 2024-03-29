package cmc.com.ktnb.entity.TTKT.dung_chung;

import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktKhDuyetKeHoach generated by MyEclipse Persistence Tools
 */

public class TtktKhDuyetKeHoach extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;

	private String maCqt;

	private String tenCqt;

	private long keHoachNam;

	private String noiKyTrinh;

	private Date ngayKyTrinh;

	private String noiPheDuyet;

	private Date ngayPheDuyet;

	private String ykienPheDuyet;
	
	public static final  String KeHoachNam = "keHoachNam";
	public static final  String MaCqt = "maCqt";
	public static final  String TenCqt = "tenCqt";
	

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
	public TtktKhDuyetKeHoach() {
	}

	/** minimal constructor */
	public TtktKhDuyetKeHoach(String id, String maCqt, String tenCqt, long keHoachNam, Date ngayPheDuyet) {
		this.id = id;
		this.maCqt = maCqt;
		this.tenCqt = tenCqt;
		this.keHoachNam = keHoachNam;
		this.ngayPheDuyet = ngayPheDuyet;
	}

	/** full constructor */
	public TtktKhDuyetKeHoach(String id, String maCqt, String tenCqt, long keHoachNam, String noiKyTrinh, Date ngayKyTrinh, String noiPheDuyet, Date ngayPheDuyet, String YKienPheDuyet) {
		this.id = id;
		this.maCqt = maCqt;
		this.tenCqt = tenCqt;
		this.keHoachNam = keHoachNam;
		this.noiKyTrinh = noiKyTrinh;
		this.ngayKyTrinh = ngayKyTrinh;
		this.noiPheDuyet = noiPheDuyet;
		this.ngayPheDuyet = ngayPheDuyet;
		this.ykienPheDuyet = YKienPheDuyet;
	}
	

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaCqt() {
		return this.maCqt;
	}

	public void setMaCqt(String maCqt) {
		this.maCqt = maCqt;
	}

	public String getTenCqt() {
		return this.tenCqt;
	}

	public void setTenCqt(String tenCqt) {
		this.tenCqt = tenCqt;
	}

	public long getKeHoachNam() {
		return this.keHoachNam;
	}

	public void setKeHoachNam(long keHoachNam) {
		this.keHoachNam = keHoachNam;
	}

	public String getNoiKyTrinh() {
		return this.noiKyTrinh;
	}

	public void setNoiKyTrinh(String noiKyTrinh) {
		this.noiKyTrinh = noiKyTrinh;
	}

	public Date getNgayKyTrinh() {
		return this.ngayKyTrinh;
	}

	public void setNgayKyTrinh(Date ngayKyTrinh) {
		this.ngayKyTrinh = ngayKyTrinh;
	}

	public String getNoiPheDuyet() {
		return this.noiPheDuyet;
	}

	public void setNoiPheDuyet(String noiPheDuyet) {
		this.noiPheDuyet = noiPheDuyet;
	}

	public Date getNgayPheDuyet() {
		return this.ngayPheDuyet;
	}

	public void setNgayPheDuyet(Date ngayPheDuyet) {
		this.ngayPheDuyet = ngayPheDuyet;
	}

	public String getYkienPheDuyet() {
		return this.ykienPheDuyet;
	}

	public void setYkienPheDuyet(String YKienPheDuyet) {
		this.ykienPheDuyet = YKienPheDuyet;
	}

}