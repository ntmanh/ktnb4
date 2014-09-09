package cmc.com.ktnb.pl.hb.entity;


/**
 * KtnbChucNang entity. @author MyEclipse Persistence Tools
 */

public class KtnbChucNang extends cmc.com.ktnb.pl.hb.entity.PersistentObject
		implements java.io.Serializable {

	// Fields

	private Long maCn;
	private String chucNang;
	private Long parent;
	private Long orderColumn;
	private String name;
	private Boolean active;
	
	// Constructors

	/** default constructor */
	public KtnbChucNang() {
	}

	
	/**
	 * @return
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @return
	 */
	public String getChucNang() {
		return chucNang;
	}

	/**
	 * @return
	 */
	public Long getMaCn() {
		return maCn;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public Long getOrderColumn() {
		return orderColumn;
	}

	/**
	 * @return
	 */
	public Long getParent() {
		return parent;
	}

	/**
	 * @param boolean1
	 */
	public void setActive(Boolean boolean1) {
		active = boolean1;
	}

	/**
	 * @param string
	 */
	public void setChucNang(String string) {
		chucNang = string;
	}

	/**
	 * @param long1
	 */
	public void setMaCn(Long long1) {
		maCn = long1;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * @param long1
	 */
	public void setOrderColumn(Long long1) {
		orderColumn = long1;
	}

	/**
	 * @param long1
	 */
	public void setParent(Long long1) {
		parent = long1;
	}
	public boolean equals(Object other) {
			 if ( (this == other ) ) return true;
			 if ( (other == null ) ) return false;
			 if ( !(other instanceof KtnbChucNang) ) return false;
		KtnbChucNang castOther = ( KtnbChucNang ) other; 
         
			 return ( (this.getMaCn()==castOther.getMaCn()));
	   }
   
	   public int hashCode() {
			 int result = 17;         
			 result = 37 * result + ( getMaCn() == null ? 0 : this.getMaCn().hashCode() );
			 return result;
	   }   
}