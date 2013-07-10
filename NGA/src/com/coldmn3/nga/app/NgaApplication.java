/*
 * 文件名：NgaApplication.java
 * 版权：(C)版权所有2013-2013宇龄信息科技(无锡)有限公司
 * 描述：
 * 修改人：wuhai
 * 修改时间：2013-6-29 上午11:46:52
 */
package com.coldmn3.nga.app;

import android.app.Application;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author wuhai
 * @version 1.0
 * @date 2013-6-29 上午11:46:52
 */
public class NgaApplication extends Application {

	public static String PACKAGENAME = "";
	
	public static NgaApplication application;

	@Override
	public void onCreate() {
		super.onCreate();
		application = this;
		PACKAGENAME = getPackageName();
	}

}
