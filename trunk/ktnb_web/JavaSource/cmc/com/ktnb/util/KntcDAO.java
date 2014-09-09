/*
 * Created on Jan 7, 2011
 */
package cmc.com.ktnb.util;
import java.util.Collection;
import org.json.JSONObject;
import cmc.com.ktnb.vo.*;
/**
 * @author DoHongPhuc
 */
public interface KntcDAO {
	void close();
	JSONObject getListQdGiaHan(String maQd) throws Exception;
	JSONObject getListQdxmPhieuYc(String maHoSo,String loaiPhieu) throws Exception;
	JSONObject getListBaoCao(String maHoSo,String loaiBaoCao) throws Exception;
	JSONObject getListHoSoTheoDoi(String maHoSo) throws Exception;
	JSONObject getListDmNd(String maHs);
	JSONObject getListDmNd(String maHs, String loaiRls,String loaiRls2) throws Exception;
}
