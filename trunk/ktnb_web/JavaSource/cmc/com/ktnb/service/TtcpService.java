package cmc.com.ktnb.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import cmc.com.ktnb.pl.hb.entity.Ttcp1a;
import cmc.com.ktnb.pl.hb.entity.Ttcp1b;
import cmc.com.ktnb.pl.hb.entity.Ttcp2a;
import cmc.com.ktnb.pl.hb.entity.Ttcp2b;
import cmc.com.ktnb.pl.hb.entity.Ttcp2c;
import cmc.com.ktnb.pl.hb.entity.Ttcp2d;
import cmc.com.ktnb.pl.hb.entity.Ttcp2dd;
import cmc.com.ktnb.tccp.Bc1aForm;
import cmc.com.ktnb.tccp.Bc1bForm;
import cmc.com.ktnb.tccp.Bc2aForm;
import cmc.com.ktnb.tccp.Bc2bForm;
import cmc.com.ktnb.tccp.Bc2cForm;
import cmc.com.ktnb.tccp.Bc2dForm;
import cmc.com.ktnb.tccp.Bc2ddForm;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.web.catalog.CatalogService;

/**
 * @author dhphuc
 */
public class TtcpService {
	protected BaseHibernateDAO dao = new BaseHibernateDAO();
	private Connection conn = null;
	
	public TtcpService() {
		super();
		try {
			conn = DataSourceConfiguration.getConnection();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	/*Bao cao 2A*/
	public void save2a(ApplicationContext appContext, Ttcp2a ttcp2a) throws Exception {
		dao.saveObject(appContext, ttcp2a, Boolean.FALSE);
	}
	public void update2a(ApplicationContext appContext, Ttcp2a ttcp2a) throws Exception {
		dao.updateObject(appContext, ttcp2a, Boolean.FALSE);
	}
	public Ttcp2a get2a(ApplicationContext appContext, String maCqt, Integer thang, Integer nam) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(Ttcp2a.class);
		sc.addSearchItem("id.maCqt", maCqt);
		sc.addSearchItem("id.thang", thang);
		sc.addSearchItem("id.nam", nam);
		Ttcp2a bc2a = (Ttcp2a) services.retriveObject(appContext, sc);
		return bc2a;
	}	
	public void getSoLieuTuBaoCao2A(Bc2aForm form,String thoiGian, String maCqt){
		ResultSet rs = null;
		CallableStatement cs = null;
		try {
			String sql = "begin rp_2a.rp_2a(?,?,?,?); end;";
			cs = conn.prepareCall(sql);
			cs.setString(1, thoiGian);
			cs.setString(2, thoiGian);
			cs.setString(3, maCqt);
			cs.registerOutParameter(4, oracle.jdbc.driver.OracleTypes.CURSOR);			
			cs.executeQuery();
			rs = (ResultSet) cs.getObject(4);
			while(rs.next()) {
				form.setTtxLuot(new Long (rs.getString("TTX_LUOT")));
				form.setTtxNguoi(new Long (rs.getString("TTX_NGUOI")));	
				form.setTtxDnnSoDoan(new Long (rs.getString("TTX_DDN_SO_DOAN")));
				form.setTtxDnnNguoi(new Long (rs.getString("TTX_DDN_NGUOI")));
				form.setTdxLuot(new Long (rs.getString("TDX_LUOT")));
				form.setTdxNguoi(new Long (rs.getString("TDX_NGUOI")));
				form.setTdxDnnSoDoan(new Long (rs.getString("TDX_DDN_SO_DOAN")));
				form.setTdxDnnNguoi(new Long (rs.getString("TDX_DDN_NGUOI")));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(cs);
		}
	}
	/*Bao cao 2B*/
	public void save2b(ApplicationContext appContext, Ttcp2b ttcp2b) throws Exception {
		dao.saveObject(appContext, ttcp2b, Boolean.FALSE);
	}
	public void update2b(ApplicationContext appContext, Ttcp2b ttcp2b) throws Exception {
		dao.updateObject(appContext, ttcp2b, Boolean.FALSE);
	}
	public Ttcp2b get2b(ApplicationContext appContext, String maCqt, Integer thang, Integer nam) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(Ttcp2b.class);
		sc.addSearchItem("id.maCqt", maCqt);
		sc.addSearchItem("id.thang", thang);
		sc.addSearchItem("id.nam", nam);
		Ttcp2b bc2b = (Ttcp2b) services.retriveObject(appContext, sc);
		return bc2b;
	}	
	public void getSoLieuTuBaoCao2B(Bc2bForm form,String thoiGian, String maCqt){
		ResultSet rs = null;
		CallableStatement cs = null;
		try {
			String sql = "begin rp_2b.rp_2b(?,?,?,?); end;";
			cs = conn.prepareCall(sql);
			cs.setString(1, thoiGian);
			cs.setString(2, thoiGian);
			cs.setString(3, maCqt);
			cs.registerOutParameter(4, oracle.jdbc.driver.OracleTypes.CURSOR);			
			cs.executeQuery();
			rs = (ResultSet) cs.getObject(4);
			while(rs.next()) {
				/*form.setTtxLuot(new Long (rs.getString("TTX_LUOT")));
				form.setTtxNguoi(new Long (rs.getString("TTX_NGUOI")));	
				form.setTtxDnnSoDoan(new Long (rs.getString("TTX_DDN_SO_DOAN")));
				form.setTtxDnnNguoi(new Long (rs.getString("TTX_DDN_NGUOI")));
				form.setTdxLuot(new Long (rs.getString("TDX_LUOT")));
				form.setTdxNguoi(new Long (rs.getString("TDX_NGUOI")));
				form.setTdxDnnSoDoan(new Long (rs.getString("TDX_DDN_SO_DOAN")));
				form.setTdxDnnNguoi(new Long (rs.getString("TDX_DDN_NGUOI")));*/
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(cs);
		}
	}
	/*Bao cao 2DD*/
	public void save2dd(ApplicationContext appContext, Ttcp2dd ttcp2dd) throws Exception {
		dao.saveObject(appContext, ttcp2dd, Boolean.FALSE);
	}
	public void update2dd(ApplicationContext appContext, Ttcp2dd ttcp2dd) throws Exception {
		dao.updateObject(appContext, ttcp2dd, Boolean.FALSE);
	}
	public Ttcp2dd get2dd(ApplicationContext appContext, String maCqt, Integer thang, Integer nam) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(Ttcp2dd.class);
		sc.addSearchItem("id.maCqt", maCqt);
		sc.addSearchItem("id.thang", thang);
		sc.addSearchItem("id.nam", nam);
		Ttcp2dd bc2dd = (Ttcp2dd) services.retriveObject(appContext, sc);
		return bc2dd;
	}	
	public void getSoLieuTuBaoCao2DD(Bc2ddForm form,String thoiGian, String maCqt){
		ResultSet rs = null;
		CallableStatement cs = null;
		try {
			String sql = "begin rp_2dd.rp_2dd(?,?,?,?); end;";
			cs = conn.prepareCall(sql);
			cs.setString(1, thoiGian);
			cs.setString(2, thoiGian);
			cs.setString(3, maCqt);
			cs.registerOutParameter(4, oracle.jdbc.driver.OracleTypes.CURSOR);			
			cs.executeQuery();
			rs = (ResultSet) cs.getObject(4);
			while(rs.next()) {
				/*form.setTtxLuot(new Long (rs.getString("TTX_LUOT")));
				form.setTtxNguoi(new Long (rs.getString("TTX_NGUOI")));	
				form.setTtxDnnSoDoan(new Long (rs.getString("TTX_DDN_SO_DOAN")));
				form.setTtxDnnNguoi(new Long (rs.getString("TTX_DDN_NGUOI")));
				form.setTdxLuot(new Long (rs.getString("TDX_LUOT")));
				form.setTdxNguoi(new Long (rs.getString("TDX_NGUOI")));
				form.setTdxDnnSoDoan(new Long (rs.getString("TDX_DDN_SO_DOAN")));
				form.setTdxDnnNguoi(new Long (rs.getString("TDX_DDN_NGUOI")));*/
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(cs);
		}
	}
	//Báo cáo 1b
	public void save1b(ApplicationContext appContext, Ttcp1b ttcp1b) throws Exception {
		dao.saveObject(appContext, ttcp1b, Boolean.FALSE);
	}
	public void update1b(ApplicationContext appContext, Ttcp1b ttcp1b) throws Exception {
		dao.updateObject(appContext, ttcp1b, Boolean.FALSE);
	}
	public Ttcp1b get1b(ApplicationContext appContext, String maCqt, Integer thang, Integer nam) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(Ttcp1b.class);
		sc.addSearchItem("id.maCqt", maCqt);
		sc.addSearchItem("id.thang", thang);
		sc.addSearchItem("id.nam", nam);
		Ttcp1b bc1b = (Ttcp1b) services.retriveObject(appContext, sc);
		return bc1b;
	}	
	public void getSoLieuTuBaoCao1B(Bc1bForm form,String thoiGian, String maCqt){
		ResultSet rs = null;
		CallableStatement cs = null;
		try {
			String sql = "begin rp_1b.rp_1b(?,?,?,?); end;";
			cs = conn.prepareCall(sql);
			cs.setString(1, thoiGian);
			cs.setString(2, thoiGian);
			cs.setString(3, maCqt);
			cs.registerOutParameter(4, oracle.jdbc.driver.OracleTypes.CURSOR);			
			cs.executeQuery();
			rs = (ResultSet) cs.getObject(4);
			while(rs.next()) {
				/*form.setTtxLuot(new Long (rs.getString("TTX_LUOT")));
				form.setTtxNguoi(new Long (rs.getString("TTX_NGUOI")));	
				form.setTtxDnnSoDoan(new Long (rs.getString("TTX_DDN_SO_DOAN")));
				form.setTtxDnnNguoi(new Long (rs.getString("TTX_DDN_NGUOI")));
				form.setTdxLuot(new Long (rs.getString("TDX_LUOT")));
				form.setTdxNguoi(new Long (rs.getString("TDX_NGUOI")));
				form.setTdxDnnSoDoan(new Long (rs.getString("TDX_DDN_SO_DOAN")));
				form.setTdxDnnNguoi(new Long (rs.getString("TDX_DDN_NGUOI")));*/
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(cs);
		}
	}
//	Báo cáo 1a
	public void save1a(ApplicationContext appContext, Ttcp1a ttcp1a) throws Exception {
		dao.saveObject(appContext, ttcp1a, Boolean.FALSE);
	}
	public void update1a(ApplicationContext appContext, Ttcp1a ttcp1a) throws Exception {
		dao.updateObject(appContext, ttcp1a, Boolean.FALSE);
	}
	public Ttcp1a get1a(ApplicationContext appContext, String maCqt, Integer thang, Integer nam) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(Ttcp1a.class);
		sc.addSearchItem("id.maCqt", maCqt);
		sc.addSearchItem("id.thang", thang);
		sc.addSearchItem("id.nam", nam);
		Ttcp1a bc1a = (Ttcp1a) services.retriveObject(appContext, sc);
		return bc1a;
	}	
	public void getSoLieuTuBaoCao1A(Bc1aForm form,String thoiGian, String maCqt,int nam, int namSau){
		ResultSet rs = null;
		CallableStatement cs = null;
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    String ngayLapBaoCao = sdf.format(cal.getTime());	
		try {
			String sql = "begin rp_1a.rp_1a(?,?,?,?,?,?,?); end;";
			cs = conn.prepareCall(sql);
			cs.setString(1, thoiGian);
			cs.setString(2, thoiGian);
			cs.setString(3, maCqt);
			cs.setString(4, Integer.toString(nam));
			cs.setString(5, Integer.toString(namSau));
			cs.setString(6, ngayLapBaoCao);
			cs.registerOutParameter(7, oracle.jdbc.driver.OracleTypes.CURSOR);			
			cs.executeQuery();
			rs = (ResultSet) cs.getObject(7);
			while(rs.next()) {
				Long a = new Long (rs.getString("KHN_TH_DX"));
				Long b = new Long (rs.getString("KHN_TD_KT_TRUC_TIEP"));
				form.setTONG_SO(new Long(a.longValue()+b.longValue()));//new Long($F{KHN_TH_DX}.longValue()+$F{KHN_TD_KT_TRUC_TIEP}.longValue())
				
				form.setKHN(new Long (rs.getString("KHN")));
				form.setKHN_TH_KY_TRUOC(new Long (rs.getString("KHN_TH_KY_TRUOC")));
				form.setKHN_TH_TRONG_KY(new Long (rs.getString("KHN_TH_TRONG_KY")));
				form.setKHN_TH_THEO_KH(new Long (rs.getString("KHN_TH_THEO_KH")));
				form.setKHN_TH_DX(new Long (rs.getString("KHN_TH_DX")));
				form.setKHN_TD_KT_TRUC_TIEP(new Long (rs.getString("KHN_TD_KT_TRUC_TIEP")));
				form.setKHN_TD_KT_KET_LUAN(new Long (rs.getString("KHN_TD_KT_KET_LUAN")));
				form.setSO_DV_DUOC_KT(new Long (rs.getString("SO_DV_DUOC_KT")));
				form.setSO_DV_SAI_PHAM(new Long (rs.getString("SO_DV_SAI_PHAM")));
				form.setTSP_TIEN(new Long (rs.getString("TSP_TIEN")));
				form.setTSP_KHAC(new Long (rs.getString("TSP_KHAC")));
				form.setKNTH_TIEN(new Long (rs.getString("KNTH_TIEN")));
				form.setKNTH_KHAC(new Long (rs.getString("KNTH_KHAC")));
				form.setKNKHAC_TIEN(new Long (rs.getString("KNKHAC_TIEN")));
				form.setKNKHAC_KHAC(new Long (rs.getString("KNKHAC_KHAC")));
				form.setKNXL_HANH_CHINH(new Long (rs.getString("KNXL_HANH_CHINH")));
				form.setKNXL_HINH_SU_VU(new Long (rs.getString("KNXL_HINH_SU_VU")));
				form.setKNXL_HINH_SU_NGUOI(new Long (rs.getString("KNXL_HINH_SU_NGUOI")));
				form.setKQ_SO_NGUOI(new Long (rs.getString("KQ_SO_NGUOI")));
				form.setKQ_HC_RUT_KN(new Long (rs.getString("KQ_HC_RUT_KN")));
				form.setKQ_HC_KHIEN_TRACH(new Long (rs.getString("KQ_HC_KHIEN_TRACH")));
				form.setKQ_HC_CANH_CAO(new Long (rs.getString("KQ_HC_CANH_CAO")));
				form.setKQ_HC_HA_LUONG(new Long (rs.getString("KQ_HC_HA_LUONG")));
				form.setKQ_HC_GIANG_CHUC(new Long (rs.getString("KQ_HC_GIANG_CHUC")));
				form.setKQ_HC_CACH_CHUC(new Long (rs.getString("KQ_HC_CACH_CHUC")));
				form.setKQ_HC_THOI_VIEC(new Long (rs.getString("KQ_HC_THOI_VIEC")));
				form.setKQ_HS(new Long (rs.getString("KQ_HS")));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(cs);
		}
	}
//	Báo cáo 2C
	public void save2c(ApplicationContext appContext, Ttcp2c ttcp2c) throws Exception {
		dao.saveObject(appContext, ttcp2c, Boolean.FALSE);
	}
	public void update2c(ApplicationContext appContext, Ttcp2c ttcp2c) throws Exception {
		dao.updateObject(appContext, ttcp2c, Boolean.FALSE);
	}
	public Ttcp2c get2c(ApplicationContext appContext, String maCqt, Integer thang, Integer nam) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(Ttcp2c.class);
		sc.addSearchItem("id.maCqt", maCqt);
		sc.addSearchItem("id.thang", thang);
		sc.addSearchItem("id.nam", nam);
		Ttcp2c bc2c = (Ttcp2c) services.retriveObject(appContext, sc);
		return bc2c;
	}	
	public void getSoLieuTuBaoCao2C(Bc2cForm form,String thoiGian, String maCqt){
		ResultSet rs = null;
		CallableStatement cs = null;
		try {
			String sql = "begin rp_2c.rp_2c(?,?,?,?); end;";
			cs = conn.prepareCall(sql);
			cs.setString(1, thoiGian);
			cs.setString(2, thoiGian);
			cs.setString(3, maCqt);
			cs.registerOutParameter(4, oracle.jdbc.driver.OracleTypes.CURSOR);			
			cs.executeQuery();
			rs = (ResultSet) cs.getObject(4);
			while(rs.next()) {
				Long a = new Long (rs.getString("DON_NHAN_TRONG_KY"));
				Long b = new Long (rs.getString("DON_TON_KY_TRUOC"));
				Long c = new Long (rs.getString("DGQ_SVV_RUT_DON"));
				Long d = new Long (rs.getString("GQ_LAN1"));
				Long e = new Long (rs.getString("GQ_LAN2_CONG_NHAN"));
				Long f = new Long (rs.getString("GQ_LAN2_HUY"));
				
				form.setTONG_SO_DON_KN(new Long (a.longValue()+b.longValue()));//new Long($F{DON_NHAN_TRONG_KY}.longValue()+$F{DON_TON_KY_TRUOC}.longValue())
				form.setSO_DON_THUOC_THAM_QUYEN(new Long (c.longValue()+d.longValue()+e.longValue()+f.longValue()));//new Long($F{DGQ_SVV_RUT_DON}.longValue()+$F{GQ_LAN1}.longValue()+$F{GQ_LAN2_CONG_NHAN}.longValue()+$F{GQ_LAN2_HUY}.longValue())
				form.setSO_VU_VIEC_THUOC_THAM_QUYEN(new Long (c.longValue()+d.longValue()+e.longValue()+f.longValue()));//new Long($F{DGQ_SVV_RUT_DON}.longValue()+$F{GQ_LAN1}.longValue()+$F{GQ_LAN2_CONG_NHAN}.longValue()+$F{GQ_LAN2_HUY}.longValue())
				form.setSO_VU_VIEC_GQ_QUA_QDHC(new Long (d.longValue()+e.longValue()+f.longValue()));//new Long($F{GQ_LAN1}.longValue()+$F{GQ_LAN2_CONG_NHAN}.longValue()+$F{GQ_LAN2_HUY}.longValue())
				form.setDON_NHAN_TRONG_KY(new Long (rs.getString("DON_NHAN_TRONG_KY")));
				form.setDON_TON_KY_TRUOC(new Long (rs.getString("DON_TON_KY_TRUOC")));
				form.setSO_VU_VIEC(new Long (rs.getString("SO_VU_VIEC")));
				form.setDGQ_SVV_RUT_DON(new Long (rs.getString("DGQ_SVV_RUT_DON")));
				form.setKQ_DUNG(new Long (rs.getString("KQ_DUNG")));
				form.setKQ_SAI(new Long (rs.getString("KQ_SAI")));
				form.setKQ_DUNG_SAI(new Long (rs.getString("KQ_DUNG_SAI")));
				form.setGQ_LAN1(new Long (rs.getString("GQ_LAN1")));
				form.setGQ_LAN2_CONG_NHAN(new Long (rs.getString("GQ_LAN2_CONG_NHAN")));
				form.setGQ_LAN2_HUY(new Long (rs.getString("GQ_LAN2_HUY")));
				form.setGQ_THU_HOI_CHO_NN(new Long (rs.getString("GQ_THU_HOI_CHO_NN")));
				form.setGQ_TRA_LAI_CD(new Long (rs.getString("GQ_TRA_LAI_CD")));
				form.setGQ_SO_NGUOI_DUOC_TRA_QUYEN_LOI(new Long (rs.getString("GQ_SO_NGUOI_DUOC_TRA_QUYEN_LOI")));
				form.setGQ_XL_HC_NGUOI(new Long (rs.getString("GQ_XL_HC_NGUOI")));
				form.setCHAP_HANH_DUNG_HAN(new Long (rs.getString("CHAP_HANH_DUNG_HAN")));
				form.setCHAP_HANH_QUA_HAN(new Long (rs.getString("CHAP_HANH_QUA_HAN")));
				form.setTH_SQD_PHAI_THUC_HIEN_TRONG_KY(new Long (rs.getString("TH_SQD_PHAI_THUC_HIEN_TRONG_KY")));
				form.setTH_SQD_DA_THUC_HIEN(new Long (rs.getString("TH_SQD_DA_THUC_HIEN")));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(cs);
		}
	}
//	Báo cáo 2D
	public void save2d(ApplicationContext appContext, Ttcp2d ttcp2d) throws Exception {
		dao.saveObject(appContext, ttcp2d, Boolean.FALSE);
	}
	public void update2d(ApplicationContext appContext, Ttcp2d ttcp2d) throws Exception {
		dao.updateObject(appContext, ttcp2d, Boolean.FALSE);
	}
	public Ttcp2d get2d(ApplicationContext appContext, String maCqt, Integer thang, Integer nam) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(Ttcp2d.class);
		sc.addSearchItem("id.maCqt", maCqt);
		sc.addSearchItem("id.thang", thang);
		sc.addSearchItem("id.nam", nam);
		Ttcp2d bc2d = (Ttcp2d) services.retriveObject(appContext, sc);
		return bc2d;
	}	
	public void getSoLieuTuBaoCao2D(Bc2dForm form,String thoiGian, String maCqt){
		ResultSet rs = null;
		CallableStatement cs = null;
		try {
			String sql = "begin rp_2d.rp_2d(?,?,?,?); end;";
			cs = conn.prepareCall(sql);
			cs.setString(1, thoiGian);
			cs.setString(2, thoiGian);
			cs.setString(3, maCqt);
			cs.registerOutParameter(4, oracle.jdbc.driver.OracleTypes.CURSOR);			
			cs.executeQuery();
			rs = (ResultSet) cs.getObject(4);
			while(rs.next()) {
				Long a = new Long (rs.getString("DON_NHAN_TRONG_KY"));
				Long b = new Long (rs.getString("DON_TON_KY_TRUOC"));
				Long c = new Long (rs.getString("KQ_DUNG"));
				Long d = new Long (rs.getString("KQ_SAI"));
				Long e = new Long (rs.getString("KQ_DUNG_SAI"));
				
				form.setTONG_SO_DON(new Long(a.longValue()+b.longValue()));//new Long($F{DON_NHAN_TRONG_KY}.longValue()+$F{DON_TON_KY_TRUOC}.longValue())
				form.setDA_GIAI_QUYET_SO_DON(new Long(c.longValue()+d.longValue()+e.longValue()));//new Long($F{KQ_DUNG}.longValue()+$F{KQ_SAI}.longValue()+$F{KQ_DUNG_SAI}.longValue())
				form.setDA_GIAI_QUYET_SO_VU_VIEC(new Long(c.longValue()+d.longValue()+e.longValue()));//new Long($F{KQ_DUNG}.longValue()+$F{KQ_SAI}.longValue()+$F{KQ_DUNG_SAI}.longValue())
				
				form.setDON_NHAN_TRONG_KY(new Long (rs.getString("DON_NHAN_TRONG_KY")));
				form.setDON_TON_KY_TRUOC(new Long (rs.getString("DON_TON_KY_TRUOC")));
				form.setSO_VU_VIEC(new Long (rs.getString("SO_VU_VIEC")));
				form.setKQ_DUNG(new Long (rs.getString("KQ_DUNG")));
				form.setKQ_SAI(new Long (rs.getString("KQ_SAI")));
				form.setKQ_DUNG_SAI(new Long (rs.getString("KQ_DUNG_SAI")));
				form.setGQ_LAN1(new Long (rs.getString("GQ_LAN1")));
				form.setGQ_THU_HOI_CHO_NN(new Long (rs.getString("GQ_THU_HOI_CHO_NN")));
				form.setGQ_TRA_LAI_CD(new Long (rs.getString("GQ_TRA_LAI_CD")));
				form.setGQ_XL_HC_NGUOI_DA_XL(new Long (rs.getString("GQ_XL_HC_NGUOI_DA_XL")));
				form.setGQ_DT_SO_DOI_TUONG(new Long (rs.getString("GQ_DT_SO_DOI_TUONG")));
				form.setGQ_DT_SO_VU(new Long (rs.getString("GQ_DT_SO_VU")));
				form.setCHAP_HANH_DUNG_HAN(new Long (rs.getString("CHAP_HANH_DUNG_HAN")));
				form.setCHAP_HANH_QUA_HAN(new Long (rs.getString("CHAP_HANH_QUA_HAN")));
				
				form.setTH_SQD_PHAI_THUC_HIEN_TRONG_KY(new Long (rs.getString("TH_SQD_PHAI_THUC_HIEN_TRONG_KY")));
				form.setTH_SQD_DA_THUC_HIEN(new Long (rs.getString("TH_SQD_DA_THUC_HIEN")));				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(cs);
		}
	}
}
