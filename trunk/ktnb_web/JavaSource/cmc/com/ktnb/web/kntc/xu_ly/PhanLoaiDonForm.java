/*
 * Created on Mar 2, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.kntc.xu_ly;

import java.util.ArrayList;

import cmc.com.ktnb.web.BaseActionForm;

/**
 * Phân loại đơn form
 * @author DoHongPhuc
 * 
 * To change the template for this generated type comment go to Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PhanLoaiDonForm extends BaseActionForm {
	private String maHoSo;

	private String maDeXuat;

	private String thamQuyen,quaHan;

	private String thuLy;

	private ArrayList thamQuyenList;

	private ArrayList thuLyList;

	private ArrayList listMauBieu;

	private String arrTenTl;
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

	/**
	 * @return
	 */
	public String getThamQuyen() {
		return thamQuyen;
	}

	/**
	 * @param string
	 */
	public void setThamQuyen(String string) {
		thamQuyen = string;
	}

	/**
	 * @return
	 */
	public ArrayList getThamQuyenList() {
		return thamQuyenList;
	}

	/**
	 * @param list
	 */
	public void setThamQuyenList(ArrayList list) {
		thamQuyenList = list;
	}

	/**
	 * @return
	 */
	public String getMaHoSo() {
		return maHoSo;
	}

	/**
	 * @param string
	 */
	public void setMaHoSo(String string) {
		maHoSo = string;
	}

	/**
	 * @return
	 */
	public String getThuLy() {
		return thuLy;
	}

	/**
	 * @return
	 */
	public ArrayList getThuLyList() {
		return thuLyList;
	}

	/**
	 * @param string
	 */
	public void setThuLy(String string) {
		thuLy = string;
	}

	/**
	 * @param list
	 */
	public void setThuLyList(ArrayList list) {
		thuLyList = list;
	}

	/**
	 * @return
	 */
	public String getMaDeXuat() {
		return maDeXuat;
	}

	/**
	 * @param string
	 */
	public void setMaDeXuat(String string) {
		maDeXuat = string;
	}

	/**
	 * @return
	 */
	public ArrayList getListMauBieu() {
		return listMauBieu;
	}

	/**
	 * @param list
	 */
	public void setListMauBieu(ArrayList list) {
		listMauBieu = list;
	}
}
