
package cmc.com.ktnb.web.ttkt.dung_chung.action;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.web.BaseDispatchAction;

/**
 * @@author ntdung1
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments 
 */
public class HomeAction extends BaseDispatchAction{ 
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{	
		ApplicationContext appContext = (ApplicationContext)request.getSession().getAttribute(Constants.APP_CONTEXT);
		switch(getManhom(appContext.getMaCanbo()))
		{
			case 8:
				return mapping.findForward("tbp");				
			case 9:
				return mapping.findForward("ttcq");				
			case 10:
				return mapping.findForward("td");				
			default:
				break;
		}
		return null; 
	}

	/**
	 * @@param string
	 * @@return
	 */
	private int getManhom(String string) throws Exception {
		int iResult = 0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
				
		try 
		{
			conn=DataSourceConfiguration.getConnection();
			String	sql = "select t.ma_nhom from ktnb_nsd_nhom t where t.ma_can_bo = '" + string + "'";
			ps=conn.prepareStatement(sql);			
			rs=ps.executeQuery();
			while(rs.next()){
				iResult = rs.getInt(1);
			}
		}
		catch (Exception e) {throw e;}
		finally {DataSourceConfiguration.releaseSqlResources(rs, ps, conn);}
		return iResult;
	}

}


