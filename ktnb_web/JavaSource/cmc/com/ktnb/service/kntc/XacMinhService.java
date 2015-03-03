package cmc.com.ktnb.service.kntc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.naming.InitialContext;
import javax.transaction.UserTransaction;

import org.hibernate.Query;
import org.hibernate.Session;

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KntcBaoCao;
import cmc.com.ktnb.pl.hb.entity.KntcBienBan;
import cmc.com.ktnb.pl.hb.entity.KntcBienBanId;
import cmc.com.ktnb.pl.hb.entity.KntcCanBoRls;
import cmc.com.ktnb.pl.hb.entity.KntcDmRls;
import cmc.com.ktnb.pl.hb.entity.KntcPhieuChuyenDon;
import cmc.com.ktnb.pl.hb.entity.KntcXmBaoCaoKq;
import cmc.com.ktnb.pl.hb.entity.KntcKquaXmDtl;
import cmc.com.ktnb.pl.hb.entity.KntcKqxmKluatKnghi;
import cmc.com.ktnb.pl.hb.entity.KntcQdinhXm;
import cmc.com.ktnb.pl.hb.entity.KntcQdxmPhieuYc;
import cmc.com.ktnb.pl.hb.entity.KntcXmGiaHan;
import cmc.com.ktnb.pl.hb.entity.KntcXmKeHoach;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.web.catalog.CatalogService;

/**
 * @author ntthu - cmcsoft
 * @since Nov 17, 2010 Xử lý các thông tin trong quá trình xác minh hồ sơ
 */
public class XacMinhService {
	protected BaseHibernateDAO dao = null;

	/**
	 * Hàm khởi tạo mặc định
	 */
	public XacMinhService() {
		super();
		dao = new BaseHibernateDAO();
	}

	/**
	 * Lưu thông tin quyết định xác minh
	 * 
	 * @param appContext
	 * @param qd :
	 *            Quyết định xác minh
	 * @param kntcCanBoRls :
	 *            Danh sách cán bộ xác minh
	 * @throws Exception
	 */
	public void saveQuyetDinhXacMinh(ApplicationContext appContext, KntcQdinhXm qd, Collection kntcCanBoRls) throws Exception {
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
			
			// BaseHibernateDAO dao = new BaseHibernateDAO();
			if (Formater.isNull(qd.getMa())) // Save
			{
				qd.setMa(KeyManagement.getGUID());
				dao.saveObject(appContext, qd, Boolean.TRUE);
			} else // Update
			{
				dao.updateObject(appContext, qd, Boolean.TRUE);
			}

			// Update Thanh vien doan
			if (!Formater.isNull(qd.getMaHs())) {
				String sql = "delete kntc_can_bo_rls where ma_hs =? and LOAI_CB =?";
				Query q = session.createSQLQuery(sql);
				q.setDate(0, new Date());
				q.setParameter(0, qd.getMaHs());
				q.setParameter(1, KntcCanBoRls.KNTC_TVD_XAC_MINH);
				q.executeUpdate();
				for (Iterator iter = kntcCanBoRls.iterator(); iter.hasNext();) {
					KntcCanBoRls cbRls = (KntcCanBoRls) iter.next();
					dao.saveObject(appContext, cbRls, Boolean.TRUE);
				}
			}
			// Update số quyết định cho mẫu phụ
			if (!Formater.isNull(qd.getMaQd())) {
				String sql = "update kntc_qdxm_phieu_yc set ma_qd =? where ma_hs=?";
				Query q = session.createSQLQuery(sql);
				q.setParameter(0, qd.getMaQd());
				q.setParameter(1, qd.getMaHs());
				q.executeUpdate();				
			}
			//Update số quyết định cho mẫu phụ gia hạn
			if (!Formater.isNull(qd.getMaQd())) {
				String sql = "update kntc_xm_gia_han set can_cu_qd =? where ma_hs=?";
				Query q = session.createSQLQuery(sql);
				q.setParameter(0, qd.getMaQd());
				q.setParameter(1, qd.getMaHs());
				q.executeUpdate();				
			}
			session.flush();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}

	/**
	 * Lưu thông tin biên bản quyết định xác minh
	 * 
	 * @param appContext
	 * @param qd
	 * @throws Exception
	 */
	public void saveBienBanQuyetDinhXacMinh(ApplicationContext appContext, KntcXmBaoCaoKq qd) throws Exception {
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
			if (Formater.isNull(qd.getMa())) // Save
			{
				qd.setMa(KeyManagement.getGUID());
				dao.saveObject(appContext, qd, Boolean.TRUE);
			} else // Update
			{
				dao.updateObject(appContext, qd, Boolean.TRUE);
			}
			if (qd.getKetThucXm() != null && qd.getKetThucXm().intValue() == 1) {
				String sql = "Update KNTC_HO_SO_HDR set TRANG_THAI=? where MA_HS=?";
				Query q = session.createSQLQuery(sql);
				q.setParameter(0, new Long(Constants.TT_KNTC_KET_LUAN));
				//q.setParameter(0, new Long(Constants.TT_KNTC_THI_HANH));
				q.setParameter(1, qd.getMaHs());
				q.executeUpdate();
			}
			session.flush();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}

	/**
	 * Lưu thông tin gia hạn thời gian xác minh
	 * 
	 * @param appContext
	 * @param qd :
	 *            Quyết định gia hạn
	 * @throws Exception
	 */
	public void saveQdGiaHanXacMinh(ApplicationContext appContext, KntcXmGiaHan qd) throws Exception {
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

			if (Formater.isNull(qd.getMa())) // Save
			{
				qd.setMa(KeyManagement.getGUID());
				dao.saveObject(appContext, qd, Boolean.TRUE);
			} else // Update
			{
				
				dao.updateObject(appContext, qd, Boolean.TRUE);
			}
			// Update ngay QDXM
			if (!Formater.isNull(qd.getSoPhieu()) && qd.getNgayLap() != null && qd.getGiaHanTuNgay() != null && qd.getGiaHanDenNgay() != null) {
				//XacMinhService s = new XacMinhService();
				//KntcQdinhXm qdXm = s.getKntcQdinhXmByHoSo(appContext, qd.getMaHs());
				String sql = " update kntc_qdinh_xm t set t.den_ngay_xm=? where t.ma_hs=?";
				Query q = session.createSQLQuery(sql);
				//q.setParameter(0, KtnbUtil.addBusinessDate(qdXm.getDenNgayXm(), Integer.parseInt(qd.getSoNgayGH())));
				q.setParameter(0, qd.getGiaHanDenNgay());
				q.setParameter(1, qd.getMaHs());
				q.executeUpdate();
			}
			session.flush();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}

	/**
	 * Lưu thông tin quyết định
	 * 
	 * @param appContext
	 * @param qd
	 * @throws Exception
	 */
	public void saveKqxmKluatKnghi(ApplicationContext appContext, KntcKqxmKluatKnghi qd) throws Exception {
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
			if (Formater.isNull(qd.getMa())) // Save
			{
				qd.setMa(KeyManagement.getGUID());
				dao.saveObject(appContext, qd, Boolean.TRUE);
			} else // Update
			{
				dao.saveOrUpdateObject(appContext, qd, Boolean.TRUE);
			}
			if (qd.getNgayDuyet() != null) {
				String sql = "Update KNTC_HO_SO_HDR set TRANG_THAI=? where MA_HS=?";
				Query q = session.createSQLQuery(sql);
				q.setParameter(0, new Long(Constants.TT_KNTC_KET_LUAN));
				q.setParameter(1, qd.getMaHs());
				q.executeUpdate();
			}
			session.flush();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}

	/**
	 * Lưu phiếu yêu cầu
	 * 
	 * @param appContext
	 * @param phieuYc :
	 *            Phiếu yêu cầu
	 * @throws Exception
	 */
	public void savePhieuYeuCau(ApplicationContext appContext, KntcQdxmPhieuYc phieuYc) throws Exception {
		// BaseHibernateDAO dao = new BaseHibernateDAO();
		if (Formater.isNull(phieuYc.getMa())) // Save
		{
			phieuYc.setMa(KeyManagement.getGUID());
			dao.saveObject(appContext, phieuYc);
		} else // Update
		{
			dao.updateObject(appContext, phieuYc);
		}
	}

	/**
	 * Lưu biên bản
	 * 
	 * @param appContext
	 * @param bb :
	 *            Biên bản
	 * @param loaiBienBan :
	 *            Loại biên bản
	 * @throws Exception
	 */
	public void saveBienBan(ApplicationContext appContext, KntcBienBan bb, String loaiBienBan) throws Exception {
		// BaseHibernateDAO dao = new BaseHibernateDAO();
		bb.setLoaiBienBan(loaiBienBan);
		// if (loaiBienBan.equals(KntcBienBan.BB_CONG_BO_QDXM_KN) ||
		// loaiBienBan.equals(KntcBienBan.BB_CONG_BO_QDXM_TC)) {
		// UserTransaction tx = null;
		// Session session = null;
		// try {
		// try {
		// tx = (UserTransaction) new
		// InitialContext().lookup("java:comp/UserTransaction");
		// tx.begin();
		// } catch (Exception e1) {
		// e1.printStackTrace();
		// }
		// BaseHibernateDAO dao = new BaseHibernateDAO();
		// session = HibernateSessionFactory.currentSession();
		// if (Formater.isNull(bb.getId().getMaBb())) // Save
		// {
		// bb.getId().setMaBb(KeyManagement.getGUID());
		// dao.saveObject(appContext, bb, Boolean.TRUE);
		// } else // Update
		// {
		// dao.updateObject(appContext, bb, Boolean.TRUE);
		// }
		// // Update ngay QDXM
		// if (bb.getThoiDiem() != null) {
		// XacMinhService s = new XacMinhService();
		// KntcQdinhXm qdXm = s.getKntcQdinhXmByHoSo(appContext,
		// bb.getId().getMaHs());
		// String sql = " update kntc_qdinh_xm t set t.tu_ngay_xm=?,
		// t.den_ngay_xm=? where t.ma_hs=?";
		// Query q = session.createSQLQuery(sql);
		// q.setParameter(0, bb.getThoiDiem());
		// q.setParameter(1, KtnbUtil.addBusinessDate(bb.getThoiDiem(),
		// qdXm.getSoNgayXm().intValue()));
		// q.setParameter(2, bb.getId().getMaHs());
		// q.executeUpdate();
		// }
		// session.flush();
		// tx.commit();
		// } catch (Exception e) {
		// tx.rollback();
		// e.printStackTrace();
		// throw new Exception(e);
		// } finally {
		// HibernateSessionFactory.closeSession(session);
		// }
		// } else {
		if (Formater.isNull(bb.getId().getMaBb())) // Save
		{
			bb.getId().setMaBb(KeyManagement.getGUID());
			dao.saveObject(appContext, bb);
		} else // Update
		{
			dao.updateObject(appContext, bb);
		}
		// }
	}

	/**
	 * Lưu báo cáo
	 * 
	 * @param appContext
	 * @param bb :
	 *            Báo cáo
	 * @param loaiBaoCao :
	 *            Loại báo cáo
	 * @throws Exception
	 */
	public void saveBaoCao(ApplicationContext appContext, KntcBaoCao bb, String loaiBaoCao) throws Exception {
		// BaseHibernateDAO dao = new BaseHibernateDAO();
		bb.setLoaiBaoCao(loaiBaoCao);
		if (Formater.isNull(bb.getMaBc())) // Save
		{
			bb.setMaBc(KeyManagement.getGUID());
			dao.saveObject(appContext, bb);
		} else // Update
		{
			dao.updateObject(appContext, bb);
		}
	}

	/**
	 * Lưu báo cáo kết quả xác minh tố cáo
	 * 
	 * @param appContext
	 * @param qd :
	 *            Báo cáo kết quả xác minh tố cáo
	 * @throws Exception
	 */
	public void saveBaoCaoKetQuaXacMinhTC(ApplicationContext appContext, KntcXacMinh qd) throws Exception {
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
			if (Formater.isNull(qd.getHdr().getMa())) // Save
			{
				qd.getHdr().setMa(KeyManagement.getGUID());
				dao.saveObject(appContext, qd.getHdr(), Boolean.TRUE);
			} else // Update
			{
				dao.updateObject(appContext, qd.getHdr(), Boolean.TRUE);
			}
			// String sql = "delete KNTC_KQUA_XM_DTL where MA_KQ=? and LOAI=?";
			// Query q = session.createSQLQuery(sql);
			// q.setParameter(0, qd.getHdr().getMaQd());
			// q.setParameter(1, KntcKquaXmDtl.BAO_CAO_XAC_MINH_TC);
			// q.executeUpdate();
			// Luu thong tin chi tiet (neu co)
			ArrayList listDtl = qd.getListDtl();
			if (listDtl != null && listDtl.size() > 0) {
				for (Iterator iter = listDtl.iterator(); iter.hasNext();) {
					KntcKquaXmDtl gbn = (KntcKquaXmDtl) iter.next();
					gbn.setMa(KeyManagement.getGUID());
					gbn.setMaKq(qd.getHdr().getMaQd());
					dao.saveObject(appContext, gbn, Boolean.TRUE);
				}
			}
			if (qd.getHdr().getNgayDuyet() != null) {
				String sql = "Update KNTC_HO_SO_HDR set TRANG_THAI=? where MA_HS=?";
				Query q = session.createSQLQuery(sql);
				q.setParameter(0, new Long(Constants.TT_KNTC_KET_LUAN));
				q.setParameter(1, qd.getHdr().getMaHs());
				q.executeUpdate();
			}
			session.flush();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}

	/**
	 * Lưu kết luận nội dung tố cáo
	 * 
	 * @param appContext
	 * @param kl :
	 *            Kết luận
	 * @throws Exception
	 */
	public void saveKetLuanTC(ApplicationContext appContext, KntcXacMinh kl) throws Exception {
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
			KntcKqxmKluatKnghi hdr = null;
			if (Formater.isNull(kl.getHdr().getMa())) // Save
			{
				hdr = kl.getHdr();
				hdr.setMa(KeyManagement.getGUID());
				dao.saveObject(appContext, hdr, Boolean.TRUE);
			} else // Update
			{
				hdr = kl.getHdr();
				dao.updateObject(appContext, hdr, Boolean.TRUE);
			}
			// String sql = "delete KNTC_KQUA_XM_DTL where MA_KQ=? and LOAI=?";
			// Query q = session.createSQLQuery(sql);
			// q.setParameter(0, kl.getHdr().getMaQd());
			// q.setParameter(1, KntcKquaXmDtl.KET_LUAN_TC);
			// q.executeUpdate();
			// Luu thong tin chi tiet (neu co)
			ArrayList listDtl = kl.getListDtl();
			if (listDtl != null && listDtl.size() > 0) {
				for (Iterator iter = listDtl.iterator(); iter.hasNext();) {
					KntcKquaXmDtl gbn = (KntcKquaXmDtl) iter.next();
					gbn.setMa(KeyManagement.getGUID());
					gbn.setMaKq(kl.getHdr().getMaQd());
					dao.saveObject(appContext, gbn, Boolean.TRUE);
				}
			}
			if (kl.getHdr().getNgayDuyet() != null) {
				String sql = "Update KNTC_HO_SO_HDR set TRANG_THAI=? where MA_HS=?";
				Query q = session.createSQLQuery(sql);
				q.setParameter(0, new Long(Constants.TT_KNTC_THI_HANH));
				q.setParameter(1, hdr.getMaHs());
				q.executeUpdate();
			}
			session.flush();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}

	/**
	 * Lưu thông tin kế hoạch xác minh
	 * 
	 * @param appContext
	 * @param kh :
	 *            kết hoạch xác minh
	 * @throws Exception
	 */
	public void saveKeHoachXacMinh(ApplicationContext appContext, KntcXmKeHoach kh) throws Exception {
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
			if (Formater.isNull(kh.getMa())) // Save
			{
				kh.setMa(KeyManagement.getGUID());
				dao.saveObject(appContext, kh, Boolean.TRUE);
			} else // Update
			{
				dao.updateObject(appContext, kh, Boolean.TRUE);
			}
			session.flush();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}

	/**
	 * Lưu kế hoạch xác minh và danh mục cán bộ trong kế hoạch xác minh
	 * 
	 * @param appContext
	 * @param kh :
	 *            kế hoạch xác minh
	 * @param listCB :
	 *            danh sách cán bộ
	 * @throws Exception
	 */
	public void saveKeHoachXacMinh(ApplicationContext appContext, KntcXmKeHoach kh, Collection listCB) throws Exception {
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
			if (Formater.isNull(kh.getMa())) // Save
			{
				kh.setMa(KeyManagement.getGUID());
				dao.saveObject(appContext, kh, Boolean.TRUE);
				if (listCB != null && listCB.size() > 0) {
					for (Iterator iter = listCB.iterator(); iter.hasNext();) {
						KntcDmRls gbn = (KntcDmRls) iter.next();
						dao.saveObject(appContext, gbn, Boolean.TRUE);
					}
				}
			} else // Update
			{
				dao.updateObject(appContext, kh, Boolean.TRUE);
				if (listCB != null && listCB.size() > 0) {
					String sql = "DELETE kntc_dm_rls where ma_hs=? and loai_rls=?";
					Query q = session.createSQLQuery(sql);
					q.setParameter(0, kh.getMaHs());
					q.setParameter(1, KntcDmRls.KE_HOACH_XAC_MINH);
					q.executeUpdate();
					for (Iterator iter = listCB.iterator(); iter.hasNext();) {
						KntcDmRls gbn = (KntcDmRls) iter.next();
						dao.saveObject(appContext, gbn, Boolean.TRUE);
					}
				}
			}
			session.flush();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}

	/**
	 * Lấy thông tin phiếu yêu cầu theo loại phiếu và mã hồ sơ
	 * 
	 * @param appContext
	 * @param maHoSo
	 * @param loaiPhieu
	 * @return KntcQdxmPhieuYc
	 * @throws Exception
	 */
	public KntcQdxmPhieuYc getPhieuYeuCau(ApplicationContext appContext, String maHoSo, String loaiPhieu) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcQdxmPhieuYc.class);
		sc.addSearchItem("kntcQdinhXm", maHoSo);
		sc.addSearchItem("loaiPhieu", loaiPhieu);
		KntcQdxmPhieuYc pYc = (KntcQdxmPhieuYc) services.retriveObject(appContext, sc);
		return pYc;
	}

	/**
	 * Lấy thông tin phiếu yêu cầu theo mã phiếu
	 * 
	 * @param appContext
	 * @param maPhieu
	 * @return KntcQdxmPhieuYc
	 * @throws Exception
	 */
	public KntcQdxmPhieuYc getPhieuYeuCauById(ApplicationContext appContext, String maPhieu) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcQdxmPhieuYc.class);
		sc.addSearchItem("ma", maPhieu);
		KntcQdxmPhieuYc pYc = (KntcQdxmPhieuYc) services.retriveObject(appContext, sc);
		return pYc;
	}

	/**
	 * Lấy thông tin quyết định xác minh theo mã quyết định
	 * 
	 * @param appContext
	 * @param maQd
	 * @return
	 * @throws Exception
	 */
	public KntcQdinhXm getKntcQdinhXm(ApplicationContext appContext, String maQd) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcQdinhXm.class);
		sc.addSearchItem("maQd", maQd);
		return (KntcQdinhXm) services.retriveObject(appContext, sc);
	}

	/**
	 * Lấy thông tin kế hoạch xác minh theo mã hồ sơ
	 * 
	 * @param appContext
	 * @param maHs
	 * @return
	 * @throws Exception
	 */
	public KntcXmKeHoach getKntcXmKeHoachByHoSo(ApplicationContext appContext, String maHs) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcXmKeHoach.class);
		sc.addSearchItem("maHs", maHs);
		return (KntcXmKeHoach) services.retriveObject(appContext, sc);
	}

	/**
	 * Lấy thông tin quyết định xác minh theo mã hồ sơ
	 * 
	 * Lấy thông tin quyết định xác minh theo  ma ho so doan xac minh
	 * @param appContext
	 * @param maHs
	 * @return
	 * @throws Exception
	 */
	public KntcQdinhXm getKntcQdinhXmByHoSo(ApplicationContext appContext, String maHs) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcQdinhXm.class);
		sc.addSearchItem("maHsDoanXm", null, SearchCriteria.LG_IS_NULL);
		sc.addSearchItem("maHs", maHs);
		return (KntcQdinhXm) services.retriveObject(appContext, sc);
	}
	
	public KntcQdinhXm getKntcQdinhXmByHoSoDoanXm(ApplicationContext appContext, String maHs) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcQdinhXm.class);
		sc.addSearchItem("maHsDoanXm", maHs);
		sc.addSearchItem("maHs", maHs);
		return (KntcQdinhXm) services.retriveObject(appContext, sc);
	}

	/**
	 * Lấy thông tin biên bản theo mã hồ sơ
	 * 
	 * @param appContext
	 * @param maHs
	 * @param loaiBb
	 * @return
	 * @throws Exception
	 */
	public KntcBienBan getBienBanByHoSo(ApplicationContext appContext, String maHs, String loaiBb) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcBienBan.class);
		sc.addSearchItem("id.maHs", maHs);
		sc.addSearchItem("loaiBienBan", loaiBb);
		return (KntcBienBan) services.retriveObject(appContext, sc);
	}

	/**
	 * Lấy thông tin phiếu chuyển đơn theo mã hồ sơ
	 * 
	 * @param appContext
	 * @param maHs
	 * @return KntcPhieuChuyenDon
	 * @throws Exception
	 */

	public Collection getListPhieuChuyenDon(ApplicationContext appContext, String maHs) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcPhieuChuyenDon.class);
		sc.addSearchItem("maHs", maHs);
		return services.retrive(appContext, sc);
	}

	public KntcPhieuChuyenDon getPhieuChuyenDonByMaPhieu(ApplicationContext appContext, String maPhieu) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcPhieuChuyenDon.class);
		sc.addSearchItem("ma", maPhieu);
		return (KntcPhieuChuyenDon) services.retriveObject(appContext, sc);
	}

	/**
	 * Lấy thông tin quyết định gia hạn theo mã quyết định
	 * 
	 * @param appContext
	 * @param maQD
	 * @return KntcXmGiaHan
	 * @throws Exception
	 */
	public KntcXmGiaHan getQDGHByMaQD(ApplicationContext appContext, String maQD) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcXmGiaHan.class);
		sc.addSearchItem("ma", maQD);
		return (KntcXmGiaHan) services.retriveObject(appContext, sc);
	}

	/**
	 * Lấy thông tin quyết định gia hạn theo mã hồ sơ.
	 * 
	 * @param appContext
	 * @param maHs
	 * @return
	 * @throws Exception
	 */
	public KntcXmGiaHan getQDGHByMaHs(ApplicationContext appContext, String maHs) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcXmGiaHan.class);
		sc.addSearchItem("maHs", maHs);
		return (KntcXmGiaHan) services.retriveObject(appContext, sc);
	}

	/**
	 * Lấy thông tin biên bản theo mã biên bản
	 * 
	 * @param appContext
	 * @param maBB
	 * @return
	 * @throws Exception
	 */
	public KntcBienBan getBienBanByMaBB(ApplicationContext appContext, String maBB) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcBienBan.class);
		sc.addSearchItem("id.maBb", maBB);
		return (KntcBienBan) services.retriveObject(appContext, sc);
	}

	/**
	 * Xóa biên bản làm việc theo mã biên bản và mã hồ sơ
	 * 
	 * @param appContext
	 * @param maBB
	 * @param maHs
	 * @throws Exception
	 */
	public void delBienBanByMaBB(ApplicationContext appContext, String maBB, String maHs) throws Exception {
		CatalogService services = new CatalogService();
		KntcBienBanId id = new KntcBienBanId();
		id.setMaBb(maBB);
		id.setMaHs(maHs);
		dao.deleteObject(appContext, services.retriveById(appContext, KntcBienBan.class, id));
	}

	/**
	 * Xóa phiếu yêu cầu theo mã phiếu
	 * 
	 * @param appContext
	 * @param maPhieu
	 * @throws Exception
	 */
	public void delPycByMaPhieu(ApplicationContext appContext, String maPhieu) throws Exception {
		CatalogService services = new CatalogService();
		dao.deleteObject(appContext, services.retriveById(appContext, KntcQdxmPhieuYc.class, maPhieu));
	}

	public void delPhieuChuyenById(ApplicationContext appContext, String maPhieu) throws Exception {
		CatalogService services = new CatalogService();
		dao.deleteObject(appContext, services.retriveById(appContext, KntcPhieuChuyenDon.class, maPhieu));
	}

	/**
	 * Xóa quyết định gia hạn theo mã quyết định
	 * 
	 * @param appContext
	 * @param maQD
	 * @throws Exception
	 */
	public void delQDGHByMa(ApplicationContext appContext, String maQD) throws Exception {
		CatalogService services = new CatalogService();
		KntcXmGiaHan gh = (KntcXmGiaHan) services.retriveById(appContext, KntcXmGiaHan.class, maQD);
		if (gh.getNgayLap() != null)
			throw new KtnbException("Kh&#244;ng x&#243;a &#273;&#432;&#7907;c d&#7919; li&#7879;u!", "", "Quy&#7871;t &#273;&#7883;nh gia h&#7841;n &#273;&#227; &#273;&#432;&#7907;c duy&#7879;t , b&#7841;n ch&#7881; c&#243; th&#7875; s&#7917;a, kh&#244;ng th&#7875; x&#243;a quy&#7871;t &#273;&#7883;nh gia h&#7841;n!");
		dao.deleteObject(appContext, services.retriveById(appContext, KntcXmGiaHan.class, maQD));
	}

	/**
	 * Thêm cán bộ xác minh mặc định vào thành viên đoàn xác minh Khi lập quyết
	 * định xác minh
	 * 
	 * @param maHs
	 * @param cbRls
	 * @throws Exception
	 */
	public void addCanBoXMDefault(String maHs, KntcCanBoRls cbRls) throws Exception {
		Connection conn = DataSourceConfiguration.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "insert into KNTC_CAN_BO_RLS (MA_HS,MA_CANBO,TEN_CB,DON_VI,CHUC_VU,VAI_TRO,LOAI_CB,LAN_TD) values (?,?,?,?,?,?,'5','0')";
			ps = conn.prepareStatement(sql);
			ps.setString(1, maHs);
			ps.setString(2, cbRls.getId().getMaCanbo());
			ps.setString(3, cbRls.getTenCb());
			ps.setString(4, cbRls.getDonVi());
			ps.setString(5, cbRls.getChucVu());
			ps.setString(6, cbRls.getVaiTro());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.print("Insert Can Bo Error: "+e.getMessage());
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
	}

	/**
	 * Lay danh sach Can bo Doan xac minh cua QDXM
	 * 
	 * @param appContext
	 * @param maHs
	 * @return
	 * @throws Exception
	 */
	public Collection getListCanBoXmByHs(ApplicationContext appContext, String maHs) throws Exception {
		SoTiepDanService services = new SoTiepDanService();
		return services.getListCanBoByHs(appContext, maHs, KntcCanBoRls.KNTC_TVD_XAC_MINH);
	}

	/**
	 * Lấy tên trưởng đoàn xác minh theo mã hồ sơ
	 * 
	 * @param appContext
	 * @param maHs
	 * @return Tên trưởng đoàn
	 * @throws Exception
	 */
	public String getTenTruongDoanXmByHs(ApplicationContext appContext, String maHs) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcCanBoRls.class);
		sc.addSearchItem("id.maHs", maHs);
		sc.addSearchItem("id.loaiCb", KntcCanBoRls.KNTC_TVD_XAC_MINH);
		sc.addSearchItem("vaiTro", "Tr\u01B0\u1EDFng \u0111o\u00E0n");
		sc.addSearchItem("ngayHetHluc", new Date(), SearchCriteria.LG_IS_NULL);
		KntcCanBoRls aCb = (KntcCanBoRls) services.retriveObject(appContext, sc);
		if (aCb == null)
			return "";
		else
			return aCb.getTenCb();
	}

	/**
	 * Lấy thông tin báo cáo kết quả giải quyết theo mã quyết định
	 * 
	 * @param appContext
	 * @param maQd
	 * @return
	 * @throws Exception
	 */
	public KntcXmBaoCaoKq getKntcKquaGquyet(ApplicationContext appContext, String maQd) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcXmBaoCaoKq.class);
		sc.addSearchItem("maQd", maQd);
		return (KntcXmBaoCaoKq) services.retriveObject(appContext, sc);
	}

	/**
	 * Lấy thông tin kết quả giải quyết theo mã hồ sơ
	 * 
	 * @param appContext
	 * @param maHs
	 * @return
	 * @throws Exception
	 */
	public KntcXmBaoCaoKq getKntcKquaGquyetByHs(ApplicationContext appContext, String maHs) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcXmBaoCaoKq.class);
		sc.addSearchItem("maHs", maHs);
		return (KntcXmBaoCaoKq) services.retriveObject(appContext, sc);
	}

	/**
	 * Lấy thông tin báo cáo kết quả xác minh theo mã quyết định
	 * 
	 * @param appContext
	 * @param maQd
	 * @return
	 * @throws Exception
	 */
	public KntcKqxmKluatKnghi getKqxmKluatKnghi(ApplicationContext appContext, String maQd) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcKqxmKluatKnghi.class);
		sc.addSearchItem("maQd", maQd);
		return (KntcKqxmKluatKnghi) services.retriveObject(appContext, sc);
	}

	/**
	 * Lấy thông tin báo cáo kết quả xác minh theo mã hồ sơ
	 * 
	 * @param appContext
	 * @param maHs
	 * @return
	 * @throws Exception
	 */
	public KntcKqxmKluatKnghi getKqxmKluatKnghiByMaHs(ApplicationContext appContext, String maHs) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcKqxmKluatKnghi.class);
		sc.addSearchItem("maHs", maHs);
		return (KntcKqxmKluatKnghi) services.retriveObject(appContext, sc);
	}
	
	public KntcXmBaoCaoKq getBaoCaoKetQuaXacMinhByMaHs(ApplicationContext appContext, String maHs) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcXmBaoCaoKq.class);
		sc.addSearchItem("maHs", maHs);
		return (KntcXmBaoCaoKq) services.retriveObject(appContext, sc);
	}
	/**
	 * Lấy thông tin kết luận theo mã quyết định và loại kết luận
	 * 
	 * @param appContext
	 * @param maQd
	 * @param loaiKl
	 * @return
	 * @throws Exception
	 */
	public KntcKqxmKluatKnghi getKqxmKluatKnghiByLoai(ApplicationContext appContext, String maQd, String loaiKl) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcKqxmKluatKnghi.class);
		sc.addSearchItem("maQd", maQd);
		sc.addSearchItem("loaiKl", loaiKl);
		return (KntcKqxmKluatKnghi) services.retriveObject(appContext, sc);
	}

	/**
	 * Lấy thông tin kết luận theo mã hồ sơ và loại kết luận
	 * 
	 * @param appContext
	 * @param maQd
	 * @param loaiKl
	 * @return
	 * @throws Exception
	 */
	public KntcKqxmKluatKnghi getKqxmKluatKnghiByMaHs(ApplicationContext appContext, String maHs, String loaiKl) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcKqxmKluatKnghi.class);
		sc.addSearchItem("maHs", maHs);
		if(loaiKl!=null)sc.addSearchItem("loaiKl", loaiKl);
		return (KntcKqxmKluatKnghi) services.retriveObject(appContext, sc);
	}

	/**
	 * Lấy thông tin kết quả xác minh theo mã quyết định và loại quyết định
	 * 
	 * @param appContext
	 * @param maQd
	 * @param loai
	 * @return
	 * @throws Exception
	 */
	public Collection getListKqxmDtl(ApplicationContext appContext, String maQd, String loai) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcKquaXmDtl.class);
		sc.addSearchItem("maKq", maQd);
		sc.addSearchItem("loai", loai);
		return services.retrive(appContext, sc);
	}

	/**
	 * Lấy danh sách phiếu yêu cầu giải trình
	 * 
	 * @param appContext
	 * @param maHoSo
	 * @return
	 * @throws Exception
	 */
	
	public Collection getListPhieuYeuCauGt(ApplicationContext appContext, String maHoSo) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcQdxmPhieuYc.class);
		sc.addSearchItem("kntcQdinhXm", maHoSo);
		sc.addSearchItem("loaiPhieu", KntcQdxmPhieuYc.PHIEU_YC_GIAI_TRINH);
		return services.retrive(appContext, sc);
	}

}
