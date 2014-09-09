package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;

import java.util.Date;

import java.util.Collection;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktKtChuyenGiaoHsVv entity. @author MyEclipse Persistence Tools
 */

public class TtktKtChuyenGiaoHsVv extends PersistentObject implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String id;
	private String idCuocTtkt;
	private String diaDiemLapHs;
	private Date thoiGian;
	private String soHs;
	private String tenCqDieuTra;
	private String tomTatHanhViViPham;
	private String hanhViViPham;
	private String chucDanhNguoiKy;
	private Date thoiGianGiaoNhan;
	private String diaDiem;
	private String tpThamDuDoanTtkt;
	private String tpThamDuCqDieuTra;
	private Short soTrang;
	private String baoGomCacTl;
	private Date thoiDiemKetThuc;

	public static String IdCuocTtkt = "idCuocTtkt";
	public static String Id = "id";
	
	private Collection dsDaiDien;
	private Collection dsDaiDienCqDt;
	// Constructors

	/** default constructor */
	public TtktKtChuyenGiaoHsVv() {
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

	public String getDiaDiemLapHs() {
		return this.diaDiemLapHs;
	}

	public void setDiaDiemLapHs(String diaDiemLapHs) {
		this.diaDiemLapHs = diaDiemLapHs;
	}

	public Date getThoiGian() {
		return this.thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getSoHs() {
		return this.soHs;
	}

	public void setSoHs(String soHs) {
		this.soHs = soHs;
	}

	public String getTenCqDieuTra() {
		return this.tenCqDieuTra;
	}

	public void setTenCqDieuTra(String tenCqDieuTra) {
		this.tenCqDieuTra = tenCqDieuTra;
	}

	public String getTomTatHanhViViPham() {
		return this.tomTatHanhViViPham;
	}

	public void setTomTatHanhViViPham(String tomTatHanhViViPham) {
		this.tomTatHanhViViPham = tomTatHanhViViPham;
	}

	public String getHanhViViPham() {
		return this.hanhViViPham;
	}

	public void setHanhViViPham(String hanhViViPham) {
		this.hanhViViPham = hanhViViPham;
	}

	public String getChucDanhNguoiKy() {
		return this.chucDanhNguoiKy;
	}

	public void setChucDanhNguoiKy(String chucDanhNguoiKy) {
		this.chucDanhNguoiKy = chucDanhNguoiKy;
	}

	public Date getThoiGianGiaoNhan() {
		return this.thoiGianGiaoNhan;
	}

	public void setThoiGianGiaoNhan(Date thoiGianGiaoNhan) {
		this.thoiGianGiaoNhan = thoiGianGiaoNhan;
	}

	public String getDiaDiem() {
		return this.diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getTpThamDuDoanTtkt() {
		return this.tpThamDuDoanTtkt;
	}

	public void setTpThamDuDoanTtkt(String tpThamDuDoanTtkt) {
		this.tpThamDuDoanTtkt = tpThamDuDoanTtkt;
	}

	public String getTpThamDuCqDieuTra() {
		return this.tpThamDuCqDieuTra;
	}

	public void setTpThamDuCqDieuTra(String tpThamDuCqDieuTra) {
		this.tpThamDuCqDieuTra = tpThamDuCqDieuTra;
	}

	public Short getSoTrang() {
		return this.soTrang;
	}

	public void setSoTrang(Short soTrang) {
		this.soTrang = soTrang;
	}

	public String getBaoGomCacTl() {
		return this.baoGomCacTl;
	}

	public void setBaoGomCacTl(String baoGomCacTl) {
		this.baoGomCacTl = baoGomCacTl;
	}

	public Date getThoiDiemKetThuc() {
		return this.thoiDiemKetThuc;
	}

	public void setThoiDiemKetThuc(Date thoiDiemKetThuc) {
		this.thoiDiemKetThuc = thoiDiemKetThuc;
	}

	/**
	 * @return
	 */
	public Collection getDsDaiDien() {
		return dsDaiDien;
	}

	/**
	 * @return
	 */
	public Collection getDsDaiDienCqDt() {
		return dsDaiDienCqDt;
	}

	/**
	 * @param collection
	 */
	public void setDsDaiDien(Collection collection) {
		dsDaiDien = collection;
	}

	/**
	 * @param collection
	 */
	public void setDsDaiDienCqDt(Collection collection) {
		dsDaiDienCqDt = collection;
	}



	

}