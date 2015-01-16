package cmc.com.ktnb.web.ttkt.ket_thuc_ttkt.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jacob.com.Dispatch;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmBienBan;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;

import cmc.com.ktnb.web.ttkt.dung_chung.form.BienBanLamViecForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;

/**
 * @version 1.0
 * @author
 */
public class BienBanLamViecAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		BienBanLamViecForm bienBanLamViecForm = (BienBanLamViecForm) form;
		ApplicationContext app = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String method = request.getParameter("method");
		String cuocTtktId = request.getParameter("idCuocTtkt");
		String type = request.getParameter("type");
		if (cuocTtktId == null) {
			cuocTtktId = bienBanLamViecForm.getIdCuocTtKt();
		}

		loadDsTvDoan(cuocTtktId, request);

		if ("save".equals(method)) {
			try {
				saveBienBan(app, bienBanLamViecForm);
				request.setAttribute("save", "ok");
			} catch (Exception err) {
				throw err;
			}

		} else if ("in".equals(method)) {
			inYeuCauGT(request, response, bienBanLamViecForm, app, cuocTtktId);
			return null;
		} else {
			loadDefaulForm(bienBanLamViecForm, app, cuocTtktId, type);
			if (!KtnbUtil.haveRoleNv(app) || app.getTrangThaiCuocTtkt(bienBanLamViecForm.getIdCuocTtKt()).equals(Constants.TT_TTKT_KT))
				request.setAttribute("readOnly", "true");
		}

		return mapping.findForward("success");
	}

	private void loadDsTvDoan(String cuocTtktId, HttpServletRequest request) {
		Collection dsThanhVienDoan = TtktService.getDanhSachThanhVienDoan(cuocTtktId);
		String cbDsThanhVienDoan = "<option value = \"\">";// Combo danh sach
		// thanh vien doan
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
		request.setAttribute("dsIdThanhVienDoan", dsIdThanhVienDoan.substring(0, dsIdThanhVienDoan.length()));
		request.setAttribute("dsChucVuTrongDoan", dsChucVuTrongDoan.substring(0, dsChucVuTrongDoan.length()));
		request.setAttribute("chiTietDsTvd", dsThanhVienDoan);
	}

	private void loadDefaulForm(BienBanLamViecForm form, ApplicationContext appContext, String cuocTtktId, String type) throws Exception {

		TtktCmBienBan bienban = null;
		if (type != null) {
			if (type.equals("tochucthongqua")) {
				bienban = TtktCnPhuService.getBienBanLamViec(appContext, cuocTtktId, Constants.TTKT_BB_TCTQ);
			} else if (type.equals("chamthongqua")) {
				bienban = TtktCnPhuService.getBienBanLamViec(appContext, cuocTtktId, Constants.TTKT_BB_CTQ);
			} else if (type.equals("thongbaokethtuc")) {
				bienban = TtktCnPhuService.getBienBanLamViec(appContext, cuocTtktId, Constants.TTKT_BB_TBKT);
			}
		} else
			bienban = TtktCnPhuService.getBienBanLamViec(appContext, cuocTtktId, form.getLoaiBB());

		if (bienban != null) {
			form.setId(bienban.getId());
			form.setIdCuocTtKt(bienban.getIdCuocTtkt());
			form.setIdDoanTtKt(bienban.getTpThamDuDoanTtkt());
			form.setIdThanhphanKhac(bienban.getTpThamDuKhac());
			// form.setThoiGian(Formater.date2str(bienban.getThoiDiemBatDau()));
			form.setThoiDiemBatDau(Formater.date2strDateTimeForNV(bienban.getThoiDiemBatDau()));
			form.setDiaDiem(bienban.getDiaDiem());
			form.setNoiDungLamViec(bienban.getNoiDung());
			form.setKetQua(bienban.getDienBienKetQua());
			form.setThoiDiemKetThuc(Formater.date2strDateTimeForNV(bienban.getThoiDiemKetThuc()));
			form.setLamViecVoi(bienban.getLamViecVoi());
			form.setLoaiBB(bienban.getLoai());

			// co quan lien quan
			ArrayList list = (ArrayList) bienban.getThanhPhanThamDu();
			if (!Formater.isNull(list)) {
				TtktCmThanhPhanThamDu[] arrDaiDienCqqlCapTren = new TtktCmThanhPhanThamDu[list.size()];
				for (int i = 0; i < list.size(); i++)
					arrDaiDienCqqlCapTren[i] = (TtktCmThanhPhanThamDu) list.get(i);
				form.setDsThanhPhanKhac(arrDaiDienCqqlCapTren);
			}

			// dai dien doan thanh tra kiem tra
			list = (ArrayList) bienban.getDoanTtKt();
			if (!Formater.isNull(list)) {
				TtktCmThanhPhanThamDu[] arrDaiDienCqqlCapTren = new TtktCmThanhPhanThamDu[list.size()];
				for (int i = 0; i < list.size(); i++)
					arrDaiDienCqqlCapTren[i] = (TtktCmThanhPhanThamDu) list.get(i);
				form.setDsDoanTtKt(arrDaiDienCqqlCapTren);
			}
		}

		else {
			form.setIdCuocTtKt(cuocTtktId);
			if (type.equals("tochucthongqua")) {
				form.setLoaiBB(Constants.TTKT_BB_TCTQ);
			} else if (type.equals("chamthongqua")) {
				form.setLoaiBB(Constants.TTKT_BB_CTQ);
			} else if (type.equals("thongbaokethtuc")) {
				form.setLoaiBB(Constants.TTKT_BB_TBKT);
			}
			form.setDiaDiem(appContext.getDiaBan());
		}
	}

	private void saveBienBan(ApplicationContext appContext, BienBanLamViecForm form) throws Exception {
		TtktCmBienBan bienban = createBienBan(appContext, form);
		TtktCnPhuService.saveBienBanLamViec(bienban, appContext);

	}

	private TtktCmBienBan createBienBan(ApplicationContext appContext, BienBanLamViecForm form) throws Exception {
		TtktCmBienBan bienban = new TtktCmBienBan();
		bienban.setId(form.getId());
		bienban.setIdCuocTtkt(form.getIdCuocTtKt());
		bienban.setTpThamDuDoanTtkt(form.getIdDoanTtKt());
		bienban.setTpThamDuKhac(form.getIdThanhphanKhac());
		// bienban.setThoiDiemBatDau(Formater.str2date(form.getThoiGian()));
		bienban.setThoiDiemBatDau(Formater.str2dateForNV(form.getThoiDiemBatDau()));
		bienban.setThoiDiemKetThuc(Formater.str2dateForNV(form.getThoiDiemKetThuc()));
		bienban.setDienBienKetQua(form.getKetQua());
		bienban.setNoiDung(form.getNoiDungLamViec());
		bienban.setLamViecVoi(form.getLamViecVoi());
		bienban.setDiaDiem(form.getDiaDiem());
		bienban.setLoai(form.getLoaiBB());
		bienban.setIdNguoiCapNat(appContext.getMaCanbo());
		bienban.setTenNguoiCapNhat(appContext.getTenCanbo());
		bienban.setNgayCapNhat(new Date());
		// Dai dien doan thanh tra kiem tra
		TtktCmThanhPhanThamDu[] arrDaiDienCqQlCapTren = form.getDsDoanTtKt();
		if (arrDaiDienCqQlCapTren != null && arrDaiDienCqQlCapTren.length > 0) {
			ArrayList dsDaiDienCqQlCapTren = new ArrayList();
			for (int i = 0; i < arrDaiDienCqQlCapTren.length; i++)
				dsDaiDienCqQlCapTren.add(arrDaiDienCqQlCapTren[i]);
			bienban.setDoanTtKt(dsDaiDienCqQlCapTren);
		}
		// dai dien co quan khac
		TtktCmThanhPhanThamDu[] arrDaiDienCq = form.getDsThanhPhanKhac();
		if (arrDaiDienCq != null && arrDaiDienCq.length > 0) {
			ArrayList dsDaiDienCq = new ArrayList();
			for (int i = 0; i < arrDaiDienCq.length; i++)
				dsDaiDienCq.add(arrDaiDienCq[i]);
			bienban.setThanhPhanThamDu(dsDaiDienCq);
		}
		bienban.setIdNguoiCapNat(appContext.getMaCanbo());
		bienban.setTenNguoiCapNhat(appContext.getTenCanbo());
		bienban.setNgayCapNhat(new Date());
		return bienban;

	}
	
	/**
	 * Des : ktnb v3
	 * */
	private void inYeuCauGTv3(HttpServletRequest request, HttpServletResponse reponse, BienBanLamViecForm form, ApplicationContext app, String idCuocTtKt) throws Exception {
		String fileIn = null;
		String fileOut = null;

		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		StringBuffer defaultPrint = new StringBuffer("\u00D4ng (B\u00E0)................             Ch\u1EE9c v\u1EE5:...............");
		defaultPrint.append("\n\u00D4ng (B\u00E0)................             Ch\u1EE9c v\u1EE5:...............");
		defaultPrint.append("\n......................................................................................");
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, idCuocTtKt);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		String hinhThuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtKt, app);
		StringBuffer sb = new StringBuffer(hinhThuc);
		sb = new StringBuffer("\u0110o\u00E0n ");
		sb.append(hinhThuc_inT);
		sb.append(" s\u1ED1");
		if (Formater.isNull(cbQd.getSoQuyetDinh())) {
			sb.append("......");
		} else {
			sb.append(" " + "Q\u0110" + cbQd.getSoQuyetDinh());
		}
		if ("inBienBan".equals(type)) {
			// in quyet dinh niem phong
			fileIn = request.getRealPath("/docin") + "\\TTNB30.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB30_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			fileTemplate = "ttnb30";

			MsWordUtils word = new MsWordUtils(fileIn, fileOut);
			try {
				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(app).toUpperCase());
				word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
				// parameters.put("ten_bc", "Th\u00F4ng b\u00E1o k\u1EBFt
				// th\u00FAc");
				word.put("[ten_bc]", "BI\u00CAN B\u1EA2N L\u00C0M VI\u1EC6C");
				word.put("[thoi_gian]", KtnbUtil.getHour(form.getThoiDiemBatDau()));
				word.put("[dia_diem]", form.getDiaDiem());
				word.put("[ttkt]", hinhThuc);
				word.put("[lam_viec_voi]", form.getLamViecVoi());
				word.put("[noi_dung]", form.getNoiDungLamViec());
				word.put("[ttkt]", hinhThuc);
				// ----------------------------danh sach thanh vien ttkt
				// ---------------------------------//
				// khoi tao table trong Msword
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrthanhphanbg = form.getDsDoanTtKt();
				StringBuffer tptd = new StringBuffer("");
				if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
					for (int i = 0; i < arrthanhphanbg.length; i++) {
						tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg[i].getHoTen()));
						tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg[i].getChucVu()));
						tptd.append("\n");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrthanhphanbg[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbg[i].getChucVu());
						word.addRowTable(table, arrthanhphanbg.length);
					}
					System.out.println(tptd.toString());
					// word.put("[thanh_vien_ttkt]",
					// tptd.toString().substring(0, tptd.length()-1));
				}
				// else{
				// word.put("[thanh_vien_ttkt]", defaultPrint.toString());
				// }
				word.put("[ttkt]", hinhThuc);
				// ----------------------------danh sach thanh phan tham du
				// ---------------------------------//
				// khoi tao table trong Msword
				table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arr = form.getDsThanhPhanKhac();
				StringBuffer tptd1 = new StringBuffer("");
				if (arr != null && arr.length > 0) {
					for (int i = 0; i < arr.length; i++) {
						tptd1.append(KtnbUtil.layoutTableHoTen(arr[i].getHoTen()));
						tptd1.append(KtnbUtil.layoutTableChucVu(arr[i].getChucVu()));
						tptd1.append("\n");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arr[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arr[i].getChucVu());
						word.addRowTable(table, arr.length);
					}
					System.out.println(tptd1.toString());
					// word.put("[thanh_vien_tc]", tptd1.toString().substring(0,
					// tptd1.length()-1));
				}
				// else{
				// word.put("[thanh_vien_tc]", defaultPrint.toString());
				// }
				word.put("[dien_bien]", form.getKetQua());
				word.put("[ket_thuc]", KtnbUtil.getHour(form.getThoiDiemKetThuc()));
				word
						.put("[doc_bien_ban]",
								"Bi\u00EAn b\u1EA3n \u0111\u00E3 \u0111\u01B0\u1EE3c \u0111\u1ECDc l\u1EA1i cho nh\u1EEFng ng\u01B0\u1EDDi c\u00F3 t\u00EAn n\u00EAu tr\u00EAn nghe v\u00E0 k\u00FD x\u00E1c nh\u1EADn./.");
				word.put("[ttkt]", hinhThuc.toUpperCase());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB30", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {
				try {
					word.saveAndClose();
				} catch (Exception e) {

				}
			}

		}
	}
	
	/**
	 * Edit : ntmanh
	 * Method : inYeuCauGT
	 * Des : ktnb v4
	 * */
	private void inYeuCauGT(HttpServletRequest request, HttpServletResponse reponse, BienBanLamViecForm form, ApplicationContext app, String idCuocTtKt) throws Exception {
		System.out.println("This is KTNBv4");
		String fileIn = null;
		String fileOut = null;

		String type = request.getParameter("type");
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		StringBuffer defaultPrint = new StringBuffer("\u00D4ng (B\u00E0)................             Ch\u1EE9c v\u1EE5:...............");
		defaultPrint.append("\n\u00D4ng (B\u00E0)................             Ch\u1EE9c v\u1EE5:...............");
		defaultPrint.append("\n......................................................................................");
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(app, idCuocTtKt);
		String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
		String hinhThuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
		TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtKt, app);
		StringBuffer sb = new StringBuffer(hinhThuc);
		sb = new StringBuffer("\u0110o\u00E0n ");
		sb.append(hinhThuc_inT);
		sb.append(" s\u1ED1");
		if (Formater.isNull(cbQd.getSoQuyetDinh())) {
			sb.append("......");
		} else {
			sb.append(" " + "Q\u0110" + cbQd.getSoQuyetDinh());
		}
		if ("inBienBan".equals(type)) {
			// in quyet dinh niem phong
			fileIn = request.getRealPath("/docin/v4") + "\\TTNB29.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB29_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			fileTemplate = "ttnb29";

			MsWordUtils word = new MsWordUtils(fileIn, fileOut);
			try {
				word.put("[ten_cqt]", KtnbUtil.getTenCqtCapTrenTt(app).toUpperCase());
				word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
				// parameters.put("ten_bc", "Th\u00F4ng b\u00E1o k\u1EBFt
				// th\u00FAc");
				word.put("[ten_bc]", "BI\u00CAN B\u1EA2N L\u00C0M VI\u1EC6C");
				word.put("[thoi_gian]", KtnbUtil.getHour(form.getThoiDiemBatDau()));
				word.put("[dia_diem]", form.getDiaDiem());
				//word.put("[ttkt]", hinhThuc);
				word.put("[lam_viec_voi]", form.getLamViecVoi());
				word.put("[noi_dung]", form.getNoiDungLamViec());
				//word.put("[ttkt]", hinhThuc);
				// ----------------------------danh sach thanh vien ttkt
				// ---------------------------------//
				// khoi tao table trong Msword
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrthanhphanbg = form.getDsDoanTtKt();
				StringBuffer tptd = new StringBuffer("");
				if (arrthanhphanbg != null && arrthanhphanbg.length > 0) {
					for (int i = 0; i < arrthanhphanbg.length; i++) {
						tptd.append(KtnbUtil.layoutTableHoTen(arrthanhphanbg[i].getHoTen()));
						tptd.append(KtnbUtil.layoutTableChucVu(arrthanhphanbg[i].getChucVu()));
						tptd.append("\n");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrthanhphanbg[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphanbg[i].getChucVu());
						word.addRowTable(table, arrthanhphanbg.length);
					}
					System.out.println(tptd.toString());
					// word.put("[thanh_vien_ttkt]",
					// tptd.toString().substring(0, tptd.length()-1));
				}
				// else{
				// word.put("[thanh_vien_ttkt]", defaultPrint.toString());
				// }
				//word.put("[ttkt]", hinhThuc);
				// ----------------------------danh sach thanh phan tham du
				// ---------------------------------//
				// khoi tao table trong Msword
				table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arr = form.getDsThanhPhanKhac();
				StringBuffer tptd1 = new StringBuffer("");
				if (arr != null && arr.length > 0) {
					for (int i = 0; i < arr.length; i++) {
						tptd1.append(KtnbUtil.layoutTableHoTen(arr[i].getHoTen()));
						tptd1.append(KtnbUtil.layoutTableChucVu(arr[i].getChucVu()));
						tptd1.append("\n");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arr[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arr[i].getChucVu());
						word.addRowTable(table, arr.length);
					}
					System.out.println(tptd1.toString());
					// word.put("[thanh_vien_tc]", tptd1.toString().substring(0,
					// tptd1.length()-1));
				}
				// else{
				// word.put("[thanh_vien_tc]", defaultPrint.toString());
				// }
				word.put("[dien_bien]", form.getKetQua());
				word.put("[ket_thuc]", KtnbUtil.getHour(form.getThoiDiemKetThuc()));
				word
						.put("[doc_bien_ban]",
								"Bi\u00EAn b\u1EA3n \u0111\u00E3 \u0111\u01B0\u1EE3c \u0111\u1ECDc l\u1EA1i cho nh\u1EEFng ng\u01B0\u1EDDi c\u00F3 t\u00EAn n\u00EAu tr\u00EAn nghe v\u00E0 k\u00FD x\u00E1c nh\u1EADn./.");
				word.put("[ttkt]", hinhThuc.toUpperCase());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB29", ".doc", reponse);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {
				try {
					word.saveAndClose();
				} catch (Exception e) {

				}
			}

		}
	}

}
