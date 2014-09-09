package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form;
 
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.web.BaseActionForm;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */

public class KiemTraXacMinhForm extends BaseActionForm {
	
	private String idKtXm; 
	private String idCuocTtKt;
	private String skDuocKtXm;
	private String thoiGian;
	private String diaDiem;
	private String idTpTdDoanTtKt;
	private String idTpTdDuocKtXm; 
	private String noiDung;
	private String idDsTvd;
	
	private TtktCmThanhPhanThamDu[] dsTpTdDoanTtKt;
	private TtktCmThanhPhanThamDu[] dsTpTdDuocKtXm;
	private String OptionTag;

	/**
	 * @return
	 */
	public String getDiaDiem() {
		return diaDiem;
	}

	/**
	 * @return
	 */
	public String getIdCuocTtKt() {
		return idCuocTtKt;
	}

	/**
	 * @return
	 */
	public String getIdKtXm() {
		return idKtXm;
	}

	/**
	 * @return
	 */
	public String getIdTpTdDoanTtKt() {
		return idTpTdDoanTtKt;
	}

	/**
	 * @return
	 */
	public String getIdTpTdDuocKtXm() {
		return idTpTdDuocKtXm;
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
	public String getSkDuocKtXm() {
		return skDuocKtXm;
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
	public void setDiaDiem(String string) {
		diaDiem = string;
	}

	/**
	 * @param string
	 */
	public void setIdCuocTtKt(String string) {
		idCuocTtKt = string;
	}

	/**
	 * @param string
	 */
	public void setIdKtXm(String string) {
		idKtXm = string;
	}

	/**
	 * @param string
	 */
	public void setIdTpTdDoanTtKt(String string) {
		idTpTdDoanTtKt = string;
	}

	/**
	 * @param string
	 */
	public void setIdTpTdDuocKtXm(String string) {
		idTpTdDuocKtXm = string;
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
	public void setSkDuocKtXm(String string) {
		skDuocKtXm = string;
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
	public TtktCmThanhPhanThamDu[] getDsTpTdDoanTtKt() {
		return dsTpTdDoanTtKt;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getDsTpTdDuocKtXm() {
		return dsTpTdDuocKtXm;
	}

	/**
	 * @param dus
	 */
	public void setDsTpTdDoanTtKt(TtktCmThanhPhanThamDu[] dus) {
		dsTpTdDoanTtKt = dus;
	}

	/**
	 * @param dus
	 */
	public void setDsTpTdDuocKtXm(TtktCmThanhPhanThamDu[] dus) {
		dsTpTdDuocKtXm = dus;
	}

	/**
	 * @return
	 */
	public String getOptionTag() {
		return OptionTag;
	}

	/**
	 * @param string
	 */
	public void setOptionTag(String string) {
		OptionTag = string;
	}

	public String getIdDsTvd() {
		return idDsTvd;
	}

	public void setIdDsTvd(String idDsTvd) {
		this.idDsTvd = idDsTvd;
	}


 }