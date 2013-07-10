/*
 * 文件名：StringUtils.java
 * 版权：(C)版权所有2013-2013宇龄信息科技(无锡)有限公司
 * 描述：
 * 修改人：wuhai
 * 修改时间：2013-7-10 下午5:42:27
 */
package com.coldmn3.nga.utils;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author wuhai
 * @version 1.0
 * @date 2013-7-10 下午5:42:27
 */
public class StringUtils {

	public static boolean isNotEmpty(CharSequence str) {
		return !isEmpty(str);
	}

	public static boolean isEmpty(CharSequence str) {
		return str == null || str.length() == 0;
	}
}
