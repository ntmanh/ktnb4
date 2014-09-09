package cmc.com.ktnb.web.kntc.tiep_dan;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.pl.hb.entity.KtnbDmCanbo;
import cmc.com.ktnb.pl.hb.entity.KtnbTlieuKemTheo;
import cmc.com.ktnb.service.kntc.KntcSoTiepDan;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.URLUTF8Encoder;
import cmc.com.ktnb.web.catalog.CatalogService;

/**
 * Form sổ tiếp dân
 * @author Ntthu Created on Nov 2, 2010
 */
public class SoTiepDanForm extends BaseSoTiepDanForm {
	private String uyQuyen;
	private String isDaGiaiQuyet;
	private String maHoSoDaGiaiQuyet;
	private String daGiaiQuyetNoiDungMoi;
	// Thong tin Uy Quyen
	private String nuqMa;
	private String nuqTen;
	private String nuqNoiCongTac;
	private String nuqChucVu;
	private String nuqDiaChi;
	private String nuqCMT;// CMT cho ca nhan, MST cho To Chuc
	private String nuqDienThoai;
	private String nuqCMTNoiCap;
	private String nuqCMTNgayCap;
	private String guqTuNgay;
	private String guqDenNgay;
	private String guqNoiDung;
	private String guqNgayXacNhan;
	private String guqNuqTen;
	private String guqNuqChucVu;
	private String nuqFAX;
	private String hinhThuc; // Tiep dinh ky, dot xuat cua lanh dao
	private String gayRoi;
	private String doanKNTC;
	private String doanKNTCSoLuong;
	private String ngayNhanVT;

	private String soCVDenVT;
	private String ngayNhanXL;
	private String luotTiep;
	private String trangThaiText;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}

	public KntcSoTiepDan toSoTiepDan(ApplicationContext appContext) throws Exception {
		// Thong tin chung
		KntcHoSoHdr hdr = new KntcHoSoHdr();
		hdr.setNgayCapNhat(new Date());
		hdr.setNguoiCapNhat(appContext.getTenNsd());
		hdr.setMa(this.getMaHidden());
		hdr.setDoanKntc(new Long(this.doanKNTC));
		if (this.doanKNTC != null && !this.doanKNTC.equals("1")) {
			if (!Formater.isNull(this.doanKNTCSoLuong))
				hdr.setDoanKntcSoLuong(new Long(this.doanKNTCSoLuong));
		}
		hdr.setLoaiHs(new Long(1));
		hdr.setGayRoi(new Long(this.gayRoi));
		hdr.setHinhThuc(new Long(this.hinhThuc));
		if (!Formater.isNull(this.hinhThuc)) {
			if (this.hinhThuc.equals("1")) // Dinh ky
			{
				hdr.setHinhThucDk(new Long(1));
				hdr.setHinhThucDx(new Long(0));
			} else if (this.hinhThuc.equals("2")) // Dot xuat
			{
				hdr.setHinhThucDx(new Long(1));
				hdr.setHinhThucDk(new Long(0));
			}
		}
		hdr.setMaHs(this.maHoSo);
		hdr.setNgayTiep(Formater.str2time(this.ngayTiep));
		hdr.setDonDeNgay(Formater.str2time(this.donDeNgay));
		hdr.setNndMa(this.congdanMa);
		hdr.setNndTen(this.congdanTen);
		hdr.setNndChucVu(this.congdanChucVu);
		hdr.setNndDiaChi(this.congdanDiaChi);
		hdr.setNndDienThoai(this.congdanDienThoai);
		hdr.setNndCmtHc(this.congdanCMT);
		hdr.setNndCmtNgayCap(Formater.str2date(this.congdanCMTNgayCap));
		hdr.setNndCmtNoiCap(this.congdanCMTNoiCap);
		hdr.setNndMst(this.congdanMST);
		hdr.setNndNoiCongTac(this.congdanNoiCongTac);
		hdr.setMaCanBo(this.canBoMa);
		hdr.setLoaiKntc(new Long(this.loaiKNTC));
		if (!Formater.isNull(this.uyQuyen))
			hdr.setLoaiUq(new Long(this.uyQuyen));
		hdr.setHsDaGqMa(this.maHoSoDaGiaiQuyet);
		hdr.setHsDaGqNdungMoi(this.daGiaiQuyetNoiDungMoi);
		hdr.setMaCqt(appContext.getMaCqt());
		hdr.setTenCqt(appContext.getTenCqt());
		if (!Formater.isNull(this.luotTiep))
			hdr.setLanTiep(new Long(this.luotTiep));
		// Uy quyen
		hdr.setNuqMa(this.nuqMa);
		hdr.setNuqTen(this.nuqTen);
		hdr.setNuqChucVu(this.nuqChucVu);
		hdr.setNuqCquan(this.nuqNoiCongTac);
		hdr.setNuqDiaChi(this.nuqDiaChi);
		hdr.setNuqNgayXacNhan(Formater.str2date(this.guqNgayXacNhan));
		hdr.setGuqTuNgay(Formater.str2date(this.guqTuNgay));
		hdr.setGuqDenNgay(Formater.str2date(this.guqDenNgay));
		hdr.setGuqNguoiUq(this.guqNuqTen);
		hdr.setGuqNuqChucVu(this.guqNuqChucVu);
		hdr.setGuqNoiDung(this.guqNoiDung);
		// Luat su
		hdr.setLuatSuMa(this.getLuatsuMa());
		hdr.setLuatSuTen(this.getLuatsuTen());
		hdr.setLsHdMa(this.getLuatsuHDMa());
		hdr.setLsHdNoiDung(this.getLuatsuHDNoiDung());
		hdr.setLsGiayGthieu(this.getLuatsuSoGiayGT());

		hdr.setTrangThai(Constants.TT_KNTC_CHO_CHUYEN_HS);
		if (this.boSungTaiLieu != null) {
			hdr.setTrangThai(Constants.TT_KNTC_BO_SUNG_HO_SO);
		}
		
		if (this.boSungTaiLieu != null) {
			hdr.setBoSungTl(new Long(this.boSungTaiLieu));
		}
		hdr.setSoDon(this.soDon);
		hdr.setNguoiBiKntcMa(this.canBoBiKNTCMa);
		hdr.setNguoiBiKntcTen(this.canBoBiKNTCTen);
		hdr.setNguoiBiKntcCv(this.canBoBiKNTCChucVu);
		hdr.setNguoiBiKntcDc(this.canBoBiKNTCDiaChi);
		hdr.setNguoiBiKntcNoiCt(this.canBoBiKNTCNoiCongTac);
		hdr.setNoiDung(this.noiDungDon);
		hdr.setGhiChu(this.getGhiChu());
		KntcSoTiepDan hoso = new KntcSoTiepDan(hdr);
		if (!Formater.isNull(this.arrTenTl)) {
			String[] arrCb = this.arrTenTl.split("@@");
			if (arrCb != null && arrCb.length > 0) {
				for (int i = 0; i < arrCb.length; i++) {
					String[] item = arrCb[i].split("###");
					if (item != null && item.length > 0) {
						if (!Formater.isNull(item[0])) {
							KtnbTlieuKemTheo aTl = new KtnbTlieuKemTheo();
							aTl.setMaHoSo(this.maHoSo);
							aTl.setLoaiTlieu(KtnbTlieuKemTheo.TLKT_SO_TIEP_DAN);
							if (!Formater.isNull(item[1]))
								aTl.setSoTrang(new Short(item[1]));
							else
								aTl.setSoTrang(new Short("0"));
							aTl.setTenTlieu(item[0]);
							aTl.setTinhTrang(item[2]);
							// aCb.setChungCu(item[3]);
							aTl.setNguoiCapNhat(appContext.getTenNsd());
							aTl.setNgayCapNhat(appContext.getSystemDate());
							hoso.addTailieu(aTl);
						}
					}
				}
			}
		}
		return hoso;
	}

	public String getMaHsEncode() {
		return URLUTF8Encoder.encode(this.maHoSo);
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
		this.maHoSoDaGiaiQuyet = hdr.getHsDaGqMa();
		this.daGiaiQuyetNoiDungMoi = hdr.getHsDaGqNdungMoi();
		this.luotTiep = String.valueOf(hdr.getLanTiep());

		this.hinhThuc = String.valueOf(hdr.getHinhThuc());
		this.gayRoi = String.valueOf(hdr.getGayRoi());
		this.doanKNTC = String.valueOf(hdr.getDoanKntc());
		this.doanKNTCSoLuong = String.valueOf(hdr.getDoanKntcSoLuong());
		// Uy quyen
		this.uyQuyen = String.valueOf(hdr.getLoaiUq());
		this.nuqTen = hdr.getNuqTen();
		this.nuqChucVu = hdr.getNuqChucVu();
		this.nuqCMT = hdr.getNuqTen();
		this.nuqCMTNgayCap = hdr.getNuqTen();
		this.nuqCMTNoiCap = hdr.getNuqTen();
		this.nuqDiaChi = hdr.getNuqTen();
		this.nuqDienThoai = hdr.getNuqTen();
		this.nuqFAX = hdr.getNuqTen();
		this.nuqNoiCongTac = hdr.getNuqCquan();
		this.guqNgayXacNhan = Formater.date2str(hdr.getNuqNgayXacNhan());
		this.guqTuNgay = Formater.date2str(hdr.getGuqTuNgay());
		this.guqDenNgay = Formater.date2str(hdr.getGuqDenNgay());
		this.guqNuqTen = hdr.getGuqNguoiUq();
		this.guqNuqChucVu = hdr.getGuqNuqChucVu();
		this.guqNoiDung = hdr.getGuqNoiDung();
		// Luat su
		this.luatsuMa = hdr.getLuatSuMa();
		this.luatsuTen = hdr.getLuatSuTen();
		this.luatsuHDMa = hdr.getLsHdMa();
		this.luatsuHDNoiDung = hdr.getLsHdNoiDung();
		this.luatsuSoGiayGT = hdr.getLsGiayGthieu();

		this.ngayNhanVT = Formater.date2str(hdr.getCongVanDenNgayVT());
		this.ngayNhanXL = Formater.date2str(hdr.getCongVanDenNgay());
		this.soCVDenVT = hdr.getCongVanDenMa();

		// Thong tin Don
		// KntcNdungDon hdr = hoso.getNoiDungDon();
		this.soDon = hdr.getSoDon();
		this.maHoSo = hdr.getMaHs();
		this.setGhiChu(hdr.getGhiChu());
		this.donDeNgay = Formater.date2str(hdr.getDonDeNgay());
		this.canBoBiKNTCTen = hdr.getNguoiBiKntcTen();
		this.canBoBiKNTCChucVu = hdr.getNguoiBiKntcCv();
		this.canBoBiKNTCDiaChi = hdr.getNguoiBiKntcDc();
		this.canBoBiKNTCNoiCongTac = hdr.getNguoiBiKntcNoiCt();
		this.noiDungDon = hdr.getNoiDung();
		// this.loaiDonKNTC = hdr.getThamQuyen();
		// this.loaiThuLy = hdr.getThuLy();
		this.boSungTaiLieu = String.valueOf(hdr.getBoSungTl());
		this.ttHoSo = CatalogService.getTenDanhMucById(hdr.getTrangThai());

		// Thong tin tai lieu kem theo
		// ArrayList tlkt = hoso.getListTailieu();
		SoTiepDanService s = new SoTiepDanService();
		
		this.maHoSoChuyen = s.getMaHoSoByMaCha(hdr.getMaHs(), SoTiepDanService.HO_SO_CHUYEN);
		this.maHoSoTachKN = s.getMaHoSoByMaCha(hdr.getMaHs(), SoTiepDanService.HO_SO_TACH_KN);
		this.maHoSoTachTC = s.getMaHoSoByMaCha(hdr.getMaHs(), SoTiepDanService.HO_SO_TACH_TC);
		this.trangThaiText = hdr.getTrangThaiText();
	}

	public String getLoaiDon() {
		if (this.getLoaiKNTC().equals("1"))
			return "Khi\u1EBFu n\u1EA1i";
		else if (this.getLoaiKNTC().equals("2"))
			return "T\u1ED1 c\u00E1o";
		else if (this.getLoaiKNTC().equals("3"))
			return "H\u1ED7n h\u1EE3p";
		else
			return "";
	}

	/**
	 * @return
	 */
	public String getDaGiaiQuyetNoiDungMoi() {
		return daGiaiQuyetNoiDungMoi;
	}

	/**
	 * @return
	 */
	public String getGuqDenNgay() {
		return guqDenNgay;
	}

	/**
	 * @return
	 */
	public String getGuqNgayXacNhan() {
		return guqNgayXacNhan;
	}

	/**
	 * @return
	 */
	public String getGuqNoiDung() {
		return guqNoiDung;
	}

	/**
	 * @return
	 */
	public String getGuqNuqChucVu() {
		return guqNuqChucVu;
	}

	/**
	 * @return
	 */
	public String getGuqNuqTen() {
		return guqNuqTen;
	}

	/**
	 * @return
	 */
	public String getGuqTuNgay() {
		return guqTuNgay;
	}

	/**
	 * @return
	 */
	public String getIsDaGiaiQuyet() {
		return isDaGiaiQuyet;
	}

	/**
	 * @return
	 */
	public String getMaHoSoDaGiaiQuyet() {
		return maHoSoDaGiaiQuyet;
	}

	/**
	 * @return
	 */
	public String getNuqChucVu() {
		return nuqChucVu;
	}

	/**
	 * @return
	 */
	public String getNuqCMT() {
		return nuqCMT;
	}

	/**
	 * @return
	 */
	public String getNuqCMTNgayCap() {
		return nuqCMTNgayCap;
	}

	/**
	 * @return
	 */
	public String getNuqCMTNoiCap() {
		return nuqCMTNoiCap;
	}

	/**
	 * @return
	 */
	public String getNuqDiaChi() {
		return nuqDiaChi;
	}

	/**
	 * @return
	 */
	public String getNuqDienThoai() {
		return nuqDienThoai;
	}

	/**
	 * @return
	 */
	public String getNuqFAX() {
		return nuqFAX;
	}

	/**
	 * @return
	 */
	public String getNuqMa() {
		return nuqMa;
	}

	/**
	 * @return
	 */
	public String getNuqNoiCongTac() {
		return nuqNoiCongTac;
	}

	/**
	 * @return
	 */
	public String getNuqTen() {
		return nuqTen;
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
	public void setDaGiaiQuyetNoiDungMoi(String string) {
		daGiaiQuyetNoiDungMoi = string;
	}

	/**
	 * @param string
	 */
	public void setGuqDenNgay(String string) {
		guqDenNgay = string;
	}

	/**
	 * @param string
	 */
	public void setGuqNgayXacNhan(String string) {
		guqNgayXacNhan = string;
	}

	/**
	 * @param string
	 */
	public void setGuqNoiDung(String string) {
		guqNoiDung = string;
	}

	/**
	 * @param string
	 */
	public void setGuqNuqChucVu(String string) {
		guqNuqChucVu = string;
	}

	/**
	 * @param string
	 */
	public void setGuqNuqTen(String string) {
		guqNuqTen = string;
	}

	/**
	 * @param string
	 */
	public void setGuqTuNgay(String string) {
		guqTuNgay = string;
	}

	/**
	 * @param string
	 */
	public void setIsDaGiaiQuyet(String string) {
		isDaGiaiQuyet = string;
	}

	/**
	 * @param string
	 */
	public void setMaHoSoDaGiaiQuyet(String string) {
		maHoSoDaGiaiQuyet = string;
	}

	/**
	 * @param string
	 */
	public void setNuqChucVu(String string) {
		nuqChucVu = string;
	}

	/**
	 * @param string
	 */
	public void setNuqCMT(String string) {
		nuqCMT = string;
	}

	/**
	 * @param string
	 */
	public void setNuqCMTNgayCap(String string) {
		nuqCMTNgayCap = string;
	}

	/**
	 * @param string
	 */
	public void setNuqCMTNoiCap(String string) {
		nuqCMTNoiCap = string;
	}

	/**
	 * @param string
	 */
	public void setNuqDiaChi(String string) {
		nuqDiaChi = string;
	}

	/**
	 * @param string
	 */
	public void setNuqDienThoai(String string) {
		nuqDienThoai = string;
	}

	/**
	 * @param string
	 */
	public void setNuqFAX(String string) {
		nuqFAX = string;
	}

	/**
	 * @param string
	 */
	public void setNuqMa(String string) {
		nuqMa = string;
	}

	/**
	 * @param string
	 */
	public void setNuqNoiCongTac(String string) {
		nuqNoiCongTac = string;
	}

	/**
	 * @param string
	 */
	public void setNuqTen(String string) {
		nuqTen = string;
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
	public String getHinhThuc() {
		return hinhThuc;
	}

	/**
	 * @param string
	 */
	public void setHinhThuc(String string) {
		hinhThuc = string;
	}

	/**
	 * @return
	 */
	public String getDoanKNTC() {
		return doanKNTC;
	}

	/**
	 * @return
	 */
	public String getDoanKNTCSoLuong() {
		return doanKNTCSoLuong;
	}

	/**
	 * @return
	 */
	public String getGayRoi() {
		return gayRoi;
	}

	/**
	 * @param string
	 */
	public void setDoanKNTC(String string) {
		doanKNTC = string;
	}

	/**
	 * @param string
	 */
	public void setDoanKNTCSoLuong(String string) {
		doanKNTCSoLuong = string;
	}

	/**
	 * @param string
	 */
	public void setGayRoi(String string) {
		gayRoi = string;
	}

	public String getNgayNhanVT() {
		return ngayNhanVT;
	}

	public void setNgayNhanVT(String ngayNhanVT) {
		this.ngayNhanVT = ngayNhanVT;
	}

	public String getNgayNhanXL() {
		return ngayNhanXL;
	}

	public void setNgayNhanXL(String ngayNhanXL) {
		this.ngayNhanXL = ngayNhanXL;
	}

	public String getSoCVDenVT() {
		return soCVDenVT;
	}

	public void setSoCVDenVT(String soCVDenVT) {
		this.soCVDenVT = soCVDenVT;
	}

	public String getLuotTiep() {
		return luotTiep;
	}

	public void setLuotTiep(String lanTiep) {
		this.luotTiep = lanTiep;
	}
	public String getTrangThaiText() {
		return trangThaiText;
	}

	public void setTrangThaiText(String trangThai) {
		this.trangThaiText = trangThai;
	}
}
