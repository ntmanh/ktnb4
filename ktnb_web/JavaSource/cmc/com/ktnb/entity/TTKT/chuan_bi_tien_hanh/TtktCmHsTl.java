package cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh;

import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * KtnbHsTl entity. @author MyEclipse Persistence Tools
 */

public class TtktCmHsTl extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String masterId;
	private String loai;
	private String ten;
	private String noiDung;
	private Date thoiGianBanGiao;
	private String diaDiemNhanId;
	private String diaDiemNhanName;
	private String nguoiNhanId;
	private String nguoiNhanName;
	private Date thoiKyTu;
	private Date thoiKyDen;
	private String hinhThuc;
	
	
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
	public static final String MasterId = "masterId";

	// Constructors

	/** default constructor */
	public TtktCmHsTl() {
	}

	/** minimal constructor */
	public TtktCmHsTl(String id, String masterId) {
		this.id = id;
		this.masterId = masterId;
	}

	/** full constructor */
	public TtktCmHsTl(String id, String masterId, String loai, String ten,
			String noiDung, Date thoiGianBanGiao, String diaDiemNhanId,
			String diaDiemNhanName, String nguoiNhanId, String nguoiNhanName) {
		this.id = id;
		this.masterId = masterId;
		this.loai = loai;
		this.ten = ten;
		this.noiDung = noiDung;
		this.thoiGianBanGiao = thoiGianBanGiao;
		this.diaDiemNhanId = diaDiemNhanId;
		this.diaDiemNhanName = diaDiemNhanName;
		this.nguoiNhanId = nguoiNhanId;
		this.nguoiNhanName = nguoiNhanName;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMasterId() {
		return this.masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getLoai() {
		return this.loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Date getThoiGianBanGiao() {
		return this.thoiGianBanGiao;
	}

	public void setThoiGianBanGiao(Date thoiGianBanGiao) {
		this.thoiGianBanGiao = thoiGianBanGiao;
	}

	public String getDiaDiemNhanId() {
		return this.diaDiemNhanId;
	}

	public void setDiaDiemNhanId(String diaDiemNhanId) {
		this.diaDiemNhanId = diaDiemNhanId;
	}

	public String getDiaDiemNhanName() {
		return this.diaDiemNhanName;
	}

	public void setDiaDiemNhanName(String diaDiemNhanName) {
		this.diaDiemNhanName = diaDiemNhanName;
	}

	public String getNguoiNhanId() {
		return this.nguoiNhanId;
	}

	public void setNguoiNhanId(String nguoiNhanId) {
		this.nguoiNhanId = nguoiNhanId;
	}

	public String getNguoiNhanName() {
		return this.nguoiNhanName;
	}

	public void setNguoiNhanName(String nguoiNhanName) {
		this.nguoiNhanName = nguoiNhanName;
	}

	/**
	 * @return
	 */
	public Date getThoiKyDen() {
		return thoiKyDen;
	}

	/**
	 * @return
	 */
	public Date getThoiKyTu() {
		return thoiKyTu;
	}

	/**
	 * @param date
	 */
	public void setThoiKyDen(Date date) {
		thoiKyDen = date;
	}

	/**
	 * @param date
	 */
	public void setThoiKyTu(Date date) {
		thoiKyTu = date;
	}

	/**
	 * @return
	 */
	public String getHinhThuc() {
		return hinhThuc;
	}

	/**
	 * @param string
	 */
	public void setHinhThuc(String string) {
		hinhThuc = string;
	}

}