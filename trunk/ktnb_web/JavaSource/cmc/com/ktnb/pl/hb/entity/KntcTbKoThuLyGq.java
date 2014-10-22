package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.web.CmcFormTag;

public class KntcTbKoThuLyGq extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
	
	// Fields
	public String id;
	public String soHoSo;
	public String soThongBao;
	public Date ngayLap;
	public String diaDiem;
	public String dviBanHanh;
	public String noiDungBcKoThuLy;
	public String lyDoApDungKoThuLy;
	public String donViChuyenBc;
	public String ngayLapStr; 
	
	//Constructors
	public KntcTbKoThuLyGq () {
		
	}
	
	public KntcTbKoThuLyGq (String id)
	{
		this.id=id;
	}
	
	// Property Access
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


	public String getDonViChuyenBc() {
		return donViChuyenBc;
	}

	public void setDonViChuyenBc(String donViChuyenBc) {
		this.donViChuyenBc = donViChuyenBc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLyDoApDungKoThuLy() {
		return lyDoApDungKoThuLy;
	}

	public void setLyDoApDungKoThuLy(String lyDoApDungKoThuLy) {
		this.lyDoApDungKoThuLy = lyDoApDungKoThuLy;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
		this.ngayLapStr=Formater.date2str(ngayLap);
	}

	public String getNoiDungBcKoThuLy() {
		return noiDungBcKoThuLy;
	}

	public void setNoiDungBcKoThuLy(String noiDungBcKoThuLy) {
		this.noiDungBcKoThuLy = noiDungBcKoThuLy;
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

	public String getNgayLapStr() {
		return ngayLapStr;
	}

	public void setNgayLapStr(String ngayLapStr) throws Exception {
		this.ngayLapStr = ngayLapStr;
		this.ngayLap=Formater.str2date(ngayLapStr);
	}
	
}
