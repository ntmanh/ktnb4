package cmc.com.ktnb.web.dung_chung;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.StringUtil;
import cmc.com.ktnb.web.BaseDispatchAction;

/**
 * @author dhphuc
 */
public class LogAction extends BaseDispatchAction {
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		if (!appContext.getTenNsd().toUpperCase().equals("INTERNAL")) {
			throw new KtnbException("B&#7841;n kh&#244;ng &#273;&#7911; th&#7849;m quy&#7873;n &#273;&#7875; v&#224;o ch&#7913;c n&#259;ng n&#224;y!", "",
					"Kh&#244;ng c&#243; gi&#7843;i ph&#225;p n&#224;o cho t&#236;nh hu&#7889;ng n&#224;y!!!");
		}
		return map.findForward("success");
	}

	public ActionForward getLog(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonResult = null;
		try {
			jsonResult = this.createObject(request);
			response.setContentType("application/json;charset=UTF-8");
			response.setHeader("Cache-Control", "no-store");
			PrintWriter out = response.getWriter();
			out.println(jsonResult);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private JSONObject createObject(HttpServletRequest request) throws Exception {
		// String maHs = request.getParameter("id");
		// Create Object
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			conn = DataSourceConfiguration.getConnection();
			String query = "select * from ktnb_log where 1 = 1";
			if(!StringUtil.isBlankOrNull(request.getParameter("tuNgay")))
				query +=" and trunc(time)>="+ "to_date('" + request.getParameter("tuNgay") + "','dd/mm/yyyy')";
			if(!StringUtil.isBlankOrNull(request.getParameter("denNgay")))
				query +=" and trunc(time)<="+ "to_date('" + request.getParameter("denNgay") + "','dd/mm/yyyy')";
			if(StringUtil.isBlankOrNull(request.getParameter("denNgay")) && StringUtil.isBlankOrNull(request.getParameter("denNgay")))			
			query +=" and trunc(time)=trunc(sysdate)";
			if(!StringUtil.isBlankOrNull(request.getParameter("canBo")))
				query +=" and MA_CAN_BO like '%"+request.getParameter("canBo")+"%' or MA_CAN_BO like '%"+request.getParameter("canBo")+"%'";
			query +=" order by time desc";
			
			ps = conn.prepareStatement(query);
			// ps.setString(1, maHs);
			// => Remove System.out.println(sb.toString());
			JSONArray jsonArray = new JSONArray();
			int rc = 0;
			rs = ps.executeQuery();
			while (rs.next()) {
				JSONArray ja;
				ja = new JSONArray();
				ja.put(rs.getString(1));
				ja.put(Formater.date2strDateTimeForNV(rs.getDate(2)));
				ja.put(rs.getString(3));
				ja.put(rs.getString(4));
				ja.put(rs.getString(5));
				ja.put(rs.getString(6));
				ja.put(rs.getString(7));
				jsonArray.put(ja);
				rc++;
			}
			// /jsonResult.put("sEcho", tkForm.getMaHoSo());
			jsonResult.put("iTotalRecords", rc);
			jsonResult.put("aaData", jsonArray);
			jsonResult.put("iTotalDisplayRecords", rc);

		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}
}
