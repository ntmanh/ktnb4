package cmc.com.ktnb.service.kntc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.naming.InitialContext;
import javax.transaction.UserTransaction;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ibm.security.krb5.internal.APOptions;

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KntcCanBoRls;
import cmc.com.ktnb.pl.hb.entity.KntcChuyenCqDieuTra;
import cmc.com.ktnb.pl.hb.entity.KntcDeXuatXly;
import cmc.com.ktnb.pl.hb.entity.KntcDmRls;
import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.pl.hb.entity.KntcPhieuChuyenDon;
import cmc.com.ktnb.pl.hb.entity.KtnbTlieuKemTheo;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.util.StringUtil;
import cmc.com.ktnb.web.catalog.CatalogService;

/**
 * @author ntthu - cmcsoft
 * @since Nov 17, 2010 Xử lý các thông tin phân loại hồ sơ khiếu nại, tố cáo
 */
public class PhanLoaiXuLyService {
	protected BaseHibernateDAO dao = new BaseHibernateDAO();

	/**
	 * Hàm khởi tạo mặc định
	 * 
	 */
	public PhanLoaiXuLyService() {
		super();
		try {
			conn = DataSourceConfiguration.getConnection();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private Connection conn = null;

	/**
	 * Đóng kết nối
	 * 
	 */
	public void close() {
		DataSourceConfiguration.releaseSqlResources(conn);
	}

	/**
	 * Lấy thông tin mã đề xuất theo mã hồ sơ
	 * 
	 * @param maHoSo
	 * @return
	 */
	public String getMaDeXuatByMaHoSo(String maHoSo) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select ma from KNTC_DE_XUAT_XLY where ma_hs=?");
			ps.setString(1, maHoSo);
			rs = ps.executeQuery();
			String ma;
			while (rs.next()) {
				ma = rs.getString(1);
				return ma;
			}
			return "";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return "";
	}

	/**
	 * Lưu đề xuất xử lý
	 * 
	 * @param appContext
	 * @param dxxl :
	 *            Đề xuất xử lý
	 * @throws Exception
	 */
	public void saveDeXuatXyLyKN(ApplicationContext appContext, KntcDeXuatXuLy dxxl,Date ngayKetThucDuKien) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		KntcDeXuatXly dx = dxxl.getDx();
		try {
			BaseHibernateDAO dao = new BaseHibernateDAO();
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();
			// Tạo mới khi phân loại hồ sơ
			if (Formater.isNull(dx.getMa())) {
				dx.setMa(KeyManagement.getGUID());
				dao.saveObject(appContext, dx, Boolean.TRUE);
				ArrayList listDtl = dxxl.getDmRls();
				if (listDtl != null && listDtl.size() > 0) {
					for (Iterator iter = listDtl.iterator(); iter.hasNext();) {
						KntcDmRls gbn = (KntcDmRls) iter.next();
						dao.saveObject(appContext, gbn, Boolean.TRUE);
					}
				}
			} else
			// Cập nhật khi lập đề xuất
			{
				// Có thông tin ngày duyệt
				if (dx.getNgayDuyet() != null) {
					String tt = Constants.TT_KNTC_XM;
					String loaiketthuc = Constants.KNTC_KET_THUC_THUONG;
					if (dx.getIsGquyetNgay() != null && dx.getIsGquyetNgay().equals(new Long(1)))
						tt = Constants.TT_KNTC_KET_LUAN;
					// 1502020101 Không thuộc thẩm quyền của cơ quan thuế các
					// cấp
					// 1502020102 Tố cáo hành vi phạm tội
					// 1502020203 Thuộc thẩm quyền của cơ quan cấp dưới nhưng
					// quá thời hạn quy định mà không được giải quyết
					// 1502020201 Không thuộc thẩm quyền giải quyết của cơ quan
					// thuế nhận đơn nhưng thuộc thẩm quyền của cơ quan thuế
					// khác
					// 1502020202 Đã được cơ quan thuế cấp dưới giải quyết nhưng
					// có căn cứ cho rằng việc giải quyết không đúng pháp luật
					// 1502020301 Đơn nặc danh mà nội dung tố cáo không rõ ràng,
					// không có chứng cứ hoặc đã được giải quyết nhưng không có
					// chứng cứ mới
					// 1502010203 Thuộc thẩm quyền của cơ quan thuế cấp dưới
					// nhưng quá thời hạn quy định(Lập văn bản đôn đốc cơ quan
					// thuế cấp dưới giải quyết)
					// 1502010204 Do ĐBQH, ĐB HĐND, Ủy ban MTTQVN...và các CQ
					// khác chuyển đến nếu thuộc thẩm quyền và không thuộc thẩm
					// quyền giải quyết của cơ quan thuế
					// 1502010201 Không thuộc thẩm quyền của cơ quan thuế các
					// cấp
					// 1502010202 Thuộc thẩm quyền của cơ quan thuế khác
					// 1502010305 Do ĐBQH, ĐB HĐND, Ủy ban MTTQVN...và các CQ
					// khác chuyển đến nếu thuộc thẩm quyền và không đủ điều
					// kiện thụ lý giải quyết
					// 1502010301 Không đủ điều kiện thụ lý
					// 1502010105 Do ĐBQH, ĐB HĐND, Ủy ban MTTQVN...và các CQ
					// khác chuyển đến nếu thuộc thẩm quyền và không đủ điều
					// kiện thụ lý giải quyết
					// 1502010101 Không đủ điều kiện thụ lý
					// Bổ sung thêm: 1502020304 Đơn tố cáo nặc danh, nội dung rõ
					// ràng nhưng không thụ lý giải quyết

					// Trường hợp đặc biệt, có một phần thuộc thẩm quyền.
					if (dx.getThuLy().equals("1502010302")) {
						tt = Constants.TT_KNTC_XM;
						if (dx.getIsGquyetNgay() != null && dx.getIsGquyetNgay().equals(new Long(1)))
							tt = Constants.TT_KNTC_KET_LUAN;
					}

					// Nếu kết thúc hồ sơ
					String trangThaiKetThucHoSo = "1502020101,1502020102,1502020203,1502020201,1502020303,1502020202,1502020301,1502010203,1502010204,1502010201,1502010202,1502010305,1502010301,1502010105,1502010101,1502020304,1502020305,1502010401";

					if (trangThaiKetThucHoSo.indexOf(dx.getThuLy()) != -1) {
						tt = Constants.TT_KNTC_KET_THUC;
						// Trường hợp lưu đơn
						// if("1502020305".equals(dx.getThuLy()) ||
						// "1502010401".equals(dx.getThuLy())){ }
						// Trường hợp chuyển đơn
						if (dx.getThuLy().equals("1502010202") 
								|| dx.getThuLy().equals("1502020201") 
								|| dx.getThuLy().equals("1502020101") 
								//|| dx.getThuLy().equals("1502010302")
								|| dx.getThuLy().equals("1502020303")) {
							loaiketthuc = Constants.KNTC_KET_THUC_CHUYEN_DON;
							SoTiepDanService s = new SoTiepDanService();
							KntcSoTiepDan hosoP = s.getSoTiepDan(appContext, dx.getMaHs(), true);
							KntcHoSoHdr hdrParent = hosoP.getHdr();
							// 2. Copy bo ho so sang CQT khac
							// Sinh ma HS theo CQT
							XacMinhService xmS = new XacMinhService();
							Collection listPcd = xmS.getListPhieuChuyenDon(appContext, dx.getMaHs());
							if (Formater.isNull(listPcd)) {
								if (!hdrParent.getLoaiKntc().equals(new Long(2)))// Khong bat buoc voi To Cao
									throw new KtnbException("Kh&#244;ng l&#432;u &#273;&#432;&#7907;c phi&#7871;u &#273;&#7873; xu&#7845;t 04/KNTC", "",
											"Ph&#7843;i l&#7853;p phi&#7871;u chuy&#7875;n &#273;&#417;n tr&#432;&#7899;c khi nh&#7853;p th&#244;ng tin k&#253; duy&#7879;t m&#7851;u &#273;&#7873; xu&#7845;t 04/KNTC!");
							} else {
								for (Iterator p = listPcd.iterator(); p.hasNext();) {
									KntcPhieuChuyenDon pcd = (KntcPhieuChuyenDon) p.next();
									if (s.getMaHoSoByMaCha(dx.getMaHs(), SoTiepDanService.HO_SO_CHUYEN) == null) { // Trường hợp đã tạo bộ
										// hồ sơ xuống chi cục rồi thì bỏ qua.
										String maCqt = pcd.getCqtGqMa();
										if (maCqt != null) {
											KntcHoSoHdr hdrCopy = new KntcHoSoHdr(appContext, hdrParent);
											hdrCopy.setMa(null);
											hdrCopy.setMaHs(null);
											hdrCopy.setLoaiHs(new Long(2));
											hdrCopy.setTrangThai(Constants.TT_KNTC_CHO_VAN_THU_XL);
											hdrCopy.setMaCqt(maCqt);
											hdrCopy.setTenCqt(pcd.getCqtGqTen());
											hdrCopy.setMaHsCha(hdrParent.getMaHs());
											hdrCopy.setLoaiQh(Constants.LIEN_KET_CHUYEN);
											KntcSoTiepDan std = new KntcSoTiepDan(hdrCopy);
											Collection arrTl = hosoP.getListTailieu();
											if (arrTl != null && arrTl.size() > 0) {
												for (Iterator iter = arrTl.iterator(); iter.hasNext();) {
													KtnbTlieuKemTheo element = (KtnbTlieuKemTheo) iter.next();
													KtnbTlieuKemTheo aCb = new KtnbTlieuKemTheo();
													aCb.setLoaiTlieu(KtnbTlieuKemTheo.TLKT_SO_TIEP_DAN);
													aCb.setSoTrang(element.getSoTrang());
													aCb.setTenTlieu(element.getTenTlieu());
													aCb.setTinhTrang(element.getTinhTrang());
													aCb.setNguoiCapNhat(appContext.getTenNsd());
													aCb.setNgayCapNhat(appContext.getSystemDate());
													std.addTailieu(aCb);
												}
											}
											s.saveSoTiepDan(appContext, std, true);
										}
									}
								}
							}
						}
					}
					// Kết thúc lưu đơn
					if("1502010401".equals(dx.getThuLy().toString())||"1502020305".equals(dx.getThuLy().toString())){
						tt = Constants.TT_KNTC_KET_THUC;
						loaiketthuc = Constants.KNTC_KET_THUC_LUU_DON;
					}
					// Update trạng thái cho hồ sơ hiện tại
					// Nếu kết thúc										
					if (Constants.TT_KNTC_KET_THUC.equals(tt)) {
						String sql = "Update KNTC_HO_SO_HDR set TRANG_THAI=?,LOAI_KET_THUC=?,NGAY_KET_THUC=?,NGAY_KET_THUC_DU_KIEN=? where MA_HS=?";
						Query q = session.createSQLQuery(sql);
						q.setParameter(0, tt);
						q.setParameter(1, loaiketthuc);
						q.setParameter(2, dx.getNgayDuyet());
						q.setParameter(3, ngayKetThucDuKien);
						q.setParameter(4, dx.getMaHs());
						q.executeUpdate();
					// Nếu xác minh hoặc giải quyết ngay
					} else {
						String sql = "Update KNTC_HO_SO_HDR set TRANG_THAI=?,NGAY_KET_THUC_DU_KIEN=? where MA_HS=?";
						Query q = session.createSQLQuery(sql);
						q.setParameter(0, tt);
						q.setParameter(1, ngayKetThucDuKien);
						q.setParameter(2, dx.getMaHs());
						q.executeUpdate();
					}					
				}

				// Update noi dung tom tat don
				SoTiepDanService s = new SoTiepDanService();
				KntcSoTiepDan hs = s.getSoTiepDan(appContext, dx.getMaHs(), true);
				// hs.getNoiDungDon().setNoiDung(dx.getDx().getNoiDung());
				KntcHoSoHdr hdr = hs.getHdr();

				// Update tai lieu kem theo của đề xuất
				ArrayList arr = new ArrayList();
				if (!Formater.isNull(dx.getArrTenTl())) {
					String[] arrTL = dx.getArrTenTl().split("@@");
					if (arrTL != null && arrTL.length > 0) {
						for (int i = 0; i < arrTL.length; i++) {
							String[] item = arrTL[i].split("###");
							if (item != null && item.length > 0) {
								if (!Formater.isNull(item[0])) {
									KtnbTlieuKemTheo aCb = new KtnbTlieuKemTheo();
									aCb.setMaHoSo(hdr.getMaHs());
									aCb.setLoaiTlieu(KtnbTlieuKemTheo.TLKT_SO_TIEP_DAN);
									if (!Formater.isNull(item[1]))
										aCb.setSoTrang(new Short(item[1]));
									else
										aCb.setSoTrang(new Short("0"));
									aCb.setTenTlieu(item[0]);
									aCb.setTinhTrang(item[2]);
									aCb.setNguoiCapNhat(appContext.getTenNsd());
									aCb.setNgayCapNhat(appContext.getSystemDate());
									arr.add(aCb);
								}
							}
						}
					}
					s.updateHsTl(appContext, hdr.getMaHs(), arr, null, session, "true");
				}
				ArrayList listDtl = dxxl.getDmRls();
				if (listDtl != null && listDtl.size() > 0) {
					// Del Quan he voi DM cu
					String sql = "DELETE kntc_dm_rls where ma_hs=? and loai_rls=?";
					Query q = session.createSQLQuery(sql);
					q.setParameter(0, dx.getMaHs());
					q.setParameter(1, KntcDmRls.DE_XUAT_XU_LY_RLS);
					q.executeUpdate();
					// Insert Quan he danh muc moi
					for (Iterator iter = listDtl.iterator(); iter.hasNext();) {
						KntcDmRls i = (KntcDmRls) iter.next();
						dao.saveObject(appContext, i, Boolean.TRUE);
					}
				}
				// Update Phan loai xu ly
				dao.updateObject(appContext, dx, Boolean.TRUE);				
			}
			session.flush();
			tx.commit();
		} catch (KtnbException e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}
	
	/**
	 * Xem, lưu, sửa, xóa phiếu chuyển cơ quan điều tra
	 * @param appContext
	 * @param phiếu chuyển :
	 *  	Phiếu chuyển cơ quan điều tra
	 *  @throws Exception
	 * */
	public KntcChuyenCqDieuTra getPhieuChuyenCqByMaPhieu(ApplicationContext appContext, String maPhieu) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcChuyenCqDieuTra.class);
		sc.addSearchItem("maPhieu", maPhieu);
		return (KntcChuyenCqDieuTra) services.retriveObject(appContext, sc);
	}
	
	public void savePhieuChuyenCq(ApplicationContext appContext, KntcChuyenCqDieuTra chuyenCq) throws Exception
	{
		if(Formater.isNull(chuyenCq.getMaPhieu()))
		{
			chuyenCq.setMaPhieu(KeyManagement.getGUID());
			dao.saveObject(appContext, chuyenCq);
		}
		else 
			dao.updateObject(appContext, chuyenCq);
	}
	/**
	 * Lưu phiếu chuyển đơn, phiếu trả đơn
	 * 
	 * @param appContext
	 * @param qd:
	 *            Phiếu chuyển đơn
	 * @throws Exception
	 */
	public void savePhieuChuyenDon(ApplicationContext appContext, KntcPhieuChuyenDon qd) throws Exception {
		// Chuyển đơn
		if (qd.getLoaiThongBao().equals(KntcPhieuChuyenDon.PHIEU_CHUYEN_DON) || qd.getLoaiThongBao().equals(KntcPhieuChuyenDon.PHIEU_CHUYEN_DON_TO_CAO)) {
			// 1. Save phieu
			if (Formater.isNull(qd.getMa())) // Save
			{
				KntcPhieuChuyenDon pcD = this.getPhieuChuyenDonByCqtNhan(appContext, qd.getCqtGqMa(), qd.getMaHs(), qd.getLoaiThongBao());
				if (pcD != null)
					throw new KtnbException("",
							"&#272;&#227; l&#7853;p phi&#7871;u chuy&#7875;n &#273;&#417;n cho &#273;&#417;n v&#7883; n&#224;y, y&#234;u c&#7847;u chuy&#7875;n &#273;&#417;n cho &#273;&#417;n v&#7883; kh&#225;c!");
				qd.setMa(KeyManagement.getGUID());
				dao.saveObject(appContext, qd);
			} else
				// Update
				dao.updateObject(appContext, qd);
			// Trả đơn
		} /*else if (qd.getLoaiThongBao().equals(KntcPhieuChuyenDon.PHIEU_TRA_DON_KN)) {
			Session session = null;
			UserTransaction tx = null;
			try {
				try {
					tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
					tx.begin();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				session = HibernateSessionFactory.currentSession();
				// 1. Ket thuc bo ho so cu
				String sql = "Update KNTC_HO_SO_HDR set TRANG_THAI=?,LOAI_KET_THUC=? where MA_HS=?";
				Query q = session.createSQLQuery(sql);
				q.setParameter(0, new Long(Constants.TT_KNTC_KET_THUC));
				q.setParameter(1, Constants.KNTC_KET_THUC_TACH_DON);
				q.setParameter(2, qd.getMaHs());
				q.executeUpdate();
				// 3. Save phieu
				if (Formater.isNull(qd.getMa())) // Save
				{
					qd.setMa(KeyManagement.getGUID());
					dao.saveObject(appContext, qd, Boolean.TRUE);
				} else // Update
				{
					dao.updateObject(appContext, qd, Boolean.FALSE);
				}
				session.flush();
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
				throw new Exception(e);
			} finally {
				HibernateSessionFactory.closeSession(session);
			}
			// Các trường hợp khác
		}*/ else {
			if (Formater.isNull(qd.getMa())) // Save
			{
				qd.setMa(KeyManagement.getGUID());
				dao.saveObject(appContext, qd);
			} else // Update
			{
				dao.updateObject(appContext, qd);
			}
		}
	}

	/**
	 * Lấy thông tin phiếu chuyển đơn theo mã hồ sơ và loại phiếu
	 * 
	 * @param appContext
	 * @param maHoSo
	 * @param loaiPhieu
	 * @return KntcPhieuChuyenDon
	 * @throws Exception
	 */
	public KntcPhieuChuyenDon getPhieuChuyenDon(ApplicationContext appContext, String maHoSo, String loaiPhieu) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcPhieuChuyenDon.class);
		sc.addSearchItem("maHs", maHoSo);
		sc.addSearchItem("loaiThongBao", loaiPhieu);
		return (KntcPhieuChuyenDon) services.retriveObject(appContext, sc);
	}

	public KntcPhieuChuyenDon getPhieuChuyenDonByCqtNhan(ApplicationContext appContext, String maCqt, String maHoSo, String loaiPhieu) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcPhieuChuyenDon.class);
		sc.addSearchItem("maHs", maHoSo);
		sc.addSearchItem("loaiThongBao", loaiPhieu);
		sc.addSearchItem("cqtGqMa", maCqt);
		return (KntcPhieuChuyenDon) services.retriveObject(appContext, sc);
	}

	/**
	 * Lấy đề xuất xử lý theo mã hồ sơ
	 * 
	 * @param appContext
	 * @param maHoSo
	 * @return
	 * @throws Exception
	 */
	public KntcDeXuatXly getDeXuatXly(ApplicationContext appContext, String maHoSo) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcDeXuatXly.class);
		sc.addSearchItem("maHs", maHoSo);
		return (KntcDeXuatXly) services.retriveObject(appContext, sc);
	}

	/**
	 * Lấy ra danh mục dùng cho việc phân loại hồ sơ
	 * 
	 * @param maHoSo
	 * @param loaiRls :
	 *            Loại danh mục
	 * @return
	 * @throws Exception
	 */
	public String getDmRls(String maHoSo, String loaiRls) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String dmRls = "";
		String sql = "select MA_DM from KNTC_DM_RLS where MA_HS =? and LOAI_RLS=?";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maHoSo);
			ps.setString(2, loaiRls);
			rs = ps.executeQuery();
			while (rs.next()) {
				dmRls += rs.getString(1) + ",";
			}
			dmRls = dmRls.substring(0, dmRls.lastIndexOf(","));
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return dmRls;
	}

	/**
	 * Lấy danh sách danh mục liên quan đến loại hồ sơ
	 * 
	 * @param appContext
	 * @param maHoSo
	 * @param loaiRls :
	 *            loại danh mục
	 * @return
	 * @throws Exception
	 */
	public Collection getDmRlsByHoSo(ApplicationContext appContext, String maHoSo, String loaiRls) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcDmRls.class);
		sc.addSearchItem("id.maHs", maHoSo);
		sc.addSearchItem("loaiRls", loaiRls);
		return services.retrive(appContext, sc);
	}

	/**
	 * Xóa dữ liệu trên bảng theo mã hồ sơ
	 * 
	 * @param tableName : Tên bảng cần xóa dữ liệu
	 * @param maHoSo
	 * @throws Exception
	 */
	public static void delete(String tableName, String maHoSo, ApplicationContext appContext) throws Exception {
		Session session = null;
		UserTransaction tx = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();
			String sql = "Update " + tableName + " set NGAY_KET_THUC = sysdate, LOAI_KET_THUC = ?, NGUOI_CAP_NHAT = ? where MA_HS=?";
			Query q = session.createSQLQuery(sql);
			// q.setParameter(0, new Date());
			q.setParameter(0, Constants.KNTC_KET_THUC_XOA_HS);
			q.setParameter(1, appContext.getTenCanbo());
			q.setParameter(2, maHoSo);
			q.executeUpdate();
			session.flush();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}

	/**
	 * Lấy ra danh sách cán bộ xử lý theo mã hồ sơ
	 * 
	 * @param appContext
	 * @param maHs
	 * @return
	 * @throws Exception
	 */
	public Collection getListCanBoXuLyByHs(ApplicationContext appContext, String maHs) throws Exception {
		SoTiepDanService services = new SoTiepDanService();
		return services.getListCanBoByHs(appContext, maHs, KntcCanBoRls.KNTC_CB_XU_LY);
	}

	/**
	 * Kiểm tra việc hoàn thiện mẫu phụ.
	 * 
	 * @param idMauPhu
	 * @return
	 */
	public boolean checkMauPhu(int idMauPhu, String maHoSo) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String dmRls = "";
		String sql = "select MA_PHIEU,THOI_DIEM from KNTC_PHIEU_CHUYEN_DON where LOAI_THONG_BAO=? and MA_HS =?";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Constants.getMauPhu(idMauPhu));
			ps.setString(2, maHoSo);
			rs = ps.executeQuery();
			if (rs.next()) {
				// Đã có mẫu phụ
				do {
					if (StringUtil.isBlankOrNull(rs.getString(1)))
						return false;
					if (StringUtil.isBlankOrNull(rs.getString(2)))
						return false;
					//String temp = rs.getString(1).substring(0, 3);
					//if ("...".equals(temp))
						//return false;
				} while (rs.next());
			} else {
				// Không có mẫu phụ
				return false;
			}
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return true;
	}
}
