package cmc.com.ktnb.web.kntc.xu_ly;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.pl.hb.entity.KntcChuyenCqDieuTra;
import cmc.com.ktnb.web.BaseActionForm;
import cmc.com.ktnb.web.BaseDispatchAction;

public class ChuyenCqDieuTraForm extends BaseActionForm {
	KntcChuyenCqDieuTra chuyenCqDieuTra=new KntcChuyenCqDieuTra();
   
	public KntcChuyenCqDieuTra getChuyenCqDieuTra() {
		return chuyenCqDieuTra;
	}

	public void setChuyenCqDieuTra(KntcChuyenCqDieuTra chuyenCqDieuTra) {
		this.chuyenCqDieuTra = chuyenCqDieuTra;
	}
	
}
