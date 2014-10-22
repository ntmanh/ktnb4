/*
 * Created on Jan 6, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.action;

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
import org.apache.struts.upload.FormFile;

import com.jacob.com.Dispatch;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.KtnbFile;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbDeCuong;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbKhTtkt;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmBienBan;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmHsTl;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThGiaHan;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.KtnbCache;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.MsWordUtils;
import cmc.com.ktnb.util.StringUtil;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.catalog.CatalogService;
import cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.form.ChuanBiTienHanhForm;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;

/**
 * @author Nguyen Tien Dung
 * 
 * To change the template for this generated type comment go to Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ChuanBiTienHanhAction extends BaseDispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception, Exception {
		ChuanBiTienHanhForm cbForm = (ChuanBiTienHanhForm) form;
		ApplicationContext appConText = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String method = request.getParameter("method");
		if (Formater.isNull(method) || "view".equals(method)) {
			String cuocTtktId = request.getParameter("cuocTtktId");
			// Load thong tin mac dinh
			TtktKhCuocTtkt cuocTtkt = (TtktKhCuocTtkt) request.getSession().getAttribute("cuocTtkt");			
			if (cuocTtkt != null) {
				request.getSession().removeAttribute("cuocTtkt");
			} else {
				cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, cuocTtktId);

			}
			// Kiem tra quyen truy cap
			KtnbUtil.checkRight(appConText, request, reponse, cuocTtkt);
			
			loadDefaultForm(cuocTtkt, cbForm, request, appConText);

			if (cuocTtkt.getLoai().booleanValue()) {// Neu la ttkt dot xuat
				request.setAttribute("showVbChiDao", "true");
			}
			appConText.setTrangThaiCuocTtkt(cuocTtktId, cuocTtkt.getTrangThai());

			// Van ban quy dinh chuc nang nhiem vu
			KtnbUtil.setVanBan(cuocTtkt.getIdDonViTh(), request);

			return mapping.findForward("success");

		} else if ("save".equals(method)) {
			String maLoi = " ";
			// if ("tvd".equals(request.getParameter("type"))) {
			// if (TtktService.getBCKS(cbForm.getIdCuocTtkt(), appConText) ==
			// null)
			// maLoi = "1";
			// }
			if ("qd".equals(request.getParameter("type"))) {
				// Da duyet danh sach thanh vien doan chua
				if (TtktService.getDsTvd(cbForm.getIdCuocTtkt(), appConText).getNgayPheDuyet() == null||TtktService.getDsTvd(cbForm.getIdCuocTtkt(), appConText).getNoiPheDuyet() == null)
					maLoi = "2";

			} else if ("kh".equals(request.getParameter("type"))) {				
				TtktCbQd qd = TtktService.getQuyetDinh(cbForm.getIdCuocTtkt(), appConText);
				if (qd == null || Formater.isNull(qd.getSoQuyetDinh()))
					maLoi = "3";

			} else if ("dc".equals(request.getParameter("type"))) {
				//String idCuocTTKT = "140312091838000000000031841846";				
				TtktCbQd qd = TtktService.getQuyetDinh(cbForm.getIdCuocTtkt(), appConText);
				if (qd == null || Formater.isNull(qd.getSoQuyetDinh()))
					maLoi = "3";

			} else if ("hdtk".equals(request.getParameter("type"))) {
				// TtktCbQd qd = TtktService.getQuyetDinh(cbForm.getIdCuocTtkt(), appConText);
				// if (qd == null || Formater.isNull(qd.getSoQuyetDinh()))
				TtktCbKhTtkt khTtkt = TtktService.getKeHoach(cbForm.getIdCuocTtkt(), appConText);
				if (khTtkt == null || Formater.isNull(khTtkt.getNoiPheDuyet()))
					maLoi = "4";
				else {
					TtktCbDeCuong deCuong = TtktService.getDeCuong(cbForm.getIdCuocTtkt(), appConText);
					if (deCuong == null)
						maLoi = "5";
				}

			}
			if (Formater.isNull(maLoi)) {
				saveCbth(request, appConText, cbForm);
			}
			PrintWriter out = reponse.getWriter();
			out.print(maLoi);
			out.flush();
			out.close();
			return null;

		} else if ("in".equals(method)) {
			inCbth(request, appConText, cbForm, reponse);
			return null;
//			return mapping.findForward("success");
		}
		return mapping.findForward("success");
	}

	private void checkRight(ApplicationContext appConText, HttpServletRequest request, HttpServletResponse reponse, TtktKhCuocTtkt cuocTtkt) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param cuocTtktId
	 * @param cbForm
	 * @param request
	 * @param appConText
	 */
	private void loadDefaultForm(TtktKhCuocTtkt cuocTtkt, ChuanBiTienHanhForm cbForm, HttpServletRequest request, ApplicationContext appConText) throws Exception {
		// Thong tin chung

		String cuocTtktId = cuocTtkt.getId();

		if (cuocTtkt.getTrangThai().equals(Constants.TT_TTKT_KT))
			request.setAttribute("readOnly", "true");
		if (cuocTtkt.getIdTruongDoan().equals(appConText.getMaCanbo()))
			appConText.setTruongDoan(cuocTtktId, true);
		else
			appConText.setTruongDoan(cuocTtktId, false);
		cbForm.setIdCuocTtkt(cuocTtktId);
		cbForm.setDiaDiem(appConText.getDiaBan());
		cbForm.setMaCuocTtkt(cuocTtkt.getMa());

		// Phan quyen
		if (!appConText.isTruongDoan(cuocTtktId)) {
			request.setAttribute("readOnly", "true");
			// Check ton tai hoan
			if (TtktCnPhuService.getHoanTtKt(appConText, cuocTtktId) != null)
				request.setAttribute("hoan", "true");
			// Check ton tai gia han
			if (!Formater.isNull(TtktCnPhuService.getDsGiaHanTtKt(appConText, cuocTtktId)))
				request.setAttribute("gia han", "true");
			// Check ton tai thay doi truong doan
			if (!Formater.isNull(TtktService.getDsThayDoiThanhVienDoan(appConText, cuocTtktId)))
				request.setAttribute("thay doi thanh vien doan", "true");
		} else {
			String[] temp = cuocTtkt.getMa().split("/");
			String namTienHanh = temp[temp.length - 2];
			KtnbUtil.cacheListHolidayDayForClient(request, namTienHanh, String.valueOf(Integer.parseInt(namTienHanh) + 1));
			// Thoi han
			HashMap thoiHanTtkt = (HashMap) KtnbCache.getInstance().get("MAP_THTTKT");
			// Ngay lap ke hoach
			request.setAttribute("ngay_lap_ke_hoach", (String) thoiHanTtkt.get(Constants.TH_TTKT_LKH));
			// Ngay duyet ke hoach
			request.setAttribute("ngay_duyet_hoach", (String) thoiHanTtkt.get(Constants.TH_TTKT_DKH));
			// Ngay lap de cuong
			request.setAttribute("ngay_lap_de_cuong", (String) thoiHanTtkt.get(Constants.TH_TTKT_DC));
			try {
				TtktThGiaHan element= new TtktThGiaHan();
				for (Iterator iter = TtktService.getDsGiaHan(appConText, cuocTtktId).iterator(); iter.hasNext();) {
					element = (TtktThGiaHan) iter.next();					
				}
				request.setAttribute("thoi_gian_gia_han", Formater.objectDate2Str(element.getGiaHanDenNgay()));
			} catch (Exception e) {
			}
			
		}

		// Bao cao ks
		loadBaoCaoKhaoSat(cuocTtktId, appConText, cbForm);

		// Thanh vien doan
		loadThanhVienDoan(cuocTtktId, appConText, cbForm, request);

		// Quyet dinh
		loadQuyetDinh(cuocTtktId, appConText, cbForm);
		if (!Formater.isNull(cbForm.getIdQuyetDinh()) && !Formater.isNull(cbForm.getSoQuyetDinh()))
			request.setAttribute("da_co_lich_trinh_du_kien", "true");

		// Ke hoach
		loadKeHoach(cuocTtktId, appConText, cbForm);

		// De cuong
		loadDeCuong(cuocTtktId, request, appConText, cbForm);

		// Hop doan trien khai
		loadHopDoanTrienKhai(cuocTtktId, request, appConText, cbForm);

	}

	/**
	 * @param cuocTtktId
	 * @param appConText
	 * @param cbForm
	 */
	private void loadHopDoanTrienKhai(String cuocTtktId, HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		TtktCmBienBan bbHopDoanTrienKhai = TtktService.getBbHopDoanTrienKhai(cuocTtktId, appConText);
		if (bbHopDoanTrienKhai != null) {
			cbForm.setThoiDiemBatDau(Formater.date2strDateTimeForNV(bbHopDoanTrienKhai.getThoiDiemBatDau()));
			cbForm.setDiaDiemHop(bbHopDoanTrienKhai.getDiaDiem());
			cbForm.setVeViec(bbHopDoanTrienKhai.getVeViec());
			cbForm.setNoiDungHopDoanTrienKhai(bbHopDoanTrienKhai.getNoiDung());
			cbForm.setThoiDiemKetThuc(Formater.date2strDateTimeForNV(bbHopDoanTrienKhai.getThoiDiemKetThuc()));
			cbForm.setIdBienBanHopTrienKhaiDoan(bbHopDoanTrienKhai.getId());

			Collection dsThanhPhanThamDu = bbHopDoanTrienKhai.getThanhPhanThamDu();
			if (!Formater.isNull(dsThanhPhanThamDu)) {
				TtktCmThanhPhanThamDu[] arrThanhPhanThamDu = new TtktCmThanhPhanThamDu[dsThanhPhanThamDu.size()];
				Iterator iterator = dsThanhPhanThamDu.iterator();
				int index = 0;
				while (iterator.hasNext()) {
					arrThanhPhanThamDu[index] = (TtktCmThanhPhanThamDu) iterator.next();
					index++;
				}
				cbForm.setThanhPhanThamDuHopDoanTrienKhai(arrThanhPhanThamDu);
			}
			TtktCbDsTvDoan dsTvdHopTrienKhai = TtktService.getDsTvdById(bbHopDoanTrienKhai.getIdDsTvd(), appConText);
			cbForm.setIdDsTvdHopTrienKhai(bbHopDoanTrienKhai.getIdDsTvd());
			request.setAttribute("dsTvdHopTrienKhai", dsTvdHopTrienKhai.getChiTietDanhSachTV());

		} else {
			TtktCbDsTvDoan dsTvdHopTrienKhai = TtktService.getDsTvd(cbForm.getIdCuocTtkt(), appConText);
			cbForm.setIdDsTvdHopTrienKhai(dsTvdHopTrienKhai.getId());
			request.setAttribute("dsTvdHopTrienKhai", dsTvdHopTrienKhai.getChiTietDanhSachTV());
		}
	}

	/**
	 * @param cuocTtktId
	 * @param appConText
	 * @param cbForm
	 */
	private void loadDeCuong(String cuocTtktId, HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		TtktCbDeCuong deCuong = TtktService.getDeCuong(cuocTtktId, appConText);
		if (deCuong != null) {
			cbForm.setNoiLapDeCuong(deCuong.getNoiLap());
			cbForm.setNgayLapDeCuong(Formater.date2str(deCuong.getNgayLap()));
			cbForm.setNhungVanDeKhac(deCuong.getNhungVanDeKhac());
			cbForm.setIdDecuong(deCuong.getId());
//			cbForm.setIdBaoCaoPhaiCbiCungCap_DC(deCuong.getIdBaoCaoPhaiCbiCungCap());
//			cbForm.setIdHstlPhaiCbiCungCap_DC(deCuong.getIdHstlPhaiCbiCungCap());
//			// Bao cao phai chuan bi va cung cap
//			ArrayList listBaoCao = (ArrayList) deCuong.getBaoCaoPhaiCbiCungCap();
//			if (!Formater.isNull(listBaoCao)) {
//				TtktCmHsTl[] arrBaoCao = new TtktCmHsTl[listBaoCao.size()];
//				for (int i = 0; i < listBaoCao.size(); i++) {
//					TtktCmHsTl baoCao = (TtktCmHsTl) listBaoCao.get(i);
//					baoCao.setStrThoiGianBanGiao(Formater.date2str(baoCao.getThoiGianBanGiao()));
//					baoCao.setStrThoiKyDen(Formater.date2str(baoCao.getThoiKyDen()));
//					baoCao.setStrThoiKyTu(Formater.date2str(baoCao.getThoiKyTu()));
//					arrBaoCao[i] = baoCao;
//				}
//
//				cbForm.setDsBaoCao(arrBaoCao);
//			}
//			// Ho so tai lieu phai chuan bi
//			ArrayList listHstl = (ArrayList) deCuong.getHstlPhaiCbiCungCap();
//			if (!Formater.isNull(listHstl)) {
//				TtktCmHsTl[] arrHstl = new TtktCmHsTl[listHstl.size()];
//				for (int i = 0; i < listHstl.size(); i++) {
//					TtktCmHsTl hsTl = (TtktCmHsTl) listHstl.get(i);
//					hsTl.setStrThoiGianBanGiao(Formater.date2str(hsTl.getThoiGianBanGiao()));
//					arrHstl[i] = hsTl;
//				}
//
//				cbForm.setDsHoSoTl(arrHstl);
//			}
			cbForm.setBcPhaiCbiCungCap(deCuong.getBaoCao());
			cbForm.setHsPhaiCbiCungCap(deCuong.getTaiLieu());
			TtktCbDsTvDoan dsTvdLapDeCuong = TtktService.getDsTvdById(deCuong.getIdDsTvd(), appConText);
			cbForm.setIdDsTvdLapDeCuong(deCuong.getIdDsTvd());
			//if(dsTvdLapDeCuong!=null)
			request.setAttribute("dsTvdLapDeCuong",dsTvdLapDeCuong.getChiTietDanhSachTV());
			if (!Formater.isNull(deCuong.getMaFile())) {
				cbForm.setMaFileDeCuong(deCuong.getMaFile());
				cbForm.setIsAttackDeCuong("true");
			} else {
				cbForm.setIsAttackDeCuong("false");

			}

		} else {
			TtktCbDsTvDoan dsTvdLapDeCuong = TtktService.getDsTvd(cbForm.getIdCuocTtkt(), appConText);
			cbForm.setIdDsTvdLapDeCuong(dsTvdLapDeCuong.getId());
			request.setAttribute("dsTvdLapDeCuong", dsTvdLapDeCuong.getChiTietDanhSachTV());
			cbForm.setIsAttackDeCuong("false");
		}

	}

	/**
	 * @param cuocTtktId
	 * @param appConText
	 * @param cbForm
	 */
	private void loadKeHoach(String cuocTtktId, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		TtktCbKhTtkt khTtkt = TtktService.getKeHoach(cuocTtktId, appConText);
		if (khTtkt != null) {
			cbForm.setDiaDiemLapKeHoach(khTtkt.getDiaDiemLap());
			cbForm.setNgayLapKeHoach(Formater.date2str(khTtkt.getNgayLap()));
			cbForm.setNoiPheDuyetKeHoach(khTtkt.getNoiPheDuyet());
			cbForm.setNgayPheDuyetKeHoach(Formater.date2str(khTtkt.getNgayPheDuyet()));
			cbForm.setMucDich(khTtkt.getMucDich());
			cbForm.setYkienPheDuyetKh(khTtkt.getYkienPheDuyetKh());
			cbForm.setYeuCau(khTtkt.getYeuCau());
			cbForm.setNoiDung(khTtkt.getNoiDung());
			cbForm.setPhuongPhapTienHanh(khTtkt.getPhuongPhapTienHanh());
			cbForm.setToChucThucHien(khTtkt.getToChucThucHien());
			cbForm.setCheDoThongTinBaoCao(khTtkt.getCheDoThongTinBaoCao());
			cbForm.setDieuKienVatChatDamBao(khTtkt.getDieuKienVatChatDamBao());
			cbForm.setNhungDieuKienKhac(khTtkt.getNhungDieuKienKhac());
			cbForm.setIdKeHoach(khTtkt.getId());
			if (!Formater.isNull(khTtkt.getMaFile())) {
				cbForm.setMaFileKeHoach(khTtkt.getMaFile());
				cbForm.setIsAttackKeHoach("true");
			} else {
				cbForm.setIsAttackKeHoach("false");
			}
		}

	}

	/**
	 * @param cuocTtktId
	 * @param appConText
	 * @param cbForm
	 * @param request
	 */
	private void loadQuyetDinh(String cuocTtktId, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		TtktCbQd qdTtkt = TtktService.getQuyetDinh(cuocTtktId, appConText);
		if (qdTtkt != null) {
			cbForm.setSoQuyetDinh(qdTtkt.getSoQuyetDinh());
			cbForm.setNgayRaQuyetDnh(Formater.date2str(qdTtkt.getNgayRaQuyetDnh()));
			cbForm.setDiaDiemRaQuyetDinh(qdTtkt.getDiaDiemRaQuyetDinh());
			cbForm.setThuTruongCacDvLienQuan(qdTtkt.getThuTruongCacDvLienQuan());
			cbForm.setIdQuyetDinh(qdTtkt.getId());

			cbForm.setIdNguoiChiDaoGiamSat(qdTtkt.getIdNguoiChiDaoGiamSat());
			cbForm.setTenNguoiChiDaoGiamSat(qdTtkt.getTenNguoiChiDaoGiamSat());
			cbForm.setChucVuNguoiChiDaoGiamSat(qdTtkt.getChucVuNguoiChiDaoGiamSat());
			cbForm.setVanBanQuyDinhCnangNvuQd(qdTtkt.getVanBanQuyDinhCnangNvuQd());
			cbForm.getVanBanKeHoach(qdTtkt.getVanBanKeHoach());

		}

	}

	/**
	 * @param cuocTtktId
	 * @param appConText
	 * @param cbForm
	 * @param request
	 */
	private void loadThanhVienDoan(String cuocTtktId, ApplicationContext appConText, ChuanBiTienHanhForm cbForm, HttpServletRequest request) throws Exception {
		// TtktCbDsTvDoan dsTvd = TtktService.getDsTvd(cuocTtktId, appConText);
		TtktCbDsTvDoan dsTvd = TtktService.getDsTvdInQd(cuocTtktId, appConText);
		if (dsTvd != null) {
			cbForm.setNoiLapDsTvd(dsTvd.getNoiLap());
			cbForm.setNgayLapDsTvd(Formater.date2str(dsTvd.getNgayLap()));
			cbForm.setNoiPheDuyetDsTvd(dsTvd.getNoiPheDuyet());
			cbForm.setNgayPheDuyetDsTvd(Formater.date2str(dsTvd.getNgayPheDuyet()));
			cbForm.setYkienPheDuyetDsTvd(dsTvd.getYkienPheDuyet());
			cbForm.setIdDsTvd(dsTvd.getId());
			cbForm.setVanBanQuyDinhCnangNvuQdTvd(dsTvd.getVanBanQuyDinhCnangNvuQdTvd());
			// load chi tiet ds thanh vien doan
			Collection chiTietDsTvds = dsTvd.getChiTietDanhSachTV();
			request.setAttribute("chiTietDsTvd", chiTietDsTvds);
			TtktCbChiTietDsTvDoan[] arrChiTietDsTvd = new TtktCbChiTietDsTvDoan[chiTietDsTvds.size()];
			Iterator iter = chiTietDsTvds.iterator();
			int index = 0;
			while (iter.hasNext()) {
				arrChiTietDsTvd[index] = (TtktCbChiTietDsTvDoan) iter.next();
				index++;
			}
			cbForm.setChiTietDsTvd(arrChiTietDsTvd);
		}
		// loadDsTvDoan(cuocTtktId, request);
		request.setAttribute("danhSachThanhVienDoan", dsTvd.getChiTietDanhSachTV());

	}

	/**
	 * @param cuocTtktId
	 * @param appConText
	 * @param cbForm
	 */
	private void loadBaoCaoKhaoSat(String cuocTtktId, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		KtnbFile fileBCKS = TtktService.getBCKS(cuocTtktId, appConText);
		if (fileBCKS != null)
			cbForm.setMaFileBCKS(fileBCKS.getMaFile());

	}

	/**
	 * @param request
	 * @param appConText
	 * @param cbForm
	 */
	private void saveCbth(HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		if ("bcks".equals(request.getParameter("type"))) {
			saveBaoCaoKs(request, appConText, cbForm);
			if (TtktService.isNewStatus(cbForm.getIdCuocTtkt(), appConText, Constants.TT_TTKT_BCKS))
				appConText.setTrangThaiCuocTtkt(cbForm.getIdCuocTtkt(), Constants.TT_TTKT_BCKS);
		} else if ("tvd".equals(request.getParameter("type"))) {
			saveThanhVienDoan(request, appConText, cbForm);
		} else if ("qd".equals(request.getParameter("type"))) {
			saveQuyetDinh(request, appConText, cbForm);
		} else if ("kh".equals(request.getParameter("type"))) {
			saveKeHoach(request, appConText, cbForm);
		} else if ("dc".equals(request.getParameter("type"))) {
			saveDeCuong(request, appConText, cbForm);
			if (TtktService.isNewStatus(cbForm.getIdCuocTtkt(), appConText, Constants.TT_TTKT_DC))
				appConText.setTrangThaiCuocTtkt(cbForm.getIdCuocTtkt(), Constants.TT_TTKT_DC);
		} else if ("hdtk".equals(request.getParameter("type"))) {
			saveHopDoanTrienKhai(request, appConText, cbForm);
			if (TtktService.isNewStatus(cbForm.getIdCuocTtkt(), appConText, Constants.TT_TTKT_HOP))
				appConText.setTrangThaiCuocTtkt(cbForm.getIdCuocTtkt(), Constants.TT_TTKT_HOP);
		}

	}

	/**
	 * Download file mau TTNB04,TTNB05,TTNB12,TTNB13,TTNB14(HDTK)
	 * 
	 * @throws Exception
	 */
	private void inCbth(HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm, HttpServletResponse reponse) throws Exception {
		String fileIn = null;
		String fileOut = null;
		MsWordUtils word = null;

		HashMap[] reportRows = null;
		Map parameters = new HashMap();
		String fileTemplate = null;
		String defaultNull1 = "................................................................................................................................";
		if ("bcks".equals(request.getParameter("type"))) {
			fileIn = request.getRealPath("/docin") + "\\TTNB03.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB03_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			fileTemplate = "ttnb03";
			// -------------hinh thuc thanh tra kiem tra-------------//
			String idCuocTtkt = cbForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			StringBuffer sb = new StringBuffer(hinhThuc);

			try {
				word = new MsWordUtils(fileIn, fileOut);
				// ----------------------------------//
				word.put("[ten_cqt]", appConText.getTenCqt().toUpperCase());
				word.put("[ten_phong]", appConText.getTenPhong().toUpperCase());
				word.put("[noi_qd]", ".....");
				word.put("[ngay_ttkt]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				word.put("[thu_truong]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				word.put("[nam]", getNamTienHanh(cuocTtkt.getMa())); // lay nam ttkt tu ma cuoc ttkt
				word.put("[tu_ngay]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				word.put("[den_ngay]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				word.put("[ten_phong]", appConText.getTenPhong());
				word.put("[ttkt]", hinhThuc);
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc); 
				word.put("[ttkt]", hinhThuc);
				word.put("[ttkt]", hinhThuc);
				word.put("[truong_bo_phan_ttkt]", appConText.getTenTruongPhong());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB03", ".doc", reponse);
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
		// Bieu mau in Thanh Vien Doan
		else if ("tvd".equals(request.getParameter("type"))) {
			fileIn = request.getRealPath("/docin") + "\\TTNB04.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB04_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			fileTemplate = "ttnb04";
			// -------------hinh thuc thanh tra kiem tra-------------//
			String idCuocTtkt = cbForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			StringBuffer sb = new StringBuffer(hinhThuc);

			try {
				word = new MsWordUtils(fileIn, fileOut);
				// ----------------------------------//
				word.put("[ten_cqt]", appConText.getTenCqt().toUpperCase());
				word.put("[ten_phong]", appConText.getTenPhong().toUpperCase());
				word.put("[ten_bc]", "T\u1EDC TR\u00CCNH");
				word.put("[ve_viec]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", sb.toString());
				String tenTt =  KtnbUtil.getTenThuTruongCqtForMauin(appConText);
				word.put("[thu_truong]", tenTt);
				word.put("[nam]", getNamTienHanh(cuocTtkt.getMa()));
				if (CatalogService.getTenDanhMucById(cbForm.getVanBanQuyDinhCnangNvuQdTvd()).equals("N/A")) {
					word.put("[can_cu]", KtnbUtil.inFieldNull(108) + ";");
				} else {
					word.put("[can_cu]", CatalogService.getTenDanhMucById(cbForm.getVanBanQuyDinhCnangNvuQdTvd()));
				}
				word.put("[ten_phong]", appConText.getTenPhong());
				word.put("[thu_truong]", tenTt);
				word.put("[ttkt]", sb.toString());
				word.put("[ttkt]", sb.toString());
				word.put("[ve_viec]", cuocTtkt.getTenDonViBi());
				word.put("[thu_truong]", tenTt);
				// ----------------------------danh sach thanh vien doan---------------------------------//
				Dispatch table = word.openTable(2);
				//Collection dsThanhVienDoan = TtktService.getDanhSachThanhVienDoan(idCuocTtkt);
				
				TtktCbDsTvDoan dsTvDoan = TtktService.getDsTvd(idCuocTtkt, appConText);
				if(dsTvDoan==null){
					dsTvDoan = TtktService.getDsTvdInQd(idCuocTtkt, appConText);
				}				
				Collection dsThanhVienDoan = dsTvDoan.getChiTietDanhSachTV();
				
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
				// word.put("[thanh_vien_doan]", sbtvd.toString().substring(0, sbtvd.toString().length() - 1));
				word.put("[noi_duyet]", cbForm.getNoiPheDuyetDsTvd());
				// -------------ngay duyet---------------//
				word.put("[ngay_duyet]", Formater.getDateForPrint(cbForm.getNgayPheDuyetDsTvd()));
				// -------------ngay trinh---------------//
				word.put("[noi_lap]", cbForm.getNoiLapDsTvd());
				word.put("[ngay_trinh]", Formater.getDateForPrint(cbForm.getNgayLapDsTvd()));
				String defaultnull = KtnbUtil.inFieldNull(60);
				if (Formater.isNull(cbForm.getYkienPheDuyetDsTvd())) {
					word.put("[y_kien_phe_duyet]", defaultnull + "\n" + defaultnull);
				} else {
					word.put("[y_kien_phe_duyet]", cbForm.getYkienPheDuyetDsTvd());
				}
				// -------------------------------------------------//
				word.put("[ten_truong_phong]", appConText.getTenTruongPhong());
				// word.put("[ten_truong_phong]", cuocTtkt.getTenTruongDoan());
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appConText.getMaCqt()).toUpperCase());
				//word.put("[ten_thu_truong]", appConText.getTenThuTruong());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB04", ".doc", reponse);
			} catch (Exception ex) {
				 ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			}finally {				
				try { 
					word.saveAndClose();
				} catch (Exception e) {
					
				}
			}

			// -------------Bieu mau in Quyet Dinh TTKT --------------------//
		} else if ("qd".equals(request.getParameter("type"))) {
			fileIn = request.getRealPath("/docin") + "\\TTNB05.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB05_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			fileTemplate = "ttnb05";
			// ------------------------------------//
			String idCuocTtkt = cbForm.getIdCuocTtkt();
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtkTrongQd(appConText, idCuocTtkt);

			// --------------------------------------//
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhThuc1 = (cuocTtkt.getHinhThuc().booleanValue()) ? "Ki\u1EC3m tra" : "Thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
			StringBuffer sb_ht = new StringBuffer(hinhThuc);
			StringBuffer sb_ht1 = new StringBuffer(hinhThuc1);
			TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appConText);

			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt(appConText).toUpperCase());
				word.put("[cqt_ra_qd]", cuocTtkt.getTenDonViTh().toUpperCase());
				//
				if (Formater.isNull(cbForm.getSoQuyetDinh())) {
					word.put("[so_quyet_dinh]", "....../Q\u0110-.......");
				} else {
					word.put("[so_quyet_dinh]", cbForm.getSoQuyetDinh());
				}
				if (Formater.isNull(cbForm.getDiaDiemRaQuyetDinh())) {
					word.put("[noi_ra_quyet_dinh]", ".....");
				} else {
					word.put("[noi_ra_quyet_dinh]", cbForm.getDiaDiemRaQuyetDinh());
				}
				if (Formater.isNull(cbForm.getNgayRaQuyetDnh())) {
					word.put("[ngay_ra_qd]", "ng\u00E0y.....th\u00E1ng.....n\u0103m.....");
				} else {
					word.put("[ngay_ra_qd]", Formater.getDateForPrint(cbForm.getNgayRaQuyetDnh()));
				}

				word.put("[ttkt]", sb_ht.toString());
				word.put("[thu_truong_ban_hanhqd]", KtnbUtil.getTenThuTruongCqtForMauin(appConText).toUpperCase());
				word.put("[van_ban_quy_dinh]", CatalogService.getTenDanhMucById(cbForm.getVanBanQuyDinhCnangNvuQd()));
				if (Formater.isNull(cbForm.getVanBanKeHoach())) {
					// word.put("[van_ban_ke_hoach]", "C\u0103n c\u1EE9 k\u1EBF ho\u1EA1ch Thanh tra ki\u1EC3m tra n\u1ED9i b\u1ED9 n\u0103m " + getNamTienHanh(cuocTtkt.getMa()) + " c\u1EE7a "+
					// appConText.getTenCqt());
					word.put("[van_ban_ke_hoach]", "C\u0103n c\u1EE9 k\u1EBF ho\u1EA1ch Thanh tra ki\u1EC3m tra n\u1ED9i b\u1ED9 n\u0103m " + getNamTienHanh(cuocTtkt.getMa()) + " c\u1EE7a "
							+ KtnbUtil.getTenThuTruongCqt(appConText));
				} else {
					StringBuffer sbVanBanKeHoach = new StringBuffer("C\u0103n c\u1EE9 ");
					sbVanBanKeHoach.append(cbForm.getVanBanKeHoach());
					word.put("[van_ban_ke_hoach]", sbVanBanKeHoach.toString());
				}
				word.put("[nguoi_de_nghi]", KtnbUtil.getTenTruongBoPhan(appConText));				
				word.put("[ten_bo_phan]", KtnbUtil.getTenBoPhan(appConText));
				word.put("[cqt_ra_qd]", cuocTtkt.getTenDonViTh());
				word.put("[ttkt1]", sb_ht1.toString());
				if (KtnbUtil.isChiCuc(cuocTtkt.getIdDonViTh())) {
					String dvPhuthuoc = CuocTtktService.searchDvPhuthuoc(cuocTtkt.getId());
					if (dvPhuthuoc != null)
						cuocTtkt.setTenDonViBi(dvPhuthuoc);
				}
				word.put("[don_vi_dc_ttkt]", cuocTtkt.getTenDonViBi());				
				word.put("[ttkt]", sb_ht.toString());
				word.put("[ngay_lv]", cuocTtkt.getThoiGianDuKien().toString());
				word.put("[ttkt]", sb_ht.toString());
				word.put("[ttkt]", sb_ht.toString());
				// Loai (dot xuat hay dinh ky)
				String loai = (cuocTtkt.getLoai().booleanValue()) ? "\u0111\u1ED9t xu\u1EA5t" : "theo k\u1EBF ho\u1EA1ch";
				word.put("[hinh_thuc]", loai);
				word.put("[ttkt]", sb_ht.toString());
				// --------------------- danh sach thanh vien doan
				// ------------------------//
				Dispatch table = word.openTable(3);
				StringBuffer sbdstvd = new StringBuffer("");
				Collection chiTietDsTvd = TtktService.getDsTvd(idCuocTtkt, appConText).getChiTietDanhSachTV();
				Iterator iter = chiTietDsTvd.iterator();
				reportRows = new HashMap[chiTietDsTvd.size()];
				int i = 0;
				while (iter.hasNext()) {
					TtktCbChiTietDsTvDoan chiTietDsTvDoan = (TtktCbChiTietDsTvDoan) iter.next();
					String tenTv = (i + 1) + "." + " \u00D4ng (b\u00E0): " + chiTietDsTvDoan.getTenCanBo();
					for (int k = tenTv.length(); k < 28; k++)
						tenTv += " ";
					sbdstvd.append(tenTv);
					word.addCellTable(table, i + 1, 1, tenTv);
					// chuc vu
					String chucvuCongTac = Formater.isNull(chiTietDsTvDoan.getChucVu()) ? "" : chiTietDsTvDoan.getChucVu();
					for (int k = chucvuCongTac.length(); k < 10; k++)
						chucvuCongTac += " ";
					sbdstvd.append("- Ch\u1EE9c v\u1EE5: " + chucvuCongTac);
					word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + chucvuCongTac);
					// chuc vu trong doan
					String chucVuTrongDoan = chiTietDsTvDoan.getChucVuTrongDoan();
					if ("Truong doan".equals(chucVuTrongDoan))
						chucVuTrongDoan = "- Tr\u01B0\u1EDFng \u0111o\u00E0n";
					else if ("Pho doan".equals(chucVuTrongDoan))
						chucVuTrongDoan = "- Ph\u00F3 \u0111o\u00E0n";
					else
						chucVuTrongDoan = "- Th\u00E0nh vi\u00EAn \u0111o\u00E0n";
					sbdstvd.append(" " + chucVuTrongDoan);
					sbdstvd.append("\n");
					word.addCellTable(table, i + 1, 3, chucVuTrongDoan);
					word.addRowTable(table, chiTietDsTvd.size());
					i++;
				}
				// word.put("[ds_thanh_vien]", sbdstvd.toString().substring(0, sbdstvd.toString().length() - 1));

				word.put("[ttkt]", sb_ht.toString());
				word.put("[ttkt1]", sb_ht1.toString());
				word.put("[noi_dung_ttkt]", TtktService.getNoiDungTtkt(cuocTtkt));
				// word.put("[noi_dung_ttkt]", cbForm.getNoiDung());
				word.put("[ttkt]", sb_ht.toString());
				// Ngay bat dau ttkt
				word.put("[tu_ngay]", Formater.getDateForPrint(Formater.date2str(cuocTtkt.getNienDoTuNgay())));
				// Ngay ket thuc ttkt
				word.put("[den_ngay]", Formater.getDateForPrint(Formater.date2str(cuocTtkt.getNienDoDenNgay())));
				// ------------------------------------------------ //
				if (Formater.isNull(cbForm.getTenNguoiChiDaoGiamSat())) {
					word.put("[ten_nguoi_giam_sat]", ".....");
				} else {
					word.put("[ten_nguoi_giam_sat]", cbForm.getTenNguoiChiDaoGiamSat());
				}
				if (Formater.isNull(cbForm.getChucVuNguoiChiDaoGiamSat())) {
					word.put("[chuc_danh]", ".....");
				} else {
					StringBuffer sbcv = new StringBuffer(cbForm.getChucVuNguoiChiDaoGiamSat());
					sbcv.append(", ");
					sbcv.append(appConText.getTenPhong());
					word.put("[chuc_danh]", sbcv.toString());
				}
				
				word.put("[ttkt]", sb_ht.toString());
//				if (Formater.isNull(cbForm.getThuTruongCacDvLienQuan())) {
//					word.put("[truong_dv_lien_quan]", " C\u00E1c");
//				} else {
//					StringBuffer sbTruong_dv_lq = new StringBuffer("C\u00E1c \u00F4ng (b\u00E0) ");
//					sbTruong_dv_lq.append(cbForm.getThuTruongCacDvLienQuan() + ", c\u00E1c");
//					word.put("[truong_dv_lien_quan]", sbTruong_dv_lq.toString());
//				}
				// thu truong co quan thue doi tuong thanh tra kiem tra //
				word.put("[nguoi_de_nghi]", KtnbUtil.getTenTruongBoPhan(appConText));
				
				word.put("[ten_bo_phan]", KtnbUtil.getTenBoPhan(appConText));
				String thuTruongCacDonViCoLienQuan = cbForm.getThuTruongCacDvLienQuan();
				if(Formater.isNull(thuTruongCacDonViCoLienQuan)&&cbQd!=null)
					thuTruongCacDonViCoLienQuan = (cbQd.getThuTruongCacDvLienQuan()==null)?"":cbQd.getThuTruongCacDvLienQuan()+" ";
				String thuTruongDonVi ="";
				if(KtnbUtil.isChiCuc(CuocTtktService.getCuocTtkt(appConText, idCuocTtkt).getIdDonViBi())){
					thuTruongDonVi = "chi c\u1EE5c tr\u01B0\u1EDFng ";
				}
				if(KtnbUtil.isCuc(CuocTtktService.getCuocTtkt(appConText, idCuocTtkt).getIdDonViBi())){
					thuTruongDonVi = "c\u1EE5c tr\u01B0\u1EDFng ";
				}
				word.put("[truong_doi_tuong_ttkt]", thuTruongCacDonViCoLienQuan+" v\u00E0 "+thuTruongDonVi+cuocTtkt.getTenDonViBi());
				word.put("[co_quan_cap_tren_truc_tiep]", KtnbUtil.getTenCqtCapTrenTt(appConText));
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appConText.getMaCqt()).toUpperCase());
				//word.put("[ten_thu_truong_cqt]", appConText.getTenThuTruong());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB05", ".doc", reponse);
			} catch (Exception ex) {
				 ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {				
				try { 
					word.saveAndClose();
				} catch (Exception e) {
					
				}
			}

		} // Bieu mau in Ke Hoach TTKT //
		else if ("kh".equals(request.getParameter("type")) || "bmkh".equals(request.getParameter("type"))) {
			fileIn = request.getRealPath("/docin") + "\\TTNB12.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB12_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			fileTemplate = "ttnb12";
			//
			String idCuocTtkt = cbForm.getIdCuocTtkt();
			// doan ttkt so
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
			String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
			TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appConText);

			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_co_quan_thue_truc_tiep]", appConText.getTenCqt().toUpperCase());
				StringBuffer sb = new StringBuffer("\u0110O\u00C0N ");
				sb.append(hinhthuc_inT);
				if (Formater.isNull(cbForm.getSoQuyetDinh())) {
					sb.append(" Q\u0110 S\u1ED0......");
					// parameters.put("so_qd", "....");
				} else {
					sb.append(" Q\u0110 S\u1ED0 " + cbForm.getSoQuyetDinh());
					// parameters.put("so_qd", cbForm.getSoQuyetDinh());
				}
				word.put("[so_ttkt]", sb.toString());
				StringBuffer sb_ht = new StringBuffer(hinhThuc);
				word.put("[ttkt]", sb_ht.toString());

				// Ten don vi bi Ttkt
				sb = new StringBuffer("");
				sb.append(cuocTtkt.getTenDonViBi());
				word.put("[dv_duoc_ttkt]", sb.toString());
				// Thu truong cqt trinh duyet
				word.put("[tt_cq_thue_trinh_duyet]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				word.put("[ttkt]", sb_ht.toString());
				if (Formater.isNull(cbForm.getSoQuyetDinh())) {
					word.put("[so_qd]", "......");
				} else {
					word.put("[so_qd]", " " + cbForm.getSoQuyetDinh());
				}
				// Ngay ra quyet dinh
				word.put("[ngay_ra_quyet_dinh]", Formater.getDateForPrint(cbForm.getNgayRaQuyetDnh()));
				word.put("[thu_truong_co_quan_thue_ra_quyet_dinh]", KtnbUtil.getTenThuTruongCqt(appConText));
				word.put("[ttkt]", sb_ht.toString());
				word.put("[dv_duoc_ttkt]", sb.toString());
				word.put("[ttkt]", sb_ht.toString());
				word.put("[dv_duoc_ttkt]", sb.toString());
				word.put("[ttkt]", sb_ht.toString());
				word.put("[ttkt]", sb_ht.toString());
				if (Formater.isNull(cbForm.getMucDich())) {
					word.put("[muc_dich]", KtnbUtil.inFieldNull(98));
				} else {
					word.put("[muc_dich]", cbForm.getMucDich());
				}
				if (Formater.isNull(cbForm.getYeuCau())) {
					word.put("[yeu_cau]", KtnbUtil.inFieldNull(100));
				} else {
					word.put("[yeu_cau]", cbForm.getYeuCau());
				}
				word.put("[ttkt]", sb_ht.toString());
				if (Formater.isNull(cbForm.getNoiDung())) {
					word.put("[noi_dung]", "- " + KtnbUtil.inFieldNull(116));
				} else {
					word.put("[noi_dung]", "- " + cbForm.getNoiDung());
				}
				word.put("[ttkt]", sb_ht.toString());
				if (Formater.isNull(cbForm.getPhuongPhapTienHanh())) {
					word.put("[phuong_phap_tien_hanh]", "- " + KtnbUtil.inFieldNull(116));
				} else {
					word.put("[phuong_phap_tien_hanh]", "- " + cbForm.getPhuongPhapTienHanh());
				}
				// --------------- tien do thuc hien -------------------//
				if (Formater.isNull(cbForm.getToChucThucHien())) {
					word.put("[tien_do_thuc_hien]", "- Ti\u1EBFn \u0111\u1ED9 th\u1EF1c hi\u1EC7n");
				} else {
					sb = new StringBuffer("- Ti\u1EBFn \u0111\u1ED9 th\u1EF1c hi\u1EC7n: ");
					sb.append(cbForm.getToChucThucHien());
					word.put("[tien_do_thuc_hien]", sb.toString());
				}

				// ----------------che do thong tin bao cao------------------ //
				if (Formater.isNull(cbForm.getCheDoThongTinBaoCao())) {
					word.put("[che_do_tt_bao_cao]", "- Ch\u1EBF \u0111\u1ED9 th\u00F4ng tin b\u00E1o c\u00E1o");
				} else {
					sb = new StringBuffer("- Ch\u1EBF \u0111\u1ED9 th\u00F4ng tin b\u00E1o c\u00E1o: ");
					sb.append(cbForm.getCheDoThongTinBaoCao());
					word.put("[che_do_tt_bao_cao]", sb.toString());
				}
				// ---------------dieu kien vat chat -------------------//
				if (Formater.isNull(cbForm.getDieuKienVatChatDamBao())) {
					word.put("[dieu_kien_vat_chat]", "- \u0110i\u1EC1u ki\u1EC7n v\u1EADt ch\u1EA5t \u0111\u1EA3m b\u1EA3o ");
				} else {
					sb = new StringBuffer("- \u0110i\u1EC1u ki\u1EC7n v\u1EADt ch\u1EA5t \u0111\u1EA3m b\u1EA3o: ");
					sb.append(cbForm.getDieuKienVatChatDamBao());
					word.put("[dieu_kien_vat_chat]", sb.toString());
				}
				// ---------------nhung dieu kien khac ----------------------//
				if (Formater.isNull(cbForm.getNhungDieuKienKhac())) {
					word.put("[van_de_khac]", "- Nh\u1EEFng \u0111i\u1EC1u ki\u1EC7n kh\u00E1c (n\u1EBFu c\u00F3) ");
				} else {
					sb = new StringBuffer("- Nh\u1EEFng \u0111i\u1EC1u ki\u1EC7n kh\u00E1c: ");
					sb.append(cbForm.getNhungDieuKienKhac());
					word.put("[van_de_khac]", sb.toString());
				}
				// Thu truong cqt trinh duyet
				word.put("[tt_cq_thue_trinh_duyet]", KtnbUtil.getTenThuTruongCqtForMauin(appConText));
				// ngay duyet
				if (!Formater.isNull(cbForm.getNoiPheDuyetKeHoach()))
					word.put("[noi_duyet]", cbForm.getNoiPheDuyetKeHoach());
				if (!Formater.isNull(cbForm.getNgayPheDuyetKeHoach()))
				{
					word.put("[ngay_duyet]", Formater.getDateForPrint(cbForm.getNgayPheDuyetKeHoach()));
				}else
				{
					word.put("[ngay_duyet]", "Ng\u00E0y.....th\u00E1ng....n\u0103m.....");
				}
				// ngay lap
				if (!Formater.isNull(cbForm.getDiaDiemLapKeHoach()))
					word.put("[noi_lap]", cbForm.getDiaDiemLapKeHoach());
				if (!Formater.isNull(cbForm.getNgayLapKeHoach()))
					word.put("[ngay_lap]", Formater.getDateForPrint(cbForm.getNgayLapKeHoach()));
				String defaultnull = KtnbUtil.inFieldNull(60);
				if (Formater.isNull(cbForm.getYkienPheDuyetKh())) {
					word.put("[y_kien_phe_duyet]", defaultnull + "\n" + defaultnull);
				} else {
					word.put("[y_kien_phe_duyet]", cbForm.getYkienPheDuyetKh());
				}
				word.put("[ttkt]", sb_ht.toString().toUpperCase());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appConText.getMaCqt()).toUpperCase());
				//word.put("[ten_thu_truong]", appConText.getTenThuTruong());

				word.saveAndClose();
				word.downloadFile(fileOut, "Mau TTNB12", ".doc", reponse);
			} catch (Exception ex) {
				 ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {				
				try { 
					word.saveAndClose();
				} catch (Exception e) {
					
				}
			}

			// In de cuong //
		} else if ("dc".equals(request.getParameter("type")) || "bmdc".equals(request.getParameter("type"))) {
			fileIn = request.getRealPath("/docin") + "\\TTNB13.doc";
			fileOut = request.getRealPath("/docout") + "\\TTNB13_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";
			fileTemplate = "ttnb13";
			String idCuocTtkt = cbForm.getIdCuocTtkt();
			TtktCbDeCuong deCuong = TtktService.getDeCuong(cbForm.getIdCuocTtkt(), appConText);
			// doan ttkt so
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
			String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
			TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appConText);
			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", appConText.getTenCqt().toUpperCase());
				StringBuffer sb = new StringBuffer("\u0110O\u00C0N ");
				sb.append(hinhthuc_inT);
				if (Formater.isNull(cbForm.getSoQuyetDinh())) {
					sb.append(" Q\u0110 S\u1ED0......");
				} else {
					sb.append(" Q\u0110 S\u1ED0 " + cbForm.getSoQuyetDinh());
				}
				word.put("[doan_ttkt_so]", sb.toString().toUpperCase());
				word.put("[ten_bc]", "\u0110\u1EC0 C\u01AF\u01A0NG");
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				sb = new StringBuffer(hinhThuc);
				word.put("[ttkt]", sb.toString());
				if (Formater.isNull(cbForm.getSoQuyetDinh())) {
					word.put("[so_quyet_dinh]", "......");
				} else {
					word.put("[so_quyet_dinh]", " " + cbForm.getSoQuyetDinh());
				}
				word.put("[ngay_quyet_dinh]", Formater.getDateForPrint(cbForm.getNgayRaQuyetDnh()));
				word.put("[chuc_danh_thu_truong_co_quan_thue_ra_quyet_dinh]", KtnbUtil.getTenThuTruongCqt(appConText));
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", sb.toString());
			 	word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				word.put("[ttkt]", sb.toString());
				word.put("[ttkt]", sb.toString());
				
				/**-------------------SUA DOI CHUC NANG, IN LAY DU LIEU TREN TEXTBOX----------
				// ---------------danh sach bao cao---------------//
				//TtktCmHsTl[] arrdsbaocao = cbForm.getDsBaoCao();
				//Lay tu DB do loi Grid khong lay duoc tu tren form
				TtktCmHsTl[] arrdsbaocao = null;
				ArrayList listBaoCao = (ArrayList) deCuong.getBaoCaoPhaiCbiCungCap();
				if (!Formater.isNull(listBaoCao)) {
					arrdsbaocao = new TtktCmHsTl[listBaoCao.size()];
					for (int i = 0; i < listBaoCao.size(); i++) {
						TtktCmHsTl baoCao = (TtktCmHsTl) listBaoCao.get(i);
						baoCao.setStrThoiGianBanGiao(Formater.date2str(baoCao.getThoiGianBanGiao()));
						baoCao.setStrThoiKyDen(Formater.date2str(baoCao.getThoiKyDen()));
						baoCao.setStrThoiKyTu(Formater.date2str(baoCao.getThoiKyTu()));
						arrdsbaocao[i] = baoCao;
					}
				}
				StringBuffer baocao = new StringBuffer("");
				if (arrdsbaocao != null && arrdsbaocao.length > 0) {
					for (int i = 0; i < arrdsbaocao.length; i++) {
						if(arrdsbaocao[i]!=null){
							if (!Formater.isNull(arrdsbaocao[i].getNoiDung())) {
								baocao.append("Tên báo cáo:"+ arrdsbaocao[i].getTen()+","+"n\u1ED9i dung:" + arrdsbaocao[i].getNoiDung());
							}
							String thoiky = arrdsbaocao[i].getStrThoiKyTu();
							String thoikyden = arrdsbaocao[i].getStrThoiKyDen();
							if (!Formater.isNull(thoiky) || !Formater.isNull(thoikyden)) {
	
								String[] arrthoiky = thoiky.split("/");
								String[] arrthoikyden = thoikyden.split("/");
								baocao.append(", th\u1EDDi k\u1EF3 t\u1EEB: ng\u00E0y " + arrthoiky[0] + " th\u00E1ng " + arrthoiky[1] + " n\u0103m " + arrthoiky[2] + " \u0111\u1EBFn: ng\u00E0y "
										+ arrthoikyden[0] + " th\u00E1ng " + arrthoikyden[1] + " n\u0103m " + arrthoikyden[2]);
							}
							if (!Formater.isNull(arrdsbaocao[i].getHinhThuc())) {
								baocao.append(", h\u00ECnh th\u1EE9c: " + arrdsbaocao[i].getHinhThuc());
							}
							String thoigianbangiao = arrdsbaocao[i].getStrThoiGianBanGiao();
							String[] arrthoigianbangiao = thoigianbangiao.split("/");
							baocao.append(", th\u1EDDi gian b\u00E0n giao: ng\u00E0y " + arrthoigianbangiao[0] + " th\u00E1ng " + arrthoigianbangiao[1] + " n\u0103m " + arrthoigianbangiao[2]);
							baocao.append(", \u0111\u1ECBa \u0111i\u1EC3m nh\u1EADn: " + arrdsbaocao[i].getDiaDiemNhanName());
							baocao.append(", ng\u01B0\u1EDDi nh\u1EADn: " + arrdsbaocao[i].getNguoiNhanName() + ".");
							baocao.append("\n");
						}
					}
				}
				//System.out.println(baocao.toString());
				if(baocao!=null && !StringUtil.isBlankOrNull(baocao.toString())){
					word.put("[bao_cao]", baocao.toString().substring(0, baocao.toString().length() - 1));
				} else {
					word.put("[bao_cao]", "\t-" + KtnbUtil.inFieldNull(114) + " \n\t-" + KtnbUtil.inFieldNull(114));
				}
				// ---------------------danh sach ho so-----------------------//
				//TtktCmHsTl[] arrdshoso = cbForm.getDsHoSoTl();
				//Lay HSTL kem theo tu DB do loi khong lay duoc tu GRID
				TtktCmHsTl[] arrdshoso = null;
				ArrayList listHstl = (ArrayList) deCuong.getHstlPhaiCbiCungCap();
				if (!Formater.isNull(listHstl)) {
					arrdshoso = new TtktCmHsTl[listHstl.size()];
					for (int i = 0; i < listHstl.size(); i++) {
						TtktCmHsTl hsTl = (TtktCmHsTl) listHstl.get(i);
						hsTl.setStrThoiGianBanGiao(Formater.date2str(hsTl.getThoiGianBanGiao()));
						arrdshoso[i] = hsTl;
					}
				}
				StringBuffer hs = new StringBuffer("");
				if (arrdshoso != null && arrdshoso.length > 0) {					
						for (int i = 0; i < arrdshoso.length; i++) {
							if(arrdshoso[i]!=null){
								hs.append("\t- T\u00EAn h\u1ED3 s\u01A1, t\u00E0i li\u1EC7u: " + arrdshoso[i].getTen());
								String thoigianbangiao = arrdshoso[i].getStrThoiGianBanGiao();
								String[] arrthoigianbangiao = thoigianbangiao.split("/");
								hs.append(", th\u1EDDi gian b\u00E0n giao: ng\u00E0y " + arrthoigianbangiao[0] + " th\u00E1ng " + arrthoigianbangiao[1] + " n\u0103m " + arrthoigianbangiao[2]);
								hs.append(", \u0111\u1ECBa \u0111i\u1EC3m nh\u1EADn: " + arrdshoso[i].getDiaDiemNhanName());
								hs.append(", ng\u01B0\u1EDDi nh\u1EADn: " + arrdshoso[i].getNguoiNhanName() + ".");
								hs.append("\n");
							}
						}
						//System.out.println(hs.toString());
				}
				if(hs!=null&&!StringUtil.isBlankOrNull(hs.toString())){
					word.put("[ho_so]", hs.toString().substring(0, hs.toString().length() - 1));					
				} else {
					// parameters.put("ho_so", " -"+defaultNull);
					word.put("[ho_so]", "\t-" + KtnbUtil.inFieldNull(114) + "\n\t-" + KtnbUtil.inFieldNull(114));
				}
				*/
				
				// Bat dau in
				word.put("[bao_cao]", cbForm.getBcPhaiCbiCungCap());
				word.put("[ho_so]",cbForm.getHsPhaiCbiCungCap());
				if (Formater.isNull(cbForm.getNhungVanDeKhac())) {
					word.put("[van_de_khac]", "3. Nh\u1EEFng v\u1EA5n \u0111\u1EC1 kh\u00E1c li\u00EAn quan (n\u1EBFu c\u00F3) ");
				} else {
					word.put("[van_de_khac]", "3. Nh\u1EEFng v\u1EA5n \u0111\u1EC1 kh\u00E1c li\u00EAn quan: " + cbForm.getNhungVanDeKhac());
				}
				word.put("[ttkt]", sb.toString());
				word.put("[dv_dc_ttkt]", cuocTtkt.getTenDonViBi());
				// -----------------------------------------------------------//
				if (!Formater.isNull(cbForm.getNoiLapDeCuong()))
					word.put("[noi_lap]", cbForm.getNoiLapDeCuong());
				if (!Formater.isNull(cbForm.getNgayLapDeCuong())) {
					word.put("[ngay_lap]", Formater.getDateForPrint(cbForm.getNgayLapDeCuong()));
				}
				word.put("[ttkt]", sb.toString().toUpperCase());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				word.saveAndClose();

				word.downloadFile(fileOut, "Mau TTNB13", ".doc", reponse);
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Download Error: " + ex.getMessage());
			} finally {				
				try { 
					word.saveAndClose();
				} catch (Exception e) {
					
				}
			}
			// hop doan trien khai (ngon, chuan) mau 14 ttnb
		} else if ("hdtk".equals(request.getParameter("type"))) {
			fileIn = request.getRealPath("/docin") + "\\HDTK.doc";
			fileOut = request.getRealPath("/docout") + "\\HDTK_Out" + System.currentTimeMillis() + request.getSession().getId() + ".doc";

			fileTemplate = "hdtk";
			String idCuocTtkt = cbForm.getIdCuocTtkt();
			// doan ttkt so
			TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appConText, idCuocTtkt);
			String hinhThuc = (cuocTtkt.getHinhThuc().booleanValue()) ? "ki\u1EC3m tra" : "thanh tra";
			String hinhthuc_in = (cuocTtkt.getHinhThuc().booleanValue()) ? "KI\u1EC2M TRA" : "THANH TRA";
			String hinhthuc_inT = (cuocTtkt.getHinhThuc().booleanValue()) ? "KT" : "TT";
			TtktCbQd cbQd = TtktService.getQuyetDinh(idCuocTtkt, appConText);

			try {
				word = new MsWordUtils(fileIn, fileOut);
				word.put("[ten_cqt]", appConText.getTenCqt().toUpperCase());
				StringBuffer sb = new StringBuffer("\u0110O\u00C0N ");
				sb.append(hinhthuc_inT);
				if (Formater.isNull(cbForm.getSoQuyetDinh())) {
					sb.append(" Q\u0110 S\u1ED0...... ");
				} else {
					sb.append(" Q\u0110 S\u1ED0 " + cbForm.getSoQuyetDinh());
				}
				word.put("[so_ttkt]", sb.toString());
				sb = new StringBuffer(hinhThuc);
				word.put("[ttkt]", sb.toString().toUpperCase());

				// ngay gio bat dau
				word.put("[thoi_gian_hop]", KtnbUtil.getHour(cbForm.getThoiDiemBatDau()));
				word.put("[dia_diem]", cbForm.getDiaDiemHop());
				word.put("[ttkt]", sb.toString());
				word.put("[ttkt]", sb.toString());
				word.put("[noi_dung_tt]", cbForm.getVeViec());

				// danh sach thanh vien doan
				Dispatch table = word.openTable(2);
				TtktCmThanhPhanThamDu[] arrthanhphan = cbForm.getThanhPhanThamDuHopDoanTrienKhai();
				reportRows = new HashMap[arrthanhphan.length];
				StringBuffer tptd = new StringBuffer("");
				int j = 0; // dem so luong thanh vien doan , bo qua truong doan ttkt
				if (arrthanhphan != null && arrthanhphan.length > 0) {
					for (int i = 0; i < arrthanhphan.length; i++) {
						if (!cuocTtkt.getTenTruongDoan().equals(arrthanhphan[i].getHoTen())) {
							tptd.append((j + 1) + ". " + arrthanhphan[i].getHoTen() + "\n");// in danh sach thanh vien ki duyet
							j++;
						}
						String hoTen = (i + 1) + "." + " \u00D4ng (b\u00E0): " + arrthanhphan[i].getHoTen();
						word.addCellTable(table, i + 1, 1, hoTen);
						// Chuc vu
						word.addCellTable(table, i + 1, 2, "- Ch\u1EE9c v\u1EE5: " + arrthanhphan[i].getChucVu());
						word.addRowTable(table, arrthanhphan.length);
					}
					// word.put("[ds_thanh_vien]", tptd.toString().substring(0, tptd.toString().length() - 1));
				}
				word.put("[noi_dung]", cbForm.getNoiDungHopDoanTrienKhai());
				// ngay gio ket thuc
				word.put("[time_ket_thuc]", KtnbUtil.getHour(cbForm.getThoiDiemKetThuc()));
				word.put("[ttkt]", hinhthuc_inT.toUpperCase());
				if(tptd.toString().length()==0)
					word.put("[ds_thanh_vien]", "");
				else
					word.put("[ds_thanh_vien]", tptd.toString().substring(0, tptd.toString().length() - 1));
				word.put("[ttkt]", sb.toString().toUpperCase());
				word.put("[ten_truong_doan]", cuocTtkt.getTenTruongDoan());
				// word.put("[chuc_danh_thu_truong]", KtnbUtil.getChucVuThuTruongByMaCqt(appConText.getMaCqt()).toUpperCase());
				// word.put("[ten_thu_truong]", appConText.getTenThuTruong());
				word.saveAndClose();
				word.downloadFile(fileOut, "Mau HDTK", ".doc", reponse);
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

	private String getNamTienHanh(String maCuocTtkt) {
		String[] ma = maCuocTtkt.split("/");
		for (int i = 0; i < ma.length - 1; i++) {
			try {
				Integer.parseInt(ma[i]);
				return ma[i];
			} catch (Exception ex) {}
		}
		return null;
	}

	/**
	 * @param request
	 * @param appConText
	 * @param cbForm
	 */
	private void saveHopDoanTrienKhai(HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		TtktCmBienBan bbHopDoanTrienKhai = createBBHopDoanTK(request, appConText, cbForm);
		TtktService.saveBienBanHopDoanTK(appConText, bbHopDoanTrienKhai);
	}

	/**
	 * @param request
	 * @param appConText
	 * @param cbForm
	 */
	private void saveDeCuong(HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		TtktCbDeCuong deCuong = createDeCuong(request, appConText, cbForm);
		TtktService.saveDeCuong(appConText, deCuong);
	}

	/**
	 * @param request
	 * @param appConText
	 * @param cbForm
	 */
	private void saveKeHoach(HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		TtktCbKhTtkt khTtkt = createKeHoach(request, appConText, cbForm);
		TtktService.saveKeHoach(appConText, khTtkt);
	}

	/**
	 * @param request
	 * @param appConText
	 * @param cbForm
	 */
	private void saveQuyetDinh(HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		TtktCbQd qdTtkt = createQuyetDinh(request, appConText, cbForm);
		TtktService.saveQuyetDinh(appConText, qdTtkt);
	}

	/**
	 * @param request
	 * @param appConText
	 * @param cbForm
	 */
	private void saveThanhVienDoan(HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		TtktCbDsTvDoan dsTvd = createDsTvd(request, appConText, cbForm);
		dsTvd.setIsNew(Boolean.TRUE);
		TtktService.saveDsTvd(appConText, dsTvd);
	}

	/**
	 * @param request
	 * @param appConText
	 * @param cbForm
	 */
	private void saveBaoCaoKs(HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		TtktService.saveBaoCaoKs(request, appConText, cbForm);	}

	/**
	 * @param request
	 * @param appConText
	 * @param cbForm
	 * @return
	 */
	private TtktCmBienBan createBBHopDoanTK(HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		TtktCmBienBan bbHopDoanTrienKhai = new TtktCmBienBan();
		bbHopDoanTrienKhai.setDiaDiem(cbForm.getDiaDiemHop());
		bbHopDoanTrienKhai.setId(cbForm.getIdBienBanHopTrienKhaiDoan());
		bbHopDoanTrienKhai.setIdCuocTtkt(cbForm.getIdCuocTtkt());
		bbHopDoanTrienKhai.setLoai(Constants.TTKT_BB_HDTK);
		bbHopDoanTrienKhai.setNoiDung(cbForm.getNoiDungHopDoanTrienKhai());
		bbHopDoanTrienKhai.setThoiDiemBatDau(Formater.str2dateForNV(cbForm.getThoiDiemBatDau()));
		bbHopDoanTrienKhai.setThoiDiemKetThuc(Formater.str2dateForNV(cbForm.getThoiDiemKetThuc()));
		bbHopDoanTrienKhai.setVeViec(cbForm.getVeViec());
		bbHopDoanTrienKhai.setThanhPhanThamDu(creatDsThanhPhanThamDuHopTK(request, appConText, cbForm));
		bbHopDoanTrienKhai.setIdDsTvd(cbForm.getIdDsTvdHopTrienKhai());
		bbHopDoanTrienKhai.setIdNguoiCapNat(appConText.getMaCanbo());
		bbHopDoanTrienKhai.setTenNguoiCapNhat(appConText.getTenCanbo());
		bbHopDoanTrienKhai.setNgayCapNhat(new Date());
		return bbHopDoanTrienKhai;
	}

	/**
	 * @param request
	 * @param appConText
	 * @param cbForm
	 * @return
	 */
	private Collection creatDsThanhPhanThamDuHopTK(HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		ArrayList thanhPhanThamDu = new ArrayList();
		TtktCmThanhPhanThamDu[] arrThanhPhanThamDu = cbForm.getThanhPhanThamDuHopDoanTrienKhai();
		for (int i = 0; i < arrThanhPhanThamDu.length; i++) {
			TtktCmThanhPhanThamDu thamDu = arrThanhPhanThamDu[i];
			thamDu.setIdMaster(cbForm.getIdBienBanHopTrienKhaiDoan());
			thamDu.setIdNguoiCapNat(appConText.getMaCanbo());
			thamDu.setTenNguoiCapNhat(appConText.getTenCanbo());
			thamDu.setNgayCapNhat(new Date());
			thanhPhanThamDu.add(thamDu);
		}

		return thanhPhanThamDu;
	}

	/**
	 * @param request
	 * @param appConText
	 * @param cbForm
	 * @return
	 */
	private TtktCbDeCuong createDeCuong(HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		TtktCbDeCuong deCuong = new TtktCbDeCuong();
		deCuong.setId(cbForm.getIdDecuong());
		deCuong.setIdCuocTtkt(cbForm.getIdCuocTtkt());
		deCuong.setNgayLap(Formater.str2date(cbForm.getNgayLapDeCuong()));
		deCuong.setNhungVanDeKhac(cbForm.getNhungVanDeKhac());
		deCuong.setNoiLap(cbForm.getNoiLapDeCuong());
		
//		deCuong.setIdBaoCaoPhaiCbiCungCap(cbForm.getIdBaoCaoPhaiCbiCungCap_DC());
//		deCuong.setIdHstlPhaiCbiCungCap(cbForm.getIdHstlPhaiCbiCungCap_DC());
		
		// Begin edit ntmanh
		deCuong.setBaoCao(cbForm.getBcPhaiCbiCungCap());
		deCuong.setTaiLieu(cbForm.getHsPhaiCbiCungCap());
		deCuong.setIdDsTvd(cbForm.getIdDsTvdLapDeCuong());
		//----------------------------------------- 
		deCuong.setIdNguoiCapNat(appConText.getMaCanbo());
		deCuong.setTenNguoiCapNhat(appConText.getTenCanbo());
		deCuong.setNgayCapNhat(new Date());

		// Bao cao phai chuan bi va cung cap
//		Collection listBaoCao = new ArrayList();
//		TtktCmHsTl[] dsBaoCao = cbForm.getDsBaoCao();
//		if (dsBaoCao != null && dsBaoCao.length > 0) {
//			for (int i = 0; i < dsBaoCao.length; i++) {
//				TtktCmHsTl hstl = dsBaoCao[i];
//				hstl.setMasterId(deCuong.getIdBaoCaoPhaiCbiCungCap());
//				hstl.setThoiKyTu(Formater.str2date(hstl.getStrThoiKyTu()));
//				hstl.setThoiKyDen(Formater.str2date(hstl.getStrThoiKyDen()));
//				hstl.setThoiGianBanGiao(Formater.str2date(hstl.getStrThoiGianBanGiao()));
//				
//				listBaoCao.add(hstl);
//			}
//			deCuong.setBaoCaoPhaiCbiCungCap(listBaoCao);
//		}
//
//		// Ho so tai lieu phai chuan bi va cung cap
//		Collection listHoSoTl = new ArrayList();
//		TtktCmHsTl[] dsHoSoTl = cbForm.getDsHoSoTl();
//		if (dsHoSoTl != null && dsHoSoTl.length > 0) {
//			for (int i = 0; i < dsHoSoTl.length; i++) {
//				TtktCmHsTl hstl = dsHoSoTl[i];
//				hstl.setMasterId(deCuong.getIdHstlPhaiCbiCungCap());
//				hstl.setThoiGianBanGiao(Formater.str2date(hstl.getStrThoiGianBanGiao()));
//				listHoSoTl.add(hstl);
//			}
//			deCuong.setHstlPhaiCbiCungCap(listHoSoTl);
//		}
		/*
		deCuong.setMaFile(cbForm.getMaFileDeCuong());
		deCuong.setHaveFileAttack("true".equals(cbForm.getIsAttackDeCuong()) ? true : false);
		if (deCuong.isHaveFileAttack()) {// Dinh kem file
			FormFile fileDk = cbForm.getFileDinhKemDeCuong();
			if (fileDk!= null && !Formater.isNull(fileDk.getFileName())) {// Co file
				deCuong.setTenFile(fileDk.getFileName());
				deCuong.setLoaiFile(fileDk.getContentType());
				deCuong.setFileDinhKem(cbForm.getFileDinhKemDeCuong());
			}
		} else {// Khong dinh kem file
			if (!Formater.isNull(deCuong.getMaFile())) {// Co file cu
				deCuong.setTenFile(null);
				deCuong.setLoaiFile(null);
				deCuong.setFileDinhKem(null);
			}
		}*/
		return deCuong;
	}

	/**
	 * @param request
	 * @param appConText
	 * @param cbForm
	 * @return
	 */
	private TtktCbKhTtkt createKeHoach(HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		TtktCbKhTtkt khTtkt = new TtktCbKhTtkt();
		khTtkt.setCheDoThongTinBaoCao(cbForm.getCheDoThongTinBaoCao());
		khTtkt.setDiaDiemLap(cbForm.getDiaDiemLapKeHoach());
		khTtkt.setDieuKienVatChatDamBao(cbForm.getDieuKienVatChatDamBao());
		khTtkt.setId(cbForm.getIdKeHoach());
		khTtkt.setIdCuocTtkt(cbForm.getIdCuocTtkt());
		khTtkt.setMucDich(cbForm.getMucDich());
		khTtkt.setYkienPheDuyetKh(cbForm.getYkienPheDuyetKh());
		khTtkt.setNgayLap(Formater.str2date(cbForm.getNgayLapKeHoach()));
		khTtkt.setNgayPheDuyet(Formater.str2date(cbForm.getNgayPheDuyetKeHoach()));
		khTtkt.setNhungDieuKienKhac(cbForm.getNhungDieuKienKhac());
		khTtkt.setNoiDung(cbForm.getNoiDung());
		khTtkt.setNoiPheDuyet(cbForm.getNoiPheDuyetKeHoach());
		khTtkt.setYeuCau(cbForm.getYeuCau());
		khTtkt.setPhuongPhapTienHanh(cbForm.getPhuongPhapTienHanh());
		khTtkt.setToChucThucHien(cbForm.getToChucThucHien());
		khTtkt.setMaFile(cbForm.getMaFileKeHoach());
		khTtkt.setHaveFileAttack("true".equals(cbForm.getIsAttackKeHoach()) ? true : false);
		/*
		if (khTtkt.isHaveFileAttack()) {// Dinh kem file
			FormFile fileDk = cbForm.getFileDinhKemKeHoach();
			if (!Formater.isNull(fileDk.getFileName())) {// Co file
				khTtkt.setTenFile(fileDk.getFileName());
				khTtkt.setLoaiFile(fileDk.getContentType());
				khTtkt.setFileDinhKem(cbForm.getFileDinhKemKeHoach());
			}
		} else {// Khong dinh kem file
			if (!Formater.isNull(khTtkt.getMaFile())) {// Co file cu
				khTtkt.setTenFile(null);
				khTtkt.setLoaiFile(null);
				khTtkt.setFileDinhKem(null);
			}
		}*/
		
		khTtkt.setIdNguoiCapNat(appConText.getMaCanbo());
		khTtkt.setTenNguoiCapNhat(appConText.getTenCanbo());
		khTtkt.setNgayCapNhat(new Date());
		
		
		return khTtkt;
	}

	/**
	 * @param request
	 * @param appConText
	 * @param cbForm
	 * @return
	 */
	private TtktCbQd createQuyetDinh(HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		TtktCbQd qdTtkt = new TtktCbQd();
		qdTtkt.setIdCuocTtkt(cbForm.getIdCuocTtkt());
		qdTtkt.setDiaDiemRaQuyetDinh(cbForm.getDiaDiemRaQuyetDinh());
		qdTtkt.setId(cbForm.getIdQuyetDinh());
		qdTtkt.setNgayRaQuyetDnh(Formater.str2date(cbForm.getNgayRaQuyetDnh()));
		qdTtkt.setSoQuyetDinh(cbForm.getSoQuyetDinh());
		qdTtkt.setThuTruongCacDvLienQuan(cbForm.getThuTruongCacDvLienQuan());
		qdTtkt.setIdNguoiChiDaoGiamSat(cbForm.getIdNguoiChiDaoGiamSat());
		qdTtkt.setTenNguoiChiDaoGiamSat(cbForm.getTenNguoiChiDaoGiamSat());
		qdTtkt.setChucVuNguoiChiDaoGiamSat(cbForm.getChucVuNguoiChiDaoGiamSat());
		qdTtkt.setVanBanQuyDinhCnangNvuQd(cbForm.getVanBanQuyDinhCnangNvuQd());
		qdTtkt.setVanBanKeHoach(cbForm.getVanBanKeHoach());
		qdTtkt.setIdNguoiCapNat(appConText.getMaCanbo());
		qdTtkt.setTenNguoiCapNhat(appConText.getTenCanbo());
		qdTtkt.setNgayCapNhat(new Date());
		return qdTtkt;
	}

	/**
	 * @param request
	 * @param appConText
	 * @param cbForm
	 * @return
	 */
	private TtktCbDsTvDoan createDsTvd(HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		TtktCbDsTvDoan dsTvd = new TtktCbDsTvDoan();
		dsTvd.setId(cbForm.getIdDsTvd()); // Danh sach thanh vien doan da ton
		// tai tu giai doan chi dinh truong
		// doan
		dsTvd.setIdCuocTtkt(cbForm.getIdCuocTtkt());
		dsTvd.setNgayLap(Formater.str2date(cbForm.getNgayLapDsTvd()));
		dsTvd.setNgayPheDuyet(Formater.str2date(cbForm.getNgayPheDuyetDsTvd()));
		dsTvd.setNoiLap(cbForm.getNoiLapDsTvd());
		dsTvd.setNoiPheDuyet(cbForm.getNoiPheDuyetDsTvd());
		dsTvd.setYkienPheDuyet(cbForm.getYkienPheDuyetDsTvd());
		dsTvd.setVanBanQuyDinhCnangNvuQdTvd(cbForm.getVanBanQuyDinhCnangNvuQdTvd());

		// Chi tiet danh sach thanh vien doan
		Collection listThanhVienDoan = new ArrayList();
		TtktCbChiTietDsTvDoan[] chiTietDsTvd = cbForm.getChiTietDsTvd();
		for (int i = 0; i < chiTietDsTvd.length; i++) {
			if (!Constants.TTKT_CVTD_TD.equals(chiTietDsTvd[i].getChucVuTrongDoan())) { // Truong
				// doan
				// da
				// co
				TtktCbChiTietDsTvDoan thanhVienDoan = chiTietDsTvd[i];
				thanhVienDoan.setId(KeyManagement.getGUID());
				thanhVienDoan.setIdDsTvd(dsTvd.getId());
				listThanhVienDoan.add(thanhVienDoan);
			}

		}
		dsTvd.setChiTietDanhSachTV(listThanhVienDoan);

		return dsTvd;
	}
}
