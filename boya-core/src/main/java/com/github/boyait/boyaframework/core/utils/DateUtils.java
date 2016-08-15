package com.github.boyait.boyaframework.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils {
	private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
	private static SimpleDateFormat sdf;
	/**
	 * 短时间字符串格式
	 */
	public static String SHORT_PATTERN = "yyyy-MM-dd";
	/**
	 * 默认时间字符串格式
	 */
	public static String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 天的单位
	 */
	public static final String DAY_UNIT = "d";
	/**
	 * 小时的单位
	 */
	public static final String HOUR_UNIT = "h";
	/**
	 * 分钟的单位
	 */
	public static final String MINUTE_UNIT = "m";

	/**
	 * 以默认模式格式化时间字符串
	 * 
	 * @param timeStr 时间字符串
	 * @return 格式化后的时间类
	 */
	public static Date parse(String timeStr) {
		return parse(timeStr, DEFAULT_PATTERN);
	}

	/**
	 * 格式化时间字符串返回Date
	 * 
	 * @param timeStr 时间字符串
	 * @param pattern 字符串模式 例如:yyyy-MM-dd
	 * @return 格式化后的时间类
	 */
	public static Date parse(String timeStr, String pattern) {
		Date result = null;
		sdf = new SimpleDateFormat(pattern);
		try {
			result = sdf.parse(timeStr);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
		return result;
	}

	/**
	 * 格式化一个时间类为字符串
	 * 
	 * @param date 时间
	 * @param pattern 模式
	 * @return 格式化后的字符串
	 */
	public static String format(Date date, String pattern) {
		sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	/**
	 * 以字符串格式获取当前时间
	 * 
	 * @return 当前时间的字符串
	 */
	public static String getNow() {
		return getNow(DEFAULT_PATTERN);
	}

	/**
	 * 以特定的模式获取当前时间的字符串
	 * 
	 * @param pattern 模式
	 * @return 当前时间的字符串
	 */
	public static String getNow(String pattern) {
		return format(new Date(), pattern);
	}
	
	/**
	 * 以字符串格式获取当天时间
	 * 
	 * @return 当天时间的字符串
	 */
	public static String getToday() {
		return getNow(SHORT_PATTERN);
	}

	/**
	 * 以特定的模式获取当天时间的字符串
	 * 
	 * @param pattern 模式
	 * @return 当天时间的字符串
	 */
	public static String getToday(String pattern) {
		return format(new Date(), pattern);
	}

	/**
	 * 以默认模式格式化一个时间类为字符串
	 * 
	 * @param date 时间
	 * @return 格式化后的字符串
	 */
	public static String format(Date date) {
		return format(date, DEFAULT_PATTERN);
	}
}
