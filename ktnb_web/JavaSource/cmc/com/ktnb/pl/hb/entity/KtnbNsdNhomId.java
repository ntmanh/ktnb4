package cmc.com.ktnb.pl.hb.entity;

/**
 * KtnbNsdNhomId entity. @author MyEclipse Persistence Tools
 */

public class KtnbNsdNhomId extends cmc.com.ktnb.pl.hb.entity.PersistentObject
		implements java.io.Serializable {

	// Fields

	private Long maNhom;
	private String maCanBo;

	// Constructors

	/** default constructor */
	public KtnbNsdNhomId() {
	}

	/** full constructor */
	public KtnbNsdNhomId(Long maNhom, String maCanBo) {
		this.maNhom = maNhom;
		this.maCanBo = maCanBo;
	}

	// Property accessors

	public Long getMaNhom() {
		return this.maNhom;
	}

	public void setMaNhom(Long maNhom) {
		this.maNhom = maNhom;
	}

	public String getMaCanBo() {
		return this.maCanBo;
	}

	public void setMaCanBo(String maCanBo) {
		this.maCanBo = maCanBo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof KtnbNsdNhomId))
			return false;
		KtnbNsdNhomId castOther = (KtnbNsdNhomId) other;

		return ((this.getMaNhom() == castOther.getMaNhom()) || (this
				.getMaNhom() != null
				&& castOther.getMaNhom() != null && this.getMaNhom().equals(
				castOther.getMaNhom())))
				&& ((this.getMaCanBo() == castOther.getMaCanBo()) || (this
						.getMaCanBo() != null
						&& castOther.getMaCanBo() != null && this.getMaCanBo()
						.equals(castOther.getMaCanBo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMaNhom() == null ? 0 : this.getMaNhom().hashCode());
		result = 37 * result
				+ (getMaCanBo() == null ? 0 : this.getMaCanBo().hashCode());
		return result;
	}

}