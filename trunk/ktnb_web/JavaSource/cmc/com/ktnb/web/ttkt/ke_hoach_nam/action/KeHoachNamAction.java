/*
 * Created on Nov 1, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.ke_hoach_nam.action;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JExcelApiExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;
import org.hibernate.Query;
import org.hibernate.Session;

import cmc.com.ktnb.entity.TTKT.dung_chung.KtnbKhTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhChiTietNoiDungTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhNoiDungTtkt;
import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.HtmlTable;
import cmc.com.ktnb.util.KtnbCache;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.QueryDetails;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.ke_hoach_nam.form.KeHoachNamForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktService;

/**
 * @author ntdung1
 * 
 */
public class KeHoachNamAction extends BaseDispatchAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception, Exception {
		KeHoachNamForm keHoachNamForm = (KeHoachNamForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String strMethod = request.getParameter("method");
		if ("delete".equals(strMethod)) {
			try {
				CuocTtktService.deleteCuocTtkt(appContext, keHoachNamForm.getCuocTtktFocus());
			} catch (Exception err) {
				if (Constants.MSG_KHG_XOA.equals(err.getMessage()))
					request.setAttribute("Action status", err.getMessage());
			}

		} else if ("xemChiTiet".equals(strMethod)) {
			String cuocTtktId = keHoachNamForm.getCuocTtktFocus();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtkt(appContext, cuocTtktId);

			if (Formater.isNull(cuocTtkt.getDsTtktCqtTrucThuoc())) { // Chi
				// co
				// noi
				// dung
				keHoachNamForm.setDsTtktCqtTrucThuoc(null);
				Collection listNoiDungTTKT = cuocTtkt.getDsNoiDungTTKT();
				TtktKhNoiDungTtkt[] arrNoiDungTtkt = new TtktKhNoiDungTtkt[listNoiDungTTKT.size()];
				int index = 0;
				for (int i = 0; i < listNoiDungTTKT.size(); i++) {
					arrNoiDungTtkt[index] = (TtktKhNoiDungTtkt) ((ArrayList) listNoiDungTTKT).get(i);
					arrNoiDungTtkt[index].setNienDoDenNgayStr(Formater.date2str(arrNoiDungTtkt[index].getNienDoDenNgay()));
					arrNoiDungTtkt[index].setNienDoTuNgayStr(Formater.date2str(arrNoiDungTtkt[index].getNienDoTuNgay()));
					// Chi tiet noi dung
					String chiTiet = getChiTietNoiDung(arrNoiDungTtkt[index]);
					if (!Formater.isNull(chiTiet))
						arrNoiDungTtkt[index].setChiTietNoiDung(chiTiet);
				}
				keHoachNamForm.setDsNoiDungTtkt(arrNoiDungTtkt);

			} else {
				ArrayList temp = new ArrayList(); // Danh sach Ttkt cqt truc
				// thuoc de view
				Collection listTtktCqtTrucThuoc = cuocTtkt.getDsTtktCqtTrucThuoc();
				for (int i = 0; i < listTtktCqtTrucThuoc.size(); i++) {
					TtktKhCuocTtkt ttktCqtTrucThuoc = (TtktKhCuocTtkt) ((ArrayList) listTtktCqtTrucThuoc).get(i);
					ArrayList listNoiDungTtkt = (ArrayList) ttktCqtTrucThuoc.getDsNoiDungTTKT();
					for (int j = 0; j < listNoiDungTtkt.size(); j++) {
						TtktKhNoiDungTtkt noiDung = (TtktKhNoiDungTtkt) listNoiDungTtkt.get(j);
						noiDung.setIdDonViBi(ttktCqtTrucThuoc.getIdDonViBi());
						noiDung.setTenDonViBi(ttktCqtTrucThuoc.getTenDonViBi());
						temp.add(noiDung);
					}
				}
				keHoachNamForm.setArrNoiDungTtktCqtTrucThuoc(convertFromArrayList(temp));
			}
			request.setAttribute("dmNoiDungTtktGoc", KtnbCache.getInstance().get("DM_NDGOC"));
			request.setAttribute("dmCqtTrucThuoc", KtnbUtil.getCqtTrucThuoc(appContext, request, cuocTtkt.getIdDonViBi()));

		} else if ("in".equals(strMethod)) {
			try {
				if(CuocTtktService.getKhNam(appContext, appContext.getMaCqt(), keHoachNamForm.getNamKeHoach()).size() <=0){
					KtnbUtil.showBussinessExceiption(request, reponse, "Ch\u01B0a c\u00F3 cu\u1ED9c Ki\u1EC3m tra n\u00E0o trong k\u1EBF ho\u1EA1ch!");
					return null;
				} 
				inKeHoachNam(appContext, request, reponse, keHoachNamForm);
				return null;
			} catch (Exception ex) {
				ex.printStackTrace();
				throw ex;
			}
		} else {
			String uri = request.getRequestURI();
			String URI = uri.substring(uri.lastIndexOf("/") + 1);
			if ("ttkt_dot_xuat.do".equals(URI)) {
				keHoachNamForm.setLoai("1");
			} else {
				keHoachNamForm.setLoai("0");
			}
			String nam = request.getParameter("nam");
			if (Formater.isNull(nam)) {
				if (Formater.isNull(keHoachNamForm.getNamKeHoach()))
					keHoachNamForm.setNamKeHoach(String.valueOf(new Date().getYear() + 1900));
			} else {
				keHoachNamForm.setNamKeHoach(nam);
			}
		}
		// Combo ke hoach nam
		int iNam = new Date().getYear() + 1900;
		Collection lisOfNam = new ArrayList();
		for (int i = 0; i < 10; i++) {
			lisOfNam.add(new LabelValueBean(String.valueOf(iNam + 1 - i), String.valueOf(iNam + 1 - i)));
		}
		request.setAttribute("lisOfNam", lisOfNam);
		search(appContext, keHoachNamForm, request);
		String uri = request.getRequestURI();
		String URI = uri.substring(uri.lastIndexOf("/") + 1);
		if ("ttkt_dot_xuat.do".equals(URI)) {
			//request.setAttribute("header", "Thanh tra Ki\u1EC3m tra \u0111\u1ED9t xu\u1EA5t n\u0103m");
			request.setAttribute("header", "Ki\u1EC3m tra \u0111\u1ED9t xu\u1EA5t n\u0103m");
			request.setAttribute("isDotXuat", "true");
		} else {
			//request.setAttribute("header", "K\u1EBF ho\u1EA1ch Thanh tra Ki\u1EC3m tra n\u0103m");
			request.setAttribute("header", "K\u1EBF ho\u1EA1ch Ki\u1EC3m tra n\u0103m");
			if (TtktService.isDuyetKhNam(appContext, appContext.getMaCqt(), keHoachNamForm.getNamKeHoach())) {
				request.setAttribute("duyet", "true");
			}
		}
		return mapping.findForward("view");
	}

	/**
	 * @param request
	 * @param reponse
	 * @param keHoachNamForm
	 */
	private void inKeHoachNam(ApplicationContext appContext, HttpServletRequest request, HttpServletResponse response, KeHoachNamForm keHoachNamForm) throws Exception {
		Connection conn = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			Map parameters = new HashMap();
			String fileTemplate = "TTNB_01_F";
			if (keHoachNamForm.getLoai().equals("1")) { // Dot xuat
				fileTemplate = "ttnb01b";
			}
			parameters.put("SUBREPORT_DIR", this.getServlet().getServletContext().getRealPath("/report/"));
			parameters.put("ten_cqt", KtnbUtil.getTenCqtCapTrenTt(appContext));
			parameters.put("dv_thuc_hien_ttkt", appContext.getTenCqt());
			parameters.put("thu_truong_cqt", KtnbUtil.getTenThuTruongCqt(appContext));
			parameters.put("p_date", "'%" + keHoachNamForm.getNamKeHoach() + "%'");
			parameters.put("p_date", keHoachNamForm.getNamKeHoach());
			parameters.put("namHienThi", keHoachNamForm.getNamKeHoach());
			parameters.put("id_don_vi_th", appContext.getMaCqt());
			//String cqtCon = " ma_cqt = '" + appContext.getMaCqt() + "'";
			parameters.put("p_ma_cqt", appContext.getMaCqt());
			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
			// long start = System.currentTimeMillis();
			// String format = "xls";
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
			jasperReport.setWhenNoDataType(JasperReport.WHEN_NO_DATA_TYPE_ALL_SECTIONS_NO_DETAIL);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
			response.reset();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileTemplate + Formater.date2str4File(new Date()) + ".xls");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JExcelApiExporter exporter = new JExcelApiExporter();
			exporter.setParameter(JExcelApiExporterParameter.CHARACTER_ENCODING, "UTF-8");
			exporter.setParameter(JExcelApiExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JExcelApiExporterParameter.OUTPUT_STREAM, baos);
			exporter.setParameter(JExcelApiExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			exporter.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporter.setParameter(JExcelApiExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			exporter.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporter.exportReport();
			ServletOutputStream oStream = response.getOutputStream();
			oStream.write(baos.toByteArray());
			oStream.flush();
			oStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(conn);
		}
	}
	/**
	 * @param temp
	 * @return
	 */
	private TtktKhNoiDungTtkt[] convertFromArrayList(ArrayList temp) {
		if (Formater.isNull(temp))
			return null;
		TtktKhNoiDungTtkt[] arrReturn = new TtktKhNoiDungTtkt[temp.size()];
		int index = 0;
		Iterator iter = temp.iterator();
		while (iter.hasNext()) {
			arrReturn[index] = (TtktKhNoiDungTtkt) iter.next();
			index++;
		}
		return arrReturn;
	}

	/**
	 * 
	 */
	private void search(ApplicationContext appContext, KeHoachNamForm keHoachNamForm, HttpServletRequest request) throws Exception, Exception {
		StringBuffer sql = new StringBuffer("select * from Ttkt_Kh_Cuoc_Ttkt t where 1=1 ");
		String uri = request.getRequestURI();
		String URI = uri.substring(uri.lastIndexOf("/") + 1);
		if ("ttkt_dot_xuat.do".equals(URI))
			sql.append(" and LOAI = 1");
		else {
			sql.append(" and LOAI = 0");
			// sql.append(" and Loai_Cuoc_Ttkt_KHN in('" +
			// Constants.TTKT_LOAI_KHN_KH + "','" + Constants.TTKT_LOAI_KHN_DEL
			// + "','" + Constants.TTKT_LOAI_KHN_EDIT + "')");
			// Thay doi - version moi nhat len tren
			sql.append(" and Loai_Cuoc_Ttkt_KHN in('" + Constants.TTKT_LOAI_KHN_KH + "','" + Constants.TTKT_LOAI_KHN_ADD + "','" + Constants.TTKT_LOAI_KHN_ADD_BY_EDIT + "')");
		}
		sql.append(" and Ma like '%" + keHoachNamForm.getNamKeHoach().trim() + "%'");
		sql.append("and " + buildConditionFromForm(appContext, keHoachNamForm));
		//Bo sung lua chon sap xep
		String sapXep = keHoachNamForm.getSapXep();
		if (!Formater.isNull(sapXep)) {
			if("TangThoiGian".equals(sapXep)){
				sql.append(" ORDER BY thoi_gian_du_kien_tu_ngay ASC");
			}else if("TangThuTu".equals(sapXep)){
				sql.append(" ORDER BY ma ASC");
			} else if("GiamThoiGian".equals(sapXep)){
				sql.append(" ORDER BY thoi_gian_du_kien_tu_ngay DESC");
			}else if("GiamThuTu".equals(sapXep)){
				sql.append(" ORDER BY ma DESC");
			}
		} else {
			sql.append(" ORDER BY substr(ma,length(ma)-2,3)");
		}
		Session session = HibernateSessionFactory.currentSession();
		if (session != null) {
			QueryDetails queryDetails = new QueryDetails();
			try {
				session.beginTransaction();
				queryDetails.setPageSize(Constants.PAGE_SIZE_DEFAULT);
				String sPageNumber = request.getParameter("pageNumber");
				try {
					queryDetails.setPageNumber(new Integer(sPageNumber));
					request.setAttribute("pnumber", sPageNumber);
				} catch (Exception e) {
					queryDetails.setPageNumber(new Integer("1"));
					request.setAttribute("pnumber", new Integer("1"));
				}
				// request.setAttribute("sql", sql.toString());
				System.out.println("SQL Searching: " + sql.toString());
				Query q = session.createSQLQuery(sql.toString()).addEntity(TtktKhCuocTtkt.class);
				int beginIndx = queryDetails.getBeginIndex();
				int lastIndx = queryDetails.getLastIndex();
				q.setFirstResult(beginIndx);
				q.setMaxResults(lastIndx);
				Collection listCuocTtkt = q.list();
				if (!Formater.isNull(listCuocTtkt)) {
					Iterator iter = listCuocTtkt.iterator();
					while (iter.hasNext()) {
						TtktKhCuocTtkt cuocTtkt = (TtktKhCuocTtkt) iter.next();
						cuocTtkt.setNienDoDenNgayStr(Formater.date2str(cuocTtkt.getNienDoDenNgay()));
						cuocTtkt.setNienDoTuNgayStr(Formater.date2str(cuocTtkt.getNienDoTuNgay()));
						cuocTtkt.setThoiGianDuKienDenNgayStr(Formater.date2str(cuocTtkt.getThoiGianDuKienDenNgay()));
						cuocTtkt.setThoiGianDuKienTuNgayStr(Formater.date2str(cuocTtkt.getThoiGianDuKienTuNgay()));
						if(KtnbUtil.isChiCuc(cuocTtkt.getIdDonViTh())){
							String dvPhuthuoc = CuocTtktService.searchDvPhuthuoc(cuocTtkt.getId());
							if(dvPhuthuoc != null)
								cuocTtkt.setTenDonViBi(dvPhuthuoc);
						}
					}
				}
				// HtmlTable
				HtmlTable table = new HtmlTable();
				table.setPageNumber(sPageNumber);
				table.setPageSize(Constants.PAGE_SIZE_DEFAULT.longValue());
				table.setData(listCuocTtkt);
				table.setSearchForm("KeHoachNamForm");
				request.setAttribute("dscttkt", table);
			} catch (Exception e) {
				e.printStackTrace();
				HibernateSessionFactory.closeSessionQuiet();
				throw new KtnbException(e);
			} finally {
				HibernateSessionFactory.closeSessionQuiet();
			}
		}
	}

	/**
	 * @param noiDung
	 * @return
	 */
	private String getChiTietNoiDung(TtktKhNoiDungTtkt noiDung) {
		String chiTiet = "";
		Collection dsChiTiet = (Collection) noiDung.getDsChiTietNoiDung();
		if (Formater.isNull(dsChiTiet))
			return "";
		Iterator iter = dsChiTiet.iterator();
		while (iter.hasNext())
			chiTiet += ((TtktKhChiTietNoiDungTtkt) iter.next()).getIdNoiDungChiTiet() + ",";
		if (!Formater.isNull(chiTiet))
			chiTiet = chiTiet.substring(0, chiTiet.length() - 2);
		return chiTiet;
	}

	private String buildConditionFromForm(ApplicationContext appContext, KeHoachNamForm keHoachNamForm) {
		StringBuffer sb = new StringBuffer();
		// SearchCriteria criteria = new SearchCriteria(TtktKhCuocTtkt.class);
		sb.append("id_Don_Vi_Th = " + appContext.getMaCqt());
		// criteria.addSearchItem(TtktKhCuocTtkt.IdDonViTh,
		// appContext.getMaCqt());
		sb.append(" and id_cuoc_ttkt_cha is null");
		// criteria.addSearchItem(TtktKhCuocTtkt.IdCuocTtktCha, null,
		// SearchCriteria.LG_IS_NULL);
		// Khong phai la cuoc Ttkt con

		if (!Formater.isNull(keHoachNamForm.getMa_cuoc_ttkt())) {
			sb.append(" and upper(ma) like upper('%" + keHoachNamForm.getMa_cuoc_ttkt().trim() + "%')");
			// criteria.addSearchItem(TtktKhCuocTtkt.Ma, "%" +
			// keHoachNamForm.getMa_cuoc_ttkt().trim() + "%",
			// SearchCriteria.OP_LIKE);
		}

		if (!Formater.isNull(keHoachNamForm.getDon_vi_duoc_ttkt())) {
			sb.append(" and upper(ten_don_vi_bi) like upper('%" + keHoachNamForm.getDon_vi_duoc_ttkt().trim() + "%')");
			// criteria.addSearchItem(TtktKhCuocTtkt.TenDonViBi, "%" +
			// keHoachNamForm.getDon_vi_duoc_ttkt().trim() + "%",
			// SearchCriteria.OP_LIKE);

		}

		if (!Formater.isNull(keHoachNamForm.getTu_ngay())) {
			sb.append(" and nien_do_tu_ngay >= " + "to_date('" + keHoachNamForm.getTu_ngay() + "','dd/mm/yyyy')");
			// criteria.addSearchItem(TtktKhCuocTtkt.NienDoTuNgay,
			// Formater.str2date(keHoachNamForm.getTu_ngay()),
			// SearchCriteria.OP_GE);
		}

		if (!Formater.isNull(keHoachNamForm.getDen_ngay())) {
			sb.append(" and nien_do_den_ngay <= " + "to_date('" + keHoachNamForm.getDen_ngay() + "','dd/mm/yyyy')");
			// criteria.addSearchItem(TtktKhCuocTtkt.NienDoDenNgay,
			// Formater.str2date(keHoachNamForm.getDen_ngay()),
			// SearchCriteria.OP_LE);
		}

		// Thoi gian du kien
		if (!Formater.isNull(keHoachNamForm.getThoiGianDuKienTuNgay())) {
			sb.append(" and thoi_gian_du_kien_tu_ngay >= " + "to_date('" + keHoachNamForm.getThoiGianDuKienTuNgay() + "','dd/mm/yyyy')");
			// criteria.addSearchItem(TtktKhCuocTtkt.ThoiGianDuKienTuNgay,
			// Formater.str2date(keHoachNamForm.getThoiGianDuKienTuNgay()),
			// SearchCriteria.OP_GE);

		}

		if (!Formater.isNull(keHoachNamForm.getThoiGianDuKienDenNgay())) {
			sb.append(" and thoi_gian_du_kien_den_ngay <= " + "to_date('" + keHoachNamForm.getThoiGianDuKienDenNgay() + "','dd/mm/yyyy')");
			// criteria.addSearchItem(TtktKhCuocTtkt.ThoiGianDuKienDenNgay,
			// Formater.str2date(keHoachNamForm.getThoiGianDuKienDenNgay()),
			// SearchCriteria.OP_LE);
		}

		// TODO: Chua test search theo thoi gian du kien
		if (!Formater.isNull(keHoachNamForm.getThoiGianDuKien())) {
			sb.append(" and thoi_gian_du_kien = " + keHoachNamForm.getThoiGianDuKien());
			// criteria.addSearchItem(TtktKhCuocTtkt.ThoiGianDuKien,
			// Byte.valueOf(keHoachNamForm.getThoiGianDuKien()));
		}
		if (!Formater.isNull(keHoachNamForm.getHinh_thuc())) {
			if (!"all".equals(keHoachNamForm.getHinh_thuc()))
				sb.append(" and hinh_thuc = " + keHoachNamForm.getHinh_thuc());

		}

		// Hinh thuc: Thanh tra, kiem tra
		// if ("0".equals(keHoachNamForm.getHinh_thuc()))
		// criteria.addSearchItem(TtktKhCuocTtkt.HinhThuc, Boolean.FALSE);
		// else if ("1".equals(keHoachNamForm.getHinh_thuc()))
		// criteria.addSearchItem(TtktKhCuocTtkt.HinhThuc, Boolean.TRUE);

		return sb.toString();
	}

	/**
	 * @param keHoachNamForm
	 * @return
	 */
	private SearchCriteria createCriteriaFromForm(ApplicationContext appContext, KeHoachNamForm keHoachNamForm) throws Exception, Exception {
		SearchCriteria criteria = new SearchCriteria(TtktKhCuocTtkt.class);

		criteria.addSearchItem(TtktKhCuocTtkt.IdDonViTh, appContext.getMaCqt());
		criteria.addSearchItem(TtktKhCuocTtkt.IdCuocTtktCha, null, SearchCriteria.LG_IS_NULL);
		// Khong phai la cuoc Ttkt con

		if (!Formater.isNull(keHoachNamForm.getMa_cuoc_ttkt()))
			criteria.addSearchItem(TtktKhCuocTtkt.Ma, "%" + keHoachNamForm.getMa_cuoc_ttkt().trim() + "%", SearchCriteria.OP_LIKE);
		if (!Formater.isNull(keHoachNamForm.getDon_vi_duoc_ttkt()))
			criteria.addSearchItem(TtktKhCuocTtkt.TenDonViBi, "%" + keHoachNamForm.getDon_vi_duoc_ttkt().trim() + "%", SearchCriteria.OP_LIKE);

		if (!Formater.isNull(keHoachNamForm.getTu_ngay()))
			criteria.addSearchItem(TtktKhCuocTtkt.NienDoTuNgay, Formater.str2date(keHoachNamForm.getTu_ngay()), SearchCriteria.OP_GE);

		if (!Formater.isNull(keHoachNamForm.getDen_ngay()))
			criteria.addSearchItem(TtktKhCuocTtkt.NienDoDenNgay, Formater.str2date(keHoachNamForm.getDen_ngay()), SearchCriteria.OP_LE);

		// Thoi gian du kien
		if (!Formater.isNull(keHoachNamForm.getThoiGianDuKienTuNgay()))
			criteria.addSearchItem(TtktKhCuocTtkt.ThoiGianDuKienTuNgay, Formater.str2date(keHoachNamForm.getThoiGianDuKienTuNgay()), SearchCriteria.OP_GE);

		if (!Formater.isNull(keHoachNamForm.getThoiGianDuKienDenNgay()))
			criteria.addSearchItem(TtktKhCuocTtkt.ThoiGianDuKienDenNgay, Formater.str2date(keHoachNamForm.getThoiGianDuKienDenNgay()), SearchCriteria.OP_LE);

		// TODO: Chua test search theo thoi gian du kien
		if (!Formater.isNull(keHoachNamForm.getThoiGianDuKien()))
			criteria.addSearchItem(TtktKhCuocTtkt.ThoiGianDuKien, Byte.valueOf(keHoachNamForm.getThoiGianDuKien()));

		// Hinh thuc: Thanh tra, kiem tra
		if ("0".equals(keHoachNamForm.getHinh_thuc()))
			criteria.addSearchItem(TtktKhCuocTtkt.HinhThuc, Boolean.FALSE);
		else if ("1".equals(keHoachNamForm.getHinh_thuc()))
			criteria.addSearchItem(TtktKhCuocTtkt.HinhThuc, Boolean.TRUE);

		return criteria;
	}

	/**
	 * @param mapping
	 * @param keHoachNamForm
	 * @param request
	 * @param reponse
	 * @return
	 */
	private void delete(ActionMapping mapping, KeHoachNamForm keHoachNamForm, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		Connection conn = null;
		Statement statement = null;
		try {

			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			// String strCondition =
			// keHoachNamForm.getSelectedItems().replaceAll(",", "','");
			String strCondition = "fdf";
			statement.addBatch("delete ktnb_kh_ttkt where id in " + "('" + strCondition + "')");
			statement.addBatch("delete ktnb_kh_ttkt_nd where ID_KH_TTKT in" + "('" + strCondition + "')");
			statement.executeBatch();
			conn.commit();

		} catch (Exception e) {

		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}
	}

	/**
	 * @param appContext
	 * @param request
	 * @param string
	 * @return
	 */
	private Collection getKeHoachNam(ApplicationContext appContext, HttpServletRequest request, String strMaCqt) throws Exception {
		SearchCriteria criteria = new SearchCriteria(KtnbKhTtkt.class);
		criteria.addSearchItem("idDonViTh", strMaCqt);
		return new BaseHibernateDAO().retrieveObjects(appContext, criteria);
	}
}
