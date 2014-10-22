package cmc.com.ktnb.web.kntc.xac_minh.tien_hanh;

import cmc.com.ktnb.pl.hb.entity.KntcBbDoiThoai;
import cmc.com.ktnb.web.BaseActionForm;

public class BienBanDoiThoaiForm extends BaseActionForm{
	KntcBbDoiThoai bbDoiThoai=new KntcBbDoiThoai();

	// Property accessor 
	public KntcBbDoiThoai getBbDoiThoai() {
		return bbDoiThoai;
	}

	public void setBbDoiThoai(KntcBbDoiThoai bbDoiThoai) {
		this.bbDoiThoai = bbDoiThoai;
	}
	
	
}
