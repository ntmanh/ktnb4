package cmc.com.ktnb.web.kntc.xac_minh.tien_hanh;
import cmc.com.ktnb.pl.hb.entity.KntcXmGiaHan;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseActionForm;
/**
 * Gia hạn form
 * @author Ntthu
 * Created on 03/03/2011
 */
public class GiaHanXmForm extends BaseActionForm {

	// Thong tin Ho so
	private String maPhieu;
	private String maHoSo;
	//private String maQdxm;
	private String diaDiem;
	private String ngayLap;

	private String canCuVb;
	private String canCuQd;
	private String ngayKThucXM;
	private String giaHanTuNgay;
	private String giaHanDenNgay;
	private String soPhieu;
	//private String maHs;
	private String nguoiLap;
	private String maCqt;
	private String ma;
	private String soNgayGH;
	private String trangThaiHoSo;
	
	//Check thông tin xem có nên cho sửa hay không
	private String choSua;
	
	public KntcXmGiaHan toEntity(ApplicationContext context) throws Exception {
		KntcXmGiaHan gh = new KntcXmGiaHan();
		gh.setMa(this.ma);
		gh.setMaHs(this.maHoSo);
		gh.setDiaDiem(this.diaDiem);
		gh.setCanCuQd(this.canCuQd);
		gh.setCanCuVb(this.canCuVb);
		gh.setSoNgayGH(this.soNgayGH);
		gh.setGiaHanTuNgay(Formater.str2date(this.giaHanTuNgay));
		gh.setGiaHanDenNgay(Formater.str2date(this.giaHanDenNgay));
		gh.setNgayLap(Formater.str2date(this.ngayLap));
		if(this.ngayKThucXM!=null) gh.setNgayRaQd(Formater.str2date(this.ngayKThucXM));
		gh.setSoPhieu(this.soPhieu);
		gh.setNguoiLap(context.getTenNsd());
		gh.setMaCqt(context.getMaCqt());
		return gh;
	}
	
	
	public void toForm(KntcXmGiaHan e){
		this.setMa(e.getMa());
		this.setMaHoSo(e.getMaHs());
		this.setDiaDiem(e.getDiaDiem());
		this.setCanCuQd(e.getCanCuQd());
		this.setCanCuVb(e.getCanCuVb());
		this.setSoNgayGH(e.getSoNgayGH());
		this.setGiaHanTuNgay(Formater.date2str(e.getGiaHanTuNgay()));
		this.setGiaHanDenNgay(Formater.date2str(e.getGiaHanDenNgay()));
		this.setNgayLap(Formater.date2str(e.getNgayLap()));
		this.setNgayKThucXM(Formater.date2str(e.getNgayRaQd()));
		this.setSoPhieu(e.getSoPhieu());
		this.setNguoiLap(e.getNguoiLap());
		this.setMaCqt(e.getMaCqt());
	}
	
	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}
	
	public String getSoNgayGH() {
		return soNgayGH;
	}


	public void setSoNgayGH(String soNgayGH) {
		this.soNgayGH = soNgayGH;
	}
	/**
	 * @return
	 */
	public String getCanCuQd() {
		return canCuQd;
	}

	/**
	 * @return
	 */
	public String getCanCuVb() {
		return canCuVb;
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
	public String getGiaHanDenNgay() {
		return giaHanDenNgay;
	}

	/**
	 * @return
	 */
	public String getGiaHanTuNgay() {
		return giaHanTuNgay;
	}

	/**
	 * @return
	 */
	public String getMaCqt() {
		return maCqt;
	}

	/**
	 * @return
	 */
	public String getMaHoSo() {
		return maHoSo;
	}

	/**
	 * @return
	 
	public String getMaHs() {
		return maHs;
	}*/

	/**
	 * @return
	 */
	public String getMaPhieu() {
		return maPhieu;
	}

	/**
	 * @return
	 
	public String getMaQdxm() {
		return maQdxm;
	}*/

	/**
	 * @return
	 */
	public String getNgayLap() {
		return ngayLap;
	}

	/**
	 * @return
	 */
	public String getNgayKThucXM() {
		return ngayKThucXM;
	}

	/**
	 * @return
	 */
	public String getNguoiLap() {
		return nguoiLap;
	}

	/**
	 * @return
	 */
	public String getSoPhieu() {
		return soPhieu;
	}

	/**
	 * @param string
	 */
	public void setCanCuQd(String string) {
		canCuQd = string;
	}

	/**
	 * @param string
	 */
	public void setCanCuVb(String string) {
		canCuVb = string;
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
	public void setGiaHanDenNgay(String string) {
		giaHanDenNgay = string;
	}

	/**
	 * @param string
	 */
	public void setGiaHanTuNgay(String string) {
		giaHanTuNgay = string;
	}

	/**
	 * @param string
	 */
	public void setMaCqt(String string) {
		maCqt = string;
	}

	/**
	 * @param string
	 */
	public void setMaHoSo(String string) {
		maHoSo = string;
	}

	/**
	 * @param string
	 
	public void setMaHs(String string) {
		maHs = string;
	}*/

	/**
	 * @param string
	 */
	public void setMaPhieu(String string) {
		maPhieu = string;
	}

	/**
	 * @param string
	 
	public void setMaQdxm(String string) {
		maQdxm = string;
	}*/

	/**
	 * @param string
	 */
	public void setNgayLap(String string) {
		ngayLap = string;
	}

	/**
	 * @param string
	 */
	public void setNgayKThucXM(String string) {
		ngayKThucXM = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiLap(String string) {
		nguoiLap = string;
	}

	/**
	 * @param string
	 */
	public void setSoPhieu(String string) {
		soPhieu = string;
	}


	public String getTrangThaiHoSo() {
		return trangThaiHoSo;
	}


	public void setTrangThaiHoSo(String trangThaiHoSo) {
		this.trangThaiHoSo = trangThaiHoSo;
	}


	public String getChoSua() {
		return choSua;
	}


	public void setChoSua(String choSua) {
		this.choSua = choSua;
	}
}
