package cmc.com.ktnb.util;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.transaction.UserTransaction;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * Configures and provides access to Hibernate sessions, tied to the
 * current thread of execution.  Follows the Thread Local Session
 * pattern, see {@link http://hibernate.org/42.html }.
 */
public class HibernateSessionFactory implements PlugIn {

	/** 
	 * Location of hibernate.cfg.xml file.
	 * Location should be on the classpath as Hibernate uses  
	 * #resourceAsStream style lookup for its configuration file. 
	 * The default classpath location of the hibernate config file is 
	 * in the default package. Use #setConfigFile() to update 
	 * the location of the configuration file for the current session.   
	 */
	public static final String SESSION_FACTORY_KEY = SessionFactory.class.getName();
	private boolean _storedInServletContext = true;
	private ActionServlet _servlet = null;
	private ModuleConfig _config = null;

	private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	private static Configuration configuration = new Configuration();
	private static org.hibernate.SessionFactory sessionFactory;

	public HibernateSessionFactory() {
	}
	public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
		_servlet = servlet;
		_config = config;
		initHibernate();
	}
	public void destroy() {
		_servlet = null;
		_config = null;
		try {
			sessionFactory.close();
			System.out.println("----STATISTICS: ----\n");
			System.out.println(sessionFactory.getStatistics().toString());
			System.out.println("----END STATISTICS! ----");
		} catch (Exception e) {
			System.err.println("Unable to destroy SessionFactory...(exception ignored)");
		}
	}

	/**
	 * Returns the Current Session instance in Transaction.
	 */
	public static Session currentSession(){
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			if(session.isOpen())
				session.setFlushMode(FlushMode.MANUAL);
		} catch (Exception e) {
			//e.printStackTrace();
			try {
				session = HibernateSessionFactory.openNewSession();
			} catch (Exception e1) {
				e1.printStackTrace();
			}			
		}
		return session;
	}
	/**
	 * Open new session (physical connection in Database)
	 * @return Session
	 * @throws Exception
	 */
	public static Session openNewSession() throws Exception {
		Session sess = null;
		try {
			//				System.out.println("HibernateSessionFactory.getCurrentSession()");
			sess = sessionFactory.openSession();
			sess.setFlushMode(FlushMode.MANUAL);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return sess;
	}

	public static void closeSession(Session session) throws Exception {
		try {
			//		Session session = getCurrentSession();
			if (session != null && session.isOpen()) {
				//				session.flush();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
		 *  Close the single hibernate session instance.
		 *
		 *  @throws HibernateException
		 */
	private static void closeSession() throws Exception {
		try {
			Session session = currentSession();
			if (session != null && session.isOpen()) {
				//				session.flush();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 
	 *
	 */
	public static void closeSessionQuiet() {
		try {
			closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 *  Close the single hibernate session instance.
	 *
	 *  @throws HibernateException
	 */
	private static void commitAndCloseSession() throws Exception {
		try {
			Session session = currentSession();
			if (session != null) {
				try {
					Transaction trans = session.getTransaction();
					if (trans != null && trans.isActive()) {
						if (trans.wasRolledBack())
							trans.rollback();
						else
							trans.commit();
					}
				} catch (HibernateException e) {
					e.printStackTrace();
				}
				if (session.isOpen()) {
					session.flush();
					session.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void commitAndCloseSessionQuiet() throws Exception {
		try {
			commitAndCloseSession();
		} catch (Exception e) {
			throw e;
		}
	}
	private static void rollback() throws Exception {
		try {
			Session session = currentSession();
			if (session != null) {
				Transaction trans = session.getTransaction();
				if (trans != null && trans.isActive()) {
					trans.rollback();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public static void rollbackQuiet() {
		try {
			rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initHibernate() throws ServletException {
		Configuration configuration = null;
		URL configFileURL = null;
		ServletContext context = null;		
		try {
			configFileURL = HibernateSessionFactory.class.getResource(CONFIG_FILE_LOCATION);
			context = _servlet.getServletContext();
			configuration = (new Configuration()).configure(configFileURL);
			sessionFactory = configuration.buildSessionFactory();
			context.setAttribute(SESSION_FACTORY_KEY, sessionFactory);
			/*
			//Thuc hien map Driver
			String sql = "select ktnb_owner.fncmapdriver() from dual";
			PreparedStatement ps = null;
			ResultSet rs = null;
			Connection conn = null;
			try {
				conn = DataSourceConfiguration.getConnection();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				if (rs.next())
					System.out.println("Map Done!");
			} catch (Exception e) {
				
			}	finally{
				DataSourceConfiguration.releaseSqlResources(rs, ps);
			}			
			*/
		} catch (Throwable t) {
			t.printStackTrace();
			System.err.println("Exception while initializing Hibernate.");
			System.err.println("Rethrowing exception..." + t.getMessage());
			throw (new ServletException(t));
		}
	}

	/**
	 * Setter for property configFilePath.
	 * @param configFilePath New value of property configFilePath.
	 */
	private void setConfigFilePath(String configFilePath) {
		if ((configFilePath == null) || (configFilePath.trim().length() == 0)) {
			throw new IllegalArgumentException("configFilePath cannot be blank or null.");
		}
		CONFIG_FILE_LOCATION = configFilePath;
	}

	/**
	 * Setter for property storedInServletContext.
	 * @param storedInServletContext New value of property storedInServletContext.
	 */
	public void setStoredInServletContext(String storedInServletContext) {
		if ((storedInServletContext == null) || (storedInServletContext.trim().length() == 0)) {
			storedInServletContext = "true";
		}
		_storedInServletContext = new Boolean(storedInServletContext).booleanValue();
	}

}