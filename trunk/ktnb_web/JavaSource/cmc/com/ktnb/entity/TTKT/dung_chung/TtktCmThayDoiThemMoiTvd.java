package cmc.com.ktnb.entity.TTKT.dung_chung;

import java.util.HashSet;
import java.util.Set;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * TtktCmThayDoiThemMoiTvd entity. @author MyEclipse Persistence Tools
 */

public class TtktCmThayDoiThemMoiTvd extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	
	private String idThanhVienCu;
	private String tenThanhVienCu;
	private String chucVuThanhVienCu;
	private String idThanhVienMoi;
	private String tenThanhVienMoi;
	private String chucVuThanhVienMoi;
	private String chucVuTrongDoanThanhVienMoi;
	private String loaiThayDoi;
	private String donViCongTacTvCu;
	private String donViCongTacTvMoi;
	private String danhSachThayDoi;
	private String idThayDoiTvd;
	
	
	
	// static fields
	public static final String DanhSachThayDoi = "danhSachThayDoi";
	
	// Constructors

	/** default constructor */
	public TtktCmThayDoiThemMoiTvd() {
	}

	/** minimal constructor */
	public TtktCmThayDoiThemMoiTvd(String id,
			String idThanhVienMoi,
			String tenThanhVienMoi, String chucVuThanhVienMoi,
			String loaiThayDoi) {
		this.id = id;
		this.idThanhVienMoi = idThanhVienMoi;
		this.tenThanhVienMoi = tenThanhVienMoi;
		this.chucVuThanhVienMoi = chucVuThanhVienMoi;
		this.loaiThayDoi = loaiThayDoi;
	}

	/** full constructor */
	public TtktCmThayDoiThemMoiTvd(String id,
			TtktCmThayDoiTvd ttktCmThayDoiTvd, String idThanhVienCu,
			String tenThanhVienCu, String chucVuThanhVienCu,
			String idThanhVienMoi, String tenThanhVienMoi,
			String chucVuThanhVienMoi, String loaiThayDoi) {
		this.id = id;
		this.idThanhVienCu = idThanhVienCu;
		this.tenThanhVienCu = tenThanhVienCu;
		this.chucVuThanhVienCu = chucVuThanhVienCu;
		this.idThanhVienMoi = idThanhVienMoi;
		this.tenThanhVienMoi = tenThanhVienMoi;
		this.chucVuThanhVienMoi = chucVuThanhVienMoi;
		this.loaiThayDoi = loaiThayDoi;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getIdThanhVienCu() {
		return this.idThanhVienCu;
	}

	public void setIdThanhVienCu(String idThanhVienCu) {
		this.idThanhVienCu = idThanhVienCu;
	}

	public String getTenThanhVienCu() {
		return this.tenThanhVienCu;
	}

	public void setTenThanhVienCu(String tenThanhVienCu) {
		this.tenThanhVienCu = tenThanhVienCu;
	}

	public String getChucVuThanhVienCu() {
		return this.chucVuThanhVienCu;
	}

	public void setChucVuThanhVienCu(String chucVuThanhVienCu) {
		this.chucVuThanhVienCu = chucVuThanhVienCu;
	}

	public String getIdThanhVienMoi() {
		return this.idThanhVienMoi;
	}

	public void setIdThanhVienMoi(String idThanhVienMoi) {
		this.idThanhVienMoi = idThanhVienMoi;
	}

	public String getTenThanhVienMoi() {
		return this.tenThanhVienMoi;
	}

	public void setTenThanhVienMoi(String tenThanhVienMoi) {
		this.tenThanhVienMoi = tenThanhVienMoi;
	}

	public String getChucVuThanhVienMoi() {
		return this.chucVuThanhVienMoi;
	}

	public void setChucVuThanhVienMoi(String chucVuThanhVienMoi) {
		this.chucVuThanhVienMoi = chucVuThanhVienMoi;
	}

	public String getLoaiThayDoi() {
		return this.loaiThayDoi;
	}

	public void setLoaiThayDoi(String loaiThayDoi) {
		this.loaiThayDoi = loaiThayDoi;
	}

	/**
	 * @return
	 */
	public String getDonViCongTacTvCu() {
		return donViCongTacTvCu;
	}

	/**
	 * @return
	 */
	public String getDonViCongTacTvMoi() {
		return donViCongTacTvMoi;
	}

	/**
	 * @param string
	 */
	public void setDonViCongTacTvCu(String string) {
		donViCongTacTvCu = string;
	}

	/**
	 * @param string
	 */
	public void setDonViCongTacTvMoi(String string) {
		donViCongTacTvMoi = string;
	}

	/**
	 * @return
	 */
	public String getDanhSachThayDoi() {
		return danhSachThayDoi;
	}

	/**
	 * @param string
	 */
	public void setDanhSachThayDoi(String string) {
		danhSachThayDoi = string;
	}
	
	/**
	 * @return
	 */
	public String getIdThayDoiTvd() {
		return idThayDoiTvd;
	}

	/**
	 * @param string
	 */
	public void setIdThayDoiTvd(String string) {
		idThayDoiTvd = string;
	}

	/**
	 * @return
	 */
	public String getChucVuTrongDoanThanhVienMoi() {
		return chucVuTrongDoanThanhVienMoi;
	}

	/**
	 * @param string
	 */
	public void setChucVuTrongDoanThanhVienMoi(String string) {
		chucVuTrongDoanThanhVienMoi = string;
	}

}