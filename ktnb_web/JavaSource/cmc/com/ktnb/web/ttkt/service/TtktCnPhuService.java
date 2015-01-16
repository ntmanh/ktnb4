/*
 * Created on Dec 24, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.service;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.UserTransaction;

import org.apache.poi.hssf.record.formula.functions.Search;
import org.apache.struts.upload.FormFile;
import org.hibernate.Criteria;
import org.hibernate.Session;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbHoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbHuy;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmBienBan;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmNhanTraHstl;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThayDoiTvd;
import cmc.com.ktnb.entity.TTKT.ket_thuc_ttkt.TtktKtBbCongBoKetLuan;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktKtChuyenGiaoHsVv;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBbMoNiemPhong;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBbNiemPhong;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBienBanKiemKe;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThGiaHan;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThKiemTraXacMinh;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThNoiDungPhucTra;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThPhucTra;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThQdKiemKe;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThQdNiemPhongHsTl;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThTrungCauGiamDinh;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThYcBsHstl;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThYeuCauGiaiTrinh;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.KtnbCache;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.web.UploadAction;
import cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.form.HoanThanhTraKiemTraForm;
import cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.form.HuyThanhTraKiemTraForm;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.BanGiaoHsVvForm;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.GiaHanForm;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.YeuCauGiaiTrinhForm;

public class TtktCnPhuService {
	private static BaseHibernateDAO dao = new BaseHibernateDAO();

	public static TtktThQdKiemKe getKiemKeTaiSan(ApplicationContext app, String id) throws Exception {

		if (id != null) {
			TtktThQdKiemKe qdkk = (TtktThQdKiemKe) dao.retrieveObject(app, TtktThQdKiemKe.class, id);
			TtktThBienBanKiemKe bbkk = getBienBanKK(app, qdkk.getId());
			qdkk.setBbKK(bbkk);
			return qdkk;
		} else
			return null;
	}

	public static TtktThBienBanKiemKe getBienBanKK(ApplicationContext app, String idBbKiemKe) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThBienBanKiemKe.class);
		criteria.addSearchItem(TtktThBienBanKiemKe.IdQdKk, idBbKiemKe);
		Collection temp = dao.retrieveObjects(app, criteria);
		// System.out.println("ket qua : "+temp.size());
		TtktThBienBanKiemKe bbkk = null;
		if (temp.size() == 0) {
			// bbkk = (TtktThBienBanKiemKe) ((ArrayList) temp).get(0);
			return bbkk;
		} else {
			bbkk = (TtktThBienBanKiemKe) ((ArrayList) temp).get(0);
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem("idMaster", bbkk.getIdDaiDienDoanTtkt());
			bbkk.setDsDoanTtkt(dao.retrieveObjects(app, criteria));

			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem("idMaster", bbkk.getIdDaiDienDviCnhanCoTskk());
			bbkk.setDsDonViCoTsKk(dao.retrieveObjects(app, criteria));
			return bbkk;
		}

	}

	public static TtktThBienBanKiemKe getBienBanKK_old(ApplicationContext app, String idBbKiemKe) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThBienBanKiemKe.class);
		criteria.addSearchItem(TtktThBienBanKiemKe.IdQdKk, idBbKiemKe);
		Collection temp = dao.retrieveObjects(app, criteria);
		TtktThBienBanKiemKe bbkk = (TtktThBienBanKiemKe) ((ArrayList) temp).get(0);
		if (Formater.isNull(temp))
			return null;
		else {
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem("idMaster", bbkk.getIdDaiDienDoanTtkt());
			bbkk.setDsDoanTtkt(dao.retrieveObjects(app, criteria));

			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem("idMaster", bbkk.getIdDaiDienDviCnhanCoTskk());
			bbkk.setDsDonViCoTsKk(dao.retrieveObjects(app, criteria));
			return bbkk;
		}

	}

	public static String saveQDKK(ApplicationContext app, TtktThQdKiemKe qdkk) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			BaseHibernateDAO dao = new BaseHibernateDAO();
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();
			if (!Formater.isNull(qdkk.getId())) {
				dao.updateObject(app, qdkk, Boolean.TRUE);
			} else {
				qdkk.setId(KeyManagement.getGUID());
				dao.saveObject(app, qdkk, Boolean.TRUE);
			}

			// saveBBKK(app, qdkk, tx, session, dao);
			session.flush();
			tx.commit();
		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
		System.out.println("id: " + qdkk.getId());
		return qdkk.getId();
	}

	public static TtktThQdKiemKe getQdKiemKe(ApplicationContext app, String idQdKiemKe) throws Exception {

		return (TtktThQdKiemKe) dao.retrieveObject(app, TtktThQdKiemKe.class, idQdKiemKe);
	}

	public static void saveBBKK(ApplicationContext app, TtktThBienBanKiemKe bbkk) throws Exception {

		UserTransaction tx = null;
		Session session = null;
		try {
			BaseHibernateDAO dao = new BaseHibernateDAO();
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();
			boolean isInsert = false;
			if (Formater.isNull(bbkk.getId())) {
				isInsert = true;
				bbkk.setId(KeyManagement.getGUID());
				bbkk.setIdDaiDienDoanTtkt(KeyManagement.getGUID());
				bbkk.setIdDaiDienDviCnhanCoTskk(KeyManagement.getGUID());
				// bbkk.setIdQdKk(qdkk.getId());

			}

			dao.saveOrUpdateObject(app, bbkk, Boolean.TRUE);
			if (!isInsert) {
				// Xoa bo cac thanh phan tham du khong con
				if (bbkk.getDsDoanTtkt() != null) {
					String sql = "delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + bbkk.getIdDaiDienDoanTtkt();
					session.createSQLQuery(sql).executeUpdate();
				}
				if (bbkk.getDsDonViCoTsKk() != null) {
					String sql2 = "delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + bbkk.getIdDaiDienDviCnhanCoTskk();
					session.createSQLQuery(sql2).executeUpdate();
				}

			}
			Collection dsDoanTtKt = bbkk.getDsDoanTtkt();
			if (dsDoanTtKt != null) {
				Iterator iter = dsDoanTtKt.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					if (isInsert)
						thanhPhanThamDu.setIdMaster(bbkk.getIdDaiDienDoanTtkt());
					dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
				}
			}

			Collection dsDvDuocKtXm = bbkk.getDsDonViCoTsKk();
			if (dsDvDuocKtXm != null) {
				Iterator iter = dsDvDuocKtXm.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					if (isInsert)
						thanhPhanThamDu.setIdMaster(bbkk.getIdDaiDienDviCnhanCoTskk());
					dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
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

	public static void saveQDKK_old(ApplicationContext app, TtktThQdKiemKe qdkk) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			BaseHibernateDAO dao = new BaseHibernateDAO();
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();
			if (!Formater.isNull(qdkk.getId())) {
				dao.updateObject(app, qdkk, Boolean.TRUE);
			} else {
				qdkk.setId(KeyManagement.getGUID());
				dao.saveObject(app, qdkk, Boolean.TRUE);
			}

			// saveBBKK(app, qdkk, tx, session, dao);
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

	public static void saveBBKK_old(ApplicationContext app, TtktThQdKiemKe qdkk, UserTransaction tx, Session session, BaseHibernateDAO dao) throws Exception {

		TtktThBienBanKiemKe bbkk = qdkk.getBbKK();
		boolean isInsert = false;
		if (Formater.isNull(bbkk.getId())) {
			isInsert = true;
			bbkk.setId(KeyManagement.getGUID());
			bbkk.setIdDaiDienDoanTtkt(KeyManagement.getGUID());
			bbkk.setIdDaiDienDviCnhanCoTskk(KeyManagement.getGUID());
			bbkk.setIdQdKk(qdkk.getId());

		}

		dao.saveOrUpdateObject(app, bbkk, Boolean.TRUE);
		if (!isInsert) {
			// Xoa bo cac thanh phan tham du khong con
			if (bbkk.getDsDoanTtkt() != null) {
				String sql = "delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + bbkk.getIdDaiDienDoanTtkt();
				session.createSQLQuery(sql).executeUpdate();
			}
			if (bbkk.getDsDonViCoTsKk() != null) {
				String sql2 = "delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + bbkk.getIdDaiDienDviCnhanCoTskk();
				session.createSQLQuery(sql2).executeUpdate();
			}

		}
		Collection dsDoanTtKt = bbkk.getDsDoanTtkt();
		if (dsDoanTtKt != null) {
			Iterator iter = dsDoanTtKt.iterator();
			while (iter.hasNext()) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
				thanhPhanThamDu.setId(KeyManagement.getGUID());
				if (isInsert)
					thanhPhanThamDu.setIdMaster(bbkk.getIdDaiDienDoanTtkt());
				dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
			}
		}

		Collection dsDvDuocKtXm = bbkk.getDsDonViCoTsKk();
		if (dsDvDuocKtXm != null) {
			Iterator iter = dsDvDuocKtXm.iterator();
			while (iter.hasNext()) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
				thanhPhanThamDu.setId(KeyManagement.getGUID());
				if (isInsert)
					thanhPhanThamDu.setIdMaster(bbkk.getIdDaiDienDviCnhanCoTskk());
				dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
			}
		}

	}

	public static TtktThKiemTraXacMinh getKiemTraXacMinh(ApplicationContext app, String id) throws Exception {

		if (id != null) {
			TtktThKiemTraXacMinh kiemTraXacMinh = (TtktThKiemTraXacMinh) dao.retrieveObject(app, TtktThKiemTraXacMinh.class, id);
			// Load thanh phan tham du doan ttkt
			SearchCriteria criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem("idMaster", kiemTraXacMinh.getThanhPhanThamDuDoanTtkt());
			kiemTraXacMinh.setDsDoanTtKt(dao.retrieveObjects(app, criteria));

			// Load thanh phan tham du doan ttkt
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem("idMaster", kiemTraXacMinh.getThanhPhanThamDuDoanDonVi());
			kiemTraXacMinh.setDsDvDuocKtXm(dao.retrieveObjects(app, criteria));

			return kiemTraXacMinh;
		} else
			return null;
	}

	public static void saveKiemTraXacMinh(TtktThKiemTraXacMinh kTxM, ApplicationContext app) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {

			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			BaseHibernateDAO dao = new BaseHibernateDAO();
			session = HibernateSessionFactory.currentSession();
			// ---------- Kiem tra xac minh ---------------
			boolean isInsert = false;
			if (Formater.isNull(kTxM.getId())) {
				isInsert = true;
				kTxM.setId(KeyManagement.getGUID());
				kTxM.setThanhPhanThamDuDoanTtkt(KeyManagement.getGUID());
				kTxM.setThanhPhanThamDuDoanDonVi(KeyManagement.getGUID());
			}
			dao.saveOrUpdateObject(app, kTxM, Boolean.TRUE);
			// ------------------ Save thanh phan tham du ----------------
			if (!isInsert) {
				// Xoa bo cac thanh phan tham du khong con
				String sql = "delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + kTxM.getThanhPhanThamDuDoanTtkt();
				session.createSQLQuery(sql).executeUpdate();
				String sql2 = "delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + kTxM.getThanhPhanThamDuDoanDonVi();
				session.createSQLQuery(sql2).executeUpdate();
			}

			Collection dsDoanTtKt = kTxM.getDsDoanTtKt();
			if (dsDoanTtKt != null) {
				Iterator iter = dsDoanTtKt.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					if (isInsert)
						thanhPhanThamDu.setIdMaster(kTxM.getThanhPhanThamDuDoanTtkt());
					dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
				}
			}

			Collection dsDvDuocKtXm = kTxM.getDsDvDuocKtXm();
			if (dsDvDuocKtXm != null) {
				Iterator iter = dsDvDuocKtXm.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					if (isInsert)
						thanhPhanThamDu.setIdMaster(kTxM.getThanhPhanThamDuDoanDonVi());
					dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
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

	public static TtktCbHuy getHuyTtKt(ApplicationContext app, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktCbHuy.class);
		criteria.addSearchItem(TtktCbHuy.IdCuocTtkt, cuocTtktId);
		Collection temp = dao.retrieveObjects(app, criteria);
		if (Formater.isNull(temp))
			return null;
		return (TtktCbHuy) ((ArrayList) temp).get(0);
	}

	public static void saveHuyTtKt(TtktCbHuy huyTtKt, ApplicationContext app, HuyThanhTraKiemTraForm form) throws Exception {

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
			BaseHibernateDAO dao = new BaseHibernateDAO();
			if (Formater.isNull(huyTtKt.getId())) {
				huyTtKt.setId(KeyManagement.getGUID());
				dao.saveObject(app, huyTtKt, Boolean.TRUE);
			} else {
				dao.updateObject(app, huyTtKt, Boolean.TRUE);
			}

			if (!Formater.isNull(huyTtKt.getSoQd())) {
				session.createSQLQuery(TtktService.buidSqlUpdateTrangThaiCuocTtkt(huyTtKt.getIdCuocTtkt(), Constants.TT_TTKT_HUY)).executeUpdate();
			}
			session.flush();
			tx.commit();
			if (!Formater.isNull(huyTtKt.getSoQd())) {
				app.setTrangThaiCuocTtkt(huyTtKt.getIdCuocTtkt(), Constants.TT_TTKT_HUY);

			}
		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}

	public static TtktCbHoan getHoanTtKt(ApplicationContext app, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktCbHoan.class);
		criteria.addSearchItem(TtktCbHoan.IdCuocTtkt, cuocTtktId);
		Collection temp = dao.retrieveObjects(app, criteria);
		if (Formater.isNull(temp))
			return null;
		return (TtktCbHoan) ((ArrayList) temp).get(0);
	}

	public static TtktCbHoan getHoanTtKtById(ApplicationContext app, String id) throws Exception {
		return (TtktCbHoan) dao.retrieveObject(app, TtktCbHoan.class, id);
	}

	public static void saveHoanTtKt(TtktCbHoan hoanTtKt, ApplicationContext app, HoanThanhTraKiemTraForm form) throws Exception {
		if (Formater.isNull(hoanTtKt.getId())) {
			insertHoan(hoanTtKt, form);
		} else {
/*			new File(UploadAction.UPLOAD_FOLDER + hoanTtKt.getIdVbXinHoan()).delete();
			new File(UploadAction.UPLOAD_FOLDER + hoanTtKt.getIdVbTraLoi()).delete();
			new File(UploadAction.UPLOAD_FOLDER + hoanTtKt.getIdVbThongBaoHoan()).delete();*/
			// Xoa DB
			Connection conn = null;
			Statement statement = null;
			try {
				conn = DataSourceConfiguration.getConnection();
				statement = conn.createStatement();
				statement.executeUpdate("delete ttkt_cb_hoan where id = '" + hoanTtKt.getId()+"'");
			} catch (Exception err) {
				throw err;
			} finally {
				DataSourceConfiguration.releaseSqlResources(null, statement, conn);
			}
			insertHoan(hoanTtKt, form);
		}
	}

	private static void insertHoan(TtktCbHoan hoanTtKt, HoanThanhTraKiemTraForm form) throws Exception {
		hoanTtKt.setId(KeyManagement.getGUID());
		// Hoan do don vi duoc thanh tra kiem tra
		if (!hoanTtKt.getCqtDeNghi().booleanValue()) {
			hoanTtKt.setIdVbTraLoi(KeyManagement.getGUID());
			hoanTtKt.setIdVbXinHoan(KeyManagement.getGUID());
		} else {// Hoan do don vi tien hanh
			hoanTtKt.setIdVbThongBaoHoan(KeyManagement.getGUID());
		}
		// Upload file
		// Neu hoan do don vi duoc Ttkt
		if (!Formater.isNull(hoanTtKt.getIdVbXinHoan())) {
			// Upload van ban xin hoan
			UploadAction.deleteFile(hoanTtKt.getIdVbXinHoan());
			UploadAction.saveFile(form.getVbXinHoanCuaDvDuocTtKt(), hoanTtKt.getIdVbXinHoan());
			// Upload van ban tra loi
			UploadAction.deleteFile(hoanTtKt.getIdVbTraLoi());
			UploadAction.saveFile(form.getVbTraLoiCuaDvTh(), hoanTtKt.getIdVbTraLoi());
		} else {
			// Upload cong van thong bao hoan
			UploadAction.deleteFile(hoanTtKt.getIdCuocTtkt());
			UploadAction.saveFile(form.getVbThongBaoHoan(), hoanTtKt.getIdCuocTtkt());
		}
		// Insert to Db
		String dvHoan = hoanTtKt.getCqtDeNghi().booleanValue() ? "1" : "0";
		String sqlInsert = "insert into TTKT_CB_HOAN (ID,ID_CUOC_TTKT,CQT_DE_NGHI,NGAY_HOAN,NGAY_BAT_DAU_LAI," + "NGAY_BAT_DAU_THUC_TE, LY_DO_HOAN";
		if (dvHoan.equals("0")) {
			sqlInsert += ", VB_XIN_HOAN_CUA_DV_DUOC_TTKT, TEN_FILE_VB_XIN_HOAN, LOAI_FILE_VB_XIN_HOAN";
			sqlInsert += ", VB_TRA_LOI_CUA_DV_TH, TEN_FILE_VB_TRA_LOI_HOAN, LOAI_FILE_VB_TRA_LOI_HOAN";
			sqlInsert += ", ID_VB_XIN_HOAN, ID_VB_TRA_LOI)";
		} else {
			sqlInsert += ", VB_THONG_BAO_HOAN, TEN_FILE_THONG_BAO_HOAN, LOAI_FILE_THONG_BAO_HOAN, ID_VB_THONG_BAO_HOAN)";
		}

		sqlInsert += " values (";
		sqlInsert += "'" + hoanTtKt.getId() + "'";
		sqlInsert += ",'" + hoanTtKt.getIdCuocTtkt() + "'";
		sqlInsert += ",'" + dvHoan + "'";
		sqlInsert += ",to_date('" + hoanTtKt.getNgayHoan() + "','yyyy-mm-dd')";
		sqlInsert += ",to_date('" + hoanTtKt.getNgayBatDauLai() + "','yyyy-mm-dd')";
		sqlInsert += ",to_date('" + hoanTtKt.getNgayBatDauThucTe() + "','yyyy-mm-dd')";
		sqlInsert += ",'" + hoanTtKt.getLyDoHoan() + "'";
		if (dvHoan.equals("0")) {
			sqlInsert += ", BFILENAME('KTNB_FILE_DIR','" + hoanTtKt.getIdVbXinHoan() + "'), '" + form.getVbXinHoanCuaDvDuocTtKt().getFileName() + "', '" + form.getVbXinHoanCuaDvDuocTtKt().getContentType() + "'";
			sqlInsert += ", BFILENAME('KTNB_FILE_DIR','" + hoanTtKt.getIdVbTraLoi() + "'),'" + form.getVbTraLoiCuaDvTh().getFileName() + "','" + form.getVbTraLoiCuaDvTh().getContentType() + "'";
			sqlInsert += ",'" + hoanTtKt.getIdVbXinHoan() + "','" + hoanTtKt.getIdVbTraLoi() + "'";
		} else {
			sqlInsert += ", BFILENAME('KTNB_FILE_DIR','" + hoanTtKt.getIdVbThongBaoHoan() + "'), '" + form.getVbThongBaoHoan().getFileName() + "', '" + form.getVbThongBaoHoan().getContentType() + "', '" + hoanTtKt.getIdVbThongBaoHoan() + "'";
		}
		sqlInsert += ")";
		System.out.print("sqlInsert: " + sqlInsert + "\n");
		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			statement.executeUpdate(sqlInsert);
		} catch (Exception err) {
			err.printStackTrace();
			UploadAction.deleteFile(hoanTtKt.getIdVbThongBaoHoan());
			UploadAction.deleteFile(hoanTtKt.getIdVbXinHoan());
			UploadAction.deleteFile(hoanTtKt.getIdVbTraLoi());
			throw err;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}

	}

	public static void deleteYeuCauBaoCaoHsTl(TtktThYcBsHstl ycbstl, HttpServletRequest request, ApplicationContext app) throws Exception {

		TtktCmNhanTraHstl bbNhan = ycbstl.getBbNhan();
		TtktCmNhanTraHstl bbGiao = ycbstl.getBbGiao();
		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			// xoa yeu cau
			if (ycbstl != null) {
				String sql = "delete TTKT_TH_YC_BS_HSTL where ID =" + ycbstl.getId();
				statement.addBatch(sql);
			}

			// xoa bien ban giao nhan
			if (bbNhan != null) {
				String sql2 = "delete TTKT_CM_NHAN_TRA_HSTL where ID = " + bbNhan.getId();
				statement.addBatch(sql2);
				String sql3 = "delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER=" + bbNhan.getIdDaiDienBenNhan();
				statement.addBatch(sql3);
				String sql4 = "delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER=" + bbNhan.getIdDaiDienBenGiao();
				statement.addBatch(sql4);
			}
			// xoa bien ban giao tra
			if (bbGiao != null) {
				String sql5 = "delete TTKT_CM_NHAN_TRA_HSTL where ID = " + bbGiao.getId();
				statement.addBatch(sql5);
				String sql6 = "delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER=" + bbGiao.getIdDaiDienBenGiao();
				statement.addBatch(sql6);
				String sql7 = "delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER=" + bbGiao.getIdDaiDienBenNhan();
				statement.addBatch(sql7);
			}
			statement.executeBatch();
			conn.commit();
		} catch (Exception e) {

		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}

	}

	public static TtktCmNhanTraHstl getHsTl(ApplicationContext app, String idTdYcBsHstl, String loai) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktCmNhanTraHstl.class);
		criteria.addSearchItem(TtktCmNhanTraHstl.IdTdYcBsHstl, idTdYcBsHstl);
		criteria.addSearchItem(TtktCmNhanTraHstl.Loai, loai);
		Collection temp = dao.retrieveObjects(app, criteria);
		if (Formater.isNull(temp))
			return null;
		else {
			TtktCmNhanTraHstl hstl = (TtktCmNhanTraHstl) ((ArrayList) temp).get(0);

			// Load thanh phan tham du giao ho so
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem("idMaster", hstl.getIdDaiDienBenGiao());
			hstl.setDaiDienBenGiao(dao.retrieveObjects(app, criteria));

			// Load thanh phan tham du nhan
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem("idMaster", hstl.getIdDaiDienBenNhan());
			hstl.setDaiDienBenNhan(dao.retrieveObjects(app, criteria));

			return hstl;
		}

	}

	public static TtktThYcBsHstl getYcBsHsTl(ApplicationContext app, String id) throws Exception {
		if (id != null) {
			TtktThYcBsHstl hstl = (TtktThYcBsHstl) dao.retrieveObject(app, TtktThYcBsHstl.class, id);
			// ban giao tra
			TtktCmNhanTraHstl bbGiaotra = getHsTl(app, hstl.getId(), Constants.TT_TTKT_BBGIAOTRA_YCBSTL);
			hstl.setBbGiao(bbGiaotra);

			// set bien ban giao nhan
			TtktCmNhanTraHstl bbGiaoNhan = getHsTl(app, hstl.getId(), Constants.TT_TTKT_BBGIAONHAN_YCBSTL);
			hstl.setBbNhan(bbGiaoNhan);
			return hstl;
		} else
			return null;

	}

	public static TtktThYcBsHstl saveYeuCauBsTl(TtktThYcBsHstl ycbstl, HttpServletRequest request, ApplicationContext app) throws Exception {
		if (Formater.isNull(ycbstl.getId())) {
			ycbstl.setId(KeyManagement.getGUID());
			return (TtktThYcBsHstl) dao.saveObject(app, ycbstl);
		} else {
			dao.updateObject(app, ycbstl);
			return ycbstl;
		}
	}

	public static void saveBB_Tra_Nhan(ApplicationContext app, TtktCmNhanTraHstl bbTraNhan, Boolean isInTrans, boolean isInsert, UserTransaction tx, Session session, BaseHibernateDAO dao) throws Exception {
		if (isInsert) {
			bbTraNhan.setIdDaiDienBenGiao(KeyManagement.getGUID());
			bbTraNhan.setIdDaiDienBenNhan(KeyManagement.getGUID());
		} else {
			// Xoa bo cac thanh phan tham du khong con
			String sql = "delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + bbTraNhan.getIdDaiDienBenGiao();
			session.createSQLQuery(sql).executeUpdate();
			String sql2 = "delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + bbTraNhan.getIdDaiDienBenNhan();
			session.createSQLQuery(sql2).executeUpdate();
		}
		dao.saveOrUpdateObject(app, bbTraNhan, isInTrans);

		// Save danh sach dai dien ben giao
		Collection daiDienGiao = bbTraNhan.getDaiDienBenGiao();
		if (daiDienGiao != null) {
			Iterator iter = daiDienGiao.iterator();
			while (iter.hasNext()) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
				thanhPhanThamDu.setId(KeyManagement.getGUID());
				if (isInsert)
					thanhPhanThamDu.setIdMaster(bbTraNhan.getIdDaiDienBenGiao());
				dao.saveObject(app, thanhPhanThamDu, isInTrans);
			}
		}

		// Save danh sach dai dien ben nhan
		Collection daiDienNhan = bbTraNhan.getDaiDienBenNhan();
		if (daiDienNhan != null) {
			Iterator iter = daiDienNhan.iterator();
			while (iter.hasNext()) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
				thanhPhanThamDu.setId(KeyManagement.getGUID());
				if (isInsert)
					thanhPhanThamDu.setIdMaster(bbTraNhan.getIdDaiDienBenNhan());
				dao.saveObject(app, thanhPhanThamDu, isInTrans);
			}
		}

	}

	// ---------------------------- Trung cau giam dinh
	// -----------------------------------------
	public static TtktThTrungCauGiamDinh getTcGd(ApplicationContext app, String id) throws Exception {
		TtktThTrungCauGiamDinh hstl;
		if (id != null) {
			hstl = (TtktThTrungCauGiamDinh) dao.retrieveObject(app, TtktThTrungCauGiamDinh.class, id);
			return hstl;
		} else
			return null;
	}

	public static void saveTrungCauGiamDinh(TtktThTrungCauGiamDinh tcgd, ApplicationContext app) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {

			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			BaseHibernateDAO dao = new BaseHibernateDAO();
			session = HibernateSessionFactory.currentSession();
			if (Formater.isNull(tcgd.getId())) {
				tcgd.setId(KeyManagement.getGUID());
				tcgd.setIdCqtGiamDinh(KeyManagement.getGUID());
				// set tam thoi
				tcgd.setIdCqtTrungCau(KeyManagement.getGUID());
			}
			dao.saveOrUpdateObject(app, tcgd, Boolean.TRUE);
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

	// ----------------------------- Gia han thanh tra kiem tra
	// -------------------------------------------
	public static TtktThGiaHan getGiaHanTtKtById(ApplicationContext app, String id) throws Exception {
		return (TtktThGiaHan) dao.retrieveObject(app, TtktThGiaHan.class, id);
	}

	public static TtktThGiaHan getGiaHanTtKtByIdCuocTtkt(ApplicationContext app, String idCuocTtkt) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThGiaHan.class);
		criteria.addSearchItem("idCuocTtkt", idCuocTtkt);
		Collection temp = dao.retrieveObjects(app, criteria);
		if (Formater.isNull(temp))
			return null;
		return (TtktThGiaHan) ((ArrayList) temp).get(0);

	}

	public static void saveGiaHan(TtktThGiaHan giahan, ApplicationContext app, GiaHanForm form) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {

			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			BaseHibernateDAO dao = new BaseHibernateDAO();
			session = HibernateSessionFactory.currentSession();
			if (Formater.isNull(giahan.getId())) {
				giahan.setId(KeyManagement.getGUID());
				dao.saveObject(app, giahan, Boolean.TRUE);
			} else {
				dao.updateObject(app, giahan, Boolean.TRUE);
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

	// ----------------------------- Yeu cau giai trinh
	// ---------------------------------
	public static TtktThYeuCauGiaiTrinh getYeuCauGT(ApplicationContext app, String id) throws Exception {
		return (TtktThYeuCauGiaiTrinh) dao.retrieveObject(app, TtktThYeuCauGiaiTrinh.class, id);
	}

	public static void saveYeuCauGiaiTrinh(TtktThYeuCauGiaiTrinh ycBcGt, ApplicationContext app, YeuCauGiaiTrinhForm form, String ngayGuiGT) throws Exception {
		Connection conn = null;
		Statement statement = null;
		String sql;
		FormFile f = form.getBaoCao();
		String loaiFile = "application/msword";
		String uploadF = UploadAction.UPLOAD_FOLDER;
		String tenFile="";
		if(f!=null)
		{
			loaiFile = form.getBaoCao().getContentType();
			tenFile=f.getFileName();
			if(UploadAction.isImageFile(tenFile))
				uploadF = UploadAction.UPLOAD_FOLDER_IMGS;				
		}
		// Xoa file cu
		if (!Formater.isNull(ycBcGt.getId())) {
			new File(uploadF + ycBcGt.getId()).delete();
			try {
				// ghi file moi
				FileOutputStream fileOutputStream = new FileOutputStream(uploadF + ycBcGt.getId());
				fileOutputStream.write(form.getBaoCao().getFileData());
				fileOutputStream.close();

			} catch (Exception e) {
				e.printStackTrace();
			} 
			try {       
				conn = DataSourceConfiguration.getConnection();
				sql = "update TTKT_TH_YEU_CAU_GIAI_TRINH set " + "ID_CUOC_TTKT= '" + ycBcGt.getIdCuocTtkt() + "',NGAY_LAP_PHIEU=" + "to_date('" + ycBcGt.getNgayLapPhieu() + "','yyyy_mm_dd')"
						+ ",NAM_SINH_NGUOI_GIAI_TRINH=" + "to_date('" + ycBcGt.getNamSinhNguoiGiaiTrinh() + "','yyyy_mm_dd')"
						+ ",NOI_LAP_PHIEU='" + ycBcGt.getNoiLapPhieu() + "',ID_NGUOI_GIAI_TRINH='" + ycBcGt.getIdNguoiGiaiTrinh() + "',TEN_NGUOI_GIAI_TRINH='" + ycBcGt.getTenNguoiGiaiTrinh()
						+ "',DV_CONG_TAC_NGUOI_GIAI_TRINH='" + ycBcGt.getDvCongTacNguoiGiaiTrinh() + "',NOI_DUNG_GIAI_TRINH='" + ycBcGt.getNoiDungGiaiTrinh()
						+ "', THOI_GIAN_GUI_GIAI_TRINH =to_date('" + ngayGuiGT + "','hh24:mi dd/mm/yyyy' ),NOI_GUI_GIAI_TRINH='" + ycBcGt.getNoiGuiGiaiTrinh() + "',  DIA_DIEM_BAO_CAO_GIAI_TRINH='"
						+ ycBcGt.getDiaDiemBaoCaoGiaiTrinh() + "',  THOI_GIAN_BAO_CAO_GIAI_TRINH=to_date('" + form.getTgBCGT() + "','hh24:mi dd/mm/yyyy'),NOI_DUNG_BAO_CAO_GIAI_TRINH='"
						+ ycBcGt.getNoiDungBaoCaoGiaiTrinh() + "',FILE_BAO_CAO_GIAI_TRINH= " + "BFILENAME('" + uploadF + "','" + ycBcGt.getId() + "')," + " HSTL_BC= '" + form.getHoSoTaiLieuBC()
						+ "', CHUC_VU_NG_GT='" + form.getCvNguoiLapPhieu() + "', LOAI_FILE='" + loaiFile + "',TEN_FILE='" + tenFile + "' where ID = '" + ycBcGt.getId() + "'";
				statement = conn.createStatement();
				statement.executeUpdate(sql);
				conn.commit();
			} catch (Exception err) {
				conn.rollback();
				throw err;
			} finally {
				DataSourceConfiguration.releaseSqlResources(null, statement, conn);
			}
			return;
		} else {
			// Cap nhat database
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			ycBcGt.setId(KeyManagement.getGUID());
			form.setId(ycBcGt.getId());
			// save file
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(uploadF + ycBcGt.getId());
				fileOutputStream.write(form.getBaoCao().getFileData());
				fileOutputStream.close();
			} catch (Exception err) {
				err.printStackTrace();
			}  
			try {
				String sqlInsertFile = "insert into TTKT_TH_YEU_CAU_GIAI_TRINH (ID,ID_CUOC_TTKT,NGAY_LAP_PHIEU,NAM_SINH_NGUOI_GIAI_TRINH,NOI_LAP_PHIEU,ID_NGUOI_GIAI_TRINH,TEN_NGUOI_GIAI_TRINH"
						+ ", DV_CONG_TAC_NGUOI_GIAI_TRINH,NOI_DUNG_GIAI_TRINH,THOI_GIAN_GUI_GIAI_TRINH,NOI_GUI_GIAI_TRINH "
						+ ",DIA_DIEM_BAO_CAO_GIAI_TRINH,THOI_GIAN_BAO_CAO_GIAI_TRINH,NOI_DUNG_BAO_CAO_GIAI_TRINH,FILE_BAO_CAO_GIAI_TRINH,HSTL_BC,CHUC_VU_NG_GT,LOAI_FILE,TEN_FILE" + " )values ('"
						+ ycBcGt.getId() + "','" + ycBcGt.getIdCuocTtkt() + "',to_date('" + ycBcGt.getNgayLapPhieu() + "','yyyy-mm-dd'),"+"to_date('" + ycBcGt.getNgayLapPhieu() + "','yyyy-mm-dd'),'" + ycBcGt.getNoiLapPhieu() + "','"
						+ ycBcGt.getIdNguoiGiaiTrinh() + "','" + ycBcGt.getTenNguoiGiaiTrinh() + "','" + ycBcGt.getDvCongTacNguoiGiaiTrinh() + "','" + ycBcGt.getNoiDungGiaiTrinh() + "',to_date('"
						+ ngayGuiGT + "','hh24:mi dd/mm/yyyy'),'" + ycBcGt.getNoiGuiGiaiTrinh() + "','" + ycBcGt.getDiaDiemBaoCaoGiaiTrinh() + "',to_date('" + form.getTgBCGT()
						+ "','hh24:mi dd/mm/yyyy'),'" + ycBcGt.getNoiDungBaoCaoGiaiTrinh() + "'," + "BFILENAME('" + uploadF + "','" + ycBcGt.getId() + "'),'" + form.getHoSoTaiLieuBC() + "','"
						+ form.getCvNguoiLapPhieu() + "','" + loaiFile + "','" + tenFile + "')";
				System.out.println("SQL :"+sqlInsertFile);
				statement.addBatch(sqlInsertFile);
				statement.executeBatch();
				statement.close();
				conn.commit();
				form.setId(ycBcGt.getId());
			} catch (Exception ex) {
				conn.rollback();
				throw ex;
			} finally {
				DataSourceConfiguration.releaseSqlResources(null, statement, conn);
			}

		}
	}

	// ---------------------------------- Chuyen giao ho so vu viec

	public static TtktKtChuyenGiaoHsVv getHoSoVv(ApplicationContext app, String id) throws Exception {
		if (id != null) {
			TtktKtChuyenGiaoHsVv hoSoVv = (TtktKtChuyenGiaoHsVv) dao.retrieveObject(app, TtktKtChuyenGiaoHsVv.class, id);
			SearchCriteria criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem("idMaster", hoSoVv.getTpThamDuDoanTtkt());
			hoSoVv.setDsDaiDien(dao.retrieveObjects(app, criteria));

			// Load thanh phan tham du doan ttkt
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem("idMaster", hoSoVv.getTpThamDuCqDieuTra());
			hoSoVv.setDsDaiDienCqDt(dao.retrieveObjects(app, criteria));
			return hoSoVv;
		} else
			return null;

	}

	public static void saveHoSoVv(TtktKtChuyenGiaoHsVv kTxM, ApplicationContext app, BanGiaoHsVvForm form) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {

			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			BaseHibernateDAO dao = new BaseHibernateDAO();
			session = HibernateSessionFactory.currentSession();
			// ---------- Ho so vu viec ---------------
			boolean isInsert = false;
			if (Formater.isNull(kTxM.getId())) {
				isInsert = true;
				kTxM.setId(KeyManagement.getGUID());
				kTxM.setTpThamDuDoanTtkt(KeyManagement.getGUID());
				kTxM.setTpThamDuCqDieuTra(KeyManagement.getGUID());
				form.setId(kTxM.getId());
			}
			dao.saveOrUpdateObject(app, kTxM, Boolean.TRUE);
			// ------------------ Save thanh phan tham du ----------------
			if (!isInsert) {
				// Xoa bo cac thanh phan tham du khong con
				String sql = "delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + kTxM.getTpThamDuDoanTtkt();
				session.createSQLQuery(sql).executeUpdate();
				String sql2 = "delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + kTxM.getTpThamDuCqDieuTra();
				session.createSQLQuery(sql2).executeUpdate();
			}

			Collection dsDoanTtKt = kTxM.getDsDaiDien();
			if (dsDoanTtKt != null) {
				Iterator iter = dsDoanTtKt.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					if (isInsert)
						thanhPhanThamDu.setIdMaster(kTxM.getTpThamDuDoanTtkt());
					dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
				}
			}

			Collection dsDvDuocKtXm = kTxM.getDsDaiDienCqDt();
			if (dsDvDuocKtXm != null) {
				Iterator iter = dsDvDuocKtXm.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					if (isInsert)
						thanhPhanThamDu.setIdMaster(kTxM.getTpThamDuCqDieuTra());
					dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
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

	// ---------------------------------- Cong Bo Ket Luan
	// -----------------------------------------

	public static TtktKtBbCongBoKetLuan getCongBoKl(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktKtBbCongBoKetLuan.class);
		criteria.addSearchItem(TtktKtBbCongBoKetLuan.IdCuocTtkt, cuocTtktId);
		ArrayList lstTemp = (ArrayList) dao.retrieveObjects(appContext, criteria);
		if (Formater.isNull(lstTemp))
			return null;
		TtktKtBbCongBoKetLuan congBoQd = (TtktKtBbCongBoKetLuan) ((ArrayList) lstTemp).get(0);

		// Dai dien co quan tien hanh ttkt
		String idDaiDienCqBanHanhQd = congBoQd.getTpThamDuCqtTienHanh();
		if (!Formater.isNull(idDaiDienCqBanHanhQd)) {
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem(TtktCmThanhPhanThamDu.IdMaster, idDaiDienCqBanHanhQd);
			congBoQd.setDsTptdCqtTienHanh(dao.retrieveObjects(appContext, criteria));
		}

		// Dai dien don vi ca nhan co lien quan
		String idDaiDienCqqlCapTren = congBoQd.getTpThamDuCquanTchucCnhan();
		if (!Formater.isNull(idDaiDienCqqlCapTren)) {
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem(TtktCmThanhPhanThamDu.IdMaster, idDaiDienCqqlCapTren);
			congBoQd.setDsTptdCquanTchucCnhan(dao.retrieveObjects(appContext, criteria));
		}

		// Dai dien doan Ttkt
		String idDaiDienDoanTtkt = congBoQd.getTpThamDuDoanTtkt();
		if (!Formater.isNull(idDaiDienDoanTtkt)) {
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem(TtktCmThanhPhanThamDu.IdMaster, idDaiDienDoanTtkt);
			congBoQd.setDsTptdDoanTtkt(dao.retrieveObjects(appContext, criteria));
		}

		// Dai dien don vi duoc Ttkt
		String idDaiDienDonViDuocTtkt = congBoQd.getTpThamDuDviDuocTtkt();
		if (!Formater.isNull(idDaiDienDoanTtkt)) {
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem(TtktCmThanhPhanThamDu.IdMaster, idDaiDienDonViDuocTtkt);
			congBoQd.setDsTptdDviDuocTtkt(dao.retrieveObjects(appContext, criteria));
		}
		return congBoQd;
	}

	public static void saveCongBoKetLuan(ApplicationContext appContext, TtktKtBbCongBoKetLuan congBoKl) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
				throw e1;
			}
			session = HibernateSessionFactory.currentSession();
			BaseHibernateDAO dao = new BaseHibernateDAO();

			if (Formater.isNull(congBoKl.getId())) {
				congBoKl.setId(KeyManagement.getGUID());
				// if (isNewStatus(appContext, Constants.TT_TTKT_CBQD))
				// session.createSQLQuery("UPDATE TTKT_KH_CUOC_TTKT set
				// TRANG_THAI= '" + Constants.TT_TTKT_CBQD + "' WHERE id=" +
				// congBoKl.getIdCuocTtkt()).executeUpdate();
				// appContext.setTrangThaiCuocTtkt(Constants.TT_TTKT_CBQD);
			}

			// Save thanh phan tham du cqt ban hanh
			if (Formater.isNull(congBoKl.getTpThamDuCqtTienHanh()) && !Formater.isNull(congBoKl.getDsTptdCqtTienHanh())) {
				congBoKl.setTpThamDuCqtTienHanh(KeyManagement.getGUID());
			} else
				// Xoa thanh phan tham du cqt ban hanh cu
				session.createSQLQuery("delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER = '" + congBoKl.getTpThamDuCqtTienHanh() + "'").executeUpdate();
			// Luu thanh phan tham du cqt ban hanh moi
			Collection dsTpThamDuCqtBanHanh = (Collection) congBoKl.getDsTptdCqtTienHanh();
			if (!Formater.isNull(dsTpThamDuCqtBanHanh)) {
				Iterator iter = dsTpThamDuCqtBanHanh.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setIdMaster(congBoKl.getTpThamDuCqtTienHanh());
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					dao.saveObject(appContext, thanhPhanThamDu, Boolean.TRUE);
				}
			}

			// Save thanh phan tham du doan ttkt
			if (Formater.isNull(congBoKl.getTpThamDuDoanTtkt()) && !Formater.isNull(congBoKl.getDsTptdDoanTtkt()))
				congBoKl.setTpThamDuDoanTtkt(KeyManagement.getGUID());
			else
				// Xoa thanh phan tham du co quan ql cap tren cu
				session.createSQLQuery("delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER = '" + congBoKl.getTpThamDuDoanTtkt() + "'").executeUpdate();
			// Luu thanh phan tham du co quan ql cap tren moi
			Collection dsTpThamDuCqqlCapTren = congBoKl.getDsTptdDoanTtkt();
			if (!Formater.isNull(dsTpThamDuCqqlCapTren)) {
				Iterator iter = dsTpThamDuCqqlCapTren.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setIdMaster(congBoKl.getTpThamDuDoanTtkt());
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					dao.saveObject(appContext, thanhPhanThamDu, Boolean.TRUE);
				}
			}

			// Dai dien doan co quan thue duoc TtKt
			if (Formater.isNull(congBoKl.getTpThamDuDviDuocTtkt()) && !Formater.isNull(congBoKl.getDsTptdDviDuocTtkt()))
				congBoKl.setTpThamDuDviDuocTtkt(KeyManagement.getGUID());
			else
				// Xoa Dai dien doan co quan thue duoc TtKt cu
				session.createSQLQuery("delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER = '" + congBoKl.getTpThamDuDviDuocTtkt() + "'").executeUpdate();
			// Luu thanh phan tham du co quan the duoc TtKt
			Collection dsDaiDienDoanTtkt = congBoKl.getDsTptdDviDuocTtkt();
			if (!Formater.isNull(dsDaiDienDoanTtkt)) {
				Iterator iter = dsDaiDienDoanTtkt.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setIdMaster(congBoKl.getTpThamDuDviDuocTtkt());
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					dao.saveObject(appContext, thanhPhanThamDu, Boolean.TRUE);
				}
			}

			// Dai dien co quan to chuc ca nhan
			if (Formater.isNull(congBoKl.getTpThamDuCquanTchucCnhan()) && !Formater.isNull(congBoKl.getDsTptdCquanTchucCnhan()))
				congBoKl.setTpThamDuCquanTchucCnhan(KeyManagement.getGUID());
			else
				// Xoa thanh phan co quan to chuc ca nhan cu
				session.createSQLQuery("delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER = '" + congBoKl.getTpThamDuCquanTchucCnhan() + "'").executeUpdate();
			// Luu thanh phan co quan to chuc ca nha moi
			Collection dsDaiDienDonViDuocTtkt = congBoKl.getDsTptdCquanTchucCnhan();
			if (!Formater.isNull(dsDaiDienDonViDuocTtkt)) {
				Iterator iter = dsDaiDienDonViDuocTtkt.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setIdMaster(congBoKl.getTpThamDuCquanTchucCnhan());
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					dao.saveObject(appContext, thanhPhanThamDu, Boolean.TRUE);
				}
			}

			// Save cong bo ket luan
			dao.saveOrUpdateObject(appContext, congBoKl, Boolean.TRUE);

			session.flush();
			tx.commit();
		} catch (Exception e) {
			// appContext.setTrangThaiCuocTtkt(Constants.TT_TTKT_HOP);
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}

	// ------------------------------ bien ban lam viec
	// ----------------------------

	public static TtktCmBienBan getBienBanLamViec(ApplicationContext app, String cuocTtktId, String loaiBB) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktCmBienBan.class);
		criteria.addSearchItem(TtktCmBienBan.IdCuocTtkt, cuocTtktId);
		criteria.addSearchItem(TtktCmBienBan.Loai, loaiBB);
		Collection temp = dao.retrieveObjects(app, criteria);
		if (Formater.isNull(temp))
			return null;

		TtktCmBienBan bbLamViec = (TtktCmBienBan) ((ArrayList) temp).get(0);
		// Load thanh phan tham du doan ttkt
		criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
		criteria.addSearchItem("idMaster", bbLamViec.getTpThamDuDoanTtkt());
		bbLamViec.setDoanTtKt(dao.retrieveObjects(app, criteria));

		// Load thanh phan tham du doan ttkt
		criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
		criteria.addSearchItem("idMaster", bbLamViec.getTpThamDuKhac());
		bbLamViec.setThanhPhanThamDu(dao.retrieveObjects(app, criteria));

		return bbLamViec;
	}

	public static void saveBienBanLamViec(TtktCmBienBan bbLamViec, ApplicationContext app) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {

			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			BaseHibernateDAO dao = new BaseHibernateDAO();
			session = HibernateSessionFactory.currentSession();

			if (Formater.isNull(bbLamViec.getId())) {

				bbLamViec.setId(KeyManagement.getGUID());
				bbLamViec.setTpThamDuDoanTtkt(KeyManagement.getGUID());
				bbLamViec.setTpThamDuKhac(KeyManagement.getGUID());
				dao.saveObject(app, bbLamViec, Boolean.TRUE);
			} else {
				dao.updateObject(app, bbLamViec, Boolean.TRUE);
				session.createSQLQuery("delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + bbLamViec.getTpThamDuDoanTtkt()).executeUpdate();
				session.createSQLQuery("delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + bbLamViec.getTpThamDuKhac()).executeUpdate();
			}

			Collection dsThamDuDoanTtKt = bbLamViec.getDoanTtKt();
			if (dsThamDuDoanTtKt != null) {
				Iterator iter = dsThamDuDoanTtKt.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					thanhPhanThamDu.setIdMaster(bbLamViec.getTpThamDuDoanTtkt());
					dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
				}
			}

			Collection dsThamDuKhac = bbLamViec.getThanhPhanThamDu();
			if (dsThamDuKhac != null) {
				Iterator iter = dsThamDuKhac.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					thanhPhanThamDu.setIdMaster(bbLamViec.getTpThamDuKhac());
					dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
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

	// ---------------------------- Danh sach tim kiem
	// -------------------------------------------

	// ------------------- danh sach yeu cau bao cao ho so tai lieu
	// --------------------------
	public static Collection getDSYeuCauBaoCaoHsTl(ApplicationContext app, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThYcBsHstl.class);
		criteria.addSearchItem(TtktThYcBsHstl.IdCuocTtkt, cuocTtktId);
		Collection temp = dao.retrieveObjects(app, criteria);
		if (Formater.isNull(temp))
			return null;
		else
			return temp;
	}

	// ---------------------- danh sach Niem phong ho so tai lieu
	// -----------------------------------

	public static Collection getDsNiemPhongHsTl(ApplicationContext app, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThQdNiemPhongHsTl.class);
		criteria.addSearchItem(TtktThQdNiemPhongHsTl.IdCuocTtkt, cuocTtktId);
		Collection temp = dao.retrieveObjects(app, criteria);
		if (Formater.isNull(temp))
			return null;
		else
			return temp;
	}

	// ----------------------- danh sach Yeu cau giai trinh
	// -------------------------------------------
	public static Collection getDsYCGiaiTrinh(ApplicationContext app, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThYeuCauGiaiTrinh.class);
		criteria.addSearchItem(TtktThYeuCauGiaiTrinh.IdCuocTtkt, cuocTtktId);
		return dao.retrieveObjects(app, criteria);

	}

	public static void deleteYCGiaiTrinh(TtktThYeuCauGiaiTrinh ycGT, HttpServletRequest request, ApplicationContext app) throws Exception {

		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			// xoa yeu cau
			if (ycGT != null) {
				String sql = "delete TTKT_TH_YEU_CAU_GIAI_TRINH where ID =" + ycGT.getId();
				statement.addBatch(sql);
			}
			statement.executeBatch();
			conn.commit();
		} catch (Exception e) {

		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}

	}

	// ------------------------------ds Kiem tra xac minh
	// -------------------------------------------
	public static Collection getDsKTXacMinh(ApplicationContext app, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThKiemTraXacMinh.class);
		criteria.addSearchItem(TtktThKiemTraXacMinh.IdCuocTtkt, cuocTtktId);
		Collection temp = dao.retrieveObjects(app, criteria);
		if (Formater.isNull(temp))
			return null;
		else
			return temp;

	}

	public static void deleteKTXacMinh(TtktThKiemTraXacMinh ktXM, HttpServletRequest request, ApplicationContext app) throws Exception {

		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			// xoa yeu cau
			if (ktXM != null) {
				String sql = "delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER=" + ktXM.getThanhPhanThamDuDoanDonVi();
				statement.addBatch(sql);
				sql = "delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER=" + ktXM.getThanhPhanThamDuDoanTtkt();
				statement.addBatch(sql);
				sql = "delete TTKT_TH_KIEM_TRA_XAC_MINH where ID =" + ktXM.getId();
				statement.addBatch(sql);
			}
			statement.executeBatch();
			conn.commit();
		} catch (Exception e) {

		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}
	}

	public static Collection getDsTCGiamDinh(ApplicationContext app, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThTrungCauGiamDinh.class);
		criteria.addSearchItem(TtktThTrungCauGiamDinh.IdCuocTtkt, cuocTtktId);
		Collection temp = dao.retrieveObjects(app, criteria);
		if (Formater.isNull(temp))
			return null;
		else
			return temp;

	}

	public static void deleteTCGiamDinh(TtktThTrungCauGiamDinh tcGD, HttpServletRequest request, ApplicationContext app) throws Exception {

		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			// xoa yeu cau
			if (tcGD != null) {
				String sql = "delete TTKT_TH_TRUNG_CAU_GIAM_DINH where ID =" + tcGD.getId();
				statement.addBatch(sql);
			}
			statement.executeBatch();
			conn.commit();
		} catch (Exception e) {

		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}

	}

	public static Collection getDsHSVuViec(ApplicationContext app, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktKtChuyenGiaoHsVv.class);
		criteria.addSearchItem(TtktKtChuyenGiaoHsVv.IdCuocTtkt, cuocTtktId);
		Collection temp = dao.retrieveObjects(app, criteria);
		if (Formater.isNull(temp))
			return null;
		else
			return temp;

	}

	public static void deleteHSVuViec(TtktKtChuyenGiaoHsVv hsvv, HttpServletRequest request, ApplicationContext app) throws Exception {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			// xoa yeu cau
			if (hsvv != null) {
				String sql = "delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER=" + hsvv.getTpThamDuCqDieuTra();
				statement.addBatch(sql);

				sql = "delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER=" + hsvv.getTpThamDuDoanTtkt();
				statement.addBatch(sql);

				sql = "delete TTKT_KT_CHUYEN_GIAO_HS_VV where ID =" + hsvv.getId();
				statement.addBatch(sql);
			}
			statement.executeBatch();
			conn.commit();
		} catch (Exception e) {

		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}
	}

	public static Collection getDsGiaHan(ApplicationContext app, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThGiaHan.class);
		criteria.addSearchItem(TtktThGiaHan.IdCuocTtkt, cuocTtktId);
		criteria.addOrderItem("ngayRqQd");
		Collection temp = dao.retrieveObjects(app, criteria);
		if (Formater.isNull(temp))
			return null;
		else
			return temp;

	}

	public static void deleteGiaHan(TtktThGiaHan giaHan, HttpServletRequest request, ApplicationContext app) throws Exception {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			// xoa yeu cau
			if (giaHan != null) {
				String sql = "delete TTKT_TH_GIA_HAN where ID =" + giaHan.getId();
				statement.addBatch(sql);
			}
			statement.executeBatch();
			conn.commit();
		} catch (Exception e) {

		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}
	}

	/**
	 * @param appContext
	 * @param cuocTtktId
	 */
	public static Collection getDsYcBsHsTl(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThYcBsHstl.class);
		criteria.addSearchItem("idCuocTtkt", cuocTtktId);
		return dao.retrieveObjects(appContext, criteria);

	}

	public static Collection getDsQdKk(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThQdKiemKe.class);
		criteria.addSearchItem("idCuocTtkt", cuocTtktId);
		return dao.retrieveObjects(appContext, criteria);
	}

	public static void deleteQdKk(TtktThQdKiemKe qdkk, HttpServletRequest request, ApplicationContext app) throws Exception {
		Connection conn = null;
		Statement statement = null;

		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			String sql;
			// xoa yeu cau
			if (qdkk != null) {
				TtktThBienBanKiemKe bbkk = qdkk.getBbKK();
				if (bbkk != null) {
					if (bbkk.getDsDoanTtkt() != null) {
						sql = "delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER=" + bbkk.getIdDaiDienDoanTtkt();
						statement.addBatch(sql);
					}

					if (bbkk.getDsDonViCoTsKk() != null) {
						sql = "delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER=" + bbkk.getIdDaiDienDviCnhanCoTskk();
						statement.addBatch(sql);
					}
					sql = "delete TTKT_TH_BIEN_BAN_KIEM_KE where ID =" + bbkk.getId();
					statement.addBatch(sql);
				}
				sql = "delete TTKT_TH_QD_KIEM_KE where ID =" + qdkk.getId();
				statement.addBatch(sql);
			}
			statement.executeBatch();
			conn.commit();
		} catch (Exception e) {

		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}
	}

	public static Collection getDsChiTietDSTVD(String idCuocTtKt) throws Exception {
		Connection conn = null;
		TtktCbChiTietDsTvDoan chitietDSTVD;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection list = new ArrayList();
		String idDSTVD = null;
		try {
			conn = DataSourceConfiguration.getConnection();

			String query = "select * from KTNB_OWNER.TTKT_CB_DS_TV_DOAN where TTKT_CB_DS_TV_DOAN.ID_CUOC_TTKT =" + idCuocTtKt;
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				idDSTVD = rs.getString("ID");
			}
			query = "select * from KTNB_OWNER.TTKT_CB_CHI_TIET_DS_TV_DOAN where TTKT_CB_CHI_TIET_DS_TV_DOAN.Y_KIEN is not null and ID_DS_TVD=" + idDSTVD;
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				chitietDSTVD = new TtktCbChiTietDsTvDoan();
				chitietDSTVD.setId(rs.getString("ID"));
				chitietDSTVD.setIdCanBo(rs.getString("ID_CAN_BO"));
				chitietDSTVD.setTenCanBo(rs.getString("TEN_CAN_BO"));
				chitietDSTVD.setYkien(rs.getString("Y_KIEN"));
				list.add(chitietDSTVD);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}

		return list;
	}

	public static void saveYKienDuThao(TtktCbChiTietDsTvDoan[] ctDSTVD) throws Exception {

		Connection conn = null;
		Statement statement = null;
		String sql;
		try {
			conn = DataSourceConfiguration.getConnection();
			sql = "update KTNB_OWNER.TTKT_CB_CHI_TIET_DS_TV_DOAN set Y_KIEN = null ";
			statement = conn.createStatement();
			statement.executeUpdate(sql);

			for (int i = 0; i < ctDSTVD.length; i++) {
				sql = "update KTNB_OWNER.TTKT_CB_CHI_TIET_DS_TV_DOAN set Y_KIEN = '" + ctDSTVD[i].getYkien() + "' where ID_CAN_BO=" + ctDSTVD[i].getIdCanBo();
				statement = conn.createStatement();
				statement.executeUpdate(sql);
			}
			conn.commit();
		} catch (Exception err) {
			throw err;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}

	}
	public static Collection loadNoiDungPhucTra() throws Exception {
		ArrayList dsTtktGoc = (ArrayList) KtnbCache.getInstance().get("DM_NDGOC");
		return dsTtktGoc;
	}

	// load phuc tra
	public static TtktThPhucTra getPhucTra(ApplicationContext app, String id) throws Exception {
		if (id != null) {
			TtktThPhucTra phucTra = (TtktThPhucTra) dao.retrieveObject(app, TtktThPhucTra.class, id);

			// danh sach nguoi thuc hien
			SearchCriteria criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem("idMaster", phucTra.getDsCanBoThucHien());
			phucTra.setDsCbThucHien(dao.retrieveObjects(app, criteria));
			// danh sach noi dung
			criteria = new SearchCriteria(TtktThNoiDungPhucTra.class);
			criteria.addSearchItem("idPhucTra", phucTra.getId());
			phucTra.setDsNdPhucTra(dao.retrieveObjects(app, criteria));
			return phucTra;
		} else
			return null;

	}

	public static Collection getDsPhucTra(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThPhucTra.class);
		criteria.addSearchItem("idCuocTtkt", cuocTtktId);
		return dao.retrieveObjects(appContext, criteria);
	}

	public static void savePhucTra(TtktThPhucTra phucTra, ApplicationContext app) throws Exception {
		UserTransaction tx = null;
		Session session = null;

		try {

			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			BaseHibernateDAO dao = new BaseHibernateDAO();
			session = HibernateSessionFactory.currentSession();
			// ---------- phuc tra ---------------
			boolean isInsert = false;
			if (Formater.isNull(phucTra.getId())) {
				isInsert = true;
				phucTra.setId(KeyManagement.getGUID());
				phucTra.setDsCanBoThucHien(KeyManagement.getGUID());
				phucTra.setIdCqtCanPhucTra(KeyManagement.getGUID());
				dao.saveObject(app, phucTra, Boolean.TRUE);
			} else {
				dao.updateObject(app, phucTra, Boolean.TRUE);

			}

			// ------------------ Save thanh phan tham du ----------------

			// Xoa bo cac thanh phan tham du khong con
			if (phucTra.getDsCbThucHien() != null) {
				String sql = "delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + phucTra.getDsCanBoThucHien();
				session.createSQLQuery(sql).executeUpdate();
			}
			// if(phucTra.getDsNdPhucTra() != null){
			String sql2 = "delete TTKT_TH_NOI_DUNG_PHUC_TRA where ID_PHUC_TRA = " + phucTra.getId();
			session.createSQLQuery(sql2).executeUpdate();
			// }

			Collection dsDoanTtKt = phucTra.getDsCbThucHien();
			if (dsDoanTtKt != null) {
				Iterator iter = dsDoanTtKt.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					thanhPhanThamDu.setIdMaster(phucTra.getDsCanBoThucHien());
					dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
				}
			}
			if (Formater.isNull(phucTra.getNoiDungPhucTraNgoaiNganhThue())) {
				Collection dsNoiDung = phucTra.getDsNdPhucTra();
				Iterator iter = dsNoiDung.iterator();
				while (iter.hasNext()) {
					TtktThNoiDungPhucTra thanhPhanThamDu = (TtktThNoiDungPhucTra) iter.next();
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					thanhPhanThamDu.setIdPhucTra(phucTra.getId());
					dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
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

	public static void deletePhucTra(TtktThPhucTra phucTra, HttpServletRequest request, ApplicationContext app) throws Exception {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			// xoa yeu cau
			if (phucTra != null) {
				String sql = "delete TTKT_TH_PHUC_TRA where ID =" + phucTra.getId();
				statement.addBatch(sql);
				if (phucTra.getDsCbThucHien() != null) {
					sql = "delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER ='" + phucTra.getDsCanBoThucHien() + "'";
					statement.addBatch(sql);
				}
				if (phucTra.getDsNdPhucTra() != null) {
					sql = "delete TTKT_TH_NOI_DUNG_PHUC_TRA where ID_PHUC_TRA ='" + phucTra.getId() + "'";
					statement.addBatch(sql);
				}
			}
			statement.executeBatch();
			conn.commit();
		} catch (Exception e) {

		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}
	}

	/**
	 * @param app
	 * @param bbGiaotra
	 */
	public static void saveBbNhanTraHsTl(ApplicationContext app, TtktCmNhanTraHstl bb) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			BaseHibernateDAO dao = new BaseHibernateDAO();
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();
			// Constants.TT_TTKT_BBGIAOTRA_YCBSTL;
			if (Formater.isNull(bb.getId())) {
				bb.setId(KeyManagement.getGUID());
				bb.setIdDaiDienBenGiao(KeyManagement.getGUID());
				bb.setIdDaiDienBenNhan(KeyManagement.getGUID());
				dao.saveObject(app, bb, Boolean.TRUE);
			} else {
				// Xoa dai dien ben giao va dai dien ben nhan
				session.createSQLQuery("delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + bb.getIdDaiDienBenGiao()).executeUpdate();
				session.createSQLQuery("delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + bb.getIdDaiDienBenNhan()).executeUpdate();
				dao.updateObject(app, bb, Boolean.TRUE);
			}
			// Dai dien ben giao
			Collection dsDaiDienBenGiao = bb.getDaiDienBenGiao();
			Iterator iterator = dsDaiDienBenGiao.iterator();
			while (iterator.hasNext()) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iterator.next();
				thanhPhanThamDu.setId(KeyManagement.getGUID());
				thanhPhanThamDu.setIdMaster(bb.getIdDaiDienBenGiao());
				dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
			}
			// Dai dien ben nhan
			Collection dsDaiDienBenNhan = bb.getDaiDienBenNhan();
			iterator = dsDaiDienBenNhan.iterator();
			while (iterator.hasNext()) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iterator.next();
				thanhPhanThamDu.setId(KeyManagement.getGUID());
				thanhPhanThamDu.setIdMaster(bb.getIdDaiDienBenNhan());
				dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
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

	public static Collection getBienBanLamViecTrongQtTienHanh(ApplicationContext appContext, String cuocTtktId) throws Exception {
		Collection dsLoaiBb = new ArrayList();
		dsLoaiBb.add(Constants.TTKT_BB_HTCV);
		dsLoaiBb.add(Constants.TTKT_BB_LVVCBLQ);
		dsLoaiBb.add(Constants.TTKT_BB_LVVCNVCQC);
		SearchCriteria criteria = new SearchCriteria(TtktCmBienBan.class);
		criteria.addSearchItem(TtktCmBienBan.Loai, dsLoaiBb, SearchCriteria.OP_IN);
		criteria.addSearchItem(TtktCmBienBan.IdCuocTtkt, cuocTtktId);
		return dao.retrieveObjects(appContext, criteria);

	}

	/**
	 * Bien ban lam viec mau so 30 va thanh phan tham du
	 * 
	 * @param app
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static TtktCmBienBan getBbLamViecById(ApplicationContext app, String id) throws Exception {
		TtktCmBienBan bienBan = (TtktCmBienBan) dao.retrieveObject(app, TtktCmBienBan.class, id);
		SearchCriteria criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
		criteria.addSearchItem(TtktCmThanhPhanThamDu.IdMaster, bienBan.getTpThamDuDoanTtkt());
		bienBan.setDoanTtKt(dao.retrieveObjects(app, criteria));
		criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
		criteria.addSearchItem(TtktCmThanhPhanThamDu.IdMaster, bienBan.getTpThamDuKhac());
		bienBan.setThanhPhanThamDu(dao.retrieveObjects(app, criteria));
		return bienBan;

	}

	public static void deleteBienBanLamViec(ApplicationContext app, String id) throws Exception {
		TtktCmBienBan bienBan = TtktCnPhuService.getBbLamViecById(app, id);
		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			statement.addBatch("delete ttkt_cm_thanh_phan_tham_du t1 where t1.id_master in ('" + bienBan.getTpThamDuDoanTtkt() + "', '" + bienBan.getTpThamDuKhac() + "')");
			statement.addBatch("delete ttkt_cm_bien_ban t2 where t2.id =" + bienBan.getId());
			statement.executeBatch();
			conn.commit();
		} catch (Exception e) {

		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}

	}

	public static Collection getDsGiaHanTtKt(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThGiaHan.class);
		criteria.addSearchItem(TtktThGiaHan.IdCuocTtkt, cuocTtktId);
		return dao.retrieveObjects(appContext, criteria);
	}

	public static TtktThBienBanKiemKe getBienBanKkByQdKk(ApplicationContext app, String idQDkK) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThBienBanKiemKe.class);
		criteria.addSearchItem("idQdKk", idQDkK);
		return (TtktThBienBanKiemKe) ((ArrayList) dao.retrieveObjects(app, criteria)).get(0);
	}

	public static void deleteBbChiTietVaTongHopById(String idBbTongHopGuiDonViDuocTtktYk) {
		try {
			new File(UploadAction.UPLOAD_FOLDER + idBbTongHopGuiDonViDuocTtktYk).delete();

		} catch (Exception ex) {
			ex.printStackTrace();
			return;
		}

		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			statement.execute("delete ttkt_th_bb_chitietvatonghop where id = '" + idBbTongHopGuiDonViDuocTtktYk+"'");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}

	}

	public static String saveQdNiemPhong(ApplicationContext app, TtktThQdNiemPhongHsTl qdNiemPhongHsTl) throws Exception {
		if (Formater.isNull(qdNiemPhongHsTl.getId())) {
			qdNiemPhongHsTl.setId(KeyManagement.getGUID());
			dao.saveObject(app, qdNiemPhongHsTl);
		} else
			dao.updateObject(app, qdNiemPhongHsTl);
		return qdNiemPhongHsTl.getId();

	}

	public static String saveBbNiemPhong(ApplicationContext app, TtktThBbNiemPhong bbNiemPhong) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			BaseHibernateDAO dao = new BaseHibernateDAO();
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();
			if (Formater.isNull(bbNiemPhong.getId())) {
				bbNiemPhong.setId(KeyManagement.getGUID());
				bbNiemPhong.setIdTpThamDuDoanTtkt(KeyManagement.getGUID());
				bbNiemPhong.setIdTpThamDuDviCnhanCoTs(KeyManagement.getGUID());
				dao.saveObject(app, bbNiemPhong, Boolean.TRUE);

			} else {
				dao.updateObject(app, bbNiemPhong, Boolean.TRUE);
				session.createSQLQuery("delete ttkt_cm_thanh_phan_tham_du t1 where t1.id_master in ('" + bbNiemPhong.getIdTpThamDuDviCnhanCoTs() + "', '" + bbNiemPhong.getIdTpThamDuDoanTtkt() + "')").executeUpdate();

			}
			// Insert vao bang thanh phan tham du
			// Doan ttkt
			Iterator iterator = bbNiemPhong.getDsDoanTtkt().iterator();
			while (iterator.hasNext()) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iterator.next();
				thanhPhanThamDu.setId(KeyManagement.getGUID());
				thanhPhanThamDu.setIdMaster(bbNiemPhong.getIdTpThamDuDoanTtkt());
				dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
			}
			// Don vi cn co ts np
			iterator = bbNiemPhong.getDsDvCoTlNp().iterator();
			while (iterator.hasNext()) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iterator.next();
				thanhPhanThamDu.setId(KeyManagement.getGUID());
				thanhPhanThamDu.setIdMaster(bbNiemPhong.getIdTpThamDuDviCnhanCoTs());
				dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
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

		return bbNiemPhong.getId();
	}

	public static TtktThQdNiemPhongHsTl getQdNiemPhong(ApplicationContext app, String idQdNiemPhong) throws Exception {

		return (TtktThQdNiemPhongHsTl) dao.retrieveObject(app, TtktThQdNiemPhongHsTl.class, idQdNiemPhong);
	}

	public static void saveBbMoNiemPhong(ApplicationContext app, TtktThBbMoNiemPhong bbMoNiemPhong) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			BaseHibernateDAO dao = new BaseHibernateDAO();
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();
			if (Formater.isNull(bbMoNiemPhong.getId())) {
				bbMoNiemPhong.setId(KeyManagement.getGUID());
				bbMoNiemPhong.setIdTpThamDuDoanTtkt(KeyManagement.getGUID());
				bbMoNiemPhong.setIdTpThamDuCacOngBa(KeyManagement.getGUID());
				dao.saveObject(app, bbMoNiemPhong, Boolean.TRUE);

			} else {
				dao.updateObject(app, bbMoNiemPhong, Boolean.TRUE);
				session.createSQLQuery("delete ttkt_cm_thanh_phan_tham_du t1 where t1.id_master in ('" + bbMoNiemPhong.getIdTpThamDuCacOngBa() + "', '" + bbMoNiemPhong.getIdTpThamDuDoanTtkt() + "')").executeUpdate();

			}
			// Insert vao bang thanh phan tham du
			// Doan ttkt
			Iterator iterator = bbMoNiemPhong.getDsDoanTtkt().iterator();
			while (iterator.hasNext()) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iterator.next();
				thanhPhanThamDu.setId(KeyManagement.getGUID());
				thanhPhanThamDu.setIdMaster(bbMoNiemPhong.getIdTpThamDuDoanTtkt());
				dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
			}
			// Don vi cn co ts np
			iterator = bbMoNiemPhong.getDsCacOba().iterator();
			while (iterator.hasNext()) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iterator.next();
				thanhPhanThamDu.setId(KeyManagement.getGUID());
				thanhPhanThamDu.setIdMaster(bbMoNiemPhong.getIdTpThamDuCacOngBa());
				dao.saveObject(app, thanhPhanThamDu, Boolean.TRUE);
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

	/**
	 * @param appContext
	 * @param idCuocTtkt
	 * @return Danh sach thay doi thanh vien doan
	 */
	public static Collection getDsThayDoiTvd(ApplicationContext appContext, String idCuocTtkt) {
		// String sql = "select t.so_qd, t.ngay_ra_qd, t.loai_thay_doi,
		// t.id_dstv_cu, t.id_dstv_moi";
		ArrayList reVal = new ArrayList();
		String sql = "select t.so_qd, to_char(t.ngay_ra_qd, 'dd/mm/yyyy') ngay_ra_qd, t.loai_thay_doi";
		sql += " from ttkt_cm_thay_doi_tvd t";
		sql += " where t.id_cuoc_ttkt = " + idCuocTtkt;
		sql += " start with t.id_dstv_cu = (select distinct id from ttkt_cb_ds_tv_doan t1 where t1.id_cuoc_ttkt = " + idCuocTtkt + " and t1.id_ds_tvd_cu is null)";
		sql += " connect by prior t.id_dstv_moi = t.id_dstv_cu";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				reVal.add(new TtktCmThayDoiTvd(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, stmt, conn);
		}
		return reVal;
	}

	public static Collection getThanhPhanThamDu(ApplicationContext app, String idMaster) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
		criteria.addSearchItem(TtktCmThanhPhanThamDu.IdMaster, idMaster);
		return dao.retrieveObjects(app, criteria);
	}

	public static Collection getGiaHanTtKtByIdCuocttkt(ApplicationContext appContext, String cuocTtktId) {
		// TODO Auto-generated method stub
		SearchCriteria criteria = new SearchCriteria(TtktThGiaHan.class);
		try {
			criteria.addSearchItem(TtktThGiaHan.IdCuocTtkt, cuocTtktId);
			return dao.retrieveObjects(appContext, criteria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
}
