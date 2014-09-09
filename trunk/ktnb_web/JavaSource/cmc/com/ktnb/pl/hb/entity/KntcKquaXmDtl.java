package cmc.com.ktnb.pl.hb.entity;

import cmc.com.ktnb.web.catalog.CatalogService;

/**
 * KntcKquaXmDtl entity. @author MyEclipse Persistence Tools
 */

public class KntcKquaXmDtl extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {

	public static final String BAO_CAO_XAC_MINH_TC = "23/KNTC";
	public static final String KET_LUAN_TC = "24/KNTC";
	// Fields    
	private String ma;
	private String maKq;
	private String noiDungMa;
	private String noiDungTen;
	private String nhanXet;
	private String loai;
	// Constructors

	/** default constructor */
	public KntcKquaXmDtl() {
	}
	public KntcKquaXmDtl(KntcDmRls aDm) {
		this.maKq = aDm.getId().getMaHs();
		this.noiDungMa = aDm.getId().getMaDm();
		try {
			this.noiDungTen = CatalogService.getTenDanhMucById(aDm.getId().getMaDm());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.nhanXet="";
	}

	public String getNoiDungMa() {
		return this.noiDungMa;
	}

	public void setNoiDungMa(String noiDungMa) {
		this.noiDungMa = noiDungMa;
	}

	public String getNoiDungTen() {
		return this.noiDungTen;
	}

	public void setNoiDungTen(String noiDungTen) {
		this.noiDungTen = noiDungTen;
	}
	/**
	 * @return
	 */
	public String getMa() {
		return ma;
	}

	/**
	 * @return
	 */
	public String getMaKq() {
		return maKq;
	}

	/**
	 * @return
	 */
	public String getNhanXet() {
		return nhanXet;
	}

	/**
	 * @param string
	 */
	public void setMa(String string) {
		ma = string;
	}

	/**
	 * @param string
	 */
	public void setMaKq(String string) {
		maKq = string;
	}

	/**
	 * @param string
	 */
	public void setNhanXet(String string) {
		nhanXet = string;
	}

	/**
	 * @return
	 */
	public String getLoai() {
		return loai;
	}

	/**
	 * @param string
	 */
	public void setLoai(String string) {
		loai = string;
	}

}