package cmc.com.ktnb.entity.TTKT.dung_chung;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktCmThayDoiTvd entity. @author MyEclipse Persistence Tools
 */

public class TtktCmThayDoiTvd extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idCuocTtkt;
	private String loaiThayDoi;
	private String soQd;
	private String noiRaQd;
	private Date ngayRaQd;
	private String vbanQdinhCnangNvu;
	private String idNguoiDeNghi;
	private String tenNguoiDeNghi;
	private String chucVuNguoiDeNghi;
	private Date ngayThoiThamGia;
	private Date ngayBanGiao;
	private Date ngayBdauCuaTvienMoi;
	private String danhSachThayDoi;
	private String idDstvCu;
	private String idDstvMoi;
	private String dvCnCoLquan;
	private String canCuQdinh;
	private String canCuLuatSo;
	
	private TtktCmThayDoiThemMoiTvd[] chiTietThayDoi;
	
	// Static fields
	public static final String IdCuocTtkt = "idCuocTtkt";
	public static final String SoQd = "soQd";
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
	public TtktCmThayDoiTvd() {
	}

	/** minimal constructor */
	public TtktCmThayDoiTvd(String id, String idCuocTtkt, String loaiThayDoi,
			String soQd, String noiRaQd, Date ngayRaQd,
			String vbanQdinhCnangNvu, String idNguoiDeNghi,
			String tenNguoiDeNghi, String chucVuNguoiDeNghi, String canCuLuatSo, String canCuQdinh) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.loaiThayDoi = loaiThayDoi;
		this.soQd = soQd;
		this.noiRaQd = noiRaQd;
		this.ngayRaQd = ngayRaQd;
		this.vbanQdinhCnangNvu = vbanQdinhCnangNvu;
		this.idNguoiDeNghi = idNguoiDeNghi;
		this.tenNguoiDeNghi = tenNguoiDeNghi;
		this.chucVuNguoiDeNghi = chucVuNguoiDeNghi;
		this.canCuLuatSo = canCuLuatSo;
		this.canCuQdinh = canCuQdinh;
	}

	/** full constructor */
	public TtktCmThayDoiTvd(String id, String idCuocTtkt, String loaiThayDoi,
			String soQd, String noiRaQd, Date ngayRaQd,
			String vbanQdinhCnangNvu, String idNguoiDeNghi,
			String tenNguoiDeNghi, String chucVuNguoiDeNghi,
			Date ngayThoiThamGia, Date ngayBanGiao, Date ngayBdauCuaTvienMoi,
			String danhSachThayDoi, String canCuLuatSo, String canCuQdinh) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.loaiThayDoi = loaiThayDoi;
		this.soQd = soQd;
		this.noiRaQd = noiRaQd;
		this.ngayRaQd = ngayRaQd;
		this.vbanQdinhCnangNvu = vbanQdinhCnangNvu;
		this.idNguoiDeNghi = idNguoiDeNghi;
		this.tenNguoiDeNghi = tenNguoiDeNghi;
		this.chucVuNguoiDeNghi = chucVuNguoiDeNghi;
		this.ngayThoiThamGia = ngayThoiThamGia;
		this.ngayBanGiao = ngayBanGiao;
		this.ngayBdauCuaTvienMoi = ngayBdauCuaTvienMoi;
		this.danhSachThayDoi = danhSachThayDoi;
		this.canCuLuatSo = canCuLuatSo;
		this.canCuQdinh = canCuQdinh;
	}

	// Property accessors

	public TtktCmThayDoiTvd(String soQd, String ngayRaQd, String loaiThayDoi) {
		this.soQd = soQd;
		this.noiRaQd = ngayRaQd;
		this.loaiThayDoi = loaiThayDoi;
	}

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

	public String getLoaiThayDoi() {
		return this.loaiThayDoi;
	}

	public void setLoaiThayDoi(String loaiThayDoi) {
		this.loaiThayDoi = loaiThayDoi;
	}

	public String getSoQd() {
		return this.soQd;
	}

	public void setSoQd(String soQd) {
		this.soQd = soQd;
	}

	public String getNoiRaQd() {
		return this.noiRaQd;
	}

	public void setNoiRaQd(String noiRaQd) {
		this.noiRaQd = noiRaQd;
	}

	public Date getNgayRaQd() {
		return this.ngayRaQd;
	}

	public void setNgayRaQd(Date ngayRaQd) {
		this.ngayRaQd = ngayRaQd;
	}

	public String getVbanQdinhCnangNvu() {
		return this.vbanQdinhCnangNvu;
	}

	public void setVbanQdinhCnangNvu(String vbanQdinhCnangNvu) {
		this.vbanQdinhCnangNvu = vbanQdinhCnangNvu;
	}

	public String getIdNguoiDeNghi() {
		return this.idNguoiDeNghi;
	}

	public void setIdNguoiDeNghi(String idNguoiDeNghi) {
		this.idNguoiDeNghi = idNguoiDeNghi;
	}

	public String getTenNguoiDeNghi() {
		return this.tenNguoiDeNghi;
	}

	public void setTenNguoiDeNghi(String tenNguoiDeNghi) {
		this.tenNguoiDeNghi = tenNguoiDeNghi;
	}

	public String getChucVuNguoiDeNghi() {
		return this.chucVuNguoiDeNghi;
	}

	public void setChucVuNguoiDeNghi(String chucVuNguoiDeNghi) {
		this.chucVuNguoiDeNghi = chucVuNguoiDeNghi;
	}

	public Date getNgayThoiThamGia() {
		return this.ngayThoiThamGia;
	}

	public void setNgayThoiThamGia(Date ngayThoiThamGia) {
		this.ngayThoiThamGia = ngayThoiThamGia;
	}

	public Date getNgayBanGiao() {
		return this.ngayBanGiao;
	}

	public void setNgayBanGiao(Date ngayBanGiao) {
		this.ngayBanGiao = ngayBanGiao;
	}

	public Date getNgayBdauCuaTvienMoi() {
		return this.ngayBdauCuaTvienMoi;
	}

	public void setNgayBdauCuaTvienMoi(Date ngayBdauCuaTvienMoi) {
		this.ngayBdauCuaTvienMoi = ngayBdauCuaTvienMoi;
	}

	public String getDanhSachThayDoi() {
		return this.danhSachThayDoi;
	}

	public void setDanhSachThayDoi(String danhSachThayDoi) {
		this.danhSachThayDoi = danhSachThayDoi;
	}

	

	public String getCanCuLuatSo() {
		return canCuLuatSo;
	}

	public void setCanCuLuatSo(String canCuLuatSo) {
		this.canCuLuatSo = canCuLuatSo;
	}

	public String getCanCuQdinh() {
		return canCuQdinh;
	}

	public void setCanCuQdinh(String canCuQdinh) {
		this.canCuQdinh = canCuQdinh;
	}

	/**
	 * @return
	 */
	public TtktCmThayDoiThemMoiTvd[] getChiTietThayDoi() {
		return chiTietThayDoi;
	}

	/**
	 * @param tvds
	 */
	public void setChiTietThayDoi(TtktCmThayDoiThemMoiTvd[] tvds) {
		chiTietThayDoi = tvds;
	}

	/**
	 * @return
	 */
	public String getIdDstvCu() {
		return idDstvCu;
	}

	/**
	 * @return
	 */
	public String getIdDstvMoi() {
		return idDstvMoi;
	}

	/**
	 * @param string
	 */
	public void setIdDstvCu(String string) {
		idDstvCu = string;
	}

	/**
	 * @param string
	 */
	public void setIdDstvMoi(String string) {
		idDstvMoi = string;
	}

	public String getDvCnCoLquan() {
		return dvCnCoLquan;
	}

	public void setDvCnCoLquan(String dvCnCoLquan) {
		this.dvCnCoLquan = dvCnCoLquan;
	}

}