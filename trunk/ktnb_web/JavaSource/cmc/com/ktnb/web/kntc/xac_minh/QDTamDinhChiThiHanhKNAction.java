package cmc.com.ktnb.web.kntc.xac_minh;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import cmc.com.ktnb.pl.hb.entity.KntcQdHuyTamDinhChiKN;
import cmc.com.ktnb.pl.hb.entity.KntcQdTamDinhChiKn;
import cmc.com.ktnb.service.kntc.XuLyPhuKhieuNaiToCaoService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
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
				qdTamDinhChiKn=cbForm.tamDinhChiKn;
				services.saveTamDinhChiKn(request, appContext, qdTamDinhChiKn);
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
