package cmc.com.ktnb.ocr;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.OutputStream;
import java.io.Writer;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import oracle.jdbc.pool.OracleDataSource;
import oracle.sql.BLOB;
import oracle.sql.CLOB;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.nt.NTEventLogAppender;

import cmc.com.ktnb.util.ImageFileFilter;

public class KtnbOcrMan {
	private static final ResourceBundle RB = ResourceBundle.getBundle("cmc.com.ktnb.ocr.config");

	private static final String KTNB_URL = "KTNB";
	private static final String KTNB_FILE_OUT = "E:/APP/OUT";

	private static OracleDataSource ods = null;

	private static Object lock = new Object();

	// 1. Lay het cac file images tu database ma da_nd is null
	
	// 2. Lay cac file
	private void update2DB() throws Exception {
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;ResultSet rs1 = null;
		Connection conn = null;
		try {
			conn = getConnection();
			String sql,sqlUpdate;
			String id = null;
			// update
			sql = "select t.ma_file,t.ten_file,t.loai_file,t.noi_dung from ktnb_file t where t.loai_file like 'image/%' and da_nd is null";
			sqlUpdate = "select NOI_DUNG from ktnb_file where ma_file=? FOR UPDATE";
			//TODO: Ntthu se update sau
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String maFile=rs.getString(1);
				String tenFile=rs.getString(2);
				Blob blob = rs.getBlob(4);
				OutputStream os = ((BLOB) blob).setBinaryStream(1L);
				ps1 = conn.prepareStatement(sqlUpdate);
				ps1.setString(1, maFile);
				ps1.executeUpdate();
//				os.write(vo.getMsg());
				os.flush();
				os.close();
			}
			ps = conn.prepareStatement(sqlUpdate);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				Blob blob = rs.getBlob(1);
				OutputStream os = ((BLOB) blob).setBinaryStream(1L);
//				os.write(vo.getMsg());
				os.flush();
				os.close();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			releaseResultSet(rs);
			releasePreparedStatement(ps);
			releaseConnection(conn);
		}
	}

	public static void main(String[] args) {
		KtnbOcrMan getMsg = new KtnbOcrMan();
		Connection conn = null;
		try {
			conn = getMsg.getConnection();
			System.out.println(conn.getMetaData().getURL());
			getListImageFile("D:/ktnb_file/images");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		Logger logger = Logger.getLogger("cmc.mq.GetMsg");
//		PatternLayout layout = new PatternLayout();
//		NTEventLogAppender ntEventLogAppender = new NTEventLogAppender("cmc.com.ktnb.ocr service", layout);
//		ConsoleAppender consoleAppender = new ConsoleAppender(layout);
//		logger.addAppender(consoleAppender);
//		logger.addAppender(ntEventLogAppender);
//		int action = 1;
//		if (args.length < 1) {
//			logger.error("Invalid Parameter!!!");
//			logger.error("Usage Parameter :-start -stop -put -put1");
//			System.exit(-1);
//		} else {
//			String arg = args[0].toLowerCase();
//			if (arg.equals("-stop"))
//				action = 0;
//			else if (arg.equals("-start"))
//				action = 1;
//			else if (arg.equals("-put"))
//				action = 2;
//			else if (arg.equals("-put1"))
//				action = 3;
//			else {
//				logger.error("Invalid Parameter!!!");
//				logger.error("Usage Parameter :-start -stop -put -put1");
//				System.exit(-1);
//			}
//		}
//		try {
//			KtnbOcrMan getMsg = new KtnbOcrMan();
//			if (action == 0) {
//				logger.info("Stoping Listener...");
//				getMsg.stop();
//			} else if (action == 1) {
//				logger.info("Listening...");
//				getMsg.start();
//			} else if (action == 2) {
//				logger.info("Putting...");
//				getMsg.put();
//			} else if (action == 3) {
//				logger.info("Put1");
//				getMsg.putMsg();
//			}
//			logger.info("Done! Bye Bye!");
//		} catch (Exception ex) {
//			logger.error(ex);
//			System.exit(-1);
//		}
	}
	/**
	 * Lay danh sach cac file images trong thu muc
	 * @param dir Thu muc chua file images
	 * @return List cac files
	 */
	public static List getListImageFile(String dir) {
		String result, _result[];
		result = recurseInDirFrom(dir);
		_result = result.split("@@");
		return Arrays.asList(_result);
	}

	private static String recurseInDirFrom(String dirItem) {
		File file;
		String result = "";
		file = new File(dirItem);
		if (file.isDirectory()) {
			ImageFileFilter imge = new ImageFileFilter();
			File list[] = file.listFiles(imge);
			for (int i = 0; i < list.length; i++) {
//				System.out.println(list[i].getName());
				result = result + list[i].getName();
				if (i < list.length - 1)
					result += "@@";
			}
		}
		return result;
	}

	private static OracleDataSource getDataSource() throws Exception {
		synchronized (lock) {
			if (ods == null) {
				try {
					ods = new OracleDataSource();
					ods.setURL(getString("url"));
				} catch (Exception ex) {
					ex.printStackTrace();
					throw ex;
				}
			}
		}
		return ods;
	}

	private static Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			conn = getDataSource().getConnection();
		} catch (Exception ex) {
			throw ex;
		}
		return conn;
	}

	private static void releaseConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	private static void releaseCallableStatement(CallableStatement cs) {
		if (cs != null) {
			try {
				cs.close();
			} catch (SQLException e) {
			}
		}
	}

	private static void releaseResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
	}

	private static void releasePreparedStatement(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
			}
		}
	}

	private static String getString(String key) {
		String result = null;
		try {
			result = RB.getString(key);
		} catch (MissingResourceException e) {
			return null;
		}
		return result;
	}

}