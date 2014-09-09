package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form;
 
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.web.BaseActionForm;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */ 

public class YeuCauCungCapHstlForm extends BaseActionForm {
	
//Phieu yeu cau	
private String lanYeuCau;
private String idYeuCau;
private String idCbYeuCau;
private String tenCbYeuCau;
private String chucVuCbYeuCau;
private String noiLapYeuCau;
private String ngayLapYeuCau;
private String baoCao;
private String hoSo;

private String idNgNhanPhieuYc;
private String tenNgNhanPhieuYc;
private String chucVuNgNhanPhieuYc;
private String thoiDiemNhanPhieuYc;
private String diaDiemNhanPhieuYc;

private String thoiDiemCungCap;
private String diaDiemCungCap;
private String idNguoiNhanBc;
private String tenCbNhanBc;
private String chucVuNgNhanBc;
private String idCuocTtKtl;
private String idDsTvdPhieuYc;


//Bien ban giao nhan
  private String idBanGiaoHoSoLuuTru;
  private String baoCaoBanGianHoSoLuuTru;
  private String hoSoBanGianHoSoLuuTru;
  private String idDaiDienBenGiaoBanGianHoSoLuuTru;
  private String idDaiDienBenNhanBanGianHoSoLuuTru;
  private String loaiBanGianHoSoLuuTru;
  private String thoiDiemBatDauBanGianHoSoLuuTru;
  private String thoiDiemKTBBGN;
  private String diaDiemBBGN;
  private TtktCmThanhPhanThamDu[] arrDaiDienBenGiaoHstlLuuTru;
  private TtktCmThanhPhanThamDu[] arrDaiDienBenNhanHstlLuuTru;
  private String idDsTvdGiaoNhan;




//Bien ban giao tra
  private String idHoSoTra;
  private String baoCaoHoSoTra;
  private String hoSoTra;
  private String idDaiDienBenGiaoHoSo;
  private String idDaiDienBenNhanHoSo;
  private String loaiHoSoLuuTru;
  private String thoiDiemBatDauBanGiaoHoSo;
  private String thoiDiemKTBBGT;
  private String diaDiemBBGT;
  private TtktCmThanhPhanThamDu[] arrDaiDienBenGiaoHstl;
  private TtktCmThanhPhanThamDu[] arrDaiDienBenNhanHstl;
  private String idDsTvdGiaoTra;


//--------------------------
private String idDonViTienHanh;
public String getDiaDiemBBGN() {
	return diaDiemBBGN;
}

public String getDiaDiemBBGT() {
	return diaDiemBBGT;
}

public void setDiaDiemBBGN(String diaDiemBBGN) {
	this.diaDiemBBGN = diaDiemBBGN;
}

public void setDiaDiemBBGT(String diaDiemBBGT) {
	this.diaDiemBBGT = diaDiemBBGT;
}

public String getThoiDiemKTBBGN() {
	return thoiDiemKTBBGN;
}

public String getThoiDiemKTBBGT() {
	return thoiDiemKTBBGT;
}

public void setThoiDiemKTBBGN(String thoiDiemKTBBGN) {
	this.thoiDiemKTBBGN = thoiDiemKTBBGN;
}

public void setThoiDiemKTBBGT(String thoiDiemKTBBGT) {
	this.thoiDiemKTBBGT = thoiDiemKTBBGT;
}

public String getDiaDiemNhanPhieuYc() {
	return diaDiemNhanPhieuYc;
}

public void setDiaDiemNhanPhieuYc(String diaDiemNhanPhieuYc) {
	this.diaDiemNhanPhieuYc = diaDiemNhanPhieuYc;
}

/**
 * @return
 */
public TtktCmThanhPhanThamDu[] getArrDaiDienBenGiaoHstl() {
	return arrDaiDienBenGiaoHstl;
}

/**
 * @return
 */
public TtktCmThanhPhanThamDu[] getArrDaiDienBenGiaoHstlLuuTru() {
	return arrDaiDienBenGiaoHstlLuuTru;
}

/**
 * @return
 */
public TtktCmThanhPhanThamDu[] getArrDaiDienBenNhanHstl() {
	return arrDaiDienBenNhanHstl;
}

/**
 * @return
 */
public TtktCmThanhPhanThamDu[] getArrDaiDienBenNhanHstlLuuTru() {
	return arrDaiDienBenNhanHstlLuuTru;
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
public String getBaoCaoBanGianHoSoLuuTru() {
	return baoCaoBanGianHoSoLuuTru;
}

/**
 * @return
 */
public String getBaoCaoHoSoTra() {
	return baoCaoHoSoTra;
}

/**
 * @return
 */
public String getChucVuCbYeuCau() {
	return chucVuCbYeuCau;
}

/**
 * @return
 */
public String getChucVuNgNhanBc() {
	return chucVuNgNhanBc;
}

/**
 * @return
 */
public String getChucVuNgNhanPhieuYc() {
	return chucVuNgNhanPhieuYc;
}

/**
 * @return
 */
public String getDiaDiemCungCap() {
	return diaDiemCungCap;
}

/**
 * @return
 */
public String getHoSo() {
	return hoSo;
}

/**
 * @return
 */
public String getHoSoBanGianHoSoLuuTru() {
	return hoSoBanGianHoSoLuuTru;
}

/**
 * @return
 */
public String getHoSoTra() {
	return hoSoTra;
}

/**
 * @return
 */
public String getIdBanGiaoHoSoLuuTru() {
	return idBanGiaoHoSoLuuTru;
}

/**
 * @return
 */
public String getIdCbYeuCau() {
	return idCbYeuCau;
}

/**
 * @return
 */
public String getIdCuocTtKtl() {
	return idCuocTtKtl;
}

/**
 * @return
 */
public String getIdDaiDienBenGiaoBanGianHoSoLuuTru() {
	return idDaiDienBenGiaoBanGianHoSoLuuTru;
}

/**
 * @return
 */
public String getIdDaiDienBenGiaoHoSo() {
	return idDaiDienBenGiaoHoSo;
}

/**
 * @return
 */
public String getIdDaiDienBenNhanBanGianHoSoLuuTru() {
	return idDaiDienBenNhanBanGianHoSoLuuTru;
}

/**
 * @return
 */
public String getIdDaiDienBenNhanHoSo() {
	return idDaiDienBenNhanHoSo;
}

/**
 * @return
 */
public String getIdHoSoTra() {
	return idHoSoTra;
}

/**
 * @return
 */
public String getIdNgNhanPhieuYc() {
	return idNgNhanPhieuYc;
}

/**
 * @return
 */
public String getIdNguoiNhanBc() {
	return idNguoiNhanBc;
}

/**
 * @return
 */
public String getIdYeuCau() {
	return idYeuCau;
}

/**
 * @return
 */
public String getLanYeuCau() {
	return lanYeuCau;
}

/**
 * @return
 */
public String getLoaiBanGianHoSoLuuTru() {
	return loaiBanGianHoSoLuuTru;
}

/**
 * @return
 */
public String getLoaiHoSoLuuTru() {
	return loaiHoSoLuuTru;
}

/**
 * @return
 */
public String getNgayLapYeuCau() {
	return ngayLapYeuCau;
}

/**
 * @return
 */
public String getNoiLapYeuCau() {
	return noiLapYeuCau;
}

/**
 * @return
 */
public String getTenCbNhanBc() {
	return tenCbNhanBc;
}

/**
 * @return
 */
public String getTenCbYeuCau() {
	return tenCbYeuCau;
}

/**
 * @return
 */
public String getTenNgNhanPhieuYc() {
	return tenNgNhanPhieuYc;
}

/**
 * @return
 */
public String getThoiDiemBatDauBanGianHoSoLuuTru() {
	return thoiDiemBatDauBanGianHoSoLuuTru;
}

/**
 * @return
 */
public String getThoiDiemBatDauBanGiaoHoSo() {
	return thoiDiemBatDauBanGiaoHoSo;
}

/**
 * @return
 */
public String getThoiDiemCungCap() {
	return thoiDiemCungCap;
}

/**
 * @return
 */
public String getThoiDiemNhanPhieuYc() {
	return thoiDiemNhanPhieuYc;
}

/**
 * @param dus
 */
public void setArrDaiDienBenGiaoHstl(TtktCmThanhPhanThamDu[] dus) {
	arrDaiDienBenGiaoHstl = dus;
}

/**
 * @param dus
 */
public void setArrDaiDienBenGiaoHstlLuuTru(TtktCmThanhPhanThamDu[] dus) {
	arrDaiDienBenGiaoHstlLuuTru = dus;
}

/**
 * @param dus
 */
public void setArrDaiDienBenNhanHstl(TtktCmThanhPhanThamDu[] dus) {
	arrDaiDienBenNhanHstl = dus;
}

/**
 * @param dus
 */
public void setArrDaiDienBenNhanHstlLuuTru(TtktCmThanhPhanThamDu[] dus) {
	arrDaiDienBenNhanHstlLuuTru = dus;
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
public void setBaoCaoBanGianHoSoLuuTru(String string) {
	baoCaoBanGianHoSoLuuTru = string;
}

/**
 * @param string
 */
public void setBaoCaoHoSoTra(String string) {
	baoCaoHoSoTra = string;
}

/**
 * @param string
 */
public void setChucVuCbYeuCau(String string) {
	chucVuCbYeuCau = string;
}

/**
 * @param string
 */
public void setChucVuNgNhanBc(String string) {
	chucVuNgNhanBc = string;
}

/**
 * @param string
 */
public void setChucVuNgNhanPhieuYc(String string) {
	chucVuNgNhanPhieuYc = string;
}

/**
 * @param string
 */
public void setDiaDiemCungCap(String string) {
	diaDiemCungCap = string;
}

/**
 * @param string
 */
public void setHoSo(String string) {
	hoSo = string;
}

/**
 * @param string
 */
public void setHoSoBanGianHoSoLuuTru(String string) {
	hoSoBanGianHoSoLuuTru = string;
}

/**
 * @param string
 */
public void setHoSoTra(String string) {
	hoSoTra = string;
}

/**
 * @param string
 */
public void setIdBanGiaoHoSoLuuTru(String string) {
	idBanGiaoHoSoLuuTru = string;
}

/**
 * @param string
 */
public void setIdCbYeuCau(String string) {
	idCbYeuCau = string;
}

/**
 * @param string
 */
public void setIdCuocTtKtl(String string) {
	idCuocTtKtl = string;
}

/**
 * @param string
 */
public void setIdDaiDienBenGiaoBanGianHoSoLuuTru(String string) {
	idDaiDienBenGiaoBanGianHoSoLuuTru = string;
}

/**
 * @param string
 */
public void setIdDaiDienBenGiaoHoSo(String string) {
	idDaiDienBenGiaoHoSo = string;
}

/**
 * @param string
 */
public void setIdDaiDienBenNhanBanGianHoSoLuuTru(String string) {
	idDaiDienBenNhanBanGianHoSoLuuTru = string;
}

/**
 * @param string
 */
public void setIdDaiDienBenNhanHoSo(String string) {
	idDaiDienBenNhanHoSo = string;
}

/**
 * @param string
 */
public void setIdHoSoTra(String string) {
	idHoSoTra = string;
}

/**
 * @param string
 */
public void setIdNgNhanPhieuYc(String string) {
	idNgNhanPhieuYc = string;
}

/**
 * @param string
 */
public void setIdNguoiNhanBc(String string) {
	idNguoiNhanBc = string;
}

/**
 * @param string
 */
public void setIdYeuCau(String string) {
	idYeuCau = string;
}

/**
 * @param string
 */
public void setLanYeuCau(String string) {
	lanYeuCau = string;
}

/**
 * @param string
 */
public void setLoaiBanGianHoSoLuuTru(String string) {
	loaiBanGianHoSoLuuTru = string;
}

/**
 * @param string
 */
public void setLoaiHoSoLuuTru(String string) {
	loaiHoSoLuuTru = string;
}

/**
 * @param string
 */
public void setNgayLapYeuCau(String string) {
	ngayLapYeuCau = string;
}

/**
 * @param string
 */
public void setNoiLapYeuCau(String string) {
	noiLapYeuCau = string;
}

/**
 * @param string
 */
public void setTenCbNhanBc(String string) {
	tenCbNhanBc = string;
}

/**
 * @param string
 */
public void setTenCbYeuCau(String string) {
	tenCbYeuCau = string;
}

/**
 * @param string
 */
public void setTenNgNhanPhieuYc(String string) {
	tenNgNhanPhieuYc = string;
}

/**
 * @param string
 */
public void setThoiDiemBatDauBanGianHoSoLuuTru(String string) {
	thoiDiemBatDauBanGianHoSoLuuTru = string;
}

/**
 * @param string
 */
public void setThoiDiemBatDauBanGiaoHoSo(String string) {
	thoiDiemBatDauBanGiaoHoSo = string;
}

/**
 * @param string
 */
public void setThoiDiemCungCap(String string) {
	thoiDiemCungCap = string;
}

/**
 * @param string
 */
public void setThoiDiemNhanPhieuYc(String string) {
	thoiDiemNhanPhieuYc = string;
}

/**
 * @return
 */
public String getIdDonViTienHanh() {
	return idDonViTienHanh;
}

/**
 * @param string
 */
public void setIdDonViTienHanh(String string) {
	idDonViTienHanh = string;
}



/**
 * @return
 */
public String getIdDsTvdGiaoNhan() {
	return idDsTvdGiaoNhan;
}

/**
 * @return
 */
public String getIdDsTvdGiaoTra() {
	return idDsTvdGiaoTra;
}

/**
 * @param string
 */
public void setIdDsTvdGiaoNhan(String string) {
	idDsTvdGiaoNhan = string;
}

/**
 * @param string
 */
public void setIdDsTvdGiaoTra(String string) {
	idDsTvdGiaoTra = string;
}

/**
 * @return
 */
public String getIdDsTvdPhieuYc() {
	return idDsTvdPhieuYc;
}

/**
 * @param string
 */
public void setIdDsTvdPhieuYc(String string) {
	idDsTvdPhieuYc = string;
}

 }