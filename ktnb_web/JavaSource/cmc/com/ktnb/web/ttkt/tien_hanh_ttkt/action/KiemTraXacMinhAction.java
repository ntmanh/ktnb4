package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.action;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThKiemTraXacMinh;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThPhucTra;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.KiemTraXacMinhForm;

public class KiemTraXacMinhAction extends BaseDispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {

		ApplicationContext app = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		KiemTraXacMinhForm kiemtraxacminForm = (KiemTraXacMinhForm) form;
		String method = request.getParameter("method");
		if ("save".equals(method)) {
			saveKiemTraXacMinh(request, kiemtraxacminForm, app);
			request.setAttribute("dsTvd", TtktService.getDsTvdById(app, kiemtraxacminForm.getIdDsTvd()));
			request.setAttribute("saveStatus", "true");
		} else if ("in".equals(method)) {
			// TODO: Kiem tra xem cho nay co phai load lai lan nua khong
			inKiemTraXacMinh(request, reponse, kiemtraxacminForm, app, kiemtraxacminForm.getIdCuocTtKt());
			return null;
		} else {
			String cuocTtktId = request.getParameter("idCuocTtkt");
			if (!Formater.isNull(cuocTtktId)) {
				// Nguoi dung click chon vao link tai form main hoac mo man hinh
				// tao moi tu form tim kiem
				if ("addnew".equals(method)) { // Tao moi tu man hinh tim kiem
					addNew(request, app, kiemtraxacminForm, cuocTtktId);

				} else { // Click vao link tai form main
					Collection dsKtxm = TtktCnPhuService.getDsKTXacMinh(app, cuocTtktId);
					if (Formater.isNull(dsKtxm)) { // Truong doan
						// them moi
						addNew(request, app, kiemtraxacminForm, cuocTtktId);
					} else {
						if (!app.isTruongDoan(cuocTtktId) && dsKtxm.size() == 1) {
							// Thu truong co quan va co 1 ban ghi
							loadDataToForm(request, app, kiemtraxacminForm, (TtktThKiemTraXacMinh) ((ArrayList) dsKtxm).get(0));
							request.setAttribute("readOnly", "true");
							return mapping.findForward("success");

						}
						request.getSession().setAttribute("dsKtXacMinh", dsKtxm);
						reponse.sendRedirect("danh_sach_tim_kiem.do?idCuocTtkt=" + cuocTtktId + "&type=ktXacMinh");
					}
				}

			} else {
				// Truong hop xem hoac sua thi truyen id vao url
				String id = request.getParameter("id");
				loadDataToForm(request, app, kiemtraxacminForm, id);
				if (!KtnbUtil.haveRoleNv(app) || "view".equals(method) || app.getTrangThaiCuocTtkt(kiemtraxacminForm.getIdCuocTtKt()).equals(Constants.TT_TTKT_KT)) {
					request.setAttribute("readOnly", "true");
				}

			}
			try {
				String id = request.getParameter("id");
				if (!Formater.isNull(id)) {
					TtktThKiemTraXacMinh ktXacMinh = TtktCnPhuService.getKiemTraXacMinh(app, id);
					request.setAttribute("ngayRaQuyetDnh", Formater.objectDate2Str(TtktService.getQuyetDinh(ktXacMinh.getIdCuocTtkt(), app).getNgayRaQuyetDnh()));
				} else {
					request.setAttribute("ngayRaQuyetDnh", Formater.objectDate2Str(TtktService.getQuyetDinh(cuocTtktId, app).getNgayRaQuyetDnh()));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return mapping.findForward("success");
	}

	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, KiemTraXacMinhForm kiemtraxacminForm, String id) throws Exception {
		TtktThKiemTraXacMinh ktXacMinh = TtktCnPhuService.getKiemTraXacMinh(app, id);
		loadDataToForm(request, app, kiemtraxacminForm, ktXacMinh);

	}

	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, KiemTraXacMinhForm kiemtraxacminForm, TtktThKiemTraXacMinh ktXacMinh) {

		kiemtraxacminForm.setIdKtXm(ktXacMinh.getId());
		kiemtraxacminForm.setIdCuocTtKt(ktXacMinh.getIdCuocTtkt());
		kiemtraxacminForm.setSkDuocKtXm(ktXacMinh.getSuViecDuocKtxm());
		kiemtraxacminForm.setThoiGian(Formater.date2strDateTimeForNV(ktXacMinh.getThoiGian()));
		kiemtraxacminForm.setDiaDiem(ktXacMinh.getDiaDiem());
		kiemtraxacminForm.setIdTpTdDoanTtKt(ktXacMinh.getThanhPhanThamDuDoanTtkt());
		kiemtraxacminForm.setIdTpTdDuocKtXm(ktXacMinh.getThanhPhanThamDuDoanDonVi());
		kiemtraxacminForm.setNoiDung(ktXacMinh.getNoiDung());

		// ----------- Load thanh phan tham du doan TTKT ------------------

		Collection dsTpTd = ktXacMinh.getDsDoanTtKt();
		if (dsTpTd != null) {
			TtktCmThanhPhanThamDu[] dsTpTdLoad1 = new TtktCmThanhPhanThamDu[dsTpTd.size()];
			Iterator iter = dsTpTd.iterator();
			int i = 0;
			while (iter.hasNext()) {
				TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
				dsTpTdLoad1[i] = tptd;
				i++;

			}
			kiemtraxacminForm.setDsTpTdDoanTtKt(dsTpTdLoad1);
		}
		// ----------- Load thanh phan tham du don vi duoc kiem tra xac minh
		// ------------------
		Collection dsDvDuocKtXmn = ktXacMinh.getDsDvDuocKtXm();
		if (dsDvDuocKtXmn != null) {
			TtktCmThanhPhanThamDu[] dsTpTdLoad2 = new TtktCmThanhPhanThamDu[dsDvDuocKtXmn.size()];
			Iterator iter = dsDvDuocKtXmn.iterator();
			int i = 0;
			while (iter.hasNext()) {
				TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
				dsTpTdLoad2[i] = tptd;
				i++;

			}
			kiemtraxacminForm.setDsTpTdDuocKtXm(dsTpTdLoad2);
		}
		kiemtraxacminForm.setIdDsTvd(ktXacMinh.getIdDsTvd());
		request.setAttribute("dsTvd", TtktService.getDanhSachThanhVienDoan(ktXacMinh.getIdCuocTtkt()));

	}

	private void addNew(HttpServletRequest request, ApplicationContext app, KiemTraXacMinhForm kiemtraxacminForm, String cuocTtktId) throws Exception {
		kiemtraxacminForm.setIdCuocTtKt(cuocTtktId);
		TtktCbDsTvDoan dsTvDoan = TtktService.getDsTvd(cuocTtktId, app);
		kiemtraxacminForm.setIdDsTvd(dsTvDoan.getId());
		kiemtraxacminForm.setDiaDiem(KtnbUtil.getTenTinhByMaCqt(app, CuocTtktService.getCuocTtkt(app, cuocTtktId).getIdDonViBi()));
		request.setAttribute("dsTvd", dsTvDoan.getChiTietDanhSachTV());

	}

	private void loadDefaulForm(KiemTraXacMinhForm kiemtraxacminForm, ApplicationContext app, HttpServletRequest request, String id, String idCuocTtKt) throws Exception {
		TtktThKiemTraXacMinh kiemtraxacminh = TtktCnPhuService.getKiemTraXacMinh(app, id);
		//
		if (kiemtraxacminh != null) {
			kiemtraxacminForm.setIdKtXm(kiemtraxacminh.getId());
			kiemtraxacminForm.setIdCuocTtKt(kiemtraxacminh.getIdCuocTtkt());
			kiemtraxacminForm.setSkDuocKtXm(kiemtraxacminh.getSuViecDuocKtxm());
			kiemtraxacminForm.setThoiGian(Formater.date2strDateTimeForNV(kiemtraxacminh.getThoiGian()));
			kiemtraxacminForm.setDiaDiem(kiemtraxacminh.getDiaDiem());
			kiemtraxacminForm.setIdTpTdDoanTtKt(kiemtraxacminh.getThanhPhanThamDuDoanTtkt());
			kiemtraxacminForm.setIdTpTdDuocKtXm(kiemtraxacminh.getThanhPhanThamDuDoanDonVi());
			kiemtraxacminForm.setNoiDung(kiemtraxacminh.getNoiDung());

			// ----------- Load thanh phan tham du doan TTKT ------------------

			Collection dsTpTd = kiemtraxacminh.getDsDoanTtKt();
			if (dsTpTd != null) {
				TtktCmThanhPhanThamDu[] dsTpTdLoad1 = new TtktCmThanhPhanThamDu[dsTpTd.size()];
				Iterator iter = dsTpTd.iterator();
				int i = 0;
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
					dsTpTdLoad1[i] = tptd;
					i++;

				}
				kiemtraxacminForm.setDsTpTdDoanTtKt(dsTpTdLoad1);
			}
			// ----------- Load thanh phan tham du don vi duoc kiem tra xac minh
			// ------------------
			Collection dsDvDuocKtXmn = kiemtraxacminh.getDsDvDuocKtXm();
			if (dsDvDuocKtXmn != null) {
				TtktCmThanhPhanThamDu[] dsTpTdLoad2 = new TtktCmThanhPhanThamDu[dsDvDuocKtXmn.size()];
				Iterator iter = dsDvDuocKtXmn.iterator();
				int i = 0;
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
					dsTpTdLoad2[i] = tptd;
					i++;

				}
				kiemtraxacminForm.setDsTpTdDuocKtXm(dsTpTdLoad2);
			}
			// -------------Dung request dua danh sach ten TPTD toi Clien
			// -------------
			request.setAttribute("dsTenTpTdDoan", getDsTen(kiemtraxacminForm.getDsTpTdDoanTtKt()));
			request.setAttribute("dsTenTpTdDoanCoTlNp", getDsTen(kiemtraxacminForm.getDsTpTdDuocKtXm()));

		} else {

			DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
			kiemtraxacminForm.setIdCuocTtKt(idCuocTtKt);
			kiemtraxacminForm.setThoiGian(dateFormat.format(new Date()));
		}
	}

	private void saveKiemTraXacMinh(HttpServletRequest request, KiemTraXacMinhForm kiemtraxacminForm, ApplicationContext app) throws Exception {
		TtktThKiemTraXacMinh kiemTraXacMinh = createKtXm(kiemtraxacminForm, app, request);
		TtktCnPhuService.saveKiemTraXacMinh(kiemTraXacMinh, app);

	}

	private TtktThKiemTraXacMinh createKtXm(KiemTraXacMinhForm kiemtraxacminForm, ApplicationContext app, HttpServletRequest request) throws Exception {
		TtktThKiemTraXacMinh kTxM = new TtktThKiemTraXacMinh();
		kTxM.setId(kiemtraxacminForm.getIdKtXm());
		kTxM.setDiaDiem(kiemtraxacminForm.getDiaDiem());
		kTxM.setIdCuocTtkt(kiemtraxacminForm.getIdCuocTtKt());
		kTxM.setNoiDung(kiemtraxacminForm.getNoiDung());
		kTxM.setSuViecDuocKtxm(kiemtraxacminForm.getSkDuocKtXm());
		kTxM.setThanhPhanThamDuDoanDonVi(kiemtraxacminForm.getIdTpTdDuocKtXm());
		kTxM.setThanhPhanThamDuDoanTtkt(kiemtraxacminForm.getIdTpTdDoanTtKt());
		kTxM.setThoiGian(Formater.str2dateForNV(kiemtraxacminForm.getThoiGian()));
		kTxM.setIdNguoiCapNat(app.getMaCanbo());
		kTxM.setTenNguoiCapNhat(app.getMaCanbo());
		kTxM.setNgayCapNhat(new Date());

		// ------------- Thanh pham tham du thanh tra kiem tra
		// -------------------------
		Collection dsDoanTtkt = new ArrayList();
		if (kiemtraxacminForm.getDsTpTdDoanTtKt() != null) {
			for (int i = 0; i < kiemtraxacminForm.getDsTpTdDoanTtKt().length; i++) {
				TtktCmThanhPhanThamDu tptd = new TtktCmThanhPhanThamDu();
				tptd.setChucVu(kiemtraxacminForm.getDsTpTdDoanTtKt()[i].getChucVu());
				tptd.setHoTen(kiemtraxacminForm.getDsTpTdDoanTtKt()[i].getHoTen());
				tptd.setIdMaster(kiemtraxacminForm.getIdTpTdDoanTtKt());
				tptd.setIdCanBo(kiemtraxacminForm.getDsTpTdDoanTtKt()[i].getIdCanBo());
				tptd.setIdNguoiCapNat(app.getMaCanbo());
				tptd.setTenNguoiCapNhat(app.getTenCanbo());
				tptd.setNgayCapNhat(new Date());
				dsDoanTtkt.add(tptd);
			}

			kTxM.setDsDoanTtKt(dsDoanTtkt);
		}
		// ------------- thanh phan tham du don vi kiem tra xac minh
		// -------------------
		Collection dsDvDuocKtXm = new ArrayList();
		if (kiemtraxacminForm.getDsTpTdDuocKtXm() != null) {
			for (int i = 0; i < kiemtraxacminForm.getDsTpTdDuocKtXm().length; i++) {
				TtktCmThanhPhanThamDu tptd = new TtktCmThanhPhanThamDu();
				tptd.setChucVu(kiemtraxacminForm.getDsTpTdDuocKtXm()[i].getChucVu());
				tptd.setHoTen(kiemtraxacminForm.getDsTpTdDuocKtXm()[i].getHoTen());
				tptd.setIdMaster(kiemtraxacminForm.getIdTpTdDuocKtXm());
				tptd.setIdCanBo(kiemtraxacminForm.getDsTpTdDuocKtXm()[i].getIdCanBo());
				dsDvDuocKtXm.add(tptd);
			}

			kTxM.setDsDvDuocKtXm(dsDvDuocKtXm);
		}
		return kTxM;
	}

	// lay danh ten cua thanh phan tham du
	public String getDsTen(TtktCmThanhPhanThamDu[] dsTpTd) {
		String arr = "";
		for (int i = 0; i < dsTpTd.length; i++) {
			String ten = dsTpTd[i].getHoTen();
			arr += ten + ",";
		}
		return arr;
	}

	public void inKiemTraXacMinh_old(HttpServletRequest request, HttpServletResponse reponse, KiemTraXacMinhForm form, ApplicationContext app, String idCuocTtKt) throws Exception {
		// String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = "ttnb31";
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, idCuocTtKt);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		String hinhThucT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtKt, app);
		StringBuffer sb = new StringBuffer(hinhThuc);
		parameters.put("ttkt", sb.toString());
		sb = new StringBuffer("\u0110o\u00E0n ");
		sb.append(hinhThuc);
		sb.append(" s\u1ED1 ");
		sb.append(cbQd.getSoQuyetDinh());

		fileTemplate = "ttnb31";
		parameters.put("ten_cqt", app.getTenCqt());
		parameters.put("doan_ttkt_so", sb.toString());
		// parameters.put("ten_bc",app.getTenCqt());
		parameters.put("ttkt", hinhThuc);
		parameters.put("dia_diem", form.getDiaDiem());
		// parameters.put("so_qdinh",app.getTenCqt());
		parameters.put("ngay_qd", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
		parameters.put("so_qd", cbQd.getSoQuyetDinh());
		parameters.put("thu_truong_qd", KtnbUtil.getTenThuTruongCqt(app));
		parameters.put("dv_dc_ttkt", cuocTtkt.getTenDonViBi());
		// parameters.put("noi_ra_qd",app.getTenCqt());
		// parameters.put("ngay_ra_qd",app.getTenCqt());
		// parameters.put("ngay_kiem_ke",app.getTenCqt());
		parameters.put("su_viec_dc_kiem_tra_xac_minh", form.getSkDuocKtXm());
		parameters.put("thoi_gian_lap_bien_ban", KtnbUtil.getHour(form.getThoiGian()));
		parameters.put("noi_dung_xac_minh", form.getNoiDung());
		parameters.put("ten_truong_doan", cuocTtkt.getTenTruongDoan());

		// doan thanh tra kiem tra
		TtktCmThanhPhanThamDu[] arrthanhphanbg = form.getDsTpTdDoanTtKt();
		StringBuffer tptd = new StringBuffer("");
		if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
			for (int i = 0; i < arrthanhphanbg.length; i++) {
				tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg[i].getHoTen()));
				tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg[i].getChucVu()));
				tptd.append("\n");
			}
			System.out.println(tptd.toString());
			parameters.put("thanh_vien", tptd.toString());
		}
		// don vi duoc kiem tra xac min
		TtktCmThanhPhanThamDu[] arr = form.getDsTpTdDuocKtXm();
		StringBuffer tptd1 = new StringBuffer("");
		if (arr != null && arr.length > 0) {
			for (int i = 0; i < arr.length; i++) {
				tptd1.append(KtnbUtil.layoutTableHoTen(arr[i].getHoTen()));
				tptd1.append(KtnbUtil.layoutTableChucVu(arr[i].getChucVu()));
				tptd1.append("\n");
			}
			System.out.println(tptd1.toString());
			parameters.put("thanh_vien_dv", tptd1.toString());
		}
		if (Formater.isNull(fileTemplate))
			throw new Exception("Chua chon file template");

		InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
		KtnbUtil.printf(reportRows, fileTemplate, reponse, inputStream, parameters, null);
	}

	/**
	 * Download file mau TTNB31
	 * 
	 * @throws Exception
	 */
	//v3
	public void inKiemTraXacMinhv3(HttpServletRequest request, HttpServletResponse reponse, KiemTraXacMinhForm form, ApplicationContext app, String idCuocTtKt) throws Exception {
		// String type = request.getParameter("type");
		String fileIn = request.getRealPath("/docin") + "\\TTNB31.doc";
		String fileOut = request.getRealPath("/docout") + "\\TTNB31_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = "ttnb31";
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, idCuocTtKt);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		String hinhThucT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtKt, app);
		StringBuffer sb = new StringBuffer(hinhThuc);
		sb = new StringBuffer("\u0110o\u00E0n ");
		sb.append(hinhThucT);
		sb.append(" s\u1ED1 ");
		sb.append(cbQd.getSoQuyetDinh());

		MsWordUtils word = new MsWordUtils(fileIn, fileOut);
		try {
			word.put("[ten_cqt]", app.getTenCqt().toUpperCase());
			word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
			word.put("[su_viec_dc_kiem_tra_xac_minh]", form.getSkDuocKtXm());
			// word.put("[ten_bc]",app.getTenCqt());
			word.put("[ttkt]", hinhThuc);
			word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			word.put("[so_qd]", cbQd.getSoQuyetDinh());
			word.put("[thu_truong_qd]", KtnbUtil.getTenThuTruongCqtForMauin(app));
			word.put("[ttkt]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
			word.put("[thoi_gian_lap_bien_ban]", KtnbUtil.getHour(form.getThoiGian()));
			word.put("[dia_diem]", form.getDiaDiem());
			word.put("[ttkt]", hinhThuc);
			word.put("[su_viec_dc_kiem_tra_xac_minh]", form.getSkDuocKtXm());
			word.put("[ttkt]", hinhThuc);
			// word.put("[so_qdinh]",app.getTenCqt());

			// word.put("[noi_ra_qd]",app.getTenCqt());
			// word.put("[ngay_ra_qd]",app.getTenCqt());
			// word.put("[ngay_kiem_ke]",app.getTenCqt());

			// doan thanh tra kiem tra
			Dispatch table = word.openTable(2);
			TtktCmThanhPhanThamDu[] arrthanhphanbg = form.getDsTpTdDoanTtKt();
			StringBuffer tptd = new StringBuffer("");
			if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
				for (int i = 0; i < arrthanhphanbg.length; i++) {
					tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg[i].getHoTen()));
					tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg[i].getChucVu()));
					tptd.append("\n");
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrthanhphanbg[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbg[i].getChucVu());
					word.addRowTable(table, arrthanhphanbg.length);
				}
				System.out.println(tptd.toString());
				// word.put("[thanh_vien]", tptd.toString());
			}
			// don vi duoc kiem tra xac minh
			word.put("[ten_don_vi_xac_minh]", cuocTtkt.getTenDonViBi());
			table = word.openTable(3);
			TtktCmThanhPhanThamDu[] arr = form.getDsTpTdDuocKtXm();
			StringBuffer tptd1 = new StringBuffer("");
			if (arr != null && arr.length > 0) {
				for (int i = 0; i < arr.length; i++) {
					tptd1.append(KtnbUtil.layoutTableHoTen(arr[i].getHoTen()));
					tptd1.append(KtnbUtil.layoutTableChucVu(arr[i].getChucVu()));
					tptd1.append("\n");
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arr[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arr[i].getChucVu());
					word.addRowTable(table, arr.length);
				}
				System.out.println(tptd1.toString());
				// word.put("[thanh_vien_dv]", tptd1.toString());
			}

			word.put("[noi_dung_xac_minh]", form.getNoiDung());
			word.put("[ttkt]", hinhThuc.toUpperCase());
			word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau TTNB31", ".doc", reponse);
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
	
	public void inKiemTraXacMinh(HttpServletRequest request, HttpServletResponse reponse, KiemTraXacMinhForm form, ApplicationContext app, String idCuocTtKt) throws Exception {
		// String type = request.getParameter("type");
		String fileIn = request.getRealPath("/docin/v4") + "\\TTNB30.doc";
		String fileOut = request.getRealPath("/docout") + "\\TTNB30_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = "ttnb31";
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, idCuocTtKt);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		String hinhThucT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtKt, app);
		StringBuffer sb = new StringBuffer(hinhThuc);
		sb = new StringBuffer("\u0110o\u00E0n ");
		sb.append(hinhThucT);
		sb.append(" s\u1ED1 ");
		sb.append(cbQd.getSoQuyetDinh());

		MsWordUtils word = new MsWordUtils(fileIn, fileOut);
		try {
			word.put("[ten_cqt]", app.getTenCqt().toUpperCase());
			word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
			word.put("[su_viec_dc_kiem_tra_xac_minh]", form.getSkDuocKtXm());
			// word.put("[ten_bc]",app.getTenCqt());
			//word.put("[ttkt]", hinhThuc);
			word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			word.put("[so_qd]", cbQd.getSoQuyetDinh());
			word.put("[thu_truong_qd]", KtnbUtil.getTenThuTruongCqtForMauin(app));
			//word.put("[ttkt]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
			word.put("[thoi_gian_lap_bien_ban]", KtnbUtil.getHour(form.getThoiGian()));
			word.put("[dia_diem]", form.getDiaDiem());
			//word.put("[ttkt]", hinhThuc);
			word.put("[su_viec_dc_kiem_tra_xac_minh]", form.getSkDuocKtXm());
			//word.put("[ttkt]", hinhThuc);
			// word.put("[so_qdinh]",app.getTenCqt());

			// word.put("[noi_ra_qd]",app.getTenCqt());
			// word.put("[ngay_ra_qd]",app.getTenCqt());
			// word.put("[ngay_kiem_ke]",app.getTenCqt());

			// doan thanh tra kiem tra
			Dispatch table = word.openTable(2);
			TtktCmThanhPhanThamDu[] arrthanhphanbg = form.getDsTpTdDoanTtKt();
			StringBuffer tptd = new StringBuffer("");
			if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
				for (int i = 0; i < arrthanhphanbg.length; i++) {
					tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg[i].getHoTen()));
					tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg[i].getChucVu()));
					tptd.append("\n");
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrthanhphanbg[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbg[i].getChucVu());
					word.addRowTable(table, arrthanhphanbg.length);
				}
				System.out.println(tptd.toString());
				// word.put("[thanh_vien]", tptd.toString());
			}
			// don vi duoc kiem tra xac minh
			word.put("[ten_don_vi_xac_minh]", cuocTtkt.getTenDonViBi());
			table = word.openTable(3);
			TtktCmThanhPhanThamDu[] arr = form.getDsTpTdDuocKtXm();
			StringBuffer tptd1 = new StringBuffer("");
			if (arr != null && arr.length > 0) {
				for (int i = 0; i < arr.length; i++) {
					tptd1.append(KtnbUtil.layoutTableHoTen(arr[i].getHoTen()));
					tptd1.append(KtnbUtil.layoutTableChucVu(arr[i].getChucVu()));
					tptd1.append("\n");
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arr[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arr[i].getChucVu());
					word.addRowTable(table, arr.length);
				}
				System.out.println(tptd1.toString());
				// word.put("[thanh_vien_dv]", tptd1.toString());
			}

			word.put("[noi_dung_xac_minh]", form.getNoiDung());
			//word.put("[ttkt]", hinhThuc.toUpperCase());
			word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau TTNB30", ".doc", reponse);
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
}
