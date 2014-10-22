package cmc.com.ktnb.entity.TTKT.dung_chung;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * KtnbChiTietNoiDungTtkt entity. @author MyEclipse Persistence Tools
 */

public class TtktKhChiTietNoiDungTtkt extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idNoiDungTtkt;
	private String idNoiDungChiTiet;
	private String tenNoiDungChiTiet;
	private String maNoiDungChiTiet;

	// Static field
	public static String Id = "id";
	public static String IdNoiDungTtkt = "idNoiDungTtkt";
	public static String IdNoiDungChiTiet = "idNoiDungChiTiet";
	public static String TenNoiDungChiTiet = "tenNoiDungChiTiet";

	// Constructors

	/** default constructor */
	public TtktKhChiTietNoiDungTtkt() {
	}

	/** full constructor */
	public TtktKhChiTietNoiDungTtkt(String id, String idNoiDungTtkt, String idNoiDungChiTiet, String tenNoiDungChiTiet, String maNoiDungChiTiet) {
		this.id = id;
		this.idNoiDungTtkt = idNoiDungTtkt;
		this.idNoiDungChiTiet = idNoiDungChiTiet;
		this.tenNoiDungChiTiet = tenNoiDungChiTiet;
		this.maNoiDungChiTiet= maNoiDungChiTiet;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdNoiDungTtkt() {
		return this.idNoiDungTtkt;
	}

	public void setIdNoiDungTtkt(String idNoiDungTtkt) {
		this.idNoiDungTtkt = idNoiDungTtkt;
	}

	public String getIdNoiDungChiTiet() {
		return this.idNoiDungChiTiet;
	}

	public void setIdNoiDungChiTiet(String idNoiDungChiTiet) {
		this.idNoiDungChiTiet = idNoiDungChiTiet;
	}

	public String getTenNoiDungChiTiet() {
		return this.tenNoiDungChiTiet;
	}

	public void setTenNoiDungChiTiet(String tenNoiDungChiTiet) {
		this.tenNoiDungChiTiet = tenNoiDungChiTiet;
	}

	public String getMaNoiDungChiTiet() {
		return maNoiDungChiTiet;
	}

	public void setMaNoiDungChiTiet(String maNoiDungChiTiet) {
		this.maNoiDungChiTiet = maNoiDungChiTiet;
	}
	
}