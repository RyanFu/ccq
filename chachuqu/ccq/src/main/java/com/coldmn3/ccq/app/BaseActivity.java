package com.coldmn3.ccq.app;

import android.os.Bundle;
import com.coldmn3.young.dagger.DaggerFragmentActivity;
import com.coldmn3.young.utils.AppManager;

/**
 * 一句话功能简述<br>
 * 功能详细描述
 *
 * @version 1.0
 * @author： session
 * @date：2013-8-30 下午5:50
 */
public class BaseActivity extends DaggerFragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 结束Activity&从堆栈中移除
        AppManager.getAppManager().finishActivity(this);
    }
}
