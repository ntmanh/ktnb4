/*
 * Created on Oct 15, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.dung_chung.form;

import cmc.com.ktnb.util.DetailInformation;

/**
 * @author ntdung1
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TimKiemCuocTtktForm extends NoiDungTtktForm {
	private String tu_ngay;
	private String den_ngay;
	private String don_vi_duoc_ttkt;
	private String ma_cuoc_ttkt;
	private String thoi_gian_du_kien;
	private String hinh_thuc; // Dot xuat hay dinh ky
	private String loai; // Thanh tra hay kiem tra
	private String cuocTtktFocus;
	private DetailInformation[] dsCuocTtkt;
	private String trangThai;
	private String trangThaiPhanCongTruongDoan;
	private String nghiepVu;
	private String thoiGianDuKienTuNgay;
	private String thoiGianDuKienDenNgay;
	private String thoiGianDuKien;
	private String maCqtTienHanh;
	private String tenCqtTienHanh;
	private String namTienHanh;
	private String tenTruongDoan;
	private String sapXep;

	/**
	 * @return
	 */
	public String getDen_ngay() {
		return den_ngay;
	}

	/**
	 * @return
	 */
	public String getDon_vi_duoc_ttkt() {
		return don_vi_duoc_ttkt;
	}

	/**
	 * @return
	 */
	public String getMa_cuoc_ttkt() {
		return ma_cuoc_ttkt;
	}

	/**
	 * @return
	 */
	public String getTu_ngay() {
		return tu_ngay;
	}

	/**
	 * @param string
	 */
	public void setDen_ngay(String string) {
		den_ngay = string;
	}

	/**
	 * @param string
	 */
	public void setDon_vi_duoc_ttkt(String string) {
		don_vi_duoc_ttkt = string;
	}

	/**
	 * @param string
	 */
	public void setMa_cuoc_ttkt(String string) {
		ma_cuoc_ttkt = string;
	}

	/**
	 * @param string
	 */
	public void setTu_ngay(String string) {
		tu_ngay = string;
	}

	/**
	 * @return
	 */
	public String getThoi_gian_du_kien() {
		return thoi_gian_du_kien;
	}

	/**
	 * @param string
	 */
	public void setThoi_gian_du_kien(String string) {
		thoi_gian_du_kien = string;
	}

	/**
	 * @return
	 */
	public String getLoai() {
		return loai;
	}

	/**
	 * @param string
	 */
	public void setLoai(String string) {
		loai = string;
	}

	/**
	 * @return
	 */
	public String getHinh_thuc() {
		return hinh_thuc;
	}

	/**
	 * @param string
	 */
	public void setHinh_thuc(String string) {
		hinh_thuc = string;
	}

	/**
	 * @return
	 */
	public String getCuocTtktFocus() {
		return cuocTtktFocus;
	}

	/**
	 * @param string
	 */
	public void setCuocTtktFocus(String string) {
		cuocTtktFocus = string;
	}

	/**
	 * @return
	 */
	public DetailInformation[] getDsCuocTtkt() {
		return dsCuocTtkt;
	}

	/**
	 * @param informations
	 */
	public void setDsCuocTtkt(DetailInformation[] informations) {
		dsCuocTtkt = informations;
	}

	/**
	 * @return
	 */
	public String getTrangThai() {
		return trangThai;
	}

	/**
	 * @param string
	 */
	public void setTrangThai(String string) {
		trangThai = string;
	}

	/**
	 * @return
	 */
	public String getNghiepVu() {
		return nghiepVu;
	}

	/**
	 * @param string
	 */
	public void setNghiepVu(String string) {
		nghiepVu = string;
	}

	/**
	 * @return
	 */
	public String getTrangThaiPhanCongTruongDoan() {
		return trangThaiPhanCongTruongDoan;
	}

	/**
	 * @param string
	 */
	public void setTrangThaiPhanCongTruongDoan(String string) {
		trangThaiPhanCongTruongDoan = string;
	}

	/**
	 * @return
	 */
	public String getThoiGianDuKienDenNgay() {
		return thoiGianDuKienDenNgay;
	}

	/**
	 * @return
	 */
	public String getThoiGianDuKienTuNgay() {
		return thoiGianDuKienTuNgay;
	}

	/**
	 * @param string
	 */
	public void setThoiGianDuKienDenNgay(String string) {
		thoiGianDuKienDenNgay = string;
	}

	/**
	 * @param string
	 */
	public void setThoiGianDuKienTuNgay(String string) {
		thoiGianDuKienTuNgay = string;
	}

	/**
	 * @return
	 */
	public String getThoiGianDuKien() {
		return thoiGianDuKien;
	}

	/**
	 * @param string
	 */
	public void setThoiGianDuKien(String string) {
		thoiGianDuKien = string;
	}

	/**
	 * @return
	 */
	public String getMaCqtTienHanh() {
		return maCqtTienHanh;
	}

	/**
	 * @param string
	 */
	public void setMaCqtTienHanh(String string) {
		maCqtTienHanh = string;
	}

	public String getNamTienHanh() {
		return namTienHanh;
	}

	public void setNamTienHanh(String namTienHanh) {
		this.namTienHanh = namTienHanh;
	}

	public String getTenCqtTienHanh() {
		return tenCqtTienHanh;
	}

	public void setTenCqtTienHanh(String tenCqtTienHanh) {
		this.tenCqtTienHanh = tenCqtTienHanh;
	}

	public String getTenTruongDoan() {
		return tenTruongDoan;
	}

	public void setTenTruongDoan(String tenTruongDoan) {
		this.tenTruongDoan = tenTruongDoan;
	}

	public String getSapXep() {
		return sapXep;
	}

	public void setSapXep(String sapXep) {
		this.sapXep = sapXep;
	}
	
}
