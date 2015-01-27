package cmc.com.ktnb.web.kntc.xac_minh.tien_hanh;

import cmc.com.ktnb.pl.hb.entity.KntcQdxmPhieuYc;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseActionForm;

/**
 * Phiếu form
 * @author Ntthu Created on 03/03/2011
 */
public class PhieuYeuCauForm extends BaseActionForm {

	// Thong tin Ho so
	private String maPhieu;

	private String maHoSo;

	private String kntcQdinhXm;

	private String diaDiem;

	private String ngayLap;

	private String donViYcgt;

	private String yeuCauYcgt;

	private String thoiDiemYcgt;

	private String diaDiemYcgt;

	private String lanYc;

	private String ycBaoCao; // Noi dung xac minh

	private String ycHoSo; // Giam dinh: dung cho ma so phieu

	private String nguoiNhanBc;

	private String nguoiNhanBcChucVu;

	private String nguoiNhanPhieu;

	private String nguoiNhanPhieuChucVu;

	private String thoiGianNhanPhieu;

	private String donViYkien;
	
	private String layYkienVeViec;
	
	private String ma;

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public KntcQdxmPhieuYc toEntity() throws Exception {
		KntcQdxmPhieuYc pYc = new KntcQdxmPhieuYc();
		pYc.setMaHoSo(this.maHoSo);
		pYc.setDiaDiem(this.diaDiem);
		pYc.setDiaDiemYcgt(this.diaDiemYcgt);
		pYc.setDonViYcgt(this.donViYcgt);
		pYc.setDonViYkien(this.donViYkien);
		pYc.setKntcQdinhXm(this.kntcQdinhXm);
		if (!Formater.isNull(this.lanYc))
			pYc.setLanTd(new Long(this.lanYc));
		else
			pYc.setLanTd(new Long(0));
		try {
			pYc.setNgayLap(Formater.str2date(this.ngayLap));
		} catch (Exception e) {
			pYc.setNgayLap(Formater.str2dateForNV(this.ngayLap));
		}
		pYc.setNguoiNhanBc(this.nguoiNhanBc);
		pYc.setNguoiNhanBcChucVu(this.nguoiNhanBcChucVu);
		pYc.setNguoiNhanPhieu(this.nguoiNhanPhieu);
		pYc.setNguoiNhanPhieuChucVu(this.nguoiNhanPhieuChucVu);
		if (!Formater.isNull(this.thoiDiemYcgt))
			pYc.setThoiDiemYcgt(Formater.str2dateForNV(this.thoiDiemYcgt));
		if (!Formater.isNull(this.thoiGianNhanPhieu))
			pYc.setThoiGianNhanPhieu(Formater.str2dateForNV(this.thoiGianNhanPhieu));
		pYc.setYcBaoCao(this.ycBaoCao);
		pYc.setYcHoSo(this.ycHoSo);
		pYc.setYeuCauYcgt(this.yeuCauYcgt);
		pYc.setMaPhieu(this.maPhieu);
		pYc.setMa(this.ma);
		pYc.setLayYkienVeViec(this.layYkienVeViec);
		return pYc;
	}

	public void fromPyc(KntcQdxmPhieuYc p) {
		this.maHoSo = p.getMaHoSo();
		this.diaDiem = p.getDiaDiem();
		this.diaDiemYcgt = p.getDiaDiemYcgt();
		this.donViYcgt = p.getDonViYcgt();
		this.donViYkien = p.getDonViYkien();
		this.kntcQdinhXm = p.getKntcQdinhXm();
		if(p.getLanYc()!=null)
		this.lanYc = p.getLanYc().toString();
		this.ngayLap = Formater.date2strDateTimeForNV(p.getNgayLap());
		//this.nguoiNhanBc = p.getNguoiNhanBc();
		this.nguoiNhanBcChucVu = p.getNguoiNhanBcChucVu();
		this.nguoiNhanPhieu = p.getNguoiNhanPhieu();
		this.nguoiNhanPhieuChucVu = p.getNguoiNhanPhieuChucVu();
		this.thoiDiemYcgt = Formater.date2strDateTimeForNV(p.getThoiDiemYcgt());
		this.thoiGianNhanPhieu = Formater.date2strDateTimeForNV(p.getThoiGianNhanPhieu());
		this.ycBaoCao = p.getYcBaoCao();
		this.ycHoSo = p.getYcHoSo();
		this.yeuCauYcgt = p.getYeuCauYcgt();
		this.maPhieu = p.getMaPhieu();
		this.layYkienVeViec=p.getLayYkienVeViec();
		this.ma = p.getMa();
	}
	
	public KntcQdxmPhieuYc toEntity(String loaiPhieu) throws Exception {
		KntcQdxmPhieuYc pYc = new KntcQdxmPhieuYc();
		pYc.setLoaiPhieu(loaiPhieu);
		pYc.setMaHoSo(this.maHoSo);
		pYc.setDiaDiem(this.diaDiem);
		pYc.setDonViYkien(this.donViYkien);
		pYc.setKntcQdinhXm(this.kntcQdinhXm);
		if (!Formater.isNull(this.lanYc))
			pYc.setLanYc(new Long(this.lanYc));
		else
			pYc.setLanTd(new Long(0));
		pYc.setNgayLap(Formater.str2date(this.ngayLap));
		if (!Formater.isNull(this.thoiDiemYcgt))
			pYc.setThoiDiemYcgt(Formater.str2date(this.thoiDiemYcgt));
		pYc.setYeuCauYcgt(this.yeuCauYcgt);
		pYc.setMaPhieu(this.maPhieu);
		pYc.setMa(this.ma);
		pYc.setLayYkienVeViec(this.layYkienVeViec);
		return pYc;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	/**
	 * @return
	 */
	public String getDiaDiemYcgt() {
		return diaDiemYcgt;
	}

	/**
	 * @return
	 */
	public String getDonViYcgt() {
		return donViYcgt;
	}

	/**
	 * @return
	 */
	public String getDonViYkien() {
		return donViYkien;
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
	public String getLanYc() {
		return lanYc;
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
	public String getNguoiNhanBc() {
		return nguoiNhanBc;
	}

	/**
	 * @return
	 */
	public String getNguoiNhanBcChucVu() {
		return nguoiNhanBcChucVu;
	}

	/**
	 * @return
	 */
	public String getNguoiNhanPhieu() {
		return nguoiNhanPhieu;
	}

	/**
	 * @return
	 */
	public String getNguoiNhanPhieuChucVu() {
		return nguoiNhanPhieuChucVu;
	}

	/**
	 * @return
	 */
	public String getThoiDiemYcgt() {
		return thoiDiemYcgt;
	}

	/**
	 * @return
	 */
	public String getThoiGianNhanPhieu() {
		return thoiGianNhanPhieu;
	}

	/**
	 * @return
	 */
	public String getYcBaoCao() {
		return ycBaoCao;
	}

	/**
	 * @return
	 */
	public String getYcHoSo() {
		return ycHoSo;
	}

	/**
	 * @return
	 */
	public String getYeuCauYcgt() {
		return yeuCauYcgt;
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
	public void setDiaDiemYcgt(String string) {
		diaDiemYcgt = string;
	}

	/**
	 * @param string
	 */
	public void setDonViYcgt(String string) {
		donViYcgt = string;
	}

	/**
	 * @param string
	 */
	public void setDonViYkien(String string) {
		donViYkien = string;
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
	public void setLanYc(String string) {
		lanYc = string;
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
	public void setNguoiNhanBc(String string) {
		nguoiNhanBc = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiNhanBcChucVu(String string) {
		nguoiNhanBcChucVu = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiNhanPhieu(String string) {
		nguoiNhanPhieu = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiNhanPhieuChucVu(String string) {
		nguoiNhanPhieuChucVu = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemYcgt(String string) {
		thoiDiemYcgt = string;
	}

	/**
	 * @param string
	 */
	public void setThoiGianNhanPhieu(String string) {
		thoiGianNhanPhieu = string;
	}

	/**
	 * @param string
	 */
	public void setYcBaoCao(String string) {
		ycBaoCao = string;
	}

	/**
	 * @param string
	 */
	public void setYcHoSo(String string) {
		ycHoSo = string;
	}

	/**
	 * @param string
	 */
	public void setYeuCauYcgt(String string) {
		yeuCauYcgt = string;
	}

	public String getLayYkienVeViec() {
		return layYkienVeViec;
	}

	public void setLayYkienVeViec(String layYkienVeViec) {
		this.layYkienVeViec = layYkienVeViec;
	}

	
}
