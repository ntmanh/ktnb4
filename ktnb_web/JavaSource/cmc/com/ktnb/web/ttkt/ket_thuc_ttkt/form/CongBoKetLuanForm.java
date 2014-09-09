package cmc.com.ktnb.web.ttkt.ket_thuc_ttkt.form;

import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.web.BaseActionForm;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */
public class CongBoKetLuanForm extends BaseActionForm {
	private String idCongBoQuyetDinh;
	private String idCuocTtkt;
	private String ngayLap;
	private String noiLap;
	private String thoiDiemCongBo;
	private String thoiDiemKetThuc;
	private String idDaiDienCqBanHanhQd;
	//ykien co quan tien hanh ttkt
	private String ykienPhatBieu;
	private String ykCqqlCapTrenCuaDtuong;
	private String ykDaiDienCqtBiTtkt;
	private String diaDiem;
	private String idDaiDienCqqlCapTren;
	private String idDaiDienDoanTtkt;
	private String idDaiDienDonViDuocTtkt;
	private String idDonViDuocTtkt;
	private String idDonViTienHanh;
	private String baoCao;
	private String hoSoTaiLieu;

	private TtktCmThanhPhanThamDu[] arrDaiDienCqtBanHanhQD;
	private TtktCmThanhPhanThamDu[] arrDaiDienCqqlCapTren;
	private TtktCmThanhPhanThamDu[] arrDaiDienDoanTtkt;
	private TtktCmThanhPhanThamDu[] arrDaiDienDonViDuocTtkt;
	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getArrDaiDienCqqlCapTren() {
		return arrDaiDienCqqlCapTren;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getArrDaiDienCqtBanHanhQD() {
		return arrDaiDienCqtBanHanhQD;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getArrDaiDienDoanTtkt() {
		return arrDaiDienDoanTtkt;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getArrDaiDienDonViDuocTtkt() {
		return arrDaiDienDonViDuocTtkt;
	}

	/**
	 * @return
	 */
	public String getBaoCao() {
		return baoCao;
	}

	/**
	 * @return
	 */
	public String getDiaDiem() {
		return diaDiem;
	}

	/**
	 * @return
	 */
	public String getHoSoTaiLieu() {
		return hoSoTaiLieu;
	}

	/**
	 * @return
	 */
	public String getIdCongBoQuyetDinh() {
		return idCongBoQuyetDinh;
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
	public String getIdDaiDienCqBanHanhQd() {
		return idDaiDienCqBanHanhQd;
	}

	/**
	 * @return
	 */
	public String getIdDaiDienCqqlCapTren() {
		return idDaiDienCqqlCapTren;
	}

	/**
	 * @return
	 */
	public String getIdDaiDienDoanTtkt() {
		return idDaiDienDoanTtkt;
	}

	/**
	 * @return
	 */
	public String getIdDaiDienDonViDuocTtkt() {
		return idDaiDienDonViDuocTtkt;
	}

	/**
	 * @return
	 */
	public String getIdDonViDuocTtkt() {
		return idDonViDuocTtkt;
	}

	/**
	 * @return
	 */
	public String getIdDonViTienHanh() {
		return idDonViTienHanh;
	}

	/**
	 * @return
	 */


	/**
	 * @return
	 */
	public String getYkienPhatBieu() {
		return ykienPhatBieu;
	}

	/**
	 * @param dus
	 */
	public void setArrDaiDienCqqlCapTren(TtktCmThanhPhanThamDu[] dus) {
		arrDaiDienCqqlCapTren = dus;
	}

	/**
	 * @param dus
	 */
	public void setArrDaiDienCqtBanHanhQD(TtktCmThanhPhanThamDu[] dus) {
		arrDaiDienCqtBanHanhQD = dus;
	}

	/**
	 * @param dus
	 */
	public void setArrDaiDienDoanTtkt(TtktCmThanhPhanThamDu[] dus) {
		arrDaiDienDoanTtkt = dus;
	}

	/**
	 * @param dus
	 */
	public void setArrDaiDienDonViDuocTtkt(TtktCmThanhPhanThamDu[] dus) {
		arrDaiDienDonViDuocTtkt = dus;
	}

	/**
	 * @param string
	 */
	public void setBaoCao(String string) {
		baoCao = string;
	}

	/**
	 * @param string
	 */
	public void setDiaDiem(String string) {
		diaDiem = string;
	}

	/**
	 * @param string
	 */
	public void setHoSoTaiLieu(String string) {
		hoSoTaiLieu = string;
	}

	/**
	 * @param string
	 */
	public void setIdCongBoQuyetDinh(String string) {
		idCongBoQuyetDinh = string;
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
	public void setIdDaiDienCqBanHanhQd(String string) {
		idDaiDienCqBanHanhQd = string;
	}

	/**
	 * @param string
	 */
	public void setIdDaiDienCqqlCapTren(String string) {
		idDaiDienCqqlCapTren = string;
	}

	/**
	 * @param string
	 */
	public void setIdDaiDienDoanTtkt(String string) {
		idDaiDienDoanTtkt = string;
	}

	/**
	 * @param string
	 */
	public void setIdDaiDienDonViDuocTtkt(String string) {
		idDaiDienDonViDuocTtkt = string;
	}

	/**
	 * @param string
	 */
	public void setIdDonViDuocTtkt(String string) {
		idDonViDuocTtkt = string;
	}

	/**
	 * @param string
	 */
	public void setIdDonViTienHanh(String string) {
		idDonViTienHanh = string;
	}



	/**
	 * @param string
	 */
	public void setYkienPhatBieu(String string) {
		ykienPhatBieu = string;
	}

	/**
	 * @return
	 */
	public String getYkCqqlCapTrenCuaDtuong() {
		return ykCqqlCapTrenCuaDtuong;
	}

	/**
	 * @return
	 */
	public String getYkDaiDienCqtBiTtkt() {
		return ykDaiDienCqtBiTtkt;
	}

	/**
	 * @param string
	 */
	public void setYkCqqlCapTrenCuaDtuong(String string) {
		ykCqqlCapTrenCuaDtuong = string;
	}

	/**
	 * @param string
	 */
	public void setYkDaiDienCqtBiTtkt(String string) {
		ykDaiDienCqtBiTtkt = string;
	}

	/**
	 * @return
	 */
	public String getNgayLap() {
		return ngayLap;
	}

	/**
	 * @return
	 */
	public String getNoiLap() {
		return noiLap;
	}

	/**
	 * @return
	 */
	public String getThoiDiemCongBo() {
		return thoiDiemCongBo;
	}

	/**
	 * @param string
	 */
	public void setNgayLap(String string) {
		ngayLap = string;
	}

	/**
	 * @param string
	 */
	public void setNoiLap(String string) {
		noiLap = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemCongBo(String string) {
		thoiDiemCongBo = string;
	}

	/**
	 * @return
	 */
	public String getThoiDiemKetThuc() {
		return thoiDiemKetThuc;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemKetThuc(String string) {
		thoiDiemKetThuc = string;
	}

}
