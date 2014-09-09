package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.action;

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
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThYeuCauGiaiTrinh;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.YeuCauGiaiTrinhForm;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */
public class YeuCauGiaiTrinhAction extends BaseDispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {

		YeuCauGiaiTrinhForm giaiTrinhForm = (YeuCauGiaiTrinhForm) form;
		
		String method = request.getParameter("method");
		ApplicationContext app = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String cuocTtktId = request.getParameter("idCuocTtkt");
		if ("save".equals(method)) {
			saveYeuCauGiaiTrinh(giaiTrinhForm, app);
			request.setAttribute("saveStatus", "true");
		} else if ("in".equals(method)) {
			inYeuCauGT(request, reponse, giaiTrinhForm, app, cuocTtktId);
			return null;
		} else {
			if (!Formater.isNull(cuocTtktId)) { // Truong hop mo tu form main hoac them moi
				if ("addnew".equals(method)) {
					giaiTrinhForm.setDiadiemBCGT(KtnbUtil.getTenTinhByMaCqt(app, CuocTtktService.getCuocTtkt(app, cuocTtktId).getIdDonViBi()));
					addNew(request, giaiTrinhForm, cuocTtktId);
					
				} else {
					Collection dsYeuCauGiaTrinh = TtktCnPhuService.getDsYCGiaiTrinh(app, cuocTtktId);
					if (Formater.isNull(dsYeuCauGiaTrinh)) { // Truong doan them moi
						giaiTrinhForm.setDiadiemBCGT(KtnbUtil.getTenTinhByMaCqt(app, CuocTtktService.getCuocTtkt(app, cuocTtktId).getIdDonViBi()));
						addNew(request, giaiTrinhForm, cuocTtktId);

					} else {
						if (dsYeuCauGiaTrinh.size() == 1 && !app.isTruongDoan(cuocTtktId)) {
							loadDataToForm(request, app, giaiTrinhForm, (TtktThYeuCauGiaiTrinh) ((ArrayList) dsYeuCauGiaTrinh).get(0));
						} else {
							request.getSession().setAttribute("dsYCGiaiTrinh", dsYeuCauGiaTrinh);
							reponse.sendRedirect("danh_sach_tim_kiem.do?idCuocTtkt=" + cuocTtktId + "&type=yeuCauGiaiTrinh");
						}
					}
				}
			} else {
				String id = request.getParameter("id");
				loadDataToForm(request, app, giaiTrinhForm, id);
				if (!app.isTruongDoan(giaiTrinhForm.getIdCuocTtKt()) || app.getTrangThaiCuocTtkt(giaiTrinhForm.getIdCuocTtKt()).equals(Constants.TT_TTKT_KT))
					request.setAttribute("readOnly", "true");
			}
			try{
				if(!Formater.isNull(cuocTtktId)){
					request.setAttribute("ngayRaQuyetDnh",Formater.objectDate2Str(TtktService.getQuyetDinh(cuocTtktId, app).getNgayRaQuyetDnh()));
				}else{
					String id = request.getParameter("id");
					TtktThYeuCauGiaiTrinh yeuCauGiaiTrinh = TtktCnPhuService.getYeuCauGT(app, id);
					request.setAttribute("ngayRaQuyetDnh",Formater.objectDate2Str(TtktService.getQuyetDinh(yeuCauGiaiTrinh.getIdCuocTtkt(), app).getNgayRaQuyetDnh()));
				}
				}catch (Exception e) {
					// TODO: handle exception
				}
		}
		return mapping.findForward("success");
	}

	/**
	 * @param request
	 * @param app
	 * @param giaiTrinhForm
	 * @param id
	 */
	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, YeuCauGiaiTrinhForm giaiTrinhForm, String id) throws Exception {
		TtktThYeuCauGiaiTrinh yeuCauGiaiTrinh = TtktCnPhuService.getYeuCauGT(app, id);
		loadDataToForm(request, app, giaiTrinhForm, yeuCauGiaiTrinh);

	}

	/**
	 * @param request
	 * @param app
	 * @param giaiTrinhForm
	 * @param yeuCauGT
	 */
	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, YeuCauGiaiTrinhForm giaiTrinhForm, TtktThYeuCauGiaiTrinh yeuCauGT) {
		giaiTrinhForm.setId(yeuCauGT.getId());  
		giaiTrinhForm.setIdCuocTtKt(yeuCauGT.getIdCuocTtkt());
		giaiTrinhForm.setNgaylapPhieu(Formater.date2str(yeuCauGT.getNgayLapPhieu()));
		giaiTrinhForm.setNoiLapPhieu(yeuCauGT.getNoiLapPhieu());
		giaiTrinhForm.setIdNGuoiGT(yeuCauGT.getIdNguoiGiaiTrinh());
		giaiTrinhForm.setTenNguoiGT(yeuCauGT.getTenNguoiGiaiTrinh());
		giaiTrinhForm.setDvNguoiGT(yeuCauGT.getDvCongTacNguoiGiaiTrinh());
		giaiTrinhForm.setNdungGT(yeuCauGT.getNoiDungGiaiTrinh());
		giaiTrinhForm.setNgayGuiGT(Formater.date2strDateTimeForNV(yeuCauGT.getThoiGianGuiGiaiTrinh()));
		giaiTrinhForm.setNoiGuiGT(yeuCauGT.getNoiGuiGiaiTrinh());
		giaiTrinhForm.setDiadiemBCGT(yeuCauGT.getDiaDiemBaoCaoGiaiTrinh());
		giaiTrinhForm.setTgBCGT(Formater.date2strDateTimeForNV(yeuCauGT.getThoiGianBaoCaoGiaiTrinh()));
		giaiTrinhForm.setNoidungBCGT(yeuCauGT.getNoiDungBaoCaoGiaiTrinh());
		giaiTrinhForm.setHoSoTaiLieuBC(yeuCauGT.getHoSoBaoCao());
		giaiTrinhForm.setCvNguoiLapPhieu(yeuCauGT.getChucVuNgGT());
	}

	/**
	 * @param request
	 * @param giaiTrinhForm
	 * @param cuocTtktId
	 */
	private void addNew(HttpServletRequest request, YeuCauGiaiTrinhForm giaiTrinhForm, String cuocTtktId) {
		giaiTrinhForm.setIdCuocTtKt(cuocTtktId);

	}

	private void loadDefaulForm(YeuCauGiaiTrinhForm form, ApplicationContext app, HttpServletRequest request, String cuocTtktId, String id) throws Exception {
		Collection dsThanhVienDoan = TtktService.getDanhSachThanhVienDoan(cuocTtktId);
		String dsIdThanhVienDoan = "";
		String dsChucVuTrongDoan = "";
		Iterator iter = dsThanhVienDoan.iterator();
		while (iter.hasNext()) {
			TtktCbChiTietDsTvDoan thanhVienDoan = (TtktCbChiTietDsTvDoan) iter.next();

			dsIdThanhVienDoan += thanhVienDoan.getIdCanBo() + ",";
			dsChucVuTrongDoan += thanhVienDoan.getChucVuTrongDoan() + ",";
		}

		request.setAttribute("dsIdThanhVienDoan", dsIdThanhVienDoan.substring(0, dsIdThanhVienDoan.length() - 1));
		request.setAttribute("dsChucVuTrongDoan", dsChucVuTrongDoan.substring(0, dsChucVuTrongDoan.length() - 1));

		TtktThYeuCauGiaiTrinh yeuCauGT = TtktCnPhuService.getYeuCauGT(app, id);
		if (yeuCauGT != null) {
			form.setId(yeuCauGT.getId());
			form.setIdCuocTtKt(yeuCauGT.getIdCuocTtkt());
			form.setNgaylapPhieu(Formater.date2str(yeuCauGT.getNgayLapPhieu()));
			form.setNoiLapPhieu(yeuCauGT.getNoiLapPhieu());
			form.setIdNGuoiGT(yeuCauGT.getIdNguoiGiaiTrinh());
			form.setTenNguoiGT(yeuCauGT.getTenNguoiGiaiTrinh());
			form.setNsNguoiGT(Formater.date2str(yeuCauGT.getNamSinhNguoiGiaiTrinh()));
			form.setDvNguoiGT(yeuCauGT.getDvCongTacNguoiGiaiTrinh());
			form.setNdungGT(yeuCauGT.getNoiDungGiaiTrinh());
			form.setNgayGuiGT(Formater.date2strDateTimeForNV(yeuCauGT.getThoiGianBaoCaoGiaiTrinh()));
			form.setNoiGuiGT(yeuCauGT.getNoiGuiGiaiTrinh());
			form.setDiadiemBCGT(yeuCauGT.getDiaDiemBaoCaoGiaiTrinh());
			form.setTgBCGT(Formater.date2strDateTimeForNV(yeuCauGT.getThoiGianBaoCaoGiaiTrinh()));
			form.setNoidungBCGT(yeuCauGT.getNoiDungBaoCaoGiaiTrinh());
			form.setHoSoTaiLieuBC(yeuCauGT.getHoSoBaoCao());
			form.setCvNguoiLapPhieu(yeuCauGT.getChucVuNgGT());

		} else {
			form.setTgBCGT(Formater.date2strDateTimeForNV(new Date()));
			form.setNgaylapPhieu(Formater.date2str(new Date()));
			form.setNgayGuiGT(Formater.date2strDateTimeForNV(new Date()));
			form.setNsNguoiGT(Formater.date2str(new Date()));

		}
	}
	private void saveYeuCauGiaiTrinh(YeuCauGiaiTrinhForm form, ApplicationContext app) throws Exception {

		TtktThYeuCauGiaiTrinh ycGT = new TtktThYeuCauGiaiTrinh();
		

		ycGT.setId(form.getId());
		ycGT.setIdCuocTtkt(form.getIdCuocTtKt());
		ycGT.setNgayLapPhieu(Formater.str2SQLdate(form.getNgaylapPhieu()));
		ycGT.setNoiLapPhieu(form.getNoiLapPhieu());
		ycGT.setIdNguoiGiaiTrinh(form.getIdNGuoiGT());
		ycGT.setTenNguoiGiaiTrinh(form.getTenNguoiGT());
		ycGT.setDvCongTacNguoiGiaiTrinh(form.getDvNguoiGT());
		ycGT.setNoiDungGiaiTrinh(form.getNdungGT());
		ycGT.setThoiGianGuiGiaiTrinh(Formater.str2dateForNV(form.getNgayGuiGT()));
		ycGT.setNoiGuiGiaiTrinh(form.getNoiGuiGT());
		//ycGT.setThoiGianBaoCaoGiaiTrinh(Formater.str2SQLdate(form.getTgBCGT()));
		ycGT.setDiaDiemBaoCaoGiaiTrinh(form.getDiadiemBCGT());
		ycGT.setNoiDungBaoCaoGiaiTrinh(form.getNoidungBCGT());
		ycGT.setIdNguoiCapNat(app.getMaCanbo());
		ycGT.setTenNguoiCapNhat(app.getTenCanbo());
		ycGT.setNgayCapNhat(new Date());

		TtktCnPhuService.saveYeuCauGiaiTrinh(ycGT, app, form, form.getNgayGuiGT());
	}
	
	private void inYeuCauGT_old(HttpServletRequest request, HttpServletResponse reponse, YeuCauGiaiTrinhForm form, ApplicationContext app, String idCuocTtKt) throws Exception {
		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, idCuocTtKt);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtKt, app);
		StringBuffer sb = new StringBuffer(hinhThuc);
		parameters.put("ttkt", sb.toString());
		sb = new StringBuffer("\u0110o\u00E0n ");
		sb.append(hinhThuc);
		sb.append(" s\u1ED1 ");
		sb.append(cbQd.getSoQuyetDinh());
		if ("inPhieuYeuCau".equals(type)) {
			//in quyet dinh niem phong
			fileTemplate = "ttnb28";
			parameters.put("ten_cqt", app.getTenCqt());
			parameters.put("doan_ttkt_so", sb.toString());
			parameters.put("ten_bc", sb.toString());
			parameters.put("ttkt", hinhThuc);
			parameters.put("thu_truong_cqt", KtnbUtil.getTenThuTruongCqt(app));
			parameters.put("ten_cqt", KtnbUtil.getTenCqtCapTrenTt(app));
			parameters.put("doan_ttkt_so", sb.toString());
			parameters.put("ngay_qd", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			parameters.put("ho_so_tai_lieu", form.getHoSoTaiLieuBC());
			parameters.put("ten_truong_doan", cuocTtkt.getTenTruongDoan());
			parameters.put("noi_dung", form.getNdungGT());
			parameters.put("so_qd", cbQd.getSoQuyetDinh());
			parameters.put("thoi_gian_gui_giai_trinh", KtnbUtil.getHour(form.getNgayGuiGT()));
			parameters.put("noi_gui_giai_trinh", form.getNoiGuiGT());
			parameters.put("dv_dc_ttkt", cuocTtkt.getTenDonViBi());
			//--parameters.put("noi_lap",form.getNoiLapPhieu());
			//--parameters.put("ngay_lap",Formater.getDateForPrint(form.getNgaylapPhieu()));
			String ongba;
			if (form.getTenNguoiGT().equals("")) {
				ongba = form.getCvNguoiLapPhieu() + " " + form.getDvNguoiGT();
			} else
				ongba = form.getTenNguoiGT() + "-" + form.getCvNguoiLapPhieu() + " " + form.getDvNguoiGT();
			parameters.put("ong_ba", ongba);
			parameters.put("ten_nguoi_giai_trinh", ongba);

			if (form.getNoiLapPhieu().equals("") || form.getNgaylapPhieu().equals("")) {
				parameters.put("noi_lap", ".....");
				parameters.put("ngay_lap", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			} else {
				parameters.put("noi_lap", form.getNoiLapPhieu());
				parameters.put("ngay_lap", Formater.getDateForPrint(form.getNgaylapPhieu()));
			}
		} else if ("inBaoCaoGT".equals(type)) {
			//in quyet dinh niem phong
			fileTemplate = "ttnb29";
			parameters.put("ten_cqt", KtnbUtil.getTenCqtCapTrenTt(app));
			parameters.put("doan_ttkt_so", sb.toString());
			parameters.put("ttkt", hinhThuc);
			parameters.put("so_qd", cbQd.getSoQuyetDinh());
			parameters.put("noi_dung", form.getNoidungBCGT());
			parameters.put("ngay_qd", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			parameters.put("nguoi_giai_trinh", form.getTenNguoiGT());
			parameters.put("ngay_sinh", form.getNsNguoiGT());
			parameters.put("chuc_vu", form.getCvNguoiLapPhieu());
			parameters.put("dv_cong_tac", form.getDvNguoiGT());
			parameters.put("ngay_lap_phieu_yeu_cau_giai_trinh", Formater.getDateForPrint(form.getNgaylapPhieu()));
			parameters.put("noi_lap", form.getNoiLapPhieu());
			parameters.put("ngay_giai_trinh", KtnbUtil.getDay(form.getTgBCGT()));

		}

		if (Formater.isNull(fileTemplate))
			throw new Exception("Chua chon file template");

		InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
		KtnbUtil.printf(reportRows, fileTemplate, reponse, inputStream, parameters, null);
	}
	
	/**
	 * Download file mau TTNB28,TTNB29
	 * 
	 * @throws Exception
	 */
	private void inYeuCauGT(HttpServletRequest request, HttpServletResponse reponse, YeuCauGiaiTrinhForm form, ApplicationContext app, String idCuocTtKt) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;
		
		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, idCuocTtKt);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		String hinhThucT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtKt, app);
		StringBuffer sb = new StringBuffer(hinhThuc);
		//parameters.put("ttkt", sb.toString());
		sb = new StringBuffer("\u0110o\u00E0n ");
		sb.append(hinhThucT);
		sb.append(" s\u1ED1 ");
		sb.append(cbQd.getSoQuyetDinh());
		if ("inPhieuYeuCau".equals(type)) {
			//in quyet dinh niem phong
			fileIn = request.getRealPath("/docin") + "\\TTNB28.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB28_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			fileTemplate = "ttnb28";
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", app.getTenCqt().toUpperCase());
				word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
				//word.put("[ten_bc]", sb.toString());
				if (form.getNoiLapPhieu().equals("") || form.getNgaylapPhieu().equals("")) {
					word.put("[noi_lap]", ".....");
					word.put("[ngay_lap]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else {
					word.put("[noi_lap]", form.getNoiLapPhieu());
					word.put("[ngay_lap]", Formater.getDateForPrint(form.getNgaylapPhieu()));
				}
				String ongba;
				if (form.getTenNguoiGT().equals("")) {
					ongba = form.getCvNguoiLapPhieu() + " " + form.getDvNguoiGT();
				} else
					ongba = form.getTenNguoiGT() + "-" + form.getCvNguoiLapPhieu() + " " + form.getDvNguoiGT();
				word.put("[ong_ba]", ongba);
				word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqt(app));
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(app));
				//word.put("[doan_ttkt_so]", sb.toString());
				word.put("[ttkt]", hinhThuc);
				word.put("[ho_so_tai_lieu]", form.getHoSoTaiLieuBC());
				word.put("[ttkt]", hinhThuc);
				word.put("[ten_nguoi_giai_trinh]", ongba);
				word.put("[noi_dung]", form.getNdungGT());
				word.put("[ttkt]", hinhThuc);
				word.put("[thoi_gian_gui_giai_trinh]", KtnbUtil.getHour(form.getNgayGuiGT()));
				word.put("[noi_gui_giai_trinh]", form.getNoiGuiGT());
				word.put("[ttkt]", hinhThuc.toUpperCase());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				//--parameters.put("noi_lap",form.getNoiLapPhieu());
				//--parameters.put("ngay_lap",Formater.getDateForPrint(form.getNgaylapPhieu()));
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB28", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}finally {				
				try { 
					word.saveAndClose();
				} catch (Exception e) {
					
				}
			}
			
			
		} else if ("inBaoCaoGT".equals(type)) {
			//in quyet dinh niem phong
			fileIn = request.getRealPath("/docin") + "\\TTNB29.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB29_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			fileTemplate = "ttnb29";
			try {
				word = new MsWordUtils(fileIn, fileOut);
				//word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(app).toUpperCase());
				//word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
				word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[nguoi_giai_trinh]", form.getTenNguoiGT());
				word.put("[ngay_sinh]", form.getNsNguoiGT());
				word.put("[chuc_vu]", form.getCvNguoiLapPhieu());
				word.put("[dv_cong_tac]", form.getDvNguoiGT());
				word.put("[ttkt]", hinhThuc);
				word.put("[ngay_lap_phieu_yeu_cau_giai_trinh]", Formater.getDateForPrint(form.getNgaylapPhieu()));
				word.put("[noi_dung]", form.getNoidungBCGT());
				word.put("[noi_lap]", form.getNoiLapPhieu());
				word.put("[ngay_giai_trinh]", KtnbUtil.getDay(form.getTgBCGT()));
				word.put("[nguoi_giai_trinh]", form.getTenNguoiGT());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB29", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}
			

		}
	}

}
