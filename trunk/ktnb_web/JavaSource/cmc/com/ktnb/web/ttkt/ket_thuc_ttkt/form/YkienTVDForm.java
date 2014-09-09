package cmc.com.ktnb.web.ttkt.ket_thuc_ttkt.form;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.web.BaseActionForm;

public class YkienTVDForm extends BaseActionForm {
	private TtktCbChiTietDsTvDoan[] dsChiTietTVD ;
	private String idCuocTtKt;
	public TtktCbChiTietDsTvDoan[] getDsChiTietTVD() {
		return dsChiTietTVD;
	}

	public void setDsChiTietTVD(TtktCbChiTietDsTvDoan[] dsChiTietTVD) {
		this.dsChiTietTVD = dsChiTietTVD;
	}

	public String getIdCuocTtKt() {
		return idCuocTtKt;
	}

	public void setIdCuocTtKt(String idCuocTtKt) {
		this.idCuocTtKt = idCuocTtKt;
	}


}
