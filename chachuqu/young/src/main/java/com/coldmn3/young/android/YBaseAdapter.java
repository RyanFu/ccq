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
package com.coldmn3.young.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

/**
 * 基础adapter
 *
 * @version 1.0
 * @author： session
 * @date：2013-9-16 下午5:44
 */
public abstract class YBaseAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater mInflater;

    public YBaseAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

}
