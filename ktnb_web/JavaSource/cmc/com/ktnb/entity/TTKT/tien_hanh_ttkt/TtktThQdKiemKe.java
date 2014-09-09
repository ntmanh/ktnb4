package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;
import java.util.Date;
import cmc.com.ktnb.pl.hb.entity.PersistentObject;
/**
 * TtktThQdKiemKe entity. @author MyEclipse Persistence Tools
 */

public class TtktThQdKiemKe extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idCuocTtkt;
	private Date thoiGianKk;
	private String taiSanDuocKiemKe;
	private String donViDangBaoQuan;
	private String diaDiemCoTsKk;
	private String dviCnhanDuocKk;
	private String dviCnhanDuocGiaoBaoQuan;
	private String noiRaQd;
	private Date ngayRaQd;
	private String thuTruongDvCoTskk;
	private String cquanTchucCnhanCoLquan;
	private TtktThBienBanKiemKe bbKK;
	
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
	public TtktThQdKiemKe() {
	}

	/** minimal constructor */
	public TtktThQdKiemKe(String id, String idCuocTtkt, String diaDiem,
			Date thoiGianKk, String taiSanDuocKiemKe, String donViDangBaoQuan) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.thoiGianKk = thoiGianKk;
		this.taiSanDuocKiemKe = taiSanDuocKiemKe;
		this.donViDangBaoQuan = donViDangBaoQuan;
	}

	/** full constructor */
	public TtktThQdKiemKe(String id, String idCuocTtkt, String diaDiem,
			Date thoiGianKk, String taiSanDuocKiemKe, String donViDangBaoQuan,
			String diaDiemCoTsKk, String dviCnhanDuocKk,
			String dviCnhanDuocGiaoBaoQuan, String noiRaQd, Date ngayRaQd,
			String thuTruongDvCoTskk, String cquanTchucCnhanCoLquan) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.thoiGianKk = thoiGianKk;
		this.taiSanDuocKiemKe = taiSanDuocKiemKe;
		this.donViDangBaoQuan = donViDangBaoQuan;
		this.diaDiemCoTsKk = diaDiemCoTsKk;
		this.dviCnhanDuocKk = dviCnhanDuocKk;
		this.dviCnhanDuocGiaoBaoQuan = dviCnhanDuocGiaoBaoQuan;
		this.noiRaQd = noiRaQd;
		this.ngayRaQd = ngayRaQd;
		this.thuTruongDvCoTskk = thuTruongDvCoTskk;
		this.cquanTchucCnhanCoLquan = cquanTchucCnhanCoLquan;
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



	public Date getThoiGianKk() {
		return this.thoiGianKk;
	}

	public void setThoiGianKk(Date thoiGianKk) {
		this.thoiGianKk = thoiGianKk;
	}

	public String getTaiSanDuocKiemKe() {
		return this.taiSanDuocKiemKe;
	}

	public void setTaiSanDuocKiemKe(String taiSanDuocKiemKe) {
		this.taiSanDuocKiemKe = taiSanDuocKiemKe;
	}

	public String getDonViDangBaoQuan() {
		return this.donViDangBaoQuan;
	}

	public void setDonViDangBaoQuan(String donViDangBaoQuan) {
		this.donViDangBaoQuan = donViDangBaoQuan;
	}

	public String getDiaDiemCoTsKk() {
		return this.diaDiemCoTsKk;
	}

	public void setDiaDiemCoTsKk(String diaDiemCoTsKk) {
		this.diaDiemCoTsKk = diaDiemCoTsKk;
	}

	public String getDviCnhanDuocKk() {
		return this.dviCnhanDuocKk;
	}

	public void setDviCnhanDuocKk(String dviCnhanDuocKk) {
		this.dviCnhanDuocKk = dviCnhanDuocKk;
	}

	public String getDviCnhanDuocGiaoBaoQuan() {
		return this.dviCnhanDuocGiaoBaoQuan;
	}

	public void setDviCnhanDuocGiaoBaoQuan(String dviCnhanDuocGiaoBaoQuan) {
		this.dviCnhanDuocGiaoBaoQuan = dviCnhanDuocGiaoBaoQuan;
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

	public String getThuTruongDvCoTskk() {
		return this.thuTruongDvCoTskk;
	}

	public void setThuTruongDvCoTskk(String thuTruongDvCoTskk) {
		this.thuTruongDvCoTskk = thuTruongDvCoTskk;
	}

	public String getCquanTchucCnhanCoLquan() {
		return this.cquanTchucCnhanCoLquan;
	}

	public void setCquanTchucCnhanCoLquan(String cquanTchucCnhanCoLquan) {
		this.cquanTchucCnhanCoLquan = cquanTchucCnhanCoLquan;
	}

	public TtktThBienBanKiemKe getBbKK() {
		return bbKK;
	}

	public void setBbKK(TtktThBienBanKiemKe bbKK) {
		this.bbKK = bbKK;
	}

}