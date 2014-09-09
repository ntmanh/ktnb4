package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;


import java.util.Date;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktThBanGiaoHstlChoTd entity. @author MyEclipse Persistence Tools
 */

public class TtktThBanGiaoHstlChoTd extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idCuocTtkt;
	private String idCanBo;
	private String tenCanBo;
	private String chucVu;
	private String chucVuTrongDoan;
	private Date thoiDiemBatDauBanGiao;
	private String thoiDiemBatDauBanGiaoStr;
	private Date thoiDiemKetThucBanGiao;
	private String thoiDiemKetThucBanGiaoStr;
	private String baoCao;
	private String hoSoTaiLieu;
	private String diaDiemBanGiao;

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
	public TtktThBanGiaoHstlChoTd() {
	}

	/** minimal constructor */
	public TtktThBanGiaoHstlChoTd(String id, String idCuocTtkt, String idCanBo,
			String tenCanBo, String chucVuTrongDoan,
			Date thoiDiemBatDauBanGiao, Date thoiDiemKetThucBanGiao) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.idCanBo = idCanBo;
		this.tenCanBo = tenCanBo;
		this.chucVuTrongDoan = chucVuTrongDoan;
		this.thoiDiemBatDauBanGiao = thoiDiemBatDauBanGiao;
		this.thoiDiemKetThucBanGiao = thoiDiemKetThucBanGiao;
	}

	/** full constructor */
	public TtktThBanGiaoHstlChoTd(String id, String idCuocTtkt, String idCanBo,
			String tenCanBo, String chucVu, String chucVuTrongDoan,
			Date thoiDiemBatDauBanGiao, Date thoiDiemKetThucBanGiao,
			String baoCao, String hoSoTaiLieu) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.idCanBo = idCanBo;
		this.tenCanBo = tenCanBo;
		this.chucVu = chucVu;
		this.chucVuTrongDoan = chucVuTrongDoan;
		this.thoiDiemBatDauBanGiao = thoiDiemBatDauBanGiao;
		this.thoiDiemKetThucBanGiao = thoiDiemKetThucBanGiao;
		this.baoCao = baoCao;
		this.hoSoTaiLieu = hoSoTaiLieu;
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

	public String getIdCanBo() {
		return this.idCanBo;
	}

	public void setIdCanBo(String idCanBo) {
		this.idCanBo = idCanBo;
	}

	public String getTenCanBo() {
		return this.tenCanBo;
	}

	public void setTenCanBo(String tenCanBo) {
		this.tenCanBo = tenCanBo;
	}

	public String getChucVu() {
		return this.chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getChucVuTrongDoan() {
		return this.chucVuTrongDoan;
	}

	public void setChucVuTrongDoan(String chucVuTrongDoan) {
		this.chucVuTrongDoan = chucVuTrongDoan;
	}

	public Date getThoiDiemBatDauBanGiao() {
		return this.thoiDiemBatDauBanGiao;
	}

	public void setThoiDiemBatDauBanGiao(Date thoiDiemBatDauBanGiao) {
		this.thoiDiemBatDauBanGiao = thoiDiemBatDauBanGiao;
	}

	public Date getThoiDiemKetThucBanGiao() {
		return this.thoiDiemKetThucBanGiao;
	}

	public void setThoiDiemKetThucBanGiao(Date thoiDiemKetThucBanGiao) {
		this.thoiDiemKetThucBanGiao = thoiDiemKetThucBanGiao;
	}

	public String getBaoCao() {
		return this.baoCao;
	}

	public void setBaoCao(String baoCao) {
		this.baoCao = baoCao;
	}

	public String getHoSoTaiLieu() {
		return this.hoSoTaiLieu;
	}

	public void setHoSoTaiLieu(String hoSoTaiLieu) {
		this.hoSoTaiLieu = hoSoTaiLieu;
	}

	/**
	 * @return
	 */
	public String getThoiDiemBatDauBanGiaoStr() {
		return thoiDiemBatDauBanGiaoStr;
	}

	/**
	 * @return
	 */
	public String getThoiDiemKetThucBanGiaoStr() {
		return thoiDiemKetThucBanGiaoStr;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemBatDauBanGiaoStr(String string) {
		thoiDiemBatDauBanGiaoStr = string;
	}

	/**
	 * @param string
	 */
	public void setThoiDiemKetThucBanGiaoStr(String string) {
		thoiDiemKetThucBanGiaoStr = string;
	}

	/**
	 * @return
	 */
	public String getDiaDiemBanGiao() {
		return diaDiemBanGiao;
	}

	/**
	 * @param string
	 */
	public void setDiaDiemBanGiao(String string) {
		diaDiemBanGiao = string;
	}

}