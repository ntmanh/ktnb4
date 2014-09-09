package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KntcBienBan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Ttcp2b extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
	private TtcpBaoCaoId id;
	private Long tnTongSo;
	private Long tnTkNhieuNguoi;
	private Long tnTrongKyMotNguoi;
	private Long tnKtNhieuNguoi;
	private Long tnKtMotNguoi;
	private Long tnDuDkXly;
	private Long ndKnHcTong;
	private Long ndKnHcTaiSan;
	private Long ndKnHcChinhSach;
	private Long ndKnKhac;
	private Long ndKnDang;
	private Long ndTcTong;
	private Long ndTcHc;
	private Long ndTcThamNhung;
	private Long ndTcDang;
	private Long ndTcKhac;
	private Long tqCqHanhChinh;
	private Long tqCqDang;
	private Long ttgqChuaGq;
	private Long ttgqDaGqLanDau;
	private Long ttgqDaGqNhieuLan;
	private Long donKhac;
	private Long kqSoVanBan;
	private Long kqSoChuyenCq;
	private Long kqSoCvDonDoc;
	private Long kqThuocTqKn;
	private Long kqThuocTqTc;
	
	private Date ngayCuoiThang;
	public Ttcp2b() {
		// TODO Auto-generated constructor stub
	}
	public TtcpBaoCaoId getId() {
		return id;
	}
	public void setId(TtcpBaoCaoId id) {
		this.id = id;
	}
	
	public Date getNgayCuoiThang() {
		return ngayCuoiThang;
	}
	public void setNgayCuoiThang(Date ngayCuoiThang) {
		this.ngayCuoiThang = ngayCuoiThang;
	}
	public Long getDonKhac() {
		return donKhac;
	}
	public void setDonKhac(Long donKhac) {
		this.donKhac = donKhac;
	}
	public Long getKqSoChuyenCq() {
		return kqSoChuyenCq;
	}
	public void setKqSoChuyenCq(Long kqSoChuyenCq) {
		this.kqSoChuyenCq = kqSoChuyenCq;
	}
	public Long getKqSoCvDonDoc() {
		return kqSoCvDonDoc;
	}
	public void setKqSoCvDonDoc(Long kqSoCvDonDoc) {
		this.kqSoCvDonDoc = kqSoCvDonDoc;
	}
	public Long getKqSoVanBan() {
		return kqSoVanBan;
	}
	public void setKqSoVanBan(Long kqSoVanBan) {
		this.kqSoVanBan = kqSoVanBan;
	}
	public Long getKqThuocTqKn() {
		return kqThuocTqKn;
	}
	public void setKqThuocTqKn(Long kqThuocTqKn) {
		this.kqThuocTqKn = kqThuocTqKn;
	}
	public Long getKqThuocTqTc() {
		return kqThuocTqTc;
	}
	public void setKqThuocTqTc(Long kqThuocTqTc) {
		this.kqThuocTqTc = kqThuocTqTc;
	}
	public Long getNdKnDang() {
		return ndKnDang;
	}
	public void setNdKnDang(Long ndKnDang) {
		this.ndKnDang = ndKnDang;
	}
	public Long getNdKnHcChinhSach() {
		return ndKnHcChinhSach;
	}
	public void setNdKnHcChinhSach(Long ndKnHcChinhSach) {
		this.ndKnHcChinhSach = ndKnHcChinhSach;
	}
	public Long getNdKnHcTaiSan() {
		return ndKnHcTaiSan;
	}
	public void setNdKnHcTaiSan(Long ndKnHcTaiSan) {
		this.ndKnHcTaiSan = ndKnHcTaiSan;
	}
	public Long getNdKnHcTong() {
		return ndKnHcTong;
	}
	public void setNdKnHcTong(Long ndKnHcTong) {
		this.ndKnHcTong = ndKnHcTong;
	}
	public Long getNdKnKhac() {
		return ndKnKhac;
	}
	public void setNdKnKhac(Long ndKnKhac) {
		this.ndKnKhac = ndKnKhac;
	}
	public Long getNdTcDang() {
		return ndTcDang;
	}
	public void setNdTcDang(Long ndTcDang) {
		this.ndTcDang = ndTcDang;
	}
	public Long getNdTcHc() {
		return ndTcHc;
	}
	public void setNdTcHc(Long ndTcHc) {
		this.ndTcHc = ndTcHc;
	}
	public Long getNdTcKhac() {
		return ndTcKhac;
	}
	public void setNdTcKhac(Long ndTcKhac) {
		this.ndTcKhac = ndTcKhac;
	}
	public Long getNdTcThamNhung() {
		return ndTcThamNhung;
	}
	public void setNdTcThamNhung(Long ndTcThamNhung) {
		this.ndTcThamNhung = ndTcThamNhung;
	}
	public Long getNdTcTong() {
		return ndTcTong;
	}
	public void setNdTcTong(Long ndTcTong) {
		this.ndTcTong = ndTcTong;
	}
	public Long getTnDuDkXly() {
		return tnDuDkXly;
	}
	public void setTnDuDkXly(Long tnDuDkXly) {
		this.tnDuDkXly = tnDuDkXly;
	}
	public Long getTnKtMotNguoi() {
		return tnKtMotNguoi;
	}
	public void setTnKtMotNguoi(Long tnKtMotNguoi) {
		this.tnKtMotNguoi = tnKtMotNguoi;
	}
	public Long getTnKtNhieuNguoi() {
		return tnKtNhieuNguoi;
	}
	public void setTnKtNhieuNguoi(Long tnKtNhieuNguoi) {
		this.tnKtNhieuNguoi = tnKtNhieuNguoi;
	}
	public Long getTnTkNhieuNguoi() {
		return tnTkNhieuNguoi;
	}
	public void setTnTkNhieuNguoi(Long tnTkNhieuNguoi) {
		this.tnTkNhieuNguoi = tnTkNhieuNguoi;
	}
	public Long getTnTongSo() {
		return tnTongSo;
	}
	public void setTnTongSo(Long tnTongSo) {
		this.tnTongSo = tnTongSo;
	}
	public Long getTnTrongKyMotNguoi() {
		return tnTrongKyMotNguoi;
	}
	public void setTnTrongKyMotNguoi(Long tnTrongKyMotNguoi) {
		this.tnTrongKyMotNguoi = tnTrongKyMotNguoi;
	}
	public Long getTqCqDang() {
		return tqCqDang;
	}
	public void setTqCqDang(Long tqCqDang) {
		this.tqCqDang = tqCqDang;
	}
	public Long getTqCqHanhChinh() {
		return tqCqHanhChinh;
	}
	public void setTqCqHanhChinh(Long tqCqHanhChinh) {
		this.tqCqHanhChinh = tqCqHanhChinh;
	}
	public Long getTtgqChuaGq() {
		return ttgqChuaGq;
	}
	public void setTtgqChuaGq(Long ttgqChuaGq) {
		this.ttgqChuaGq = ttgqChuaGq;
	}
	public Long getTtgqDaGqLanDau() {
		return ttgqDaGqLanDau;
	}
	public void setTtgqDaGqLanDau(Long ttgqDaGqLanDau) {
		this.ttgqDaGqLanDau = ttgqDaGqLanDau;
	}
	public Long getTtgqDaGqNhieuLan() {
		return ttgqDaGqNhieuLan;
	}
	public void setTtgqDaGqNhieuLan(Long ttgqDaGqNhieuLan) {
		this.ttgqDaGqNhieuLan = ttgqDaGqNhieuLan;
	}
	
}