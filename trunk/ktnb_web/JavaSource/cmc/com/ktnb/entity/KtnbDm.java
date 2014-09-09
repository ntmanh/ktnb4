package cmc.com.ktnb.entity; 

import java.util.HashSet;
import java.util.Set;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * KtnbDm entity. @author MyEclipse Persistence Tools
 */

public class KtnbDm extends PersistentObject
implements java.io.Serializable{

	// Fields

	private String ma;
	private KtnbDm ktnbDm;
	private String ten;
	private Set ktnbDmTimes = new HashSet(0);
	private Set ktnbDms = new HashSet(0);

	// Constructors

	/** default constructor */
	public KtnbDm() {
	}

	/** minimal constructor */
	public KtnbDm(String ma, String ten) {
		this.ma = ma;
		this.ten = ten;
	}

	/** full constructor */
	public KtnbDm(String ma, KtnbDm ktnbDm, String ten, Set ktnbDmTimes,
			Set ktnbDms) {
		this.ma = ma;
		this.ktnbDm = ktnbDm;
		this.ten = ten;
		this.ktnbDmTimes = ktnbDmTimes;
		this.ktnbDms = ktnbDms;
	}

	// Property accessors

	public String getMa() {
		return this.ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public KtnbDm getKtnbDm() {
		return this.ktnbDm;
	}

	public void setKtnbDm(KtnbDm ktnbDm) {
		this.ktnbDm = ktnbDm;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Set getKtnbDmTimes() {
		return this.ktnbDmTimes;
	}

	public void setKtnbDmTimes(Set ktnbDmTimes) {
		this.ktnbDmTimes = ktnbDmTimes;
	}

	public Set getKtnbDms() {
		return this.ktnbDms;
	}

	public void setKtnbDms(Set ktnbDms) {
		this.ktnbDms = ktnbDms;
	}
	
}