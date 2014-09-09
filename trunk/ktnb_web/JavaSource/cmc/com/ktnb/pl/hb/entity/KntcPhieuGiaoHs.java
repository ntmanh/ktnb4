package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;


/**
 * KntcPhieuGiaoHs entity. @author MyEclipse Persistence Tools
 */

public class KntcPhieuGiaoHs extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {


    // Fields    

     private String ma,maPhieu;
     private String maHs;
     private Date thoiDiem;
     private String nguoiGiaoMa;
     private String nguoiNhanMa;
     private String donViNhan;
	 private String noiDung,diaDiem;


    // Constructors

    /** default constructor */
    public KntcPhieuGiaoHs() {
    }

	/** minimal constructor */
    public KntcPhieuGiaoHs(String maPhieu, String maHs) {
        this.maPhieu = maPhieu;
        this.maHs = maHs;
    }
    
    /** full constructor */
    public KntcPhieuGiaoHs(String maPhieu, String maHs, Date thoiDiem, String nguoiGiaoMa, String nguoiNhanMa, String donViNhan) {
        this.maPhieu = maPhieu;
        this.maHs = maHs;
        this.thoiDiem = thoiDiem;
        this.nguoiGiaoMa = nguoiGiaoMa;
        this.nguoiNhanMa = nguoiNhanMa;
        this.donViNhan = donViNhan;
    }

   
    // Property accessors

    public String getMaPhieu() {
        return this.maPhieu;
    }
    
    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaHs() {
        return this.maHs;
    }
    
    public void setMaHs(String maHs) {
        this.maHs = maHs;
    }

    public Date getThoiDiem() {
        return this.thoiDiem;
    }
    
    public void setThoiDiem(Date thoiDiem) {
        this.thoiDiem = thoiDiem;
    }

    public String getNguoiGiaoMa() {
        return this.nguoiGiaoMa;
    }
    
    public void setNguoiGiaoMa(String nguoiGiaoMa) {
        this.nguoiGiaoMa = nguoiGiaoMa;
    }

    public String getNguoiNhanMa() {
        return this.nguoiNhanMa;
    }
    
    public void setNguoiNhanMa(String nguoiNhanMa) {
        this.nguoiNhanMa = nguoiNhanMa;
    }

    public String getDonViNhan() {
        return this.donViNhan;
    }
    
    public void setDonViNhan(String donViNhan) {
        this.donViNhan = donViNhan;
    }
   /**
	 * @return
	 */
	public String getNoiDung() {
		return noiDung;
	}

	/**
	 * @param string
	 */
	public void setNoiDung(String string) {
		noiDung = string;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

}