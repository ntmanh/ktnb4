package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form;

import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.web.BaseActionForm;

/**
 * Form bean for a Struts application. 
 * @version 	1.0
 * @author
 */
public class NiemPhongHoSoTaiLieuForm extends BaseActionForm {

	//Quyet dinh niem phong
	private String idQdNiemPhong;
	private String noiRaQDNP;
	private String ngayRaQDNP;
	private String loaiTaiLieuQDNP;
	private String thoiGianNPTu;
	private String dinViCaNhanThucHien;
	private String tenCanBoDvCnTh;
	private String chucVuTrongDoanQDNP;
	private String dinViCaNhanBaoQuanQdNp;
	private String dinViCaNhanBaoQuanBbNp;
	private String idDsTvdQdNiemPhong;
	

	//Bien ban niem phong
	private String idBbNiemPhong;
	private String vaoLucBienBanNP;
	private String taiDiaDiemNP;
	private String tienHanhNPCacTaiLieu;
	private String thoiGianHoanThanhNP;
	private String idThanhPhanThamDuDoanTtktBBNP;
	private String idThanhPhanThamDuCacOngBaBBNP;
	private TtktCmThanhPhanThamDu[] dsTVD;
	private TtktCmThanhPhanThamDu[] dsDvCoTlnp;
	private String idDsTvdBbNiemPhong;
	

	//Quyet dinh mo niem phong
	private String idBbMoNiemPhong;
	private String noiRaQDMoNP;
	private String ngayRaQDMoNP;
	private String donViBaoQuanSauNP;
	private String loaiTaiLieuBBNP;
	private String nguoiMoNP;
	private String chucVuNguoiMoNP;
	private String tenNguoiMoNp;
	private String idDsTvdQdMoNiemPhong;


	//Bien ban mo niem phong
	private String vaoLucBienBanMoNP;
	private String diaDiemBienBanMoNP;
	private String moNPCuaNgay;
	private String tinhTrangDauNiemPhong;
	private String thoiGianHoanThanhMoNP;
	private TtktCmThanhPhanThamDu[] dsTVD2;
	private TtktCmThanhPhanThamDu[] dsCacOb;
	private String idThanhPhanThamDuDoanTtktBBMNP;
	private String idThanhPhanThamDuCacOngBaBBMNP;
	private String idDsTvdBbMoNiemPhong;
	

	private String idCuocTtkt;
	private String idCqtBi;

	private String optionTag;

	/**
	 * @return
	 */
	public String getDiaDiemBienBanMoNP() {
		return diaDiemBienBanMoNP;
	}

	

	/**
	 * @return
	 */

	/**
	 * @return
	 */
	public String getLoaiTaiLieuQDNP() {
		return loaiTaiLieuQDNP;
	}

	/**
	 * @return
	 */
	public String getMoNPCuaNgay() {
		return moNPCuaNgay;
	}

	/**
	 * @return
	 */
	public String getNgayRaQDMoNP() {
		return ngayRaQDMoNP;
	}

	/**
	 * @return
	 */
	public String getNgayRaQDNP() {
		return ngayRaQDNP;
	}

	/**
	 * @return
	 */
	public String getNoiRaQDMoNP() {
		return noiRaQDMoNP;
	}

	/**
	 * @return
	 */
	public String getNoiRaQDNP() {
		return noiRaQDNP;
	}

	/**
	 * @return
	 */
	public String getTaiDiaDiemNP() {
		return taiDiaDiemNP;
	}

	/**
	 * @return
	 */
	public String getThoiGianHoanThanhMoNP() {
		return thoiGianHoanThanhMoNP;
	}

	/**
	 * @return
	 */
	public String getThoiGianHoanThanhNP() {
		return thoiGianHoanThanhNP;
	}

	/**
	 * @return
	 */
	public String getThoiGianNPTu() {
		return thoiGianNPTu;
	}

	/**
	 * @return
	 */
	public String getTienHanhNPCacTaiLieu() {
		return tienHanhNPCacTaiLieu;
	}

	/**
	 * @return
	 */
	public String getTinhTrangDauNiemPhong() {
		return tinhTrangDauNiemPhong;
	}

	/**
	 * @return
	 */
	public String getVaoLucBienBanMoNP() {
		return vaoLucBienBanMoNP;
	}

	/**
	 * @return
	 */
	public String getVaoLucBienBanNP() {
		return vaoLucBienBanNP;
	}

	/**
	 * @param string
	 */
	public void setDiaDiemBienBanMoNP(String string) {
		diaDiemBienBanMoNP = string;
	}

	



	/**
	 * @param string
	 */
	public void setDonViBaoQuanSauNP(String string) {
		donViBaoQuanSauNP = string;
	}

	/**
	 * @param string
	 */
	public void setLoaiTaiLieuQDNP(String string) {
		loaiTaiLieuQDNP = string;
	}

	/**
	 * @param string
	 */
	public void setMoNPCuaNgay(String string) {
		moNPCuaNgay = string;
	}

	/**
	 * @param string
	 */
	public void setNgayRaQDMoNP(String string) {
		ngayRaQDMoNP = string;
	}

	/**
	 * @param string
	 */
	public void setNgayRaQDNP(String string) {
		ngayRaQDNP = string;
	}

	/**
	 * @param string
	 */
	public void setNoiRaQDMoNP(String string) {
		noiRaQDMoNP = string;
	}

	/**
	 * @param string
	 */
	public void setNoiRaQDNP(String string) {
		noiRaQDNP = string;
	}

	/**
	 * @param string
	 */
	public void setTaiDiaDiemNP(String string) {
		taiDiaDiemNP = string;
	}

	/**
	 * @param string
	 */
	public void setThoiGianHoanThanhMoNP(String string) {
		thoiGianHoanThanhMoNP = string;
	}

	/**
	 * @param string
	 */
	public void setThoiGianHoanThanhNP(String string) {
		thoiGianHoanThanhNP = string;
	}

	/**
	 * @param string
	 */
	public void setThoiGianNPTu(String string) {
		thoiGianNPTu = string;
	}

	/**
	 * @param string
	 */
	public void setTienHanhNPCacTaiLieu(String string) {
		tienHanhNPCacTaiLieu = string;
	}

	/**
	 * @param string
	 */
	public void setTinhTrangDauNiemPhong(String string) {
		tinhTrangDauNiemPhong = string;
	}

	/**
	 * @param string
	 */
	public void setVaoLucBienBanMoNP(String string) {
		vaoLucBienBanMoNP = string;
	}

	/**
	 * @param string
	 */
	public void setVaoLucBienBanNP(String string) {
		vaoLucBienBanNP = string;
	}

	/**
	 * @return
	 */

	/**
	 * @return
	 */
	public String getLoaiTaiLieuBBNP() {
		return loaiTaiLieuBBNP;
	}

	/**
	 * @param string
	 */
	public void setLoaiTaiLieuBBNP(String string) {
		loaiTaiLieuBBNP = string;
	}

	/**
	 * @return
	 */
	public String getChucVuNguoiMoNP() {
		return chucVuNguoiMoNP;
	}

	/**
	 * @param string
	 */
	public void setChucVuNguoiMoNP(String string) {
		chucVuNguoiMoNP = string;
	}

	/**
	 * @return
	 */
	public String getNguoiMoNP() {
		return nguoiMoNP;
	}

	/**
	 * @param string
	 */
	public void setNguoiMoNP(String string) {
		nguoiMoNP = string;
	}

	/**
	 * @return
	 */
	public String getDinViCaNhanThucHien() {
		return dinViCaNhanThucHien;
	}

	/**
	 * @return
	 */
	public String getDonViBaoQuanSauNP() {
		return donViBaoQuanSauNP;
	}

	/**
	 * @param string
	 */
	public void setDinViCaNhanThucHien(String string) {
		dinViCaNhanThucHien = string;
	}

	/**
	 * @return
	 */
	public String getOptionTag() {
		return optionTag;
	}

	/**
	 * @param string
	 */
	public void setOptionTag(String string) {
		optionTag = string;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getDsTVD() {
		return dsTVD;
	}

	/**
	 * @param doans
	 */
	public void setDsTVD(TtktCmThanhPhanThamDu[] doans) {
		dsTVD = doans;
	}

	/**
	 * @return
	 */
	public String getIdQdNiemPhong() {
		return idQdNiemPhong;
	}

	/**
	 * @param string
	 */
	public void setIdQdNiemPhong(String string) {
		idQdNiemPhong = string;
	}

	/**
	 * @return
	 */
	public String getIdBbMoNiemPhong() {
		return idBbMoNiemPhong;
	}

	/**
	 * @return
	 */
	public String getIdBbNiemPhong() {
		return idBbNiemPhong;
	}

	/**
	 * @param string
	 */
	public void setIdBbMoNiemPhong(String string) {
		idBbMoNiemPhong = string;
	}

	/**
	 * @param string
	 */
	public void setIdBbNiemPhong(String string) {
		idBbNiemPhong = string;
	}

	/**
	 * @return
	 */
	public String getIdCuocTtkt() {
		return idCuocTtkt;
	}

	/**
	 * @param string
	 */
	public void setIdCuocTtkt(String string) {
		idCuocTtkt = string;
	}

	/**
	 * @return
	 */
	public String getTenCanBoDvCnTh() {
		return tenCanBoDvCnTh;
	}

	/**
	 * @param string
	 */
	public void setTenCanBoDvCnTh(String string) {
		tenCanBoDvCnTh = string;
	}

	/**
	 * @return
	 */
	public String getTenNguoiMoNp() {
		return tenNguoiMoNp;
	}

	/**
	 * @param string
	 */
	public void setTenNguoiMoNp(String string) {
		tenNguoiMoNp = string;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getDsDvCoTlnp() {
		return dsDvCoTlnp;
	}

	/**
	 * @param doans
	 */
	public void setDsDvCoTlnp(TtktCmThanhPhanThamDu[] doans) {
		dsDvCoTlnp = doans;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getDsCacOb() {
		return dsCacOb;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getDsTVD2() {
		return dsTVD2;
	}

	/**
	 * @param doans
	 */
	public void setDsCacOb(TtktCmThanhPhanThamDu[] doans) {
		dsCacOb = doans;
	}

	/**
	 * @param doans
	 */
	public void setDsTVD2(TtktCmThanhPhanThamDu[] doans) {
		dsTVD2 = doans;
	}

	/**
	 * @return
	 */
	public String getIdThanhPhanThamDuCacOngBaBBMNP() {
		return idThanhPhanThamDuCacOngBaBBMNP;
	}

	/**
	 * @return
	 */
	public String getIdThanhPhanThamDuCacOngBaBBNP() {
		return idThanhPhanThamDuCacOngBaBBNP;
	}

	/**
	 * @return
	 */
	public String getIdThanhPhanThamDuDoanTtktBBMNP() {
		return idThanhPhanThamDuDoanTtktBBMNP;
	}

	/**
	 * @return
	 */
	public String getIdThanhPhanThamDuDoanTtktBBNP() {
		return idThanhPhanThamDuDoanTtktBBNP;
	}

	/**
	 * @param string
	 */
	public void setIdThanhPhanThamDuCacOngBaBBMNP(String string) {
		idThanhPhanThamDuCacOngBaBBMNP = string;
	}

	/**
	 * @param string
	 */
	public void setIdThanhPhanThamDuCacOngBaBBNP(String string) {
		idThanhPhanThamDuCacOngBaBBNP = string;
	}

	/**
	 * @param string
	 */
	public void setIdThanhPhanThamDuDoanTtktBBMNP(String string) {
		idThanhPhanThamDuDoanTtktBBMNP = string;
	}

	/**
	 * @param string
	 */
	public void setIdThanhPhanThamDuDoanTtktBBNP(String string) {
		idThanhPhanThamDuDoanTtktBBNP = string;
	}

	/**
	 * @return
	 */
	public String getChucVuTrongDoanQDNP() {
		return chucVuTrongDoanQDNP;
	}

	/**
	 * @param string
	 */
	public void setChucVuTrongDoanQDNP(String string) {
		chucVuTrongDoanQDNP = string;
	}

	

	public String getIdDsTvdBbNiemPhong() {
		return idDsTvdBbNiemPhong;
	}

	public void setIdDsTvdBbNiemPhong(String idDsTvdBbNiemPhong) {
		this.idDsTvdBbNiemPhong = idDsTvdBbNiemPhong;
	}

	public String getIdDsTvdBbMoNiemPhong() {
		return idDsTvdBbMoNiemPhong;
	}

	public void setIdDsTvdBbMoNiemPhong(String idDsTvdBbMoNiemPhong) {
		this.idDsTvdBbMoNiemPhong = idDsTvdBbMoNiemPhong;
	}

	public String getIdDsTvdQdMoNiemPhong() {
		return idDsTvdQdMoNiemPhong;
	}

	public void setIdDsTvdQdMoNiemPhong(String idDsTvdQdMoNiemPhong) {
		this.idDsTvdQdMoNiemPhong = idDsTvdQdMoNiemPhong;
	}

	public String getIdDsTvdQdNiemPhong() {
		return idDsTvdQdNiemPhong;
	}

	public void setIdDsTvdQdNiemPhong(String idDsTvdQdNiemPhong) {
		this.idDsTvdQdNiemPhong = idDsTvdQdNiemPhong;
	}

	public String getIdCqtBi() {
		return idCqtBi;
	}

	public void setIdCqtBi(String idCqtBi) {
		this.idCqtBi = idCqtBi;
	}



	public String getDinViCaNhanBaoQuanBbNp() {
		return dinViCaNhanBaoQuanBbNp;
	}



	public void setDinViCaNhanBaoQuanBbNp(String dinViCaNhanBaoQuanBbNp) {
		this.dinViCaNhanBaoQuanBbNp = dinViCaNhanBaoQuanBbNp;
	}



	public String getDinViCaNhanBaoQuanQdNp() {
		return dinViCaNhanBaoQuanQdNp;
	}



	public void setDinViCaNhanBaoQuanQdNp(String dinViCaNhanBaoQuanQdNp) {
		this.dinViCaNhanBaoQuanQdNp = dinViCaNhanBaoQuanQdNp;
	}

}
