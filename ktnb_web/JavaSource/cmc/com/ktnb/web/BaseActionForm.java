package cmc.com.ktnb.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.util.FormResetUtils;

public class BaseActionForm extends ActionForm {
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		FormResetUtils formUtil = new FormResetUtils();
		formUtil.resetForm(this,mapping,request,"cmc.com");
	}	
}
