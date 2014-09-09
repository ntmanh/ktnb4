package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;


/**
 * KntcBaoCao entity. @author MyEclipse Persistence Tools
 */

public class KntcBaoCao extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {


    // Fields    
	 public static final String BAO_CAO_GIAI_TRINH_XAC_MINH="14B/KNTC";
     private String maBc;
     private String maHs;
     private Date thoiDiem;
     private String diaDiem;
     private String noiDung;
     private Long soBanIn;
     private Date ngayCapNhat;
     private String nguoiCapNhat;
     private String maCqt;
     private String tenDoan;
     private Date ngayYc;
     private String nguoiLap;
     private String nguoiLapCvu;
     private String nguoiLapDvi;
	 private String loaiBaoCao;
	 private Long lanTd;

    // Constructors

    /** default constructor */
    public KntcBaoCao() {
    }

	/** minimal constructor */
    public KntcBaoCao(String maBc) {
        this.maBc = maBc;
    }
    
    /** full constructor */
    public KntcBaoCao(String maBc, String maHs, Date thoiDiem, String diaDiem, String noiDung, Long soBanIn, Date ngayCapNhat, String nguoiCapNhat, String maCqt, String tenDoan, Date ngayYc, String nguoiLap, String nguoiLapCvu, String nguoiLapDvi) {
        this.maBc = maBc;
        this.maHs = maHs;
        this.thoiDiem = thoiDiem;
        this.diaDiem = diaDiem;
        this.noiDung = noiDung;
        this.soBanIn = soBanIn;
        this.ngayCapNhat = ngayCapNhat;
        this.nguoiCapNhat = nguoiCapNhat;
        this.maCqt = maCqt;
        this.tenDoan = tenDoan;
        this.ngayYc = ngayYc;
        this.nguoiLap = nguoiLap;
        this.nguoiLapCvu = nguoiLapCvu;
        this.nguoiLapDvi = nguoiLapDvi;
    }

   
    // Property accessors

    public String getMaBc() {
        return this.maBc;
    }
    
    public void setMaBc(String maBc) {
        this.maBc = maBc;
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

    public String getDiaDiem() {
        return this.diaDiem;
    }
    
    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getNoiDung() {
        return this.noiDung;
    }
    
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Long getSoBanIn() {
        return this.soBanIn;
    }
    
    public void setSoBanIn(Long soBanIn) {
        this.soBanIn = soBanIn;
    }

    public Date getNgayCapNhat() {
        return this.ngayCapNhat;
    }
    
    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public String getNguoiCapNhat() {
        return this.nguoiCapNhat;
    }
    
    public void setNguoiCapNhat(String nguoiCapNhat) {
        this.nguoiCapNhat = nguoiCapNhat;
    }

    public String getMaCqt() {
        return this.maCqt;
    }
    
    public void setMaCqt(String maCqt) {
        this.maCqt = maCqt;
    }

    public String getTenDoan() {
        return this.tenDoan;
    }
    
    public void setTenDoan(String tenDoan) {
        this.tenDoan = tenDoan;
    }

    public Date getNgayYc() {
        return this.ngayYc;
    }
    
    public void setNgayYc(Date ngayYc) {
        this.ngayYc = ngayYc;
    }

    public String getNguoiLap() {
        return this.nguoiLap;
    }
    
    public void setNguoiLap(String nguoiLap) {
        this.nguoiLap = nguoiLap;
    }

    public String getNguoiLapCvu() {
        return this.nguoiLapCvu;
    }
    
    public void setNguoiLapCvu(String nguoiLapCvu) {
        this.nguoiLapCvu = nguoiLapCvu;
    }

    public String getNguoiLapDvi() {
        return this.nguoiLapDvi;
    }
    
    public void setNguoiLapDvi(String nguoiLapDvi) {
        this.nguoiLapDvi = nguoiLapDvi;
    }
   	/**
	 * @return
	 */
	public String getLoaiBaoCao() {
		return loaiBaoCao;
	}

	/**
	 * @param string
	 */
	public void setLoaiBaoCao(String string) {
		loaiBaoCao = string;
	}

	/**
	 * @return
	 */
	public Long getLanTd() {
		return lanTd;
	}

	/**
	 * @param long1
	 */
	public void setLanTd(Long long1) {
		lanTd = long1;
	}

}