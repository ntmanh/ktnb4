package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThGiaHan;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.catalog.CatalogService;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.GiaHanForm;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.PhucTraForm;

/**
 * Form bean for a Struts application.
 * 
 * @version 1.0
 * @author
 */
public class GiaHanAction extends BaseDispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		GiaHanForm giaHanForm = (GiaHanForm) form;
		if ("save".equals(request.getParameter("method"))) { 
			saveGiaHan(giaHanForm, appContext);
			request.setAttribute("saveStatus", "ok");
		} else if ("in".equals(request.getParameter("method"))) {
			inQuyetDinh(request, reponse, giaHanForm, appContext);
			return null;
		} else if ("inTT".equals(request.getParameter("method"))) {
			inToTrinh(request, reponse, giaHanForm, appContext);
			return null;
		} else {
			String cuocTtktId = request.getParameter("idCuocTtkt");
			if (!Formater.isNull(cuocTtktId)) { // Truong hop mo tu form main
				Collection dsGiaHan = TtktService.getDsGiaHan(appContext, cuocTtktId);
				if (KtnbUtil.isTruongDoan(appContext.getMaCanbo(), appContext, cuocTtktId)) {
					if (Formater.isNull(dsGiaHan) || "addnew".equals(request.getParameter("method"))) {
						if (CuocTtktService.getCuocTtkt(appContext, cuocTtktId).getNgayKetThuc() == null) {
							giaHanForm.setIdCuocTtKt(cuocTtktId);
						} else {
							giaHanForm.setIdCuocTtKt(cuocTtktId);
							request.setAttribute("access", "deny");
						}

					} else {
						// Mo danh sach de xem
						request.getSession().setAttribute("dsGiaHan", dsGiaHan);
						reponse.sendRedirect("danh_sach_tim_kiem.do?idCuocTtkt=" + cuocTtktId + "&type=giaHan");
					}
				} else {
					if (dsGiaHan.size() == 1) {
						loadDataToForm(giaHanForm, appContext, request, (TtktThGiaHan) ((ArrayList) dsGiaHan).get(0));
						request.setAttribute("readOnly", "true");

					} else {
						request.getSession().setAttribute("dsGiaHan", dsGiaHan);
						reponse.sendRedirect("danh_sach_tim_kiem.do?idCuocTtkt=" + cuocTtktId + "&type=giaHan");
					}

				}
			} else { // Truong hop mo len de xem, sua
				String id = request.getParameter("id");
				TtktThGiaHan giaHan = TtktCnPhuService.getGiaHanTtKtById(appContext, id);
				loadDataToForm(giaHanForm, appContext, request, giaHan);
				if (!"edit".equals(request.getParameter("method")) || appContext.getTrangThaiCuocTtkt(giaHanForm.getIdCuocTtKt()).equals(Constants.TT_TTKT_KT)) {
					request.setAttribute("readOnly", "true");
				}
			}
		}

		// Van ban quy dinh chuc nang nhiem vu
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktTrongQdWithoutNoiDung(appContext, giaHanForm.getIdCuocTtKt());
		KtnbUtil.setVanBan(cuocTtkt.getIdDonViTh(), request);
		// Danh sach cac ngay nghi
		String[] temp = cuocTtkt.getMa().split("/");
		String namTienHanh = temp[temp.length - 2];
		KtnbUtil.cacheListHolidayDayForClient(request, namTienHanh, String.valueOf(Integer.parseInt(namTienHanh) + 1));
		try {
			request.setAttribute("ngayRaQuyetDnh", Formater.objectDate2Str(TtktService.getQuyetDinh(request.getParameter("idCuocTtkt"), appContext).getNgayRaQuyetDnh()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapping.findForward("success");
	}

	/**
	 * @param giaHanForm
	 * @param appContext
	 * @param request
	 * @param id
	 */
	private void loadDataToForm(GiaHanForm giaHanForm, ApplicationContext appContext, HttpServletRequest request, TtktThGiaHan giaHan) throws Exception {

		giaHanForm.setDvCaNhanLq(giaHan.getDviCnhanLquan());
		giaHanForm.setId(giaHan.getId());
		giaHanForm.setIdCuocTtKt(giaHan.getIdCuocTtkt());
		giaHanForm.setKienPheDuyet(giaHan.getYKienPheDuyet());
		giaHanForm.setLyDoRaHan(giaHan.getLyDoGiaHan());
		giaHanForm.setNgayPheDuyet(Formater.date2str(giaHan.getNgayPheDuyet()));
		giaHanForm.setNgayRaQd(Formater.date2str(giaHan.getNgayRqQd()));
		giaHanForm.setNgayTrinh(Formater.date2str(giaHan.getNgayTrinh()));
		giaHanForm.setNoiPheDuyet(giaHan.getNoiPheDuyet());
		giaHanForm.setNoiRaQd(giaHan.getNoiRaQd());
		giaHanForm.setNoiTrinh(giaHan.getNoiTrinh());
		giaHanForm.setRaHanDenNgay(Formater.date2str(giaHan.getGiaHanDenNgay()));
		giaHanForm.setRaHanTuNgay(Formater.date2str(giaHan.getGiaHanTuNgay()));
		giaHanForm.setSoNgayRaHan(String.valueOf(giaHan.getSoNgayGiaHan()));
		giaHanForm.setSoQd(giaHan.getSoQd());
		giaHanForm.setVbQdCnNv(giaHan.getVbQdinhCnangNvu());
	}

	/**
	 * Download file mau TTNB11
	 * 
	 * @throws Exception
	 */
	private void inQuyetDinh(HttpServletRequest request, HttpServletResponse reponse, GiaHanForm giaHanForm, ApplicationContext appConText) throws Exception {
		String fileIn = request.getRealPath("/docin") + "\\TTNB11.doc";
		String fileOut = request.getRealPath("/docout") + "\\TTNB11_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

		String fileTemplate = null;
		fileTemplate = "ttnb11"; // (ngon, chuan)
		String idCuocTtkt = giaHanForm.getIdCuocTtKt();
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);

		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appConText);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		StringBuffer sb = new StringBuffer(hinhThuc);

		MsWordUtils word = new MsWordUtils(fileIn, fileOut);
		try {
			word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText).toUpperCase());
			word.put("[cqt_ra_quyet_dinh]", cuocTtkt.getTenDonViTh().toUpperCase());
			if (Formater.isNull(giaHanForm.getSoQd())) {
				word.put("[so_qd]", "....../Q\u0110-.......");
			} else {
				word.put("[so_qd]", giaHanForm.getSoQd().toString());
			}
			String ngaylap = giaHanForm.getNgayRaQd();
			String[] arrngaylap = ngaylap.split("/");
			if (giaHanForm.getNoiRaQd().equals("") && giaHanForm.getNgayRaQd().equals("")) {
				word.put("[noi_ra_qd]", ".....");
				word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			} else if (!giaHanForm.getNoiRaQd().equals("") && !giaHanForm.getNgayRaQd().equals("")) {
				word.put("[noi_ra_qd]", giaHanForm.getNoiRaQd());
				word.put("[ngay_ra_qd]", "ng\u00E0y " + arrngaylap[0] + " th\u00E1ng " + arrngaylap[1] + " n\u0103m " + arrngaylap[2]);
			} else if (giaHanForm.getNoiRaQd().equals("") && !giaHanForm.getNgayRaQd().equals("")) {
				word.put("[noi_ra_qd]", ".....");
				word.put("[ngay_ra_qd]", "ng\u00E0y " + arrngaylap[0] + " th\u00E1ng " + arrngaylap[1] + " n\u0103m " + arrngaylap[2]);
			} else if (!giaHanForm.getNoiRaQd().equals("") && giaHanForm.getNgayRaQd().equals("")) {
				word.put("[noi_ra_qd]", giaHanForm.getNoiRaQd());
				word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			}
			word.put("[ttkt]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
			word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText).toUpperCase());
			if (CatalogService.getTenDanhMucById(giaHanForm.getVbQdCnNv()).equals("N/A")) {
				word.put("[van_ban_quy_dinh]", KtnbUtil.inFieldNull(104) + ";");
			} else {
				word.put("[van_ban_quy_dinh]", CatalogService.getTenDanhMucById(giaHanForm.getVbQdCnNv()));
			}
			word.put("[ttkt]", hinhThuc);
			word.put("[ttkt]", hinhThuc);
			word.put("[qd_so]", cbQd.getSoQuyetDinh());
			String ngayxet = Formater.date2str(cbQd.getNgayRaQuyetDnh());
			String[] arrngayxet = ngayxet.split("/");
			word.put("[ngay_qd]", "ng\u00E0y " + arrngayxet[0] + " th\u00E1ng " + arrngayxet[1] + " n\u0103m " + arrngayxet[2]);
			word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
			word.put("[ttkt]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi().toString());
			word.put("[ttkt]", hinhThuc);
			word.put("[ttkt]", hinhThuc);
			word.put("[qd_so]", cbQd.getSoQuyetDinh());
			word.put("[ngay_qd]", "ng\u00E0y " + arrngayxet[0] + " th\u00E1ng " + arrngayxet[1] + " n\u0103m " + arrngayxet[2]);
			word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
			word.put("[ttkt1]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi().toString());
			word.put("[ngay_lv]", giaHanForm.getSoNgayRaHan());
			// tu ngay
			String tungay = giaHanForm.getRaHanTuNgay();
			String[] arrtungay = tungay.split("/");
			word.put("[tu_ngay]", "ng\u00E0y " + arrtungay[0] + " th\u00E1ng " + arrtungay[1] + " n\u0103m " + arrtungay[2]);
			// den ngay
			String denngay = giaHanForm.getRaHanDenNgay();
			String[] arrdenngay = denngay.split("/");
			word.put("[den_ngay]", "ng\u00E0y " + arrdenngay[0] + " th\u00E1ng " + arrdenngay[1] + " n\u0103m " + arrdenngay[2]);
			word.put("[ttkt]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi().toString());
			if (Formater.isNull(giaHanForm.getDvCaNhanLq())) {
				word.put("[dv_lien_quan]", "");
			} else {
				word.put("[dv_lien_quan]", ", " + giaHanForm.getDvCaNhanLq());
			}
			word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText));
			word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appConText.getMaCqt()).toUpperCase());
			// if (Formater.isNull(appConText.getTenThuTruong())) {
			// word.put("[ten_thu_truong]", "");
			// } else {
			// word.put("[ten_thu_truong]", appConText.getTenThuTruong());
			// }
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau TTNB11", ".doc", reponse);
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
	private void inQuyetDinhV4(HttpServletRequest request, HttpServletResponse reponse, GiaHanForm giaHanForm, ApplicationContext appConText) throws Exception {
		String fileIn = request.getRealPath("/docin/v4") + "\\TTNB11.doc";
		String fileOut = request.getRealPath("/docout") + "\\TTNB11_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

		String fileTemplate = null;
		fileTemplate = "ttnb11"; // (ngon, chuan)
		String idCuocTtkt = giaHanForm.getIdCuocTtKt();
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);

		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appConText);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		StringBuffer sb = new StringBuffer(hinhThuc);

		MsWordUtils word = new MsWordUtils(fileIn, fileOut);
		try {
			word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText).toUpperCase());
			word.put("[cqt_ra_quyet_dinh]", cuocTtkt.getTenDonViTh().toUpperCase());
			if (Formater.isNull(giaHanForm.getSoQd())) {
				word.put("[so_qd]", "....../Q\u0110-.......");
			} else {
				word.put("[so_qd]", giaHanForm.getSoQd().toString());
			}
			String ngaylap = giaHanForm.getNgayRaQd();
			String[] arrngaylap = ngaylap.split("/");
			if (giaHanForm.getNoiRaQd().equals("") && giaHanForm.getNgayRaQd().equals("")) {
				word.put("[noi_ra_qd]", ".....");
				word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			} else if (!giaHanForm.getNoiRaQd().equals("") && !giaHanForm.getNgayRaQd().equals("")) {
				word.put("[noi_ra_qd]", giaHanForm.getNoiRaQd());
				word.put("[ngay_ra_qd]", "ng\u00E0y " + arrngaylap[0] + " th\u00E1ng " + arrngaylap[1] + " n\u0103m " + arrngaylap[2]);
			} else if (giaHanForm.getNoiRaQd().equals("") && !giaHanForm.getNgayRaQd().equals("")) {
				word.put("[noi_ra_qd]", ".....");
				word.put("[ngay_ra_qd]", "ng\u00E0y " + arrngaylap[0] + " th\u00E1ng " + arrngaylap[1] + " n\u0103m " + arrngaylap[2]);
			} else if (!giaHanForm.getNoiRaQd().equals("") && giaHanForm.getNgayRaQd().equals("")) {
				word.put("[noi_ra_qd]", giaHanForm.getNoiRaQd());
				word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			}
			//word.put("[ttkt]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
			word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText).toUpperCase());
			if (CatalogService.getTenDanhMucById(giaHanForm.getVbQdCnNv()).equals("N/A")) {
				word.put("[van_ban_quy_dinh]", KtnbUtil.inFieldNull(104) + ";");
			} else {
				word.put("[van_ban_quy_dinh]", CatalogService.getTenDanhMucById(giaHanForm.getVbQdCnNv()));
			}
			//word.put("[ttkt]", hinhThuc);
			//word.put("[ttkt]", hinhThuc);
			word.put("[qd_so]", cbQd.getSoQuyetDinh());
			String ngayxet = Formater.date2str(cbQd.getNgayRaQuyetDnh());
			String[] arrngayxet = ngayxet.split("/");
			word.put("[ngay_qd]", "ng\u00E0y " + arrngayxet[0] + " th\u00E1ng " + arrngayxet[1] + " n\u0103m " + arrngayxet[2]);
			word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
			//word.put("[ttkt]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi().toString());
			//word.put("[ttkt]", hinhThuc);
			//word.put("[ttkt]", hinhThuc);
			word.put("[qd_so]", cbQd.getSoQuyetDinh());
			word.put("[ngay_qd]", "ng\u00E0y " + arrngayxet[0] + " th\u00E1ng " + arrngayxet[1] + " n\u0103m " + arrngayxet[2]);
			word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
			//word.put("[ttkt1]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi().toString());
			word.put("[ngay_lv]", giaHanForm.getSoNgayRaHan());
			// tu ngay
			String tungay = giaHanForm.getRaHanTuNgay();
			String[] arrtungay = tungay.split("/");
			word.put("[tu_ngay]", "ng\u00E0y " + arrtungay[0] + " th\u00E1ng " + arrtungay[1] + " n\u0103m " + arrtungay[2]);
			// den ngay
			String denngay = giaHanForm.getRaHanDenNgay();
			String[] arrdenngay = denngay.split("/");
			word.put("[den_ngay]", "ng\u00E0y " + arrdenngay[0] + " th\u00E1ng " + arrdenngay[1] + " n\u0103m " + arrdenngay[2]);
			//word.put("[ttkt]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi().toString());
			if (Formater.isNull(giaHanForm.getDvCaNhanLq())) {
				word.put("[dv_lien_quan]", "");
			} else {
				word.put("[dv_lien_quan]", ", " + giaHanForm.getDvCaNhanLq());
			}
			word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText));
			word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appConText.getMaCqt()).toUpperCase());
			// if (Formater.isNull(appConText.getTenThuTruong())) {
			// word.put("[ten_thu_truong]", "");
			// } else {
			// word.put("[ten_thu_truong]", appConText.getTenThuTruong());
			// }
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau TTNB11", ".doc", reponse);
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
	//v3
	private void inToTrinhv3(HttpServletRequest request, HttpServletResponse reponse, GiaHanForm giaHanForm, ApplicationContext appConText) throws Exception {

		String fileIn = request.getRealPath("/docin") + "\\TTNB10.doc";
		String fileOut = request.getRealPath("/docout") + "\\TTNB10_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

		String fileTemplate = null;
		fileTemplate = "ttnb10"; // (ngon, chuan)
		String idCuocTtkt = giaHanForm.getIdCuocTtKt();
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);

		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appConText);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		StringBuffer sb = new StringBuffer(hinhThuc);

		MsWordUtils word = new MsWordUtils(fileIn, fileOut);
		try {
			word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText).toUpperCase());
			// hinh thuc thanh tra kiem tra
			if (Formater.isNull(giaHanForm.getSoQd())) {
				sb.append(" Q\u0110 S\u1ED0......");
			} else {
				sb.append(" Q\u0110 S\u1ED0 " + giaHanForm.getSoQd());
			}
			word.put("[doan_ttkt_so]", sb.toString().toUpperCase());

			word.put("[ttkt]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
			word.put("[thu_truong_cqt_ra_qd]", KtnbUtil.getTenThuTruongCqtForMauin(appConText).toUpperCase());
			word.put("[ttkt]", hinhThuc);
			if (Formater.isNull(cbQd.getSoQuyetDinh())) {
				word.put("[qd_so]", "............");
			} else {
				word.put("[qd_so]", cbQd.getSoQuyetDinh());
			}

			String ngayxet = Formater.date2str(cbQd.getNgayRaQuyetDnh());
			String[] arrngayxet = ngayxet.split("/");
			word.put("[ngay_qd]", "ng\u00E0y " + arrngayxet[0] + " th\u00E1ng " + arrngayxet[1] + " n\u0103m " + arrngayxet[2]);
			word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
			word.put("[ttkt]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());

			word.put("[ttkt]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi().toString());
			word.put("[ngay_lv]", giaHanForm.getSoNgayRaHan());
			String tungay = giaHanForm.getRaHanTuNgay();
			String[] arrtungay = tungay.split("/");
			word.put("[tu_ngay]", "ng\u00E0y " + arrtungay[0] + " th\u00E1ng " + arrtungay[1] + " n\u0103m " + arrtungay[2]);
			// den ngay
			String denngay = giaHanForm.getRaHanDenNgay();
			String[] arrdenngay = denngay.split("/");
			word.put("[den_ngay]", "ng\u00E0y " + arrdenngay[0] + " th\u00E1ng " + arrdenngay[1] + " n\u0103m " + arrdenngay[2]);
			word.put("[ly_do]", giaHanForm.getLyDoRaHan());
			word.put("[thu_truong_cqt_ra_qd]", KtnbUtil.getTenThuTruongCqtForMauin(appConText).toUpperCase());
			word.put("[noi_duyet]", giaHanForm.getNoiPheDuyet());
			// ngay duyet
			String ngayduyet = giaHanForm.getNgayPheDuyet();
			String[] arrngayduyet = ngayduyet.split("/");
			if (arrngayduyet.length >= 2) {
				word.put("[ngay_duyet]", "ng\u00E0y " + arrngayduyet[0] + " th\u00E1ng " + arrngayduyet[1] + " n\u0103m " + arrngayduyet[2]);
			}
			word.put("[noi_lap]", giaHanForm.getNoiTrinh());
			// ngay lap to trinh
			String ngaylaptotrinh = giaHanForm.getNgayTrinh();
			String[] arrngaylaptotrinh = ngaylaptotrinh.split("/");
			if (arrngaylaptotrinh.length >= 2) {
				word.put("[ngay_lap_to_trinh]", "ng\u00E0y " + arrngaylaptotrinh[0] + " th\u00E1ng " + arrngaylaptotrinh[1] + " n\u0103m " + arrngaylaptotrinh[2]);
			}
			word.put("[ttkt]", hinhThuc);
			word.put("[y_kien_phe_duyet]", giaHanForm.getKienPheDuyet());
			word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
			word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appConText.getMaCqt()).toUpperCase());
			// if (Formater.isNull(appConText.getTenThuTruong())) {
			// word.put("[ten_thu_truong]", "");
			// } else {
			// word.put("[ten_thu_truong]", appConText.getTenThuTruong());
			// }
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau TTNB10", ".doc", reponse);
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
	//v4
	private void inToTrinh(HttpServletRequest request, HttpServletResponse reponse, GiaHanForm giaHanForm, ApplicationContext appConText) throws Exception {

		String fileIn = request.getRealPath("/docin/v4") + "\\TTNB10.doc";
		String fileOut = request.getRealPath("/docout") + "\\TTNB10_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

		String fileTemplate = null;
		fileTemplate = "ttnb10"; // (ngon, chuan)
		String idCuocTtkt = giaHanForm.getIdCuocTtKt();
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);

		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appConText);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		StringBuffer sb = new StringBuffer(hinhThuc);

		MsWordUtils word = new MsWordUtils(fileIn, fileOut);
		try {
			word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText).toUpperCase());
			// hinh thuc thanh tra kiem tra
			if (Formater.isNull(giaHanForm.getSoQd())) {
				sb.append(" Q\u0110 S\u1ED0......");
			} else {
				sb.append(" Q\u0110 S\u1ED0 " + giaHanForm.getSoQd());
			}
			word.put("[doan_ttkt_so]", sb.toString().toUpperCase());

			//word.put("[ttkt]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
			word.put("[thu_truong_cqt_ra_qd]", KtnbUtil.getTenThuTruongCqtForMauin(appConText).toUpperCase());
			//word.put("[ttkt]", hinhThuc);
			word.put("[quyet_dinh_so]", "7");
			word.put("[quyet_dinh_ngay]", "09/04/2014");
			if (Formater.isNull(cbQd.getSoQuyetDinh())) {
				word.put("[qd_so]", "............");
			} else {
				word.put("[qd_so]", cbQd.getSoQuyetDinh());
			}

			String ngayxet = Formater.date2str(cbQd.getNgayRaQuyetDnh());
			String[] arrngayxet = ngayxet.split("/");
			word.put("[ngay_qd]", "ng\u00E0y " + arrngayxet[0] + " th\u00E1ng " + arrngayxet[1] + " n\u0103m " + arrngayxet[2]);
			word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
			//word.put("[ttkt]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());

			//word.put("[ttkt]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi().toString());
			word.put("[ngay_lv]", giaHanForm.getSoNgayRaHan());
			String tungay = giaHanForm.getRaHanTuNgay();
			String[] arrtungay = tungay.split("/");
			word.put("[tu_ngay]", "ng\u00E0y " + arrtungay[0] + " th\u00E1ng " + arrtungay[1] + " n\u0103m " + arrtungay[2]);
			// den ngay
			String denngay = giaHanForm.getRaHanDenNgay();
			String[] arrdenngay = denngay.split("/");
			word.put("[den_ngay]", "ng\u00E0y " + arrdenngay[0] + " th\u00E1ng " + arrdenngay[1] + " n\u0103m " + arrdenngay[2]);
			word.put("[ly_do]", giaHanForm.getLyDoRaHan());
			word.put("[thu_truong_cqt_ra_qd]", KtnbUtil.getTenThuTruongCqtForMauin(appConText).toUpperCase());
			word.put("[noi_duyet]", giaHanForm.getNoiPheDuyet());
			// ngay duyet
			String ngayduyet = giaHanForm.getNgayPheDuyet();
			String[] arrngayduyet = ngayduyet.split("/");
			if (arrngayduyet.length >= 2) {
				word.put("[ngay_duyet]", "ng\u00E0y " + arrngayduyet[0] + " th\u00E1ng " + arrngayduyet[1] + " n\u0103m " + arrngayduyet[2]);
			}
			word.put("[noi_lap]", giaHanForm.getNoiTrinh());
			// ngay lap to trinh
			String ngaylaptotrinh = giaHanForm.getNgayTrinh();
			String[] arrngaylaptotrinh = ngaylaptotrinh.split("/");
			if (arrngaylaptotrinh.length >= 2) {
				word.put("[ngay_lap_to_trinh]", "ng\u00E0y " + arrngaylaptotrinh[0] + " th\u00E1ng " + arrngaylaptotrinh[1] + " n\u0103m " + arrngaylaptotrinh[2]);
			}
			//word.put("[ttkt]", hinhThuc);
			word.put("[y_kien_phe_duyet]", giaHanForm.getKienPheDuyet());
			word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
			//word.put("[chuc_danh_thu_truong]", "ABC");
			word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appConText.getMaCqt()).toUpperCase());
			// if (Formater.isNull(appConText.getTenThuTruong())) {
			// word.put("[ten_thu_truong]", "");
			// } else {
			// word.put("[ten_thu_truong]", appConText.getTenThuTruong());
			// }
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau TTNB10", ".doc", reponse);
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

	private void loadDefaulForm(GiaHanForm form, ApplicationContext app, HttpServletRequest request, String cuocTtktId, String id) throws Exception {
		TtktThGiaHan giaHan = TtktCnPhuService.getGiaHanTtKtByIdCuocTtkt(app, cuocTtktId);
		form.setIdCuocTtKt(cuocTtktId);
		if (giaHan != null) {
			form.setId(giaHan.getId());
			form.setIdCuocTtKt(giaHan.getIdCuocTtkt());
			form.setNoiTrinh(giaHan.getNoiTrinh());
			form.setNgayTrinh(Formater.date2str(giaHan.getNgayTrinh()));
			form.setNoiPheDuyet(giaHan.getNoiPheDuyet());
			form.setNgayPheDuyet(Formater.date2str(giaHan.getNgayPheDuyet()));
			form.setKienPheDuyet(giaHan.getYKienPheDuyet());
			form.setSoQd(giaHan.getSoQd());
			form.setNoiRaQd(giaHan.getNoiRaQd());
			form.setNgayRaQd(Formater.date2str(giaHan.getNgayRqQd()));
			form.setSoNgayRaHan(giaHan.getSoNgayGiaHan().toString());
			form.setRaHanTuNgay(Formater.date2str(giaHan.getGiaHanTuNgay()));
			form.setRaHanDenNgay(Formater.date2str(giaHan.getGiaHanDenNgay()));
			form.setLyDoRaHan(giaHan.getLyDoGiaHan());
			form.setDvCaNhanLq(giaHan.getDviCnhanLquan());
			form.setVbQdCnNv(giaHan.getVbQdinhCnangNvu());

		}

	}

	private void saveGiaHan(GiaHanForm form, ApplicationContext app) throws Exception {

		TtktThGiaHan giaHan = new TtktThGiaHan();

		giaHan.setId(form.getId());
		giaHan.setIdCuocTtkt(form.getIdCuocTtKt());
		giaHan.setNoiTrinh(form.getNoiTrinh());
		giaHan.setNgayTrinh(Formater.str2date(form.getNgayTrinh()));
		giaHan.setNoiPheDuyet(form.getNoiPheDuyet());
		giaHan.setNgayPheDuyet(Formater.str2date(form.getNgayPheDuyet()));
		giaHan.setYKienPheDuyet(form.getKienPheDuyet());
		giaHan.setSoQd(form.getSoQd());
		giaHan.setNoiRaQd(form.getNoiRaQd());
		giaHan.setNgayRqQd(Formater.str2date(form.getNgayRaQd()));
		giaHan.setSoNgayGiaHan(Byte.valueOf(form.getSoNgayRaHan()));
		giaHan.setGiaHanTuNgay(Formater.str2date(form.getRaHanTuNgay()));
		// --- cong ngay ---------
		Date denNgay = KtnbUtil.addBusinessDate(giaHan.getGiaHanTuNgay(), giaHan.getSoNgayGiaHan().intValue() - 1);

		giaHan.setGiaHanDenNgay(denNgay);
		giaHan.setLyDoGiaHan(form.getLyDoRaHan());
		giaHan.setDviCnhanLquan(form.getDvCaNhanLq());
		giaHan.setVbQdinhCnangNvu(form.getVbQdCnNv());

		TtktCnPhuService.saveGiaHan(giaHan, app, form);
	}

	private Date congNgay(Byte soNgay, Date ngayBatDau) {
		int soNgay2 = soNgay.intValue();
		Calendar cal = Calendar.getInstance();
		cal.setTime(ngayBatDau);
		cal.add(Calendar.DATE, soNgay2 - 1);
		Date denNgay = cal.getTime();
		return denNgay;
	}

}
