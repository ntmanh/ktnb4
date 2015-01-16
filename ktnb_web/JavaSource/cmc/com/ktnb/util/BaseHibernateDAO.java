package cmc.com.ktnb.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.UserTransaction;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;
import cmc.com.ktnb.pl.hb.entity.PersistentObjectLogger;

public class BaseHibernateDAO implements IBaseHibernateDAO {
	private Session session = null;

	public BaseHibernateDAO() {
		super();
		session = HibernateSessionFactory.currentSession();
	}

	public PersistentObject saveObject(ApplicationContext appContext, PersistentObject entity, Boolean isInTran) throws Exception {
		if ((appContext == null) || (entity == null))
			throw new NullPointerException("Invalid parameters! Check input!");
		UserTransaction tx = null;
		Session session = null;
		try {
			// session = getSession(request);
			if (entity instanceof PersistentObjectLogger) {
				((PersistentObjectLogger) entity).setUserCreated(appContext.getTenNsd());
				((PersistentObjectLogger) entity).setDateCreated(new Date(System.currentTimeMillis()));
			}
			if (!isInTran.booleanValue()) {
				try {
					tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
					tx.begin();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				session = HibernateSessionFactory.currentSession();
				session.save(entity);
				session.flush();
				tx.commit();
			} else {
				session = HibernateSessionFactory.currentSession();
				session.save(entity);
			}
			KtnbLogging.insertLog(appContext, entity, "Save", null);
		} catch (Exception e) {
			e.printStackTrace();
			if (!isInTran.booleanValue()) {
				try {
					tx.rollback();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			throw e;
		} finally {
			if (!isInTran.booleanValue()) {
				HibernateSessionFactory.closeSessionQuiet();
			}
		}
		return entity;
	}

	public void updateObject(ApplicationContext appContext, PersistentObject entity, Boolean isInTran) throws Exception {
		if ((appContext == null) || (entity == null))
			throw new NullPointerException("Input value is null!");
		UserTransaction tx = null;
		try {
			if (!isInTran.booleanValue()) {
				try {
					tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
					tx.begin();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				session = HibernateSessionFactory.currentSession();
				session.update(entity);
				session.flush();
				tx.commit();
			} else {
				session = HibernateSessionFactory.currentSession();
				session.update(entity);
			}
			KtnbLogging.insertLog(appContext, entity, "Update", null);
		} catch (Exception e) {
			e.printStackTrace();
			if (!isInTran.booleanValue()) {
				try {
					tx.rollback();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			throw e;
		} finally {
			if (!isInTran.booleanValue()) {
				HibernateSessionFactory.closeSessionQuiet();
			}
		}
	}

	public void mergeObj(ApplicationContext appContext, PersistentObject entity, Boolean isInTran) throws Exception {
		if ((appContext == null) || (entity == null))
			throw new NullPointerException("Input value is null!");
		Transaction tx = null;
		try {
			if (entity instanceof PersistentObjectLogger) {
				((PersistentObjectLogger) entity).setUserCreated(appContext.getTenNsd());
				((PersistentObjectLogger) entity).setDateCreated(appContext.getSystemDate());
			}
			if (!isInTran.booleanValue()) {
				tx = session.beginTransaction();
				session.merge(entity);
				tx.commit();
			} else {
				session.update(entity);
			}
			KtnbLogging.insertLog(appContext, entity, "Merge", null);
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				try {
					tx.rollback();
				} catch (Exception etx) {
					etx.printStackTrace();
				}
			}
			throw e;
		}
	}

	public PersistentObject saveOrUpdateObject(ApplicationContext appContext, PersistentObject entity, Boolean isInTran) throws Exception {
		if ((appContext == null) || (entity == null))
			throw new NullPointerException("Invalid parameters! Check input!");
		UserTransaction tx = null;
		Session session = null;
		try {
			if (entity instanceof PersistentObjectLogger) {
				((PersistentObjectLogger) entity).setUserCreated(appContext.getTenNsd());
				((PersistentObjectLogger) entity).setDateCreated(appContext.getSystemDate());
			}
			if (!isInTran.booleanValue()) {
				try {
					tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
					tx.begin();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				session = HibernateSessionFactory.currentSession();
				session.saveOrUpdate(entity);
				session.flush();
				tx.commit();
			} else {
				session = HibernateSessionFactory.currentSession();
				session.saveOrUpdate(entity);
			}
			KtnbLogging.insertLog(appContext, entity, "SaveOrUpdate", null);
		} catch (Exception e) {
			e.printStackTrace();
			if (!isInTran.booleanValue()) {
				try {
					tx.rollback();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			throw e;
		} finally {
			if (!isInTran.booleanValue()) {
				HibernateSessionFactory.closeSessionQuiet();
			}
		}
		return entity;
	}

	public void deleteObject(ApplicationContext appContext, PersistentObject entity, Boolean isInTran) throws Exception {
		if ((appContext == null) || (entity == null))
			throw new NullPointerException("input value is null");

		UserTransaction tx = null;
		Session session = null;
		try {
			if (entity instanceof PersistentObjectLogger) {
				((PersistentObjectLogger) entity).setUserCreated(appContext.getTenNsd());
				((PersistentObjectLogger) entity).setDateCreated(appContext.getSystemDate());
			}
			if (!isInTran.booleanValue()) {
				try {
					tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
					tx.begin();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				session = HibernateSessionFactory.currentSession();
				session.delete(entity);
				session.flush();
				tx.commit();
			} else {
				session = HibernateSessionFactory.currentSession();
				session.delete(entity);
			}
			KtnbLogging.insertLog(appContext, entity, "Delete", null);
		} catch (Exception e) {
			e.printStackTrace();
			if (!isInTran.booleanValue()) {
				try {
					tx.rollback();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			throw e;
		} finally {
			if (!isInTran.booleanValue()) {
				HibernateSessionFactory.closeSessionQuiet();
			}
		}

	}

	public PersistentObject saveObject(ApplicationContext appContext, PersistentObject entity) throws Exception {
		return saveObject(appContext, entity, Boolean.FALSE);
	}

	public void updateObject(ApplicationContext appContext, PersistentObject entity) throws Exception {
		this.updateObject(appContext, entity, Boolean.FALSE);
	}

	public void saveOrUpdateObject(ApplicationContext appContext, PersistentObject entity) throws Exception {
		this.saveOrUpdateObject(appContext, entity, Boolean.FALSE);
	}

	public void deleteObject(ApplicationContext appContext, PersistentObject entity) throws Exception {
		this.deleteObject(appContext, entity, Boolean.FALSE);
	}

	public Collection retrieveObjects(ApplicationContext appContext, SearchCriteria cri, Boolean isInTran, boolean ignoreEndDate, boolean forceCache) throws Exception {
		if ((appContext == null) || (cri == null) || (cri.getSearchClass() == null))
			throw new NullPointerException("input value is null");
		ArrayList pName = cri.getPropertyName();
		ArrayList pValue = cri.getPropertyValue();
		ArrayList operation = cri.getOperation();
		ArrayList logOperation = cri.getLogicOperation();
		Collection retval = new ArrayList();
		// Transaction tx = null;
		try {
			// if (!isInTran.booleanValue()) tx = session.beginTransaction();
			session = HibernateSessionFactory.currentSession();
			if (!session.isOpen())
				session = HibernateSessionFactory.openNewSession();
			Criteria criteria = session.createCriteria(cri.getSearchClass());
			int size = pName.size();
			Criterion criterion = null;
			for (int i = 0; i < size; i++) {
				String name = (String) pName.get(i);
				Object value = pValue.get(i);
				String oper = (String) operation.get(i);
				String logOper = (String) logOperation.get(i);
				Criterion criTmp = this.createCiterion(name, value, oper);
				if (criterion == null) {
					criterion = criTmp;
				} else {
					if (logOper.equals(SearchCriteria.LG_AND)) {
						criterion = Restrictions.and(criterion, criTmp);
					} else if (logOper.equals(SearchCriteria.LG_OR)) {
						criterion = Restrictions.or(criterion, criTmp);
					}
				}
			}
			if (criterion != null) {
				criteria.add(criterion);
			}
			// Them phan order
			if (cri.getOrderList() != null && cri.getOrderList().size() > 0) {
				for (int k = 0; k < cri.getOrderList().size(); k++) {
					criteria.addOrder(Order.asc((String) cri.getOrderList().get(k)));
				}
			}

			//Xu ly restricQuery
			if(!StringUtil.isBlankOrNull(cri.getRestricQuery())){
				criteria.add(Restrictions.sqlRestriction(cri.getRestricQuery()));
			}
			
			// if(!ignoreEndDate)
			// criteria.add(Expression.isNull("ngayHetHl"));

			QueryDetails queryDetails = cri.getQueryDetail();
			if (queryDetails != null) {
				criteria.setFirstResult(queryDetails.getBeginIndex());
				criteria.setMaxResults(queryDetails.getLastIndex());
				// criteria.setMaxResults(51);  
			}
			if (forceCache)
				criteria.setCacheable(true);
			retval = criteria.list();			
			//KtnbLogging.insertLog(appContext, null, "Retrieve", null);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retval;
	}

	public Collection retrieveObjects(ApplicationContext appContext, SearchCriteria cri) throws Exception {
		return retrieveObjects(appContext, cri, Boolean.FALSE, true, false);
	}

	/**
	 * Lay thong tin 1 object qua Id
	 * 
	 * @param appContext
	 * @param clazz
	 *            Loai PersistentObject
	 * @param id
	 *            ID
	 * @return
	 * @throws Exception
	 */
	public PersistentObject retrieveObject(ApplicationContext appContext, Class clazz, Object id, Boolean isInTrans) throws Exception {
		if ((appContext == null) || (id == null || id.equals("")) || (clazz == null))
			throw new NullPointerException("Input value was null!");
		PersistentObject entity;
		try {
			session = HibernateSessionFactory.currentSession();
			if (!session.isOpen())
				session = HibernateSessionFactory.openNewSession();
			entity = (PersistentObject) session.get(clazz, (Serializable) id);
			//KtnbLogging.insertLog(appContext, entity, "Retrieve", null);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return entity;
	}

	public PersistentObject retrieveObject(ApplicationContext appContext, Class clazz, Object id) throws Exception {
		return this.retrieveObject(appContext, clazz, id, new Boolean(false));
	}

	/**
	 * 
	 * @param name
	 * @param value
	 * @param oper
	 * @return
	 */
	private Criterion createCiterion(String name, Object value, String oper) {
		Criterion retval = null;
		if (SearchCriteria.OP_EQ.equals(oper)) {
			retval = Restrictions.eq(name, value);
		} else if (SearchCriteria.OP_GE.equals(oper)) {
			retval = Restrictions.ge(name, value);
		} else if (SearchCriteria.OP_GT.equals(oper)) {
			retval = Restrictions.eq(name, value);
		} else if (SearchCriteria.OP_LE.equals(oper)) {
			retval = Restrictions.le(name, value);
		} else if (SearchCriteria.OP_LIKE.equals(oper)) {
			retval = Restrictions.ilike(name, value);
		} else if (SearchCriteria.OP_LT.equals(oper)) {
			retval = Restrictions.lt(name, value);
		} else if (SearchCriteria.OP_NE.equals(oper)) {
			retval = Restrictions.ne(name, value);
		} else if (SearchCriteria.LG_IS_NULL.equals(oper)) {
			retval = Restrictions.isNull(name);
		} else if (SearchCriteria.LG_IS_NOT_NULL.equals(oper)) {
			retval = Restrictions.isNotNull(name);
		} else if (SearchCriteria.OP_IN.equals(oper)) {
			retval = Restrictions.in(name, (Collection) value);
		}
		return retval;
	}

	public void executeNativeSQL(ApplicationContext appContext, String sql, Boolean isInTran) throws Exception {
		if ((appContext == null) || (sql == null || sql.trim().equals("")))
			throw new NullPointerException("Input value is null!");
		Transaction tx = null;
		try {
			Query q = session.createSQLQuery(sql);
			if (!isInTran.booleanValue()) {
				tx = session.beginTransaction();
				q.executeUpdate();
				tx.commit();
			} else {
				q.executeUpdate();
			}
			KtnbLogging.insertLog(appContext, null, "NativeSQL", sql);
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				try {
					tx.rollback();
				} catch (Exception etx) {
					etx.printStackTrace();
				}
			}
			throw e;
		}
	}
}