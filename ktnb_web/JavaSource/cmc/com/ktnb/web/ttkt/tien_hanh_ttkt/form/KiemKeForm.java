package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form;
 

import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.web.BaseActionForm;


/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */

public class KiemKeForm extends BaseActionForm {
	// Bien ban kiem ke
	private String idBBKK;
	private String idQdKk;
	private String thoiGianBatDau;
	private String thoiGianKetThuc;
	private String soluongChungloaiXs;
	private String thoiDiemLapBb;
	private String thoiDiemKk;
	private String idDaiDienDoanTTKT;
	private String idDaiDienDVCOTSTKK;
	private String dvDuocGiaoBQTS;
	private String idDsTvd;
	
	
	// Quyet dinh kiem ke

	private String idCuocTtkt;
	private String thoiGianKk;
	private String taiSanCanKiemKe;
	private String donViDangBaoQuan;
	private String diaDiemCoTsKk;
	private String donViCaNhanDuocKk;
	private String donViCaNhanBaoQuan;
	private String noiRaQd;
	private String ngayRaQd;
	private String thuTruongDonViCoTSKK;
	private String donViCoLienQuan;
	
	
	//Thanh phan tham du
	private TtktCmThanhPhanThamDu[] donViTtKt;
	private TtktCmThanhPhanThamDu[] donViCoTaiSanDuocKK;
	private String phanLoaiTV;

	private String cbDsTvd;
	/**
	 * @return
	 */


	/**
	 * @return
	 */
	public String getDiaDiemCoTsKk() {
		return diaDiemCoTsKk;
	}

	/**
	 * @return
	 */
	public String getDonViCaNhanBaoQuan() {
		return donViCaNhanBaoQuan;
	}

	/**
	 * @return
	 */
	public String getDonViCaNhanDuocKk() {
		return donViCaNhanDuocKk;
	}

	/**
	 * @return
	 */
	public String getDonViDangBaoQuan() {
		return donViDangBaoQuan;
	}

	/**
	 * @return
	 */
	public String getIdBBKK() {
		return idBBKK;
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
	public String getIdQdKk() {
		return idQdKk;
	}



	/**
	 * @return
	 */
	public String getNgayRaQd() {
		return ngayRaQd;
	}

	/**
	 * @return
	 */
	public String getNoiRaQd() {
		return noiRaQd;
	}

	/**
	 * @return
	 */
	public String getSoluongChungloaiXs() {
		return soluongChungloaiXs;
	}

	/**
	 * @return
	 */
	public String getTaiSanCanKiemKe() {
		return taiSanCanKiemKe;
	}

	/**
	 * @return
	 */
	public String getThoiDiemKk() {
		return thoiDiemKk;
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
	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	/**
	 * @return
	 */
	public String getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	/**
	 * @return
	 */
	public String getThoiGianKk() {
		return thoiGianKk;
	}


	/**
	 * @param string
	 */
	public void setDiaDiemCoTsKk(String string) {
		diaDiemCoTsKk = string;
	}

	/**
	 * @param string
	 */
	public void setDonViCaNhanBaoQuan(String string) {
		donViCaNhanBaoQuan = string;
	}

	/**
	 * @param string
	 */
	public void setDonViCaNhanDuocKk(String string) {
		donViCaNhanDuocKk = string;
	}

	/**
	 * @param string
	 */
	public void setDonViDangBaoQuan(String string) {
		donViDangBaoQuan = string;
	}

	/**
	 * @param string
	 */
	public void setIdBBKK(String string) {
		idBBKK = string;
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
	public void setIdQdKk(String string) {
		idQdKk = string;
	}

	/**
	 * @param string
	 */

	/**
	 * @param string
	 */
	public void setNgayRaQd(String string) {
		ngayRaQd = string;
	}

	/**
	 * @param string
	 */
	public void setNoiRaQd(String string) {
		noiRaQd = string;
	}

	/**
	 * @param string
	 */
	public void setSoluongChungloaiXs(String string) {
		soluongChungloaiXs = string;
	}

	/**
	 * @param string
	 */
	public void setTaiSanCanKiemKe(String string) {
		taiSanCanKiemKe = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemKk(String string) {
		thoiDiemKk = string;
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
	public void setThoiGianBatDau(String string) {
		thoiGianBatDau = string;
	}

	/**
	 * @param string
	 */
	public void setThoiGianKetThuc(String string) {
		thoiGianKetThuc = string;
	}

	/**
	 * @param string
	 */
	public void setThoiGianKk(String string) {
		thoiGianKk = string;
	}

	/**
	 * @return
	 */
	public String getDonViCoLienQuan() {
		return donViCoLienQuan;
	}

	/**
	 * @return
	 */
	public String getThuTruongDonViCoTSKK() {
		return thuTruongDonViCoTSKK;
	}

	/**
	 * @param string
	 */
	public void setDonViCoLienQuan(String string) {
		donViCoLienQuan = string;
	}

	/**
	 * @param string
	 */
	public void setThuTruongDonViCoTSKK(String string) {
		thuTruongDonViCoTSKK = string;
	}



	/**
	 * @return
	 */
	public String getDvDuocGiaoBQTS() {
		return dvDuocGiaoBQTS;
	}


	/**
	 * @param string
	 */
	public void setDvDuocGiaoBQTS(String string) {
		dvDuocGiaoBQTS = string;
	}



	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getDonViCoTaiSanDuocKK() {
		return donViCoTaiSanDuocKK;
	}

	/**
	 * @return
	 */
	public String getPhanLoaiTV() {
		return phanLoaiTV;
	}

	/**
	 * @param dus
	 */
	public void setDonViCoTaiSanDuocKK(TtktCmThanhPhanThamDu[] dus) {
		donViCoTaiSanDuocKK = dus;
	}

	/**
	 * @param string
	 */
	public void setPhanLoaiTV(String string) {
		phanLoaiTV = string;
	}

	/**
	 * @return
	 */
	public String getCbDsTvd() {
		return cbDsTvd;
	}

	/**
	 * @param string
	 */
	public void setCbDsTvd(String string) {
		cbDsTvd = string;
	}

	/**
	 * @return
	 */
	public String getIdDaiDienDoanTTKT() {
		return idDaiDienDoanTTKT;
	}

	/**
	 * @param string
	 */
	public void setIdDaiDienDoanTTKT(String string) {
		idDaiDienDoanTTKT = string;
	}

	/**
	 * @return
	 */
	public String getIdDaiDienDVCOTSTKK() {
		return idDaiDienDVCOTSTKK;
	}

	/**
	 * @param string
	 */
	public void setIdDaiDienDVCOTSTKK(String string) {
		idDaiDienDVCOTSTKK = string;
	}

	public TtktCmThanhPhanThamDu[] getDonViTtKt() {
		return donViTtKt;
	}

	public void setDonViTtKt(TtktCmThanhPhanThamDu[] donViTtKt) {
		this.donViTtKt = donViTtKt;
	}

	public String getIdDsTvd() {
		return idDsTvd;
	}

	public void setIdDsTvd(String idDsTvd) {
		this.idDsTvd = idDsTvd;
	}



 }