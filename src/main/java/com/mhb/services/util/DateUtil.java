package com.mhb.services.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private final static DateFormat YYYY_MM_DD =new SimpleDateFormat("YYYY-MM-dd");
	//private final static DateFormat YYYY_MM_DD_HH_MM_SS =new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
	
	/**
	 * @author 梅华波 2014年10月29日 上午1:23:31
	 * @param timestamp	long类型的日期时间戳
	 * @return	2014-10-29这种歌是日期的字符串
	 */
	public static String longToYYYYMMDDString(long timestamp){
		return YYYY_MM_DD.format(new Date(timestamp));
	}
	
	
}
