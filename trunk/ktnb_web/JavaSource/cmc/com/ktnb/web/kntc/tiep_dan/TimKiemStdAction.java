package cmc.com.ktnb.web.kntc.tiep_dan;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KntcCanBoRls;
import cmc.com.ktnb.service.kntc.PhanLoaiXuLyService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.HtmlTable;
import cmc.com.ktnb.util.HttpUtil;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.QueryDetails;
import cmc.com.ktnb.util.URLUTF8Encoder;
import cmc.com.ktnb.vo.CategoryVO;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.catalog.CanboForm;
import cmc.com.ktnb.web.catalog.CatalogService;
import cmc.com.ktnb.web.catalog.vo.CanboLovVO;
import cmc.com.ktnb.web.catalog.vo.HoSoLovVO;

/**
 * Xử lý thông tin tìm kiếm hồ sơ KNTC
 * 
 * @since 2011-2012
 * @author Ntthu
 */
public class TimKiemStdAction extends BaseDispatchAction {
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		TimkiemForm tkForm = (TimkiemForm) form;
		// KtnbUtil.setCqt(appContext, tkFom, request);
		String action = request.getParameter("action");
		if (Formater.isNull(action)) {
			action = "default";
		} else {
			request.setAttribute("action", action);
		}
		// Trang thai new =>check with action
		ArrayList list = (ArrayList) request.getAttribute("dmtt");
		ArrayList listKntc = (ArrayList) request.getAttribute("dmkntc");
		if (list == null) { // Chua co trong session
			list = new ArrayList();
			listKntc = new ArrayList();
			// Tim kiem thong thuong
			if ("default".equals(action)) {
				list.add(new LabelValueBean(Constants.TATCA, TimkiemForm.ALL));
				Collection dmTrangThai = CatalogService.getDmByParentId(CatalogService.KNTC_TRANG_THAI);
				for (Iterator iter = dmTrangThai.iterator(); iter.hasNext();) {
					CategoryVO loaitien = (CategoryVO) iter.next();
					if (!Constants.TT_KNTC_XM.equals(loaitien.getId()))
						list.add(new LabelValueBean(loaitien.getName(), loaitien.getId()));
				}
				listKntc = addListKntc();
			}
			// Tim kiem tiep dan - va tim kiem xu ly
			else if ("tktiepdan".equals(action)) {
				list.add(new LabelValueBean(Constants.TATCA, TimkiemForm.ALL));
				Collection dmTrangThai = CatalogService.getDmByParentId(CatalogService.KNTC_TRANG_THAI);
				for (Iterator iter = dmTrangThai.iterator(); iter.hasNext();) {
					CategoryVO vo = (CategoryVO) iter.next();
					list.add(new LabelValueBean(vo.getName(), vo.getId()));
				}
				listKntc = addListKntc();
			} else if ("tkxuly".equals(action)) {
				Collection dmTrangThai = CatalogService.getDmByParentId(CatalogService.KNTC_TRANG_THAI);
				String allTT = Constants.TT_KNTC_CHO_CHUYEN_HS + "," + Constants.TT_KNTC_CHO_VAN_THU_XL + "," + Constants.TT_KNTC_PHAN_LOAI_DX_XLY + "," + Constants.TT_KNTC_XM + ","
						+ Constants.TT_KNTC_KET_LUAN + "," + Constants.TT_KNTC_THI_HANH + "," + Constants.TT_KNTC_KET_THUC;
				list.add(new LabelValueBean(Constants.TATCA, allTT));
				for (Iterator iter = dmTrangThai.iterator(); iter.hasNext();) {
					CategoryVO vo = (CategoryVO) iter.next();
					if (!Constants.TT_KNTC_BO_SUNG_HO_SO.equals(vo.getId()) && !Constants.TT_KNTC_CHO_CHUYEN_HS.equals(vo.getId()))
						list.add(new LabelValueBean(vo.getName(), vo.getId()));
				}
				listKntc = addListKntc();
			}
			// Xu ly ho so tu van Thu
			else if ("chonXLHS1Lan".equals(action)) {
				list.add(new LabelValueBean("Chờ văn thư xử lý", Constants.TT_KNTC_CHO_VAN_THU_XL));
				listKntc = addListKntc();
			}
			// Copy ho so,
			else if ("copyHs".equals(action)) {
				list.add(new LabelValueBean(Constants.TT_KNTC_KET_THUC_TEXT, Constants.TT_KNTC_KET_THUC));
				listKntc = addListKntc();
			} else if ("gopHs".equals(action)) {
				Collection dmTrangThai = CatalogService.getDmByParentId(CatalogService.KNTC_TRANG_THAI);
				String allTT = Constants.TT_KNTC_CHO_CHUYEN_HS + "," + Constants.TT_KNTC_CHO_VAN_THU_XL + "," + Constants.TT_KNTC_PHAN_LOAI_DX_XLY + "," + Constants.TT_KNTC_XM + ","
						+ Constants.TT_KNTC_KET_LUAN + "," + Constants.TT_KNTC_THI_HANH + "," + Constants.TT_KNTC_KET_THUC;
				list.add(new LabelValueBean(Constants.TATCA, allTT));
				for (Iterator iter = dmTrangThai.iterator(); iter.hasNext();) {
					CategoryVO vo = (CategoryVO) iter.next();
					if (!Constants.TT_KNTC_BO_SUNG_HO_SO.equals(vo.getId()) && !Constants.TT_KNTC_CHO_CHUYEN_HS.equals(vo.getId()))
						list.add(new LabelValueBean(vo.getName(), vo.getId()));
				}
				listKntc = addListKn_tc();
			}

			else if ("bosungHS".equals(action) || "suaHSTD".equals(action)) {
				list.add(new LabelValueBean(Constants.TATCA, Constants.TT_KNTC_BO_SUNG_HO_SO + "," + Constants.TT_KNTC_CHO_CHUYEN_HS));
				list.add(new LabelValueBean("Bổ sung HSTL", Constants.TT_KNTC_BO_SUNG_HO_SO));
				list.add(new LabelValueBean("Chuyển HS sang BPHC", Constants.TT_KNTC_CHO_CHUYEN_HS));
				listKntc = addListKntc();
			} else if ("chuyenHS".equals(action)) {
				list.add(new LabelValueBean("Chuyển HS sang BPHC", Constants.TT_KNTC_CHO_CHUYEN_HS));
				listKntc = addListKntc();
			} else if ("phancongHS".equals(action)) {
				Collection dmTrangThai = CatalogService.getDmByParentId(CatalogService.KNTC_TRANG_THAI);
				String allTT = Constants.TT_KNTC_CHO_VAN_THU_XL + "," + Constants.TT_KNTC_PHAN_LOAI_DX_XLY + "," + Constants.TT_KNTC_XM + "," + Constants.TT_KNTC_KET_LUAN;
				list.add(new LabelValueBean(Constants.TATCA, allTT));
				for (Iterator iter = dmTrangThai.iterator(); iter.hasNext();) {
					CategoryVO loaitien = (CategoryVO) iter.next();
					if (!Constants.TT_KNTC_BO_SUNG_HO_SO.equals(loaitien.getId()) && !Constants.TT_KNTC_CHO_CHUYEN_HS.equals(loaitien.getId()) && !Constants.TT_KNTC_THI_HANH.equals(loaitien.getId())
							&& !Constants.TT_KNTC_KET_THUC.equals(loaitien.getId()))
						list.add(new LabelValueBean(loaitien.getName(), loaitien.getId()));
				}
				listKntc = addListKntc();
			} else if ("suaHSVT".equals(action)) {
				list.add(new LabelValueBean(Constants.TT_KNTC_PHAN_LOAI_DX_XLY_TEXT, Constants.TT_KNTC_PHAN_LOAI_DX_XLY));
				listKntc = addListKntc();
			} else if ("phanloaiHSKN".equals(action)) {
				list.add(new LabelValueBean(Constants.TT_KNTC_PHAN_LOAI_DX_XLY_TEXT, Constants.TT_KNTC_PHAN_LOAI_DX_XLY));
				listKntc = addListKN();
			} else if ("qdxmtc".equals(action) || "khxmtc".equals(action) || "xacMinhToCao".equals(action)) {
				list.add(new LabelValueBean(Constants.TT_KNTC_XM_TEXT, Constants.TT_KNTC_XM));
				listKntc = addListTC();
				tkForm.setLoaiHoSo("2");
			}
			// Khieu Nai
			else if ("bbxmkn".equals(action)) {
				list.add(new LabelValueBean(Constants.TT_KNTC_XM_TEXT, Constants.TT_KNTC_XM));
				listKntc = addListKN();
			} else if ("qdxmkn".equals(action) || "khxmkn".equals(action) || "xacMinhKhieuNai".equals(action)) {
				list.add(new LabelValueBean(Constants.TT_KNTC_XM_TEXT, Constants.TT_KNTC_XM));
				listKntc = addListKN();
			} else if ("ketThucKhieuNai".equals(action)) {
				list.add(new LabelValueBean(Constants.TT_KNTC_KET_LUAN_TEXT, Constants.TT_KNTC_KET_LUAN));
				listKntc = addListKN();
			} else if ("qdgq".equals(action) || "bckqxmKN".equals(action)) {
				list.add(new LabelValueBean(Constants.TATCA, Constants.TT_KNTC_XM + "," + Constants.TT_KNTC_KET_LUAN));
				list.add(new LabelValueBean(Constants.TT_KNTC_XM_TEXT, Constants.TT_KNTC_XM));
				list.add(new LabelValueBean(Constants.TT_KNTC_KET_LUAN_TEXT, Constants.TT_KNTC_KET_LUAN));
				listKntc = addListKN();
			} else if ("tachDon".equals(action)) {
				list.add(new LabelValueBean(Constants.TT_KNTC_PHAN_LOAI_DX_XLY_TEXT, Constants.TT_KNTC_PHAN_LOAI_DX_XLY));
				listKntc = addListKntc();
				tkForm.setLoaiHoSo("3");
			} else if ("lichTrinhDKKN".equals(action)) {
				list.add(new LabelValueBean(Constants.TATCA, Constants.TT_KNTC_XM + "," + Constants.TT_KNTC_KET_LUAN + "," + Constants.TT_KNTC_THI_HANH + "," + Constants.TT_KNTC_KET_THUC));
				list.add(new LabelValueBean(Constants.TT_KNTC_XM_TEXT, Constants.TT_KNTC_XM));
				list.add(new LabelValueBean(Constants.TT_KNTC_KET_LUAN_TEXT, Constants.TT_KNTC_KET_LUAN));
				list.add(new LabelValueBean(Constants.TT_KNTC_THI_HANH_TEXT, Constants.TT_KNTC_THI_HANH));
				list.add(new LabelValueBean(Constants.TT_KNTC_KET_THUC_TEXT, Constants.TT_KNTC_KET_THUC));
				listKntc = addListKN();
			} else if ("bbDoiThoaiKN".equals(action)) {
				list.add(new LabelValueBean(Constants.TATCA, Constants.TT_KNTC_XM + "," + Constants.TT_KNTC_KET_LUAN));
				list.add(new LabelValueBean(Constants.TT_KNTC_XM_TEXT, Constants.TT_KNTC_XM));
				list.add(new LabelValueBean(Constants.TT_KNTC_KET_LUAN_TEXT, Constants.TT_KNTC_KET_LUAN));
				listKntc = addListKN();
			} else if ("rutdon".equals(action)) {
				String allTT = Constants.TT_KNTC_CHO_VAN_THU_XL + "," + Constants.TT_KNTC_PHAN_LOAI_DX_XLY + "," + Constants.TT_KNTC_XM + "," + Constants.TT_KNTC_KET_LUAN;
				list.add(new LabelValueBean(Constants.TATCA, allTT));
				Collection dmTien = CatalogService.getDmByParentId(CatalogService.KNTC_TRANG_THAI);
				for (Iterator iter = dmTien.iterator(); iter.hasNext();) {
					CategoryVO vo = (CategoryVO) iter.next();
					if (!Constants.TT_KNTC_BO_SUNG_HO_SO.equals(vo.getId()) && !Constants.TT_KNTC_CHO_CHUYEN_HS.equals(vo.getId()) && !Constants.TT_KNTC_THI_HANH.equals(vo.getId())
							&& !Constants.TT_KNTC_KET_THUC.equals(vo.getId()))
						list.add(new LabelValueBean(vo.getName(), vo.getId()));
				}
				listKntc = addListKN();
			} else if ("theodoiKN".equals(action)) {
				list.add(new LabelValueBean(Constants.TT_KNTC_THI_HANH_TEXT, Constants.TT_KNTC_THI_HANH));
				listKntc = addListKN();
			} else if ("bbLamViecNguoiKN".equals(action) || "bbLamViecNguoiBiKN".equals(action) || "phieuYcHsTlKN".equals(action) || "phieuYcGtKN".equals(action) || "yktvKN".equals(action)
					|| "ycgdKN".equals(action) || "giahanKN".equals(action) || "kqxmKN".equals(action)) {
				list.add(new LabelValueBean(Constants.TT_KNTC_XM_TEXT, Constants.TT_KNTC_XM));
				listKntc = addListKN();
			} else if ("bbLamViecNguoiKN0".equals(action)) {
				list.add(new LabelValueBean(Constants.TATCA, Constants.TT_KNTC_XM + "," + Constants.TT_KNTC_KET_LUAN));
				list.add(new LabelValueBean(Constants.TT_KNTC_XM_TEXT, Constants.TT_KNTC_XM));
				list.add(new LabelValueBean(Constants.TT_KNTC_KET_LUAN_TEXT, Constants.TT_KNTC_KET_LUAN));
				listKntc = addListKN();
			}

			else if ("xuLyKhieuNai".equals(action)) {
				list.add(new LabelValueBean(Constants.TATCA, Constants.TT_KNTC_PHAN_LOAI_DX_XLY + "," + Constants.TT_KNTC_XM + "," + Constants.TT_KNTC_KET_LUAN + "," + Constants.TT_KNTC_THI_HANH));
				list.add(new LabelValueBean(Constants.TT_KNTC_PHAN_LOAI_DX_XLY_TEXT, Constants.TT_KNTC_PHAN_LOAI_DX_XLY));
				list.add(new LabelValueBean(Constants.TT_KNTC_XM_TEXT, Constants.TT_KNTC_XM));
				list.add(new LabelValueBean(Constants.TT_KNTC_KET_LUAN_TEXT, Constants.TT_KNTC_KET_LUAN));
				list.add(new LabelValueBean(Constants.TT_KNTC_THI_HANH_TEXT, Constants.TT_KNTC_THI_HANH));
				listKntc = addListKN();
			}
			// To cao
			else if ("phanloaiHSTC".equals(action)) {
				list.add(new LabelValueBean(Constants.TT_KNTC_PHAN_LOAI_DX_XLY_TEXT, Constants.TT_KNTC_PHAN_LOAI_DX_XLY));
				listKntc = addListTC();
				tkForm.setLoaiHoSo("2");
			} else if ("bbxmtc".equals(action) || "bckqxmtc".equals(action)) {
				list.add(new LabelValueBean(Constants.TT_KNTC_XM_TEXT, Constants.TT_KNTC_XM));
				listKntc = addListTC();
				tkForm.setLoaiHoSo("2");
			} else if ("ketLuanTC".equals(action) || "bbThongBaoDuThaoTC".equals(action)) {
				list.add(new LabelValueBean(Constants.TATCA, Constants.TT_KNTC_XM + "," + Constants.TT_KNTC_KET_LUAN));
				list.add(new LabelValueBean(Constants.TT_KNTC_XM_TEXT, Constants.TT_KNTC_XM));
				list.add(new LabelValueBean(Constants.TT_KNTC_KET_LUAN_TEXT, Constants.TT_KNTC_KET_LUAN));
				listKntc = addListTC();
				tkForm.setLoaiHoSo("2");
			} else if ("bbLamViecNguoiTC0".equals(action)) {
				list.add(new LabelValueBean(Constants.TATCA, Constants.TT_KNTC_XM + "," + Constants.TT_KNTC_KET_LUAN));
				list.add(new LabelValueBean(Constants.TT_KNTC_XM_TEXT, Constants.TT_KNTC_XM));
				list.add(new LabelValueBean(Constants.TT_KNTC_KET_LUAN_TEXT, Constants.TT_KNTC_KET_LUAN));
				listKntc = addListTC();
				tkForm.setLoaiHoSo("2");
			} else if ("lichTrinhDKTC".equals(action)) {
				list.add(new LabelValueBean(Constants.TATCA, Constants.TT_KNTC_XM + "," + Constants.TT_KNTC_KET_LUAN + "," + Constants.TT_KNTC_THI_HANH + "," + Constants.TT_KNTC_KET_THUC));
				list.add(new LabelValueBean(Constants.TT_KNTC_XM_TEXT, Constants.TT_KNTC_XM));
				list.add(new LabelValueBean(Constants.TT_KNTC_KET_LUAN_TEXT, Constants.TT_KNTC_KET_LUAN));
				list.add(new LabelValueBean(Constants.TT_KNTC_THI_HANH_TEXT, Constants.TT_KNTC_THI_HANH));
				list.add(new LabelValueBean(Constants.TT_KNTC_KET_THUC_TEXT, Constants.TT_KNTC_KET_THUC));
				listKntc = addListTC();
				tkForm.setLoaiHoSo("2");
			} else if ("ketThucToCao".equals(action)) {
				list.add(new LabelValueBean(Constants.TT_KNTC_KET_LUAN_TEXT, Constants.TT_KNTC_KET_LUAN));
				listKntc = addListTC();
			} else if ("25A".equals(action) || "25B".equals(action) || "tbkqgqtc".equals(action)) {
				list.add(new LabelValueBean(Constants.TATCA, Constants.TT_KNTC_KET_LUAN + "," + Constants.TT_KNTC_THI_HANH));
				list.add(new LabelValueBean(Constants.TT_KNTC_KET_LUAN_TEXT, Constants.TT_KNTC_KET_LUAN));
				list.add(new LabelValueBean(Constants.TT_KNTC_THI_HANH_TEXT, Constants.TT_KNTC_THI_HANH));
				listKntc = addListTC();
				tkForm.setLoaiHoSo("2");
			} else if ("theodoiTC".equals(action)) {
				list.add(new LabelValueBean(Constants.TT_KNTC_THI_HANH_TEXT, Constants.TT_KNTC_THI_HANH));
				listKntc = addListTC();
				tkForm.setLoaiHoSo("2");
			} else if ("bbLamViecNguoiTC".equals(action) || "bbLamViecNguoiBiTC".equals(action) || "phieuYcHsTlTC".equals(action) || "bbYeuCauBoSungHSTLTC".equals(action)
					|| "phieuYcGtTC".equals(action) || "yktvTC".equals(action) || "ycgdTC".equals(action) || "giahanTC".equals(action) || "bckqxmTC".equals(action)) {
				list.add(new LabelValueBean(Constants.TT_KNTC_XM_TEXT, Constants.TT_KNTC_XM));
				listKntc = addListTC();
			} else if ("xuLyToCao".equals(action)) {
				list.add(new LabelValueBean(Constants.TATCA, Constants.TT_KNTC_PHAN_LOAI_DX_XLY + "," + Constants.TT_KNTC_XM + "," + Constants.TT_KNTC_KET_LUAN + "," + Constants.TT_KNTC_THI_HANH));
				list.add(new LabelValueBean(Constants.TT_KNTC_PHAN_LOAI_DX_XLY_TEXT, Constants.TT_KNTC_PHAN_LOAI_DX_XLY));
				list.add(new LabelValueBean(Constants.TT_KNTC_XM_TEXT, Constants.TT_KNTC_XM));
				list.add(new LabelValueBean(Constants.TT_KNTC_KET_LUAN_TEXT, Constants.TT_KNTC_KET_LUAN));
				list.add(new LabelValueBean(Constants.TT_KNTC_THI_HANH_TEXT, Constants.TT_KNTC_THI_HANH));

				listKntc = addListTC();
			}
		}
		request.setAttribute("dmtt", list);
		request.setAttribute("dmkntc", listKntc);
		KtnbUtil.setCqtCapCuc(appContext, tkForm, request);
		String capCqt = tkForm.getCapCqt();

		// Xử lý các combo nếu có thay đổi
		if (request.getParameter("loai") != null) {
			tkForm.setLoaiHoSo(request.getParameter("loai"));
		}

		tkForm = changeLoaiHoSo(tkForm, request);

		if (!Formater.isNull(capCqt)) {
			KtnbUtil.setCqt(appContext, tkForm, request, tkForm.getCapCqt());
		} else
			KtnbUtil.setCqt(appContext, tkForm, request, appContext.getMaCqt());
		// saveToken(request);
		return map.findForward("success");
	}

	public ActionForward search(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Loop 3 request :|
		// if (isTokenValid(request)) {
		JSONObject jsonResult = null;
		TimkiemForm tF = (TimkiemForm) form;
		try {
			jsonResult = this.find(tF, request);
			response.setContentType("application/json;charset=UTF-8");
			response.setHeader("Cache-Control", "no-store");
			PrintWriter out = response.getWriter();
			out.println(jsonResult);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// }
		return null;
	}

	public ActionForward lov(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		TimkiemForm cForm = (TimkiemForm) form;
		StringBuffer sql = new StringBuffer("select t.ma_hs,t.nnd_ten,t.cong_van_den_ngay as ngaycv,t.ten_cqt as tencqt,t.trang_thai as trangthai,t.loai_kntc as loaihoso "
				+ "from kntc_ho_so_hdr t where t.ma_cqt='"+appContext.getMaCqt()+"'");
		String loaiHoSo;
		if(!Formater.isNull(request.getParameter("loai")))
		{
			cForm.setLoaiHoSo(request.getParameter("loai"));
		}
		String txtSearch = cForm.getMaHoSo();
		loaiHoSo = cForm.getLoaiHoSo();
		String trangThai = cForm.getTrangThai();
		if (!Formater.isNull(loaiHoSo)) {
			sql.append(" AND t.loai_kntc = '" + loaiHoSo+ "'");
		}else{
			sql.append(" AND t.loai_kntc = '1'");
		}
		if (!Formater.isNull(trangThai) && !"0".equals(trangThai)) {
			sql.append(" AND t.trang_thai = '" + trangThai+ "'");
		}
		if (!Formater.isNull(txtSearch)) {
			sql.append(" AND t.ma_hs like '%" + txtSearch.trim().toUpperCase() + "%'"); // '"+txtSearch.trim().toLowerCase()
		}
		if (!Formater.isNull(request.getParameter("nnd"))) {
			sql.append(" AND (upper(t.nnd_ten) like '%" + request.getParameter("nnd").trim().toUpperCase() + "%')"); // '"+txtSearch.trim().toLowerCase()
		} else if (!Formater.isNull(cForm.getNguoiNopDon())) {
			sql.append(" AND (upper(t.nnd_ten) like '%" + cForm.getNguoiNopDon().trim().toUpperCase() + "%')");
		}
		// Hồ sơ gộp phải nhỏ hơn trạng thái xác minh.
		String hoSoDuocGopLuu = request.getParameter("tt");		
		if (!Formater.isNull(hoSoDuocGopLuu) && "y".equals(hoSoDuocGopLuu)) {
			sql.append(" AND t.TRANG_THAI < '" + Constants.TT_KNTC_XM + "'");
			// Hồ sơ được gộp phải là hồ sơ hợp lệ, chưa được gộp vào hồ sơ nào
			// => loai_quna_he = null
			 sql.append(" AND (t.LOAI_QH <> '"+Constants.LIEN_KET_GOP+"' or loai_qh is null)");
		}
		
		// Không tìm hồ sơ đã xóa
		//sql.append(" AND t.LOAI_KET_THUC != '" + Constants.KNTC_KET_THUC_XOA_HS + "' ");
		sql.append(" and (t.loai_ket_thuc != '" + Constants.KNTC_KET_THUC_XOA_HS + "' or t.loai_ket_thuc is null)");
		// TODO: Thiếu check quyền cán bộ

		//sql.append(KtnbUtil.addCqtCondition(appContext, "t"));
		
		sql.append(" ORDER By t.cong_van_den_ngay desc");
		Session session = HibernateSessionFactory.openNewSession();
		Collection objects = new ArrayList();
		HtmlTable table = new HtmlTable();
		if (session != null) {
			QueryDetails queryDetails = new QueryDetails();
			try {
				session.beginTransaction();
				// BaseHibernateDAO dao = new BaseHibernateDAO();
				String sPageNumber = request.getParameter("pageNumber");
				try {
					queryDetails.setPageNumber(new Integer(sPageNumber));
					request.setAttribute("pnumber", sPageNumber);
					queryDetails.setPageSize(Constants.PAGE_SIZE_DEFAULT);
				} catch (Exception e) {
					queryDetails.setPageNumber(new Integer("1"));
					queryDetails.setPageSize(new Integer("10"));
					request.setAttribute("pnumber", new Integer("1"));
				}
				System.out.println("SQL Lov: " + sql.toString());
				Query q = session.createSQLQuery(sql.toString()).setFirstResult(queryDetails.getBeginIndex()).setMaxResults(queryDetails.getLastIndex());
				objects = q.list();
				int total = 0;
				if (objects != null && objects.size() > 0) {
					total = objects.size();
					// set data to display
					Collection ret = new ArrayList();
					table.setPageNumber(Integer.toString(queryDetails.getPageNumber().intValue()));
					table.setPageSize(queryDetails.getPageSize().longValue());
					table.setTotalRecord(total);
					for (Iterator iter = objects.iterator(); iter.hasNext();) {
						HoSoLovVO vo = new HoSoLovVO((Object[]) iter.next());
						ret.add(vo);
					}
					table.setData(ret);
					table.setGoToPageUrl(this.getUrl(request, "lov"));
					table.setSearchForm("stdTimKiemForm");
					request.setAttribute("dtnts", table);
				}
			} catch (Exception e) {
				e.printStackTrace();
				HibernateSessionFactory.rollbackQuiet();
				throw new Exception(e);
			} finally {
				HibernateSessionFactory.closeSessionQuiet();
			}
		}
		request.setAttribute("total", new Long(table.getCurrentTotalRecord()));
		return mapping.findForward("lov");
	}

	private JSONObject find(TimkiemForm tkForm, HttpServletRequest request) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String space10 = "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;";
		String space5 = "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;";
		// Collection retval = new ArrayList();
		int start = Integer.parseInt(request.getParameter("iDisplayStart"));
		//if (start == 0)
		start++;
		String maHs = request.getParameter("maHs");
		if (!Formater.isNull(maHs))
			tkForm.setMaHoSo(maHs);
		String tt = request.getParameter("tt");
		if (!Formater.isNull(tt))
			tkForm.setTrangThai(tt);
		String loai = request.getParameter("loai");
		if (!Formater.isNull(loai))
			tkForm.setLoaiHoSo(loai);
		String cqt = request.getParameter("cqt");
		if (!Formater.isNull(cqt))
			tkForm.setArrCqt(cqt);
		String sDate = request.getParameter("sDate");
		if (!Formater.isNull(sDate) & sDate != "")
			tkForm.setTuNgay(sDate);
		String fDate = request.getParameter("fDate");
		if (!Formater.isNull(fDate) & fDate != "")
			tkForm.setDenNgay(fDate);
		String tdTuNgay = request.getParameter("tdTuNgay");
		if (!Formater.isNull(tdTuNgay) & tdTuNgay != "")
			tkForm.setTdTuNgay(tdTuNgay);
		String tdDenNgay = request.getParameter("tdDenNgay");
		if (!Formater.isNull(tdDenNgay) & tdDenNgay != "")
			tkForm.setTdDenNgay(tdDenNgay);
		String cvsDate = request.getParameter("cvsDate");
		if (!Formater.isNull(cvsDate) & cvsDate != "")
			tkForm.setCvTuNgay(cvsDate);
		String cvfDate = request.getParameter("cvfDate");
		if (!Formater.isNull(cvfDate) & cvfDate != "")
			tkForm.setCvDenNgay(cvfDate);
		String nguoiNopDon = request.getParameter("nnd");
		if (!Formater.isNull(nguoiNopDon))
			tkForm.setNguoiNopDon(nguoiNopDon);
		String canBoXL = request.getParameter("cbxl");
		if (!Formater.isNull(canBoXL))
			tkForm.setCanBoXL(canBoXL);
		String nguoiUyQuyen = request.getParameter("nuq");
		if (!Formater.isNull(nguoiUyQuyen))
			tkForm.setNguoiUyQuyen(nguoiUyQuyen);
		String textSearch = request.getParameter("tSearch");
		if (!Formater.isNull(textSearch))
			tkForm.setTextSearch(textSearch);
		String doanKNTC=request.getParameter("doanKNTC");
		if(!Formater.isNull(doanKNTC))
			tkForm.setDoanKNTC(doanKNTC);
		String action = request.getParameter("action");

		String[] arr = appContext.getRoleData();
		boolean isPP = false;
		if (arr != null && arr.length > 0 && appContext.getMaChucvu().equals("1115"))
			isPP = true;

		StringBuffer sql = new StringBuffer(
				"select dtl.*,ktnb_pck_util.fnc_get_cqt_chuyen(dtl.ma_hs) as dvchuyen from  ( select * from (select rownum r, t.ma_hs,t.doan_kntc_so_luong,t.nnd_ten,t.nuq_ten,t.nguoi_bi_kntc_ten as nguoibikntc" +
				",t.ngay_tiep,t.cong_van_den_ngay as ngaycv,r.ma_canbo,t.ma_cqt,t.ten_cqt as tencqt" +
				",t.trang_thai,t.loai_kntc,t.loai_hs " +				
				"from kntc_ho_so_hdr t,kntc_can_bo_rls r");
		if ((request.getParameter("thamQuyen") != null && !"0".equals(request.getParameter("thamQuyen")) )||(request.getParameter("thuLy") != null && !"0".equals(request.getParameter("thuLy")))) {
			sql = new StringBuffer(
			"select dtl.*,ktnb_pck_util.fnc_get_cqt_chuyen(dtl.ma_hs) as dvchuyen from  ( select * from (select rownum r, t.ma_hs,t.doan_kntc_so_luong,t.nnd_ten,t.nuq_ten,t.nguoi_bi_kntc_ten as nguoibikntc" +
			",t.ngay_tiep,t.cong_van_den_ngay as ngaycv,r.ma_canbo,t.ma_cqt,t.ten_cqt as tencqt" +
			",t.trang_thai,t.loai_kntc,t.loai_hs " +
			"from kntc_ho_so_hdr t,kntc_de_xuat_xly dx,kntc_can_bo_rls r");
		}
		/**
		 * Chọn hồ sơ xử lý 1 lần. Được phép nhìn các bộ hồ sơ từ cơ quan khác
		 * chuyển đến hoặc từ tiếp dân chuyển lên
		 */
		if ("chonXLHS1Lan".equals(action)) {
			sql.append(" where t.ma_cqt='" + appContext.getMaCqt() + "'");
		}
		/**
		 * Các action thực hiện chức năng. Chỉ nhìn thấy bộ hồ sơ mình được phép
		 * thực hiện
		 */
		else if (!action.equals("tktiepdan") && !action.equals("tkxuly") && !action.equals("lichTrinhDKKN") && !action.equals("lichTrinhDKTC")) {
			sql.append(" where (r.ma_canbo = '" + appContext.getMaCanbo() + "' or t.nguoi_cap_nhat = '" + appContext.getMaCanbo() + "')");
		}
		/**
		 * Các action tra cứu và xem lịch trình
		 */
		else {
			if (appContext.isLanhDao() || isPP) {
				sql.append(" where 1=1 ");
			} else {
				sql.append(" where 1=1 ");
				if (arr != null && arr.length > 0) {
					sql.append(" AND ((r.ma_canbo = '" + appContext.getMaCanbo() + "' or t.nguoi_cap_nhat = '" + appContext.getMaCanbo() + "')");
					if (!Formater.isNull(tkForm.getArrCqt())) {
						arr = tkForm.getArrCqt().split(",");
						String newArr = "";
						for (int i = 0; i < arr.length; i++) {
							newArr += ",'" + arr[i] + "'";
						}
						sql.append(" OR t.ma_cqt in (" + newArr.substring(1) + ")");
						tkForm.setArrCqt(null);
					}
				} else {
					sql.append(" AND (r.ma_canbo = '" + appContext.getMaCanbo() + "' or t.nguoi_cap_nhat = '" + appContext.getMaCanbo() + "'");
				}
				sql.append(") and r.ma_hs = t.ma_hs and r.lan_td = 0 and r.loai_cb=" + KntcCanBoRls.KNTC_CB_XU_LY);
			}
			// Neu la pho phong
			if (isPP) {
				String newArr = "";
				for (int i = 0; i < arr.length; i++) {
					newArr += ",'" + arr[i] + "'";
				}
				// Nhin thay cac ho so cua can bo duoc quan ly
				String arrCanBo = "";
				String[] arrCB = appContext.getArrCb();
				for (int i = 0; i < arrCB.length; i++) {
					arrCanBo += ",'" + arrCB[i] + "'";
				}
				sql.append(" AND ( (t.ma_cqt in (" + newArr.substring(1) + "))");
				sql.append(" OR  (t.ma_can_bo in(" + arrCanBo.substring(1) + ")))");
			}
			// Danh sach co quan thue neu chon
			// if (!Formater.isNull(tkForm.getArrCqt())) {
			// arr = tkForm.getArrCqt().split(",");
			// String newArr = "";
			// for (int i = 0; i < arr.length; i++) {
			// newArr += ",'" + arr[i] + "'";
			// }
			// sql.append(" AND t.ma_cqt in (" + newArr.substring(1) + ")");
			// }
			sql.append(KtnbUtil.addCqtCondition2(appContext, "t"));
		}
		// Danh sach co quan thue neu chon
		if (!Formater.isNull(tkForm.getArrCqt())) {
			arr = tkForm.getArrCqt().split(",");
			String newArr = "";
			for (int i = 0; i < arr.length; i++) {
				newArr += ",'" + arr[i] + "'";
			}
			sql.append(" AND t.ma_cqt in (" + newArr.substring(1) + ")");
		}
		// Tìm tiếp dân =>Chỉ load loại hồ sơ là TD=1
		if ("tktiepdan".equals(action))
			sql.append(" and t.loai_hs = 1 ");

		//sql.append(" and t.trang_thai = d.ma");
		sql.append(" and r.ma_hs = t.ma_hs and r.lan_td = 0 and r.loai_cb=" + KntcCanBoRls.KNTC_CB_XU_LY);

		// if (!action.equals("tktiepdan") && !action.equals("tkxuly") &&
		// !action.equals("lichTrinhDKKN") && !action.equals("lichTrinhDKTC"))
		// if(!appContext.isLanhDao())
		// sql.append(" and t.trang_thai = d.ma");
		// sql.append(" AND r.MA_HS = t.MA_HS");
		// sql.append(" AND r.loai_cb = 6");
		// sql.append(" AND r.lan_td = 0");

		// Không tìm các hồ sơ đã xóa
		sql.append(" and (t.loai_ket_thuc != '" + Constants.KNTC_KET_THUC_XOA_HS + "' or t.loai_ket_thuc is null)");

		// Trường hợp thay đổi loại hồ sơ trên form tìm kiếm
		tkForm = changeLoaiHoSo(tkForm, request);
		/**
		 * Lọc thêm các điều kiện trên form
		 */
		JSONObject jsonResult = new JSONObject();
		try {
			conn = DataSourceConfiguration.getConnection();

			if (!Formater.isNull(tkForm.getMaHoSo()))
				sql.append(" And t.ma_hs like '" + tkForm.getMaHoSo() + "'");
			if (!Formater.isNull(tkForm.getLoaiHoSo()) && !tkForm.getLoaiHoSo().equals(TimkiemForm.ALL))
				sql.append(" And t.loai_kntc =" + tkForm.getLoaiHoSo());
			if (!Formater.isNull(tkForm.getTrangThai()) && !tkForm.getTrangThai().equals(TimkiemForm.ALL))
				sql.append(" And t.trang_thai in (" + tkForm.getTrangThai() + ")");
			if(!Formater.isNull(tkForm.getDoanKNTC()))
			{
				System.out.println(tkForm.getDoanKNTC());
				sql.append(" And t.doan_kntc =" + tkForm.getDoanKNTC().toString());
			}
			// if (!Formater.isNull(tkForm.getNguoiNopDon())) {
			// sql.append(" And REGEXP_LIKE (lower(t.nnd_ten),
			// N'*"+convertStringToSearch(tkForm.getNguoiNopDon().trim())+"*')");
			// }
			// if (!Formater.isNull(tkForm.getCanBoXL())) {
			// sql.append(" And REGEXP_LIKE (lower(r.ten_cb),
			// N'*"+convertStringToSearch(tkForm.getCanBoXL().trim())+"*')");
			// }
			// if (!Formater.isNull(tkForm.getNguoiUyQuyen())) {
			// sql.append(" And REGEXP_LIKE (lower(t.nuq_ten),
			// N'*"+convertStringToSearch(tkForm.getNguoiUyQuyen().trim())+"*')");
			// }
			if (!Formater.isNull(tkForm.getNguoiNopDon())) {
				sql.append(" And lower(t.nnd_ten) like '%" + tkForm.getNguoiNopDon().trim().toLowerCase() + "%'");
			}
			if (!Formater.isNull(tkForm.getCanBoXL())) {
				sql.append(" And lower(r.ten_cb) like '%" + tkForm.getCanBoXL().trim().toLowerCase() + "%'");
			}
			if (!Formater.isNull(tkForm.getNguoiUyQuyen())) {
				sql.append(" And lower(t.nuq_ten) like '%" + tkForm.getNguoiUyQuyen().trim().toLowerCase() + "%'");
			}
			if (!Formater.isNull(tkForm.getTextSearch())) {
				String t = tkForm.getTextSearch().toLowerCase();
				sql.append(" And (lower(t.MA_HS) like '%" + t + "%'");
				sql.append(" or lower(t.NND_TEN) like '%" + t + "%'");
				sql.append(" or lower(t.NUQ_TEN) like '%" + t + "%'");
				sql.append(" or lower(t.LUAT_SU_TEN) like '%" + t + "%'");
				sql.append(" or lower(t.CONG_VAN_DEN_MA) like '%" + t + "%'");
				sql.append(" or lower(t.NND_DIA_CHI) like '%" + t + "%'");
				sql.append(" or lower(t.SO_DON) like '%" + t + "%'");
				sql.append(" or lower(t.NGUOI_BI_KNTC_TEN) like '%" + t + "%'");
				sql.append(" or lower(t.NOI_DUNG) like '%" + t + "%'");
				sql.append(" or lower(t.GHI_CHU) like '%" + t + "%'");
				sql.append(" or lower(t.TEN_CAN_BO) like '%" + t + "%')");
			}
			if (!Formater.isNull(tkForm.getTuNgay())) {
				sql.append(" AND (ngay_tiep >= " + "to_date('" + tkForm.getTuNgay() + "','dd/mm/yyyy') or cong_van_den_ngay_vt >= " + "to_date('" + tkForm.getTuNgay() + "','dd/mm/yyyy'))");
			}
			if (!Formater.isNull(tkForm.getDenNgay())) {
				sql.append(" AND (ngay_tiep <= " + "to_date('" + tkForm.getDenNgay() + "','dd/mm/yyyy') or cong_van_den_ngay_vt <= " + "to_date('" + tkForm.getDenNgay() + "','dd/mm/yyyy'))");
			}
			if (!Formater.isNull(tkForm.getCvTuNgay())) {
				sql.append(" AND cong_van_den_ngay >= " + "to_date('" + tkForm.getCvTuNgay() + "','dd/mm/yyyy')");
			}
			if (!Formater.isNull(tkForm.getCvDenNgay())) {
				sql.append(" AND cong_van_den_ngay <= " + "to_date('" + tkForm.getCvDenNgay() + "','dd/mm/yyyy')");
			}
			if (!Formater.isNull(tkForm.getTdTuNgay())) {
				sql.append(" AND ngay_tiep >= " + "to_date('" + tkForm.getTdTuNgay() + "','dd/mm/yyyy')");
			}
			if (!Formater.isNull(tkForm.getTdDenNgay())) {
				sql.append(" AND ngay_tiep <= " + "to_date('" + tkForm.getTdDenNgay() + "','dd/mm/yyyy')");
			}
			if ("1".equals(request.getParameter("trungDon"))) {
				sql.append(" AND loai_ket_thuc ='" + Constants.KNTC_KET_THUC_GOP_DON + "'");
			}
			if ("1".equals(request.getParameter("luuDon"))) {
				sql.append(" AND loai_ket_thuc ='" + Constants.KNTC_KET_THUC_LUU_DON + "'");
			}
			if (request.getParameter("loaiQuanHe") != null && !"-1".equals(request.getParameter("loaiQuanHe"))) {
				sql.append(" AND LOAI_QH = '" + request.getParameter("loaiQuanHe") + "'");
			}
			if (request.getParameter("loaiKetThuc") != null && !"-1".equals(request.getParameter("loaiKetThuc"))) {
				sql.append(" AND LOAI_KET_THUC = '" + request.getParameter("loaiKetThuc") + "'");
			}
			if (request.getParameter("thamQuyen") != null && !"0".equals(request.getParameter("thamQuyen"))) {
				sql.append(" AND dx.tham_quyen = '" + request.getParameter("thamQuyen") + "'");
				sql.append(" AND dx.ma_hs = t.ma_hs");
			}
			if (request.getParameter("thuLy") != null && !"0".equals(request.getParameter("thuLy"))) {
				sql.append(" AND dx.thu_ly = '" + request.getParameter("thuLy") + "'");
				sql.append(" AND dx.ma_hs = t.ma_hs");
			}
			sql.append(" order by t.MA_HS DESC)a where a.r between ? and ? ) dtl");
			System.out.println("SQL Search: " + sql.toString());
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, start);
			ps.setInt(2, start + 9);

			// Tinh count
			StringBuffer sqlCount = new StringBuffer("select count(*) as c ");
			sqlCount.append(sql.substring(sql.lastIndexOf("from"), sql.lastIndexOf(")a where")));
			System.out.println("SQL Count: " + sqlCount);
			PreparedStatement psCount = null;
			ResultSet rsCount = null;
			psCount = conn.prepareStatement(sqlCount.toString());
			rsCount = psCount.executeQuery();
			int sum = 0;
			while (rsCount.next()) {
				sum = rsCount.getInt("c");
			}
			// Xử lý kết quả Create Json
			JSONArray jsonArray = new JSONArray();
			JSONArray ja;
			int i = 0;
			if (sum > 0) {
				rs = ps.executeQuery();
				while (rs.next()) {
					ja = new JSONArray();
					i++;
					// Chọn xử lý chỉ được nhìn thấy mã hồ sơ, không có link để
					// xem nội dung
					if (action.equals("chonXLHS1Lan"))
						ja.put("<b>" + rs.getString("ma_hs") + "</b>");
					else {
						/*if ("1".equals(rs.getString("loai_hs"))) {// TD
							ja.put("<b><a href=\"kntc_tiep_dan.do?method=view&action=" + request.getParameter("action") + "&id=" + rs.getString("ma_hs") + "\">" + rs.getString("ma_hs") + "</a></b>");
						} else {// VT
							ja.put("<b><a href=\"kntc_tiep_dan_van_thu.do?method=view&action=" + request.getParameter("action") + "&id=" + rs.getString("ma_hs") + "\">" + rs.getString("ma_hs")
									+ "</a></b>");
						}*/
						if ("1".equals(rs.getString("loai_hs"))) {
							ja.put("<b>" + rs.getString("ma_hs") + "</b>");
						} else {
							ja.put("<b>" + rs.getString("ma_hs") + "</b>");
						}
					}
					ja.put(rs.getString("ma_hs"));

					ja.put(rs.getString("nnd_ten") + space5);
					// ja.put(rs.getString("nuq_ten"));
					if (rs.getString("nguoibikntc") != null)
						ja.put(rs.getString("nguoibikntc") + space5);
					else
						ja.put(space10 + space10);

					if ("bosungHS".equals(action) || "chuyenHS".equals(action) || "tktiepdan".equals(action) || "suaHSTD".equals(action) || "chonXLHS1Lan".equals(action))
						if (rs.getDate("ngay_tiep") != null)
							ja.put(Formater.date2str(rs.getDate("ngay_tiep")) + space5);
						else
							ja.put(space10);
					else if (rs.getDate("ngaycv") != null)
						ja.put(Formater.date2str(rs.getDate("ngaycv")) + space5);
					else
						ja.put(space10);

					ja.put(CatalogService.getTenCanBoByMa(appContext, rs.getString("ma_canbo")) + space10);

					ja.put(rs.getString("tencqt") + space5);

					if (rs.getString("dvchuyen") != null)
						ja.put(rs.getString("dvchuyen") + space5);
					else
						ja.put(space10 + space10);
					
					ja.put(Constants.getTenTrangThai(rs.getInt("trang_thai")) + space5);
					// ja.put(rs.getString("loai_kntc"));

					if (rs.getString("loai_kntc").equals("1"))
						ja.put("KN" + space5);
					else if (rs.getString("loai_kntc").equals("2"))
						ja.put("TC" + space5);
					else if (rs.getString("loai_kntc").equals("4"))
						ja.put("CS" + space5);
					else if (rs.getString("loai_kntc").equals("3"))
						ja.put("KH" + space5);
					if(rs.getString("doan_kntc_so_luong")!=null)
						ja.put(rs.getString("doan_kntc_so_luong")+space5+space5+space5+"&nbsp;");
					else
						ja.put(space10 + space10);
					jsonArray.put(ja);
				}
			} else {
				ja = new JSONArray();
				for (int j = 0; j < 11; j++) {
					ja.put(space10 + space10 + space10);
				}
				jsonArray.put(ja);
			}
			jsonResult.put("sEcho", tkForm.getMaHoSo());
			jsonResult.put("iTotalRecords", sum);
			jsonResult.put("iTotalDisplayRecords", sum);
			jsonResult.put("aaData", jsonArray);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return jsonResult;
	}

	private TimkiemForm changeLoaiHoSo(TimkiemForm tkForm, HttpServletRequest request) throws Exception {
		// Lấy ra thẩm quyền ban đầu theo loại hồ sơ
		ArrayList listTQ = new ArrayList();
		ArrayList listTL = new ArrayList();
		Collection dmTq = null;
		ArrayList listDmkntc = (ArrayList) request.getAttribute("dmkntc");
		String loaiHoSo = tkForm.getLoaiHoSo() == null ? ((LabelValueBean) listDmkntc.get(0)).getValue() : tkForm.getLoaiHoSo();
		if ("1".equals(loaiHoSo))
			dmTq = CatalogService.getDmByParentId(cmc.com.ktnb.util.Constants.PLXL_DON_KN);
		else if ("2".equals(loaiHoSo))
			dmTq = CatalogService.getDmByParentId(cmc.com.ktnb.util.Constants.PLXL_DON_TC);
		if (dmTq != null) {
			for (Iterator iter = dmTq.iterator(); iter.hasNext();) {
				CategoryVO dmVO = (CategoryVO) iter.next();
				listTQ.add(new LabelValueBean(dmVO.getName(), dmVO.getId()));
			}
		}
		tkForm.setThamQuyenList(listTQ);
		// Lấy ra list trường hợp cụ thể
		if (request.getParameter("thamQuyen") != null) {
			Collection c = CatalogService.getDmByParentId(request.getParameter("thamQuyen"));
			for (Iterator iter = c.iterator(); iter.hasNext();) {
				CategoryVO dmVO = (CategoryVO) iter.next();
				listTL.add(new LabelValueBean(dmVO.getName(), dmVO.getId()));
			}
		}
		tkForm.setThuLyList(listTL);
		return tkForm;
	}

	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TimkiemForm tkForm = (TimkiemForm) form;
		String maHs = request.getParameter("id");
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		StringBuffer urlForward = request.getRequestURL();
		
		if("xoaHSVT".equals(request.getParameter("action")))
			urlForward.append("?method=show&action=tkxuly");
		else 
			urlForward.append("?method=show&action=tktiepdan");
		HttpSession session = request.getSession(false);
		try {
			if (appContext.isLanhDao()) {
				PhanLoaiXuLyService.delete("KNTC_HO_SO_HDR", maHs, appContext);
				//urlForward.append("&xoaThanhcong=1");				
				session.setAttribute("xoaThanhcong", "1");
			} else {
				throw new KtnbException("Ch&#7881; l&#227;nh &#273;&#7841;o c&#417; quan m&#7899;i &#273;&#432;&#7907;c ph&#233;p x&#243;a h&#7891; s&#417;", "",
						"Ch&#7881; l&#227;nh &#273;&#7841;o c&#417; quan m&#7899;i &#273;&#432;&#7907;c ph&#233;p x&#243;a h&#7891; s&#417;");				
			}
		} catch (Exception ex) {
			//urlForward.append("&xoaThanhcong=0");
			session.setAttribute("xoaThanhcong", "0");
			ex.printStackTrace();
		}
		
		response.sendRedirect(urlForward.toString());	
		
		return null;
	}

	private ArrayList addListKntc() {
		ArrayList list = new ArrayList();
		list.add(new LabelValueBean("Khiếu nại", "1"));
		list.add(new LabelValueBean("Tố cáo", "2"));
		list.add(new LabelValueBean("Phản ánh, kiến nghị", "4"));
		list.add(new LabelValueBean("Khác", "3"));
		return list;
	}

	private ArrayList addListKn_tc() {
		ArrayList list = new ArrayList();
		list.add(new LabelValueBean("Khiếu nại", "1"));
		list.add(new LabelValueBean("Tố cáo", "2"));
		return list;
	}

	private ArrayList addListKN() {
		ArrayList list = new ArrayList();
		list.add(new LabelValueBean("Khiếu nại", "1"));
		return list;
	}

	private ArrayList addListTC() {
		ArrayList list = new ArrayList();
		list.add(new LabelValueBean("Tố cáo", "2"));
		return list;
	}

	private ArrayList addListKhac() {
		ArrayList list = new ArrayList();
		list.add(new LabelValueBean("Khác", "3"));
		return list;
	}

	private String convertStringToSearch(String str) {
		char[] cArray = str.toLowerCase().toCharArray();
		StringBuffer strRet = new StringBuffer();
		for (int i = 0; i < cArray.length; i++) {
			switch (cArray[i]) {
			case 'a':
				strRet.append("(ă|â|à|ả|ã|ạ|á|ằ|ẳ|ẵ|ặ|ắ|ầ|ẩ|ẫ|ậ|ấ)");
				break;
			case 'e':
				strRet.append("(ê|è|ẻ|ẽ|ẹ|é|ề|ể|ễ|ệ|ế)");
				break;
			case 'u':
				strRet.append("(ư|ù|ủ|ũ|ụ|ú|ừ|ử|ữ|ự|ứ)");
				break;
			case 'i':
				strRet.append("(ì|ỉ|ĩ|ị|í)");
				break;
			case 'y':
				strRet.append("(ỳ|ỷ|ỹ|ỵ|ý)");
				break;
			case 'o':
				strRet.append("(ô|ơ|ò|ỏ|õ|ọ|ó|ồ|ổ|ỗ|ộ|ố|ờ|ở|ỡ|ợ|ớ)");
				break;
			default:
				strRet.append(cArray[i]);
				break;
			}
		}
		System.out.println("Convert Out: " + strRet.toString());
		return strRet.toString();
	}
}