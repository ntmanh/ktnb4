package cmc.com.ktnb.tccp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.KntcXmKeHoach;
import cmc.com.ktnb.pl.hb.entity.Ttcp1a;
import cmc.com.ktnb.pl.hb.entity.Ttcp1b;
import cmc.com.ktnb.pl.hb.entity.Ttcp2a;
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
public class Bc1bForm extends BaseActionForm {	
	private String maCqt;
	private Integer nam;
	private Integer thang;
	//So lieu lay tu bao cao
	//So lieu can nhap	
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
	private String ngayCuoiThang;
	
	public void fromEntity(Ttcp1b entity, ApplicationContext c) throws Exception {
		this.maCqt = entity.getId().getMaCqt();
		this.nam = entity.getId().getNam();
		this.thang = entity.getId().getThang();
		//So lieu lay tu bao cao
		//So lieu nhap
		this.vbBhMoi = entity.getVbBhMoi();
		this.vbBhBoSung = entity.getVbBhBoSung();
		this.thKtnbLop = entity.getThKtnbLop();
		this.thKtnbNg = entity.getThKtnbNg();
		this.thKntcLop = entity.getThKntcLop();
		this.thKntcNg = entity.getThKntcNg();
		this.ndTtktSoCuoc = entity.getNdTtktSoCuoc();
		this.ndTtktSoDv = entity.getNdTtktSoDv();
		this.ndKntcSoCuoc = entity.getNdKntcSoCuoc();
		this.ndKntcSoDv = entity.getNdKntcSoDv();
		this.ndDvViPham = entity.getNdDvViPham();
		this.ndXlySoNg = entity.getNdXlySoNg();
		this.ndXlyHcSoVu = entity.getNdXlyHcSoVu();
		this.ndXlyHcSoNg = entity.getNdXlyHcSoNg();
		this.thTongSo = entity.getThTongSo();
		this.thKqKd = entity.getThKqKd();
		this.thKqHcVu = entity.getThKqHcVu();
		this.thKqHcNg = entity.getThKqHcNg();
		this.ngayCuoiThang = Formater.date2strDateTimeForNV(entity.getNgayCuoiThang());
	}
	public Ttcp1b toEntity() throws Exception{
		Ttcp1b entity = new Ttcp1b();
		TtcpBaoCaoId id = new TtcpBaoCaoId();
		id.setMaCqt(this.maCqt);
		id.setNam(this.nam);
		id.setThang(this.thang);
		entity.setId(id);
		entity.setVbBhMoi(this.vbBhMoi);
		entity.setVbBhBoSung(this.vbBhBoSung);
		entity.setThKtnbLop(this.thKtnbLop);
		entity.setThKtnbNg(this.thKtnbNg);
		entity.setThKntcLop(this.thKntcLop);
		entity.setThKntcNg(this.thKntcNg);
		entity.setNdTtktSoCuoc(this.ndTtktSoCuoc);
		entity.setNdTtktSoDv(this.ndTtktSoDv);
		entity.setNdKntcSoCuoc(this.ndKntcSoCuoc);
		entity.setNdKntcSoDv(this.ndKntcSoDv);
		entity.setNdDvViPham(this.ndDvViPham);
		entity.setNdXlySoNg(this.ndXlySoNg);
		entity.setNdXlyHcSoVu(this.ndXlyHcSoVu);
		entity.setNdXlyHcSoNg(this.ndXlyHcSoNg);
		entity.setThTongSo(this.thTongSo);
		entity.setThKqKd(this.thKqKd);
		entity.setThKqHcVu(this.thKqHcVu);
		entity.setThKqHcNg(this.thKqHcNg);
		entity.setNgayCuoiThang(Formater.str2dateForNV(this.getNgayCuoiThang()));
		
		return entity;
	}
	public Bc1bForm() {
		// TODO Auto-generated constructor stub
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
