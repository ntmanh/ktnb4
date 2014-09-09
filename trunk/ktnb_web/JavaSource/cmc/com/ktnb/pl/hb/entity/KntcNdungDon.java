package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;


/**
 * KntcNdungDon entity. @author ntthu
 */

public class KntcNdungDon extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {

	
     private String maDon,maHs,maHsGoc,noiGuiDon,soDon,soCv;
     private Date ngayLap,ngayCv,ngayGuiDon,ngayBpxlCv;


    // Constructors

    /** default constructor */
    public KntcNdungDon() {
    }


	public String getMaDon() {
		return maDon;
	}


	public void setMaDon(String maDon) {
		this.maDon = maDon;
	}


	public String getMaHs() {
		return maHs;
	}


	public void setMaHs(String maHs) {
		this.maHs = maHs;
	}


	public String getMaHsGoc() {
		return maHsGoc;
	}


	public void setMaHsGoc(String maHsGoc) {
		this.maHsGoc = maHsGoc;
	}


	public Date getNgayBpxlCv() {
		return ngayBpxlCv;
	}


	public void setNgayBpxlCv(Date ngayBpxlCv) {
		this.ngayBpxlCv = ngayBpxlCv;
	}


	public Date getNgayCv() {
		return ngayCv;
	}


	public void setNgayCv(Date ngayCv) {
		this.ngayCv = ngayCv;
	}


	public Date getNgayGuiDon() {
		return ngayGuiDon;
	}


	public void setNgayGuiDon(Date ngayGuiDon) {
		this.ngayGuiDon = ngayGuiDon;
	}


	public Date getNgayLap() {
		return ngayLap;
	}


	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}


	public String getNoiGuiDon() {
		return noiGuiDon;
	}


	public void setNoiGuiDon(String noiGuiDon) {
		this.noiGuiDon = noiGuiDon;
	}


	public String getSoCv() {
		return soCv;
	}


	public void setSoCv(String soCv) {
		this.soCv = soCv;
	}


	public String getSoDon() {
		return soDon;
	}


	public void setSoDon(String soDon) {
		this.soDon = soDon;
	}
}