package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;
import cmc.com.ktnb.pl.hb.entity.PersistentObject;

import java.util.Collection;
import java.util.Date;

/**
 * TtktThBbNiemPhong entity. @author MyEclipse Persistence Tools
 */

public class TtktThBbNiemPhong extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private Date thoiDiemNiemPhong;
	private String diaDiemNiemPhong;
	private String idTpThamDuDoanTtkt;
	private String idTpThamDuDviCnhanCoTs;
	private String taiSanNiemPhong;
	private String tenDviCnhanBaoQuan;
	private Date thoiDiemKetThucNphong;
	private String idDviCnhanBaoQuan;
	private String taiLieuBiNP;
	private String idQuyetDinhNp;
	private Collection dsDoanTtkt;
	private Collection dsDvCoTlNp;
	private String idDsTvd;
	
	public static String IdQuyetDinhNp = "idQuyetDinhNp";

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
	public TtktThBbNiemPhong() {
	}


	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public Date getThoiDiemNiemPhong() {
		return this.thoiDiemNiemPhong;
	}

	public void setThoiDiemNiemPhong(Date thoiDiemNiemPhong) {
		this.thoiDiemNiemPhong = thoiDiemNiemPhong;
	}

	public String getDiaDiemNiemPhong() {
		return this.diaDiemNiemPhong;
	}

	public void setDiaDiemNiemPhong(String diaDiemNiemPhong) {
		this.diaDiemNiemPhong = diaDiemNiemPhong;
	}

	public String getIdTpThamDuDoanTtkt() {
		return this.idTpThamDuDoanTtkt;
	}

	public void setIdTpThamDuDoanTtkt(String idTpThamDuDoanTtkt) {
		this.idTpThamDuDoanTtkt = idTpThamDuDoanTtkt;
	}

	public String getIdTpThamDuDviCnhanCoTs() {
		return this.idTpThamDuDviCnhanCoTs;
	}

	public void setIdTpThamDuDviCnhanCoTs(String idTpThamDuDviCnhanCoTs) {
		this.idTpThamDuDviCnhanCoTs = idTpThamDuDviCnhanCoTs;
	}

	public String getTaiSanNiemPhong() {
		return this.taiSanNiemPhong;
	}

	public void setTaiSanNiemPhong(String taiSanNiemPhong) {
		this.taiSanNiemPhong = taiSanNiemPhong;
	}

	public String getTenDviCnhanBaoQuan() {
		return this.tenDviCnhanBaoQuan;
	}

	public void setTenDviCnhanBaoQuan(String tenDviCnhanBaoQuan) {
		this.tenDviCnhanBaoQuan = tenDviCnhanBaoQuan;
	}

	public Date getThoiDiemKetThucNphong() {
		return this.thoiDiemKetThucNphong;
	}

	public void setThoiDiemKetThucNphong(Date thoiDiemKetThucNphong) {
		this.thoiDiemKetThucNphong = thoiDiemKetThucNphong;
	}

	public String getIdDviCnhanBaoQuan() {
		return this.idDviCnhanBaoQuan;
	}

	public void setIdDviCnhanBaoQuan(String idDviCnhanBaoQuan) {
		this.idDviCnhanBaoQuan = idDviCnhanBaoQuan;
	}

	/**
	 * @return
	 */
	public String getTaiLieuBiNP() {
		return taiLieuBiNP;
	}

	/**
	 * @param string
	 */
	public void setTaiLieuBiNP(String string) {
		taiLieuBiNP = string;
	}

	/**
	 * @return
	 */
	public String getIdQuyetDinhNp() {
		return idQuyetDinhNp;
	}

	/**
	 * @param string
	 */
	public void setIdQuyetDinhNp(String string) {
		idQuyetDinhNp = string;
	}

	/**
	 * @return
	 */
	public Collection getDsDoanTtkt() {
		return dsDoanTtkt;
	}

	/**
	 * @return
	 */
	public Collection getDsDvCoTlNp() {
		return dsDvCoTlNp;
	}

	/**
	 * @param collection
	 */
	public void setDsDoanTtkt(Collection collection) {
		dsDoanTtkt = collection;
	}

	/**
	 * @param collection
	 */
	public void setDsDvCoTlNp(Collection collection) {
		dsDvCoTlNp = collection;
	}


	public String getIdDsTvd() {
		return idDsTvd;
	}


	public void setIdDsTvd(String idDsTvd) {
		this.idDsTvd = idDsTvd;
	}

}