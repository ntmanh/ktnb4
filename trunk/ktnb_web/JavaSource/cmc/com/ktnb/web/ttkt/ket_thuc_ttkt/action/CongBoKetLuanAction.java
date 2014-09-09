package cmc.com.ktnb.web.ttkt.ket_thuc_ttkt.action;

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

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.ket_thuc_ttkt.TtktKtBbCongBoKetLuan;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBbChitietvatonghop;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.ket_thuc_ttkt.form.CongBoKetLuanForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;

import com.jacob.com.Dispatch;

/**
 * @version 1.0
 * @author
 */
public class CongBoKetLuanAction extends BaseDispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String cuocTtktId = request.getParameter("idCuocTtkt");
		CongBoKetLuanForm congBoKetLuanForm = (CongBoKetLuanForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String method = request.getParameter("method");
		if (cuocTtktId == null) {
			cuocTtktId = congBoKetLuanForm.getIdCuocTtkt();
		}
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtkTrongQd(appContext, cuocTtktId);
		request.setAttribute("maCqtTh", appContext.getMaCqt());
		request.setAttribute("maCqtDuocTtkt", cuocTtkt.getIdDonViBi());

		loadDsTvDoan(cuocTtktId, request);
		if ("save".equals(method)) {
			try {
				saveCongBoKL(request, appContext, congBoKetLuanForm);
				request.setAttribute("save", "ok");
			} catch (Exception err) {
				throw err;
			}

		} else if ("in".equals(method)) {
			inCongBoKL(request, response, congBoKetLuanForm, appContext, cuocTtktId);
			return null;
		} else {
			loadDefaulForm(congBoKetLuanForm, appContext, cuocTtktId);
			if (!KtnbUtil.haveRoleNv(appContext) || appContext.getTrangThaiCuocTtkt(cuocTtktId).equals(Constants.TT_TTKT_KT))
				request.setAttribute("readOnly", "true");
		}
		try {
			request.setAttribute("ngayRaKetLuanSv", TtktService.getKetLuan(appContext, cuocTtktId).getTgianThTuNgayStr());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mapping.findForward("success");
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
		request.setAttribute("cbChiTietDsTvd", cbDsThanhVienDoan);
		request.setAttribute("dsIdThanhVienDoan", dsIdThanhVienDoan.substring(0, dsIdThanhVienDoan.length()));
		request.setAttribute("dsChucVuTrongDoan", dsChucVuTrongDoan.substring(0, dsChucVuTrongDoan.length()));
		request.setAttribute("chiTietDsTvd", dsThanhVienDoan);
	}

	private void loadDefaulForm(CongBoKetLuanForm form, ApplicationContext appContext, String cuocTtktId) throws Exception {
		TtktKtBbCongBoKetLuan congBoQd = TtktCnPhuService.getCongBoKl(appContext, cuocTtktId);
		if (congBoQd != null) {
			form.setDiaDiem(congBoQd.getDiaDiem());
			form.setIdCongBoQuyetDinh(congBoQd.getId());
			form.setIdCuocTtkt(congBoQd.getIdCuocTtkt());
			form.setIdDaiDienCqBanHanhQd(congBoQd.getTpThamDuCqtTienHanh());
			form.setIdDaiDienCqqlCapTren(congBoQd.getTpThamDuCquanTchucCnhan());
			form.setIdDaiDienDoanTtkt(congBoQd.getTpThamDuDoanTtkt());
			form.setIdDaiDienDonViDuocTtkt(congBoQd.getTpThamDuDviDuocTtkt());
			form.setNgayLap(Formater.date2str(congBoQd.getNgayLap()));
			form.setNoiLap(congBoQd.getNoiLap());
			form.setThoiDiemCongBo(Formater.date2strDateTimeForNV(congBoQd.getThoiDiemCongBo()));
			form.setYkienPhatBieu(congBoQd.getYkDaiDienCqTienHanh());
			form.setYkDaiDienCqtBiTtkt(congBoQd.getYkDaiDienCqtBiTtkt());
			form.setYkCqqlCapTrenCuaDtuong(congBoQd.getYkCqqlCapTrenCuaDtuong());
			form.setThoiDiemKetThuc(Formater.date2strDateTimeForNV(congBoQd.getThoiDiemKetThuc()));
			// Dai dien cqql cap tren
			ArrayList list = (ArrayList) congBoQd.getDsTptdCquanTchucCnhan();
			if (!Formater.isNull(list)) {
				TtktCmThanhPhanThamDu[] arrDaiDienCqqlCapTren = new TtktCmThanhPhanThamDu[list.size()];
				for (int i = 0; i < list.size(); i++)
					arrDaiDienCqqlCapTren[i] = (TtktCmThanhPhanThamDu) list.get(i);
				form.setArrDaiDienCqqlCapTren(arrDaiDienCqqlCapTren);
			}

			// Dai dien cqql cap tren
			list = (ArrayList) congBoQd.getDsTptdCqtTienHanh();
			if (!Formater.isNull(list)) {
				TtktCmThanhPhanThamDu[] arrDaiDienCqtBanHanhQD = new TtktCmThanhPhanThamDu[list.size()];
				for (int i = 0; i < list.size(); i++)
					arrDaiDienCqtBanHanhQD[i] = (TtktCmThanhPhanThamDu) list.get(i);
				form.setArrDaiDienCqtBanHanhQD(arrDaiDienCqtBanHanhQD);
			}

			// Dai dien doan ttkt
			list = (ArrayList) congBoQd.getDsTptdDoanTtkt();
			if (!Formater.isNull(list)) {
				TtktCmThanhPhanThamDu[] arrDaiDienDoanTtkt = new TtktCmThanhPhanThamDu[list.size()];
				for (int i = 0; i < list.size(); i++)
					arrDaiDienDoanTtkt[i] = (TtktCmThanhPhanThamDu) list.get(i);
				form.setArrDaiDienDoanTtkt(arrDaiDienDoanTtkt);
			}
			// Dai dien doan ttkt
			list = (ArrayList) congBoQd.getDsTptdDviDuocTtkt();
			if (!Formater.isNull(list)) {
				TtktCmThanhPhanThamDu[] arrDaiDienDonViDuocTtkt = new TtktCmThanhPhanThamDu[list.size()];
				for (int i = 0; i < list.size(); i++)
					arrDaiDienDonViDuocTtkt[i] = (TtktCmThanhPhanThamDu) list.get(i);
				form.setArrDaiDienDonViDuocTtkt(arrDaiDienDonViDuocTtkt);
			}

		} else {
			form.setDiaDiem(KtnbUtil.getTenTinhByMaCqt(appContext, CuocTtktService.getCuocTtkt(appContext, cuocTtktId).getIdDonViBi()));
			form.setIdCuocTtkt(cuocTtktId);

		}
	}

	private void saveCongBoKL(HttpServletRequest request, ApplicationContext appContext, CongBoKetLuanForm form) throws Exception {
		TtktKtBbCongBoKetLuan congBoKL = createCongBoQd(appContext, form);
		TtktCnPhuService.saveCongBoKetLuan(appContext, congBoKL);

	}

	private TtktKtBbCongBoKetLuan createCongBoQd(ApplicationContext appContext, CongBoKetLuanForm form) throws Exception {
		// Load thong tin chung
		// TtktKhCuocTtkt cuocTtkt =
		// CuocTtktService.getCuocTtktWithoutNoiDung(appContext, cuocTtktId);
		// String tendvBi = cuocTtkt.getTenDonViBi();
		TtktKtBbCongBoKetLuan congBoKL = new TtktKtBbCongBoKetLuan();

		congBoKL.setId(form.getIdCongBoQuyetDinh());
		congBoKL.setIdCuocTtkt(form.getIdCuocTtkt());
		congBoKL.setThoiDiemCongBo(Formater.str2dateForNV(form.getThoiDiemCongBo()));
		congBoKL.setThoiDiemKetThuc(Formater.str2dateForNV(form.getThoiDiemKetThuc()));
		congBoKL.setNgayLap(Formater.str2date(form.getNgayLap()));
		congBoKL.setDiaDiem(form.getDiaDiem());
		congBoKL.setYkDaiDienCqTienHanh(form.getYkienPhatBieu());
		congBoKL.setYkCqqlCapTrenCuaDtuong(form.getYkCqqlCapTrenCuaDtuong());
		congBoKL.setYkDaiDienCqtBiTtkt(form.getYkDaiDienCqtBiTtkt());
		congBoKL.setNoiLap(form.getNoiLap());
		congBoKL.setIdNguoiCapNat(appContext.getMaCanbo());
		congBoKL.setTenNguoiCapNhat(appContext.getTenCanbo());
		congBoKL.setNgayCapNhat(new Date());
		// Dai dien co quan ban hanh Qd
		congBoKL.setTpThamDuCqtTienHanh(form.getIdDaiDienCqBanHanhQd());
		TtktCmThanhPhanThamDu[] arrDaiDienCqtBanHanhQd = form.getArrDaiDienCqtBanHanhQD();
		if (arrDaiDienCqtBanHanhQd != null && arrDaiDienCqtBanHanhQd.length > 0) {
			ArrayList dsDaiDienCqtBanHanhQd = new ArrayList();
			for (int i = 0; i < arrDaiDienCqtBanHanhQd.length; i++)
				dsDaiDienCqtBanHanhQd.add(arrDaiDienCqtBanHanhQd[i]);
			congBoKL.setDsTptdCqtTienHanh(dsDaiDienCqtBanHanhQd);
		}

		// Dai dien co quan quan ly cap tren
		congBoKL.setTpThamDuCquanTchucCnhan(form.getIdDaiDienCqqlCapTren());
		TtktCmThanhPhanThamDu[] arrDaiDienCqQlCapTren = form.getArrDaiDienCqqlCapTren();
		if (arrDaiDienCqQlCapTren != null && arrDaiDienCqQlCapTren.length > 0) {
			ArrayList dsDaiDienCqQlCapTren = new ArrayList();
			for (int i = 0; i < arrDaiDienCqQlCapTren.length; i++)
				dsDaiDienCqQlCapTren.add(arrDaiDienCqQlCapTren[i]);
			congBoKL.setDsTptdCquanTchucCnhan(dsDaiDienCqQlCapTren);
		}

		// Dai dien doan Ttkt
		congBoKL.setTpThamDuDoanTtkt(form.getIdDaiDienDoanTtkt());
		TtktCmThanhPhanThamDu[] arrDaiDienDoanTtkt = form.getArrDaiDienDoanTtkt();
		if (arrDaiDienDoanTtkt != null && arrDaiDienDoanTtkt.length > 0) {
			ArrayList dsDaiDienDoanTtkt = new ArrayList();
			for (int i = 0; i < arrDaiDienDoanTtkt.length; i++)
				dsDaiDienDoanTtkt.add(arrDaiDienDoanTtkt[i]);
			congBoKL.setDsTptdDoanTtkt(dsDaiDienDoanTtkt);
		}

		// Don vi duoc Ttkt
		congBoKL.setTpThamDuDviDuocTtkt(form.getIdDaiDienDonViDuocTtkt());
		TtktCmThanhPhanThamDu[] arrDaiDienDvDuocTtkt = form.getArrDaiDienDonViDuocTtkt();
		if (arrDaiDienDvDuocTtkt != null && arrDaiDienDvDuocTtkt.length > 0) {
			ArrayList dsDaiDienDvDuocTtkt = new ArrayList();
			for (int i = 0; i < arrDaiDienDvDuocTtkt.length; i++)
				dsDaiDienDvDuocTtkt.add(arrDaiDienDvDuocTtkt[i]);
			congBoKL.setDsTptdDviDuocTtkt(dsDaiDienDvDuocTtkt);
		}

		return congBoKL;
	}

	private void inCongBoKL(HttpServletRequest request, HttpServletResponse reponse, CongBoKetLuanForm form, ApplicationContext app, String idCuocTtKt) throws Exception {
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtkTrongQd(app, idCuocTtKt);
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtKt, app);
		TtktCmThanhPhanThamDu[] arrthanhphanbg1 = form.getArrDaiDienCqtBanHanhQD();
		TtktCmThanhPhanThamDu[] arrthanhphanbg4 = form.getArrDaiDienCqqlCapTren();
		String fileIn = "";
		String fileOut = "";
		StringBuffer tptd = new StringBuffer("");
		Dispatch table = new Dispatch();
		// cbQd.get
		if (arrthanhphanbg1 != null && arrthanhphanbg4 != null) {
			fileIn = request.getRealPath("/docin") + "\\TTNB39.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB39_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
		}
		if (arrthanhphanbg1 == null && arrthanhphanbg4 != null) {
			fileIn = request.getRealPath("/docin") + "\\TTNB39_1.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB39_1_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
		}
		if (arrthanhphanbg1 != null && arrthanhphanbg4 == null) {
			fileIn = request.getRealPath("/docin") + "\\TTNB39_2.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB39_2_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
		}
		if (arrthanhphanbg1 == null && arrthanhphanbg4 == null) {
			fileIn = request.getRealPath("/docin") + "\\TTNB39_3.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB39_3_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
		}
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "Ki\u1EC3m tra" : "thanh tra";
		String hinhThuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
		StringBuffer sb = new StringBuffer(hinhThuc);
		sb = new StringBuffer("\u0110o\u00E0n");
		sb.append(hinhThuc_in);
		sb.append(" Q\u0110 S\u1ED1");
		sb.append(cbQd.getSoQuyetDinh());

		MsWordUtils word = new MsWordUtils(fileIn, fileOut);
		try {
			word.put("[ten_cqt]", app.getTenCqt().toUpperCase());
			word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
			if (form.getDiaDiem().equals("") || form.getThoiDiemCongBo().equals("")) {
				word.put("[noi_ra_thong_bao]", ".....");
				word.put("[ngay_thong_bao]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			} else {
				word.put("[noi_ra_thong_bao]", form.getDiaDiem());
				word.put("[ngay_thong_bao]", KtnbUtil.getDay(form.getThoiDiemCongBo()));
			}
			word.put("[ttkt]", hinhThuc);

			word.put("[thoi_diem_cong_bo]", KtnbUtil.getHour(form.getThoiDiemCongBo()));
			// -- parameters.put("noi_ra_thong_bao", form.getDiaDiem());
			// -- parameters.put("ngay_thong_bao", KtnbUtil.getDay(
			// form.getThoiDiemCongBo()));
			word.put("[dia_diem]", form.getDiaDiem());
			word.put("[ttkt]", hinhThuc);
			word.put("[ttkt]", hinhThuc);
			word.put("[so_qd]", cbQd.getSoQuyetDinh());
			word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			word.put("[thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(app.getMaCqt()));
			word.put("[ttkt]", hinhThuc);
			word.put("[thu_truong_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(app.getMaCqt()));
			word.put("[ttkt]", hinhThuc);
			word.put("[ten_dv_duoc_ttkt]", cuocTtkt.getTenDonViBi());

			// thanh phan tham du don vi tien hanh ttkt
			if (arrthanhphanbg1 != null) {
				word.put("[ttkt]", hinhThuc);
				table = word.openTable(2);
				for (int i = 0; i < arrthanhphanbg1.length; i++) {
					tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg1[i].getHoTen()));
					tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg1[i].getChucVu()));
					tptd.append("\n        ");
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0\u00A0): " + arrthanhphanbg1[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbg1[i].getChucVu());
					word.addRowTable(table, arrthanhphanbg1.length);
				}
				System.out.println(tptd.toString());
			}

			// word.put("[dai_dien_cqth]", tptd.toString());
			if (arrthanhphanbg1 != null) {
				word.put("[ttkt]", hinhThuc);
				// thanh phan tham du doan ttkt
				table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arrthanhphanbg2 = form.getArrDaiDienDoanTtkt();
				tptd = new StringBuffer("");
				if (arrthanhphanbg2 != null && arrthanhphanbg2.length > 0) {
					for (int i = 0; i < arrthanhphanbg2.length; i++) {
						tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg2[i].getHoTen()));
						tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg2[i].getChucVu()));
						tptd.append("\n        ");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0\u00A0): " + arrthanhphanbg2[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbg2[i].getChucVu());
						word.addRowTable(table, arrthanhphanbg2.length);
					}
					System.out.println(tptd.toString());
					// word.put("[dai_dien_doanttkt]", tptd.toString());
				}
			} else {
				word.put("[ttkt]", hinhThuc);
				// thanh phan tham du doan ttkt
				table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrthanhphanbg2 = form.getArrDaiDienDoanTtkt();
				tptd = new StringBuffer("");
				if (arrthanhphanbg2 != null && arrthanhphanbg2.length > 0) {
					for (int i = 0; i < arrthanhphanbg2.length; i++) {
						tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg2[i].getHoTen()));
						tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg2[i].getChucVu()));
						tptd.append("\n        ");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0\u00A0): " + arrthanhphanbg2[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbg2[i].getChucVu());
						word.addRowTable(table, arrthanhphanbg2.length);
					}
					System.out.println(tptd.toString());
					// word.put("[dai_dien_doanttkt]", tptd.toString());
				}
			}
			if (arrthanhphanbg1 != null) {
				word.put("[ten_dv_duoc_ttkt]", cuocTtkt.getTenDonViBi());
				// thanh phan tham du don vi dc ttkt
				table = word.openTable(4);
				TtktCmThanhPhanThamDu[] arrthanhphanbg3 = form.getArrDaiDienDonViDuocTtkt();
				tptd = new StringBuffer("");
				if ((arrthanhphanbg3 != null && arrthanhphanbg3.length > 0)) {
					for (int i = 0; i < arrthanhphanbg3.length; i++) {
						tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg3[i].getHoTen()));
						tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg3[i].getChucVu()));
						tptd.append("\n        ");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0\u00A0): " + arrthanhphanbg3[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbg3[i].getChucVu());
						word.addRowTable(table, arrthanhphanbg3.length);
					}
					System.out.println(tptd.toString());
					// word.put("[dai_dien_dvDuocttkt]", tptd.toString());
				}
			} else {
				word.put("[ten_dv_duoc_ttkt]", cuocTtkt.getTenDonViBi());
				// thanh phan tham du don vi dc ttkt
				table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arrthanhphanbg3 = form.getArrDaiDienDonViDuocTtkt();
				tptd = new StringBuffer("");
				if ((arrthanhphanbg3 != null && arrthanhphanbg3.length > 0)) {
					for (int i = 0; i < arrthanhphanbg3.length; i++) {
						tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg3[i].getHoTen()));
						tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg3[i].getChucVu()));
						tptd.append("\n        ");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0\u00A0): " + arrthanhphanbg3[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbg3[i].getChucVu());
						word.addRowTable(table, arrthanhphanbg3.length);
					}
					System.out.println(tptd.toString());
					// word.put("[dai_dien_dvDuocttkt]", tptd.toString());
				}
			}
			if (arrthanhphanbg4 != null) {
				table = word.openTable(5);
				tptd = new StringBuffer("");
				if (arrthanhphanbg4 != null && arrthanhphanbg4.length > 0) {
					for (int i = 0; i < arrthanhphanbg4.length; i++) {
						tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg4[i].getHoTen()));
						tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg4[i].getChucVu()));
						tptd.append("\n        ");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0\u00A0): " + arrthanhphanbg4[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbg4[i].getChucVu());
						word.addRowTable(table, arrthanhphanbg4.length);
					}
					System.out.println(tptd.toString());
					// word.put("[dai_dien_cqlienquan]", tptd.toString());
				}

			}

			// thanh phan tham du co quan lien quan

			word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
			word.put("[ttkt]", hinhThuc);
			word.put("[ttkt]", hinhThuc);
			word.put("[ttkt]", hinhThuc);

			// Lay thong tin ket luan
			TtktThBbChitietvatonghop ketLuan = TtktService.getKetLuan(app, idCuocTtKt);
			if (ketLuan != null) {
				word.put("[so_kl]", ketLuan.getSoKetLuan());
				word.put("[ngay_ra_kl]", Formater.getDateForPrint(Formater.date2str(ketLuan.getTgianThTuNgay())));
			}
			word.put("[thu_truong_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(app.getMaCqt()));
			if (Formater.isNull(form.getYkienPhatBieu()))
				word.put("[y_kien1]", KtnbUtil.inFieldNull(115));
			else
				word.put("[y_kien1]", form.getYkienPhatBieu());
			if (Formater.isNull(form.getYkCqqlCapTrenCuaDtuong()))
				word.put("[y_kien2]", KtnbUtil.inFieldNull(115));
			else
				word.put("[y_kien2]", form.getYkCqqlCapTrenCuaDtuong());
			if (Formater.isNull(form.getYkDaiDienCqtBiTtkt()))
				word.put("[y_kien3]", KtnbUtil.inFieldNull(115));
			else
				word.put("[y_kien3]", form.getYkDaiDienCqtBiTtkt());
			word.put("[ttkt]", hinhThuc);
			word.put("[thoi_diem_ket_thuc]", KtnbUtil.getHour(form.getThoiDiemKetThuc()));
			// word.put("[thong_bao_ket_thuc]",
			// KtnbUtil.getHour(form.getThoiDiemKetThuc()));
			word.put("[ttkt]", hinhThuc);
			word.put("[ttkt]", hinhThuc.toUpperCase());
			word.put("[ttkt]", hinhThuc.toUpperCase());
			word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau TTNB39", ".doc", reponse);
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
