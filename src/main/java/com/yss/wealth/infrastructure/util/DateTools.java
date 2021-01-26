package com.yss.wealth.infrastructure.util;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


/**
 * 日期相关工具类
 * 
 * @see
 * @author wang xiaoying
 * @version 1.0,2011-7-12
 * @since 1.0,2011-7-12
 */
@Slf4j
public class DateTools {

	/**
	 * 30数值变量
	 */
	public static final int COUNT_30 = 30;
	/**f
	 * 99数值变量
	 */
	public static final int COUNT_99 = 99;
	/**
	 * 1000数值变量
	 */
	public static final int COUNT_1000 = 1000;
	/**
	 * 2000数值变量
	 */
	public static final int COUNT_2000 = 2000;
	/**
	 * 1900数值变量
	 */
	public static final int COUNT_1900 = 1900;
	/**
	 * 9999数值变量
	 */
	public static final int COUNT_9999 = 9999;

	/**
	 * yyyy-MM-dd
	 */
	public final static String FORMAT_yyyy_MM_dd = "yyyy-MM-dd";

	/**
	 * yyyyMMdd
	 */
	public final static String FORMAT_yyyyMMdd = "yyyyMMdd";

	/**
	 * 获取指定月份的最后一天
	 * 
	 * @param firstDay 月份的第一天
	 * @return String 月份的最后一天
	 */
	public static final String getLastDayOfMonth(String firstDay) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		String returnStrDate = "";
		try {
			date = dateFormat.parse(firstDay);
			Calendar calender = Calendar.getInstance();
			calender.setTime(date);
			calender.add(Calendar.MONTH, 1);
			calender.add(Calendar.DAY_OF_MONTH, -1);
			returnStrDate = dateFormat.format(calender.getTime());
		} catch (ParseException e) {
			log.error(e.getMessage());
		}
		return returnStrDate;
	}
	
	/**
	 * 根据传入日期获取本周最后一日
	 * 方法详细说明，包括用途、注意事项、举例说明等。
	 * @param current_day
	 * @return
	 * @author  qixu
	 * @date    2018-1-13
	 */
	public static final String getLastDayOfWeek(String current_day) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date date;
	    String returnStrDate = "";
	    try {
		date = dateFormat.parse(current_day);
		Calendar cDate = Calendar.getInstance();  
		cDate.setFirstDayOfWeek(Calendar.MONDAY);  
		cDate.setTime(date);  
		Calendar lastDate = Calendar.getInstance();  
		lastDate.setFirstDayOfWeek(Calendar.MONDAY);  
		lastDate.setTime(date);  
		if(cDate.get(Calendar.WEEK_OF_YEAR)==1&&cDate.get(Calendar.MONTH)==11){  
		    lastDate.set(Calendar.YEAR, cDate.get(Calendar.YEAR)+1);  
		}  
		int typeNum  = cDate.get(Calendar.WEEK_OF_YEAR);  
		lastDate.set(Calendar.WEEK_OF_YEAR, typeNum);  
		lastDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);  
		returnStrDate = new SimpleDateFormat("yyyy-MM-dd").format(lastDate.getTime());
	    } catch (Exception e) {
		log.error(e.getMessage());
	    }
	    return returnStrDate;
	}

	/**
	 * 返回当前是第几季度
	 * 
	 * @return int 当前是第几季度
	 */
	@SuppressWarnings("deprecation")
	public static final int getCurrentSeason() {

		int season = 0;
		Timestamp now = new Timestamp(System.currentTimeMillis());
		int month = now.getMonth();
		if (month >= 1 && month <= Integer.parseInt("3")) {
			season = 1;
		} else if (month >= Integer.parseInt("4") && month <= Integer.parseInt("6")) {
			season = Integer.parseInt("2");
		} else if (month >= Integer.parseInt("7") && month <= Integer.parseInt("9")) {
			season = Integer.parseInt("3");
		} else if (month >= Integer.parseInt("10") && month <= Integer.parseInt("12")) {
			season = Integer.parseInt("4");
		}
		return season;
	}

	/**
	 * 返回当前月是所处季度的第几个月
	 * 
	 * @return int 当前月是所处季度的第几个月
	 */
	public static final int getMonthOfSeason() {

		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH);
		return (month % Integer.parseInt("3") + 1);
	}

	/**
	 * 获取当前日期是本季度的第几个月
	 * 方法详细说明，包括用途、注意事项、举例说明等。
	 * @param date
	 * @return
	 * @author  qixu
	 * @date    2018-12-21
	 */
	public static final int getMonthOfSeason(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		return (month % Integer.parseInt("3") + 1);
	}

	/**
	 * 返回当前年份
	 * 
	 * @return int 年份值
	 */
	public static final int getCurrentYear() {

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return year;
	}

	/**
	 * 返回当前月份
	 * 
	 * @return int 月份值
	 */
	public static final int getCurrentMonth() {

		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		return month;
	}

	/**
	 * 返回当前日
	 * 
	 * @return int 当前日
	 */
	public static final int getCurrentDay() {

		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return day;
	}

	/**
	 * 返回Date型当前时间 2011/7/21 10:20:02
	 * 
	 * @return 当前时间
	 * @throws ParseException 异常
	 */
	public static Date getCurrentTime() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String systemTime = sdf.format(new Date()).toString();
		Date returnDate = null;
		try {
			returnDate = sdf.parse(systemTime);
		} catch (ParseException e) {
			log.error(e.getMessage());
			throw e;
		}
		return returnDate;
	}

	/**
	 * 返回Timestamp类型的当前日期 2006-07-07
	 * 
	 * @return 当前日期
	 */
	public static Timestamp currentTime() {

		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 获取当前日期的字符串 2006-07-07
	 * 
	 * @return String 当前日期
	 */
	public static String getCurrentDate() {

		Timestamp d = currentTime();
		return d.toString().substring(0, Integer.parseInt("10"));
	}

	/**
	 * 根据指定天数返回指定日期之前或之后的日期
	 * 
	 * @param date 指定日期
	 * @param d 增加或减少的天数,取当前日期之后传入正数，取当前日期之前传入负数
	 * @return Date
	 */
	public static Date getCurrentDateBeforOrAfter(Date date, int d) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, d);
		return cal.getTime();
	}

	/**
	 * 返回指定Date类型日期的字符串
	 * 
	 * @param date 日期
	 * @return String
	 */
	public static String getStringDate(Date date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	/**
	 * 返回指定Date类型日期的字符串
	 * 
	 * @param date 日期
	 * @return String
	 */
	public static String getStringDateYYYYMMDD(Date date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return dateFormat.format(date);
	}

	/**
	 * 把给定的日字符串转换成Date类型
	 * 
	 * @param sdate 日期
	 * @return Date
	 * @throws ParseException 异常
	 */
	public static Date getStringToDate(String sdate) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.parse(sdate);
	}

	/**
	 * 
	 * 把给定的日期字符串转换成Date类型
	 * 
	 * @param sdate 日期
	 * @param dateFormatString 日期格式
	 * @return Date
	 * @throws ParseException 异常
	 */
	public static Date getStringToDate(String sdate, String dateFormatString) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
		return dateFormat.parse(sdate);
	}

	/**
	 * 根据给定日期 获取前一天(自然日)
	 * 
	 * @param date 日期
	 * @return Date
	 * @author zhanglq
	 */
	public static Date getPreDate(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}

	/**
	 * 根据指定格式格式化日期
	 * 
	 * @param format 格式
	 * @param date 日期
	 * @return String
	 * @author zhanglq
	 */
	public static String convertDateToString(String format, Date date) {

		String dateStr = null;
		if (date != null) {

			DateFormat df = new SimpleDateFormat(format);
			dateStr = df.format(date);
		}
		return dateStr;
	}

	/**
	 * 获取上个月第一天
	 * 
	 * @param date 日期
	 * @return Date
	 */
	public static Date getFirstDayBM(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -1);// 当前月-1，即上月
		cal.set(Calendar.DATE, 1);// 上个月第一天
		return cal.getTime();
	}

	/**
	 * 获取指定月第一天
	 * 
	 * @param date 日期
	 * @param amount 指定第几个月
	 * @return Date
	 */
	public static Date getFirstDayBM(Date date, int amount) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, amount);// 指定月
		cal.set(Calendar.DATE, 1);// 第一天
		return cal.getTime();
	}

	/**
	 * 获取上个月最后一天
	 * 
	 * @param date 日期
	 * @return Date
	 */
	public static Date getLastDayBM(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);// 当前月第一天
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 获取本月最后一天
	 * 
	 * @param date 日期
	 * @return Date
	 */
	public static Date getLastDayByM(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 获取上个季度的第一天
	 * 
	 * @param date 日期
	 * @return Date
	 */
	public static Date getFirstDayBQ(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		cal.set(Calendar.DATE, 1);// 设置为第一天
		if (month >= 1 && month <= Integer.parseInt("3")) {
			cal.add(Calendar.YEAR, -1);
			cal.set(Calendar.MONTH, Integer.parseInt("9"));
		} else if (month >= Integer.parseInt("4") && month <= Integer.parseInt("6")) {
			cal.set(Calendar.MONTH, 0);
		} else if (month >= Integer.parseInt("7") && month <= Integer.parseInt("9")) {
			cal.set(Calendar.MONTH, Integer.parseInt("3"));
		} else if (month >= Integer.parseInt("10") && month <= Integer.parseInt("12")) {
			cal.set(Calendar.MONTH, Integer.parseInt("6"));
		}
		return cal.getTime();
	}

	/**
	 * 获取上个季度最后一天
	 * 
	 * @param date 日期
	 * @return Date
	 */
	public static Date getLastDayBQ(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		cal.set(Calendar.DATE, 1);// 设置为第一天
		if (month >= 1 && month <= Integer.parseInt("3")) {
			cal.set(Calendar.MONTH, 0);
		} else if (month >= Integer.parseInt("4") && month <= Integer.parseInt("6")) {
			cal.set(Calendar.MONTH, Integer.parseInt("3"));
		} else if (month >= Integer.parseInt("7") && month <= Integer.parseInt("9")) {
			cal.set(Calendar.MONTH, Integer.parseInt("6"));
		} else if (month >= Integer.parseInt("10") && month <= Integer.parseInt("12")) {
			cal.set(Calendar.MONTH, Integer.parseInt("9"));
		}
		cal.add(Calendar.DATE, -1);// 设置为最后一天
		return cal.getTime();
	}

	/**
	 * 获取上半年年第一天
	 * 
	 * @param date 日期
	 * @return Date
	 */
	public static Date getFirstDayBHY(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		cal.set(Calendar.DATE, 1);// 设置为第一天
		if (month <= Integer.parseInt("6")) {
			cal.add(Calendar.YEAR, -1);
			cal.set(Calendar.MONTH, Integer.parseInt("6"));
		} else {
			cal.set(Calendar.MONTH, 0);
		}
		cal.set(Calendar.DATE, 1);
		return cal.getTime();
	}

	/**
	 * 获取上半年年最后一天
	 * 
	 * @param date 日期
	 * @return Date
	 */
	public static Date getLastDayBHY(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		if (month <= Integer.parseInt("6")) {
			cal.add(Calendar.YEAR, -1);
			cal.set(Calendar.MONTH, Integer.parseInt("12"));
		} else {
			cal.set(Calendar.MONTH, Integer.parseInt("6"));
		}
		cal.set(Calendar.DATE, 1);// 设置为第一天
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 获取上一年第一天
	 * 
	 * @param date 日期
	 * @return Date
	 */
	public static Date getFirstDayBY(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, -1);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DATE, 1);
		return cal.getTime();
	}

	/**
	 * 获取上一年最后一天
	 * 
	 * @param date 日期
	 * @return Date
	 */
	public static Date getLastDayBY(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.MONTH, 0);
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 获取当前年最后一天
	 * 
	 * @param date 日期
	 * @return Date
	 */
	public static Date getLastDay(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 1);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.MONTH, 0);
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}
	
	
	/**
	 * 类似vb的CDate函数，自动分析sDate，如格式正常，返回日期，否则报错。
	 * 注意这里只能处理单纯日期，不处理时间，年份正常范围在0-99和1000－9999 仅解析用/-.间隔的日期
	 * 
	 * @param sDate 日期
	 * @return Date
	 * @throws Exception 异常
	 * @author yaojie
	 * @date 2014-11-27
	 */
	public static Date toDate(String sDate) throws Exception {

		int jj;
		char ss;
		char cc;
		String[] sss = { "-", "/", "." };
		String[] result;
		int kk;
		int mm;
		final String emsg = "非法日期格式！";

		GregorianCalendar cl = null;

		Boolean re = false;// 是否有分隔符判断标识
		// 检查分隔符
		for (jj = 0; jj < sss.length; jj++) {
			if (sDate.indexOf(sss[jj]) >= 0) {
				re = true;// 有分隔符时置为true
				break;
			}
		}
		// 添加对没有分隔符日期格式的转换 add by luotaiping 2012-05-08
		if (re) {// 有分隔符的
			if (jj >= sss.length) {
				throw new Exception(emsg);
			}

			ss = sss[jj].charAt(0);
			// 检查数字有效性即除了数字和分隔符，不应该再包括其它字符
			for (int i = 0; i < sDate.length(); i++) {
				cc = sDate.charAt(i);
				if (cc != ss && (cc < '0' || cc > '9')) {
					throw new Exception(emsg);
				}
			}

			// 劈开，获取3个数字
			if(".".equals(sss[jj])){  //年份分隔符为 “.”的情况下 split 需要转义
				result = sDate.split("\\.", -1);
			}else{
				result = sDate.split(sss[jj], -1); // 检查全部，包括空的元素，用0会忽略空
			}
			if (result.length != Integer.parseInt("3")) {
				throw new Exception(emsg);
			}
			jj = Integer.parseInt(result[0]);
			kk = Integer.parseInt(result[1]);
			mm = Integer.parseInt(result[Integer.parseInt("2")]);

			// 判断是否符合一种日期格式
			// 1、y/M/d格式
			if (isValidDate(jj, kk, mm)) {

				cl = new GregorianCalendar(jj < COUNT_30 ? jj + COUNT_2000 : jj <= COUNT_99 ? jj
						+ COUNT_1900 : jj, kk - 1, mm);
			} else {
				if (mm < COUNT_30) {
					mm += COUNT_2000;
				} else if (mm <= COUNT_99) {
					mm += COUNT_1900;
				}
				// 2、M/d/y格式
				if (isValidDate(mm, jj, kk)) {
					cl = new GregorianCalendar(mm, jj - 1, kk);
				}
				// 3、d/M/y格式
				else if (isValidDate(mm, kk, jj)) {
					cl = new GregorianCalendar(mm, kk - 1, jj);
				} else {
					throw new Exception(emsg);
				}
			}
		} else {// 无分隔符的
			if (sDate.length() != 8) {// 无分隔符的日期不等于八位则为非法日期格式
				throw new Exception(emsg);
			}
			// 检查数字有效性即除了数字，不应该再包括其它字符
			for (int i = 0; i < sDate.length(); i++) {
				cc = sDate.charAt(i);
				if (cc < '0' || cc > '9') {
					throw new Exception(emsg);
				}
			}
			jj = Integer.parseInt(sDate.substring(0, 4));
			kk = Integer.parseInt(sDate.substring(4, 6));
			mm = Integer.parseInt(sDate.substring(6, 8));
			if (isValidDate(jj, kk, mm)) {
				cl = new GregorianCalendar(jj < 30 ? jj + 2000 : jj <= 99 ? jj + 1900 : jj,
						kk - 1, mm);
			} else {
				throw new Exception(emsg);
			}

		}
		return cl.getTime();
	}

	/**
	 * 
	 * 判断年月日是否在正常范围 年份正常范围在0-99和1000－9999
	 * 
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @return boolean
	 * @author yaojie
	 * @date 2014-11-27
	 */
	public static boolean isValidDate(int year, int month, int day) {

		boolean result = true;
		GregorianCalendar cl;
		int year1 = year;
		if (year < 0 || year > COUNT_99 && year < COUNT_1000 || year > COUNT_9999) {
			result = false;
		}
		if (year < COUNT_30) {
			year1 += COUNT_2000;
		} else if (year <= COUNT_99) {
			year1 += COUNT_1900;
		}

		if (month < 1 || month > Integer.parseInt("12")) {
			result = false;
		}

		cl = new GregorianCalendar(year1, month - 1, 1); // 参数月份从0开始所以减一
		if (day < cl.getActualMinimum(Calendar.DAY_OF_MONTH)
				|| day > cl.getActualMaximum(Calendar.DAY_OF_MONTH)) {
			result = false;
		}

		return result;
	}

	/**
	 * 功能说明：计算两个日期之间相差的天数
	 * 
	 * @param dDate1 ：较小日期
	 * @param dDate2 ：较大日期
	 * @return 相差天数
	 */
	public static int dateDiff(Date dDate1, Date dDate2) {
		if(dDate1 == null || dDate2 == null) {
			return 0;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_yyyy_MM_dd);
		try {
			dDate1 = sdf.parse(sdf.format(dDate1));
			dDate2 = sdf.parse(sdf.format(dDate2));
		} catch (ParseException e) {
			log.error("计算两日期天数之差出错：", e);
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(dDate1);
		long time1 = cal.getTimeInMillis();
		cal.setTime(dDate2);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(StringUtil.getString(between_days));
	}

	/**
	 * 功能说明：通过只算年份和月份，获取月份差，不计四舍五入
	 * 
	 * @param dDate1 Date：起始月日期
	 * @param dDate2 Date：终止月日期
	 * @return int：dDate2-dDate1的月份差
	 */
	public static int monthDiff(Date dDate1, Date dDate2) {
		int year, month;
		GregorianCalendar cld = new GregorianCalendar();

		cld.setTime(dDate2);
		year = cld.get(Calendar.YEAR);
		month = cld.get(Calendar.MONTH);

		cld.setTime(dDate1);
		year -= cld.get(Calendar.YEAR);
		month -= cld.get(Calendar.MONTH);

		return year * 12 + month;
	}
	
	/**
	 * 计算两个日期之前的年份差
	 * @param date
	 * @param bigDate
	 * @return
	 */
	public static int yearDiff(Date date, Date bigDate){
		GregorianCalendar cld = new GregorianCalendar();
		cld.setTime(bigDate);
		int bigYear = cld.get(Calendar.YEAR);

		cld.setTime(date);
		int year = cld.get(Calendar.YEAR);
		
		return bigYear-year;
	}
	/**
	 * 计算两个日期相差的月份，第三个参数为false的时候，直接算月份查，不含年份差*12
	 * @param date 
	 * @param bigDate
	 * @param containsYear
	 * @return
	 */
	public static int monthDiff(Date date, Date bigDate, boolean containsYear){
		if(containsYear){
			return monthDiff(date,bigDate);
		}
		GregorianCalendar cld = new GregorianCalendar();
		cld.setTime(bigDate);
		int bigMonth = cld.get(Calendar.MONTH);
		cld.setTime(date);
		int month = cld.get(Calendar.MONTH);
		return bigMonth-month;
	}
	
	/**
	 * 计算两个日期相差的天数，第三个参数为false的时候，直接算天数差。
	 * @param date
	 * @param bigDate
	 * @param containsYearAndMonth
	 * @return
	 */
	public static int dateDiff(Date date, Date bigDate, boolean containsYearAndMonth){
		if(containsYearAndMonth){
			return dateDiff(date,bigDate);
		}
		GregorianCalendar cld = new GregorianCalendar();
		cld.setTime(bigDate);
		int bigD = cld.get(Calendar.DATE);
		cld.setTime(date);
		int d = cld.get(Calendar.DATE);
		return bigD-d;
	}
	

	/**
	 * 功能说明：判断闰年
	 * 
	 * @param year 传入得年份
	 * @return 是否为闰年;
	 */
	public static boolean isLeapYear(int year) {
		return new GregorianCalendar().isLeapYear(year);
	}

	/**
	 * 功能说明：返回指定日期区间段呢包含2月29日的个数。
	 * 
	 * @param sDate：起始日期（含）
	 * @param eDate：结束日期（含）
	 * @return 2月29日的个数
	 * @throws Exception
	 */
	public static int getLeapYears(Date sDate, Date eDate) throws Exception {
		int leapDays = 0;
		Date dDate;
		for (int i = getYear(sDate); i <= getYear(eDate); i++) {
			if (isLeapYear(i)) {
				dDate = toDate(i + "-02-29");
				if (dateDiff(dDate, sDate) <= 0 && dateDiff(dDate, eDate) >= 0) {
					leapDays++;
				}
			}
		}
		return leapDays;
	}

	/**
	 * 功能说明：依据类型返回日期中的元素
	 */
	public static int getDateItems(Date dDate, int field) {
		GregorianCalendar cl = new GregorianCalendar();
		cl.setTime(dDate);

		return cl.get(field);
	}

	/**
	 * 功能说明：返回给定日期的具体年份
	 * 
	 * @param dDate 日期
	 * @return
	 */
	public static int getYear(Date dDate) {
		return getDateItems(dDate, Calendar.YEAR);
	}

	/**
	 * 功能说明：返回给定日期的具体月份
	 * 
	 * @param dDate 日期
	 * @return int 月
	 */
	public static int getMonth(Date dDate) {
		return getDateItems(dDate, Calendar.MONTH) + 1;
	}

	/**
	 * 功能说明：返回给定日期为当月中具体日
	 * 
	 * @param dDate 日期
	 * @return int 日
	 */
	public static int getDay(Date dDate) {
		return getDateItems(dDate, Calendar.DAY_OF_MONTH);
	}

	/**
	 * 功能说明：返回给定日期为星期几的标识位
	 * 
	 * @param dDate 日期
	 * @return 星期几标识位 2：星期一 3：星期二 4：星期三 5：星期四 6：星期五 7：星期六 1：星期日
	 */
	public static int getWeekDay(Date dDate) {
		return getDateItems(dDate, Calendar.DAY_OF_WEEK);
	}

	/**
	 * 功能说明：返回给定日期当年的第多少天
	 * 
	 * @param dDate 日期
	 * @return int 比如2017-5-26，返回146
	 * 
	 */
	public static int getYearDays(Date dDate) {
		return getDateItems(dDate, Calendar.DAY_OF_YEAR);
	}
	
	/**
	 * 功能说明：返回给定日期当年天数
	 * @param dDate 日期
	 * @return int 年天数；平年365，闰年366。
	 * 
	 */
	public static int getYearDayss(Date dDate) {
		return isLeapYear(getYear(dDate)) ? 366 : 365;
	}

	/**
	 * 取得指定日期的下一个月
	 * 
	 * @param date 指定日期。
	 * @return 指定日期的下一个月
	 */
	public static Date getNextMonth(Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.MONTH, 1);
		return gc.getTime();
	}

	/**
	 * 取得指定日期的下一日
	 * 
	 * @param date 指定日期。
	 * @return 指定日期的下一日
	 */
	public static Date getNextDate(Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.DATE, 1);
		return gc.getTime();
	}

	/**
	 * 获取月份第一天的日期 例如：date = 2011-1-23 getMonthFirstDay(date) = 2011-1-1
	 */
	public static Date getMonthFirstDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, day);
		return calendar.getTime();
	}

	/**
	 * 获取月份最后一天的日期 例如：date = 2011-1-23 getMonthLastDay(date) = 2011-1-31
	 */
	public static Date getMonthLastDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, day);
		return calendar.getTime();
	}
	/**
	 * 获取当前月份的所在季度的最后一天
	 * @param date 日期
	 * @return 
	 * @throws Exception
	 */
	public static Date getQuarterEndDay(Date date) throws Exception {
		Date quarterDay = null;
		 int m = getMonth(date);
	        int s = (int)Math.ceil( (m - 1)  / 3) + 1;     //季度
	        String year = StringUtil.getString(getYear(date));
	        switch(s){
		        case 1 :
		        	quarterDay= toDate(year+"-03-31");
		          break;
		        case 2 :
		        	quarterDay= toDate(year+"-06-30");
		          break;
		        case 3 :
		        	quarterDay = toDate(year+"-09-30");
		          break;
			    case 4 :
			    	quarterDay= toDate(year+"-12-31");
		          break;
		        default :
		        	quarterDay= toDate(year+"-12-31");
			      break;
	        }
		return quarterDay;
	}
	
	
	/**
	 * 获取当前月份的所在季度的第一天
	 * @param date 日期
	 * @return 
	 * @throws Exception
	 */
	public static Date getQuarterFirstDay(Date date) throws Exception {
		Date quarterDay = null;
		 int m = getMonth(date);
	        int s = (int)Math.ceil( (m - 1)  / 3) + 1;     //季度
	        String year = StringUtil.getString(getYear(date));
	        switch(s){
		        case 1 :
		        	quarterDay= toDate(year+"-01-01");
		          break;
		        case 2 :
		        	quarterDay= toDate(year+"-04-01");
		          break;
		        case 3 :
		        	quarterDay = toDate(year+"-07-01");
		          break;
			    case 4 :
			    	quarterDay= toDate(year+"-10-01");
		          break;
		        default :
		        	quarterDay= toDate(year+"-01-01");
		           break;
	        }
		return quarterDay;
	}

	/**
	 * 获取给定日期的当前年份的第一天
	 * 例如：date = 2011-1-23
	 * getYearFirstDay(date) = 2011-01-01
	 */
	public static Date getYearFirstDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		return calendar.getTime();
	}

	/**
	 * 获取给定日期的当前年份的最后一天
	 * 例如：date = 2011-1-23
	 * getYearLastDay(date) = 2011-12-31
	 */
	public static Date getYearLastDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		return calendar.getTime();
	}

	/**
	 * 功能说明：返回月末日
	 * 
	 * @param year 年
	 * @param month 月
	 * @return 指定年、月的月末日
	 */
	public static int endOfMonth(int year, int month) {
		return new GregorianCalendar(year, month - 1, 1).getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取永久日期(29991231)
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getForeverDate() throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		return sf.parse("29991231");
	}

	/**
	 * 转换为sqldate
	 * 
	 * @param fdate
	 * @return
	 */
	public static java.sql.Date toSqlDate(Date fdate) {
		return new java.sql.Date(fdate.getTime());
	}
	
	/**
	 * 转换为timestamp
	 * 
	 * @param fdate
	 * @return
	 */
	public static Timestamp toTimeStamp(Date fdate) {
		return new Timestamp(fdate.getTime());
	}

	/**
	 * 功能说明：加减年，根据日期向前或向后推算N年
	 * 
	 * @param dDate 日期
	 * @param years 年份数 正整数或负整数
	 * @return 返回增加年份后的日期对象
	 */
	public static final Date addYear(Date dDate, int years) {
		return addDate(dDate, years, Calendar.YEAR);
	}

	/**
	 * 功能说明：加减月，根据日期向前或向后推算N个月
	 * 
	 * @param dDate 日期
	 * @param months 月份数 正整数或负整数
	 * @return 返回增加月份后的日期对象
	 */
	public static final Date addMonth(Date dDate, int months) {
		return addDate(dDate, months, Calendar.MONTH);
	}

	/**
	 * 
	 * 日期加减方法
	 * 
	 * @param dDate
	 * @param days
	 * @return
	 * @author chenwentao
	 * @date 2015-7-11
	 */
	public static final Date addDay(Date dDate, int days) {
		return addDate(dDate, days, Calendar.DAY_OF_MONTH);
	}

	/**
	 * 功能说明：加减日期
	 * 
	 * @param dDate 日期对象
	 * @param  field 指定是年、月、日
	 * @param amount 是数量
	 * @return 修改后的日期
	 */
	public static Date addDate(Date dDate, int amount, int field) {
		GregorianCalendar cl = new GregorianCalendar();
		cl.setTime(dDate);
		cl.add(field, amount);

		return cl.getTime();
	}

	/**
	 * 获取某年某月的最后一天
	 * 
	 * @param year 年
	 * @param month 月
	 * @return
	 */
	public static final String getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		cal.set(Calendar.MONTH, month - 1);
		// 获取某月最大天数
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String lastDayOfMonth = sdf.format(cal.getTime());

		return lastDayOfMonth;
	}

	/**
	 * 获取连天中最大的一天，精确到天
	 * 
	 * @param dDate1 日期1
	 * @param dDate2 日期2
	 * @return
	 * @author linht
	 * @date 2015-11-21
	 */
	public static Date maxDate(Date dDate1, Date dDate2) {
		if (dDate1 == null) {
			return dDate2;
		} else if (dDate2 == null) {
			return dDate1;
		}
		if (DateTools.dateDiff(dDate1, dDate2) > 0) {
			return dDate2;
		} else {
			return dDate1;
		}
	}

	/**
	 * 获取数组中的最大日期，精确到天
	 * 
	 * @param dates 日期数组
	 * @return
	 * @author linht
	 * @date 2015-11-21
	 */
	public static Date maxDate(Date[] dates) {
		if (dates == null || dates.length == 0) {
			return null;
		}
		if (dates.length == 1) {
			return dates[0];
		}
		Date max = dates[0];
		for (int i = 0; i < dates.length - 1; i++) {
			max = maxDate(max, dates[i + 1]);
		}
		return max;
	}
	
	/**
	 * 获取连天中最小的一天，精确到天
	 * 
	 * @param dDate1 日期1
	 * @param dDate2 日期2
	 * @return
	 * @author wuyang
	 * @date 2018-9-28
	 */
	public static Date minDate(Date dDate1, Date dDate2) {
		if (dDate1 == null) {
			return dDate2;
		} else if (dDate2 == null) {
			return dDate1;
		}
		if (DateTools.dateDiff(dDate1, dDate2) < 0) {
			return dDate2;
		} else {
			return dDate1;
		}
	}
	
	/**
	 * 获取数组中的最小日期，精确到天
	 * 
	 * @param dates 日期数组
	 * @return
	 * @author wuyang
	 * @date 2018-9-28
	 */
	public static Date minDate(Date[] dates) {
		if (dates == null || dates.length == 0) {
			return null;
		}
		if (dates.length == 1) {
			return dates[0];
		}
		Date min = dates[0];
		for (int i = 0; i < dates.length - 1; i++) {
			min = minDate(min, dates[i + 1]);
		}
		return min;
	}
	
	/**
	 * 获取当前季度最后一天
	 * 
	 * @param date 日期
	 * @return Date
	 */
	public static Date getLastDayOfSeason(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		cal.set(Calendar.DATE, 1);// 设置为第一天
		if (month >= 1 && month <= Integer.parseInt("3")) {
			cal.set(Calendar.MONTH, 3);
		} else if (month >= Integer.parseInt("4") && month <= Integer.parseInt("6")) {
			cal.set(Calendar.MONTH, Integer.parseInt("6"));
		} else if (month >= Integer.parseInt("7") && month <= Integer.parseInt("9")) {
			cal.set(Calendar.MONTH, Integer.parseInt("9"));
		} else if (month >= Integer.parseInt("10") && month <= Integer.parseInt("12")) {
			cal.set(Calendar.MONTH, Integer.parseInt("0"));
			cal.add(Calendar.YEAR, 1);//按季最后一个季度，最后一天减前一天是差了一年，需要加回来。
		}
		cal.add(Calendar.DATE, -1);// 设置为最后一天
		return cal.getTime();
	}
	
    /**
     * 获取指定日期的指定格式的日期字符串
     * 
     * 方法详细说明，包括用途、注意事项、举例说明等。
     * @param date
     * @param format 例如：yyyy-MM-dd或者yyyy-MM-等形式
     * @return
     * @author  guochaolong
     * @date    2016-3-20
     */
    public static String getYearAndMonth(Date date,String format){
        String result = "";
        SimpleDateFormat formater = new SimpleDateFormat(format);
        result = formater.format(date);
        return result;
    }
	
	/**
	 * 
	 * 返回日期所在季度
	 * 20160802 add by gcl
	 * @return int 当前是第几季度
	 */
	public static final int getSeason(Date date){
        Calendar c = Calendar.getInstance(); 
        c.setTime(date);
        int currentMonth = c.get(Calendar.MONTH) + 1; 
        int currentSeacon =0;
        if (currentMonth >= 1 && currentMonth <= 3)  {
            currentSeacon =1;
        } else if (currentMonth >= 4 && currentMonth <= 6)  {
        	
        	currentSeacon =2; 
        } else if (currentMonth >= 7 && currentMonth <= 9)  {
        	
        	currentSeacon =3; 
        } else if (currentMonth >= 10 && currentMonth <= 12)  {
        	
        	currentSeacon =4;
        }
        return currentSeacon; 
	}
	
	/**
	 * 获取上一年的日期
	 * 20160802 add by gcl
	 * @param date
	 * @return
	 */
	public static Date getLastYear(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, -1);
		return cal.getTime();
	}
	

	/**
	 * 功能说明：返回给定日期当年天数
	 * 
	 * @param year 传入年份
	 * @return int 年天数；平年365，闰年366。
	 * 
	 */
	public static int getCurYearDays(int year) {
		return new GregorianCalendar().isLeapYear(year) ? 366 : 365;
	}
	

/**
 * 
 * @author LiKai
 * @version 1.0.0,2018-4-24
 * @since 1.0.0,2018
 */

	// 日期转化为大小写
	public static String dateToUpper(Date date) {

		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH) + 1;
		int day = ca.get(Calendar.DAY_OF_MONTH);
		return numToUpper(year) + "年" + monthToUppder(month) + "月" + dayToUppder(day) + "日";
	}
	/**
	 * 
	 * @author LiKai
	 * @version 1.0.0,2018-4-24
	 * @since 1.0.0,2018
	 */
	// 将数字转化为大写
	public static String numToUpper(int num) {

		// String u[] = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
		String[] u = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
		char[] str = StringUtil.getString(num).toCharArray();
		StringBuffer rstr = new StringBuffer();
		for (int i = 0; i < str.length; i++) {
		    	rstr.append(u[Integer.parseInt(StringUtil.getString(str[i]))]);
		}
		return rstr.toString();
	}
	/**
	 * 
	 * @author LiKai
	 * @version 1.0.0,2018-4-24
	 * @since 1.0.0,2018
	 */
	// 月转化为大写
	public static String monthToUppder(int month) {

		if (month < 10) {
			return numToUpper(month);
		} else if (month == 10) {
			return "十";
		} else {
			return "十" + numToUpper(month - 10);
		}
	}
	/**
	 * 
	 * @author LiKai
	 * @version 1.0.0,2018-4-24
	 * @since 1.0.0,2018
	 */
	// 日转化为大写
	public static String dayToUppder(int day) {

		if (day < 20) {
			return monthToUppder(day);
		} else {
			char[] str = StringUtil.getString(day).toCharArray();
			if (str[1] == '0') {
				return numToUpper(Integer.parseInt(StringUtil.getString(str[0]))) + "十";
			} else {
				return numToUpper(Integer.parseInt(StringUtil.getString(str[0]))) + "十" + numToUpper(Integer.parseInt(StringUtil.getString(str[1])));
			}
		}
	}
	
	/**
	 * 计算两个日期之间的差值
	 * @param date1 较小日期
	 * @param date2 较大日期
	 * @author lianghongwu
	 */
	public static long[] getDiffTime(Date date1,Date date2){
		long l = date2.getTime() - date1.getTime(); 
		long day = l / (24 * 60 * 60 * 1000); 
		long hour = l / (60 * 60 * 1000) - day * 24; 
		long min = (l / (60 * 1000) - day * 24 * 60 - hour * 60); 
		long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60); 
		long[] arr = new  long[4];
		arr[0]=day;
		arr[1]=hour;
		arr[2]=min;
		arr[3]=s;
		return arr;
	}


	/**
	 * 通过一个原时区日期时间，获取另外一个指定时区的日期时间
	 * 
	 * @param date  原时区 日期
	 * @param format  格式化
	 * @param sourceString 原时区
	 * @param targetString 目标时区
	 * @return 目标时区 时间
	 * 
	 * @author  twh  2018-07-06
	 */
	public static String getDateByTimeZone(Date date , String format , String sourceString , String targetString){
		
		DateFormat formatter = new SimpleDateFormat(format);
		
		//原时区
		TimeZone sourceTimeZone = TimeZone.getTimeZone(sourceString); 
		//目标时区
        TimeZone targetTimeZone = TimeZone.getTimeZone(targetString);
        
        Long targetTime = date.getTime() - sourceTimeZone.getRawOffset() + targetTimeZone.getRawOffset(); 
        
        Date date2 = new Date(targetTime);
        
        return formatter.format(date2);
		
	}

	/**
	 * 获取指定日期的上周一日期
	 * 
	 * @param date
	 * @return
	 * @author naxin
	 * @date 2019-8-6
	 */
	public static Date lastMonday(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int loop = 0;
            while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
                loop++;
                calendar.add(Calendar.DAY_OF_WEEK, -1);
                if(loop>10000){
            		break;
                }
            }
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            int offset = 1 - dayOfWeek;
            calendar.add(Calendar.DATE, offset - 7);
            return calendar.getTime();
    	}
	
	/**
	 * 获取指定日期的上周五日期
	 * 
	 * @param date
	 * @return
	 * @author naxin
	 * @date 2019-8-6
	 */
	public static Date lastFriday(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int loop = 0;
            while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
        	loop++;
                calendar.add(Calendar.DAY_OF_WEEK, -1);
                if(loop>10000){
                    break;
                }
            }
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            int offset = 7 - dayOfWeek;
            calendar.add(Calendar.DATE, offset - 9);
            return calendar.getTime();
	}

}
	