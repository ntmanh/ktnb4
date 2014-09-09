package cmc.com.ktnb.entity;

import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

public class KtnbTkCanBo extends PersistentObject implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ma;
	private Date ngay_bat_dau;
	private Date ngay_ket_thuc;
	private String ma_cqt;
	private String ten_cqt;
	private Long so_cct;
	private Long so_doi_ktnb;
	private Long trinh_do_dh;
	private Long trinh_do_cdtc;
	private Long chuyen_trach;
	private Long kiem_nhiem;
	//search
	public static final String MA_CQT = "ma_cqt";
	public Long getChuyen_trach() {
		return chuyen_trach;
	}
	public void setChuyen_trach(Long chuyen_trach) {
		this.chuyen_trach = chuyen_trach;
	}
	public Long getKiem_nhiem() {
		return kiem_nhiem;
	}
	public void setKiem_nhiem(Long kiem_nhiem) {
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
	public Date getNgay_bat_dau() {
		return ngay_bat_dau;
	}
	public void setNgay_bat_dau(Date ngay_bat_dau) {
		this.ngay_bat_dau = ngay_bat_dau;
	}
	public Date getNgay_ket_thuc() {
		return ngay_ket_thuc;
	}
	public void setNgay_ket_thuc(Date ngay_ket_thuc) {
		this.ngay_ket_thuc = ngay_ket_thuc;
	}
	public Long getSo_cct() {
		return so_cct;
	}
	public void setSo_cct(Long so_cct) {
		this.so_cct = so_cct;
	}
	public Long getSo_doi_ktnb() {
		return so_doi_ktnb;
	}
	public void setSo_doi_ktnb(Long so_doi_ktnb) {
		this.so_doi_ktnb = so_doi_ktnb;
	}
	public String getTen_cqt() {
		return ten_cqt;
	}
	public void setTen_cqt(String ten_cqt) {
		this.ten_cqt = ten_cqt;
	}
	public Long getTrinh_do_cdtc() {
		return trinh_do_cdtc;
	}
	public void setTrinh_do_cdtc(Long trinh_do_cdtc) {
		this.trinh_do_cdtc = trinh_do_cdtc;
	}
	public Long getTrinh_do_dh() {
		return trinh_do_dh;
	}
	public void setTrinh_do_dh(Long trinh_do_dh) {
		this.trinh_do_dh = trinh_do_dh;
	}
	
	
}
