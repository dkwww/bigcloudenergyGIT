package com.yidu.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 项目名：Store
 * 文件名：GetTime.java
 * @author ZhouJun
 * @date： 2018年7月7日下午2:10:58
 * 类说明: 获得本机时间工具类
 */
public class TimeUtil {
	/**
	 * 获得 util Date
	 * @return Date 当前时间
	 */
	public static Date getDateTime(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);
		Date time = null;
		try {
			time = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}
	/**
	 * 获得 sql精确时间 Timestamp
	 * @return Timestamp 当前时间
	 */
	public static Timestamp getTimestamp(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);
		Timestamp time = null;
		try {
			time = getSqlTimestamp(sdf.parse(str));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}
	
	/**
	 * 获得 sql精确时间 Timestamp
	 * @return Timestamp 当前时间
	 */
	public static String getStrDate(Timestamp time){
		if(time==null) return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(time.getTime());
		
		return sdf.format(date);
	}
	
	/**
	 * 获得 sql精确时间 Timestamp
	 * @return Timestamp 当前时间
	 */
	public static String getStrDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return sdf.format(date);
	}
	
	/**
	 * 将 util.date 转换为sql.date
	 * 
	 * @param date
	 * @return
	 */
	public static java.sql.Timestamp getSqlTimestamp(java.util.Date date) {
		java.sql.Timestamp d = new java.sql.Timestamp(date.getTime());
		return d;
	}
	
	/**
	 * 方法说明：日期转字符串格式
	 * @param date
	 * @return
	 * @author ZhouJun
	 * @date：2018年9月14日
	 */
	public static String dateToString(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if(date==null){
			return "" ;
		}else{
			String str = sdf.format(date);
			return str ;
		}
	}
	
	/**
	 * 方法说明：字符串转日期格式
	 * @param date
	 * @return
	 * @throws ParseException
	 * @author ZhouJun
	 * @date：2018年9月14
	 */
	public static Date stringToDate(String date,String format) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if(date==null){
			return null ;
		}else{
			Date str = sdf.parse(date);
			return str ;
		}
	}
	
}
