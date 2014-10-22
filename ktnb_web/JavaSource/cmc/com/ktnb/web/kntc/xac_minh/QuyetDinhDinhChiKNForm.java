package cmc.com.ktnb.web.kntc.xac_minh;

import cmc.com.ktnb.pl.hb.entity.KntcQdDinhChiKN;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseActionForm;

public class QuyetDinhDinhChiKNForm extends BaseActionForm{
	KntcQdDinhChiKN qdDinhChiKN=new KntcQdDinhChiKN();

	public KntcQdDinhChiKN getQdDinhChiKN() {
		return qdDinhChiKN;
	}

	public void setQdDinhChiKN(KntcQdDinhChiKN qdDinhChiKN) {
		this.qdDinhChiKN = qdDinhChiKN;
	}
	
}
