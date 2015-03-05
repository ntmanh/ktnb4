/*
 * Created on Mar 3, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.kntc.xu_ly;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForwards;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ibm.ws.webservices.xml.wassysapp.systemApp;

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KntcDeXuatXly;
import cmc.com.ktnb.pl.hb.entity.KntcDmRls;
import cmc.com.ktnb.pl.hb.entity.KntcDmRlsId;
import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.pl.hb.entity.KtnbTlieuKemTheo;
import cmc.com.ktnb.service.kntc.KntcDeXuatXuLy;
import cmc.com.ktnb.service.kntc.KntcSoTiepDan;
import cmc.com.ktnb.service.kntc.PhanLoaiXuLyService;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.util.StringUtil;
import cmc.com.ktnb.util.URLUTF8Encoder;
import cmc.com.ktnb.vo.CategoryVO;
import cmc.com.ktnb.web.BaseActionForm;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.catalog.CatalogService;
import cmc.com.ktnb.web.kntc.tiep_dan.TachDonForm;

/**
 * 
 * 
 * @author cmc
 */
public class DeXuatXuLyKNAction extends BaseDispatchAction {
	/**
	 * Show Function
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		loadDefaultValue(map, form, request, response);
		return map.findForward(request.getParameter("action"));
	}

	/**
	 * Lấy thông tin trang, xử lý postback
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void loadDefaultValue(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
		DeXuatXuLyKNForm inputForm = (DeXuatXuLyKNForm) form;
		CatalogService cService = new CatalogService();
		String maHs = request.getParameter("id");
		SoTiepDanService s = new SoTiepDanService(); 
		KntcSoTiepDan hs = s.getSoTiepDan(appContext, maHs, true);
		KntcHoSoHdr hdr = hs.getHdr();
		int loaiKntc = hdr.getLoaiKntc().intValue();
		//Nếu là đơn lưu
		if(Constants.LIEN_KET_GOP.equals(hdr.getLoaiQh())){
			inputForm.setLuuDon("true");
		}
		
		if (!Formater.isNull(maHs)) {
			// SoTiepDanService s = new SoTiepDanService();
			// KntcSoTiepDan hs = s.getSoTiepDan(appContext, maHs, true);
			inputForm.setMaHoSo(maHs);
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			String maDeXuat = plService.getMaDeXuatByMaHoSo(maHs);
			// Xử lý combobox thẩm quyền và thụ lý
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
			if (maDeXuat.equals("")) {
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
			} else {
				if (parentID == "0") {
					inputForm.setThamQuyen("0");
					inputForm.setThuLy("0");
					request.setAttribute("bm", null);
				} else if (parentID.length() > 0) {
					inputForm.setThamQuyen(request.getParameter("thamquyen").toString());
					listTL = new ArrayList();
					Collection c = CatalogService.getDmByParentId(request.getParameter("thamquyen").toString());
					for (Iterator iter = c.iterator(); iter.hasNext();) {
						CategoryVO dmVO = (CategoryVO) iter.next();
						listTL.add(new LabelValueBean(dmVO.getName(), dmVO.getId()));
					}
				} else {
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
					inputForm.setThuLy(dxxl.getThuLy());
					ArrayList listBm = (ArrayList) request.getAttribute("bm");
					String strListBieuMau = "";
					if (listBm == null) {
						listBm = new ArrayList();
						Collection c = CatalogService.getDmBieuMauByPId(dxxl.getThuLy());
						System.out.println("Thu li "+ dxxl.getThuLy());
						for (Iterator iter = c.iterator(); iter.hasNext();) {
							CategoryVO dmVO = (CategoryVO) iter.next();
							// dmVO.setUrl(dmVO.getUrl() + "&id=" +
							// URLUTF8Encoder.encode(maHs));
							dmVO.setUrl(dmVO.getUrl() + "&id=" + maHs);
							listBm.add(dmVO);
							strListBieuMau += dmVO.getId() + ",";
						}
					}
					request.setAttribute("bm", listBm);
					inputForm.setStrListIdBieuMau(strListBieuMau);
				}
			}
			inputForm.setThamQuyenList(listTQ);
			inputForm.setThuLyList(listTL);

			// Xử lý các thông tin khác
			inputForm.setMa(maDeXuat);
//			String maHsStd=request.getParameter("id");
//			SoTiepDanService sv=new SoTiepDanService();
//			KntcSoTiepDan std=sv.getSoTiepDan(appContext, maHsStd, true);
//			System.out.println("Noi dung so tiep dan : "+std.getHdr().getNoiDung());
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			// Lần đầu tiên lập đề xuất
			if (dx == null) {
				dx = new KntcDeXuatXly();
				dx.setNoiDung(hdr.getNoiDung() == null ? "" : hdr.getNoiDung());
				dx.setNguoiKNTC(hdr.getNuqTen() == null ? (hdr.getNndTen() == null ? "" : hdr.getNndTen()) : hdr.getNuqTen());
				dx.setChuDanhNguoiKNTC(hdr.getNuqChucVu() == null ? (hdr.getNndChucVu() == null ? "" : hdr.getNndChucVu()) : hdr.getNuqChucVu());
				dx.setDcNguoiKNTC(hdr.getNuqDiaChi() == null ? (hdr.getNndDiaChi() == null ? "" : hdr.getNndDiaChi()) : hdr.getNuqDiaChi());
				dx.setNguoiBiKNTC(hdr.getNguoiBiKntcTen() == null ? "" : hdr.getNguoiBiKntcTen());
				dx.setChuDanhNguoiBiKNTC(hdr.getNguoiBiKntcCv() == null ? "" : hdr.getNguoiBiKntcCv());
				dx.setDcNguoiBiKNTC(hdr.getNguoiBiKntcDc() == null ? "" : hdr.getNguoiBiKntcDc());
//				dx.setNoiDungKNTC(std.getHdr().getNoiDung());
			}
			//if (dx.getDeXuat() == null) {
				//String readOnly = request.getParameter("r");
				//if (readOnly != null)
					//if (readOnly.equals("rol")) {
						//throw new KtnbException("Bi&#x1EC3;u m&#x1EAB;u n&#xE0;y kh&#xF4;ng c&#xF3; s&#x1ED1; li&#x1EC7;u!!!", "", "");
					//}
			//}
			inputForm.setDonTomTat(dx.getNoiDung() == null ? "" : dx.getNoiDung());
			inputForm.setNguoiKNTC(dx.getNguoiKNTC() == null ? "" : dx.getNguoiKNTC());
			inputForm.setChuDanhNguoiKNTC(dx.getChuDanhNguoiKNTC() == null ? "" : dx.getChuDanhNguoiKNTC());
			inputForm.setDcNguoiKNTC(dx.getDcNguoiKNTC() == null ? "" : dx.getDcNguoiKNTC());
			inputForm.setNguoiBiKNTC(dx.getNguoiBiKNTC() == null ? "" : dx.getNguoiBiKNTC());
			inputForm.setChuDanhNguoiBiKNTC(dx.getChuDanhNguoiBiKNTC());
			inputForm.setDcNguoiBiKNTC(dx.getDcNguoiBiKNTC() == null ? "" : dx.getDcNguoiBiKNTC());
			inputForm.setDiaDiem(dx.getDiaDiem() == null ? appContext.getDiaBan() : dx.getDiaDiem());
			inputForm.setLanGui(dx.getLanGui() == null ? "" : dx.getLanGui().toString());
			inputForm.setNoiDungKNTC(dx.getNoiDungKNTC() == null ? "" : dx.getNoiDungKNTC());
			inputForm.setCqDaQG(dx.getCqDaQG() == null ? "" : dx.getCqDaQG());
			inputForm.setNdDaQG(dx.getNdDaQG() == null ? "" : dx.getNdDaQG());
			inputForm.setDeXuatXL(dx.getDeXuat() == null ? "" : dx.getDeXuat());
			inputForm.setNgayTrinhKy(dx.getNgayTrinhKy() == null ? "" : Formater.date2str(dx.getNgayTrinhKy()));
			inputForm.setNgayKy(dx.getNgayKy() == null ? "" : Formater.date2str(dx.getNgayKy()));
			inputForm.setNgayDx(dx.getNgayCapNhat() == null ? Formater.date2str(new Date()) : Formater.date2str(dx.getNgayCapNhat()));
			inputForm.setCanBoTL(Formater.isNull(dx.getCanBoXly()) ? appContext.getTenCanbo() : dx.getCanBoXly());
			inputForm.setKienTrinh(dx.getYKienTrinh() == null ? "" : dx.getYKienTrinh());
			inputForm.setNgayTrinhDuyet(dx.getNgayTrinhDuyet() == null ? "" : Formater.date2str(dx.getNgayTrinhDuyet()));
			inputForm.setNgayDuyet(dx.getNgayDuyet() == null ? "" : Formater.date2str(dx.getNgayDuyet()));
			inputForm.setKienDuyet(dx.getYKienDuyet() == null ? "" : dx.getYKienDuyet());
			inputForm.setGiaiQuyetNgay(dx.getIsGquyetNgay() == null ? "1" : dx.getIsGquyetNgay().toString());
			inputForm.setQuaHan(dx.getIsQuaHan() == null ? "0" : dx.getIsQuaHan().toString());

			// inputForm.setThamQuyen(dx.getThamQuyen());
			// inputForm.setThuLy(dx.getThuLy());
			inputForm.setCanBoTL(dx.getCanBoXly());
			// request.setAttribute("tenThamQuyen",
			// CatalogService.getTenDanhMucById(dx.getThamQuyen()));
			// request.setAttribute("tenThuLy",
			// CatalogService.getTenDanhMucById(dx.getThuLy()));
		}
	}

	/**
	 * Lưu phiếu đề xuất
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveDeXuatXuLyKN(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhanLoaiXuLyService service = new PhanLoaiXuLyService();
		DeXuatXuLyKNForm inputForm = (DeXuatXuLyKNForm) form;
		// String maHs = request.getParameter("id");
		KntcDeXuatXly dx = new KntcDeXuatXly();
		SoTiepDanService s = new SoTiepDanService();
		KntcSoTiepDan hs = s.getSoTiepDan(appContext, inputForm.getMaHoSo(), true);
		KntcHoSoHdr hdr = hs.getHdr();
		if(!"1609".equals(hdr.getTrangThai())){
			request.removeAttribute("ghiThanhcong");
			throw new KtnbException("H&#x1ED3; s&#x1A1; &#x111;&#xE3; duy&#x1EC7;t &#x111;&#x1EC1; xu&#x1EA5;t, kh&#xF4;ng th&#x1EC3; ch&#x1EC9;nh s&#x1EED;a!!!","","H&#7891; s&#417; kh&#244;ng &#7903; tr&#7841;ng th&#225;i &#273;&#7873; xu&#7845;t n&#234;n kh&#244;ng th&#7875; ch&#7881;nh s&#7917;a &#273;&#7873; xu&#7845;t");
		}
		// Kiểm tra các mẫu phụ trong thường hợp Đề xuất có thông tin ký duyệt
		// thì mẫu phụ tương ứng phải hoàn thiện
		if (!StringUtil.isBlankOrNull(inputForm.getNgayDuyet()) && !StringUtil.isBlankOrNull(inputForm.getStrListIdBieuMau())) {
			String[] strIdBieuMau = inputForm.getStrListIdBieuMau().split(",");
			for (int i = 0; i < strIdBieuMau.length; i++) {
				int idBm = Integer.parseInt(strIdBieuMau[i]);
				System.out.println("tham quyen: "+inputForm.getThamQuyen().toString() );
				System.out.println("Thu ly: "+inputForm.getThuLy().toString() );
				System.out.println("idBm: "+idBm );
				//Trường hợp 1 phần thuộc thẩm quyền => Không check mẫu phụ cho phần đơn không thuộc thẩm quyền
				if(Constants.TC_MOT_PHAN_THUOC_THAM_QUYEN.equals(inputForm.getThamQuyen().toString()) || Constants.TC_THUOC_TQ_CUA_CQ_KHAC_VA_CQ_NHAN_DON.equals(inputForm.getThuLy().toString())){
					//Không check mẫu 05,06,20
					
					if(9905!=idBm && 9906!=idBm && 9922!=idBm){
						if (!service.checkMauPhu(idBm, inputForm.getMaHoSo())) {
							request.removeAttribute("ghiThanhcong");
							throw new KtnbException(
									"C&#x1EA7;n ho&#xE0;n thi&#x1EC7;n bi&#x1EC3;u m&#x1EAB;u ph&#x1EE5; cho ph&#x1EA7;n n&#x1ED9;i dung thu&#x1ED9;c th&#x1EA9;m quy&#x1EC1;n, nh&#x1EAD;p &#x111;&#x1EA7;y &#x111;&#x1EE7; s&#x1ED1; quy&#x1EBF;t &#x111;&#x1ECB;nh v&#xE0; ng&#xE0;y ban h&#xE0;nh tr&#x1B0;&#x1EDB;c khi l&#x1B0;u &#x111;&#x1EC1; xu&#x1EA5;t c&#xF3; k&#xFD; duy&#x1EC7;t",
									"Ki&#x1EC3;m tra m&#x1EAB;u ph&#x1EE5; " + Constants.getMauPhu(idBm));
						}
					}
				}
				//Trường hợp thuộc thẩm quyền
				//Không check 2 TH
				//Thuộc thẩm quyền của CQT cấp dưới nhưng quá thời hạn quy định mà không được giải quyết 
				//Đã được CQT cấp dưới giải quyết nhưng có căn cứ cho rằng việc giải quyết không đúng pháp luật 
				else if(Constants.TC_THUOC_THAM_QUYEN.equals(inputForm.getThamQuyen().toString()))
				{
					if(!Constants.TC_CQ_DUOI_GQ_NHUNG_SAI_PL.equals(inputForm.getThuLy().toString())&&!Constants.TC_QUA_HAN_GQ_CUA_CQ_DUOI.equals(inputForm.getThuLy().toString()))
					{
//						idBm=Integer.parseInt(service.IdMauPhu(inputForm.getMaHoSo(),appContext));
//						System.out.println("idBm TC: "+idBm );
						//khong du dieu kien giai quyet
						if(!Constants.TC_KO_DU_DK.equals(inputForm.getThuLy().toString())&&!Constants.TC_CAP_DUOI_GQ_KO_CO_TT_MOI.equals(inputForm.getThuLy().toString()))
						{
							if (!service.checkMauPhuTC(idBm, inputForm.getMaHoSo())) {
								request.removeAttribute("ghiThanhcong");
								throw new KtnbException(
										"C&#x1EA7;n ho&#xE0;n thi&#x1EC7;n bi&#x1EC3;u m&#x1EAB;u ph&#x1EE5; cho ph&#x1EA7;n n&#x1ED9;i dung thu&#x1ED9;c th&#x1EA9;m quy&#x1EC1;n, nh&#x1EAD;p &#x111;&#x1EA7;y &#x111;&#x1EE7; s&#x1ED1; quy&#x1EBF;t &#x111;&#x1ECB;nh v&#xE0; ng&#xE0;y ban h&#xE0;nh tr&#x1B0;&#x1EDB;c khi l&#x1B0;u &#x111;&#x1EC1; xu&#x1EA5;t c&#xF3; k&#xFD; duy&#x1EC7;t",
										"Ki&#x1EC3;m tra m&#x1EAB;u ph&#x1EE5; " + Constants.getMauPhu(idBm));
							}
						}
						
					}
				}
				//Trường hợp khác
				else{
					if (!service.checkMauPhu(idBm, inputForm.getMaHoSo())) {
						request.removeAttribute("ghiThanhcong");
						throw new KtnbException(
								"C&#7847;n ho&#224;n thi&#7879;n bi&#7875;u m&#7851;u ph&#7909;, nh&#7853;p &#273;&#7847;y &#273;&#7911; s&#7889; quy&#7871;t &#273;&#7883;nh v&#224; ng&#224;y ban h&#224;nh tr&#432;&#7899;c khi l&#432;u &#273;&#7873; xu&#7845;t c&#243; k&#253; duy&#7879;t",
								"Ki&#x1EC3;m tra m&#x1EAB;u ph&#x1EE5; " + Constants.getMauPhu(idBm));
					}
				}
			}
		}
		// Xử lý lưu đề xuất
		try {
			dx.setNguoiKNTC(inputForm.getNguoiKNTC());
			dx.setDcNguoiKNTC(inputForm.getDcNguoiKNTC());
			dx.setChuDanhNguoiKNTC(inputForm.getChuDanhNguoiKNTC());
			dx.setNguoiBiKNTC(inputForm.getNguoiBiKNTC());
			dx.setDcNguoiBiKNTC(inputForm.getDcNguoiBiKNTC());
			dx.setChuDanhNguoiBiKNTC(inputForm.getChuDanhNguoiBiKNTC());
			dx.setCanBoXly(appContext.getTenCanbo());
			dx.setLanGui(new Long(inputForm.getLanGui()));
			dx.setCqDaQG(inputForm.getCqDaQG());
			dx.setNdDaQG(inputForm.getNdDaQG());
			dx.setNgayCapNhat(Formater.str2date(inputForm.getNgayDx()));
			dx.setNguoiCapNhat(appContext.getTenNsd());
			dx.setDiaDiem(inputForm.getDiaDiem());
			dx.setMaHs(inputForm.getMaHoSo());
			dx.setMa(inputForm.getMa());
			dx.setDeXuat(inputForm.getDeXuatXL());
			dx.setNgayTrinhKy(Formater.str2date(inputForm.getNgayTrinhKy()));
			dx.setNgayKy(Formater.str2date(inputForm.getNgayKy()));
			dx.setYKienTrinh(inputForm.getKienTrinh());
			dx.setYKienDuyet(inputForm.getKienDuyet());
			if ("phanloaiHSTC".equals(request.getParameter("action"))) {
				dx.setIsGquyetNgay(new Long(0));// phai xac minh
			} else {
				dx.setIsGquyetNgay(new Long(inputForm.getGiaiQuyetNgay()));
			}
			dx.setNgayTrinhDuyet(Formater.str2date(inputForm.getNgayTrinhDuyet()));
			dx.setNgayDuyet(Formater.str2date(inputForm.getNgayDuyet()));
			dx.setThamQuyen(inputForm.getThamQuyen());
			dx.setThuLy(inputForm.getThuLy());
			dx.setNoiDung(inputForm.getDonTomTat());
			dx.setArrTenTl(inputForm.getArrTenTl());
			dx.setNoiDungKNTC(inputForm.getNoiDungKNTC());
			if (Formater.isNull(inputForm.getQuaHan()))
				inputForm.setQuaHan("0");
			dx.setIsQuaHan(new Long(inputForm.getQuaHan()));
			// Tạo Đề xuất xử lý full để lưu
			KntcDeXuatXuLy dxxl = new KntcDeXuatXuLy(dx);
			ArrayList listNoiDung = new ArrayList();
			// Lưu danh mục nội dung
			String arrDms = inputForm.getArrDms();
			if (!Formater.isNull(arrDms)) {
				String[] arr = arrDms.split(",");
				for (int i = 0; i < arr.length; i++) {
					if (!Formater.isNull(arr[i])) {
						KntcDmRlsId dmId = new KntcDmRlsId();
						dmId.setMaDm(arr[i]);
						dmId.setMaHs(inputForm.getMaHoSo());
						KntcDmRls dmRls = new KntcDmRls();
						dmRls.setId(dmId);
						dmRls.setLoaiRls(KntcDmRls.DE_XUAT_XU_LY_RLS);
						listNoiDung.add(dmRls);
					}
				}
			}
			dxxl.setDmRls(listNoiDung);
			service.saveDeXuatXyLyKN(appContext, dxxl, s.getNgayKetThuc(dx.getMaHs(), request));	
			//Nếu có thông tin ngày duyệt thì update sổ tiếp dân, cập nhật ngày kết thúc dự kiến
			//if (dx.getNgayDuyet() != null) {				
				//hdr.setNgayKetThucDuKien(s.getNgayKetThuc(dx.getMaHs(), request));
				//s.saveSoTiepDan(appContext, hs, false);
			//}
			if (StringUtil.isBlankOrNull(request.getParameter("warning")))
				request.setAttribute("ghiThanhcong", "1");
		} catch (Exception ex) {
			if (StringUtil.isBlankOrNull(request.getParameter("warning")))
				request.setAttribute("ghiThanhcong", "0");
			ex.printStackTrace();
			throw ex;
		}
		loadDefaultValue(map, form, request, response);
		return map.findForward(request.getParameter("action"));
	}

	/**
	 * Show tách đơn
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward tachDon(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
		TachDonForm f = (TachDonForm) form;
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs)) {
			f.setMaHoSo(maHs);
			f.setMaHoSoKN(maHs + "/KN");
			f.setMaHoSoTC(maHs + "/TC");
			SoTiepDanService s = new SoTiepDanService();
			KntcSoTiepDan hs = s.getSoTiepDan(appContext, maHs, true);
			// KntcNdungDon hdr = hs.getHdr().getNoiDung();
			if (hs != null)
				f.setNoiDungDon(hs.getHdr().getNoiDung());
		}
		return map.findForward("tachDon");
	}

	/**
	 * Save Tách đơn
	 * 
	 * @param map
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveTachDon(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(cmc.com.ktnb.util.Constants.APP_CONTEXT);
		TachDonForm f = (TachDonForm) form;
		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();

			// 1. Ket thuc ho so cu
			SoTiepDanService s = new SoTiepDanService();
			KntcSoTiepDan hosoP = s.getSoTiepDan(appContext, f.getMaHoSo(), true);
			KntcHoSoHdr hdrParent = hosoP.getHdr();
			String sql = "Update KNTC_HO_SO_HDR set TRANG_THAI=?,LOAI_KET_THUC=? where MA_HS=?";
			Query q = session.createSQLQuery(sql);
			q.setParameter(0, new Long(Constants.TT_KNTC_KET_THUC));
			q.setParameter(1, Constants.KNTC_KET_THUC_TACH_DON);
			q.setParameter(2, hdrParent.getMaHs());
			q.executeUpdate();

			// 2.Save hs khieu nai moi
			KntcHoSoHdr hdrKN = new KntcHoSoHdr(appContext, hdrParent);
			hdrKN.setMa(null);
			hdrKN.setMaHsCha(hdrParent.getMaHs());
			hdrKN.setLoaiQh(Constants.LIEN_KET_CHA);
			hdrKN.setMaHs(f.getMaHoSoKN());
			// hdrKN.setMaCanBo(appContext.getMaCanbo());
			// hdrKN.setNguoiCapNhat(appContext.getTenCanbo());
			hdrKN.setLoaiKntc(new Long(1));
			hdrKN.setLoaiHs(new Long(2));
			hdrKN.setTrangThai(Constants.TT_KNTC_PHAN_LOAI_DX_XLY);
			hdrKN.setNoiDung(f.getNoiDungKN());
			KntcSoTiepDan hosoKN = new KntcSoTiepDan(hdrKN);
			CatalogService cs = new CatalogService();
			String[] arrCb = f.getArrTlktKN().split(",");
			if (arrCb != null && arrCb.length > 0) {
				for (int i = 0; i < arrCb.length; i++) {
					if (!Formater.isNull(arrCb[i])) {
						KtnbTlieuKemTheo fDb = (KtnbTlieuKemTheo) cs.retriveById(appContext, KtnbTlieuKemTheo.class, arrCb[i]);
						KtnbTlieuKemTheo aCb = new KtnbTlieuKemTheo();
						aCb.setMaHoSo(hdrKN.getMaHs());
						aCb.setLoaiTlieu(KtnbTlieuKemTheo.TLKT_SO_TIEP_DAN);
						aCb.setSoTrang(fDb.getSoTrang());
						aCb.setTenTlieu(fDb.getTenTlieu());
						aCb.setTinhTrang(fDb.getTinhTrang());
						aCb.setNguoiCapNhat(appContext.getTenNsd());
						aCb.setNgayCapNhat(appContext.getSystemDate());
						hosoKN.addTailieu(aCb);
					}
				}
			}

			s.saveSoTiepDan(appContext, hosoKN, true);
			// 3.Save ho so to cao moi
			KntcHoSoHdr hdrTC = new KntcHoSoHdr(appContext, hdrParent);
			hdrTC.setMa(null);
			hdrTC.setMaHsCha(hdrParent.getMaHs());
			hdrTC.setLoaiQh(Constants.LIEN_KET_CHA);
			// hdrTC.setMaCanBo(appContext.getMaCanbo());
			// hdrTC.setNguoiCapNhat(appContext.getTenCanbo());
			hdrTC.setMaHs(f.getMaHoSoTC());
			hdrTC.setLoaiKntc(new Long(2));
			hdrTC.setLoaiHs(new Long(2));
			hdrTC.setTrangThai(Constants.TT_KNTC_PHAN_LOAI_DX_XLY);
			hdrTC.setNoiDung(f.getNoiDungTC());
			KntcSoTiepDan hosoTC = new KntcSoTiepDan(hdrTC);
			arrCb = f.getArrTlktTC().split(",");
			if (arrCb != null && arrCb.length > 0) {
				for (int i = 0; i < arrCb.length; i++) {
					if (!Formater.isNull(arrCb[i])) {
						KtnbTlieuKemTheo fDb = (KtnbTlieuKemTheo) cs.retriveById(appContext, KtnbTlieuKemTheo.class, arrCb[i]);
						KtnbTlieuKemTheo aCb = new KtnbTlieuKemTheo();
						aCb.setMaHoSo(hdrTC.getMaHs());
						aCb.setLoaiTlieu(KtnbTlieuKemTheo.TLKT_SO_TIEP_DAN);
						aCb.setSoTrang(fDb.getSoTrang());
						aCb.setTenTlieu(fDb.getTenTlieu());
						aCb.setTinhTrang(fDb.getTinhTrang());
						aCb.setNguoiCapNhat(appContext.getTenNsd());
						aCb.setNgayCapNhat(appContext.getSystemDate());
						hosoTC.addTailieu(aCb);
					}
				}
			}
			s.saveSoTiepDan(appContext, hosoTC, true);
			session.flush();
			tx.commit();
			request.setAttribute("ghiThanhcong", "1");
			// HttpUtil.doForward("kntc_tiep_dan.do?method=view&id=" +
			// hdrParent.getMaHs(), request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("ghiThanhcong", "0");
			tx.rollback();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		return map.findForward("tachDon");
		// return null;
	}

	public ActionForward getListTlktKnTachDon(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonResult = null;
		TachDonForm dxForm = (TachDonForm) form;
		try {
			jsonResult = this.createObject(dxForm, request, true, "KN");
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

	public ActionForward getListTlktTcTachDon(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonResult = null;
		TachDonForm dxForm = (TachDonForm) form;
		try {
			jsonResult = this.createObject(dxForm, request, true, "TC");
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

	public ActionForward getListTL(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonResult = null;
		DeXuatXuLyKNForm dxForm = (DeXuatXuLyKNForm) form;
		try {
			jsonResult = this.createObject(dxForm, request);
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

	private JSONObject createObject(BaseActionForm dxForm, HttpServletRequest request) throws Exception {
		String maHs = request.getParameter("id");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			conn = DataSourceConfiguration.getConnection();
			StringBuffer sb = new StringBuffer("select ten_tlieu,so_trang,tinh_trang,MA_TLIEU from ktnb_tl_kem_theo where ma_ho_so = ? order by ten_tlieu");
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, maHs);
			System.out.println(sb.toString());
			JSONArray jsonArray = new JSONArray();
			int rc = 0;
			rs = ps.executeQuery();
			while (rs.next()) {
				JSONArray ja;
				ja = new JSONArray();
				ja.put("<input type=\"text\" name=\"tenTL\" id=\"tenTL" + rc + "\" value=\"" + rs.getString(1) + "\" style=\"width: 100%\">");// ten
				ja.put("<input type=\"text\" name=\"soTrangTL\" id=\"soTrangTL" + rc + "\" value=\"" + rs.getString(2) + "\" style=\"width: 100%\" maxlength=\"3\" onblur=\"isNumber(this,'i');\" />");// sotrang

				String s1 = "";
				String s2 = "";
				String s3 = "";
				String tinhTrang = URLUTF8Encoder.encode(rs.getString(3));
				if ("B%e1%ba%a3n+ch%c3%adnh".equals(tinhTrang)) {
					s1 = "selected=\"selected\"";
				} else if ("B%e1%ba%a3n+sao".equals(tinhTrang)) {
					s2 = "selected=\"selected\"";
				} else if ("B%e1%ba%a3n+sao+c%c3%b3+c%c3%b4ng+ch%e1%bb%a9ng".equals(tinhTrang)) {
					s3 = "selected=\"selected\"";
				}

				ja.put("<select id=\"tinhTrang" + rc + "\">" + "<option value=\"B&#7843;n ch&#237;nh\" " + s1 + ">B&#7843;n ch&#237;nh</option>" + "<option value=\"B&#7843;n sao\" " + s2
						+ ">B&#7843;n sao</option>" + "<option value=\"B&#7843;n sao c&#243; c&#244;ng ch&#7913;ng\" " + s3 + ">B&#7843;n sao c&#243; c&#244;ng ch&#7913;ng</option>" + "</select>");// tinhtrang

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

	private JSONObject createObject(BaseActionForm dxForm, HttpServletRequest request, boolean hasCheckBox, String nVu) throws Exception {
		// Get ma Ho so
		String maHs = request.getParameter("id");
		// if (!Formater.isNull(maHs))
		// dxForm.setMaHoSo(maHs);
		// else
		// maHs = dxForm.getMaHoSo();
		// Create Object
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			conn = DataSourceConfiguration.getConnection();
			StringBuffer sb = new StringBuffer("select ten_tlieu,so_trang,tinh_trang,MA_TLIEU from ktnb_tl_kem_theo where ma_ho_so = ? order by ten_tlieu");
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, maHs);
			System.out.println(sb.toString());
			JSONArray jsonArray = new JSONArray();
			int rc = 0;
			rs = ps.executeQuery();
			while (rs.next()) {
				JSONArray ja;
				ja = new JSONArray();
				ja.put(rs.getString(1));// ten
				if (!Formater.isNull(rs.getString(2)))
					ja.put(rs.getString(2));// sotrang
				else
					ja.put("");
				ja.put(rs.getString(3));// tinhtrang
				if (hasCheckBox)
					ja.put("<input type=checkbox id='dmTl" + nVu + "' checked name='dmTl" + nVu + "' value='" + rs.getString(4) + "' />");
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

	public ActionForward in_old(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		DeXuatXuLyKNForm dxForm = (DeXuatXuLyKNForm) form;
		String maHs = dxForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			SoTiepDanService stdService = new SoTiepDanService();
			KntcSoTiepDan std = stdService.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = std.getHdr();
			String fileTemplate = "kntc04";
			String arrDms = dxForm.getArrDms();
			String[] arr = arrDms.split(",");
			StringBuffer sb = new StringBuffer();
			// reportRows = new HashMap[arr.length];
			for (int i = 0; i < arr.length; i++) {
				if (!Formater.isNull(arr[i])) {
					sb.append("+ " + CatalogService.getTenDanhMucById(arr[i]));
					sb.append("\n");
				}
			}
			parameters.put("khieu_nai_noi_dung", sb.toString());
			if (hdr.getLoaiKntc().equals(new Long("2"))) {
				// ----------------//
				fileTemplate = "kntc04";
				parameters.put("to_cao_noi_dung", sb.toString());
			}
			parameters.put("CO_QUAN_THUE_TRUC_TIEP", appContext.getTenCqt());
			parameters.put("BO_PHAN_DUOC_GIAO_XU_LY_DON", appContext.getTenPhong());
			parameters.put("nguoi_co_quan_don_vi_khieu_nai", dxForm.getNguoiKNTC());
			if (!Formater.isNull(dxForm.getChuDanhNguoiKNTC()))
				parameters.put("chuc_danh_nguoi_khieu_nai", "Ch\u1EE9c danh: " + dxForm.getChuDanhNguoiKNTC());
			parameters.put("dia_chi_nguoi_co_quan_don_vi_khieu_nai", dxForm.getDcNguoiKNTC());

			parameters.put("nguoi_co_quan_don_vi_bi_khieu_nai", dxForm.getNguoiBiKNTC());
			if (!Formater.isNull(dxForm.getChuDanhNguoiBiKNTC()))
				parameters.put("chuc_danh_nguoi_bi_khieu_nai", "Ch\u1EE9c danh: " + dxForm.getChuDanhNguoiBiKNTC());
			parameters.put("dia_chi_nguoi_co_quan_don_vi_bi_khieu_nai", dxForm.getDcNguoiBiKNTC());
			parameters.put("don_gui_lan_thu", dxForm.getLanGui());
			parameters.put("ten_co_quan_giai_quyet", dxForm.getCqDaQG());
			parameters.put("ket_qua_da_giai_quyet", dxForm.getNdDaQG());
			parameters.put("tom_tat_noi_dung_don", dxForm.getDonTomTat());
			parameters.put("khieu_nai_noi_dung", dxForm.getNoiDungKNTC());
			Collection tl = stdService.getListTlkt(appContext, maHs);
			sb = new StringBuffer();
			for (Iterator iter = tl.iterator(); iter.hasNext();) {
				KtnbTlieuKemTheo tlKt = (KtnbTlieuKemTheo) iter.next();
				sb.append("+" + tlKt.getTenTlieu() + "; s\u1ED1 trang: " + tlKt.getSoTrang() + "; t\u00ECnh tr\u1EA1ng: " + tlKt.getTinhTrang());
				sb.append("\n");
			}
			parameters.put("tai_lieu_kem_theo", sb.toString());
			PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
			KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
			parameters.put("de_xuat_xu_ly", CatalogService.getTenDanhMucById(dx.getThamQuyen()) + "<br> \u0110\u1EC1 xu\u1EA5t x\u1EED l\u00FD: " + dxForm.getDeXuatXL());
			parameters.put("can_bo_de_xuat", appContext.getTenCanbo());
			String ngayLap = "";
			if (Formater.isNull(dxForm.getNgayDx())) {
				ngayLap = "ng\u00E0y   th\u00E1ng   n\u0103m        ";
				parameters.put("ngay_de_xuat", dxForm.getDiaDiem() + ", " + ngayLap);
			} else
				parameters.put("ngay_de_xuat", dxForm.getDiaDiem() + ", " + Formater.getDateForPrint(dxForm.getNgayDx()));
			parameters.put("ten_bo_phan", appContext.getTenPhong());
			parameters.put("tt_cqt", appContext.getTenCqt());
			parameters.put("ten_thu_truong", appContext.getTenThuTruong());
			parameters.put("ten_truong_bo_phan", appContext.getTenTruongPhong());
			parameters.put("y_kien_cua_truong_bo_phan", dxForm.getKienTrinh());
			parameters.put("ngay_truong_bo_phan_ky", dxForm.getDiaDiem() + ", " + Formater.getDateForPrint(dxForm.getNgayKy()));
			parameters.put("y_kien_cua_thu_truong_co_quan", dxForm.getKienDuyet());
			parameters.put("ngay_thu_truong_phe_duyet", dxForm.getDiaDiem() + ", " + Formater.getDateForPrint(dxForm.getNgayDuyet()));
			//parameters.put("ten_thu_truong", appContext.getTenThuTruong());
			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
			KtnbUtil.printf(reportRows, fileTemplate, response, inputStream, parameters, null);
		}
		return null;
	}

	/**
	 * Download file mau KNTC04
	 * 
	 * @throws Exception
	 */
	public ActionForward in(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String fileIn = null;
		String fileOut = null;

		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);

		DeXuatXuLyKNForm dxForm = (DeXuatXuLyKNForm) form;
		String maHs = dxForm.getMaHoSo();
		if (!Formater.isNull(maHs)) {
			SoTiepDanService stdService = new SoTiepDanService();
			KntcSoTiepDan std = stdService.getSoTiepDan(appContext, maHs, true);
			KntcHoSoHdr hdr = std.getHdr();
			String fileTemplate = "kntc04";
			// ktra xem mau in cho Khieu nai hay To cao
			if (hdr.getLoaiKntc().equals(new Long("2"))) {
				fileIn = request.getRealPath("/docin") + "\\KNTC04_TC.doc";
				fileOut = request.getRealPath("/docout") + "\\KNTC04_TC_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
				fileTemplate = "KNTC04_TC";
			} else if (hdr.getLoaiKntc().equals(new Long("1"))) {
				fileIn = request.getRealPath("/docin") + "\\KNTC04.doc";
				fileOut = request.getRealPath("/docout") + "\\KNTC04_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
				fileTemplate = "KNTC04";
			}
			MsWordUtils word = null;
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[CO_QUAN_THUE_TRUC_TIEP]", appContext.getTenCqt().toUpperCase());
				word.put("[BO_PHAN_DUOC_GIAO_XU_LY_DON]", appContext.getTenPhong().toUpperCase());
				word.put("[nguoi_co_quan_don_vi_khieu_nai]", dxForm.getNguoiKNTC());
				if (Formater.isNull(dxForm.getChuDanhNguoiKNTC())) {
					word.put("[chuc_danh_nguoi_khieu_nai]", "Ch\u1EE9c danh: " + KtnbUtil.inFieldNull(100));
				} else {
					word.put("[chuc_danh_nguoi_khieu_nai]", "Ch\u1EE9c danh: " + dxForm.getChuDanhNguoiKNTC());
				}
				if (Formater.isNull(dxForm.getDcNguoiKNTC())) {
					word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", KtnbUtil.inFieldNull(102));
				} else {
					word.put("[dia_chi_nguoi_co_quan_don_vi_khieu_nai]", dxForm.getDcNguoiKNTC());
				}
				word.put("[nguoi_co_quan_don_vi_bi_khieu_nai]", dxForm.getNguoiBiKNTC());
				if (Formater.isNull(dxForm.getChuDanhNguoiBiKNTC())) {
					word.put("[chuc_danh_nguoi_bi_khieu_nai]", "Ch\u1EE9c danh: " + KtnbUtil.inFieldNull(100));
				} else {
					word.put("[chuc_danh_nguoi_bi_khieu_nai]", "Ch\u1EE9c danh: " + dxForm.getChuDanhNguoiBiKNTC());
				}
				if (Formater.isNull(dxForm.getDcNguoiBiKNTC())) {
					word.put("[dia_chi_nguoi_co_quan_don_vi_bi_khieu_nai]", KtnbUtil.inFieldNull(104));
				} else {
					word.put("[dia_chi_nguoi_co_quan_don_vi_bi_khieu_nai]", dxForm.getDcNguoiBiKNTC());
				}
				word.put("[don_gui_lan_thu]", dxForm.getLanGui());
				word.put("[ten_co_quan_giai_quyet]", dxForm.getCqDaQG());
				word.put("[ket_qua_da_giai_quyet]", dxForm.getNdDaQG());
				String arrDms = dxForm.getArrDms();
				String[] arr = arrDms.split(",");
				StringBuffer sb = new StringBuffer();
				// reportRows = new HashMap[arr.length];
				for (int i = 0; i < arr.length; i++) {
					if (!Formater.isNull(arr[i])) {
						sb.append("+ " + CatalogService.getTenDanhMucById(arr[i]));
						sb.append("\n");
					}
				}
				if (Formater.isNull(dxForm.getDonTomTat()))
					word.put("[tom_tat_noi_dung_don]", KtnbUtil.inFieldNull(87));
				else
					word.put("[tom_tat_noi_dung_don]", dxForm.getDonTomTat());
				// if (hdr.getLoaiKntc().equals(new Long("2"))) {
				// word.put("[to_cao_noi_dung]", sb.toString());
				// }else if (hdr.getLoaiKntc().equals(new Long("1"))){
				// word.put("[khieu_nai_noi_dung]", sb.toString());
				// }
				if (Formater.isNull(dxForm.getNoiDungKNTC()))
					word.put("[khieu_nai_noi_dung]", KtnbUtil.inFieldNull(118));
				else
					word.put("[khieu_nai_noi_dung]", dxForm.getNoiDungKNTC());
				Collection tl = stdService.getListTlkt(appContext, maHs);
				sb = new StringBuffer();
				for (Iterator iter = tl.iterator(); iter.hasNext();) {
					KtnbTlieuKemTheo tlKt = (KtnbTlieuKemTheo) iter.next();
					sb.append("+ " + tlKt.getTenTlieu());
					if (!tlKt.getSoTrang().equals("") && !String.valueOf(tlKt.getSoTrang()).equals("0"))
						sb.append("; s\u1ED1 trang: " + tlKt.getSoTrang());
					sb.append("; t\u00ECnh tr\u1EA1ng: " + tlKt.getTinhTrang() + ".");
					sb.append("\n");
				}
				// check xem co tai lieu kem theo hok
				if (sb.toString().length() == 0)
					word.put("[tai_lieu_kem_theo]", KtnbUtil.inFieldNull(116));
				else
					word.put("[tai_lieu_kem_theo]", sb.toString().substring(0, sb.toString().length() - 1));
				PhanLoaiXuLyService plService = new PhanLoaiXuLyService();
				KntcDeXuatXly dx = plService.getDeXuatXly(appContext, maHs);
				if (dx == null)
					throw new KtnbException("C&#x1EA7;n l&#x1B0;u &#x111;&#x1EC1; xu&#x1EA5;t tr&#x1B0;&#x1EDB;c khi in", "C&#x1EA7;n l&#x1B0;u &#x111;&#x1EC1; xu&#x1EA5;t tr&#x1B0;&#x1EDB;c khi in");
				StringBuffer de_xuat_xl = new StringBuffer(CatalogService.getTenDanhMucById(dx.getThamQuyen()) + ".\n\u0110\u1EC1 xu\u1EA5t x\u1EED l\u00FD: ");
				if (Formater.isNull(dxForm.getDeXuatXL()))
					de_xuat_xl.append("\n" + KtnbUtil.inFieldNull(115));
				else
					de_xuat_xl.append("\n" + dxForm.getDeXuatXL());
				word.put("[de_xuat_xu_ly]", de_xuat_xl.toString());
				String ngayLap = "ng\u00E0y....th\u00E1ng....n\u0103m....";
				if (Formater.isNull(dxForm.getDiaDiem()) && Formater.isNull(dxForm.getNgayDx())) {
					word.put("[ngay_de_xuat]", "......, " + ngayLap);
				} else if (!Formater.isNull(dxForm.getDiaDiem()) && !Formater.isNull(dxForm.getNgayDx())) {
					word.put("[ngay_de_xuat]", dxForm.getDiaDiem() + ", " + Formater.getDateForPrint(dxForm.getNgayDx()));
				} else if (!Formater.isNull(dxForm.getDiaDiem()) && Formater.isNull(dxForm.getNgayDx())) {
					word.put("[ngay_de_xuat]", dxForm.getDiaDiem() + ", " + ngayLap);
				} else {
					word.put("[ngay_de_xuat]", "......, " + Formater.getDateForPrint(dxForm.getNgayDx()));
				}
				if (Formater.isNull(appContext.getTenCanbo())) {
					word.put("[can_bo_de_xuat]", "");
				} else {
					word.put("[can_bo_de_xuat]", appContext.getTenCanbo());
				}
				// if(Formater.isNull(dxForm.getKienTrinh())){
				// word.put("[y_kien_cua_truong_bo_phan]",
				// KtnbUtil.inFieldNull(76));
				// }else{
				// word.put("[y_kien_cua_truong_bo_phan]",
				// dxForm.getKienTrinh());
				// }
				if (Formater.isNull(dxForm.getDiaDiem())) {
					word.put("[ngay_truong_bo_phan_ky]", "......, " + Formater.getDateForPrint(dxForm.getNgayKy()));
				} else {
					word.put("[ngay_truong_bo_phan_ky]", dxForm.getDiaDiem() + ", " + Formater.getDateForPrint(dxForm.getNgayKy()));
				}
				word.put("[ten_bo_phan]", appContext.getTenPhong());
				word.put("[ten_truong_bo_phan]", appContext.getTenTruongPhong());
				if (Formater.isNull(dxForm.getKienDuyet())) {
					word.put("[y_kien_cua_thu_truong_co_quan]", KtnbUtil.inFieldNull(61));
				} else {
					word.put("[y_kien_cua_thu_truong_co_quan]", dxForm.getKienDuyet());
				}
				if (Formater.isNull(dxForm.getDiaDiem())) {
					word.put("[ngay_thu_truong_phe_duyet]", "......, " + Formater.getDateForPrint(dxForm.getNgayDuyet()));
				} else {
					word.put("[ngay_thu_truong_phe_duyet]", dxForm.getDiaDiem() + ", " + Formater.getDateForPrint(dxForm.getNgayDuyet()));
				}
				word.put("[tt_cqt]", appContext.getTenCqt());
				//word.put("[ten_thu_truong]", appContext.getTenThuTruong());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau " + fileTemplate, ".doc", response);
			} catch (Exception ex) {				
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
				throw ex;
			} finally {				
				try { 
					word.saveAndClose();
				} catch (Exception e) {
					
				}
			}

		}
		return null;
	}
}
