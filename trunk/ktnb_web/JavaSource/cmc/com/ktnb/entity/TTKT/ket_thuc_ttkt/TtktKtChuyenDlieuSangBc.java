package cmc.com.ktnb.entity.TTKT.ket_thuc_ttkt;

import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktKtChuyenDlieuSangBc entity. @author MyEclipse Persistence Tools
 */

public class TtktKtChuyenDlieuSangBc extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idCuocTtkt;   
	private Double saiPhamTienMat;
	private Long saiPhamKhac;
	private Double thuHoiTienMat;
	private Long thuHoiKhac;
	private Double daThuHoiTienMat;
	private Double tienDaThuHoiSauTtkt;
	private Long daThuHoiKhac;
	private Long kienNghiKhac;
	private Long soNguoiBiKienNghiXuLy;
	private Long soCchucThueBiXlyHchinh;
	private Long soDtuongKhacBiXlyHchinh,soTienDaThuHauKiem;
	
	private Long soNguoiChuyenCqDieuTra;
	private Long soVuChuyenCqDieuTra;
	
	private Long soNguoiDaXly;
	private Long kiemDiemRutKn;
	private Long khienTrach;
	private Long canhCao;
	private Long haBacLuong;
	private Long giangChuc;
	private Long cachChuc; 
	private Long buocThoiViec;
	private Long xlyHinhSuCoAn;
	private Long soDvSaiPham;
	private Long chuaXuLy;
	private String ketThucNhapLieu,soKetLuan;
	private Long soKlQdDaKt;
	private Long soTienThuDoiTuongKhac;	
	private Long soTienNopDoiTuongKhac;

	// Constructors
	private String idNguoiCapNat;
	 private String tenNguoiCapNhat;
	 private Date ngayCapNhat;
	 public String getIdNguoiCapNat() {
	  return idNguoiCapNat;
	 }

	 public void setIdNguoiCapNat(String idNguoiCapNat) {
	  this.idNguoiCapNat = idNguoiCapNat;
	 }

	 public Date getNgayCapNhat() {
	  return ngayCapNhat;
	 }

	 public void setNgayCapNhat(Date ngayCapNhat) {
	  this.ngayCapNhat = ngayCapNhat;
	 }

	 public String getTenNguoiCapNhat() {
	  return tenNguoiCapNhat;
	 }

	 public void setTenNguoiCapNhat(String tenNguoiCapNhat) {
	  this.tenNguoiCapNhat = tenNguoiCapNhat;
	 }
	public Long getSoKlQdDaKt() {
		return soKlQdDaKt;
	}

	public void setSoKlQdDaKt(Long soKlQdDaKt) {
		this.soKlQdDaKt = soKlQdDaKt;
	}

	public String getKetThucNhapLieu() {
		return ketThucNhapLieu;
	}

	public void setKetThucNhapLieu(String ketThucNhapLieu) {
		this.ketThucNhapLieu = ketThucNhapLieu;
	}

	public Long getSoVuChuyenCqDieuTra() {
		return soVuChuyenCqDieuTra;
	}

	public void setSoVuChuyenCqDieuTra(Long soVuChuyenCqDieuTra) {
		this.soVuChuyenCqDieuTra = soVuChuyenCqDieuTra;
	}

	/** default constructor */
	public TtktKtChuyenDlieuSangBc() {
	}

	/** minimal constructor */
	public TtktKtChuyenDlieuSangBc(String id, String idCuocTtkt) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
	}

	/** full constructor */
	public TtktKtChuyenDlieuSangBc(String id, String idCuocTtkt,
			Double saiPhamTienMat, Long saiPhamKhac, Double thuHoiTienMat, Long thuHoiKhac, Double daThuHoiTienMat,
			Long daThuHoiKhac, Long kienNghiKhac, Long soNguoiBiKienNghiXuLy,
			Long soCchucThueBiXlyHchinh, Long soDtuongKhacBiXlyHchinh,
			Long chuyenCqDieuTra) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.saiPhamTienMat = saiPhamTienMat;
		this.saiPhamKhac = saiPhamKhac;
		this.thuHoiTienMat = thuHoiTienMat;
		this.thuHoiKhac = thuHoiKhac;
		this.daThuHoiTienMat = daThuHoiTienMat;
		this.daThuHoiKhac = daThuHoiKhac;
		this.kienNghiKhac = kienNghiKhac;
		this.soNguoiBiKienNghiXuLy = soNguoiBiKienNghiXuLy;
		this.soCchucThueBiXlyHchinh = soCchucThueBiXlyHchinh;
		this.soDtuongKhacBiXlyHchinh = soDtuongKhacBiXlyHchinh;
		
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdCuocTtkt() {
		return this.idCuocTtkt;
	}

	public void setIdCuocTtkt(String idCuocTtkt) {
		this.idCuocTtkt = idCuocTtkt;
	}

	public Double getSaiPhamTienMat() {
		return this.saiPhamTienMat;
	}

	public void setSaiPhamTienMat(Double saiPhamTienMat) {
		this.saiPhamTienMat = saiPhamTienMat;
	}

	

	

	public Double getThuHoiTienMat() {
		return this.thuHoiTienMat;
	}

	public void setThuHoiTienMat(Double thuHoiTienMat) {
		this.thuHoiTienMat = thuHoiTienMat;
	}

	

	public Double getDaThuHoiTienMat() {
		return this.daThuHoiTienMat;
	}

	public void setDaThuHoiTienMat(Double daThuHoiTienMat) {
		this.daThuHoiTienMat = daThuHoiTienMat;
	}

	

	public Long getDaThuHoiKhac() {
		return daThuHoiKhac;
	}

	public void setDaThuHoiKhac(Long daThuHoiKhac) {
		this.daThuHoiKhac = daThuHoiKhac;
	}

	public Long getSaiPhamKhac() {
		return saiPhamKhac;
	}

	public void setSaiPhamKhac(Long saiPhamKhac) {
		this.saiPhamKhac = saiPhamKhac;
	}

	public Long getThuHoiKhac() {
		return thuHoiKhac;
	}

	public void setThuHoiKhac(Long thuHoiKhac) {
		this.thuHoiKhac = thuHoiKhac;
	}

	public Long getKienNghiKhac() {
		return this.kienNghiKhac;
	}

	public void setKienNghiKhac(Long kienNghiKhac) {
		this.kienNghiKhac = kienNghiKhac;
	}

	public Long getSoNguoiBiKienNghiXuLy() {
		return this.soNguoiBiKienNghiXuLy;
	}

	public void setSoNguoiBiKienNghiXuLy(Long soNguoiBiKienNghiXuLy) {
		this.soNguoiBiKienNghiXuLy = soNguoiBiKienNghiXuLy;
	}

	public Long getSoCchucThueBiXlyHchinh() {
		return this.soCchucThueBiXlyHchinh;
	}

	public void setSoCchucThueBiXlyHchinh(Long soCchucThueBiXlyHchinh) {
		this.soCchucThueBiXlyHchinh = soCchucThueBiXlyHchinh;
	}

	public Long getSoDtuongKhacBiXlyHchinh() {
		return this.soDtuongKhacBiXlyHchinh;
	}

	public void setSoDtuongKhacBiXlyHchinh(Long soDtuongKhacBiXlyHchinh) {
		this.soDtuongKhacBiXlyHchinh = soDtuongKhacBiXlyHchinh;
	}

	public Long getSoNguoiChuyenCqDieuTra() {
		return soNguoiChuyenCqDieuTra;
	}

	public void setSoNguoiChuyenCqDieuTra(Long soNguoiChuyenCqDieuTra) {
		this.soNguoiChuyenCqDieuTra = soNguoiChuyenCqDieuTra;
	}

	public Long getBuocThoiViec() {
		return buocThoiViec;
	}

	public void setBuocThoiViec(Long buocThoiViec) {
		this.buocThoiViec = buocThoiViec;
	}

	public Long getCachChuc() {
		return cachChuc;
	}

	public void setCachChuc(Long cachChuc) {
		this.cachChuc = cachChuc;
	}

	public Long getCanhCao() {
		return canhCao;
	}

	public void setCanhCao(Long canhCao) {
		this.canhCao = canhCao;
	}

	public Long getGiangChuc() {
		return giangChuc;
	}

	public void setGiangChuc(Long giangChuc) {
		this.giangChuc = giangChuc;
	}

	public Long getHaBacLuong() {
		return haBacLuong;
	}

	public void setHaBacLuong(Long haBacLuong) {
		this.haBacLuong = haBacLuong;
	}

	public Long getKhienTrach() {
		return khienTrach;
	}

	public void setKhienTrach(Long khienTrach) {
		this.khienTrach = khienTrach;
	}

	public Long getKiemDiemRutKn() {
		return kiemDiemRutKn;
	}

	public void setKiemDiemRutKn(Long kiemDiemRutKn) {
		this.kiemDiemRutKn = kiemDiemRutKn;
	}

	public Long getSoNguoiDaXly() {
		return soNguoiDaXly;
	}

	public void setSoNguoiDaXly(Long soNguoiDaXly) {
		this.soNguoiDaXly = soNguoiDaXly;
	}

	public Long getXlyHinhSuCoAn() {
		return xlyHinhSuCoAn;
	}

	public void setXlyHinhSuCoAn(Long xlyHinhSuCoAn) {
		this.xlyHinhSuCoAn = xlyHinhSuCoAn;
	}

	public Double getTienDaThuHoiSauTtkt() {
		return tienDaThuHoiSauTtkt;
	}

	public void setTienDaThuHoiSauTtkt(Double tienDaThuHoiSauTtkt) {
		this.tienDaThuHoiSauTtkt = tienDaThuHoiSauTtkt;
	}

	public Long getSoDvSaiPham() {
		return soDvSaiPham;
	}

	public void setSoDvSaiPham(Long soDvSaiPham) {
		this.soDvSaiPham = soDvSaiPham;
	}

	public void setChuaXuLy(Long chuaXuLy) {
		this.chuaXuLy = chuaXuLy;
		
	}

	public Long getChuaXuLy() {
		return chuaXuLy;
	}

	public String getSoKetLuan() {
		return soKetLuan;
	}

	public void setSoKetLuan(String soKetLuan) {
		this.soKetLuan = soKetLuan;
	}

	public Long getSoTienDaThuHauKiem() {
		return soTienDaThuHauKiem;
	}

	public void setSoTienDaThuHauKiem(Long soTienDaThuHauKiem) {
		this.soTienDaThuHauKiem = soTienDaThuHauKiem;
	}

	public Long getSoTienNopDoiTuongKhac() {
		return soTienNopDoiTuongKhac;
	}

	public void setSoTienNopDoiTuongKhac(Long soTienNopDoiTuongKhac) {
		this.soTienNopDoiTuongKhac = soTienNopDoiTuongKhac;
	}

	public Long getSoTienThuDoiTuongKhac() {
		return soTienThuDoiTuongKhac;
	}

	public void setSoTienThuDoiTuongKhac(Long soTienThuDoiTuongKhac) {
		this.soTienThuDoiTuongKhac = soTienThuDoiTuongKhac;
	}

	

}