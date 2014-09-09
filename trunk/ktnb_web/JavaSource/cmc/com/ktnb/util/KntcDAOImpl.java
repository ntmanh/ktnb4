/*
 * Created on Jan 10, 2011
 */
package cmc.com.ktnb.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;

import cmc.com.ktnb.pl.hb.entity.KntcQdxmPhieuYc;

/**
 * @author DoHongPhuc
 * Xử lý các thông tin liên quan đến riêng KNTC
 */
public class KntcDAOImpl implements KntcDAO {
	private Connection conn = null;
	/**
	 * Hàm khởi tạo mặc định
	 *
	 */
	public KntcDAOImpl() {
		try {
			conn = DataSourceConfiguration.getConnection();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	/**
	 * Đóng và giải phóng các kết nối
	 */
	public void close() {
		DataSourceConfiguration.releaseSqlResources(conn);
	}
	/**
	 * Lấy ra danh sách các phiếu trong quá trình xác minh , theo loại phiếu
	 */
	public JSONObject getListQdxmPhieuYc(String maHoSo, String loaiPhieu) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		String query = "select MA,NGAY_LAP,NGUOI_NHAN_PHIEU,NGUOI_NHAN_BC ";
		if (loaiPhieu.equals(KntcQdxmPhieuYc.PHIEU_YC_GIAI_TRINH) || loaiPhieu.equals(KntcQdxmPhieuYc.PHIEU_TRUNG_CAU_GIAM_DINH))
			query = "select MA,Ngay_lap,don_vi_ycgt ";
		else if(loaiPhieu.equals(KntcQdxmPhieuYc.PHIEU_LAY_Y_KIEN_TU_VAN))
			query = "select MA,Ngay_lap,don_vi_ykien ";		
		try {
			query += "from KNTC_QDXM_PHIEU_YC where MA_HS = '" + maHoSo + "' AND LOAI_PHIEU='" + loaiPhieu + "'";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			JSONArray jsonArray = new JSONArray();
			JSONArray ja;
			while (rs.next()) {
				ja = new JSONArray();

				ja.put(rs.getString("MA"));
				ja.put(Formater.date2str(rs.getDate("NGAY_LAP")));
				if (loaiPhieu.equals(KntcQdxmPhieuYc.PHIEU_YC_GIAI_TRINH) || loaiPhieu.equals(KntcQdxmPhieuYc.PHIEU_TRUNG_CAU_GIAM_DINH))
					ja.put(rs.getString("don_vi_ycgt"));
				else if (loaiPhieu.equals(KntcQdxmPhieuYc.PHIEU_YC_HO_SO_TL)) {
					ja.put(rs.getString("NGUOI_NHAN_PHIEU"));
					ja.put(rs.getString("NGUOI_NHAN_BC"));
				}else if(loaiPhieu.equals(KntcQdxmPhieuYc.PHIEU_LAY_Y_KIEN_TU_VAN)){
					ja.put(rs.getString("don_vi_ykien"));
				}
				jsonArray.put(ja);
			}
			jsonResult.put("aaData", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}
	/**
	 * Lấy ra danh sách báo cáo theo mã hồ sơ và loại phiếu
	 */
	public JSONObject getListBaoCao(String maHoSo, String loaiPhieu) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		String query = "select MA_BC,THOI_DIEM,NGUOI_LAP ";
		// if (loaiPhieu.equals("14B/KNTC"))
		// query = "select MA_PHIEU,Ngay_lap,don_vi_ycgt ";
		try {
			query += "from KNTC_BAO_CAO where MA_HS = '" + maHoSo + "'";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			JSONArray jsonArray = new JSONArray();
			JSONArray ja;
			while (rs.next()) {
				ja = new JSONArray();
				ja.put(rs.getString("MA_BC")); // Ma don
				ja.put(rs.getDate("THOI_DIEM")); // Thoi diem lap phieu
				ja.put(rs.getString("NGUOI_LAP"));
				// if (loaiPhieu.equals("14A/KNTC"))
				// ja.put(rs.getString("don_vi_ycgt"));
				// else if (loaiPhieu.equals("13/KNTC")) {
				// ja.put(rs.getString("NGUOI_NHAN_PHIEU")); //Dia diem hen
				// ja.put(rs.getString("NGUOI_NHAN_BC")); //Muc dich hen
				// }
				jsonArray.put(ja);
			}
			jsonResult.put("aaData", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}
	/**
	 * Lấy ra danh sách quyết định gia hạn theo mã hồ sơ
	 */
	public JSONObject getListQdGiaHan(String maHs) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		String query = "select MA,SO_PHIEU,NGAY_LAP,NGUOI_LAP ";
		try {
			query += "from kntc_xm_gia_han where MA_HS = '" + maHs + "'";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			JSONArray jsonArray = new JSONArray();
			JSONArray ja;
			while (rs.next()) {
				ja = new JSONArray();
				ja.put(rs.getString("MA"));
				ja.put(rs.getString("SO_PHIEU"));
				ja.put(rs.getDate("NGAY_LAP"));
				ja.put(rs.getString("NGUOI_LAP"));
				jsonArray.put(ja);
			}
			jsonResult.put("aaData", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}
	/**
	 * Lấy ra danh sách các thông tin theo dõi thi hành theo mã hồ sơ
	 */
	public JSONObject getListHoSoTheoDoi(String maHoSo) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			String query = "select ma,ngay_lap,noi_dung from kntc_ho_so_theo_doi where ma_hs = '" + maHoSo + "'";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			JSONArray jsonArray = new JSONArray();
			JSONArray ja;
			while (rs.next()) {
				ja = new JSONArray();
				ja.put(rs.getString(1)); // Ma
				ja.put(rs.getDate(2)); // Ngay theo doi
				ja.put(rs.getString(3)); // Noi dung
				jsonArray.put(ja);
			}
			jsonResult.put("aaData", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	/**
	 * Lấy ra danh sách các nội dung liên quan đến bộ hồ sơ
	 */
	public JSONObject getListDmNd(String maHs, String loaiRls, String l2) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			String query = "select t1.ma,t1.ten from ktnb_dm t1, kntc_dm_rls t2 where t1.ma=t2.ma_dm and t2.ma_hs=? and t2.loai_rls=? order by t1.ma";
			ps = conn.prepareStatement(query);
			ps.setString(1, maHs);
			ps.setString(2, l2);
			rs = ps.executeQuery();
			String m1 = "";
			while (rs.next()) {
				m1 += rs.getString(1) + ",";
			}
			DataSourceConfiguration.releaseSqlResources(rs, ps);
			ps = conn.prepareStatement(query);
			ps.setString(1, maHs);
			ps.setString(2, loaiRls);
			rs = ps.executeQuery();
			JSONArray jsonArray = new JSONArray();
			JSONArray ja;
			int i = 1;
			while (rs.next()) {
				ja = new JSONArray();
				ja.put(i);
				String ma = rs.getString(1);
				ja.put(ma); // Ma
				ja.put(rs.getString(2)); // Ngay theo doi >/
				if (m1.indexOf(ma) > 0) {
					ja.put("<input type=checkbox id='dmNd' checked name='dmNd' value='" + ma + "' />");
				} else
					ja.put("<input type=checkbox id='dmNd' name='dmNd' value='" + ma + "' />");
				jsonArray.put(ja);
				i++;
			}
			jsonResult.put("aaData", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	public JSONObject getListDmNd(String maHs) {
		return null;
	}
}
