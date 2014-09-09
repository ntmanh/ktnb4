/*
 * Created on Nov 1, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.ke_hoach_nam.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhDuyetKeHoach;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.ke_hoach_nam.form.DuyetKeHoachForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktService;

/**
 * @author ntdung1
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DuyetKeHoachAction extends BaseDispatchAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception, Exception {
		DuyetKeHoachForm duyetKeHoachForm = (DuyetKeHoachForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String strMethod = request.getParameter("method");
		if ("save".equals(strMethod)) {
			if(!existKehoach(appContext, appContext.getMaCqt(), duyetKeHoachForm.getKeHoachNam())){
				//KtnbUtil.showBussinessExceiption(request, reponse, "Kh\u00F4ng th\u1EC3 duy\u1EC7t do ch\u01B0a c\u00F3 cu\u1ED9c Ki\u1EC3m tra n\u00E0o!");
				request.setAttribute("khong_co_cuoc_kh", "true");
				return mapping.findForward("view");			
			}
			TtktKhDuyetKeHoach duyetKeHoach = createDuyetKeHoach(appContext, request, duyetKeHoachForm);
			TtktService.saveDuyetKeHoach(appContext, duyetKeHoach);
			request.setAttribute("save", "ok");
		} else {			
			String namKeHoach = request.getParameter("nam");
			if (Formater.isNull(duyetKeHoachForm.getKeHoachNam()))
				duyetKeHoachForm.setKeHoachNam(namKeHoach);
				duyetKeHoachForm.setNoiKyTrinh(appContext.getDiaBan());
				duyetKeHoachForm.setNoiPheDuyet(appContext.getDiaBan());
			TtktKhDuyetKeHoach duyetKeHoach = TtktService.getDuyetKeHoach(appContext, duyetKeHoachForm.getKeHoachNam());
			if (duyetKeHoach != null) {
				duyetKeHoachForm.setId(duyetKeHoach.getId());
				duyetKeHoachForm.setKeHoachNam(String.valueOf(duyetKeHoach.getKeHoachNam()));
				duyetKeHoachForm.setNgayKyTrinh(Formater.date2str(duyetKeHoach.getNgayKyTrinh()));
				duyetKeHoachForm.setNgayPheDuyet(Formater.date2str(duyetKeHoach.getNgayPheDuyet()));
				duyetKeHoachForm.setNoiKyTrinh(duyetKeHoach.getNoiKyTrinh());
				duyetKeHoachForm.setNoiPheDuyet(duyetKeHoach.getNoiPheDuyet());
				duyetKeHoachForm.setYkienPheDuyet(duyetKeHoach.getYkienPheDuyet());
			}
		}
		return mapping.findForward("view");
	}

	private boolean existKehoach(ApplicationContext appContext, String maCqt, String namKeHoach) throws Exception {
		return CuocTtktService.getKhNam(appContext, maCqt, namKeHoach).size() > 0;
	}

	/**
	 * @param appContext
	 * @param request
	 * @param duyetKeHoachForm
	 * @return
	 */
	private TtktKhDuyetKeHoach createDuyetKeHoach(ApplicationContext appContext, HttpServletRequest request, DuyetKeHoachForm duyetKeHoachForm) throws Exception {
		TtktKhDuyetKeHoach duyetKeHoach = new TtktKhDuyetKeHoach();
		duyetKeHoach.setId(duyetKeHoachForm.getId());
		duyetKeHoach.setKeHoachNam((new Long(duyetKeHoachForm.getKeHoachNam())).longValue());
		duyetKeHoach.setMaCqt(appContext.getMaCqt());
		duyetKeHoach.setNgayKyTrinh(Formater.str2date(duyetKeHoachForm.getNgayKyTrinh()));
		duyetKeHoach.setNgayPheDuyet(Formater.str2date(duyetKeHoachForm.getNgayPheDuyet()));
		duyetKeHoach.setNoiKyTrinh(duyetKeHoachForm.getNoiKyTrinh());
		duyetKeHoach.setNoiPheDuyet(duyetKeHoachForm.getNoiPheDuyet());
		duyetKeHoach.setTenCqt(appContext.getTenCqt());
		duyetKeHoach.setYkienPheDuyet(duyetKeHoachForm.getYkienPheDuyet());
		duyetKeHoach.setIdNguoiCapNat(appContext.getMaCanbo());
		duyetKeHoach.setTenNguoiCapNhat(appContext.getTenCanbo());
		duyetKeHoach.setNgayCapNhat(new Date());
		
		return duyetKeHoach;
	}

}
