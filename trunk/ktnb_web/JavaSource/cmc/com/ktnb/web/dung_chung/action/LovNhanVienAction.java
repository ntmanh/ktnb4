/*
 * Created on Nov 4, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.dung_chung.action;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.criterion.Restrictions;

import cmc.com.ktnb.pl.hb.entity.KtnbDmCanbo;
import cmc.com.ktnb.pl.hb.entity.KtnbDmCqt;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HtmlTable;
import cmc.com.ktnb.util.KtnbDAO;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.QueryDetails;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.vo.CategoryVO;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.dung_chung.form.LovNhanVienForm;

/**
 * @author ntdung1
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LovNhanVienAction extends BaseDispatchAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		LovNhanVienForm nvForm = (LovNhanVienForm) form;

		String method = request.getParameter("method");
		if ("selectCqtTrucThuoc".equals(method)) {
			// Danh sach ma cqt truc thuoc
			Collection dsCqtTrucThuoc = KtnbUtil.getCqtTrucThuoc(appContext, request, nvForm.getMaCqt());
			request.setAttribute("dsCqtTrucThuoc", dsCqtTrucThuoc);

			// danh sach phong ban truc thuoc
			Collection dsPhongBanTrucThuoc = KtnbUtil.getDeptByMaCqt(nvForm.getMaCqtTrucThuoc());
			request.setAttribute("dsPhongBanTrucThuoc", dsPhongBanTrucThuoc);

		} else if ("chonCanBo".equals(method)) {
			String idCanBo = request.getParameter("idCanBo");
			response.setContentType("application/json;charset=UTF-8");
			response.setHeader("Cache-Control", "no-store");
			PrintWriter out = response.getWriter();
			out.print(selectCanBo(idCanBo, request));
			out.flush();
			out.close();
			return null;
		} else if ("search".equals(method)) {
			if (nvForm.isSearchCqtTrucThuoc()) {
				// Danh sach cqt truc thuoc
				try {
					ArrayList dsCqtTrucThuoc = (ArrayList) KtnbUtil.getCqtTrucThuoc(appContext, request, nvForm.getMaCqt());
					request.setAttribute("dsCqtTrucThuoc", dsCqtTrucThuoc);
					// Danh sach phong ban
					Collection dsPhongBanTrucThuoc = KtnbUtil.getDeptByMaCqt(nvForm.getMaCqtTrucThuoc());
					request.setAttribute("dsPhongBanTrucThuoc", dsPhongBanTrucThuoc);

				} catch (Exception ex) {

				}

			}

		} else {// Load form
			nvForm.setMaCqt(request.getParameter("maCqt"));
			nvForm.setTenNhanVien(request.getParameter("tenNhanVien"));
			nvForm.setSearchCqtTrucThuoc("true".equals(request.getParameter("cqtt")));
			if (nvForm.isSearchCqtTrucThuoc()) {
				try {
					// Danh sach ma cqt truc thuoc cua don vi bi, chi tong cuc
					// thue moi co,
					ArrayList dsCqtTrucThuoc = (ArrayList) KtnbUtil.getCqtTrucThuoc(appContext, request, nvForm.getMaCqt());
					request.setAttribute("dsCqtTrucThuoc", dsCqtTrucThuoc);

					// Mac dinh co quan thue dau tien
					nvForm.setMaCqtTrucThuoc(((KtnbDmCqt) dsCqtTrucThuoc.get(0)).getMa());

					// danh sach phong ban truc thuoc
					Collection dsPhongBanTrucThuoc = KtnbUtil.getDeptByMaCqt(nvForm.getMaCqtTrucThuoc());
					request.setAttribute("dsPhongBanTrucThuoc", dsPhongBanTrucThuoc);

				} catch (Exception ex) {

				}

			}

			String isNsd = request.getParameter("isNsd");
			if (!Formater.isNull(isNsd) && "true".equals(isNsd)) {
				nvForm.setIsNSD("true");
			}
			request.setAttribute("type", request.getParameter("type"));
		}
		search(nvForm, request, appContext);

		return mapping.findForward("search");
	}

	private void search(LovNhanVienForm nvForm, HttpServletRequest request, ApplicationContext appContext) throws Exception {

		// Do du lieu vao combo

		Collection dsPhongBanTrucThuoc = (Collection) request.getAttribute("dsPhongBanTrucThuoc");
		if (Formater.isNull(dsPhongBanTrucThuoc)) {// Truong hop click vao nut
			// search
			if (Formater.isNull(nvForm.getMaCqtTrucThuoc()))
				dsPhongBanTrucThuoc = KtnbUtil.getDeptByMaCqt(nvForm.getMaCqt());
			else
				dsPhongBanTrucThuoc = KtnbUtil.getDeptByMaCqt(nvForm.getMaCqtTrucThuoc());
			request.setAttribute("dsPhongBanTrucThuoc", dsPhongBanTrucThuoc);
		}

		SearchCriteria criteria = new SearchCriteria(KtnbDmCanbo.class);
		// Ma co quan thue

		// ma phong
		if (Formater.isNull(nvForm.getMaPhong())) {
			Iterator iter = dsPhongBanTrucThuoc.iterator();
			Collection listPhongBanId = new ArrayList();
			while (iter.hasNext()) {
				CategoryVO phongBan = (CategoryVO) iter.next();
				listPhongBanId.add(phongBan.getId());
			}
			if (!Formater.isNull(listPhongBanId))
				criteria.addSearchItem(KtnbDmCanbo.MaPhong, listPhongBanId, SearchCriteria.OP_IN);
		} else
			criteria.addSearchItem(KtnbDmCanbo.MaPhong, nvForm.getMaPhong());
		if (!Formater.isNull(nvForm.getTenNhanVien()))
			criteria.addSearchItem(KtnbDmCanbo.Ten, "%" + nvForm.getTenNhanVien().trim().toUpperCase() + "%", SearchCriteria.OP_LIKE);
		// Chi show ra can bo la NSD
		// => Khi chuyen ung dung sang BMT luu y cho nay.
		if ("true".equals(nvForm.getIsNSD())) {
			criteria.setRestricQuery("{alias}.ma in (select ma_can_bo from ktnb_nsd)");
		}
		// queryDetails
		QueryDetails queryDetails = new QueryDetails();
		String pageNumber = request.getParameter("pageNumber");
		pageNumber = Formater.isNull(pageNumber) ? "1" : pageNumber;
		queryDetails.setPageNumber(Integer.valueOf(pageNumber));
		queryDetails.setPageSize(Constants.PAGE_SIZE_DEFAULT);
		criteria.setQueryDetail(queryDetails);

		Collection ketQuaTimKiem = new BaseHibernateDAO().retrieveObjects(appContext, criteria);
		if (ketQuaTimKiem.size() == 1) {
			KtnbDmCanbo canbo = (KtnbDmCanbo) ((ArrayList) ketQuaTimKiem).get(0);
			String idCanBo = canbo.getMa();
			request.setAttribute("tenCqtvaChucVu", selectCanBo(idCanBo, request));
			// return mapping.findForward("search");
			return;
		}

		// HtmlTable
		HtmlTable table = new HtmlTable();
		table.setPageNumber(pageNumber);
		table.setPageSize(Constants.PAGE_SIZE_DEFAULT.longValue());
		table.setData(ketQuaTimKiem);
		table.setSearchForm("LovNhanVienForm");
		table.setGoToPageUrl(this.getUrl(request, "dspb"));
		request.setAttribute("dsNhanVien", table);

	}

	private void search() {

	}

	/**
	 * @param idCanBo
	 */
	private String selectCanBo(String idCanBo, HttpServletRequest request) throws Exception {
		String reVal = "";
		String sql = "select t.MA, t.TEN, t3.ten as CHUC_VU, t1.ten as TEN_PHONG, t2.ten as TEN_CQT ";
		sql += "from ktnb_dm_can_bo t, ktnb_dm_phong t1, ktnb_dm_cqt t2, ktnb_dm t3 ";
		sql += "where t.ma_phong = t1.ma ";
		sql += "and t1.ma_cqt = t2.ma ";
		sql += "and t.ma_chuc_vu = t3.ma(+) ";
		sql += "and t.ma = '" + idCanBo;
		sql += "' and t1.ma = t.ma_phong";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			connection = DataSourceConfiguration.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				if (Formater.isNull(ma))
					ma = "";
				String ten = rs.getString(2);
				if (Formater.isNull(ten))
					ten = "";
				String chucVu = rs.getString(3);
				if (Formater.isNull(chucVu))
					chucVu = "";
				String tenPhong = rs.getString(4);
				if (Formater.isNull(tenPhong))
					tenPhong = "";
				String tenCqt = rs.getString(5);
				if (Formater.isNull(tenCqt))
					tenCqt = "";
				reVal = ma.trim() + "&" + ten.trim().trim() + "&" + chucVu.trim() + "&" + tenPhong.trim() + "&" + tenCqt.trim();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, statement, connection);
		}
		return reVal;

	}

	public ActionForward changeCqt(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("search");
	}

}
