package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form;
 


import org.apache.struts.upload.FormFile;

import cmc.com.ktnb.web.BaseActionForm;


/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */

public class YeuCauGiaiTrinhForm extends BaseActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String idCuocTtKt;
	private String ngaylapPhieu;
	private String noiLapPhieu;
	private String idNGuoiGT;
	private String tenNguoiGT;
	private String cvNguoiLapPhieu;
	private String nsNguoiGT;
	private String dvNguoiGT;
	private String ndungGT;
	private String ngayGuiGT;
	private String noiGuiGT;
	private String diadiemBCGT;
	private String tgBCGT;
	private String noidungBCGT;
	private FormFile baoCao;
	private String hoSoTaiLieuBC;
	


	/**
	 * @return
	 */
	public FormFile getBaoCao() {
		return baoCao;
	}

	/**
	 * @return
	 */
	public String getDiadiemBCGT() {
		return diadiemBCGT;
	}

	/**
	 * @return
	 */
	public String getDvNguoiGT() {
		return dvNguoiGT;
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
	public String getIdNGuoiGT() {
		return idNGuoiGT;
	}

	/**
	 * @return
	 */
	public String getNdungGT() {
		return ndungGT;
	}

	/**
	 * @return
	 */
	public String getNgayGuiGT() {
		return ngayGuiGT;
	}

	/**
	 * @return
	 */
	public String getNgaylapPhieu() {
		return ngaylapPhieu;
	}

	/**
	 * @return
	 */
	public String getNoidungBCGT() {
		return noidungBCGT;
	}

	/**
	 * @return
	 */
	public String getNoiGuiGT() {
		return noiGuiGT;
	}

	/**
	 * @return
	 */
	public String getNoiLapPhieu() {
		return noiLapPhieu;
	}

	/**
	 * @return
	 */
	public String getNsNguoiGT() {
		return nsNguoiGT;
	}

	/**
	 * @return
	 */
	public String getTenNguoiGT() {
		return tenNguoiGT;
	}

	/**
	 * @return
	 */
	public String getTgBCGT() {
		return tgBCGT;
	}

	/**
	 * @param file
	 */
	public void setBaoCao(FormFile file) {
		baoCao = file;
	}

	/**
	 * @param string
	 */
	public void setDiadiemBCGT(String string) {
		diadiemBCGT = string;
	}

	/**
	 * @param string
	 */
	public void setDvNguoiGT(String string) {
		dvNguoiGT = string;
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
	public void setIdNGuoiGT(String string) {
		idNGuoiGT = string;
	}

	/**
	 * @param string
	 */
	public void setNdungGT(String string) {
		ndungGT = string;
	}

	/**
	 * @param string
	 */
	public void setNgayGuiGT(String string) {
		ngayGuiGT = string;
	}

	/**
	 * @param string
	 */
	public void setNgaylapPhieu(String string) {
		ngaylapPhieu = string;
	}

	/**
	 * @param string
	 */
	public void setNoidungBCGT(String string) {
		noidungBCGT = string;
	}

	/**
	 * @param string
	 */
	public void setNoiGuiGT(String string) {
		noiGuiGT = string;
	}

	/**
	 * @param string
	 */
	public void setNoiLapPhieu(String string) {
		noiLapPhieu = string;
	}

	/**
	 * @param string
	 */
	public void setNsNguoiGT(String string) {
		nsNguoiGT = string;
	}

	/**
	 * @param string
	 */
	public void setTenNguoiGT(String string) {
		tenNguoiGT = string;
	}

	/**
	 * @param string
	 */
	public void setTgBCGT(String string) {
		tgBCGT = string;
	}

	/**
	 * @return
	 */
	public String getCvNguoiLapPhieu() {
		return cvNguoiLapPhieu;
	}

	/**
	 * @param string
	 */
	public void setCvNguoiLapPhieu(String string) {
		cvNguoiLapPhieu = string;
	}

	public String getHoSoTaiLieuBC() {
		return hoSoTaiLieuBC;
	}

	public void setHoSoTaiLieuBC(String hoSoTaiLieuBC) {
		this.hoSoTaiLieuBC = hoSoTaiLieuBC;
	}



 }