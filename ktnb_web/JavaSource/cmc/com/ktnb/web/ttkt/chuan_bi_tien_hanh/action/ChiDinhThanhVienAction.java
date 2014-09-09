/*
 * Created on Jan 6, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbDsTvDoan;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DetailInformation;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.form.ChiDinhThanhVienForm;

/**
 * @author Nguyen Tien Dung
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ChiDinhThanhVienAction extends BaseDispatchAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception, Exception {

		ChiDinhThanhVienForm chiDinhTVForm = (ChiDinhThanhVienForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		chiDinhTVForm.setNoiLap(appContext.getDiaBan());
		
		// lay ngay hien tai
		Calendar cal = Calendar.getInstance();
		String day = Integer.toString(cal.get(Calendar.DATE));
		String month = Integer.toString(cal.get(Calendar.MONTH) + 1);
		String year = Integer.toString(cal.get(Calendar.YEAR));
		String thisday = day + "/" + month + "/" + year;
		chiDinhTVForm.setNgayLap(thisday);
		String method = request.getParameter("method");

		// su kien voi nut Save,luu danh sach than vien doan
		if ("save".equals(method)) {
			TtktCbDsTvDoan ktnbDsTvd = createDsTvDoan(appContext, chiDinhTVForm, request);
			save(ktnbDsTvd, appContext);
		}
		// su kien voi nut themTV, them mot thanh vien doan vao danh sach
		else if ("themTV".equals(method)) {
			DetailInformation[] dsThanhVien = chiDinhTVForm.getDsThanhVienDoan();
			ArrayList arrNewDsTv = new ArrayList();
			if (!Formater.isNull(dsThanhVien)) {

				for (int i = 0; i < dsThanhVien.length; i++) {
					arrNewDsTv.add(dsThanhVien[i]);
				}
			}
			DetailInformation information = new DetailInformation();
			// Set gia tri mac dinh cho thanh vien vua duoc bo sung
			information.setCol1(appContext.getTenCqt());
			arrNewDsTv.add(information);
			chiDinhTVForm.setDsThanhVienDoan(DetailInformation.convertFromArrayList(arrNewDsTv));
		}
		return mapping.findForward("view");
	}

	/**
	 * @param appContext
	 * @param chiDienTVForm
	 * @param request
	 * @return
	 */

	private void Load() {

	}

	private TtktCbDsTvDoan createDsTvDoan(ApplicationContext appContext, ChiDinhThanhVienForm chiDienTVForm, HttpServletRequest request) throws Exception {
		// Lay thong tin Ds Tvd
		TtktCbDsTvDoan dsTvd = new TtktCbDsTvDoan();
		dsTvd.setNgayLap(Formater.str2date(chiDienTVForm.getNgayLap()));
		dsTvd.setNoiLap(chiDienTVForm.getNoiLap());

		dsTvd.setIdNguoiCapNat(appContext.getMaCanbo());
		dsTvd.setTenNguoiCapNhat(appContext.getTenCanbo());
		dsTvd.setNgayCapNhat(new Date());

		// Lay chi tiet dstv
		ArrayList chiTietDsTv = new ArrayList();
		DetailInformation[] chiTiet = chiDienTVForm.getDsThanhVienDoan();
		for (int i = 0; i < chiTiet.length; i++) {
			TtktCbChiTietDsTvDoan chiTietDsTvd = new TtktCbChiTietDsTvDoan();
			// Lay gia tri tu form
			chiTietDsTv.add(chiTietDsTvd);
		}
		dsTvd.setChiTietDanhSachTV(chiTietDsTv);
		return dsTvd;
	}

	/**
	 * @param ktnbDsTvd
	 */
	private void save(TtktCbDsTvDoan ktnbDsTvd, ApplicationContext appContext) throws Exception {
		// Save vao bang Ds thanh vien
		new BaseHibernateDAO().saveObject(appContext, ktnbDsTvd);
		// Save vao bang chi tiet Ds Thanh vien
		Collection chiTietDsTv = ktnbDsTvd.getChiTietDanhSachTV();
		Iterator iter = chiTietDsTv.iterator();
		while (iter.hasNext())
			new BaseHibernateDAO().saveObject(appContext, (TtktCbChiTietDsTvDoan) iter.next());
	}
}
