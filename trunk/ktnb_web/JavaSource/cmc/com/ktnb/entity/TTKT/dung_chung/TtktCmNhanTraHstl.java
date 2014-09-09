package cmc.com.ktnb.entity.TTKT.dung_chung;

import java.util.Collection;
import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktThNhanTraHstl entity. @author MyEclipse Persistence Tools
 */

public class TtktCmNhanTraHstl extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idTdYcBsHstl; 
	private Date thoiDiemNhanTra;
	private String baoCao;
	private String hoSo;
	private String idDaiDienBenGiao;
	private String idDaiDienBenNhan;
	private String loai;
	private Date thoiDiemBatDau;
	private Date thoiDiemKetThuc;
	private String diaDiemBanGiao;
	private Collection daiDienBenGiao;
	private Collection daiDienBenNhan;
	private String idCuocTtkt; 
	private String idDsTvd;
	
	
	// Static fiels
	public static final String IdTdYcBsHstl = "idTdYcBsHstl";
	public static final String IdCuocTtkt = "idCuocTtkt";
	public static final String Loai = "loai";

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
	// Constructors

	/** default constructor */
	public TtktCmNhanTraHstl() {
	}

	/** minimal constructor */
	public TtktCmNhanTraHstl(String id, String idTdYcBsHstl,
			Date thoiDiemNhanTra, String idDaiDienBenGiao,
			String idDaiDienBenNhan, String loai) {
		this.id = id;
		this.idTdYcBsHstl = idTdYcBsHstl;
		this.thoiDiemNhanTra = thoiDiemNhanTra;
		this.idDaiDienBenGiao = idDaiDienBenGiao;
		this.idDaiDienBenNhan = idDaiDienBenNhan;
		this.loai = loai;
	}

	/** full constructor */
	public TtktCmNhanTraHstl(String id, String idTdYcBsHstl,
			Date thoiDiemNhanTra, String baoCao, String hoSo,
			String idDaiDienBenGiao, String idDaiDienBenNhan, String loai) {
		this.id = id;
		this.idTdYcBsHstl = idTdYcBsHstl;
		this.thoiDiemNhanTra = thoiDiemNhanTra;
		this.baoCao = baoCao;
		this.hoSo = hoSo;
		this.idDaiDienBenGiao = idDaiDienBenGiao;
		this.idDaiDienBenNhan = idDaiDienBenNhan;
		this.loai = loai;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public Date getThoiDiemNhanTra() {
		return this.thoiDiemNhanTra;
	}

	public void setThoiDiemNhanTra(Date thoiDiemNhanTra) {
		this.thoiDiemNhanTra = thoiDiemNhanTra;
	}

	public String getBaoCao() {
		return this.baoCao;
	}

	public void setBaoCao(String baoCao) {
		this.baoCao = baoCao;
	}

	public String getHoSo() {
		return this.hoSo;
	}

	public void setHoSo(String hoSo) {
		this.hoSo = hoSo;
	}

	public String getIdDaiDienBenGiao() {
		return this.idDaiDienBenGiao;
	}

	public void setIdDaiDienBenGiao(String idDaiDienBenGiao) {
		this.idDaiDienBenGiao = idDaiDienBenGiao;
	}

	public String getIdDaiDienBenNhan() {
		return this.idDaiDienBenNhan;
	}

	public void setIdDaiDienBenNhan(String idDaiDienBenNhan) {
		this.idDaiDienBenNhan = idDaiDienBenNhan;
	}

	

	/**
	 * @return
	 */
	public String getIdTdYcBsHstl() {
		return idTdYcBsHstl;
	}

	/**
	 * @return
	 */
	public Date getThoiDiemBatDau() {
		return thoiDiemBatDau;
	}

	/**
	 * @return
	 */
	public Date getThoiDiemKetThuc() {
		return thoiDiemKetThuc;
	}

	/**
	 * @param string
	 */
	public void setIdTdYcBsHstl(String string) {
		idTdYcBsHstl = string;
	}

	/**
	 * @param date
	 */
	public void setThoiDiemBatDau(Date date) {
		thoiDiemBatDau = date;
	}

	/**
	 * @param date
	 */
	public void setThoiDiemKetThuc(Date date) {
		thoiDiemKetThuc = date;
	}

	/**
	 * @return
	 */
	public String getDiaDiemBanGiao() {
		return diaDiemBanGiao;
	}

	/**
	 * @param string
	 */
	public void setDiaDiemBanGiao(String string) {
		diaDiemBanGiao = string;
	}

	/**
	 * @return
	 */
	public String getLoai() {
		return loai;
	}

	/**
	 * @param string
	 */
	public void setLoai(String string) {
		loai = string;
	}

	/**
	 * @return
	 */
	public Collection getDaiDienBenGiao() {
		return daiDienBenGiao;
	}

	/**
	 * @return
	 */
	public Collection getDaiDienBenNhan() {
		return daiDienBenNhan;
	}

	/**
	 * @param collection
	 */
	public void setDaiDienBenGiao(Collection collection) {
		daiDienBenGiao = collection;
	}

	/**
	 * @param collection
	 */
	public void setDaiDienBenNhan(Collection collection) {
		daiDienBenNhan = collection;
	}

	

	/**
	 * @param string
	 */
	public void setIdCuocTtkt(String string) {
		idCuocTtkt = string;
	}

	/**
	 * @return
	 */
	public String getIdCuocTtkt() {
		return idCuocTtkt;
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