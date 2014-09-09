package cmc.com.ktnb.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
	private Date systemDate;

	private int cuc = 2;

	private String tenTruongPhong; // Truong phong

	private String tenThuTruong; // Cuc Truong, Chi Cuc Truong

	private String tenNsd;

	private String maCanbo;

	private String tenCanbo;

	private String maPhong;

	private String tenPhong;

	private String maCqt;

	private String tenCqt;

	private String maCuc;

	private String tenCuc,diaBan;

	private String maChucvu;

	private String tenChucvu;

	private String tenCqtTat;

	private String[] role;

	private String[] roleData; // Phan quyen data theo CQT cap duoi

	private String[] arrCb; // Danh sach can bo quan ly (pho phong)

	private String versionApp = "2.2";
	
	private Map attributes = new HashMap();

	// Trang thai cua tat ca cac cuoc Thanh tra Kiem tra trong session
	private HashMap trangThaiCuocTtkt = new HashMap();

	// Truong doan cua tat ca cac cuoc Thanh tra Kiem tra trong session
	private HashMap truongDoan = new HashMap();
	
	private String listNguoiKy =""; // Danh sach lanh dao ky

	public boolean isTruongDoan(String idCuocTtkt) {
		return ((Boolean) truongDoan.get(idCuocTtkt)).booleanValue();
	}

	public void setTruongDoan(String idCuocTtkt, boolean isTruongDoan) {
		if (truongDoan.containsKey(idCuocTtkt)) {
			truongDoan.remove(idCuocTtkt);
		}
		truongDoan.put(idCuocTtkt, new Boolean(isTruongDoan));
	}

	public boolean lanhDao;

	public ApplicationContext() {
		systemDate = new Date();
	}

	public Object setAttribute(String key, Object value) {
		return attributes.put(key, value);
	}

	public Object getAttribute(String key) {
		return attributes.get(key);
	}

	public Object removeAttribute(String key) {
		return attributes.remove(key);
	}

	public boolean isValid() {
		boolean retval = (this.maCanbo != null);
		return retval;
	}

	public Date getSystemDate() {
		return systemDate;
	}

	public void setSystemDate(Date date) {
		systemDate = date;
	}

	public Map getAttributes() {
		return attributes;
	}

	public String getMaCanbo() {
		return maCanbo;
	}

	public String getMaCqt() {
		return maCqt;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public String getTenCanbo() {
		return tenCanbo;
	}

	public String getTenCqt() {		
		//return tenCqt.replaceAll("'", "\'");
		return tenCqt;
	}

	public String getTenNsd() {
		return tenNsd;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setAttributes(Map map) {
		attributes = map;
	}

	public void setMaCanbo(String string) {
		maCanbo = string;
	}

	public void setMaCqt(String string) {
		maCqt = string;
	}

	public void setMaPhong(String string) {
		maPhong = string;
	}

	public void setTenCanbo(String string) {
		tenCanbo = string;
	}

	public void setTenCqt(String string) {
		tenCqt = string;
	}

	public void setTenNsd(String string) {
		tenNsd = string;
	}

	public void setTenPhong(String string) {
		tenPhong = string;
	}

	public String[] getRole() {
		return role;
	}

	public void setRole(String[] strings) {
		role = strings;
	}

	public String getTrangThaiCuocTtkt(String idCuocTtkt) {
		return (String) trangThaiCuocTtkt.get(idCuocTtkt);
	}

	public void setTrangThaiCuocTtkt(String idCuocTtkt, String trangThai) {
		if (trangThaiCuocTtkt.containsKey(idCuocTtkt)) {
			trangThaiCuocTtkt.remove(idCuocTtkt);
		}
		trangThaiCuocTtkt.put(idCuocTtkt, trangThai);
	}

	public String getMaCuc() {
		return maCuc;
	}

	public String getTenCuc() {
		return tenCuc;
	}

	public void setMaCuc(String string) {
		maCuc = string;
	}

	public void setTenCuc(String string) {
		tenCuc = string;
	}

	public int getCuc() {
		return cuc;
	}

	public void setCuc(int i) {
		cuc = i;
	}

	/**
	 * @return
	 */
	public String getTenCqtTat() {
		return tenCqtTat;
	}

	public String getTenCqtVTat() {
		return tenCqtTat.replaceAll("/", "");
	}

	/**
	 * @param string
	 */
	public void setTenCqtTat(String string) {
		tenCqtTat = string;
	}

	/**
	 * @return
	 */
	public String getMaChucvu() {
		return maChucvu;
	}

	/**
	 * @return
	 */
	public String getTenChucvu() {
		return tenChucvu;
	}

	/**
	 * @param string
	 */
	public void setMaChucvu(String string) {
		maChucvu = string;
	}

	/**
	 * @param string
	 */
	public void setTenChucvu(String string) {
		tenChucvu = string;
	}

	public String getTenTruongPhong() {
		return tenTruongPhong;
	}

	public void setTenTruongPhong(String tenTruongPhong) {
		this.tenTruongPhong = tenTruongPhong;
	}

	public String getTenThuTruong() {
		return tenThuTruong;
	}

	public void setTenThuTruong(String tenThuTruong) {
		this.tenThuTruong = tenThuTruong;
	}

	public String[] getRoleData() {
		return roleData;
	}

	public void setRoleData(String[] roleData) {
		this.roleData = roleData;
	}

	public boolean isLanhDao() {
		return lanhDao;
	}

	public void setLanhDao(boolean isLanhDao) {
		this.lanhDao = isLanhDao;
	}

	public String[] getArrCb() {
		return arrCb;
	}

	public void setArrCb(String[] arrCb) {
		this.arrCb = arrCb;
	}

	public String getListNguoiKy() {
		return listNguoiKy;
	}

	public void setListNguoiKy(String listNguoiKy) {
		this.listNguoiKy = listNguoiKy;
	}

	public String getDiaBan() {
		return diaBan;
	}

	public void setDiaBan(String diaBan) {
		this.diaBan = diaBan;
	}

	public String getVersionApp() {
		return versionApp;
	}

	public void setVersionApp(String versionApp) {
		this.versionApp = versionApp;
	}
	
}
