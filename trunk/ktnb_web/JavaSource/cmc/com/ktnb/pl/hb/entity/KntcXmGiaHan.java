package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;


/**
 * KntcXmGiaHan entity. @author MyEclipse Persistence Tools
 */

public class KntcXmGiaHan extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {


    // Fields    

     private String ma;
     private String diaDiem;
     private Date ngayLap;
     private String canCuVb;
     private String canCuQd;
     private Date ngayRaQd;
     private Date giaHanTuNgay;
     private Date giaHanDenNgay;
     private String soPhieu;
     private String maHs;
     private String nguoiLap;
     private String maCqt;
     private String soNgayGH;

    // Constructors

    public String getSoNgayGH() {
		return soNgayGH;
	}

	public void setSoNgayGH(String soNgayGH) {
		this.soNgayGH = soNgayGH;
	}

	/** default constructor */
    public KntcXmGiaHan() {
    }

	/** minimal constructor */
    public KntcXmGiaHan(String ma, String soPhieu) {
        this.ma = ma;
        this.soPhieu = soPhieu;
    }
   
   
    // Property accessors

    public String getMa() {
        return this.ma;
    }
    
    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getDiaDiem() {
        return this.diaDiem;
    }
    
    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public Date getNgayLap() {
        return this.ngayLap;
    }
    
    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getCanCuVb() {
        return this.canCuVb;
    }
    
    public void setCanCuVb(String canCuVb) {
        this.canCuVb = canCuVb;
    }

    public String getCanCuQd() {
        return this.canCuQd;
    }
    
    public void setCanCuQd(String canCuQd) {
        this.canCuQd = canCuQd;
    }

    public Date getNgayRaQd() {
        return this.ngayRaQd;
    }
    
    public void setNgayRaQd(Date ngayRaQd) {
        this.ngayRaQd = ngayRaQd;
    }

    public Date getGiaHanTuNgay() {
        return this.giaHanTuNgay;
    }
    
    public void setGiaHanTuNgay(Date giaHanTuNgay) {
        this.giaHanTuNgay = giaHanTuNgay;
    }

    public Date getGiaHanDenNgay() {
        return this.giaHanDenNgay;
    }
    
    public void setGiaHanDenNgay(Date giaHanDenNgay) {
        this.giaHanDenNgay = giaHanDenNgay;
    }

    public String getSoPhieu() {
        return this.soPhieu;
    }
    
    public void setSoPhieu(String soPhieu) {
        this.soPhieu = soPhieu;
    }

    public String getMaHs() {
        return this.maHs;
    }
    
    public void setMaHs(String maHs) {
        this.maHs = maHs;
    }

    public String getNguoiLap() {
        return this.nguoiLap;
    }
    
    public void setNguoiLap(String nguoiLap) {
        this.nguoiLap = nguoiLap;
    }

    public String getMaCqt() {
        return this.maCqt;
    }
    
    public void setMaCqt(String maCqt) {
        this.maCqt = maCqt;
    }
}