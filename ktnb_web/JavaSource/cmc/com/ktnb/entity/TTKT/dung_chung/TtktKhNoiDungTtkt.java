package cmc.com.ktnb.entity.TTKT.dung_chung;

import java.util.Collection;
import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * KtnbNoiDungTtkt entity. @author MyEclipse Persistence Tools
 */

public class TtktKhNoiDungTtkt extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idNoiDung;
	private String tenNoiDung;
	private String idCuocTtkt;
	private String idDonViBi;
	private String tenDonViBi;

	private Boolean hinhThuc;
	private String hinhThucStr;
	private Boolean loai;
	private String loaiStr;
	private Date nienDoTuNgay;
	private Date nienDoDenNgay;
	private Byte thoiGianDuKien;
	private String thoiGianDuKienStr;
	private Collection dsChiTietNoiDung;
	private String chiTietNoiDung;
	private String tenChiTietNoiDung;
	private String nienDoTuNgayStr;
	private String nienDoDenNgayStr;
	private Date thoiGianDuKienDenNgay;
	private String thoiGianDuKienDenNgayStr;
	private Date thoiGianDuKienTuNgay;
	private String thoiGianDuKienTuNgayStr;

	// Static field
	public static String Id = "id";
	public static String IdNoiDung = "idNoiDung";
	public static String TenNoiDung = "tenNoiDung";
	public static String IdCuocTtkt = "idCuocTtkt";

	public static final String HinhThuc = "hinhThuc";
	public static final String Loai = "loai";
	public static String NienDoTuNgay = "nienDoTuNgay";
	public static String NienDoDenNgay = "nienDoDenNgay";
	public static String ThoiGianDuKien = "thoiGianDuKien";
	private boolean active = false;

	// Constructors

	/** default constructor */
	public TtktKhNoiDungTtkt() {
	}

	/** full constructor */
	public TtktKhNoiDungTtkt(
		String id,
		String idNoiDung,
		String tenNoiDung,
		String idCuocTtkt,
		String idNoiDungChiTiet,
		String tenNoiDungChiTiet,
		Boolean hinhThuc,
		Boolean loai,
		Date nienDoTuNgay,
		Date nienDoDenNgay,
		Byte thoiGianDuKien) {
		this.id = id;
		this.idNoiDung = idNoiDung;
		this.tenNoiDung = tenNoiDung;
		this.idCuocTtkt = idCuocTtkt;

		this.hinhThuc = hinhThuc;
		this.loai = loai;
		this.nienDoTuNgay = nienDoTuNgay;
		this.nienDoDenNgay = nienDoDenNgay;
		this.thoiGianDuKien = thoiGianDuKien;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdNoiDung() {
		return this.idNoiDung;
	}

	public void setIdNoiDung(String idNoiDung) {
		this.idNoiDung = idNoiDung;
	}

	public String getTenNoiDung() {
		return this.tenNoiDung;
	}

	public void setTenNoiDung(String tenNoiDung) {
		this.tenNoiDung = tenNoiDung;
	}

	public String getIdCuocTtkt() {
		return this.idCuocTtkt;
	}

	public void setIdCuocTtkt(String idCuocTtkt) {
		this.idCuocTtkt = idCuocTtkt;
	}

	public Boolean getHinhThuc() {
		return this.hinhThuc;
	}

	public void setHinhThuc(Boolean hinhThuc) {
		this.hinhThuc = hinhThuc;
	}

	public Boolean getLoai() {
		return this.loai;
	}

	public void setLoai(Boolean loai) {
		this.loai = loai;
	}

	public Date getNienDoTuNgay() {
		return this.nienDoTuNgay;
	}

	public void setNienDoTuNgay(Date nienDoTuNgay) {
		this.nienDoTuNgay = nienDoTuNgay;
	}

	public Date getNienDoDenNgay() {
		return this.nienDoDenNgay;
	}

	public void setNienDoDenNgay(Date nienDoDenNgay) {
		this.nienDoDenNgay = nienDoDenNgay;
	}

	public Byte getThoiGianDuKien() {
		return this.thoiGianDuKien;
	}

	public void setThoiGianDuKien(Byte thoiGianDuKien) {
		this.thoiGianDuKien = thoiGianDuKien;
	}

	/**
	 * @return
	 */
	public Collection getDsChiTietNoiDung() {
		return dsChiTietNoiDung;
	}

	/**
	 * @param collection
	 */
	public void setDsChiTietNoiDung(Collection collection) {
		dsChiTietNoiDung = collection;
	}

	/**
	 * @return
	 */
	public String getChiTietNoiDung() {
		return chiTietNoiDung;
	}

	

	
	/**
	 * @param string
	 */
	public static void setNienDoDenNgay(String string) {
		NienDoDenNgay = string;
	}

	/**
	 * @param string
	 */
	public static void setNienDoTuNgay(String string) {
		NienDoTuNgay = string;
	}

	/**
	 * @param string
	 */
	public static void setThoiGianDuKien(String string) {
		ThoiGianDuKien = string;
	}

	/**
	 * @param string
	 */
	public void setChiTietNoiDung(String string) {
		chiTietNoiDung = string;
	}

	/**
	 * @return
	 */
	public String getIdDonViBi() {
		return idDonViBi;
	}

	/**
	 * @return
	 */
	public String getTenDonViBi() {
		return tenDonViBi;
	}

	/**
	 * @param string
	 */
	public void setIdDonViBi(String string) {
		idDonViBi = string;
	}

	/**
	 * @param string
	 */
	public void setTenDonViBi(String string) {
		tenDonViBi = string;
	}

	/**
	 * @return
	 */
	public String getTenChiTietNoiDung() {
		return tenChiTietNoiDung;
	}

	/**
	 * @param string
	 */
	public void setTenChiTietNoiDung(String string) {
		tenChiTietNoiDung = string;
	}

	/**
	 * @return
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param b
	 */
	public void setActive(boolean b) {
		active = b;
	}

	/**
	 * @return
	 */
	public String getNienDoDenNgayStr() {
		return nienDoDenNgayStr;
	}

	/**
	 * @return
	 */
	public String getNienDoTuNgayStr() {
		return nienDoTuNgayStr;
	}

	/**
	 * @param string
	 */
	public void setNienDoDenNgayStr(String string) {
		nienDoDenNgayStr = string;
	}

	/**
	 * @param string
	 */
	public void setNienDoTuNgayStr(String string) {
		nienDoTuNgayStr = string;
	}

	/**
	 * @return
	 */
	public Date getThoiGianDuKienDenNgay() {
		return thoiGianDuKienDenNgay;
	}

	/**
	 * @return
	 */
	public String getThoiGianDuKienDenNgayStr() {
		return thoiGianDuKienDenNgayStr;
	}

	/**
	 * @return
	 */
	public Date getThoiGianDuKienTuNgay() {
		return thoiGianDuKienTuNgay;
	}

	/**
	 * @return
	 */
	public String getThoiGianDuKienTuNgayStr() {
		return thoiGianDuKienTuNgayStr;
	}

	/**
	 * @param date
	 */
	public void setThoiGianDuKienDenNgay(Date date) {
		thoiGianDuKienDenNgay = date;
	}

	/**
	 * @param string
	 */
	public void setThoiGianDuKienDenNgayStr(String string) {
		thoiGianDuKienDenNgayStr = string;
	}

	/**
	 * @param date
	 */
	public void setThoiGianDuKienTuNgay(Date date) {
		thoiGianDuKienTuNgay = date;
	}

	/**
	 * @param string
	 */
	public void setThoiGianDuKienTuNgayStr(String string) {
		thoiGianDuKienTuNgayStr = string;
	}

	/**
	 * @return
	 */
	public String getHinhThucStr() {
		return hinhThucStr;
	}

	/**
	 * @return
	 */
	public String getLoaiStr() {
		return loaiStr;
	}

	/**
	 * @param string
	 */
	public void setHinhThucStr(String string) {
		hinhThucStr = string;
	}

	/**
	 * @param string
	 */
	public void setLoaiStr(String string) {
		loaiStr = string;
	}

	/**
	 * @return
	 */
	public String getThoiGianDuKienStr() {
		return thoiGianDuKienStr;
	}

	/**
	 * @param string
	 */
	public void setThoiGianDuKienStr(String string) {
		thoiGianDuKienStr = string;
	}

}