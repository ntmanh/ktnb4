package cmc.com.ktnb.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.fill.JRDoubleIncrementerFactory;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.struts.util.LabelValueBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.json.simple.JSONArray;

import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhDuyetKeHoach;
import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KtnbDmCanbo;
import cmc.com.ktnb.pl.hb.entity.KtnbDmCqt;
import cmc.com.ktnb.vo.CategoryVO;
import cmc.com.ktnb.web.BaseActionForm;
import cmc.com.ktnb.web.catalog.CatalogService;
import cmc.com.ktnb.web.ttkt.service.TtktService;

public class KtnbUtil {

	/**
	 * Lay tat ca Cuc Thue
	 * 
	 * @param context
	 * @param includeTCT
	 *            Co lay TCT hay khong
	 * @param request
	 * @return Danh sach Cuc Thue tu table KtnbDmCqt
	 * @throws Exception
	 */
	public static Collection getCucThue(ApplicationContext context, boolean includeTCT, HttpServletRequest request, String tenCqt) throws Exception {
		CatalogService cs = new CatalogService();
		SearchCriteria sc = new SearchCriteria();
		sc.setSearchClass(KtnbDmCqt.class);
		sc.addSearchItem("ma", "%00", SearchCriteria.OP_LIKE);
		if (!Formater.isNull(tenCqt))
			sc.addSearchItem("ten", "%" + tenCqt + "%", SearchCriteria.OP_LIKE);
		if (!includeTCT)
			sc.addSearchItem("ma", "00000", SearchCriteria.OP_NE);
		sc.addOrderItem("ma");
		return cs.retrive(context, sc);
	}

	/**
	 * Lay tat ca CCT Cuc Thue cua 1 Cuc Thue
	 * 
	 * @param context
	 * @param includeCha
	 *            Co lay VP Cuc hay khong
	 * @param request
	 * @return Danh sach Chi Cuc Thue tu table KtnbDmCqt
	 * @throws Exception
	 */
	public static Collection getCqt(ApplicationContext context, HttpServletRequest request, String maCqt, boolean includeCha, String tenCqt) throws Exception {
		if (isChiCuc(maCqt))
			throw new Exception("Chi cuc khong co cqt truc thuoc");
		CatalogService cs = new CatalogService();
		SearchCriteria sc = new SearchCriteria();
		sc.setSearchClass(KtnbDmCqt.class);
		if (!Formater.isNull(maCqt))
			sc.addSearchItem("ma", maCqt.substring(0, 3) + "%", SearchCriteria.OP_LIKE);
		if (!Formater.isNull(tenCqt))
			sc.addSearchItem("ten", "%" + tenCqt + "%", SearchCriteria.OP_LIKE);
		if (!includeCha)
			sc.addSearchItem("ma", maCqt, SearchCriteria.OP_NE);
		sc.addOrderItem("ma");
		Collection ret = cs.retrive(context, sc);
		return ret;
	}

	// ntdung: Bo sung ham lay cac co quan thue truc thuoc, bao gom ca co quan
	// thue cha
	public static Collection getCqtTrucThuoc(ApplicationContext context, HttpServletRequest request, String maCqt) throws Exception {
		return getCqt(context, request, maCqt, true, null);
	}

	public static void printf(HttpServletRequest request, String fileIn, Map parameters, HttpServletResponse response) throws Exception {
		String fileOut = request.getRealPath("/docout") + "\\temp" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
		MsWordUtils word = new MsWordUtils(fileIn, fileOut);
		try {
			for (Iterator iter = parameters.keySet().iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				word.put("[" + key + "]", (String) parameters.get(key));
			}
			String[] temp = fileIn.split(".doc")[0].split("/");
			String fileOutName = temp[temp.length - 1];
			word.saveAndClose();
			word.downloadFile(fileOut, fileOutName, ".doc", response);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				word.saveAndClose();
			} catch (Exception ex) {
			}
		}
	}

	/**
	 * 
	 * @param reportRows
	 *            Danh sach
	 * @param rp
	 *            Ten bieu mau
	 * @param response
	 * @param inputStream
	 * @param parameters
	 *            Cac tham so lay tren form
	 * @param format
	 *            Dinh danh can xuat ra
	 * @throws IOException
	 * @throws JRException
	 */
	public static void printf(HashMap[] reportRows, String rp, HttpServletResponse response, InputStream inputStream, Map parameters, String format) throws Exception, JRException {
		long start = System.currentTimeMillis();
		if (Formater.isNull(format))
			format = "RTF";
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
		jasperReport.setWhenNoDataType(JasperReport.WHEN_NO_DATA_TYPE_ALL_SECTIONS_NO_DETAIL);
		JasperPrint jasperPrint;
		if (reportRows != null && reportRows.length > 0) {
			JRMapArrayDataSource dataSource = new JRMapArrayDataSource(reportRows);
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		} else
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
		response.reset();
		ServletOutputStream oStream = response.getOutputStream();
		response.addHeader("Content-Disposition", "attachment;filename=" + rp + Formater.date2str4File(new Date()) + "." + format);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		if ("PDF".equals(format)) {
			response.setContentType("application/pdf");
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
			exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, baos);
			exporter.exportReport();
		} else if ("RTF".equals(format)) {
			response.setContentType("application/rtf");
			JRRtfExporter exporter = new JRRtfExporter();
			exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
			// exporter.setParameter(JRExporterParameter.JASPER_PRINT,
			// jasperPrint);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
			exporter.exportReport();
		}
		oStream.write(baos.toByteArray());
		oStream.flush();
		oStream.close();
		System.out.println("Report time=" + (System.currentTimeMillis() - start));
	}

	public static boolean isTruongDoan(String maCanBoId, ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktKhCuocTtkt.class);
		criteria.addSearchItem(TtktKhCuocTtkt.IdTruongDoan, maCanBoId);
		criteria.addSearchItem(TtktKhCuocTtkt.Id, cuocTtktId);
		return ((Collection) (new BaseHibernateDAO()).retrieveObjects(appContext, criteria)).size() > 0;
	}

	public static boolean isChiCuc(ApplicationContext appContext) {
		return !isTongCuc(appContext) && !isCuc(appContext);
	}

	public static boolean isTongCuc(String macqt) {
		return macqt.equals(Constants.TCT_CODE);
	}

	public static boolean isTongCuc(ApplicationContext context) {
		return isTongCuc(context.getMaCqt());
	}

	public static boolean isCuc(ApplicationContext context) {
		return context.getMaCqt().substring(3).equals("00") && !context.getMaCqt().equals("00000");
	}

	public static boolean isCuc(String maCqt) {
		return maCqt.substring(3).equals("00") && !maCqt.equals("00000");
	}

	public static boolean isChiCuc(String maCqt) {
		return !maCqt.substring(3, 5).equals("00") && !maCqt.equals("00000");
	}

	public static String getMaCucByMaCqt(String macqt) {
		return macqt.substring(0, 3) + "00";
	}

	public static String getMaTinhByMaCqt(String macqt) {
		return macqt.substring(0, 3);
	}

	public static String getTenTinhByMaCqt(ApplicationContext context, String macqt) {
		if (isTongCuc(macqt))
			return "H\u00E0 N\u1ED9i";
		else {
			String ma_tinh = getMaTinhByMaCqt(macqt);
			return getTenTinhByMa(context, ma_tinh);
		}
	}

	public static String getLanhDaoByMaCqt(String macqt) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String retval = null;
		String sql = "select TEN_CANBO FROM KTNB_DM_CAN_BO_V where MA_CQT=? and (MA_CHUC_VU=? or MA_CHUC_VU=?)";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, macqt);
			ps.setString(2, "1105");
			ps.setString(3, "1109");
			rs = ps.executeQuery();
			if (rs.next())
				retval = rs.getString(1);
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}

	public static String getDiaBan(ApplicationContext appContext, String macqt) throws Exception {
		String retval = null;
		if (isTongCuc(appContext))
			retval = "H\u00E0 N\u1ED9i";
		else {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select ten from ktnb_dm_huyen where MA=?";
			try {
				conn = DataSourceConfiguration.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, macqt);
				rs = ps.executeQuery();
				if (rs.next())
					retval = rs.getString(1);
				replace4FullText(retval);
			} catch (Exception ex) {
				throw ex;
			} finally {
				DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
			}
		}
		return retval;
	}

	public static String replace4FullText(String ori) {
		String[] arrQ = { "Qu\u1EADn", "Huy\u1EC7n", "Th\u1ECB x\u00E3", "T\u1EC9nh", "Th\u00E0nh ph\u1ED1" };
		for (int i = 0; i < arrQ.length; i++)
			ori.replaceAll(arrQ[i], "");
		return ori;
	}

	public static String getSeqMaHsByMaCqt(String macqt, String kyBc) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String retval = null;
		String sql = "select ma_hs FROM ktnb_ho_so_seq where MA=? and KY_BC=?";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, macqt);
			ps.setString(2, kyBc);
			rs = ps.executeQuery();
			if (rs.next()) {
				retval = rs.getString(1);
			} else {
				// insert ky bao cao moi
				String insertSql = "insert into ktnb_ho_so_seq values(?,1,?)";
				ps = conn.prepareStatement(insertSql);
				ps.setString(1, macqt);
				ps.setString(2, kyBc);
				ps.execute();
				retval = "0";
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}

	public static Collection getCqtByMaTinh(String matinh) {
		HashMap map = (HashMap) KtnbCache.getInstance().get("MAP_CQT");
		return (Collection) map.get(matinh);
	}

	public static Collection getDeptByMaCqt(String macqt) {
		HashMap map = (HashMap) KtnbCache.getInstance().get("MAP_DEPT");
		return (Collection) map.get(macqt);
	}

	public static KtnbDAO getKtnbDAO() {
		return new KtnbDAOImpl();
	}

	public static void releaseKtnbDAO(KtnbDAO dao) {
		if (dao != null) {
			dao.close();
			dao = null;
		}
	}

	public static boolean findArr(String[] arri, String[] arrj) {
		if (arrj == null || arrj.length < 1)
			return false;
		String ai;
		for (int i = 0; i < arri.length; i++) {
			ai = arri[i];
			for (int j = 0; j < arrj.length; j++) {
				if (arrj[j].equals(ai))
					return true;
			}
		}
		return false;
	}

	public static boolean findArr(String[] arr, String role) {
		for (int i = 0; i < arr.length; i++) {
			if (role.equals(arr[i]))
				return true;
		}
		return false;
	}

	public static String findNameDM(String id) {
		Collection c = (Collection) KtnbCache.getInstance().get("LOV_DSDM");
		CategoryVO categoryVO;
		for (Iterator iter = c.iterator(); iter.hasNext();) {
			categoryVO = (CategoryVO) iter.next();
			if (id.equals(categoryVO.getId()))
				return categoryVO.getName();
		}
		return null;
	}

	public static String getMa(ApplicationContext appContext, String nghiepVu) throws Exception {
		String retVal = "...../" + appContext.getTenCqtTat() + "/" + nghiepVu;
		return retVal;
	}

	public static String getMaNvu(ApplicationContext appContext, String nghiepVu) throws Exception {
		String retVal = "...../";
		retVal += nghiepVu + "-" + appContext.getTenCqtTat();
		return retVal;
	}

	public static DetailInformation[] increateArray(DetailInformation[] arrInput, DetailInformation addItem) {
		DetailInformation[] arrOutput = new DetailInformation[arrInput.length + 1];
		for (int i = 0; i < arrInput.length; i++)
			arrOutput[i] = arrInput[i];
		arrOutput[arrOutput.length - 1] = addItem;
		return arrOutput;
	}

	public static KtnbDmCanbo getThongTinCanBo(String maCanBo) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select t.ma_canbo,t.ten_canbo,t.ma_phong,t.ten_phong,t.ma_cqt,t.ten_cqt,t.chuc_vu from ktnb_dm_can_bo_v t where t.ma_canbo = ?";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maCanBo);
			rs = ps.executeQuery();
			KtnbDmCanbo canbo = new KtnbDmCanbo();
			if (rs.next()) {
				canbo.setMa(rs.getString(1));
				canbo.setTen(rs.getString(2));
				canbo.setMaPhong(rs.getString(3));
				canbo.setTenPhong(rs.getString(4));
				canbo.setMaCqt(rs.getString(5));
				canbo.setTenCqt(rs.getString(6));
				canbo.setChucVu(rs.getString(7));
			}
			return canbo;
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
	}

	public static String getTenPhongByMa(String ma, Collection c) {
		CategoryVO categoryVO;
		for (Iterator iter = c.iterator(); iter.hasNext();) {
			categoryVO = (CategoryVO) iter.next();
			if (ma.equals(categoryVO.getId()))
				return categoryVO.getName();
		}
		return null;
	}

	public static String getTenTinhByMa(ApplicationContext appContext, String ma) {
		String retval = "";
		if (isTongCuc(ma))
			retval = "H\u00E0 N\u1ED9i";
		else {
			Collection c = (Collection) KtnbCache.getInstance().get("LOV_TINH");
			CategoryVO categoryVO;
			for (Iterator iter = c.iterator(); iter.hasNext();) {
				categoryVO = (CategoryVO) iter.next();
				if (ma.equals(categoryVO.getId()))
					retval = categoryVO.getName();
			}
		}
		return retval;
	}

	public static String getTenChucVuByMa(String ma) {
		if (Formater.isNull(ma))
			return null;
		HashMap map = (HashMap) KtnbCache.getInstance().get("MAP_CHUCVU");
		String ten = (String) map.get(ma);
		return ten;
	}

	public static String getTenCqtByMa(String ma) {
		String maTinh = getMaTinhByMaCqt(ma);
		Collection c = getCqtByMaTinh(maTinh);
		CategoryVO categoryVO;
		for (Iterator iter = c.iterator(); iter.hasNext();) {
			categoryVO = (CategoryVO) iter.next();
			if (ma.equals(categoryVO.getId()))
				return categoryVO.getName();
		}
		return null;
	}

	public static JSONArray coll2Jarr(Collection c) {
		JSONArray jSONArray = new JSONArray();
		for (Iterator it = c.iterator(); it.hasNext();)
			jSONArray.add((CategoryVO) it.next());
		return jSONArray;
	}

	public static HashMap coll2Hash(Collection c) {
		HashMap map = new HashMap();
		CategoryVO categoryVO;
		for (Iterator it = c.iterator(); it.hasNext();) {
			categoryVO = (CategoryVO) it.next();
			map.put(categoryVO.getId(), categoryVO.getName());
		}
		return map;
	}

	/**
	 * @param appContext
	 * @return
	 */
	public static boolean haveRoleNv(ApplicationContext appContext) {
		String[] roles = appContext.getRole();
		for (int i = 0; i < roles.length; i++) {
			if (roles[i].equals(Constants.TTKT_ROLE_NV))
				return true;
		}
		return false;
	}

	/**
	 * @param appContext
	 * @return
	 */
	public static boolean haveRoleTt(ApplicationContext appContext) {
		String[] roles = appContext.getRole();
		for (int i = 0; i < roles.length; i++) {
			if (roles[i].equals(Constants.TTKT_ROLE_TTCQ))
				return true;
		}
		return false;
	}

	public static boolean haveRoleTBP(ApplicationContext appContext) {
		String[] roles = appContext.getRole();
		for (int i = 0; i < roles.length; i++) {
			if (roles[i].equals(Constants.TTKT_ROLE_TBP))
				return true;
		}
		return false;
	}

	/**
	 * Lay thong tin CQT cho man hinh tuy vao CQT cua NSD, xem man hinh bc_28
	 * cua KNTC
	 * 
	 * @param appContext
	 * @param aForm
	 * @param request
	 * @throws Exception
	 */
	public static void setCqt(ApplicationContext appContext, BaseActionForm aForm, HttpServletRequest request, String maCqt) throws Exception {
		// Lay cac thong tin co quan thue
		if (request.getAttribute("cqts") == null) {
			Collection dmCqt = null;
			Collection list = new ArrayList();
			if (maCqt != null && maCqt.equals(Constants.TCT_CODE)) { // Lay thong tin Cuc Thue
				{
					dmCqt = getCucThue(appContext, true, request, null);
					if (dmCqt != null && dmCqt.size() > 0) {
						for (Iterator iter = dmCqt.iterator(); iter.hasNext();) {
							KtnbDmCqt aCqt = (KtnbDmCqt) iter.next();
							if (aCqt.getMa().equals(Constants.TCT_CODE)) // Cuc Thue,TCT
								aCqt.setTen("VP " + aCqt.getTen());
							list.add(aCqt);
						}
					}
				}
			} else if (isCuc(maCqt)) {
				dmCqt = getCqt(appContext, request, maCqt, true, null);
				if (dmCqt != null && dmCqt.size() > 0) {
					for (Iterator iter = dmCqt.iterator(); iter.hasNext();) {
						KtnbDmCqt aCqt = (KtnbDmCqt) iter.next();
						if (aCqt.getMa().endsWith("00")) // Cuc Thue,TCT
							aCqt.setTen("VP " + aCqt.getTen());
						list.add(aCqt);
					}
				}
			} else // Chi cuc thi lay luon CQT cua user dang nhap
			{
				KtnbDmCqt aCqt = new KtnbDmCqt();
				aCqt.setMa(appContext.getMaCqt());
				aCqt.setTen(appContext.getTenCqt());
				list.add(aCqt);
			}
			request.setAttribute("cqts", list);
		}
	}

	/**
	 * Lay thong tin CQT cho man hinh tuy vao CQT cua NSD, xem man hinh bc_28
	 * cua KNTC
	 * 
	 * @param appContext
	 * @param aForm
	 * @param request
	 * @throws Exception
	 */
	public static void setCqt(ApplicationContext appContext, BaseActionForm aForm, HttpServletRequest request, String tenCqt, String level) throws Exception {
		// Lay cac thong tin co quan thue
		if (request.getAttribute("cqts") == null) {
			Collection dmCqt = null;
			Collection list = new ArrayList();
			if (isTongCuc(appContext)) { // Lay thong tin Cuc Thue
				dmCqt = getCucThue(appContext, true, request, tenCqt);
				if (dmCqt != null && dmCqt.size() > 0) {
					for (Iterator iter = dmCqt.iterator(); iter.hasNext();) {
						KtnbDmCqt aCqt = (KtnbDmCqt) iter.next();
						list.add(aCqt);
					}
				}
			} else if (isCuc(appContext)) { // Lay thong tin Chi Cuc Thue
				dmCqt = getCqt(appContext, request, appContext.getMaCqt(), true, tenCqt);
				if (dmCqt != null && dmCqt.size() > 0) {
					String[] roles = appContext.getRoleData();
					// String roleStr = "";
					if (roles != null && roles.length > 0) {
						for (int i = 0; i < roles.length; i++) {
							for (Iterator iter = dmCqt.iterator(); iter.hasNext();) {
								KtnbDmCqt aCqt = (KtnbDmCqt) iter.next();
								if (aCqt.getMa().equals(roles[i]))
									list.add(aCqt);
							}
						}
					}
				}
			} else { // Lay thong tin Chi Cuc Thue
				KtnbDmCqt aCqt = new KtnbDmCqt();
				aCqt.setMa(appContext.getMaCqt());
				aCqt.setTen(appContext.getTenCqt());
				list.add(aCqt);
			}
			request.setAttribute("cqts", list);
		}
	}

	/**
	 * Lay thong tin CQT cho man hinh tuy vao CQT cua NSD, xem man hinh bc_28
	 * cua KNTC
	 * 
	 * @param appContext
	 * @param aForm
	 * @param request
	 * @throws Exception
	 */
	public static void setCqtCbx(ApplicationContext appContext, BaseActionForm aForm, HttpServletRequest request) throws Exception {
		// Lay cac thong tin co quan thue
		if (request.getAttribute("cqts") == null) {
			Collection dmCqt = null;
			Collection list = new ArrayList();
			if (isTongCuc(appContext)) { // Lay thong tin Cuc Thue
				dmCqt = getCucThue(appContext, true, request, null);
				if (dmCqt != null && dmCqt.size() > 0) {
					for (Iterator iter = dmCqt.iterator(); iter.hasNext();) {
						KtnbDmCqt aCqt = (KtnbDmCqt) iter.next();
						list.add(new LabelValueBean(aCqt.getTen(), aCqt.getMa()));
					}
				}
			} else if (isCuc(appContext)) { // Lay thong tin Chi Cuc Thue
				dmCqt = getCqt(appContext, request, appContext.getMaCqt(), true, null);
				if (dmCqt != null && dmCqt.size() > 0) {
					for (Iterator iter = dmCqt.iterator(); iter.hasNext();) {
						KtnbDmCqt aCqt = (KtnbDmCqt) iter.next();
						list.add(new LabelValueBean(aCqt.getTen(), aCqt.getMa()));
					}
				}
			} else { // Lay thong tin Chi Cuc Thue
				KtnbDmCqt aCqt = new KtnbDmCqt();
				aCqt.setMa(appContext.getMaCqt());
				aCqt.setTen(appContext.getTenCqt());
				list.add(new LabelValueBean(aCqt.getTen(), aCqt.getMa()));
			}
			request.setAttribute("cqts", list);
		}
	}

	/**
	 * Lay thong tin CQT cho man hinh tuy vao CQT cua NSD, xem man hinh bc_28
	 * cua KNTC
	 * 
	 * @param appContext
	 * @param aForm
	 * @param request
	 * @throws Exception
	 */
	public static void setCqtCapCuc(ApplicationContext appContext, BaseActionForm aForm, HttpServletRequest request) throws Exception {
		// Lay cac thong tin co quan thue
		if (request.getAttribute("dmCqt") == null) {
			Collection dmCqt = null;
			Collection list = new ArrayList();
			if (isTongCuc(appContext)) { // Lay thong tin Cuc Thue
				dmCqt = getCucThue(appContext, true, request, null);
				if (dmCqt != null && dmCqt.size() > 0) {
					for (Iterator iter = dmCqt.iterator(); iter.hasNext();) {
						KtnbDmCqt aCqt = (KtnbDmCqt) iter.next();
						list.add(new LabelValueBean(aCqt.getTen(), aCqt.getMa()));
					}
				}
			} else
				list.add(new LabelValueBean(appContext.getTenCqt(), appContext.getMaCqt()));
			request.setAttribute("dmCqt", list);
		}
	}

	public static String getTextVbQdCnNv(String ma, ApplicationContext appContext, HttpServletRequest request) throws Exception {
		ArrayList listVb = (ArrayList) request.getAttribute("dmtly");
		if (listVb == null) { // Chua co trong session
			listVb = new ArrayList();
			String pId = "";
			if (KtnbUtil.isTongCuc(appContext))
				pId = CatalogService.VB_CAN_CU_TC;
			else if (KtnbUtil.isCuc(appContext))
				pId = CatalogService.VB_CAN_CU_CUC;
			else if (KtnbUtil.isChiCuc(appContext))
				pId = CatalogService.VB_CAN_CU_CHI_CUC;
			Collection dmTien = CatalogService.getDmByParentId(pId);
			for (Iterator iter = dmTien.iterator(); iter.hasNext();) {
				CategoryVO vo = (CategoryVO) iter.next();
				listVb.add(new LabelValueBean(vo.getName(), vo.getId()));
			}
		}
		Iterator iterator = listVb.iterator();
		while (iterator.hasNext()) {
			LabelValueBean valueBean = (LabelValueBean) iterator.next();
			if (valueBean.getValue().equals(ma))
				return valueBean.getLabel();
		}
		return null;
	}

	public static void setVanBan(String maCqt, HttpServletRequest request) throws Exception {
		ArrayList listVb = (ArrayList) request.getAttribute("dmtly");
		if (listVb == null) { // Chua co trong session
			listVb = new ArrayList();
			String pId = "";
			if (KtnbUtil.isTongCuc(maCqt))
				pId = CatalogService.VB_CAN_CU_TC;
			else if (KtnbUtil.isCuc(maCqt))
				pId = CatalogService.VB_CAN_CU_CUC;
			else if (KtnbUtil.isChiCuc(maCqt))
				pId = CatalogService.VB_CAN_CU_CHI_CUC;
			Collection dmTien = CatalogService.getDmByParentId(pId);
			for (Iterator iter = dmTien.iterator(); iter.hasNext();) {
				CategoryVO vo = (CategoryVO) iter.next();
				listVb.add(new LabelValueBean(vo.getName(), vo.getId()));
			}
		}
		request.setAttribute("dmtly", listVb);
	}

	public static void setVanBan(ApplicationContext appContext, HttpServletRequest request) throws Exception {
		ArrayList listVb = (ArrayList) request.getAttribute("dmtly");
		if (listVb == null) { // Chua co trong session
			listVb = new ArrayList();
			String pId = "";
			if (KtnbUtil.isTongCuc(appContext))
				pId = CatalogService.VB_CAN_CU_TC;
			else if (KtnbUtil.isCuc(appContext))
				pId = CatalogService.VB_CAN_CU_CUC;
			else if (KtnbUtil.isChiCuc(appContext))
				pId = CatalogService.VB_CAN_CU_CHI_CUC;
			Collection dmTien = CatalogService.getDmByParentId(pId);
			for (Iterator iter = dmTien.iterator(); iter.hasNext();) {
				CategoryVO vo = (CategoryVO) iter.next();
				listVb.add(new LabelValueBean(vo.getName(), vo.getId()));
			}
		}
		request.setAttribute("dmtly", listVb);
	}

	/**
	 * Lay them dieu kien tim kiem theo CQT cho man hinh tuy vao CQT cua NSD,
	 * xem man hinh tim kiem cua KNTC
	 */
	public static String addEndDate(String tableAlias) throws Exception {
		return " AND " + tableAlias + ".ngay_ket_thuc is null";
	}

	/**
	 * Lay them dieu kien tim kiem theo CQT cho man hinh tuy vao CQT cua NSD,
	 * xem man hinh tim kiem cua KNTC
	 */
	public static String addCqtCondition(ApplicationContext appContext, String tableAlias) throws Exception {
		String condition = "";
		String column = tableAlias + ".ma_cqt";
		// Lay cac thong tin co quan thue
		if (isCuc(appContext)) {
			condition = " AND " + column + " like '" + appContext.getMaCqt().substring(0, 3) + "%'";
		} else if (isChiCuc(appContext)) { // Lay thong tin Chi Cuc Thue
			condition = " AND " + column + " = '" + appContext.getMaCqt() + "'";
		} else if (isTongCuc(appContext)) {
			condition = " AND " + column + " = '" + appContext.getMaCqt() + "'";
		}
		return condition;
	}

	/**
	 * Lay them dieu kien tim kiem theo CQT cho man hinh tuy vao CQT cua NSD,
	 * xem man hinh tim kiem cua KNTC
	 */
	public static String addCqtCondition2(ApplicationContext appContext, String tableAlias) throws Exception {
		String condition = "";
		String column = tableAlias + ".ma_cqt";
		// Lay cac thong tin co quan thue
		if (isCuc(appContext)) {
			condition = " AND " + column + " like '" + appContext.getMaCqt().substring(0, 3) + "%'";
		} else if (isChiCuc(appContext)) {
			condition = " AND " + column + " = '" + appContext.getMaCqt() + "'";
		} else if (isTongCuc(appContext)) {
			if (!appContext.isLanhDao())
				condition = " AND " + column + " = '" + appContext.getMaCqt() + "'";
		}
		return condition;
	}

	/**
	 * Lay thong tin ve ngay lam viec cua he thong
	 * 
	 * @param root
	 *            Ngay bat dau
	 * @param numBusinessDays
	 *            So ngay can tinh
	 * @return Ngay ket thuc sau khi da bo di ngay nghi (ngay nghi he thong +
	 *         Thu 7 + Chu Nhat)
	 * @throws Exception
	 */
	public static Date addBusinessDate(Date root, int numBusinessDays) throws Exception {
		// System.out.println("Date is : " + Formater.date2str(root));
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(root);
		int numNonBusinessDays = 0;
		KtnbDAO ktnbDAO = KtnbUtil.getKtnbDAO();

		try {
			Collection listNgayNghi = ktnbDAO.getNgayNghi(Integer.toString(root.getYear()), Integer.toString(Calendar.YEAR));
			for (int i = 0; i < numBusinessDays; i++) {
				cal2.add(Calendar.DATE, 1);
				/*
				 * It's a Canadian/American custom to get the Monday (sometimes
				 * Friday) off when a holiday falls on a weekend.
				 */
				for (Iterator iter = listNgayNghi.iterator(); iter.hasNext();) {
					Date element = (Date) iter.next();
					// System.out.println(date2str(element));
					// System.out.println("cal2.getTime():
					// "+date2str(cal2.getTime()));
					if (Formater.date2str(element).equals(Formater.date2str(cal2.getTime()))) {
						numNonBusinessDays++;
					}
				}
				// Bo qua T7, CN
				if (cal2.get(Calendar.DAY_OF_WEEK) == 1 || cal2.get(Calendar.DAY_OF_WEEK) == 7) {
					numNonBusinessDays++;
				}
			}
			// System.out.println("So ngay nghi: " +numNonBusinessDays);
			if (numNonBusinessDays > 0) {
				cal2.add(Calendar.DATE, numNonBusinessDays);
			}
			// System.out.println("Date after " + numBusinessDays + " is : " +
			// Formater.date2str(cal2.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			KtnbUtil.releaseKtnbDAO(ktnbDAO);
		}
		return cal2.getTime();
	}

	public static String getTenThuTruongCqt(ApplicationContext appConText) throws Exception {
		String ret = "";
		CatalogService s = new CatalogService();
		if (isTongCuc(appConText)) {
			ret = "T\u1ED5ng c\u1EE5c tr\u01B0\u1EDFng" + " T\u1ED5ng c\u1EE5c thu\u1EBF";
		} else if (isCuc(appConText))
			ret = "C\u1EE5c tr\u01B0\u1EDFng " + ((KtnbDmCqt) s.retriveById(appConText, KtnbDmCqt.class, appConText.getMaCqt().substring(0, 3) + "00")).getTen();
		else
			ret = "Chi c\u1EE5c tr\u01B0\u1EDFng " + appConText.getTenCqt();
		return ret;
	}

	public static String getTenThuTruongCqtForMauin(ApplicationContext appConText) throws Exception {
		String ret = "";
		CatalogService s = new CatalogService();
		if (isTongCuc(appConText)) {
			ret = "T\u1ED5ng c\u1EE5c tr\u01B0\u1EDFng " + appConText.getTenCqt();
		} else if (isCuc(appConText))
			ret = "C\u1EE5c tr\u01B0\u1EDFng " + ((KtnbDmCqt) s.retriveById(appConText, KtnbDmCqt.class, appConText.getMaCqt().substring(0, 3) + "00")).getTen();
		else
			ret = "Chi c\u1EE5c tr\u01B0\u1EDFng " + appConText.getTenCqt();
		return ret;
	}

	public static String getChucVuThuTruongByMaCqt(String idDonVi) {
		String ret = "";
		if (isTongCuc(idDonVi))
			ret = "T\u1ED5ng c\u1EE5c tr\u01B0\u1EDFng";
		else if (isCuc(idDonVi))
			ret = "C\u1EE5c tr\u01B0\u1EDFng";
		else if (isChiCuc(idDonVi))
			ret = "Chi c\u1EE5c tr\u01B0\u1EDFng";
		else
			ret = "T\u1ED5ng c\u1EE5c tr\u01B0\u1EDFng";
		return ret;
	}

	public static String getTenTtCqtThueRaQd(ApplicationContext c) {
		return "\u0110\u1ED7 Ho\u00E0ng Anh Tu\u1EA5n";
	}

	/**
	 * @param appContext
	 * @param string
	 * @param string2
	 * @return
	 */
	public static String getMaHoSo(ApplicationContext appContext, String nghiepVu, String hinhThuc) {
		String retVal = appContext.getTenCqtTat() + "/" + nghiepVu + "/" + hinhThuc + "/" + Formater.date2str4Key(new Date());
		return retVal;
	}

	public static String getMaHoSoByCqt(ApplicationContext appContext, String maCqt, String nghiepVu, String hinhThuc) throws Exception {
		CatalogService cs = new CatalogService();
		KtnbDmCqt cqt = (KtnbDmCqt) cs.retriveById(appContext, KtnbDmCqt.class, maCqt);
		String retVal = cqt.getTenVt() + "/" + nghiepVu + "/" + hinhThuc + "/" + Formater.date2str4Key(new Date());
		return retVal;
	}

	/**
	 * Lay ma ho so theo STT
	 * 
	 * @param appContext
	 * @param maCqt
	 * @param nghiepVu
	 *            KN hay TC
	 * @param hinhThuc
	 *            Nhan tu van thu, tiep dan,...
	 * @return Ma ho so
	 * @throws Exception
	 */
	// public static String[] getMaHoSoByCqtBySeq(ApplicationContext appContext,
	// String nghiepVu, String hinhThuc,String kyBc) throws Exception {
	// String maHs = getSeqMaHsByMaCqt(appContext.getMaCqt(), kyBc);
	// String sttStr = "";
	// int stt = Integer.parseInt(maHs) + 1;
	// if (stt < 10)
	// sttStr = "00" + stt;
	// else if (stt >= 10 && stt < 100)
	// sttStr = "0" + stt;
	// else
	// sttStr = String.valueOf(stt);
	// String[] retVal = new String[2];
	// retVal[0] = appContext.getTenCqtTat() + "/" + nghiepVu + "/" + hinhThuc +
	// "/" + kyBc + "/" + sttStr;
	// retVal[1] = String.valueOf(stt);
	// return retVal;
	// }
	/**
	 * Lay ma ho so theo STT
	 * 
	 * @param appContext
	 * @param maCqt
	 * @param nghiepVu
	 *            KN hay TC
	 * @param hinhThuc
	 *            Nhan tu van thu, tiep dan,...
	 * @return Ma ho so
	 * @throws Exception
	 */
	public static String[] getMaHoSoByCqtBySeq(ApplicationContext appContext, String maCqt, String nghiepVu, String hinhThuc, String kyBc) throws Exception {
		CatalogService cs = new CatalogService();
		KtnbDmCqt cqt = (KtnbDmCqt) cs.retriveById(appContext, KtnbDmCqt.class, maCqt);
		String maHs = getSeqMaHsByMaCqt(cqt.getMa(), kyBc);
		String sttStr = "";
		int stt;
		try {
			stt = Integer.parseInt(maHs) + 1;
		} catch (Exception e) {
			stt = 1;
		}
		if (stt < 10)
			sttStr = "00" + stt;
		else if (stt >= 10 && stt < 100)
			sttStr = "0" + stt;
		else
			sttStr = String.valueOf(stt);
		System.out.println("Ma CQT: " + maCqt + ", Max: " + sttStr);
		String[] retVal = new String[2];
		retVal[0] = cqt.getTenVt() + "/" + nghiepVu + "/" + hinhThuc + "/" + kyBc + "/" + sttStr;
		retVal[1] = String.valueOf(stt);
		return retVal;
	}

	/**
	 * @param request
	 */
	public static void cacheListHolidayDayForClient(HttpServletRequest request) throws Exception {
		// Cache danh sach cac ngay nghi
		KtnbDAO ktnbDAO = KtnbUtil.getKtnbDAO();
		Collection listNgayNghi = ktnbDAO.getNgayNghi(Integer.toString(Calendar.YEAR - 2), Integer.toString(Calendar.YEAR));
		String strDateHoliday = "";
		Iterator iterator = listNgayNghi.iterator();
		while (iterator.hasNext()) {
			strDateHoliday += Formater.date2str((Date) iterator.next()) + ";";
		}
		if (!Formater.isNull(strDateHoliday))
			request.setAttribute("strDateHoliday", strDateHoliday.substring(0, strDateHoliday.length() - 1));
	}

	/**
	 * @param request
	 */
	public static void cacheListHolidayDayForClient(HttpServletRequest request, String startYear, String enYear) throws Exception {
		// Cache danh sach cac ngay nghi
		KtnbDAO ktnbDAO = KtnbUtil.getKtnbDAO();
		Collection listNgayNghi = ktnbDAO.getNgayNghi(startYear, enYear);
		String strDateHoliday = "";
		Iterator iterator = listNgayNghi.iterator();
		while (iterator.hasNext()) {
			strDateHoliday += Formater.date2str((Date) iterator.next()) + ";";
		}
		if (!Formater.isNull(strDateHoliday))
			strDateHoliday = strDateHoliday.substring(0, strDateHoliday.length() - 1);
		request.setAttribute("strDateHoliday", strDateHoliday);

	}

	/**
	 * @param appConText
	 */
	public static String getTenCqtCapTrenTt(ApplicationContext appConText) throws Exception {
		CatalogService s = new CatalogService();
		if (isTongCuc(appConText))
			return "B\u1ED9 T\u00E0i ch\u00EDnh";
		else if (isCuc(appConText))
			return "T\u1ED5ng c\u1EE5c Thu\u1EBF";
		else
			return ((KtnbDmCqt) s.retriveById(appConText, KtnbDmCqt.class, appConText.getMaCqt().substring(0, 3) + "00")).getTen();
		// return "C\u1EE5c thu\u1EBF" + ((KtnbDmCqt) s.retriveById(appConText,
		// KtnbDmCqt.class, appConText.getMaCqt().substring(0, 3) +
		// "00")).getTen();
	}

	// Lay ten cua truong bo phan (Vu truong, truong phong, doi truong)
	public static String getTenTruongBoPhan(ApplicationContext appConText) throws Exception {
		if (isTongCuc(appConText))
			return "V\u1EE5 tr\u01B0\u1EDFng ";
		else if (isCuc(appConText))
			return "Tr\u01B0\u1EDFng ph\u00F2ng ";
		else
			return "\u0110\u1ED9i tr\u01B0\u1EDFng ";
	}// Lay ten cua truong bo phan (Vu truong, truong phong, doi truong)

	public static String getTenBoPhan(ApplicationContext appConText) throws Exception {
		if (isTongCuc(appConText))
			return "V\u1EE5 ki\u1EC3m tra n\u1ED9i b\u1ED9 ";
		else if (isCuc(appConText))
			return "Ph\u00F2ng ki\u1EC3m tra n\u1ED9i b\u1ED9 " + appConText.getTenCqt();
		else
			return "\u0110\u1ED9i Ki\u1EC3m tra n\u1ED9i b\u1ED9 " + appConText.getTenCqt();
	}

	// Lay chuc danh cua nguoi de nghi
	public static String getChucDanhNguoiDeNghi(ApplicationContext appConText) throws Exception {
		if (isTongCuc(appConText))
			return "Tr\u01B0\u1EDFng b\u1ED9 ph\u1EADn";
		else if (isCuc(appConText))
			return "Tr\u01B0\u1EDFng ph\u00F2ng";
		else
			return "\u0110\u1ED9i tr\u01B0\u1EDFng";
	}

	public static String getTenThuTruongCqt(String maCqt) {
		return "";
	}

	public static String getTenCqtCapTrenTt4P(ApplicationContext appConText) throws Exception {
		CatalogService s = new CatalogService();
		if (isTongCuc(appConText))
			return "B\u1ED8 T\u00C0I CH\u00CDNH";
		else if (isCuc(appConText))
			return "T\u1ED4NG C\u1EE4C THU\u1EBE";
		else
			return ((KtnbDmCqt) s.retriveById(appConText, KtnbDmCqt.class, appConText.getMaCqt().substring(0, 3) + "00")).getTen();
	}

	// hoan
	public static String getDay(String day) {
		String ngayLapTemp = day.split(" ")[1];
		String ngay = ngayLapTemp.split("/")[0];
		String thang = ngayLapTemp.split("/")[1];
		String nam = ngayLapTemp.split("/")[2];

		String layngay = "ng\u00E0y " + ngay + " th\u00E1ng " + thang + " n\u0103m " + nam;
		return layngay;
	}

	public static String getHour(String day) {
		String ngayLapTemp = day.split(" ")[1];
		String ngay = ngayLapTemp.split("/")[0];
		String thang = ngayLapTemp.split("/")[1];
		String nam = ngayLapTemp.split("/")[2];

		String gioPhutLap = day.split(" ")[0];
		String phut = gioPhutLap.split(":")[1];
		String gio = gioPhutLap.split(":")[0];
		String tgNiemPhong = gio + " gi\u1EDD " + phut + " ph\u00FAt ng\u00E0y " + ngay + " th\u00E1ng " + thang + " n\u0103m " + nam;

		return tgNiemPhong;
	}

	public static String layoutTableHoTen(String stringIn) {
		String stringOut1 = "- \u00D4ng(b\u00E0): " + stringIn;
		int count = stringOut1.length();
		int spaceCount = 40 - count;
		String stringOut2 = "";
		for (int i = 0; i < spaceCount; i++) {
			stringOut2 += " ";
		}

		return stringOut1 + stringOut2;

	}

	public static String layoutTableChucVu(String stringIn) {
		String stringOut1 = "- Ch\u1EE9c v\u1EE5: " + stringIn;
		return stringOut1;
	}

	// in default dau ... khi co truong null
	public static String inFieldNull(int spaceCount) {
		String stringOut2 = "";
		for (int i = 0; i < spaceCount; i++) {
			stringOut2 += ".";
		}
		return stringOut2;

	}

	public static String inFieldNull(int right, String stringIn) {
		String stringOut1 = stringIn;
		int count = stringOut1.length();
		int spaceCount = 0;
		if (right > count) {
			spaceCount = right - count;
		}
		String stringOut2 = "";
		for (int i = 0; i < spaceCount; i++) {
			stringOut2 += ".";
		}
		return stringOut2;
		// return stringOut1 + stringOut2;

	}

	/**
	 * @param request
	 * @param response
	 * @param string
	 */
	public static void showBussinessExceiption(HttpServletRequest request, HttpServletResponse response, String message) throws IOException {
		request.getSession().setAttribute("error_message", message);
		response.sendRedirect("error.do");

	}

	public static void showRightExceiption(HttpServletResponse response) throws IOException {
		response.sendRedirect("error.do");

	}

	// lay ra danh sach nguoi ky
	public static void loadNguoiKy(HttpServletRequest request) {
		ApplicationContext appConText = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		if (Formater.isNull(appConText.getListNguoiKy()))
			return;
		Collection listNgky = new ArrayList();
		String[] arrNgky = appConText.getListNguoiKy().split(",");
		for (int i = 0; i < arrNgky.length; i++) {
			listNgky.add(new LabelValueBean(arrNgky[i], arrNgky[i]));
		}

		request.setAttribute("listNky", listNgky);

	}

	/**
	 * Kiem tra quyen truy cap
	 * 
	 * @param appConText
	 * @param request
	 * @param reponse
	 * @param cuocTtkt
	 *            Cuoc Thanh tra kiem tra can check
	 * @throws IOException
	 */
	public static void checkRight(ApplicationContext appConText, HttpServletRequest request, HttpServletResponse reponse, TtktKhCuocTtkt cuocTtkt) throws IOException {
		// La truong doan
		if (appConText.getMaCanbo().equals(cuocTtkt.getIdTruongDoan()))
			return;

		// Khong la thu truong co quan
		if (!haveRoleTBP(appConText) && !haveRoleTt(appConText))
			reponse.sendRedirect("error.do");

		// La thu truong cqt
		if (appConText.getMaCqt().equals(cuocTtkt.getIdDonViTh()))
			return;

		// La thu truong cqt cap tren
		if (isTongCuc(cuocTtkt.getIdDonViTh()) || isCuc(cuocTtkt.getIdDonViTh())) {
			if (isTongCuc(appConText))
				return;
			else
				reponse.sendRedirect("error.do");
		}

		String maCqtCha = cuocTtkt.getIdDonViTh().substring(0, 3) + "00";
		if (!appConText.getMaCqt().equals(maCqtCha)) {
			if (!isTongCuc(appConText))
				reponse.sendRedirect("error.do");
		}
	}

	public static String getArrMaCqt(String parentId) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String retval = null;
		String sql = "SELECT tab_to_string(CAST(COLLECT(ma) AS t_varchar2_tab)) AS arrma FROM   ktnb_dm_cqt where ma like ? GROUP BY substr(ma,0,3)";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, parentId.substring(0, 3) + "%");
			rs = ps.executeQuery();
			if (rs.next())
				retval = rs.getString(1);
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}
}
