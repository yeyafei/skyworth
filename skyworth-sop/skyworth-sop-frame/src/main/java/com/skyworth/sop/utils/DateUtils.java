package com.skyworth.sop.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/**
 * 日期工具类
 * 
 * @author wupengfei
 *
 */
public abstract class DateUtils {

	public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYYMMDD = "yyyy-MM-dd";
	public static final String HH_MM_SS = "HH:mm:ss";
	public static final String HH_MM = "HH:mm";
	public static final String YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";

	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }
	
	/**
	 * 根据所给的格式返回当前的时间
	 * 
	 * @param type
	 * @return
	 */
	public static String getNow(String type) {
		SimpleDateFormat sf = new SimpleDateFormat(type);
		Date now = new Date(System.currentTimeMillis());
		return sf.format(now);
	}

	/**
	 * 给当前的时间加上天数
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDays(Date date, int day) {
		Calendar calendra = Calendar.getInstance();
		calendra.setTime(date);
		calendra.add(Calendar.DAY_OF_MONTH, day);
		return calendra.getTime();
	}

	/**
	 * 所给的时间加上秒数是否超过当前时间
	 * 
	 * @param date
	 * @param seconds
	 * @return
	 */
	public static boolean isDatePlusSecondsExceedNow(Date date, int seconds) {
		if (date == null) {
			return false;
		}
		long now = System.currentTimeMillis();
		if ((date.getTime() + seconds * 1000) > now) {
			return true;
		}
		return false;
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }
	/**
	 * 获取当前日期的天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDays(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 获取指定日期是星期几
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekOfDate(Date date) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (week < 0) {
			week = 0;
		}
		return weekDays[week];
	}

	/**
	 * 返回指定日期的毫秒数
	 * 
	 * @param date
	 * @param patternStringTools.java
	 * @return
	 */
	public static long getMilliseconds(String date, String pattern) {
		if (StringUtil.isEmpty(date) || StringUtil.isEmpty(pattern)) {
			return 0;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(date).getTime();
		} catch (ParseException e) {
			return 0;
		}
	}

	/**
	 * 获取系统时间前n小时前的时间，支持跨天
	 * @param fmt
	 * @param n
	 * @return
	 * @author
	 */
	public static String getSysNextHourTime(String fmt, int n) {
		SimpleDateFormat fd = new SimpleDateFormat(fmt);
   	  	Calendar calendar = Calendar.getInstance();//此时打印它获取的是系统当前时间
   	  	calendar.add(Calendar.HOUR, -n);//当前系统时间的  前一小时
   	  	String timehourago = fd.format(calendar.getTime());
		return timehourago;
	}
	
	public static String getSysNextMinuteTime(String fmt, int n) {
		SimpleDateFormat fd = new SimpleDateFormat(fmt);
   	  	Calendar calendar = Calendar.getInstance();//此时打印它获取的是系统当前时间
   	  	calendar.add(Calendar.MINUTE, -n);//当前系统时间的  前一小时
   	  	String timehourago = fd.format(calendar.getTime());
		return timehourago;
	}
	
	public static String dateToLongString(Date value) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String longDate = formatter.format(value);
		return longDate;
	}
	
	public static Date stringToLongDate(String value) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = formatter.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	


}
