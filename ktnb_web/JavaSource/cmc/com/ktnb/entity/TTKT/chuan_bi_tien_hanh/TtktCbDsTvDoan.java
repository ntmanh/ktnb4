package cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;



import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * KtnbDsTvd entity. @author MyEclipse Persistence Tools
 */

public class TtktCbDsTvDoan extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idCuocTtkt;
	private Date ngayLap;
	private String noiLap;
	private String noiPheDuyet;
	private Date ngayPheDuyet;
	private String ykienPheDuyet;
	private Collection ChiTietDanhSachTV;
	private String idDsTvdCu;
	private Boolean isNew;
	private String vanBanQuyDinhCnangNvuQdTvd;
	
	
	
	
	public static final String IdCuocTtkt = "idCuocTtkt";
	
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
	public TtktCbDsTvDoan() {
	}

	/** full constructor */
	public TtktCbDsTvDoan(String id, String idCuocTtkt, Date ngayLap, String noiLap) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.ngayLap = ngayLap;
		this.noiLap = noiLap;
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

	public Date getNgayLap() {
		return this.ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getNoiLap() {
		return this.noiLap;
	}

	public void setNoiLap(String noiLap) {
		this.noiLap = noiLap;
	}

	/**
	 * @return
	 */
	public Collection getChiTietDanhSachTV() {
		return ChiTietDanhSachTV;
	}

	/**
	 * @param list
	 */
	public void setChiTietDanhSachTV(Collection list) {
		ChiTietDanhSachTV = list;
	}


	/**
	 * @return
	 */
	public Date getNgayPheDuyet() {
		return ngayPheDuyet;
	}

	/**
	 * @return
	 */
	public String getNoiPheDuyet() {
		return noiPheDuyet;
	}

	

	/**
	 * @param string
	 */
	public void setNgayPheDuyet(Date date) {
		ngayPheDuyet = date;
	}

	/**
	 * @param string
	 */
	public void setNoiPheDuyet(String string) {
		noiPheDuyet = string;
	}

	
	/**
	 * @return
	 */
	public String getYkienPheDuyet() {
		return ykienPheDuyet;
	}

	/**
	 * @param string
	 */
	public void setYkienPheDuyet(String string) {
		ykienPheDuyet = string;
	}

	

	/**
	 * @return
	 */
	public String getIdDsTvdCu() {
		return idDsTvdCu;
	}

	

	/**
	 * @param string
	 */
	public void setIdDsTvdCu(String string) {
		idDsTvdCu = string;
	}

	

	/**
	 * @return
	 */
	public Boolean getIsNew() {
		return isNew;
	}

	/**
	 * @param boolean1
	 */
	public void setIsNew(Boolean boolean1) {
		isNew = boolean1;
	}

	

	/**
	 * @return
	 */
	public String getVanBanQuyDinhCnangNvuQdTvd() {
		return vanBanQuyDinhCnangNvuQdTvd;
	}

	/**
	 * @param string
	 */
	public void setVanBanQuyDinhCnangNvuQdTvd(String string) {
		vanBanQuyDinhCnangNvuQdTvd = string;
	}

}