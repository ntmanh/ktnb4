package cmc.com.ktnb.web.kntc.xac_minh;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.pl.hb.entity.KntcXmBaoCaoKq;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseActionForm;

/**
 * Bao cao form
 * @author Ntthu Created on Nov 2, 2010
 */
public class BaoCaoKqXmForm extends BaseActionForm {

	// Thong tin Ho so
	private String maHoSo;
	private String diaDiemBc;
	private String thoiDiemBc;
	private String maHiddenBb,soQd,cbKetThuc;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);		
	}

	public KntcXmBaoCaoKq toBaoCaoKqXm(ApplicationContext appContext) throws Exception {
		KntcXmBaoCaoKq bc = new KntcXmBaoCaoKq();
		bc.setMaHs(this.maHoSo);
		bc.setDiaDiem(this.diaDiemBc);
		bc.setNgayLap(Formater.str2date(this.thoiDiemBc));
		if(Formater.isNull(this.cbKetThuc))
			this.cbKetThuc="0";
		bc.setKetThucXm(new Long(this.cbKetThuc));
		bc.setMa(this.maHiddenBb);
		bc.setMaQd(this.soQd);
		return bc;
	}
	
	public String getDiaDiemBc() {
		return diaDiemBc;
	}
	public void setDiaDiemBc(String diaDiem) {
		this.diaDiemBc = diaDiem;
	}
	public String getMaHoSo() {
		return maHoSo;
	}
	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}
	public String getThoiDiemBc() {
		return thoiDiemBc;
	}
	public void setThoiDiemBc(String thoiDiem) {
		this.thoiDiemBc = thoiDiem;
	}

	public String getMaHiddenBb() {
		return maHiddenBb;
	}

	public void setMaHiddenBb(String maHiddenBb) {
		this.maHiddenBb = maHiddenBb;
	}

	public String getSoQd() {
		return soQd;
	}

	public void setSoQd(String soQd) {
		this.soQd = soQd;
	}

	public String getCbKetThuc() {
		return cbKetThuc;
	}

	public void setCbKetThuc(String cbKetThuc) {
		this.cbKetThuc = cbKetThuc;
	}
}
