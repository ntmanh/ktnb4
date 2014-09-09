/*
 * Created on Nov 4, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.dung_chung.action;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.pl.hb.entity.KtnbDmCqt;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.HtmlTable;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.QueryDetails;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.dung_chung.form.TimKiemCqtForm;
/**
* @author ntdung1
*
* To change the template for this generated type comment go to
* Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
*/
public class TimKiemCqtAction extends BaseDispatchAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		TimKiemCqtForm timKiemCqtForm = (TimKiemCqtForm) form;
		SearchCriteria criteria = new SearchCriteria(KtnbDmCqt.class);
		if (timKiemCqtForm.getMaCqt() != null && !timKiemCqtForm.getMaCqt().trim().equals("")) {
			criteria.addSearchItem("ma", "%" + timKiemCqtForm.getMaCqt().trim().toUpperCase() + "%", SearchCriteria.OP_LIKE);
		}
		String tenCqt = request.getParameter("tenCqt");
		if (tenCqt != null && !tenCqt.equals(""))
			timKiemCqtForm.setTenCqt(tenCqt);
		if (timKiemCqtForm.getTenCqt() != null && !timKiemCqtForm.getTenCqt().trim().equals("")) {
			criteria.addSearchItem("ten", "%" + timKiemCqtForm.getTenCqt().toUpperCase() + "%", SearchCriteria.OP_LIKE);
		}
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		if (KtnbUtil.isTongCuc(appContext)) {
			criteria.addSearchItem("ma", "%00", SearchCriteria.OP_LIKE);
		} else if (KtnbUtil.isCuc(appContext)) {
			criteria.addSearchItem("ma", appContext.getMaCqt().substring(0, 3) + "%", SearchCriteria.OP_LIKE);
		}
		criteria.addOrderItem("ma");

		QueryDetails queryDetails = new QueryDetails();
		queryDetails.setPageSize(Constants.PAGE_SIZE_DEFAULT);
		String sPageNumber = request.getParameter("pageNumber") != null && !request.getParameter("pageNumber").equals("") ? request.getParameter("pageNumber") : "1";
		queryDetails.setPageNumber(new Integer(sPageNumber));
		request.setAttribute("pnumber", sPageNumber);
		criteria.setQueryDetail(queryDetails);
		Collection listCQT = new BaseHibernateDAO().retrieveObjects(appContext, criteria);
		

		// Bo sung them co quan thue dang thuc hien vao ket qua tim kiem		
//		boolean addCqt = false;
//
//		if (Formater.isNull(timKiemCqtForm.getMaCqt()) && Formater.isNull(timKiemCqtForm.getTenCqt()))
//			addCqt = true;
//		else if (Formater.isNull(timKiemCqtForm.getMaCqt()) && !Formater.isNull(timKiemCqtForm.getTenCqt())) {
//			if (appContext.getTenCqt().indexOf(timKiemCqtForm.getTenCqt()) >= 0)
//				addCqt = true;
//		} else if (!Formater.isNull(timKiemCqtForm.getMaCqt()) && Formater.isNull(timKiemCqtForm.getTenCqt())) {
//			if (appContext.getMaCqt().indexOf(timKiemCqtForm.getMaCqt()) >= 0)
//				addCqt = true;
//		} else if (!Formater.isNull(timKiemCqtForm.getMaCqt()) && !Formater.isNull(timKiemCqtForm.getTenCqt())) {
//			if (appContext.getMaCqt().indexOf(timKiemCqtForm.getMaCqt()) >= 0 || appContext.getTenCqt().toUpperCase().indexOf(timKiemCqtForm.getTenCqt().toUpperCase()) >= 0)
//				addCqt = true;
//		}
//		if (addCqt) {
//			ArrayList arrTemp = new ArrayList();
//			arrTemp.add(new KtnbDmCqt(appContext.getMaCqt(), appContext.getTenCqt()));
//			arrTemp.addAll(listCQT);
//			listCQT = arrTemp;
//		}

		HtmlTable table = new HtmlTable();
		int total = 0;
		int pNum = queryDetails.getPageNumber().intValue();
		int pSize = queryDetails.getPageSize().intValue();
		//if (listCQT != null && listCQT.size() > 0) {
		total = listCQT.size();
		//set data to display
		table.setPageNumber(Integer.toString(pNum));
		table.setPageSize(queryDetails.getPageSize().longValue());
		table.setTotalRecord(total);
		//table.setSearchForm("catalogForm");
		table.setData(listCQT);
		request.setAttribute("dspb", table);
		table.setGoToPageUrl(this.getUrl(request, "dspb"));
		//}
		if (listCQT.size() == 1) {
			KtnbDmCqt dmCqt = (KtnbDmCqt) ((ArrayList) listCQT).get(0);
			request.setAttribute("ma&&ten", dmCqt.getMa() + "&&" + dmCqt.getTen());
		}
		return mapping.findForward("search");
	}

	public ActionForward changeCqt(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("search");
	}

}
