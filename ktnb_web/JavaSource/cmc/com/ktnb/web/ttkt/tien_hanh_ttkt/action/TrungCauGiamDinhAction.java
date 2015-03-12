package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.action;

import java.io.InputStream;
import java.util.ArrayList;
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
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThKiemTraXacMinh;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThTrungCauGiamDinh;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.dung_chung.form.BienBanLamViecForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.KiemTraXacMinhForm;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.TrungCauGiamDinhForm;

/**
 * Form bean for a Struts application.
 * 
 * @version 1.0
 * @author
 */
public class TrungCauGiamDinhAction extends BaseDispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {

		ApplicationContext app = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		TrungCauGiamDinhForm tcGiamDinhForm = (TrungCauGiamDinhForm) form;
		String method = request.getParameter("method");
		
		if ("save".equals(method)) {
			saveTrungCauGiamDinh(tcGiamDinhForm, app);
			request.setAttribute("saveStatus", "true");
		} else if ("in".equals(method)) {
			// TODO: Kiem tra xem cho nay co phai load lai lan nua khong
			inTrungCauGD(request, reponse, tcGiamDinhForm, app);
			return null;
		} else {
			String cuocTtktId = request.getParameter("idCuocTtkt");
			if (!Formater.isNull(cuocTtktId)) {
				// Nguoi dung click chon vao link tai form main hoac mo man hinh
				// tao moi tu form tim kiem
				if ("addnew".equals(method)) { // Tao moi tu man hinh tim kiem
					addNew(request, app, tcGiamDinhForm, cuocTtktId);

				} else { // Click vao link tai form main
					Collection dsTcGiamDinh = TtktCnPhuService.getDsTCGiamDinh(app, cuocTtktId);
					if (Formater.isNull(dsTcGiamDinh)) { // Truong doan
						// them moi
						addNew(request, app, tcGiamDinhForm, cuocTtktId);
					} else {
						if (!app.isTruongDoan(cuocTtktId) && dsTcGiamDinh.size() == 1) {
							// Thu truong co quan va co 1 ban ghi
							loadDataToForm(request, app, tcGiamDinhForm, (TtktThTrungCauGiamDinh) ((ArrayList) dsTcGiamDinh).get(0));
							request.setAttribute("readOnly", "true");
							return mapping.findForward("success");

						}
						request.getSession().setAttribute("dsTcGiamDinh", dsTcGiamDinh);
						reponse.sendRedirect("danh_sach_tim_kiem.do?idCuocTtkt=" + cuocTtktId + "&type=tcGiamDinh");
					}
					try {
						request.setAttribute("ngayRaQuyetDnh", Formater.objectDate2Str(TtktService.getQuyetDinh(cuocTtktId, app).getNgayRaQuyetDnh()));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			} else {
				// Truong hop xem hoac sua thi truyen id vao url
				String id = request.getParameter("id");
				loadDataToForm(request, app, tcGiamDinhForm, id);
				if (!KtnbUtil.haveRoleNv(app) || "view".equals(method) || app.getTrangThaiCuocTtkt(tcGiamDinhForm.getIdCuocTtKt()).equals(Constants.TT_TTKT_KT)) {
					request.setAttribute("readOnly", "true");
				}

			}
		}

		return mapping.findForward("success");
	}

	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, TrungCauGiamDinhForm tcGiamDinhForm, String id) throws Exception {
		TtktThTrungCauGiamDinh tcGiamDinh = TtktCnPhuService.getTcGd(app, id);
		loadDataToForm(request, app, tcGiamDinhForm, tcGiamDinh);

	}

	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, TrungCauGiamDinhForm tcGiamDinhForm, TtktThTrungCauGiamDinh trungCauGiamDinh) throws Exception {
		tcGiamDinhForm.setId(trungCauGiamDinh.getId());
		tcGiamDinhForm.setIdCuocTtKt(trungCauGiamDinh.getIdCuocTtkt());
		tcGiamDinhForm.setIdCqtGd(trungCauGiamDinh.getIdCqtGiamDinh());
		tcGiamDinhForm.setIdCqtTc(trungCauGiamDinh.getIdCqtTrungCau());
		tcGiamDinhForm.setNoiLap(trungCauGiamDinh.getNoiLap());
		tcGiamDinhForm.setNgayCcKq(Formater.date2str(trungCauGiamDinh.getNgayCungCapKq()));
		tcGiamDinhForm.setNgayLap(Formater.date2str(trungCauGiamDinh.getNgayLap()));
		tcGiamDinhForm.setNoiDung(trungCauGiamDinh.getNoiDung());
		tcGiamDinhForm.setTenCqtGd(trungCauGiamDinh.getTenCqtGiamDinh());
		tcGiamDinhForm.setTenCqtTc(trungCauGiamDinh.getTenCqtTrungCau());
		tcGiamDinhForm.setSoQd(trungCauGiamDinh.getSoQuyetDinh());
		//tcGiamDinhForm.setSoQd(KtnbUtil.getMaNvu(app, "TCG\u0110"));
	}

	private void addNew(HttpServletRequest request, ApplicationContext app, TrungCauGiamDinhForm tcGiamDinhForm, String cuocTtktId) {
		tcGiamDinhForm.setIdCuocTtKt(cuocTtktId);

	}

	private void loadDefaulForm(TrungCauGiamDinhForm form, ApplicationContext app, HttpServletRequest request, String id, String cuocTtktId) throws Exception {
		TtktThTrungCauGiamDinh trungCauGiamDinh = TtktCnPhuService.getTcGd(app, id);
		if (trungCauGiamDinh != null) {
			form.setId(trungCauGiamDinh.getId());
			form.setIdCqtGd(trungCauGiamDinh.getIdCqtGiamDinh());
			form.setIdCqtTc(trungCauGiamDinh.getIdCqtTrungCau());
			form.setNoiLap(trungCauGiamDinh.getNoiLap());
			form.setNgayCcKq(Formater.date2str(trungCauGiamDinh.getNgayCungCapKq()));
			form.setNgayLap(Formater.date2str(trungCauGiamDinh.getNgayLap()));
			form.setNoiDung(trungCauGiamDinh.getNoiDung());
			form.setTenCqtGd(trungCauGiamDinh.getTenCqtGiamDinh());
			form.setTenCqtTc(trungCauGiamDinh.getTenCqtTrungCau());
			form.setSoQd(trungCauGiamDinh.getSoQuyetDinh());
			//form.setSoQd(KtnbUtil.getMaNvu(app, "/TCG\u0110"));
		} else
			form.setNgayCcKq(Formater.date2str(new Date()));
		form.setNgayLap(Formater.date2str(new Date()));
		form.setIdCuocTtKt(cuocTtktId);

	}

	private void saveTrungCauGiamDinh(TrungCauGiamDinhForm form, ApplicationContext app) throws Exception {
		TtktThTrungCauGiamDinh tcgd = new TtktThTrungCauGiamDinh();

		tcgd.setId(form.getId());
		tcgd.setIdCqtGiamDinh(form.getIdCqtGd());
		tcgd.setIdCqtTrungCau(form.getIdCqtTc());
		tcgd.setIdCuocTtkt(form.getIdCuocTtKt());
		tcgd.setNgayCungCapKq(Formater.str2date(form.getNgayCcKq()));
		tcgd.setNgayLap(Formater.str2date(form.getNgayLap()));
		tcgd.setNoiDung(form.getNoiDung());
		tcgd.setNoiLap(form.getNoiLap());
		tcgd.setTenCqtGiamDinh(form.getTenCqtGd());
		tcgd.setTenCqtTrungCau(form.getTenCqtTc());
		tcgd.setIdNguoiCapNat(app.getMaCanbo());
		tcgd.setTenNguoiCapNhat(app.getTenCanbo());
		tcgd.setSoQuyetDinh(form.getSoQd());
		;
		TtktCnPhuService.saveTrungCauGiamDinh(tcgd, app);
	}

	public void inTrungCauGD_old(HttpServletRequest request, HttpServletResponse reponse, TrungCauGiamDinhForm form, ApplicationContext app, String idCuocTtKt) throws Exception {
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		fileTemplate = "ttnb32";
		String idCuocTtkt = form.getIdCuocTtKt();
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, idCuocTtkt);

		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, app);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		StringBuffer sb = new StringBuffer(hinhThuc);
		parameters.put("ttkt", sb.toString());
		parameters.put("ten_cqt", KtnbUtil.getTenCqtCapTrenTt(app));
		parameters.put("thu_truong_cqt", KtnbUtil.getTenThuTruongCqt(app));
		parameters.put("cqt_ra_van_ban", cuocTtkt.getTenDonViTh());
		parameters.put("doan_ttkt_so", cbQd.getSoQuyetDinh());
		parameters.put("co_quan_giam_dinh", form.getTenCqtGd());
		parameters.put("so_qd", cbQd.getSoQuyetDinh());
		parameters.put("ngay_qd", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
		parameters.put("ttkt", hinhThuc);
		parameters.put("dv_dc_ttkt", cuocTtkt.getTenDonViBi());
		parameters.put("ten_co_quan_yeu_giam_dinh", form.getTenCqtTc());
		parameters.put("noi_dung", form.getNoiDung());
		parameters.put("truoc_ngay", Formater.getDateForPrint(form.getNgayCcKq()));
		parameters.put("chuc_danh_thu_truong", KtnbUtil.getChucVuThuTruongByMaCqt(app.getMaCqt()));
		// --parameters.put("noi_lap", form.getNoiLap());
		// --parameters.put("ngay_lap",
		// Formater.getDateForPrint(form.getNgayLap()) );
		// parameters.put("ten_thu_truong", app.getTenThuTruong());

		if (form.getNoiLap().equals("") || form.getNgayLap().equals("")) {
			parameters.put("noi_lap", ".....");
			parameters.put("ngay_lap", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
		} else {
			parameters.put("noi_lap", form.getNoiLap());
			parameters.put("ngay_lap", Formater.getDateForPrint(form.getNgayLap()));
		}

		if (Formater.isNull(fileTemplate))
			throw new Exception("Chua chon file template");

		InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
		KtnbUtil.printf(reportRows, fileTemplate, reponse, inputStream, parameters, null);
	}

	/**
	 * Download file mau TTNB32
	 * 
	 * @throws Exception
	 */
	
	/**
	 * 
	 * Method : inTrungCauGD
	 * Des : chon version
	 * */
	
	private void inTrungCauGD(HttpServletRequest request,  HttpServletResponse reponse, TrungCauGiamDinhForm form, ApplicationContext appConText) throws Exception {
		CuocTtktService service = new CuocTtktService();
		String cuocTtktId=form.getIdCuocTtKt();
		System.out.println("Id cuoc ttkt : "+cuocTtktId );
		if(!Formater.isNull(cuocTtktId))
		{
			if(Constants.DON_VERSION.equals(service.getDonVerionTtkt(appConText, cuocTtktId)))
			{
				inTrungCauGDv4(request, reponse, form, appConText, cuocTtktId);
			}
			else inTrungCauGDv3(request, reponse, form, appConText, cuocTtktId);
		}
		else 
		{
			if(Constants.DON_VERSION.equals(Constants.APP_DEP_VERSION))
				inTrungCauGDv4(request, reponse, form, appConText, cuocTtktId);
			else inTrungCauGDv3(request, reponse, form, appConText, cuocTtktId);
		}
	}
	
	
	/**
	 * 
	 * Method : inTrungCauGDv3
	 * Des : ktnb v3
	 * */
	
	//v3
	public void inTrungCauGDv3(HttpServletRequest request, HttpServletResponse reponse, TrungCauGiamDinhForm form, ApplicationContext app, String idCuocTtKt) throws Exception {
		String fileIn = request.getRealPath("/docin") + "\\TTNB32.doc";
		String fileOut = request.getRealPath("/docout") + "\\TTNB32_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		fileTemplate = "ttnb32";
		String idCuocTtkt = form.getIdCuocTtKt();
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, idCuocTtkt);

		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, app);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";

		MsWordUtils word = new MsWordUtils(fileIn, fileOut);
		try {
			word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(app).toUpperCase());
			word.put("[cqt_ra_van_ban]", cuocTtkt.getTenDonViTh().toUpperCase());
			// word.put("[doan_ttkt_so]", cbQd.getSoQuyetDinh());
			word.put("[doan_ttkt_so]", "........../TCG\u0110-......."); // dang
			// thieu
			// truong
			// nay
			// tren
			// form
			if (form.getNoiLap().equals("") || form.getNgayLap().equals("")) {
				word.put("[noi_lap]", ".....");
				word.put("[ngay_lap]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			} else {
				word.put("[noi_lap]", form.getNoiLap());
				word.put("[ngay_lap]", Formater.getDateForPrint(form.getNgayLap()));
			}
			String cq_giamdinh = null;
			if (Formater.isNull(form.getTenCqtGd()))
				cq_giamdinh = "...........";
			else
				cq_giamdinh = form.getTenCqtGd();
			word.put("[co_quan_giam_dinh]", cq_giamdinh);
			word.put("[ttkt]", hinhThuc);
			word.put("[so_qd]", cbQd.getSoQuyetDinh());
			word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqt(app));
			word.put("[ttkt]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
			word.put("[ttkt]", hinhThuc);
			String ten_cq_giamdinh = null;
			if (Formater.isNull(form.getTenCqtTc()))
				ten_cq_giamdinh = "......";
			else
				ten_cq_giamdinh = form.getTenCqtTc();
			word.put("[ten_co_quan_yeu_giam_dinh]", ten_cq_giamdinh);
			word.put("[co_quan_giam_dinh]", cq_giamdinh);
			word.put("[noi_dung]", form.getNoiDung());
			word.put("[ten_co_quan_yeu_giam_dinh]", ten_cq_giamdinh);
			word.put("[ten_co_quan_yeu_giam_dinh]", ten_cq_giamdinh);
			word.put("[truoc_ngay]", Formater.getDateForPrint(form.getNgayCcKq()));
			word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(app.getMaCqt()).toUpperCase());
			// --word.put("noi_lap", form.getNoiLap());
			// --word.put("ngay_lap",
			// Formater.getDateForPrint(form.getNgayLap()) );
			// word.put("[ten_thu_truong]", app.getTenThuTruong());

			word.saveAndClose();
			word.downloadFile(fileOut, "Mau TTNB32", ".doc", reponse);
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
	 * Edit : ntmanh	
	 * Method : inTrungCauGDv4
	 * Des : ktnb v4
	 * */

	public void inTrungCauGDv4(HttpServletRequest request, HttpServletResponse reponse, TrungCauGiamDinhForm form, ApplicationContext app, String idCuocTtKt) throws Exception {
		System.out.println("This is KTNBv4");
		String fileIn = request.getRealPath("/docin/v4") + "\\TTNB31.doc";
		String fileOut = request.getRealPath("/docout") + "\\TTNB31_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		fileTemplate = "ttnb31";
		String idCuocTtkt = form.getIdCuocTtKt();
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, idCuocTtkt);

		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, app);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";

		MsWordUtils word = new MsWordUtils(fileIn, fileOut);
		try {
			word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(app).toUpperCase());
			word.put("[cqt_ra_van_ban]", cuocTtkt.getTenDonViTh().toUpperCase());
			word.put("[doan_ttkt_so]", form.getSoQd().toString()+KtnbUtil.getMaNvu1(app, "TCG\u0110") );
			//word.put("[doan_ttkt_so]", "........../TCG\u0110-......."); // dang
			// thieu
			// truong
			// nay
			// tren
			// form
			if (form.getNoiLap().equals("") || form.getNgayLap().equals("")) {
				word.put("[noi_lap]", ".....");
				word.put("[ngay_lap]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			} else {
				word.put("[noi_lap]", form.getNoiLap());
				word.put("[ngay_lap]", Formater.getDateForPrint(form.getNgayLap()));
			}
			String cq_giamdinh = null;
			if (Formater.isNull(form.getTenCqtGd()))
				cq_giamdinh = "...........";
			else
				cq_giamdinh = form.getTenCqtGd();
			word.put("[co_quan_giam_dinh]", cq_giamdinh);
			//word.put("[ttkt]", hinhThuc);
			word.put("[so_qd]", cbQd.getSoQuyetDinh());
			word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqt(app));
			//word.put("[ttkt]", hinhThuc);
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
			//word.put("[ttkt]", hinhThuc);
			String ten_cq_giamdinh = null;
			if (Formater.isNull(form.getTenCqtTc()))
				ten_cq_giamdinh = "......";
			else
				ten_cq_giamdinh = form.getTenCqtTc();
			word.put("[ten_co_quan_yeu_giam_dinh]", ten_cq_giamdinh);
			word.put("[co_quan_giam_dinh]", cq_giamdinh);
			word.put("[noi_dung]", form.getNoiDung());
			word.put("[ten_co_quan_yeu_giam_dinh]", ten_cq_giamdinh);
			word.put("[ten_co_quan_yeu_giam_dinh]", ten_cq_giamdinh);
			word.put("[truoc_ngay]", Formater.getDateForPrint(form.getNgayCcKq()));
			word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(app.getMaCqt()).toUpperCase());
			// --word.put("noi_lap", form.getNoiLap());
			// --word.put("ngay_lap",
			// Formater.getDateForPrint(form.getNgayLap()) );
			// word.put("[ten_thu_truong]", app.getTenThuTruong());

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

}
