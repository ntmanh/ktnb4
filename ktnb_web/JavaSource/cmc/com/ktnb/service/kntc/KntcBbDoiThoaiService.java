package cmc.com.ktnb.service.kntc;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.transaction.UserTransaction;

import org.hibernate.Session;

import cmc.com.ktnb.pl.hb.entity.KntcBbDoiThoai;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.HibernateSessionFactory;

public class KntcBbDoiThoaiService {
	protected BaseHibernateDAO dao = new BaseHibernateDAO();

	/**
	 * Ham khoi tao mac dinh
	 * 
	 */
	public KntcBbDoiThoaiService() {
		super();
		try {
			conn = DataSourceConfiguration.getConnection();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private Connection conn = null;

	/**
	 * Dong ket noi
	 * 
	 */
	public void close() {
		DataSourceConfiguration.releaseSqlResources(conn);
	}
	
	
	/**
	 * Luu de bien ban doi thoai
	 * 
	 * @param appContext
	 * @param dxxl :
	 *            De xuat xu ly
	 * @throws Exception
	 */
	
	public void saveBbDoiThoai(ApplicationContext appContext, KntcBbDoiThoai bbdt) throws Exception{
		UserTransaction tx=null;
		Session session=null;
		try {
			tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
			tx.begin();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		BaseHibernateDAO dao = new BaseHibernateDAO();
		session = HibernateSessionFactory.currentSession();
	}
	
}
