package cmc.com.ktnb.web.kntc.xu_ly;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.pl.hb.entity.KntcDeXuatXly;
import cmc.com.ktnb.pl.hb.entity.KntcGiaoNvXmTc;
import cmc.com.ktnb.pl.hb.entity.KntcNoiDungTCTT;
import cmc.com.ktnb.pl.hb.entity.KntcTbKhongThuLyGqTiep;
import cmc.com.ktnb.pl.hb.entity.KntcTbKoThuLyGq;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.web.BaseActionForm;

public class XlyPhuToCaoForm extends BaseActionForm {
	KntcNoiDungTCTT tctt=new KntcNoiDungTCTT();  
	KntcTbKhongThuLyGqTiep tbKhongThuLyTiep=new KntcTbKhongThuLyGqTiep();
	KntcTbKoThuLyGq tbKoThuLyGq=new KntcTbKoThuLyGq();
	KntcGiaoNvXmTc giaoNvXmTc=new KntcGiaoNvXmTc();
	KntcDeXuatXly deXuatXly=new KntcDeXuatXly(); 
	PhieuHdNknForm phieuHdNkn=new PhieuHdNknForm();
	DeXuatXuLyKNForm xuLyKN =new DeXuatXuLyKNForm();
	public DeXuatXuLyKNForm getXuLyKN() {
		return xuLyKN;
	}

	public void setXuLyKN(DeXuatXuLyKNForm xuLyKN) {
		this.xuLyKN = xuLyKN;
	}

	// Property accessors
	public KntcNoiDungTCTT getTctt() {
		return tctt;
	}

	public void setTctt(KntcNoiDungTCTT tctt) {
		this.tctt = tctt;
	}

	public KntcTbKhongThuLyGqTiep getTbKhongThuLyTiep() {
		return tbKhongThuLyTiep;
	}

	public void setTbKhongThuLyTiep(KntcTbKhongThuLyGqTiep tbKhongThuLyTiep) {
		this.tbKhongThuLyTiep = tbKhongThuLyTiep;
	}

	public KntcTbKoThuLyGq getTbKoThuLyGq() {
		return tbKoThuLyGq;
	}

	public void setTbKoThuLyGq(KntcTbKoThuLyGq tbKoThuLyGq) {
		this.tbKoThuLyGq = tbKoThuLyGq;
	}

	public KntcGiaoNvXmTc getGiaoNvXmTc() {
		return giaoNvXmTc;
	}

	public void setGiaoNvXmTc(KntcGiaoNvXmTc giaoNvXmTc) {
		this.giaoNvXmTc = giaoNvXmTc;
	}

	public KntcDeXuatXly getDeXuatXly() {
		return deXuatXly;
	}

	public void setDeXuatXly(KntcDeXuatXly deXuatXly) {
		this.deXuatXly = deXuatXly;
	}

	public PhieuHdNknForm getPhieuHdNkn() {
		return phieuHdNkn;
	}

	public void setPhieuHdNkn(PhieuHdNknForm phieuHdNkn) {
		this.phieuHdNkn = phieuHdNkn;
	}

	
}
