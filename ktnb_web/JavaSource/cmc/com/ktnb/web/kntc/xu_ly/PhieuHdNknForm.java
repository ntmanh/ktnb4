package cmc.com.ktnb.web.kntc.xu_ly;

import cmc.com.ktnb.pl.hb.entity.KntcPhieuChuyenDon;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.dung_chung.form.XacNhanForm;

/**
 * Phiếu hướng dẫn người khiếu nại Form
 * @author Ntthu Created on 29/03/2011
 */
public class PhieuHdNknForm extends XacNhanForm {

	private String congVanSo;

	private String congVanNgay;

	// Thong tin Ho so
	private String maPhieu;

	private String ngayCvDen;

	private String donCvDeNgay;

	private String noiDungDon;

	private String nguoiCqDvKn;

	private String diaChiCqDvKn;

	private String maHidden;

	private String cqtGqTen;

	private String cqtGqMa;

	private String congVanDenSo;

	private String loaiPhieu;

	private String lyDo; // Ly do khong thu ly don

	private String noiNhan, hanhViViPham, dauHieuToiPham, soNguoiLienQuan; // 25A-TC

	public KntcPhieuChuyenDon toEntity(ApplicationContext c) throws Exception {
		KntcPhieuChuyenDon p = new KntcPhieuChuyenDon();
		p.setMa(this.maHidden);
		p.setLoaiThongBao(this.loaiPhieu);
		p.setMaHs(this.getMaHoSo());
		p.setDiaDiem(this.getDiaDiem());
		p.setThoiDiem(Formater.str2date(this.getThoiDiem()));
		p.setCvDenNgay(Formater.str2date(this.congVanNgay));
		p.setCvDenMa(this.congVanSo);
		p.setMaCqt(c.getMaCqt());
		p.setMaPhieu(this.maPhieu==null?"":this.maPhieu);
		p.setCqtGqMa(this.cqtGqMa);
		p.setCqtGqTen(this.cqtGqTen);
		p.setNgayDuyet(Formater.str2date(this.getNgayDuyet()));
		p.setNgayTrinhDuyet(Formater.str2date(this.getNgayTrinhDuyet()));
		p.setNgayTrinhKy(Formater.str2date(this.getNgayTrinhKy()));
		p.setNgayKy(Formater.str2date(this.getNgayKy()));
		p.setYKienTrinh(this.getKienTrinh());
		p.setYKienDuyet(this.getKienDuyet());
		p.setLyDo(this.lyDo);
		if (!Formater.isNull(this.soNguoiLienQuan))
			p.setSoNguoiLquan(new Long(this.soNguoiLienQuan));
		p.setHanhViViPham(this.hanhViViPham);
		p.setDauHieuToiPham(this.dauHieuToiPham);
		p.setNoiNhanPhieu(this.noiNhan);
		p.setNoiDungDon(this.getNoiDungDon());
		return p;
	}

	public void fromEntity(KntcPhieuChuyenDon kq) {
		this.maHidden = kq.getMa();
		this.setMaHoSo(kq.getMaHs());
		this.maPhieu = kq.getMaPhieu();
		this.congVanNgay = Formater.date2str(kq.getCvDenNgay());
		this.congVanSo = kq.getCvDenMa();
		this.setDiaDiem(kq.getDiaDiem());
		this.setThoiDiem(Formater.date2str(kq.getThoiDiem()));
		this.setKienDuyet(kq.getYKienDuyet());
		this.setKienTrinh(kq.getYKienTrinh());
		this.setNgayTrinhDuyet(Formater.date2str(kq.getNgayTrinhDuyet()));
		this.setNgayDuyet(Formater.date2str(kq.getNgayDuyet()));
		this.setNgayTrinhKy(Formater.date2str(kq.getNgayTrinhKy()));
		this.setNgayKy(Formater.date2str(kq.getNgayKy()));
		this.setCqtGqMa(kq.getCqtGqMa());
		this.setCqtGqTen(kq.getCqtGqTen());
		this.setLyDo(kq.getLyDo());
		this.setHanhViViPham(kq.getHanhViViPham());
		this.setDauHieuToiPham(kq.getDauHieuToiPham());
		this.setNoiNhan(kq.getNoiNhanPhieu());
		if (kq.getSoNguoiLquan() != null)
			this.soNguoiLienQuan = kq.getSoNguoiLquan().toString();
		this.setNoiDungDon(kq.getNoiDungDon());
	}

	/**
	 * @return
	 */
	public String getCongVanNgay() {
		return congVanNgay;
	}

	/**
	 * @return
	 */
	public String getCongVanSo() {
		return congVanSo;
	}

	/**
	 * @return
	 */
	public String getMaPhieu() {
		return maPhieu;
	}

	/**
	 * @return
	 */
	public String getNoiDungDon() {
		return noiDungDon;
	}

	/**
	 * @param string
	 */
	public void setCongVanNgay(String string) {
		congVanNgay = string;
	}

	/**
	 * @param string
	 */
	public void setCongVanSo(String string) {
		congVanSo = string;
	}

	/**
	 * @param string
	 */
	public void setMaPhieu(String string) {
		maPhieu = string;
	}

	/**
	 * @param string
	 */
	public void setNoiDungDon(String string) {
		noiDungDon = string;
	}

	/**
	 * @return
	 */
	public String getDiaChiCqDvKn() {
		return diaChiCqDvKn;
	}

	/**
	 * @return
	 */
	public String getDonCvDeNgay() {
		return donCvDeNgay;
	}

	/**
	 * @return
	 */
	public String getNgayCvDen() {
		return ngayCvDen;
	}

	/**
	 * @return
	 */
	public String getNguoiCqDvKn() {
		return nguoiCqDvKn;
	}

	/**
	 * @param string
	 */
	public void setDiaChiCqDvKn(String string) {
		diaChiCqDvKn = string;
	}

	/**
	 * @param string
	 */
	public void setDonCvDeNgay(String string) {
		donCvDeNgay = string;
	}

	/**
	 * @param string
	 */
	public void setNgayCvDen(String string) {
		ngayCvDen = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiCqDvKn(String string) {
		nguoiCqDvKn = string;
	}

	/**
	 * @return
	 */
	public String getMaHidden() {
		return maHidden;
	}

	/**
	 * @param string
	 */
	public void setMaHidden(String string) {
		maHidden = string;
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
	public String getCongVanDenSo() {
		return congVanDenSo;
	}

	/**
	 * @param string
	 */
	public void setCongVanDenSo(String string) {
		congVanDenSo = string;
	}

	/**
	 * @return
	 */
	public String getLoaiPhieu() {
		return loaiPhieu;
	}

	/**
	 * @param string
	 */
	public void setLoaiPhieu(String string) {
		loaiPhieu = string;
	}

	/**
	 * @return
	 */
	public String getLyDo() {
		return lyDo;
	}

	/**
	 * @param string
	 */
	public void setLyDo(String string) {
		lyDo = string;
	}

	/**
	 * @return
	 */
	public String getDauHieuToiPham() {
		return dauHieuToiPham;
	}

	/**
	 * @return
	 */
	public String getHanhViViPham() {
		return hanhViViPham;
	}

	/**
	 * @return
	 */
	public String getNoiNhan() {
		return noiNhan;
	}

	/**
	 * @return
	 */
	public String getSoNguoiLienQuan() {
		return soNguoiLienQuan;
	}

	/**
	 * @param string
	 */
	public void setDauHieuToiPham(String string) {
		dauHieuToiPham = string;
	}

	/**
	 * @param string
	 */
	public void setHanhViViPham(String string) {
		hanhViViPham = string;
	}

	/**
	 * @param string
	 */
	public void setNoiNhan(String string) {
		noiNhan = string;
	}

	/**
	 * @param string
	 */
	public void setSoNguoiLienQuan(String string) {
		soNguoiLienQuan = string;
	}

}
