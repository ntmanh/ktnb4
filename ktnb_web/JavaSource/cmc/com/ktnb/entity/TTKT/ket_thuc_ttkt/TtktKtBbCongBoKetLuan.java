package cmc.com.ktnb.entity.TTKT.ket_thuc_ttkt;

import java.util.Collection;
import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktKtBbCongBoKetLuan entity. @author MyEclipse Persistence Tools
 */

public class TtktKtBbCongBoKetLuan extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idCuocTtkt;
	private String noiLap;
	private Date ngayLap;
	private Date thoiDiemCongBo;
	private String diaDiem;
	private String tpThamDuCqtTienHanh;
	private String tpThamDuDoanTtkt;
	private String tpThamDuDviDuocTtkt;
	private String tpThamDuCquanTchucCnhan;
	private String ykDaiDienCqTienHanh;
	private String ykCqqlCapTrenCuaDtuong;
	private String ykDaiDienCqtBiTtkt;
	private Date thoiDiemKetThuc;
	
	private Collection dsTptdCqtTienHanh;
	private Collection dsTptdDviDuocTtkt;
	private Collection dsTptdCquanTchucCnhan;
	private Collection dsTptdDoanTtkt;

	public static String IdCuocTtkt = "idCuocTtkt";
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
	public TtktKtBbCongBoKetLuan() {
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

	public String getNoiLap() {
		return this.noiLap;
	}

	public void setNoiLap(String noiLap) {
		this.noiLap = noiLap;
	}

	public Date getNgayLap() {
		return this.ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public Date getThoiDiemCongBo() {
		return this.thoiDiemCongBo;
	}

	public void setThoiDiemCongBo(Date thoiDiemCongBo) {
		this.thoiDiemCongBo = thoiDiemCongBo;
	}

	public String getDiaDiem() {
		return this.diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getTpThamDuCqtTienHanh() {
		return this.tpThamDuCqtTienHanh;
	}

	public void setTpThamDuCqtTienHanh(String tpThamDuCqtTienHanh) {
		this.tpThamDuCqtTienHanh = tpThamDuCqtTienHanh;
	}

	public String getTpThamDuDoanTtkt() {
		return this.tpThamDuDoanTtkt;
	}

	public void setTpThamDuDoanTtkt(String tpThamDuDoanTtkt) {
		this.tpThamDuDoanTtkt = tpThamDuDoanTtkt;
	}

	public String getTpThamDuDviDuocTtkt() {
		return this.tpThamDuDviDuocTtkt;
	}

	public void setTpThamDuDviDuocTtkt(String tpThamDuDviDuocTtkt) {
		this.tpThamDuDviDuocTtkt = tpThamDuDviDuocTtkt;
	}

	public String getTpThamDuCquanTchucCnhan() {
		return this.tpThamDuCquanTchucCnhan;
	}

	public void setTpThamDuCquanTchucCnhan(String tpThamDuCquanTchucCnhan) {
		this.tpThamDuCquanTchucCnhan = tpThamDuCquanTchucCnhan;
	}

	public String getYkDaiDienCqTienHanh() {
		return this.ykDaiDienCqTienHanh;
	}

	public void setYkDaiDienCqTienHanh(String ykDaiDienCqTienHanh) {
		this.ykDaiDienCqTienHanh = ykDaiDienCqTienHanh;
	}

	public String getYkCqqlCapTrenCuaDtuong() {
		return this.ykCqqlCapTrenCuaDtuong;
	}

	public void setYkCqqlCapTrenCuaDtuong(String ykCqqlCapTrenCuaDtuong) {
		this.ykCqqlCapTrenCuaDtuong = ykCqqlCapTrenCuaDtuong;
	}

	public String getYkDaiDienCqtBiTtkt() {
		return this.ykDaiDienCqtBiTtkt;
	}

	public void setYkDaiDienCqtBiTtkt(String ykDaiDienCqtBiTtkt) {
		this.ykDaiDienCqtBiTtkt = ykDaiDienCqtBiTtkt;
	}

	/**
	 * @return
	 */
	public Collection getDsTptdCqtTienHanh() {
		return dsTptdCqtTienHanh;
	}

	/**
	 * @return
	 */
	public Collection getDsTptdCquanTchucCnhan() {
		return dsTptdCquanTchucCnhan;
	}

	/**
	 * @return
	 */
	public Collection getDsTptdDoanTtkt() {
		return dsTptdDoanTtkt;
	}

	/**
	 * @return
	 */
	public Collection getDsTptdDviDuocTtkt() {
		return dsTptdDviDuocTtkt;
	}

	/**
	 * @param collection
	 */
	public void setDsTptdCqtTienHanh(Collection collection) {
		dsTptdCqtTienHanh = collection;
	}

	/**
	 * @param collection
	 */
	public void setDsTptdCquanTchucCnhan(Collection collection) {
		dsTptdCquanTchucCnhan = collection;
	}

	/**
	 * @param collection
	 */
	public void setDsTptdDoanTtkt(Collection collection) {
		dsTptdDoanTtkt = collection;
	}

	/**
	 * @param collection
	 */
	public void setDsTptdDviDuocTtkt(Collection collection) {
		dsTptdDviDuocTtkt = collection;
	}




	/**
	 * @return
	 */
	public Date getThoiDiemKetThuc() {
		return thoiDiemKetThuc;
	}

	/**
	 * @param date
	 */
	public void setThoiDiemKetThuc(Date date) {
		thoiDiemKetThuc = date;
	}

}