/*
 * Created on Nov 18, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.ke_hoach_nam.action;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhDuyetKeHoach;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HtmlTable;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.QueryDetails;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.ke_hoach_nam.form.KeHoachNamCqtCapDuoiForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;

/**
 * @author ntdung1
 * 
 * To change the template for this generated type comment go to Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class KeHoachNamCqtCapTrenAction extends BaseDispatchAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		if (KtnbUtil.isTongCuc(appContext)) {
			KtnbUtil.showBussinessExceiption(request, response, "T\u1ED5ng c\u1EE5c kh\u00F4ng c\u00F3 c\u01A1 quan thu\u1EBF c\u1EA5p tr\u00EAn");

		}
		KeHoachNamCqtCapDuoiForm keHoachNamCqtCapDuoiForm = (KeHoachNamCqtCapDuoiForm) form;
		if (Formater.isNull(keHoachNamCqtCapDuoiForm.getNamKeHoach()))
			keHoachNamCqtCapDuoiForm.setNamKeHoach(String.valueOf(new Date().getYear() + 1900));
		// Load du lieu vao combobox
		
		SearchCriteria criteria = new SearchCriteria(TtktKhCuocTtkt.class);
		// Trang thai <> Het hieu luc
		criteria.addSearchItem(TtktKhCuocTtkt.TrangThai, Constants.TT_TTKT_HET_HL, SearchCriteria.OP_NE);
		// Loai = ke hoach nam
		criteria.addSearchItem(TtktKhCuocTtkt.Loai, Boolean.FALSE);
		criteria.addSearchItem(TtktKhCuocTtkt.IdDonViBi, appContext.getMaCqt());
		
		// Don vi tien hanh khong phai cqt ma phai la cqt cap tren
		criteria.addSearchItem(TtktKhCuocTtkt.IdDonViTh, appContext.getMaCqt(), SearchCriteria.OP_NE);

		criteria.addSearchItem(TtktKhCuocTtkt.Ma, "%" + keHoachNamCqtCapDuoiForm.getNamKeHoach().trim() + "%", SearchCriteria.OP_LIKE);
		// Khoi tao form
		QueryDetails queryDetails = new QueryDetails();
		queryDetails.setPageSize(Constants.PAGE_SIZE_DEFAULT);
		String sPageNumber = request.getParameter("pageNumber") != null && !request.getParameter("pageNumber").equals("") ? request.getParameter("pageNumber") : "1";
		queryDetails.setPageNumber(new Integer(sPageNumber));
		request.setAttribute("pnumber", sPageNumber);
		criteria.setQueryDetail(queryDetails);
		Collection listCuocTtkt = new BaseHibernateDAO().retrieveObjects(appContext, criteria);
		Iterator iterator = listCuocTtkt.iterator();
		while (iterator.hasNext()) {
			TtktKhCuocTtkt cuocTtkt = (TtktKhCuocTtkt) iterator.next();
			cuocTtkt.setNienDoDenNgayStr(Formater.date2str(cuocTtkt.getNienDoDenNgay()));
			cuocTtkt.setNienDoTuNgayStr(Formater.date2str(cuocTtkt.getNienDoTuNgay()));
			cuocTtkt.setThoiGianDuKienDenNgayStr(Formater.date2str(cuocTtkt.getThoiGianDuKienDenNgay()));
			cuocTtkt.setThoiGianDuKienTuNgayStr(Formater.date2str(cuocTtkt.getThoiGianDuKienTuNgay()));
		}
		HtmlTable table = new HtmlTable();
		int total = 0;
		int pNum = queryDetails.getPageNumber().intValue();
		int pSize = queryDetails.getPageSize().intValue();
		// if (listCQT != null && listCQT.size() > 0) {
		total = listCuocTtkt.size();
		// set data to display
		table.setPageNumber(Integer.toString(pNum));
		table.setPageSize(queryDetails.getPageSize().longValue());
		table.setTotalRecord(total);

		table.setData(listCuocTtkt);
		table.setSearchForm("KeHoachNamCqtCapDuoiForm");
		request.setAttribute("dscttkt", table);
		// table.setGoToPageUrl(this.getUrl(request, "dscttkt"));

		// HtmlTable table = new HtmlTable();
		// table.setPageNumber(sPageNumber);
		// table.setPageSize(Constants.PAGE_SIZE_DEFAULT.longValue());
		// table.setData(listCuocTtkt);
		// table.setSearchForm("KeHoachNamForm");
		// request.setAttribute("dscttkt", table);

		return mapping.findForward("viewkehoachnam");
	}

}
