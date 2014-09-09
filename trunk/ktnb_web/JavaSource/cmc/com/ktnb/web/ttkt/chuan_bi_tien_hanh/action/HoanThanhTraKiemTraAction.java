package cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbHoan;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.form.HoanThanhTraKiemTraForm;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;

/**
 * @version 1.0
 * @author
 */
public class HoanThanhTraKiemTraAction extends BaseDispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		HoanThanhTraKiemTraForm hoanThanhTraKiemTraForm = (HoanThanhTraKiemTraForm) form;

		ApplicationContext app = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String cuocTtktId = request.getParameter("idCuocTtkt");
		String method = request.getParameter("method");

		if (cuocTtktId != null)
			hoanThanhTraKiemTraForm.setIdCuocTtKt(cuocTtktId);

		if ("save".equals(method)) {
			saveHoanTtKt(request, hoanThanhTraKiemTraForm, app);
			request.setAttribute("saveStatus", "ok");
		} else {
			loadDefaulForm(hoanThanhTraKiemTraForm, app, request, cuocTtktId);
			if (!KtnbUtil.haveRoleNv(app) || app.getTrangThaiCuocTtkt(hoanThanhTraKiemTraForm.getIdCuocTtKt()).equals(Constants.TT_TTKT_KT))
				request.setAttribute("readOnly", "true");
		}

		return mapping.findForward("success");
	}

	private void loadDefaulForm(HoanThanhTraKiemTraForm hoanThanhTraKiemTraForm, ApplicationContext app, HttpServletRequest request, String cuocTtktId) throws Exception {
		TtktCbHoan hoanTtKt = TtktCnPhuService.getHoanTtKt(app, cuocTtktId);

		if (hoanTtKt != null) {
			hoanThanhTraKiemTraForm.setId(hoanTtKt.getId());
			hoanThanhTraKiemTraForm.setIdCuocTtKt(hoanTtKt.getIdCuocTtkt());
			hoanThanhTraKiemTraForm.setLyDoHoan(hoanTtKt.getLyDoHoan());
			hoanThanhTraKiemTraForm.setNgayBatDauLai(Formater.date2str(hoanTtKt.getNgayBatDauLai()));
			hoanThanhTraKiemTraForm.setNgayHoan(Formater.date2str(hoanTtKt.getNgayHoan()));
			
			hoanThanhTraKiemTraForm.setNgayBatDauThucTe(Formater.date2str(hoanTtKt.getNgayBatDauThucTe()));
			if (hoanTtKt.getCqtDeNghi().booleanValue()){
				hoanThanhTraKiemTraForm.setCqtDeNghi("true");
				hoanThanhTraKiemTraForm.setIdVbThongBaoHoan(hoanTtKt.getIdVbThongBaoHoan());
			}
				
			else{
				hoanThanhTraKiemTraForm.setCqtDeNghi("false");
				hoanThanhTraKiemTraForm.setIdVbHoan(hoanTtKt.getIdVbXinHoan());
				hoanThanhTraKiemTraForm.setIdVbTraLoi(hoanTtKt.getIdVbTraLoi());
			}
				
		} else {

			hoanThanhTraKiemTraForm.setCqtDeNghi("true");
		}
	}

	private void saveHoanTtKt(HttpServletRequest request, HoanThanhTraKiemTraForm hoanThanhTraKiemTraForm, ApplicationContext app) throws Exception {
		TtktCbHoan hoanTtKt = createHoanTtKt(hoanThanhTraKiemTraForm, app, request);
		TtktCnPhuService.saveHoanTtKt(hoanTtKt, app, hoanThanhTraKiemTraForm);
	}

	private TtktCbHoan createHoanTtKt(HoanThanhTraKiemTraForm hoanTtktForm, ApplicationContext app, HttpServletRequest request) throws Exception {
		TtktCbHoan hoanTtKt = new TtktCbHoan();
		hoanTtKt.setCqtDeNghi((hoanTtktForm.getCqtDeNghi().equals("true")) ? Boolean.TRUE : Boolean.FALSE);
		hoanTtKt.setId(hoanTtktForm.getId());
		hoanTtKt.setIdCuocTtkt(hoanTtktForm.getIdCuocTtKt());
		hoanTtKt.setLyDoHoan(hoanTtktForm.getLyDoHoan());
		hoanTtKt.setNgayBatDauLai(Formater.str2SQLdate(hoanTtktForm.getNgayBatDauLai()));
		hoanTtKt.setNgayBatDauThucTe(Formater.str2SQLdate(hoanTtktForm.getNgayBatDauThucTe()));
		hoanTtKt.setNgayHoan(Formater.str2SQLdate(hoanTtktForm.getNgayHoan()));
		hoanTtKt.setIdNguoiCapNat(app.getMaCanbo());
		hoanTtKt.setTenNguoiCapNhat(app.getTenCanbo());
		hoanTtKt.setNgayCapNhat(new Date());
		
		// Hoan do don vi duoc Thanh tra Kiem tra
		if ("false".equals(hoanTtktForm.getCqtDeNghi())){
			hoanTtKt.setIdVbXinHoan(hoanTtktForm.getIdVbHoan());
			hoanTtKt.setIdVbTraLoi(hoanTtktForm.getIdVbTraLoi());
		}else{
			hoanTtKt.setIdVbThongBaoHoan(hoanTtktForm.getIdVbThongBaoHoan());
		}
			

		return hoanTtKt;
	}
}
