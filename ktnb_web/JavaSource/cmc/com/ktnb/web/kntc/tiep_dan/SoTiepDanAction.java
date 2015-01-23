package cmc.com.ktnb.web.kntc.tiep_dan;

import java.io.InputStream;
import java.io.PrintWriter;
import java.text.Format;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.pl.hb.entity.KntcQdinhXm;
import cmc.com.ktnb.pl.hb.entity.KtnbDmCanbo;
import cmc.com.ktnb.pl.hb.entity.KtnbTlieuKemTheo;
import cmc.com.ktnb.service.kntc.KntcSoTiepDan;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.service.kntc.XacMinhService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.HttpUtil;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.util.URLUTF8Encoder;
import cmc.com.ktnb.vo.CategoryVO;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.catalog.CatalogService;
import cmc.com.ktnb.web.dung_chung.DungChungService;

/**
 * Form xử lý sổ tiếp dân
 * 
 * @author Ntthu
 */
public class SoTiepDanAction extends BaseDispatchAction {
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		SoTiepDanForm cnForm = (SoTiepDanForm) form;
		if (cnForm.getFirst().equals("1")) {
			// Thong tin cong dan
			cnForm.setLuotTiep("1");
			cnForm.setNgayTiep(Formater.date2str(new Date()));
			cnForm.setDonDeNgay("");
			cnForm.setThoiDiemInGbn(Formater.date2strDateTimeForNV(new Date()));
			// Sinh ma ho so
			// Thong tin can bo tiep dan
			cnForm.setCanBoMa(appContext.getMaCanbo());
			cnForm.setCanBoTen(appContext.getTenCanbo());
			cnForm.setCanBoChucVu(appContext.getTenChucvu());
			cnForm.setCanBoNoiCongTac(appContext.getTenPhong());
			cnForm.setNoiTiepDan(appContext.getTenCqt());
			// cnForm.setCanBoChucVu(appContext.getMaCanbo());
			cnForm.setIsKNTCTrucTiep("false");
			cnForm.setUyQuyen("1");
			cnForm.setLoaiKNTC("1");
			// cnForm.setMaHoSo(KtnbUtil.getMaHoSoByCqtBySeq(appContext, "KN",
			// "TD"));
			// Set default for checkbox group: hinhthuc, doankntc,Gay roi ---
			// Cuongnt
			cnForm.setHinhThuc("1");
			cnForm.setDoanKNTC("0");
			cnForm.setGayRoi("0");
			cnForm.setDoanKNTC("1");
			// saveToken(request);
		}
		/*
		 * String loaiKNTC = cnForm.getLoaiKNTC(); String tq =
		 * CatalogService.KNTC_THAM_QUYEN; String tl =
		 * request.getParameter("tq"); if (Formater.isNull(loaiKNTC)) loaiKNTC =
		 * "1"; if (loaiKNTC.equals("1")) {
		 * //cnForm.setMaHoSo(KtnbUtil.getMaHoSoByCqtBySeq(appContext, "KN",
		 * "TD")); tq = CatalogService.KNTC_THAM_QUYEN; tl =
		 * CatalogService.KNTC_THAM_QUYEN_THU_LY; } else if
		 * (loaiKNTC.equals("2")) {
		 * //cnForm.setMaHoSo(KtnbUtil.getMaHoSoByCqtBySeq(appContext, "TC",
		 * "TD")); tl = CatalogService.KNTC_THAM_QUYEN_THU_LY_TC; tq =
		 * CatalogService.KNTC_THAM_QUYEN_TC; } else if (loaiKNTC.equals("4")) {
		 * //cnForm.setMaHoSo(KtnbUtil.getMaHoSoByCqtBySeq(appContext, "CS",
		 * "TD")); // tl = CatalogService.KNTC_THAM_QUYEN_THU_LY_TC; // tq =
		 * CatalogService.KNTC_THAM_QUYEN_TC; } else {
		 * //cnForm.setMaHoSo(KtnbUtil.getMaHoSoByCqtBySeq(appContext, "KH",
		 * "TD")); tl = CatalogService.KNTC_THAM_QUYEN_THU_LY_HH; tq =
		 * CatalogService.KNTC_THAM_QUYEN_HH; } // Thuoc tham quyen ArrayList
		 * list = (ArrayList) request.getAttribute("dmtq"); if (list == null) { //
		 * Chua co trong session list = new ArrayList(); Collection dmTien =
		 * CatalogService.getDmByParentId(tq); for (Iterator iter =
		 * dmTien.iterator(); iter.hasNext();) { CategoryVO loaitien =
		 * (CategoryVO) iter.next(); list.add(new
		 * LabelValueBean(loaitien.getName(), loaitien.getId())); } }
		 * request.setAttribute("dmtq", list); tl = request.getParameter("tq"); //
		 * Thu ly don if (Formater.isNull(tl)) tl =
		 * CatalogService.KNTC_THAM_QUYEN_THU_LY; ArrayList listThuLy =
		 * (ArrayList) request.getAttribute("dmtly"); if (listThuLy == null) { //
		 * Chua co trong session listThuLy = new ArrayList(); Collection dmTien =
		 * CatalogService.getDmByParentId(tl); for (Iterator iter =
		 * dmTien.iterator(); iter.hasNext();) { CategoryVO vo = (CategoryVO)
		 * iter.next(); listThuLy.add(new LabelValueBean(vo.getName(),
		 * vo.getId())); } } request.setAttribute("dmtly", listThuLy);
		 */
		return map.findForward("success");
	}

	public ActionForward edit(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		SoTiepDanService service = new SoTiepDanService();
		String maHs = request.getParameter("id");
		KntcSoTiepDan std = service.getSoTiepDan(appContext, maHs, true);
		SoTiepDanForm stdForm = (SoTiepDanForm) form;
		stdForm.toForm(std);
		return map.findForward("success");
	}

	public ActionForward save(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// if (isTokenValid(request)) {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		SoTiepDanForm tdForm = (SoTiepDanForm) form;
		KntcSoTiepDan std = null;
		try {
			std = tdForm.toSoTiepDan(appContext);
			SoTiepDanService service = new SoTiepDanService();
			service.saveSoTiepDan(appContext, std, false);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("ghiThanhcong", "0");
			throw new Exception(e);
		}
		HttpUtil.doForward("kntc_tiep_dan.do?method=edit&id=" + std.getHdr().getMaHs(), request, response);
		// return map.findForward("success");
		// }//
		return null;
	}

	public ActionForward del(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		KntcSoTiepDan std = null;
		try {
			String maHs = request.getParameter("id");
			SoTiepDanService service = new SoTiepDanService();
			std = service.getSoTiepDan(appContext, maHs, true);
			service.delSoTiepDan(appContext, std.getHdr());
			request.setAttribute("xoaThanhcong", "1");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("xoaThanhcong", "0");
			throw new Exception(e);
		}
		HttpUtil.doForward("kntc_tim_kiem.do?method=show&action=suaHSTD", request, response);
		return null;
	}

	public ActionForward view(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		try {
			SoTiepDanForm cnForm = (SoTiepDanForm) form;
			String maHs = request.getParameter("id");
			if (!Formater.isNull(maHs)) {
				SoTiepDanService service = new SoTiepDanService();
				cnForm.toForm(service.getSoTiepDan(appContext, maHs, true));
				XacMinhService s = new XacMinhService();
				KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, cnForm.getMaHoSo());
				if (qd != null && !Formater.isNull(qd.getMaQd()))
					request.setAttribute("maQDXM", URLUTF8Encoder.encode(qd.getMaQd()));
				else
					request.setAttribute("maQDXM", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return map.findForward("view");
	}

	public ActionForward getListTlKt(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("maHs");
		if (Formater.isNull(maHs))
			return null;
		else {
			JSONObject jsonResult = new JSONObject();
			SoTiepDanService s = new SoTiepDanService();
			JSONArray jsonArray = new JSONArray();
			JSONArray ja;
			try {
				Collection listTlkt = s.getListTlkt(appContext, maHs);
				for (Iterator iter = listTlkt.iterator(); iter.hasNext();) {
					KtnbTlieuKemTheo element = (KtnbTlieuKemTheo) iter.next();
					ja = new JSONArray();
					ja.put(element.getTenTlieu());
					ja.put(element.getSoTrang());
					ja.put(element.getTinhTrang());
					// ja.put(element.getChungCu());
					jsonArray.put(ja);
				}
				jsonResult.put("aaData", jsonArray);
				response.setContentType("application/json;charset=UTF-8");
				response.setHeader("Cache-Control", "no-store");
				PrintWriter out = response.getWriter();
				out.println(jsonResult);
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ActionForward showTlkt(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		SoTiepDanForm stdForm = (SoTiepDanForm) form;
		String maHs = request.getParameter("maHs");
		if (Formater.isNull(maHs))
			return null;
		else {
			stdForm.setMaHoSo(maHs);
		}
		return mapping.findForward("success");
	}

	public ActionForward saveTlkt(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		UserTransaction tx = null;
		Session session = null;
		try {
			// BaseHibernateDAO dao = new BaseHibernateDAO();
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();
			String kt = request.getParameter("kt");
			String del = "true";
			if (!Formater.isNull(request.getParameter("kt"))) {
				del = request.getParameter("kt");
			}
			SoTiepDanForm tdForm = (SoTiepDanForm) form;
			// KntcSoTiepDan hs = tdForm.toSoTiepDan(appContext);
			SoTiepDanService service = new SoTiepDanService();
			ArrayList arr = new ArrayList();
			String[] arrTL = tdForm.arrTenTl.split("@@");
			if (arrTL != null && arrTL.length > 0) {
				for (int i = 0; i < arrTL.length; i++) {
					String[] item = arrTL[i].split(",");
					if (item != null && item.length > 0) {
						if (!Formater.isNull(item[0])) {
							KtnbTlieuKemTheo aCb = new KtnbTlieuKemTheo();
							aCb.setMaHoSo(tdForm.maHoSo);
							aCb.setLoaiTlieu(KtnbTlieuKemTheo.TLKT_SO_TIEP_DAN);
							if (!Formater.isNull(item[1]))
								aCb.setSoTrang(new Short(item[1]));
							else
								aCb.setSoTrang(new Short("0"));
							aCb.setTenTlieu(item[0]);
							aCb.setTinhTrang(item[2]);
							// aCb.setChungCu(item[3]);
							aCb.setNguoiCapNhat(appContext.getTenNsd());
							aCb.setNgayCapNhat(appContext.getSystemDate());
							arr.add(aCb);
						}
					}
				}
			}
			service.updateHsTl(appContext, tdForm.maHoSo, arr, kt, session, del);
			session.flush();
			tx.commit();
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		// HttpUtil.doForward("std_tim_kiem.do?method=show",request,response);
		return map.findForward("success");
	}

	public ActionForward inGbn_old(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		SoTiepDanForm cbForm = (SoTiepDanForm) form;
		String fileTemplate = "kntc01";
		parameters.put("CO_QUAN_THUE_TRUC_TIEP", appContext.getTenCqt());
		parameters.put("DON_VI_VIET_GIAY_BIEN_NHAN", appContext.getTenPhong());
		String maHs = request.getParameter("id");
		StringBuffer sb = new StringBuffer();
		if (Formater.isNull(maHs)) // In tu man hinh tiep dan
		{
			String[] arrCb = cbForm.getArrTenTl().split("@@");
			if (arrCb != null && arrCb.length > 0) {
				for (int i = 0; i < arrCb.length; i++) {
					String[] item = arrCb[i].split("###");
					if (item != null && item.length > 0) {
						if (!Formater.isNull(item[0])) {
							sb.append(" + " + item[0] + "; ");
							sb.append("s\u1ED1 trang: " + item[1] + "; ");
							sb.append("t\u00ECnh tr\u1EA1ng: " + item[2] + "\n");
						}
					}
				}
			}

			if (Formater.isNull(sb.toString())) {
				parameters.put("tai_lieu_chung_cu_kem_theo", "");
			} else {
				parameters.put("tai_lieu_chung_cu_kem_theo", sb.toString());
			}
			parameters.put("thoi_diem_lap_giay_bien_nhan", Formater.getDateTimeForPrint(cbForm.getThoiDiemInGbn()));
			parameters.put("dia_chi_don_vi_lap_giay_bien_nhan", cbForm.getNoiTiepDan());

			parameters.put("can_bo_lap_giay_bien_nhan", cbForm.getCanBoTen());
			parameters.put("chuc_vu", cbForm.getCanBoChucVu());
			parameters.put("bo_phan_cong_tac", cbForm.getCanBoNoiCongTac());

			if (Formater.isNull(cbForm.getCongdanTen())) {
				parameters.put("nguoi_nhan_giay_bien_nhan", "");
			} else {
				parameters.put("nguoi_nhan_giay_bien_nhan", cbForm.getCongdanTen());
			}
			if (Formater.isNull(cbForm.getCongdanDiaChi())) {
				parameters.put("dia_chi_nguoi_nhan_giay_bien_nhan", "");
			} else {
				parameters.put("dia_chi_nguoi_nhan_giay_bien_nhan", cbForm.getCongdanDiaChi());
			}

			if (cbForm.getLoaiKNTC().equals("1"))
				parameters.put("don", "Khi\u1EBFu n\u1EA1i");
			else if (cbForm.getLoaiKNTC().equals("2"))
				parameters.put("don", "T\u1ED1 c\u00E1o");
			else
				parameters.put("don", "tr\u01B0\u1EDDng h\u1EE3p kh\u00E1c");
			parameters.put("ngay_cua_don", Formater.getDateForPrint(cbForm.getDonDeNgay()));
		} else { // In tu man hinh bo sung HSTL
			SoTiepDanService s = new SoTiepDanService();
			KntcSoTiepDan std = s.getSoTiepDan(appContext, maHs, false);
			KntcHoSoHdr hdr = std.getHdr();
			sb = new StringBuffer();

			String[] arrCb = cbForm.getArrTenTl().split("@@");
			if (arrCb != null && arrCb.length > 0) {
				for (int i = 0; i < arrCb.length; i++) {
					String[] item = arrCb[i].split("###");
					if (item != null && item.length > 0) {
						if (!Formater.isNull(item[0])) {
							sb.append(" + " + item[0] + "; ");
							sb.append("s\u1ED1 trang: " + item[1] + "; ");
							sb.append("t\u00ECnh tr\u1EA1ng: " + item[2] + "\n");
						}
					}
				}
			}
			if (Formater.isNull(sb.toString())) {
				parameters.put("tai_lieu_chung_cu_kem_theo", "");
			} else {
				parameters.put("tai_lieu_chung_cu_kem_theo", sb.toString());
			}
			parameters.put("thoi_diem_lap_giay_bien_nhan", Formater.getDateTimeForPrint(Formater.date2strDateTimeForNV(new Date())));
			parameters.put("dia_chi_don_vi_lap_giay_bien_nhan", hdr.getTenCqt());

			KtnbDmCanbo aCb = KtnbUtil.getThongTinCanBo(hdr.getMaCanBo());
			parameters.put("can_bo_lap_giay_bien_nhan", hdr.getNndTen());
			parameters.put("chuc_vu", aCb.getChucVu());
			parameters.put("bo_phan_cong_tac", aCb.getTenPhong());
			if (Formater.isNull(aCb.getTen())) {
				parameters.put("nguoi_nhan_giay_bien_nhan", "");
			} else {
				parameters.put("nguoi_nhan_giay_bien_nhan", aCb.getTen());
			}
			if (Formater.isNull(hdr.getNndDiaChi())) {
				parameters.put("dia_chi_nguoi_nhan_giay_bien_nhan", "");
			} else {
				parameters.put("dia_chi_nguoi_nhan_giay_bien_nhan", hdr.getNndDiaChi());
			}
			if (hdr.getLoaiKntc().equals("1"))
				parameters.put("don", "Khi\u1EBFu n\u1EA1i");
			else if (hdr.getLoaiKntc().equals("2"))
				parameters.put("don", "T\u1ED1 c\u00E1o");
			else
				parameters.put("don", "Tr\u01B0\u1EDDng h\u1EE3p kh\u00E1c");
			parameters.put("ngay_cua_don", Formater.getDateForPrint(Formater.date2str(hdr.getNgayLap())));
		}

		InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
		KtnbUtil.printf(reportRows, fileTemplate, response, inputStream, parameters, null);
		return null;
	}

	/**
	 * Download file mau KNTC01 downloadKNTC01
	 * 
	 * @throws Exception
	 */

	
	public ActionForward inGbn(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		SoTiepDanForm cnForm = (SoTiepDanForm) form;
		String maHs = cnForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			DungChungService service = new DungChungService();
			if ("4".equals(service.getVersionDonKntc(appContext, maHs)))
				inGbnV4(map, form, request, response);
			else
				inGbnv3(map, form, request, response);
			System.out.println("Ma HS : "+service.getVersionDonKntc(appContext, maHs));
		} else
			if("4".equals(Constants.APP_DEP_VERSION))
				inGbnV4(map, form, request, response);
			else 
				inGbnv3(map, form, request, response);
		return null;
	}
	/**
	 * Des : ktnb v3
	 * */
	public ActionForward inGbnv3(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!"HEAD".equals(request.getMethod().toString().toUpperCase())) {
			String fileIn = request.getRealPath("/docin") + "\\KNTC01.doc";
			// String abc = request.getSession().getId();
			String fileOut = request.getRealPath("/docout") + "\\KNTC01_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
			SoTiepDanForm cbForm = (SoTiepDanForm) form;
			MsWordUtils word = new MsWordUtils(fileIn, fileOut);
			word.put("[CO_QUAN_THUE_TRUC_TIEP]", appContext.getTenCqt().toUpperCase());
			word.put("[DON_VI_VIET_GIAY_BIEN_NHAN]", appContext.getTenPhong().toUpperCase());
			try {
				String maHs = request.getParameter("id");
				SoTiepDanService s = new SoTiepDanService();
				KntcSoTiepDan hs = s.getSoTiepDan(appContext, maHs, true);
				// hs.getNoiDungDon().setNoiDung(dx.getDx().getNoiDung());
				KntcHoSoHdr hdr = hs.getHdr();

				StringBuffer sb = new StringBuffer();
				if (Formater.isNull(maHs)) // In tu man hinh tiep dan
				{
					if (!Formater.isNull(cbForm.getArrTenTl())) {
						String[] arrCb = cbForm.getArrTenTl().split("@@");
						if (arrCb != null && arrCb.length > 0) {
							for (int i = 0; i < arrCb.length; i++) {
								String[] item = arrCb[i].split("###");
								if (item != null && item.length > 0) {
									if (!Formater.isNull(item[0])) {
										sb.append(" + " + item[0] + "; ");
										if (!item[1].equals("") && !item[1].equals("0"))
											sb.append("s\u1ED1 trang: " + item[1] + "; ");
										sb.append("t\u00ECnh tr\u1EA1ng: " + item[2] + ".\n");
									}
								}
							}
						}
					}
					word.put("[thoi_diem_lap_giay_bien_nhan]", Formater.getDateTimeForPrint(cbForm.getThoiDiemInGbn()));
					word.put("[dia_chi_don_vi_lap_giay_bien_nhan]", cbForm.getNoiTiepDan());
					word.put("[can_bo_lap_giay_bien_nhan]", cbForm.getCanBoTen());
					word.put("[chuc_vu]", cbForm.getCanBoChucVu());
					word.put("[bo_phan_cong_tac]", cbForm.getCanBoNoiCongTac());
					if (Formater.isNull(cbForm.getCongdanTen()))
						word.put("[nguoi_nhan_giay_bien_nhan]", KtnbUtil.inFieldNull(102));
					else
						word.put("[nguoi_nhan_giay_bien_nhan]", cbForm.getCongdanTen());
					if (Formater.isNull(cbForm.getCongdanDiaChi()))
						word.put("[dia_chi_nguoi_nhan_giay_bien_nhan]", KtnbUtil.inFieldNull(108));
					else
						word.put("[dia_chi_nguoi_nhan_giay_bien_nhan]", cbForm.getCongdanDiaChi());

					if (cbForm.getLoaiKNTC().equals("1"))
						word.put("[don]", "Khi\u1EBFu n\u1EA1i");
					else if (cbForm.getLoaiKNTC().equals("2"))
						word.put("[don]", "T\u1ED1 c\u00E1o");
					else
						word.put("[don]", "tr\u01B0\u1EDDng h\u1EE3p kh\u00E1c");

					word.put("[ngay_cua_don]", Formater.getDateForPrint(cbForm.getDonDeNgay()));
					try {
						if (Formater.isNull(sb.toString())) {
							word.put("[tai_lieu_chung_cu_kem_theo]", KtnbUtil.inFieldNull(68));
						} else {
							word.put("[tai_lieu_chung_cu_kem_theo]", "\n" + sb.toString().substring(0, sb.toString().length() - 1));
						}
					} catch (Exception ex) {
						word.put("[tai_lieu_chung_cu_kem_theo]", "......");
					}
					if (Formater.isNull(cbForm.getCongdanTen())) {
						word.put("[nguoi_nhan_giay_bien_nhan]", "");
					} else {
						word.put("[nguoi_nhan_giay_bien_nhan]", cbForm.getCongdanTen());
					}
					word.put("[can_bo_lap_giay_bien_nhan]", cbForm.getCanBoTen());
				} else { // In tu man hinh bo sung HSTL
					// SoTiepDanService s = new SoTiepDanService();
					// KntcSoTiepDan std = s.getSoTiepDan(appContext, maHs,
					// false);
					// KntcHoSoHdr hdr = std.getHdr();
					sb = new StringBuffer();
					if (!Formater.isNull(cbForm.getArrTenTl())) {
						String[] arrCb = cbForm.getArrTenTl().split("@@");
						if (arrCb != null && arrCb.length > 0) {
							for (int i = 0; i < arrCb.length; i++) {
								String[] item = arrCb[i].split("%%");
								if (item != null && item.length > 0) {
									if (!Formater.isNull(item[0])) {
										sb.append(" + " + item[0] + "; ");
										if (!item[1].equals("") && !item[1].equals("0"))
											sb.append("s\u1ED1 trang: " + item[1] + "; ");
										sb.append("t\u00ECnh tr\u1EA1ng: " + item[2] + ".\n");
									}
								}
							}
						}
					}
					word.put("[thoi_diem_lap_giay_bien_nhan]", Formater.getDateTimeForPrint(Formater.date2strDateTimeForNV(new Date())));
					word.put("[dia_chi_don_vi_lap_giay_bien_nhan]", hdr.getTenCqt());

					KtnbDmCanbo aCb = KtnbUtil.getThongTinCanBo(hdr.getMaCanBo());
					word.put("[can_bo_lap_giay_bien_nhan]", aCb.getTen());
					word.put("[chuc_vu]", aCb.getChucVu());
					word.put("[bo_phan_cong_tac]", aCb.getTenPhong());
					if (Formater.isNull(aCb.getTen())) {
						word.put("[nguoi_nhan_giay_bien_nhan]", KtnbUtil.inFieldNull(102));
					} else {
						word.put("[nguoi_nhan_giay_bien_nhan]", hdr.getNndTen());
					}
					if (Formater.isNull(hdr.getNndDiaChi())) {
						word.put("[dia_chi_nguoi_nhan_giay_bien_nhan]", KtnbUtil.inFieldNull(108));
					} else {
						word.put("[dia_chi_nguoi_nhan_giay_bien_nhan]", hdr.getNndDiaChi());
					}
					if (hdr.getLoaiKntc().equals("1"))
						word.put("[don]", "Khi\u1EBFu n\u1EA1i");
					else if (hdr.getLoaiKntc().equals("2"))
						word.put("[don]", "T\u1ED1 c\u00E1o");
					else
						word.put("[don]", "Tr\u01B0\u1EDDng h\u1EE3p kh\u00E1c");
					word.put("[ngay_cua_don]", Formater.getDateForPrint(Formater.date2str(hdr.getNgayLap())));
					if (Formater.isNull(sb.toString())) {
						word.put("[tai_lieu_chung_cu_kem_theo]", KtnbUtil.inFieldNull(68));
					} else {
						word.put("[tai_lieu_chung_cu_kem_theo]", "\n" + sb.toString().substring(0, sb.toString().length() - 1));
					}
					if (Formater.isNull(aCb.getTen())) {
						word.put("[nguoi_nhan_giay_bien_nhan]", "");
					} else {
						word.put("[nguoi_nhan_giay_bien_nhan]", hdr.getNndTen());
					}
					word.put("[can_bo_lap_giay_bien_nhan]", aCb.getTen());
				}
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau KNTC01", ".doc", response);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					word.saveAndClose();
				} catch (Exception ex) {
				}
			}
			return null;
		}
		return null;
	}

	/**
	 * Edit : ntmanh 
	 * Method : inGbn
	 * Des : ktnb v4
	 * */
	public ActionForward inGbnV4(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!"HEAD".equals(request.getMethod().toString().toUpperCase())) {
			String fileIn = request.getRealPath("/docin/v4") + "\\TCD01.doc";
			// String abc = request.getSession().getId();
			String fileOut = request.getRealPath("/docout") + "\\TCD01_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
			SoTiepDanForm cbForm = (SoTiepDanForm) form;
			MsWordUtils word = new MsWordUtils(fileIn, fileOut);
			word.put("[CO_QUAN_THUE_TRUC_TIEP]", appContext.getTenCqt().toUpperCase());
			word.put("[DON_VI_VIET_GIAY_BIEN_NHAN]", appContext.getTenPhong().toUpperCase());
			try {
				String maHs = request.getParameter("id");
				SoTiepDanService s = new SoTiepDanService();
				KntcSoTiepDan hs = s.getSoTiepDan(appContext, maHs, true);
				// hs.getNoiDungDon().setNoiDung(dx.getDx().getNoiDung());
				KntcHoSoHdr hdr = hs.getHdr();

				StringBuffer sb = new StringBuffer();
				if (Formater.isNull(maHs)) // In tu man hinh tiep dan
				{
					if (!Formater.isNull(cbForm.getArrTenTl())) {
						String[] arrCb = cbForm.getArrTenTl().split("@@");
						if (arrCb != null && arrCb.length > 0) {
							for (int i = 0; i < arrCb.length; i++) {
								String[] item = arrCb[i].split("###");
								if (item != null && item.length > 0) {
									if (!Formater.isNull(item[0])) {
										sb.append(" + " + item[0] + "; ");
										if (!item[1].equals("") && !item[1].equals("0"))
											sb.append("s\u1ED1 trang: " + item[1] + "; ");
										sb.append("t\u00ECnh tr\u1EA1ng: " + item[2] + ".\n");
									}
								}
							}
						}
					}
					word.put("[thoi_diem_lap_giay_bien_nhan]", Formater.getDateTimeForPrint(cbForm.getThoiDiemInGbn()));
					word.put("[dia_chi_don_vi_lap_giay_bien_nhan]", cbForm.getNoiTiepDan());
					word.put("[can_bo_lap_giay_bien_nhan]", cbForm.getCanBoTen());
					word.put("[chuc_vu]", cbForm.getCanBoChucVu());
					word.put("[bo_phan_cong_tac]", cbForm.getCanBoNoiCongTac());
					if (Formater.isNull(cbForm.getCongdanTen()))
						word.put("[nguoi_nhan_giay_bien_nhan]", KtnbUtil.inFieldNull(102));
					else
						word.put("[nguoi_nhan_giay_bien_nhan]", cbForm.getCongdanTen());
					if (Formater.isNull(cbForm.getCongdanDiaChi()))
						word.put("[dia_chi_nguoi_nhan_giay_bien_nhan]", KtnbUtil.inFieldNull(108));
					else
						word.put("[dia_chi_nguoi_nhan_giay_bien_nhan]", cbForm.getCongdanDiaChi());

					if (cbForm.getLoaiKNTC().equals("1"))
						word.put("[don]", "Khi\u1EBFu n\u1EA1i");
					else if (cbForm.getLoaiKNTC().equals("2"))
						word.put("[don]", "T\u1ED1 c\u00E1o");
					else
						word.put("[don]", "tr\u01B0\u1EDDng h\u1EE3p kh\u00E1c");

					word.put("[ngay_cua_don]", Formater.getDateForPrint(cbForm.getDonDeNgay()));
					try {
						if (Formater.isNull(sb.toString())) {
							word.put("[tai_lieu_chung_cu_kem_theo]", KtnbUtil.inFieldNull(68));
						} else {
							word.put("[tai_lieu_chung_cu_kem_theo]", "\n" + sb.toString().substring(0, sb.toString().length() - 1));
						}
					} catch (Exception ex) {
						word.put("[tai_lieu_chung_cu_kem_theo]", "......");
					}
					if (Formater.isNull(cbForm.getCongdanTen())) {
						word.put("[nguoi_nhan_giay_bien_nhan]", "");
					} else {
						word.put("[nguoi_nhan_giay_bien_nhan]", cbForm.getCongdanTen());
					}
					word.put("[can_bo_lap_giay_bien_nhan]", cbForm.getCanBoTen());
				} else { // In tu man hinh bo sung HSTL
					// SoTiepDanService s = new SoTiepDanService();
					// KntcSoTiepDan std = s.getSoTiepDan(appContext, maHs,
					// false);
					// KntcHoSoHdr hdr = std.getHdr();
					sb = new StringBuffer();
					if (!Formater.isNull(cbForm.getArrTenTl())) {
						String[] arrCb = cbForm.getArrTenTl().split("@@");
						if (arrCb != null && arrCb.length > 0) {
							for (int i = 0; i < arrCb.length; i++) {
								String[] item = arrCb[i].split("%%");
								if (item != null && item.length > 0) {
									if (!Formater.isNull(item[0])) {
										sb.append(" + " + item[0] + "; ");
										if (!item[1].equals("") && !item[1].equals("0"))
											sb.append("s\u1ED1 trang: " + item[1] + "; ");
										sb.append("t\u00ECnh tr\u1EA1ng: " + item[2] + ".\n");
									}
								}
							}
						}
					}
					word.put("[thoi_diem_lap_giay_bien_nhan]", Formater.getDateTimeForPrint(Formater.date2strDateTimeForNV(new Date())));
					word.put("[dia_chi_don_vi_lap_giay_bien_nhan]", hdr.getTenCqt());

					KtnbDmCanbo aCb = KtnbUtil.getThongTinCanBo(hdr.getMaCanBo());
					word.put("[can_bo_lap_giay_bien_nhan]", aCb.getTen());
					word.put("[chuc_vu]", aCb.getChucVu());
					word.put("[bo_phan_cong_tac]", aCb.getTenPhong());
					if (Formater.isNull(aCb.getTen())) {
						word.put("[nguoi_nhan_giay_bien_nhan]", KtnbUtil.inFieldNull(102));
					} else {
						word.put("[nguoi_nhan_giay_bien_nhan]", hdr.getNndTen());
					}
					if (Formater.isNull(hdr.getNndDiaChi())) {
						word.put("[dia_chi_nguoi_nhan_giay_bien_nhan]", KtnbUtil.inFieldNull(108));
					} else {
						word.put("[dia_chi_nguoi_nhan_giay_bien_nhan]", hdr.getNndDiaChi());
					}
					if (hdr.getLoaiKntc().equals("1"))
						word.put("[don]", "Khi\u1EBFu n\u1EA1i");
					else if (hdr.getLoaiKntc().equals("2"))
						word.put("[don]", "T\u1ED1 c\u00E1o");
					else
						word.put("[don]", "Tr\u01B0\u1EDDng h\u1EE3p kh\u00E1c");
					word.put("[ngay_cua_don]", Formater.getDateForPrint(Formater.date2str(hdr.getNgayLap())));
					if (Formater.isNull(sb.toString())) {
						word.put("[tai_lieu_chung_cu_kem_theo]", KtnbUtil.inFieldNull(68));
					} else {
						word.put("[tai_lieu_chung_cu_kem_theo]", "\n" + sb.toString().substring(0, sb.toString().length() - 1));
					}
					if (Formater.isNull(aCb.getTen())) {
						word.put("[nguoi_nhan_giay_bien_nhan]", "");
					} else {
						word.put("[nguoi_nhan_giay_bien_nhan]", hdr.getNndTen());
					}
					word.put("[can_bo_lap_giay_bien_nhan]", aCb.getTen());
				}
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TCD01", ".doc", response);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					word.saveAndClose();
				} catch (Exception ex) {
				}
			}
			return null;
		}
		return null;
	}
}
