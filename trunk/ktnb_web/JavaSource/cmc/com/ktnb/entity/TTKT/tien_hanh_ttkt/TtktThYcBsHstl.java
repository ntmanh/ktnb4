package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;

import java.util.Date;

import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmNhanTraHstl;
import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktThYcBsHstl entity. @author MyEclipse Persistence Tools
 */

public class TtktThYcBsHstl extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idCbYeuCau;
	private Byte lanYeuCau;
	private String noiLapYeuCau;
	private Date ngayLapYeuCau;
	private String baoCao;
	private String hoSo;
	private String idNguoiNhanPhieuYc;
	private String tenNguoiNhanPhieuYc;
	private String chucVuNguoiNhanPhieuYc;
	private Date thoiDiemNhanPhieuYc;
	private Date thoiDiemCungCap;
	private String diaDiemCungCap;
	private String diaDiemNhanPhieuYC;
	private String idNguoiNhanBc;
	private String tenCanBoNhanBc;
	private String chucVuNguoiNhanBc;
	private String idCuocTtkt;
	private String tenCanBoYeuCau;
	private String chucVuNguoiYc;

	private TtktCmNhanTraHstl bbGiao;
	private TtktCmNhanTraHstl bbNhan;

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

	public String getDiaDiemNhanPhieuYC() {
		return diaDiemNhanPhieuYC;
	}

	public void setDiaDiemNhanPhieuYC(String diaDiemNhanPhieuYC) {
		this.diaDiemNhanPhieuYC = diaDiemNhanPhieuYC;
	}

	/** default constructor */
	public TtktThYcBsHstl() {
	}

	/** minimal constructor */
	public TtktThYcBsHstl(
		String id,
		Byte lanYeuCau,
		String noiLapYeuCau,
		Date ngayLapYeuCau,
		String idNguoiNhanPhieuYc,
		String chucVuNguoiNhanPhieuYc,
		Date thoiDiemNhanPhieuYc,
		Date thoiDiemCungCap,
		String diaDiemCungCap,
		String tenCanBoNhanBc,
		String idCuocTtkt,
		String tenCanBoYeuCau) {
		this.id = id;
		this.lanYeuCau = lanYeuCau;
		this.noiLapYeuCau = noiLapYeuCau;
		this.ngayLapYeuCau = ngayLapYeuCau;
		this.idNguoiNhanPhieuYc = idNguoiNhanPhieuYc;
		this.chucVuNguoiNhanPhieuYc = chucVuNguoiNhanPhieuYc;
		this.thoiDiemNhanPhieuYc = thoiDiemNhanPhieuYc;
		this.thoiDiemCungCap = thoiDiemCungCap;
		this.diaDiemCungCap = diaDiemCungCap;
		this.tenCanBoNhanBc = tenCanBoNhanBc;
		this.idCuocTtkt = idCuocTtkt;
		this.tenCanBoYeuCau = tenCanBoYeuCau;
	}

	/** full constructor */
	public TtktThYcBsHstl(
		String id,
		String idCbYeuCau,
		Byte lanYeuCau,
		String noiLapYeuCau,
		Date ngayLapYeuCau,
		String baoCao,
		String hoSo,
		String idNguoiNhanPhieuYc,
		String tenNguoiNhanPhieuYc,
		String chucVuNguoiNhanPhieuYc,
		Date thoiDiemNhanPhieuYc,
		Date thoiDiemCungCap,
		String diaDiemCungCap,
		String idNguoiNhanBc,
		String tenCanBoNhanBc,
		String chucVuNguoiNhanBc,
		String idCuocTtkt,
		String tenCanBoYeuCau,
		String chucVuNguoiYc) {
		this.id = id;
		this.idCbYeuCau = idCbYeuCau;
		this.lanYeuCau = lanYeuCau;
		this.noiLapYeuCau = noiLapYeuCau;
		this.ngayLapYeuCau = ngayLapYeuCau;
		this.baoCao = baoCao;
		this.hoSo = hoSo;
		this.idNguoiNhanPhieuYc = idNguoiNhanPhieuYc;
		this.tenNguoiNhanPhieuYc = tenNguoiNhanPhieuYc;
		this.chucVuNguoiNhanPhieuYc = chucVuNguoiNhanPhieuYc;
		this.thoiDiemNhanPhieuYc = thoiDiemNhanPhieuYc;
		this.thoiDiemCungCap = thoiDiemCungCap;
		this.diaDiemCungCap = diaDiemCungCap;
		this.idNguoiNhanBc = idNguoiNhanBc;
		this.tenCanBoNhanBc = tenCanBoNhanBc;
		this.chucVuNguoiNhanBc = chucVuNguoiNhanBc;
		this.idCuocTtkt = idCuocTtkt;
		this.tenCanBoYeuCau = tenCanBoYeuCau;
		this.chucVuNguoiYc = chucVuNguoiYc;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdCbYeuCau() {
		return this.idCbYeuCau;
	}

	public void setIdCbYeuCau(String idCbYeuCau) {
		this.idCbYeuCau = idCbYeuCau;
	}

	public Byte getLanYeuCau() {
		return this.lanYeuCau;
	}

	public void setLanYeuCau(Byte lanYeuCau) {
		this.lanYeuCau = lanYeuCau;
	}

	public String getNoiLapYeuCau() {
		return this.noiLapYeuCau;
	}

	public void setNoiLapYeuCau(String noiLapYeuCau) {
		this.noiLapYeuCau = noiLapYeuCau;
	}

	public Date getNgayLapYeuCau() {
		return this.ngayLapYeuCau;
	}

	public void setNgayLapYeuCau(Date ngayLapYeuCau) {
		this.ngayLapYeuCau = ngayLapYeuCau;
	}

	public String getBaoCao() {
		return this.baoCao;
	}

	public void setBaoCao(String baoCao) {
		this.baoCao = baoCao;
	}

	public String getHoSo() {
		return this.hoSo;
	}

	public void setHoSo(String hoSo) {
		this.hoSo = hoSo;
	}

	public String getIdNguoiNhanPhieuYc() {
		return this.idNguoiNhanPhieuYc;
	}

	public void setIdNguoiNhanPhieuYc(String idNguoiNhanPhieuYc) {
		this.idNguoiNhanPhieuYc = idNguoiNhanPhieuYc;
	}

	public String getTenNguoiNhanPhieuYc() {
		return this.tenNguoiNhanPhieuYc;
	}

	public void setTenNguoiNhanPhieuYc(String tenNguoiNhanPhieuYc) {
		this.tenNguoiNhanPhieuYc = tenNguoiNhanPhieuYc;
	}

	public String getChucVuNguoiNhanPhieuYc() {
		return this.chucVuNguoiNhanPhieuYc;
	}

	public void setChucVuNguoiNhanPhieuYc(String chucVuNguoiNhanPhieuYc) {
		this.chucVuNguoiNhanPhieuYc = chucVuNguoiNhanPhieuYc;
	}

	public Date getThoiDiemNhanPhieuYc() {
		return this.thoiDiemNhanPhieuYc;
	}

	public void setThoiDiemNhanPhieuYc(Date thoiDiemNhanPhieuYc) {
		this.thoiDiemNhanPhieuYc = thoiDiemNhanPhieuYc;
	}

	public Date getThoiDiemCungCap() {
		return this.thoiDiemCungCap;
	}

	public void setThoiDiemCungCap(Date thoiDiemCungCap) {
		this.thoiDiemCungCap = thoiDiemCungCap;
	}

	public String getDiaDiemCungCap() {
		return this.diaDiemCungCap;
	}

	public void setDiaDiemCungCap(String diaDiemCungCap) {
		this.diaDiemCungCap = diaDiemCungCap;
	}

	public String getIdNguoiNhanBc() {
		return this.idNguoiNhanBc;
	}

	public void setIdNguoiNhanBc(String idNguoiNhanBc) {
		this.idNguoiNhanBc = idNguoiNhanBc;
	}

	public String getTenCanBoNhanBc() {
		return this.tenCanBoNhanBc;
	}

	public void setTenCanBoNhanBc(String tenCanBoNhanBc) {
		this.tenCanBoNhanBc = tenCanBoNhanBc;
	}

	public String getChucVuNguoiNhanBc() {
		return this.chucVuNguoiNhanBc;
	}

	public void setChucVuNguoiNhanBc(String chucVuNguoiNhanBc) {
		this.chucVuNguoiNhanBc = chucVuNguoiNhanBc;
	}

	public String getIdCuocTtkt() {
		return this.idCuocTtkt;
	}

	public void setIdCuocTtkt(String idCuocTtkt) {
		this.idCuocTtkt = idCuocTtkt;
	}

	public String getTenCanBoYeuCau() {
		return this.tenCanBoYeuCau;
	}

	public void setTenCanBoYeuCau(String tenCanBoYeuCau) {
		this.tenCanBoYeuCau = tenCanBoYeuCau;
	}

	public String getChucVuNguoiYc() {
		return this.chucVuNguoiYc;
	}

	public void setChucVuNguoiYc(String chucVuNguoiYc) {
		this.chucVuNguoiYc = chucVuNguoiYc;
	}

	/**
	 * @return
	 */
	public TtktCmNhanTraHstl getBbGiao() {
		return bbGiao;
	}

	/**
	 * @return
	 */
	public TtktCmNhanTraHstl getBbNhan() {
		return bbNhan;
	}

	/**
	 * @param hstl
	 */
	public void setBbGiao(TtktCmNhanTraHstl hstl) {
		bbGiao = hstl;
	}

	/**
	 * @param hstl
	 */
	public void setBbNhan(TtktCmNhanTraHstl hstl) {
		bbNhan = hstl;
	}

	private String idDsTvd;

	/**
	 * @return
	 */
	public String getIdDsTvd() {
		return idDsTvd;
	}

	/**
	 * @param string
	 */
	public void setIdDsTvd(String string) {
		idDsTvd = string;
	}

}