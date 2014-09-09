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
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.TTKT.dung_chung.KtnbKhTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhChiTietNoiDungTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhNoiDungTtkt;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HtmlTable;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.QueryDetails;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.ke_hoach_nam.form.SuaKeHoachNamForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktService;

/**
 * @author ntdung1
 */
public class SuaKeHoachNamAction extends BaseDispatchAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception, Exception {

		SuaKeHoachNamForm keHoachNamForm = (SuaKeHoachNamForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);

		String strMethod = request.getParameter("method");
		if ("delete".equals(strMethod)) {
			try {
				TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtkt(appContext, keHoachNamForm.getCuocTtktFocus());
				//Neu da co quyet dinh => phai lap bien ban huy, khong duoc dieu chinh giam
				if (TtktService.getIndexOfTrangThai(cuocTtkt.getTrangThai()) >= TtktService.getIndexOfTrangThai(Constants.TT_TTKT_QD))
					throw new Exception(Constants.MSG_KHG_XOA);
				
				if (cuocTtkt.getLoaiCuocTtktKeHoachNam().equals(Constants.TTKT_LOAI_KHN_ADD)) {
					CuocTtktService.deleteCuocTtkt(appContext, keHoachNamForm.getCuocTtktFocus());
				} 
				else if (cuocTtkt.getLoaiCuocTtktKeHoachNam().equals(Constants.TTKT_LOAI_KHN_ADD_BY_EDIT)) {
					// Xoa cuoc ttkt					
					CuocTtktService.deleteCuocTtkt(appContext, keHoachNamForm.getCuocTtktFocus());
					// Cap nhat lai cuoc ttkt goc trong ke hoach
					TtktKhCuocTtkt cuocTtktGoc = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, cuocTtkt.getIdCuocKhCu());
					cuocTtktGoc.setTrangThai(Constants.TT_TTKT_CREATE);
					cuocTtktGoc.setLoaiCuocTtktKeHoachNam(Constants.TTKT_LOAI_KHN_KH);
					new BaseHibernateDAO().updateObject(appContext, cuocTtktGoc);
				} 
				else if (cuocTtkt.getLoaiCuocTtktKeHoachNam().equals(Constants.TTKT_LOAI_KHN_DEL)) {
					cuocTtkt.setTrangThai(Constants.TT_TTKT_CREATE);
					cuocTtkt.setLoaiCuocTtktKeHoachNam(Constants.TTKT_LOAI_KHN_KH);
					new BaseHibernateDAO().updateObject(appContext, cuocTtkt);
				} 
				else if (cuocTtkt.getLoaiCuocTtktKeHoachNam().equals(Constants.TTKT_LOAI_KHN_EDIT)) {
					request.setAttribute("Action error", "Cu\u1ED9c Thanh tra Ki\u1EC3m tra n\u00E0y \u0111\u00E3 \u0111\u01B0\u1EE3c ch\u1EC9nh s\u1EEDa, kh\u00F4ng th\u1EC3 x\u00F3a!");
				} 
				else if (cuocTtkt.getLoaiCuocTtktKeHoachNam().equals(Constants.TTKT_LOAI_KHN_KH)) {
					CuocTtktService.chinhSuaXoaCuocTtkt(appContext, keHoachNamForm.getCuocTtktFocus());
				}
				cuocTtkt.setLoaiCuocTtktKeHoachNam(Constants.TTKT_LOAI_KHN_DEL);
				cuocTtkt.setTrangThai(Constants.TT_TTKT_HET_HL);
				new BaseHibernateDAO().updateObject(appContext, cuocTtkt);
			} catch (Exception err) {
				if (Constants.MSG_KHG_XOA.equals(err.getMessage()))
					request.setAttribute("Action status", err.getMessage());
			}

		} else if ("in".equals(strMethod)) {
			try {
				inKeHoachNam(appContext, request, reponse, keHoachNamForm);
				return null;
			} catch (Exception ex) {
				ex.printStackTrace();
				throw ex;
			}

		} else {
			if (Formater.isNull(keHoachNamForm.getNamKeHoach())) {
				String nam = request.getParameter("nam");
				keHoachNamForm.setNamKeHoach(nam);				
			}

			if (!TtktService.isDuyetKhNam(appContext, appContext.getMaCqt(), keHoachNamForm.getNamKeHoach()))
				reponse.sendRedirect("ke_hoach_nam.do?nam=" + keHoachNamForm.getNamKeHoach());
		}
		this.search(appContext, keHoachNamForm, request);
		request.setAttribute("header", "Ch\u1EC9nh s\u1EEDa k\u1EBF ho\u1EA1ch n\u0103m");
		return mapping.findForward("view");
	}

	/**
	 * @param request
	 * @param reponse
	 * @param keHoachNamForm
	 */
	private void inKeHoachNam(ApplicationContext appContext, HttpServletRequest request, HttpServletResponse response, SuaKeHoachNamForm keHoachNamForm) throws Exception {
		Connection conn = null;
		try {
			conn = DataSourceConfiguration.getConnection();

			HashMap[] reportRows = null;
			Map parameters = new HashMap();
			String fileTemplate = "ttnb01";
			parameters.put("ten_cqt", KtnbUtil.getTenCqtCapTrenTt(appContext));
			parameters.put("dv_thuc_hien_ttkt", appContext.getTenCqt());
			parameters.put("thu_truong_cqt", KtnbUtil.getTenThuTruongCqt(appContext));
			parameters.put("nam", String.valueOf((new Date().getYear() + 1900)));
			parameters.put("id_don_vi_th", appContext.getMaCqt());
			String cqtCon = " ma_cqt = '" + appContext.getMaCqt() + "'";
			parameters.put("p_ma_cqt", cqtCon);
			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
			long start = System.currentTimeMillis();
			String format = "XLS";
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
			jasperReport.setWhenNoDataType(JasperReport.WHEN_NO_DATA_TYPE_ALL_SECTIONS_NO_DETAIL);
			JasperPrint jasperPrint;
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
			response.reset();
			ServletOutputStream oStream = response.getOutputStream();
			response.addHeader("Content-Disposition", "attachment;filename=" + fileTemplate + Formater.date2str4File(new Date()) + "." + format);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			response.setContentType("application/xls");
			JRXlsExporter exporter = new JRXlsExporter();
			exporter.setParameter(JRXlsExporterParameter.CHARACTER_ENCODING, "UTF-8");
			exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
			exporter.exportReport();
			oStream.write(baos.toByteArray());
			oStream.flush();
			oStream.close();
			System.out.println("Report time=" + (System.currentTimeMillis() - start));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(conn);
		}

	}

	/**
	 * @param noiDungTtkt
	 * @param sttLevel3
	 * @return
	 */
	private HashMap pushCuocTtkt(TtktKhNoiDungTtkt noiDungTtkt, String sttLevel3) {
		HashMap row = new HashMap();
		try {

			row.put("stt", sttLevel3);
			row.put("dv_dc_ttkt", noiDungTtkt.getTenDonViBi());
			row.put("thoi_ky", Formater.date2str(noiDungTtkt.getNienDoTuNgay()) + "-" + Formater.date2str(noiDungTtkt.getNienDoDenNgay()));
			//row.put("dv_thuc_hien_ttkt", noiDungTtkt.getTenDonViTh());
			row.put("thoi_gian_ttkt", Formater.date2str(noiDungTtkt.getThoiGianDuKienTuNgay()) + "-" + Formater.date2str(noiDungTtkt.getThoiGianDuKienDenNgay()));
			Boolean ghiChu = noiDungTtkt.getHinhThuc();
			if (ghiChu.booleanValue())
				row.put("ghi_chu", "Thanh tra");
			else
				row.put("ghi_chu", "Ki\u1EC3m tra");

		} catch (Exception err) {
		}
		return row;

	}

	/**
	 * @param cuocTtkt
	 * @return
	 */
	private HashMap pushCuocTtkt(TtktKhCuocTtkt cuocTtkt, String index) {
		HashMap row = new HashMap();
		try {

			row.put("stt", index);
			row.put("dv_dc_ttkt", cuocTtkt.getTenDonViBi());
			row.put("thoi_ky", Formater.date2str(cuocTtkt.getNienDoTuNgay()) + "-" + Formater.date2str(cuocTtkt.getNienDoDenNgay()));
			row.put("dv_thuc_hien_ttkt", cuocTtkt.getTenDonViTh());
			row.put("thoi_gian_ttkt", Formater.date2str(cuocTtkt.getThoiGianDuKienTuNgay()) + "-" + Formater.date2str(cuocTtkt.getThoiGianDuKienDenNgay()));
			Boolean ghiChu = cuocTtkt.getHinhThuc();
			if (ghiChu.booleanValue())
				row.put("ghi_chu", "Thanh tra");
			else
				row.put("ghi_chu", "Ki\u1EC3m tra");

		} catch (Exception err) {
		}
		return row;
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
	private void search(ApplicationContext appContext, SuaKeHoachNamForm keHoachNamForm, HttpServletRequest request) throws Exception, Exception {
		SearchCriteria criteria = createCriteriaFromForm(appContext, keHoachNamForm);
		criteria.addSearchItem(TtktKhCuocTtkt.Loai, Boolean.FALSE);
		criteria.addSearchItem(TtktKhCuocTtkt.Ma, "%" + keHoachNamForm.getNamKeHoach().trim() + "%", SearchCriteria.OP_LIKE);
		criteria.addSearchItem(TtktKhCuocTtkt.LoaiCuocTtktKeHoachNam,Constants.TTKT_LOAI_KHN_CHANGE_IN_QD, SearchCriteria.OP_NE);
		// Loai cuoc ttkt sua ke hoach
		String loaiCuocTtkt = keHoachNamForm.getLoaiCuocTtktSuaKH();
		Collection dsTrangThai = new ArrayList();
		if ("tat_ca".equals(loaiCuocTtkt)) {
		} else if ("ke_hoach_nam".equals(loaiCuocTtkt)) {
			// Nhung cuoc khong thay doi
			dsTrangThai.add(Constants.TTKT_LOAI_KHN_KH);
			// Nhung cuoc bi xoa
			dsTrangThai.add(Constants.TTKT_LOAI_KHN_DEL);
			// Nhung cuoc bi sua
			dsTrangThai.add(Constants.TTKT_LOAI_KHN_EDIT);

			criteria.addSearchItem(TtktKhCuocTtkt.LoaiCuocTtktKeHoachNam, dsTrangThai, SearchCriteria.OP_IN);

		} else if ("ke_hoach_chinh_sua".equals(loaiCuocTtkt)) {
			// Nhung cuoc khong thay doi
			dsTrangThai.add(Constants.TTKT_LOAI_KHN_KH);
			// Nhung cuoc bo sung
			dsTrangThai.add(Constants.TTKT_LOAI_KHN_ADD);
			// Nhung cuoc bo sung do them moi
			dsTrangThai.add(Constants.TTKT_LOAI_KHN_ADD_BY_EDIT);
			criteria.addSearchItem(TtktKhCuocTtkt.LoaiCuocTtktKeHoachNam, dsTrangThai, SearchCriteria.OP_IN);

		} else if ("bo_sung".equals(loaiCuocTtkt)) {
			criteria.addSearchItem(TtktKhCuocTtkt.LoaiCuocTtktKeHoachNam, Constants.TTKT_LOAI_KHN_ADD);
		} else if ("sua".equals(loaiCuocTtkt)) {
			criteria.addSearchItem(TtktKhCuocTtkt.LoaiCuocTtktKeHoachNam, Constants.TTKT_LOAI_KHN_ADD_BY_EDIT);
		} else if ("xoa".equals(loaiCuocTtkt)) {
			criteria.addSearchItem(TtktKhCuocTtkt.LoaiCuocTtktKeHoachNam, Constants.TTKT_SUA_DEL);
		}

		// queryDetails
		QueryDetails queryDetails = new QueryDetails();
		queryDetails.setPageSize(Constants.PAGE_SIZE_DEFAULT);
		String sPageNumber = request.getParameter("pageNumber");
		if (Formater.isNull(sPageNumber))
			sPageNumber = "1";
		queryDetails.setPageNumber(new Integer(sPageNumber));
		criteria.setQueryDetail(queryDetails);
		Collection listCuocTtkt = new BaseHibernateDAO().retrieveObjects(appContext, criteria);
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
		table.setSearchForm("SuaKeHoachNamForm");
		request.setAttribute("dscttkt", table);
		request.setAttribute("countResult", listCuocTtkt.size()+"");

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

	/**
	 * @param keHoachNamForm
	 * @return
	 */
	private SearchCriteria createCriteriaFromForm(ApplicationContext appContext, SuaKeHoachNamForm keHoachNamForm) throws Exception, Exception {
		SearchCriteria criteria = new SearchCriteria(TtktKhCuocTtkt.class);

		criteria.addSearchItem(TtktKhCuocTtkt.IdDonViTh, appContext.getMaCqt());
		criteria.addSearchItem(TtktKhCuocTtkt.IdCuocTtktCha, null, SearchCriteria.LG_IS_NULL); // Khong phai la cuoc Ttkt con

		if (!Formater.isNull(keHoachNamForm.getMa_cuoc_ttkt()))
			criteria.addSearchItem(TtktKhCuocTtkt.Ma, "%" + keHoachNamForm.getMa_cuoc_ttkt().trim() + "%", SearchCriteria.OP_LIKE);
		if (!Formater.isNull(keHoachNamForm.getDon_vi_duoc_ttkt()))
			criteria.addSearchItem(TtktKhCuocTtkt.TenDonViBi, "%" + keHoachNamForm.getDon_vi_duoc_ttkt().trim() + "%", SearchCriteria.OP_LIKE);

		if (!Formater.isNull(keHoachNamForm.getTu_ngay()))
			criteria.addSearchItem(TtktKhCuocTtkt.NienDoTuNgay, Formater.str2date(keHoachNamForm.getTu_ngay()), SearchCriteria.OP_GE);

		if (!Formater.isNull(keHoachNamForm.getDen_ngay()))
			criteria.addSearchItem(TtktKhCuocTtkt.NienDoDenNgay, Formater.str2date(keHoachNamForm.getDen_ngay()), SearchCriteria.OP_LE);

		//		Thoi gian du kien
		if (!Formater.isNull(keHoachNamForm.getThoiGianDuKienTuNgay()))
			criteria.addSearchItem(TtktKhCuocTtkt.ThoiGianDuKienTuNgay, Formater.str2date(keHoachNamForm.getThoiGianDuKienTuNgay()), SearchCriteria.OP_GE);

		if (!Formater.isNull(keHoachNamForm.getThoiGianDuKienDenNgay()))
			criteria.addSearchItem(TtktKhCuocTtkt.ThoiGianDuKienDenNgay, Formater.str2date(keHoachNamForm.getThoiGianDuKienDenNgay()), SearchCriteria.OP_LE);

		if (!Formater.isNull(keHoachNamForm.getThoi_gian_du_kien()))
			criteria.addSearchItem(TtktKhCuocTtkt.ThoiGianDuKien, Byte.valueOf(keHoachNamForm.getThoi_gian_du_kien()));

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
	private void delete(ActionMapping mapping, SuaKeHoachNamForm keHoachNamForm, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		Connection conn = null;
		Statement statement = null;
		try {

			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			//String strCondition = keHoachNamForm.getSelectedItems().replaceAll(",", "','");
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
