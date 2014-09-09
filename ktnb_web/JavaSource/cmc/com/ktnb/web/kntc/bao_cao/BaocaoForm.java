package cmc.com.ktnb.web.kntc.bao_cao;
import cmc.com.ktnb.util.StringUtil;
import cmc.com.ktnb.web.BaseActionForm;
/**
 * Báo cáo form
 * @author Ntthu
 * Created on 16/04/2011
 */
public class BaocaoForm extends BaseActionForm {
	private String ketQua;
	private String dinhDang;
	private String nguoiLap;	
	private String diaDiem;
	private String ngayLap;
	private String tuNgay;		
	private String denNgay,capCqt,textSearch;	
	private String arrCqt,arrNd,loaiBc,tenBc,kyBc;
	private String tuThang,denThang;
	public String getKyBc() {
		return kyBc;
	}

	public void setKyBc(String kyBc) {
		this.kyBc = kyBc;
	}

	public String getTenBc() {
		return tenBc;
	}

	public void setTenBc(String tenBc) {
		this.tenBc = tenBc;
	}

	private String loaiBaoCaoTtkt;// 02 hay 43;
	private String nam;// Nam bao cao
	private String cqt;
	
	public String getCqt() {
		return cqt;
	}

	public void setCqt(String cqt) {
		this.cqt = cqt;
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
	public String getDinhDang() {
		return dinhDang;
	}

	/**
	 * @return
	 */
	public String getNgayLap() {
		return ngayLap;
	}

	/**
	 * @return
	 */
	public String getNguoiLap() {
		return nguoiLap;
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
	public void setDinhDang(String string) {
		dinhDang = string;
	}

	/**
	 * @param string
	 */
	public void setNgayLap(String string) {
		ngayLap = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiLap(String string) {
		nguoiLap = string;
	}

	/**
	 * @param string
	 */
	public void setTuNgay(String string) {
		tuNgay = string;
	}

	/**
	 * @return
	 */
	public String getArrCqt() {
		return arrCqt;
	}

	/**
	 * @param string
	 */
	public void setArrCqt(String string) {
		arrCqt = string;
	}

	public String getLoaiBc() {
		return loaiBc;
	}

	public void setLoaiBc(String loaiBc) {
		this.loaiBc = loaiBc;
	}

	/**
	 * @return
	 */
	public String getLoaiBaoCaoTtkt() {
		return loaiBaoCaoTtkt;
	}

	/**
	 * @param string
	 */
	public void setLoaiBaoCaoTtkt(String string) {
		loaiBaoCaoTtkt = string;
	}

	/**
	 * @return
	 */
	public String getNam() {
		return nam;
	}

	/**
	 * @param string
	 */
	public void setNam(String string) {
		nam = string;
	}

	public String getCapCqt() {
		return capCqt;
	}

	public void setCapCqt(String capCqt) {
		this.capCqt = capCqt;
	}

	public String getTextSearch() {
		return textSearch;
	}

	public void setTextSearch(String textSearch) {
		this.textSearch = textSearch;
	}

	public String getArrNd() {
		return arrNd;
	}

	public void setArrNd(String arrNd) {
		this.arrNd = arrNd;
	}

	public String getDenThang() {
		return denThang;
	}

	public void setDenThang(String denThang) {
		this.denThang = denThang;
	}

	public String getTuThang() {
		return tuThang;
	}

	public void setTuThang(String tuThang) {
		this.tuThang = tuThang;
	}

	public String getKetQua() {
		if(StringUtil.isBlankOrNull(ketQua)) return "1";
		return ketQua;
	}

	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}
	
}
