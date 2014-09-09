package cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.form;

import org.apache.struts.upload.FormFile;

import cmc.com.ktnb.web.BaseActionForm;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */
public class HoanThanhTraKiemTraForm extends BaseActionForm {

private String id;
private String idCuocTtKt;
private String cqtDeNghi;
private String ngayHoan;
private String ngayBatDauLai;
private String lyDoHoan;
private FormFile vbXinHoanCuaDvDuocTtKt;
private FormFile vbTraLoiCuaDvTh;
private String trangThai;
private String ngayBatDauThucTe;
private String idVbHoan;
private String idVbTraLoi;
private String idVbThongBaoHoan;

private String tenFileThongBaoHoan;

private String loaiFileThongBaoHoan;

private FormFile vbThongBaoHoan;


public String getIdVbThongBaoHoan() {
	return idVbThongBaoHoan;
}

public void setIdVbThongBaoHoan(String idVbThongBaoHoan) {
	this.idVbThongBaoHoan = idVbThongBaoHoan;
}

public String getLoaiFileThongBaoHoan() {
	return loaiFileThongBaoHoan;
}

public void setLoaiFileThongBaoHoan(String loaiFileThongBaoHoan) {
	this.loaiFileThongBaoHoan = loaiFileThongBaoHoan;
}

public String getTenFileThongBaoHoan() {
	return tenFileThongBaoHoan;
}

public void setTenFileThongBaoHoan(String tenFileThongBaoHoan) {
	this.tenFileThongBaoHoan = tenFileThongBaoHoan;
}



public FormFile getVbThongBaoHoan() {
	return vbThongBaoHoan;
}

public void setVbThongBaoHoan(FormFile vbThongBaoHoan) {
	this.vbThongBaoHoan = vbThongBaoHoan;
}

/**
 * @return
 */
public String getCqtDeNghi() {
	return cqtDeNghi;
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
public String getLyDoHoan() {
	return lyDoHoan;
}

/**
 * @return
 */
public String getNgayBatDauLai() {
	return ngayBatDauLai;
}

/**
 * @return
 */
public String getNgayBatDauThucTe() {
	return ngayBatDauThucTe;
}

/**
 * @return
 */
public String getNgayHoan() {
	return ngayHoan;
}

/**
 * @return
 */
public String getTrangThai() {
	return trangThai;
}

/**
 * @return
 */
public FormFile getVbTraLoiCuaDvTh() {
	return vbTraLoiCuaDvTh;
}

/**
 * @return
 */
public FormFile getVbXinHoanCuaDvDuocTtKt() {
	return vbXinHoanCuaDvDuocTtKt;
}

/**
 * @param string
 */
public void setCqtDeNghi(String string) {
	cqtDeNghi = string;
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
public void setLyDoHoan(String string) {
	lyDoHoan = string;
}

/**
 * @param string
 */
public void setNgayBatDauLai(String string) {
	ngayBatDauLai = string;
}

/**
 * @param string
 */
public void setNgayBatDauThucTe(String string) {
	ngayBatDauThucTe = string;
}

/**
 * @param string
 */
public void setNgayHoan(String string) {
	ngayHoan = string;
}

/**
 * @param string
 */
public void setTrangThai(String string) {
	trangThai = string;
}

/**
 * @param string
 */
public void setVbTraLoiCuaDvTh(FormFile string) {
	vbTraLoiCuaDvTh = string;
}

/**
 * @param string
 */
public void setVbXinHoanCuaDvDuocTtKt(FormFile string) {
	vbXinHoanCuaDvDuocTtKt = string;
}



/**
 * @return
 */
public String getIdVbHoan() {
	return idVbHoan;
}

/**
 * @return
 */
public String getIdVbTraLoi() {
	return idVbTraLoi;
}

/**
 * @param string
 */
public void setIdVbHoan(String string) {
	idVbHoan = string;
}

/**
 * @param string
 */
public void setIdVbTraLoi(String string) {
	idVbTraLoi = string;
}

}
