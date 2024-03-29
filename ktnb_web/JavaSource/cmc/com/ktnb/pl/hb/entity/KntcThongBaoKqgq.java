package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

/**
 * KntcThongBaoKqgq generated by MyEclipse Persistence Tools
 */

public class KntcThongBaoKqgq extends
		cmc.com.ktnb.pl.hb.entity.PersistentObject implements
		java.io.Serializable {

	// Fields

	private String ma;

	private String maHs;

	private Date ngayLap;

	private String diaDiem;

	private String benLienQuan;

	private String ketQuaGq;

	private Date ngayTrinhKy;

	private Date ngayKy;

	private String YKienTrinh;

	private Date ngayTrinhDuyet;

	private Date ngayDuyet;

	private String YKienDuyet;

    private String SoThongBao;
	// Constructors

	/** default constructor */
	public KntcThongBaoKqgq() {
	}

	/** minimal constructor */
	public KntcThongBaoKqgq(String ma, String maHs) {
		this.ma = ma;
		this.maHs = maHs;
	}

	/** full constructor */
	public KntcThongBaoKqgq(String ma, String maHs, Date ngayLap,
			String diaDiem, String benLienQuan, String ketQuaGq,
			Date ngayTrinhKy, Date ngayKy, String YKienTrinh,
			Date ngayTrinhDuyet, Date ngayDuyet, String YKienDuyet) {
		this.ma = ma;
		this.maHs = maHs;
		this.ngayLap = ngayLap;
		this.diaDiem = diaDiem;
		this.benLienQuan = benLienQuan;
		this.ketQuaGq = ketQuaGq;
		this.ngayTrinhKy = ngayTrinhKy;
		this.ngayKy = ngayKy;
		this.YKienTrinh = YKienTrinh;
		this.ngayTrinhDuyet = ngayTrinhDuyet;
		this.ngayDuyet = ngayDuyet;
		this.YKienDuyet = YKienDuyet;
	}

	// Property accessors

	public String getMa() {
		return this.ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getMaHs() {
		return this.maHs;
	}

	public void setMaHs(String maHs) {
		this.maHs = maHs;
	}

	public Date getNgayLap() {
		return this.ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getDiaDiem() {
		return this.diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getBenLienQuan() {
		return this.benLienQuan;
	}

	public void setBenLienQuan(String benLienQuan) {
		this.benLienQuan = benLienQuan;
	}

	public String getKetQuaGq() {
		return this.ketQuaGq;
	}

	public void setKetQuaGq(String ketQuaGq) {
		this.ketQuaGq = ketQuaGq;
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

	public String getSoThongBao() {
		return SoThongBao;
	}

	public void setSoThongBao(String soThongBao) {
		SoThongBao = soThongBao;
	}

}