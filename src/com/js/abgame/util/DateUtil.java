package com.js.abgame.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/**
 * 日期类
 * @author Abeni
 *
 */
public class DateUtil {
	/**
	 * 日期和时间的方法
	 */
	public static void getDate() {
		//创建日期类对象 
		Calendar calendar=Calendar.getInstance();
		//获取年
		int year=calendar.get(Calendar.YEAR);
		//获取月
		int month=calendar.get(Calendar.MONTH);
		//获取日
		int day=calendar.get(Calendar.DATE);
		//获取小时
		int hour=calendar.get(Calendar.HOUR_OF_DAY);
		//获取分钟
		int min=calendar.get(Calendar.MINUTE);
		//获取秒
		int sec=calendar.get(Calendar.SECOND);
	}
	/**
	 * 时间方法
	 */
	public static void getTime() {
		//创建时间类对象
		Date date=new Date();
		//直接输出时间
		System.out.println(date);
	}
	/**
	 * 获取当前时间 转换成字符串类型
	 * @param d 时间类型的数据
	 * @return
	 */
	public static String getDateToString(Date d) {
		//创建日期格式化对象  传入具体的格式
		DateFormat df=new SimpleDateFormat("yyy 年 MM 月 dd 日 HH:mm:ss");
		//格式化时间类数据
		String time=df.format(d);
		return time;
	}
	/**
	 * 把字符串类型时间转成格式化时间
	 * @param s	字符串类型时间
	 * @return 返回时间类型
	 * @throws ParseException 有可能出现类型不匹配异常
	 *
	 */
	public static Date getStringToDate(String s) throws ParseException {
		//创建日期格式化对象  传入具体的格式
		DateFormat df=new SimpleDateFormat("yyy 年 MM 月 dd 日 HH:mm:ss");
		//将字符串类型转换成 时间类型
		Date tDate=df.parse(s);
		return tDate;
	}
	public static void main(String[] args) {
		//创建时间对象
		Date date=new Date();
		String sdate=getDateToString(date);
		System.out.println(sdate);
		
		try {
			Date date2=getStringToDate("2019年2月20日 12:12:20");
			System.out.println(date2);
		} catch (ParseException e) {
			System.out.println("失败");
		}
		
	}
}
