package cmc.com.ktnb.pl.hb.entity;

/**
 * KtnbNhomChucNangId entity. @author MyEclipse Persistence Tools
 */

public class KtnbNhomChucNangId extends cmc.com.ktnb.pl.hb.entity.PersistentObject
		implements java.io.Serializable {

	// Fields

	private String maChucNang;
	private Long maNhom;

	// Constructors

	/** default constructor */
	public KtnbNhomChucNangId() {
	}

	/** full constructor */
	public KtnbNhomChucNangId(String maChucNang, Long maNhom) {
		this.maChucNang = maChucNang;
		this.maNhom = maNhom;
	}

	// Property accessors

	public String getMaChucNang() {
		return this.maChucNang;
	}

	public void setMaChucNang(String maChucNang) {
		this.maChucNang = maChucNang;
	}

	public Long getMaNhom() {
		return this.maNhom;
	}

	public void setMaNhom(Long maNhom) {
		this.maNhom = maNhom;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof KtnbNhomChucNangId))
			return false;
		KtnbNhomChucNangId castOther = (KtnbNhomChucNangId) other;

		return ((this.getMaChucNang() == castOther.getMaChucNang()) || (this
				.getMaChucNang() != null
				&& castOther.getMaChucNang() != null && this.getMaChucNang()
				.equals(castOther.getMaChucNang())))
				&& ((this.getMaNhom() == castOther.getMaNhom()) || (this
						.getMaNhom() != null
						&& castOther.getMaNhom() != null && this.getMaNhom()
						.equals(castOther.getMaNhom())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getMaChucNang() == null ? 0 : this.getMaChucNang()
						.hashCode());
		result = 37 * result
				+ (getMaNhom() == null ? 0 : this.getMaNhom().hashCode());
		return result;
	}

}