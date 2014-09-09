package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form;

import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.web.BaseActionForm;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */

public class CongBoQuyetDinhForm extends BaseActionForm {
	private String idCongBoQuyetDinh;
	private String idCuocTtkt;
	private String thoiDiemCbTu;
	private String thoiDiemCbDen;
	private String idDaiDienCqBanHanhQd;
	private String ykienPhatBieu;
	private String diaDiem;
	private String idDaiDienCqqlCapTren;
	private String idDaiDienDoanTtkt;
	private String idDaiDienDonViDuocTtkt;
	private String idDonViDuocTtkt;
	private String idDonViTienHanh;

	private TtktCmThanhPhanThamDu[] arrDaiDienCqtBanHanhQD;
	private TtktCmThanhPhanThamDu[] arrDaiDienCqqlCapTren;
	private TtktCmThanhPhanThamDu[] arrDaiDienDoanTtkt;
	private TtktCmThanhPhanThamDu[] arrDaiDienDonViDuocTtkt;

	/**
	 * @return
	 */
	public String getDiaDiem() {
		return diaDiem;
	}

	

	/**
	 * @return
	 */
	public String getIdCuocTtkt() {
		return idCuocTtkt;
	}

	/**
	 * @return
	 */
	public String getIdDaiDienCqBanHanhQd() {
		return idDaiDienCqBanHanhQd;
	}

	/**
	 * @return
	 */
	public String getIdDaiDienCqqlCapTren() {
		return idDaiDienCqqlCapTren;
	}

	/**
	 * @return
	 */
	public String getIdDaiDienDoanTtkt() {
		return idDaiDienDoanTtkt;
	}

	/**
	 * @return
	 */
	public String getIdDaiDienDonViDuocTtkt() {
		return idDaiDienDonViDuocTtkt;
	}

	/**
	 * @return
	 */
	public String getThoiDiemCbDen() {
		return thoiDiemCbDen;
	}

	/**
	 * @return
	 */
	public String getThoiDiemCbTu() {
		return thoiDiemCbTu;
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
	public void setIdCuocTtkt(String string) {
		idCuocTtkt = string;
	}

	/**
	 * @param string
	 */
	public void setIdDaiDienCqBanHanhQd(String string) {
		idDaiDienCqBanHanhQd = string;
	}

	/**
	 * @param string
	 */
	public void setIdDaiDienCqqlCapTren(String string) {
		idDaiDienCqqlCapTren = string;
	}

	/**
	 * @param string
	 */
	public void setIdDaiDienDoanTtkt(String string) {
		idDaiDienDoanTtkt = string;
	}

	/**
	 * @param string
	 */
	public void setIdDaiDienDonViDuocTtkt(String string) {
		idDaiDienDonViDuocTtkt = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemCbDen(String string) {
		thoiDiemCbDen = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemCbTu(String string) {
		thoiDiemCbTu = string;
	}

	

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getArrDaiDienCqqlCapTren() {
		return arrDaiDienCqqlCapTren;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getArrDaiDienCqtBanHanhQD() {
		return arrDaiDienCqtBanHanhQD;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getArrDaiDienDoanTtkt() {
		return arrDaiDienDoanTtkt;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getArrDaiDienDonViDuocTtkt() {
		return arrDaiDienDonViDuocTtkt;
	}

	/**
	 * @param dus
	 */
	public void setArrDaiDienCqqlCapTren(TtktCmThanhPhanThamDu[] dus) {
		arrDaiDienCqqlCapTren = dus;
	}

	/**
	 * @param dus
	 */
	public void setArrDaiDienCqtBanHanhQD(TtktCmThanhPhanThamDu[] dus) {
		arrDaiDienCqtBanHanhQD = dus;
	}

	/**
	 * @param dus
	 */
	public void setArrDaiDienDoanTtkt(TtktCmThanhPhanThamDu[] dus) {
		arrDaiDienDoanTtkt = dus;
	}

	/**
	 * @param dus
	 */
	public void setArrDaiDienDonViDuocTtkt(TtktCmThanhPhanThamDu[] dus) {
		arrDaiDienDonViDuocTtkt = dus;
	}

	/**
	 * @return
	 */
	public String getIdCongBoQuyetDinh() {
		return idCongBoQuyetDinh;
	}

	/**
	 * @param string
	 */
	public void setIdCongBoQuyetDinh(String string) {
		idCongBoQuyetDinh = string;
	}

	/**
	 * @return
	 */
	public String getYkienPhatBieu() {
		return ykienPhatBieu;
	}

	/**
	 * @param string
	 */
	public void setYkienPhatBieu(String string) {
		ykienPhatBieu = string;
	}

	/**
	 * @return
	 */
	public String getIdDonViDuocTtkt() {
		return idDonViDuocTtkt;
	}

	/**
	 * @return
	 */
	public String getIdDonViTienHanh() {
		return idDonViTienHanh;
	}

	/**
	 * @param string
	 */
	public void setIdDonViDuocTtkt(String string) {
		idDonViDuocTtkt = string;
	}

	/**
	 * @param string
	 */
	public void setIdDonViTienHanh(String string) {
		idDonViTienHanh = string;
	}

}