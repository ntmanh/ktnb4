package cmc.com.ktnb.web.kntc.xac_minh;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import cmc.com.ktnb.pl.hb.entity.KntcQdDinhChiKN;
import cmc.com.ktnb.service.kntc.XuLyPhuKhieuNaiToCaoService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.kntc.xu_ly.PrintAction;

public class QuyetDinhDinhChiKNAction extends PrintAction {
	KntcQdDinhChiKN dinhChiKN = new KntcQdDinhChiKN();

	XuLyPhuKhieuNaiToCaoService services = new XuLyPhuKhieuNaiToCaoService();

	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		QuyetDinhDinhChiKNForm cbForm = (QuyetDinhDinhChiKNForm) form;
		String soHoSo = request.getParameter("id");
		if ("view".equals(request.getParameter("action")))
		{
			if (!Formater.isNull(soHoSo)) {
				loadDefauldForm(appContext, cbForm, soHoSo);
			}
		}
		else if ("save".equals(request.getParameter("action"))) {
			dinhChiKN = cbForm.qdDinhChiKN;
			services.saveQdDinhChiKn(request, appContext, dinhChiKN);
			request.setAttribute("save", "okk");
		}
		else if("exportDoc".equals(request.getParameter("action")))
		{
			exportDoc(map, form, request, response);
		}
		return map.findForward("success");
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

	// Export file doc
	protected String getDocInName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return request.getRealPath("/docin") + "\\TTNB_qd_dinh_chi_gq_kn.doc";
	}

	protected String getDocOutName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return request.getRealPath("/docout") + "\\TTNB_qd_dinh_chi_gq_kn.doc_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
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
