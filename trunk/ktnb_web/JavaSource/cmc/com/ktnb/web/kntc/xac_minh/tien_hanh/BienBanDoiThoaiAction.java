package cmc.com.ktnb.web.kntc.xac_minh.tien_hanh;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import cmc.com.ktnb.pl.hb.entity.KntcBbDoiThoai;
import cmc.com.ktnb.service.kntc.XuLyPhuKhieuNaiToCaoService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.MsWordUtils;
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
			khieuNaiToCaoService.saveBienBanDoiThoai(request, appContext, bbDoiThoai);
			request.setAttribute("save", "ok");
		}
		if ("exportDoc".equals(request.getParameter("action")))
			exportDoc(map, form, request, response);
		return map.findForward("success");
	}

	public void loadDefauldForm(ApplicationContext appContext, BienBanDoiThoaiForm cbForm, String soHoSo) throws Exception {
		bbDoiThoai = khieuNaiToCaoService.findBbDoiThoai(appContext, soHoSo);
		if (bbDoiThoai == null) {
			// Khoi tao lai bb doi thoai, set so ho so cho cbForm
			bbDoiThoai = new KntcBbDoiThoai();
		} else
			cbForm.bbDoiThoai = bbDoiThoai;
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
