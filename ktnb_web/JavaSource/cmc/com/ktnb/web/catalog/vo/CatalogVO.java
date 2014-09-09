/*
 * Created on Jun 19, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.catalog.vo;

import java.lang.reflect.Field;

import cmc.com.ktnb.util.ValueObject;

/**
 * @author nhvan
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CatalogVO extends ValueObject {
	private String ngayApDung;
	private String ngayKt;
	private String loai;   
   	private boolean active;
   	private String hasChanged;
   	private String hasAddNew;
   
   	private String id;
   	private String ma ;
   	private String ten;
   	private String gtriTu ;
   	private String gtriDen ;
   	private String parentId;
   	private String muc;
      
   	private String hideId;
   	private String hideMa ;
   	private String hideTen;
   	private String hiheGtriTu ;
   	private String hideGtriDen ;
   	private String hideParentId;
   	private String hideMuc;
   	
	public void copyFieldsData(Object source) {
		try {
			Field[] fields = source.getClass().getDeclaredFields();
			int fieldLength = fields.length;
			for(int i=0; i<fieldLength; i++) {
				Field field = fields[i];
				String fieldName = field.getName();
				Class fieldType = field.getType();

				Object fieldValue = field.get(source);
				if (fieldValue != null) {
					Field fieldToFill = this.getClass().getDeclaredField(fieldName);
					fieldToFill.set(this, fieldValue);
				}
			}
		} 
		catch (IllegalAccessException iae) {
			System.out.println("IllegalAccessException = " + iae.toString());
		} 
		catch (NoSuchFieldException nsfe) {
			System.out.println("NoSuchFieldException = " + nsfe.toString());
		}
	}
		
	/**
	 * @return
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * @return
	 */
	public String getGtriDen() {
		return gtriDen;
	}
	
	/**
	 * @return
	 */
	public String getGtriTu() {
		return gtriTu;
	}
	
	/**
	 * @return
	 */
	public String getHideGtriDen() {
		return hideGtriDen;
	}
	
	/**
	 * @return
	 */
	public String getHideId() {
		return hideId;
	}
	
	/**
	 * @return
	 */
	public String getHideMa() {
		return hideMa;
	}
	
	/**
	 * @return
	 */
	public String getHideTen() {
		return hideTen;
	}
	
	/**
	 * @return
	 */
	public String getHiheGtriTu() {
		return hiheGtriTu;
	}
	
	/**
	 * @return
	 */
	public String getId() {
		return id;
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
	public String getTen() {
		return ten;
	}
	
	/**
	 * @param b
	 */
	public void setActive(boolean b) {
		active = b;
	}
	
	/**
	 * @param string
	 */
	public void setGtriDen(String string) {
		gtriDen = string;
	}
	
	/**
	 * @param string
	 */
	public void setGtriTu(String string) {
		gtriTu = string;
	}
	
	/**
	 * @param string
	 */
	public void setHideGtriDen(String string) {
		hideGtriDen = string;
	}
	
	/**
	 * @param string
	 */
	public void setHideId(String string) {
		hideId = string;
	}
	
	/**
	 * @param string
	 */
	public void setHideMa(String string) {
		hideMa = string;
	}
	
	/**
	 * @param string
	 */
	public void setHideTen(String string) {
		hideTen = string;
	}
	
	/**
	 * @param string
	 */
	public void setHiheGtriTu(String string) {
		hiheGtriTu = string;
	}
	
	/**
	 * @param string
	 */
	public void setId(String string) {
		id = string;
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
	public void setTen(String string) {
		ten = string;
	}
	
	/**
	 * @return
	 */
	public String getHideMuc() {
		return hideMuc;
	}
	
	/**
	 * @return
	 */
	public String getHideParentId() {
		return hideParentId;
	}
	
	/**
	 * @param string
	 */
	public void setHideMuc(String string) {
		hideMuc = string;
	}
	
	/**
	 * @param string
	 */
	public void setHideParentId(String string) {
		hideParentId = string;
	}

	/**
	 * @return
	 */
	public String getNgayApDung() {
		return ngayApDung;
	}
	
	/**
	 * @param string
	 */
	public void setNgayApDung(String string) {
		ngayApDung = string;
	}

	/**
	 * @return
	 */
	public String getMuc() {
		return muc;
	}
	
	/**
	 * @param string
	 */
	public void setMuc(String string) {
		muc = string;
	}

	/**
	 * @return
	 */
	public String getLoai() {
		return loai;
	}
	
	/**
	 * @param string
	 */
	public void setLoai(String string) {
		loai = string;
	}
	/**
	 * @return
	 */
	public String getNgayKt() {
		return ngayKt;
	}
	
	/**
	 * @param string
	 */
	public void setNgayKt(String string) {
		ngayKt = string;
	}

	/**
	 * @return
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param string
	 */
	public void setParentId(String string) {
		parentId = string;
	}

	/**
	 * @return
	 */
	public String getHasChanged() {
		return hasChanged;
	}

	/**
	 * @param string
	 */
	public void setHasChanged(String string) {
		hasChanged = string;
	}

	/**
	 * @return
	 */
	public String getHasAddNew() {
		return hasAddNew;
	}

	/**
	 * @param string
	 */
	public void setHasAddNew(String string) {
		hasAddNew = string;
	}

}
