package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form;

import org.apache.struts.upload.FormFile;

import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBanGiaoHstlChoTd;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBbChitietvatonghop;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThNhatKy;
import cmc.com.ktnb.web.BaseActionForm;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */
      
public class TienHanhTtktForm extends BaseActionForm {
	// Cong bo quyet dinh
	private String idCongBoQuyetDinh;
	private String idCuocTtkt;
	private String thoiDiemCbTu;
	private String thoiDiemCbDen;
	private String idDaiDienCqBanHanhQd;
	private String ykienPhatBieu;
	private String diaDiem;
	private String idDaiDienCqqlCapTren;
	private String idDaiDienDoanTtkt;
	private String idDaiDienDonViDuocTtkt;
	private String idDonViDuocTtkt;
	private String idDonViTienHanh;	
	private String baoCao;
	private String hoSoTaiLieu;
	private String tenFile;
	
	
	
	private TtktCmThanhPhanThamDu[] arrDaiDienCqtBanHanhQD;
	private TtktCmThanhPhanThamDu[] arrDaiDienCqqlCapTren;
	private TtktCmThanhPhanThamDu[] arrDaiDienDoanTtkt;
	private TtktCmThanhPhanThamDu[] arrDaiDienDonViDuocTtkt;

	// Nhat ky thanh tra kiem tra
	private TtktThNhatKy[] arrNhatKy;
	private String ndKhac;

	// Bien ban chi tiet
	TtktThBbChitietvatonghop[] arrBienBanChiTiet;

	// Ban giao ho so tai lieu cho truong doan
	TtktThBanGiaoHstlChoTd[] arrBanGiaoHstlChoTruongDoan;

	// Du thao bien ban tong hop
	private String idDuThaoBbTongHop;
	private FormFile fileDinhKemDuThaoBbTongHop;

	// Bien ban tong hop gui don vi duoc ttkt	
	private String dvDuocTtktDongGopYkien;
	private String idBbTongHopGuiDonViDuocTtktYk;
	private FormFile ykienOfDvDcTtKt;
	
	private String idBbTongHopGuiDonViDuocTtkt;
	private FormFile fileDinhKemBbTongHopGuiDonViDuocTtkt;

	// Bien ban tong hop
	private String idBbTongHop;
	private FormFile fileDinhKemBbTongHop;




	public String getIdBbTongHopGuiDonViDuocTtktYk() {
		return idBbTongHopGuiDonViDuocTtktYk;
	}

	public void setIdBbTongHopGuiDonViDuocTtktYk(
			String idBbTongHopGuiDonViDuocTtktYk) {
		this.idBbTongHopGuiDonViDuocTtktYk = idBbTongHopGuiDonViDuocTtktYk;
	}

	public FormFile getYkienOfDvDcTtKt() {
		return ykienOfDvDcTtKt;
	}

	public void setYkienOfDvDcTtKt(FormFile ykienOfDvDcTtKt) {
		this.ykienOfDvDcTtKt = ykienOfDvDcTtKt;
	}

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
	public String getDiaDiem() {
		return diaDiem;
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
	public String getThoiDiemCbDen() {
		return thoiDiemCbDen;
	}

	/**
	 * @return
	 */
	public String getThoiDiemCbTu() {
		return thoiDiemCbTu;
	}

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
	public void setDiaDiem(String string) {
		diaDiem = string;
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
	public void setThoiDiemCbDen(String string) {
		thoiDiemCbDen = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemCbTu(String string) {
		thoiDiemCbTu = string;
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
	public TtktThBanGiaoHstlChoTd[] getArrBanGiaoHstlChoTruongDoan() {
		return arrBanGiaoHstlChoTruongDoan;
	}

	/**
	 * @return
	 */
	public TtktThBbChitietvatonghop[] getArrBienBanChiTiet() {
		return arrBienBanChiTiet;
	}

	/**
	 * @return
	 */
	public TtktThNhatKy[] getArrNhatKy() {
		return arrNhatKy;
	}

	/**
	 * @param tds
	 */
	public void setArrBanGiaoHstlChoTruongDoan(TtktThBanGiaoHstlChoTd[] tds) {
		arrBanGiaoHstlChoTruongDoan = tds;
	}

	/**
	 * @param chitietvatonghops
	 */
	public void setArrBienBanChiTiet(TtktThBbChitietvatonghop[] chitietvatonghops) {
		arrBienBanChiTiet = chitietvatonghops;
	}

	/**
	 * @param kies
	 */
	public void setArrNhatKy(TtktThNhatKy[] kies) {
		arrNhatKy = kies;
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
	public String getHoSoTaiLieu() {
		return hoSoTaiLieu;
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
	public void setHoSoTaiLieu(String string) {
		hoSoTaiLieu = string;
	}

	/**
	 * @return
	 */
	public String getIdBbTongHop() {
		return idBbTongHop;
	}

	/**
	 * @param string
	 */
	public void setIdBbTongHop(String string) {
		idBbTongHop = string;
	}

	/**
	 * @return
	 */
	public FormFile getFileDinhKemBbTongHop() {
		return fileDinhKemBbTongHop;
	}

	/**
	 * @param file
	 */
	public void setFileDinhKemBbTongHop(FormFile file) {
		fileDinhKemBbTongHop = file;
	}

	/**
	 * @return
	 */
	public FormFile getFileDinhKemDuThaoBbTongHop() {
		return fileDinhKemDuThaoBbTongHop;
	}

	/**
	 * @return
	 */
	public String getIdDuThaoBbTongHop() {
		return idDuThaoBbTongHop;
	}

	/**
	 * @param file
	 */
	public void setFileDinhKemDuThaoBbTongHop(FormFile file) {
		fileDinhKemDuThaoBbTongHop = file;
	}

	/**
	 * @param string
	 */
	public void setIdDuThaoBbTongHop(String string) {
		idDuThaoBbTongHop = string;
	}

	/**
	 * @return
	 */
	public FormFile getFileDinhKemBbTongHopGuiDonViDuocTtkt() {
		return fileDinhKemBbTongHopGuiDonViDuocTtkt;
	}

	/**
	 * @return
	 */
	public String getIdBbTongHopGuiDonViDuocTtkt() {
		return idBbTongHopGuiDonViDuocTtkt;
	}

	/**
	 * @param file
	 */
	public void setFileDinhKemBbTongHopGuiDonViDuocTtkt(FormFile file) {
		fileDinhKemBbTongHopGuiDonViDuocTtkt = file;
	}

	/**
	 * @param string
	 */
	public void setIdBbTongHopGuiDonViDuocTtkt(String string) {
		idBbTongHopGuiDonViDuocTtkt = string;
	}

	public String getDvDuocTtktDongGopYkien() {
		return dvDuocTtktDongGopYkien;
	}

	public void setDvDuocTtktDongGopYkien(String dvDuocTtktDongGopYkien) {
		this.dvDuocTtktDongGopYkien = dvDuocTtktDongGopYkien;
	}

	public String getNdKhac() {
		return ndKhac;
	}

	public void setNdKhac(String ndKhac) {
		this.ndKhac = ndKhac;
	}
	private String maCuocTtkt;




	public String getMaCuocTtkt() {
		return maCuocTtkt;
	}

	public void setMaCuocTtkt(String maCuocTtkt) {
		this.maCuocTtkt = maCuocTtkt;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	

}