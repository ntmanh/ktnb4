package cmc.com.ktnb.pl.hb.entity;
/**
 * KntcDmRls entity. @author MyEclipse Persistence Tools
 */
public class KntcDmRls extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
	// Cac loai Quan he voi Danh muc
	public static final String DE_XUAT_XU_LY_RLS = "04/KNTC";
	public static final String KE_HOACH_XAC_MINH = "11/KNTC";
	public static final String BAO_CAO_XAC_MINH = "23/KNTC";
	//	Fields 
	private KntcDmRlsId id;
	private String loaiRls;

	/**
	 * @return
	 */
	public KntcDmRlsId getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getLoaiRls() {
		return loaiRls;
	}

	/**
	 * @param id
	 */
	public void setId(KntcDmRlsId id) {
		this.id = id;
	}

	/**
	 * @param string
	 */
	public void setLoaiRls(String string) {
		loaiRls = string;
	}

}