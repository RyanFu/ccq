/*
 * 文件名：BaseActivity.java
 * 版权：(C)版权所有2013-2013宇龄信息科技(无锡)有限公司
 * 描述：
 * 修改人：wuhai
 * 修改时间：2013-6-29 上午11:33:51
 */
package com.coldmn3.nga.ui;

import android.app.Activity;
import android.os.Bundle;

import com.coldmn3.nga.app.AppManager;
import com.umeng.analytics.MobclickAgent;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author wuhai
 * @version 1.0
 * @date 2013-6-29 上午11:33:51
 */
public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// 添加Activity到堆栈
		AppManager.getAppManager().addActivity(this);
	}

	@Override
	protected void onResume() {
		super.onResume();

		MobclickAgent.onResume(this);// 友盟
	}

	@Override
	protected void onPause() {
		super.onPause();

		MobclickAgent.onPause(this);// 友盟
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		// 结束Activity&从堆栈中移除
		AppManager.getAppManager().finishActivity(this);
	}

}
