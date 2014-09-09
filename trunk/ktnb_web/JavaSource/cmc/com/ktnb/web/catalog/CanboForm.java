/*
 * Created on Apr 18, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.catalog;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.web.BaseActionForm;

/**
 * @author Administrator
 */
public class CanboForm extends BaseActionForm {
	private String id;
	private String name;
	private String address;
	private String arrCqt;
	private String arrLhdn;
	public void reset(ActionMapping mapping,HttpServletRequest request) {
			super.reset(mapping,request);
//			id = null;
//			name=null;
//			address=null;
//			arrCqt=null;
//			arrLhdn=null;		
		}

	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param string
	 */
	public void setId(String string) {
		id = string;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getArrCqt() {
		return arrCqt;
	}

	public void setArrCqt(String arrCqt) {
		this.arrCqt = arrCqt;
	}

	public String getArrLhdn() {
		return arrLhdn;
	}

	public void setArrLhdn(String arrLhdn) {
		this.arrLhdn = arrLhdn;
	}
}
