package cmc.com.ktnb.web.kntc.ket_qua;

import java.io.InputStream;
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

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KntcBCKQThucHienQDKN;
import cmc.com.ktnb.pl.hb.entity.KntcDeXuatXly;
import cmc.com.ktnb.pl.hb.entity.KntcDmRls;
import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.pl.hb.entity.KntcKquaXmDtl;
import cmc.com.ktnb.pl.hb.entity.KntcKqxmKluatKnghi;
import cmc.com.ktnb.pl.hb.entity.KntcQdinhGquyet;
import cmc.com.ktnb.pl.hb.entity.KntcQdinhXm;
import cmc.com.ktnb.pl.hb.entity.KntcXmBaoCaoKq;
import cmc.com.ktnb.service.kntc.KntcSoTiepDan;
import cmc.com.ktnb.service.kntc.KntcXacMinh;
import cmc.com.ktnb.service.kntc.PhanLoaiXuLyService;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.service.kntc.XacMinhService;
import cmc.com.ktnb.service.kntc.XuLyKNTCService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HttpUtil;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.kntc.xu_ly.LichTrinhDuKienAction;

/**
 * Xu ly Bao cao ket qua xac minh
 * 
 * @author Ntthu - CMCSOFT
 * @author Dhphuc- CMCSOFT
 * @since 18/03/2011
 */
public class BaoCaoKetQuaXacMinh extends BaseDispatchAction {
	/**
	 * Hiển thị mẫu 18/KNTC 
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward baocao(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		KetQuaXmForm kqForm = (KetQuaXmForm) form;
		String maHs = request.getParameter("id");
		kqForm.setMaHoSo(maHs);
		if (!Formater.isNull(maHs)) {
			kqForm.setMaHidden(maHs);
			XacMinhService s = new XacMinhService();
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			KntcKqxmKluatKnghi kq = s.getKqxmKluatKnghiByMaHs(appContext, maHs);
			if (kq == null) { // Tao moi
				KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, maHs);
				SoTiepDanService stdS = new SoTiepDanService();
				KntcSoTiepDan std = stdS.getSoTiepDan(appContext, maHs, true);

				if ("0".equals(dx.getIsGquyetNgay().toString())) {
					if (qd == null || qd.getNgayDuyet() == null) {
						throw new KtnbException("Ch&#x1B0;a c&#xF3; Quy&#x1EBF;t &#x111;&#x1ECB;nh x&#xE1;c minh, ho&#x1EB7;c Q&#x110;XM ch&#x1B0;a &#x111;&#x1B0;&#x1EE3;c duy&#x1EC7;t!", "",
								"C&#7847;n ho&#224;n thi&#7879;n Quy&#7871;t &#273;&#7883;nh x&#225;c minh tr&#432;&#7899;c khi l&#224;m c&#225;c bi&#7875;u m&#7851;u ti&#7871;p theo!");
					}
					if (s.getKntcKquaGquyetByHs(appContext, maHs) == null) {
						throw new KtnbException(
								"Ch&#432;a c&#243; b&#225;o c&#225;o k&#7871;t qu&#7843; x&#225;c minh m&#7851;u 17/KNTC!",
								"",
								"C&#7847;n l&#7853;p b&#225;o c&#225;o k&#7871;t qu&#7843; x&#225;c minh m&#7851;u 17/KNTC tr&#432;&#7899;c khi l&#7853;p m&#7851;u b&#225;o c&#225;o k&#7871;t qu&#7843; gi&#7843;i quy&#7871;t 18/KNTC!");
					}
				}

				KntcXmBaoCaoKq bcKqXm = s.getKntcKquaGquyetByHs(appContext, maHs);
				if (bcKqXm != null) {
					// kqForm.setKienNghi(bcKqXm.getKienNghi());
					kqForm.setKetQuaXm("K&#7871;t qu&#7843; x&#225;c minh: <br>" + bcKqXm.getKetQuaXm() + "<br>Ki&#7871;n ngh&#7883;: <br>" + bcKqXm.getKienNghi());
					kqForm.setNoiDungDon(bcKqXm.getNoiDungKn());
				}

				if (qd != null) // Co xac minh
				{
					kqForm.setSoQd(qd.getMaQd());
					kqForm.setNoiDungViPham(qd.getNguoiBiKntcHanhVi());
				}

				//kqForm.setThoiDiem(Formater.date2str(new Date()));
				kqForm.setNoiDungDon(dx.getNoiDung());
				kqForm.setTuNgay(Formater.date2str(std.getHdr().getCongVanDenNgay()));
				kqForm.setDenNgay(Formater.date2str(LichTrinhDuKienAction.getNgayKetThuc(maHs, request)));
				kqForm.setPhanTichKq("0");
			} else {
				kqForm.fromEntity(kq);
			}
		}
		// saveToken(request);
		return map.findForward("baocao");
	}

	/**
	 * Lưu mẫu 18/KNTC và 24/KNTC
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveBaoCao(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String maHs = request.getParameter("id");
		KetQuaXmForm cnForm = (KetQuaXmForm) form;
		boolean isKN = SoTiepDanService.isKN(appContext, cnForm.getMaHoSo());
		try {
			if (Formater.isNull(maHs))
				maHs = cnForm.getMaHoSo();
			KntcKqxmKluatKnghi qd = cnForm.toKqxmKluatKnghi(appContext);
			XacMinhService s = new XacMinhService();
			s.saveKqxmKluatKnghi(appContext, qd);
			request.setAttribute(isKN ? "ghiThanhcong_18" : "ghiThanhcong_24", "1");
		} catch (Exception e) {
			request.setAttribute(isKN ? "ghiThanhcong_18" : "ghiThanhcong_24", "1");
			e.printStackTrace();
			throw e;
		}
		if (isKN)
			HttpUtil.doForward("kntc_kq_xm.do?method=ketThuc&action=ketThucKhieuNai&id=" + cnForm.getMaHoSo(), request, response);
		else
			HttpUtil.doForward("kntc_kq_xm.do?method=ketThuc&action=ketThucToCao&id=" + cnForm.getMaHoSo(), request, response);
		return null;
	}

	/***************************************************************************
	 * Hiển thị mẫu 23/KNTC
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward bcKqXmTc(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		KetQuaXmTcForm cnForm = (KetQuaXmTcForm) form;
		String maHs = request.getParameter("id");
		XacMinhService s = new XacMinhService();
		KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, maHs);
		if (qd == null || qd.getNgayDuyet() == null) {
			throw new KtnbException("Ch&#x1B0;a c&#xF3; Quy&#x1EBF;t &#x111;&#x1ECB;nh x&#xE1;c minh, ho&#x1EB7;c Q&#x110;XM ch&#x1B0;a &#x111;&#x1B0;&#x1EE3;c duy&#x1EC7;t!", "",
					"C&#7847;n ho&#224;n thi&#7879;n Quy&#7871;t &#273;&#7883;nh x&#225;c minh tr&#432;&#7899;c khi l&#224;m c&#225;c bi&#7875;u m&#7851;u ti&#7871;p theo!");
		}
		String maQd = qd.getMaQd();
		PhanLoaiXuLyService plS = new PhanLoaiXuLyService();
		if (!Formater.isNull(maQd)) {
			KntcKqxmKluatKnghi kq = s.getKqxmKluatKnghiByMaHs(appContext, maHs, KntcKqxmKluatKnghi.LOAI_BC_KQ_XM_TC);
			if (kq == null) { // Tao moi
				// KntcQdinhXm qdXm = s.getKntcQdinhXmByHoSo(appContext, maHs);
				cnForm.setMaHoSo(maHs);
				// cnForm.setMaHidden(maHs);
				cnForm.setSoQd(maQd);
				PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
				KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);

				// if (s.getBienBanByHoSo(appContext, maHs,
				// KntcBienBan.BB_CONG_BO_QDXM_TC) == null)
				// throw new KtnbException(
				// "Ch&#432;a c&#243; bi&#234;n b&#7843;n c&#244;ng b&#7889;
				// Quy&#7871;t &#273;&#7883;nh x&#225;c minh m&#7851;u
				// 12/KNTC!",
				// "",
				// "C&#7847;n l&#7853;p bi&#234;n b&#7843;n c&#244;ng b&#7889;
				// Quy&#7871;t &#273;&#7883;nh x&#225;c minh tr&#432;&#7899;c
				// khi th&#7921;c hi&#7879;n c&#225;c m&#7851;u trong qu&#225;
				// tr&#236;nh x&#225;c minh!");

				cnForm.setNoiDungDon(dx.getNoiDung());
				//cnForm.setThoiDiem(Formater.date2str(new Date()));

				// Lay thong tin noi dung
				Collection arrDm = plS.getDmRlsByHoSo(appContext, maHs, KntcDmRls.KE_HOACH_XAC_MINH);
				if (!Formater.isNull(arrDm)) {
					KntcKquaXmDtl[] arrNd = new KntcKquaXmDtl[arrDm.size()];
					int i = 0;
					for (Iterator iter = arrDm.iterator(); iter.hasNext();) {
						KntcDmRls aDm = (KntcDmRls) iter.next();
						arrNd[i] = new KntcKquaXmDtl(aDm);
						arrNd[i]
								.setNhanXet("1.N\u1ED9i dung nh\u1EEFng t\u00E0i li\u1EC7u, b\u1EB1ng ch\u1EE9ng ng\u01B0\u1EDDi t\u1ED1 c\u00E1o cung c\u1EA5p \u0111\u1EC3 ch\u1EE9ng minh h\u00E0nh vi vi ph\u1EA1m \n\n 2.N\u1ED9i dung nh\u1EEFng t\u00E0i li\u1EC7u, b\u1EB1ng ch\u1EE9ng kh\u00E1c do ng\u01B0\u1EDDi x\u00E1c minh t\u1ED1 c\u00E1o thu th\u1EADp \u0111\u01B0\u1EE3c c\u00F3 \u00FD ngh\u0129a trong vi\u1EC7c ch\u1EE9ng minh t\u00EDnh \u0111\u00FAng, sai c\u1EE7a h\u00E0nh vi b\u1ECB t\u1ED1 c\u00E1o \n\n 3.N\u1ED9i dung gi\u1EA3i tr\u00ECnh c\u1EE7a ng\u01B0\u1EDDi b\u1ECB t\u1ED1 c\u00E1o \n\n 4.N\u1ED9i dung nh\u1EEFng t\u00E0i li\u1EC7u, b\u1EB1ng ch\u1EE9ng ng\u01B0\u1EDDi b\u1ECB t\u1ED1 c\u00E1o cung c\u1EA5p ch\u1EE9ng minh t\u00EDnh \u0111\u00FAng, sai c\u1EE7a h\u00E0nh vi b\u1ECB t\u1ED1 c\u00E1o\n\n 5.Nh\u1EADn x\u00E9t, \u0111\u00E1nh gi\u00E1 v\u1EC1 n\u1ED9i dung t\u1ED1 c\u00E1o\n\n");
						i++;
					}
					cnForm.setArrNd(arrNd);
				}
				cnForm.setPhanTichKq("0");
			} else {
				cnForm.fromEntity(kq);
				Collection listDtl = s.getListKqxmDtl(appContext, maQd, KntcKquaXmDtl.BAO_CAO_XAC_MINH_TC);
				if (!Formater.isNull(listDtl)) {
					KntcKquaXmDtl[] arrDm = new KntcKquaXmDtl[listDtl.size()];
					int i = 0;
					for (Iterator iter = listDtl.iterator(); iter.hasNext();) {
						arrDm[i] = (KntcKquaXmDtl) iter.next();
						i++;
					}
					cnForm.setArrNd(arrDm);
				}
			}
		}
		saveToken(request);
		return map.findForward("bcKqXmTc");
	}

	/***************************************************************************
	 * Lưu mẫu 23/KNTC
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveBcKqXmTc(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		if (isTokenValid(request, true)) {
			try {
				KetQuaXmTcForm cnForm = (KetQuaXmTcForm) form;
				KntcXacMinh qd = cnForm.toBcKqXacMinhTC(appContext);
				XacMinhService s = new XacMinhService();
				s.saveBaoCaoKetQuaXacMinhTC(appContext, qd);
				request.setAttribute("ghiThanhcong", "1");
			} catch (Exception e) {
				request.setAttribute("ghiThanhcong", "0");
				e.printStackTrace();
				throw new Exception(e);
			}
		}
		return map.findForward("bcKqXmTc");
	}

	/**
	 * Hiển thị mẫu 24/KNTC
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward klndtc(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		KetQuaXmForm cnForm = (KetQuaXmForm) form;
		String maHs = request.getParameter("id");
		String maQd = "";
		if (!Formater.isNull(maHs)) {
			XacMinhService xacMinhService = new XacMinhService();
			KntcQdinhXm xm = xacMinhService.getKntcQdinhXmByHoSo(appContext, maHs);
			if (xm == null) {
				throw new KtnbException("Ch&#432;a c&#243; b&#225;o c&#225;o k&#7871;t qu&#7843; x&#225;c minh m&#7851;u 23/KNTC!", "",
						"C&#7847;n l&#7853;p b&#225;o c&#225;o k&#7871;t qu&#7843; x&#225;c minh m&#7851;u 23/KNTC tr&#432;&#7899;c khi l&#7853;p m&#7851;u k&#7871;t lu&#7853;n n&#7897;i dung TC 24/KNTC!");
			}
			maQd = xm.getMaQd();
			// KntcKqxmKluatKnghi kq =
			// xacMinhService.getKqxmKluatKnghiByMaHs(appContext, maHs,
			// KntcKqxmKluatKnghi.LOAI_KET_LUAN_TC);
			KntcKqxmKluatKnghi kq = xacMinhService.getKqxmKluatKnghiByMaHs(appContext, maHs, null);
			if (kq == null) { // Tao moi
				cnForm.setMaHoSo(maHs);
				cnForm.setSoQd(maQd);
				if (xacMinhService.getBaoCaoKetQuaXacMinhByMaHs(appContext, maHs) == null) {
					throw new KtnbException("Ch&#432;a c&#243; b&#225;o c&#225;o k&#7871;t qu&#7843; x&#225;c minh m&#7851;u 23/KNTC!", "",
							"C&#7847;n l&#7853;p b&#225;o c&#225;o k&#7871;t qu&#7843; x&#225;c minh m&#7851;u 23/KNTC tr&#432;&#7899;c khi l&#7853;p m&#7851;u k&#7871;t lu&#7853;n n&#7897;i dung TC 24/KNTC!");
				}
				//cnForm.setThoiDiem(Formater.date2str(new Date()));
				cnForm.setMaKq(KtnbUtil.getMaNvu(appContext, "KL"));
				cnForm.setPhanTichKq("1");
				cnForm.setDiaDiem(appContext.getDiaBan());
			} else {
				cnForm.fromEntity(kq);
			}
		}
		return map.findForward("klndtc");
	}

	/**
	 * Lưu mẫu 24/KNTC
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveKetLuanTc(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		try {
			KetQuaXmTcForm cnForm = (KetQuaXmTcForm) form;
			KntcXacMinh qd = cnForm.toKetLuanTC(appContext);
			XacMinhService s = new XacMinhService();
			s.saveKetLuanTC(appContext, qd);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw e;
		}
		return map.findForward("ketLuanTc");
	}

	/***************************************************************************
	 * Tải file cũ 18/KNTC
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward download_18_old(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		KetQuaXmForm dxForm = (KetQuaXmForm) form;
		String maHs = dxForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			SoTiepDanService stdService = new SoTiepDanService();
			KntcSoTiepDan std = stdService.getSoTiepDan(appContext, maHs, true);
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			KntcHoSoHdr hdr = std.getHdr();
			// In mau 18
			String fileTemplate = "kntc18";
			parameters.put("co_quan_giai_quyet_khieu_nai", appContext.getTenCqt());
			parameters.put("bo_phan_duoc_giao_xu_ly_don", appContext.getTenPhong());
			String ngayLap = "";
			if (Formater.isNull(dxForm.getThoiDiem())) {
				ngayLap = "ng\u00E0y    th\u00E1ng    n\u0103m        ";
			} else
				ngayLap = Formater.getDateForPrint(dxForm.getThoiDiem());
			parameters.put("ngay_lap_quyet_dinh", dxForm.getDiaDiem() + ", " + ngayLap);
			parameters.put("thu_truong_co_quan_giai_quyet_khieu_nai", KtnbUtil.getTenThuTruongCqt(appContext));
			if (dxForm.getSoQd() != null)
				parameters.put("doan_xac_minh_qd_so", dxForm.getSoQd());
			else
				parameters.put("doan_xac_minh_qd_so", "");
			parameters.put("ngay_bao_cao_kq_xac_minh", Formater.getDateForPrint(dxForm.getThoiDiem()));
			XacMinhService s = new XacMinhService();
			KntcQdinhXm kh = s.getKntcQdinhXmByHoSo(appContext, maHs);
			parameters.put("tu_ngay", Formater.getDateForPrint(dxForm.getTuNgay()));
			parameters.put("den_ngay", Formater.getDateForPrint(dxForm.getTuNgay()));
			if (kh != null)
				parameters.put("ngay_ra_quyet_dinh", Formater.getDateForPrint(Formater.date2str(kh.getNgayLap())));
			parameters.put("ket_qua_giai_quyet", dxForm.getKetQuaXm());
			// parameters.put("kien_nghi", dxForm.getKienNghi());

			parameters.put("nguoi_co_quan_don_vi_khieu_nai", dx.getNguoiKNTC());
			parameters.put("don_cong_van_de_ngay", Formater.getDateForPrint(Formater.date2str(hdr.getNgayTiep())));
			parameters.put("hanh_vi_bi_khieu_nai", dx.getNguoiBiKNTC());
			parameters.put("tom_tat_noi_dung_khieu_nai", dxForm.getNoiDungDon());
			parameters.put("ten_bo_phan", appContext.getTenPhong());
			parameters.put("ten_truong_bo_phan", appContext.getTenTruongPhong());
			parameters.put("ngay_truong_bo_phan_ky", Formater.getDateForPrintUpper(dxForm.getNgayKy()));
			parameters.put("tt_cqt", appContext.getTenCqt());
			// parameters.put("ten_thu_truong", appContext.getTenThuTruong());
			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
			KtnbUtil.printf(reportRows, fileTemplate, response, inputStream, parameters, null);
		}
		return null;
	}

	/***************************************************************************
	 * Tải file 18/KNTC
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward download_18(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileIn = request.getRealPath("/docin") + "\\KNTC18.doc";
		String fileOut = request.getRealPath("/docout") + "\\KNTC18_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		KetQuaXmForm dxForm = (KetQuaXmForm) form;
		String maHs = dxForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			SoTiepDanService stdService = new SoTiepDanService();
			KntcSoTiepDan std = stdService.getSoTiepDan(appContext, maHs, true);
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			KntcHoSoHdr hdr = std.getHdr();
			// In mau 18
			String fileTemplate = "kntc18";

			MsWordUtils word = new MsWordUtils(fileIn, fileOut);
			try {
				word.put("[co_quan_giai_quyet_khieu_nai]", appContext.getTenCqt().toUpperCase());
				word.put("[bo_phan_duoc_giao_xu_ly_don]", appContext.getTenPhong().toUpperCase());
				String ngayLap = "";
				if (Formater.isNull(dxForm.getThoiDiem())) {
					ngayLap = "ng\u00E0y.......th\u00E1ng......n\u0103m........";
				} else
					ngayLap = Formater.getDateForPrint(dxForm.getThoiDiem());
				if (Formater.isNull(dxForm.getDiaDiem()))
					word.put("[ngay_lap_quyet_dinh]", "......., " + ngayLap);
				else
					word.put("[ngay_lap_quyet_dinh]", dxForm.getDiaDiem() + ", " + ngayLap);
				word.put("[thu_truong_co_quan_giai_quyet_khieu_nai]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
				word.put("[ngay_bao_cao_kq_xac_minh]", Formater.getDateForPrint(dxForm.getThoiDiem()));
				if (dxForm.getSoQd() != null)
					word.put("[doan_xac_minh_qd_so]", dxForm.getSoQd());
				else
					word.put("[doan_xac_minh_qd_so]", "......");
				word.put("[thu_truong_co_quan_giai_quyet_khieu_nai]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
				XacMinhService s = new XacMinhService();
				KntcQdinhXm kh = s.getKntcQdinhXmByHoSo(appContext, maHs);
				if (kh != null)
					word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(Formater.date2str(kh.getNgayLap())));
				else
					word.put("[ngay_ra_quyet_dinh]", "");
				word.put("[thu_truong_co_quan_giai_quyet_khieu_nai]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
				word.put("[bo_phan_duoc_giao_xu_ly_don]", appContext.getTenPhong());
				word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
				word.put("[de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
				word.put("[hanh_vi_bi_khieu_nai]", dx.getNguoiBiKNTC());
				// word.put("[tom_tat_noi_dung_khieu_nai]",
				// dxForm.getNoiDungDon());
				word.put("[tom_tat_noi_dung_khieu_nai]", dx.getNoiDungKNTC());
				word.put("[bo_phan_duoc_giao_xu_ly_don]", appContext.getTenPhong());
				word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
				word.put("[thu_truong_co_quan_giai_quyet_khieu_nai]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
				word.put("[ngay_truong_bo_phan_ky]", Formater.getDateForPrintUpper(dxForm.getNgayKy()));
				word.put("[ten_bo_phan]", appContext.getTenPhong().toUpperCase());
				word.put("[ten_truong_bo_phan]", appContext.getTenTruongPhong());
				// word.put("[don_cong_van_de_ngay]",
				// Formater.getDateForPrint(Formater.date2str(hdr.getNgayTiep())));
				// word.put("[tt_cqt]", appContext.getTenCqt());
				// word.put("[ten_thu_truong]", appContext.getTenThuTruong());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau KNTC18", ".doc", response);
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

	/***************************************************************************
	 * Tải file 19/KNTC
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward inBcKqXmTc(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		KetQuaXmTcForm dxForm = (KetQuaXmTcForm) form;
		String maHs = dxForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			SoTiepDanService stdService = new SoTiepDanService();
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			KntcSoTiepDan std = stdService.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = std.getHdr();
			// In mau 23
			String fileTemplate = "kntc23";
			parameters.put("co_quan_ra_quyet_dinh_xac_minh", appContext.getTenCqt());
			parameters.put("ten_co_quan_thue_ra_quyet_dinh", appContext.getTenCqt());
			parameters.put("quyet_dinh_so", dxForm.getSoQd());
			String ngayLap = "";
			if (Formater.isNull(dxForm.getThoiDiem())) {
				ngayLap = "ng\u00E0y    th\u00E1ng    n\u0103m        ";
			} else
				ngayLap = Formater.getDateForPrint(dxForm.getThoiDiem());
			parameters.put("ngay_lap_bao_cao", dxForm.getDiaDiem() + ", " + ngayLap);

			parameters.put("thu_truong_co_quan_giai_quyet_khieu_nai", KtnbUtil.getTenThuTruongCqt(appContext));
			parameters.put("doan_to_xac_minh_quyet_dinh_so", dxForm.getSoQd());

			parameters.put("ngay_bao_cao_kq_xac_minh", Formater.getDateForPrint(dxForm.getThoiDiem()));
			XacMinhService s = new XacMinhService();
			KntcQdinhXm kh = s.getKntcQdinhXmByHoSo(appContext, maHs);
			parameters.put("tu_ngay", Formater.date2str(kh.getTuNgayXm()));
			parameters.put("den_ngay", Formater.date2str(kh.getDenNgayXm()));

			// KntcNdungDon don = std.getNoiDungDon();
			parameters.put("ten_nguoi_to_cao", dx.getNguoiKNTC());
			parameters.put("nam_sinh_nguoi_to_cao", "");
			parameters.put("so_cmnd_nguoi_to_cao", hdr.getNndCmtHc());
			parameters.put("dia_chi_nguoi_to_cao", dx.getDcNguoiKNTC());
			parameters.put("nghe_nghiep_nguoi_to_cao", "");
			parameters.put("chuc_vu_nguoi_to_cao", dx.getChuDanhNguoiKNTC());
			parameters.put("don_vi_nguoi_to_cao", hdr.getNndDiaChi());

			parameters.put("ten_nguoi_bi_to_cao", dx.getNguoiBiKNTC());
			parameters.put("nam_sinh_nguoi_bi_to_cao", "");
			parameters.put("so_cmnd_nguoi_bi_to_cao", "");
			if (Formater.isNull(hdr.getNguoiBiKntcDc()))
				parameters.put("dia_chi_nguoi_bi_to_cao", "");
			else
				parameters.put("dia_chi_nguoi_bi_to_cao", dx.getDcNguoiBiKNTC());
			parameters.put("nghe_nghiep_nguoi_bi_to_cao", "");
			parameters.put("chuc_vu_nguoi_bi_to_cao", dx.getChuDanhNguoiBiKNTC());
			parameters.put("don_vi_nguoi_bi_to_cao", hdr.getNguoiBiKntcNoiCt());

			parameters.put("noi_dung_to_cao", dx.getNoiDung());

			parameters.put("ly_do_nguoi_to_cao_biet_hanh_vi_bi_to_cao", dxForm.getLyDoNtc());
			parameters.put("y_kien_khac_nhau_trong_doan_xac_minh", dxForm.getKienKhacTrongDoan());
			parameters.put("y_kien_khac_nhau_giua_truong_doan_v�_thu_truong_don_vi", dxForm.getKienTdTtcqt());
			parameters.put("noi_dung_to_cao_khong_dung_su_that", dxForm.getKetQuaXm());
			parameters.put("ket_luan_ve_hanh_vi_vi_pham_cua_nguoi_bi_to_cao", dxForm.getKetQuaXmTc());

			parameters.put("noi_dung_nguoi_giai_quyet_to_cao_can_thuc_hien", dxForm.getKienNghi());
			parameters.put("kien_nghi_khac", dxForm.getKienNghiTcKhac());

			// Noi dung xac minh
			StringBuffer sb = new StringBuffer();
			if (dxForm.getArrNd() != null && dxForm.getArrNd().length > 0) {
				KntcKquaXmDtl[] arrNd = dxForm.getArrNd();
				int k = 1;
				for (int i = 0; i < dxForm.getArrNd().length; i++) {
					KntcKquaXmDtl d = arrNd[i];
					sb.append("4. " + k + " " + d.getNoiDungTen());
					sb.append("\n");
					sb.append(d.getNhanXet());
					sb.append("\n");
					k++;
				}
			}
			parameters.put("noi_dung_to_cao_chi_tiet", sb.toString());
			parameters.put("tt_cqt", appContext.getTenCqt());
			parameters.put("ten_truong_doan", s.getTenTruongDoanXmByHs(appContext, maHs));
			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
			KtnbUtil.printf(reportRows, fileTemplate, response, inputStream, parameters, null);
		}
		return null;
	}

	/***************************************************************************
	 * Tải file 24/KNTC
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward inKetLuanTc(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		KetQuaXmTcForm dxForm = (KetQuaXmTcForm) form;
		String maHs = dxForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			// SoTiepDanService stdService = new SoTiepDanService();
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			// KntcHoSoHdr hdr = std.getHdr();
			// In mau 24
			String fileTemplate = "kntc24";
			parameters.put("co_quan_cap_tren_truc_tiep", appContext.getTenCqtTat());
			parameters.put("co_quan_thue_ra_van_ban", appContext.getTenCqt());
			parameters.put("so_van_ban", dxForm.getMaKq());
			String ngayLap = "";
			if (Formater.isNull(dxForm.getThoiDiem())) {
				ngayLap = "ng\u00E0y    th\u00E1ng    n\u0103m        ";
			} else
				ngayLap = Formater.getDateForPrint(dxForm.getThoiDiem());
			parameters.put("ngay_lap_van_ban", dxForm.getDiaDiem() + ", " + ngayLap);
			parameters.put("co_quan_thue_ban_hanh_ket_luan", appContext.getTenCqtTat());

			XacMinhService s = new XacMinhService();
			KntcQdinhXm kh = s.getKntcQdinhXmByHoSo(appContext, dxForm.getMaHoSo());
			parameters.put("can_cu_quyet_dinh_so", kh.getMaQd());
			parameters.put("ngay_ra_quyet_dinh", Formater.getDateForPrint(Formater.date2str(kh.getNgayLap())));

			parameters.put("nguoi_bi_to_cao", dx.getNguoiBiKNTC());

			parameters.put("noi_dung_to_cao_khong_dung_su_that", dxForm.getKetQuaXm());
			parameters.put("ket_luan_hanh_vi_vi_pham_phap_luat", dxForm.getKetQuaXmTc());
			parameters.put("khong_phai_nguoi_giai_quyet_to_cao", dxForm.getKienNghi());
			parameters.put("nguoi_giai_quyet_to_cao", dxForm.getKienNghiTcKhac());
			parameters.put("co_quan_don_vi_ca_nhan_khac", dxForm.getDonViDuocGuiKl());
			// Noi dung xac minh
			StringBuffer sb = new StringBuffer();
			if (dxForm.getArrNd() != null && dxForm.getArrNd().length > 0) {
				KntcKquaXmDtl[] arrNd = dxForm.getArrNd();
				int k = 1;
				for (int i = 0; i < dxForm.getArrNd().length; i++) {
					KntcKquaXmDtl d = arrNd[i];
					sb.append(k + ". " + d.getNoiDungTen());
					sb.append("\n");
					sb.append(d.getNhanXet());
					sb.append("\n");
					k++;
				}
			}
			parameters.put("noi_dung_to_cao_chi_tiet", sb.toString());
			parameters.put("tt_cqt", appContext.getTenCqt());
			// parameters.put("ten_thu_truong", appContext.getTenThuTruong());
			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
			KtnbUtil.printf(reportRows, fileTemplate, response, inputStream, parameters, null);
		}
		return null;
	}

	/**
	 * Hiển thị 19/KNTC, 26/KNTC
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	public ActionForward qdgq(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		FormBeanConfig fbc = map.getModuleConfig().findFormBeanConfig("qdGqForm");
		Class clazz = Class.forName(fbc.getType());
		QuyetDinhGqKnForm qdgqForm = (QuyetDinhGqKnForm) clazz.newInstance();
		// baoCaoKqThucHienForm
		String maHs = request.getParameter("id");
		PhanLoaiXuLyService plService=new PhanLoaiXuLyService();
		KntcDeXuatXly dxxl=plService.getDeXuatXly(appContext, maHs);
		qdgqForm.setLanGiaiQuyet(dxxl.getLanGui());
		if (!Formater.isNull(maHs)) {
			qdgqForm.setMaHoSo(maHs);
			XuLyKNTCService s = new XuLyKNTCService();
			KntcQdinhGquyet kq = s.getQdinhGquyet(appContext, maHs);
			if (kq == null) { // Tao moi
				qdgqForm.setSoQd(KtnbUtil.getMaNvu(appContext, "Q\u0110"));
				qdgqForm.setThoiDiem(Formater.date2str(new Date()));
				qdgqForm.setKnDungSai("1");
			} else { // Edit
				XacMinhService xmService = new XacMinhService();
				KntcKqxmKluatKnghi baoCaoKq = xmService.getKqxmKluatKnghi(appContext, kq.getMaHs());
				if (baoCaoKq != null)
					qdgqForm.setNoiDungViPham(baoCaoKq.getQuyetDinhHc());
				qdgqForm.fromEntity(kq);
				if (kq.getKnDungSai() != null)
					qdgqForm.setKnDungSai(kq.getKnDungSai().toString());
			}
		}
		KtnbUtil.setVanBan(appContext, request);
		// saveToken(request);
		request.setAttribute("qdGqForm", qdgqForm);
		return map.findForward("qdgq");
	}

	/**
	 * Hiển thị Báo cáo kết quả thực hiện KN và TC
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward baocaoketqua(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);

		FormBeanConfig fbc = map.getModuleConfig().findFormBeanConfig("baoCaoKqThucHienForm");
		Class clazz = Class.forName(fbc.getType());
		BaoCaoKetQuaThucHienForm inputForm = (BaoCaoKetQuaThucHienForm) clazz.newInstance();
		// BaoCaoKetQuaThucHienForm inputForm = (BaoCaoKetQuaThucHienForm) form;
		XuLyKNTCService s = new XuLyKNTCService();
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			inputForm.setMaHs(maHs);
			KntcBCKQThucHienQDKN bc = s.getBCKQThucHienKN(appContext, maHs);
			if (bc == null) {
				bc = new KntcBCKQThucHienQDKN();
				bc.setMaHs(maHs);
				bc.setLoaiKntc(SoTiepDanService.isKN(appContext, maHs) ? new Long(1) : new Long(2));
				// bc.setNguoiCapNhat(nguoiCapNhat);
			} else {
				inputForm.fromEntity(bc);
			}
		}
		request.setAttribute("baoCaoKqThucHienForm", inputForm);
		return map.findForward("baocaoketqua");
	}

	/**
	 * Các tab liên quan khi lưu xong sẽ quay về đây để load lại dữ liệu
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward ketThuc(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String act = request.getParameter("action");
			ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
			KetQuaXmForm kqForm = (KetQuaXmForm) form;
			String maHs = request.getParameter("id");
			kqForm.setMaHoSo(maHs);

			SoTiepDanService s = new SoTiepDanService();
			KntcSoTiepDan hs = s.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = hs.getHdr();

			// Lấy thông tin đề xuất: xem giải quyết ngay hay phải xác minh
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			if ("1".equals(dx.getIsGquyetNgay().toString())) {
				kqForm.setIsGiaiQuyetNgay("true");
			} else {
				kqForm.setIsGiaiQuyetNgay("false");
			}
			// Hồ sơ chưa đến trạng thái 1615
			if (Integer.parseInt(hdr.getTrangThai()) < Integer.parseInt(Constants.TT_KNTC_KET_LUAN)) {
				throw new KtnbException("H&#x1ED3; s&#x1A1; ch&#x1B0;a &#x111;&#x1EE7; th&#xF4;ng tin &#x111;&#x1EC3; th&#x1EF1;c hi&#x1EC7;n vi&#x1EC7;c k&#x1EBF;t th&#xFA;c!!!", "", "");
			}

			// Nếu đã kết thúc và là chuyển đơn thì không cần xem tab xác minh + kết thúc
			if (Constants.TT_KNTC_KET_THUC.equals(hdr.getTrangThai()) && Constants.KNTC_KET_THUC_CHUYEN_DON.equals(hdr.getLoaiKetThuc())) {
				throw new KtnbException("H&#x1ED3; s&#x1A1; &#x111;&#xE3; chuy&#x1EC3;n v&#xE0; k&#x1EBF;t th&#xFA;c n&#xEA;n kh&#xF4;ng th&#x1EC3; th&#x1EF1;c hi&#x1EC7;n x&#xE1;c minh!!!", "", "");
			}

			if ("ketThucKhieuNai".equals(act)) {
				this.baocao(map, form, request, response);
				this.qdgq(map, form, request, response);
				this.baocaoketqua(map, form, request, response);
				return map.findForward("ketThucKhieuNai");
			} else {
				this.klndtc(map, form, request, response);
				this.qdgq(map, form, request, response);
				this.baocaoketqua(map, form, request, response);
				return map.findForward("ketThucToCao");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
