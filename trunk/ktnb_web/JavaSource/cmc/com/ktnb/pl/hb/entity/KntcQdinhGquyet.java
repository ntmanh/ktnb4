package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;


/**
 * KntcQdinhGquyet entity. @author MyEclipse Persistence Tools
 */

public class KntcQdinhGquyet extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {


    // Fields    
	 private String ma,maCqt;
	 private String maHs;
     private String soQd;
     private String diaDiem;
     private String tenQdhc;
     private String ketLuan;
     private Date ngayTrinhKy;
     private Date ngayKy;
     private String YKienTrinh;
     private Date ngayTrinhDuyet;
     private Date ngayDuyet;
     private String YKienDuyet;
     private Date ngayCapNhat;
     private String nguoiCapNhat;
     private Date ngayLap;
     private String noiDungKn;
     private String ketQuaXm;
     private String canCuQd,vanBanQd;
     private Long trangThai;     
     private String tenVuViec;
     private Date ngayRaQd;
     private String dieu1;
     private String dieu2;
     private Long dieu3ThoiHan,ketThuc;
     private String dieu3NguoiQgMa;
     private String dieu3NguoiQgTen;
	 private String dieu4,benLienQuan,ghiChu;
	 private Long knDungSai;
	 
    // Constructors

    /** default constructor */
    public KntcQdinhGquyet() {
    }

	/** minimal constructor */
    public KntcQdinhGquyet(String soQd, String maHs) {
        this.soQd = soQd;
        this.maHs = maHs;
    }
     public String getSoQd() {
        return this.soQd;
    }
    
    public void setSoQd(String soQd) {
        this.soQd = soQd;
    }

    public String getDiaDiem() {
        return this.diaDiem;
    }
    
    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getTenQdhc() {
        return this.tenQdhc;
    }
    
    public void setTenQdhc(String tenQdhc) {
        this.tenQdhc = tenQdhc;
    }

    public String getKetLuan() {
        return this.ketLuan;
    }
    
    public void setKetLuan(String ketLuan) {
        this.ketLuan = ketLuan;
    }

    public Date getNgayTrinhKy() {
        return this.ngayTrinhKy;
    }
    
    public void setNgayTrinhKy(Date ngayTrinhKy) {
        this.ngayTrinhKy = ngayTrinhKy;
    }

    public Date getNgayKy() {
        return this.ngayKy;
    }
    
    public void setNgayKy(Date ngayKy) {
        this.ngayKy = ngayKy;
    }

    public String getYKienTrinh() {
        return this.YKienTrinh;
    }
    
    public void setYKienTrinh(String YKienTrinh) {
        this.YKienTrinh = YKienTrinh;
    }

    public Date getNgayTrinhDuyet() {
        return this.ngayTrinhDuyet;
    }
    
    public void setNgayTrinhDuyet(Date ngayTrinhDuyet) {
        this.ngayTrinhDuyet = ngayTrinhDuyet;
    }

    public Date getNgayDuyet() {
        return this.ngayDuyet;
    }
    
    public void setNgayDuyet(Date ngayDuyet) {
        this.ngayDuyet = ngayDuyet;
    }

    public String getYKienDuyet() {
        return this.YKienDuyet;
    }
    
    public void setYKienDuyet(String YKienDuyet) {
        this.YKienDuyet = YKienDuyet;
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

    public Date getNgayLap() {
        return this.ngayLap;
    }
    
    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getNoiDungKn() {
        return this.noiDungKn;
    }
    
    public void setNoiDungKn(String noiDungKn) {
        this.noiDungKn = noiDungKn;
    }

    public String getKetQuaXm() {
        return this.ketQuaXm;
    }
    
    public void setKetQuaXm(String ketQuaXm) {
        this.ketQuaXm = ketQuaXm;
    }

    public String getCanCuQd() {
        return this.canCuQd;
    }
    
    public void setCanCuQd(String canCuQd) {
        this.canCuQd = canCuQd;
    }

    public Long getTrangThai() {
        return this.trangThai;
    }
    
    public void setTrangThai(Long trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaHs() {
        return this.maHs;
    }
    
    public void setMaHs(String maHs) {
        this.maHs = maHs;
    }

    public String getTenVuViec() {
        return this.tenVuViec;
    }
    
    public void setTenVuViec(String tenVuViec) {
        this.tenVuViec = tenVuViec;
    }

    public Date getNgayRaQd() {
        return this.ngayRaQd;
    }
    
    public void setNgayRaQd(Date ngayRaQd) {
        this.ngayRaQd = ngayRaQd;
    }

    public String getDieu1() {
        return this.dieu1;
    }
    
    public void setDieu1(String dieu1) {
        this.dieu1 = dieu1;
    }

    public String getDieu2() {
        return this.dieu2;
    }
    
    public void setDieu2(String dieu2) {
        this.dieu2 = dieu2;
    }

    public Long getDieu3ThoiHan() {
        return this.dieu3ThoiHan;
    }
    
    public void setDieu3ThoiHan(Long dieu3ThoiHan) {
        this.dieu3ThoiHan = dieu3ThoiHan;
    }

    public String getDieu3NguoiQgMa() {
        return this.dieu3NguoiQgMa;
    }
    
    public void setDieu3NguoiQgMa(String dieu3NguoiQgMa) {
        this.dieu3NguoiQgMa = dieu3NguoiQgMa;
    }

    public String getDieu3NguoiQgTen() {
        return this.dieu3NguoiQgTen;
    }
    
    public void setDieu3NguoiQgTen(String dieu3NguoiQgTen) {
        this.dieu3NguoiQgTen = dieu3NguoiQgTen;
    }
   
	/**
	 * @return
	 */
	public String getDieu4() {
		return dieu4;
	}

	/**
	 * @param string
	 */
	public void setDieu4(String string) {
		dieu4 = string;
	}

	/**
	 * @return
	 */
	public String getMa() {
		return ma;
	}

	/**
	 * @param string
	 */
	public void setMa(String string) {
		ma = string;
	}

	public String getVanBanQd() {
		return vanBanQd;
	}

	public void setVanBanQd(String vanBanQd) {
		this.vanBanQd = vanBanQd;
	}

	public String getMaCqt() {
		return maCqt;
	}

	public void setMaCqt(String maCqt) {
		this.maCqt = maCqt;
	}

	public String getBenLienQuan() {
		return benLienQuan;
	}

	public void setBenLienQuan(String benLienQuan) {
		this.benLienQuan = benLienQuan;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public Long getKetThuc() {
		return ketThuc;
	}

	public void setKetThuc(Long ketThuc) {
		this.ketThuc = ketThuc;
	}

	public Long getKnDungSai() {
		return knDungSai;
	}

	public void setKnDungSai(Long knDungSai) {
		this.knDungSai = knDungSai;
	}
	
}