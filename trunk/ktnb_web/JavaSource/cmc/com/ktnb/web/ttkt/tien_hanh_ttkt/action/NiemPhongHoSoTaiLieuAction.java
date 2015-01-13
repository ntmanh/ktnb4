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

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBbMoNiemPhong;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBbNiemPhong;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThQdNiemPhongHsTl;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.NiemPhongHoSoTaiLieuForm;

/**
 * @version 1.0
 * @author
 */
public class NiemPhongHoSoTaiLieuAction extends BaseDispatchAction {

	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ApplicationContext app = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		NiemPhongHoSoTaiLieuForm niemphonghosotailieuForm = (NiemPhongHoSoTaiLieuForm) form;
		String method = request.getParameter("method");
		if ("save".equals(method)) {
			String type = request.getParameter("type");
			if (type.equals("qdNiemPhong")) {
				saveQdNiemPhong(request, reponse, app, niemphonghosotailieuForm);
			} else if (type.equals("bbNiemPhong")) {
				saveBbNiemPhong(request, reponse, app, niemphonghosotailieuForm);
			} else if (type.equals("qdMoNiemPhong")) {
				saveQdMoNiemPhong(request, reponse, app, niemphonghosotailieuForm);
			} else if (type.equals("bbMoNiemPhong")) {
				saveBbMoNiemPhong(request, reponse, app, niemphonghosotailieuForm);
			}
			return null;
		} else if ("in".equals(method)) {
			// TODO: Kiem tra xem cho nay co phai load lai lan nua khong
			String cuocTtktId = request.getParameter("idCuocTtkt");
			inNiemPhongHsTl(request, reponse, niemphonghosotailieuForm, app,cuocTtktId );
			return null;
		} else {
			String cuocTtktId = request.getParameter("idCuocTtkt");
			if (!Formater.isNull(cuocTtktId)) { // Nguoi dung click chon vao
				// link tai form main hoac mo
				// man hinh tao moi tu form tim
				// kiem
				if ("addnew".equals(method)) { // Tao moi tu man hinh tim kiem
					addNew(request, app, niemphonghosotailieuForm, cuocTtktId);

				} else { // Click vao link tai form main
					Collection dsNiemPhongHsTl = TtktCnPhuService.getDsNiemPhongHsTl(app, cuocTtktId);
					if (Formater.isNull(dsNiemPhongHsTl)) { // Truong doan
						// them moi
						addNew(request, app, niemphonghosotailieuForm, cuocTtktId);
					} else {
						if (!app.isTruongDoan(cuocTtktId) && dsNiemPhongHsTl.size() == 1) {
							// Thu truong co quan va co 1 ban ghi
							loadDataToForm(request, app, niemphonghosotailieuForm, (TtktThQdNiemPhongHsTl) ((ArrayList) dsNiemPhongHsTl).get(0));
							request.setAttribute("readOnly", "true");
							return mapping.findForward("success");

						}
						request.getSession().setAttribute("dsNiemPhongHsTl", dsNiemPhongHsTl);
						reponse.sendRedirect("danh_sach_tim_kiem.do?idCuocTtkt=" + cuocTtktId + "&type=niemPhongHSTL");
					}
				}

			} else {
				// Truong hop xem hoac sua thi truyen id vao url
				String id = request.getParameter("id");
				loadDataToForm(request, app, niemphonghosotailieuForm, id);
				if (!KtnbUtil.haveRoleNv(app) || "view".equals(method) || app.getTrangThaiCuocTtkt(niemphonghosotailieuForm.getIdCuocTtkt()).equals(Constants.TT_TTKT_KT)) {
					request.setAttribute("readOnly", "true");
				}

			}
		}

		return mapping.findForward("success");
	}

	private void saveBbMoNiemPhong(HttpServletRequest request, HttpServletResponse reponse, ApplicationContext app, NiemPhongHoSoTaiLieuForm niemphonghosotailieuForm) throws Exception {
		// Kiem tra da save quyet dinh mo niem phong chua
		TtktThQdNiemPhongHsTl qdNiemPhongHsTl = TtktCnPhuService.getQdNiemPhong(app, niemphonghosotailieuForm.getIdQdNiemPhong());
		PrintWriter writer = reponse.getWriter();
		if (Formater.isNull(qdNiemPhongHsTl.getIdNguoiMoNiemPhong())) {

			writer.print("loi");
		} else {
			TtktThBbMoNiemPhong bbMoNiemPhong = createBbMoNiemPhong(niemphonghosotailieuForm, app, request);
			TtktCnPhuService.saveBbMoNiemPhong(app, bbMoNiemPhong);

			writer.print("cucsess");
		}
	}

	private void saveQdMoNiemPhong(HttpServletRequest request, HttpServletResponse reponse, ApplicationContext app, NiemPhongHoSoTaiLieuForm niemPhongHoSoTaiLieuForm) throws Exception {
		TtktThQdNiemPhongHsTl niemPhongHsTl = createQdMoNiemPhong(app, niemPhongHoSoTaiLieuForm);
		TtktCnPhuService.saveQdNiemPhong(app, niemPhongHsTl);
		PrintWriter writer = reponse.getWriter();
		writer.print("cucsess");

	}

	private TtktThQdNiemPhongHsTl createQdMoNiemPhong(ApplicationContext app, NiemPhongHoSoTaiLieuForm niemPhongHoSoTaiLieuForm) throws Exception {
		TtktThQdNiemPhongHsTl niemPhongHsTl = TtktCnPhuService.getQdNiemPhong(app, niemPhongHoSoTaiLieuForm.getIdQdNiemPhong());
		niemPhongHsTl.setNgayRaQdMoNp(Formater.str2date(niemPhongHoSoTaiLieuForm.getNgayRaQDMoNP()));
		niemPhongHsTl.setNoiRaQdMoNp(niemPhongHoSoTaiLieuForm.getNoiRaQDMoNP());
		niemPhongHsTl.setTenDviCnhanBaoQuanSauMo(niemPhongHoSoTaiLieuForm.getDonViBaoQuanSauNP());
		niemPhongHsTl.setIdCnhanBaoQuanSauMo(KeyManagement.getGUID());
		niemPhongHsTl.setTenNguoiMoNiemPhong(niemPhongHoSoTaiLieuForm.getTenNguoiMoNp());
		niemPhongHsTl.setIdNguoiMoNiemPhong(niemPhongHoSoTaiLieuForm.getNguoiMoNP());
		niemPhongHsTl.setChucVuNguoiMoNiemPhong(niemPhongHoSoTaiLieuForm.getChucVuNguoiMoNP());
		niemPhongHsTl.setIdNguoiCapNat(app.getMaCanbo());
		niemPhongHsTl.setTenNguoiCapNhat(app.getTenCanbo());
		niemPhongHsTl.setNgayCapNhat(new Date());
		
		
		return niemPhongHsTl;
	}

	private void saveBbNiemPhong(HttpServletRequest request, HttpServletResponse reponse, ApplicationContext app, NiemPhongHoSoTaiLieuForm niemphonghosotailieuForm) throws Exception {
		TtktThBbNiemPhong bbNiemPhong = createBbNiemPhong(niemphonghosotailieuForm, app, request);
		PrintWriter writer = reponse.getWriter();
		writer.print("returnId:" + TtktCnPhuService.saveBbNiemPhong(app, bbNiemPhong));

	}

	private void saveQdNiemPhong(HttpServletRequest request, HttpServletResponse reponse, ApplicationContext app, NiemPhongHoSoTaiLieuForm niemPhongHoSoTaiLieuForm) throws Exception {
		TtktThQdNiemPhongHsTl qdNiemPhongHsTl = createQdNiemPhong(request, reponse, app, niemPhongHoSoTaiLieuForm);
		PrintWriter writer = reponse.getWriter();
		writer.print("returnId:" + TtktCnPhuService.saveQdNiemPhong(app, qdNiemPhongHsTl));

	}

	private TtktThQdNiemPhongHsTl createQdNiemPhong(HttpServletRequest request, HttpServletResponse reponse, ApplicationContext app, NiemPhongHoSoTaiLieuForm niemPhongHoSoTaiLieuForm)
			throws Exception {
		TtktThQdNiemPhongHsTl qdNiemPhongHsTl = new TtktThQdNiemPhongHsTl();
		qdNiemPhongHsTl.setChucVuDviCnhanThucHien(niemPhongHoSoTaiLieuForm.getChucVuTrongDoanQDNP());
		qdNiemPhongHsTl.setId(niemPhongHoSoTaiLieuForm.getIdQdNiemPhong());
		qdNiemPhongHsTl.setIdDsTvdQdNiemPhong(niemPhongHoSoTaiLieuForm.getIdDsTvdQdNiemPhong());
		qdNiemPhongHsTl.setIdDsTvdQdMoNiemPhong(niemPhongHoSoTaiLieuForm.getIdDsTvdQdMoNiemPhong());
		qdNiemPhongHsTl.setIdCuocTtkt(niemPhongHoSoTaiLieuForm.getIdCuocTtkt());
		qdNiemPhongHsTl.setNgayRaQd(Formater.str2date(niemPhongHoSoTaiLieuForm.getNgayRaQDNP()));
		qdNiemPhongHsTl.setNoiRaQd(niemPhongHoSoTaiLieuForm.getNoiRaQDNP());
		qdNiemPhongHsTl.setTgNiemPhongTu(Formater.str2dateForNV(niemPhongHoSoTaiLieuForm.getThoiGianNPTu()));
		qdNiemPhongHsTl.setTaiLieuDuocNiemPhong(niemPhongHoSoTaiLieuForm.getLoaiTaiLieuQDNP());
		qdNiemPhongHsTl.setTgNiemPhongTu(Formater.str2dateForNV(niemPhongHoSoTaiLieuForm.getThoiGianNPTu()));
		qdNiemPhongHsTl.setIdDviCnhanThucHien(niemPhongHoSoTaiLieuForm.getDinViCaNhanThucHien());
		qdNiemPhongHsTl.setIdDviCnhanBaoQuan(KeyManagement.getGUID());
		qdNiemPhongHsTl.setTenDviCnhanBaoQuan(niemPhongHoSoTaiLieuForm.getDinViCaNhanBaoQuanQdNp());
		qdNiemPhongHsTl.setTenDviCnhanThucHien(niemPhongHoSoTaiLieuForm.getTenCanBoDvCnTh());
		
		qdNiemPhongHsTl.setIdNguoiCapNat(app.getMaCanbo());
		qdNiemPhongHsTl.setTenNguoiCapNhat(app.getTenCanbo());
		qdNiemPhongHsTl.setNgayCapNhat(new Date());
		return qdNiemPhongHsTl;
	}

	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, NiemPhongHoSoTaiLieuForm niemphonghosotailieuForm, TtktThQdNiemPhongHsTl qdNiemPhongHsTl) throws Exception {

		// Quyet dinh niem phong
		niemphonghosotailieuForm.setIdCuocTtkt(qdNiemPhongHsTl.getIdCuocTtkt());
		niemphonghosotailieuForm.setIdCqtBi(CuocTtktService.getCuocTtktTrongQdWithoutNoiDung(app, qdNiemPhongHsTl.getIdCuocTtkt()).getIdDonViBi());
		niemphonghosotailieuForm.setIdQdNiemPhong(qdNiemPhongHsTl.getId());
		niemphonghosotailieuForm.setIdDsTvdQdNiemPhong(qdNiemPhongHsTl.getIdDsTvdQdNiemPhong());
		request.setAttribute("dsTvdQdNiemPhong", TtktService.getDsTvdById(app, qdNiemPhongHsTl.getIdDsTvdQdNiemPhong()));
		niemphonghosotailieuForm.setIdDsTvdQdMoNiemPhong(qdNiemPhongHsTl.getIdDsTvdQdMoNiemPhong());
		TtktCbDsTvDoan dsTvDoanHienTai = null;
		if (Formater.isNull(qdNiemPhongHsTl.getIdDsTvdQdMoNiemPhong())) {
			dsTvDoanHienTai = TtktService.getDsTvd(qdNiemPhongHsTl.getIdCuocTtkt(), app);
			niemphonghosotailieuForm.setIdDsTvdQdMoNiemPhong(dsTvDoanHienTai.getId());
			request.setAttribute("dsTvdQdMoNiemPhong", dsTvDoanHienTai.getChiTietDanhSachTV());
		} else {
			request.setAttribute("dsTvdQdMoNiemPhong", TtktService.getDsTvdById(app, qdNiemPhongHsTl.getIdDsTvdQdMoNiemPhong()));
		}

		niemphonghosotailieuForm.setNoiRaQDNP(qdNiemPhongHsTl.getNoiRaQd());
		niemphonghosotailieuForm.setNgayRaQDNP(Formater.date2str(qdNiemPhongHsTl.getNgayRaQd()));
		niemphonghosotailieuForm.setThoiGianNPTu(Formater.date2strDateTimeForNV(qdNiemPhongHsTl.getTgNiemPhongTu()));
		niemphonghosotailieuForm.setLoaiTaiLieuQDNP(qdNiemPhongHsTl.getTaiLieuDuocNiemPhong());
		niemphonghosotailieuForm.setDinViCaNhanThucHien(qdNiemPhongHsTl.getIdDviCnhanThucHien());
		niemphonghosotailieuForm.setDinViCaNhanBaoQuanQdNp(qdNiemPhongHsTl.getTenDviCnhanBaoQuan());
		niemphonghosotailieuForm.setNoiRaQDMoNP(qdNiemPhongHsTl.getNoiRaQdMoNp());
		niemphonghosotailieuForm.setNgayRaQDMoNP(Formater.date2str(qdNiemPhongHsTl.getNgayRaQdMoNp()));
		niemphonghosotailieuForm.setDonViBaoQuanSauNP(qdNiemPhongHsTl.getTenDviCnhanBaoQuanSauMo());
		niemphonghosotailieuForm.setChucVuTrongDoanQDNP(qdNiemPhongHsTl.getChucVuDviCnhanThucHien());
		niemphonghosotailieuForm.setTenNguoiMoNp(qdNiemPhongHsTl.getTenNguoiMoNiemPhong());
		niemphonghosotailieuForm.setChucVuNguoiMoNP(qdNiemPhongHsTl.getChucVuNguoiMoNiemPhong());
		niemphonghosotailieuForm.setTenCanBoDvCnTh(qdNiemPhongHsTl.getTenDviCnhanThucHien());
		
		niemphonghosotailieuForm.setNguoiMoNP(qdNiemPhongHsTl.getIdNguoiMoNiemPhong());
		niemphonghosotailieuForm.setTenCanBoDvCnTh(qdNiemPhongHsTl.getTenDviCnhanThucHien());

		// Bien ban niem phong
		TtktThBbNiemPhong bbNiemPhong = qdNiemPhongHsTl.getBbNiemPhong();
		if (bbNiemPhong != null) {
			niemphonghosotailieuForm.setIdBbNiemPhong(bbNiemPhong.getId());
			niemphonghosotailieuForm.setIdDsTvdBbNiemPhong(bbNiemPhong.getIdDsTvd());
			request.setAttribute("dsTvdBbNiemPhong", TtktService.getDsTvdById(app, bbNiemPhong.getIdDsTvd()));

			niemphonghosotailieuForm.setVaoLucBienBanNP(Formater.date2strDateTimeForNV(bbNiemPhong.getThoiDiemNiemPhong()));
			niemphonghosotailieuForm.setTaiDiaDiemNP(bbNiemPhong.getDiaDiemNiemPhong());
			niemphonghosotailieuForm.setIdThanhPhanThamDuDoanTtktBBNP(bbNiemPhong.getIdTpThamDuDoanTtkt());
			niemphonghosotailieuForm.setIdThanhPhanThamDuCacOngBaBBNP(bbNiemPhong.getIdTpThamDuDviCnhanCoTs());
			niemphonghosotailieuForm.setTienHanhNPCacTaiLieu(bbNiemPhong.getTaiLieuBiNP());
			niemphonghosotailieuForm.setDinViCaNhanBaoQuanBbNp(bbNiemPhong.getTenDviCnhanBaoQuan());
			niemphonghosotailieuForm.setThoiGianHoanThanhNP(Formater.date2strDateTimeForNV(bbNiemPhong.getThoiDiemKetThucNphong()));
			

			// ------- Load Thanh phan tham du TTKT ----------
			Collection dsTpTd = bbNiemPhong.getDsDoanTtkt();
			if (dsTpTd != null) {
				TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[dsTpTd.size()];
				Iterator iter = dsTpTd.iterator();
				int i = 0;
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();

					dsTpTdLoad[i] = tptd;
					i++;

				}
				niemphonghosotailieuForm.setDsTVD(dsTpTdLoad);
			}
			// ------- Load Thanh phan tham du co tai lieu niem phong
			// ----------

			Collection dsTpTdCoTlNp = bbNiemPhong.getDsDvCoTlNp();

			if (dsTpTdCoTlNp != null) {
				TtktCmThanhPhanThamDu[] dsTpTdCoTlNpLoad = new TtktCmThanhPhanThamDu[dsTpTdCoTlNp.size()];
				Iterator iter2 = dsTpTdCoTlNp.iterator();
				int i = 0;
				while (iter2.hasNext()) {
					TtktCmThanhPhanThamDu tptd2 = (TtktCmThanhPhanThamDu) iter2.next();

					dsTpTdCoTlNpLoad[i] = tptd2;
					i++;
				}
				niemphonghosotailieuForm.setDsDvCoTlnp(dsTpTdCoTlNpLoad);
			}
		} else {
			if (dsTvDoanHienTai == null)
				dsTvDoanHienTai = TtktService.getDsTvd(qdNiemPhongHsTl.getIdCuocTtkt(), app);
			niemphonghosotailieuForm.setIdDsTvdBbNiemPhong(dsTvDoanHienTai.getId());
			request.setAttribute("dsTvdBbNiemPhong", dsTvDoanHienTai.getChiTietDanhSachTV());
		}

		// Bien ban mo niem phong

		TtktThBbMoNiemPhong bbMoNiemPhong = qdNiemPhongHsTl.getBbMoNiemPhong();
		if (bbMoNiemPhong != null) {
			niemphonghosotailieuForm.setIdBbMoNiemPhong(bbMoNiemPhong.getId());
			niemphonghosotailieuForm.setIdDsTvdBbMoNiemPhong(bbMoNiemPhong.getIdDsTvd());
			request.setAttribute("dsTvdBbMoNiemPhong", TtktService.getDsTvdById(app, bbMoNiemPhong.getIdDsTvd()));
			niemphonghosotailieuForm.setVaoLucBienBanMoNP(Formater.date2strDateTimeForNV(bbMoNiemPhong.getThoiDiemMoNiemPhong()));
			niemphonghosotailieuForm.setDiaDiemBienBanMoNP(bbMoNiemPhong.getDiaDiemMoNiemPhong());
			niemphonghosotailieuForm.setMoNPCuaNgay(Formater.date2str(bbNiemPhong.getThoiDiemNiemPhong()));
			niemphonghosotailieuForm.setTinhTrangDauNiemPhong(bbMoNiemPhong.getTinhTrangDauNphong());
			niemphonghosotailieuForm.setThoiGianHoanThanhMoNP(Formater.date2strDateTimeForNV(bbMoNiemPhong.getThoiDiemKetThucMoNphong()));
			niemphonghosotailieuForm.setIdThanhPhanThamDuDoanTtktBBMNP(bbMoNiemPhong.getIdTpThamDuDoanTtkt());
			niemphonghosotailieuForm.setIdThanhPhanThamDuCacOngBaBBMNP(bbMoNiemPhong.getIdTpThamDuCacOngBa());
			// ---------- Thanh phan tham du doan thanh tra kiem tra
			// -------------
			Collection dsTpTd2 = bbMoNiemPhong.getDsDoanTtkt();

			if (dsTpTd2 != null) {
				TtktCmThanhPhanThamDu[] dsTpTd2Load = new TtktCmThanhPhanThamDu[dsTpTd2.size()];
				Iterator iter3 = dsTpTd2.iterator();
				int i = 0;
				while (iter3.hasNext()) {
					TtktCmThanhPhanThamDu tptd3 = (TtktCmThanhPhanThamDu) iter3.next();
					dsTpTd2Load[i] = tptd3;
					i++;

				}
				niemphonghosotailieuForm.setDsTVD2(dsTpTd2Load);
			}

			// ---------- Thanh phan tham du cac Ong Ba --------
			Collection dsTpTdCacOngBa = bbMoNiemPhong.getDsCacOba();

			if (dsTpTdCacOngBa != null) {
				TtktCmThanhPhanThamDu[] dsTpTdCacOngBaLoad = new TtktCmThanhPhanThamDu[dsTpTdCacOngBa.size()];
				Iterator iter4 = dsTpTdCacOngBa.iterator();
				int i = 0;
				while (iter4.hasNext()) {
					TtktCmThanhPhanThamDu tptd4 = (TtktCmThanhPhanThamDu) iter4.next();
					dsTpTdCacOngBaLoad[i] = tptd4;
					i++;

				}
				niemphonghosotailieuForm.setDsCacOb(dsTpTdCacOngBaLoad);
			}
			// -------------Dung request dua danh sach ten TPTD toi Clien
			// -------------
			request.setAttribute("dsTenTpTdDoan", getDsTen(niemphonghosotailieuForm.getDsTVD()));
			request.setAttribute("dsTenTpTdDoanCoTlNp", getDsTen(niemphonghosotailieuForm.getDsDvCoTlnp()));
			request.setAttribute("dsTenTpTdDoanBBMNP", getDsTen(niemphonghosotailieuForm.getDsTVD2()));
			request.setAttribute("dsTenTpTdDoanOngBaBBMNP", getDsTen(niemphonghosotailieuForm.getDsCacOb()));
		} else {
			if (dsTvDoanHienTai == null)
				dsTvDoanHienTai = TtktService.getDsTvd(qdNiemPhongHsTl.getIdCuocTtkt(), app);
			niemphonghosotailieuForm.setIdDsTvdBbMoNiemPhong(dsTvDoanHienTai.getId());
			request.setAttribute("dsTvdBbMoNiemPhong", dsTvDoanHienTai.getChiTietDanhSachTV());
		}

	}

	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, NiemPhongHoSoTaiLieuForm niemphonghosotailieuForm, String idQdNiemPhong) throws Exception {
		TtktThQdNiemPhongHsTl niemPhongHsTl = TtktService.getQdNiemPhong(app, idQdNiemPhong);
		loadDataToForm(request, app, niemphonghosotailieuForm, niemPhongHsTl);

	}

	private void addNew(HttpServletRequest request, ApplicationContext app, NiemPhongHoSoTaiLieuForm niemphonghosotailieuForm, String cuocTtktId) throws Exception {
		niemphonghosotailieuForm.setIdCuocTtkt(cuocTtktId);
		niemphonghosotailieuForm.setIdCqtBi(CuocTtktService.getCuocTtktTrongQdWithoutNoiDung(app, cuocTtktId).getIdDonViBi());
		TtktCbDsTvDoan dsTvDoan = TtktService.getDsTvd(cuocTtktId, app);
		String idDstvd = dsTvDoan.getId();
		Collection chiTietDsTvd = dsTvDoan.getChiTietDanhSachTV();
		niemphonghosotailieuForm.setIdDsTvdQdNiemPhong(idDstvd);
		niemphonghosotailieuForm.setIdDsTvdQdMoNiemPhong(idDstvd);
		niemphonghosotailieuForm.setIdDsTvdBbNiemPhong(idDstvd);
		niemphonghosotailieuForm.setIdDsTvdBbMoNiemPhong(idDstvd);
		request.setAttribute("dsTvdQdNiemPhong", chiTietDsTvd);
		request.setAttribute("dsTvdQdMoNiemPhong", chiTietDsTvd);
		request.setAttribute("dsTvdBbNiemPhong", chiTietDsTvd);
		request.setAttribute("dsTvdBbMoNiemPhong", chiTietDsTvd);

	}

	
	private TtktThBbMoNiemPhong createBbMoNiemPhong(NiemPhongHoSoTaiLieuForm niemphonghosotailieuForm, ApplicationContext app, HttpServletRequest request) throws Exception {
		TtktThBbMoNiemPhong bbMoNP = new TtktThBbMoNiemPhong();
		bbMoNP.setId(niemphonghosotailieuForm.getIdBbMoNiemPhong());
		bbMoNP.setIdDsTvd(niemphonghosotailieuForm.getIdDsTvdBbMoNiemPhong());
		bbMoNP.setThoiDiemMoNiemPhong(Formater.str2dateForNV(niemphonghosotailieuForm.getVaoLucBienBanMoNP()));
		bbMoNP.setDiaDiemMoNiemPhong(niemphonghosotailieuForm.getDiaDiemBienBanMoNP());
		bbMoNP.setTinhTrangDauNphong(niemphonghosotailieuForm.getTinhTrangDauNiemPhong());
		bbMoNP.setThoiDiemKetThucMoNphong(Formater.str2dateForNV(niemphonghosotailieuForm.getThoiGianHoanThanhMoNP()));
		bbMoNP.setIdNguoiCapNat(app.getMaCanbo());
		bbMoNP.setTenNguoiCapNhat(app.getTenCanbo());
		bbMoNP.setNgayCapNhat(new Date());
		
		
		String str = niemphonghosotailieuForm.getVaoLucBienBanNP();
		String subStr = "";
		if (str != null && str.length() > 0) {
			String[] strTemp = str.split(" ");
			if (str.length() > 0) {
				subStr = strTemp[strTemp.length - 1];
			}
		}

		bbMoNP.setMoNiemPhongCuaNgay(Formater.str2date(subStr));
		bbMoNP.setIdQdMoNiemPhong(niemphonghosotailieuForm.getIdQdNiemPhong());
		bbMoNP.setIdTpThamDuDoanTtkt(niemphonghosotailieuForm.getIdThanhPhanThamDuDoanTtktBBMNP());
		bbMoNP.setIdTpThamDuCacOngBa(niemphonghosotailieuForm.getIdThanhPhanThamDuCacOngBaBBMNP());

		// ------------- Thanh pham tham du thanh tra kiem tra
		// -------------------------
		String thanhPhanThamDuDoanTtktId = niemphonghosotailieuForm.getIdThanhPhanThamDuDoanTtktBBMNP();
		Collection dsDoanTtkt = new ArrayList();
		if (niemphonghosotailieuForm.getDsTVD2() != null) {
			for (int i = 0; i < niemphonghosotailieuForm.getDsTVD2().length; i++) {
				TtktCmThanhPhanThamDu tptd = new TtktCmThanhPhanThamDu();
				tptd.setChucVu(niemphonghosotailieuForm.getDsTVD2()[i].getChucVu());
				tptd.setHoTen(niemphonghosotailieuForm.getDsTVD2()[i].getHoTen());
				tptd.setIdMaster(thanhPhanThamDuDoanTtktId);
				tptd.setIdCanBo(niemphonghosotailieuForm.getDsTVD2()[i].getIdCanBo());
				tptd.setIdNguoiCapNat(app.getMaCanbo());
				tptd.setTenNguoiCapNhat(app.getTenCanbo());
				tptd.setNgayCapNhat(new Date());
				dsDoanTtkt.add(tptd);
			}
			bbMoNP.setIdTpThamDuDoanTtkt(thanhPhanThamDuDoanTtktId);
			bbMoNP.setDsDoanTtkt(dsDoanTtkt);
		}

		// --------------- Thanh pham tham du gom cac Ong Ba
		// --------------------------
		String dsCacObId = niemphonghosotailieuForm.getIdThanhPhanThamDuCacOngBaBBMNP();
		Collection dsCacOb = new ArrayList();
		if (niemphonghosotailieuForm.getDsCacOb() != null) {
			for (int i = 0; i < niemphonghosotailieuForm.getDsCacOb().length; i++) {
				TtktCmThanhPhanThamDu cacOb = new TtktCmThanhPhanThamDu();
				cacOb.setChucVu(niemphonghosotailieuForm.getDsCacOb()[i].getChucVu());
				cacOb.setHoTen(niemphonghosotailieuForm.getDsCacOb()[i].getHoTen());
				cacOb.setIdMaster(dsCacObId);
				cacOb.setIdCanBo(niemphonghosotailieuForm.getDsCacOb()[i].getIdCanBo());
				dsCacOb.add(cacOb);
			}
			bbMoNP.setIdTpThamDuCacOngBa(dsCacObId);
			bbMoNP.setDsCacOba(dsCacOb);
		}

		return bbMoNP;
	}

	private TtktThBbNiemPhong createBbNiemPhong(NiemPhongHoSoTaiLieuForm niemphonghosotailieuForm, ApplicationContext app, HttpServletRequest request) throws Exception {

		TtktThBbNiemPhong bbNP = new TtktThBbNiemPhong();
		bbNP.setId(niemphonghosotailieuForm.getIdBbNiemPhong());
		bbNP.setIdDsTvd(niemphonghosotailieuForm.getIdDsTvdBbNiemPhong());
		bbNP.setThoiDiemNiemPhong(Formater.str2dateForNV(niemphonghosotailieuForm.getVaoLucBienBanNP()));
		bbNP.setDiaDiemNiemPhong(niemphonghosotailieuForm.getTaiDiaDiemNP());
		bbNP.setTaiLieuBiNP(niemphonghosotailieuForm.getTienHanhNPCacTaiLieu());
		bbNP.setThoiDiemKetThucNphong(Formater.str2dateForNV(niemphonghosotailieuForm.getThoiGianHoanThanhNP()));
		bbNP.setIdQuyetDinhNp(niemphonghosotailieuForm.getIdQdNiemPhong());
		bbNP.setIdTpThamDuDoanTtkt(niemphonghosotailieuForm.getIdThanhPhanThamDuDoanTtktBBNP());
		bbNP.setIdTpThamDuDviCnhanCoTs(niemphonghosotailieuForm.getIdThanhPhanThamDuCacOngBaBBNP());
		bbNP.setTenDviCnhanBaoQuan(niemphonghosotailieuForm.getDinViCaNhanBaoQuanBbNp());
		bbNP.setIdNguoiCapNat(app.getMaCanbo());
		bbNP.setTenNguoiCapNhat(app.getTenCanbo());
		bbNP.setNgayCapNhat(new Date());
		
		// Thanh pham tham du thanh tra kiem tra

		String thanhPhanThamDuDoanTtktId = niemphonghosotailieuForm.getIdThanhPhanThamDuDoanTtktBBNP();
		bbNP.setIdTpThamDuDoanTtkt(thanhPhanThamDuDoanTtktId);
		Collection dsDoanTtkt = new ArrayList();
		if (niemphonghosotailieuForm.getDsTVD() != null) {
			for (int i = 0; i < niemphonghosotailieuForm.getDsTVD().length; i++) {
				TtktCmThanhPhanThamDu tptd = new TtktCmThanhPhanThamDu();
				tptd.setChucVu(niemphonghosotailieuForm.getDsTVD()[i].getChucVu());
				tptd.setHoTen(niemphonghosotailieuForm.getDsTVD()[i].getHoTen());
				tptd.setIdMaster(thanhPhanThamDuDoanTtktId);
				tptd.setIdCanBo(niemphonghosotailieuForm.getDsTVD()[i].getIdCanBo());
				tptd.setIdNguoiCapNat(app.getMaCanbo());
				tptd.setTenNguoiCapNhat(app.getTenCanbo());
				tptd.setNgayCapNhat(new Date());
				dsDoanTtkt.add(tptd);
			}

			bbNP.setDsDoanTtkt(dsDoanTtkt);
		}

		// Thanh phan tham du don vi co tai lieu duoc niem phong
		String dvCaNhaCoTlnpID = niemphonghosotailieuForm.getIdThanhPhanThamDuCacOngBaBBNP();
		bbNP.setIdTpThamDuDviCnhanCoTs(dvCaNhaCoTlnpID);
		Collection dsDvCoTlnp = new ArrayList();
		if (niemphonghosotailieuForm.getDsDvCoTlnp() != null) {
			for (int i = 0; i < niemphonghosotailieuForm.getDsDvCoTlnp().length; i++) {
				TtktCmThanhPhanThamDu tptd = new TtktCmThanhPhanThamDu();
				tptd.setHoTen(niemphonghosotailieuForm.getDsDvCoTlnp()[i].getHoTen());
				tptd.setChucVu(niemphonghosotailieuForm.getDsDvCoTlnp()[i].getChucVu());
				tptd.setIdMaster(dvCaNhaCoTlnpID);
				tptd.setIdCanBo(niemphonghosotailieuForm.getDsDvCoTlnp()[i].getIdCanBo());
				dsDvCoTlnp.add(tptd);
			}

			bbNP.setDsDvCoTlNp(dsDvCoTlnp);

		}

		return bbNP;
	}

	
	private void inNiemPhongHsTl_old(HttpServletRequest request, HttpServletResponse reponse, NiemPhongHoSoTaiLieuForm form, ApplicationContext app, String idCuocTtKt) throws Exception {
		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, idCuocTtKt);
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtKt, app);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
		String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
		StringBuffer sb = new StringBuffer(hinhThuc);
		parameters.put("ttkt", sb.toString());
		sb = new StringBuffer("\u0110O\u00C0N ");
		sb.append(hinhthuc_inT);
		sb.append(" Q\u0110 S\u1ED0 ");
		sb.append(cbQd.getSoQuyetDinh());
		if ("inQDNP".equals(type)) {
			// in quyet dinh niem phong
			fileTemplate = "ttnb22";
			parameters.put("ten_cqt", app.getTenCqt());
			parameters.put("doan_ttkt_so", sb.toString());
			// parameters.put("ttkt", sb.toString());
			parameters.put("dv_dc_giao_thuc_hien", form.getTenCanBoDvCnTh());
			parameters.put("dv_dc_giao_bao_quan", form.getDinViCaNhanBaoQuanQdNp());
			// parameters.put("dv_co_tai_lieu_niem_phong", form.getd);
			parameters.put("so_ttkt", cbQd.getSoQuyetDinh());
			parameters.put("ngay_qd", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			parameters.put("so_qd", cbQd.getSoQuyetDinh());
			parameters.put("thu_truong", KtnbUtil.getTenThuTruongCqt(app));
			parameters.put("dv_dc_ttkt", cuocTtkt.getTenDonViBi());
			parameters.put("noi_ra_qd", cbQd.getDiaDiemRaQuyetDinh());
			parameters.put("thoi_gian_niem_phong", KtnbUtil.getHour(form.getThoiGianNPTu()));
			parameters.put("thu_truong_dv_dc_niem_phong", KtnbUtil.getChucVuThuTruongByMaCqt(cuocTtkt.getIdDonViBi()) + " " + cuocTtkt.getTenDonViBi());
			parameters.put("loai_tai_lieu_dc_niem_phong", form.getLoaiTaiLieuQDNP());
			parameters.put("ten_truong_doan", cuocTtkt.getTenTruongDoan());
			System.out.println("ten truong doan :"+cuocTtkt.getTenTruongDoan());
			if (Formater.isNull(form.getNoiRaQDNP()) || Formater.isNull(form.getNgayRaQDNP())) {
				parameters.put("noi_ra_quyet_dinh", ".....");
				parameters.put("ngay_ra_qd", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			} else {
				parameters.put("noi_ra_quyet_dinh", form.getNoiRaQDNP());
				parameters.put("ngay_ra_qd", Formater.getDateForPrint(form.getNgayRaQDNP()));
			}
		} else if ("inQDMoNP".equals(type)) {
			// in quyet dinh mo niem phong
			fileTemplate = "ttnb24";
			parameters.put("ten_cqt", app.getTenCqt());
			parameters.put("doan_ttkt_so", sb.toString());
			// parameters.put("ttkt", sb.toString());
			parameters.put("ngay_qd", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())).toUpperCase());
			parameters.put("dv_dc_bao_quan_tai_lieu", form.getDonViBaoQuanSauNP());
			parameters.put("thoi_gian_quyet_dinh", Formater.getDateForPrint(form.getNgayRaQDNP()));
			parameters.put("dv_dc_giao_nhiem_vu_mo", form.getTenNguoiMoNp());
			parameters.put("dv_co_tai_lieu_niem_phong", KtnbUtil.getChucVuThuTruongByMaCqt(cuocTtkt.getIdDonViBi()) + " " + cuocTtkt.getTenDonViBi());
			parameters.put("TTKT", hinhThuc.toUpperCase());
			parameters.put("thu_truong_cqt", KtnbUtil.getTenThuTruongCqt(app).toUpperCase());
			parameters.put("so_qd", cbQd.getSoQuyetDinh());
			parameters.put("dv_bao_quan_sau_khi_mo", form.getDonViBaoQuanSauNP());
			parameters.put("dv_dc_ttkt", cuocTtkt.getTenDonViBi());
			parameters.put("ngay_qd2", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			parameters.put("thu_truong_cqt2", KtnbUtil.getTenThuTruongCqt(app));
			parameters.put("ten_truong_doan", cuocTtkt.getTenTruongDoan());

		} else if ("inBienBanMo".equals(type)) {
			fileTemplate = "ttnb25";
			parameters.put("ten_cqt", app.getTenCqt());
			parameters.put("doan_ttkt_so", sb.toString());
			parameters.put("ten_bc", sb.toString());
			parameters.put("ttkt", hinhThuc);
			// parameters.put("so_qd_niem_phong", sb.toString());
			parameters.put("ngay_qd_niem_phong", "");
			System.out.println("ngay qd niem phong : "+form.getNgayRaQDMoNP());
			//parameters.put("ngay_qd_niem_phong", Formater.getDateForPrint(form.getNgayRaQDMoNP()));
			//parameters.put("ngay_qd", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			System.out.println("ngay_qd : "+Formater.date2str(cbQd.getNgayRaQuyetDnh()));
			parameters.put("ngay_qd", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			parameters.put("thoi_gian_mo_niem_phong", "");
			System.out.println("thoi gian mo niem phong : "+form.getVaoLucBienBanNP());
			//parameters.put("thoi_gian_mo_niem_phong", KtnbUtil.getHour(form.getVaoLucBienBanNP()));
			parameters.put("dia_diem_mo_niem_phong", form.getDiaDiemBienBanMoNP());
			parameters.put("dv_co_tai_lieu_niem_phong", cuocTtkt.getTenDonViBi());
			parameters.put("ket_thuc_niem_phong", "");
			//parameters.put("ket_thuc_niem_phong", KtnbUtil.getHour(form.getThoiGianHoanThanhMoNP()));
			parameters.put("cac_tai_lieu", form.getLoaiTaiLieuBBNP());
			parameters.put("dv_nguoi_dc_quan_ly", form.getDonViBaoQuanSauNP());
			parameters.put("thu_truong_cqt", KtnbUtil.getTenThuTruongCqt(app));
			parameters.put("so_qd", cbQd.getSoQuyetDinh());
			parameters.put("dv_dc_ttkt", cuocTtkt.getTenDonViBi());
			parameters.put("dia_diem_niem_phong", form.getDiaDiemBienBanMoNP());
			parameters.put("ngay_mo_niem_phong", "");
			System.out.println("ngay mo niem phong : "+form.getThoiGianNPTu());
			//parameters.put("ngay_mo_niem_phong", KtnbUtil.getDay(form.getThoiGianNPTu()));
			parameters.put("tinh_trang_tai_lieu", form.getTinhTrangDauNiemPhong());
			parameters.put("ten_truong_doan", cuocTtkt.getTenTruongDoan());

			// doan thanh tra kiem tra
			TtktCmThanhPhanThamDu[] arrthanhphanbg = form.getDsTVD2();
			StringBuffer tptd = new StringBuffer("");
			if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
				for (int i = 0; i < arrthanhphanbg.length; i++) {
					tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg[i].getHoTen()));
					tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg[i].getChucVu()));
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				parameters.put("ten_thanh_vien_doan", tptd.toString().substring(0, tptd.toString().length()-1));
			}

			// Don vi ca nhan co tai lieu niem phong
			TtktCmThanhPhanThamDu[] arr = form.getDsCacOb();
			StringBuffer tptd1 = new StringBuffer("");
			if (arr != null && arr.length > 0) {
				for (int i = 0; i < arr.length; i++) {
					tptd1.append(KtnbUtil.layoutTableHoTen(arr[i].getHoTen()));
					tptd1.append(KtnbUtil.layoutTableChucVu(arr[i].getChucVu()));
					tptd1.append("\n");
				}
				System.out.println(tptd1.toString());
				parameters.put("ten_thanh_vien_dv", tptd1.toString().substring(0, tptd1.toString().length()-1));
			}
		} else if ("inBienBan".equals(type)) {
			fileTemplate = "ttnb23";
			parameters.put("ten_cqt", app.getTenCqt());
			parameters.put("doan_ttkt_so", sb.toString());
			parameters.put("ten_bc", sb.toString());
			parameters.put("ngay_niem_phong", Formater.getDateForPrint(form.getNgayRaQDNP()));
			parameters.put("thu_truong_cqt", KtnbUtil.getTenThuTruongCqt(app));
			parameters.put("so_qd", cbQd.getSoQuyetDinh());
			parameters.put("dv_dc_ttkt", cuocTtkt.getTenDonViBi());
			parameters.put("thoi_gian_lap_bien_ban", Formater.getDateTimeForPrint(form.getVaoLucBienBanNP()));
			parameters.put("dia_diem", form.getTaiDiaDiemNP());
			parameters.put("tai_lieu_niem_phong", form.getTienHanhNPCacTaiLieu());
			parameters.put("dv_quan_ly", form.getDinViCaNhanBaoQuanBbNp());
			parameters.put("thoi_gian_ket_thuc", Formater.getDateTimeForPrint(form.getThoiGianHoanThanhNP()));
			parameters.put("thu_truong_qd", KtnbUtil.getTenThuTruongCqt(app));
			parameters.put("ngay_qdinh", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			parameters.put("ten_truong_doan", cuocTtkt.getTenTruongDoan());
			// doan thanh tra kiem tra
			TtktCmThanhPhanThamDu[] arrthanhphanbg = form.getDsTVD();
			StringBuffer tptd = new StringBuffer("");
			if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
				for (int i = 0; i < arrthanhphanbg.length; i++) {
					tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg[i].getHoTen()));
					tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg[i].getChucVu()));
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				parameters.put("thanh_vien", tptd.toString().substring(0, tptd.toString().length()-1));
			}

			// Don vi ca nhan co tai lieu niem phong
			TtktCmThanhPhanThamDu[] arr = form.getDsDvCoTlnp();
			StringBuffer tptd1 = new StringBuffer("");
			if (arr != null && arr.length > 0) {
				for (int i = 0; i < arr.length; i++) {
					tptd1.append(KtnbUtil.layoutTableHoTen(arr[i].getHoTen()));
					tptd1.append(KtnbUtil.layoutTableChucVu(arr[i].getChucVu()));
					tptd1.append("\n");
				}
				System.out.println(tptd1.toString());
				parameters.put("thanh_vien_dv", tptd1.toString().substring(0, tptd1.toString().length()-1));
			}
		}

		if (Formater.isNull(fileTemplate))
			throw new Exception("Chua chon file template");

		InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
		KtnbUtil.printf(reportRows, fileTemplate, reponse, inputStream, parameters, null);
	}
	
	/**
	 * Download file mau TTNB22,TTNB23,TTNB24,TTNB25
	 * 
	 * @throws Exception
	*/
	
	//v3
	private void inNiemPhongHsTlv3(HttpServletRequest request, HttpServletResponse reponse, NiemPhongHoSoTaiLieuForm form, ApplicationContext app, String idCuocTtKt) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;
		StringBuffer defaultPrint = new StringBuffer("\u00D4ng (B\u00E0)................             Ch\u1EE9c v\u1EE5:...............");
		defaultPrint.append("\n\u00D4ng (B\u00E0)................             Ch\u1EE9c v\u1EE5:...............");
		defaultPrint.append("\n......................................................................................");
		
		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, idCuocTtKt);
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtKt, app);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
		String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
		StringBuffer sb = new StringBuffer(hinhThuc);
		
		StringBuffer sbT = new StringBuffer("\u0110O\u00C0N ");
		sbT.append(hinhthuc_inT);
		sbT.append(" Q\u0110 S\u1ED0 ");
		sbT.append(cbQd.getSoQuyetDinh());
		if ("inQDNP".equals(type)) {
			// in quyet dinh niem phong
			fileIn = request.getRealPath("/docin") + "\\TTNB22.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB22_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			fileTemplate = "ttnb22";
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", app.getTenCqt().toUpperCase());
				word.put("[doan_ttkt_so]", sbT.toString().toUpperCase());
				if (Formater.isNull(form.getNoiRaQDNP()) && Formater.isNull(form.getNgayRaQDNP())) {
					word.put("[noi_ra_quyet_dinh]", ".....");
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else if (!Formater.isNull(form.getNoiRaQDNP()) && !Formater.isNull(form.getNgayRaQDNP())) {
					word.put("[noi_ra_quyet_dinh]", form.getNoiRaQDNP());
					word.put("[ngay_ra_qd]", Formater.getDateForPrint(form.getNgayRaQDNP()));
				} else if (Formater.isNull(form.getNoiRaQDNP()) && !Formater.isNull(form.getNgayRaQDNP())) {
					word.put("[noi_ra_quyet_dinh]", ".....");
					word.put("[ngay_ra_qd]", Formater.getDateForPrint(form.getNgayRaQDNP()));
				} else if (!Formater.isNull(form.getNoiRaQDNP()) && Formater.isNull(form.getNgayRaQDNP())) {
					word.put("[noi_ra_quyet_dinh]", form.getNoiRaQDNP());
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				}
				word.put("[ttkt]", sb.toString().toUpperCase());
				word.put("[so_ttkt]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())).toUpperCase());
				word.put("[thu_truong]", KtnbUtil.getTenThuTruongCqtForMauin(app).toUpperCase());
				word.put("[ttkt]", sb.toString());
				word.put("[so_ttkt]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong]", KtnbUtil.getTenThuTruongCqtForMauin(app));
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[loai_tai_lieu_dc_niem_phong]", form.getLoaiTaiLieuQDNP());
				word.put("[thoi_gian_niem_phong]", KtnbUtil.getHour(form.getThoiGianNPTu()));
				word.put("[dv_dc_giao_thuc_hien]", form.getTenCanBoDvCnTh());
				word.put("[dv_dc_giao_bao_quan]", form.getDinViCaNhanBaoQuanQdNp());
				word.put("[dv_dc_giao_thuc_hien]", form.getTenCanBoDvCnTh());
				word.put("[dv_dc_giao_bao_quan]", form.getDinViCaNhanBaoQuanQdNp());
				word.put("[thu_truong_dv_dc_niem_phong]", KtnbUtil.getChucVuThuTruongByMaCqt(cuocTtkt.getIdDonViBi()) + " " + cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", sb.toString().toUpperCase());
				// word.put("dv_co_tai_lieu_niem_phong", form.getd);
				//word.put("[so_qd]", cbQd.getSoQuyetDinh());
				//word.put("[noi_ra_qd]", cbQd.getDiaDiemRaQuyetDinh());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				System.out.println("ten truong doan :"+cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB22", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}finally {				
				try { 
					word.saveAndClose();
				} catch (Exception e) {
					
				}
			}
			
		} else if ("inQDMoNP".equals(type)) {
			// in quyet dinh mo niem phong
			fileIn = request.getRealPath("/docin") + "\\TTNB24.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB24_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			fileTemplate = "ttnb24";
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", app.getTenCqt().toUpperCase());
				word.put("[doan_ttkt_so]", sbT.toString().toUpperCase());
				word.put("[ttkt]", sb.toString().toUpperCase());
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())).toUpperCase());
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(app).toUpperCase());
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(app));
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[dv_dc_bao_quan_tai_lieu]", form.getDonViBaoQuanSauNP());
				word.put("[ttkt]", sb.toString());
				word.put("[thoi_gian_quyet_dinh]", Formater.getDateForPrint(form.getNgayRaQDNP()));
				word.put("[dv_dc_giao_nhiem_vu_mo]", form.getTenNguoiMoNp());
				word.put("[dv_bao_quan_sau_khi_mo]", form.getDonViBaoQuanSauNP());
				word.put("[dv_dc_bao_quan_tai_lieu]", form.getDonViBaoQuanSauNP());
				if(Formater.isNull(form.getTenNguoiMoNp()))
					word.put("[dv_dc_giao_nhiem_vu_mo]", "");
				else
					word.put("[dv_dc_giao_nhiem_vu_mo]", form.getTenNguoiMoNp()+",");
				word.put("[dv_bao_quan_sau_khi_mo]", form.getDonViBaoQuanSauNP());
				word.put("[dv_co_tai_lieu_niem_phong]", KtnbUtil.getChucVuThuTruongByMaCqt(cuocTtkt.getIdDonViBi()) + " " + cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", hinhThuc.toUpperCase());
				//word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqt(app).toUpperCase());
				//word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB24", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}
		} else if ("inBienBanMo".equals(type)) {
			fileIn = request.getRealPath("/docin") + "\\TTNB25.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB25_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			fileTemplate = "ttnb25";
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", app.getTenCqt().toUpperCase());
				word.put("[doan_ttkt_so]", sbT.toString().toUpperCase());
				//word.put("[ten_bc]", sb.toString());
				// word.put("so_qd_niem_phong", sb.toString());
				word.put("[ngay_qd_niem_phong]", Formater.getDateForPrint(form.getNgayRaQDMoNP()));
				//word.put("ngay_qd_niem_phong", Formater.getDateForPrint(form.getNgayRaQDMoNP()));
				word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(app));
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[thoi_gian_mo_niem_phong]", KtnbUtil.getHour(form.getVaoLucBienBanMoNP()));
				word.put("[dia_diem_mo_niem_phong]", form.getDiaDiemBienBanMoNP());
				//word.put("[dia_diem_niem_phong]", form.getDiaDiemBienBanMoNP());
				word.put("[ttkt]", hinhThuc);
				//doan thanh tra kiem tra
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrthanhphanbg = form.getDsTVD2();
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
					//word.put("[ten_thanh_vien_doan]", tptd.toString().substring(0, tptd.toString().length()-1));
				}
				//else{
				//	word.put("[ten_thanh_vien_doan]", defaultPrint.toString());
				//}
				word.put("[dv_co_tai_lieu_niem_phong]", cuocTtkt.getTenDonViBi());
				//Don vi ca nhan co tai lieu niem phong
				table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arr = form.getDsCacOb();
				StringBuffer tptd1 = new StringBuffer("");
				if (arr != null && arr.length > 0) {
					for (int i = 0; i < arr.length; i++) {
						tptd1.append(KtnbUtil.layoutTableHoTen(arr[i].getHoTen()));
						tptd1.append(KtnbUtil.layoutTableChucVu(arr[i].getChucVu()));
						tptd1.append("\n");
						word.addCellTable(table, i+1, 1, "- \u00D4ng (b\u00E0): " + arr[i].getHoTen());
						word.addCellTable(table, i+1, 2, "- Ch\u1EE9c v\u1EE5: " + arr[i].getChucVu());
						word.addRowTable(table,arr.length);
					}
					System.out.println(tptd1.toString());
					//word.put("[ten_thanh_vien_dv]", tptd1.toString().substring(0, tptd1.toString().length()-1));
				}
				//word.put("[ngay_mo_niem_phong]", KtnbUtil.getDay(form.getThoiGianNPTu()));
				word.put("[ngay_mo_niem_phong]", KtnbUtil.getHour(form.getVaoLucBienBanNP()));
				word.put("[tinh_trang_tai_lieu]", form.getTinhTrangDauNiemPhong());
				if(Formater.isNull(form.getDonViBaoQuanSauNP()))
					word.put("[dv_nguoi_dc_quan_ly]", "...");
				else
					word.put("[dv_nguoi_dc_quan_ly]", form.getDonViBaoQuanSauNP());
				word.put("[ket_thuc_niem_phong]", KtnbUtil.getHour(form.getThoiGianHoanThanhMoNP()));
				//word.put("ket_thuc_niem_phong", KtnbUtil.getHour(form.getThoiGianHoanThanhMoNP()));
				//word.put("[cac_tai_lieu]", form.getLoaiTaiLieuBBNP());
				//word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB25", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}
			
		} else if ("inBienBan".equals(type)) {
			fileIn = request.getRealPath("/docin") + "\\TTNB23.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB23_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			fileTemplate = "ttnb23";
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", app.getTenCqt().toUpperCase());
				word.put("[doan_ttkt_so]", sbT.toString().toUpperCase());
				//word.put("[ten_bc]", sb.toString());
				word.put("[ngay_niem_phong]", Formater.getDateForPrint(form.getNgayRaQDNP()));
				word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qdinh]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong_qd]", KtnbUtil.getTenThuTruongCqtForMauin(app));
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqt(app));
				word.put("[thoi_gian_lap_bien_ban]", Formater.getDateTimeForPrint(form.getVaoLucBienBanNP()));
				word.put("[dia_diem]", form.getTaiDiaDiemNP());
				word.put("[ttkt]", hinhThuc);
				//doan thanh tra kiem tra
				//khoi tao table trong Msword
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrthanhphanbg = form.getDsTVD();
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
					//word.put("[thanh_vien]", tptd.toString().substring(0, tptd.toString().length()-1));
				}
				//else{
				//	word.put("[thanh_vien]",defaultPrint.toString());
				//}
				//Don vi ca nhan co tai lieu niem phong
				table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arr = form.getDsDvCoTlnp();
				StringBuffer tptd1 = new StringBuffer("");
				if (arr != null && arr.length > 0) {
					for (int i = 0; i < arr.length; i++) {
						tptd1.append(KtnbUtil.layoutTableHoTen(arr[i].getHoTen()));
						tptd1.append(KtnbUtil.layoutTableChucVu(arr[i].getChucVu()));
						tptd1.append("\n");
						word.addCellTable(table, i+1, 1, "- \u00D4ng (b\u00E0): " + arr[i].getHoTen());
						word.addCellTable(table, i+1, 2, "- Ch\u1EE9c v\u1EE5: " + arr[i].getChucVu());
						word.addRowTable(table,arr.length);
					}
					//word.put("[thanh_vien_dv]", tptd1.toString().substring(0, tptd1.toString().length()-1));
				}
				word.put("[tai_lieu_niem_phong]", form.getTienHanhNPCacTaiLieu());
				word.put("[dv_quan_ly]", form.getDinViCaNhanBaoQuanBbNp());
				word.put("[thoi_gian_ket_thuc]", Formater.getDateTimeForPrint(form.getThoiGianHoanThanhNP()));
				//word.put("[thu_truong_qd]", KtnbUtil.getTenThuTruongCqt(app));
				word.put("[ttkt]", hinhThuc.toUpperCase());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB23", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}
			
		}
	}

	//v4
	private void inNiemPhongHsTl(HttpServletRequest request, HttpServletResponse reponse, NiemPhongHoSoTaiLieuForm form, ApplicationContext app, String idCuocTtKt) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;
		StringBuffer defaultPrint = new StringBuffer("\u00D4ng (B\u00E0)................             Ch\u1EE9c v\u1EE5:...............");
		defaultPrint.append("\n\u00D4ng (B\u00E0)................             Ch\u1EE9c v\u1EE5:...............");
		defaultPrint.append("\n......................................................................................");
		
		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, idCuocTtKt);
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtKt, app);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
		String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
		StringBuffer sb = new StringBuffer(hinhThuc);
		
		StringBuffer sbT = new StringBuffer("\u0110O\u00C0N ");
		sbT.append(hinhthuc_inT);
		sbT.append(" Q\u0110 S\u1ED0 ");
		sbT.append(cbQd.getSoQuyetDinh());
		if ("inQDNP".equals(type)) {
			// in quyet dinh niem phong
			fileIn = request.getRealPath("/docin/v4") + "\\TTNB22.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB22_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			fileTemplate = "ttnb22";
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", app.getTenCqt().toUpperCase());
				word.put("[doan_ttkt_so]", sbT.toString().toUpperCase());
				if (Formater.isNull(form.getNoiRaQDNP()) && Formater.isNull(form.getNgayRaQDNP())) {
					word.put("[noi_ra_quyet_dinh]", ".....");
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else if (!Formater.isNull(form.getNoiRaQDNP()) && !Formater.isNull(form.getNgayRaQDNP())) {
					word.put("[noi_ra_quyet_dinh]", form.getNoiRaQDNP());
					word.put("[ngay_ra_qd]", Formater.getDateForPrint(form.getNgayRaQDNP()));
				} else if (Formater.isNull(form.getNoiRaQDNP()) && !Formater.isNull(form.getNgayRaQDNP())) {
					word.put("[noi_ra_quyet_dinh]", ".....");
					word.put("[ngay_ra_qd]", Formater.getDateForPrint(form.getNgayRaQDNP()));
				} else if (!Formater.isNull(form.getNoiRaQDNP()) && Formater.isNull(form.getNgayRaQDNP())) {
					word.put("[noi_ra_quyet_dinh]", form.getNoiRaQDNP());
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				}
				//word.put("[ttkt]", sb.toString().toUpperCase());
				word.put("[so_ttkt]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())).toUpperCase());
				word.put("[thu_truong]", KtnbUtil.getTenThuTruongCqtForMauin(app).toUpperCase());
				//word.put("[ttkt]", sb.toString());
				word.put("[so_ttkt]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong]", KtnbUtil.getTenThuTruongCqtForMauin(app));
				//word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[loai_tai_lieu_dc_niem_phong]", form.getLoaiTaiLieuQDNP());
				word.put("[thoi_gian_niem_phong]", KtnbUtil.getHour(form.getThoiGianNPTu()));
				word.put("[dv_dc_giao_thuc_hien]", form.getTenCanBoDvCnTh());
				word.put("[dv_dc_giao_bao_quan]", form.getDinViCaNhanBaoQuanQdNp());
				word.put("[dv_dc_giao_thuc_hien]", form.getTenCanBoDvCnTh());
				word.put("[dv_dc_giao_bao_quan]", form.getDinViCaNhanBaoQuanQdNp());
				word.put("[thu_truong_dv_dc_niem_phong]", KtnbUtil.getChucVuThuTruongByMaCqt(cuocTtkt.getIdDonViBi()) + " " + cuocTtkt.getTenDonViBi());
				//word.put("[ttkt]", sb.toString().toUpperCase());
				// word.put("dv_co_tai_lieu_niem_phong", form.getd);
				//word.put("[so_qd]", cbQd.getSoQuyetDinh());
				//word.put("[noi_ra_qd]", cbQd.getDiaDiemRaQuyetDinh());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				System.out.println("ten truong doan :"+cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB22", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}finally {				
				try { 
					word.saveAndClose();
				} catch (Exception e) {
					
				}
			}
			
		} else if ("inQDMoNP".equals(type)) {
			// in quyet dinh mo niem phong
			fileIn = request.getRealPath("/docin") + "\\TTNB24.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB24_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			fileTemplate = "ttnb24";
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", app.getTenCqt().toUpperCase());
				word.put("[doan_ttkt_so]", sbT.toString().toUpperCase());
				word.put("[ttkt]", sb.toString().toUpperCase());
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())).toUpperCase());
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(app).toUpperCase());
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(app));
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[dv_dc_bao_quan_tai_lieu]", form.getDonViBaoQuanSauNP());
				word.put("[ttkt]", sb.toString());
				word.put("[thoi_gian_quyet_dinh]", Formater.getDateForPrint(form.getNgayRaQDNP()));
				word.put("[dv_dc_giao_nhiem_vu_mo]", form.getTenNguoiMoNp());
				word.put("[dv_bao_quan_sau_khi_mo]", form.getDonViBaoQuanSauNP());
				word.put("[dv_dc_bao_quan_tai_lieu]", form.getDonViBaoQuanSauNP());
				if(Formater.isNull(form.getTenNguoiMoNp()))
					word.put("[dv_dc_giao_nhiem_vu_mo]", "");
				else
					word.put("[dv_dc_giao_nhiem_vu_mo]", form.getTenNguoiMoNp()+",");
				word.put("[dv_bao_quan_sau_khi_mo]", form.getDonViBaoQuanSauNP());
				word.put("[dv_co_tai_lieu_niem_phong]", KtnbUtil.getChucVuThuTruongByMaCqt(cuocTtkt.getIdDonViBi()) + " " + cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", hinhThuc.toUpperCase());
				//word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqt(app).toUpperCase());
				//word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB24", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}
		} else if ("inBienBanMo".equals(type)) {
			fileIn = request.getRealPath("/docin") + "\\TTNB25.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB25_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			fileTemplate = "ttnb25";
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", app.getTenCqt().toUpperCase());
				word.put("[doan_ttkt_so]", sbT.toString().toUpperCase());
				//word.put("[ten_bc]", sb.toString());
				// word.put("so_qd_niem_phong", sb.toString());
				word.put("[ngay_qd_niem_phong]", Formater.getDateForPrint(form.getNgayRaQDMoNP()));
				//word.put("ngay_qd_niem_phong", Formater.getDateForPrint(form.getNgayRaQDMoNP()));
				word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(app));
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[thoi_gian_mo_niem_phong]", KtnbUtil.getHour(form.getVaoLucBienBanMoNP()));
				word.put("[dia_diem_mo_niem_phong]", form.getDiaDiemBienBanMoNP());
				//word.put("[dia_diem_niem_phong]", form.getDiaDiemBienBanMoNP());
				word.put("[ttkt]", hinhThuc);
				//doan thanh tra kiem tra
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrthanhphanbg = form.getDsTVD2();
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
					//word.put("[ten_thanh_vien_doan]", tptd.toString().substring(0, tptd.toString().length()-1));
				}
				//else{
				//	word.put("[ten_thanh_vien_doan]", defaultPrint.toString());
				//}
				word.put("[dv_co_tai_lieu_niem_phong]", cuocTtkt.getTenDonViBi());
				//Don vi ca nhan co tai lieu niem phong
				table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arr = form.getDsCacOb();
				StringBuffer tptd1 = new StringBuffer("");
				if (arr != null && arr.length > 0) {
					for (int i = 0; i < arr.length; i++) {
						tptd1.append(KtnbUtil.layoutTableHoTen(arr[i].getHoTen()));
						tptd1.append(KtnbUtil.layoutTableChucVu(arr[i].getChucVu()));
						tptd1.append("\n");
						word.addCellTable(table, i+1, 1, "- \u00D4ng (b\u00E0): " + arr[i].getHoTen());
						word.addCellTable(table, i+1, 2, "- Ch\u1EE9c v\u1EE5: " + arr[i].getChucVu());
						word.addRowTable(table,arr.length);
					}
					System.out.println(tptd1.toString());
					//word.put("[ten_thanh_vien_dv]", tptd1.toString().substring(0, tptd1.toString().length()-1));
				}
				//word.put("[ngay_mo_niem_phong]", KtnbUtil.getDay(form.getThoiGianNPTu()));
				word.put("[ngay_mo_niem_phong]", KtnbUtil.getHour(form.getVaoLucBienBanNP()));
				word.put("[tinh_trang_tai_lieu]", form.getTinhTrangDauNiemPhong());
				if(Formater.isNull(form.getDonViBaoQuanSauNP()))
					word.put("[dv_nguoi_dc_quan_ly]", "...");
				else
					word.put("[dv_nguoi_dc_quan_ly]", form.getDonViBaoQuanSauNP());
				word.put("[ket_thuc_niem_phong]", KtnbUtil.getHour(form.getThoiGianHoanThanhMoNP()));
				//word.put("ket_thuc_niem_phong", KtnbUtil.getHour(form.getThoiGianHoanThanhMoNP()));
				//word.put("[cac_tai_lieu]", form.getLoaiTaiLieuBBNP());
				//word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB25", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}
			
		} else if ("inBienBan".equals(type)) {
			fileIn = request.getRealPath("/docin/v4") + "\\TTNB23.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB23_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			fileTemplate = "ttnb23";
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", app.getTenCqt().toUpperCase());
				word.put("[doan_ttkt_so]", sbT.toString().toUpperCase());
				//word.put("[ten_bc]", sb.toString());
				word.put("[ngay_niem_phong]", Formater.getDateForPrint(form.getNgayRaQDNP()));
				//word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qdinh]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong_qd]", KtnbUtil.getTenThuTruongCqtForMauin(app));
				//word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqt(app));
				word.put("[thoi_gian_lap_bien_ban]", Formater.getDateTimeForPrint(form.getVaoLucBienBanNP()));
				word.put("[dia_diem]", form.getTaiDiaDiemNP());
				//word.put("[ttkt]", hinhThuc);
				//doan thanh tra kiem tra
				//khoi tao table trong Msword
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrthanhphanbg = form.getDsTVD();
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
					//word.put("[thanh_vien]", tptd.toString().substring(0, tptd.toString().length()-1));
				}
				//else{
				//	word.put("[thanh_vien]",defaultPrint.toString());
				//}
				//Don vi ca nhan co tai lieu niem phong
				table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arr = form.getDsDvCoTlnp();
				StringBuffer tptd1 = new StringBuffer("");
				if (arr != null && arr.length > 0) {
					for (int i = 0; i < arr.length; i++) {
						tptd1.append(KtnbUtil.layoutTableHoTen(arr[i].getHoTen()));
						tptd1.append(KtnbUtil.layoutTableChucVu(arr[i].getChucVu()));
						tptd1.append("\n");
						word.addCellTable(table, i+1, 1, "- \u00D4ng (b\u00E0): " + arr[i].getHoTen());
						word.addCellTable(table, i+1, 2, "- Ch\u1EE9c v\u1EE5: " + arr[i].getChucVu());
						word.addRowTable(table,arr.length);
					}
					//word.put("[thanh_vien_dv]", tptd1.toString().substring(0, tptd1.toString().length()-1));
				}
				word.put("[tai_lieu_niem_phong]", form.getTienHanhNPCacTaiLieu());
				word.put("[dv_quan_ly]", form.getDinViCaNhanBaoQuanBbNp());
				word.put("[thoi_gian_ket_thuc]", Formater.getDateTimeForPrint(form.getThoiGianHoanThanhNP()));
				//word.put("[thu_truong_qd]", KtnbUtil.getTenThuTruongCqt(app));
				//word.put("[ttkt]", hinhThuc.toUpperCase());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB23", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}
			
		}
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

}
