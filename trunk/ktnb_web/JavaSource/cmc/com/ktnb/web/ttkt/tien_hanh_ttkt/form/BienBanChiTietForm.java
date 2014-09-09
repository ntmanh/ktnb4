package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form;

import org.apache.struts.upload.FormFile;

import cmc.com.ktnb.web.BaseActionForm;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */

public class BienBanChiTietForm extends BaseActionForm {
	private String id;
	private String idCuocTtkt;
	private String idNguoiLap;
	private String tenNguoiLap;
	private String tgianThTuNgay;
	private String tgianThDenNgay;
	private String ttktTai;
	private String thoiDiemLapBb;
	private String diaDiemLapBb;
	private String noiDungTomTat;
	private String thoiDiemThongQua;
	private FormFile fileDinhKem;
	private String ngayPhanCongCuaTd;
	private String loaiBb;

	/**
	 * @return
	 */
	public String getDiaDiemLapBb() {
		return diaDiemLapBb;
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
	public String getIdCuocTtkt() {
		return idCuocTtkt;
	}

	/**
	 * @return
	 */
	public String getIdNguoiLap() {
		return idNguoiLap;
	}

	/**
	 * @return
	 */
	public String getLoaiBb() {
		return loaiBb;
	}

	/**
	 * @return
	 */
	public String getNgayPhanCongCuaTd() {
		return ngayPhanCongCuaTd;
	}

	/**
	 * @return
	 */
	public String getNoiDungTomTat() {
		return noiDungTomTat;
	}

	/**
	 * @return
	 */
	public String getTenNguoiLap() {
		return tenNguoiLap;
	}

	/**
	 * @return
	 */
	public String getTgianThDenNgay() {
		return tgianThDenNgay;
	}

	/**
	 * @return
	 */
	public String getTgianThTuNgay() {
		return tgianThTuNgay;
	}

	/**
	 * @return
	 */
	public String getThoiDiemLapBb() {
		return thoiDiemLapBb;
	}

	/**
	 * @return
	 */
	public String getThoiDiemThongQua() {
		return thoiDiemThongQua;
	}

	/**
	 * @return
	 */
	public String getTtktTai() {
		return ttktTai;
	}

	/**
	 * @param string
	 */
	public void setDiaDiemLapBb(String string) {
		diaDiemLapBb = string;
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
	public void setIdCuocTtkt(String string) {
		idCuocTtkt = string;
	}

	/**
	 * @param string
	 */
	public void setIdNguoiLap(String string) {
		idNguoiLap = string;
	}

	/**
	 * @param string
	 */
	public void setLoaiBb(String string) {
		loaiBb = string;
	}

	/**
	 * @param string
	 */
	public void setNgayPhanCongCuaTd(String string) {
		ngayPhanCongCuaTd = string;
	}

	/**
	 * @param string
	 */
	public void setNoiDungTomTat(String string) {
		noiDungTomTat = string;
	}

	/**
	 * @param string
	 */
	public void setTenNguoiLap(String string) {
		tenNguoiLap = string;
	}

	/**
	 * @param string
	 */
	public void setTgianThDenNgay(String string) {
		tgianThDenNgay = string;
	}

	/**
	 * @param string
	 */
	public void setTgianThTuNgay(String string) {
		tgianThTuNgay = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemLapBb(String string) {
		thoiDiemLapBb = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemThongQua(String string) {
		thoiDiemThongQua = string;
	}

	/**
	 * @param string
	 */
	public void setTtktTai(String string) {
		ttktTai = string;
	}

	/**
	 * @return
	 */
	public FormFile getFileDinhKem() {
		return fileDinhKem;
	}

	/**
	 * @param file
	 */
	public void setFileDinhKem(FormFile file) {
		fileDinhKem = file;
	}

}