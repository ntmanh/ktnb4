package cmc.com.ktnb.web.kntc.bao_cao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JExcelApiExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;
import org.json.JSONArray;
import org.json.JSONObject;

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KtnbDmCqt;
import cmc.com.ktnb.pl.hb.entity.KtnbLopTapHuan;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.util.StringUtil;
import cmc.com.ktnb.vo.CategoryVO;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.catalog.CatalogService;

/**
 * Xử lý báo cáo
 * @author ntthu-cmcsoft
 */
public class BaocaoAction extends BaseDispatchAction {
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		String type = request.getParameter("t");
		if(Formater.isNull(type))
			throw new KtnbException("Report","Phải chọn loại báo cáo!");
		cnForm.setLoaiBc(type);
		cnForm.setTenBc("");
		cnForm.setNguoiLap(appContext.getTenCanbo());
		cnForm.setNgayLap(Formater.date2str(new Date()));
		cnForm.setDenNgay(Formater.date2str(new Date()));
		cnForm.setDiaDiem(appContext.getTenCqt());
		//KtnbUtil.setCqt(appContext, cnForm, request);
		return map.findForward(type);
	}
	public ActionForward bcKn(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		try {
			ArrayList listKntc = (ArrayList) request.getAttribute("dmbc");
			if (Formater.isNull(listKntc)) {
				listKntc = new ArrayList();
				Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_KN);
				for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
					CategoryVO aVo = (CategoryVO) iter.next();
					listKntc.add(new LabelValueBean(aVo.getName(), aVo.getId()));
				}
			}
			request.setAttribute("dmbc", listKntc);
			cnForm.setNguoiLap(appContext.getTenCanbo());
			cnForm.setNam(Formater.date2str(new Date()).substring(6));
			cnForm.setNgayLap(Formater.date2str(new Date()));
			cnForm.setDenNgay(Formater.date2str(new Date()));
			cnForm.setDiaDiem(appContext.getTenCqt());			
			KtnbUtil.setCqtCapCuc(appContext, cnForm, request);
			KtnbUtil.setCqt(appContext, cnForm, request,appContext.getMaCqt());			   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.findForward("bcKn");
	}
	public ActionForward bc28(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		try {
			ArrayList listKntc = (ArrayList) request.getAttribute("dmbc");
			if (Formater.isNull(listKntc)) {
				listKntc = new ArrayList();
				Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_KN);
				for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
					CategoryVO aVo = (CategoryVO) iter.next();
					listKntc.add(new LabelValueBean(aVo.getName(), aVo.getId()));
				}
			}
			request.setAttribute("dmbc", listKntc);
			cnForm.setNguoiLap(appContext.getTenCanbo());
			cnForm.setNam(Formater.date2str(new Date()).substring(6));
			cnForm.setNgayLap(Formater.date2str(new Date()));
			cnForm.setDenNgay(Formater.date2str(new Date()));
			cnForm.setDiaDiem(appContext.getTenCqt());			
			KtnbUtil.setCqtCapCuc(appContext, cnForm, request);
			KtnbUtil.setCqt(appContext, cnForm, request,appContext.getMaCqt());			   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.findForward("bc28");
	}
	public ActionForward bcTc(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		try {
			ArrayList listKntc = (ArrayList) request.getAttribute("dmbc");
			if (Formater.isNull(listKntc)) {
				listKntc = new ArrayList();
				Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_TC);
				for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
					CategoryVO aVo = (CategoryVO) iter.next();
					listKntc.add(new LabelValueBean(aVo.getName(), aVo.getId()));
				}
			}
			cnForm.setNguoiLap(appContext.getTenCanbo());
			cnForm.setNam(Formater.date2str(new Date()).substring(6));
			cnForm.setNgayLap(Formater.date2str(new Date()));
			cnForm.setDenNgay(Formater.date2str(new Date()));
			cnForm.setDiaDiem(appContext.getTenCqt());
			request.setAttribute("dmbc", listKntc);
			KtnbUtil.setCqtCapCuc(appContext, cnForm, request);
			KtnbUtil.setCqt(appContext, cnForm, request,appContext.getMaCqt());			   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.findForward("bcTc");
	}
	
	public ActionForward bc2a(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		try {
			ArrayList listKntc = (ArrayList) request.getAttribute("dmbc");
			if (Formater.isNull(listKntc)) {
				listKntc = new ArrayList();
				Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_KN);
				for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
					CategoryVO aVo = (CategoryVO) iter.next();
					listKntc.add(new LabelValueBean(aVo.getName(), aVo.getId()));
				}
			}
			request.setAttribute("dmbc", listKntc);
			cnForm.setNguoiLap(appContext.getTenCanbo());
			cnForm.setNam(Formater.date2str(new Date()).substring(6));
			cnForm.setNgayLap(Formater.date2str(new Date()));
			cnForm.setDenNgay(Formater.date2str(new Date()));
			cnForm.setDiaDiem(appContext.getTenCqt());			
			KtnbUtil.setCqtCapCuc(appContext, cnForm, request);
			KtnbUtil.setCqt(appContext, cnForm, request,appContext.getMaCqt());			   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.findForward("bc2a");
	}
	
	public ActionForward bc2b(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		try {
			ArrayList listKntc = (ArrayList) request.getAttribute("dmbc");
			if (Formater.isNull(listKntc)) {
				listKntc = new ArrayList();
				Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_KN);
				for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
					CategoryVO aVo = (CategoryVO) iter.next();
					listKntc.add(new LabelValueBean(aVo.getName(), aVo.getId()));
				}
			}
			request.setAttribute("dmbc", listKntc);
			cnForm.setNguoiLap(appContext.getTenCanbo());
			cnForm.setNam(Formater.date2str(new Date()).substring(6));
			cnForm.setNgayLap(Formater.date2str(new Date()));
			cnForm.setDenNgay(Formater.date2str(new Date()));
			cnForm.setDiaDiem(appContext.getTenCqt());			
			KtnbUtil.setCqtCapCuc(appContext, cnForm, request);
			KtnbUtil.setCqt(appContext, cnForm, request,appContext.getMaCqt());			   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.findForward("bc2b");
	}
	
	public ActionForward bc2c(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		try {
			ArrayList listKntc = (ArrayList) request.getAttribute("dmbc");
			if (Formater.isNull(listKntc)) {
				listKntc = new ArrayList();
				Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_KN);
				for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
					CategoryVO aVo = (CategoryVO) iter.next();
					listKntc.add(new LabelValueBean(aVo.getName(), aVo.getId()));
				}
			}
			request.setAttribute("dmbc", listKntc);
			cnForm.setNguoiLap(appContext.getTenCanbo());
			cnForm.setNam(Formater.date2str(new Date()).substring(6));
			cnForm.setNgayLap(Formater.date2str(new Date()));
			cnForm.setDenNgay(Formater.date2str(new Date()));
			cnForm.setDiaDiem(appContext.getTenCqt());			
			KtnbUtil.setCqtCapCuc(appContext, cnForm, request);
			KtnbUtil.setCqt(appContext, cnForm, request,appContext.getMaCqt());			   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.findForward("bc2c");
	}
	public ActionForward bc2d(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		try {
			ArrayList listKntc = (ArrayList) request.getAttribute("dmbc");
			if (Formater.isNull(listKntc)) {
				listKntc = new ArrayList();
				Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_TC);
				for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
					CategoryVO aVo = (CategoryVO) iter.next();
					listKntc.add(new LabelValueBean(aVo.getName(), aVo.getId()));
				}
			}
			cnForm.setNguoiLap(appContext.getTenCanbo());
			cnForm.setNam(Formater.date2str(new Date()).substring(6));
			cnForm.setNgayLap(Formater.date2str(new Date()));
			cnForm.setDenNgay(Formater.date2str(new Date()));
			cnForm.setDiaDiem(appContext.getTenCqt());
			request.setAttribute("dmbc", listKntc);
			KtnbUtil.setCqtCapCuc(appContext, cnForm, request);
			KtnbUtil.setCqt(appContext, cnForm, request,appContext.getMaCqt());			   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.findForward("bc2d");
	}
	public ActionForward bc2dd(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		try {
			ArrayList listKntc = (ArrayList) request.getAttribute("dmbc");
			if (Formater.isNull(listKntc)) {
				listKntc = new ArrayList();
				Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_TC);
				for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
					CategoryVO aVo = (CategoryVO) iter.next();
					listKntc.add(new LabelValueBean(aVo.getName(), aVo.getId()));
				}
			}
			cnForm.setNguoiLap(appContext.getTenCanbo());
			cnForm.setNam(Formater.date2str(new Date()).substring(6));
			cnForm.setNgayLap(Formater.date2str(new Date()));
			cnForm.setDenNgay(Formater.date2str(new Date()));
			cnForm.setDiaDiem(appContext.getTenCqt());
			request.setAttribute("dmbc", listKntc);
			KtnbUtil.setCqtCapCuc(appContext, cnForm, request);
			KtnbUtil.setCqt(appContext, cnForm, request,appContext.getMaCqt());			   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.findForward("bc2dd");
	}
	public ActionForward bc1a(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		String aF ="bc1a";
		try {
			String loaiBc = (String) request.getParameter("tenBc");
			if(!Formater.isNull(loaiBc))
			{
				aF=loaiBc;
			}
			else
			{
				ArrayList listKntc = (ArrayList) request.getAttribute("dmbc");
				if (Formater.isNull(listKntc)) {
					listKntc = new ArrayList();
					Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_TTKT);
					for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
						CategoryVO aVo = (CategoryVO) iter.next();
						listKntc.add(new LabelValueBean(aVo.getName(), aVo.getId()));
					}
				}
				request.setAttribute("dmbc", listKntc);
			}
			cnForm.setNguoiLap(appContext.getTenCanbo());
			cnForm.setNam(Formater.date2str(new Date()).substring(6));
			cnForm.setNgayLap(Formater.date2str(new Date()));
			cnForm.setDenNgay(Formater.date2str(new Date()));
			cnForm.setDiaDiem(appContext.getTenCqt());
			KtnbUtil.setCqtCapCuc(appContext, cnForm, request);
			KtnbUtil.setCqt(appContext, cnForm, request,appContext.getMaCqt());			   
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return map.findForward(aF);
	}
	public ActionForward bc1b(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		String aF ="bc1b";
		try {
			String loaiBc = (String) request.getParameter("tenBc");
			if(!Formater.isNull(loaiBc))
			{
				aF=loaiBc;
			}
			else
			{
				ArrayList listKntc = (ArrayList) request.getAttribute("dmbc");
				if (Formater.isNull(listKntc)) {
					listKntc = new ArrayList();
					Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_TTKT);
					for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
						CategoryVO aVo = (CategoryVO) iter.next();
						listKntc.add(new LabelValueBean(aVo.getName(), aVo.getId()));
					}
				}
				request.setAttribute("dmbc", listKntc);
			}
			cnForm.setNguoiLap(appContext.getTenCanbo());
			cnForm.setNam(Formater.date2str(new Date()).substring(6));
			cnForm.setNgayLap(Formater.date2str(new Date()));
			cnForm.setDenNgay(Formater.date2str(new Date()));
			cnForm.setDiaDiem(appContext.getTenCqt());
			KtnbUtil.setCqtCapCuc(appContext, cnForm, request);
			KtnbUtil.setCqt(appContext, cnForm, request,appContext.getMaCqt());			   
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return map.findForward(aF);
	}
	public ActionForward bcTtKt(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		String aF ="bcTtKt";
		try {
			String loaiBc = (String) request.getParameter("tenBc");
			if(!Formater.isNull(loaiBc))
			{
				aF=loaiBc;
			}
			else
			{
				ArrayList listKntc = (ArrayList) request.getAttribute("dmbc");
				if (Formater.isNull(listKntc)) {
					listKntc = new ArrayList();
					Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_TTKT);
					for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
						CategoryVO aVo = (CategoryVO) iter.next();
						listKntc.add(new LabelValueBean(aVo.getName(), aVo.getId()));
					}
				}
				request.setAttribute("dmbc", listKntc);
			}
			cnForm.setNguoiLap(appContext.getTenCanbo());
			cnForm.setNam(Formater.date2str(new Date()).substring(6));
			cnForm.setNgayLap(Formater.date2str(new Date()));
			cnForm.setDenNgay(Formater.date2str(new Date()));
			cnForm.setDiaDiem(appContext.getTenCqt());
			KtnbUtil.setCqtCapCuc(appContext, cnForm, request);
			KtnbUtil.setCqt(appContext, cnForm, request,appContext.getMaCqt());			   
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return map.findForward(aF);
	}
	public ActionForward bcTtKt43E(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		try {
			cnForm.setLoaiBc("ttkt43E");
			//Danh muc noi dung/chuyen de cho combobox
			ArrayList listDmNoiDungCbx = (ArrayList) request.getAttribute("dmndcbx");
			if (Formater.isNull(listDmNoiDungCbx)) {
				listDmNoiDungCbx = new ArrayList();
				Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_TTKT_ND_PARENT);
				for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
					CategoryVO aVo = (CategoryVO) iter.next();
					listDmNoiDungCbx.add(new LabelValueBean(aVo.getName(), aVo.getId()));
				}				
			}
			request.setAttribute("dmndcbx", listDmNoiDungCbx);
			//Danh muc noi dung/chuyen de chi tiet
			ArrayList listDmNoiDung = (ArrayList) request.getAttribute("dmnd");
			if (Formater.isNull(listDmNoiDung)) {
				listDmNoiDung = new ArrayList();
				String loaiBaoCaoTtkt = cnForm.getLoaiBaoCaoTtkt();
				if(Formater.isNull(loaiBaoCaoTtkt))
					loaiBaoCaoTtkt = Constants.REPORT_TTKT_CD;
				Collection dmBc = CatalogService.getDmByParentId(loaiBaoCaoTtkt);
				for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
					CategoryVO aVo = (CategoryVO) iter.next();
					listDmNoiDung.add(aVo);
				}				
			}
			request.setAttribute("dmnd", listDmNoiDung);
			cnForm.setNguoiLap(appContext.getTenCanbo());
			cnForm.setNam(Formater.date2str(new Date()).substring(6));
			cnForm.setNgayLap(Formater.date2str(new Date()));
			cnForm.setDenNgay(Formater.date2str(new Date()));
			cnForm.setDiaDiem(appContext.getTenCqt());			
			KtnbUtil.setCqtCapCuc(appContext, cnForm, request);
			KtnbUtil.setCqt(appContext, cnForm, request,appContext.getMaCqt());			   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.findForward("bcTtKt43E");
	}
	public ActionForward bcKnNd(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		try {
			cnForm.setLoaiBc("bcKnNd");
			//Danh muc noi dung/chuyen de chi tiet
			ArrayList listDmNoiDung = (ArrayList) request.getAttribute("dmnd");
			if (Formater.isNull(listDmNoiDung)) {
				listDmNoiDung = new ArrayList();
				Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_KN_ND);
				for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
					CategoryVO aVo = (CategoryVO) iter.next();
					listDmNoiDung.add(aVo);
				}				
			}
			request.setAttribute("dmnd", listDmNoiDung);
			cnForm.setNguoiLap(appContext.getTenCanbo());
			cnForm.setNam(Formater.date2str(new Date()).substring(6));
			cnForm.setNgayLap(Formater.date2str(new Date()));
			cnForm.setDenNgay(Formater.date2str(new Date()));
			cnForm.setDiaDiem(appContext.getTenCqt());			
			KtnbUtil.setCqtCapCuc(appContext, cnForm, request);
			KtnbUtil.setCqt(appContext, cnForm, request,appContext.getMaCqt());			   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.findForward("bcKnNd");
	}
	public ActionForward bcTcNd(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		try {
			cnForm.setLoaiBc("bcTcNd");
			//Danh muc noi dung/chuyen de chi tiet
			ArrayList listDmNoiDung = (ArrayList) request.getAttribute("dmnd");
			if (Formater.isNull(listDmNoiDung)) {
				listDmNoiDung = new ArrayList();
				Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_TC_ND);
				for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
					CategoryVO aVo = (CategoryVO) iter.next();
					listDmNoiDung.add(aVo);
				}				
			}
			request.setAttribute("dmnd", listDmNoiDung);
			cnForm.setNguoiLap(appContext.getTenCanbo());
			cnForm.setNam(Formater.date2str(new Date()).substring(6));
			cnForm.setNgayLap(Formater.date2str(new Date()));
			cnForm.setDenNgay(Formater.date2str(new Date()));
			cnForm.setDiaDiem(appContext.getTenCqt());			
			KtnbUtil.setCqtCapCuc(appContext, cnForm, request);
			KtnbUtil.setCqt(appContext, cnForm, request,appContext.getMaCqt());			   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.findForward("bcTcNd");
	}
	public ActionForward search(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		try {
			String capCqt = cnForm.getCapCqt();
			if(!Formater.isNull(capCqt))
			{
				KtnbUtil.setCqt(appContext, cnForm, request,cnForm.getCapCqt());	
			}else
			{
				Collection list = new ArrayList();
				KtnbDmCqt aCqt = new KtnbDmCqt();
				aCqt.setMa(appContext.getMaCqt());
				aCqt.setTen(appContext.getTenCqt());
				list.add(aCqt);
				request.setAttribute("cqts", list);
			}
				
			if(cnForm.getLoaiBc().equals("bcKn"))
			{
				ArrayList listKntc = (ArrayList) request.getAttribute("dmbc");
				if (Formater.isNull(listKntc)) {
					listKntc = new ArrayList();
					Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_KN);
					for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
						CategoryVO aVo = (CategoryVO) iter.next();
						listKntc.add(new LabelValueBean(aVo.getName(), aVo.getId()));
					}
				}
				request.setAttribute("dmbc", listKntc);	
			}else if(cnForm.getLoaiBc().equals("bcTc"))
			{
				ArrayList listKntc = (ArrayList) request.getAttribute("dmbc");
				if (Formater.isNull(listKntc)) {
					listKntc = new ArrayList();
					Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_TC);
					for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
						CategoryVO aVo = (CategoryVO) iter.next();
						listKntc.add(new LabelValueBean(aVo.getName(), aVo.getId()));
					}
				}
				request.setAttribute("dmbc", listKntc);	
			}
			else if(cnForm.getLoaiBc().equals("bcTtKt43E"))
			{
				ArrayList listKntc = (ArrayList) request.getAttribute("dmbcTtKt");
				if (Formater.isNull(listKntc)) {
					listKntc = new ArrayList();
					Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_TTKT);
					for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
						CategoryVO aVo = (CategoryVO) iter.next();
						listKntc.add(new LabelValueBean(aVo.getName(), aVo.getId()));
					}				
				}
				request.setAttribute("dmbcTtKt", listKntc);
				//Danh muc noi dung/chuyen de cho combobox
				ArrayList listDmNoiDungCbx = (ArrayList) request.getAttribute("dmndcbx");
				if (Formater.isNull(listDmNoiDungCbx)) {
					listDmNoiDungCbx = new ArrayList();
					Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_TTKT_ND_PARENT);
					for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
						CategoryVO aVo = (CategoryVO) iter.next();
						listDmNoiDungCbx.add(new LabelValueBean(aVo.getName(), aVo.getId()));
					}				
				}
				request.setAttribute("dmndcbx", listDmNoiDungCbx);
				//Danh muc noi dung/chuyen de chi tiet
				ArrayList listDmNoiDung = (ArrayList) request.getAttribute("dmnd");
				if (Formater.isNull(listDmNoiDung)) {
					listDmNoiDung = new ArrayList();
					String loaiBaoCaoTtkt = cnForm.getLoaiBaoCaoTtkt();
					Collection dmBc = CatalogService.getDmByParentId(loaiBaoCaoTtkt);
//					Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_KN);
					for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
						CategoryVO aVo = (CategoryVO) iter.next();
						listDmNoiDung.add(aVo);
					}				
				}
				request.setAttribute("dmnd", listDmNoiDung);				
			}
			else if(cnForm.getLoaiBc().equals("bcTtKt"))
			{
				ArrayList listKntc = (ArrayList) request.getAttribute("dmbc");
				if (Formater.isNull(listKntc)) {
					listKntc = new ArrayList();
					Collection dmBc = CatalogService.getDmByParentId(Constants.REPORT_TTKT);
					for (Iterator iter = dmBc.iterator(); iter.hasNext();) {
						CategoryVO aVo = (CategoryVO) iter.next();
						listKntc.add(new LabelValueBean(aVo.getName(), aVo.getId()));
					}
				}
				request.setAttribute("dmbc", listKntc);
			}
			cnForm.setNguoiLap(appContext.getTenCanbo());
			cnForm.setNam(Formater.date2str(new Date()).substring(6));
			cnForm.setNgayLap(Formater.date2str(new Date()));
			cnForm.setDenNgay(Formater.date2str(new Date()));
			cnForm.setDiaDiem(appContext.getTenCqt());			
			KtnbUtil.setCqtCapCuc(appContext, cnForm, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.findForward(cnForm.getLoaiBc());
	}
	
	public ActionForward getListLopDt(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		JSONObject jsonResult = null;
		try {
			jsonResult = this.getListBaoCao(appContext);
			response.setContentType("application/json;charset=UTF-8");
			response.setHeader("Cache-Control", "no-store");
			PrintWriter out = response.getWriter();
			out.println(jsonResult);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public JSONObject getListBaoCao(ApplicationContext c) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KtnbLopTapHuan.class);
		JSONObject jsonResult = new JSONObject();
		Collection r = services.retrive(c, sc);
		JSONArray jsonArray = new JSONArray();
		JSONArray ja;
		for (Iterator iter = r.iterator(); iter.hasNext();) {
			KtnbLopTapHuan element = (KtnbLopTapHuan) iter.next();
			ja = new JSONArray();
			ja.put(element.getTenLop()); // Thoi diem lap phieu
			ja.put(element.getDiaDiem());
			ja.put(Formater.date2str(element.getNgayBatDau()) + "->" + Formater.date2str(element.getNgayKetThuc()));
			ja.put(element.getSoNguoi());
			ja.put("<input type=checkbox id='dmNd' name='dmNd' value='" + element.getMa() + "' />");
			jsonArray.put(ja);
		}
		jsonResult.put("aaData", jsonArray);
		return jsonResult;
	}

	public ActionForward export(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
			// HashMap[] reportRows = null;
			Map parameters = new HashMap();
			BaocaoForm cbForm = (BaocaoForm) form;
			String fileTemplate = "kntc";
			if(!Formater.isNull(cbForm.getTenBc()) && cbForm.getLoaiBc().toLowerCase().indexOf("ttkt")!=-1)
				fileTemplate="ttnb";				
			if(!Formater.isNull(cbForm.getTenBc()))
				fileTemplate +=cbForm.getTenBc();
//			if (!Formater.isNull(cbForm.getDinhDang()) && cbForm.getDinhDang().equals("A3")) {
//				fileTemplate += "_A3";
//			}
			parameters.put("ten_cqt", KtnbUtil.getTenCqtCapTrenTt4P(appContext));
			parameters.put("ten_cqt_bao_cao", appContext.getTenCqt());
			parameters.put("tt_cqt", KtnbUtil.getTenThuTruongCqt(appContext));
			parameters.put("ten_thu_truong", appContext.getTenThuTruong());
			//parameters.put("ten_can_bo", appContext.getTenCanbo());
			parameters.put("ten_can_bo", StringUtil.isBlankOrNull(cbForm.getNguoiLap())?appContext.getTenCanbo():cbForm.getNguoiLap());
			parameters.put("noi_lap_bao_cao", appContext.getDiaBan());
			parameters.put("dia_diem_bao_cao", appContext.getDiaBan());
			//Cho TTNB02
			parameters.put("dv_thuc_hien_ttkt", appContext.getTenCqt());
			parameters.put("thu_truong_cqt", KtnbUtil.getTenThuTruongCqt(appContext));
			parameters.put("chuc_danh_thu_truong", KtnbUtil.getTenThuTruongCqt(appContext));
			parameters.put("nam", "'%" + cbForm.getNam() + "%'");
			parameters.put("namHienThi", cbForm.getNam());
			parameters.put("id_don_vi_th", appContext.getMaCqt());
			//cho Bao Cao TTCP
			parameters.put("p_tu_thang", cbForm.getTuThang());
			parameters.put("p_den_thang", cbForm.getDenThang());
			
			String date ="",dateView="";
			/*if(fileTemplate.equals("ttnb43")){
				if(cbForm.getTuNgay().equals("THANG"))
				{
					date = cbForm.getKyBc()+"/"+cbForm.getNam();
					dateView="Tháng "+cbForm.getKyBc()+" năm "+cbForm.getNam();
				}
				else if(cbForm.getTuNgay().equals("QUY"))
				{
					date = cbForm.getKyBc()+"st"+cbForm.getNam();
					dateView ="Quý "+cbForm.getKyBc()+" năm "+cbForm.getNam();
				}
				else if(cbForm.getTuNgay().equals("NAM"))
				{
					date = cbForm.getNam();
					dateView ="Năm "+cbForm.getNam();
				}
			}*/
			dateView = " Từ tháng "+cbForm.getTuThang()+" đến tháng "+cbForm.getDenThang();
			parameters.put("ngay_lap_bao_cao", Formater.getDateForPrintUpper(cbForm.getNgayLap()));
			parameters.put("p_ngay_lap_bao_cao", cbForm.getNgayLap());
			parameters.put("thoi_gian_bao_cao", dateView);
			//KTNB2
			parameters.put("p_date", date);
			//parameters.put("p_date", null);
			parameters.put("p_type",cbForm.getTuNgay());			
			/*if(fileTemplate.indexOf("ttnb43")!=-1)
			{
				parameters.put("p_nam", cbForm.getNam());
				parameters.put("p_nam_sau", String.valueOf(Integer.parseInt(cbForm.getNam())+1));
			}*/
			parameters.put("p_nam_sau", "0");//Khong dung nua
			String pCqt ="";
			if (!Formater.isNull(cbForm.getArrCqt())) { // Lay tu man hinh
				pCqt = cbForm.getArrCqt(); // Lay tu danh sach chon
			} else 
				pCqt = cbForm.getCapCqt(); // Lay tu combobox
			if(StringUtil.isBlankOrNull(pCqt)) pCqt = appContext.getMaCqt(); //Lay tu context
			// Tong Cuc khi chon Cuc thi lay tat ca VP Cuc + CCT truc thuoc 
			if(pCqt.equalsIgnoreCase("all")&&KtnbUtil.isTongCuc(appContext))
			{
				//pCqt = appContext.getMaCqt();
				pCqt = null;
			//}else if(appContext.getMaCqt().equals(cbForm.getCapCqt())&& KtnbUtil.isTongCuc(appContext))
			}
			else
			{
				String[] arrCqt = pCqt.split(";");
				String reArrCqt = "";
				for(int i=0;i<arrCqt.length;i++){
					String maCqt = arrCqt[i];
					if(!Formater.isNull(maCqt))
					{
						/*if(KtnbUtil.isTongCuc(maCqt))
							reArrCqt +=maCqt+";";
						else if(KtnbUtil.isCuc(maCqt))
							reArrCqt += KtnbUtil.getArrMaCqt(maCqt)+";";
						else reArrCqt += maCqt +";";*/
						reArrCqt += maCqt +";";
					}
				}
				pCqt=reArrCqt;
			}			
			parameters.put("p_ma_cqt", pCqt);
			// ket qua tong hop hay chi tiet
			parameters.put("p_thct", cbForm.getKetQua());
			if(fileTemplate.toLowerCase().indexOf("ttnb43e")!=-1 || fileTemplate.toLowerCase().indexOf("kntc29c")!=-1
					|| fileTemplate.toLowerCase().indexOf("kntc30c")!=-1||fileTemplate.toLowerCase().indexOf("ttnb02")!=-1)
			{
				parameters.put("p_content", cbForm.getArrNd());
				parameters.put("SUBREPORT_DIR", this.getServlet().getServletContext().getRealPath("/report/"));
			}	
			System.out.println("p_type: "+cbForm.getTuNgay()+"---p_date: "+date+" p_ma_cqt: "+parameters.get("p_ma_cqt")+" p_content: "+parameters.get("p_content"));
			net.sf.jasperreports.engine.util.JRProperties.setProperty("net.sf.jasperreports.query.executer.factory.plsql", "com.jaspersoft.jrx.query.PlSqlQueryExecuterFactory");
			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
			
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
			jasperReport.setWhenNoDataType(JasperReport.WHEN_NO_DATA_TYPE_ALL_SECTIONS_NO_DETAIL);
//			conn.setAutoCommit(false);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
			response.reset();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileTemplate.toUpperCase() + Formater.date2str4File(new Date()) + ".xls");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JExcelApiExporter exporter = new JExcelApiExporter();
			exporter.setParameter(JExcelApiExporterParameter.CHARACTER_ENCODING, "UTF-8");
			exporter.setParameter(JExcelApiExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JExcelApiExporterParameter.OUTPUT_STREAM, baos);
			exporter.setParameter(JExcelApiExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			exporter.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporter.setParameter(JExcelApiExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			exporter.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporter.exportReport();
			ServletOutputStream oStream = response.getOutputStream();
			oStream.write(baos.toByteArray());
			oStream.flush();
			oStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(conn);
		}
		return null;
	}

	public ActionForward bctt43(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		if (Formater.isNull(cnForm.getNam()))
			cnForm.setNam(String.valueOf(new Date().getYear() + 1900));
		cnForm.setLoaiBaoCaoTtkt("43");
		cnForm.setNguoiLap(appContext.getTenCanbo());
		cnForm.setNgayLap(Formater.date2str(new Date()));
		cnForm.setDiaDiem(appContext.getTenCqt());
		KtnbUtil.setCqt(appContext, cnForm, request,null);
		saveToken(request);

		request.setAttribute("header", "B\u00C1O C\u00C1O C\u00D4NG T\u00C1C THANH TRA, KI\u1EC2M TRA N\u1ED8I B\u1ED8 NG\u00C0NH");
		return map.findForward("bctt43");
	}

	public ActionForward bctt02(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm cnForm = (BaocaoForm) form;
		if (Formater.isNull(cnForm.getNam()))
			cnForm.setNam(String.valueOf(new Date().getYear() + 1900));
		cnForm.setLoaiBaoCaoTtkt("02");
		cnForm.setNguoiLap(appContext.getTenCanbo());
		cnForm.setNgayLap(Formater.date2str(new Date()));
		cnForm.setDiaDiem(appContext.getTenCqt());
		KtnbUtil.setCqt(appContext, cnForm, request,appContext.getMaCqt());
		saveToken(request);
		request.setAttribute("header", "B\u00C1O C\u00C1O K\u1EBE HO\u1EA0CH THANH TRA KI\u1EC2M TRA N\u1ED8I B\u1ED8 NG\u00C0NH");
		if (!KtnbUtil.isChiCuc(appContext)) {
			ArrayList arrTemp = new ArrayList();
			arrTemp.add(new KtnbDmCqt("all","T\u1EA5t c\u1EA3"));
			if (KtnbUtil.isTongCuc(appContext)) {
				arrTemp.addAll(KtnbUtil.getCucThue(appContext, true, request,null));
				request.setAttribute("dmCqtTrucThuoc", arrTemp);

			} else {
				arrTemp.addAll(KtnbUtil.getCqtTrucThuoc(appContext, request, appContext.getMaCqt()));
				request.setAttribute("dmCqtTrucThuoc", arrTemp);
			}

		} else {
			ArrayList arrTemp = new ArrayList();
			arrTemp.add(new KtnbDmCqt(appContext.getMaCqt(), appContext.getTenCqt()));
			request.setAttribute("dmCqtTrucThuoc", arrTemp);
		}
		return map.findForward("bctt02");
	}

	public ActionForward inBc02(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm baocaoForm = (BaocaoForm) form;
		Connection conn = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			// HashMap[] reportRows = null;
			Map parameters = new HashMap();
			String fileTemplate = "ttnb02";
			parameters.put("ten_cqt", KtnbUtil.getTenCqtCapTrenTt(appContext));
			parameters.put("dv_thuc_hien_ttkt", appContext.getTenCqt());
			parameters.put("thu_truong_cqt", KtnbUtil.getTenThuTruongCqt(appContext));
			parameters.put("chuc_danh_thu_truong", KtnbUtil.getTenThuTruongCqt(appContext));
			parameters.put("ten_thu_truong", appContext.getTenThuTruong());
			parameters.put("nam", "'%" + baocaoForm.getNam() + "%'");
			parameters.put("namHienThi", baocaoForm.getNam());
			parameters.put("id_don_vi_th", appContext.getMaCqt());
			String cqtCon = " ma_cqt = '" + appContext.getMaCqt() + "'";
			parameters.put("p_ma_cqt", cqtCon);
			if("all".equals(baocaoForm.getCqt())){
				if(KtnbUtil.isTongCuc(appContext)){
					parameters.put("ma_cqt_lap_bc", "%%");
				}else{
					parameters.put("ma_cqt_lap_bc", appContext.getMaCqt().substring(0, 3) + "%");
				}
			}else{
				parameters.put("ma_cqt_lap_bc", baocaoForm.getCqt());
			}
			
			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
			// long start = System.currentTimeMillis();
			// String format = "xls";
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
			jasperReport.setWhenNoDataType(JasperReport.WHEN_NO_DATA_TYPE_ALL_SECTIONS_NO_DETAIL);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
			response.reset();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileTemplate.toUpperCase() + Formater.date2str4File(new Date()) + ".xls");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JExcelApiExporter exporter = new JExcelApiExporter();
			exporter.setParameter(JExcelApiExporterParameter.CHARACTER_ENCODING, "UTF-8");
			exporter.setParameter(JExcelApiExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JExcelApiExporterParameter.OUTPUT_STREAM, baos);
			exporter.setParameter(JExcelApiExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			exporter.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporter.setParameter(JExcelApiExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			exporter.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporter.exportReport();
			ServletOutputStream oStream = response.getOutputStream();
			oStream.write(baos.toByteArray());
			oStream.flush();
			oStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(conn);
		}

		return null;
	}

	public ActionForward inBc43(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaocaoForm baocaoForm = (BaocaoForm) form;
		Connection conn = null;
		try {
			conn = DataSourceConfiguration.getConnection();

			HashMap[] reportRows = null;
			Map parameters = new HashMap();
			String fileTemplate = "ttnb43";

			parameters.put("ten_cqt_bao_cao", appContext.getTenCqt());
			parameters.put("ten_can_bo_lap", appContext.getTenCanbo());
			parameters.put("noi_lap_bao_cao", baocaoForm.getDiaDiem());
			String[] arrNgayLap = baocaoForm.getNgayLap().split("/");

			parameters.put("ngay_lap_bao_cao", "ng\u00E0y " + arrNgayLap[0] + " th\u00E1ng " + arrNgayLap[1] + " n\u0103m " + arrNgayLap[2]);
			parameters.put("ten_thu_truong", KtnbUtil.getLanhDaoByMaCqt(appContext.getMaCqt()) == null ? "" : KtnbUtil.getLanhDaoByMaCqt(appContext.getMaCqt()));

			parameters.put("ten_cqt", KtnbUtil.getTenCqtCapTrenTt(appContext));
			parameters.put("dv_thuc_hien_ttkt", appContext.getTenCqt());
			parameters.put("thu_truong_cqt", KtnbUtil.getTenThuTruongCqt(appContext));
			parameters.put("nam", "%" + baocaoForm.getTuNgay().split("/")[2] + "%");
			parameters.put("nam_sau", "%" + baocaoForm.getDenNgay().split("/")[2] + "%");
			parameters.put("namHienThi", baocaoForm.getNam());
			parameters.put("id_don_vi_th", appContext.getMaCqt());
			String cqtCon = " ma_cqt = '" + appContext.getMaCqt() + "'";
			parameters.put("p_ma_cqt", cqtCon);
			parameters.put("p_tu_ngay", "'" + baocaoForm.getTuNgay() + "'");
			parameters.put("p_den_ngay", "'" + baocaoForm.getDenNgay() + "'");
			parameters.put("thoi_gian_bao_cao", Formater.getDateForPrint(baocaoForm.getTuNgay()) + " \u0111\u1EBFn " + Formater.getDateForPrint(baocaoForm.getDenNgay()));
			if (KtnbUtil.isTongCuc(appContext))
				parameters.put("ma_cqt_lap_bc", "%%");
			else if (KtnbUtil.isCuc(appContext))
				parameters.put("ma_cqt_lap_bc", appContext.getMaCqt().substring(0, 3) + "%");
			else if (KtnbUtil.isChiCuc(appContext))
				parameters.put("ma_cqt_lap_bc", appContext.getMaCqt());
			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
			// long start = System.currentTimeMillis();
			// String format = "xls";
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
			jasperReport.setWhenNoDataType(JasperReport.WHEN_NO_DATA_TYPE_ALL_SECTIONS_NO_DETAIL);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
			response.reset();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileTemplate.toUpperCase() + Formater.date2str4File(new Date()) + ".xls");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JExcelApiExporter exporter = new JExcelApiExporter();
			exporter.setParameter(JExcelApiExporterParameter.CHARACTER_ENCODING, "UTF-8");
			exporter.setParameter(JExcelApiExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JExcelApiExporterParameter.OUTPUT_STREAM, baos);
			exporter.setParameter(JExcelApiExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			exporter.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporter.setParameter(JExcelApiExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			exporter.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporter.exportReport();
			ServletOutputStream oStream = response.getOutputStream();
			oStream.write(baos.toByteArray());
			oStream.flush();
			oStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(conn);
		}

		return null;
	}
}
