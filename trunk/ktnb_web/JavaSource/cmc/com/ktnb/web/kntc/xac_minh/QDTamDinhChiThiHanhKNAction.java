package cmc.com.ktnb.web.kntc.xac_minh;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KntcQdDinhChiKN;
import cmc.com.ktnb.pl.hb.entity.KntcQdHuyTamDinhChiKN;
import cmc.com.ktnb.pl.hb.entity.KntcQdTamDinhChiKn;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.service.kntc.XuLyPhuKhieuNaiToCaoService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.catalog.CatalogService;
import cmc.com.ktnb.web.kntc.xac_minh.tien_hanh.BienBanDoiThoaiForm;
import cmc.com.ktnb.web.kntc.xu_ly.PrintAction;

public class QDTamDinhChiThiHanhKNAction extends PrintAction{
	KntcQdTamDinhChiKn qdTamDinhChiKn =new KntcQdTamDinhChiKn();
	KntcQdHuyTamDinhChiKN qdHuyTamDinhChiKn=new KntcQdHuyTamDinhChiKN();
	XuLyPhuKhieuNaiToCaoService services=new XuLyPhuKhieuNaiToCaoService();
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ApplicationContext appContext=(ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		QDTamDinhChiThiHanhKNForm cbForm=(QDTamDinhChiThiHanhKNForm) form;
		if("view".equals(request.getParameter("action")))
		{
			String soHoSo=request.getParameter("id");
			if(!Formater.isNull(soHoSo))
			{
				if("tam".equals(request.getParameter("type")))
					loadTamDinhChi(appContext,cbForm,soHoSo);
				else if("huytam".equals(request.getParameter("type")))
					loadHuyTamDinhChi(appContext,cbForm,soHoSo);
			}
		}
		else if("save".equals(request.getParameter("action")))
		{
			if("tam".equals(request.getParameter("type")))
			{
				saveQdTamDinhChiKn(map, request, response, form);
			}
			else if("huytam".equals(request.getParameter("type")))
			{
				qdHuyTamDinhChiKn=cbForm.huyDinhChiKn;
				services.saveHuyTamDinhChiKn(request, appContext, qdHuyTamDinhChiKn);
			}
			request.setAttribute("save", "okk");
		}
		else if("exportDoc".equals(request.getParameter("action")))
		{
			exportDoc(map, form, request, response);
		}
		return returnMappingForm(map,form,request,response);
	}
	public ActionForward returnMappingForm(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		if("tam".equals(request.getParameter("type")))
		{
			return map.findForward("tam");
		}
		else if("huytam".equals(request.getParameter("type")))
		{
			return map.findForward("huytam");
		}
		else return map.findForward("success"); 
	}
	public void loadTamDinhChi(ApplicationContext appContext, QDTamDinhChiThiHanhKNForm cbForm, String soHoSo) throws Exception
	{
		//tim theo soHoSo
		qdTamDinhChiKn=services.findQdTamDinhChiKN(appContext, soHoSo);
		if(qdTamDinhChiKn==null)
		{
			qdTamDinhChiKn=new KntcQdTamDinhChiKn();
			qdTamDinhChiKn.setSoHs(soHoSo);
			cbForm.tamDinhChiKn.setSoHs(soHoSo);
		}
		else {
			cbForm.tamDinhChiKn=qdTamDinhChiKn;
		}
	}
	public void loadHuyTamDinhChi(ApplicationContext appContext, QDTamDinhChiThiHanhKNForm cbForm, String soHoSo) throws Exception
	{
		// Tim theo soHoso
		KntcQdHuyTamDinhChiKN huyTamDinhChi=services.findHuyTamDinhChi(appContext, soHoSo);
		if(huyTamDinhChi==null)
		{
			huyTamDinhChi=new KntcQdHuyTamDinhChiKN();
			huyTamDinhChi.setSoHoSo(soHoSo);
			cbForm.huyDinhChiKn.setSoHoSo(soHoSo);
		}
		else {
			cbForm.huyDinhChiKn=huyTamDinhChi;
		}
	}
	
	/**
	 * Quyet dinh dinh chi khieu nai 
	 * 
	 * */
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
			StringBuffer sb = new StringBuffer("select id,so_qd,ngay_ban_hanh from kntc_qd_tam_dinh_chi_kn where so_hs= ? order by ngay_ban_hanh desc");
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
				ja.put(rs.getString("so_qd"));
				ja.put(Formater.date2str(rs.getDate("ngay_ban_hanh")));
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
	public ActionForward saveQdTamDinhChiKn(ActionMapping map, HttpServletRequest request, HttpServletResponse response, ActionForm form) throws Exception
	{
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		SoTiepDanService service = new SoTiepDanService();
		QDTamDinhChiThiHanhKNForm cmForm= (QDTamDinhChiThiHanhKNForm) form;
		String maHs=request.getParameter("id");
		try {
			KntcQdTamDinhChiKn qd=cmForm.getTamDinhChiKn();
			qd.setSoHs(maHs);
			service.saveQdTamDinhChiKn(appContext, qd);
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
		System.out.println(maHs + maPh);
		QDTamDinhChiThiHanhKNForm bbForm = (QDTamDinhChiThiHanhKNForm) form;
		SoTiepDanService service = new SoTiepDanService();
		if (!Formater.isNull(maHs)) {
			KntcQdTamDinhChiKn bb = service.getQdTamDinhChi(appContext, maHs, maPh);
			if (bb != null)
				bbForm.setTamDinhChiKn(bb);
		} else {

		}
		return map.findForward("success");
	}

	// Tao moi bien ban doi thoai 
	public ActionForward taoBienBan(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		QDTamDinhChiThiHanhKNForm bbForm=(QDTamDinhChiThiHanhKNForm) form;
		String maHs=request.getParameter("id");
		String readOnly = request.getParameter("r");
		if (readOnly != null)
			if (readOnly.equals("rol")) {
				throw new KtnbException("Bi&#7875;u m&#7851;u n&#224;y kh&#244;ng c&#243; s&#7889; li&#7879;u!!!", "", "");
			}
		bbForm.setTamDinhChiKn(new KntcQdTamDinhChiKn());
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
				service.xoaQdTamDinhChiKn(appContext, service.getQdTamDinhChi(appContext, maHs, maPh));
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
	
	
	// Export 
	public void exportTamDinhChi(HttpServletRequest request,HttpServletResponse response, ActionForm form) throws IOException
	{
		String fileIn=request.getRealPath("/docin")+ "\\TTNB41_qd_tam_dinh_chi.doc";
		String fileOut=request.getRealPath("/docout")+ "\\TTNB41_qd_tam_dinh_chi_Out"+System.currentTimeMillis()+request.getSession().getId()+".doc";
		ApplicationContext appContext=(ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		QDTamDinhChiThiHanhKNForm cbForm=(QDTamDinhChiThiHanhKNForm) form;
		MsWordUtils word=new MsWordUtils(fileIn,fileOut);
		try {
			word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
			//word.put("", appContext.getTenPhong().toUpperCase());
			word.put("[ngay_lap]",cbForm.tamDinhChiKn.getNgayBanHanhstr());
			word.put("[dia_diem_giao_nhan]", cbForm.tamDinhChiKn.getDiaDiem());
			word.put("[can_cu_van_ban]", cbForm.tamDinhChiKn.getCanCuVanBan());
			word.put("[nguoi_de_nghi]",cbForm.tamDinhChiKn.getNguoiDeNghi());
			word.put("[nguoi_ban_hanh_ten]",cbForm.tamDinhChiKn.getNguoiBhQdTen());
			word.put("[nguoi_ban_hanh_ chuc_vu]"," Ch\u1EE9c v\u1EE5 : " + cbForm.tamDinhChiKn.getNguoiBhQdChucVu());
			word.put("[don_vi_ban_hanh]",cbForm.tamDinhChiKn.getDonViBhQd());
			word.put("[don_vi_thi_hanh]",cbForm.tamDinhChiKn.getDonViThiHanh());
			word.put("[don_vi_lien_quan]", cbForm.tamDinhChiKn.getDonViLienQuan());
			word.put("[quyet_dinh_ten]",cbForm.tamDinhChiKn.getQdDinhChiTen());
			word.put("[ly_do]",cbForm.tamDinhChiKn.getLyDo());
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau quyet dinh dinh chi", ".doc", response);
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			System.out.println("Download Error : "+ e.getMessage());
		}
		finally {
			try {
				word.saveAndClose();
			} catch (Exception e) {}
		}
	}
	
	public void exportHuyTamDinhChi(HttpServletRequest request,HttpServletResponse response, ActionForm form) throws IOException
	{
		String fileIn=request.getRealPath("/docin")+ "\\TTNB_huy_quyet_dinh_tam_dinh_chi.doc";
		String fileOut=request.getRealPath("/docout")+ "\\TTNB_huy_quyet_dinh_tam_dinh_chi_Out"+System.currentTimeMillis()+request.getSession().getId()+".doc";
		ApplicationContext appContext=(ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		QDTamDinhChiThiHanhKNForm cbForm=(QDTamDinhChiThiHanhKNForm) form;
		MsWordUtils word=new MsWordUtils(fileIn,fileOut);
		try {
			word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
			//word.put("", appContext.getTenPhong().toUpperCase());
			word.put("[ngay_lap]",cbForm.huyDinhChiKn.getNgayBanHanhstr());
			word.put("[dia_diem_giao_nhan]", cbForm.huyDinhChiKn.getDiaDiem());
			word.put("[can_cu_van_ban]", cbForm.huyDinhChiKn.getVanBanCanCu());
			word.put("[nguoi_de_nghi]",cbForm.huyDinhChiKn.getNguoiDeNghi());
			word.put("[nguoi_ban_hanh_huy_bo_ten]",cbForm.huyDinhChiKn.getNguoiBhHuyTen());
			word.put("[nguoi_ban_hanh_huy_bo_chuc_vu]"," Ch\u1EE9c v\u1EE5 : " + cbForm.huyDinhChiKn.getNguoiBhChucVu());
			word.put("[nguoi_ban_hanh_qd_hanh_chi_bi_kn_ten]",cbForm.huyDinhChiKn.getNguoiBhQdHcTen());
			word.put("[nguoi_ban_hanh_qd_hanh_chi_bi_kn_chuc_vu]"," Ch\u1EE9c v\u1EE5 : " + cbForm.huyDinhChiKn.getNguoiBhQdHcCvu());
			word.put("[don_vi_thi_hanh]", cbForm.huyDinhChiKn.getDonViThiHanh());
			word.put("[don_vi_lien_quan]",cbForm.huyDinhChiKn.getDonViLienQuan());
			word.put("[huy_bo_quyet_dinh]",cbForm.huyDinhChiKn.getTenQdHuy());
			word.put("[ly_do]",cbForm.huyDinhChiKn.getLyDoHuy());
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau quyet huy quyet dinh dinh chi", ".doc", response);
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			System.out.println("Download Error : "+ e.getMessage());
		}
		finally {
			try {
				word.saveAndClose();
			} catch (Exception e) {}
		}
	}
	protected String getDocInName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		if("tam".equals(request.getParameter("type")))
		{
			return request.getRealPath("/docin")+ "\\TTNB41_qd_tam_dinh_chi.doc";
		}
		else if ("huytam".equals(request.getParameter("type")))
		{
			return request.getRealPath("/docin")+ "\\TTNB_huy_quyet_dinh_tam_dinh_chi.doc";
		}
		else return "";
	}
	protected String getDocOutName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		if("tam".equals(request.getParameter("type")))
		{
			return request.getRealPath("/docout")+ "\\TTNB41_qd_tam_dinh_chi_Out"+System.currentTimeMillis()+request.getSession().getId()+".doc";
		}
		else if("huytam".equals(request.getParameter("type")))
		{
			return request.getRealPath("/docout")+ "\\TTNB_huy_quyet_dinh_tam_dinh_chi_Out"+System.currentTimeMillis()+request.getSession().getId()+".doc";
		}
		else return null;
	}
	protected String getFileOutName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		if("tam".equals(request.getParameter("type")))
		{
			return "Tam Dinh Chi KN";
		}
		else if("huytam".equals(request.getParameter("type")))
		{
			return "Huy Tam Dinh Chi KN";
		}
		else return "";
	}
	public void pushData(MsWordUtils word, HttpServletRequest request, ActionForm form) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
