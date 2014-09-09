package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KntcBienBan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Ttcp1b extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
	private TtcpBaoCaoId id;
	private Long vbBhMoi;
	private Long vbBhBoSung;
	private Long thKtnbLop;
	private Long thKtnbNg;
	private Long thKntcLop;
	private Long thKntcNg;
	private Long ndTtktSoCuoc;
	private Long ndTtktSoDv;
	private Long ndKntcSoCuoc;
	private Long ndKntcSoDv;
	private Long ndDvViPham;
	private Long ndXlySoNg;
	private Long ndXlyHcSoVu;
	private Long ndXlyHcSoNg;
	private Long thTongSo;
	private Long thKqKd;
	private Long thKqHcVu;
	private Long thKqHcNg;
	
	private Date ngayCuoiThang;
	public Ttcp1b() {
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
	public Long getNdDvViPham() {
		return ndDvViPham;
	}
	public void setNdDvViPham(Long ndDvViPham) {
		this.ndDvViPham = ndDvViPham;
	}
	public Long getNdKntcSoCuoc() {
		return ndKntcSoCuoc;
	}
	public void setNdKntcSoCuoc(Long ndKntcSoCuoc) {
		this.ndKntcSoCuoc = ndKntcSoCuoc;
	}
	public Long getNdKntcSoDv() {
		return ndKntcSoDv;
	}
	public void setNdKntcSoDv(Long ndKntcSoDv) {
		this.ndKntcSoDv = ndKntcSoDv;
	}
	public Long getNdTtktSoCuoc() {
		return ndTtktSoCuoc;
	}
	public void setNdTtktSoCuoc(Long ndTtktSoCuoc) {
		this.ndTtktSoCuoc = ndTtktSoCuoc;
	}
	public Long getNdTtktSoDv() {
		return ndTtktSoDv;
	}
	public void setNdTtktSoDv(Long ndTtktSoDv) {
		this.ndTtktSoDv = ndTtktSoDv;
	}
	public Long getNdXlyHcSoNg() {
		return ndXlyHcSoNg;
	}
	public void setNdXlyHcSoNg(Long ndXlyHcSoNg) {
		this.ndXlyHcSoNg = ndXlyHcSoNg;
	}
	public Long getNdXlyHcSoVu() {
		return ndXlyHcSoVu;
	}
	public void setNdXlyHcSoVu(Long ndXlyHcSoVu) {
		this.ndXlyHcSoVu = ndXlyHcSoVu;
	}
	public Long getNdXlySoNg() {
		return ndXlySoNg;
	}
	public void setNdXlySoNg(Long ndXlySoNg) {
		this.ndXlySoNg = ndXlySoNg;
	}
	public Long getThKntcLop() {
		return thKntcLop;
	}
	public void setThKntcLop(Long thKntcLop) {
		this.thKntcLop = thKntcLop;
	}
	public Long getThKntcNg() {
		return thKntcNg;
	}
	public void setThKntcNg(Long thKntcNg) {
		this.thKntcNg = thKntcNg;
	}
	public Long getThKqHcNg() {
		return thKqHcNg;
	}
	public void setThKqHcNg(Long thKqHcNg) {
		this.thKqHcNg = thKqHcNg;
	}
	public Long getThKqHcVu() {
		return thKqHcVu;
	}
	public void setThKqHcVu(Long thKqHcVu) {
		this.thKqHcVu = thKqHcVu;
	}
	public Long getThKqKd() {
		return thKqKd;
	}
	public void setThKqKd(Long thKqKd) {
		this.thKqKd = thKqKd;
	}
	public Long getThKtnbLop() {
		return thKtnbLop;
	}
	public void setThKtnbLop(Long thKtnbLop) {
		this.thKtnbLop = thKtnbLop;
	}
	public Long getThKtnbNg() {
		return thKtnbNg;
	}
	public void setThKtnbNg(Long thKtnbNg) {
		this.thKtnbNg = thKtnbNg;
	}
	public Long getThTongSo() {
		return thTongSo;
	}
	public void setThTongSo(Long thTongSo) {
		this.thTongSo = thTongSo;
	}
	public Long getVbBhBoSung() {
		return vbBhBoSung;
	}
	public void setVbBhBoSung(Long vbBhBoSung) {
		this.vbBhBoSung = vbBhBoSung;
	}
	public Long getVbBhMoi() {
		return vbBhMoi;
	}
	public void setVbBhMoi(Long vbBhMoi) {
		this.vbBhMoi = vbBhMoi;
	}
	
}