package cmc.com.ktnb.web.kntc.ket_qua;

import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.KntcBCKQThucHienQDKN;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.BaseActionForm;

public class BaoCaoKetQuaThucHienForm extends BaseActionForm {
	// Fields
	private String ma;

	private String maHs;

	private String maCqt;

	private String soTienKnghiThuHoi;

	private String taiSanKhacKnghiThuHoi;

	private String soTienTraCdan;

	private String taiSanKhacTraCdan;

	private String soNknHoanTra;

	private String soTienHoanTraNkn;

	private String soNguoiXlhc;

	private String chuyenCquanDtra;

	private String ketThucTdoiThiHanh;

	private String ngayNhanBckq;

	private String ngayCapNhat;

	private String nguoiCapNhat;

	private String soMinhOan;

	private String soNguoiChuyenCqDtra;

	private String loaiKntc;

	public BaoCaoKetQuaThucHienForm() {
		// TODO Auto-generated constructor stub
	}

	public String getChuyenCquanDtra() {
		return chuyenCquanDtra;
	}

	public void setChuyenCquanDtra(String chuyenCquanDtra) {
		this.chuyenCquanDtra = chuyenCquanDtra;
	}

	public String getKetThucTdoiThiHanh() {
		return ketThucTdoiThiHanh;
	}

	public void setKetThucTdoiThiHanh(String ketThucTdoiThiHanh) {
		this.ketThucTdoiThiHanh = ketThucTdoiThiHanh;
	}

	public String getLoaiKntc() {
		return loaiKntc;
	}

	public void setLoaiKntc(String loaiKntc) {
		this.loaiKntc = loaiKntc;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getMaCqt() {
		return maCqt;
	}

	public void setMaCqt(String maCqt) {
		this.maCqt = maCqt;
	}

	public String getMaHs() {
		return maHs;
	}

	public void setMaHs(String maHs) {
		this.maHs = maHs;
	}

	public String getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(String ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public String getNgayNhanBckq() {
		return ngayNhanBckq;
	}

	public void setNgayNhanBckq(String ngayNhanBckq) {
		this.ngayNhanBckq = ngayNhanBckq;
	}

	public String getNguoiCapNhat() {
		return nguoiCapNhat;
	}

	public void setNguoiCapNhat(String nguoiCapNhat) {
		this.nguoiCapNhat = nguoiCapNhat;
	}

	public String getSoMinhOan() {
		return soMinhOan;
	}

	public void setSoMinhOan(String soMinhOan) {
		this.soMinhOan = soMinhOan;
	}

	public String getSoNguoiChuyenCqDtra() {
		return soNguoiChuyenCqDtra;
	}

	public void setSoNguoiChuyenCqDtra(String soNguoiChuyenCqDtra) {
		this.soNguoiChuyenCqDtra = soNguoiChuyenCqDtra;
	}

	public String getSoNguoiXlhc() {
		return soNguoiXlhc;
	}

	public void setSoNguoiXlhc(String soNguoiXlhc) {
		this.soNguoiXlhc = soNguoiXlhc;
	}

	public String getSoNknHoanTra() {
		return soNknHoanTra;
	}

	public void setSoNknHoanTra(String soNknHoanTra) {
		this.soNknHoanTra = soNknHoanTra;
	}

	public String getSoTienHoanTraNkn() {
		return soTienHoanTraNkn;
	}

	public void setSoTienHoanTraNkn(String soTienHoanTraNkn) {
		this.soTienHoanTraNkn = soTienHoanTraNkn;
	}

	public String getSoTienKnghiThuHoi() {
		return soTienKnghiThuHoi;
	}

	public void setSoTienKnghiThuHoi(String soTienKnghiThuHoi) {
		this.soTienKnghiThuHoi = soTienKnghiThuHoi;
	}

	public String getSoTienTraCdan() {
		return soTienTraCdan;
	}

	public void setSoTienTraCdan(String soTienTraCdan) {
		this.soTienTraCdan = soTienTraCdan;
	}

	public String getTaiSanKhacKnghiThuHoi() {
		return taiSanKhacKnghiThuHoi;
	}

	public void setTaiSanKhacKnghiThuHoi(String taiSanKhacKnghiThuHoi) {
		this.taiSanKhacKnghiThuHoi = taiSanKhacKnghiThuHoi;
	}

	public String getTaiSanKhacTraCdan() {
		return taiSanKhacTraCdan;
	}

	public void setTaiSanKhacTraCdan(String taiSanKhacTraCdan) {
		this.taiSanKhacTraCdan = taiSanKhacTraCdan;
	}

	public void fromEntity(KntcBCKQThucHienQDKN entity) {
		this.ma = entity.getMa();
		this.maHs = entity.getMaHs();
		this.maCqt = entity.getMaCqt();
		this.soTienKnghiThuHoi = entity.getSoTienKnghiThuHoi().toString();
		this.taiSanKhacKnghiThuHoi = entity.getTaiSanKhacKnghiThuHoi().toString();
		this.soTienTraCdan = entity.getSoTienTraCdan().toString();
		this.taiSanKhacTraCdan = entity.getTaiSanKhacTraCdan().toString();
		this.soNknHoanTra = entity.getSoNknHoanTra().toString();
		this.soTienHoanTraNkn = entity.getSoTienHoanTraNkn().toString();
		this.soNguoiXlhc = entity.getSoNguoiXlhc().toString();
		this.chuyenCquanDtra = entity.getChuyenCquanDtra().toString();
		if (entity.getKetThucTdoiThiHanh() != null)
			this.ketThucTdoiThiHanh = entity.getKetThucTdoiThiHanh().toString();
		this.ngayNhanBckq = Formater.date2str(entity.getNgayNhanBckq());
		this.ngayCapNhat = Formater.date2str(entity.getNgayCapNhat());
		this.nguoiCapNhat = entity.getNguoiCapNhat();
		this.soMinhOan = entity.getSoMinhOan().toString();
		this.soNguoiChuyenCqDtra = entity.getSoNguoiChuyenCqDtra().toString();
		this.loaiKntc = entity.getLoaiKntc().toString();
	}

	public KntcBCKQThucHienQDKN toEntity(ApplicationContext context) throws Exception {
		KntcBCKQThucHienQDKN entity = new KntcBCKQThucHienQDKN();
		entity.setMa(this.ma);
		entity.setMaHs(this.maHs);
		entity.setMaCqt(context.getMaCqt());
		entity.setSoTienKnghiThuHoi(Formater.toLong(this.soTienKnghiThuHoi));
		entity.setTaiSanKhacKnghiThuHoi(Formater.toLong(this.taiSanKhacKnghiThuHoi));
		entity.setSoTienTraCdan(Formater.toLong(this.soTienTraCdan));
		entity.setTaiSanKhacTraCdan(Formater.toLong(this.taiSanKhacTraCdan));
		entity.setSoNknHoanTra(Formater.toLong(this.soNknHoanTra));
		entity.setSoTienHoanTraNkn(Formater.toLong(this.soTienHoanTraNkn));
		entity.setSoNguoiXlhc(Formater.toLong(this.soNguoiXlhc));
		entity.setChuyenCquanDtra(Formater.toLong(this.chuyenCquanDtra));
		entity.setKetThucTdoiThiHanh(Formater.toLong(this.ketThucTdoiThiHanh));
		entity.setNgayNhanBckq(Formater.str2date(this.ngayNhanBckq));
		entity.setNgayCapNhat(Formater.str2date(this.ngayCapNhat));
		entity.setNguoiCapNhat(context.getTenNsd());
		entity.setSoMinhOan(Formater.toLong(this.soMinhOan));
		entity.setSoNguoiChuyenCqDtra(Formater.toLong(this.soNguoiChuyenCqDtra));
		entity.setLoaiKntc(Formater.toLong(this.loaiKntc));
		return entity;
	}
}
