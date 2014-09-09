package cmc.com.ktnb.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.vo.CategoryVO;
import cmc.com.ktnb.vo.Node;
import cmc.com.ktnb.vo.SearchStoreVO;
import cmc.com.ktnb.vo.SearchVO;

/**
 * 
 * @author nbdai-dhphuc-ntthu Xử lý các thông tin liên quan đến hệ thống
 */
public class KtnbDAOImpl implements KtnbDAO {
	private Connection conn = null;

	/**
	 * Hàm khởi tạo mặc định
	 */
	public KtnbDAOImpl() {
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
	 * Lấy thông tin DBLink
	 */
	public Collection getDBLink() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection retval = new ArrayList();
		String sql = "select ma from ktnb_dblink order by ma ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			CategoryVO vo;
			String ma;
			while (rs.next()) {
				ma = rs.getString(1);
				vo = new CategoryVO(ma, ma);
				retval.add(vo);
			}
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return retval;
	}

	/**
	 * Đồng bộ danh mục phòng từ TINC
	 */
	public void refreshDMPhong(String db) throws Exception {
		CallableStatement cs = null;
		try {
			String sql = "begin ktnb_pck_load.prc_load_phong_tinc(?); end;";
			cs = conn.prepareCall(sql);
			cs.setString(1, db);
			cs.execute();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(cs);
		}
	}

	/**
	 * Đồng bộ danh mục cán bộ từ TINC
	 */
	public void refreshDMCanBo(String db) throws Exception {
		CallableStatement cs = null;
		try {
			String sql = "begin ktnb_pck_load.prc_load_can_bo_tinc(?); end;";
			cs = conn.prepareCall(sql);
			cs.setString(1, db);
			cs.execute();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(cs);
		}
	}

	/**
	 * Tạo người sử dụng
	 */
	public void createUser(String macb) throws Exception {
		CallableStatement cs = null;
		try {
			String sql = "begin ktnb_pck_util.create_user(?); end;";
			cs = conn.prepareCall(sql);
			cs.setString(1, macb);
			cs.execute();
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(cs);
		}
	}

	/**
	 * Xóa người sử dụng
	 */
	public void deleteUser(String userId) throws Exception {
		PreparedStatement ps = null;
		try {
			String sql = "update ktnb_nsd set ACTIVE=0,NGAY_HET_HLUC=sysdate where MA_NSD=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps);
		}
	}

	/**
	 * Khóa người sử dụng
	 */
	public void lockUser(String macb) throws Exception {
		PreparedStatement ps = null;
		try {
			String sql = "update ktnb_nsd set ACTIVE=0,NGAY_HET_HLUC=sysdate where MA_CAN_BO=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, macb);
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps);
		}
	}

	/**
	 * Cập nhật quyền cho người sử dụng
	 */
	public void updUserRole(String macb, String role) throws Exception {
		PreparedStatement ps = null;
		try {
			String sql = "update ktnb_nsd set nhom=? where MA_CAN_BO=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, role);
			ps.setString(2, macb);
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps);
		}
	}

	/**
	 * Cập nhật quyền quản lý địa bàn cho người sử dụng
	 */
	public void updUserDataRole(String macb, String role) throws Exception {
		PreparedStatement ps = null;
		try {
			String sql = "update ktnb_nsd set ma_cqt=? where MA_CAN_BO=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, role);
			ps.setString(2, macb);
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps);
		}
	}

	/**
	 * Mở khóa người sử dụng
	 */
	public void unLockUser(String macb) throws Exception {
		PreparedStatement ps = null;
		try {
			String sql = "update ktnb_nsd set ACTIVE=1,NGAY_HET_HLUC=null where MA_CAN_BO=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, macb);
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps);
		}
	}

	/**
	 * Xóa cán bộ Đặt ngày hết hiệu lực bằng ngày xóa
	 */
	public void delCanBo(String macb) throws Exception {
		PreparedStatement ps = null;
		try {
			lockUser(macb);
			String sql = "update ktnb_dm_can_bo set NGAY_HLUC_DEN=sysdate where MA=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, macb);
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps);
		}
	}

	/**
	 * Cập nhật thông tin cho cán bộ
	 */
	public void updCanBo(JSONObject jo) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String macb, maphong, machucvu, ten;
		try {
			macb = (String) jo.get("ma_canbo");
			ten = (String) jo.get("ten_canbo");
			maphong = (String) jo.get("ten_phong");
			machucvu = (String) jo.get("ten_chucvu");
			StringBuffer sb = new StringBuffer("update ktnb_dm_can_bo set ma=ma");
			if (!Formater.isNull(ten))
				sb.append(",TEN=?");
			if (!Formater.isNull(maphong))
				sb.append(",MA_PHONG=?");
			if (!Formater.isNull(machucvu))
				sb.append(",MA_CHUC_VU=?");
			sb.append(" where ma=?");
			ps = conn.prepareStatement(sb.toString());
			int i = 1;
			if (!Formater.isNull(ten))
				ps.setString(i++, ten);
			if (!Formater.isNull(maphong))
				ps.setString(i++, maphong);
			if (!Formater.isNull(machucvu))
				ps.setString(i++, machucvu);
			ps.setString(i++, macb);
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
	}

	/**
	 * Thêm mới cán bộ
	 */
	public void insCanBo(JSONObject jo) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String ma = null, sql, maphong, machucvu, ten;
		try {
			ten = (String) jo.get("ten_canbo");
			maphong = (String) jo.get("ten_phong");
			machucvu = (String) jo.get("ten_chucvu");
			if (Formater.isNull(ten) || Formater.isNull(maphong))
				throw new IllegalArgumentException("Ph\u1EA3i nh\u1EADp t\u00EAn cb v\u00E0 ph\u00F2ng ban!");
			sql = "select lpad(nvl(max(to_number(substr(ma,8))),0)+1,3,'0') from ktnb_dm_can_bo where substr(ma,0,7) like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, maphong + "%");
			rs = ps.executeQuery();
			if (rs.next())
				ma = maphong + rs.getString(1);
			sql = "insert into ktnb_dm_can_bo (MA,TEN,MA_PHONG,MA_CHUC_VU,NGAY_HLUC_TU) values (?,?,?,?,sysdate)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ma);
			ps.setString(2, ten);
			ps.setString(3, maphong);
			ps.setString(4, machucvu);
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
	}
	
	/**
	 * Get Ma NSD Mapping BTC
	 */
	public int getMaNsd(String maCanBo) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select ma_nsd from ktnb_nsd where ma_can_bo = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, maCanBo);
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps);
		}
		return 0;
	}
	public Collection getAllMaNsd() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection c = new ArrayList();
		try {
			String sql = "select ma_nsd from ktnb_nsd";
			ps = conn.prepareStatement(sql);			
			rs = ps.executeQuery();
			while (rs.next()){
			   c.add(rs.getString(1));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps);
		}
		return c;
	}
	/**
	 * Đổi mật khẩu
	 */
	public void changePassword(String userId, String newPass) throws Exception {
		PreparedStatement ps = null;
		try {
			String sql = "update ktnb_nsd set MAT_KHAU=ktnb_pck_util.get_hash(?,?) where MA_CAN_BO=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, newPass);
			ps.setString(3, userId);
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps);
		}
	}
	/**
	 * Thay doi mat khau cua 1 user
	 * @param username Ten user
	 * @param newPass Mat khau moi
	 * @throws BctcException
	 */
	public void changePasswordBtc(String userId, String newPass) throws Exception {
		if (Formater.isNull(userId) || Formater.isNull(newPass))
			throw new KtnbException("Tham so khong hop le!", "Xem lai thong so dau vao!");
		//if(context==null)
			//throw new Exception("Tham so khong hop le!");
		Connection connBtc = null;
		PreparedStatement ps = null;
		//ResultSet rs = null;		
		try {
			int maNsd = getMaNsd(userId);
			//Lay connection den CSDL BMT			
			connBtc = DataSourceConfiguration.getConnection(Constants.DBNAME_BTC);	
			String sql = "declare  " + "result boolean; " + "begin   " + "btc_owner.btc_pck_bmht.Prc_Get_Key;" + " result := btc_owner.btc_pck_bmht.fnc_change_password(?,?);" + " :result := sys.diutil.bool_to_int(result);" + " end";
			sql = "{call " + sql + "}";
			ps = connBtc.prepareCall(sql);
			int v = 0;
			ps.setInt(1, maNsd);
			ps.setString(2, newPass);
			ps.setInt(3, v);
			ps.execute();			
		} catch (Exception e) {
			e.printStackTrace();
			throw new KtnbException(e);
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps, connBtc);
		}
	}	
	
	private ApplicationContext getInfor(String user, String pass) throws KtnbException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ApplicationContext ac = null;
		String sql, macb, nhom, macqt, macuc, machucvu, dsCqt, dsCbQl;
		try {
			//sql = "SELECT MA_CAN_BO,MAT_KHAU,ACTIVE,NHOM,MA_CQT,MA_CB FROM ktnb_nsd WHERE ten_nsd=?";
			sql = "SELECT MA_CAN_BO,NHOM,MA_CQT,MA_CB FROM ktnb_nsd WHERE ten_nsd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			rs = ps.executeQuery();
			if (!rs.next())
				throw new Exception("Ng&#432;&#7901;i d&#249;ng kh&#244;ng t&#7891;n t&#7841;i ho&#7863;c ch&#432;a &#273;&#432;&#7907;c &#273;&#7891;ng b&#7897;!");
			//if (!"1".equals(rs.getString(3)))
				//throw new Exception("Ng&#432;&#7901;i d&#249;ng b&#7883; kh&#243;a");
			macb = rs.getString(1);
			//pwd = getHash(macb, pass);
			//if (!pwd.equals(rs.getString(2)))
				//throw new KtnbException("Sai m&#7853;t kh&#7849;u!", "Sai m&#7853;t kh&#7849;u!");
			ac = new ApplicationContext();
			ac.setMaCanbo(macb);
			ac.setTenNsd(user);
			nhom = rs.getString(2);
			if (!Formater.isNull(nhom))
				ac.setRole(nhom.split(","));
			// Quan ly CQT cap duoi
			dsCqt = rs.getString(3);
			if (!Formater.isNull(dsCqt))
				ac.setRoleData(dsCqt.split(","));
			// Quan ly can bo cap duoi
			dsCbQl = rs.getString(4);
			if (!Formater.isNull(dsCbQl))
				ac.setArrCb(dsCbQl.split(","));
			// Lay thong tin
			sql = "SELECT TEN_CANBO,MA_PHONG,TEN_PHONG,MA_CQT,TEN_CQT,ten_cqt_tat,ma_chuc_vu FROM ktnb_dm_can_bo_v WHERE MA_CANBO=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, macb);
			rs = ps.executeQuery();
			if (rs.next()) {
				macqt = rs.getString(4);
				macuc = macqt.substring(0, 3);
				machucvu = rs.getString(7);
				if (!Formater.isNull(nhom) && (nhom.indexOf(Constants.LANH_DAO) != -1 || nhom.indexOf(Constants.TRUONG_PHONG_KNTC) != -1))
					ac.setLanhDao(true);
				ac.setTenCanbo(rs.getString(1));
				ac.setMaPhong(rs.getString(2));
				ac.setTenPhong(rs.getString(3));
				ac.setMaCqt(macqt);
				ac.setTenCqt(rs.getString(5));
				ac.setTenCqtTat(rs.getString(6));
				ac.setMaChucvu(machucvu);
				ac.setTenChucvu(KtnbUtil.getTenChucVuByMa(machucvu));
				ac.setMaCuc(macuc);
				ac.setTenCuc(KtnbUtil.getTenTinhByMa(ac,macuc));
//				ac.setDiaBan(KtnbUtil.getDiaBan(ac, macqt));
				ac.setDiaBan(KtnbUtil.getTenTinhByMa(ac,macuc));
				if ("00000".equals(macqt))
					ac.setCuc(0);
				else if ("00".equals(macqt.substring(3)))
					ac.setCuc(1);
			}
			DataSourceConfiguration.releaseSqlResources(rs, ps);
			// Lay thong tin truong bo phan
			sql = "select t1.ten ten_cb from ktnb_dm_phong t, ktnb_dm_can_bo t1 where t.ma=t1.ma_phong and t1.ma_chuc_vu=? and t1.ma_phong=?";
			ps = conn.prepareStatement(sql);
			if (KtnbUtil.isTongCuc(ac)) { // Vu truong
				ps.setString(1, "1101");
			} else if (KtnbUtil.isCuc(ac)) { // Truong phong
				ps.setString(1, "1113");
			} else
				// Doi truong
				ps.setString(1, "1117");
			ps.setString(2, ac.getMaPhong());
			rs = ps.executeQuery();
			if (rs.next()) {
				ac.setTenTruongPhong(rs.getString(1));
			}
			DataSourceConfiguration.releaseSqlResources(rs, ps);

			// Lay thong tin thu truong CQT
			sql = "select t1.ten_canbo from ktnb_dm_cqt t, ktnb_dm_can_bo_v t1 where t.ma=t1.ma_cqt and t1.ma_chuc_vu=? and t.ma=?";
			ps = conn.prepareStatement(sql);
			if (KtnbUtil.isTongCuc(ac)) {
				ps.setString(1, "1125");
			} else if (KtnbUtil.isCuc(ac)) {
				ps.setString(1, "1105");
			} else
				ps.setString(1, "1109");
			ps.setString(2, ac.getMaCqt());
			rs = ps.executeQuery();
			if (rs.next()) {
				ac.setTenThuTruong(rs.getString(1));
			}
			DataSourceConfiguration.releaseSqlResources(rs, ps);

			// Lay Danh sach nguoi ky
			String listNguoiKy = "";
			sql = "select t.ten_canbo from ktnb_dm_can_bo_v t where t.ma_cqt='" + ac.getMaCqt() + "'";
			if (KtnbUtil.isTongCuc(ac))
				sql += " and t.ma_chuc_vu in (" + Constants.LANH_DAO_TCT + ")";
			else if (KtnbUtil.isCuc(ac))
				sql += " and t.ma_chuc_vu in (" + Constants.LANH_DAO_CT + ")";
			else if (KtnbUtil.isChiCuc(ac))
				sql += " and t.ma_chuc_vu in (" + Constants.LANH_DAO_CCT + ")";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				listNguoiKy += rs.getString(1) + ",";
			}
			if (!Formater.isNull(listNguoiKy))
				ac.setListNguoiKy(listNguoiKy.substring(0, listNguoiKy.length() - 1));
			
			DataSourceConfiguration.releaseSqlResources(rs, ps);		
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new KtnbException(e);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return ac;
	}
	/**
	 * Xác thực đăng nhập
	 */
	public ApplicationContext authenticate(String user, String pass) throws KtnbException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ApplicationContext ac = null;
		String sql, macb, pwd, nhom, macqt, macuc, machucvu, dsCqt, dsCbQl;
		try {
			sql = "SELECT MA_CAN_BO,MAT_KHAU,ACTIVE,NHOM,MA_CQT,MA_CB FROM ktnb_nsd WHERE ten_nsd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			rs = ps.executeQuery();
			if (!rs.next())
				throw new Exception("Sai t&#234;n &#273;&#259;ng nh&#7853;p!");
			if (!"1".equals(rs.getString(3)))
				throw new Exception("Ng&#432;&#7901;i d&#249;ng b&#7883; kh&#243;a");
			macb = rs.getString(1);
			pwd = getHash(macb, pass);
			if (!pwd.equals(rs.getString(2)))
				throw new KtnbException("Sai m&#7853;t kh&#7849;u!", "Sai m&#7853;t kh&#7849;u!");
			ac = new ApplicationContext();
			ac.setMaCanbo(macb);
			ac.setTenNsd(user);
			nhom = rs.getString(4);
			if (!Formater.isNull(nhom))
				ac.setRole(nhom.split(","));
			// Quan ly CQT cap duoi
			dsCqt = rs.getString(5);
			if (!Formater.isNull(dsCqt))
				ac.setRoleData(dsCqt.split(","));
			// Quan ly can bo cap duoi
			dsCbQl = rs.getString(6);
			if (!Formater.isNull(dsCbQl))
				ac.setArrCb(dsCbQl.split(","));
			// Lay thong tin
			sql = "SELECT TEN_CANBO,MA_PHONG,TEN_PHONG,MA_CQT,TEN_CQT,ten_cqt_tat,ma_chuc_vu FROM ktnb_dm_can_bo_v WHERE MA_CANBO=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, macb);
			rs = ps.executeQuery();
			if (rs.next()) {
				macqt = rs.getString(4);
				macuc = macqt.substring(0, 3);
				machucvu = rs.getString(7);
				if (!Formater.isNull(nhom) && (nhom.indexOf(Constants.LANH_DAO) != -1 || nhom.indexOf(Constants.TRUONG_PHONG_KNTC) != -1))
					ac.setLanhDao(true);
				ac.setTenCanbo(rs.getString(1));
				ac.setMaPhong(rs.getString(2));
				ac.setTenPhong(rs.getString(3));
				ac.setMaCqt(macqt);
				ac.setTenCqt(rs.getString(5));
				ac.setTenCqtTat(rs.getString(6));
				ac.setMaChucvu(machucvu);
				ac.setTenChucvu(KtnbUtil.getTenChucVuByMa(machucvu));
				ac.setMaCuc(macuc);
				ac.setTenCuc(KtnbUtil.getTenTinhByMa(ac,macuc));
//				ac.setDiaBan(KtnbUtil.getDiaBan(ac, macqt));
				ac.setDiaBan(KtnbUtil.getTenTinhByMa(ac,macuc));
				if ("00000".equals(macqt))
					ac.setCuc(0);
				else if ("00".equals(macqt.substring(3)))
					ac.setCuc(1);
			}
			DataSourceConfiguration.releaseSqlResources(rs, ps);
			// Lay thong tin truong bo phan
			sql = "select t1.ten ten_cb from ktnb_dm_phong t, ktnb_dm_can_bo t1 where t.ma=t1.ma_phong and t1.ma_chuc_vu=? and t1.ma_phong=?";
			ps = conn.prepareStatement(sql);
			if (KtnbUtil.isTongCuc(ac)) { // Vu truong
				ps.setString(1, "1101");
			} else if (KtnbUtil.isCuc(ac)) { // Truong phong
				ps.setString(1, "1113");
			} else
				// Doi truong
				ps.setString(1, "1117");
			ps.setString(2, ac.getMaPhong());
			rs = ps.executeQuery();
			if (rs.next()) {
				ac.setTenTruongPhong(rs.getString(1));
			}
			DataSourceConfiguration.releaseSqlResources(rs, ps);

			// Lay thong tin thu truong CQT
			sql = "select t1.ten_canbo from ktnb_dm_cqt t, ktnb_dm_can_bo_v t1 where t.ma=t1.ma_cqt and t1.ma_chuc_vu=? and t.ma=?";
			ps = conn.prepareStatement(sql);
			if (KtnbUtil.isTongCuc(ac)) {
				ps.setString(1, "1125");
			} else if (KtnbUtil.isCuc(ac)) {
				ps.setString(1, "1105");
			} else
				ps.setString(1, "1109");
			ps.setString(2, ac.getMaCqt());
			rs = ps.executeQuery();
			if (rs.next()) {
				ac.setTenThuTruong(rs.getString(1));
			}
			DataSourceConfiguration.releaseSqlResources(rs, ps);

			// Lay Danh sach nguoi ky
			String listNguoiKy = "";
			sql = "select t.ten_canbo from ktnb_dm_can_bo_v t where t.ma_cqt='" + ac.getMaCqt() + "'";
			if (KtnbUtil.isTongCuc(ac))
				sql += " and t.ma_chuc_vu in (" + Constants.LANH_DAO_TCT + ")";
			else if (KtnbUtil.isCuc(ac))
				sql += " and t.ma_chuc_vu in (" + Constants.LANH_DAO_CT + ")";
			else if (KtnbUtil.isChiCuc(ac))
				sql += " and t.ma_chuc_vu in (" + Constants.LANH_DAO_CCT + ")";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				listNguoiKy += rs.getString(1) + ",";
			}
			if (!Formater.isNull(listNguoiKy))
				ac.setListNguoiKy(listNguoiKy.substring(0, listNguoiKy.length() - 1));
			
			DataSourceConfiguration.releaseSqlResources(rs, ps);		
			//Lay phien ban App
			sql = "select ten from ktnb_dm where ma ='"+Constants.VERSION_APP+"'";			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ac.setVersionApp(rs.getString(1));
			}
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		} catch (Exception e) {
			e.printStackTrace();
			throw new KtnbException(e);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return ac;
	}
	
	/**
	 * Xác thực đăng nhập BTC
	 */
	public ApplicationContext authenticateBtc(String username, String pass) throws KtnbException {
		ApplicationContext retval = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			//1. Lay connection den CSDL BMT
			//conn = DataSourceConfiguration.getConnection(DataSourceConfiguration.BMT_DATASOURCE);
			conn = DataSourceConfiguration.getConnection(Constants.DBNAME_BTC);	
			//2. Kiem tra username va password
			String sql = "SELECT btc_owner.btc_pck_bmht.Fnc_Check_Login(?, ?) FROM dual";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			String vTmp = "";
			if (rs.next()) {
				vTmp = rs.getString(1);
				if (!Formater.isNull(vTmp)) {
				} else {
					throw new KtnbException("Error when check UserName and PassWord!","ERROR");
				}
			} else {
				throw new KtnbException("Error when check UserName and PassWord!","ERROR");
			}
			DataSourceConfiguration.releaseSqlResources(rs, ps);			
			System.out.println("DANG NHAP THANH CONG!");
			retval = getInfor(username, pass);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new KtnbException(e);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}
	
	/**
	 * Xác thực đăng nhập BTC - Backup
	 */
	public ApplicationContext authenticateBtc_Backup(String username, String pass) throws KtnbException {
		ApplicationContext retval = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			//1. Lay connection den CSDL BMT
//			conn = DataSourceConfiguration.getConnection(DataSourceConfiguration.BMT_DATASOURCE);
			conn = DataSourceConfiguration.getConnection(Constants.DBNAME_BTC);	
			//2. Kiem tra username va password
			String sql = "SELECT btc_owner.btc_pck_bmht.Fnc_Check_Login(?, ?) FROM dual";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			String vTmp = "";
			if (rs.next()) {
				vTmp = rs.getString(1);
				if (!Formater.isNull(vTmp)) {
				} else {
					throw new KtnbException("Error when check UserName and PassWord!","ERROR");
				}
			} else {
				throw new KtnbException("Error when check UserName and PassWord!","ERROR");
			}
			DataSourceConfiguration.releaseSqlResources(rs, ps);
			// Lay thong tin quyen truy cap vao KTNB
			sql =
				"SELECT na.ten_file FROM btc_owner.btc_chuc_nang na "
					+ " where"
					+ " na.ma_ud='KTNB' and"
					+ " na.ma_chuc_nang in"
					+ " (SELECT c.ma_chuc_nang FROM btc_owner.btc_nhom_chuc_nang c"
					+ " where"
					+ " c.ma_nhom in (SELECT ma_nhom FROM btc_owner.btc_nsd_nhom n where n.ma_nsd=?)"
					+ " )";
			System.out.println("SQL quyen: "+sql);
			ps = conn.prepareStatement(sql);
			ps.setString(1, vTmp);
			rs = ps.executeQuery();
			System.out.println("SQL quyen DONE!");
			retval = new ApplicationContext();
			if (rs.next()) {
				String func = "";
				while(rs.next()){
					func += rs.getString(1) + ",";
				}
				System.out.println("Quyen: "+func);
				retval.setRole(func.split(","));
				System.out.println("User: "+username+" -- p: "+pass);
				this.getInfor(username, pass);				
				System.out.println("BAN CO QUYEN VAO UNG DUNG KTNB!");
			} else {
				throw new KtnbException("Error! Access denied!","ERROR");
			}
			DataSourceConfiguration.releaseSqlResources(rs, ps);
			System.out.println("DANG NHAP THANH CONG!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new KtnbException(e);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return retval;
	}
	
	/**
	 * Mã hóa mật khẩu
	 * 
	 * @param macb
	 * @param pass
	 * @return
	 * @throws Exception
	 */
	private String getHash(String macb, String pass) throws Exception {
		String result = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select ktnb_owner.ktnb_pck_util.get_hash(?,?) from dual";
			ps = conn.prepareStatement(sql);
			ps.setString(1, macb);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			if (rs.next())
				result = rs.getString(1);
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return result;
	}

	public String getSEQ(String seqName) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String result = null;
		try {
			String sql = "select " + seqName + ".nextval from dual";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next())
				result = rs.getString(1);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return result;
	}

	/**
	 * Cập nhật danh mục
	 */
	public void updateDM(String ma, String ten) throws Exception {
		PreparedStatement ps = null;
		try {
			String sql = "update ktnb_dm set ten=? where ma=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ten);
			ps.setString(2, ma);
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps);
		}
	}

	/**
	 * Thay đổi vị trí danh mục
	 */
	public void moveDM(String ma, String newParentId) throws Exception {
		PreparedStatement ps = null;
		try {
			String sql = "update ktnb_dm set parent_id=? where ma=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newParentId);
			ps.setString(2, ma);
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps);
		}
	}

	/**
	 * Tạo mới danh mục
	 */
	public String insertDM(String parentId, String ten) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String ma = null;
		try {
			int rc = 0;
			String sql = "select nvl(max(to_number(ma)),0) from ktnb_dm where parent_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, parentId);
			rs = ps.executeQuery();
			if (rs.next())
				rc = rs.getInt(1);
			ma = (rc > 0) ? (String.valueOf(rc + 2)) : (parentId + "01");
			sql = "insert into ktnb_dm (ma,ten,parent_id) values (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ma);
			ps.setString(2, ten);
			ps.setString(3, parentId);
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return ma;
	}

	/**
	 * Cập nhật danh mục phòng
	 */
	public void updDMPhong(JSONObject jo) throws Exception {
		PreparedStatement ps = null;
		String sql, ma, ten;
		try {
			ma = (String) jo.get("ma");
			ten = (String) jo.get("ten");
			if (Formater.isNull(ten))
				throw new IllegalArgumentException("Ph\u1EA3i nh\u1EADp t\u00EAn!");
			sql = "update ktnb_dm_phong set ten=? where ma=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ten);
			ps.setString(2, ma);
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps);
		}
	}

	/**
	 * Thêm mới danh mục phòng
	 */
	public void insDMPhong(String macqt, JSONObject jo) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String ma = null, sql, ten;
		try {
			ten = (String) jo.get("ten");
			if (Formater.isNull(ten))
				throw new IllegalArgumentException("Ph\u1EA3i nh\u1EADp t\u00EAn!");
			// String sql = "select nvl(max(to_number(ma)),0) from ktnb_dm where
			// parent_id=?";
			if (macqt.equals("*"))
				macqt = "00000";
			sql = "select lpad(nvl(max(to_number(substr(ma,6))),0)+1,2,'0') from ktnb_dm_phong where MA_CQT=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, macqt);
			rs = ps.executeQuery();
			if (rs.next())
				ma = macqt + rs.getString(1);
			sql = "insert into ktnb_dm_phong (MA,TEN,MA_CQT) values (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ma);
			ps.setString(2, ten);
			ps.setString(3, macqt);
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
	}

	/**
	 * Lấy danh sách cuộc thanh tra kiểm tra
	 */
	public JSONObject getDsCuocTTKT(SearchStoreVO searchStoreVO) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			JSONArray jsonArray = new JSONArray();
			String status = searchStoreVO.status;
			String hinhthuc_ttkt = searchStoreVO.hinhthuc_ttkt;
			String loai_ttkt = searchStoreVO.loai_ttkt;
			String ma_dv_ttkt = searchStoreVO.ma_dv_ttkt;
			String noidung_ttkt = searchStoreVO.noidung_ttkt;
			String tu_ngay = searchStoreVO.tu_ngay;
			String den_ngay = searchStoreVO.den_ngay;
			String macqt = searchStoreVO.macqt;
			String sort = searchStoreVO.sort;
			String dir = searchStoreVO.dir;
			String ma_ttkt = searchStoreVO.ma_ttkt;
			int rc = 0, i = 1;
			if (!Formater.isNull(ma_ttkt))
				ma_ttkt = "%" + ma_ttkt.trim() + "%";
			StringBuffer sb = new StringBuffer("select count(*) from TTKT_KH_CUOC_TTKT a where a.ID_DON_VI_TH=?");
			if (!Formater.isNull(ma_dv_ttkt))
				sb.append(" and a.ID_DON_VI_BI=?");
			if (!Formater.isNull(ma_ttkt))
				sb.append(" and a.MA like ?");
			if (!Formater.isNull(status))
				sb.append(" and a.TRANG_THAI=?");
			if (!Formater.isNull(hinhthuc_ttkt))
				sb.append(" and a.HINH_THUC=?");
			if (!Formater.isNull(loai_ttkt))
				sb.append(" and a.LOAI=?");
			if (!Formater.isNull(tu_ngay))
				sb.append(" and a.NIEN_DO_TU_NGAY<=?");
			if (!Formater.isNull(den_ngay))
				sb.append(" and a.NIEN_DO_DEN_NGAY<=?");
			if (!Formater.isNull(noidung_ttkt))
				sb.append(" and exists (select 1 from TTKT_KH_NOI_DUNG_TTKT where ID_CUOC_TTKT=a.ID and ID_NOI_DUNG in (" + noidung_ttkt + "))");
			// System.out.println(sb.toString());
			ps = conn.prepareStatement(sb.toString());
			ps.setString(i++, macqt);
			if (!Formater.isNull(ma_dv_ttkt))
				ps.setString(i++, ma_dv_ttkt);
			if (!Formater.isNull(ma_ttkt))
				ps.setString(i++, ma_ttkt);
			if (!Formater.isNull(status))
				ps.setString(i++, status);
			if (!Formater.isNull(hinhthuc_ttkt))
				ps.setString(i++, hinhthuc_ttkt);
			if (!Formater.isNull(loai_ttkt))
				ps.setString(i++, loai_ttkt);
			if (!Formater.isNull(tu_ngay))
				ps.setDate(i++, Formater.str2SQLdate(tu_ngay));
			if (!Formater.isNull(den_ngay))
				ps.setDate(i++, Formater.str2SQLdate(den_ngay));
			rs = ps.executeQuery();
			if (rs.next())
				rc = rs.getInt(1);
			if (rc > 0) {
				i = 1;
				int limit = searchStoreVO.limit, start = searchStoreVO.start;
				sb = new StringBuffer("select * from (select rownum rn,z.* from (select a.ID,a.MA,a.LOAI,a.HINH_THUC,a.TRANG_THAI,a.TEN_DON_VI_BI,to_char(a.NIEN_DO_TU_NGAY,'dd/mm/yy')||'-'||to_char(a.NIEN_DO_DEN_NGAY,'dd/mm/yy')  from TTKT_KH_CUOC_TTKT a where a.ID_DON_VI_TH=?");
				if (!Formater.isNull(ma_dv_ttkt))
					sb.append(" and a.ID_DON_VI_BI=?");
				if (!Formater.isNull(ma_ttkt))
					sb.append(" and a.MA like ?");
				if (!Formater.isNull(status))
					sb.append(" and a.TRANG_THAI=?");
				if (!Formater.isNull(hinhthuc_ttkt))
					sb.append(" and a.HINH_THUC=?");
				if (!Formater.isNull(loai_ttkt))
					sb.append(" and a.LOAI=?");
				if (!Formater.isNull(tu_ngay))
					sb.append(" and a.NIEN_DO_TU_NGAY<=?");
				if (!Formater.isNull(den_ngay))
					sb.append(" and a.NIEN_DO_DEN_NGAY<=?");
				if (!Formater.isNull(noidung_ttkt))
					sb.append(" and exists (select 1 from TTKT_KH_NOI_DUNG_TTKT where ID_CUOC_TTKT=a.ID and ID_NOI_DUNG in (" + noidung_ttkt + "))");
				sb.append(" order by " + sort + " ");
				if (!Formater.isNull(dir))
					sb.append(dir);
				sb.append(") z where rownum<=?) where rn>=?");
				// System.out.println(sb.toString());
				ps = conn.prepareStatement(sb.toString());
				ps.setString(i++, macqt);
				if (!Formater.isNull(ma_dv_ttkt))
					ps.setString(i++, ma_dv_ttkt);
				if (!Formater.isNull(ma_ttkt))
					ps.setString(i++, ma_ttkt);
				if (!Formater.isNull(status))
					ps.setString(i++, status);
				if (!Formater.isNull(hinhthuc_ttkt))
					ps.setString(i++, hinhthuc_ttkt);
				if (!Formater.isNull(loai_ttkt))
					ps.setString(i++, loai_ttkt);
				if (!Formater.isNull(tu_ngay))
					ps.setDate(i++, Formater.str2SQLdate(tu_ngay));
				if (!Formater.isNull(den_ngay))
					ps.setDate(i++, Formater.str2SQLdate(den_ngay));
				ps.setInt(i++, start + limit);
				ps.setInt(i++, start + 1);
				rs = ps.executeQuery();
				JSONObject jsonObj;
				while (rs.next()) {
					jsonObj = new JSONObject();
					jsonObj.put("id", rs.getString(2));
					jsonObj.put("ma", rs.getString(3));
					jsonObj.put("loai", rs.getString(4));
					jsonObj.put("hinh_thuc", rs.getString(5));
					jsonObj.put("trang_thai", rs.getString(6));
					jsonObj.put("ten_don_vi_bi", rs.getString(7));
					jsonObj.put("nien_do", rs.getString(8));
					jsonArray.add(jsonObj);
				}
			}
			jsonResult.put("total", new Integer(rc));
			jsonResult.put("data", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	/**
	 * Lấy danh sách cán bộ
	 */
	public JSONObject getDsCanBo(SearchStoreVO searchStoreVO) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			JSONArray jsonArray = new JSONArray();
			String status = searchStoreVO.status;
			String macuc = searchStoreVO.macuc;
			String macqt = searchStoreVO.macqt;
			String maphong = searchStoreVO.maphong;
			String query = searchStoreVO.query;
			String sort = searchStoreVO.sort;
			String dir = searchStoreVO.dir;
			boolean search = false, searchAllCqt = false, searchAllPhong = false;
			int rc = 0, i = 1;
			if (!Formater.isNull(query)) {
				search = true;
				query = "%" + query.trim().toUpperCase() + "%";
			}
			if ("*".equals(macqt))
				searchAllCqt = true;
			if ("*".equals(maphong))
				searchAllPhong = true;
			StringBuffer sb = new StringBuffer("select count(*) from ktnb_dm_can_bo_v a where 1=1");
			if (searchAllPhong) {
				if (searchAllCqt)
					sb.append(" and a.ma_cqt like ?");
				else
					sb.append(" and a.ma_cqt=?");
			} else {
				sb.append(" and a.MA_PHONG=?");
			}
			if (search)
				sb.append(" and upper(a.TEN_CANBO) like ?");
			if ("is_user".equals(status))
				sb.append(" and exists (select 1 from ktnb_nsd where ngay_het_hluc is null and MA_CAN_BO=a.MA_CANBO)");
			else if ("is_locked_user".equals(status))
				sb.append(" and exists (select 1 from ktnb_nsd where ngay_het_hluc is not null and MA_CAN_BO=a.MA_CANBO)");
			else if ("is_not_user".equals(status))
				sb.append(" and not exists (select 1 from ktnb_nsd where MA_CAN_BO=a.MA_CANBO)");
			else if ("is_effect".equals(status))
				sb.append(" and a.NGAY_HLUC_DEN is null");
			else if ("is_not_effect".equals(status))
				sb.append(" and a.NGAY_HLUC_DEN is not null");
			// System.out.println(sb.toString());
			ps = conn.prepareStatement(sb.toString());
			if (searchAllPhong) {
				if (searchAllCqt)
					ps.setString(i++, macuc + "%");
				else
					ps.setString(i++, macqt);
			} else
				ps.setString(i++, maphong);
			if (search)
				ps.setString(i++, query);
			rs = ps.executeQuery();
			if (rs.next())
				rc = rs.getInt(1);
			if (rc > 0) {
				sb = new StringBuffer("select * from (select rownum rn,z.* from (select a.MA_CANBO,a.TEN_CANBO,a.MA_PHONG,a.TEN_PHONG,a.MA_CQT,a.TEN_CQT,to_char(a.NGAY_HLUC_TU,'dd/mm/yy'),to_char(a.NGAY_HLUC_DEN,'dd/mm/yy'),a.MA_CHUC_VU,");
				if ("is_user".equals(status))
					sb.append("b.TEN_NSD from ktnb_dm_can_bo_v a,ktnb_nsd b where a.MA_CANBO=b.MA_CAN_BO and b.ngay_het_hluc is null");
				else if ("is_locked_user".equals(status))
					sb.append("b.TEN_NSD from ktnb_dm_can_bo_v a,ktnb_nsd b where a.MA_CANBO=b.MA_CAN_BO and b.ngay_het_hluc is not null");
				else {
					sb.append("null TEN_NSD from ktnb_dm_can_bo_v a where 1=1");
					if ("is_not_user".equals(status))
						sb.append(" and not exists (select 1 from ktnb_nsd where MA_CAN_BO=a.MA_CANBO)");
					else if ("is_effect".equals(status))
						sb.append(" and a.NGAY_HLUC_DEN is null");
					else if ("is_not_effect".equals(status))
						sb.append(" and a.NGAY_HLUC_DEN is not null");
				}
				if (searchAllPhong) {
					if (searchAllCqt)
						sb.append(" and a.ma_cqt like ?");
					else
						sb.append(" and a.ma_cqt=?");
				} else {
					sb.append(" and a.MA_PHONG=?");
				}
				if (search)
					sb.append(" and upper(a.TEN_CANBO) like ?");
				sb.append(" and a.ten_canbo <>'INTERNAL'");
				sb.append(" order by " + sort + " ");
				if (!Formater.isNull(dir))
					sb.append(dir);
				sb.append(") z where rownum<=?) where rn>=?");
				// System.out.println(sb.toString());
				ps = conn.prepareStatement(sb.toString());
				i = 1;
				int limit = searchStoreVO.limit, start = searchStoreVO.start;
				if (searchAllPhong) {
					if (searchAllCqt)
						ps.setString(i++, macuc + "%");
					else
						ps.setString(i++, macqt);
				} else {
					ps.setString(i++, maphong);
				}
				if (search)
					ps.setString(i++, query);
				ps.setInt(i++, start + limit);
				ps.setInt(i++, start + 1);
				rs = ps.executeQuery();
				JSONObject jsonObj;
				String ma_chucvu;
				while (rs.next()) {
					jsonObj = new JSONObject();
					jsonObj.put("ma_canbo", rs.getString(2));
					jsonObj.put("ten_canbo", rs.getString(3));
					jsonObj.put("ma_phong", rs.getString(4));
					jsonObj.put("ten_phong", rs.getString(5));
					jsonObj.put("ma_cqt", rs.getString(6));
					jsonObj.put("ten_cqt", rs.getString(7));
					jsonObj.put("ngay_hluc_tu", rs.getString(8));
					jsonObj.put("ngay_hluc_den", rs.getString(9));
					ma_chucvu = rs.getString(10);
					jsonObj.put("ten_chucvu", KtnbUtil.getTenChucVuByMa(ma_chucvu));
					jsonObj.put("ten_nsd", rs.getString(11));
					jsonArray.add(jsonObj);
				}
			}
			jsonResult.put("total", new Integer(rc));
			jsonResult.put("data", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	/**
	 * Cập nhật danh mục thời hạn
	 */
	public void updateDMTime(JSONObject jo) throws Exception {
		PreparedStatement ps = null;
		try {
			String ma = (String) jo.get("ma");
			Long thoigian = (Long) jo.get("thoigian");
			String sql = "delete ktnb_dm_time where pid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ma);
			ps.executeUpdate();
			sql = "insert into ktnb_dm_time values (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ma);
			ps.setString(2, "0");
			ps.setInt(3, thoigian.intValue());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps);
		}
	}

	/**
	 * Lấy thông tin quản lý địa bàn
	 */
	public JSONObject getRoleByUserByCqt(String parentId) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			String sql = "select ma_cqt from ktnb_nsd where ma_can_bo=?";
			ps = conn.prepareStatement(sql);
			//ps.setString(1, parentId);
			rs = ps.executeQuery();
			String id = null, nhom = null, role = null;
			if (rs.next())
				nhom = rs.getString(1);
			Collection c = (Collection) KtnbCache.getInstance().get("DM_CQT_TT");
			JSONArray jsonArray = new JSONArray();
			CategoryVO categoryVO;
			JSONObject jsonObject;
			if (Formater.isNull(nhom)) {
				for (Iterator iter = c.iterator(); iter.hasNext();) {
					jsonObject = new JSONObject();
					categoryVO = (CategoryVO) iter.next();
					jsonObject.put("id", categoryVO.getId());
					jsonObject.put("name", categoryVO.getName());
					jsonObject.put("role", role);
					jsonArray.add(jsonObject);
				}
			} else {
				for (Iterator iter = c.iterator(); iter.hasNext();) {
					jsonObject = new JSONObject();
					categoryVO = (CategoryVO) iter.next();
					id = categoryVO.getId();
					role = (nhom.indexOf(id) > -1) ? "1" : null;
					jsonObject.put("id", id);
					jsonObject.put("name", categoryVO.getName());
					jsonObject.put("role", role);
					jsonArray.add(jsonObject);
				}
			}
			jsonResult.put("data", jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	/**
	 * Lấy thông tin quyền người sử dụng
	 */
	public JSONObject getRoleByUser(String parentId) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			String sql = "select nhom from ktnb_nsd where ma_can_bo=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, parentId);
			rs = ps.executeQuery();
			String id = null, nhom = null, role = null;
			if (rs.next())
				nhom = rs.getString(1);
			Collection c = (Collection) KtnbCache.getInstance().get("LOV_ROLE");
			JSONArray jsonArray = new JSONArray();
			CategoryVO categoryVO;
			JSONObject jsonObject;
			if (Formater.isNull(nhom)) {
				for (Iterator iter = c.iterator(); iter.hasNext();) {
					jsonObject = new JSONObject();
					categoryVO = (CategoryVO) iter.next();
					jsonObject.put("id", categoryVO.getId());
					jsonObject.put("name", categoryVO.getName());
					jsonObject.put("role", role);
					jsonArray.add(jsonObject);
				}
			} else {
				for (Iterator iter = c.iterator(); iter.hasNext();) {
					jsonObject = new JSONObject();
					categoryVO = (CategoryVO) iter.next();
					id = categoryVO.getId();
					role = (nhom.indexOf(id) > -1) ? "1" : null;
					jsonObject.put("id", id);
					jsonObject.put("name", categoryVO.getName());
					jsonObject.put("role", role);
					jsonArray.add(jsonObject);
				}
			}
			jsonResult.put("data", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	/**
	 * Lấy danh sách thời hạn dùng cho lịch trình dự kiến
	 */
	public JSONObject getDsTime(SearchStoreVO searchStoreVO) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			String parentId = searchStoreVO.parentId;
			if (Formater.isNull(parentId))
				parentId = "*";
			StringBuffer sb = new StringBuffer("select a.ma,a.ten,b.thoigian from ktnb_dm a,ktnb_dm_time b where a.parent_id like ? and a.ma=b.pid(+) order by a.ma");
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, parentId + "%");
			rs = ps.executeQuery();
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObj;
			int rc = 0;
			while (rs.next()) {
				jsonObj = new JSONObject();
				jsonObj.put("ma", rs.getString(1));
				jsonObj.put("ten", rs.getString(2));
				jsonObj.put("thoigian", rs.getString(3));
				jsonArray.add(jsonObj);
				rc++;
			}
			jsonResult.put("total", new Integer(rc));
			jsonResult.put("data", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	/**
	 * Lấy danh sách cơ quan thuế
	 */
	public JSONObject getDsCqt(SearchStoreVO searchStoreVO) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			JSONArray jsonArray = new JSONArray();
			String parentId = searchStoreVO.parentId;
			if (Formater.isNull(parentId))
				parentId = "*";
			String query = searchStoreVO.query;
			String sort = searchStoreVO.sort;
			String dir = searchStoreVO.dir;
			boolean search = false;
			if (!Formater.isNull(query)) {
				search = true;
				query = "%" + query.trim().toUpperCase() + "%";
			}
			int rc = 0, i = 1;
			StringBuffer sb = new StringBuffer("select count(*) from ktnb_dm_cqt where 1=1");
			if (!"*".equals(parentId))
				sb.append(" and ma like ?");
			if (search)
				sb.append(" and (upper(ten) like ? or ma like ?)");
			ps = conn.prepareStatement(sb.toString());
			if (!"*".equals(parentId))
				ps.setString(i++, parentId + "%");
			if (search) {
				ps.setString(i++, query);
				ps.setString(i++, query);
			}
			rs = ps.executeQuery();
			if (rs.next())
				rc = rs.getInt(1);
			if (rc > 0) {
				sb = new StringBuffer("select * from (select  rownum rn,z.* from (select ma,ten from ktnb_dm_cqt where 1=1");
				if (!"*".equals(parentId))
					sb.append(" and ma like ?");
				if (search)
					sb.append(" and (upper(ten) like ? or ma like ?)");
				sb.append(" order by " + sort + " ");
				if (!Formater.isNull(dir))
					sb.append(dir);
				sb.append(") z where rownum<=?) where rn>=?");
				ps = conn.prepareStatement(sb.toString());
				i = 1;
				int limit = searchStoreVO.limit, start = searchStoreVO.start;
				if (!"*".equals(parentId))
					ps.setString(i++, parentId + "%");
				if (search) {
					ps.setString(i++, query);
					ps.setString(i++, query);
				}
				ps.setInt(i++, start + limit);
				ps.setInt(i++, start + 1);
				rs = ps.executeQuery();
				JSONObject jsonObj;
				while (rs.next()) {
					jsonObj = new JSONObject();
					jsonObj.put("ma", rs.getString(2));
					jsonObj.put("ten", rs.getString(3));
					jsonArray.add(jsonObj);
				}
			}
			jsonResult.put("total", new Integer(rc));
			jsonResult.put("data", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	/**
	 * Lấy danh sách phòng
	 */
	public JSONObject getDsPhong(SearchStoreVO searchStoreVO) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			JSONArray jsonArray = new JSONArray();
			String macuc = searchStoreVO.macuc;
			String macqt = searchStoreVO.macqt;
			String query = searchStoreVO.query;
			String sort = searchStoreVO.sort;
			String dir = searchStoreVO.dir;
			boolean search = false, searchAll = false;
			if ("*".equals(macqt))
				searchAll = true;
			int rc = 0, i = 1;
			if (!Formater.isNull(query)) {
				search = true;
				query = "%" + query.trim().toUpperCase() + "%";
			}
			StringBuffer sb = new StringBuffer("select count(*) from ktnb_dm_phong where ma_cqt");
			if (searchAll)
				sb.append(" like ?");
			else
				sb.append("=?");
			if (search)
				sb.append(" and (upper(ten) like ? or ma like ?)");
			ps = conn.prepareStatement(sb.toString());
			if (searchAll)
				ps.setString(i++, macuc + "%");
			else
				ps.setString(i++, macqt);
			if (search) {
				ps.setString(i++, query);
				ps.setString(i++, query);
			}
			rs = ps.executeQuery();
			if (rs.next())
				rc = rs.getInt(1);
			if (rc > 0) {
				sb = new StringBuffer("select * from (select rownum rn,z.* from (select ma,ten,ma_cqt,ten_cqt from ktnb_dm_phong_v where ma_cqt");
				if (searchAll)
					sb.append(" like ?");
				else
					sb.append("=?");
				if (search)
					sb.append(" and (upper(ten) like ? or ma like ?)");
				sb.append(" order by " + sort + " ");
				if (!Formater.isNull(dir))
					sb.append(dir);
				sb.append(") z where rownum<=?) where rn>=?");
				ps = conn.prepareStatement(sb.toString());
				// System.out.println(sb.toString());
				i = 1;
				int limit = searchStoreVO.limit, start = searchStoreVO.start;
				if (searchAll)
					ps.setString(i++, macuc + "%");
				else
					ps.setString(i++, macqt);
				if (search) {
					ps.setString(i++, query);
					ps.setString(i++, query);
				}
				ps.setInt(i++, start + limit);
				ps.setInt(i++, start + 1);
				rs = ps.executeQuery();
				JSONObject jsonObj;
				while (rs.next()) {
					jsonObj = new JSONObject();
					jsonObj.put("ma", rs.getString(2));
					jsonObj.put("ten", rs.getString(3));
					jsonObj.put("ma_cqt", rs.getString(4));
					jsonObj.put("ten_cqt", rs.getString(5));
					jsonArray.add(jsonObj);
				}
			}
			jsonResult.put("total", new Integer(rc));
			jsonResult.put("data", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	/**
	 * Lấy danh sách tỉnh
	 */
	public JSONObject getDsTinh(SearchStoreVO searchStoreVO) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			JSONArray jsonArray = new JSONArray();
			String query = searchStoreVO.query;
			String sort = searchStoreVO.sort;
			String dir = searchStoreVO.dir;
			boolean search = false;
			int rc = 0;
			if (!Formater.isNull(query)) {
				search = true;
				query = "%" + query.trim().toUpperCase() + "%";
			}
			StringBuffer sb = new StringBuffer("select count(*) from ktnb_dm_tinh where ma!='000'");
			if (search)
				sb.append(" and upper(ten) like ?");
			ps = conn.prepareStatement(sb.toString());
			if (search)
				ps.setString(1, query);
			rs = ps.executeQuery();
			if (rs.next())
				rc = rs.getInt(1);
			if (rc > 0) {
				sb = new StringBuffer("select * from (select rownum rn,z.* from (select ma,ten from ktnb_dm_tinh where ma!='000'");
				if (search)
					sb.append(" and upper(ten) like ?");
				sb.append(" order by " + sort + " ");
				if (!Formater.isNull(dir))
					sb.append(dir);
				sb.append(") z where rownum<=?) where rn>=?");
				ps = conn.prepareStatement(sb.toString());
				int i = 1, limit = searchStoreVO.limit, start = searchStoreVO.start;
				if (search)
					ps.setString(i++, query);
				ps.setInt(i++, start + limit);
				ps.setInt(i++, start + 1);
				rs = ps.executeQuery();
				JSONObject jSONObject;
				while (rs.next()) {
					jSONObject = new JSONObject();
					jSONObject.put("id", rs.getString(2));
					jSONObject.put("name", rs.getString(3));
					jsonArray.add(jSONObject);
				}
			}
			jsonResult.put("total", new Integer(rc));
			jsonResult.put("data", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	/**
	 * Lấy danh sách cục thuế
	 */
	public JSONObject getDsCucThue(SearchStoreVO searchStoreVO) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			String query = searchStoreVO.query;
			boolean search = false;
			if (!Formater.isNull(query)) {
				search = true;
				query = "%" + query.trim().toUpperCase() + "%";
			}
			StringBuffer sb = new StringBuffer("select ma,ten from ktnb_dm_tinh where 1=1");
			if (search)
				sb.append(" and upper(ten) like ?");
			sb.append(" order by ten ");
			ps = conn.prepareStatement(sb.toString());
			if (search)
				ps.setString(1, query);
			rs = ps.executeQuery();
			JSONArray jsonArray = new JSONArray();
			JSONObject jSONObject;
			/*
			 * if (all) { jSONObject = new JSONObject();
			 * jSONObject.put("id","*"); jSONObject.put("name",Constants.TATCA);
			 * jsonArray.add(jSONObject); }
			 */
			while (rs.next()) {
				jSONObject = new JSONObject();
				jSONObject.put("id", rs.getString(1));
				jSONObject.put("name", rs.getString(2));
				jsonArray.add(jSONObject);
			}
			jsonResult.put("data", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	/**
	 * Lấy danh sách DB
	 */
	public JSONObject getDsDB() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			String sql = "select ma from ktnb_dblink order by ma";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			String ma;
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObj;
			while (rs.next()) {
				ma = rs.getString(1);
				jsonObj = new JSONObject();
				jsonObj.put("id", ma);
				jsonObj.put("name", ma);
				jsonArray.add(jsonObj);
			}
			jsonResult.put("data", jsonArray);
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	/**
	 * Lấy ra cây danh mục hoặc trạng thái hoặc phân loại KNTC
	 */
	public JSONObject getTree(String pma, boolean check) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = null;
		try {
			String sql = "select ma,ten,parent_id from ktnb_dm start with parent_id=? and hien_thi=1 and ngay_het_hl is null CONNECT by prior ma=parent_id and hien_thi = '1' and ngay_het_hl is null order by ma";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pma);
			rs = ps.executeQuery();
			String ma, ten, parentId;
			Map map = (HashMap) KtnbCache.getInstance().get("MAP_DSDM");
			Node node, parentNode;
			node = new Node(pma, (String) map.get(pma));
			map = new HashMap();
			map.put(pma, node);
			while (rs.next()) {
				ma = rs.getString(1);
				ten = rs.getString(2);
				parentId = rs.getString(3);
				node = new Node(ma, ten);
				map.put(ma, node);
				parentNode = (Node) map.get(parentId);
				parentNode.addChild(node);
				map.put(parentId, parentNode);
			}
			node = (Node) map.get(pma);
			jsonResult = node.toJson(check);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	/**
	 * Lấy ra cây cơ quan Thuế từ Database
	 * 
	 */
	public JSONObject getTreeCqt_db(String pma) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = null;
		try {
			String sql = "select ma,ten,ma_cha from ktnb_dm_cqt where ma=? union all select ma,ten,ma_cha from ktnb_dm_cqt start with ma_cha=? CONNECT by prior ma=ma_cha order by ma";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pma);
			ps.setString(2, pma);
			rs = ps.executeQuery();
			Map map = (HashMap) KtnbCache.getInstance().get("MAP_CQT");
			Node node, parentNode;
			node = new Node(pma, (String) map.get(pma));
			map = new HashMap();
			map.put(pma, node);
			String ma, ten, parentId;
			while (rs.next()) {
				ma = rs.getString(1);
				ten = rs.getString(2);
				parentId = rs.getString(3);
				node = new Node(ma, ten);
				map.put(ma, node);
				try {
					parentNode = (Node) map.get(parentId);
					parentNode.addChild(node);
					map.put(parentId, parentNode);
				} catch (Exception e) {
				}
			}
			node = (Node) map.get(pma);
			jsonResult = node.toJson(true);
			// System.out.println(jsonResult.size());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	/***
	 * Lấy ra cây cơ quan thuế từ Cache
	 */
	public JSONObject getTreeCqt(String pma) throws Exception {
		JSONObject jsonResult = null;
		try {
			Map mapCQT = (HashMap) KtnbCache.getInstance().get("MAP_CQT");
			Node node, parentNode;
			node = new Node(pma, (String) mapCQT.get(pma));
			// Load From Cache
			Map map = new HashMap();
			map.put(pma, node);
			String ma, ten, parentId;
			Iterator iterator = mapCQT.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry mapEntry = (Map.Entry) iterator.next();
				Collection subMap = (ArrayList) mapEntry.getValue();
				Iterator subIterator = subMap.iterator();
				while (subIterator.hasNext()) {
					CategoryVO vo = (CategoryVO) subIterator.next();
					if (vo.getId().equals(pma)) {
						((Node) map.get(pma)).setText(vo.getName());
						break;
					}
					ma = vo.getId();
					ten = vo.getName();
					parentId = vo.getUrl();
					node = new Node(ma, ten);
					map.put(ma, node);
					parentNode = (Node) map.get(parentId);
					if (parentNode != null) {
						parentNode.addChild(node);
						map.put(parentId, parentNode);
					}
				}
			}

			node = (Node) map.get(pma);
			jsonResult = node.toJson(true);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return jsonResult;
	}

	/**
	 * Lấy ra cây danh mục phân loại KNTC
	 */
	public JSONObject getTree(String pma, String maHs, String loaiRls) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = null;
		// String strCheck = "";
		ArrayList strCheck = new ArrayList();
		try {
			String sql = "select ma,ten,parent_id from ktnb_dm start with parent_id=? CONNECT by prior ma=parent_id and hien_thi=1";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pma);

			String sqlCheck = "select MA_DM from KNTC_DM_RLS where MA_HS =? and LOAI_RLS=?";
			PreparedStatement psCheck = conn.prepareStatement(sqlCheck);
			psCheck.setString(1, maHs);
			psCheck.setString(2, loaiRls);
			ResultSet rsCheck = psCheck.executeQuery();
			while (rsCheck.next()) {
				strCheck.add(rsCheck.getString(1));
				// strCheck += rsCheck.getString(1) + ",";
			}
			rsCheck.close();
			psCheck.close();
			Map map = (HashMap) KtnbCache.getInstance().get("MAP_DSDM");
			Node node, parentNode;
			node = new Node(pma, (String) map.get(pma));
			map = new HashMap();
			map.put(pma, node);
			rs = ps.executeQuery();
			while (rs.next()) {
				String ma, ten, parentId;
				ma = rs.getString(1);
				ten = rs.getString(2);
				parentId = rs.getString(3);
				boolean checked = false;
				if (strCheck.contains(ma))
					// if (strCheck.indexOf(ma) != -1)
					checked = true;
				node = new Node(ma, ten, checked);
				map.put(ma, node);
				parentNode = (Node) map.get(parentId);
				parentNode.addChild(node);
				map.put(parentId, parentNode);
			}
			node = (Node) map.get(pma);
			jsonResult = node.toJson();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	/**
	 * Lấy ra danh sách cán bộ
	 */
	public Collection lovCanBo(SearchVO searchVO) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection c = new ArrayList();
		try {
			String macqt = searchVO.macqt;
			String maphong = searchVO.maphong;
			String ten = searchVO.ten;
			String sql = "select * from (select rownum rn,z.* from (select MA_CANBO,TEN_CANBO,MA_PHONG,TEN_PHONG from ktnb_dm_can_bo_v where ma_phong";
			if ("*".equals(maphong))
				sql += " like  ?";
			else
				sql += "=?";
			if (!Formater.isNull(ten))
				sql += " and upper(TEN_CANBO) like ?";
			sql += " order by TEN_CANBO) z where rownum<=?) where rn>=?";
			ps = conn.prepareStatement(sql);
			int i = 1;
			if ("*".equals(maphong))
				ps.setString(i++, macqt + "%");
			else
				ps.setString(i++, maphong);
			if (!Formater.isNull(ten))
				ps.setString(i++, "%" + ten.trim().toUpperCase() + "%");
			ps.setInt(i++, searchVO.getToRow());
			ps.setInt(i++, searchVO.getFromRow());
			rs = ps.executeQuery();
			DetailInformation detailInformation = null;
			while (rs.next()) {
				detailInformation = new DetailInformation();
				detailInformation.setCol2(rs.getString(2));
				detailInformation.setCol3(rs.getString(3));
				detailInformation.setCol4(rs.getString(4));
				detailInformation.setCol5(rs.getString(5));
				c.add(detailInformation);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return c;
	}

	/**
	 * Lấy ra danh sách các ngày nghỉ trong năm
	 */
	public Collection getNgayNghi(String year) throws Exception {
		Collection ret = new ArrayList();
		PreparedStatement ps = null;
		ResultSet rs = null;
		// JSONObject jsonResult = null;
		try {
			String sql = "select ngay_nghi from ktnb_dm_ngay_nghi where nam=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, year);
			rs = ps.executeQuery();
			while (rs.next()) {
				ret.add(rs.getDate("ngay_nghi"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return ret;
	}

	/**
	 * Lấy ra danh sách các ngày nghỉ theo khoảng năm
	 */
	public Collection getNgayNghi(String startYear, String endYear) throws Exception {
		Collection ret = new ArrayList();
		PreparedStatement ps = null;
		ResultSet rs = null;
		// JSONObject jsonResult = null;
		try {
			String sql = "select ngay_nghi from ktnb_dm_ngay_nghi where nam between ? and ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, startYear);
			ps.setString(2, endYear);
			rs = ps.executeQuery();
			while (rs.next()) {
				ret.add(rs.getDate("ngay_nghi"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return ret;
	}

	/**
	 * Get danh sách ngày nghỉ theo năm
	 */
	public JSONObject getDsNgayNghi(SearchStoreVO searchStoreVO) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			String nam = searchStoreVO.nam;
			String querry = "select t.MA,t.NGAY_NGHI,t.MO_TA from KTNB_OWNER.KTNB_DM_NGAY_NGHI t where t.NAM = " + nam + " order by NGAY_NGHI";
			ps = conn.prepareStatement(querry);
			rs = ps.executeQuery();
			JSONArray jsonArray = new JSONArray();
			JSONObject jSONObject;
			while (rs.next()) {
				jSONObject = new JSONObject();
				jSONObject.put("ma", rs.getString(1));
				jSONObject.put("ngay_nghi", Formater.date2str(rs.getDate(2)));
				jSONObject.put("mo_ta", rs.getString(3));
				jsonArray.add(jSONObject);
			}
			jsonResult.put("data", jsonArray);
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	/**
	 * Thêm mới danh mục phòng
	 */
	public void insDMNgayNghi(String nam, JSONObject jo) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		try {
			sql = "select max(ma)+1 from KTNB_OWNER.KTNB_DM_NGAY_NGHI";
			ps = conn.prepareStatement(sql);
			String ma_moi = "";
			rs = ps.executeQuery();
			while (rs.next())
				ma_moi = rs.getString(1);

			sql = "insert into KTNB_OWNER.KTNB_DM_NGAY_NGHI (MA,NAM,NGAY_NGHI,MO_TA) values (?,?,to_date(?,'dd/MM/yyyy'),?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ma_moi);
			ps.setString(2, nam);
			ps.setString(3, (String) jo.get("ngay_nghi"));
			ps.setString(4, (String) jo.get("mo_ta"));
			// System.out.println((String) jo.get("ngay_nghi"));
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
	}

	/**
	 * Sửa đổi danh mục phòng
	 */
	public void updDMNgayNghi(String nam, JSONObject jo) throws Exception {
		PreparedStatement ps = null;
		String ma, ngaynghi, mota;
		try {
			ma = (String) jo.get("ma");
			ngaynghi = (String) jo.get("ngay_nghi");
			mota = (String) jo.get("mo_ta");
			StringBuffer sb = new StringBuffer("update ktnb_dm_ngay_nghi set nam=?");
			if (!Formater.isNull(ngaynghi))
				sb.append(",ngay_nghi=to_date(?,'dd/MM/yyyy')");
			if (!Formater.isNull(mota))
				sb.append(",mo_ta=?");
			sb.append(" where ma=?");
			ps = conn.prepareStatement(sb.toString());

			ps.setString(1, nam);
			int i = 2;
			if (!Formater.isNull(ngaynghi))
				ps.setString(i++, ngaynghi);
			if (!Formater.isNull(mota))
				ps.setString(i++, mota);
			ps.setString(i++, ma);

			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps);
		}
	}

	public JSONObject getAllUser(String parentId) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		JSONObject jsonResult = new JSONObject();
		try {
			String sql = "select * from ktnb_nsd n where n.ten_nsd like '%.' || (select t.ten_vt from ktnb_dm_cqt t where t.ma = (select substr(c.ma, 0, 3) || '00' from ktnb_dm_can_bo c where c.ma = ?))";
			ps = conn.prepareStatement(sql);
			ps.setString(1, parentId);
			//System.out.println(sql);
			rs = ps.executeQuery();
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject;
			while (rs.next()){
				jsonObject = new JSONObject();
				jsonObject.put("ngay_hieu_luc", rs.getString(4));
				jsonObject.put("name", rs.getString(1));
				jsonObject.put("select", null);
				jsonArray.add(jsonObject);
			}
			jsonResult.put("data", jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return jsonResult;
	}

	public void chonNsd(String id, String name) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "update ktnb_nsd set ma_can_bo = ? where ten_nsd =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
	}

}
