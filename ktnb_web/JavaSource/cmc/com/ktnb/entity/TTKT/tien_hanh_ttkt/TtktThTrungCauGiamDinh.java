package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;
import java.util.Date;
import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktThTrungCauGiamDinh entity. @author MyEclipse Persistence Tools
 */

public class TtktThTrungCauGiamDinh extends PersistentObject implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String id;
	private String idCuocTtkt;
	private String noiLap;
	private Date ngayLap;
	private String idCqtGiamDinh;
	private String tenCqtTrungCau;
	private String idCqtTrungCau;
	private String noiDung;
	private Date ngayCungCapKq;
	private String tenCqtGiamDinh;
	private String soQuyetDinh;
	
	public static String IdCuocTtkt = "idCuocTtkt";
	public static String Id = "id";
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
	public TtktThTrungCauGiamDinh() {
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

	public String getIdCqtGiamDinh() {
		return this.idCqtGiamDinh;
	}

	public void setIdCqtGiamDinh(String idCqtGiamDinh) {
		this.idCqtGiamDinh = idCqtGiamDinh;
	}

	public String getTenCqtTrungCau() {
		return this.tenCqtTrungCau;
	}

	public void setTenCqtTrungCau(String tenCqtTrungCau) {
		this.tenCqtTrungCau = tenCqtTrungCau;
	}

	public String getIdCqtTrungCau() {
		return this.idCqtTrungCau;
	}

	public void setIdCqtTrungCau(String idCqtTrungCau) {
		this.idCqtTrungCau = idCqtTrungCau;
	}

	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Date getNgayCungCapKq() {
		return this.ngayCungCapKq;
	}

	public void setNgayCungCapKq(Date ngayCungCapKq) {
		this.ngayCungCapKq = ngayCungCapKq;
	}

	public String getTenCqtGiamDinh() {
		return this.tenCqtGiamDinh;
	}

	public void setTenCqtGiamDinh(String tenCqtGiamDinh) {
		this.tenCqtGiamDinh = tenCqtGiamDinh;
	}

	public String getSoQuyetDinh() {
		return soQuyetDinh;
	}

	public void setSoQuyetDinh(String soQuyetDinh) {
		this.soQuyetDinh = soQuyetDinh;
	}

}