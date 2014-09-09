package cmc.com.ktnb.tccp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.pl.hb.entity.Ttcp1b;
import cmc.com.ktnb.pl.hb.entity.Ttcp2a;
import cmc.com.ktnb.pl.hb.entity.TtcpBaoCaoId;
import cmc.com.ktnb.service.TtcpService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DateUtil;
import cmc.com.ktnb.web.BaseDispatchAction;

public class Bc1bAction extends BaseDispatchAction{
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Bc1bForm bcform = (Bc1bForm) form;
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
		Ttcp1b bc1b = null;
		bc1b = service.get1b(appContext, appContext.getMaCqt(), bcform.getThang(),bcform.getNam());
		if(bc1b!=null){
			bcform.fromEntity(bc1b, appContext);
		}
		else {
			bc1b = new Ttcp1b();
			TtcpBaoCaoId id = new  TtcpBaoCaoId();
			id.setMaCqt(appContext.getMaCqt());
			id.setThang(bcform.getThang());
			id.setNam(bcform.getNam());
			bc1b.setId(id);
			bc1b.setNgayCuoiThang(DateUtil.getLastDayOfMonth(bcform.getNam().intValue(), bcform.getThang().intValue()));
			bcform.fromEntity(bc1b, appContext);
		}		
		return mapping.findForward("success");
	}
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		Bc1bForm bcform = (Bc1bForm) form;		
		try {
			Ttcp1b bc1b = null;
			bc1b = bcform.toEntity();
			TtcpService service = new TtcpService();
			if(service.get1b(appContext, bcform.getMaCqt(), bcform.getThang(), bcform.getNam()) == null){
				service.save1b(appContext, bc1b);
			}else{
				service.update1b(appContext, bc1b);
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
