package cmc.com.ktnb.entity.TTKT.ket_thuc_ttkt;

import java.util.Date;

/**
 * TtktKtChuyenGiaoHsVv entity. @author MyEclipse Persistence Tools
 */

public class TtktKtChuyenGiaoHsVv implements java.io.Serializable {

	// Fields

	private String id;
	private String idCuocTtkt;
	private String diaDiemLapHs;
	private Date thoiGian;
	private String soHs;
	private String tenCqDieuTra;
	private String tomTatHanhViViPham;
	private String hanhViViPham;
	private String chucDanhNguoiKy;
	private Date thoiGianGiaoNhan;
	private String diaDiem;
	private String tpThamDuDoanTtkt;
	private String tpThamDuCqDieuTra;
	private Short soTrang;
	private String baoGomCacTl;
	private Date thoiDiemKetThuc;

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
	public TtktKtChuyenGiaoHsVv() {
	}

	/** minimal constructor */
	public TtktKtChuyenGiaoHsVv(String id, String idCuocTtkt,
			String diaDiemLapHs, Date thoiGian, String soHs,
			String tenCqDieuTra, String chucDanhNguoiKy, Date thoiGianGiaoNhan,
			String diaDiem, String tpThamDuDoanTtkt, String tpThamDuCqDieuTra,
			Short soTrang, String baoGomCacTl, Date thoiDiemKetThuc) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.diaDiemLapHs = diaDiemLapHs;
		this.thoiGian = thoiGian;
		this.soHs = soHs;
		this.tenCqDieuTra = tenCqDieuTra;
		this.chucDanhNguoiKy = chucDanhNguoiKy;
		this.thoiGianGiaoNhan = thoiGianGiaoNhan;
		this.diaDiem = diaDiem;
		this.tpThamDuDoanTtkt = tpThamDuDoanTtkt;
		this.tpThamDuCqDieuTra = tpThamDuCqDieuTra;
		this.soTrang = soTrang;
		this.baoGomCacTl = baoGomCacTl;
		this.thoiDiemKetThuc = thoiDiemKetThuc;
	}

	/** full constructor */
	public TtktKtChuyenGiaoHsVv(String id, String idCuocTtkt,
			String diaDiemLapHs, Date thoiGian, String soHs,
			String tenCqDieuTra, String tomTatHanhViViPham,
			String hanhViViPham, String chucDanhNguoiKy, Date thoiGianGiaoNhan,
			String diaDiem, String tpThamDuDoanTtkt, String tpThamDuCqDieuTra,
			Short soTrang, String baoGomCacTl, Date thoiDiemKetThuc) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.diaDiemLapHs = diaDiemLapHs;
		this.thoiGian = thoiGian;
		this.soHs = soHs;
		this.tenCqDieuTra = tenCqDieuTra;
		this.tomTatHanhViViPham = tomTatHanhViViPham;
		this.hanhViViPham = hanhViViPham;
		this.chucDanhNguoiKy = chucDanhNguoiKy;
		this.thoiGianGiaoNhan = thoiGianGiaoNhan;
		this.diaDiem = diaDiem;
		this.tpThamDuDoanTtkt = tpThamDuDoanTtkt;
		this.tpThamDuCqDieuTra = tpThamDuCqDieuTra;
		this.soTrang = soTrang;
		this.baoGomCacTl = baoGomCacTl;
		this.thoiDiemKetThuc = thoiDiemKetThuc;
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

	public String getDiaDiemLapHs() {
		return this.diaDiemLapHs;
	}

	public void setDiaDiemLapHs(String diaDiemLapHs) {
		this.diaDiemLapHs = diaDiemLapHs;
	}

	public Date getThoiGian() {
		return this.thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getSoHs() {
		return this.soHs;
	}

	public void setSoHs(String soHs) {
		this.soHs = soHs;
	}

	public String getTenCqDieuTra() {
		return this.tenCqDieuTra;
	}

	public void setTenCqDieuTra(String tenCqDieuTra) {
		this.tenCqDieuTra = tenCqDieuTra;
	}

	public String getTomTatHanhViViPham() {
		return this.tomTatHanhViViPham;
	}

	public void setTomTatHanhViViPham(String tomTatHanhViViPham) {
		this.tomTatHanhViViPham = tomTatHanhViViPham;
	}

	public String getHanhViViPham() {
		return this.hanhViViPham;
	}

	public void setHanhViViPham(String hanhViViPham) {
		this.hanhViViPham = hanhViViPham;
	}

	public String getChucDanhNguoiKy() {
		return this.chucDanhNguoiKy;
	}

	public void setChucDanhNguoiKy(String chucDanhNguoiKy) {
		this.chucDanhNguoiKy = chucDanhNguoiKy;
	}

	public Date getThoiGianGiaoNhan() {
		return this.thoiGianGiaoNhan;
	}

	public void setThoiGianGiaoNhan(Date thoiGianGiaoNhan) {
		this.thoiGianGiaoNhan = thoiGianGiaoNhan;
	}

	public String getDiaDiem() {
		return this.diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getTpThamDuDoanTtkt() {
		return this.tpThamDuDoanTtkt;
	}

	public void setTpThamDuDoanTtkt(String tpThamDuDoanTtkt) {
		this.tpThamDuDoanTtkt = tpThamDuDoanTtkt;
	}

	public String getTpThamDuCqDieuTra() {
		return this.tpThamDuCqDieuTra;
	}

	public void setTpThamDuCqDieuTra(String tpThamDuCqDieuTra) {
		this.tpThamDuCqDieuTra = tpThamDuCqDieuTra;
	}

	public Short getSoTrang() {
		return this.soTrang;
	}

	public void setSoTrang(Short soTrang) {
		this.soTrang = soTrang;
	}

	public String getBaoGomCacTl() {
		return this.baoGomCacTl;
	}

	public void setBaoGomCacTl(String baoGomCacTl) {
		this.baoGomCacTl = baoGomCacTl;
	}

	public Date getThoiDiemKetThuc() {
		return this.thoiDiemKetThuc;
	}

	public void setThoiDiemKetThuc(Date thoiDiemKetThuc) {
		this.thoiDiemKetThuc = thoiDiemKetThuc;
	}

}