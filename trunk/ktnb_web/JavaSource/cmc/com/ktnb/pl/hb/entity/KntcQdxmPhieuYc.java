package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;


/**
 * KntcQdxmPhieuYc entity. @author MyEclipse Persistence Tools
 */

public class KntcQdxmPhieuYc extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {


    // Fields    
	 public static final String PHIEU_YC_GIAI_TRINH="14A/KNTC";
	 public static final String PHIEU_YC_HO_SO_TL="13/KNTC";
	 public static final String PHIEU_LAY_Y_KIEN_TU_VAN="15A/KNTC";
	 public static final String PHIEU_TRUNG_CAU_GIAM_DINH="15B/KNTC";
	 private String ma;
     private String maPhieu;
	 private String maHoSo;
     private String kntcQdinhXm;
     private String diaDiem;
     private Date ngayLap;
     private String donViYcgt;
     private String yeuCauYcgt;
     private Date thoiDiemYcgt;
     private String diaDiemYcgt;
     private Long lanYc;
     private String ycBaoCao;
     private String ycHoSo;
     private String nguoiNhanBc;
     private String nguoiNhanBcChucVu;
     private String nguoiNhanPhieu;
     private String nguoiNhanPhieuChucVu;
     private Date thoiGianNhanPhieu;
     private String loaiPhieu;
     private String donViYkien;
	 private Long lanTd;

    // Constructors

    /** default constructor */
    public KntcQdxmPhieuYc() {
    }

	
    // Property accessors

    public String getMaPhieu() {
        return this.maPhieu;
    }
    
    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
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

    public String getDonViYcgt() {
        return this.donViYcgt;
    }
    
    public void setDonViYcgt(String donViYcgt) {
        this.donViYcgt = donViYcgt;
    }

    public String getYeuCauYcgt() {
        return this.yeuCauYcgt;
    }
    
    public void setYeuCauYcgt(String yeuCauYcgt) {
        this.yeuCauYcgt = yeuCauYcgt;
    }

    public Date getThoiDiemYcgt() {
        return this.thoiDiemYcgt;
    }
    
    public void setThoiDiemYcgt(Date thoiDiemYcgt) {
        this.thoiDiemYcgt = thoiDiemYcgt;
    }

    public String getDiaDiemYcgt() {
        return this.diaDiemYcgt;
    }
    
    public void setDiaDiemYcgt(String diaDiemYcgt) {
        this.diaDiemYcgt = diaDiemYcgt;
    }

    public Long getLanYc() {
        return this.lanYc;
    }
    
    public void setLanYc(Long lanYc) {
        this.lanYc = lanYc;
    }

    public String getYcBaoCao() {
        return this.ycBaoCao;
    }
    
    public void setYcBaoCao(String ycBaoCao) {
        this.ycBaoCao = ycBaoCao;
    }

    public String getYcHoSo() {
        return this.ycHoSo;
    }
    
    public void setYcHoSo(String ycHoSo) {
        this.ycHoSo = ycHoSo;
    }

    public String getNguoiNhanBc() {
        return this.nguoiNhanBc;
    }
    
    public void setNguoiNhanBc(String nguoiNhanBc) {
        this.nguoiNhanBc = nguoiNhanBc;
    }

    public String getNguoiNhanBcChucVu() {
        return this.nguoiNhanBcChucVu;
    }
    
    public void setNguoiNhanBcChucVu(String nguoiNhanBcChucVu) {
        this.nguoiNhanBcChucVu = nguoiNhanBcChucVu;
    }

    public String getNguoiNhanPhieu() {
        return this.nguoiNhanPhieu;
    }
    
    public void setNguoiNhanPhieu(String nguoiNhanPhieu) {
        this.nguoiNhanPhieu = nguoiNhanPhieu;
    }

    public String getNguoiNhanPhieuChucVu() {
        return this.nguoiNhanPhieuChucVu;
    }
    
    public void setNguoiNhanPhieuChucVu(String nguoiNhanPhieuChucVu) {
        this.nguoiNhanPhieuChucVu = nguoiNhanPhieuChucVu;
    }

    public Date getThoiGianNhanPhieu() {
        return this.thoiGianNhanPhieu;
    }
    
    public void setThoiGianNhanPhieu(Date thoiGianNhanPhieu) {
        this.thoiGianNhanPhieu = thoiGianNhanPhieu;
    }

    public String getLoaiPhieu() {
        return this.loaiPhieu;
    }
    
    public void setLoaiPhieu(String loaiPhieu) {
        this.loaiPhieu = loaiPhieu;
    }

    public String getDonViYkien() {
        return this.donViYkien;
    }
    
    public void setDonViYkien(String donViYkien) {
        this.donViYkien = donViYkien;
    }
   
	/**
	 * @return
	 */
	public String getKntcQdinhXm() {
		return kntcQdinhXm;
	}

	/**
	 * @return
	 */
	public String getMaHoSo() {
		return maHoSo;
	}

	/**
	 * @param string
	 */
	public void setKntcQdinhXm(String string) {
		kntcQdinhXm = string;
	}

	/**
	 * @param string
	 */
	public void setMaHoSo(String string) {
		maHoSo = string;
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


	public String getMa() {
		return ma;
	}


	public void setMa(String ma) {
		this.ma = ma;
	}

}