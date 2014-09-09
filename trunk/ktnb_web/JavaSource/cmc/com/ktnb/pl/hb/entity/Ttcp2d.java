package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KntcBienBan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Ttcp2d extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
	private TtcpBaoCaoId id;
	private Long snDuocBv;
	private Long snBiXly;
	private Long chuyenDtSoVuDkt;
	private Long chuyenDtSoNgDkt;
	private Long thTongSo;
	private Long thDaTh;
	private Long thThuHoiPhaiThu;
	private Long thThuHoiDaThu;
	private Long thTraLaiPhaiTra;
	private Long thTraLaiDaTra;
	
	private Date ngayCuoiThang;
	public Ttcp2d() {
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
	public Long getChuyenDtSoNgDkt() {
		return chuyenDtSoNgDkt;
	}
	public void setChuyenDtSoNgDkt(Long chuyenDtSoNgDkt) {
		this.chuyenDtSoNgDkt = chuyenDtSoNgDkt;
	}
	public Long getChuyenDtSoVuDkt() {
		return chuyenDtSoVuDkt;
	}
	public void setChuyenDtSoVuDkt(Long chuyenDtSoVuDkt) {
		this.chuyenDtSoVuDkt = chuyenDtSoVuDkt;
	}
	public Long getSnBiXly() {
		return snBiXly;
	}
	public void setSnBiXly(Long snBiXly) {
		this.snBiXly = snBiXly;
	}
	public Long getSnDuocBv() {
		return snDuocBv;
	}
	public void setSnDuocBv(Long snDuocBv) {
		this.snDuocBv = snDuocBv;
	}
	public Long getThDaTh() {
		return thDaTh;
	}
	public void setThDaTh(Long thDaTh) {
		this.thDaTh = thDaTh;
	}
	public Long getThThuHoiPhaiThu() {
		return thThuHoiPhaiThu;
	}
	public void setThThuHoiPhaiThu(Long thThuHoiPhaiThu) {
		this.thThuHoiPhaiThu = thThuHoiPhaiThu;
	}
	public Long getThTongSo() {
		return thTongSo;
	}
	public void setThTongSo(Long thTongSo) {
		this.thTongSo = thTongSo;
	}
	public Long getThTraLaiDaTra() {
		return thTraLaiDaTra;
	}
	public void setThTraLaiDaTra(Long thTraLaiDaTra) {
		this.thTraLaiDaTra = thTraLaiDaTra;
	}
	public Long getThTraLaiPhaiTra() {
		return thTraLaiPhaiTra;
	}
	public void setThTraLaiPhaiTra(Long thTraLaiPhaiTra) {
		this.thTraLaiPhaiTra = thTraLaiPhaiTra;
	}
	public Long getThThuHoiDaThu() {
		return thThuHoiDaThu;
	}
	public void setThThuHoiDaThu(Long thThuHoiDaThu) {
		this.thThuHoiDaThu = thThuHoiDaThu;
	}
	
}