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

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KntcCanBoRls;
import cmc.com.ktnb.pl.hb.entity.KntcDeXuatXly;
import cmc.com.ktnb.pl.hb.entity.KntcQdinhXm;
import cmc.com.ktnb.pl.hb.entity.KntcQdxmPhieuYc;
import cmc.com.ktnb.service.kntc.PhanLoaiXuLyService;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.service.kntc.XacMinhService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HttpUtil;
import cmc.com.ktnb.util.KntcDAO;
import cmc.com.ktnb.util.KntcUtil;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;

/**
 * Xử lý thông tin các phiếu trong quá trình xác minh
 * 
 * @author Ntthu
 */
public class PhieuYeuCauHsTlAction extends BaseDispatchAction {
	// Show phieu yeu cau 13
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuYeuCauForm pycForm = (PhieuYeuCauForm) form;
		String maHs = request.getParameter("id");
		XacMinhService s = new XacMinhService();

		String readOnly = request.getParameter("r");
		if (readOnly != null)
			if (readOnly.equals("rol")) {
				if (s.getPhieuYeuCau(appContext, maHs, KntcQdxmPhieuYc.PHIEU_YC_HO_SO_TL) == null) {
					throw new KtnbException("Bi&#7875;u m&#7851;u n&#224;y kh&#244;ng c&#243; s&#7889; li&#7879;u!!!", "", "");
				}
			}

		KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, maHs);

		if (qd == null || qd.getNgayDuyet() == null) {
			throw new KtnbException("Ch&#x1B0;a c&#xF3; Quy&#x1EBF;t &#x111;&#x1ECB;nh x&#xE1;c minh, ho&#x1EB7;c Q&#x110;XM ch&#x1B0;a &#x111;&#x1B0;&#x1EE3;c duy&#x1EC7;t!", "",
					"C&#7847;n ho&#224;n thi&#7879;n Quy&#7871;t &#273;&#7883;nh x&#225;c minh tr&#432;&#7899;c khi l&#224;m c&#225;c bi&#7875;u m&#7851;u ti&#7871;p theo!");
		}

		String maQd = qd.getMaQd();
		if (!Formater.isNull(maQd)) {
			pycForm.setKntcQdinhXm(maQd);
			SoTiepDanService std = new SoTiepDanService();

			KntcQdinhXm qdXm = s.getKntcQdinhXmByHoSo(appContext, maHs);
			pycForm.setMaHoSo(qdXm.getMaHs());

			pycForm.setThoiDiemYcgt(Formater.date2strDateTimeForNV(new Date()));
			pycForm.setThoiGianNhanPhieu(Formater.date2strDateTimeForNV(new Date()));
			pycForm.setMaPhieu(KtnbUtil.getMaNvu(appContext, "HSTL"));
			pycForm.setNgayLap(Formater.date2str(new Date()));
			pycForm.setDiaDiem(appContext.getDiaBan());
			/*
			 * StringBuffer sb = new StringBuffer("+ " +
			 * std.getNoiDungDonForXm(appContext, qdXm.getMaHs()));
			 * sb.append("\n+ "); if (s.getKntcXmKeHoachByHoSo(appContext,
			 * qdXm.getMaHs()) != null)
			 * sb.append(s.getKntcXmKeHoachByHoSo(appContext,
			 * qdXm.getMaHs()).getBangChung());
			 * pycForm.setYcHoSo(sb.toString());
			 */
			Collection listCb = s.getListCanBoXmByHs(appContext, qdXm.getMaHs());
			// Danh sach can bo xac minh
			ArrayList list = (ArrayList) request.getAttribute("dmcb");
			if (list == null) { // Chua co trong session
				list = new ArrayList();
				for (Iterator iter = listCb.iterator(); iter.hasNext();) {
					KntcCanBoRls element = (KntcCanBoRls) iter.next();
					list.add(new LabelValueBean(element.getTenCb() + ", Ch\u1EE9c v\u1EE5: " + element.getVaiTro(), element.getTenCb() + ", Ch\u1EE9c v\u1EE5: " + element.getVaiTro()));
				}
			}
			request.setAttribute("dmcb", list);
		}
		return ReturnDefaultPycHsTl(map, form, request, response);
	}

	// Xem phieu yeu cau 13
	public ActionForward xemPycHstl(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("id");
		XacMinhService s = new XacMinhService();
		KntcQdinhXm qdXm = s.getKntcQdinhXmByHoSo(appContext, maHs);
		String maQD = qdXm.getMaQd();
		try {
			KntcQdxmPhieuYc pyc = s.getPhieuYeuCauById(appContext, request.getParameter("pId").toString());
			PhieuYeuCauForm tdForm = (PhieuYeuCauForm) form;
			tdForm.fromPyc(pyc);
			Collection listCb = s.getListCanBoXmByHs(appContext, qdXm.getMaHs());
			// Danh sach can bo xac minh
			ArrayList list = (ArrayList) request.getAttribute("dmcb");
			if (list == null) { // Chua co trong session
				list = new ArrayList();
				for (Iterator iter = listCb.iterator(); iter.hasNext();) {
					KntcCanBoRls element = (KntcCanBoRls) iter.next();
					list.add(new LabelValueBean(element.getTenCb() + ", Ch\u1EE9c v\u1EE5: " + element.getVaiTro(), element.getTenCb() + ", Ch\u1EE9c v\u1EE5: " + element.getVaiTro()));
				}
			}
			tdForm.setNguoiNhanBc(pyc.getNguoiNhanBc());
			tdForm.setNgayLap(Formater.dateTimeToDate(tdForm.getNgayLap()));
			request.setAttribute("dmcb", list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return ReturnDefaultPycHsTl(map, form, request, response);
	}

	// Xoa phieu yeu cau 13
	public ActionForward xoaPycHstl(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("id");
		XacMinhService s = new XacMinhService();
		KntcQdinhXm qdXm = s.getKntcQdinhXmByHoSo(appContext, maHs);
		String maQD = qdXm.getMaQd();
		try {
			s.delPycByMaPhieu(appContext, request.getParameter("pId").toString());
			request.setAttribute("xoaThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("xoaThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		// PhieuYeuCauForm tdForm = (PhieuYeuCauForm) form;
		// KntcQdxmPhieuYc pyc = s.getPhieuYeuCauById(appContext,
		// request.getParameter("pId").toString());
		Collection listCb = s.getListCanBoXmByHs(appContext, maHs);
		// Danh sach can bo xac minh
		ArrayList list = (ArrayList) request.getAttribute("dmcb");
		if (list == null) { // Chua co trong session
			list = new ArrayList();
			for (Iterator iter = listCb.iterator(); iter.hasNext();) {
				KntcCanBoRls element = (KntcCanBoRls) iter.next();
				list.add(new LabelValueBean(element.getTenCb() + ", Ch\u1EE9c v\u1EE5: " + element.getVaiTro(), element.getTenCb() + ", Ch\u1EE9c v\u1EE5: " + element.getVaiTro()));
			}
		}
		request.setAttribute("dmcb", list);
		return ReturnDefaultPycHsTl(map, form, request, response);
	}

	// Tao moi phieu yeu cau 13
	public ActionForward taoMoiPycHstl(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("id");
		XacMinhService s = new XacMinhService();
		KntcQdinhXm qdXm = s.getKntcQdinhXmByHoSo(appContext, maHs);
		String maQd = qdXm.getMaQd();
		PhieuYeuCauForm pycForm = (PhieuYeuCauForm) form;
		if (!Formater.isNull(maQd)) {
			pycForm.setKntcQdinhXm(maQd);
			SoTiepDanService std = new SoTiepDanService();
			pycForm.setMaHoSo(qdXm.getMaHs());
			pycForm.setThoiDiemYcgt(Formater.date2strDateTimeForNV(new Date()));
			pycForm.setThoiGianNhanPhieu(Formater.date2strDateTimeForNV(new Date()));
			pycForm.setMaPhieu(KtnbUtil.getMaNvu(appContext, "HSTL"));
			pycForm.setNgayLap(Formater.date2str(new Date()));
			/*
			 * StringBuffer sb = new StringBuffer("+ " +
			 * std.getNoiDungDonForXm(appContext, qdXm.getMaHs()));
			 * sb.append("\n+ "); if (s.getKntcXmKeHoachByHoSo(appContext,
			 * qdXm.getMaHs()) != null)
			 * sb.append(s.getKntcXmKeHoachByHoSo(appContext,
			 * qdXm.getMaHs()).getBangChung());
			 * pycForm.setYcHoSo(sb.toString());
			 */
			pycForm.setYcHoSo("");
			pycForm.setDiaDiem(appContext.getDiaBan());
			pycForm.setDonViYcgt("");
			pycForm.setYcBaoCao("");
			pycForm.setNguoiNhanPhieu("");
			pycForm.setNguoiNhanPhieuChucVu("");
			pycForm.setLanYc("");
			pycForm.setMa(null);

			Collection listCb = s.getListCanBoXmByHs(appContext, qdXm.getMaHs());
			ArrayList list = (ArrayList) request.getAttribute("dmcb");
			if (list == null) {
				list = new ArrayList();
				for (Iterator iter = listCb.iterator(); iter.hasNext();) {
					KntcCanBoRls element = (KntcCanBoRls) iter.next();
					list.add(new LabelValueBean(element.getTenCb() + ", Ch\u1EE9c v\u1EE5: " + element.getVaiTro(), element.getTenCb() + ", Ch\u1EE9c v\u1EE5: " + element.getVaiTro()));
				}
			}
			request.setAttribute("dmcb", list);
		}
		return ReturnDefaultPycHsTl(map, form, request, response);
	}

	// Return default Pychstl
	public ActionForward ReturnDefaultPycHsTl(ActionMapping map,ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		if("phieuYcHsTlTC".equals(request.getParameter("action")))
			return map.findForward("phieuYcHsTlTC");
		else
		return map.findForward("success");
	}
	// Save phieu yeu cau hstl 13
	public ActionForward savePyc(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuYeuCauForm tdForm = (PhieuYeuCauForm) form;
		String action = request.getParameter("action");
		// if (isTokenValid(request, true)) {
		try {
			KntcQdxmPhieuYc pyc = tdForm.toEntity();
			pyc.setLoaiPhieu(KntcQdxmPhieuYc.PHIEU_YC_HO_SO_TL);
			// Luu xuong DB
			XacMinhService services = new XacMinhService();
			services.savePhieuYeuCau(appContext, pyc);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		// }
		HttpUtil.doForward("kntc_xm_phieu_yc.do?method=show&action=" + action + "&id=" + tdForm.getMaHoSo(), request, response);
		return null;
	}

	// Show yeu cau giai trinh 14A
	public ActionForward ycgt(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuYeuCauForm ycgtForm = (PhieuYeuCauForm) form;
		String maHs = request.getParameter("id");
		XacMinhService s = new XacMinhService();

		String readOnly = request.getParameter("r");
		if (readOnly != null)
			if (readOnly.equals("rol")) {
				if (s.getPhieuYeuCau(appContext, maHs, KntcQdxmPhieuYc.PHIEU_YC_GIAI_TRINH) == null) {
					throw new KtnbException("Bi&#7875;u m&#7851;u n&#224;y kh&#244;ng c&#243; s&#7889; li&#7879;u!!!", "", "");
				}
			}

		KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, maHs);
		if (qd == null || qd.getNgayDuyet() == null) {
			throw new KtnbException("Ch&#x1B0;a c&#xF3; Quy&#x1EBF;t &#x111;&#x1ECB;nh x&#xE1;c minh, ho&#x1EB7;c Q&#x110;XM ch&#x1B0;a &#x111;&#x1B0;&#x1EE3;c duy&#x1EC7;t!", "",
					"C&#7847;n ho&#224;n thi&#7879;n Quy&#7871;t &#273;&#7883;nh x&#225;c minh tr&#432;&#7899;c khi l&#224;m c&#225;c bi&#7875;u m&#7851;u ti&#7871;p theo!");
		}
		String maQd = qd.getMaQd();
		if (!Formater.isNull(maQd)) {
			ycgtForm.setKntcQdinhXm(maQd);
			ycgtForm.setMaHoSo(qd.getMaHs());
		}
		ycgtForm.setDiaDiem(appContext.getDiaBan());
		ycgtForm.setThoiDiemYcgt(Formater.date2strDateTimeForNV(new Date()));
		ycgtForm.setNgayLap(Formater.date2strDateTimeForNV(new Date()));
		saveToken(request);
		return ReturnDefaultYcgt(map, form, request, response);
	}

	// Xem Yeu cau giai trinh 14A
	public ActionForward xemYcgt(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhService s = new XacMinhService();
		try {
			// KntcQdinhXm qdXm = s.getKntcQdinhXm(appContext,
			// request.getParameter("id").toString());
			KntcQdxmPhieuYc pyc = s.getPhieuYeuCauById(appContext, request.getParameter("pId").toString());
			System.out.println(request.getParameter("pId").toString());
			PhieuYeuCauForm ycgtForm = (PhieuYeuCauForm) form;
			ycgtForm.fromPyc(pyc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return ReturnDefaultYcgt(map, form, request, response);
	}

	// Xoa Yeu cau giai trinh 14A
	public ActionForward xoaYcgt(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhService s = new XacMinhService();
		try {
			s.delPycByMaPhieu(appContext, request.getParameter("pId").toString());
			request.setAttribute("xoaThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("xoaThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		return ReturnDefaultYcgt(map, form, request, response);
	}

	// Tao moi Yeu cau giai trinh 14A
	public ActionForward taoMoiYcgt(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("id");
		XacMinhService s = new XacMinhService();
		KntcQdinhXm qdXm = s.getKntcQdinhXmByHoSo(appContext, maHs);
		String maQd = qdXm.getMaQd();
		PhieuYeuCauForm ycgtForm = (PhieuYeuCauForm) form;
		if (!Formater.isNull(maQd)) {
			ycgtForm.setKntcQdinhXm(maQd);
			ycgtForm.setMaHoSo(qdXm.getMaHs());
		}
		// ycgtForm.setMaPhieu(KtnbUtil.getMaNvu(appContext, "PYC/NKNGT"));
		ycgtForm.setDiaDiem(appContext.getDiaBan());
		ycgtForm.setThoiDiemYcgt(Formater.date2strDateTimeForNV(new Date()));
		ycgtForm.setNgayLap(Formater.date2strDateTimeForNV(new Date()));

		ycgtForm.setDonViYcgt("");
		ycgtForm.setYeuCauYcgt("");
		ycgtForm.setDiaDiemYcgt(appContext.getDiaBan());
		ycgtForm.setMa(null);

		return ReturnDefaultYcgt(map, form, request, response);
	}

	// Save yeu cau giai trinh 14A
	public ActionForward saveYcgt(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// if (isTokenValid(request, true)) {
		try {
			PhieuYeuCauForm tdForm = (PhieuYeuCauForm) form;
			KntcQdxmPhieuYc qd = tdForm.toEntity();
			qd.setLoaiPhieu(KntcQdxmPhieuYc.PHIEU_YC_GIAI_TRINH);
			// Luu xuong DB
			XacMinhService services = new XacMinhService();
			services.savePhieuYeuCau(appContext, qd);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		// }
		return ReturnDefaultYcgt(map, form, request, response);
	}

	public ActionForward ReturnDefaultYcgt(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		String loaiYcgt = request.getParameter("action");
		System.out.println("Loai yeu cau giai thich :  " + loaiYcgt);
		if ("phieuYcGtTC".equals(loaiYcgt))
			return map.findForward("ycgtTC");
		else if ("phieuYcGtKN".equals(loaiYcgt))
			return map.findForward("ycgtKN");
		else
			return map.findForward("ycgt");
	}

	// Show y kien tu van 15A
	public ActionForward yktv(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuYeuCauForm ycgtForm = (PhieuYeuCauForm) form;
		String maHs = request.getParameter("id");
		PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
		KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
		XacMinhService s = new XacMinhService();

		String readOnly = request.getParameter("r");
		if (readOnly != null)
			if (readOnly.equals("rol")) {
				if (s.getPhieuYeuCau(appContext, maHs, KntcQdxmPhieuYc.PHIEU_LAY_Y_KIEN_TU_VAN) == null) {
					throw new KtnbException("Bi&#7875;u m&#7851;u n&#224;y kh&#244;ng c&#243; s&#7889; li&#7879;u!!!", "", "");
				}
			}

		KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, maHs);
		// Riêng mẫu này chỉ check quyết định khi hồ sơ phải xác minh, giải
		// quyết ngay thì không cần check
		if ("0".equals(dx.getIsGquyetNgay().toString())) {
			if (qd == null || qd.getNgayDuyet() == null) {
				throw new KtnbException("Ch&#x1B0;a c&#xF3; Quy&#x1EBF;t &#x111;&#x1ECB;nh x&#xE1;c minh, ho&#x1EB7;c Q&#x110;XM ch&#x1B0;a &#x111;&#x1B0;&#x1EE3;c duy&#x1EC7;t!", "",
						"C&#7847;n ho&#224;n thi&#7879;n Quy&#7871;t &#273;&#7883;nh x&#225;c minh tr&#432;&#7899;c khi l&#224;m c&#225;c bi&#7875;u m&#7851;u ti&#7871;p theo!");
			}
		}
		/*
		 * String maQd = qd.getMaQd(); if (!Formater.isNull(maQd)) {
		 * ycgtForm.setKntcQdinhXm(maQd); ycgtForm.setMaHoSo(qd.getMaHs()); }
		 */
		ycgtForm.setMaHoSo(dx.getMaHs());
		ycgtForm.setMaPhieu(KtnbUtil.getMaNvu(appContext, "YKTV"));
		ycgtForm.setThoiDiemYcgt(Formater.date2str(new Date()));
		ycgtForm.setNgayLap(Formater.date2str(new Date()));
		ycgtForm.setDiaDiem(appContext.getDiaBan());
		saveToken(request);
		return returnDefaultYktv(map, form, request, response);
	}

	public ActionForward returnDefaultYktv(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loaiYktv = request.getParameter("action");
		System.out.println(loaiYktv);
		if ("yktvTC".equals(loaiYktv))
			return map.findForward("yktvTC");
		else
			return map.findForward("yktv");
	}

	// Save Y kien tu van 15A
	public ActionForward saveYktv(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// if (isTokenValid(request, true)) {
		try {
			PhieuYeuCauForm tdForm = (PhieuYeuCauForm) form;
			KntcQdxmPhieuYc qd = tdForm.toEntity(KntcQdxmPhieuYc.PHIEU_LAY_Y_KIEN_TU_VAN);
			// Luu xuong DB
			XacMinhService services = new XacMinhService();
			services.savePhieuYeuCau(appContext, qd);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		// }
		return returnDefaultYktv(map, form, request, response);
	}

	// Xem Y kien tu van 15A
	public ActionForward xemYktv(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhService s = new XacMinhService();
		try {
			// KntcQdinhXm qdXm = s.getKntcQdinhXm(appContext,
			// request.getParameter("id").toString());
			KntcQdxmPhieuYc pyc = s.getPhieuYeuCauById(appContext, request.getParameter("pId").toString());
			// System.out.println(request.getParameter("pId").toString());
			PhieuYeuCauForm ycgtForm = (PhieuYeuCauForm) form;
			ycgtForm.fromPyc(pyc);
			ycgtForm.setNgayLap(Formater.dateTimeToDate(ycgtForm.getNgayLap()));
			ycgtForm.setThoiDiemYcgt(Formater.dateTimeToDate(ycgtForm.getThoiDiemYcgt()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return returnDefaultYktv(map, form, request, response);
	}

	// Xoa Y kien tu van 15A
	public ActionForward xoaYktv(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhService s = new XacMinhService();
		try {
			s.delPycByMaPhieu(appContext, request.getParameter("pId").toString());
			request.setAttribute("xoaThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("xoaThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		return returnDefaultYktv(map, form, request, response);
	}

	// Tao moi Y kien tu van 15A
	public ActionForward taoMoiYktv(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("id");
		XacMinhService s = new XacMinhService();
		PhieuYeuCauForm ycgtForm = (PhieuYeuCauForm) form;
		/*
		 * KntcQdinhXm qdXm = s.getKntcQdinhXmByHoSo(appContext, maHs); String
		 * maQd = qdXm.getMaQd(); if (!Formater.isNull(maQd)) {
		 * ycgtForm.setKntcQdinhXm(maQd); ycgtForm.setMaHoSo(qdXm.getMaHs()); }
		 */
		ycgtForm.setMaHoSo(maHs);
		ycgtForm.setDiaDiem(appContext.getDiaBan());
		ycgtForm.setMaPhieu(KtnbUtil.getMaNvu(appContext, "YKTV"));
		ycgtForm.setThoiDiemYcgt(Formater.date2str(new Date()));
		ycgtForm.setNgayLap(Formater.date2str(new Date()));

		ycgtForm.setDonViYkien("");
		ycgtForm.setYeuCauYcgt("");
		ycgtForm.setMa(null);

		return returnDefaultYktv(map, form, request, response);
	}

	public ActionForward returndDefaultTcgd(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loaiTcgd = request.getParameter("action");
		if ("ycgdTC".equals(loaiTcgd))
			return map.findForward("tcgdTC");
		else
			return map.findForward("tcgd");
	}

	// Show trung cau giam dinh 15B
	public ActionForward tcgd(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuYeuCauForm cnForm = (PhieuYeuCauForm) form;
		String maHs = request.getParameter("id");
		XacMinhService s = new XacMinhService();

		String readOnly = request.getParameter("r");
		if (readOnly != null)
			if (readOnly.equals("rol")) {
				if (s.getPhieuYeuCau(appContext, maHs, KntcQdxmPhieuYc.PHIEU_TRUNG_CAU_GIAM_DINH) == null) {
					throw new KtnbException("Bi&#7875;u m&#7851;u n&#224;y kh&#244;ng c&#243; s&#7889; li&#7879;u!!!", "", "");
				}
			}

		KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, maHs);
		if (qd == null || qd.getNgayDuyet() == null) {
			throw new KtnbException("Ch&#x1B0;a c&#xF3; Quy&#x1EBF;t &#x111;&#x1ECB;nh x&#xE1;c minh, ho&#x1EB7;c Q&#x110;XM ch&#x1B0;a &#x111;&#x1B0;&#x1EE3;c duy&#x1EC7;t!", "",
					"C&#7847;n ho&#224;n thi&#7879;n Quy&#7871;t &#273;&#7883;nh x&#225;c minh tr&#432;&#7899;c khi l&#224;m c&#225;c bi&#7875;u m&#7851;u ti&#7871;p theo!");
		}
		String maQd = qd.getMaQd();
		if (!Formater.isNull(maQd)) {
			cnForm.setKntcQdinhXm(maQd);
			cnForm.setMaHoSo(maHs);
			cnForm.setDiaDiemYcgt(appContext.getTenCqt());
		}
		cnForm.setMaPhieu(KtnbUtil.getMaNvu(appContext, "TCG\u0110"));
		cnForm.setThoiDiemYcgt(Formater.date2strDateTimeForNV(new Date()));
		cnForm.setNgayLap(Formater.date2str(new Date()));
		cnForm.setDiaDiem(appContext.getDiaBan());
		saveToken(request);
		return returndDefaultTcgd(map, form, request, response);
	}

	// Xem trung cau giam dinh 15B
	public ActionForward xemPgd(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhService s = new XacMinhService();
		try {
			// KntcQdinhXm qdXm = s.getKntcQdinhXm(appContext,
			// request.getParameter("id").toString());
			KntcQdxmPhieuYc pyc = s.getPhieuYeuCauById(appContext, request.getParameter("pId").toString());
			// System.out.println(request.getParameter("pId").toString());
			PhieuYeuCauForm ycgtForm = (PhieuYeuCauForm) form;
			ycgtForm.fromPyc(pyc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return returndDefaultTcgd(map, form, request, response);
	}

	// Tao trung cau giam dinh 15B
	public ActionForward taoMoiPgd(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("id");
		XacMinhService s = new XacMinhService();
		KntcQdinhXm qdXm = s.getKntcQdinhXmByHoSo(appContext, maHs);
		String maQd = qdXm.getMaQd();
		PhieuYeuCauForm ycgtForm = (PhieuYeuCauForm) form;
		if (!Formater.isNull(maQd)) {
			ycgtForm.setKntcQdinhXm(maQd);
			ycgtForm.setMaHoSo(qdXm.getMaHs());
		}
		ycgtForm.setDiaDiem(appContext.getDiaBan());
		ycgtForm.setMaPhieu(KtnbUtil.getMaNvu(appContext, "TCGD"));
		ycgtForm.setDiaDiemYcgt(appContext.getDiaBan());
		ycgtForm.setYeuCauYcgt("");
		ycgtForm.setThoiDiemYcgt("");
		ycgtForm.setDonViYcgt("");
		ycgtForm.setThoiGianNhanPhieu("");
		ycgtForm.setMa(null);

		return returndDefaultTcgd(map, form, request, response);
	}

	// Save trung cau giam dinh 15B
	public ActionForward saveTcgd(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// if (isTokenValid(request, true)) {
		try {
			PhieuYeuCauForm tdForm = (PhieuYeuCauForm) form;
			KntcQdxmPhieuYc qd = tdForm.toEntity();
			qd.setLoaiPhieu(KntcQdxmPhieuYc.PHIEU_TRUNG_CAU_GIAM_DINH);
			// Luu xuong DB
			XacMinhService services = new XacMinhService();
			services.savePhieuYeuCau(appContext, qd);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		// }
		return returndDefaultTcgd(map, form, request, response);
	}

	// Xoa Y kien tu van 15A
	public ActionForward xoaPgd(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhService s = new XacMinhService();
		try {
			s.delPycByMaPhieu(appContext, request.getParameter("pId").toString());
			request.setAttribute("xoaThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("xoaThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		return returndDefaultTcgd(map, form, request, response);
	}

	// Get list phieu yeu cau
	public ActionForward getListPhieu(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String maHs = request.getParameter("maHs");
		String loaiPhieu = request.getParameter("t");
		if (Formater.isNull(maHs) || Formater.isNull(loaiPhieu))
			return null;
		else {
			JSONObject jsonResult = null;
			KntcDAO kntcDAO = KntcUtil.getKntcDAO();
			try {
				jsonResult = kntcDAO.getListQdxmPhieuYc(maHs, loaiPhieu);
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

	// In Phieu yeu cau
	public ActionForward in_old(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		PhieuYeuCauForm cnForm = (PhieuYeuCauForm) form;
		String maHs = cnForm.getMaHoSo();
		String type = request.getParameter("type");
		SoTiepDanService stdS = new SoTiepDanService();
		XacMinhService s = new XacMinhService();
		KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, maHs);
		String maQd = qd.getMaQd();
		/*
		 * XacMinhService s = new XacMinhService(); KntcQdinhXm qdXm =
		 * s.getKntcQdinhXmByHoSo(appContext, maHs); String maQd =
		 * qdXm.getMaQd();
		 */
		String ngayLap = "";
		if (Formater.isNull(cnForm.getNgayLap())) {
			ngayLap = "ng\u00E0y   th\u00E1ng   n\u0103m        ";
			parameters.put("ngay_lap_phieu", cnForm.getDiaDiem() + ", " + ngayLap);
		} else
			parameters.put("ngay_lap_phieu", cnForm.getDiaDiem() + ", " + Formater.getDateForPrint(cnForm.getNgayLap()));
		String su = "";
		if (type.equals("13/KTNB")) {
			if (!Formater.isNull(maQd)) {
				su = "kntc13";
				parameters.put("co_quan_ra_QD_xac_minh", appContext.getTenCqt());
				parameters.put("doan_to_xac_minh_qd_so", cnForm.getKntcQdinhXm());
				parameters.put("lan_thu", cnForm.getLanYc());
				parameters.put("nguoi_co_quan_don_vi_duoc_yeu_cau_cung_cap", cnForm.getDonViYcgt());
				parameters.put("ngay_ra_quyet_dinh", Formater.getDateForPrint(Formater.date2str(qd.getNgayLap())));
				parameters.put("chuc_danh_thu_truong_co_quan_thue", KtnbUtil.getTenThuTruongCqt(appContext));
				if (qd != null)
					parameters.put("xac_minh_ve_viec", qd.getNoiDungXm());
				else
					parameters.put("xac_minh_ve_viec", " ");
				parameters.put("bao_cao_can_cung_cap", cnForm.getYcBaoCao());
				parameters.put("ho_so_tai_lieu_can_cung_cap", cnForm.getYcHoSo());
				parameters.put("thoi_gian_cung_cap_tai_lieu", Formater.getDateTimeForPrint(cnForm.getThoiDiemYcgt()));
				parameters.put("dia_diem_cung_cap", cnForm.getDiaDiemYcgt());
				parameters.put("nguoi_nhan_phieu_yeu_cau", cnForm.getNguoiNhanPhieu());
				parameters.put("chuc_vu_nguoi_nhan", cnForm.getNguoiNhanPhieuChucVu());
				parameters.put("nguoi_nhan_hstl", cnForm.getNguoiNhanBc());
				parameters.put("nguoi_nhan_hstl_ten", cnForm.getNguoiNhanBc().split(",")[0]);
				parameters.put("thoi_gian_giao_phieu", Formater.getDateTimeForPrint(cnForm.getThoiGianNhanPhieu()));
			}
		} else if (type.equals("14/KTNB")) {
			if (!Formater.isNull(maQd)) {
				su = "kntc14";
				parameters.put("co_quan_ra_QD_xac_minh", appContext.getTenCqt());
				parameters.put("doan_to_xac_minh_qd_so", cnForm.getKntcQdinhXm());
				parameters.put("ngay_lap_phieu", cnForm.getDiaDiem() + ", " + Formater.getDateForPrint(cnForm.getNgayLap()));
				parameters.put("nguoi_co_quan_don_vi_duoc_yeu_cau_giai_trinh", cnForm.getDonViYcgt());
				parameters.put("so_quyet_dinh_xac_minh", maQd);
				parameters.put("thoi_gian_lap_phieu", Formater.getDateTimeForPrint(cnForm.getNgayLap()));
				if (qd != null) {
					parameters.put("noi_dung_xac_minh", stdS.getNoiDungDonForXm(appContext, qd.getMaHs()));
					parameters.put("ngay_ra_quyet_dinh", Formater.getDateForPrint(Formater.date2str(qd.getNgayLap())));
				} else {
					parameters.put("noi_dung_xac_minh", "Chua co QDXM!");
					parameters.put("ngay_ra_quyet_dinh", "  ");
				}
				parameters.put("chuc_danh_thu_truong_co_quan", KtnbUtil.getTenThuTruongCqt(appContext));
				parameters.put("yeu_cau_giai_trinh", cnForm.getYeuCauYcgt());
				parameters.put("thoi_gian_cung_cap_giai_trinh", Formater.getDateTimeForPrint(cnForm.getThoiDiemYcgt()));
				parameters.put("dia_diem_cung_cap_giai_trinh", cnForm.getDiaDiemYcgt());
				// parameters.put("chuc_vu", cnForm.getNguoiNhanBcChucVu());
			}
		} else if (type.equals("15/KTNB")) {
			if (!Formater.isNull(maQd)) {
				su = "kntc15";
				parameters.put("co_quan_cap_tren_truc_tiep", KtnbUtil.getTenCqtCapTrenTt4P(appContext));
				parameters.put("co_quan_thue_don_vi_lay_y_kien", appContext.getTenCqt());
				// parameters.put("ngay_lap_phieu", cnForm.getDiaDiem()+", "
				// +Formater.getDateForPrint(cnForm.getNgayLap()));
				parameters.put("so", cnForm.getMaPhieu());
				parameters.put("co_quan_don_vi_tham_gia_y_kien", cnForm.getDonViYkien());
				parameters.put("noi_dung", cnForm.getYeuCauYcgt());
				parameters.put("thoi_han_xin_y_kien", Formater.getDateForPrint(cnForm.getThoiDiemYcgt()));
			}
		} else if (type.equals("15B/KTNB")) {
			if (!Formater.isNull(maQd)) {
				su = "kntc15b";
				parameters.put("co_quan_cap_tren_truc_tiep", KtnbUtil.getTenCqtCapTrenTt4P(appContext));
				parameters.put("co_quan_thue_ra_van_ban", appContext.getTenCqt());
				parameters.put("co_quan_thue_de_nghi_giam_dinh", appContext.getTenCqt());
				// parameters.put("ngay_lap_phieu", cnForm.getDiaDiem()+", "
				// +Formater.getDateForPrint(cnForm.getNgayLap()));
				parameters.put("so_phieu", cnForm.getMaPhieu());
				parameters.put("chuc_danh_thu_truong_co_quan_thue", KtnbUtil.getTenThuTruongCqt(appContext));
				parameters.put("noi_dung_quyet_dinh_xac_minh", cnForm.getYeuCauYcgt());
				parameters.put("quyet_dinh_xac_minh_so", cnForm.getKntcQdinhXm());
				parameters.put("ngay_ra_quyet_dinh", Formater.getDateForPrint(Formater.date2str(qd.getNgayLap())));
				parameters.put("ten_co_quan_giam_dinh", cnForm.getDonViYcgt());
				parameters.put("thoi_gian_ban_giao_ho_so", Formater.getDateTimeForPrint(cnForm.getThoiDiemYcgt()));
				parameters.put("thoi_diem_cung_cap_ket_qua", Formater.getDateTimeForPrint(cnForm.getThoiGianNhanPhieu()));
				parameters.put("dia_diem", cnForm.getDiaDiemYcgt());
				// parameters.put("ten_thu_truong",
				// appContext.getTenThuTruong());
			}
		}
		parameters.put("tt_cqt", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()));
		InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + su + ".jasper");
		KtnbUtil.printf(reportRows, su, response, inputStream, parameters, null);
		return null;
	}

	public ActionForward in(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;

		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		PhieuYeuCauForm cnForm = (PhieuYeuCauForm) form;
		String maHs = cnForm.getMaHoSo();
		String type = request.getParameter("type");
		SoTiepDanService stdS = new SoTiepDanService();
		XacMinhService s = new XacMinhService();
		KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, maHs);
		String maQd = qd.getMaQd();
		/*
		 * XacMinhService s = new XacMinhService(); KntcQdinhXm qdXm =
		 * s.getKntcQdinhXmByHoSo(appContext, maHs); String maQd =
		 * qdXm.getMaQd();
		 */
		String ngayLap = "";
		if (Formater.isNull(cnForm.getNgayLap())) {
			ngayLap = "ng\u00E0y.....th\u00E1ng.....n\u0103m.......";
		} else
			ngayLap = Formater.getDateForPrint(cnForm.getNgayLap());

		String su = "";
		if (type.equals("13/KTNB")) {
			if (!Formater.isNull(maQd)) {
				su = "kntc13";
				fileIn = request.getRealPath("/docin") + "\\KNTC13.doc";
				fileOut = request.getRealPath("/docout") + "\\KNTC13_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

				word = new MsWordUtils(fileIn, fileOut);
				try {
					word.put("[co_quan_ra_QD_xac_minh]", appContext.getTenCqt().toUpperCase());
					word.put("[doan_to_xac_minh_qd_so]", cnForm.getKntcQdinhXm().toUpperCase());
					if (Formater.isNull(cnForm.getDiaDiem())) {
						word.put("[ngay_lap_phieu]", "........, " + Formater.getDateForPrint(cnForm.getNgayLap()));
					} else
						word.put("[ngay_lap_phieu]", cnForm.getDiaDiem() + ", " + Formater.getDateForPrint(cnForm.getNgayLap()));
					if (Formater.isNull(cnForm.getLanYc()))
						word.put("[lan_thu]", ".......");
					else
						word.put("[lan_thu]", cnForm.getLanYc());
					if (Formater.isNull(cnForm.getDonViYcgt()))
						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_cung_cap]", ".......");
					else
						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_cung_cap]", cnForm.getDonViYcgt());
					word.put("[doan_to_xac_minh_qd_so]", cnForm.getKntcQdinhXm());
					word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(Formater.date2str(qd.getNgayLap())));
					word.put("[chuc_danh_thu_truong_co_quan_thue]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
					if (qd != null)
						word.put("[xac_minh_ve_viec]", qd.getNoiDungXm());
					else
						word.put("[xac_minh_ve_viec]", " ");
					if (Formater.isNull(cnForm.getDonViYcgt()))
						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_cung_cap]", KtnbUtil.inFieldNull(100));
					else
						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_cung_cap]", cnForm.getDonViYcgt());
					word.put("[bao_cao_can_cung_cap]", cnForm.getYcBaoCao());
					word.put("[ho_so_tai_lieu_can_cung_cap]", cnForm.getYcHoSo());
					word.put("[thoi_gian_cung_cap_tai_lieu]", Formater.getDateTimeForPrint(cnForm.getThoiDiemYcgt()));
					if (Formater.isNull(cnForm.getDiaDiemYcgt()))
						word.put("[dia_diem_cung_cap]", KtnbUtil.inFieldNull(90));
					else
						word.put("[dia_diem_cung_cap]", cnForm.getDiaDiemYcgt());
					word.put("[nguoi_nhan_hstl]", cnForm.getNguoiNhanBc());
					if (Formater.isNull(cnForm.getNguoiNhanPhieu()))
						word.put("[nguoi_nhan_phieu_yeu_cau]", "......");
					else
						word.put("[nguoi_nhan_phieu_yeu_cau]", cnForm.getNguoiNhanPhieu());
					if (Formater.isNull(cnForm.getNguoiNhanPhieuChucVu()))
						word.put("[chuc_vu_nguoi_nhan]", "......");
					else
						word.put("[chuc_vu_nguoi_nhan]", cnForm.getNguoiNhanPhieuChucVu());
					word.put("[thoi_gian_giao_phieu]", Formater.getDateTimeForPrint(cnForm.getThoiGianNhanPhieu()));
					word.put("[nguoi_nhan_phieu_yeu_cau]", cnForm.getNguoiNhanPhieu());
					word.put("[nguoi_nhan_hstl_ten]", cnForm.getNguoiNhanBc().split(",")[0]);
					word.saveAndClose();
					word.downloadFile(fileOut, "Mau KNTC13", ".doc", response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					System.out.println("Download Error: " + ex.getMessage());
				} finally {
					try {
						word.saveAndClose();
					} catch (Exception ex) {
					}
				}
			}
		} 
		if (type.equals("TC10")) {
			if (!Formater.isNull(maQd)) {
				su = "tc10";
				fileIn = request.getRealPath("/docin") + "\\TC10.doc";
				fileOut = request.getRealPath("/docout") + "\\TC10_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

				word = new MsWordUtils(fileIn, fileOut);
				try {
					word.put("[co_quan_ra_QD_xac_minh]", appContext.getTenCqt().toUpperCase());
					word.put("[doan_to_xac_minh_qd_so]", cnForm.getKntcQdinhXm().toUpperCase());
					if (Formater.isNull(cnForm.getDiaDiem())) {
						word.put("[ngay_lap_phieu]", "........, " + Formater.getDateForPrint(cnForm.getNgayLap()));
					} else
						word.put("[ngay_lap_phieu]", cnForm.getDiaDiem() + ", " + Formater.getDateForPrint(cnForm.getNgayLap()));
					if (Formater.isNull(cnForm.getLanYc()))
						word.put("[lan_thu]", ".......");
					else
						word.put("[lan_thu]", cnForm.getLanYc());
//					if (Formater.isNull(cnForm.getDonViYcgt()))
//						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_cung_cap]", ".......");
//					else
//						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_cung_cap]", cnForm.getDonViYcgt());
					word.put("[doan_to_xac_minh_qd_so]", cnForm.getKntcQdinhXm());
					word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(Formater.date2str(qd.getNgayLap())));
					word.put("[chuc_danh_thu_truong_co_quan_thue]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
					if (qd != null)
						word.put("[xac_minh_ve_viec]", qd.getNoiDungXm());
					else
						word.put("[xac_minh_ve_viec]", " ");
					if (Formater.isNull(cnForm.getDonViYcgt()))
						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_cung_cap]", KtnbUtil.inFieldNull(100));
					else
						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_cung_cap]", cnForm.getDonViYcgt());
					word.put("[bao_cao_can_cung_cap]", cnForm.getYcBaoCao());
					word.put("[ho_so_tai_lieu_can_cung_cap]", cnForm.getYcHoSo());
					word.put("[thoi_gian_cung_cap_tai_lieu]", Formater.getDateTimeForPrint(cnForm.getThoiDiemYcgt()));
					if (Formater.isNull(cnForm.getDiaDiemYcgt()))
						word.put("[dia_diem_cung_cap]", KtnbUtil.inFieldNull(90));
					else
						word.put("[dia_diem_cung_cap]", cnForm.getDiaDiemYcgt());
					word.put("[nguoi_nhan_hstl]", cnForm.getNguoiNhanBc());
					if (Formater.isNull(cnForm.getNguoiNhanPhieu()))
						word.put("[nguoi_nhan_phieu_yeu_cau]", "......");
					else
						word.put("[nguoi_nhan_phieu_yeu_cau]", cnForm.getNguoiNhanPhieu());
					if (Formater.isNull(cnForm.getNguoiNhanPhieuChucVu()))
						word.put("[chuc_vu_nguoi_nhan]", "......");
					else
						word.put("[chuc_vu_nguoi_nhan]", cnForm.getNguoiNhanPhieuChucVu());
					word.put("[thoi_gian_giao_phieu]", Formater.getDateTimeForPrint(cnForm.getThoiGianNhanPhieu()));
					word.put("[nguoi_nhan_phieu_yeu_cau]", cnForm.getNguoiNhanPhieu());
					word.put("[nguoi_nhan_hstl_ten]", cnForm.getNguoiNhanBc().split(",")[0]);
					word.saveAndClose();
					word.downloadFile(fileOut, "Mau TC10", ".doc", response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					System.out.println("Download Error: " + ex.getMessage());
				} finally {
					try {
						word.saveAndClose();
					} catch (Exception ex) {
					}
				}
			}
		}else if (type.equals("KN11A")) {
			if (!Formater.isNull(maQd)) {
				su = "kntc14";
				fileIn = request.getRealPath("/docin") + "\\KN11A.doc";
				fileOut = request.getRealPath("/docout") + "\\KN11A_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

				try {
					word = new MsWordUtils(fileIn, fileOut);
					word.put("[co_quan_ra_QD_xac_minh]", appContext.getTenCqt().toUpperCase());
					word.put("[doan_to_xac_minh_qd_so]", cnForm.getKntcQdinhXm().toUpperCase());
					// word.put("[ngay_lap_phieu]", cnForm.getDiaDiem() + ", " +
					// Formater.getDateForPrint(cnForm.getNgayLap()));
					if (Formater.isNull(cnForm.getDiaDiem())) {
						word.put("[ngay_lap_phieu]", "........, " + Formater.getDateForPrintFromDateTime(cnForm.getNgayLap()));
					} else
						word.put("[ngay_lap_phieu]", cnForm.getDiaDiem() + ", " + Formater.getDateForPrintFromDateTime(cnForm.getNgayLap()));
					if (Formater.isNull(cnForm.getDonViYcgt()))
						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_giai_trinh]", ".........");
					else
						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_giai_trinh]", cnForm.getDonViYcgt());
					word.put("[so_quyet_dinh_xac_minh]", maQd);
					if (qd != null) {
						word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(Formater.date2str(qd.getNgayLap())));
						word.put("[chuc_danh_thu_truong_co_quan]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
						word.put("[noi_dung_xac_minh]", stdS.getNoiDungDonForXm(appContext, qd.getMaHs()));
					} else {
						word.put("[ngay_ra_quyet_dinh]", "  ");
						word.put("[chuc_danh_thu_truong_co_quan]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
						word.put("[noi_dung_xac_minh]", "Chua co QDXM!");
					}
					if (Formater.isNull(cnForm.getDonViYcgt()))
						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_giai_trinh]", ".........");
					else
						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_giai_trinh]", cnForm.getDonViYcgt());
					word.put("[yeu_cau_giai_trinh]", cnForm.getYeuCauYcgt());
					word.put("[thoi_gian_cung_cap_giai_trinh]", Formater.getDateTimeForPrint(cnForm.getThoiDiemYcgt()));
					if (Formater.isNull(cnForm.getDiaDiemYcgt()))
						word.put("[dia_diem_cung_cap_giai_trinh]", ".......");
					else
						word.put("[dia_diem_cung_cap_giai_trinh]", cnForm.getDiaDiemYcgt());
					if (Formater.isNull(cnForm.getDonViYcgt()))
						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_giai_trinh]", ".........");
					else
						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_giai_trinh]", cnForm.getDonViYcgt());
					word.put("[thoi_gian_lap_phieu]", Formater.getDateTimeForPrint(cnForm.getNgayLap()));
					word.put("[nguoi_nhan]", cnForm.getNguoiNhanBc());
					word.put("[truong_doan]", s.getTenTruongDoanXmByHs(appContext, cnForm.getMaHoSo()));
					// parameters.put("chuc_vu", cnForm.getNguoiNhanBcChucVu());
					word.saveAndClose();
					word.downloadFile(fileOut, "Mau KN11A", ".doc", response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					System.out.println("Download Error: " + ex.getMessage());
				}
			}
		} else if (type.equals("TC12")) {
			System.out.println("Chay vao mau giai trinh TC12");
			if (!Formater.isNull(maQd)) {
				su = "kntc14";
				fileIn = request.getRealPath("/docin") + "\\TC12.doc";
				fileOut = request.getRealPath("/docout") + "\\TC12_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

				try {
					word = new MsWordUtils(fileIn, fileOut);
					word.put("[co_quan_ra_QD_xac_minh]", appContext.getTenCqt().toUpperCase());
					word.put("[doan_to_xac_minh_qd_so]", cnForm.getKntcQdinhXm().toUpperCase());
					// word.put("[ngay_lap_phieu]", cnForm.getDiaDiem() + ", " +
					// Formater.getDateForPrint(cnForm.getNgayLap()));
					if (Formater.isNull(cnForm.getDiaDiem())) {
						word.put("[ngay_lap_phieu]", "........, " + Formater.getDateForPrintFromDateTime(cnForm.getNgayLap()));
					} else
						word.put("[ngay_lap_phieu]", cnForm.getDiaDiem() + ", " + Formater.getDateForPrintFromDateTime(cnForm.getNgayLap()));
					word.put("[so_quyet_dinh_xac_minh]", maQd);
					if (qd != null) {
						word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(Formater.date2str(qd.getNgayLap())));
						word.put("[chuc_danh_thu_truong_co_quan]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
						word.put("[noi_dung_xac_minh]", stdS.getNoiDungDonForXm(appContext, qd.getMaHs()));
					} else {
						word.put("[ngay_ra_quyet_dinh]", "  ");
						word.put("[chuc_danh_thu_truong_co_quan]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
						word.put("[noi_dung_xac_minh]", "Chua co QDXM!");
					}
					if (Formater.isNull(cnForm.getDonViYcgt()))
						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_giai_trinh]", ".........");
					else
						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_giai_trinh]", cnForm.getDonViYcgt());
					word.put("[yeu_cau_giai_trinh]", cnForm.getYeuCauYcgt());
					word.put("[thoi_gian_cung_cap_giai_trinh]", Formater.getDateTimeForPrint(cnForm.getThoiDiemYcgt()));
					if (Formater.isNull(cnForm.getDiaDiemYcgt()))
						word.put("[dia_diem_cung_cap_giai_trinh]", ".......");
					else
						word.put("[dia_diem_cung_cap_giai_trinh]", cnForm.getDiaDiemYcgt());
					if (Formater.isNull(cnForm.getDonViYcgt()))
						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_giai_trinh]", ".........");
					else
						word.put("[nguoi_co_quan_don_vi_duoc_yeu_cau_giai_trinh]", cnForm.getDonViYcgt());
					word.put("[thoi_gian_lap_phieu]", Formater.getDateTimeForPrint(cnForm.getNgayLap()));
					word.put("[nguoi_nhan]", cnForm.getNguoiNhanBc());
					word.put("[truong_doan]", s.getTenTruongDoanXmByHs(appContext, cnForm.getMaHoSo()));
					// parameters.put("chuc_vu", cnForm.getNguoiNhanBcChucVu());
					word.saveAndClose();
					word.downloadFile(fileOut, "Mau TC12", ".doc", response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					System.out.println("Download Error: " + ex.getMessage());
				}
			}
		} else if (type.equals("15/KTNB")) {
			if (!Formater.isNull(maQd)) {
				su = "kntc15";
				fileIn = request.getRealPath("/docin") + "\\KN12A.doc";
				fileOut = request.getRealPath("/docout") + "\\KN12A_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

				try {
					word = new MsWordUtils(fileIn, fileOut);
					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_don_vi_lay_y_kien]", appContext.getTenCqt().toUpperCase());
					// parameters.put("ngay_lap_phieu", cnForm.getDiaDiem()+", "
					// +Formater.getDateForPrint(cnForm.getNgayLap()));
					String cq_donvi_thamgia = null;
					if (Formater.isNull(cnForm.getDonViYkien()))
						cq_donvi_thamgia = ".......";
					else
						cq_donvi_thamgia = cnForm.getDonViYkien();
					word.put("[so]", cnForm.getMaPhieu());
					if (Formater.isNull(cnForm.getDiaDiem())) {
						word.put("[ngay_lap_phieu]", "........, " + ngayLap);
					} else
						word.put("[ngay_lap_phieu]", cnForm.getDiaDiem() + ", " + Formater.getDateForPrint(cnForm.getNgayLap()));
					// word.put("[co_quan_don_vi_tham_gia_y_kien]",
					// cnForm.getDonViYkien());
					//word.put("[co_quan_don_vi_tham_gia_y_kien]", cq_donvi_thamgia);
					if (Formater.isNull(cnForm.getYeuCauYcgt())) {
						String defaultNull = KtnbUtil.inFieldNull(115);
						word.put("[noi_dung]", defaultNull + "\n" + defaultNull + "\n" + defaultNull + "\n" + defaultNull);
					} else
						word.put("[noi_dung]", cnForm.getYeuCauYcgt());
					word.put("[co_quan_don_vi_tham_gia_y_kien]", cq_donvi_thamgia);
					word.put("[thoi_han_xin_y_kien]", Formater.getDateForPrint(cnForm.getThoiDiemYcgt()));
					word.put("[co_quan_don_vi_tham_gia_y_kien]", cq_donvi_thamgia);
					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]",
					// appContext.getTenThuTruong());
					word.saveAndClose();
					word.downloadFile(fileOut, "Mau 12/KN", ".doc", response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					System.out.println("Download Error: " + ex.getMessage());
				}
			}
		} else if (type.equals("14TC")) {
			if (!Formater.isNull(maQd)) {
				su = "kntc15";
				fileIn = request.getRealPath("/docin") + "\\TC14.doc";
				fileOut = request.getRealPath("/docout") + "\\TC14_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

				try {
					word = new MsWordUtils(fileIn, fileOut);
					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_don_vi_lay_y_kien]", appContext.getTenCqt().toUpperCase());
					// parameters.put("ngay_lap_phieu", cnForm.getDiaDiem()+", "
					// +Formater.getDateForPrint(cnForm.getNgayLap()));
					String cq_donvi_thamgia = null;
					if (Formater.isNull(cnForm.getDonViYkien()))
						cq_donvi_thamgia = ".......";
					else
						cq_donvi_thamgia = cnForm.getDonViYkien();
					word.put("[so]", cnForm.getMaPhieu());
					if (Formater.isNull(cnForm.getDiaDiem())) {
						word.put("[ngay_lap_phieu]", "........, " + ngayLap);
					} else
						word.put("[ngay_lap_phieu]", cnForm.getDiaDiem() + ", " + Formater.getDateForPrint(cnForm.getNgayLap()));
					// word.put("[co_quan_don_vi_tham_gia_y_kien]",
					// cnForm.getDonViYkien());
					word.put("[co_quan_don_vi_tham_gia_y_kien]", cq_donvi_thamgia);
					if (Formater.isNull(cnForm.getYeuCauYcgt())) {
						String defaultNull = KtnbUtil.inFieldNull(115);
						word.put("[noi_dung]", defaultNull + "\n" + defaultNull + "\n" + defaultNull + "\n" + defaultNull);
					} else
						word.put("[noi_dung]", cnForm.getYeuCauYcgt());
					word.put("[co_quan_don_vi_tham_gia_y_kien]", cq_donvi_thamgia);
					word.put("[thoi_han_xin_y_kien]", Formater.getDateForPrint(cnForm.getThoiDiemYcgt()));
					word.put("[co_quan_don_vi_tham_gia_y_kien]", cq_donvi_thamgia);
					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]",
					// appContext.getTenThuTruong());
					word.saveAndClose();
					word.downloadFile(fileOut, "Mau 14/TC", ".doc", response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					System.out.println("Download Error: " + ex.getMessage());
				}
			}
		} else if (type.equals("13/KN")) {
			if (!Formater.isNull(maQd)) {
				su = "kntc15b";
				fileIn = request.getRealPath("/docin") + "\\KN13.doc";
				fileOut = request.getRealPath("/docout") + "\\KN13_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

				try {
					word = new MsWordUtils(fileIn, fileOut);
					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
					word.put("[so_phieu]", cnForm.getMaPhieu());
					// word.put("ngay_lap_phieu", cnForm.getDiaDiem()+",
					// "+Formater.getDateForPrint(cnForm.getNgayLap()));
					if (Formater.isNull(cnForm.getDiaDiem())) {
						word.put("[ngay_lap_phieu]", "........, " + ngayLap);
					} else
						word.put("[ngay_lap_phieu]", cnForm.getDiaDiem() + ", " + Formater.getDateForPrint(cnForm.getNgayLap()));
					if (Formater.isNull(cnForm.getDonViYcgt()))
						word.put("[ten_co_quan_giam_dinh]", "..........");
					else
						word.put("[ten_co_quan_giam_dinh]", cnForm.getDonViYcgt());
					word.put("[quyet_dinh_xac_minh_so]", cnForm.getKntcQdinhXm());
					word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(Formater.date2str(qd.getNgayLap())));
					word.put("[chuc_danh_thu_truong_co_quan_thue]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
					if (Formater.isNull(cnForm.getYeuCauYcgt()))
						word.put("[noi_dung_quyet_dinh_xac_minh]", ".......");
					else
						word.put("[noi_dung_quyet_dinh_xac_minh]", cnForm.getYeuCauYcgt());
					word.put("[co_quan_thue_de_nghi_giam_dinh]", appContext.getTenCqt());
					word.put("[ten_co_quan_giam_dinh]", cnForm.getDonViYcgt());
					word.put("[noi_dung_quyet_dinh_xac_minh]", cnForm.getYeuCauYcgt());
					word.put("[co_quan_thue_de_nghi_giam_dinh]", appContext.getTenCqt());
					word.put("[ten_co_quan_giam_dinh]", cnForm.getDonViYcgt());
					if (Formater.isNull(cnForm.getThoiDiemYcgt()))
						word.put("[thoi_gian_ban_giao_ho_so]", "....gi\u1EDD......ng\u00E0y....th\u00E1ng....n\u0103m...........");
					else
						word.put("[thoi_gian_ban_giao_ho_so]", Formater.getDateTimeForPrint(cnForm.getThoiDiemYcgt()));
					if (Formater.isNull(cnForm.getDiaDiemYcgt()))
						word.put("[dia_diem]", "...........");
					else
						word.put("[dia_diem]", cnForm.getDiaDiemYcgt());
					word.put("[co_quan_thue_de_nghi_giam_dinh]", appContext.getTenCqt());
					word.put("[ten_co_quan_giam_dinh]", cnForm.getDonViYcgt());
					word.put("[co_quan_thue_de_nghi_giam_dinh]", appContext.getTenCqt());
					if (Formater.isNull(cnForm.getThoiGianNhanPhieu()))
						word.put("[thoi_diem_cung_cap_ket_qua]", "ng\u00E0y...th\u00E1ng....n\u0103m.........");
					else
						word.put("[thoi_diem_cung_cap_ket_qua]", Formater.getDateTimeForPrint(cnForm.getThoiGianNhanPhieu()));
					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]",
					// appContext.getTenThuTruong());
					word.saveAndClose();
					word.downloadFile(fileOut, "Mau KN13", ".doc", response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					System.out.println("Download Error: " + ex.getMessage());
				}
			}
		}
		else if (type.equals("15TC")) {
			if (!Formater.isNull(maQd)) {
				su = "kntc15b";
				fileIn = request.getRealPath("/docin") + "\\TC15.doc";
				fileOut = request.getRealPath("/docout") + "\\TC15_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

				try {
					word = new MsWordUtils(fileIn, fileOut);
					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
					word.put("[so_phieu]", cnForm.getMaPhieu());
					// word.put("ngay_lap_phieu", cnForm.getDiaDiem()+",
					// "+Formater.getDateForPrint(cnForm.getNgayLap()));
					if (Formater.isNull(cnForm.getDiaDiem())) {
						word.put("[ngay_lap_phieu]", "........, " + ngayLap);
					} else
						word.put("[ngay_lap_phieu]", cnForm.getDiaDiem() + ", " + Formater.getDateForPrint(cnForm.getNgayLap()));
					if (Formater.isNull(cnForm.getDonViYcgt()))
						word.put("[ten_co_quan_giam_dinh]", "..........");
					else
						word.put("[ten_co_quan_giam_dinh]", cnForm.getDonViYcgt());
					word.put("[quyet_dinh_xac_minh_so]", cnForm.getKntcQdinhXm());
					word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(Formater.date2str(qd.getNgayLap())));
					word.put("[chuc_danh_thu_truong_co_quan_thue]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
					if (Formater.isNull(cnForm.getYeuCauYcgt()))
						word.put("[noi_dung_quyet_dinh_xac_minh]", ".......");
					else
						word.put("[noi_dung_quyet_dinh_xac_minh]", cnForm.getYeuCauYcgt());
					word.put("[co_quan_thue_de_nghi_giam_dinh]", appContext.getTenCqt());
					word.put("[ten_co_quan_giam_dinh]", cnForm.getDonViYcgt());
					word.put("[noi_dung_quyet_dinh_xac_minh]", cnForm.getYeuCauYcgt());
					word.put("[co_quan_thue_de_nghi_giam_dinh]", appContext.getTenCqt());
					word.put("[ten_co_quan_giam_dinh]", cnForm.getDonViYcgt());
					if (Formater.isNull(cnForm.getThoiDiemYcgt()))
						word.put("[thoi_gian_ban_giao_ho_so]", "....gi\u1EDD......ng\u00E0y....th\u00E1ng....n\u0103m...........");
					else
						word.put("[thoi_gian_ban_giao_ho_so]", Formater.getDateTimeForPrint(cnForm.getThoiDiemYcgt()));
					if (Formater.isNull(cnForm.getDiaDiemYcgt()))
						word.put("[dia_diem]", "...........");
					else
						word.put("[dia_diem]", cnForm.getDiaDiemYcgt());
					word.put("[co_quan_thue_de_nghi_giam_dinh]", appContext.getTenCqt());
					word.put("[ten_co_quan_giam_dinh]", cnForm.getDonViYcgt());
					word.put("[co_quan_thue_de_nghi_giam_dinh]", appContext.getTenCqt());
					if (Formater.isNull(cnForm.getThoiGianNhanPhieu()))
						word.put("[thoi_diem_cung_cap_ket_qua]", "ng\u00E0y...th\u00E1ng....n\u0103m.........");
					else
						word.put("[thoi_diem_cung_cap_ket_qua]", Formater.getDateTimeForPrint(cnForm.getThoiGianNhanPhieu()));
					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]",
					// appContext.getTenThuTruong());
					word.saveAndClose();
					word.downloadFile(fileOut, "Mau 15/TC", ".doc", response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					System.out.println("Download Error: " + ex.getMessage());
				}
			}
		}
		// InputStream inputStream =
		// getServlet().getServletContext().getResourceAsStream("/report/" + su
		// + ".jasper");
		// KtnbUtil.printf(reportRows, su, response, inputStream, parameters,
		// null);
		return null;
	}
}
