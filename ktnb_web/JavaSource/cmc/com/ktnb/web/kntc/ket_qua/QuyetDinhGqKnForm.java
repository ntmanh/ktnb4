package cmc.com.ktnb.web.kntc.ket_qua;

import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.KntcQdinhGquyet;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.dung_chung.form.XacNhanForm;

/**
 * Quyết định giải quyết khiếu nại form
 * @author Ntthu Created on Nov 2, 2010
 */
public class QuyetDinhGqKnForm extends XacNhanForm {

	// Thong tin Ho so
	private String soQd;

	private String maHidden;

	private String canCuTheo, vanBanQd,benLienQuan;

	private String noidung;

	private String noiDungViPham;

	private String noiDungDon;

	private String ketQuaXm;

	private String ketLuan;

	private String dieu1;

	private String dieu2;

	private String dieu3ThoiHan,ketThuc;

	private String dieu3NguoiQgTen;

	private String dieu4,ghiChu;
	
	private String knDungSai;
	
	private Long lanGiaiQuyet;
	
	public QuyetDinhGqKnForm() {
		super();
	}

	public void fromEntity(KntcQdinhGquyet kq) {
		if(kq!=null)
		{
			this.noiDungDon = kq.getNoiDungKn();
			this.setSoQd(kq.getSoQd());
			this.setMaHoSo(kq.getMaHs());
			this.setDiaDiem(kq.getDiaDiem());
			this.maHidden = kq.getMa();
			this.ketQuaXm = kq.getKetQuaXm();
			this.ketLuan = kq.getKetLuan();
			this.setKienDuyet(kq.getYKienDuyet());
			this.setKienTrinh(kq.getYKienTrinh());
	
			this.setThoiDiem(Formater.date2str(kq.getNgayLap()));
			this.setNgayTrinhDuyet(Formater.date2str(kq.getNgayTrinhDuyet()));
			this.setNgayDuyet(Formater.date2str(kq.getNgayDuyet()));
			this.setNgayTrinhKy(Formater.date2str(kq.getNgayTrinhKy()));
			this.setNgayKy(Formater.date2str(kq.getNgayKy()));
	
			this.canCuTheo = kq.getCanCuQd();
			this.vanBanQd = kq.getVanBanQd();
			this.dieu1 = kq.getDieu1();
			this.dieu2 = kq.getDieu2();
			this.dieu4 = kq.getDieu4();
			this.ghiChu=kq.getGhiChu();
			this.dieu3NguoiQgTen = kq.getDieu3NguoiQgTen();
			if (kq.getDieu3ThoiHan() != null)
				this.dieu3ThoiHan = kq.getDieu3ThoiHan().toString();
			if (kq.getKetThuc() != null)
				this.ketThuc = kq.getKetThuc().toString();
			if (kq.getKnDungSai() != null)
				this.knDungSai = kq.getKnDungSai().toString();
			this.noiDungDon = kq.getNoiDungKn();
			this.noiDungViPham = kq.getTenVuViec();
		}		
	}

	public KntcQdinhGquyet toQdinhGquyet(ApplicationContext c) throws Exception {
		KntcQdinhGquyet qd = new KntcQdinhGquyet();
		qd.setMa(this.maHidden);
		qd.setMaHs(this.getMaHoSo());
		qd.setDiaDiem(this.getDiaDiem());
		qd.setNgayLap(Formater.str2date(this.getThoiDiem()));
		qd.setNgayCapNhat(new Date());
		qd.setNguoiCapNhat(c.getTenNsd());
		qd.setMaCqt(c.getMaCqt());
		qd.setGhiChu(this.getGhiChu());
		// Thong tin ky duyet
		qd.setNgayDuyet(Formater.str2date(this.getNgayDuyet()));
		qd.setNgayTrinhDuyet(Formater.str2date(this.getNgayTrinhDuyet()));
		qd.setNgayTrinhKy(Formater.str2date(this.getNgayTrinhKy()));
		qd.setNgayKy(Formater.str2date(this.getNgayKy()));
		qd.setYKienTrinh(this.getKienTrinh());
		qd.setYKienDuyet(this.getKienDuyet());

		qd.setNoiDungKn(this.getNoiDungDon());
		qd.setKetQuaXm(this.getKetQuaXm());
		qd.setSoQd(this.getSoQd());

		qd.setCanCuQd(this.getCanCuTheo());
		qd.setVanBanQd(this.getVanBanQd());
		qd.setDieu1(this.getDieu1());
		qd.setDieu2(this.getDieu2());
		qd.setDieu4(this.dieu4);
		qd.setDieu3NguoiQgTen(this.dieu3NguoiQgTen);
		if (!Formater.isNull(this.dieu3ThoiHan))
			qd.setDieu3ThoiHan(new Long(this.dieu3ThoiHan));
		if (!Formater.isNull(this.ketThuc))
			qd.setKetThuc(new Long(this.ketThuc));
		else qd.setKetThuc(new Long("0"));
		//if (!Formater.isNull(this.ketThuc))
			//qd.setKnDungSai(new Long(this.ketThuc));
		//else 
		if(this.getKnDungSai()!=null)
			qd.setKnDungSai(new Long(this.getKnDungSai()));
		qd.setKetLuan(this.ketLuan);
		qd.setNgayRaQd(Formater.str2date(this.getThoiDiem()));
		qd.setTenQdhc(this.noiDungViPham);
		qd.setTenVuViec(this.noiDungDon);
		qd.setBenLienQuan(this.benLienQuan);
		return qd;
	}

	/**
	 * @return
	 */
	public String getCanCuTheo() {
		return canCuTheo;
	}

	/**
	 * @return
	 */
	public String getDieu1() {
		return dieu1;
	}

	/**
	 * @return
	 */
	public String getDieu2() {
		return dieu2;
	}

	/**
	 * @return
	 */
	public String getDieu3NguoiQgTen() {
		return dieu3NguoiQgTen;
	}

	/**
	 * @return
	 */
	public String getDieu3ThoiHan() {
		return dieu3ThoiHan;
	}

	/**
	 * @return
	 */
	public String getDieu4() {
		return dieu4;
	}

	/**
	 * @return
	 */
	public String getKetLuan() {
		return ketLuan;
	}

	/**
	 * @return
	 */
	public String getKetQuaXm() {
		return ketQuaXm;
	}

	/**
	 * @return
	 */
	public String getMaHidden() {
		return maHidden;
	}

	/**
	 * @return
	 */
	public String getNoidung() {
		return noidung;
	}

	/**
	 * @return
	 */
	public String getNoiDungDon() {
		return noiDungDon;
	}

	/**
	 * @return
	 */
	public String getNoiDungViPham() {
		return noiDungViPham;
	}

	/**
	 * @return
	 */
	public String getSoQd() {
		return soQd;
	}

	/**
	 * @param string
	 */
	public void setCanCuTheo(String string) {
		canCuTheo = string;
	}

	/**
	 * @param string
	 */
	public void setDieu1(String string) {
		dieu1 = string;
	}

	/**
	 * @param string
	 */
	public void setDieu2(String string) {
		dieu2 = string;
	}

	/**
	 * @param string
	 */
	public void setDieu3NguoiQgTen(String string) {
		dieu3NguoiQgTen = string;
	}

	/**
	 * @param string
	 */
	public void setDieu3ThoiHan(String string) {
		dieu3ThoiHan = string;
	}

	/**
	 * @param string
	 */
	public void setDieu4(String string) {
		dieu4 = string;
	}

	/**
	 * @param string
	 */
	public void setKetLuan(String string) {
		ketLuan = string;
	}

	/**
	 * @param string
	 */
	public void setKetQuaXm(String string) {
		ketQuaXm = string;
	}

	/**
	 * @param string
	 */
	public void setMaHidden(String string) {
		maHidden = string;
	}

	/**
	 * @param string
	 */
	public void setNoidung(String string) {
		noidung = string;
	}

	/**
	 * @param string
	 */
	public void setNoiDungDon(String string) {
		noiDungDon = string;
	}

	/**
	 * @param string
	 */
	public void setNoiDungViPham(String string) {
		noiDungViPham = string;
	}

	/**
	 * @param string
	 */
	public void setSoQd(String string) {
		soQd = string;
	}

	public String getVanBanQd() {
		return vanBanQd;
	}

	public void setVanBanQd(String vanBanQd) {
		this.vanBanQd = vanBanQd;
	}

	public String getBenLienQuan() {
		return benLienQuan;
	}

	public void setBenLienQuan(String benLienQuan) {
		this.benLienQuan = benLienQuan;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getKetThuc() {
		return ketThuc;
	}

	public void setKetThuc(String ketThuc) {
		this.ketThuc = ketThuc;
	}
	public String getKnDungSai() {
		return knDungSai;
	}

	public void setKnDungSai(String knDungSai) {
		this.knDungSai = knDungSai;
	}

	public Long getLanGiaiQuyet() {
		return lanGiaiQuyet;
	}

	public void setLanGiaiQuyet(Long lanGiaiQuyet) {
		this.lanGiaiQuyet = lanGiaiQuyet;
	}

	
}
