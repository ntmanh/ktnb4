package cmc.com.ktnb.web.kntc;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import cmc.com.ktnb.pl.hb.entity.KtnbLopTapHuan;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.catalog.CatalogService;

/**
 * Xử lý thông tin trợ giúp 
 * @author Ntthu
 */
public class TroGiupAction extends BaseDispatchAction {
	public ActionForward lopDt(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		TroGiupForm cnForm = (TroGiupForm) form;		
		saveToken(request);
		return map.findForward("lopDt");
	}

	public ActionForward savelopDt(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		//if (isTokenValid(request, true)) {
			try {
				TroGiupForm tdForm = (TroGiupForm) form;
				KtnbLopTapHuan qd = tdForm.toEntity();
				// Luu xuong DB
				SoTiepDanService s = new SoTiepDanService();
				s.saveLopTapHuan(appContext,qd);
				request.setAttribute("ghiThanhcong", "1");
			} catch (Exception e) {
				request.setAttribute("ghiThanhcong", "0");
				e.printStackTrace();
				throw new Exception(e);
			}
		//}
		return map.findForward("lopDt");
	}
	public ActionForward getListLopDt(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		JSONObject jsonResult = null;
		try {
			jsonResult = this.getListBaoCao(appContext);
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
	public JSONObject getListBaoCao(ApplicationContext c) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KtnbLopTapHuan.class);
		JSONObject jsonResult = new JSONObject();
		Collection r = services.retrive(c, sc);
		JSONArray jsonArray = new JSONArray();
		JSONArray ja;
		for (Iterator iter = r.iterator(); iter.hasNext();) {
			KtnbLopTapHuan element = (KtnbLopTapHuan) iter.next();
			ja = new JSONArray();			
			ja.put(element.getTenLop()); //Thoi diem lap phieu
			ja.put(element.getDiaDiem());
			ja.put(Formater.date2str(element.getNgayBatDau()) + "->" + Formater.date2str(element.getNgayKetThuc()));
			ja.put(element.getSoNguoi());
			ja.put("<input type=checkbox id='dmNd' name='dmNd' value='"+element.getMa()+"' />");
			jsonArray.put(ja);
		
		}
		jsonResult.put("aaData", jsonArray);
		return jsonResult;
	}
}
