package cmc.com.ktnb.web.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.KtnbDAO;
import cmc.com.ktnb.util.KtnbUtil;

public class PassAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		KtnbDAO ktnbDAO = KtnbUtil.getKtnbDAO();
		try {
			ApplicationContext ac = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
			String maCanbo = ac.getMaCanbo();

			String pass = ((String) request.getParameter("pass1"));
			if (pass != null) {
				if ("1".equals(Constants.USE_BTC)){
					ktnbDAO.changePasswordBtc(maCanbo, pass);
				}else{
					ktnbDAO.changePassword(maCanbo, pass);
				}
				response.getWriter().write("{success:true,msg:\"ok\"}");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			KtnbUtil.releaseKtnbDAO(ktnbDAO);
		}
		return mapping.findForward("success");
	}
}
