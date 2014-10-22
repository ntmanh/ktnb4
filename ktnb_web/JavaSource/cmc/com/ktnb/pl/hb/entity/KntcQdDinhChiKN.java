package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;

import cmc.com.ktnb.util.Formater;

public class KntcQdDinhChiKN extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
	//Fields    
	private String id;

	private String soQuyetDinh;
	private Date ngayBanHanh;
	private String diaDiem;
	private String nguoiDeNghi;
	private String nguoiQdTen;
	private String nguoiQdChucVu;
	private String lyDo;
	private String cqThiHanh;
	private String soHoSo;
	private String ngayBanHanhStr;

	// Constructors

	/** default constructor */
	public KntcQdDinhChiKN() {
	}

	/** minimal constructor */
	public KntcQdDinhChiKN(String id) {
		this.id = id;
	}

	/** full constructor */
	public KntcQdDinhChiKN(String id, String soQuyetDinh, Date ngayBanHanh, String diaDiem, String nguoiDeNghi, String nguoiQdTen, String nguoiQdChucVu, String lyDo, String cqThiHanh) {
		this.id = id;
		this.diaDiem = diaDiem;
		this.soQuyetDinh = soQuyetDinh;
		this.ngayBanHanh = ngayBanHanh;
		this.diaDiem = diaDiem;
		this.nguoiDeNghi = nguoiDeNghi;
		this.nguoiQdTen = nguoiQdTen;
		this.nguoiQdChucVu = nguoiQdChucVu;
		this.lyDo = lyDo;
		this.cqThiHanh = cqThiHanh;
	}
	// Property accessors

	public String getCqThiHanh() {
		return cqThiHanh;
	}

	public void setCqThiHanh(String cqThiHanh) {
		this.cqThiHanh = cqThiHanh;
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

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public Date getNgayBanHanh() {
		return ngayBanHanh;
	}

	public void setNgayBanHanh(Date ngayBanHanh) {
		this.ngayBanHanh = ngayBanHanh;
		this.ngayBanHanhStr=Formater.date2str(ngayBanHanh);
	}

	public String getNguoiDeNghi() {
		return nguoiDeNghi;
	}

	public void setNguoiDeNghi(String nguoiDeNghi) {
		this.nguoiDeNghi = nguoiDeNghi;
	}

	public String getNguoiQdChucVu() {
		return nguoiQdChucVu;
	}

	public void setNguoiQdChucVu(String nguoiQdChucVu) {
		this.nguoiQdChucVu = nguoiQdChucVu;
	}

	public String getNguoiQdTen() {
		return nguoiQdTen;
	}

	public void setNguoiQdTen(String nguoiQdTen) {
		this.nguoiQdTen = nguoiQdTen;
	}

	public String getSoQuyetDinh() {
		return soQuyetDinh;
	}

	public void setSoQuyetDinh(String soQuyetDinh) {
		this.soQuyetDinh = soQuyetDinh;
	}

	public String getSoHoSo() {
		return soHoSo;
	}

	public void setSoHoSo(String soHoSo) {
		this.soHoSo = soHoSo;
	}

	public String getNgayBanHanhStr() {
		return ngayBanHanhStr;
	}

	public void setNgayBanHanhStr(String ngayBanHanhStr) throws Exception {
		this.ngayBanHanhStr = ngayBanHanhStr;
		this.ngayBanHanh=Formater.str2date(ngayBanHanhStr);
	}
	
	
}
