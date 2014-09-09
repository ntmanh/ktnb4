package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KntcKquaGquyetHdr entity. @author MyEclipse Persistence Tools
 */

public class KntcKquaGquyetHdr extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {

	// Fields    

	private String ma;
	private String maQd;
	private Date ngayTrinhKy;
	private Date ngayKy;
	private String YKienTrinh;
	private Date ngayTrinhDuyet;
	private Date ngayDuyet;
	private String YKienDuyet;
	private Date ngayCapNhat;
	private String nguoiCapNhat;
	private String diaDiem;
	private Date ngayLap;
	private String noiDungKn;
	private String quyetDinhHc;
	private String ketQuaXm;
	private String kienNghi;
	private String maHs;

	// Constructors

	/** default constructor */
	public KntcKquaGquyetHdr() {
	}

	/** minimal constructor */
	public KntcKquaGquyetHdr(String ma, String maHs) {
		this.ma = ma;
		this.maHs = maHs;
	}

	// Property accessors

	public String getMa() {
		return this.ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getMaQd() {
		return this.maQd;
	}

	public void setMaQd(String maQd) {
		this.maQd = maQd;
	}

	public Date getNgayTrinhKy() {
		return this.ngayTrinhKy;
	}

	public void setNgayTrinhKy(Date ngayTrinhKy) {
		this.ngayTrinhKy = ngayTrinhKy;
	}

	public Date getNgayKy() {
		return this.ngayKy;
	}

	public void setNgayKy(Date ngayKy) {
		this.ngayKy = ngayKy;
	}

	public String getYKienTrinh() {
		return this.YKienTrinh;
	}

	public void setYKienTrinh(String YKienTrinh) {
		this.YKienTrinh = YKienTrinh;
	}

	public Date getNgayTrinhDuyet() {
		return this.ngayTrinhDuyet;
	}

	public void setNgayTrinhDuyet(Date ngayTrinhDuyet) {
		this.ngayTrinhDuyet = ngayTrinhDuyet;
	}

	public Date getNgayDuyet() {
		return this.ngayDuyet;
	}

	public void setNgayDuyet(Date ngayDuyet) {
		this.ngayDuyet = ngayDuyet;
	}

	public String getYKienDuyet() {
		return this.YKienDuyet;
	}

	public void setYKienDuyet(String YKienDuyet) {
		this.YKienDuyet = YKienDuyet;
	}

	public Date getNgayCapNhat() {
		return this.ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public String getNguoiCapNhat() {
		return this.nguoiCapNhat;
	}

	public void setNguoiCapNhat(String nguoiCapNhat) {
		this.nguoiCapNhat = nguoiCapNhat;
	}

	public String getDiaDiem() {
		return this.diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public Date getNgayLap() {
		return this.ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getNoiDungKn() {
		return this.noiDungKn;
	}

	public void setNoiDungKn(String noiDungKn) {
		this.noiDungKn = noiDungKn;
	}

	public String getQuyetDinhHc() {
		return this.quyetDinhHc;
	}

	public void setQuyetDinhHc(String quyetDinhHc) {
		this.quyetDinhHc = quyetDinhHc;
	}

	public String getMaHs() {
		return this.maHs;
	}

	public void setMaHs(String maHs) {
		this.maHs = maHs;
	}

	/**
	 * @return
	 */
	public String getKetQuaXm() {
		return ketQuaXm;
	}

	/**
	 * @return
	 */
	public String getKienNghi() {
		return kienNghi;
	}

	/**
	 * @param string
	 */
	public void setKetQuaXm(String string) {
		ketQuaXm = string;
	}

	/**
	 * @param string
	 */
	public void setKienNghi(String string) {
		kienNghi = string;
	}

}