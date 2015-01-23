/*
 * Created on Oct 15, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.dung_chung.form;
import java.util.Collection;

import cmc.com.ktnb.entity.TTKT.dung_chung.KtnbKhTtkt;

/**
 * @author ntdung1
 *
 */
public class CuocTtktForm extends NoiDungTtktForm {
	private Collection dmNoiDungTTKT;

	private KtnbKhTtkt ktnbKhTtkt;

	private String id;
	private String maKhTtkt;
	private String idDonViBi;
	private String idDonViTh;
	private String nienDoTtkt;
	private String thoiGianDuKien;
	private String hinhThuc; // Thanh tra hay kiem tra	
	private String loai; // Dot xuat hay dinh ky
	private String ghiChu;
	private String idCanBo;
	private String idDonVi;
	private String pathOwner;
	private String propertyOfUtilCombo;
	private String IdCuocTtktTrongQd;
	private String IdCuocTtktTrongKh;
	private String maCuocTtktTrongKh;
	private String loaiCuocTtkt; // Trong ke hoach hay trong quyet dinh
	private String thoiDiem; // Cuoc ttkt la bo sung hay trong ke hoach.
	private String loaiChinhSua;
	private String idCuocKhCu;
	private String idCuocKhMoi;
	private String idCuocQdCu;
	private String idCuocQdMoi;
	private String loaiCuocTtktKeHoachNam;
	private String loaiCuocTtktQuyetDinh;

	private String nienDoTuNgay;
	private String nienDoDenNgay;
	private String donViBiName;
	private String donViThName;
	private String[][] selectNoiDungTtkt;
	private String[][] selectChiTietNoiDungTtkt;
	private String selectedNoiDungTtktIds;
	private String selectedChiTietNoiDungTtktIds;
	private String maCqtChon;
	private String trangThai;
	private String thoiGianDuKienTuNgay;
	private String thoiGianDuKienDenNgay;
	private String type,namKh;
	private String donVer;

	/**
	 * @return
	 */
	public KtnbKhTtkt getKtnbKhTtkt() {
		return ktnbKhTtkt;
	}

	/**
	 * @param ttkt
	 */
	public void setKtnbKhTtkt(KtnbKhTtkt ttkt) {
		ktnbKhTtkt = ttkt;
		//		this.setDonViBiName(ttkt.getDonViBiName());
		//		this.setDonViThName(ttkt.getDonViThName());
		//		this.setNienDoTuNgay(Formater.date2str(ttkt.getNienDoTuNgay()));
		//		this.setGhiChu(ttkt.getGhiChu());
		//		this.setId(ttkt.getId());
		//		this.setIdDonVi(ttkt.getIdDonVi());
		//		this.setIdDonViBi(ttkt.getIdDonViBi());
		//		this.setIdDonViTh(ttkt.getIdDonViTh());
		//
		//		this.setLoai(ttkt.getLoai().toString());
		//		this.setMaKhTtkt(ttkt.getMaKhTtkt());
		//		this.setThoiGianDuKien(ttkt.getThoiGianDuKien().toString());
		//		this.setNienDoDenNgay(Formater.date2str(ttkt.getNienDoDenNgay()));

	}

	/**
	 * @return
	 */
	public String getDonViBiName() {
		return donViBiName;
	}

	/**
	 * @return
	 */
	public String getDonViThName() {
		return donViThName;
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
	public String getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getIdCanBo() {
		return idCanBo;
	}

	/**
	 * @return
	 */
	public String getIdDonVi() {
		return idDonVi;
	}

	/**
	 * @return
	 */
	public String getIdDonViBi() {
		return idDonViBi;
	}

	/**
	 * @return
	 */
	public String getIdDonViTh() {
		return idDonViTh;
	}

	/**
	 * @return
	 */
	public String getLoai() {
		return loai;
	}

	/**
	 * @return
	 */
	public String getMaKhTtkt() {
		return maKhTtkt;
	}

	/**
	 * @return
	 */
	public String getNienDoTtkt() {
		return nienDoTtkt;
	}

	/**
	 * @return
	 */
	public String getPathOwner() {
		return pathOwner;
	}

	/**
	 * @return
	 */
	public String getThoiGianDuKien() {
		return thoiGianDuKien;
	}

	/**
	 * @param string
	 */
	public void setDonViBiName(String string) {
		donViBiName = string;
	}

	/**
	 * @param string
	 */
	public void setDonViThName(String string) {
		donViThName = string;
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
	public void setId(String string) {
		id = string;
	}

	/**
	 * @param string
	 */
	public void setIdCanBo(String string) {
		idCanBo = string;
	}

	/**
	 * @param string
	 */
	public void setIdDonVi(String string) {
		idDonVi = string;
	}

	/**
	 * @param string
	 */
	public void setIdDonViBi(String string) {
		idDonViBi = string;
	}

	/**
	 * @param string
	 */
	public void setIdDonViTh(String string) {
		idDonViTh = string;
	}

	/**
	 * @param string
	 */
	public void setLoai(String string) {
		loai = string;
	}

	/**
	 * @param string
	 */
	public void setMaKhTtkt(String string) {
		maKhTtkt = string;
	}

	/**
	 * @param string
	 */
	public void setNienDoTtkt(String string) {
		nienDoTtkt = string;
	}

	/**
	 * @param string
	 */
	public void setPathOwner(String string) {
		pathOwner = string;
	}

	/**
	 * @param string
	 */
	public void setThoiGianDuKien(String string) {
		thoiGianDuKien = string;
	}

	/**
	 * @return
	 */
	public Collection getDmNoiDungTTKT() {
		return dmNoiDungTTKT;
	}

	/**
	 * @param collection
	 */
	public void setDmNoiDungTTKT(Collection collection) {
		dmNoiDungTTKT = collection;
	}

	/**
	 * @return
	 */
	public String getNienDoDenNgay() {
		return nienDoDenNgay;
	}

	/**
	 * @return
	 */
	public String getNienDoTuNgay() {
		return nienDoTuNgay;
	}

	/**
	 * @param string
	 */
	public void setNienDoDenNgay(String string) {
		nienDoDenNgay = string;
	}

	/**
	 * @param string
	 */
	public void setNienDoTuNgay(String string) {
		nienDoTuNgay = string;
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
	public String[][] getSelectChiTietNoiDungTtkt() {
		return selectChiTietNoiDungTtkt;
	}

	/**
	 * @return
	 */
	public String[][] getSelectNoiDungTtkt() {
		return selectNoiDungTtkt;
	}

	/**
	 * @param strings
	 */
	public void setSelectChiTietNoiDungTtkt(String[][] strings) {
		selectChiTietNoiDungTtkt = strings;
	}

	/**
	 * @param string
	 */
	public void setSelectedIds(String string) {
		selectedNoiDungTtktIds = string;
	}

	/**
	 * @return
	 */
	public String getSelectedChiTietNoiDungTtktIds() {
		return selectedChiTietNoiDungTtktIds;
	}

	/**
	 * @return
	 */
	public String getSelectedNoiDungTtktIds() {
		return selectedNoiDungTtktIds;
	}

	/**
	 * @param string
	 */
	public void setSelectedChiTietNoiDungTtktIds(String string) {
		selectedChiTietNoiDungTtktIds = string;
	}

	/**
	 * @param string
	 */
	public void setSelectedNoiDungTtktIds(String string) {
		selectedNoiDungTtktIds = string;
	}

	/**
	 * @param strings
	 */
	public void setSelectNoiDungTtkt(String[][] strings) {
		selectNoiDungTtkt = strings;
	}

	/**
	 * @return
	 */
	public String getMaCqtChon() {
		return maCqtChon;
	}

	/**
	 * @param string
	 */
	public void setMaCqtChon(String string) {
		maCqtChon = string;
	}

	/**
	 * @return
	 */
	public String getPropertyOfUtilCombo() {
		return propertyOfUtilCombo;
	}

	/**
	 * @param string
	 */
	public void setPropertyOfUtilCombo(String string) {
		propertyOfUtilCombo = string;
	}

	/**
	 * @return
	 */
	public String getTrangThai() {
		return trangThai;
	}

	/**
	 * @param string
	 */
	public void setTrangThai(String string) {
		trangThai = string;
	}

	/**
	 * @return
	 */
	public String getThoiGianDuKienDenNgay() {
		return thoiGianDuKienDenNgay;
	}

	/**
	 * @return
	 */
	public String getThoiGianDuKienTuNgay() {
		return thoiGianDuKienTuNgay;
	}

	/**
	 * @param string
	 */
	public void setThoiGianDuKienDenNgay(String string) {
		thoiGianDuKienDenNgay = string;
	}

	/**
	 * @param string
	 */
	public void setThoiGianDuKienTuNgay(String string) {
		thoiGianDuKienTuNgay = string;
	}

	/**
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param string
	 */
	public void setType(String string) {
		type = string;
	}

	/**
	 * @return
	 */
	public String getIdCuocTtktTrongQd() {
		return IdCuocTtktTrongQd;
	}

	/**
	 * @param string
	 */
	public void setIdCuocTtktTrongQd(String string) {
		IdCuocTtktTrongQd = string;
	}

	/**
	 * @return
	 */
	public String getLoaiCuocTtkt() {
		return loaiCuocTtkt;
	}

	/**
	 * @param string
	 */
	public void setLoaiCuocTtkt(String string) {
		loaiCuocTtkt = string;
	}

	/**
	 * @return
	 */
	public String getIdCuocTtktTrongKh() {
		return IdCuocTtktTrongKh;
	}

	/**
	 * @param string
	 */
	public void setIdCuocTtktTrongKh(String string) {
		IdCuocTtktTrongKh = string;
	}

	/**
	 * @return
	 */
	public String getThoiDiem() {
		return thoiDiem;
	}

	/**
	 * @param string
	 */
	public void setThoiDiem(String string) {
		thoiDiem = string;
	}

	/**
	 * @return
	 */
	public String getMaCuocTtktTrongKh() {
		return maCuocTtktTrongKh;
	}

	/**
	 * @param string
	 */
	public void setMaCuocTtktTrongKh(String string) {
		maCuocTtktTrongKh = string;
	}

	/**
	 * @return
	 */
	public String getLoaiChinhSua() {
		return loaiChinhSua;
	}

	/**
	 * @param string
	 */
	public void setLoaiChinhSua(String string) {
		loaiChinhSua = string;
	}

	

	/**
	 * @return
	 */
	public String getLoaiCuocTtktKeHoachNam() {
		return loaiCuocTtktKeHoachNam;
	}

	/**
	 * @return
	 */
	public String getLoaiCuocTtktQuyetDinh() {
		return loaiCuocTtktQuyetDinh;
	}

	

	/**
	 * @param string
	 */
	public void setLoaiCuocTtktKeHoachNam(String string) {
		loaiCuocTtktKeHoachNam = string;
	}

	/**
	 * @param string
	 */
	public void setLoaiCuocTtktQuyetDinh(String string) {
		loaiCuocTtktQuyetDinh = string;
	}

	/**
	 * @return
	 */
	public String getIdCuocKhCu() {
		return idCuocKhCu;
	}

	/**
	 * @return
	 */
	public String getIdCuocKhMoi() {
		return idCuocKhMoi;
	}

	/**
	 * @return
	 */
	public String getIdCuocQdCu() {
		return idCuocQdCu;
	}

	/**
	 * @return
	 */
	public String getIdCuocQdMoi() {
		return idCuocQdMoi;
	}

	/**
	 * @param string
	 */
	public void setIdCuocKhCu(String string) {
		idCuocKhCu = string;
	}

	/**
	 * @param string
	 */
	public void setIdCuocKhMoi(String string) {
		idCuocKhMoi = string;
	}

	/**
	 * @param string
	 */
	public void setIdCuocQdCu(String string) {
		idCuocQdCu = string;
	}

	/**
	 * @param string
	 */
	public void setIdCuocQdMoi(String string) {
		idCuocQdMoi = string;
	}

	public String getNamKh() {
		return namKh;
	}

	public void setNamKh(String namKh) {
		this.namKh = namKh;
	}

	public String getDonVer() {
		return donVer;
	}

	public void setDonVer(String donVer) {
		this.donVer = donVer;
	}

}
