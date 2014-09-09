/*
 * Created on Oct 15, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.dung_chung.form;
import cmc.com.ktnb.entity.TTKT.dung_chung.KtnbKhTtkt;
import cmc.com.ktnb.web.BaseActionForm;

/**
 * @author ntdung1
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HomeForm extends BaseActionForm{
	KtnbKhTtkt ktnbKhTtkt;
	/**
	 * @return
	 */
	public KtnbKhTtkt getKtnbKhTtkt() {
		return ktnbKhTtkt;
	}

	/**
	 * @param ttkt
	 */
	public void setKtnbKhTtkt(KtnbKhTtkt ttkt) {
		ktnbKhTtkt = ttkt;
	}

}
