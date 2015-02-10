/*
 * Created on Dec 24, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.service;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import net.sf.jasperreports.components.barcode4j.UPCAComponent;

import org.apache.struts.upload.FormFile;
import org.hibernate.Session;

import cmc.com.ktnb.entity.KtnbTkCanBo;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.KtnbFile;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbChiTietDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbDeCuong;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbDsTvDoan;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbKhTtkt;
import cmc.com.ktnb.entity.TTKT.chuan_bi_tien_hanh.TtktCbQd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmBienBan;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmHsTl;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmNhanTraHstl;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThanhPhanThamDu;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThayDoiThemMoiTvd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktCmThayDoiTvd;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhChiTietNoiDungTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhCuocTtkt;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhDuyetKeHoach;
import cmc.com.ktnb.entity.TTKT.dung_chung.TtktKhNoiDungTtkt;
import cmc.com.ktnb.entity.TTKT.ket_thuc_ttkt.TtktKtBcKqThucHienKL;
import cmc.com.ktnb.entity.TTKT.ket_thuc_ttkt.TtktKtChuyenDlieuSangBc;
import cmc.com.ktnb.entity.TTKT.ket_thuc_ttkt.TtktKtChuyenGiaoHsVv;
import cmc.com.ktnb.entity.TTKT.ket_thuc_ttkt.TtktKtKetLuanChuyenBC;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBanGiaoHstlChoTd;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBbChitietvatonghop;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBbMoNiemPhong;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBbNiemPhong;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThBienBanKiemKe;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThCongBoQd;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThGiaHan;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThNhatKy;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThPhucTra;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThQdKiemKe;
import cmc.com.ktnb.entity.TTKT.tien_hanh_ttkt.TtktThQdNiemPhongHsTl;
import cmc.com.ktnb.pl.hb.entity.KtnbDmCanbo;
import cmc.com.ktnb.pl.hb.entity.KtnbDmCqt;
import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.DetailInformation;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.HibernateSessionFactory;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.KtnbUtil;
import cmc.com.ktnb.util.SearchCriteria;
import cmc.com.ktnb.web.UploadAction;
import cmc.com.ktnb.web.catalog.CatalogService;
import cmc.com.ktnb.web.ttkt.chuan_bi_tien_hanh.form.ChuanBiTienHanhForm;
import cmc.com.ktnb.web.ttkt.ket_thuc_ttkt.form.KetThucTtktForm;

/**
 * @author Ntthu+Nguyen Tien Dung+vmduan
 */
public class TtktService {
	private static BaseHibernateDAO dao = new BaseHibernateDAO();

	/**
	 * L?u phân công tr??ng ?oàn
	 * 
	 * @param dsCuocTtkt
	 *            Danh sách các cu?c Thanh tra Ki?m tra c?n phân công, s?a phân công
	 * @param request
	 * @param appContext
	 * @throws Exception
	 */
	public static void saveDsPhanCongTd(DetailInformation[] dsCuocTtkt, HttpServletRequest request, ApplicationContext appContext) throws Exception {

		for (int i = 0; i < dsCuocTtkt.length; i++) {
			if (!Formater.isNull(dsCuocTtkt[i].getCol12())) {
				if (Formater.isNull(dsCuocTtkt[i].getCol13())) { // Chua co
					// danh sach thanh vien doan (chua phan cong truong doan)
					UserTransaction tx = null;
					Session session = null;
					try {
						BaseHibernateDAO dao = new BaseHibernateDAO();
						try {
							tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
							tx.begin();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						session = HibernateSessionFactory.currentSession();
						// Cap nhat trang thai cuoc Ttkt
						session.createSQLQuery(
								"UPDATE ttkt_kh_cuoc_ttkt set TRANG_THAI= '" + Constants.TT_TTKT_CDTD + "', id_truong_doan = '" + dsCuocTtkt[i].getCol11() + "', ten_truong_doan = '"
										+ dsCuocTtkt[i].getCol12() + "' WHERE id= '" + dsCuocTtkt[i].getCol0() + "'").executeUpdate();
						savePhanCongTd(dsCuocTtkt[i], request, appContext, Boolean.TRUE);
						session.flush();
						tx.commit();
					} catch (Exception e) {
						HibernateSessionFactory.rollbackQuiet();
						e.printStackTrace();
						throw new Exception(e);
					} finally {
						HibernateSessionFactory.closeSession(session);
					}
				} else {
					updatePhanCongTd(dsCuocTtkt[i], request, appContext);
				}
			} else {
				if (!Formater.isNull(dsCuocTtkt[i].getCol13())) {
					UserTransaction tx = null;
					Session session = null;
					try {
						BaseHibernateDAO dao = new BaseHibernateDAO();
						try {
							tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
							tx.begin();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						session = HibernateSessionFactory.currentSession();

						// Cap nhat trang thai cuoc Ttkt thanh create
						session.createSQLQuery(buidSqlUpdateTrangThaiCuocTtkt(dsCuocTtkt[i].getCol0(), Constants.TT_TTKT_CREATE)).executeUpdate();

						// Xoa chi tiet danh sach thanh vien doan
						session.createSQLQuery("delete ttkt_cb_chi_tiet_ds_tv_doan where id_ds_tvd = " + dsCuocTtkt[i].getCol13()).executeUpdate();

						// Xoa danh sach thanh vien doan
						session.createSQLQuery("delete ttkt_cb_ds_tv_doan where ID_CUOC_TTKT = " + dsCuocTtkt[i].getCol0()).executeUpdate();

						session.flush();
						tx.commit();
					} catch (Exception e) {
						HibernateSessionFactory.rollbackQuiet();
						e.printStackTrace();
						throw new Exception(e);
					} finally {
						HibernateSessionFactory.closeSession(session);
					}

				}

			}
		}

	}

	/**
	 * Ki?m tra tr?ng thái truy?n vào có ph?i tr?ng thái m?i c?a cu?c Thanh tra Ki?m tra ?ang th?c hi?n hay không
	 * 
	 * @param appContext
	 * @param tenTrangThai
	 *            Tr?ng thái c?n ki?m tra
	 * @return
	 */
	public static boolean isNewStatus(String idCuocTtkt, ApplicationContext appContext, String tenTrangThai) {
		System.out.println("Ten Trang thai: "+ tenTrangThai);
		System.out.println("id cuoc kt: "+ idCuocTtkt);
		if (getIndexOfTrangThai(tenTrangThai) > getIndexOfTrangThai(appContext.getTrangThaiCuocTtkt(idCuocTtkt)))
			return true;
		else
			return false;
	}

	/**
	 * L?y v? trí c?a tr?ng thái trong danh sách các tr?ng thái c?a m?t cu?c Thanh tra Ki?m tra
	 * 
	 * @param appContext
	 * @param tenTrangThai
	 *            Tr?ng thái c?n xác ??nh v? trí
	 */
	public static int getIndexOfTrangThai(String tenTrangThai) {
		for (int i = 0; i < Constants.ARR_TRANG_THAI_CUOC_TTKT.length; i++)
		{
			boolean check = Constants.ARR_TRANG_THAI_CUOC_TTKT[i].trim().equals(tenTrangThai);
			if (Constants.ARR_TRANG_THAI_CUOC_TTKT[i].trim().equals(tenTrangThai))
				return i;
		}
		return 0;
	}

	/**
	 * C?p nh?t phân công tr??ng ?oàn trong tr??ng h?p thay ??i tr??ng ?oàn cho cu?c Thanh tra Ki?m tra v?a ???c phân công tr??ng ?oàn
	 * 
	 * @param information
	 *            Thông tin v? cu?c Thanh tra Ki?m tra và tr??ng ?oàn m?i
	 * @param request
	 * @param appContext
	 */
	private static void updatePhanCongTd(DetailInformation information, HttpServletRequest request, ApplicationContext appContext) throws Exception {
		String upDateTableChiTietTVD = "update TTKT_CB_CHI_TIET_DS_TV_DOAN set id_can_bo = '" + information.getCol11() + "', ten_can_bo = '" + information.getCol12() + "', CHUC_VU = '"
				+ information.getCol15() + "', ";
		KtnbDmCanbo canbo = KtnbUtil.getThongTinCanBo(information.getCol11());
		// upDateTableChiTietTVD += "CHUC_VU = '" + canbo.getTenChucVu() + "',
		// ";
		upDateTableChiTietTVD += "TEN_PHONG = '" + canbo.getTenPhong() + ", " + canbo.getTenCqt() + "'";
		upDateTableChiTietTVD += "where ID_DS_TVD = '" + information.getCol13() + "'";
		String upDateTableCuocTtkt = "UPDATE ttkt_kh_cuoc_ttkt set id_truong_doan = '" + information.getCol11() + "', ten_truong_doan = '" + information.getCol12() + "' WHERE id= '"
				+ information.getCol0() + "'";
		Connection conn = null;
		Statement statement = null;
		try {

			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			statement.addBatch(upDateTableChiTietTVD);
			statement.addBatch(upDateTableCuocTtkt);
			statement.executeBatch();
			conn.commit();

		} catch (Exception e) {
			
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}

	}

	/**
	 * Th?c hi?n phân công tr??ng ?oàn cho cu?c Thanh tra Ki?m tra ch?a ???c phân công
	 * 
	 * @param information
	 *            Thông tin v? cu?c Thanh tra Ki?m tra và tr??ng ?oàn
	 * @param request
	 * @param appContext
	 * @param inInTran
	 *            N?u là true hàm s? không commit các th?c thi sql bên trong, ng??c l?i các th?c thi sql s? ???c commit
	 */
	private static void savePhanCongTd(DetailInformation cuocTtkt, HttpServletRequest request, ApplicationContext appContext, Boolean inInTran) throws Exception {
		// Luu vao bang danh sach Tv doan
		TtktCbDsTvDoan dsTvd = new TtktCbDsTvDoan();
		dsTvd.setIsNew(Boolean.TRUE);
		dsTvd.setIdCuocTtkt(cuocTtkt.getCol0());
		dsTvd.setId(KeyManagement.getGUID());
		dao.saveObject(appContext, dsTvd, Boolean.TRUE);
		// Luu vao bang chi tiet danh sach Tv doan
		TtktCbChiTietDsTvDoan chiTietDsTvd = new TtktCbChiTietDsTvDoan();
		chiTietDsTvd.setId(KeyManagement.getGUID());
		chiTietDsTvd.setIdDsTvd(dsTvd.getId());
		chiTietDsTvd.setIdCanBo(cuocTtkt.getCol11());
		chiTietDsTvd.setTenCanBo(cuocTtkt.getCol12());
		chiTietDsTvd.setChucVu(cuocTtkt.getCol15());
		// Don vi cong tac
		KtnbDmCanbo canbo = KtnbUtil.getThongTinCanBo(cuocTtkt.getCol11());
		chiTietDsTvd.setTenPhong(canbo.getTenPhong() + ", " + canbo.getTenCqt());
		// Chuc vu
		// chiTietDsTvd.setChucVu(canbo.getTenChucVu());
		chiTietDsTvd.setChucVuTrongDoan(Constants.TTKT_CVTD_TD);
		dao.saveObject(appContext, chiTietDsTvd, Boolean.TRUE);

	}

	/**
	 * L?y báo cáo kh?o sát c?a cu?c Thanh tra Ki?m tra
	 * 
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra c?n l?y
	 * @param appConText
	 * @return
	 */
	public static KtnbFile getBCKS(String cuocTtktId, ApplicationContext appConText) throws Exception {
		SearchCriteria criteria = new SearchCriteria(KtnbFile.class);
		criteria.addSearchItem(KtnbFile.MaDon, cuocTtktId);
		criteria.addSearchItem(KtnbFile.NghiepVuPath, Constants.TTKT_NV_BCKS);

		Collection temp = dao.retrieveObjects(appConText, criteria);
		if (Formater.isNull(temp))
			return null;
		else
			return (KtnbFile) ((ArrayList) temp).get(0);
	}
	
	/**
	 * L?y danh sách thành viên ?oàn hi?n t?i c?a cu?c Thanh tra Ki?m tra
	 * 
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra c?n l?y
	 * @param appConText
	 * @return
	 */
	public static TtktCbDsTvDoan getDsTvd(String cuocTtktId, ApplicationContext appConText) throws Exception {
		// Ds thanh vien doan
		CatalogService cs = new CatalogService();
		SearchCriteria criteria = new SearchCriteria(TtktCbDsTvDoan.class);
		criteria.addSearchItem("idCuocTtkt", cuocTtktId);
		criteria.addSearchItem("isNew", Boolean.TRUE);
		Collection listTemp = cs.retrive(appConText, criteria);
		if (Formater.isNull(listTemp))
			return null;
		TtktCbDsTvDoan dsTvd = (TtktCbDsTvDoan) ((ArrayList) listTemp).get(0);
		// Chi tien ds thanh vien doan
		criteria = new SearchCriteria(TtktCbChiTietDsTvDoan.class);
		criteria.addSearchItem(TtktCbChiTietDsTvDoan.IdDsTvd, dsTvd.getId());

		Collection chitietDsThanhVienDoan = dao.retrieveObjects(appConText, criteria);
		// Sap xep lai thu tu, truong doan len dau tien
		int index = 0;
		Iterator iter = chitietDsThanhVienDoan.iterator();
		while (iter.hasNext()) {
			TtktCbChiTietDsTvDoan tvDoan = (TtktCbChiTietDsTvDoan) iter.next();
			if (Constants.TTKT_CVTD_TD.equals(tvDoan.getChucVuTrongDoan()))
				break;
			index++;
		}
		ArrayList temp = new ArrayList();
		temp.add(((ArrayList) chitietDsThanhVienDoan).get(index));
		for (int i = 0; i < chitietDsThanhVienDoan.size(); i++) {
			if (i != index)
				temp.add(((ArrayList) chitietDsThanhVienDoan).get(i));
		}
		dsTvd.setChiTietDanhSachTV(temp);
		return dsTvd;
	}

	/**
	 * L?y danh sách thành viên ?oàn theo id
	 * 
	 * @param id
	 *            Id danh sách thành viên ?oàn
	 * @param appConText
	 * @return
	 * @throws Exception
	 */
	public static TtktCbDsTvDoan getDsTvdById(String id, ApplicationContext appConText) throws Exception {
		// Ds thanh vien doan
		CatalogService cs = new CatalogService();
		SearchCriteria criteria = new SearchCriteria(TtktCbDsTvDoan.class);
		criteria.addSearchItem("id", id);
		Collection listTemp = cs.retrive(appConText, criteria);
		if (Formater.isNull(listTemp))
			return null;
		TtktCbDsTvDoan dsTvd = (TtktCbDsTvDoan) ((ArrayList) listTemp).get(0);
		// Chi tien ds thanh vien doan
		criteria = new SearchCriteria(TtktCbChiTietDsTvDoan.class);
		criteria.addSearchItem(TtktCbChiTietDsTvDoan.IdDsTvd, dsTvd.getId());

		Collection chitietDsThanhVienDoan = dao.retrieveObjects(appConText, criteria);
		// Sap xep lai thu tu, truong doan len dau tien
		int index = 0;
		Iterator iter = chitietDsThanhVienDoan.iterator();
		while (iter.hasNext()) {
			TtktCbChiTietDsTvDoan tvDoan = (TtktCbChiTietDsTvDoan) iter.next();
			if (Constants.TTKT_CVTD_TD.equals(tvDoan.getChucVuTrongDoan()))
				break;
			index++;
		}
		ArrayList temp = new ArrayList();
		temp.add(((ArrayList) chitietDsThanhVienDoan).get(index));
		for (int i = 0; i < chitietDsThanhVienDoan.size(); i++) {
			if (i != index)
				temp.add(((ArrayList) chitietDsThanhVienDoan).get(i));
		}
		dsTvd.setChiTietDanhSachTV(temp);
		return dsTvd;

	}

	/**
	 * L?y quy?t ??nh Thanh tra Ki?m tra theo Id cu?c Thanh tra Ki?m tra
	 * 
	 * @param cuocTtktId   Id cu?c Thanh tra Ki?m tra
	 * @param appConText
	 * @return
	 */
	public static TtktCbQd getQuyetDinh(String cuocTtktId, ApplicationContext appConText) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktCbQd.class);
		criteria.addSearchItem(TtktCbDsTvDoan.IdCuocTtkt, cuocTtktId);
		Collection listTemp = dao.retrieveObjects(appConText, criteria);
		if (Formater.isNull(listTemp))
			return null;
		return (TtktCbQd) ((ArrayList) listTemp).get(0);
	}
	/**
	 * Ntthu: lay so don vi duoc TTKT
	 * @param cuocTtktId
	 * @param appConText
	 * @return
	 * @throws Exception
	 */
	public static String getSoDonViDuocTtKt(ApplicationContext appConText,String cuocTtktId) throws Exception {
		String retval = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(t2.id) so_dv_ttkt from ttkt_kh_cuoc_ttkt t1, ttkt_kh_cuoc_ttkt t2 where t1.id = t2.id_cuoc_ttkt_cha and t1.id=? group by t1.id";
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cuocTtktId);
			rs = ps.executeQuery();
			if (rs.next())
				retval = rs.getString(1);
		} catch (Exception ex) {
			throw ex;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}		
		return retval;
	}

	/**
	 * L?y k? ho?ch c?a cu?c Thanh tra Ki?m tra theo Id cu?c Thanh tra Ki?m tra
	 * 
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @param appConText
	 * @return
	 */
	public static TtktCbKhTtkt getKeHoach(String cuocTtktId, ApplicationContext appConText) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktCbKhTtkt.class);
		criteria.addSearchItem(TtktCbKhTtkt.IdCuocTtkt, cuocTtktId);
		Collection listTemp = dao.retrieveObjects(appConText, criteria);
		if (Formater.isNull(listTemp))
			return null;

		return (TtktCbKhTtkt) ((ArrayList) listTemp).get(0);
	}

	/**
	 * L?y ?? c??ng cu?c Thanh tra Ki?m tra theo id
	 * 
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @param appConText
	 * @return
	 */
	public static TtktCbDeCuong getDeCuong(String cuocTtktId, ApplicationContext appConText) throws Exception {
		// De cuong
		SearchCriteria criteria = new SearchCriteria(TtktCbDeCuong.class);
		criteria.addSearchItem(TtktCbDeCuong.IdCuocTtkt, cuocTtktId);
		Collection listTemp = dao.retrieveObjects(appConText, criteria);
		if (Formater.isNull(listTemp))
			return null;
		TtktCbDeCuong deCuong = (TtktCbDeCuong) ((ArrayList) listTemp).get(0);

		// Ho so tai lieu phai chuan bi va cung cap
		criteria = new SearchCriteria(TtktCmHsTl.class);
		criteria.addSearchItem(TtktCmHsTl.MasterId, deCuong.getIdHstlPhaiCbiCungCap());
		deCuong.setHstlPhaiCbiCungCap(dao.retrieveObjects(appConText, criteria));

		// Bao cao tai lieu phai chuan bi va cung cap
		criteria = new SearchCriteria(TtktCmHsTl.class);
		criteria.addSearchItem(TtktCmHsTl.MasterId, deCuong.getIdBaoCaoPhaiCbiCungCap());
		deCuong.setBaoCaoPhaiCbiCungCap(dao.retrieveObjects(appConText, criteria));
		return deCuong;
	}

	/**
	 * L?y biên b?n h?p ?oàn tri?n khai c?a cu?c Thanh tra Ki?m tra
	 * 
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @param appConText
	 * @return
	 */
	public static TtktCmBienBan getBbHopDoanTrienKhai(String cuocTtktId, ApplicationContext appConText) throws Exception {
		// Bien ban hop doan
		SearchCriteria criteria = new SearchCriteria(TtktCmBienBan.class);
		criteria.addSearchItem(TtktCmBienBan.IdCuocTtkt, cuocTtktId);
		criteria.addSearchItem(TtktCmBienBan.Loai, Constants.TTKT_BB_HDTK);
		Collection listTemp = dao.retrieveObjects(appConText, criteria);
		if (Formater.isNull(listTemp))
			return null;
		TtktCmBienBan bb = (TtktCmBienBan) ((ArrayList) listTemp).get(0);
		// Thanh phan tham du
		criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
		criteria.addSearchItem(TtktCmThanhPhanThamDu.IdMaster, bb.getId());
		bb.setThanhPhanThamDu(dao.retrieveObjects(appConText, criteria));
		return bb;
	}

	/**
	 * L?y biên b?n cu?c Thanh tra Ki?m tra theo Id cu?c Thanh tra Ki?m tra và lo?i biên b?n
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @param loaiBB
	 *            Lo?i biên b?n
	 * @return
	 * @throws Exception
	 */
	public static TtktCmBienBan getBienBan(ApplicationContext appContext, String cuocTtktId, String loaiBB) throws Exception {
		// Bien ban hop doan
		SearchCriteria criteria = new SearchCriteria(TtktCmBienBan.class);
		criteria.addSearchItem(TtktCmBienBan.IdCuocTtkt, cuocTtktId);
		criteria.addSearchItem(TtktCmBienBan.Loai, loaiBB);
		Collection listTemp = dao.retrieveObjects(appContext, criteria);
		if (Formater.isNull(listTemp))
			return null;
		TtktCmBienBan bb = (TtktCmBienBan) ((ArrayList) listTemp).get(0);
		// Thanh phan tham du
		criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
		criteria.addSearchItem(TtktCmThanhPhanThamDu.IdMaster, bb.getId());
		bb.setThanhPhanThamDu(dao.retrieveObjects(appContext, criteria));
		return bb;
	}

	/**
	 * Insert ki?m kê tài s?n
	 * 
	 * @param qdkk
	 *            Quy?t ??nh kiêm kê
	 * @param bbkk
	 *            Biên b?n ki?m kê
	 * @param request
	 * @param app
	 * @throws Exception
	 */
	public static void insertKkTs(TtktThQdKiemKe qdkk, TtktThBienBanKiemKe bbkk, HttpServletRequest request, ApplicationContext app) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			BaseHibernateDAO dao = new BaseHibernateDAO();
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();
			dao.saveObject(app, qdkk, Boolean.TRUE);
			//saveQdTtkt(qdkk, request, app, Boolean.TRUE);
			saveBbTtkt(bbkk, request, app, Boolean.TRUE);
			session.flush();
			tx.commit();
		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}

	/**
	 * L?u biên b?n ki?m kê
	 * 
	 * @param bbkk
	 *            Biên b?n ki?m kê
	 * @param request
	 * @param app
	 * @param isInTran
	 *            N?u là true thì không commit các th?c thi sql bên trong hàm, ng??c l?i các th?c thi sql bên trong s? ???c commit
	 * @throws Exception
	 */
	private static void saveBbTtkt(TtktThBienBanKiemKe bbkk, HttpServletRequest request, ApplicationContext app, Boolean isInTran) throws Exception {
		dao.saveObject(app, bbkk, Boolean.TRUE);
		Collection tptdDoanTtkt = bbkk.getDsDoanTtkt();
		Iterator iter = tptdDoanTtkt.iterator();
		while (iter.hasNext()) {
			dao.saveObject(app, (TtktCmThanhPhanThamDu) iter.next(), Boolean.TRUE);
		}

	}

	/**
	 * L?u quy?t ??nh kiêm kê tài s?n
	 * 
	 * @param qdkk
	 *            Quy?t ??nh kiêm kê
	 * @param request
	 * @param app
	 * @param isInTran
	 *            N?u là true thì không commit các th?c thi sql bên trong hàm, ng??c l?i các th?c thi sql bên trong s? ???c commit
	 * @throws Exception
	 */
	private static void saveQdTtkt(TtktThQdKiemKe qdkk, HttpServletRequest request, ApplicationContext app, Boolean isInTran) throws Exception {
		dao.saveObject(app, qdkk, Boolean.TRUE);
	}

	/**
	 * Xóa niêm phong h? s? tài li?u
	 * 
	 * @param npHsTl
	 *            Niêm phong h? s? tài li?u
	 * @param request
	 * @param app
	 * @throws Exception
	 */
	public static void deleteNiemPhongHsTl(TtktThQdNiemPhongHsTl npHsTl, HttpServletRequest request, ApplicationContext app) throws Exception {
		TtktThBbNiemPhong bbNp = npHsTl.getBbNiemPhong();
		TtktThBbMoNiemPhong bbMoNp = npHsTl.getBbMoNiemPhong();
		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			// xoa bien ban niem phong
			if (bbNp != null) {

				String sql3 = "delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER=" + bbNp.getIdTpThamDuDoanTtkt();
				statement.addBatch(sql3);
				String sql4 = "delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER=" + bbNp.getIdTpThamDuDviCnhanCoTs();
				statement.addBatch(sql4);
				String sql2 = "delete TTKT_TH_BB_NIEM_PHONG where ID = " + bbNp.getId();
				statement.addBatch(sql2);
			}
			// xoa bien ban mo niem phong
			if (bbMoNp != null) {

				String sql6 = "delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER=" + bbMoNp.getIdTpThamDuCacOngBa();
				statement.addBatch(sql6);
				String sql7 = "delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER=" + bbMoNp.getIdTpThamDuDoanTtkt();
				statement.addBatch(sql7);
				String sql5 = "delete TTKT_TH_BB_MO_NIEM_PHONG where ID = " + bbMoNp.getId();
				statement.addBatch(sql5);
			}
			// xoa quyet dinh
			if (npHsTl != null) {
				String sql = "delete TTKT_TH_QD_NIEM_PHONG_HS_TL where ID =" + npHsTl.getId();
				statement.addBatch(sql);
			}
			statement.executeBatch();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}
	}

	/**
	 * L?u niêm phong h? s? tài li?u
	 * 
	 * @param qdNP
	 *            Niêm phong h? s? tài li?u
	 * @param request
	 * @param app
	 * @throws Exception
	 */
	public static void saveNiemPhongHstl(TtktThQdNiemPhongHsTl qdNP, HttpServletRequest request, ApplicationContext app) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {

			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			BaseHibernateDAO dao = new BaseHibernateDAO();
			session = HibernateSessionFactory.currentSession();
			// ---------- Quyet dinh niem phong ---------------
			boolean isInsert = false;
			if (Formater.isNull(qdNP.getId())) {
				isInsert = true;
				qdNP.setId(KeyManagement.getGUID());
			}
			dao.saveOrUpdateObject(app, qdNP, Boolean.TRUE);

			// --------- Bien ban niem phong --------------
			TtktThBbNiemPhong bbNiemPhong = qdNP.getBbNiemPhong();
			if (isInsert) {
				bbNiemPhong.setId(KeyManagement.getGUID());
				bbNiemPhong.setIdQuyetDinhNp(qdNP.getId());
			}
			saveBbNiemPhong(app, bbNiemPhong, Boolean.TRUE, isInsert, tx, session, dao);

			// --------- Bien ban mo niem phong --------------
			TtktThBbMoNiemPhong bbMoNiemPhong = qdNP.getBbMoNiemPhong();
			if (isInsert) {
				bbMoNiemPhong.setId(KeyManagement.getGUID());
				bbMoNiemPhong.setIdQdMoNiemPhong(qdNP.getId());
			}
			saveBienBanMoNiemPhong(app, bbMoNiemPhong, Boolean.TRUE, isInsert, tx, session, dao);

			session.flush();
			tx.commit();
		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}
	}

	/**
	 * L?u biên b?n m? niêm phong
	 * 
	 * @param app
	 * @param bbMoNiemPhong
	 *            Biên b?n m? niêm phong
	 * @param isInTrans
	 *            N?u là true thì không commit các th?c thi sql bên trong hàm, ng??c l?i các th?c thi sql bên trong s? ???c commit
	 * @param isInsert
	 *            N?u là true thì insert, ng??c l?i thì update
	 * @param tx
	 *            Transaction bao các th?c thi sql trong hàm
	 * @param session
	 *            Session thu?c tx
	 * @param dao
	 * @throws Exception
	 */
	public static void saveBienBanMoNiemPhong(ApplicationContext app, TtktThBbMoNiemPhong bbMoNiemPhong, Boolean isInTrans, boolean isInsert, UserTransaction tx, Session session, BaseHibernateDAO dao)
			throws Exception {
		if (isInsert) {
			bbMoNiemPhong.setIdTpThamDuDoanTtkt(KeyManagement.getGUID());
			bbMoNiemPhong.setIdTpThamDuCacOngBa(KeyManagement.getGUID());
		} else {
			// Xoa bo cac thanh phan tham du khong con

			String sql = "delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + bbMoNiemPhong.getIdTpThamDuDoanTtkt();
			session.createSQLQuery(sql).executeUpdate();
			String sql2 = "delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + bbMoNiemPhong.getIdTpThamDuCacOngBa();
			session.createSQLQuery(sql2).executeUpdate();

		}
		dao.saveOrUpdateObject(app, bbMoNiemPhong, isInTrans);

		// Save thanh phan tham du
		Collection dsThanhPhanThamDu = bbMoNiemPhong.getDsDoanTtkt();
		if (dsThanhPhanThamDu != null) {
			Iterator iter = dsThanhPhanThamDu.iterator();
			while (iter.hasNext()) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
				thanhPhanThamDu.setId(KeyManagement.getGUID());
				if (isInsert)
					thanhPhanThamDu.setIdMaster(bbMoNiemPhong.getIdTpThamDuDoanTtkt());
				dao.saveObject(app, thanhPhanThamDu, isInTrans);
			}
		}

		Collection dsCacOngBa = bbMoNiemPhong.getDsCacOba();
		if (dsCacOngBa != null) {
			Iterator iter = dsCacOngBa.iterator();
			while (iter.hasNext()) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
				thanhPhanThamDu.setId(KeyManagement.getGUID());
				if (isInsert)
					thanhPhanThamDu.setIdMaster(bbMoNiemPhong.getIdTpThamDuCacOngBa());
				dao.saveObject(app, thanhPhanThamDu, isInTrans);
			}
		}

	}

	/**
	 * L?u biên b?n niêm phong
	 * 
	 * @param app
	 * @param bbNiemPhong
	 *            Biên b?n niêm phong
	 * @param isInTrans
	 *            N?u là true thì không commit các th?c thi sql bên trong hàm, ng??c l?i các th?c thi sql bên trong s? ???c commit
	 * @param isInsert
	 *            N?u là true thì insert, ng??c l?i thì update
	 * @param tx
	 *            Transaction bao các th?c thi sql trong hàm
	 * @param session
	 *            Session thu?c tx
	 * @param dao
	 * @throws Exception
	 */
	private static void saveBbNiemPhong(ApplicationContext app, TtktThBbNiemPhong bbNiemPhong, Boolean isInTrans, boolean isInsert, UserTransaction tx, Session session, BaseHibernateDAO dao)
			throws Exception {

		if (isInsert) {
			bbNiemPhong.setIdTpThamDuDoanTtkt(KeyManagement.getGUID());
			bbNiemPhong.setIdTpThamDuDviCnhanCoTs(KeyManagement.getGUID());
		} else {
			// Xoa bo cac thanh phan tham du khong con

			String sql = "delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + bbNiemPhong.getIdTpThamDuDoanTtkt();
			session.createSQLQuery(sql).executeUpdate();
			String sql2 = "delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + bbNiemPhong.getIdTpThamDuDviCnhanCoTs();
			session.createSQLQuery(sql2).executeUpdate();

		}
		dao.saveOrUpdateObject(app, bbNiemPhong, isInTrans);

		// Save thanh phan tham du

		Collection dsThanhPhanThamDu = bbNiemPhong.getDsDoanTtkt();
		if (dsThanhPhanThamDu != null) {
			Iterator iter = dsThanhPhanThamDu.iterator();
			while (iter.hasNext()) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
				thanhPhanThamDu.setId(KeyManagement.getGUID());
				if (isInsert)
					thanhPhanThamDu.setIdMaster(bbNiemPhong.getIdTpThamDuDoanTtkt());
				dao.saveObject(app, thanhPhanThamDu, isInTrans);
			}

		}

		Collection dsDvCoTlNp = bbNiemPhong.getDsDvCoTlNp();
		if (dsDvCoTlNp != null) {
			Iterator iter = dsDvCoTlNp.iterator();
			while (iter.hasNext()) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
				thanhPhanThamDu.setId(KeyManagement.getGUID());
				if (isInsert)
					thanhPhanThamDu.setIdMaster(bbNiemPhong.getIdTpThamDuDviCnhanCoTs());
				dao.saveObject(app, thanhPhanThamDu, isInTrans);
			}
		}

	}

	/**
	 * C?p nh?t báo cáo kh?o sát
	 * 
	 * @param request
	 * @param appConText
	 * @param cbForm
	 *            Ch?a các thông tin tên file, lo?i file
	 */
	public static void UpdateBaoCaoKs(HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			FormFile formFile = cbForm.getFileBCKS();
			String id = KeyManagement.getGUID();
			// Luu file
			UploadAction.saveFile(formFile, id);

			conn = DataSourceConfiguration.getConnection();
			String tenNsd = appConText.getTenNsd();
			String fileName = formFile.getFileName();
			String contentType = formFile.getContentType();

			// insert to DB
			String sql = "insert into ktnb_file (MA_FILE,MA_DON,TEN_FILE,LOAI_FILE,NGUOI_CAP_NHAT,NOI_DUNG, SO_TRANG, NGHIEP_VU_PATH) values (?,?,?,?,?,BFILENAME('KTNB_FILE_DIR','" + id + "'),?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, cbForm.getIdCuocTtkt());
			ps.setString(3, fileName);
			ps.setString(4, contentType);
			ps.setString(5, tenNsd);
			ps.setString(6, "1");
			ps.setString(7, Constants.TTKT_NV_BCKS);
			ps.executeUpdate();
			formFile.destroy();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
	}

	/**
	 * L?u danh sách thành viên ?oàn
	 * 
	 * @param appConText
	 * @param dsTvd
	 *            Danh sách thành viên ?oàn
	 * @throws Exception
	 */
	public static void saveDsTvd(ApplicationContext appConText, TtktCbDsTvDoan dsTvd) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
				throw e1;
			}
			session = HibernateSessionFactory.currentSession();
			BaseHibernateDAO dao = new BaseHibernateDAO();

			// Save thanh vien doan
			dao.updateObject(appConText, dsTvd, Boolean.TRUE);

			// Cap nhat trang thai cuoc Ttkt neu can.
			if (isNewStatus(dsTvd.getIdCuocTtkt(), appConText, Constants.TT_TTKT_CDTVD) && !Formater.isNull(dsTvd.getNoiPheDuyet())) {
				String sql = buidSqlUpdateTrangThaiCuocTtkt(dsTvd.getIdCuocTtkt(), Constants.TT_TTKT_CDTVD);
				session.createSQLQuery(sql).executeUpdate();
			}

			// Save chi tiet danh sach thanh vien doan
			// Xoa chi tiet danh sach thanh vien cu
			String sql = "delete ttkt_cb_chi_tiet_ds_tv_doan where chuc_vu_trong_doan != '" + Constants.TTKT_CVTD_TD + "' and id_ds_tvd = '" + dsTvd.getId() + "'";
			session.createSQLQuery(sql).executeUpdate();
			// Them chi tiet danh sach thanh vien moi
			Collection listDsTvd = dsTvd.getChiTietDanhSachTV();
			Iterator iter = listDsTvd.iterator();
			while (iter.hasNext())
				dao.saveObject(appConText, (TtktCbChiTietDsTvDoan) iter.next(), Boolean.TRUE);

			session.flush();
			tx.commit();
			if (!Formater.isNull(dsTvd.getNoiPheDuyet())) {
				appConText.setTrangThaiCuocTtkt(dsTvd.getIdCuocTtkt(), Constants.TT_TTKT_CDTVD);
			}

		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}

	/**
	 * L?u quy?t ??nh Thanh tra Ki?m tra
	 * 
	 * @param appConText
	 * @param qdTtkt
	 *            Quy?t ??nh Thanh tra Ki?m tra
	 */
	public static void saveQuyetDinh(ApplicationContext appConText, TtktCbQd qdTtkt) throws Exception {

		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			BaseHibernateDAO dao = new BaseHibernateDAO();
			session = HibernateSessionFactory.currentSession();
			if (!Formater.isNull(qdTtkt.getSoQuyetDinh()))
				session.createSQLQuery(buidSqlUpdateTrangThaiCuocTtkt(qdTtkt.getIdCuocTtkt(), Constants.TT_TTKT_QD)).executeUpdate();
			if (Formater.isNull(qdTtkt.getId())) {
				qdTtkt.setId(KeyManagement.getGUID());
				dao.saveObject(appConText, qdTtkt, Boolean.TRUE);
			} else {
				dao.updateObject(appConText, qdTtkt, Boolean.TRUE);
			}
			session.flush();
			tx.commit();
			if (!Formater.isNull(qdTtkt.getSoQuyetDinh()) && TtktService.isNewStatus(qdTtkt.getIdCuocTtkt(), appConText, Constants.TT_TTKT_QD))
				appConText.setTrangThaiCuocTtkt(qdTtkt.getIdCuocTtkt(), Constants.TT_TTKT_QD);

		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}

	/**
	 * L?u k? ho?ch Thanh tra Ki?m tra
	 * 
	 * @param appConText
	 * @param khTtkt
	 *            K? ho?ch Thanh tra Ki?m tra
	 */
	public static void saveKeHoach1(ApplicationContext appConText, TtktCbKhTtkt khTtkt) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			BaseHibernateDAO dao = new BaseHibernateDAO();
			session = HibernateSessionFactory.currentSession();
			boolean isInsert = false;
			if (Formater.isNull(khTtkt.getId())) {
				khTtkt.setId(KeyManagement.getGUID());
				isInsert = true;
			}
			// Cap nhat trang thai cuoc Ttkt
			if (isInsert) {
				dao.saveObject(appConText, khTtkt, Boolean.TRUE);
				if (isNewStatus(khTtkt.getIdCuocTtkt(), appConText, Constants.TT_TTKT_KH))
					session.createSQLQuery("UPDATE TTKT_KH_CUOC_TTKT set TRANG_THAI= '" + Constants.TT_TTKT_KH + "' WHERE id=" + khTtkt.getIdCuocTtkt()).executeUpdate();
			} else {
				dao.updateObject(appConText, khTtkt, Boolean.TRUE);
			}

			session.flush();
			tx.commit();
		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}

	/**
	 * L?u k? ho?ch Thanh tra Ki?m tra
	 * 
	 * @param appConText
	 * @param khTtkt
	 *            K? ho?ch Thanh tra Ki?m tra
	 */
	public static void saveKeHoach2(ApplicationContext appConText, TtktCbKhTtkt khTtkt) throws Exception {
		String sql;
		// Insert
		if (Formater.isNull(khTtkt.getId())) {
			sql = "insert into TTKT_CB_KH_TTKT (ID, ID_CUOC_TTKT,DIA_DIEM_LAP, NGAY_LAP";
			if (!Formater.isNull(khTtkt.getMucDich()))
				sql += ", MUC_DICH";
			if (!Formater.isNull(khTtkt.getYeuCau()))
				sql += ", YEU_CAU";
			if (!Formater.isNull(khTtkt.getNoiDung()))
				sql += ", NOI_DUNG";
			if (!Formater.isNull(khTtkt.getPhuongPhapTienHanh()))
				sql += ", PHUONG_PHAP_TIEN_HANH";
			if (!Formater.isNull(khTtkt.getToChucThucHien()))
				sql += ", TO_CHUC_THUC_HIEN";
			if (!Formater.isNull(khTtkt.getCheDoThongTinBaoCao()))
				sql += ", CHE_DO_THONG_TIN_BAO_CAO";
			if (!Formater.isNull(khTtkt.getDieuKienVatChatDamBao()))
				sql += ", DIEU_KIEN_VAT_CHAT_DAM_BAO";
			if (!Formater.isNull(khTtkt.getNhungDieuKienKhac()))
				sql += ", NHUNG_DIEU_KIEN_KHAC";
			sql += ", NOI_PHE_DUYET";
			sql += ", NGAY_PHE_DUYET";
			if (!Formater.isNull(khTtkt.getFileDinhKem().getFileName())) {
				sql += ", MA_FILE";
				sql += ", TEN_FILE";
				sql += ", LOAI_FILE";
				sql += ", FILE_DINH_KEM";
			}
			sql += ")";
			sql += "values(";
			sql += KeyManagement.getGUID();
			sql += ", " + khTtkt.getIdCuocTtkt();
			sql += ", '" + khTtkt.getDiaDiemLap() + "'";
			sql += ", to_date('" + Formater.date2str(khTtkt.getNgayLap()) + "', 'dd/mm/yyyy')";
			if (!Formater.isNull(khTtkt.getMucDich()))
				sql += ", '" + khTtkt.getMucDich() + "'";
			if (!Formater.isNull(khTtkt.getYeuCau()))
				sql += ", '" + khTtkt.getYeuCau() + "'";
			if (!Formater.isNull(khTtkt.getNoiDung()))
				sql += ", '" + khTtkt.getNoiDung() + "'";
			if (!Formater.isNull(khTtkt.getPhuongPhapTienHanh()))
				sql += ", '" + khTtkt.getPhuongPhapTienHanh() + "'";
			if (!Formater.isNull(khTtkt.getToChucThucHien()))
				sql += ", '" + khTtkt.getToChucThucHien() + "'";
			if (!Formater.isNull(khTtkt.getCheDoThongTinBaoCao()))
				sql += ", '" + khTtkt.getCheDoThongTinBaoCao() + "'";
			if (!Formater.isNull(khTtkt.getDieuKienVatChatDamBao()))
				sql += ", '" + khTtkt.getDieuKienVatChatDamBao() + "'";
			if (!Formater.isNull(khTtkt.getNhungDieuKienKhac()))
				sql += ", '" + khTtkt.getNhungDieuKienKhac() + "'";
			sql += ", '" + khTtkt.getNoiPheDuyet() + "'";
			sql += ", to_date('" + Formater.date2str(khTtkt.getNgayPheDuyet()) + "', 'dd/mm/yyyy')";
			if (!Formater.isNull(khTtkt.getFileDinhKem().getFileName())) {
				khTtkt.setMaFile(KeyManagement.getGUID());

				// Upload file
				FormFile fileDk = khTtkt.getFileDinhKem();
				UploadAction.saveFile(fileDk, khTtkt.getMaFile());

				// Upload DB
				sql += ", '" + khTtkt.getMaFile() + "'";
				sql += ", '" + fileDk.getFileName() + "'";
				sql += ", '" + fileDk.getContentType() + "'";
				sql += ", BFILENAME('KTNB_FILE_DIR','" + khTtkt.getMaFile() + "')";
			}
			sql += ")";
		} else {
			sql = "update TTKT_CB_KH_TTKT set";
			sql += " DIA_DIEM_LAP = '" + khTtkt.getDiaDiemLap() + "'";
			sql += ", NGAY_LAP = to_date('" + Formater.date2str(khTtkt.getNgayLap()) + "', 'dd/mm/yyyy')";
			if (!Formater.isNull(khTtkt.getMucDich())) {
				sql += ", MUC_DICH = '" + khTtkt.getMucDich() + "'";
			} else {
				sql += ", MUC_DICH = null";
			}

			if (!Formater.isNull(khTtkt.getYeuCau())) {
				sql += ", YEU_CAU = '" + khTtkt.getYeuCau() + "'";
			} else {
				sql += ", YEU_CAU = null";
			}
			if (!Formater.isNull(khTtkt.getNoiDung())) {
				sql += ", NOI_DUNG = '" + khTtkt.getNoiDung() + "'";
			} else {
				sql += ", NOI_DUNG = null";
			}
			if (!Formater.isNull(khTtkt.getPhuongPhapTienHanh())) {
				sql += ", PHUONG_PHAP_TIEN_HANH = '" + khTtkt.getPhuongPhapTienHanh() + "'";
			} else {
				sql += ", PHUONG_PHAP_TIEN_HANH = null";
			}
			if (!Formater.isNull(khTtkt.getToChucThucHien())) {
				sql += ", TO_CHUC_THUC_HIEN = '" + khTtkt.getToChucThucHien() + "'";
			} else {
				sql += ", TO_CHUC_THUC_HIEN = null";
			}
			if (!Formater.isNull(khTtkt.getCheDoThongTinBaoCao())) {
				sql += ", CHE_DO_THONG_TIN_BAO_CAO = '" + khTtkt.getCheDoThongTinBaoCao() + "'";
			} else {
				sql += ", CHE_DO_THONG_TIN_BAO_CAO = null";
			}
			if (!Formater.isNull(khTtkt.getDieuKienVatChatDamBao())) {
				sql += ", DIEU_KIEN_VAT_CHAT_DAM_BAO = '" + khTtkt.getDieuKienVatChatDamBao() + "'";
			} else {
				sql += ", DIEU_KIEN_VAT_CHAT_DAM_BAO = null";
			}
			if (!Formater.isNull(khTtkt.getNhungDieuKienKhac())) {
				sql += ", NHUNG_DIEU_KIEN_KHAC = '" + khTtkt.getNhungDieuKienKhac() + "'";
			} else {
				sql += ", NHUNG_DIEU_KIEN_KHAC = null";
			}
			if (!Formater.isNull(khTtkt.getNoiPheDuyet())) {
				sql += ", NOI_PHE_DUYET = '" + khTtkt.getNoiPheDuyet() + "'";
			} else {
				sql += ", NOI_PHE_DUYET = null";
			}
			if (khTtkt.getNgayPheDuyet() != null) {
				sql += ", NGAY_PHE_DUYET = to_date('" + Formater.date2str(khTtkt.getNgayPheDuyet()) + "', 'dd/mm/yyyy')";
			} else {
				sql += ", NGAY_PHE_DUYET = null";
			}

			FormFile fileDk = khTtkt.getFileDinhKem();
			if (Formater.isNull(khTtkt.getMaFile())) {
				if (Formater.isNull(fileDk.getFileName())) {
					sql += ", MA_FILE = null";
					sql += ", TEN_FILE = null";
					sql += ", LOAI_FILE = null";
					sql += ", FILE_DINH_KEM = null";

				} else {
					// Upload file moi
					khTtkt.setMaFile(KeyManagement.getGUID());
					UploadAction.saveFile(fileDk, khTtkt.getMaFile());
					sql += ", MA_FILE = '" + khTtkt.getMaFile() + "'";
					sql += ", TEN_FILE = '" + fileDk.getFileName() + "'";
					sql += ", LOAI_FILE = '" + fileDk.getContentType() + "'";
					sql += ", FILE_DINH_KEM = BFILENAME('KTNB_FILE_DIR','" + khTtkt.getMaFile() + "')";
				}

			} else {
				// Neu co file cu Xoa file cu
				UploadAction.deleteFile(khTtkt.getMaFile());
				// Neu co file moi
				if (!Formater.isNull(fileDk.getFileName())) {
					khTtkt.setMaFile(KeyManagement.getGUID());
					// Upload file moi
					UploadAction.saveFile(fileDk, khTtkt.getMaFile());
					sql += ", TEN_FILE = '" + fileDk.getFileName() + "'";
					sql += ", LOAI_FILE = '" + fileDk.getContentType() + "'";
					sql += ", FILE_DINH_KEM = BFILENAME('KTNB_FILE_DIR','" + khTtkt.getMaFile() + "')";

				} else {// Khong co file moi
					sql += ", MA_FILE = null";
					sql += ", TEN_FILE = null";
					sql += ", LOAI_FILE = null";
					sql += ", FILE_DINH_KEM = null";
				}
			}

			sql += "where id = " + khTtkt.getId();

		}

		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			if (TtktService.isNewStatus(khTtkt.getIdCuocTtkt(), appConText, Constants.TT_TTKT_KH)) {
				statement.addBatch(sql);
				statement.addBatch(buidSqlUpdateTrangThaiCuocTtkt(khTtkt.getIdCuocTtkt(), Constants.TT_TTKT_KH));
				statement.executeBatch();
				conn.commit();
				appConText.setTrangThaiCuocTtkt(khTtkt.getIdCuocTtkt(), Constants.TT_TTKT_KH);

			} else {
				statement.execute(sql);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}

	}

	/**
	 * L?u k? ho?ch Thanh tra Ki?m tra
	 * 
	 * @param appConText
	 * @param khTtkt
	 *            K? ho?ch Thanh tra Ki?m tra
	 */
	public static void saveKeHoach(ApplicationContext appConText, TtktCbKhTtkt khTtkt) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			BaseHibernateDAO dao = new BaseHibernateDAO();
			session = HibernateSessionFactory.currentSession();

			if (Formater.isNull(khTtkt.getId())) {
				khTtkt.setId(KeyManagement.getGUID());
				FormFile fileDk = khTtkt.getFileDinhKem();
				if (fileDk != null) {
					khTtkt.setMaFile(KeyManagement.getGUID());
					// Upload file
					try {
						UploadAction.saveFile(fileDk, khTtkt.getMaFile());
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}
				}
				dao.saveObject(appConText, khTtkt, Boolean.TRUE);
				if (isNewStatus(khTtkt.getIdCuocTtkt(), appConText, Constants.TT_TTKT_KH) && !Formater.isNull(khTtkt.getNoiPheDuyet()) && !Formater.isNull(khTtkt.getYkienPheDuyetKh()))
					session.createSQLQuery(buidSqlUpdateTrangThaiCuocTtkt(khTtkt.getIdCuocTtkt(), Constants.TT_TTKT_KH)).executeUpdate();
			} else {
				FormFile fileDk = khTtkt.getFileDinhKem();
				if (khTtkt.isHaveFileAttack()) {// Dinh kem file
					if (fileDk != null) {// Co file
						// Xoa file cu neu co
						if (!Formater.isNull(khTtkt.getMaFile()))							
							UploadAction.deleteFile(khTtkt.getMaFile());
						else
							// Khong co file cu tao ma moi
							khTtkt.setMaFile(KeyManagement.getGUID());
						try {// Upload file
							UploadAction.saveFile(fileDk, khTtkt.getMaFile());
						} catch (Exception e) {
							e.printStackTrace();
							throw e;
						}

					}

				} else {// Khong dinh kem file
					if (!Formater.isNull(khTtkt.getMaFile())) {// Xoa file cu
						// neu co
						UploadAction.deleteFile(khTtkt.getMaFile());
						khTtkt.setMaFile(null);
					}

				}

				dao.updateObject(appConText, khTtkt, Boolean.TRUE);
				if (isNewStatus(khTtkt.getIdCuocTtkt(), appConText, Constants.TT_TTKT_KH) && !Formater.isNull(khTtkt.getNoiPheDuyet()) && !Formater.isNull(khTtkt.getYkienPheDuyetKh()))
					session.createSQLQuery(buidSqlUpdateTrangThaiCuocTtkt(khTtkt.getIdCuocTtkt(), Constants.TT_TTKT_KH)).executeUpdate();

			}

			session.flush();
			tx.commit();
			if (TtktService.isNewStatus(khTtkt.getIdCuocTtkt(), appConText, Constants.TT_TTKT_KH) && !Formater.isNull(khTtkt.getNoiPheDuyet()) && !Formater.isNull(khTtkt.getYkienPheDuyetKh()))
				appConText.setTrangThaiCuocTtkt(khTtkt.getIdCuocTtkt(), Constants.TT_TTKT_KH);
		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}

	/**
	 * L?u ?? c??ng Thanh tra Ki?m tra
	 * 
	 * @param appConText
	 * @param deCuong ??
	 *            c??ng Thanh tra Ki?m tra
	 */
	public static void saveDeCuong(ApplicationContext appConText, TtktCbDeCuong deCuong) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			BaseHibernateDAO dao = new BaseHibernateDAO();
			session = HibernateSessionFactory.currentSession();

			/** Doan nay sua doi lai khong can phai luu vao ttkt_hs_tl
			// Bao cao
			if (Formater.isNull(deCuong.getIdBaoCaoPhaiCbiCungCap())) {
				deCuong.setIdBaoCaoPhaiCbiCungCap(KeyManagement.getGUID());
			} else {
				session.createSQLQuery("delete TTKT_CM_HS_TL where MASTER_ID = '" + deCuong.getIdBaoCaoPhaiCbiCungCap() + "'").executeUpdate();
			}
			if (!Formater.isNull(deCuong.getBaoCaoPhaiCbiCungCap())) {
				Collection baoCaoPhaiCbiCungCap = deCuong.getBaoCaoPhaiCbiCungCap();
				Iterator iter = baoCaoPhaiCbiCungCap.iterator();
				while (iter.hasNext()) {
					TtktCmHsTl hsTl = (TtktCmHsTl) iter.next();
					hsTl.setMasterId(deCuong.getIdBaoCaoPhaiCbiCungCap());
					hsTl.setId(KeyManagement.getGUID());
					dao.saveObject(appConText, hsTl, Boolean.TRUE);
				}
			}

			// Ho so tai lieu
			if (Formater.isNull(deCuong.getIdHstlPhaiCbiCungCap())) {
				deCuong.setIdHstlPhaiCbiCungCap(KeyManagement.getGUID());
			} else {
				session.createSQLQuery("delete TTKT_CM_HS_TL where MASTER_ID = '" + deCuong.getIdHstlPhaiCbiCungCap() + "'").executeUpdate();
			}
			if (!Formater.isNull(deCuong.getHstlPhaiCbiCungCap())) {
				Collection hstlPhaiCbiCungCap = deCuong.getHstlPhaiCbiCungCap();
				Iterator iter = hstlPhaiCbiCungCap.iterator();
				while (iter.hasNext()) {
					TtktCmHsTl hsTl = (TtktCmHsTl) iter.next();
					hsTl.setMasterId(deCuong.getIdHstlPhaiCbiCungCap());
					hsTl.setId(KeyManagement.getGUID());
					dao.saveObject(appConText, hsTl, Boolean.TRUE);
				}
			}
			 * 
			 */
			// De cuong
			if (Formater.isNull(deCuong.getId())) {
				deCuong.setId(KeyManagement.getGUID());
				FormFile fileDk = deCuong.getFileDinhKem();
				if (fileDk != null) {
					deCuong.setMaFile(KeyManagement.getGUID());
					// Upload file
					UploadAction.saveFile(fileDk, deCuong.getMaFile());
				}
				deCuong.setId(KeyManagement.getGUID());
				dao.saveObject(appConText, deCuong, Boolean.TRUE);
				if (isNewStatus(deCuong.getIdCuocTtkt(), appConText, Constants.TT_TTKT_DC))
					session.createSQLQuery("UPDATE TTKT_KH_CUOC_TTKT set TRANG_THAI= '" + Constants.TT_TTKT_DC + "' WHERE id=" + deCuong.getIdCuocTtkt()).executeUpdate();
			} else {
				FormFile fileDk = deCuong.getFileDinhKem();
				if (deCuong.isHaveFileAttack()) {// Dinh kem file
					if (fileDk != null) {// Co file
						// Xoa file cu neu co
						if (!Formater.isNull(deCuong.getMaFile()))
							UploadAction.deleteFile(deCuong.getMaFile());
						else
							// Khong co file cu tao ma moi
							deCuong.setMaFile(KeyManagement.getGUID());
						try {// Upload file
							UploadAction.saveFile(fileDk, deCuong.getMaFile());
						} catch (Exception e) {
							e.printStackTrace();
							throw e;
						}

					}

				} else {// Khong dinh kem file
					if (!Formater.isNull(deCuong.getMaFile())) {// Xoa file cu
						// neu co
						UploadAction.deleteFile(deCuong.getMaFile());
						deCuong.setMaFile(null);
					}

				}
				dao.updateObject(appConText, deCuong, Boolean.TRUE);
			}

			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			HibernateSessionFactory.rollbackQuiet();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}

	/**
	 * L?u biên b?n h?p ?oàn tri?n khai c?a cu?c Thanh tra Ki?m tra
	 * 
	 * @param appConText
	 * @param bbHopDoanTrienKhai
	 *            Biên b?n h?p ?oàn tri?n khai
	 */
	public static void saveBienBanHopDoanTK(ApplicationContext appConText, TtktCmBienBan bbHopDoanTrienKhai) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			BaseHibernateDAO dao = new BaseHibernateDAO();
			session = HibernateSessionFactory.currentSession();

			if (Formater.isNull(bbHopDoanTrienKhai.getId())) {
				bbHopDoanTrienKhai.setId(KeyManagement.getGUID());
				dao.saveObject(appConText, bbHopDoanTrienKhai, Boolean.TRUE);
				if (isNewStatus(bbHopDoanTrienKhai.getIdCuocTtkt(), appConText, Constants.TT_TTKT_HOP))
					session.createSQLQuery("UPDATE TTKT_KH_CUOC_TTKT set TRANG_THAI= '" + Constants.TT_TTKT_HOP + "' WHERE id=" + bbHopDoanTrienKhai.getIdCuocTtkt()).executeUpdate();

				// Save bien ban hop
				Collection dsThanhPhanThamDu = bbHopDoanTrienKhai.getThanhPhanThamDu();
				if (!Formater.isNull(dsThanhPhanThamDu)) {
					Iterator iter = dsThanhPhanThamDu.iterator();
					while (iter.hasNext()) {
						TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
						thanhPhanThamDu.setIdMaster(bbHopDoanTrienKhai.getId());
						thanhPhanThamDu.setId(KeyManagement.getGUID());
						dao.saveObject(appConText, thanhPhanThamDu, Boolean.TRUE);
					}
				}

			} else {
				session.createSQLQuery("delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER = '" + bbHopDoanTrienKhai.getId() + "'").executeUpdate();
				dao.updateObject(appConText, bbHopDoanTrienKhai, Boolean.TRUE);
				// Save bien ban hop
				Collection dsThanhPhanThamDu = bbHopDoanTrienKhai.getThanhPhanThamDu();
				if (!Formater.isNull(dsThanhPhanThamDu)) {
					Iterator iter = dsThanhPhanThamDu.iterator();
					while (iter.hasNext()) {
						TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
						thanhPhanThamDu.setId(KeyManagement.getGUID());
						dao.saveObject(appConText, thanhPhanThamDu, Boolean.TRUE);
					}
				}
			}

			session.flush();
			tx.commit();
		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}

	/**
	 * L?u biên b?n h?p rút kinh nghi?m ?oàn Thanh tra Ki?m tra
	 * 
	 * @param appConText
	 * @param bbHopRutKinhNghiem
	 *            Biên b?n h?p rút kinh nghi?m
	 */
	public static void saveBienBanHopRutKinhNghiem(ApplicationContext appConText, TtktCmBienBan bbHopRutKinhNghiem) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			BaseHibernateDAO dao = new BaseHibernateDAO();
			session = HibernateSessionFactory.currentSession();

			// Save bien ban hop
			boolean isInsert = false;

			if (TtktService.isNewStatus(bbHopRutKinhNghiem.getIdCuocTtkt(), appConText, Constants.TT_TTKT_HOPRKN)) {
				bbHopRutKinhNghiem.setId(KeyManagement.getGUID());
				isInsert = true;
				// Cap nhat trang thai cuoc ttkt
				session.createSQLQuery(buidSqlUpdateTrangThaiCuocTtkt(bbHopRutKinhNghiem.getIdCuocTtkt(), Constants.TT_TTKT_HOPRKN)).executeUpdate();

			} else {
				if (Formater.isNull(bbHopRutKinhNghiem.getId()))
					bbHopRutKinhNghiem.setId(TtktService.getBbHopRutKinhNghiemDoan(appConText, bbHopRutKinhNghiem.getIdCuocTtkt()).getId());
				// Xoa thanh phan tham du hop doan trien khai cu
				session.createSQLQuery("delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER = '" + bbHopRutKinhNghiem.getId() + "'").executeUpdate();

			}
			// Insert thanh phan tham du moi
			Collection listThanhPhanThamDu = bbHopRutKinhNghiem.getThanhPhanThamDu();
			if (!Formater.isNull(listThanhPhanThamDu)) {
				Iterator iter = listThanhPhanThamDu.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setIdMaster(bbHopRutKinhNghiem.getId());
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					dao.saveObject(appConText, thanhPhanThamDu, Boolean.TRUE);
				}
			}
			if (isInsert) {
				dao.saveObject(appConText, bbHopRutKinhNghiem, Boolean.TRUE);
			} else
				dao.updateObject(appConText, bbHopRutKinhNghiem, Boolean.TRUE);

			session.flush();
			tx.commit();
			if (isInsert)
				appConText.setTrangThaiCuocTtkt(bbHopRutKinhNghiem.getIdCuocTtkt(), Constants.TT_TTKT_HOPRKN);
		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}

	/**
	 * L?y danh sách tr?ng thái ?ng v?i tr?ng thái truy?n vào
	 * <p>
	 * Các giá tr? truy?n vào s? d?ng trong ?ng d?ng là Chu?n b? ti?n hanh, Ti?n hành, K?t thuc
	 * 
	 * @param appContext
	 * @param trangThaiHienTai
	 *            Tr?ng thái c?n l?y danh sách tr?ng thái bên trong
	 * @return
	 */
	public static Collection getDsTrangThaiHopLe(ApplicationContext appContext, String trangThaiHienTai) {
		int indexOfTrangThaiHienTai = TtktService.getIndexOfTrangThai(trangThaiHienTai);
		Collection dsTrangThaiHopLe = new ArrayList();
		for (int i = indexOfTrangThaiHienTai - 1; i < Constants.ARR_TRANG_THAI_CUOC_TTKT.length; i++)
			dsTrangThaiHopLe.add(Constants.ARR_TRANG_THAI_CUOC_TTKT[i].trim());
		return dsTrangThaiHopLe;
	}

	/**
	 * L?y công b? quy?t ??nh
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return
	 */
	public static TtktThCongBoQd getCongBoQd(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThCongBoQd.class);
		criteria.addSearchItem(TtktThCongBoQd.IdCuocTtkt, cuocTtktId);
		ArrayList lstTemp = (ArrayList) dao.retrieveObjects(appContext, criteria);
		if (Formater.isNull(lstTemp))
			return null;
		TtktThCongBoQd congBoQd = (TtktThCongBoQd) lstTemp.get(0);

		// Dai dien co quan ban hanh quyet dinh
		String idDaiDienCqBanHanhQd = congBoQd.getIdDaiDienCqBanHanhQd();
		if (!Formater.isNull(idDaiDienCqBanHanhQd)) {
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem(TtktCmThanhPhanThamDu.IdMaster, idDaiDienCqBanHanhQd);
			congBoQd.setDsDaiDienCqtBanHanhQD(dao.retrieveObjects(appContext, criteria));
		}

		// Dai dien co quan quan ly cap tren
		String idDaiDienCqqlCapTren = congBoQd.getIdDaiDienCqqlCapTren();
		if (!Formater.isNull(idDaiDienCqqlCapTren)) {
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem(TtktCmThanhPhanThamDu.IdMaster, idDaiDienCqqlCapTren);
			congBoQd.setDsDaiDienCqqlCapTren(dao.retrieveObjects(appContext, criteria));
		}

		// Dai dien doan Ttkt
		String idDaiDienDoanTtkt = congBoQd.getIdDaiDienDoanTtkt();
		if (!Formater.isNull(idDaiDienDoanTtkt)) {
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem(TtktCmThanhPhanThamDu.IdMaster, idDaiDienDoanTtkt);
			congBoQd.setDsDaiDienDoanTtkt(dao.retrieveObjects(appContext, criteria));
		}

		// Dai dien don vi duoc Ttkt
		String idDaiDienDonViDuocTtkt = congBoQd.getIdDaiDienDonViDuocTtkt();
		if (!Formater.isNull(idDaiDienDoanTtkt)) {
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem(TtktCmThanhPhanThamDu.IdMaster, idDaiDienDonViDuocTtkt);
			congBoQd.setDsDaiDienDonViDuocTtkt(dao.retrieveObjects(appContext, criteria));
		}
		return congBoQd;
	}

	/**
	 * L?y chi ti?t danh sách thành viên ?oàn
	 * 
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return Danh sách thành viên ?oàn
	 */
	public static Collection getDanhSachThanhVienDoan(String cuocTtktId) {
		String sql = "select t2.* from TTKT_CB_DS_TV_DOAN t1, TTKT_CB_CHI_TIET_DS_TV_DOAN t2";
		sql += " where t1.id = t2.ID_DS_TVD and t1.isnew = 1 and t1.ID_CUOC_TTKT = '" + cuocTtktId + "'";
		Session session = HibernateSessionFactory.currentSession();
		return session.createSQLQuery(sql).addEntity(TtktCbChiTietDsTvDoan.class).list();
	}

	/**
	 * L?y nh?t ký thanh tra ki?m tra
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return Nh?t ký cu?c Thanh tra Ki?m tra
	 */
	public static Collection getNhatKyTtkt(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThNhatKy.class);
		criteria.addSearchItem(TtktThNhatKy.IdCuocTtkt, cuocTtktId);
		return dao.retrieveObjects(appContext, criteria);
	}

	/**
	 * L?y Danh sách biên b?n chi ti?t
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return Danh sách các biên b?n chi ti?t
	 */
	public static Collection getBienBanChiTiet(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThBbChitietvatonghop.class);
		criteria.addSearchItem(TtktThBbChitietvatonghop.IdCuocTtkt, cuocTtktId);
		criteria.addSearchItem(TtktThBbChitietvatonghop.LoaiBb, Constants.TTKT_BB_CT);
		return dao.retrieveObjects(appContext, criteria);

	}

	/**
	 * L?y danh sách bàn giao h? s? tài li?u cho tr??ng ?oàn
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return Danh sách bàn giao h? s? tài li?u
	 */
	public static Collection getBanGiaoHstlChoTd(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThBanGiaoHstlChoTd.class);
		criteria.addSearchItem("idCuocTtkt", cuocTtktId);
		return dao.retrieveObjects(appContext, criteria);
	}

	/**
	 * L?y quy?t ??nh niêm phong
	 * 
	 * @param app
	 * @param id
	 *            Id quy?t ??nh niêm phong
	 * @return Quy?t ??nh niêm phong
	 * @throws Exception
	 */
	public static TtktThQdNiemPhongHsTl getQdNiemPhong(ApplicationContext app, String id) throws Exception {
		if (id != null) {
			TtktThQdNiemPhongHsTl npHsTl = (TtktThQdNiemPhongHsTl) dao.retrieveObject(app, TtktThQdNiemPhongHsTl.class, id);
			// ban niem phong
			npHsTl.setBbNiemPhong(getBienBanNiempPhong(app, npHsTl.getId()));

			// set bien ban giao nhan
			npHsTl.setBbMoNiemPhong(getBienBanMoNiemPhong(app, npHsTl.getId()));
			return npHsTl;
		} else
			return null;
	}

	/**
	 * L?y biên b?n m? niêm phong theo Id quy?t ??nh niêm phong
	 * 
	 * @param app
	 * @param qdNiemPhongId
	 *            Id quy?t ??nh niêm phong
	 * @return
	 */
	public static TtktThBbMoNiemPhong getBienBanMoNiemPhong(ApplicationContext app, String qdNiemPhongId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThBbMoNiemPhong.class);
		criteria.addSearchItem(TtktThBbMoNiemPhong.IdQuyetMoDinhNp, qdNiemPhongId);
		Collection temp = dao.retrieveObjects(app, criteria);
		if (Formater.isNull(temp))
			return null;
		TtktThBbMoNiemPhong bbMoNiemPhong = (TtktThBbMoNiemPhong) ((ArrayList) temp).get(0);

		// Load thanh phan tham du doan ttkt
		criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
		criteria.addSearchItem("idMaster", bbMoNiemPhong.getIdTpThamDuDoanTtkt());
		bbMoNiemPhong.setDsDoanTtkt(dao.retrieveObjects(app, criteria));

		// Load thanh phan tham du doan ttkt
		criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
		criteria.addSearchItem("idMaster", bbMoNiemPhong.getIdTpThamDuCacOngBa());
		bbMoNiemPhong.setDsCacOba(dao.retrieveObjects(app, criteria));

		return bbMoNiemPhong;

	}

	/**
	 * L?y biên b?n niêm phong theo quy?t ??nh niêm phong
	 * 
	 * @param app
	 * @param qdNiemPhongId
	 *            Id quy?t ??nh niêm phong
	 * @return Biên b?n niêm phong
	 * @throws Exception
	 */
	public static TtktThBbNiemPhong getBienBanNiempPhong(ApplicationContext app, String qdNiemPhongId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThBbNiemPhong.class);
		criteria.addSearchItem(TtktThBbNiemPhong.IdQuyetDinhNp, qdNiemPhongId);
		Collection temp = dao.retrieveObjects(app, criteria);
		if (Formater.isNull(temp))
			return null;
		TtktThBbNiemPhong bbNiemPhong = (TtktThBbNiemPhong) ((ArrayList) temp).get(0);

		// Load thanh phan tham du doan ttkt
		criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
		criteria.addSearchItem("idMaster", bbNiemPhong.getIdTpThamDuDoanTtkt());
		bbNiemPhong.setDsDoanTtkt(dao.retrieveObjects(app, criteria));

		// Load thanh phan tham du doan ttkt
		criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
		criteria.addSearchItem("idMaster", bbNiemPhong.getIdTpThamDuDviCnhanCoTs());
		bbNiemPhong.setDsDvCoTlNp(dao.retrieveObjects(app, criteria));

		return bbNiemPhong;

	}

	/**
	 * L?y biên b?n chi ti?t ho?c biên b?n t?ng h?p theo Id
	 * 
	 * @param appContext
	 * @param idBienBan
	 *            Id
	 * @return Biên b?n chi ti?t ho?c biên b?n t?ng h?p
	 */
	public static TtktThBbChitietvatonghop getBbChiTietVaTongHopById(ApplicationContext appContext, String idBienBan) throws Exception {
		return (TtktThBbChitietvatonghop) dao.retrieveObject(appContext, TtktThBbChitietvatonghop.class, idBienBan);
	}

	/**
	 * T?o câu l?nh update tr?ng thái cu?c Thanh tra Ki?m tra
	 * 
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @param trangThai
	 *            Tr?ng thái c?n c?p nh?t
	 * @return
	 */
	protected static String buidSqlUpdateTrangThaiCuocTtkt(String cuocTtktId, String trangThai) {
		String sqlUpdateTrangThaiCuocTttk = "update ttkt_kh_cuoc_ttkt set trang_thai = '" + trangThai;
		sqlUpdateTrangThaiCuocTttk += "', ma_trang_thai = '" + TtktKhCuocTtkt.selectMaTrangThai(trangThai) + "' where id = " + cuocTtktId;
		return sqlUpdateTrangThaiCuocTttk;

	}

	/**
	 * L?u báo cáo kh?o sát
	 * 
	 * @param request
	 * @param appConText
	 * @param cbForm
	 *            Form ch?a thông tin báo cáo kh?o sát
	 */
	public static void saveBaoCaoKs(HttpServletRequest request, ApplicationContext appConText, ChuanBiTienHanhForm cbForm) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String id = cbForm.getMaFileBCKS();
			boolean isInsert = false;
			if (Formater.isNull(id)) {
				isInsert = true;
				id = KeyManagement.getGUID();
				cbForm.setMaFileBCKS(id);
			}
			if (!isInsert) {
				UploadAction.deleteFile(id);
			}

			// Luu file moi
			FormFile formFile = cbForm.getFileBCKS();
//			if(Formater.isNull(formFile.getFileName()))
//				formFile.setFileName("...");
			UploadAction.saveFile(formFile, id);

			// Cap nhat database
			conn = DataSourceConfiguration.getConnection();
			Statement statement = conn.createStatement();
			String fileName = formFile.getFileName();
//			if(!Formater.isNull(fileName)){
//				fileName="...";
//			}
			String contentType = formFile.getContentType();
			if (isInsert) {
				// Cap nhat trang thai cuoc Ttkt
				if (isNewStatus(cbForm.getIdCuocTtkt(), appConText, Constants.TT_TTKT_BCKS))
					statement.addBatch(buidSqlUpdateTrangThaiCuocTtkt(cbForm.getIdCuocTtkt(), Constants.TT_TTKT_BCKS));
				
					
					String tenNsd = appConText.getTenNsd();
					String sqlInsertFile = "insert into ktnb_file (MA_FILE,MA_DON,TEN_FILE,LOAI_FILE,NGUOI_CAP_NHAT,NOI_DUNG, SO_TRANG, NGHIEP_VU_PATH) values ('" + id + "','" + cbForm.getIdCuocTtkt()
					+ "','" + fileName + "','" + contentType + "','" + tenNsd + "',BFILENAME('KTNB_FILE_DIR','" + id + "'),'1','" + Constants.TTKT_NV_BCKS + "')";
					statement.addBatch(sqlInsertFile);
				statement.executeBatch();
				conn.commit();
			} else {
				String sqlUpdateFile = "update KTNB_FILE set NOI_DUNG = BFILENAME('KTNB_FILE_DIR','" + id + "'), TEN_FILE = '" + fileName + "',LOAI_FILE = '" + contentType + "' where ma_file = '"
						+ id + "'";
				statement.execute(sqlUpdateFile);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}

	}

	/**
	 * L?u công b? quy?t ??nh
	 * 
	 * @param appContext
	 * @param congBoQd
	 *            Công b? quy?t ??nh
	 */
	public static void saveCongBoQd(ApplicationContext appContext, TtktThCongBoQd congBoQd) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
				throw e1;
			}
			session = HibernateSessionFactory.currentSession();
			BaseHibernateDAO dao = new BaseHibernateDAO();

			if (Formater.isNull(congBoQd.getId())) {
				congBoQd.setId(KeyManagement.getGUID());
				if (isNewStatus(congBoQd.getId(), appContext, Constants.TT_TTKT_CBQD))
					session.createSQLQuery("UPDATE TTKT_KH_CUOC_TTKT set TRANG_THAI= '" + Constants.TT_TTKT_CBQD + "' WHERE id=" + congBoQd.getIdCuocTtkt()).executeUpdate();
				appContext.setTrangThaiCuocTtkt(congBoQd.getId(), Constants.TT_TTKT_CBQD);
			}

			session
					.createSQLQuery(
							"UPDATE TTKT_KH_CUOC_TTKT set ngay_bat_dau =  to_date('" + Formater.date2str(congBoQd.getThoiDiemCbTu()) + "', 'dd/mm/yyyy') where id = " + congBoQd.getIdCuocTtkt())
					.executeUpdate();

			// Save thanh phan tham du cqt ban hanh
			if (Formater.isNull(congBoQd.getIdDaiDienCqBanHanhQd()) && !Formater.isNull(congBoQd.getDsDaiDienCqtBanHanhQD())) {
				congBoQd.setIdDaiDienCqBanHanhQd(KeyManagement.getGUID());
			} else
				// Xoa thanh phan tham du cqt ban hanh cu
				session.createSQLQuery("delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER = '" + congBoQd.getIdDaiDienCqBanHanhQd() + "'").executeUpdate();
			// Luu thanh phan tham du cqt ban hanh moi
			Collection dsTpThamDuCqtBanHanh = congBoQd.getDsDaiDienCqtBanHanhQD();
			if (!Formater.isNull(dsTpThamDuCqtBanHanh)) {
				Iterator iter = dsTpThamDuCqtBanHanh.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setIdMaster(congBoQd.getIdDaiDienCqBanHanhQd());
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					dao.saveObject(appContext, thanhPhanThamDu, Boolean.TRUE);
				}
			}

			// Save thanh phan tham du cqt quan ly cap tren
			if (Formater.isNull(congBoQd.getIdDaiDienCqqlCapTren()) && !Formater.isNull(congBoQd.getDsDaiDienCqqlCapTren()))
				congBoQd.setIdDaiDienCqqlCapTren(KeyManagement.getGUID());
			else
				// Xoa thanh phan tham du co quan ql cap tren cu
				session.createSQLQuery("delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER = '" + congBoQd.getIdDaiDienCqqlCapTren() + "'").executeUpdate();
			// Luu thanh phan tham du co quan ql cap tren moi
			Collection dsTpThamDuCqqlCapTren = congBoQd.getDsDaiDienCqqlCapTren();
			if (!Formater.isNull(dsTpThamDuCqqlCapTren)) {
				Iterator iter = dsTpThamDuCqqlCapTren.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setIdMaster(congBoQd.getIdDaiDienCqqlCapTren());
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					dao.saveObject(appContext, thanhPhanThamDu, Boolean.TRUE);
				}
			}

			// Dai dien doan Ttkt
			if (Formater.isNull(congBoQd.getIdDaiDienDoanTtkt()) && !Formater.isNull(congBoQd.getDsDaiDienDoanTtkt()))
				congBoQd.setIdDaiDienDoanTtkt(KeyManagement.getGUID());
			else
				// Xoa thanh phan tham du doan Ttkt cu
				session.createSQLQuery("delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER = '" + congBoQd.getIdDaiDienDoanTtkt() + "'").executeUpdate();
			// Luu thanh phan tham du doan Ttkt moi
			Collection dsDaiDienDoanTtkt = congBoQd.getDsDaiDienDoanTtkt();
			if (!Formater.isNull(dsDaiDienDoanTtkt)) {
				Iterator iter = dsDaiDienDoanTtkt.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setIdMaster(congBoQd.getIdDaiDienDoanTtkt());
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					dao.saveObject(appContext, thanhPhanThamDu, Boolean.TRUE);
				}
			}

			// Dai dien don vi duoc Ttkt
			if (Formater.isNull(congBoQd.getIdDaiDienDonViDuocTtkt()) && !Formater.isNull(congBoQd.getDsDaiDienDonViDuocTtkt()))
				congBoQd.setIdDaiDienDonViDuocTtkt(KeyManagement.getGUID());
			else
				// Xoa thanh phan tham du don vi duoc Ttkt cu
				session.createSQLQuery("delete TTKT_CM_THANH_PHAN_THAM_DU where ID_MASTER = '" + congBoQd.getIdDaiDienDonViDuocTtkt() + "'").executeUpdate();
			// Luu thanh phan tham du don vi duoc Ttkt moi
			Collection dsDaiDienDonViDuocTtkt = congBoQd.getDsDaiDienDonViDuocTtkt();
			if (!Formater.isNull(dsDaiDienDonViDuocTtkt)) {
				Iterator iter = dsDaiDienDonViDuocTtkt.iterator();
				while (iter.hasNext()) {
					TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iter.next();
					thanhPhanThamDu.setIdMaster(congBoQd.getIdDaiDienDonViDuocTtkt());
					thanhPhanThamDu.setId(KeyManagement.getGUID());
					dao.saveObject(appContext, thanhPhanThamDu, Boolean.TRUE);
				}
			}

			// Save cong bo quyet dinh
			dao.saveOrUpdateObject(appContext, congBoQd, Boolean.TRUE);

			session.flush();
			tx.commit();
		} catch (Exception e) {
			appContext.setTrangThaiCuocTtkt(congBoQd.getIdCuocTtkt(), Constants.TT_TTKT_HOP);
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}

	/**
	 * L?u nh?t ký Thanh tra Ki?m tra
	 * 
	 * @param appContext
	 * @param arrNhatKy
	 *            Nh?t ký Thanh tra Ki?m tra
	 */
	public static void saveNhatKy(ApplicationContext appContext, TtktThNhatKy[] arrNhatKy, String idCuocTtkt) throws Exception {

		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
				throw e1;
			}
			session = HibernateSessionFactory.currentSession();
			BaseHibernateDAO dao = new BaseHibernateDAO();
			session.createSQLQuery("delete TTKT_TH_NHAT_KY where ID_CUOC_TTKT = '" + idCuocTtkt + "'").executeUpdate();
			if (isNewStatus(idCuocTtkt, appContext, Constants.TT_TTKT_NK))
				session.createSQLQuery("update TTKT_KH_CUOC_TTKT set TRANG_THAI = '" + Constants.TT_TTKT_NK + "' where ID = " + idCuocTtkt).executeUpdate();

			for (int i = 0; i < arrNhatKy.length; i++) {
				arrNhatKy[i].setId(KeyManagement.getGUID());
				dao.saveObject(appContext, arrNhatKy[i], Boolean.TRUE);
			}

			session.flush();
			tx.commit();
		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}

	/**
	 * L?u bàn giao h? s? tài li?u cho tr??ng ?oàn
	 * 
	 * @param banGiaoHstlChoTd
	 *            Bàn giao h? s? tài li?u cho tr??ng ?oàn
	 */
	public static String saveBanGiaoHstlChoTd(ApplicationContext appContext, TtktThBanGiaoHstlChoTd banGiaoHstlChoTd) throws Exception {
		if (!Formater.isNull(banGiaoHstlChoTd.getId())) {
			dao.updateObject(appContext, banGiaoHstlChoTd);
			return banGiaoHstlChoTd.getId();
		}
		banGiaoHstlChoTd.setId(KeyManagement.getGUID());
		if (!isNewStatus(banGiaoHstlChoTd.getIdCuocTtkt(), appContext, Constants.TT_TTKT_BGHSLT)) {
			dao.saveObject(appContext, banGiaoHstlChoTd);
		} else {
			UserTransaction tx = null;
			Session session = null;
			try {
				try {
					tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
					tx.begin();
				} catch (Exception e1) {
					e1.printStackTrace();
					throw e1;
				}
				session = HibernateSessionFactory.currentSession();
				dao.saveObject(appContext, banGiaoHstlChoTd, Boolean.TRUE);
				session.createSQLQuery(buidSqlUpdateTrangThaiCuocTtkt(banGiaoHstlChoTd.getIdCuocTtkt(), Constants.TT_TTKT_BGHSTLCTD)).executeUpdate();
				session.flush();
				tx.commit();
			} catch (Exception e) {
				HibernateSessionFactory.rollbackQuiet();
				e.printStackTrace();
				throw new Exception(e);
			} finally {
				HibernateSessionFactory.closeSession(session);
			}
		}
		return banGiaoHstlChoTd.getId();

	}

	/**
	 * L?u biên b?n t?ng h?p
	 * 
	 * @param appContext
	 * @param bbTongHop
	 *            Biên b?n t?ng h?p
	 */
	public static void saveBbTongHop(ApplicationContext appContext, TtktThBbChitietvatonghop bbTongHop) throws Exception {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			String id = bbTongHop.getId();
			boolean isInsert = false;
			if (Formater.isNull(id)) {
				isInsert = true;
				id = KeyManagement.getGUID();
				bbTongHop.setId(id);
			}
			if (isInsert) {
				// Luu file moi
				FormFile formFile = bbTongHop.getFileDinhKem();
				UploadAction.saveFile(formFile, id);
				// insert database
				conn = DataSourceConfiguration.getConnection();
				statement = conn.createStatement();
				String sqlInsertFileBbChiTiet = "insert into TTKT_TH_BB_CHITIETVATONGHOP (ID, ID_CUOC_TTKT, ID_NGUOI_LAP, TEN_NGUOI_LAP, TGIAN_TH_TU_NGAY, TGIAN_TH_DEN_NGAY, TTKT_TAI, THOI_DIEM_LAP_BB, DIA_DIEM_LAP_BB, THOI_DIEM_THONG_QUA, FILE_DINH_KEM,TEN_FILE,LOAI_FILE, NGAY_PHAN_CONG_CUA_TD)";
				sqlInsertFileBbChiTiet += "values(";
				sqlInsertFileBbChiTiet += "'" + bbTongHop.getId() + "',";
				sqlInsertFileBbChiTiet += "'" + bbTongHop.getIdCuocTtkt() + "',";
				sqlInsertFileBbChiTiet += "'" + bbTongHop.getIdNguoiLap() + "',";
				sqlInsertFileBbChiTiet += "'" + bbTongHop.getTenNguoiLap() + "',";
				sqlInsertFileBbChiTiet += "to_date('" + bbTongHop.getTgianThTuNgay() + "','yyyy-mm-dd'),";
				sqlInsertFileBbChiTiet += "to_date('" + bbTongHop.getTgianThDenNgay() + "','yyyy-mm-dd'),";
				sqlInsertFileBbChiTiet += "'" + bbTongHop.getTtktTai() + "',";
				sqlInsertFileBbChiTiet += "to_date('" + bbTongHop.getThoiDiemLapBb() + "', 'yyyy-mm-dd'),";
				sqlInsertFileBbChiTiet += "'" + bbTongHop.getDiaDiemLapBb() + "',";
				sqlInsertFileBbChiTiet += "to_date('" + bbTongHop.getThoiDiemThongQua() + "', 'yyyy-mm-dd'),";
				sqlInsertFileBbChiTiet += "BFILENAME('KTNB_FILE_DIR','" + id + "'),";
				sqlInsertFileBbChiTiet += "'" + formFile.getFileName() + "'";
				sqlInsertFileBbChiTiet += "'" + formFile.getContentType() + "'";
				sqlInsertFileBbChiTiet += "to_date('" + bbTongHop.getNgayPhanCongCuaTd() + "', 'yyyy-mm-dd'))";
				statement.addBatch(sqlInsertFileBbChiTiet);

				// Cap nhat trang thai cuoc Ttkt
				statement.addBatch(buidSqlUpdateTrangThaiCuocTtkt(bbTongHop.getIdCuocTtkt(), Constants.TT_TTKT_BBCT));
				statement.executeBatch();
				conn.commit();

			} else {
				// Xoa file cu				
				UploadAction.deleteFile(id);
				UploadAction.saveFile(bbTongHop.getFileDinhKem(), id);
				// Cap nhat database
				conn = DataSourceConfiguration.getConnection();
				statement = conn.createStatement();
				String sqlUpdate = "update TTKT_TH_BB_CHITIETVATONGHOP set ID_NGUOI_LAP = '" + bbTongHop.getIdNguoiLap() + "',";
				sqlUpdate += "TEN_NGUOI_LAP = '" + bbTongHop.getTenNguoiLap() + "',";
				sqlUpdate += "TGIAN_TH_TU_NGAY = '" + bbTongHop.getTenNguoiLap() + "',";
				sqlUpdate += "TGIAN_TH_DEN_NGAY = '" + bbTongHop.getTenNguoiLap() + "',";
				sqlUpdate += "TTKT_TAI = '" + bbTongHop.getTenNguoiLap() + "',";
				sqlUpdate += "THOI_DIEM_LAP_BB = '" + bbTongHop.getTenNguoiLap() + "',";
				sqlUpdate += "DIA_DIEM_LAP_BB = '" + bbTongHop.getTenNguoiLap() + "',";
				sqlUpdate += "THOI_DIEM_THONG_QUA = '" + bbTongHop.getTenNguoiLap() + "',";
				sqlUpdate += "FILE_DINH_KEM = '" + bbTongHop.getTenNguoiLap() + "',";
				sqlUpdate += "NGAY_PHAN_CONG_CUA_TD = '" + bbTongHop.getTenNguoiLap() + "',";
				sqlUpdate += "TEN_FILE = '" + bbTongHop.getFileDinhKem().getFileName() + "',";
				sqlUpdate += "LOAI_FILE = '" + bbTongHop.getFileDinhKem().getContentType() + "',";
				statement.execute(sqlUpdate);
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, statement, conn);
		}

	}

	/**
	 * L?u biên b?n chi ti?t
	 * 
	 * @param appContext
	 * @param bbChiTiet
	 *            Biên b?n chi ti?t
	 */
	public static String saveBienBanChiTiet(ApplicationContext appContext, TtktThBbChitietvatonghop bbChiTiet, String thoiDiemLapBB, String thoiDiemThongQua) throws Exception {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		String retVal = "";
		try {
			String id = bbChiTiet.getId();
			boolean isInsert = false;
			if (Formater.isNull(id)) {
				isInsert = true;
				id = KeyManagement.getGUID();
				bbChiTiet.setId(id);
			}
			retVal = id;
			if (isInsert) {
				// Luu file moi
				FormFile formFile = bbChiTiet.getFileDinhKem();
				UploadAction.saveFile(formFile, id);
				// insert database
				conn = DataSourceConfiguration.getConnection();
				statement = conn.createStatement();
				String sqlInsertFileBbChiTiet = "insert into TTKT_TH_BB_CHITIETVATONGHOP (ID, ID_CUOC_TTKT, ID_NGUOI_LAP, TEN_NGUOI_LAP, TGIAN_TH_TU_NGAY, TGIAN_TH_DEN_NGAY, TTKT_TAI, THOI_DIEM_LAP_BB, DIA_DIEM_LAP_BB, THOI_DIEM_THONG_QUA, TEN_FILE, LOAI_FILE, FILE_DINH_KEM, NGAY_PHAN_CONG_CUA_TD, LOAI_BB)";
				sqlInsertFileBbChiTiet += "values(";
				sqlInsertFileBbChiTiet += "'" + bbChiTiet.getId() + "',";
				sqlInsertFileBbChiTiet += "'" + bbChiTiet.getIdCuocTtkt() + "',";
				sqlInsertFileBbChiTiet += "'" + bbChiTiet.getIdNguoiLap() + "',";
				sqlInsertFileBbChiTiet += "'" + bbChiTiet.getTenNguoiLap() + "',";
				sqlInsertFileBbChiTiet += "to_date('" + bbChiTiet.getTgianThTuNgay() + "','yyyy-mm-dd'),";
				sqlInsertFileBbChiTiet += "to_date('" + bbChiTiet.getTgianThDenNgay() + "','yyyy-mm-dd'),";
				sqlInsertFileBbChiTiet += "'" + bbChiTiet.getTtktTai() + "',";
				sqlInsertFileBbChiTiet += "to_date('" + thoiDiemLapBB + "', 'hh24:mi dd/mm/yyyy'),";
				sqlInsertFileBbChiTiet += "'" + bbChiTiet.getDiaDiemLapBb() + "',";
				sqlInsertFileBbChiTiet += "to_date('" + thoiDiemThongQua + "', 'hh24:mi dd/mm/yyyy'),";
				sqlInsertFileBbChiTiet += "'" + formFile.getFileName() + "', ";
				sqlInsertFileBbChiTiet += "'" + formFile.getContentType() + "', ";
				sqlInsertFileBbChiTiet += "BFILENAME('KTNB_FILE_DIR','" + id + "'),";
				sqlInsertFileBbChiTiet += "to_date('" + bbChiTiet.getNgayPhanCongCuaTd() + "', 'yyyy-mm-dd'),'";
				sqlInsertFileBbChiTiet += Constants.TTKT_BB_CT + "')";
				statement.addBatch(sqlInsertFileBbChiTiet);

				// Cap nhat trang thai cuoc Ttkt
				if (isNewStatus(bbChiTiet.getIdCuocTtkt(), appContext, Constants.TT_TTKT_BBCT))
					statement.addBatch(buidSqlUpdateTrangThaiCuocTtkt(bbChiTiet.getIdCuocTtkt(), Constants.TT_TTKT_BBCT));
				statement.executeBatch();
				conn.commit();
				if (isNewStatus(bbChiTiet.getIdCuocTtkt(), appContext, Constants.TT_TTKT_BBCT))
					appContext.setTrangThaiCuocTtkt(bbChiTiet.getIdCuocTtkt(), Constants.TT_TTKT_BBCT);

			} else {
				// Xoa file cu
				UploadAction.deleteFile(id);
				// Luu file moi
				FormFile formFile = bbChiTiet.getFileDinhKem();
				UploadAction.saveFile(formFile, id);
				// Cap nhat database
				conn = DataSourceConfiguration.getConnection();
				statement = conn.createStatement();
				String sqlUpdate = "update TTKT_TH_BB_CHITIETVATONGHOP set ID_NGUOI_LAP = '" + bbChiTiet.getIdNguoiLap() + "', ";
				sqlUpdate += "TEN_NGUOI_LAP = '" + bbChiTiet.getTenNguoiLap() + "', ";
				sqlUpdate += "TGIAN_TH_TU_NGAY = " + "to_date('" + bbChiTiet.getTgianThTuNgay() + "', 'yyyy-mm-dd'), ";
				sqlUpdate += "TGIAN_TH_DEN_NGAY = " + "to_date('" + bbChiTiet.getTgianThDenNgay() + "', 'yyyy-mm-dd'), ";
				sqlUpdate += "TTKT_TAI = '" + bbChiTiet.getTtktTai() + "', ";
				sqlUpdate += "THOI_DIEM_LAP_BB = " + "to_date('" + thoiDiemLapBB + "', 'hh24:mi dd/mm/yyyy'), ";
				sqlUpdate += "DIA_DIEM_LAP_BB = '" + bbChiTiet.getDiaDiemLapBb() + "', ";
				sqlUpdate += "THOI_DIEM_THONG_QUA = " + "to_date('" + thoiDiemThongQua + "', 'hh24:mi dd/mm/yyyy'), ";
				sqlUpdate += "FILE_DINH_KEM = " + "BFILENAME('KTNB_FILE_DIR','" + id + "'), ";
				sqlUpdate += "NGAY_PHAN_CONG_CUA_TD = " + "to_date('" + bbChiTiet.getNgayPhanCongCuaTd() + "', 'yyyy-mm-dd'), ";
				sqlUpdate += "TEN_FILE = '" + formFile.getFileName() + "', ";
				sqlUpdate += "LOAI_FILE = '" + formFile.getContentType() + "' ";
				sqlUpdate += "where id = " + bbChiTiet.getId();
				statement.execute(sqlUpdate);
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, statement, conn);
		}
		return retVal;

	}

	/**
	 * L?u danh sách các biên b?n chi ti?t
	 * 
	 * @param appContext
	 * @param idCuocTtkt
	 *            Id cu?c Thanh tra Ki?m tra
	 * @param chitietvatonghops
	 *            Danh sách biên b?n chi ti?t
	 */
	public static void saveBienBanChiTiet(ApplicationContext appContext, String idCuocTtkt, TtktThBbChitietvatonghop[] chitietvatonghops) throws Exception {
		String listOfExistId = "";
		for (int i = 0; i < chitietvatonghops.length; i++)
			listOfExistId += chitietvatonghops[i].getId() + ",";
		listOfExistId = listOfExistId.substring(0, listOfExistId.length() - 1);
		String updateString = "delete ttkt_th_bb_chitietvatonghop where ID_CUOC_TTKT = " + idCuocTtkt + " and id not in (";
		updateString += listOfExistId + ")";
		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			statement.execute(updateString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}
	}
	/**
	 * L?u biên b?n
	 * 
	 * @param bienBan
	 *            Biên b?n c?n l?u
	 * @param trangThai
	 *            N?u cu?c Thanh tra Ki?m tra ch?a ? tr?ng thái này thì c?p nh?t tr?ng thái cu?c Thanh tra Ki?m tra
	 */
	public static void saveBienBan(ApplicationContext appContext, TtktThBbChitietvatonghop bienBan, String trangThai) throws Exception {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			boolean isInsert = false;
			String sql;

			if (Formater.isNull(bienBan.getId())) {
				isInsert = true;
				bienBan.setId(KeyManagement.getGUID());
				// Upload file
				FormFile formFile = bienBan.getFileDinhKem();
				UploadAction.saveFile(formFile, bienBan.getId());
				SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
				String ngayCapNhat = parser.format(bienBan.getNgayCapNhat());
				
				sql = "insert into TTKT_TH_BB_CHITIETVATONGHOP (id, id_cuoc_ttkt,so_ket_luan, loai_bb, FILE_DINH_KEM,TEN_FILE,LOAI_FILE,ID_NGUOI_CAP_NHAT,TEN_NGUOI_CAP_NHAP,NGAY_CAP_NHAT";
				if (!Formater.isNull(bienBan.getTgianThTuNgayStr()))
					sql += ", TGIAN_TH_TU_NGAY";

				sql += ") VALUES ('" + bienBan.getId() + "','" + bienBan.getIdCuocTtkt() + "','" + bienBan.getSoKetLuan() + "','" + bienBan.getLoaiBb() +"', BFILENAME('KTNB_FILE_DIR','" + bienBan.getId() + "'),'"
						+ bienBan.getFileDinhKem().getFileName() + "','" + bienBan.getFileDinhKem().getContentType() + "','" +bienBan.getIdNguoiCapNat() + "','"+ bienBan.getTenNguoiCapNhat() +"',to_date('" + ngayCapNhat + "', 'dd-mm-yyyy')";
				if (!Formater.isNull(bienBan.getTgianThTuNgayStr()))
					sql += ", to_date('" + bienBan.getTgianThTuNgayStr() + "', 'dd-mm-yyyy')";
				sql += ")";
				statement.addBatch(sql);
				// Cap nhat trang thai cuoc ttkt
				if (isNewStatus(bienBan.getIdCuocTtkt(), appContext, trangThai))
					statement.addBatch(buidSqlUpdateTrangThaiCuocTtkt(bienBan.getIdCuocTtkt(), trangThai));

			} else {
				FormFile formFile = bienBan.getFileDinhKem();
				if (formFile != null && !Formater.isNull(formFile.getFileName())) {
					// Xoa file cu
					UploadAction.deleteFile(bienBan.getId());
					
					// Upload file moi
					UploadAction.saveFile(formFile, bienBan.getId());
				}
				sql = "update TTKT_TH_BB_CHITIETVATONGHOP set ";
				if (!Formater.isNull(bienBan.getTgianThTuNgayStr()))
					sql += "TGIAN_TH_TU_NGAY = to_date('" + bienBan.getTgianThTuNgayStr() + "', 'dd-mm-yyyy'),";
				if (!Formater.isNull(bienBan.getSoKetLuan()))
					sql += "SO_KET_LUAN = '" + bienBan.getSoKetLuan() + "',";
				if (formFile != null && !Formater.isNull(formFile.getFileName()))
				{
					sql += "FILE_DINH_KEM = BFILENAME('KTNB_FILE_DIR','" + bienBan.getId() + "'),";
					sql += "LOAI_FILE = '" + bienBan.getFileDinhKem().getContentType() + "',";
					sql += "TEN_FILE = '" + bienBan.getFileDinhKem().getFileName() + "',";
				}
				sql = sql.substring(0, sql.length() - 1);
				sql += " where id = " + bienBan.getId();
			}

			if (isInsert) {
				statement.executeBatch();
				conn.commit();
				if (isNewStatus(bienBan.getIdCuocTtkt(), appContext, trangThai))
					appContext.setTrangThaiCuocTtkt(bienBan.getIdCuocTtkt(), trangThai);
			} else {
				statement.execute(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e1) {}
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, statement, conn);
		}

	}

	public static void saveBienBan(ApplicationContext appContext, TtktThBbChitietvatonghop bienBan) {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			boolean isInsert = false;
			String sql;
			if (Formater.isNull(bienBan.getId())) {

				isInsert = true;
				bienBan.setId(KeyManagement.getGUID());
				// Upload file
				FormFile formFile = bienBan.getFileDinhKem();
				UploadAction.saveFile(formFile, bienBan.getId());
				sql = "insert into TTKT_TH_BB_CHITIETVATONGHOP (id, id_cuoc_ttkt, loai_bb, FILE_DINH_KEM,TEN_FILE,LOAI_FILE";
				if (!Formater.isNull(bienBan.getTgianThTuNgayStr()))
					sql += ", TGIAN_TH_TU_NGAY";

				sql += ") VALUES (" + bienBan.getId() + "," + bienBan.getIdCuocTtkt() + ",'" + bienBan.getLoaiBb() + "', BFILENAME('KTNB_FILE_DIR','" + bienBan.getId() + "'),'"
						+ bienBan.getFileDinhKem().getFileName() + "',' " + bienBan.getFileDinhKem().getContentType() + "'";
				if (!Formater.isNull(bienBan.getTgianThTuNgayStr()))
					sql += ", to_date('" + bienBan.getTgianThTuNgayStr() + "', 'dd-mm-yyyy')";
				sql += ")";
				statement.addBatch(sql);

			} else {

				FormFile formFile = bienBan.getFileDinhKem();
				if (formFile != null && !Formater.isNull(formFile.getFileName())) {
					// Xoa file cu
					UploadAction.deleteFile(bienBan.getId());
					//(new File(UploadAction.UPLOAD_FOLDER + bienBan.getId())).delete();
					// Upload file moi
					UploadAction.saveFile(formFile, bienBan.getId());

				}

				sql = "update TTKT_TH_BB_CHITIETVATONGHOP set ";
				if (!Formater.isNull(bienBan.getTgianThTuNgayStr()))
					sql += "TGIAN_TH_TU_NGAY = to_date('" + bienBan.getTgianThTuNgayStr() + "', 'dd-mm-yyyy'),";
				if (formFile != null && !Formater.isNull(formFile.getFileName()))
					sql += "FILE_DINH_KEM = BFILENAME('KTNB_FILE_DIR','" + bienBan.getId() + "'),";
				if (formFile != null && !Formater.isNull(formFile.getFileName()))
					sql += "LOAI_FILE = '" + bienBan.getFileDinhKem().getContentType() + "',";
				if (formFile != null && !Formater.isNull(formFile.getFileName()))
					sql += "TEN_FILE = '" + bienBan.getFileDinhKem().getFileName() + "',";
				sql = sql.substring(0, sql.length() - 1);

				sql += " where id = " + bienBan.getId();
			}

			if (isInsert) {
				statement.executeBatch();
				conn.commit();

			} else {
				statement.execute(sql);
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();

			} catch (Exception e1) {

			}

		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, statement, conn);
		}
	}

	/**
	 * L?y biên b?n t?ng h?p
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @param loaiBB
	 *            Lo?i biên b?n
	 * @return
	 */
	public static TtktThBbChitietvatonghop getBbTongHop(ApplicationContext appContext, String cuocTtktId, String loaiBB) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThBbChitietvatonghop.class);
		criteria.addSearchItem(TtktThBbChitietvatonghop.IdCuocTtkt, cuocTtktId);
		criteria.addSearchItem(TtktThBbChitietvatonghop.LoaiBb, loaiBB);
		Collection temp = dao.retrieveObjects(appContext, criteria);
		if (Formater.isNull(temp))
			return null;
		else
			return (TtktThBbChitietvatonghop) ((ArrayList) temp).get(0);
	}
	
	public static TtktKtKetLuanChuyenBC getKetLuanSangBC(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktKtKetLuanChuyenBC.class);
		criteria.addSearchItem("idCuocTtkt", cuocTtktId);

		Collection temp = dao.retrieveObjects(appContext, criteria);
		if (Formater.isNull(temp))
			return null;
		else
			return (TtktKtKetLuanChuyenBC) ((ArrayList) temp).get(0);
	}

	/**
	 * L?u thông báo k?t thúc
	 * 
	 * @param appContext
	 * @param ketThucTtktForm
	 *            Ch?a các thông tin thông báo k?t thuc
	 */
	public static void thongBaoKetThuc(ApplicationContext appContext, KetThucTtktForm ketThucTtktForm) throws Exception {
		Connection conn = null;
		Statement ps = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			ps = conn.createStatement();
			String strKetThucCuocTtkt = "update ttkt_kh_cuoc_ttkt set NGAY_KET_THUC = ";
			strKetThucCuocTtkt += "to_date('" + ketThucTtktForm.getNgayKetThuc() + "','dd-mm-yyyy'),";
			if (isNewStatus(ketThucTtktForm.getIdCuocTtkt(), appContext, Constants.TT_TTKT_TBKT))
				strKetThucCuocTtkt += "trang_thai = '" + Constants.TT_TTKT_TBKT + "', ";
			strKetThucCuocTtkt += "NOI_RA_THONG_BAO_KET_THUC = '" + ketThucTtktForm.getNoiRaThongBaoKetThuc() + "',";
			strKetThucCuocTtkt += " NGAY_RA_THONG_BAO_KET_THUC = ";
			strKetThucCuocTtkt += "to_date('" + ketThucTtktForm.getNgayRaThongBaoKetThuc() + "','dd-mm-yyyy') where id = " + ketThucTtktForm.getIdCuocTtkt();
			ps.execute(strKetThucCuocTtkt);
			if (TtktService.isNewStatus(ketThucTtktForm.getIdCuocTtkt(), appContext, Constants.TT_TTKT_TBKT))
				appContext.setTrangThaiCuocTtkt(ketThucTtktForm.getIdCuocTtkt(), Constants.TT_TTKT_TBKT);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		} finally {
			DataSourceConfiguration.releaseSqlResources(null, ps, conn);
		}

	}
	/**
	 * L?u nh?n tr? h? s? tài li?u
	 * 
	 * @param appContext
	 * @param nhanTraHstl
	 *            Nh?n tr? h? s? tài li?u
	 */
	public static void saveNhanTraHstl(ApplicationContext appContext, TtktCmNhanTraHstl nhanTraHstl) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			BaseHibernateDAO dao = new BaseHibernateDAO();
			session = HibernateSessionFactory.currentSession();
			boolean isInsert = false;
			if (TtktService.isNewStatus(nhanTraHstl.getIdCuocTtkt(), appContext, Constants.TT_TTKT_BGHSLT)) {
				nhanTraHstl.setId(KeyManagement.getGUID());
				session.createSQLQuery(buidSqlUpdateTrangThaiCuocTtkt(nhanTraHstl.getIdCuocTtkt(), Constants.TT_TTKT_BGHSLT)).executeUpdate();
				isInsert = true;

			}

			if (Formater.isNull(nhanTraHstl.getIdDaiDienBenGiao())) {
				nhanTraHstl.setIdDaiDienBenGiao(KeyManagement.getGUID());
			} else {
				// Xoa dai dien ben giao cu
				session.createSQLQuery("delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + nhanTraHstl.getIdDaiDienBenGiao()).executeUpdate();
			}
			Collection daiDienBenGiao = nhanTraHstl.getDaiDienBenGiao();
			Iterator iterDaiDienBenGiao = daiDienBenGiao.iterator();
			while (iterDaiDienBenGiao.hasNext()) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iterDaiDienBenGiao.next();
				thanhPhanThamDu.setId(KeyManagement.getGUID());
				thanhPhanThamDu.setIdMaster(nhanTraHstl.getIdDaiDienBenGiao());
				dao.saveObject(appContext, thanhPhanThamDu, Boolean.TRUE);
			}

			if (Formater.isNull(nhanTraHstl.getIdDaiDienBenNhan())) {
				nhanTraHstl.setIdDaiDienBenNhan(KeyManagement.getGUID());
			} else {
				// Xoa dai dien ben nhan cu
				session.createSQLQuery("delete ttkt_cm_thanh_phan_tham_du where ID_MASTER = " + nhanTraHstl.getIdDaiDienBenNhan()).executeUpdate();
			}
			Collection daiDienBenNhan = nhanTraHstl.getDaiDienBenNhan();
			Iterator iterDaiDienBenNhan = daiDienBenNhan.iterator();
			while (iterDaiDienBenNhan.hasNext()) {
				TtktCmThanhPhanThamDu thanhPhanThamDu = (TtktCmThanhPhanThamDu) iterDaiDienBenNhan.next();
				thanhPhanThamDu.setId(KeyManagement.getGUID());
				thanhPhanThamDu.setIdMaster(nhanTraHstl.getIdDaiDienBenNhan());
				dao.saveObject(appContext, thanhPhanThamDu, Boolean.TRUE);
			}
			if (isInsert) {
				dao.saveObject(appContext, nhanTraHstl, Boolean.TRUE);
			} else {
				if (Formater.isNull(nhanTraHstl.getId()))
					nhanTraHstl.setId(TtktService.getNhanTraHsTl(appContext, nhanTraHstl.getIdCuocTtkt()).getId());
				dao.updateObject(appContext, nhanTraHstl, Boolean.TRUE);
			}
			session.flush();
			tx.commit();
			if (isInsert)
				appContext.setTrangThaiCuocTtkt(nhanTraHstl.getIdCuocTtkt(), Constants.TT_TTKT_BGHSLT);
		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}

	/**
	 * L?u chuy?n d? li?u sang báo cáo
	 * 
	 * @param appContext
	 * @param chuyenDlieuSangBc
	 *            Chuy?n d? li?u sang báo cáo
	 */
	public static void chuyenDlieuSangBaoCao(ApplicationContext appContext, TtktKtChuyenDlieuSangBc chuyenDlieuSangBc) throws Exception {

		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			BaseHibernateDAO dao = new BaseHibernateDAO();
			session = HibernateSessionFactory.currentSession();
			if ("ketThuc".equals(chuyenDlieuSangBc.getKetThucNhapLieu())) {
				session.createSQLQuery(buidSqlUpdateTrangThaiCuocTtkt(chuyenDlieuSangBc.getIdCuocTtkt(), Constants.TT_TTKT_KT)).executeUpdate();
			} else {
				session.createSQLQuery(buidSqlUpdateTrangThaiCuocTtkt(chuyenDlieuSangBc.getIdCuocTtkt(), Constants.TT_TTKT_CDLBC)).executeUpdate();
			}

			if (TtktService.isNewStatus(chuyenDlieuSangBc.getIdCuocTtkt(), appContext, Constants.TT_TTKT_CDLBC)) {

				chuyenDlieuSangBc.setId(KeyManagement.getGUID());
				dao.saveObject(appContext, chuyenDlieuSangBc, Boolean.TRUE);
			} else {
				if (Formater.isNull(chuyenDlieuSangBc.getId()))
					chuyenDlieuSangBc.setId(TtktService.getChuyenDlieuSangBaoCao(appContext, chuyenDlieuSangBc.getIdCuocTtkt()).getId());
				dao.updateObject(appContext, chuyenDlieuSangBc, Boolean.TRUE);
			}
			session.flush();
			tx.commit();
			if ("ketThuc".equals(chuyenDlieuSangBc.getKetThucNhapLieu())) {
				appContext.setTrangThaiCuocTtkt(chuyenDlieuSangBc.getIdCuocTtkt(), Constants.TT_TTKT_KT);
			} else {
				appContext.setTrangThaiCuocTtkt(chuyenDlieuSangBc.getIdCuocTtkt(), Constants.TT_TTKT_CDLBC);
			}

		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}
	
	public static void baocaoKqThucHienKl(ApplicationContext appContext, TtktKtBcKqThucHienKL kqThucHienKl, KetThucTtktForm form) throws Exception {

		UserTransaction tx = null;
		Session session = null;
		try {
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			boolean isInsert = false;
			if (Formater.isNull(kqThucHienKl.getId()))
			{
				kqThucHienKl.setId(KeyManagement.getGUID());
				isInsert = true;
			}
			session = HibernateSessionFactory.currentSession();
			if (isInsert)
				session.save(kqThucHienKl);
			else
				session.update(kqThucHienKl);			
			// upload file
			if(form.getBaoCaoKqDinhKem().getFileSize() > 0){	
				SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
				String ngayCapNhat = parser.format(new Date());
					String sql;
					if (isInsert) {
						sql = "insert into TTKT_TH_BB_CHITIETVATONGHOP (id, id_cuoc_ttkt, loai_bb, FILE_DINH_KEM,TEN_FILE,LOAI_FILE,ID_NGUOI_CAP_NHAT,TEN_NGUOI_CAP_NHAP,NGAY_CAP_NHAT";
						sql += ") VALUES ('" + kqThucHienKl.getId() + "','" + form.getIdCuocTtkt() + "','Ket qua thuc hien ket luan', BFILENAME('KTNB_FILE_DIR','" + kqThucHienKl.getId() + "'),'"
								+ form.getBaoCaoKqDinhKem().getFileName() + "','" + form.getBaoCaoKqDinhKem().getContentType() + "'," +form.getIdNguoiCapNhat() + ",'"+ form.getTenNguoiCapNhap() +"',to_date('" + ngayCapNhat + "', 'dd-mm-yyyy')";
						sql += ")";
					} else { //Update
						// Xoa file cu
						UploadAction.deleteFile(form.getIdKqThucHienKl());
						UploadAction.deleteFile(kqThucHienKl.getId());	
						sql = "update TTKT_TH_BB_CHITIETVATONGHOP set ";
						sql += "FILE_DINH_KEM = BFILENAME('KTNB_FILE_DIR','" + form.getIdKqThucHienKl() + "'),";
						sql += "LOAI_FILE = '" + form.getBaoCaoKqDinhKem().getContentType() + "',";
						sql += "TEN_FILE = '" + form.getBaoCaoKqDinhKem().getFileName() + "'";
						sql += " where id = '" + form.getIdKqThucHienKl()+"'";
					}
					System.out.println("SQL Ket thuc: "+sql);
					session.createSQLQuery(sql).executeUpdate();
					//Upload file
					FormFile formFile = form.getBaoCaoKqDinhKem();
					UploadAction.saveFile(formFile, kqThucHienKl.getId());
			}
			
			// Cap nhat trang thai cuocTtkt
			if (kqThucHienKl.getKetThucTdoiThanh().intValue() == 1) {
				session.createSQLQuery(buidSqlUpdateTrangThaiCuocTtkt(kqThucHienKl.getIdCuocTtkt(), Constants.TT_TTKT_KT)).executeUpdate();
			} else {
				session.createSQLQuery(buidSqlUpdateTrangThaiCuocTtkt(kqThucHienKl.getIdCuocTtkt(), Constants.TT_TTKT_CDLBC)).executeUpdate();
			}
			
			session.flush();
			tx.commit();
			
			if (kqThucHienKl.getKetThucTdoiThanh().intValue() == 1) {
				appContext.setTrangThaiCuocTtkt(kqThucHienKl.getIdCuocTtkt(), Constants.TT_TTKT_KT);
			} else {
				appContext.setTrangThaiCuocTtkt(kqThucHienKl.getIdCuocTtkt(), Constants.TT_TTKT_CDLBC);
			}

		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}

	/**
	 * L?y d? th?o k?t qu? Thanh tra Ki?m tra
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return D? th?o k?t qu? Thanh tra Ki?m tra
	 */
	public static TtktThBbChitietvatonghop getDuThaoKetQua(ApplicationContext appContext, String cuocTtktId) throws Exception {
		return getBbTongHop(appContext, cuocTtktId, Constants.TTKT_BB_DTKQ);
	}

	/**
	 * L?y k?t qu? Thanh tra Ki?m tra
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return K?t qu? Thanh tra Ki?m tra
	 */
	public static TtktThBbChitietvatonghop getKetQua(ApplicationContext appContext, String cuocTtktId) throws Exception {
		return getBbTongHop(appContext, cuocTtktId, Constants.TTKT_BB_KQ);
	}

	/**
	 * L?y d? th?o k?t lu?n Thanh tra Ki?m tra
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return D? th?o k?t lu?n Thanh tra Ki?m tra
	 */
	public static TtktThBbChitietvatonghop getDuThaoKetLuan(ApplicationContext appContext, String cuocTtktId) throws Exception {
		return getBbTongHop(appContext, cuocTtktId, Constants.TTKT_BB_DTKL);
	}

	/**
	 * L?y k?t lu?n Thanh tra Ki?m tra
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return K?t lu?n Thanh tra Ki?m tra
	 */
	public static TtktThBbChitietvatonghop getKetLuan(ApplicationContext appContext, String cuocTtktId) throws Exception {
		return getBbTongHop(appContext, cuocTtktId, Constants.TTKT_BB_KL);
	}

	/**
	 * L?y biên b?n h?p rút kinh nghi?m ?oàn
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return Biên b?n h?p rút kinh nghi?m ?oàn
	 */
	public static TtktCmBienBan getBbHopRutKinhNghiemDoan(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktCmBienBan.class);
		criteria.addSearchItem(TtktCmBienBan.IdCuocTtkt, cuocTtktId);
		criteria.addSearchItem(TtktCmBienBan.Loai, Constants.TTKT_BB_HRKN);
		Collection temp = dao.retrieveObjects(appContext, criteria);
		if (Formater.isNull(temp))
			return null;
		else {
			TtktCmBienBan bbHopRutKinhNghiem = (TtktCmBienBan) ((ArrayList) temp).get(0);
			// Thanh phan tham du
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem("idMaster", bbHopRutKinhNghiem.getId());
			bbHopRutKinhNghiem.setThanhPhanThamDu(dao.retrieveObjects(appContext, criteria));
			return bbHopRutKinhNghiem;
		}

	}

	/**
	 * L?y nh?n tr? h? s? tài li?u
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return Nh?n tr? h? s? tài li?u
	 */
	public static TtktCmNhanTraHstl getNhanTraHsTl(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktCmNhanTraHstl.class);
		criteria.addSearchItem(TtktCmNhanTraHstl.IdCuocTtkt, cuocTtktId);
		criteria.addSearchItem(TtktCmNhanTraHstl.Loai, Constants.TTKT_GNH_BGHSLT);
		Collection temp = dao.retrieveObjects(appContext, criteria);
		if (Formater.isNull(temp))
			return null;
		else {
			TtktCmNhanTraHstl nhanTraHsTl = (TtktCmNhanTraHstl) ((ArrayList) temp).get(0);

			// Dai dien ben giao
			String idDaiDienBenGiao = nhanTraHsTl.getIdDaiDienBenGiao();
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem(TtktCmThanhPhanThamDu.IdMaster, idDaiDienBenGiao);
			nhanTraHsTl.setDaiDienBenGiao(dao.retrieveObjects(appContext, criteria));

			// Dai dien ben nhan
			String idDaiDienBenNhan = nhanTraHsTl.getIdDaiDienBenNhan();
			criteria = new SearchCriteria(TtktCmThanhPhanThamDu.class);
			criteria.addSearchItem(TtktCmThanhPhanThamDu.IdMaster, idDaiDienBenNhan);
			nhanTraHsTl.setDaiDienBenNhan(dao.retrieveObjects(appContext, criteria));
			return nhanTraHsTl;
		}

	}

	/**
	 * L?y thông tin báo cáo c?a cu?c Thanh tra Ki?m tra
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return Báo cáo c?a cu?c Thanh tra Ki?m tra
	 */
	public static TtktKtChuyenDlieuSangBc getChuyenDlieuSangBaoCao(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktKtChuyenDlieuSangBc.class);
		criteria.addSearchItem("idCuocTtkt", cuocTtktId);
		Collection temp = dao.retrieveObjects(appContext, criteria);
		if (Formater.isNull(temp))
			return null;
		else
			return (TtktKtChuyenDlieuSangBc) ((ArrayList) temp).get(0);
	}
	
	public static TtktKtBcKqThucHienKL getKqThucHienKl(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktKtBcKqThucHienKL.class);
		criteria.addSearchItem("idCuocTtkt", cuocTtktId);
		Collection temp = dao.retrieveObjects(appContext, criteria);
		if (Formater.isNull(temp))
			return null;
		else
			return (TtktKtBcKqThucHienKL) ((ArrayList) temp).get(0);
	}

	/**
	 * L?y tr?ng thái ti?n hành c?a cu?c Thanh tra Ki?m tra
	 * <p>
	 * Tr?ng thái tr? v? là: Ch?a ti?n hành, Chu?n b? ti?n hành, Ti?n hành, K?t thúc.
	 * 
	 * @param trangThaiCuocTtkt
	 *            Tr?ng thái cu?c Thanh tra Ki?m tra
	 * @return Tr?ng thái cu?c Thanh tra Ki?m tra (Ch?a ti?n hành, Chu?n b? ti?n hành, Ti?n hành, K?t thúc)
	 */
	public static String getTrangThaiTienHanh(String idCuocTtkt, ApplicationContext appContext, String trangThaiCuocTtkt) {
		int trangThaiHienTai = getIndexOfTrangThai(appContext.getTrangThaiCuocTtkt(idCuocTtkt));
		int trangThaiChiDinhTruongDoan = getIndexOfTrangThai(Constants.TT_TTKT_CDTD);
		int trangThaiHopDoanTrienKhai = getIndexOfTrangThai(Constants.TT_TTKT_HOP);
		int trangThaiLapBBTongHop = getIndexOfTrangThai(Constants.TT_TTKT_BBTH);

		if (trangThaiHienTai <= trangThaiChiDinhTruongDoan)
			return "chuaTienHanh";
		if (trangThaiHienTai > trangThaiLapBBTongHop)
			return "ketThuc";
		if (trangThaiHienTai <= trangThaiHopDoanTrienKhai)
			return "cbTienHanh";
		return "tienHanh";
	}

	/**
	 * L?y Role c?a ng??i dùng ??i v?i cu?c Thanh tra Ki?m tra
	 * 
	 * @param appConText
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return Role c?a ng??i dùng ??i v?i cu?c Thanh tra Ki?m tra
	 */
	public static String getUserRole(ApplicationContext appConText, String cuocTtktId) throws Exception {
		TtktKhCuocTtkt cuocTtkt = (TtktKhCuocTtkt) dao.retrieveObject(appConText, TtktKhCuocTtkt.class, cuocTtktId);
		if (cuocTtkt.getIdTruongDoan().equals(appConText.getMaCanbo()))
			return Constants.TTKT_ROLE_TD;
		else
			return Constants.TTKT_ROLE_TT;
	}

	/**
	 * L?u bàn giao h? s? tài li?u cho tr??ng ?oàn
	 * 
	 * @param appContext
	 * @param arrBanGiaoHstlChoTruongDoan
	 *            Danh sách bàn giao h? s? tài li?u cho tr??ng ?oàn
	 */
	public static void saveDsBanGiaoHstlChoTd(ApplicationContext appContext, TtktThBanGiaoHstlChoTd[] arrBanGiaoHstlChoTruongDoan, String idCuocTtkt) throws Exception {
		// Connection conn = null;
		// Statement statement = null;
		// try {
		// String sql;
		// if (arrBanGiaoHstlChoTruongDoan != null &&
		// arrBanGiaoHstlChoTruongDoan.length > 0) {
		// sql = "delete TTKT_TH_BAN_GIAO_HSTL_CHO_TD where id not in (";
		// for (int i = 0; i < arrBanGiaoHstlChoTruongDoan.length; i++)
		// sql += arrBanGiaoHstlChoTruongDoan[i].getId() + ",";
		// sql = sql.substring(0, sql.length() - 1);
		// sql += ") and ID_CUOC_TTKT = " + idCuocTtkt;
		// } else {
		// sql = "delete TTKT_TH_BAN_GIAO_HSTL_CHO_TD where ID_CUOC_TTKT = " +
		// idCuocTtkt;
		// }
		// conn = DataSourceConfiguration.getConnection();
		// statement = conn.createStatement();
		// statement.execute(sql);
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// throw e;
		// } finally {
		// DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		// }
		UserTransaction tx = null;
		Session session = null;
		try {
			BaseHibernateDAO dao = new BaseHibernateDAO();
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();
			session.createQuery("delete TTKT_TH_BAN_GIAO_HSTL_CHO_TD where ID_CUOC_TTKT = " + idCuocTtkt).executeUpdate();
			for (int i = 0; i < arrBanGiaoHstlChoTruongDoan.length; i++) {
				arrBanGiaoHstlChoTruongDoan[i].setId(KeyManagement.getGUID());
				dao.saveObject(appContext, arrBanGiaoHstlChoTruongDoan[i], Boolean.TRUE);
			}

			session.flush();
			tx.commit();
		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}

	/**
	 * L?y thông tin thay ??i thành viên ?oàn
	 * 
	 * @param appContext
	 * @param idThayDoi
	 *            Id thay ??i thành viên ?oàn
	 * @return Thay ??i thành viên ?oàn
	 */
	public static TtktCmThayDoiTvd getThayDoiThanhVienDoan(ApplicationContext appContext, String idThayDoi) throws Exception {
		return (TtktCmThayDoiTvd) dao.retrieveObject(appContext, TtktCmThayDoiTvd.class, idThayDoi);
	}

	/**
	 * L?y n?i dung thay ??i thành viên ?oàn
	 * 
	 * @param appContext
	 * @param idThayDoi
	 *            Id thay ??i thành viên ?oàn
	 * @return N?i dung thay ??i thành viên ?oàn
	 */
	public static TtktCmThayDoiThemMoiTvd[] getNoiDungThayDoiThanhVienDoan(ApplicationContext appContext, String idThayDoi) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktCmThayDoiThemMoiTvd.class);
		criteria.addSearchItem("idThayDoiTvd", idThayDoi);
		Collection dsThayDoi = dao.retrieveObjects(appContext, criteria);
		if (Formater.isNull(dsThayDoi))
			return null;
		TtktCmThayDoiThemMoiTvd[] arrReturn = new TtktCmThayDoiThemMoiTvd[dsThayDoi.size()];
		int index = 0;
		Iterator iterator = dsThayDoi.iterator();
		while (iterator.hasNext()) {
			arrReturn[index] = (TtktCmThayDoiThemMoiTvd) iterator.next();
			index++;
		}
		return arrReturn;
	}

	/**
	 * L?u thay ??i thành viên ?oàn
	 * <p>
	 * N?u ch?a t?n t?i thay ??i thành viên ?oàn thì insert, ng??c l?i thì s?a thay ??i thành viên ?oàn
	 * 
	 * @param appContext
	 * @param thayDoiTvd
	 *            Thay ??i thành viên ?oàn
	 */
	public static void saveThayDoiTvd(ApplicationContext appContext, TtktCmThayDoiTvd thayDoiTvd) throws Exception {

		// Luu thay doi
		if (Formater.isNull(thayDoiTvd.getId())) {
			insertThayDoiTvd(appContext, thayDoiTvd);

		} else {
			deleteThayDoiTvd(appContext, thayDoiTvd);
			insertThayDoiTvd(appContext, thayDoiTvd);

		}
	}

	/**
	 * Xóa thay ??i thành viên ?oàn
	 * 
	 * @param appContext
	 * @param thayDoiTvd
	 *            Thay ??i thành viên ?oàn c?n xóa
	 */
	public static void deleteThayDoiTvd(ApplicationContext appContext, TtktCmThayDoiTvd thayDoiTvd) throws SQLException {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			// Xoa chi tiet danh sach thanh vien doan moi
			String sqlDelDsTvdMoi = "delete ttkt_cb_chi_tiet_ds_tv_doan t where t.id_ds_tvd = '" + thayDoiTvd.getIdDstvMoi() + "'";
			statement.addBatch(sqlDelDsTvdMoi);

			// Xoa danh sach thanh vien doan moi
			String sqlDelChiTietDsTvdMoi = "delete ttkt_cb_ds_tv_doan where id = '" + thayDoiTvd.getIdDstvMoi() + "'";
			statement.addBatch(sqlDelChiTietDsTvdMoi);

			// Xoa chi tiet thay doi
			String sqlXoaChiTietThayDoi = "delete ttkt_cm_thay_doi_them_moi_tvd where id_thay_doi_tvd = '" + thayDoiTvd.getId() + "'";
			statement.addBatch(sqlXoaChiTietThayDoi);

			// Xoa thay doi thanh vien doan
			String sqlDeleThayDoi = "delete ttkt_cm_thay_doi_tvd where id = '" + thayDoiTvd.getId() + "' ";
			statement.addBatch(sqlDeleThayDoi);

			statement.executeBatch();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}

	}

	/**
	 * Insert thay ??i thành viên ?oàn
	 * 
	 * @param appContext
	 * @param thayDoiTvd
	 *            Thay ??i thành viên ?oàn
	 */
	private static void insertThayDoiTvd(ApplicationContext appContext, TtktCmThayDoiTvd thayDoiTvd) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try {
			BaseHibernateDAO dao = new BaseHibernateDAO();
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			session = HibernateSessionFactory.currentSession();

			// Lay danh sach thanh vien cu
			TtktCbDsTvDoan dsTvDoanCu = getDsTvd(thayDoiTvd.getIdCuocTtkt(), appContext);

			// Neu da co quyet dinh thi cap nhat danh sach cu truong (isnew = 0)
			if (!Formater.isNull(thayDoiTvd.getSoQd())) {
				session.createSQLQuery("update TTKT_CB_DS_TV_DOAN set ISNEW = 0 where id = " + dsTvDoanCu.getId()).executeUpdate();
				// Neu la thay doi truong doan => cap nhat lai truong doan
				if (thayDoiTvd.getLoaiThayDoi().equals("truong_doan")) {
					session.createSQLQuery(
							"update ttkt_kh_cuoc_ttkt set id_truong_doan = '" + thayDoiTvd.getChiTietThayDoi()[0].getIdThanhVienMoi() + "', TEN_TRUONG_DOAN = '"
									+ thayDoiTvd.getChiTietThayDoi()[0].getTenThanhVienMoi() + "' where id = " + thayDoiTvd.getIdCuocTtkt()).executeUpdate();
				}
			}

			// Tao danh sach tvd moi
			TtktCbDsTvDoan dsTvDoanMoi = createDsTvdMoi(dsTvDoanCu, thayDoiTvd, appContext);
			// Luu danh sach tvd moi
			dao.saveObject(appContext, dsTvDoanMoi, Boolean.TRUE);
			// Luu chi tiet danh sach tvd moi
			Collection chiTietDstvdMoi = dsTvDoanMoi.getChiTietDanhSachTV();
			Iterator iterator = chiTietDstvdMoi.iterator();
			while (iterator.hasNext()) {
				TtktCbChiTietDsTvDoan thanhVienDoan = (TtktCbChiTietDsTvDoan) iterator.next();
				dao.saveObject(appContext, thanhVienDoan, Boolean.TRUE);
			}

			// Luu thong tin thay doi thanh vien doan
			// Thong tin thay doi
			thayDoiTvd.setId(KeyManagement.getGUID());
			thayDoiTvd.setIdDstvCu(dsTvDoanCu.getId());
			thayDoiTvd.setIdDstvMoi(dsTvDoanMoi.getId());
			thayDoiTvd.setDanhSachThayDoi(KeyManagement.getGUID());
			dao.saveObject(appContext, thayDoiTvd, Boolean.TRUE);
			// Luu chi tiet thay doi
			TtktCmThayDoiThemMoiTvd[] chiTietThayDoi = thayDoiTvd.getChiTietThayDoi();
			for (int i = 0; i < chiTietThayDoi.length; i++) {
				chiTietThayDoi[i].setId(KeyManagement.getGUID());
				chiTietThayDoi[i].setIdThayDoiTvd(thayDoiTvd.getId());
				chiTietThayDoi[i].setLoaiThayDoi(thayDoiTvd.getLoaiThayDoi());
				chiTietThayDoi[i].setChucVuTrongDoanThanhVienMoi(chiTietThayDoi[i].getChucVuThanhVienCu());
				dao.saveObject(appContext, chiTietThayDoi[i], Boolean.TRUE);
			}

			session.flush();
			tx.commit();
		} catch (Exception e) {
			HibernateSessionFactory.rollbackQuiet();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			HibernateSessionFactory.closeSession(session);
		}

	}

	/**
	 * T?o danh sách thành viên ?oàn m?i t? danh sách thành viên ?oàn c? và thay ??i thành viên ?oàn
	 * 
	 * @param dsTvDoanCu
	 *            Danh sách thành viên ?oàn c?
	 * @param thayDoiTvd
	 *            Thay ??i thành viên ?oàn
	 * @param appContext
	 * @return Danh sách thành viên ?oàn m?i
	 */
	private static TtktCbDsTvDoan createDsTvdMoi(TtktCbDsTvDoan dsTvDoanCu, TtktCmThayDoiTvd thayDoiTvd, ApplicationContext appContext) throws Exception {
		TtktCbDsTvDoan dsTvDoan = new TtktCbDsTvDoan();
		dsTvDoan.setIdDsTvdCu(dsTvDoanCu.getId());
		dsTvDoan.setId(KeyManagement.getGUID());
		dsTvDoan.setIdCuocTtkt(dsTvDoanCu.getIdCuocTtkt());
		if (!Formater.isNull(thayDoiTvd.getSoQd()))
			dsTvDoan.setIsNew(Boolean.TRUE);
		Collection chiTietDsTvDoanCu = dsTvDoanCu.getChiTietDanhSachTV();
		TtktCmThayDoiThemMoiTvd[] arrDanhSachThayDoi = thayDoiTvd.getChiTietThayDoi();
		Collection chiTietDsTvdMoi = new ArrayList();

		if (thayDoiTvd.getLoaiThayDoi().equals("truong_doan") || "thanh_vien_doan".equals(thayDoiTvd.getLoaiThayDoi())) {
			if ("thanh_vien_doan".equals(thayDoiTvd.getLoaiThayDoi())) {
				Iterator iter = chiTietDsTvDoanCu.iterator();
				while (iter.hasNext()) {
					TtktCbChiTietDsTvDoan thanhVienDoanCu = (TtktCbChiTietDsTvDoan) iter.next();
					TtktCbChiTietDsTvDoan thanhVienDoanMoi = checkThayDoi(thanhVienDoanCu, arrDanhSachThayDoi);
					if (thanhVienDoanMoi == null)
						thanhVienDoanMoi = thanhVienDoanCu.copy();
					thanhVienDoanMoi.setId(KeyManagement.getGUID());
					thanhVienDoanMoi.setIdDsTvd(dsTvDoan.getId());
					chiTietDsTvdMoi.add(thanhVienDoanMoi);

				}
			} else {
				TtktCbChiTietDsTvDoan truongDoanMoi = new TtktCbChiTietDsTvDoan(arrDanhSachThayDoi[0].getIdThanhVienMoi(), arrDanhSachThayDoi[0].getTenThanhVienMoi(), arrDanhSachThayDoi[0]
						.getChucVuThanhVienMoi(), arrDanhSachThayDoi[0].getDonViCongTacTvMoi(), "Truong doan");
				truongDoanMoi.setId(KeyManagement.getGUID());
				truongDoanMoi.setIdDsTvd(dsTvDoan.getId());
				chiTietDsTvdMoi.add(truongDoanMoi);
				Iterator iter = chiTietDsTvDoanCu.iterator();
				while (iter.hasNext()) {
					TtktCbChiTietDsTvDoan thanhVienDoanCu = (TtktCbChiTietDsTvDoan) iter.next();
					if (!"Truong doan".equals(thanhVienDoanCu.getChucVuTrongDoan())) {
						TtktCbChiTietDsTvDoan thanhVienDoanMoi = thanhVienDoanCu.copy();
						thanhVienDoanMoi.setId(KeyManagement.getGUID());
						thanhVienDoanMoi.setIdDsTvd(dsTvDoan.getId());
						chiTietDsTvdMoi.add(thanhVienDoanMoi);
					}
				}
			}

		} else if ("bo_sung_thanh_vien_doan".equals(thayDoiTvd.getLoaiThayDoi())) {
			// Thanh vien cu
			Iterator iterator = chiTietDsTvDoanCu.iterator();
			while (iterator.hasNext()) {
				TtktCbChiTietDsTvDoan chiTietDsTvDoan = (TtktCbChiTietDsTvDoan) iterator.next();
				TtktCbChiTietDsTvDoan thanhVienDoanMoi = chiTietDsTvDoan.copy();
				// Thay doi id de thoa man contrains
				thanhVienDoanMoi.setId(KeyManagement.getGUID());
				thanhVienDoanMoi.setIdDsTvd(dsTvDoan.getId());
				chiTietDsTvdMoi.add(thanhVienDoanMoi);

			}
			// Thanh vien moi
			for (int i = 0; i < arrDanhSachThayDoi.length; i++) {
				TtktCbChiTietDsTvDoan thanhVienMoi = new TtktCbChiTietDsTvDoan(arrDanhSachThayDoi[i].getIdThanhVienMoi(), arrDanhSachThayDoi[i].getTenThanhVienMoi(), arrDanhSachThayDoi[i]
						.getChucVuThanhVienMoi(), arrDanhSachThayDoi[i].getDonViCongTacTvMoi(), arrDanhSachThayDoi[i].getChucVuTrongDoanThanhVienMoi());
				thanhVienMoi.setId(KeyManagement.getGUID());
				thanhVienMoi.setIdDsTvd(dsTvDoan.getId());
				chiTietDsTvdMoi.add(thanhVienMoi);
			}

		}
		dsTvDoan.setChiTietDanhSachTV(chiTietDsTvdMoi);
		return dsTvDoan;
	}

	/**
	 * Ki?m tra m?t thành viên ?oàn có b? thay ??i trong thay ??i thành viên ?oàn hay không
	 * 
	 * @param thanhVienDoanCu
	 *            Danh sách thành viên ?oàn c?
	 * @param arrDanhSachThayDoi
	 *            Danh sách chi ti?t thay ??i
	 * @return Thành viên ?oàn ???c b? sung ho?c null n?u thành viên ?oàn c?n ki?m tra là không b? thay ??i
	 */
	private static TtktCbChiTietDsTvDoan checkThayDoi(TtktCbChiTietDsTvDoan thanhVienDoanCu, TtktCmThayDoiThemMoiTvd[] arrDanhSachThayDoi) throws Exception {
		for (int i = 0; i < arrDanhSachThayDoi.length; i++) {
			if (arrDanhSachThayDoi[i].getIdThanhVienCu().equals(thanhVienDoanCu.getIdCanBo())) {
				return new TtktCbChiTietDsTvDoan(arrDanhSachThayDoi[i].getIdThanhVienMoi(), arrDanhSachThayDoi[i].getTenThanhVienMoi(), arrDanhSachThayDoi[i].getChucVuThanhVienMoi(),
						arrDanhSachThayDoi[i].getDonViCongTacTvMoi(), thanhVienDoanCu.getChucVuTrongDoan());

			}
		}
		return null;
	}

	/**
	 * Duy?t k? ho?ch n?m, n?u k? ho?ch n?m ?ã ???c duy?t thì c?p nh?t thông tin duy?t
	 * 
	 * @param appContext
	 * @param duyetKeHoach
	 *            N?m c?n duy?t k? ho?ch
	 */
	public static void saveDuyetKeHoach(ApplicationContext appContext, TtktKhDuyetKeHoach duyetKeHoach) throws Exception {
		if (Formater.isNull(duyetKeHoach.getId())) {
			duyetKeHoach.setId(KeyManagement.getGUID());
			dao.saveObject(appContext, duyetKeHoach);
		} else {
			dao.updateObject(appContext, duyetKeHoach);
		}

	}

	/**
	 * L?y thông tin duy?t k? ho?ch n?m c?a c? quan thu? ??ng nh?p
	 * 
	 * @param appContext
	 * @param keHoachNam
	 *            N?m c?n l?y thông tin
	 * @return Thông tin duy?t k? ho?ch n?m
	 * @throws Exception
	 */
	public static TtktKhDuyetKeHoach getDuyetKeHoach(ApplicationContext appContext, String keHoachNam) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktKhDuyetKeHoach.class);
		criteria.addSearchItem("maCqt", appContext.getMaCqt());
		criteria.addSearchItem("keHoachNam", Long.valueOf(keHoachNam));
		Collection listDuyetKeHoach = dao.retrieveObjects(appContext, criteria);
		if (Formater.isNull(listDuyetKeHoach))
			return null;
		else
			return (TtktKhDuyetKeHoach) ((ArrayList) listDuyetKeHoach).get(0);
	}

	/**
	 * L?y s? cu?c Thanh tra ki?m tra hi?n có theo lo?i (??nh k? hay ??t xu?t) và theo n?m
	 * 
	 * @param appContext
	 * @param type
	 *            ??nh k? ho?c ??t xu?t
	 * @param year
	 *            N?m c?n ??m
	 * @return S? cu?c Thanh Tra Ki?m tra
	 * @throws Exception
	 */
	public static int getSoCuocTtkt(ApplicationContext appContext, String type, String year) throws Exception {
		// Dieu kien tim kiem
		SearchCriteria criteria = new SearchCriteria(TtktKhCuocTtkt.class);
		// Ma cqt
		criteria.addSearchItem(TtktKhCuocTtkt.IdDonViTh, appContext.getMaCqt());
		// Nam thuc hien
		criteria.addSearchItem(TtktKhCuocTtkt.Ma, "%" + year + "%", SearchCriteria.OP_LIKE);
		// Loai ke hoach
		if (Constants.TTKT_LOAI_KH.equals(type)) {
			// Loai ke hoach
			criteria.addSearchItem(TtktKhCuocTtkt.Loai, Boolean.FALSE);
			Collection dsTrangThai = new ArrayList();
			// Nhung cuoc khong thay doi trong chinh sua ke hoach
			dsTrangThai.add(Constants.TTKT_LOAI_KHN_KH);
			// Nhung cuoc bi xoa trong chinh sua ke hoach
			dsTrangThai.add(Constants.TTKT_LOAI_KHN_DEL);
			// Nhung cuoc bi sua trong chinh sua ke hoach
			dsTrangThai.add(Constants.TTKT_LOAI_KHN_EDIT);
			criteria.addSearchItem(TtktKhCuocTtkt.LoaiCuocTtktKeHoachNam, dsTrangThai, SearchCriteria.OP_IN);
		} else {
			criteria.addSearchItem(TtktKhCuocTtkt.Loai, Boolean.TRUE);
		}
		Collection listCuocTtkt = dao.retrieveObjects(appContext, criteria);
		if (Formater.isNull(listCuocTtkt))
			return 0;
		else
			return listCuocTtkt.size();

	}

	/**
	 * L?y danh sách t?t c? các l?n thay ??i thành viên ?oàn
	 * 
	 * @param appConText
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return Danh sách t?t c? các l?n thay ??i thành viên ?oàn
	 * @throws Exception
	 */
	public static Collection getDsThayDoiThanhVienDoan(ApplicationContext appConText, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktCmThayDoiTvd.class);
		criteria.addSearchItem(TtktCmThayDoiTvd.IdCuocTtkt, cuocTtktId);
		Collection temp = dao.retrieveObjects(appConText, criteria);
		if (Formater.isNull(temp))
			return null;
		else
			return temp;
	}

	/**
	 * L?y danh sách ki?m kê tài s?n c?a cu?c Thanh tra Ki?m tra
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return Danh sách ki?m kê tài s?n c?a cu?c Thanh tra Ki?m tra
	 * @throws Exception
	 */
	public static Collection getKiemTaiSan(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThQdKiemKe.class);
		criteria.addSearchItem("idCuocTtkt", cuocTtktId);
		return dao.retrieveObjects(appContext, criteria);
	}

	/**
	 * L?y danh sách phúc tra c?a cu?c Thanh tra Ki?m tra
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return Danh sách phúc tra c?a cu?c Thanh tra Ki?m tra
	 * @throws Exception
	 */
	public static Collection getDsPhucTra(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThPhucTra.class);
		criteria.addSearchItem("idCuocTtkt", cuocTtktId);
		return dao.retrieveObjects(appContext, criteria);
	}

	/**
	 * L?y danh sách chuy?n giao h? s? v? vi?c c?a cu?c Thanh tra Ki?m tra
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return Danh sách chuy?n giao h? s? v? vi?c
	 * @throws Exception
	 */
	public static Collection getChuyenGiaoHsvv(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktKtChuyenGiaoHsVv.class);
		criteria.addSearchItem("idCuocTtkt", cuocTtktId);
		return dao.retrieveObjects(appContext, criteria);
	}

	/**
	 * L?y danh sách thay ??i thành viên ?oàn c?a cu?c Thanh tra Ki?m tra
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return Danh sách thay ??i thành viên ?oàn c?a cu?c Thanh tra Ki?m tra
	 */
	public static Collection getDsThayDoiTvd(ApplicationContext appContext, String cuocTtktId) throws Exception {		
		String sql = "select * from ttkt_cm_thay_doi_tvd t";
		sql += " where t.id_cuoc_ttkt = " + cuocTtktId;
		sql += " connect by prior t.id_dstv_moi = t.id_dstv_cu";
		sql += " start with t.id_dstv_cu not in (select id_dstv_moi from ttkt_cm_thay_doi_tvd where t.id_cuoc_ttkt = " + cuocTtktId + ")";
		return HibernateSessionFactory.currentSession().createSQLQuery(sql.toString()).addEntity(TtktCmThayDoiTvd.class).list();
	}

	/**
	 * L?y k? ho?ch n?m hi?n t?i c?a c? quan thu? ??ng nh?p
	 * 
	 * @param appContext
	 * @return K? ho?ch n?m hi?n t?i c?a c? quan thu? ??ng nh?p
	 */
	public static Collection getKeHoachNam(ApplicationContext appContext) throws Exception {
		Collection ret = new ArrayList();
		SearchCriteria criteria = new SearchCriteria(TtktKhCuocTtkt.class);
		criteria.addSearchItem("idDonViTh", appContext.getMaCqt());
		criteria.addSearchItem(TtktKhCuocTtkt.IdCuocTtktCha, null, SearchCriteria.LG_IS_NULL);
		criteria.addSearchItem(TtktKhCuocTtkt.Loai, Boolean.FALSE);
		Collection temp = dao.retrieveObjects(appContext, criteria);
		Iterator iter = temp.iterator();
		while (iter.hasNext()) {
			TtktKhCuocTtkt cuocTtkt = (TtktKhCuocTtkt) iter.next();
			ret.add(CuocTtktService.getCuocTtktWithoutNoiDung(appContext, cuocTtkt.getId()));
		}
		return ret;
	}

	/**
	 * L?y n?i dung c?a cu?c Thanh tra Ki?m tra
	 * 
	 * @param cuocTtkt
	 *            Cu?c Thanh tra Ki?m tra
	 * @return N?i dung c?a cu?c Thanh tra Ki?m tra
	 */
	public static String getNoiDungTtkt(TtktKhCuocTtkt cuocTtkt) {
		String reVal = "";
		if (Formater.isNull(cuocTtkt.getDsNoiDungTTKT())) {
			Collection dsCqtTrucThuoc = cuocTtkt.getDsTtktCqtTrucThuoc();
			Iterator iter = dsCqtTrucThuoc.iterator();
			while (iter.hasNext()) {
				TtktKhCuocTtkt ttktCqtTrucThuoc = (TtktKhCuocTtkt) iter.next();
				Collection dsNoiDung = ttktCqtTrucThuoc.getDsNoiDungTTKT();
				Iterator iterNoiDung = dsNoiDung.iterator();
				while (iterNoiDung.hasNext()) {
					TtktKhNoiDungTtkt noiDungTtkt = (TtktKhNoiDungTtkt) iterNoiDung.next();
					if (reVal.indexOf(noiDungTtkt.getTenNoiDung()) < 0){
						reVal += "- "+ttktCqtTrucThuoc.getTenDonViBi()+": "+noiDungTtkt.getTenNoiDung()+"\n";
						//Iterator dsNDung = noiDungTtkt.getDsChiTietNoiDung().iterator();
						//while (dsNDung.hasNext()) {
						//	TtktKhChiTietNoiDungTtkt chitietND = (TtktKhChiTietNoiDungTtkt)(dsNDung.next());
							//reVal+="         "+chitietND.getIdNoiDungChiTiet()+"\n";
						//}
						
					}
				}

			}

		} else {
			Collection dsNoiDung = cuocTtkt.getDsNoiDungTTKT();
			Iterator iterNoiDung = dsNoiDung.iterator();
			while (iterNoiDung.hasNext()) {
				TtktKhNoiDungTtkt noiDungTtkt = (TtktKhNoiDungTtkt) iterNoiDung.next();
				if (reVal.indexOf(noiDungTtkt.getTenNoiDung()) < 0)
					reVal +="- "+ cuocTtkt.getTenDonViBi()+": "+noiDungTtkt.getTenNoiDung() + ";" +"\n";
			}
		}
		reVal = reVal.substring(0, reVal.length() - 1);
		return reVal;
	}

	/**
	 * Ki?m tra quy?n s?a ??i v?i m?t thay ??i thành viên ?oàn
	 * 
	 * @param idThayDoiThanhVienDoan
	 *            Id thay ??i thành viên ?oàn
	 * @return true n?u thay ??i thành viên ?oàn ch?a ???c duy?t, ng??c l?i tr? v? false
	 */
	public static boolean checkRightEdit(String idThayDoiThanhVienDoan) {
		boolean bReturn = false;
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select t1.*, t2.id from TTKT_CB_DS_TV_DOAN t1, ttkt_cm_thay_doi_tvd t2 where t2.id_dstv_moi = t1.id and t1.isnew = 1 and t2.id =" + idThayDoiThanhVienDoan;
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			if (rs.next())
				bReturn = true;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, statement, conn);
		}

		return bReturn;
	}

	/**
	 * Ki?m tra xem k? ho?ch n?m c?a c? quan thu? ?ã ???c duy?t ch?a
	 * 
	 * @param appContext
	 * @param maCqt
	 *            Mã c? quan thu?
	 * @param namKeHoach
	 *            N?m k? ho?ch
	 * @return true n?u k? ho?ch n?m c?a cqt ?ã ???c duy?t, ng??c l?i tr? v? false
	 */
	public static boolean isDuyetKhNam(ApplicationContext appContext, String maCqt, String namKeHoach) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktKhDuyetKeHoach.class);
		criteria.addSearchItem(TtktKhDuyetKeHoach.MaCqt, maCqt);
		criteria.addSearchItem("keHoachNam", Long.valueOf(namKeHoach));
		Collection temp = dao.retrieveObjects(appContext, criteria);
		if (Formater.isNull(temp))
			return false;
		else
			return true;
	}

	/**
	 * L?y danh sách thành viên ?oàn t?i th?i ?i?m ra quy?t ??nh
	 * 
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @param appConText
	 * @return Danh sách thành viên ?oàn t?i th?i ?i?m ra quy?t ??nh
	 */
	public static TtktCbDsTvDoan getDsTvdInQd(String cuocTtktId, ApplicationContext appConText) throws Exception {
		// Ds thanh vien doan
		CatalogService cs = new CatalogService();
		SearchCriteria criteria = new SearchCriteria(TtktCbDsTvDoan.class);
		criteria.addSearchItem("idCuocTtkt", cuocTtktId);
		//criteria.addSearchItem("idDsTvdCu", null, SearchCriteria.LG_IS_NULL);
		Collection listTemp = cs.retrive(appConText, criteria);
		String idDsTvdMoi="";
		if (Formater.isNull(listTemp))
			return null;
		if(listTemp.size()>1)
		{
			criteria.addSearchItem("isNew", Boolean.TRUE);
			TtktCbDsTvDoan dsTvdMoi = (TtktCbDsTvDoan) ((ArrayList) cs.retrive(appConText, criteria)).get(0);
			idDsTvdMoi=dsTvdMoi.getId();
		}
		else { }
		TtktCbDsTvDoan dsTvd = (TtktCbDsTvDoan) ((ArrayList) listTemp).get(0);
		// Chi tien ds thanh vien doan
		criteria = new SearchCriteria(TtktCbChiTietDsTvDoan.class);
		if(!Formater.isNull(idDsTvdMoi))
			criteria.addSearchItem(TtktCbChiTietDsTvDoan.IdDsTvd, idDsTvdMoi);
		else
		criteria.addSearchItem(TtktCbChiTietDsTvDoan.IdDsTvd, dsTvd.getId());

		Collection chitietDsThanhVienDoan = dao.retrieveObjects(appConText, criteria);
		// Sap xep lai thu tu, truong doan len dau tien
		int index = 0;
		Iterator iter = chitietDsThanhVienDoan.iterator();
		while (iter.hasNext()) {
			TtktCbChiTietDsTvDoan tvDoan = (TtktCbChiTietDsTvDoan) iter.next();
			if (Constants.TTKT_CVTD_TD.equals(tvDoan.getChucVuTrongDoan()))
				break;
			index++;
		}
		ArrayList temp = new ArrayList();
		temp.add(((ArrayList) chitietDsThanhVienDoan).get(index));
		for (int i = 0; i < chitietDsThanhVienDoan.size(); i++) {
			if (i != index)
				temp.add(((ArrayList) chitietDsThanhVienDoan).get(i));
		}
		dsTvd.setChiTietDanhSachTV(temp);
		return dsTvd;
	}

	/**
	 * L?y danh sách thành viên ?oàn theo Id
	 * 
	 * @param appContext
	 * @param idDsTvd
	 *            Id danh sách thành viên ?oàn theo Id
	 * @return Danh sách thành viên ?oàn
	 */
	public static Collection getDsTvdById(ApplicationContext appContext, String idDsTvd) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktCbChiTietDsTvDoan.class);
		criteria.addSearchItem(TtktCbChiTietDsTvDoan.IdDsTvd, idDsTvd);
		return dao.retrieveObjects(appContext, criteria);
	}

	/**
	 * L?y danh sách gia h?n c?a cu?c Thanh tra Ki?m tra
	 * 
	 * @param appContext
	 * @param cuocTtktId
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return Danh sách gia h?n c?a cu?c Thanh tra Ki?m tra
	 */
	public static Collection getDsGiaHan(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktThGiaHan.class);
		criteria.addSearchItem(TtktThGiaHan.IdCuocTtkt, cuocTtktId);
		return dao.retrieveObjects(appContext, criteria);
	}

	/**
	 * L?y t?ng th?i gian gia h?n c?a cu?c Thanh tra Ki?m tra
	 * 
	 * @param appContext
	 * @param idCuocTtkt
	 *            Id cu?c Thanh tra Ki?m tra
	 * @return T?ng th?i gian gia h?n c?a cu?c Thanh tra Ki?m tra
	 */
	public static int getTongThoiGianRaHan(ApplicationContext appContext, String idCuocTtkt) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		Statement statement = null;
		int iReturn = 0;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery("select sum(t.so_ngay_gia_han) from TTKT_TH_GIA_HAN t where id_cuoc_ttkt = '" + idCuocTtkt + "' and so_qd is not null");
			if (rs.next()) {
				iReturn = rs.getByte(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(rs, statement, conn);
		}

		return iReturn;
	}

	/**
	 * @param appContext
	 * @param cuocTtktId
	 * @return
	 */
	public static boolean isChuaDuyetThayDoiTvd(ApplicationContext appContext, String cuocTtktId) throws Exception {
		SearchCriteria criteria = new SearchCriteria(TtktCmThayDoiTvd.class);
		criteria.addSearchItem(TtktCmThayDoiTvd.IdCuocTtkt, cuocTtktId);
		criteria.addSearchItem(TtktCmThayDoiTvd.SoQd, null, SearchCriteria.LG_IS_NULL);
		return !Formater.isNull(dao.retrieveObjects(appContext, criteria));
	}

	

	public static Collection getDsChuyenGiaoHsvv(ApplicationContext appContext, String cuocTtktId) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void deleteBbChiTietById(ApplicationContext appContext, String id) throws Exception {
		(new File(UploadAction.UPLOAD_FOLDER + id)).delete();
		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			statement.execute("delete TTKT_TH_BB_CHITIETVATONGHOP where id = '" + id+"'");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}
	}

	public static void deleteBanGiaoHstlChoTdById(ApplicationContext appContext, String id) throws Exception {
		Connection conn = null;
		Statement statement = null;
		try {
			conn = DataSourceConfiguration.getConnection();
			statement = conn.createStatement();
			statement.execute("delete TTKT_TH_BAN_GIAO_HSTL_CHO_TD where id = " + id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DataSourceConfiguration.releaseSqlResources(null, statement, conn);
		}
	}

	
	public static void saveKetLuanSangBC(ApplicationContext appContext, TtktThBbChitietvatonghop bienBan, String trangThai) throws Exception {
		UserTransaction tx = null;
		Session session = null;
		try{
			if (Formater.isNull(bienBan.getDcID()))
				bienBan.setDcID(KeyManagement.getGUID());
			TtktKtKetLuanChuyenBC obj = null;
			if(Formater.isNull(bienBan.getId()))
			{
				obj = new TtktKtKetLuanChuyenBC();
				obj.setId(bienBan.getDcID());
			}
			else
				obj = getKetLuanSangBC(appContext, bienBan.getIdCuocTtkt());			
			obj.setIdCuocTtkt(bienBan.getIdCuocTtkt());
			obj.setIdNguoiCapNhat(bienBan.getIdNguoiCapNat());
			if (!Formater.isNull(bienBan.getDcKienNghiKhac()))
				obj.setKienNghiKhac(new Long(Formater.str2num(bienBan.getDcKienNghiKhac()).longValue()));
			obj.setKtraSauTtkt("1".equals(bienBan.isDcKiemTraSauTTKT())?new Long(1):new Long(0));
			
			obj.setMoTa(bienBan.getDcMoTa());
			obj.setNgayCapNhat(bienBan.getNgayCapNhat());
			//New co kiem tra sau TTKT
			if("1".equals(bienBan.isDcKiemTraSauTTKT())){
				if(!Formater.isNull(bienBan.getSoTienDaThuHauKiem()))
					obj.setSoTienDaThuHauKiem(new Long(Formater.str2num(bienBan.getSoTienDaThuHauKiem()).longValue()));
				if (!Formater.isNull(bienBan.getDcTsKlTtktQdxlDaKtra()))
					obj.setTsKlTtktQdxlDaKtra(new Long(Formater.str2num(bienBan.getDcTsKlTtktQdxlDaKtra()).longValue()));
			}
			//New khong kierm tra => reset gia tri ve 0
			else{
				obj.setSoTienDaThuHauKiem(new Long(0));
				obj.setTsKlTtktQdxlDaKtra(new Long(0));
			}
			if (!Formater.isNull(bienBan.getDcSoDonViTTKT()))
				obj.setSoDviDuocTtkt(new Long(Formater.str2num(bienBan.getDcSoDonViTTKT()).longValue()));
			if (!Formater.isNull(bienBan.getDcSoDonViSaiPham()))
				obj.setSoDviSaiPham(new Long(Formater.str2num(bienBan.getDcSoDonViSaiPham()).longValue()));
			if (!Formater.isNull(bienBan.getDcSoSDBC_QTQC()))
				obj.setSoSdbsQtqc(new Long(Formater.str2num(bienBan.getDcSoSDBC_QTQC()).longValue()));
			if (!Formater.isNull(bienBan.getDcSoSDBS_VPBQ()))
				obj.setSoSdbsVbpq(new Long(Formater.str2num(bienBan.getDcSoSDBS_VPBQ()).longValue()));
			if (!Formater.isNull(bienBan.getDcSoTienKnghiThuHtraSpKhac()))
				obj.setSoTienKnghiThuHtraSpKhac(new Double(Formater.toDouble(bienBan.getDcSoTienKnghiThuHtraSpKhac())));
			
			if (!Formater.isNull(bienBan.getDcSoTienThuCongChucThue()))
				obj.setSoTienThuCongChucThue(new Double(Formater.toDouble(bienBan.getDcSoTienThuCongChucThue())));
			if (!Formater.isNull(bienBan.getDcSoTienThuNguoiNopThue()))
				obj.setSoTienThuNguoiNopThue(new Double(Formater.toDouble(bienBan.getDcSoTienThuNguoiNopThue())));
			if (!Formater.isNull(bienBan.getDcSoTienNopCongChucTHue()))
				obj.setSoTienTraCongChucThue(new Double(Formater.toDouble(bienBan.getDcSoTienNopCongChucTHue())));
			if (!Formater.isNull(bienBan.getDcSoTienNopNguoiNopThue()))
				obj.setSoTienTraNguoiNopThue(new Double(Formater.toDouble(bienBan.getDcSoTienNopNguoiNopThue())));
			
			if (!Formater.isNull(bienBan.getDcSoTTKTThue()))
				obj.setSoTtktThue(new Long(Formater.str2num(bienBan.getDcSoTTKTThue()).longValue()));
			obj.setTenNguoiCapNhap(bienBan.getTenNguoiCapNhat());
			
			if (!Formater.isNull(bienBan.getDcTSTienThuCongChucThue()))
				obj.setTsTienThuCongChucThue(new Double(Formater.toDouble(bienBan.getDcTSTienThuCongChucThue())));
			if (!Formater.isNull(bienBan.getDcTsTienThuHtraSpKhac()))
				obj.setTsTienThuHtraSpKhac(new Double(Formater.toDouble(bienBan.getDcTsTienThuHtraSpKhac())));
			if (!Formater.isNull(bienBan.getDcTSTienThuNguoiNopThue()))
				obj.setTsTienThuNguoiNopThue(new Double(Formater.toDouble(bienBan.getDcTSTienThuNguoiNopThue())));
			if (!Formater.isNull(bienBan.getDcTSTienTraCongChucThue()))
				obj.setTsTienTraCongChucThue(new Double(Formater.toDouble(bienBan.getDcTSTienTraCongChucThue())));
			if (!Formater.isNull(bienBan.getDcTSTienTraNguoiNopThue()))
				obj.setTsTienTraNguoiNopThue(new Double(Formater.toDouble(bienBan.getDcTSTienTraNguoiNopThue())));
			
			if (!Formater.isNull(bienBan.getDcXuLiHanhChinhCongVienChucThue()))
				obj.setXlhcCongVienChucThue(new Long(Formater.str2num(bienBan.getDcXuLiHanhChinhCongVienChucThue()).longValue()));
			if (!Formater.isNull(bienBan.getDcXuLiHanhChinhDoiTuongKhac()))
				obj.setXlhcDoiTuongKhac(new Long(Formater.str2num(bienBan.getDcXuLiHanhChinhDoiTuongKhac()).longValue()));
			if (!Formater.isNull(bienBan.getDcXLHSSoNguoi()))
				obj.setXlhsSoNguoi(new Long(Formater.str2num(bienBan.getDcXLHSSoNguoi()).longValue()));
			if (!Formater.isNull(bienBan.getDcXLHSSoVuViec()))
				obj.setXlhsSoVuViec(new Long(Formater.str2num(bienBan.getDcXLHSSoVuViec()).longValue()));
			if (!Formater.isNull(bienBan.getDcSoTienThuDoiTuongKhac()))
				obj.setSoTienThuDoiTuongKhac(new Double(Formater.toDouble(bienBan.getDcSoTienThuDoiTuongKhac())));
			if (!Formater.isNull(bienBan.getDcSoTienNopDoiTuongKhac()))
				obj.setSoTienNopDoiTuongKhac(new Double(Formater.toDouble(bienBan.getDcSoTienNopDoiTuongKhac())));
		
			try {
				tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
				tx.begin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			session = HibernateSessionFactory.currentSession();
			session.saveOrUpdate(obj);
			session.flush();
			tx.commit();
		}catch(Exception ex){
			tx.rollback();
			ex.printStackTrace();
		}finally {
			HibernateSessionFactory.closeSessionQuiet();
		}
	}

	public static Collection getThongKeCanBo(ApplicationContext appcontext) {
		// TODO Auto-generated method stub
		SearchCriteria sc = new SearchCriteria(KtnbTkCanBo.class);
		Collection result = new ArrayList();
		try {
			sc.addSearchItem(KtnbTkCanBo.MA_CQT,appcontext.getMaCqt(),SearchCriteria.OP_EQ);
			result = dao.retrieveObjects(appcontext, sc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static boolean saveThongKeCanBo(ApplicationContext appContext, KtnbTkCanBo bo) {
		// TODO Auto-generated method stub
		UserTransaction tx = null;
		Session session = null;
		try {
			tx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
			tx.begin();
			session = HibernateSessionFactory.currentSession();
			session.saveOrUpdate(bo);
			session.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		try {
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				tx.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			e.printStackTrace();
			return false;
		}finally {
			HibernateSessionFactory.closeSessionQuiet();
		}
		return true;
	}
}
