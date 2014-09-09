package cmc.com.ktnb.pl.hb.entity;

/**
 * KntcPhanCongId entity. @author MyEclipse Persistence Tools
 */

public class KntcKquaXmDtlId extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {

	// Fields    

	private String maKq;
	private String noiDungMa;

	// Constructors

	/** default constructor */
	public KntcKquaXmDtlId() {
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof KntcKquaXmDtlId))
			return false;
		KntcKquaXmDtlId castOther = (KntcKquaXmDtlId) other;
		return (
			(this.getMaKq() == castOther.getMaKq()) || (this.getMaKq() != null && castOther.getMaKq() != null && this.getMaKq().equals(castOther.getMaKq())))
			&& ((this.getNoiDungMa() == castOther.getNoiDungMa())
				|| (this.getNoiDungMa() != null && castOther.getNoiDungMa() != null && this.getNoiDungMa().equals(castOther.getNoiDungMa())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMaKq() == null ? 0 : this.getMaKq().hashCode());
		result = 37 * result + (getNoiDungMa() == null ? 0 : this.getNoiDungMa().hashCode());
		return result;
	}
	/**
	 * @return
	 */
	public String getMaKq() {
		return maKq;
	}

	/**
	 * @return
	 */
	public String getNoiDungMa() {
		return noiDungMa;
	}

	/**
	 * @param string
	 */
	public void setMaKq(String string) {
		maKq = string;
	}

	/**
	 * @param string
	 */
	public void setNoiDungMa(String string) {
		noiDungMa = string;
	}

}