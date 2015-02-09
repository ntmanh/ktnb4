package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.action;

import java.io.InputStream;
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

import com.jacob.com.Dispatch;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktKtChuyenGiaoHsVv;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.form.HuyThanhTraKiemTraForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.BanGiaoHsVvForm;

/**
 * @version 1.0
 * @author
 */
public class BanGiaoHsVvAction extends BaseDispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		ApplicationContext app = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BanGiaoHsVvForm banGiaoHsForm = (BanGiaoHsVvForm) form;
		String method = request.getParameter("method");
		if ("save".equals(method)) {
			saveYeuCau(banGiaoHsForm, app);
			request.setAttribute("saveStatus", "true");
		} else if ("in".equals(method)) {
			// TODO: Kiem tra xem cho nay co phai load lai lan nua khong
			inBanGiaoHsVv(request, banGiaoHsForm, response, app);
			return null;
		} else {
			String cuocTtktId = request.getParameter("idCuocTtkt");
			if (!Formater.isNull(cuocTtktId)) {
				// Nguoi dung click chon vao link tai form main hoac mo man hinh
				// tao moi tu form tim kiem
				if ("addnew".equals(method)) { // Tao moi tu man hinh tim kiem
					addNew(request, app, banGiaoHsForm, cuocTtktId);

				} else { // Click vao link tai form main
					Collection dsBanGiaoHsVv = TtktCnPhuService.getDsHSVuViec(app, cuocTtktId);
					if (Formater.isNull(dsBanGiaoHsVv)) { // Truong doan
						// them moi
						addNew(request, app, banGiaoHsForm, cuocTtktId);
					} else {
						if (!app.isTruongDoan(cuocTtktId) && dsBanGiaoHsVv.size() == 1) {
							// Thu truong co quan va co 1 ban ghi
							loadDataToForm(request, app, banGiaoHsForm, (TtktKtChuyenGiaoHsVv) ((ArrayList) dsBanGiaoHsVv).get(0));
							request.setAttribute("readOnly", "true");
							return mapping.findForward("success");

						}
						request.getSession().setAttribute("dsBGHoSoVuViec", dsBanGiaoHsVv);
						response.sendRedirect("danh_sach_tim_kiem.do?idCuocTtkt=" + cuocTtktId + "&type=bgHsVv");
					}
				}

			} else {
				// Truong hop xem hoac sua thi truyen id vao url
				String id = request.getParameter("id");
				loadDataToForm(request, app, banGiaoHsForm, id);
				if (!KtnbUtil.haveRoleNv(app) || "view".equals(method) || app.getTrangThaiCuocTtkt(banGiaoHsForm.getIdCuocTtKt()).equals(Constants.TT_TTKT_KT)) {
					request.setAttribute("readOnly", "true");
				}

			}
		}

		return mapping.findForward("success");

	}

	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, BanGiaoHsVvForm banGiaoHsForm, String id) throws Exception {
		TtktKtChuyenGiaoHsVv hoSoVv = TtktCnPhuService.getHoSoVv(app, id);
		loadDataToForm(request, app, banGiaoHsForm, hoSoVv);

	}

	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, BanGiaoHsVvForm form, TtktKtChuyenGiaoHsVv hoSoVv) {
		form.setId(hoSoVv.getId());

		form.setIdCuocTtKt(hoSoVv.getIdCuocTtkt());
		form.setThoiGian(Formater.date2strDateTimeForNV(hoSoVv.getThoiGian()));
		form.setDiaDiemNopHs(hoSoVv.getDiaDiemLapHs());
		form.setSoHs(hoSoVv.getSoHs());
		form.setHanhViVp(hoSoVv.getHanhViViPham());
		form.setTenCqDieuTra(hoSoVv.getTenCqDieuTra());
		form.setTomTatHvVp(hoSoVv.getTomTatHanhViViPham());
		form.setChucDanhNguoiKy(hoSoVv.getChucDanhNguoiKy());
		form.setTgGiaoNhan(Formater.date2strDateTimeForNV(hoSoVv.getThoiGianGiaoNhan()));
		form.setDiaDiemGiaoNhan(hoSoVv.getDiaDiem());
		form.setSoTrang(hoSoVv.getSoTrang().toString());
		form.setThoiDiemKt(Formater.date2strDateTimeForNV(hoSoVv.getThoiDiemKetThuc()));
		form.setBaoGomCacTl(hoSoVv.getBaoGomCacTl());
		form.setIdDsDaiDien(hoSoVv.getTpThamDuDoanTtkt());
		form.setIdDsDaiDienCqDt(hoSoVv.getTpThamDuCqDieuTra());

		// -------------- load danh sach dai dien -----------------------

		Collection dsDaidien = (Collection) hoSoVv.getDsDaiDien();
		if (dsDaidien != null) {
			TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[dsDaidien.size()];
			Iterator iter = dsDaidien.iterator();
			int i = 0;
			while (iter.hasNext()) {
				TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
				dsTpTdLoad[i] = tptd;
				i++;
			}
			form.setDsDaiDien(dsTpTdLoad);
		}

		// --------------- load danh sach dai dien co quan dieu tra
		// -------------
		Collection dsDaidienCqDt = (Collection) hoSoVv.getDsDaiDienCqDt();
		if (dsDaidienCqDt != null) {
			TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[dsDaidienCqDt.size()];
			Iterator iter = dsDaidienCqDt.iterator();
			int i = 0;
			while (iter.hasNext()) {
				TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
				dsTpTdLoad[i] = tptd;
				i++;
			}
			form.setDsDaiDienCqDt(dsTpTdLoad);
		}

	}

	private void addNew(HttpServletRequest request, ApplicationContext app, BanGiaoHsVvForm banGiaoHsForm, String cuocTtktId) throws Exception {
		banGiaoHsForm.setIdCuocTtKt(cuocTtktId);

	}

	/**
	 * @param request
	 * @param banGiaoHsForm
	 * @param response
	 */
	private void inBanGiaoHsVv_old(HttpServletRequest request, BanGiaoHsVvForm form, HttpServletResponse response, ApplicationContext app) throws Exception {
		String idCuocTtKt = form.getIdCuocTtKt();
		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktTrongQdWithoutNoiDung(app, idCuocTtKt);
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtKt, app);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
		StringBuffer sb = new StringBuffer(hinhThuc);
		parameters.put("ttkt", sb.toString());
		sb = new StringBuffer("\u0110O\u00C0N ");
		sb.append(hinhthuc_in);
		sb.append(" Q\u0110 S\u1ED0 ");
		sb.append(cbQd.getSoQuyetDinh());
		if (type.equals("bbChuyenGiao")) {
			fileTemplate = "ttnb40";
			parameters.put("ten_cqt", app.getTenCqt());
			parameters.put("doan_ttkt_so", sb.toString());
			parameters.put("ttkt", hinhThuc);
			parameters.put("cqt_ra_van_ban", cuocTtkt.getTenDonViTh());
			parameters.put("so_qdinh", cbQd.getSoQuyetDinh());
			parameters.put("so_qd", cbQd.getSoQuyetDinh());
			parameters.put("dv_dc_ttkt", cuocTtkt.getTenDonViBi());
			parameters.put("tom_tat_hanh_vi_vi_pham", form.getTomTatHvVp());
			parameters.put("hanh_vi_co_dau_hieu_toi_pham", form.getHanhViVp());
			parameters.put("thu_truong_ban_hanhqd", KtnbUtil.getTenThuTruongCqt(app));
			parameters.put("ngay_qd", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			parameters.put("ten_co_quan_dieu_tra_co_tham_quyen", form.getTenCqDieuTra());
			if (form.getDiaDiemNopHs().equals("") || form.getThoiGian().equals("")) {
				parameters.put("noi_lap", ".....");
				parameters.put("ngay_lap", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			} else {
				parameters.put("noi_lap", form.getDiaDiemNopHs());
				parameters.put("ngay_lap", KtnbUtil.getDay(form.getThoiGian()));
			}

			parameters.put("chuc_danh_thu_truong", KtnbUtil.getTenThuTruongCqt(app));
		} else { // Bien ban giao nhan
			fileTemplate = "ttnb41";
			parameters.put("ten_cqt", app.getTenCqt());
			parameters.put("ten_dv_giao_hs", cuocTtkt.getTenDonViTh());
			parameters.put("ngay_lap", Formater.getDateForPrint(form.getTgGiaoNhan()));
			parameters.put("dia_diem_giao_nhan", form.getDiaDiemGiaoNhan());
			parameters.put("co_quan_giao_hs", cuocTtkt.getTenDonViTh());
			parameters.put("so_trang", form.getSoTrang());
			parameters.put("tai_lieu", form.getBaoGomCacTl());
			parameters.put("thoi_diem_kt", KtnbUtil.getHour(form.getThoiDiemKt()));

			// dai dien ben giao
			TtktCmThanhPhanThamDu[] arrthanhphanbg = form.getDsDaiDien();
			StringBuffer tptd = new StringBuffer("");
			if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
				for (int i = 0; i < arrthanhphanbg.length; i++) {
					tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg[i].getHoTen()));
					tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg[i].getChucVu()));
					tptd.append("\n           ");
				}
				System.out.println(tptd.toString());
				parameters.put("dai_dien_ben_giao", tptd.toString());
			}

			// dai dien ben nhan
			TtktCmThanhPhanThamDu[] arrthanhphanbg1 = form.getDsDaiDienCqDt();
			tptd = new StringBuffer("");
			if (arrthanhphanbg1 != null && arrthanhphanbg1.length > 0) {
				for (int i = 0; i < arrthanhphanbg1.length; i++) {
					tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg1[i].getHoTen()));
					tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg1[i].getChucVu()));
					tptd.append("\n           ");
				}
				System.out.println(tptd.toString());
				parameters.put("dai_dien_ben_nhan", tptd.toString());
			}
		}
		if (Formater.isNull(fileTemplate))
			throw new Exception("Chua chon file template");

		InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
		KtnbUtil.printf(reportRows, fileTemplate, response, inputStream, parameters, null);

	}

	/**
	 * Download file mau TTNB40,TTNB41
	 * 
	 * @throws Exception
	 */

	private void inBanGiaoHsVv(HttpServletRequest request, BanGiaoHsVvForm form, HttpServletResponse response, ApplicationContext app) throws Exception {
		CuocTtktService service = new CuocTtktService();
		String cuocTtktId = form.getIdCuocTtKt();
		System.out.println("Id cuoc ttkt : " + cuocTtktId);

		if (!Formater.isNull(cuocTtktId)) {
			if ("4".equals(service.getDonVerionTtkt(app, cuocTtktId))) {
				System.out.println(">>>>>>>>>>>>>>>>>>>v4");
				inBanGiaoHsVvv4(request, form, response, app);
			} else
				inBanGiaoHsVvv3(request, form, response, app);
		} else {
			if ("4".equals(Constants.APP_DEP_VERSION))
				inBanGiaoHsVvv4(request, form, response, app);
			else
				inBanGiaoHsVvv3(request, form, response, app);
		}
	}

	// v3
	private void inBanGiaoHsVvv3(HttpServletRequest request, BanGiaoHsVvForm form, HttpServletResponse response, ApplicationContext app) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;

		String idCuocTtKt = form.getIdCuocTtKt();
		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktTrongQdWithoutNoiDung(app, idCuocTtKt);
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtKt, app);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
		StringBuffer sb = new StringBuffer(hinhThuc);
		sb = new StringBuffer("\u0110O\u00C0N ");
		sb.append(hinhthuc_in);
		sb.append(" Q\u0110 S\u1ED0 ");
		sb.append(cbQd.getSoQuyetDinh());
		if (type.equals("bbChuyenGiao")) {
			fileIn = request.getRealPath("/docin") + "\\TTNB40.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB40_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			fileTemplate = "ttnb40";
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", app.getTenCqt().toUpperCase());
				// word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
				word.put("[cqt_ra_van_ban]", cuocTtkt.getTenDonViTh().toUpperCase());
				if (Formater.isNull(form.getSoHs()))
					word.put("[so_qdinh]", "....../CHS-.........");
				else
					word.put("[so_qdinh]", cbQd.getSoQuyetDinh());
				if (form.getDiaDiemNopHs().equals("") || form.getThoiGian().equals("")) {
					word.put("[noi_lap]", ".....");
					word.put("[ngay_lap]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else {
					word.put("[noi_lap]", form.getDiaDiemNopHs());
					word.put("[ngay_lap]", KtnbUtil.getDay(form.getThoiGian()));
				}
				word.put("[ten_co_quan_dieu_tra_co_tham_quyen]", form.getTenCqDieuTra());

				word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong_ban_hanhqd]", KtnbUtil.getTenThuTruongCqt(app));
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[tom_tat_hanh_vi_vi_pham]", form.getTomTatHvVp());
				word.put("[cqt_ra_van_ban]", cuocTtkt.getTenDonViTh());
				if (Formater.isNull(form.getHanhViVp()))
					word.put("[hanh_vi_co_dau_hieu_toi_pham]", ".......");
				else
					word.put("[hanh_vi_co_dau_hieu_toi_pham]", form.getHanhViVp());
				word.put("[ten_co_quan_dieu_tra_co_tham_quyen]", form.getTenCqDieuTra());
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(app.getMaCqt()).toUpperCase());
				// word.put("[ten_thu_truong]", app.getTenThuTruong());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB40", ".doc", response);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {
				try {
					word.saveAndClose();
				} catch (Exception e) {

				}
			}
		} else if (type.equals("bbGiaoNhan")) { // Bien ban giao nhan
			fileIn = request.getRealPath("/docin") + "\\TTNB41.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB41_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			fileTemplate = "ttnb41";
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", app.getTenCqt().toUpperCase());
				word.put("[ten_dv_giao_hs]", cuocTtkt.getTenDonViTh().toUpperCase());
				// word.put("[ngay_lap]",Formater.getDateForPrint(form.getTgGiaoNhan()));
				word.put("[ngay_lap]", KtnbUtil.getHour(form.getTgGiaoNhan()));
				word.put("[dia_diem_giao_nhan]", form.getDiaDiemGiaoNhan());
				word.put("[co_quan_giao_hs]", cuocTtkt.getTenDonViTh());
				// dai dien ben giao
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrthanhphanbg = form.getDsDaiDien();
				StringBuffer tptd = new StringBuffer("");
				if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
					for (int i = 0; i < arrthanhphanbg.length; i++) {
						tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg[i].getHoTen()));
						tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg[i].getChucVu()));
						tptd.append("\n           ");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrthanhphanbg[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbg[i].getChucVu());
						word.addRowTable(table, arrthanhphanbg.length);
					}
					System.out.println(tptd.toString());
					// word.put("dai_dien_ben_giao", tptd.toString());
				}

				// dai dien ben nhan
				table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arrthanhphanbg1 = form.getDsDaiDienCqDt();
				tptd = new StringBuffer("");
				if (arrthanhphanbg1 != null && arrthanhphanbg1.length > 0) {
					for (int i = 0; i < arrthanhphanbg1.length; i++) {
						tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg1[i].getHoTen()));
						tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg1[i].getChucVu()));
						tptd.append("\n           ");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrthanhphanbg1[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbg1[i].getChucVu());
						word.addRowTable(table, arrthanhphanbg1.length);
					}
					System.out.println(tptd.toString());
					// word.put("dai_dien_ben_nhan", tptd.toString());
				}
				word.put("[so_trang]", form.getSoTrang());
				if (Formater.isNull(form.getBaoGomCacTl()))
					word.put("[tai_lieu]", KtnbUtil.inFieldNull(115));
				else
					word.put("[tai_lieu]", form.getBaoGomCacTl());
				word.put("[thoi_diem_kt]", KtnbUtil.getHour(form.getThoiDiemKt()));
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB41", ".doc", response);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}
		}
	}

	// v4
	private void inBanGiaoHsVvv4(HttpServletRequest request, BanGiaoHsVvForm form, HttpServletResponse response, ApplicationContext app) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;

		String idCuocTtKt = form.getIdCuocTtKt();
		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktTrongQdWithoutNoiDung(app, idCuocTtKt);
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtKt, app);
		// String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ?
		// "ki\u1EC3m tra" : "thanh tra";
		// String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ?
		// "KI\u1EC2M TRA" : "THANH TRA";
		// StringBuffer sb = new StringBuffer(hinhThuc);
		StringBuffer sb = new StringBuffer("ki\u1EC3m tra");
		sb = new StringBuffer("\u0110O\u00C0N ");
		sb.append("KI\u1EC2M TRA");
		sb.append(" Q\u0110 S\u1ED0 ");
		sb.append(cbQd.getSoQuyetDinh());
		if (type.equals("bbChuyenGiao")) {
			fileIn = request.getRealPath("/docin/v4") + "\\KTNB39.doc";
			fileOut = request.getRealPath("/docout") + "\\KTNB39_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			fileTemplate = "ktnb39";
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", app.getTenCqt().toUpperCase());
				// word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
				word.put("[cqt_ra_van_ban]", cuocTtkt.getTenDonViTh().toUpperCase());
				if (Formater.isNull(form.getSoHs()))
					word.put("[so_qdinh]", "....../CHS-.........");
				else
					word.put("[so_qdinh]", cbQd.getSoQuyetDinh());
				if (form.getDiaDiemNopHs().equals("") || form.getThoiGian().equals("")) {
					word.put("[noi_lap]", ".....");
					word.put("[ngay_lap]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else {
					word.put("[noi_lap]", form.getDiaDiemNopHs());
					word.put("[ngay_lap]", KtnbUtil.getDay(form.getThoiGian()));
				}
				word.put("[ten_co_quan_dieu_tra_co_tham_quyen]", form.getTenCqDieuTra());

				// word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong_ban_hanhqd]", KtnbUtil.getTenThuTruongCqt(app));
				// word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[tom_tat_hanh_vi_vi_pham]", form.getTomTatHvVp());
				word.put("[cqt_ra_van_ban]", cuocTtkt.getTenDonViTh());
				if (Formater.isNull(form.getHanhViVp()))
					word.put("[hanh_vi_co_dau_hieu_toi_pham]", ".......");
				else
					word.put("[hanh_vi_co_dau_hieu_toi_pham]", form.getHanhViVp());
				word.put("[ten_co_quan_dieu_tra_co_tham_quyen]", form.getTenCqDieuTra());
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(app.getMaCqt()).toUpperCase());
				// word.put("[ten_thu_truong]", app.getTenThuTruong());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau KTNB39", ".doc", response);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {
				try {
					word.saveAndClose();
				} catch (Exception e) {

				}
			}
		} else if (type.equals("bbGiaoNhan")) { // Bien ban giao nhan
			fileIn = request.getRealPath("/docin/v4") + "\\KTNB40.doc";
			fileOut = request.getRealPath("/docout") + "\\KTNB40_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			fileTemplate = "ktnb40";
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", app.getTenCqt().toUpperCase());
				word.put("[ten_dv_giao_hs]", cuocTtkt.getTenDonViTh().toUpperCase());
				// word.put("[ngay_lap]",Formater.getDateForPrint(form.getTgGiaoNhan()));
				word.put("[ngay_lap]", KtnbUtil.getHour(form.getTgGiaoNhan()));
				word.put("[dia_diem_giao_nhan]", form.getDiaDiemGiaoNhan());
				word.put("[co_quan_giao_hs]", cuocTtkt.getTenDonViTh());
				word.put("[ten_co_quan_dieu_tra]", form.getTenCqDieuTra());
				// dai dien ben giao
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrthanhphanbg = form.getDsDaiDien();
				StringBuffer tptd = new StringBuffer("");
				if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
					for (int i = 0; i < arrthanhphanbg.length; i++) {
						tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg[i].getHoTen()));
						tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg[i].getChucVu()));
						tptd.append("\n           ");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrthanhphanbg[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbg[i].getChucVu());
						word.addRowTable(table, arrthanhphanbg.length);
					}
					System.out.println(tptd.toString());
					// word.put("dai_dien_ben_giao", tptd.toString());
				}

				// dai dien ben nhan
				table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arrthanhphanbg1 = form.getDsDaiDienCqDt();
				tptd = new StringBuffer("");
				if (arrthanhphanbg1 != null && arrthanhphanbg1.length > 0) {
					for (int i = 0; i < arrthanhphanbg1.length; i++) {
						tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg1[i].getHoTen()));
						tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg1[i].getChucVu()));
						tptd.append("\n           ");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrthanhphanbg1[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbg1[i].getChucVu());
						word.addRowTable(table, arrthanhphanbg1.length);
					}
					System.out.println(tptd.toString());
					// word.put("dai_dien_ben_nhan", tptd.toString());
				}
				word.put("[so_trang]", form.getSoTrang());
				if (Formater.isNull(form.getBaoGomCacTl()))
					word.put("[tai_lieu]", KtnbUtil.inFieldNull(115));
				else
					word.put("[tai_lieu]", form.getBaoGomCacTl());
				word.put("[thoi_diem_kt]", KtnbUtil.getHour(form.getThoiDiemKt()));
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau KTNB40", ".doc", response);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}
		}
	}

	private void loadDefault(String cuocTtktId, ApplicationContext app, BanGiaoHsVvForm form, String id) throws Exception {
		TtktKtChuyenGiaoHsVv hoSoVv = TtktCnPhuService.getHoSoVv(app, id);

		if (hoSoVv != null) {
			form.setId(hoSoVv.getId());
			form.setIdCuocTtKt(hoSoVv.getIdCuocTtkt());
			form.setThoiGian(Formater.date2strDateTimeForNV(hoSoVv.getThoiGian()));
			form.setDiaDiemNopHs(hoSoVv.getDiaDiemLapHs());
			form.setSoHs(hoSoVv.getSoHs());
			form.setHanhViVp(hoSoVv.getHanhViViPham());
			form.setTenCqDieuTra(hoSoVv.getTenCqDieuTra());
			form.setTomTatHvVp(hoSoVv.getTomTatHanhViViPham());
			form.setChucDanhNguoiKy(hoSoVv.getChucDanhNguoiKy());
			form.setTgGiaoNhan(Formater.date2strDateTimeForNV(hoSoVv.getThoiGianGiaoNhan()));
			form.setDiaDiemGiaoNhan(hoSoVv.getDiaDiem());
			form.setSoTrang(hoSoVv.getSoTrang().toString());
			form.setThoiDiemKt(Formater.date2str(hoSoVv.getThoiDiemKetThuc()));
			form.setBaoGomCacTl(hoSoVv.getBaoGomCacTl());
			form.setIdDsDaiDien(hoSoVv.getTpThamDuDoanTtkt());
			form.setIdDsDaiDienCqDt(hoSoVv.getTpThamDuCqDieuTra());

			// -------------- load danh sach dai dien -----------------------

			Collection dsDaidien = (Collection) hoSoVv.getDsDaiDien();
			if (dsDaidien != null) {
				TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[dsDaidien.size()];
				Iterator iter = dsDaidien.iterator();
				int i = 0;
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
					dsTpTdLoad[i] = tptd;
					i++;
				}
				form.setDsDaiDien(dsTpTdLoad);
			}

			// --------------- load danh sach dai dien co quan dieu tra
			// -------------
			Collection dsDaidienCqDt = (Collection) hoSoVv.getDsDaiDienCqDt();
			if (dsDaidienCqDt != null) {
				TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[dsDaidienCqDt.size()];
				Iterator iter = dsDaidienCqDt.iterator();
				int i = 0;
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
					dsTpTdLoad[i] = tptd;
					i++;
				}
				form.setDsDaiDienCqDt(dsTpTdLoad);
			}

		} else {
			form.setThoiDiemKt(Formater.date2strDateTimeForNV(new Date()));
			form.setThoiGian(Formater.date2strDateTimeForNV(new Date()));
			form.setTgGiaoNhan(Formater.date2str(new Date()));
			form.setIdCuocTtKt(cuocTtktId);
		}

	}

	private void saveYeuCau(BanGiaoHsVvForm form, ApplicationContext app) throws Exception {
		TtktKtChuyenGiaoHsVv hoSoVv = new TtktKtChuyenGiaoHsVv();

		hoSoVv.setId(form.getId());
		hoSoVv.setIdCuocTtkt(form.getIdCuocTtKt());
		hoSoVv.setThoiGian(Formater.str2dateForNV(form.getThoiGian()));
		hoSoVv.setDiaDiemLapHs(form.getDiaDiemNopHs());
		hoSoVv.setSoHs(form.getSoHs());
		hoSoVv.setTenCqDieuTra(form.getTenCqDieuTra());
		hoSoVv.setTomTatHanhViViPham(form.getTomTatHvVp());
		hoSoVv.setHanhViViPham(form.getHanhViVp());
		hoSoVv.setThoiGianGiaoNhan(Formater.str2dateForNV(form.getTgGiaoNhan()));
		hoSoVv.setDiaDiem(form.getDiaDiemGiaoNhan());
		hoSoVv.setSoTrang(Short.valueOf(form.getSoTrang()));
		hoSoVv.setBaoGomCacTl(form.getBaoGomCacTl());
		hoSoVv.setThoiDiemKetThuc(Formater.str2dateForNV(form.getThoiDiemKt()));
		hoSoVv.setChucDanhNguoiKy(form.getChucDanhNguoiKy());
		hoSoVv.setTenCqDieuTra(form.getTenCqDieuTra());
		// -- danh sach dai dien -----------------------------------
		String idDsDaiDien = form.getIdDsDaiDien();
		Collection arr1 = new ArrayList();
		if (form.getDsDaiDien() != null) {
			for (int i = 0; i < form.getDsDaiDien().length; i++) {
				TtktCmThanhPhanThamDu tptd = new TtktCmThanhPhanThamDu();
				tptd.setChucVu(form.getDsDaiDien()[i].getChucVu());
				tptd.setHoTen(form.getDsDaiDien()[i].getHoTen());
				tptd.setIdMaster(idDsDaiDien);
				tptd.setIdCanBo(form.getDsDaiDien()[i].getIdCanBo());
				tptd.setIdNguoiCapNat(app.getMaCanbo());
				tptd.setTenNguoiCapNhat(app.getTenCanbo());
				tptd.setNgayCapNhat(new Date());
				arr1.add(tptd);
			}
			hoSoVv.setTpThamDuDoanTtkt(idDsDaiDien);
			hoSoVv.setDsDaiDien(arr1);
		}
		// -------------------danh sach dai dien co quan dieu tra
		// ----------------------
		String idDsDaiDienCqDt = form.getIdDsDaiDienCqDt();
		Collection arr2 = new ArrayList();
		if (form.getDsDaiDienCqDt() != null) {
			for (int i = 0; i < form.getDsDaiDienCqDt().length; i++) {
				TtktCmThanhPhanThamDu tptd = new TtktCmThanhPhanThamDu();
				tptd.setChucVu(form.getDsDaiDienCqDt()[i].getChucVu());
				tptd.setHoTen(form.getDsDaiDienCqDt()[i].getHoTen());
				tptd.setIdMaster(idDsDaiDienCqDt);
				tptd.setIdCanBo(form.getDsDaiDienCqDt()[i].getIdCanBo());
				arr2.add(tptd);
			}
			hoSoVv.setTpThamDuCqDieuTra(idDsDaiDienCqDt);
			hoSoVv.setDsDaiDienCqDt(arr2);
		}

		TtktCnPhuService.saveHoSoVv(hoSoVv, app, form);
	}

}
