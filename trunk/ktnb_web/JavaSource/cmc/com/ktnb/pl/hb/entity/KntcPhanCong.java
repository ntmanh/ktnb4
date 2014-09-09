package cmc.com.ktnb.pl.hb.entity;



/**
 * KntcPhanCong entity. @author MyEclipse Persistence Tools
 */

public class KntcPhanCong extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {


    // Fields    

     private KntcPhanCongId id;
     private String tenCanbo;
     private String chucVu;
     private String coQuan;
     private String lanTd;
     private String ngayCapNhat;
     private String viTri;
     private String nguoiCapNhat;


    // Constructors

    /** default constructor */
    public KntcPhanCong() {
    }

	/** minimal constructor */
    public KntcPhanCong(KntcPhanCongId id) {
        this.id = id;
    }
    
    /** full constructor */
    public KntcPhanCong(KntcPhanCongId id, String tenCanbo, String chucVu, String coQuan, String lanTd, String ngayCapNhat, String viTri, String nguoiCapNhat) {
        this.id = id;
        this.tenCanbo = tenCanbo;
        this.chucVu = chucVu;
        this.coQuan = coQuan;
        this.lanTd = lanTd;
        this.ngayCapNhat = ngayCapNhat;
        this.viTri = viTri;
        this.nguoiCapNhat = nguoiCapNhat;
    }

   
    // Property accessors

    public KntcPhanCongId getId() {
        return this.id;
    }
    
    public void setId(KntcPhanCongId id) {
        this.id = id;
    }

    public String getTenCanbo() {
        return this.tenCanbo;
    }
    
    public void setTenCanbo(String tenCanbo) {
        this.tenCanbo = tenCanbo;
    }

    public String getChucVu() {
        return this.chucVu;
    }
    
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getCoQuan() {
        return this.coQuan;
    }
    
    public void setCoQuan(String coQuan) {
        this.coQuan = coQuan;
    }

    public String getLanTd() {
        return this.lanTd;
    }
    
    public void setLanTd(String lanTd) {
        this.lanTd = lanTd;
    }

    public String getNgayCapNhat() {
        return this.ngayCapNhat;
    }
    
    public void setNgayCapNhat(String ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public String getViTri() {
        return this.viTri;
    }
    
    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getNguoiCapNhat() {
        return this.nguoiCapNhat;
    }
    
    public void setNguoiCapNhat(String nguoiCapNhat) {
        this.nguoiCapNhat = nguoiCapNhat;
    }
   








}