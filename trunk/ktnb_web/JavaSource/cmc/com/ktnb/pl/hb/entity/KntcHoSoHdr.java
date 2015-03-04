package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

import cmc.com.ktnb.util.ApplicationContext;

/**
 * KntcHoSoHdr generated by MyEclipse Persistence Tools
 */

public class KntcHoSoHdr extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {

	// Fields

	private String ma, duongDayNong; 

	private String maHs;

	private String maCanBo;

	private String maCqt;

	private Date ngayTiep;

	private String nndTen;

	private Long loaiKntc;

	private String nuqTen, nndNoiCongTac;

	private String nuqChucVu;

	private String nuqCquan;

	private String nuqDiaChi;

	private Date guqTuNgay;

	private Date guqDenNgay;

	private String guqNoiDung;

	private String nndMa;

	private String nuqMa;

	private Date nuqNgayXacNhan;

	private String guqNguoiUq;

	private String guqNuqChucVu;

	private String luatSuMa;

	private String luatSuTen;

	private String lsGiayGthieu;

	private String lsHdMa;

	private String lsHdNoiDung;

	private String hsDaGqMa;

	private String hsDaGqNdungMoi;

	private Date ngayCapNhat;

	private String nguoiCapNhat;

	private String trangThai;

	private String congVanDenMa;

	private String congVanDenDv;

	private Date congVanDenNgay;

	private Date congVanDenNgayVT;

	private String nndMaCongVan;

	private String nndChucVu;

	private String nndDiaChi; 

	private String nndDienThoai;

	private String nndCmtHc;

	private Date nndCmtNgayCap;

	private String nndCmtNoiCap;

	private String nndMst;

	private String lyDoRutDon;

	private Long loaiUq;

	private Long hinhThuc, hinhThucDk, hinhThucDx;

	private Long gayRoi;

	private Long doanKntc;

	private Long doanKntcSoLuong;

	private String tenCqt;

	private Long loaiHs;

	private String donTrichYeu;

	private String maHsCha;

	private Long lanTiep;

	private String soDon;

	private Date ngayLap;

	private Date donDeNgay;

	private String nguoiBiKntcMa;

	private String nguoiBiKntcTen;

	private String nguoiBiKntcDc;

	private String nguoiBiKntcCv;

	private String nguoiBiKntcNoiCt;

	private String noiDung;

	private Long boSungTl;

	private String ghiChu, loaiKetThuc, loaiQh;

	private Date ngayKetThucDuKien;

	private Date ngayTrinhTruongBp;

	private Date ngayTruongBPKy;

	private String ykienTruongBP;

	private Date ngayTrinhTruongCq;

	private Date ngayTruongCQKy;

	private String ykienTruongCQ;
	
	private String donVer;
	
	private String daiDienBsNoiDung;
	
	private String thamQuyenDon;  
	
	private String coNhieuDungTen;
	
	private String thongTinDungTen;
	
	private String vuViec;

	// Constructors

	public Long getBoSungTl() {
		return boSungTl;
	}

	public String getYkienTruongBP() {
		return ykienTruongBP;
	}

	public void setYkienTruongBP(String ykienTruongBP) {
		this.ykienTruongBP = ykienTruongBP;
	}

	public void setBoSungTl(Long boSungTl) {
		this.boSungTl = boSungTl;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getNguoiBiKntcCv() {
		return nguoiBiKntcCv;
	}

	public void setNguoiBiKntcCv(String nguoiBiKntcCv) {
		this.nguoiBiKntcCv = nguoiBiKntcCv;
	}

	public String getNguoiBiKntcDc() {
		return nguoiBiKntcDc;
	}

	public void setNguoiBiKntcDc(String nguoiBiKntcDc) {
		this.nguoiBiKntcDc = nguoiBiKntcDc;
	}

	public String getNguoiBiKntcMa() {
		return nguoiBiKntcMa;
	}

	public void setNguoiBiKntcMa(String nguoiBiKntcMa) {
		this.nguoiBiKntcMa = nguoiBiKntcMa;
	}

	public String getNguoiBiKntcNoiCt() {
		return nguoiBiKntcNoiCt;
	}

	public void setNguoiBiKntcNoiCt(String nguoiBiKntcNoiCt) {
		this.nguoiBiKntcNoiCt = nguoiBiKntcNoiCt;
	}

	public String getNguoiBiKntcTen() {
		return nguoiBiKntcTen;
	}

	public void setNguoiBiKntcTen(String nguoiBiKntcTen) {
		this.nguoiBiKntcTen = nguoiBiKntcTen;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getSoDon() {
		return soDon;
	}

	public void setSoDon(String soDon) {
		this.soDon = soDon;
	}

	/** default constructor */
	public KntcHoSoHdr() {
	}

	/** minimal constructor */
	public KntcHoSoHdr(String ma, String maHs, String maCanBo, String maCqt) {
		this.ma = ma;
		this.maHs = maHs;
		this.maCanBo = maCanBo;
		this.maCqt = maCqt;
	}

	/** full constructor */
	public KntcHoSoHdr(ApplicationContext appContext, KntcHoSoHdr h) {
		// ApplicationContext appContext = (ApplicationContext)
		// request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
		this.ma = h.ma;
		this.maHs = h.maHs;
		this.maCanBo = appContext.getMaCanbo();
		this.nguoiCapNhat = appContext.getTenNsd();
		this.maCqt = h.maCqt;
		this.ngayTiep = h.ngayTiep;
		this.nndTen = h.nndTen;
		this.loaiKntc = h.loaiKntc;
		this.nuqTen = h.nuqTen;
		this.nuqChucVu = h.nuqChucVu;
		this.nuqCquan = h.nuqCquan;
		this.nuqDiaChi = h.nuqDiaChi;
		this.guqTuNgay = h.guqTuNgay;
		this.guqDenNgay = h.guqDenNgay;
		this.guqNoiDung = h.guqNoiDung;
		this.nndMa = h.nndMa;
		this.nuqMa = h.nuqMa;
		this.nuqNgayXacNhan = h.nuqNgayXacNhan;
		this.guqNguoiUq = h.guqNguoiUq;
		this.guqNuqChucVu = h.guqNuqChucVu;
		this.luatSuMa = h.luatSuMa;
		this.luatSuTen = h.luatSuTen;
		this.lsGiayGthieu = h.lsGiayGthieu;
		this.lsHdMa = h.lsHdMa;
		this.lsHdNoiDung = h.lsHdNoiDung;
		this.hsDaGqMa = h.hsDaGqMa;
		this.hsDaGqNdungMoi = h.hsDaGqNdungMoi;
		this.ngayCapNhat = h.ngayCapNhat;
		// this.nguoiCapNhat = h.nguoiCapNhat;
		this.trangThai = h.trangThai;
		this.congVanDenMa = h.congVanDenMa;
		this.congVanDenDv = h.congVanDenDv;
		this.congVanDenNgay = h.congVanDenNgay;
		this.nndMaCongVan = h.nndMaCongVan;
		this.nndChucVu = h.nndChucVu;
		this.nndDiaChi = h.nndDiaChi;
		this.nndDienThoai = h.nndDienThoai;
		this.nndCmtHc = h.nndCmtHc;
		this.nndCmtNgayCap = h.nndCmtNgayCap;
		this.nndCmtNoiCap = h.nndCmtNoiCap;
		this.nndMst = h.nndMst;
		this.lyDoRutDon = h.lyDoRutDon;
		this.loaiUq = h.loaiUq;
		this.hinhThuc = h.hinhThuc;
		this.gayRoi = h.gayRoi;
		this.doanKntc = h.doanKntc;
		this.doanKntcSoLuong = h.doanKntcSoLuong;
		this.tenCqt = h.tenCqt;
		this.loaiHs = h.loaiHs;
		this.donTrichYeu = h.donTrichYeu;
		this.maHsCha = h.maHsCha;
		this.nndNoiCongTac = h.nndNoiCongTac;

		this.soDon = h.soDon;
		this.nguoiBiKntcMa = h.nguoiBiKntcMa;
		this.nguoiBiKntcTen = h.nguoiBiKntcTen;
		this.noiDung = h.noiDung;
		this.boSungTl = h.boSungTl;
		this.ghiChu = h.ghiChu;
		this.nguoiBiKntcDc = h.nguoiBiKntcDc;
		this.nguoiBiKntcCv = h.nguoiBiKntcCv;
		this.nguoiBiKntcNoiCt = h.nguoiBiKntcNoiCt;
		this.ngayLap = h.ngayLap;
		this.ngayKetThucDuKien = h.ngayKetThucDuKien;
	}

	// Property accessors

	public String getMa() {
		return this.ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getMaHs() {
		return this.maHs;
	}

	public void setMaHs(String maHs) {
		this.maHs = maHs;
	}

	public String getMaCanBo() {
		return this.maCanBo;
	}

	public void setMaCanBo(String maCanBo) {
		this.maCanBo = maCanBo;
	}

	public String getMaCqt() {
		return this.maCqt;
	}

	public void setMaCqt(String maCqt) {
		this.maCqt = maCqt;
	}

	public Date getNgayTiep() {
		return this.ngayTiep;
	}

	public void setNgayTiep(Date ngayTiep) {
		this.ngayTiep = ngayTiep;
	}

	public String getNndTen() {
		return this.nndTen;
	}

	public void setNndTen(String nndTen) {
		this.nndTen = nndTen;
	}

	public Long getLoaiKntc() {
		return this.loaiKntc;
	}

	public String getTenLoaiKntc() {
		String loai = String.valueOf(this.loaiKntc.longValue());
		if (loai.equals("1"))
			return "khi\u1EBFu n\u1EA1i";
		else if (loai.equals("2"))
			return "t\u1ED1 c\u00E1o";
		else
			return "h\u1ED7n h\u1EE3p";
	}

	public void setLoaiKntc(Long loaiKntc) {
		this.loaiKntc = loaiKntc;
	}

	public String getNuqTen() {
		return this.nuqTen;
	}

	public void setNuqTen(String nuqTen) {
		this.nuqTen = nuqTen;
	}

	public String getNuqChucVu() {
		return this.nuqChucVu;
	}

	public void setNuqChucVu(String nuqChucVu) {
		this.nuqChucVu = nuqChucVu;
	}

	public String getNuqCquan() {
		return this.nuqCquan;
	}

	public void setNuqCquan(String nuqCquan) {
		this.nuqCquan = nuqCquan;
	}

	public Date getGuqTuNgay() {
		return this.guqTuNgay;
	}

	public void setGuqTuNgay(Date guqTuNgay) {
		this.guqTuNgay = guqTuNgay;
	}

	public Date getGuqDenNgay() {
		return this.guqDenNgay;
	}

	public void setGuqDenNgay(Date guqDenNgay) {
		this.guqDenNgay = guqDenNgay;
	}

	public String getGuqNoiDung() {
		return this.guqNoiDung;
	}

	public void setGuqNoiDung(String guqNoiDung) {
		this.guqNoiDung = guqNoiDung;
	}

	public String getNndMa() {
		return this.nndMa;
	}

	public void setNndMa(String nndMa) {
		this.nndMa = nndMa;
	}

	public String getNuqMa() {
		return this.nuqMa;
	}

	public void setNuqMa(String nuqMa) {
		this.nuqMa = nuqMa;
	}

	public Date getNuqNgayXacNhan() {
		return this.nuqNgayXacNhan;
	}

	public void setNuqNgayXacNhan(Date nuqNgayXacNhan) {
		this.nuqNgayXacNhan = nuqNgayXacNhan;
	}

	public String getGuqNguoiUq() {
		return this.guqNguoiUq;
	}

	public void setGuqNguoiUq(String guqNguoiUq) {
		this.guqNguoiUq = guqNguoiUq;
	}

	public String getGuqNuqChucVu() {
		return this.guqNuqChucVu;
	}

	public void setGuqNuqChucVu(String guqNuqChucVu) {
		this.guqNuqChucVu = guqNuqChucVu;
	}

	public String getLuatSuMa() {
		return this.luatSuMa;
	}

	public void setLuatSuMa(String luatSuMa) {
		this.luatSuMa = luatSuMa;
	}

	public String getLuatSuTen() {
		return this.luatSuTen;
	}

	public void setLuatSuTen(String luatSuTen) {
		this.luatSuTen = luatSuTen;
	}

	public String getLsGiayGthieu() {
		return this.lsGiayGthieu;
	}

	public void setLsGiayGthieu(String lsGiayGthieu) {
		this.lsGiayGthieu = lsGiayGthieu;
	}

	public String getLsHdMa() {
		return this.lsHdMa;
	}

	public void setLsHdMa(String lsHdMa) {
		this.lsHdMa = lsHdMa;
	}

	public String getLsHdNoiDung() {
		return this.lsHdNoiDung;
	}

	public void setLsHdNoiDung(String lsHdNoiDung) {
		this.lsHdNoiDung = lsHdNoiDung;
	}

	public String getHsDaGqMa() {
		return this.hsDaGqMa;
	}

	public void setHsDaGqMa(String hsDaGqMa) {
		this.hsDaGqMa = hsDaGqMa;
	}

	public String getHsDaGqNdungMoi() {
		return this.hsDaGqNdungMoi;
	}

	public void setHsDaGqNdungMoi(String hsDaGqNdungMoi) {
		this.hsDaGqNdungMoi = hsDaGqNdungMoi;
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

	public String getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getCongVanDenMa() {
		return this.congVanDenMa;
	}

	public void setCongVanDenMa(String congVanDenMa) {
		this.congVanDenMa = congVanDenMa;
	}

	public String getCongVanDenDv() {
		return this.congVanDenDv;
	}

	public void setCongVanDenDv(String congVanDenDv) {
		this.congVanDenDv = congVanDenDv;
	}

	public Date getCongVanDenNgay() {
		return this.congVanDenNgay;
	}

	public void setCongVanDenNgay(Date congVanDenNgay) {
		this.congVanDenNgay = congVanDenNgay;
	}

	public String getNndMaCongVan() {
		return this.nndMaCongVan;
	}

	public void setNndMaCongVan(String nndMaCongVan) {
		this.nndMaCongVan = nndMaCongVan;
	}

	public String getNndChucVu() {
		return this.nndChucVu;
	}

	public void setNndChucVu(String nndChucVu) {
		this.nndChucVu = nndChucVu;
	}

	public String getNndDiaChi() {
		return this.nndDiaChi;
	}

	public void setNndDiaChi(String nndDiaChi) {
		this.nndDiaChi = nndDiaChi;
	}

	public String getNndDienThoai() {
		return this.nndDienThoai;
	}

	public void setNndDienThoai(String nndDienThoai) {
		this.nndDienThoai = nndDienThoai;
	}

	public String getNndCmtHc() {
		return this.nndCmtHc;
	}

	public void setNndCmtHc(String nndCmtHc) {
		this.nndCmtHc = nndCmtHc;
	}

	public Date getNndCmtNgayCap() {
		return this.nndCmtNgayCap;
	}

	public void setNndCmtNgayCap(Date nndCmtNgayCap) {
		this.nndCmtNgayCap = nndCmtNgayCap;
	}

	public String getNndCmtNoiCap() {
		return this.nndCmtNoiCap;
	}

	public void setNndCmtNoiCap(String nndCmtNoiCap) {
		this.nndCmtNoiCap = nndCmtNoiCap;
	}

	public String getNndMst() {
		return this.nndMst;
	}

	public void setNndMst(String nndMst) {
		this.nndMst = nndMst;
	}

	public String getLyDoRutDon() {
		return this.lyDoRutDon;
	}

	public void setLyDoRutDon(String lyDoRutDon) {
		this.lyDoRutDon = lyDoRutDon;
	}

	public Long getLoaiUq() {
		return this.loaiUq;
	}

	public void setLoaiUq(Long loaiUq) {
		this.loaiUq = loaiUq;
	}

	public Long getHinhThuc() {
		return this.hinhThuc;
	}

	public void setHinhThuc(Long hinhThuc) {
		this.hinhThuc = hinhThuc;
	}

	public Long getGayRoi() {
		return this.gayRoi;
	}

	public void setGayRoi(Long gayRoi) {
		this.gayRoi = gayRoi;
	}

	public Long getDoanKntc() {
		return this.doanKntc;
	}

	public void setDoanKntc(Long doanKntc) {
		this.doanKntc = doanKntc;
	}

	public Long getDoanKntcSoLuong() {
		return this.doanKntcSoLuong;
	}

	public void setDoanKntcSoLuong(Long doanKntcSoLuong) {
		this.doanKntcSoLuong = doanKntcSoLuong;
	}

	public String getTenCqt() {
		return this.tenCqt;
	}

	public void setTenCqt(String tenCqt) {
		this.tenCqt = tenCqt;
	}

	public Long getLoaiHs() {
		return this.loaiHs;
	}

	public void setLoaiHs(Long loaiHs) {
		this.loaiHs = loaiHs;
	}

	public String getDonTrichYeu() {
		return this.donTrichYeu;
	}

	public void setDonTrichYeu(String donTrichYeu) {
		this.donTrichYeu = donTrichYeu;
	}

	public String getMaHsCha() {
		return this.maHsCha;
	}

	public void setMaHsCha(String maHsCha) {
		this.maHsCha = maHsCha;
	}

	public String getDuongDayNong() {
		return duongDayNong;
	}

	public void setDuongDayNong(String duongDayNong) {
		this.duongDayNong = duongDayNong;
	}

	public Date getCongVanDenNgayVT() {
		return congVanDenNgayVT;
	}

	public void setCongVanDenNgayVT(Date congVanDenNgayXL) {
		this.congVanDenNgayVT = congVanDenNgayXL;
	}

	public Long getHinhThucDk() {
		return hinhThucDk;
	}

	public void setHinhThucDk(Long hinhThucDk) {
		this.hinhThucDk = hinhThucDk;
	}

	public Long getHinhThucDx() {
		return hinhThucDx;
	}

	public void setHinhThucDx(Long hinhThucDx) {
		this.hinhThucDx = hinhThucDx;
	}

	public String getNndNoiCongTac() {
		return nndNoiCongTac;
	}

	public void setNndNoiCongTac(String nndNoiCongTac) {
		this.nndNoiCongTac = nndNoiCongTac;
	}

	public Long getLanTiep() {
		return lanTiep;
	}

	public void setLanTiep(Long lanTiep) {
		this.lanTiep = lanTiep;
	}

	public String getNuqDiaChi() {
		return nuqDiaChi;
	}

	public void setNuqDiaChi(String nuqDiaChi) {
		this.nuqDiaChi = nuqDiaChi;
	}

	public Date getDonDeNgay() {
		return donDeNgay;
	}

	public void setDonDeNgay(Date donDeNgay) {
		this.donDeNgay = donDeNgay;
	}

	public Date getNgayKetThucDuKien() {
		return ngayKetThucDuKien;
	}

	public void setNgayKetThucDuKien(Date ngayKetThucDuKien) {
		this.ngayKetThucDuKien = ngayKetThucDuKien;
	}

	public String getLoaiKetThuc() {
		return loaiKetThuc;
	}

	public void setLoaiKetThuc(String loaiKetThuc) {
		this.loaiKetThuc = loaiKetThuc;
	}

	public Date getNgayTrinhTruongBp() {
		return ngayTrinhTruongBp;
	}

	public void setNgayTrinhTruongBp(Date ngayTrinhTruongBp) {
		this.ngayTrinhTruongBp = ngayTrinhTruongBp;
	}

	public Date getNgayTruongBPKy() {
		return ngayTruongBPKy;
	}

	public void setNgayTruongBPKy(Date ngayTruongBPKy) {
		this.ngayTruongBPKy = ngayTruongBPKy;
	}

	public Date getNgayTrinhTruongCq() {
		return ngayTrinhTruongCq;
	}

	public void setNgayTrinhTruongCq(Date ngayTrinhTruongCq) {
		this.ngayTrinhTruongCq = ngayTrinhTruongCq;
	}

	public Date getNgayTruongCQKy() {
		return ngayTruongCQKy;
	}

	public void setNgayTruongCQKy(Date ngayTruongCQKy) {
		this.ngayTruongCQKy = ngayTruongCQKy;
	}

	public String getYkienTruongCQ() {
		return ykienTruongCQ;
	}

	public void setYkienTruongCQ(String ykienTruongCQ) {
		this.ykienTruongCQ = ykienTruongCQ;
	}

	public String getLoaiQh() {
		return loaiQh;
	}

	public void setLoaiQh(String loaiQh) {
		this.loaiQh = loaiQh;
	}

	
	public String getDonVer() {
		return donVer;
	}

	public void setDonVer(String donVer) {
		this.donVer = donVer;
	}

	
	public String getDaiDienBsNoiDung() {
		return daiDienBsNoiDung;
	}

	public void setDaiDienBsNoiDung(String daiDienBsNoiDung) {
		this.daiDienBsNoiDung = daiDienBsNoiDung;
	}

	public String getThamQuyenDon() {
		return thamQuyenDon;
	}

	public void setThamQuyenDon(String thamQuyenDon) {
		this.thamQuyenDon = thamQuyenDon;
	}
	
	public String getCoNhieuDungTen() {
		return coNhieuDungTen;
	}

	public void setCoNhieuDungTen(String coNhieuDungTen) {
		this.coNhieuDungTen = coNhieuDungTen;
	}

	public String getThongTinDungTen() {
		return thongTinDungTen;
	}

	public void setThongTinDungTen(String thongTinDungTen) {
		this.thongTinDungTen = thongTinDungTen;
	}

	public String getVuViec() {
		return vuViec;
	}

	public void setVuViec(String vuViec) {
		this.vuViec = vuViec;
	}

	public String getTrangThaiText() {
		if ("1603".equals(this.trangThai))
			return "B\u1ED5 sung HSTL";

		if ("1605".equals(this.trangThai))
			return "Chuy\u1EC3n HS sang BPHC";

		if ("1607".equals(this.trangThai))
			return "Ch\u1EDD v\u0103n th\u01B0 x\u1EED l\u00FD";

		if ("1609".equals(this.trangThai))
			return "Ph\u00E2n lo\u1EA1i, \u0111\u1EC1 xu\u1EA5t";

		if ("1611".equals(this.trangThai))
			return "X\u00E1c minh";

		if ("1613".equals(this.trangThai))
			return "\u0110ang gi\u1EA3i quy\u1EBFt";

		if ("1615".equals(this.trangThai))
			return "Q\u0110GQ KN / KLND TC";

		if ("1617".equals(this.trangThai))
			return "K\u1EBFt th\u00FAc";

		return this.trangThai;
	}
}