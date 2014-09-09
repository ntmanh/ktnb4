package cmc.com.ktnb.web.ttkt.ket_thuc_ttkt.action;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.web.ttkt.ket_thuc_ttkt.form.YkienTVDForm;
import cmc.com.ktnb.web.ttkt.service.TtktCnPhuService;
import cmc.com.ktnb.web.ttkt.service.TtktService;



	

public class YkienTVDAction  extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		YkienTVDForm ykienForm = (YkienTVDForm) form;
		String method = request.getParameter("method");
		ApplicationContext app = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		String cuocTtktId = request.getParameter("cuocTtktId");

		if (cuocTtktId == null) {
			cuocTtktId = ykienForm.getIdCuocTtKt();
		}
		loadDsTvDoan(cuocTtktId,request);
		if ("save".equals(method)) {
			saveYKienDuThao(ykienForm);
			request.setAttribute("save", "ok");
		} else {
			loadDsChiTietTVD(request,ykienForm,cuocTtktId);	
			if (!KtnbUtil.haveRoleNv(app) || app.getTrangThaiCuocTtkt(ykienForm.getIdCuocTtKt()).equals(Constants.TT_TTKT_KT))
				request.setAttribute("readOnly", "true");
		}
		return mapping.findForward("success");
	}
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
		request.setAttribute("chiTietDsTvd", dsThanhVienDoan);
		request.setAttribute("dsThanhVienDoan", dsThanhVienDoan);
		request.setAttribute("cbChiTietDsTvd", cbDsThanhVienDoan);
		request.setAttribute("dsIdThanhVienDoan", dsIdThanhVienDoan.substring(0, dsIdThanhVienDoan.length() - 1));
		request.setAttribute("dsChucVuTrongDoan", dsChucVuTrongDoan.substring(0, dsChucVuTrongDoan.length() - 1));
		
	}
	
	private void loadDsChiTietTVD(HttpServletRequest request,YkienTVDForm form,String idCuocTtKt) throws Exception{
		Collection list = TtktCnPhuService.getDsChiTietDSTVD(idCuocTtKt);
		TtktCbChiTietDsTvDoan[] arr =new TtktCbChiTietDsTvDoan[list.size()];
		Iterator iter = list.iterator();
		int i = 0;
		while (iter.hasNext()) {
			TtktCbChiTietDsTvDoan tptd = (TtktCbChiTietDsTvDoan) iter.next();
			arr[i] = tptd;
			i++;
		}
		form.setDsChiTietTVD(arr);
		form.setIdCuocTtKt(idCuocTtKt);
	}
	
	private void saveYKienDuThao(YkienTVDForm ykienForm)throws Exception{
		TtktCnPhuService.saveYKienDuThao(ykienForm.getDsChiTietTVD());
	}
}
