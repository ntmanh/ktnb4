package cmc.com.ktnb.web.kntc.xac_minh;

import cmc.com.ktnb.pl.hb.entity.KntcQdHuyTamDinhChiKN;
import cmc.com.ktnb.pl.hb.entity.KntcQdTamDinhChiKn;
import cmc.com.ktnb.web.BaseActionForm;

public class QDTamDinhChiThiHanhKNForm extends BaseActionForm{
	KntcQdTamDinhChiKn tamDinhChiKn=new KntcQdTamDinhChiKn();
	KntcQdHuyTamDinhChiKN huyDinhChiKn=new KntcQdHuyTamDinhChiKN();

	public KntcQdTamDinhChiKn getTamDinhChiKn() {
		return tamDinhChiKn;
	}

	public void setTamDinhChiKn(KntcQdTamDinhChiKn tamDinhChiKn) {
		this.tamDinhChiKn = tamDinhChiKn;
	}

	public KntcQdHuyTamDinhChiKN getHuyDinhChiKn() {
		return huyDinhChiKn;
	}

	public void setHuyDinhChiKn(KntcQdHuyTamDinhChiKN huyDinhChiKn) {
		this.huyDinhChiKn = huyDinhChiKn;
	}
	
}
