package cmc.com.ktnb.web.kntc.tiep_dan;
import cmc.com.ktnb.web.BaseActionForm;
/**
 * Tách đơn khiếu nại tố cáo
 * @author Ntthu
 * Created on 03/03/2011
 */
public class TachDonForm extends BaseActionForm {

	// Thong tin Ho so
	private String maHoSo,maHoSoKN,maHoSoTC;
	
	private String noiDungDon;
	private String noiDungKN, noiDungTC,arrTlktTC,arrTlktKN;
	
	/**
	 * @return
	 */
	public String getArrTlktKN() {
		return arrTlktKN;
	}

	/**
	 * @return
	 */
	public String getArrTlktTC() {
		return arrTlktTC;
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
	public String getNoiDungDon() {
		return noiDungDon;
	}

	/**
	 * @return
	 */
	public String getNoiDungKN() {
		return noiDungKN;
	}

	/**
	 * @return
	 */
	public String getNoiDungTC() {
		return noiDungTC;
	}

	/**
	 * @param string
	 */
	public void setArrTlktKN(String string) {
		arrTlktKN = string;
	}

	/**
	 * @param string
	 */
	public void setArrTlktTC(String string) {
		arrTlktTC = string;
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
	public void setNoiDungDon(String string) {
		noiDungDon = string;
	}

	/**
	 * @param string
	 */
	public void setNoiDungKN(String string) {
		noiDungKN = string;
	}

	/**
	 * @param string
	 */
	public void setNoiDungTC(String string) {
		noiDungTC = string;
	}

	public String getMaHoSoKN() {
		return maHoSoKN;
	}

	public void setMaHoSoKN(String maHoSoKN) {
		this.maHoSoKN = maHoSoKN;
	}

	public String getMaHoSoTC() {
		return maHoSoTC;
	}

	public void setMaHoSoTC(String maHoSoTC) {
		this.maHoSoTC = maHoSoTC;
	}

}
