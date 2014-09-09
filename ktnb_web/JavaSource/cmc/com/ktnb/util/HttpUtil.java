package cmc.com.ktnb.util;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.MultipartRequestWrapper;

public class HttpUtil 
{
  public static void doForward(String uri, HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException,Exception 
  {
    try 
    {
		if (uri.indexOf("%")==-1)
		{      
		  uri = URLUTF8Encoder.encode(uri);
		  uri = StringUtils.replace(uri,"%2f","/");
		  uri = StringUtils.replace(uri,"%3f","?");
		  uri = StringUtils.replace(uri,"%3d","=");
		  uri = StringUtils.replace(uri,"%26","&");
		  uri = StringUtils.replace(uri,"%3b",";");
		  uri = StringUtils.replace(uri,"%27","'");
		}
		if (request instanceof MultipartRequestWrapper)    request = ((MultipartRequestWrapper) request).getRequest();
		RequestDispatcher rd = request.getSession().getServletContext().getRequestDispatcher(uri);
		if (rd == null)  throw new Exception("uri invalid "+uri);
		rd.forward(request, response);
	}
	catch (Exception e) 
	{		
		e.printStackTrace();
		response.sendRedirect(uri);
	}
  }
  public static String getFullURL(HttpServletRequest request) {
	    StringBuffer requestURL = request.getRequestURL();
	    String queryString = request.getQueryString();

	    if (queryString == null) {
	        return requestURL.toString();
	    } else {
	        return requestURL.append('?').append(queryString).toString();
	    }
	}
}