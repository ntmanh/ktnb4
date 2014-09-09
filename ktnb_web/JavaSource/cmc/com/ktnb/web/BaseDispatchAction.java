package cmc.com.ktnb.web;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.actions.DispatchAction;
public class BaseDispatchAction extends DispatchAction {
	
	public BaseDispatchAction() {
		super();
		
	}
	public String getUrl(HttpServletRequest arg, String methodName) {
		String url = arg.getRequestURI();
		if (url.indexOf(methodName) < 0) {
			if (url.indexOf("?") > 0)
				url = url + "&method=" + methodName;
			else
				url = url + "?method=" + methodName;
		}
		return url;
	}
}
