package cmc.com.ktnb.web.ttkt.ket_thuc_ttkt.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.web.BaseDispatchAction;



/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */
public class ChuyenGiaoHsvvChoCqDieuTraAction extends BaseDispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		
		return mapping.findForward("success");
	}
	
}
