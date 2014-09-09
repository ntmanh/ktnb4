package cmc.com.ktnb.web.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.web.BaseAction;
public class LogoutAction extends BaseAction 
{
	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession(false);
		if(session != null) session.invalidate(); 
		System.out.println("User Logout!!!");
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		if(appContext!= null){
			System.out.println("Appcontext is not released!");
		}
		return mapping.findForward("success");
	}	
}
