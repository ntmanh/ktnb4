package cmc.com.ktnb.pl.hb.entity;

/**
 * KtnbPaHsRlsId entity. @author MyEclipse Persistence Tools
 */

public class KtnbPaHsRlsId extends cmc.com.ktnb.pl.hb.entity.PersistentObject
		implements java.io.Serializable {

	// Fields

	private String maHs;
	private String maPa;

	// Constructors

	/** default constructor */
	public KtnbPaHsRlsId() {
	}

	/** full constructor */
	public KtnbPaHsRlsId(String maHs, String maPa) {
		this.maHs = maHs;
		this.maPa = maPa;
	}

	// Property accessors

	public String getMaHs() {
		return this.maHs;
	}

	public void setMaHs(String maHs) {
		this.maHs = maHs;
	}

	public String getMaPa() {
		return this.maPa;
	}

	public void setMaPa(String maPa) {
		this.maPa = maPa;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof KtnbPaHsRlsId))
			return false;
		KtnbPaHsRlsId castOther = (KtnbPaHsRlsId) other;

		return ((this.getMaHs() == castOther.getMaHs()) || (this.getMaHs() != null
				&& castOther.getMaHs() != null && this.getMaHs().equals(
				castOther.getMaHs())))
				&& ((this.getMaPa() == castOther.getMaPa()) || (this.getMaPa() != null
						&& castOther.getMaPa() != null && this.getMaPa()
						.equals(castOther.getMaPa())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMaHs() == null ? 0 : this.getMaHs().hashCode());
		result = 37 * result
				+ (getMaPa() == null ? 0 : this.getMaPa().hashCode());
		return result;
	}

}