/*
 * Created on Dec 24, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.naming.InitialContext;
import javax.security.auth.login.AppConfigurationEntry;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.UserTransaction;

import org.hibernate.Query;
import org.hibernate.Session;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhChiTietNoiDungTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhDuyetKeHoach;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhNoiDungTtkt;
import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KtnbDmCqt;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.vo.CategoryVO;
import cmc.com.ktnb.web.catalog.CatalogService;

/**
 * @author Nguyen Tien Dung
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CuocTtktService {
	private static BaseHibernateDAO dao = new BaseHibernateDAO();

	/**
	 * @param appContext
	 * @param cuocTtktId
	 * @return
	 */
	public static TtktKhCuocTtkt getCuocTtkt(ApplicationContext appContext,
			String cuocTtktId) throws Exception {
		// Lay cuoc Ttkt
		TtktKhCuocTtkt cuocTtkt = (TtktKhCuocTtkt) dao.retrieveObject(
				appContext, TtktKhCuocTtkt.class, cuocTtktId);
		// Lay noi dung
		SearchCriteria searchNoiDung = new SearchCriteria(
				TtktKhNoiDungTtkt.class);
		searchNoiDung.addSearchItem(TtktKhNoiDungTtkt.IdCuocTtkt, cuocTtkt
				.getId());
		Collection dsNoiDung = dao.retrieveObjects(appContext, searchNoiDung);
		if (Formater.isNull(dsNoiDung)) { // Lay ds co quan thue truc thuoc
			SearchCriteria searchTtktCqtTrucThuoc = new SearchCriteria(
					TtktKhCuocTtkt.class);
			searchTtktCqtTrucThuoc.addSearchItem(TtktKhCuocTtkt.IdCuocTtktCha,
					cuocTtkt.getId());
			Collection dsTtktCqtTrucThuoc = dao.retrieveObjects(appContext,
					searchTtktCqtTrucThuoc);
			if (!Formater.isNull(dsTtktCqtTrucThuoc)) {
				Iterator iter = dsTtktCqtTrucThuoc.iterator();
				while (iter.hasNext()) {
					TtktKhCuocTtkt cuocTtktCon = (TtktKhCuocTtkt) iter.next();
					cuocTtktCon.setDsNoiDungTTKT(getNoiDungTtkt(appContext,
							cuocTtktCon.getId()));
				}
			}
			cuocTtkt.setDsTtktCqtTrucThuoc(dsTtktCqtTrucThuoc);
		} else {
			cuocTtkt.setDsNoiDungTTKT(getNoiDungTtkt(appContext, cuocTtkt
					.getId()));
		}
		return cuocTtkt;
	}

	/**
	 * @param cuocTtktId
	 * @return
	 */
	public static Collection getNoiDungTtkt(ApplicationContext appContext,
			String cuocTtktId) throws Exception {
		SearchCriteria searchNoiDungTtkt = new SearchCriteria(
				TtktKhNoiDungTtkt.class);
		searchNoiDungTtkt.addSearchItem(TtktKhNoiDungTtkt.IdCuocTtkt,
				cuocTtktId);
		Collection dsNoiDungTtkt = dao.retrieveObjects(appContext,
				searchNoiDungTtkt);
		// Lay chi tiet noi dung
		Iterator iter = dsNoiDungTtkt.iterator();
		while (iter.hasNext()) {
			TtktKhNoiDungTtkt noidung = (TtktKhNoiDungTtkt) iter.next();
			SearchCriteria searchChitiet = new SearchCriteria(
					TtktKhChiTietNoiDungTtkt.class);
			searchChitiet.addSearchItem(TtktKhChiTietNoiDungTtkt.IdNoiDungTtkt,
					noidung.getId());
			noidung.setDsChiTietNoiDung(dao.retrieveObjects(appContext,
					searchChitiet));
		}
		return dsNoiDungTtkt;
	}

	private static void saveCuocTtkt(TtktKhCuocTtkt cuocTtkt,
			ApplicationContext appContext, HttpServletRequest request)
			throws Exception {

		if (!Formater.isNull(cuocTtkt.getIdCuocQdCu())) { // Them moi do sua
			// ke hoach
			// Tang tren luu id cuoc ttkt trong ke hoach vao cuoc ttkt theo qd
			// nen cho nay phai sua lai
			TtktKhCuocTtkt cuocTtktTrongQdCu = CuocTtktService
					.getCuocTtktWithoutNoiDung(appContext, cuocTtkt
							.getIdCuocQdCu());
			cuocTtkt.setIdTruongDoan(cuocTtktTrongQdCu.getIdTruongDoan());
			cuocTtkt.setTenTruongDoan(cuocTtktTrongQdCu.getTenTruongDoan());
			cuocTtkt
					.setLoaiCuocTtktKeHoachNam(Constants.TTKT_LOAI_KHN_CHANGE_IN_QD);
			cuocTtkt.setTrangThai(cuocTtktTrongQdCu.getTrangThai());
			cuocTtktTrongQdCu.setIdCuocQdMoi(cuocTtkt.getId());
			cuocTtktTrongQdCu.setTrangThai(Constants.TT_TTKT_HET_HL);
			cuocTtktTrongQdCu.setIdNguoiCapNat(appContext.getMaCanbo());
			cuocTtktTrongQdCu.setTenNguoiCapNhat(appContext.getTenCanbo());
			cuocTtktTrongQdCu.setNgayCapNhat(new Date());
			dao.updateObject(appContext, cuocTtktTrongQdCu, Boolean.TRUE);

		} else if (!Formater.isNull(cuocTtkt.getIdCuocKhCu())) {
			// Tang tren luu id cuoc ttkt trong ke hoach vao cuoc ttkt theo qd
			// nen cho nay phai sua lai
			TtktKhCuocTtkt cuocTtktTrongKhCu = CuocTtktService
					.getCuocTtktWithoutNoiDung(appContext, cuocTtkt
							.getIdCuocKhCu());
			cuocTtktTrongKhCu.setIdCuocKhMoi(cuocTtkt.getId());
			cuocTtktTrongKhCu
					.setLoaiCuocTtktKeHoachNam(Constants.TTKT_LOAI_KHN_EDIT);
			cuocTtktTrongKhCu.setTrangThai(Constants.TT_TTKT_HET_HL);
			dao.updateObject(appContext, cuocTtktTrongKhCu, Boolean.TRUE);
		}
		dao.saveObject(appContext, cuocTtkt, Boolean.TRUE);

		// Neu cuoc Ttkt co noi dung ttkt (Khong phai truong hop cuoc Ttkt
		// chinh)
		Collection dsNoiDungTtkt = (ArrayList) cuocTtkt.getDsNoiDungTTKT();
		if (Formater.isNull(dsNoiDungTtkt)) {
			// Neu cuoc Ttkt co Ttkt nhieu Cqt truc thuoc
			Collection dsTtktCqtTrucThuoc = cuocTtkt.getDsTtktCqtTrucThuoc();
			Iterator iter = dsTtktCqtTrucThuoc.iterator();
			while (iter.hasNext()) {
				TtktKhCuocTtkt ttktcqtTrucThuoc = (TtktKhCuocTtkt) iter.next();
				ttktcqtTrucThuoc.setIdCuocTtktCha(cuocTtkt.getId());
				saveCuocTtkt(ttktcqtTrucThuoc, appContext, request);
			}

		} else {
			Iterator iter = dsNoiDungTtkt.iterator();
			while (iter.hasNext()) {
				TtktKhNoiDungTtkt noidungTtkt = (TtktKhNoiDungTtkt) iter.next();
				noidungTtkt.setIdCuocTtkt(cuocTtkt.getId());
				// Persis noi dung Ttkt
				noidungTtkt = (TtktKhNoiDungTtkt) dao.saveObject(appContext,
						noidungTtkt, Boolean.TRUE);
				// Persis chi tiet noi dung
				// TODO: luu cac chi tiet vao 1 cot, khongn luu thanh nhieu rows
				Collection dsChiTietNoiDungTtkt = (ArrayList) noidungTtkt
						.getDsChiTietNoiDung();
				if (!Formater.isNull(dsChiTietNoiDungTtkt)) {
					Iterator chiTietNoiDungIterator = dsChiTietNoiDungTtkt
							.iterator();
					while (chiTietNoiDungIterator.hasNext()) {
						TtktKhChiTietNoiDungTtkt chiTietNoiDungTtkt = (TtktKhChiTietNoiDungTtkt) chiTietNoiDungIterator
								.next();
						chiTietNoiDungTtkt
								.setIdNoiDungTtkt(noidungTtkt.getId());
						dao.saveObject(appContext, chiTietNoiDungTtkt,
								Boolean.TRUE);
					}
				}
			}

		}

	}

	/**
	 * @param ktnbCuocTtkt
	 * @param appContext
	 * @param request
	 */
	public static void insertCuocTtkt(TtktKhCuocTtkt ktnbCuocTtkt,
			ApplicationContext appContext, HttpServletRequest request,
			boolean isInTran) throws Exception {
		if (isInTran) {
			saveCuocTtkt(ktnbCuocTtkt, appContext, request);
		} else {
			UserTransaction tx = null;
			Session session = null;
			try {
				BaseHibernateDAO dao = new BaseHibernateDAO();
				try {
					tx = (UserTransaction) new InitialContext()
							.lookup("java:comp/UserTransaction");
					tx.begin();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				session = HibernateSessionFactory.currentSession();
				saveCuocTtkt(ktnbCuocTtkt, appContext, request);
				session.flush();
				tx.commit();
			} catch (Exception e) {
				HibernateSessionFactory.rollbackQuiet();
				e.printStackTrace();
				throw new Exception(e);
			} finally {
				HibernateSessionFactory.closeSession(session);
			}

		}

	}

	private static Collection getDmNoiDungTtktGoc() throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection retval = new ArrayList();
		String sql = "select * from ktnb_dm t where t.parent_id = "
				+ Constants.DM_TTKT;
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

	/**
	 * @param appContext
	 * @param cuocTtkt
	 * @param isInTran
	 *            Co thuoc Tran
	 */
	private static void deleteCuocTtkt(ApplicationContext appContext,
			TtktKhCuocTtkt cuocTtkt, boolean isInTran) throws Exception {
		if (isInTran) {
			deleteCuocTtkt(appContext, cuocTtkt);

		} else {
			UserTransaction tx = null;
			Session session = null;
			try {
				BaseHibernateDAO dao = new BaseHibernateDAO();
				try {
					tx = (UserTransaction) new InitialContext()
							.lookup("java:comp/UserTransaction");
					tx.begin();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				session = HibernateSessionFactory.currentSession();
				deleteCuocTtkt(appContext, cuocTtkt);
				session.flush();
				tx.commit();
			} catch (Exception e) {
				HibernateSessionFactory.rollbackQuiet();
				e.printStackTrace();
				throw new Exception(e);
			} finally {
				HibernateSessionFactory.closeSession(session);
			}

		}
	}

	/**
	 * @param appContext
	 * @param string
	 */
	public static void deleteCuocTtkt(ApplicationContext appContext,
			String cuocTtktId) throws Exception {
		TtktKhCuocTtkt cuocTtkt = getCuocTtkt(appContext, cuocTtktId);
		if (TtktService.getIndexOfTrangThai(cuocTtkt.getTrangThai()) >= TtktService.getIndexOfTrangThai(Constants.TT_TTKT_CDTD))
			throw new Exception(Constants.MSG_KHG_XOA);
		deleteCuocTtkt(appContext, cuocTtkt, false);
	}

	/**
	 * @param appContext
	 * @param cuocTtktCon
	 */
	private static void deleteCuocTtkt(ApplicationContext appContext,
			TtktKhCuocTtkt cuocTtkt) throws Exception {

		if (Formater.isNull(cuocTtkt.getDsNoiDungTTKT())) { // Xoa danh sach
			// TtktCqt truc
			// thuoc
			Collection dsTtCqtTrucThuoc = cuocTtkt.getDsTtktCqtTrucThuoc();
			Iterator iter = dsTtCqtTrucThuoc.iterator();
			while (iter.hasNext()) {
				TtktKhCuocTtkt cuocTtktCon = (TtktKhCuocTtkt) iter.next();
				deleteCuocTtkt(appContext, cuocTtktCon);
			}

		} else { // Xoa danh sach noi dung Ttkt
			Collection dsNoiDungTtkt = cuocTtkt.getDsNoiDungTTKT();
			Iterator iter = dsNoiDungTtkt.iterator();
			while (iter.hasNext()) {
				TtktKhNoiDungTtkt noiDungTtkt = (TtktKhNoiDungTtkt) iter.next();
				deleteNoiDungTtkt(appContext, noiDungTtkt);
			}

		}
		dao.deleteObject(appContext, cuocTtkt, Boolean.TRUE);

	}

	/**
	 * @param appContext
	 * @param noiDungTtkt
	 */
	private static void deleteNoiDungTtkt(ApplicationContext appContext,
			TtktKhNoiDungTtkt noiDungTtkt) throws Exception {
		Collection dsChiTietNoiDungTtkt = noiDungTtkt.getDsChiTietNoiDung();
		if (!Formater.isNull(dsChiTietNoiDungTtkt)) {
			Iterator iter = dsChiTietNoiDungTtkt.iterator();
			while (iter.hasNext()) {
				TtktKhChiTietNoiDungTtkt chiTietNoiDungTtkt = (TtktKhChiTietNoiDungTtkt) iter
						.next();
				dao.deleteObject(appContext, chiTietNoiDungTtkt, Boolean.TRUE);
			}
		}
		dao.deleteObject(appContext, noiDungTtkt, Boolean.TRUE);

	}

	/**
	 * @param ktnbCuocTtkt
	 * @param appContext
	 * @param request
	 */
	public static TtktKhCuocTtkt upDateCuocTtkt(TtktKhCuocTtkt ktnbCuocTtkt,
			ApplicationContext appContext, HttpServletRequest request)
			throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext()
						.lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();
			// Xoa cuoc Ttkt cu
			deleteCuocTtkt(appContext, getCuocTtkt(appContext, ktnbCuocTtkt
					.getId()), true);
			// Luu cuoc Ttkt moi
			ktnbCuocTtkt.setId(KeyManagement.getGUID());
			insertCuocTtkt(ktnbCuocTtkt, appContext, request, true);
			session.flush();
			tx.commit();
		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		return ktnbCuocTtkt;

	}

	/**
	 * @param ttkt
	 */
	public static void saveCuocTtkt(ApplicationContext appContext,
			HttpServletRequest request, TtktKhCuocTtkt cuocTtkt)
			throws Exception {
		if (Formater.isNull(cuocTtkt.getId())) { // Truong hop them moi
			cuocTtkt.setId(KeyManagement.getGUID());
			cuocTtkt.setDonVer(Constants.APP_DEP_VERSION);
			insertCuocTtkt(cuocTtkt, appContext, request, false);
			if (!Formater.isNull(cuocTtkt.getIdCuocQdCu())) {
				// chinh lai link cua bao cao khao sat va quyet dinh neu co
				Connection conn = null;
				Statement statement = null;
				try {
					conn = DataSourceConfiguration.getConnection();
					statement = conn.createStatement();
					// Chinh lai link bcks
					statement.addBatch("update ktnb_file set MA_DON = '"
							+ cuocTtkt.getId() + "' where MA_DON = '"
							+ cuocTtkt.getIdCuocQdCu() + "'");
					// Chinh lai link cua danh sach thanh vien doan
					statement
							.addBatch("update TTKT_CB_DS_TV_DOAN set ID_CUOC_TTKT = '"
									+ cuocTtkt.getId()
									+ "' where ID_CUOC_TTKT = '"
									+ cuocTtkt.getIdCuocQdCu() + "'");
					// Chinh lai link cua quyet dinh
					statement.addBatch("update TTKT_CB_QD set ID_CUOC_TTKT = '"
							+ cuocTtkt.getId() + "' where ID_CUOC_TTKT = '"
							+ cuocTtkt.getIdCuocQdCu() + "'");
					statement.executeBatch();
					conn.commit();
				} catch (Exception e) {
					e.printStackTrace();

				} finally {
					DataSourceConfiguration.releaseSqlResources(null,
							statement, conn);
				}
			}
		} else
			// Truong hop cap nhat
			upDateCuocTtkt(cuocTtkt, appContext, request);

	}

	/**
	 * @param string
	 * @return
	 */
	public static TtktCbChiTietDsTvDoan getTruongDoan(String cuocTtktId) {
		String sql = "select * from TTKT_CB_CHI_TIET_DS_TV_DOAN t1, TTKT_CB_DS_TV_DOAN t2 where t1.id_ds_tvd = t2.id and t2.id_cuoc_ttkt = '"
				+ cuocTtktId + "'";
		Session s = HibernateSessionFactory.currentSession();
		return (TtktCbChiTietDsTvDoan) s.createSQLQuery(sql).addEntity(
				TtktCbChiTietDsTvDoan.class).list().get(0);

	}

	/**
	 * @param appContext
	 * @param cuocTtktId
	 * @return
	 */
	public static TtktKhCuocTtkt getCuocTtkTrongQd(
			ApplicationContext appContext, String cuocTtktId) throws Exception {
		TtktKhCuocTtkt cuocTtkt = (TtktKhCuocTtkt) dao.retrieveObject(
				appContext, TtktKhCuocTtkt.class, cuocTtktId);
		if (Formater.isNull(cuocTtkt.getIdCuocTtktTrongQd()))
			return getCuocTtkt(appContext, cuocTtktId);
		else
			return getCuocTtkt(appContext, cuocTtkt.getIdCuocTtktTrongQd());
	}

	/**
	 * @param appConText
	 * @param cuocTtktId
	 * @return
	 */
	public static TtktKhCuocTtkt getCuocTtktWithoutNoiDung(
			ApplicationContext appConText, String cuocTtktId) throws Exception {
		return (TtktKhCuocTtkt) dao.retrieveObject(appConText,
				TtktKhCuocTtkt.class, cuocTtktId);
	}

	public String getDonVerionTtkt(ApplicationContext appConText, String cuocTtktId) throws Exception {
		TtktKhCuocTtkt cuocTtkt = (TtktKhCuocTtkt) dao.retrieveObject(appConText, TtktKhCuocTtkt.class, cuocTtktId);
		if ("4".equals(cuocTtkt.getDonVer()))
			return "4";
		else
			return "3";
	}
	
	public static TtktKhCuocTtkt getCuocTtktTrongQdWithoutNoiDung(
			ApplicationContext appConText, String cuocTtktId) throws Exception {
		TtktKhCuocTtkt cuocTtktKh = getCuocTtktWithoutNoiDung(appConText,
				cuocTtktId);
		if (Formater.isNull(cuocTtktKh.getIdCuocTtktTrongQd()))
			return cuocTtktKh;
		return (TtktKhCuocTtkt) dao.retrieveObject(appConText,
				TtktKhCuocTtkt.class, cuocTtktKh.getIdCuocTtktTrongQd());
	}

	/**
	 * @param cuocTtktId
	 */
	public static void chinhSuaXoaCuocTtkt(ApplicationContext appContext,
			String cuocTtktId) {
		String sqlDelete = "update ttkt_kh_cuoc_ttkt set LOAI_CUOC_TTKT_KHN = '"
				+ Constants.TTKT_LOAI_KHN_DEL
				+ "', TRANG_THAI = '"
				+ Constants.TT_TTKT_HET_HL + "' where id = " + cuocTtktId;
		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			statement.executeUpdate(sqlDelete);

		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}
	}

	/**
	 * @param appContext
	 * @return
	 */
	public static Collection getDsIdCuocTtktBiSuaTrongKhNam(
			ApplicationContext appContext) {
		ArrayList arrReturn = new ArrayList();
		Connection conn = null;
		ResultSet rs = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			rs = statement
					.executeQuery("select ID_CUOC_TTKT_KH from ttkt_kh_cuoc_ttkt where ID_CUOC_TTKT_KH is not null");
			while (rs.next()) {
				arrReturn.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, statement, conn);
		}
		return arrReturn;

	}

	public static String[] getDsMaDaSuDung(String maCqt, String type,
			String year) {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		String[] arrResult = null;
		Collection temp = new ArrayList();
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			String sql = "select distinct SUBSTR(t1.ma, length(t1.ma) - 2, length(t1.ma)) as stt";
			sql += " from ttkt_kh_cuoc_ttkt t1";
			sql += " where t1.ma is not null";
			sql += "  and t1.ma like '%/" + year + "/%'";
			sql += "  and t1.ma like '%/" + type + "/%'";
			sql += "  and t1.id_don_vi_th = '" + maCqt + "'";
			sql += "  order by to_number(stt)";
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				temp.add(rs.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, statement, conn);

		}
		if (Formater.isNull(temp))
			return null;
		arrResult = new String[temp.size()];
		for (int i = 0; i < arrResult.length; i++) {
			arrResult[i] = (String) ((ArrayList) temp).get(i);
		}
		return arrResult;
	}

	public static boolean isExist(ApplicationContext appContext, String maKhTtkt)
			throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktKhCuocTtkt.class);
		criteria.addSearchItem(TtktKhCuocTtkt.Ma, maKhTtkt);
		return !Formater.isNull(dao.retrieveObjects(appContext, criteria));
	}

	public static Collection getDsDuyetKh(ApplicationContext appContext)
			throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktKhDuyetKeHoach.class);
		criteria.addSearchItem(TtktKhDuyetKeHoach.MaCqt, appContext.getMaCqt());
		return dao.retrieveObjects(appContext, criteria);
	}

	public static Collection getKhNam(ApplicationContext appContext,
			String maCqt, String namKeHoach) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktKhCuocTtkt.class);
		criteria.addSearchItem(TtktKhCuocTtkt.IdDonViTh, maCqt);
		criteria.addSearchItem(TtktKhCuocTtkt.Ma, "%" + namKeHoach + "%",
				SearchCriteria.OP_LIKE);
		return dao.retrieveObjects(appContext, criteria);
	}

	public static String searchDvPhuthuoc(String parentId) throws KtnbException {
		String dvPhuthuoc = null;
		if (parentId != null && !parentId.equals("")) {
			String sql = "select * from Ttkt_Kh_Cuoc_Ttkt t where t.id_cuoc_ttkt_cha ='"
					+ parentId + "'";
			Session session = HibernateSessionFactory.currentSession();
			try {
				if (!session.isOpen())
					session = HibernateSessionFactory.openNewSession();
				session.beginTransaction();
				Query q = session.createSQLQuery(sql.toString()).addEntity(
						TtktKhCuocTtkt.class);
				Collection listCuocTtkt = q.list();
				if (!Formater.isNull(listCuocTtkt)) {
					dvPhuthuoc = "";
					Iterator iter = listCuocTtkt.iterator();
					while (iter.hasNext()) {
						TtktKhCuocTtkt cuocTtkt = (TtktKhCuocTtkt) iter.next();
						if (!dvPhuthuoc.equals(""))
							dvPhuthuoc += "; ";
						dvPhuthuoc += cuocTtkt.getTenDonViBi();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new KtnbException(e);
			} finally {
				// HibernateSessionFactory.closeSessionQuiet();
			}
		}
		return dvPhuthuoc;
	}

	public static Collection getCqtTrucThuocDaDuyetKh(
			ApplicationContext appContext, HttpServletRequest request,
			String maCqt, String namKeHoach) throws Exception {
		if (KtnbUtil.isChiCuc(maCqt))
			throw new Exception("Chi cuc khong co cqt truc thuoc");
		SearchCriteria sc = new SearchCriteria(TtktKhDuyetKeHoach.class);
		sc.addSearchItem(TtktKhDuyetKeHoach.KeHoachNam, Long
				.valueOf(namKeHoach));
		sc.addSearchItem(TtktKhDuyetKeHoach.MaCqt, maCqt, SearchCriteria.OP_NE);
		if (KtnbUtil.isTongCuc(maCqt)) {
			sc.addSearchItem(TtktKhDuyetKeHoach.MaCqt, "%00",
					SearchCriteria.OP_LIKE);
		} else if (KtnbUtil.isCuc(appContext)) {
			sc.addSearchItem(TtktKhDuyetKeHoach.MaCqt, maCqt.substring(0, 3)
					+ "%", SearchCriteria.OP_LIKE);
		}
		sc.addOrderItem(TtktKhDuyetKeHoach.MaCqt);
		return dao.retrieveObjects(appContext, sc);
	}

	public static boolean checkExit(ApplicationContext appContext,
			HttpServletRequest request, TtktKhCuocTtkt cuocTtkt) {
		// TODO Auto-generated method stub
		SearchCriteria sc = new SearchCriteria(TtktKhCuocTtkt.class);
		Collection result = new ArrayList();
		try {
			sc.addSearchItem(TtktKhCuocTtkt.IdDonViBi, cuocTtkt.getIdDonViBi());
			if (!"".equals(cuocTtkt.getId())) {
				sc.addSearchItem(TtktKhCuocTtkt.Id, cuocTtkt.getId(),
						SearchCriteria.OP_NE);
			}
			result = dao.retrieveObjects(appContext, sc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Iterator iter = result.iterator(); iter.hasNext();) {
			boolean tk = false;
			boolean nd = false;
			TtktKhCuocTtkt cuocTtktTemp = (TtktKhCuocTtkt) iter.next();
			// Thoi Ki
			/*if (cuocTtktTemp.getIdCuocTtktCha() == null) {
				if (cuocTtktTemp.getNienDoTuNgay().compareTo(cuocTtkt.getNienDoTuNgay()) <= 0) {
					if (cuocTtktTemp.getNienDoDenNgay().compareTo(cuocTtkt.getNienDoTuNgay()) >= 0) {
						tk = true;
					}
				} else if (cuocTtktTemp.getNienDoTuNgay().compareTo(cuocTtkt.getNienDoTuNgay()) >= 0
						&& cuocTtktTemp.getNienDoTuNgay().compareTo(cuocTtkt.getNienDoDenNgay()) <= 0) {
					tk = true;
				}
			}*/
			tk = true;
			// Noi dung
			if (cuocTtktTemp.getIdCuocTtktCha() == null) {
				Collection dscqtTrucThuoc = new ArrayList();
				try {
					dscqtTrucThuoc = CuocTtktService.getCuocTtkt(appContext,
							cuocTtktTemp.getId()).getDsTtktCqtTrucThuoc();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (dscqtTrucThuoc != null) {
					for (Iterator iterator = dscqtTrucThuoc.iterator(); iterator
							.hasNext();) {
						TtktKhCuocTtkt cqtTructhuoc = (TtktKhCuocTtkt) iterator
								.next();
						Collection dsNoiDung = cqtTructhuoc.getDsNoiDungTTKT();
						for (Iterator iterator1 = dsNoiDung.iterator(); iterator1
								.hasNext();) {
							TtktKhNoiDungTtkt noiDung = (TtktKhNoiDungTtkt) iterator1
									.next();
							//
							Collection medscqtTrucThuoc = cuocTtkt
									.getDsTtktCqtTrucThuoc();
							for (Iterator meiterator = medscqtTrucThuoc
									.iterator(); meiterator.hasNext();) {
								TtktKhCuocTtkt mecqtTructhuoc = (TtktKhCuocTtkt) meiterator
										.next();
								Collection medsNoiDung = mecqtTructhuoc
										.getDsNoiDungTTKT();
								for (Iterator meiterator1 = medsNoiDung
										.iterator(); meiterator1.hasNext();) {
									TtktKhNoiDungTtkt noiDung1 = (TtktKhNoiDungTtkt) meiterator1
											.next();
									if (noiDung.getIdNoiDung().equals(
											noiDung1.getIdNoiDung())
											&& mecqtTructhuoc.getId().equals(
													cqtTructhuoc.getId())) {
										nd = true;
										break;
									}
								}
							}
							//
						}
					}
				}
			}
			if (tk && nd) {
				return true;
			}
			// end
		}
		return false;
	}

	public static void updateCuocTtkt(ApplicationContext appContext,
			HttpServletRequest request, TtktKhCuocTtkt cuocTtkt) throws Exception{
		TtktKhCuocTtkt cuocTtktCu = new TtktKhCuocTtkt();
		try {
			cuocTtktCu = CuocTtktService.getCuocTtkt(appContext, cuocTtkt
					.getId());
			// CuocTtktService.getCuocTtkTrongQd(appContext, cuocTtktId)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collection dsCqtTrucThuoc = cuocTtktCu.getDsTtktCqtTrucThuoc();
		for (Iterator iter = dsCqtTrucThuoc.iterator(); iter.hasNext();) {
			TtktKhCuocTtkt element = (TtktKhCuocTtkt) iter.next();
			try {
				CuocTtktService.deleteCuocTtkt(appContext, element.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dsCqtTrucThuoc = cuocTtkt.getDsTtktCqtTrucThuoc();
		for (Iterator iter = dsCqtTrucThuoc.iterator(); iter.hasNext();) {
			TtktKhCuocTtkt element = (TtktKhCuocTtkt) iter.next();
			element.setId(null);
			try {
				CuocTtktService.saveCuocTtkt(appContext, request, element);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//dhphuc: bo sung update thong tin ngay thang rieng cho cuoc thanh tra
		/*String sqlDelete = "update ttkt_kh_cuoc_ttkt " +
				" set NIEN_DO_TU_NGAY = " + cuocTtkt.getNienDoTuNgay()
				+ ", NIEN_DO_DEN_NGAY = " + cuocTtkt.getNienDoDenNgay() 
				+ ", THOI_GIAN_DU_KIEN = " + cuocTtkt.getThoiGianDuKien()
				+ ", THOI_GIAN_DU_KIEN_TU_NGAY = " + cuocTtkt.getThoiGianDuKienTuNgay()
				+ ", THOI_GIAN_DU_KIEN_DEN_NGAY = " + cuocTtkt.getThoiGianDuKienDenNgay()
				+ " where id = " + cuocTtkt.getId();*/
		Session session = HibernateSessionFactory.currentSession();
		try{
		String sqlDelete = "update ttkt_kh_cuoc_ttkt  set NIEN_DO_TU_NGAY = ?, NIEN_DO_DEN_NGAY = ?, THOI_GIAN_DU_KIEN = ?, THOI_GIAN_DU_KIEN_TU_NGAY = ?, THOI_GIAN_DU_KIEN_DEN_NGAY = ? where id = " + cuocTtkt.getId();			
		Query q = session.createSQLQuery(sqlDelete);
		q.setParameter(0, cuocTtkt.getNienDoTuNgay());
		q.setParameter(1, cuocTtkt.getNienDoDenNgay());
		q.setParameter(2, cuocTtkt.getThoiGianDuKien());
		q.setParameter(3, cuocTtkt.getThoiGianDuKienTuNgay());
		q.setParameter(4, cuocTtkt.getThoiGianDuKienDenNgay());
		q.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}

	public static void copy(TtktKhCuocTtkt cuocTtkt,
			ApplicationContext appContext) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext()
						.lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();
			cuocTtkt.setId(KeyManagement.getGUID());
			cuocTtkt.setDonVer("4");
			dao.saveObject(appContext, cuocTtkt, Boolean.TRUE);
			Collection dsCqtTrucThuoc = cuocTtkt.getDsTtktCqtTrucThuoc();
			for (Iterator iter = dsCqtTrucThuoc.iterator(); iter.hasNext();) {
				TtktKhCuocTtkt element = (TtktKhCuocTtkt) iter.next();
				element.setId(KeyManagement.getGUID());
				element.setIdCuocTtktCha(cuocTtkt.getId());
				dao.saveObject(appContext, element, Boolean.TRUE);
				Collection dsNoidung = element.getDsNoiDungTTKT();
				for (Iterator iteratorND = dsNoidung.iterator(); iteratorND
						.hasNext();) {
					TtktKhNoiDungTtkt noidung = (TtktKhNoiDungTtkt) iteratorND
							.next();
					noidung.setId(KeyManagement.getGUID());
					noidung.setIdCuocTtkt(element.getId());
					dao.saveObject(appContext, noidung, Boolean.TRUE);
					Collection dsChiTiet = noidung.getDsChiTietNoiDung();
					if (!Formater.isNull(dsChiTiet)) {
						for (Iterator iteratorNDChiTiet = dsChiTiet.iterator(); iteratorNDChiTiet
								.hasNext();) {
							TtktKhChiTietNoiDungTtkt chiTiet = (TtktKhChiTietNoiDungTtkt) iteratorNDChiTiet
									.next();
							chiTiet.setId(KeyManagement.getGUID());
							chiTiet.setIdNoiDungTtkt(noidung.getId());
							dao.saveObject(appContext, chiTiet, Boolean.TRUE);
						}
					}
				}
			}
			session.flush();
			tx.commit();
		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}
}
