package cmc.com.ktnb.util;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {
	private FilterConfig filterConfig = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Context context = Context.newInstance((HttpServletRequest) request);
		try {
			request.setCharacterEncoding("utf-8");
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			String uri = req.getRequestURI();
			String URI = uri.substring(uri.lastIndexOf("/") + 1);
			if (URI.equals("login.do") || URI.equals("loginAction.do") || URI.equals("thoat.do") || URI.equals("error.do") || URI.equals("right.do")) {
				chain.doFilter(request, response);
				return;
			}
			ApplicationContext ac = (ApplicationContext) session.getAttribute(Constants.APP_CONTEXT);
			if (ac == null || !ac.isValid())
				filterConfig.getServletContext().getRequestDispatcher("/login.do").forward(request, response);
			if (URI.equals("home.do") || URI.equals("index.do") || URI.equals("online.do") || URI.equals("pass.do")) {
				chain.doFilter(request, response);
				return;
			}
			// Check phan quyen chuc nang
			String queryString = req.getQueryString(), method = "*", act = "*";
			if (!Formater.isNull(queryString)) {
				String[] arri = queryString.split("&");
				String arr;
				for (int i = 0; i < arri.length; i++) {
					arr = arri[i];
					if (arr.startsWith("method="))
						method = arr.split("=")[1];
					else if (arr.startsWith("act=") || arr.startsWith("action="))
						act = arr.split("=")[1];
				}
			}
			String action = URI + "-" + method + "-" + act;
			HashMap map = (HashMap) KtnbCache.getInstance().get("MAP_FUNC");
			if (map.containsKey(action)) {
				System.out.println("Action: "+action+"---- Role: "+ac.getRole());
				String[] arri = ((String) map.get(action)).split(",");
				if (!KtnbUtil.findArr(arri, ac.getRole())) {
					filterConfig.getServletContext().getRequestDispatcher("/right.do").forward(request, response);
				}
			}
			
			// Check phan quyen chuc nang tu BTC
//			if(ac.getRole()==null || ac.getRole().length<1)
//				throw new KtnbException("Error! Access denied!","ERROR");
//			else{
//				for(int i=0; i<ac.getRole().length-1; i++){
//					String func = ac.getRole()[i];
//					if(!URI.equals(func))
//						filterConfig.getServletContext().getRequestDispatcher("/right.do").forward(request, response);
//				}
//			}
			
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(httpResponse) {
				public String encodeRedirectUrl(String url) {
					return url;
				}

				public String encodeRedirectURL(String url) {
					return url;
				}

				public String encodeUrl(String url) {
					return url;
				}

				public String encodeURL(String url) {
					return url;
				}
			};
			chain.doFilter(request, wrappedResponse);
			return;
		} catch (Exception e) {
			throw new ServletException(e);
		}
		finally{
			context.release();
		}
	}

}