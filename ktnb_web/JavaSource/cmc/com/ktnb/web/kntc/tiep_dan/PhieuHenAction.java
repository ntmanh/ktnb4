package cmc.com.ktnb.web.kntc.tiep_dan;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KntcPhieuGiaoHs;
import cmc.com.ktnb.pl.hb.entity.KntcPhieuHen;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.util.StringUtil;
import cmc.com.ktnb.web.BaseDispatchAction;

/**
 * Xử lý phiếu hẹn
 * 
 * @author DoHongPhuc
 */
public class PhieuHenAction extends BaseDispatchAction {

	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuHenForm cnForm = (PhieuHenForm) form;
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			SoTiepDanService s = new SoTiepDanService();
			KntcPhieuHen ph = s.getPhieuHen(appContext, maHs);
			if (ph == null) {
				String readOnly = request.getParameter("r");
				if (readOnly != null)
					if (readOnly.equals("rol")) {
						throw new KtnbException("Bi&#7875;u m&#7851;u n&#224;y kh&#244;ng c&#243; s&#7889; li&#7879;u!!!", "", "");
					}
				cnForm.setMaHoSo(maHs);
				cnForm.setDiaDiemHen(appContext.getDiaBan());
				cnForm.setNgayLapPhieu(Formater.date2strDateTimeForNV(new Date()));
				if (request.getParameter("nguoinhan") != null || request.getParameter("nguoinhan") != "")
					cnForm.setNguoiNhanPhieuTen(request.getParameter("nguoinhan"));
				if (request.getParameter("diachi") != null || request.getParameter("diachi") != "")
					cnForm.setNguoiNhanPhieuDC(request.getParameter("diachi"));
				cnForm.setCanBoLapPhieuTen(appContext.getTenCanbo());
				cnForm.setCanBoLapPhieuDV(appContext.getTenPhong());
				cnForm.setCanBoLapPhieuCV(appContext.getTenChucvu());
			} else {

			}
		}
		return map.findForward("success");
	}

	public ActionForward getListPhieuHen(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonResult = null;
		// PhieuHenForm phForm = (PhieuHenForm) form;
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
		// Get ma Ho so
		String maHs = request.getParameter("id");
		// Create Object
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			conn = DataSourceConfiguration.getConnection();
			StringBuffer sb = new StringBuffer("select thoi_diem_lap_phieu,thoi_diem_hen,dia_diem_hen from kntc_phieu_hen where ma_don = ? order by thoi_diem_hen");
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, maHs);
			System.out.println(sb.toString());
			JSONArray jsonArray = new JSONArray();
			int rc = 0;
			rs = ps.executeQuery();
			while (rs.next()) {
				JSONArray ja;
				ja = new JSONArray();
				ja.put(Formater.date2strDateTimeForNV(rs.getDate(1)));
				ja.put(Formater.date2strDateTimeForNV(rs.getDate(2)));
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

	public ActionForward save(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuHenForm phieuHenForm = (PhieuHenForm) form;
		// if (isTokenValid(request, true)) {
		try {
			KntcPhieuHen phieuHen = new KntcPhieuHen();
			// Lay thong tin phieu hen tren Form.
			phieuHen.setMaDon(phieuHenForm.getMaHoSo());
			phieuHen.setMaPh(KeyManagement.getGUID());
			phieuHen.setThoiDiemLapPhieu(Formater.str2dateForNV(phieuHenForm.getNgayLapPhieu()));
			phieuHen.setThoiDiemHen(Formater.str2dateForNV(phieuHenForm.getThoiDiemHen()));
			phieuHen.setDiaDiemHen(phieuHenForm.getDiaDiemHen());
			phieuHen.setMucDich(phieuHenForm.getMucDichHen());
			SoTiepDanService service = new SoTiepDanService();
			service.savePhieuHen(appContext, phieuHen);
			// Show message neu thanh cong.
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		// }
		return map.findForward("success");
		// HttpUtil.doForward("kntc_tiep_dan.do?method=view&id="+phieuHenForm.getMaHoSo(),request,response);
		// return null;
	}

	public ActionForward inPhieuHen_old(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		PhieuHenForm cbForm = (PhieuHenForm) form;
		String fileTemplate = "kntc02";
		parameters.put("CO_QUAN_THUE_TRUC_TIEP", appContext.getTenCqt());
		parameters.put("DON_VI_VIET_PHIEU_HEN", appContext.getTenPhong());
		parameters.put("thoi_diem_lap_phieu_hen", Formater.getDateTimeForPrint(cbForm.getNgayLapPhieu()));
		parameters.put("dia_chi_don_vi_lap_phieu_hen", cbForm.getDiaDiemHen());

		parameters.put("can_bo_lap_phieu_hen", cbForm.getCanBoLapPhieuTen());
		parameters.put("chuc_vu", cbForm.getCanBoLapPhieuCV());
		parameters.put("bo_phan_cong_tac", cbForm.getCanBoLapPhieuDV());
		parameters.put("nguoi_nhan_phieu_hen", cbForm.getNguoiNhanPhieuTen());
		parameters.put("dia_chi", cbForm.getNguoiNhanPhieuDC());
		if (Formater.isNull(cbForm.getThoiDiemHen())) {
			parameters.put("thoi_diem_hen", "....gi\u1EDD....ng\u00E0y....th\u00E1ng....n\u0103m....");
		} else {
			parameters.put("thoi_diem_hen", Formater.getDateTimeForPrint(cbForm.getThoiDiemHen()));
		}
		if (Formater.isNull(cbForm.getDiaDiemHen())) {
			parameters.put("dia_chi_hen", "....");
		} else {
			parameters.put("dia_chi_hen", cbForm.getDiaDiemHen());
		}
		if (Formater.isNull(cbForm.getMucDichHen())) {
			parameters.put("muc_dich_cuoc_hen", "....");
		} else {
			parameters.put("muc_dich_cuoc_hen", cbForm.getMucDichHen());
		}
		InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
		KtnbUtil.printf(reportRows, fileTemplate, response, inputStream, parameters, null);
		return null;
	}

	/**
	 * Download file mau KNTC02
	 * 
	 * @throws Exception
	 */
	public ActionForward inPhieuHen(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileIn = request.getRealPath("/docin") + "\\KNTC02.doc";
		String fileOut = request.getRealPath("/docout") + "\\KNTC02_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);

		PhieuHenForm cbForm = (PhieuHenForm) form;

		MsWordUtils word = new MsWordUtils(fileIn, fileOut);
		try {
			word.put("[CO_QUAN_THUE_TRUC_TIEP]", appContext.getTenCqt().toUpperCase());
			word.put("[DON_VI_VIET_PHIEU_HEN]", appContext.getTenPhong().toUpperCase());
			word.put("[thoi_diem_lap_phieu_hen]", Formater.getDateTimeForPrint(cbForm.getNgayLapPhieu()));
			if (Formater.isNull(cbForm.getDiaDiemHen())) {
				word.put("[dia_chi_don_vi_lap_phieu_hen]", KtnbUtil.inFieldNull(16));
			} else {
				word.put("[dia_chi_don_vi_lap_phieu_hen]", cbForm.getDiaDiemHen());
			}
			word.put("[can_bo_lap_phieu_hen]", cbForm.getCanBoLapPhieuTen());
			word.put("[chuc_vu]", cbForm.getCanBoLapPhieuCV());
			word.put("[bo_phan_cong_tac]", cbForm.getCanBoLapPhieuDV());
			word.put("[nguoi_nhan_phieu_hen]", cbForm.getNguoiNhanPhieuTen());
			word.put("[dia_chi]", cbForm.getNguoiNhanPhieuDC());
			if (Formater.isNull(cbForm.getThoiDiemHen())) {
				word.put("[thoi_diem_hen]", "....gi\u1EDD....ng\u00E0y....th\u00E1ng....n\u0103m....");
			} else {
				word.put("[thoi_diem_hen]", Formater.getDateTimeForPrint(cbForm.getThoiDiemHen()));
			}
			if (Formater.isNull(cbForm.getDiaDiemHen())) {
				word.put("[dia_chi_hen]", "....");
			} else {
				word.put("[dia_chi_hen]", cbForm.getDiaDiemHen());
			}
			if (Formater.isNull(cbForm.getMucDichHen())) {
				word.put("[muc_dich_cuoc_hen]", "....");
			} else {
				word.put("[muc_dich_cuoc_hen]", cbForm.getMucDichHen());
			}
			word.put("[nguoi_nhan_phieu_hen]", cbForm.getNguoiNhanPhieuTen());
			word.put("[can_bo_lap_phieu_hen]", cbForm.getCanBoLapPhieuTen());
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau KNTC02", ".doc", response);
		} catch (Exception ex) {
			// ex.printStackTrace();
			System.out.println("Download Error: " + ex.getMessage());
		} finally {
			try {
				word.saveAndClose();
			} catch (Exception ex) {
			}
		}
		return null;
	}

}
