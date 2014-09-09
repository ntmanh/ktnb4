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
import org.apache.struts.util.LabelValueBean;

import com.jacob.com.Dispatch;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmBienBan;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhNoiDungTtkt;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThNoiDungPhucTra;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThPhucTra;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThYeuCauGiaiTrinh;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.vo.CategoryVO;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.catalog.CatalogService;
import cmc.com.ktnb.web.ttkt.dung_chung.form.BienBanLamViecForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.PhucTraForm;

public class PhucTraAction extends BaseDispatchAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		ApplicationContext app = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		PhucTraForm phucTraForm = (PhucTraForm) form;
		String method = request.getParameter("method");
		if ("save".equals(method)) {
			savePhucTra(request, reponse, phucTraForm, app);
			request.setAttribute("saveStatus", "true");			
			request.setAttribute("dsTvd", TtktService.getDsTvdById(app, phucTraForm.getIdDsTvd()));
			//danh sach don vi bi
			ArrayList dsNoiDung = new ArrayList();
			Collection dsCqtTrucThuoc = CuocTtktService.getCuocTtkt(app, phucTraForm.getIdCuocTtKt()).getDsTtktCqtTrucThuoc();
			for (Iterator iter = dsCqtTrucThuoc.iterator(); iter.hasNext();) {
				TtktKhCuocTtkt cqtTrucThuoc = (TtktKhCuocTtkt) iter.next();
				Collection dsCqtNoiDung = cqtTrucThuoc.getDsNoiDungTTKT();
				for (Iterator iterator = dsCqtNoiDung.iterator(); iterator
						.hasNext();) {
					TtktKhNoiDungTtkt noiDung = (TtktKhNoiDungTtkt) iterator.next();
					//default value false
					boolean pivort=false;
					for(int i=0;i<dsNoiDung.size();i++){
						TtktKhNoiDungTtkt item = (TtktKhNoiDungTtkt)dsNoiDung.get(i);
						if(item.getIdNoiDung().toString().equals(noiDung.getIdNoiDung())){
							pivort = true;
							break;
						}
					}
					if(!pivort){
						dsNoiDung.add(noiDung);
					}
				}
				
			}
			request.setAttribute("dsNoiDung", dsNoiDung);
		} else if ("in".equals(method)) {
			// TODO: Kiem tra xem cho nay co phai load lai lan nua khong
			inPhucTra(request, reponse, phucTraForm, app, phucTraForm.getIdCuocTtKt());
			return null;
		} else {
			String cuocTtktId = request.getParameter("idCuocTtkt");
			if (!Formater.isNull(cuocTtktId)) { // Nguoi dung click chon vao
				// link tai form main hoac mo
				// man hinh tao moi tu form tim
				// kiem
				if ("addnew".equals(method)) { // Tao moi tu man hinh tim kiem
					addNew(request, app, phucTraForm, cuocTtktId);

				} else { // Click vao link tai form main
					Collection dsPhucTra = TtktCnPhuService.getDsPhucTra(app, cuocTtktId);
					if (Formater.isNull(dsPhucTra)) { // Truong doan
						// them moi
						addNew(request, app, phucTraForm, cuocTtktId);
					} else {
						if (!app.isTruongDoan(cuocTtktId) && dsPhucTra.size() == 1) {
							// Thu truong co quan va co 1 ban ghi
							loadDataToForm(request, app, phucTraForm, (TtktThPhucTra) ((ArrayList) dsPhucTra).get(0));
							request.setAttribute("readOnly", "true");
							return mapping.findForward("success");

						}
						request.getSession().setAttribute("dsPhucTra", dsPhucTra);
						reponse.sendRedirect("danh_sach_tim_kiem.do?idCuocTtkt=" + cuocTtktId + "&type=phucTra");
					}
				}

			} else {
				// Truong hop xem hoac sua thi truyen id vao url
				String id = request.getParameter("id");
				loadDataToForm(request, app, phucTraForm, id);
				if (!KtnbUtil.haveRoleNv(app) || "view".equals(method) || app.getTrangThaiCuocTtkt(phucTraForm.getIdCuocTtKt()).equals(Constants.TT_TTKT_KT)) {
					request.setAttribute("readOnly", "true");
				}

			}
			try{
				if(!Formater.isNull(cuocTtktId)){
					request.setAttribute("ngayRaQuyetDnh",Formater.objectDate2Str(TtktService.getQuyetDinh(cuocTtktId, app).getNgayRaQuyetDnh()));
				}else{
					String id = request.getParameter("id");
					TtktThPhucTra phucTra = TtktCnPhuService.getPhucTra(app, id);
					request.setAttribute("ngayRaQuyetDnh",Formater.objectDate2Str(TtktService.getQuyetDinh(phucTra.getIdCuocTtkt(), app).getNgayRaQuyetDnh()));
				}
				}catch (Exception e) {
					// TODO: handle exception
				}
		}

		return mapping.findForward("success");
	}

	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, PhucTraForm phucTraForm, String id) throws Exception {
		TtktThPhucTra phucTra = TtktCnPhuService.getPhucTra(app, id);
		loadDataToForm(request, app, phucTraForm, phucTra);
		TtktCbDsTvDoan dsTvd = TtktService.getDsTvdById(phucTra.getIdDsTvd(), app);
		phucTraForm.setIdDsTvd(dsTvd.getId());
		request.setAttribute("dsTvd", dsTvd.getChiTietDanhSachTV());
		//danh sach don vi bi
		ArrayList dsNoiDung = new ArrayList();
		Collection dsCqtTrucThuoc = CuocTtktService.getCuocTtkt(app, phucTraForm.getIdCuocTtKt()).getDsTtktCqtTrucThuoc();
		for (Iterator iter = dsCqtTrucThuoc.iterator(); iter.hasNext();) {
			TtktKhCuocTtkt cqtTrucThuoc = (TtktKhCuocTtkt) iter.next();
			Collection dsCqtNoiDung = cqtTrucThuoc.getDsNoiDungTTKT();
			for (Iterator iterator = dsCqtNoiDung.iterator(); iterator
					.hasNext();) {
				TtktKhNoiDungTtkt noiDung = (TtktKhNoiDungTtkt) iterator.next();
				//default value false
				boolean pivort=false;
				for(int i=0;i<dsNoiDung.size();i++){
					TtktKhNoiDungTtkt item = (TtktKhNoiDungTtkt)dsNoiDung.get(i);
					if(item.getIdNoiDung().toString().equals(noiDung.getIdNoiDung())){
						pivort = true;
						break;
					}
				}
				if(!pivort){
					dsNoiDung.add(noiDung);
				}
			}
			
		}
		request.setAttribute("dsNoiDung", dsNoiDung);
	}

	private void loadDataToForm(HttpServletRequest request, ApplicationContext app, PhucTraForm phucTraForm, TtktThPhucTra phucTra) throws Exception {
		phucTraForm.setSoQuyetDinh(phucTra.getSoQd());
		phucTraForm.setNgayRaQuyetDinh(Formater.date2str(phucTra.getNgayRaQd()));
		phucTraForm.setId(phucTra.getId());
		phucTraForm.setIdDsTvd(phucTra.getIdDsTvd());
		phucTraForm.setIdCuocTtKt(phucTra.getIdCuocTtkt());
		phucTraForm.setNoiTrinh(phucTra.getNoiTrinh());
		phucTraForm.setNgayTrinh(Formater.date2str(phucTra.getNgayTrinh()));
		phucTraForm.setNoiPheDuyet(phucTra.getNoiPheDuyet());
		phucTraForm.setNgayPheDuyet(Formater.date2str(phucTra.getNgayPheDuyet()));
		phucTraForm.setKienPheDuyet(phucTra.getKienPheDuyet());
		phucTraForm.setSoQdTtKtCanPhucTra(phucTra.getSoQdTtktCanPhucTra());
		phucTraForm.setNoiRaQuyetDinh(phucTra.getNoiRaQd());
		phucTraForm.setNgayRaQuyetDinh(Formater.date2str(phucTra.getNgayRaQd()));
		phucTraForm.setVanBanQuyetDinh(phucTra.getVbQuyDinhCnangNvu());
		phucTraForm.setIdCoQuanThueCanPhucTra(phucTra.getIdCqtCanPhucTra());
		phucTraForm.setTenCoQuanTueCanPhucTra(phucTra.getTenCqtCanPhucTra());
		phucTraForm.setDiaDiemPhucTra(phucTra.getDiaDiemPhucTra());
		phucTraForm.setNoiDungNghiVan(phucTra.getNoiDungNghiVan());
		phucTraForm.setSoQuyetDinh(phucTra.getSoQd());
		phucTraForm.setNgayLap(Formater.date2str(phucTra.getNgayLap()));
		phucTraForm.setTenNguoiRaQd(phucTra.getThuTruongCqtThTtKt());
		phucTraForm.setChucDanhNguoiRaQd(phucTra.getChucDanhNguoiRaQd());
		phucTraForm.setNienDoTuNgay(Formater.date2str(phucTra.getNienDoTuNgay()));
		phucTraForm.setNienDoDenNgay(Formater.date2str(phucTra.getNienDoDenNgay()));
		phucTraForm.setThoiGian(phucTra.getThoiGian().toString());
		phucTraForm.setIdDVThucHien(phucTra.getDsCanBoThucHien());
		phucTraForm.setCvNguoiDeNghiPT(phucTra.getCvNguoiDeNghiPT());
		phucTraForm.setTenNguoiDeNghiPT(phucTra.getTenNguoiDeNghiPT());
		phucTraForm.setIdNguoiDeNghiPT(phucTra.getIdNguoiDeNghiPT());
		phucTraForm.setCqNguoiDeNghiPT(phucTra.getCqNguoiDeNghiPT());
		Collection dsNoiDungPhucTra = (Collection) phucTra.getDsNdPhucTra();
		if (!Formater.isNull(dsNoiDungPhucTra)) {
			phucTraForm.setLoaiND("NoiBo");
			TtktThNoiDungPhucTra[] arrNoiDungPhucTra = new TtktThNoiDungPhucTra[dsNoiDungPhucTra.size()];

			Iterator iterator = dsNoiDungPhucTra.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				arrNoiDungPhucTra[i] = (TtktThNoiDungPhucTra) iterator.next();
				i++;
			}
			phucTraForm.setNoiDungPhucTra(arrNoiDungPhucTra);

		} else {
			phucTraForm.setLoaiND("Ngoai");
			phucTraForm.setNoiDungPhucTraNgoaiNganhThue(phucTra.getNoiDungPhucTraNgoaiNganhThue());

		}

		Collection tpTD = (Collection) phucTra.getDsCbThucHien();
		if (tpTD != null) {
			TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[tpTD.size()];
			Iterator iter = tpTD.iterator();
			int i = 0;
			while (iter.hasNext()) {
				TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
				dsTpTdLoad[i] = tptd;
				i++;
			}
			phucTraForm.setDsCanBoThucHien(dsTpTdLoad);
		}
		request.setAttribute("dsNoiDung", TtktCnPhuService.loadNoiDungPhucTra());

	}

	private void addNew(HttpServletRequest request, ApplicationContext app, PhucTraForm phucTraForm, String cuocTtktId) throws Exception {
		phucTraForm.setIdCuocTtKt(cuocTtktId);
		// Gia tri mac dinh
		phucTraForm.setLoaiND("Ngoai");
		TtktCbDsTvDoan dsTvDoan = TtktService.getDsTvd(cuocTtktId, app);
		// Danh sach thanh vien doan
		phucTraForm.setIdDsTvd(dsTvDoan.getId());
		Collection dsTvd = dsTvDoan.getChiTietDanhSachTV();
		request.setAttribute("dsTvd", dsTvd);
		// Danh muc Ttkt goc
		//danh sach don vi bi
		ArrayList dsNoiDung = new ArrayList();
		Collection dsCqtTrucThuoc = CuocTtktService.getCuocTtkt(app, cuocTtktId).getDsTtktCqtTrucThuoc();
		for (Iterator iter = dsCqtTrucThuoc.iterator(); iter.hasNext();) {
			TtktKhCuocTtkt cqtTrucThuoc = (TtktKhCuocTtkt) iter.next();
			Collection dsCqtNoiDung = cqtTrucThuoc.getDsNoiDungTTKT();
			for (Iterator iterator = dsCqtNoiDung.iterator(); iterator
					.hasNext();) {
				TtktKhNoiDungTtkt noiDung = (TtktKhNoiDungTtkt) iterator.next();
				//default value false
				boolean pivort=false;
				for(int i=0;i<dsNoiDung.size();i++){
					TtktKhNoiDungTtkt item = (TtktKhNoiDungTtkt)dsNoiDung.get(i);
					if(item.getIdNoiDung().toString().equals(noiDung.getIdNoiDung())){
						pivort = true;
						break;
					}
				}
				if(!pivort){
					dsNoiDung.add(noiDung);
				}
			}
			
		}
		request.setAttribute("dsNoiDung", dsNoiDung);

	}

	public ActionForward execute1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {

		PhucTraForm phucTraForm = (PhucTraForm) form;
		String method = request.getParameter("method");
		ApplicationContext app = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String cuocTtktId = request.getParameter("idCuocTtkt");
		String id = request.getParameter("id");

		if (cuocTtktId == null) {
			cuocTtktId = phucTraForm.getIdCuocTtKt();
		}
		request.setAttribute("maCqtTh", app.getMaCqt());
		loadNoiDungPhucTra(app, request, cuocTtktId);
		if ("save".equals(method)) {
			savePhucTra(request, reponse, phucTraForm, app);

			request.setAttribute("save", "ok");
		} else if ("in".equals(method)) {
			inPhucTra(request, reponse, phucTraForm, app, cuocTtktId);
			return null;
		} else {
			loadDefaulForm(phucTraForm, app, request, cuocTtktId, id);
			if (!KtnbUtil.haveRoleNv(app) || app.getTrangThaiCuocTtkt(phucTraForm.getIdCuocTtKt()).equals(Constants.TT_TTKT_KT))
				request.setAttribute("readOnly", "true");
		}
		// Danh sach cac ngay nghi
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktTrongQdWithoutNoiDung(app, phucTraForm.getIdCuocTtKt());
		String[] temp = cuocTtkt.getMa().split("/");
		String namTienHanh = temp[temp.length - 2];
		KtnbUtil.cacheListHolidayDayForClient(request, namTienHanh, String.valueOf(Integer.parseInt(namTienHanh) + 1));
		// Van ban quy dinh chuc nang nhiem vu
		KtnbUtil.setVanBan(cuocTtkt.getIdDonViTh(), request);
		return mapping.findForward("success");
	}

	public void loadNoiDungPhucTra(ApplicationContext app, HttpServletRequest request, String cuocTtktId) throws Exception {
		TtktCbDsTvDoan dsTvd = TtktService.getDsTvd(cuocTtktId, app);
		request.setAttribute("dsTvd", dsTvd.getChiTietDanhSachTV());

		Collection danhMucND = TtktCnPhuService.loadNoiDungPhucTra();
		TtktThNoiDungPhucTra[] dsNoiDung = new TtktThNoiDungPhucTra[danhMucND.size()];
		String cbDsNoiDung = "<option value = \"\">";
		cbDsNoiDung += "</option>";
		String dsIdNoiDung = "";
		// String dsTenNoiDung = "";
		Iterator iter = danhMucND.iterator();
		TtktThNoiDungPhucTra noidung1;
		int i = 0;
		while (iter.hasNext()) {
			noidung1 = new TtktThNoiDungPhucTra();
			CategoryVO noidung = (CategoryVO) iter.next();

			noidung1.setIdNoiDung(noidung.getId());
			noidung1.setTenNoiDung(noidung.getName());
			dsNoiDung[i] = noidung1;

			cbDsNoiDung += "<option value =\"" + noidung.getName() + "\">";
			cbDsNoiDung += noidung.getName();
			cbDsNoiDung += "</option>";
			dsIdNoiDung += noidung.getId() + ",";
			// dsTenNoiDung += noidung.getName() + ",";
			i++;

		}
		// noi dung phuc tra
		request.setAttribute("dsIdNoiDung", dsIdNoiDung.substring(0, dsIdNoiDung.length() - 1));
		request.setAttribute("dsNoiDung", dsNoiDung);
		request.setAttribute("cbDsNoiDung", cbDsNoiDung);
		// thanh phan tham gia phuc tra

		Collection dsThanhVienDoan = TtktService.getDanhSachThanhVienDoan(cuocTtktId);
		String cbDsThanhVienDoan = "<option value = \"\">";// Combo danh sach
		// thanh vien doan
		cbDsThanhVienDoan += "</option>";
		String dsIdThanhVienDoan = "";
		String dsChucVuTrongDoan = "";
		Iterator iter1 = dsThanhVienDoan.iterator();
		while (iter1.hasNext()) {
			TtktCbChiTietDsTvDoan thanhVienDoan = (TtktCbChiTietDsTvDoan) iter1.next();
			cbDsThanhVienDoan += "<option value = " + thanhVienDoan.getIdCanBo() + ">";
			cbDsThanhVienDoan += thanhVienDoan.getTenCanBo();
			cbDsThanhVienDoan += "</option>";
			dsIdThanhVienDoan += thanhVienDoan.getIdCanBo() + ",";
			dsChucVuTrongDoan += thanhVienDoan.getChucVuTrongDoan() + ",";
		}
		request.setAttribute("cbChiTietDsTvd", cbDsThanhVienDoan);
		request.setAttribute("dsIdThanhVienDoan", dsIdThanhVienDoan.substring(0, dsIdThanhVienDoan.length()));
		request.setAttribute("dsChucVuTrongDoan", dsChucVuTrongDoan.substring(0, dsChucVuTrongDoan.length()));
		request.setAttribute("chiTietDsTvd", dsThanhVienDoan);

	}

	public String getDsTen(TtktThNoiDungPhucTra[] dsTpTd) {
		String arr = "";
		for (int i = 0; i < dsTpTd.length; i++) {
			String ten = dsTpTd[i].getTenNoiDung();
			arr += ten + ",";
		}
		return arr;
	}

	private void loadDefaulForm(PhucTraForm form, ApplicationContext app, HttpServletRequest request, String cuocTtktId, String id) throws Exception {
		TtktThPhucTra phucTra = TtktCnPhuService.getPhucTra(app, id);
		if (phucTra != null) {
			form.setId(phucTra.getId());
			form.setIdCuocTtKt(phucTra.getIdCuocTtkt());
			form.setNoiTrinh(phucTra.getNoiTrinh());
			form.setNgayTrinh(Formater.date2str(phucTra.getNgayTrinh()));
			form.setNoiPheDuyet(phucTra.getNoiPheDuyet());
			form.setNgayPheDuyet(Formater.date2str(phucTra.getNgayPheDuyet()));
			form.setKienPheDuyet(phucTra.getKienPheDuyet());
			form.setSoQdTtKtCanPhucTra(phucTra.getSoQdTtktCanPhucTra());
			form.setNoiRaQuyetDinh(phucTra.getNoiRaQd());
			form.setNgayRaQuyetDinh(Formater.date2str(phucTra.getNgayRaQd()));
			form.setVanBanQuyetDinh(phucTra.getVbQuyDinhCnangNvu());
			form.setIdCoQuanThueCanPhucTra(phucTra.getIdCqtCanPhucTra());
			form.setTenCoQuanTueCanPhucTra(phucTra.getTenCqtCanPhucTra());
			form.setDiaDiemPhucTra(phucTra.getDiaDiemPhucTra());
			form.setNoiDungNghiVan(phucTra.getNoiDungNghiVan());
			form.setSoQuyetDinh(phucTra.getSoQd());
			form.setNgayLap(Formater.date2str(phucTra.getNgayLap()));
			form.setTenNguoiRaQd(phucTra.getThuTruongCqtThTtKt());
			form.setChucDanhNguoiRaQd(phucTra.getChucDanhNguoiRaQd());
			form.setNienDoTuNgay(Formater.date2str(phucTra.getNienDoTuNgay()));
			form.setNienDoDenNgay(Formater.date2str(phucTra.getNienDoDenNgay()));
			form.setThoiGian(phucTra.getThoiGian().toString());
			form.setIdDVThucHien(phucTra.getDsCanBoThucHien());
			form.setCvNguoiDeNghiPT(phucTra.getCvNguoiDeNghiPT());
			form.setTenNguoiDeNghiPT(phucTra.getTenNguoiDeNghiPT());
			form.setIdNguoiDeNghiPT(phucTra.getIdNguoiDeNghiPT());
			form.setCqNguoiDeNghiPT(phucTra.getCqNguoiDeNghiPT());
			Collection dsNoiDung1 = (Collection) phucTra.getDsNdPhucTra();
			if (dsNoiDung1 != null) {
				TtktThNoiDungPhucTra[] dsTpTdLoad = new TtktThNoiDungPhucTra[dsNoiDung1.size()];

				Iterator iter1 = dsNoiDung1.iterator();
				int i = 0;
				while (iter1.hasNext()) {
					TtktThNoiDungPhucTra tptd = (TtktThNoiDungPhucTra) iter1.next();
					dsTpTdLoad[i] = tptd;
					if (dsTpTdLoad[i].getLoaiND().equals("Ngoai")) {
						form.setNoiDungPhucTraNgoaiNganhThue(dsTpTdLoad[i].getTenNoiDung());
						form.setLoaiND(dsTpTdLoad[i].getLoaiND());
						break;
					}
					form.setLoaiND(dsTpTdLoad[i].getLoaiND());
					i++;
				}
				form.setNoiDungPhucTra(dsTpTdLoad);

			}

			request.setAttribute("dsTenNoiDung", getDsTen(form.getNoiDungPhucTra()));

			Collection tpTD = (Collection) phucTra.getDsCbThucHien();
			if (tpTD != null) {
				TtktCmThanhPhanThamDu[] dsTpTdLoad = new TtktCmThanhPhanThamDu[tpTD.size()];
				Iterator iter = tpTD.iterator();
				int i = 0;
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu tptd = (TtktCmThanhPhanThamDu) iter.next();
					dsTpTdLoad[i] = tptd;
					i++;
				}
				form.setDsCanBoThucHien(dsTpTdLoad);
			}
		} else {
			form.setNgayTrinh(Formater.date2str(new Date()));
			form.setNgayPheDuyet(Formater.date2str(new Date()));
			form.setNgayRaQuyetDinh(Formater.date2str(new Date()));
			form.setNgayLap(Formater.date2str(new Date()));
			form.setIdCuocTtKt(cuocTtktId);
		}
	}

	private void savePhucTra(HttpServletRequest request, HttpServletResponse response, PhucTraForm phucTraForm, ApplicationContext app) throws Exception {
		TtktThPhucTra phucTra = new TtktThPhucTra();

		phucTra.setId(phucTraForm.getId());
		phucTra.setIdDsTvd(phucTraForm.getIdDsTvd());
		// private TtktThNoiDungPhucTra ttktThNoiDungPhucTra;
		phucTra.setSoQd(phucTraForm.getSoQuyetDinh());
		phucTra.setNgayRaQd(Formater.str2date(phucTraForm.getNgayRaQuyetDinh()));
		phucTra.setIdCuocTtkt(phucTraForm.getIdCuocTtKt());
		phucTra.setNoiTrinh(phucTraForm.getNoiTrinh());
		phucTra.setNgayTrinh(Formater.str2date(phucTraForm.getNgayTrinh()));
		phucTra.setNoiPheDuyet(phucTraForm.getNoiPheDuyet());
		phucTra.setNgayPheDuyet(Formater.str2date(phucTraForm.getNgayTrinh()));
		phucTra.setKienPheDuyet(phucTraForm.getKienPheDuyet());
		phucTra.setSoQd(phucTraForm.getSoQuyetDinh());
		phucTra.setNoiRaQd(phucTraForm.getNoiRaQuyetDinh());
		phucTra.setNgayRaQd(Formater.str2date(phucTraForm.getNgayRaQuyetDinh()));
		phucTra.setVbQuyDinhCnangNvu(phucTraForm.getVanBanQuyetDinh());
		phucTra.setIdCqtCanPhucTra(phucTraForm.getIdCoQuanThueCanPhucTra());
		phucTra.setTenCqtCanPhucTra(phucTraForm.getTenCoQuanTueCanPhucTra());
		phucTra.setDiaDiemPhucTra(phucTraForm.getDiaDiemPhucTra());
		phucTra.setNoiDungNghiVan(phucTraForm.getNoiDungNghiVan());
		phucTra.setSoQdTtktCanPhucTra(phucTraForm.getSoQdTtKtCanPhucTra());
		phucTra.setNgayLap(Formater.str2date(phucTraForm.getNgayLap()));
		phucTra.setChucDanhNguoiRaQd(phucTraForm.getChucDanhNguoiRaQd());
		phucTra.setNienDoTuNgay(Formater.str2date(phucTraForm.getNienDoTuNgay()));
		phucTra.setNienDoDenNgay(Formater.str2date(phucTraForm.getNienDoDenNgay()));
		phucTra.setThoiGian(Byte.valueOf(phucTraForm.getThoiGian()));
		phucTra.setThuTruongCqtThTtKt(phucTraForm.getTenNguoiRaQd());
		phucTra.setCqNguoiDeNghiPT(phucTraForm.getCqNguoiDeNghiPT());
		phucTra.setIdNguoiDeNghiPT(phucTraForm.getIdNguoiDeNghiPT());
		phucTra.setCvNguoiDeNghiPT(phucTraForm.getCvNguoiDeNghiPT());
		phucTra.setTenNguoiDeNghiPT(phucTraForm.getTenNguoiDeNghiPT());
		phucTra.setIdNguoiCapNat(app.getMaCanbo());
		phucTra.setTenNguoiCapNhat(app.getTenCanbo());
		phucTra.setNgayCapNhat(new Date());

		String idDVThucHien = phucTraForm.getIdDVThucHien();
		Collection dsCanBoThucHien = new ArrayList();
		if (phucTraForm.getDsCanBoThucHien() != null) {
			for (int i = 0; i < phucTraForm.getDsCanBoThucHien().length; i++) {
				TtktCmThanhPhanThamDu cacOb = new TtktCmThanhPhanThamDu();
				cacOb.setChucVu(phucTraForm.getDsCanBoThucHien()[i].getChucVu());
				cacOb.setHoTen(phucTraForm.getDsCanBoThucHien()[i].getHoTen());
				cacOb.setIdMaster(idDVThucHien);
				cacOb.setIdCanBo(phucTraForm.getDsCanBoThucHien()[i].getIdCanBo());
				cacOb.setIdNguoiCapNat(app.getMaCanbo());
				cacOb.setTenNguoiCapNhat(app.getTenCanbo());
				cacOb.setNgayCapNhat(new Date());
				dsCanBoThucHien.add(cacOb);
			}
			phucTra.setDsCanBoThucHien(idDVThucHien);
			phucTra.setDsCbThucHien(dsCanBoThucHien);
		}

		if (phucTraForm.getLoaiND().equals("NoiBo")) {
			Collection dsNoiDungPhucTra = new ArrayList();
			for (int i = 0; i < phucTraForm.getNoiDungPhucTra().length; i++) {
				TtktThNoiDungPhucTra noiDungPhucTra = new TtktThNoiDungPhucTra();
				noiDungPhucTra.setIdNoiDung(phucTraForm.getNoiDungPhucTra()[i].getIdNoiDung());
				noiDungPhucTra.setTenNoiDung(phucTraForm.getNoiDungPhucTra()[i].getTenNoiDung());
				noiDungPhucTra.setLoaiND(phucTraForm.getLoaiND());
				noiDungPhucTra.setIdPhucTra(phucTraForm.getId());
				dsNoiDungPhucTra.add(noiDungPhucTra);
			}
			phucTra.setIdPhucTra(phucTraForm.getId());
			phucTra.setDsNdPhucTra(dsNoiDungPhucTra);
			request.setAttribute("dsNoiDung", dsNoiDungPhucTra);
		} else {
			phucTra.setNoiDungPhucTraNgoaiNganhThue(phucTraForm.getNoiDungPhucTraNgoaiNganhThue());
		}
		TtktCnPhuService.savePhucTra(phucTra, app);
	}

	private void inPhucTra_old(HttpServletRequest request, HttpServletResponse reponse, PhucTraForm form, ApplicationContext app, String idCuocTtKt) throws Exception {
		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, idCuocTtKt);
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtKt, app);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
		String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
		StringBuffer sb = new StringBuffer(hinhThuc);
		parameters.put("ttkt", sb.toString());
		sb = new StringBuffer("\u0110O\u00C0N ");
		sb.append(hinhthuc_inT);
		sb.append(" Q\u0110 S\u1ED0 ");
		sb.append(cbQd.getSoQuyetDinh());
		if ("inQD".equals(type)) {
			fileTemplate = "ttnb27";
			parameters.put("ten_cqt", KtnbUtil.getTenCqtCapTrenTt(app));
			parameters.put("doan_ttkt_so", sb.toString());
			parameters.put("thu_truong_cqt", KtnbUtil.getTenThuTruongCqt(app));
			parameters.put("dv_dc_phuc_tra", cuocTtkt.getTenDonViBi());
			parameters.put("thu_truong_ban_hanhqd", KtnbUtil.getTenThuTruongCqt(app));
			parameters.put("cqt_ra_quyet_dinh", cuocTtkt.getTenDonViTh());
			parameters.put("ttkt", hinhThuc);
			parameters.put("so_ngay_lam_viec", form.getThoiGian());
			parameters.put("van_ban_qd", CatalogService.getTenDanhMucById(cbQd.getVanBanQuyDinhCnangNvuQd()));
			String niendo = form.getNienDoTuNgay() + "-" + form.getNienDoDenNgay();
			parameters.put("nien_do", niendo);
			parameters.put("chuc_danh_thu_truong", KtnbUtil.getChucVuThuTruongByMaCqt(app.getMaCqt()));
			parameters.put("ngay_qd", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			parameters.put("so_qd", cbQd.getSoQuyetDinh());
			// --parameters.put("ngay_lap",Formater.getDateForPrint(form.getNgayLap()));
			parameters.put("dv_dc_ttkt", cuocTtkt.getTenDonViBi());
			// --parameters.put("noi_lap1", cbQd.getDiaDiemRaQuyetDinh());
			parameters.put("thu_truong", app.getTenThuTruong());
			String str = form.getTenNguoiDeNghiPT() + ", " + form.getCvNguoiDeNghiPT() + ", " + form.getCqNguoiDeNghiPT();
			parameters.put("chuc_danh_nguoi_de_nghi_phuc_tra", str);

			if (cbQd.getDiaDiemRaQuyetDinh().equals("") || form.getNgayLap().equals("")) {
				parameters.put("noi_lap1", ".....");
				parameters.put("ngay_lap", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			} else {
				parameters.put("noi_lap1", cbQd.getDiaDiemRaQuyetDinh());
				parameters.put("ngay_lap", Formater.getDateForPrint(form.getNgayLap()));
			}
			// noi dung phuc tra
			TtktThNoiDungPhucTra[] arrthanhphanbg = form.getNoiDungPhucTra();
			StringBuffer tptd = new StringBuffer("");
			if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
				for (int i = 0; i < arrthanhphanbg.length; i++) {
					tptd.append("- " + arrthanhphanbg[i].getTenNoiDung());
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				parameters.put("noi_dung", tptd.toString());
			}
			// ---------------- danh sach nguoi thuc hien ----------------
			TtktCmThanhPhanThamDu[] arr = form.getDsCanBoThucHien();
			StringBuffer bf = new StringBuffer("");
			if (arr != null && arr.length > 0) {
				for (int i = 0; i < arr.length; i++) {
					bf.append(KtnbUtil.layoutTableHoTen(arr[i].getHoTen()));
					bf.append(KtnbUtil.layoutTableChucVu(arr[i].getChucVu()));
					bf.append("\n");
				}
				System.out.println(bf.toString());
				parameters.put("thanh_vien", bf.toString());
			}
		} else if ("inTT".equals(type)) {
			fileTemplate = "ttnb26";
			parameters.put("ten_cqt", KtnbUtil.getTenCqtCapTrenTt(app));
			parameters.put("doan_ttkt_so", sb.toString());
			parameters.put("ttkt", hinhThuc);
			parameters.put("so_qd", cbQd.getSoQuyetDinh());
			parameters.put("ngay_qd", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			parameters.put("thu_truong_qd", KtnbUtil.getTenThuTruongCqt(app));
			parameters.put("dv_dc_ttkt", cuocTtkt.getTenDonViBi());
			parameters.put("thu_truong_cqtTH", KtnbUtil.getTenThuTruongCqt(app));
			parameters.put("y_kien_phe_duyet", form.getKienPheDuyet());
			parameters.put("thu_truong_cqt", KtnbUtil.getChucVuThuTruongByMaCqt(app.getMaCqt()));
			parameters.put("noi_phe_duyet", form.getNoiPheDuyet());
			parameters.put("ngay_phe_duyet", Formater.getDateForPrint(form.getNgayPheDuyet()));
			parameters.put("noi_ky_trinh", form.getNoiTrinh());
			parameters.put("ngay_ky_trinh", Formater.getDateForPrint(form.getNgayTrinh()));
			parameters.put("nd_sai_pham", form.getNoiDungNghiVan());
			parameters.put("so_ngay_PT", form.getThoiGian());
			String niendo = "t\u1EEB " + Formater.getDateForPrint(form.getNienDoTuNgay()) + " \u0111\u1EBFn " + Formater.getDateForPrint(form.getNienDoDenNgay());
			parameters.put("thoi_ky_nien_do_PT", niendo);
			//parameters.put("ten_thu_truong", app.getTenThuTruong());
			parameters.put("ten_truong_doan", cuocTtkt.getTenTruongDoan());

			// noi dung phuc tra
			TtktThNoiDungPhucTra[] arrthanhphanbg = form.getNoiDungPhucTra();
			StringBuffer tptd = new StringBuffer("");
			if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
				for (int i = 0; i < arrthanhphanbg.length; i++) {
					tptd.append("+" + arrthanhphanbg[i].getTenNoiDung());
					tptd.append("\n      ");
					// tptd.append("\n");
				}
				System.out.println(tptd.toString());
				parameters.put("nd_phuc_tra", tptd.toString().substring(0, tptd.toString().length() - 7));
			}
		}

		// ---------------- danh sach nguoi thuc hien ----------------
		TtktCmThanhPhanThamDu[] arr = form.getDsCanBoThucHien();
		StringBuffer bf = new StringBuffer("");
		if (arr != null && arr.length > 0) {
			for (int i = 0; i < arr.length; i++) {
				bf.append(Integer.toString(i + 1) + ". " + KtnbUtil.layoutTableHoTen(arr[i].getHoTen()));
				bf.append(KtnbUtil.layoutTableChucVu(arr[i].getChucVu()));
				bf.append("\n       ");
				// bf.append("\n");
			}
			System.out.println(bf.toString());
			parameters.put("dai_dien_doan_ttkt", bf.toString().substring(0, bf.toString().length() - 8));
		}
		if (Formater.isNull(fileTemplate))
			throw new Exception("Chua chon file template");

		InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
		KtnbUtil.printf(reportRows, fileTemplate, reponse, inputStream, parameters, null);
	}

	/**
	 * Download file mau TTNB26,TTNB27
	 * 
	 * @throws Exception
	*/
	private void inPhucTra(HttpServletRequest request, HttpServletResponse reponse, PhucTraForm form, ApplicationContext app, String idCuocTtKt) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;
		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, idCuocTtKt);
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtKt, app);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
		String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
		StringBuffer sb = new StringBuffer(hinhThuc);
		sb = new StringBuffer("\u0110O\u00C0N ");
		sb.append(hinhthuc_inT);
		sb.append(" Q\u0110 S\u1ED0 ");
		sb.append(cbQd.getSoQuyetDinh());
		if ("inQD".equals(type)) {
			fileIn = request.getRealPath("/docin") + "\\TTNB27.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB27_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			fileTemplate = "ttnb27";
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(app).toUpperCase());
				word.put("[cqt_ra_quyet_dinh]", cuocTtkt.getTenDonViTh().toUpperCase());
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				if (cbQd.getDiaDiemRaQuyetDinh().equals("") && form.getNgayLap().equals("")) {
					word.put("[noi_lap1]", ".....");
					word.put("[ngay_lap]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else if(!cbQd.getDiaDiemRaQuyetDinh().equals("") && !form.getNgayLap().equals("")) {
					word.put("[noi_lap1]", form.getNoiTrinh());
					word.put("[ngay_lap]", Formater.getDateForPrint(form.getNgayLap()));
				}else if(!cbQd.getDiaDiemRaQuyetDinh().equals("") && form.getNgayLap().equals("")) {
					word.put("[noi_lap1]", form.getNoiTrinh());
					word.put("[ngay_lap]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				}else if(cbQd.getDiaDiemRaQuyetDinh().equals("") && !form.getNgayLap().equals("")) {
					word.put("[noi_lap1]", ".....");
					word.put("[ngay_lap]", Formater.getDateForPrint(form.getNgayLap()));
				}
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_phuc_tra]", cuocTtkt.getTenDonViBi());
				word.put("[thu_truong_ban_hanhqd]", KtnbUtil.getTenThuTruongCqt(app).toUpperCase());
				word.put("[van_ban_qd]", CatalogService.getTenDanhMucById(cbQd.getVanBanQuyDinhCnangNvuQd()));
				word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong_ban_hanhqd]", KtnbUtil.getTenThuTruongCqt(app));
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				String str = form.getTenNguoiDeNghiPT() + ", " + form.getCvNguoiDeNghiPT() + ", " + form.getCqNguoiDeNghiPT();
				word.put("[chuc_danh_nguoi_de_nghi_phuc_tra]", str);
				word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", form.getSoQdTtKtCanPhucTra());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqt(app));
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[so_ngay_lam_viec]", form.getThoiGian());
				word.put("[ttkt]", hinhThuc);
				//---------------- danh sach nguoi thuc hien ----------------
				Dispatch table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arr1 = form.getDsCanBoThucHien();
				StringBuffer bf1 = new StringBuffer("");
				if (arr1 != null && arr1.length > 0) {
					for (int i = 0; i < arr1.length; i++) {
						bf1.append(KtnbUtil.layoutTableHoTen(arr1[i].getHoTen()));
						bf1.append(KtnbUtil.layoutTableChucVu(arr1[i].getChucVu()));
						bf1.append("\n");
						word.addCellTable(table, i+1, 1, "- \u00D4ng (b\u00E0): " + arr1[i].getHoTen());
						word.addCellTable(table, i+1, 2, "- Ch\u1EE9c v\u1EE5: " + arr1[i].getChucVu());
						word.addRowTable(table,arr1.length);
					}
					System.out.println(bf1.toString());
					//word.put("[thanh_vien]", bf1.toString().substring(0, bf1.toString().length()-1));
				}
				//else
				//	word.put("[thanh_vien]", "");
				word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc);
				//noi dung phuc tra
				if( "NoiBo".equals(form.getLoaiNDHidden())) {
					TtktThNoiDungPhucTra[] arrthanhphanbg = form.getNoiDungPhucTra();
					StringBuffer tptd = new StringBuffer("");
					if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
						for (int i = 0; i < arrthanhphanbg.length; i++) {
							tptd.append("- " + arrthanhphanbg[i].getTenNoiDung());
							tptd.append("\n");
						}
						System.out.println(tptd.toString());
						word.put("[noi_dung]", tptd.toString().substring(0, tptd.toString().length()-1));
					}else
						word.put("[noi_dung]", KtnbUtil.inFieldNull(114));
				}else 
					word.put("[noi_dung]", form.getNoiDungPhucTraNgoaiNganhThue());
				word.put("[ttkt]", hinhThuc);
				String niendo = form.getNienDoTuNgay() + "-" + form.getNienDoDenNgay();
				word.put("[nien_do]", niendo);
				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(app));
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(app.getMaCqt()).toUpperCase());
				// --parameters.put("ngay_lap",Formater.getDateForPrint(form.getNgayLap()));
				// --parameters.put("noi_lap1", cbQd.getDiaDiemRaQuyetDinh());
				//word.put("[thu_truong]", app.getTenThuTruong());
				
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB27", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}finally {				
				try { 
					word.saveAndClose();
				} catch (Exception e) {
					
				}
			}
		} else if ("inTT".equals(type)) {
			fileIn = request.getRealPath("/docin") + "\\TTNB26.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB26_Out" + System.currentTimeMillis()+request.getSession().getId() + ".doc";
			fileTemplate = "ttnb26";
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(app).toUpperCase());
				word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[thu_truong_cqtTH]", KtnbUtil.getTenThuTruongCqt(app));
				word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong_qd]", KtnbUtil.getTenThuTruongCqt(app));
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong_qd]", KtnbUtil.getTenThuTruongCqt(app));
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", hinhThuc);
				word.put("[nd_sai_pham]", form.getNoiDungNghiVan());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong_qd]", KtnbUtil.getTenThuTruongCqt(app));
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//noi dung phuc tra
				TtktThNoiDungPhucTra[] arrthanhphanbg = form.getNoiDungPhucTra();
				StringBuffer tptd = new StringBuffer("");
				if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
					for (int i = 0; i < arrthanhphanbg.length; i++) {
						tptd.append("+" + arrthanhphanbg[i].getTenNoiDung());
						tptd.append("\n      ");
						// tptd.append("\n");
					}
					System.out.println(tptd.toString());
					word.put("[nd_phuc_tra]", tptd.toString().substring(0, tptd.toString().length() - 7));
				}
				String niendo = "t\u1EEB " + Formater.getDateForPrint(form.getNienDoTuNgay()) + " \u0111\u1EBFn " + Formater.getDateForPrint(form.getNienDoDenNgay());
				word.put("[thoi_ky_nien_do_PT]", niendo);
				word.put("[so_ngay_PT]", form.getThoiGian());
				word.put("[ttkt]", hinhThuc);
				//---------------- danh sach nguoi thuc hien ----------------
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arr = form.getDsCanBoThucHien();
				StringBuffer bf = new StringBuffer("");
				if (arr != null && arr.length > 0) {
					for (int i = 0; i < arr.length; i++) {
						bf.append(Integer.toString(i + 1) + ". " + KtnbUtil.layoutTableHoTen(arr[i].getHoTen()));
						bf.append(KtnbUtil.layoutTableChucVu(arr[i].getChucVu()));
						bf.append("\n       ");
						word.addCellTable(table, i+1, 1, "- \u00D4ng (b\u00E0): " + arr[i].getHoTen());
						word.addCellTable(table, i+1, 2, "- Ch\u1EE9c v\u1EE5: " + arr[i].getChucVu());
						word.addRowTable(table,arr.length);
					}
					System.out.println(bf.toString());
					//word.put("[dai_dien_doan_ttkt]", bf.toString().substring(0, bf.toString().length() - 8));
				}
				word.put("[thu_truong_cqtTH]", KtnbUtil.getTenThuTruongCqt(app));
				word.put("[noi_phe_duyet]", form.getNoiPheDuyet());
				word.put("[ngay_phe_duyet]", Formater.getDateForPrint(form.getNgayPheDuyet()));
				word.put("[noi_ky_trinh]", form.getNoiTrinh());
				word.put("[ngay_ky_trinh]", Formater.getDateForPrint(form.getNgayTrinh()));
				word.put("[ttkt]", hinhThuc.toUpperCase());
				word.put("[y_kien_phe_duyet]", form.getKienPheDuyet());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.put("[thu_truong_cqt]", KtnbUtil.getChucVuThuTruongByMaCqt(app.getMaCqt()).toUpperCase());
				//word.put("[ten_thu_truong]", app.getTenThuTruong());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB26", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}
		}

		
		
	}
}
