package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBbChitietvatonghop;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThCongBoQd;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktService;
import cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.form.BienBanChiTietForm;

/**
 * Form bean for a Struts application.
 * @version 	1.0
 * @author
 */
public class BienBanChiTietAction extends BaseDispatchAction {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {

		BienBanChiTietForm bienBanChiTietForm = (BienBanChiTietForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String method = request.getParameter("method");
		if ("save".equals(method)) {
			TtktThBbChitietvatonghop bbChiTiet = createBienbanChiTiet(appContext, bienBanChiTietForm);
			String id = TtktService.saveBienBanChiTiet(appContext, bbChiTiet, bienBanChiTietForm.getThoiDiemLapBb(), bienBanChiTietForm.getThoiDiemThongQua());
			// Danh sach thanh vien doan
			loadDsTvDoan(bbChiTiet.getIdCuocTtkt(), request);
			request.setAttribute("cucsses", "cucsses");
			if (Formater.isNull(bienBanChiTietForm.getId())) {
				request.setAttribute("updateType", "insert");
				bienBanChiTietForm.setId(id);
			} else {
				
				request.setAttribute("updateType", "update");
			}

			
		} else if("downLoadMau".equals(method)){
			downLoadMau(request,reponse);
			return null;
		}else {
			String cuocTtktId = request.getParameter("idCuocTtkt");
			if (Formater.isNull(cuocTtktId)) { // Truong hop sua
				String idBienBan = request.getParameter("id");
				if (!Formater.isNull(idBienBan)) {
					loadToEdit(appContext, request, idBienBan, bienBanChiTietForm);
					// Danh sach thanh vien doan
					loadDsTvDoan(bienBanChiTietForm.getIdCuocTtkt(), request);
				} else { // Truong hop save

				}
			} else { // Truong hop tao moi
				TtktThCongBoQd congBoQd = TtktService.getCongBoQd(appContext, cuocTtktId);
				if (congBoQd == null) {
					request.setAttribute("chua_cong_bo_quyet_dinh", "true");
					//return mapping.findForward("success");
				}
				bienBanChiTietForm.setIdCuocTtkt(cuocTtktId);
				bienBanChiTietForm.setDiaDiemLapBb(KtnbUtil.getTenTinhByMaCqt(appContext, CuocTtktService.getCuocTtkt(appContext, cuocTtktId).getIdDonViBi()));
				// Danh sach thanh vien doan
				loadDsTvDoan(cuocTtktId, request);
			}

		}
		return mapping.findForward("success");
	}
	//v3
	private void downLoadMauv3(HttpServletRequest request, HttpServletResponse response){
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(request.getRealPath("/docin") + "\\TTNB33.doc");
			byte[] buffer = new byte[1024];
			int nbytes = 0;
			response.reset();
			response.setContentType("application/msword");
			response.setHeader("Cache-Control", "max-age=0");
			response.setHeader("Content-Disposition", "attachment;filename=" + "TTNB33.doc");
			try {
				OutputStream outputStream = response.getOutputStream();
				while ((nbytes = inputStream.read(buffer)) != -1)
					outputStream.write(buffer, 0, nbytes);
				outputStream.flush();
				outputStream.close();
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//v4
	private void downLoadMau(HttpServletRequest request, HttpServletResponse response){
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(request.getRealPath("/docin/v4") + "\\TTNB32.doc");
			byte[] buffer = new byte[1024];
			int nbytes = 0;
			response.reset();
			response.setContentType("application/msword");
			response.setHeader("Cache-Control", "max-age=0");
			response.setHeader("Content-Disposition", "attachment;filename=" + "TTNB32.doc");
			try {
				OutputStream outputStream = response.getOutputStream();
				while ((nbytes = inputStream.read(buffer)) != -1)
					outputStream.write(buffer, 0, nbytes);
				outputStream.flush();
				outputStream.close();
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * @param appContext
	 * @param bienBanChiTietForm
	 * @return
	 */
	private TtktThBbChitietvatonghop createBienbanChiTiet(ApplicationContext appContext, BienBanChiTietForm bienBanChiTietForm) throws Exception {
		TtktThBbChitietvatonghop bbChiTiet = new TtktThBbChitietvatonghop();
		bbChiTiet.setDiaDiemLapBb(bienBanChiTietForm.getDiaDiemLapBb());
		bbChiTiet.setId(bienBanChiTietForm.getId());
		bbChiTiet.setIdCuocTtkt(bienBanChiTietForm.getIdCuocTtkt());
		bbChiTiet.setIdNguoiLap(bienBanChiTietForm.getIdNguoiLap());
		bbChiTiet.setNgayPhanCongCuaTd(Formater.str2SQLdate(bienBanChiTietForm.getNgayPhanCongCuaTd()));
		bbChiTiet.setTenNguoiLap(bienBanChiTietForm.getTenNguoiLap());
		bbChiTiet.setTgianThDenNgay(Formater.str2SQLdate(bienBanChiTietForm.getTgianThDenNgay()));
		bbChiTiet.setTgianThTuNgay(Formater.str2SQLdate(bienBanChiTietForm.getTgianThTuNgay()));

		bbChiTiet.setTtktTai(bienBanChiTietForm.getTtktTai());
		bbChiTiet.setFileDinhKem(bienBanChiTietForm.getFileDinhKem());
		return bbChiTiet;
	}
	/**
	 * @param appContext
	 * @param request
	 * @param idBienBan
	 * @param bienBanChiTietForm
	 */
	private void loadToEdit(ApplicationContext appContext, HttpServletRequest request, String idBienBan, BienBanChiTietForm bienBanChiTietForm) throws Exception {
		TtktThBbChitietvatonghop bbChiTiet = TtktService.getBbChiTietVaTongHopById(appContext, idBienBan);
		bienBanChiTietForm.setDiaDiemLapBb(bbChiTiet.getDiaDiemLapBb());
		bienBanChiTietForm.setId(bbChiTiet.getId());
		bienBanChiTietForm.setIdCuocTtkt(bbChiTiet.getIdCuocTtkt());
		bienBanChiTietForm.setIdNguoiLap(bbChiTiet.getIdNguoiLap());
		bienBanChiTietForm.setNgayPhanCongCuaTd(Formater.date2str(bbChiTiet.getNgayPhanCongCuaTd()));
		bienBanChiTietForm.setTenNguoiLap(bbChiTiet.getTenNguoiLap());
		bienBanChiTietForm.setTgianThDenNgay(Formater.date2str(bbChiTiet.getTgianThDenNgay()));
		bienBanChiTietForm.setTgianThTuNgay(Formater.date2str(bbChiTiet.getTgianThTuNgay()));
		bienBanChiTietForm.setThoiDiemLapBb(Formater.date2strDateTimeForNV(bbChiTiet.getThoiDiemLapBb()));
		bienBanChiTietForm.setTtktTai(bbChiTiet.getTtktTai());
		bienBanChiTietForm.setThoiDiemThongQua(Formater.date2strDateTimeForNV(bbChiTiet.getThoiDiemThongQua()));
		
		//bienBanChiTietForm.set

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
		request.setAttribute("dsThanhVienDoan", dsThanhVienDoan);
		request.setAttribute("cbChiTietDsTvd", cbDsThanhVienDoan);
		request.setAttribute("dsIdThanhVienDoan", dsIdThanhVienDoan.substring(0, dsIdThanhVienDoan.length() - 1));
		request.setAttribute("dsChucVuTrongDoan", dsChucVuTrongDoan.substring(0, dsChucVuTrongDoan.length() - 1));
		//thoiDiemCongBo
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		try {
			TtktCbQd qd= TtktService.getQuyetDinh(cuocTtktId, appContext);
			TtktThCongBoQd cbqd = TtktService.getCongBoQd(appContext, cuocTtktId);
			request.setAttribute("ngayRaQuyetDinh", Formater.objectDate2Str(qd.getNgayRaQuyetDnh()));
			request.setAttribute("thoiDiemCongBo", Formater.objectDate2Str(cbqd.getThoiDiemCbTu()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param cuocTtktId
	 * @param BienBanChiTietForm
	 * @param appContext
	 * @param request
	 */
	private void loadDefaultForm(String cuocTtktId, BienBanChiTietForm BienBanChiTietForm, ApplicationContext appContext, HttpServletRequest request) throws Exception {

	}

}
