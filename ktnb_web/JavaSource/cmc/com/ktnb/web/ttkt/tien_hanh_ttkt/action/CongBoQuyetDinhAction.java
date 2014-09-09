package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThCongBoQd;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.form.ChuanBiTienHanhForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktService;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.CongBoQuyetDinhForm;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */
public class CongBoQuyetDinhAction extends BaseDispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		CongBoQuyetDinhForm congBoQuyetDinhForm = (CongBoQuyetDinhForm) form;
		String cuocTtktId = request.getParameter("cuocTtktId");
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		loadDefaulForm(request, appContext, congBoQuyetDinhForm, cuocTtktId);
		// Danh sach thanh vien doan
		loadDsTvDoan(cuocTtktId, request);
		return mapping.findForward("success");
	}

	/**
	 * @param cuocTtktId
	 * @param request
	 */
	private void loadDsTvDoan(String cuocTtktId, HttpServletRequest request) {
		Collection dsThanhVienDoan = TtktService.getDanhSachThanhVienDoan(cuocTtktId);
		String cbDsThanhVienDoan = "<option value = \"\">"; // Combo danh sach thanh vien doan
		cbDsThanhVienDoan += "</option>";
		String dsIdThanhVienDoan = "";
		String dsChucVuTrongDoan = "";
		Iterator iter = dsThanhVienDoan.iterator();
		while (iter.hasNext()) {
			TtktCbChiTietDsTvDoan thanhVienDoan = (TtktCbChiTietDsTvDoan) iter.next();
			cbDsThanhVienDoan += "<option value = " + thanhVienDoan.getIdCanBo() + ">";
			cbDsThanhVienDoan += thanhVienDoan.getTenCanBo();
			cbDsThanhVienDoan += "</option>";
			dsIdThanhVienDoan += thanhVienDoan.getIdCanBo() + ",";
			dsChucVuTrongDoan += thanhVienDoan.getChucVuTrongDoan() + ",";

		}
		request.setAttribute("cbChiTietDsTvd", cbDsThanhVienDoan);
		request.setAttribute("dsIdThanhVienDoan", dsIdThanhVienDoan.substring(0, dsIdThanhVienDoan.length() - 1));
		request.setAttribute("dsChucVuTrongDoan", dsChucVuTrongDoan.substring(0, dsChucVuTrongDoan.length() - 1));

	}
	/**
	* 
	* @param request
	* @param appConText
	* @param cbForm
	* @throws Exception
	*/
	private void inCbqd(HttpServletRequest request, ApplicationContext appConText, CongBoQuyetDinhForm cbForm, HttpServletResponse reponse, ChuanBiTienHanhForm chbForm) throws Exception {
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		if ("bcks".equals(request.getParameter("type"))) {

		} else if ("cbqd".equals(request.getParameter("type"))) {
			fileTemplate = "ttnb16";
			parameters.put("ten_cqt", appConText.getTenCqt());
			parameters.put("doan_ttkt_so", chbForm.getSoQuyetDinh());
			String loai_nv = (String) request.getParameter("loai_nv");
			String ten_nv = ("0".equals(loai_nv)) ? "THANH TRA" : "KI\u1EC2M TRA";
			parameters.put("ten_bc", "BI\u00CAN B\u1EA2N");
			StringBuffer sb = new StringBuffer("C\u00F4ng b\u1ED1 Quy\u1EBFt \u0111\u1ECBnh ");
			sb.append(ten_nv);
			sb.append(" n\u1ED9i b\u1ED9");
			parameters.put("cong_bo_quyet_dinh", sb.toString());
			//
			sb = new StringBuffer("H\u00F4m nay,");
			sb.append(cbForm.getThoiDiemCbDen());
			sb.append(" t\u1EA1i ");
			sb.append(appConText.getTenPhong());
			sb.append(", \u0111\u1ECBa ch\u1EC9 ");
			sb.append(cbForm.getDiaDiem());
			parameters.put("hom_nay", sb.toString());
			//
			sb = new StringBuffer("\u0110o\u00E0n ");
			sb.append(ten_nv);
			sb.append(" theo quy\u1EBFt \u0111\u1ECBnh s\u1ED1 ");
			sb.append(chbForm.getSoQuyetDinh());
			sb.append(chbForm.getNgayRaQuyetDnh());
			sb.append(" c\u1EE7a ");
			sb.append(appConText.getTenChucvu());
			sb.append(" v\u1EC1 vi\u1EC7c ");
			sb.append(ten_nv);
			sb.append(" n\u1ED9i b\u1ED9 t\u1EA1i ");
			sb.append(appConText.getTenPhong());
			sb.append(" ti\u1EBFn h\u00E0nh c\u00F4ng b\u1ED1 quy\u1EBFt \u0111\u1ECBnh ");
			sb.append(ten_nv);
			parameters.put("doan", sb.toString());
			//I. thanh phan tham du
			//dai dien co quan ban hanh quyet dinh
			sb = new StringBuffer("1. \u0110\u1EA1i di\u1EC7n c\u01A1 quan thu\u1EBF ban h\u00E0nh quy\u1EBFt \u0111\u1ECBnh ");
			sb.append(ten_nv);
			parameters.put("dai_dien_cqt", sb.toString());
			TtktCmThanhPhanThamDu[] daidiencqt = cbForm.getArrDaiDienCqtBanHanhQD();
			if (daidiencqt != null && daidiencqt.length > 0) {
				reportRows = new HashMap[daidiencqt.length];
				for (int i = 0; i < daidiencqt.length; i++) {
					HashMap row = new HashMap();
					row.put("ten_thanh_vien_cqt", daidiencqt[i].getHoTen());
					row.put("chuc_vu_cqt", daidiencqt[i].getChucVu());
				}
			}
			//dai dien co quan quan ly cap tren
			sb = new StringBuffer("2. \u0110\u1EA1i di\u1EC7n c\u01A1 quan qu\u1EA3n l\u00FD c\u1EA5p tr\u00EAn tr\u1EF1c ti\u1EBFp c\u1EE7a \u0111\u01A1n v\u1ECB \u0111\u01B0\u1EE3c ");
			sb.append(ten_nv);
			parameters.put("dai_dien_cq_ql", sb.toString());
			TtktCmThanhPhanThamDu[] daidienql = cbForm.getArrDaiDienCqqlCapTren();
			if (daidienql != null && daidienql.length > 0) {
				reportRows = new HashMap[daidienql.length];
				for (int i = 0; i < daidienql.length; i++) {
					HashMap row = new HashMap();
					row.put("ten_thanh_vien_cq_ql", daidienql[i].getHoTen());
					row.put("chuc_vu_cq_ql", daidienql[i].getChucVu());
				}
			}
			//dai dien doan tkkt
			sb = new StringBuffer("3. \u0110o\u00E0n ");
			sb.append(ten_nv);
			parameters.put("doan_ttkt", sb.toString());
			TtktCmThanhPhanThamDu[] daidiendoanttkt = cbForm.getArrDaiDienDoanTtkt();
			if (daidiendoanttkt != null && daidiendoanttkt.length > 0) {
				reportRows = new HashMap[daidiendoanttkt.length];
				for (int i = 0; i < daidiendoanttkt.length; i++) {
					HashMap row = new HashMap();
					row.put("ten_thanh_vien_ttkt", daidiendoanttkt[i].getHoTen());
					row.put("chuc_vu_ttkt", daidiendoanttkt[i].getChucVu());
				}
			}
			//dai dien don vi duoc ttkt
			sb = new StringBuffer("4. \u0110\u01A1n v\u1ECB \u0111\u01B0\u1EE3c ");
			sb.append(ten_nv);
			parameters.put("don_vi_dc_ttkt", sb.toString());
			TtktCmThanhPhanThamDu[] daidiendv = cbForm.getArrDaiDienDonViDuocTtkt();
			if (daidiendv != null && daidiendv.length > 0) {
				reportRows = new HashMap[daidiendv.length];
				for (int i = 0; i < daidiendv.length; i++) {
					HashMap row = new HashMap();
					row.put("ten_thanh_vien_dv", daidiendv[i].getHoTen());
					row.put("chuc_vu_dv", daidiendv[i].getChucVu());
				}
			}
			//II. noi dung
			sb = new StringBuffer("1. Tr\u01B0\u1EDFng \u0111o\u00E0n ");
			sb.append(ten_nv);
			sb.append(" \u0111\u1ECDc to\u00E0n v\u0103n Quy\u1EBFt \u0111\u1ECBnh ");
			sb.append(ten_nv);
			sb.append(" s\u1ED1 ");
			sb.append(chbForm.getSoQuyetDinh());
			sb.append(chbForm.getNgayRaQuyetDnh());
			sb.append(" c\u1EE7a ");
			sb.append(appConText.getTenChucvu());
			sb.append(" v\u1EC1 vi\u1EC7c ");
			sb.append(ten_nv);
			sb.append(" n\u1ED9i b\u1ED9 t\u1EA1i ");
			sb.append(appConText.getTenPhong());
			sb.append(" v\u00E0 ph\u1ED5 bi\u1EBFn t\u00F3m t\u1EAFt m\u1EE5c \u0111\u00EDch, y\u00EAu c\u1EA7u, n\u1ED9i dung k\u1EBF ho\u1EA1ch ");
			sb.append(ten_nv);
			sb.append(", nhi\u1EC7m v\u1EE5, quy\u1EC1n h\u1EA1n c\u1EE7a Tr\u01B0\u1EDFng \u0111o\u00E0 ");
			sb.append(ten_nv);
			sb.append(", th\u00E0nh vi\u00EAn \u0110o\u00E0n ");
			sb.append(ten_nv);
			sb.append(", quy\u1EC1n v\u00E0 ngh\u0129a v\u1EE5 c\u1EE7a \u0111\u1ED1i t\u01B0\u1EE3ng \u0111\u01B0\u1EE3c ");
			sb.append(ten_nv);
			sb.append("; th\u1ED1ng nh\u1EA5t l\u1ECBch thanh tra, ki\u1EC3m tra \u0111\u1ED1i v\u1EDBi \u0111\u01A1n v\u1ECB, c\u00E1 nh\u00E2n thu\u1ED9c c\u01A1 quan l\u00E0 \u0111\u1ED1i t\u01B0\u1EE3ng ");
			sb.append(ten_nv);
			parameters.put("noi_dung1", sb.toString());
			//
			sb = new StringBuffer("2. ");
			sb.append(cbForm.getYkienPhatBieu());
			sb.append(" Vi\u1EC7c c\u00F4ng b\u1ED1 Quy\u1EBFt \u0111\u1ECBnh ");
			sb.append(ten_nv);
			sb.append(" k\u1EBFt th\u00FAc v\u00E0o ");
			sb.append(cbForm.getThoiDiemCbDen());
			sb.append(" Bi\u00EAn b\u1EA3n c\u00F4ng b\u1ED1 quy\u1EBFt \u0111\u1ECBnh ");
			sb.append(ten_nv);
			sb.append(" \u0111\u00E3 \u0111\u01B0\u1EE3c \u0111\u1ECDc l\u1EA1i cho nh\u1EEFng ng\u01B0\u1EDDi c\u00F3 t\u00EAn n\u00EAu tr\u00EAn nghe v\u00E0 k\u00FD x\u00E1c nh\u1EADn gi\u1EEFa \u0110o\u00E0n ");
			sb.append(ten_nv);
			sb.append(" v\u1EDBi \u0111\u01A1n v\u1ECB \u0111\u01B0\u1EE3c thanh tra, ki\u1EC3m tra./.");
		}
		if (Formater.isNull(fileTemplate))
				throw new Exception("Chua chon file template");

			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + fileTemplate + ".jasper");
			KtnbUtil.printf(reportRows, fileTemplate, reponse, inputStream, parameters, null);
	}

	/**
	 * @param request
	 * @param appContext
	 * @param congBoQuyetDinhForm
	 * @param cuocTtktId
	 */
	private void loadDefaulForm(HttpServletRequest request, ApplicationContext appContext, CongBoQuyetDinhForm congBoQuyetDinhForm, String cuocTtktId) throws Exception {
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, cuocTtktId);
		congBoQuyetDinhForm.setIdDonViDuocTtkt(cuocTtkt.getIdDonViBi());
		congBoQuyetDinhForm.setIdDonViTienHanh(cuocTtkt.getIdDonViTh());
		congBoQuyetDinhForm.setDiaDiem(appContext.getDiaBan());
		TtktThCongBoQd congBoQd = TtktService.getCongBoQd(appContext, cuocTtktId);
		if (congBoQd != null) {
			congBoQuyetDinhForm.setDiaDiem(congBoQd.getDiaDiem());
			congBoQuyetDinhForm.setIdCongBoQuyetDinh(congBoQd.getId());
			congBoQuyetDinhForm.setIdCuocTtkt(congBoQd.getIdCuocTtkt());
			congBoQuyetDinhForm.setIdDaiDienCqBanHanhQd(congBoQd.getIdDaiDienCqBanHanhQd());
			congBoQuyetDinhForm.setIdDaiDienCqqlCapTren(congBoQd.getIdDaiDienCqqlCapTren());
			congBoQuyetDinhForm.setIdDaiDienDoanTtkt(congBoQd.getIdDaiDienDoanTtkt());
			congBoQuyetDinhForm.setIdDaiDienDonViDuocTtkt(congBoQd.getIdDaiDienDonViDuocTtkt());
			congBoQuyetDinhForm.setThoiDiemCbTu(Formater.date2str(congBoQd.getThoiDiemCbTu()));
			congBoQuyetDinhForm.setThoiDiemCbDen(Formater.date2str(congBoQd.getThoiDiemCbDen()));
			congBoQuyetDinhForm.setYkienPhatBieu(congBoQd.getYkienPhatBieu());

			// Dai dien cqql cap tren
			ArrayList list = (ArrayList) congBoQd.getDsDaiDienCqqlCapTren();
			if (!Formater.isNull(list)) {
				TtktCmThanhPhanThamDu[] arrDaiDienCqqlCapTren = new TtktCmThanhPhanThamDu[list.size()];
				for (int i = 0; i < list.size(); i++)
					arrDaiDienCqqlCapTren[i] = (TtktCmThanhPhanThamDu) list.get(i);
			}

			// Dai dien cqql cap tren
			list = (ArrayList) congBoQd.getDsDaiDienCqtBanHanhQD();
			if (!Formater.isNull(list)) {
				TtktCmThanhPhanThamDu[] arrDaiDienCqtBanHanhQD = new TtktCmThanhPhanThamDu[list.size()];
				for (int i = 0; i < list.size(); i++)
					arrDaiDienCqtBanHanhQD[i] = (TtktCmThanhPhanThamDu) list.get(i);
			}

			// Dai dien doan ttkt
			list = (ArrayList) congBoQd.getDsDaiDienDoanTtkt();
			if (!Formater.isNull(list)) {
				TtktCmThanhPhanThamDu[] arrDaiDienDoanTtkt = new TtktCmThanhPhanThamDu[list.size()];
				for (int i = 0; i < list.size(); i++)
					arrDaiDienDoanTtkt[i] = (TtktCmThanhPhanThamDu) list.get(i);
			}
			// Dai dien doan ttkt
			list = (ArrayList) congBoQd.getDsDaiDienDonViDuocTtkt();
			if (!Formater.isNull(list)) {
				TtktCmThanhPhanThamDu[] arrDaiDienDonViDuocTtkt = new TtktCmThanhPhanThamDu[list.size()];
				for (int i = 0; i < list.size(); i++)
					arrDaiDienDonViDuocTtkt[i] = (TtktCmThanhPhanThamDu) list.get(i);
			}

		}

	}

}
