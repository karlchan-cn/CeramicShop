package cn.com.grocery.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author lihongkun@oppo.com
 */
public class DateUtils {
	
	/**
	 * 日期字符串转换为日期类型
	 * 
	 * @param str 日期字符串
	 * @param pattern 日期字符串格式
	 * @return 转换后日期
	 * @throws Exception
	 */
	public static Date str2Date(String str,String pattern) throws Exception{
		SimpleDateFormat formator = new SimpleDateFormat(pattern);
		return formator.parse(str);
	}
	
	/**
	 * 日期字符串转换为日期类型 , 且为当天最后时分秒
	 * @param str
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	public static Date str2DateEnd(String str,String pattern) throws Exception{
		SimpleDateFormat formator = new SimpleDateFormat(pattern);
		Date date = formator.parse(str);
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(date);
		
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}
	
	/**
	 * 日期格式化为字符串
	 * 
	 * @param date 日期
	 * @param pattern 日期字符串格式
	 * @return 字符串
	 * @throws Exception
	 */
	public static String date2Str(Date date,String pattern)throws Exception{
		SimpleDateFormat formator = new SimpleDateFormat(pattern);
		return formator.format(date);
	}
	
	/**
	 * 时间区间
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long duration(Date startDate,Date endDate){
		long diff = endDate.getTime()-startDate.getTime();
		return diff/1000;
	}
	
	/**
	 * @return unix 时间 (单位:秒)
	 */
	public static int unixTime(){
		BigDecimal num = new BigDecimal(System.currentTimeMillis()/1000);
		return num.intValue();
	}
	
	public static int unixTime(Date date){
		BigDecimal num = new BigDecimal(date.getTime()/1000);
		return num.intValue();
	}
	
	/**
	 * unix 时间转换成 Date
	 * @param unixtime (单位:秒)
	 * @return
	 */
	public static Date unixTimeToDate(int unixtime){
		return new Date((long)unixtime*1000);
	}
	
	/**
	 * unix 时间转换成 Date
	 * @param unixtime (单位:秒)
	 * @return
	 */
	public static Date unixTimeToDate(long unixtime){
		return new Date((long)unixtime*1000);
	}
	
	public static int dateInt(Date date){
		try{
			return Integer.parseInt(date2Str(date, "yyyyMMdd"));
		}
		catch(Exception ex){
			return -1;
		}
	}
}
