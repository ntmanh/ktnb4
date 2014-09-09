package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;

import java.util.Collection;
import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktThCongBoQd entity. @author MyEclipse Persistence Tools
 */

public class TtktThCongBoQd extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idCuocTtkt;
	private Date thoiDiemCbTu;
	private Date thoiDiemCbDen;
	private String idDaiDienCqBanHanhQd;
	private String ykienPhatBieu;
	private String diaDiem;
	private String idDaiDienCqqlCapTren;
	private String idDaiDienDoanTtkt;
	private String idDaiDienDonViDuocTtkt;
	private Collection dsDaiDienCqtBanHanhQD;
	private Collection dsDaiDienCqqlCapTren;
	private Collection dsDaiDienDoanTtkt;
	private Collection dsDaiDienDonViDuocTtkt;
	
	// Static field
	public static final String IdCuocTtkt = "idCuocTtkt";

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
	public TtktThCongBoQd() {
	}

	/** minimal constructor */
	public TtktThCongBoQd(String id, String idCuocTtkt, Date thoiDiemCbTu,
			Date thoiDiemCbDen, String diaDiem) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.thoiDiemCbTu = thoiDiemCbTu;
		this.thoiDiemCbDen = thoiDiemCbDen;
		this.diaDiem = diaDiem;
	}

	/** full constructor */
	public TtktThCongBoQd(String id, String idCuocTtkt, Date thoiDiemCbTu,
			Date thoiDiemCbDen, String idDaiDienCqBanHanhQd,
			String ykienPhatBieu, String diaDiem, String idDaiDienCqqlCapTren,
			String idDaiDienDoanTtkt, String idDaiDienDonViDuocTtkt) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.thoiDiemCbTu = thoiDiemCbTu;
		this.thoiDiemCbDen = thoiDiemCbDen;
		this.idDaiDienCqBanHanhQd = idDaiDienCqBanHanhQd;
		this.ykienPhatBieu = ykienPhatBieu;
		this.diaDiem = diaDiem;
		this.idDaiDienCqqlCapTren = idDaiDienCqqlCapTren;
		this.idDaiDienDoanTtkt = idDaiDienDoanTtkt;
		this.idDaiDienDonViDuocTtkt = idDaiDienDonViDuocTtkt;
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

	public Date getThoiDiemCbTu() {
		return this.thoiDiemCbTu;
	}

	public void setThoiDiemCbTu(Date thoiDiemCbTu) {
		this.thoiDiemCbTu = thoiDiemCbTu;
	}

	public Date getThoiDiemCbDen() {
		return this.thoiDiemCbDen;
	}

	public void setThoiDiemCbDen(Date thoiDiemCbDen) {
		this.thoiDiemCbDen = thoiDiemCbDen;
	}

	public String getIdDaiDienCqBanHanhQd() {
		return this.idDaiDienCqBanHanhQd;
	}

	public void setIdDaiDienCqBanHanhQd(String idDaiDienCqBanHanhQd) {
		this.idDaiDienCqBanHanhQd = idDaiDienCqBanHanhQd;
	}

	public String getDiaDiem() {
		return this.diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getIdDaiDienCqqlCapTren() {
		return this.idDaiDienCqqlCapTren;
	}

	public void setIdDaiDienCqqlCapTren(String idDaiDienCqqlCapTren) {
		this.idDaiDienCqqlCapTren = idDaiDienCqqlCapTren;
	}

	public String getIdDaiDienDoanTtkt() {
		return this.idDaiDienDoanTtkt;
	}

	public void setIdDaiDienDoanTtkt(String idDaiDienDoanTtkt) {
		this.idDaiDienDoanTtkt = idDaiDienDoanTtkt;
	}

	public String getIdDaiDienDonViDuocTtkt() {
		return this.idDaiDienDonViDuocTtkt;
	}

	public void setIdDaiDienDonViDuocTtkt(String idDaiDienDonViDuocTtkt) {
		this.idDaiDienDonViDuocTtkt = idDaiDienDonViDuocTtkt;
	}

	/**
	 * @return
	 */
	public Collection getDsDaiDienCqqlCapTren() {
		return dsDaiDienCqqlCapTren;
	}

	/**
	 * @return
	 */
	public Collection getDsDaiDienCqtBanHanhQD() {
		return dsDaiDienCqtBanHanhQD;
	}

	/**
	 * @return
	 */
	public Collection getDsDaiDienDoanTtkt() {
		return dsDaiDienDoanTtkt;
	}

	/**
	 * @return
	 */
	public Collection getDsDaiDienDonViDuocTtkt() {
		return dsDaiDienDonViDuocTtkt;
	}

	/**
	 * @param collection
	 */
	public void setDsDaiDienCqqlCapTren(Collection collection) {
		dsDaiDienCqqlCapTren = collection;
	}

	/**
	 * @param collection
	 */
	public void setDsDaiDienCqtBanHanhQD(Collection collection) {
		dsDaiDienCqtBanHanhQD = collection;
	}

	/**
	 * @param collection
	 */
	public void setDsDaiDienDoanTtkt(Collection collection) {
		dsDaiDienDoanTtkt = collection;
	}

	/**
	 * @param collection
	 */
	public void setDsDaiDienDonViDuocTtkt(Collection collection) {
		dsDaiDienDonViDuocTtkt = collection;
	}

	/**
	 * @return
	 */
	public String getYkienPhatBieu() {
		return ykienPhatBieu;
	}

	/**
	 * @param string
	 */
	public void setYkienPhatBieu(String string) {
		ykienPhatBieu = string;
	}

}