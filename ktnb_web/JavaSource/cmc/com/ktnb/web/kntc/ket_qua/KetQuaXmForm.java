package cmc.com.ktnb.web.kntc.ket_qua;

import java.math.BigDecimal;
import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.KntcKqxmKluatKnghi;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.dung_chung.form.XacNhanForm;

/**
 * Kết quả xác minh form
 * 
 * @author Ntthu Created on Nov 2, 2010
 */
public class KetQuaXmForm extends XacNhanForm {

	// Thong tin Ho so
	private String maHidden;

	private String soQd;

	private String maKq;

	private String noiDungViPham;

	private String noiDungDon;

	private String ketQuaXm;

	// private String kienNghi;
	private String tuNgay, denNgay;

	private String phanTichKq;

	private String xlyHinhThuc;

	private String xlySoNguoi;

	private String denBuSoNguoi;

	private String knthNnSoTien;

	private String knthNnDat;

	private String knthNnLoai;

	private String knthNnTriGia;

	private String htcdTien;

	private String htcdLoai;

	private String htcdTriGia;

	private String htcdDat;

	private String lyDoNtc;

	private String kienKhacTrongDoan;

	private String kienTdTtcqt;
	
	private String isGiaiQuyetNgay;
	
	public KetQuaXmForm() {
		super();
	}

	public void fromEntity(KntcKqxmKluatKnghi kq) {
		if (kq.getDenBuSoNguoi() != null)
			this.denBuSoNguoi = String.valueOf(kq.getDenBuSoNguoi());
		if (kq.getXlySoNguoi() != null)
			this.xlySoNguoi = String.valueOf(kq.getXlySoNguoi());
		this.htcdDat = Formater.getFromDouble(kq.getHtcdDat());
		this.htcdTien = Formater.getFromDouble(kq.getHtcdTien());
		this.htcdTriGia = Formater.getFromDouble(kq.getHtcdTriGia());
		this.htcdLoai = kq.getHtcdLoai();
		this.tuNgay = Formater.date2str(kq.getTuNgayGq());
		this.denNgay = Formater.date2str(kq.getDenNgayGq());
		this.ketQuaXm = kq.getKetQuaXm();
		// this.kienNghi = kq.getKienNghi();

		this.knthNnDat = Formater.getFromDouble(kq.getKnthNnDat());
		this.knthNnSoTien = Formater.getFromDouble(kq.getKnthNnSoTien());
		this.knthNnTriGia = Formater.getFromDouble(kq.getKnthNnTriGia());
		this.knthNnLoai = kq.getKnthNnLoai();
		this.setMaHoSo(kq.getMaHs());
		this.maHidden = kq.getMa();
		this.maKq = kq.getMaQd();
		this.noiDungDon = kq.getNoiDungKn();
		this.noiDungViPham = kq.getQuyetDinhHc();
		this.phanTichKq = kq.getLoaiKq();
		this.setDiaDiem(kq.getDiaDiem());
		this.setThoiDiem(Formater.date2str(kq.getNgayLap()));
		this.soQd = kq.getMaQd();
		this.xlyHinhThuc = kq.getXlyGiaiPhap();

		this.lyDoNtc = kq.getLyDoNtc();
		this.kienKhacTrongDoan = kq.getYKienKhacTrongDoan();
		this.kienTdTtcqt = kq.getYKienTdTtcqt();

		this.setKienDuyet(kq.getYKienDuyet());
		this.setKienTrinh(kq.getYKienTrinh());
		this.setNgayTrinhDuyet(Formater.date2str(kq.getNgayTrinhDuyet()));
		this.setNgayDuyet(Formater.date2str(kq.getNgayDuyet()));
		this.setNgayTrinhKy(Formater.date2str(kq.getNgayTrinhKy()));
		this.setNgayKy(Formater.date2str(kq.getNgayKy()));
	}

	public KntcKqxmKluatKnghi toKqxmKluatKnghi(ApplicationContext c) throws Exception {
		KntcKqxmKluatKnghi qd = new KntcKqxmKluatKnghi();
		qd.setMaHs(this.getMaHoSo());
		qd.setMa(this.maHidden);
		qd.setMaQd(this.getSoQd());
		qd.setDiaDiem(this.getDiaDiem());
		qd.setNgayLap(Formater.str2date(this.getThoiDiem()));
		qd.setNgayCapNhat(new Date());
		qd.setNguoiCapNhat(c.getTenNsd());
		qd.setMaCqt(c.getMaCqt());
		qd.setTuNgayGq(Formater.str2date(this.tuNgay));
		qd.setDenNgayGq(Formater.str2date(this.denNgay));
		// Thong tin ky duyet
		qd.setNgayDuyet(Formater.str2date(this.getNgayDuyet()));
		qd.setNgayTrinhDuyet(Formater.str2date(this.getNgayTrinhDuyet()));
		qd.setNgayTrinhKy(Formater.str2date(this.getNgayTrinhKy()));
		qd.setNgayKy(Formater.str2date(this.getNgayKy()));
		qd.setYKienTrinh(this.getKienTrinh());
		qd.setYKienDuyet(this.getKienDuyet());
		qd.setNoiDungKn(this.noiDungDon);
		qd.setQuyetDinhHc(this.noiDungViPham);
		qd.setKetQuaXm(this.ketQuaXm);

		qd.setLyDoNtc(this.lyDoNtc);
		qd.setYKienKhacTrongDoan(this.kienKhacTrongDoan);
		qd.setYKienTdTtcqt(this.kienTdTtcqt);

		// qd.setKienNghi(this.kienNghi);
		if (!Formater.isNull(this.denBuSoNguoi))
			qd.setDenBuSoNguoi(new Long(this.denBuSoNguoi));

		if (!Formater.isNull(this.xlySoNguoi))
			qd.setXlySoNguoi(new Long(this.xlySoNguoi));
		if (!Formater.isNull(this.knthNnDat))
			qd.setKnthNnDat(new Double(Formater.toDouble((this.knthNnDat))));
		if (!Formater.isNull(this.knthNnSoTien))
			qd.setKnthNnSoTien(new Double(Formater.toDouble(this.knthNnSoTien)));
		if (!Formater.isNull(this.knthNnTriGia))
			qd.setKnthNnTriGia(new Double(Formater.toDouble(this.knthNnTriGia)));
		if (!Formater.isNull(this.htcdDat))
			qd.setHtcdDat(new Double(Formater.toDouble(this.htcdDat)));
		if (!Formater.isNull(this.htcdTien))
			qd.setHtcdTien(new Double(Formater.toDouble(this.htcdTien)));
		if (!Formater.isNull(this.htcdTriGia))
			qd.setHtcdTriGia(new Double(Formater.toDouble(this.htcdTriGia)));
		qd.setLoaiKq(this.phanTichKq);
		qd.setXlyGiaiPhap(this.xlyHinhThuc);
		qd.setHtcdLoai(this.htcdLoai);
		qd.setKnthNnLoai(this.knthNnLoai);
		return qd;
	}

	/**
	 * @return
	 */
	public String getSoQd() {
		return soQd;
	}

	/**
	 * @param string
	 */
	public void setSoQd(String string) {
		soQd = string;
	}

	/**
	 * @return
	 */
	public String getKetQuaXm() {
		return ketQuaXm;
	}

	/**
	 * @return
	 * 
	 * public String getKienNghi() { return kienNghi; }
	 */

	/**
	 * @return
	 */
	public String getNoiDungDon() {
		return noiDungDon;
	}

	/**
	 * @return
	 */
	public String getNoiDungViPham() {
		return noiDungViPham;
	}

	/**
	 * @param string
	 */
	public void setKetQuaXm(String string) {
		ketQuaXm = string;
	}

	/**
	 * @param string
	 * 
	 * public void setKienNghi(String string) { kienNghi = string; }
	 */

	/**
	 * @param string
	 */
	public void setNoiDungDon(String string) {
		noiDungDon = string;
	}

	/**
	 * @param string
	 */
	public void setNoiDungViPham(String string) {
		noiDungViPham = string;
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
	public String getDenBuSoNguoi() {
		return denBuSoNguoi;
	}

	/**
	 * @return
	 */
	public String getHtcdDat() {
		return htcdDat;
	}

	/**
	 * @return
	 */
	public String getHtcdLoai() {
		return htcdLoai;
	}

	/**
	 * @return
	 */
	public String getHtcdTien() {
		return htcdTien;
	}

	/**
	 * @return
	 */
	public String getHtcdTriGia() {
		return htcdTriGia;
	}

	/**
	 * @return
	 */
	public String getKnthNnDat() {
		return knthNnDat;
	}

	/**
	 * @return
	 */
	public String getKnthNnLoai() {
		return knthNnLoai;
	}

	/**
	 * @return
	 */
	public String getKnthNnSoTien() {
		return knthNnSoTien;
	}

	/**
	 * @return
	 */
	public String getKnthNnTriGia() {
		return knthNnTriGia;
	}

	/**
	 * @return
	 */
	public String getMaKq() {
		return maKq;
	}

	/**
	 * @return
	 */
	public String getPhanTichKq() {
		return phanTichKq;
	}

	/**
	 * @return
	 */
	public String getXlyHinhThuc() {
		return xlyHinhThuc;
	}

	/**
	 * @return
	 */
	public String getXlySoNguoi() {
		return xlySoNguoi;
	}

	/**
	 * @param string
	 */
	public void setDenBuSoNguoi(String string) {
		denBuSoNguoi = string;
	}

	/**
	 * @param string
	 */
	public void setHtcdDat(String string) {
		htcdDat = string;
	}

	/**
	 * @param string
	 */
	public void setHtcdLoai(String string) {
		htcdLoai = string;
	}

	/**
	 * @param string
	 */
	public void setHtcdTien(String string) {
		htcdTien = string;
	}

	/**
	 * @param string
	 */
	public void setHtcdTriGia(String string) {
		htcdTriGia = string;
	}

	/**
	 * @param string
	 */
	public void setKnthNnDat(String string) {
		knthNnDat = string;
	}

	/**
	 * @param string
	 */
	public void setKnthNnLoai(String string) {
		knthNnLoai = string;
	}

	/**
	 * @param string
	 */
	public void setKnthNnSoTien(String string) {
		knthNnSoTien = string;
	}

	/**
	 * @param string
	 */
	public void setKnthNnTriGia(String string) {
		knthNnTriGia = string;
	}

	/**
	 * @param string
	 */
	public void setMaKq(String string) {
		maKq = string;
	}

	/**
	 * @param string
	 */
	public void setPhanTichKq(String string) {
		phanTichKq = string;
	}

	/**
	 * @param string
	 */
	public void setXlyHinhThuc(String string) {
		xlyHinhThuc = string;
	}

	/**
	 * @param string
	 */
	public void setXlySoNguoi(String string) {
		xlySoNguoi = string;
	}

	/**
	 * @return
	 */
	public String getKienKhacTrongDoan() {
		return kienKhacTrongDoan;
	}

	/**
	 * @return
	 */
	public String getKienTdTtcqt() {
		return kienTdTtcqt;
	}

	/**
	 * @return
	 */
	public String getLyDoNtc() {
		return lyDoNtc;
	}

	/**
	 * @param string
	 */
	public void setKienKhacTrongDoan(String string) {
		kienKhacTrongDoan = string;
	}

	/**
	 * @param string
	 */
	public void setKienTdTtcqt(String string) {
		kienTdTtcqt = string;
	}

	/**
	 * @param string
	 */
	public void setLyDoNtc(String string) {
		lyDoNtc = string;
	}

	public String getDenNgay() {
		return denNgay;
	}

	public void setDenNgay(String denNgay) {
		this.denNgay = denNgay;
	}

	public String getTuNgay() {
		return tuNgay;
	}

	public void setTuNgay(String tuNgay) {
		this.tuNgay = tuNgay;
	}

	public String getIsGiaiQuyetNgay() {
		return isGiaiQuyetNgay;
	}

	public void setIsGiaiQuyetNgay(String isGiaiQuyetNgay) {
		this.isGiaiQuyetNgay = isGiaiQuyetNgay;
	}

}
