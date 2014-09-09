package cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * KtnbChiTietDsTvd entity. @author MyEclipse Persistence Tools
 */

public class TtktCbChiTietDsTvDoan extends PersistentObject implements java.io.Serializable {

	// Fields

	/**
	 * @param idCanBo
	 * @param tenCanBo
	 * @param chucVuTrongDoan
	 */
	public TtktCbChiTietDsTvDoan(String idCanBo, String tenCanBo, String chucVu, String donViCongTac, String chucVuTrongDoan) {
		this.idCanBo = idCanBo;
		this.tenCanBo = tenCanBo;
		this.chucVu = chucVu;
		this.tenPhong = donViCongTac;
		this.chucVuTrongDoan = chucVuTrongDoan;
	}

	private String id;
	private String idDsTvd;
	private String idCanBo;
	private String tenCanBo;
	private String idPhong;
	private String tenPhong;
	private String idCqt;
	private String tenCqt;
	private String chucVu;
	private String chucVuTrongDoan;
	private String ykien;

	// Static field
	public static final String Id = "id";
	public static final String IdDsTvd = "idDsTvd";
	public static final String IdCanBo = "idCanBo";
	public static final String TenCanBo = "tenCanBo";
	public static final String IdPhong = "idPhong";
	public static final String TenPhong = "tenPhong";
	public static final String IdCqt = "idCqt";
	public static final String TenCqt = "tenCqt";
	public static final String ChucVu = "chucVu";
	public static final String ChucVuTrongDoan = "chucVuTrongDoan";

	// Constructors

	/** default constructor */
	public TtktCbChiTietDsTvDoan() {
	}

	/** minimal constructor */
	public TtktCbChiTietDsTvDoan(String id, String idDsTvd, String idCanBo, String tenCanBo) {
		this.id = id;
		this.idDsTvd = idDsTvd;
		this.idCanBo = idCanBo;
		this.tenCanBo = tenCanBo;
	}

	/** full constructor */
	public TtktCbChiTietDsTvDoan(String id, String idDsTvd, String idCanBo, String tenCanBo, String idPhong, String tenPhong, String idCqt, String tenCqt, String chucVu, String chucVuTrongDoan) {
		this.id = id;
		this.idDsTvd = idDsTvd;
		this.idCanBo = idCanBo;
		this.tenCanBo = tenCanBo;
		this.idPhong = idPhong;
		this.tenPhong = tenPhong;
		this.idCqt = idCqt;
		this.tenCqt = tenCqt;
		this.chucVu = chucVu;
		this.chucVuTrongDoan = chucVuTrongDoan;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdDsTvd() {
		return this.idDsTvd;
	}

	public void setIdDsTvd(String idDsTvd) {
		this.idDsTvd = idDsTvd;
	}

	public String getIdCanBo() {
		return this.idCanBo;
	}

	public void setIdCanBo(String idCanBo) {
		this.idCanBo = idCanBo;
	}

	public String getTenCanBo() {
		return this.tenCanBo;
	}

	public void setTenCanBo(String tenCanBo) {
		this.tenCanBo = tenCanBo;
	}

	public String getIdPhong() {
		return this.idPhong;
	}

	public void setIdPhong(String idPhong) {
		this.idPhong = idPhong;
	}

	public String getTenPhong() {
		return this.tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getIdCqt() {
		return this.idCqt;
	}

	public void setIdCqt(String idCqt) {
		this.idCqt = idCqt;
	}

	public String getTenCqt() {
		return this.tenCqt;
	}

	public void setTenCqt(String tenCqt) {
		this.tenCqt = tenCqt;
	}

	public String getChucVu() {
		return this.chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getChucVuTrongDoan() {
		return this.chucVuTrongDoan;
	}

	public void setChucVuTrongDoan(String chucVuTrongDoan) {
		this.chucVuTrongDoan = chucVuTrongDoan;
	}

	public String getYkien() {
		return ykien;
	}

	public void setYkien(String ykien) {
		this.ykien = ykien;
	}

	/**
	 * @return
	 */
	public TtktCbChiTietDsTvDoan copy() {
		TtktCbChiTietDsTvDoan thanhVienMoi = new TtktCbChiTietDsTvDoan();
		thanhVienMoi.setIdCanBo(idCanBo);
		thanhVienMoi.setTenCanBo(tenCanBo);
		thanhVienMoi.setChucVuTrongDoan(chucVuTrongDoan);
		thanhVienMoi.setChucVu(chucVu);
		thanhVienMoi.setIdPhong(idPhong);
		thanhVienMoi.setTenPhong(tenPhong);
		thanhVienMoi.setTenCqt(TenCqt);
		thanhVienMoi.setIdCqt(IdCqt);
		return thanhVienMoi;
	}

}