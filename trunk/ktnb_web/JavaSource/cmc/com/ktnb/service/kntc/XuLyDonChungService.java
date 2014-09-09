/*
 * Created on Jan 19, 2011
 */
package cmc.com.ktnb.service.kntc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cmc.com.ktnb.pl.hb.entity.KntcCanBoRls;
import cmc.com.ktnb.pl.hb.entity.KntcCanBoRlsId;
import cmc.com.ktnb.util.BaseHibernateDAO;
import cmc.com.ktnb.util.DataSourceConfiguration;

/**
 * @author DoHongPhuc
 * Xử lý một số thông tin chung của hồ sơ
 */
public class XuLyDonChungService {
	private Connection conn = null;

	protected BaseHibernateDAO dao = new BaseHibernateDAO();
	/**
	 * Hàm khởi tạo mặc định
	 *
	 */
	public XuLyDonChungService() {
		super();
		try {
			conn = DataSourceConfiguration.getConnection();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	/**
	 * Lấy ra danh sách cán bộ theo mã hồ sơ
	 * @param maHoSo
	 * @return
	 */
	public ArrayList getListCanBoByMaHoSo(String maHoSo) {
		ArrayList listCB = new ArrayList();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select * from KNTC_CAN_BO_RLS where ma_hs = ?";
		try {
			rs = ps.executeQuery();
			while (rs.next()) {
				KntcCanBoRls cb = new KntcCanBoRls();
				KntcCanBoRlsId aId = new KntcCanBoRlsId(rs.getString(1),rs.getString(2),new Long(rs.getLong(8)),rs.getString(7));
				cb.setId(aId);	
				cb.setDonVi(rs.getString(3));
				cb.setChucVu(rs.getString(4));
				cb.setNgayCapNhat(rs.getDate(5));
				cb.setNguoiCapNhat(rs.getString(6));
				cb.setNgayHetHluc(rs.getDate(9));
				cb.setTenCb(rs.getString(10));

				listCB.add(cb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCB;
	}
	/**
	 * Lấy ra lần thay đổi gần nhất
	 * @param maHoSo
	 * @return
	 */
	public int getMAXLDB(String maHoSo) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select MAX(lan_td) from KNTC_CAN_BO_RLS where ma_hs = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, maHoSo);
			rs = ps.executeQuery();
			while (rs.next()) return rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	/**
	 * Lấy ra danh sách cán bộ xử lý hiện tại
	 * @param maHoSo
	 * @return
	 */
	public KntcCanBoRls getCBXLHienTai(String maHoSo) {
		KntcCanBoRls cb = new KntcCanBoRls();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int lanTd = getMAXLDB(maHoSo);
		String query = "select ma_canbo,ten_cb from KNTC_CAN_BO_RLS where ma_hs = ? and lan_td= ?";
		System.out.println(query);
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, maHoSo);
			ps.setInt(2, lanTd);
			rs = ps.executeQuery();
			while (rs.next()) {
				//cb.setMaCanbo(rs.getString(1));
				//cb.setMaHs(rs.getString(2));
				//cb.setDonVi(rs.getString(3));
				//cb.setChucVu(rs.getString(4));
				//cb.setNgayCapNhat(rs.getDate(5));
				//cb.setNguoiCapNhat(rs.getString(6));
				//cb.setLoaiCb(rs.getString(7));
				//cb.setLanTd(new Long(rs.getLong(8)));
				//cb.setNgayHetHluc(rs.getDate(9));
				cb.setTenCb(rs.getString(2));
				return cb;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cb;
	} 
}
