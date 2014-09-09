package cmc.com.ktnb.pl.hb.entity;

/**
 * KntcPhieuChuyenDonId entity. @author MyEclipse Persistence Tools
 */

public class KntcPhieuChuyenDonId implements java.io.Serializable {

	// Fields

	private String maPhieu;
	private String maHs;

	// Constructors

	/** default constructor */
	public KntcPhieuChuyenDonId() {
	}

	/** full constructor */
	public KntcPhieuChuyenDonId(String maPhieu, String maHs) {
		this.maPhieu = maPhieu;
		this.maHs = maHs;
	}

	// Property accessors

	public String getMaPhieu() {
		return this.maPhieu;
	}

	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
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
		if (!(other instanceof KntcPhieuChuyenDonId))
			return false;
		KntcPhieuChuyenDonId castOther = (KntcPhieuChuyenDonId) other;

		return ((this.getMaPhieu() == castOther.getMaPhieu()) || (this
				.getMaPhieu() != null
				&& castOther.getMaPhieu() != null && this.getMaPhieu().equals(
				castOther.getMaPhieu())))
				&& ((this.getMaHs() == castOther.getMaHs()) || (this.getMaHs() != null
						&& castOther.getMaHs() != null && this.getMaHs()
						.equals(castOther.getMaHs())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMaPhieu() == null ? 0 : this.getMaPhieu().hashCode());
		result = 37 * result
				+ (getMaHs() == null ? 0 : this.getMaHs().hashCode());
		return result;
	}

}