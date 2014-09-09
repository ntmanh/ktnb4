/*
 * Created on Mar 3, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.kntc.xu_ly;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.pl.hb.entity.KntcDeXuatXly;
import cmc.com.ktnb.pl.hb.entity.KntcThongBaoKqgq;
import cmc.com.ktnb.service.kntc.KntcSoTiepDan;
import cmc.com.ktnb.service.kntc.PhanLoaiXuLyService;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.service.kntc.XuLyKNTCService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;

/**
 * Xử lý thông báo kết quả giải quyết tố cáo
 * 
 * @author DoHongPhuc
 */
public class ThongBaoKQGQToCaoAction extends BaseDispatchAction {
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		ThongBaoKQGQToCaoForm tbForm = (ThongBaoKQGQToCaoForm) form;
		String maHs = request.getParameter("id");
		tbForm.setMaHoSo(maHs);

		XuLyKNTCService service = new XuLyKNTCService();
		KntcThongBaoKqgq tb = service.getThongBaoKqgq(appContext, maHs);
		PhanLoaiXuLyService plSercive = new PhanLoaiXuLyService();
		KntcDeXuatXly dx = plSercive.getDeXuatXly(appContext, maHs);

		SoTiepDanService s = new SoTiepDanService();
		KntcSoTiepDan hs = s.getSoTiepDan(appContext, maHs, true);

		tbForm.setNguoiToCao(dx.getNguoiKNTC());
		tbForm.setChucVuNguoiBiToCao(dx.getChuDanhNguoiBiKNTC());
		tbForm.setNguoiBiToCao(dx.getNguoiBiKNTC());
		tbForm.setNoiDungToCao(dx.getNoiDung());
		tbForm.setSoThongBao(KtnbUtil.getMaNvu(appContext, "TB"));
		tbForm.setDiaDiem(appContext.getDiaBan());
		if (tb != null) {
			tbForm.setDiaDiem(tb.getDiaDiem());
			tbForm.setThoiDiem(Formater.date2str(tb.getNgayLap()));
			tbForm.setSoThongBao(tb.getSoThongBao());
			tbForm.setKetQuaGiaiQuyet(tb.getKetQuaGq());
			tbForm.setBenLienQuan(tb.getBenLienQuan());
			tbForm.setNgayTrinhKy(Formater.date2str(tb.getNgayTrinhKy()));
			tbForm.setNgayTrinhDuyet(Formater.date2str(tb.getNgayTrinhDuyet()));
			tbForm.setNgayKy(Formater.date2str(tb.getNgayKy()));
			tbForm.setNgayDuyet(Formater.date2str(tb.getNgayDuyet()));
			tbForm.setKienTrinh(tb.getYKienTrinh());
			tbForm.setKienDuyet(tb.getYKienDuyet());
		}

		return map.findForward("success");
	}

	public ActionForward save(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// String maHs = request.getParameter("id");

		// if (isTokenValid(request, true)) {
		try {

			ThongBaoKQGQToCaoForm tbForm = (ThongBaoKQGQToCaoForm) form;

			KntcThongBaoKqgq tb = new KntcThongBaoKqgq();
			tb.setMa(tbForm.getMa());
			tb.setMaHs(tbForm.getMaHoSo());
			tb.setDiaDiem(tbForm.getDiaDiem());
			tb.setNgayLap(Formater.str2date(tbForm.getThoiDiem()));
			tb.setSoThongBao(tbForm.getSoThongBao());
			tb.setKetQuaGq(tbForm.getKetQuaGiaiQuyet());
			tb.setBenLienQuan(tbForm.getBenLienQuan());
			tb.setNgayTrinhKy(Formater.str2date(tbForm.getNgayTrinhKy()));
			tb.setNgayTrinhDuyet(Formater.str2date(tbForm.getNgayTrinhDuyet()));
			tb.setNgayKy(Formater.str2date(tbForm.getNgayKy()));
			tb.setNgayDuyet(Formater.str2date(tbForm.getNgayDuyet()));
			tb.setYKienTrinh(tbForm.getKienTrinh());
			tb.setYKienDuyet(tbForm.getKienDuyet());

			// Luu xuong DB
			XuLyKNTCService service = new XuLyKNTCService();
			service.saveTbGQTC(appContext, tb);

			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		// }
		return map.findForward("success");
	}

	public ActionForward in_old(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		ThongBaoKQGQToCaoForm cnForm = (ThongBaoKQGQToCaoForm) form;
		String su = "kntc26";
		parameters.put("co_quan_cap_tren_truc_tiep", appContext.getTenCqt());
		parameters.put("co_quan_thue_ra_thong_bao", appContext.getTenPhong());
		parameters.put("so_thong_bao", cnForm.getSoThongBao());
		String ngayLap = "";
		if (Formater.isNull(cnForm.getThoiDiem())) {
			ngayLap = "ng\u00E0y    th\u00E1ng    n\u0103m        ";
		} else
			ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
		parameters.put("ngay_ra_thong_bao", cnForm.getDiaDiem() + ", " + ngayLap);
		parameters.put("nguoi_to_cao", cnForm.getNguoiToCao());
		parameters.put("ben_lien_quan", cnForm.getBenLienQuan());
		parameters.put("co_quan_co_tham_quyen_giai_quyet_to_cao", appContext.getTenCqt());
		parameters.put("nguoi_bi_to_cao", cnForm.getNguoiBiToCao());
		parameters.put("chuc_vu_nguoi_bi_to_cao", cnForm.getChucVuNguoiBiToCao());
		parameters.put("tom_tat_noi_dung_to_cao", cnForm.getNoiDungToCao());
		parameters.put("tom_tat_ket_luan_ve_noi_dung_to_cao", cnForm.getNoiDungToCao());
		parameters.put("tom_tat_ket_qua_xu_ly_to_cao", cnForm.getKetQuaGiaiQuyet());
		// parameters.put("ten_thu_truong", appContext.getTenThuTruong());
		parameters.put("tt_cqt", KtnbUtil.getTenThuTruongCqt(appContext));
		InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + su + ".jasper");
		KtnbUtil.printf(reportRows, su, response, inputStream, parameters, null);
		return null;
	}

	public ActionForward in(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileIn = request.getRealPath("/docin") + "\\KNTC26.doc";
		String fileOut = request.getRealPath("/docout") + "\\KNTC26_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		ThongBaoKQGQToCaoForm cnForm = (ThongBaoKQGQToCaoForm) form;
		String su = "kntc26";

		MsWordUtils word = new MsWordUtils(fileIn, fileOut);
		try {
			word.put("[co_quan_cap_tren_truc_tiep]", appContext.getTenCqt().toUpperCase());
			word.put("[co_quan_thue_ra_thong_bao]", appContext.getTenPhong().toUpperCase());
			word.put("[so_thong_bao]", cnForm.getSoThongBao());
			String ngayLap = "";
			if (Formater.isNull(cnForm.getThoiDiem())) {
				ngayLap = "ng\u00E0y.....th\u00E1ng....n\u0103m.......";
			} else
				ngayLap = Formater.getDateForPrint(cnForm.getThoiDiem());
			if (Formater.isNull(cnForm.getDiaDiem()))
				word.put("[ngay_ra_thong_bao]", "......, " + ngayLap);
			else
				word.put("[ngay_ra_thong_bao]", cnForm.getDiaDiem() + ", " + ngayLap);
			word.put("[nguoi_to_cao]", cnForm.getNguoiToCao());
			if (Formater.isNull(cnForm.getBenLienQuan()))
				word.put("[ben_lien_quan]", "");
			else
				word.put("[ben_lien_quan]", ", " + cnForm.getBenLienQuan());
			word.put("[co_quan_co_tham_quyen_giai_quyet_to_cao]", appContext.getTenCqt());
			word.put("[nguoi_bi_to_cao]", cnForm.getNguoiBiToCao());
			word.put("[chuc_vu_nguoi_bi_to_cao]", cnForm.getChucVuNguoiBiToCao());
			word.put("[tom_tat_noi_dung_to_cao]", cnForm.getNoiDungToCao());
			if (Formater.isNull(cnForm.getNoiDungToCao()))
				word.put("[tom_tat_ket_luan_ve_noi_dung_to_cao]", ".............");
			else
				word.put("[tom_tat_ket_luan_ve_noi_dung_to_cao]", cnForm.getNoiDungToCao());
			if (Formater.isNull(cnForm.getKetQuaGiaiQuyet()))
				word.put("[tom_tat_ket_qua_xu_ly_to_cao]", ".............");
			else
				word.put("[tom_tat_ket_qua_xu_ly_to_cao]", cnForm.getKetQuaGiaiQuyet());
			word.put("[co_quan_co_tham_quyen_giai_quyet_to_cao]", appContext.getTenCqt());
			word.put("[nguoi_to_cao]", cnForm.getNguoiToCao());
			word.put("[tt_cqt]", KtnbUtil.getTenThuTruongCqt(appContext).toUpperCase());
			// word.put("[ten_thu_truong]", appContext.getTenThuTruong());
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau KNTC26", ".doc", response);
		} catch (Exception ex) {
			// ex.printStackTrace();
			System.out.println("Download Error: " + ex.getMessage());
		} finally {
			try {
				word.saveAndClose();
			} catch (Exception e) {

			}
		}

		return null;
	}
}
