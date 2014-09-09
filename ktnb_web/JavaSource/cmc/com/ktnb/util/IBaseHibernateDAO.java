package cmc.com.ktnb.util;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import cmc.com.ktnb.pl.hb.entity.PersistentObject;


/**
 * Data access interface for domain model
 * @author ntthu
 */
public interface IBaseHibernateDAO {
	public PersistentObject saveObject(ApplicationContext appContext,PersistentObject entity, Boolean isInTran)throws Exception;
	public void updateObject(ApplicationContext appContext, PersistentObject entity,Boolean isInTran)throws Exception;
	public void deleteObject(ApplicationContext appContext,PersistentObject entity,Boolean isInTran) throws Exception;
	public PersistentObject saveObject(ApplicationContext appContext,PersistentObject entity) throws Exception;
	public void updateObject(ApplicationContext appContext, PersistentObject entity) throws Exception;
	public void deleteObject(ApplicationContext appContext,PersistentObject entity) throws Exception;
	public Collection retrieveObjects(ApplicationContext appContext, SearchCriteria cri,Boolean isInTran,boolean ignoreEndDate, boolean forceCache)throws Exception;
	public Collection retrieveObjects(ApplicationContext appContext, SearchCriteria cri)throws Exception;
	public void executeNativeSQL(ApplicationContext appContext,String sql,Boolean isInTran) throws Exception;
}