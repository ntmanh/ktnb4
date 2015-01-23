
package cmc.com.ktnb.entity.TTKT.dung_chung;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbCache;

/**
 * KtnbCuocTtkt entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TtktKhCuocTtkt extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;

	private String ma;

	private String idDonViTh;

	private String idDonViBi;

	private Byte thoiGianDuKien;

	private Date nienDoTuNgay;

	private Date nienDoDenNgay;

	private String nienDoTuNgayStr;

	private String nienDoDenNgayStr;

	private Boolean loai;

	private Boolean hinhThuc;

	private String tenDonViTh;

	private String tenDonViBi;

	private String trangThai;

	private Collection dsTtktCqtTrucThuoc;

	private Collection dsNoiDungTTKT;

	private String idCuocTtktCha;

	private String idTruongDoan;

	private String tenTruongDoan;

	private String noiRaThongBaoKetThuc;

	private Date ngayRaThongBaoKetThuc;

	private Date ngayKetThuc;

	private Date endDate;

	private Date thoiGianDuKienDenNgay;

	private String thoiGianDuKienDenNgayStr;

	private Date thoiGianDuKienTuNgay;

	private String thoiGianDuKienTuNgayStr;

	private String idCuocTtktTrongQd;

	private String idCuocTtktTrongKh;

	private String maCuocTtktTrongKh;

	private String loaiChinhSua;

	private String idCuocKhCu;

	private String idCuocKhMoi;

	private String idCuocQdCu;

	private String idCuocQdMoi;

	private String loaiCuocTtktKeHoachNam;

	private String loaiCuocTtktQuyetDinh;

	private String maTrangThai;
	
	private String donVer;

	// Static field
	public static final String IdCuocKhCu = "idCuocKhCu";

	public static final String IdCuocKhMoi = "idCuocKhMoi";

	public static final String IdCuocQdCu = "idCuocQdCu";

	public static final String IdCuocQdMoi = "idCuocQdMoi";

	public static final String LoaiCuocTtktKeHoachNam = "loaiCuocTtktKeHoachNam";

	public static final String LoaiCuocTtktQuyetDinh = "loaiCuocTtktQuyetDinh";

	public static String Id = "id";

	public static String Ma = "ma";

	public static String IdDonViTh = "idDonViTh";

	public static String IdDonViBi = "idDonViBi";

	public static String ThoiGianDuKien = "thoiGianDuKien";

	public static String NienDoTuNgay = "nienDoTuNgay";

	public static String NienDoDenNgay = "nienDoDenNgay";

	public static String Loai = "loai";

	public static String HinhThuc = "hinhThuc";

	public static String TenDonViTh = "tenDonViTh";

	public static String TenDonViBi = "tenDonViBi";

	public static String TrangThai = "trangThai";

	public static String IdCuocTtktCha = "idCuocTtktCha";

	public static String IdTruongDoan = "idTruongDoan";

	public static String TenTruongDoan = "tenTruongDoan";

	public static String ThoiGianDuKienTuNgay = "thoiGianDuKienTuNgay";

	public static String ThoiGianDuKienDenNgay = "thoiGianDuKienDenNgay";

	public static String IdCuocTtktTrongQd = "idCuocTtktTrongQd";

	public static String IdCuocTtktTrongKh = "idCuocTtktTrongKh";

	public static String MaCuocTtktTrongKh = "maCuocTtktTrongKh";

	public static String LoaiChinhSua = "loaiChinhSua";

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
	/** default constructor */
	public TtktKhCuocTtkt() {
	}

	/** full constructor */
	public TtktKhCuocTtkt(String id, String ma, String idDonViTh, String idDonViBi, Byte thoiGianDuKien, Date nienDoTuNgay, Date nienDoDenNgay, Boolean loai, Boolean hinhThuc, String tenDonViTh,
			String tenDonViBi, String maNoiDung, String tenNoiDung, String trangThai) {
		this.id = id;
		this.ma = ma;
		this.idDonViTh = idDonViTh;
		this.idDonViBi = idDonViBi;
		this.thoiGianDuKien = thoiGianDuKien;
		this.nienDoTuNgay = nienDoTuNgay;
		this.nienDoDenNgay = nienDoDenNgay;
		this.loai = loai;
		this.hinhThuc = hinhThuc;
		this.tenDonViTh = tenDonViTh;
		this.tenDonViBi = tenDonViBi;
		this.trangThai = trangThai;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMa() {
		return this.ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getIdDonViTh() {
		return this.idDonViTh;
	}

	public void setIdDonViTh(String idDonViTh) {
		this.idDonViTh = idDonViTh;
	}

	public String getIdDonViBi() {
		return this.idDonViBi;
	}

	public void setIdDonViBi(String idDonViBi) {
		this.idDonViBi = idDonViBi;
	}

	public Byte getThoiGianDuKien() {
		return this.thoiGianDuKien;
	}

	public void setThoiGianDuKien(Byte thoiGianDuKien) {
		this.thoiGianDuKien = thoiGianDuKien;
	}

	public Date getNienDoTuNgay() {
		return this.nienDoTuNgay;
	}

	public void setNienDoTuNgay(Date nienDoTuNgay) {
		this.nienDoTuNgay = nienDoTuNgay;
	}

	public Date getNienDoDenNgay() {
		return this.nienDoDenNgay;
	}

	public void setNienDoDenNgay(Date nienDoDenNgay) {
		this.nienDoDenNgay = nienDoDenNgay;
	}

	public Boolean getLoai() {
		return this.loai;
	}

	public void setLoai(Boolean loai) {
		this.loai = loai;
	}

	public Boolean getHinhThuc() {
		return this.hinhThuc;
	}

	public void setHinhThuc(Boolean hinhThuc) {
		this.hinhThuc = hinhThuc;
	}

	public String getTenDonViTh() {
		return this.tenDonViTh;
	}

	public void setTenDonViTh(String tenDonViTh) {
		this.tenDonViTh = tenDonViTh;
	}

	public String getTenDonViBi() {
		return this.tenDonViBi;
	}

	public void setTenDonViBi(String tenDonViBi) {
		this.tenDonViBi = tenDonViBi;
	}

	public String getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
		this.maTrangThai = selectMaTrangThai(trangThai);
	}

	public static String selectMaTrangThai(String tenTrangThai) {
		HashMap hm = (HashMap) KtnbCache.getInstance().get("DM_TT_TTKT");
		return (String) hm.get(tenTrangThai);
	}

	/**
	 * @return
	 */
	public Collection getDsTtktCqtTrucThuoc() {
		return dsTtktCqtTrucThuoc;
	}

	/**
	 * @param collection
	 */
	public void setDsTtktCqtTrucThuoc(Collection collection) {
		dsTtktCqtTrucThuoc = collection;
	}

	/**
	 * @return
	 */
	public Collection getDsNoiDungTTKT() {
		return dsNoiDungTTKT;
	}

	/**
	 * @param collection
	 */
	public void setDsNoiDungTTKT(Collection collection) {
		dsNoiDungTTKT = collection;
	}

	/**
	 * @return
	 */
	public String getIdCuocTtktCha() {
		return idCuocTtktCha;
	}

	/**
	 * @param string
	 */
	public void setIdCuocTtktCha(String string) {
		idCuocTtktCha = string;
	}

	/**
	 * @return
	 */
	public String getIdTruongDoan() {
		return idTruongDoan;
	}

	/**
	 * @return
	 */
	public String getTenTruongDoan() {
		return tenTruongDoan;
	}

	/**
	 * @param string
	 */
	public static void setLoai(String string) {
		Loai = string;
	}

	/**
	 * @param string
	 */
	public static void setNienDoDenNgay(String string) {
		NienDoDenNgay = string;
	}

	/**
	 * @param string
	 */
	public static void setNienDoTuNgay(String string) {
		NienDoTuNgay = string;
	}

	/**
	 * @param string
	 */
	public static void setThoiGianDuKien(String string) {
		ThoiGianDuKien = string;
	}

	/**
	 * @param string
	 */
	public void setIdTruongDoan(String string) {
		idTruongDoan = string;
	}

	/**
	 * @param string
	 */
	public void setTenTruongDoan(String string) {
		tenTruongDoan = string;
	}

	/**
	 * @return
	 */
	public String getNoiRaThongBaoKetThuc() {
		return noiRaThongBaoKetThuc;
	}

	/**
	 * @param string
	 */
	public void setNoiRaThongBaoKetThuc(String string) {
		noiRaThongBaoKetThuc = string;
	}

	/**
	 * @return
	 */
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	/**
	 * @return
	 */
	public Date getNgayRaThongBaoKetThuc() {
		return ngayRaThongBaoKetThuc;
	}

	/**
	 * @param date
	 */
	public void setNgayKetThuc(Date date) {
		ngayKetThuc = date;
	}

	/**
	 * @param date
	 */
	public void setNgayRaThongBaoKetThuc(Date date) {
		ngayRaThongBaoKetThuc = date;
	}

	/**
	 * @return
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param date
	 */
	public void setEndDate(Date date) {
		endDate = date;
	}

	/**
	 * @return
	 */
	public Date getThoiGianDuKienDenNgay() {
		return thoiGianDuKienDenNgay;
	}

	/**
	 * @return
	 */
	public String getThoiGianDuKienDenNgayStr() {
		return thoiGianDuKienDenNgayStr;
	}

	/**
	 * @return
	 */
	public Date getThoiGianDuKienTuNgay() {
		return thoiGianDuKienTuNgay;
	}

	/**
	 * @return
	 */
	public String getThoiGianDuKienTuNgayStr() {
		return thoiGianDuKienTuNgayStr;
	}

	/**
	 * @param string
	 */
	public static void setHinhThuc(String string) {
		HinhThuc = string;
	}

	/**
	 * @param date
	 */
	public void setThoiGianDuKienDenNgay(Date date) {
		thoiGianDuKienDenNgay = date;
	}

	/**
	 * @param string
	 */
	public void setThoiGianDuKienDenNgayStr(String string) {
		thoiGianDuKienDenNgayStr = string;
	}

	/**
	 * @param date
	 */
	public void setThoiGianDuKienTuNgay(Date date) {
		thoiGianDuKienTuNgay = date;
	}

	/**
	 * @param string
	 */
	public void setThoiGianDuKienTuNgayStr(String string) {
		thoiGianDuKienTuNgayStr = string;
	}

	/**
	 * @return
	 */
	public String getNienDoDenNgayStr() {
		return nienDoDenNgayStr;
	}

	/**
	 * @return
	 */
	public String getNienDoTuNgayStr() {
		return nienDoTuNgayStr;
	}

	/**
	 * @param string
	 */
	public static void setThoiGianDuKienDenNgay(String string) {
		ThoiGianDuKienDenNgay = string;
	}

	/**
	 * @param string
	 */
	public static void setThoiGianDuKienTuNgay(String string) {
		ThoiGianDuKienTuNgay = string;
	}

	/**
	 * @param string
	 */
	public void setNienDoDenNgayStr(String string) {
		nienDoDenNgayStr = string;
	}

	/**
	 * @param string
	 */
	public void setNienDoTuNgayStr(String string) {
		nienDoTuNgayStr = string;
	}

	/**
	 * @return
	 */
	public String getIdCuocTtktTrongQd() {
		return idCuocTtktTrongQd;
	}

	/**
	 * @param string
	 */
	public void setIdCuocTtktTrongQd(String string) {
		idCuocTtktTrongQd = string;
	}

	/**
	 * @return
	 */
	public String getLoaiChinhSua() {
		return loaiChinhSua;
	}

	/**
	 * @param string
	 */
	public void setLoaiChinhSua(String string) {
		loaiChinhSua = string;
	}

	/**
	 * @return
	 */
	public String getIdCuocTtktTrongKh() {
		return idCuocTtktTrongKh;
	}

	/**
	 * @return
	 */
	public String getMaCuocTtktTrongKh() {
		return maCuocTtktTrongKh;
	}

	/**
	 * @param string
	 */
	public void setIdCuocTtktTrongKh(String string) {
		idCuocTtktTrongKh = string;
	}

	/**
	 * @param string
	 */
	public void setMaCuocTtktTrongKh(String string) {
		maCuocTtktTrongKh = string;
	}

	/**
	 * @return
	 */
	public String getLoaiCuocTtktKeHoachNam() {
		return loaiCuocTtktKeHoachNam;
	}

	/**
	 * @return
	 */
	public String getLoaiCuocTtktQuyetDinh() {
		return loaiCuocTtktQuyetDinh;
	}

	/**
	 * @param string
	 */
	public void setLoaiCuocTtktKeHoachNam(String string) {
		loaiCuocTtktKeHoachNam = string;
	}

	/**
	 * @param string
	 */
	public void setLoaiCuocTtktQuyetDinh(String string) {
		loaiCuocTtktQuyetDinh = string;
	}

	/**
	 * @return
	 */
	public String getIdCuocKhCu() {
		return idCuocKhCu;
	}

	/**
	 * @return
	 */
	public String getIdCuocKhMoi() {
		return idCuocKhMoi;
	}

	/**
	 * @return
	 */
	public String getIdCuocQdCu() {
		return idCuocQdCu;
	}

	/**
	 * @return
	 */
	public String getIdCuocQdMoi() {
		return idCuocQdMoi;
	}

	/**
	 * @param string
	 */
	public void setIdCuocKhCu(String string) {
		idCuocKhCu = string;
	}

	/**
	 * @param string
	 */
	public void setIdCuocKhMoi(String string) {
		idCuocKhMoi = string;
	}

	/**
	 * @param string
	 */
	public void setIdCuocQdCu(String string) {
		idCuocQdCu = string;
	}

	/**
	 * @param string
	 */
	public void setIdCuocQdMoi(String string) {
		idCuocQdMoi = string;
	}

	public String getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(String maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public String getDonVer() {
		return donVer;
	}

	public void setDonVer(String donVer) {
		this.donVer = donVer;
	}

}