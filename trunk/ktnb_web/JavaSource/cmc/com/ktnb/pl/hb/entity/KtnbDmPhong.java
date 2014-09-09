package cmc.com.ktnb.pl.hb.entity;

/**
 * KtnbDmPhong entity. @author MyEclipse Persistence Tools
 */

public class KtnbDmPhong extends cmc.com.ktnb.pl.hb.entity.PersistentObject
		implements java.io.Serializable {

	// Fields

	private String ma;
	private String ten;
	private String maCqt;

	// Constructors

	/** default constructor */
	public KtnbDmPhong() {
	}

	/** minimal constructor */
	public KtnbDmPhong(String ma) {
		this.ma = ma;
	}

	/** full constructor */
	public KtnbDmPhong(String ma, String ten, String maCqt) {
		this.ma = ma;
		this.ten = ten;
		this.maCqt = maCqt;
	}

	// Property accessors

	public String getMa() {
		return this.ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMaCqt() {
		return this.maCqt;
	}

	public void setMaCqt(String maCqt) {
		this.maCqt = maCqt;
	}

}