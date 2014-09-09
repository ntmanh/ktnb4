package cmc.com.ktnb.service;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.naming.InitialContext;
import javax.transaction.UserTransaction;

import org.hibernate.Query;
import org.hibernate.Session;

import cmc.com.ktnb.pl.hb.entity.KntcCanBoRls;
import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.service.kntc.KntcSoTiepDan;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.SearchCriteria;

/**
 * @author ntthu - cmcsoft Nov 17, 2010 ktnb_web
 */
public class KtnbService {
	protected BaseHibernateDAO dao = new BaseHibernateDAO();

	/**
	 * 
	 */
	public KtnbService() {
		super();
	}

	/**
	 * Save hoac Update Phan cong can bo xu ly ho so
	 */
	public void saveTvd(ApplicationContext appContext, String maHoSo, Collection kntcCanBoRls, boolean isInTrans) throws Exception {
		Session session = null;
		UserTransaction tx = null;
		try {
			if (!isInTrans) {
				try {
					tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
					tx.begin();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			session = HibernateSessionFactory.currentSession();
			if (!Formater.isNull(maHoSo)) {
				String sql = "update kntc_can_bo_rls set lan_td = lan_td+1,NGAY_HET_HLUC=? where ma_hs =? ";
				Query q = session.createSQLQuery(sql);
				q.setDate(0, new Date());
				q.setParameter(1, maHoSo);
				q.executeUpdate();
			}
			for (Iterator iter = kntcCanBoRls.iterator(); iter.hasNext();) {
				KntcCanBoRls cbRls = (KntcCanBoRls) iter.next();
				dao.saveObject(appContext, cbRls, Boolean.TRUE);
			}
			if (!isInTrans) {
				session.flush();
				tx.commit();
			}
		} catch (Exception e) {
			if (!isInTrans) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			if (!isInTrans) {
				HibernateSessionFactory.closeSession(session);
			}
		}
	}

	/**
	 * Lấy thông tin thành viên đoàn
	 * @param appContext
	 * @param maHoSo
	 * @return
	 * @throws Exception
	 */
	public Collection getTvd(ApplicationContext appContext, String maHoSo) throws Exception {
		SearchCriteria cri = new SearchCriteria(KntcCanBoRls.class);
		cri.addSearchItem("maHs", maHoSo);
		cri.addSearchItem("lanTd", new Long(0));
		cri.addSearchItem("ngayHetHluc", null, SearchCriteria.LG_IS_NULL);
		cri.addSearchItem("loaiCb", KntcCanBoRls.KNTC_TVD_XAC_MINH);
		return dao.retrieveObjects(appContext, cri);
	}

	public Collection getCbxl(ApplicationContext appContext, String maHoSo) throws Exception {
		SearchCriteria cri = new SearchCriteria(KntcCanBoRls.class);
		cri.addSearchItem("maHs", maHoSo);
		cri.addSearchItem("lanTd", new Long(0));
		cri.addSearchItem("ngayHetHluc", null, SearchCriteria.LG_IS_NULL);
		cri.addSearchItem("loaiCb", KntcCanBoRls.KNTC_CB_XU_LY);
		return dao.retrieveObjects(appContext, cri);
	}

	/**
	 * Lay thong tin so tiep dan
	 * 
	 * @param appContext
	 * @param maHoSo
	 *            Ma ho so
	 * @param isSimple
	 *            Chi lay thong tin chung (Header)
	 * @return KntcSoTiepDan
	 * @throws Exception
	 */

	public KntcSoTiepDan getSoTiepDan(ApplicationContext appContext, String maHoSo, boolean isSimple) throws Exception {
		KntcHoSoHdr hdr = (KntcHoSoHdr) dao.retrieveObject(appContext, KntcHoSoHdr.class, maHoSo);
		KntcSoTiepDan std = new KntcSoTiepDan(hdr);
		// if (!isSimple) {
		// KntcNdungDon don = (KntcNdungDon) dao.retrieveObject(appContext, KntcNdungDon.class, maHoSo);
		// //std.setNoiDungDon(don);
		// }
		return std;
	}
}
