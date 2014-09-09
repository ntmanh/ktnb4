/*
 * Created on Nov 4, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.dung_chung.form;



import java.util.Collection;

import cmc.com.ktnb.pl.hb.entity.KtnbDmCqt;
import cmc.com.ktnb.web.BaseActionForm;

/**
 * @author ntdung1
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TimKiemCqtForm extends BaseActionForm{
	private KtnbDmCqt[] arrCuc;
	private KtnbDmCqt[] arrChiCuc;
	private KtnbDmCqt[] arrDoi;
	private int level;
	private String maCqtChon;
	private String maCqt;
	private String tenCqt;	
	private Collection arrSearchResult;

	/**
	 * @return
	 */
	public KtnbDmCqt[] getArrChiCuc() {
		return arrChiCuc;
	}

	/**
	 * @return
	 */
	public KtnbDmCqt[] getArrCuc() {
		return arrCuc;
	}

	/**
	 * @return
	 */
	public KtnbDmCqt[] getArrDoi() {
		return arrDoi;
	}

	/**
	 * @param cqts
	 */
	public void setArrChiCuc(KtnbDmCqt[] cqts) {
		arrChiCuc = cqts;
	}

	/**
	 * @param cqts
	 */
	public void setArrCuc(KtnbDmCqt[] cqts) {
		arrCuc = cqts;
	}

	/**
	 * @param cqts
	 */
	public void setArrDoi(KtnbDmCqt[] cqts) {
		arrDoi = cqts;
	}

	/**
	 * @return
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @return
	 */
	public String getMaCqtChon() {
		return maCqtChon;
	}

	/**
	 * @param i
	 */
	public void setLevel(int i) {
		level = i;
	}

	/**
	 * @param string
	 */
	public void setMaCqtChon(String string) {
		maCqtChon = string;
	}

	/**
	 * @return
	 */
	public String getMaCqth() {
		return maCqt;
	}

	/**
	 * @return
	 */
	public String getTenCqt() {
		return tenCqt;
	}

	/**
	 * @param string
	 */
	public void setMaCqth(String string) {
		maCqt = string;
	}

	/**
	 * @param string
	 */
	public void setTenCqt(String string) {
		tenCqt = string;
	}

	

	/**
	 * @return
	 */
	public String getMaCqt() {
		return maCqt;
	}

	
	/**
	 * @param string
	 */
	public void setMaCqt(String string) {
		maCqt = string;
	}

	/**
	 * @return
	 */
	public Collection getArrSearchResult() {
		return arrSearchResult;
	}

	/**
	 * @param cqts
	 */
	public void setArrSearchResult(Collection cqts) {
		arrSearchResult = cqts;
	}


}
