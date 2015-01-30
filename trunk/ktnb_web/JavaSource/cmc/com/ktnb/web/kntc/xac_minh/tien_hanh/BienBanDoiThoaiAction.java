package cmc.com.ktnb.web.kntc.xac_minh.tien_hanh;

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

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KntcBbDoiThoai;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.service.kntc.XuLyPhuKhieuNaiToCaoService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.kntc.tiep_dan.PhieuHenForm;
import cmc.com.ktnb.web.kntc.xu_ly.PrintAction;

public class BienBanDoiThoaiAction extends PrintAction {

	KntcBbDoiThoai bbDoiThoai = new KntcBbDoiThoai();

	XuLyPhuKhieuNaiToCaoService khieuNaiToCaoService = new XuLyPhuKhieuNaiToCaoService();

	// Execute method
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BienBanDoiThoaiForm cbForm = (BienBanDoiThoaiForm) form;
		String soHoSo = request.getParameter("id");
		if ("view".equals(request.getParameter("action"))) {
			// Load form voi so quyet dinh
			if (!Formater.isNull(soHoSo))
				loadDefauldForm(appContext, cbForm, soHoSo);
		}

		if ("save".equals(request.getParameter("action"))) {
			bbDoiThoai = cbForm.bbDoiThoai;
			saveBienBanDoiThoai(map, request, response, form);
		}
		if ("exportDoc".equals(request.getParameter("action")))
			exportDoc(map, form, request, response);
		return map.findForward("success");
	}

	public ActionForward getListBienBan(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		JSONObject jsonResult = null;
		// PhieuHenForm phForm = (PhieuHenForm) form;
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
		// Get ma Ho so
		String maHs = request.getParameter("id");
		// Create Object
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			conn = DataSourceConfiguration.getConnection();
			StringBuffer sb = new StringBuffer("select t.id,t.dia_diem,t.thoi_gian_bat_dau,t.thoi_gian_ket_thuc,t.so_qd from kntc_xm_bb_doi_thoai t where t.so_qd= ? order by t.thoi_gian_bat_dau");
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, maHs);
			System.out.println(sb.toString());
			JSONArray jsonArray = new JSONArray();
			int rc = 0;
			rs = ps.executeQuery();
			while (rs.next()) {
				JSONArray ja;
				ja = new JSONArray();
				ja.put(rs.getString("id"));
				ja.put(rs.getString("dia_diem"));
				ja.put(Formater.date2strDateTimeForNV(rs.getTimestamp("thoi_gian_bat_dau")));
				ja.put(Formater.date2strDateTimeForNV(rs.getTimestamp("thoi_gian_ket_thuc")));
				ja.put("<a href='#' onclick='openUploadFile();'>File \u0111\u00EDnh k\u00E8m</a>");
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
	public void loadDefauldForm(ApplicationContext appContext, BienBanDoiThoaiForm cbForm, String soHoSo) throws Exception {
		bbDoiThoai = khieuNaiToCaoService.findBbDoiThoai(appContext, soHoSo);
		if (bbDoiThoai == null) {
			// Khoi tao lai bb doi thoai, set so ho so cho cbForm
			bbDoiThoai = new KntcBbDoiThoai();
		} else
			cbForm.bbDoiThoai = bbDoiThoai;
	}
	
	public ActionForward saveBienBanDoiThoai(ActionMapping map, HttpServletRequest request, HttpServletResponse response, ActionForm form) throws Exception
	{
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		SoTiepDanService service = new SoTiepDanService();
		BienBanDoiThoaiForm cnForm = (BienBanDoiThoaiForm) form;
		String maHs=request.getParameter("id");
		try {
			KntcBbDoiThoai bb = cnForm.getBbDoiThoai();
			bb.setSoQD(maHs);
			service.saveBbDoiThoai(appContext, bb);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		return map.findForward("success");
	}
	// Xem bien ban
	public ActionForward xemBienBan(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("id");
		String maPh = request.getParameter("pId");
		BienBanDoiThoaiForm bbForm = (BienBanDoiThoaiForm) form;
		SoTiepDanService service = new SoTiepDanService();
		if (!Formater.isNull(maHs)) {
			KntcBbDoiThoai bb = service.getBienBanByMaPh(appContext, maHs, maPh);
			if (bb != null)
				bbForm.setBbDoiThoai(bb);
		} else {

		}
		return map.findForward("success");
	}

	// Tao moi bien ban doi thoai 
	public ActionForward taoBienBan(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BienBanDoiThoaiForm bbForm= (BienBanDoiThoaiForm) form;
		String maHs=request.getParameter("id");
		String readOnly = request.getParameter("r");
		if (readOnly != null)
			if (readOnly.equals("rol")) {
				throw new KtnbException("Bi&#7875;u m&#7851;u n&#224;y kh&#244;ng c&#243; s&#7889; li&#7879;u!!!", "", "");
			}
		bbForm.setBbDoiThoai(new KntcBbDoiThoai());
		return map.findForward("success");
	}
	
	// Xoa bien ban doi thoai
	public ActionForward xoaBienBan(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ApplicationContext appContext = (ApplicationContext)request.getSession().getAttribute(Constants.APP_CONTEXT);
		SoTiepDanService service = new SoTiepDanService();
		String maHs= request.getParameter("id");
		String maPh= request.getParameter("pId");
		try {
			if(!Formater.isNull(maHs) && !Formater.isNull(maPh))
			{
				service.xoaBienBanDoiThoai(appContext, service.getBienBanByMaPh(appContext, maHs, maPh));
				request.setAttribute("xoaThanhcong", "1");
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("xoaThanhcong","0");
			e.printStackTrace();
			throw new Exception(e);
		}
		
		return map.findForward("success");
	}
	
	protected String getDocInName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return request.getRealPath("/docin") + "\\TTNB_bb_doi_thoai.doc";
	}

	protected String getDocOutName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return request.getRealPath("/docout") + "\\TTNB_bb_doi_thoai_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
	}

	protected String getFileOutName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "BB doi thoai";
	}

	public void pushData(MsWordUtils word, HttpServletRequest request, ActionForm form) throws Exception {
		// TODO Auto-generated method stub
		BienBanDoiThoaiForm cbForm = (BienBanDoiThoaiForm) form;
		word.put("[thoi_gian_bat_dau]", cbForm.bbDoiThoai.getThoiGianBatDauStr());
		word.put("[dia_diem]", cbForm.bbDoiThoai.getDiaDiem());
		word.put("[nguoi_giai_quyet_ten]", cbForm.bbDoiThoai.getNguoiGqTen());
		word.put("[nguoi_giai_quyet_chuc_vu]", " Ch\u1EE9c v\u1EE5 : " + cbForm.bbDoiThoai.getNguoiGqChucVu());
		word.put("[nguoi_giai_quyet_co_quan]", " C\u01A1 quan : " + cbForm.bbDoiThoai.getNguoiGqCoQuan());
		word.put("[nguoi_ghi_bb_ten]", cbForm.bbDoiThoai.getNguoiGhiBbTen());
		word.put("[nguoi_ghi_bb_chuc_vu]", " Ch\u1EE9c v\u1EE5 " + cbForm.bbDoiThoai.getNguoiGhiBbChucVu());
		word.put("[nguoi_ghi_bb_co_quan]", " C\u01A1 quan : " + cbForm.bbDoiThoai.getNguoiGhiBbCoQuan());
		word.put("[nguoi_lq_ten]", cbForm.bbDoiThoai.getNguoiLqTen());
		word.put("[nguoi_lq_cmt]", "S\u1ED1 CMT/H\u1ED9 chi\u1EBFu : " + cbForm.bbDoiThoai.getNguoiLqCmt());
		word.put("[nguoi_lq_noi_cap]", " N\u01A1i c\u1EA5p : " + cbForm.bbDoiThoai.getNguoiLqCmtNoiCap());
		word.put("[nguoi_lq_ngay_cap]", " Ng\u00E0y c\u1EA5p : " + cbForm.bbDoiThoai.getNguoiLqCmtNgayStr());
		word.put("[dai_dien_ten]", cbForm.bbDoiThoai.getDaiDienTen());
		word.put("[dai_dien_dia_chi]", " \u0110\u1ECBa ch\u1EC9 : " + cbForm.bbDoiThoai.getDaiDienDiaChi());
		word.put("[noi_dung_doi_thoai]", cbForm.bbDoiThoai.getNoiDung());
		word.put("[ket_qua_doi_thoai]", cbForm.bbDoiThoai.getKetQua());
		word.put("[thoi_diem_kt]", cbForm.bbDoiThoai.getThoiGianKetThucStr());
	}

	// Property accessors
	public KntcBbDoiThoai getBbDoiThoai() {
		return bbDoiThoai;
	}

	public void setBbDoiThoai(KntcBbDoiThoai bbDoiThoai) {
		this.bbDoiThoai = bbDoiThoai;
	}

	public XuLyPhuKhieuNaiToCaoService getKhieuNaiToCaoService() {
		return khieuNaiToCaoService;
	}

	public void setKhieuNaiToCaoService(XuLyPhuKhieuNaiToCaoService khieuNaiToCaoService) {
		this.khieuNaiToCaoService = khieuNaiToCaoService;
	}
	
}
