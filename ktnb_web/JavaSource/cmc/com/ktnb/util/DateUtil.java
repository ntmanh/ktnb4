package cmc.com.ktnb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String getCurrentMonth(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		return sdf.format(new Date());
	}
	public static String getCurrentYear(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(new Date());
	}
	public static Date getLastDayOfMonth(int year,int month) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		String dateInString = "15-"+month+"-"+year;
		Date date = sdf.parse(dateInString);
		return date;
	}
}
