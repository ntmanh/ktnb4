package cmc.com.ktnb.web.kntc.ket_qua;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KntcBCKQThucHienQDKN;
import cmc.com.ktnb.pl.hb.entity.KntcKqxmKluatKnghi;
import cmc.com.ktnb.pl.hb.entity.KntcQdinhGquyet;
import cmc.com.ktnb.service.kntc.SoTiepDanService;
import cmc.com.ktnb.service.kntc.XacMinhService;
import cmc.com.ktnb.service.kntc.XuLyKNTCService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HttpUtil;
import cmc.com.ktnb.web.BaseDispatchAction;

public class BaoCaoKetQuaThucHienAction extends BaseDispatchAction {
	
	public ActionForward saveBaoCaoThiHanhKhieuNai(ActionMapping map, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		BaoCaoKetQuaThucHienForm cnForm = (BaoCaoKetQuaThucHienForm) form;
		boolean isKN = SoTiepDanService.isKN(appContext, cnForm.getMaHs());
		try {
			XuLyKNTCService s = new XuLyKNTCService();
			//Check quyet dinh 18.19
			if(isKN){
				XacMinhService sm = new XacMinhService();
				KntcKqxmKluatKnghi qd18 = sm.getKqxmKluatKnghiByMaHs(appContext, cnForm.getMaHs());
				if(qd18 == null){
					throw new KtnbException("Ph&#7843;i nh&#7853;p th&#244;ng tin m&#7851;u s&#7889; 18/KNTC tr&#432;&#7899;c khi nh&#7853;p k&#7871;t th&#250;c thi h&#224;nh", "",
					"Ph&#7843;i nh&#7853;p th&#244;ng tin m&#7851;u s&#7889; 18/KNTC tr&#432;&#7899;c khi nh&#7853;p k&#7871;t th&#250;c thi h&#224;nh");
				}
				XuLyKNTCService sl = new XuLyKNTCService();
				KntcQdinhGquyet qd19 = sl.getQdinhGquyet(appContext, cnForm.getMaHs());
				if(qd19 == null){
					throw new KtnbException("Ph&#7843;i nh&#7853;p th&#244;ng tin m&#7851;u s&#7889; 19/KNTC tr&#432;&#7899;c khi nh&#7853;p k&#7871;t th&#250;c thi h&#224;nh", "",
					"Ph&#7843;i nh&#7853;p th&#244;ng tin m&#7851;u s&#7889; 19/KNTC tr&#432;&#7899;c khi nh&#7853;p k&#7871;t th&#250;c thi h&#224;nh");
				}
			}
			//Check quyet dinh 24.26
			else{
				XacMinhService sm = new XacMinhService();
				KntcKqxmKluatKnghi qd24 = sm.getKqxmKluatKnghiByMaHs(appContext, cnForm.getMaHs());
				if(qd24 == null){
					throw new KtnbException("Ph&#7843;i nh&#7853;p th&#244;ng tin m&#7851;u s&#7889; 24/KNTC tr&#432;&#7899;c khi nh&#7853;p k&#7871;t th&#250;c thi h&#224;nh", "",
					"Ph&#7843;i nh&#7853;p th&#244;ng tin m&#7851;u s&#7889; 24/KNTC tr&#432;&#7899;c khi nh&#7853;p k&#7871;t th&#250;c thi h&#224;nh");
				}
				XuLyKNTCService sl = new XuLyKNTCService();
				KntcQdinhGquyet qd26 = sl.getQdinhGquyet(appContext, cnForm.getMaHs());
				if(qd26 == null){
					throw new KtnbException("Ph&#7843;i nh&#7853;p th&#244;ng tin m&#7851;u s&#7889; 26/KNTC tr&#432;&#7899;c khi nh&#7853;p k&#7871;t th&#250;c thi h&#224;nh", "",
					"Ph&#7843;i nh&#7853;p th&#244;ng tin m&#7851;u s&#7889; 26/KNTC tr&#432;&#7899;c khi nh&#7853;p k&#7871;t th&#250;c thi h&#224;nh");
				}
			}
			s.saveBCKQThucHienKN(appContext, cnForm.toEntity(appContext));
			request.setAttribute("ghiThanhcong2", "1");
		} catch (Exception e) {
			request.setAttribute("ghiThanhcong2", "0");
			e.printStackTrace();
			throw e;
		}
		if(isKN){
			HttpUtil.doForward("kntc_kq_xm.do?method=ketThuc&action=ketThucKhieuNai&id=" + cnForm.getMaHs(), request, response);
		}else{
			HttpUtil.doForward("kntc_kq_xm.do?method=ketThuc&action=ketThucToCao&id=" + cnForm.getMaHs(), request, response);
		}		
		return null;
	}
}
