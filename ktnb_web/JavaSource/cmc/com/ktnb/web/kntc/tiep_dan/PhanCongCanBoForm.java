package cmc.com.ktnb.web.kntc.tiep_dan;
import cmc.com.ktnb.web.BaseActionForm;
/**
 * Form phân công cán bộ
 * @author DoHongPhuc
 * Created on Nov 5, 2010
 */
public class PhanCongCanBoForm extends BaseActionForm {
	private String maHoSo;
	private String ngayPhanCong;
	private String arrCanBo;
	private String countCanBo;
	/**
	 * @return
	 */
	public String getMaHoSo() {
		return maHoSo;
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
	public String getNgayPhanCong() {
		return ngayPhanCong;
	}

	/**
	 * @param string
	 */
	public void setNgayPhanCong(String string) {
		ngayPhanCong = string;
	}

	/**
	 * @return
	 */
	public String getArrCanBo() {
		return arrCanBo;
	}

	/**
	 * @param string
	 */
	public void setArrCanBo(String string) {
		arrCanBo = string;
	}

	/**
	 * @return
	 */
	public String getCountCanBo() {
		return countCanBo;
	}

	/**
	 * @param string
	 */
	public void setCountCanBo(String string) {
		countCanBo = string;
	}

}
