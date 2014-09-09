package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;

import java.util.Date;
import java.util.Collection;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktThPhucTra entity. @author MyEclipse Persistence Tools
 */

public class TtktThPhucTra extends PersistentObject implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private TtktThNoiDungPhucTra ttktThNoiDungPhucTra;
	private String idCuocTtkt;
	private String noiTrinh;
	private Date ngayTrinh;
	private String noiPheDuyet;
	private Date ngayPheDuyet;
	private String KienPheDuyet;
	private String soQd;
	private String noiRaQd;
	private Date ngayRaQd;
	private String vbQuyDinhCnangNvu;
	private String idCqtCanPhucTra;
	private String tenCqtCanPhucTra;
	private String diaDiemPhucTra;
	private String noiDungNghiVan;
	private String soQdTtktCanPhucTra;
	private Date ngayLap;
	private String chucDanhNguoiRaQd;
	private Date nienDoTuNgay;
	private Date nienDoDenNgay;
	private Byte thoiGian;
	private String dsCanBoThucHien;
	private String idPhucTra;
	private String thuTruongCqtThTtKt;
	private String idDsTvd;
	private String noiDungPhucTraNgoaiNganhThue;
	
	
	
	public String loaiND;
	public static String IdCuocTtkt = "idCuocTtkt";
	public static String Id = "id";
	
	
	public String tenNguoiDeNghiPT;
	public String cvNguoiDeNghiPT;
	public String cqNguoiDeNghiPT;
	public String idNguoiDeNghiPT;
	
	
	private Collection dsCbThucHien;
	private Collection dsNdPhucTra;
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

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



	public String getCqNguoiDeNghiPT() {
		return cqNguoiDeNghiPT;
	}



	public String getCvNguoiDeNghiPT() {
		return cvNguoiDeNghiPT;
	}



	public String getIdNguoiDeNghiPT() {
		return idNguoiDeNghiPT;
	}



	public String getTenNguoiDeNghiPT() {
		return tenNguoiDeNghiPT;
	}



	public void setCqNguoiDeNghiPT(String cqNguoiDeNghiPT) {
		this.cqNguoiDeNghiPT = cqNguoiDeNghiPT;
	}



	public void setCvNguoiDeNghiPT(String cvNguoiDeNghiPT) {
		this.cvNguoiDeNghiPT = cvNguoiDeNghiPT;
	}



	public void setIdNguoiDeNghiPT(String idNguoiDeNghiPT) {
		this.idNguoiDeNghiPT = idNguoiDeNghiPT;
	}



	public void setTenNguoiDeNghiPT(String tenNguoiDeNghiPT) {
		this.tenNguoiDeNghiPT = tenNguoiDeNghiPT;
	}



	public String getThuTruongCqtThTtKt() {
		return thuTruongCqtThTtKt;
	}



	public void setThuTruongCqtThTtKt(String thuTruongCqtThTtKt) {
		this.thuTruongCqtThTtKt = thuTruongCqtThTtKt;
	}



	public String getIdPhucTra() {
		return idPhucTra;
	}



	public void setIdPhucTra(String idPhucTra) {
		this.idPhucTra = idPhucTra;
	}



	/** default constructor */
	public TtktThPhucTra() {
	}



	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TtktThNoiDungPhucTra getTtktThNoiDungPhucTra() {
		return this.ttktThNoiDungPhucTra;
	}

	public void setTtktThNoiDungPhucTra(
			TtktThNoiDungPhucTra ttktThNoiDungPhucTra) {
		this.ttktThNoiDungPhucTra = ttktThNoiDungPhucTra;
	}

	public String getIdCuocTtkt() {
		return this.idCuocTtkt;
	}

	public void setIdCuocTtkt(String idCuocTtkt) {
		this.idCuocTtkt = idCuocTtkt;
	}

	public String getNoiTrinh() {
		return this.noiTrinh;
	}

	public void setNoiTrinh(String noiTrinh) {
		this.noiTrinh = noiTrinh;
	}

	public Date getNgayTrinh() {
		return this.ngayTrinh;
	}

	public void setNgayTrinh(Date ngayTrinh) {
		this.ngayTrinh = ngayTrinh;
	}

	public String getNoiPheDuyet() {
		return this.noiPheDuyet;
	}

	public void setNoiPheDuyet(String noiPheDuyet) {
		this.noiPheDuyet = noiPheDuyet;
	}

	public Date getNgayPheDuyet() {
		return this.ngayPheDuyet;
	}

	public void setNgayPheDuyet(Date ngayPheDuyet) {
		this.ngayPheDuyet = ngayPheDuyet;
	}

	public String getSoQd() {
		return this.soQd;
	}

	public void setSoQd(String soQd) {
		this.soQd = soQd;
	}

	public String getNoiRaQd() {
		return this.noiRaQd;
	}

	public void setNoiRaQd(String noiRaQd) {
		this.noiRaQd = noiRaQd;
	}

	public Date getNgayRaQd() {
		return this.ngayRaQd;
	}

	public void setNgayRaQd(Date ngayRaQd) {
		this.ngayRaQd = ngayRaQd;
	}

	public String getVbQuyDinhCnangNvu() {
		return this.vbQuyDinhCnangNvu;
	}

	public void setVbQuyDinhCnangNvu(String vbQuyDinhCnangNvu) {
		this.vbQuyDinhCnangNvu = vbQuyDinhCnangNvu;
	}

	public String getIdCqtCanPhucTra() {
		return this.idCqtCanPhucTra;
	}

	public void setIdCqtCanPhucTra(String idCqtCanPhucTra) {
		this.idCqtCanPhucTra = idCqtCanPhucTra;
	}

	public String getTenCqtCanPhucTra() {
		return this.tenCqtCanPhucTra;
	}

	public void setTenCqtCanPhucTra(String tenCqtCanPhucTra) {
		this.tenCqtCanPhucTra = tenCqtCanPhucTra;
	}

	public String getDiaDiemPhucTra() {
		return this.diaDiemPhucTra;
	}

	public void setDiaDiemPhucTra(String diaDiemPhucTra) {
		this.diaDiemPhucTra = diaDiemPhucTra;
	}

	public String getNoiDungNghiVan() {
		return this.noiDungNghiVan;
	}

	public void setNoiDungNghiVan(String noiDungNghiVan) {
		this.noiDungNghiVan = noiDungNghiVan;
	}

	public String getSoQdTtktCanPhucTra() {
		return this.soQdTtktCanPhucTra;
	}

	public void setSoQdTtktCanPhucTra(String soQdTtktCanPhucTra) {
		this.soQdTtktCanPhucTra = soQdTtktCanPhucTra;
	}

	public Date getNgayLap() {
		return this.ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getChucDanhNguoiRaQd() {
		return this.chucDanhNguoiRaQd;
	}

	public void setChucDanhNguoiRaQd(String chucDanhNguoiRaQd) {
		this.chucDanhNguoiRaQd = chucDanhNguoiRaQd;
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

	public Byte getThoiGian() {
		return this.thoiGian;
	}

	public void setThoiGian(Byte thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getDsCanBoThucHien() {
		return this.dsCanBoThucHien;
	}

	public void setDsCanBoThucHien(String dsCanBoThucHien) {
		this.dsCanBoThucHien = dsCanBoThucHien;
	}
	
	public Collection getDsCbThucHien() {
		return dsCbThucHien;
	}

	/**
	 * @param collection
	 */
	public void setDsCbThucHien(Collection collection) {
		dsCbThucHien = collection;
	}

	/**
	 * @return
	 */
	public Collection getDsNdPhucTra() {
		return dsNdPhucTra;
	}

	/**
	 * @param collection
	 */
	public void setDsNdPhucTra(Collection collection) {
		dsNdPhucTra = collection;
	}



	public String getKienPheDuyet() {
		return KienPheDuyet;
	}



	public void setKienPheDuyet(String kienPheDuyet) {
		KienPheDuyet = kienPheDuyet;
	}



	public String getLoaiND() {
		return loaiND;
	}



	public void setLoaiND(String loaiND) {
		this.loaiND = loaiND;
	}



	public String getIdDsTvd() {
		return idDsTvd;
	}



	public void setIdDsTvd(String idDsTvd) {
		this.idDsTvd = idDsTvd;
	}



	public String getNoiDungPhucTraNgoaiNganhThue() {
		return noiDungPhucTraNgoaiNganhThue;
	}



	public void setNoiDungPhucTraNgoaiNganhThue(String noiDungPhucTraNgoaiNganhThue) {
		this.noiDungPhucTraNgoaiNganhThue = noiDungPhucTraNgoaiNganhThue;
	}

}