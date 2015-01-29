package cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt;
import cmc.com.ktnb.pl.hb.entity.PersistentObject;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TtktThQdNiemPhongHsTl entity. @author MyEclipse Persistence Tools
 */

public class TtktThQdNiemPhongHsTl extends PersistentObject implements java.io.Serializable { 

	// Fields

	private String id;
	private String idCuocTtkt;
	private Date ngayRaQd;
	private String taiLieuDuocNiemPhong; 
	private Date tgNiemPhongTu;
	private String idDviCnhanThucHien;
	private String idDviCnhanBaoQuan;
	private String tenDviCnhanBaoQuan;
	private String noiRaQd;
	private String chucVuDviCnhanThucHien;
	private String idCnhanBaoQuanSauMo;
	private String idNguoiMoNiemPhong;
	private String tenNguoiMoNiemPhong;
	private String chucVuNguoiMoNiemPhong;
	private String tenDviCnhanThucHien;
	private String noiRaQdMoNp;
	private Date ngayRaQdMoNp;
	private String tenDviCnhanBaoQuanSauMo;
	private String idDsTvdQdNiemPhong;
	private String idDsTvdQdMoNiemPhong;
	
	private String canCuQd;
	

	private TtktThBbMoNiemPhong bbMoNiemPhong;
	private TtktThBbNiemPhong bbNiemPhong;
	
	
	// static fields
	public static String IdCuocTtkt = "idCuocTtkt";
	public static String Id = "id";
	// Constructors
	private String idNguoiCapNat;
	 private String tenNguoiCapNhat;
	 private Date ngayCapNhat;
	 
	 
	 
	 public String getCanCuQd() {
		return canCuQd;
	}

	public void setCanCuQd(String canCuQd) {
		this.canCuQd = canCuQd;
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
	/** default constructor */
	public TtktThQdNiemPhongHsTl() {
	}

	/** minimal constructor */
	public TtktThQdNiemPhongHsTl(String id, String idCuocTtkt, Date ngayRaQd,
			String taiLieuDuocNiemPhong, Date tgNiemPhongTu,
			String tenDviCnhanBaoQuan, String noiRaQd,
			String tenDviCnhanThucHien, String tenDviCnhanBaoQuanSauMo) {
		this.id = id;
		this.idCuocTtkt = idCuocTtkt;
		this.ngayRaQd = ngayRaQd;
		this.taiLieuDuocNiemPhong = taiLieuDuocNiemPhong;
		this.tgNiemPhongTu = tgNiemPhongTu;
		this.tenDviCnhanBaoQuan = tenDviCnhanBaoQuan;
		this.noiRaQd = noiRaQd;
		this.tenDviCnhanThucHien = tenDviCnhanThucHien;
		this.tenDviCnhanBaoQuanSauMo = tenDviCnhanBaoQuanSauMo;
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

	public Date getNgayRaQd() {
		return this.ngayRaQd;
	}

	public void setNgayRaQd(Date ngayRaQd) {
		this.ngayRaQd = ngayRaQd;
	}

	public String getTaiLieuDuocNiemPhong() {
		return this.taiLieuDuocNiemPhong;
	}

	public void setTaiLieuDuocNiemPhong(String taiLieuDuocNiemPhong) {
		this.taiLieuDuocNiemPhong = taiLieuDuocNiemPhong;
	}

	public Date getTgNiemPhongTu() {
		return this.tgNiemPhongTu;
	}

	public void setTgNiemPhongTu(Date tgNiemPhongTu) {
		this.tgNiemPhongTu = tgNiemPhongTu;
	}

	public String getIdDviCnhanThucHien() {
		return this.idDviCnhanThucHien;
	}

	public void setIdDviCnhanThucHien(String idDviCnhanThucHien) {
		this.idDviCnhanThucHien = idDviCnhanThucHien;
	}

	public String getIdDviCnhanBaoQuan() {
		return this.idDviCnhanBaoQuan;
	}

	public void setIdDviCnhanBaoQuan(String idDviCnhanBaoQuan) {
		this.idDviCnhanBaoQuan = idDviCnhanBaoQuan;
	}

	public String getTenDviCnhanBaoQuan() {
		return this.tenDviCnhanBaoQuan;
	}

	public void setTenDviCnhanBaoQuan(String tenDviCnhanBaoQuan) {
		this.tenDviCnhanBaoQuan = tenDviCnhanBaoQuan;
	}

	public String getNoiRaQd() {
		return this.noiRaQd;
	}

	public void setNoiRaQd(String noiRaQd) {
		this.noiRaQd = noiRaQd;
	}

	public String getChucVuDviCnhanThucHien() {
		return this.chucVuDviCnhanThucHien;
	}

	public void setChucVuDviCnhanThucHien(String chucVuDviCnhanThucHien) {
		this.chucVuDviCnhanThucHien = chucVuDviCnhanThucHien;
	}

	public String getIdCnhanBaoQuanSauMo() {
		return this.idCnhanBaoQuanSauMo;
	}

	public void setIdCnhanBaoQuanSauMo(String idCnhanBaoQuanSauMo) {
		this.idCnhanBaoQuanSauMo = idCnhanBaoQuanSauMo;
	}

	public String getIdNguoiMoNiemPhong() {
		return this.idNguoiMoNiemPhong;
	}

	public void setIdNguoiMoNiemPhong(String idNguoiMoNiemPhong) {
		this.idNguoiMoNiemPhong = idNguoiMoNiemPhong;
	}

	public String getTenNguoiMoNiemPhong() {
		return this.tenNguoiMoNiemPhong;
	}

	public void setTenNguoiMoNiemPhong(String tenNguoiMoNiemPhong) {
		this.tenNguoiMoNiemPhong = tenNguoiMoNiemPhong;
	}

	public String getChucVuNguoiMoNiemPhong() {
		return this.chucVuNguoiMoNiemPhong;
	}

	public void setChucVuNguoiMoNiemPhong(String chucVuNguoiMoNiemPhong) {
		this.chucVuNguoiMoNiemPhong = chucVuNguoiMoNiemPhong;
	}

	public String getTenDviCnhanThucHien() {
		return this.tenDviCnhanThucHien;
	}

	public void setTenDviCnhanThucHien(String tenDviCnhanThucHien) {
		this.tenDviCnhanThucHien = tenDviCnhanThucHien;
	}

	public String getNoiRaQdMoNp() {
		return this.noiRaQdMoNp;
	}

	public void setNoiRaQdMoNp(String noiRaQdMoNp) {
		this.noiRaQdMoNp = noiRaQdMoNp;
	}

	public Date getNgayRaQdMoNp() {
		return this.ngayRaQdMoNp;
	}

	public void setNgayRaQdMoNp(Date ngayRaQdMoNp) {
		this.ngayRaQdMoNp = ngayRaQdMoNp;
	}

	public String getTenDviCnhanBaoQuanSauMo() {
		return this.tenDviCnhanBaoQuanSauMo;
	}

	public void setTenDviCnhanBaoQuanSauMo(String tenDviCnhanBaoQuanSauMo) {
		this.tenDviCnhanBaoQuanSauMo = tenDviCnhanBaoQuanSauMo;
	}


	/**
	 * @return
	 */
	public TtktThBbMoNiemPhong getBbMoNiemPhong() {
		return bbMoNiemPhong;
	}

	/**
	 * @return
	 */
	public TtktThBbNiemPhong getBbNiemPhong() {
		return bbNiemPhong;
	}

	/**
	 * @param phong
	 */
	public void setBbMoNiemPhong(TtktThBbMoNiemPhong phong) {
		bbMoNiemPhong = phong;
	}

	/**
	 * @param phong
	 */
	public void setBbNiemPhong(TtktThBbNiemPhong phong) {
		bbNiemPhong = phong;
	}

	public String getIdDsTvdQdMoNiemPhong() {
		return idDsTvdQdMoNiemPhong;
	}

	public void setIdDsTvdQdMoNiemPhong(String idDsTvdQdMoNiemPhong) {
		this.idDsTvdQdMoNiemPhong = idDsTvdQdMoNiemPhong;
	}

	public String getIdDsTvdQdNiemPhong() {
		return idDsTvdQdNiemPhong;
	}

	public void setIdDsTvdQdNiemPhong(String idDsTvdQdNiemPhong) {
		this.idDsTvdQdNiemPhong = idDsTvdQdNiemPhong;
	}

}