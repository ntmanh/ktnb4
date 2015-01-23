package cmc.com.ktnb.web.ttkt.dung_chung.action;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.TTKT.dung_chung.KtnbKhTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.KtnbKhTtktNd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhChiTietNoiDungTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhNoiDungTtkt;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.KtnbCache;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.vo.CategoryVO;
import cmc.com.ktnb.web.ttkt.dung_chung.form.CuocTtktForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktService;

/**
 * @@author ntdung1
 * 
 * To change the template for this generated type comment go to Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CuocTtktAction extends TimKiemAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		CuocTtktForm cuocTtktForm = (CuocTtktForm) form;
		String method = request.getParameter("method");
		if ("add".equals(method)) {
			// load gia tri mac dinh
			loadDefaut(appContext, request, cuocTtktForm);
			if (KtnbUtil.isChiCuc(appContext)) {
				request.setAttribute("tu_ttkt", "true");
				request.setAttribute("dmCqtTrucThuoc", KtnbUtil.getDeptByMaCqt(appContext.getMaCqt()));
			}
			if ("suaKeHoachNam".equals(request.getParameter("thoiDiem"))) {
				// request.setAttribute("title", "B\u1ED5 sung cu\u1ED9c Thanh
				// tra Ki\u1EC3m tra cho k\u1EBF ho\u1EA1ch n\u0103m");
				request.setAttribute("title", "B\u1ED5 sung cu\u1ED9c Ki\u1EC3m tra cho k\u1EBF ho\u1EA1ch n\u0103m");
				cuocTtktForm.setLoaiCuocTtktKeHoachNam(Constants.TTKT_LOAI_KHN_ADD);
			} else {
				// request.setAttribute("title", "T\u1EA1o m\u1EDBi cu\u1ED9c
				// Thanh tra Ki\u1EC3m tra");
				request.setAttribute("title", "T\u1EA1o m\u1EDBi cu\u1ED9c Ki\u1EC3m tra");
				cuocTtktForm.setLoaiCuocTtktKeHoachNam(Constants.TTKT_LOAI_KHN_KH);
			}

		} else if ("copy".equals(method) || "edit".equals(method) || "view".equals(method)) {
			loadCuocTtkt(appContext, request, cuocTtktForm, method, request.getParameter("cuocTtktId"));
			if("copy".equals(method))
				cuocTtktForm.setId("");
			if ("view".equals(method)) {
				if (Constants.TT_TTKT_HUY.equals(cuocTtktForm.getTrangThai())) {
					request.setAttribute("trangThaiTienHanh", "huy");
				} else {
					request.setAttribute("trangThaiTienHanh", TtktService.getTrangThaiTienHanh(request.getParameter("cuocTtktId"), appContext, cuocTtktForm.getTrangThai()));
				}
				request.setAttribute("readOnly", "true");
				// request.setAttribute("title", "Cu\u1ED9c Thanh tra Ki\u1EC3m
				// tra");
				request.setAttribute("title", "Cu\u1ED9c Ki\u1EC3m tra");
			} else {
				if ("copy".equals(method)) {
					if ("suaKeHoachNam".equals(request.getParameter("thoiDiem"))) {
						// request.setAttribute("title", "B\u1ED5 sung cu\u1ED9c
						// Thanh tra Ki\u1EC3m tra cho k\u1EBF ho\u1EA1ch
						// n\u0103m");
						request.setAttribute("title", "B\u1ED5 sung cu\u1ED9c Ki\u1EC3m tra cho k\u1EBF ho\u1EA1ch n\u0103m");
					} else {
						request.setAttribute("title", "T\u1EA1o m\u1EDBi cu\u1ED9c Ki\u1EC3m tra");
						// request.setAttribute("title", "T\u1EA1o m\u1EDBi
						// cu\u1ED9c Thanh tra Ki\u1EC3m tra");
					}
				} else {
					// request.setAttribute("title", "S\u1EEDa cu\u1ED9c Thanh
					// tra Ki\u1EC3m tra");
					if ("raQuyetDinh".equals(request.getParameter("thoiDiem")))
						request.setAttribute("title", "Thay \u0111\u1ED5i n\u1ED9i dung Ki\u1EC3m tra so v\u1EDBi k\u1EBF ho\u1EA1ch");
					else
						request.setAttribute("title", "S\u1EEDa cu\u1ED9c Ki\u1EC3m tra");
				}
			}
			// Load du lieu vao cho combo
			if (cuocTtktForm.getIdDonViBi().equals(cuocTtktForm.getIdDonViTh())) {
				request.setAttribute("tu_ttkt", "true");
				request.setAttribute("dmCqtTrucThuoc", KtnbUtil.getDeptByMaCqt(cuocTtktForm.getIdDonViBi()));
			} else {
				if (KtnbUtil.isCuc(appContext) || KtnbUtil.isChiCuc(cuocTtktForm.getIdDonViBi())) {
					// Cho len dung giao dien thoi
					request.setAttribute("tu_ttkt", "true");
					Collection dmCqtTrucThuoc = new ArrayList();
					dmCqtTrucThuoc.add(new CategoryVO(cuocTtktForm.getIdDonViBi(), cuocTtktForm.getDonViBiName()));
					dmCqtTrucThuoc.addAll(KtnbUtil.getDeptByMaCqt(cuocTtktForm.getIdDonViBi()));
					request.setAttribute("dmCqtTrucThuoc", dmCqtTrucThuoc);
				} else {
					Collection dsCqtTrucThuoc = KtnbUtil.getCqtTrucThuoc(appContext, request, cuocTtktForm.getIdDonViBi());
					request.setAttribute("dmCqtTrucThuoc", dsCqtTrucThuoc);
				}
			}

		} else if ("changeDonViDuocTtkt".equals(method)) {
			this.changeDonViDuocTtkt(cuocTtktForm);

			// Load du lieu cho combo
			if (appContext.getMaCqt().equals(cuocTtktForm.getIdDonViBi())) {
				request.setAttribute("dmCqtTrucThuoc", KtnbUtil.getDeptByMaCqt(appContext.getMaCqt()));
				request.setAttribute("tu_ttkt", "true");
				if (KtnbUtil.isChiCuc(appContext)) {
					request.setAttribute("isChiChuc", "true");
				}
			} else {
				if (KtnbUtil.isCuc(appContext)) {
					// De len giao dien cho dung
					request.setAttribute("tu_ttkt", "true");
					Collection dmCqtTrucThuoc = new ArrayList();
					dmCqtTrucThuoc.add(new CategoryVO(cuocTtktForm.getIdDonViBi(), cuocTtktForm.getDonViBiName()));
					dmCqtTrucThuoc.addAll(KtnbUtil.getDeptByMaCqt(cuocTtktForm.getIdDonViBi()));
					request.setAttribute("dmCqtTrucThuoc", dmCqtTrucThuoc);
				} else {
					Collection dsCqtTrucThuoc = KtnbUtil.getCqtTrucThuoc(appContext, request, cuocTtktForm.getIdDonViBi());
					request.setAttribute("dmCqtTrucThuoc", dsCqtTrucThuoc);
				}
			}
			if (Formater.isNull(cuocTtktForm.getId())) {
				if (cuocTtktForm.getLoaiCuocTtktKeHoachNam().equals(Constants.TTKT_LOAI_KHN_ADD)) {
					// request.setAttribute("title", "B\u1ED5 sung cu\u1ED9c
					// Thanh tra Ki\u1EC3m tra cho k\u1EBF ho\u1EA1ch
					// n\u0103m");
					request.setAttribute("title", "B\u1ED5 sung cu\u1ED9c Ki\u1EC3m tra cho k\u1EBF ho\u1EA1ch n\u0103m");
				} else {
					// request.setAttribute("title", "T\u1EA1o m\u1EDBi
					// cu\u1ED9c Thanh tra Ki\u1EC3m tra");
					request.setAttribute("title", "T\u1EA1o m\u1EDBi cu\u1ED9c Ki\u1EC3m tra");
				}

			} else {
				// request.setAttribute("title", "S\u1EEDa cu\u1ED9c Thanh tra
				// Ki\u1EC3m tra");
				request.setAttribute("title", "S\u1EEDa cu\u1ED9c Ki\u1EC3m tra");
			}

		} else if ("save".equals(method)) {
			try {
//				if (Formater.isNull(cuocTtktForm.getId())) {
//					// Neu ma bi trung
//					if ((Formater.isNull(cuocTtktForm.getLoaiCuocTtktKeHoachNam()) || cuocTtktForm.getLoaiCuocTtktKeHoachNam().equals(Constants.TTKT_LOAI_KHN_ADD))
//							&& CuocTtktService.isExist(appContext, cuocTtktForm.getMaKhTtkt()) && !Constants.TTKT_LOAI_QD_ADD_BY_EDIT.equals(cuocTtktForm.getLoaiCuocTtktQuyetDinh())) {
//						// Sinh ma moi
//						String maMoi = genMaCuocTTKT(appContext, request, cuocTtktForm.getLoai(), cuocTtktForm.getHinhThuc(), cuocTtktForm.getMaKhTtkt());
//						cuocTtktForm.setMaKhTtkt(maMoi);
//						request.setAttribute("ma moi", maMoi);
//					}
//				}
				
				TtktKhCuocTtkt cuocTtkt = this.createCuocTtkt(request, appContext, cuocTtktForm);
				if(!CuocTtktService.checkExit(appContext, request, cuocTtkt)){
					if ("raQuyetDinh".equals(request.getParameter("thoiDiem")))
					{
						CuocTtktService.updateCuocTtkt(appContext, request, cuocTtkt);
						request.setAttribute("save_status", "cuccess");
					}
					else
						if("dinhky".equals(request.getParameter("type"))){
							CuocTtktService.copy(cuocTtkt,appContext);
							request.setAttribute("save_status", "cuccess");
						}
						else{
						CuocTtktService.saveCuocTtkt(appContext, request, cuocTtkt);
						request.setAttribute("save_status", "cuccess");
						}
				}else
				{
					request.setAttribute("save_status", "unsuccess");
				}
				if (KtnbUtil.isCuc(appContext) || KtnbUtil.isChiCuc(cuocTtktForm.getIdDonViBi())) {
					// Cho len dung giao dien thoi
					request.setAttribute("tu_ttkt", "true");
					Collection dmCqtTrucThuoc = new ArrayList();
					dmCqtTrucThuoc.add(new CategoryVO(cuocTtktForm.getIdDonViBi(), cuocTtktForm.getDonViBiName()));
					dmCqtTrucThuoc.addAll(KtnbUtil.getDeptByMaCqt(cuocTtktForm.getIdDonViBi()));
					request.setAttribute("dmCqtTrucThuoc", dmCqtTrucThuoc);
				} else {
					Collection dsCqtTrucThuoc = KtnbUtil.getCqtTrucThuoc(appContext, request, cuocTtktForm.getIdDonViBi());
					request.setAttribute("dmCqtTrucThuoc", dsCqtTrucThuoc);
				}
				if (Constants.TTKT_LOAI_QD_ADD_BY_EDIT.equals(cuocTtktForm.getLoaiCuocTtktQuyetDinh())) {
					TtktKhCuocTtkt cuocTtktCu = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, cuocTtkt.getIdCuocQdCu());
					String idCuocTtktMoi = cuocTtktCu.getIdCuocQdMoi();
					request.setAttribute("idCuocTtktMoi", idCuocTtktMoi);
				}

			} catch (Exception ex) {
				throw ex;
			}
		}
		if (!"view".equals(method)) {
			// Cache danh sach cac ngay nghi
			try {
				//String[] temp = cuocTtktForm.getNamKh().split("/");
				String namTienHanh = cuocTtktForm.getNamKh();
				KtnbUtil.cacheListHolidayDayForClient(request, namTienHanh, String.valueOf(Integer.parseInt(namTienHanh) + 1));
			} catch (Exception err) {
				return mapping.findForward("success");
			}
			request.setAttribute("trangThaiTienHanh", "chuaTienHanh");
			request.setAttribute("thoiGianDuKien", getThoiHanKetThuc(cuocTtktForm.getIdDonViTh()));
		}
		if(cuocTtktForm.getIdDonViBi() != null){
//			 Load du lieu vao cho combo
			if (cuocTtktForm.getIdDonViBi().equals(cuocTtktForm.getIdDonViTh())) {
				request.setAttribute("tu_ttkt", "true");
				request.setAttribute("dmCqtTrucThuoc", KtnbUtil.getDeptByMaCqt(cuocTtktForm.getIdDonViBi()));
			} else {
				if (KtnbUtil.isCuc(appContext) || KtnbUtil.isChiCuc(cuocTtktForm.getIdDonViBi())) {
					// Cho len dung giao dien thoi
					request.setAttribute("tu_ttkt", "true");
					Collection dmCqtTrucThuoc = new ArrayList();
					dmCqtTrucThuoc.add(new CategoryVO(cuocTtktForm.getIdDonViBi(), cuocTtktForm.getDonViBiName()));
					dmCqtTrucThuoc.addAll(KtnbUtil.getDeptByMaCqt(cuocTtktForm.getIdDonViBi()));
					request.setAttribute("dmCqtTrucThuoc", dmCqtTrucThuoc);
				} else {
					Collection dsCqtTrucThuoc = KtnbUtil.getCqtTrucThuoc(appContext, request, cuocTtktForm.getIdDonViBi());
					request.setAttribute("dmCqtTrucThuoc", dsCqtTrucThuoc);
				}
			}
		}
		request.setAttribute("dmNoiDungTtktGoc", KtnbCache.getInstance().get("DM_NDGOC"));
		return mapping.findForward("success");
	}

	public static String getThoiHanKetThuc(String idDonViTh) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
		//String suffix = KtnbUtil.isTongCuc(idDonViTh) ? "_TC" : KtnbUtil.isCuc(idDonViTh) ? "_C" : "_CC";
		//String tTraConstValue = (String) Constants.class.getDeclaredField("TH_TTKT_KT_TT" + suffix).get(new Constants());
		//String kTConstValue = (String) Constants.class.getDeclaredField("TH_TTKT_KT_KT" + suffix).get(new Constants());
		//return (String) ((HashMap) KtnbCache.getInstance().get("MAP_THTTKT")).get(tTraConstValue) + "," + (String) ((HashMap) KtnbCache.getInstance().get("MAP_THTTKT")).get(kTConstValue);
		return "45,45";
	}
	/**
	 * 
	 */
	private void changeDonViDuocTtkt(CuocTtktForm cuoc_ttktForm) {
		// Tao noi dung Ttkt cqt mac dinh
		TtktKhNoiDungTtkt noiDungTtktCqtTrucThuoc = new TtktKhNoiDungTtkt();
		noiDungTtktCqtTrucThuoc.setNienDoTuNgayStr(cuoc_ttktForm.getNienDoTuNgay());
		noiDungTtktCqtTrucThuoc.setNienDoDenNgayStr(cuoc_ttktForm.getNienDoDenNgay());
		noiDungTtktCqtTrucThuoc.setThoiGianDuKienStr(cuoc_ttktForm.getThoiGianDuKien());
		noiDungTtktCqtTrucThuoc.setThoiGianDuKienTuNgayStr(cuoc_ttktForm.getThoiGianDuKienTuNgay());
		noiDungTtktCqtTrucThuoc.setThoiGianDuKienDenNgayStr(cuoc_ttktForm.getThoiGianDuKienDenNgay());
		noiDungTtktCqtTrucThuoc.setHinhThucStr(cuoc_ttktForm.getHinhThuc());
		noiDungTtktCqtTrucThuoc.setLoaiStr(cuoc_ttktForm.getLoai());
		cuoc_ttktForm.setArrNoiDungTtktCqtTrucThuoc(new TtktKhNoiDungTtkt[] { noiDungTtktCqtTrucThuoc });

	}

	/**
	 * @param appContext
	 * @param request
	 */
	private void loadCuocTtkt(ApplicationContext appContext, HttpServletRequest request, CuocTtktForm cuoc_ttktForm, String method, String cuocTtktId) throws Exception {
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtkt(appContext, cuocTtktId);
		appContext.setTrangThaiCuocTtkt(cuocTtktId, cuocTtkt.getTrangThai());
		if ("edit".equals(method)) {
			if ("suaKeHoachNam".equals(request.getParameter("thoiDiem"))) {
				// Khong cho phep sua cuoc da duoc sua va cuoc da xoa
				if (!Formater.isNull(cuocTtkt.getIdCuocKhMoi())) {
					// request.setAttribute("Action error", "Cu\u1ED9c Thanh tra
					// Ki\u1EC3m tra n\u00E0y \u0111\u00E3 \u0111\u01B0\u1EE3c
					// s\u1EEDa trong k\u1EBF ho\u1EA1ch n\u0103m!");
					request.setAttribute("Action error", "Cu\u1ED9c Ki\u1EC3m tra n\u00E0y \u0111\u00E3 \u0111\u01B0\u1EE3c s\u1EEDa trong k\u1EBF ho\u1EA1ch n\u0103m!");
				} else if (cuocTtkt.getLoaiCuocTtktKeHoachNam().equals(Constants.TTKT_LOAI_KHN_DEL)) {
					// request.setAttribute("Action error", "Kh\u00F4ng th\u1EC3
					// s\u1EEDa cu\u1ED9c Thanh tra Ki\u1EC3m tra \u0111\u00E3
					// x\u00F3a!");
					request.setAttribute("Action error", "Kh\u00F4ng th\u1EC3 s\u1EEDa cu\u1ED9c Ki\u1EC3m tra \u0111\u00E3 x\u00F3a!");
				}

			}
		}
		if(!Formater.isNull(cuocTtktId)){
			cuoc_ttktForm.setId(cuocTtktId);
		}
		cuoc_ttktForm.setDonViBiName(cuocTtkt.getTenDonViBi());
		cuoc_ttktForm.setDonViThName(cuocTtkt.getTenDonViTh());
		cuoc_ttktForm.setHinhThuc(cuocTtkt.getHinhThuc().booleanValue() ? "1" : "0");
		cuoc_ttktForm.setLoai(cuocTtkt.getLoai().booleanValue() ? "1" : "0");
		cuoc_ttktForm.setIdDonViBi(cuocTtkt.getIdDonViBi());
		cuoc_ttktForm.setIdDonViTh(cuocTtkt.getIdDonViTh());
		cuoc_ttktForm.setNienDoDenNgay(Formater.date2str(cuocTtkt.getNienDoDenNgay()));
		cuoc_ttktForm.setNienDoTuNgay(Formater.date2str(cuocTtkt.getNienDoTuNgay()));
		cuoc_ttktForm.setThoiGianDuKien(cuocTtkt.getThoiGianDuKien().toString());
		cuoc_ttktForm.setThoiGianDuKienTuNgay(Formater.date2str(cuocTtkt.getThoiGianDuKienTuNgay()));
		cuoc_ttktForm.setThoiGianDuKienDenNgay(Formater.date2str(cuocTtkt.getThoiGianDuKienDenNgay()));
		cuoc_ttktForm.setTrangThai(cuocTtkt.getTrangThai());
		String maKh = cuocTtkt.getMa();
		if(!Formater.isNull(maKh))
			//cuoc_ttktForm.setNamKh(Formater.date2str(cuocTtkt.getThoiGianDuKienTuNgay()).split(Formater.date_separator)[2]);
			cuoc_ttktForm.setNamKh(maKh.split("/")[maKh.split("/").length-2]);
		// Noi dung TTKT
		ArrayList dsNoiDungTtktCqtTrucThuoc = new ArrayList();
		Collection listTtktCqtTrucThuoc = cuocTtkt.getDsTtktCqtTrucThuoc();
		Iterator iterTtktCqlTrucThuoc = listTtktCqtTrucThuoc.iterator();
		while (iterTtktCqlTrucThuoc.hasNext()) {
			TtktKhCuocTtkt ttktCqtTrucThuoc = (TtktKhCuocTtkt) iterTtktCqlTrucThuoc.next();
			Collection listNoiDungTtkt = ttktCqtTrucThuoc.getDsNoiDungTTKT();
			Iterator iterNoiDungTtkt = listNoiDungTtkt.iterator();
			while (iterNoiDungTtkt.hasNext()) {
				TtktKhNoiDungTtkt noiDung = (TtktKhNoiDungTtkt) iterNoiDungTtkt.next();
				noiDung.setTenDonViBi(ttktCqtTrucThuoc.getTenDonViBi());
				noiDung.setIdDonViBi(ttktCqtTrucThuoc.getIdDonViBi());
				noiDung.setNienDoDenNgayStr(Formater.date2str(noiDung.getNienDoDenNgay()));
				noiDung.setNienDoTuNgayStr(Formater.date2str(noiDung.getNienDoTuNgay()));
				noiDung.setThoiGianDuKienStr(noiDung.getThoiGianDuKien().toString());
				noiDung.setThoiGianDuKienTuNgayStr(Formater.date2str(noiDung.getThoiGianDuKienTuNgay()));
				noiDung.setThoiGianDuKienDenNgayStr(Formater.date2str(noiDung.getThoiGianDuKienDenNgay()));
				noiDung.setHinhThucStr(noiDung.getHinhThuc().booleanValue() ? "1" : "0");
				noiDung.setLoaiStr(noiDung.getLoai().booleanValue() ? "1" : "0");
				// Chi tiet noi dung
				Collection dsChiTiet = noiDung.getDsChiTietNoiDung();
				if (!Formater.isNull(dsChiTiet)) {
					String chiTietNoiDung = "";
					Iterator iterator = dsChiTiet.iterator();
					/**
					 * Doan nay thay the code cu, chi can lay maNoiDungChiTiet tai index 0
					 * */
					chiTietNoiDung= ((TtktKhChiTietNoiDungTtkt)CollectionUtils.get(dsChiTiet, 0)).getMaNoiDungChiTiet().toString();
					noiDung.setChiTietNoiDung(chiTietNoiDung.substring(0, chiTietNoiDung.length() - 1));
				}
				dsNoiDungTtktCqtTrucThuoc.add(noiDung);
			}
		}
		cuoc_ttktForm.setArrNoiDungTtktCqtTrucThuoc(this.convertToArray(dsNoiDungTtktCqtTrucThuoc));
		if ("edit".equals(method)) {
			// Sua cuoc thanh tra kiem tra trong chinh sua ke hoach nam
			if ("suaKeHoachNam".equals(request.getParameter("thoiDiem"))) {
				if (cuocTtkt.getLoaiCuocTtktKeHoachNam().equals(Constants.TTKT_LOAI_KHN_ADD) || cuocTtkt.getLoaiCuocTtktKeHoachNam().equals(Constants.TTKT_LOAI_KHN_ADD_BY_EDIT)) {
					cuoc_ttktForm.setId(cuocTtkt.getId());
					if (cuocTtkt.getLoaiCuocTtktKeHoachNam().equals(Constants.TTKT_LOAI_KHN_ADD_BY_EDIT))
						cuoc_ttktForm.setIdCuocKhCu(cuocTtkt.getIdCuocKhCu());
					cuoc_ttktForm.setLoaiCuocTtktKeHoachNam(cuocTtkt.getLoaiCuocTtktKeHoachNam());
				} else {
					cuoc_ttktForm.setLoaiCuocTtktKeHoachNam(Constants.TTKT_LOAI_KHN_ADD_BY_EDIT);
					// Id cuoc cu
					cuoc_ttktForm.setIdCuocKhCu(cuocTtkt.getId());
				}
				if (TtktService.getIndexOfTrangThai(cuocTtkt.getTrangThai()) >= TtktService.getIndexOfTrangThai(Constants.TT_TTKT_CDTD)) {
					request.setAttribute("Action status", Constants.MSG_KHG_SUA);
					return;
				}
			} else if ("raQuyetDinh".equals(request.getParameter("thoiDiem"))) {
				// Sua luc ra quyet dinh
				// if (TtktService.getIndexOfTrangThai(Constants.TT_TTKT_QD) <= TtktService.getIndexOfTrangThai(cuocTtkt.getTrangThai())) {
				// request.setAttribute("cuoc_ttkt_da_ra_qd", "true");
				// }
				if (!TtktService.isNewStatus(cuocTtkt.getId(), appContext, Constants.TT_TTKT_QD)) {
					request.setAttribute("cuoc_ttkt_da_ra_qd", "true");
				}
				cuoc_ttktForm.setIdCuocQdCu(cuocTtkt.getId()); // Id cuoc cu
				cuoc_ttktForm.setTrangThai(cuocTtkt.getTrangThai());
				cuoc_ttktForm.setLoaiCuocTtktQuyetDinh(Constants.TTKT_LOAI_QD_ADD_BY_EDIT);

			} else {
				if (TtktService.getIndexOfTrangThai(cuocTtkt.getTrangThai()) >= TtktService.getIndexOfTrangThai(Constants.TT_TTKT_CDTD)) {
					request.setAttribute("Action status", Constants.MSG_KHG_SUA);
					return;
				}
				cuoc_ttktForm.setId(cuocTtkt.getId());
			}

		}
		if ("copy".equals(method)) {
			cuoc_ttktForm.setMaKhTtkt(genMaCuocTTKT(appContext, request, cuoc_ttktForm.getLoai(), cuoc_ttktForm.getHinhThuc(), null));
			// Khi chinh sua ke hoach nam
			if ("suaKeHoachNam".equals(request.getParameter("thoiDiem"))) {
				cuoc_ttktForm.setLoaiCuocTtktKeHoachNam(Constants.TTKT_LOAI_KHN_ADD);
			}
		} else {
			cuoc_ttktForm.setMaKhTtkt(cuocTtkt.getMa());
		}
		if ("view".equals(method)) {
			cuoc_ttktForm.setId(cuocTtkt.getId());
		}

	}

	/**
	 * @param dsNoiDungTtktCqtTrucThuoc
	 * @return
	 */
	private TtktKhNoiDungTtkt[] convertToArray(ArrayList dsNoiDungTtktCqtTrucThuoc) {
		if (dsNoiDungTtktCqtTrucThuoc == null)
			return null;
		TtktKhNoiDungTtkt[] arrReturn = new TtktKhNoiDungTtkt[dsNoiDungTtktCqtTrucThuoc.size()];
		Iterator iter = dsNoiDungTtktCqtTrucThuoc.iterator();
		int index = 0;
		while (iter.hasNext()) {
			arrReturn[index] = (TtktKhNoiDungTtkt) iter.next();
			index++;
		}
		return arrReturn;
	}

	/**
	 * @param request
	 * @param appContext
	 * @param cuoc_ttktForm
	 */
	private TtktKhCuocTtkt createCuocTtkt(HttpServletRequest request, ApplicationContext appContext, CuocTtktForm cuoc_ttktForm) throws Exception, Exception {
		// Thong tin chung header
		TtktKhCuocTtkt cuocTtkt = this.createCuocTtktFromForm(appContext, cuoc_ttktForm);

		// Noi dung Thanh tra Kiem tra
		Collection listTtktCqtTrucThuoc = new ArrayList();
		TtktKhNoiDungTtkt[] arrNoiDungTtktCqtTrucThuoc = cuoc_ttktForm.getArrNoiDungTtktCqtTrucThuoc();
		TtktKhCuocTtkt ttktCqtTrucThuoc = null;
		String idDonViBi = null;
		for (int i = 0; i < arrNoiDungTtktCqtTrucThuoc.length; i++) {
			if(arrNoiDungTtktCqtTrucThuoc[i].getIdNoiDung()!=null){
			idDonViBi = arrNoiDungTtktCqtTrucThuoc[i].getIdDonViBi();
			if (!Formater.isNull(idDonViBi)) {
				// Create cuoc Ttkt con
				ttktCqtTrucThuoc = createNewCuocTtktCon(appContext, arrNoiDungTtktCqtTrucThuoc[i], cuocTtkt);
				Collection dsNoiDungTTKT = new ArrayList();
				dsNoiDungTTKT.add(createMotNoiDungTtktCqtTrucThuoc(arrNoiDungTtktCqtTrucThuoc[i], ttktCqtTrucThuoc.getId(), cuoc_ttktForm));
				ttktCqtTrucThuoc.setDsNoiDungTTKT(dsNoiDungTTKT);
				listTtktCqtTrucThuoc.add(ttktCqtTrucThuoc);
			} else {
				// Bo sung noi dung cho cuoc Ttkt con.
				if(ttktCqtTrucThuoc!=null){
				Collection dsNoiDungTTKT = ttktCqtTrucThuoc.getDsNoiDungTTKT();
				dsNoiDungTTKT.add(createMotNoiDungTtktCqtTrucThuoc(arrNoiDungTtktCqtTrucThuoc[i], ttktCqtTrucThuoc.getId(), cuoc_ttktForm));
				ttktCqtTrucThuoc.setDsNoiDungTTKT(dsNoiDungTTKT);
				}
			}
			}
		}
		// Gan cuoc TTKT con vao cuoc TTKT cha
		cuocTtkt.setDsTtktCqtTrucThuoc(listTtktCqtTrucThuoc);
		cuocTtkt.setIdNguoiCapNat(appContext.getMaCanbo());
		cuocTtkt.setTenNguoiCapNhat(appContext.getTenCanbo());
		cuocTtkt.setNgayCapNhat(new Date(System.currentTimeMillis()));
		//dhphuc: bo sung thong tin bi thieu
		cuocTtkt.setNienDoTuNgay(Formater.str2date(cuoc_ttktForm.getNienDoTuNgay()));
		cuocTtkt.setNienDoDenNgay(Formater.str2date(cuoc_ttktForm.getNienDoDenNgay()));
		cuocTtkt.setThoiGianDuKien(cuocTtkt.getThoiGianDuKien());
		cuocTtkt.setThoiGianDuKienTuNgay(Formater.str2date(cuoc_ttktForm.getThoiGianDuKienTuNgay()));
		cuocTtkt.setThoiGianDuKienDenNgay(Formater.str2date(cuoc_ttktForm.getThoiGianDuKienDenNgay()));
		return cuocTtkt;

	}

	/**
	 * @return
	 */
	private TtktKhCuocTtkt createCuocTtktFromForm(ApplicationContext appContext, CuocTtktForm cuoc_ttktForm) throws Exception {
		TtktKhCuocTtkt cuocTtkt = new TtktKhCuocTtkt();
		cuocTtkt.setId(cuoc_ttktForm.getId());
		cuocTtkt.setIdDonViBi(cuoc_ttktForm.getIdDonViBi());
		cuocTtkt.setIdDonViTh(appContext.getMaCqt());
		cuocTtkt.setNienDoDenNgay(Formater.str2date(cuoc_ttktForm.getNienDoDenNgay()));
		cuocTtkt.setNienDoTuNgay(Formater.str2date(cuoc_ttktForm.getNienDoTuNgay()));
		cuocTtkt.setTenDonViBi(cuoc_ttktForm.getDonViBiName());
		cuocTtkt.setTenDonViTh(appContext.getTenCqt());
		cuocTtkt.setThoiGianDuKien(new Byte(cuoc_ttktForm.getThoiGianDuKien()));
		cuocTtkt.setThoiGianDuKienTuNgay(Formater.str2date(cuoc_ttktForm.getThoiGianDuKienTuNgay()));
		cuocTtkt.setThoiGianDuKienDenNgay(Formater.str2date(cuoc_ttktForm.getThoiGianDuKienDenNgay()));
		cuocTtkt.setHinhThuc("0".equals(cuoc_ttktForm.getHinhThuc()) ? Boolean.FALSE : Boolean.TRUE);
		cuocTtkt.setLoaiCuocTtktKeHoachNam(cuoc_ttktForm.getLoaiCuocTtktKeHoachNam());
		cuocTtkt.setLoaiCuocTtktQuyetDinh(cuoc_ttktForm.getLoaiCuocTtktQuyetDinh());
		cuocTtkt.setLoai(("0".equals(cuoc_ttktForm.getLoai())) ? Boolean.FALSE : Boolean.TRUE);
		cuocTtkt.setIdNguoiCapNat(appContext.getMaCanbo());
		cuocTtkt.setTenNguoiCapNhat(appContext.getTenCanbo());
		cuocTtkt.setNgayCapNhat(new Date(System.currentTimeMillis()));		
		//String loaiStr = "0".equals(cuoc_ttktForm.getLoai()) ? Constants.TTKT_LOAI_KH : Constants.TTKT_LOAI_DX;
		if ("0".equals(cuoc_ttktForm.getLoai())) {
			// Truong hop bo sung thi da co loai roi
			if (Formater.isNull(cuocTtkt.getLoaiCuocTtktKeHoachNam()))
				cuocTtkt.setLoaiCuocTtktKeHoachNam(Constants.TTKT_LOAI_KHN_KH);
			if (!Formater.isNull(cuoc_ttktForm.getIdCuocKhCu())) {
				// Them moi do sua cuoc ttkt trong suakh nam
				cuocTtkt.setIdCuocKhCu(cuoc_ttktForm.getIdCuocKhCu());
			}
		}
		if (!Formater.isNull(cuoc_ttktForm.getIdCuocQdCu())) { // Them moi do sua cuoc ttkt trong quyet dinh
			cuocTtkt.setIdCuocQdCu(cuoc_ttktForm.getIdCuocQdCu());
		}

		if (Formater.isNull(cuocTtkt.getId())) {
			// Truong hop tao moi (tao moi cuoc, tao moi do sua ke hoach, tao moi do sua quyet dinh
			if (Formater.isNull(cuoc_ttktForm.getLoaiCuocTtktQuyetDinh())) {
				// Khong phai truong hop tao moi do sua quyet dinh
				cuocTtkt.setTrangThai(Constants.TT_TTKT_CREATE);
			}		
			cuocTtkt.setMa(this.genMaCuocTTKT(appContext,cuoc_ttktForm.getNamKh(),cuoc_ttktForm.getLoai(), "/KT", ""));				
		} else { // Chi sua cuoc ttkt o trang thai create
			cuocTtkt.setTrangThai(Constants.TT_TTKT_CREATE);
			cuocTtkt.setMa(cuoc_ttktForm.getMaKhTtkt());
		}
		return cuocTtkt;
	}

	/**
	 * @param appContext
	 * @param information
	 * @return
	 */
	private TtktKhCuocTtkt createNewCuocTtktCon(ApplicationContext appContext, TtktKhNoiDungTtkt noiDungTtkt, TtktKhCuocTtkt cuocTtktCha) throws Exception {
		TtktKhCuocTtkt ttktCqtTrucThuoc = new TtktKhCuocTtkt();
		ttktCqtTrucThuoc.setId(KeyManagement.getGUID());
		ttktCqtTrucThuoc.setIdDonViBi(noiDungTtkt.getIdDonViBi());
		ttktCqtTrucThuoc.setIdDonViTh(appContext.getMaCqt());
		ttktCqtTrucThuoc.setTenDonViBi(noiDungTtkt.getTenDonViBi());
		ttktCqtTrucThuoc.setTenDonViTh(appContext.getTenCqt());
		ttktCqtTrucThuoc.setIdCuocTtktCha(cuocTtktCha.getId());
		ttktCqtTrucThuoc.setIdNguoiCapNat(appContext.getMaCanbo());
		ttktCqtTrucThuoc.setTenNguoiCapNhat(appContext.getTenCanbo());
		ttktCqtTrucThuoc.setNgayCapNhat(new Date(System.currentTimeMillis()));
		return ttktCqtTrucThuoc;
	}

	/**
	 * @param information
	 * @param ttktCqt
	 * @return
	 */
	private TtktKhNoiDungTtkt createMotNoiDungTtktCqtTrucThuoc(TtktKhNoiDungTtkt noiDungTtkt, String cuocTtktId, CuocTtktForm cuoc_ttktForm) throws Exception {
		String loai = cuoc_ttktForm.getLoai();
		noiDungTtkt.setId(KeyManagement.getGUID());
		noiDungTtkt.setNienDoDenNgay(Formater.str2date(noiDungTtkt.getNienDoDenNgayStr()));
		noiDungTtkt.setNienDoTuNgay(Formater.str2date(noiDungTtkt.getNienDoTuNgayStr()));
		noiDungTtkt.setThoiGianDuKien(new Byte(noiDungTtkt.getThoiGianDuKienStr()));
		noiDungTtkt.setThoiGianDuKienTuNgay(Formater.str2date(noiDungTtkt.getThoiGianDuKienTuNgayStr()));
		noiDungTtkt.setThoiGianDuKienDenNgay(Formater.str2date(noiDungTtkt.getThoiGianDuKienDenNgayStr()));
		noiDungTtkt.setHinhThuc("0".equals(noiDungTtkt.getHinhThucStr()) ? Boolean.FALSE : Boolean.TRUE);
		noiDungTtkt.setLoai(("0".equals(cuoc_ttktForm.getLoai())) ? Boolean.FALSE : Boolean.TRUE);
		if (!Formater.isNull(noiDungTtkt.getChiTietNoiDung()))
			noiDungTtkt.setDsChiTietNoiDung(createChiTietNoiDung(noiDungTtkt.getId(), noiDungTtkt.getChiTietNoiDung()));
		noiDungTtkt.setIdCuocTtkt(cuocTtktId);
		return noiDungTtkt;
	}

	/**
	 * @param string
	 * @return
	 */
	private Collection createChiTietNoiDung(String idNoiDung, String maChiTietNoiDung) throws Exception {
		Collection listChiTietNoiDung = new ArrayList();
		// Sua code doan nay, chi can luu tat ca maChiTietNoiDung vao MaNoiDungChiTiet, khong can tach = split
		//String[] arrChiTietNoiDung = maChiTietNoiDung.trim().split(",");
		//for (int i = 0; i < arrChiTietNoiDung.length; i++) {
			TtktKhChiTietNoiDungTtkt chiTietNoiDungTtkt = new TtktKhChiTietNoiDungTtkt();
			chiTietNoiDungTtkt.setId(KeyManagement.getGUID());
			chiTietNoiDungTtkt.setIdNoiDungTtkt(idNoiDung);
			chiTietNoiDungTtkt.setIdNoiDungChiTiet("bo sung lai truong nay neu can");
			chiTietNoiDungTtkt.setMaNoiDungChiTiet(maChiTietNoiDung+";");
			chiTietNoiDungTtkt.setTenNoiDungChiTiet("phai lay lai noi dung chi tiet");
			listChiTietNoiDung.add(chiTietNoiDungTtkt);
		//}

		return listChiTietNoiDung;
	}

	/**
	 * @param appContext
	 * @param request
	 * @param cuoc_ttktForm
	 */
	private void loadDefaut(ApplicationContext appContext, HttpServletRequest request, CuocTtktForm cuoc_ttktForm) throws Exception {
		cuoc_ttktForm.setLoai("dinhky".equals(request.getParameter("type")) ? "0" : "1");
		cuoc_ttktForm.setIdDonViTh(appContext.getMaCqt());
		cuoc_ttktForm.setDonViThName(appContext.getTenCqt());
		if (KtnbUtil.isChiCuc(appContext)) {
			cuoc_ttktForm.setIdDonViBi(appContext.getMaCqt());
			cuoc_ttktForm.setDonViBiName(appContext.getTenCqt());
			//cuoc_ttktForm.setLoai("0");
			request.setAttribute("isChiChuc", "true");
		}
		cuoc_ttktForm.setHinhThuc("1");// Bo kg quan ly thanh tra
		cuoc_ttktForm.setMaKhTtkt(genMaCuocTTKT(appContext, request, cuoc_ttktForm.getLoai(), cuoc_ttktForm.getHinhThuc(), null));	
		String year = request.getParameter("nam");
		cuoc_ttktForm.setNamKh(year);
	}

	/**
	 * @param appContext
	 * @return
	 */
	private String genMaCuocTTKT(ApplicationContext appContext, HttpServletRequest request, String loai, String hinhThuc, String maCu) throws Exception {
		String type = "0".equals(loai) ? Constants.TTKT_LOAI_KH : Constants.TTKT_LOAI_DX;
		String year = request.getParameter("nam");
		if (Formater.isNull(year)) {
			String[] temp = maCu.split("/");
			year = temp[temp.length - 2];
		}
		String[] arrMaDaSuDung = CuocTtktService.getDsMaDaSuDung(appContext.getMaCqt(), type, year);
		if (Formater.isNull(hinhThuc))
			hinhThuc = "/TT";
		else {
			if ("0".equals(hinhThuc))
				hinhThuc = "/TT";
			else
				hinhThuc = "/KT";
		}
		return appContext.getTenCqtTat() + hinhThuc + "/" + type + "/" + year + "/" + getSequence(arrMaDaSuDung);
	}
	
	/**
	 * @param appContext
	 * @return
	 */
	private String genMaCuocTTKT(ApplicationContext appContext, String year, String loai, String hinhThuc, String maCu) throws Exception {
		String type = "0".equals(loai) ? Constants.TTKT_LOAI_KH : Constants.TTKT_LOAI_DX;
		if (Formater.isNull(year)) {
			String[] temp = maCu.split("/");
			year = temp[temp.length - 2];
		}
		String[] arrMaDaSuDung = CuocTtktService.getDsMaDaSuDung(appContext.getMaCqt(), type, year);
		if (Formater.isNull(hinhThuc))
			hinhThuc = "/TT";
		else {
			if ("0".equals(hinhThuc))
				hinhThuc = "/TT";
			else
				hinhThuc = "/KT";
		}
		return appContext.getTenCqtTat() + hinhThuc + "/" + type + "/" + year + "/" + getSequence(arrMaDaSuDung);
	}

	private String getSequence(String[] arrMaDaSuDung) {
		if (arrMaDaSuDung == null || arrMaDaSuDung.length <= 0)
			return "001";
		int index = arrMaDaSuDung.length + 1;
		for (int i = 0; i < arrMaDaSuDung.length; i++) {
			if (Integer.parseInt(arrMaDaSuDung[i]) != i + 1) {
				index = i + 1;
				break;
			}
		}
		String sequence = "";
		if (index < 10)
			sequence = "00" + index;
		else if (index < 100)
			sequence = "0" + index;
		else
			sequence = String.valueOf(index);
		return sequence;
	}

	/**
	 * @@param appContext
	 * @@param request
	 * @@return
	 */
	private Collection getDmNoiDungTtktGoc() throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection retval = new ArrayList();
		String sql = "select * from ktnb_dm t where t.parent_id = " + Constants.DM_TTKT;
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			CategoryVO vo;
			String ma;
			String ten;
			while (rs.next()) {
				ma = rs.getString(1);
				ten = rs.getString(2);
				vo = new CategoryVO(ma, ten);
				retval.add(vo);
			}
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}

	public ActionForward xoaCqtTrucThuoc(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("success");

	}

	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		CuocTtktForm cuocTtktForm = (CuocTtktForm) form;
		System.out.println("ID cuoc ttkt : "+cuocTtktForm.getId());
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		if (!Formater.isNull(cuocTtktForm.getId())) {
			save(appContext, cuocTtktForm, request);
		} else
			add(appContext, cuocTtktForm, request);
		return mapping.findForward("kehoachnam");
	}

	/**
	 * @param appContext
	 * @param cuocTtktForm
	 * @param request
	 */
	private void add(ApplicationContext appContext, CuocTtktForm cuocTtktForm, HttpServletRequest request) throws Exception {
		// Luu vao bang cuoc ttkt
		KtnbKhTtkt ktnbKhTtkt = this.getVoFromForm(cuocTtktForm, appContext);
		ktnbKhTtkt = (KtnbKhTtkt) new BaseHibernateDAO().saveObject(appContext, ktnbKhTtkt);

		// Luu vao bang quan he
		String strNoidungTTKT = "";
		String[] arrNoidung = strNoidungTTKT.split(",");
		for (int i = 0; i < arrNoidung.length; i++) {
			KtnbKhTtktNd ktnbKhTtktNd = new KtnbKhTtktNd();
			ktnbKhTtktNd.setIdDmNoiDungTtkt(arrNoidung[i]);
			ktnbKhTtktNd.setIdKhTtkt(ktnbKhTtkt.getId());
			ktnbKhTtktNd.setId(KeyManagement.getGUID());
			new BaseHibernateDAO().saveObject(appContext, ktnbKhTtktNd);
		}

	}

	/**
	 * @param appContext
	 * @param cuocTtktForm
	 * @param request
	 */
	private void save(ApplicationContext appContext, CuocTtktForm cuocTtktForm, HttpServletRequest request) throws Exception {
		// Luu vao bang cuoc ttkt
		KtnbKhTtkt ktnbKhTtkt = this.getVoFromForm(cuocTtktForm, appContext);
		new BaseHibernateDAO().updateObject(appContext, ktnbKhTtkt);

		// Xoa bo noi dung TTKT cu
		Connection conn = null;
		Statement ps = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.createStatement();
			ps.execute("delete ktnb_kh_ttkt_nd where id_kh_ttkt = '" + cuocTtktForm.getId() + "'");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps, conn);
		}
		// Luu noi dung ttkt moi
		String strNoidungTTKT = "";
		String[] arrNoidung = strNoidungTTKT.split(",");
		for (int i = 0; i < arrNoidung.length; i++) {
			KtnbKhTtktNd ktnbKhTtktNd = new KtnbKhTtktNd();
			ktnbKhTtktNd.setIdDmNoiDungTtkt(arrNoidung[i]);
			ktnbKhTtktNd.setIdKhTtkt(ktnbKhTtkt.getId());
			ktnbKhTtktNd.setId(KeyManagement.getGUID());
			new BaseHibernateDAO().saveObject(appContext, ktnbKhTtktNd);
		}
	}

	/**
	 * @param cuocTtktForm
	 * @param appContext
	 * @return
	 */
	private KtnbKhTtkt getVoFromForm(CuocTtktForm cuocTtktForm, ApplicationContext appContext) throws Exception {
		KtnbKhTtkt ktnbKhTtkt = new KtnbKhTtkt();
		ktnbKhTtkt.setDonViBiName(cuocTtktForm.getDonViBiName());
		ktnbKhTtkt.setDonViThName(appContext.getTenCqt());
		ktnbKhTtkt.setNienDoTuNgay(Formater.str2date(cuocTtktForm.getNienDoTuNgay()));
		ktnbKhTtkt.setGhiChu(ktnbKhTtkt.getGhiChu());
		if (Formater.isNull(cuocTtktForm.getId()))
		{
			ktnbKhTtkt.setId(KeyManagement.getGUID());
			ktnbKhTtkt.setMaKhTtkt(this.genMaCuocTTKT(appContext, cuocTtktForm.getNamKh(), cuocTtktForm.getLoai(), cuocTtktForm.getHinhThuc(), null));
		}
		else
		{
			ktnbKhTtkt.setId(cuocTtktForm.getId());
			ktnbKhTtkt.setMaKhTtkt(cuocTtktForm.getMaKhTtkt());
		}
		ktnbKhTtkt.setIdCanBo(appContext.getMaCanbo());
		ktnbKhTtkt.setIdDonVi(appContext.getMaCqt());
		ktnbKhTtkt.setIdDonViBi(cuocTtktForm.getIdDonViBi());
		ktnbKhTtkt.setIdDonViTh(appContext.getMaCqt());
		ktnbKhTtkt.setHinhThuc(new Long(cuocTtktForm.getHinhThuc()));
		ktnbKhTtkt.setLoai(new Long(cuocTtktForm.getLoai()));
		ktnbKhTtkt.setThoiGianDuKien(new Short(cuocTtktForm.getThoiGianDuKien()));
		ktnbKhTtkt.setNienDoDenNgay(Formater.str2date(cuocTtktForm.getNienDoDenNgay()));
		ktnbKhTtkt.setNienDoTtkt(cuocTtktForm.getNienDoTuNgay() + "-" + cuocTtktForm.getNienDoDenNgay());
		return ktnbKhTtkt;
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cuocTtktId = request.getParameter("id");
		CuocTtktForm cuocTtktForm = (CuocTtktForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// Lay thong tin cuoc TTKT
		cuocTtktForm.setKtnbKhTtkt(getCuocTtktById(request, appContext, cuocTtktId));
		cuocTtktForm.setId(cuocTtktId);
		// Lay noi dung TTKT
		cuocTtktForm.setDmNoiDungTTKT(getDmNoiDungTtktGoc());
		return mapping.findForward("success");

	}

	/**
	 * @param cuocTtktId
	 * @return
	 */
	private KtnbKhTtkt getCuocTtktById(HttpServletRequest request, ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(KtnbKhTtkt.class);
		criteria.addSearchItem("id", cuocTtktId);
		return (KtnbKhTtkt) new BaseHibernateDAO().retrieveObject(appContext, KtnbKhTtkt.class, cuocTtktId);
	}

	public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String cuocTtktId = request.getParameter("id");
		CuocTtktForm cuocTtktForm = (CuocTtktForm) form;

		// Lay thong tin cuoc TTKT
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		SearchCriteria criteria = new SearchCriteria(KtnbKhTtkt.class);
		criteria.addSearchItem("id", cuocTtktId);
		KtnbKhTtkt khTtkt = (KtnbKhTtkt) new BaseHibernateDAO().retrieveObject(appContext, KtnbKhTtkt.class, cuocTtktId);
		cuocTtktForm.setKtnbKhTtkt(khTtkt);
		return mapping.findForward("success");
	}

}
