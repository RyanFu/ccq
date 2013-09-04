/*
    CCQ Android Client
    Copyright (c) 2013 Wu Hai <coldmn3@gmail.com>
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package com.coldmn3.young.utils;

import android.app.Application;
import android.provider.ContactsContract;

/**
 * Application实现类<br>
 * Application实现类,在应用程序整个生命周期中，该类对象会一直存在，可以在该类中共享一些数据
 *
 * @version 1.0
 * @author： session
 * @date：2013-9-4 下午3:35
 */
public class BaseApplication extends Application {

    public static String PACKAGE_NAME;

    @Override
    public void onCreate() {

        PACKAGE_NAME = this.getPackageName();
        initSystem();
        super.onCreate();
    }

    /**
     * 系统参数初始化<br>
     * 配置参数的初始化
     */
    private void initSystem() {
        PropertyManager.getInstance(getApplicationContext());
    }
}
