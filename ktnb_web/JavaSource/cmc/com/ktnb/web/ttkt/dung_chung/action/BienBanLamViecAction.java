/*
 * Created on Dec 20, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.dung_chung.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbDsTvDoan;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmBienBan;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThYcBsHstl;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.dung_chung.form.BienBanLamViecForm;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;

/**
 * @author Nguyen Tien Dung
 * 
 * To change the template for this generated type comment go to Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class BienBanLamViecAction extends BaseDispatchAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ApplicationContext app = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BienBanLamViecForm bbLamViecForm = (BienBanLamViecForm) form;
		String method = request.getParameter("method");
		if ("save".equals(method)) {
			save(request, reponse, bbLamViecForm, app);
			bbLamViecForm.setIdDsTvd(bbLamViecForm.getIdDsTvd());
			request.setAttribute("dsTvd", TtktService.getDsTvdById(app, bbLamViecForm.getIdDsTvd()));

			Collection loaiBienBan = new ArrayList();
			loaiBienBan.add(new LabelValueBean(Constants.TTKT_BB_HTCV, Constants.TTKT_BB_HTCV));
			loaiBienBan.add(new LabelValueBean(Constants.TTKT_BB_LVVCBLQ, Constants.TTKT_BB_LVVCBLQ));
			loaiBienBan.add(new LabelValueBean(Constants.TTKT_BB_LVVCNVCQC, Constants.TTKT_BB_LVVCNVCQC));
			request.setAttribute("loaiBienBan", loaiBienBan);

			request.setAttribute("saveStatus", "true");
		} else if ("in".equals(method)) {
			// TODO: Kiem tra xem cho nay co phai load lai lan nua khong
			in(request, reponse, bbLamViecForm, app);
			return null;
		} else {
			String cuocTtktId = request.getParameter("idCuocTtkt");
			if (!Formater.isNull(cuocTtktId)) { // Nguoi dung click chon vao link tai form main hoac mo man hinh tao moi tu form tim kiem
				if ("addnew".equals(method)) { // Tao moi tu man hinh tim kiem
					addNew(request, app, bbLamViecForm, cuocTtktId);

				} else { // Click vao link tai form main
					Collection dsBienBanLamViec = TtktCnPhuService.getBienBanLamViecTrongQtTienHanh(app, cuocTtktId);
					if (Formater.isNull(dsBienBanLamViec)) { // Truong doan them moi
						addNew(request, app, bbLamViecForm, cuocTtktId);
					} else {
						if (dsBienBanLamViec.size() == 1) {							
							// Thu truong co quan va co 1 ban ghi
							if (!app.isTruongDoan(cuocTtktId) || app.getTrangThaiCuocTtkt(cuocTtktId).equals(Constants.TT_TTKT_KT)) {
								request.setAttribute("readOnly", "true");
								TtktCmBienBan bienBan = (TtktCmBienBan) ((ArrayList) dsBienBanLamViec).get(0);
								loadDataToForm(request, app, bbLamViecForm, bienBan);
								return mapping.findForward("success");
							}
						}
						request.getSession().setAttribute("dsBienBanLamViec", dsBienBanLamViec);
						reponse.sendRedirect("danh_sach_tim_kiem.do?idCuocTtkt=" + cuocTtktId + "&type=bienBanLamViecTrongQTTienHanh");
					}
				}

			} else {
				// Truong hop xem hoac sua thi truyen id vao url
				String id = request.getParameter("id");
				loadDataToForm(request, app, bbLamViecForm, id);
				if (!KtnbUtil.haveRoleNv(app) || "view".equals(method) || app.getTrangThaiCuocTtkt(bbLamViecForm.getIdCuocTtKt()).equals(Constants.TT_TTKT_KT)) {
					request.setAttribute("readOnly", "true");
				}
			}
			try {
				request.setAttribute("tgRaQuyetDinh", Formater.objectDate2Str(TtktService.getQuyetDinh(cuocTtktId, app).getNgayRaQuyetDnh()));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return mapping.findForward("success");
	}

	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, BienBanLamViecForm bbLamViecForm, TtktCmBienBan bbLamViec) throws Exception {
		bbLamViecForm.setId(bbLamViec.getId());
		bbLamViecForm.setIdCuocTtKt(bbLamViec.getIdCuocTtkt());
		bbLamViecForm.setIdDoanTtKt(bbLamViec.getTpThamDuDoanTtkt());
		bbLamViecForm.setIdThanhphanKhac(bbLamViec.getTpThamDuKhac());
		bbLamViecForm.setThoiDiemBatDau(Formater.date2strDateTimeForNV(bbLamViec.getThoiDiemBatDau()));
		bbLamViecForm.setDiaDiem(bbLamViec.getDiaDiem());
		bbLamViecForm.setNoiDungLamViec(bbLamViec.getNoiDung());
		bbLamViecForm.setKetQua(bbLamViec.getDienBienKetQua());
		bbLamViecForm.setThoiDiemKetThuc(Formater.date2strDateTimeForNV(bbLamViec.getThoiDiemKetThuc()));
		bbLamViecForm.setLamViecVoi(bbLamViec.getLamViecVoi());
		bbLamViecForm.setLoaiBB(bbLamViec.getLoai());

		bbLamViecForm.setIdDsTvd(bbLamViec.getIdDsTvd());
		request.setAttribute("dsTvd", TtktService.getDsTvdById(app, bbLamViec.getIdDsTvd()));

		// Thanh phan Doan thanh tra kiem tra
		ArrayList dsThamDuDoanTtkt = (ArrayList) TtktCnPhuService.getThanhPhanThamDu(app, bbLamViec.getTpThamDuDoanTtkt());
		if (!Formater.isNull(dsThamDuDoanTtkt)) {
			TtktCmThanhPhanThamDu[] arrThanhPhanThamDuDoanTtkt = new TtktCmThanhPhanThamDu[dsThamDuDoanTtkt.size()];
			for (int i = 0; i < dsThamDuDoanTtkt.size(); i++)
				arrThanhPhanThamDuDoanTtkt[i] = (TtktCmThanhPhanThamDu) dsThamDuDoanTtkt.get(i);
			bbLamViecForm.setDsDoanTtKt(arrThanhPhanThamDuDoanTtkt);
		}

		// Thanh phan tham du khac
		ArrayList dsThamDuKhac = (ArrayList) TtktCnPhuService.getThanhPhanThamDu(app, bbLamViec.getTpThamDuKhac());
		if (!Formater.isNull(dsThamDuKhac)) {
			TtktCmThanhPhanThamDu[] arrThanhPhanThamDuKhac = new TtktCmThanhPhanThamDu[dsThamDuKhac.size()];
			for (int i = 0; i < dsThamDuKhac.size(); i++)
				arrThanhPhanThamDuKhac[i] = (TtktCmThanhPhanThamDu) dsThamDuKhac.get(i);
			bbLamViecForm.setDsThanhPhanKhac(arrThanhPhanThamDuKhac);
		}

		Collection loaiBienBan = new ArrayList();
		loaiBienBan.add(new LabelValueBean(Constants.TTKT_BB_HTCV, Constants.TTKT_BB_HTCV));
		loaiBienBan.add(new LabelValueBean(Constants.TTKT_BB_LVVCBLQ, Constants.TTKT_BB_LVVCBLQ));
		loaiBienBan.add(new LabelValueBean(Constants.TTKT_BB_LVVCNVCQC, Constants.TTKT_BB_LVVCNVCQC));
		request.setAttribute("loaiBienBan", loaiBienBan);

	}

	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, BienBanLamViecForm bbLamViecForm, String id) throws Exception {
		TtktCmBienBan bienBanLv = TtktCnPhuService.getBbLamViecById(app, id);
		loadDataToForm(request, app, bbLamViecForm, bienBanLv);

	}

	private void addNew(HttpServletRequest request, ApplicationContext app, BienBanLamViecForm bbLamViecForm, String cuocTtktId) throws Exception {
		bbLamViecForm.setIdCuocTtKt(cuocTtktId);
		TtktCbDsTvDoan dsTvDoan = TtktService.getDsTvd(cuocTtktId, app);
		if(dsTvDoan==null){
			dsTvDoan = TtktService.getDsTvdInQd(cuocTtktId, app);
		}
		bbLamViecForm.setIdDsTvd(dsTvDoan.getId());
		Collection dsTvd = dsTvDoan.getChiTietDanhSachTV();
		request.setAttribute("dsTvd", dsTvd);
		Collection loaiBienBan = new ArrayList();
		loaiBienBan.add(new LabelValueBean(Constants.TTKT_BB_HTCV, Constants.TTKT_BB_HTCV));
		loaiBienBan.add(new LabelValueBean(Constants.TTKT_BB_LVVCBLQ, Constants.TTKT_BB_LVVCBLQ));
		loaiBienBan.add(new LabelValueBean(Constants.TTKT_BB_LVVCNVCQC, Constants.TTKT_BB_LVVCNVCQC));
		request.setAttribute("loaiBienBan", loaiBienBan);

	}

	private void in(HttpServletRequest request, HttpServletResponse reponse, BienBanLamViecForm bbLamViecForm, ApplicationContext app) {
		// TODO Auto-generated method stub

	}

	private void save(HttpServletRequest request, HttpServletResponse reponse, BienBanLamViecForm bbLamViecForm, ApplicationContext app) throws Exception {
		TtktCmBienBan bienBanLamViec = createBienBanLamViec(bbLamViecForm, app);
		TtktCnPhuService.saveBienBanLamViec(bienBanLamViec, app);
		Collection dsTvd = TtktService.getDanhSachThanhVienDoan(bbLamViecForm.getIdCuocTtKt());
		request.setAttribute("dsTvd", dsTvd);

	}

	private TtktCmBienBan createBienBanLamViec(BienBanLamViecForm bbLamViecForm, ApplicationContext app) throws Exception {
		TtktCmBienBan bienban = new TtktCmBienBan();
		bienban.setId(bbLamViecForm.getId());
		bienban.setIdCuocTtkt(bbLamViecForm.getIdCuocTtKt());
		bienban.setTpThamDuDoanTtkt(bbLamViecForm.getIdDoanTtKt());
		bienban.setTpThamDuKhac(bbLamViecForm.getIdThanhphanKhac());
		bienban.setThoiDiemBatDau(Formater.str2dateForNV(bbLamViecForm.getThoiDiemBatDau()));
		bienban.setThoiDiemKetThuc(Formater.str2dateForNV(bbLamViecForm.getThoiDiemKetThuc()));
		bienban.setDienBienKetQua(bbLamViecForm.getKetQua());
		bienban.setNoiDung(bbLamViecForm.getNoiDungLamViec());
		bienban.setLamViecVoi(bbLamViecForm.getLamViecVoi());
		bienban.setDiaDiem(bbLamViecForm.getDiaDiem());
		bienban.setLoai(bbLamViecForm.getLoaiBB());
		bienban.setIdNguoiCapNat(app.getMaCanbo());
		bienban.setTenNguoiCapNhat(app.getTenCanbo());
		bienban.setNgayCapNhat(new Date());
		// Dai dien doan thanh tra kiem tra
		bienban.setIdDsTvd(bbLamViecForm.getIdDsTvd());
		TtktCmThanhPhanThamDu[] arrDaiDienDoanTtkt = bbLamViecForm.getDsDoanTtKt();
		if (arrDaiDienDoanTtkt != null && arrDaiDienDoanTtkt.length > 0) {
			ArrayList dsDaiDienDoanTtkt = new ArrayList();
			for (int i = 0; i < arrDaiDienDoanTtkt.length; i++)
				dsDaiDienDoanTtkt.add(arrDaiDienDoanTtkt[i]);
			bienban.setDoanTtKt(dsDaiDienDoanTtkt);
		}
		// dai dien co quan khac
		TtktCmThanhPhanThamDu[] arrDaiDienCq = bbLamViecForm.getDsThanhPhanKhac();
		if (arrDaiDienCq != null && arrDaiDienCq.length > 0) {
			ArrayList dsDaiDienCq = new ArrayList();
			for (int i = 0; i < arrDaiDienCq.length; i++)
				dsDaiDienCq.add(arrDaiDienCq[i]);
			bienban.setThanhPhanThamDu(dsDaiDienCq);
		}

		return bienban;
	}

}
