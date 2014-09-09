package cmc.com.ktnb.util;

import java.util.Date;

public class ValueObject implements java.io.Serializable {
	private String id;

	private String name;

	private Date startDate;

	private Date endDate;

	private Long status; // Trang thai cua ban ghi
	
	private int type; // Catalog's type
	
	private ApplicationContext context;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	public static int LOAI_TIEN = 1;
	public static int LOAI_HINH_DOANH_NGHIEP = 2;
	public static int THANH_PHAN_KINH_TE = 3;
	public static int BANG_DIEM = 4;
	public static int CAP_CHUONG = 5;
	public static int CO_QUAN_THUE = 6;
	public static int CONG_THUC_DAU_VAO = 7;
	public static int DOI_TUONG_NOP_THUE = 8;
	public static int LOAI_BAO_CAO = 9;
	public static int LOAI_CONG_THUC_DR = 10;
	public static int LOAI_TAI_LIEU_DK = 11;
	public static int PHAN_LOAI = 12;
	public static int TI_GIA = 13;
}
