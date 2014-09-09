package cmc.com.ktnb.pl.hb.entity;

/**
 * KtnbDmTinh entity. @author MyEclipse Persistence Tools
 */

public class KtnbDmTinh extends cmc.com.ktnb.pl.hb.entity.PersistentObject
		implements java.io.Serializable {

	// Fields

	private String ma;
	private String ten;

	// Constructors

	/** default constructor */
	public KtnbDmTinh() {
	}

	/** minimal constructor */
	public KtnbDmTinh(String ma) {
		this.ma = ma;
	}

	/** full constructor */
	public KtnbDmTinh(String ma, String ten) {
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

}