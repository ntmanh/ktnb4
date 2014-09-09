package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KntcBienBan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Ttcp2c extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
	private TtcpBaoCaoId id;
	private Long soNguoiDaBiXly;
	private Long chuyenDtSoVu;
	private Long chuyenDtSoNguoi;
	private Long chuyenDtKqSoVu;
	private Long chuyenDtKqSoNguoi;
	private Long thuHoiPhaiThu;
	private Long thuHoiDaThu;
	private Long traLaiPhaiTra;
	private Long traLaiDaTra;
	
	private Date ngayCuoiThang;
	public Ttcp2c() {
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
	public Long getChuyenDtKqSoNguoi() {
		return chuyenDtKqSoNguoi;
	}
	public void setChuyenDtKqSoNguoi(Long chuyenDtKqSoNguoi) {
		this.chuyenDtKqSoNguoi = chuyenDtKqSoNguoi;
	}
	public Long getChuyenDtKqSoVu() {
		return chuyenDtKqSoVu;
	}
	public void setChuyenDtKqSoVu(Long chuyenDtKqSoVu) {
		this.chuyenDtKqSoVu = chuyenDtKqSoVu;
	}
	public Long getChuyenDtSoNguoi() {
		return chuyenDtSoNguoi;
	}
	public void setChuyenDtSoNguoi(Long chuyenDtSoNguoi) {
		this.chuyenDtSoNguoi = chuyenDtSoNguoi;
	}
	public Long getChuyenDtSoVu() {
		return chuyenDtSoVu;
	}
	public void setChuyenDtSoVu(Long chuyenDtSoVu) {
		this.chuyenDtSoVu = chuyenDtSoVu;
	}
	public Long getSoNguoiDaBiXly() {
		return soNguoiDaBiXly;
	}
	public void setSoNguoiDaBiXly(Long soNguoiDaBiXly) {
		this.soNguoiDaBiXly = soNguoiDaBiXly;
	}
	public Long getThuHoiDaThu() {
		return thuHoiDaThu;
	}
	public void setThuHoiDaThu(Long thuHoiDaThu) {
		this.thuHoiDaThu = thuHoiDaThu;
	}
	public Long getThuHoiPhaiThu() {
		return thuHoiPhaiThu;
	}
	public void setThuHoiPhaiThu(Long thuHoiPhaiThu) {
		this.thuHoiPhaiThu = thuHoiPhaiThu;
	}
	public Long getTraLaiDaTra() {
		return traLaiDaTra;
	}
	public void setTraLaiDaTra(Long traLaiDaTra) {
		this.traLaiDaTra = traLaiDaTra;
	}
	public Long getTraLaiPhaiTra() {
		return traLaiPhaiTra;
	}
	public void setTraLaiPhaiTra(Long traLaiPhaiTra) {
		this.traLaiPhaiTra = traLaiPhaiTra;
	}
	
}