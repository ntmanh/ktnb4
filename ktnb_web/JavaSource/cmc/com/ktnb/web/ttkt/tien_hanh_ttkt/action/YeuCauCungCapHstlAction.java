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

import com.jacob.com.Dispatch;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmNhanTraHstl;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThYcBsHstl;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.YeuCauCungCapHstlForm;

/**
 * Form bean for a Struts application.
 * 
 * @version 1.0
 * @author
 */
public class YeuCauCungCapHstlAction extends BaseDispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ApplicationContext app = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		YeuCauCungCapHstlForm hstlForm = (YeuCauCungCapHstlForm) form;
		String method = request.getParameter("method");
		if ("save".equals(method)) {
			saveYeuCau(request, reponse, hstlForm, app);
			return null;
		} else if ("in".equals(method)) {
			// TODO: Kiem tra xem cho nay co phai load lai lan nua khong
			String cuocTtktId = request.getParameter("idCuocTtkt");
			System.out.println("cuoc ttkt : "+cuocTtktId);
			inYcbsTl(request, reponse, hstlForm, app,cuocTtktId);
			return null;
		} else {
			String cuocTtktId = request.getParameter("idCuocTtkt");
			if (!Formater.isNull(cuocTtktId)) { // Nguoi dung click chon vao
				// link tai form main hoac mo
				// man hinh tao moi tu form tim
				// kiem
				if ("addnew".equals(method)) { // Tao moi tu man hinh tim kiem
					hstlForm.setDiaDiemBBGN(KtnbUtil.getTenTinhByMaCqt(app, CuocTtktService.getCuocTtkt(app, cuocTtktId).getIdDonViBi()));
					hstlForm.setDiaDiemBBGT(KtnbUtil.getTenTinhByMaCqt(app, CuocTtktService.getCuocTtkt(app, cuocTtktId).getIdDonViBi()));
					hstlForm.setDiaDiemCungCap(KtnbUtil.getTenTinhByMaCqt(app, CuocTtktService.getCuocTtkt(app, cuocTtktId).getIdDonViBi()));
					hstlForm.setDiaDiemNhanPhieuYc(KtnbUtil.getTenTinhByMaCqt(app, CuocTtktService.getCuocTtkt(app, cuocTtktId).getIdDonViBi()));
					addNew(request, app, hstlForm, cuocTtktId);					
				} else { // Click vao link tai form main
					Collection dsYeuCauBaoCaoHsTl = TtktCnPhuService.getDSYeuCauBaoCaoHsTl(app, cuocTtktId);
					if (Formater.isNull(dsYeuCauBaoCaoHsTl)) { // Truong doan
						// them moi
						hstlForm.setDiaDiemBBGN(KtnbUtil.getTenTinhByMaCqt(app, CuocTtktService.getCuocTtkt(app, cuocTtktId).getIdDonViBi()));
						hstlForm.setDiaDiemBBGT(KtnbUtil.getTenTinhByMaCqt(app, CuocTtktService.getCuocTtkt(app, cuocTtktId).getIdDonViBi()));
						hstlForm.setDiaDiemCungCap(KtnbUtil.getTenTinhByMaCqt(app, CuocTtktService.getCuocTtkt(app, cuocTtktId).getIdDonViBi()));
						hstlForm.setDiaDiemNhanPhieuYc(KtnbUtil.getTenTinhByMaCqt(app, CuocTtktService.getCuocTtkt(app, cuocTtktId).getIdDonViBi()));
						addNew(request, app, hstlForm, cuocTtktId);						
					} else {
						if (!KtnbUtil.isTruongDoan(app.getMaCanbo(), app, cuocTtktId) && dsYeuCauBaoCaoHsTl.size() == 1) { 
							// Thu truong co quan va co 1 banghi
							loadDataToForm(request, app, hstlForm, (TtktThYcBsHstl) ((ArrayList) dsYeuCauBaoCaoHsTl).get(0));
							request.setAttribute("readOnly", "true");
						}						
						request.getSession().setAttribute("dsYeuCauBaoCaoHsTl", dsYeuCauBaoCaoHsTl);
						reponse.sendRedirect("danh_sach_tim_kiem.do?idCuocTtkt=" + cuocTtktId + "&type=yeucaucungcapHSTL");
					}
				}

			} else {
				// Truong hop xem hoac sua thi truyen id vao url
				String id = request.getParameter("id");
				loadDataToForm(request, app, hstlForm, id);
				if (!KtnbUtil.haveRoleNv(app) || "view".equals(method) || app.getTrangThaiCuocTtkt(hstlForm.getIdCuocTtKtl()).equals(Constants.TT_TTKT_KT)) {
					request.setAttribute("readOnly", "true");
				}				
			}
			try {
				if(!Formater.isNull(cuocTtktId)){
					request.setAttribute("thoiDiemRaQD",Formater.objectDate2Str(TtktService.getCongBoQd(app, cuocTtktId).getThoiDiemCbTu()));
				}else{
					String id = request.getParameter("id");
					TtktThYcBsHstl phieuYc = TtktCnPhuService.getYcBsHsTl(app, id);
					request.setAttribute("thoiDiemRaQD",Formater.objectDate2Str(TtktService.getCongBoQd(app, phieuYc.getIdCuocTtkt()).getThoiDiemCbTu()));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return mapping.findForward("success");
	}

	/**
	 * @param request
	 * @param app
	 * @param hstlForm
	 * @param cuocTtktId
	 */
	private void addNew(HttpServletRequest request, ApplicationContext app, YeuCauCungCapHstlForm hstlForm, String cuocTtktId) throws Exception {
		hstlForm.setIdCuocTtKtl(cuocTtktId);
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, cuocTtktId);
		request.setAttribute("maCqtDuocTtkt",  CuocTtktService.getCuocTtktWithoutNoiDung(app, cuocTtktId).getIdDonViBi());
		TtktCbDsTvDoan dsTvDoan = TtktService.getDsTvd(cuocTtktId, app);
		Collection chiTietDsTvd = dsTvDoan.getChiTietDanhSachTV();
		hstlForm.setIdDsTvdPhieuYc(dsTvDoan.getId());
		request.setAttribute("dsTvdYeuCau", chiTietDsTvd);
		hstlForm.setIdDsTvdGiaoTra(dsTvDoan.getId());
		request.setAttribute("dsTvdGiaoTra", chiTietDsTvd);
		hstlForm.setIdDsTvdGiaoNhan(dsTvDoan.getId());
		request.setAttribute("dsTvdGiaoNhan", chiTietDsTvd);

	}

	/**
	 * @param request
	 * @param app
	 * @param hstlForm
	 * @param cuocTtktId
	 * @param hstl
	 */
	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, YeuCauCungCapHstlForm form, TtktThYcBsHstl phieuYc) throws Exception {
		form.setIdCuocTtKtl(phieuYc.getIdCuocTtkt());
		form.setIdCbYeuCau(phieuYc.getIdCbYeuCau());
		form.setIdNguoiNhanBc(phieuYc.getIdNguoiNhanBc());
		form.setLanYeuCau(phieuYc.getLanYeuCau().toString());
		form.setIdYeuCau(phieuYc.getId());
		form.setChucVuCbYeuCau(phieuYc.getChucVuNguoiYc());
		form.setTenCbYeuCau(phieuYc.getTenCanBoYeuCau());
		form.setNoiLapYeuCau(phieuYc.getNoiLapYeuCau());
		form.setNgayLapYeuCau(Formater.date2str(phieuYc.getNgayLapYeuCau()));
		form.setBaoCao(phieuYc.getBaoCao());
		form.setHoSo(phieuYc.getHoSo());
		form.setIdNgNhanPhieuYc(phieuYc.getIdNguoiNhanPhieuYc());
		form.setTenNgNhanPhieuYc(phieuYc.getTenNguoiNhanPhieuYc());
		form.setChucVuNgNhanPhieuYc(phieuYc.getChucVuNguoiNhanPhieuYc());
		form.setThoiDiemNhanPhieuYc(Formater.date2strDateTimeForNV(phieuYc.getThoiDiemNhanPhieuYc()));
		form.setDiaDiemNhanPhieuYc(phieuYc.getDiaDiemNhanPhieuYC());
		form.setThoiDiemCungCap(Formater.date2strDateTimeForNV(phieuYc.getThoiDiemCungCap()));
		form.setDiaDiemCungCap(phieuYc.getDiaDiemCungCap());
		form.setIdNguoiNhanBc(phieuYc.getIdNguoiNhanBc());
		form.setChucVuNgNhanBc(phieuYc.getChucVuNguoiNhanBc());
		form.setTenCbNhanBc(phieuYc.getTenCanBoNhanBc());
		form.setIdDsTvdPhieuYc(phieuYc.getIdDsTvd());
		request.setAttribute("dsTvdYeuCau", TtktService.getDsTvdById(app, phieuYc.getIdDsTvd()));
		TtktCbDsTvDoan cbDsTvDoan = null;

		// ----------- bien ban giao nhan ---------------------
		TtktCmNhanTraHstl bbGiaoNhan = phieuYc.getBbNhan();
		if (bbGiaoNhan != null) {
			form.setIdBanGiaoHoSoLuuTru(bbGiaoNhan.getId());
			form.setBaoCaoBanGianHoSoLuuTru(bbGiaoNhan.getBaoCao());
			form.setHoSoBanGianHoSoLuuTru(bbGiaoNhan.getHoSo());
			form.setIdDaiDienBenNhanBanGianHoSoLuuTru(bbGiaoNhan.getIdDaiDienBenNhan());
			form.setIdDaiDienBenGiaoBanGianHoSoLuuTru(bbGiaoNhan.getIdDaiDienBenGiao());
			form.setLoaiBanGianHoSoLuuTru(bbGiaoNhan.getLoai());
			form.setThoiDiemBatDauBanGianHoSoLuuTru(Formater.date2strDateTimeForNV(bbGiaoNhan.getThoiDiemBatDau()));
			form.setThoiDiemKTBBGN(Formater.date2strDateTimeForNV(bbGiaoNhan.getThoiDiemKetThuc()));
			form.setDiaDiemBBGN(bbGiaoNhan.getDiaDiemBanGiao());
			form.setIdDsTvdGiaoTra(bbGiaoNhan.getIdDsTvd());
			request.setAttribute("dsTvdGiaoTra", TtktService.getDsTvdById(app, bbGiaoNhan.getIdDsTvd()));
			// load dai dien ben giao bien ban giao nhan
			Collection dsTpTd = bbGiaoNhan.getDaiDienBenGiao();
			if (dsTpTd != null) {
				TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[dsTpTd.size()];
				Iterator iter = dsTpTd.iterator();
				int i = 0;
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();

					dsTpTdLoad[i] = tptd;
					i++;

				}
				form.setArrDaiDienBenGiaoHstlLuuTru(dsTpTdLoad);
			}

			// load dai dien ben nhan bien ban giao nhan
			Collection ddNhanBbGn = bbGiaoNhan.getDaiDienBenNhan();
			if (ddNhanBbGn != null) {
				TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[ddNhanBbGn.size()];
				Iterator iter = ddNhanBbGn.iterator();
				int i = 0;
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
					dsTpTdLoad[i] = tptd;
					i++;
				}
				form.setArrDaiDienBenNhanHstlLuuTru(dsTpTdLoad);
			}

		} else {
			cbDsTvDoan = TtktService.getDsTvd(phieuYc.getIdCuocTtkt(), app);
			form.setIdDsTvdGiaoTra(cbDsTvDoan.getId());
			request.setAttribute("dsTvdGiaoTra", cbDsTvDoan.getChiTietDanhSachTV());
		}

		// bien ban giao tra
		TtktCmNhanTraHstl bbGiaoTra = phieuYc.getBbGiao();
		if (bbGiaoTra != null) {
			form.setIdHoSoTra(bbGiaoTra.getId());
			form.setBaoCaoHoSoTra(bbGiaoTra.getBaoCao());
			form.setHoSoTra(bbGiaoTra.getHoSo());
			form.setLoaiHoSoLuuTru(bbGiaoTra.getLoai());
			form.setThoiDiemBatDauBanGiaoHoSo(Formater.date2strDateTimeForNV(bbGiaoTra.getThoiDiemBatDau()));
			form.setThoiDiemKTBBGT(Formater.date2strDateTimeForNV(bbGiaoTra.getThoiDiemKetThuc()));
			form.setIdDaiDienBenGiaoHoSo(bbGiaoTra.getIdDaiDienBenGiao());
			form.setIdDaiDienBenNhanHoSo(bbGiaoTra.getIdDaiDienBenNhan());
			form.setDiaDiemBBGT(bbGiaoTra.getDiaDiemBanGiao());
			TtktCbDsTvDoan dsTvDoan = TtktService.getDsTvdById(bbGiaoTra.getIdDsTvd(), app);
			form.setIdDsTvdGiaoNhan(dsTvDoan.getId());
			request.setAttribute("dsTvdGiaoNhan", dsTvDoan.getChiTietDanhSachTV());
			// load dai dien ben giao Bien ban giao tra
			Collection ddGiaoBbGt = bbGiaoTra.getDaiDienBenGiao();
			if (ddGiaoBbGt != null) {
				TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[ddGiaoBbGt.size()];
				Iterator iter = ddGiaoBbGt.iterator();
				int i = 0;
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();

					dsTpTdLoad[i] = tptd;
					i++;

				}
				form.setArrDaiDienBenGiaoHstl(dsTpTdLoad);
			}
			// load dai dien ben nhan bien ban giao nhan
			Collection ddNhanBbGn = bbGiaoTra.getDaiDienBenNhan();
			if (ddNhanBbGn != null) {
				TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[ddNhanBbGn.size()];
				Iterator iter = ddNhanBbGn.iterator();
				int i = 0;
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
					dsTpTdLoad[i] = tptd;
					i++;
				}
				form.setArrDaiDienBenNhanHstl(dsTpTdLoad);
			}
		} else {
			if (cbDsTvDoan == null)
				cbDsTvDoan = TtktService.getDsTvd(phieuYc.getIdCuocTtkt(), app);
			form.setIdDsTvdGiaoNhan(cbDsTvDoan.getId());
			request.setAttribute("dsTvdGiaoNhan", cbDsTvDoan.getChiTietDanhSachTV());
		}
		request.setAttribute("maCqtDuocTtkt", CuocTtktService.getCuocTtktWithoutNoiDung(app, phieuYc.getIdCuocTtkt()).getIdDonViBi());
		TtktCbDsTvDoan dsTvd = TtktService.getDsTvdById(phieuYc.getIdDsTvd(), app);
		request.setAttribute("dsTvd", dsTvd.getChiTietDanhSachTV());

	}

	/**
	 * @param request
	 * @param app
	 * @param hstlForm
	 * @param cuocTtktId
	 * @param id
	 */
	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, YeuCauCungCapHstlForm form, String id) throws Exception {
		TtktThYcBsHstl phieuYc = TtktCnPhuService.getYcBsHsTl(app, id);
		loadDataToForm(request, app, form, phieuYc);
	}

	private void inYcbsTl_old(HttpServletRequest request, HttpServletResponse reponse, YeuCauCungCapHstlForm hstlForm, ApplicationContext appConText, String idCuocTtkt) throws Exception {
		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		// neu full mau in thi dat KtnbUtil.inFieldNull(118)
		String printDefaultNull = KtnbUtil.inFieldNull(100)+"\n       "+KtnbUtil.inFieldNull(100);
		if (type.equals("phieuYeuCau")) { // phieu yeu cau cung cap ho so tai
			// lieu
			fileTemplate = "ttnb17"; // (ngon, chuan)
			// Loc sua lai sau
			//String idCuocTtkt = hstlForm.getIdCuocTtKtl();
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
			parameters.put("noi_lap", hstlForm.getDiaDiemNhanPhieuYc());
			
			//String ngaynhanphieuyc = hstlForm.getThoiDiemNhanPhieuYc();
			//String[] arrNgaynhanyc = ngaynhanphieuyc.split("/");
			//
			parameters.put("ngay_lap_phieu", KtnbUtil.getDay(hstlForm.getThoiDiemNhanPhieuYc()));// xai ham ktnbUtil.getday() van bi loi
			//parameters.put("ngay_lap_phieu", "ng\u00E0y " + arrNgaynhanyc[0] + " th\u00E1ng " + arrNgaynhanyc[1] + " n\u0103m " + arrNgaynhanyc[2]);
			//
			// parameters.put("ngay_lap_phieu",
			// KtnbUtil.getDay(hstlForm.getNgayLapYeuCau()));
			parameters.put("lan_thu", hstlForm.getLanYeuCau());
			parameters.put("dv_dc_ttkt", cuocTtkt.getTenDonViBi());
			parameters.put("so_quyet_dinh", cbQd.getSoQuyetDinh());
			String ngayqd = Formater.date2str(cbQd.getNgayRaQuyetDnh());
			String[] arrngayqd = ngayqd.split("/");
			parameters.put("ngay_quyet", "ng\u00E0y " + arrngayqd[0] + " th\u00E1ng " + arrngayqd[1] + " n\u0103m " + arrngayqd[2]);
			parameters.put("chuc_danh_thu_truong", KtnbUtil.getTenThuTruongCqt(appConText));
			parameters.put("ten_truong_doan", cuocTtkt.getTenTruongDoan());
			parameters.put("ten_nguoi_nhan_phieu", hstlForm.getTenNgNhanPhieuYc());
			if(Formater.isNull(hstlForm.getBaoCao())){
				parameters.put("bao_cao", printDefaultNull);
			}else{
				parameters.put("bao_cao", hstlForm.getBaoCao());
			}
			if(Formater.isNull(hstlForm.getHoSo())){
				parameters.put("ho_so", printDefaultNull);
			}else{
				parameters.put("ho_so", hstlForm.getHoSo());
			}
			//
			parameters.put("thoi_gian_cung_cap", Formater.getDateTimeForPrint(hstlForm.getThoiDiemCungCap()));
			// danh sach thanh vien doan
			// parameters.put("thoi_gian_cung_cap", "ng\u00E0y " +
			// arrtimecungcap[0] + " th\u00E1ng " + arrtimecungcap[1] + "
			// n\u0103m " + arrtimecungcap[2]);
			parameters.put("dia_diem", hstlForm.getDiaDiemCungCap());
			parameters.put("nguoi_nhan", hstlForm.getTenCbNhanBc());
			parameters.put("chuc_vu", hstlForm.getChucVuNgNhanBc());
			parameters.put("nguoi_nhan_phieu", hstlForm.getTenNgNhanPhieuYc());
			parameters.put("chuc_vu_ng_nhan_phieu", hstlForm.getChucVuNgNhanPhieuYc());
			//
			parameters.put("thoi_gian_nhan", Formater.getDateTimeForPrint(hstlForm.getThoiDiemNhanPhieuYc()));
			//
		} else if (type.equals("bbGiaoNhan")) {
			fileTemplate = "ttnb18"; // (ngon, chuan)
			//String idCuocTtkt = hstlForm.getIdCuocTtKtl();
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
			parameters.put("dia_diem", hstlForm.getDiaDiemBBGN());
			if(Formater.isNull(hstlForm.getBaoCaoBanGianHoSoLuuTru())){
				parameters.put("bao_cao", printDefaultNull);
			}else{
				parameters.put("bao_cao", hstlForm.getBaoCaoBanGianHoSoLuuTru());
			}
			if(Formater.isNull(hstlForm.getHoSoBanGianHoSoLuuTru())){
				parameters.put("ho_so_tai_lieu", printDefaultNull);
			}else{
				parameters.put("ho_so_tai_lieu", hstlForm.getHoSoBanGianHoSoLuuTru());
			}
			parameters.put("so_quyet_dinh", cbQd.getSoQuyetDinh());
			parameters.put("chuc_danh_thu_truong", KtnbUtil.getTenThuTruongCqt(appConText));
			parameters.put("thoi_diem_bat_dau", KtnbUtil.getHour(hstlForm.getThoiDiemBatDauBanGianHoSoLuuTru()));
			parameters.put("ten_truong_doan", cuocTtkt.getTenTruongDoan());
			parameters.put("ngay_quyet", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			parameters.put("thoi_diem_giao_nhan", KtnbUtil.getHour(hstlForm.getThoiDiemKTBBGN()));
			// dai dien ben giao
			TtktCmThanhPhanThamDu[] arrthanhphanbg = hstlForm.getArrDaiDienBenNhanHstlLuuTru();
			StringBuffer tptd = new StringBuffer("");
			if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
				for (int i = 0; i < arrthanhphanbg.length; i++) {
					tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg[i].getHoTen()));
					tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg[i].getChucVu()));
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				parameters.put("thanh_vien_ben_giao", tptd.toString().substring(0, tptd.toString().length()-1));
			}

			// dai dien ben nhan
			TtktCmThanhPhanThamDu[] arrthanhphanbn = hstlForm.getArrDaiDienBenGiaoHstlLuuTru();
			StringBuffer bn = new StringBuffer("");
			if (arrthanhphanbn != null && arrthanhphanbn.length > 0) {
				for (int i = 0; i < arrthanhphanbn.length; i++) {
					bn.append(KtnbUtil.layoutTableHoTen(arrthanhphanbn[i].getHoTen()));
					bn.append(KtnbUtil.layoutTableChucVu(arrthanhphanbn[i].getChucVu()));
					bn.append("\n");
				}
				System.out.println("ben nhan : "+bn.toString());
				parameters.put("thanh_vien_ben_nhan", bn.toString().substring(0, bn.toString().length()-1));
			}

		} else {
			fileTemplate = "ttnb19"; // (ngon, chuan)
			// Loc sua lai sau
			//String idCuocTtkt = hstlForm.getIdCuocTtKtl();
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
			parameters.put("dia_diem", hstlForm.getDiaDiemBBGT());
			if(Formater.isNull(hstlForm.getBaoCaoBanGianHoSoLuuTru())){
				parameters.put("bao_cao", printDefaultNull);
			}else{
				parameters.put("bao_cao", hstlForm.getBaoCaoBanGianHoSoLuuTru());
			}
			if(Formater.isNull(hstlForm.getHoSoBanGianHoSoLuuTru())){
				parameters.put("ho_so_tai_lieu", printDefaultNull);
			}else{
				parameters.put("ho_so_tai_lieu", hstlForm.getHoSoBanGianHoSoLuuTru());
			}
			parameters.put("so_quyet_dinh", cbQd.getSoQuyetDinh());
			parameters.put("chuc_danh_thu_truong", KtnbUtil.getTenThuTruongCqt(appConText));
			parameters.put("thoi_diem_bat_dau", KtnbUtil.getHour(hstlForm.getThoiDiemBatDauBanGiaoHoSo()));
			parameters.put("ten_truong_doan", cuocTtkt.getTenTruongDoan());
			parameters.put("ngay_quyet", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			// dai dien ben giao

			parameters.put("thoi_diem_giao_nhan", KtnbUtil.getHour(hstlForm.getThoiDiemKTBBGT()));
			//
			TtktCmThanhPhanThamDu[] arrthanhphanbg = hstlForm.getArrDaiDienBenGiaoHstl();
			StringBuffer tptd = new StringBuffer("");
			if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
				for (int i = 0; i < arrthanhphanbg.length; i++) {
					tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg[i].getHoTen()));
					tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg[i].getChucVu()));
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				parameters.put("thanh_vien_ben_giao", tptd.toString().substring(0, tptd.toString().length()-1));
			}
			// dai dien ben nhan
			TtktCmThanhPhanThamDu[] arrthanhphanbn = hstlForm.getArrDaiDienBenNhanHstl();
			StringBuffer bn = new StringBuffer("");
			if (arrthanhphanbn != null && arrthanhphanbn.length > 0) {
				for (int i = 0; i < arrthanhphanbn.length; i++) {
					bn.append(KtnbUtil.layoutTableHoTen(arrthanhphanbn[i].getHoTen()));
					bn.append(KtnbUtil.layoutTableChucVu(arrthanhphanbn[i].getChucVu()));
					bn.append("\n");
				}
				System.out.println(bn.toString());
				parameters.put("thanh_vien_ben_nhan", bn.toString().substring(0, bn.toString().length()-1));
			}
			//

		}
		if (Formater.isNull(fileTemplate))
			throw new Exception("Chua chon file template");

		InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
		KtnbUtil.printf(reportRows, fileTemplate, reponse, inputStream, parameters, null);

	}
	
	/**
	 * Download file mau TTNB17,TTNB18,TTNB19
	 * 
	 * @throws Exception
	*/
	private void inYcbsTl(HttpServletRequest request, HttpServletResponse reponse, YeuCauCungCapHstlForm hstlForm, ApplicationContext appConText, String idCuocTtkt) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;
		String defaulNull = "- \u00D4ng (b\u00E0):..........................................- Ch\u1EE9c v\u1EE5:.............................\n"+KtnbUtil.inFieldNull(105);
		
		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		// neu full mau in thi dat KtnbUtil.inFieldNull(118)
		String printDefaultNull = KtnbUtil.inFieldNull(100)+"\n"+KtnbUtil.inFieldNull(100);
		if (type.equals("phieuYeuCau")) { // phieu yeu cau cung cap ho so tai lieu
			fileIn = request.getRealPath("/docin") + "\\TTNB17.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB17_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			
			fileTemplate = "ttnb17"; // (ngon, chuan)
			// Loc sua lai sau
			//String idCuocTtkt = hstlForm.getIdCuocTtKtl();
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
				word.put("[lan_thu]", hstlForm.getLanYeuCau());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", sb.toString());
				word.put("[so_quyet_dinh]", cbQd.getSoQuyetDinh());
				String ngayqd = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				String[] arrngayqd = ngayqd.split("/");
				word.put("[ngay_quyet]", "ng\u00E0y " + arrngayqd[0] + " th\u00E1ng " + arrngayqd[1] + " n\u0103m " + arrngayqd[2]);
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", sb.toString());
				if(Formater.isNull(hstlForm.getBaoCao())){
					word.put("[bao_cao]", printDefaultNull);
				}else{
					word.put("[bao_cao]", hstlForm.getBaoCao());
				}
				if(Formater.isNull(hstlForm.getHoSo())){
					word.put("[ho_so]", printDefaultNull);
				}else{
					word.put("[ho_so]", hstlForm.getHoSo());
				}
				//
				word.put("[thoi_gian_cung_cap]", Formater.getDateTimeForPrint(hstlForm.getThoiDiemCungCap()));
				word.put("[dia_diem]", hstlForm.getDiaDiemCungCap());
				word.put("[nguoi_nhan]", hstlForm.getTenCbNhanBc());
				word.put("[chuc_vu]", hstlForm.getChucVuNgNhanBc());
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[nguoi_nhan_phieu]", hstlForm.getTenNgNhanPhieuYc());
				word.put("[chuc_vu_ng_nhan_phieu]", hstlForm.getChucVuNgNhanPhieuYc());
				//
				word.put("[thoi_gian_nhan]", Formater.getDateTimeForPrint(hstlForm.getThoiDiemNhanPhieuYc()));
				//
				if(Formater.isNull(hstlForm.getDiaDiemNhanPhieuYc()))
					word.put("[noi_lap]",".......");
				else
					word.put("[noi_lap]", hstlForm.getDiaDiemNhanPhieuYc());
				//String ngaynhanphieuyc = hstlForm.getThoiDiemNhanPhieuYc();
				//String[] arrNgaynhanyc = ngaynhanphieuyc.split("/");
				word.put("[ngay_lap_phieu]", KtnbUtil.getDay(hstlForm.getThoiDiemNhanPhieuYc()));// xai ham ktnbUtil.getday() van bi loi
				//parameters.put("ngay_lap_phieu", "ng\u00E0y " + arrNgaynhanyc[0] + " th\u00E1ng " + arrNgaynhanyc[1] + " n\u0103m " + arrNgaynhanyc[2]);
				// parameters.put("ngay_lap_phieu",KtnbUtil.getDay(hstlForm.getNgayLapYeuCau()));
				if(Formater.isNull(hstlForm.getDiaDiemNhanPhieuYc()))
					word.put("[noi_lap]",".......");
				else
					word.put("[noi_lap]", hstlForm.getDiaDiemNhanPhieuYc());
				word.put("[ngay_lap_phieu]", KtnbUtil.getDay(hstlForm.getThoiDiemNhanPhieuYc()));// xai ham ktnbUtil.getday() van bi loi
				word.put("[ttkt]", sb.toString().toUpperCase());
				word.put("[ten_nguoi_nhan_phieu]", hstlForm.getTenNgNhanPhieuYc());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				// danh sach thanh vien doan
				// parameters.put("thoi_gian_cung_cap", "ng\u00E0y " +
				// arrtimecungcap[0] + " th\u00E1ng " + arrtimecungcap[1] + "
				// n\u0103m " + arrtimecungcap[2]);
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB17", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}
			finally {				
				try { 
					word.saveAndClose();
				} catch (Exception e) {
					
				}
			}
		} else if (type.equals("bbGiaoNhan")) {
			fileIn = request.getRealPath("/docin") + "\\TTNB18.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB18_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			
			fileTemplate = "ttnb18"; // (ngon, chuan)
			//String idCuocTtkt = hstlForm.getIdCuocTtKtl();
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
				word.put("[thoi_diem_bat_dau]", KtnbUtil.getHour(hstlForm.getThoiDiemBatDauBanGianHoSoLuuTru()));
				word.put("[dia_diem]", hstlForm.getDiaDiemBBGN());
				word.put("[ttkt]", sb.toString());
				word.put("[so_quyet_dinh]", cbQd.getSoQuyetDinh());
				word.put("[ngay_quyet]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//dai dien ben giao
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrthanhphanbg = hstlForm.getArrDaiDienBenNhanHstlLuuTru();
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
					//word.put("[thanh_vien_ben_giao]", tptd.toString().substring(0, tptd.toString().length()-1));
				}
				//else{
					//word.put("[thanh_vien_ben_giao]", KtnbUtil.inFieldNull(106));
					//word.put("[thanh_vien_ben_giao]", defaulNull);
				//}

				// dai dien ben nhan
				table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arrthanhphanbn = hstlForm.getArrDaiDienBenGiaoHstlLuuTru();
				StringBuffer bn = new StringBuffer("");
				if (arrthanhphanbn != null && arrthanhphanbn.length > 0) {
					for (int i = 0; i < arrthanhphanbn.length; i++) {
						bn.append(KtnbUtil.layoutTableHoTen(arrthanhphanbn[i].getHoTen()));
						bn.append(KtnbUtil.layoutTableChucVu(arrthanhphanbn[i].getChucVu()));
						bn.append("\n");
						word.addCellTable(table, i+1, 1, "- \u00D4ng (b\u00E0): " + arrthanhphanbn[i].getHoTen());
						word.addCellTable(table, i+1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbn[i].getChucVu());
						word.addRowTable(table,arrthanhphanbn.length);
					}
					System.out.println("ben nhan : "+bn.toString());
					//word.put("[thanh_vien_ben_nhan]", bn.toString().substring(0, bn.toString().length()-1));
				}
				//else{
				//	word.put("[thanh_vien_ben_nhan]", defaulNull);
					//word.put("[thanh_vien_ben_nhan]", KtnbUtil.inFieldNull(106));
				//}
				word.put("[ttkt]", sb.toString());
				if(Formater.isNull(hstlForm.getBaoCaoBanGianHoSoLuuTru())){
					word.put("[bao_cao]", printDefaultNull);
				}else{
					word.put("[bao_cao]", hstlForm.getBaoCaoBanGianHoSoLuuTru());
				}
				if(Formater.isNull(hstlForm.getHoSoBanGianHoSoLuuTru())){
					word.put("[ho_so_tai_lieu]", printDefaultNull);
				}else{
					word.put("[ho_so_tai_lieu]", hstlForm.getHoSoBanGianHoSoLuuTru());
				}
				word.put("[thoi_diem_giao_nhan]", KtnbUtil.getHour(hstlForm.getThoiDiemKTBBGN()));
				//word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.put("[nguoi_giao]", arrthanhphanbg[0].getHoTen());
				word.put("[nguoi_nhan]", arrthanhphanbn[0].getHoTen());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB18", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}
			
		} else {
			fileIn = request.getRealPath("/docin") + "\\TTNB19.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB 19_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			
			fileTemplate = "ttnb19"; // (ngon, chuan)
			// Loc sua lai sau
			//String idCuocTtkt = hstlForm.getIdCuocTtKtl();
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
				word.put("[thoi_diem_bat_dau]", KtnbUtil.getHour(hstlForm.getThoiDiemBatDauBanGiaoHoSo()));
				word.put("[dia_diem]", hstlForm.getDiaDiemBBGT());
				word.put("[ttkt]", sb.toString());
				word.put("[so_quyet_dinh]", cbQd.getSoQuyetDinh());
				word.put("[ngay_quyet]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//dai dien ben giao
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrthanhphanbg = hstlForm.getArrDaiDienBenGiaoHstl();
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
					//word.put("[thanh_vien_ben_giao]", tptd.toString().substring(0, tptd.toString().length()-1));
				}
				//else{
					//word.put("[thanh_vien_ben_giao]", defaulNull);
					//word.put("[thanh_vien_ben_giao]", KtnbUtil.inFieldNull(106));
				//}
				// dai dien ben nhan
				table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arrthanhphanbn = hstlForm.getArrDaiDienBenNhanHstl();
				StringBuffer bn = new StringBuffer("");
				if (arrthanhphanbn != null && arrthanhphanbn.length > 0) {
					for (int i = 0; i < arrthanhphanbn.length; i++) {
						bn.append(KtnbUtil.layoutTableHoTen(arrthanhphanbn[i].getHoTen()));
						bn.append(KtnbUtil.layoutTableChucVu(arrthanhphanbn[i].getChucVu()));
						bn.append("\n");
						word.addCellTable(table, i+1, 1, "- \u00D4ng (b\u00E0): " + arrthanhphanbn[i].getHoTen());
						word.addCellTable(table, i+1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbn[i].getChucVu());
						word.addRowTable(table,arrthanhphanbn.length);
					}
					System.out.println(bn.toString());
					//word.put("[thanh_vien_ben_nhan]", bn.toString().substring(0, bn.toString().length()-1));
				}
				//else{
					//word.put("[thanh_vien_ben_nhan]", defaulNull);
					//word.put("[thanh_vien_ben_nhan]", KtnbUtil.inFieldNull(106));
				//}
				//
				word.put("[ttkt]", sb.toString());
				if(Formater.isNull(hstlForm.getBaoCaoHoSoTra())){
					word.put("[bao_cao]", printDefaultNull);
				}else{
					word.put("[bao_cao]", hstlForm.getBaoCaoHoSoTra());
				}
				if(Formater.isNull(hstlForm.getHoSoTra())){
					word.put("[ho_so_tai_lieu]", printDefaultNull);
				}else{
					word.put("[ho_so_tai_lieu]", hstlForm.getHoSoTra());
				}
				word.put("[thoi_diem_giao_nhan]", KtnbUtil.getHour(hstlForm.getThoiDiemKTBBGT()));
				word.put("[ben_nhan]",  arrthanhphanbn[0].getHoTen());
				word.put("[ben_tra]",arrthanhphanbg[0].getHoTen());
				//word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB19", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}
		}
	}

	private void loadDataToForm(String cuocTtktId, ApplicationContext app, YeuCauCungCapHstlForm form, String id) throws Exception {

		TtktThYcBsHstl phieuYc = TtktCnPhuService.getYcBsHsTl(app, id);

		if (phieuYc != null) {

			// ----------- phieu yeu cau ---------------------
			form.setLanYeuCau(phieuYc.getLanYeuCau().toString());
			form.setIdYeuCau(phieuYc.getId());
			form.setChucVuCbYeuCau(phieuYc.getChucVuNguoiYc());
			form.setTenCbYeuCau(phieuYc.getTenCanBoYeuCau());
			form.setNoiLapYeuCau(phieuYc.getNoiLapYeuCau());
			form.setNgayLapYeuCau(Formater.date2str(phieuYc.getNgayLapYeuCau()));
			form.setBaoCao(phieuYc.getBaoCao());
			form.setHoSo(phieuYc.getHoSo());
			form.setIdNgNhanPhieuYc(phieuYc.getIdNguoiNhanPhieuYc());
			form.setTenNgNhanPhieuYc(phieuYc.getTenNguoiNhanPhieuYc());
			form.setChucVuNgNhanPhieuYc(phieuYc.getChucVuNguoiNhanPhieuYc());
			form.setThoiDiemNhanPhieuYc(Formater.date2strDateTimeForNV(phieuYc.getThoiDiemNhanPhieuYc()));
			form.setDiaDiemNhanPhieuYc(phieuYc.getDiaDiemNhanPhieuYC());
			form.setThoiDiemCungCap(Formater.date2strDateTimeForNV(phieuYc.getThoiDiemCungCap()));
			form.setDiaDiemCungCap(phieuYc.getDiaDiemCungCap());
			form.setIdNguoiNhanBc(phieuYc.getIdNguoiNhanBc());
			form.setChucVuNgNhanBc(phieuYc.getChucVuNguoiNhanBc());
			form.setTenCbNhanBc(phieuYc.getTenCanBoNhanBc());
			// ----------- bien ban giao nhan ---------------------
			TtktCmNhanTraHstl bbGiaoNhan = phieuYc.getBbNhan();
			if (bbGiaoNhan != null) {
				form.setIdBanGiaoHoSoLuuTru(bbGiaoNhan.getId());
				form.setBaoCaoBanGianHoSoLuuTru(bbGiaoNhan.getBaoCao());
				form.setHoSoBanGianHoSoLuuTru(bbGiaoNhan.getHoSo());
				form.setIdDaiDienBenNhanBanGianHoSoLuuTru(bbGiaoNhan.getIdDaiDienBenNhan());
				form.setIdDaiDienBenGiaoBanGianHoSoLuuTru(bbGiaoNhan.getIdDaiDienBenGiao());
				form.setLoaiBanGianHoSoLuuTru(bbGiaoNhan.getLoai());
				form.setThoiDiemBatDauBanGianHoSoLuuTru(Formater.date2strDateTimeForNV(bbGiaoNhan.getThoiDiemBatDau()));
				form.setThoiDiemKTBBGN(Formater.date2strDateTimeForNV(bbGiaoNhan.getThoiDiemKetThuc()));
				form.setDiaDiemBBGN(bbGiaoNhan.getDiaDiemBanGiao());
				// load dai dien ben giao bien ban giao nhan
				Collection dsTpTd = bbGiaoNhan.getDaiDienBenGiao();
				if (dsTpTd != null) {
					TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[dsTpTd.size()];
					Iterator iter = dsTpTd.iterator();
					int i = 0;
					while (iter.hasNext()) {
						TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();

						dsTpTdLoad[i] = tptd;
						i++;

					}
					form.setArrDaiDienBenGiaoHstlLuuTru(dsTpTdLoad);
				}

				// load dai dien ben nhan bien ban giao nhan
				Collection ddNhanBbGn = bbGiaoNhan.getDaiDienBenNhan();
				if (ddNhanBbGn != null) {
					TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[ddNhanBbGn.size()];
					Iterator iter = ddNhanBbGn.iterator();
					int i = 0;
					while (iter.hasNext()) {
						TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
						dsTpTdLoad[i] = tptd;
						i++;
					}
					form.setArrDaiDienBenNhanHstlLuuTru(dsTpTdLoad);
				}
			}

			// bien ban giao tra
			TtktCmNhanTraHstl bbGiaoTra = phieuYc.getBbGiao();
			if (bbGiaoTra != null) {
				form.setIdHoSoTra(bbGiaoTra.getId());
				form.setBaoCaoHoSoTra(bbGiaoTra.getBaoCao());
				form.setHoSoTra(bbGiaoTra.getHoSo());
				form.setLoaiHoSoLuuTru(bbGiaoTra.getLoai());
				form.setThoiDiemBatDauBanGiaoHoSo(Formater.date2strDateTimeForNV(bbGiaoTra.getThoiDiemBatDau()));
				form.setThoiDiemKTBBGT(Formater.date2strDateTimeForNV(bbGiaoTra.getThoiDiemKetThuc()));
				form.setIdDaiDienBenGiaoHoSo(bbGiaoTra.getIdDaiDienBenGiao());
				form.setIdDaiDienBenNhanHoSo(bbGiaoTra.getIdDaiDienBenNhan());
				form.setDiaDiemBBGT(bbGiaoTra.getDiaDiemBanGiao());
				// load dai dien ben giao Bien ban giao tra
				Collection ddGiaoBbGt = bbGiaoTra.getDaiDienBenGiao();
				if (ddGiaoBbGt != null) {
					TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[ddGiaoBbGt.size()];
					Iterator iter = ddGiaoBbGt.iterator();
					int i = 0;
					while (iter.hasNext()) {
						TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();

						dsTpTdLoad[i] = tptd;
						i++;

					}
					form.setArrDaiDienBenGiaoHstl(dsTpTdLoad);
				}
				// load dai dien ben nhan bien ban giao nhan
				Collection ddNhanBbGn = bbGiaoTra.getDaiDienBenNhan();
				if (ddNhanBbGn != null) {
					TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[ddNhanBbGn.size()];
					Iterator iter = ddNhanBbGn.iterator();
					int i = 0;
					while (iter.hasNext()) {
						TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
						dsTpTdLoad[i] = tptd;
						i++;
					}
					form.setArrDaiDienBenNhanHstl(dsTpTdLoad);
				}
			}
		} else {
			form.setNgayLapYeuCau(Formater.date2str(new Date()));
			form.setThoiDiemNhanPhieuYc(Formater.date2strDateTimeForNV(new Date()));
			form.setThoiDiemCungCap(Formater.date2strDateTimeForNV(new Date()));
			form.setThoiDiemBatDauBanGianHoSoLuuTru(Formater.date2strDateTimeForNV(new Date()));
			form.setThoiDiemBatDauBanGiaoHoSo(Formater.date2strDateTimeForNV(new Date()));
			form.setThoiDiemKTBBGN(Formater.date2strDateTimeForNV(new Date()));
			form.setThoiDiemKTBBGT(Formater.date2strDateTimeForNV(new Date()));
		}

	}

	private void saveYeuCau(HttpServletRequest request, HttpServletResponse response, YeuCauCungCapHstlForm form, ApplicationContext app) throws Exception {
		String type = request.getParameter("type");
		if (type.equals("phieuyeucau")) {

			PrintWriter out = response.getWriter();
			out.print("returnId:" + savePhieuYeuCau(request, response, form, app));
			out.flush();
			out.close();
		} else if (type.equals("bbgiaonhan")) {
			saveBbGiaoNhan(request, response, form, app);
		} else if (type.equals("bbgiaotra")) {
			saveBbGiaoTra(request, response, form, app);
		}
		if (!type.equals("phieuyeucau")) {
			PrintWriter out = response.getWriter();
			out.print("cucsess");
			out.flush();
			out.close();
		}

	}

	/**
	 * @param request
	 * @param response
	 * @param form
	 * @param app
	 */
	private void saveBbGiaoTra(HttpServletRequest request, HttpServletResponse response, YeuCauCungCapHstlForm form, ApplicationContext app) throws Exception {

		TtktCmNhanTraHstl bbGiaotra = createBBGiaoTra(form, app, request);
		TtktCnPhuService.saveBbNhanTraHsTl(app, bbGiaotra);

	}

	/**
	 * @param request
	 * @param response
	 * @param form
	 * @param app
	 */
	private void saveBbGiaoNhan(HttpServletRequest request, HttpServletResponse response, YeuCauCungCapHstlForm form, ApplicationContext app) throws Exception {
		TtktCmNhanTraHstl bbGiaotra = createBBGiaoNhan(form, app, request);
		TtktCnPhuService.saveBbNhanTraHsTl(app, bbGiaotra);

	}

	/**
	 * @param request
	 * @param response
	 * @param form
	 * @param app
	 */
	private String savePhieuYeuCau(HttpServletRequest request, HttpServletResponse response, YeuCauCungCapHstlForm form, ApplicationContext app) throws Exception {

		TtktThYcBsHstl phieuYc = createPhieuYc(form,app);
		phieuYc = TtktCnPhuService.saveYeuCauBsTl(phieuYc, request, app);
		return phieuYc.getId();

	}

	/**
	 * @return
	 */
	private TtktThYcBsHstl createPhieuYc(YeuCauCungCapHstlForm form, ApplicationContext app ) throws Exception {
		TtktThYcBsHstl phieuYc = new TtktThYcBsHstl();

		phieuYc.setLanYeuCau(Byte.valueOf(form.getLanYeuCau()));
		phieuYc.setIdCuocTtkt(form.getIdCuocTtKtl());
		phieuYc.setId(form.getIdYeuCau());
		phieuYc.setIdCbYeuCau(form.getIdCbYeuCau());
		phieuYc.setTenCanBoYeuCau(form.getTenCbYeuCau());
		phieuYc.setChucVuNguoiYc(form.getChucVuCbYeuCau());
		phieuYc.setNoiLapYeuCau(form.getNoiLapYeuCau());
		phieuYc.setNgayLapYeuCau(Formater.str2date(form.getNgayLapYeuCau()));
		phieuYc.setHoSo(form.getHoSo());
		phieuYc.setBaoCao(form.getBaoCao());
		phieuYc.setDiaDiemNhanPhieuYC(form.getDiaDiemNhanPhieuYc());
		phieuYc.setIdNguoiNhanPhieuYc(form.getIdNgNhanPhieuYc());
		phieuYc.setTenNguoiNhanPhieuYc(form.getTenNgNhanPhieuYc());
		phieuYc.setChucVuNguoiNhanPhieuYc(form.getChucVuNgNhanPhieuYc());
		phieuYc.setThoiDiemNhanPhieuYc(Formater.str2dateForNV(form.getThoiDiemNhanPhieuYc()));

		phieuYc.setThoiDiemCungCap(Formater.str2dateForNV(form.getThoiDiemCungCap()));
		phieuYc.setDiaDiemCungCap(form.getDiaDiemCungCap());
		phieuYc.setIdNguoiNhanBc(form.getIdNguoiNhanBc());
		phieuYc.setTenCanBoNhanBc(form.getTenCbNhanBc());
		phieuYc.setChucVuNguoiNhanBc(form.getChucVuNgNhanBc());
		phieuYc.setIdDsTvd(form.getIdDsTvdPhieuYc());
		phieuYc.setIdNguoiCapNat(app.getMaCanbo());
		phieuYc.setTenNguoiCapNhat(app.getTenCanbo());
		phieuYc.setNgayCapNhat(new Date());
		
		
		
		return phieuYc;

	}

	private TtktCmNhanTraHstl createBBGiaoNhan(YeuCauCungCapHstlForm form, ApplicationContext app, HttpServletRequest request) throws Exception {
		TtktCmNhanTraHstl bbGiaoNhan = new TtktCmNhanTraHstl();
		bbGiaoNhan.setLoai(Constants.TT_TTKT_BBGIAONHAN_YCBSTL);
		bbGiaoNhan.setId(form.getIdBanGiaoHoSoLuuTru());
		bbGiaoNhan.setHoSo(form.getHoSoBanGianHoSoLuuTru());
		bbGiaoNhan.setBaoCao(form.getBaoCaoBanGianHoSoLuuTru());
		bbGiaoNhan.setIdTdYcBsHstl(form.getIdYeuCau());
		bbGiaoNhan.setIdCuocTtkt(form.getIdCuocTtKtl());
		bbGiaoNhan.setIdDaiDienBenGiao(form.getIdDaiDienBenGiaoBanGianHoSoLuuTru());
		bbGiaoNhan.setIdDaiDienBenNhan(form.getIdDaiDienBenNhanBanGianHoSoLuuTru());
		bbGiaoNhan.setThoiDiemBatDau(Formater.str2dateForNV(form.getThoiDiemBatDauBanGianHoSoLuuTru()));
		bbGiaoNhan.setThoiDiemKetThuc(Formater.str2dateForNV(form.getThoiDiemKTBBGN()));
		// bbGiaoNhan.setLoai(form.getLoaiBanGianHoSoLuuTru());
		bbGiaoNhan.setDiaDiemBanGiao(form.getDiaDiemBBGN());
		bbGiaoNhan.setIdDsTvd(form.getIdDsTvdGiaoNhan());
		// ------------- Dai dien ben nhan bien ban giao nhan
		// -------------------------
		String idDaiDienNhanBBGN = form.getIdDaiDienBenNhanBanGianHoSoLuuTru();
		Collection arr1 = new ArrayList();
		if (form.getArrDaiDienBenNhanHstlLuuTru() != null) {
			for (int i = 0; i < form.getArrDaiDienBenNhanHstlLuuTru().length; i++) {
				TtktCmThanhPhanThamDu tptd = new TtktCmThanhPhanThamDu();
				tptd.setChucVu(form.getArrDaiDienBenNhanHstlLuuTru()[i].getChucVu());
				tptd.setHoTen(form.getArrDaiDienBenNhanHstlLuuTru()[i].getHoTen());
				tptd.setIdMaster(idDaiDienNhanBBGN);
				tptd.setIdCanBo(form.getArrDaiDienBenNhanHstlLuuTru()[i].getIdCanBo());
				tptd.setIdNguoiCapNat(app.getMaCanbo());
				tptd.setTenNguoiCapNhat(app.getTenCanbo());
				tptd.setNgayCapNhat(new Date());
				
				arr1.add(tptd);
			}
			bbGiaoNhan.setIdDaiDienBenNhan(idDaiDienNhanBBGN);
			bbGiaoNhan.setDaiDienBenNhan(arr1);
		}

		// --------------- Dai dien ben giao bien ban gao nhan
		// --------------------------
		String idDaiDienGiaoBBGn = form.getIdDaiDienBenGiaoBanGianHoSoLuuTru();
		Collection arr2 = new ArrayList();
		if (form.getArrDaiDienBenGiaoHstlLuuTru() != null) {
			for (int i = 0; i < form.getArrDaiDienBenGiaoHstlLuuTru().length; i++) {
				TtktCmThanhPhanThamDu cacOb = new TtktCmThanhPhanThamDu();
				cacOb.setChucVu(form.getArrDaiDienBenGiaoHstlLuuTru()[i].getChucVu());
				cacOb.setHoTen(form.getArrDaiDienBenGiaoHstlLuuTru()[i].getHoTen());
				cacOb.setIdMaster(idDaiDienGiaoBBGn);
				cacOb.setIdCanBo(form.getArrDaiDienBenGiaoHstlLuuTru()[i].getIdCanBo());
				arr2.add(cacOb);
			}
			bbGiaoNhan.setIdDaiDienBenGiao(idDaiDienGiaoBBGn);
			bbGiaoNhan.setDaiDienBenGiao(arr2);
		}

		return bbGiaoNhan;
	}

	private TtktCmNhanTraHstl createBBGiaoTra(YeuCauCungCapHstlForm form, ApplicationContext app, HttpServletRequest request) throws Exception {
		TtktCmNhanTraHstl bbGiaoTra = new TtktCmNhanTraHstl();
		bbGiaoTra.setLoai(Constants.TT_TTKT_BBGIAOTRA_YCBSTL);

		bbGiaoTra.setId(form.getIdHoSoTra());
		bbGiaoTra.setIdTdYcBsHstl(form.getIdYeuCau());
		bbGiaoTra.setHoSo(form.getHoSoTra());
		bbGiaoTra.setBaoCao(form.getBaoCaoHoSoTra());
		bbGiaoTra.setIdCuocTtkt(form.getIdCuocTtKtl());
		bbGiaoTra.setIdDaiDienBenGiao(form.getIdDaiDienBenGiaoHoSo());
		bbGiaoTra.setIdDaiDienBenNhan(form.getIdDaiDienBenNhanHoSo());
		bbGiaoTra.setThoiDiemBatDau(Formater.str2dateForNV(form.getThoiDiemBatDauBanGiaoHoSo()));
		bbGiaoTra.setThoiDiemKetThuc(Formater.str2dateForNV(form.getThoiDiemKTBBGT()));
		// bbGiaoTra.setLoai(form.getLoaiHoSoLuuTru());
		bbGiaoTra.setDiaDiemBanGiao(form.getDiaDiemBBGT());
		bbGiaoTra.setIdDsTvd(form.getIdDsTvdGiaoTra());
		// --------------- Dai dien ben nhan bien ban giao tra
		// --------------------------
		String idDaiDienNhanBBGT = form.getIdDaiDienBenNhanHoSo();
		Collection arr3 = new ArrayList();
		if (form.getArrDaiDienBenNhanHstl() != null) {
			for (int i = 0; i < form.getArrDaiDienBenNhanHstl().length; i++) {
				TtktCmThanhPhanThamDu cacOb = new TtktCmThanhPhanThamDu();
				cacOb.setChucVu(form.getArrDaiDienBenNhanHstl()[i].getChucVu());
				cacOb.setHoTen(form.getArrDaiDienBenNhanHstl()[i].getHoTen());
				cacOb.setIdMaster(idDaiDienNhanBBGT);
				cacOb.setIdCanBo(form.getArrDaiDienBenNhanHstl()[i].getIdCanBo());
				cacOb.setIdNguoiCapNat(app.getMaCanbo());
				cacOb.setTenNguoiCapNhat(app.getTenCanbo());
				cacOb.setNgayCapNhat(new Date());
				arr3.add(cacOb);
			}
			bbGiaoTra.setIdDaiDienBenNhan(idDaiDienNhanBBGT);
			bbGiaoTra.setDaiDienBenNhan(arr3);
		}

		// --------------- Dai dien ben nhan bien ban giao tra
		// --------------------------
		String idDaiDienGiaoBBGT = form.getIdDaiDienBenGiaoHoSo();
		Collection arr4 = new ArrayList();
		if (form.getArrDaiDienBenGiaoHstl() != null) {
			for (int i = 0; i < form.getArrDaiDienBenGiaoHstl().length; i++) {
				TtktCmThanhPhanThamDu cacOb = new TtktCmThanhPhanThamDu();
				cacOb.setChucVu(form.getArrDaiDienBenGiaoHstl()[i].getChucVu());
				cacOb.setHoTen(form.getArrDaiDienBenGiaoHstl()[i].getHoTen());
				cacOb.setIdMaster(idDaiDienGiaoBBGT);
				cacOb.setIdCanBo(form.getArrDaiDienBenGiaoHstl()[i].getIdCanBo());
				arr4.add(cacOb);
			}
			bbGiaoTra.setIdDaiDienBenGiao(idDaiDienGiaoBBGT);
			bbGiaoTra.setDaiDienBenGiao(arr4);
		}

		return bbGiaoTra;
	}

}
