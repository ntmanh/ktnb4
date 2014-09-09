package cmc.com.ktnb.web.kntc.ket_qua;

import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.KntcKquaXmDtl;
import cmc.com.ktnb.pl.hb.entity.KntcKqxmKluatKnghi;
import cmc.com.ktnb.service.kntc.KntcXacMinh;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.dung_chung.form.XacNhanForm;

/**
 * Kết quả xác minh nội dung tố cáo form
 * @author Ntthu Created on Nov 2, 2010
 */
public class KetQuaXmTcForm extends XacNhanForm {

	// Thong tin Ho so
	private String maHidden;

	private String soQd;

	private String maKq;

	private String noiDungViPham;

	private String noiDungDon, noiDungToCao;

	private String ketQuaXm;

	private String kienNghi;

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

	private String ketQuaXmTc;

	private String kienNghiTcKhac;

	private String donViDuocGuiKl;

	private KntcKquaXmDtl[] arrNd;

	public KetQuaXmTcForm() {
		super();
	}

	public void fromEntity(KntcKqxmKluatKnghi kq) {
		if (kq.getDenBuSoNguoi() != null)
			this.denBuSoNguoi = String.valueOf(kq.getDenBuSoNguoi());
		if (kq.getXlySoNguoi() != null)
			this.xlySoNguoi = String.valueOf(kq.getXlySoNguoi());
		this.htcdDat = getFromDouble(kq.getHtcdDat());
		this.htcdTien = getFromDouble(kq.getHtcdTien());
		this.htcdTriGia = getFromDouble(kq.getHtcdTriGia());
		this.htcdLoai = kq.getHtcdLoai();

		this.ketQuaXm = kq.getKetQuaXm();
		this.kienNghi = kq.getKienNghi();
		this.kienNghiTcKhac = kq.getKienNghiTcKhac();
		this.ketQuaXmTc = kq.getKetQuaXmTc();
		this.kienKhacTrongDoan = kq.getYKienKhacTrongDoan();
		this.donViDuocGuiKl = kq.getDonViDuocGuiKl();
		this.knthNnDat = getFromDouble(kq.getKnthNnDat());
		this.knthNnSoTien = getFromDouble(kq.getKnthNnSoTien());
		this.knthNnTriGia = getFromDouble(kq.getKnthNnTriGia());
		this.knthNnLoai = kq.getKnthNnLoai();

		this.maHidden = kq.getMa();
		this.setMaHoSo(kq.getMaHs());
		this.maKq = kq.getSoKl();
		this.soQd = kq.getMaQd();
		this.noiDungDon = kq.getNoiDungKn();
		this.noiDungViPham = kq.getQuyetDinhHc();
		this.phanTichKq = kq.getLoaiKq();
		this.xlyHinhThuc = kq.getXlyGiaiPhap();

		this.lyDoNtc = kq.getLyDoNtc();
		// this.kienKhacTrongDoan = kq.getYKienKhacTrongDoan();
		this.kienTdTtcqt = kq.getYKienTdTtcqt();

		this.setKienDuyet(kq.getYKienDuyet());
		this.setKienTrinh(kq.getYKienTrinh());
		this.setNgayTrinhDuyet(Formater.date2str(kq.getNgayTrinhDuyet()));
		this.setNgayDuyet(Formater.date2str(kq.getNgayDuyet()));
		this.setNgayTrinhKy(Formater.date2str(kq.getNgayTrinhKy()));
		this.setNgayKy(Formater.date2str(kq.getNgayKy()));
		this.setDiaDiem(kq.getDiaDiem());
		this.setThoiDiem(Formater.date2str(kq.getNgayLap()));
		this.setNoiDungToCao(kq.getNoiDungToCao());
		// Thong tin detail

	}

	public KntcXacMinh toBcKqXacMinhTC(ApplicationContext c) throws Exception {
		KntcXacMinh hdr = new KntcXacMinh();
		KntcKqxmKluatKnghi qd = new KntcKqxmKluatKnghi();
		qd.setLoaiKl(KntcKqxmKluatKnghi.LOAI_BC_KQ_XM_TC);
		qd.setMa(this.maHidden);
		qd.setMaHs(this.getMaHoSo());
		qd.setMaQd(this.getSoQd());
		qd.setDiaDiem(this.getDiaDiem());
		qd.setNgayLap(Formater.str2date(this.getThoiDiem()));
		qd.setNgayCapNhat(new Date());
		qd.setNguoiCapNhat(c.getTenNsd());
		qd.setMaCqt(c.getMaCqt());
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
		qd.setKienNghi(this.kienNghi);

		qd.setLoaiKq(this.phanTichKq);
		qd.setXlyGiaiPhap(this.xlyHinhThuc);
		qd.setHtcdLoai(this.htcdLoai);
		qd.setKnthNnLoai(this.knthNnLoai);
		qd.setNoiDungToCao(this.noiDungToCao);
		if (this.arrNd != null && this.arrNd.length > 0) {
			for (int i = 0; i < this.arrNd.length; i++) {
				KntcKquaXmDtl d = this.arrNd[i];
				d.setLoai(KntcKquaXmDtl.BAO_CAO_XAC_MINH_TC);
				hdr.addKntcKquaXmDtl(d);
			}
		}

		qd.setYKienKhacTrongDoan(this.kienKhacTrongDoan);
		qd.setYKienTdTtcqt(this.kienTdTtcqt);
		qd.setLyDoNtc(this.lyDoNtc);
		qd.setKetQuaXmTc(this.ketQuaXmTc);
		qd.setKienNghiTcKhac(this.kienNghiTcKhac);
		hdr.setHdr(qd);
		return hdr;
	}

	public KntcXacMinh toKetLuanTC(ApplicationContext c) throws Exception {
		KntcXacMinh hdr = new KntcXacMinh();
		KntcKqxmKluatKnghi qd = new KntcKqxmKluatKnghi();
		qd.setLoaiKl(KntcKqxmKluatKnghi.LOAI_KET_LUAN_TC);
		qd.setMa(this.maHidden);
		qd.setMaHs(this.getMaHoSo());
		qd.setSoKl(this.getMaKq());
		qd.setMaQd(this.getSoQd());
		qd.setDiaDiem(this.getDiaDiem());
		qd.setNgayLap(Formater.str2date(this.getThoiDiem()));
		qd.setNgayCapNhat(new Date());
		qd.setNguoiCapNhat(c.getTenNsd());
		qd.setMaCqt(c.getMaCqt());
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
		qd.setKienNghi(this.kienNghi);
		qd.setYKienKhacTrongDoan(this.kienKhacTrongDoan);
		qd.setYKienTdTtcqt(this.kienTdTtcqt);
		qd.setLyDoNtc(this.lyDoNtc);
		if (!Formater.isNull(this.denBuSoNguoi))
			qd.setDenBuSoNguoi(new Long(this.denBuSoNguoi));
		if (!Formater.isNull(this.xlySoNguoi))
			qd.setXlySoNguoi(new Long(this.xlySoNguoi));
		if (!Formater.isNull(this.knthNnDat))
			qd.setKnthNnDat(toDouble(this.knthNnDat));
		if (!Formater.isNull(this.knthNnSoTien))
			qd.setKnthNnSoTien(toDouble(this.knthNnSoTien));
		if (!Formater.isNull(this.knthNnTriGia))
			qd.setKnthNnTriGia(toDouble(this.knthNnTriGia));
		if (!Formater.isNull(this.htcdDat))
			qd.setHtcdDat(toDouble(this.htcdDat));
		if (!Formater.isNull(this.htcdTien))
			qd.setHtcdTien(toDouble(this.htcdTien));
		if (!Formater.isNull(this.htcdTriGia))
			qd.setHtcdTriGia(toDouble(this.htcdTriGia));
		qd.setLoaiKq(this.phanTichKq);
		qd.setXlyGiaiPhap(this.xlyHinhThuc);
		qd.setHtcdLoai(this.htcdLoai);
		qd.setKnthNnLoai(this.knthNnLoai);
		qd.setLyDoNtc(this.lyDoNtc);
		qd.setKetQuaXmTc(this.ketQuaXmTc);
		qd.setKienNghiTcKhac(this.kienNghiTcKhac);
		qd.setDonViDuocGuiKl(this.donViDuocGuiKl);
		hdr.setHdr(qd);
		if (this.arrNd != null && this.arrNd.length > 0) {
			for (int i = 0; i < this.arrNd.length; i++) {
				KntcKquaXmDtl d = this.arrNd[i];
				d.setLoai(KntcKquaXmDtl.KET_LUAN_TC);
				hdr.addKntcKquaXmDtl(d);
			}
		}
		return hdr;
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
	 */
	public String getKienNghi() {
		return kienNghi;
	}

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
	 */
	public void setKienNghi(String string) {
		kienNghi = string;
	}

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

	public static String getFromDouble(Double v) {
		if (v != null)
			return Formater.num2str(v.doubleValue());
		else
			return "";
	}

	public static Double toDouble(String v) {
		if (v != null)
			try {
				return new Double(Formater.str2num(v).doubleValue());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		else
			return null;
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

	/**
	 * @return
	 */
	public KntcKquaXmDtl[] getArrNd() {
		return arrNd;
	}

	/**
	 * @param dtls
	 */
	public void setArrNd(KntcKquaXmDtl[] dtls) {
		arrNd = dtls;
	}

	/**
	 * @return
	 */
	public String getKetQuaXmTc() {
		return ketQuaXmTc;
	}

	/**
	 * @return
	 */
	public String getKienNghiTcKhac() {
		return kienNghiTcKhac;
	}

	/**
	 * @param string
	 */
	public void setKetQuaXmTc(String string) {
		ketQuaXmTc = string;
	}

	/**
	 * @param string
	 */
	public void setKienNghiTcKhac(String string) {
		kienNghiTcKhac = string;
	}

	/**
	 * @return
	 */
	public String getDonViDuocGuiKl() {
		return donViDuocGuiKl;
	}

	/**
	 * @param string
	 */
	public void setDonViDuocGuiKl(String string) {
		donViDuocGuiKl = string;
	}

	public String getNoiDungToCao() {
		return noiDungToCao;
	}

	public void setNoiDungToCao(String noiDung) {
		this.noiDungToCao = noiDung;
	}

}
