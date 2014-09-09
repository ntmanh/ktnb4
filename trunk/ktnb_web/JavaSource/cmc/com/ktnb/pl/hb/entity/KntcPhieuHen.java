package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;


/**
 * KntcPhieuHen entity. @author MyEclipse Persistence Tools
 */

public class KntcPhieuHen extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {


    // Fields    

     private String maPh;
     private Date thoiDiemLapPhieu;
     private String maDon;
     private Date thoiDiemHen;
     private String diaDiemHen;
     private String mucDich;


    // Constructors

    /** default constructor */
    public KntcPhieuHen() {
    }

	/** minimal constructor */
    public KntcPhieuHen(String maPh, String maDon) {
        this.maPh = maPh;
        this.maDon = maDon;
    }
    
    /** full constructor */
    public KntcPhieuHen(String maPh, Date thoiDiemLapPhieu, String maDon, Date thoiDiemHen, String diaDiemHen, String mucDich) {
        this.maPh = maPh;
        this.thoiDiemLapPhieu = thoiDiemLapPhieu;
        this.maDon = maDon;
        this.thoiDiemHen = thoiDiemHen;
        this.diaDiemHen = diaDiemHen;
        this.mucDich = mucDich;
    }

   
    // Property accessors

    public String getMaPh() {
        return this.maPh;
    }
    
    public void setMaPh(String maPh) {
        this.maPh = maPh;
    }

    public Date getThoiDiemLapPhieu() {
        return this.thoiDiemLapPhieu;
    }
    
    public void setThoiDiemLapPhieu(Date thoiDiemLapPhieu) {
        this.thoiDiemLapPhieu = thoiDiemLapPhieu;
    }

    public String getMaDon() {
        return this.maDon;
    }
    
    public void setMaDon(String maDon) {
        this.maDon = maDon;
    }

    public Date getThoiDiemHen() {
        return this.thoiDiemHen;
    }
    
    public void setThoiDiemHen(Date thoiDiemHen) {
        this.thoiDiemHen = thoiDiemHen;
    }

    public String getDiaDiemHen() {
        return this.diaDiemHen;
    }
    
    public void setDiaDiemHen(String diaDiemHen) {
        this.diaDiemHen = diaDiemHen;
    }

    public String getMucDich() {
        return this.mucDich;
    }
    
    public void setMucDich(String mucDich) {
        this.mucDich = mucDich;
    }
   








}