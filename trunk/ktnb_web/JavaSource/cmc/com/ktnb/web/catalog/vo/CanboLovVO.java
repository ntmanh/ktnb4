package cmc.com.ktnb.web.catalog.vo;

import java.io.Serializable;

/**
 * @author ntthu
 * @version Jan 21, 2008
 */
public class CanboLovVO implements Serializable {
	private String ma;
	private String ten;
	private String chucVu;
	private String maPhong;
	private String maCqt;
	private String tenPhong;
	private String tenCqt;
	public CanboLovVO(String ma,String ten){
		this.ma =  ma;
		this.ten = ten;
	}
	public CanboLovVO(Object[] ele) {
		this.ma = (String) ele[0];
		this.ten = (String) ele[1];
		try {
			this.chucVu = (String) ele[2];
			this.maPhong = (String) ele[3];
			this.tenPhong = (String) ele[4];
			this.maCqt = (String) ele[5];		
			this.tenCqt = (String) ele[6];
		} catch (RuntimeException e) {
			//e.printStackTrace();
		}
	}

	public String getData() {
		String retVal = "";
		retVal = this.ma + "@@" + this.ten + "@@" + this.chucVu + "@@" + this.maPhong + "@@" + this.tenPhong + "@@" + this.maCqt + "@@" + this.tenCqt;
		return retVal.replaceAll("'", "\\\\'");
	}
	public String getDataCqt() {
		String retVal = "";
		retVal = this.ma + "@@" + this.ten;
		return retVal.replaceAll("'", "\\\\'");
	}

	/**
	 * @return
	 */
	public String getChucVu() {
		return chucVu;
	}

	/**
	 * @return
	 */
	public String getMa() {
		return ma;
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
	public String getMaPhong() {
		return maPhong;
	}

	/**
	 * @return
	 */
	public String getTen() {
		return ten;
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
	public void setChucVu(String string) {
		chucVu = string;
	}

	/**
	 * @param string
	 */
	public void setMa(String string) {
		ma = string;
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
	public void setMaPhong(String string) {
		maPhong = string;
	}

	/**
	 * @param string
	 */
	public void setTen(String string) {
		ten = string;
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

}
