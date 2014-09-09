package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form;


import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.web.BaseActionForm;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */
public class BanGiaoHsVvForm extends BaseActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String idCuocTtKt;
	private String thoiGian;
	private String diaDiemNopHs;
	private String soHs;
	private String tenCqDieuTra;
	private String tomTatHvVp;
	private String hanhViVp;
	private String chucDanhNguoiKy;
	private String tgGiaoNhan;
	private String diaDiemGiaoNhan;
	private String soTrang;
	private String baoGomCacTl;
	private String thoiDiemKt;
	
	private String idDsDaiDien;
	private String idDsDaiDienCqDt;
	
	
	private TtktCmThanhPhanThamDu[]  dsDaiDien;
	private TtktCmThanhPhanThamDu[]  dsDaiDienCqDt;

	/**
	 * @return
	 */
	public String getBaoGomCacTl() {
		return baoGomCacTl;
	}

	/**
	 * @return
	 */
	public String getChucDanhNguoiKy() {
		return chucDanhNguoiKy;
	}

	/**
	 * @return
	 */
	public String getDiaDiemGiaoNhan() {
		return diaDiemGiaoNhan;
	}

	/**
	 * @return
	 */
	public String getDiaDiemNopHs() {
		return diaDiemNopHs;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getDsDaiDien() {
		return dsDaiDien;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getDsDaiDienCqDt() {
		return dsDaiDienCqDt;
	}

	/**
	 * @return
	 */
	public String getHanhViVp() {
		return hanhViVp;
	}

	/**
	 * @return
	 */
	public String getId() {
		return id;
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
	public String getIdDsDaiDien() {
		return idDsDaiDien;
	}

	/**
	 * @return
	 */
	public String getIdDsDaiDienCqDt() {
		return idDsDaiDienCqDt;
	}

	/**
	 * @return
	 */
	public String getSoHs() {
		return soHs;
	}

	/**
	 * @return
	 */
	public String getSoTrang() {
		return soTrang;
	}

	/**
	 * @return
	 */
	public String getTenCqDieuTra() {
		return tenCqDieuTra;
	}

	/**
	 * @return
	 */
	public String getTgGiaoNhan() {
		return tgGiaoNhan;
	}

	/**
	 * @return
	 */
	public String getThoiDiemKt() {
		return thoiDiemKt;
	}

	/**
	 * @return
	 */
	public String getThoiGian() {
		return thoiGian;
	}

	/**
	 * @return
	 */
	public String getTomTatHvVp() {
		return tomTatHvVp;
	}

	/**
	 * @param string
	 */
	public void setBaoGomCacTl(String string) {
		baoGomCacTl = string;
	}

	/**
	 * @param string
	 */
	public void setChucDanhNguoiKy(String string) {
		chucDanhNguoiKy = string;
	}

	/**
	 * @param string
	 */
	public void setDiaDiemGiaoNhan(String string) {
		diaDiemGiaoNhan = string;
	}

	/**
	 * @param string
	 */
	public void setDiaDiemNopHs(String string) {
		diaDiemNopHs = string;
	}

	/**
	 * @param dus
	 */
	public void setDsDaiDien(TtktCmThanhPhanThamDu[] dus) {
		dsDaiDien = dus;
	}

	/**
	 * @param dus
	 */
	public void setDsDaiDienCqDt(TtktCmThanhPhanThamDu[] dus) {
		dsDaiDienCqDt = dus;
	}

	/**
	 * @param string
	 */
	public void setHanhViVp(String string) {
		hanhViVp = string;
	}

	/**
	 * @param string
	 */
	public void setId(String string) {
		id = string;
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
	public void setIdDsDaiDien(String string) {
		idDsDaiDien = string;
	}

	/**
	 * @param string
	 */
	public void setIdDsDaiDienCqDt(String string) {
		idDsDaiDienCqDt = string;
	}

	/**
	 * @param string
	 */
	public void setSoHs(String string) {
		soHs = string;
	}

	/**
	 * @param string
	 */
	public void setSoTrang(String string) {
		soTrang = string;
	}

	/**
	 * @param string
	 */
	public void setTenCqDieuTra(String string) {
		tenCqDieuTra = string;
	}

	/**
	 * @param string
	 */
	public void setTgGiaoNhan(String string) {
		tgGiaoNhan = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemKt(String string) {
		thoiDiemKt = string;
	}

	/**
	 * @param string
	 */
	public void setThoiGian(String string) {
		thoiGian = string;
	}

	/**
	 * @param string
	 */
	public void setTomTatHvVp(String string) {
		tomTatHvVp = string;
	}

	

}
