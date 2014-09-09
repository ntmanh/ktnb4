/*
 * Created on Apr 25, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.kntc.tiep_dan;

import cmc.com.ktnb.web.BaseActionForm;

/**
 * 
 * @author NguyenTrongCuong + Ntthu
 *@since 2011
 */
public class DaTiepNhanForm extends BaseActionForm{
	private String maHoSo,soHsGop,noiChuyenDon;
	private String ngayNhanVT;
	private String soCVDenVT;
	private String ngayNhanXL,soDon,ngayGuiDon;
	private String trangThai,loaiHoSo;//Trạng thái và loại hồ sơ của Hồ sơ gốc
		
	/**
	 * @return
	 */
	public String getMaHoSo() {
		return maHoSo;
	}

	/**
	 * @return
	 */
	public String getNgayNhanVT() {
		return ngayNhanVT;
	}

	/**
	 * @return
	 */
	public String getSoCVDenVT() {
		return soCVDenVT;
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
	public void setNgayNhanVT(String string) {
		ngayNhanVT = string;
	}

	/**
	 * @param string
	 */
	public void setSoCVDenVT(String string) {
		soCVDenVT = string;
	}

	/**
	 * @return
	 */
	public String getNgayNhanXL() {
		return ngayNhanXL;
	}

	/**
	 * @param string
	 */
	public void setNgayNhanXL(String string) {
		ngayNhanXL = string;
	}

	public String getSoHsGop() {
		return soHsGop;
	}

	public void setSoHsGop(String soHsGop) {
		this.soHsGop = soHsGop;
	}

	public String getNoiChuyenDon() {
		return noiChuyenDon;
	}

	public void setNoiChuyenDon(String noiChuyenDon) {
		this.noiChuyenDon = noiChuyenDon;
	}

	public String getNgayGuiDon() {
		return ngayGuiDon;
	}

	public void setNgayGuiDon(String ngayGuiDon) {
		this.ngayGuiDon = ngayGuiDon;
	}

	public String getSoDon() {
		return soDon;
	}

	public void setSoDon(String soDon) {
		this.soDon = soDon;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getLoaiHoSo() {
		return loaiHoSo;
	}

	public void setLoaiHoSo(String loaiHoSo) {
		this.loaiHoSo = loaiHoSo;
	}
}