package cmc.com.ktnb.web.ttkt.dung_chung.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktKtChuyenGiaoHsVv;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThGiaHan;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThKiemTraXacMinh;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThPhucTra;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThQdKiemKe;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThQdNiemPhongHsTl;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThTrungCauGiamDinh;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThYcBsHstl;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThYeuCauGiaiTrinh;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;

/**
 * @version 1.0
 * @author
 */
public class DanhSachTimKiemAction extends DispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		ApplicationContext app = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String type = request.getParameter("type");
		request.setAttribute("type", type);

		String cuocTtktId = request.getParameter("idCuocTtkt");
		request.setAttribute("idCuocTtkt", cuocTtktId);
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, cuocTtktId);
		if (!cuocTtkt.getIdTruongDoan().equals(app.getMaCanbo()) || app.getTrangThaiCuocTtkt(cuocTtktId).equals(Constants.TT_TTKT_KT)) {
			request.setAttribute("readOnly", "true");
		}

		if (!KtnbUtil.isTruongDoan(app.getMaCanbo(), app, cuocTtktId)|| app.getTrangThaiCuocTtkt(cuocTtktId).equals(Constants.TT_TTKT_KT))
			request.setAttribute("readOnly", "true");
		String act = request.getParameter("act");
		String id = request.getParameter("id");
		if (type.equals("thayDoiThanhVienDoan")) {
			if ("delete".equals(act)) {
				TtktService.deleteThayDoiTvd(app, TtktService.getThayDoiThanhVienDoan(app, id));
			} else {
				Collection dsThayDoiTvd = (Collection) request.getSession().getAttribute("dsThayDoiTvd");
				if (Formater.isNull(dsThayDoiTvd)) {
					dsThayDoiTvd = TtktService.getDsThayDoiTvd(app, cuocTtktId);
					request.setAttribute("dsThayDoiTvd", dsThayDoiTvd);

				} else {
					request.setAttribute("dsThayDoiTvd", dsThayDoiTvd);
					request.getSession().removeAttribute("dsThayDoiTvd");
				}
				return mapping.findForward("success");
			}

		} else if (type.equals("giaHan")) {
			Collection dsGiaHan = (Collection) request.getSession().getAttribute("dsGiaHan");
			if (Formater.isNull(dsGiaHan)) {
				loadGiaHan(request, cuocTtktId, app, response);
			} else {
				request.setAttribute("dsGiaHan", dsGiaHan);
				request.getSession().removeAttribute("dsGiaHan");
			}

		} else if (type.equals("kkTS")) {
			Collection dsGiaHan = (Collection) request.getSession().getAttribute("dsKkTs");
			if (Formater.isNull(dsGiaHan)) {
				loadKKTS(request, cuocTtktId, app, response);
			} else {
				request.setAttribute("dsKkTs", dsGiaHan);
				request.getSession().removeAttribute("dsKkTs");
			}

		} else if (type.equals("yeucaucungcapHSTL")) {
			Collection dsYeuCauBaoCaoHsTl = (Collection) request.getSession().getAttribute("dsYeuCauBaoCaoHsTl");
			if (Formater.isNull(dsYeuCauBaoCaoHsTl)) {
				dsYeuCauBaoCaoHsTl = TtktCnPhuService.getDSYeuCauBaoCaoHsTl(app, cuocTtktId);
			} else {
				request.getSession().removeAttribute("dsYeuCauBaoCaoHsTl");
			}
			request.setAttribute("dsYeuCauBaoCaoHsTl", dsYeuCauBaoCaoHsTl);

		} else if (type.equals("yeuCauGiaiTrinh")) {
			Collection dsYCGiaiTrinh = (Collection) request.getSession().getAttribute("dsYCGiaiTrinh");
			if (Formater.isNull(dsYCGiaiTrinh)) {
				dsYCGiaiTrinh = TtktCnPhuService.getDsYCGiaiTrinh(app, cuocTtktId);
			} else {
				//request.getSession().removeAttribute("dsYeuCauBaoCaoHsTl");
				request.getSession().removeAttribute("dsYCGiaiTrinh");
			}
			request.setAttribute("dsYCGiaiTrinh", dsYCGiaiTrinh);

		} else if (type.equals("bienBanLamViecTrongQTTienHanh")) {
			Collection dsBienBanLamViec = (Collection) request.getSession().getAttribute("dsBienBanLamViec");
			if (Formater.isNull(dsBienBanLamViec)) {
				dsBienBanLamViec = TtktCnPhuService.getBienBanLamViecTrongQtTienHanh(app, cuocTtktId);
			} else {
				request.getSession().removeAttribute("dsBienBanLamViec");
			}
			request.setAttribute("dsBienBanLamViec", dsBienBanLamViec);
		} else if (type.equals("tcGiamDinh")) {

			Collection dsTcGiamDinh = (Collection) request.getSession().getAttribute("dsTcGiamDinh");
			if (Formater.isNull(dsTcGiamDinh)) {
				dsTcGiamDinh = TtktCnPhuService.getDsTCGiamDinh(app, cuocTtktId);
			} else {
				request.getSession().removeAttribute("dsTcGiamDinh");
			}
			request.setAttribute("dsTCGiamDinh", dsTcGiamDinh);
		} else if (type.equals("ktXacMinh")) {
			Collection dsKtXacMinh = (Collection) request.getSession().getAttribute("dsKtXacMinh");
			if (Formater.isNull(dsKtXacMinh)) {
				dsKtXacMinh = TtktCnPhuService.getDsKTXacMinh(app, cuocTtktId);
			} else {
				request.getSession().removeAttribute("dsKtXacMinh");
			}
			request.setAttribute("dsKTXacMinh", dsKtXacMinh);
		} else if (type.equals("phucTra")) {
			Collection dsPhucTra = (Collection) request.getSession().getAttribute("dsPhucTra");
			if (Formater.isNull(dsPhucTra)) {
				dsPhucTra = TtktCnPhuService.getDsPhucTra(app, cuocTtktId);
			} else {
				request.getSession().removeAttribute("dsPhucTra");
			}
			request.setAttribute("dsPhucTra", dsPhucTra);
		}else if (type.equals("bgHsVv")){
			Collection dsBanGiaoHsVv = (Collection) request.getSession().getAttribute("dsBGHoSoVuViec");
			if (Formater.isNull(dsBanGiaoHsVv)) {
				dsBanGiaoHsVv = TtktCnPhuService.getDsHSVuViec(app, cuocTtktId);
			} else {
				request.getSession().removeAttribute("dsBGHoSoVuViec");
			}
			request.setAttribute("dsBGHoSoVuViec", dsBanGiaoHsVv);
			
		}else if(type.equals("niemPhongHSTL")){
			Collection dsNiemPhongHsTl = (Collection) request.getSession().getAttribute("dsNiemPhongHsTl");
			if (Formater.isNull(dsNiemPhongHsTl)) {
				dsNiemPhongHsTl = TtktCnPhuService.getDsNiemPhongHsTl(app, cuocTtktId);
			} else {
				request.getSession().removeAttribute("dsNiemPhongHsTl");
			}
			request.setAttribute("dsNiemPhongHsTl", dsNiemPhongHsTl);
			
		}

		// request.setAttribute("idCuocTtkt", cuocTtktId);

		// ------------ Xoa du lieu -----------------
		if (act != null) {
			if ("delete".equals(act))
				if (type.equals("yeucaucungcapHSTL"))
					deleteYeuCauBaoCaoHsTl(request, id, app);
				else if (type.equals("niemPhongHSTL"))
					deleteNiemPhongHsTl(request, id, app);
				else if (type.equals("yeuCauGiaiTrinh"))
					deleteYCGiaiTrinh(request, id, app);
				else if (type.equals("ktXacMinh"))
					deleteKTXM(request, id, app);
				else if (type.equals("tcGiamDinh"))
					deleteTCGD(request, id, app);
				else if (type.equals("bgHsVv"))
					deleteBGHsVv(request, id, app);
				else if (type.equals("giaHan"))
					deleteGiaHan(request, id, app);
				else if (type.equals("kkTS"))
					deleteKkTs(request, id, app);
				else if (type.equals("phucTra"))
					deletePhucTra(request, id, app);
				else if (type.equals("bienBanLamViecTrongQTTienHanh"))
					deleteBienBanLamViec(request, id, app);

			PrintWriter out = response.getWriter();
			out.print("cucsess");
			out.flush();
			out.close();
			return null;
		}
		
		return mapping.findForward("success");

	}

	private void deleteBienBanLamViec(HttpServletRequest request, String id, ApplicationContext app) throws Exception {
		TtktCnPhuService.deleteBienBanLamViec(app, id);

	}

	// ------------------------------------- Yeu cau ho so tai lieu
	// -----------------------------------
	private void loadDsYeuCauBaoCaoHsTl(HttpServletRequest request, String idCuocTtkt, ApplicationContext app, HttpServletResponse response) throws Exception {
		Collection list = TtktCnPhuService.getDSYeuCauBaoCaoHsTl(app, idCuocTtkt);
		if (!KtnbUtil.isTruongDoan(app.getMaCanbo(), app, idCuocTtkt)) {
			if (list.size() == 1)
				response.sendRedirect("yeu_cau_cung_cap_tai_lieu.do?id=" + ((TtktThYcBsHstl) ((ArrayList) list).get(0)).getId() + "&idCuocTtkt=" + idCuocTtkt);
		}
		// response.sendRedirect("yeu_cau_cung_cap_tai_lieu.do?idCuocTtkt="+idCuocTtkt);
		request.setAttribute("dsYeuCauBaoCaoHsTl", list);
	}

	private void deleteYeuCauBaoCaoHsTl(HttpServletRequest request, String id, ApplicationContext app) throws Exception {
		TtktThYcBsHstl yC = TtktCnPhuService.getYcBsHsTl(app, id);
		TtktCnPhuService.deleteYeuCauBaoCaoHsTl(yC, request, app);
	}

	// ------------------------------------- Niem phong ho so tai lieu
	// ----------------------------------
	private void loadDsNiemPhongHsTl(HttpServletRequest request, String idCuocTtkt, ApplicationContext app, HttpServletResponse response) throws Exception {
		Collection list = TtktCnPhuService.getDsNiemPhongHsTl(app, idCuocTtkt);
		// if(Formater.isNull(list))
		// response.sendRedirect("niem_phong_ho_so_tai_lieu.do?idCuocTtkt="+idCuocTtkt);
		request.setAttribute("dsNiemPhongHsTl", list);
	}

	private void deleteNiemPhongHsTl(HttpServletRequest request, String id, ApplicationContext app) throws Exception {
		TtktThQdNiemPhongHsTl qdNP = TtktService.getQdNiemPhong(app, id);
		TtktService.deleteNiemPhongHsTl(qdNP, request, app);
	}

	// -------------------------------------- Yeu cau giai trinh
	// ---------------------------
	private void loadYCGiaiTrinh(HttpServletRequest request, String idCuocTtkt, ApplicationContext app, HttpServletResponse response) throws Exception {
		Collection list = TtktCnPhuService.getDsYCGiaiTrinh(app, idCuocTtkt);
		// if(Formater.isNull(list))
		// response.sendRedirect("yeu_cau_giai_trinh.do?idCuocTtkt="+idCuocTtkt);
		request.setAttribute("dsYCGiaiTrinh", list);
	}

	private void deleteYCGiaiTrinh(HttpServletRequest request, String id, ApplicationContext app) throws Exception {
		TtktThYeuCauGiaiTrinh qdNP = TtktCnPhuService.getYeuCauGT(app, id);
		TtktCnPhuService.deleteYCGiaiTrinh(qdNP, request, app);
	}

	// ---------------------------- Kiem tra xac minh
	// ----------------------------------------
	private void loadKTXacMinh(HttpServletRequest request, String idCuocTtkt, ApplicationContext app, HttpServletResponse response) throws Exception {
		Collection list = TtktCnPhuService.getDsKTXacMinh(app, idCuocTtkt);
		// if(Formater.isNull(list))
		// response.sendRedirect("yeu_cau_giai_trinh.do?idCuocTtkt="+idCuocTtkt);
		request.setAttribute("dsKTXacMinh", list);
	}

	private void deleteKTXM(HttpServletRequest request, String id, ApplicationContext app) throws Exception {
		TtktThKiemTraXacMinh ktXM = TtktCnPhuService.getKiemTraXacMinh(app, id);
		TtktCnPhuService.deleteKTXacMinh(ktXM, request, app);
	}

	// ------------------------ Trung cau giam dinh
	// ----------------------------------
	private void loadTCGiamDinh(HttpServletRequest request, String idCuocTtkt, ApplicationContext app, HttpServletResponse response) throws Exception {
		Collection list = TtktCnPhuService.getDsTCGiamDinh(app, idCuocTtkt);
		// if(Formater.isNull(list))
		// response.sendRedirect("yeu_cau_giai_trinh.do?idCuocTtkt="+idCuocTtkt);
		request.setAttribute("dsTCGiamDinh", list);
	}

	private void deleteTCGD(HttpServletRequest request, String id, ApplicationContext app) throws Exception {
		TtktThTrungCauGiamDinh tcGD = TtktCnPhuService.getTcGd(app, id);
		TtktCnPhuService.deleteTCGiamDinh(tcGD, request, app);
	}

	// ------------------- Ban giao ho so vu viec
	// -----------------------------------------
	private void loadBGHsVv(HttpServletRequest request, String idCuocTtkt, ApplicationContext app, HttpServletResponse response) throws Exception {
		Collection list = TtktCnPhuService.getDsHSVuViec(app, idCuocTtkt);
		request.setAttribute("dsBGHoSoVuViec", list);
	}

	private void deleteBGHsVv(HttpServletRequest request, String id, ApplicationContext app) throws Exception {
		TtktKtChuyenGiaoHsVv hsvv = TtktCnPhuService.getHoSoVv(app, id);
		TtktCnPhuService.deleteHSVuViec(hsvv, request, app);
	}

	// -------------------- gia han -------------------------

	private void loadGiaHan(HttpServletRequest request, String idCuocTtkt, ApplicationContext app, HttpServletResponse response) throws Exception {
		Collection list = TtktCnPhuService.getDsGiaHan(app, idCuocTtkt);
		request.setAttribute("dsGiaHan", list);
	}

	private void loadKkTs(HttpServletRequest request, String idCuocTtkt, ApplicationContext app, HttpServletResponse response) throws Exception {
		Collection list = TtktCnPhuService.getDsQdKk(app, idCuocTtkt);
		request.setAttribute("dsKkTs", list);
	}

	private void deleteGiaHan(HttpServletRequest request, String id, ApplicationContext app) throws Exception {
		TtktThGiaHan giaHan = TtktCnPhuService.getGiaHanTtKtById(app, id);
		TtktCnPhuService.deleteGiaHan(giaHan, request, app);
	}

	private void loadKKTS(HttpServletRequest request, String idCuocTtkt, ApplicationContext app, HttpServletResponse response) throws Exception {
		Collection list = TtktCnPhuService.getDsQdKk(app, idCuocTtkt);
		request.setAttribute("dsKkTs", list);
	}

	private void deleteKkTs(HttpServletRequest request, String id, ApplicationContext app) throws Exception {
		TtktThQdKiemKe kkts = TtktCnPhuService.getKiemKeTaiSan(app, id);
		TtktCnPhuService.deleteQdKk(kkts, request, app);
	}

	// ------------------------ phuc tra ----------------------------
	private void loadPhucTra(HttpServletRequest request, String idCuocTtkt, ApplicationContext app, HttpServletResponse response) throws Exception {
		Collection list = TtktCnPhuService.getDsPhucTra(app, idCuocTtkt);
		request.setAttribute("dsPhucTra", list);
	}

	private void deletePhucTra(HttpServletRequest request, String id, ApplicationContext app) throws Exception {
		TtktThPhucTra phucTra = TtktCnPhuService.getPhucTra(app, id);
		TtktCnPhuService.deletePhucTra(phucTra, request, app);
	}
}
