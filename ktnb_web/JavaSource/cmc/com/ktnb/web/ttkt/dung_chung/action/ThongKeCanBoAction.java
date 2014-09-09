package cmc.com.ktnb.web.ttkt.dung_chung.action;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.KtnbTkCanBo;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.dung_chung.form.ThongKeCanBoForm;
import cmc.com.ktnb.web.ttkt.service.TtktService;

public class ThongKeCanBoAction extends BaseDispatchAction{
public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
	ThongKeCanBoForm myform = (ThongKeCanBoForm)form;
	Collection ktnbCanBo = TtktService.getThongKeCanBo(appContext);
	for (Iterator iter = ktnbCanBo.iterator(); iter.hasNext();) {
		KtnbTkCanBo element = (KtnbTkCanBo) iter.next();
		myform.toForm(element);
		break;
	}
	if(KtnbUtil.isCuc(appContext)){
		request.setAttribute("isCuc","yes");
	}
	return mapping.findForward("view");
}
public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
	ThongKeCanBoForm myform = (ThongKeCanBoForm)form;
	if(Formater.isNull(myform.getMa())){
		myform.setMa(KeyManagement.GUID(appContext));
	}
	if(Formater.isNull(myform.getMa_cqt())){
		myform.setMa_cqt(appContext.getMaCqt());
		myform.setTen_cqt(appContext.getTenCqt());
	}
	if(TtktService.saveThongKeCanBo(appContext,myform.toEntity())){
		request.setAttribute("success", "ok");
	}
	if(KtnbUtil.isCuc(appContext)){
		request.setAttribute("isCuc","yes");
	}
	return mapping.findForward("save");
}
}
