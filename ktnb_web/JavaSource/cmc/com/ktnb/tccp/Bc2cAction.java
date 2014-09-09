package cmc.com.ktnb.tccp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.pl.hb.entity.Ttcp2c;
import cmc.com.ktnb.pl.hb.entity.TtcpBaoCaoId;
import cmc.com.ktnb.service.TtcpService;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DateUtil;
import cmc.com.ktnb.web.BaseDispatchAction;

public class Bc2cAction extends BaseDispatchAction{
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Bc2cForm bcform = (Bc2cForm) form;
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
		Ttcp2c bc2c = null;
		bc2c = service.get2c(appContext, appContext.getMaCqt(), bcform.getThang(),bcform.getNam());
		if(bc2c!=null){
			bcform.fromEntity(bc2c, appContext);
		}
		else {
			bc2c = new Ttcp2c();
			TtcpBaoCaoId id = new  TtcpBaoCaoId();
			id.setMaCqt(appContext.getMaCqt());
			id.setThang(bcform.getThang());
			id.setNam(bcform.getNam());
			bc2c.setId(id);
			bc2c.setNgayCuoiThang(DateUtil.getLastDayOfMonth(bcform.getNam().intValue(), bcform.getThang().intValue()));
			bcform.fromEntity(bc2c, appContext);
		}		
		return mapping.findForward("success");
	}
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		Bc2cForm bcform = (Bc2cForm) form;		
		try {
			Ttcp2c bc2c = null;
			bc2c = bcform.toEntity();
			TtcpService service = new TtcpService();
			if(service.get2c(appContext, bcform.getMaCqt(), bcform.getThang(), bcform.getNam()) == null){
				service.save2c(appContext, bc2c);
			}else{
				service.update2c(appContext, bc2c);
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
