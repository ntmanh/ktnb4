package cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh;

import java.util.Collection;
import java.util.Date;

import org.apache.struts.upload.FormFile;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

/**
 * KtnbCbDeCuong entity. @author MyEclipse Persistence Tools
 */

public class TtktCbDeCuong extends PersistentObject implements java.io.Serializable {

	// Fields

	private String id;
	private String idCuocTtkt;
	private String idDsTvd;
	private String noiLap;
	private Date ngayLap;
	private String nhungVanDeKhac;
	private String idBaoCaoPhaiCbiCungCap;
	private String idHstlPhaiCbiCungCap;
	private Collection baoCaoPhaiCbiCungCap;
	private Collection hstlPhaiCbiCungCap;
	
	private String baoCao;
	private String taiLieu;
	
	// Static fields
	public static final String IdCuocTtkt = "idCuocTtkt";
	public static final String IdDsTvd = "idDsTvd";
	
	private FormFile fileDinhKem;
	private String maFile;
	private String tenFile;
	private String loaiFile;
	private boolean haveFileAttack;

	
	private String idNguoiCapNat;
	private String tenNguoiCapNhat;
	private Date ngayCapNhat;
	// Constructors

	/** default constructor */
	public TtktCbDeCuong() {
	}

	/** minimal constructor */
	public TtktCbDeCuong(String id, String idCuocTtkt) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
	}

	/** full constructor */
	public TtktCbDeCuong(String id, String idCuocTtkt, String noiLap,
			Date ngayLap, String nhungVanDeKhac) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.noiLap = noiLap;
		this.ngayLap = ngayLap;
		this.nhungVanDeKhac = nhungVanDeKhac;
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

	public String getNoiLap() {
		return this.noiLap;
	}

	public void setNoiLap(String noiLap) {
		this.noiLap = noiLap;
	}

	public Date getNgayLap() {
		return this.ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getNhungVanDeKhac() {
		return this.nhungVanDeKhac;
	}

	public void setNhungVanDeKhac(String nhungVanDeKhac) {
		this.nhungVanDeKhac = nhungVanDeKhac;
	}	

	/**
	 * @return
	 */
	public Collection getBaoCaoPhaiCbiCungCap() {
		return baoCaoPhaiCbiCungCap;
	}

	/**
	 * @return
	 */
	public Collection getHstlPhaiCbiCungCap() {
		return hstlPhaiCbiCungCap;
	}

	/**
	 * @param collection
	 */
	public void setBaoCaoPhaiCbiCungCap(Collection collection) {
		baoCaoPhaiCbiCungCap = collection;
	}

	/**
	 * @param collection
	 */
	public void setHstlPhaiCbiCungCap(Collection collection) {
		hstlPhaiCbiCungCap = collection;
	}

	/**
	 * @return
	 */
	public String getIdBaoCaoPhaiCbiCungCap() {
		return idBaoCaoPhaiCbiCungCap;
	}

	/**
	 * @return
	 */
	public String getIdHstlPhaiCbiCungCap() {
		return idHstlPhaiCbiCungCap;
	}

	/**
	 * @param string
	 */
	public void setIdBaoCaoPhaiCbiCungCap(String string) {
		idBaoCaoPhaiCbiCungCap = string;
	}

	/**
	 * @param string
	 */
	public void setIdHstlPhaiCbiCungCap(String string) {
		idHstlPhaiCbiCungCap = string;
	}

	/**
	 * @return
	 */
	public String getIdDsTvd() {
		return idDsTvd;
	}

	/**
	 * @param string
	 */
	public void setIdDsTvd(String string) {
		idDsTvd = string;
	}

	public FormFile getFileDinhKem() {
		return fileDinhKem;
	}

	public void setFileDinhKem(FormFile fileDinhKem) {
		this.fileDinhKem = fileDinhKem;
	}

	public boolean isHaveFileAttack() {
		return haveFileAttack;
	}

	public void setHaveFileAttack(boolean haveFileAttack) {
		this.haveFileAttack = haveFileAttack;
	}

	public String getLoaiFile() {
		return loaiFile;
	}

	public void setLoaiFile(String loaiFile) {
		this.loaiFile = loaiFile;
	}

	public String getMaFile() {
		return maFile;
	}

	public void setMaFile(String maFile) {
		this.maFile = maFile;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

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

	public String getBaoCao() {
		return baoCao;
	}

	public void setBaoCao(String baoCao) {
		this.baoCao = baoCao;
	}

	public String getTaiLieu() {
		return taiLieu;
	}

	public void setTaiLieu(String taiLieu) {
		this.taiLieu = taiLieu;
	}

}