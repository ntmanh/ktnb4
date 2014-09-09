package cmc.com.ktnb.exception;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

import cmc.com.ktnb.util.Formater;

public class KtnbExceptionHandler extends ExceptionHandler
{	
	public ActionForward execute(Exception ex, ExceptionConfig exConf, ActionMapping mapping, 
                ActionForm form,HttpServletRequest request, HttpServletResponse response)	{
		KtnbException idme = null;	
		System.out.println(ex.toString());	
		if (ex instanceof KtnbException)	{
			idme = (KtnbException) ex;
		}
		else {
			idme = new KtnbException(ex);
		}
		//System.err.println(ex.getMessage());
		request.setAttribute("errCodeCause", idme.getAdditionalInfor());
		request.setAttribute("errCodeAction", idme.getSolution());
		String errCode = null;
		if(idme.getCode()!=null)
			errCode = idme.getCode();
		else if(idme.getCause()!=null)
			errCode = idme.getCause().toString();
		if(errCode!=null)
			System.out.println("errCode: "+errCode);
		else
			System.out.println("errCode is null!!!");			
		if(errCode!=null && errCode.indexOf("connection")>0)		     
			request.setAttribute("errCode", "KHONG KET NOI DUOC VOI DATABASE SERVER!");			
		else {
			System.out.println("Loi k xac dinh!!!!");
			if(!Formater.isNull(errCode)){
				if(errCode.indexOf("ORA-00001")>0)
					errCode = errCode.substring(errCode.indexOf("ORA-00001")); 
				request.setAttribute("errCode", errCode.replaceAll("\n",""));
			}else 
				request.setAttribute("errCode", ex.toString());
		}		
		return mapping.findForward("error");
	}
}