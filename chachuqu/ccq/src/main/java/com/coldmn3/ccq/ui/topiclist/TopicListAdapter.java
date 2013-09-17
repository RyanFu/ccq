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
package com.coldmn3.ccq.ui.topiclist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.coldmn3.young.android.YBaseAdapter;

import java.util.List;

/**
 * 一句话功能简述<br>
 * 功能详细描述
 *
 * @version 1.0
 * @author： session
 * @date：2013-9-16 下午5:27
 */
public class TopicListAdapter extends YBaseAdapter {

    private List<TopicListEntity> mData;

    public final class ViewHolder {
        public TextView subject;
    }

    public TopicListAdapter(Context context, List<TopicListEntity> data) {
        super(context);
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return convertView;
    }
}
