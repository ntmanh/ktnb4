package cmc.com.ktnb.web.kntc.xu_ly;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;

public abstract class PrintAction extends BaseDispatchAction{
	protected abstract String getDocInName(HttpServletRequest request);
	protected abstract String getDocOutName(HttpServletRequest request);
	protected abstract String getFileOutName(HttpServletRequest request);
	public void exportDoc(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		//String fileIn= request.getRealPath("/docin")+ "\\TTNB_tb_khong_thu_ly_giai_quyet.doc";
		//String fileOut=request.getRealPath("/docout")+ "\\TTNB_tb_khong_thu_ly_giai_quyet_Out"+System.currentTimeMillis()+request.getSession().getId()+".doc";
		String fileIn=getDocInName(request);
		String fileOut=getDocOutName(request);
		ApplicationContext appContext=(ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		MsWordUtils word = new MsWordUtils(fileIn, fileOut);
		try {
			word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
			pushData(word,request,form);
			word.saveAndClose();
			word.downloadFile(fileOut, getFileOutName(request), ".doc", response);
		} catch (Exception ex) {
			// ex.printStackTrace();
			System.out.println("Download Error: " + ex.getMessage());
		} finally {
			try{
			word.saveAndClose();
			}catch(Exception ex){}
		}
	}
	public abstract void pushData(MsWordUtils word,HttpServletRequest request,ActionForm form) throws Exception;
}
