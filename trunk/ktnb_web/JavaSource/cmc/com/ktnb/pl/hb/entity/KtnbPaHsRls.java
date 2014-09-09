package cmc.com.ktnb.pl.hb.entity;


/**
 * KtnbPaHsRls entity. @author MyEclipse Persistence Tools
 */

public class KtnbPaHsRls extends cmc.com.ktnb.pl.hb.entity.PersistentObject
		implements java.io.Serializable {

	// Fields

	private KtnbPaHsRlsId id;
	private Long loaiRls;
	private String vaiTro;

	// Constructors

	/** default constructor */
	public KtnbPaHsRls() {
	}

	/** minimal constructor */
	public KtnbPaHsRls(KtnbPaHsRlsId id) {
		this.id = id;
	}

	/** full constructor */
	public KtnbPaHsRls(KtnbPaHsRlsId id, Long loaiRls, String vaiTro) {
		this.id = id;
		this.loaiRls = loaiRls;
		this.vaiTro = vaiTro;
	}

	// Property accessors

	public KtnbPaHsRlsId getId() {
		return this.id;
	}

	public void setId(KtnbPaHsRlsId id) {
		this.id = id;
	}

	public Long getLoaiRls() {
		return this.loaiRls;
	}

	public void setLoaiRls(Long loaiRls) {
		this.loaiRls = loaiRls;
	}

	public String getVaiTro() {
		return this.vaiTro;
	}

	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}

}