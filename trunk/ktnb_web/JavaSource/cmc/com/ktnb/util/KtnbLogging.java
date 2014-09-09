package cmc.com.ktnb.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import cmc.com.ktnb.pl.hb.entity.PersistentObject;

public class KtnbLogging {
	private static Connection conn = null;

	public KtnbLogging() {
//		try {
//			conn = DataSourceConfiguration.getConnection();
//		} catch (Exception ex) {
//			throw new RuntimeException(ex);
//		}
	}

	public void close() {
		DataSourceConfiguration.releaseSqlResources(conn);
	}

	public static void insertLog(ApplicationContext appContext, PersistentObject entity, String method, String query) {
//		PreparedStatement ps = null;
//		ResultSet rs = null;
		//String sql = "";
//		try {
			/*
			HttpServletRequest request = Context.getCurrentInstance().getRequest();
			conn = DataSourceConfiguration.getConnection();
			// ID,TIME,NSD,MA_CAN_BO,ACTION,INFO,CQT
			sql = "insert into ktnb_log values(?,sysdate,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, KeyManagement.getGUID());
			ps.setString(2, appContext.getTenNsd());
			ps.setString(3, appContext.getMaCanbo());
			ps.setString(4, HttpUtil.getFullURL(request));

			String info = "";
			info += "Method: " + method + "\n";
			if (entity != null) {
				String objectInfo = "";
				Class cls = entity.getClass();
				// while (cls != null) {
				Field[] f = cls.getDeclaredFields();
				for (int i = 0; i < f.length; i++) {
					f[i].setAccessible(true);
					if (null != f[i].get(entity))
						objectInfo += "\n Name: " + f[i].getName() + " Value: " + f[i].get(entity).toString();
				}
				// cls = cls.getSuperclass();
				// }

				info += "Object: " + entity.getClass() + "\n";
				info += "Info: " + objectInfo + "\n";
			}
			if (query != null) {
				info += "SQL: " + query;
			}
			ps.setString(5, info);
			ps.setString(6, appContext.getMaCqt());
			ps.executeUpdate();
			*/
//		} catch (Exception e) {
//			// Khong ghi duoc log
//			e.printStackTrace();
//		} finally {
//			DataSourceConfiguration.releaseSqlResources(rs, ps);
//		}
	}

}
