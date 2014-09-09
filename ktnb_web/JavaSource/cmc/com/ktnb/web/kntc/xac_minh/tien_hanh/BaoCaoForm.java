package cmc.com.ktnb.web.kntc.xac_minh.tien_hanh;
import cmc.com.ktnb.pl.hb.entity.KntcBaoCao;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseActionForm;
/**
 * Báo cáo form
 * @author Ntthu
 * Created on 03/03/2011
 */
public class BaoCaoForm extends BaseActionForm {

	// Thong tin Ho so
	private String maPhieu;
	private String maHoSo;
	private String kntcQdinhXm;
	private String diaDiem;
	private String ngayLap;
	
	private String doanXm;
	private String ngayPhieuYcgt;
	private String nguoiLapBc;
	private String nguoiLapBcChucVu;	
	private String nguoiLapBcDvCt;
	private String noiDungGt,lanTd;
	
	public KntcBaoCao toEntity() throws Exception {
		KntcBaoCao pYc = new KntcBaoCao();
		pYc.setMaHs(this.maHoSo);
		pYc.setDiaDiem(this.diaDiem);
		pYc.setThoiDiem(Formater.str2date(this.ngayLap));
		pYc.setNguoiLap(this.nguoiLapBc);
		pYc.setNguoiLapCvu(this.nguoiLapBcChucVu);
		pYc.setNguoiLapDvi(this.nguoiLapBcDvCt);
		pYc.setNgayYc(Formater.str2date(this.ngayPhieuYcgt));
		pYc.setNoiDung(this.noiDungGt);
		pYc.setTenDoan(this.doanXm);
		if(!Formater.isNull(this.lanTd))
			pYc.setLanTd(new Long(this.lanTd));
		else
			pYc.setLanTd(new Long("0"));	
		return pYc;
	}
	/**
	 * @return
	 */
	public String getDiaDiem() {
		return diaDiem;
	}

	/**
	 * @return
	 */
	public String getDoanXm() {
		return doanXm;
	}

	/**
	 * @return
	 */
	public String getKntcQdinhXm() {
		return kntcQdinhXm;
	}

	/**
	 * @return
	 */
	public String getMaHoSo() {
		return maHoSo;
	}

	/**
	 * @return
	 */
	public String getMaPhieu() {
		return maPhieu;
	}

	/**
	 * @return
	 */
	public String getNgayLap() {
		return ngayLap;
	}

	/**
	 * @return
	 */
	public String getNgayPhieuYcgt() {
		return ngayPhieuYcgt;
	}

	/**
	 * @return
	 */
	public String getNguoiLapBc() {
		return nguoiLapBc;
	}

	/**
	 * @return
	 */
	public String getNguoiLapBcChucVu() {
		return nguoiLapBcChucVu;
	}

	/**
	 * @return
	 */
	public String getNguoiLapBcDvCt() {
		return nguoiLapBcDvCt;
	}

	/**
	 * @return
	 */
	public String getNoiDungGt() {
		return noiDungGt;
	}

	/**
	 * @param string
	 */
	public void setDiaDiem(String string) {
		diaDiem = string;
	}

	/**
	 * @param string
	 */
	public void setDoanXm(String string) {
		doanXm = string;
	}

	/**
	 * @param string
	 */
	public void setKntcQdinhXm(String string) {
		kntcQdinhXm = string;
	}

	/**
	 * @param string
	 */
	public void setMaHoSo(String string) {
		maHoSo = string;
	}

	/**
	 * @param string
	 */
	public void setMaPhieu(String string) {
		maPhieu = string;
	}

	/**
	 * @param string
	 */
	public void setNgayLap(String string) {
		ngayLap = string;
	}

	/**
	 * @param string
	 */
	public void setNgayPhieuYcgt(String string) {
		ngayPhieuYcgt = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiLapBc(String string) {
		nguoiLapBc = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiLapBcChucVu(String string) {
		nguoiLapBcChucVu = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiLapBcDvCt(String string) {
		nguoiLapBcDvCt = string;
	}

	/**
	 * @param string
	 */
	public void setNoiDungGt(String string) {
		noiDungGt = string;
	}
	public String getLanTd() {
		return lanTd;
	}
	public void setLanTd(String lanTd) {
		this.lanTd = lanTd;
	}

}
