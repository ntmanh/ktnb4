package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;

import java.util.HashSet;
import java.util.Set;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktThNoiDungPhucTra entity. @author MyEclipse Persistence Tools
 */

public class TtktThNoiDungPhucTra extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idNoiDung;
	private String tenNoiDung;
	private String idPhucTra;
	private String loaiND;
	
	public static String IdNoiDung="idNoiDung";
	// Constructors

	public String getIdPhucTra() {
		return idPhucTra;
	}

	public void setIdPhucTra(String idPhucTra) {
		this.idPhucTra = idPhucTra;
	}

	/** default constructor */
	public TtktThNoiDungPhucTra() {
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getIdNoiDung() {
		return this.idNoiDung;
	}

	public void setIdNoiDung(String idNoiDung) {
		this.idNoiDung = idNoiDung;
	}

	public String getTenNoiDung() {
		return this.tenNoiDung;
	}

	public void setTenNoiDung(String tenNoiDung) {
		this.tenNoiDung = tenNoiDung;
	}

	public String getLoaiND() {
		return loaiND;
	}

	public void setLoaiND(String loaiND) {
		this.loaiND = loaiND;
	}



}