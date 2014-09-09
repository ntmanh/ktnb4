package cmc.com.ktnb.entity.TTKT.dung_chung;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * KtnbKhTtktNd entity. @author MyEclipse Persistence Tools
 */

public class KtnbKhTtktNd extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idKhTtkt;
	private String idDmNoiDungTtkt;

	// Constructors

	/** default constructor */
	public KtnbKhTtktNd() {
	}

	/** minimal constructor */
	public KtnbKhTtktNd(String id) {
		this.id = id;
	}

	/** full constructor */
	public KtnbKhTtktNd(String id, String idKhTtkt, String idDmNoiDungTtkt) {
		this.id = id;
		this.idKhTtkt = idKhTtkt;
		this.idDmNoiDungTtkt = idDmNoiDungTtkt;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdKhTtkt() {
		return this.idKhTtkt;
	}

	public void setIdKhTtkt(String idKhTtkt) {
		this.idKhTtkt = idKhTtkt;
	}

	public String getIdDmNoiDungTtkt() {
		return this.idDmNoiDungTtkt;
	}

	public void setIdDmNoiDungTtkt(String idDmNoiDungTtkt) {
		this.idDmNoiDungTtkt = idDmNoiDungTtkt;
	}

}