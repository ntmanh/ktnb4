package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KntcBienBan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Ttcp2dd extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
	private TtcpBaoCaoId id;
	private Long vbMoiBh;
	private Long vbBoSung;
	private Long thLop;
	private Long thNguoi;
	private Long ttktSoCuoc;
	private Long ttktSoDonVi;
	private Long ttktSoDvViPham;
	private Long ttktKdToChuc;
	private Long ttktKdCaNhan;
	private Long ttktHcToChuc;
	private Long ttktHcCaNhan;
	private Long ktthTongSo;
	private Long ktthKdToChuc;
	private Long ktthKdCaNhan;
	private Long ktthHcToChuc;
	private Long ktthHcCaNhan;
	
	private Date ngayCuoiThang;
	public Ttcp2dd() {
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
	public Long getKtthHcCaNhan() {
		return ktthHcCaNhan;
	}
	public void setKtthHcCaNhan(Long ktthHcCaNhan) {
		this.ktthHcCaNhan = ktthHcCaNhan;
	}
	public Long getKtthHcToChuc() {
		return ktthHcToChuc;
	}
	public void setKtthHcToChuc(Long ktthHcToChuc) {
		this.ktthHcToChuc = ktthHcToChuc;
	}
	public Long getKtthKdCaNhan() {
		return ktthKdCaNhan;
	}
	public void setKtthKdCaNhan(Long ktthKdCaNhan) {
		this.ktthKdCaNhan = ktthKdCaNhan;
	}
	public Long getKtthKdToChuc() {
		return ktthKdToChuc;
	}
	public void setKtthKdToChuc(Long ktthKdToChuc) {
		this.ktthKdToChuc = ktthKdToChuc;
	}
	public Long getKtthTongSo() {
		return ktthTongSo;
	}
	public void setKtthTongSo(Long ktthTongSo) {
		this.ktthTongSo = ktthTongSo;
	}
	public Long getThLop() {
		return thLop;
	}
	public void setThLop(Long thLop) {
		this.thLop = thLop;
	}
	public Long getThNguoi() {
		return thNguoi;
	}
	public void setThNguoi(Long thNguoi) {
		this.thNguoi = thNguoi;
	}
	public Long getTtktHcCaNhan() {
		return ttktHcCaNhan;
	}
	public void setTtktHcCaNhan(Long ttktHcCaNhan) {
		this.ttktHcCaNhan = ttktHcCaNhan;
	}
	public Long getTtktHcToChuc() {
		return ttktHcToChuc;
	}
	public void setTtktHcToChuc(Long ttktHcToChuc) {
		this.ttktHcToChuc = ttktHcToChuc;
	}
	public Long getTtktKdCaNhan() {
		return ttktKdCaNhan;
	}
	public void setTtktKdCaNhan(Long ttktKdCaNhan) {
		this.ttktKdCaNhan = ttktKdCaNhan;
	}
	public Long getTtktKdToChuc() {
		return ttktKdToChuc;
	}
	public void setTtktKdToChuc(Long ttktKdToChuc) {
		this.ttktKdToChuc = ttktKdToChuc;
	}
	public Long getTtktSoCuoc() {
		return ttktSoCuoc;
	}
	public void setTtktSoCuoc(Long ttktSoCuoc) {
		this.ttktSoCuoc = ttktSoCuoc;
	}
	public Long getTtktSoDonVi() {
		return ttktSoDonVi;
	}
	public void setTtktSoDonVi(Long ttktSoDonVi) {
		this.ttktSoDonVi = ttktSoDonVi;
	}
	public Long getTtktSoDvViPham() {
		return ttktSoDvViPham;
	}
	public void setTtktSoDvViPham(Long ttktSoDvViPham) {
		this.ttktSoDvViPham = ttktSoDvViPham;
	}
	public Long getVbBoSung() {
		return vbBoSung;
	}
	public void setVbBoSung(Long vbBoSung) {
		this.vbBoSung = vbBoSung;
	}
	public Long getVbMoiBh() {
		return vbMoiBh;
	}
	public void setVbMoiBh(Long vbMoiBh) {
		this.vbMoiBh = vbMoiBh;
	}
	
}