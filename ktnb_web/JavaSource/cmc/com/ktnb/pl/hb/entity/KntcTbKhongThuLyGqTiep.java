package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

import cmc.com.ktnb.util.Formater;

public class KntcTbKhongThuLyGqTiep extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
	
	//Fields
	private String id;
	
	private String soHoSo;
	
	private String soThongBao;
	
	private Date ngayLap;
	
	private String diaDiem;
	
	private String dviBanHanh;
	
	private String noiDung;
	
	private String lyDo;
	
	private String dviChuyenTiepBc;
	
	private String nguoiGqTheoThamQuyen;
	
	private Long soBanIn;
	private String ttVanBan;
	private String ngayLapStr;
	
	// Constructors
	public KntcTbKhongThuLyGqTiep(){
		
	}
	
	public KntcTbKhongThuLyGqTiep(String id)
	{
		this.id=id;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getDviBanHanh() {
		return dviBanHanh;
	}

	public void setDviBanHanh(String dviBanHanh) {
		this.dviBanHanh = dviBanHanh;
	}

	public String getDviChuyenTiepBc() {
		return dviChuyenTiepBc;
	}

	public void setDviChuyenTiepBc(String dviChuyenTiepBc) {
		this.dviChuyenTiepBc = dviChuyenTiepBc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
		this.ngayLapStr=Formater.date2str(ngayLap);
	}

	public String getNgayLapStr() {
		return ngayLapStr;
	}

	public void setNgayLapStr(String ngayLapStr) throws Exception {
		this.ngayLapStr = ngayLapStr;
		this.ngayLap=Formater.str2date(ngayLapStr);
	}

	public String getNguoiGqTheoThamQuyen() {
		return nguoiGqTheoThamQuyen;
	}

	public void setNguoiGqTheoThamQuyen(String nguoiGqTheoThamQuyen) {
		this.nguoiGqTheoThamQuyen = nguoiGqTheoThamQuyen;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
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

	public String getSoThongBao() {
		return soThongBao;
	}

	public void setSoThongBao(String soThongBao) {
		this.soThongBao = soThongBao;
	}

	public String getTtVanBan() {
		return ttVanBan;
	}

	public void setTtVanBan(String ttVanBan) {
		this.ttVanBan = ttVanBan;
	}
	
	// Property accessors
	
}
