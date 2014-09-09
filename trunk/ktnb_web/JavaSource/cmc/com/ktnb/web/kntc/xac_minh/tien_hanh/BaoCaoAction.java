package cmc.com.ktnb.web.kntc.xac_minh.tien_hanh;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;
import org.json.JSONObject;

import cmc.com.ktnb.pl.hb.entity.KntcBaoCao;
import cmc.com.ktnb.pl.hb.entity.KntcQdxmPhieuYc;
import cmc.com.ktnb.service.kntc.XacMinhService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HttpUtil;
import cmc.com.ktnb.util.KntcDAO;
import cmc.com.ktnb.util.KntcUtil;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.web.BaseDispatchAction;

/**
 * Xử lý báo cáo
 * @author Ntthu
 * @since 04/2011
 */
public class BaoCaoAction extends BaseDispatchAction {
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaoCaoForm cnForm = (BaoCaoForm) form;
		String maQd = request.getParameter("id");
		cnForm.setNguoiLapBc(appContext.getTenCanbo());
		cnForm.setNguoiLapBcChucVu(appContext.getTenChucvu());
		cnForm.setNguoiLapBcDvCt(appContext.getTenPhong() + ", " + appContext.getTenCqt());
		cnForm.setNgayLap(Formater.date2str(new Date()));
		cnForm.setDiaDiem(appContext.getTenCqt());
		XacMinhService service = new XacMinhService();
		if (!Formater.isNull(maQd)) {
			cnForm.setDoanXm("Theo Q\u0110 s\u1ED1 " + maQd);
			cnForm.setKntcQdinhXm(maQd);
			cnForm.setMaHoSo(service.getKntcQdinhXm(appContext, maQd).getMaHs());
			KntcQdxmPhieuYc pYc = service.getPhieuYeuCau(appContext, maQd, KntcQdxmPhieuYc.PHIEU_YC_GIAI_TRINH);
			if (pYc != null) {
				cnForm.setNgayPhieuYcgt(Formater.date2str(pYc.getThoiDiemYcgt()));
				if (!Formater.isNull(pYc.getNguoiNhanBc()))
					cnForm.setNguoiLapBc(pYc.getNguoiNhanBc());
			}
		}
		// Lay danh sach cac phieu y/c giai trinh
		ArrayList list = (ArrayList) request.getAttribute("dmtq");
		if (list == null) { // Chua co trong session
			list = new ArrayList();
			Collection dmTien = service.getListPhieuYeuCauGt(appContext, maQd);
			for (Iterator iter = dmTien.iterator(); iter.hasNext();) {
				KntcQdxmPhieuYc phieuYcGt = (KntcQdxmPhieuYc) iter.next();
				list.add(new LabelValueBean(Formater.date2str(phieuYcGt.getNgayLap()), Formater.date2str(phieuYcGt.getNgayLap())));
			}
			request.setAttribute("dmtq", list);
		}
		saveToken(request);
		return map.findForward("success");
	}

	public ActionForward save(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaoCaoForm tdForm = (BaoCaoForm) form;
		// if (isTokenValid(request, true)) {
		try {

			KntcBaoCao qd = tdForm.toEntity();
			// Luu xuong DB
			XacMinhService services = new XacMinhService();
			services.saveBaoCao(appContext, qd, KntcBaoCao.BAO_CAO_GIAI_TRINH_XAC_MINH);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		HttpUtil.doForward("kntc_xm_bao_cao.do?method=show&action=baoCaoGt&id=" + tdForm.getKntcQdinhXm(), request, response);
		// }
		return map.findForward(null);
	}

	public ActionForward getListPhieu(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String maHs = request.getParameter("maHs");
		String loaiPhieu = request.getParameter("t");
		if (Formater.isNull(maHs) || Formater.isNull(loaiPhieu))
			return null;
		else {
			JSONObject jsonResult = null;
			KntcDAO kntcDAO = KntcUtil.getKntcDAO();
			try {
				jsonResult = kntcDAO.getListBaoCao(maHs, loaiPhieu);
				response.setContentType("application/json;charset=UTF-8");
				response.setHeader("Cache-Control", "no-store");
				PrintWriter out = response.getWriter();
				out.println(jsonResult);
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				KntcUtil.releaseKntcDAO(kntcDAO);
			}
		}
		return null;
	}

	public ActionForward in(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ApplicationContext c = (ApplicationContext)
		// request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		BaoCaoForm xmForm = (BaoCaoForm) form;
		String su = "kntc14b";
		String maHoSo = xmForm.getKntcQdinhXm();
		if (!Formater.isNull(maHoSo)) {
			parameters.put("doan_to_xac_minh_quyet_dinh_so", xmForm.getDoanXm());
			parameters.put("nguoi_lap_bao_giai_trinh", xmForm.getNguoiLapBc());
			parameters.put("chuc_vu", xmForm.getNguoiLapBcChucVu());
			parameters.put("don_vi_cong_tac", xmForm.getNguoiLapBcDvCt());
			parameters.put("phieu_yeu_cau_giai_trinh_ngay", Formater.getDateForPrint(xmForm.getNgayPhieuYcgt()));
			parameters.put("noi_dung_giai_trinh", xmForm.getNoiDungGt());
			String ngayLap = "";
			if (Formater.isNull(xmForm.getNgayLap())) {
				ngayLap = "ng\u00E0y    th\u00E1ng    n\u0103m        ";				
			} else
				ngayLap = Formater.getDateForPrint(xmForm.getNgayLap());
			parameters.put("ngay_lap_bao_cao", xmForm.getDiaDiem() + ", " + ngayLap);			
		}
		InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + su + ".jasper");
		KtnbUtil.printf(reportRows, su, response, inputStream, parameters, null);
		return null;
	}
}
