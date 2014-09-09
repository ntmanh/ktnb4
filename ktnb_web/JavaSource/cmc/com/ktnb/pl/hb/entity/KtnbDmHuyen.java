package cmc.com.ktnb.pl.hb.entity;

/**
 * KtnbDmHuyen entity. @author MyEclipse Persistence Tools
 */

public class KtnbDmHuyen extends cmc.com.ktnb.pl.hb.entity.PersistentObject
		implements java.io.Serializable {

	// Fields

	private String ma;
	private String ten;
	private String maTinh;

	// Constructors

	/** default constructor */
	public KtnbDmHuyen() {
	}

	/** minimal constructor */
	public KtnbDmHuyen(String ma, String ten) {
		this.ma = ma;
		this.ten = ten;
	}

	/** full constructor */
	public KtnbDmHuyen(String ma, String ten, String maTinh) {
		this.ma = ma;
		this.ten = ten;
		this.maTinh = maTinh;
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

	public String getMaTinh() {
		return this.maTinh;
	}

	public void setMaTinh(String maTinh) {
		this.maTinh = maTinh;
	}

}