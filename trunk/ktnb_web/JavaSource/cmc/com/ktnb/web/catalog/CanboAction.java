/*
 * Created on Apr 18, 2007 
 */
package cmc.com.ktnb.web.catalog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;

import cmc.com.ktnb.pl.hb.entity.KtnbDmCanbo;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.HtmlTable;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.QueryDetails;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.catalog.vo.CanboLovVO;

/**
 * @author ntthu
 */
public class CanboAction extends BaseDispatchAction {
	public ActionForward list(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		CanboForm cForm = (CanboForm) form;
		CatalogService cs = new CatalogService();
		SearchCriteria cri = new SearchCriteria();
		QueryDetails queryDetails = new QueryDetails();
		queryDetails.setPageSize(Constants.PAGE_SIZE_DEFAULT);
		String sPageNumber = request.getParameter("pageNumber");
		try {
			queryDetails.setPageNumber(new Integer(sPageNumber));
			request.setAttribute("pnumber", sPageNumber);
		} catch (Exception e) {
			queryDetails.setPageNumber(new Integer("1"));
			request.setAttribute("pnumber", new Integer("1"));
		}
		cri.setQueryDetail(queryDetails);
		cri.setSearchClass(KtnbDmCanbo.class);
		if (!Formater.isNull(cForm.getId()))
			cri.addSearchItem("maCanbo", cForm.getId().trim().toLowerCase(), SearchCriteria.OP_LIKE, SearchCriteria.LG_AND);
		if (!Formater.isNull(cForm.getName()))
			cri.addSearchItem("tenCanbo", cForm.getName().trim().toLowerCase(), SearchCriteria.OP_LIKE, SearchCriteria.LG_AND);
		cri.addOrderItem("maCanbo");
		Collection objects = cs.retrive(appContext, cri);
		HtmlTable table = new HtmlTable();
		int total = 0;
		int pNum = queryDetails.getPageNumber().intValue();
//		int pSize = queryDetails.getPageSize().intValue();
		if (objects != null && objects.size() > 0) {
			total = objects.size();
			//set data to display
			table.setPageNumber(Integer.toString(pNum));
			table.setPageSize(queryDetails.getPageSize().longValue());
			table.setTotalRecord(total);
			table.setSearchForm("cbForm");
			table.setData(objects);
			table.setGoToPageUrl(this.getUrl(request, "list"));
			request.setAttribute("dtnts", table);
		}
		request.setAttribute("totalrecord", new Long(total));
		return map.findForward("list");
	}
	public ActionForward lov(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		CanboForm cForm = (CanboForm) form;
		KtnbUtil.setCqtCbx(appContext, cForm, request);
		StringBuffer sql = new StringBuffer("select t.ma_canbo,t.ten_canbo,t.chuc_vu,t.ma_phong,t.ten_phong,t.ma_cqt,t.ten_cqt from ktnb_dm_can_bo_v t");
		sql.append(" where 1=1");
		//Auto search and return
		String txtSearch = request.getParameter("txtSearch");
		if (!Formater.isNull(txtSearch)){
			sql.append(" AND (upper(t.ten_canbo) like '%" + txtSearch.trim().toUpperCase() + "%')"); //+"' OR lower(dt.ten_dtnt) like '"+txtSearch.trim().toLowerCase()
			cForm.setName(txtSearch.trim());
		}
		if (!Formater.isNull(cForm.getName()))
			sql.append(" AND upper(t.ten_canbo) like '%" + cForm.getName().trim().toUpperCase() + "%'");
		if (!Formater.isNull(cForm.getId()))
			sql.append(" AND t.ma_canbo like '" + cForm.getId().trim() + "'");		
		String r = request.getParameter("r");
		if(!Formater.isNull(r)){
			cForm.setArrCqt(appContext.getMaCqt());
			sql.append(KtnbUtil.addCqtCondition(appContext, "t"));			
		}else {
			String maCqt = request.getParameter("cqt");
			if(!Formater.isNull(maCqt)){
				sql.append(" AND t.ma_cqt like '" + maCqt + "'");
			}
		}
		sql.append(" ORDER By t.ma_canbo");
		Session session = HibernateSessionFactory.openNewSession();
		Collection objects = new ArrayList();
		HtmlTable table = new HtmlTable();
		if (session != null) {
			QueryDetails queryDetails = new QueryDetails();
			try {
				session.beginTransaction();
//				BaseHibernateDAO dao = new BaseHibernateDAO();
				String sPageNumber = request.getParameter("pageNumber");
				try {
					queryDetails.setPageNumber(new Integer(sPageNumber));
					request.setAttribute("pnumber", sPageNumber);
					queryDetails.setPageSize(Constants.PAGE_SIZE_DEFAULT);
				} catch (Exception e) {
					queryDetails.setPageNumber(new Integer("1"));
					queryDetails.setPageSize(new Integer("10"));
					request.setAttribute("pnumber", new Integer("1"));
				}
				System.out.println("SQL Lov: " +sql.toString());
				Query q = session.createSQLQuery(sql.toString()).setFirstResult(queryDetails.getBeginIndex()).setMaxResults(queryDetails.getLastIndex());
				objects = q.list();
				int total = 0;
				if (objects != null && objects.size() > 0) {
					total = objects.size();
					if (total == 1) // Co 1 ban ghi
						{
						CanboLovVO vo = new CanboLovVO((Object[]) objects.iterator().next());
						request.setAttribute("datas", vo.getData());
					} else {
						//set data to display
						Collection ret = new ArrayList();
						table.setPageNumber(Integer.toString(queryDetails.getPageNumber().intValue()));
						table.setPageSize(queryDetails.getPageSize().longValue());
						table.setTotalRecord(total);
						for (Iterator iter = objects.iterator(); iter.hasNext();) {
							CanboLovVO vo = new CanboLovVO((Object[]) iter.next());
							ret.add(vo);
						}
						table.setData(ret);
						table.setGoToPageUrl(this.getUrl(request, "lov"));
						table.setSearchForm("canboForm");
						request.setAttribute("dtnts", table);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				HibernateSessionFactory.rollbackQuiet();
				throw new Exception(e);
			} finally {
				HibernateSessionFactory.closeSessionQuiet();
			}
		}
		request.setAttribute("total", new Long(table.getCurrentTotalRecord()));
		return map.findForward("success");
	}	
	public ActionForward lovCqt(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		CanboForm cForm = (CanboForm) form;
		StringBuffer sql = new StringBuffer("select ma,ten from ktnb_dm_cqt t where 1=1 ");		
		//Auto search and return
		String txtSearch = request.getParameter("txtSearch");
		if(Formater.isNull(txtSearch))
			txtSearch = cForm.getName();
		if (!Formater.isNull(txtSearch))
			sql.append(" AND (lower(t.ten) like '%" + txtSearch.trim().toLowerCase() + "%')"); //+"' OR lower(dt.ten_dtnt) like '"+txtSearch.trim().toLowerCase() 	
		if (!Formater.isNull(cForm.getId()))
			sql.append(" AND t.ma like '" + cForm.getId().trim() + "'");
		String r = request.getParameter("r");
		if(!Formater.isNull(r))
			sql.append(" AND t.ma like '"+ appContext.getMaCqt().substring(0,3) +"%'");
		sql.append(" order by ma");
		Session session = HibernateSessionFactory.openNewSession();
		Collection objects = new ArrayList();
		HtmlTable table = new HtmlTable();
		if (session != null) {
			QueryDetails queryDetails = new QueryDetails();
			try {
				session.beginTransaction();
//				BaseHibernateDAO dao = new BaseHibernateDAO();
				String sPageNumber = request.getParameter("pageNumber");
				try {
					queryDetails.setPageNumber(new Integer(sPageNumber));
					request.setAttribute("pnumber", sPageNumber);
					queryDetails.setPageSize(Constants.PAGE_SIZE_DEFAULT);
				} catch (Exception e) {
					queryDetails.setPageNumber(new Integer("1"));
					queryDetails.setPageSize(new Integer("10"));
					request.setAttribute("pnumber", new Integer("1"));
				}
				System.out.println("SQL Lov: " +sql.toString());
				Query q = session.createSQLQuery(sql.toString()).setFirstResult(queryDetails.getBeginIndex()).setMaxResults(queryDetails.getLastIndex());
				objects = q.list();
				int total = 0;
				if (objects != null && objects.size() > 0) {
					total = objects.size();
					if (total == 1) // Co 1 ban ghi
						{
						CanboLovVO vo = new CanboLovVO((Object[]) objects.iterator().next());
						request.setAttribute("datas", vo.getData());
					} else {
						//set data to display
						Collection ret = new ArrayList();
						table.setPageNumber(Integer.toString(queryDetails.getPageNumber().intValue()));
						table.setPageSize(queryDetails.getPageSize().longValue());
						table.setTotalRecord(total);
						for (Iterator iter = objects.iterator(); iter.hasNext();) {
							Object[] obj = (Object[]) iter.next();
							CanboLovVO vo = new CanboLovVO(obj[0].toString(),obj[1].toString());
							ret.add(vo);
						}
						table.setData(ret);
						table.setGoToPageUrl(this.getUrl(request, "lov"));
						table.setSearchForm("canboForm");
						request.setAttribute("dtnts", table);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				HibernateSessionFactory.rollbackQuiet();
				throw new Exception(e);
			} finally {
				HibernateSessionFactory.closeSessionQuiet();
			}
		}
		request.setAttribute("total", new Long(table.getCurrentTotalRecord()));
		return map.findForward("lovCqt");
	}	
}
