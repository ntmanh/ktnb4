package cmc.com.ktnb.tccp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.pl.hb.entity.Ttcp2a;
import cmc.com.ktnb.pl.hb.entity.Ttcp2d;
import cmc.com.ktnb.pl.hb.entity.TtcpBaoCaoId;
import cmc.com.ktnb.service.TtcpService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DateUtil;
import cmc.com.ktnb.web.BaseDispatchAction;

public class Bc2dAction extends BaseDispatchAction{
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Bc2dForm bcform = (Bc2dForm) form;
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		//Get so lieu co dinh
		bcform.setMaCqt(appContext.getMaCqt());
		if(bcform.getThang()==null){	
			bcform.setThang(new Integer(DateUtil.getCurrentMonth()));
		}
		if(bcform.getNam()==null){			
			bcform.setNam(new Integer(DateUtil.getCurrentYear()));
		}
				
		TtcpService service = new TtcpService();
		Ttcp2d bc2d = null;
		bc2d = service.get2d(appContext, appContext.getMaCqt(), bcform.getThang(),bcform.getNam());
		if(bc2d!=null){
			bcform.fromEntity(bc2d, appContext);
		}
		else {
			bc2d = new Ttcp2d();
			TtcpBaoCaoId id = new  TtcpBaoCaoId();
			id.setMaCqt(appContext.getMaCqt());
			id.setThang(bcform.getThang());
			id.setNam(bcform.getNam());
			bc2d.setId(id);
			bc2d.setNgayCuoiThang(DateUtil.getLastDayOfMonth(bcform.getNam().intValue(), bcform.getThang().intValue()));
			bcform.fromEntity(bc2d, appContext);
		}		
		return mapping.findForward("success");
	}
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		Bc2dForm bcform = (Bc2dForm) form;		
		try {
			Ttcp2d bc2d = null;
			bc2d = bcform.toEntity();
			TtcpService service = new TtcpService();
			if(service.get2d(appContext, bcform.getMaCqt(), bcform.getThang(), bcform.getNam()) == null){
				service.save2d(appContext, bc2d);
			}else{
				service.update2d(appContext, bc2d);
			}
			request.setAttribute("ghiThanhcong", "1");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("ghiThanhcong", "0");
			throw new Exception(e);
		}
		return mapping.findForward("success");
	}	
}
