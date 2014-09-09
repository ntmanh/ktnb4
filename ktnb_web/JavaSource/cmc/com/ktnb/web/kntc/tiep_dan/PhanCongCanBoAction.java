package cmc.com.ktnb.web.kntc.tiep_dan;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import cmc.com.ktnb.pl.hb.entity.KntcCanBoRls;
import cmc.com.ktnb.pl.hb.entity.KntcCanBoRlsId;
import cmc.com.ktnb.service.KtnbService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseDispatchAction;

/**
 * Xử lý phân công cán bộ
 * 
 * @author Ntthu+DoHongPhuc
 */
public class PhanCongCanBoAction extends BaseDispatchAction {
	public ActionForward getListCanBo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}

	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		PhanCongCanBoForm pccbForm = (PhanCongCanBoForm) form;
		// 1.Get Ma ho so
		pccbForm.setMaHoSo(request.getParameter("id"));
		pccbForm.setNgayPhanCong(Formater.date2str(new Date()));
		pccbForm.setArrCanBo("");
		saveToken(request);
		return map.findForward("success");
	}

	// Dung cho Phan Cong Can Bo
	public ActionForward saveListCanBo(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		KtnbService service = new KtnbService();
		PhanCongCanBoForm pccbForm;
		Collection listCb;
		try {
			pccbForm = (PhanCongCanBoForm) form;
			String[] arrCb = pccbForm.getArrCanBo().split("@@");
			listCb = new ArrayList();
			for (int i = 0; i < arrCb.length; i++) {
				String[] item = arrCb[i].split(",");
				KntcCanBoRls aCb = new KntcCanBoRls();
				KntcCanBoRlsId aId = new KntcCanBoRlsId(item[0], pccbForm.getMaHoSo(), new Long(0), KntcCanBoRls.KNTC_CB_XU_LY);
				aCb.setId(aId);
				aCb.setTenCb(item[1]);
				aCb.setDonVi(item[2]);
				if (!Formater.isNull(item[3]))
					aCb.setChucVu(item[3]);

				aCb.setNgayCapNhat(Formater.str2date(pccbForm.getNgayPhanCong()));
				aCb.setNguoiCapNhat(appContext.getTenNsd());
				listCb.add(aCb);
			}
			service.saveTvd(appContext, pccbForm.getMaHoSo(), listCb, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.findForward("success");
	}

	public ActionForward tvd(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String maHs = request.getParameter("parentId");
		PhanCongCanBoForm pForm = (PhanCongCanBoForm) form;
		pForm.setMaHoSo(maHs);
		return map.findForward("tvd");
	}

	public ActionForward saveTvd(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhanCongCanBoForm pForm = (PhanCongCanBoForm) form;
		KtnbService s = new KtnbService();
		String[] arrCb = pForm.getArrCanBo().split("@@");
		Collection listCb = new ArrayList();
		for (int i = 0; i < arrCb.length; i++) {
			String[] item = arrCb[i].split(",");
			KntcCanBoRls aCb = new KntcCanBoRls();
			KntcCanBoRlsId aId = new KntcCanBoRlsId(item[0], pForm.getMaHoSo(), new Long(0), KntcCanBoRls.KNTC_CB_XU_LY);
			aCb.setId(aId);
			aCb.setTenCb(item[1]);
			aCb.setDonVi(item[2]);
			aCb.setChucVu(item[3]);
			aCb.setVaiTro(item[4]);
			aCb.setNgayCapNhat(Formater.str2date(pForm.getNgayPhanCong()));
			aCb.setNguoiCapNhat(appContext.getTenNsd());
			listCb.add(aCb);
		}
		s.saveTvd(appContext, pForm.getMaHoSo(), listCb,false);
		return map.findForward("tvd");
	}

	public ActionForward getLichSu(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonResult = null;
		PhanCongCanBoForm pccbForm = (PhanCongCanBoForm) form;
		try {
			jsonResult = this.createObject(pccbForm, request);
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

	private JSONObject createObject(PhanCongCanBoForm pccbForm, HttpServletRequest request) throws Exception {
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs))
			pccbForm.setMaHoSo(maHs);
		else
			maHs = pccbForm.getMaHoSo();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			conn = DataSourceConfiguration.getConnection();
			StringBuffer sb = new StringBuffer("select lan_td,ten_cb,don_vi,chuc_vu,ngay_cap_nhat from KNTC_CAN_BO_RLS where ma_hs = ? and loai_cb=6 order by lan_td desc");
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, maHs);
			System.out.println(sb.toString());
			JSONArray jsonArray = new JSONArray();
			int rc = 0;
			rs = ps.executeQuery();
			String lantd = "";
			int max = 0;
			while (rs.next()) {
				JSONArray ja;
				ja = new JSONArray();
				if (Integer.parseInt(rs.getString(1)) > max)
					max = Integer.parseInt(rs.getString(1));

				if (!lantd.equals(rs.getString(1))) {
					lantd = rs.getString(1);
					if (max == Integer.parseInt(lantd))
						ja.put("Ph&#226;n c&#244;ng l&#7847;n &#273;&#7847;u");
					else if ("0".equals(lantd))
						ja.put("Hi&#7879;n t&#7841;i");
					else
						ja.put("L&#7847;n thay &#273;&#7893;i " + (max - (Integer.parseInt(lantd))));
					ja.put(rs.getString(2));
					ja.put(rs.getString(3));
					ja.put(rs.getString(4));
					ja.put(Formater.date2str(rs.getDate(5)));
				} else {
					ja.put("");
					ja.put(rs.getString(2));
					ja.put(rs.getString(3));
					ja.put(rs.getString(4));
					ja.put("");
				}
				jsonArray.put(ja);
				rc++;
			}
			jsonResult.put("iTotalRecords", new Integer(rc));
			jsonResult.put("aaData", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}
}
