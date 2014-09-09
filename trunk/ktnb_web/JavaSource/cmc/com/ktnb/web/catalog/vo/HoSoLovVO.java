package cmc.com.ktnb.web.catalog.vo;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

import cmc.com.ktnb.util.Formater;

/**
 * @author ntthu
 * @version Jan 21, 2008
 */
public class HoSoLovVO implements Serializable {
	private String ma;
	private String tenNnd;
	private String ngayNhan;
	private String tenCqt,trangThai,loaiHoSo;
	public HoSoLovVO(String ma,String ten,String ngay, String cqt, String _trangThai, String _loaiHoSo){
		this.ma =  ma;
		this.tenNnd = ten;
		this.ngayNhan = ngay;
		this.tenCqt=cqt;
		this.trangThai=_trangThai;
		this.loaiHoSo = _loaiHoSo;
	}
	public HoSoLovVO(Object[] ele) {
		this.ma = (String) ele[0];
		this.tenNnd = (String) ele[1];
		this.ngayNhan = Formater.date2str((Date) ele[2]);
		this.tenCqt = (String) ele[3];
		this.trangThai = (String) ele[4];		
		this.loaiHoSo = Integer.toString(((BigDecimal) ele[5]).intValue());		
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTenCqt() {
		return tenCqt;
	}
	public void setTenCqt(String tenCqt) {
		this.tenCqt = tenCqt;
	}
	public String getTenNnd() {
		return tenNnd;
	}
	public void setTenNnd(String tenNnd) {
		this.tenNnd = tenNnd;
	}
	public String getNgayNhan() {
		return ngayNhan;
	}
	public void setNgayNhan(String ngayNhan) {
		this.ngayNhan = ngayNhan;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getLoaiHoSo() {
		return loaiHoSo;
	}
	public void setLoaiHoSo(String loaiHoSo) {
		this.loaiHoSo = loaiHoSo;
	}
}
