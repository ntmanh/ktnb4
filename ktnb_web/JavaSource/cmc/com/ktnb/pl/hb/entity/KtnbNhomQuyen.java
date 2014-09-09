package cmc.com.ktnb.pl.hb.entity;


/**
 * KtnbNhomQuyen entity. @author MyEclipse Persistence Tools
 */

public class KtnbNhomQuyen extends cmc.com.ktnb.pl.hb.entity.PersistentObject
		implements java.io.Serializable {

	// Fields

	private Long maNhom;
	private String tenNhom;
	private String parent;
	private String moTa;
	private String maCqt;
	
	// Constructors

	/** default constructor */
	public KtnbNhomQuyen() {
	}

	/** minimal constructor */
	public KtnbNhomQuyen(Long maNhom) {
		this.maNhom = maNhom;		
	}

	public Long getMaNhom() {
		return this.maNhom;
	}

	public void setMaNhom(Long maNhom) {
		this.maNhom = maNhom;
	}

	public String getTenNhom() {
		return this.tenNhom;
	}

	public void setTenNhom(String tenNhom) {
		this.tenNhom = tenNhom;
	}

	public String getParent() {
		return this.parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}
	/**
	 * @return
	 */
	public String getMoTa() {
		return moTa;
	}

	/**
	 * @param string
	 */
	public void setMoTa(String string) {
		moTa = string;
	}

	/**
	 * @return
	 */
	public String getMaCqt() {
		return maCqt;
	}

	/**
	 * @param string
	 */
	public void setMaCqt(String string) {
		maCqt = string;
	}

}