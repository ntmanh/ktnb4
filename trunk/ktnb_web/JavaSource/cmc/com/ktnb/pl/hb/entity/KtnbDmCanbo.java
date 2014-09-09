package cmc.com.ktnb.pl.hb.entity;

import java.util.Date;
public class KtnbDmCanbo extends cmc.com.ktnb.pl.hb.entity.PersistentObject implements java.io.Serializable {
	private String ma;
	private String ten;
	private String maPhong;
	private Date ngayHlucTu;
	private Date ngayHlucDen;
	//	ntdung bo sung
	private String tenPhong;
	private String maCqt;
	private String tenCqt;	
	private String maChucVu;
	private String tenChucVu;
	private String chucVu;

	public static String Ma = "ma";
	public static String Ten = "ten";
	public static String MaPhong = "maPhong";
	public static String TenPhong = "tenPhong";
	public static String MaCqt = "maCqt";
	public static String TenCqt = "tenCqt";
	public static String MaChucVu = "maChucVu";
	public static String TenChucVu = "tenChucVu";
	

	public KtnbDmCanbo() {
	}

	/** minimal constructor */
	public KtnbDmCanbo(String ma) {
		this.ma = ma;
	}

	/** full constructor */
	public KtnbDmCanbo(String ma, String ten, String maPhong, Date ngayHlucTu, Date ngayHlucDen) {
		this.ma = ma;
		this.ten = ten;
		this.maPhong = maPhong;
		this.ngayHlucTu = ngayHlucTu;
		this.ngayHlucDen = ngayHlucDen;
	}

	// Property accessors

	public String getMa() {
		return this.ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMaPhong() {
		return this.maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public Date getNgayHlucTu() {
		return this.ngayHlucTu;
	}

	public void setNgayHlucTu(Date ngayHlucTu) {
		this.ngayHlucTu = ngayHlucTu;
	}

	public Date getNgayHlucDen() {
		return this.ngayHlucDen;
	}

	public void setNgayHlucDen(Date ngayHlucDen) {
		this.ngayHlucDen = ngayHlucDen;
	}

	/**
	 * @return
	 */
	public String getMaCqt() {
		return maCqt;
	}

	/**
	 * @return
	 */
	public String getTenCqt() {
		return tenCqt;
	}

	/**
	 * @return
	 */
	public String getTenPhong() {
		return tenPhong;
	}

	/**
	 * @param string
	 */
	public void setMaCqt(String string) {
		maCqt = string;
	}

	/**
	 * @param string
	 */
	public void setTenCqt(String string) {
		tenCqt = string;
	}

	/**
	 * @param string
	 */
	public void setTenPhong(String string) {
		tenPhong = string;
	}

	

	/**
	 * @return
	 */
	public String getMaChucVu() {
		return maChucVu;
	}

	/**
	 * @return
	 */
	public String getTenChucVu() {
		return tenChucVu;
	}

	/**
	 * @param string
	 */
	public void setMaChucVu(String string) {
		maChucVu = string;
	}

	/**
	 * @param string
	 */
	public void setTenChucVu(String string) {
		tenChucVu = string;
	}

	/**
	 * @return
	 */
	public String getChucVu() {
		return chucVu;
	}

	/**
	 * @param string
	 */
	public void setChucVu(String string) {
		chucVu = string;
	}

}