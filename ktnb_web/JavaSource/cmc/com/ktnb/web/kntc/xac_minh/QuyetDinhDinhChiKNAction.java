package cmc.com.ktnb.web.kntc.xac_minh;

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
import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.pl.hb.entity.KntcQdDinhChiKN;
import cmc.com.ktnb.service.kntc.KntcSoTiepDan;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.service.kntc.XuLyPhuKhieuNaiToCaoService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.kntc.xac_minh.tien_hanh.BienBanDoiThoaiForm;
import cmc.com.ktnb.web.kntc.xu_ly.PrintAction;

public class QuyetDinhDinhChiKNAction extends PrintAction {
	KntcQdDinhChiKN dinhChiKN = new KntcQdDinhChiKN();

	XuLyPhuKhieuNaiToCaoService services = new XuLyPhuKhieuNaiToCaoService();

	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		QuyetDinhDinhChiKNForm cbForm = (QuyetDinhDinhChiKNForm) form;
		String soHoSo = request.getParameter("id");
		
		if ("view".equals(request.getParameter("action"))){
			loadDefauldForm(appContext, cbForm, soHoSo);
		} else if ("save".equals(request.getParameter("action"))) {
			saveQdDinhChiKn(map, request, response, form);
		} else if("exportDoc".equals(request.getParameter("action"))){
			exportDoc(map, form, request, response);
			
		}
		
		if("Qddckn".equals(request.getParameter("type"))){
			return map.findForward("success");
		}
		else  if("Qddctc".equals(request.getParameter("type"))){
			return map.findForward("tc");		
		}
		return null;
	}



	// Load defauld form
	public void loadDefauldForm(ApplicationContext appContext, QuyetDinhDinhChiKNForm cbForm, String soHoSo) throws Exception {
		dinhChiKN = services.findQdDinhChiKN(appContext, soHoSo);
		if (dinhChiKN == null) {
			dinhChiKN = new KntcQdDinhChiKN();
			cbForm.qdDinhChiKN.setSoHoSo(soHoSo);
		} else
			cbForm.qdDinhChiKN = dinhChiKN;
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
			StringBuffer sb = new StringBuffer("select id,so_quyet_dinh,ngay_ban_hanh,cq_thi_hanh from kntc_qd_dinh_chi_kn where so_ho_so= ? order by ngay_ban_hanh desc");
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
				ja.put(rs.getString("so_quyet_dinh"));
				ja.put(Formater.date2str(rs.getDate("ngay_ban_hanh")));
				ja.put(rs.getString("cq_thi_hanh"));
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
	public ActionForward saveQdDinhChiKn(ActionMapping map, HttpServletRequest request, HttpServletResponse response, ActionForm form) throws Exception
	{
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		SoTiepDanService service = new SoTiepDanService();
		QuyetDinhDinhChiKNForm cmForm= (QuyetDinhDinhChiKNForm) form;
		String maHs=request.getParameter("id");
		try {
			KntcQdDinhChiKN qd=cmForm.getQdDinhChiKN();
			qd.setSoHoSo(maHs);
			service.saveQuyetDinhDinhChi(appContext, qd);
			// chuyen sang trang thai ket thuc
			KntcSoTiepDan std= service.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr= std.getHdr();
			hdr.setTrangThai(Constants.TT_KNTC_KET_THUC);
			hdr.setLoaiKetThuc(Constants.KNTC_KET_THUC_THUONG);
			service.saveSoTiepDan(appContext, std, false);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		
		if("Qddckn".equals(request.getParameter("type"))){
			
			return map.findForward("success");
		}
		else  if("Qddctc".equals(request.getParameter("type"))){
			
			return map.findForward("tc");		
		}
		return null;
	
	}
	// Xem bien ban
	public ActionForward xemBienBan(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("id");
		String maPh = request.getParameter("pId");
		QuyetDinhDinhChiKNForm bbForm = (QuyetDinhDinhChiKNForm) form;
		//bbForm.qdDinhChiKN.setSoQuyetDinh(KtnbUtil.getMaNvu(appContext, "\u0110CKN"));
		SoTiepDanService service = new SoTiepDanService();
		if (!Formater.isNull(maHs)) {
			KntcQdDinhChiKN bb = service.getQuyetDinhByMaPh(appContext, maHs, maPh);
			if (bb != null)
				bbForm.setQdDinhChiKN(bb);
				//bbForm.qdDinhChiKN.setSoQuyetDinh(KtnbUtil.getMaNvu(appContext, "\u0110CKN"));
		} else {

		}
		if("Qddckn".equals(request.getParameter("type"))){
			return map.findForward("success");
		}
		else  if("Qddctc".equals(request.getParameter("type"))){
			return map.findForward("tc");		
		}
		return null;
	}

	// Tao moi bien ban doi thoai 
	public ActionForward taoBienBan(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		QuyetDinhDinhChiKNForm bbForm=(QuyetDinhDinhChiKNForm) form;
		bbForm.qdDinhChiKN.setSoQuyetDinh(KtnbUtil.getMaNvu(appContext, "\u0110CKN"));
		String maHs=request.getParameter("id");
		String readOnly = request.getParameter("r");
		if (readOnly != null)
			if (readOnly.equals("rol")) {
				throw new KtnbException("Bi&#7875;u m&#7851;u n&#224;y kh&#244;ng c&#243; s&#7889; li&#7879;u!!!", "", "");
			}
		bbForm.setQdDinhChiKN(new KntcQdDinhChiKN());
		bbForm.qdDinhChiKN.setSoQuyetDinh(KtnbUtil.getMaNvu(appContext, "\u0110CKN"));
		if("Qddckn".equals(request.getParameter("type"))){
			return map.findForward("success");
		}
		else  if("Qddctc".equals(request.getParameter("type"))){
			return map.findForward("tc");		
		}
		return null;
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
				service.xoaQDDinhChiKn(appContext, service.getQuyetDinhByMaPh(appContext, maHs, maPh));
				request.setAttribute("xoaThanhcong", "1");
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("xoaThanhcong","0");
			e.printStackTrace();
			throw new Exception(e);
		}
		
		if("Qddckn".equals(request.getParameter("type"))){
			return map.findForward("success");
		}
		else  if("Qddctc".equals(request.getParameter("type"))){
			return map.findForward("tc");		
		}
		return null;
	}
	
	
	
	
	// Export file doc
	protected String getDocInName(HttpServletRequest request) {
		
		System.out.print(request.getParameter("type"));
		if("Qddckn".equals(request.getParameter("type")))
		{
			return request.getRealPath("/docin") + "\\TTNB_qd_dinh_chi_gq_kn.doc";
		}
		else if("Qddctc".equals(request.getParameter("type")))
		{
			return request.getRealPath("/docin") + "\\TTNB_qd_dinh_chi_gq_tc.doc";
		}
		return null;
	}

	protected String getDocOutName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		if("Qddckn".equals(request.getParameter("type")))
		{
			return request.getRealPath("/docout") + "\\TTNB_qd_dinh_chi_gq_kn.doc_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
		}
		else if("Qddctc".equals(request.getParameter("type")))
		{
			return request.getRealPath("/docout") + "\\TTNB_qd_dinh_chi_gq_tc.doc_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
		}
		return null;
	}

	protected String getFileOutName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "Quyet Dinh Dinh Chi Khieu Nai";
	}

	public void pushData(MsWordUtils word, HttpServletRequest request, ActionForm form) throws Exception {
		// TODO Auto-generated method stub
		QuyetDinhDinhChiKNForm cbForm = (QuyetDinhDinhChiKNForm) form;
		word.put("[ngay_lap]", cbForm.qdDinhChiKN.getNgayBanHanhStr());
		word.put("[dia_diem_giao_nhan]", cbForm.qdDinhChiKN.getDiaDiem());
		word.put("[nguoi_de_nghi]", cbForm.qdDinhChiKN.getNguoiDeNghi());
		word.put("[so_ho_so]", cbForm.getQdDinhChiKN().getSoHoSo());
		word.put("[nguoi_qd_dinh_chi_ten]", cbForm.getQdDinhChiKN().getNguoiQdTen());
		word.put("[nguoi_qd_dinh_chi_chuc_vu]", " Ch\u1EE9c v\u1EE5 : " + cbForm.getQdDinhChiKN().getNguoiQdChucVu());
		word.put("[ly_do]", cbForm.getQdDinhChiKN().getLyDo());
		word.put("[co_quan_thi_hanh]", cbForm.getQdDinhChiKN().getCqThiHanh());
	}
}
