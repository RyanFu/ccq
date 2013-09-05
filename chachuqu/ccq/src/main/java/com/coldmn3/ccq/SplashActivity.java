package com.coldmn3.ccq;

import android.os.Bundle;
import com.coldmn3.young.android.BaseActivity;
import com.coldmn3.young.utils.ULog;

public class SplashActivity extends BaseActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ULog.error("ULOG!@!@");
    }
}
