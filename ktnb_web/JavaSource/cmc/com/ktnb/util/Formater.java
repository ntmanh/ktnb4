package cmc.com.ktnb.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class Formater {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private static final SimpleDateFormat sdf4Key = new SimpleDateFormat("ddMMyy/HH:mm");

	private static final SimpleDateFormat sdf4File = new SimpleDateFormat("ddMMyyHHmmss");

	private static final SimpleDateFormat sdfTime = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	private static final SimpleDateFormat sdfTimeForNV = new SimpleDateFormat("HH:mm dd/MM/yyyy");

	private static final NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMANY);

	public static final String date_separator = "/";

	public static String objectDate2Str(Object date) {
		try {
			String result = date2str((Date) date);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			return "";
		}
	}

	// Ham lam tron so : int precision do chinh xac
	public static double round(double val, int precision) {
		double powprecision = Math.pow(10, precision);
		return Math.floor((val * powprecision) + 0.5) / powprecision;
	}

	// Kiem tra 1 chuoi la null or rong
	public static boolean isNull(String str) {
		return str == null || str.equals("") || str.trim().length() == 0;
	}

	// Kiem tra 1 collection
	public static boolean isNull(Collection c) {
		return c == null || c.isEmpty();
	}

	public static java.sql.Date str2SQLdate(String str) throws Exception {
		if (isNull(str))
			return null;
		return new java.sql.Date(str2date(str).getTime());
	}

	public static String SQLdate2str(java.sql.Date d) {
		return date2str((Date) d);
	}

	public static Date str2date(String str) throws Exception {
		if (isNull(str))
			return null;
		Date result = null;
		try {
			result = sdf.parse(str);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return result;
	}

	public static Date str2dateForNV(String str) throws Exception {
		if (isNull(str))
			return null;
		Date result = null;
		try {
			result = sdfTimeForNV.parse(str);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return result;
	}

	public static Date str2date(String date, String time) throws Exception {
		if (isNull(date) || isNull(time))
			return null;
		date.trim();
		time.trim();
		String str = date + " " + time;
		Date result = null;
		try {
			result = sdfTime.parse(str);
		} catch (Exception e) {
			throw new Exception(e.toString());
		}
		return result;
	}

	public static String date2str(Date d) {
		if (d == null)
			return null;
		return sdf.format(d);
	}

	public static String date2str4File(Date d) {
		TimeZone t = TimeZone.getTimeZone("Asia/Saigon");
		sdf4File.setTimeZone(t);
		return sdf4File.format(d);
	}

	public static String date2str4Key(Date d) {
		TimeZone t = TimeZone.getTimeZone("Asia/Saigon");
		sdf4Key.setTimeZone(t);
		return sdf4Key.format(d);
	}

	public static String date2strDateTime(Date d) {
		if (d == null)
			return null;
		return sdfTime.format(d);
	}

	public static String date2strDateTimeForNV(Date d) {
		if (d == null)
			return null;
		TimeZone t = TimeZone.getTimeZone("Asia/Saigon");
		sdfTimeForNV.setTimeZone(t);
		return sdfTimeForNV.format(d);
	}

	public static Timestamp str2time(String str) throws Exception {
		if (isNull(str))
			return null;
		Timestamp result = null;
		try {
			result = new Timestamp(sdf.parse(str).getTime());
		} catch (Exception e) {
			throw new Exception(e.toString());
		}
		return result;
	}

	public static String time2str(Timestamp t) {
		if (t == null)
			return null;
		return sdf.format(t);
	}

	public static String gc2str(GregorianCalendar gc) {
		if (gc == null)
			return null;
		return sdf.format(gc.getTime());
	}

	public static String gc2strDateTime(GregorianCalendar gc) {
		if (gc == null)
			return null;
		return sdfTime.format(gc.getTime());
	}

	public static GregorianCalendar str2gc(String str) throws Exception {
		if (isNull(str))
			return null;
		GregorianCalendar result = new GregorianCalendar();
		try {
			result.setTime(str2date(str));
		} catch (Exception e) {
			throw new Exception(e.toString());
		}
		return result;
	}

	public static GregorianCalendar str2gc(String date, String time) throws Exception {
		if (isNull(date) || isNull(time))
			return null;
		GregorianCalendar result = new GregorianCalendar();
		try {
			result.setTime(str2date(date, time));
		} catch (Exception e) {
			throw new Exception(e.toString());
		}
		return result;
	}

	public static GregorianCalendar time2gc(Timestamp t) {
		if (t == null)
			return null;
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(t);
		return gc;
	}

	public static Timestamp gc2time(GregorianCalendar gc) {
		if (gc == null)
			return null;
		return new Timestamp(gc.getTime().getTime());
	}

	public static String num2str(double number) {
		return nf.format(number);
	}

	public static String num2str(long number) {
		return nf.format(number);
	}

	public static Number str2num(String str) throws Exception {
		if (isNull(str))
			return null;
		Number result = null;
		try {
			result = nf.parse(str);
		} catch (Exception e) {
			throw new Exception(e.toString());
		}
		return result;
	}

	public static String[] split(String str, String symbol) {
		StringTokenizer a = new StringTokenizer(str, symbol);
		String[] arr = new String[a.countTokens()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = a.nextToken();
		}
		return arr;
	}

	public static String d2n(String str) {
		if (isNull(str))
			return null;
		String[] arr = split(str, date_separator);
		String strD = arr[0], strM = arr[1], strY = arr[2];
		if (strD.length() == 1)
			strD = "0" + strD;
		if (strM.length() == 1)
			strM = "0" + strM;
		if (strY.length() == 2) {
			if (Integer.parseInt(strY) > 30)
				strY = "19" + strY;
			else
				strY = "20" + strY;
		}
		return strY + strM + strD;
	}

	public static String s2n(String str) throws Exception {
		if (isNull(str))
			return null;
		String result = null;
		try {
			double d = str2num(str).doubleValue();
			result = new java.math.BigDecimal(String.valueOf(d)).toString();
		} catch (Exception e) {
			throw new Exception(e.toString());
		}
		return result;
	}

	public static java.sql.Date gc2SQLdate(GregorianCalendar gc) {
		if (gc == null)
			return null;
		else {
			java.sql.Date d = new java.sql.Date(gc.getTime().getTime());
			return d;
		}
	}

	public static GregorianCalendar SQLdate2gc(java.sql.Date date) {
		if (date == null)
			return null;
		else {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setGregorianChange(date);
			return gc;
		}
	}

	public static String n2d(String str) throws Exception {
		if (isNull(str))
			return null;
		String result = null;
		try {
			result = str.substring(6) + date_separator + str.substring(4, 6) + date_separator + str.substring(0, 4);
		} catch (Exception e) {
			throw new Exception(e.toString());
		}
		return result;
	}

	public static String n2s(String str) throws Exception {
		if (isNull(str))
			return null;
		String result = null;
		try {
			result = num2str(Double.parseDouble(str));
		} catch (Exception e) {
			throw new Exception(e.toString());
		}
		return result;
	}

	public static int gc_compare_gc(GregorianCalendar g1, GregorianCalendar g2) throws Exception {
		if (g1 == null || g2 == null)
			throw new Exception("Parameter is null");
		return (g2.getTime().compareTo(g1.getTime()));
	}

	public static int gc_compare_time(GregorianCalendar g1, Timestamp time) throws Exception {
		if (g1 == null || time == null)
			throw new Exception("Parameter is null");
		return gc_compare_gc(g1, time2gc(time));
	}

	private static boolean isNumber(String strNum) {
		String num = "-,0,1,2,3,4,5,6,7,8,9,., ";
		char[] arrStr = strNum.toCharArray();
		for (int i = 0; i < arrStr.length; i++) {
			char c = arrStr[i];
			if (num.indexOf(c) < 0)
				return false;
		}
		return true;
	}

	/**
	 * @param informations
	 * @return
	 */
	public static boolean isNull(Object[] informations) {
		return informations == null || informations.length <= 0;
	}

	public static void addDate(Date root, int soNgay) {
		System.out.println("Date is : " + sdf.format(root));
		GregorianCalendar c1 = new GregorianCalendar();
		c1.setTime(root);
		c1.add(GregorianCalendar.DAY_OF_MONTH, soNgay);
		System.out.println("Date after " + soNgay + " is : " + sdf.format(c1.getTime()));
	}

	public static void subDate(Date root, int soNgay) {
		System.out.println("Now is : " + sdf.format(root));
		GregorianCalendar c1 = new GregorianCalendar();
		c1.setTime(root);
		c1.roll(GregorianCalendar.DAY_OF_MONTH, soNgay);
		System.out.println("Date before " + soNgay + " is : " + sdf.format(c1.getTime()));
	}

	public static String getDateForPrintFromDateTime(String date) {
		if (Formater.isNull(date))
			return "";
		String[] dt = date.split(" ");
		String[] sd = dt[1].split(date_separator);
		String ret = "ng\u00E0y " + sd[0] + " th\u00E1ng " + sd[1] + " n\u0103m " + sd[2];
		return ret;
	}

	// Lay formate date theo dinh dang: Ngay dd thang mm nam yyyy
	public static String getDateForPrint(String date) {
		if (Formater.isNull(date))
			return "ng\u00E0y.....th\u00E1ng.....n\u0103m.....";
		String[] sd = date.split(date_separator);
		String ret = "ng\u00E0y " + sd[0] + " th\u00E1ng " + sd[1] + " n\u0103m " + sd[2];
		return ret;
	}
	//Viet hoa chu "Ngay" dau dong
	public static String dateTimeToDate(String dateTime) {
		try {
			String[] dt = dateTime.split(" ");
			return dt[1];
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

	public static String getStringForPrint(String str) {
		if (Formater.isNull(str))
			return "...";
		return str;
	}

	public static String getDateForPrintUpper(String date) {
		if (Formater.isNull(date))
			return "";
		String[] sd = date.split(date_separator);
		String ret = "Ng\u00E0y " + sd[0] + " th\u00E1ng " + sd[1] + " n\u0103m " + sd[2];
		return ret;
	}

	public static String getDateTimeForPrint(String dateTime) {
		if (Formater.isNull(dateTime))
			return "";
		String ret = "";
		try {
			ret = dateTime.substring(0, 2) + " gi\u1EDD " + dateTime.substring(3, 5) + " ph\u00FAt ng\u00E0y " + dateTime.substring(6, 8) + " th\u00E1ng " + dateTime.substring(9, 11) + " n\u0103m "
					+ dateTime.substring(dateTime.length() - 4, dateTime.length());
		} catch (Exception e) {
			System.out.println("Date Error: " + dateTime);
			e.printStackTrace();
		}
		return ret;
	}

	public static String getFromDouble(Double v) {
		if (v != null) {
			BigDecimal big = new BigDecimal(v.toString());
			return big.toString();
		} else
			return "";
	}

	public static double toDouble(String v) {
		if (v != null)
			try {
				return Double.parseDouble(v.replaceAll(" ", ""));
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		else
			return 0;
	}

	public static Long toLong(String v) {
		if (!Formater.isNull(v))
			try {
				return new Long(v.replaceAll(" ", ""));
			} catch (Exception e) {
				e.printStackTrace();
				return new Long("0");
			}
		else
			return new Long("0");
	}

	public static String number2StringIgnorePre(double num) throws Exception {
		int x = (int) Math.pow(10, Integer.parseInt("0"));
		int intSo = 0;
		int cents = 0;
		String formatStr = "";
		intSo = (int) Math.floor(num * x + 0.50000000001);
		cents = intSo % x;
		if (cents < 0)
			cents = cents * -1;

		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setGroupingSeparator(' ');
		dfs.setDecimalSeparator(',');

		DecimalFormat df = new DecimalFormat();
		df.setDecimalFormatSymbols(dfs);
		df.setMaximumFractionDigits(0);
		if (cents != 0) {
			df.setMinimumFractionDigits(0);
		}
		formatStr = df.format(num);
		return formatStr;
	}
}