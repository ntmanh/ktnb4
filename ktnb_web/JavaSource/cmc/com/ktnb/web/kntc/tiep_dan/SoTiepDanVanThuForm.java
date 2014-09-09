package cmc.com.ktnb.web.kntc.tiep_dan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.pl.hb.entity.KtnbDmCanbo;
import cmc.com.ktnb.pl.hb.entity.KtnbTlieuKemTheo;
import cmc.com.ktnb.service.kntc.KntcSoTiepDan;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.web.catalog.CatalogService;

/**
 * Form sổ tiếp dân văn thư
 * 
 * @author Ntthu Created on Nov 2, 2010
 */
public class SoTiepDanVanThuForm extends BaseSoTiepDanForm {
	private String soCongVanDen;

	private String ngayNhanCongVan;

	private String ngayNhanCongVanVT;

	private String donViNhanCongVan;

	private String soKyHieuCV;

	private String donTrichYeu;

	private String ghiChu;

	private String uyQuyen;

	private String loaiHoSo, kenhNhanTin; // Qua van thu, qua duong day nong		
	private String trangThaiText;
	
	// private String trangThai;
	public KntcSoTiepDan toSoTiepDan(ApplicationContext appContext) throws Exception {
		// Thong tin chung
		KntcHoSoHdr hdr = new KntcHoSoHdr();
		hdr.setMa(this.getMaHidden());
		hdr.setLoaiHs(new Long(2));
		hdr.setMaHs(this.maHoSo);
		hdr.setCongVanDenDv(this.donViNhanCongVan);
		hdr.setCongVanDenMa(this.soCongVanDen);
		hdr.setCongVanDenNgay(Formater.str2time(this.ngayNhanCongVan));
		hdr.setCongVanDenNgayVT(Formater.str2time(this.ngayNhanCongVanVT));
		hdr.setNndMaCongVan(this.soKyHieuCV);
		hdr.setNndDiaChi(this.congdanDiaChi);
		hdr.setDonTrichYeu(this.donTrichYeu);
		hdr.setMaCanBo(appContext.getMaCanbo());
		//hdr.setTrangThai(this.trangThaiText);
		// hdr.setNgayTiep(Formater.str2time(this.donDeNgay));
		hdr.setDonDeNgay(Formater.str2date(this.donDeNgay));
		hdr.setNndMa(this.congdanMa);
		hdr.setNndTen(this.congdanTen);
		hdr.setNndChucVu(this.congdanChucVu);
		hdr.setNndNoiCongTac(this.congdanNoiCongTac);
		hdr.setNndDienThoai(this.congdanDienThoai);
		hdr.setNndCmtHc(this.congdanCMT);
		hdr.setNndCmtNgayCap(Formater.str2date(this.congdanCMTNgayCap));
		hdr.setNndCmtNoiCap(this.congdanCMTNoiCap);
		hdr.setNndMst(this.congdanMST);
		hdr.setNgayCapNhat(new Date());
		hdr.setNguoiCapNhat(appContext.getTenNsd());
		hdr.setLoaiKntc(new Long(this.loaiKNTC));
		// hdr.setLoaiUq(new Long(this.uyQuyen));
		hdr.setMaCqt(appContext.getMaCqt());
		hdr.setTenCqt(appContext.getTenCqt());
		// Luat su
		hdr.setLuatSuMa(this.luatsuMa);
		hdr.setLuatSuTen(this.luatsuTen);
		hdr.setLsHdMa(this.luatsuHDMa);
		hdr.setLsHdNoiDung(this.luatsuHDNoiDung);
		hdr.setLsGiayGthieu(this.luatsuSoGiayGT);
		hdr.setTrangThai(Constants.TT_KNTC_PHAN_LOAI_DX_XLY);
		if (this.boSungTaiLieu != null) {
			hdr.setTrangThai(Constants.TT_KNTC_BO_SUNG_HO_SO);
		}
		hdr.setDuongDayNong(this.kenhNhanTin);
		KntcSoTiepDan std = new KntcSoTiepDan(hdr);
		// Thong tin Don
		// KntcNdungDon hdr = new KntcNdungDon();
		// hdr.setMaDon(this.soDon);
		hdr.setMaHs(this.maHoSo);
		hdr.setGhiChu(this.ghiChu);
		// hdr.setNgayLap(new Date());
		hdr.setNguoiBiKntcMa(this.canBoBiKNTCMa);
		hdr.setNguoiBiKntcTen(this.canBoBiKNTCTen);
		hdr.setNguoiBiKntcCv(this.canBoBiKNTCChucVu);
		hdr.setNguoiBiKntcDc(this.canBoBiKNTCDiaChi);
		hdr.setNguoiBiKntcNoiCt(this.canBoBiKNTCNoiCongTac);
		hdr.setNoiDung(this.noiDungDon);
		hdr.setSoDon(this.soDon);
		// hdr.setThamQuyen(this.loaiDonKNTC);
		// hdr.setThuLy(this.loaiThuLy);
		if (this.boSungTaiLieu != null)
			hdr.setBoSungTl(new Long(this.boSungTaiLieu));
		// std.setNoiDungDon(hdr);
		// Thong tin tai lieu kem theo
		String[] arrCb = this.arrTenTl.split("@@");
		if (arrCb != null && arrCb.length > 0) {
			for (int i = 0; i < arrCb.length; i++) {
				String[] item = arrCb[i].split("###");
				if (item != null && item.length > 0) {
					if (!Formater.isNull(item[0])) {
						KtnbTlieuKemTheo aCb = new KtnbTlieuKemTheo();
						aCb.setMaHoSo(this.maHoSo);
						aCb.setLoaiTlieu(KtnbTlieuKemTheo.TLKT_SO_TIEP_DAN);
						if (!Formater.isNull(item[1]))
							aCb.setSoTrang(new Short(item[1]));
						else
							aCb.setSoTrang(new Short("0"));
						aCb.setTenTlieu(item[0]);
						aCb.setTinhTrang(item[2]);
						// aCb.setChungCu(item[3]);
						aCb.setNguoiCapNhat(appContext.getTenNsd());
						aCb.setNgayCapNhat(appContext.getSystemDate());
						std.addTailieu(aCb);
					}
				}
			}
		}
		return std;
	}

	public void toForm(KntcSoTiepDan hoso) throws Exception {
		// Thong tin chung
		KntcHoSoHdr hdr = hoso.getHdr();
		this.maHidden = hdr.getMa();
		this.maHoSo = hdr.getMaHs();
		this.ngayTiep = Formater.date2str(hdr.getNgayTiep());
		this.congdanMa = hdr.getNndMa();
		this.congdanTen = hdr.getNndTen();
		this.congdanChucVu = hdr.getNndChucVu();
		this.congdanDiaChi = hdr.getNndDiaChi();
		this.congdanDienThoai = hdr.getNndDienThoai();
		this.congdanCMT = hdr.getNndCmtHc();
		this.congdanCMTNgayCap = Formater.date2str(hdr.getNndCmtNgayCap());
		this.donDeNgay = Formater.date2str(hdr.getDonDeNgay());
		this.congdanCMTNoiCap = hdr.getNndCmtNoiCap();
		this.congdanMST = hdr.getNndMst();
		this.congdanNoiCongTac = hdr.getNndNoiCongTac();
		KtnbDmCanbo cb = KtnbUtil.getThongTinCanBo(hdr.getMaCanBo());
		this.canBoMa = cb.getMa();
		this.canBoChucVu = cb.getChucVu();
		this.canBoNoiCongTac = cb.getTenPhong() + ", " + cb.getTenCqt();
		this.canBoTen = cb.getTen();
		this.noiTiepDan = cb.getTenCqt();
		this.loaiKNTC = String.valueOf(hdr.getLoaiKntc());
		this.trangThaiText = hdr.getTrangThaiText();
		
		this.soCongVanDen = hdr.getCongVanDenMa();
		this.ngayNhanCongVan = Formater.date2str(hdr.getCongVanDenNgay());
		this.ngayNhanCongVanVT = Formater.date2str(hdr.getCongVanDenNgayVT());
		this.donViNhanCongVan = hdr.getCongVanDenDv();
		// Uy quyen
		this.uyQuyen = String.valueOf(hdr.getLoaiUq());

		// Luat su
		this.luatsuMa = hdr.getLuatSuMa();
		this.luatsuTen = hdr.getLuatSuTen();
		this.luatsuHDMa = hdr.getLsHdMa();
		this.luatsuHDNoiDung = hdr.getLsHdNoiDung();
		this.luatsuSoGiayGT = hdr.getLsGiayGthieu();

		// Thong tin Don
		// KntcNdungDon hdr = hoso.getNoiDungDon();
		this.soDon = hdr.getSoDon();
		this.maHoSo = hdr.getMaHs();
		this.ghiChu = hdr.getGhiChu();
		// this.ngayLap = Formater.date2str(hdr.getNgayLap());
		this.canBoBiKNTCTen = hdr.getNguoiBiKntcTen();
		this.canBoBiKNTCChucVu = hdr.getNguoiBiKntcCv();
		this.canBoBiKNTCDiaChi = hdr.getNguoiBiKntcDc();
		this.canBoBiKNTCNoiCongTac = hdr.getNguoiBiKntcNoiCt();
		this.noiDungDon = hdr.getNoiDung();
		// this.loaiDonKNTC = hdr.getThamQuyen();
		// this.loaiThuLy = hdr.getThuLy();
		this.boSungTaiLieu = String.valueOf(hdr.getBoSungTl());
		this.ttHoSo = CatalogService.getTenDanhMucById(hdr.getTrangThai());
		
		SoTiepDanService s = new SoTiepDanService();
		
		this.maHoSoChuyen = s.getMaHoSoByMaCha(hdr.getMaHs(), SoTiepDanService.HO_SO_CHUYEN);
		this.maHoSoTachKN = s.getMaHoSoByMaCha(hdr.getMaHs(), SoTiepDanService.HO_SO_TACH_KN);
		this.maHoSoTachTC = s.getMaHoSoByMaCha(hdr.getMaHs(), SoTiepDanService.HO_SO_TACH_TC);
	}

	/**
	 * @return
	 */
	public String getDonTrichYeu() {
		return donTrichYeu;
	}

	/**
	 * @return
	 */
	public String getDonViNhanCongVan() {
		return donViNhanCongVan;
	}

	/**
	 * @return
	 */
	public String getGhiChu() {
		return ghiChu;
	}

	/**
	 * @return
	 */
	public String getNgayNhanCongVan() {
		return ngayNhanCongVan;
	}

	/**
	 * @return
	 */
	public String getSoCongVanDen() {
		return soCongVanDen;
	}

	/**
	 * @return
	 */
	public String getSoKyHieuCV() {
		return soKyHieuCV;
	}

	/**
	 * @param string
	 */
	public void setDonTrichYeu(String string) {
		donTrichYeu = string;
	}

	/**
	 * @param string
	 */
	public void setDonViNhanCongVan(String string) {
		donViNhanCongVan = string;
	}

	/**
	 * @param string
	 */
	public void setGhiChu(String string) {
		ghiChu = string;
	}

	/**
	 * @param string
	 */
	public void setNgayNhanCongVan(String string) {
		ngayNhanCongVan = string;
	}

	/**
	 * @param string
	 */
	public void setSoCongVanDen(String string) {
		soCongVanDen = string;
	}

	/**
	 * @param string
	 */
	public void setSoKyHieuCV(String string) {
		soKyHieuCV = string;
	}

	/**
	 * @return
	 */
	public String getUyQuyen() {
		return uyQuyen;
	}

	/**
	 * @param string
	 */
	public void setUyQuyen(String string) {
		uyQuyen = string;
	}

	/**
	 * @return
	 */
	public String getLoaiHoSo() {
		return loaiHoSo;
	}

	/**
	 * @param string
	 */
	public void setLoaiHoSo(String string) {
		loaiHoSo = string;
	}

	public String getKenhNhanTin() {
		return kenhNhanTin;
	}

	public void setKenhNhanTin(String kenhNhanTin) {
		this.kenhNhanTin = kenhNhanTin;
	}

	public String getNgayNhanCongVanVT() {
		return ngayNhanCongVanVT;
	}

	public void setNgayNhanCongVanVT(String ngayNhanCongVanVT) {
		this.ngayNhanCongVanVT = ngayNhanCongVanVT;
	}

	public String getTrangThaiText() {
		return trangThaiText;
	}

	public void setTrangThaiText(String trangThai) {
		this.trangThaiText = trangThai;
	}

}
