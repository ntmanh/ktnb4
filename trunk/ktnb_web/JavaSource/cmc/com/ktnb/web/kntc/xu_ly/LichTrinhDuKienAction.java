/*
 * Created on Apr 25, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.kntc.xu_ly;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import cmc.com.ktnb.pl.hb.entity.KntcCanBoRls;
import cmc.com.ktnb.pl.hb.entity.KntcDeXuatXly;
import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.service.kntc.KntcSoTiepDan;
import cmc.com.ktnb.service.kntc.PhanLoaiXuLyService;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.service.kntc.XuLyDonChungService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.web.BaseDispatchAction;

/**
 * Xử lý lịch trình dự kiến
 * @author dhphuc
 * 
 * To change the template for this generated type comment go to Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LichTrinhDuKienAction extends BaseDispatchAction {
	public ActionForward show(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		LichTrinhDuKienForm ltForm = (LichTrinhDuKienForm) form;
		String maHs = request.getParameter("id");
		ltForm.setMaHoSo(maHs);

		// Get hdr
		SoTiepDanService s = new SoTiepDanService();
		KntcSoTiepDan hs = s.getSoTiepDan(appContext, maHs, true);
		KntcHoSoHdr hdr = hs.getHdr();
		// Get thong tin can bo thu ly
		XuLyDonChungService service = new XuLyDonChungService();
		KntcCanBoRls cbRls = service.getCBXLHienTai(maHs);
		// Set thong tin len Form
		ltForm.setCanBoThuLy(cbRls.getTenCb());
		ltForm.setNgayCVDen(Formater.date2str(hdr.getCongVanDenNgay()));
		// ltForm.setLoaiHS("Khong du tham quyen giai quyet");
		// ltForm.setNoiDung(hs.getNoiDungDon().getNoiDung());
		return map.findForward("success");
	}

	public ActionForward getLichTrinh(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonResult = null;
		LichTrinhDuKienForm ltForm = (LichTrinhDuKienForm) form;
		try {
			jsonResult = this.getObject(ltForm, request);
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

	private JSONObject getObject(LichTrinhDuKienForm ltForm, HttpServletRequest request) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// Get ma Ho so
		String maHs = request.getParameter("id");
		if (!Formater.isNull(maHs))
			ltForm.setMaHoSo(maHs);
		// Get hdr
		SoTiepDanService s = new SoTiepDanService();
		KntcSoTiepDan hs = s.getSoTiepDan(appContext, maHs, true);
		KntcHoSoHdr hdr = hs.getHdr();
		Date ngayCongVanDen = hdr.getCongVanDenNgay();
		// ltForm.setNgayCVDen(Formater.date2str(ngayCongVanDen));
		// get de xuat xu ly
		PhanLoaiXuLyService s2 = new PhanLoaiXuLyService();
		KntcDeXuatXly dx = s2.getDeXuatXly(appContext, maHs);
		JSONObject jObject = new JSONObject();
		// Tinh lich trinh cho ho so khieu nai
		if ("1".equals(hdr.getLoaiKntc().toString())) {
			// Khieu nai can xac minh
			if ("0".equals(dx.getIsGquyetNgay().toString())) {
				jObject = createObject(Constants.TH_KHIEU_NAI_XAC_MINH, ngayCongVanDen);
			}
			// Khieu nai giai quyet ngay
			else if ("1".equals(dx.getIsGquyetNgay().toString())) {
				jObject = createObject(Constants.TH_KHIEU_NAI_GQ_NGAY, ngayCongVanDen);
			}
		}
		// Tinh lich trinh cho ho so to cao
		else if ("2".equals(hdr.getLoaiKntc().toString())) {
			jObject = createObject(Constants.TH_TO_CAO, ngayCongVanDen);
		}
		return jObject;
	}

	private JSONObject createObject(String pId, Date ngay) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			conn = DataSourceConfiguration.getConnection();
			StringBuffer sb = new StringBuffer("select a.ma,a.ten,b.thoigian from ktnb_dm a,ktnb_dm_time b where a.parent_id like ? and a.ma=b.pid(+) order by a.ma");
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, pId + "%");
			// System.out.println(sb.toString());
			JSONArray jsonArray = new JSONArray();
			JSONArray ja;
			int rc = 0;
			rs = ps.executeQuery();
			while (rs.next()) {
				ja = new JSONArray();
				ja.put(rs.getString(2));
				ja.put(Formater.date2str(ngay));
				if(rs.getString(3)!=null)
					ngay = KtnbUtil.addBusinessDate(ngay, Integer.parseInt(rs.getString(3)));
				if ("0".equals(rs.getString(3)) || rs.getString(3)==null)
					ja.put("");
				else
					ja.put(rs.getString(3));
				jsonArray.put(ja);
				rc++;
			}
			jsonResult.put("iTotalRecords", new Integer(rc));
			jsonResult.put("aaData", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	public static Date getNgayKetThuc(String maHs, HttpServletRequest request) throws Exception {
		Date ngayKetThuc;
		// Get ma Ho so
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// Get hdr
		SoTiepDanService s = new SoTiepDanService();
		KntcSoTiepDan hs = s.getSoTiepDan(appContext, maHs, true);
		KntcHoSoHdr hdr = hs.getHdr();
		ngayKetThuc = hdr.getCongVanDenNgay();

		PhanLoaiXuLyService s2 = new PhanLoaiXuLyService();
		KntcDeXuatXly dx = s2.getDeXuatXly(appContext, maHs);

		String pId = "";
		if ("1".equals(hdr.getLoaiKntc().toString())) {
			if ("0".equals(dx.getIsGquyetNgay().toString())) {
				pId = Constants.TH_KHIEU_NAI_XAC_MINH;
			} else if ("1".equals(dx.getIsGquyetNgay().toString())) {
				pId = Constants.TH_KHIEU_NAI_GQ_NGAY;
			}
		} else if ("2".equals(hdr.getLoaiKntc().toString())) {
			pId = Constants.TH_TO_CAO;
		}

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			StringBuffer sb = new StringBuffer("select b.thoigian from ktnb_dm a,ktnb_dm_time b where a.parent_id like ? and a.ma=b.pid(+) order by a.ma");
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, pId + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getString(1)!=null)
				ngayKetThuc = KtnbUtil.addBusinessDate(ngayKetThuc, Integer.parseInt(rs.getString(1)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return ngayKetThuc;
	}
}
