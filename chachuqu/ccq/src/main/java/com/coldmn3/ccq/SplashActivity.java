package com.coldmn3.ccq;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import com.coldmn3.young.utils.ULog;
import com.umeng.update.UmengUpdateAgent;
import com.umeng.update.UmengUpdateListener;
import com.umeng.update.UpdateResponse;

public class SplashActivity extends CCQBaseActivity {

    RefreshListView listView;
    private String[] adapterData;
    private ImageView refresh;
    AnimationDrawable anim;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        refresh = (ImageView) findViewById(R.id.imageView);
        refresh.setBackgroundResource(R.drawable.refresh_list_header_progress);
        anim = (AnimationDrawable) refresh.getBackground();
        refresh.post(new Runnable() {
            @Override
            public void run() {
                anim.start();
            }
        });

        ULog.error("ULOG!@!@");
        adapterData = new String[] { "Afghanistan", "Albania", "Algeria",
                "American Samoa", "Andorra", "Angola", "Anguilla",
                "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia",
                "Aruba", "Australia", "Austria", "Azerbaijan", "Bahrain",
                "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize",
                "Benin", "Bermuda", "Bhutan", "Bolivia",
                "Bosnia and Herzegovina", "Botswana", "Bouvet Island" };

        listView = (RefreshListView) findViewById(R.id.infomation_tab_list);
        listView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, adapterData));
    }

    public void checkNew(View view) {
        // 如果想程序启动时自动检查是否需要更新， 把下面两行代码加在Activity 的onCreate()函数里。
        com.umeng.common.Log.LOG = true;

        UmengUpdateAgent.setUpdateOnlyWifi(false); // 目前我们默认在Wi-Fi接入情况下才进行自动提醒。如需要在其他网络环境下进行更新自动提醒，则请添加该行代码
        UmengUpdateAgent.setUpdateAutoPopup(false);
        UmengUpdateAgent.setUpdateListener(updateListener);

        UmengUpdateAgent.update(this);
    }

    UmengUpdateListener updateListener = new UmengUpdateListener() {
        @Override
        public void onUpdateReturned(int updateStatus,
                                     UpdateResponse updateInfo) {
            switch (updateStatus) {
                case 0: // has update
                    Log.i("--->", "callback result");
                    UmengUpdateAgent.showUpdateDialog(SplashActivity.this, updateInfo);
                    break;
                case 1: // has no update
                    Toast.makeText(SplashActivity.this, "没有更新", Toast.LENGTH_SHORT)
                            .show();
                    break;
                case 2: // none wifi
                    Toast.makeText(SplashActivity.this, "没有wifi连接， 只在wifi下更新", Toast.LENGTH_SHORT)
                            .show();
                    break;
                case 3: // time out
                    Toast.makeText(SplashActivity.this, "超时", Toast.LENGTH_SHORT)
                            .show();
                    break;
                case 4: // is updating
					/*Toast.makeText(mContext, "正在下载更新...", Toast.LENGTH_SHORT)
							.show();*/
                    break;
            }

        }
    };
}
