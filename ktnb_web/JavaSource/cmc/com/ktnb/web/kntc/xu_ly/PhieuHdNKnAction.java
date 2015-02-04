package cmc.com.ktnb.web.kntc.xu_ly;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import org.json.JSONArray;
import org.json.JSONObject;

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KntcBienBan;
import cmc.com.ktnb.pl.hb.entity.KntcCanBoRls;
import cmc.com.ktnb.pl.hb.entity.KntcDeXuatXly;
import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.pl.hb.entity.KntcPhieuChuyenDon;
import cmc.com.ktnb.pl.hb.entity.KntcQdinhXm;
import cmc.com.ktnb.pl.hb.entity.KtnbTlieuKemTheo;
import cmc.com.ktnb.service.kntc.KntcSoTiepDan;
import cmc.com.ktnb.service.kntc.PhanLoaiXuLyService;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.service.kntc.XacMinhService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.dung_chung.DungChungService;
import cmc.com.ktnb.web.kntc.tiep_dan.PhieuHenForm;
import cmc.com.ktnb.web.kntc.xac_minh.KeHoachForm;

/**
 * Xử lý phiếu hướng dẫn người khiếu nại
 * 
 * @author Ntthu - CMCSOFT
 * @since 18/03/2011
 */
public class PhieuHdNKnAction extends BaseDispatchAction {
	public ActionForward phieuHdNkn(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuHdNknForm phieuHDForm = (PhieuHdNknForm) form;
		phieuHDForm.setLoaiPhieu(KntcPhieuChuyenDon.PHIEU_HUONG_DAN_NKN);
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			phieuHDForm.setMaHoSo(maHs);
			PhanLoaiXuLyService s = new PhanLoaiXuLyService();
			KntcPhieuChuyenDon kq = s.getPhieuChuyenDon(appContext, maHs, KntcPhieuChuyenDon.PHIEU_HUONG_DAN_NKN);
			phieuHDForm.setNoiDungDon(dx.getNoiDung());
			if (kq == null) {
				String readOnly = request.getParameter("r");
				if (readOnly != null)
					if (readOnly.equals("rol")) {
						throw new KtnbException("Biểu mẫu này không có số liệu!!!", "", "");
					}
				phieuHDForm.setMaPhieu(KtnbUtil.getMaNvu(appContext, "HD"));
				phieuHDForm.setThoiDiem(Formater.date2str(new Date()));
			} else {
				phieuHDForm.fromEntity(kq);
			}
		}
		return map.findForward("phieuHdNkn");
	}

	// Thông báo không thụ lý mẫu 07/KNTC
	public ActionForward thongBaoKThuLy(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuHdNknForm cnForm = (PhieuHdNknForm) form;
		cnForm.setLoaiPhieu(KntcPhieuChuyenDon.PHIEU_THONG_BAO_KHONG_THU_LY);
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			cnForm.setMaHoSo(maHs);
			PhanLoaiXuLyService s = new PhanLoaiXuLyService();
			KntcPhieuChuyenDon kq = s.getPhieuChuyenDon(appContext, maHs, KntcPhieuChuyenDon.PHIEU_THONG_BAO_KHONG_THU_LY);
			SoTiepDanService s1 = new SoTiepDanService();
			cnForm.setNoiDungDon(s1.getSoTiepDan(appContext, maHs, true).getHdr().getNoiDung());
			if (kq == null) { // Tao moi
				String readOnly = request.getParameter("r");
				if (readOnly != null)
					if (readOnly.equals("rol")) {
						throw new KtnbException("Biểu mẫu này không có số liệu!!!", "", "");
					}
				cnForm.setMaPhieu(KtnbUtil.getMaNvu(appContext, "TB"));
				cnForm.setThoiDiem(Formater.date2str(new Date()));
			} else { // Edit
				cnForm.fromEntity(kq);
			}
		}
		return map.findForward("thongBaoKThuLy");
	}

	public ActionForward getListPhieuChuyen(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonResult = null;
		try {
			jsonResult = this.createObject(request);
			response.setContentType("application/json;charset=UTF-8");
			response.setHeader("Cache-Control", "no-store");
			PrintWriter out = response.getWriter();
			out.println(jsonResult);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private JSONObject createObject(HttpServletRequest request) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// Get ma Ho so
		String maHs = request.getParameter("maHs");
		// Loai bien ban
		String loaiThongBao = SoTiepDanService.isKN(appContext, maHs) ? KntcPhieuChuyenDon.PHIEU_CHUYEN_DON : KntcPhieuChuyenDon.PHIEU_CHUYEN_DON_TO_CAO;
		// Create Object
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			conn = DataSourceConfiguration.getConnection();
			StringBuffer sb = new StringBuffer("SELECT t.MA, t.THOI_DIEM, t.CQT_GQ_TEN FROM KTNB_OWNER.KNTC_PHIEU_CHUYEN_DON t WHERE t.MA_HS=? AND t.LOAI_THONG_BAO=?");
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, maHs);
			ps.setString(2, loaiThongBao);
			System.out.println(sb.toString());
			JSONArray jsonArray = new JSONArray();
			int rc = 0;
			rs = ps.executeQuery();
			while (rs.next()) {
				JSONArray ja;
				ja = new JSONArray();
				ja.put(rs.getString(1));
				ja.put(Formater.date2str(rs.getDate(2)));
				ja.put(rs.getString(3));
				jsonArray.put(ja);
				rc++;
			}
			jsonResult.put("iTotalRecords", new Integer(rc));
			jsonResult.put("aaData", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	// Phiếu chuyển đơn mẫu 06/KNTC và mẫu 20/KNTC
	public ActionForward phieuCd(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuHdNknForm cnForm = (PhieuHdNknForm) form;
		String maHs = request.getParameter("id");
		boolean isKN = true;
		if (!Formater.isNull(maHs)) {
			isKN = SoTiepDanService.isKN(appContext, maHs);
			cnForm.setLoaiPhieu(isKN ? KntcPhieuChuyenDon.PHIEU_CHUYEN_DON : KntcPhieuChuyenDon.PHIEU_CHUYEN_DON_TO_CAO);
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			cnForm.setMaHoSo(maHs);
			PhanLoaiXuLyService s = new PhanLoaiXuLyService();
			KntcPhieuChuyenDon kq = s.getPhieuChuyenDon(appContext, maHs, isKN ? KntcPhieuChuyenDon.PHIEU_CHUYEN_DON : KntcPhieuChuyenDon.PHIEU_CHUYEN_DON_TO_CAO);
			SoTiepDanService s1 = new SoTiepDanService();
			KntcSoTiepDan std = s1.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = std.getHdr();
			// KntcNdungDon don = std.getNoiDungDon();
			cnForm.setNoiDungDon(hdr.getNoiDung());
			if (kq == null) { // Tao moi
				String readOnly = request.getParameter("r");
				if (readOnly != null)
					if (readOnly.equals("rol")) {
						throw new KtnbException("Biểu mẫu này không có số liệu!!!", "", "");
					}
				cnForm.setMaPhieu(KtnbUtil.getMaNvu(appContext, "PC\u0110"));
				cnForm.setThoiDiem(Formater.date2str(new Date()));
				cnForm.setDiaDiem(appContext.getDiaBan());
				cnForm.setCongVanDenSo(hdr.getCongVanDenMa());
				cnForm.setCongVanNgay(Formater.date2str(hdr.getCongVanDenNgay()));
				cnForm.setDonCvDeNgay(Formater.date2str(hdr.getDonDeNgay()));
				cnForm.setCongVanSo(hdr.getSoDon());
				cnForm.setNguoiCqDvKn(dx.getNguoiKNTC());
				cnForm.setDiaChiCqDvKn(dx.getChuDanhNguoiBiKNTC());
				cnForm.setNoiDungDon(dx.getNoiDung());
			} else { // Edit
				cnForm.fromEntity(kq);
				cnForm.setCongVanDenSo(hdr.getCongVanDenMa());
				cnForm.setDonCvDeNgay(Formater.date2str(hdr.getDonDeNgay()));
			}
		}
		// saveToken(request);
		return isKN ? map.findForward("phieuCd") : map.findForward("phieuCdTc");
	}

	// Xem Phiếu chuyển đơn mẫu 06/KNTC và mẫu 20/KNTC
	public ActionForward xemPhieuChuyen(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhService service = new XacMinhService();
		String maHs = request.getParameter("id");
		boolean isKN = true;
		try {
			isKN = SoTiepDanService.isKN(appContext, maHs);
			KntcPhieuChuyenDon pcd = service.getPhieuChuyenDonByMaPhieu(appContext, request.getParameter("pId").toString());
			PhieuHdNknForm f = (PhieuHdNknForm) form;
			f.fromEntity(pcd);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return isKN ? map.findForward("phieuCd") : map.findForward("phieuCdTc");
	}

	// Tạo mới Phiếu chuyển đơn mẫu 06/KNTC và mẫu 20/KNTC
	public ActionForward taoMoiPhieuChuyen(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuHdNknForm cnForm = (PhieuHdNknForm) form;
		if (SoTiepDanService.isKN(appContext, cnForm.getMaHoSo())) {
			cnForm.setLoaiPhieu(KntcPhieuChuyenDon.PHIEU_CHUYEN_DON);
		} else {
			cnForm.setLoaiPhieu(KntcPhieuChuyenDon.PHIEU_CHUYEN_DON_TO_CAO);
		}
		String maHs = request.getParameter("id");
		boolean isKN = true;
		if (!Formater.isNull(maHs)) {
			isKN = SoTiepDanService.isKN(appContext, maHs);
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			cnForm.setMaHoSo(maHs);
			SoTiepDanService s1 = new SoTiepDanService();
			KntcSoTiepDan std = s1.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = std.getHdr();
			// KntcNdungDon don = std.getNoiDungDon();
			cnForm.setNoiDungDon(hdr.getNoiDung());
			String readOnly = request.getParameter("r");
			if (readOnly != null)
				if (readOnly.equals("rol")) {
					throw new KtnbException("Biểu mẫu này không có số liệu!!!", "", "");
				}
			cnForm.setMaPhieu(KtnbUtil.getMaNvu(appContext, "PC\u0110"));
			cnForm.setThoiDiem(Formater.date2str(new Date()));
			cnForm.setCongVanDenSo(hdr.getCongVanDenMa());
			cnForm.setCongVanNgay(Formater.date2str(hdr.getCongVanDenNgay()));
			cnForm.setDonCvDeNgay(Formater.date2str(hdr.getDonDeNgay()));
			cnForm.setCongVanSo(hdr.getSoDon());

			cnForm.setNguoiCqDvKn(dx.getNguoiKNTC());
			cnForm.setDiaChiCqDvKn(dx.getDcNguoiBiKNTC());
			cnForm.setNoiDungDon(dx.getNoiDung());

			cnForm.setDiaDiem(appContext.getDiaBan());
			cnForm.setCqtGqTen("");
			cnForm.setCqtGqMa(null);
			cnForm.setMaHidden(null);

		}
		return isKN ? map.findForward("phieuCd") : map.findForward("phieuCdTc");
	}

	// Xóa Phiếu chuyển đơn mẫu 06/KNTC và mẫu 20/KNTC
	public ActionForward xoaPhieuChuyen(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		XacMinhService service = new XacMinhService();
		String maHs = request.getParameter("id");
		boolean isKN = true;
		try {
			isKN = SoTiepDanService.isKN(appContext, maHs);
			service.delPhieuChuyenById(appContext, request.getParameter("pId").toString());
			request.setAttribute("xoaThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("xoaThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		return isKN ? map.findForward("phieuCd") : map.findForward("phieuCdTc");
	}

	// Chuyển cơ quan điều tra mẫu 25A/KNTC
	public ActionForward chuyenDieuTra(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuHdNknForm cnForm = (PhieuHdNknForm) form;
		cnForm.setLoaiPhieu(KntcPhieuChuyenDon.TC_PHIEU_CHUYEN_CQ_DIEU_TRA);
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			cnForm.setMaHoSo(maHs);
			PhanLoaiXuLyService s = new PhanLoaiXuLyService();
			KntcPhieuChuyenDon kq = s.getPhieuChuyenDon(appContext, maHs, KntcPhieuChuyenDon.TC_PHIEU_CHUYEN_CQ_DIEU_TRA);
			if (kq == null) { // Tao moi
				String readOnly = request.getParameter("r");
				if (readOnly != null)
					if (readOnly.equals("rol")) {
						throw new KtnbException("Biểu mẫu này không có số liệu!!!", "", "");
					}
				cnForm.setMaPhieu(KtnbUtil.getMa(appContext, "PC\u0110"));
				cnForm.setThoiDiem(Formater.date2str(new Date()));
				cnForm.setDiaDiem(appContext.getDiaBan());
			} else { // Edit
				cnForm.fromEntity(kq);
			}
		}
		// saveToken(request);
		return map.findForward("chuyenDieuTra");
	}

	// Phiếu trả đơn cho người KN
	public ActionForward phieuTd(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuHdNknForm ptdForm = (PhieuHdNknForm) form;
		ptdForm.setLoaiPhieu(KntcPhieuChuyenDon.PHIEU_TRA_DON_KN);
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			ptdForm.setMaHoSo(maHs);
			PhanLoaiXuLyService s = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = s.getDeXuatXly(appContext, maHs);
			KntcPhieuChuyenDon kq = s.getPhieuChuyenDon(appContext, maHs, KntcPhieuChuyenDon.PHIEU_TRA_DON_KN);
			ptdForm.setMaHoSo(maHs);
			SoTiepDanService s1 = new SoTiepDanService();
			KntcSoTiepDan std = s1.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = std.getHdr();
			// KntcNdungDon don = std.getNoiDungDon();
			ptdForm.setNoiDungDon(hdr.getNoiDung());
			if (kq == null) { // Tao moi
				String readOnly = request.getParameter("r");
				if (readOnly != null)
					if (readOnly.equals("rol")) {
						throw new KtnbException("Biểu mẫu này không có số liệu!!!", "", "");
					}
				ptdForm.setMaPhieu(KtnbUtil.getMaNvu(appContext, "PT\u0110"));
				ptdForm.setThoiDiem(Formater.date2str(new Date()));
				ptdForm.setDiaDiem(appContext.getDiaBan());
				ptdForm.setCongVanDenSo(hdr.getCongVanDenMa());
				ptdForm.setCongVanNgay(Formater.date2str(hdr.getCongVanDenNgay()));
				// ptdForm.setNgayCvDen(Formater.date2str(hdr.getCongVanDenNgay()));
				ptdForm.setDonCvDeNgay(Formater.date2str(hdr.getDonDeNgay()));
				ptdForm.setCongVanSo(hdr.getSoDon());

				ptdForm.setNguoiCqDvKn(dx.getNguoiKNTC());
				ptdForm.setDiaChiCqDvKn(dx.getDcNguoiKNTC());
				ptdForm.setNoiDungDon(dx.getNoiDung());
			} else { // Edit
				ptdForm.fromEntity(kq);
				ptdForm.setCongVanDenSo(hdr.getCongVanDenMa());
				ptdForm.setDonCvDeNgay(Formater.date2str(hdr.getDonDeNgay()));
			}
		}
		// saveToken(request);
		return map.findForward("phieuTd");
	}

	// Thông báo thụ lý 09/KNTC
	public ActionForward thongBaoThuLy(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuHdNknForm cnForm = (PhieuHdNknForm) form;
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			cnForm.setMaHoSo(maHs);
			String loaiPhieu = SoTiepDanService.isKN(appContext, maHs) ? KntcPhieuChuyenDon.PHIEU_THONG_BAO_THU_LY : KntcPhieuChuyenDon.PHIEU_THONG_BAO_THU_LY_TO_CAO;
			cnForm.setLoaiPhieu(loaiPhieu);
			PhanLoaiXuLyService s = new PhanLoaiXuLyService();
			KntcPhieuChuyenDon kq = s.getPhieuChuyenDon(appContext, maHs, loaiPhieu);
			KntcDeXuatXly dx = s.getDeXuatXly(appContext, maHs);
			if (kq == null) { // Tao moi
				String readOnly = request.getParameter("r");
				if (readOnly != null)
					if (readOnly.equals("rol")) {
						throw new KtnbException("Biểu mẫu này không có số liệu!!!", "", "");
					}
				cnForm.setMaPhieu(KtnbUtil.getMaNvu(appContext, "TB"));
				cnForm.setThoiDiem(Formater.date2str(new Date()));
				cnForm.setDiaDiem(appContext.getDiaBan());
				cnForm.setNoiDungDon(dx.getNoiDung());

			} else { // Edit
				cnForm.fromEntity(kq);
			}
		}
		return map.findForward("thongBaoThuLy");
	}

	public ActionForward save(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String su = "";
		PhieuHdNknForm cnForm = (PhieuHdNknForm) form;
		try {
			if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_CHUYEN_DON))
				su = "phieuCd";
			else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_CHUYEN_DON_TO_CAO))
				su = "phieuCdTc";
			else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_HUONG_DAN_NKN))
				su = "phieuHdNkn";
			else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_THONG_BAO_THU_LY))
				su = "thongBaoThuLy";
			else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_THONG_BAO_THU_LY_TO_CAO))
				su = "thongBaoThuLy";// Dùng chung JSP
			else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_THONG_BAO_KHONG_THU_LY))
				su = "thongBaoKThuLy";
			else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_TRA_DON_KN))
				su = "phieuTd";
			else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.TC_PHIEU_CHUYEN_CQ_DIEU_TRA))
				su = "chuyenDieuTra";
			PhanLoaiXuLyService s = new PhanLoaiXuLyService();
			s.savePhieuChuyenDon(appContext, cnForm.toEntity(appContext));
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		return map.findForward(su);
	}

	/**
	 * Download file mau
	 * KNTC05,KNTC06,KNTC07,KNTC08,KNTC09,KNTC20,KNTC21,KNTC25,
	 * 
	 * @throws Exception
	 */

	public ActionForward in(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuHdNknForm phknForm = (PhieuHdNknForm) form;
		//PhieuHenForm phForm=(PhieuHenForm) form;
		DungChungService service=new DungChungService();
		String maHs = phknForm.getMaHoSo();
		System.out.println("Ma hs  : "+maHs);
		if(!Formater.isNull(maHs))
		{
			if("4".equals(service.getVersionDonKntc(appContext, maHs)))
				inv4(map, form, request, response);
			else inv3(map, form, request, response);
			System.out.println("Donver  : " +service.getVersionDonKntc(appContext, maHs) );
		}
		else 
		{
			if("4".equals(Constants.APP_DEP_VERSION))
				inv4(map, form, request, response);
			else 
				inv3(map, form, request, response);
		}
		return null;
		
	}
	/**
	 * Des : ktnb v3
	 */
	public ActionForward inv3(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileIn = null;
		String fileOut = null;

		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		PhieuHdNknForm cnForm = (PhieuHdNknForm) form;
		String maHs = cnForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			SoTiepDanService stdService = new SoTiepDanService();
			KntcSoTiepDan std = stdService.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = std.getHdr();
			PhanLoaiXuLyService plServices = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plServices.getDeXuatXly(appContext, maHs);
			String su = "kntc06";
			StringBuffer sb = null;

			MsWordUtils word = null;

			try {
				if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_CHUYEN_DON) || cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_CHUYEN_DON_TO_CAO)) {
					// word.put("[co_quan_co_tham_quyen_giai_quyet]",
					// cnForm.getCqtGqTen());
					if (hdr.getLoaiKntc().intValue() == 1) {
						System.out.println("Type : " + request.getParameter("type"));
						if ("KN03".equals(request.getParameter("type"))) {
							su = "kntc03";
							fileIn = request.getRealPath("/docin") + "\\KN03.doc";
							fileOut = request.getRealPath("/docout") + "\\KN03_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
							word = new MsWordUtils(fileIn, fileOut);

							word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
							word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
							word.put("[so_phieu]", cnForm.getMaPhieu());
							String ngayLap = "";
							if (Formater.isNull(cnForm.getThoiDiem())) {
								ngayLap = "ng\u00E0y....th\u00E1ng....n\u0103m.....";
							} else
								ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
							if (Formater.isNull(cnForm.getDiaDiem())) {
								word.put("[ngay_lap]", "......, " + ngayLap);
							} else {
								word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);
							}
							// if (Formater.isNull(cnForm.getCqtGqTen()))
							// word.put("[co_quan_co_tham_quyen_giai_quyet]",
							// ".........");
							// else
							// word.put("[co_quan_co_tham_quyen_giai_quyet]",
							// cnForm.getCqtGqTen());
							word.put("[ngay_cong_van_den]", Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
							word.put("[so_cong_van_van_thu]", hdr.getCongVanDenMa());
							word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
							if (!Formater.isNull(hdr.getSoDon()))
								word.put("[so_cong_van]", hdr.getSoDon());
							else
								word.put("[so_cong_van]", "......");
							word.put("[cong_van_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));

							word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
							if (Formater.isNull(dx.getDcNguoiKNTC())) {
								word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", ".......");
							} else {
								word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", dx.getDcNguoiKNTC());
							}
							word.put("[noi_dung_tom_tat_don]", cnForm.getNoiDungDon());
							word.put("[can_cu]", "Điều 7");
							word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
							word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
							if (Formater.isNull(cnForm.getCqtGqTen()))
								word.put("[co_quan_co_tham_quyen_giai_quyet]", ".........");
							else
								word.put("[co_quan_co_tham_quyen_giai_quyet]", cnForm.getCqtGqTen());
							word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
							// word.put("[ten_thu_truong]",
							// appContext.getTenThuTruong());
						} else {
							su = "kntc06";
							fileIn = request.getRealPath("/docin") + "\\KNTC06.doc";
							fileOut = request.getRealPath("/docout") + "\\KNTC06_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
							word = new MsWordUtils(fileIn, fileOut);

							word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
							word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
							word.put("[so_phieu]", cnForm.getMaPhieu());
							String ngayLap = "";
							if (Formater.isNull(cnForm.getThoiDiem())) {
								ngayLap = "ng\u00E0y....th\u00E1ng....n\u0103m.....";
							} else
								ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
							if (Formater.isNull(cnForm.getDiaDiem())) {
								word.put("[ngay_lap]", "......, " + ngayLap);
							} else {
								word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);
							}
							if (Formater.isNull(cnForm.getCqtGqTen()))
								word.put("[co_quan_co_tham_quyen_giai_quyet]", ".........");
							else
								word.put("[co_quan_co_tham_quyen_giai_quyet]", cnForm.getCqtGqTen());
							word.put("[ngay_cong_van_den]", Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
							word.put("[so_cong_van_van_thu]", hdr.getCongVanDenMa());
							word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
							if (!Formater.isNull(hdr.getSoDon()))
								word.put("[so_cong_van]", hdr.getSoDon());
							else
								word.put("[so_cong_van]", "......");
							word.put("[cong_van_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));

							word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
							if (Formater.isNull(dx.getDcNguoiKNTC())) {
								word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", ".......");
							} else {
								word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", dx.getDcNguoiKNTC());
							}
							word.put("[noi_dung_tom_tat_don]", cnForm.getNoiDungDon());
							word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
							word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
							if (Formater.isNull(cnForm.getCqtGqTen()))
								word.put("[co_quan_co_tham_quyen_giai_quyet]", ".........");
							else
								word.put("[co_quan_co_tham_quyen_giai_quyet]", cnForm.getCqtGqTen());
							word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
							// word.put("[ten_thu_truong]",
							// appContext.getTenThuTruong());
						}

					} else {
						// version cu
						// //////////////////////////////////////////////////////////////////////////////////
						// su = "kntc20";
						// fileIn = request.getRealPath("/docin") +
						// "\\KNTC20.doc";
						// fileOut = request.getRealPath("/docout") +
						// "\\KNTC20_Out" + System.currentTimeMillis() +
						// request.getSession().getId() + ".doc";
						// word = new MsWordUtils(fileIn, fileOut);
						//
						// word.put("[co_quan_cap_tren_truc_tiep]",
						// KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
						// word.put("[co_quan_thue_ra_van_ban]",
						// appContext.getTenCqt().toUpperCase());
						// word.put("[so_phieu]", cnForm.getMaPhieu());
						// String ngayLap = "";
						// if (Formater.isNull(cnForm.getThoiDiem())) {
						// ngayLap =
						// "ng\u00E0y.....th\u00E1ng.....n\u0103m.....";
						// } else
						// ngayLap =
						// Formater.getDateForPrint(cnForm.getThoiDiem());
						// if (Formater.isNull(cnForm.getDiaDiem()))
						// word.put("[ngay_lap]", "......, " + ngayLap);
						// else
						// word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " +
						// ngayLap);
						// word.put("[co_quan_co_tham_quyen_giai_quyet]",
						// cnForm.getCqtGqTen());
						// word.put("[ngay_cong_van_den]",
						// Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
						// if (!Formater.isNull(hdr.getSoDon()))
						// word.put("[so_cong_van]", hdr.getSoDon());
						// else
						// word.put("[so_cong_van]", "......");
						// word.put("[co_quan_thue_ra_van_ban]",
						// appContext.getTenCqt());
						// word.put("[don_de_ngay]",
						// Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
						// word.put("[nguoi_co_quan_don_vi_khieu_nai]",
						// dx.getNguoiKNTC());
						//
						// if (Formater.isNull(dx.getDcNguoiKNTC())) {
						// word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]",
						// ".....");
						// } else {
						// word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]",
						// dx.getDcNguoiKNTC());
						// }
						// word.put("[noi_dung_tom_tat_don]",
						// cnForm.getNoiDungDon());
						// word.put("[co_quan_thue_ra_van_ban]",
						// appContext.getTenCqt());
						// word.put("[nguoi_co_quan_don_vi_khieu_nai]",
						// dx.getNguoiKNTC());
						// word.put("[co_quan_co_tham_quyen_giai_quyet]",
						// cnForm.getCqtGqTen());
						//
						// word.put("[tt_cqt]",
						// KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
						// // word.put("[ten_thu_truong]",
						// // appContext.getTenThuTruong());
						// //////////////////////////////////////////////////////////////////////////////////////////////

						// v4
						su = "tc03";
						fileIn = request.getRealPath("/docin/v4") + "\\TC03.doc";
						fileOut = request.getRealPath("/docout") + "\\TC03_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
						word = new MsWordUtils(fileIn, fileOut);

						word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
						word.put("[so_phieu]", cnForm.getMaPhieu());
						String ngayLap = "";
						if (Formater.isNull(cnForm.getThoiDiem())) {
							ngayLap = "ng\u00E0y.....th\u00E1ng.....n\u0103m.....";
						} else
							ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
						if (Formater.isNull(cnForm.getDiaDiem()))
							word.put("[ngay_lap]", "......, " + ngayLap);
						else
							word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);
						// word.put("[co_quan_co_tham_quyen_giai_quyet]",
						// cnForm.getCqtGqTen());
						word.put("[ngay_cong_van_den]", Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
						if (!Formater.isNull(hdr.getSoDon()))
							word.put("[so_cong_van]", hdr.getSoDon());
						else
							word.put("[so_cong_van]", "......");
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
						word.put("[don_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
						if (Formater.isNull(dx.getDcNguoiKNTC())) {
							word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", ".....");
						} else {
							word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", dx.getDcNguoiKNTC());
						}
						word.put("[noi_dung_tom_tat_don]", cnForm.getNoiDungDon());
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
						word.put("[co_quan_co_tham_quyen_giai_quyet]", cnForm.getCqtGqTen());
						word.put("[co_quan_co_tham_quyen_giai_quyet]", cnForm.getCqtGqTen());
						// word.put("[bo_phan_duoc_giao_xu_ly]",
						// appContext.getTenCanbo());
						word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
						// word.put("[ten_thu_truong]",
						// appContext.getTenThuTruong());

					}
				} else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_HUONG_DAN_NKN)) {
					su = "kntc05";
					fileIn = request.getRealPath("/docin") + "\\KNTC05.doc";
					fileOut = request.getRealPath("/docout") + "\\KNTC05_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
					word = new MsWordUtils(fileIn, fileOut);
					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
					word.put("[so_phieu]", cnForm.getMaPhieu());
					String ngayLap = "";
					if (Formater.isNull(cnForm.getThoiDiem())) {
						ngayLap = "ng\u00E0y.....th\u00E1ng.....n\u0103m.....";
					} else
						ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
					if (Formater.isNull(cnForm.getDiaDiem())) {
						word.put("[ngay_lap]", "......., " + ngayLap);
					} else {
						word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);
					}
					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
					word.put("[ngay_cong_van_den]", Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
					word.put("[so_cong_van_van_thu]", hdr.getCongVanDenMa());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					if (!Formater.isNull(hdr.getSoDon()))
						word.put("[so_cong_van]", hdr.getSoDon());
					else
						word.put("[so_cong_van]", "......");
					word.put("[cong_van_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());

					if (Formater.isNull(dx.getDcNguoiKNTC())) {
						word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", "......");
					} else {
						word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", dx.getDcNguoiKNTC());
					}
					word.put("[noi_dung_tom_tat_don]", cnForm.getNoiDungDon());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					// word.put("[chuc_danh_nguoi_khieu_nai]",
					// dx.getChuDanhNguoiKNTC());

					// word.put("[don_de_ngay]",
					// Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));

					if (Formater.isNull(cnForm.getCqtGqTen())) {
						word.put("[co_quan_co_tham_quyen_giai_quyet_khieu_nai]", "......");
					} else {
						word.put("[co_quan_co_tham_quyen_giai_quyet_khieu_nai]", cnForm.getCqtGqTen());
					}
					Collection tl = stdService.getListTlkt(appContext, maHs);
					sb = new StringBuffer();
					if (tl.size() > 0) {
						sb.append("T\u00E0i li\u1EC7u g\u1EEDi tr\u1EA3 l\u1EA1i k\u00E8m theo: \n");
						for (Iterator iter = tl.iterator(); iter.hasNext();) {
							sb.append("\t+ " + ((KtnbTlieuKemTheo) iter.next()).getTenTlieu() + ".\n");
						}
					}
					// word.put("[tai_lieu_kem_theo]", sb.toString());
					word.put("[tai_lieu_chung_co_kem_theo]", sb.toString());
					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]",
					// appContext.getTenThuTruong());
				} else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_THONG_BAO_THU_LY) || cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_THONG_BAO_THU_LY_TO_CAO)) {
					if (hdr.getLoaiKntc().intValue() == 1) {
						su = "kntc09";
						fileIn = request.getRealPath("/docin") + "\\KNTC09.doc";
						fileOut = request.getRealPath("/docout") + "\\KNTC09_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
						word = new MsWordUtils(fileIn, fileOut);

						word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
						word.put("[so_phieu]", cnForm.getMaPhieu());
						String ngayLap = "";
						if (Formater.isNull(cnForm.getThoiDiem())) {
							ngayLap = "ng\u00E0y.....th\u00E1ng.....n\u0103m.....";
						} else
							ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
						if (Formater.isNull(cnForm.getDiaDiem()))
							word.put("[ngay_lap]", "....., " + ngayLap);
						else
							word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);
						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
						word.put("[ngay_cong_van_den]", Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
						word.put("[so_cong_van_van_thu]", hdr.getCongVanDenMa());
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
						if (!Formater.isNull(hdr.getSoDon()))
							word.put("[so_cong_van]", hdr.getSoDon());
						else
							word.put("[so_cong_van]", "......");
						word.put("[cong_van_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());

						if (Formater.isNull(dx.getDcNguoiKNTC())) {
							word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", ".....");
						} else {
							word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", dx.getDcNguoiKNTC());
						}
						word.put("[noi_dung_tom_tat_don]", cnForm.getNoiDungDon());
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
						if (!Formater.isNull(hdr.getSoDon()))
							word.put("[so_cong_van]", hdr.getSoDon());
						else
							word.put("[so_cong_van]", "......");
						word.put("[cong_van_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
						word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
						// word.put("[ten_thu_truong]",
						// appContext.getTenThuTruong());

					} else {
						// version cu
						// ////////////////////////////////////////////////////////////
						// su = "kntc21";
						// fileIn = request.getRealPath("/docin") +
						// "\\KNTC21.doc";
						// fileOut = request.getRealPath("/docout") +
						// "\\KNTC21_Out" + System.currentTimeMillis() +
						// request.getSession().getId() + ".doc";
						// word = new MsWordUtils(fileIn, fileOut);
						//
						// word.put("[co_quan_cap_tren_truc_tiep]",
						// KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
						// word.put("[co_quan_thue_ra_van_ban]",
						// appContext.getTenCqt().toUpperCase());
						// word.put("[so_phieu]", cnForm.getMaPhieu());
						// String ngayLap = "";
						// if (Formater.isNull(cnForm.getThoiDiem())) {
						// ngayLap =
						// "ng\u00E0y.....th\u00E1ng.....n\u0103m.....";
						// } else
						// ngayLap =
						// Formater.getDateForPrint(cnForm.getThoiDiem());
						// if (Formater.isNull(cnForm.getDiaDiem()))
						// word.put("[ngay_lap]", "......, " + ngayLap);
						// else
						// word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " +
						// ngayLap);
						//
						// word.put("[nguoi_co_quan_don_vi_khieu_nai]",
						// dx.getNguoiKNTC());
						// word.put("[ngay_cong_van_den]",
						// Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
						// word.put("[co_quan_co_tham_quyen_giai_quyet]",
						// cnForm.getCqtGqTen());
						// word.put("[ho_ten_nguoi_bi_to_cao]",
						// dx.getNguoiBiKNTC());
						// word.put("[chuc_vu_nguoi_bi_to_cao]",
						// dx.getChuDanhNguoiBiKNTC());
						// word.put("[noi_dung_tom_tat_don]",
						// cnForm.getNoiDungDon());
						// word.put("[co_quan_co_tham_quyen_giai_quyet]",
						// cnForm.getCqtGqTen());
						//
						// word.put("[tt_cqt]",
						// KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
						// // word.put("[ten_thu_truong]",
						// // appContext.getTenThuTruong());
						// //////////////////////////////////////////////////////////////////////////////////
						// v4
						su = "tc06";
						fileIn = request.getRealPath("/docin/v4") + "\\TC06.doc";
						fileOut = request.getRealPath("/docout") + "\\TC06_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
						word = new MsWordUtils(fileIn, fileOut);

						word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
						word.put("[so_phieu]", cnForm.getMaPhieu());
						String ngayLap = "";
						if (Formater.isNull(cnForm.getThoiDiem())) {
							ngayLap = "ng\u00E0y.....th\u00E1ng.....n\u0103m.....";
						} else
							ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
						if (Formater.isNull(cnForm.getDiaDiem()))
							word.put("[ngay_lap]", "......, " + ngayLap);
						else
							word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);

						// word.put("[nguoi_co_quan_don_vi_khieu_nai]",
						// dx.getNguoiKNTC());
						// word.put("[ngay_cong_van_den]",
						// Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
						word.put("[co_quan_co_tham_quyen_giai_quyet]", appContext.getTenCanbo());
						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
						word.put("[ho_ten_nguoi_bi_to_cao]", dx.getNguoiBiKNTC());
						if(!dx.getChuDanhNguoiBiKNTC().equals(""))
							word.put("[chuc_vu_nguoi_bi_to_cao]","chức vụ "+ dx.getChuDanhNguoiBiKNTC());
						else
							word.put("[chuc_vu_nguoi_bi_to_cao]","");
						word.put("[noi_dung_tom_tat_don]", cnForm.getNoiDungDon());
						word.put("[ten_don_vi_ca_nhan_chuyen_don]", "");
						word.put("[noi_dung_don]", dx.getNoiDungKNTC());
						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
						word.put("[ten_don_vi_ca_nhan_chuyen_don]", "");

						word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
						// word.put("[ten_thu_truong]",
						// appContext.getTenThuTruong());

					}
				} else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_THONG_BAO_KHONG_THU_LY)) {
					su = "kntc07";
					fileIn = request.getRealPath("/docin") + "\\KNTC07.doc";
					fileOut = request.getRealPath("/docout") + "\\KNTC07_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
					word = new MsWordUtils(fileIn, fileOut);
					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
					word.put("[so_phieu]", cnForm.getMaPhieu());
					String ngayLap = "";
					if (Formater.isNull(cnForm.getThoiDiem())) {
						ngayLap = "ng\u00E0y.....th\u00E1ng....n\u0103m....";
					} else
						ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
					if (Formater.isNull(cnForm.getDiaDiem())) {
						word.put("[ngay_lap]", "....., " + ngayLap);
					} else {
						word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);
					}
					if (Formater.isNull(cnForm.getCqtGqTen()))
						word.put("[ten_co_quan_to_chuc_chuyen_don_den]", "..........");
					else
						word.put("[ten_co_quan_to_chuc_chuyen_don_den]", cnForm.getCqtGqTen());
					word.put("[ngay_cong_van_den]", Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
					word.put("[so_cong_van_van_thu]", hdr.getCongVanDenMa());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					if (!Formater.isNull(hdr.getSoDon()))
						word.put("[so_cong_van]", hdr.getSoDon());
					else
						word.put("[so_cong_van]", "....");
					word.put("[cong_van_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));

					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
					if (Formater.isNull(dx.getDcNguoiKNTC())) {
						word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", "........");
					} else {
						word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", dx.getDcNguoiKNTC());
					}
					if (Formater.isNull(cnForm.getCqtGqTen()))
						word.put("[ten_co_quan_to_chuc_chuyen_don_den]", "..........");
					else
						word.put("[ten_co_quan_to_chuc_chuyen_don_den]", cnForm.getCqtGqTen());
					word.put("[cong_van_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					if (Formater.isNull(cnForm.getLyDo())) {
						word.put("[ly_do_khong_thu_ly_don]", ".....");
					} else {
						word.put("[ly_do_khong_thu_ly_don]", cnForm.getLyDo());
					}
					Collection tl = stdService.getListTlkt(appContext, maHs);
					sb = new StringBuffer();
					if (tl.size() > 0) {
						sb.append("T\u00E0i li\u1EC7u g\u1EEDi tr\u1EA3 l\u1EA1i k\u00E8m theo: \n");
						for (Iterator iter = tl.iterator(); iter.hasNext();) {
							sb.append("+ " + ((KtnbTlieuKemTheo) iter.next()).getTenTlieu() + ".\n");
						}
					}
					word.put("[tai_lieu_kem_theo]", sb.toString());
					word.put("[ten_co_quan_to_chuc_chuyen_don_den]", cnForm.getCqtGqTen());

					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]",
					// appContext.getTenThuTruong());

				} else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_TRA_DON_KN)) {
					su = "kntc08";
					fileIn = request.getRealPath("/docin") + "\\KNTC08.doc";
					fileOut = request.getRealPath("/docout") + "\\KNTC08_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
					word = new MsWordUtils(fileIn, fileOut);

					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
					word.put("[so_phieu]", cnForm.getMaPhieu());
					String ngayLap = "";
					if (Formater.isNull(cnForm.getThoiDiem())) {
						ngayLap = "ng\u00E0y.....th\u00E1ng.....n\u0103m......";
					} else
						ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
					if (Formater.isNull(cnForm.getDiaDiem()))
						word.put("[ngay_lap]", "......, " + ngayLap);
					else
						word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);
					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
					word.put("[ngay_cong_van_den]", Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
					word.put("[so_cong_van_van_thu]", hdr.getCongVanDenMa());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					if (!Formater.isNull(hdr.getSoDon()))
						word.put("[so_cong_van]", hdr.getSoDon());
					else
						word.put("[so_cong_van]", ".....");
					word.put("[cong_van_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
					if (Formater.isNull(dx.getDcNguoiKNTC())) {
						word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", ".....");
					} else {
						word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", dx.getDcNguoiKNTC());
					}
					word.put("[noi_dung_tom_tat_don]", cnForm.getNoiDungDon());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					word.put("[ly_do_khong_giai_quyet]", cnForm.getLyDo());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());

					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]",
					// appContext.getTenThuTruong());

				} else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.TC_PHIEU_CHUYEN_CQ_DIEU_TRA)) {
					su = "kntc25";
					fileIn = request.getRealPath("/docin") + "\\KNTC25.doc";
					fileOut = request.getRealPath("/docout") + "\\KNTC25_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
					word = new MsWordUtils(fileIn, fileOut);

					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
					word.put("[so_phieu]", cnForm.getMaPhieu());
					String ngayLap = "";
					if (Formater.isNull(cnForm.getThoiDiem())) {
						ngayLap = "ng\u00E0y.....th\u00E1ng......n\u0103m......";
					} else
						ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
					if (Formater.isNull(cnForm.getDiaDiem()))
						word.put("[ngay_lap]", "......, " + ngayLap);
					else
						word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);
					word.put("[ten_co_quan_dieu_tra_co_tham_quyen]", cnForm.getCqtGqTen());

					XacMinhService s = new XacMinhService();
					KntcQdinhXm kh = s.getKntcQdinhXmByHoSo(appContext, cnForm.getMaHoSo());
					word.put("[so_quyet_dinh]", kh.getMaQd());
					word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(Formater.date2str(kh.getNgayLap())));
					word.put("[chuc_danh_thu_truong_co_quan_thue_ra_quyet_dinh_xac_minh]", KtnbUtil.getTenThuTruongCqt(appContext));
					if (Formater.isNull(cnForm.getHanhViViPham()))
						word.put("[tom_tat_hanh_vi_vi_pham]", ".....");
					else
						word.put("[tom_tat_hanh_vi_vi_pham]", cnForm.getHanhViViPham());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					if (Formater.isNull(cnForm.getDauHieuToiPham()))
						word.put("[hanh_vi_vi_pham_co_dau_hieu_toi_pham]", ".....");
					else
						word.put("[hanh_vi_vi_pham_co_dau_hieu_toi_pham]", cnForm.getDauHieuToiPham());
					word.put("[ten_co_quan_dieu_tra_co_tham_quyen]", cnForm.getCqtGqTen());
					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]",
					// appContext.getTenThuTruong());
				}
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau " + su, ".doc", response);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {
				try {
					word.saveAndClose();
				} catch (Exception ex) {
				}
			}
		}
		return null;
	}

	/**
	 * Des : ktnb v4
	 */
	public ActionForward inv4(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("this is ktnb v4");
		String fileIn = null;
		String fileOut = null;

		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		PhieuHdNknForm cnForm = (PhieuHdNknForm) form;
		String maHs = cnForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			SoTiepDanService stdService = new SoTiepDanService();
			KntcSoTiepDan std = stdService.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = std.getHdr();
			PhanLoaiXuLyService plServices = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plServices.getDeXuatXly(appContext, maHs);
			String su = "kntc06";
			StringBuffer sb = null;

			MsWordUtils word = null;

			try {
				if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_CHUYEN_DON) || cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_CHUYEN_DON_TO_CAO)) {
					// word.put("[co_quan_co_tham_quyen_giai_quyet]",
					// cnForm.getCqtGqTen());
					if (hdr.getLoaiKntc().intValue() == 1) {
						su = "kn03";
						fileIn = request.getRealPath("/docin") + "\\KN03.doc";
						fileOut = request.getRealPath("/docout") + "\\KN03_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
						word = new MsWordUtils(fileIn, fileOut);

						word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
						word.put("[so_phieu]", cnForm.getMaPhieu());
						String ngayLap = "";
						if (Formater.isNull(cnForm.getThoiDiem())) {
							ngayLap = "ng\u00E0y....th\u00E1ng....n\u0103m.....";
						} else
							ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
						if (Formater.isNull(cnForm.getDiaDiem())) {
							word.put("[ngay_lap]", "......, " + ngayLap);
						} else {
							word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);
						}
						// if (Formater.isNull(cnForm.getCqtGqTen()))
						// word.put("[co_quan_co_tham_quyen_giai_quyet]",
						// ".........");
						// else
						// word.put("[co_quan_co_tham_quyen_giai_quyet]",
						// cnForm.getCqtGqTen());
						word.put("[ngay_cong_van_den]", Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
						word.put("[so_cong_van_van_thu]", hdr.getCongVanDenMa());
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
						if (!Formater.isNull(hdr.getSoDon()))
							word.put("[so_cong_van]", hdr.getSoDon());
						else
							word.put("[so_cong_van]", "......");
						word.put("[cong_van_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));

						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
						if (Formater.isNull(dx.getDcNguoiKNTC())) {
							word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", ".......");
						} else {
							word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", dx.getDcNguoiKNTC());
						}
						word.put("[noi_dung_tom_tat_don]", cnForm.getNoiDungDon());
						word.put("[can_cu]", "Điều 7");
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
						if (Formater.isNull(cnForm.getCqtGqTen()))
							word.put("[co_quan_co_tham_quyen_giai_quyet]", ".........");
						else
							word.put("[co_quan_co_tham_quyen_giai_quyet]", cnForm.getCqtGqTen());
						word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
						// word.put("[ten_thu_truong]",
						// appContext.getTenThuTruong());
					} else {
						// su = "kntc20";
						// fileIn = request.getRealPath("/docin") +
						// "\\KNTC20.doc";
						// fileOut = request.getRealPath("/docout") +
						// "\\KNTC20_Out" + System.currentTimeMillis() +
						// request.getSession().getId() + ".doc";
						// word = new MsWordUtils(fileIn, fileOut);
						//
						// word.put("[co_quan_cap_tren_truc_tiep]",
						// KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
						// word.put("[co_quan_thue_ra_van_ban]",
						// appContext.getTenCqt().toUpperCase());
						// word.put("[so_phieu]", cnForm.getMaPhieu());
						// String ngayLap = "";
						// if (Formater.isNull(cnForm.getThoiDiem())) {
						// ngayLap =
						// "ng\u00E0y.....th\u00E1ng.....n\u0103m.....";
						// } else
						// ngayLap =
						// Formater.getDateForPrint(cnForm.getThoiDiem());
						// if (Formater.isNull(cnForm.getDiaDiem()))
						// word.put("[ngay_lap]", "......, " + ngayLap);
						// else
						// word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " +
						// ngayLap);
						// word.put("[co_quan_co_tham_quyen_giai_quyet]",
						// cnForm.getCqtGqTen());
						// word.put("[ngay_cong_van_den]",
						// Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
						// if (!Formater.isNull(hdr.getSoDon()))
						// word.put("[so_cong_van]", hdr.getSoDon());
						// else
						// word.put("[so_cong_van]", "......");
						// word.put("[co_quan_thue_ra_van_ban]",
						// appContext.getTenCqt());
						// word.put("[don_de_ngay]",
						// Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
						// word.put("[nguoi_co_quan_don_vi_khieu_nai]",
						// dx.getNguoiKNTC());
						//
						// if (Formater.isNull(dx.getDcNguoiKNTC())) {
						// word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]",
						// ".....");
						// } else {
						// word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]",
						// dx.getDcNguoiKNTC());
						// }
						// word.put("[noi_dung_tom_tat_don]",
						// cnForm.getNoiDungDon());
						// word.put("[co_quan_thue_ra_van_ban]",
						// appContext.getTenCqt());
						// word.put("[nguoi_co_quan_don_vi_khieu_nai]",
						// dx.getNguoiKNTC());
						// word.put("[co_quan_co_tham_quyen_giai_quyet]",
						// cnForm.getCqtGqTen());
						//
						// word.put("[tt_cqt]",
						// KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
						// // word.put("[ten_thu_truong]",
						// // appContext.getTenThuTruong());

						// v4
						su = "tc03";
						fileIn = request.getRealPath("/docin/v4") + "\\TC03.doc";
						fileOut = request.getRealPath("/docout") + "\\TC03_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
						word = new MsWordUtils(fileIn, fileOut);

						word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
						word.put("[so_phieu]", cnForm.getMaPhieu());
						String ngayLap = "";
						if (Formater.isNull(cnForm.getThoiDiem())) {
							ngayLap = "ng\u00E0y.....th\u00E1ng.....n\u0103m.....";
						} else
							ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
						if (Formater.isNull(cnForm.getDiaDiem()))
							word.put("[ngay_lap]", "......, " + ngayLap);
						else
							word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);
						// word.put("[co_quan_co_tham_quyen_giai_quyet]",
						// cnForm.getCqtGqTen());
						word.put("[ngay_cong_van_den]", Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
						if (!Formater.isNull(hdr.getSoDon()))
							word.put("[so_cong_van]", hdr.getSoDon());
						else
							word.put("[so_cong_van]", "......");
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
						word.put("[don_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
						if (Formater.isNull(dx.getDcNguoiKNTC())) {
							word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", ".....");
						} else {
							word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", dx.getDcNguoiKNTC());
						}
						word.put("[noi_dung_tom_tat_don]", cnForm.getNoiDungDon());
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
						word.put("[co_quan_co_tham_quyen_giai_quyet]", cnForm.getCqtGqTen());
						word.put("[co_quan_co_tham_quyen_giai_quyet]", cnForm.getCqtGqTen());
						// word.put("[bo_phan_duoc_giao_xu_ly]",
						// appContext.getTenCanbo());
						word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
						// word.put("[ten_thu_truong]",
						// appContext.getTenThuTruong());

					}
				} else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_HUONG_DAN_NKN)) {
					su = "kn02";
					fileIn = request.getRealPath("/docin/v4/kntc") + "\\KN02.doc";
					fileOut = request.getRealPath("/docout") + "\\KN02_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
					word = new MsWordUtils(fileIn, fileOut);
					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
					word.put("[so_phieu]", cnForm.getMaPhieu());
					String ngayLap = "";
					if (Formater.isNull(cnForm.getThoiDiem())) {
						ngayLap = "ng\u00E0y.....th\u00E1ng.....n\u0103m.....";
					} else
						ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
					if (Formater.isNull(cnForm.getDiaDiem())) {
						word.put("[ngay_lap]", "......., " + ngayLap);
					} else {
						word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);
					}
					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
					word.put("[ngay_cong_van_den]", Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
					word.put("[so_cong_van_van_thu]", hdr.getCongVanDenMa());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					if (!Formater.isNull(hdr.getSoDon()))
						word.put("[so_cong_van]", hdr.getSoDon());
					else
						word.put("[so_cong_van]", "......");
					word.put("[cong_van_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());

					if (Formater.isNull(dx.getDcNguoiKNTC())) {
						word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", "......");
					} else {
						word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", dx.getDcNguoiKNTC());
					}
					word.put("[noi_dung_tom_tat_don]", cnForm.getNoiDungDon());
					if (Formater.isNull(cnForm.getCanCuQuyetDinh()))
						word.put("[can_cu]", "...");
					else
						word.put("[can_cu]", cnForm.getCanCuQuyetDinh());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					// word.put("[chuc_danh_nguoi_khieu_nai]",
					// dx.getChuDanhNguoiKNTC());

					// word.put("[don_de_ngay]",
					// Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));

					if (Formater.isNull(cnForm.getCqtGqTen())) {
						word.put("[co_quan_co_tham_quyen_giai_quyet_khieu_nai]", "......");
					} else {
						word.put("[co_quan_co_tham_quyen_giai_quyet_khieu_nai]", cnForm.getCqtGqTen());
					}
					Collection tl = stdService.getListTlkt(appContext, maHs);
					sb = new StringBuffer();
					if (tl.size() > 0) {
						sb.append("T\u00E0i li\u1EC7u g\u1EEDi tr\u1EA3 l\u1EA1i k\u00E8m theo: \n");
						for (Iterator iter = tl.iterator(); iter.hasNext();) {
							sb.append("\t+ " + ((KtnbTlieuKemTheo) iter.next()).getTenTlieu() + ".\n");
						}
					}
					// word.put("[tai_lieu_kem_theo]", sb.toString());
					word.put("[tai_lieu_chung_co_kem_theo]", sb.toString());
					word.put("[bo_phan_xl_don]", "...");
					// word.put("[tt_cqt]",
					// KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]",
					// appContext.getTenThuTruong());
				} else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_THONG_BAO_THU_LY) || cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_THONG_BAO_THU_LY_TO_CAO)) {
					if (hdr.getLoaiKntc().intValue() == 1) {
						su = "kn05";
						fileIn = request.getRealPath("/docin/v4/kntc") + "\\KN05.doc";
						fileOut = request.getRealPath("/docout") + "\\KN05_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
						word = new MsWordUtils(fileIn, fileOut);

						word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
						word.put("[so_phieu]", cnForm.getMaPhieu());
						String ngayLap = "";
						if (Formater.isNull(cnForm.getThoiDiem())) {
							ngayLap = "ng\u00E0y.....th\u00E1ng.....n\u0103m.....";
						} else
							ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
						if (Formater.isNull(cnForm.getDiaDiem()))
							word.put("[ngay_lap]", "....., " + ngayLap);
						else
							word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);
						if(dx.getLanGui()==null)
							word.put("[lan_giai_quyet_kn]", "...");
						else 
						{
							if("1".equals(dx.getLanGui().toString())) 
								word.put("[lan_giai_quyet_kn]", "l\u1EA7n \u0111\u1EA7u");
							else if("2".equals(dx.getLanGui().toString()))
								word.put("[lan_giai_quyet_kn]", "l\u1EA7n hai");
							else
								word.put("[lan_giai_quyet_kn]", dx.getLanGui().toString());
						}
						//word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
						word.put("[ngay_cong_van_den]", Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
						word.put("[so_cong_van_van_thu]", hdr.getCongVanDenMa());
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
//						if (!Formater.isNull(hdr.getSoDon()))
//							word.put("[so_cong_van]", hdr.getSoDon());
//						else
//							word.put("[so_cong_van]", "......");
						word.put("[cong_van_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());

						if (Formater.isNull(dx.getDcNguoiKNTC())) {
							word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", ".....");
						} else {
							word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", dx.getDcNguoiKNTC());
						}
						String cmtMst="....";
						if(!Formater.isNull(hdr.getNndCmtHc()))
						{
								cmtMst="S\u1ED1 CMND : "+hdr.getNndCmtHc();
								if(hdr.getNndCmtNgayCap()!=null)
									cmtMst+=" .Ng\u00E0y c\u1EA5p: "+Formater.getDateForPrint(Formater.date2str(hdr.getNndCmtNgayCap())) ;
								if(!Formater.isNull(hdr.getNndCmtNoiCap()))
									cmtMst+=" .N\u01A1i c\u1EA5p : "+hdr.getNndCmtNoiCap();
								if(!Formater.isNull(hdr.getNndMst()))
									cmtMst+=".M\u00E3 s\u1ED1 thu\u1EBF :"+hdr.getNndMst();
						}	
						System.out.println("CMT : "+cmtMst);
						word.put("[thong_tin_cmt_hc]",cmtMst);
						word.put("[noi_dung_tom_tat_don]", cnForm.getNoiDungDon());
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
//						if (!Formater.isNull(hdr.getSoDon()))
//							word.put("[so_cong_van]", hdr.getSoDon());
//						else
//							word.put("[so_cong_van]", "......");
//						word.put("[cong_van_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
						//word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
						word.put("[don_vi_chuyen_don_den]", cnForm.getDonViCoThamQuyenChuyenDen());
						word.put("[bo_phan_xu_ly_don]", "...");
						//word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
						// word.put("[ten_thu_truong]",
						// appContext.getTenThuTruong());

					} else {
						// v3
						// su = "kntc21";
						// fileIn = request.getRealPath("/docin") +
						// "\\KNTC21.doc";
						// fileOut = request.getRealPath("/docout") +
						// "\\KNTC21_Out" + System.currentTimeMillis() +
						// request.getSession().getId() + ".doc";
						// word = new MsWordUtils(fileIn, fileOut);
						//
						// word.put("[co_quan_cap_tren_truc_tiep]",
						// KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
						// word.put("[co_quan_thue_ra_van_ban]",
						// appContext.getTenCqt().toUpperCase());
						// word.put("[so_phieu]", cnForm.getMaPhieu());
						// String ngayLap = "";
						// if (Formater.isNull(cnForm.getThoiDiem())) {
						// ngayLap =
						// "ng\u00E0y.....th\u00E1ng.....n\u0103m.....";
						// } else
						// ngayLap =
						// Formater.getDateForPrint(cnForm.getThoiDiem());
						// if (Formater.isNull(cnForm.getDiaDiem()))
						// word.put("[ngay_lap]", "......, " + ngayLap);
						// else
						// word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " +
						// ngayLap);
						//
						// word.put("[nguoi_co_quan_don_vi_khieu_nai]",
						// dx.getNguoiKNTC());
						// word.put("[ngay_cong_van_den]",
						// Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
						// word.put("[co_quan_co_tham_quyen_giai_quyet]",
						// cnForm.getCqtGqTen());
						// word.put("[ho_ten_nguoi_bi_to_cao]",
						// dx.getNguoiBiKNTC());
						// word.put("[chuc_vu_nguoi_bi_to_cao]",
						// dx.getChuDanhNguoiBiKNTC());
						// word.put("[noi_dung_tom_tat_don]",
						// cnForm.getNoiDungDon());
						// word.put("[co_quan_co_tham_quyen_giai_quyet]",
						// cnForm.getCqtGqTen());
						//
						// word.put("[tt_cqt]",
						// KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
						// // word.put("[ten_thu_truong]",
						// // appContext.getTenThuTruong());

						su = "tc06";
						fileIn = request.getRealPath("/docin/v4") + "\\TC06.doc";
						fileOut = request.getRealPath("/docout") + "\\TC06_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
						word = new MsWordUtils(fileIn, fileOut);

						word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
						word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
						word.put("[so_phieu]", cnForm.getMaPhieu());
						String ngayLap = "";
						if (Formater.isNull(cnForm.getThoiDiem())) {
							ngayLap = "ng\u00E0y.....th\u00E1ng.....n\u0103m.....";
						} else
							ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
						if (Formater.isNull(cnForm.getDiaDiem()))
							word.put("[ngay_lap]", "......, " + ngayLap);
						else
							word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);

						// word.put("[nguoi_co_quan_don_vi_khieu_nai]",
						// dx.getNguoiKNTC());
						// word.put("[ngay_cong_van_den]",
						// Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
						word.put("[co_quan_co_tham_quyen_giai_quyet]", appContext.getTenCanbo());
						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
						word.put("[ho_ten_nguoi_bi_to_cao]", dx.getNguoiBiKNTC());
						if(Formater.isNull(dx.getChuDanhNguoiBiKNTC()))
							word.put("[chuc_vu_nguoi_bi_to_cao]","");
						else
							word.put("[chuc_vu_nguoi_bi_to_cao]","chức vụ "+ dx.getChuDanhNguoiBiKNTC());
						word.put("[noi_dung_tom_tat_don]", cnForm.getNoiDungDon());
						word.put("[ten_don_vi_ca_nhan_chuyen_don]", "");
						word.put("[noi_dung_don]", dx.getNoiDungKNTC());
						word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
						word.put("[ten_don_vi_ca_nhan_chuyen_don]", "");

						word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
						// word.put("[ten_thu_truong]",
						// appContext.getTenThuTruong());

					}
				} else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_THONG_BAO_KHONG_THU_LY)) {
					su = "kn04";
					fileIn = request.getRealPath("/docin/v4/kntc") + "\\KN04.doc";
					fileOut = request.getRealPath("/docout") + "\\KN04_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
					word = new MsWordUtils(fileIn, fileOut);
					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
					word.put("[so_phieu]", cnForm.getMaPhieu());
					String ngayLap = "";
					if (Formater.isNull(cnForm.getThoiDiem())) {
						ngayLap = "ng\u00E0y.....th\u00E1ng....n\u0103m....";
					} else
						ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
					if (Formater.isNull(cnForm.getDiaDiem())) {
						word.put("[ngay_lap]", "....., " + ngayLap);
					} else {
						word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);
					}
					// if (Formater.isNull(cnForm.getCqtGqTen()))
					// word.put("[ten_co_quan_to_chuc_chuyen_don_den]",
					// "..........");
					// else
					// word.put("[ten_co_quan_to_chuc_chuyen_don_den]",
					// cnForm.getCqtGqTen());
					word.put("[ngay_cong_van_den]", Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
					word.put("[so_cong_van_van_thu]", hdr.getCongVanDenMa());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
					// if (!Formater.isNull(hdr.getSoDon()))
					// word.put("[so_cong_van]", hdr.getSoDon());
					// else
					// word.put("[so_cong_van]", "....");
					word.put("[cong_van_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
					if (Formater.isNull(cnForm.getCqtGqTen()))
						word.put("[ten_co_quan_to_chuc_chuyen_don_den]", "..........");
					else
						word.put("[ten_co_quan_to_chuc_chuyen_don_den]", cnForm.getCqtGqTen());

					if (Formater.isNull(dx.getDcNguoiKNTC())) {
						word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", "........");
					} else {
						word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", dx.getDcNguoiKNTC());
					}

					String cmtMst = "....";
					if (!Formater.isNull(hdr.getNndCmtHc())) {
						cmtMst = "S\u1ED1 CMND : " + hdr.getNndCmtHc();
						if (hdr.getNndCmtNgayCap() != null)
							cmtMst += " .Ng\u00E0y c\u1EA5p: " + Formater.getDateForPrint(Formater.date2str(hdr.getNndCmtNgayCap()));
						if (!Formater.isNull(hdr.getNndCmtNoiCap()))
							cmtMst += " .N\u01A1i c\u1EA5p : " + hdr.getNndCmtNoiCap();
						if (!Formater.isNull(hdr.getNndMst()))
							cmtMst += ".M\u00E3 s\u1ED1 thu\u1EBF :" + hdr.getNndMst() + ".";
					}
					System.out.println("CMT : " + cmtMst);
					word.put("[thong_tin_CMT_MST]", cmtMst);
					word.put("[noi_dung_viec_khieu_nai]", hdr.getNoiDung());
					word.put("[can_cu]", cnForm.getCanCuQuyetDinh());
					if (Formater.isNull(cnForm.getLyDo())) {
						word.put("[ly_do_khong_thu_ly_don]", ".....");
					} else {
						word.put("[ly_do_khong_thu_ly_don]", cnForm.getLyDo());
					}
					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
					if (Formater.isNull(cnForm.getCqtGqTen()))
						word.put("[ten_co_quan_to_chuc_chuyen_don_den]", "..........");
					else
						word.put("[ten_co_quan_to_chuc_chuyen_don_den]", cnForm.getCqtGqTen());

					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					if (Formater.isNull(cnForm.getCqtGqTen()))
						word.put("[ten_co_quan_to_chuc_chuyen_don_den]", "..........");
					else
						word.put("[ten_co_quan_to_chuc_chuyen_don_den]", cnForm.getCqtGqTen());

					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());

					// word.put("[tt_cqt]",
					// KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]",
					// appContext.getTenThuTruong());

				} else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.PHIEU_TRA_DON_KN)) {
					su = "kntc08";
					fileIn = request.getRealPath("/docin") + "\\KNTC08.doc";
					fileOut = request.getRealPath("/docout") + "\\KNTC08_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
					word = new MsWordUtils(fileIn, fileOut);

					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
					word.put("[so_phieu]", cnForm.getMaPhieu());
					String ngayLap = "";
					if (Formater.isNull(cnForm.getThoiDiem())) {
						ngayLap = "ng\u00E0y.....th\u00E1ng.....n\u0103m......";
					} else
						ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
					if (Formater.isNull(cnForm.getDiaDiem()))
						word.put("[ngay_lap]", "......, " + ngayLap);
					else
						word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);
					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
					word.put("[ngay_cong_van_den]", Formater.getDateForPrintUpper(Formater.date2str(hdr.getCongVanDenNgayVT())));
					word.put("[so_cong_van_van_thu]", hdr.getCongVanDenMa());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					if (!Formater.isNull(hdr.getSoDon()))
						word.put("[so_cong_van]", hdr.getSoDon());
					else
						word.put("[so_cong_van]", ".....");
					word.put("[cong_van_de_ngay]", Formater.getDateForPrint(Formater.date2str(hdr.getDonDeNgay())));
					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());
					if (Formater.isNull(dx.getDcNguoiKNTC())) {
						word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", ".....");
					} else {
						word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", dx.getDcNguoiKNTC());
					}
					word.put("[noi_dung_tom_tat_don]", cnForm.getNoiDungDon());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					word.put("[ly_do_khong_giai_quyet]", cnForm.getLyDo());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					word.put("[nguoi_co_quan_don_vi_khieu_nai]", dx.getNguoiKNTC());

					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]",
					// appContext.getTenThuTruong());

				} else if (cnForm.getLoaiPhieu().equals(KntcPhieuChuyenDon.TC_PHIEU_CHUYEN_CQ_DIEU_TRA)) {
					su = "kntc25";
					fileIn = request.getRealPath("/docin") + "\\KNTC25.doc";
					fileOut = request.getRealPath("/docout") + "\\KNTC25_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
					word = new MsWordUtils(fileIn, fileOut);

					word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt4P(appContext).toUpperCase());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt().toUpperCase());
					word.put("[so_phieu]", cnForm.getMaPhieu());
					String ngayLap = "";
					if (Formater.isNull(cnForm.getThoiDiem())) {
						ngayLap = "ng\u00E0y.....th\u00E1ng......n\u0103m......";
					} else
						ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
					if (Formater.isNull(cnForm.getDiaDiem()))
						word.put("[ngay_lap]", "......, " + ngayLap);
					else
						word.put("[ngay_lap]", cnForm.getDiaDiem() + ", " + ngayLap);
					word.put("[ten_co_quan_dieu_tra_co_tham_quyen]", cnForm.getCqtGqTen());

					XacMinhService s = new XacMinhService();
					KntcQdinhXm kh = s.getKntcQdinhXmByHoSo(appContext, cnForm.getMaHoSo());
					word.put("[so_quyet_dinh]", kh.getMaQd());
					word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(Formater.date2str(kh.getNgayLap())));
					word.put("[chuc_danh_thu_truong_co_quan_thue_ra_quyet_dinh_xac_minh]", KtnbUtil.getTenThuTruongCqt(appContext));
					if (Formater.isNull(cnForm.getHanhViViPham()))
						word.put("[tom_tat_hanh_vi_vi_pham]", ".....");
					else
						word.put("[tom_tat_hanh_vi_vi_pham]", cnForm.getHanhViViPham());
					word.put("[co_quan_thue_ra_van_ban]", appContext.getTenCqt());
					if (Formater.isNull(cnForm.getDauHieuToiPham()))
						word.put("[hanh_vi_vi_pham_co_dau_hieu_toi_pham]", ".....");
					else
						word.put("[hanh_vi_vi_pham_co_dau_hieu_toi_pham]", cnForm.getDauHieuToiPham());
					word.put("[ten_co_quan_dieu_tra_co_tham_quyen]", cnForm.getCqtGqTen());
					word.put("[tt_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
					// word.put("[ten_thu_truong]",
					// appContext.getTenThuTruong());
				}
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau " + su, ".doc", response);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {
				try {
					word.saveAndClose();
				} catch (Exception ex) {
				}
			}
		}
		return null;
	}
}
