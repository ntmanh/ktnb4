/*
 * Created on Nov 18, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.ke_hoach_nam.form;

import cmc.com.ktnb.web.BaseActionForm;

/**
 * @author ntdung1
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class KeHoachNamCqtCapDuoiForm extends BaseActionForm {
	private String selectedCqt;	
	private String namKeHoach;

	/**
	 * @return
	 */
	public String getSelectedCqt() {
		return selectedCqt;
	}

	/**
	 * @param string
	 */
	public void setSelectedCqt(String string) {
		selectedCqt = string;
	}

	/**
	 * @return
	 */
	public String getNamKeHoach() {
		return namKeHoach;
	}

	/**
	 * @param string
	 */
	public void setNamKeHoach(String string) {
		namKeHoach = string;
	}

}
