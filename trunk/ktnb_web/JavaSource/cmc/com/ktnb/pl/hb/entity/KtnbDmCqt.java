package cmc.com.ktnb.pl.hb.entity;

/**
 * KtnbDmCqt entity. @author MyEclipse Persistence Tools
 */

public class KtnbDmCqt extends cmc.com.ktnb.pl.hb.entity.PersistentObject
		implements java.io.Serializable {

	// Fields

	private String ma;
	private String ten;
	private String tenVt;
	private String maHs;
	// Constructors

	/** default constructor */
	public KtnbDmCqt() {
	}

	/** full constructor */
	public KtnbDmCqt(String ma, String ten) {
		this.ma = ma;
		this.ten = ten;
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

	public String getTenVt() {
		return tenVt;
	}

	public void setTenVt(String tenVt) {
		this.tenVt = tenVt;
	}

	public String getMaHs() {
		return maHs;
	}

	public void setMaHs(String maHs) {
		this.maHs = maHs;
	}

}