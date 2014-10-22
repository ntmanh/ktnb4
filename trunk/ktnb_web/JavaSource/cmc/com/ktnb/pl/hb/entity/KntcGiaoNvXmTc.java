package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

import cmc.com.ktnb.util.Formater;

public class KntcGiaoNvXmTc extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
	// Fields
	public String id;
	public String soHoSo;
	public String soQuyetDinh;
	public Date ngayBanHanh;
	public String diaDiem;
	public String canCuVanBan;
	public String nguoiDeNghi;
	public String nguoiRaQdTen;
	public String nguoiRaQdCvu;
	public String noiDungDuocThuLy;
	public String nguoiGqTcTen;
	public String nguoiGqTcChucVu;
	public String donViDuocGiaoXm;
	public String yeuCauKhac;
	public Date ngayTrinhTruongBoPhanKy;
	public Date ngayTruongBoPhanKy;
	public String ykienCuaTruongBoPhan;
	public Date ngayTrinhThuTruongDuyet;
	public Date ngayThuTruongDuyet;
	public String ykienThuTruong;
	public String ngayBanHanhStr,ngayTrinhTruongBoPhanKyStr,ngayTruongBoPhanKyStr,ngayTrinhThuTruongDuyetStr,ngayThuTruongDuyetStr;
	
	// Defauld constructor
	public KntcGiaoNvXmTc(){
		
	}
	public KntcGiaoNvXmTc(String id)
	{
		this.id=id;
	}
	
	// Propery accessors
	public String getCanCuVanBan() {
		return canCuVanBan;
	}
	public void setCanCuVanBan(String canCuVanBan) {
		this.canCuVanBan = canCuVanBan;
	}
	public String getDiaDiem() {
		return diaDiem;
	}
	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}
	public String getDonViDuocGiaoXm() {
		return donViDuocGiaoXm;
	}
	public void setDonViDuocGiaoXm(String donViDuocGiaoXm) {
		this.donViDuocGiaoXm = donViDuocGiaoXm;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getNgayBanHanh() {
		return ngayBanHanh;
	}
	public void setNgayBanHanh(Date ngayBanHanh) {
		this.ngayBanHanh = ngayBanHanh;
		this.ngayBanHanhStr=Formater.date2str(ngayBanHanh);
	}
	public String getNgayBanHanhStr() {
		return ngayBanHanhStr;
	}
	public void setNgayBanHanhStr(String ngayBanHanhStr) throws Exception {
		this.ngayBanHanhStr = ngayBanHanhStr;
		this.ngayBanHanh=Formater.str2date(ngayBanHanhStr);
	}
	public Date getNgayThuTruongDuyet() {
		return ngayThuTruongDuyet;
	}
	public void setNgayThuTruongDuyet(Date ngayThuTruongDuyet) {
		this.ngayThuTruongDuyet = ngayThuTruongDuyet;
		this.ngayThuTruongDuyetStr=Formater.date2str(this.ngayThuTruongDuyet);
	}
	public String getNgayThuTruongDuyetStr() {
		return ngayThuTruongDuyetStr;
	}
	public void setNgayThuTruongDuyetStr(String ngayThuTruongDuyetStr) throws Exception {
		this.ngayThuTruongDuyetStr = ngayThuTruongDuyetStr;
		this.ngayThuTruongDuyet=Formater.str2date(ngayThuTruongDuyetStr);
	}
	public Date getNgayTrinhThuTruongDuyet() {
		return ngayTrinhThuTruongDuyet;
	}
	public void setNgayTrinhThuTruongDuyet(Date ngayTrinhThuTruongDuyet) {
		this.ngayTrinhThuTruongDuyet = ngayTrinhThuTruongDuyet;
		this.ngayTrinhThuTruongDuyetStr=Formater.date2str(ngayTrinhThuTruongDuyet);
	}
	public String getNgayTrinhThuTruongDuyetStr() {
		return ngayTrinhThuTruongDuyetStr;
	}
	public void setNgayTrinhThuTruongDuyetStr(String ngayTrinhThuTruongDuyetStr) throws Exception {
		this.ngayTrinhThuTruongDuyetStr = ngayTrinhThuTruongDuyetStr;
		this.ngayTrinhThuTruongDuyet=Formater.str2date(ngayTrinhThuTruongDuyetStr);
	}
	public Date getNgayTrinhTruongBoPhanKy() {
		return ngayTrinhTruongBoPhanKy;
	}
	public void setNgayTrinhTruongBoPhanKy(Date ngayTrinhTruongBoPhanKy) {
		this.ngayTrinhTruongBoPhanKy = ngayTrinhTruongBoPhanKy;
		this.ngayTrinhTruongBoPhanKyStr=Formater.date2str(ngayTrinhTruongBoPhanKy);
	}
	public String getNgayTrinhTruongBoPhanKyStr() {
		return ngayTrinhTruongBoPhanKyStr;
	}
	public void setNgayTrinhTruongBoPhanKyStr(String ngayTrinhTruongBoPhanKyStr) throws Exception {
		this.ngayTrinhTruongBoPhanKyStr = ngayTrinhTruongBoPhanKyStr;
		this.ngayTrinhTruongBoPhanKy=Formater.str2date(ngayTrinhTruongBoPhanKyStr);
	}
	public Date getNgayTruongBoPhanKy() {
		return ngayTruongBoPhanKy;
	}
	public void setNgayTruongBoPhanKy(Date ngayTruongBoPhanKy) {
		this.ngayTruongBoPhanKy = ngayTruongBoPhanKy;
		this.ngayTruongBoPhanKyStr=Formater.date2str(ngayTruongBoPhanKy);
	}
	public String getNgayTruongBoPhanKyStr() {
		return ngayTruongBoPhanKyStr;
	}
	public void setNgayTruongBoPhanKyStr(String ngayTruongBoPhanKyStr) throws Exception {
		this.ngayTruongBoPhanKyStr = ngayTruongBoPhanKyStr;
		this.ngayTruongBoPhanKy=Formater.str2date(ngayTruongBoPhanKyStr);
	}
	public String getNguoiDeNghi() {
		return nguoiDeNghi;
	}
	public void setNguoiDeNghi(String nguoiDeNghi) {
		this.nguoiDeNghi = nguoiDeNghi;
	}
	public String getNguoiGqTcChucVu() {
		return nguoiGqTcChucVu;
	}
	public void setNguoiGqTcChucVu(String nguoiGqTcChucVu) {
		this.nguoiGqTcChucVu = nguoiGqTcChucVu;
	}
	public String getNguoiGqTcTen() {
		return nguoiGqTcTen;
	}
	public void setNguoiGqTcTen(String nguoiGqTcTen) {
		this.nguoiGqTcTen = nguoiGqTcTen;
	}
	public String getNguoiRaQdCvu() {
		return nguoiRaQdCvu;
	}
	public void setNguoiRaQdCvu(String nguoiRaQdCvu) {
		this.nguoiRaQdCvu = nguoiRaQdCvu;
	}
	public String getNguoiRaQdTen() {
		return nguoiRaQdTen;
	}
	public void setNguoiRaQdTen(String nguoiRaQdTen) {
		this.nguoiRaQdTen = nguoiRaQdTen;
	}
	public String getNoiDungDuocThuLy() {
		return noiDungDuocThuLy;
	}
	public void setNoiDungDuocThuLy(String noiDungDuocThuLy) {
		this.noiDungDuocThuLy = noiDungDuocThuLy;
	}
	public String getSoHoSo() {
		return soHoSo;
	}
	public void setSoHoSo(String soHoSo) {
		this.soHoSo = soHoSo;
	}
	public String getSoQuyetDinh() {
		return soQuyetDinh;
	}
	public void setSoQuyetDinh(String soQuyetDinh) {
		this.soQuyetDinh = soQuyetDinh;
	}
	public String getYeuCauKhac() {
		return yeuCauKhac;
	}
	public void setYeuCauKhac(String yeuCauKhac) {
		this.yeuCauKhac = yeuCauKhac;
	}
	public String getYkienCuaTruongBoPhan() {
		return ykienCuaTruongBoPhan;
	}
	public void setYkienCuaTruongBoPhan(String ykienCuaTruongBoPhan) {
		this.ykienCuaTruongBoPhan = ykienCuaTruongBoPhan;
	}
	public String getYkienThuTruong() {
		return ykienThuTruong;
	}
	public void setYkienThuTruong(String ykienThuTruong) {
		this.ykienThuTruong = ykienThuTruong;
	}
	
}
