package cmc.com.ktnb.web.dung_chung;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.kntc.tiep_dan.TimkiemForm;

/**
 * @author Admin
  */
public class DanhMucAction extends BaseDispatchAction {
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		TimkiemForm cnForm = (TimkiemForm) form;
		String ts = request.getParameter("txtS");
		if (!Formater.isNull(ts))
			cnForm.setMaHoSo(ts);

		return map.findForward("success");
	}

	public ActionForward search(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonResult = null;
		TimkiemForm tF = (TimkiemForm) form;
		String ts = request.getParameter("txtS");
		if (!Formater.isNull(ts))
			tF.setMaHoSo(ts);
		try {
			jsonResult = this.find(tF, request);
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
	private JSONObject find(TimkiemForm cForm, HttpServletRequest request) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection retval = new ArrayList();
		String ma = request.getParameter("ma");
		JSONObject jsonResult = new JSONObject();
		try {
			boolean ic = true;
			StringBuffer sql = new StringBuffer("select count(*) from ktnb_dm_huyen where ma like '101%'");
			sql.append(" AND ma <> ?");
			if (!Formater.isNull(cForm.getMaHoSo()))
				sql.append(" AND ten like ?");
			sql.append(" order by ma");
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, "00000");
			if (!Formater.isNull(cForm.getMaHoSo()))
				ps.setString(2, "'%" + cForm.getMaHoSo() + "%'");
			rs = ps.executeQuery();
			int totalRec = 0;
			if (rs.next()) {
				totalRec = rs.getInt(1);
			}
			DataSourceConfiguration.releaseSqlResources(rs, ps);
			if (totalRec > 0) {
				int idx = 1;
				sql = new StringBuffer("select * from (select rownum rn,z.* from (select ma,ten from ktnb_dm_huyen where 1=1");
				sql.append(" AND ma <> ?");
				if (!Formater.isNull(cForm.getMaHoSo())){				
					idx++;
					sql.append(" AND ten like ?");					
				}
				sql.append(" order by ma");
				sql.append(") z where rownum<=?) where rn>=?");
				System.out.println(sql.toString());
				ps = conn.prepareStatement(sql.toString());
				ps.setString(1, "00000");
				if (!Formater.isNull(cForm.getMaHoSo()))
					ps.setString(idx, "'%" + cForm.getMaHoSo() + "%'");
				ps.setInt(idx+1,30);
				ps.setInt(idx+2,10);
				rs = ps.executeQuery();
				JSONArray jsonArray = new JSONArray();
				JSONArray ja;
				int i = 0;
				while (rs.next()) {
					ja = new JSONArray();
					i++;
					ja.put(i);
					ja.put(rs.getString("ma"));
					ja.put(rs.getString("ten"));
					jsonArray.put(ja);
				}
				jsonResult.put("iTotalRecords", totalRec);
				jsonResult.put("iTotalDisplayRecords", 30);
				jsonResult.put("aaData", jsonArray);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return jsonResult;
	}
}