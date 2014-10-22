package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

import cmc.com.ktnb.util.Formater;

public class KntcNoiDungTCTT extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
	//Fields    
	private String id;

	private String diaDiem;

	private Date thoiGianBatDau;

	private Date thoiGianKetThuc;

	private String cacBenLquan;

	private String ndungToCao;

	private String bangChungCc;

	private String yeuCauNtc;

	private String soHoSo;

	private Long soBanIn;
	
	private String thoiGianBatDauStr,thoiGianKetThucStr;

	// Constructors

	/** default constructor */
	public KntcNoiDungTCTT() {
	}

	/** minimal constructor */
	public KntcNoiDungTCTT(String id) {
		this.id = id;
	}

	/** full constructor */
	public KntcNoiDungTCTT(String id, String diaDiem, Date thoiGianBatDau, Date thoiGianKetThuc, String cacBenLquan, String ndungToCao, String bangChungCc, String yeuCauNtc, String soHoSo,
			Long soBanIn) {
		this.id = id;
		this.diaDiem = diaDiem;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.cacBenLquan = cacBenLquan;
		this.ndungToCao = ndungToCao;
		this.bangChungCc = bangChungCc;
		this.yeuCauNtc = yeuCauNtc;
		this.soHoSo = soHoSo;
		this.soBanIn = soBanIn;
	}
	// Property accessors

	public String getBangChungCc() {
		return bangChungCc;
	}

	public void setBangChungCc(String bangChungCc) {
		this.bangChungCc = bangChungCc;
	}

	public String getCacBenLquan() {
		return cacBenLquan;
	}

	public void setCacBenLquan(String cacBenLquan) {
		this.cacBenLquan = cacBenLquan;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNdungToCao() {
		return ndungToCao;
	}

	public void setNdungToCao(String ndungToCao) {
		this.ndungToCao = ndungToCao;
	}

	public Long getSoBanIn() {
		return soBanIn;
	}

	public void setSoBanIn(Long soBanIn) {
		this.soBanIn = soBanIn;
	}

	public String getSoHoSo() {
		return soHoSo;
	}

	public void setSoHoSo(String soHoSo) {
		this.soHoSo = soHoSo;
	}

	public Date getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Date thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianBatDauStr=Formater.date2strDateTimeForNV(thoiGianBatDau);
	}

	public Date getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.thoiGianKetThucStr=Formater.date2strDateTimeForNV(thoiGianKetThuc);
	}

	public String getYeuCauNtc() {
		return yeuCauNtc;
	}

	public void setYeuCauNtc(String yeuCauNtc) {
		this.yeuCauNtc = yeuCauNtc;
	}

	public String getThoiGianBatDauStr() {
		return thoiGianBatDauStr;
	}

	public void setThoiGianBatDauStr(String thoiGianBatDauStr) throws Exception {
		this.thoiGianBatDauStr = thoiGianBatDauStr;
		this.thoiGianBatDau=Formater.str2dateForNV(thoiGianBatDauStr);
	}

	public String getThoiGianKetThucStr() {
		return thoiGianKetThucStr;
	}

	public void setThoiGianKetThucStr(String thoiGianKetThucStr) throws Exception {
		this.thoiGianKetThucStr = thoiGianKetThucStr;
		this.thoiGianKetThuc=Formater.str2dateForNV(thoiGianKetThucStr);
	}
	
}
