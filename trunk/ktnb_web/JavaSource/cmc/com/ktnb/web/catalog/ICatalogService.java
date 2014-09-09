/*
 * Created on Apr 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.catalog;

import java.util.Collection;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.SearchCriteria;

/**
 * @author dmha
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface ICatalogService {
	
	public PersistentObject insert(ApplicationContext theApp, PersistentObject perObject) throws Exception;
	public void delete(ApplicationContext theApp, PersistentObject perObject) throws Exception;
	public void update(ApplicationContext theApp, PersistentObject perObject) throws Exception;
	public void saveOrUpdate(ApplicationContext theApp, PersistentObject perObject) throws Exception;
	public Collection retrive(ApplicationContext theApp, SearchCriteria searchCriteria) throws Exception;
	public PersistentObject retriveById(ApplicationContext theApp, Class po,  Object id) throws Exception;
		

}
