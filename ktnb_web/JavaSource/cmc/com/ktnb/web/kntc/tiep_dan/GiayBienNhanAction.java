package cmc.com.ktnb.web.kntc.tiep_dan;

import java.io.InputStream;
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

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KntcGiayBienNhan;
import cmc.com.ktnb.pl.hb.entity.KntcPhieuGiaoHs;
import cmc.com.ktnb.pl.hb.entity.KtnbTlieuKemTheo;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.util.StringUtil;
import cmc.com.ktnb.web.BaseDispatchAction;

/**
 * Xử lý giấy biên nhận
 * 
 * @author Admin
 */
public class GiayBienNhanAction extends BaseDispatchAction {

	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuForm cnForm = (PhieuForm) form;
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			cnForm.setMaHoSo(maHs);
			SoTiepDanService s = new SoTiepDanService();
			KntcPhieuGiaoHs phieu = s.getPhieuGiaoHs(appContext, maHs);
			if (phieu == null) { // Them moi
				cnForm.setNgay(Formater.date2str(new Date()));
			} else // Update
			{
				cnForm.fromEntity(appContext, phieu);
			}
		}
		saveToken(request);
		return map.findForward("success");
	}

	public ActionForward save(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// if (isTokenValid(request, true)) {
		try {
			PhieuForm tdForm = (PhieuForm) form;
			KntcGiayBienNhan ph = new KntcGiayBienNhan();
			if(!StringUtil.isBlankOrNull(tdForm.getMaHoSo())){
				ph.setMaDon(tdForm.getMaHoSo());
			}else{
				if(request.getParameter("id")!=null)
				ph.setMaDon(request.getParameter("id").toString());
				else {
					throw new Exception("Khong lay duoc ma ho so");
				}
			}
			ph.setMaGbn(tdForm.getMa());
			ph.setThoiDiem(Formater.str2date(tdForm.getNgay()));
			SoTiepDanService service = new SoTiepDanService();
			service.saveGiayBienNhan(appContext, ph);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		// }
		return map.findForward("success");
	}

	public ActionForward cghs(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuForm cnForm = (PhieuForm) form;
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			SoTiepDanService s = new SoTiepDanService();
			KntcPhieuGiaoHs ph = s.getPhieuGiaoHs(appContext, maHs);
			if (ph == null) {
				String readOnly = request.getParameter("r");
				if (readOnly != null)
					if (readOnly.equals("rol")) {
						throw new KtnbException("Bi&#7875;u m&#7851;u n&#224;y kh&#244;ng c&#243; s&#7889; li&#7879;u!!!", "", "");
					}
				String s1 = "+ " + s.getNoiDungDonForXm(appContext, maHs) + ".\n";
				Collection listTlkt = s.getListTlkt(appContext, maHs);
				for (Iterator iter = listTlkt.iterator(); iter.hasNext();) {
					KtnbTlieuKemTheo element = (KtnbTlieuKemTheo) iter.next();
					s1 = s1 + "+ " + element.getTenTlieu();
					if (!element.getSoTrang().equals("") && !String.valueOf(element.getSoTrang()).equals("0"))
						s1 += "; s\u1ED1 trang: " + element.getSoTrang();
					s1 += "; t\u00ECnh tr\u1EA1ng: " + element.getTinhTrang() + ".\n";
				}
				cnForm.setNoiDungBG(s1.substring(0, s1.length() - 1));
				cnForm.setMaHoSo(maHs);
				cnForm.setMa(KtnbUtil.getMa(appContext, "GBN"));
				cnForm.setNgay(Formater.date2strDateTimeForNV(new Date()));
				cnForm.setNguoiGiaoMa(appContext.getMaCanbo());
				cnForm.setNguoiGiaoTen(appContext.getTenCanbo());
				cnForm.setNguoiGiaoCV(appContext.getTenChucvu());
				cnForm.setNguoiGiaoDV(appContext.getTenPhong());

				cnForm.setDvGiaoMa(appContext.getMaCqt());
				cnForm.setDvGiaoTen(appContext.getTenCqt());

				cnForm.setDvNhanTen("Ph\u00F2ng h\u00E0nh ch\u00EDnh l\u01B0u tr\u1EEF");
				cnForm.setDiaDiem(appContext.getDiaBan());
			} else {
				cnForm.fromEntity(appContext, ph);
			}
		}

		return map.findForward("cghs");
	}

	public ActionForward saveCghs(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// if (isTokenValid(request, true)) {
		try {
			PhieuForm tdForm = (PhieuForm) form;
			KntcPhieuGiaoHs ph = new KntcPhieuGiaoHs();
			if(!StringUtil.isBlankOrNull(tdForm.getMaHoSo())){
				ph.setMaHs(tdForm.getMaHoSo());
			}else{
				if(request.getParameter("id")!=null)
				ph.setMaHs(request.getParameter("id").toString());
				else {
					throw new Exception("Khong lay duoc ma ho so");
				}
			}			
			ph.setMaPhieu(tdForm.getMa());
			ph.setThoiDiem(Formater.str2dateForNV(tdForm.getNgay()));
			ph.setDonViNhan(tdForm.getDvNhanTen());
			ph.setNguoiGiaoMa(tdForm.getNguoiGiaoMa());
			ph.setNguoiNhanMa(tdForm.getNguoiNhanMa());
			ph.setNoiDung(tdForm.getNoiDungBG());
			SoTiepDanService service = new SoTiepDanService();
			service.savePhieuCgHs(appContext, ph);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		// }
		return map.findForward("cghs");
	}

	public ActionForward inCghs_old(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		PhieuForm cbForm = (PhieuForm) form;
		String fileTemplate = "kntc03";
		parameters.put("CO_QUAN_THUE_TRUC_TIEP", appContext.getTenCqt());
		parameters.put("DON_VI_TIEP_NHAN", appContext.getTenPhong());
		parameters.put("thoi_diem_lap_phieu_giao_nhan", Formater.getDateTimeForPrint(cbForm.getNgay()));
		parameters.put("dia_chi_don_vi_lap_phieu_giao_nhan", cbForm.getDiaDiem());

		parameters.put("ho_ten_nguoi_giao_ho_so", cbForm.getNguoiGiaoTen());
		parameters.put("chuc_vu_nguoi_giao_ho_so", cbForm.getNguoiGiaoCV());
		parameters.put("don_vi_nguoi_giao_ho_so", cbForm.getNguoiGiaoDV());

		parameters.put("ho_ten_nguoi_nhan_ho_so", cbForm.getNguoiNhanTen());
		parameters.put("chuc_vu_nguoi_nhan_ho_so", cbForm.getNguoiNhanCV());
		parameters.put("don_vi_nguoi_nhan_ho_so", cbForm.getNguoiNhanDV());
		parameters.put("ho_so_tai_lieu", cbForm.getNoiDungBG());
		InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
		KtnbUtil.printf(reportRows, fileTemplate, response, inputStream, parameters, null);
		return null;
	}

	/**
	 * Download file mau KNTC03
	 * 
	 * @throws Exception
	 */
	public ActionForward inCghs(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileIn = request.getRealPath("/docin") + "\\TCD03.doc";
		String fileOut = request.getRealPath("/docout") + "\\TCD03_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhieuForm cbForm = (PhieuForm) form;

		MsWordUtils word = new MsWordUtils(fileIn, fileOut);
		try {
			word.put("[CO_QUAN_CAP_TREN_TRUC_TIEP]", appContext.getTenCqt().toUpperCase());
			word.put("[DON_VI_CONG_TAC]", appContext.getTenPhong().toUpperCase());
			word.put("[thoi_diem_lap_phieu_giao_nhan]", Formater.getDateTimeForPrint(cbForm.getNgay()));
			word.put("[dia_chi_don_vi_lap_phieu_giao_nhan]", cbForm.getDiaDiem());

			word.put("[ho_ten_nguoi_nhan_ho_so]", cbForm.getNguoiNhanTen());
			word.put("[chuc_vu_nguoi_nhan_ho_so]", cbForm.getNguoiNhanCV());
			word.put("[don_vi_nguoi_nhan_ho_so]", cbForm.getNguoiNhanDV());

			word.put("[ho_ten_nguoi_giao_ho_so]", cbForm.getNguoiGiaoTen());
			word.put("[chuc_vu_nguoi_giao_ho_so]", cbForm.getNguoiGiaoCV());
			word.put("[don_vi_nguoi_giao_ho_so]", cbForm.getNguoiGiaoDV());

			word.put("[ho_so_tai_lieu]", cbForm.getNoiDungBG());
			word.put("[ho_ten_nguoi_giao_ho_so]", cbForm.getNguoiGiaoTen());
			word.put("[ho_ten_nguoi_nhan_ho_so]", cbForm.getNguoiNhanTen());
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau TCD03", ".doc", response);
		} catch (Exception ex) {
			// ex.printStackTrace();
			System.out.println("Download Error: " + ex.getMessage());
		} finally {
			try{
			word.saveAndClose();
			}catch(Exception ex){}
		}

		return null;
	}
}
