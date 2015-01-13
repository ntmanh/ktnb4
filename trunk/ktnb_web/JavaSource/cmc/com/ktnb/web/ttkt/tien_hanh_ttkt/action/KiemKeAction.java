package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.action;

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

import com.jacob.com.Dispatch;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmBienBan;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBienBanKiemKe;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThCongBoQd;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThQdKiemKe;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.dung_chung.form.BienBanLamViecForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.KiemKeForm;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.TienHanhTtktForm;

/**
 * Form bean for a Struts application.
 * 
 * @version 1.0
 * @author
 */
public class KiemKeAction extends BaseDispatchAction {

	public ActionForward execute1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {

		KiemKeForm kiemkeForm = (KiemKeForm) form;
		String method = request.getParameter("method");
		ApplicationContext app = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String cuocTtktId = request.getParameter("idCuocTtkt");
		String id = request.getParameter("id");
		if (cuocTtktId == null) {
			cuocTtktId = kiemkeForm.getIdCuocTtkt();
		}
		TtktCbDsTvDoan dsTvd = TtktService.getDsTvd(cuocTtktId, app);
		request.setAttribute("dsTvd", dsTvd.getChiTietDanhSachTV());
		loadDsTvDoan(cuocTtktId, request);
		if ("save".equals(method)) {
			//saveQDKK(kiemkeForm, app);
			request.setAttribute("save", "ok");
		} else if ("in".equals(method)) {
			inKiemke(request, reponse, kiemkeForm, app);
			return null;
		} else {
			loadDefault(kiemkeForm, app, id, cuocTtktId);
			if (!KtnbUtil.haveRoleNv(app) || app.getTrangThaiCuocTtkt(cuocTtktId).equals(Constants.TT_TTKT_KT))
				request.setAttribute("readOnly", "true");
		}

		return mapping.findForward("success");
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {

		ApplicationContext app = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		KiemKeForm kiemKeForm = (KiemKeForm) form;
		String method = request.getParameter("method");
		if ("save".equals(method)) {
			saveQDKK(reponse,request,kiemKeForm, app);
			request.setAttribute("dsTvd", TtktService.getDsTvdById(app, kiemKeForm.getIdDsTvd()));
			//request.setAttribute("saveStatus", "true");
		} else if ("in".equals(method)) {
			// TODO: Kiem tra xem cho nay co phai load lai lan nua khong
			inKiemke(request, reponse, kiemKeForm, app);
			return null;
		} else {
			String cuocTtktId = request.getParameter("idCuocTtkt");
			if (!Formater.isNull(cuocTtktId)) { // Nguoi dung click chon vao
				// link tai form main hoac mo
				// man hinh tao moi tu form tim
				// kiem
				if ("addnew".equals(method)) { // Tao moi tu man hinh tim kiem
					addNew(request, app, kiemKeForm, cuocTtktId);

				} else { // Click vao link tai form main
					Collection dsKkTaiSan = TtktCnPhuService.getDsQdKk(app, cuocTtktId);
					if (Formater.isNull(dsKkTaiSan)) { // Truong doan
						// them moi
						addNew(request, app, kiemKeForm, cuocTtktId);
					} else {
						if (!app.isTruongDoan(cuocTtktId) && dsKkTaiSan.size() == 1) {
							// Thu truong co quan va co 1 ban ghi
							loadDataToForm(request, app, kiemKeForm, (TtktThQdKiemKe) ((ArrayList) dsKkTaiSan).get(0));
							request.setAttribute("readOnly", "true");
							return mapping.findForward("success");

						}
						request.getSession().setAttribute("dsKkTaiSan", dsKkTaiSan);
						reponse.sendRedirect("danh_sach_tim_kiem.do?idCuocTtkt=" + cuocTtktId + "&type=kkTS");
					}
				}

			} else {
				// Truong hop xem hoac sua thi truyen id vao url
				String id = request.getParameter("id");
				loadDataToForm(request, app, kiemKeForm, id);
				if (!KtnbUtil.haveRoleNv(app) || "view".equals(method) || app.getTrangThaiCuocTtkt(kiemKeForm.getIdCuocTtkt()).equals(Constants.TT_TTKT_KT)) {
					request.setAttribute("readOnly", "true");
				}

			}
		}

		return mapping.findForward("success");
	}

	private void addNew(HttpServletRequest request, ApplicationContext app, KiemKeForm kiemKeForm, String cuocTtktId) throws Exception {
		kiemKeForm.setIdCuocTtkt(cuocTtktId);
		TtktCbDsTvDoan dsTvd = TtktService.getDsTvd(cuocTtktId, app);
		kiemKeForm.setIdDsTvd(dsTvd.getId());
		request.setAttribute("dsTvd", dsTvd.getChiTietDanhSachTV());

	}

	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, KiemKeForm kiemKeForm, String id) throws Exception {
		TtktThQdKiemKe qdkk = TtktCnPhuService.getKiemKeTaiSan(app, id);
		loadDataToForm(request, app, kiemKeForm, qdkk);

	}
	
	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, KiemKeForm kiemKeForm, TtktThQdKiemKe qdkk) throws Exception {

		//Quyet dinh kiem ke
		kiemKeForm.setIdCuocTtkt(qdkk.getIdCuocTtkt());
		kiemKeForm.setThoiGianKk(Formater.date2strDateTimeForNV(qdkk.getThoiGianKk()));
		kiemKeForm.setTaiSanCanKiemKe(qdkk.getTaiSanDuocKiemKe());
		kiemKeForm.setDonViCaNhanBaoQuan(qdkk.getDonViDangBaoQuan());
		kiemKeForm.setDiaDiemCoTsKk(qdkk.getDiaDiemCoTsKk());
		kiemKeForm.setNoiRaQd(qdkk.getNoiRaQd());
		kiemKeForm.setNgayRaQd(Formater.date2str(qdkk.getNgayRaQd()));
		kiemKeForm.setThuTruongDonViCoTSKK(qdkk.getThuTruongDvCoTskk());
		kiemKeForm.setDonViCoLienQuan(qdkk.getCquanTchucCnhanCoLquan());
		kiemKeForm.setDonViDangBaoQuan(qdkk.getDonViDangBaoQuan());
		kiemKeForm.setDonViCaNhanDuocKk(qdkk.getDviCnhanDuocKk());
		
		TtktThBienBanKiemKe bbkk = qdkk.getBbKK();
		
		//TtktCbDsTvDoan dsTvd = null;
		//if (Formater.isNull(bbkk.getIdQdKk())) {
		//	dsTvd = TtktService.getDsTvdById(bbkk.getIdDsTvd(), app);
		//	kiemKeForm.setIdDsTvd(dsTvd.getId());
		//	request.setAttribute("dsTvd", dsTvd.getChiTietDanhSachTV());
		//} else {
		//	request.setAttribute("dsTvd", TtktService.getDsTvdById(app, bbkk.getIdDsTvd()));
		//}
		
		if (bbkk != null) {
			TtktCbDsTvDoan dsTvd = TtktService.getDsTvdById(bbkk.getIdDsTvd(), app);
			kiemKeForm.setIdDsTvd(dsTvd.getId());
			request.setAttribute("dsTvd", dsTvd.getChiTietDanhSachTV());
			
			kiemKeForm.setIdBBKK(bbkk.getId());
			kiemKeForm.setIdDaiDienDoanTTKT(bbkk.getIdDaiDienDoanTtkt());
			kiemKeForm.setIdDaiDienDVCOTSTKK(bbkk.getIdDaiDienDviCnhanCoTskk());
			kiemKeForm.setIdQdKk(bbkk.getIdQdKk());
			kiemKeForm.setThoiGianBatDau(Formater.date2strDateTimeForNV(bbkk.getThoiGianBatDau()));
			kiemKeForm.setThoiGianKetThuc(Formater.date2strDateTimeForNV(bbkk.getThoiGianKetThuc()));
			kiemKeForm.setSoluongChungloaiXs(bbkk.getSoluongChungloaiXs());
			kiemKeForm.setThoiDiemLapBb(Formater.date2strDateTimeForNV(bbkk.getThoiDiemLapBb()));
			kiemKeForm.setThoiDiemKk(Formater.date2strDateTimeForNV(bbkk.getThoiDiemKk()));
			kiemKeForm.setDvDuocGiaoBQTS(bbkk.getDviCnhanDuocGiaoBaoQuan());
			
			
			Collection dsTpTd = bbkk.getDsDoanTtkt();
			if (dsTpTd != null) {
				TtktCmThanhPhanThamDu[] dsTpTdLoad1 = new TtktCmThanhPhanThamDu[dsTpTd.size()];
				Iterator iter = dsTpTd.iterator();
				int i = 0;
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
					dsTpTdLoad1[i] = tptd;
					i++;

				}
				kiemKeForm.setDonViTtKt(dsTpTdLoad1);
			}

			Collection dsDVCoTsKk = bbkk.getDsDonViCoTsKk();
			if (dsDVCoTsKk != null) {
				TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[dsDVCoTsKk.size()];
				Iterator iter = dsDVCoTsKk.iterator();
				int i = 0;
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
					dsTpTdLoad[i] = tptd;
					i++;
				}
				kiemKeForm.setDonViCoTaiSanDuocKK(dsTpTdLoad);

			}
		}else{
			//bbkk = TtktCnPhuService.getBienBanKkByQdKk(app, qdkk.getId());
			kiemKeForm.setIdQdKk(qdkk.getId());
			TtktCbDsTvDoan dsTvdkk = TtktService.getDsTvd(qdkk.getIdCuocTtkt(), app);
			kiemKeForm.setIdDsTvd(dsTvdkk.getId());
			request.setAttribute("dsTvd", dsTvdkk.getChiTietDanhSachTV());
		}
		
		

	}

	private void loadDataToForm_old(HttpServletRequest request, ApplicationContext app, KiemKeForm kiemKeForm, TtktThQdKiemKe qdkk) throws Exception {

		TtktThBienBanKiemKe bbkk = qdkk.getBbKK();
		if (bbkk == null) {
			bbkk = TtktCnPhuService.getBienBanKkByQdKk(app, qdkk.getId());
		}
		kiemKeForm.setIdBBKK(bbkk.getId());
		kiemKeForm.setIdCuocTtkt(qdkk.getIdCuocTtkt());
		kiemKeForm.setIdDaiDienDoanTTKT(bbkk.getIdDaiDienDoanTtkt());
		kiemKeForm.setIdDaiDienDVCOTSTKK(bbkk.getIdDaiDienDviCnhanCoTskk());
		kiemKeForm.setIdQdKk(bbkk.getIdQdKk());
		kiemKeForm.setThoiGianBatDau(Formater.date2strDateTimeForNV(bbkk.getThoiGianBatDau()));
		kiemKeForm.setThoiGianKetThuc(Formater.date2strDateTimeForNV(bbkk.getThoiGianKetThuc()));
		kiemKeForm.setSoluongChungloaiXs(bbkk.getSoluongChungloaiXs());
		kiemKeForm.setThoiDiemLapBb(Formater.date2strDateTimeForNV(bbkk.getThoiDiemLapBb()));
		kiemKeForm.setThoiDiemKk(Formater.date2strDateTimeForNV(bbkk.getThoiDiemKk()));
		kiemKeForm.setThoiGianKk(Formater.date2strDateTimeForNV(qdkk.getThoiGianKk()));
		kiemKeForm.setDvDuocGiaoBQTS(bbkk.getDviCnhanDuocGiaoBaoQuan());
		// Quyet dinh kiem ke
		kiemKeForm.setThoiDiemKk(Formater.date2strDateTimeForNV(qdkk.getThoiGianKk()));
		kiemKeForm.setTaiSanCanKiemKe(qdkk.getTaiSanDuocKiemKe());
		kiemKeForm.setDonViCaNhanBaoQuan(qdkk.getDonViDangBaoQuan());
		kiemKeForm.setDiaDiemCoTsKk(qdkk.getDiaDiemCoTsKk());
		kiemKeForm.setNoiRaQd(qdkk.getNoiRaQd());
		kiemKeForm.setNgayRaQd(Formater.date2str(qdkk.getNgayRaQd()));
		kiemKeForm.setThuTruongDonViCoTSKK(qdkk.getThuTruongDvCoTskk());
		kiemKeForm.setDonViCoLienQuan(qdkk.getCquanTchucCnhanCoLquan());
		kiemKeForm.setDonViDangBaoQuan(qdkk.getDonViDangBaoQuan());
		kiemKeForm.setDonViCaNhanDuocKk(qdkk.getDviCnhanDuocKk());

		TtktCbDsTvDoan dsTvd = TtktService.getDsTvdById(bbkk.getIdDsTvd(), app);
		kiemKeForm.setIdDsTvd(dsTvd.getId());
		request.setAttribute("dsTvd", dsTvd.getChiTietDanhSachTV());

		Collection dsTpTd = bbkk.getDsDoanTtkt();
		if (dsTpTd != null) {
			TtktCmThanhPhanThamDu[] dsTpTdLoad1 = new TtktCmThanhPhanThamDu[dsTpTd.size()];
			Iterator iter = dsTpTd.iterator();
			int i = 0;
			while (iter.hasNext()) {
				TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
				dsTpTdLoad1[i] = tptd;
				i++;

			}
			kiemKeForm.setDonViTtKt(dsTpTdLoad1);
		}

		Collection dsDVCoTsKk = bbkk.getDsDonViCoTsKk();
		if (dsDVCoTsKk != null) {
			TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[dsDVCoTsKk.size()];
			Iterator iter = dsDVCoTsKk.iterator();
			int i = 0;
			while (iter.hasNext()) {
				TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
				dsTpTdLoad[i] = tptd;
				i++;
			}
			kiemKeForm.setDonViCoTaiSanDuocKK(dsTpTdLoad);

		}

	}

	/**
	 * @param request
	 * @param reponse
	 * @param kiemkeForm
	 */
	private void inKiemke_old(HttpServletRequest request, HttpServletResponse reponse, KiemKeForm kiemkeForm, ApplicationContext appConText) throws Exception {
		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		if ("qdkk".equals(type)) {
			fileTemplate = "ttnb20";
			// Loc sua lai sau
			String idCuocTtkt = kiemkeForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);

			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appConText);
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
			String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
			StringBuffer sb = new StringBuffer(hinhThuc);
			parameters.put("ttkt", sb.toString());
			sb = new StringBuffer("\u0110O\u00C0N ");
			sb.append(hinhthuc_inT);
			sb.append(" Q\u0110 S\u1ED0 ");
			sb.append(cbQd.getSoQuyetDinh());
			parameters.put("doan_ttkt_so", sb.toString());
			parameters.put("ten_cqt", appConText.getTenCqt());
			parameters.put("dv_dc_ttkt", cuocTtkt.getTenDonViBi());
			parameters.put("so_qd", cbQd.getSoQuyetDinh());
			String ngayttkt = Formater.date2str(cbQd.getNgayRaQuyetDnh());
			String[] arrngayttkt = ngayttkt.split("/");
			parameters.put("ngay_ra_qd", "ng\u00E0y " + arrngayttkt[0] + " th\u00E1ng " + arrngayttkt[1] + " n\u0103m " + arrngayttkt[2]);
			parameters.put("thu_truong_cqt", KtnbUtil.getTenThuTruongCqt(appConText));
			parameters.put("tai_san", kiemkeForm.getTaiSanCanKiemKe());
			parameters.put("dv_quan_ly_tai_san", kiemkeForm.getDonViDangBaoQuan());
			parameters.put("dv_bao_quan", kiemkeForm.getDonViCaNhanBaoQuan());
			parameters.put("dv_dc_kiem_ke", kiemkeForm.getDonViCaNhanDuocKk());
			parameters.put("dv_lien_quan", kiemkeForm.getDonViCoLienQuan());
			parameters.put("dia_diem_noi_co_tai_san_kiem_ke", kiemkeForm.getDiaDiemCoTsKk());
			parameters.put("thu_truong_dv_co_tai_san_kiem_ke", kiemkeForm.getThuTruongDonViCoTSKK());
			parameters.put("thoi_gian_kiem_ke", Formater.getDateTimeForPrint(kiemkeForm.getThoiGianKk()));
			parameters.put("ten_truong_doan", cuocTtkt.getTenTruongDoan());

			String ngaylap = kiemkeForm.getNgayRaQd();
			String[] arrngaylap = ngaylap.split("/");
			if (kiemkeForm.getNoiRaQd().equals("") || kiemkeForm.getNgayRaQd().equals("")) {
				parameters.put("noi_ra_qd", ".....");
				parameters.put("ngay_lap", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			} else {
				parameters.put("noi_ra_qd", kiemkeForm.getNoiRaQd());
				parameters.put("ngay_lap", "ng\u00E0y " + arrngaylap[0] + " th\u00E1ng " + arrngaylap[1] + " n\u0103m " + arrngaylap[2]);
			}
			//

			//
		} else if (type.equals("bbkk")) {

			fileTemplate = "ttnb21"; // (ngon, chuan)
			// Loc sua lai sau
			String idCuocTtkt = kiemkeForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);
			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appConText);
			StringBuffer defaultPrint = new StringBuffer("\u00D4ng (B\u00E0)................             Ch\u1EE9c v\u1EE5:...............");
			defaultPrint.append("\n\u00D4ng (B\u00E0)................             Ch\u1EE9c v\u1EE5:...............");
			defaultPrint.append("\n......................................................................................");
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
			String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
			StringBuffer sb = new StringBuffer(hinhThuc);
			parameters.put("ttkt", sb.toString());
			sb = new StringBuffer("\u0110O\u00C0N ");
			sb.append(hinhthuc_inT);
			sb.append(" Q\u0110 S\u1ED0 ");
			sb.append(cbQd.getSoQuyetDinh());
			parameters.put("doan_ttkt_so", sb.toString());
			parameters.put("ten_cqt", appConText.getTenCqt());
			// ngay kiem ke

			parameters.put("ngay_kiem_ke", Formater.getDateForPrint(kiemkeForm.getNgayRaQd()));
			// thoi gian lap bien ban
			parameters.put("dv_dc_ttkt", cuocTtkt.getTenDonViBi());
			parameters.put("so_qd", cbQd.getSoQuyetDinh());
			if (Formater.isNull(kiemkeForm.getDvDuocGiaoBQTS())) {
				parameters.put("dv_bao_quan", "...............");
			} else {
				parameters.put("dv_bao_quan", kiemkeForm.getDvDuocGiaoBQTS());
			}
			parameters.put("thoi_gian_lap_bien_ban", Formater.getDateTimeForPrint(kiemkeForm.getThoiDiemLapBb()));
			if (Formater.isNull(kiemkeForm.getNoiRaQd())) {
				parameters.put("dia_diem", "..........");
			} else {
				parameters.put("dia_diem", kiemkeForm.getNoiRaQd());
			}
			// TODO: chua co truong dia diem lap bien ban tren form
			parameters.put("thu_truong_qd", KtnbUtil.getTenThuTruongCqt(appConText));
			parameters.put("ten_truong_doan", cuocTtkt.getTenTruongDoan());
			parameters.put("dv_co_tai_san_kiem_ke", cuocTtkt.getTenDonViBi());
			parameters.put("gom", kiemkeForm.getSoluongChungloaiXs());
			// thoi diem kiem ke
			parameters.put("thoi_diem_kiem_ke", Formater.getDateTimeForPrint(kiemkeForm.getThoiDiemKk()));
			parameters.put("time_tu", Formater.getDateTimeForPrint(kiemkeForm.getThoiGianBatDau()));
			parameters.put("time_den", Formater.getDateTimeForPrint(kiemkeForm.getThoiGianKetThuc()));
			// dai dien doan ttkt
			TtktCmThanhPhanThamDu[] arrthanhphanbg = kiemkeForm.getDonViTtKt();
			StringBuffer tptd = new StringBuffer("");
			if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
				for (int i = 0; i < arrthanhphanbg.length; i++) {
					tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg[i].getHoTen()));
					tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg[i].getChucVu()));
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				parameters.put("thanh_vien", tptd.toString().substring(0, tptd.toString().length() - 1));
			} else {
				parameters.put("thanh_vien", defaultPrint.toString());
			}
			// dai dien dv co tai san dc kiem ke
			TtktCmThanhPhanThamDu[] arrthanhphankk = kiemkeForm.getDonViCoTaiSanDuocKK();
			StringBuffer kk = new StringBuffer("");
			// if (arrthanhphanbg != null && arrthanhphanbg.length > 0) { //code
			// cu
			if (arrthanhphankk != null && arrthanhphankk.length > 0) {
				for (int i = 0; i < arrthanhphankk.length; i++) {
					kk.append(KtnbUtil.layoutTableHoTen(arrthanhphankk[i].getHoTen()));
					kk.append(KtnbUtil.layoutTableChucVu(arrthanhphankk[i].getChucVu()));
					kk.append("\n");
				}
				System.out.println(kk.toString());
				parameters.put("thanh_vien_dv", kk.toString().substring(0, kk.toString().length() - 1));
			} else {
				parameters.put("thanh_vien_dv", defaultPrint.toString());
			}
			//
		}
		if (Formater.isNull(fileTemplate))
			throw new Exception("Chua chon file template");

		InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
		KtnbUtil.printf(reportRows, fileTemplate, reponse, inputStream, parameters, null);
	}
	
	/**
	 * Download file mau TTNB20,TTNB21
	 * 
	 * @throws Exception
	 */
	
	//v3
	private void inKiemkev3(HttpServletRequest request, HttpServletResponse reponse, KiemKeForm kiemkeForm, ApplicationContext appConText) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;
		
		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		if ("qdkk".equals(type)) {
			fileIn = request.getRealPath("/docin") + "\\TTNB20.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB20_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			
			fileTemplate = "ttnb20";
			// Loc sua lai sau
			String idCuocTtkt = kiemkeForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);

			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appConText);
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
			String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
			StringBuffer sb = new StringBuffer(hinhThuc);
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", appConText.getTenCqt().toUpperCase());
				StringBuffer sbT = new StringBuffer("\u0110O\u00C0N ");
				sbT.append(hinhthuc_inT);
				sbT.append(" Q\u0110 S\u1ED0 ");
				sbT.append(cbQd.getSoQuyetDinh());
				word.put("[doan_ttkt_so]", sbT.toString());
				String ngaylap = kiemkeForm.getNgayRaQd();
				String[] arrngaylap = ngaylap.split("/");
				if (kiemkeForm.getNoiRaQd().equals("") && kiemkeForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", ".....");
					word.put("[ngay_lap]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				}else if (!kiemkeForm.getNoiRaQd().equals("") && !kiemkeForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", kiemkeForm.getNoiRaQd());
					word.put("[ngay_lap]", "ng\u00E0y " + arrngaylap[0] + " th\u00E1ng " + arrngaylap[1] + " n\u0103m " + arrngaylap[2]);
				}else if (kiemkeForm.getNoiRaQd().equals("") && !kiemkeForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", ".....");
					word.put("[ngay_lap]", "ng\u00E0y " + arrngaylap[0] + " th\u00E1ng " + arrngaylap[1] + " n\u0103m " + arrngaylap[2]);
				}else if (!kiemkeForm.getNoiRaQd().equals("") && kiemkeForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", kiemkeForm.getNoiRaQd());
					word.put("[ngay_lap]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				}
				word.put("[ttkt]", sb.toString().toUpperCase());
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				String ngayttkt = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				String[] arrngayttkt = ngayttkt.split("/");
				String ngay_ra_qd = "ng\u00E0y " + arrngayttkt[0] + " th\u00E1ng " + arrngayttkt[1] + " n\u0103m " + arrngayttkt[2];
				word.put("[ngay_ra_qd]",ngay_ra_qd.toUpperCase());
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText).toUpperCase());
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_ra_qd]",ngay_ra_qd);
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[tai_san]", kiemkeForm.getTaiSanCanKiemKe());
				word.put("[dv_quan_ly_tai_san]", kiemkeForm.getDonViDangBaoQuan());
				word.put("[dia_diem_noi_co_tai_san_kiem_ke]", kiemkeForm.getDiaDiemCoTsKk());
				word.put("[thoi_gian_kiem_ke]", Formater.getDateTimeForPrint(kiemkeForm.getThoiGianKk()));
				word.put("[dv_dc_kiem_ke]", kiemkeForm.getDonViCaNhanDuocKk());
				word.put("[dv_bao_quan]", kiemkeForm.getDonViCaNhanBaoQuan());
				word.put("[dv_quan_ly_tai_san]", kiemkeForm.getDonViDangBaoQuan());
				word.put("[dv_dc_kiem_ke]", kiemkeForm.getDonViCaNhanDuocKk());
				word.put("[dv_bao_quan]", kiemkeForm.getDonViCaNhanBaoQuan());
				if(Formater.isNull(kiemkeForm.getThuTruongDonViCoTSKK()))
					word.put("[thu_truong_dv_co_tai_san_kiem_ke]", "");
				else
					word.put("[thu_truong_dv_co_tai_san_kiem_ke]", ", "+kiemkeForm.getThuTruongDonViCoTSKK());
				if(Formater.isNull(kiemkeForm.getDonViCoLienQuan()))
					word.put("[dv_lien_quan]", "");
				else
					word.put("[dv_lien_quan]",", v\u00E0 "+ kiemkeForm.getDonViCoLienQuan());
				word.put("[ttkt]", sb.toString().toUpperCase());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());

				
				//
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB20", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}finally {				
				try { 
					word.saveAndClose();
				} catch (Exception e) {
					
				}
			}
			
			//
		} else if (type.equals("bbkk")) {
			fileIn = request.getRealPath("/docin") + "\\TTNB21.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB21_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			
			fileTemplate = "ttnb21"; // (ngon, chuan)
			// Loc sua lai sau
			String idCuocTtkt = kiemkeForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);
			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appConText);
			StringBuffer defaultPrint = new StringBuffer("\u00D4ng (B\u00E0)................             Ch\u1EE9c v\u1EE5:...............");
			defaultPrint.append("\n\u00D4ng (B\u00E0)................             Ch\u1EE9c v\u1EE5:...............");
			defaultPrint.append("\n......................................................................................");
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
			String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
			StringBuffer sb = new StringBuffer(hinhThuc);
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", appConText.getTenCqt().toUpperCase());
				StringBuffer sbT = new StringBuffer("\u0110O\u00C0N ");
				sbT.append(hinhthuc_inT);
				sbT.append(" Q\u0110 S\u1ED0 ");
				sbT.append(cbQd.getSoQuyetDinh());
				word.put("[doan_ttkt_so]", sbT.toString());
				// ngay kiem ke
				word.put("[ngay_kiem_ke]", Formater.getDateForPrint(kiemkeForm.getNgayRaQd()));
				word.put("[ttkt]", sb.toString());
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[thu_truong_qd]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[thoi_gian_lap_bien_ban]", Formater.getDateTimeForPrint(kiemkeForm.getThoiDiemLapBb()));
				if (Formater.isNull(kiemkeForm.getNoiRaQd())) {
					word.put("[dia_diem]", "..........");
				} else {
					word.put("[dia_diem]", kiemkeForm.getNoiRaQd());
				}
				word.put("[ttkt]", sb.toString());
				//dai dien doan ttkt
				//khoi tao table trong Msword
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrthanhphanbg = kiemkeForm.getDonViTtKt();
				StringBuffer tptd = new StringBuffer("");
				if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
					for (int i = 0; i < arrthanhphanbg.length; i++) {
						tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg[i].getHoTen()));
						tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg[i].getChucVu()));
						tptd.append("\n");
						word.addCellTable(table, i+1, 1, "- \u00D4ng (b\u00E0): " + arrthanhphanbg[i].getHoTen());
						word.addCellTable(table, i+1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbg[i].getChucVu());
						word.addRowTable(table,arrthanhphanbg.length);
					}
					System.out.println(tptd.toString());
					word.put("[thanh_vien]", tptd.toString().substring(0, tptd.toString().length() - 1));
				} 
				//else {
					word.put("[thanh_vien]", defaultPrint.toString());
				//}
				// dai dien dv co tai san dc kiem ke
				word.put("[dv_co_tai_san_kk]", kiemkeForm.getDonViDangBaoQuan());
				table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arrthanhphankk = kiemkeForm.getDonViCoTaiSanDuocKK();
				StringBuffer kk = new StringBuffer("");
				// if (arrthanhphanbg != null && arrthanhphanbg.length > 0) { //code cu
				if (arrthanhphankk != null && arrthanhphankk.length > 0) {
					for (int i = 0; i < arrthanhphankk.length; i++) {
						kk.append(KtnbUtil.layoutTableHoTen(arrthanhphankk[i].getHoTen()));
						kk.append(KtnbUtil.layoutTableChucVu(arrthanhphankk[i].getChucVu()));
						kk.append("\n");
						word.addCellTable(table, i+1, 1, "- \u00D4ng (b\u00E0): " + arrthanhphankk[i].getHoTen());
						word.addCellTable(table, i+1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphankk[i].getChucVu());
						word.addRowTable(table,arrthanhphankk.length);
					}
					System.out.println(kk.toString());
					word.put("[thanh_vien_dv]", kk.toString().substring(0, kk.toString().length() - 1));
				} 
				//else {
					word.put("[thanh_vien_dv]", defaultPrint.toString());
				//}
				word.put("[dv_co_tai_san_kiem_ke]", cuocTtkt.getTenDonViBi());
				word.put("[gom]", kiemkeForm.getSoluongChungloaiXs());
				//thoi diem kiem ke
				word.put("[thoi_diem_kiem_ke]", Formater.getDateTimeForPrint(kiemkeForm.getThoiDiemKk()));
				word.put("[time_tu]", Formater.getDateTimeForPrint(kiemkeForm.getThoiGianBatDau()));
				word.put("[time_den]", Formater.getDateTimeForPrint(kiemkeForm.getThoiGianKetThuc()));
				if (Formater.isNull(kiemkeForm.getDvDuocGiaoBQTS())) {
					word.put("[dv_bao_quan]", "...............");
				} else {
					word.put("[dv_bao_quan]", kiemkeForm.getDvDuocGiaoBQTS());
				}
				word.put("[ttkt]", sb.toString());
				word.put("[ttkt]", sb.toString().toUpperCase());
				// TODO: chua co truong dia diem lap bien ban tren form
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB21", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}
			
		}
	}
	
	//v4
	
	private void inKiemke(HttpServletRequest request, HttpServletResponse reponse, KiemKeForm kiemkeForm, ApplicationContext appConText) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;
		
		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		if ("qdkk".equals(type)) {
			fileIn = request.getRealPath("/docin/v4") + "\\TTNB20.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB20_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			
			fileTemplate = "ttnb20";
			// Loc sua lai sau
			String idCuocTtkt = kiemkeForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);

			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appConText);
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
			String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
			StringBuffer sb = new StringBuffer(hinhThuc);
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", appConText.getTenCqt().toUpperCase());
				StringBuffer sbT = new StringBuffer("\u0110O\u00C0N ");
				sbT.append(hinhthuc_inT);
				sbT.append(" Q\u0110 S\u1ED0 ");
				sbT.append(cbQd.getSoQuyetDinh());
				word.put("[doan_ttkt_so]", sbT.toString());
				String ngaylap = kiemkeForm.getNgayRaQd();
				String[] arrngaylap = ngaylap.split("/");
				if (kiemkeForm.getNoiRaQd().equals("") && kiemkeForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", ".....");
					word.put("[ngay_lap]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				}else if (!kiemkeForm.getNoiRaQd().equals("") && !kiemkeForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", kiemkeForm.getNoiRaQd());
					word.put("[ngay_lap]", "ng\u00E0y " + arrngaylap[0] + " th\u00E1ng " + arrngaylap[1] + " n\u0103m " + arrngaylap[2]);
				}else if (kiemkeForm.getNoiRaQd().equals("") && !kiemkeForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", ".....");
					word.put("[ngay_lap]", "ng\u00E0y " + arrngaylap[0] + " th\u00E1ng " + arrngaylap[1] + " n\u0103m " + arrngaylap[2]);
				}else if (!kiemkeForm.getNoiRaQd().equals("") && kiemkeForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", kiemkeForm.getNoiRaQd());
					word.put("[ngay_lap]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				}
				//word.put("[ttkt]", sb.toString().toUpperCase());
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				String ngayttkt = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				String[] arrngayttkt = ngayttkt.split("/");
				String ngay_ra_qd = "ng\u00E0y " + arrngayttkt[0] + " th\u00E1ng " + arrngayttkt[1] + " n\u0103m " + arrngayttkt[2];
				word.put("[ngay_ra_qd]",ngay_ra_qd.toUpperCase());
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText).toUpperCase());
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_ra_qd]",ngay_ra_qd);
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				//word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[tai_san]", kiemkeForm.getTaiSanCanKiemKe());
				word.put("[dv_quan_ly_tai_san]", kiemkeForm.getDonViDangBaoQuan());
				word.put("[dia_diem_noi_co_tai_san_kiem_ke]", kiemkeForm.getDiaDiemCoTsKk());
				word.put("[thoi_gian_kiem_ke]", Formater.getDateTimeForPrint(kiemkeForm.getThoiGianKk()));
				word.put("[dv_dc_kiem_ke]", kiemkeForm.getDonViCaNhanDuocKk());
				word.put("[dv_bao_quan]", kiemkeForm.getDonViCaNhanBaoQuan());
				word.put("[dv_quan_ly_tai_san]", kiemkeForm.getDonViDangBaoQuan());
				word.put("[dv_dc_kiem_ke]", kiemkeForm.getDonViCaNhanDuocKk());
				word.put("[dv_bao_quan]", kiemkeForm.getDonViCaNhanBaoQuan());
				if(Formater.isNull(kiemkeForm.getThuTruongDonViCoTSKK()))
					word.put("[thu_truong_dv_co_tai_san_kiem_ke]", "");
				else
					word.put("[thu_truong_dv_co_tai_san_kiem_ke]", ", "+kiemkeForm.getThuTruongDonViCoTSKK());
				if(Formater.isNull(kiemkeForm.getDonViCoLienQuan()))
					word.put("[dv_lien_quan]", "");
				else
					word.put("[dv_lien_quan]",", v\u00E0 "+ kiemkeForm.getDonViCoLienQuan());
				//word.put("[ttkt]", sb.toString().toUpperCase());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());

				
				//
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB20", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}finally {				
				try { 
					word.saveAndClose();
				} catch (Exception e) {
					
				}
			}
			
			//
		} else if (type.equals("bbkk")) {
			fileIn = request.getRealPath("/docin/v4") + "\\TTNB21.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB21_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			
			fileTemplate = "ttnb21"; // (ngon, chuan)
			// Loc sua lai sau
			String idCuocTtkt = kiemkeForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);
			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appConText);
			StringBuffer defaultPrint = new StringBuffer("\u00D4ng (B\u00E0)................             Ch\u1EE9c v\u1EE5:...............");
			defaultPrint.append("\n\u00D4ng (B\u00E0)................             Ch\u1EE9c v\u1EE5:...............");
			defaultPrint.append("\n......................................................................................");
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
			String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
			StringBuffer sb = new StringBuffer(hinhThuc);
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", appConText.getTenCqt().toUpperCase());
				StringBuffer sbT = new StringBuffer("\u0110O\u00C0N ");
				sbT.append(hinhthuc_inT);
				sbT.append(" Q\u0110 S\u1ED0 ");
				sbT.append(cbQd.getSoQuyetDinh());
				word.put("[doan_ttkt_so]", sbT.toString());
				// ngay kiem ke
				word.put("[ngay_kiem_ke]", Formater.getDateForPrint(kiemkeForm.getNgayRaQd()));
				//word.put("[ttkt]", sb.toString());
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[thu_truong_qd]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				//word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[thoi_gian_lap_bien_ban]", Formater.getDateTimeForPrint(kiemkeForm.getThoiDiemLapBb()));
				if (Formater.isNull(kiemkeForm.getNoiRaQd())) {
					word.put("[dia_diem]", "..........");
				} else {
					word.put("[dia_diem]", kiemkeForm.getNoiRaQd());
				}
				//word.put("[ttkt]", sb.toString());
				//dai dien doan ttkt
				//khoi tao table trong Msword
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrthanhphanbg = kiemkeForm.getDonViTtKt();
				StringBuffer tptd = new StringBuffer("");
				if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
					for (int i = 0; i < arrthanhphanbg.length; i++) {
						tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg[i].getHoTen()));
						tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg[i].getChucVu()));
						tptd.append("\n");
						word.addCellTable(table, i+1, 1, "- \u00D4ng (b\u00E0): " + arrthanhphanbg[i].getHoTen());
						word.addCellTable(table, i+1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbg[i].getChucVu());
						word.addRowTable(table,arrthanhphanbg.length);
					}
					System.out.println(tptd.toString());
					//word.put("[thanh_vien]", tptd.toString().substring(0, tptd.toString().length() - 1));
				} 
				//else {
				//	word.put("[thanh_vien]", defaultPrint.toString());
				//}
				// dai dien dv co tai san dc kiem ke
				//word.put("[dv_co_tai_san_kk]", kiemkeForm.getDonViDangBaoQuan());
				table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arrthanhphankk = kiemkeForm.getDonViCoTaiSanDuocKK();
				StringBuffer kk = new StringBuffer("");
				// if (arrthanhphanbg != null && arrthanhphanbg.length > 0) { //code cu
				if (arrthanhphankk != null && arrthanhphankk.length > 0) {
					for (int i = 0; i < arrthanhphankk.length; i++) {
						kk.append(KtnbUtil.layoutTableHoTen(arrthanhphankk[i].getHoTen()));
						kk.append(KtnbUtil.layoutTableChucVu(arrthanhphankk[i].getChucVu()));
						kk.append("\n");
						word.addCellTable(table, i+1, 1, "- \u00D4ng (b\u00E0): " + arrthanhphankk[i].getHoTen());
						word.addCellTable(table, i+1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphankk[i].getChucVu());
						word.addRowTable(table,arrthanhphankk.length);
					}
					System.out.println(kk.toString());
					//word.put("[thanh_vien_dv]", kk.toString().substring(0, kk.toString().length() - 1));
				} 
				//else {
					//word.put("[thanh_vien_dv]", defaultPrint.toString());
				//}
				word.put("[dv_co_tai_san_kiem_ke]", cuocTtkt.getTenDonViBi());
				word.put("[gom]", kiemkeForm.getSoluongChungloaiXs());
				//thoi diem kiem ke
				word.put("[thoi_diem_kiem_ke]", Formater.getDateTimeForPrint(kiemkeForm.getThoiDiemKk()));
				word.put("[time_tu]", Formater.getDateTimeForPrint(kiemkeForm.getThoiGianBatDau()));
				word.put("[time_den]", Formater.getDateTimeForPrint(kiemkeForm.getThoiGianKetThuc()));
				if (Formater.isNull(kiemkeForm.getDvDuocGiaoBQTS())) {
					word.put("[dv_bao_quan]", "...............");
				} else {
					word.put("[dv_bao_quan]", kiemkeForm.getDvDuocGiaoBQTS());
				}
				//word.put("[ttkt]", sb.toString());
				//word.put("[ttkt]", sb.toString().toUpperCase());
				// TODO: chua co truong dia diem lap bien ban tren form
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB21", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}
			
		}
	}

	private void loadDsTvDoan(String cuocTtktId, HttpServletRequest request) {
		Collection dsThanhVienDoan = TtktService.getDanhSachThanhVienDoan(cuocTtktId);
		String cbDsThanhVienDoan = "<option value = \"\">"; // Combo danh sach
		// thanh vien doan
		cbDsThanhVienDoan += "</option>";
		String dsIdThanhVienDoan = "";
		String dsChucVuTrongDoan = "";
		Iterator iter = dsThanhVienDoan.iterator();
		while (iter.hasNext()) {
			TtktCbChiTietDsTvDoan thanhVienDoan = (TtktCbChiTietDsTvDoan) iter.next();
			cbDsThanhVienDoan += "<option value = " + thanhVienDoan.getIdCanBo() + ">";
			cbDsThanhVienDoan += thanhVienDoan.getTenCanBo();
			cbDsThanhVienDoan += "</option>";
			dsIdThanhVienDoan += thanhVienDoan.getIdCanBo() + ",";
			dsChucVuTrongDoan += thanhVienDoan.getChucVuTrongDoan() + ",";
		}
		request.setAttribute("chiTietDsTvd", dsThanhVienDoan);
		request.setAttribute("dsThanhVienDoan", dsThanhVienDoan);
		request.setAttribute("cbChiTietDsTvd", cbDsThanhVienDoan);
		request.setAttribute("dsIdThanhVienDoan", dsIdThanhVienDoan.substring(0, dsIdThanhVienDoan.length() - 1));
		request.setAttribute("dsChucVuTrongDoan", dsChucVuTrongDoan.substring(0, dsChucVuTrongDoan.length() - 1));

	}

	private void loadDefault(KiemKeForm form, ApplicationContext app, String id, String idCuocTtKt) throws Exception {
		TtktThQdKiemKe qdkk = TtktCnPhuService.getKiemKeTaiSan(app, id);
		if (qdkk != null) {
			TtktThBienBanKiemKe bbkk = qdkk.getBbKK();
			form.setIdBBKK(bbkk.getId());
			form.setIdCuocTtkt(qdkk.getIdCuocTtkt());
			form.setIdDaiDienDoanTTKT(bbkk.getIdDaiDienDoanTtkt());
			form.setIdDaiDienDVCOTSTKK(bbkk.getIdDaiDienDviCnhanCoTskk());
			form.setIdQdKk(bbkk.getIdQdKk());
			form.setThoiGianBatDau(Formater.date2strDateTimeForNV(bbkk.getThoiGianBatDau()));
			form.setThoiGianKetThuc(Formater.date2strDateTimeForNV(bbkk.getThoiGianKetThuc()));
			form.setSoluongChungloaiXs(bbkk.getSoluongChungloaiXs());
			form.setThoiDiemLapBb(Formater.date2strDateTimeForNV(bbkk.getThoiDiemLapBb()));
			form.setThoiDiemKk(Formater.date2strDateTimeForNV(bbkk.getThoiDiemKk()));
			form.setThoiGianKk(Formater.date2strDateTimeForNV(qdkk.getThoiGianKk()));
			form.setDvDuocGiaoBQTS(bbkk.getDviCnhanDuocGiaoBaoQuan());
			// Quyet dinh kiem ke
			form.setThoiDiemKk(Formater.date2strDateTimeForNV(qdkk.getThoiGianKk()));
			form.setTaiSanCanKiemKe(qdkk.getTaiSanDuocKiemKe());
			form.setDonViCaNhanBaoQuan(qdkk.getDonViDangBaoQuan());
			form.setDiaDiemCoTsKk(qdkk.getDiaDiemCoTsKk());
			form.setNoiRaQd(qdkk.getNoiRaQd());
			form.setNgayRaQd(Formater.date2str(qdkk.getNgayRaQd()));
			form.setThuTruongDonViCoTSKK(qdkk.getThuTruongDvCoTskk());
			form.setDonViCoLienQuan(qdkk.getCquanTchucCnhanCoLquan());
			form.setDonViDangBaoQuan(qdkk.getDonViDangBaoQuan());
			form.setDonViCaNhanDuocKk(qdkk.getDviCnhanDuocKk());

			Collection dsTpTd = bbkk.getDsDoanTtkt();
			if (dsTpTd != null) {
				TtktCmThanhPhanThamDu[] dsTpTdLoad1 = new TtktCmThanhPhanThamDu[dsTpTd.size()];
				Iterator iter = dsTpTd.iterator();
				int i = 0;
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
					dsTpTdLoad1[i] = tptd;
					i++;

				}
				form.setDonViTtKt(dsTpTdLoad1);
			}

			Collection dsDVCoTsKk = bbkk.getDsDonViCoTsKk();
			if (dsDVCoTsKk != null) {
				TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[dsDVCoTsKk.size()];
				Iterator iter = dsDVCoTsKk.iterator();
				int i = 0;
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
					dsTpTdLoad[i] = tptd;
					i++;
				}
				form.setDonViCoTaiSanDuocKK(dsTpTdLoad);

			}
		} else {
			form.setThoiDiemLapBb(Formater.date2strDateTimeForNV(new Date()));
			form.setThoiDiemKk(Formater.date2strDateTimeForNV(new Date()));
			form.setThoiGianBatDau(Formater.date2strDateTimeForNV(new Date()));
			form.setThoiGianKetThuc(Formater.date2strDateTimeForNV(new Date()));
			form.setNgayRaQd(Formater.date2str(new Date()));
			form.setThoiGianKk(Formater.date2strDateTimeForNV(new Date()));
			form.setIdCuocTtkt(idCuocTtKt);
		}
	}

	private void saveQDKK(HttpServletResponse response,HttpServletRequest request,KiemKeForm form, ApplicationContext app) throws Exception {
		if ("qdkk".equals(request.getParameter("type"))) {
			TtktThQdKiemKe qdkk = createQuyetdinhKK(app, form);
			PrintWriter writer = response.getWriter();
			writer.print("returnId:"+TtktCnPhuService.saveQDKK(app, qdkk));
			writer.flush();
			writer.close();
		} else if ("bbkk".equals(request.getParameter("type"))) {
			//TtktThQdKiemKe qdkk = TtktCnPhuService.getQdKiemKe(app, form.getIdQdKk());
			TtktThQdKiemKe qdkk = TtktCnPhuService.getKiemKeTaiSan(app, form.getIdQdKk());
			PrintWriter writer = response.getWriter();
			if (Formater.isNull(qdkk.getId())) {
				writer.print("loi");
				writer.flush();
				writer.close();
			} else {
				TtktThBienBanKiemKe bbkk = createBienbanKK(app, form);
				TtktCnPhuService.saveBBKK(app, bbkk);
				writer.print("cucsess");
				writer.flush();
				writer.close();
			}
		} 
	}
	
	private TtktThQdKiemKe createQuyetdinhKK(ApplicationContext appContext, KiemKeForm form) throws Exception{
		TtktThQdKiemKe qdkk = new TtktThQdKiemKe();
		qdkk.setId(form.getIdQdKk());
		qdkk.setIdCuocTtkt(form.getIdCuocTtkt());
		qdkk.setDiaDiemCoTsKk(form.getDiaDiemCoTsKk());
		qdkk.setNoiRaQd(form.getNoiRaQd());
		qdkk.setThoiGianKk(Formater.str2dateForNV(form.getThoiGianKk()));
		qdkk.setTaiSanDuocKiemKe(form.getTaiSanCanKiemKe());
		qdkk.setDviCnhanDuocGiaoBaoQuan(form.getDonViCaNhanBaoQuan());
		qdkk.setDonViDangBaoQuan(form.getDonViCaNhanBaoQuan());
		qdkk.setDiaDiemCoTsKk(form.getDiaDiemCoTsKk());
		qdkk.setDviCnhanDuocKk(form.getDonViCaNhanDuocKk());
		qdkk.setDonViDangBaoQuan(form.getDonViDangBaoQuan());
		qdkk.setThuTruongDvCoTskk(form.getThuTruongDonViCoTSKK());
		qdkk.setCquanTchucCnhanCoLquan(form.getDonViCoLienQuan());
		qdkk.setNgayRaQd(Formater.str2date(form.getNgayRaQd()));
		qdkk.setIdNguoiCapNat(appContext.getMaCanbo());
		qdkk.setTenNguoiCapNhat(appContext.getTenCanbo());
		qdkk.setNgayCapNhat(new Date());
		
		return qdkk;
	}
	
	private TtktThBienBanKiemKe createBienbanKK(ApplicationContext appContext, KiemKeForm form) throws Exception{
		TtktThBienBanKiemKe bbkk = new TtktThBienBanKiemKe();
		//Insert Bien ban kiem ke

		bbkk.setId(form.getIdBBKK());
		bbkk.setIdQdKk(form.getIdQdKk());
		bbkk.setIdDsTvd(form.getIdDsTvd());
		bbkk.setThoiDiemLapBb(Formater.str2dateForNV(form.getThoiDiemLapBb()));
		bbkk.setThoiDiemKk(Formater.str2dateForNV(form.getThoiDiemKk()));
		bbkk.setThoiGianBatDau(Formater.str2dateForNV(form.getThoiGianBatDau()));
		bbkk.setThoiGianKetThuc(Formater.str2dateForNV(form.getThoiGianKetThuc()));
		bbkk.setDviCnhanDuocGiaoBaoQuan(form.getDvDuocGiaoBQTS());
		bbkk.setSoluongChungloaiXs(form.getSoluongChungloaiXs());
		bbkk.setIdNguoiCapNat(appContext.getMaCanbo());
		bbkk.setTenNguoiCapNhat(appContext.getTenCanbo());
		bbkk.setNgayCapNhat(new Date());

		// Thanh phan tham du doan Ttkt
		String thanhPhanThamDuDoanTtktId = KeyManagement.getGUID();
		bbkk.setIdDaiDienDoanTtkt(thanhPhanThamDuDoanTtktId);
		Collection lstDaiDienDoanTtkt = new ArrayList();

		if (form.getDonViTtKt() != null) {
			for (int i = 0; i < form.getDonViTtKt().length; i++) {
				TtktCmThanhPhanThamDu tptd = new TtktCmThanhPhanThamDu();
				tptd.setId(KeyManagement.getGUID());
				tptd.setChucVu(form.getDonViTtKt()[i].getChucVu());
				tptd.setHoTen(form.getDonViTtKt()[i].getHoTen());
				tptd.setIdMaster(thanhPhanThamDuDoanTtktId);
				tptd.setIdCanBo(form.getDonViTtKt()[i].getIdCanBo());
				tptd.setIdNguoiCapNat(appContext.getMaCanbo());
				tptd.setTenNguoiCapNhat(appContext.getTenCanbo());
				tptd.setNgayCapNhat(new Date());
				lstDaiDienDoanTtkt.add(tptd);
			}
			bbkk.setDsDoanTtkt(lstDaiDienDoanTtkt);
		}

		// Thanh phan tham du don vi co ts
		String thanhPhanThamDuCoTS = KeyManagement.getGUID();
		bbkk.setIdDaiDienDviCnhanCoTskk(thanhPhanThamDuCoTS);
		Collection lstDaiDienDoanCqCoTs = new ArrayList();
		for (int i = 0; i < form.getDonViCoTaiSanDuocKK().length; i++) {
			TtktCmThanhPhanThamDu cacOb = new TtktCmThanhPhanThamDu();
			cacOb.setChucVu(form.getDonViCoTaiSanDuocKK()[i].getChucVu());
			cacOb.setHoTen(form.getDonViCoTaiSanDuocKK()[i].getHoTen());
			cacOb.setIdMaster(thanhPhanThamDuCoTS);
			cacOb.setIdCanBo(form.getDonViCoTaiSanDuocKK()[i].getIdCanBo());
			lstDaiDienDoanCqCoTs.add(cacOb);
		}
		bbkk.setDsDonViCoTsKk(lstDaiDienDoanCqCoTs);
		
		return bbkk;
	}
	
	private void saveQDKK_old(KiemKeForm form, ApplicationContext app) throws Exception {
		
		
		TtktThQdKiemKe qdkk = new TtktThQdKiemKe();
		TtktThBienBanKiemKe bbkk = new TtktThBienBanKiemKe();

		qdkk.setId(form.getIdQdKk());
		qdkk.setIdCuocTtkt(form.getIdCuocTtkt());
		qdkk.setDiaDiemCoTsKk(form.getDiaDiemCoTsKk());
		qdkk.setNoiRaQd(form.getNoiRaQd());
		qdkk.setThoiGianKk(Formater.str2dateForNV(form.getThoiGianKk()));
		qdkk.setTaiSanDuocKiemKe(form.getTaiSanCanKiemKe());
		qdkk.setDviCnhanDuocGiaoBaoQuan(form.getDonViCaNhanBaoQuan());
		qdkk.setDonViDangBaoQuan(form.getDonViCaNhanBaoQuan());
		qdkk.setDiaDiemCoTsKk(form.getDiaDiemCoTsKk());
		qdkk.setDviCnhanDuocKk(form.getDonViCaNhanDuocKk());
		qdkk.setDonViDangBaoQuan(form.getDonViDangBaoQuan());
		qdkk.setThuTruongDvCoTskk(form.getThuTruongDonViCoTSKK());
		qdkk.setCquanTchucCnhanCoLquan(form.getDonViCoLienQuan());
		qdkk.setNgayRaQd(Formater.str2date(form.getNgayRaQd()));
		// Insert Bien ban kiem ke

		bbkk.setId(form.getIdBBKK());
		bbkk.setIdQdKk(form.getIdQdKk());
		bbkk.setIdDsTvd(form.getIdDsTvd());
		bbkk.setThoiDiemLapBb(Formater.str2dateForNV(form.getThoiDiemLapBb()));
		bbkk.setThoiDiemKk(Formater.str2dateForNV(form.getThoiDiemKk()));
		bbkk.setThoiGianBatDau(Formater.str2dateForNV(form.getThoiGianBatDau()));
		bbkk.setThoiGianKetThuc(Formater.str2dateForNV(form.getThoiGianKetThuc()));
		bbkk.setDviCnhanDuocGiaoBaoQuan(form.getDvDuocGiaoBQTS());
		bbkk.setSoluongChungloaiXs(form.getSoluongChungloaiXs());

		// Thanh phan tham du doan Ttkt
		String thanhPhanThamDuDoanTtktId = KeyManagement.getGUID();
		bbkk.setIdDaiDienDoanTtkt(thanhPhanThamDuDoanTtktId);
		Collection lstDaiDienDoanTtkt = new ArrayList();

		if (form.getDonViTtKt() != null) {
			for (int i = 0; i < form.getDonViTtKt().length; i++) {
				TtktCmThanhPhanThamDu tptd = new TtktCmThanhPhanThamDu();
				tptd.setId(KeyManagement.getGUID());
				tptd.setChucVu(form.getDonViTtKt()[i].getChucVu());
				tptd.setHoTen(form.getDonViTtKt()[i].getHoTen());
				tptd.setIdMaster(thanhPhanThamDuDoanTtktId);
				tptd.setIdCanBo(form.getDonViTtKt()[i].getIdCanBo());
				tptd.setIdNguoiCapNat(app.getMaCanbo());
				tptd.setTenNguoiCapNhat(app.getTenCanbo());
				tptd.setNgayCapNhat(new Date());
				
				lstDaiDienDoanTtkt.add(tptd);
			}
			bbkk.setDsDoanTtkt(lstDaiDienDoanTtkt);
		}

		// Thanh phan tham du don vi co ts
		String thanhPhanThamDuCoTS = KeyManagement.getGUID();
		bbkk.setIdDaiDienDviCnhanCoTskk(thanhPhanThamDuCoTS);
		Collection lstDaiDienDoanCqCoTs = new ArrayList();
		for (int i = 0; i < form.getDonViCoTaiSanDuocKK().length; i++) {
			TtktCmThanhPhanThamDu cacOb = new TtktCmThanhPhanThamDu();
			cacOb.setChucVu(form.getDonViCoTaiSanDuocKK()[i].getChucVu());
			cacOb.setHoTen(form.getDonViCoTaiSanDuocKK()[i].getHoTen());
			cacOb.setIdMaster(thanhPhanThamDuCoTS);
			cacOb.setIdCanBo(form.getDonViCoTaiSanDuocKK()[i].getIdCanBo());
			lstDaiDienDoanCqCoTs.add(cacOb);
		}
		bbkk.setDsDonViCoTsKk(lstDaiDienDoanCqCoTs);

		qdkk.setBbKK(bbkk);
		TtktCnPhuService.saveQDKK(app, qdkk);
	}

}
