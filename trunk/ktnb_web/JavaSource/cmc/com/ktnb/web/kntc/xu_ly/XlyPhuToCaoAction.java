package cmc.com.ktnb.web.kntc.xu_ly;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import cmc.com.ktnb.pl.hb.entity.KntcDeXuatXly;
import cmc.com.ktnb.pl.hb.entity.KntcGiaoNvXmTc;
import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.pl.hb.entity.KntcNoiDungTCTT;
import cmc.com.ktnb.pl.hb.entity.KntcTbKhongThuLyGqTiep;
import cmc.com.ktnb.pl.hb.entity.KntcTbKoThuLyGq;
import cmc.com.ktnb.service.kntc.KntcSoTiepDan;
import cmc.com.ktnb.service.kntc.PhanLoaiXuLyService;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.service.kntc.XuLyPhuKhieuNaiToCaoService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.catalog.CatalogService;
import cmc.com.ktnb.web.kntc.tiep_dan.PhieuForm;
import cmc.com.ktnb.web.kntc.xac_minh.XacMinhForm;

public class XlyPhuToCaoAction extends PrintAction {
	KntcNoiDungTCTT ndtc = new KntcNoiDungTCTT();

	KntcTbKhongThuLyGqTiep khongThuLyGqTiep = new KntcTbKhongThuLyGqTiep();

	KntcTbKoThuLyGq khongThuLyGq = new KntcTbKoThuLyGq();

	KntcGiaoNvXmTc giaoNvXmTc = new KntcGiaoNvXmTc();

	XuLyPhuKhieuNaiToCaoService khieuNaiTcaoService = new XuLyPhuKhieuNaiToCaoService();

	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XlyPhuToCaoForm cbForm = (XlyPhuToCaoForm) form;
		String soHoSo = request.getParameter("id");
		String type = request.getParameter("type");
		if ("view".equals(request.getParameter("action"))||"view".equals(request.getParameter("action1"))) {
			if (!Formater.isNull(soHoSo)) {
				loadDefauldForm(request, appContext, cbForm, soHoSo);

			}
		} else if ("save".equals(request.getParameter("action"))||"save".equals(request.getParameter("action1"))) {
			if ("bBanNdung".equals(type))
				ndtc = cbForm.tctt;
			else if ("tbKoGquyetTiep".equals(type))
				khongThuLyGqTiep = cbForm.tbKhongThuLyTiep;
			else if ("tbKoThuLyGq".equals(type))
				khongThuLyGq = cbForm.tbKoThuLyGq;
			else if ("giaoNhiemVu".equals(type))
				giaoNvXmTc = cbForm.giaoNvXmTc;
			saveBienBan(request, appContext, cbForm);
			request.setAttribute("save", "ok");
		} else if ("exportDoc".equals(request.getParameter("action"))||"exportDoc".equals(request.getParameter("action1"))) {
			exportDoc(map, form, request, response);
		}
		return returnMappingForm(map, form, request, response);
	}

	// Load defauld form
	public void loadDefauldForm(HttpServletRequest request, ApplicationContext appContext, XlyPhuToCaoForm cbForm, String soHoSo) throws Exception {
		String type = request.getParameter("type");
		if ("bBanNdung".equals(type))
			loadBienBanNoiDung(appContext, cbForm, soHoSo);
		else if ("tbKoGquyetTiep".equals(type))
			loadTbKoGiaiQuyetTiep(appContext, cbForm, soHoSo);
		else if ("tbKoThuLyGq".equals(type))
			loadTbKoGiaiQuyet(appContext, cbForm, soHoSo);
		else if ("giaoNhiemVu".equals(type))
			loadGiaoNhiemVu(appContext, cbForm, soHoSo);
	}

	// Load object Form
	public void loadBienBanNoiDung(ApplicationContext appContext, XlyPhuToCaoForm cbForm, String soHoSo) throws Exception {
		// tim theo so ho so
		ndtc = khieuNaiTcaoService.findNoiDungTc(appContext, soHoSo);
		if (ndtc == null) {
			ndtc = new KntcNoiDungTCTT();
			cbForm.tctt.setSoHoSo(soHoSo);
		} else {
			cbForm.tctt = ndtc;
		}
	}

	public void loadTbKoGiaiQuyetTiep(ApplicationContext appContext, XlyPhuToCaoForm cbForm, String soHoSo) throws Exception {
		// tim theo so ho so
		khongThuLyGqTiep = khieuNaiTcaoService.findTbkhongThuLyGqTiep(appContext, soHoSo);
		if (khongThuLyGqTiep == null) {
			khongThuLyGqTiep = new KntcTbKhongThuLyGqTiep();
			cbForm.tbKhongThuLyTiep.setSoHoSo(soHoSo);
		} else {
			cbForm.tbKhongThuLyTiep = khongThuLyGqTiep;
		}

	}

	public void loadTbKoGiaiQuyet(ApplicationContext appContext, XlyPhuToCaoForm cbForm, String soHoSo) throws Exception {
		// tim theo so ho so
		khongThuLyGq = khieuNaiTcaoService.findTbkoThuLyGq(appContext, soHoSo);
		if (khongThuLyGq == null) {
			khongThuLyGq = new KntcTbKoThuLyGq();
			cbForm.tbKoThuLyGq.setSoHoSo(soHoSo);
		} else {
			cbForm.tbKoThuLyGq = khongThuLyGq;
		}

	}

	public void loadGiaoNhiemVu(ApplicationContext appContext, XlyPhuToCaoForm cbForm, String soHoSo) throws Exception {
		// Tim theo so ho so
		giaoNvXmTc = khieuNaiTcaoService.findGiaoNvXm(appContext, soHoSo);
		if (giaoNvXmTc == null) {
			giaoNvXmTc = new KntcGiaoNvXmTc();
			cbForm.giaoNvXmTc.setSoHoSo(soHoSo);
		} else {
			cbForm.giaoNvXmTc = giaoNvXmTc;
		}

	}

	// Return mapping form
	public ActionForward returnMappingForm(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		String type = request.getParameter("type");
		if ("bBanNdung".equals(type))
			return map.findForward("bbNoiDung");
		else if ("tbKoGquyetTiep".equals(type))
			return map.findForward("tbKoGquyetTiep");
		else if ("tbKoThuLyGq".equals(type))
			return map.findForward("tbKoThuLyGq");
		else if ("giaoNhiemVu".equals(type))
			return map.findForward("giaoNhiemVu");
		else
			return map.findForward("success");
	}

	// Save bien ban
	public void saveBienBan(HttpServletRequest request, ApplicationContext appContext, XlyPhuToCaoForm cbForm) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			BaseHibernateDAO dao = new BaseHibernateDAO();
			session = HibernateSessionFactory.currentSession();
			if ("bBanNdung".equals(request.getParameter("type"))) {
				if (Formater.isNull(ndtc.getId())) {
					ndtc.setId(KeyManagement.getGUID());
					dao.saveObject(appContext, ndtc);
				} else {
					dao.updateObject(appContext, ndtc, Boolean.TRUE);
					session.flush();
					tx.commit();
				}
			}
			if ("tbKoGquyetTiep".equals(request.getParameter("type"))) {
				if (Formater.isNull(khongThuLyGqTiep.getId())) {
					khongThuLyGqTiep.setId(KeyManagement.getGUID());
					dao.saveObject(appContext, khongThuLyGqTiep);
				} else {
					dao.updateObject(appContext, khongThuLyGqTiep, Boolean.TRUE);
					session.flush();
					tx.commit();
				}
			}
			if ("giaoNhiemVu".equals(request.getParameter("type"))) {
				if (Formater.isNull(giaoNvXmTc.getId())) {
					giaoNvXmTc.setId(KeyManagement.getGUID());
					dao.saveObject(appContext, giaoNvXmTc);
				} else {
					dao.updateObject(appContext, giaoNvXmTc, Boolean.TRUE);
					session.flush();
					tx.commit();
				}
			}

			if ("tbKoThuLyGq".equals(request.getParameter("type"))) {
				if (Formater.isNull(khongThuLyGq.getId())) {
					khongThuLyGq.setId(KeyManagement.getGUID());
					dao.saveObject(appContext, khongThuLyGq);
				} else {
					dao.updateObject(appContext, khongThuLyGq, Boolean.TRUE);
					session.flush();
					tx.commit();
				}
			}

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}

	protected String getDocInName(HttpServletRequest request) {
		// TODO Auto-generated method stubs
		String type = request.getParameter("type");
		if ("bBanNdung".equals(type))
			return request.getRealPath("/docin") + "\\TTNB_nd_tc_truc_tiep.doc";
		else if ("tbKoGquyetTiep".equals(type))
			return request.getRealPath("/docin") + "\\TTNB_tb_ko_thu_ly_giai_quyet_tiep.doc";
		else if ("tbKoThuLyGq".equals(type))
			return request.getRealPath("/docin/v4/kntc") + "\\TC04.doc";
		else if ("giaoNhiemVu".equals(type))
			return request.getRealPath("/docin") + "\\TTNB_giao_nv_xm.doc";
		else
			return null;
	}

	protected String getDocOutName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		if ("bBanNdung".equals(type))
			return request.getRealPath("/docout") + "\\TTNB_nd_tc_truc_tiep_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
		else if ("tbKoGquyetTiep".equals(type))
			return request.getRealPath("/docout") + "\\TTNB_tb_ko_thu_ly_giai_quyet_tiep_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
		else if ("tbKoThuLyGq".equals(type))
			return request.getRealPath("/docout") + "\\TTNB_tb_ko_thu_ly_giai_quyet_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
		else if ("giaoNhiemVu".equals(type))
			return request.getRealPath("/docout") + "\\TTNB_giao_nv_xm_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
		else
			return null;
	}

	public void pushDataBbNDung(MsWordUtils word, XlyPhuToCaoForm cbForm) {
		word.put("[thoi_gian_bat_dau]", cbForm.tctt.getThoiGianBatDauStr());
		word.put("[dia_diem]", cbForm.tctt.getDiaDiem());
		word.put("[cac_ben_lien_quan]", cbForm.tctt.getCacBenLquan());
		word.put("[noi_dung_bao_cao]", cbForm.tctt.getNdungToCao());
		word.put("[tai_lieu]", cbForm.tctt.getBangChungCc());
		word.put("[yeu_cau_nguoi_to_cao]", cbForm.tctt.getYeuCauNtc());
		word.put("[thoi_gian_kt]", cbForm.tctt.getThoiGianKetThucStr());
	}

	public void pushDataTbKoGquyetTiep(MsWordUtils word, XlyPhuToCaoForm cbForm) {
		word.put("[ngay_lap]", cbForm.tbKhongThuLyTiep.getNgayLapStr());
		word.put("[dia_diem]", cbForm.tbKhongThuLyTiep.getDiaDiem());
		word.put("[don_vi_ban_hanh_tb]", cbForm.tbKhongThuLyTiep.getDviBanHanh());
		word.put("[noi_dung_tc_tiep]", cbForm.tbKhongThuLyTiep.getNoiDung());
		word.put("[ly_do_tc_tiep]", cbForm.tbKhongThuLyTiep.getLyDo());
		word.put("[don_vi_chuyen_tc]", cbForm.tbKhongThuLyTiep.getDviChuyenTiepBc());
		word.put("[nguoi_dq_theo_tham_quyen]", cbForm.tbKhongThuLyTiep.getNguoiGqTheoThamQuyen());
	}

	public void pushDataTbKoGquyet(MsWordUtils word, XlyPhuToCaoForm cbForm, ApplicationContext app) {

		word.put("[cqt_ra_van_ban]", cbForm.tbKoThuLyGq.getDviBanHanh());
		word.put("[so_tb]", cbForm.tbKoThuLyGq.getSoThongBao());

		word.put("[dia_diem]", cbForm.tbKoThuLyGq.getDiaDiem());
		word.put("[ngay_lap]", cbForm.tbKoThuLyGq.getNgayLapStr());

		word.put("[ngay_lap]", cbForm.tbKoThuLyGq.getNgayLapStr());

		word.put("[co_quan_co_tham_quyen_giai_quyet]", cbForm.phieuHdNkn.getCqtGqTen());
		word.put("[nguoi_co_quan_don_vi_to_cao]", cbForm.deXuatXly.getNguoiKNTC());

		// word.put("[don_vi_ban_hanh_thong_bao]",
		// cbForm.tbKoThuLyGq.getDviBanHanh());
		word.put("[noi_dung_khong_thu_ly]", cbForm.tbKoThuLyGq.getNoiDungBcKoThuLy());
		word.put("[don_vi_chuyen_to_cao]", cbForm.tbKoThuLyGq.getDonViChuyenBc());
		word.put("[ly_do_khong_thu_ly]", cbForm.tbKoThuLyGq.getLyDoApDungKoThuLy());

		// word.put("[don_vi_chuyen_to_cao]",
		// cbForm.tbKoThuLyGq.getDonViChuyenBc());

		word.put("[nguoi_co_quan_don_vi_to_cao]", cbForm.deXuatXly.getNguoiKNTC());
		word.put("[don_vi_chuyen_to_cao]", cbForm.tbKoThuLyGq.getDonViChuyenBc());
		word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(app.getMaCqt()).toUpperCase());
	}

	public void pushDataGiaoNhiemVu(MsWordUtils word, XlyPhuToCaoForm cbForm) {
		word.put("[ngay_lap]", cbForm.giaoNvXmTc.getNgayBanHanhStr());
		word.put("[dia_diem]", cbForm.giaoNvXmTc.getDiaDiem());
		word.put("[van_ban]", cbForm.giaoNvXmTc.getCanCuVanBan());
		word.put("[nguoi_de_nghi]", cbForm.giaoNvXmTc.getNguoiDeNghi());
		word.put("[noi_dung_duoc_thu_ly]", cbForm.giaoNvXmTc.getNoiDungDuocThuLy());
		word.put("[don_vi_duoc_giao_xm]", cbForm.giaoNvXmTc.getDonViDuocGiaoXm());
		word.put("[nguoi_ra_qd_ten]", cbForm.giaoNvXmTc.getNguoiRaQdTen());
		word.put("[nguoi_ra_qd_chuc_vu]", cbForm.giaoNvXmTc.getNguoiRaQdCvu());
		word.put("[nguoi_gq_ten]", cbForm.giaoNvXmTc.getNguoiGqTcTen());
		word.put("[nguoi_gq_chuc_vu]", cbForm.giaoNvXmTc.getNguoiGqTcChucVu());
		word.put("[yeu_cau_khac]", cbForm.giaoNvXmTc.getYeuCauKhac());
		word.put("[ngay_trinh_truong_bo_phan_ky]", cbForm.giaoNvXmTc.getNgayTrinhTruongBoPhanKyStr());
		word.put("[ngay_truong_bo_phan_ky]", cbForm.giaoNvXmTc.getNgayTruongBoPhanKyStr());
		word.put("[y_kien]", cbForm.giaoNvXmTc.getYkienCuaTruongBoPhan());
		word.put("[ngay_trinh_thu_truong_duyet]", cbForm.giaoNvXmTc.getNgayTrinhThuTruongDuyetStr());
		word.put("[ngay_thu_truong_duyet]", cbForm.giaoNvXmTc.getNgayThuTruongDuyetStr());
		word.put("[y_kien_thu_truong]", cbForm.giaoNvXmTc.getYkienThuTruong());
	}

	public void pushData(MsWordUtils word, HttpServletRequest request, ActionForm form, ApplicationContext app) throws Exception {
		// TODO Auto-generated method stub
		XlyPhuToCaoForm cbForm = (XlyPhuToCaoForm) form;
		String type = request.getParameter("type");
		if ("bBanNdung".equals(type))
			pushDataBbNDung(word, cbForm);
		else if ("tbKoGquyetTiep".equals(type))
			pushDataTbKoGquyetTiep(word, cbForm);
		else if ("tbKoThuLyGq".equals(type))
			pushDataTbKoGquyet(word, cbForm, app);
		else if ("giaoNhiemVu".equals(type))
			pushDataGiaoNhiemVu(word, cbForm);
	}

	protected String getFileOutName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		if ("bBanNdung".equals(type))
			return "Bien Ban Noi Dung";
		else if ("tbKoGquyetTiep".equals(type))
			return "Tb khong gquyet tiep";
		else if ("tbKoThuLyGq".equals(type))
			return "Tb khong thu ly giai quyet";
		else if ("giaoNhiemVu".equals(type))
			return "Giao nhiem vu xac minh";
		else
			return null;
	}

	// Property accessor
	public KntcGiaoNvXmTc getGiaoNvXmTc() {
		return giaoNvXmTc;
	}

	public void setGiaoNvXmTc(KntcGiaoNvXmTc giaoNvXmTc) {
		this.giaoNvXmTc = giaoNvXmTc;
	}

	public KntcTbKoThuLyGq getKhongThuLyGq() {
		return khongThuLyGq;
	}

	public void setKhongThuLyGq(KntcTbKoThuLyGq khongThuLyGq) {
		this.khongThuLyGq = khongThuLyGq;
	}

	public KntcTbKhongThuLyGqTiep getKhongThuLyGqTiep() {
		return khongThuLyGqTiep;
	}

	public void setKhongThuLyGqTiep(KntcTbKhongThuLyGqTiep khongThuLyGqTiep) {
		this.khongThuLyGqTiep = khongThuLyGqTiep;
	}

	public KntcNoiDungTCTT getNdtc() {
		return ndtc;
	}

	public void setNdtc(KntcNoiDungTCTT ndtc) {
		this.ndtc = ndtc;
	}

	public KntcTbKoThuLyGq getTbKoThuLyGq() {
		return khongThuLyGq;
	}

	public void setTbKoThuLyGq(KntcTbKoThuLyGq khongThuLyGq) {
		this.khongThuLyGq = khongThuLyGq;
	}

	public XuLyPhuKhieuNaiToCaoService getKhieuNaiTcaoService() {
		return khieuNaiTcaoService;
	}

	public void setKhieuNaiTcaoService(XuLyPhuKhieuNaiToCaoService khieuNaiTcaoService) {
		this.khieuNaiTcaoService = khieuNaiTcaoService;
	}

	public void pushData(MsWordUtils word, HttpServletRequest request, ActionForm form) throws Exception {
		// TODO Auto-generated method stub

	}

	//v4
	//In thong bao khong thu li giai quyet
	public ActionForward inTbKoThuLyGq(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;

		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XlyPhuToCaoForm cbForm = (XlyPhuToCaoForm) form;
		String soHoSo = request.getParameter("id");
		PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
		KntcDeXuatXly dx = plService.getDeXuatXly(appContext, soHoSo);
		fileIn = request.getRealPath("/docin/v4") + "\\TC04.doc";
		fileOut = request.getRealPath("/docout") + "\\TC04_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

		word = new MsWordUtils(fileIn, fileOut);
		try {
			word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
			word.put("[co_quan_thue_ra_TB]", appContext.getTenCqt().toUpperCase());
//			word.put("[cqt_ra_van_ban]", cbForm.tbKoThuLyGq.getDviBanHanh());
			word.put("[so_tb]", cbForm.tbKoThuLyGq.getSoThongBao());
			String ngayLap="";
			if (Formater.isNull(cbForm.tbKoThuLyGq.getNgayLapStr())) {
				ngayLap = "Ng\u00E0y   th\u00E1ng   n\u0103m        ";
				word.put("[ngay_lap_quyet_dinh]", cbForm.tbKoThuLyGq.getDiaDiem() + ", " + ngayLap);
			} else
				word.put("[ngay_lap_quyet_dinh]", cbForm.tbKoThuLyGq.getDiaDiem() + ", " + Formater.getDateForPrint(cbForm.tbKoThuLyGq.getNgayLapStr()));
//			word.put("[dia_diem]", cbForm.tbKoThuLyGq.getDiaDiem());
			if (Formater.isNull(cbForm.tbKoThuLyGq.getNgayLapStr())) {
				ngayLap = "Ng\u00E0y   th\u00E1ng   n\u0103m        ";
				word.put("[ngay_lap_quyet_dinh]", ngayLap);
			} else
				word.put("[ngay_lap_quyet_dinh]", Formater.getDateForPrint(cbForm.tbKoThuLyGq.getNgayLapStr()));
			word.put("[co_quan_co_tham_quyen_giai_quyet]", cbForm.tbKoThuLyGq.getDviBanHanh());
			word.put("[nguoi_co_quan_don_vi_to_cao]", dx.getNguoiKNTC());
			// word.put("[don_vi_ban_hanh_thong_bao]",
			// cbForm.tbKoThuLyGq.getDviBanHanh());
//			word.put("[noi_dung_khong_thu_ly]", cbForm.tbKoThuLyGq.getNoiDungBcKoThuLy());
			word.put("[noi_dung_khong_thu_ly]", dx.getNoiDungKNTC());
//			System.out.println("noi dung tc: " + dx.getNoiDungKNTC());
			if (Formater.isNull(cbForm.tbKoThuLyGq.getNgayLapStr()))
				word.put("[don_vi_chuyen_to_cao]", "");
			else
				word.put("[don_vi_chuyen_to_cao]","T\u1ED1 c\u00E1o do \"" + cbForm.tbKoThuLyGq.getDonViChuyenBc()+"\" chuy\u1EC3n \u0111\u1EBFn.");
			
			word.put("[ly_do_khong_thu_ly]", cbForm.tbKoThuLyGq.getLyDoApDungKoThuLy());

			// word.put("[don_vi_chuyen_to_cao]",
			// cbForm.tbKoThuLyGq.getDonViChuyenBc());

			word.put("[nguoi_co_quan_don_vi_to_cao]", dx.getNguoiKNTC());
			if (Formater.isNull(cbForm.tbKoThuLyGq.getNgayLapStr()))
				word.put("[don_vi_chuyen_to_cao]", "......");
			else
				word.put("[don_vi_chuyen_to_cao]",cbForm.tbKoThuLyGq.getDonViChuyenBc());
			
			word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau TC04", ".doc", response);
		} catch (Exception ex) {
			// ex.printStackTrace();
			System.out.println("Download Error: " + ex.getMessage());
		}
		return null;
	}

	//In thong bao khong thu li giai quyet
	public ActionForward inTbKoThuLyGqTiep(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;

		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XlyPhuToCaoForm cbForm = (XlyPhuToCaoForm) form;
		String soHoSo = request.getParameter("id");
		PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
//		DeXuatXuLyKNForm xl=
		KntcDeXuatXly dx = plService.getDeXuatXly(appContext, soHoSo);
		fileIn = request.getRealPath("/docin/v4") + "\\TC05.doc";
		fileOut = request.getRealPath("/docout") + "\\TC05_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

		word = new MsWordUtils(fileIn, fileOut);
		try {
			word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
			word.put("[co_quan_thue_ra_TB]", appContext.getTenCqt().toUpperCase());
//			word.put("[cqt_ra_van_ban]", cbForm.tbKoThuLyGq.getDviBanHanh());
			word.put("[so_tb]", cbForm.tbKhongThuLyTiep.getSoThongBao());
			String ngayLap="";
			if (Formater.isNull(cbForm.tbKhongThuLyTiep.getNgayLapStr())) {
				ngayLap = "Ng\u00E0y   th\u00E1ng   n\u0103m        ";
				word.put("[ngay_lap_quyet_dinh]", cbForm.tbKhongThuLyTiep.getDiaDiem() + ", " + ngayLap);
			} else
				word.put("[ngay_lap_quyet_dinh]", cbForm.tbKhongThuLyTiep.getDiaDiem() + ", " + Formater.getDateForPrint(cbForm.tbKoThuLyGq.getNgayLapStr()));
//			word.put("[dia_diem]", cbForm.tbKoThuLyGq.getDiaDiem());
			if (Formater.isNull(cbForm.tbKhongThuLyTiep.getNgayLapStr())) {
				ngayLap = "Ng\u00E0y   th\u00E1ng   n\u0103m        ";
				word.put("[ngay_lap_quyet_dinh]", ngayLap);
			} else
				word.put("[ngay_lap_quyet_dinh]", Formater.getDateForPrint(cbForm.tbKhongThuLyTiep.getNgayLapStr()));
			word.put("[nguoi_co_tham_quyen_giai_quyet]", appContext.getTenCanbo().toUpperCase());
			word.put("[noi_dung_to_cao_tiep]", dx.getNoiDungKNTC());
//			word.put("[nguoi_co_quan_don_vi_to_cao]", dx.getNguoiKNTC());
			// word.put("[don_vi_ban_hanh_thong_bao]",
			// cbForm.tbKoThuLyGq.getDviBanHanh());
			if (Formater.isNull(cbForm.tbKhongThuLyTiep.getNgayLapStr()))
				word.put("[don_vi_chuyen_to_cao]", "");
			else
				word.put("[don_vi_chuyen_to_cao]","T\u1ED1 c\u00E1o do \"" + cbForm.tbKhongThuLyTiep.getDviChuyenTiepBc()+"\" chuy\u1EC3n \u0111\u1EBFn.");
			
			word.put("[nguoi_da_gq_tc_theo_tham_quyen]", cbForm.tbKhongThuLyTiep.getDviBanHanh());
			word.put("[thong_tin_van_ban_da_giai_quyet]", cbForm.tbKhongThuLyTiep.getTtVanBan());
			
			if (Formater.isNull(cbForm.tbKhongThuLyTiep.getNgayLapStr()))
				word.put("[ly_do_tc_tiep]","\u2026nh\u01B0ng ng\u01B0\u1EDDi t\u1ED1 c\u00E1o ti\u1EBFp t\u1EE5c t\u1ED1 c\u00E1o m\u00E0 kh\u00F4ng n\u00EAu r\u00F5 l\u00FD do t\u1ED1 c\u00E1o ti\u1EBFp");
			else
				word.put("[ly_do_tc_tiep]", cbForm.tbKhongThuLyTiep.getLyDo());

			word.put("[nguoi_co_tham_quyen_giai_quyet]", appContext.getTenCanbo().toUpperCase());
			word.put("[nguoi_co_tham_quyen_giai_quyet]", appContext.getTenCanbo().toUpperCase());
			// word.put("[don_vi_chuyen_to_cao]",
			// cbForm.tbKoThuLyGq.getDonViChuyenBc());
			if (Formater.isNull(cbForm.tbKhongThuLyTiep.getNgayLapStr()))
				word.put("[don_vi_chuyen_to_cao]", "");
			else
				word.put("[don_vi_chuyen_to_cao]",cbForm.tbKhongThuLyTiep.getDviChuyenTiepBc());
			word.put("[nguoi_da_gq_tc_theo_tham_quyen]", cbForm.tbKhongThuLyTiep.getDviBanHanh());
			word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau TC05", ".doc", response);
		} catch (Exception ex) {
			// ex.printStackTrace();
			System.out.println("Download Error: " + ex.getMessage());
		}
		return null;
	}

}
