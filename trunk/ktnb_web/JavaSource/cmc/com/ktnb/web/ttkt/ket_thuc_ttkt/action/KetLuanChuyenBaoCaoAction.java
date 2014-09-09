package cmc.com.ktnb.web.ttkt.ket_thuc_ttkt.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.ket_thuc_ttkt.form.KetLuanChuyenBaoCaoForm;
import cmc.com.ktnb.web.ttkt.service.TtktService;

public class KetLuanChuyenBaoCaoAction extends BaseDispatchAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {		
		KetLuanChuyenBaoCaoForm testForm = (KetLuanChuyenBaoCaoForm)form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String method = request.getParameter("method");
		if("save".equals(method))
		{
			save(appContext,testForm,request,reponse);
		}else
		{
			testForm.setDcMoTa("Default mode");
		}
		return mapping.findForward("success");
	}
	private void save(ApplicationContext appContext, KetLuanChuyenBaoCaoForm testForm, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String type= request.getParameter("type");
		if("test".equals(type))
		{
			//TtktService.test(appContext, testForm);
		}		
	}
}
