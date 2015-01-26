package cmc.com.ktnb.web.kntc.tiep_dan;

import java.util.ArrayList;

import cmc.com.ktnb.web.BaseActionForm;

/**
 * Form tìm kiếm
 * 
 * @author Ntthu Created on Nov 2, 2010
 */
public class TimkiemForm extends BaseActionForm {

	// Thong tin Ho so
	private String maHoSo;

	private String maQd;

	private String loaiHoSo;

	private String trangThai;

	private String tuNgay;

	private String denNgay;

	private String cvTuNgay;

	private String cvDenNgay;

	private String arrCqt, data;

	private String nguoiNopDon;

	private String nguoiUyQuyen;

	private String textSearch, capCqt;

	private String canBoXL;

	private boolean trungDon;

	private boolean luuDon;

	private String loaiKetThuc;

	private String loaiQuanHe;

	private String thamQuyen;

	private ArrayList thamQuyenList;

	private ArrayList thuLyList;

	private String thuLy;
	
	private String tdTuNgay;
	
	private String tdDenNgay;
	
	private String doanKNTC;
	
	public static final String ALL = "0";

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

	/**
	 * @return
	 */
	public String getDenNgay() {
		return denNgay;
	}

	/**
	 * @return
	 */
	public String getLoaiHoSo() {
		return loaiHoSo;
	}

	/**
	 * @return
	 */
	public String getMaHoSo() {
		return maHoSo;
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
	public void setLoaiHoSo(String string) {
		loaiHoSo = string;
	}

	/**
	 * @param string
	 */
	public void setMaHoSo(String string) {
		maHoSo = string;
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

	/**
	 * @return
	 */
	public String getMaQd() {
		return maQd;
	}

	/**
	 * @param string
	 */
	public void setMaQd(String string) {
		maQd = string;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNguoiNopDon() {
		return nguoiNopDon;
	}

	public void setNguoiNopDon(String nguoinopdon) {
		this.nguoiNopDon = nguoinopdon;
	}

	public String getNguoiUyQuyen() {
		return nguoiUyQuyen;
	}

	public void setNguoiUyQuyen(String nguoiuyquyen) {
		this.nguoiUyQuyen = nguoiuyquyen;
	}

	public String getTextSearch() {
		return textSearch;
	}

	public void setTextSearch(String textSearch) {
		this.textSearch = textSearch;
	}

	public String getCvDenNgay() {
		return cvDenNgay;
	}

	public void setCvDenNgay(String cvDenNgay) {
		this.cvDenNgay = cvDenNgay;
	}

	public String getCvTuNgay() {
		return cvTuNgay;
	}

	public void setCvTuNgay(String cvTuNgay) {
		this.cvTuNgay = cvTuNgay;
	}

	public String getCanBoXL() {
		return canBoXL;
	}

	public void setCanBoXL(String canBoXL) {
		this.canBoXL = canBoXL;
	}

	public String getCapCqt() {
		return capCqt;
	}

	public void setCapCqt(String capCqt) {
		this.capCqt = capCqt;
	}

	public boolean isLuuDon() {
		return luuDon;
	}

	public void setLuuDon(boolean luuDon) {
		this.luuDon = luuDon;
	}

	public boolean isTrungDon() {
		return trungDon;
	}

	public void setTrungDon(boolean trungDon) {
		this.trungDon = trungDon;
	}

	public String getLoaiKetThuc() {
		return loaiKetThuc;
	}

	public void setLoaiKetThuc(String loaiKetThuc) {
		this.loaiKetThuc = loaiKetThuc;
	}

	public String getLoaiQuanHe() {
		return loaiQuanHe;
	}

	public void setLoaiQuanHe(String loaiQuanHe) {
		this.loaiQuanHe = loaiQuanHe;
	}

	public String getThamQuyen() {
		return thamQuyen;
	}

	public void setThamQuyen(String thamQuyen) {
		this.thamQuyen = thamQuyen;
	}

	public String getThuLy() {
		return thuLy;
	}

	public void setThuLy(String thuLy) {
		this.thuLy = thuLy;
	}

	public String getTdDenNgay() {
		return tdDenNgay;
	}

	public void setTdDenNgay(String tdDenNgay) {
		this.tdDenNgay = tdDenNgay;
	}

	public String getTdTuNgay() {
		return tdTuNgay;
	}

	public void setTdTuNgay(String tdTuNgay) {
		this.tdTuNgay = tdTuNgay;
	}

	public String getDoanKNTC() {
		return doanKNTC;
	}

	public void setDoanKNTC(String doanKNTC) {
		this.doanKNTC = doanKNTC;
	}
	
}
