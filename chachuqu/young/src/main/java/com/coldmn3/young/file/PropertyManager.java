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
package com.coldmn3.young.file;

import android.content.Context;
import com.coldmn3.young.R;
import com.coldmn3.young.utils.ULog;
import com.coldmn3.young.utils.Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 系统配置参数管理类<br>
 * 直接调用get方法，获取raw/system.properties中对应的value
 *
 * @version 1.0
 * @author: session
 * @date:2013-9-4 下午4:03
 */
public class PropertyManager {

    private static Properties properties;

    private static PropertyManager instance = null;

    private PropertyManager(Context context) {
        InputStream is = context.getResources().openRawResource(R.raw.system);
        properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            ULog.error(e.getMessage());
        } finally {
            Util.closeStream(is);
        }
    }

    /**
     * 实例化<br>
     * 该方法在系统启动的时候调用
     *
     * @param context context
     * @return
     */
    public static PropertyManager getInstance(Context context) {
        if (instance == null) {
            instance = new PropertyManager(context);
        }
        return instance;
    }

    /**
     * 取值<br>
     * 输入的参数为raw/system.properties中的key
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * 取值<br>
     * 输入的参数为raw/system.properties中的key
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        return properties.getProperty(key, "");
    }
}
