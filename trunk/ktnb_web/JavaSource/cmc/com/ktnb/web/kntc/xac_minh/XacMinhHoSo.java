
package cmc.com.ktnb.web.kntc.xac_minh;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import org.apache.struts.config.FormBeanConfig;
import org.apache.struts.util.LabelValueBean;
import org.apache.struts.util.RequestUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.jacob.com.Dispatch;

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KntcBienBan;
import cmc.com.ktnb.pl.hb.entity.KntcBienBanId;
import cmc.com.ktnb.pl.hb.entity.KntcCanBoRls;
import cmc.com.ktnb.pl.hb.entity.KntcCanBoRlsId;
import cmc.com.ktnb.pl.hb.entity.KntcDeXuatXly;
import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.pl.hb.entity.KntcQdinhXm;
import cmc.com.ktnb.pl.hb.entity.KntcXmBaoCaoKq;
import cmc.com.ktnb.pl.hb.entity.KntcXmGiaHan;
import cmc.com.ktnb.pl.hb.entity.KntcXmKeHoach;
import cmc.com.ktnb.service.kntc.KntcSoTiepDan;
import cmc.com.ktnb.service.kntc.PhanLoaiXuLyService;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.service.kntc.XacMinhService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HttpUtil;
import cmc.com.ktnb.util.KntcDAO;
import cmc.com.ktnb.util.KntcUtil;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.util.URLUTF8Encoder;
import cmc.com.ktnb.web.BaseActionForm;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.catalog.CatalogService;
import cmc.com.ktnb.web.dung_chung.DungChungService;
import cmc.com.ktnb.web.kntc.tiep_dan.SoTiepDanForm;
import cmc.com.ktnb.web.kntc.xac_minh.tien_hanh.GiaHanXmForm;

/**
 * Xử lý các thông tin quá trình xác minh hồ sơ KNTC
 * 
 * @author Ntthu - CMCSOFT
 * @since 03/2011
 * @author Dhphuc - CMCSOFT
 * @since 03/2011
 */
public class XacMinhHoSo extends BaseDispatchAction {

	/**
	 * Show quyết định xác minh 10/KNTC, 22/KNTC
	 * 
	 * @throws Exception
	 */
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			DungChungService service = new DungChungService();
			if ("4".equals(service.getVersionDonKntc(appContext, maHs)))
				return showV4(map, form, request, response);
			else
				System.out.println("Ma HS : "+service.getVersionDonKntc(appContext, maHs));
				return showV3(map, form, request, response);
		} else
			if("4".equals(Constants.APP_DEP_VERSION))
				return showV4(map, form, request, response);
			else 
				return showV3(map, form, request, response);
	}
	public ActionForward showV3(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		FormBeanConfig fbc = map.getModuleConfig().findFormBeanConfig("xacMinhForm");
		Class clazz = Class.forName(fbc.getType());
		XacMinhForm xmForm = (XacMinhForm) clazz.newInstance();
		String maHs = request.getParameter("id");
		String ret = "success";
		boolean isKN = SoTiepDanService.isKN(appContext, maHs);
		if (!Formater.isNull(maHs)) {
			xmForm.setMaHoSo(maHs);
			SoTiepDanService s = new SoTiepDanService();
			KntcSoTiepDan hs = s.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = hs.getHdr();
			ret = isKN ? "success" : "qdtc";
			XacMinhService xmService = new XacMinhService();
			KntcQdinhXm qd = xmService.getKntcQdinhXmByHoSo(appContext, maHs);
			if (qd == null) // Tao moi
			{
				String readOnly = request.getParameter("r");
				if (readOnly != null)
					if (readOnly.equals("rol")) {
						throw new KtnbException("Bi&#7875;u m&#7851;u n&#224;y kh&#244;ng c&#243; s&#7889; li&#7879;u!!!", "", "");
					}
				if (hdr.getLoaiKntc().intValue() == 1) // KN
				{
					xmForm.setDeNghiTruongBoPhan(appContext.getTenTruongPhong());
				} else if (hdr.getLoaiKntc().intValue() == 2) // TC
				{
					xmForm.setNguoiBiTcTen(hdr.getNguoiBiKntcTen());
					xmForm.setNguoiBiTcHanhVi(hdr.getNoiDung());
				}
				xmForm.setChucDanhCanBoTqXm(xmForm.getChucDanhCanBoTqXm());
				xmForm.setSoQd(KtnbUtil.getMaNvu(appContext, "Q\u0110"));
				//xmForm.setThoiDiem(Formater.date2str(new Date()));
				xmForm.setDiaDiem(appContext.getDiaBan());
				// Save can bo default
				KntcCanBoRls cbRls = new KntcCanBoRls();
				KntcCanBoRlsId cbId = new KntcCanBoRlsId();
				cbId.setMaCanbo(appContext.getMaCanbo());
				cbRls.setId(cbId);
				cbRls.setTenCb(appContext.getTenCanbo());
				cbRls.setChucVu(appContext.getTenChucvu());
				cbRls.setDonVi(appContext.getTenPhong());
				cbRls.setVaiTro("Th\u00E0nh vi\u00EAn \u0111o\u00E0n");
				xmService.addCanBoXMDefault(maHs, cbRls);
			} else // Update
			{
				xmForm.fromEntity(qd);
			}
		}
		KtnbUtil.setVanBan(appContext, request);
		KtnbUtil.cacheListHolidayDayForClient(request, Formater.date2str(new Date()).substring(6), Formater.date2str(new Date()).substring(6));
		request.setAttribute("xacMinhForm", xmForm);
		// saveToken(request);
		return map.findForward(ret);
	}
	public ActionForward showV4(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		FormBeanConfig fbc = map.getModuleConfig().findFormBeanConfig("xacMinhForm");
		Class clazz = Class.forName(fbc.getType());
		XacMinhForm xmForm = (XacMinhForm) clazz.newInstance();
		String maHs = request.getParameter("id");
		String ret = "success";
		boolean isKN = SoTiepDanService.isKN(appContext, maHs);
		if (!Formater.isNull(maHs)) {
			xmForm.setMaHoSo(maHs);
			SoTiepDanService s = new SoTiepDanService();
			KntcSoTiepDan hs = s.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = hs.getHdr();
			ret = isKN ? "success" : "qdtc";
			XacMinhService xmService = new XacMinhService();
			KntcQdinhXm qd = xmService.getKntcQdinhXmByHoSo(appContext, maHs);
			if (qd == null) // Tao moi
			{
				String readOnly = request.getParameter("r");
				if (readOnly != null)
					if (readOnly.equals("rol")) {
						throw new KtnbException("Bi&#7875;u m&#7851;u n&#224;y kh&#244;ng c&#243; s&#7889; li&#7879;u!!!", "", "");
					}
				if (hdr.getLoaiKntc().intValue() == 1) // KN
				{
					xmForm.setDeNghiTruongBoPhan(appContext.getTenTruongPhong());
				} else if (hdr.getLoaiKntc().intValue() == 2) // TC
				{
					xmForm.setNguoiBiTcTen(hdr.getNguoiBiKntcTen());
					xmForm.setNguoiBiTcHanhVi(hdr.getNoiDung());
					xmForm.setNoiDung(hdr.getNoiDung());
					
				}
				xmForm.setSoQd(KtnbUtil.getMaNvu(appContext, "Q\u0110"));
				//xmForm.setThoiDiem(Formater.date2str(new Date()));
				xmForm.setDiaDiem(appContext.getDiaBan());
				// Save can bo default
				KntcCanBoRls cbRls = new KntcCanBoRls();
				KntcCanBoRlsId cbId = new KntcCanBoRlsId();
				cbId.setMaCanbo(appContext.getMaCanbo());
				cbRls.setId(cbId);
				cbRls.setTenCb(appContext.getTenCanbo());
				cbRls.setChucVu(appContext.getTenChucvu());
				cbRls.setDonVi(appContext.getTenPhong());
				cbRls.setVaiTro("Th\u00E0nh vi\u00EAn \u0111o\u00E0n");
				xmService.addCanBoXMDefault(maHs, cbRls);
			} else // Update
			{
//				String maHsStd=request.getParameter("id");
//				SoTiepDanService sv=new SoTiepDanService();
//				KntcSoTiepDan std=sv.getSoTiepDan(appContext, maHsStd, true);
//				System.out.println("Noi dung so tiep dan : "+std.getHdr().getNoiDung());
				xmForm.fromEntity(qd);
//				xmForm.setNoiDung(hdr.getNoiDung());
			}
		}
		KtnbUtil.setVanBan(appContext, request);
		KtnbUtil.cacheListHolidayDayForClient(request, Formater.date2str(new Date()).substring(6), Formater.date2str(new Date()).substring(6));
		request.setAttribute("xacMinhForm", xmForm);
		// saveToken(request);
		return map.findForward(ret);
	}
	// Báo cáo kết quả xác minh mẫu 17/KNTC, 23/KNTC
	public ActionForward bbKqXm(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		FormBeanConfig fbc = map.getModuleConfig().findFormBeanConfig("baoCaoKqXmForm");
		Class clazz = Class.forName(fbc.getType());
		BaoCaoKqXmForm xmForm = (BaoCaoKqXmForm) clazz.newInstance();
		String maHs = request.getParameter("id");
		XacMinhService s = new XacMinhService();
		boolean isKN = true;
		SoTiepDanService stdService = new SoTiepDanService();
		KntcSoTiepDan hs = stdService.getSoTiepDan(appContext, maHs, true);
		KntcHoSoHdr hdr = hs.getHdr();
		if (hdr.getLoaiKntc().intValue() == 2)
			isKN = false;
		KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, maHs);
		String maQd = "0";
		if (qd != null)
			maQd = qd.getMaQd();
		KntcXmBaoCaoKq kq = null;
		if (maQd != "0")
			kq = s.getKntcKquaGquyetByHs(appContext, maHs);
		if (kq == null) { // Tao moi
			xmForm.setMaHoSo(maHs);
			// KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			if (maQd != "0") {
				xmForm.setSoQd(maQd);
			} else {
				xmForm.setSoQd(".../QD");
			}
			//xmForm.setThoiDiemBc(Formater.date2str(new Date()));
			xmForm.setDiaDiemBc(appContext.getDiaBan());
		} else {
			xmForm.setDiaDiemBc(kq.getDiaDiem());
			xmForm.setThoiDiemBc(Formater.date2str(kq.getNgayLap()));
			xmForm.setSoQd(kq.getMaQd());
			xmForm.setMaHoSo(kq.getMaHs());
			xmForm.setMaHiddenBb(kq.getMa());
			xmForm.setCbKetThuc(String.valueOf(kq.getKetThucXm()));
			// cnForm.setNoiDungViPham(qd.getNguoiBiKntcHanhVi());//Luôn lấy
			// thông tin theo mẫu 10, không nên lưu thừa trên mẫu 17.
		}
		request.setAttribute("baoCaoKqXmForm", xmForm);
		if (isKN)
			return map.findForward("bbKqXm");
		else
			return map.findForward("bbKqXmTc");
	}

	/**
	 * Save báo cáo kết quả xác minh 17/KNTC, 23/KNTC
	 */
	public ActionForward saveBbKqXm(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaoCaoKqXmForm cnForm = (BaoCaoKqXmForm) form;
		String maHs = cnForm.getMaHoSo();
		boolean isKN = true;
		if (!Formater.isNull(maHs)) {
			SoTiepDanService stdService = new SoTiepDanService();
			KntcSoTiepDan hs = stdService.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = hs.getHdr();
			if (hdr.getLoaiKntc().intValue() == 2)
				isKN = false;
			try {
				KntcXmBaoCaoKq qd = cnForm.toBaoCaoKqXm(appContext);
				XacMinhService s = new XacMinhService();
				s.saveBienBanQuyetDinhXacMinh(appContext, qd);
				request.setAttribute(isKN ? "ghiThanhcong_17" : "ghiThanhcong_23", "1");
			} catch (Exception e) {
				request.setAttribute(isKN ? "ghiThanhcong_17" : "ghiThanhcong_23", "0");
				e.printStackTrace();
				throw new Exception(e);
			}
		}
		if (isKN)
			HttpUtil.doForward("kntc_xac_minh.do?method=xacMinh&action=xacMinhKhieuNai&id=" + cnForm.getMaHoSo(), request, response);
		else
			HttpUtil.doForward("kntc_xac_minh.do?method=xacMinh&action=xacMinhToCao&id=" + cnForm.getMaHoSo(), request, response);
		return null;
	}

	/**
	 * Lưu thông tin kế hoạch xác minh Dùng chung cho KN và TC
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveKeHoachXm(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		KeHoachForm cnForm = (KeHoachForm) request.getAttribute("khxmForm");
		try {
			KntcXmKeHoach qd = cnForm.toKeHoachXm(appContext);
			XacMinhService s = new XacMinhService();
			s.saveKeHoachXacMinh(appContext, qd, null);
			request.setAttribute("ghiThanhcong_kh", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong_kh", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		String urlRedirect = "";
		SoTiepDanService s = new SoTiepDanService();
		KntcSoTiepDan hs = s.getSoTiepDan(appContext, cnForm.getMaHoSo(), true);
		KntcHoSoHdr hdr = hs.getHdr();
		if (hdr.getLoaiKntc().intValue() == 1) // KN
			urlRedirect = "kntc_xac_minh.do?method=xacMinh&action=xacMinhKhieuNai&id=" + cnForm.getMaHoSo();
		else if (hdr.getLoaiKntc().intValue() == 2) // TC
			urlRedirect = "kntc_xac_minh.do?method=xacMinh&action=xacMinhToCao&id=" + cnForm.getMaHoSo();
		HttpUtil.doForward(urlRedirect, request, response);
		return null;
	}

	public ActionForward khxm(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);

		FormBeanConfig fbc = map.getModuleConfig().findFormBeanConfig("khxmForm");
		Class clazz = Class.forName(fbc.getType());
		KeHoachForm cnForm = (KeHoachForm) clazz.newInstance();
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			XacMinhService services = new XacMinhService();
			KntcXmKeHoach kh = services.getKntcXmKeHoachByHoSo(appContext, maHs);
			String readOnly = request.getParameter("r");
			KntcQdinhXm qd = services.getKntcQdinhXmByHoSo(appContext, maHs);
			if (qd==null && readOnly != null)
				if (readOnly.equals("rol")) {
					throw new KtnbException("Bi&#7875;u m&#7851;u n&#224;y kh&#244;ng c&#243; s&#7889; li&#7879;u!!!", "", "");
				}
			if (qd != null)
				cnForm.setNoiDung(qd.getNoiDungXm());
			else
				cnForm.setNoiDung("Ch\u01B0a c\u00F3 QDXM m\u1EABu 10/KNTC.");
			cnForm.setMaHoSo(maHs);
			if (qd != null) {
				Collection listCb = services.getListCanBoXmByHs(appContext, qd.getMaHs());
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
				// cnForm.setCanBoTen(qd.getNguoiCapNhat());
				cnForm.setMaQd(qd.getMaQd());
			} else {
				ArrayList list = (ArrayList) request.getAttribute("dmcb");
				if (list == null) { // Chua co trong session
					list = new ArrayList();
					list.add(new LabelValueBean(", Ch\u1EE9c v\u1EE5: ", ", Ch\u1EE9c v\u1EE5: "));
				}
				request.setAttribute("dmcb", list);
			}
			if (kh != null) { // Update ke hoach
				cnForm.fromEntity(kh, appContext);
			} else { // Insert moi
				// cnForm.setThoiDiem(Formater.date2str(new Date()));
				cnForm.setDiaDiem(appContext.getDiaBan());
			}
		}
		// saveToken(request);
		request.setAttribute("khxmForm", cnForm);
		return map.findForward("khxm");
	}

	public ActionForward khxmtc(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		KeHoachForm cnForm = (KeHoachForm) form;
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			XacMinhService services = new XacMinhService();
			KntcXmKeHoach kh = services.getKntcXmKeHoachByHoSo(appContext, maHs);

			KntcQdinhXm qd = services.getKntcQdinhXmByHoSo(appContext, maHs);
			if (qd == null || qd.getNgayDuyet() == null)
				throw new KtnbException("Ch&#x1B0;a c&#xF3; Quy&#x1EBF;t &#x111;&#x1ECB;nh x&#xE1;c minh, ho&#x1EB7;c Q&#x110;XM ch&#x1B0;a &#x111;&#x1B0;&#x1EE3;c duy&#x1EC7;t!", "",
						"C&#7847;n l&#7853;p quy&#7871;t &#273;&#7883;nh x&#225;c minh m&#7851;u 22/KNTC tr&#432;&#7899;c!");

			cnForm.setNoiDung(qd.getNoiDungXm());
			cnForm.setMaHoSo(maHs);
			SoTiepDanService std = new SoTiepDanService();
			StringBuffer sb = new StringBuffer(std.getNoiDungDonForXm(appContext, maHs));
			sb.append("\n");
			sb.append(qd.getCanCuPly());
			if (qd != null) {
				Collection listCb = services.getListCanBoXmByHs(appContext, qd.getMaHs());
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
				// cnForm.setCanBoTen(qd.getNguoiCapNhat());
				cnForm.setMaQd(qd.getMaQd());
			}
			if (kh != null) { // Update ke hoach
				cnForm.fromEntity(kh, appContext);
			} else { // Insert moi
				// cnForm.setThoiDiem(Formater.date2str(new Date()));
				cnForm.setDiaDiem(appContext.getDiaBan());
			}
		}
		// saveToken(request);
		return map.findForward("khxmTc");
	}

	public ActionForward saveKhxmTc(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		KeHoachForm cnForm = (KeHoachForm) form;
		try {
			KntcXmKeHoach qd = cnForm.toKeHoachXm(appContext);
			XacMinhService s = new XacMinhService();
			s.saveKeHoachXacMinh(appContext, qd);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		HttpUtil.doForward("kntc_khxm.do?method=khxmtc&id=" + cnForm.getMaHoSo(), request, response);
		return null;
	}

	/**
	 * Show Gia han xac minh 16/KNTC
	 */
	public ActionForward giahan(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		GiaHanXmForm ghForm = (GiaHanXmForm) form;
		String maHs = request.getParameter("id");
		XacMinhService s = new XacMinhService();
		if (!Formater.isNull(maHs)) {
			SoTiepDanService stdService = new SoTiepDanService();
			KntcSoTiepDan std = stdService.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = std.getHdr();
			ghForm.setTrangThaiHoSo(hdr.getTrangThai());
			String readOnly = request.getParameter("r");
			if (readOnly != null)
				if (readOnly.equals("rol")) {
					if (s.getQDGHByMaHs(appContext, maHs) == null) {
						throw new KtnbException("Bi&#7875;u m&#7851;u n&#224;y kh&#244;ng c&#243; s&#7889; li&#7879;u!!!", "", "");
					}
				}

			KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, maHs);
			if (qd == null || qd.getNgayDuyet() == null) {
				throw new KtnbException("Ch&#x1B0;a c&#xF3; Quy&#x1EBF;t &#x111;&#x1ECB;nh x&#xE1;c minh, ho&#x1EB7;c Q&#x110;XM ch&#x1B0;a &#x111;&#x1B0;&#x1EE3;c duy&#x1EC7;t!", "",
						"C&#7847;n ho&#224;n thi&#7879;n Quy&#7871;t &#273;&#7883;nh x&#225;c minh tr&#432;&#7899;c khi l&#224;m c&#225;c bi&#7875;u m&#7851;u ti&#7871;p theo!");
			}
			String maQD = qd.getMaQd();
			if (!Formater.isNull(maQD)) {
				KntcQdinhXm qdXm = s.getKntcQdinhXmByHoSo(appContext, maHs);
				ghForm.setCanCuQd(maQD);
				ghForm.setMaHoSo(qdXm.getMaHs());

			}
			ghForm.setSoPhieu(KtnbUtil.getMaNvu(appContext, "Q\u0110"));
			ghForm.setNgayLap("");
			ghForm.setDiaDiem(appContext.getDiaBan());
			ghForm.setNgayKThucXM("");
			KtnbUtil.setVanBan(appContext, request);
			KtnbUtil.cacheListHolidayDayForClient(request, Formater.date2str(new Date()).substring(6), Formater.date2str(new Date()).substring(6));
		}
		
		return returnDefaultGiaHan(map, form, request, response);
	}
	/*
	 * Return default gia han
	 * */
	public ActionForward returnDefaultGiaHan(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String loaiGiaHan=request.getParameter("action");
//		if("giahanTC".equals(loaiGiaHan))
//			return map.findForward("giahanTC");
		return map.findForward("giahan");
	}
	/**
	 * Save gia han xac minh
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveGh(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// if (isTokenValid(request, true)) {
		String action = request.getParameter("action");
		GiaHanXmForm ghForm = (GiaHanXmForm) form;
		try {
			KntcXmGiaHan gh = ghForm.toEntity(appContext);
			// Luu xuong DB
			XacMinhService services = new XacMinhService();
			services.saveQdGiaHanXacMinh(appContext, gh);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		// }
		HttpUtil.doForward("kntc_xm_gia_han.do?method=giahan&action=" + action + "&id=" + ghForm.getMaHoSo(), request, response);
		return null;
	}

	/**
	 * Xem gia han xac minh
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward xemQdgh(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhService s = new XacMinhService();
		try {
			// System.out.println(request.getParameter("pId").toString());
			// KntcQdinhXm qdXm = s.getKntcQdinhXm(appContext,
			// request.getParameter("id").toString());
			KntcXmGiaHan gh = s.getQDGHByMaQD(appContext, request.getParameter("pId").toString());
			GiaHanXmForm ghForm = (GiaHanXmForm) form;
			ghForm.toForm(gh);
			// Nếu đã có số quyết định gia hạn và ngày ban hành => không cho
			// sửa.
			if (!Formater.isNull(ghForm.getSoPhieu()) && !Formater.isNull(ghForm.getNgayLap())) {
				ghForm.setChoSua("false");
			}
			KtnbUtil.setVanBan(appContext, request);
			KtnbUtil.cacheListHolidayDayForClient(request, Formater.date2str(new Date()).substring(6), Formater.date2str(new Date()).substring(6));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return returnDefaultGiaHan(map, form, request, response);
	}

	/**
	 * Tao moi gia han xac minh
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward taoMoiQdgh(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		GiaHanXmForm ghForm = (GiaHanXmForm) form;
		String maHs = request.getParameter("id");
		XacMinhService s = new XacMinhService();
		KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, maHs);
		String maQD = qd.getMaQd();
		// Nếu chưa có thông tin ngày ban hành và thời gian xác minh => lỗi
		if (Formater.isNull(Formater.date2str(qd.getTuNgayXm())) || Formater.isNull(Formater.date2str(qd.getDenNgayXm()))) {
			throw new KtnbException(
					"Quy&#7871;t &#273;&#7883;nh x&#225;c minh c&#7847;n c&#243; ng&#224;y ban h&#224;nh v&#224; th&#7901;i gian x&#225;c minh m&#7899;i l&#7853;p &#273;&#432;&#7907;c phi&#7871;u gia h&#7841;n",
					"Quy&#7871;t &#273;&#7883;nh x&#225;c minh c&#7847;n c&#243; ng&#224;y ban h&#224;nh v&#224; th&#7901;i gian x&#225;c minh m&#7899;i l&#7853;p &#273;&#432;&#7907;c phi&#7871;u gia h&#7841;n");
		}
		if (!Formater.isNull(maQD)) {
			ghForm.setCanCuQd(maQD);
			ghForm.setMaHoSo(qd.getMaHs());
			// ghForm.setGiaHanTuNgay(Formater.date2str(qd.getTuNgayXm()));
			ghForm.setNgayKThucXM(Formater.date2str(qd.getDenNgayXm()));
		}
		// ghForm.setSoPhieu(KtnbUtil.getMaNvu(appContext, "Q\u0110"));
		ghForm.setSoPhieu("");
		ghForm.setNgayLap("");
		ghForm.setMa(null);

		ghForm.setSoNgayGH("");
		ghForm.setGiaHanTuNgay("");
		ghForm.setGiaHanDenNgay("");
		ghForm.setDiaDiem(appContext.getDiaBan());

		KtnbUtil.setVanBan(appContext, request);
		KtnbUtil.cacheListHolidayDayForClient(request, Formater.date2str(new Date()).substring(6), Formater.date2str(new Date()).substring(6));
		// saveToken(request);
		return returnDefaultGiaHan(map, form, request, response);
	}

	/**
	 * Xoa phieu yeu cau 16
	 */
	public ActionForward xoaQdgh(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhService s = new XacMinhService();
		try {
			s.delQDGHByMa(appContext, request.getParameter("pId").toString());
			request.setAttribute("xoaThanhcong", "1");
		} catch (KtnbException e) {
			e.printStackTrace();
			request.setAttribute("xoaThanhcong", "0");
			throw e;
		} catch (Exception e) {
			request.setAttribute("xoaThanhcong", "0");
			e.printStackTrace();
		}
		KtnbUtil.setVanBan(appContext, request);
		KtnbUtil.cacheListHolidayDayForClient(request, Formater.date2str(new Date()).substring(6), Formater.date2str(new Date()).substring(6));
		return returnDefaultGiaHan(map, form, request, response);
	}

	/**
	 * lưu quyết định xác minh, mẫu 10/KNTC, 22/KNTC
	 * 
	 * @throws Exception
	 */
	public ActionForward save(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// if (isTokenValid(request, true)) {
		XacMinhForm xmForm = (XacMinhForm) form;
		boolean isKN = SoTiepDanService.isKN(appContext, xmForm.getMaHoSo());
		try {
			KntcQdinhXm qd = new KntcQdinhXm();
			qd.setMa(xmForm.getMaHidden());
			qd.setMaHs(xmForm.getMaHoSo());
			qd.setBenLienQuan(xmForm.getBenLienQuan());
			qd.setBenLienQuanTt(xmForm.getBenLienQuanThuTruong());
			qd.setNgayLap(Formater.str2date(xmForm.getThoiDiem()));
			qd.setTuNgayXm(Formater.str2date(xmForm.getTuNgayXm()));
			qd.setDenNgayXm(Formater.str2date(xmForm.getDenNgayXm()));

			qd.setDiaDiem(xmForm.getDiaDiem());
			qd.setNgayCapNhat(new Date());
			qd.setNguoiCapNhat(appContext.getTenNsd());

			// Thong tin ky duyet
			qd.setNgayDuyet(Formater.str2date(xmForm.getNgayDuyet()));
			qd.setNgayTrinhDuyet(Formater.str2date(xmForm.getNgayTrinhDuyet()));
			qd.setNgayTrinhKy(Formater.str2date(xmForm.getNgayTrinhKy()));
			qd.setNgayKy(Formater.str2date(xmForm.getNgayKy()));
			qd.setYKienTrinh(xmForm.getKienTrinh());
			qd.setYKienDuyet(xmForm.getKienDuyet());

			qd.setNoiDungXm(xmForm.getNoiDung());
			if (!Formater.isNull(xmForm.getSoNgayXm()))
				qd.setSoNgayXm(new Long(xmForm.getSoNgayXm()));
			qd.setMaQd(xmForm.getSoQd());
			qd.setSoVanBan(xmForm.getCanCuVanBan());
			qd.setCanCuNvu(xmForm.getCanCuNhiemVu());
			qd.setNguoiBiKntcTen(xmForm.getNguoiBiTcTen());
			// if (!Formater.isNull(xmForm.getNguoiBiTcHanhVi()))
			qd.setNguoiBiKntcHanhVi(xmForm.getNguoiBiTcHanhVi());
			qd.setChucDanhCanBoTqXm(xmForm.getChucDanhCanBoTqXm());
			qd.setDeNghiTruongBoPhan(xmForm.getDeNghiTruongBoPhan());
			qd.setTrangThai(new Long(1));
			// Luu xuong DB
			XacMinhService services = new XacMinhService();

			// Thong tin can bo xac minh
			Collection listCb = new ArrayList();
			// if (isTokenValid(request, true)) {
			if (xmForm.getArrCanBo().length() > 0) {
				String[] arrCb = xmForm.getArrCanBo().split("@@");
				for (int i = 0; i < arrCb.length; i++) {
					String[] item = arrCb[i].split(",");
					KntcCanBoRls aCb = new KntcCanBoRls();
					KntcCanBoRlsId aId = new KntcCanBoRlsId(item[0], xmForm.getMaHoSo(), new Long(0), KntcCanBoRls.KNTC_TVD_XAC_MINH);
					aCb.setId(aId);
					aCb.setTenCb(item[1]);
					aCb.setDonVi(item[2]);
					if (!Formater.isNull(item[3]))
						aCb.setChucVu(item[3]);
					if (!Formater.isNull(item[4]))
						aCb.setVaiTro(item[4]);
					aCb.setNgayCapNhat(new Date());
					aCb.setNguoiCapNhat(appContext.getTenNsd());
					listCb.add(aCb);
				}
			}
			services.saveQuyetDinhXacMinh(appContext, qd, listCb);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}

		if (isKN) {
			HttpUtil.doForward("kntc_xac_minh.do?method=xacMinh&action=xacMinhKhieuNai&id=" + xmForm.getMaHoSo(), request, response);
		} else {
			HttpUtil.doForward("kntc_xac_minh.do?method=xacMinh&action=xacMinhToCao&id=" + xmForm.getMaHoSo(), request, response);
		}

		return null;
	}

	public ActionForward getListQd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String maHs = request.getParameter("id");
		if (Formater.isNull(maHs))
			return null;
		else {
			JSONObject jsonResult = null;
			KntcDAO kntcDAO = KntcUtil.getKntcDAO();
			try {
				jsonResult = kntcDAO.getListQdGiaHan(maHs);
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

	public ActionForward getListDmNd(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String maHs = request.getParameter("maHs");
		String l1 = request.getParameter("l1");
		String l2 = request.getParameter("l2");
		if (Formater.isNull(maHs) || Formater.isNull(l1) || Formater.isNull(l2))
			return null;
		else {
			JSONObject jsonResult = null;
			KntcDAO kntcDAO = KntcUtil.getKntcDAO();
			try {
				jsonResult = kntcDAO.getListDmNd(maHs, l1, l2);
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
	
	/** 
	 * Des : in
	 * 
	 */
	
	public ActionForward in(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhForm cnForm = (XacMinhForm) form;
		String maHs = cnForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			DungChungService service = new DungChungService();
			if ("4".equals(service.getVersionDonKntc(appContext, maHs)))
				inv4(map, form, request, response);
			else
				inv3(map, form, request, response);
			System.out.println("Ma HS : "+service.getVersionDonKntc(appContext, maHs));
		} else
			if("4".equals(Constants.APP_DEP_VERSION))
				inv4(map, form, request, response);
			else 
				inv3(map, form, request, response);
		return null;
	}

	/**
	 * Download file mẫu KNTC10,KNTC22
	 * 
	 * Des: ktnbv3
	 * 
	 * @throws Exception
	 */
	
	//v3
	
	public ActionForward inv3(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;

		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		XacMinhForm xmForm = (XacMinhForm) form;
		String maHs = xmForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			SoTiepDanService stdService = new SoTiepDanService();
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			KntcSoTiepDan std = stdService.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = std.getHdr();
			// KntcNdungDon don = std.getNoiDungDon();
			String fileTemplate = "kntc10";
			if (hdr.getLoaiKntc().intValue() == 2) {
				fileTemplate = "kntc22";
				fileIn = request.getRealPath("/docin") + "\\KNTC22.doc";
				fileOut = request.getRealPath("/docout") + "\\KNTC22_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

				word = new MsWordUtils(fileIn, fileOut);
				try {
					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_QD]", appContext.getTenCqt().toUpperCase());
					word.put("[so_quyet_dinh]", "S\u1ED1: " + xmForm.getSoQd());
					// String[] arr = arrDms.split(",");
					String ngayLap = "";
					if (Formater.isNull(xmForm.getThoiDiem())) {
						ngayLap = "ng\u00E0y   th\u00E1ng   n\u0103m        ";
						word.put("[ngay_lap_quyet_dinh]", xmForm.getDiaDiem() + ", " + ngayLap);
					} else
						word.put("[ngay_lap_quyet_dinh]", xmForm.getDiaDiem() + ", " + Formater.getDateForPrint(xmForm.getThoiDiem()));
					word.put("[chuc_danh_thu_truong_co_quan]", KtnbUtil.getTenThuTruongCqtForMauin(appContext).toUpperCase());
					word.put("[van_ban_quy_dinh_chuc_nang_nhiem_vu]", CatalogService.getTenDanhMucById(xmForm.getCanCuVanBan()));
					word.put("[giao_nhiem_vu_xac_minh]", xmForm.getCanCuNhiemVu());
					word.put("[don_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
					word.put("[ten_nguoi_bi_to_cao]", dx.getNguoiBiKNTC());
					if (!Formater.isNull(dx.getChuDanhNguoiBiKNTC()))
						word.put("[chuc_vu_nguoi_bi_to_cao]", dx.getChuDanhNguoiBiKNTC());
					else
						word.put("[chuc_vu_nguoi_bi_to_cao]", "");
					word.put("[hanh_vi_cua_nguoi_bi_to_cao]", xmForm.getNguoiBiTcHanhVi());
					word.put("[noi_dung_xac_minh]", xmForm.getNoiDung());
					word.put("[thoi_gian_xac_minh]", xmForm.getSoNgayXm());
					word.put("[tu_ngay]", Formater.getDateForPrint(xmForm.getTuNgayXm()));
					word.put("[den_ngay]", Formater.getDateForPrint(xmForm.getDenNgayXm()));

					StringBuffer sb = new StringBuffer();
					String[] arrCb = xmForm.getArrCanBo().split("@@");
					try {
						for (int i = 0; i < arrCb.length; i++) {
							String[] item = arrCb[i].split(",");
							if (item != null) {
								sb.append(i + 1 + ". \u00D4ng (b\u00E0): " + item[1]);
								if (!Formater.isNull(item[3]))
									sb.append(", ch\u1EE9c v\u1EE5: " + item[3] + ",");
								if (!Formater.isNull(item[4]))
									sb.append(item[4]);
								sb.append("\n");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					word.put("[thanh_vien_doan]", sb.toString());
					if (Formater.isNull(xmForm.getBenLienQuanThuTruong()))
						word.put("[thu_truong_co_quan_lien_quan]", "..........");
					else
						word.put("[thu_truong_co_quan_lien_quan]", xmForm.getBenLienQuanThuTruong());
					word.put("[ten_nguoi_bi_to_cao]", dx.getNguoiBiKNTC());
					if (Formater.isNull(xmForm.getBenLienQuan()))
						word.put("[nguoi_co_quan_don_vi_co_lien_quan]", "..........");
					else
						word.put("[nguoi_co_quan_don_vi_co_lien_quan]", xmForm.getBenLienQuan());
					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]",
					// appContext.getTenThuTruong());
					// word.put("[y_kien_cua_truong_bo_phan]",
					// xmForm.getKienTrinh());
					// word.put("[ngay_truong_bo_phan_ky]",
					// Formater.getDateForPrint(xmForm.getNgayKy()));
					// word.put("[y_kien_cua_thu_truong_co_quan]",
					// xmForm.getKienDuyet());
					// word.put("[ngay_thu_truong_phe_duyet]",
					// Formater.getDateForPrint(xmForm.getNgayDuyet()));
					// word.put("[hanh_vi_hanh_chinh]",
					// xmForm.getNguoiBiTcHanhVi());
					word.saveAndClose();
					word.downloadFile(fileOut, "Mau KNTC22", ".doc", response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					System.out.println("Download Error: " + ex.getMessage());
				} finally {
					try {
						word.saveAndClose();
					} catch (Exception ex) {
					}
				}

			} else if (hdr.getLoaiKntc().intValue() == 1) {
				fileTemplate = "kntc10";
				fileIn = request.getRealPath("/docin") + "\\KNTC10.doc";
				fileOut = request.getRealPath("/docout") + "\\KNTC10_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

				try {
					word = new MsWordUtils(fileIn, fileOut);
					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_QD]", appContext.getTenCqt().toUpperCase());
					word.put("[so_quyet_dinh]", "S\u1ED1: " + xmForm.getSoQd());
					// String[] arr = arrDms.split(",");
					String ngayLap = "";
					if (Formater.isNull(xmForm.getThoiDiem())) {
						ngayLap = "ng\u00E0y   th\u00E1ng   n\u0103m        ";
						word.put("[ngay_lap_quyet_dinh]", xmForm.getDiaDiem() + ", " + ngayLap);
					} else
						word.put("[ngay_lap_quyet_dinh]", xmForm.getDiaDiem() + ", " + Formater.getDateForPrint(xmForm.getThoiDiem()));
					word.put("[chuc_danh_thu_truong_co_quan]", KtnbUtil.getTenThuTruongCqtForMauin(appContext).toUpperCase());
					word.put("[van_ban_quy_dinh_chuc_nang_nhiem_vu]", CatalogService.getTenDanhMucById(xmForm.getCanCuVanBan()));
					word.put("[truong_bo_phan]", KtnbUtil.getTenTruongBoPhan(appContext) + " " + appContext.getTenPhong());
					word.put("[tom_tat_noi_dung_khieu_nai]", "khi\u1EBFu n\u1EA1i");
					word.put("[don_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
					word.put("[hanh_vi_hanh_chinh]", xmForm.getNguoiBiTcHanhVi());
					word.put("[noi_dung_xac_minh]", xmForm.getNoiDung());
					word.put("[thoi_gian_xac_minh]", xmForm.getSoNgayXm());
					StringBuffer sb = new StringBuffer();
					String[] arrCb = xmForm.getArrCanBo().split("@@");
					try {
						for (int i = 0; i < arrCb.length; i++) {
							String[] item = arrCb[i].split(",");
							if (item != null) {
								sb.append(i + 1 + ". \u00D4ng (b\u00E0): " + item[1]);
								if (!Formater.isNull(item[3]))
									sb.append(", ch\u1EE9c v\u1EE5: " + item[3] + ",");
								if (!Formater.isNull(item[4]))
									sb.append(item[4]);
								sb.append("\n");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					word.put("[thanh_vien_doan]", sb.toString());

					if (Formater.isNull(xmForm.getBenLienQuanThuTruong()))
						word.put("[thu_truong_co_quan_lien_quan]", "..........");
					else
						word.put("[thu_truong_co_quan_lien_quan]", xmForm.getBenLienQuanThuTruong());
					if (Formater.isNull(xmForm.getBenLienQuan()))
						word.put("[nguoi_co_quan_don_vi_co_lien_quan]", "..........");
					else
						word.put("[nguoi_co_quan_don_vi_co_lien_quan]", xmForm.getBenLienQuan());
					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]",
					// appContext.getTenThuTruong());
					// word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]",
					// dx.getDcNguoiKNTC());
					// word.put("[hanh_vi_cua_nguoi_bi_to_cao]",
					// xmForm.getNguoiBiTcHanhVi());
					// word.put("[giao_nhiem_vu_xac_minh]",
					// xmForm.getCanCuNhiemVu());
					// word.put("[y_kien_cua_truong_bo_phan]",
					// xmForm.getKienTrinh());
					// word.put("[ngay_truong_bo_phan_ky]",
					// Formater.getDateForPrint(xmForm.getNgayKy()));
					// word.put("[y_kien_cua_thu_truong_co_quan]",
					// xmForm.getKienDuyet());
					// word.put("[ngay_thu_truong_phe_duyet]",
					// Formater.getDateForPrint(xmForm.getNgayDuyet()));
					word.saveAndClose();
					word.downloadFile(fileOut, "Mau KNTC10", ".doc", response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					System.out.println("Download Error: " + ex.getMessage());
				}
			}
		}
		return null;
	} 
	
	/**
	 * 
	 * Des: ktnbv4
	 * @throws Exception
	 */
	
	//v4
	public ActionForward inv4(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;

		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		XacMinhForm xmForm = (XacMinhForm) form;
		String maHs = xmForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			SoTiepDanService stdService = new SoTiepDanService();
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			KntcSoTiepDan std = stdService.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = std.getHdr();
			// KntcNdungDon don = std.getNoiDungDon();
			String fileTemplate = "kntc10";
			if (hdr.getLoaiKntc().intValue() == 2) {
				fileTemplate = "tc07";
				fileIn = request.getRealPath("/docin/v4") + "\\TC07.doc";
				fileOut = request.getRealPath("/docout") + "\\TC07_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

				word = new MsWordUtils(fileIn, fileOut);
				try {
					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_QD]", appContext.getTenCqt().toUpperCase());
					word.put("[so_quyet_dinh]", "S\u1ED1: " + xmForm.getSoQd());
					// String[] arr = arrDms.split(",");
					String ngayLap = "";
					if (Formater.isNull(xmForm.getThoiDiem())) {
						ngayLap = "ng\u00E0y   th\u00E1ng   n\u0103m        ";
						word.put("[ngay_lap_quyet_dinh]", xmForm.getDiaDiem() + ", " + ngayLap);
					} else
						word.put("[ngay_lap_quyet_dinh]", xmForm.getDiaDiem() + ", " + Formater.getDateForPrint(xmForm.getThoiDiem()));
					word.put("[chuc_danh_thu_truong_co_quan]", KtnbUtil.getTenThuTruongCqtForMauin(appContext).toUpperCase());
					word.put("[van_ban_quy_dinh_chuc_nang_nhiem_vu]", CatalogService.getTenDanhMucById(xmForm.getCanCuVanBan()));
					word.put("[truong_bo_phan]", KtnbUtil.getTenTruongBoPhan(appContext) + " " + appContext.getTenPhong());
//					word.put("[giao_nhiem_vu_xac_minh]", xmForm.getCanCuNhiemVu());
//					word.put("[don_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
					word.put("[ten_nguoi_bi_to_cao]", dx.getNguoiBiKNTC());
					if (!Formater.isNull(dx.getChuDanhNguoiBiKNTC()))
						word.put("[chuc_vu_nguoi_bi_to_cao]",", chức vụ " + dx.getChuDanhNguoiBiKNTC());
					else
						word.put("[chuc_vu_nguoi_bi_to_cao]", "");
					word.put("[hanh_vi_cua_nguoi_bi_to_cao]", xmForm.getNguoiBiTcHanhVi());
					word.put("[noi_dung_xac_minh]", xmForm.getNoiDung());
					StringBuffer sb = new StringBuffer();
					String[] arrCb = xmForm.getArrCanBo().split("@@");
					try {
						for (int i = 0; i < arrCb.length; i++) {
							String[] item = arrCb[i].split(",");
							if (item != null) {
								sb.append(i + 1 + ". \u00D4ng (b\u00E0): " + item[1]);
								if (!Formater.isNull(item[3]))
									sb.append(", ch\u1EE9c v\u1EE5: " + item[3] + ",");
								if (!Formater.isNull(item[4]))
									sb.append(item[4]);
								sb.append("\n");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					word.put("[thanh_vien_doan]", sb.toString());
					word.put("[thoi_gian_xac_minh]", xmForm.getSoNgayXm());
//					word.put("[tu_ngay]", Formater.getDateForPrint(xmForm.getTuNgayXm()));
//					word.put("[den_ngay]", Formater.getDateForPrint(xmForm.getDenNgayXm()));

					if (Formater.isNull(xmForm.getBenLienQuanThuTruong()))
						word.put("[thu_truong_co_quan_lien_quan]", "..........");
					else
						word.put("[thu_truong_co_quan_lien_quan]", xmForm.getBenLienQuanThuTruong());
					word.put("[ten_nguoi_bi_to_cao]", dx.getNguoiBiKNTC());
					if (!Formater.isNull(dx.getChuDanhNguoiBiKNTC()))
						word.put("[chuc_vu_nguoi_bi_to_cao]",", chức vụ " + dx.getChuDanhNguoiBiKNTC());
					else
						word.put("[chuc_vu_nguoi_bi_to_cao]", "");
//					if (Formater.isNull(xmForm.getBenLienQuan()))
//						word.put("[nguoi_co_quan_don_vi_co_lien_quan]", "..........");
//					else
//						word.put("[nguoi_co_quan_don_vi_co_lien_quan]", xmForm.getBenLienQuan());
					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]",
					// appContext.getTenThuTruong());
					// word.put("[y_kien_cua_truong_bo_phan]",
					// xmForm.getKienTrinh());
					// word.put("[ngay_truong_bo_phan_ky]",
					// Formater.getDateForPrint(xmForm.getNgayKy()));
					// word.put("[y_kien_cua_thu_truong_co_quan]",
					// xmForm.getKienDuyet());
					// word.put("[ngay_thu_truong_phe_duyet]",
					// Formater.getDateForPrint(xmForm.getNgayDuyet()));
					// word.put("[hanh_vi_hanh_chinh]",
					// xmForm.getNguoiBiTcHanhVi());
					word.saveAndClose();
					word.downloadFile(fileOut, "Mau TC07", ".doc", response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					System.out.println("Download Error: " + ex.getMessage());
				} finally {
					try {
						word.saveAndClose();
					} catch (Exception ex) {
					}
				}

			} else if (hdr.getLoaiKntc().intValue() == 1) {
				fileTemplate = "kn06";
				fileIn = request.getRealPath("/docin/v4/kntc") + "\\KN06.doc";
				fileOut = request.getRealPath("/docout") + "\\KN06_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

				try {
					word = new MsWordUtils(fileIn, fileOut);
					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_QD]", appContext.getTenCqt().toUpperCase());
					word.put("[so_quyet_dinh]", "S\u1ED1: " + xmForm.getSoQd());
					// String[] arr = arrDms.split(",");
					String ngayLap = "";
					if (Formater.isNull(xmForm.getThoiDiem())) {
						ngayLap = "ng\u00E0y   th\u00E1ng   n\u0103m        ";
						word.put("[ngay_lap_quyet_dinh]", xmForm.getDiaDiem() + ", " + ngayLap);
					} else
						word.put("[ngay_lap_quyet_dinh]", xmForm.getDiaDiem() + ", " + Formater.getDateForPrint(xmForm.getThoiDiem()));
					word.put("[chuc_danh_can_bo_tq_xm]", xmForm.getChucDanhCanBoTqXm());
					word.put("[van_ban_quy_dinh_chuc_nang_nhiem_vu]", CatalogService.getTenDanhMucById(xmForm.getCanCuVanBan()));
					word.put("[truong_bo_phan]", KtnbUtil.getTenTruongBoPhan(appContext) + " " + appContext.getTenPhong());
					//word.put("[tom_tat_noi_dung_khieu_nai]", "khi\u1EBFu n\u1EA1i");
					//word.put("[don_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
					//word.put("[hanh_vi_hanh_chinh]", xmForm.getNguoiBiTcHanhVi());
					word.put("[noi_dung_xac_minh]", xmForm.getNoiDung());
					word.put("[thoi_gian_xac_minh]", xmForm.getSoNgayXm());
					StringBuffer sb = new StringBuffer();
					String[] arrCb = xmForm.getArrCanBo().split("@@");
					try {
						for (int i = 0; i < arrCb.length; i++) {
							String[] item = arrCb[i].split(",");
							if (item != null) {
								sb.append(i + 1 + ". \u00D4ng (b\u00E0): " + item[1]);
								if (!Formater.isNull(item[3]))
									sb.append(", ch\u1EE9c v\u1EE5: " + item[3] + ",");
								if (!Formater.isNull(item[4]))
									sb.append(item[4]);
								sb.append("\n");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					word.put("[thanh_vien_doan]", sb.toString());

					if (Formater.isNull(xmForm.getBenLienQuanThuTruong()))
						word.put("[thu_truong_co_quan_lien_quan]", "..........");
					else
						word.put("[thu_truong_co_quan_lien_quan]", xmForm.getBenLienQuanThuTruong());
					//if (Formater.isNull(xmForm.getBenLienQuan()))
						//word.put("[nguoi_co_quan_don_vi_co_lien_quan]", "..........");
					//else
						//word.put("[nguoi_co_quan_don_vi_co_lien_quan]", xmForm.getBenLienQuan());
					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]",
					// appContext.getTenThuTruong());
					// word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]",
					// dx.getDcNguoiKNTC());
					// word.put("[hanh_vi_cua_nguoi_bi_to_cao]",
					// xmForm.getNguoiBiTcHanhVi());
					// word.put("[giao_nhiem_vu_xac_minh]",
					// xmForm.getCanCuNhiemVu());
					// word.put("[y_kien_cua_truong_bo_phan]",
					// xmForm.getKienTrinh());
					// word.put("[ngay_truong_bo_phan_ky]",
					// Formater.getDateForPrint(xmForm.getNgayKy()));
					// word.put("[y_kien_cua_thu_truong_co_quan]",
					// xmForm.getKienDuyet());
					// word.put("[ngay_thu_truong_phe_duyet]",
					// Formater.getDateForPrint(xmForm.getNgayDuyet()));
					word.saveAndClose();
					word.downloadFile(fileOut, "Mau KN06", ".doc", response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					System.out.println("Download Error: " + ex.getMessage());
				}
			}
		}
		return null;
	}

	/**
	 * In quyet dinh xac minh
	 */
	public ActionForward in_old(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		XacMinhForm xmForm = (XacMinhForm) form;
		String maHs = xmForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			SoTiepDanService stdService = new SoTiepDanService();
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			KntcSoTiepDan std = stdService.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = std.getHdr();
			// KntcNdungDon don = std.getNoiDungDon();
			String fileTemplate = "kntc10";
			if (hdr.getLoaiKntc().intValue() == 2) {
				fileTemplate = "kntc22";
				parameters.put("ten_nguoi_bi_to_cao", dx.getNguoiBiKNTC());
				if (!Formater.isNull(dx.getChuDanhNguoiBiKNTC()))
					parameters.put("chuc_vu_nguoi_bi_to_cao", dx.getChuDanhNguoiBiKNTC());
				else
					parameters.put("chuc_vu_nguoi_bi_to_cao", "");

				parameters.put("hanh_vi_hanh_chinh", xmForm.getNguoiBiTcHanhVi());
			}
			parameters.put("tu_ngay", Formater.getDateForPrint(xmForm.getTuNgayXm()));
			parameters.put("den_ngay", Formater.getDateForPrint(xmForm.getDenNgayXm()));
			// String[] arr = arrDms.split(",");

			parameters.put("so_quyet_dinh", "S\u1ED1: " + xmForm.getSoQd());
			String ngayLap = "";
			if (Formater.isNull(xmForm.getThoiDiem())) {
				ngayLap = "ng\u00E0y   th\u00E1ng   n\u0103m        ";
				parameters.put("ngay_lap_quyet_dinh", xmForm.getDiaDiem() + ", " + ngayLap);
			} else
				parameters.put("ngay_lap_quyet_dinh", xmForm.getDiaDiem() + ", " + Formater.getDateForPrint(xmForm.getThoiDiem()));
			parameters.put("van_ban_quy_dinh_chuc_nang_nhiem_vu", CatalogService.getTenDanhMucById(xmForm.getCanCuVanBan()));

			parameters.put("truong_bo_phan", KtnbUtil.getTenTruongBoPhan(appContext) + " " + appContext.getTenPhong());
			parameters.put("chuc_danh_thu_truong_co_quan", KtnbUtil.getTenThuTruongCqt(appContext));
			parameters.put("co_quan_cap_tren_truc_tiep", KtnbUtil.getTenCqtCapTrenTt4P(appContext));
			parameters.put("co_quan_thue_ra_QD", appContext.getTenCqt().toUpperCase());
			parameters.put("nguoi_co_quan_don_vi_khieu_nai", dx.getNguoiKNTC());
			parameters.put("dia_chi_nguoi_co_quan_don_vi_khieu_nai", dx.getDcNguoiKNTC());
			parameters.put("don_de_ngay", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
			parameters.put("tom_tat_noi_dung_khieu_nai", "khi\u1EBFu n\u1EA1i");

			parameters.put("hanh_vi_cua_nguoi_bi_to_cao", xmForm.getNguoiBiTcHanhVi());
			parameters.put("giao_nhiem_vu_xac_minh", xmForm.getCanCuNhiemVu());

			parameters.put("thoi_gian_xac_minh", xmForm.getSoNgayXm());
			parameters.put("nguoi_co_quan_don_vi_co_lien_quan", xmForm.getBenLienQuan());
			parameters.put("thu_truong_co_quan_lien_quan", xmForm.getBenLienQuanThuTruong());
			parameters.put("noi_dung_xac_minh", xmForm.getNoiDung());
			parameters.put("tt_cqt", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()));
			// parameters.put("ten_thu_truong", appContext.getTenThuTruong());
			StringBuffer sb = new StringBuffer();
			String[] arrCb = xmForm.getArrCanBo().split("@@");
			try {
				int idx = 1;
				for (int i = 0; i < arrCb.length; i++) {
					String[] item = arrCb[i].split(",");
					if (item != null) {
						sb.append(idx + ". \u00D4ng (b\u00E0): " + item[1]);
						if (!Formater.isNull(item[3]))
							sb.append(", ch\u1EE9c v\u1EE5 " + item[3]);
						if (!Formater.isNull(item[4]))
							sb.append(", " + item[4]);
						if (i < arrCb.length - 1)
							sb.append(";<br>");
					}
					idx++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			parameters.put("thanh_vien_doan_xac_minh", sb.toString());
			parameters.put("y_kien_cua_truong_bo_phan", xmForm.getKienTrinh());
			parameters.put("ngay_truong_bo_phan_ky", Formater.getDateForPrint(xmForm.getNgayKy()));
			parameters.put("y_kien_cua_thu_truong_co_quan", xmForm.getKienDuyet());
			parameters.put("ngay_thu_truong_phe_duyet", Formater.getDateForPrint(xmForm.getNgayDuyet()));

			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
			KtnbUtil.printf(reportRows, fileTemplate, response, inputStream, parameters, null);
		}
		return null;
	}

	// In Bien ban lam viec!
	/**
	 * Des: inBbQdxm
	 */
	
	public ActionForward inBbQdxm (ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		SoTiepDanForm cnForm = (SoTiepDanForm) form;
		String maHs = cnForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			DungChungService service = new DungChungService();
			if ("4".equals(service.getVersionDonKntc(appContext, maHs)))
				inBbQdxmv4(map, form, request, response);
			else
				inBbQdxmv3(map, form, request, response);
			System.out.println("Ma HS : "+service.getVersionDonKntc(appContext, maHs));
		} else
			if("4".equals(Constants.APP_DEP_VERSION))
				inBbQdxmv4(map, form, request, response);
			else 
				inBbQdxmv3(map, form, request, response);
		return null;
	}
	
	/**
	 * 
	 * Des: ktnbv3
	 * 
	 */
	
	//v3
	
	public ActionForward inBbQdxmv3(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;

		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);

		KeHoachForm xmForm = (KeHoachForm) form;
		String maHs = xmForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			fileIn = request.getRealPath("/docin") + "\\KNTC12.doc";
			fileOut = request.getRealPath("/docout") + "\\KNTC12_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			word = new MsWordUtils(fileIn, fileOut);
			try {
				String gioHop = "";
				if (Formater.isNull(xmForm.getThoiDiem())) {
					gioHop = ".....gi\u1EDD.....ph\u00FAt ng\u00E0y.....th\u00E1ng....n\u0103m....";
				} else
					gioHop = Formater.getDateForPrint(xmForm.getThoiDiem());
				word.put("[Gio_hop]", gioHop);

				if (Formater.isNull(xmForm.getDiaDiem()))
					word.put("[Dia_diem_hop]", "...");
				else
					word.put("[Dia_diem_hop]", xmForm.getDiaDiem());

				if (Formater.isNull(xmForm.getThanhPhan())) {
					word.put("[Dai_dien]", "\t...");
				} else {
					String thanhPhanStr = "\t" + xmForm.getThanhPhan().replaceAll("\n", "\n\t");
					word.put("[Dai_dien]", thanhPhanStr);
				}

				if (Formater.isNull(xmForm.getNoiDung())) {
					word.put("[Noi_dung_lam_viec]", "...");
				} else {
					String noiDungLamViec = "\t" + xmForm.getNoiDung().replaceAll("\n", "\n\t");
					word.put("[Noi_dung_lam_viec]", noiDungLamViec);
				}

				if (Formater.isNull(xmForm.getSoBanIn()))
					word.put("[So_ban_in_ra]", "...");
				else
					word.put("[So_ban_in_ra]", xmForm.getSoBanIn());

				word.saveAndClose();
				word.downloadFile(fileOut, "Mau KNTC12", ".doc", response);
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
		return null;
	}
	
	/**
	 * Des: kntbv4
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	//v4
	public ActionForward inBbQdxmv4(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;

		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);

		KeHoachForm xmForm = (KeHoachForm) form;
		String maHs = xmForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			fileIn = request.getRealPath("/docin") + "\\KNTC12.doc";
			fileOut = request.getRealPath("/docout") + "\\KNTC12_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			word = new MsWordUtils(fileIn, fileOut);
			try {
				String gioHop = "";
				if (Formater.isNull(xmForm.getThoiDiem())) {
					gioHop = ".....gi\u1EDD.....ph\u00FAt ng\u00E0y.....th\u00E1ng....n\u0103m....";
				} else
					gioHop = Formater.getDateForPrint(xmForm.getThoiDiem());
				word.put("[Gio_hop]", gioHop);

				if (Formater.isNull(xmForm.getDiaDiem()))
					word.put("[Dia_diem_hop]", "...");
				else
					word.put("[Dia_diem_hop]", xmForm.getDiaDiem());

				if (Formater.isNull(xmForm.getThanhPhan())) {
					word.put("[Dai_dien]", "\t...");
				} else {
					String thanhPhanStr = "\t" + xmForm.getThanhPhan().replaceAll("\n", "\n\t");
					word.put("[Dai_dien]", thanhPhanStr);
				}

				if (Formater.isNull(xmForm.getNoiDung())) {
					word.put("[Noi_dung_lam_viec]", "...");
				} else {
					String noiDungLamViec = "\t" + xmForm.getNoiDung().replaceAll("\n", "\n\t");
					word.put("[Noi_dung_lam_viec]", noiDungLamViec);
				}

				if (Formater.isNull(xmForm.getSoBanIn()))
					word.put("[So_ban_in_ra]", "...");
				else
					word.put("[So_ban_in_ra]", xmForm.getSoBanIn());

				word.saveAndClose();
				word.downloadFile(fileOut, "Mau KNTC12", ".doc", response);
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
		return null;
	}

	// In Bien ban lam viec!
	public ActionForward inBbQdxm_old(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		KeHoachForm xmForm = (KeHoachForm) form;
		String maHs = xmForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			String fileTemplate = "kntc12";
			parameters.put("Gio_hop", Formater.getDateTimeForPrint(xmForm.getThoiDiem()));
			parameters.put("Dia_diem_hop", xmForm.getDiaDiem());
			parameters.put("chuc_danh_thu_truong_co_quan_thue", KtnbUtil.getTenThuTruongCqt(appContext));
			parameters.put("Dai_dien", xmForm.getThanhPhan());
			parameters.put("Noi_dung_lam_viec", xmForm.getNoiDung());
			parameters.put("So_ban_in_ra", xmForm.getSoBanIn());
			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
			KtnbUtil.printf(reportRows, fileTemplate, response, inputStream, parameters, null);
		}
		return null;
	}

	public ActionForward inBb25B_old(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		KeHoachForm xmForm = (KeHoachForm) form;
		String maHs = xmForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			String fileTemplate = "kntc25b";
			parameters.put("co_quan_cap_tren_truc_tiep", appContext.getTenCqt());
			parameters.put("don_vi_ban_giao_ho_so_vu_viec", appContext.getTenPhong());
			parameters.put("viec_giao_nhan_hoan_thanh_vao_luc", Formater.getDateTimeForPrint(xmForm.getThoiDiemHoanThanh()));
			parameters.put("dia_diem_ban_giao", xmForm.getDiaDiem());
			parameters.put("thoi_gian_ban_giao", Formater.getDateTimeForPrint(xmForm.getThoiDiem()));
			parameters.put("Dai_dien", xmForm.getThanhPhan());
			// parameters.put("chuc_danh_thu_truong_co_quan_thue",
			// KtnbUtil.getTenThuTruongCqt(appContext));
			// parameters.put("Dai_dien", xmForm.getThanhPhan());
			parameters.put("Noi_dung_lam_viec", xmForm.getNoiDung());
			parameters.put("So_ban_in_ra", xmForm.getSoBanIn());
			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
			KtnbUtil.printf(reportRows, fileTemplate, response, inputStream, parameters, null);
		}
		return null;
	}

	public ActionForward inBb25B(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		KeHoachForm xmForm = (KeHoachForm) form;
		String maHs = xmForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			fileIn = request.getRealPath("/docin") + "\\KNTC25B.doc";
			fileOut = request.getRealPath("/docout") + "\\KNTC25B_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			word = new MsWordUtils(fileIn, fileOut);
			try {
				word.put("[co_quan_thue_truc_tiep]", appContext.getTenCqt());
				word.put("[don_vi_viet_giay_bien_nhan]", appContext.getTenPhong());
				word.put("[thoi_gian_ban_giao]", Formater.getDateTimeForPrint(xmForm.getThoiDiem()));
				word.put("[dia_diem_ban_giao]", xmForm.getDiaDiem());
				word.put("[Dai_dien_1]", xmForm.getDaiDien());
				word.put("[Dai_dien_2]", xmForm.getThanhPhan());
				word.put("[don_vi_ban_giao_ho_so_vu_viec]", xmForm.getDaiDien());
				word.put("[co_quan_dieu_tra]", xmForm.getThanhPhan());
				word.put("[don_vi_ban_giao_ho_so_vu_viec]", xmForm.getDaiDien());
				word.put("[Noi_dung_lam_viec]", "+ " + xmForm.getSoTrangTl().toString() + " trang tài liệu và " + xmForm.getSoBangChung().toString()
						+ "bằng chứng khác (chi tiết tên tài liệu, bằng chứng và tình trạng của tài liệu bằng chứng có mục lục kèm theo).");
				word.put("[viec_giao_nhan_hoan_thanh_vao_luc]", Formater.getDateTimeForPrint(xmForm.getThoiDiemHoanThanh()));
				word.saveAndClose();

				word.downloadFile(fileOut, "Mau KNTC25B", ".doc", response);
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
		return null;
	}

	public ActionForward inKhXm_old(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		KeHoachForm xmForm = (KeHoachForm) form;
		String maHs = xmForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			SoTiepDanService stdService = new SoTiepDanService();
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			KntcSoTiepDan std = stdService.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = std.getHdr();
			String fileTemplate = "kntc11";
			// String arrDms = xmForm.getArrDm();
			// String[] arr = arrDms.split(",");
			// StringBuffer sb = new StringBuffer();

			// parameters.put("so_quyet_dinh", xmForm.);
			String ngayLap = "";
			if (Formater.isNull(xmForm.getThoiDiem())) {
				ngayLap = "ng\u00E0y   th\u00E1ng   n\u0103m        ";
				parameters.put("ngay_lap_ke_hoach", xmForm.getDiaDiem() + ", " + ngayLap);
			} else
				parameters.put("ngay_lap_ke_hoach", xmForm.getDiaDiem() + ", " + Formater.getDateForPrint(xmForm.getThoiDiem()));
			// parameters.put("can_cu_phap_ly_tien_hanh_xac_minh",
			// CatalogService.getTenDanhMucById(xmForm.getCanCuPhapLy()));
			parameters.put("can_cu_phap_ly_tien_hanh_xac_minh", xmForm.getCanCuPhapLy());

			parameters.put("chuc_danh_thu_truong_co_quan_thue", KtnbUtil.getTenThuTruongCqt(appContext));

			parameters.put("co_quan_cap_tren_truc_tiep", appContext.getTenCqt());
			parameters.put("bo_phan_duoc_giao_xu_ly", appContext.getTenPhong());
			parameters.put("nguoi_co_quan_don_vi_khieu_nai", dx.getNguoiKNTC());
			parameters.put("dia_chi_nguoi_khieu_nai]", hdr.getNndDiaChi());
			if (!Formater.isNull(dx.getDcNguoiKNTC()))
				parameters.put("dia_chi_nguoi_co_quan_don_vi_khieu_nai", "\u0110\u1ECBa ch\u1EC9: " + dx.getDcNguoiKNTC());
			// KntcNdungDon don = std.getNoiDungDon();
			parameters.put("don_de_ngay", Formater.getDateForPrint(Formater.date2str(std.getHdr().getDonDeNgay())));
			parameters.put("muc_dich_yeu_cau_cua_viec_xac_minh", xmForm.getMucDich());

			parameters.put("dieu_kien_phuong_tien_phuc_vu_xac_minh", xmForm.getPhuongTien());

			parameters.put("nguoi_co_quan_lam_viec_thu_thap_chung_cu", xmForm.getBenLienQuan());
			parameters.put("tai_lieu_bang_chung", xmForm.getBangChung());

			// Lay thong tin danh muc kem theo
			// String arrDms = xmForm.getArrDm();
			// String[] arr = arrDms.split(",");
			// for (int i = 0; i < arr.length; i++) {
			// if (!Formater.isNull(arr[i])) {
			// sb.append("+ " + CatalogService.getTenDanhMucById(arr[i]));
			// sb.append("\n");
			// }
			// }
			parameters.put("ten_bo_phan", appContext.getTenPhong());
			parameters.put("tt_cqt", appContext.getTenCqt());
			// parameters.put("ten_thu_truong", appContext.getTenThuTruong());
			parameters.put("ten_truong_bo_phan", appContext.getTenTruongPhong());
			parameters.put("noi_dung_can_xac_minh", xmForm.getNoiDung());
			// parameters.put("y_kien_cua_truong_bo_phan",
			// xmForm.getKienTrinh());
			// if (xmForm.getDiaDiem().equals("") ||
			// xmForm.getNgayKy().equals("")) {
			// parameters.put("ngay_truong_bo_phan_ky",
			// "...,ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			// } else {
			// parameters.put("ngay_truong_bo_phan_ky", xmForm.getDiaDiem() + ",
			// " + Formater.getDateForPrint(xmForm.getNgayKy()));
			// }
			//
			// parameters.put("y_kien_cua_thu_truong_co_quan_thue",
			// xmForm.getKienDuyet());
			// if (xmForm.getDiaDiem().equals("") ||
			// xmForm.getNgayDuyet().equals("")) {
			// parameters.put("ngay_thu_truong_phe_duyet",
			// "...,ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			// } else {
			// parameters.put("ngay_thu_truong_phe_duyet", xmForm.getDiaDiem() +
			// ", " + Formater.getDateForPrint(xmForm.getNgayDuyet()));
			// }
			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
			KtnbUtil.printf(reportRows, fileTemplate, response, inputStream, parameters, null);
		}
		return null;
	}

	/**
	 * Download file mẫu KNTC11
	 * 
	 * @throws Exception
	 */
	public ActionForward inKhXm(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileIn = request.getRealPath("\\docin\\KNTC11.doc");
		String fileOut = request.getRealPath("\\docout\\KNTC11_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc");

		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// HashMap[] reportRows = null;
		// Map parameters = new HashMap();
		// KeHoachForm xmForm = (KeHoachForm) request.getAttribute("khxmForm");
		KeHoachForm xmForm = (KeHoachForm) form;
		String maHs = xmForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			SoTiepDanService stdService = new SoTiepDanService();
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			KntcSoTiepDan std = stdService.getSoTiepDan(appContext, maHs, true);
			// KntcHoSoHdr hdr = std.getHdr();
			// String fileTemplate = "kntc11";

			MsWordUtils word = new MsWordUtils(fileIn, fileOut);
			// String arrDms = xmForm.getArrDm();
			// String[] arr = arrDms.split(",");
			// StringBuffer sb = new StringBuffer();
			try {
				// parameters.put("so_quyet_dinh", xmForm.);
				word.put("[co_quan_cap_tren_truc_tiep]", appContext.getTenCqt().toUpperCase());
				word.put("[bo_phan_duoc_giao_xu_ly]", appContext.getTenPhong().toUpperCase());
				String ngayLap = "";
				if (Formater.isNull(xmForm.getThoiDiem())) {
					ngayLap = "ng\u00E0y......th\u00E1ng......n\u0103m.......";
				} else
					ngayLap = Formater.getDateForPrint(xmForm.getThoiDiem());
				if (Formater.isNull(xmForm.getDiaDiem())) {
					word.put("[ngay_lap_ke_hoach]", "......, " + ngayLap);
				} else
					word.put("[ngay_lap_ke_hoach]", xmForm.getDiaDiem() + ", " + ngayLap);
				// parameters.put("can_cu_phap_ly_tien_hanh_xac_minh",
				// CatalogService.getTenDanhMucById(xmForm.getCanCuPhapLy()));
				word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
				if (!Formater.isNull(dx.getDcNguoiKNTC()))
					word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", "\u0110\u1ECBa ch\u1EC9: " + dx.getDcNguoiKNTC());
				else
					word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", "\u0110\u1ECBa ch\u1EC9: " + KtnbUtil.inFieldNull(104));
				word.put("[chuc_danh_thu_truong_co_quan_thue]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
				word.put("[chuc_danh_thu_truong_co_quan_thue]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
				// if (xmForm.getDiaDiem().equals("") ||
				// xmForm.getNgayKy().equals("")) {
				// word.put("[ngay_truong_bo_phan_ky]", ".....,
				// ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				// } else {
				// word.put("[ngay_truong_bo_phan_ky]", xmForm.getDiaDiem() + ",
				// " + Formater.getDateForPrint(xmForm.getNgayKy()));
				// }
				word.put("[ten_bo_phan]", appContext.getTenPhong());
				word.put("[ten_truong_bo_phan]", appContext.getTenTruongPhong());
				// if(Formater.isNull(xmForm.getKienDuyet()))
				// word.put("[y_kien_cua_thu_truong_co_quan_thue]",
				// KtnbUtil.inFieldNull(63));
				// else
				// word.put("[y_kien_cua_thu_truong_co_quan_thue]",
				// xmForm.getKienDuyet());
				// if (xmForm.getDiaDiem().equals("") ||
				// xmForm.getNgayDuyet().equals("")) {
				// word.put("[ngay_thu_truong_phe_duyet]", ".....,
				// ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				// } else {
				// word.put("[ngay_thu_truong_phe_duyet]", xmForm.getDiaDiem() +
				// ", " + Formater.getDateForPrint(xmForm.getNgayDuyet()));
				// }
				word.put("[tt_cqt]", appContext.getTenCqt());
				// word.put("[ten_thu_truong]", appContext.getTenThuTruong());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau KNTC11", ".doc", response);
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
		return null;
	}
	
	/**
	 * Des: inGhXm
	 */
	
	public ActionForward inGhXm(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		GiaHanXmForm xmForm=(GiaHanXmForm) form;
		String maHs = xmForm.getMaHoSo();
		System.out.println("Ma ho so  : "+maHs);
		if (!Formater.isNull(maHs)) {
			DungChungService service = new DungChungService();
			if ("4".equals(service.getVersionDonKntc(appContext, maHs)))
				inGhXmv4(map, form, request, response);
			else
				inGhXmv3(map, form, request, response);
			System.out.println("Ma HS : "+service.getVersionDonKntc(appContext, maHs));
		} else
			if("4".equals(Constants.APP_DEP_VERSION))
				inGhXmv4(map, form, request, response);
			else 
				inGhXmv3(map, form, request, response);
		return null;
	}

	/**
	 * Download file mẫu KNTC16
	 * Des: ktnbv3
	 * @throws Exception
	 */
	
	public ActionForward inGhXmv3(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(request.getParameter("type"));
		if("TC16".equals(request.getParameter("type")))
		{
			String fileIn = request.getRealPath("/docin") + "\\TC16.doc";
			String fileOut = request.getRealPath("/docout") + "\\TC16_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
			HashMap[] reportRows = null;
			Map parameters = new HashMap();
			GiaHanXmForm xmForm = (GiaHanXmForm) form;
			String maQdXm = xmForm.getCanCuQd();
			XacMinhService s = new XacMinhService();
			KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, xmForm.getMaHoSo());
			if (!Formater.isNull(maQdXm)) {
				XacMinhService xmService = new XacMinhService();
				KntcQdinhXm qdXm = xmService.getKntcQdinhXmByHoSo(appContext, xmForm.getMaHoSo());
				// SoTiepDanService stdService = new SoTiepDanService();
				PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
				KntcDeXuatXly dx = plService.getDeXuatXly(appContext, qdXm.getMaHs());
				// KntcSoTiepDan std = stdService.getSoTiepDan(appContext,
				// qdXm.getMaHs(), true);
				String fileTemplate = "kntc16";

				MsWordUtils word = new MsWordUtils(fileIn, fileOut);
				try {
					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_quyet_dinh]", appContext.getTenCqt().toUpperCase());
					word.put("[so_quyet_dinh]", xmForm.getSoPhieu());
					if (xmForm.getDiaDiem().equals("") || xmForm.getNgayLap().equals("")) {
						word.put("[ngay_lap_quyet_dinh]", "...,ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
					} else {
						word.put("[ngay_lap_quyet_dinh]", xmForm.getDiaDiem() + ", " + Formater.getDateForPrint(xmForm.getNgayLap()));
					}
					word.put("[chuc_danh_thu_truong_co_quan_thue_ra_quyet_dinh]", KtnbUtil.getTenThuTruongCqtForMauin(appContext).toUpperCase());
					word.put("[van_ban_quy_dinh_chuc_nang_nhiem_vu]", CatalogService.getTenDanhMucById(xmForm.getCanCuVb()));
					word.put("[so_quyet_dinh_xm]", xmForm.getCanCuQd());
					word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(xmForm.getNgayKThucXM()));
					word.put("[chuc_danh_thu_truong_co_quan_thue_ra_quyet_dinh]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));

					if (Formater.isNull(dx.getNguoiBiKNTC())) {
						word.put("[ten_nguoi_bi_khieu_nai]", "");
					} else {
						word.put("[ten_nguoi_bi_khieu_nai]", dx.getNguoiBiKNTC());
					}
					word.put("[nguoi_de_nghi_gia_han]", "Truong doan to chuc xac minh to cao");
					if (Formater.isNull(dx.getNguoiBiKNTC())) {
						word.put("[don_vi_bi_to_cao]", "");
					} else {
						word.put("[don_vi_bi_to_cao]", dx.getNguoiBiKNTC());
					}
					if(Formater.isNull(qdXm.getNoiDungXm()))
						word.put("[tom_tat_noi_dung]", "");
					else 
						word.put("[tom_tat_noi_dung]", qdXm.getNoiDungXm());
					word.put("[can_cu_quyet_dinh_so]", xmForm.getCanCuQd());
//					word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(Formater.date2str(qd.getNgayLap())));
//					word.put("[chuc_danh_thu_truong_co_quan_thue_ra_quyet_dinh]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));

					// if (Formater.isNull(dx.getChuDanhNguoiBiKNTC())) {
					// word.put("[chuc_vu]", "");
					// } else {
					// word.put("[chuc_vu]", dx.getChuDanhNguoiBiKNTC());
					// }

					if (Formater.isNull(xmForm.getSoNgayGH())) {
						word.put("[thoi_gian_gia_han]", "");
					} else {
						word.put("[thoi_gian_gia_han]", xmForm.getSoNgayGH());
					}
					word.put("[tu_ngay]", Formater.getDateForPrint(xmForm.getGiaHanTuNgay()));
					//word.put("[den_ngay]", Formater.getDateForPrint(xmForm.getGiaHanDenNgay()));
//					if (Formater.isNull(dx.getNguoiBiKNTC())) {
//						word.put("[ten_nguoi_bi_khieu_nai]", "");
//					} else {
//						word.put("[ten_nguoi_bi_khieu_nai]", dx.getNguoiBiKNTC());
//					}
//					// Loc code
//					if (Formater.isNull(qdXm.getBenLienQuanTt())) {
//						word.put("[thu_truong_co_quan_don_vi_lien_quan]", "");
//					} else {
//						word.put("[thu_truong_co_quan_don_vi_lien_quan]", qdXm.getBenLienQuanTt());
//					}
//					if (Formater.isNull(qdXm.getBenLienQuan())) {
//						word.put("[ca_nhan_to_chuc_lien_quan]", "");
//					} else {
//						word.put("[ca_nhan_to_chuc_lien_quan]", qdXm.getBenLienQuan());
//					}
					word.put("[don_vi_chiu_trach_nhiem]", "Truong doan to chuc to cao");
					
					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]", appContext.getTenThuTruong());

					word.saveAndClose();
					word.downloadFile(fileOut, "Mau 16//TC", ".doc", response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					System.out.println("Download Error: " + ex.getMessage());
				} finally {
					try {
						word.saveAndClose();
					} catch (Exception ex) {
					}
				}
				// InputStream inputStream =
				// getServlet().getServletContext().getResourceAsStream("/report/" +
				// fileTemplate + ".jasper");
				// KtnbUtil.printf(reportRows, fileTemplate, response, inputStream,
				// parameters, null);
			}
			return null;
		}
		else 
		{
			String fileIn = request.getRealPath("/docin") + "\\KNTC16.doc";
			String fileOut = request.getRealPath("/docout") + "\\KNTC16_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
			HashMap[] reportRows = null;
			Map parameters = new HashMap();
			GiaHanXmForm xmForm = (GiaHanXmForm) form;
			String maQdXm = xmForm.getCanCuQd();
			XacMinhService s = new XacMinhService();
			KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, xmForm.getMaHoSo());
			if (!Formater.isNull(maQdXm)) {
				XacMinhService xmService = new XacMinhService();
				KntcQdinhXm qdXm = xmService.getKntcQdinhXmByHoSo(appContext, xmForm.getMaHoSo());
				// SoTiepDanService stdService = new SoTiepDanService();
				PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
				KntcDeXuatXly dx = plService.getDeXuatXly(appContext, qdXm.getMaHs());
				// KntcSoTiepDan std = stdService.getSoTiepDan(appContext,
				// qdXm.getMaHs(), true);
				String fileTemplate = "kntc16";

				MsWordUtils word = new MsWordUtils(fileIn, fileOut);
				try {
					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_quyet_dinh]", appContext.getTenCqt().toUpperCase());
					word.put("[so_quyet_dinh]", xmForm.getSoPhieu());
					if (xmForm.getDiaDiem().equals("") || xmForm.getNgayLap().equals("")) {
						word.put("[ngay_lap_quyet_dinh]", "...,ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
					} else {
						word.put("[ngay_lap_quyet_dinh]", xmForm.getDiaDiem() + ", " + Formater.getDateForPrint(xmForm.getNgayLap()));
					}
					word.put("[chuc_danh_thu_truong_co_quan_thue_ra_quyet_dinh]", KtnbUtil.getTenThuTruongCqtForMauin(appContext).toUpperCase());
					word.put("[van_ban_quy_dinh_chuc_nang_nhiem_vu]", CatalogService.getTenDanhMucById(xmForm.getCanCuVb()));
					word.put("[so_quyet_dinh_xm]", xmForm.getCanCuQd());
					word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(xmForm.getNgayKThucXM()));
					word.put("[chuc_danh_thu_truong_co_quan_thue_ra_quyet_dinh]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));

					if (Formater.isNull(dx.getNguoiBiKNTC())) {
						word.put("[ten_nguoi_bi_khieu_nai]", "");
					} else {
						word.put("[ten_nguoi_bi_khieu_nai]", dx.getNguoiBiKNTC());
					}
					word.put("[can_cu_quyet_dinh_so]", xmForm.getCanCuQd());
					word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(Formater.date2str(qd.getNgayLap())));
					word.put("[chuc_danh_thu_truong_co_quan_thue_ra_quyet_dinh]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));

					// if (Formater.isNull(dx.getChuDanhNguoiBiKNTC())) {
					// word.put("[chuc_vu]", "");
					// } else {
					// word.put("[chuc_vu]", dx.getChuDanhNguoiBiKNTC());
					// }

					if (Formater.isNull(xmForm.getSoNgayGH())) {
						word.put("[thoi_gian_gia_han]", "");
					} else {
						word.put("[thoi_gian_gia_han]", xmForm.getSoNgayGH());
					}
					word.put("[tu_ngay]", Formater.getDateForPrint(xmForm.getGiaHanTuNgay()));
					word.put("[den_ngay]", Formater.getDateForPrint(xmForm.getGiaHanDenNgay()));
					if (Formater.isNull(dx.getNguoiBiKNTC())) {
						word.put("[ten_nguoi_bi_khieu_nai]", "");
					} else {
						word.put("[ten_nguoi_bi_khieu_nai]", dx.getNguoiBiKNTC());
					}
					// Loc code
					if (Formater.isNull(qdXm.getBenLienQuanTt())) {
						word.put("[thu_truong_co_quan_don_vi_lien_quan]", "");
					} else {
						word.put("[thu_truong_co_quan_don_vi_lien_quan]", qdXm.getBenLienQuanTt());
					}
					if (Formater.isNull(qdXm.getBenLienQuan())) {
						word.put("[ca_nhan_to_chuc_lien_quan]", "");
					} else {
						word.put("[ca_nhan_to_chuc_lien_quan]", qdXm.getBenLienQuan());
					}
					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]", appContext.getTenThuTruong());

					word.saveAndClose();
					word.downloadFile(fileOut, "Mau KNTC16", ".doc", response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					System.out.println("Download Error: " + ex.getMessage());
				} finally {
					try {
						word.saveAndClose();
					} catch (Exception ex) {
					}
				}
				// InputStream inputStream =
				// getServlet().getServletContext().getResourceAsStream("/report/" +
				// fileTemplate + ".jasper");
				// KtnbUtil.printf(reportRows, fileTemplate, response, inputStream,
				// parameters, null);
			}
			return null;
		}
	}
	
	/**
	 * Des: ktnbv4
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	//v4
	public ActionForward inGhXmv4(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(request.getParameter("type"));
		if("TC16".equals(request.getParameter("type")))
		{
			String fileIn = request.getRealPath("/docin") + "\\TC16.doc";
			String fileOut = request.getRealPath("/docout") + "\\TC16_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
			HashMap[] reportRows = null;
			Map parameters = new HashMap();
			GiaHanXmForm xmForm = (GiaHanXmForm) form;
			String maQdXm = xmForm.getCanCuQd();
			XacMinhService s = new XacMinhService();
			KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, xmForm.getMaHoSo());
			if (!Formater.isNull(maQdXm)) {
				XacMinhService xmService = new XacMinhService();
				KntcQdinhXm qdXm = xmService.getKntcQdinhXmByHoSo(appContext, xmForm.getMaHoSo());
				// SoTiepDanService stdService = new SoTiepDanService();
				PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
				KntcDeXuatXly dx = plService.getDeXuatXly(appContext, qdXm.getMaHs());
				// KntcSoTiepDan std = stdService.getSoTiepDan(appContext,
				// qdXm.getMaHs(), true);
				String fileTemplate = "kntc16";

				MsWordUtils word = new MsWordUtils(fileIn, fileOut);
				try {
					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_quyet_dinh]", appContext.getTenCqt().toUpperCase());
					word.put("[so_quyet_dinh]", xmForm.getSoPhieu());
					if (xmForm.getDiaDiem().equals("") || xmForm.getNgayLap().equals("")) {
						word.put("[ngay_lap_quyet_dinh]", "...,ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
					} else {
						word.put("[ngay_lap_quyet_dinh]", xmForm.getDiaDiem() + ", " + Formater.getDateForPrint(xmForm.getNgayLap()));
					}
					word.put("[chuc_danh_thu_truong_co_quan_thue_ra_quyet_dinh]", KtnbUtil.getTenThuTruongCqtForMauin(appContext).toUpperCase());
					word.put("[van_ban_quy_dinh_chuc_nang_nhiem_vu]", CatalogService.getTenDanhMucById(xmForm.getCanCuVb()));
					word.put("[so_quyet_dinh_xm]", xmForm.getCanCuQd());
					word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(xmForm.getNgayKThucXM()));
					word.put("[chuc_danh_thu_truong_co_quan_thue_ra_quyet_dinh]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));

					if (Formater.isNull(dx.getNguoiBiKNTC())) {
						word.put("[ten_nguoi_bi_khieu_nai]", "");
					} else {
						word.put("[ten_nguoi_bi_khieu_nai]", dx.getNguoiBiKNTC());
					}
					word.put("[nguoi_de_nghi_gia_han]", "Truong doan to chuc xac minh to cao");
					if (Formater.isNull(dx.getNguoiBiKNTC())) {
						word.put("[don_vi_bi_to_cao]", "");
					} else {
						word.put("[don_vi_bi_to_cao]", dx.getNguoiBiKNTC());
					}
					if(Formater.isNull(qdXm.getNoiDungXm()))
						word.put("[tom_tat_noi_dung]", "");
					else 
						word.put("[tom_tat_noi_dung]", qdXm.getNoiDungXm());
					word.put("[can_cu_quyet_dinh_so]", xmForm.getCanCuQd());
//					word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(Formater.date2str(qd.getNgayLap())));
//					word.put("[chuc_danh_thu_truong_co_quan_thue_ra_quyet_dinh]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));

					// if (Formater.isNull(dx.getChuDanhNguoiBiKNTC())) {
					// word.put("[chuc_vu]", "");
					// } else {
					// word.put("[chuc_vu]", dx.getChuDanhNguoiBiKNTC());
					// }

					if (Formater.isNull(xmForm.getSoNgayGH())) {
						word.put("[thoi_gian_gia_han]", "");
					} else {
						word.put("[thoi_gian_gia_han]", xmForm.getSoNgayGH());
					}
					word.put("[tu_ngay]", Formater.getDateForPrint(xmForm.getGiaHanTuNgay()));
					//word.put("[den_ngay]", Formater.getDateForPrint(xmForm.getGiaHanDenNgay()));
//					if (Formater.isNull(dx.getNguoiBiKNTC())) {
//						word.put("[ten_nguoi_bi_khieu_nai]", "");
//					} else {
//						word.put("[ten_nguoi_bi_khieu_nai]", dx.getNguoiBiKNTC());
//					}
//					// Loc code
//					if (Formater.isNull(qdXm.getBenLienQuanTt())) {
//						word.put("[thu_truong_co_quan_don_vi_lien_quan]", "");
//					} else {
//						word.put("[thu_truong_co_quan_don_vi_lien_quan]", qdXm.getBenLienQuanTt());
//					}
//					if (Formater.isNull(qdXm.getBenLienQuan())) {
//						word.put("[ca_nhan_to_chuc_lien_quan]", "");
//					} else {
//						word.put("[ca_nhan_to_chuc_lien_quan]", qdXm.getBenLienQuan());
//					}
					word.put("[don_vi_chiu_trach_nhiem]", "Truong doan to chuc to cao");
					
					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]", appContext.getTenThuTruong());

					word.saveAndClose();
					word.downloadFile(fileOut, "Mau 16//TC", ".doc", response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					System.out.println("Download Error: " + ex.getMessage());
				} finally {
					try {
						word.saveAndClose();
					} catch (Exception ex) {
					}
				}
				// InputStream inputStream =
				// getServlet().getServletContext().getResourceAsStream("/report/" +
				// fileTemplate + ".jasper");
				// KtnbUtil.printf(reportRows, fileTemplate, response, inputStream,
				// parameters, null);
			}
			return null;
		}
		else 
		{
			String fileIn = request.getRealPath("/docin/v4/kntc") + "\\KN14.doc";
			String fileOut = request.getRealPath("/docout") + "\\KN14_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
			HashMap[] reportRows = null;
			Map parameters = new HashMap();
			GiaHanXmForm xmForm = (GiaHanXmForm) form;
			String maQdXm = xmForm.getCanCuQd();
			XacMinhService s = new XacMinhService();
			KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, xmForm.getMaHoSo());
			if (!Formater.isNull(maQdXm)) {
				XacMinhService xmService = new XacMinhService();
				KntcQdinhXm qdXm = xmService.getKntcQdinhXmByHoSo(appContext, xmForm.getMaHoSo());
				SoTiepDanService stdService = new SoTiepDanService();
				PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
				KntcDeXuatXly dx = plService.getDeXuatXly(appContext, qdXm.getMaHs());
				KntcSoTiepDan std = stdService.getSoTiepDan(appContext, qdXm.getMaHs (), true);		
				//KntcSoTiepDan std = stdService.getSoTiepDan(appContext, maHs, true);
				KntcHoSoHdr hdr = std.getHdr();
				String fileTemplate = "kn14";

				MsWordUtils word = new MsWordUtils(fileIn, fileOut);
				try {
					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_quyet_dinh]", appContext.getTenCqt().toUpperCase());
					word.put("[so_quyet_dinh]", xmForm.getSoPhieu());
					if (xmForm.getDiaDiem().equals("") || xmForm.getNgayLap().equals("")) {
						word.put("[ngay_lap_quyet_dinh]", "...,ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
					} else {
						word.put("[ngay_lap_quyet_dinh]", xmForm.getDiaDiem() + ", " + Formater.getDateForPrint(xmForm.getNgayLap()));
					}
					word.put("[chuc_danh_thu_truong_co_quan_thue_ra_quyet_dinh]", KtnbUtil.getTenThuTruongCqtForMauin(appContext).toUpperCase());
					word.put("[van_ban_quy_dinh_chuc_nang_nhiem_vu]", CatalogService.getTenDanhMucById(xmForm.getCanCuVb()));
					word.put("[so_quyet_dinh_xm]", xmForm.getCanCuQd());
					word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(xmForm.getNgayKThucXM()));
					word.put("[ten_nguoi_khieu_nai]", dx.getNguoiKNTC()); 
					word.put("[dia_chi_nguoi_khieu_nai]", hdr.getNndDiaChi()); 
					if (Formater.isNull(dx.getNguoiBiKNTC())) {
						word.put("[ten_nguoi_bi_khieu_nai]", "");
					} else {
						word.put("[ten_nguoi_bi_khieu_nai]", dx.getNguoiBiKNTC());
					}
					word.put("[can_cu_quyet_dinh_so]", xmForm.getCanCuQd());
					word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(Formater.date2str(qd.getNgayLap())));
					word.put("[chuc_danh_thu_truong_co_quan_thue_ra_quyet_dinh]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));

					// if (Formater.isNull(dx.getChuDanhNguoiBiKNTC())) {
					// word.put("[chuc_vu]", "");
					// } else {
					// word.put("[chuc_vu]", dx.getChuDanhNguoiBiKNTC());
					// }

					if (Formater.isNull(xmForm.getSoNgayGH())) {
						word.put("[thoi_gian_gia_han]", "");
					} else {
						word.put("[thoi_gian_gia_han]", xmForm.getSoNgayGH());
					}
					word.put("[tu_ngay]", Formater.getDateForPrint(xmForm.getGiaHanTuNgay()));
					word.put("[den_ngay]", Formater.getDateForPrint(xmForm.getGiaHanDenNgay()));
					if (Formater.isNull(dx.getNguoiBiKNTC())) {
						word.put("[ten_nguoi_bi_khieu_nai]", "");
					} else {
						word.put("[ten_nguoi_bi_khieu_nai]", dx.getNguoiBiKNTC());
					}
					// Loc code
					if (Formater.isNull(qdXm.getBenLienQuanTt())) {
						word.put("[thu_truong_co_quan_don_vi_lien_quan]", "");
					} else {
						word.put("[thu_truong_co_quan_don_vi_lien_quan]", qdXm.getBenLienQuanTt());
					}
					if (Formater.isNull(qdXm.getBenLienQuan())) {
						word.put("[ca_nhan_to_chuc_lien_quan]", "");
					} else {
						word.put("[ca_nhan_to_chuc_lien_quan]", qdXm.getBenLienQuan());
					}
					word.put("[ten_nguoi_khieu_nai]", dx.getNguoiKNTC());
					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]", appContext.getTenThuTruong());

					word.saveAndClose();
					word.downloadFile(fileOut, "Mau KN14", ".doc", response);
				} catch (Exception ex) {
					// ex.printStackTrace();
					System.out.println("Download Error: " + ex.getMessage());
				} finally {
					try {
						word.saveAndClose();
					} catch (Exception ex) {
					}
				}
				// InputStream inputStream =
				// getServlet().getServletContext().getResourceAsStream("/report/" +
				// fileTemplate + ".jasper");
				// KtnbUtil.printf(reportRows, fileTemplate, response, inputStream,
				// parameters, null);
			}
			return null;
		}
	}

	
	public ActionForward inGhXm_old(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		GiaHanXmForm xmForm = (GiaHanXmForm) form;
		String maQdXm = xmForm.getCanCuQd();
		if (!Formater.isNull(maQdXm)) {
			XacMinhService xmService = new XacMinhService();
			KntcQdinhXm qdXm = xmService.getKntcQdinhXmByHoSo(appContext, xmForm.getMaHoSo());
			// SoTiepDanService stdService = new SoTiepDanService();
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, qdXm.getMaHs());
			// KntcSoTiepDan std = stdService.getSoTiepDan(appContext,
			// qdXm.getMaHs(), true);

			String fileTemplate = "kn14";
			//
			if (xmForm.getDiaDiem().equals("") || xmForm.getNgayLap().equals("")) {
				parameters.put("ngay_lap_quyet_dinh", "...,ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			} else {
				parameters.put("ngay_lap_quyet_dinh", xmForm.getDiaDiem() + ", " + Formater.getDateForPrint(xmForm.getNgayLap()));
			}
			//
			parameters.put("van_ban_quy_dinh_chuc_nang_nhiem_vu", CatalogService.getTenDanhMucById(xmForm.getCanCuVb()));
			parameters.put("chuc_danh_thu_truong_co_quan_thue_ra_quyet_dinh", KtnbUtil.getTenThuTruongCqt(appContext));
			parameters.put("co_quan_cap_tren_truc_tiep", KtnbUtil.getTenCqtCapTrenTt4P(appContext));
			parameters.put("co_quan_thue_ra_quyet_dinh", appContext.getTenCqt());
			parameters.put("so_quyet_dinh", xmForm.getSoPhieu());
			parameters.put("so_quyet_dinh_xm", xmForm.getCanCuQd());
			if (Formater.isNull(dx.getNguoiBiKNTC())) {
				parameters.put("ten_nguoi_bi_khieu_nai", "");
			} else {
				parameters.put("ten_nguoi_bi_khieu_nai", dx.getNguoiBiKNTC());
			}
			if (Formater.isNull(dx.getChuDanhNguoiBiKNTC())) {
				parameters.put("chuc_vu", "");
			} else {
				parameters.put("chuc_vu", dx.getChuDanhNguoiBiKNTC());
			}

			parameters.put("can_cu_quyet_dinh_so", xmForm.getCanCuQd());

			parameters.put("ngay_ra_quyet_dinh", Formater.getDateForPrint(xmForm.getNgayKThucXM()));

			parameters.put("tu_ngay", Formater.getDateForPrint(xmForm.getGiaHanTuNgay()));
			parameters.put("den_ngay", Formater.getDateForPrint(xmForm.getGiaHanDenNgay()));
			parameters.put("tt_cqt", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()));
			// parameters.put("ten_thu_truong", appContext.getTenThuTruong());
			// Loc code
			if (Formater.isNull(qdXm.getBenLienQuanTt())) {
				parameters.put("thu_truong_co_quan_don_vi_lien_quan", "");
			} else {
				parameters.put("thu_truong_co_quan_don_vi_lien_quan", qdXm.getBenLienQuanTt());
			}
			if (Formater.isNull(qdXm.getBenLienQuan())) {
				parameters.put("ca_nhan_to_chuc_lien_quan", "");
			} else {
				parameters.put("ca_nhan_to_chuc_lien_quan", qdXm.getBenLienQuan());
			}
			if (Formater.isNull(xmForm.getSoNgayGH())) {
				parameters.put("Thoi_gian_gia_han", "");
			} else {
				parameters.put("thoi_gian_gia_han", xmForm.getSoNgayGH());
			}

			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
			KtnbUtil.printf(reportRows, fileTemplate, response, inputStream, parameters, null);
		}
		return null;
	}

	public ActionForward inBbKqXm(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		Map parameters = new HashMap();
		XacMinhForm dxForm = (XacMinhForm) form;
		String maHs = dxForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			SoTiepDanService stdService = new SoTiepDanService();
			KntcSoTiepDan std = stdService.getSoTiepDan(appContext, maHs, true);
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			KntcHoSoHdr hdr = std.getHdr();
			String fileTemplate = "kntc17";

			parameters.put("co_quan_ra_quyet_dinh_xac_minh", appContext.getTenCqt());
			parameters.put("doan_xac_minh_qd_so", dxForm.getSoQd());
			parameters.put("ngay_lap_quyet_dinh", dxForm.getThoiDiem());
			parameters.put("chuc_danh_nguoi_ra_quyet_dinh_xac_minh", KtnbUtil.getTenThuTruongCqt(appContext));
			parameters.put("so_quyet_dinh", dxForm.getSoQd());

			XacMinhService s = new XacMinhService();
			KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, dxForm.getMaHoSo());
			parameters.put("tu_ngay", Formater.getDateForPrint(Formater.date2str(qd.getTuNgayXm())));
			parameters.put("den_ngay", Formater.getDateForPrint(Formater.date2str(qd.getDenNgayXm())));
			parameters.put("ngay_ra_quyet_dinh", Formater.getDateForPrint(Formater.date2str(qd.getNgayLap())));
			parameters.put("ket_qua_xac_minh", dxForm.getKetQuaXm());
			parameters.put("kien_nghi", dxForm.getKienNghi());
			parameters.put("ten_truong_doan", "");
			String ngayLap = "";
			if (Formater.isNull(dxForm.getThoiDiem())) {
				ngayLap = ".....,ng\u00E0y.....th\u00E1ng....n\u0103m        ";
			} else
				ngayLap = Formater.getDateForPrint(dxForm.getThoiDiem());
			parameters.put("ngay_lap_bao_cao", dxForm.getDiaDiem() + ", " + ngayLap);
			if (dx != null) {
				parameters.put("nguoi_co_quan_don_vi_khieu_nai", dx.getNguoiKNTC());
				parameters.put("hanh_vi_bi_khieu_nai", dx.getNguoiBiKNTC());
			}
			parameters.put("don_cong_van_de_ngay", Formater.getDateForPrint(Formater.date2str(hdr.getCongVanDenNgay())));
			parameters.put("tom_tat_noi_dung_khieu_nai", dxForm.getNoiDung());
			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
			KtnbUtil.printf(null, fileTemplate, response, inputStream, parameters, null);
		}
		return null;
	}

	// Show bien ban lam viec 12/KNTC
	public ActionForward bb(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			DungChungService service = new DungChungService();
			if ("4".equals(service.getVersionDonKntc(appContext, maHs)))
				return bbV4(map, form, request, response);
			else
				System.out.println("Ma HS : "+service.getVersionDonKntc(appContext, maHs));
				return bbV3(map, form, request, response);
		} else
			if("4".equals(Constants.APP_DEP_VERSION))
				return bbV4(map, form, request, response);
			else 
				return bbV3(map, form, request, response);
		
	}
	
	public ActionForward bbV3(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		KeHoachForm cnForm = (KeHoachForm) form;
		String maHs = request.getParameter("id");
		XacMinhService s = new XacMinhService();
		String act = request.getParameter("action");
		// Loai bien ban
		String readOnly = request.getParameter("r");
		if (readOnly != null)
			if (readOnly.equals("rol")) {
				String loaiBienBan = "";
				if ("bbxmkn".equals(act)) {
					loaiBienBan = KntcBienBan.BB_CONG_BO_QDXM_KN;
				} else if ("bbxmtc".equals(act)) {
					loaiBienBan = KntcBienBan.BB_CONG_BO_QDXM_TC;
				} else if ("bbLamViecNguoiKN0".equals(act)) {
					loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_KN0;
				} else if ("bbLamViecNguoiKN".equals(act)) {
					loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_KN;
				} else if ("bbLamViecNguoiBiKN".equals(act)) {
					loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_BI_KN;
				} else if ("bbLamViecNguoiTC0".equals(act)) {
					loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_TC0;
				} else if ("bbLamViecNguoiTC".equals(act)) {
					loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_TC;
				} else if ("bbLamViecNguoiBiTC".equals(act)) {
					loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_BI_TC;
				} else if ("bbDoiThoai".equals(act)) {
					loaiBienBan = KntcBienBan.BB_DOI_THOAI;
				} else if ("bbDoiThoaiKN".equals(act)) {
					loaiBienBan = KntcBienBan.BB_DOI_THOAI_KN;
				} else if ("bbYeuCauBoSungHSTL".equals(act)) {
					loaiBienBan = KntcBienBan.BB_LAM_VIEC_YEU_CAU_CCTL;
				} else if ("bbYeuCauBoSungHSTLTC".equals(act)) {
					loaiBienBan = KntcBienBan.BB_LAM_VIEC_YEU_CAU_CCTLTC;
				} else if ("bbThongBaoDuThaoTC".equals(act)) {
					loaiBienBan = KntcBienBan.BB_THONG_BAO_DU_THAO_GQTC;
				}
				if (s.getBienBanByHoSo(appContext, maHs, loaiBienBan) == null) {
					throw new KtnbException("Bi&#7875;u m&#7851;u n&#224;y kh&#244;ng c&#243; s&#7889; li&#7879;u!!!", "", "");
				}
			}

		if (act.toUpperCase().indexOf("KN") != -1 && !act.equals("bbDoiThoaiKN") && !act.equals("bbLamViecNguoiKN0")) {
			KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, maHs);
			if (qd == null || qd.getNgayDuyet() == null)
				throw new KtnbException(
						"Ch&#432;a c&#243; quy&#7871;t &#273;&#7883;nh x&#225;c minh, ho&#7863;c quy&#7871;t &#273;&#7883;nh x&#225;c minh ch&#432;a &#273;&#432;&#7907;c duy&#7879;t!", "",
						"C&#7847;n ho&#224;n thi&#7879;n quy&#7871;t &#273;&#7883;nh x&#225;c minh m&#7851;u 10/KNTC tr&#432;&#7899;c!");

			// KntcXmKeHoach kh = s.getKntcXmKeHoachByHoSo(appContext, maHs);
			// if (kh == null || kh.getNgayDuyet() == null)
			// throw new KtnbException("Ch&#432;a c&#243; k&#7871; ho&#7841;ch
			// x&#225;c minh, ho&#7863;c k&#7871; ho&#7841;ch x&#225;c minh
			// ch&#432;a &#273;&#432;&#7907;c duy&#7879;t!", "", "C&#7847;n
			// ho&#224;n thi&#7879;n k&#7871; ho&#7841;ch x&#225;c minh
			// m&#7851;u 11/KNTC tr&#432;&#7899;c!");
		} else if (act.toUpperCase().indexOf("TC") != -1 && !act.equals("bbLamViecNguoiTC0") && !act.equals("bbThongBaoDuThaoTC")) {
			KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, maHs);
			if (qd == null || qd.getNgayDuyet() == null)
				throw new KtnbException(
						"Ch&#432;a c&#243; quy&#7871;t &#273;&#7883;nh x&#225;c minh, ho&#7863;c quy&#7871;t &#273;&#7883;nh x&#225;c minh ch&#432;a &#273;&#432;&#7907;c duy&#7879;t!", "",
						"C&#7847;n ho&#224;n thi&#7879;n quy&#7871;t &#273;&#7883;nh x&#225;c minh m&#7851;u 22/KNTC tr&#432;&#7899;c!");
			// KntcXmKeHoach kh = s.getKntcXmKeHoachByHoSo(appContext, maHs);
			// if (kh == null || kh.getNgayDuyet() == null)
			// throw new KtnbException("Ch&#432;a c&#243; k&#7871; ho&#7841;ch
			// x&#225;c minh, ho&#7863;c k&#7871; ho&#7841;ch x&#225;c minh
			// ch&#432;a &#273;&#432;&#7907;c duy&#7879;t!", "", "C&#7847;n
			// ho&#224;n thi&#7879;n k&#7871; ho&#7841;ch x&#225;c minh
			// m&#7851;u 11/KNTC tr&#432;&#7899;c!");
		}
		if (!Formater.isNull(maHs))
			cnForm.setMaHoSo(maHs);
		cnForm.setThoiDiem(Formater.date2strDateTimeForNV(new Date()));
		cnForm.setDiaDiem(appContext.getDiaBan());
		Collection listCb = s.getListCanBoXmByHs(appContext, maHs);
		StringBuffer sb = new StringBuffer("1. \u0110\u1EA1i \u0111i\u1EC7n \u0111o\u00E0n x\u00E1c minh: <br>");
		for (Iterator iter = listCb.iterator(); iter.hasNext();) {
			KntcCanBoRls element = (KntcCanBoRls) iter.next();
			sb.append("+ \u00D4ng (b\u00E0): " + element.getTenCb() + " - ch\u1EE9c v\u1EE5: " + element.getVaiTro());
			sb.append(" <br> ");
		}
		cnForm.setThanhPhan(sb.toString());

		cnForm.setAct(act);

		return map.findForward("bb");
	}
	
	// Xem Bien ban lam viec! Mau 12/KNTC
	public ActionForward xemBblv(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		KeHoachForm tdForm = (KeHoachForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			DungChungService service = new DungChungService();
			if ("4".equals(service.getVersionDonKntc(appContext, maHs)))
				return xemBblvV4(map, form, request, response);
			else
				System.out.println("Ma HS : "+service.getVersionDonKntc(appContext, maHs));
				return xemBblvV3(map, form, request, response);
		} else
			if("4".equals(Constants.APP_DEP_VERSION))
				return xemBblvV4(map, form, request, response);
			else 
				return xemBblvV3(map, form, request, response);
	}
	//v3
	public ActionForward xemBblvV3(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhService service = new XacMinhService();
		try {
			KntcBienBan bb = service.getBienBanByMaBB(appContext, request.getParameter("pId").toString());
			KeHoachForm tdForm = (KeHoachForm) form;
			tdForm.fromBienBan(bb, appContext);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return map.findForward("bb");
	}

	//v4
	public ActionForward xemBblvV4(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhService service = new XacMinhService();
		String action=request.getParameter("action");
		try {
			KntcBienBan bb = service.getBienBanByMaBB(appContext, request.getParameter("pId").toString());
			KeHoachForm tdForm = (KeHoachForm) form;
			tdForm.fromBienBan(bb, appContext);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		if("bbxmtc".equals(action))
			return map.findForward("bbTC");
		else
			return map.findForward("bb");
	}

	// Tao moi bien ban lam viec 12
	public ActionForward taoMoiBblv(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		KeHoachForm tdForm = (KeHoachForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			DungChungService service = new DungChungService();
			if ("4".equals(service.getVersionDonKntc(appContext, maHs)))
				return taoMoiBblvV4(map, form, request, response);
			else
				return taoMoiBblvV3(map, form, request, response);
		} else
			if("4".equals(Constants.APP_DEP_VERSION))
				return taoMoiBblvV4(map, form, request, response);
			else 
				return taoMoiBblvV3(map, form, request, response);
	}
	public ActionForward taoMoiBblvV3(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		KeHoachForm tdForm = (KeHoachForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhService s = new XacMinhService();
		// reset value
		tdForm.setNoiDung("");
		tdForm.setDiaDiem(appContext.getDiaBan());
		tdForm.setThoiDiem(Formater.date2strDateTimeForNV(new Date()));
		tdForm.setSoBanIn("2");
		// Collection listCb = s.getListCanBoXmByHs(appContext,
		// tdForm.getMaHoSo());
		// StringBuffer sb = new StringBuffer("1. \u0110\u1EA1i \u0111i\u1EC7n
		// \u0111o\u00E0n x\u00E1c minh: <br>");
		// for (Iterator iter = listCb.iterator(); iter.hasNext();) {
		// KntcCanBoRls element = (KntcCanBoRls) iter.next();
		// sb.append("+ \u00D4ng (b\u00E0): " + element.getTenCb() + " -
		// ch\u1EE9c v\u1EE5: " + element.getVaiTro());
		// sb.append(" <br> ");
		// }
		tdForm.setThanhPhan("");

		return map.findForward("bb");
	}
	//v4
	public ActionForward taoMoiBblvV4(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		KeHoachForm tdForm = (KeHoachForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhService s = new XacMinhService();
		String action = request.getParameter("action");
		// reset value
		tdForm.setNoiDung("");
		tdForm.setDiaDiem(appContext.getDiaBan());
		tdForm.setThoiDiem(Formater.date2strDateTimeForNV(new Date()));
		tdForm.setSoBanIn("2");
		// Collection listCb = s.getListCanBoXmByHs(appContext,
		// tdForm.getMaHoSo());
		// StringBuffer sb = new StringBuffer("1. \u0110\u1EA1i \u0111i\u1EC7n
		// \u0111o\u00E0n x\u00E1c minh: <br>");
		// for (Iterator iter = listCb.iterator(); iter.hasNext();) {
		// KntcCanBoRls element = (KntcCanBoRls) iter.next();
		// sb.append("+ \u00D4ng (b\u00E0): " + element.getTenCb() + " -
		// ch\u1EE9c v\u1EE5: " + element.getVaiTro());
		// sb.append(" <br> ");
		// }
		tdForm.setThanhPhan("");
		if ("bbxmtc".equals(action)) {
//			 cnForm.setThoiDiemHoanThanh(thoiDiemHoanThanh)
			 return map.findForward("bbTC");
		 }
		 else
			 return map.findForward("bb");
	}

	// Xoa bb lam viec
	public ActionForward xoaBblv(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			DungChungService service = new DungChungService();
			if ("4".equals(service.getVersionDonKntc(appContext, maHs)))
				return xoaBblvV4(map, form, request, response);
			else
				System.out.println("Ma HS : "+service.getVersionDonKntc(appContext, maHs));
				return xoaBblvV3(map, form, request, response);
		} else
			if("4".equals(Constants.APP_DEP_VERSION))
				return xoaBblvV4(map, form, request, response);
			else 
				return xoaBblvV3(map, form, request, response);
		
	}
	
	public ActionForward xoaBblvV3(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhService service = new XacMinhService();
		try {
			service.delBienBanByMaBB(appContext, request.getParameter("pId").toString(), request.getParameter("id").toString());
			request.setAttribute("xoaThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("xoaThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		return map.findForward("bb");
	}
	//v4
	public ActionForward xoaBblvV4(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhService service = new XacMinhService();
		String action = request.getParameter("action");
		try {
			service.delBienBanByMaBB(appContext, request.getParameter("pId").toString(), request.getParameter("id").toString());
			request.setAttribute("xoaThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("xoaThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		if ("bbxmtc".equals(action)) {
			 return map.findForward("bbTC");
		 }
		else
			return map.findForward("bb");
	}


	// Save Bien ban lam viec! Mau 12/KNTC
	public ActionForward saveBblv(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			DungChungService service = new DungChungService();
			if ("4".equals(service.getVersionDonKntc(appContext, maHs)))
				return saveBblvV4(map, form, request, response);
			else
				return saveBblvV3(map, form, request, response);
		} else
			if("4".equals(Constants.APP_DEP_VERSION))
				return saveBblvV4(map, form, request, response);
			else 
				return saveBblvV3(map, form, request, response);		
	}
	
	public ActionForward saveBblvV3(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// if (isTokenValid(request, true)) {
		try {
			KeHoachForm tdForm = (KeHoachForm) form;
			XacMinhService xmS = new XacMinhService();
			KntcBienBan bb = null;
			if (request.getParameter("pId") != null) {
				bb = xmS.getBienBanByMaBB(appContext, request.getParameter("pId").toString());
				// System.out.println(request.getParameter("pId").toString());
			}
			KntcBienBanId id = null;
			if (bb == null) {
				bb = new KntcBienBan();
				id = new KntcBienBanId();
				id.setMaHs(tdForm.getMaHoSo());
				if (request.getParameter("pId") != null) {
					id.setMaBb(request.getParameter("pId").toString());
				} else
					id.setMaBb(null);
			} else
				id = bb.getId();

			bb.setId(id);
			bb.setDiaDiem(tdForm.getDiaDiem());
			bb.setNgayCapNhat(new Date());
			bb.setNguoiCapNhat(appContext.getTenNsd());
			bb.setThoiDiem(Formater.str2dateForNV(tdForm.getThoiDiem()));

			bb.setSoBanIn(new Long(tdForm.getSoBanIn()));
			// bb.setSoBenLviec(new Long(tdForm.getSoBen()));
			// System.out.println(tdForm.getNoiDung().length());
			bb.setNoiDung(tdForm.getNoiDung());
			bb.setThanhPhan(tdForm.getThanhPhan());
			// Luu xuong DB
			XacMinhService services = new XacMinhService();
			String loaiBienBan = "";
			String action = tdForm.getAct();
			if ("bbxmkn".equals(action)) {
				loaiBienBan = KntcBienBan.BB_CONG_BO_QDXM_KN;
			} else if ("bbxmtc".equals(action)) {
				loaiBienBan = KntcBienBan.BB_CONG_BO_QDXM_TC;
			} else if ("bbLamViecNguoiKN0".equals(action)) {
				loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_KN0;
			} else if ("bbLamViecNguoiKN".equals(action)) {
				loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_KN;
			} else if ("bbLamViecNguoiBiKN".equals(action)) {
				loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_BI_KN;
			} else if ("bbLamViecNguoiTC0".equals(action)) {
				loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_TC0;
			} else if ("bbLamViecNguoiTC".equals(action)) {
				loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_TC;
			} else if ("bbLamViecNguoiBiTC".equals(action)) {
				loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_BI_TC;
			} else if ("bbDoiThoai".equals(action)) {
				loaiBienBan = KntcBienBan.BB_DOI_THOAI;
			} else if ("bbDoiThoaiKN".equals(action)) {
				loaiBienBan = KntcBienBan.BB_DOI_THOAI_KN;
			} else if ("bbYeuCauBoSungHSTL".equals(action)) {
				loaiBienBan = KntcBienBan.BB_LAM_VIEC_YEU_CAU_CCTL;
			} else if ("bbYeuCauBoSungHSTLTC".equals(action)) {
				loaiBienBan = KntcBienBan.BB_LAM_VIEC_YEU_CAU_CCTLTC;
			} else if ("bbThongBaoDuThaoTC".equals(action)) {
				loaiBienBan = KntcBienBan.BB_THONG_BAO_DU_THAO_GQTC;
			}
			services.saveBienBan(appContext, bb, loaiBienBan);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		return map.findForward("bb");
	}

	public ActionForward saveBblvV4(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// if (isTokenValid(request, true)) {
		try {
			KeHoachForm tdForm = (KeHoachForm) form;
			XacMinhService xmS = new XacMinhService();
			KntcBienBan bb = null;
			if (request.getParameter("pId") != null) {
				bb = xmS.getBienBanByMaBB(appContext, request.getParameter("pId").toString());
				// System.out.println(request.getParameter("pId").toString());
			}
			KntcBienBanId id = null;
			if (bb == null) {
				bb = new KntcBienBan();
				id = new KntcBienBanId();
				id.setMaHs(tdForm.getMaHoSo());
				if (request.getParameter("pId") != null) {
					id.setMaBb(request.getParameter("pId").toString());
				} else
					id.setMaBb(null);
			} else
				id = bb.getId();

			bb.setId(id);
			bb.setDiaDiem(tdForm.getDiaDiem());
			bb.setNgayCapNhat(new Date());
			bb.setNguoiCapNhat(appContext.getTenNsd());
			bb.setThoiDiem(Formater.str2dateForNV(tdForm.getThoiDiem()));
			bb.setThoiDiemHoanThanh(Formater.str2dateForNV(tdForm.getThoiDiemHoanThanh()));
			System.out.println("bat dau: "+ bb.getThoiDiem());
			System.out.println("ket thuc: "+bb.getThoiDiemHoanThanh());
			bb.setSoBanIn(new Long(tdForm.getSoBanIn()));
			// bb.setSoBenLviec(new Long(tdForm.getSoBen()));
			// System.out.println(tdForm.getNoiDung().length());
			bb.setNoiDung(tdForm.getNoiDung());
			bb.setThanhPhan(tdForm.getThanhPhan());
			// Luu xuong DB
			XacMinhService services = new XacMinhService();
			String loaiBienBan = "";
			String action = tdForm.getAct();
			if ("bbxmkn".equals(action)) {
				loaiBienBan = KntcBienBan.BB_CONG_BO_QDXM_KN;
			} else if ("bbxmtc".equals(action)) {
				loaiBienBan = KntcBienBan.BB_CONG_BO_QDXM_TC;
			} else if ("bbLamViecNguoiKN0".equals(action)) {
				loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_KN0;
			} else if ("bbLamViecNguoiKN".equals(action)) {
				loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_KN;
			} else if ("bbLamViecNguoiBiKN".equals(action)) {
				loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_BI_KN;
			} else if ("bbLamViecNguoiTC0".equals(action)) {
				loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_TC0;
			} else if ("bbLamViecNguoiTC".equals(action)) {
				loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_TC;
			} else if ("bbLamViecNguoiBiTC".equals(action)) {
				loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_BI_TC;
			} else if ("bbDoiThoai".equals(action)) {
				loaiBienBan = KntcBienBan.BB_DOI_THOAI;
			} else if ("bbDoiThoaiKN".equals(action)) {
				loaiBienBan = KntcBienBan.BB_DOI_THOAI_KN;
			} else if ("bbYeuCauBoSungHSTL".equals(action)) {
				loaiBienBan = KntcBienBan.BB_LAM_VIEC_YEU_CAU_CCTL;
			} else if ("bbYeuCauBoSungHSTLTC".equals(action)) {
				loaiBienBan = KntcBienBan.BB_LAM_VIEC_YEU_CAU_CCTLTC;
			} else if ("bbThongBaoDuThaoTC".equals(action)) {
				loaiBienBan = KntcBienBan.BB_THONG_BAO_DU_THAO_GQTC;
			}
			services.saveBienBan(appContext, bb, loaiBienBan);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			SoTiepDanService s = new SoTiepDanService();
			KntcSoTiepDan hs = s.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = hs.getHdr();
			if (hdr.getLoaiKntc().intValue() == 2) // TC
			{
				return map.findForward("bbTC");
			}
			else
				return map.findForward("bb");
		}
		else
			return map.findForward("bb");
	}

	
	/**
	 * Bien ban chuyen co quan dieu tra cua TO CAO
	 * 
	 * @author ntthu
	 */
	public ActionForward bb25B(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		KeHoachForm cnForm = (KeHoachForm) form;
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			cnForm.setMaHoSo(maHs);
			XacMinhService s = new XacMinhService();
			// Collection listCb = s.getListCanBoXmByHs(appContext, maHs);
			// StringBuffer sb = new StringBuffer();
			// for (Iterator iter = listCb.iterator(); iter.hasNext();) {
			// KntcCanBoRls element = (KntcCanBoRls) iter.next();
			// sb.append("+ \u00D4ng (b\u00E0) " + element.getTenCb() + " -
			// ch\u1EE9c v\u1EE5 " + element.getVaiTro());
			// sb.append(" <br> ");
			// }
			cnForm.setDaiDien("");
			KntcBienBan kq = s.getBienBanByHoSo(appContext, maHs, KntcBienBan.BB_CHUYEN_DIEU_TRA_TC);
			// SoTiepDanService s1 = new SoTiepDanService();
			if (kq == null) { // Tao moi
				cnForm.setThoiDiem(Formater.date2strDateTimeForNV(new Date()));
				cnForm.setThoiDiemHoanThanh(Formater.date2strDateTimeForNV(new Date()));
				cnForm.setDiaDiem(appContext.getDiaBan());
			} else { // Edit
				cnForm.fromBienBan(kq, appContext);
			}
		}
		// saveToken(request);
		return map.findForward("bb25B");
	}

	public ActionForward saveBb25(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// if (isTokenValid(request, true)) {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		KeHoachForm cnForm = (KeHoachForm) form;
		try {
			XacMinhService services = new XacMinhService();
			services.saveBienBan(appContext, cnForm.toBienBan(appContext), KntcBienBan.BB_CHUYEN_DIEU_TRA_TC);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		// }
		return map.findForward("bb25B");
	}

	public ActionForward getListBienBan(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonResult = null;
		// XacMinhForm xmForm = (XacMinhForm) form;
		try {
			// jsonResult = this.createObject(xmForm, request);
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
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			DungChungService service = new DungChungService();
			if ("4".equals(service.getVersionDonKntc(appContext, maHs)))
				return createObjectV4(request);
			else
				return createObjectV3(request);
		} else
			if("4".equals(Constants.APP_DEP_VERSION))
				return createObjectV4(request);
			else 
				return createObjectV3(request);
				
	}
	private JSONObject createObjectV3(HttpServletRequest request) throws Exception {
		// Get ma Ho so
		String maHs = request.getParameter("maHs");
		// Loai bien ban
		String loaiBienBan = "";
		String action = request.getParameter("action");
		if ("bbxmkn".equals(action)) {
			loaiBienBan = KntcBienBan.BB_CONG_BO_QDXM_KN;
		} else if ("bbxmtc".equals(action)) {
			loaiBienBan = KntcBienBan.BB_CONG_BO_QDXM_TC;
		} else if ("bbLamViecNguoiKN0".equals(action)) {
			loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_KN0;
		} else if ("bbLamViecNguoiKN".equals(action)) {
			loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_KN;
		} else if ("bbLamViecNguoiBiKN".equals(action)) {
			loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_BI_KN;
		} else if ("bbLamViecNguoiTC0".equals(action)) {
			loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_TC0;
		} else if ("bbLamViecNguoiTC".equals(action)) {
			loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_TC;
		} else if ("bbLamViecNguoiBiTC".equals(action)) {
			loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_BI_TC;
		} else if ("bbDoiThoai".equals(action)) {
			loaiBienBan = KntcBienBan.BB_DOI_THOAI;
		} else if ("bbDoiThoaiKN".equals(action)) {
			loaiBienBan = KntcBienBan.BB_DOI_THOAI_KN;
		} else if ("bbYeuCauBoSungHSTL".equals(action)) {
			loaiBienBan = KntcBienBan.BB_LAM_VIEC_YEU_CAU_CCTL;
		} else if ("bbYeuCauBoSungHSTLTC".equals(action)) {
			loaiBienBan = KntcBienBan.BB_LAM_VIEC_YEU_CAU_CCTLTC;
		} else if ("bbThongBaoDuThaoTC".equals(action)) {
			loaiBienBan = KntcBienBan.BB_THONG_BAO_DU_THAO_GQTC;
		}
		// Create Object
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			conn = DataSourceConfiguration.getConnection();
			StringBuffer sb = new StringBuffer("select ma_bb,dia_diem,thoi_diem,so_ban_in from kntc_bien_ban where ma_hs=? and loai_bb=?");
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, maHs);
			ps.setString(2, loaiBienBan);
			System.out.println(sb.toString());
			JSONArray jsonArray = new JSONArray();
			int rc = 0;
			rs = ps.executeQuery();
			while (rs.next()) {
				JSONArray ja;
				ja = new JSONArray();
				ja.put(rs.getString(1)); // ma bb
				ja.put(rs.getString(2)); // diadiem
				ja.put(Formater.date2str(rs.getDate(3))); // thoidiem
				ja.put(rs.getString(4));// so ban in
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

	//v4
	public ActionForward bbV4(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		KeHoachForm cnForm = (KeHoachForm) form;
		String maHs = request.getParameter("id");
		XacMinhService s = new XacMinhService();
		String act = request.getParameter("action");
		// Loai bien ban
		String readOnly = request.getParameter("r");
		if (readOnly != null)
			if (readOnly.equals("rol")) {
				String loaiBienBan = "";
				if ("bbxmkn".equals(act)) {
					loaiBienBan = KntcBienBan.BB_CONG_BO_QDXM_KN;
				} else if ("bbxmtc".equals(act)) {
					loaiBienBan = KntcBienBan.BB_CONG_BO_QDXM_TC;
				} else if ("bbLamViecNguoiKN0".equals(act)) {
					loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_KN0;
				} else if ("bbLamViecNguoiKN".equals(act)) {
					loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_KN;
				} else if ("bbLamViecNguoiBiKN".equals(act)) {
					loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_BI_KN;
				} else if ("bbLamViecNguoiTC0".equals(act)) {
					loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_TC0;
				} else if ("bbLamViecNguoiTC".equals(act)) {
					loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_TC;
				} else if ("bbLamViecNguoiBiTC".equals(act)) {
					loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_BI_TC;
				} else if ("bbDoiThoai".equals(act)) {
					loaiBienBan = KntcBienBan.BB_DOI_THOAI;
				} else if ("bbDoiThoaiKN".equals(act)) {
					loaiBienBan = KntcBienBan.BB_DOI_THOAI_KN;
				} else if ("bbYeuCauBoSungHSTL".equals(act)) {
					loaiBienBan = KntcBienBan.BB_LAM_VIEC_YEU_CAU_CCTL;
				} else if ("bbYeuCauBoSungHSTLTC".equals(act)) {
					loaiBienBan = KntcBienBan.BB_LAM_VIEC_YEU_CAU_CCTLTC;
				} else if ("bbThongBaoDuThaoTC".equals(act)) {
					loaiBienBan = KntcBienBan.BB_THONG_BAO_DU_THAO_GQTC;
				}
				if (s.getBienBanByHoSo(appContext, maHs, loaiBienBan) == null) {
					throw new KtnbException("Bi&#7875;u m&#7851;u n&#224;y kh&#244;ng c&#243; s&#7889; li&#7879;u!!!", "", "");
				}
			}

		if (act.toUpperCase().indexOf("KN") != -1 && !act.equals("bbDoiThoaiKN") && !act.equals("bbLamViecNguoiKN0")) {
			KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, maHs);
			if (qd == null || qd.getNgayDuyet() == null)
				throw new KtnbException(
						"Ch&#432;a c&#243; quy&#7871;t &#273;&#7883;nh x&#225;c minh, ho&#7863;c quy&#7871;t &#273;&#7883;nh x&#225;c minh ch&#432;a &#273;&#432;&#7907;c duy&#7879;t!", "",
						"C&#7847;n ho&#224;n thi&#7879;n quy&#7871;t &#273;&#7883;nh x&#225;c minh m&#7851;u 10/KNTC tr&#432;&#7899;c!");

			// KntcXmKeHoach kh = s.getKntcXmKeHoachByHoSo(appContext, maHs);
			// if (kh == null || kh.getNgayDuyet() == null)
			// throw new KtnbException("Ch&#432;a c&#243; k&#7871; ho&#7841;ch
			// x&#225;c minh, ho&#7863;c k&#7871; ho&#7841;ch x&#225;c minh
			// ch&#432;a &#273;&#432;&#7907;c duy&#7879;t!", "", "C&#7847;n
			// ho&#224;n thi&#7879;n k&#7871; ho&#7841;ch x&#225;c minh
			// m&#7851;u 11/KNTC tr&#432;&#7899;c!");
		} else if (act.toUpperCase().indexOf("TC") != -1 && !act.equals("bbLamViecNguoiTC0") && !act.equals("bbThongBaoDuThaoTC")) {
			KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, maHs);
			if (qd == null || qd.getNgayDuyet() == null)
				throw new KtnbException(
						"Ch&#432;a c&#243; quy&#7871;t &#273;&#7883;nh x&#225;c minh, ho&#7863;c quy&#7871;t &#273;&#7883;nh x&#225;c minh ch&#432;a &#273;&#432;&#7907;c duy&#7879;t!", "",
						"C&#7847;n ho&#224;n thi&#7879;n quy&#7871;t &#273;&#7883;nh x&#225;c minh m&#7851;u 22/KNTC tr&#432;&#7899;c!");
			// KntcXmKeHoach kh = s.getKntcXmKeHoachByHoSo(appContext, maHs);
			// if (kh == null || kh.getNgayDuyet() == null)
			// throw new KtnbException("Ch&#432;a c&#243; k&#7871; ho&#7841;ch
			// x&#225;c minh, ho&#7863;c k&#7871; ho&#7841;ch x&#225;c minh
			// ch&#432;a &#273;&#432;&#7907;c duy&#7879;t!", "", "C&#7847;n
			// ho&#224;n thi&#7879;n k&#7871; ho&#7841;ch x&#225;c minh
			// m&#7851;u 11/KNTC tr&#432;&#7899;c!");
		}
		if (!Formater.isNull(maHs))
			cnForm.setMaHoSo(maHs);
		cnForm.setThoiDiem(Formater.date2strDateTimeForNV(new Date()));
		cnForm.setDiaDiem(appContext.getDiaBan());
		Collection listCb = s.getListCanBoXmByHs(appContext, maHs);
		StringBuffer sb = new StringBuffer("1. \u0110\u1EA1i \u0111i\u1EC7n \u0111o\u00E0n x\u00E1c minh: <br>");
		for (Iterator iter = listCb.iterator(); iter.hasNext();) {
			KntcCanBoRls element = (KntcCanBoRls) iter.next();
			sb.append("+ \u00D4ng (b\u00E0): " + element.getTenCb() + " - ch\u1EE9c v\u1EE5: " + element.getVaiTro());
			sb.append(" <br> ");
		}
		cnForm.setThanhPhan(sb.toString());

		cnForm.setAct(act);
		 if ("bbLamViecNguoiTC".equals(act)) {
//			 cnForm.setThoiDiemHoanThanh(thoiDiemHoanThanh)
			 return map.findForward("bbTC");
		 }
		 else
			 return map.findForward("bb");
	}

	private JSONObject createObjectV4(HttpServletRequest request) throws Exception {
		// Get ma Ho so
		String maHs = request.getParameter("maHs");
		// Loai bien ban
		String loaiBienBan = "";
		String action = request.getParameter("action");
		if ("bbxmkn".equals(action)) {
			loaiBienBan = KntcBienBan.BB_CONG_BO_QDXM_KN;
		} else if ("bbxmtc".equals(action)) {
			loaiBienBan = KntcBienBan.BB_CONG_BO_QDXM_TC;
		} else if ("bbLamViecNguoiKN0".equals(action)) {
			loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_KN0;
		} else if ("bbLamViecNguoiKN".equals(action)) {
			loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_KN;
		} else if ("bbLamViecNguoiBiKN".equals(action)) {
			loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_BI_KN;
		} else if ("bbLamViecNguoiTC0".equals(action)) {
			loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_TC0;
		} else if ("bbLamViecNguoiTC".equals(action)) {
			loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_TC;
		} else if ("bbLamViecNguoiBiTC".equals(action)) {
			loaiBienBan = KntcBienBan.BB_LAM_VIEC_NGUOI_BI_TC;
		} else if ("bbDoiThoai".equals(action)) {
			loaiBienBan = KntcBienBan.BB_DOI_THOAI;
		} else if ("bbDoiThoaiKN".equals(action)) {
			loaiBienBan = KntcBienBan.BB_DOI_THOAI_KN;
		} else if ("bbYeuCauBoSungHSTL".equals(action)) {
			loaiBienBan = KntcBienBan.BB_LAM_VIEC_YEU_CAU_CCTL;
		} else if ("bbYeuCauBoSungHSTLTC".equals(action)) {
			loaiBienBan = KntcBienBan.BB_LAM_VIEC_YEU_CAU_CCTLTC;
		} else if ("bbThongBaoDuThaoTC".equals(action)) {
			loaiBienBan = KntcBienBan.BB_THONG_BAO_DU_THAO_GQTC;
		}
		// Create Object
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			conn = DataSourceConfiguration.getConnection();
			StringBuffer sb = new StringBuffer("select ma_bb,dia_diem,thoi_diem,thoi_diem_hoan_thanh,so_ban_in from kntc_bien_ban where ma_hs=? and loai_bb=?");
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, maHs);
			ps.setString(2, loaiBienBan);
			System.out.println(sb.toString());
			JSONArray jsonArray = new JSONArray();
			int rc = 0;
			rs = ps.executeQuery();
			while (rs.next()) {
				JSONArray ja;
				ja = new JSONArray();
				ja.put(rs.getString(1)); // ma bb
				ja.put(rs.getString(2)); // diadiem
				ja.put(Formater.date2strDateTimeForNV(rs.getDate(3))); // thoidiem
				ja.put(Formater.date2strDateTimeForNV(rs.getDate(4))); // thoidiemhoanthanh
				ja.put(rs.getString(5));// so ban in
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

	public ActionForward getListTVD(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonResult = null;
		// XacMinhForm xmForm = (XacMinhForm) form;
		try {
			// jsonResult = this.createObject(xmForm, request);
			jsonResult = this.createObjectTVD(request);
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

	private JSONObject createObjectTVD(HttpServletRequest request) throws Exception {
		// Get ma Ho so
		String maHs = request.getParameter("id");
		// Create Object
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			conn = DataSourceConfiguration.getConnection();
			StringBuffer sb = new StringBuffer("select ma_canbo,ten_cb,don_vi,chuc_vu,vai_tro from KNTC_CAN_BO_RLS where ma_hs =? and loai_cb=?");
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, maHs);
			ps.setString(2, KntcCanBoRls.KNTC_TVD_XAC_MINH);
			System.out.println(sb.toString());
			JSONArray jsonArray = new JSONArray();
			int rc = 1;
			rs = ps.executeQuery();
			while (rs.next()) {
				JSONArray ja;
				ja = new JSONArray();
				String s1 = "";
				String s2 = "";
				String s3 = "";
				String vaiTro = URLUTF8Encoder.encode(rs.getString(5));
				if ("Tr%c6%b0%e1%bb%9fng+%c4%91o%c3%a0n".equals(vaiTro)) {
					s1 = "selected=\"selected\"";
				} else if ("Ph%c3%b3+%c4%91o%c3%a0n".equals(vaiTro)) {
					s2 = "selected=\"selected\"";
				} else if ("Th%c3%a0nh+vi%c3%aan+%c4%91o%c3%a0n".equals(vaiTro)) {
					s3 = "selected=\"selected\"";
				}
				ja.put("<input type=\"text\" id=\"maCanBo" + rc + "\" value=\"" + rs.getString(1) + "\" style=\"display: none;width: 0px;\"/>" + "<input type=\"text\" name=\"tenCanBo\" value=\""
						+ rs.getString(2) + "\" id=\"tenCanBo" + rc + "\" style=\"width: 120px;\"/>&nbsp;"
						+ "<input type=\"button\" class=\"button\" name=\"btnCb\" value=\"...\" onclick=\"showLovCanbo(" + rc + ")\"/>");
				ja.put("<input type=\"text\" name=\"donVi\" id=\"donVi" + rc + "\" value=\"" + rs.getString(3) + "\" readonly=\"true\" style=\"width: 120px;\"/>"); // diadiem
				ja.put("<input type=\"text\" name=\"chucVu\" id=\"chucVu" + rc + "\" value=\"" + rs.getString(4) + "\" readonly=\"true\" style=\"width: 120px;\"/>"); // thoidiem
				ja.put("<select id=\"vaiTro" + rc + "\">" + "<option value=\"Tr&#432;&#7903;ng &#273;o&#224;n\" " + s1 + ">Tr&#432;&#7903;ng &#273;o&#224;n</option>"
						+ "<option value=\"Ph&#243; &#273;o&#224;n\" " + s2 + ">Ph&#243; &#273;o&#224;n</option>" + "<option value=\"Th&#224;nh vi&#234;n &#273;o&#224;n\" " + s3
						+ ">Th&#224;nh vi&#234;n &#273;o&#224;n</option>" + "</select>");// so
				// ban
				// in
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

	/**
	 * Download file mẫu KNTC17
	 * 
	 * @throws Exception
	 */
	public ActionForward downloadKNTC17(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileIn = request.getRealPath("/docin") + "\\KNTC17.doc";
		String fileOut = request.getRealPath("/docout") + "\\KNTC17_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhForm dxForm = (XacMinhForm) form;
		String maHs = dxForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			SoTiepDanService stdService = new SoTiepDanService();
			KntcSoTiepDan std = stdService.getSoTiepDan(appContext, maHs, true);
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			XacMinhService xmService = new XacMinhService();
			KntcQdinhXm qdxm = xmService.getKntcQdinhXmByHoSo(appContext, maHs);
			KntcHoSoHdr hdr = std.getHdr();

			MsWordUtils word = new MsWordUtils(fileIn, fileOut);
			try {
				// Chú ý: Việc replate text cần thực hiện tuần tự đúng từ trên
				// xuống dưới theo file Word
				word.put("[TEN_CQ_RA_QD]", appContext.getTenCqt().toUpperCase());
				word.put("[SO_QD_XM]", qdxm.getMaQd());
				word.put("[dia_diem]", dxForm.getDiaDiem());
				if (Formater.isNull(dxForm.getThoiDiem())) {
					word.put("[ngay_thang_nam]", ",ngày...tháng...năm...");
				} else
					word.put("[ngay_thang_nam]", Formater.getDateForPrint(dxForm.getThoiDiem()));
				word.put("[chuc_danh_nguoi_ra_quyet_dinh]", KtnbUtil.getTenThuTruongCqt(appContext) + " " + appContext.getTenCqt());
				word.put("[so_quyet_dinh]", qdxm.getMaQd());
				word.put("[ngay/thang/nam_qd]", Formater.date2str(qdxm.getNgayLap()));
				word.put("[chuc_danh_nguoi_ra_quyet_dinh]", KtnbUtil.getTenThuTruongCqt(appContext) + " " + appContext.getTenCqt());

				word.put("[ngay/thang/nam_bat_dau_xac_minh]", Formater.date2str(qdxm.getTuNgayXm()));
				word.put("[ngay/thang/nam_ket_thuc_xac_minh]", Formater.date2str(qdxm.getDenNgayXm()));
				word.put("[ten_doan_xac_minh]", "Đoàn xác minh theo quyết định số " + qdxm.getMaQd());
				word.put("[nguoi_khieu_nai]", dx.getNguoiKNTC());
				word.put("[ngay/thang/nam_de_tren_don]", Formater.date2str(hdr.getDonDeNgay()));

				word.put("[quyet_dinh_hc_bi_kn]", qdxm.getNguoiBiKntcHanhVi());
				word.put("[tom_tat_noi_dung_kn]", hdr.getNoiDung());
				word.put("[nguoi_khieu_nai]", dx.getNguoiKNTC());
				word.put("[chuc_danh_nguoi_ra_quyet_dinh]", KtnbUtil.getTenThuTruongCqt(appContext));

				word.put("[truong_doan_xac_minh]", xmService.getTenTruongDoanXmByHs(appContext, maHs));
				word.saveAndClose();

				word.downloadFile(fileOut, "Mau KNTC17", ".doc", response);
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
		return null;
	}

	public ActionForward xacMinh(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String act = request.getParameter("action");
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
		BaseActionForm xmForm = (BaseActionForm) form;
		// String maHs = request.getParameter("id");
		// xmForm.setMaHoSo(maHs);
		String maHs = request.getParameter("id");
		PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
		KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
		// Nếu chưa có đề xuất xử lý
		if (dx == null)
			throw new KtnbException("C&#x1EA7;n l&#x1EAD;p &#x111;&#x1EC1; xu&#x1EA5;t x&#x1EED; l&#xFD; tr&#x1B0;&#x1EDB;c khi th&#x1EF1;c hi&#x1EC7;n x&#xE1;c minh!!!", "", "");

		SoTiepDanService stdService = new SoTiepDanService();
		KntcSoTiepDan hs = stdService.getSoTiepDan(appContext, maHs, true);
		KntcHoSoHdr hdr = hs.getHdr();
		// Hồ sơ chưa đến trạng thái 1611 TT_KNTC_XM
		if (Integer.parseInt(hdr.getTrangThai()) < Integer.parseInt(Constants.TT_KNTC_XM)) {
			throw new KtnbException("H&#7891; s&#417; ch&#432;a &#273;&#7871;n b&#432;&#7899;c x&#225;c minh!!!", "", "");
		}
		// Nếu đã kết thúc và là chuyển đơn thì không cần xem tab xác minh + kết
		// thúc
		if (Constants.TT_KNTC_KET_THUC.equals(hdr.getTrangThai()) && Constants.KNTC_KET_THUC_CHUYEN_DON.equals(hdr.getLoaiKetThuc())) {
			throw new KtnbException("H&#x1ED3; s&#x1A1; &#x111;&#xE3; chuy&#x1EC3;n v&#xE0; k&#x1EBF;t th&#xFA;c n&#xEA;n kh&#xF4;ng th&#x1EC3; th&#x1EF1;c hi&#x1EC7;n x&#xE1;c minh!!!", "", "");
		}

		if ("xacMinhKhieuNai".equals(act)) {
			// Riêng cho KN: Nếu phân loại là phải xác minh thì mới vào super
			// tab xác minh
			if ("1".equals(dx.getIsGquyetNgay().toString()))
				throw new KtnbException("H&#x1ED3; s&#x1A1; kh&#xF4;ng c&#x1EA7;n ph&#x1EA3;i x&#xE1;c minh!!!", "", "");
			this.show(map, xmForm, request, response);
			this.khxm(map, xmForm, request, response);
			this.bbKqXm(map, xmForm, request, response);
			return map.findForward("viewXacMinhKhieuNai");
		} else if ("xacMinhToCao".equals(act)) {
			this.show(map, xmForm, request, response);
			this.khxm(map, xmForm, request, response);
			this.bbKqXm(map, xmForm, request, response);
			return map.findForward("viewXacMinhToCao");
		}
		return null;
	}
}