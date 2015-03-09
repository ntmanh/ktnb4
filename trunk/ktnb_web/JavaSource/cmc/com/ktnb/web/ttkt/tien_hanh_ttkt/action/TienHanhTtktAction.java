package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThayDoiTvd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBanGiaoHstlChoTd;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBbChitietvatonghop;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThCongBoQd;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThNhatKy;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbCache;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.dung_chung.form.ThayDoiThanhVienDoanForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.TienHanhTtktForm;

import com.jacob.com.Dispatch;

/**
 * Form bean for a Struts application.
 * 
 * @version 1.0
 * @author
 */
public class TienHanhTtktAction extends BaseDispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		TienHanhTtktForm tienHanhTtktForm = (TienHanhTtktForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String cuocTtktId = request.getParameter("cuocTtktId");
		if (!Formater.isNull(cuocTtktId)) {
			loadDefaultForm(cuocTtktId, tienHanhTtktForm, appContext, request, reponse);
		} else {
			String method = request.getParameter("method");
			if ("save".equals(method)) {
				saveTienHanhTtkt(request, reponse, appContext, tienHanhTtktForm);
				return null;
			} else if ("in".equals(method)) {
				inTienHanhTtkt(request, appContext, tienHanhTtktForm, reponse);
				return null;
			} else if ("xoaBbChiTiet".equals(method) || "xoaBgHstlChoTd".equals(method)) {
				String id = request.getParameter("id");
				PrintWriter out = reponse.getWriter();
				try {
					if ("xoaBbChiTiet".equals(method))
						TtktService.deleteBbChiTietById(appContext, id);
					else
						TtktService.deleteBanGiaoHstlChoTdById(appContext, id);

					out.print("cucsess");

				} catch (Exception e) {

				}

				out.flush();
				out.close();
				return null;

			} else if ("saveBbHsTlChoTd".equals(method)) {
				if (Formater.isNull(TtktService.getBienBanChiTiet(appContext, tienHanhTtktForm.getIdCuocTtkt()))) {
					writeMaLoi(reponse, "1");
					return null;
				}
				TtktThBanGiaoHstlChoTd banGiaoHstlChoTd = createGiaoHstlChoTd(request,appContext);
				PrintWriter out = reponse.getWriter();
				TtktService.saveBanGiaoHstlChoTd(appContext, banGiaoHstlChoTd);

				out.print(TtktService.saveBanGiaoHstlChoTd(appContext, banGiaoHstlChoTd));
				out.flush();
				out.close();
				return null;
			}
		}
		// Danh sach thanh vien doan
		loadDsTvDoan(cuocTtktId, request);
		//loadCongBoQuyetDinh(request, tienHanhTtktForm, appContext, cuocTtktId);
		try{
		request.setAttribute("ngayRaQuyetDnh",Formater.objectDate2Str(TtktService.getQuyetDinh(cuocTtktId, appContext).getNgayRaQuyetDnh()));
		}catch (Exception e) {
			// TODO: handle exception
		}
		return mapping.findForward("success");
	}

	/**
	 * @param request
	 * @param appContext
	 * @param tienHanhTtktForm
	 */
	
	/**
	 *
	 * Method : inTienHanhTtkt
	 * Des : chon version
	 * */
	
	private void inTienHanhTtkt(HttpServletRequest request, ApplicationContext appConText, TienHanhTtktForm tienHanhTtktForm, HttpServletResponse reponse) throws Exception {
		CuocTtktService service = new CuocTtktService();
		String cuocTtktId=tienHanhTtktForm.getIdCuocTtkt();
		System.out.println("Id cuoc ttkt : "+cuocTtktId );
		if(!Formater.isNull(cuocTtktId))
		{
			if("4".equals(service.getDonVerionTtkt(appConText, cuocTtktId)))
			{
				inTienHanhTtktv4(request, appConText, tienHanhTtktForm, reponse);
			}
			else inTienHanhTtktv3(request, appConText, tienHanhTtktForm, reponse);
		}
		else 
		{
			if("4".equals(Constants.APP_DEP_VERSION))
				inTienHanhTtktv4(request, appConText, tienHanhTtktForm, reponse);
			else inTienHanhTtktv3(request, appConText, tienHanhTtktForm, reponse);
		}
	}
	
	
	/**
	 * Des : ktnb v3
	 * */
	private void inTienHanhTtktv3(HttpServletRequest request, ApplicationContext appContext, TienHanhTtktForm tienHanhTtktForm, HttpServletResponse response) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		String type = request.getParameter("type");
		if ("downloadMau34".equals(type)) {
			fileIn = request.getRealPath("/docin") + "\\TTNB34.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB34_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			System.out.println("Da chay vao day");
			fileTemplate = "ttnb34";
			String idCuocTtkt = tienHanhTtktForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);
			// Lay cac thong tin tu quyet dinh
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
			String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
			
			try {
				word = new MsWordUtils(fileIn, fileOut);
				TtktCbQd qdTtkt = TtktService.getQuyetDinh(idCuocTtkt, appContext);
				
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", qdTtkt.getSoQuyetDinh());
				String ngayqd = Formater.date2str(qdTtkt.getNgayRaQuyetDnh());
				//String[] arrngayqd = ngayqd.split("/");
				//word.put("[ngay_quyet]", "ng\u00E0y " + arrngayqd[0] + " th\u00E1ng " + arrngayqd[1] + " n\u0103m " + arrngayqd[2]);
				word.put("[ngay_qd]", Formater.getDateForPrint(ngayqd));
				word.put("[thu_truong_qd]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				for(int i=0;i<3;i++)
					word.put("[ttkt]", hinhThuc);
				
				//----------------------------danh sach thanh vien doan---------------------------------//
				Dispatch table = word.openTable(2);
				Collection dsThanhVienDoan = TtktService.getDanhSachThanhVienDoan(idCuocTtkt);
				String cbDsThanhVienDoan = ""; 
				// thanh vien doan
				int j=0;
				Iterator iter = dsThanhVienDoan.iterator();
				while (iter.hasNext()) {
					TtktCbChiTietDsTvDoan thanhVienDoan = (TtktCbChiTietDsTvDoan) iter.next();
					word.addCellTable(table, j + 1, 1,"- \u00D4ng (b\u00E0): "+ thanhVienDoan.getTenCanBo());
					//chuc vu trong doan
					String chucVuTrongDoan = thanhVienDoan.getChucVuTrongDoan();
					if ("Truong doan".equals(chucVuTrongDoan))
						chucVuTrongDoan = "Tr\u01B0\u1EDFng \u0111o\u00E0n";
					else if ("Pho doan".equals(chucVuTrongDoan))
						chucVuTrongDoan = "Ph\u00F3 \u0111o\u00E0n";
					else
						chucVuTrongDoan = "Th\u00E0nh vi\u00EAn \u0111o\u00E0n";
					word.addCellTable(table, j + 1, 2,"- Ch\u1EE9c v\u1EE5: " + chucVuTrongDoan);
					word.addRowTable(table, dsThanhVienDoan.size());
					j++;
				}
				
				word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				for(int i=0;i<7;i++)
					word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc.toUpperCase());
				word.put("[ttkt]", hinhThuc.toUpperCase());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB34", ".doc", response);
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {				
				try { 
					word.saveAndClose();
				} catch (Exception e) {
					
				}
			}
		}else if ("congBoQd".equals(type)) { // In cong bo (ngon, chuan)
			fileTemplate = "ttnb16";
			TtktCmThanhPhanThamDu[] arrdaidiencoquanthue = tienHanhTtktForm.getArrDaiDienCqtBanHanhQD();
			TtktCmThanhPhanThamDu[] arrdaidiencoquancaptren = tienHanhTtktForm.getArrDaiDienCqqlCapTren();
			if(arrdaidiencoquanthue !=null&&arrdaidiencoquancaptren!=null){
				fileIn = request.getRealPath("/docin") + "\\TTNB16.doc";
				fileOut = request.getRealPath("/docout") + "\\TTNB16_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
				try {
					word = new MsWordUtils(fileIn, fileOut);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				inMau16v3(request, appContext, tienHanhTtktForm, response, word, fileIn, fileOut,0);
			}
			if(arrdaidiencoquanthue ==null&&arrdaidiencoquancaptren!=null){
				fileIn = request.getRealPath("/docin") + "\\TTNB16_1.doc";
				fileOut = request.getRealPath("/docout") + "\\TTNB16_1_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
				try {
					word = new MsWordUtils(fileIn, fileOut);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				inMau16v3(request, appContext, tienHanhTtktForm, response, word, fileIn, fileOut,1);
			}
			if(arrdaidiencoquanthue !=null&&arrdaidiencoquancaptren==null){
				fileIn = request.getRealPath("/docin") + "\\TTNB16_2.doc";
				fileOut = request.getRealPath("/docout") + "\\TTNB16_2_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
				try {
					word = new MsWordUtils(fileIn, fileOut);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				inMau16v3(request, appContext, tienHanhTtktForm, response, word, fileIn, fileOut,2);
			}
			if(arrdaidiencoquanthue ==null&&arrdaidiencoquancaptren==null){
				fileIn = request.getRealPath("/docin") + "\\TTNB16_3.doc";
				fileOut = request.getRealPath("/docout") + "\\TTNB16_3_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
				try {
					word = new MsWordUtils(fileIn, fileOut);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				inMau16v3(request, appContext, tienHanhTtktForm, response, word, fileIn, fileOut,3);
			}

		} else if ("nhatKy".equals(type)) { // In nhat ky
			fileIn = request.getRealPath("/docin") + "\\TTNB15.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB15_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			fileTemplate = "ttnb15";
			String idCuocTtkt = request.getParameter("idCuocTtkt");
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtkt(appContext, idCuocTtkt);
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhThuc1 = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
			word = new MsWordUtils(fileIn, fileOut);

			StringBuffer sb = new StringBuffer(hinhThuc);
			word.put("[ttkt]", hinhThuc.toUpperCase());
			word.put("[ttkt]", sb.toString());
			if (Formater.isNull(cuocTtkt.getTenDonViTh())) {
				word.put("[ten_cqt_tien_hanh]", "-  \n\t- \n\t" + KtnbUtil.inFieldNull(114));
			} else {
				word.put("[ten_cqt_tien_hanh]", cuocTtkt.getTenDonViTh());
			}
			word.put("[ttkt]", sb.toString());
			word.put("[ttkt]", sb.toString());
			TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appContext);
			word.put("[so_qd]", cbQd.getSoQuyetDinh());
			word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			word.put("[thu_truong_qd]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
			String cac_qd_td_tvd = getDsThayDoiTvd(appContext, idCuocTtkt);
			if (Formater.isNull(cac_qd_td_tvd)) {
				word.put("[cac_quyet_dinh_thay_doi_thanh_vien_doan]", "");
			} else {
				word.put("[cac_quyet_dinh_thay_doi_thanh_vien_doan]", "\n" + cac_qd_td_tvd.substring(0, cac_qd_td_tvd.length() - 1));
			}
			word.put("[ttkt]", sb.toString());
			StringBuffer sb1 = new StringBuffer("\u00D4ng (b\u00E0): " + cuocTtkt.getTenTruongDoan());
			word.put("[ten_truong_doan]", sb1.toString());
			String chucvu_truongdoan = null;
			sb1 = new StringBuffer("");
			Collection dsChiTietTvd = TtktService.getDsTvd(idCuocTtkt, appContext).getChiTietDanhSachTV();
			Iterator iterator = dsChiTietTvd.iterator();
			while (iterator.hasNext()) {
				TtktCbChiTietDsTvDoan thanhVien = (TtktCbChiTietDsTvDoan) iterator.next();
				if (thanhVien.getChucVuTrongDoan().equals("Truong doan")) {
					chucvu_truongdoan = thanhVien.getChucVu();
				}
			}
			word.put("[chuc_vu_truong_doan]", chucvu_truongdoan);
			word.put("[ttkt]", sb.toString());
			int j = 0; // dem so luong thanh vien
			StringBuffer ds_thanhviendoan = new StringBuffer(""); // danh sach thanh vien doan
			// mo table trong Jacob Word
			Dispatch table = word.openTable(1);
			iterator = dsChiTietTvd.iterator();
			while (iterator.hasNext()) {
				TtktCbChiTietDsTvDoan thanhVien = (TtktCbChiTietDsTvDoan) iterator.next();
				if (!thanhVien.getChucVuTrongDoan().equals("Truong doan")) {
					ds_thanhviendoan.append((j + 1) + ". " + thanhVien.getTenCanBo() + "\n");
					// sb1.append("- \u00D4ng (b\u00E0): ");
					String chucVuCoDau = thanhVien.getChucVuTrongDoan().equals("Pho doan") ? "Ph\u00F3 \u0111o\u00E0n" : "Th\u00E0nh vi\u00EAn \u0111o\u00E0n";
					// sb1.append(thanhVien.getTenCanBo() + ", " + chucVuCoDau);
					// sb1.append("\n");
					word.addCellTable(table, j + 1, 1, "- \u00D4ng (b\u00E0): " + thanhVien.getTenCanBo());
					word.addCellTable(table, j + 1, 2, "- " + thanhVien.getChucVu());
					word.addCellTable(table, j + 1, 3, "- " + chucVuCoDau);
					word.addRowTable(table, dsChiTietTvd.size() - 1);
					j++;
				}
			}
			// word.put("[ten_thanh_vien]",sb1.toString());
			word.put("[ttkt]", sb.toString());
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
			word.put("[ttkt]", sb.toString().toUpperCase());

			StringBuffer noiDungNk = new StringBuffer("");
			TtktThNhatKy[] arrNhatKy = tienHanhTtktForm.getArrNhatKy();
			for (int i = 0; i < arrNhatKy.length; i++) {
				String[] ngayLamViec = arrNhatKy[i].getNgayStr().split("/");
				noiDungNk.append((i + 1) + ". Ng\u00E0y " + ngayLamViec[0] + " th\u00E1ng " + ngayLamViec[1] + " n\u0103m " + ngayLamViec[2]);
				noiDungNk.append("\n");
				noiDungNk.append(" ");
				noiDungNk.append(arrNhatKy[i].getNoiDung());
				noiDungNk.append("\n");
			}
			word.put("[noi_dung]", noiDungNk.toString().substring(0, noiDungNk.toString().length() - 1));// xoa di ki tu xuong dong cuoi cung
			if (Formater.isNull(tienHanhTtktForm.getNdKhac())) {
				String defaultNull = KtnbUtil.inFieldNull(115);
				word.put("[noi_dung_khac]", defaultNull + "\n" + defaultNull + "\n" + defaultNull);
			} else
				word.put("[noi_dung_khac]", tienHanhTtktForm.getNdKhac());
			word.put("[ttkt]", sb.toString().toUpperCase());
			word.put("[ttkt]", sb.toString().toUpperCase());
			word.put("[ds_thanhvien]", ds_thanhviendoan.toString());
			word.put("[truong_doan]", cuocTtkt.getTenTruongDoan());

		} else if ("banGiaoHstlChoTd".equals(type)) { // in ban giao hstl cho
			// truong doan (ngon,
			// chuan)
			fileIn = request.getRealPath("/docin") + "\\TTNB18A.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB18A_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			fileTemplate = "ttnb18a";
			String idCuocTtkt = tienHanhTtktForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);

			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
			word = new MsWordUtils(fileIn, fileOut);

			TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appContext);
			// thu truong co quan thue doi tuong thanh tra kiem tra\
			word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
			StringBuffer sb = new StringBuffer("\u0110o\u00E0n ");
			sb = new StringBuffer("\u0110O\u00C0N ");
			sb.append(hinhthuc_inT);
			sb.append(" Q\u0110 S\u1ED0 ");
			sb.append(cbQd.getSoQuyetDinh()); // so doan thanh tra, kiem tra
			word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
			word.put("[ten_bc]", "BI\u00CAN B\u1EA2N"); //
			String idTvd = request.getParameter("idTvd");
			if (Formater.isNull(idTvd))
				throw new Exception("Chua chon thanh vien doan nao");
			TtktThBanGiaoHstlChoTd thanhVienDoanCanIn = null;
			TtktThBanGiaoHstlChoTd[] arrBanGiaoHstlChoTruongDoan = tienHanhTtktForm.getArrBanGiaoHstlChoTruongDoan();
			for (int i = 0; i < arrBanGiaoHstlChoTruongDoan.length; i++) {
				if (arrBanGiaoHstlChoTruongDoan[i].getIdCanBo().equals(idTvd)) {
					thanhVienDoanCanIn = arrBanGiaoHstlChoTruongDoan[i];
					break;
				}
			}
			word.put("[thoi_diem_bat_dau]", KtnbUtil.getHour(thanhVienDoanCanIn.getThoiDiemBatDauBanGiaoStr()));
			word.put("[dia_diem]", thanhVienDoanCanIn.getDiaDiemBanGiao());
			sb = new StringBuffer(hinhThuc);
			word.put("[ttkt]", sb.toString());
			word.put("[so_quyet_dinh]", cbQd.getSoQuyetDinh());
			String ngayqd = Formater.date2str(cbQd.getNgayRaQuyetDnh());
			String[] arrngayqd = ngayqd.split("/");
			word.put("[ngay_quyet]", "ng\u00E0y " + arrngayqd[0] + " th\u00E1ng " + arrngayqd[1] + " n\u0103m " + arrngayqd[2]);

			word.put("[chuc_danh_thu_truong]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
			word.put("[ttkt]", sb.toString());
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());

			StringBuffer sb1 = new StringBuffer("- \u00D4ng (b\u00E0): " + thanhVienDoanCanIn.getTenCanBo());
			sb1.append("  \t Ch\u1EE9c v\u1EE5: " + thanhVienDoanCanIn.getChucVuTrongDoan());
			word.put("[thanh_vien_ben_giao]", sb1.toString());
			Collection dsChiTietTvd = TtktService.getDsTvd(idCuocTtkt, appContext).getChiTietDanhSachTV();
			Iterator iterator = dsChiTietTvd.iterator();
			while (iterator.hasNext()) {
				TtktCbChiTietDsTvDoan thanhVien = (TtktCbChiTietDsTvDoan) iterator.next();
				if (thanhVien.getChucVuTrongDoan().equals("Truong doan")) {
					sb1 = new StringBuffer("- \u00D4ng (b\u00E0): " + thanhVien.getTenCanBo());
					sb1.append("  \t Ch\u1EE9c v\u1EE5: Tr\u01B0\u1EDFng \u0111o\u00E0n");
				}
			}
			word.put("[thanh_vien_ben_nhan]", sb1.toString());
			word.put("[bao_cao]", tienHanhTtktForm.getBaoCao());
			word.put("[ho_so_tai_lieu]", tienHanhTtktForm.getHoSoTaiLieu());
			String thoidiemketthuc = thanhVienDoanCanIn.getThoiDiemKetThucBanGiaoStr();
			// TODO: Loc moi Code them
			if (thanhVienDoanCanIn.getThoiDiemKetThucBanGiaoStr().equals("")) {
				word.put("[thoi_diem_giao_nhan]", ".....,ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			} else {
				String[] arrketthuc = thoidiemketthuc.split("/");
				word.put("[thoi_diem_giao_nhan]", KtnbUtil.getHour(thanhVienDoanCanIn.getThoiDiemKetThucBanGiaoStr()));
			}
		}

		if (Formater.isNull(fileTemplate))
			try {
				throw new Exception("Chua chon file template");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		try {
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau " + fileTemplate, ".doc", response);
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
	
	/**
	 * Edit : ntmanh
	 * Method : inTienHanhTtkt
	 * Des : ktnb v4
	 * */
	private void inTienHanhTtktv4(HttpServletRequest request, ApplicationContext appContext, TienHanhTtktForm tienHanhTtktForm, HttpServletResponse response) throws Exception {
		System.out.println("This is ktnb v4");
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;
		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		String type = request.getParameter("type");
		if ("downloadMau33".equals(type)) {
			fileIn = request.getRealPath("/docin/v4") + "\\TTNB33.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB33_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			fileTemplate = "ttnb33";
			String idCuocTtkt = tienHanhTtktForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);
			// Lay cac thong tin tu quyet dinh
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
			String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
			
			try {
				word = new MsWordUtils(fileIn, fileOut);
				TtktCbQd qdTtkt = TtktService.getQuyetDinh(idCuocTtkt, appContext);
				
				//word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//word.put("[ttkt]", hinhThuc);
				word.put("[so_qd]", qdTtkt.getSoQuyetDinh());
				String ngayqd = Formater.date2str(qdTtkt.getNgayRaQuyetDnh());
				//String[] arrngayqd = ngayqd.split("/");
				//word.put("[ngay_quyet]", "ng\u00E0y " + arrngayqd[0] + " th\u00E1ng " + arrngayqd[1] + " n\u0103m " + arrngayqd[2]);
				word.put("[ngay_qd]", Formater.getDateForPrint(ngayqd));
				word.put("[thu_truong_qd]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
				//word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//for(int i=0;i<3;i++)
					//word.put("[ttkt]", hinhThuc);
				
				//----------------------------danh sach thanh vien doan---------------------------------//
				Dispatch table = word.openTable(2);
				Collection dsThanhVienDoan = TtktService.getDanhSachThanhVienDoan(idCuocTtkt);
				String cbDsThanhVienDoan = ""; 
				// thanh vien doan
				int j=0;
				Iterator iter = dsThanhVienDoan.iterator();
				while (iter.hasNext()) {
					TtktCbChiTietDsTvDoan thanhVienDoan = (TtktCbChiTietDsTvDoan) iter.next();
					word.addCellTable(table, j + 1, 1,"- \u00D4ng (b\u00E0): "+ thanhVienDoan.getTenCanBo());
					//chuc vu trong doan
					String chucVuTrongDoan = thanhVienDoan.getChucVuTrongDoan();
					if ("Truong doan".equals(chucVuTrongDoan))
						chucVuTrongDoan = "Tr\u01B0\u1EDFng \u0111o\u00E0n";
					else if ("Pho doan".equals(chucVuTrongDoan))
						chucVuTrongDoan = "Ph\u00F3 \u0111o\u00E0n";
					else
						chucVuTrongDoan = "Th\u00E0nh vi\u00EAn \u0111o\u00E0n";
					word.addCellTable(table, j + 1, 2,"- Ch\u1EE9c v\u1EE5: " + chucVuTrongDoan);
					word.addRowTable(table, dsThanhVienDoan.size());
					j++;
				}
				
				//word.put("[ttkt]", hinhThuc);
				//word.put("[ttkt]", hinhThuc);
				//word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				//for(int i=0;i<7;i++)
					//word.put("[ttkt]", hinhThuc);
				//word.put("[ttkt]", hinhThuc.toUpperCase());
				//word.put("[ttkt]", hinhThuc.toUpperCase());
				//word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB33", ".doc", response);
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {				
				try { 
					word.saveAndClose();
				} catch (Exception e) {
					
				}
			}
		}else if ("congBoQd".equals(type)) { // In cong bo (ngon, chuan)
			fileTemplate = "Ktnb16";
			TtktCmThanhPhanThamDu[] arrdaidiencoquanthue = tienHanhTtktForm.getArrDaiDienCqtBanHanhQD();
			TtktCmThanhPhanThamDu[] arrdaidiencoquancaptren = tienHanhTtktForm.getArrDaiDienCqqlCapTren();
			if(arrdaidiencoquanthue !=null&&arrdaidiencoquancaptren!=null){
				fileIn = request.getRealPath("/docin/v4") + "\\TTNB16.doc";
				fileOut = request.getRealPath("/docout") + "\\TTNB16_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
				try {
					word = new MsWordUtils(fileIn, fileOut);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				inMau16v4(request, appContext, tienHanhTtktForm, response, word, fileIn, fileOut,0);
			}
			if(arrdaidiencoquanthue ==null&&arrdaidiencoquancaptren!=null){
				fileIn = request.getRealPath("/docin/v4") + "\\TTNB16_1.doc";
				fileOut = request.getRealPath("/docout") + "\\TTNB16_1_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
				try {
					word = new MsWordUtils(fileIn, fileOut);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				inMau16v4(request, appContext, tienHanhTtktForm, response, word, fileIn, fileOut,1);
			}
			if(arrdaidiencoquanthue !=null&&arrdaidiencoquancaptren==null){
				fileIn = request.getRealPath("/docin/v4") + "\\TTNB16_2.doc";
				fileOut = request.getRealPath("/docout") + "\\TTNB16_2_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
				try {
					word = new MsWordUtils(fileIn, fileOut);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				inMau16v4(request, appContext, tienHanhTtktForm, response, word, fileIn, fileOut,2);
			}
			if(arrdaidiencoquanthue ==null&&arrdaidiencoquancaptren==null){
				fileIn = request.getRealPath("/docin/v4") + "\\TTNB16_3.doc";
				fileOut = request.getRealPath("/docout") + "\\TTNB16_3_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
				try {
					word = new MsWordUtils(fileIn, fileOut);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				inMau16v4(request, appContext, tienHanhTtktForm, response, word, fileIn, fileOut,3);
			}

		} else if ("nhatKy".equals(type)) { // In nhat ky
			fileIn = request.getRealPath("/docin/v4") + "\\TTNB15.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB15_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			fileTemplate = "Ktnb15";
			String idCuocTtkt = request.getParameter("idCuocTtkt");
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtkt(appContext, idCuocTtkt);
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhThuc1 = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
			word = new MsWordUtils(fileIn, fileOut);

			StringBuffer sb = new StringBuffer(hinhThuc);
			//word.put("[ttkt]", hinhThuc.toUpperCase());
			//word.put("[ttkt]", sb.toString());
			if (Formater.isNull(cuocTtkt.getTenDonViTh())) {
				word.put("[ten_cqt_tien_hanh]", "-  \n\t- \n\t" + KtnbUtil.inFieldNull(114));
			} else {
				word.put("[ten_cqt_tien_hanh]", cuocTtkt.getTenDonViTh());
			}
			//word.put("[ttkt]", sb.toString());
			//word.put("[ttkt]", sb.toString());
			TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appContext);
			word.put("[so_qd]", cbQd.getSoQuyetDinh());
			word.put("[ngay_qd]", Formater.getDateForPrint(Formater.date2str(cbQd.getNgayRaQuyetDnh())));
			word.put("[thu_truong_qd]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
			String cac_qd_td_tvd = getDsThayDoiTvd(appContext, idCuocTtkt);
			if (Formater.isNull(cac_qd_td_tvd)) {
				word.put("[cac_quyet_dinh_thay_doi_thanh_vien_doan]", "");
			} else {
				word.put("[cac_quyet_dinh_thay_doi_thanh_vien_doan]", "\n" + cac_qd_td_tvd.substring(0, cac_qd_td_tvd.length() - 1));
			}
			//word.put("[ttkt]", sb.toString());
			StringBuffer sb1 = new StringBuffer("\u00D4ng (b\u00E0): " + cuocTtkt.getTenTruongDoan());
			word.put("[ten_truong_doan]", sb1.toString());
			String chucvu_truongdoan = null;
			sb1 = new StringBuffer("");
			Collection dsChiTietTvd = TtktService.getDsTvd(idCuocTtkt, appContext).getChiTietDanhSachTV();
			Iterator iterator = dsChiTietTvd.iterator();
			while (iterator.hasNext()) {
				TtktCbChiTietDsTvDoan thanhVien = (TtktCbChiTietDsTvDoan) iterator.next();
				if (thanhVien.getChucVuTrongDoan().equals("Truong doan")) {
					chucvu_truongdoan = thanhVien.getChucVu();
				}
			}
			word.put("[chuc_vu_truong_doan]", chucvu_truongdoan);
			//word.put("[ttkt]", sb.toString());
			int j = 0; // dem so luong thanh vien
			StringBuffer ds_thanhviendoan = new StringBuffer(""); // danh sach thanh vien doan
			// mo table trong Jacob Word
			Dispatch table = word.openTable(1);
			iterator = dsChiTietTvd.iterator();
			while (iterator.hasNext()) {
				TtktCbChiTietDsTvDoan thanhVien = (TtktCbChiTietDsTvDoan) iterator.next();
				if (!thanhVien.getChucVuTrongDoan().equals("Truong doan")) {
					ds_thanhviendoan.append((j + 1) + ". " + thanhVien.getTenCanBo() + "\n");
					// sb1.append("- \u00D4ng (b\u00E0): ");
					String chucVuCoDau = thanhVien.getChucVuTrongDoan().equals("Pho doan") ? "Ph\u00F3 \u0111o\u00E0n" : "Th\u00E0nh vi\u00EAn \u0111o\u00E0n";
					// sb1.append(thanhVien.getTenCanBo() + ", " + chucVuCoDau);
					// sb1.append("\n");
					word.addCellTable(table, j + 1, 1, "- \u00D4ng (b\u00E0): " + thanhVien.getTenCanBo());
					word.addCellTable(table, j + 1, 2, "- " + thanhVien.getChucVu());
					word.addCellTable(table, j + 1, 3, "- " + chucVuCoDau);
					word.addRowTable(table, dsChiTietTvd.size() - 1);
					j++;
				}
			}
			// word.put("[ten_thanh_vien]",sb1.toString());
			//word.put("[ttkt]", sb.toString());
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
			//word.put("[ttkt]", sb.toString().toUpperCase());

			StringBuffer noiDungNk = new StringBuffer("");
			TtktThNhatKy[] arrNhatKy = tienHanhTtktForm.getArrNhatKy();
			for (int i = 0; i < arrNhatKy.length; i++) {
				String[] ngayLamViec = arrNhatKy[i].getNgayStr().split("/");
				noiDungNk.append((i + 1) + ". Ng\u00E0y " + ngayLamViec[0] + " th\u00E1ng " + ngayLamViec[1] + " n\u0103m " + ngayLamViec[2]);
				noiDungNk.append("\n");
				noiDungNk.append(" ");
				noiDungNk.append(arrNhatKy[i].getNoiDung());
				noiDungNk.append("\n");
			}
			word.put("[noi_dung]", noiDungNk.toString().substring(0, noiDungNk.toString().length() - 1));// xoa di ki tu xuong dong cuoi cung
			if (Formater.isNull(tienHanhTtktForm.getNdKhac())) {
				String defaultNull = KtnbUtil.inFieldNull(115);
				word.put("[noi_dung_khac]", defaultNull + "\n" + defaultNull + "\n" + defaultNull);
			} else
				word.put("[noi_dung_khac]", tienHanhTtktForm.getNdKhac());
			//word.put("[ttkt]", sb.toString().toUpperCase());
			//word.put("[ttkt]", sb.toString().toUpperCase());
			word.put("[ds_thanhvien]", ds_thanhviendoan.toString());
			word.put("[truong_doan]", cuocTtkt.getTenTruongDoan());

		} else if ("banGiaoHstlChoTd".equals(type)) { // in ban giao hstl cho
			// truong doan (ngon,
			// chuan)
			fileIn = request.getRealPath("/docin/v4") + "\\TTNB18A.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB18A_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			fileTemplate = "ttnb18a";
			String idCuocTtkt = tienHanhTtktForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);

			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
			word = new MsWordUtils(fileIn, fileOut);

			TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appContext);
			// thu truong co quan thue doi tuong thanh tra kiem tra\
			word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
			StringBuffer sb = new StringBuffer("\u0110o\u00E0n ");
			sb = new StringBuffer("\u0110O\u00C0N ");
			sb.append(hinhthuc_inT);
			sb.append(" Q\u0110 S\u1ED0 ");
			sb.append(cbQd.getSoQuyetDinh()); // so doan thanh tra, kiem tra
			word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
			word.put("[ten_bc]", "BI\u00CAN B\u1EA2N"); //
			String idTvd = request.getParameter("idTvd");
			if (Formater.isNull(idTvd))
				throw new Exception("Chua chon thanh vien doan nao");
			TtktThBanGiaoHstlChoTd thanhVienDoanCanIn = null;
			TtktThBanGiaoHstlChoTd[] arrBanGiaoHstlChoTruongDoan = tienHanhTtktForm.getArrBanGiaoHstlChoTruongDoan();
			for (int i = 0; i < arrBanGiaoHstlChoTruongDoan.length; i++) {
				if (arrBanGiaoHstlChoTruongDoan[i].getIdCanBo().equals(idTvd)) {
					thanhVienDoanCanIn = arrBanGiaoHstlChoTruongDoan[i];
					break;
				}
			}
			word.put("[thoi_diem_bat_dau]", KtnbUtil.getHour(thanhVienDoanCanIn.getThoiDiemBatDauBanGiaoStr()));
			word.put("[dia_diem]", thanhVienDoanCanIn.getDiaDiemBanGiao());
			sb = new StringBuffer(hinhThuc);
			//word.put("[ttkt]", sb.toString());
			word.put("[so_quyet_dinh]", cbQd.getSoQuyetDinh());
			String ngayqd = Formater.date2str(cbQd.getNgayRaQuyetDnh());
			String[] arrngayqd = ngayqd.split("/");
			word.put("[ngay_quyet]", "ng\u00E0y " + arrngayqd[0] + " th\u00E1ng " + arrngayqd[1] + " n\u0103m " + arrngayqd[2]);

			word.put("[chuc_danh_thu_truong]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
			//word.put("[ttkt]", sb.toString());
			word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());

			StringBuffer sb1 = new StringBuffer("- \u00D4ng (b\u00E0): " + thanhVienDoanCanIn.getTenCanBo());
			sb1.append("  \t Ch\u1EE9c v\u1EE5: " + thanhVienDoanCanIn.getChucVuTrongDoan());
			word.put("[thanh_vien_ben_giao]", sb1.toString());
			Collection dsChiTietTvd = TtktService.getDsTvd(idCuocTtkt, appContext).getChiTietDanhSachTV();
			Iterator iterator = dsChiTietTvd.iterator();
			while (iterator.hasNext()) {
				TtktCbChiTietDsTvDoan thanhVien = (TtktCbChiTietDsTvDoan) iterator.next();
				if (thanhVien.getChucVuTrongDoan().equals("Truong doan")) {
					sb1 = new StringBuffer("- \u00D4ng (b\u00E0): " + thanhVien.getTenCanBo());
					sb1.append("  \t Ch\u1EE9c v\u1EE5: Tr\u01B0\u1EDFng \u0111o\u00E0n");
				}
			}
			word.put("[thanh_vien_ben_nhan]", sb1.toString());
			word.put("[bao_cao]", tienHanhTtktForm.getBaoCao());
			word.put("[ho_so_tai_lieu]", tienHanhTtktForm.getHoSoTaiLieu());
			String thoidiemketthuc = thanhVienDoanCanIn.getThoiDiemKetThucBanGiaoStr();
			// TODO: Loc moi Code them
			if (thanhVienDoanCanIn.getThoiDiemKetThucBanGiaoStr().equals("")) {
				word.put("[thoi_diem_giao_nhan]", ".....,ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
			} else {
				String[] arrketthuc = thoidiemketthuc.split("/");
				word.put("[thoi_diem_giao_nhan]", KtnbUtil.getHour(thanhVienDoanCanIn.getThoiDiemKetThucBanGiaoStr()));
			}
		}

		if (Formater.isNull(fileTemplate))
			try {
				throw new Exception("Chua chon file template");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		try {
			word.saveAndClose();
			word.downloadFile(fileOut, "Mau " + fileTemplate, ".doc", response);
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
	
	

	private String getDsThayDoiTvd(ApplicationContext appContext, String idCuocTtkt) {
		Collection dsThayDoiTvd = TtktCnPhuService.getDsThayDoiTvd(appContext, idCuocTtkt);
		if (Formater.isNull(dsThayDoiTvd))
			return "";
		StringBuffer sb = new StringBuffer();
		Iterator iterator = dsThayDoiTvd.iterator();
		while (iterator.hasNext()) {
			sb.append("Quy\u1EBFt \u0111\u1ECBnh ");
			TtktCmThayDoiTvd thayDoiTvd = (TtktCmThayDoiTvd) iterator.next();
			String soQD = thayDoiTvd.getSoQd();
			// kiem tra xem da co Quyet dinh thay doi thanh vien doan chua
			if(Formater.isNull(soQD))
				soQD = "..... ";
			if (thayDoiTvd.getLoaiThayDoi().equals("thanh_vien_doan")) {
				sb.append("thay \u0111\u1ED5i th\u00E0nh vi\u00EAn s\u1ED1 " + soQD + ", " + Formater.getDateForPrint(thayDoiTvd.getNoiRaQd()) + ".");
			} else if (thayDoiTvd.getLoaiThayDoi().equals("bo_sung_thanh_vien_doan")) {
				sb.append("b\u1ED5 sung th\u00E0nh vi\u00EAn s\u1ED1 " + soQD + ", " + Formater.getDateForPrint(thayDoiTvd.getNoiRaQd()) + ".");
			} else if (thayDoiTvd.getLoaiThayDoi().equals("truong_doan")) {
				sb.append("thay \u0111\u1ED5i tr\u01B0\u1EDFng \u0111o\u00E0n s\u1ED1 " + soQD + ", " + Formater.getDateForPrint(thayDoiTvd.getNoiRaQd()) + ".");
			}
			sb.append("\n");

		}
		return sb.toString();
	}

	/**
	 * @param request
	 * @return
	 */
	private TtktThBanGiaoHstlChoTd createGiaoHstlChoTd(HttpServletRequest request,ApplicationContext appContext) throws Exception {
		TtktThBanGiaoHstlChoTd banGiaoHstlChoTd = new TtktThBanGiaoHstlChoTd();
		banGiaoHstlChoTd.setId(request.getParameter("id"));
		banGiaoHstlChoTd.setIdCuocTtkt(request.getParameter("idCuocTtkt"));
		banGiaoHstlChoTd.setIdCanBo(request.getParameter("idCanBo"));
		banGiaoHstlChoTd.setTenCanBo(request.getParameter("tenCanBo"));
		banGiaoHstlChoTd.setChucVuTrongDoan(request.getParameter("chucVuTrongDoan"));
		banGiaoHstlChoTd.setThoiDiemBatDauBanGiao(Formater.str2dateForNV(request.getParameter("thoiDiemBatDauBanGiaoStr")));
		banGiaoHstlChoTd.setThoiDiemKetThucBanGiao(Formater.str2dateForNV(request.getParameter("thoiDiemKetThucBanGiaoStr")));
		banGiaoHstlChoTd.setBaoCao(request.getParameter("baoCao"));
		banGiaoHstlChoTd.setHoSoTaiLieu(request.getParameter("hstl"));
		banGiaoHstlChoTd.setDiaDiemBanGiao(request.getParameter("diaDiemBanGiao"));
		banGiaoHstlChoTd.setIdNguoiCapNat(appContext.getMaCanbo());
		banGiaoHstlChoTd.setTenCanBo(appContext.getMaCanbo());
		banGiaoHstlChoTd.setNgayCapNhat(new Date());

		return banGiaoHstlChoTd;
	}

	/**
	 * @param request
	 * @param appContext
	 * @param tienHanhTtktForm
	 */
	private void saveTienHanhTtkt(HttpServletRequest request, HttpServletResponse reponse, ApplicationContext appContext, TienHanhTtktForm tienHanhTtktForm) throws Exception {
		String type = request.getParameter("type");
		if(type.indexOf("thongBaoKetThuc")!=-1)
		{
			TtktService.thongBaoKetThuc(appContext, tienHanhTtktForm);
		}
		if (type.indexOf("congBoQd")!=-1) {
			TtktThCongBoQd congBoQd = createCongBoQd(appContext, tienHanhTtktForm);
			TtktService.saveCongBoQd(appContext, congBoQd);
		} else if (type.indexOf("nhatKy")!=-1) {
			TtktThNhatKy[] arrNhatKy = createNhatKy(appContext, tienHanhTtktForm);
			if (arrNhatKy == null || arrNhatKy.length <= 0)
				return;
			TtktService.saveNhatKy(appContext, arrNhatKy, tienHanhTtktForm.getIdCuocTtkt());
		} else if ( type.indexOf("bienBanChiTiet")!=-1) {

		} else if (type.indexOf("banGiaoHstlChoTd")!=-1) {

		} else {
			if (Formater.isNull(TtktService.getBanGiaoHstlChoTd(appContext, tienHanhTtktForm.getIdCuocTtkt()))) {
				writeMaLoi(reponse, "1");
				return;
			}
			if (type.indexOf("duThaoBienBanTongHop")!=-1) {
				TtktThBbChitietvatonghop duThaoBbTongHop = createDuThaoBbTongHop(appContext, tienHanhTtktForm);
				TtktService.saveBienBan(appContext, duThaoBbTongHop, Constants.TT_TTKT_DTBBTH);
//				TtktService.saveDuThaoBbTongHop(appContext, duThaoBbTongHop);
			} else if (type.indexOf("bienBanTongHopKetQuaGuiDvDuocTtkt")!=-1) {
				if (tienHanhTtktForm.getFileDinhKemBbTongHopGuiDonViDuocTtkt() != null) {
					TtktThBbChitietvatonghop bbTongHopGuiDvDuocTtkt = createBbTongHopGuiDviDuocTtkt(appContext, tienHanhTtktForm);
					
					TtktService.saveBienBan(appContext, bbTongHopGuiDvDuocTtkt, Constants.TT_TTKT_BBTHGDVTTKT);
					//TtktService.saveBbTongHopGuiDvDuocTttk(appContext, bbTongHopGuiDvDuocTtkt);

				}
				if ("true".equals(tienHanhTtktForm.getDvDuocTtktDongGopYkien())) {
					if (tienHanhTtktForm.getYkienOfDvDcTtKt() != null) {
						TtktThBbChitietvatonghop ykien = createBbTongHopGuiDviDuocTtkt_Yk(appContext, tienHanhTtktForm);
						TtktService.saveBienBan(appContext, ykien);
					}

				} else {
					if (!Formater.isNull(tienHanhTtktForm.getIdBbTongHopGuiDonViDuocTtktYk())) {
						TtktCnPhuService.deleteBbChiTietVaTongHopById(tienHanhTtktForm.getIdBbTongHopGuiDonViDuocTtktYk());
					}
				}
			} else {
				TtktThBbChitietvatonghop bbTongHop = createBbTongHop(appContext, tienHanhTtktForm);
				TtktService.saveBienBan(appContext, bbTongHop, Constants.TT_TTKT_BBTH);
//				TtktService.saveBbTongHop123(appContext, bbTongHop);
			}
		}
	}
	private void writeMaLoi(HttpServletResponse reponse, String maLoi) throws IOException {
		PrintWriter out = reponse.getWriter();
		out.print(maLoi);
		out.flush();
		out.close();
	}

	/**
	 * @param appContext
	 * @param tienHanhTtktForm
	 * @return
	 */
	private TtktThBbChitietvatonghop createBbTongHopGuiDviDuocTtkt(ApplicationContext appContext, TienHanhTtktForm tienHanhTtktForm) {
		TtktThBbChitietvatonghop bbTongHopGuiDvDuocTtkt = new TtktThBbChitietvatonghop();
		bbTongHopGuiDvDuocTtkt.setId(tienHanhTtktForm.getIdBbTongHopGuiDonViDuocTtkt());
		bbTongHopGuiDvDuocTtkt.setIdCuocTtkt(tienHanhTtktForm.getIdCuocTtkt());
		bbTongHopGuiDvDuocTtkt.setLoaiBb(Constants.TTKT_BB_THGDV);
		bbTongHopGuiDvDuocTtkt.setFileDinhKem(tienHanhTtktForm.getFileDinhKemBbTongHopGuiDonViDuocTtkt());
		bbTongHopGuiDvDuocTtkt.setNgayCapNhat(new Date());
		return bbTongHopGuiDvDuocTtkt;
	}

	private TtktThBbChitietvatonghop createBbTongHopGuiDviDuocTtkt_Yk(ApplicationContext appContext, TienHanhTtktForm tienHanhTtktForm) {
		TtktThBbChitietvatonghop bbTongHopGuiDvDuocTtkt = new TtktThBbChitietvatonghop();
		bbTongHopGuiDvDuocTtkt.setId(tienHanhTtktForm.getIdBbTongHopGuiDonViDuocTtktYk());
		bbTongHopGuiDvDuocTtkt.setIdCuocTtkt(tienHanhTtktForm.getIdCuocTtkt());
		bbTongHopGuiDvDuocTtkt.setLoaiBb(Constants.TT_TTKT_BBTHGDVTTKT_YK);
		bbTongHopGuiDvDuocTtkt.setFileDinhKem(tienHanhTtktForm.getYkienOfDvDcTtKt());
		bbTongHopGuiDvDuocTtkt.setNgayCapNhat(new Date());
		return bbTongHopGuiDvDuocTtkt;
	}

	/**
	 * @param appContext
	 * @param tienHanhTtktForm
	 * @return
	 */
	private TtktThBbChitietvatonghop createDuThaoBbTongHop(ApplicationContext appContext, TienHanhTtktForm tienHanhTtktForm) {
		TtktThBbChitietvatonghop bbDuThaoBbTongHop = new TtktThBbChitietvatonghop();
		bbDuThaoBbTongHop.setId(tienHanhTtktForm.getIdDuThaoBbTongHop());
		bbDuThaoBbTongHop.setIdCuocTtkt(tienHanhTtktForm.getIdCuocTtkt());
		bbDuThaoBbTongHop.setLoaiBb(Constants.TTKT_BB_DTTH);
		bbDuThaoBbTongHop.setFileDinhKem(tienHanhTtktForm.getFileDinhKemDuThaoBbTongHop());
		bbDuThaoBbTongHop.setNgayCapNhat(new Date());
		return bbDuThaoBbTongHop;
	}

	/**
	 * @param appContext
	 * @param tienHanhTtktForm
	 * @return
	 */
	private TtktThBbChitietvatonghop createBbTongHop(ApplicationContext appContext, TienHanhTtktForm tienHanhTtktForm) throws Exception {
		TtktThBbChitietvatonghop bbTongHop = new TtktThBbChitietvatonghop();
		bbTongHop.setId(tienHanhTtktForm.getIdBbTongHop());
		bbTongHop.setIdCuocTtkt(tienHanhTtktForm.getIdCuocTtkt());
		bbTongHop.setLoaiBb(Constants.TTKT_BB_TH);
		bbTongHop.setFileDinhKem(tienHanhTtktForm.getFileDinhKemBbTongHop());
		bbTongHop.setNgayCapNhat(new Date());
		return bbTongHop;
	}

	/**
	 * @param appContext
	 * @param tienHanhTtktForm
	 * @return
	 */
	private TtktThBanGiaoHstlChoTd createBanGiaoHstlChoTd(ApplicationContext appContext, TienHanhTtktForm tienHanhTtktForm) {
		return null;
	}

	/**
	 * @param appContext
	 * @param tienHanhTtktForm
	 * @return
	 */
	private TtktThNhatKy[] createNhatKy(ApplicationContext appContext, TienHanhTtktForm tienHanhTtktForm) throws Exception {
		TtktThNhatKy[] arrNhatKy = tienHanhTtktForm.getArrNhatKy();
		if (arrNhatKy != null && arrNhatKy.length > 0) {
			for (int i = 0; i < arrNhatKy.length; i++) {
				TtktThNhatKy nhatKy = arrNhatKy[i];
				nhatKy.setIdCuocTtkt(tienHanhTtktForm.getIdCuocTtkt());
				nhatKy.setNgay(Formater.str2date(nhatKy.getNgayStr()));
				nhatKy.setIdNguoiCapNat(appContext.getMaCanbo());
				nhatKy.setTenNguoiCapNhat(appContext.getTenCanbo());
				nhatKy.setNgayCapNhat(new Date());
			}
			arrNhatKy[0].setCongViecThucHien(tienHanhTtktForm.getNdKhac());
		}
		return arrNhatKy;
	}

	/**
	 * @param appContext
	 * @param tienHanhTtktForm
	 * @return
	 */
	private TtktThCongBoQd createCongBoQd(ApplicationContext appContext, TienHanhTtktForm tienHanhTtktForm) throws Exception {
		TtktThCongBoQd congBoQd = new TtktThCongBoQd();

		congBoQd.setId(tienHanhTtktForm.getIdCongBoQuyetDinh());
		congBoQd.setIdCuocTtkt(tienHanhTtktForm.getIdCuocTtkt());
		congBoQd.setThoiDiemCbTu(Formater.str2dateForNV(tienHanhTtktForm.getThoiDiemCbTu()));
		congBoQd.setThoiDiemCbDen(Formater.str2dateForNV(tienHanhTtktForm.getThoiDiemCbDen()));
		congBoQd.setDiaDiem(tienHanhTtktForm.getDiaDiem());
		congBoQd.setYkienPhatBieu(tienHanhTtktForm.getYkienPhatBieu());
		congBoQd.setIdNguoiCapNat(appContext.getMaCanbo());
		congBoQd.setTenNguoiCapNhat(appContext.getTenCanbo());
		congBoQd.setNgayCapNhat(new Date());

		// Dai dien co quan ban hanh Qd
		congBoQd.setIdDaiDienCqBanHanhQd(tienHanhTtktForm.getIdDaiDienCqBanHanhQd());
		TtktCmThanhPhanThamDu[] arrDaiDienCqtBanHanhQd = tienHanhTtktForm.getArrDaiDienCqtBanHanhQD();
		if (arrDaiDienCqtBanHanhQd != null && arrDaiDienCqtBanHanhQd.length > 0) {
			ArrayList dsDaiDienCqtBanHanhQd = new ArrayList();
			for (int i = 0; i < arrDaiDienCqtBanHanhQd.length; i++)
				dsDaiDienCqtBanHanhQd.add(arrDaiDienCqtBanHanhQd[i]);
			congBoQd.setDsDaiDienCqtBanHanhQD(dsDaiDienCqtBanHanhQd);
		}

		// Dai dien co quan quan ly cap tren
		congBoQd.setIdDaiDienCqqlCapTren(tienHanhTtktForm.getIdDaiDienCqqlCapTren());
		TtktCmThanhPhanThamDu[] arrDaiDienCqQlCapTren = tienHanhTtktForm.getArrDaiDienCqqlCapTren();
		if (arrDaiDienCqQlCapTren != null && arrDaiDienCqQlCapTren.length > 0) {
			ArrayList dsDaiDienCqQlCapTren = new ArrayList();
			for (int i = 0; i < arrDaiDienCqQlCapTren.length; i++)
				dsDaiDienCqQlCapTren.add(arrDaiDienCqQlCapTren[i]);
			congBoQd.setDsDaiDienCqqlCapTren(dsDaiDienCqQlCapTren);
		}

		// Dai dien doan Ttkt
		congBoQd.setIdDaiDienDoanTtkt(tienHanhTtktForm.getIdDaiDienDoanTtkt());
		TtktCmThanhPhanThamDu[] arrDaiDienDoanTtkt = tienHanhTtktForm.getArrDaiDienDoanTtkt();
		if (arrDaiDienDoanTtkt != null && arrDaiDienDoanTtkt.length > 0) {
			ArrayList dsDaiDienDoanTtkt = new ArrayList();
			for (int i = 0; i < arrDaiDienDoanTtkt.length; i++)
				dsDaiDienDoanTtkt.add(arrDaiDienDoanTtkt[i]);
			congBoQd.setDsDaiDienDoanTtkt(dsDaiDienDoanTtkt);
		}

		// Don vi duoc Ttkt
		congBoQd.setIdDaiDienDonViDuocTtkt(tienHanhTtktForm.getIdDaiDienDonViDuocTtkt());
		TtktCmThanhPhanThamDu[] arrDaiDienDvDuocTtkt = tienHanhTtktForm.getArrDaiDienDonViDuocTtkt();
		if (arrDaiDienDvDuocTtkt != null && arrDaiDienDvDuocTtkt.length > 0) {
			ArrayList dsDaiDienDvDuocTtkt = new ArrayList();
			for (int i = 0; i < arrDaiDienDvDuocTtkt.length; i++)
				dsDaiDienDvDuocTtkt.add(arrDaiDienDvDuocTtkt[i]);
			congBoQd.setDsDaiDienDonViDuocTtkt(dsDaiDienDvDuocTtkt);
		}

		return congBoQd;
	}

	/**
	 * @param cuocTtktId
	 * @param request
	 */
	private void loadDsTvDoan(String cuocTtktId, HttpServletRequest request) {
		Collection dsThanhVienDoan = TtktService.getDanhSachThanhVienDoan(cuocTtktId);
		Collection dsTvD = new ArrayList();
		String cbDsThanhVienDoan = "<option value = \"\">"; // Combo danh sach
		String cbDstvd="<option value = \"\">";
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
			if(!thanhVienDoan.getChucVuTrongDoan().equals("Truong doan")){
				dsTvD.add(thanhVienDoan);
				cbDstvd += "<option value = " + thanhVienDoan.getIdCanBo() + ">";
				cbDstvd += thanhVienDoan.getTenCanBo();
				cbDstvd += "</option>";
			}
		}
		request.setAttribute("chiTietDsTvd", dsThanhVienDoan);
		request.setAttribute("dsThanhVienDoan", dsThanhVienDoan);
		request.setAttribute("dsTvd", dsTvD);
		request.setAttribute("cbDstvd", cbDstvd);
		//request.setAttribute("arrDaiDienDoanTtkt", dsThanhVienDoan);
		request.setAttribute("cbChiTietDsTvd", cbDsThanhVienDoan);
		request.setAttribute("dsIdThanhVienDoan", dsIdThanhVienDoan.substring(0, dsIdThanhVienDoan.length() - 1));
		request.setAttribute("dsChucVuTrongDoan", dsChucVuTrongDoan.substring(0, dsChucVuTrongDoan.length() - 1));		
	}

	private void loadThongBaoKetThuc(HttpServletRequest request, TienHanhTtktForm tienHanhTtktForm, ApplicationContext appContext, TtktKhCuocTtkt cuocTtkt) throws Exception {
		tienHanhTtktForm.setNoiRaThongBaoKetThuc(cuocTtkt.getNoiRaThongBaoKetThuc());
		tienHanhTtktForm.setNgayKetThuc(Formater.date2str(cuocTtkt.getNgayKetThuc()));
		tienHanhTtktForm.setNgayRaThongBaoKetThuc(Formater.date2str(cuocTtkt.getNgayRaThongBaoKetThuc()));
	}
	private void loadCongBoQuyetDinh(HttpServletRequest request, TienHanhTtktForm tienHanhTtktForm, ApplicationContext appContext, String cuocTtktId) throws Exception {
		TtktThCongBoQd congBoQd = TtktService.getCongBoQd(appContext, cuocTtktId);
		if (congBoQd != null) {
			tienHanhTtktForm.setDiaDiem(congBoQd.getDiaDiem());
			tienHanhTtktForm.setIdCongBoQuyetDinh(congBoQd.getId());
			tienHanhTtktForm.setIdCuocTtkt(congBoQd.getIdCuocTtkt());
			tienHanhTtktForm.setIdDaiDienCqBanHanhQd(congBoQd.getIdDaiDienCqBanHanhQd());
			tienHanhTtktForm.setIdDaiDienCqqlCapTren(congBoQd.getIdDaiDienCqqlCapTren());
			tienHanhTtktForm.setIdDaiDienDoanTtkt(congBoQd.getIdDaiDienDoanTtkt());
			tienHanhTtktForm.setIdDaiDienDonViDuocTtkt(congBoQd.getIdDaiDienDonViDuocTtkt());
			tienHanhTtktForm.setThoiDiemCbTu(Formater.date2strDateTimeForNV(congBoQd.getThoiDiemCbTu()));
			tienHanhTtktForm.setThoiDiemCbDen(Formater.date2strDateTimeForNV(congBoQd.getThoiDiemCbDen()));
			tienHanhTtktForm.setYkienPhatBieu(congBoQd.getYkienPhatBieu());

			// Dai dien cqql cap tren
			ArrayList list = (ArrayList) congBoQd.getDsDaiDienCqqlCapTren();
			if (!Formater.isNull(list)) {
				TtktCmThanhPhanThamDu[] arrDaiDienCqqlCapTren = new TtktCmThanhPhanThamDu[list.size()];
				for (int i = 0; i < list.size(); i++)
					arrDaiDienCqqlCapTren[i] = (TtktCmThanhPhanThamDu) list.get(i);
				tienHanhTtktForm.setArrDaiDienCqqlCapTren(arrDaiDienCqqlCapTren);
			}

			// Dai dien cqql cap tren
			list = (ArrayList) congBoQd.getDsDaiDienCqtBanHanhQD();
			if (!Formater.isNull(list)) {
				TtktCmThanhPhanThamDu[] arrDaiDienCqtBanHanhQD = new TtktCmThanhPhanThamDu[list.size()];
				for (int i = 0; i < list.size(); i++)
					arrDaiDienCqtBanHanhQD[i] = (TtktCmThanhPhanThamDu) list.get(i);
				tienHanhTtktForm.setArrDaiDienCqtBanHanhQD(arrDaiDienCqtBanHanhQD);
			}

			// Dai dien doan ttkt
			list = (ArrayList) congBoQd.getDsDaiDienDoanTtkt();
			if (!Formater.isNull(list)) {
				TtktCmThanhPhanThamDu[] arrDaiDienDoanTtkt = new TtktCmThanhPhanThamDu[list.size()];
				for (int i = 0; i < list.size(); i++)
					arrDaiDienDoanTtkt[i] = (TtktCmThanhPhanThamDu) list.get(i);
				tienHanhTtktForm.setArrDaiDienDoanTtkt(arrDaiDienDoanTtkt);
			}
			// Dai dien doan ttkt
			list = (ArrayList) congBoQd.getDsDaiDienDonViDuocTtkt();
			if (!Formater.isNull(list)) {
				TtktCmThanhPhanThamDu[] arrDaiDienDonViDuocTtkt = new TtktCmThanhPhanThamDu[list.size()];
				for (int i = 0; i < list.size(); i++)
					arrDaiDienDonViDuocTtkt[i] = (TtktCmThanhPhanThamDu) list.get(i);
				tienHanhTtktForm.setArrDaiDienDonViDuocTtkt(arrDaiDienDonViDuocTtkt);
			}

		}
		// Thoi han cong bo
		Date ngayRaQd = TtktService.getQuyetDinh(cuocTtktId, appContext).getNgayRaQuyetDnh();
		request.setAttribute("ngayRaQd", Formater.date2str(ngayRaQd));
		HashMap thoiHanTtkt = (HashMap) KtnbCache.getInstance().get("MAP_THTTKT");
		int thoiHanCongBo = Formater.str2num((String) thoiHanTtkt.get(Constants.TH_TTKT_CB)).intValue();
		request.setAttribute("thoiHanCongBo", Formater.num2str(thoiHanCongBo));
		request.setAttribute("ngayCongBoDuKien", Formater.date2str(KtnbUtil.addBusinessDate(ngayRaQd, thoiHanCongBo)));
	}

	private void loadNhatKy(TienHanhTtktForm tienHanhTtktForm, ApplicationContext appContext, String cuocTtktId) throws Exception {
		Collection listNhatKyTtkt = TtktService.getNhatKyTtkt(appContext, cuocTtktId);
		if (!Formater.isNull(listNhatKyTtkt)) {
			int index = 0;
			TtktThNhatKy[] arrNhatkyTtkt = new TtktThNhatKy[listNhatKyTtkt.size()];
			Iterator iter = listNhatKyTtkt.iterator();
			while (iter.hasNext()) {
				TtktThNhatKy nhatKy = (TtktThNhatKy) iter.next();
				nhatKy.setNgayStr(Formater.date2str(nhatKy.getNgay()));
				arrNhatkyTtkt[index] = nhatKy;
				if (!Formater.isNull(nhatKy.getCongViecThucHien()))
					tienHanhTtktForm.setNdKhac(nhatKy.getCongViecThucHien());
				index++;
			}
			tienHanhTtktForm.setArrNhatKy(arrNhatkyTtkt);

		}
	}

	private void loadBbChiTiet(TienHanhTtktForm tienHanhTtktForm, ApplicationContext appContext, String cuocTtktId) throws Exception {
		Collection listBienBanChiTiet = TtktService.getBienBanChiTiet(appContext, cuocTtktId);
		if (!Formater.isNull(listBienBanChiTiet)) {
			int index = 0;
			TtktThBbChitietvatonghop[] arrBbChitiet = new TtktThBbChitietvatonghop[listBienBanChiTiet.size()];
			Iterator iter = listBienBanChiTiet.iterator();
			while (iter.hasNext()) {
				TtktThBbChitietvatonghop bbChitiet = (TtktThBbChitietvatonghop) iter.next();
				arrBbChitiet[index] = bbChitiet;
				arrBbChitiet[index].setThoiDiemLapBbStr(Formater.date2strDateTimeForNV(bbChitiet.getThoiDiemLapBb()));
				arrBbChitiet[index].setThoiDiemThongQuaStr(Formater.date2strDateTimeForNV(bbChitiet.getThoiDiemThongQua()));
				arrBbChitiet[index].setTgianThDenNgayStr(Formater.date2str(bbChitiet.getTgianThDenNgay()));
				arrBbChitiet[index].setTgianThTuNgayStr(Formater.date2str(bbChitiet.getTgianThTuNgay()).substring(0, 5));

				index++;
			}
			tienHanhTtktForm.setArrBienBanChiTiet(arrBbChitiet);
		}
	}

	private void loadBanGiaoHstlChoTd(TienHanhTtktForm tienHanhTtktForm, ApplicationContext appContext, String cuocTtktId) throws Exception {
		Collection listBanGiaoHstl = TtktService.getBanGiaoHstlChoTd(appContext, cuocTtktId);
		if (!Formater.isNull(listBanGiaoHstl)) {
			int index = 0;
			TtktThBanGiaoHstlChoTd[] arrBanGiaoHstlChoTd = new TtktThBanGiaoHstlChoTd[listBanGiaoHstl.size()];
			Iterator iter = listBanGiaoHstl.iterator();
			while (iter.hasNext()) {
				TtktThBanGiaoHstlChoTd banGiaoHstlChoTd = (TtktThBanGiaoHstlChoTd) iter.next();
				banGiaoHstlChoTd.setThoiDiemBatDauBanGiaoStr(Formater.date2strDateTimeForNV(banGiaoHstlChoTd.getThoiDiemBatDauBanGiao()));
				banGiaoHstlChoTd.setThoiDiemKetThucBanGiaoStr(Formater.date2strDateTimeForNV(banGiaoHstlChoTd.getThoiDiemKetThucBanGiao()));
				arrBanGiaoHstlChoTd[index] = banGiaoHstlChoTd;
				index++;
			}
			tienHanhTtktForm.setArrBanGiaoHstlChoTruongDoan(arrBanGiaoHstlChoTd);
		}
	}

	/**
	 * @param cuocTtktId
	 * @param tienHanhTtktForm
	 * @param appContext
	 * @param request
	 */
	private void loadDefaultForm(String cuocTtktId, TienHanhTtktForm tienHanhTtktForm, ApplicationContext appContext, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		// Thong tin chung
		TtktKhCuocTtkt cuocTtkt = (TtktKhCuocTtkt) request.getSession().getAttribute("cuocTtkt");
		if (cuocTtkt != null) {
			request.getSession().removeAttribute("cuocTtkt");
		} else {
			cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, cuocTtktId);

		}
		// Kiem tra quyen truy cap
		KtnbUtil.checkRight(appContext, request, reponse, cuocTtkt);
		
		appContext.setTrangThaiCuocTtkt(cuocTtkt.getId(), cuocTtkt.getTrangThai());
		if (appContext.getTrangThaiCuocTtkt(cuocTtktId).equals(Constants.TT_TTKT_KT))
			request.setAttribute("readOnly", "true");
		if (cuocTtkt.getIdTruongDoan().equals(appContext.getMaCanbo()))
			appContext.setTruongDoan(cuocTtkt.getId(), true);

		else {
			appContext.setTruongDoan(cuocTtkt.getId(), false);
			request.setAttribute("readOnly", "true");
		}

		tienHanhTtktForm.setIdCuocTtkt(cuocTtktId);
		tienHanhTtktForm.setIdDonViDuocTtkt(cuocTtkt.getIdDonViBi());
		tienHanhTtktForm.setIdDonViTienHanh(cuocTtkt.getIdDonViTh());
		tienHanhTtktForm.setDiaDiem(KtnbUtil.getTenTinhByMaCqt(appContext, cuocTtkt.getIdDonViBi()));
		tienHanhTtktForm.setMaCuocTtkt(cuocTtkt.getMa());
		// Phan quyen
		if ("true".equals(request.getAttribute("readOnly"))) {
			// Bien ban lam viec
			if (!Formater.isNull(TtktCnPhuService.getBienBanLamViecTrongQtTienHanh(appContext, cuocTtktId)))
				request.setAttribute("bien ban lam viec", "true");
			// Yeu cau bo sung tai lieu
			if (!Formater.isNull(TtktCnPhuService.getDsYcBsHsTl(appContext, cuocTtktId)))
				request.setAttribute("yeu cau bo sung hstl", "true");
			// Kiem ke tai san
			if (!Formater.isNull(TtktService.getKiemTaiSan(appContext, cuocTtktId)))
				request.setAttribute("kiem ke tai san", "true");
			// Niem phong ho so tai lieu
			if (!Formater.isNull(TtktCnPhuService.getDsNiemPhongHsTl(appContext, cuocTtktId)))
				request.setAttribute("niem phong ho so tai lieu", "true");
			// Phuc tra
			if (!Formater.isNull(TtktService.getDsPhucTra(appContext, cuocTtktId)))
				request.setAttribute("phuc tra", "true");
			// Yeu cau giai trinh
			if (!Formater.isNull(TtktCnPhuService.getDsYCGiaiTrinh(appContext, cuocTtktId)))
				request.setAttribute("Yeu cau giai trinh", "true");
			// Kiem tra xac minh
			if (!Formater.isNull(TtktCnPhuService.getDsKTXacMinh(appContext, cuocTtktId)))
				request.setAttribute("Kiem tra xac minh", "true");
			// Trung cau giam dinh
			if (!Formater.isNull(TtktCnPhuService.getDsTCGiamDinh(appContext, cuocTtktId)))
				request.setAttribute("Trung cau giam dinh", "true");
			// Chuyen giao ho so vu viec
			if (!Formater.isNull(TtktService.getDsChuyenGiaoHsvv(appContext, cuocTtktId)))
				request.setAttribute("Chuyen giao ho so vu viec", "true");
			// Gia han thanh tra kiem tra
			if (!Formater.isNull(TtktCnPhuService.getDsGiaHanTtKt(appContext, cuocTtktId)))
				request.setAttribute("Gia han thanh tra kiem tra", "true");
			// Thay doi thanh vien doan
			if (!Formater.isNull(TtktService.getDsThayDoiTvd(appContext, cuocTtktId)))
				request.setAttribute("Thay doi thanh vien doan", "true");
			// Y kien thanh vien doan ve du thao bien ban tong hop
			TtktCbDsTvDoan cbDsTvDoan = TtktService.getDsTvd(cuocTtktId, appContext);
			Iterator iterator = cbDsTvDoan.getChiTietDanhSachTV().iterator();
			while (iterator.hasNext()) {
				TtktCbChiTietDsTvDoan chiTietDsTvDoan = (TtktCbChiTietDsTvDoan) iterator.next();
				if (!Formater.isNull(chiTietDsTvDoan.getYkien())) {
					request.setAttribute("y_kien_thanh_vien_doan", "true");
					break;
				}
			}
			// To chuc thong qua
			if (TtktCnPhuService.getBienBanLamViec(appContext, cuocTtktId, Constants.TTKT_BB_TCTQ) != null)
				request.setAttribute("To_chuc_thong_qua", "true");
			// Cham thong qua
			if (TtktCnPhuService.getBienBanLamViec(appContext, cuocTtktId, Constants.TTKT_BB_CTQ) != null)
				request.setAttribute("Cham_thong_qua", "true");

		}

		// Thong bao ket thuc
		loadThongBaoKetThuc(request, tienHanhTtktForm, appContext, cuocTtkt);
		
		// Cong bo quyet dinh
		loadCongBoQuyetDinh(request, tienHanhTtktForm, appContext, cuocTtktId);

		// Nhat ky thanh tra kiem tra
		loadNhatKy(tienHanhTtktForm, appContext, cuocTtktId);

		// Bien ban chi tiet
		loadBbChiTiet(tienHanhTtktForm, appContext, cuocTtktId);

		// Ban giao ho so tai lieu cho truong doan
		loadBanGiaoHstlChoTd(tienHanhTtktForm, appContext, cuocTtktId);

		loadBb(tienHanhTtktForm, appContext, cuocTtktId);

	}

	private void loadBb(TienHanhTtktForm tienHanhTtktForm, ApplicationContext appContext, String cuocTtktId) throws Exception {
		// Du thao bien ban tong hop
		TtktThBbChitietvatonghop duThaoBbTongHop = TtktService.getBbTongHop(appContext, cuocTtktId, Constants.TTKT_BB_DTTH);
		if (duThaoBbTongHop != null) {
			tienHanhTtktForm.setIdDuThaoBbTongHop(duThaoBbTongHop.getId());
		}
		// Bien ban tong hop gui don vi duoc Ttkt
		TtktThBbChitietvatonghop duBbTongHopGuiDvDuocTtkt = TtktService.getBbTongHop(appContext, cuocTtktId, Constants.TTKT_BB_THGDV);
		if (duBbTongHopGuiDvDuocTtkt != null) {
			tienHanhTtktForm.setIdBbTongHopGuiDonViDuocTtkt(duBbTongHopGuiDvDuocTtkt.getId());
		}

		// Bien ban tong hop gui don vi duoc Ttkt - y kien cua don vi dc ttkt
		TtktThBbChitietvatonghop ykien = TtktService.getBbTongHop(appContext, cuocTtktId, Constants.TT_TTKT_BBTHGDVTTKT_YK);
		if (ykien != null) {
			tienHanhTtktForm.setIdBbTongHopGuiDonViDuocTtktYk(ykien.getId());
			tienHanhTtktForm.setDvDuocTtktDongGopYkien("true");
		}

		// Bien ban tong hop
		TtktThBbChitietvatonghop bbTongHop = TtktService.getBbTongHop(appContext, cuocTtktId, Constants.TTKT_BB_TH);
		if (bbTongHop != null) {
			tienHanhTtktForm.setIdBbTongHop(bbTongHop.getId());
			tienHanhTtktForm.setTenFile(bbTongHop.getTenFile());
		}
	}
	
	/**
	 * 
	 * Des: inmau16 ver 3
	 * 
	 */
	
	private void inMau16v3(HttpServletRequest request, ApplicationContext appContext, TienHanhTtktForm tienHanhTtktForm, HttpServletResponse response, MsWordUtils word, String fileIn, String fileOut,int type)
	{
		String idCuocTtkt = tienHanhTtktForm.getIdCuocTtkt();
		TtktKhCuocTtkt cuocTtkt= new TtktKhCuocTtkt();
		StringBuffer sb = new StringBuffer("\u0110O\u00C0N ");
		String hinhthuc_inT="";
		String hinhThuc="";
		try {
			cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);
			hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
		} catch (Exception e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		// Lay cac thong tin tu quyet dinh
		sb.append(hinhthuc_inT);
		sb.append(" Q\u0110 S\u1ED0 ");
		TtktCbQd qdTtkt= new TtktCbQd();
		try {
			qdTtkt = TtktService.getQuyetDinh(idCuocTtkt, appContext);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		sb.append(qdTtkt.getSoQuyetDinh());
		word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
		word.put("[doan_ttkt_so]", sb.toString().toUpperCase());

		word.put("[ten_bc]", "BI\u00CAN B\u1EA2N");
		sb = new StringBuffer("C\u00F4ng b\u1ED1 Quy\u1EBFt \u0111\u1ECBnh ");
		sb.append(hinhThuc);
		sb.append(" n\u1ED9i b\u1ED9");
		word.put("[cong_bo_quyet_dinh]", sb.toString());

		//
		String ngayGiolap = tienHanhTtktForm.getThoiDiemCbTu();
		String ngaylapTemp = ngayGiolap.split(" ")[1];
		String ngay = ngaylapTemp.split("/")[0];
		String thang = ngaylapTemp.split("/")[1];
		String nam = ngaylapTemp.split("/")[2];

		String gioPhutLap = ngayGiolap.split(" ")[0];
		String phut = gioPhutLap.split(":")[1];
		String gio = gioPhutLap.split(":")[0];
		word.put("[thoi_diem_bat_dau]", gio + " gi\u1EDD " + phut + " ph\u00FAt, ng\u00E0y " + ngay + " th\u00E1ng " + thang + " n\u0103m " + nam);
		//
		//word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
		word.put("[dia_diem]", tienHanhTtktForm.getDiaDiem());
		sb = new StringBuffer(hinhThuc);
		word.put("[ttkt]", sb.toString());
		word.put("[so_quyet_dinh]", qdTtkt.getSoQuyetDinh());
		String ngayqd = Formater.date2str(qdTtkt.getNgayRaQuyetDnh());
		String[] arrngayqd = ngayqd.split("/");
		word.put("[ngay_quyet]", "ng\u00E0y " + arrngayqd[0] + " th\u00E1ng " + arrngayqd[1] + " n\u0103m " + arrngayqd[2]);

		try {
			word.put("[chuc_danh_thu_truong]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		word.put("[ttkt]", sb.toString());
		word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
		word.put("[ttkt]", sb.toString());
		Dispatch table = new Dispatch();
		StringBuffer tptd = new StringBuffer("");
		TtktCmThanhPhanThamDu[] arrdaidiencoquanthue = tienHanhTtktForm.getArrDaiDienCqtBanHanhQD();
		TtktCmThanhPhanThamDu[] arrdaidiencoquancaptren = tienHanhTtktForm.getArrDaiDienCqqlCapTren();
		TtktCmThanhPhanThamDu[] arrdoanttkt = tienHanhTtktForm.getArrDaiDienDoanTtkt();
		TtktCmThanhPhanThamDu[] arrdonvittkt = tienHanhTtktForm.getArrDaiDienDonViDuocTtkt();
		switch (type) {
		case 0:
			word.put("[ttkt]", sb.toString());
			// dai dien co quan thue ra quyet dinh
			table = word.openTable(3);
			
			if (arrdaidiencoquanthue != null && arrdaidiencoquanthue.length > 0) {
				for (int i = 0; i < arrdaidiencoquanthue.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdaidiencoquanthue[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdaidiencoquanthue[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdaidiencoquanthue[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdaidiencoquanthue[i].getChucVu());
					word.addRowTable(table, arrdaidiencoquanthue.length);
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				//word.put("[thanh_vien]", tptd.toString().substring(0, tptd.length() - 1));
			}
			break;
		case 2:
			word.put("[ttkt]", sb.toString());
			// dai dien co quan thue ra quyet dinh
			table = word.openTable(3);
			if (arrdaidiencoquanthue != null && arrdaidiencoquanthue.length > 0) {
				for (int i = 0; i < arrdaidiencoquanthue.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdaidiencoquanthue[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdaidiencoquanthue[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdaidiencoquanthue[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdaidiencoquanthue[i].getChucVu());
					word.addRowTable(table, arrdaidiencoquanthue.length);
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				//word.put("[thanh_vien]", tptd.toString().substring(0, tptd.length() - 1));
			}
			break;			
		default:
			break;
		}
		switch (type) {
		case 0:
			word.put("[ttkt]", sb.toString());
			// dai dien co quan quan ly cap tren
			table = word.openTable(4);
			tptd = new StringBuffer("");
			if (arrdaidiencoquancaptren != null && arrdaidiencoquancaptren.length > 0) {
				for (int i = 0; i < arrdaidiencoquancaptren.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdaidiencoquancaptren[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdaidiencoquancaptren[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdaidiencoquancaptren[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdaidiencoquancaptren[i].getChucVu());
					word.addRowTable(table, arrdaidiencoquancaptren.length);
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				//word.put("[thanh_vien_ql]", tptd.toString().substring(0, tptd.length() - 1));
			}
			break;
		case 1:
			word.put("[ttkt]", sb.toString());
			// dai dien co quan quan ly cap tren
			table = word.openTable(3);
			tptd = new StringBuffer("");
			if (arrdaidiencoquancaptren != null && arrdaidiencoquancaptren.length > 0) {
				for (int i = 0; i < arrdaidiencoquancaptren.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdaidiencoquancaptren[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdaidiencoquancaptren[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdaidiencoquancaptren[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdaidiencoquancaptren[i].getChucVu());
					word.addRowTable(table, arrdaidiencoquancaptren.length);
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				//word.put("[thanh_vien_ql]", tptd.toString().substring(0, tptd.length() - 1));
			}
			break;			
		default:
			break;
		}
		// else{
		// word.put("[thanh_vien]", "\t"+KtnbUtil.inFieldNull(120));
		// }
		//
		
		// else{
		// word.put("[thanh_vien_ql]", "\t"+KtnbUtil.inFieldNull(120));
		// }
		//
		switch (type) {
		case 0:
			word.put("[ttkt]", sb.toString());
			// dai dien doan ttkt
			table = word.openTable(5);
			tptd = new StringBuffer("");
			if (arrdoanttkt != null && arrdoanttkt.length > 0) {
				for (int i = 0; i < arrdoanttkt.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdoanttkt[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdoanttkt[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdoanttkt[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdoanttkt[i].getChucVu());
					word.addRowTable(table, arrdoanttkt.length);
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				//word.put("[doan_ttkt]", tptd.toString().substring(0, tptd.length() - 1));
			}
			break;
		case 1:
			word.put("[ttkt]", sb.toString());
			// dai dien doan ttkt
			table = word.openTable(4);
			tptd = new StringBuffer("");
			if (arrdoanttkt != null && arrdoanttkt.length > 0) {
				for (int i = 0; i < arrdoanttkt.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdoanttkt[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdoanttkt[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdoanttkt[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdoanttkt[i].getChucVu());
					word.addRowTable(table, arrdoanttkt.length);
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				//word.put("[doan_ttkt]", tptd.toString().substring(0, tptd.length() - 1));
			}
			break;	
		case 2:
			word.put("[ttkt]", sb.toString());
			// dai dien doan ttkt
			table = word.openTable(4);
			tptd = new StringBuffer("");
			if (arrdoanttkt != null && arrdoanttkt.length > 0) {
				for (int i = 0; i < arrdoanttkt.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdoanttkt[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdoanttkt[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdoanttkt[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdoanttkt[i].getChucVu());
					word.addRowTable(table, arrdoanttkt.length);
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				//word.put("[doan_ttkt]", tptd.toString().substring(0, tptd.length() - 1));
			}
			break;	
		case 3:
			word.put("[ttkt]", sb.toString());
			// dai dien doan ttkt
			table = word.openTable(3);
			tptd = new StringBuffer("");
			if (arrdoanttkt != null && arrdoanttkt.length > 0) {
				for (int i = 0; i < arrdoanttkt.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdoanttkt[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdoanttkt[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdoanttkt[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdoanttkt[i].getChucVu());
					word.addRowTable(table, arrdoanttkt.length);
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				//word.put("[doan_ttkt]", tptd.toString().substring(0, tptd.length() - 1));
			}
			break;	
		default:
			break;
		}
		switch (type) {
		case 0:
			word.put("[ttkt]", sb.toString());
			// dai dien don vi dc ttkt
			table = word.openTable(6);
			tptd = new StringBuffer("");
			if (arrdonvittkt != null && arrdonvittkt.length > 0) {
				for (int i = 0; i < arrdonvittkt.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdonvittkt[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdonvittkt[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdonvittkt[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdonvittkt[i].getChucVu());
					word.addRowTable(table, arrdonvittkt.length);
					tptd.append("\n");

				}
				System.out.println(tptd.toString());
				//word.put("[dv_ttkt]", tptd.toString().substring(0, tptd.length() - 1));

			}
			break;
		case 1:
			word.put("[ttkt]", sb.toString());
			// dai dien don vi dc ttkt
			table = word.openTable(5);
			tptd = new StringBuffer("");
			if (arrdonvittkt != null && arrdonvittkt.length > 0) {
				for (int i = 0; i < arrdonvittkt.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdonvittkt[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdonvittkt[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdonvittkt[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdonvittkt[i].getChucVu());
					word.addRowTable(table, arrdonvittkt.length);
					tptd.append("\n");

				}
				System.out.println(tptd.toString());
				//word.put("[dv_ttkt]", tptd.toString().substring(0, tptd.length() - 1));

			}
			break;	
		case 2:
			word.put("[ttkt]", sb.toString());
			// dai dien don vi dc ttkt
			table = word.openTable(5);
			tptd = new StringBuffer("");
			if (arrdonvittkt != null && arrdonvittkt.length > 0) {
				for (int i = 0; i < arrdonvittkt.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdonvittkt[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdonvittkt[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdonvittkt[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdonvittkt[i].getChucVu());
					word.addRowTable(table, arrdonvittkt.length);
					tptd.append("\n");

				}
				System.out.println(tptd.toString());
				//word.put("[dv_ttkt]", tptd.toString().substring(0, tptd.length() - 1));

			}
			break;
		case 3:
			word.put("[ttkt]", sb.toString());
			// dai dien don vi dc ttkt
			table = word.openTable(4);
			tptd = new StringBuffer("");
			if (arrdonvittkt != null && arrdonvittkt.length > 0) {
				for (int i = 0; i < arrdonvittkt.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdonvittkt[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdonvittkt[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdonvittkt[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdonvittkt[i].getChucVu());
					word.addRowTable(table, arrdonvittkt.length);
					tptd.append("\n");

				}
				System.out.println(tptd.toString());
				//word.put("[dv_ttkt]", tptd.toString().substring(0, tptd.length() - 1));

			}
			break;
		default:
			break;
		}
		//
		word.put("[ttkt]", sb.toString());
		word.put("[ttkt]", sb.toString());
		word.put("[so_quyet_dinh]", qdTtkt.getSoQuyetDinh());
		word.put("[ngay_quyet]", "ng\u00E0y " + arrngayqd[0] + " th\u00E1ng " + arrngayqd[1] + " n\u0103m " + arrngayqd[2]);
		try {
			word.put("[chuc_danh_thu_truong]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		word.put("[ttkt]", sb.toString());
		word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
		word.put("[ttkt]", sb.toString());
		word.put("[ttkt]", sb.toString());
		word.put("[ttkt]", sb.toString());
		word.put("[ttkt]", sb.toString());
		word.put("[ttkt]", sb.toString());
		StringBuffer sb1 = new StringBuffer("\u00DD ki\u1EBFn ph\u00E1t bi\u1EC3u: ");
		if (Formater.isNull(tienHanhTtktForm.getYkienPhatBieu())) {
			sb1.append("\n\t" + KtnbUtil.inFieldNull(115));
		} else {
			sb1.append("\n\t" + tienHanhTtktForm.getYkienPhatBieu());
		}
		word.put("[y_kien]", sb1.toString());
		word.put("[ttkt]", sb.toString());

		//
		String ngayGioKT = tienHanhTtktForm.getThoiDiemCbDen();
		String ngayKTTemp = ngayGiolap.split(" ")[1];
		ngay = ngayKTTemp.split("/")[0];
		thang = ngayKTTemp.split("/")[1];
		nam = ngayKTTemp.split("/")[2];

		String gioPhutKT = ngayGioKT.split(" ")[0];
		phut = gioPhutKT.split(":")[1];
		gio = gioPhutKT.split(":")[0];
		word.put("[thoi_gian_ket_thuc]", gio + " gi\u1EDD " + phut + " ph\u00FAt, ng\u00E0y " + ngay + " th\u00E1ng " + thang + " n\u0103m " + nam);
		word.put("[ttkt]", sb.toString());
		word.put("[ttkt]", sb.toString());
		word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
		word.put("[ttkt]", sb.toString().toUpperCase());
		word.put("[ttkt]", sb.toString().toUpperCase());
		word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
	}


	
	/**
	 * 
	 * Des: inmau16 ver 4
	 * 
	 */
	
	
	private void inMau16v4(HttpServletRequest request, ApplicationContext appContext, TienHanhTtktForm tienHanhTtktForm, HttpServletResponse response, MsWordUtils word, String fileIn, String fileOut,int type)
	{
		String idCuocTtkt = tienHanhTtktForm.getIdCuocTtkt();
		TtktKhCuocTtkt cuocTtkt= new TtktKhCuocTtkt();
		StringBuffer sb = new StringBuffer("\u0110O\u00C0N ");
		String hinhthuc_inT="";
		String hinhThuc="";
		try {
			cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);
			hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
		} catch (Exception e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		// Lay cac thong tin tu quyet dinh
		sb.append(hinhthuc_inT);
		sb.append(" Q\u0110 S\u1ED0 ");
		TtktCbQd qdTtkt= new TtktCbQd();
		try {
			qdTtkt = TtktService.getQuyetDinh(idCuocTtkt, appContext);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		sb.append(qdTtkt.getSoQuyetDinh());
		word.put("[ten_cqt]", appContext.getTenCqt().toUpperCase());
		word.put("[doan_ttkt_so]", sb.toString().toUpperCase());

		word.put("[ten_bc]", "BI\u00CAN B\u1EA2N");
		sb = new StringBuffer("C\u00F4ng b\u1ED1 Quy\u1EBFt \u0111\u1ECBnh ");
		sb.append(hinhThuc);
		sb.append(" n\u1ED9i b\u1ED9");
		word.put("[cong_bo_quyet_dinh]", sb.toString());

		//
		String ngayGiolap = tienHanhTtktForm.getThoiDiemCbTu();
		String ngaylapTemp = ngayGiolap.split(" ")[1];
		String ngay = ngaylapTemp.split("/")[0];
		String thang = ngaylapTemp.split("/")[1];
		String nam = ngaylapTemp.split("/")[2];

		String gioPhutLap = ngayGiolap.split(" ")[0];
		String phut = gioPhutLap.split(":")[1];
		String gio = gioPhutLap.split(":")[0];
		word.put("[thoi_diem_bat_dau]", gio + " gi\u1EDD " + phut + " ph\u00FAt, ng\u00E0y " + ngay + " th\u00E1ng " + thang + " n\u0103m " + nam);
		//
		word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
		word.put("[dia_diem]", tienHanhTtktForm.getDiaDiem());
		sb = new StringBuffer(hinhThuc);
		//word.put("[ttkt]", sb.toString());
		word.put("[so_quyet_dinh]", qdTtkt.getSoQuyetDinh());
		String ngayqd = Formater.date2str(qdTtkt.getNgayRaQuyetDnh());
		String[] arrngayqd = ngayqd.split("/");
		word.put("[ngay_quyet]", "ng\u00E0y " + arrngayqd[0] + " th\u00E1ng " + arrngayqd[1] + " n\u0103m " + arrngayqd[2]);

		try {
			word.put("[chuc_danh_thu_truong]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//word.put("[ttkt]", sb.toString());
		word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
		//word.put("[ttkt]", sb.toString());
		Dispatch table = new Dispatch();
		StringBuffer tptd = new StringBuffer("");
		TtktCmThanhPhanThamDu[] arrdaidiencoquanthue = tienHanhTtktForm.getArrDaiDienCqtBanHanhQD();
		TtktCmThanhPhanThamDu[] arrdaidiencoquancaptren = tienHanhTtktForm.getArrDaiDienCqqlCapTren();
		TtktCmThanhPhanThamDu[] arrdoanttkt = tienHanhTtktForm.getArrDaiDienDoanTtkt();
		TtktCmThanhPhanThamDu[] arrdonvittkt = tienHanhTtktForm.getArrDaiDienDonViDuocTtkt();
		switch (type) {
		case 0:
			//word.put("[ttkt]", sb.toString());
			// dai dien co quan thue ra quyet dinh
			table = word.openTable(3);
			
			if (arrdaidiencoquanthue != null && arrdaidiencoquanthue.length > 0) {
				for (int i = 0; i < arrdaidiencoquanthue.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdaidiencoquanthue[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdaidiencoquanthue[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdaidiencoquanthue[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdaidiencoquanthue[i].getChucVu());
					word.addRowTable(table, arrdaidiencoquanthue.length);
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				// word.put("[thanh_vien]", tptd.toString().substring(0, tptd.length() - 1));
			}
			break;
		case 2:
			//word.put("[ttkt]", sb.toString());
			// dai dien co quan thue ra quyet dinh
			table = word.openTable(3);
			if (arrdaidiencoquanthue != null && arrdaidiencoquanthue.length > 0) {
				for (int i = 0; i < arrdaidiencoquanthue.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdaidiencoquanthue[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdaidiencoquanthue[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdaidiencoquanthue[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdaidiencoquanthue[i].getChucVu());
					word.addRowTable(table, arrdaidiencoquanthue.length);
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				// word.put("[thanh_vien]", tptd.toString().substring(0, tptd.length() - 1));
			}
			break;			
		default:
			break;
		}
		switch (type) {
		case 0:
			//word.put("[ttkt]", sb.toString());
			// dai dien co quan quan ly cap tren
			table = word.openTable(4);
			tptd = new StringBuffer("");
			if (arrdaidiencoquancaptren != null && arrdaidiencoquancaptren.length > 0) {
				for (int i = 0; i < arrdaidiencoquancaptren.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdaidiencoquancaptren[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdaidiencoquancaptren[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdaidiencoquancaptren[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdaidiencoquancaptren[i].getChucVu());
					word.addRowTable(table, arrdaidiencoquancaptren.length);
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				// word.put("[thanh_vien_ql]", tptd.toString().substring(0, tptd.length() - 1));
			}
			break;
		case 1:
			//word.put("[ttkt]", sb.toString());
			// dai dien co quan quan ly cap tren
			table = word.openTable(3);
			tptd = new StringBuffer("");
			if (arrdaidiencoquancaptren != null && arrdaidiencoquancaptren.length > 0) {
				for (int i = 0; i < arrdaidiencoquancaptren.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdaidiencoquancaptren[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdaidiencoquancaptren[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdaidiencoquancaptren[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdaidiencoquancaptren[i].getChucVu());
					word.addRowTable(table, arrdaidiencoquancaptren.length);
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				// word.put("[thanh_vien_ql]", tptd.toString().substring(0, tptd.length() - 1));
			}
			break;			
		default:
			break;
		}
		// else{
		// word.put("[thanh_vien]", "\t"+KtnbUtil.inFieldNull(120));
		// }
		//
		
		// else{
		// word.put("[thanh_vien_ql]", "\t"+KtnbUtil.inFieldNull(120));
		// }
		//
		switch (type) {
		case 0:
			//word.put("[ttkt]", sb.toString());
			// dai dien doan ttkt
			table = word.openTable(5);
			tptd = new StringBuffer("");
			if (arrdoanttkt != null && arrdoanttkt.length > 0) {
				for (int i = 0; i < arrdoanttkt.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdoanttkt[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdoanttkt[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdoanttkt[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdoanttkt[i].getChucVu());
					word.addRowTable(table, arrdoanttkt.length);
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				// word.put("[doan_ttkt]", tptd.toString().substring(0, tptd.length() - 1));
			}
			break;
		case 1:
			//word.put("[ttkt]", sb.toString());
			// dai dien doan ttkt
			table = word.openTable(4);
			tptd = new StringBuffer("");
			if (arrdoanttkt != null && arrdoanttkt.length > 0) {
				for (int i = 0; i < arrdoanttkt.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdoanttkt[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdoanttkt[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdoanttkt[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdoanttkt[i].getChucVu());
					word.addRowTable(table, arrdoanttkt.length);
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				// word.put("[doan_ttkt]", tptd.toString().substring(0, tptd.length() - 1));
			}
			break;	
		case 2:
			//word.put("[ttkt]", sb.toString());
			// dai dien doan ttkt
			table = word.openTable(4);
			tptd = new StringBuffer("");
			if (arrdoanttkt != null && arrdoanttkt.length > 0) {
				for (int i = 0; i < arrdoanttkt.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdoanttkt[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdoanttkt[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdoanttkt[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdoanttkt[i].getChucVu());
					word.addRowTable(table, arrdoanttkt.length);
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				// word.put("[doan_ttkt]", tptd.toString().substring(0, tptd.length() - 1));
			}
			break;	
		case 3:
			//word.put("[ttkt]", sb.toString());
			// dai dien doan ttkt
			table = word.openTable(3);
			tptd = new StringBuffer("");
			if (arrdoanttkt != null && arrdoanttkt.length > 0) {
				for (int i = 0; i < arrdoanttkt.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdoanttkt[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdoanttkt[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdoanttkt[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdoanttkt[i].getChucVu());
					word.addRowTable(table, arrdoanttkt.length);
					tptd.append("\n");
				}
				System.out.println(tptd.toString());
				// word.put("[doan_ttkt]", tptd.toString().substring(0, tptd.length() - 1));
			}
			break;	
		default:
			break;
		}
		switch (type) {
		case 0:
			//word.put("[ttkt]", sb.toString());
			// dai dien don vi dc ttkt
			table = word.openTable(6);
			tptd = new StringBuffer("");
			if (arrdonvittkt != null && arrdonvittkt.length > 0) {
				for (int i = 0; i < arrdonvittkt.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdonvittkt[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdonvittkt[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdonvittkt[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdonvittkt[i].getChucVu());
					word.addRowTable(table, arrdonvittkt.length);
					tptd.append("\n");

				}
				System.out.println(tptd.toString());
				// word.put("[dv_ttkt]", tptd.toString().substring(0, tptd.length() - 1));

			}
			break;
		case 1:
			//word.put("[ttkt]", sb.toString());
			// dai dien don vi dc ttkt
			table = word.openTable(5);
			tptd = new StringBuffer("");
			if (arrdonvittkt != null && arrdonvittkt.length > 0) {
				for (int i = 0; i < arrdonvittkt.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdonvittkt[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdonvittkt[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdonvittkt[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdonvittkt[i].getChucVu());
					word.addRowTable(table, arrdonvittkt.length);
					tptd.append("\n");

				}
				System.out.println(tptd.toString());
				// word.put("[dv_ttkt]", tptd.toString().substring(0, tptd.length() - 1));

			}
			break;	
		case 2:
			//word.put("[ttkt]", sb.toString());
			// dai dien don vi dc ttkt
			table = word.openTable(5);
			tptd = new StringBuffer("");
			if (arrdonvittkt != null && arrdonvittkt.length > 0) {
				for (int i = 0; i < arrdonvittkt.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdonvittkt[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdonvittkt[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdonvittkt[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdonvittkt[i].getChucVu());
					word.addRowTable(table, arrdonvittkt.length);
					tptd.append("\n");

				}
				System.out.println(tptd.toString());
				// word.put("[dv_ttkt]", tptd.toString().substring(0, tptd.length() - 1));

			}
			break;
		case 3:
			//word.put("[ttkt]", sb.toString());
			// dai dien don vi dc ttkt
			table = word.openTable(4);
			tptd = new StringBuffer("");
			if (arrdonvittkt != null && arrdonvittkt.length > 0) {
				for (int i = 0; i < arrdonvittkt.length; i++) {
					tptd.append("\t- \u00D4ng (b\u00E0): " + arrdonvittkt[i].getHoTen());
					tptd.append("    - Ch\u1EE9c v\u1EE5: " + arrdonvittkt[i].getChucVu());
					word.addCellTable(table, i + 1, 1, "- \u00D4ng (b\u00E0): " + arrdonvittkt[i].getHoTen());
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrdonvittkt[i].getChucVu());
					word.addRowTable(table, arrdonvittkt.length);
					tptd.append("\n");

				}
				System.out.println(tptd.toString());
				// word.put("[dv_ttkt]", tptd.toString().substring(0, tptd.length() - 1));

			}
			break;
		default:
			break;
		}
		//
		//word.put("[ttkt]", sb.toString());
		//word.put("[ttkt]", sb.toString());
		word.put("[so_quyet_dinh]", qdTtkt.getSoQuyetDinh());
		word.put("[ngay_quyet]", "ng\u00E0y " + arrngayqd[0] + " th\u00E1ng " + arrngayqd[1] + " n\u0103m " + arrngayqd[2]);
		try {
			word.put("[chuc_danh_thu_truong]", KtnbUtil.getTenThuTruongCqtForMauin(appContext));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//word.put("[ttkt]", sb.toString());
		word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
		//word.put("[ttkt]", sb.toString());
		//word.put("[ttkt]", sb.toString());
		//word.put("[ttkt]", sb.toString());
		//word.put("[ttkt]", sb.toString());
		//word.put("[ttkt]", sb.toString());
		StringBuffer sb1 = new StringBuffer("\u00DD ki\u1EBFn ph\u00E1t bi\u1EC3u: ");
		if (Formater.isNull(tienHanhTtktForm.getYkienPhatBieu())) {
			sb1.append("\n\t" + KtnbUtil.inFieldNull(115));
		} else {
			sb1.append("\n\t" + tienHanhTtktForm.getYkienPhatBieu());
		}
		word.put("[y_kien]", sb1.toString());
		//word.put("[ttkt]", sb.toString());

		//
		String ngayGioKT = tienHanhTtktForm.getThoiDiemCbDen();
		String ngayKTTemp = ngayGiolap.split(" ")[1];
		ngay = ngayKTTemp.split("/")[0];
		thang = ngayKTTemp.split("/")[1];
		nam = ngayKTTemp.split("/")[2];

		String gioPhutKT = ngayGioKT.split(" ")[0];
		phut = gioPhutKT.split(":")[1];
		gio = gioPhutKT.split(":")[0];
		word.put("[thoi_gian_ket_thuc]", gio + " gi\u1EDD " + phut + " ph\u00FAt, ng\u00E0y " + ngay + " th\u00E1ng " + thang + " n\u0103m " + nam);
		//word.put("[ttkt]", sb.toString());
		//word.put("[ttkt]", sb.toString());
		word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
		//word.put("[ttkt]", sb.toString().toUpperCase());
		//word.put("[ttkt]", sb.toString().toUpperCase());
		word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
	}

}
