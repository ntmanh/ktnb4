package cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh;

import java.util.Date;

import org.apache.struts.upload.FormFile;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * KtnbKhTtkt entity. @author MyEclipse Persistence Tools
 */

public class TtktCbKhTtkt extends PersistentObject implements java.io.Serializable{

	// Fields

	private String id;
	private String idCuocTtkt;
	private String diaDiemLap;
	private Date ngayLap;
	private String mucDich;
	private String ykienPheDuyetKh;
	private String yeuCau;
	private String noiDung;
	private String phuongPhapTienHanh;
	private String toChucThucHien;
	private String cheDoThongTinBaoCao;
	private String dieuKienVatChatDamBao;
	private String nhungDieuKienKhac;
	private String noiPheDuyet;
	private Date ngayPheDuyet;
	
	private FormFile fileDinhKem;
	private String maFile;
	private String tenFile;
	private String loaiFile;
	private boolean haveFileAttack;
	
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
	// Static field
	public static String IdCuocTtkt = "idCuocTtkt";
	// Constructors

	/** default constructor */
	public TtktCbKhTtkt() {
	}

	/** minimal constructor */
	public TtktCbKhTtkt(String id, String idCuocTtkt) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
	}

	/** full constructor */
	public TtktCbKhTtkt(String id, String idCuocTtkt, String diaDiemLap,
			Date ngayLap, String mucDich, String yeuCau, String noiDung,
			String phuongPhapTienHanh, String toChucThucHien,
			String cheDoThongTinBaoCao, String dieuKienVatChatDamBao,
			String nhungDieuKienKhac) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.diaDiemLap = diaDiemLap;
		this.ngayLap = ngayLap;
		this.mucDich = mucDich;
		this.yeuCau = yeuCau;
		this.noiDung = noiDung;
		this.phuongPhapTienHanh = phuongPhapTienHanh;
		this.toChucThucHien = toChucThucHien;
		this.cheDoThongTinBaoCao = cheDoThongTinBaoCao;
		this.dieuKienVatChatDamBao = dieuKienVatChatDamBao;
		this.nhungDieuKienKhac = nhungDieuKienKhac;
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

	public String getDiaDiemLap() {
		return this.diaDiemLap;
	}

	public void setDiaDiemLap(String diaDiemLap) {
		this.diaDiemLap = diaDiemLap;
	}

	public Date getNgayLap() {
		return this.ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getMucDich() {
		return this.mucDich;
	}

	public void setMucDich(String mucDich) {
		this.mucDich = mucDich;
	}

	public String getYeuCau() {
		return this.yeuCau;
	}

	public void setYeuCau(String yeuCau) {
		this.yeuCau = yeuCau;
	}

	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getPhuongPhapTienHanh() {
		return this.phuongPhapTienHanh;
	}

	public void setPhuongPhapTienHanh(String phuongPhapTienHanh) {
		this.phuongPhapTienHanh = phuongPhapTienHanh;
	}

	public String getToChucThucHien() {
		return this.toChucThucHien;
	}

	public void setToChucThucHien(String toChucThucHien) {
		this.toChucThucHien = toChucThucHien;
	}

	public String getCheDoThongTinBaoCao() {
		return this.cheDoThongTinBaoCao;
	}

	public void setCheDoThongTinBaoCao(String cheDoThongTinBaoCao) {
		this.cheDoThongTinBaoCao = cheDoThongTinBaoCao;
	}

	public String getDieuKienVatChatDamBao() {
		return this.dieuKienVatChatDamBao;
	}

	public void setDieuKienVatChatDamBao(String dieuKienVatChatDamBao) {
		this.dieuKienVatChatDamBao = dieuKienVatChatDamBao;
	}

	public String getNhungDieuKienKhac() {
		return this.nhungDieuKienKhac;
	}

	public void setNhungDieuKienKhac(String nhungDieuKienKhac) {
		this.nhungDieuKienKhac = nhungDieuKienKhac;
	}

	/**
	 * @return
	 */
	public Date getNgayPheDuyet() {
		return ngayPheDuyet;
	}

	/**
	 * @return
	 */
	public String getNoiPheDuyet() {
		return noiPheDuyet;
	}

	/**
	 * @param string
	 */
	public void setNgayPheDuyet(Date string) {
		ngayPheDuyet = string;
	}

	/**
	 * @param string
	 */
	public void setNoiPheDuyet(String string) {
		noiPheDuyet = string;
	}

	

	public FormFile getFileDinhKem() {
		return fileDinhKem;
	}

	public void setFileDinhKem(FormFile fileDinhKem) {
		this.fileDinhKem = fileDinhKem;
	}

	public String getMaFile() {
		return maFile;
	}

	public void setMaFile(String maFile) {
		this.maFile = maFile;
	}

	public String getLoaiFile() {
		return loaiFile;
	}

	public void setLoaiFile(String loaiFile) {
		this.loaiFile = loaiFile;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public boolean isHaveFileAttack() {
		return haveFileAttack;
	}

	public void setHaveFileAttack(boolean haveFileAttack) {
		this.haveFileAttack = haveFileAttack;
	}

	public String getYkienPheDuyetKh() {
		return ykienPheDuyetKh;
	}

	public void setYkienPheDuyetKh(String ykienPheDuyetKh) {
		this.ykienPheDuyetKh = ykienPheDuyetKh;
	}

	
	

}