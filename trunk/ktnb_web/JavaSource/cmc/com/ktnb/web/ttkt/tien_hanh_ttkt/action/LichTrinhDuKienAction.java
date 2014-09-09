package cmc.com.ktnb.web.ttkt.tien_hanh_ttkt.action;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThCongBoQd;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbCache;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.web.BaseDispatchAction;
import cmc.com.ktnb.web.ttkt.service.CuocTtktService;
import cmc.com.ktnb.web.ttkt.service.TtktService;

/**
 * Form bean for a Struts application.
 * 
 * @version 1.0
 * @author
 */
public class LichTrinhDuKienAction extends BaseDispatchAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		String idCuocTtkt = request.getParameter("idCuocTtkt");
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// Quyet dinh
		TtktCbQd qd = TtktService.getQuyetDinh(idCuocTtkt, appContext);
		if (qd == null)
			throw new Exception("Chua co quyet dinh Thanh tra Kiem tra");
		HashMap thoiHanTtkt = (HashMap) KtnbCache.getInstance().get("MAP_THTTKT");

		// 1.Quyet dinh
		String thQuyetDinh = (String) thoiHanTtkt.get(Constants.TH_TTKT_QD);
		request.setAttribute("th_quyet_dinh", thQuyetDinh.length() >= 2 ? thQuyetDinh : "0" + thQuyetDinh);
		Date ngayRaQd = qd.getNgayRaQuyetDnh();

		request.setAttribute("quyet_dinh", Formater.date2str(ngayRaQd));

		// 2.Lap ke hoach
		String thKeHoach = (String) thoiHanTtkt.get(Constants.TH_TTKT_LKH);
		request.setAttribute("th_lap_ke_hoach", thKeHoach.length() >= 2 ? thKeHoach : "0" + thKeHoach);
		Date ngayLapKh = KtnbUtil.addBusinessDate(ngayRaQd, Formater.str2num(thKeHoach).intValue());
		request.setAttribute("lap_ke_hoach", Formater.date2str(ngayLapKh));

		// 3.Ngay duyet ke hoach
		String thDuyetKeHoach = (String) thoiHanTtkt.get(Constants.TH_TTKT_DKH);
		request.setAttribute("th_duyet_ke_hoach", thDuyetKeHoach.length() >= 2 ? thDuyetKeHoach : "0" + thDuyetKeHoach);
		Date ngayDuyetKh = KtnbUtil.addBusinessDate(ngayLapKh, Formater.str2num(thDuyetKeHoach).intValue());
		request.setAttribute("duyet_ke_hoach", Formater.date2str(ngayDuyetKh));

		// 4.Ngay lap de cuong
		String thLapDc = (String) thoiHanTtkt.get(Constants.TH_TTKT_DC);
		request.setAttribute("th_de_cuong", thLapDc.length() >= 2 ? thLapDc : "0" + thLapDc);
		Date ngayLapDc = KtnbUtil.addBusinessDate(ngayRaQd, Formater.str2num(thLapDc).intValue());
		request.setAttribute("de_cuong", Formater.date2str(ngayLapDc));

		// 5.Ngay cong bo
		String thCongBo = (String) thoiHanTtkt.get(Constants.TH_TTKT_CB);
		request.setAttribute("th_cong_bo", thCongBo.length() >= 2 ? thCongBo : "0" + thCongBo);
		//TtktThCongBoQd congBoQd = TtktService.getCongBoQd(appContext, idCuocTtkt);
		Date ngayCongBo;
		//if (congBoQd == null) {
			ngayCongBo = KtnbUtil.addBusinessDate(ngayRaQd, Formater.str2num(thCongBo).intValue());
		//} else
			//ngayCongBo = congBoQd.getThoiDiemCbTu();
		request.setAttribute("cong_bo", Formater.date2str(ngayCongBo));

		// 6.Ngay ket thuc
		TtktKhCuocTtkt cuocTtkt = CuocTtktService.getCuocTtktWithoutNoiDung(appContext, idCuocTtkt);
		int iThoiGianDuKien = cuocTtkt.getThoiGianDuKien().intValue();
		request.setAttribute("th_ket_thuc_ttkt", iThoiGianDuKien >= 10 ? String.valueOf(iThoiGianDuKien) : "0" + iThoiGianDuKien);
		int iThoiHanKt = iThoiGianDuKien + TtktService.getTongThoiGianRaHan(appContext, idCuocTtkt);
		Date ngayKetThuc = KtnbUtil.addBusinessDate(ngayCongBo, iThoiHanKt);
		request.setAttribute("ket_thuc_ttkt", Formater.date2str(ngayKetThuc));

		// 7.Bao cao ket qua, du thao kl
		String thoiHanBcKetQua = (String) thoiHanTtkt.get(Constants.TH_TTKT_KQ);
		request.setAttribute("th_bao_cao_kq", thoiHanBcKetQua.length() >= 2 ? thoiHanBcKetQua : "0" + thoiHanBcKetQua);
		Date ngayBcKq = KtnbUtil.addBusinessDate(ngayKetThuc, Formater.str2num(thoiHanBcKetQua).intValue());
		request.setAttribute("bao_cao_kq", Formater.date2str(ngayBcKq));

		// 8.Ket luan
		String thKetLuan = (String) thoiHanTtkt.get(Constants.TH_TTKT_KL);
		request.setAttribute("th_ket_luan", thKetLuan.length() >= 2 ? thKetLuan : "0" + thKetLuan);
		Date ngayKetLuan = KtnbUtil.addBusinessDate(ngayBcKq, Formater.str2num(thKetLuan).intValue());
		request.setAttribute("ket_luan", Formater.date2str(ngayKetLuan));

		// 9.Ban giao hstl cho td
		String thBanGiaoHstl = (String) thoiHanTtkt.get(Constants.TH_TTKT_BGHSLT);
		request.setAttribute("th_ban_giao_hslt", thBanGiaoHstl.length() >= 2 ? thBanGiaoHstl : "0" + thBanGiaoHstl);
		Date ngayBanGiao = KtnbUtil.addBusinessDate(ngayKetLuan, Formater.str2num(thBanGiaoHstl).intValue());
		request.setAttribute("ban_giao_hslt", Formater.date2str(ngayBanGiao));

		return mapping.findForward("success");
	}

}
