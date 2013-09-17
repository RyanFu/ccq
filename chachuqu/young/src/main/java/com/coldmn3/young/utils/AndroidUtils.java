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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.coldmn3.young.R;

/**
 * Toast工具类
 *
 * @version 1.0
 * @author： session
 * @date：2013-9-17 下午3:03
 */
public class AndroidUtils {

    public static LayoutInflater getLayoutInflater(Context context) {
        LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflate;
    }

    /**
     * 使用自定义外观的Toast
     *
     * @param context
     * @param text
     */
    public static void Toast(Context context, String text) {
        Toast result = new Toast(context);
        View v = getLayoutInflater(context).inflate(R.layout.ccq_toast, null);
        TextView tv = (TextView) v.findViewById(R.id.toast_text);
        tv.setText(text);
        result.setDuration(Toast.LENGTH_SHORT);
        result.setView(v);
        result.show();
    }

    public static void Toast(Context context, int id) {
        Toast(context, context.getString(id));
    }
}
