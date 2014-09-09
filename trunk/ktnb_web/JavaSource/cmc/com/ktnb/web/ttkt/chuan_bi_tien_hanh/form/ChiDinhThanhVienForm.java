/*
 * Created on Jan 6, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.form; 

import cmc.com.ktnb.util.DetailInformation;
import cmc.com.ktnb.web.BaseActionForm;

/**
 * @author Nguyen Tien Dung
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ChiDinhThanhVienForm extends BaseActionForm {
	private String id;
	private String idCb;
	private String tenCanBo;
	private Boolean chucVuTrongDoan;
	private String noiLap;
	private String ngayLap;
	private DetailInformation[] chiTietDanhSachTV;
	private DetailInformation[] dsThanhVienDoan;

	/**
	 * @return
	 */
	public Boolean getChucVuTrongDoan() {
		return chucVuTrongDoan;
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
	public String getIdCb() {
		return idCb;
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
	public String getNoiLap() {
		return noiLap;
	}

	/**
	 * @return
	 */
	public String getTenCanBo() {
		return tenCanBo;
	}

	/**
	 * @param boolean1
	 */
	public void setChucVuTrongDoan(Boolean boolean1) {
		chucVuTrongDoan = boolean1;
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
	public void setIdCb(String string) {
		idCb = string;
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
	public void setNoiLap(String string) {
		noiLap = string;
	}

	/**
	 * @param string
	 */
	public void setTenCanBo(String string) {
		tenCanBo = string;
	}

	/**
	 * @return
	 */
	public DetailInformation[] getChiTietDanhSachTV() {
		return chiTietDanhSachTV;
	}

	/**
	 * @param informations
	 */
	public void setChiTietDanhSachTV(DetailInformation[] informations) {
		chiTietDanhSachTV = informations;
	}

	/**
	 * @return
	 */
	public DetailInformation[] getDsThanhVienDoan() {
		return dsThanhVienDoan;
	}

	/**
	 * @param informations
	 */
	public void setDsThanhVienDoan(DetailInformation[] informations) {
		dsThanhVienDoan = informations;
	}

}
