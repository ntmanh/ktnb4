/*
 * Created on Mar 8, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.kntc.tiep_dan;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KntcCanBoRls;
import cmc.com.ktnb.pl.hb.entity.KntcQdinhXm;
import cmc.com.ktnb.service.kntc.KntcSoTiepDan;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.service.kntc.XacMinhService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HttpUtil;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.URLUTF8Encoder;
import cmc.com.ktnb.web.BaseDispatchAction;

/**
 * Form xử lý sổ tiếp dân văn thư
 * @since 2011
 * @author Ntthu+Do Hong Phuc
 */
public class SoTiepDanVanThuAction extends BaseDispatchAction {
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		SoTiepDanVanThuForm cnForm = (SoTiepDanVanThuForm) form;
		//String type = "VT";
		if (cnForm.getFirst().equals("1")) {
			String loai = request.getParameter("l");
			if (Formater.isNull(loai))
				loai = "v";
			if (loai.equals("v")) {
				//type = "VT";
				cnForm.setLoaiHoSo("2");
				request.setAttribute("t", "Nh&#7853;n h&#7891; s&#417; qua v&#259;n th&#432; (c&#417; quan thu&#7871; ch&#432;a ti&#7871;p nh&#7853;n l&#7847;n n&#224;o)");
			} else if (loai.equals("n")) {
				cnForm.setLoaiHoSo("3");
				//type = "DDN";
				request.setAttribute("t", "Nh&#7853;n th&#244;ng tin qua &#273;&#432;&#7901;ng d&#226;y n&#243;ng");
			}
			// Thong tin cong dan
			cnForm.setNgayTiep(Formater.date2str(new Date()));
			cnForm.setDonDeNgay("");
			// Sinh ma ho so
//			cnForm.setMaHoSo(KtnbUtil.getMaHoSo(appContext, "KN", type));
			cnForm.setDonViNhanCongVan(appContext.getTenPhong());
			// cnForm.setCanBoChucVu(appContext.getMaCanbo());
			// cnForm.setIsKNTCTrucTiep("true");
			// cnForm.setUyQuyen("1");
			cnForm.setLoaiKNTC("1");
		}
		if (cnForm.getLoaiHoSo().equals("2")) {
//			type = "VT";
			request.setAttribute("t", "Nh&#7853;n h&#7891; s&#417; qua v&#259;n th&#432; (c&#417; quan thu&#7871; ch&#432;a ti&#7871;p nh&#7853;n l&#7847;n n&#224;o)");
		} else if (cnForm.getLoaiHoSo().equals("3")) {
//			type = "DDN";
			request.setAttribute("t", "Nh&#7853;n th&#244;ng tin qua &#273;&#432;&#7901;ng d&#226;y n&#243;ng");
		}
//		String loaiKNTC = cnForm.getLoaiKNTC();
//		if (Formater.isNull(loaiKNTC))
//			loaiKNTC = "1";
//		if (loaiKNTC.equals("1")) {
//			cnForm.setMaHoSo(KtnbUtil.getMaHoSo(appContext, "KN", type));
//		} else if (loaiKNTC.equals("2")) {
//			cnForm.setMaHoSo(KtnbUtil.getMaHoSo(appContext, "TC", type));
//		}else if (loaiKNTC.equals("4")) {
//			cnForm.setMaHoSo(KtnbUtil.getMaHoSo(appContext, "CS", type));
//		}
//		else {
//			cnForm.setMaHoSo(KtnbUtil.getMaHoSo(appContext, "KH", type));
//		}
		return map.findForward("success");
	}
	public ActionForward del(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		KntcSoTiepDan std = null;
		try {
			String maHs = request.getParameter("id");			
			SoTiepDanService service = new SoTiepDanService();
			std = service.getSoTiepDan(appContext, maHs, true);
			service.delSoTiepDan(appContext, std.getHdr());
			request.setAttribute("xoaThanhcong", "1");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("xoaThanhcong", "0");
			throw new Exception(e);
		}
		HttpUtil.doForward("kntc_tim_kiem.do?method=show&action=suaHSVT", request, response);
		return null;
	}
	public ActionForward view(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		try {
			SoTiepDanVanThuForm cnForm = (SoTiepDanVanThuForm) form;
			String maHs = request.getParameter("id");
			if (!Formater.isNull(maHs)) {
				SoTiepDanService service = new SoTiepDanService();
				cnForm.toForm(service.getSoTiepDan(appContext, maHs, true));
				XacMinhService s = new XacMinhService();
				KntcQdinhXm qd = s.getKntcQdinhXmByHoSo(appContext, cnForm.getMaHoSo());
				if (qd != null && !Formater.isNull(qd.getMaQd()))
					request.setAttribute("maQDXM", URLUTF8Encoder.encode(qd.getMaQd()));
				else
					request.setAttribute("maQDXM", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return map.findForward("view");
	}
	
	public ActionForward edit(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		SoTiepDanService service = new SoTiepDanService();
		String maHs = request.getParameter("id");
		service.getListCanBoByHs(appContext, maHs, KntcCanBoRls.KNTC_CB_XU_LY);
		KntcSoTiepDan std = service.getSoTiepDan(appContext, maHs, true);		
		if (!std.getHdr().getNguoiCapNhat().equals(appContext.getTenNsd())) {
			throw new KtnbException("Kh&#244;ng th&#7875; s&#7917;a th&#244;ng tin h&#7891; s&#417;!", "", "Ch&#7881; c&#225;n b&#7897; x&#7917; l&#253; b&#7897; h&#7891; s&#417; n&#224;y m&#7899;i &#273;&#432;&#7907;c s&#7917;a th&#244;ng tin h&#7891; s&#417;!");
		}
		SoTiepDanVanThuForm stdForm = (SoTiepDanVanThuForm) form;
		stdForm.toForm(std);
		return map.findForward("success");
	}
	public ActionForward copy(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		SoTiepDanService service = new SoTiepDanService();
		String maHs = request.getParameter("id");
		service.getListCanBoByHs(appContext, maHs, KntcCanBoRls.KNTC_CB_XU_LY);
		KntcSoTiepDan std = service.getSoTiepDan(appContext, maHs, true);		
		if (!std.getHdr().getNguoiCapNhat().equals(appContext.getTenNsd())) {
			throw new KtnbException("Kh&#244;ng th&#7875; s&#7917;a th&#244;ng tin h&#7891; s&#417;!", "", "Ch&#7881; c&#225;n b&#7897; x&#7917; l&#253; b&#7897; h&#7891; s&#417; n&#224;y m&#7899;i &#273;&#432;&#7907;c s&#7917;a th&#244;ng tin h&#7891; s&#417;!");
		}
		SoTiepDanVanThuForm stdForm = (SoTiepDanVanThuForm) form;		
		stdForm.toForm(std);
		//Xoa cac thong tin chinh
		stdForm.setMaHidden("");
		stdForm.setMaHoSo("");
		stdForm.setSoCongVanDen("");
		stdForm.setNgayNhanCongVanVT("");
		stdForm.setNgayNhanCongVan("");
		stdForm.setDonDeNgay("");
		stdForm.setNoiDungDon("");
		return map.findForward("success");
	}
	

	public ActionForward save(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		SoTiepDanVanThuForm tdvtForm = (SoTiepDanVanThuForm) form;
		KntcSoTiepDan std = null;
		try {
			std = tdvtForm.toSoTiepDan(appContext);
			SoTiepDanService service = new SoTiepDanService();
			service.saveSoTiepDan(appContext, std, false);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("ghiThanhcong", "0");
			throw new Exception(e);
		}
		request.setAttribute("t", "Nh&#7853;n h&#7891; s&#417; qua v&#259;n th&#432; (c&#417; quan thu&#7871; ch&#432;a ti&#7871;p nh&#7853;n l&#7847;n n&#224;o)");
		HttpUtil.doForward("kntc_tiep_dan_van_thu.do?method=edit&id=" + std.getHdr().getMaHs(), request, response);
		return null;
	}
}
