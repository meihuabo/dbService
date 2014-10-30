package com.mhb.services.util;

import java.util.regex.Pattern;

public class SqlUtil {
	/**
	 * 判断表的名字是否合法，只能包含下划线和字母数字，防止sql注入
	 * @param table	表的名字
	 * @return	true:合法  false:不合法
	 */
	public static boolean isTableName(String table){
		Pattern p = Pattern.compile("[a-zA-Z_]*");
		return p.matcher(table).matches();
	}
}
