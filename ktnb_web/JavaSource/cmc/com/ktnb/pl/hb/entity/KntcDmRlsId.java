package cmc.com.ktnb.pl.hb.entity;



/**
 * KntcDmRlsId entity. @author MyEclipse Persistence Tools
 */

public class KntcDmRlsId extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {


    // Fields    

     private String maHs;
     private String maDm;
	/**
	 * @return
	 */
	public String getMaDm() {
		return maDm;
	}

	/**
	 * @return
	 */
	public String getMaHs() {
		return maHs;
	}

	/**
	 * @param string
	 */
	public void setMaDm(String string) {
		maDm = string;
	}

	/**
	 * @param string
	 */
	public void setMaHs(String string) {
		maHs = string;
	}

}