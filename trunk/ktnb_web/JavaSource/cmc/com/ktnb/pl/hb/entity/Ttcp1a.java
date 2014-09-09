package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KntcBienBan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Ttcp1a extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
	private TtcpBaoCaoId id;
	private Long daThuTien;
	private Long daThuKhac;
	private Long kiemTraTongSo;
	private Long kiemTraTienPhaiThu;
	private Long kiemTraTienDaThu;
	private Long kiemTraKhacPhaiThu;
	private Long kiemTraKhacDaThu;
	private Long kiemTraDaXlyHC;
	private Long kiemTraKhoiToVu;
	private Long kiemTraKhoiToNguoi;
	
	private Date ngayCuoiThang;
	public Ttcp1a() {
		// TODO Auto-generated constructor stub
	}
	public TtcpBaoCaoId getId() {
		return id;
	}
	public void setId(TtcpBaoCaoId id) {
		this.id = id;
	}
	
	public Date getNgayCuoiThang() {
		return ngayCuoiThang;
	}
	public void setNgayCuoiThang(Date ngayCuoiThang) {
		this.ngayCuoiThang = ngayCuoiThang;
	}
	public Long getDaThuKhac() {
		return daThuKhac;
	}
	public void setDaThuKhac(Long daThuKhac) {
		this.daThuKhac = daThuKhac;
	}
	public Long getDaThuTien() {
		return daThuTien;
	}
	public void setDaThuTien(Long daThuTien) {
		this.daThuTien = daThuTien;
	}
	public Long getKiemTraDaXlyHC() {
		return kiemTraDaXlyHC;
	}
	public void setKiemTraDaXlyHC(Long kiemTraDaXlyHC) {
		this.kiemTraDaXlyHC = kiemTraDaXlyHC;
	}
	public Long getKiemTraKhacDaThu() {
		return kiemTraKhacDaThu;
	}
	public void setKiemTraKhacDaThu(Long kiemTraKhacDaThu) {
		this.kiemTraKhacDaThu = kiemTraKhacDaThu;
	}
	public Long getKiemTraKhacPhaiThu() {
		return kiemTraKhacPhaiThu;
	}
	public void setKiemTraKhacPhaiThu(Long kiemTraKhacPhaiThu) {
		this.kiemTraKhacPhaiThu = kiemTraKhacPhaiThu;
	}
	public Long getKiemTraKhoiToNguoi() {
		return kiemTraKhoiToNguoi;
	}
	public void setKiemTraKhoiToNguoi(Long kiemTraKhoiToNguoi) {
		this.kiemTraKhoiToNguoi = kiemTraKhoiToNguoi;
	}
	public Long getKiemTraKhoiToVu() {
		return kiemTraKhoiToVu;
	}
	public void setKiemTraKhoiToVu(Long kiemTraKhoiToVu) {
		this.kiemTraKhoiToVu = kiemTraKhoiToVu;
	}
	public Long getKiemTraTienDaThu() {
		return kiemTraTienDaThu;
	}
	public void setKiemTraTienDaThu(Long kiemTraTienDaThu) {
		this.kiemTraTienDaThu = kiemTraTienDaThu;
	}
	public Long getKiemTraTienPhaiThu() {
		return kiemTraTienPhaiThu;
	}
	public void setKiemTraTienPhaiThu(Long kiemTraTienPhaiThu) {
		this.kiemTraTienPhaiThu = kiemTraTienPhaiThu;
	}
	public Long getKiemTraTongSo() {
		return kiemTraTongSo;
	}
	public void setKiemTraTongSo(Long kiemTraTongSo) {
		this.kiemTraTongSo = kiemTraTongSo;
	}
	
}