package cmc.com.ktnb.web.catalog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cmc.com.ktnb.pl.hb.entity.KtnbDmCanbo;
import cmc.com.ktnb.pl.hb.entity.PersistentObject;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.vo.CategoryVO;

public class CatalogService implements ICatalogService {
	private BaseHibernateDAO dao;

	public CatalogService() {
		dao = new BaseHibernateDAO();
	}

	public PersistentObject insert(ApplicationContext theApp, PersistentObject perObject) throws Exception {
		if ((theApp == null) || (perObject == null)) {
			throw new NullPointerException("illegal parameter");
		}
		Transaction tx = null;
		try {
			Session session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			perObject = dao.saveObject(theApp, perObject, Boolean.TRUE);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (Exception etx) {
					etx.printStackTrace();
				}
			}
			throw e;
		}
		return perObject;
	}

	public void delete(ApplicationContext theApp, PersistentObject perObject) throws Exception {
		if ((theApp == null) || (perObject == null)) {
			throw new NullPointerException("illegal parameter");
		}
		Transaction tx = null;
		try {
			Session session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			dao.deleteObject(theApp, perObject, Boolean.TRUE);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (Exception etx) {
					etx.printStackTrace();
				}
			}
			throw e;
		}
	}

	public void update(ApplicationContext theApp, PersistentObject perObject) throws Exception {
		if ((theApp == null) || (perObject == null)) {
			throw new NullPointerException("illegal parameter");
		}
		Transaction tx = null;
		try {
			Session session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			dao.updateObject(theApp, perObject, Boolean.TRUE);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (Exception etx) {
					etx.printStackTrace();
				}
			}
			throw e;
		}
	}

	public void saveOrUpdate(ApplicationContext theApp, PersistentObject perObject) throws Exception {
		if ((theApp == null) || (perObject == null)) {
			throw new NullPointerException("illegal parameter");
		}
		Transaction tx = null;
		try {
			Session session = HibernateSessionFactory.currentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(perObject);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (Exception etx) {
					etx.printStackTrace();
				}
			}
			throw e;
		}
	}

	public PersistentObject retriveObject(ApplicationContext theApp, SearchCriteria searchCriteria) throws Exception {
		if ((theApp == null) || (searchCriteria == null))
			throw new NullPointerException("illegal parameter");
		PersistentObject retval = null;
		try {
			Session session = HibernateSessionFactory.currentSession();
			Collection ret = dao.retrieveObjects(theApp, searchCriteria, Boolean.FALSE, false, false);
			for (Iterator iter = ret.iterator(); iter.hasNext();) {
				retval = (PersistentObject) iter.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retval;
	}

	public Collection retrive(ApplicationContext theApp, SearchCriteria searchCriteria) throws Exception {
		if ((theApp == null) || (searchCriteria == null))
			throw new NullPointerException("illegal parameter");
		Collection retval = null;
		try {
			Session session = HibernateSessionFactory.currentSession();
			retval = dao.retrieveObjects(theApp, searchCriteria, Boolean.FALSE, false, false);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retval;
	}

	/**
	 * Lay tat ca thong tin cua 1 doi tuong
	 * 
	 * @param theApp
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public Collection retriveAll(ApplicationContext theApp, Class po) throws Exception {
		if ((theApp == null) || (po == null))
			throw new NullPointerException("illegal parameter");
		Collection retval = null;
		try {
			SearchCriteria searchCriteria = new SearchCriteria();
			searchCriteria.setSearchClass(po);
			retval = dao.retrieveObjects(theApp, searchCriteria, Boolean.TRUE, false, true);
		} catch (Exception e) {
			throw e;
		}
		return retval;
	}

	/**
	 * Lay tat ca thong tin cua 1 doi tuong
	 * 
	 * @param theApp
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public PersistentObject retriveById(ApplicationContext theApp, Class po, Object id) throws Exception {
		if (theApp == null || po == null || id == null) {
			throw new NullPointerException("illegal parameter");
		}
		PersistentObject retval = null;
		try {
			SearchCriteria searchCriteria = new SearchCriteria();
			searchCriteria.setSearchClass(po);
			retval = dao.retrieveObject(theApp, po, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retval;
	}

	//Lấy ra các biểu mẫu cần lập tùy trường hợp phân loại
	public static Collection getDmByParentId(String maCha) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection retval = new ArrayList();
		String sql = "select ma,ten from ktnb_dm where parent_id =? and ngay_het_hl is null order by ten";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maCha);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryVO vo = new CategoryVO(rs.getString(1), rs.getString(2));
				retval.add(vo);
			}
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}

	public static Collection getDmBieuMauByPId(String maCha) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection retval = new ArrayList();
		String sql = "select t.ma,t.ten,t1.url from ktnb_dm t,ktnb_dm_bieu_mau t1  where t.ma=t1.cid and t1.pid=?";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maCha);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryVO vo = new CategoryVO(rs.getString(1), rs.getString(2), rs.getString(3));
				retval.add(vo);
			}
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}

	// P: Get dam muc by Ma
	public static CategoryVO getDmById(String dmID) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CategoryVO retval = null;
		String sql = "select ma,ten from ktnb_dm where ma =? and hien_thi=1";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dmID);
			rs = ps.executeQuery();
			while (rs.next()) {
				retval = new CategoryVO(rs.getString(1), rs.getString(2));
			}
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}


	/**
	 * Tra ve ten danh muc
	 * 
	 * @param dmID
	 * @return
	 * @throws Exception
	 */
	public static String getTenDanhMucById(String dmID) throws Exception {
		CategoryVO c = getDmById(dmID);
		if(c!=null)
			return c.getName();
		return "N/A";
	}

	public static String getTenCanBoByMa(ApplicationContext appContext, String maCb) throws Exception {
		CatalogService cs = new CatalogService();
		KtnbDmCanbo aCb = (KtnbDmCanbo) cs.retriveById(appContext, KtnbDmCanbo.class, maCb);
		if (aCb == null)
			return "N/A";
		else
			return aCb.getTen();
	}
	
	
	
	public static final String KNTC_THAM_QUYEN = "150101"; // Thuoc tham quyen KN

	public static final String KNTC_THAM_QUYEN_THU_LY = "15010101"; // Thu ly don

	public static final String KNTC_THAM_QUYEN_TC = "150102"; // Thuoc tham quyen KN

	public static final String KNTC_THAM_QUYEN_THU_LY_TC = "15010201"; // Thu ly don

	public static final String KNTC_THAM_QUYEN_HH = "150103"; // Thuoc tham quyen KN

	public static final String KNTC_THAM_QUYEN_THU_LY_HH = "15010301"; // Thu ly don

	public static final String KNTC_TRANG_THAI = "16"; // Trang thai ho so KNTC

	public static final String VB_CAN_CU_TC = "2301";

	public static final String VB_CAN_CU_CUC = "2303";

	public static final String VB_CAN_CU_CHI_CUC = "2305";

}
