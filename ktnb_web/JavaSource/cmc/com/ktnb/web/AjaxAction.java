package cmc.com.ktnb.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.KtnbCache;
import cmc.com.ktnb.util.KtnbDAO;
import cmc.com.ktnb.util.KtnbUtil;

public class AjaxAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		KtnbDAO ktnbDAO = KtnbUtil.getKtnbDAO();
		try {
			String method = (String) request.getParameter("method");
			String id = (String) request.getParameter("id");
			String msg = null, name = null;
			if ("refreshStaff".equals(method)) {
				ktnbDAO.refreshDMCanBo(id);
				msg = "\u0110\u00E3 \u0111\u1ED3ng b\u1ED9 danh s\u00E1ch CB database : " + id;
			} else if ("refreshDept".equals(method)) {
				ktnbDAO.refreshDMPhong(id);
				msg = "\u0110\u00E3 \u0111\u1ED3ng b\u1ED9 danh s\u00E1ch ph\u00F2ng ban database : " + id;
			} else if ("refreshCache".equals(method)) {
				KtnbCache.reLoad();
				msg = "Reload Cache!";
			} else if ("insdm".equals(method)) {
				name = (String) request.getParameter("name");
				msg = ktnbDAO.insertDM(id, name);
			} else if ("upddm".equals(method)) {
				name = (String) request.getParameter("name");
				ktnbDAO.updateDM(id, name);
			} else if ("movedm".equals(method)) {
				name = (String) request.getParameter("newparentid");
				ktnbDAO.moveDM(id, name);
			} else if ("updRoleData".equals(method)) {
				name = (String) request.getParameter("role");
				ktnbDAO.updUserDataRole(id, name);
				msg = "Ng\u01B0\u1EDDi s\u1EED d\u1EE5ng \u0111\u00E3 \u0111\u01B0\u1EE3c ph\u00E2n quy\u1EC1n!";
			} else if ("updrole".equals(method)) {
				name = (String) request.getParameter("role");
				ktnbDAO.updUserRole(id, name);
				msg = "Ng\u01B0\u1EDDi s\u1EED d\u1EE5ng \u0111\u00E3 \u0111\u01B0\u1EE3c ph\u00E2n quy\u1EC1n!";
			} else if ("create_user".equals(method)) {
				ktnbDAO.createUser(id);
				msg = "\u0110\u00E3 t\u1EA1o NSD c\u00F3 m\u00E3 CB : " + id;
			} else if ("delete_user".equals(method)) {
				ktnbDAO.delCanBo(id);
				msg = "\u0110\u00E3 x\u00F3a c\u00F3 m\u00E3 CB : " + id;
			} else if ("lock_user".equals(method)) {
				ktnbDAO.lockUser(id);
				msg = "\u0110\u00E3 kh\u00F3a NSD c\u00F3 m\u00E3 CB : " + id;
			} else if ("unlock_user".equals(method)) {
				ktnbDAO.unLockUser(id);
				msg = "\u0110\u00E3 m\u1EDF kh\u00F3a NSD c\u00F3 m\u00E3 CB : " + id;
			}else if ("chonNsd".equals(method)) {
				name = (String) request.getParameter("name");
				ktnbDAO.chonNsd(id,name);
				msg = "C\u1EADp nh\u1EADt th\u00E0nh c\u00F4ng";
			}else if ("reset".equals(method)) {
				if ("1".equals(Constants.USE_BTC)){
					ktnbDAO.changePasswordBtc(id,"123456");
				}else{
					ktnbDAO.changePassword(id,"123456");
				}
				msg = "C\u1EADp nh\u1EADt th\u00E0nh c\u00F4ng";
			}
			msg = "{success:true,msg:\"" + msg + "\"}";
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(msg);
		} catch (Exception e) {
			throw e;
		} finally {
			KtnbUtil.releaseKtnbDAO(ktnbDAO);
		}
		return null;
	}
}
