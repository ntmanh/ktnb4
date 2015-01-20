package cmc.com.ktnb.web.kntc.xac_minh;

import java.text.Format;
import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.KntcQdinhXm;
import cmc.com.ktnb.pl.hb.entity.KntcXmBaoCaoKq;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.dung_chung.form.XacNhanForm;

/**
 * Xác minh hồ sơ form
 * @author Ntthu Created on Nov 2, 2010
 */
public class XacMinhForm extends XacNhanForm {

	// Thong tin Ho so
	private String soQd;

	private String canCuVanBan;

	private String canCuNhiemVu;

	private String thoiGian;

	private String noiDung;

	private String benLienQuan;

	private String benLienQuanThuTruong;

	private String noiDungViPham;

	private String noiDungDon;

	private String ketQuaXm;

	private String kienNghi;

	private String maHidden;

	private String nguoiBiTcMa;

	private String nguoiBiTcTen;

	private String nguoiBiTcChucVu;

	private String nguoiBiTcHanhVi;

	private String soNgayXm;

	private String tuNgayXm;

	private String denNgayXm;

	private String arrDm;
	
	private String chucDanhCanBoTqXm;

	private String deNghiTruongBoPhan;

	private String mucDich;
	
	private String act;
	
	private String arrCanBo;
	
	private String countCanBo;

	public XacMinhForm() {
		super();
	}
	public void fromEntity(KntcQdinhXm kq) {
		this.setMaHidden(kq.getMa());
		this.setMaHoSo(kq.getMaHs());
		this.setDiaDiem(kq.getDiaDiem());
		this.setThoiDiem(Formater.date2str(kq.getNgayLap()));
		this.setChucDanhCanBoTqXm(kq.getChucDanhCanBoTqXm());
		this.setDeNghiTruongBoPhan(kq.getDeNghiTruongBoPhan());
		this.setSoQd(kq.getMaQd());
		this.setCanCuVanBan(kq.getCanCuPly());
		if (kq.getSoNgayXm() != null)
			this.setSoNgayXm(kq.getSoNgayXm().toString());
		this.setCanCuNhiemVu(kq.getCanCuNvu());
		this.setTuNgayXm(Formater.date2str(kq.getTuNgayXm()));
		this.setDenNgayXm(Formater.date2str(kq.getDenNgayXm()));
		
		this.setNoiDung(kq.getNoiDungXm());
		this.setBenLienQuan(kq.getBenLienQuan());
		this.setBenLienQuanThuTruong(kq.getBenLienQuanTt());
		this.setNguoiBiTcHanhVi(kq.getNguoiBiKntcHanhVi());
		this.setKienDuyet(kq.getYKienDuyet());
		this.setKienTrinh(kq.getYKienTrinh());
		this.setNgayTrinhDuyet(Formater.date2str(kq.getNgayTrinhDuyet()));
		this.setNgayDuyet(Formater.date2str(kq.getNgayDuyet()));
		this.setNgayTrinhKy(Formater.date2str(kq.getNgayTrinhKy()));
		this.setNgayKy(Formater.date2str(kq.getNgayKy()));
	}
		
	public KntcXmBaoCaoKq toKquaGquyet(ApplicationContext c) throws Exception {
		KntcXmBaoCaoKq qd = new KntcXmBaoCaoKq();
		qd.setMa(this.maHidden);
		qd.setMaHs(this.getMaHoSo());
		qd.setDiaDiem(this.getDiaDiem());
		qd.setNgayLap(Formater.str2date(this.getThoiDiem()));
		qd.setNgayCapNhat(new Date());
		qd.setNguoiCapNhat(c.getTenNsd());
		
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
		qd.setMaQd(this.getSoQd());
		return qd;
	}

	/**
	 * @return
	 */
	public String getBenLienQuan() {
		return benLienQuan;
	}

	/**
	 * @return
	 */
	public String getBenLienQuanThuTruong() {
		return benLienQuanThuTruong;
	}

	/**
	 * @return
	 */
	public String getCanCuVanBan() {
		return canCuVanBan;
	}

	/**
	 * @return
	 */
	public String getNoiDung() { 
		return noiDung;
	}

	/**
	 * @return
	 */
	public String getSoQd() {
		return soQd;
	}

	/**
	 * @return
	 */
	public String getThoiGian() {
		return thoiGian;
	}

	/**
	 * @param string
	 */
	public void setBenLienQuan(String string) {
		benLienQuan = string;
	}

	/**
	 * @param string
	 */
	public void setBenLienQuanThuTruong(String string) {
		benLienQuanThuTruong = string;
	}

	/**
	 * @param string
	 */
	public void setCanCuVanBan(String string) {
		canCuVanBan = string;
	}

	/**
	 * @param string
	 */
	public void setNoiDung(String string) {
		noiDung = string;
	}

	/**
	 * @param string
	 */
	public void setSoQd(String string) {
		soQd = string;
	}

	/**
	 * @param string
	 */
	public void setThoiGian(String string) {
		thoiGian = string;
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
	public String getCanCuNhiemVu() {
		return canCuNhiemVu;
	}

	/**
	 * @param string
	 */
	public void setCanCuNhiemVu(String string) {
		canCuNhiemVu = string;
	}

	/**
	 * @return
	 */
	public String getNguoiBiTcHanhVi() {
		return nguoiBiTcHanhVi;
	}

	/**
	 * @return
	 */
	public String getNguoiBiTcMa() {
		return nguoiBiTcMa;
	}

	/**
	 * @return
	 */
	public String getNguoiBiTcTen() {
		return nguoiBiTcTen;
	}

	/**
	 * @param string
	 */
	public void setNguoiBiTcHanhVi(String string) {
		nguoiBiTcHanhVi = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiBiTcMa(String string) {
		nguoiBiTcMa = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiBiTcTen(String string) {
		nguoiBiTcTen = string;
	}

	/**
	 * @return
	 */
	public String getDenNgayXm() {
		return denNgayXm;
	}

	/**
	 * @return
	 */
	public String getNguoiBiTcChucVu() {
		return nguoiBiTcChucVu;
	}

	/**
	 * @return
	 */
	public String getSoNgayXm() {
		return soNgayXm;
	}

	/**
	 * @return
	 */
	public String getTuNgayXm() {
		return tuNgayXm;
	}

	/**
	 * @param string
	 */
	public void setDenNgayXm(String string) {
		denNgayXm = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiBiTcChucVu(String string) {
		nguoiBiTcChucVu = string;
	}

	/**
	 * @param string
	 */
	public void setSoNgayXm(String string) {
		soNgayXm = string;
	}

	/**
	 * @param string
	 */
	public void setTuNgayXm(String string) {
		tuNgayXm = string;
	}

	/**
	 * @return
	 */
	public String getArrDm() {
		return arrDm;
	}

	/**
	 * @param string
	 */
	public void setArrDm(String string) {
		arrDm = string;
	}
	
	/**
	 * @return
	 */
	public String getChucDanhCanBoTqXm() {
		return chucDanhCanBoTqXm;
	}

	/**
	 * @return
	 */
	public String getDeNghiTruongBoPhan() {
		return deNghiTruongBoPhan;
	}
	
	/**
	 * @param string
	 */
	public void setChucDanhCanBoTqXm(String string) {
		chucDanhCanBoTqXm = string;
	}

	/**
	 * @param string
	 */
	public void setDeNghiTruongBoPhan(String string) {
		deNghiTruongBoPhan = string;
	}

	/**
	 * @return
	 */
	public String getMucDich() {
		return mucDich;
	}

	/**
	 * @param string
	 */
	public void setMucDich(String string) {
		mucDich = string;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public String getArrCanBo() {
		return arrCanBo;
	}

	public void setArrCanBo(String arrCanBo) {
		this.arrCanBo = arrCanBo;
	}

	public String getCountCanBo() {
		return countCanBo;
	}

	public void setCountCanBo(String countCanBo) {
		this.countCanBo = countCanBo;
	}
}
