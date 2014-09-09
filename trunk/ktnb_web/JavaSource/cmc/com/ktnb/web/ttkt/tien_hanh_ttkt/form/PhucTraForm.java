package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form;
 


import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThNoiDungPhucTra;
import cmc.com.ktnb.web.BaseActionForm;


/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */

public class PhucTraForm extends BaseActionForm {

	private String id;
	private String idCuocTtKt;
	private String noiTrinh;
	private String ngayTrinh;
	private String noiPheDuyet;
	private String ngayPheDuyet;
	private String kienPheDuyet;
	private String soQuyetDinh;
	private String noiRaQuyetDinh;
	private String ngayRaQuyetDinh;
	private String vanBanQuyetDinh;
	private String idCoQuanThueCanPhucTra;
	private String tenCoQuanTueCanPhucTra;
	private String diaDiemPhucTra;
	private String noiDungNghiVan;
	private String soQdTtKtCanPhucTra;
	private String ngayLap;
	private String tenNguoiRaQd;
	private String chucDanhNguoiRaQd;
	private String idNoiDungPhucTra;
	private TtktThNoiDungPhucTra[] noiDungPhucTra;
	private String noiDungPhucTraNgoaiNganhThue;
	private String loaiNDPhucTra;
	private String nienDoTuNgay;
	private String nienDoDenNgay;
	private String thoiGian;
	private String idDVThucHien;
	
	private String tenNguoiDeNghiPT;
	private String cvNguoiDeNghiPT;
	private String cqNguoiDeNghiPT;
	private String idNguoiDeNghiPT;
	private String loaiND;
	private String loaiNDHidden;
	private String idDsTvd;
	
	private TtktCmThanhPhanThamDu[] dsCanBoThucHien;


	public String getIdNguoiDeNghiPT() {
		return idNguoiDeNghiPT;
	}

	public void setIdNguoiDeNghiPT(String idNguoiDeNghiPT) {
		this.idNguoiDeNghiPT = idNguoiDeNghiPT;
	}

	public String getCqNguoiDeNghiPT() {
		return cqNguoiDeNghiPT;
	}

	public String getCvNguoiDeNghiPT() {
		return cvNguoiDeNghiPT;
	}

	public String getTenNguoiDeNghiPT() {
		return tenNguoiDeNghiPT;
	}

	public void setCqNguoiDeNghiPT(String cqNguoiDeNghiPT) {
		this.cqNguoiDeNghiPT = cqNguoiDeNghiPT;
	}

	public void setCvNguoiDeNghiPT(String cvNguoiDeNghiPT) {
		this.cvNguoiDeNghiPT = cvNguoiDeNghiPT;
	}

	public void setTenNguoiDeNghiPT(String tenNguoiDeNghiPT) {
		this.tenNguoiDeNghiPT = tenNguoiDeNghiPT;
	}

	public String getIdDVThucHien() {
		return idDVThucHien;
	}

	/**
	 * @param idDVThucHien the idDVThucHien to set
	 */
	public void setIdDVThucHien(String idDVThucHien) {
		this.idDVThucHien = idDVThucHien;
	}

	/**
	 * @return the noiDungPhucTra
	 */
	public TtktThNoiDungPhucTra[] getNoiDungPhucTra() {
		return noiDungPhucTra;
	}

	/**
	 * @param noiDungPhucTra the noiDungPhucTra to set
	 */
	public void setNoiDungPhucTra(TtktThNoiDungPhucTra[] noiDungPhucTra) {
		this.noiDungPhucTra = noiDungPhucTra;
	}

	/**
	 * @return the tenNguoiRaQd
	 */
	public String getTenNguoiRaQd() {
		return tenNguoiRaQd;
	}

	/**
	 * @param tenNguoiRaQd the tenNguoiRaQd to set
	 */
	public void setTenNguoiRaQd(String tenNguoiRaQd) {
		this.tenNguoiRaQd = tenNguoiRaQd;
	}

	/**
	 * @return the dsCanBoThucHien
	 */
	public TtktCmThanhPhanThamDu[] getDsCanBoThucHien() {
		return dsCanBoThucHien;
	}

	/**
	 * @return the dsNoiDungPhucTra
	 */
	public void setDsCanBoThucHien(TtktCmThanhPhanThamDu[] dsCanBoThucHien) {
		this.dsCanBoThucHien = dsCanBoThucHien;
	}


	/**
	 * @return the tenCoQuanTueCanPhucTra
	 */
	public String getTenCoQuanTueCanPhucTra() {
		return tenCoQuanTueCanPhucTra;
	}

	/**
	 * @param tenCoQuanTueCanPhucTra the tenCoQuanTueCanPhucTra to set
	 */
	public void setTenCoQuanTueCanPhucTra(String tenCoQuanTueCanPhucTra) {
		this.tenCoQuanTueCanPhucTra = tenCoQuanTueCanPhucTra;
	}

	/**
	 * @return the serialVersionUID
	 */
		/**
	 * @return the chucDanhNguoiRaQd
	 */
	public String getChucDanhNguoiRaQd() {
		return chucDanhNguoiRaQd;
	}



	/**
	 * @return the soQdTtKtCanPhucTra
	 */
	public String getSoQdTtKtCanPhucTra() {
		return soQdTtKtCanPhucTra;
	}

	/**
	 * @return the tenCqtCanPhucTra
	 */

	/**
	 * @param chucDanhNguoiRaQd the chucDanhNguoiRaQd to set
	 */
	public void setChucDanhNguoiRaQd(String chucDanhNguoiRaQd) {
		this.chucDanhNguoiRaQd = chucDanhNguoiRaQd;
	}

	/**
	 * @param diaDiemPhucTra the diaDiemPhucTra to set
	 */
	public void setDiaDiemPhucTra(String diaDiemPhucTra) {
		this.diaDiemPhucTra = diaDiemPhucTra;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param idCuocTtKt the idCuocTtKt to set
	 */
	public void setIdCuocTtKt(String idCuocTtKt) {
		this.idCuocTtKt = idCuocTtKt;
	}

	/**
	 * @param kienPheDuyet the kienPheDuyet to set
	 */
	public void setKienPheDuyet(String kienPheDuyet) {
		this.kienPheDuyet = kienPheDuyet;
	}

	/**
	 * @param ngayLap the ngayLap to set
	 */
	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}

	/**
	 * @param ngayPheDuyet the ngayPheDuyet to set
	 */
	public void setNgayPheDuyet(String ngayPheDuyet) {
		this.ngayPheDuyet = ngayPheDuyet;
	}

	/**
	 * @param ngayRaQuyetDinh the ngayRaQuyetDinh to set
	 */
	public void setNgayRaQuyetDinh(String ngayRaQuyetDinh) {
		this.ngayRaQuyetDinh = ngayRaQuyetDinh;
	}

	/**
	 * @param ngayTrinh the ngayTrinh to set
	 */
	public void setNgayTrinh(String ngayTrinh) {
		this.ngayTrinh = ngayTrinh;
	}

	/**
	 * @param nienDoDenNgay the nienDoDenNgay to set
	 */
	public void setNienDoDenNgay(String nienDoDenNgay) {
		this.nienDoDenNgay = nienDoDenNgay;
	}

	/**
	 * @param nienDoTuNgay the nienDoTuNgay to set
	 */
	public void setNienDoTuNgay(String nienDoTuNgay) {
		this.nienDoTuNgay = nienDoTuNgay;
	}

	/**
	 * @param noiDungNghiVan the noiDungNghiVan to set
	 */
	public void setNoiDungNghiVan(String noiDungNghiVan) {
		this.noiDungNghiVan = noiDungNghiVan;
	}

	/**
	 * @param noiPheDuyet the noiPheDuyet to set
	 */
	public void setNoiPheDuyet(String noiPheDuyet) {
		this.noiPheDuyet = noiPheDuyet;
	}

	/**
	 * @param noiRaQuyetDinh the noiRaQuyetDinh to set
	 */
	public void setNoiRaQuyetDinh(String noiRaQuyetDinh) {
		this.noiRaQuyetDinh = noiRaQuyetDinh;
	}

	/**
	 * @param noiTrinh the noiTrinh to set
	 */
	public void setNoiTrinh(String noiTrinh) {
		this.noiTrinh = noiTrinh;
	}

	/**
	 * @param soQdTtKtCanPhucTra the soQdTtKtCanPhucTra to set
	 */
	public void setSoQdTtKtCanPhucTra(String soQdTtKtCanPhucTra) {
		this.soQdTtKtCanPhucTra = soQdTtKtCanPhucTra;
	}

	/**
	 * @param soQuyetDinh the soQuyetDinh to set
	 */
	public void setSoQuyetDinh(String soQuyetDinh) {
		this.soQuyetDinh = soQuyetDinh;
	}



	/**
	 * @param thoiGian the thoiGian to set
	 */
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	/**
	 * @param vanBanQuyetDinh the vanBanQuyetDinh to set
	 */
	public void setVanBanQuyetDinh(String vanBanQuyetDinh) {
		this.vanBanQuyetDinh = vanBanQuyetDinh;
	}

	/**
	 * @return the idNoiDungPhucTra
	 */
	public String getIdNoiDungPhucTra() {
		return idNoiDungPhucTra;
	}

	/**
	 * @param idNoiDungPhucTra the idNoiDungPhucTra to set
	 */
	public void setIdNoiDungPhucTra(String idNoiDungPhucTra) {
		this.idNoiDungPhucTra = idNoiDungPhucTra;
	}

	/**
	 * @return the idCoQuanThueCanPhucTra
	 */
	public String getIdCoQuanThueCanPhucTra() {
		return idCoQuanThueCanPhucTra;
	}

	/**
	 * @param idCoQuanThueCanPhucTra the idCoQuanThueCanPhucTra to set
	 */
	public void setIdCoQuanThueCanPhucTra(String idCoQuanThueCanPhucTra) {
		this.idCoQuanThueCanPhucTra = idCoQuanThueCanPhucTra;
	}

	/**
	 * @return the diaDiemPhucTra
	 */
	public String getDiaDiemPhucTra() {
		return diaDiemPhucTra;
	}
	/**
	 * @return the dsCbThucHien
	 */

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the idCuocTtKt
	 */
	public String getIdCuocTtKt() {
		return idCuocTtKt;
	}

	/**
	 * @return the kienPheDuyet
	 */
	public String getKienPheDuyet() {
		return kienPheDuyet;
	}
	/**
	 * @return the ngayLap
	 */
	public String getNgayLap() {
		return ngayLap;
	}
	/**
	 * @return the ngayPheDuyet
	 */
	public String getNgayPheDuyet() {
		return ngayPheDuyet;
	}
	/**
	 * @return the ngayRaQuyetDinh
	 */
	public String getNgayRaQuyetDinh() {
		return ngayRaQuyetDinh;
	}
	/**
	 * @return the ngayTrinh
	 */
	public String getNgayTrinh() {
		return ngayTrinh;
	}
	/**
	 * @return the nienDoDenNgay
	 */
	public String getNienDoDenNgay() {
		return nienDoDenNgay;
	}
	/**
	 * @return the nienDoTuNgay
	 */
	public String getNienDoTuNgay() {
		return nienDoTuNgay;
	}
	/**
	 * @return the noiDungNghiVan
	 */
	public String getNoiDungNghiVan() {
		return noiDungNghiVan;
	}
	/**
	 * @return the noiPheDuyet
	 */
	public String getNoiPheDuyet() {
		return noiPheDuyet;
	}
	/**
	 * @return the noiRaQuyetDinh
	 */
	public String getNoiRaQuyetDinh() {
		return noiRaQuyetDinh;
	}
	/**
	 * @return the noiTrinh
	 */
	public String getNoiTrinh() {
		return noiTrinh;
	}


	public String getSoQuyetDinh() {
		return soQuyetDinh;
	}

	/**
	 * @return the thoiGian
	 */
	public String getThoiGian() {
		return thoiGian;
	}
	/**
	 * @return the vanBanQuyetDinh
	 */
	public String getVanBanQuyetDinh() {
		return vanBanQuyetDinh;
	}

	public String getLoaiNDPhucTra() {
		return loaiNDPhucTra;
	}

	public void setLoaiNDPhucTra(String loaiNDPhucTra) {
		this.loaiNDPhucTra = loaiNDPhucTra;
	}

	public String getNoiDungPhucTraNgoaiNganhThue() {
		return noiDungPhucTraNgoaiNganhThue;
	}

	public void setNoiDungPhucTraNgoaiNganhThue(String noiDungPhucTraNgoaiNganhThue) {
		this.noiDungPhucTraNgoaiNganhThue = noiDungPhucTraNgoaiNganhThue;
	}

	public String getLoaiND() {
		return loaiND;
	}

	public void setLoaiND(String loaiND) {
		this.loaiND = loaiND;
	}

	public String getLoaiNDHidden() {
		return loaiNDHidden;
	}

	public void setLoaiNDHidden(String loaiNDHidden) {
		this.loaiNDHidden = loaiNDHidden;
	}	

	public String getIdDsTvd() {
		return idDsTvd;
	}

	public void setIdDsTvd(String idDsTvd) {
		this.idDsTvd = idDsTvd;
	}

	
	
	
 }