package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt; 

import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktThGiaHan entity. @author MyEclipse Persistence Tools
 */

public class TtktThGiaHan extends PersistentObject implements java.io.Serializable {

	// Fields 

	private String id;
	private String idCuocTtkt;
	private String noiTrinh;
	private Date ngayTrinh;
	private String noiPheDuyet;
	private Date ngayPheDuyet;
	private String YKienPheDuyet;
	private String soQd;
	private String noiRaQd;
	private Date ngayRqQd;
	private Byte soNgayGiaHan;
	private Date giaHanTuNgay;
	private Date giaHanDenNgay;
	private String lyDoGiaHan;
	private String dviCnhanLquan;
	private String vbQdinhCnangNvu;
	private String canCuQd;
	private String canCuLuat;
	
	public static  String  IdCuocTtkt = "idCuocTtkt";
	public static  String  Id = "id";
	// Constructors
	private String idNguoiCapNat;
	private String tenNguoiCapNhat;
	private Date ngayCapNhat;
	 
	 
	 
	public String getCanCuLuat() {
		return canCuLuat;
	}

	public void setCanCuLuat(String canCuLuat) {
		this.canCuLuat = canCuLuat;
	}

	public String getCanCuQd() {
		return canCuQd;
	}

	public void setCanCuQd(String canCuQd) {
		this.canCuQd = canCuQd;
	}

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
	public TtktThGiaHan() {
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

	public String getNoiTrinh() {
		return this.noiTrinh;
	}

	public void setNoiTrinh(String noiTrinh) {
		this.noiTrinh = noiTrinh;
	}

	public Date getNgayTrinh() {
		return this.ngayTrinh;
	}

	public void setNgayTrinh(Date ngayTrinh) {
		this.ngayTrinh = ngayTrinh;
	}

	public String getNoiPheDuyet() {
		return this.noiPheDuyet;
	}

	public void setNoiPheDuyet(String noiPheDuyet) {
		this.noiPheDuyet = noiPheDuyet;
	}

	public Date getNgayPheDuyet() {
		return this.ngayPheDuyet;
	}

	public void setNgayPheDuyet(Date ngayPheDuyet) {
		this.ngayPheDuyet = ngayPheDuyet;
	}

	public String getYKienPheDuyet() {
		return this.YKienPheDuyet;
	}

	public void setYKienPheDuyet(String YKienPheDuyet) {
		this.YKienPheDuyet = YKienPheDuyet;
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

	public Date getNgayRqQd() {
		return this.ngayRqQd;
	}

	public void setNgayRqQd(Date ngayRqQd) {
		this.ngayRqQd = ngayRqQd;
	}

	public Byte getSoNgayGiaHan() {
		return this.soNgayGiaHan;
	}

	public void setSoNgayGiaHan(Byte soNgayGiaHan) {
		this.soNgayGiaHan = soNgayGiaHan;
	}

	public Date getGiaHanTuNgay() {
		return this.giaHanTuNgay;
	}

	public void setGiaHanTuNgay(Date giaHanTuNgay) {
		this.giaHanTuNgay = giaHanTuNgay;
	}

	public Date getGiaHanDenNgay() {
		return this.giaHanDenNgay;
	}

	public void setGiaHanDenNgay(Date giaHanDenNgay) {
		this.giaHanDenNgay = giaHanDenNgay;
	}

	public String getLyDoGiaHan() {
		return this.lyDoGiaHan;
	}

	public void setLyDoGiaHan(String lyDoGiaHan) {
		this.lyDoGiaHan = lyDoGiaHan;
	}

	public String getDviCnhanLquan() {
		return this.dviCnhanLquan;
	}

	public void setDviCnhanLquan(String dviCnhanLquan) {
		this.dviCnhanLquan = dviCnhanLquan;
	}

	public String getVbQdinhCnangNvu() {
		return this.vbQdinhCnangNvu;
	}

	public void setVbQdinhCnangNvu(String vbQdinhCnangNvu) {
		this.vbQdinhCnangNvu = vbQdinhCnangNvu;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TtktThGiaHan))
			return false;
		TtktThGiaHan castOther = (TtktThGiaHan) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getIdCuocTtkt() == castOther.getIdCuocTtkt()) || (this
						.getIdCuocTtkt() != null
						&& castOther.getIdCuocTtkt() != null && this
						.getIdCuocTtkt().equals(castOther.getIdCuocTtkt())))
				&& ((this.getNoiTrinh() == castOther.getNoiTrinh()) || (this
						.getNoiTrinh() != null
						&& castOther.getNoiTrinh() != null && this
						.getNoiTrinh().equals(castOther.getNoiTrinh())))
				&& ((this.getNgayTrinh() == castOther.getNgayTrinh()) || (this
						.getNgayTrinh() != null
						&& castOther.getNgayTrinh() != null && this
						.getNgayTrinh().equals(castOther.getNgayTrinh())))
				&& ((this.getNoiPheDuyet() == castOther.getNoiPheDuyet()) || (this
						.getNoiPheDuyet() != null
						&& castOther.getNoiPheDuyet() != null && this
						.getNoiPheDuyet().equals(castOther.getNoiPheDuyet())))
				&& ((this.getNgayPheDuyet() == castOther.getNgayPheDuyet()) || (this
						.getNgayPheDuyet() != null
						&& castOther.getNgayPheDuyet() != null && this
						.getNgayPheDuyet().equals(castOther.getNgayPheDuyet())))
				&& ((this.getYKienPheDuyet() == castOther.getYKienPheDuyet()) || (this
						.getYKienPheDuyet() != null
						&& castOther.getYKienPheDuyet() != null && this
						.getYKienPheDuyet()
						.equals(castOther.getYKienPheDuyet())))
				&& ((this.getSoQd() == castOther.getSoQd()) || (this.getSoQd() != null
						&& castOther.getSoQd() != null && this.getSoQd()
						.equals(castOther.getSoQd())))
				&& ((this.getNoiRaQd() == castOther.getNoiRaQd()) || (this
						.getNoiRaQd() != null
						&& castOther.getNoiRaQd() != null && this.getNoiRaQd()
						.equals(castOther.getNoiRaQd())))
				&& ((this.getNgayRqQd() == castOther.getNgayRqQd()) || (this
						.getNgayRqQd() != null
						&& castOther.getNgayRqQd() != null && this
						.getNgayRqQd().equals(castOther.getNgayRqQd())))
				&& ((this.getSoNgayGiaHan() == castOther.getSoNgayGiaHan()) || (this
						.getSoNgayGiaHan() != null
						&& castOther.getSoNgayGiaHan() != null && this
						.getSoNgayGiaHan().equals(castOther.getSoNgayGiaHan())))
				&& ((this.getGiaHanTuNgay() == castOther.getGiaHanTuNgay()) || (this
						.getGiaHanTuNgay() != null
						&& castOther.getGiaHanTuNgay() != null && this
						.getGiaHanTuNgay().equals(castOther.getGiaHanTuNgay())))
				&& ((this.getGiaHanDenNgay() == castOther.getGiaHanDenNgay()) || (this
						.getGiaHanDenNgay() != null
						&& castOther.getGiaHanDenNgay() != null && this
						.getGiaHanDenNgay()
						.equals(castOther.getGiaHanDenNgay())))
				&& ((this.getLyDoGiaHan() == castOther.getLyDoGiaHan()) || (this
						.getLyDoGiaHan() != null
						&& castOther.getLyDoGiaHan() != null && this
						.getLyDoGiaHan().equals(castOther.getLyDoGiaHan())))
				&& ((this.getDviCnhanLquan() == castOther.getDviCnhanLquan()) || (this
						.getDviCnhanLquan() != null
						&& castOther.getDviCnhanLquan() != null && this
						.getDviCnhanLquan()
						.equals(castOther.getDviCnhanLquan())))
				&& ((this.getVbQdinhCnangNvu() == castOther
						.getVbQdinhCnangNvu()) || (this.getVbQdinhCnangNvu() != null
						&& castOther.getVbQdinhCnangNvu() != null && this
						.getVbQdinhCnangNvu().equals(
								castOther.getVbQdinhCnangNvu())))
				&& ((this.getCanCuQd() == castOther
						.getCanCuQd()) || (this.getCanCuQd() != null
						&& castOther.getCanCuQd() != null && this
						.getCanCuQd().equals(castOther.getCanCuQd())))
				&& ((this.getCanCuLuat() == castOther
						.getCanCuLuat()) || (this.getCanCuLuat() != null
						&& castOther.getCanCuLuat() != null && this
						.getCanCuLuat().equals(castOther.getCanCuLuat())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37
				* result
				+ (getIdCuocTtkt() == null ? 0 : this.getIdCuocTtkt()
						.hashCode());
		result = 37 * result
				+ (getNoiTrinh() == null ? 0 : this.getNoiTrinh().hashCode());
		result = 37 * result
				+ (getNgayTrinh() == null ? 0 : this.getNgayTrinh().hashCode());
		result = 37
				* result
				+ (getNoiPheDuyet() == null ? 0 : this.getNoiPheDuyet()
						.hashCode());
		result = 37
				* result
				+ (getNgayPheDuyet() == null ? 0 : this.getNgayPheDuyet()
						.hashCode());
		result = 37
				* result
				+ (getYKienPheDuyet() == null ? 0 : this.getYKienPheDuyet()
						.hashCode());
		result = 37 * result
				+ (getSoQd() == null ? 0 : this.getSoQd().hashCode());
		result = 37 * result
				+ (getNoiRaQd() == null ? 0 : this.getNoiRaQd().hashCode());
		result = 37 * result
				+ (getNgayRqQd() == null ? 0 : this.getNgayRqQd().hashCode());
		result = 37
				* result
				+ (getSoNgayGiaHan() == null ? 0 : this.getSoNgayGiaHan()
						.hashCode());
		result = 37
				* result
				+ (getGiaHanTuNgay() == null ? 0 : this.getGiaHanTuNgay()
						.hashCode());
		result = 37
				* result
				+ (getGiaHanDenNgay() == null ? 0 : this.getGiaHanDenNgay()
						.hashCode());
		result = 37
				* result
				+ (getLyDoGiaHan() == null ? 0 : this.getLyDoGiaHan()
						.hashCode());
		result = 37
				* result
				+ (getDviCnhanLquan() == null ? 0 : this.getDviCnhanLquan()
						.hashCode());
		result = 37
				* result
				+ (getVbQdinhCnangNvu() == null ? 0 : this.getVbQdinhCnangNvu()
						.hashCode());
		result = 37
				* result
				+ (getCanCuQd() == null ? 0 : this.getCanCuQd()
						.hashCode());
		result = 37
				* result
				+ (getCanCuLuat() == null ? 0 : this.getCanCuLuat()
						.hashCode());
		return result;
	}

}