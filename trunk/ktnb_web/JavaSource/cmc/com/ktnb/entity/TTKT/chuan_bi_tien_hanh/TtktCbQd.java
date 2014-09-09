package cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh;

import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * KtnbQd entity. @author MyEclipse Persistence Tools
 */

public class TtktCbQd extends PersistentObject implements java.io.Serializable{

	// Fields

	private String id;
	private String idCuocTtkt;
	private String soQuyetDinh;
	private String diaDiemRaQuyetDinh;
	private Date ngayRaQuyetDnh;
	private String thuTruongCacDvLienQuan;
	
	private String vanBanQuyDinhCnangNvuQd;
	private String idNguoiChiDaoGiamSat;
	private String tenNguoiChiDaoGiamSat;
	private String chucVuNguoiChiDaoGiamSat;
	private String vanBanKeHoach;

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
	public TtktCbQd() {
	}

	/** full constructor */
	public TtktCbQd(String id, String idCuocTtkt, String soQuyetDinh,
			String diaDiemRaQuyetDinh, Date ngayRaQuyetDnh) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.soQuyetDinh = soQuyetDinh;
		this.diaDiemRaQuyetDinh = diaDiemRaQuyetDinh;
		this.ngayRaQuyetDnh = ngayRaQuyetDnh;
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

	public String getSoQuyetDinh() {
		return this.soQuyetDinh;
	}

	public void setSoQuyetDinh(String soQuyetDinh) {
		this.soQuyetDinh = soQuyetDinh;
	}

	public String getDiaDiemRaQuyetDinh() {
		return this.diaDiemRaQuyetDinh;
	}

	public void setDiaDiemRaQuyetDinh(String diaDiemRaQuyetDinh) {
		this.diaDiemRaQuyetDinh = diaDiemRaQuyetDinh;
	}

	public Date getNgayRaQuyetDnh() {
		return this.ngayRaQuyetDnh;
	}

	public void setNgayRaQuyetDnh(Date ngayRaQuyetDnh) {
		this.ngayRaQuyetDnh = ngayRaQuyetDnh;
	}

	/**
	 * @return
	 */
	public String getThuTruongCacDvLienQuan() {
		return thuTruongCacDvLienQuan;
	}

	/**
	 * @param string
	 */
	public void setThuTruongCacDvLienQuan(String string) {
		thuTruongCacDvLienQuan = string;
	}

	/**
	 * @return
	 */
	public String getChucVuNguoiChiDaoGiamSat() {
		return chucVuNguoiChiDaoGiamSat;
	}

	/**
	 * @return
	 */
	public String getIdNguoiChiDaoGiamSat() {
		return idNguoiChiDaoGiamSat;
	}

	/**
	 * @return
	 */
	public String getTenNguoiChiDaoGiamSat() {
		return tenNguoiChiDaoGiamSat;
	}

	/**
	 * @return
	 */
	public String getVanBanQuyDinhCnangNvuQd() {
		return vanBanQuyDinhCnangNvuQd;
	}

	/**
	 * @param string
	 */
	public void setChucVuNguoiChiDaoGiamSat(String string) {
		chucVuNguoiChiDaoGiamSat = string;
	}

	/**
	 * @param string
	 */
	public void setIdNguoiChiDaoGiamSat(String string) {
		idNguoiChiDaoGiamSat = string;
	}

	/**
	 * @param string
	 */
	public void setTenNguoiChiDaoGiamSat(String string) {
		tenNguoiChiDaoGiamSat = string;
	}

	/**
	 * @param string
	 */
	public void setVanBanQuyDinhCnangNvuQd(String string) {
		vanBanQuyDinhCnangNvuQd = string;
	}

	/**
	 * @return
	 */
	public String getVanBanKeHoach() {
		return vanBanKeHoach;
	}

	/**
	 * @param string
	 */
	public void setVanBanKeHoach(String string) {
		vanBanKeHoach = string;
	}

}