package cmc.com.ktnb.web.kntc.tiep_dan;
import cmc.com.ktnb.pl.hb.entity.KntcPhieuGiaoHs;
import cmc.com.ktnb.pl.hb.entity.KtnbDmCanbo;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.web.BaseActionForm;
/**
 * Form phiếu dùng chung
 * @author Ntthu 
 * Created on Nov 2, 2010
 */
public class PhieuForm extends BaseActionForm {

	// Thong tin Ho so
	private String maHoSo;
	private String ma;
	private String ngay;
	private String dvGiaoMa;
	private String dvGiaoTen;
	private String dvNhanMa;
	private String dvNhanTen;
	private String diaDiem;
	private String nguoiNhanMa;
	private String nguoiNhanTen;
	private String nguoiNhanCV;
	private String nguoiNhanDV;
	private String nguoiGiaoMa;
	private String nguoiGiaoTen;
	private String nguoiGiaoCV;
	private String nguoiGiaoDV;
	private String noiDungBG;
	
	public void fromEntity(ApplicationContext c, KntcPhieuGiaoHs p) throws Exception{
		this.setMaHoSo(p.getMaHs());
		this.setMa(p.getMaPhieu());
		this.diaDiem = p.getDiaDiem();
		this.nguoiGiaoMa = p.getNguoiGiaoMa();
		KtnbDmCanbo aCb = KtnbUtil.getThongTinCanBo(p.getNguoiGiaoMa());
		this.nguoiGiaoCV = aCb.getTenChucVu();
		this.nguoiGiaoDV = aCb.getTenPhong();
		this.nguoiGiaoTen = aCb.getTen();
		this.nguoiNhanMa = p.getNguoiNhanMa();
		aCb = KtnbUtil.getThongTinCanBo(p.getNguoiNhanMa());
		this.nguoiNhanCV = aCb.getTenChucVu();
		this.nguoiNhanDV = aCb.getTenPhong();
		this.nguoiNhanTen = aCb.getTen();
		this.noiDungBG = p.getNoiDung();
	}
	
	/**
	 * @return
	 */
	public String getMa() {
		return ma;
	}

	/**
	 * @return
	 */
	public String getNgay() {
		return ngay;
	}

	/**
	 * @param string
	 */
	public void setMa(String string) {
		ma = string;
	}

	/**
	 * @param string
	 */
	public void setNgay(String string) {
		ngay = string;
	}
	/**
	 * @return
	 */
	public String getMaHoSo() {
		return maHoSo;
	}

	/**
	 * @param string
	 */
	public void setMaHoSo(String string) {
		maHoSo = string;
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
	public String getDvGiaoMa() {
		return dvGiaoMa;
	}

	/**
	 * @return
	 */
	public String getDvGiaoTen() {
		return dvGiaoTen;
	}

	/**
	 * @return
	 */
	public String getDvNhanMa() {
		return dvNhanMa;
	}

	/**
	 * @return
	 */
	public String getDvNhanTen() {
		return dvNhanTen;
	}

	/**
	 * @return
	 */
	public String getNguoiGiaoCV() {
		return nguoiGiaoCV;
	}

	/**
	 * @return
	 */
	public String getNguoiGiaoDV() {
		return nguoiGiaoDV;
	}

	/**
	 * @return
	 */
	public String getNguoiGiaoMa() {
		return nguoiGiaoMa;
	}

	/**
	 * @return
	 */
	public String getNguoiGiaoTen() {
		return nguoiGiaoTen;
	}

	/**
	 * @return
	 */
	public String getNguoiNhanCV() {
		return nguoiNhanCV;
	}

	/**
	 * @return
	 */
	public String getNguoiNhanDV() {
		return nguoiNhanDV;
	}

	/**
	 * @return
	 */
	public String getNguoiNhanMa() {
		return nguoiNhanMa;
	}

	/**
	 * @return
	 */
	public String getNguoiNhanTen() {
		return nguoiNhanTen;
	}

	/**
	 * @return
	 */
	public String getNoiDungBG() {
		return noiDungBG;
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
	public void setDvGiaoMa(String string) {
		dvGiaoMa = string;
	}

	/**
	 * @param string
	 */
	public void setDvGiaoTen(String string) {
		dvGiaoTen = string;
	}

	/**
	 * @param string
	 */
	public void setDvNhanMa(String string) {
		dvNhanMa = string;
	}

	/**
	 * @param string
	 */
	public void setDvNhanTen(String string) {
		dvNhanTen = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiGiaoCV(String string) {
		nguoiGiaoCV = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiGiaoDV(String string) {
		nguoiGiaoDV = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiGiaoMa(String string) {
		nguoiGiaoMa = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiGiaoTen(String string) {
		nguoiGiaoTen = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiNhanCV(String string) {
		nguoiNhanCV = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiNhanDV(String string) {
		nguoiNhanDV = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiNhanMa(String string) {
		nguoiNhanMa = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiNhanTen(String string) {
		nguoiNhanTen = string;
	}

	/**
	 * @param string
	 */
	public void setNoiDungBG(String string) {
		noiDungBG = string;
	}

}
