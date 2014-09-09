package cmc.com.ktnb.web.login;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.util.Constants;

public class IndexAction extends Action 
{
	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)	throws Exception 
	{
		//DynaActionForm f=(DynaActionForm) form;
		//String tab=(String) f.get("tab");
		HttpSession session = request.getSession();
		if (session != null)
		{
			Enumeration attributeNames = session.getAttributeNames();
			if (attributeNames != null)
			{
				String name; 
				while (attributeNames.hasMoreElements())
				{
					name = attributeNames.nextElement().toString();	
					if(!name.equals(Constants.APP_CONTEXT))	session.removeAttribute(name);						
				}
			}
		}
		return mapping.findForward("success");
		// ntdung1: Dung trang chu cua ktnb
	}
}
