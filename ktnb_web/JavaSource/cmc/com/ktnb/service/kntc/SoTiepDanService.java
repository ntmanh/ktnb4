package cmc.com.ktnb.service.kntc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.UserTransaction;

import org.hibernate.Query;
import org.hibernate.Session;

import cmc.com.ktnb.exception.KtnbException;
import cmc.com.ktnb.pl.hb.entity.KntcBbDoiThoai;
import cmc.com.ktnb.pl.hb.entity.KntcCanBoRls;
import cmc.com.ktnb.pl.hb.entity.KntcCanBoRlsId;
import cmc.com.ktnb.pl.hb.entity.KntcDeXuatXly;
import cmc.com.ktnb.pl.hb.entity.KntcGiayBienNhan;
import cmc.com.ktnb.pl.hb.entity.KntcHoSoHdr;
import cmc.com.ktnb.pl.hb.entity.KntcPhieuGiaoHs;
import cmc.com.ktnb.pl.hb.entity.KntcPhieuHen;
import cmc.com.ktnb.pl.hb.entity.KntcQdDinhChiKN;
import cmc.com.ktnb.pl.hb.entity.KntcQdHuyTamDinhChiKN;
import cmc.com.ktnb.pl.hb.entity.KntcQdTamDinhChiKn;
import cmc.com.ktnb.pl.hb.entity.KtnbDmCanbo;
import cmc.com.ktnb.pl.hb.entity.KtnbDmCqt;
import cmc.com.ktnb.pl.hb.entity.KtnbLopTapHuan;
import cmc.com.ktnb.pl.hb.entity.KtnbTlieuKemTheo;
import cmc.com.ktnb.service.KtnbService;
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
 * @since Nov 17, 2010 Xử lý các thông tin liên quan đến sổ tiếp dân hoặc hồ sơ
 *        nhận từ văn thư
 */
public class SoTiepDanService {
	protected BaseHibernateDAO dao = new BaseHibernateDAO();

	private Connection conn = null;

	/**
	 * Hàm khởi tạo mặc định
	 */
	public SoTiepDanService() {
		super();
	}

	/**
	 * Lưu thông tin sổ tiếp dân
	 * 
	 * @param appContext
	 * @param hoSo
	 * @param isInTrans
	 * @throws Exception
	 */
	
	/**
	 * Des : ktnb v3
	 * */
	public void saveSoTiepDanv3(ApplicationContext appContext, KntcSoTiepDan hoSo, boolean isInTrans) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			KntcHoSoHdr hdr = hoSo.getHdr();
			// KntcNdungDon hdr = hoSo.getNoiDungDon();
			if (!isInTrans) {
				// BaseHibernateDAO dao = new BaseHibernateDAO();
				try {
					tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
					tx.begin();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			session = HibernateSessionFactory.currentSession();
			if (hdr.getLoaiKntc() != null && hdr.getLoaiKntc().equals(new Long("4"))) // Hỏi chính sách
			{
				hdr.setTrangThai(Constants.TT_KNTC_KET_THUC);
				hdr.setLoaiKetThuc(Constants.KNTC_KET_THUC_THUONG);
			}
			if (Formater.isNull(hdr.getMa())) { // Insert
				String ma = KeyManagement.getGUID();
				hdr.setMa(ma);
				if (Formater.isNull(hdr.getMaHs())) {
					int loai = hdr.getLoaiKntc().intValue();
					String loaiKNTC = "";
					if (loai == 1)
						loaiKNTC = "KN";
					else if (loai == 2)
						loaiKNTC = "TC";
					else if (loai == 3)
						loaiKNTC = "KH";
					else if (loai == 4)
						loaiKNTC = "CS";
					String kyBc;
					try {
						kyBc = Formater.date2str(hdr.getCongVanDenNgay()).split(Formater.date_separator)[2];
					} catch (Exception e) {
						kyBc = Formater.date2str(hdr.getNgayTiep()).split(Formater.date_separator)[2];
					}
					String loaiHs = "";
					loai = hdr.getLoaiHs().intValue();
					if (loai == 1)
						loaiHs = "TD";
					else if (loai == 2)
						loaiHs = "VT";
					String[] maHs = KtnbUtil.getMaHoSoByCqtBySeq(appContext, hdr.getMaCqt(), loaiKNTC, loaiHs, kyBc);
					hdr.setMaHs(maHs[0]);
					// Update max ma ho so
					String sql = "update ktnb_ho_so_seq set ma_hs=? where ma=? and ky_bc=?";
					Query q = session.createSQLQuery(sql);
					q.setParameter(0, maHs[1]);
					q.setParameter(1, hdr.getMaCqt());
					q.setParameter(2, kyBc);
					q.executeUpdate();
				}
				hdr.setNgayLap(new Date());
				dao.saveObject(appContext, hdr, Boolean.TRUE);
			} else
				// Update
				dao.updateObject(appContext, hdr, Boolean.TRUE);
			// Luu thong tin tai lieu kem theo
			ArrayList listTlkt = hoSo.getListTailieu();
			if (listTlkt != null && listTlkt.size() > 0) {
				String sql = "delete ktnb_tl_kem_theo where ma_ho_so=?";
				Query q = session.createSQLQuery(sql);
				q.setParameter(0, hdr.getMaHs());
				q.executeUpdate();
				for (Iterator iter = listTlkt.iterator(); iter.hasNext();) {
					KtnbTlieuKemTheo aTl = (KtnbTlieuKemTheo) iter.next();
					aTl.setMaTlieu(KeyManagement.getGUID());
					aTl.setMaHoSo(hdr.getMaHs());
					dao.saveObject(appContext, aTl, Boolean.TRUE);
				}
			}

			KntcCanBoRls aCb = new KntcCanBoRls();
			KntcCanBoRlsId aId = new KntcCanBoRlsId(hdr.getMaCanBo(), hdr.getMaHs(), new Long(0), KntcCanBoRls.KNTC_CB_XU_LY);
			aCb.setId(aId);
			aCb.setNgayCapNhat(new Date());
			aCb.setNguoiCapNhat(appContext.getTenNsd());
			CatalogService cs = new CatalogService();
			KtnbDmCanbo cb = (KtnbDmCanbo) cs.retriveById(appContext, KtnbDmCanbo.class, hdr.getMaCanBo());
			aCb.setTenCb(cb.getTen());
			aCb.setChucVu(cb.getChucVu());
			aCb.setDonVi(cb.getTenPhong());
			// dao.saveOrUpdateObject(appContext, aCb, Boolean.TRUE);
			KtnbService service = new KtnbService();
			Collection listCb;
			listCb = new ArrayList();
			listCb.add(aCb);
			service.saveTvd(appContext, hoSo.getHdr().getMaHs(), listCb, true);
			if (!isInTrans) {
				session.flush();
				tx.commit();
			}
		} catch (Exception e) {
			if (!isInTrans) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			if (!isInTrans) {
				HibernateSessionFactory.closeSession(session);
			}
		}
	}
	
	/**
	 * Des: ktnb v4
	 * */ 
	public void saveSoTiepDan(ApplicationContext appContext, KntcSoTiepDan hoSo, boolean isInTrans) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			KntcHoSoHdr hdr = hoSo.getHdr();
			// KntcNdungDon hdr = hoSo.getNoiDungDon();
			if (!isInTrans) {
				// BaseHibernateDAO dao = new BaseHibernateDAO();
				try {
					tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
					tx.begin();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			session = HibernateSessionFactory.currentSession();
			if ((hdr.getLoaiKntc() != null && hdr.getLoaiKntc().equals(new Long("4"))) || (hdr.getThamQuyenDon() !=null && "0".equals(hdr.getThamQuyenDon()) )) // Hỏi chính sách
			{
				hdr.setTrangThai(Constants.TT_KNTC_KET_THUC);
				hdr.setLoaiKetThuc(Constants.KNTC_KET_THUC_THUONG);
			}
			if (Formater.isNull(hdr.getMa())) { // Insert
				String ma = KeyManagement.getGUID();
				hdr.setMa(ma);
				hdr.setDonVer(Constants.APP_DEP_VERSION);
				if (Formater.isNull(hdr.getMaHs())) {
					int loai = hdr.getLoaiKntc().intValue();
					String loaiKNTC = "";
					if (loai == 1)
						loaiKNTC = "KN";
					else if (loai == 2)
						loaiKNTC = "TC";
					else if (loai == 3)
						loaiKNTC = "KH";
					else if (loai == 4)
						loaiKNTC = "CS";
					String kyBc;
					try {
						kyBc = Formater.date2str(hdr.getCongVanDenNgay()).split(Formater.date_separator)[2];
					} catch (Exception e) {
						kyBc = Formater.date2str(hdr.getNgayTiep()).split(Formater.date_separator)[2];
					}
					String loaiHs = "";
					loai = hdr.getLoaiHs().intValue();
					if (loai == 1)
						loaiHs = "TD";
					else if (loai == 2)
						loaiHs = "VT";
					String[] maHs = KtnbUtil.getMaHoSoByCqtBySeq(appContext, hdr.getMaCqt(), loaiKNTC, loaiHs, kyBc);
					hdr.setMaHs(maHs[0]);
					// Update max ma ho so
					String sql = "update ktnb_ho_so_seq set ma_hs=? where ma=? and ky_bc=?";
					Query q = session.createSQLQuery(sql);
					q.setParameter(0, maHs[1]);
					q.setParameter(1, hdr.getMaCqt());
					q.setParameter(2, kyBc);
					q.executeUpdate();
				}
				hdr.setNgayLap(new Date());
				dao.saveObject(appContext, hdr, Boolean.TRUE);
			} else
				// Update
				dao.updateObject(appContext, hdr, Boolean.TRUE);
			// Luu thong tin tai lieu kem theo
			ArrayList listTlkt = hoSo.getListTailieu();
			if (listTlkt != null && listTlkt.size() > 0) {
				String sql = "delete ktnb_tl_kem_theo where ma_ho_so=?";
				Query q = session.createSQLQuery(sql);
				q.setParameter(0, hdr.getMaHs());
				q.executeUpdate();
				for (Iterator iter = listTlkt.iterator(); iter.hasNext();) {
					KtnbTlieuKemTheo aTl = (KtnbTlieuKemTheo) iter.next();
					aTl.setMaTlieu(KeyManagement.getGUID());
					aTl.setMaHoSo(hdr.getMaHs());
					dao.saveObject(appContext, aTl, Boolean.TRUE);
				}
			}

			KntcCanBoRls aCb = new KntcCanBoRls();
			KntcCanBoRlsId aId = new KntcCanBoRlsId(hdr.getMaCanBo(), hdr.getMaHs(), new Long(0), KntcCanBoRls.KNTC_CB_XU_LY);
			aCb.setId(aId);
			aCb.setNgayCapNhat(new Date());
			aCb.setNguoiCapNhat(appContext.getTenNsd());
			CatalogService cs = new CatalogService();
			KtnbDmCanbo cb = (KtnbDmCanbo) cs.retriveById(appContext, KtnbDmCanbo.class, hdr.getMaCanBo());
			aCb.setTenCb(cb.getTen());
			aCb.setChucVu(cb.getChucVu());
			aCb.setDonVi(cb.getTenPhong());
			// dao.saveOrUpdateObject(appContext, aCb, Boolean.TRUE);
			KtnbService service = new KtnbService();
			Collection listCb;
			listCb = new ArrayList();
			listCb.add(aCb);
			service.saveTvd(appContext, hoSo.getHdr().getMaHs(), listCb, true);
			if (!isInTrans) {
				session.flush();
				tx.commit();
			}
		} catch (Exception e) {
			if (!isInTrans) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			if (!isInTrans) {
				HibernateSessionFactory.closeSession(session);
			}
		}
	}

	/**
	 * Cập nhật hồ sơ tài liệu cho hồ sơ
	 * 
	 * @param appContext
	 * @param maHs
	 * @param listTlkt :
	 *            danh sách tài liệu kèm theo
	 * @param kt
	 *            trạng thái kết thúc
	 * @param session
	 * @param del
	 *            xóa cập nhật mới
	 * @throws Exception
	 */

	public void delSoTiepDan(ApplicationContext appContext, KntcHoSoHdr hs) throws Exception {
		dao.deleteObject(appContext, hs);
	}

	public void updateHsTl(ApplicationContext appContext, String maHs, ArrayList listTlkt, String kt, Session session, String del) throws Exception {
		// UserTransaction tx = null;
		// Session session = null;
		try {
			// BaseHibernateDAO dao = new BaseHibernateDAO();
			// try {
			// //tx = (UserTransaction) new
			// InitialContext().lookup("java:comp/UserTransaction");
			// tx.begin();
			// } catch (Exception e1) {
			// e1.printStackTrace();
			// }
			// session = HibernateSessionFactory.currentSession();
			// Change trang thai
			if ("true".equals(kt)) {
				String sql = "Update KNTC_HO_SO_HDR set TRANG_THAI=? where MA_HS=?";
				Query q = session.createSQLQuery(sql);
				q.setParameter(0, new Long(Constants.TT_KNTC_CHO_CHUYEN_HS));
				q.setParameter(1, maHs);
				q.executeUpdate();
			} else if ("false".equals(kt)) {
				String sql = "Update KNTC_HO_SO_HDR set TRANG_THAI=? where MA_HS=?";
				Query q = session.createSQLQuery(sql);
				q.setParameter(0, new Long(Constants.TT_KNTC_BO_SUNG_HO_SO));
				q.setParameter(1, maHs);
				q.executeUpdate();
			}
			// update danh sach
			if (listTlkt != null && listTlkt.size() > 0) {
				if (del == "true") {
					String sql = "delete ktnb_tl_kem_theo where ma_ho_so=?";
					Query q = session.createSQLQuery(sql);
					q.setParameter(0, maHs);
					q.executeUpdate();
				}
				for (Iterator iter = listTlkt.iterator(); iter.hasNext();) {
					KtnbTlieuKemTheo gbn = (KtnbTlieuKemTheo) iter.next();
					gbn.setMaTlieu(KeyManagement.getGUID());
					gbn.setMaHoSo(maHs);
					dao.saveObject(appContext, gbn, Boolean.TRUE);
				}
			}
			// session.flush();
			// tx.commit();
		} catch (Exception e) {
			// tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	/**
	 * Lưu phiếu hẹn
	 * 
	 * @param appContext
	 * @param ph
	 *            Phiếu hẹn
	 * @throws Exception
	 */
	public void savePhieuHen(ApplicationContext appContext, KntcPhieuHen ph) throws Exception {
		System.out.println("Ma PH : "+ph.getMaPh());
		if(Formater.isNull(ph.getMaPh()))
		{
			ph.setMaPh(KeyManagement.getGUID());
			dao.saveObject(appContext, ph, Boolean.FALSE);
		}
		else 
			dao.updateObject(appContext, ph);
	}
	
	public void xoaPhieuHen(ApplicationContext applicationContext, KntcPhieuHen ph) throws Exception {
		dao.deleteObject(applicationContext, ph);
	}

	/**
	 * Bien Ban doi thoai
	 * 
	 * @param appContext
	 * @param maHs,maPh
	 *            Phiếu hẹn
	 * @throws Exception
	 */
	public KntcBbDoiThoai getBienBanByMaPh(ApplicationContext appContext, String maHs, String maPh)  throws Exception
	{
		CatalogService service = new CatalogService();
		SearchCriteria sc= new SearchCriteria(KntcBbDoiThoai.class);
		sc.addSearchItem("soQD", maHs);
		sc.addSearchItem("id", maPh);
		return (KntcBbDoiThoai) service.retriveObject(appContext, sc);
	}
	
	public void xoaBienBanDoiThoai(ApplicationContext appContext, KntcBbDoiThoai bb) throws Exception
	{
		dao.deleteObject(appContext, bb);
	}
	
	public void saveBbDoiThoai(ApplicationContext appContext, KntcBbDoiThoai bb) throws Exception
	{
		if(Formater.isNull(bb.getId()))
		{
			bb.setId(KeyManagement.getGUID());
			dao.saveObject(appContext, bb);
		}
		else dao.updateObject(appContext, bb);
		
	}
	
	/**
	 * Quyet dinh dinh chi khieu nai
	 * 
	 * @param appContext
	 * @param maHs,maPh
	 * @throws Exception
	 */
	public KntcQdDinhChiKN getQuyetDinhByMaPh(ApplicationContext appContext, String maHs, String maPh)  throws Exception
	{
		CatalogService service = new CatalogService();
		SearchCriteria sc= new SearchCriteria(KntcQdDinhChiKN.class);
		sc.addSearchItem("soHoSo", maHs);
		sc.addSearchItem("id", maPh);
		return (KntcQdDinhChiKN) service.retriveObject(appContext, sc);
	}
	public void saveQuyetDinhDinhChi(ApplicationContext appContext, KntcQdDinhChiKN qd) throws Exception
	{
		try {

			if(Formater.isNull(qd.getId()))
			{
				qd.setId(KeyManagement.getGUID());
				dao.saveObject(appContext, qd);
			}
			else
				dao.updateObject(appContext, qd);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e);
		} 
		
	}
	public void xoaQDDinhChiKn(ApplicationContext appContext, KntcQdDinhChiKN dckn) throws Exception
	{
		try {
			dao.deleteObject(appContext, dckn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	/**
	 * Quyet dinh tam dinh chi khieu nai
	 * @throws Exception 
	 * */
	public KntcQdTamDinhChiKn getQdTamDinhChi(ApplicationContext appContext, String maHs, String maPhieu) throws Exception
	{
		CatalogService service = new CatalogService();
		SearchCriteria sc= new SearchCriteria(KntcQdTamDinhChiKn.class);
		sc.addSearchItem("soHs", maHs);
		sc.addSearchItem("id", maPhieu);
		return (KntcQdTamDinhChiKn)service.retriveObject(appContext, sc);
	}
	public KntcQdHuyTamDinhChiKN getQdHuyTamDinhChi(ApplicationContext appContext, String maHs, String maPhieu) throws Exception
	{
		CatalogService service = new CatalogService();
		SearchCriteria sc= new SearchCriteria(KntcQdHuyTamDinhChiKN.class);
		sc.addSearchItem("soHoSo", maHs);
		sc.addSearchItem("id", maPhieu);
		return (KntcQdHuyTamDinhChiKN)service.retriveObject(appContext, sc);
	}
	public void saveQdTamDinhChiKn(ApplicationContext appContext, KntcQdTamDinhChiKn qdTamDinhChiKn) throws Exception
	{
		try {
			if(Formater.isNull(qdTamDinhChiKn.getId()))
			{
				qdTamDinhChiKn.setId(KeyManagement.getGUID());
				dao.saveObject(appContext, qdTamDinhChiKn);
			}
			else 
				dao.updateObject(appContext, qdTamDinhChiKn);
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	public void xoaQdTamDinhChiKn(ApplicationContext appContext, KntcQdTamDinhChiKn qdTamDinhChiKn) throws Exception
	{
		try {
			dao.deleteObject(appContext, qdTamDinhChiKn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	/**
	 * Lưu giấy biên nhận
	 * 
	 * @param appContext
	 * @param gbn
	 *            Giấy biên nhận
	 * @throws Exception
	 */
	public void saveGiayBienNhan(ApplicationContext appContext, KntcGiayBienNhan gbn) throws Exception {
		dao.saveObject(appContext, gbn, Boolean.FALSE);
	}

	/**
	 * Lưu phiếu chuyển giao hồ sơ tài liệu
	 * 
	 * @param appContext
	 * @param pcg
	 *            Phiếu chuyển giao
	 * @throws Exception
	 */
	public void savePhieuCgHs(ApplicationContext appContext, KntcPhieuGiaoHs pcg) throws Exception {
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
			String sql = "Update KNTC_HO_SO_HDR set TRANG_THAI=? where MA_HS=?";
			Query q = session.createSQLQuery(sql);
			q.setParameter(0, new Long(Constants.TT_KNTC_CHO_VAN_THU_XL));
			q.setParameter(1, pcg.getMaHs());
			q.executeUpdate();
			if (Formater.isNull(pcg.getMa())) {
				pcg.setMa(KeyManagement.getGUID());
				dao.saveObject(appContext, pcg, Boolean.TRUE);
			} else {
				dao.updateObject(appContext, pcg, Boolean.TRUE);
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
	}

	/**
	 * Lấy thông tin từ sổ tiếp dân theo mã hồ sơ
	 * 
	 * @param appContext
	 * @param maHoSo
	 * @param isSimple :
	 *            Lấy ra đầy đủ thông tin hay thông tin cơ bản
	 * @return KntcSoTiepDan
	 * @throws Exception
	 */

	public KntcSoTiepDan getSoTiepDan(ApplicationContext appContext, String maHoSo, boolean isSimple) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcHoSoHdr.class);
		sc.addSearchItem("maHs", maHoSo);
		KntcHoSoHdr hdr = (KntcHoSoHdr) services.retriveObject(appContext, sc);
		KntcSoTiepDan std = new KntcSoTiepDan(hdr);
		// sc = new SearchCriteria(KntcNdungDon.class);
		// sc.addSearchItem("maHs", maHoSo);
		// KntcNdungDon don = (KntcNdungDon) services.retriveObject(appContext,
		// sc);
		// std.setNoiDungDon(don);
		if (!isSimple) // Load full thong tin
		{ 
			sc = new SearchCriteria(KtnbTlieuKemTheo.class);
			sc.addSearchItem("maHoSo", maHoSo);
			sc.addSearchItem("loaiTlieu", KtnbTlieuKemTheo.TLKT_SO_TIEP_DAN);
			//sc.addSearchItem("loaiThongTin", KtnbTlieuKemTheo.getLoaiThongTin);
			Collection a = services.retrive(appContext, sc);
			for (Iterator iter = a.iterator(); iter.hasNext();) {
				KtnbTlieuKemTheo element = (KtnbTlieuKemTheo) iter.next();
				std.addTailieu(element);
			}
		}
		return std;
	}

	public static boolean isKN(ApplicationContext appContext, String maHoSo) throws Exception {
		if (StringUtil.isBlankOrNull(maHoSo))
			throw new KtnbException("Mã hồ sơ không đúng hoặc tồn tại", "Mã hồ sơ không đúng hoặc tồn tại");
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcHoSoHdr.class);
		sc.addSearchItem("maHs", maHoSo);
		KntcHoSoHdr hdr = (KntcHoSoHdr) services.retriveObject(appContext, sc);
		return hdr.getLoaiKntc().intValue() == 1 ? true : false;
	}

	/**
	 * Lấy nội dung đơn phục vụ cho quá trình xác minh
	 * 
	 * @param appContext
	 * @param maHoSo
	 * @return
	 * @throws Exception
	 */
	public String getNoiDungDonForXm(ApplicationContext appContext, String maHoSo) throws Exception {
		String retVal = "N\u1ED9i dung \u0111\u01A1n ";
		KntcHoSoHdr hdr = this.getSoTiepDan(appContext, maHoSo, true).getHdr();
		retVal += hdr.getTenLoaiKntc() + " \u0111\u1EC1 ";
		retVal += Formater.getDateForPrint(Formater.date2str(hdr.getNgayTiep() != null ? hdr.getNgayTiep() : hdr.getDonDeNgay()));
		retVal += " c\u1EE7a " + Formater.getStringForPrint(hdr.getNndTen()) + ", \u0111\u1ECBa ch\u1EC9 " + Formater.getStringForPrint(hdr.getNndDiaChi());
		return retVal;
	}

	/**
	 * Lấy danh sách tài liệu kèm theo theo mã hồ sơ
	 * 
	 * @param appContext
	 * @param maHoSo
	 * @return
	 * @throws Exception
	 */
	public Collection getListTlkt(ApplicationContext appContext, String maHoSo) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KtnbTlieuKemTheo.class);
		sc.addSearchItem("maHoSo", maHoSo);
		sc.addSearchItem("loaiTlieu", KtnbTlieuKemTheo.TLKT_SO_TIEP_DAN);
		return services.retrive(appContext, sc);
	}

	/**
	 * Lấy thông tin phiếu chuyển giao hồ sơ
	 * 
	 * @param appContext
	 * @param maHoSo
	 * @return
	 * @throws Exception
	 */
	public KntcPhieuGiaoHs getPhieuGiaoHs(ApplicationContext appContext, String maHoSo) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcPhieuGiaoHs.class);
		sc.addSearchItem("maHs", maHoSo);
		return (KntcPhieuGiaoHs) services.retriveObject(appContext, sc);
	}

	/**
	 * Lấy thông tin phiếu hẹn
	 * 
	 * @param appContext
	 * @param maHoSo
	 * @return
	 * @throws Exception
	 */
	public KntcPhieuHen getPhieuHen(ApplicationContext appContext, String maHoSo) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcPhieuHen.class);
		sc.addSearchItem("maDon", maHoSo);
		return (KntcPhieuHen) services.retriveObject(appContext, sc);
	}

	public KntcPhieuHen getPhieuHenByMaPhieu(ApplicationContext appContext, String maHoSo, String maPhieu) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcPhieuHen.class);
		sc.addSearchItem("maDon", maHoSo);
		sc.addSearchItem("maPh", maPhieu);
		return (KntcPhieuHen) services.retriveObject(appContext, sc);
	}
	
	/**
	 * Lấy thông tin bien ban doi thoai
	 * 
	 * @param appContext
	 * @param maHoSo
	 * @return
	 * @throws Exception
	 */
	public KntcBbDoiThoai getBienBanDoiThoai(ApplicationContext appContext, String maHoSo) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcBbDoiThoai.class);
		sc.addSearchItem("soQD", maHoSo);
		return (KntcBbDoiThoai) services.retriveObject(appContext, sc);
	}

	/**
	 * Lưu thông tin về lớp tập huấn
	 * 
	 * @param appContext
	 * @param qd
	 * @throws Exception
	 */
	public void saveLopTapHuan(ApplicationContext appContext, KtnbLopTapHuan qd) throws Exception {
		if (Formater.isNull(qd.getMa())) // Save
		{
			qd.setMa(KeyManagement.getGUID());
			dao.saveObject(appContext, qd);
		} else // Update
		{
			dao.updateObject(appContext, qd);
		}
	}

	/**
	 * Lấy danh sách cán bộ theo mã hồ sơ
	 * 
	 * @param appContext
	 * @param maHs
	 * @param loaiCb :
	 *            Cán bộ xử lý hoặc cán bộ xác minh
	 * @return
	 * @throws Exception
	 */
	public Collection getListCanBoByHs(ApplicationContext appContext, String maHs, String loaiCb) throws Exception {
		CatalogService services = new CatalogService();
		SearchCriteria sc = new SearchCriteria(KntcCanBoRls.class);
		sc.addSearchItem("id.maHs", maHs);
		sc.addSearchItem("id.loaiCb", loaiCb);
		sc.addSearchItem("ngayHetHluc", new Date(), SearchCriteria.LG_IS_NULL);
		return services.retrive(appContext, sc);
	}

	public Collection getListHoSo(ApplicationContext appContext) throws Exception {
		CatalogService services = new CatalogService();
		return services.retriveAll(appContext, KntcHoSoHdr.class);
	}

	public Date getNgayKetThuc(String maHs, HttpServletRequest request) throws Exception {
		Date ngayKetThuc;
		// Get ma Ho so
		ApplicationContext appContext = (ApplicationContext) request.getSession().getAttribute(Constants.APP_CONTEXT);
		// Get hdr
		SoTiepDanService s = new SoTiepDanService();
		KntcSoTiepDan hs = s.getSoTiepDan(appContext, maHs, true);
		KntcHoSoHdr hdr = hs.getHdr();
		ngayKetThuc = hdr.getCongVanDenNgay();

		PhanLoaiXuLyService s2 = new PhanLoaiXuLyService();
		KntcDeXuatXly dx = s2.getDeXuatXly(appContext, maHs);
		
		String pId = "";
		if ("1".equals(hdr.getLoaiKntc().toString())) {
			if (dx != null && dx.getIsGquyetNgay() != null) {
				if ("0".equals(dx.getIsGquyetNgay().toString())) {
					pId = Constants.TH_KHIEU_NAI_XAC_MINH;
				} else if ("1".equals(dx.getIsGquyetNgay().toString())) {
					pId = Constants.TH_KHIEU_NAI_GQ_NGAY;
				}
			}
		} else if ("2".equals(hdr.getLoaiKntc().toString())) {
			pId = Constants.TH_TO_CAO;
		}

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			StringBuffer sb = new StringBuffer("select b.thoigian from ktnb_dm a,ktnb_dm_time b where a.parent_id like ? and a.ma=b.pid(+) order by a.ma");
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, pId + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString(1) != null)
					ngayKetThuc = KtnbUtil.addBusinessDate(ngayKetThuc, Integer.parseInt(rs.getString(1)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return ngayKetThuc;
	}

	public String getMaHoSoByMaCha(String maCha, int loai) throws Exception {
		conn = DataSourceConfiguration.getConnection();
		String ma = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// JSONObject jsonResult = null;
		try {
			String sql = "select t.MA_HS from KTNB_OWNER.KNTC_HO_SO_HDR t where t.MA_HS_CHA =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, maCha);
			rs = ps.executeQuery();
			while (rs.next()) {
				String temp = "";
				temp = rs.getString(1);
				if (loai == HO_SO_CHUYEN) {
					if (temp.substring(temp.lastIndexOf("/"), temp.length()) != "KN" && temp.substring(temp.lastIndexOf("/"), temp.length()) != "TC")
						ma = temp;
				} else if (loai == HO_SO_TACH_KN) {
					if (temp.substring(temp.lastIndexOf("/"), temp.length()) == "KN")
						ma = temp;
				} else if (loai == HO_SO_TACH_TC) {
					if (temp.substring(temp.lastIndexOf("/"), temp.length()) == "TC")
						ma = temp;
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps);
		}
		return ma;
	}

	public static final int HO_SO_CHUYEN = 0x01;

	public static final int HO_SO_TACH_KN = 0x02;

	public static final int HO_SO_TACH_TC = 0x03;
}
