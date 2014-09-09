package cmc.com.ktnb.web.kntc.tiep_dan;
import cmc.com.ktnb.web.BaseActionForm;
/**
 * Class base của sổ tiếp dân
 * @author Ntthu 
 * Created on Nov 2, 2010
 */
public class BaseSoTiepDanForm extends BaseActionForm {

	// Thong tin Ho so
	protected String ngayTiep,thoiDiemInGbn; // Ngay nhan cong van
	
	// Thong tin nguoi Khieu To hoac cong dan Khieu nai truc tiep
	protected String congdanMa;
	protected String congdanTen;
	protected String congdanDiaChi;
	protected String congdanChucVu;
	protected String congdanDienThoai;
	protected String congdanNoiCongTac;

	protected String congdanCMT;
	protected String congdanCMTNoiCap;
	protected String congdanCMTNgayCap;
	protected String congdanMST;
	protected String coLuatSu;

	protected String noiTiepDan; // Hoac don vi nhan cong van
	protected String loaiKNTC;
	

	//	Thong tin Luat Su
	protected String luatsuMa;
	protected String luatsuTen;
	protected String luatsuNoiCongTac;
	protected String luatsuSoThe;
	protected String luatsuDiaChi;
	protected String luatsuCMT; // CMT cho ca nhan, MST cho To Chuc
	protected String luatsuDienThoai;
	protected String luatsuHDMa;
	protected String luatsuHDNoiDung;
	protected String luatsuSoGiayGT;

	protected String loaiDonKNTC;
	protected String loaiThuLy;
	protected String maHoSo,maHidden;
	protected String soDon;
	protected String isKNTCTrucTiep;

	protected String donDeNgay;
	protected String ngayLap;
	protected String canBoBiKNTCMa;
	protected String canBoBiKNTCTen;
	protected String canBoBiKNTCChucVu;
	protected String canBoBiKNTCNoiCongTac;
	protected String canBoBiKNTCDiaChi;
	protected String noiDungDon;
	protected String ghiChu;
	protected String boSungTaiLieu;
	protected String tinhTrangDonTC;

	protected String mucdich;
	protected String first = "1";
	protected String arrTenTl;
	protected String arrSoTrangTl,ttHoSo;
	protected String canBoMa;
	protected String canBoTen;
	protected String canBoNoiCongTac;
	protected String canBoChucVu;
	protected String maHoSoChuyen;
	protected String maHoSoTachKN;
	protected String maHoSoTachTC;
	public String getMaHoSoChuyen() {
		return maHoSoChuyen;
	}

	public void setMaHoSoChuyen(String maHoSoChuyen) {
		this.maHoSoChuyen = maHoSoChuyen;
	}

	public String getMaHoSoTachKN() {
		return maHoSoTachKN;
	}

	public void setMaHoSoTachKN(String maHoSoTachKN) {
		this.maHoSoTachKN = maHoSoTachKN;
	}

	public String getMaHoSoTachTC() {
		return maHoSoTachTC;
	}

	public void setMaHoSoTachTC(String maHoSoTachTC) {
		this.maHoSoTachTC = maHoSoTachTC;
	}
	/**
	 * @return
	 */
	public String getArrSoTrangTl() {
		return arrSoTrangTl;
	}

	/**
	 * @return
	 */
	public String getArrTenTl() {
		return arrTenTl;
	}

	/**
	 * @return
	 */
	public String getBoSungTaiLieu() {
		return boSungTaiLieu;
	}

	/**
	 * @return
	 */
	public String getCanBoBiKNTCChucVu() {
		return canBoBiKNTCChucVu;
	}

	/**
	 * @return
	 */
	public String getCanBoBiKNTCDiaChi() {
		return canBoBiKNTCDiaChi;
	}

	/**
	 * @return
	 */
	public String getCanBoBiKNTCMa() {
		return canBoBiKNTCMa;
	}

	/**
	 * @return
	 */
	public String getCanBoBiKNTCNoiCongTac() {
		return canBoBiKNTCNoiCongTac;
	}

	/**
	 * @return
	 */
	public String getCanBoBiKNTCTen() {
		return canBoBiKNTCTen;
	}

	/**
	 * @return
	 */
	public String getCoLuatSu() {
		return coLuatSu;
	}

	/**
	 * @return
	 */
	public String getCongdanChucVu() {
		return congdanChucVu;
	}

	/**
	 * @return
	 */
	public String getCongdanCMT() {
		return congdanCMT;
	}

	/**
	 * @return
	 */
	public String getCongdanCMTNgayCap() {
		return congdanCMTNgayCap;
	}

	/**
	 * @return
	 */
	public String getCongdanCMTNoiCap() {
		return congdanCMTNoiCap;
	}

	/**
	 * @return
	 */
	public String getCongdanDiaChi() {
		return congdanDiaChi;
	}

	/**
	 * @return
	 */
	public String getCongdanDienThoai() {
		return congdanDienThoai;
	}

	/**
	 * @return
	 */
	public String getCongdanMa() {
		return congdanMa;
	}

	/**
	 * @return
	 */
	public String getCongdanMST() {
		return congdanMST;
	}

	/**
	 * @return
	 */
	public String getCongdanNoiCongTac() {
		return congdanNoiCongTac;
	}

	/**
	 * @return
	 */
	public String getCongdanTen() {
		return congdanTen;
	}

	/**
	 * @return
	 */
	public String getDonDeNgay() {
		return donDeNgay;
	}

	/**
	 * @return
	 */
	public String getFirst() {
		return first;
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
	public String getIsKNTCTrucTiep() {
		return isKNTCTrucTiep;
	}

	/**
	 * @return
	 */
	public String getLoaiDonKNTC() {
		return loaiDonKNTC;
	}

	/**
	 * @return
	 */
	public String getLoaiKNTC() {
		return loaiKNTC;
	}

	/**
	 * @return
	 */
	public String getLoaiThuLy() {
		return loaiThuLy;
	}

	/**
	 * @return
	 */
	public String getLuatsuCMT() {
		return luatsuCMT;
	}

	/**
	 * @return
	 */
	public String getLuatsuDiaChi() {
		return luatsuDiaChi;
	}

	/**
	 * @return
	 */
	public String getLuatsuDienThoai() {
		return luatsuDienThoai;
	}

	/**
	 * @return
	 */
	public String getLuatsuHDMa() {
		return luatsuHDMa;
	}

	/**
	 * @return
	 */
	public String getLuatsuHDNoiDung() {
		return luatsuHDNoiDung;
	}

	/**
	 * @return
	 */
	public String getLuatsuMa() {
		return luatsuMa;
	}

	/**
	 * @return
	 */
	public String getLuatsuNoiCongTac() {
		return luatsuNoiCongTac;
	}

	/**
	 * @return
	 */
	public String getLuatsuSoGiayGT() {
		return luatsuSoGiayGT;
	}

	/**
	 * @return
	 */
	public String getLuatsuSoThe() {
		return luatsuSoThe;
	}

	/**
	 * @return
	 */
	public String getLuatsuTen() {
		return luatsuTen;
	}

	/**
	 * @return
	 */
	public String getMaHoSo() {
		return maHoSo;
	}

	/**
	 * @return
	 */
	public String getMucdich() {
		return mucdich;
	}

	/**
	 * @return
	 */
	public String getNgayTiep() {
		return ngayTiep;
	}

	/**
	 * @return
	 */
	public String getNoiDungDon() {
		return noiDungDon;
	}

	/**
	 * @return
	 */
	public String getNoiTiepDan() {
		return noiTiepDan;
	}

	/**
	 * @return
	 */
	public String getSoDon() {
		return soDon;
	}

	/**
	 * @return
	 */
	public String getTinhTrangDonTC() {
		return tinhTrangDonTC;
	}

	/**
	 * @param string
	 */
	public void setArrSoTrangTl(String string) {
		arrSoTrangTl = string;
	}

	/**
	 * @param string
	 */
	public void setArrTenTl(String string) {
		arrTenTl = string;
	}

	/**
	 * @param string
	 */
	public void setBoSungTaiLieu(String string) {
		boSungTaiLieu = string;
	}

	/**
	 * @param string
	 */
	public void setCanBoBiKNTCChucVu(String string) {
		canBoBiKNTCChucVu = string;
	}

	/**
	 * @param string
	 */
	public void setCanBoBiKNTCDiaChi(String string) {
		canBoBiKNTCDiaChi = string;
	}

	/**
	 * @param string
	 */
	public void setCanBoBiKNTCMa(String string) {
		canBoBiKNTCMa = string;
	}

	/**
	 * @param string
	 */
	public void setCanBoBiKNTCNoiCongTac(String string) {
		canBoBiKNTCNoiCongTac = string;
	}

	/**
	 * @param string
	 */
	public void setCanBoBiKNTCTen(String string) {
		canBoBiKNTCTen = string;
	}

	/**
	 * @param string
	 */
	public void setCoLuatSu(String string) {
		coLuatSu = string;
	}

	/**
	 * @param string
	 */
	public void setCongdanChucVu(String string) {
		congdanChucVu = string;
	}

	/**
	 * @param string
	 */
	public void setCongdanCMT(String string) {
		congdanCMT = string;
	}

	/**
	 * @param string
	 */
	public void setCongdanCMTNgayCap(String string) {
		congdanCMTNgayCap = string;
	}

	/**
	 * @param string
	 */
	public void setCongdanCMTNoiCap(String string) {
		congdanCMTNoiCap = string;
	}

	/**
	 * @param string
	 */
	public void setCongdanDiaChi(String string) {
		congdanDiaChi = string;
	}

	/**
	 * @param string
	 */
	public void setCongdanDienThoai(String string) {
		congdanDienThoai = string;
	}

	/**
	 * @param string
	 */
	public void setCongdanMa(String string) {
		congdanMa = string;
	}

	/**
	 * @param string
	 */
	public void setCongdanMST(String string) {
		congdanMST = string;
	}

	/**
	 * @param string
	 */
	public void setCongdanNoiCongTac(String string) {
		congdanNoiCongTac = string;
	}

	/**
	 * @param string
	 */
	public void setCongdanTen(String string) {
		congdanTen = string;
	}

	/**
	 * @param string
	 */
	public void setDonDeNgay(String string) {
		donDeNgay = string;
	}

	/**
	 * @param string
	 */
	public void setFirst(String string) {
		first = string;
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
	public void setIsKNTCTrucTiep(String string) {
		isKNTCTrucTiep = string;
	}

	/**
	 * @param string
	 */
	public void setLoaiDonKNTC(String string) {
		loaiDonKNTC = string;
	}

	/**
	 * @param string
	 */
	public void setLoaiKNTC(String string) {
		loaiKNTC = string;
	}

	/**
	 * @param string
	 */
	public void setLoaiThuLy(String string) {
		loaiThuLy = string;
	}

	/**
	 * @param string
	 */
	public void setLuatsuCMT(String string) {
		luatsuCMT = string;
	}

	/**
	 * @param string
	 */
	public void setLuatsuDiaChi(String string) {
		luatsuDiaChi = string;
	}

	/**
	 * @param string
	 */
	public void setLuatsuDienThoai(String string) {
		luatsuDienThoai = string;
	}

	/**
	 * @param string
	 */
	public void setLuatsuHDMa(String string) {
		luatsuHDMa = string;
	}

	/**
	 * @param string
	 */
	public void setLuatsuHDNoiDung(String string) {
		luatsuHDNoiDung = string;
	}

	/**
	 * @param string
	 */
	public void setLuatsuMa(String string) {
		luatsuMa = string;
	}

	/**
	 * @param string
	 */
	public void setLuatsuNoiCongTac(String string) {
		luatsuNoiCongTac = string;
	}

	/**
	 * @param string
	 */
	public void setLuatsuSoGiayGT(String string) {
		luatsuSoGiayGT = string;
	}

	/**
	 * @param string
	 */
	public void setLuatsuSoThe(String string) {
		luatsuSoThe = string;
	}

	/**
	 * @param string
	 */
	public void setLuatsuTen(String string) {
		luatsuTen = string;
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
	public void setMucdich(String string) {
		mucdich = string;
	}

	/**
	 * @param string
	 */
	public void setNgayTiep(String string) {
		ngayTiep = string;
	}

	/**
	 * @param string
	 */
	public void setNoiDungDon(String string) {
		noiDungDon = string;
	}

	/**
	 * @param string
	 */
	public void setNoiTiepDan(String string) {
		noiTiepDan = string;
	}

	/**
	 * @param string
	 */
	public void setSoDon(String string) {
		soDon = string;
	}

	/**
	 * @param string
	 */
	public void setTinhTrangDonTC(String string) {
		tinhTrangDonTC = string;
	}

	/**
	 * @return
	 */
	public String getTtHoSo() {
		return ttHoSo;
	}

	/**
	 * @param string
	 */
	public void setTtHoSo(String string) {
		ttHoSo = string;
	}

	public String getCanBoChucVu() {
		return canBoChucVu;
	}

	public void setCanBoChucVu(String canBoChucVu) {
		this.canBoChucVu = canBoChucVu;
	}

	public String getCanBoMa() {
		return canBoMa;
	}

	public void setCanBoMa(String canBoMa) {
		this.canBoMa = canBoMa;
	}

	public String getCanBoNoiCongTac() {
		return canBoNoiCongTac;
	}

	public void setCanBoNoiCongTac(String canBoNoiCongTac) {
		this.canBoNoiCongTac = canBoNoiCongTac;
	}

	public String getCanBoTen() {
		return canBoTen;
	}

	public void setCanBoTen(String canBoTen) {
		this.canBoTen = canBoTen;
	}

	public String getThoiDiemInGbn() {
		return thoiDiemInGbn;
	}

	public void setThoiDiemInGbn(String thoiDiemInGbn) {
		this.thoiDiemInGbn = thoiDiemInGbn;
	}

	public String getMaHidden() {
		return maHidden;
	}

	public void setMaHidden(String maHidden) {
		this.maHidden = maHidden;
	}

	public String getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}

}
