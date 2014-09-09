package cmc.com.ktnb.pl.hb.entity;

/**
 * KntcBienBanId entity. @author MyEclipse Persistence Tools
 */

public class KntcBienBanId extends cmc.com.ktnb.pl.hb.entity.PersistentObject
		implements java.io.Serializable {

	// Fields

	private String maBb;
	private String maHs;

	// Constructors

	/** default constructor */
	public KntcBienBanId() {
	}

	/** full constructor */
	public KntcBienBanId(String maBb, String maHs) {
		this.maBb = maBb;
		this.maHs = maHs;
	}

	// Property accessors

	public String getMaBb() {
		return this.maBb;
	}

	public void setMaBb(String maBb) {
		this.maBb = maBb;
	}

	public String getMaHs() {
		return this.maHs;
	}

	public void setMaHs(String maHs) {
		this.maHs = maHs;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof KntcBienBanId))
			return false;
		KntcBienBanId castOther = (KntcBienBanId) other;

		return ((this.getMaBb() == castOther.getMaBb()) || (this.getMaBb() != null
				&& castOther.getMaBb() != null && this.getMaBb().equals(
				castOther.getMaBb())))
				&& ((this.getMaHs() == castOther.getMaHs()) || (this.getMaHs() != null
						&& castOther.getMaHs() != null && this.getMaHs()
						.equals(castOther.getMaHs())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMaBb() == null ? 0 : this.getMaBb().hashCode());
		result = 37 * result
				+ (getMaHs() == null ? 0 : this.getMaHs().hashCode());
		return result;
	}

}