package cmc.com.ktnb.web.ttkt.dung_chung.form;

import cmc.com.ktnb.entity.KtnbTkCanBo;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseActionForm;

public class ThongKeCanBoForm extends BaseActionForm{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String ma;
private String ngay_bat_dau;
private String ngay_ket_thuc;
private String ma_cqt;
private String ten_cqt;
private String so_cct;
private String so_doi_ktnb;
private String trinh_do_dh;
private String trinh_do_cdtc;
private String chuyen_trach;
private String kiem_nhiem;
public String getChuyen_trach() {
	return chuyen_trach;
}
public void setChuyen_trach(String chuyen_trach) {
	this.chuyen_trach = chuyen_trach;
}
public String getKiem_nhiem() {
	return kiem_nhiem;
}
public void setKiem_nhiem(String kiem_nhiem) {
	this.kiem_nhiem = kiem_nhiem;
}
public String getMa() {
	return ma;
}
public void setMa(String ma) {
	this.ma = ma;
}
public String getMa_cqt() {
	return ma_cqt;
}
public void setMa_cqt(String ma_cqt) {
	this.ma_cqt = ma_cqt;
}
public String getNgay_bat_dau() {
	return ngay_bat_dau;
}
public void setNgay_bat_dau(String ngay_bat_dau) {
	this.ngay_bat_dau = ngay_bat_dau;
}
public String getNgay_ket_thuc() {
	return ngay_ket_thuc;
}
public void setNgay_ket_thuc(String ngay_ket_thuc) {
	this.ngay_ket_thuc = ngay_ket_thuc;
}
public String getSo_cct() {
	return so_cct;
}
public void setSo_cct(String so_cct) {
	this.so_cct = so_cct;
}
public String getSo_doi_ktnb() {
	return so_doi_ktnb;
}
public void setSo_doi_ktnb(String so_doi_ktnb) {
	this.so_doi_ktnb = so_doi_ktnb;
}
public String getTen_cqt() {
	return ten_cqt;
}
public void setTen_cqt(String ten_cqt) {
	this.ten_cqt = ten_cqt;
}
public String getTrinh_do_cdtc() {
	return trinh_do_cdtc;
}
public void setTrinh_do_cdtc(String trinh_do_cdtc) {
	this.trinh_do_cdtc = trinh_do_cdtc;
}
public String getTrinh_do_dh() {
	return trinh_do_dh;
}
public void setTrinh_do_dh(String trinh_do_dh) {
	this.trinh_do_dh = trinh_do_dh;
}
public KtnbTkCanBo toEntity(){
	KtnbTkCanBo entity = new KtnbTkCanBo();
	entity.setChuyen_trach(Formater.toLong(this.chuyen_trach));
	entity.setKiem_nhiem(Formater.toLong(this.kiem_nhiem));
	entity.setMa(this.ma);
	entity.setMa_cqt(this.ma_cqt);
	try {
		entity.setNgay_bat_dau(Formater.str2date(this.ngay_bat_dau));
		entity.setNgay_ket_thuc(Formater.str2date(this.ngay_ket_thuc));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	entity.setSo_cct(Formater.toLong(this.so_cct));
	entity.setSo_doi_ktnb(Formater.toLong(this.so_doi_ktnb));
	entity.setTen_cqt(this.ten_cqt);
	entity.setTrinh_do_cdtc(Formater.toLong(this.trinh_do_cdtc));
	entity.setTrinh_do_dh(Formater.toLong(this.trinh_do_dh));
	return entity;
}
public void toForm(KtnbTkCanBo entity){
	this.chuyen_trach = entity.getChuyen_trach().toString();
	this.kiem_nhiem = entity.getKiem_nhiem().toString();
	this.ma = entity.getMa();
	this.ma_cqt = entity.getMa_cqt();
	this.ngay_bat_dau = Formater.date2str(entity.getNgay_bat_dau());
	this.ngay_ket_thuc = Formater.date2str(entity.getNgay_ket_thuc());
	this.so_cct = entity.getSo_cct().toString();
	this.so_doi_ktnb = entity.getSo_doi_ktnb().toString();
	this.ten_cqt = entity.getTen_cqt();
	this.setTrinh_do_cdtc(entity.getTrinh_do_cdtc().toString());
	this.setTrinh_do_dh(entity.getTrinh_do_dh().toString());
}
}
