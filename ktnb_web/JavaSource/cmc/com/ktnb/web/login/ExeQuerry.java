package cmc.com.ktnb.web.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.KtnbDAO;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.web.BaseDispatchAction;

public class ExeQuerry extends BaseDispatchAction {
	private Connection conn = null;

	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		if(!appContext.getTenNsd().toUpperCase().equals("INTERNAL")){
			throw new KtnbException("B&#7841;n kh&#244;ng &#273;&#7911; th&#7849;m quy&#7873;n &#273;&#7875; v&#224;o ch&#7913;c n&#259;ng n&#224;y!", "", "Kh&#244;ng c&#243; gi&#7843;i ph&#225;p n&#224;o cho t&#236;nh hu&#7889;ng n&#224;y!!!");
		}
		return mapping.findForward("success");
	}

	public ActionForward exe(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		KtnbDAO ktnbDAO = KtnbUtil.getKtnbDAO();
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		if(!appContext.getTenNsd().toUpperCase().equals("INTERNAL")){
			throw new KtnbException("B&#7841;n kh&#244;ng &#273;&#7911; th&#7849;m quy&#7873;n &#273;&#7875; v&#224;o ch&#7913;c n&#259;ng n&#224;y!", "", "Kh&#244;ng c&#243; gi&#7843;i ph&#225;p n&#224;o cho t&#236;nh hu&#7889;ng n&#224;y!!!");
		}
		try {
			conn = DataSourceConfiguration.getConnection();
			ApplicationContext ac = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
			ExeQuerryBean f = (ExeQuerryBean) form;

			PreparedStatement ps = null;
			ResultSet rs = null;
			String result = "";
			String querry = f.getQuerry();
			ps = conn.prepareStatement(querry);

			if ("SELECT".equals(querry.substring(0, 6).toUpperCase())) {
				rs = ps.executeQuery();
				result = dumpData(rs);
			} else {
				result = Integer.toString(ps.executeUpdate());
			}
			f.setResult(result);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			KtnbUtil.releaseKtnbDAO(ktnbDAO);
		}
		return mapping.findForward("success");
	}

	private String dumpData(ResultSet rs) throws Exception {
		StringBuffer out = new StringBuffer();
		int rowCount = 0;
		out.append("<TABLE BORDER=1>");
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		// table header
		out.append("<TR>");
		out.append("<TH>STT</TH>");
		for (int i = 0; i < columnCount; i++) {
			out.append("<TH>" + rsmd.getColumnLabel(i + 1) + "</TH>");
		}
		out.append("</TR>");
		// the data
		while (rs.next()) {
			rowCount++;
			out.append("<TR>");
			out.append("<TD>" + rowCount + "</TD>");
			for (int i = 0; i < columnCount; i++) {
				// out.append("<TD>" + rs.getInt(i + 1) + "</TD>");
				out.append("<TD><div class=\"hideextra\">" + rs.getString(i + 1) + "</div></TD>");
			}
			out.append("</TR>");
		}
		out.append("</TABLE>");
		return out.toString();
	}
}
