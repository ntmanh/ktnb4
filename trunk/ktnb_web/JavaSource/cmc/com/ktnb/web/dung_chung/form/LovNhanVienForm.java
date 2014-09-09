/*
 * Created on Nov 4, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.dung_chung.form;



import java.util.Collection;

import cmc.com.ktnb.web.BaseActionForm;

/**
 * @author ntdung1
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LovNhanVienForm extends BaseActionForm{
	private String maNhanVien;
	private String tenNhanVien;
	private String maPhong;
	private String tenPhong;
	private String maCqt;
	private String tenCqt;
	private String chucVu;
	private Collection dsNhanVien;
	private String isNSD;
	private String cqtt;
	private boolean searchCqtTrucThuoc;
	private String maCqtTrucThuoc;
	public String getMaCqtTrucThuoc() {
		return maCqtTrucThuoc;
	}

	public void setMaCqtTrucThuoc(String maCqtTrucThuoc) {
		this.maCqtTrucThuoc = maCqtTrucThuoc;
	}

	public boolean isSearchCqtTrucThuoc() {
		return searchCqtTrucThuoc;
	}

	public void setSearchCqtTrucThuoc(boolean searchCqtTrucThuoc) {
		this.searchCqtTrucThuoc = searchCqtTrucThuoc;
	}

	/**
	 * @return
	 */
	public String getMaCqt() {
		return maCqt;
	}

	/**
	 * @return
	 */
	public String getMaPhong() {
		return maPhong;
	}

	/**
	 * @return
	 */
	public String getTenCqt() {
		return tenCqt;
	}

	/**
	 * @return
	 */
	public String getTenPhong() {
		return tenPhong;
	}

	
	/**
	 * @param string
	 */
	public void setMaCqt(String string) {
		maCqt = string;
	}

	/**
	 * @param string
	 */
	public void setMaPhong(String string) {
		maPhong = string;
	}

	/**
	 * @param string
	 */
	public void setTenCqt(String string) {
		tenCqt = string;
	}

	/**
	 * @param string
	 */
	public void setTenPhong(String string) {
		tenPhong = string;
	}

	

	/**
	 * @return
	 */
	public Collection getDsNhanVien() {
		return dsNhanVien;
	}

	/**
	 * @param collection
	 */
	public void setDsNhanVien(Collection collection) {
		dsNhanVien = collection;
	}

	
	/**
	 * @return
	 */
	public String getMaNhanVien() {
		return maNhanVien;
	}

	/**
	 * @return
	 */
	public String getTenNhanVien() {
		return tenNhanVien;
	}

	/**
	 * @param string
	 */
	public void setMaNhanVien(String string) {
		maNhanVien = string;
	}

	/**
	 * @param string
	 */
	public void setTenNhanVien(String string) {
		tenNhanVien = string;
	}

	/**
	 * @return
	 */
	public String getChucVu() {
		return chucVu;
	}

	/**
	 * @param string
	 */
	public void setChucVu(String string) {
		chucVu = string;
	}

	public String getIsNSD() {
		return isNSD;
	}

	public void setIsNSD(String isNSD) {
		this.isNSD = isNSD;
	}

	public String getCqtt() {
		return cqtt;
	}

	public void setCqtt(String cqtt) {
		this.cqtt = cqtt;
	}

}
