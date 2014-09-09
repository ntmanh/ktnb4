package cmc.com.ktnb.web.kntc.xac_minh.tien_hanh;
import cmc.com.ktnb.pl.hb.entity.KntcBienBan;
import cmc.com.ktnb.service.kntc.KntcBienBanChuyenHoSo;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseActionForm;
/**
 * Biên bản chuyển hồ sơ Form
 * @author Ntthu
 * Created on 03/03/2011
 */
public class BienBanChuyenDieuTraForm extends BaseActionForm {

	// Thong tin Ho so
	private String maHoSo;
	private String diaDiem;
	private String thoiDiem, soTrangTl, soBangChung, thoiDiemHoanThanh, arrDvDt, arrCqDt,arrTlkt,donViBanGiao,coQuanDieuTra;
	public KntcBienBanChuyenHoSo toEntity() throws Exception {
		KntcBienBanChuyenHoSo bb = new KntcBienBanChuyenHoSo();
		KntcBienBan pYc = new KntcBienBan();
		pYc.setDiaDiem(this.diaDiem);
		if(Formater.isNull(this.soTrangTl))
			pYc.setSoTrangTl(new Long(this.soTrangTl));
		if(Formater.isNull(this.soBangChung))
			pYc.setSoBangChung(new Long(this.soTrangTl));
		pYc.setThoiDiem(Formater.str2date(this.thoiDiem));
		pYc.setThoiDiemHoanThanh(Formater.str2dateForNV(this.thoiDiemHoanThanh));		
		bb.setBienBan(pYc);
		return bb;
	}
	/**
	 * @return
	 */
	public String getArrCqDt() {
		return arrCqDt;
	}

	/**
	 * @return
	 */
	public String getArrDvDt() {
		return arrDvDt;
	}

	/**
	 * @return
	 */
	public String getDiaDiem() {
		return diaDiem;
	}

	/**
	 * @return
	 */
	public String getMaHoSo() {
		return maHoSo;
	}

	/**
	 * @return
	 */
	public String getSoBangChung() {
		return soBangChung;
	}

	/**
	 * @return
	 */
	public String getSoTrangTl() {
		return soTrangTl;
	}

	/**
	 * @return
	 */
	public String getThoiDiem() {
		return thoiDiem;
	}

	/**
	 * @return
	 */
	public String getThoiDiemHoanThanh() {
		return thoiDiemHoanThanh;
	}

	/**
	 * @param string
	 */
	public void setArrCqDt(String string) {
		arrCqDt = string;
	}

	/**
	 * @param string
	 */
	public void setArrDvDt(String string) {
		arrDvDt = string;
	}

	/**
	 * @param string
	 */
	public void setDiaDiem(String string) {
		diaDiem = string;
	}

	/**
	 * @param string
	 */
	public void setMaHoSo(String string) {
		maHoSo = string;
	}

	/**
	 * @param string
	 */
	public void setSoBangChung(String string) {
		soBangChung = string;
	}

	/**
	 * @param string
	 */
	public void setSoTrangTl(String string) {
		soTrangTl = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiem(String string) {
		thoiDiem = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemHoanThanh(String string) {
		thoiDiemHoanThanh = string;
	}

	/**
	 * @return
	 */
	public String getArrTlkt() {
		return arrTlkt;
	}

	/**
	 * @param string
	 */
	public void setArrTlkt(String string) {
		arrTlkt = string;
	}

	/**
	 * @return
	 */
	public String getCoQuanDieuTra() {
		return coQuanDieuTra;
	}

	/**
	 * @return
	 */
	public String getDonViBanGiao() {
		return donViBanGiao;
	}

	/**
	 * @param string
	 */
	public void setCoQuanDieuTra(String string) {
		coQuanDieuTra = string;
	}

	/**
	 * @param string
	 */
	public void setDonViBanGiao(String string) {
		donViBanGiao = string;
	}

}
