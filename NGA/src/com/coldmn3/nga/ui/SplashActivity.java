/*
 * 文件名：SplashActivity.java
 * 版权：(C)版权所有2013-2013宇龄信息科技(无锡)有限公司
 * 描述：
 * 修改人：wuhai
 * 修改时间：2013-6-29 上午11:33:22
 */
package com.coldmn3.nga.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * 启动页
 * 
 * @author wuhai
 * @version 1.0
 * @date 2013-6-29 上午11:33:22
 */
public class SplashActivity extends Activity {

	private static final long SPLASH_DELAY = 100L;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent intent = new Intent(SplashActivity.this, MainActivity.class);
				SplashActivity.this.startActivity(intent);
				SplashActivity.this.finish();
			}
		}, SPLASH_DELAY);
	}

}
