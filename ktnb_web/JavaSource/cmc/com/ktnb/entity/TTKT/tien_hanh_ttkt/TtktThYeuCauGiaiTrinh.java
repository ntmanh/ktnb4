package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;

import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;
/**
 * TtktThYeuCauGiaiTrinh entity. @author MyEclipse Persistence Tools
 */

public class TtktThYeuCauGiaiTrinh extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idCuocTtkt;
	private Date ngayLapPhieu;
	private String noiLapPhieu;
	private String idNguoiGiaiTrinh;
	private String tenNguoiGiaiTrinh;
	private Date namSinhNguoiGiaiTrinh;
	private String dvCongTacNguoiGiaiTrinh;
	private String noiDungGiaiTrinh;
	private Date thoiGianGuiGiaiTrinh;
	private String noiGuiGiaiTrinh;
	private String diaDiemBaoCaoGiaiTrinh;
	private Date thoiGianBaoCaoGiaiTrinh;
	private String noiDungBaoCaoGiaiTrinh;
	private String fileBaoCaoGiaiTrinh;
	private String hoSoBaoCao;
	private String chucVuNgGT;
	public static String IdCuocTtkt = "idCuocTtkt";
	public static String Id = "id";
	
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
	public TtktThYeuCauGiaiTrinh() {
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

	public Date getNgayLapPhieu() {
		return this.ngayLapPhieu;
	}

	public void setNgayLapPhieu(Date ngayLapPhieu) {
		this.ngayLapPhieu = ngayLapPhieu;
	}

	public String getNoiLapPhieu() {
		return this.noiLapPhieu;
	}

	public void setNoiLapPhieu(String noiLapPhieu) {
		this.noiLapPhieu = noiLapPhieu;
	}

	public String getIdNguoiGiaiTrinh() {
		return this.idNguoiGiaiTrinh;
	}

	public void setIdNguoiGiaiTrinh(String idNguoiGiaiTrinh) {
		this.idNguoiGiaiTrinh = idNguoiGiaiTrinh;
	}

	public String getTenNguoiGiaiTrinh() {
		return this.tenNguoiGiaiTrinh;
	}

	public void setTenNguoiGiaiTrinh(String tenNguoiGiaiTrinh) {
		this.tenNguoiGiaiTrinh = tenNguoiGiaiTrinh;
	}

	public Date getNamSinhNguoiGiaiTrinh() {
		return this.namSinhNguoiGiaiTrinh;
	}

	public void setNamSinhNguoiGiaiTrinh(Date namSinhNguoiGiaiTrinh) {
		this.namSinhNguoiGiaiTrinh = namSinhNguoiGiaiTrinh;
	}

	public String getDvCongTacNguoiGiaiTrinh() {
		return this.dvCongTacNguoiGiaiTrinh;
	}

	public void setDvCongTacNguoiGiaiTrinh(String dvCongTacNguoiGiaiTrinh) {
		this.dvCongTacNguoiGiaiTrinh = dvCongTacNguoiGiaiTrinh;
	}

	public String getNoiDungGiaiTrinh() {
		return this.noiDungGiaiTrinh;
	}

	public void setNoiDungGiaiTrinh(String noiDungGiaiTrinh) {
		this.noiDungGiaiTrinh = noiDungGiaiTrinh;
	}

	public Date getThoiGianGuiGiaiTrinh() {
		return this.thoiGianGuiGiaiTrinh;
	}

	public void setThoiGianGuiGiaiTrinh(Date thoiGianGuiGiaiTrinh) {
		this.thoiGianGuiGiaiTrinh = thoiGianGuiGiaiTrinh;
	}

	public String getNoiGuiGiaiTrinh() {
		return this.noiGuiGiaiTrinh;
	}

	public void setNoiGuiGiaiTrinh(String noiGuiGiaiTrinh) {
		this.noiGuiGiaiTrinh = noiGuiGiaiTrinh;
	}

	public String getDiaDiemBaoCaoGiaiTrinh() {
		return this.diaDiemBaoCaoGiaiTrinh;
	}

	public void setDiaDiemBaoCaoGiaiTrinh(String diaDiemBaoCaoGiaiTrinh) {
		this.diaDiemBaoCaoGiaiTrinh = diaDiemBaoCaoGiaiTrinh;
	}

	public Date getThoiGianBaoCaoGiaiTrinh() {
		return this.thoiGianBaoCaoGiaiTrinh;
	}

	public void setThoiGianBaoCaoGiaiTrinh(Date thoiGianBaoCaoGiaiTrinh) {
		this.thoiGianBaoCaoGiaiTrinh = thoiGianBaoCaoGiaiTrinh;
	}

	public String getNoiDungBaoCaoGiaiTrinh() {
		return this.noiDungBaoCaoGiaiTrinh;
	}

	public void setNoiDungBaoCaoGiaiTrinh(String noiDungBaoCaoGiaiTrinh) {
		this.noiDungBaoCaoGiaiTrinh = noiDungBaoCaoGiaiTrinh;
	}

	public String getFileBaoCaoGiaiTrinh() {
		return this.fileBaoCaoGiaiTrinh;
	}

	public void setFileBaoCaoGiaiTrinh(String fileBaoCaoGiaiTrinh) {
		this.fileBaoCaoGiaiTrinh = fileBaoCaoGiaiTrinh;
	}




	public String getHoSoBaoCao() {
		return hoSoBaoCao;
	}




	public void setHoSoBaoCao(String hoSoBaoCao) {
		this.hoSoBaoCao = hoSoBaoCao;
	}




	public String getChucVuNgGT() {
		return chucVuNgGT;
	}




	public void setChucVuNgGT(String chucVuNgGT) {
		this.chucVuNgGT = chucVuNgGT;
	}

}