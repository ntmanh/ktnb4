package cmc.com.ktnb.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//import org.apache.wsif.schema.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class HibernateDAO {
	private ArrayList restrictions = new ArrayList();
	private Class searchClass;
	private SearchParam searchParam;
	public void addRestriction(Object restriction){
		restrictions.add(restriction);
	}
	
	public HibernateDAO(Class searchClass){
		this.searchClass = searchClass;
	}
	public Collection search(){
		Session session = HibernateSessionFactory.currentSession();		
		Criteria criteria = session.createCriteria(searchClass);
		Iterator iter = restrictions.iterator();
		while(iter.hasNext())
			criteria.add((Criterion) iter.next());
		if(searchParam !=null){
			criteria.setFirstResult(searchParam.beginIndex.intValue());
			criteria.setMaxResults(searchParam.endIndex.intValue());
		}
		return criteria.list();
	}
	public void addRestrictions(Collection collection) {
		this.restrictions.addAll(collection);
		
	}
	public class SearchParam{
		private Integer pageNum;
		private Integer pageSize;
		private Integer beginIndex;
		private Integer endIndex;
		public Integer getBeginIndex() {
			return beginIndex;
		}
		public void setBeginIndex(Integer beginIndex) {
			this.beginIndex = beginIndex;
		}
		public Integer getEndIndex() {
			return endIndex;
		}
		public void setEndIndex(Integer endIndex) {
			this.endIndex = endIndex;
		}
		public Integer getPageNum() {
			return pageNum;
		}
		public void setPageNum(Integer pageNum) {
			this.pageNum = pageNum;
			if(this.pageSize !=null){
				beginIndex = new Integer((pageNum.intValue()-1)*pageSize.intValue());
				endIndex = new Integer(pageSize.intValue() * 5 +2);
			}
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
			if(this.pageNum !=null){
				beginIndex = new Integer((pageNum.intValue()-1)*pageSize.intValue() +1);
				endIndex = new Integer(pageSize.intValue() * 5 +2);
			}
		}
		
		
	}
	public ArrayList getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(ArrayList restrictions) {
		this.restrictions = restrictions;
	}

	public Class getSearchClass() {
		return searchClass;
	}

	public void setSearchClass(Class searchClass) {
		this.searchClass = searchClass;
	}

	public SearchParam getSearchParam() {
		if(searchParam == null)
			searchParam = new SearchParam();
		return searchParam;
	}

	public void setSearchParam(SearchParam searchParam) {
		this.searchParam = searchParam;
	}

	

}
