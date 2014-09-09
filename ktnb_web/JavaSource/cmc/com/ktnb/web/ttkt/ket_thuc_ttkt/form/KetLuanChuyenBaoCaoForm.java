package cmc.com.ktnb.web.ttkt.ket_thuc_ttkt.form;

import cmc.com.ktnb.web.BaseActionForm;

public class KetLuanChuyenBaoCaoForm extends BaseActionForm{
	private static final long serialVersionUID = 1L;
	private String dcID;
	private String dcIDCuocThanhTraKiemTra;
	private String dcSoDonViTTKT;
	private String dcSoDonViSaiPham;
	private String dcTSTienThuCongChucThue;
	private String dcTSTienTraCongChucThue;
	private String dcTSTienThuNguoiNopThue;
	private String dcTSTienTraNguoiNopThue;
	private String dcSoTienThuCongChucThue;
	private String dcSoTienNopCongChucTHue;
	private String dcSoTienThuNguoiNopThue;
	private String dcSoTienNopNguoiNopThue;
	private String dcXuLiHanhChinhCongVienChucThue;
	private String dcXuLiHanhChinhDoiTuongKhac;
	private String dcXLHSSoVuViec;
	private String dcXLHSDoiTuongKhac;
	private String dcXLHSSoNguoi;
	private String dcSoSDBS_VPBQ;
	private String dcSoSDBC_QTQC;
	private String dcSoTTKTThue;
	private String dcKienNghiKhac;
	private String dcMoTa,soKetLuan;
	private String dcIdNguoiCapNhat;
	private String dcTenNguoiCapNhat;
	private String dcNgayCapNhat;
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getDcID() {
		return dcID;
	}
	public void setDcID(String dcID) {
		this.dcID = dcID;
	}
	public String getDcIDCuocThanhTraKiemTra() {
		return dcIDCuocThanhTraKiemTra;
	}
	public void setDcIDCuocThanhTraKiemTra(String dcIDCuocThanhTraKiemTra) {
		this.dcIDCuocThanhTraKiemTra = dcIDCuocThanhTraKiemTra;
	}
	public String getDcIdNguoiCapNhat() {
		return dcIdNguoiCapNhat;
	}
	public void setDcIdNguoiCapNhat(String dcIdNguoiCapNhat) {
		this.dcIdNguoiCapNhat = dcIdNguoiCapNhat;
	}
	public String getDcKienNghiKhac() {
		return dcKienNghiKhac;
	}
	public void setDcKienNghiKhac(String dcKienNghiKhac) {
		this.dcKienNghiKhac = dcKienNghiKhac;
	}
	public String getDcMoTa() {
		return dcMoTa;
	}
	public void setDcMoTa(String dcMoTa) {
		this.dcMoTa = dcMoTa;
	}
	public String getDcNgayCapNhat() {
		return dcNgayCapNhat;
	}
	public void setDcNgayCapNhat(String dcNgayCapNhat) {
		this.dcNgayCapNhat = dcNgayCapNhat;
	}
	public String getDcSoDonViSaiPham() {
		return dcSoDonViSaiPham;
	}
	public void setDcSoDonViSaiPham(String dcSoDonViSaiPham) {
		this.dcSoDonViSaiPham = dcSoDonViSaiPham;
	}
	public String getDcSoDonViTTKT() {
		return dcSoDonViTTKT;
	}
	public void setDcSoDonViTTKT(String dcSoDonViTTKT) {
		this.dcSoDonViTTKT = dcSoDonViTTKT;
	}
	public String getDcSoSDBC_QTQC() {
		return dcSoSDBC_QTQC;
	}
	public void setDcSoSDBC_QTQC(String dcSoSDBC_QTQC) {
		this.dcSoSDBC_QTQC = dcSoSDBC_QTQC;
	}
	public String getDcSoSDBS_VPBQ() {
		return dcSoSDBS_VPBQ;
	}
	public void setDcSoSDBS_VPBQ(String dcSoSDBS_VPBQ) {
		this.dcSoSDBS_VPBQ = dcSoSDBS_VPBQ;
	}
	public String getDcSoTienNopCongChucTHue() {
		return dcSoTienNopCongChucTHue;
	}
	public void setDcSoTienNopCongChucTHue(String dcSoTienNopCongChucTHue) {
		this.dcSoTienNopCongChucTHue = dcSoTienNopCongChucTHue;
	}
	public String getDcSoTienNopNguoiNopThue() {
		return dcSoTienNopNguoiNopThue;
	}
	public void setDcSoTienNopNguoiNopThue(String dcSoTienNopNguoiNopThue) {
		this.dcSoTienNopNguoiNopThue = dcSoTienNopNguoiNopThue;
	}
	public String getDcSoTienThuCongChucThue() {
		return dcSoTienThuCongChucThue;
	}
	public void setDcSoTienThuCongChucThue(String dcSoTienThuCongChucThue) {
		this.dcSoTienThuCongChucThue = dcSoTienThuCongChucThue;
	}
	public String getDcSoTienThuNguoiNopThue() {
		return dcSoTienThuNguoiNopThue;
	}
	public void setDcSoTienThuNguoiNopThue(String dcSoTienThuNguoiNopThue) {
		this.dcSoTienThuNguoiNopThue = dcSoTienThuNguoiNopThue;
	}
	public String getDcSoTTKTThue() {
		return dcSoTTKTThue;
	}
	public void setDcSoTTKTThue(String dcSoTTKTThue) {
		this.dcSoTTKTThue = dcSoTTKTThue;
	}
	public String getDcTenNguoiCapNhat() {
		return dcTenNguoiCapNhat;
	}
	public void setDcTenNguoiCapNhat(String dcTenNguoiCapNhat) {
		this.dcTenNguoiCapNhat = dcTenNguoiCapNhat;
	}
	public String getDcTSTienThuCongChucThue() {
		return dcTSTienThuCongChucThue;
	}
	public void setDcTSTienThuCongChucThue(String dcTSTienThuCongChucThue) {
		this.dcTSTienThuCongChucThue = dcTSTienThuCongChucThue;
	}
	public String getDcTSTienThuNguoiNopThue() {
		return dcTSTienThuNguoiNopThue;
	}
	public void setDcTSTienThuNguoiNopThue(String dcTSTienThuNguoiNopThue) {
		this.dcTSTienThuNguoiNopThue = dcTSTienThuNguoiNopThue;
	}
	public String getDcTSTienTraCongChucThue() {
		return dcTSTienTraCongChucThue;
	}
	public void setDcTSTienTraCongChucThue(String dcTSTienTraCongChucThue) {
		this.dcTSTienTraCongChucThue = dcTSTienTraCongChucThue;
	}
	public String getDcTSTienTraNguoiNopThue() {
		return dcTSTienTraNguoiNopThue;
	}
	public void setDcTSTienTraNguoiNopThue(String dcTSTienTraNguoiNopThue) {
		this.dcTSTienTraNguoiNopThue = dcTSTienTraNguoiNopThue;
	}
	public String getDcXLHSDoiTuongKhac() {
		return dcXLHSDoiTuongKhac;
	}
	public void setDcXLHSDoiTuongKhac(String dcXLHSDoiTuongKhac) {
		this.dcXLHSDoiTuongKhac = dcXLHSDoiTuongKhac;
	}
	public String getDcXLHSSoNguoi() {
		return dcXLHSSoNguoi;
	}
	public void setDcXLHSSoNguoi(String dcXLHSSoNguoi) {
		this.dcXLHSSoNguoi = dcXLHSSoNguoi;
	}
	public String getDcXLHSSoVuViec() {
		return dcXLHSSoVuViec;
	}
	public void setDcXLHSSoVuViec(String dcXLHSSoVuViec) {
		this.dcXLHSSoVuViec = dcXLHSSoVuViec;
	}
	public String getDcXuLiHanhChinhCongVienChucThue() {
		return dcXuLiHanhChinhCongVienChucThue;
	}
	public void setDcXuLiHanhChinhCongVienChucThue(String dcXuLiHanhChinhCongVienChucThue) {
		this.dcXuLiHanhChinhCongVienChucThue = dcXuLiHanhChinhCongVienChucThue;
	}
	public String getDcXuLiHanhChinhDoiTuongKhac() {
		return dcXuLiHanhChinhDoiTuongKhac;
	}
	public void setDcXuLiHanhChinhDoiTuongKhac(String dcXuLiHanhChinhDoiTuongKhac) {
		this.dcXuLiHanhChinhDoiTuongKhac = dcXuLiHanhChinhDoiTuongKhac;
	}
	public String getSoKetLuan() {
		return soKetLuan;
	}
	public void setSoKetLuan(String soKetLuan) {
		this.soKetLuan = soKetLuan;
	}
}
