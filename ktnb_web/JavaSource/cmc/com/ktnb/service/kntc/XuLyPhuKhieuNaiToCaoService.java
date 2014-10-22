package cmc.com.ktnb.service.kntc;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.hibernate.Session;

import cmc.com.ktnb.pl.hb.entity.KntcBbDoiThoai;
import cmc.com.ktnb.pl.hb.entity.KntcGiaoNvXmTc;
import cmc.com.ktnb.pl.hb.entity.KntcNoiDungTCTT;
import cmc.com.ktnb.pl.hb.entity.KntcQdDinhChiKN;
import cmc.com.ktnb.pl.hb.entity.KntcQdHuyTamDinhChiKN;
import cmc.com.ktnb.pl.hb.entity.KntcQdTamDinhChiKn;
import cmc.com.ktnb.pl.hb.entity.KntcTbKhongThuLyGqTiep;
import cmc.com.ktnb.pl.hb.entity.KntcTbKoThuLyGq;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.web.catalog.CatalogService;
import cmc.com.ktnb.web.kntc.xac_minh.QDTamDinhChiThiHanhKNForm;
import cmc.com.ktnb.web.kntc.xac_minh.QuyetDinhDinhChiKNForm;
import cmc.com.ktnb.web.kntc.xac_minh.tien_hanh.BienBanDoiThoaiForm;

public class XuLyPhuKhieuNaiToCaoService {
	//	 Connnection String
	private Connection conn = null;
	protected BaseHibernateDAO dao = new BaseHibernateDAO();
	// Defauld constructor 
	public XuLyPhuKhieuNaiToCaoService() {
		
	}
	
	/**
	 * Khieu nai  
	 * 
	 */
	// Bien ban doi thoai 
	public KntcBbDoiThoai findBbDoiThoai(ApplicationContext app, String soQd) throws Exception
	{
		CatalogService services=new CatalogService();
		SearchCriteria sc=new SearchCriteria(KntcBbDoiThoai.class);
		sc.addSearchItem("soQD", soQd);
		KntcBbDoiThoai bbdt=(KntcBbDoiThoai) services.retriveObject(app, sc);
		return bbdt;
	}
	
	public void saveBienBanDoiThoai(HttpServletRequest request, ApplicationContext appContext, KntcBbDoiThoai bbDoiThoai) throws Exception
	{
		UserTransaction tx=null;
		Session session=null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session=HibernateSessionFactory.currentSession();
			// Khoi tao id neu null idbbDoiThoai 
			if(Formater.isNull(bbDoiThoai.getId()))
			{
				bbDoiThoai.setId(KeyManagement.getGUID());
				dao.saveObject(appContext, bbDoiThoai);
			}
			else 
			{
				dao.updateObject(appContext, bbDoiThoai, Boolean.TRUE);
			}
			session.flush();
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		}
		finally
		{
			HibernateSessionFactory.closeSession(session);
		}
	}
	// Quyet dinh dinh chi khieu nai 
	public KntcQdDinhChiKN findQdDinhChiKN(ApplicationContext app,String soHoSo) throws Exception
	{
		CatalogService services=new CatalogService();
		SearchCriteria sc=new SearchCriteria(KntcQdDinhChiKN.class);
		sc.addSearchItem("soHoSo", soHoSo);
		KntcQdDinhChiKN qddc=(KntcQdDinhChiKN) services.retriveObject(app, sc);
		return qddc;
	}
	public void saveQdDinhChiKn(HttpServletRequest request, ApplicationContext appContext, KntcQdDinhChiKN dinhChiKN) throws Exception
	{
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
			if(Formater.isNull(dinhChiKN.getId()))
			{
				dinhChiKN.setId(KeyManagement.getGUID());
				dao.saveObject(appContext,dinhChiKN);
			}
			else 
			{
				dao.updateObject(appContext,dinhChiKN,Boolean.TRUE);
				session.flush();
				tx.commit();
			}
			
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		}
		finally
		{
			HibernateSessionFactory.closeSession(session);
		}
	}
	
	// Quyet dinh tam dinh chi khieu nai 
	public KntcQdTamDinhChiKn findQdTamDinhChiKN (ApplicationContext appContext, String soHoSo) throws Exception
	{
		CatalogService services=new CatalogService();
		SearchCriteria sc=new SearchCriteria(KntcQdTamDinhChiKn.class);
		sc.addSearchItem("soHs", soHoSo);
		KntcQdTamDinhChiKn tdc=(KntcQdTamDinhChiKn) services.retriveObject(appContext, sc);
		return tdc;
	}
	public void saveTamDinhChiKn(HttpServletRequest request, ApplicationContext appContext,KntcQdTamDinhChiKn tamDinhChiKn) throws Exception
	{
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
			if(Formater.isNull(tamDinhChiKn.getId()))
			{
				tamDinhChiKn.setId(KeyManagement.getGUID());
				dao.saveObject(appContext, tamDinhChiKn);
			}
			else {
				dao.updateObject(appContext, tamDinhChiKn, Boolean.TRUE);
				session.flush();
				tx.commit();
			}
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		}
		finally
		{
			HibernateSessionFactory.closeSession(session);
		}
	}
	
	// Quyet dinh huy tam dinh chi khieu nai
	public KntcQdHuyTamDinhChiKN findHuyTamDinhChi(ApplicationContext appContext, String soHoSo) throws Exception
	{
		CatalogService services=new CatalogService();
		SearchCriteria sc=new SearchCriteria(KntcQdHuyTamDinhChiKN.class);
		sc.addSearchItem("soHoSo", soHoSo);
		KntcQdHuyTamDinhChiKN hdc=(KntcQdHuyTamDinhChiKN) services.retriveObject(appContext, sc);
		return hdc;
	}
	public void saveHuyTamDinhChiKn(HttpServletRequest request, ApplicationContext appContext,KntcQdHuyTamDinhChiKN huyTamDinhChiKn) throws Exception
	{
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
			if(Formater.isNull(huyTamDinhChiKn.getId()))
			{
				huyTamDinhChiKn.setId(KeyManagement.getGUID());
				dao.saveOrUpdateObject(appContext, huyTamDinhChiKn);
			}
			else {
				dao.updateObject(appContext,huyTamDinhChiKn,Boolean.TRUE);
				session.flush();
				tx.commit();
			}
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		}
		finally
		{
			HibernateSessionFactory.closeSession(session);
		}
	}
	/**
	 * To cao 
	 */
	// Bien ban noi dung to cao truc tiep
	public KntcNoiDungTCTT findNoiDungTc(ApplicationContext appContext, String soHoSo) throws Exception
	{
		KntcNoiDungTCTT tctt=new KntcNoiDungTCTT();
		CatalogService services=new CatalogService();
		SearchCriteria sc=new SearchCriteria(KntcNoiDungTCTT.class);
		sc.addSearchItem("soHoSo", soHoSo);
		tctt=(KntcNoiDungTCTT) services.retriveObject(appContext, sc);
		return tctt;
	}
	// Thong bao khong thu ly giai quyet
	public KntcTbKoThuLyGq findTbkoThuLyGq(ApplicationContext appContext, String soHoSo) throws Exception
	{
		KntcTbKoThuLyGq koThuLyGq=new KntcTbKoThuLyGq();
		CatalogService services=new CatalogService();
		SearchCriteria sc=new SearchCriteria(KntcTbKoThuLyGq.class);
		sc.addSearchItem("soHoSo", soHoSo);
		koThuLyGq=(KntcTbKoThuLyGq) services.retriveObject(appContext, sc);
		return koThuLyGq;
	}
	// Thong bao khong thu ly giai quyet tiep
	public KntcTbKhongThuLyGqTiep findTbkhongThuLyGqTiep(ApplicationContext appContext, String soHoSo) throws Exception
	{
		KntcTbKhongThuLyGqTiep koGqTiep=new KntcTbKhongThuLyGqTiep();
		CatalogService services=new CatalogService();
		SearchCriteria sc=new SearchCriteria(KntcTbKhongThuLyGqTiep.class);
		sc.addSearchItem("soHoSo", soHoSo);
		koGqTiep=(KntcTbKhongThuLyGqTiep) services.retriveObject(appContext, sc);
		return koGqTiep;
	}
	
	// Giao nhiem vu xac minh 
	public KntcGiaoNvXmTc findGiaoNvXm(ApplicationContext appContext, String soHoSo) throws Exception
	{
		KntcGiaoNvXmTc giaoxm=new KntcGiaoNvXmTc();
		CatalogService services=new CatalogService();
		SearchCriteria sc=new SearchCriteria(KntcGiaoNvXmTc.class);
		sc.addSearchItem("soHoSo", soHoSo);
		giaoxm=(KntcGiaoNvXmTc) services.retriveObject(appContext,sc);
		return giaoxm;
	}
	
	

}
