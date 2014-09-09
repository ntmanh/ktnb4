/*
 * Created on Mar 2, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.kntc.xu_ly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import cmc.com.ktnb.pl.hb.entity.KntcDeXuatXly;
import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.service.kntc.KntcDeXuatXuLy;
import cmc.com.ktnb.service.kntc.KntcSoTiepDan;
import cmc.com.ktnb.service.kntc.PhanLoaiXuLyService;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.URLUTF8Encoder;
import cmc.com.ktnb.vo.CategoryVO;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.catalog.CatalogService;

/**
 * Xử lý phân loại đơn
 * 
 * @author DoHongPhuc
 * 
 */
public class PhanLoaiDonAction extends BaseDispatchAction {
	/**
	 * Xử lý thông tin hiển thị form	
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
		PhanLoaiXuLyService service = new PhanLoaiXuLyService();
		CatalogService cService = new CatalogService();
		String maHs = null;
		if (request.getParameter("id") != null)
			maHs = request.getParameter("id").toString();
		// Get Ho so Header
		SoTiepDanService s = new SoTiepDanService();
		KntcSoTiepDan hs = s.getSoTiepDan(appContext, maHs, true);
		KntcHoSoHdr hdr = hs.getHdr();
		// Get loai Kntc. KN = 1, TC = 2
		int loaiKntc = hdr.getLoaiKntc().intValue();

		PhanLoaiDonForm inputForm = (PhanLoaiDonForm) form;
		String maDeXuat = service.getMaDeXuatByMaHoSo(maHs);
		inputForm.setMaHoSo(maHs);
		// Xử lý thông tin thẩm quyền
		String parentID = "";
		if (request.getParameter("thamquyen") != null)
			parentID = request.getParameter("thamquyen").toString();
		ArrayList listTQ = (ArrayList) request.getAttribute("dmtq");
		
		if (listTQ == null) {
			listTQ = new ArrayList();
			Collection dmTq = null;
			if (loaiKntc == 1)
				dmTq = CatalogService.getDmByParentId(cmc.com.ktnb.util.Constants.PLXL_DON_KN);
			else if (loaiKntc == 2)
				dmTq = CatalogService.getDmByParentId(cmc.com.ktnb.util.Constants.PLXL_DON_TC);
			for (Iterator iter = dmTq.iterator(); iter.hasNext();) {
				CategoryVO dmVO = (CategoryVO) iter.next();
				listTQ.add(new LabelValueBean(dmVO.getName(), dmVO.getId()));
			}
		}

		request.setAttribute("dmtq", listTQ);
		ArrayList listTL = new ArrayList();
		// Xử lý thông tin thụ lý
		if (maDeXuat.equals("")) {
			// Ho so chua phan loai
			if (parentID.length() > 0) {
				listTL = (ArrayList) request.getAttribute("dmtl");
				if (listTL == null) {
					listTL = new ArrayList();
					Collection c = CatalogService.getDmByParentId(parentID);
					for (Iterator iter = c.iterator(); iter.hasNext();) {
						CategoryVO dmVO = (CategoryVO) iter.next();
						listTL.add(new LabelValueBean(dmVO.getName(), dmVO.getId()));
					}
				}
				request.setAttribute("dmtl", listTL);
			}
			request.setAttribute("bm", null);
		}
		// Da phan loai => load thong tin cu ra, va xu ly viec thay doi
		// lua chon tham quyen
		else {
			// Chon lai tham quyen bang ="Chon tham quyen"
			if (parentID == "0") {
				inputForm.setThamQuyen("0");
				inputForm.setThuLy("0");
				request.setAttribute("bm", null);
				// Khong hien bieu mau
			}
			// Chon tham quyen khac
			else if (parentID.length() > 0) {
				inputForm.setThamQuyen(request.getParameter("thamquyen").toString());
				// Thay doi list Thu Ly
				listTL = new ArrayList();
				Collection c = CatalogService.getDmByParentId(request.getParameter("thamquyen").toString());
				for (Iterator iter = c.iterator(); iter.hasNext();) {
					CategoryVO dmVO = (CategoryVO) iter.next();
					listTL.add(new LabelValueBean(dmVO.getName(), dmVO.getId()));
				}
				// Set lai link bm
			}
			// Lan dau load trang, chua thay doi thong tin tham quyen
			else {
				KntcDeXuatXly dxxl = (KntcDeXuatXly) cService.retriveById(appContext, KntcDeXuatXly.class, maDeXuat);
				String thamQuyen = dxxl.getThamQuyen();
				listTL = (ArrayList) request.getAttribute("dmtl");
				if (listTL == null) {
					listTL = new ArrayList();
					Collection c = CatalogService.getDmByParentId(thamQuyen);
					for (Iterator iter = c.iterator(); iter.hasNext();) {
						CategoryVO dmVO = (CategoryVO) iter.next();
						listTL.add(new LabelValueBean(dmVO.getName(), dmVO.getId()));
					}
				}
				request.setAttribute("dmtl", listTL);
				if (dxxl.getIsQuaHan() != null)
					inputForm.setQuaHan(dxxl.getIsQuaHan().toString());
				else
					inputForm.setQuaHan("0");
				inputForm.setThamQuyen(dxxl.getThamQuyen()); 
				// Set combobox thụ lý
				// Lấy thông tin biểu mẫu
				inputForm.setThuLy(dxxl.getThuLy());
				inputForm.setMaDeXuat(dxxl.getMa());
				// Set attribute for link
				ArrayList listBm = (ArrayList) request.getAttribute("bm");
				if (listBm == null) {
					listBm = new ArrayList();
					Collection c = CatalogService.getDmBieuMauByPId(dxxl.getThuLy());
					for (Iterator iter = c.iterator(); iter.hasNext();) {
						CategoryVO dmVO = (CategoryVO) iter.next();
						dmVO.setUrl(dmVO.getUrl() + "&id=" + URLUTF8Encoder.encode(maHs));
						listBm.add(dmVO);
					}
				}
				request.setAttribute("bm", listBm);
			}
		}
		inputForm.setThamQuyenList(listTQ);
		inputForm.setThuLyList(listTL);
		return map.findForward("success");
	}
	
	/***
	 * Xử lý thông tin save phân loại
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveLoaiHoSo(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
		PhanLoaiDonForm inputForm = (PhanLoaiDonForm) form;
		KntcDeXuatXly dx = new KntcDeXuatXly();
		PhanLoaiXuLyService service = new PhanLoaiXuLyService();
		SoTiepDanService s = new SoTiepDanService();
		KntcSoTiepDan hs = s.getSoTiepDan(appContext, inputForm.getMaHoSo(), true);
		KntcHoSoHdr hdr = hs.getHdr();
		// Lan dau tien phan loai
		if (service.getDeXuatXly(appContext, inputForm.getMaHoSo()) == null) {
			dx.setMaHs(inputForm.getMaHoSo());
			dx.setThamQuyen(inputForm.getThamQuyen());
			dx.setThuLy(inputForm.getThuLy());
			dx.setMa(inputForm.getMaDeXuat());
			/******** Chuyen thong tin tu ho so sang de xuat de cho phep chinh sua ************/
			if (hdr.getNoiDung() != null)
				dx.setNoiDung(hdr.getNoiDung());
			if (hdr.getNuqTen() != null)
				dx.setNguoiKNTC(hdr.getNuqTen());
			else if (hdr.getNndTen() != null)
				dx.setNguoiKNTC(hdr.getNndTen());
			if (hdr.getNuqChucVu() != null)
				dx.setChuDanhNguoiKNTC(hdr.getNuqChucVu());
			else if (hdr.getNndChucVu() != null)
				dx.setChuDanhNguoiKNTC(hdr.getNndChucVu());
			if (hdr.getNuqDiaChi() != null)
				dx.setDcNguoiKNTC(hdr.getNuqDiaChi());
			else if (hdr.getNndDiaChi() != null)
				dx.setDcNguoiKNTC(hdr.getNndDiaChi());
			if (hdr.getNguoiBiKntcTen() != null)
				dx.setNguoiBiKNTC(hdr.getNguoiBiKntcTen());
			if (hdr.getNguoiBiKntcCv() != null)
				dx.setChuDanhNguoiBiKNTC(hdr.getNguoiBiKntcCv());
			if (hdr.getNguoiBiKntcDc() != null)
				dx.setDcNguoiBiKNTC(hdr.getNguoiBiKntcDc());
		} else {// Phan loai lan 2,3,4
			dx = service.getDeXuatXly(appContext, inputForm.getMaHoSo());
			dx.setThamQuyen(inputForm.getThamQuyen());
			dx.setThuLy(inputForm.getThuLy());
		}
		// ktra qua han
		if (Formater.isNull(inputForm.getQuaHan()))
			inputForm.setQuaHan("0");
		dx.setIsQuaHan(new Long(inputForm.getQuaHan()));

		KntcDeXuatXuLy dxxl = new KntcDeXuatXuLy(dx);
		try {
			//Hàm này không dùng nữa
			//service.saveDeXuatXyLyKN(appContext, dxxl);
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("ghiThanhcong", "0");
			throw ex;
		}
		show(map, form, request, response);
		return map.findForward("success");
	}
}
