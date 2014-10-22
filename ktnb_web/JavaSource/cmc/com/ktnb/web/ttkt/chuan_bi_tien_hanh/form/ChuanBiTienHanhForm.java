/*
 * Created on Jan 6, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmHsTl;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.web.BaseActionForm;

/**
 * @author Nguyen Tien Dung
 * 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ChuanBiTienHanhForm extends BaseActionForm {
	// Thong tin chung
	private String idCuocTtkt;

	private String diaDiem;

	// File Bao cao khao sat
	private FormFile fileBCKS;

	private String maFileBCKS = " ";

	private String tenFileBCKS;

	private String ngayCapNhatBCKS;

	private String nguoiCapNhatBCKS;

	private String loaiFileBCKS;

	private String maDonBCKS;

	private String soTrangBCKS;

	private String noiDungBCKS;

	// Danh sach thanh vien doan
	private String idDsTvd;

	private String ngayLapDsTvd;

	private String noiLapDsTvd;

	private TtktCbChiTietDsTvDoan[] chiTietDsTvd;
	private TtktCmHsTl[] dsBaoCao;
	private TtktCmHsTl[] dsHoSoTl;
	private TtktCmThanhPhanThamDu[] thanhPhanThamDuHopDoanTrienKhai;

	private String noiPheDuyetDsTvd;

	private String ngayPheDuyetDsTvd;

	private String ykienPheDuyetDsTvd;

	private String vanBanQuyDinhCnangNvuQdTvd;

	// Quyet dinh
	private String idQuyetDinh;

	private String soQuyetDinh;

	private String diaDiemRaQuyetDinh;

	private String ngayRaQuyetDnh;

	private String thuTruongCacDvLienQuan;

	private String vanBanQuyDinhCnangNvuQd;

	private String idNguoiChiDaoGiamSat;

	private String tenNguoiChiDaoGiamSat;

	private String chucVuNguoiChiDaoGiamSat;

	private String vanBanKeHoach;

	// Ke hoach
	private String idKeHoach;

	private String diaDiemLapKeHoach;

	private String ngayLapKeHoach;

	private String mucDich;
	private String ykienPheDuyetKh;

	private String yeuCau;

	private String noiDung;

	private String phuongPhapTienHanh;

	private String toChucThucHien;

	private String cheDoThongTinBaoCao;

	private String dieuKienVatChatDamBao;

	private String nhungDieuKienKhac;

	private String noiPheDuyetKeHoach;

	private String ngayPheDuyetKeHoach;

	private FormFile fileDinhKemKeHoach;

	private String maFileKeHoach;

	private String isAttackKeHoach;

	// De cuong
	private String idDecuong;

	private String noiLapDeCuong;

	private String ngayLapDeCuong;

	private String nhungVanDeKhac;

	private String idBaoCaoPhaiCbiCungCap_DC;

	private String idHstlPhaiCbiCungCap_DC;

	private String idDsTvdLapDeCuong;

	private String dsTvdLapDeCuong;// Truong util de gen ra combo an

	private FormFile fileDinhKemDeCuong;

	private String maFileDeCuong;

	private String isAttackDeCuong;

	// Hop doan trien khai
	private String idBienBanHopTrienKhaiDoan;

	private String loaiBienBan;

	private String thoiDiemBatDau;

	private String thoiDiemKetThuc;

	private String diaDiemHop;

	private String noiDungHopDoanTrienKhai;

	private String veViec;

	private String idDsTvdHopTrienKhai;

	private String dsTvdHopTrienKhai;// Truong util de gen ra combo an

	// Kiem tra thay doi du lieu tren cac tab
	private String isChangeBCKS;

	private String isChangeTvd;

	private String isChangeQuyetDinh;

	private String isChangeDeCuong;

	private String isChangeKeHoach;

	private String isChangeHopDoanTrienKhai;
	
	/**
	 * Edit ntmanh
	 */
	private String bcPhaiCbiCungCap;
	private String hsPhaiCbiCungCap;
	

	public String getBcPhaiCbiCungCap() {
		return bcPhaiCbiCungCap;
	}

	public void setBcPhaiCbiCungCap(String bcPhaiCbiCungCap) {
		this.bcPhaiCbiCungCap = bcPhaiCbiCungCap;
	}

	public String getHsPhaiCbiCungCap() {
		return hsPhaiCbiCungCap;
	}

	public void setHsPhaiCbiCungCap(String hsPhaiCbiCungCap) {
		this.hsPhaiCbiCungCap = hsPhaiCbiCungCap;
	}

	/**
	 * @return
	 */
	public String getCheDoThongTinBaoCao() {
		return cheDoThongTinBaoCao;
	}

	/**
	 * @return
	 */
	public TtktCbChiTietDsTvDoan[] getChiTietDsTvd() {
		return chiTietDsTvd==null ? new TtktCbChiTietDsTvDoan[1] : chiTietDsTvd;
	}

	/**
	 * @return
	 */
	public String getDiaDiemLapKeHoach() {
		return diaDiemLapKeHoach;
	}

	/**
	 * @return
	 */
	public String getDiaDiemRaQuyetDinh() {
		return diaDiemRaQuyetDinh;
	}

	/**
	 * @return
	 */
	public String getDieuKienVatChatDamBao() {
		return dieuKienVatChatDamBao;
	}

	/**
	 * @return
	 */
	public String getIdCuocTtkt() {
		return idCuocTtkt;
	}

	/**
	 * @return
	 */
	public String getIdDecuong() {
		return idDecuong;
	}

	/**
	 * @return
	 */
	public String getIdDsTvd() {
		return idDsTvd;
	}

	/**
	 * @return
	 */
	public String getIdKeHoach() {
		return idKeHoach;
	}

	/**
	 * @return
	 */
	public String getIdQuyetDinh() {
		return idQuyetDinh;
	}

	/**
	 * @return
	 */
	public String getLoaiFileBCKS() {
		return loaiFileBCKS;
	}

	/**
	 * @return
	 */
	public String getMaFileBCKS() {
		return maFileBCKS;
	}

	/**
	 * @return
	 */
	public String getMucDich() {
		return mucDich;
	}

	/**
	 * @return
	 */
	public String getNgayRaQuyetDnh() {
		return ngayRaQuyetDnh;
	}

	/**
	 * @return
	 */
	public String getNguoiCapNhatBCKS() {
		return nguoiCapNhatBCKS;
	}

	/**
	 * @return
	 */
	public String getNhungDieuKienKhac() {
		return nhungDieuKienKhac;
	}

	/**
	 * @return
	 */
	public String getNhungVanDeKhac() {
		return nhungVanDeKhac;
	}

	/**
	 * @return
	 */
	public String getNoiDung() {
		return noiDung;
	}

	/**
	 * @return
	 */
	public String getNoiDungBCKS() {
		return noiDungBCKS;
	}

	/**
	 * @return
	 */
	public String getNoiDungHopDoanTrienKhai() {
		return noiDungHopDoanTrienKhai;
	}

	/**
	 * @return
	 */
	public String getNoiLapDeCuong() {
		return noiLapDeCuong;
	}

	/**
	 * @return
	 */
	public String getPhuongPhapTienHanh() {
		return phuongPhapTienHanh;
	}

	/**
	 * @return
	 */
	public String getSoQuyetDinh() {
		return soQuyetDinh;
	}

	/**
	 * @return
	 */
	public String getTenFileBCKS() {
		return tenFileBCKS;
	}

	/**
	 * @return
	 */
	public String getToChucThucHien() {
		return toChucThucHien;
	}

	/**
	 * @return
	 */
	public String getYeuCau() {
		return yeuCau;
	}

	/**
	 * @param string
	 */
	public void setCheDoThongTinBaoCao(String string) {
		cheDoThongTinBaoCao = string;
	}

	/**
	 * @param tvds
	 */
	public void setChiTietDsTvd(TtktCbChiTietDsTvDoan[] tvds) {
		chiTietDsTvd = tvds;
	}

	/**
	 * @param string
	 */
	public void setDiaDiemLapKeHoach(String string) {
		diaDiemLapKeHoach = string;
	}

	/**
	 * @param string
	 */
	public void setDiaDiemRaQuyetDinh(String string) {
		diaDiemRaQuyetDinh = string;
	}

	/**
	 * @param string
	 */
	public void setDieuKienVatChatDamBao(String string) {
		dieuKienVatChatDamBao = string;
	}

	/**
	 * @param string
	 */
	public void setIdCuocTtkt(String string) {
		idCuocTtkt = string;
	}

	/**
	 * @param string
	 */
	public void setIdDecuong(String string) {
		idDecuong = string;
	}

	/**
	 * @param string
	 */
	public void setIdDsTvd(String string) {
		idDsTvd = string;
	}

	/**
	 * @param string
	 */
	public void setIdKeHoach(String string) {
		idKeHoach = string;
	}

	/**
	 * @param string
	 */
	public void setIdQuyetDinh(String string) {
		idQuyetDinh = string;
	}

	/**
	 * @param string
	 */
	public void setLoaiFileBCKS(String string) {
		loaiFileBCKS = string;
	}

	/**
	 * @param string
	 */
	public void setMaDonBCKS(String string) {
		maDonBCKS = string;
	}

	/**
	 * @param string
	 */
	public void setMaFileBCKS(String string) {
		maFileBCKS = string;
	}

	/**
	 * @param string
	 */
	public void setMucDich(String string) {
		mucDich = string;
	}

	/**
	 * @param string
	 */
	public void setNgayRaQuyetDnh(String string) {
		ngayRaQuyetDnh = string;
	}

	/**
	 * @param string
	 */
	public void setNguoiCapNhatBCKS(String string) {
		nguoiCapNhatBCKS = string;
	}

	/**
	 * @param string
	 */
	public void setNhungDieuKienKhac(String string) {
		nhungDieuKienKhac = string;
	}

	/**
	 * @param string
	 */
	public void setNhungVanDeKhac(String string) {
		nhungVanDeKhac = string;
	}

	/**
	 * @param string
	 */
	public void setNoiDung(String string) {
		noiDung = string;
	}

	/**
	 * @param string
	 */
	public void setNoiDungBCKS(String string) {
		noiDungBCKS = string;
	}

	/**
	 * @param string
	 */
	public void setNoiDungHopDoanTrienKhai(String string) {
		noiDungHopDoanTrienKhai = string;
	}

	/**
	 * @param string
	 */
	public void setNoiLapDeCuong(String string) {
		noiLapDeCuong = string;
	}

	/**
	 * @param string
	 */
	public void setPhuongPhapTienHanh(String string) {
		phuongPhapTienHanh = string;
	}

	/**
	 * @param string
	 */
	public void setSoQuyetDinh(String string) {
		soQuyetDinh = string;
	}

	/**
	 * @param string
	 */
	public void setTenFileBCKS(String string) {
		tenFileBCKS = string;
	}

	/**
	 * @param string
	 */
	public void setToChucThucHien(String string) {
		toChucThucHien = string;
	}

	/**
	 * @param string
	 */
	public void setYeuCau(String string) {
		yeuCau = string;
	}

	/**
	 * @return
	 */
	public String getNgayLapDsTvd() {
		return ngayLapDsTvd;
	}

	/**
	 * @return
	 */
	public String getNgayPheDuyetDsTvd() {
		return ngayPheDuyetDsTvd;
	}

	/**
	 * @return
	 */
	public String getNoiLapDsTvd() {
		return noiLapDsTvd;
	}

	/**
	 * @return
	 */
	public String getNoiPheDuyetDsTvd() {
		return noiPheDuyetDsTvd;
	}

	/**
	 * @param string
	 */
	public void setNgayLapDsTvd(String string) {
		ngayLapDsTvd = string;
	}

	/**
	 * @param string
	 */
	public void setNgayPheDuyetDsTvd(String string) {
		ngayPheDuyetDsTvd = string;
	}

	/**
	 * @param string
	 */
	public void setNoiLapDsTvd(String string) {
		noiLapDsTvd = string;
	}

	/**
	 * @param string
	 */
	public void setNoiPheDuyetDsTvd(String string) {
		noiPheDuyetDsTvd = string;
	}

	/**
	 * @return
	 */
	public String getThuTruongCacDvLienQuan() {
		return thuTruongCacDvLienQuan;
	}

	/**
	 * @param string
	 */
	public void setThuTruongCacDvLienQuan(String string) {
		thuTruongCacDvLienQuan = string;
	}

	/**
	 * @return
	 */
	public String getIdBienBanHopTrienKhaiDoan() {
		return idBienBanHopTrienKhaiDoan;
	}

	/**
	 * @return
	 */
	public String getLoaiBienBan() {
		return loaiBienBan;
	}

	/**
	 * @return
	 */
	public String getMaDonBCKS() {
		return maDonBCKS;
	}

	/**
	 * @return
	 */
	public String getThoiDiemBatDau() {
		return thoiDiemBatDau;
	}

	/**
	 * @return
	 */
	public String getThoiDiemKetThuc() {
		return thoiDiemKetThuc;
	}

	/**
	 * @param string
	 */
	public void setIdBienBanHopTrienKhaiDoan(String string) {
		idBienBanHopTrienKhaiDoan = string;
	}

	/**
	 * @param string
	 */
	public void setLoaiBienBan(String string) {
		loaiBienBan = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemBatDau(String string) {
		thoiDiemBatDau = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemKetThuc(String string) {
		thoiDiemKetThuc = string;
	}

	/**
	 * @return
	 */
	public String getDiaDiemHop() {
		return diaDiemHop;
	}

	/**
	 * @param string
	 */
	public void setDiaDiemHop(String string) {
		diaDiemHop = string;
	}

	/**
	 * @return
	 */
	public String getVeViec() {
		return veViec;
	}

	/**
	 * @param string
	 */
	public void setVeViec(String string) {
		veViec = string;
	}

	/**
	 * @return
	 */
	public String getYkienPheDuyetDsTvd() {
		return ykienPheDuyetDsTvd;
	}

	/**
	 * @param string
	 */
	public void setYkienPheDuyetDsTvd(String string) {
		ykienPheDuyetDsTvd = string;
	}

	/**
	 * @return
	 */
	public String getNoiPheDuyetKeHoach() {
		return noiPheDuyetKeHoach;
	}

	/**
	 * @param string
	 */
	public void setNoiPheDuyetKeHoach(String string) {
		noiPheDuyetKeHoach = string;
	}

	/**
	 * @return
	 */
	public String getNgayLapKeHoach() {
		return ngayLapKeHoach;
	}

	/**
	 * @return
	 */
	public String getNgayPheDuyetKeHoach() {
		return ngayPheDuyetKeHoach;
	}

	/**
	 * @param string
	 */
	public void setNgayLapKeHoach(String string) {
		ngayLapKeHoach = string;
	}

	/**
	 * @param string
	 */
	public void setNgayPheDuyetKeHoach(String string) {
		ngayPheDuyetKeHoach = string;
	}

	/**
	 * @return
	 */
	public FormFile getFileBCKS() {
		return fileBCKS;
	}

	/**
	 * @param file
	 */
	public void setFileBCKS(FormFile file) {
		fileBCKS = file;
	}

	/**
	 * @return
	 */
	public String getNgayCapNhatBCKS() {
		return ngayCapNhatBCKS;
	}

	/**
	 * @return
	 */
	public String getNgayLapDeCuong() {
		return ngayLapDeCuong;
	}

	/**
	 * @return
	 */
	public String getSoTrangBCKS() {
		return soTrangBCKS;
	}

	/**
	 * @param string
	 */
	public void setNgayCapNhatBCKS(String string) {
		ngayCapNhatBCKS = string;
	}

	/**
	 * @param string
	 */
	public void setNgayLapDeCuong(String string) {
		ngayLapDeCuong = string;
	}

	/**
	 * @param string
	 */
	public void setSoTrangBCKS(String string) {
		soTrangBCKS = string;
	}

	/**
	 * @return
	 */
	public TtktCmThanhPhanThamDu[] getThanhPhanThamDuHopDoanTrienKhai() {
		return thanhPhanThamDuHopDoanTrienKhai==null?new TtktCmThanhPhanThamDu[1]:thanhPhanThamDuHopDoanTrienKhai;
	}

	/**
	 * @param dus
	 */
	public void setThanhPhanThamDuHopDoanTrienKhai(TtktCmThanhPhanThamDu[] dus) {
		thanhPhanThamDuHopDoanTrienKhai = dus;
	}

	/**
	 * @return
	 */
	public String getIsChangeBCKS() {
		return isChangeBCKS;
	}

	/**
	 * @return
	 */
	public String getIsChangeDeCuong() {
		return isChangeDeCuong;
	}

	/**
	 * @return
	 */
	public String getIsChangeHopDoanTrienKhai() {
		return isChangeHopDoanTrienKhai;
	}

	/**
	 * @return
	 */
	public String getIsChangeKeHoach() {
		return isChangeKeHoach;
	}

	/**
	 * @return
	 */
	public String getIsChangeQuyetDinh() {
		return isChangeQuyetDinh;
	}

	/**
	 * @return
	 */
	public String getIsChangeTvd() {
		return isChangeTvd;
	}

	/**
	 * @param string
	 */
	public void setIsChangeBCKS(String string) {
		isChangeBCKS = string;
	}

	/**
	 * @param string
	 */
	public void setIsChangeDeCuong(String string) {
		isChangeDeCuong = string;
	}

	/**
	 * @param string
	 */
	public void setIsChangeHopDoanTrienKhai(String string) {
		isChangeHopDoanTrienKhai = string;
	}

	/**
	 * @param string
	 */
	public void setIsChangeKeHoach(String string) {
		isChangeKeHoach = string;
	}

	/**
	 * @param string
	 */
	public void setIsChangeQuyetDinh(String string) {
		isChangeQuyetDinh = string;
	}

	/**
	 * @param string
	 */
	public void setIsChangeTvd(String string) {
		isChangeTvd = string;
	}

	/**
	 * @return
	 */
	public String getDiaDiem() {
		return diaDiem;
	}

	/**
	 * @param string
	 */
	public void setDiaDiem(String string) {
		diaDiem = string;
	}

	/**
	 * @return
	 */
	public String getIdBaoCaoPhaiCbiCungCap_DC() {
		return idBaoCaoPhaiCbiCungCap_DC;
	}

	/**
	 * @return
	 */
	public String getIdHstlPhaiCbiCungCap_DC() {
		return idHstlPhaiCbiCungCap_DC;
	}

	/**
	 * @param string
	 */
	public void setIdBaoCaoPhaiCbiCungCap_DC(String string) {
		idBaoCaoPhaiCbiCungCap_DC = string;
	}

	/**
	 * @param string
	 */
	public void setIdHstlPhaiCbiCungCap_DC(String string) {
		idHstlPhaiCbiCungCap_DC = string;
	}

	/**
	 * @return
	 */
	public String getChucVuNguoiChiDaoGiamSat() {
		return chucVuNguoiChiDaoGiamSat;
	}

	/**
	 * @return
	 */
	public String getIdNguoiChiDaoGiamSat() {
		return idNguoiChiDaoGiamSat;
	}

	/**
	 * @return
	 */
	public String getTenNguoiChiDaoGiamSat() {
		return tenNguoiChiDaoGiamSat;
	}

	/**
	 * @return
	 */
	public String getVanBanQuyDinhCnangNvuQd() {
		return vanBanQuyDinhCnangNvuQd;
	}

	/**
	 * @param string
	 */
	public void setChucVuNguoiChiDaoGiamSat(String string) {
		chucVuNguoiChiDaoGiamSat = string;
	}

	/**
	 * @param string
	 */
	public void setIdNguoiChiDaoGiamSat(String string) {
		idNguoiChiDaoGiamSat = string;
	}

	/**
	 * @param string
	 */
	public void setTenNguoiChiDaoGiamSat(String string) {
		tenNguoiChiDaoGiamSat = string;
	}

	/**
	 * @param string
	 */
	public void setVanBanQuyDinhCnangNvuQd(String string) {
		vanBanQuyDinhCnangNvuQd = string;
	}

	/**
	 * @return
	 */
	public String getVanBanQuyDinhCnangNvuQdTvd() {
		return vanBanQuyDinhCnangNvuQdTvd;
	}

	/**
	 * @param string
	 */
	public void setVanBanQuyDinhCnangNvuQdTvd(String string) {
		vanBanQuyDinhCnangNvuQdTvd = string;
	}

	/**
	 * @return
	 */
	public String getVanBanKeHoach() {
		return vanBanKeHoach;
	}

	/**
	 * @param string
	 */
	public void setVanBanKeHoach(String string) {
		vanBanKeHoach = string;
	}

	/**
	 * @param string
	 */
	public void getVanBanKeHoach(String string) {
		vanBanKeHoach = string;

	}

	/**
	 * @return
	 */
	public String getIdDsTvdHopTrienKhai() {
		return idDsTvdHopTrienKhai;
	}

	/**
	 * @return
	 */
	public String getIdDsTvdLapDeCuong() {
		return idDsTvdLapDeCuong;
	}

	/**
	 * @param string
	 */
	public void setIdDsTvdHopTrienKhai(String string) {
		idDsTvdHopTrienKhai = string;
	}

	/**
	 * @param string
	 */
	public void setIdDsTvdLapDeCuong(String string) {
		idDsTvdLapDeCuong = string;
	}

	/**
	 * @return
	 */
	public String getDsTvdHopTrienKhai() {
		return dsTvdHopTrienKhai;
	}

	/**
	 * @return
	 */
	public String getDsTvdLapDeCuong() {
		return dsTvdLapDeCuong;
	}

	/**
	 * @param string
	 */
	public void setDsTvdHopTrienKhai(String string) {
		dsTvdHopTrienKhai = string;
	}

	/**
	 * @param string
	 */
	public void setDsTvdLapDeCuong(String string) {
		dsTvdLapDeCuong = string;
	}

	public FormFile getFileDinhKemKeHoach() {
		return fileDinhKemKeHoach;
	}

	public void setFileDinhKemKeHoach(FormFile fileDinhKemKeHoach) {
		this.fileDinhKemKeHoach = fileDinhKemKeHoach;
	}

	public String getMaFileKeHoach() {
		return maFileKeHoach;
	}

	public void setMaFileKeHoach(String maFileKeHoach) {
		this.maFileKeHoach = maFileKeHoach;
	}

	public String getIsAttackKeHoach() {
		return isAttackKeHoach;
	}

	public void setIsAttackKeHoach(String isAttackKeHoach) {
		this.isAttackKeHoach = isAttackKeHoach;
	}

	public TtktCmHsTl[] getDsBaoCao() {
		return dsBaoCao==null?new TtktCmHsTl[1]:dsBaoCao;
	}

	public void setDsBaoCao(TtktCmHsTl[] dsBaoCao) {
		this.dsBaoCao = dsBaoCao;
	}

	public TtktCmHsTl[] getDsHoSoTl() {
		return dsHoSoTl==null?new TtktCmHsTl[1]:dsHoSoTl;
	}

	public void setDsHoSoTl(TtktCmHsTl[] dsHoSoTl) {
		this.dsHoSoTl = dsHoSoTl;
	}

	public FormFile getFileDinhKemDeCuong() {
		return fileDinhKemDeCuong;
	}

	public void setFileDinhKemDeCuong(FormFile fileDinhKemDeCuong) {
		this.fileDinhKemDeCuong = fileDinhKemDeCuong;
	}

	public String getIsAttackDeCuong() {
		return isAttackDeCuong;
	}

	public void setIsAttackDeCuong(String isAttackDeCuong) {
		this.isAttackDeCuong = isAttackDeCuong;
	}

	public String getMaFileDeCuong() {
		return maFileDeCuong;
	}

	public void setMaFileDeCuong(String maFileDeCuong) {
		this.maFileDeCuong = maFileDeCuong;
	}

	public String getYkienPheDuyetKh() {
		return ykienPheDuyetKh;
	}

	public void setYkienPheDuyetKh(String ykienPheDuyetKh) {
		this.ykienPheDuyetKh = ykienPheDuyetKh;
	}

	private String maCuocTtkt;

	public String getMaCuocTtkt() {
		return maCuocTtkt;
	}

	public void setMaCuocTtkt(String maCuocTtkt) {
		this.maCuocTtkt = maCuocTtkt;
	}
	
	public TtktCbChiTietDsTvDoan getChiTietDsTvd(int index){
		try{
			return chiTietDsTvd[index]==null?new TtktCbChiTietDsTvDoan():chiTietDsTvd[index];
		}
		catch(Exception ex){
			return new TtktCbChiTietDsTvDoan();
		}
	}
	public void setChiTietDsTvd(int index, TtktCbChiTietDsTvDoan value){
		chiTietDsTvd[index] = value;
	}
	
	public TtktCmHsTl getDsBaoCao(int index){
		try{
			return dsBaoCao[index]==null?new TtktCmHsTl():dsBaoCao[index];
		}
		catch(Exception ex){
			return new TtktCmHsTl();
		}
	}
	public void setDsBaoCao(int index, TtktCmHsTl value){
		dsBaoCao[index] = value;
	}
	
	public TtktCmHsTl getDsHoSoTl(int index){
		try{
			return dsHoSoTl[index]==null?new TtktCmHsTl():dsHoSoTl[index];
		}
		catch(Exception ex){
			return new TtktCmHsTl();
		}
	}
	public void setDsHoSoTl(int index, TtktCmHsTl value){
		dsHoSoTl[index] = value;
	}
	
	public TtktCmThanhPhanThamDu getThanhPhanThamDuHopDoanTrienKhai(int index){		
		try{
			return thanhPhanThamDuHopDoanTrienKhai[index]==null?new TtktCmThanhPhanThamDu():thanhPhanThamDuHopDoanTrienKhai[index];
		}
		catch(Exception ex){
			return new TtktCmThanhPhanThamDu();
		}
	}
	public void setThanhPhanThamDuHopDoanTrienKhai(int index, TtktCmThanhPhanThamDu value){
		thanhPhanThamDuHopDoanTrienKhai[index] = value;
	}
}
