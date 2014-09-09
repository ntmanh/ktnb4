package cmc.com.ktnb.web.kntc.xac_minh;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;
import org.json.JSONArray;
import org.json.JSONObject;

import cmc.com.ktnb.pl.hb.entity.KntcCanBoRls;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.vo.CategoryVO;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.catalog.CatalogService;
import cmc.com.ktnb.web.kntc.tiep_dan.TimkiemForm;

/**
 * Xử lý tìm kiếm hồ sơ xác minh
 * @author Admin
 */
public class TimKiemHoSoXmAction extends BaseDispatchAction {
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		TimkiemForm tkForm = (TimkiemForm) form;
		KtnbUtil.setCqt(appContext, tkForm, request,null);
		String action = request.getParameter("action");
		if (Formater.isNull(action))
			action = "default";
		else
			request.setAttribute("action", action);

		// Trang thai new =>check with action
		ArrayList list = (ArrayList) request.getAttribute("dmtt");
		ArrayList listKntc = (ArrayList) request.getAttribute("dmkntc");
		if (list == null) { // Chua co trong session
			list = new ArrayList();
			listKntc = new ArrayList();

			// Tim kiem thong thuong
			if ("default".equals(action)) {
				list.add(new LabelValueBean("T\u1EA5t c\u1EA3", TimkiemForm.ALL));
				Collection dmTien = CatalogService.getDmByParentId(CatalogService.KNTC_TRANG_THAI);
				for (Iterator iter = dmTien.iterator(); iter.hasNext();) {
					CategoryVO loaitien = (CategoryVO) iter.next();
					list.add(new LabelValueBean(loaitien.getName(), loaitien.getId()));
				}
				listKntc = addListKntc();
			}

			// Khieu nai
			else if (action.indexOf("KN")>0) {
				list.add(new LabelValueBean("X\u00E1c minh", Constants.TT_KNTC_XM));
				listKntc = addListKntc();
			} 
			// To cao
			else if (action.indexOf("TC")>0) {
				list.add(new LabelValueBean("X\u00E1c minh", Constants.TT_KNTC_XM));
				listKntc = addListKntc();
				tkForm.setLoaiHoSo("2");
			}
		}
		request.setAttribute("dmtt", list);
		request.setAttribute("dmkntc", listKntc);
		return map.findForward("success");
	}

	public ActionForward search(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonResult = null;
		TimkiemForm tF = (TimkiemForm) form;
		try {
			jsonResult = this.find(tF, request);
			response.setContentType("application/json;charset=UTF-8");
			response.setHeader("Cache-Control", "no-store");
			PrintWriter out = response.getWriter();
			out.println(jsonResult);
			out.flush();
			out.close();
		} catch (Exception e) {

		}
		return null;
	}

	private JSONObject find(TimkiemForm tkForm, HttpServletRequest request) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
//		Collection retval = new ArrayList();
		String maHs = request.getParameter("maHs");
		int start = Integer.parseInt(request.getParameter("iDisplayStart"));
		if (!Formater.isNull(maHs))
			tkForm.setMaHoSo(maHs);
		String tt = request.getParameter("tt");
		if (!Formater.isNull(tt))
			tkForm.setTrangThai(tt);
		String loai = request.getParameter("loai");
		if (!Formater.isNull(loai))
			tkForm.setLoaiHoSo(loai);
		String cqt = request.getParameter("cqt");
		if (!Formater.isNull(cqt))
			tkForm.setArrCqt(cqt);
		String sDate = request.getParameter("sDate");
		if (!Formater.isNull(sDate))
			tkForm.setTuNgay(sDate);
		String fDate = request.getParameter("fDate");
		if (!Formater.isNull(fDate))
			tkForm.setDenNgay(fDate);
		// StringBuffer sql = new StringBuffer("select t.ma_hs,t.MA_QD,t.tu_ngay_xm,t.den_ngay_xm,trang_thai from kntc_qdinh_xm t where 1=1");
		StringBuffer sql = new StringBuffer("select dtl.*,ktnb_pck_util.fnc_get_cqt_chuyen(dtl.ma_hs) as dvchuyen from  ( select * from (select rownum r,t.ma_hs, h.nnd_ten, t.MA_QD, t.tu_ngay_xm, t.den_ngay_xm from kntc_qdinh_xm t,kntc_ho_so_hdr h,kntc_can_bo_rls c"
				+ " where t.ma_hs = c.ma_hs and t.ma_hs = h.ma_hs");
		JSONObject jsonResult = new JSONObject();
		try {
			conn = DataSourceConfiguration.getConnection();
			if (!Formater.isNull(tkForm.getMaHoSo()))
				sql.append(" And t.ma_hs like '%" + tkForm.getMaHoSo() + "%'");
			if (!Formater.isNull(tkForm.getMaQd()))
				sql.append(" And t.ma_qd like '%" + tkForm.getMaQd() + "%'");
			if (!Formater.isNull(tkForm.getLoaiHoSo()) && !tkForm.getLoaiHoSo().equals(TimkiemForm.ALL))
				sql.append(" And loai_kntc =" + tkForm.getLoaiHoSo());
			if (!Formater.isNull(tkForm.getTrangThai()) && !tkForm.getTrangThai().equals(TimkiemForm.ALL))
				sql.append(" And h.trang_thai =" + tkForm.getTrangThai());			
			if (!Formater.isNull(tkForm.getTuNgay()) && !Formater.isNull(tkForm.getDenNgay())) {
				if (tkForm.getDenNgay().equals(tkForm.getTuNgay())) {
					sql.append(" AND tu_ngay_xm = " + "to_date('" + tkForm.getTuNgay() + "','dd/mm/yyyy')");
				} else {
					sql.append(" AND tu_ngay_xm >= " + "to_date('" + tkForm.getTuNgay() + "','dd/mm/yyyy')");
					sql.append(" AND den_ngay_xm <= " + "to_date('" + tkForm.getDenNgay() + "','dd/mm/yyyy')");
				}
			} else if (!Formater.isNull(tkForm.getTuNgay()) && Formater.isNull(tkForm.getDenNgay())) {
				sql.append(" AND tu_ngay_xm >= " + "to_date('" + tkForm.getTuNgay() + "','dd/mm/yyyy')");
			} else if (Formater.isNull(tkForm.getTuNgay()) && !Formater.isNull(tkForm.getDenNgay())) {
				sql.append(" AND den_ngay_xm <= " + "to_date('" + tkForm.getDenNgay() + "','dd/mm/yyyy')");
			}
			if (!Formater.isNull(tkForm.getArrCqt())) {
				String[] arr = tkForm.getArrCqt().split(",");
				String newArr = "";
				for (int i = 0; i < arr.length; i++) {
					newArr += ",'" + arr[i] + "'";
				}
				sql.append(" AND h.ma_cqt in (" + newArr.substring(1) + ")");
			} else {
				sql.append(KtnbUtil.addCqtCondition(appContext, "h"));
			}
			// Them dieu kien can bo
			sql.append(" and c.ma_canbo = '"+appContext.getMaCanbo()+"'");
			sql.append(" and c.loai_cb = '"+KntcCanBoRls.KNTC_TVD_XAC_MINH+"'");
			sql.append(" order by t.tu_ngay_xm");
			sql.append(" )a where a.r between ? and ?) dtl");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, start);
			ps.setInt(2, start + 10);
			System.out.println("SQL Search: " + sql.toString());
			rs = ps.executeQuery();

			// Tinh count
			StringBuffer sqlCount = new StringBuffer("select count(*) as c ");
			sqlCount.append(sql.substring(sql.lastIndexOf("from"), sql.lastIndexOf(")a where")));
			System.out.println("Sql Count: " + sqlCount);
			PreparedStatement psCount = null;
			ResultSet rsCount = null;
			psCount = conn.prepareStatement(sqlCount.toString());
			rsCount = psCount.executeQuery();
			int Count = 0;
			while (rsCount.next()) {
				Count = rsCount.getInt("c");
			}

			// Create Json
			JSONArray jsonArray = new JSONArray();
			JSONArray ja;
			int i = 0;
			while (rs.next()) {
				ja = new JSONArray();
				i++;
				// ja.put(i);
				ja.put(rs.getString("ma_hs"));
				ja.put(rs.getString("nnd_ten"));
				ja.put(rs.getString("MA_QD"));
				ja.put(Formater.date2str(rs.getDate("tu_ngay_xm")));
				ja.put(Formater.date2str(rs.getDate("den_ngay_xm")));
				jsonArray.put(ja);
			}
			jsonResult.put("sEcho", tkForm.getMaHoSo());
			jsonResult.put("iTotalRecords", Count);
			jsonResult.put("iTotalDisplayRecords", Count);
			jsonResult.put("aaData", jsonArray);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return jsonResult;
	}

	private ArrayList addListKntc() {
		ArrayList list = new ArrayList();
		list.add(new LabelValueBean("Khi\u1EBFu n\u1EA1i", "1"));
		list.add(new LabelValueBean("T\u1ED1 c\u00E1o", "2"));
		list.add(new LabelValueBean("Kh\u00E1c", "3"));
		return list;
	}
}