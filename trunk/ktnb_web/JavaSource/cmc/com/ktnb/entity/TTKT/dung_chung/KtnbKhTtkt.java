package cmc.com.ktnb.entity.TTKT.dung_chung;

import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * KtnbKhTtkt entity. @author MyEclipse Persistence Tools
 */

public class KtnbKhTtkt
	extends PersistentObject
	implements java.io.Serializable {

	// Fields

	private String id;
	private String maKhTtkt;
	private String idDonViBi;
	private String idDonViTh;
	private String nienDoTtkt;
	private Short thoiGianDuKien;
	// Loai thanh tra hay kiem tra
	private Long hinhThuc;
	// Dot xuat hay dinh ky
	private Long loai;
	private String ghiChu;
	private String idCanBo;
	private String idDonVi;
	private String pathOwner;

	private Date nienDoTuNgay;
	private Date nienDoDenNgay;
	private String donViBiName;
	private String donViThName;

	// Constructors

	/** default constructor */
	public KtnbKhTtkt() {
	}

	/** minimal constructor */
	public KtnbKhTtkt(
		String id,
		String maKhTtkt,
		String idDonViBi,
		String idDonViTh,
		String nienDoTtkt,
		Short thoiGianDuKien,
		Long idDmPhanLoai,
		String idCanBo,
		String idDonVi) {
		this.id = id;
		this.maKhTtkt = maKhTtkt;
		this.idDonViBi = idDonViBi;
		this.idDonViTh = idDonViTh;
		this.nienDoTtkt = nienDoTtkt;
		this.thoiGianDuKien = thoiGianDuKien;
		
		this.idCanBo = idCanBo;
		this.idDonVi = idDonVi;
	}

	/** full constructor */
	public KtnbKhTtkt(
		String id,
		String maKhTtkt,
		String idDonViBi,
		String idDonViTh,
		String nienDoTtkt,
		Short thoiGianDuKien,
		Long idDmPhanLoai,
		String ghiChu,
		String idCanBo,
		String idDonVi,
		String pathOwner) {
		this.id = id;
		this.maKhTtkt = maKhTtkt;
		this.idDonViBi = idDonViBi;
		this.idDonViTh = idDonViTh;
		this.nienDoTtkt = nienDoTtkt;
		this.thoiGianDuKien = thoiGianDuKien;
		
		this.ghiChu = ghiChu;
		this.idCanBo = idCanBo;
		this.idDonVi = idDonVi;
		this.pathOwner = pathOwner;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaKhTtkt() {
		return this.maKhTtkt;
	}

	public void setMaKhTtkt(String maKhTtkt) {
		this.maKhTtkt = maKhTtkt;
	}

	public String getIdDonViBi() {
		return this.idDonViBi;
	}

	public void setIdDonViBi(String idDonViBi) {
		this.idDonViBi = idDonViBi;
	}

	public String getIdDonViTh() {
		return this.idDonViTh;
	}

	public void setIdDonViTh(String idDonViTh) {
		this.idDonViTh = idDonViTh;
	}

	public String getNienDoTtkt() {
		return this.nienDoTtkt;
	}

	public void setNienDoTtkt(String nienDoTtkt) {
		this.nienDoTtkt = nienDoTtkt;
	}

	public Short getThoiGianDuKien() {
		return this.thoiGianDuKien;
	}

	public void setThoiGianDuKien(Short thoiGianDuKien) {
		this.thoiGianDuKien = thoiGianDuKien;
	}

	
	public String getGhiChu() {
		return this.ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	

	public void setIdCanBo(String idCanBo) {
		this.idCanBo = idCanBo;
	}

	public String getIdDonVi() {
		return this.idDonVi;
	}

	public void setIdDonVi(String idDonVi) {
		this.idDonVi = idDonVi;
	}

	public String getPathOwner() {
		return this.pathOwner;
	}

	public void setPathOwner(String pathOwner) {
		this.pathOwner = pathOwner;
	}

	

	/**
	 * @return
	 */
	public String getDonViBiName() {
		return donViBiName;
	}

	/**
	 * @return
	 */
	public String getDonViThName() {
		return donViThName;
	}

	/**
	 * @param string
	 */
	public void setDonViBiName(String string) {
		donViBiName = string;
	}

	/**
	 * @param string
	 */
	public void setDonViThName(String string) {
		donViThName = string;
	}

	/**
	 * @return
	 */
	public Date getNienDoDenNgay() {
		return nienDoDenNgay;
	}

	/**
	 * @return
	 */
	public Date getNienDoTuNgay() {
		return nienDoTuNgay;
	}

	/**
	 * @param date
	 */
	public void setNienDoDenNgay(Date date) {
		nienDoDenNgay = date;
	}

	/**
	 * @param date
	 */
	public void setNienDoTuNgay(Date date) {
		nienDoTuNgay = date;
	}

	/**
	 * @return
	 */
	public Long getHinhThuc() {
		return hinhThuc;
	}

	/**
	 * @return
	 */
	public String getIdCanBo() {
		return idCanBo;
	}

	/**
	 * @return
	 */
	public Long getLoai() {
		return loai;
	}

	/**
	 * @param long1
	 */
	public void setHinhThuc(Long long1) {
		hinhThuc = long1;
	}

	/**
	 * @param long1
	 */
	public void setLoai(Long long1) {
		loai = long1;
	}

}