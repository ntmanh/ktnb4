/*
 * Created on Jan 10, 2011
 */
package cmc.com.ktnb.util;

/**
 * @author DoHongPhuc
 */
public class KntcUtil {
	public static KntcDAO getKntcDAO() {
		return new KntcDAOImpl();
	}
	public static void releaseKntcDAO(KntcDAO dao) {
		if (dao != null) {
			dao.close();
			dao = null;
		}
	}
}
