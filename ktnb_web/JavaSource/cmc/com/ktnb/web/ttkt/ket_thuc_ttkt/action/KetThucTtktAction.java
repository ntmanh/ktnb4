package cmc.com.ktnb.web.ttkt.ket_thuc_ttkt.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmBienBan;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmNhanTraHstl;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.ket_thuc_ttkt.TtktKtBcKqThucHienKL;
import cmc.com.ktnb.entity.TTKT.ket_thuc_ttkt.TtktKtChuyenDlieuSangBc;
import cmc.com.ktnb.entity.TTKT.ket_thuc_ttkt.TtktKtKetLuanChuyenBC;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBbChitietvatonghop;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThCongBoQd;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThGiaHan;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbCache;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.ket_thuc_ttkt.form.KetThucTtktForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;

import com.jacob.com.Dispatch;

/**
 * Form bean for a Struts application.
 * 
 * @version 1.0
 * @author
 */
public class KetThucTtktAction extends BaseDispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		KetThucTtktForm ketThucTtktForm = (KetThucTtktForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String method = request.getParameter("method");
		if ("save".equals(method)) {
			this.saveKetThucTtkt(appContext, ketThucTtktForm, request, reponse);
			return null;
		} else if ("in".equals(method)) {
			this.inKetThucTtkt(appContext, ketThucTtktForm, request, reponse);
			return null;
		} else {
			String cuocTtktId = request.getParameter("cuocTtktId");
			try {
				request.setAttribute("maCqtBi", CuocTtktService.getCuocTtkt(appContext, cuocTtktId).getIdDonViBi());
				request.setAttribute("maCqtTh", appContext.getMaCqt());
			} catch (Exception e) {
				// TODO: handle exception
			}
			this.loadDefault(appContext, ketThucTtktForm, cuocTtktId, request, reponse);
			this.loadDsTvDoan(cuocTtktId, request);
		}
		return mapping.findForward("success");
	}

	/**
	 * Download file mau TTNB35,TTNB14,TTNB18
	 * 
	 * @throws Exception
	 */

	/**
	 * Des : ktnb v3
	 * */
	
	private void inKetThucTtktv3(ApplicationContext appContext, KetThucTtktForm ketThucTtktForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;
		String type = request.getParameter("type");
		if ("downloadMau37".equals(type)) {
			fileIn = request.getRealPath("/docin") + "\\TTNB37.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB37_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			String idCuocTtkt = ketThucTtktForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);

			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";

			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appContext);

			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
				StringBuffer sb = new StringBuffer("\u0110O\u00C0N ");
				sb.append(hinhthuc_in);
				sb.append(" Q\u0110 S\u1ED0 ");
				sb.append(cbQd.getSoQuyetDinh());
				word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
				word.put("[noi_lap]", ".....");
				word.put("[ngay_lap]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[chuc_danh_nguoi_ra_qd_ttkt]", "..........");
				word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				String ngayqd = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				word.put("[ngay_qd]", Formater.getDateForPrint(ngayqd));
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				for (int i = 0; i < 4; i++)
					word.put("[ttkt]", hinhThuc);
				word.put("[ten_dv_da_lam_viec]", "..........");
				word.put("[ten_dv_da_kt_xacminh]", "..........");
				for (int i = 0; i < 13; i++)
					word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", hinhThuc);
				word.put("[chuc_danh_nguoi_ra_qd_ttkt]", "..........");
				word.put("[ttkt]", hinhThuc.toUpperCase());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());

				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB37", ".doc", response);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {
				try {
					word.saveAndClose();
				} catch (Exception e) {

				}
			}
		} else if ("downloadMau38".equals(type)) {
			fileIn = request.getRealPath("/docin") + "\\TTNB38.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB38_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			String idCuocTtkt = ketThucTtktForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);

			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appContext);

			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
				word.put("[cqt_ra_ket_luan]", "T\u00CAN C\u01A0 QUAN THU\u1EBE RA Q\u0110");
				word.put("[ten_viet_tat_cqt]", "...../KL-.........");
				word.put("[noi_lap]", ".....");
				word.put("[ngay_lap]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				word.put("[ttkt]", hinhThuc.toUpperCase());
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				String ngayqd = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				word.put("[ngay_qd]", Formater.getDateForPrint(ngayqd));
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
				word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc);
				word.put("[ten_cqt_dua_ra_ket_luan]", "..........");
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				for (int i = 0; i < 5; i++)
					word.put("[ttkt]", hinhThuc);
				word.put("[ten_cqt]", appContext.getTenCqt());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", hinhThuc);
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
				//word.put("[ten_thu_truong_cqt]", appContext.getTenThuTruong());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB38", ".doc", response);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {
				try {
					word.saveAndClose();
				} catch (Exception e) {

				}
			}
		} else if ("thongBaoKetThuc".equals(type)) { // thong bao ket thuc
			// (ngon,chuan)
			fileIn = request.getRealPath("/docin") + "\\TTNB35.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB35_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			// Loc sua lai sau
			String idCuocTtkt = ketThucTtktForm.getIdCuocTtkt();

			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);

			KtnbUtil.getChucVuThuTruongByMaCqt(cuocTtkt.getIdDonViBi());
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";

			StringBuffer sb = new StringBuffer("\u0110O\u00C0N ");
			sb.append(hinhthuc_in);
			sb.append(" Q\u0110 S\u1ED0 ");
			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appContext);
			TtktThCongBoQd cbKl = TtktService.getCongBoQd(appContext, cuocTtkt.getId());
			sb.append(cbQd.getSoQuyetDinh());

			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
				word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
				String ngaythongbao = ketThucTtktForm.getNgayRaThongBaoKetThuc();
				String[] arrngaythongbao = ngaythongbao.split("/");
				if (ketThucTtktForm.getNoiRaThongBaoKetThuc().equals("") || ketThucTtktForm.getNgayRaThongBaoKetThuc().equals("")) {
					word.put("[noi_ra_thong_bao]", ".....");
					word.put("[ngay_thong_bao]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else {
					word.put("[noi_ra_thong_bao]", ketThucTtktForm.getNoiRaThongBaoKetThuc());
					word.put("[ngay_thong_bao]", "Ng\u00E0y " + arrngaythongbao[0] + " th\u00E1ng " + arrngaythongbao[1] + " n\u0103m " + arrngaythongbao[2]);
				}
				word.put("[ten_bc]", "TH\u00D4NG B\u00C1O");
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				// ngay ra qd
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqt(appContext));
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc);
				// thanh tra, kiem tra tu ngay
				word.put("[ngay_ttkt]", Formater.getDateForPrint(Formater.date2str(cbKl.getThoiDiemCbTu())));
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc);
				// ngay ket thuc
				word.put("[thong_bao_ket_thuc]", Formater.getDateForPrint(ketThucTtktForm.getNgayKetThuc()));
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());

				word.put("[ttkt]", hinhThuc.toUpperCase());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				// sb = new StringBuffer("V\u1EC1 vi\u1EC7c k\u1EBFt th\u00FAc
				// ");
				// sb.append(hinhThuc);
				// word.put("[thong_bao]", sb.toString());
				// word.put("[kinh_gui]", appContext.getTenCqtTat());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB35", ".doc", response);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {
				try {
					word.saveAndClose();
				} catch (Exception e) {

				}
			}

			// hop rut kinh nghiem doan (ngon, chuan)
		} else if ("hopRutKinhNghiemDoan".equals(type)) {
			fileIn = request.getRealPath("/docin") + "\\TTNB14.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB14_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			// Loc sua lai sau
			String idCuocTtkt = ketThucTtktForm.getIdCuocTtkt();

			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);

			KtnbUtil.getChucVuThuTruongByMaCqt(cuocTtkt.getIdDonViBi());
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";

			StringBuffer sb = new StringBuffer("\u0110O\u00C0N ");
			sb.append(hinhthuc_in);
			sb.append(" Q\u0110 S\u1ED0 ");
			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appContext);
			sb.append(cbQd.getSoQuyetDinh());

			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
				word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
				word.put("[ten_bc]", "BI\u00CAN B\u1EA2N");
				word.put("[ttkt]", hinhThuc.toUpperCase());
				word.put("[thoi_diem_bat_dau]", KtnbUtil.getHour(ketThucTtktForm.getThoiDiemBatDauHopRutKinhNghiem()));
				word.put("[dia_diem]", ketThucTtktForm.getDiaDiemHopRutKinhNghiem());
				word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc);
				word.put("[noi_dung_tom_tat]", ketThucTtktForm.getVeViecHopRutKinhNghiem());
				// thanh phan tham du
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrthanhphantd = ketThucTtktForm.getThanhPhanThamDuHopRutKinhNghiem();
				StringBuffer tptd = new StringBuffer("");
				int j = 0; // dem so luong thanh vien doan , bo qua truong doan
				// ttkt
				if (arrthanhphantd != null && arrthanhphantd.length > 0) {
					for (int i = 0; i < arrthanhphantd.length; i++) {
						if (!cuocTtkt.getTenTruongDoan().equals(arrthanhphantd[i].getHoTen())) {
							tptd.append((j + 1) + ". " + arrthanhphantd[i].getHoTen() + "\n");// in
							// danh
							// sach
							// thanh
							// vien
							// ki
							// duyet
							j++;
						}
						String tenTv = (i + 1) + "." + " \u00D4ng(b\u00E0): " + arrthanhphantd[i].getHoTen();
						String chucvu = "- Ch\u1EE9c v\u1EE5: " + arrthanhphantd[i].getChucVu();
						word.addCellTable(table, i + 1, 1, (i + 1) + "." + " \u00D4ng(b\u00E0): " + arrthanhphantd[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphantd[i].getChucVu());
						word.addRowTable(table, arrthanhphantd.length);
					}
					System.out.println(tptd.toString());
					// word.put("thanh_vien", tptd.toString());
				}
				//
				word.put("[noi_dung]", ketThucTtktForm.getNoiDungHopRutKinhNghiem());
				word.put("[thoi_gian_ket_thuc]", KtnbUtil.getHour(ketThucTtktForm.getThoiDiemKetThucHopRutKinhNghiem()));
				word.put("[ttkt]", hinhThuc.toUpperCase());
				word.put("[ttkt]", hinhThuc.toUpperCase());
				if (tptd.toString().length() == 0)
					word.put("[ds_thanh_vien]", "");
				else
					word.put("[ds_thanh_vien]", tptd.toString());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB14", ".doc", response);
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {
				try {
					word.saveAndClose();
				} catch (Exception e) {

				}
			}

			// ban giao hs (xem lai)
		} else if ("banGiaoHoSoLuuTru".equals(type)) {
			fileIn = request.getRealPath("/docin") + "\\TTNB18.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB18_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			String idCuocTtkt = ketThucTtktForm.getIdCuocTtkt();

			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);

			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appContext);
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";

			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
				StringBuffer sb = new StringBuffer("\u0110O\u00C0N ");
				sb.append(hinhthuc_in);
				sb.append(" Q\u0110 S\u1ED0 ");
				sb.append(cbQd.getSoQuyetDinh());
				word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
				word.put("[ten_bc]", "BI\u00CAN B\u1EA2N");
				word.put("[thoi_diem_bat_dau]", KtnbUtil.getHour(ketThucTtktForm.getThoiDiemBatDauBanGianHoSoLuuTru()));
				word.put("[dia_diem]", ketThucTtktForm.getDiaDiemBanGiaoHoSoLuuTru());
				word.put("[ttkt]", hinhThuc);
				word.put("[so_quyet_dinh]", cbQd.getSoQuyetDinh());
				String ngayqd = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				String[] arrngayquyet = ngayqd.split("/");
				word.put("[ngay_quyet]", "ng\u00E0y " + arrngayquyet[0] + " th\u00E1ng " + arrngayquyet[1] + " n\u0103m " + arrngayquyet[2]);
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getTenThuTruongCqt(appContext));
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());

				// dai dien ben giao
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrbengiao = ketThucTtktForm.getArrDaiDienBenGiaoHstlLuuTru();
				StringBuffer bengiao = new StringBuffer("");
				String nguoiGiao = "";
				if (arrbengiao != null && arrbengiao.length > 0) {
					for (int i = 0; i < arrbengiao.length; i++) {
						bengiao.append("- \u00D4ng(b\u00E0): " + arrbengiao[i].getHoTen());
						bengiao.append("   - Ch\u1EE9c v\u1EE5: " + arrbengiao[i].getChucVu());
						bengiao.append("\n");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrbengiao[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrbengiao[i].getChucVu());
						word.addRowTable(table, arrbengiao.length);
						nguoiGiao = arrbengiao[i].getHoTen();
					}
				}
				// dai dien ben nhan
				table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arrbennhan = ketThucTtktForm.getArrDaiDienBenNhanHstlLuuTru();
				StringBuffer bennhan = new StringBuffer("");
				String nguoiNhan = "";
				if (arrbennhan != null && arrbennhan.length > 0) {
					// for (int i = 0; i < arrbengiao.length; i++) {
					for (int i = 0; i < arrbennhan.length; i++) {
						bennhan.append("- \u00D4ng(b\u00E0): " + arrbennhan[i].getHoTen());
						bennhan.append("    - Ch\u1EE9c v\u1EE5: " + arrbennhan[i].getChucVu());
						bennhan.append("\n");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrbennhan[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrbennhan[i].getChucVu());
						word.addRowTable(table, arrbennhan.length);
						nguoiNhan = arrbennhan[i].getHoTen();
					}
				}
				word.put("[ttkt]", hinhThuc);
				word.put("[bao_cao]", ketThucTtktForm.getBaoCaoBanGianHoSoLuuTru());
				word.put("[ho_so_tai_lieu]", ketThucTtktForm.getHoSoBanGianHoSoLuuTru());
				word.put("[thoi_diem_giao_nhan]", KtnbUtil.getHour(ketThucTtktForm.getThoiDiemKetThucBanGianHoSoLuuTru()));
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB18A", ".doc", response);
			} catch (Exception ex) {
				ex.printStackTrace();
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
	 * Edit : tmtuan
	 * Method : inKetThucTtkt
	 * Des : ktnb v4
	 * */
	private void inKetThucTtkt(ApplicationContext appContext, KetThucTtktForm ketThucTtktForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("This is ktnb v4");
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;
		String type = request.getParameter("type");
		if ("downloadMau35".equals(type)) {
			fileIn = request.getRealPath("/docin/v4/ttkt") + "\\KTNB35.doc";
			fileOut = request.getRealPath("/docout") + "\\KTNB35_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			String idCuocTtkt = ketThucTtktForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);

			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";

			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appContext);

			try {
				word = new MsWordUtils(fileIn, fileOut);
				TtktCbQd qdTtkt = TtktService.getQuyetDinh(idCuocTtkt, appContext);
				word.put("[so_qd]", qdTtkt.getSoQuyetDinh());
				String ngayqd = Formater.date2str(qdTtkt.getNgayRaQuyetDnh());
				word.put("[ngay_qd]", Formater.getDateForPrint(ngayqd));
				word.put("[so_qd]", qdTtkt.getSoQuyetDinh());
				word.put("[ngay_qd]", Formater.getDateForPrint(ngayqd));
				word.put("[thu_truong_qd]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());

				word.saveAndClose();
				word.downloadFile(fileOut, "Mau 35/KTNB", ".doc", response);
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
		if ("downloadMau36".equals(type)) {
			fileIn = request.getRealPath("/docin/v4/ttkt") + "\\KTNB36.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB36_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			String idCuocTtkt = ketThucTtktForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);

			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";

			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appContext);

			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
				StringBuffer sb = new StringBuffer("\u0110O\u00C0N ");
				sb.append(hinhthuc_in);
				sb.append(" Q\u0110 S\u1ED0 ");
				sb.append(cbQd.getSoQuyetDinh());
				word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
				word.put("[noi_lap]", ".....");
				word.put("[ngay_lap]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				//word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[chuc_danh_nguoi_ra_qd_ttkt]", "..........");
				//word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				String ngayqd = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				word.put("[ngay_qd]", Formater.getDateForPrint(ngayqd));
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
				//word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//for (int i = 0; i < 4; i++)
				//word.put("[ttkt]", hinhThuc);
				word.put("[ten_dv_da_lam_viec]", "..........");
				word.put("[ten_dv_da_kt_xacminh]", "..........");
				//for (int i = 0; i < 13; i++)
				//word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//word.put("[ttkt]", hinhThuc);
				word.put("[chuc_danh_nguoi_ra_qd_ttkt]", "..........");
				//word.put("[ttkt]", hinhThuc.toUpperCase());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());

				word.saveAndClose();
				word.downloadFile(fileOut, "Mau 36/KTNB", ".doc", response);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {
				try {
					word.saveAndClose();
				} catch (Exception e) {

				}
			}
		} else if ("downloadMau37".equals(type)) {
			fileIn = request.getRealPath("/docin/v4/ttkt") + "\\KTNB37.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB37_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			String idCuocTtkt = ketThucTtktForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);

			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appContext);

			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
				word.put("[cqt_ra_ket_luan]", "T\u00CAN C\u01A0 QUAN THU\u1EBE RA Q\u0110");
				word.put("[ten_viet_tat_cqt]", "...../KL-.........");
				word.put("[noi_lap]", ".....");
				word.put("[ngay_lap]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				//word.put("[ttkt]", hinhThuc.toUpperCase());
				//word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				String ngayqd = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				word.put("[ngay_qd]", Formater.getDateForPrint(ngayqd));
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
				//word.put("[ttkt]", hinhThuc);
				//word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//word.put("[ttkt]", hinhThuc);
				//word.put("[ttkt]", hinhThuc);
				//word.put("[ttkt]", hinhThuc);
				word.put("[ten_cqt_dua_ra_ket_luan]", "..........");
				//word.put("[ttkt]", hinhThuc);
				//word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//for (int i = 0; i < 5; i++)
				//word.put("[ttkt]", hinhThuc);
				word.put("[ten_cqt]", appContext.getTenCqt());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//word.put("[ttkt]", hinhThuc);
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appContext.getMaCqt()).toUpperCase());
				//word.put("[ten_thu_truong_cqt]", appContext.getTenThuTruong());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau 37/KTNB", ".doc", response);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {
				try {
					word.saveAndClose();
				} catch (Exception e) {

				}
			}
		} else if ("thongBaoKetThuc".equals(type)) { // thong bao ket thuc
			// (ngon,chuan)
			fileIn = request.getRealPath("/docin/v4") + "\\TTNB34.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB34_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			// Loc sua lai sau
			String idCuocTtkt = ketThucTtktForm.getIdCuocTtkt();

			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);

			KtnbUtil.getChucVuThuTruongByMaCqt(cuocTtkt.getIdDonViBi());
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";

			StringBuffer sb = new StringBuffer("\u0110O\u00C0N ");
			sb.append(hinhthuc_in);
			sb.append(" Q\u0110 S\u1ED0 ");
			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appContext);
			TtktThCongBoQd cbKl = TtktService.getCongBoQd(appContext, cuocTtkt.getId());
			sb.append(cbQd.getSoQuyetDinh());

			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
				word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
				String ngaythongbao = ketThucTtktForm.getNgayRaThongBaoKetThuc();
				String[] arrngaythongbao = ngaythongbao.split("/");
				if (ketThucTtktForm.getNoiRaThongBaoKetThuc().equals("") || ketThucTtktForm.getNgayRaThongBaoKetThuc().equals("")) {
					word.put("[noi_ra_thong_bao]", ".....");
					word.put("[ngay_thong_bao]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else {
					word.put("[noi_ra_thong_bao]", ketThucTtktForm.getNoiRaThongBaoKetThuc());
					word.put("[ngay_thong_bao]", "Ng\u00E0y " + arrngaythongbao[0] + " th\u00E1ng " + arrngaythongbao[1] + " n\u0103m " + arrngaythongbao[2]);
				}
				word.put("[ten_bc]", "TH\u00D4NG B\u00C1O");
				//word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", cbQd.getSoQuyetDinh());
				// ngay ra qd
				word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
				word.put("[thu_truong_cqt]", KtnbUtil.getTenThuTruongCqt(appContext));
				//word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//word.put("[ttkt]", hinhThuc);
				//word.put("[ttkt]", hinhThuc);
				// thanh tra, kiem tra tu ngay
				word.put("[ngay_ttkt]", Formater.getDateForPrint(Formater.date2str(cbKl.getThoiDiemCbTu())));
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//word.put("[ttkt]", hinhThuc);
				//word.put("[ttkt]", hinhThuc);
				// ngay ket thuc
				word.put("[thong_bao_ket_thuc]", Formater.getDateForPrint(ketThucTtktForm.getNgayKetThuc()));
				//word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());

				//word.put("[ttkt]", hinhThuc.toUpperCase());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				// sb = new StringBuffer("V\u1EC1 vi\u1EC7c k\u1EBFt th\u00FAc
				// ");
				// sb.append(hinhThuc);
				// word.put("[thong_bao]", sb.toString());
				// word.put("[kinh_gui]", appContext.getTenCqtTat());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB34", ".doc", response);
			} catch (Exception ex) {
				// ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {
				try {
					word.saveAndClose();
				} catch (Exception e) {

				}
			}

			// hop rut kinh nghiem doan (ngon, chuan)
		} else if ("hopRutKinhNghiemDoan".equals(type)) {
			fileIn = request.getRealPath("/docin/v4") + "\\TTNB14.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB14_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			// Loc sua lai sau
			String idCuocTtkt = ketThucTtktForm.getIdCuocTtkt();

			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);

			KtnbUtil.getChucVuThuTruongByMaCqt(cuocTtkt.getIdDonViBi());
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";

			StringBuffer sb = new StringBuffer("\u0110O\u00C0N ");
			sb.append(hinhthuc_in);
			sb.append(" Q\u0110 S\u1ED0 ");
			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appContext);
			sb.append(cbQd.getSoQuyetDinh());

			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
				word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
				word.put("[ten_bc]", "BI\u00CAN B\u1EA2N");
				//word.put("[ttkt]", hinhThuc.toUpperCase());
				word.put("[thoi_diem_bat_dau]", KtnbUtil.getHour(ketThucTtktForm.getThoiDiemBatDauHopRutKinhNghiem()));
				word.put("[dia_diem]", ketThucTtktForm.getDiaDiemHopRutKinhNghiem());
				//word.put("[ttkt]", hinhThuc);
				//word.put("[ttkt]", hinhThuc);
				word.put("[noi_dung_tom_tat]", ketThucTtktForm.getVeViecHopRutKinhNghiem());
				// thanh phan tham du
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrthanhphantd = ketThucTtktForm.getThanhPhanThamDuHopRutKinhNghiem();
				StringBuffer tptd = new StringBuffer("");
				int j = 0; // dem so luong thanh vien doan , bo qua truong doan
				// ttkt
				if (arrthanhphantd != null && arrthanhphantd.length > 0) {
					for (int i = 0; i < arrthanhphantd.length; i++) {
						if (!cuocTtkt.getTenTruongDoan().equals(arrthanhphantd[i].getHoTen())) {
							tptd.append((j + 1) + ". " + arrthanhphantd[i].getHoTen() + "\n");// in
							// danh
							// sach
							// thanh
							// vien
							// ki
							// duyet
							j++;
						}
						String tenTv = (i + 1) + "." + " \u00D4ng(b\u00E0): " + arrthanhphantd[i].getHoTen();
						String chucvu = "- Ch\u1EE9c v\u1EE5: " + arrthanhphantd[i].getChucVu();
						word.addCellTable(table, i + 1, 1, (i + 1) + "." + " \u00D4ng(b\u00E0): " + arrthanhphantd[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphantd[i].getChucVu());
						word.addRowTable(table, arrthanhphantd.length);
					}
					System.out.println(tptd.toString());
					// word.put("thanh_vien", tptd.toString());
				}
				//
				word.put("[noi_dung]", ketThucTtktForm.getNoiDungHopRutKinhNghiem());
				word.put("[thoi_gian_ket_thuc]", KtnbUtil.getHour(ketThucTtktForm.getThoiDiemKetThucHopRutKinhNghiem()));
				//word.put("[ttkt]", hinhThuc.toUpperCase());
				//word.put("[ttkt]", hinhThuc.toUpperCase());
				if (tptd.toString().length() == 0)
					word.put("[ds_thanh_vien]", "");
				else
					word.put("[ds_thanh_vien]", tptd.toString());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB14", ".doc", response);
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {
				try {
					word.saveAndClose();
				} catch (Exception e) {

				}
			}

			// ban giao hs (xem lai)
		} else if ("banGiaoHoSoLuuTru".equals(type)) {
			fileIn = request.getRealPath("/docin/v4") + "\\TTNB18.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB18_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			String idCuocTtkt = ketThucTtktForm.getIdCuocTtkt();

			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);

			TtktCbQd cbQd = TtktService.getQuyetDinh(cuocTtkt.getId(), appContext);
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";

			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
				StringBuffer sb = new StringBuffer("\u0110O\u00C0N ");
				sb.append(hinhthuc_in);
				sb.append(" Q\u0110 S\u1ED0 ");
				sb.append(cbQd.getSoQuyetDinh());
				word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
				word.put("[ten_bc]", "BI\u00CAN B\u1EA2N");
				word.put("[thoi_diem_bat_dau]", KtnbUtil.getHour(ketThucTtktForm.getThoiDiemBatDauBanGianHoSoLuuTru()));
				word.put("[dia_diem]", ketThucTtktForm.getDiaDiemBanGiaoHoSoLuuTru());
				//word.put("[ttkt]", hinhThuc);
				word.put("[so_quyet_dinh]", cbQd.getSoQuyetDinh());
				String ngayqd = Formater.date2str(cbQd.getNgayRaQuyetDnh());
				String[] arrngayquyet = ngayqd.split("/");
				word.put("[ngay_quyet]", "ng\u00E0y " + arrngayquyet[0] + " th\u00E1ng " + arrngayquyet[1] + " n\u0103m " + arrngayquyet[2]);
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getTenThuTruongCqt(appContext));
				//word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());

				// dai dien ben giao
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrbengiao = ketThucTtktForm.getArrDaiDienBenGiaoHstlLuuTru();
				StringBuffer bengiao = new StringBuffer("");
				String nguoiGiao = "";
				if (arrbengiao != null && arrbengiao.length > 0) {
					for (int i = 0; i < arrbengiao.length; i++) {
						bengiao.append("- \u00D4ng(b\u00E0): " + arrbengiao[i].getHoTen());
						bengiao.append("   - Ch\u1EE9c v\u1EE5: " + arrbengiao[i].getChucVu());
						bengiao.append("\n");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrbengiao[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrbengiao[i].getChucVu());
						word.addRowTable(table, arrbengiao.length);
						nguoiGiao = arrbengiao[i].getHoTen();
					}
				}
				// dai dien ben nhan
				table = word.openTable(3);
				TtktCmThanhPhanThamDu[] arrbennhan = ketThucTtktForm.getArrDaiDienBenNhanHstlLuuTru();
				StringBuffer bennhan = new StringBuffer("");
				String nguoiNhan = "";
				if (arrbennhan != null && arrbennhan.length > 0) {
					// for (int i = 0; i < arrbengiao.length; i++) {
					for (int i = 0; i < arrbennhan.length; i++) {
						bennhan.append("- \u00D4ng(b\u00E0): " + arrbennhan[i].getHoTen());
						bennhan.append("    - Ch\u1EE9c v\u1EE5: " + arrbennhan[i].getChucVu());
						bennhan.append("\n");
						word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrbennhan[i].getHoTen());
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrbennhan[i].getChucVu());
						word.addRowTable(table, arrbennhan.length);
						nguoiNhan = arrbennhan[i].getHoTen();
					}
				}
				//word.put("[ttkt]", hinhThuc);
				word.put("[bao_cao]", ketThucTtktForm.getBaoCaoBanGianHoSoLuuTru());
				word.put("[ho_so_tai_lieu]", ketThucTtktForm.getHoSoBanGianHoSoLuuTru());
				word.put("[thoi_diem_giao_nhan]", KtnbUtil.getHour(ketThucTtktForm.getThoiDiemKetThucBanGianHoSoLuuTru()));
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB18A", ".doc", response);
			} catch (Exception ex) {
				ex.printStackTrace();
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
	 * @param appContext
	 * @param ketThucTtktForm
	 */
	private void saveKetThucTtkt(ApplicationContext appContext, KetThucTtktForm ketThucTtktForm, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String type = request.getParameter("type");
		String maLoi = " ";
		if ("thongBaoKetThuc".equals(type)) {
			TtktService.thongBaoKetThuc(appContext, ketThucTtktForm);

		} else if ("duThaoKetQua".equals(type)) {
			// Chua nhap thong bao ket thuc
			if (TtktService.getIndexOfTrangThai(appContext.getTrangThaiCuocTtkt(ketThucTtktForm.getIdCuocTtkt())) < TtktService.getIndexOfTrangThai(Constants.TT_TTKT_TBKT)) {
				maLoi = "1";
			} else {
				TtktThBbChitietvatonghop bbChitietvatonghop = createDuThaoKetQua(appContext, ketThucTtktForm);
				TtktService.saveBienBan(appContext, bbChitietvatonghop, Constants.TT_TTKT_DTKQ);
			}
		} else if ("ketQua".equals(type)) {
			if (TtktService.getIndexOfTrangThai(appContext.getTrangThaiCuocTtkt(ketThucTtktForm.getIdCuocTtkt())) < TtktService.getIndexOfTrangThai(Constants.TT_TTKT_TBKT)) {
				maLoi = "1";
			} else {
				TtktThBbChitietvatonghop bbChitietvatonghop = this.createKetQua(appContext, ketThucTtktForm);
				TtktService.saveBienBan(appContext, bbChitietvatonghop, Constants.TT_TTKT_KQ);
			}

		} else if ("duThaoKetLuan".equals(type)) {
			if (TtktService.getIndexOfTrangThai(appContext.getTrangThaiCuocTtkt(ketThucTtktForm.getIdCuocTtkt())) < TtktService.getIndexOfTrangThai(Constants.TT_TTKT_KQ)) {
				maLoi = "2";
			} else {
				TtktThBbChitietvatonghop bbChitietvatonghop = this.createDuThaoKetLuan(appContext, ketThucTtktForm);
				TtktService.saveBienBan(appContext, bbChitietvatonghop, Constants.TT_TTKT_DTKL);
			}
		} else if ("ketLuan".equals(type)) {
			if (TtktService.getIndexOfTrangThai(appContext.getTrangThaiCuocTtkt(ketThucTtktForm.getIdCuocTtkt())) < TtktService.getIndexOfTrangThai(Constants.TT_TTKT_KQ)) {
				maLoi = "2";
			} else {
				TtktThBbChitietvatonghop bbChitietvatonghop = this.createKetLuan(appContext, ketThucTtktForm);
				TtktService.saveBienBan(appContext, bbChitietvatonghop, Constants.TT_TTKT_KL);
			}
		} else if ("ketLuanSangBaoCao".equals(type)) {
			if (TtktService.getIndexOfTrangThai(appContext.getTrangThaiCuocTtkt(ketThucTtktForm.getIdCuocTtkt())) < TtktService.getIndexOfTrangThai(Constants.TT_TTKT_KQ)) {
				maLoi = "2";
			} else {
				TtktThBbChitietvatonghop bbChitietvatonghop = this.createKetLuanSangBC(appContext, ketThucTtktForm);
				//System.out.println("alert1");
				TtktService.saveKetLuanSangBC(appContext, bbChitietvatonghop, Constants.TT_TTKT_KL);
			}
		} else if ("hopRutKinhNghiemDoan".equals(type)) {
			if (TtktService.getIndexOfTrangThai(appContext.getTrangThaiCuocTtkt(ketThucTtktForm.getIdCuocTtkt())) < TtktService.getIndexOfTrangThai(Constants.TT_TTKT_KL)) {
				maLoi = "3";
			} else {
				TtktCmBienBan bienBanHopRutKinhNghiem = this.createBienBanHopRutKinhNghiem(appContext, ketThucTtktForm, request);
				TtktService.saveBienBanHopRutKinhNghiem(appContext, bienBanHopRutKinhNghiem);
			}
		} else if ("banGiaoHoSoLuuTru".equals(type)) {
			if (TtktService.getIndexOfTrangThai(appContext.getTrangThaiCuocTtkt(ketThucTtktForm.getIdCuocTtkt())) < TtktService.getIndexOfTrangThai(Constants.TT_TTKT_HOPRKN)) {
				maLoi = "4";
			} else {
				TtktCmNhanTraHstl nhanTraHstl = this.createBanGiaoHoSoLuuTru(appContext, ketThucTtktForm, request);
				TtktService.saveNhanTraHstl(appContext, nhanTraHstl);
			}
		} else if ("chuyenDuLieuSangBaoCao".equals(type)) {
			if (TtktService.getIndexOfTrangThai(appContext.getTrangThaiCuocTtkt(ketThucTtktForm.getIdCuocTtkt())) < TtktService.getIndexOfTrangThai(Constants.TT_TTKT_BGHSLT)) {
				maLoi = "5";
			} else {
				// TtktKtChuyenDlieuSangBc chuyenDlieuSangBc =
				// createChuyenDlieuSangBaoCao(appContext, ketThucTtktForm);
				// TtktService.chuyenDlieuSangBaoCao(appContext,
				// chuyenDlieuSangBc);				
				TtktKtBcKqThucHienKL kqThucHienKl = this.createKqThucHienKL(appContext, ketThucTtktForm);
				TtktService.baocaoKqThucHienKl(appContext, kqThucHienKl, ketThucTtktForm);
			}
		}
		//PrintWriter out = reponse.getWriter();
		//if (Formater.isNull(maLoi))
		//	out.print("cucsess");
		//else
		//	out.print(maLoi);
		//out.flush();
		//out.close();
	}

	/**
	 * @param appContext
	 * @param ketThucTtktForm
	 * @return
	 */
	private TtktKtChuyenDlieuSangBc createChuyenDlieuSangBaoCao(ApplicationContext appContext, KetThucTtktForm ketThucTtktForm) {
		TtktKtChuyenDlieuSangBc chuyenDlieuSangBc = new TtktKtChuyenDlieuSangBc();
		chuyenDlieuSangBc.setSoNguoiChuyenCqDieuTra(Long.valueOf(ketThucTtktForm.getSoNguoiChuyenCqDieuTra().replaceAll(" ", "")));
		chuyenDlieuSangBc.setSoVuChuyenCqDieuTra(Long.valueOf(ketThucTtktForm.getSoVuChuyenCqDieuTra().replaceAll(" ", "")));
		chuyenDlieuSangBc.setDaThuHoiKhac(Long.valueOf(ketThucTtktForm.getDaThuHoiKhac().replaceAll(" ", "")));
		chuyenDlieuSangBc.setDaThuHoiTienMat(Double.valueOf(ketThucTtktForm.getDaThuHoiTienMat().replaceAll(" ", "")));
		chuyenDlieuSangBc.setId(ketThucTtktForm.getIdChuyenDuLieuSangBc());
		chuyenDlieuSangBc.setIdCuocTtkt(ketThucTtktForm.getIdCuocTtkt());
		chuyenDlieuSangBc.setKienNghiKhac(Long.valueOf(ketThucTtktForm.getKienNghiKhac().replaceAll(" ", "")));
		chuyenDlieuSangBc.setSaiPhamKhac(Long.valueOf(ketThucTtktForm.getSaiPhamKhac().replaceAll(" ", "")));
		chuyenDlieuSangBc.setSaiPhamTienMat(Double.valueOf(ketThucTtktForm.getSaiPhamTienMat().replaceAll(" ", "")));
		chuyenDlieuSangBc.setSoCchucThueBiXlyHchinh(Long.valueOf(ketThucTtktForm.getSoCchucThueBiXlyHchinh().replaceAll(" ", "")));
		chuyenDlieuSangBc.setSoNguoiBiKienNghiXuLy(Long.valueOf(ketThucTtktForm.getSoNguoiBiKienNghiXuLy().replaceAll(" ", "")));
		chuyenDlieuSangBc.setChuaXuLy(Long.valueOf(ketThucTtktForm.getChuaXuLy().replaceAll(" ", "")));

		chuyenDlieuSangBc.setSoDtuongKhacBiXlyHchinh(Long.valueOf(ketThucTtktForm.getSoDtuongKhacBiXlyHchinh().replaceAll(" ", "")));
		chuyenDlieuSangBc.setThuHoiTienMat(Double.valueOf(ketThucTtktForm.getThuHoiTienMat().replaceAll(" ", "")));
		chuyenDlieuSangBc.setThuHoiKhac(Long.valueOf(ketThucTtktForm.getThuHoiKhac().replaceAll(" ", "")));
		chuyenDlieuSangBc.setSoDvSaiPham(Long.valueOf(ketThucTtktForm.getSoDvSaiPham().replaceAll(" ", "")));

		chuyenDlieuSangBc.setKiemDiemRutKn(Long.valueOf(ketThucTtktForm.getKiemDiemRutKn().replaceAll(" ", "")));
		chuyenDlieuSangBc.setKhienTrach(Long.valueOf(ketThucTtktForm.getKhienTrach().replaceAll(" ", "")));
		chuyenDlieuSangBc.setCanhCao(Long.valueOf(ketThucTtktForm.getCanhCao().replaceAll(" ", "")));
		chuyenDlieuSangBc.setHaBacLuong(Long.valueOf(ketThucTtktForm.getHaBacLuong().replaceAll(" ", "")));
		chuyenDlieuSangBc.setGiangChuc(Long.valueOf(ketThucTtktForm.getGiangChuc().replaceAll(" ", "")));
		chuyenDlieuSangBc.setCachChuc(Long.valueOf(ketThucTtktForm.getCachChuc().replaceAll(" ", "")));
		chuyenDlieuSangBc.setBuocThoiViec(Long.valueOf(ketThucTtktForm.getBuocThoiViec().replaceAll(" ", "")));
		chuyenDlieuSangBc.setXlyHinhSuCoAn(Long.valueOf(ketThucTtktForm.getXlyHinhSuCoAn().replaceAll(" ", "")));

		chuyenDlieuSangBc.setIdNguoiCapNat(appContext.getMaCanbo());
		chuyenDlieuSangBc.setTenNguoiCapNhat(appContext.getTenCanbo());
		chuyenDlieuSangBc.setNgayCapNhat(new Date());

		if ("kiemTra".equals(ketThucTtktForm.getKiemTraSauTtkt())) {
			chuyenDlieuSangBc.setTienDaThuHoiSauTtkt(Double.valueOf(ketThucTtktForm.getTienDaThuHoiSauTtkt().replaceAll(" ", "")));
			chuyenDlieuSangBc.setSoKlQdDaKt(Long.valueOf(ketThucTtktForm.getSoKlQdDaKt().replaceAll(" ", "")));
		}
		chuyenDlieuSangBc.setKetThucNhapLieu(ketThucTtktForm.getKetThucNhapLieu());
		chuyenDlieuSangBc.setSoKetLuan(ketThucTtktForm.getSoKetLuan());
		return chuyenDlieuSangBc;
	}

	/**
	 * @param appContext
	 * @param ketThucTtktForm
	 * @return
	 */
	private TtktKtBcKqThucHienKL createKqThucHienKL(ApplicationContext appContext, KetThucTtktForm form) throws Exception {
		TtktKtBcKqThucHienKL obj = null;
		if (Formater.isNull(form.getIdKqThucHienKl()))
			obj = new TtktKtBcKqThucHienKL();
		else
			obj = TtktService.getKqThucHienKl(appContext, form.getIdCuocTtkt());
		obj.setIdCuocTtkt(form.getIdCuocTtkt());
		obj.setKetThucTdoiThanh(form.isKetThucTdoiThanh() ? new Long(1) : new Long(0));
		obj.setKienNghiKhac(Formater.isNull(form.getKienNghiKhac()) ? new Long(0) : new Long(form.getKienNghiKhac()));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		obj.setNgayNhanBckq(Formater.isNull(form.getNgayNhanBckq()) ? new Date() : sdf.parse(form.getNgayNhanBckq()));
		obj.setSoCachChuc(Formater.isNull(form.getSoCachChuc()) ? new Long(0) : new Long(form.getSoCachChuc()));
		obj.setSoCanhCao(Formater.isNull(form.getSoCanhCao()) ? new Long(0) : new Long(form.getSoCanhCao()));
		obj.setSoDviDuocTtkt(Formater.isNull(form.getSoDviDuocTtkt()) ? new Long(0) : new Long(form.getSoDviDuocTtkt()));
		obj.setSoDviSaiPham(Formater.isNull(form.getSoDviSaiPham()) ? new Long(0) : new Long(form.getSoDviSaiPham()));
		obj.setSoGiangChuc(Formater.isNull(form.getSoGiangChuc()) ? new Long(0) : new Long(form.getSoGiangChuc()));
		obj.setSoHaBacLuong(Formater.isNull(form.getSoHaBacLuong()) ? new Long(0) : new Long(form.getSoHaBacLuong()));
		obj.setSoKhac(Formater.isNull(form.getSoKhac()) ? new Long(0) : new Long(form.getSoKhac()));
		obj.setSoKhienTrach(Formater.isNull(form.getSoKhienTrach()) ? new Long(0) : new Long(form.getSoKhienTrach()));
		obj.setSoKiemDiem(Formater.isNull(form.getSoKiemDiem()) ? new Long(0) : new Long(form.getSoKiemDiem()));
		obj.setSoSdbsQtqc(Formater.isNull(form.getSoSdbsQtqc()) ? new Long(0) : new Long(form.getSoSdbsQtqc()));
		obj.setSoSdbsVbpq(Formater.isNull(form.getSoSdbsVbpq()) ? new Long(0) : new Long(form.getSoSdbsVbpq()));
		obj.setSoThoiViec(Formater.isNull(form.getSoThoiViec()) ? new Long(0) : new Long(form.getSoThoiViec()));
		if (!Formater.isNull(form.getSoTienThuHtraSpKhac()))
			obj.setSoTienThuHtraSpKhac(new Double(Formater.toDouble(form.getSoTienThuHtraSpKhac())));
		obj.setSoTtktThue(Formater.isNull(form.getSoTtktThue()) ? new Long(0) : new Long(form.getSoTtktThue()));
		if (!Formater.isNull(form.getTienHoanTraCongChucThue()))
			obj.setTienHoanTraCongChucThue(new Double(Formater.toDouble(form.getTienHoanTraCongChucThue())));
		if (!Formater.isNull(form.getTienHoanTraNguoiNopThue()))
			obj.setTienHoanTraNguoiNopThue(new Double(Formater.toDouble(form.getTienHoanTraNguoiNopThue())));
		if (!Formater.isNull(form.getTienHoanTraTtktThue()))
			obj.setTienHoanTraTtktThue(new Double(Formater.toDouble(form.getTienHoanTraTtktThue())));
		if (!Formater.isNull(form.getTienPhaiThuCongChucThue()))
			obj.setTienPhaiThuCongChucThue(new Double(Formater.toDouble(form.getTienPhaiThuCongChucThue())));
		if (!Formater.isNull(form.getTienPhaiThuNguoiNopThue()))
			obj.setTienPhaiThuNguoiNopThue(new Double(Formater.toDouble(form.getTienPhaiThuNguoiNopThue())));
		if (!Formater.isNull(form.getTienPhaiThuTtktThue()))
			obj.setTienPhaiThuTtktThue(new Double(Formater.toDouble(form.getTienPhaiThuTtktThue())));
		obj.setSoXlhsCoAn(Formater.isNull(form.getSoXlhsCoAn()) ? new Long(0) : new Long(form.getSoXlhsCoAn()));

		obj.setIdNguoiCapNhat(appContext.getMaCanbo());
		obj.setTenNguoiCapNhap(appContext.getTenCanbo());
		obj.setNgayCapNhat(new Date());

		return obj;
	}

	/**
	 * @param appContext
	 * @param ketThucTtktForm
	 * @param request
	 * @return
	 */
	private TtktCmNhanTraHstl createBanGiaoHoSoLuuTru(ApplicationContext appContext, KetThucTtktForm ketThucTtktForm, HttpServletRequest request) throws Exception {
		TtktCmNhanTraHstl nhanTraHstl = new TtktCmNhanTraHstl();
		nhanTraHstl.setId(ketThucTtktForm.getIdBanGiaoHoSoLuuTru());
		nhanTraHstl.setThoiDiemBatDau(Formater.str2dateForNV(ketThucTtktForm.getThoiDiemBatDauBanGianHoSoLuuTru()));
		nhanTraHstl.setDiaDiemBanGiao(ketThucTtktForm.getDiaDiemBanGiaoHoSoLuuTru());
		nhanTraHstl.setBaoCao(ketThucTtktForm.getBaoCaoBanGianHoSoLuuTru());
		nhanTraHstl.setHoSo(ketThucTtktForm.getHoSoBanGianHoSoLuuTru());
		nhanTraHstl.setThoiDiemKetThuc(Formater.str2dateForNV(ketThucTtktForm.getThoiDiemKetThucBanGianHoSoLuuTru()));
		nhanTraHstl.setLoai(Constants.TTKT_BB_BGHSLT);
		nhanTraHstl.setIdCuocTtkt(ketThucTtktForm.getIdCuocTtkt());
		nhanTraHstl.setIdNguoiCapNat(appContext.getMaCanbo());
		nhanTraHstl.setTenNguoiCapNhat(appContext.getTenCanbo());
		nhanTraHstl.setNgayCapNhat(new Date());
		// Dai dien ben giao ho so luu tru
		nhanTraHstl.setIdDaiDienBenGiao(ketThucTtktForm.getIdDaiDienBenGiaoBanGianHoSoLuuTru());
		TtktCmThanhPhanThamDu[] arrDaiDienBenGiao = ketThucTtktForm.getArrDaiDienBenGiaoHstlLuuTru();
		Collection listDaiDienBenGiao = new ArrayList();
		if (arrDaiDienBenGiao != null && arrDaiDienBenGiao.length > 0) {
			for (int i = 0; i < arrDaiDienBenGiao.length; i++) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) arrDaiDienBenGiao[i];
				thanhPhanThamDu.setIdMaster(nhanTraHstl.getIdDaiDienBenGiao());
				listDaiDienBenGiao.add(thanhPhanThamDu);
			}
		}
		nhanTraHstl.setDaiDienBenGiao(listDaiDienBenGiao);

		// Dai dien ben nhan giao ho so luu tru
		nhanTraHstl.setIdDaiDienBenNhan(ketThucTtktForm.getIdDaiDienBenNhanBanGianHoSoLuuTru());
		TtktCmThanhPhanThamDu[] arrDaiDienBenNhan = ketThucTtktForm.getArrDaiDienBenNhanHstlLuuTru();
		Collection listDaiDienBenNhan = new ArrayList();
		if (arrDaiDienBenNhan != null && arrDaiDienBenNhan.length > 0) {
			for (int i = 0; i < arrDaiDienBenNhan.length; i++) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) arrDaiDienBenNhan[i];
				thanhPhanThamDu.setIdMaster(nhanTraHstl.getIdDaiDienBenNhan());
				listDaiDienBenNhan.add(thanhPhanThamDu);
			}
		}
		nhanTraHstl.setDaiDienBenNhan(listDaiDienBenNhan);

		return nhanTraHstl;
	}

	/**
	 * @param appContext
	 * @param ketThucTtktForm
	 * @return
	 */
	private TtktCmBienBan createBienBanHopRutKinhNghiem(ApplicationContext appContext, KetThucTtktForm ketThucTtktForm, HttpServletRequest request) throws Exception {
		TtktCmBienBan bbHopDoanTrienKhai = new TtktCmBienBan();
		bbHopDoanTrienKhai.setDiaDiem(ketThucTtktForm.getDiaDiemHopRutKinhNghiem());
		bbHopDoanTrienKhai.setId(ketThucTtktForm.getIdBienBanHopRutKinhNghiem());
		bbHopDoanTrienKhai.setIdCuocTtkt(ketThucTtktForm.getIdCuocTtkt());
		bbHopDoanTrienKhai.setLoai(Constants.TTKT_BB_HRKN);
		bbHopDoanTrienKhai.setNoiDung(ketThucTtktForm.getNoiDungHopRutKinhNghiem());
		bbHopDoanTrienKhai.setThoiDiemBatDau(Formater.str2dateForNV(ketThucTtktForm.getThoiDiemBatDauHopRutKinhNghiem()));
		bbHopDoanTrienKhai.setThoiDiemKetThuc(Formater.str2dateForNV(ketThucTtktForm.getThoiDiemKetThucHopRutKinhNghiem()));
		bbHopDoanTrienKhai.setVeViec(ketThucTtktForm.getVeViecHopRutKinhNghiem());
		bbHopDoanTrienKhai.setThanhPhanThamDu(creatDsThanhPhanThamDuHop(request, appContext, ketThucTtktForm));
		return bbHopDoanTrienKhai;
	}

	/**
	 * @param request
	 * @param appContext
	 * @param ketThucTtktForm
	 * @return
	 */
	private Collection creatDsThanhPhanThamDuHop(HttpServletRequest request, ApplicationContext appContext, KetThucTtktForm ketThucTtktForm) throws Exception {
		ArrayList thanhPhanThamDu = new ArrayList();
		TtktCmThanhPhanThamDu[] arrThanhPhanThamDu = ketThucTtktForm.getThanhPhanThamDuHopRutKinhNghiem();
		for (int i = 0; i < arrThanhPhanThamDu.length; i++) {
			TtktCmThanhPhanThamDu thamDu = arrThanhPhanThamDu[i];
			thamDu.setIdMaster(ketThucTtktForm.getIdBienBanHopRutKinhNghiem());
			thanhPhanThamDu.add(thamDu);
		}

		return thanhPhanThamDu;
	}

	/**
	 * @param appContext
	 * @param ketThucTtktForm
	 * @return
	 */
	private TtktThBbChitietvatonghop createKetLuan(ApplicationContext appContext, KetThucTtktForm ketThucTtktForm) throws Exception {
		TtktThBbChitietvatonghop kqklThanhTraKiemTra = new TtktThBbChitietvatonghop();
		kqklThanhTraKiemTra.setId(ketThucTtktForm.getIdKetLuan());
		kqklThanhTraKiemTra.setIdCuocTtkt(ketThucTtktForm.getIdCuocTtkt());
		kqklThanhTraKiemTra.setLoaiBb(Constants.TTKT_BB_KL);
		kqklThanhTraKiemTra.setFileDinhKem(ketThucTtktForm.getFileKetLuan());
		kqklThanhTraKiemTra.setTgianThTuNgay(Formater.str2date(ketThucTtktForm.getNgayRaKetLuan()));
		kqklThanhTraKiemTra.setTgianThTuNgayStr(ketThucTtktForm.getNgayRaKetLuan());
		kqklThanhTraKiemTra.setIdNguoiCapNat(appContext.getMaCanbo());
		kqklThanhTraKiemTra.setTenNguoiCapNhat(appContext.getTenCanbo());
		kqklThanhTraKiemTra.setNgayCapNhat(new Date());
		kqklThanhTraKiemTra.setSoKetLuan(ketThucTtktForm.getSoKetLuan());
		return kqklThanhTraKiemTra;

	}

	/**
	 * @param appContext
	 * @param ktTtktForm
	 * @return
	 */
	private TtktThBbChitietvatonghop createKetLuanSangBC(ApplicationContext appContext, KetThucTtktForm ktTtktForm) throws Exception {
		TtktThBbChitietvatonghop kqkl = new TtktThBbChitietvatonghop();
		kqkl.setId(ktTtktForm.getIdKetLuan());
		kqkl.setDcID(ktTtktForm.getDcID());
		kqkl.setIdCuocTtkt(ktTtktForm.getIdCuocTtkt());
		// kqklThanhTraKiemTra.setLoaiBb(Constants.TTKT_BB_KL);
		// kqklThanhTraKiemTra.setFileDinhKem(ketThucTtktForm.getFileKetLuan());
		kqkl.setTgianThTuNgay(Formater.str2date(ktTtktForm.getNgayRaKetLuan()));
		kqkl.setTgianThTuNgayStr(ktTtktForm.getNgayRaKetLuan());
		// kqklThanhTraKiemTra.setFileDinhKem(ketThucTtktForm.getFileKetLuan());
		kqkl.setIdNguoiCapNat(appContext.getMaCanbo());
		kqkl.setTenNguoiCapNhat(appContext.getTenCanbo());
		kqkl.setNgayCapNhat(new Date());

		kqkl.setDcKiemTraSauTTKT(ktTtktForm.getDcKiemTraSauTTKT());
		kqkl.setDcTsKlTtktQdxlDaKtra(ktTtktForm.getDcTsKlTtktQdxlDaKtra());
		kqkl.setSoTienDaThuHauKiem(ktTtktForm.getSoTienDaThuHauKiem());

		kqkl.setDcKienNghiKhac(ktTtktForm.getDcKienNghiKhac());
		kqkl.setDcMoTa(ktTtktForm.getDcMoTa());
		kqkl.setDcSoDonViSaiPham(ktTtktForm.getDcSoDonViSaiPham());
		kqkl.setDcSoDonViTTKT(ktTtktForm.getDcSoDonViTTKT());
		kqkl.setDcSoSDBC_QTQC(ktTtktForm.getDcSoSDBC_QTQC());
		kqkl.setDcSoSDBS_VPBQ(ktTtktForm.getDcSoSDBS_VPBQ());
		kqkl.setDcSoTienNopCongChucTHue(ktTtktForm.getDcSoTienNopCongChucTHue());
		kqkl.setDcSoTienNopNguoiNopThue(ktTtktForm.getDcSoTienNopNguoiNopThue());
		kqkl.setDcSoTienThuCongChucThue(ktTtktForm.getDcSoTienThuCongChucThue());
		kqkl.setDcSoTienThuNguoiNopThue(ktTtktForm.getDcSoTienThuNguoiNopThue());
		kqkl.setDcTSTienThuCongChucThue(ktTtktForm.getDcTSTienThuCongChucThue());
		kqkl.setDcTSTienThuNguoiNopThue(ktTtktForm.getDcTSTienThuNguoiNopThue());
		kqkl.setDcTSTienTraCongChucThue(ktTtktForm.getDcTSTienTraCongChucThue());
		kqkl.setDcTSTienTraNguoiNopThue(ktTtktForm.getDcTSTienTraNguoiNopThue());

		kqkl.setDcTsTienThuHtraSpKhac(ktTtktForm.getDcTsTienThuHtraSpKhac());
		kqkl.setDcSoTienKnghiThuHtraSpKhac(ktTtktForm.getDcSoTienKnghiThuHtraSpKhac());
		kqkl.setDcXuLiHanhChinhCongVienChucThue(ktTtktForm.getDcXuLiHanhChinhCongVienChucThue());
		kqkl.setDcXuLiHanhChinhDoiTuongKhac(ktTtktForm.getDcXuLiHanhChinhDoiTuongKhac());
		kqkl.setDcXLHSSoVuViec(ktTtktForm.getDcXLHSSoVuViec());
		kqkl.setDcXLHSSoNguoi(ktTtktForm.getDcXLHSSoNguoi());
		kqkl.setDcSoTienKnghiThuHtraSpKhac(ktTtktForm.getDcSoTienKnghiThuHtraSpKhac());
		kqkl.setDcSoTTKTThue(ktTtktForm.getDcSoTTKTThue());
		kqkl.setSoKetLuan(ktTtktForm.getSoKetLuan());
		kqkl.setDcSoTienThuDoiTuongKhac(ktTtktForm.getDcSoTienThuDoiTuongKhac());
		kqkl.setDcSoTienNopDoiTuongKhac(ktTtktForm.getDcSoTienNopDoiTuongKhac());
		return kqkl;
	}

	/**
	 * @param appContext
	 * @param ketThucTtktForm
	 * @return
	 */
	private TtktThBbChitietvatonghop createDuThaoKetLuan(ApplicationContext appContext, KetThucTtktForm ketThucTtktForm) {
		TtktThBbChitietvatonghop kqklThanhTraKiemTra = new TtktThBbChitietvatonghop();
		kqklThanhTraKiemTra.setId(ketThucTtktForm.getIdDuThaoKetLuan());
		kqklThanhTraKiemTra.setIdCuocTtkt(ketThucTtktForm.getIdCuocTtkt());
		kqklThanhTraKiemTra.setLoaiBb(Constants.TTKT_BB_DTKL);
		kqklThanhTraKiemTra.setFileDinhKem(ketThucTtktForm.getFileDuThaoKetLuan());
		kqklThanhTraKiemTra.setIdNguoiCapNat(appContext.getMaCanbo());
		kqklThanhTraKiemTra.setTenNguoiCapNhat(appContext.getTenCanbo());
		kqklThanhTraKiemTra.setNgayCapNhat(new Date());

		return kqklThanhTraKiemTra;
	}

	/**
	 * @param appContext
	 * @param ketThucTtktForm
	 * @return
	 */
	private TtktThBbChitietvatonghop createKetQua(ApplicationContext appContext, KetThucTtktForm ketThucTtktForm) throws Exception {
		TtktThBbChitietvatonghop kqklThanhTraKiemTra = new TtktThBbChitietvatonghop();
		kqklThanhTraKiemTra.setId(ketThucTtktForm.getIdKetQua());
		kqklThanhTraKiemTra.setIdCuocTtkt(ketThucTtktForm.getIdCuocTtkt());
		kqklThanhTraKiemTra.setLoaiBb(Constants.TTKT_BB_KQ);
		kqklThanhTraKiemTra.setFileDinhKem(ketThucTtktForm.getFileKetQua());
		// Luu ngay gui bao cao kq va du thao ket luan vao truong thoi gian tien
		// hanh tu ngay.
		kqklThanhTraKiemTra.setTgianThTuNgay(Formater.str2date(ketThucTtktForm.getNgayGuiBaoCaoKetQuaVaDuThaoKetLuan()));
		kqklThanhTraKiemTra.setTgianThTuNgayStr(ketThucTtktForm.getNgayGuiBaoCaoKetQuaVaDuThaoKetLuan());
		// kqklThanhTraKiemTra.setFileDinhKem(ketThucTtktForm.getFileDuThaoKetLuan());
		kqklThanhTraKiemTra.setIdNguoiCapNat(appContext.getMaCanbo());
		kqklThanhTraKiemTra.setTenNguoiCapNhat(appContext.getTenCanbo());
		kqklThanhTraKiemTra.setNgayCapNhat(new Date());

		return kqklThanhTraKiemTra;
	}

	/**
	 * @param appContext
	 * @param ketThucTtktForm
	 * @return
	 */
	private TtktThBbChitietvatonghop createDuThaoKetQua(ApplicationContext appContext, KetThucTtktForm ketThucTtktForm) throws Exception {
		TtktThBbChitietvatonghop kqklThanhTraKiemTra = new TtktThBbChitietvatonghop();
		kqklThanhTraKiemTra.setId(ketThucTtktForm.getIdDuThaoKetQua());
		kqklThanhTraKiemTra.setIdCuocTtkt(ketThucTtktForm.getIdCuocTtkt());
		kqklThanhTraKiemTra.setLoaiBb(Constants.TTKT_BB_DTKQ);
		kqklThanhTraKiemTra.setFileDinhKem(ketThucTtktForm.getFileDuThaoKetQua());
		// kqklThanhTraKiemTra.setFileDinhKem(ketThucTtktForm.getFileDuThaoKetLuan());
		kqklThanhTraKiemTra.setIdNguoiCapNat(appContext.getMaCanbo());
		kqklThanhTraKiemTra.setTenNguoiCapNhat(appContext.getTenCanbo());
		kqklThanhTraKiemTra.setNgayCapNhat(new Date());

		return kqklThanhTraKiemTra;
	}

	private void loadDsTvDoan(String cuocTtktId, HttpServletRequest request) {
		Collection dsThanhVienDoan = TtktService.getDanhSachThanhVienDoan(cuocTtktId);
		String cbDsThanhVienDoan = "<option value = \"\">"; // Combo danh sach
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

		request.setAttribute("chiTietDsTvd", dsThanhVienDoan);
		request.setAttribute("dsThanhVienDoan", dsThanhVienDoan);
		request.setAttribute("cbChiTietDsTvd", cbDsThanhVienDoan);
		request.setAttribute("dsIdThanhVienDoan", dsIdThanhVienDoan.substring(0, dsIdThanhVienDoan.length() - 1));
		request.setAttribute("dsChucVuTrongDoan", dsChucVuTrongDoan.substring(0, dsChucVuTrongDoan.length() - 1));

	}

	/**
	 * @param appContext
	 * @param ketThucTtktForm
	 * @param cuocTtktId
	 */
	private void loadDefault(ApplicationContext appContext, KetThucTtktForm ketThucTtktForm, String cuocTtktId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Thong tin chung
		TtktKhCuocTtkt cuocTtkt = (TtktKhCuocTtkt) request.getSession().getAttribute("cuocTtkt");
		if (cuocTtkt != null) {
			request.getSession().removeAttribute("cuocTtkt");
		} else {
			cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, cuocTtktId);
		}
		// Kiem tra quyen truy cap		
		KtnbUtil.checkRight(appContext, request, response, cuocTtkt);
		ketThucTtktForm.setIdCuocTtkt(cuocTtkt.getId());
		ketThucTtktForm.setMaCuocTtkt(cuocTtkt.getMa());
		appContext.setTrangThaiCuocTtkt(cuocTtkt.getId(), cuocTtkt.getTrangThai());

		if (appContext.getTrangThaiCuocTtkt(cuocTtktId).equals(Constants.TT_TTKT_KT))
			request.setAttribute("readOnly", "true");
		if (cuocTtkt.getIdTruongDoan().equals(appContext.getMaCanbo()))
			appContext.setTruongDoan(cuocTtkt.getId(), true);
		else
			appContext.setTruongDoan(cuocTtkt.getId(), false);
		String[] temp = cuocTtkt.getMa().split("/");
		String namTienHanh = temp[temp.length - 2];
		KtnbUtil.cacheListHolidayDayForClient(request, namTienHanh, String.valueOf(Integer.parseInt(namTienHanh) + 1));

		// Phan quyen
		if (!appContext.isTruongDoan(cuocTtkt.getId())) {
			request.setAttribute("readOnly", "true");
			// To chuc thong bao ket thuc
			if (TtktCnPhuService.getBienBanLamViec(appContext, cuocTtktId, Constants.TTKT_BB_TBKT) != null)
				request.setAttribute("to_chuc_thong_bao_ket_thuc", "true");

			// Y kien tham gia cua cac thanh vien ve du thao ket qua
			Collection dstvd = TtktCnPhuService.getDsChiTietDSTVD(cuocTtktId);
			Iterator iterator = dstvd.iterator();
			while (iterator.hasNext()) {
				TtktCbChiTietDsTvDoan tvDoan = (TtktCbChiTietDsTvDoan) iterator.next();
				if (!Formater.isNull(tvDoan.getYkien())) {
					request.setAttribute("Y kien tham gia cua cac thanh vien ve du thao ket qua", "true");
					break;
				}
			}
			// Cong bo ket luan
			if (TtktCnPhuService.getCongBoKl(appContext, cuocTtktId) != null)
				request.setAttribute("cong_bo_ket_luan", "true");
			// Chuyen giao hsvv
			if (!Formater.isNull(TtktService.getDsChuyenGiaoHsvv(appContext, cuocTtktId))) {
				request.setAttribute("Chuyen giao hsvv", "true");
			}
		}
		// Thong bao ket thuc
		this.loadThongBaoKetThuc(request, appContext, ketThucTtktForm, cuocTtktId);
		// Thoi han Thanh tra Kiem tra
		if (KtnbUtil.isTruongDoan(appContext.getMaCanbo(), appContext, cuocTtktId)) {
			// Ngay cong bo
			Date ngayCongBo = TtktService.getCongBoQd(appContext, cuocTtktId).getThoiDiemCbDen();
			request.setAttribute("ngayCongBo", Formater.date2str(ngayCongBo));

			// Thoi han Ttkt
			HashMap thoiHanTtkt = (HashMap) KtnbCache.getInstance().get("MAP_THTTKT");

			// Thoi han ket thuc lam viec tai don vi
			int thoiHanKt = cuocTtkt.getThoiGianDuKien().intValue();
			// Kiem tra xem co gia han khong
			try {
				TtktThGiaHan giaHan = (TtktThGiaHan) TtktCnPhuService.getGiaHanTtKtByIdCuocttkt(appContext, cuocTtktId).toArray()[0];
				if (giaHan != null)
					thoiHanKt += giaHan.getSoNgayGiaHan().intValue();
			} catch (Exception e) {
				// TODO: handle exception
			}
			request.setAttribute("thoiHanKt", Formater.num2str(thoiHanKt));
			// Ngay ket thuc du kien
			Date ngayKetThuc = KtnbUtil.addBusinessDate(ngayCongBo, thoiHanKt);
			ketThucTtktForm.setHanKetThuc(Formater.date2str(ngayKetThuc));
			// Thoi han ra ket qua
			String thoiHanGuiKetQua = (String) thoiHanTtkt.get(Constants.TH_TTKT_KQ);
			request.setAttribute("thoiHanGuiKetQuaVaDuThaoKL", thoiHanGuiKetQua);

			// Thoi han ra ket luan
			request.setAttribute("thoiHanRaKetLuan", (String) thoiHanTtkt.get(Constants.TH_TTKT_KL));
			// Thoi han ban giao ho so luu tru
			request.setAttribute("thoiHanBanGiaoHsLuuTru", (String) thoiHanTtkt.get(Constants.TH_TTKT_BGHSLT));
		}

		// Ket qua, ket luan
		this.loadKetLuanKetQua(appContext, ketThucTtktForm, cuocTtktId, request);
		// Ngay thong bao ket thuc theo du kien

		// Hop rut kinh nghiem
		this.loadHopRutKinhNghiemDoan(appContext, ketThucTtktForm, cuocTtktId);

		// Ban giao ho so luu tru
		this.loadBanGiaoHoSoLuuTru(appContext, ketThucTtktForm, cuocTtktId, request);

		// Chuyen du lieu sang bao cao
		// loadChuyenDuLieuSangBaoCao(appContext, ketThucTtktForm, cuocTtktId);
		this.loadKqThucHienKl(appContext, ketThucTtktForm, cuocTtktId);

	}

	/**
	 * @param appContext
	 * @param ketThucTtktForm
	 * @param cuocTtktId
	 */
	private void loadBanGiaoHoSoLuuTru(ApplicationContext appContext, KetThucTtktForm ketThucTtktForm, String cuocTtktId, HttpServletRequest request) throws Exception {
		TtktCmNhanTraHstl nhanTraHstl = TtktService.getNhanTraHsTl(appContext, cuocTtktId);
		ketThucTtktForm.setDiaDiemBanGiaoHoSoLuuTru(KtnbUtil.getTenTinhByMaCqt(appContext, CuocTtktService.getCuocTtkt(appContext, cuocTtktId).getIdDonViBi()));
		if (nhanTraHstl != null) {
			ketThucTtktForm.setIdDaiDienBenGiaoBanGianHoSoLuuTru(nhanTraHstl.getIdDaiDienBenGiao());
			ketThucTtktForm.setIdDaiDienBenNhanBanGianHoSoLuuTru(nhanTraHstl.getIdDaiDienBenNhan());
			ketThucTtktForm.setIdBanGiaoHoSoLuuTru(nhanTraHstl.getId());
			ketThucTtktForm.setThoiDiemBatDauBanGianHoSoLuuTru(Formater.date2strDateTimeForNV(nhanTraHstl.getThoiDiemBatDau()));
			ketThucTtktForm.setDiaDiemBanGiaoHoSoLuuTru(nhanTraHstl.getDiaDiemBanGiao());
			ketThucTtktForm.setBaoCaoBanGianHoSoLuuTru(nhanTraHstl.getBaoCao());
			ketThucTtktForm.setHoSoBanGianHoSoLuuTru(nhanTraHstl.getHoSo());
			ketThucTtktForm.setThoiDiemKetThucBanGianHoSoLuuTru(Formater.date2strDateTimeForNV(nhanTraHstl.getThoiDiemKetThuc()));
			// Dai dien ben giao

			Collection daiDienBenGiao = nhanTraHstl.getDaiDienBenGiao();
			if (!Formater.isNull(daiDienBenGiao)) {
				TtktCmThanhPhanThamDu[] arrDaiDienBenGiao = new TtktCmThanhPhanThamDu[daiDienBenGiao.size()];
				int index = 0;
				Iterator iter = daiDienBenGiao.iterator();
				while (iter.hasNext()) {
					arrDaiDienBenGiao[index] = (TtktCmThanhPhanThamDu) iter.next();
					index++;
				}
				ketThucTtktForm.setArrDaiDienBenGiaoHstlLuuTru(arrDaiDienBenGiao);

			}

			// Dai dien ben nhan
			Collection daiDienBenNhan = nhanTraHstl.getDaiDienBenNhan();
			if (!Formater.isNull(daiDienBenNhan)) {
				TtktCmThanhPhanThamDu[] arrDaiDienBenNhan = new TtktCmThanhPhanThamDu[daiDienBenNhan.size()];
				int index = 0;
				Iterator iter = daiDienBenNhan.iterator();
				while (iter.hasNext()) {
					arrDaiDienBenNhan[index] = (TtktCmThanhPhanThamDu) iter.next();
					index++;
				}
				ketThucTtktForm.setArrDaiDienBenNhanHstlLuuTru(arrDaiDienBenNhan);

			}
		}

	}

	/**
	 * @param appContext
	 * @param ketThucTtktForm
	 * @param cuocTtktId
	 */
	private void loadHopRutKinhNghiemDoan(ApplicationContext appContext, KetThucTtktForm ketThucTtktForm, String cuocTtktId) throws Exception {
		TtktCmBienBan bienBanHopRutKinhNghiem = TtktService.getBbHopRutKinhNghiemDoan(appContext, cuocTtktId);
		ketThucTtktForm.setDiaDiemHopRutKinhNghiem(KtnbUtil.getTenTinhByMaCqt(appContext, CuocTtktService.getCuocTtkt(appContext, cuocTtktId).getIdDonViBi()));
		if (bienBanHopRutKinhNghiem != null) {
			ketThucTtktForm.setThoiDiemBatDauHopRutKinhNghiem(Formater.date2strDateTimeForNV(bienBanHopRutKinhNghiem.getThoiDiemBatDau()));
			ketThucTtktForm.setDiaDiemHopRutKinhNghiem(bienBanHopRutKinhNghiem.getDiaDiem());
			ketThucTtktForm.setVeViecHopRutKinhNghiem(bienBanHopRutKinhNghiem.getVeViec());
			ketThucTtktForm.setNoiDungHopRutKinhNghiem(bienBanHopRutKinhNghiem.getNoiDung());
			ketThucTtktForm.setThoiDiemKetThucHopRutKinhNghiem(Formater.date2strDateTimeForNV(bienBanHopRutKinhNghiem.getThoiDiemKetThuc()));
			ketThucTtktForm.setIdBienBanHopRutKinhNghiem(bienBanHopRutKinhNghiem.getId());

			Collection thanhPhanThamDu = bienBanHopRutKinhNghiem.getThanhPhanThamDu();
			if (!Formater.isNull(thanhPhanThamDu)) {
				TtktCmThanhPhanThamDu[] arrthanhPhanThamDu = new TtktCmThanhPhanThamDu[thanhPhanThamDu.size()];
				int index = 0;
				Iterator iter = thanhPhanThamDu.iterator();
				while (iter.hasNext()) {
					arrthanhPhanThamDu[index] = (TtktCmThanhPhanThamDu) iter.next();
					index++;
				}
				ketThucTtktForm.setThanhPhanThamDuHopRutKinhNghiem(arrthanhPhanThamDu);
			}
		}
	}

	/**
	 * @param appContext
	 * @param ketThucTtktForm
	 * @param cuocTtktId
	 */
	private void loadKetLuanKetQua(ApplicationContext appContext, KetThucTtktForm ketThucTtktForm, String cuocTtktId, HttpServletRequest request) throws Exception {
		try {
			// Du thao ket qua
			TtktThBbChitietvatonghop duThaoKetQua = TtktService.getDuThaoKetQua(appContext, cuocTtktId);
			if (duThaoKetQua != null) {
				ketThucTtktForm.setIdDuThaoKetQua(duThaoKetQua.getId());
			}
			// Ket qua
			TtktThBbChitietvatonghop ketQua = TtktService.getKetQua(appContext, cuocTtktId);
			if (ketQua != null) {
				ketThucTtktForm.setIdKetQua(ketQua.getId());
				ketThucTtktForm.setNgayGuiBaoCaoKetQuaVaDuThaoKetLuan(Formater.date2str(ketQua.getTgianThTuNgay()));
			}
			// Du thao ket luan
			TtktThBbChitietvatonghop duThaoKetLuan = TtktService.getDuThaoKetLuan(appContext, cuocTtktId);
			if (duThaoKetLuan != null) {
				ketThucTtktForm.setIdDuThaoKetLuan(duThaoKetLuan.getId());
				if (duThaoKetLuan.getTgianThTuNgay() != null)
					ketThucTtktForm.setNgayRaKetLuan(Formater.date2str(duThaoKetLuan.getTgianThTuNgay()));
			}
			// Ket luan
			TtktThBbChitietvatonghop ketLuan = TtktService.getKetLuan(appContext, cuocTtktId);
			if (ketLuan != null) {
				ketThucTtktForm.setIdKetLuan(ketLuan.getId());
				ketThucTtktForm.setNgayRaKetLuan(Formater.date2str(ketLuan.getTgianThTuNgay()));
				ketThucTtktForm.setSoKetLuan(ketLuan.getSoKetLuan());
			}
			// Ketluan sang BC
			TtktKtKetLuanChuyenBC obj = TtktService.getKetLuanSangBC(appContext, cuocTtktId);
			if (obj != null) {
				ketThucTtktForm.setDcID(obj.getId());
				ketThucTtktForm.setIdCuocTtkt(obj.getIdCuocTtkt());
				ketThucTtktForm.setDcKienNghiKhac(obj.getKienNghiKhac() == null ? "" : obj.getKienNghiKhac().toString());

				ketThucTtktForm.setDcKiemTraSauTTKT(obj.getKtraSauTtkt() != null && obj.getKtraSauTtkt().intValue() == 1 ? "1" : "0");
				ketThucTtktForm.setDcMoTa(obj.getMoTa());
				ketThucTtktForm.setDcSoDonViTTKT(obj.getSoDviDuocTtkt() == null ? "" : obj.getSoDviDuocTtkt().toString());
				ketThucTtktForm.setDcSoDonViSaiPham(obj.getSoDviSaiPham() == null ? "" : obj.getSoDviSaiPham().toString());
				ketThucTtktForm.setDcSoSDBC_QTQC(obj.getSoSdbsQtqc() == null ? "" : obj.getSoSdbsQtqc().toString());
				ketThucTtktForm.setDcSoSDBS_VPBQ(obj.getSoSdbsVbpq() == null ? "" : obj.getSoSdbsVbpq().toString());

				ketThucTtktForm.setDcSoTienKnghiThuHtraSpKhac(obj.getSoTienKnghiThuHtraSpKhac() == null ? "" : Formater.number2StringIgnorePre(obj.getSoTienKnghiThuHtraSpKhac().doubleValue()));
				ketThucTtktForm.setDcSoTienThuCongChucThue(obj.getSoTienThuCongChucThue() == null ? "" : Formater.number2StringIgnorePre(obj.getSoTienThuCongChucThue().doubleValue()));
				ketThucTtktForm.setDcSoTienThuNguoiNopThue(obj.getSoTienThuNguoiNopThue() == null ? "" : Formater.number2StringIgnorePre(obj.getSoTienThuNguoiNopThue().doubleValue()));
				ketThucTtktForm.setDcSoTienNopCongChucTHue(obj.getSoTienTraCongChucThue() == null ? "" : Formater.number2StringIgnorePre(obj.getSoTienTraCongChucThue().doubleValue()));
				ketThucTtktForm.setDcSoTienNopNguoiNopThue(obj.getSoTienTraNguoiNopThue() == null ? "" : Formater.number2StringIgnorePre(obj.getSoTienTraNguoiNopThue().doubleValue()));
				ketThucTtktForm.setDcSoTTKTThue(obj.getSoTtktThue() == null ? "" : obj.getSoTtktThue().toString());

				ketThucTtktForm.setDcTsKlTtktQdxlDaKtra(obj.getTsKlTtktQdxlDaKtra() == null ? "" : obj.getTsKlTtktQdxlDaKtra().toString());
				ketThucTtktForm.setDcTSTienThuCongChucThue(obj.getTsTienThuCongChucThue() == null ? "" : Formater.number2StringIgnorePre(obj.getTsTienThuCongChucThue().doubleValue()));

				ketThucTtktForm.setDcTsTienThuHtraSpKhac(obj.getTsTienThuHtraSpKhac() == null ? "" : Formater.number2StringIgnorePre(obj.getTsTienThuHtraSpKhac().doubleValue()));
				ketThucTtktForm.setDcTSTienThuNguoiNopThue(obj.getTsTienThuNguoiNopThue() == null ? "" : Formater.number2StringIgnorePre(obj.getTsTienThuNguoiNopThue().doubleValue()));
				ketThucTtktForm.setDcTSTienTraCongChucThue(obj.getTsTienTraCongChucThue() == null ? "" : Formater.number2StringIgnorePre(obj.getTsTienTraCongChucThue().doubleValue()));
				ketThucTtktForm.setDcTSTienTraNguoiNopThue(obj.getTsTienTraNguoiNopThue() == null ? "" : Formater.number2StringIgnorePre(obj.getTsTienTraNguoiNopThue().doubleValue()));
				ketThucTtktForm.setDcXuLiHanhChinhCongVienChucThue(obj.getXlhcCongVienChucThue() == null ? "" : obj.getXlhcCongVienChucThue().toString());
				ketThucTtktForm.setDcXuLiHanhChinhDoiTuongKhac(obj.getXlhcDoiTuongKhac() == null ? "" : obj.getXlhcDoiTuongKhac().toString());
				ketThucTtktForm.setDcXLHSSoNguoi(obj.getXlhsSoNguoi() == null ? "" : obj.getXlhsSoNguoi().toString());
				ketThucTtktForm.setDcXLHSSoVuViec(obj.getXlhsSoVuViec() == null ? "" : obj.getXlhsSoVuViec().toString());
				ketThucTtktForm.setSoTienDaThuHauKiem(obj.getSoTienDaThuHauKiem() == null ? "" : Formater.number2StringIgnorePre(obj.getSoTienDaThuHauKiem().doubleValue()));
				ketThucTtktForm.setDcSoTienThuDoiTuongKhac(obj.getSoTienThuDoiTuongKhac() == null ? "" : Formater.number2StringIgnorePre(obj.getSoTienThuDoiTuongKhac().doubleValue()));
				ketThucTtktForm.setDcSoTienNopDoiTuongKhac(obj.getSoTienNopDoiTuongKhac() == null ? "" : Formater.number2StringIgnorePre(obj.getSoTienNopDoiTuongKhac().doubleValue()));
				//ketThucTtktForm.setSoKetLuan(obj.getSoKetLuan());
			} else {
				ketThucTtktForm.setDcSoDonViTTKT(TtktService.getSoDonViDuocTtKt(appContext, cuocTtktId));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param appContext
	 * @param ketThucTtktForm
	 * @param cuocTtktId
	 */
	private void loadThongBaoKetThuc(HttpServletRequest request, ApplicationContext appContext, KetThucTtktForm ketThucTtktForm, String cuocTtktId) throws Exception {
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, cuocTtktId);
		if (cuocTtkt != null) {
			if (Formater.isNull(cuocTtkt.getNoiRaThongBaoKetThuc()))
				ketThucTtktForm.setNoiRaThongBaoKetThuc(KtnbUtil.getTenTinhByMaCqt(appContext, CuocTtktService.getCuocTtkt(appContext, cuocTtktId).getIdDonViBi()));
			else
				ketThucTtktForm.setNoiRaThongBaoKetThuc(cuocTtkt.getNoiRaThongBaoKetThuc());
			ketThucTtktForm.setNgayRaThongBaoKetThuc(Formater.date2str(cuocTtkt.getNgayRaThongBaoKetThuc()));
			ketThucTtktForm.setNgayKetThuc(Formater.date2str(cuocTtkt.getNgayKetThuc()));
			ketThucTtktForm.setIdDonViTienHanh(cuocTtkt.getIdDonViTh());
		}

	}

	private void loadKqThucHienKl(ApplicationContext appContext, KetThucTtktForm form, String cuocTtktId) throws Exception {
		TtktKtBcKqThucHienKL obj = TtktService.getKqThucHienKl(appContext, cuocTtktId);
		if (obj != null) {
			form.setIdKqThucHienKl(obj.getId());
			form.setIdCuocTtkt(obj.getIdCuocTtkt());
			form.setKetThucTdoiThanh(obj.getKetThucTdoiThanh() != null && obj.getKetThucTdoiThanh().intValue() == 1 ? true : false);
			form.setKienNghiKhac(obj.getKienNghiKhac() == null ? "" : obj.getKienNghiKhac().toString());

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			form.setNgayNhanBckq(obj.getNgayNhanBckq() == null ? "" : sdf.format(obj.getNgayNhanBckq()));
			form.setNgayCapNhat(obj.getNgayCapNhat() == null ? "" : sdf.format(obj.getNgayCapNhat()));
			form.setSoCachChuc(obj.getSoCachChuc() == null ? "" : obj.getSoCachChuc().toString());
			form.setSoCanhCao(obj.getSoCanhCao() == null ? "" : obj.getSoCanhCao().toString());
			form.setSoDviDuocTtkt(obj.getSoDviDuocTtkt() == null ? "" : obj.getSoDviDuocTtkt().toString());
			form.setSoDviSaiPham(obj.getSoDviSaiPham() == null ? "" : obj.getSoDviSaiPham().toString());
			form.setSoGiangChuc(obj.getSoGiangChuc() == null ? "" : obj.getSoGiangChuc().toString());
			form.setSoHaBacLuong(obj.getSoHaBacLuong() == null ? "" : obj.getSoHaBacLuong().toString());
			form.setSoKhac(obj.getSoKhac() == null ? "" : obj.getSoKhac().toString());
			form.setSoKhienTrach(obj.getSoKhienTrach() == null ? "" : obj.getSoKhienTrach().toString());
			form.setSoKiemDiem(obj.getSoKiemDiem() == null ? "" : obj.getSoKiemDiem().toString());
			form.setSoSdbsQtqc(obj.getSoSdbsQtqc() == null ? "" : obj.getSoSdbsQtqc().toString());
			form.setSoSdbsVbpq(obj.getSoSdbsVbpq() == null ? "" : obj.getSoSdbsVbpq().toString());
			form.setSoThoiViec(obj.getSoThoiViec() == null ? "" : obj.getSoThoiViec().toString());
			form.setSoTienThuHtraSpKhac(obj.getSoTienThuHtraSpKhac() == null ? "" : Formater.num2str(obj.getSoTienThuHtraSpKhac().doubleValue()));
			form.setSoTtktThue(obj.getSoTtktThue() == null ? "" : obj.getSoTtktThue().toString());
			form.setTienHoanTraCongChucThue(obj.getTienHoanTraCongChucThue() == null ? "" : Formater.num2str(obj.getTienHoanTraCongChucThue().doubleValue()));
			form.setTienHoanTraNguoiNopThue(obj.getTienHoanTraNguoiNopThue() == null ? "" : Formater.num2str(obj.getTienHoanTraNguoiNopThue().doubleValue()));
			form.setTienHoanTraTtktThue(obj.getTienHoanTraTtktThue() == null ? "" : Formater.num2str(obj.getTienHoanTraTtktThue().doubleValue()));
			form.setTienPhaiThuCongChucThue(obj.getTienPhaiThuCongChucThue() == null ? "" : Formater.num2str(obj.getTienPhaiThuCongChucThue().doubleValue()));
			form.setTienPhaiThuNguoiNopThue(obj.getTienPhaiThuNguoiNopThue() == null ? "" : Formater.num2str(obj.getTienPhaiThuNguoiNopThue().doubleValue()));
			form.setTienPhaiThuTtktThue(obj.getTienPhaiThuTtktThue() == null ? "" : Formater.num2str(obj.getTienPhaiThuTtktThue().doubleValue()));
			form.setSoXlhsCoAn(obj.getSoXlhsCoAn() == null ? "" : obj.getSoXlhsCoAn().toString());
		} else {
			form.setSoDviDuocTtkt(TtktService.getSoDonViDuocTtKt(appContext, cuocTtktId));
		}
	}
}
