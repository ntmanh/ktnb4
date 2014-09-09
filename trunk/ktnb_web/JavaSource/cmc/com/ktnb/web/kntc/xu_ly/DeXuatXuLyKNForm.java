/*
 * Created on Mar 3, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.kntc.xu_ly;

import java.text.Format;
import java.util.ArrayList;

import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.dung_chung.form.XacNhanForm;

/*
 * Đề xuất xử lý form
 * @author dhphuc
 */
public class DeXuatXuLyKNForm extends XacNhanForm {
	private String coQuanTrucTiep;

	private String boPhanXLDon;

	private String lanGui;

	private String nguoiKNTC;

	private String chuDanhNguoiKNTC;

	private String dcNguoiKNTC;

	private String nguoiBiKNTC;

	private String chuDanhNguoiBiKNTC;

	private String dcNguoiBiKNTC;

	private String cqDaQG;

	private String ndDaQG;

	private String donTomTat;

	private String fullFileName;

	private String thamQuyen;

	private String thuLy;

	private String giaiQuyetNgay;

	private String truongBP, diaDiem;

	private String canBoTL, ngayDx;

	private String deXuatXL;

	private String ma;

	private String arrDms;

	private String arrTenTl;

	private String noiDungKNTC;

	private String quaHan;

	private ArrayList thamQuyenList;

	private ArrayList thuLyList;
	
	private String strListIdBieuMau;
	
	private String luuDon;
	
	public ArrayList getThamQuyenList() {
		return thamQuyenList;
	}

	public void setThamQuyenList(ArrayList list) {
		thamQuyenList = list;
	}

	public ArrayList getThuLyList() {
		return thuLyList;
	}
	
	public void setThuLyList(ArrayList list) {
		thuLyList = list;
	}
	
	public String getQuaHan() {
		return quaHan;
	}

	public void setQuaHan(String quaHan) {
		this.quaHan = quaHan;
	}

	public String getArrTenTl() {
		return arrTenTl;
	}

	public void setArrTenTl(String arrTenTl) {
		this.arrTenTl = arrTenTl;
	}

	public String getBoPhanXLDon() {
		return boPhanXLDon;
	}

	public String getCanBoTL() {
		return canBoTL;
	}

	public String getCoQuanTrucTiep() {
		return coQuanTrucTiep;
	}

	public String getDeXuatXL() {
		return deXuatXL;
	}

	public String getDonTomTat() {
		return donTomTat;
	}

	public String getGiaiQuyetNgay() {
		return giaiQuyetNgay;
	}

	public String getLanGui() {
		return lanGui;
	}

	public String getThamQuyen() {
		return thamQuyen;
	}

	public String getThuLy() {
		return thuLy;
	}

	public String getTruongBP() {
		return truongBP;
	}

	public void setBoPhanXLDon(String string) {
		boPhanXLDon = string;
	}

	public void setCanBoTL(String string) {
		canBoTL = string;
	}

	public void setCoQuanTrucTiep(String string) {
		coQuanTrucTiep = string;
	}

	public void setDeXuatXL(String string) {
		deXuatXL = string;
	}

	public void setDonTomTat(String string) {
		donTomTat = string;
	}

	public void setGiaiQuyetNgay(String string) {
		giaiQuyetNgay = string;
	}

	public void setLanGui(String string) {
		lanGui = string;
	}

	public void setThamQuyen(String string) {
		thamQuyen = string;
	}

	public void setThuLy(String string) {
		thuLy = string;
	}

	public void setTruongBP(String string) {
		truongBP = string;
	}

	public String getFullFileName() {
		return fullFileName;
	}

	public void setFullFileName(String string) {
		fullFileName = string;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String string) {
		ma = string;
	}

	public String getArrDms() {
		return arrDms;
	}

	public void setArrDms(String string) {
		arrDms = string;
	}

	public String getChuDanhNguoiBiKNTC() {
		return chuDanhNguoiBiKNTC;
	}

	public void setChuDanhNguoiBiKNTC(String chuDanhNguoiBiKNTC) {
		this.chuDanhNguoiBiKNTC = chuDanhNguoiBiKNTC;
	}

	public String getChuDanhNguoiKNTC() {
		return chuDanhNguoiKNTC;
	}

	public void setChuDanhNguoiKNTC(String chuDanhNguoiKNTC) {
		this.chuDanhNguoiKNTC = chuDanhNguoiKNTC;
	}

	public String getCqDaQG() {
		return cqDaQG;
	}

	public void setCqDaQG(String cqDaQG) {
		this.cqDaQG = cqDaQG;
	}

	public String getDcNguoiBiKNTC() {
		return dcNguoiBiKNTC;
	}

	public void setDcNguoiBiKNTC(String dcNguoiBiKNTC) {
		this.dcNguoiBiKNTC = dcNguoiBiKNTC;
	}

	public String getDcNguoiKNTC() {
		return dcNguoiKNTC;
	}

	public void setDcNguoiKNTC(String dcNguoiKNTC) {
		this.dcNguoiKNTC = dcNguoiKNTC;
	}

	public String getNdDaQG() {
		return ndDaQG;
	}

	public void setNdDaQG(String ndDaQG) {
		this.ndDaQG = ndDaQG;
	}

	public String getNguoiBiKNTC() {
		return nguoiBiKNTC;
	}

	public void setNguoiBiKNTC(String nguoiBiKNTC) {
		this.nguoiBiKNTC = nguoiBiKNTC;
	}

	public String getNguoiKNTC() {
		return nguoiKNTC;
	}

	public void setNguoiKNTC(String nguoiKNTC) {
		this.nguoiKNTC = nguoiKNTC;
	}

	public String getNgayDx() {
		return ngayDx;
	}

	public void setNgayDx(String ngayDx) {
		this.ngayDx = ngayDx;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getNoiDungKNTC() {
		return noiDungKNTC;
	}

	public void setNoiDungKNTC(String noiDungKNTC) {
		this.noiDungKNTC = noiDungKNTC;
	}

	public String getStrListIdBieuMau() {
		return strListIdBieuMau;
	}

	public void setStrListIdBieuMau(String strListIdBieuMau) {
		this.strListIdBieuMau = strListIdBieuMau;
	}

	public String getLuuDon() {
		return luuDon;
	}

	public void setLuuDon(String luuDon) {
		this.luuDon = luuDon;
	}
}
