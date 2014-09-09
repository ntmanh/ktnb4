/*
 * Created on Dec 20, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.dung_chung.form;

import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhNoiDungTtkt;
import cmc.com.ktnb.web.BaseActionForm;

/**
 * @author Nguyen Tien Dung
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NoiDungTtktForm extends BaseActionForm {
	private TtktKhCuocTtkt[] dsTtktCqtTrucThuoc;
	private TtktKhNoiDungTtkt[] dsNoiDungTtkt;
	private String noiDungTtktGoc;
	private TtktKhNoiDungTtkt[] arrNoiDungTtktCqtTrucThuoc;
	

	/**
	 * @return
	 */
	public String getNoiDungTtktGoc() {
		return noiDungTtktGoc;
	}

	/**
	 * @param string
	 */
	public void setNoiDungTtktGoc(String string) {
		noiDungTtktGoc = string;
	}

	/**
	 * @return
	 */
	public TtktKhNoiDungTtkt[] getDsNoiDungTtkt() {
		return dsNoiDungTtkt;
	}

	/**
	 * @return
	 */
	public TtktKhCuocTtkt[] getDsTtktCqtTrucThuoc() {
		return dsTtktCqtTrucThuoc;
	}

	/**
	 * @param ttkts
	 */
	public void setDsNoiDungTtkt(TtktKhNoiDungTtkt[] ttkts) {
		dsNoiDungTtkt = ttkts;
	}

	/**
	 * @param ttkts
	 */
	public void setDsTtktCqtTrucThuoc(TtktKhCuocTtkt[] ttkts) {
		dsTtktCqtTrucThuoc = ttkts;
	}

	/**
	 * @return
	 */
	public TtktKhNoiDungTtkt[] getArrNoiDungTtktCqtTrucThuoc() {
		return arrNoiDungTtktCqtTrucThuoc;
	}

	/**
	 * @param ttkts
	 */
	public void setArrNoiDungTtktCqtTrucThuoc(TtktKhNoiDungTtkt[] ttkts) {
		arrNoiDungTtktCqtTrucThuoc = ttkts;
	}

}
