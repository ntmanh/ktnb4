package cmc.com.ktnb.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import cmc.com.ktnb.vo.CategoryVO;
public class KtnbCache extends HashMap {
	private static KtnbCache instance = null;
	protected KtnbCache() {
		load();
	}
	public static KtnbCache getInstance() {
		if (instance == null)
			createInstance();
		return instance;
	}
	synchronized private static void createInstance() {
		if (instance == null)
			instance = new KtnbCache();
	}
	synchronized public static void reLoad() {
		instance = new KtnbCache();
	}

	private static HashMap getFunc() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HashMap map = new HashMap();
		String sql = "select uri||'-'||method||'-'||act,nhom from ktnb_chuc_nang";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			String nhom;
			while (rs.next()) {
				nhom = rs.getString(2);
				map.put(rs.getString(1), nhom);
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return map;
	}

	private static Collection getRole() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection retval = new ArrayList();
		String sql = "select ma,ten from ktnb_dm start with parent_id=? connect by PRIOR ma=parent_id and hien_thi=1 order by ma ";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "24");
			rs = ps.executeQuery();
			CategoryVO vo = null;
			while (rs.next()) {
				vo = new CategoryVO(rs.getString(1), rs.getString(2));
				retval.add(vo);
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}
	private static Collection getTinh() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection retval = new ArrayList();
		String sql = "select ma,ten from ktnb_dm_tinh where ma!='000' order by ma";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			CategoryVO vo = new CategoryVO("000", "TCT");
			retval.add(vo);
			while (rs.next()) {
				vo = new CategoryVO(rs.getString(1), rs.getString(2));
				retval.add(vo);
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}
	private static Collection getCuc() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection retval = new ArrayList();
		String sql = "select ma,ten from ktnb_dm_cqt where ma like ?  order by ma";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%00");
			rs = ps.executeQuery();
			CategoryVO vo = null;
			while (rs.next()) {
				vo = new CategoryVO(rs.getString(1), rs.getString(2));
				retval.add(vo);
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}

	private static Collection getCqtByMaTinh(String matinh) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection retval = new ArrayList();
		String sql = "select ma,ten,ma_cha from ktnb_dm_cqt where ma like ?  order by ma";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, matinh + "%");
			rs = ps.executeQuery();
			CategoryVO vo;
			while (rs.next()) {
				vo = new CategoryVO(rs.getString(1), rs.getString(2),rs.getString(3));
				retval.add(vo);
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}
	
	private static Collection getDepCqtByMaTinh(String matinh) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection retval = new ArrayList();
		String sql = "select t.ma,t.ten from ktnb_dm_phong_cqt_v t where (t.ma like ? or (t.ma like ? and length(t.ma)=5)) order by length(ma),ma";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, matinh + "00%");
			ps.setString(2, matinh + "%");
			rs = ps.executeQuery();
			CategoryVO vo;
			while (rs.next()) {
				vo = new CategoryVO(rs.getString(1), rs.getString(2));
				retval.add(vo);
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}
	private static HashMap getMapCqt(Collection c) throws Exception {
		HashMap map = new HashMap();
		try {
			CategoryVO vo;
			String id;
			for (Iterator it = c.iterator(); it.hasNext();) {
				vo = (CategoryVO) it.next();
				id = vo.getId();
				map.put(id, getCqtByMaTinh(id));
			}
		} catch (Exception ex) {
			throw ex;
		}
		return map;
	}
	private static Collection getDeptByMaCqt(String macqt) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection retval = new ArrayList();
		String sql = "select ma,ten from ktnb_dm_phong where ma_cqt=? order by ten";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, macqt);
			rs = ps.executeQuery();
			CategoryVO vo;
			while (rs.next()) {
				vo = new CategoryVO(rs.getString(1), rs.getString(2));
				retval.add(vo);
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}

	private static Collection getDmByParentId(String parentId) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection retval = new ArrayList();
		String sql = "select ma,ten from ktnb_dm where parent_id=?  and ngay_het_hl is null and hien_thi=1 order by to_number(ma)";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, parentId);
			rs = ps.executeQuery();
			while (rs.next())
				retval.add(new CategoryVO(rs.getString(1), rs.getString(2)));
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}

	private static HashMap getMapDept() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HashMap map = new HashMap();
		try {
			String sql = "select ma from ktnb_dm_cqt order by ten";
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			String id;
			while (rs.next()) {
				id = rs.getString(1);
				map.put(id, getDeptByMaCqt(id));
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return map;
	}

	private static Collection getDsDm() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection retval = new ArrayList();
		String sql = "select ma,ten from ktnb_dm where parent_id is null and hien_thi=1 and ngay_het_hl is null order by ma ";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
				retval.add(new CategoryVO(rs.getString(1), rs.getString(2)));
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}

	private void load() {
		try {
			System.out.println("Start load Cache");
			put("DM_CQT_TT", getDepCqtByMaTinh("101"));
			put("MAP_DEPT", getMapDept());
			put("LOV_ROLE", getRole());
			put("MAP_FUNC", getFunc());
			// Danh muc noi dung thanh tra kiem tra
			put("DM_NDGOC", getDmByParentId(Constants.DM_TTKT));
			// Trang thai Thanh tra kiem tra
			put("DM_TT_TTKT", getDmTrangThaiTttk());			
			//tinh
			Collection c = getTinh();
			put("LOV_TINH", c);
			put("JARR_DSTINH", KtnbUtil.coll2Jarr(c));
			put("MAP_CQT", getMapCqt(c));
			//chucvu
			c = getDmByParentId(Constants.DM_CHUC_VU);
			put("MAP_CHUCVU", KtnbUtil.coll2Hash(c));
			put("JARR_DSCHUCVU", KtnbUtil.coll2Jarr(c));
			//dsdm			
			c = getDsDm();
			put("JARR_DSDM", KtnbUtil.coll2Jarr(c));
			put("MAP_DSDM", KtnbUtil.coll2Hash(c));

			c = getDmByParentId(Constants.DM_TTKT);
			put("JARR_DSNDTTKT", KtnbUtil.coll2Jarr(c));

			// Dm thoi han ttkt
			put("MAP_THTTKT", getThoiHanTtkt());

			System.out.println("End load Cache");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	private HashMap getDmTrangThaiTttk() throws Exception {
		HashMap retval = new HashMap();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select t.ma, t.ten from ktnb_dm t where t.parent_id like '18%'";
		try {
			conn = DataSourceConfiguration.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next())
				retval.put(rs.getString(2), rs.getString(1));
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, st, conn);
		}
		return retval;
	}
	/**
	 * @return
	 */
	private HashMap getThoiHanTtkt() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		HashMap map = new HashMap();
		try {
			String sql = "select t1.ma, t2.thoigian, t2.ngay from ktnb_dm t1, ktnb_dm_time t2 where t1.ma = t2.pid and t1.ma in (";			
			sql += "'" + Constants.TH_TTKT_QD + "',";
			sql += "'" + Constants.TH_TTKT_LKH + "',";
			sql += "'" + Constants.TH_TTKT_DKH + "',";
			sql += "'" + Constants.TH_TTKT_DC + "',";
			sql += "'" + Constants.TH_TTKT_CB + "',"; 
			sql += "'" + Constants.TH_TTKT_KT + "',";
			sql += "'" + Constants.TH_TTKT_KQ + "',";
			sql += "'" + Constants.TH_TTKT_KL + "',";
			sql += "'" + Constants.TH_TTKT_BGHSLT + "',";
			sql += "'" + Constants.TH_TTKT_GQD + "',";
			sql += "'" + Constants.TH_TTKT_CGHSVV + "',";
			sql += "'" + Constants.TH_TTKT_TCGKH + "',";
			sql += "'" + Constants.TH_TTKT_CGKH + "',";
			sql += "'" + Constants.TH_TTKT_CCGKH + "',";
			sql += "'" + Constants.TH_TTKT_CCGKH + "',";
			sql += "'" + Constants.TH_TTKT_KT_TT_TC + "',";
			sql += "'" + Constants.TH_TTKT_KT_KT_TC + "',";
			sql += "'" + Constants.TH_TTKT_KT_TT_C + "',";
			sql += "'" + Constants.TH_TTKT_KT_KT_C + "',";
			sql += "'" + Constants.TH_TTKT_KT_TT_CC + "',";
			sql += "'" + Constants.TH_TTKT_KT_KT_CC + "'";
			sql += ")";
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			String id;
			String thoiHan;
			while (rs.next()) {
				id = rs.getString(1).trim();
				try {
					thoiHan = rs.getString(2).trim();
				} catch (Exception e) {
					thoiHan = rs.getString(3).trim();
				}
				map.put(id, thoiHan);
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return map;
	}
}