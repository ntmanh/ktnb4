package cmc.com.ktnb.web.kntc.xu_ly;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ibm.etools.ejb.Session;

import cmc.com.ktnb.pl.hb.entity.KntcChuyenCqDieuTra;
import cmc.com.ktnb.pl.hb.entity.KntcPhieuChuyenDon;
import cmc.com.ktnb.service.kntc.PhanLoaiXuLyService;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseDispatchAction;

public class ChuyenCqDieuTraAction extends BaseDispatchAction {
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String maHoSo= request.getParameter("id");
		ChuyenCqDieuTraForm cmForm= (ChuyenCqDieuTraForm) form;
		cmForm.chuyenCqDieuTra.setMaHoSo(maHoSo);
		if("savePhieu".equals(request.getParameter("action")))
		{
			savePhieu(form, request);
			request.setAttribute("ghiThanhcong", "1");
		}
		else if("xoaPhieu".equals(request.getParameter("action")))
		{
			xoaPhieu(form,request);
			request.setAttribute("xoaThanhcong", "1");
		}
		return map.findForward("success");
	}
	
	public ActionForward getListPhieuChuyen(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	
	public ActionForward xemPhieu(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ApplicationContext appContext =(ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		ChuyenCqDieuTraForm cmForm = (ChuyenCqDieuTraForm) form;
		String maPhieu= request.getParameter("pId");
		KntcChuyenCqDieuTra chuyenCqDieuTra= new KntcChuyenCqDieuTra();
		PhanLoaiXuLyService service = new PhanLoaiXuLyService();
		chuyenCqDieuTra=service.getPhieuChuyenCqByMaPhieu(appContext, maPhieu);
		if(chuyenCqDieuTra!=null)
			cmForm.setChuyenCqDieuTra(chuyenCqDieuTra);
		return map.findForward("success");
	}
	
	public ActionForward taoMoiPhieu(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String maHs = request.getParameter("id");
		ChuyenCqDieuTraForm cmForm = (ChuyenCqDieuTraForm) form;
		cmForm.setChuyenCqDieuTra(new KntcChuyenCqDieuTra());
		cmForm.chuyenCqDieuTra.setMaHoSo(maHs);
		return map.findForward("success");
	}
	
	public void savePhieu(ActionForm form, HttpServletRequest request) throws Exception
	{
		ApplicationContext appContext = (ApplicationContext)request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhanLoaiXuLyService service = new PhanLoaiXuLyService();
		ChuyenCqDieuTraForm cmForm = (ChuyenCqDieuTraForm) form;
		KntcChuyenCqDieuTra chuyencq= service.getPhieuChuyenCqByMaPhieu(appContext, request.getParameter("pId"));
		chuyencq= cmForm.chuyenCqDieuTra;
		chuyencq.setTrangThai("1");
		service.savePhieuChuyenCq(appContext, chuyencq);
	}

	public void xoaPhieu(ActionForm form, HttpServletRequest request) throws Exception
	{
		ApplicationContext appContext = (ApplicationContext)request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhanLoaiXuLyService service = new PhanLoaiXuLyService();
		KntcChuyenCqDieuTra chuyencq= service.getPhieuChuyenCqByMaPhieu(appContext, request.getParameter("pId"));
		chuyencq.setTrangThai("0");
		service.savePhieuChuyenCq(appContext, chuyencq);
	}
	private JSONObject createObject(HttpServletRequest request) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// Get ma Ho so
		String maHs = request.getParameter("maHs");
		/*
		// Loai bien ban
		String loaiThongBao = SoTiepDanService.isKN(appContext, maHs) ? KntcPhieuChuyenDon.PHIEU_CHUYEN_DON : KntcPhieuChuyenDon.PHIEU_CHUYEN_DON_TO_CAO;
		*/
		// Create Object
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			conn = DataSourceConfiguration.getConnection();
			StringBuffer sb = new StringBuffer("select t.ma_phieu,t.so_cong_van_chuyen,t.ngay_ban_hanh,t.so_nguoi from KNTC_CHUYEN_CQ_DIEU_TRA t WHERE t.ma_ho_so=? and t.trang_thai=?");
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, maHs);
			ps.setString(2, "1");
			System.out.println(sb.toString());
			JSONArray jsonArray = new JSONArray();
			int rc = 0;
			rs = ps.executeQuery();
			while (rs.next()) {
				JSONArray ja;
				ja = new JSONArray();
				ja.put(rs.getString(1));
				ja.put(rs.getString(2));
				ja.put(Formater.date2str(rs.getDate(3)));
				ja.put(rs.getString(4));
				ja.put("<A href=\"#\" onclick=\"openUploadFile(1);\">File \u0111\u00EDnh k\u00E8m</A>");
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
