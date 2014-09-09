package cmc.com.ktnb.web.kntc;
import cmc.com.ktnb.pl.hb.entity.KtnbLopTapHuan;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseActionForm;
/**
 * Form trợ giúp
 * @author Ntthu
 * Created on 16/04/2011
 */
public class TroGiupForm extends BaseActionForm {
	private String maHidden;
	private String tenLop;	
	private String diaDiem;
	private String tuNgay;	
	private String soNguoi;
	private String denNgay;	
	public KtnbLopTapHuan toEntity() throws Exception {
		KtnbLopTapHuan pYc = new KtnbLopTapHuan();
		pYc.setMa(this.maHidden);
		pYc.setDiaDiem(this.diaDiem);
		pYc.setTenLop(this.tenLop);
		pYc.setSoNguoi(new Long(Formater.str2num(this.soNguoi).longValue()));
		pYc.setNgayBatDau(Formater.str2date(this.tuNgay));
		pYc.setNgayKetThuc(Formater.str2date(this.denNgay));
		return pYc;
	}
	
	/**
	 * @return
	 */
	public String getDenNgay() {
		return denNgay;
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
	public String getMaHidden() {
		return maHidden;
	}

	/**
	 * @return
	 */
	public String getSoNguoi() {
		return soNguoi;
	}

	/**
	 * @return
	 */
	public String getTenLop() {
		return tenLop;
	}

	/**
	 * @return
	 */
	public String getTuNgay() {
		return tuNgay;
	}

	/**
	 * @param string
	 */
	public void setDenNgay(String string) {
		denNgay = string;
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
	public void setMaHidden(String string) {
		maHidden = string;
	}

	/**
	 * @param string
	 */
	public void setSoNguoi(String string) {
		soNguoi = string;
	}

	/**
	 * @param string
	 */
	public void setTenLop(String string) {
		tenLop = string;
	}

	/**
	 * @param string
	 */
	public void setTuNgay(String string) {
		tuNgay = string;
	}

}
