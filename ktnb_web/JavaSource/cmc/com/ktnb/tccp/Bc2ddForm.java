package cmc.com.ktnb.tccp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.KntcXmKeHoach;
import cmc.com.ktnb.pl.hb.entity.Ttcp2a;
import cmc.com.ktnb.pl.hb.entity.Ttcp2b;
import cmc.com.ktnb.pl.hb.entity.Ttcp2dd;
import cmc.com.ktnb.pl.hb.entity.TtcpBaoCaoId;
import cmc.com.ktnb.service.TtcpService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseActionForm;
/**
 * Báo cáo form
 * @author Ntthu
 * Created on 16/04/2011
 */
public class Bc2ddForm extends BaseActionForm {	
	private String maCqt;
	private Integer nam;
	private Integer thang;
	//So lieu lay tu bao cao
	//So lieu can nhap	
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
	private String ngayCuoiThang;
	
	public void fromEntity(Ttcp2dd entity, ApplicationContext c) throws Exception {
		this.maCqt = entity.getId().getMaCqt();
		this.nam = entity.getId().getNam();
		this.thang = entity.getId().getThang();
		//So lieu lay tu bao cao
		//So lieu nhap
		this.vbMoiBh = entity.getVbMoiBh();
		this.vbBoSung = entity.getVbBoSung();
		this.thLop = entity.getThLop();
		this.thNguoi = entity.getThNguoi();
		this.ttktSoCuoc = entity.getTtktSoCuoc();
		this.ttktSoDonVi = entity.getTtktSoDonVi();
		this.ttktSoDvViPham = entity.getTtktSoDvViPham();
		this.ttktKdToChuc = entity.getTtktKdToChuc();
		this.ttktKdCaNhan = entity.getTtktKdCaNhan();
		this.ttktHcToChuc = entity.getTtktHcToChuc();
		this.ttktHcCaNhan = entity.getTtktHcCaNhan();
		this.ktthTongSo = entity.getKtthTongSo();
		this.ktthKdToChuc = entity.getKtthKdToChuc();
		this.ktthKdCaNhan = entity.getKtthKdCaNhan();
		this.ktthHcToChuc = entity.getKtthHcToChuc();
		this.ktthHcCaNhan = entity.getKtthHcCaNhan();
		this.ngayCuoiThang = Formater.date2strDateTimeForNV(entity.getNgayCuoiThang());
	}
	public Ttcp2dd toEntity() throws Exception{
		Ttcp2dd entity = new Ttcp2dd();
		TtcpBaoCaoId id = new TtcpBaoCaoId();
		id.setMaCqt(this.maCqt);
		id.setNam(this.nam);
		id.setThang(this.thang);
		entity.setId(id);
		entity.setVbMoiBh(this.vbMoiBh);
		entity.setVbBoSung(this.vbBoSung);
		entity.setThLop(this.thLop);
		entity.setThNguoi(this.thNguoi);
		entity.setTtktSoCuoc(this.ttktSoCuoc);
		entity.setTtktSoDonVi(this.ttktSoDonVi);
		entity.setTtktSoDvViPham(this.ttktSoDvViPham);
		entity.setTtktKdToChuc(this.ttktKdToChuc);
		entity.setTtktKdCaNhan(this.ttktKdCaNhan);
		entity.setTtktHcToChuc(this.ttktHcToChuc);
		entity.setTtktHcCaNhan(this.ttktHcCaNhan);
		entity.setKtthTongSo(this.ktthTongSo);
		entity.setKtthKdToChuc(this.ktthKdToChuc);
		entity.setKtthKdCaNhan(this.ktthKdCaNhan);
		entity.setKtthHcToChuc(this.ktthHcToChuc);
		entity.setKtthHcCaNhan(this.ktthHcCaNhan);
		entity.setNgayCuoiThang(Formater.str2dateForNV(this.getNgayCuoiThang()));
		return entity;
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
	public String getMaCqt() {
		return maCqt;
	}
	public void setMaCqt(String maCqt) {
		this.maCqt = maCqt;
	}
	public Integer getNam() {
		return nam;
	}
	public void setNam(Integer nam) {
		this.nam = nam;
	}
	public String getNgayCuoiThang() {
		return ngayCuoiThang;
	}
	public void setNgayCuoiThang(String ngayCuoiThang) {
		this.ngayCuoiThang = ngayCuoiThang;
	}
	public Integer getThang() {
		return thang;
	}
	public void setThang(Integer thang) {
		this.thang = thang;
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
	public Bc2ddForm() {
		// TODO Auto-generated constructor stub
	}
	
}
