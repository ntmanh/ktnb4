/*
 * Created on Nov 1, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.dung_chung.action;

import java.io.InputStream;
import java.util.ArrayList;
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

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThayDoiThemMoiTvd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThayDoiTvd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.catalog.CatalogService;
import cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.form.HuyThanhTraKiemTraForm;
import cmc.com.ktnb.web.ttkt.dung_chung.form.ThayDoiThanhVienDoanForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktService;

/**
 * @author ntdung1
 * 
 * To change the template for this generated type comment go to Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ThayDoiThanhVienDoanAction extends BaseDispatchAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception, Exception {
		ThayDoiThanhVienDoanForm thayDoiThanhVienDoanForm = (ThayDoiThanhVienDoanForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String method = request.getParameter("method");
		String cuocTtktId = "";
		if ("save".equals(method)) {
			TtktCmThayDoiTvd thayDoiTvd = createThayDoiTvd(appContext, request, thayDoiThanhVienDoanForm);
			TtktService.saveThayDoiTvd(appContext, thayDoiTvd);
			request.setAttribute("saveStatus", "true");
			cuocTtktId = thayDoiThanhVienDoanForm.getIdCuocTtkt();

		} else if ("in".equals(method)) {
			inThayDoiThanhVien(request, appContext, thayDoiThanhVienDoanForm, reponse);
			return null;
		} else {
			cuocTtktId = request.getParameter("idCuocTtkt");
			if (!Formater.isNull(cuocTtktId)) {
				if (Formater.isNull(method)) {
					Collection dsThayDoiTvd = TtktService.getDsThayDoiTvd(appContext, cuocTtktId);
					if (appContext.isTruongDoan(cuocTtktId)) {
						if (Formater.isNull(dsThayDoiTvd)) {
							addNew(appContext, thayDoiThanhVienDoanForm, cuocTtktId);

						} else {
							// Mo danh sach de xem
							request.getSession().setAttribute("dsThayDoiTvd", dsThayDoiTvd);
							reponse.sendRedirect("danh_sach_tim_kiem.do?idCuocTtkt=" + cuocTtktId + "&type=thayDoiThanhVienDoan");
						}
					} else {
						if (dsThayDoiTvd.size() == 1) {
							loadDataToForm((TtktCmThayDoiTvd) ((ArrayList) dsThayDoiTvd).get(0), appContext, request, thayDoiThanhVienDoanForm);
							request.setAttribute("readOnly", "true");

						} else {
							request.getSession().setAttribute("dsThayDoiTvd", dsThayDoiTvd);
							reponse.sendRedirect("danh_sach_tim_kiem.do?idCuocTtkt=" + cuocTtktId + "&type=thayDoiThanhVienDoan");
						}

					}
				} else if ("adnew".equals(method)) {
					if (TtktService.isChuaDuyetThayDoiTvd(appContext, cuocTtktId)) {
						KtnbUtil.showBussinessExceiption(request, reponse,
								"Kh\u00F4ng th\u1EC3 thay \u0111\u1ED5i th\u00E0nh vi\u00EAn \u0111o\u00E0n do t\u1ED3n t\u1EA1i thay \u0111\u1ED5i ch\u01B0a \u0111\u01B0\u1EE3c duy\u1EC7t!");
					}
					thayDoiThanhVienDoanForm.setIdCuocTtkt(cuocTtktId);
				}

			} else {
				String id = request.getParameter("id");
				TtktCmThayDoiTvd thayDoiTvd = TtktService.getThayDoiThanhVienDoan(appContext, id);
				loadDataToForm(thayDoiTvd, appContext, request, thayDoiThanhVienDoanForm);
				cuocTtktId = thayDoiTvd.getIdCuocTtkt();
				if (!Formater.isNull(thayDoiTvd.getSoQd()) || appContext.getTrangThaiCuocTtkt(cuocTtktId).equals(Constants.TT_TTKT_KT)) {
					request.setAttribute("readOnly", "true");
				}
			}
		}
		// Van ban quy dinh chuc nang nhiem vu
		KtnbUtil.setVanBan(CuocTtktService.getCuocTtktTrongQdWithoutNoiDung(appContext, cuocTtktId).getIdDonViTh(), request);
		setDsTvdToClient(cuocTtktId, request);

		return mapping.findForward("success");
	}

	private void addNew(ApplicationContext appContext, ThayDoiThanhVienDoanForm thayDoiThanhVienDoanForm, String cuocTtktId) {
		thayDoiThanhVienDoanForm.setIdCuocTtkt(cuocTtktId);

	}

	/**
	 * @param cuocTtktId
	 * @param request
	 */
	private void setDsTvdToClient(String cuocTtktId, HttpServletRequest request) {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		Collection dsThanhVienDoan = TtktService.getDanhSachThanhVienDoan(cuocTtktId);
		request.setAttribute("dsThanhVienDoan", dsThanhVienDoan);

		String dsIdThanhVienDoan = "";
		String dsChucVuTrongDoan = "";
		String dsTenThanhVienDoan = "";
		Iterator iter = dsThanhVienDoan.iterator();
		while (iter.hasNext()) {
			TtktCbChiTietDsTvDoan thanhVienDoan = (TtktCbChiTietDsTvDoan) iter.next();

			dsIdThanhVienDoan += thanhVienDoan.getIdCanBo() + ",";
			dsChucVuTrongDoan += thanhVienDoan.getChucVuTrongDoan() + ",";
			dsTenThanhVienDoan += thanhVienDoan.getTenCanBo() + ",";
		}
		request.setAttribute("dsThanhVienDoan", dsThanhVienDoan);

		request.setAttribute("dsIdThanhVienDoan", dsIdThanhVienDoan.substring(0, dsIdThanhVienDoan.length() - 1));
		request.setAttribute("dsChucVuTrongDoan", dsChucVuTrongDoan.substring(0, dsChucVuTrongDoan.length() - 1));
		request.setAttribute("dsTenThanhVienDoan", dsTenThanhVienDoan.substring(0, dsTenThanhVienDoan.length() - 1));
		try {
			TtktCbQd qD = TtktService.getQuyetDinh(cuocTtktId, appContext);
			request.setAttribute("ngayRaQuyetDnh", qD.getNgayRaQuyetDnh());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param tvd
	 * @param appContext
	 * @param request
	 */
	private void loadDataToForm(TtktCmThayDoiTvd thayDoiTvd, ApplicationContext appContext, HttpServletRequest request, ThayDoiThanhVienDoanForm thayDoiThanhVienDoanForm) throws Exception {

		thayDoiThanhVienDoanForm.setChucVuNguoiDeNghi(thayDoiTvd.getChucVuNguoiDeNghi());
		thayDoiThanhVienDoanForm.setId(thayDoiTvd.getId());
		thayDoiThanhVienDoanForm.setIdCuocTtkt(thayDoiTvd.getIdCuocTtkt());
		thayDoiThanhVienDoanForm.setIdNguoiDeNghi(thayDoiTvd.getIdNguoiDeNghi());
		thayDoiThanhVienDoanForm.setTenNguoiDeNghi(thayDoiTvd.getTenNguoiDeNghi());

		thayDoiThanhVienDoanForm.setSoQd(thayDoiTvd.getSoQd());
		thayDoiThanhVienDoanForm.setNoiRaQd(thayDoiTvd.getNoiRaQd());
		thayDoiThanhVienDoanForm.setNgayRaQd(Formater.date2str(thayDoiTvd.getNgayRaQd()));

		thayDoiThanhVienDoanForm.setVbanQdinhCnangNvu(thayDoiTvd.getVbanQdinhCnangNvu());
		thayDoiThanhVienDoanForm.setDvCnCoLquan(thayDoiTvd.getDvCnCoLquan());

		thayDoiThanhVienDoanForm.setCanCuLuatSo(thayDoiTvd.getCanCuLuatSo());
		thayDoiThanhVienDoanForm.setCanCuQdinh("C\u0103n c\u1EE9 Quy\u1EBFt \u0111\u1ECBnh s\u1ED1 1722/Q\u0110-TCT ng\u00E0y 08 th\u00E1ng 10 n\u0103m 2014");
		
		String loaiThayDoi = thayDoiTvd.getLoaiThayDoi();
		thayDoiThanhVienDoanForm.setLoaiThayDoi(loaiThayDoi);
		TtktCmThayDoiThemMoiTvd[] noiDungThayDoi = TtktService.getNoiDungThayDoiThanhVienDoan(appContext, thayDoiTvd.getId());
		if ("truong_doan".equals(loaiThayDoi) || "thanh_vien_doan".equals(loaiThayDoi)) {
			thayDoiThanhVienDoanForm.setNgayBanGiao(Formater.date2str(thayDoiTvd.getNgayBanGiao()));
			thayDoiThanhVienDoanForm.setNgayBdauCuaTvienMoi(Formater.date2str(thayDoiTvd.getNgayBdauCuaTvienMoi()));
			thayDoiThanhVienDoanForm.setNgayThoiThamGia(Formater.date2str(thayDoiTvd.getNgayThoiThamGia()));
			if ("truong_doan".equals(loaiThayDoi)) {
				TtktCmThayDoiThemMoiTvd thayDoiTruongDoan = noiDungThayDoi[0];
				thayDoiThanhVienDoanForm.setIdThanhVienCu(thayDoiTruongDoan.getIdThanhVienCu());
				thayDoiThanhVienDoanForm.setTenThanhVienCu(thayDoiTruongDoan.getTenThanhVienCu());
				thayDoiThanhVienDoanForm.setChucVuThanhVienCu(thayDoiTruongDoan.getChucVuThanhVienCu());

				thayDoiThanhVienDoanForm.setIdThanhVienMoi(thayDoiTruongDoan.getIdThanhVienMoi());
				thayDoiThanhVienDoanForm.setTenThanhVienMoi(thayDoiTruongDoan.getTenThanhVienMoi());
				thayDoiThanhVienDoanForm.setChucVuThanhVienMoi(thayDoiTruongDoan.getChucVuThanhVienMoi());
				thayDoiThanhVienDoanForm.setDonViCongTacTvMoi(thayDoiTruongDoan.getDonViCongTacTvMoi());
			} else {
				thayDoiThanhVienDoanForm.setNoiDungThayDoi(noiDungThayDoi);
			}

		} else {
			thayDoiThanhVienDoanForm.setNoiDungBoSung(noiDungThayDoi);
		}

	}

	/**
	 * @param request
	 * @param appContext
	 * @param thayDoiThanhVienDoanForm
	 */
	private void loadDefaulValue(HttpServletRequest request, ApplicationContext appContext, ThayDoiThanhVienDoanForm thayDoiThanhVienDoanForm) {
		// TODO Auto-generated method stub

	}

	/**
	 * Download file mau TTNB07,TTNB08,TTNB09
	 * 
	 * @throws Exception
	 */
	
	private void inThayDoiThanhVien(HttpServletRequest request, ApplicationContext appConText, ThayDoiThanhVienDoanForm thayDoiThanhVienDoanForm, HttpServletResponse reponse) throws Exception {
		CuocTtktService service = new CuocTtktService();
		String cuocTtktId=thayDoiThanhVienDoanForm.getIdCuocTtkt();
		System.out.println("Id cuoc ttkt : "+cuocTtktId );
		if(!Formater.isNull(cuocTtktId))
		{
			if("4".equals(service.getDonVerionTtkt(appConText, cuocTtktId)))
			{
				inThayDoiThanhVienv4(request, reponse, thayDoiThanhVienDoanForm, appConText);
			}
			else inThayDoiThanhVienv3(request, reponse, thayDoiThanhVienDoanForm, appConText);
		}
		else 
		{
			if("4".equals(Constants.APP_DEP_VERSION))
				inThayDoiThanhVienv4(request, reponse, thayDoiThanhVienDoanForm, appConText);
			else inThayDoiThanhVienv3(request, reponse, thayDoiThanhVienDoanForm, appConText);
		}
	}
	
	/**
	 * Des : ktnb v3
	 * */
	private void inThayDoiThanhVienv3(HttpServletRequest request, HttpServletResponse reponse, ThayDoiThanhVienDoanForm thayDoiThanhVienDoanForm, ApplicationContext appConText) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;

		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = "";
		String type = request.getParameter("type");

		// bo sung thanh vien doan (ngon, chuan)
		if ("boSungTv".equals(type)) {
			fileIn = request.getRealPath("/docin") + "\\TTNB09.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB09_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			fileTemplate = "ttnb09";
			String idCuocTtkt = thayDoiThanhVienDoanForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);
			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appConText);
			String loai_nv = (String) request.getParameter("loai_nv");
			String ten_nv = ("0".equals(loai_nv)) ? "thanh tra" : "ki\u1EC3m tra";
			StringBuffer sb = new StringBuffer(ten_nv);
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText).toUpperCase());
				word.put("[cqt_ra_quyet_dinh]", cuocTtkt.getTenDonViTh().toUpperCase());
				if (Formater.isNull(thayDoiThanhVienDoanForm.getSoQd())) {
					word.put("[so_qd]", "....../Q\u0110-.......");
				} else {
					word.put("[so_qd]", thayDoiThanhVienDoanForm.getSoQd());
				}
				//
				String ngaylap = thayDoiThanhVienDoanForm.getNgayRaQd();
				String[] arrngaylap = ngaylap.split("/");
				if (thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", ".....");
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else if (!thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && !thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", thayDoiThanhVienDoanForm.getNoiRaQd());
					word.put("[ngay_ra_qd]", "ng\u00E0y " + arrngaylap[0] + " th\u00E1ng " + arrngaylap[1] + " n\u0103m " + arrngaylap[2]);
				} else if (thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && !thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", ".....");
					word.put("[ngay_ra_qd]", "ng\u00E0y " + arrngaylap[0] + " th\u00E1ng " + arrngaylap[1] + " n\u0103m " + arrngaylap[2]);
				} else if (!thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", thayDoiThanhVienDoanForm.getNoiRaQd());
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				}
				word.put("[ttkt]", sb.toString());
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText).toUpperCase());
				if (CatalogService.getTenDanhMucById(thayDoiThanhVienDoanForm.getVbanQdinhCnangNvu()).equals("N/A")) {
					word.put("[van_ban_quy_dinh]", KtnbUtil.inFieldNull(108) + ";");
				} else {
					word.put("[van_ban_quy_dinh]", CatalogService.getTenDanhMucById(thayDoiThanhVienDoanForm.getVbanQdinhCnangNvu()));
				}
				word.put("[ttkt]", sb.toString());
				word.put("[so_qdinh]", cbQd.getSoQuyetDinh());
				String ngayraqd1 = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				String[] arrngayraqd1 = ngayraqd1.split("/");
				word.put("[ngay_ra_qd_cu]", "ng\u00E0y " + arrngayraqd1[0] + " th\u00E1ng " + arrngayraqd1[1] + " n\u0103m " + arrngayraqd1[2]);
				//
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[nguoi_de_nghi]", thayDoiThanhVienDoanForm.getChucVuNguoiDeNghi());
				word.put("[ttkt]", sb.toString());
				word.put("[so_qdinh]", cbQd.getSoQuyetDinh());
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				// ngay bat dau ttkt
				String ngayttkt = Formater.date2str(cuocTtkt.getThoiGianDuKienTuNgay());
				String[] arrngayttkt = ngayttkt.split("/");
				word.put("[tu_ngay]", "ng\u00E0y " + arrngayttkt[0] + " th\u00E1ng " + arrngayttkt[1] + " n\u0103m " + arrngayttkt[2]);
				// thanh vien moi
				TtktCmThayDoiThemMoiTvd[] thaydoitvd = thayDoiThanhVienDoanForm.getNoiDungBoSung();
				StringBuffer tptd = new StringBuffer("");
				if (thaydoitvd != null && thaydoitvd.length > 0) {
					for (int i = 0; i < thaydoitvd.length; i++) {
						tptd.append("- \u00D4ng (b\u00E0): " + thaydoitvd[i].getTenThanhVienMoi());
						tptd.append("  Ch\u1EE9c v\u1EE5: " + thaydoitvd[i].getChucVuThanhVienMoi());
						tptd.append(" - \u0110\u01A1n v\u1ECB c\u00F4ng t\u00E1c: " + thaydoitvd[i].getDonViCongTacTvMoi());
						tptd.append("\n");
					}
					System.out.println(tptd.toString());
					word.put("[thanh_vien_moi]", tptd.toString().substring(0, tptd.toString().length() - 1));
				}
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				if (Formater.isNull(thayDoiThanhVienDoanForm.getDvCnCoLquan())) {
					word.put("[don_vi_lien_quan]", "");
				} else {
					word.put("[don_vi_lien_quan]", ", " + thayDoiThanhVienDoanForm.getDvCnCoLquan() + ",");
				}
				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText));
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appConText.getMaCqt()).toUpperCase());
				//word.put("[ten_thu_truong]", appConText.getTenThuTruong());

				// String ngayqd = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				// String[] arrngqd = ngayqd.split("/");
				// word.put("[ngay_qdinh]", "ng\u00E0y " + arrngqd[0] + " th\u00E1ng " + arrngqd[1] + " n\u0103m " + arrngqd[2]);

				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB09", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}finally {				
				try { 
					word.saveAndClose();
				} catch (Exception e) {
					
				}
			}

			// thay doi truong doan (ngon , chuan)
		} else if ("truongDoan".equals(type)) {
			fileIn = request.getRealPath("/docin") + "\\TTNB07.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB07_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			fileTemplate = "ttnb07";
			// Loc sua lai sau
			String idCuocTtkt = thayDoiThanhVienDoanForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);

			TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appConText);
			String loai_nv = (String) request.getParameter("loai_nv");
			String ten_nv = ("0".equals(loai_nv)) ? "thanh tra" : "ki\u1EC3m tra";
			StringBuffer sb = new StringBuffer(ten_nv);
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText).toUpperCase());
				word.put("[cqt_ra_quyet_dinh]", cuocTtkt.getTenDonViTh().toUpperCase());
				if (Formater.isNull(thayDoiThanhVienDoanForm.getSoQd())) {
					word.put("[so_qd]", "....../Q\u0110-.......");
				} else {
					word.put("[so_qd]", " " + thayDoiThanhVienDoanForm.getSoQd());
				}
				// ngay ra qd thay truong doan
				String ngayraqd = thayDoiThanhVienDoanForm.getNgayRaQd();
				String[] arrngayraqd = ngayraqd.split("/");
				// parameters.put("ngay_ra_qd", "ng\u00E0y " + arrngayraqd[0] + " th\u00E1ng " + arrngayraqd[1] + " n\u0103m " + arrngayraqd[2]);

				if (thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", ".....");
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else if (!thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && !thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", thayDoiThanhVienDoanForm.getNoiRaQd());
					word.put("[ngay_ra_qd]", "ng\u00E0y " + arrngayraqd[0] + " th\u00E1ng " + arrngayraqd[1] + " n\u0103m " + arrngayraqd[2]);
				} else if (thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && !thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", ".....");
					word.put("[ngay_ra_qd]", "ng\u00E0y " + arrngayraqd[0] + " th\u00E1ng " + arrngayraqd[1] + " n\u0103m " + arrngayraqd[2]);
				} else if (!thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", thayDoiThanhVienDoanForm.getNoiRaQd());
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				}
				word.put("[ttkt]", sb.toString());
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText).toUpperCase());
				if (CatalogService.getTenDanhMucById(thayDoiThanhVienDoanForm.getVbanQdinhCnangNvu()).equals("N/A")) {
					word.put("[van_ban_quy_dinh]", KtnbUtil.inFieldNull(108) + ";");
				} else {
					word.put("[van_ban_quy_dinh]", CatalogService.getTenDanhMucById(thayDoiThanhVienDoanForm.getVbanQdinhCnangNvu()));
				}
				word.put("[ttkt]", sb.toString());
				word.put("[so_qdinh]", cbQd.getSoQuyetDinh());
				String ngayraqd1 = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				String[] arrngayraqd1 = ngayraqd1.split("/");
				word.put("[ngay_ra_qd_cu]", "ng\u00E0y " + arrngayraqd1[0] + " th\u00E1ng " + arrngayraqd1[1] + " n\u0103m " + arrngayraqd1[2]);
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[nguoi_de_nghi]", thayDoiThanhVienDoanForm.getChucVuNguoiDeNghi());
				// quyet dinh thay doi truong doan
				word.put("[truong_doan_moi]", thayDoiThanhVienDoanForm.getTenThanhVienMoi());
				word.put("[chuc_vu]", thayDoiThanhVienDoanForm.getChucVuThanhVienMoi());
				word.put("[dv_cong_tac]", thayDoiThanhVienDoanForm.getDonViCongTacTvMoi());
				word.put("[ttkt]", sb.toString());
				word.put("[truong_doan_cu]", cuocTtkt.getTenTruongDoan());
				word.put("[ttkt]", sb.toString());
				word.put("[ttkt]", sb.toString());
				word.put("[so_qdinh]", cbQd.getSoQuyetDinh());
				word.put("[ngay_ra_qd_cu]", "ng\u00E0y " + arrngayraqd1[0] + " th\u00E1ng " + arrngayraqd1[1] + " n\u0103m " + arrngayraqd1[2]);
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				// ngay ra qd thay truong doan
				String ngayttkt = thayDoiThanhVienDoanForm.getNgayBdauCuaTvienMoi();
				String[] arrngayttkt = ngayttkt.split("/");
				word.put("[tu_ngay]", "ng\u00E0y " + arrngayttkt[0] + " th\u00E1ng " + arrngayttkt[1] + " n\u0103m " + arrngayttkt[2]);
				word.put("[truong_doan_cu]", cuocTtkt.getTenTruongDoan());
				word.put("[truong_doan_moi]", thayDoiThanhVienDoanForm.getTenThanhVienMoi());
				// ngay ban giao
				String ngaybangiao = thayDoiThanhVienDoanForm.getNgayBanGiao();
				String[] arrbangiao = ngaybangiao.split("/");
				word.put("[ngay_ban_giao]", "ng\u00E0y " + arrbangiao[0] + " th\u00E1ng " + arrbangiao[1] + " n\u0103m " + arrbangiao[2]);
				word.put("[truong_doan_moi]", thayDoiThanhVienDoanForm.getTenThanhVienMoi());
				word.put("[truong_doan_cu]", cuocTtkt.getTenTruongDoan());
				if (Formater.isNull(thayDoiThanhVienDoanForm.getDvCnCoLquan())) {
					word.put("[dv_lien_quan]", "");
				} else {
					word.put("[dv_lien_quan]", ", v\u00E0 " + thayDoiThanhVienDoanForm.getDvCnCoLquan());
				}

				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText));
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appConText.getMaCqt()).toUpperCase());
				//word.put("[ten_thu_truong]", appConText.getTenThuTruong());

				// Ngay qd
				// String ngayqd = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				// String[] arrngqd = ngayqd.split("/");
				// word.put("[ngay_qdinh]", "ng\u00E0y " + arrngqd[0] + " th\u00E1ng " + arrngqd[1] + " n\u0103m " + arrngqd[2]);

				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB07", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}

		} else {
			fileIn = request.getRealPath("/docin") + "\\TTNB08.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB08_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			fileTemplate = "ttnb08";
			// Loc sua lai sau
			String idCuocTtkt = thayDoiThanhVienDoanForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);

			TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appConText);
			String loai_nv = (String) request.getParameter("loai_nv");
			String ten_nv = ("0".equals(loai_nv)) ? "thanh tra" : "ki\u1EC3m tra";
			StringBuffer sb = new StringBuffer(ten_nv);
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText).toUpperCase());
				word.put("[cqt_ra_quyet_dinh]", cuocTtkt.getTenDonViTh().toUpperCase());
				if (Formater.isNull(thayDoiThanhVienDoanForm.getSoQd())) {
					word.put("[so_qd]", "....../Q\u0110-.......");
				} else {
					word.put("[so_qd]", " " + thayDoiThanhVienDoanForm.getSoQd());
				}
				// ngay ra qd
				String raqd = thayDoiThanhVienDoanForm.getNgayRaQd();
				String[] arrraqd = raqd.split("/");
				// -- parameters.put("ngay_ra_qd", "ng\u00E0y " + arrraqd[0] + " th\u00E1ng " + arrraqd[1] + " n\u0103m " + arrraqd[2]);

				if (thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", ".....");
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else if (!thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && !thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", thayDoiThanhVienDoanForm.getNoiRaQd());
					word.put("[ngay_ra_qd]", "ng\u00E0y " + arrraqd[0] + " th\u00E1ng " + arrraqd[1] + " n\u0103m " + arrraqd[2]);
				} else if (thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && !thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", ".....");
					word.put("[ngay_ra_qd]", "ng\u00E0y " + arrraqd[0] + " th\u00E1ng " + arrraqd[1] + " n\u0103m " + arrraqd[2]);
				} else if (!thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", thayDoiThanhVienDoanForm.getNoiRaQd());
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				}
				word.put("[ttkt]", sb.toString());
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText).toUpperCase());
				if (CatalogService.getTenDanhMucById(thayDoiThanhVienDoanForm.getVbanQdinhCnangNvu()).equals("N/A")) {
					word.put("[van_ban_quy_dinh]", KtnbUtil.inFieldNull(108) + ";");
				} else {
					word.put("[van_ban_quy_dinh]", CatalogService.getTenDanhMucById(thayDoiThanhVienDoanForm.getVbanQdinhCnangNvu()));
				}
				word.put("[ttkt]", sb.toString());
				word.put("[so_qdinh]", cbQd.getSoQuyetDinh());
				String ngayraqd1 = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				String[] arrngayraqd1 = ngayraqd1.split("/");
				word.put("[ngay_ra_qd_cu]", "ng\u00E0y " + arrngayraqd1[0] + " th\u00E1ng " + arrngayraqd1[1] + " n\u0103m " + arrngayraqd1[2]);
				//
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[nguoi_de_nghi]", thayDoiThanhVienDoanForm.getChucVuNguoiDeNghi());
				word.put("[ttkt]", sb.toString());
				word.put("[ttkt]", sb.toString());
				word.put("[so_qdinh]", cbQd.getSoQuyetDinh());
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				// ngay bat dau ttkt
				String ngayttkt = Formater.date2str(cuocTtkt.getThoiGianDuKienTuNgay());
				String[] arrngayttkt = ngayttkt.split("/");
				word.put("[tu_ngay]", "ng\u00E0y " + arrngayttkt[0] + " th\u00E1ng " + arrngayttkt[1] + " n\u0103m " + arrngayttkt[2]);
				// thanh vien moi
				TtktCmThayDoiThemMoiTvd[] thaydoitvd = thayDoiThanhVienDoanForm.getNoiDungThayDoi();
				StringBuffer tptd = new StringBuffer("");
				if (thaydoitvd != null && thaydoitvd.length > 0) {
					for (int i = 0; i < thaydoitvd.length; i++) {
						tptd.append("- \u00D4ng (b\u00E0): " + thaydoitvd[i].getTenThanhVienMoi());
						tptd.append("   Ch\u1EE9c v\u1EE5: " + thaydoitvd[i].getChucVuThanhVienMoi());
						tptd.append("  - " + thaydoitvd[i].getDonViCongTacTvMoi());
						tptd.append("\n");
					}
					System.out.println(tptd.toString());
					word.put("[thanh_vien_moi]", tptd.toString().substring(0, tptd.toString().length() - 1));
				}
				word.put("[ttkt]", sb.toString());
				word.put("[ttkt]", sb.toString());
				if (Formater.isNull(thayDoiThanhVienDoanForm.getSoQd())) {
					word.put("[so_qd1]", "......");
				} else {
					word.put("[so_qd1]", " " + thayDoiThanhVienDoanForm.getSoQd());
				}
				if (thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else {
					word.put("[ngay_ra_qd]", "ng\u00E0y " + arrraqd[0] + " th\u00E1ng " + arrraqd[1] + " n\u0103m " + arrraqd[2]);
				}
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", sb.toString());
				// ngay thoi tham gia
				String ngaythoi = thayDoiThanhVienDoanForm.getNgayThoiThamGia();
				String[] arrngaythoi = ngaythoi.split("/");
				word.put("[tu_ngay_thoi]", "ng\u00E0y " + arrngaythoi[0] + " th\u00E1ng " + arrngaythoi[1] + " n\u0103m " + arrngaythoi[2]);

				// thanh vien cu
				TtktCmThayDoiThemMoiTvd[] thaydoitvdcu = thayDoiThanhVienDoanForm.getNoiDungThayDoi();
				StringBuffer tvd = new StringBuffer("");
				if (thaydoitvdcu != null && thaydoitvdcu.length > 0) {
					for (int i = 0; i < thaydoitvdcu.length; i++) {
						tvd.append("- \u00D4ng (b\u00E0): " + thaydoitvdcu[i].getTenThanhVienCu());
						tvd.append("   Ch\u1EE9c v\u1EE5: " + thaydoitvdcu[i].getChucVuThanhVienCu());
						tptd.append("  - " + thaydoitvd[i].getDonViCongTacTvCu());
						tvd.append("\n");
					}
					System.out.println(tptd.toString());
					word.put("[thanh_vien_cu]", tvd.toString().substring(0, tvd.toString().length() - 1));
				}
				word.put("[ttkt]", sb.toString());
				word.put("[ttkt]", sb.toString());
				// ngay ban giao cong viec
				String ngaybangiao = thayDoiThanhVienDoanForm.getNgayBanGiao();
				String[] arrngaybg = ngaybangiao.split("/");
				word.put("[ngay_ban_giao]", "ng\u00E0y " + arrngaybg[0] + " th\u00E1ng " + arrngaybg[1] + " n\u0103m " + arrngaybg[2]);
				word.put("[ttkt]", sb.toString());
				System.out.println("don vi dc ttkt :" + cuocTtkt.getTenDonViBi());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				if (Formater.isNull(thayDoiThanhVienDoanForm.getDvCnCoLquan())) {
					word.put("[co_quan_lien_quan]", "");
				} else {
					word.put("[co_quan_lien_quan]", ", " + thayDoiThanhVienDoanForm.getDvCnCoLquan() + ",");
				}
				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText));
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appConText.getMaCqt()).toUpperCase());
				//word.put("[ten_thu_truong]", appConText.getTenThuTruong());

				// String ngayqd = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				// String[] arrngqd = ngayqd.split("/");
				// word.put("ngay_qdinh", "ng\u00E0y " + arrngqd[0] + " th\u00E1ng " + arrngqd[1] + " n\u0103m " + arrngqd[2]);

				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB08", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}

		}
	}
	
	/**
	 * Edit : ntmanh
	 * Method : inThayDoiThanhVien
	 * Des : ktnb v4
	 * */
	private void inThayDoiThanhVienv4(HttpServletRequest request, HttpServletResponse reponse, ThayDoiThanhVienDoanForm thayDoiThanhVienDoanForm, ApplicationContext appConText) throws Exception {
		System.out.println("This is ktnb v4");
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;

		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = "";
		String type = request.getParameter("type");

		// bo sung thanh vien doan (ngon, chuan)
		if ("boSungTv".equals(type)) {
			fileIn = request.getRealPath("/docin/v4") + "\\KTNB09.doc";
			fileOut = request.getRealPath("/docout") + "\\KTNB09_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			fileTemplate = "ttnb09";
			String idCuocTtkt = thayDoiThanhVienDoanForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);
			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appConText);
			String loai_nv = (String) request.getParameter("loai_nv");
			String ten_nv = ("0".equals(loai_nv)) ? "thanh tra" : "ki\u1EC3m tra";
			StringBuffer sb = new StringBuffer(ten_nv);
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText).toUpperCase());
				word.put("[cqt_ra_quyet_dinh]", cuocTtkt.getTenDonViTh().toUpperCase());
				if (Formater.isNull(thayDoiThanhVienDoanForm.getSoQd())) {
					word.put("[so_qd]", "....../Q\u0110-.......");
				} else {
					word.put("[so_qd]", thayDoiThanhVienDoanForm.getSoQd());
				}
				//
				String ngaylap = thayDoiThanhVienDoanForm.getNgayRaQd();
				String[] arrngaylap = ngaylap.split("/");
				if (thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", ".....");
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else if (!thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && !thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", thayDoiThanhVienDoanForm.getNoiRaQd());
					word.put("[ngay_ra_qd]", "ng\u00E0y " + arrngaylap[0] + " th\u00E1ng " + arrngaylap[1] + " n\u0103m " + arrngaylap[2]);
				} else if (thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && !thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", ".....");
					word.put("[ngay_ra_qd]", "ng\u00E0y " + arrngaylap[0] + " th\u00E1ng " + arrngaylap[1] + " n\u0103m " + arrngaylap[2]);
				} else if (!thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", thayDoiThanhVienDoanForm.getNoiRaQd());
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				}
				//word.put("[ttkt]", sb.toString());
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText).toUpperCase());
				word.put("[luat_so]", thayDoiThanhVienDoanForm.getCanCuLuatSo());
				if (CatalogService.getTenDanhMucById(thayDoiThanhVienDoanForm.getVbanQdinhCnangNvu()).equals("N/A")) {
					word.put("[van_ban_quy_dinh]", KtnbUtil.inFieldNull(108) + ";");
				} else {
					word.put("[van_ban_quy_dinh]", CatalogService.getTenDanhMucById(thayDoiThanhVienDoanForm.getVbanQdinhCnangNvu()));
				}
				word.put("[quyet_dinh_so]", thayDoiThanhVienDoanForm.getCanCuQdinh());
				
				//word.put("[ttkt]", sb.toString());
				word.put("[so_qdinh]", cbQd.getSoQuyetDinh());
				String ngayraqd1 = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				String[] arrngayraqd1 = ngayraqd1.split("/");
				word.put("[ngay_ra_qd_cu]", "ng\u00E0y " + arrngayraqd1[0] + " th\u00E1ng " + arrngayraqd1[1] + " n\u0103m " + arrngayraqd1[2]);
				//
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				//word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[nguoi_de_nghi]", thayDoiThanhVienDoanForm.getChucVuNguoiDeNghi());
				//word.put("[ttkt]", sb.toString());
				word.put("[so_qdinh]", cbQd.getSoQuyetDinh());
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				//word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				// ngay bat dau ttkt
				String ngayttkt = Formater.date2str(cuocTtkt.getThoiGianDuKienTuNgay());
				String[] arrngayttkt = ngayttkt.split("/");
				word.put("[tu_ngay]", "ng\u00E0y " + arrngayttkt[0] + " th\u00E1ng " + arrngayttkt[1] + " n\u0103m " + arrngayttkt[2]);
				// thanh vien moi
				TtktCmThayDoiThemMoiTvd[] thaydoitvd = thayDoiThanhVienDoanForm.getNoiDungBoSung();
				StringBuffer tptd = new StringBuffer("");
				if (thaydoitvd != null && thaydoitvd.length > 0) {
					for (int i = 0; i < thaydoitvd.length; i++) {
						tptd.append("- \u00D4ng (b\u00E0): " + thaydoitvd[i].getTenThanhVienMoi());
						tptd.append("  Ch\u1EE9c v\u1EE5: " + thaydoitvd[i].getChucVuThanhVienMoi());
						tptd.append(" - \u0110\u01A1n v\u1ECB c\u00F4ng t\u00E1c: " + thaydoitvd[i].getDonViCongTacTvMoi());
						tptd.append("\n");
					}
					System.out.println(tptd.toString());
					word.put("[thanh_vien_moi]", tptd.toString().substring(0, tptd.toString().length() - 1));
				}
				//word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				if (Formater.isNull(thayDoiThanhVienDoanForm.getDvCnCoLquan())) {
					word.put("[don_vi_lien_quan]", "");
				} else {
					word.put("[don_vi_lien_quan]", ", " + thayDoiThanhVienDoanForm.getDvCnCoLquan() + ",");
				}
				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText));
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appConText.getMaCqt()).toUpperCase());
				//word.put("[ten_thu_truong]", appConText.getTenThuTruong());

				// String ngayqd = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				// String[] arrngqd = ngayqd.split("/");
				// word.put("[ngay_qdinh]", "ng\u00E0y " + arrngqd[0] + " th\u00E1ng " + arrngqd[1] + " n\u0103m " + arrngqd[2]);

				word.saveAndClose();
				word.downloadFile(fileOut, "Mau KTNB09", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}finally {				
				try { 
					word.saveAndClose();
				} catch (Exception e) {
					
				}
			}

			// thay doi truong doan (ngon , chuan)
		} else if ("truongDoan".equals(type)) {
			fileIn = request.getRealPath("/docin/v4") + "\\KTNB07.doc";
			fileOut = request.getRealPath("/docout") + "\\KTNB07_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			fileTemplate = "ktnb07";
			// Loc sua lai sau
			String idCuocTtkt = thayDoiThanhVienDoanForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);

			TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appConText);
			String loai_nv = (String) request.getParameter("loai_nv");
			String ten_nv = ("0".equals(loai_nv)) ? "thanh tra" : "ki\u1EC3m tra";
			StringBuffer sb = new StringBuffer(ten_nv);
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText).toUpperCase());
				word.put("[cqt_ra_quyet_dinh]", cuocTtkt.getTenDonViTh().toUpperCase());
				if (Formater.isNull(thayDoiThanhVienDoanForm.getSoQd())) {
					word.put("[so_qd]", "....../Q\u0110-.......");
				} else {
					word.put("[so_qd]", " " + thayDoiThanhVienDoanForm.getSoQd());
				}
				// ngay ra qd thay truong doan
				String ngayraqd = thayDoiThanhVienDoanForm.getNgayRaQd();
				String[] arrngayraqd = ngayraqd.split("/");
				// parameters.put("ngay_ra_qd", "ng\u00E0y " + arrngayraqd[0] + " th\u00E1ng " + arrngayraqd[1] + " n\u0103m " + arrngayraqd[2]);

				if (thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", ".....");
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else if (!thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && !thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", thayDoiThanhVienDoanForm.getNoiRaQd());
					word.put("[ngay_ra_qd]", "ng\u00E0y " + arrngayraqd[0] + " th\u00E1ng " + arrngayraqd[1] + " n\u0103m " + arrngayraqd[2]);
				} else if (thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && !thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", ".....");
					word.put("[ngay_ra_qd]", "ng\u00E0y " + arrngayraqd[0] + " th\u00E1ng " + arrngayraqd[1] + " n\u0103m " + arrngayraqd[2]);
				} else if (!thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", thayDoiThanhVienDoanForm.getNoiRaQd());
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				}
				//word.put("[ttkt]", sb.toString());
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText).toUpperCase());
				word.put("[luat_so]", thayDoiThanhVienDoanForm.getCanCuLuatSo());
				if (CatalogService.getTenDanhMucById(thayDoiThanhVienDoanForm.getVbanQdinhCnangNvu()).equals("N/A")) {
					word.put("[van_ban_quy_dinh]", KtnbUtil.inFieldNull(108) + ";");
				} else {
					word.put("[van_ban_quy_dinh]", CatalogService.getTenDanhMucById(thayDoiThanhVienDoanForm.getVbanQdinhCnangNvu()));
				}
				word.put("[qd_so]", thayDoiThanhVienDoanForm.getCanCuQdinh());
				//word.put("[ttkt]", sb.toString());
				word.put("[so_qdinh]", cbQd.getSoQuyetDinh());
				String ngayraqd1 = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				String[] arrngayraqd1 = ngayraqd1.split("/");
				word.put("[ngay_ra_qd_cu]", "ng\u00E0y " + arrngayraqd1[0] + " th\u00E1ng " + arrngayraqd1[1] + " n\u0103m " + arrngayraqd1[2]);
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				//word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[nguoi_de_nghi]", thayDoiThanhVienDoanForm.getChucVuNguoiDeNghi());
				// quyet dinh thay doi truong doan
				word.put("[truong_doan_moi]", thayDoiThanhVienDoanForm.getTenThanhVienMoi());
				word.put("[chuc_vu]", thayDoiThanhVienDoanForm.getChucVuThanhVienMoi());
				word.put("[dv_cong_tac]", thayDoiThanhVienDoanForm.getDonViCongTacTvMoi());
				//word.put("[ttkt]", sb.toString());
				word.put("[truong_doan_cu]", cuocTtkt.getTenTruongDoan());
				//word.put("[ttkt]", sb.toString());
				//word.put("[ttkt]", sb.toString());
				word.put("[so_qdinh]", cbQd.getSoQuyetDinh());
				word.put("[ngay_ra_qd_cu]", "ng\u00E0y " + arrngayraqd1[0] + " th\u00E1ng " + arrngayraqd1[1] + " n\u0103m " + arrngayraqd1[2]);
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				//word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				// ngay ra qd thay truong doan
				String ngayttkt = thayDoiThanhVienDoanForm.getNgayBdauCuaTvienMoi();
				String[] arrngayttkt = ngayttkt.split("/");
				word.put("[tu_ngay]", "ng\u00E0y " + arrngayttkt[0] + " th\u00E1ng " + arrngayttkt[1] + " n\u0103m " + arrngayttkt[2]);
				word.put("[truong_doan_cu]", cuocTtkt.getTenTruongDoan());
				word.put("[truong_doan_moi]", thayDoiThanhVienDoanForm.getTenThanhVienMoi());
				// ngay ban giao
				String ngaybangiao = thayDoiThanhVienDoanForm.getNgayBanGiao();
				String[] arrbangiao = ngaybangiao.split("/");
				word.put("[ngay_ban_giao]", "ng\u00E0y " + arrbangiao[0] + " th\u00E1ng " + arrbangiao[1] + " n\u0103m " + arrbangiao[2]);
				word.put("[truong_doan_moi]", thayDoiThanhVienDoanForm.getTenThanhVienMoi());
				word.put("[truong_doan_cu]", cuocTtkt.getTenTruongDoan());
				if (Formater.isNull(thayDoiThanhVienDoanForm.getDvCnCoLquan())) {
					word.put("[dv_lien_quan]", "");
				} else {
					word.put("[dv_lien_quan]", ", v\u00E0 " + thayDoiThanhVienDoanForm.getDvCnCoLquan());
				}

				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText));
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appConText.getMaCqt()).toUpperCase());
				//word.put("[ten_thu_truong]", appConText.getTenThuTruong());

				// Ngay qd
				// String ngayqd = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				// String[] arrngqd = ngayqd.split("/");
				// word.put("[ngay_qdinh]", "ng\u00E0y " + arrngqd[0] + " th\u00E1ng " + arrngqd[1] + " n\u0103m " + arrngqd[2]);

				word.saveAndClose();
				word.downloadFile(fileOut, "Mau KTNB07", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}

		} else {
			fileIn = request.getRealPath("/docin/v4") + "\\KTNB08.doc";
			fileOut = request.getRealPath("/docout") + "\\KTNB08_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			fileTemplate = "ttnb08";
			// Loc sua lai sau
			String idCuocTtkt = thayDoiThanhVienDoanForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);

			TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appConText);
			String loai_nv = (String) request.getParameter("loai_nv");
			String ten_nv = ("0".equals(loai_nv)) ? "thanh tra" : "ki\u1EC3m tra";
			StringBuffer sb = new StringBuffer(ten_nv);
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText).toUpperCase());
				word.put("[cqt_ra_quyet_dinh]", cuocTtkt.getTenDonViTh().toUpperCase());
				if (Formater.isNull(thayDoiThanhVienDoanForm.getSoQd())) {
					word.put("[so_qd]", "....../Q\u0110-.......");
				} else {
					word.put("[so_qd]", " " + thayDoiThanhVienDoanForm.getSoQd());
				}
				// ngay ra qd
				String raqd = thayDoiThanhVienDoanForm.getNgayRaQd();
				String[] arrraqd = raqd.split("/");
				// -- parameters.put("ngay_ra_qd", "ng\u00E0y " + arrraqd[0] + " th\u00E1ng " + arrraqd[1] + " n\u0103m " + arrraqd[2]);

				if (thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", ".....");
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else if (!thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && !thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", thayDoiThanhVienDoanForm.getNoiRaQd());
					word.put("[ngay_ra_qd]", "ng\u00E0y " + arrraqd[0] + " th\u00E1ng " + arrraqd[1] + " n\u0103m " + arrraqd[2]);
				} else if (thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && !thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", ".....");
					word.put("[ngay_ra_qd]", "ng\u00E0y " + arrraqd[0] + " th\u00E1ng " + arrraqd[1] + " n\u0103m " + arrraqd[2]);
				} else if (!thayDoiThanhVienDoanForm.getNoiRaQd().equals("") && thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[noi_ra_qd]", thayDoiThanhVienDoanForm.getNoiRaQd());
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				}
				//word.put("[ttkt]", sb.toString());
				
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText).toUpperCase());
				word.put("[luat_so]", thayDoiThanhVienDoanForm.getCanCuLuatSo());
				if (CatalogService.getTenDanhMucById(thayDoiThanhVienDoanForm.getVbanQdinhCnangNvu()).equals("N/A")) {
					word.put("[van_ban_quy_dinh]", KtnbUtil.inFieldNull(108) + ";");
				} else {
					word.put("[van_ban_quy_dinh]", CatalogService.getTenDanhMucById(thayDoiThanhVienDoanForm.getVbanQdinhCnangNvu()));
				}
				//word.put("[ttkt]", sb.toString());
				word.put("[quyet_dinh_so]", thayDoiThanhVienDoanForm.getCanCuQdinh());
				
				word.put("[so_qdinh]", cbQd.getSoQuyetDinh());
				String ngayraqd1 = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				String[] arrngayraqd1 = ngayraqd1.split("/");
				word.put("[ngay_ra_qd_cu]", "ng\u00E0y " + arrngayraqd1[0] + " th\u00E1ng " + arrngayraqd1[1] + " n\u0103m " + arrngayraqd1[2]);
				//
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				//word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[nguoi_de_nghi]", thayDoiThanhVienDoanForm.getChucVuNguoiDeNghi());
				//word.put("[ttkt]", sb.toString());
				//word.put("[ttkt]", sb.toString());
				word.put("[so_qdinh]", cbQd.getSoQuyetDinh());
				word.put("[ngay_ra_qd1]", "Chua co");
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				//word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				// ngay bat dau ttkt
				String ngayttkt = Formater.date2str(cuocTtkt.getThoiGianDuKienTuNgay());
				String[] arrngayttkt = ngayttkt.split("/");
				word.put("[tu_ngay]", "ng\u00E0y " + arrngayttkt[0] + " th\u00E1ng " + arrngayttkt[1] + " n\u0103m " + arrngayttkt[2]);
				// thanh vien moi
				TtktCmThayDoiThemMoiTvd[] thaydoitvd = thayDoiThanhVienDoanForm.getNoiDungThayDoi();
				StringBuffer tptd = new StringBuffer("");
				if (thaydoitvd != null && thaydoitvd.length > 0) {
					for (int i = 0; i < thaydoitvd.length; i++) {
						tptd.append("- \u00D4ng (b\u00E0): " + thaydoitvd[i].getTenThanhVienMoi());
						tptd.append("   Ch\u1EE9c v\u1EE5: " + thaydoitvd[i].getChucVuThanhVienMoi());
						tptd.append("  - " + thaydoitvd[i].getDonViCongTacTvMoi());
						tptd.append("\n");
					}
					System.out.println(tptd.toString());
					word.put("[thanh_vien_moi]", tptd.toString().substring(0, tptd.toString().length() - 1));
				}
				//word.put("[ttkt]", sb.toString());
				//word.put("[ttkt]", sb.toString());
				if (Formater.isNull(thayDoiThanhVienDoanForm.getSoQd())) {
					word.put("[so_qd1]", "......");
				} else {
					word.put("[so_qd1]", " " + thayDoiThanhVienDoanForm.getSoQd());
				}
				if (thayDoiThanhVienDoanForm.getNgayRaQd().equals("")) {
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else {
					word.put("[ngay_ra_qd]", "ng\u00E0y " + arrraqd[0] + " th\u00E1ng " + arrraqd[1] + " n\u0103m " + arrraqd[2]);
				}
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				//word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//word.put("[ttkt]", sb.toString());
				// ngay thoi tham gia
				String ngaythoi = thayDoiThanhVienDoanForm.getNgayThoiThamGia();
				String[] arrngaythoi = ngaythoi.split("/");
				word.put("[tu_ngay_thoi]", "ng\u00E0y " + arrngaythoi[0] + " th\u00E1ng " + arrngaythoi[1] + " n\u0103m " + arrngaythoi[2]);

				// thanh vien cu
				TtktCmThayDoiThemMoiTvd[] thaydoitvdcu = thayDoiThanhVienDoanForm.getNoiDungThayDoi();
				StringBuffer tvd = new StringBuffer("");
				if (thaydoitvdcu != null && thaydoitvdcu.length > 0) {
					for (int i = 0; i < thaydoitvdcu.length; i++) {
						tvd.append("- \u00D4ng (b\u00E0): " + thaydoitvdcu[i].getTenThanhVienCu());
						tvd.append("   Ch\u1EE9c v\u1EE5: " + thaydoitvdcu[i].getChucVuThanhVienCu());
						tptd.append("  - " + thaydoitvd[i].getDonViCongTacTvCu());
						tvd.append("\n");
					}
					System.out.println(tptd.toString());
					word.put("[thanh_vien_cu]", tvd.toString().substring(0, tvd.toString().length() - 1));
				}
				//word.put("[ttkt]", sb.toString());
				//word.put("[ttkt]", sb.toString());
				// ngay ban giao cong viec
				String ngaybangiao = thayDoiThanhVienDoanForm.getNgayBanGiao();
				String[] arrngaybg = ngaybangiao.split("/");
				word.put("[ngay_ban_giao]", "ng\u00E0y " + arrngaybg[0] + " th\u00E1ng " + arrngaybg[1] + " n\u0103m " + arrngaybg[2]);
				//word.put("[ttkt]", sb.toString());
				System.out.println("don vi dc ttkt :" + cuocTtkt.getTenDonViBi());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				if (Formater.isNull(thayDoiThanhVienDoanForm.getDvCnCoLquan())) {
					word.put("[co_quan_lien_quan]", "");
				} else {
					word.put("[co_quan_lien_quan]", ", " + thayDoiThanhVienDoanForm.getDvCnCoLquan() + ",");
				}
				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(appConText));
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appConText.getMaCqt()).toUpperCase());
				//word.put("[ten_thu_truong]", appConText.getTenThuTruong());

				// String ngayqd = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				// String[] arrngqd = ngayqd.split("/");
				// word.put("ngay_qdinh", "ng\u00E0y " + arrngqd[0] + " th\u00E1ng " + arrngqd[1] + " n\u0103m " + arrngqd[2]);

				word.saveAndClose();
				word.downloadFile(fileOut, "Mau 08/KTNB", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}

		}
	}

	/**
	 * @param appContext
	 * @param request
	 * @param thayDoiThanhVienDoanForm
	 * @return
	 */
	private TtktCmThayDoiTvd createThayDoiTvd(ApplicationContext appContext, HttpServletRequest request, ThayDoiThanhVienDoanForm thayDoiThanhVienDoanForm) throws Exception {
		TtktCmThayDoiTvd thayDoiTvd = new TtktCmThayDoiTvd();

		// Thong tin chung
		thayDoiTvd.setId(thayDoiThanhVienDoanForm.getId());
		thayDoiTvd.setIdCuocTtkt(thayDoiThanhVienDoanForm.getIdCuocTtkt());
		thayDoiTvd.setIdNguoiCapNat(appContext.getMaCanbo());
		thayDoiTvd.setTenNguoiCapNhat(appContext.getTenCanbo());
		thayDoiTvd.setNgayCapNhat(new Date());
		thayDoiTvd.setIdNguoiCapNat(appContext.getMaCanbo());
		thayDoiTvd.setTenNguoiCapNhat(appContext.getTenCanbo());
		thayDoiTvd.setNgayCapNhat(new Date());
		
		thayDoiTvd.setCanCuLuatSo(thayDoiThanhVienDoanForm.getCanCuLuatSo());
		thayDoiTvd.setCanCuQdinh(thayDoiThanhVienDoanForm.getCanCuQdinh());
		
		// Quyet dinh
		thayDoiTvd.setSoQd(thayDoiThanhVienDoanForm.getSoQd());
		thayDoiTvd.setNoiRaQd(thayDoiThanhVienDoanForm.getNoiRaQd());
		thayDoiTvd.setNgayRaQd(Formater.str2date(thayDoiThanhVienDoanForm.getNgayRaQd()));

		// Nguoi de nghi
		thayDoiTvd.setIdNguoiDeNghi(thayDoiThanhVienDoanForm.getIdNguoiDeNghi());
		thayDoiTvd.setTenNguoiDeNghi(thayDoiThanhVienDoanForm.getTenNguoiDeNghi());
		thayDoiTvd.setChucVuNguoiDeNghi(thayDoiThanhVienDoanForm.getChucVuNguoiDeNghi());

		// Van ban quy dinh chuc nang nhiem vu
		thayDoiTvd.setVbanQdinhCnangNvu(thayDoiThanhVienDoanForm.getVbanQdinhCnangNvu());

		// Don vi ca nhan co lien quan
		thayDoiTvd.setDvCnCoLquan(thayDoiThanhVienDoanForm.getDvCnCoLquan());
		String loaiThayDoi = thayDoiThanhVienDoanForm.getLoaiThayDoi();
		thayDoiTvd.setLoaiThayDoi(loaiThayDoi);

		if ("truong_doan".equals(loaiThayDoi) || "thanh_vien_doan".equals(loaiThayDoi)) {
			thayDoiTvd.setNgayThoiThamGia(Formater.str2date(thayDoiThanhVienDoanForm.getNgayThoiThamGia()));
			thayDoiTvd.setNgayBdauCuaTvienMoi(Formater.str2date(thayDoiThanhVienDoanForm.getNgayBdauCuaTvienMoi()));
			thayDoiTvd.setNgayBanGiao(Formater.str2date(thayDoiThanhVienDoanForm.getNgayBanGiao()));
			if ("truong_doan".equals(loaiThayDoi)) {
				TtktCmThayDoiThemMoiTvd cmThayDoiThemMoiTvd = new TtktCmThayDoiThemMoiTvd();
				cmThayDoiThemMoiTvd.setIdThanhVienMoi(thayDoiThanhVienDoanForm.getIdThanhVienMoi());
				cmThayDoiThemMoiTvd.setTenThanhVienMoi(thayDoiThanhVienDoanForm.getTenThanhVienMoi());
				cmThayDoiThemMoiTvd.setChucVuThanhVienMoi(thayDoiThanhVienDoanForm.getChucVuThanhVienMoi());
				cmThayDoiThemMoiTvd.setDonViCongTacTvMoi(thayDoiThanhVienDoanForm.getDonViCongTacTvMoi());

				cmThayDoiThemMoiTvd.setIdThanhVienCu(appContext.getMaCanbo());
				cmThayDoiThemMoiTvd.setTenThanhVienCu(appContext.getTenCanbo());
				cmThayDoiThemMoiTvd.setChucVuThanhVienCu(appContext.getTenChucvu());
				cmThayDoiThemMoiTvd.setDonViCongTacTvCu(appContext.getTenCqt());
				thayDoiTvd.setChiTietThayDoi(new TtktCmThayDoiThemMoiTvd[] { cmThayDoiThemMoiTvd });
			} else {
				thayDoiTvd.setChiTietThayDoi(thayDoiThanhVienDoanForm.getNoiDungThayDoi());
			}

		} else {
			thayDoiTvd.setChiTietThayDoi(thayDoiThanhVienDoanForm.getNoiDungBoSung());
		}
		return thayDoiTvd;
	}

}
