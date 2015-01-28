package cmc.com.ktnb.web.kntc.xac_minh;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.pl.hb.entity.KntcBienBan;
import cmc.com.ktnb.pl.hb.entity.KntcBienBanId;
import cmc.com.ktnb.pl.hb.entity.KntcXmKeHoach;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseActionForm;
import cmc.com.ktnb.web.dung_chung.form.XacNhanForm;

/**
 * Kế hoạch form
 * @author Ntthu Created on Nov 2, 2010
 */
public class KeHoachForm extends BaseActionForm {

	// Thong tin Ho so
	private String maHoSo;
	private String diaDiem;
	private String thoiDiem;
	private String maHiddenKh;

	private String canBoMa;

	private String canBoTen;

	private String canCuPhapLy;

	private String mucDich;

	private String bangChung;

	private String benLienQuan,daiDien;

	private String phuongTien;

	private String soBanIn;

	private String soBen;

	private String arrDm;

	private String maQd;

	private String noiDung;

	private String thanhPhan, soTrangTl, soBangChung, thoiDiemHoanThanh;
	private String fileLuuTru;
	private String act;
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);		
	}
	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public KntcXmKeHoach toKeHoachXm(ApplicationContext c) throws Exception {
		KntcXmKeHoach qd = new KntcXmKeHoach();
		qd.setMa(this.getMaHiddenKh());
		qd.setMaHs(this.getMaHoSo());
		qd.setDiaDiem(this.getDiaDiem());
		qd.setNgayLap(Formater.str2date(this.getThoiDiem()));
		qd.setNgayCapNhat(new Date());
		qd.setNguoiCapNhat(c.getTenNsd());
		qd.setBangChung(this.bangChung);
		qd.setBenLienQuan(this.benLienQuan);
		qd.setCanCuPly(this.canCuPhapLy);
		qd.setMucDich(this.mucDich);
		qd.setPhuongTien(this.phuongTien);
		qd.setNoiDungXm(this.noiDung);
		// Thong tin ky duyet
		qd.setMaQd(this.getMaQd());
		return qd;
	}

	public void fromEntity(KntcXmKeHoach kq, ApplicationContext c) throws Exception {
		this.setMaHiddenKh(kq.getMa());
		this.maQd = kq.getMaQd();
		this.setMaHoSo(kq.getMaHs());
		this.setDiaDiem(kq.getDiaDiem());
		this.setThoiDiem(Formater.date2str(kq.getNgayLap()));
		if (!Formater.isNull(kq.getNguoiCapNhat())) {
			this.setCanBoMa(kq.getNguoiCapNhat());
			this.setCanBoTen(kq.getNguoiCapNhat());
		}
		this.bangChung = kq.getBangChung();
		this.benLienQuan = kq.getBenLienQuan();

		this.canCuPhapLy = kq.getCanCuPly();
		this.mucDich = kq.getMucDich();
		this.phuongTien = kq.getPhuongTien();
		this.noiDung = kq.getNoiDungXm();
	}

	public void fromBienBan(KntcBienBan kq, ApplicationContext c) throws Exception {
		this.setMaHiddenKh(kq.getId().getMaBb());
		this.setMaHoSo(kq.getId().getMaHs());
		this.setDiaDiem(kq.getDiaDiem());
		this.setThoiDiem(Formater.date2strDateTimeForNV(kq.getThoiDiem()));
		this.setThoiDiemHoanThanh(Formater.date2strDateTimeForNV(kq.getThoiDiemHoanThanh()));
		this.setThanhPhan(kq.getThanhPhan());
		this.setNoiDung(kq.getNoiDung());
		if (kq.getSoTrangTl() != null)
			this.setSoTrangTl(kq.getSoTrangTl().toString());
		if (kq.getSoBangChung() != null)
			this.setSoBangChung(kq.getSoBangChung().toString());
	}
	
	public KntcBienBan toBienBan(ApplicationContext c) throws Exception {
		KntcBienBan bb = new KntcBienBan();
		KntcBienBanId id = new KntcBienBanId();
		id.setMaHs(this.getMaHoSo());
		bb.setId(id);
		bb.setDiaDiem(this.getDiaDiem());
		bb.setNgayCapNhat(new Date());
		bb.setNguoiCapNhat(c.getTenNsd());
		bb.setThoiDiem(Formater.str2dateForNV(this.getThoiDiem()));
		bb.setThoiDiemHoanThanh(Formater.str2dateForNV(this.getThoiDiemHoanThanh()));
		// bb.setSoBanIn(new Long(this.getSoBanIn()));
		// bb.setSoBenLviec(new Long(tdForm.getSoBen()));
		if (this.soTrangTl != null)
			bb.setSoTrangTl(new Long(this.soTrangTl));
		if (this.soBangChung != null)
			bb.setSoBangChung(new Long(this.soBangChung));
		bb.setDaiDien(this.daiDien);
		bb.setNoiDung(this.noiDung);
		bb.setThanhPhan(this.thanhPhan);
		return bb;
	}

	/**
	 * @return
	 */
	public String getBangChung() {
		return bangChung;
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
	public String getCanBoMa() {
		return canBoMa;
	}

	/**
	 * @return
	 */
	public String getCanBoTen() {
		return canBoTen;
	}

	/**
	 * @return
	 */
	public String getCanCuPhapLy() {
		return canCuPhapLy;
	}

	/**
	 * @return
	 */
	public String getMucDich() {
		return mucDich;
	}

	/**
	 * @return
	 */
	public String getPhuongTien() {
		return phuongTien;
	}

	/**
	 * @param string
	 */
	public void setBangChung(String string) {
		bangChung = string;
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
	public void setCanBoMa(String string) {
		canBoMa = string;
	}

	/**
	 * @param string
	 */
	public void setCanBoTen(String string) {
		canBoTen = string;
	}

	/**
	 * @param string
	 */
	public void setCanCuPhapLy(String string) {
		canCuPhapLy = string;
	}

	/**
	 * @param string
	 */
	public void setMucDich(String string) {
		mucDich = string;
	}

	/**
	 * @param string
	 */
	public void setPhuongTien(String string) {
		phuongTien = string;
	}

	/**
	 * @return
	 */
	public String getSoBanIn() {
		return soBanIn;
	}

	/**
	 * @return
	 */
	public String getSoBen() {
		return soBen;
	}

	/**
	 * @param string
	 */
	public void setSoBanIn(String string) {
		soBanIn = string;
	}

	/**
	 * @param string
	 */
	public void setSoBen(String string) {
		soBen = string;
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
	public String getMaQd() {
		return maQd;
	}

	/**
	 * @param string
	 */
	public void setMaQd(String string) {
		maQd = string;
	}

	/**
	 * @return
	 */
	public String getMaHiddenKh() {
		return maHiddenKh;
	}

	/**
	 * @param string
	 */
	public void setMaHiddenKh(String string) {
		maHiddenKh = string;
	}

	/**
	 * @return
	 */
	public String getNoiDung() {
		if(!Formater.isNull(noiDung)&& noiDung.indexOf("urn:schemas-microsoft-com:office:office")!=-1)
			noiDung = noiDung.replaceAll("<?xml:namespace prefix = o ns = \"urn:schemas-microsoft-com:office:office\" />", "");
		return noiDung;
	}

	/**
	 * @param string
	 */
	public void setNoiDung(String string) {
		noiDung = string;
	}

	public String getThanhPhan() {
		if(!Formater.isNull(thanhPhan)&& thanhPhan.indexOf("urn:schemas-microsoft-com:office:office")!=-1)
			thanhPhan = thanhPhan.replaceAll("<?xml:namespace prefix = o ns = \"urn:schemas-microsoft-com:office:office\" />", "");
		return thanhPhan;
	}

	public void setThanhPhan(String thanhPhan) {
		this.thanhPhan = thanhPhan;
	}

	public String getSoBangChung() {
		return soBangChung;
	}

	public void setSoBangChung(String soBangChung) {
		this.soBangChung = soBangChung;
	}

	public String getSoTrangTl() {
		return soTrangTl;
	}

	public void setSoTrangTl(String soTrangTl) {
		this.soTrangTl = soTrangTl;
	}

	public String getThoiDiemHoanThanh() {
		return thoiDiemHoanThanh;
	}

	public void setThoiDiemHoanThanh(String thoiDiemHoanThanh) {
		this.thoiDiemHoanThanh = thoiDiemHoanThanh;
	}

	public String getDaiDien() {
		return daiDien;
	}

	public void setDaiDien(String daiDien) {
		this.daiDien = daiDien;
	}
	public String getDiaDiem() {
		return diaDiem;
	}
	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}
	public String getMaHoSo() {
		return maHoSo;
	}
	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}
	public String getThoiDiem() {
		return thoiDiem;
	}
	public void setThoiDiem(String thoiDiem) {
		this.thoiDiem = thoiDiem;
	}
	public String getFileLuuTru() {
		return fileLuuTru;
	}
	public void setFileLuuTru(String fileLuuTru) {
		this.fileLuuTru = fileLuuTru;
	}

}
