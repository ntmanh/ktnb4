package cmc.com.ktnb.web.kntc.tiep_dan;
import cmc.com.ktnb.web.BaseActionForm;
/**
 * Form phiếu hẹn
 * @author DoHongPhuc
 * Created on Nov 5, 2010
 */
public class PhieuHenForm extends BaseActionForm {

	// Thong tin Ho so
	private String maHoSo;
	private String maPhieuHen;
	private String ngayLapPhieu;
	
	private String thoiDiemHen;
	private String diaDiemHen;
	private String mucDichHen;
	private String canBoLapPhieuTen,canBoLapPhieuCV,canBoLapPhieuDV;
	private String nguoiNhanPhieuTen,nguoiNhanPhieuDC;
	
	/**
	 * @return
	 */
	public String getMaPhieuHen() {
		return maPhieuHen;
	}

	/**
	 * @param string
	 */
	public void setMaPhieuHen(String string) {
		maPhieuHen = string;
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
	public String getDiaDiemHen() {
		return diaDiemHen;
	}

	/**
	 * @return
	 */
	public String getMucDichHen() {
		return mucDichHen;
	}

	/**
	 * @return
	 */
	public String getThoiDiemHen() {
		return thoiDiemHen;
	}

	/**
	 * @param string
	 */
	public void setDiaDiemHen(String string) {
		diaDiemHen = string;
	}

	/**
	 * @param string
	 */
	public void setMucDichHen(String string) {
		mucDichHen = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemHen(String string) {
		thoiDiemHen = string;
	}

	/**
	 * @return
	 */
	public String getNgayLapPhieu() {
		return ngayLapPhieu;
	}

	/**
	 * @param string
	 */
	public void setNgayLapPhieu(String string) {
		ngayLapPhieu = string;
	}

	public String getCanBoLapPhieuCV() {
		return canBoLapPhieuCV;
	}

	public void setCanBoLapPhieuCV(String canBoLapPhieuCV) {
		this.canBoLapPhieuCV = canBoLapPhieuCV;
	}

	public String getCanBoLapPhieuDV() {
		return canBoLapPhieuDV;
	}

	public void setCanBoLapPhieuDV(String canBoLapPhieuDV) {
		this.canBoLapPhieuDV = canBoLapPhieuDV;
	}

	public String getCanBoLapPhieuTen() {
		return canBoLapPhieuTen;
	}

	public void setCanBoLapPhieuTen(String canBoLapPhieuTen) {
		this.canBoLapPhieuTen = canBoLapPhieuTen;
	}

	public String getNguoiNhanPhieuDC() {
		return nguoiNhanPhieuDC;
	}

	public void setNguoiNhanPhieuDC(String nguoiNhanPhieuDC) {
		this.nguoiNhanPhieuDC = nguoiNhanPhieuDC;
	}

	public String getNguoiNhanPhieuTen() {
		return nguoiNhanPhieuTen;
	}

	public void setNguoiNhanPhieuTen(String nguoiNhanPhieuTen) {
		this.nguoiNhanPhieuTen = nguoiNhanPhieuTen;
	}

}
