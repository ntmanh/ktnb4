package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;

import java.util.Date;

import org.apache.struts.upload.FormFile;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktThBbChitietvatonghop entity. @author MyEclipse Persistence Tools
 */

public class TtktThBbChitietvatonghop extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idCuocTtkt;
	private String idNguoiLap;
	private String tenNguoiLap;
	private Date tgianThTuNgay;
	private Date tgianThDenNgay;
	private String tgianThTuNgayStr;
	private String tgianThDenNgayStr;
	private String ttktTai;
	private Date thoiDiemLapBb;
	private String thoiDiemLapBbStr;
	private String thoiDiemThongQuaStr;
	private String diaDiemLapBb;
	private String noiDungTomTat;
	private Date thoiDiemThongQua;
	private FormFile fileDinhKem;
	private Date ngayPhanCongCuaTd;
	private String loaiBb;
	// Static fields
	public static final String IdCuocTtkt = "idCuocTtkt";
	public static final String LoaiBb = "loaiBb";

	// Constructors
	 private String idNguoiCapNat;
	 private String tenNguoiCapNhat;
	 private Date ngayCapNhat;
	 
	 private String dcID;
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
	 private String dcKiemTraSauTTKT;
	 private String dcTsKlTtktQdxlDaKtra;
	 private String soTienDaThuHauKiem;
	 private String dcTsTienThuHtraSpKhac;
	 private String dcSoTienKnghiThuHtraSpKhac;
	 private String dcSoTienThuDoiTuongKhac;
	 private String dcSoTienNopDoiTuongKhac;
	 
	 public String getDcSoTienNopDoiTuongKhac() {
		return dcSoTienNopDoiTuongKhac;
	}

	public void setDcSoTienNopDoiTuongKhac(String dcSoTienNopDoiTuongKhac) {
		this.dcSoTienNopDoiTuongKhac = dcSoTienNopDoiTuongKhac;
	}

	public String getDcSoTienThuDoiTuongKhac() {
		return dcSoTienThuDoiTuongKhac;
	}

	public void setDcSoTienThuDoiTuongKhac(String dcSoTienThuDoiTuongKhac) {
		this.dcSoTienThuDoiTuongKhac = dcSoTienThuDoiTuongKhac;
	}

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

	/** default constructor */
	public TtktThBbChitietvatonghop() {
	}

	/** minimal constructor */
	public TtktThBbChitietvatonghop(
		String id,
		String idCuocTtkt,
		String idNguoiLap,
		String tenNguoiLap,
		Date tgianThTuNgay,
		Date tgianThDenNgay,
		String ttktTai,
		Date thoiDiemLapBb,
		String diaDiemLapBb,
		Date thoiDiemThongQua,
		Date ngayPhanCongCuaTd,
		String loaiBb) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.idNguoiLap = idNguoiLap;
		this.tenNguoiLap = tenNguoiLap;
		this.tgianThTuNgay = tgianThTuNgay;
		this.tgianThDenNgay = tgianThDenNgay;
		this.ttktTai = ttktTai;
		this.thoiDiemLapBb = thoiDiemLapBb;
		this.diaDiemLapBb = diaDiemLapBb;
		this.thoiDiemThongQua = thoiDiemThongQua;
		this.ngayPhanCongCuaTd = ngayPhanCongCuaTd;
		this.loaiBb = loaiBb;
	}

	/** full constructor */
	public TtktThBbChitietvatonghop(
		String id,
		String idCuocTtkt,
		String idNguoiLap,
		String tenNguoiLap,
		Date tgianThTuNgay,
		Date tgianThDenNgay,
		String ttktTai,
		Date thoiDiemLapBb,
		String diaDiemLapBb,
		String noiDungTomTat,
		Date thoiDiemThongQua,
		FormFile fileDinhKem,
		Date ngayPhanCongCuaTd,
		String loaiBb) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.idNguoiLap = idNguoiLap;
		this.tenNguoiLap = tenNguoiLap;
		this.tgianThTuNgay = tgianThTuNgay;
		this.tgianThDenNgay = tgianThDenNgay;
		this.ttktTai = ttktTai;
		this.thoiDiemLapBb = thoiDiemLapBb;
		this.diaDiemLapBb = diaDiemLapBb;
		this.noiDungTomTat = noiDungTomTat;
		this.thoiDiemThongQua = thoiDiemThongQua;
		this.fileDinhKem = fileDinhKem;
		this.ngayPhanCongCuaTd = ngayPhanCongCuaTd;
		this.loaiBb = loaiBb;
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

	public String getIdNguoiLap() {
		return this.idNguoiLap;
	}

	public void setIdNguoiLap(String idNguoiLap) {
		this.idNguoiLap = idNguoiLap;
	}

	public String getTenNguoiLap() {
		return this.tenNguoiLap;
	}

	public void setTenNguoiLap(String tenNguoiLap) {
		this.tenNguoiLap = tenNguoiLap;
	}

	public Date getTgianThTuNgay() {
		return this.tgianThTuNgay;
	}

	public void setTgianThTuNgay(Date tgianThTuNgay) {
		this.tgianThTuNgay = tgianThTuNgay;
	}

	public Date getTgianThDenNgay() {
		return this.tgianThDenNgay;
	}

	public void setTgianThDenNgay(Date tgianThDenNgay) {
		this.tgianThDenNgay = tgianThDenNgay;
	}

	public String getTtktTai() {
		return this.ttktTai;
	}

	public void setTtktTai(String ttktTai) {
		this.ttktTai = ttktTai;
	}

	public Date getThoiDiemLapBb() {
		return this.thoiDiemLapBb;
	}

	public void setThoiDiemLapBb(Date thoiDiemLapBb) {
		this.thoiDiemLapBb = thoiDiemLapBb;
	}

	public String getDiaDiemLapBb() {
		return this.diaDiemLapBb;
	}

	public void setDiaDiemLapBb(String diaDiemLapBb) {
		this.diaDiemLapBb = diaDiemLapBb;
	}

	public String getNoiDungTomTat() {
		return this.noiDungTomTat;
	}

	public void setNoiDungTomTat(String noiDungTomTat) {
		this.noiDungTomTat = noiDungTomTat;
	}

	public Date getThoiDiemThongQua() {
		return this.thoiDiemThongQua;
	}

	public void setThoiDiemThongQua(Date thoiDiemThongQua) {
		this.thoiDiemThongQua = thoiDiemThongQua;
	}

	public Date getNgayPhanCongCuaTd() {
		return this.ngayPhanCongCuaTd;
	}

	public void setNgayPhanCongCuaTd(Date ngayPhanCongCuaTd) {
		this.ngayPhanCongCuaTd = ngayPhanCongCuaTd;
	}

	public String getLoaiBb() {
		return this.loaiBb;
	}

	public void setLoaiBb(String loaiBb) {
		this.loaiBb = loaiBb;
	}

	/**
	 * @return
	 */
	public FormFile getFileDinhKem() {
		return fileDinhKem;
	}

	/**
	 * @param file
	 */
	public void setFileDinhKem(FormFile file) {
		fileDinhKem = file;
	}

	/**
	 * @return
	 */
	public String getThoiDiemLapBbStr() {
		return thoiDiemLapBbStr;
	}

	/**
	 * @return
	 */
	public String getThoiDiemThongQuaStr() {
		return thoiDiemThongQuaStr;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemLapBbStr(String string) {
		thoiDiemLapBbStr = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemThongQuaStr(String string) {
		thoiDiemThongQuaStr = string;
	}

	/**
	 * @return
	 */
	public String getTgianThDenNgayStr() {
		return tgianThDenNgayStr;
	}

	/**
	 * @return
	 */
	public String getTgianThTuNgayStr() {
		return tgianThTuNgayStr;
	}

	/**
	 * @param string
	 */
	public void setTgianThDenNgayStr(String string) {
		tgianThDenNgayStr = string;
	}

	/**
	 * @param string
	 */
	public void setTgianThTuNgayStr(String string) {
		tgianThTuNgayStr = string;
	}
	
	public String getDcID() {
		return dcID;
	}
	public void setDcID(String dcID) {
		this.dcID = dcID;
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

	public String isDcKiemTraSauTTKT() {
		return dcKiemTraSauTTKT;
	}

	public void setDcKiemTraSauTTKT(String dcKiemTraSauTTKT) {
		this.dcKiemTraSauTTKT = dcKiemTraSauTTKT;
	}

	public String getDcSoTienKnghiThuHtraSpKhac() {
		return dcSoTienKnghiThuHtraSpKhac;
	}

	public void setDcSoTienKnghiThuHtraSpKhac(String dcSoTienKnghiThuHtraSpKhac) {
		this.dcSoTienKnghiThuHtraSpKhac = dcSoTienKnghiThuHtraSpKhac;
	}

	public String getDcTsKlTtktQdxlDaKtra() {
		return dcTsKlTtktQdxlDaKtra;
	}

	public void setDcTsKlTtktQdxlDaKtra(String dcTsKlTtktQdxlDaKtra) {
		this.dcTsKlTtktQdxlDaKtra = dcTsKlTtktQdxlDaKtra;
	}

	public String getDcTsTienThuHtraSpKhac() {
		return dcTsTienThuHtraSpKhac;
	}

	public void setDcTsTienThuHtraSpKhac(String dcTsTienThuHtraSpKhac) {
		this.dcTsTienThuHtraSpKhac = dcTsTienThuHtraSpKhac;
	}

	public String getSoKetLuan() {
		return soKetLuan;
	}

	public void setSoKetLuan(String soKetLuan) {
		this.soKetLuan = soKetLuan;
	}

	public String getSoTienDaThuHauKiem() {
		return soTienDaThuHauKiem;
	}

	public void setSoTienDaThuHauKiem(String soTienDaThuHauKiem) {
		this.soTienDaThuHauKiem = soTienDaThuHauKiem;
	}
	
}