package cmc.com.ktnb.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DataSourceConfiguration {
	private static HashMap cache = new HashMap();

	public static DataSource getDataSource() throws Exception {
		DataSource ds = null;
		ds = (DataSource) cache.get(Constants.DBNAME);
		if (ds == null) {
			try {
				InitialContext ic = new InitialContext();
				ds = (DataSource) ic.lookup(Constants.DBNAME);
				cache.put(Constants.DBNAME, ds);
			} catch (Exception e) {
				throw e;
			}
		}
		return ds;
	}
	public static DataSource getDataSource(String dbName) throws Exception {
		DataSource ds = null;
		ds = (DataSource) cache.get(dbName);
		if (ds == null) {
			try {
				InitialContext ic = new InitialContext();
				ds = (DataSource) ic.lookup(dbName);
				cache.put(dbName, ds);
			} catch (Exception e) {
				throw e;
			}
		}
		return ds;
	}

	public static Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			conn = getDataSource().getConnection();
		} catch (Exception e) {
			throw e;
		}
		return conn;
	}
	public static Connection getConnection(String dbName) throws Exception {
		Connection conn = null;
		try {
			conn = getDataSource(dbName).getConnection();
		} catch (Exception e) {
			throw e;
		}
		return conn;
	}

	public static void releaseSqlResources(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
			conn = null;
		}
	}

	public static void releaseSqlResources(CallableStatement cs) {
		if (cs != null) {
			try {
				cs.close();
			} catch (SQLException e) {
			}
			cs = null;
		}
	}

	public static void releaseSqlResources(ResultSet rs, PreparedStatement ps) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
			rs = null;
		}

		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
			}
			ps = null;
		}
	}

	public static void releaseSqlResources(ResultSet rs, PreparedStatement ps, Connection conn) {
		releaseSqlResources(rs, ps);
		releaseSqlResources(conn);
	}

	public static void releaseSqlResources(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
			rs = null;
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
			stmt = null;
		}
		releaseSqlResources(conn);

	}
}
