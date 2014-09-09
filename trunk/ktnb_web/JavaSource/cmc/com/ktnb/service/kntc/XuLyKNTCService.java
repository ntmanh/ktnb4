package cmc.com.ktnb.service.kntc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.naming.InitialContext;
import javax.transaction.UserTransaction;

import org.hibernate.Query;
import org.hibernate.Session;

import cmc.com.ktnb.pl.hb.entity.KntcBCKQThucHienQDKN;
import cmc.com.ktnb.pl.hb.entity.KntcBienBan;
import cmc.com.ktnb.pl.hb.entity.KntcCanBoRls;
import cmc.com.ktnb.pl.hb.entity.KntcDmRls;
import cmc.com.ktnb.pl.hb.entity.KntcHoSoTheoDoi;
import cmc.com.ktnb.pl.hb.entity.KntcQdinhGquyet;
import cmc.com.ktnb.pl.hb.entity.KntcThongBaoKqgq;
import cmc.com.ktnb.pl.hb.entity.KtnbPaHsRls;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.web.catalog.CatalogService;

/**
 * @author ntthu - cmcsoft
 * @since Nov 17, 2010 Xử lý các thông tin liên quan đến giai đoạn thi hành KNTC
 */
public class XuLyKNTCService {
	protected BaseHibernateDAO dao = new BaseHibernateDAO();

	/**
	 * Hàm khởi tạo mặc định
	 */
	public XuLyKNTCService() {
		super();
	}

	public void saveBienBanChuyenDieuTra(ApplicationContext appContext, KntcBienBanChuyenHoSo dx) throws Exception {
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
			dx.getBienBan().setLoaiBienBan(KntcBienBan.BB_CHUYEN_DIEU_TRA_TC);
			if (Formater.isNull(dx.getBienBan().getId().getMaBb())) // Save
			{
				dx.getBienBan().getId().setMaBb(KeyManagement.getGUID());
				dao.saveObject(appContext, dx.getBienBan(), Boolean.TRUE);
				ArrayList listDtl = dx.getListDm();
				if (listDtl != null && listDtl.size() > 0) {
					for (Iterator iter = listDtl.iterator(); iter.hasNext();) {
						KntcDmRls gbn = (KntcDmRls) iter.next();
						dao.saveObject(appContext, gbn, Boolean.TRUE);
					}
				}
				ArrayList listCb = dx.getListCb();
				if (listCb != null && listCb.size() > 0) {
					for (Iterator iter = listCb.iterator(); iter.hasNext();) {
						KntcCanBoRls gbn = (KntcCanBoRls) iter.next();
						dao.saveObject(appContext, gbn, Boolean.TRUE);
					}
				}
				ArrayList listPa = dx.getListPa();
				if (listPa != null && listPa.size() > 0) {
					for (Iterator iter = listPa.iterator(); iter.hasNext();) {
						KtnbPaHsRls gbn = (KtnbPaHsRls) iter.next();
						dao.saveObject(appContext, gbn, Boolean.TRUE);
					}
				}
			} else // Update
			{
				dao.updateObject(appContext, dx.getBienBan(), Boolean.TRUE);
				ArrayList listDtl = dx.getListDm();
				if (listDtl != null && listDtl.size() > 0) {
					for (Iterator iter = listDtl.iterator(); iter.hasNext();) {
						KntcDmRls gbn = (KntcDmRls) iter.next();
						dao.updateObject(appContext, gbn, Boolean.TRUE);
					}
				}
				ArrayList listCb = dx.getListCb();
				if (listCb != null && listCb.size() > 0) {
					for (Iterator iter = listCb.iterator(); iter.hasNext();) {
						KntcCanBoRls gbn = (KntcCanBoRls) iter.next();
						dao.updateObject(appContext, gbn, Boolean.TRUE);
					}
				}
				ArrayList listPa = dx.getListPa();
				if (listPa != null && listPa.size() > 0) {
					for (Iterator iter = listPa.iterator(); iter.hasNext();) {
						KtnbPaHsRls gbn = (KtnbPaHsRls) iter.next();
						dao.updateObject(appContext, gbn, Boolean.TRUE);
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
	 * Lấy thông tin biên bản để chuyển hồ sơ
	 * 
	 * @param context
	 * @param maBienBan
	 *            Mã biên bản
	 * @param maHoSo
	 *            Mã hồ sơ
	 * @return KntcBienBanChuyenHoSo
	 */
	public KntcBienBanChuyenHoSo getBienBan(ApplicationContext context, String maBienBan, String maHoSo) {
		KntcBienBanChuyenHoSo retVal = null;
		return retVal;
	}

	/**
	 * Lưu hoặc cập nhật quyết định giải quyết KN cần xác minh
	 * 
	 * @param appContext
	 * @param qd
	 *            Quyết định giải quyết
	 * @throws KtnbException
	 */
	public void saveQuyetDinhGqKN(ApplicationContext appContext, KntcQdinhGquyet qd) throws Exception {
		Session session = null;
		UserTransaction tx = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();
			if (Formater.isNull(qd.getMa())) // Save
			{
				qd.setMa(KeyManagement.getGUID());
				dao.saveObject(appContext, qd, Boolean.TRUE);
			} else // Update
			{
				dao.updateObject(appContext, qd, Boolean.TRUE);
			}
			if (qd.getNgayDuyet() != null) {
				String sql = "Update KNTC_HO_SO_HDR set TRANG_THAI=?,NGAY_KET_THUC =? where MA_HS=?";
				Query q = session.createSQLQuery(sql);
				q.setParameter(0, new Long(Constants.TT_KNTC_THI_HANH));
				q.setParameter(1, qd.getNgayDuyet());
				q.setParameter(2, qd.getMaHs());
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
	 * Lưu thông tin theo dõi việc giải quyết KNTC
	 * 
	 * @param appContext
	 *            Context
	 * @param Qd
	 *            Hồ sơ theo dõi
	 * @throws KtnbException
	 *             Lỗi
	 */
	public void saveTheoDoiGqKN(ApplicationContext appContext, KntcHoSoTheoDoi qd) throws Exception {
		if (Formater.isNull(qd.getMa())) // Save
		{
			qd.setMa(KeyManagement.getGUID());
			dao.saveObject(appContext, qd);
		} else // Update
		{
			dao.saveObject(appContext, qd);
		}
	}

	/**
	 * Lưu thông tin theo dõi thi hành giải quyết KN
	 * 
	 * @param appContext
	 * @param listTheoDoi
	 * @throws Exception
	 */
	public void saveTheoDoiGqKN(ApplicationContext appContext, Collection listTheoDoi) throws Exception {
		if (Formater.isNull(listTheoDoi))
			return;
		else {
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
				for (Iterator iter = listTheoDoi.iterator(); iter.hasNext();) {
					KntcHoSoTheoDoi gbn = (KntcHoSoTheoDoi) iter.next();
					if (Formater.isNull(gbn.getMa())) {
						gbn.setMa(KeyManagement.getGUID());
						dao.saveObject(appContext, gbn, Boolean.TRUE);
					} else
						dao.updateObject(appContext, gbn, Boolean.TRUE);
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
	}

	/**
	 * Lấy thông tin quyết định giải quyết theo mã hồ sơ
	 * 
	 * @param appContext
	 * @param maHs
	 *            Mã hồ sơ
	 * @return KntcQdinhGquyet
	 * @throws Exception
	 */
	public KntcQdinhGquyet getQdinhGquyet(ApplicationContext appContext, String maHs) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcQdinhGquyet.class);
		sc.addSearchItem("maHs", maHs);
		return (KntcQdinhGquyet) services.retriveObject(appContext, sc);
	}
	
	/**
	 * Lấy thông báo kết quả giải quyết theo mã hồ sơ
	 * 
	 * @param appContext
	 * @param maHs
	 * @return KntcThongBaoKqgq
	 * @throws Exception
	 */
	public KntcThongBaoKqgq getThongBaoKqgq(ApplicationContext appContext, String maHs) throws Exception {
		CatalogService service = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcThongBaoKqgq.class);
		sc.addSearchItem("maHs", maHs);
		return (KntcThongBaoKqgq) service.retriveObject(appContext, sc);
	}

	/**
	 * Lưu thông báo giải quyết TC
	 * 
	 * @param appContext
	 * @param tb
	 * @throws Exception
	 */
	public void saveTbGQTC(ApplicationContext appContext, KntcThongBaoKqgq tb) throws Exception {
		Session session = null;
		UserTransaction tx = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();
			String sql = "Update KNTC_HO_SO_HDR set TRANG_THAI=? where MA_HS=?";
			Query q = session.createSQLQuery(sql);
			q.setParameter(0, new Long(Constants.TT_KNTC_THI_HANH));
			q.setParameter(1, tb.getMaHs());
			q.executeUpdate();
			if (Formater.isNull(tb.getMa()))// Save
			{
				tb.setMa(KeyManagement.getGUID());
				dao.saveObject(appContext, tb, Boolean.TRUE);
			} else // Update
			{
				dao.saveObject(appContext, tb, Boolean.TRUE);
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
	/***
	 * Lấy thông tin báo cáo kết quả thực hiện ( Dùng chung cả KN và TC )
	 * @param appContext
	 * @param maHs
	 * @return
	 * @throws Exception
	 */
	public KntcBCKQThucHienQDKN getBCKQThucHienKN(ApplicationContext appContext, String maHs) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcBCKQThucHienQDKN.class);
		sc.addSearchItem("maHs", maHs);
		return (KntcBCKQThucHienQDKN) services.retriveObject(appContext, sc);
	}
	/***
	 * Lưu thông tin báo cáo kết quả thực hiện ( Dùng chung cả KN và TC )
	 * @param appContext
	 * @param qd
	 * @throws Exception
	 */
	public void saveBCKQThucHienKN(ApplicationContext appContext, KntcBCKQThucHienQDKN bc) throws Exception {
	Session session = null;
	UserTransaction tx = null;
	try {
		try {
			tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
			tx.begin();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		session = HibernateSessionFactory.currentSession();
		if (Formater.isNull(bc.getMa()))
		{
			bc.setMa(KeyManagement.getGUID());
			dao.saveObject(appContext, bc, Boolean.TRUE);
		} 
		//Update
		else 
		{
			dao.updateObject(appContext, bc, Boolean.TRUE);
		}
		if (bc.getNgayNhanBckq() != null && bc.getKetThucTdoiThiHanh()!=null && bc.getKetThucTdoiThiHanh().intValue()==1) {
			String sql = "Update KNTC_HO_SO_HDR set TRANG_THAI=?,NGAY_KET_THUC =?,LOAI_KET_THUC=? where MA_HS=?";
			Query q = session.createSQLQuery(sql);
			q.setParameter(0, new Long(Constants.TT_KNTC_KET_THUC));
			q.setParameter(1, bc.getNgayNhanBckq());
			q.setParameter(2, Constants.KNTC_KET_THUC_THUONG);
			q.setParameter(3, bc.getMaHs());
			q.executeUpdate();				
		}
		session.flush();
		tx.commit();
	} catch (Exception e) {
		e.printStackTrace();		
		tx.rollback();
		throw new Exception(e);
	} finally {
		HibernateSessionFactory.closeSession(session);
	}
	}
}
