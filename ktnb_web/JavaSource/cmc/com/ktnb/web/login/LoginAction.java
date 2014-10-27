package cmc.com.ktnb.web.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.KtnbCache;
import cmc.com.ktnb.util.KtnbDAO;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.web.LoginForm;

public class LoginAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginForm cbForm=(LoginForm) form;
		KtnbDAO ktnbDAO = KtnbUtil.getKtnbDAO();
		try {
			HttpSession session = request.getSession(false);
			if (session != null)
				session.invalidate();
			//String user = ((String) request.getParameter("user")).trim().toUpperCase();
			//String pass = ((String) request.getParameter("pass")).trim();
			String user=cbForm.getUserName().trim().toUpperCase();
			String pass=cbForm.getPassWord().trim().toUpperCase();
			ApplicationContext ac = null;
			if ("1".equals(Constants.USE_BTC))
				ac = ktnbDAO.authenticateBtc(user, pass);
			else
				ac = ktnbDAO.authenticate(user, pass);
			if (ac != null) {
				session = request.getSession(true);
				session.setAttribute(Constants.APP_CONTEXT, ac);
				KtnbCache.reLoad();//Reload cache khi login
				response.getWriter().write("{success:true,msg:\"ok\"}");
				request.setAttribute("login", "ok");
				//return mapping.findForward("success");
			} else {
				response.getWriter().write("{success:false,msg:\"ok\"}");
				request.setAttribute("login", "loi1");
				//return mapping.findForward("error");
			}
		} catch (Exception e) {
			response.getWriter().write("{success:false,msg:\"" + e.getMessage() + "\"}");
			request.setAttribute("login", "loi2");
		} finally {
			KtnbUtil.releaseKtnbDAO(ktnbDAO);
		}
		System.out.println("User Login!!!");
		return mapping.findForward("success");
	}
}
