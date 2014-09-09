/*
 * Created on Apr 25, 2011
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

import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.service.kntc.KntcSoTiepDan;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseDispatchAction;

/**
 * @author ntthu
 */
public class DaTiepNhanAction extends BaseDispatchAction {
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		DaTiepNhanForm dtnForm = (DaTiepNhanForm) form;
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			dtnForm.setMaHoSo(maHs);
			dtnForm.setNgayNhanXL(Formater.date2str(new Date()));
		}
		saveToken(request);
		return mapping.findForward("success");
	}

	public ActionForward gopHs(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		DaTiepNhanForm dtnForm = (DaTiepNhanForm) form;
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			dtnForm.setMaHoSo(maHs);
			dtnForm.setNgayNhanXL(Formater.date2str(new Date()));
		}
		return mapping.findForward("gopHs");
	}

	public ActionForward save(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		try {
			DaTiepNhanForm dtnForm = (DaTiepNhanForm) form;
			SoTiepDanService s = new SoTiepDanService();
			String maHs = request.getParameter("id");
			KntcSoTiepDan hs = s.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = hs.getHdr();

			hdr.setMaCanBo(appContext.getMaCanbo());
			hdr.setCongVanDenNgayVT(Formater.str2date(dtnForm.getNgayNhanVT()));
			hdr.setCongVanDenMa(dtnForm.getSoCVDenVT());
			hdr.setCongVanDenNgay(Formater.str2date(dtnForm.getNgayNhanXL()));
			hdr.setTrangThai(Constants.TT_KNTC_PHAN_LOAI_DX_XLY);

			s.saveSoTiepDan(appContext, hs, false);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		return map.findForward("success");
	}

	/**
	 * 1. Update thong tin ho so can gop: thong tin cong van va chuyen trang
	 * thai ve KET_THUC 2. Ghi thong tin sang table KNTC_NDUNG_DON
	 */
	public ActionForward saveGopHs(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		try {
			DaTiepNhanForm dtnForm = (DaTiepNhanForm) form;
			SoTiepDanService s = new SoTiepDanService();
			String maHsGoc = dtnForm.getMaHoSo();
			KntcSoTiepDan hsGoc = s.getSoTiepDan(appContext, maHsGoc, true);
			KntcHoSoHdr hdrGoc = hsGoc.getHdr();
			KntcSoTiepDan hsCanGop = null;
			String maHsGop = dtnForm.getSoHsGop();
			
			boolean isLuuDon = Integer.parseInt(dtnForm.getTrangThai())>=1615;//True Là lưu đơn, False là gộp đơn.
			//Nếu là tố cáo thì luôn gộp đơn => luôn kết thúc hồ sơ con.
			if("2".equals(hdrGoc.getLoaiKntc())){
				isLuuDon = false;
			}
			//Neu ho so goc chưa ket thuc, can lap de xuat.			
			if (Formater.isNull(maHsGop)) { 
				// Gop khi chua co thong tin ho so
				KntcHoSoHdr hdrCopy = new KntcHoSoHdr(appContext, hdrGoc);
				hdrCopy.setMa(null);
				hdrCopy.setMaHs(null);
				//Hồ sơ gộp thì trạng thái là kết thúc
				//Hồ sơ lưu thì trạng thái là đề xuất
				hdrCopy.setTrangThai(isLuuDon ? Constants.TT_KNTC_PHAN_LOAI_DX_XLY:Constants.TT_KNTC_KET_THUC);				
				hdrCopy.setMaHsCha(hdrGoc.getMaHs());
				hdrCopy.setLoaiQh(Constants.LIEN_KET_GOP);
				hdrCopy.setMaCanBo(appContext.getMaCanbo());
				hdrCopy.setCongVanDenNgayVT(Formater.str2date(dtnForm.getNgayNhanVT()));
				hdrCopy.setCongVanDenMa(dtnForm.getSoCVDenVT());
				hdrCopy.setCongVanDenNgay(Formater.str2date(dtnForm.getNgayNhanXL()));
				hdrCopy.setSoDon(dtnForm.getSoDon());
				hdrCopy.setDonDeNgay(Formater.str2date(dtnForm.getNgayGuiDon()));
				hdrCopy.setLyDoRutDon("");
				//Hồ sơ gốc kết thúc thì lưu đơn, hồ sơ gốc chưa kết thúc thì gộp đơn.
				hdrCopy.setLoaiKetThuc(isLuuDon ? Constants.KNTC_KET_THUC_LUU_DON:Constants.KNTC_KET_THUC_GOP_DON);
				hsCanGop = new KntcSoTiepDan(hdrCopy);
			} 
			//Gop khi da co ho so: chuyen tu cap tren, nhap trung ho so
			else 				
			{
				hsCanGop = s.getSoTiepDan(appContext, maHsGop, true);
				KntcHoSoHdr hdrCopy = hsCanGop.getHdr();
				hdrCopy.setMaHsCha(hdrGoc.getMaHs());
				hdrCopy.setLoaiQh(Constants.LIEN_KET_GOP);
				//Hồ sơ gộp thì trạng thái là kết thúc
				//Hồ sơ lưu thì trạng thái là đề xuất
				hdrCopy.setTrangThai(isLuuDon ?Constants.TT_KNTC_PHAN_LOAI_DX_XLY:Constants.TT_KNTC_KET_THUC);
				hdrCopy.setLyDoRutDon("");
				//Hồ sơ gốc kết thúc thì lưu đơn, hồ sơ gốc chưa kết thúc thì gộp đơn.
				hdrCopy.setLoaiKetThuc(isLuuDon ? Constants.KNTC_KET_THUC_LUU_DON:Constants.KNTC_KET_THUC_GOP_DON);
				hsCanGop.setHdr(hdrCopy);
			}
			s.saveSoTiepDan(appContext, hsCanGop, false);
			dtnForm.setSoHsGop(hsCanGop.getHdr().getMaHs());
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong", "0");
			e.printStackTrace();
			throw new Exception(e);
		}
		return map.findForward("gopHs");
	}
}
