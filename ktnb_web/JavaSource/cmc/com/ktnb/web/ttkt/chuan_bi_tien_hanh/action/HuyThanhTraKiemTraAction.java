package cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.action;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbHuy;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.catalog.CatalogService;
import cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.form.HuyThanhTraKiemTraForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;

/**
 * @version 1.0
 * @author
 */
public class HuyThanhTraKiemTraAction extends BaseDispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HuyThanhTraKiemTraForm huyThanhTraKiemTraForm = (HuyThanhTraKiemTraForm) form;
		ApplicationContext app = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String cuocTtktId = request.getParameter("idCuocTtkt");
		String method = request.getParameter("method");

		if ("save".equals(method)) {
			saveHuyTtKt(request, huyThanhTraKiemTraForm, app);
			request.setAttribute("saveStatus", "true");
		} else if ("in".equals(method)) {
			inQuyetDinhHuy(request, response, huyThanhTraKiemTraForm, app);
			return null;
		} else {
			loadDefaulForm(huyThanhTraKiemTraForm, app, request, cuocTtktId);
			if (!KtnbUtil.haveRoleNv(app) || app.getTrangThaiCuocTtkt(huyThanhTraKiemTraForm.getIdCuocTtKt()).equals(Constants.TT_TTKT_KT))
				request.setAttribute("readOnly", "true");
		}
		// Van ban quy dinh chuc nang nhiem vu
		KtnbUtil.setVanBan(CuocTtktService.getCuocTtktWithoutNoiDung(app, huyThanhTraKiemTraForm.getIdCuocTtKt()).getIdDonViTh(), request);
		return mapping.findForward("success");

	}

	/**
	 * Download file mau TTNB06
	 * 
	 * @throws Exception
	 */
	private void inQuyetDinhHuy(HttpServletRequest request, HttpServletResponse response, HuyThanhTraKiemTraForm huyThanhTraKiemTraForm, ApplicationContext appConText) throws Exception {
		String fileIn = request.getRealPath("/docin") + "\\KTNB06.doc";
		String fileOut = request.getRealPath("/docout") + "\\KTNB06_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		fileTemplate = "ttnb06";
		String idCuocTtkt = huyThanhTraKiemTraForm.getIdCuocTtKt();
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);
		// --------------------------------------------------//
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appConText);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		StringBuffer sb = new StringBuffer(hinhThuc);

		MsWordUtils word = new MsWordUtils(fileIn, fileOut);
		try {
			word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText).toUpperCase());
			word.put("[co_quan_thue_ra_quyet_dinh]", cuocTtkt.getTenDonViTh().toUpperCase());
			if (Formater.isNull(huyThanhTraKiemTraForm.getSoQd()))
				word.put("[so_ttkt]", ".........../Q\u0110-.......");
			else
				word.put("[so_ttkt]", huyThanhTraKiemTraForm.getSoQd());
			// noi lap qd, ngay
			String ngay = huyThanhTraKiemTraForm.getNgayRaQd();
			String[] arrngay = ngay.split("/");

			if (huyThanhTraKiemTraForm.getNoiRaQd().equals("") || huyThanhTraKiemTraForm.getNgayRaQd().equals("")) {
				word.put("[noi_qd]", ".....");
				word.put("[ngay_ttkt]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			} else {
				word.put("[noi_qd]", huyThanhTraKiemTraForm.getNoiRaQd());
				word.put("[ngay_ttkt]", "ng\u00E0y " + arrngay[0] + " th\u00E1ng " + arrngay[1] + " n\u0103m " + arrngay[2]);
			}
			//word.put("[ttkt]", sb.toString());
			word.put("[so_qd_huy]", cbQd.getSoQuyetDinh());
			String ngayttkt1 = Formater.date2str(cbQd.getNgayRaQuyetDnh());
			String[] arrngayttkt1 = ngayttkt1.split("/");
			word.put("[ngay_ra_qd]", "ng\u00E0y " + arrngayttkt1[0] + " th\u00E1ng " + arrngayttkt1[1] + " n\u0103m " + arrngayttkt1[2]);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
			word.put("[chuc_danh_thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText).toUpperCase()); // chuc
																													// danh
																													// thu
																													// truong
			word.put("[luat_so]","7");																									
			word.put("[can_cu]", CatalogService.getTenDanhMucById(huyThanhTraKiemTraForm.getVbQd()));
			word.put("[quyet_dinh_so]","8");
			word.put("[quyet_dinh_ngay]","22/12/2013");
			//word.put("[ttkt]", sb.toString());
			word.put("[so_qd]", cbQd.getSoQuyetDinh());
			word.put("[ngay_ra_qd]", "ng\u00E0y " + arrngayttkt1[0] + " th\u00E1ng " + arrngayttkt1[1] + " n\u0103m " + arrngayttkt1[2]);
			word.put("[chuc_danh_thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
			//word.put("[ttkt]", sb.toString());
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
			if (!Formater.isNull(huyThanhTraKiemTraForm.getChucVuNguoiDnHuy())) {
				word.put("[chuc_danh_nguoi_de_nghi_bo_qd]", huyThanhTraKiemTraForm.getChucVuNguoiDnHuy());
			} else {
				word.put("[chuc_danh_nguoi_de_nghi_bo_qd]", KtnbUtil.inFieldNull(94));
			}
			//word.put("[ttkt]", sb.toString());
			word.put("[so_qd_huy]", cbQd.getSoQuyetDinh());
			word.put("[ngay_ra_qd]", "ng\u00E0y " + arrngayttkt1[0] + " th\u00E1ng " + arrngayttkt1[1] + " n\u0103m " + arrngayttkt1[2]);
			word.put("[chuc_danh_thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
			//word.put("[ttkt]", sb.toString());
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
			// ------------Ngay hieu luc--------------------//
			String ngayraqd = huyThanhTraKiemTraForm.getNgayHieuLuc();
			String[] arrNgayqd = ngayraqd.split("/");
			word.put("[ngay_qd_huy]", Formater.getDateForPrint(huyThanhTraKiemTraForm.getNgayHieuLuc()));
			word.put("[ttkt]", sb.toString());
			word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText));
			word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appConText.getMaCqt()).toUpperCase());
			// if (Formater.isNull(appConText.getTenThuTruong())) {
			// word.put("[ten_thu_truong]", "");
			// } else {
			// word.put("[ten_thu_truong]", appConText.getTenThuTruong());
			// }
			// String ngayttkt = Formater.date2str(cbQd.getNgayRaQuyetDnh());
			// String[] arrngayttkt = ngayttkt.split("/");
			// word.put("[ngay_qd]", "ng\u00E0y " + arrngayttkt[0] + "
			// th\u00E1ng " + arrngayttkt[1] + " n\u0103m " + arrngayttkt[2]);
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau KTNB06", ".doc", response);
		} catch (Exception ex) {
			// ex.printStackTrace();
			System.out.println("Download Error: " + ex.getMessage());
		} finally {
			try {
				word.saveAndClose();
			} catch (Exception e) {

			}
		}
	}

	/**
	 * @param request
	 * @param response
	 * @param huyThanhTraKiemTraForm
	 */
	private void inQuyetDinhHuy_old(HttpServletRequest request, HttpServletResponse response, HuyThanhTraKiemTraForm huyThanhTraKiemTraForm, ApplicationContext appConText) throws Exception {
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		fileTemplate = "ttnb06";
		String idCuocTtkt = huyThanhTraKiemTraForm.getIdCuocTtKt();
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);
		// --------------------------------------------------//
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appConText);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		StringBuffer sb = new StringBuffer(hinhThuc);
		parameters.put("ttkt", sb.toString());
		parameters.put("so_ttkt", huyThanhTraKiemTraForm.getSoQd());
		parameters.put("ten_cqt", KtnbUtil.getTenCqtCapTrenTt(appConText));
		parameters.put("co_quan_thue_ra_quyet_dinh", cuocTtkt.getTenDonViTh());
		parameters.put("dv_dc_ttkt", cuocTtkt.getTenDonViBi());
		if (!Formater.isNull(huyThanhTraKiemTraForm.getChucVuNguoiDnHuy())) {
			parameters.put("chuc_danh_nguoi_de_nghi_bo_qd", huyThanhTraKiemTraForm.getChucVuNguoiDnHuy());
		} else {
			parameters.put("chuc_danh_nguoi_de_nghi_bo_qd", KtnbUtil.inFieldNull(94));
		}
		parameters.put("chuc_danh_thu_truong_cqt", KtnbUtil.getTenThuTruongCqt(appConText)); // chuc
																								// danh
																								// thu
																								// truong
		parameters.put("chuc_danh_thu_truong", KtnbUtil.getChucVuThuTruongByMaCqt(appConText.getMaCqt()));
		parameters.put("can_cu", CatalogService.getTenDanhMucById(huyThanhTraKiemTraForm.getVbQd()));
		parameters.put("so_qd", cbQd.getSoQuyetDinh());
		String ngayttkt1 = Formater.date2str(cbQd.getNgayRaQuyetDnh());
		String[] arrngayttkt1 = ngayttkt1.split("/");
		parameters.put("ngay_ra_qd", "ng\u00E0y " + arrngayttkt1[0] + " th\u00E1ng " + arrngayttkt1[1] + " n\u0103m " + arrngayttkt1[2]);
		// ------------Ngay hieu luc--------------------//
		String ngayraqd = huyThanhTraKiemTraForm.getNgayHieuLuc();
		String[] arrNgayqd = ngayraqd.split("/");
		parameters.put("ngay_qd_huy", Formater.getDateForPrint(huyThanhTraKiemTraForm.getNgayHieuLuc()));
		parameters.put("so_qd_huy", cbQd.getSoQuyetDinh());
		// noi lap qd, ngay
		String ngay = huyThanhTraKiemTraForm.getNgayRaQd();
		String[] arrngay = ngay.split("/");

		if (huyThanhTraKiemTraForm.getNoiRaQd().equals("") || huyThanhTraKiemTraForm.getNgayRaQd().equals("")) {
			parameters.put("noi_qd", ".....");
			parameters.put("ngay_ttkt", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
		} else {
			parameters.put("noi_qd", huyThanhTraKiemTraForm.getNoiRaQd());
			parameters.put("ngay_ttkt", "ng\u00E0y " + arrngay[0] + " th\u00E1ng " + arrngay[1] + " n\u0103m " + arrngay[2]);
		}
		String ngayttkt = Formater.date2str(cbQd.getNgayRaQuyetDnh());
		String[] arrngayttkt = ngayttkt.split("/");
		parameters.put("ngay_qd", "ng\u00E0y " + arrngayttkt[0] + " th\u00E1ng " + arrngayttkt[1] + " n\u0103m " + arrngayttkt[2]);
		//
		if (Formater.isNull(fileTemplate))
			throw new Exception("Chua chon file template");

		InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
		KtnbUtil.printf(reportRows, fileTemplate, response, inputStream, parameters, null);

	}

	private void loadDefaulForm(HuyThanhTraKiemTraForm huyThanhTraKiemTraForm, ApplicationContext app, HttpServletRequest request, String cuocTtktId) throws Exception {
		// load quyet dinh
		TtktCbHuy huyTtKt = TtktCnPhuService.getHuyTtKt(app, cuocTtktId);
		huyThanhTraKiemTraForm.setIdCuocTtKt(cuocTtktId);
		if (huyTtKt != null) {
			huyThanhTraKiemTraForm.setChucVuNguoiDnHuy(huyTtKt.getChucVuNguoiDeNghi());
			huyThanhTraKiemTraForm.setId(huyTtKt.getId());
			huyThanhTraKiemTraForm.setIdCuocTtKt(huyTtKt.getIdCuocTtkt());
			huyThanhTraKiemTraForm.setIdNguoiDnHuy(huyTtKt.getIdNguoiDeNghiHuy());
			huyThanhTraKiemTraForm.setNgayHieuLuc(Formater.date2str(huyTtKt.getNgayHieuLuc()));
			huyThanhTraKiemTraForm.setNgayRaQd(Formater.date2str(huyTtKt.getNgayRaQd()));
			huyThanhTraKiemTraForm.setNoiRaQd(huyTtKt.getNoiRaQd());
			huyThanhTraKiemTraForm.setSoQd(huyTtKt.getSoQd());
			huyThanhTraKiemTraForm.setSoQdHuy(huyTtKt.getSoQdHuy());
			huyThanhTraKiemTraForm.setTenNguyenDnHuy(huyTtKt.getTenNguoiDeNghiHuy());
			huyThanhTraKiemTraForm.setVbQd(huyTtKt.getVbQdinhCnangNvu());

		}

	}

	private void saveHuyTtKt(HttpServletRequest request, HuyThanhTraKiemTraForm huyThanhTraKiemTraForm, ApplicationContext app) throws Exception {
		TtktCbHuy huyTtKt = createHuyTtKt(huyThanhTraKiemTraForm, app, request);
		TtktCnPhuService.saveHuyTtKt(huyTtKt, app, huyThanhTraKiemTraForm);
	}

	private TtktCbHuy createHuyTtKt(HuyThanhTraKiemTraForm huyForm, ApplicationContext app, HttpServletRequest request) throws Exception {
		TtktCbHuy huyTtKt = new TtktCbHuy();
		if (!Formater.isNull(huyForm.getChucVuNguoiDnHuy()))
			huyTtKt.setChucVuNguoiDeNghi(huyForm.getChucVuNguoiDnHuy());
		huyTtKt.setId(huyForm.getId());
		huyTtKt.setIdCuocTtkt(huyForm.getIdCuocTtKt());
		huyTtKt.setNgayHieuLuc(Formater.str2date(huyForm.getNgayHieuLuc()));
		if (!Formater.isNull(huyForm.getNgayRaQd()))
			huyTtKt.setNgayRaQd(Formater.str2date(huyForm.getNgayRaQd()));
		if (!Formater.isNull(huyForm.getNoiRaQd()))
			huyTtKt.setNoiRaQd(huyForm.getNoiRaQd());
		if (!Formater.isNull(huyForm.getSoQd()))
			huyTtKt.setSoQd(huyForm.getSoQd());
		if (!Formater.isNull(huyForm.getSoQdHuy()))
			huyTtKt.setSoQdHuy(huyForm.getSoQdHuy());
		if (!Formater.isNull(huyForm.getTenNguyenDnHuy()))
			huyTtKt.setTenNguoiDeNghiHuy(huyForm.getTenNguyenDnHuy());
		huyTtKt.setVbQdinhCnangNvu(huyForm.getVbQd());

		huyTtKt.setIdNguoiCapNat(app.getMaCanbo());
		huyTtKt.setTenNguoiCapNhat(app.getTenCanbo());
		huyTtKt.setNgayCapNhat(new Date());

		return huyTtKt;
	}
}
