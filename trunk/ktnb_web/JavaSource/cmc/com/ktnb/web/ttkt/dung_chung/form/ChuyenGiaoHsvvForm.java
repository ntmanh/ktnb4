/*
 * Created on Oct 15, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.dung_chung.form;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.TTKT.dung_chung.KtnbKhTtkt;

/**
 * @author ntdung1
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ChuyenGiaoHsvvForm extends NoiDungTtktForm {
	/**
	 * @author ntdung1
	 *
	 * To change the template for this generated type comment go to
	 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
	}
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

	private String nienDoTuNgay;
	private String nienDoDenNgay;
	private String donViBiName;
	private String donViThName;
	private String[][] selectNoiDungTtkt;
	private String[][] selectChiTietNoiDungTtkt;
	private String selectedNoiDungTtktIds;
	private String selectedChiTietNoiDungTtktIds;
	private String maCqtChon;
	

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

}
