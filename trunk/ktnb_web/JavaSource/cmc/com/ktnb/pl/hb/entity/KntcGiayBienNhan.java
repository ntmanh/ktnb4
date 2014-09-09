package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;


/**
 * KntcGiayBienNhan entity. @author MyEclipse Persistence Tools
 */

public class KntcGiayBienNhan extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {


    // Fields    

     private String maGbn;
     private String maDon;
     private Date thoiDiem;


    // Constructors

    /** default constructor */
    public KntcGiayBienNhan() {
    }

	/** minimal constructor */
    public KntcGiayBienNhan(String maGbn, String maDon) {
        this.maGbn = maGbn;
        this.maDon = maDon;
    }
    
    /** full constructor */
    public KntcGiayBienNhan(String maGbn, String maDon, Date thoiDiem) {
        this.maGbn = maGbn;
        this.maDon = maDon;
        this.thoiDiem = thoiDiem;
    }

   
    // Property accessors

    public String getMaGbn() {
        return this.maGbn;
    }
    
    public void setMaGbn(String maGbn) {
        this.maGbn = maGbn;
    }

    public String getMaDon() {
        return this.maDon;
    }
    
    public void setMaDon(String maDon) {
        this.maDon = maDon;
    }

    public Date getThoiDiem() {
        return this.thoiDiem;
    }
    
    public void setThoiDiem(Date thoiDiem) {
        this.thoiDiem = thoiDiem;
    }
   








}