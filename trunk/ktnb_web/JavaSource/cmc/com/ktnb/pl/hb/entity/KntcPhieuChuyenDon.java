package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KntcPhieuChuyenDon entity. @author MyEclipse Persistence Tools
 */

public class KntcPhieuChuyenDon extends PersistentObject implements java.io.Serializable {

	// Cac mau phieu
	public static final String PHIEU_HUONG_DAN_NKN = "05/KNTC";
	public static final String PHIEU_CHUYEN_DON = "06/KNTC";
	public static final String PHIEU_CHUYEN_DON_TO_CAO = "20/KNTC"; 
	public static final String PHIEU_THONG_BAO_KHONG_THU_LY = "07/KNTC";
	public static final String PHIEU_TRA_DON_KN = "08/KNTC"; 
	public static final String PHIEU_THONG_BAO_THU_LY = "09/KNTC";
	public static final String PHIEU_THONG_BAO_THU_LY_TO_CAO = "21/KNTC"; 
	public static final String TC_PHIEU_CHUYEN_CQ_DIEU_TRA = "25A/KNTC"; 
	
	// Fields    
	private String ma;
	private String maPhieu;
	private String maHs;
	private Date thoiDiem;
	private String maCqt;
	private String cqtGiaoMa;
	private String cqtNhanMa;
	private String diaDiem;
	private Date cvDenNgay;
	private String cvDenMa;	
	private String loaiThongBao;
	private String lyDo;
	private Long soNguoiLquan;
	private Date ngayRaQd;
	private String hanhViViPham;
	private String dauHieuToiPham;
	private String cqtGqTen;
	private String cqtGqMa;
	private Date ngayTrinhKy;
	private Date ngayKy;
	private String YKienTrinh;
	private Date ngayTrinhDuyet;
	private Date ngayDuyet;
	private String YKienDuyet;
	private String noiNhanPhieu;
	private String noiDungDon;
	private String canCuQuyetDinh;
	private String donViCoTqChuyenDonDen;
	// Constructors

	/** default constructor */
	public KntcPhieuChuyenDon() {
	}

	public Date getThoiDiem() {
		return this.thoiDiem;
	}

	public void setThoiDiem(Date thoiDiem) {
		this.thoiDiem = thoiDiem;
	}

	public String getCqtGiaoMa() {
		return this.cqtGiaoMa;
	}

	public void setCqtGiaoMa(String cqtGiaoMa) {
		this.cqtGiaoMa = cqtGiaoMa;
	}

	public String getCqtNhanMa() {
		return this.cqtNhanMa;
	}

	public void setCqtNhanMa(String cqtNhanMa) {
		this.cqtNhanMa = cqtNhanMa;
	}

	public String getDiaDiem() {
		return this.diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public Date getCvDenNgay() {
		return this.cvDenNgay;
	}

	public void setCvDenNgay(Date cvDenNgay) {
		this.cvDenNgay = cvDenNgay;
	}

	public String getCvDenMa() {
		return this.cvDenMa;
	}

	public void setCvDenMa(String cvDenMa) {
		this.cvDenMa = cvDenMa;
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

	public String getLoaiThongBao() {
		return this.loaiThongBao;
	}

	public void setLoaiThongBao(String loaiThongBao) {
		this.loaiThongBao = loaiThongBao;
	}

	public String getLyDo() {
		return this.lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public Long getSoNguoiLquan() {
		return this.soNguoiLquan;
	}

	public void setSoNguoiLquan(Long soNguoiLquan) {
		this.soNguoiLquan = soNguoiLquan;
	}

	public Date getNgayRaQd() {
		return this.ngayRaQd;
	}

	public void setNgayRaQd(Date ngayRaQd) {
		this.ngayRaQd = ngayRaQd;
	}

	public String getHanhViViPham() {
		return this.hanhViViPham;
	}

	public void setHanhViViPham(String hanhViViPham) {
		this.hanhViViPham = hanhViViPham;
	}

	public String getDauHieuToiPham() {
		return this.dauHieuToiPham;
	}

	public void setDauHieuToiPham(String dauHieuToiPham) {
		this.dauHieuToiPham = dauHieuToiPham;
	}
	/**
	 * @return
	 */
	public String getMa() {
		return ma;
	}

	/**
	 * @return
	 */
	public String getMaHs() {
		return maHs;
	}

	/**
	 * @return
	 */
	public String getMaPhieu() {
		return maPhieu;
	}

	/**
	 * @param string
	 */
	public void setMa(String string) {
		ma = string;
	}

	/**
	 * @param string
	 */
	public void setMaHs(String string) {
		maHs = string;
	}

	/**
	 * @param string
	 */
	public void setMaPhieu(String string) {
		maPhieu = string;
	}

	/**
	 * @return
	 */
	public String getMaCqt() {
		return maCqt;
	}

	/**
	 * @param string
	 */
	public void setMaCqt(String string) {
		maCqt = string;
	}

		/**
		 * @return
		 */
		public String getCqtGqMa() {
			return cqtGqMa;
		}

	/**
	 * @return
	 */
	public String getCqtGqTen() {
		return cqtGqTen;
	}

		/**
		 * @param string
		 */
		public void setCqtGqMa(String string) {
			cqtGqMa = string;
		}

	/**
	 * @param string
	 */
	public void setCqtGqTen(String string) {
		cqtGqTen = string;
	}

	/**
	 * @return
	 */
	public String getNoiNhanPhieu() {
		return noiNhanPhieu;
	}

	/**
	 * @param string
	 */
	public void setNoiNhanPhieu(String string) {
		noiNhanPhieu = string;
	}

	public String getNoiDungDon() {
		return noiDungDon;
	}

	public void setNoiDungDon(String noiDungDon) {
		this.noiDungDon = noiDungDon;
	}

	public String getCanCuQuyetDinh() {
		return canCuQuyetDinh;
	}

	public void setCanCuQuyetDinh(String canCuQuyetDinh) {
		this.canCuQuyetDinh = canCuQuyetDinh;
	}

	public String getDonViCoTqChuyenDonDen() {
		return donViCoTqChuyenDonDen;
	}

	public void setDonViCoTqChuyenDonDen(String donViCoTqChuyenDonDen) {
		this.donViCoTqChuyenDonDen = donViCoTqChuyenDonDen;
	}

}