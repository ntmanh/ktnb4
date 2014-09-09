package cmc.com.ktnb.web.ttkt.dung_chung.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.TTKT.dung_chung.KtnbKhTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.KtnbKhTtktNd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhChiTietNoiDungTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhNoiDungTtkt;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.DetailInformation;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.KtnbCache;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.vo.CategoryVO;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.dung_chung.form.CuocTtktForm;

/**
 * @@author ntdung1
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DanhMucGocNoiDungTtktAction extends BaseDispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("select");
	}
	/**
	 * @param cuoc_ttktForm
	 * @return
	 */
	private DetailInformation getDefaulValueForNoiDungTtkt(CuocTtktForm cuoc_ttktForm) throws Exception {
		DetailInformation noiDungTtkt = new DetailInformation();
		noiDungTtkt.setCol3(cuoc_ttktForm.getNienDoTuNgay());
		noiDungTtkt.setCol4(cuoc_ttktForm.getNienDoDenNgay());
		noiDungTtkt.setCol5(cuoc_ttktForm.getThoiGianDuKien());
		noiDungTtkt.setCol6(cuoc_ttktForm.getHinhThuc());
		noiDungTtkt.setCol7(cuoc_ttktForm.getLoai());
		noiDungTtkt.setActive(false);
		return noiDungTtkt;
	}
	private BaseHibernateDAO dao = new BaseHibernateDAO();
	/**
	 * @param ktnbCuocTtkt
	 * @param appContext
	 * @param request
	 */
	private void persisCuocTtkt(TtktKhCuocTtkt ktnbCuocTtkt, ApplicationContext appContext, HttpServletRequest request) throws Exception {

		dao.saveObject(appContext, ktnbCuocTtkt);

		// Neu cuoc Ttkt co noi dung ttkt (Khong phai truong hop cuoc Ttkt chinh)
		ArrayList dsNoiDungTtkt = (ArrayList) ktnbCuocTtkt.getDsNoiDungTTKT();
		if (!Formater.isNull(dsNoiDungTtkt)) {
			for (int i = 0; i < dsNoiDungTtkt.size(); i++) {
				TtktKhNoiDungTtkt noidungTtkt = (TtktKhNoiDungTtkt) dsNoiDungTtkt.get(i);
				// Persis noi dung Ttkt
				dao.saveObject(appContext, noidungTtkt);
				// Persis chi tiet noi dung
				ArrayList dsChiTietNoiDungTtkt = (ArrayList) noidungTtkt.getDsChiTietNoiDung();
				if (!Formater.isNull(dsChiTietNoiDungTtkt)) {
					for (int j = 0; j < dsChiTietNoiDungTtkt.size(); j++) {
						TtktKhChiTietNoiDungTtkt chiTietNoiDungTtkt = (TtktKhChiTietNoiDungTtkt) dsChiTietNoiDungTtkt.get(j);
						dao.saveObject(appContext, chiTietNoiDungTtkt);
					}
				}

			}
		}

		// Neu cuoc Ttkt co Ttkt nhieu Cqt truc thuoc 
		ArrayList dsTtktCqtTrucThuoc = (ArrayList) ktnbCuocTtkt.getDsTtktCqtTrucThuoc();
		if (!Formater.isNull(dsTtktCqtTrucThuoc)) {
			for (int i = 0; i < dsTtktCqtTrucThuoc.size(); i++) {
				TtktKhCuocTtkt ttktcqtTrucThuoc = (TtktKhCuocTtkt) dsTtktCqtTrucThuoc.get(i);
				persisCuocTtkt(ttktcqtTrucThuoc, appContext, request);
			}
		}

	}

	/**
	 * @param information
	 * @param ttktCqt
	 * @return
	 */
	private Object createMotNoiDungTtktCqtTrucThuoc(DetailInformation detailInformation, String cuocTtktId) throws Exception {
		TtktKhNoiDungTtkt ktnbNoiDungTtkt = new TtktKhNoiDungTtkt();
		ktnbNoiDungTtkt.setId(KeyManagement.getGUID());
		ktnbNoiDungTtkt.setIdNoiDung(detailInformation.getCol2());
		ktnbNoiDungTtkt.setTenNoiDung(detailInformation.getCol11());
		ktnbNoiDungTtkt.setDsChiTietNoiDung(createChiTienNoiDung(ktnbNoiDungTtkt.getId(), detailInformation.getCol3(), detailInformation.getCol12()));
		ktnbNoiDungTtkt.setHinhThuc(Boolean.valueOf(detailInformation.getCol7()));
		ktnbNoiDungTtkt.setLoai(Boolean.valueOf(detailInformation.getCol8()));
		ktnbNoiDungTtkt.setNienDoDenNgay(Formater.str2date(detailInformation.getCol5()));
		ktnbNoiDungTtkt.setNienDoTuNgay(Formater.str2date(detailInformation.getCol4()));
		ktnbNoiDungTtkt.setThoiGianDuKien(Byte.valueOf(detailInformation.getCol6()));
		ktnbNoiDungTtkt.setIdCuocTtkt(cuocTtktId);
		return ktnbNoiDungTtkt;
	}
	/**
	 * @param information
	 * @return
	 */
	private TtktKhNoiDungTtkt createMotNoiDungTtktCqtTrucThuoc(DetailInformation detailInformation) throws Exception {
		TtktKhNoiDungTtkt ktnbNoiDungTtkt = new TtktKhNoiDungTtkt();
		ktnbNoiDungTtkt.setId(KeyManagement.getGUID());
		ktnbNoiDungTtkt.setIdNoiDung(detailInformation.getCol2());
		ktnbNoiDungTtkt.setTenNoiDung(detailInformation.getCol11());
		ktnbNoiDungTtkt.setDsChiTietNoiDung(createChiTienNoiDung(ktnbNoiDungTtkt.getId(), detailInformation.getCol3(), detailInformation.getCol12()));
		ktnbNoiDungTtkt.setHinhThuc(Boolean.valueOf(detailInformation.getCol7()));
		ktnbNoiDungTtkt.setLoai(Boolean.valueOf(detailInformation.getCol8()));
		ktnbNoiDungTtkt.setNienDoDenNgay(Formater.str2date(detailInformation.getCol5()));
		ktnbNoiDungTtkt.setNienDoTuNgay(Formater.str2date(detailInformation.getCol4()));
		ktnbNoiDungTtkt.setThoiGianDuKien(Byte.valueOf(detailInformation.getCol6()));
		return ktnbNoiDungTtkt;
	}
	/**
	 * @param string
	 * @return
	 */
	private Collection createChiTienNoiDung(String idNoiDung, String maChiTietNoiDung, String tenChiTietNoiDung) throws Exception {
		Collection listChiTietNoiDung = new ArrayList();
		String[] arrChiTietNoiDung = maChiTietNoiDung.trim().split(",");
		for (int i = 0; i < arrChiTietNoiDung.length; i++) {
			TtktKhChiTietNoiDungTtkt chiTietNoiDungTtkt = new TtktKhChiTietNoiDungTtkt();
			chiTietNoiDungTtkt.setId(KeyManagement.getGUID());
			chiTietNoiDungTtkt.setIdNoiDungTtkt(idNoiDung);
			chiTietNoiDungTtkt.setIdNoiDungChiTiet(arrChiTietNoiDung[i].trim());
			chiTietNoiDungTtkt.setTenNoiDungChiTiet("phai lay lai noi dung chi tiet");
			listChiTietNoiDung.add(chiTietNoiDungTtkt);
			// TODO: Phai lay lai noi dung chi tiet
		}

		return listChiTietNoiDung;
	}
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// load gia tri mac dinh
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		CuocTtktForm cuoc_ttktForm = (CuocTtktForm) form;
		loadDefaut(appContext, request, cuoc_ttktForm);

		return mapping.findForward("success");
	}
	public ActionForward copy(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cuocTtktId = request.getParameter("id");
		CuocTtktForm cuocTtktForm = (CuocTtktForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// Lay thong tin cuoc TTKT
		cuocTtktForm.setKtnbKhTtkt(getCuocTtktById(request, appContext, cuocTtktId));
		// Sinh ma khac
		//cuocTtktForm.setMaKhTtkt(genMaCuocTTKT(appContext));
		cuocTtktForm.setId("");
		// Lay noi dung TTKT
		cuocTtktForm.setDmNoiDungTTKT(getDmNoiDungTtktGoc());
		return mapping.findForward("success");

	}
	private void getCuocTtktById(String strId, HttpServletRequest request, KtnbKhTtkt ktnbKhTtkt, Collection lstNoiDungTTKT) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);

		// Lay thong tin cuoc TTKT
		SearchCriteria criteria = new SearchCriteria(KtnbKhTtkt.class);
		criteria.addSearchItem("id", strId);
		ktnbKhTtkt = (KtnbKhTtkt) new BaseHibernateDAO().retrieveObject(appContext, KtnbKhTtkt.class, strId);

		// Lay noi dung TTKT
		lstNoiDungTTKT = getNoiDungOfCuocTtkt(strId);
	}

	/**
	 * @param strCuocTtktId
	 * @return
	 */
	private Collection getNoiDungOfCuocTtkt(String strCuocTtktId) {

		return null;
	}
	/**
	 * @param appContext
	 * @param request
	 * @param cuoc_ttktForm
	 */
	private void loadDefaut(ApplicationContext appContext, HttpServletRequest request, CuocTtktForm cuoc_ttktForm) throws Exception {
		cuoc_ttktForm.setDonViBiName("");
		cuoc_ttktForm.setDonViThName(appContext.getTenCqt());
		//data.setFromDate(new Date());
		cuoc_ttktForm.setGhiChu("");
		if (KtnbUtil.isChiCuc(appContext)) {
			cuoc_ttktForm.setIdDonViBi(appContext.getMaCqt());
			cuoc_ttktForm.setDonViBiName(appContext.getTenCqt());
		} else {
			cuoc_ttktForm.setIdDonViBi("");
			cuoc_ttktForm.setDonViBiName("");
		}
		cuoc_ttktForm.setIdDonViTh(appContext.getMaCqt());
		cuoc_ttktForm.setHinhThuc("0");
		cuoc_ttktForm.setLoai("0");
		cuoc_ttktForm.setThoiGianDuKien("45");
		
		cuoc_ttktForm.setNienDoTuNgay("11/11/2010");
		cuoc_ttktForm.setNienDoDenNgay("11/11/2011");

	}

	

	/**
	 * @@param appContext
	 * @@param request
	 * @@return
	 */
	private Collection getDmNoiDungTtktGoc() throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection retval = new ArrayList();
		String sql = "select * from ktnb_dm t where t.parent_id = " + Constants.DM_TTKT;
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			CategoryVO vo;
			String ma;
			String ten;
			while (rs.next()) {
				ma = rs.getString(1);
				ten = rs.getString(2);
				vo = new CategoryVO(ma, ten);
				retval.add(vo);
			}
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}

	public ActionForward xoaCqtTrucThuoc(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		CuocTtktForm cuocTtktForm = (CuocTtktForm) form;
		TtktKhCuocTtkt cuocTtkt = new TtktKhCuocTtkt();
		return mapping.findForward("success");

	}

	private DetailInformation getDefaulValueForCuocTTKT(CuocTtktForm cuocTtktForm) throws Exception {
		DetailInformation ttktCqtrucThuoc = new DetailInformation();
		ttktCqtrucThuoc.setCol0(KeyManagement.getGUID());
		ttktCqtrucThuoc.setCol4(cuocTtktForm.getNienDoTuNgay());
		ttktCqtrucThuoc.setCol5(cuocTtktForm.getNienDoDenNgay());
		ttktCqtrucThuoc.setCol6(cuocTtktForm.getThoiGianDuKien());
		ttktCqtrucThuoc.setCol7(cuocTtktForm.getHinhThuc());
		ttktCqtrucThuoc.setCol8(cuocTtktForm.getLoai());
		return ttktCqtrucThuoc;

	}
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		CuocTtktForm cuocTtktForm = (CuocTtktForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		if (cuocTtktForm.getId() != null && !cuocTtktForm.getId().equals("")) {
			save(appContext, cuocTtktForm, request);
		} else
			add(appContext, cuocTtktForm, request);
		return mapping.findForward("kehoachnam");
	}
	/**
	 * @param appContext
	 * @param cuocTtktForm
	 * @param request
	 */
	private void add(ApplicationContext appContext, CuocTtktForm cuocTtktForm, HttpServletRequest request) throws Exception {
		// Luu vao bang cuoc ttkt 
		KtnbKhTtkt ktnbKhTtkt = getVoFromForm(cuocTtktForm, appContext);
		ktnbKhTtkt = (KtnbKhTtkt) new BaseHibernateDAO().saveObject(appContext, ktnbKhTtkt);

		// Luu vao bang quan he		
		String strNoidungTTKT = "";
		String[] arrNoidung = strNoidungTTKT.split(",");
		for (int i = 0; i < arrNoidung.length; i++) {
			KtnbKhTtktNd ktnbKhTtktNd = new KtnbKhTtktNd();
			ktnbKhTtktNd.setIdDmNoiDungTtkt(arrNoidung[i]);
			ktnbKhTtktNd.setIdKhTtkt(ktnbKhTtkt.getId());
			ktnbKhTtktNd.setId(KeyManagement.getGUID());
			new BaseHibernateDAO().saveObject(appContext, ktnbKhTtktNd);
		}

	}

	/**
	 * @param appContext
	 * @param cuocTtktForm
	 * @param request
	 */
	private void save(ApplicationContext appContext, CuocTtktForm cuocTtktForm, HttpServletRequest request) throws Exception {
		// Luu vao bang cuoc ttkt 
		KtnbKhTtkt ktnbKhTtkt = getVoFromForm(cuocTtktForm, appContext);
		new BaseHibernateDAO().updateObject(appContext, ktnbKhTtkt);

		// Xoa bo noi dung TTKT cu
		Connection conn = null;
		Statement ps = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.createStatement();
			ps.execute("delete ktnb_kh_ttkt_nd where id_kh_ttkt = '" + cuocTtktForm.getId() + "'");
		} catch (Exception e) {

		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps, conn);
		}
		// Luu noi dung ttkt moi		
		String strNoidungTTKT = "";
		String[] arrNoidung = strNoidungTTKT.split(",");
		for (int i = 0; i < arrNoidung.length; i++) {
			KtnbKhTtktNd ktnbKhTtktNd = new KtnbKhTtktNd();
			ktnbKhTtktNd.setIdDmNoiDungTtkt(arrNoidung[i]);
			ktnbKhTtktNd.setIdKhTtkt(ktnbKhTtkt.getId());
			ktnbKhTtktNd.setId(KeyManagement.getGUID());
			new BaseHibernateDAO().saveObject(appContext, ktnbKhTtktNd);
		}

	}

	/**
	 * @param cuocTtktForm
	 * @param appContext
	 * @return
	 */
	private KtnbKhTtkt getVoFromForm(CuocTtktForm cuocTtktForm, ApplicationContext appContext) throws Exception {
		KtnbKhTtkt ktnbKhTtkt = new KtnbKhTtkt();
		ktnbKhTtkt.setDonViBiName(cuocTtktForm.getDonViBiName());
		ktnbKhTtkt.setDonViThName(appContext.getTenCqt());
		ktnbKhTtkt.setNienDoTuNgay(Formater.str2date(cuocTtktForm.getNienDoTuNgay()));
		ktnbKhTtkt.setGhiChu(ktnbKhTtkt.getGhiChu());
		if (cuocTtktForm.getId() == null || cuocTtktForm.getId().equals(""))
			ktnbKhTtkt.setId(KeyManagement.getGUID());
		else
			ktnbKhTtkt.setId(cuocTtktForm.getId());
		ktnbKhTtkt.setIdCanBo(appContext.getMaCanbo());
		ktnbKhTtkt.setIdDonVi(appContext.getMaCqt());
		ktnbKhTtkt.setIdDonViBi(cuocTtktForm.getIdDonViBi());
		ktnbKhTtkt.setIdDonViTh(appContext.getMaCqt());
		ktnbKhTtkt.setHinhThuc(new Long(cuocTtktForm.getHinhThuc()));
		ktnbKhTtkt.setLoai(new Long(cuocTtktForm.getLoai()));
		ktnbKhTtkt.setMaKhTtkt(cuocTtktForm.getMaKhTtkt());
		ktnbKhTtkt.setThoiGianDuKien(new Short(cuocTtktForm.getThoiGianDuKien()));
		ktnbKhTtkt.setNienDoDenNgay(Formater.str2date(cuocTtktForm.getNienDoDenNgay()));
		ktnbKhTtkt.setNienDoTtkt(cuocTtktForm.getNienDoTuNgay() + "-" + cuocTtktForm.getNienDoDenNgay());
		return ktnbKhTtkt;
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cuocTtktId = request.getParameter("id");
		CuocTtktForm cuocTtktForm = (CuocTtktForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// Lay thong tin cuoc TTKT
		cuocTtktForm.setKtnbKhTtkt(getCuocTtktById(request, appContext, cuocTtktId));
		cuocTtktForm.setId(cuocTtktId);
		// Lay noi dung TTKT
		cuocTtktForm.setDmNoiDungTTKT(getDmNoiDungTtktGoc());

		return mapping.findForward("success");

	}
	/**
	 * @param cuocTtktId
	 * @return
	 */
	private KtnbKhTtkt getCuocTtktById(HttpServletRequest request, ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(KtnbKhTtkt.class);
		criteria.addSearchItem("id", cuocTtktId);
		return (KtnbKhTtkt) new BaseHibernateDAO().retrieveObject(appContext, KtnbKhTtkt.class, cuocTtktId);
	}

	/**
	 * @param appContext
	 * @param request
	 * @param cuocTtktId
	 * @return
	 */
	private String getSelectedNoiDung(ApplicationContext appContext, HttpServletRequest request, String cuocTtktId) throws Exception {
		Collection noiDungTTKT = getNoidungTTKT(cuocTtktId);
		String strReturn = "";
		//		Iterator iter = noiDungTTKT.iterator();
		//		while (iter.hasNext())
		//			strReturn += ((KtnbDmChung) iter.next()).getId() + ",";
		//		strReturn = strReturn.substring(0, strReturn.length() - 2);
		return strReturn;
	}

	/**
	 * 
	 * @param request
	 * @param cuocTtktId
	 * @param appContext
	 * @return CuocTtktForm
	 */
	private CuocTtktForm getDataToForm(HttpServletRequest request, ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(KtnbKhTtkt.class);
		criteria.addSearchItem("id", cuocTtktId);
		KtnbKhTtkt khTtkt = (KtnbKhTtkt) new BaseHibernateDAO().retrieveObject(appContext, KtnbKhTtkt.class, cuocTtktId);
		CuocTtktForm cuocTtktForm = new CuocTtktForm();
		cuocTtktForm.setKtnbKhTtkt(khTtkt);
		return cuocTtktForm;
	}
	public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String cuocTtktId = request.getParameter("id");
		CuocTtktForm cuocTtktForm = (CuocTtktForm) form;

		// Lay thong tin cuoc TTKT
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		SearchCriteria criteria = new SearchCriteria(KtnbKhTtkt.class);
		criteria.addSearchItem("id", cuocTtktId);
		KtnbKhTtkt khTtkt = (KtnbKhTtkt) new BaseHibernateDAO().retrieveObject(appContext, KtnbKhTtkt.class, cuocTtktId);
		cuocTtktForm.setKtnbKhTtkt(khTtkt);

		// Lay noi dung cua cuoc TTKT
		cuocTtktForm.setDmNoiDungTTKT(getNoidungTTKT(cuocTtktId));
		return mapping.findForward("success");
	}

	/**
	 * @param request
	 * @param appContext
	 * @param cuocTtktId
	 * @return
	 */
	private Collection getNoidungTTKT(String cuocTtktId) throws Exception {
		//		String sql = "select t.* from ktnb_dm_chung t, ktnb_kh_ttkt_nd t1 where t1.id_dm_noi_dung_ttkt = t.id and t1.id_kh_ttkt = '" + cuocTtktId + "'";
		//		Session s = HibernateSessionFactory.currentSession();
		//		return s.createSQLQuery(sql).addEntity(KtnbDm.class).list();
		return new ArrayList();
	}

}
