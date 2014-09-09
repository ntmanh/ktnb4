package cmc.com.ktnb.pl.hb.entity;
import java.util.Date;

/**
 * Tat ca cac doi tuong muon luu tru lau dai xuong CSDL deu phai
 * thua ke lop nay.
 *  Luu them thong tin ve log
 * @author ntthu
 */
public class PersistentObjectLogger extends PersistentObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userCreated;
	private Date dateCreated;
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @return
	 */
	public String getUserCreated() {
		return userCreated;
	}

	/**
	 * @param date
	 */
	public void setDateCreated(Date date) {
		dateCreated = date;
	}

	/**
	 * @param string
	 */
	public void setUserCreated(String string) {
		userCreated = string;
	}
}