package cmc.com.ktnb.web.ttkt.dung_chung.form;

import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.web.BaseActionForm;

/**
 * Form bean for a Struts application.
 * 
 * @version 1.0
 * @author
 */
public class BienBanLamViecForm extends BaseActionForm {

	private String id;

	private String idCuocTtKt;

	private String thoiDiemBatDau;

	private String diaDiem;

	private String lamViecVoi;

	private String noiDungLamViec;

	private String ketQua;

	private String idDoanTtKt;

	private String idThanhphanKhac;

	private String thoiDiemKetThuc;

	private String loaiBB;

	private String idDsTvd;

	private String thoiGian;

	private TtktCmThanhPhanThamDu[] dsDoanTtKt;

	private TtktCmThanhPhanThamDu[] dsThanhPhanKhac;

	/**
	 * @return
	 */
	public String getDiaDiem() {
		return diaDiem;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getDsDoanTtKt() {
		return dsDoanTtKt;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getDsThanhPhanKhac() {
		return dsThanhPhanKhac;
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
	public String getIdDoanTtKt() {
		return idDoanTtKt;
	}

	/**
	 * @return
	 */
	public String getIdThanhphanKhac() {
		return idThanhphanKhac;
	}

	/**
	 * @return
	 */
	public String getKetQua() {
		return ketQua;
	}

	/**
	 * @return
	 */
	public String getLamViecVoi() {
		return lamViecVoi;
	}

	/**
	 * @return
	 */
	public String getNoiDungLamViec() {
		return noiDungLamViec;
	}

	/**
	 * @return
	 */
	public String getThoiDiemKetThuc() {
		return thoiDiemKetThuc;
	}

	/**
	 * @param string
	 */
	public void setDiaDiem(String string) {
		diaDiem = string;
	}

	/**
	 * @param dus
	 */
	public void setDsDoanTtKt(TtktCmThanhPhanThamDu[] dus) {
		dsDoanTtKt = dus;
	}

	/**
	 * @param dus
	 */
	public void setDsThanhPhanKhac(TtktCmThanhPhanThamDu[] dus) {
		dsThanhPhanKhac = dus;
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
	public void setIdDoanTtKt(String string) {
		idDoanTtKt = string;
	}

	/**
	 * @param string
	 */
	public void setIdThanhphanKhac(String string) {
		idThanhphanKhac = string;
	}

	/**
	 * @param string
	 */
	public void setKetQua(String string) {
		ketQua = string;
	}

	/**
	 * @param string
	 */
	public void setLamViecVoi(String string) {
		lamViecVoi = string;
	}

	/**
	 * @param string
	 */
	public void setNoiDungLamViec(String string) {
		noiDungLamViec = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemKetThuc(String string) {
		thoiDiemKetThuc = string;
	}

	public String getLoaiBB() {
		return loaiBB;
	}

	public void setLoaiBB(String loaiBB) {
		this.loaiBB = loaiBB;
	}

	public String getThoiDiemBatDau() {
		return thoiDiemBatDau;
	}

	public void setThoiDiemBatDau(String thoiDiemBatDau) {
		this.thoiDiemBatDau = thoiDiemBatDau;
	}

	public String getIdDsTvd() {
		return idDsTvd;
	}

	public void setIdDsTvd(String idDsTvd) {
		this.idDsTvd = idDsTvd;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

}
