package cmc.com.ktnb.pl.hb.entity;

/**
 * KntcBienBanId entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TtcpBaoCaoId extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {

	// Fields

	private String maCqt;

	private Integer thang;

	private Integer nam;

	// Constructors

	/** default constructor */
	public TtcpBaoCaoId() {
	}

	/** full constructor */
	public TtcpBaoCaoId(String maCqt, Integer thang, Integer nam) {
		this.maCqt = maCqt;
		this.nam = nam;
		this.thang = thang;
	}

	public String getMaCqt() {
		return maCqt;
	}

	public void setMaCqt(String maCqt) {
		this.maCqt = maCqt;
	}

	public Integer getNam() {
		return nam;
	}

	public void setNam(Integer nam) {
		this.nam = nam;
	}

	public Integer getThang() {
		return thang;
	}

	public void setThang(Integer thang) {
		this.thang = thang;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TtcpBaoCaoId))
			return false;
		TtcpBaoCaoId castOther = (TtcpBaoCaoId) other;
		try {
			if (!castOther.getMaCqt().equals(this.maCqt))
				return false;
			if (!castOther.getThang().equals(this.thang))
				return false;
			if (!castOther.getNam().equals(this.nam))
				return false;
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		int result = 17;
		result = 37 * result + (this.getMaCqt() == null ? 0 : this.getMaCqt().hashCode());
		result = 37 * result + (this.getThang() == null ? 0 : this.getThang().hashCode());
		result = 37 * result + (this.getNam() == null ? 0 : this.getNam().hashCode());
		return result;
	}

}