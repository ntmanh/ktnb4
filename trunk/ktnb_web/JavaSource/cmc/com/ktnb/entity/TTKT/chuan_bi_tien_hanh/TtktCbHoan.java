package cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh;

import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktCbHoan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TtktCbHoan extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;

	private String idCuocTtkt;

	private Boolean cqtDeNghi;

	private Date ngayHoan;

	private Date ngayBatDauLai;

	private String lyDoHoan;

	private String vbXinHoanCuaDvDuocTtkt;

	private String vbTraLoiCuaDvTh;

	private Boolean trangThai;

	private Date ngayBatDauThucTe;

	private String idVbXinHoan;

	private String idVbTraLoi;

	private String tenFileVbXinHoan;

	private String tenFileVbTraLoiHoan;

	private String loaiFileVbTraLoiHoan;

	private String loaiFileVbXinHoan;

	private String idVbThongBaoHoan;

	private String tenFileThongBaoHoan;

	private String loaiFileThongBaoHoan;

	private String vbThongBaoHoan;

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
	
	public String getLoaiFileVbTraLoiHoan() {
		return this.loaiFileVbTraLoiHoan;
	}

	public void setLoaiFileVbTraLoiHoan(String loaiFileVbTraLoiHoan) {
		this.loaiFileVbTraLoiHoan = loaiFileVbTraLoiHoan;
	}

	public String getTenFileVbTraLoiHoan() {
		return this.tenFileVbTraLoiHoan;
	}

	public void setTenFileVbTraLoiHoan(String tenFileVbTraLoiHoan) {
		this.tenFileVbTraLoiHoan = tenFileVbTraLoiHoan;
	}

	public String getLoaiFileVbXinHoan() {
		return this.loaiFileVbXinHoan;
	}

	public void setLoaiFileVbXinHoan(String loaiFileVbXinHoan) {
		this.loaiFileVbXinHoan = loaiFileVbXinHoan;
	}

	public String getTenFileVbXinHoan() {
		return this.tenFileVbXinHoan;
	}

	public void setTenFileVbXinHoan(String tenFileVbXinHoan) {
		this.tenFileVbXinHoan = tenFileVbXinHoan;
	}

	public static String IdCuocTtkt = "idCuocTtkt";

	// Constructors

	/** default constructor */
	public TtktCbHoan() {
	}

	/** minimal constructor */
	public TtktCbHoan(String id, String idCuocTtkt, Boolean cqtDeNghi, Date ngayHoan, Date ngayBatDauLai) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.cqtDeNghi = cqtDeNghi;
		this.ngayHoan = ngayHoan;
		this.ngayBatDauLai = ngayBatDauLai;
	}

	/** full constructor */
	public TtktCbHoan(String id, String idCuocTtkt, Boolean cqtDeNghi, Date ngayHoan, Date ngayBatDauLai, String lyDoHoan, String vbXinHoanCuaDvDuocTtkt, String vbTraLoiCuaDvTh, Boolean trangThai,
			Date ngayBatDauThucTe, String idVbXinHoan, String idVbTraLoi) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.cqtDeNghi = cqtDeNghi;
		this.ngayHoan = ngayHoan;
		this.ngayBatDauLai = ngayBatDauLai;
		this.lyDoHoan = lyDoHoan;
		this.vbXinHoanCuaDvDuocTtkt = vbXinHoanCuaDvDuocTtkt;
		this.vbTraLoiCuaDvTh = vbTraLoiCuaDvTh;
		this.trangThai = trangThai;
		this.ngayBatDauThucTe = ngayBatDauThucTe;
		this.idVbXinHoan = idVbXinHoan;
		this.idVbTraLoi = idVbTraLoi;
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

	public Boolean getCqtDeNghi() {
		return this.cqtDeNghi;
	}

	public void setCqtDeNghi(Boolean cqtDeNghi) {
		this.cqtDeNghi = cqtDeNghi;
	}

	public Date getNgayHoan() {
		return this.ngayHoan;
	}

	public void setNgayHoan(Date ngayHoan) {
		this.ngayHoan = ngayHoan;
	}

	public Date getNgayBatDauLai() {
		return this.ngayBatDauLai;
	}

	public void setNgayBatDauLai(Date ngayBatDauLai) {
		this.ngayBatDauLai = ngayBatDauLai;
	}

	public String getLyDoHoan() {
		return this.lyDoHoan;
	}

	public void setLyDoHoan(String lyDoHoan) {
		this.lyDoHoan = lyDoHoan;
	}

	public String getVbXinHoanCuaDvDuocTtkt() {
		return this.vbXinHoanCuaDvDuocTtkt;
	}

	public void setVbXinHoanCuaDvDuocTtkt(String vbXinHoanCuaDvDuocTtkt) {
		this.vbXinHoanCuaDvDuocTtkt = vbXinHoanCuaDvDuocTtkt;
	}

	public String getVbTraLoiCuaDvTh() {
		return this.vbTraLoiCuaDvTh;
	}

	public void setVbTraLoiCuaDvTh(String vbTraLoiCuaDvTh) {
		this.vbTraLoiCuaDvTh = vbTraLoiCuaDvTh;
	}

	public Boolean getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public Date getNgayBatDauThucTe() {
		return this.ngayBatDauThucTe;
	}

	public void setNgayBatDauThucTe(Date ngayBatDauThucTe) {
		this.ngayBatDauThucTe = ngayBatDauThucTe;
	}

	public String getIdVbXinHoan() {
		return this.idVbXinHoan;
	}

	public void setIdVbXinHoan(String idVbXinHoan) {
		this.idVbXinHoan = idVbXinHoan;
	}

	public String getIdVbTraLoi() {
		return this.idVbTraLoi;
	}

	public void setIdVbTraLoi(String idVbTraLoi) {
		this.idVbTraLoi = idVbTraLoi;
	}

	public String getIdVbThongBaoHoan() {
		return idVbThongBaoHoan;
	}

	public void setIdVbThongBaoHoan(String idVbThongBaoHoan) {
		this.idVbThongBaoHoan = idVbThongBaoHoan;
	}

	public String getLoaiFileThongBaoHoan() {
		return loaiFileThongBaoHoan;
	}

	public void setLoaiFileThongBaoHoan(String loaiFileThongBaoHoan) {
		this.loaiFileThongBaoHoan = loaiFileThongBaoHoan;
	}

	public String getTenFileThongBaoHoan() {
		return tenFileThongBaoHoan;
	}

	public void setTenFileThongBaoHoan(String tenFileThongBaoHoan) {
		this.tenFileThongBaoHoan = tenFileThongBaoHoan;
	}

	public String getVbThongBaoHoan() {
		return vbThongBaoHoan;
	}

	public void setVbThongBaoHoan(String vbThongBaoHoan) {
		this.vbThongBaoHoan = vbThongBaoHoan;
	}

}