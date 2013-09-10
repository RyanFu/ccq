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
package com.coldmn3.ccq.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import com.coldmn3.ccq.R;

/**
 * Page 底部指示器
 *
 * @version 1.0
 * @author： session
 * @date：2013-9-5 下午4:56
 */
public class CCQPageIndicator extends View implements PageIndicator {

    public CCQPageIndicator(Context context) {
        super(context);
    }

    public CCQPageIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.CCQPageIndicatorStyle);
    }

    public CCQPageIndicator(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (isInEditMode()) return;

        final Resources res = getResources();

    }

    @Override
    public void setViewPager(ViewPager view) {

    }

    @Override
    public void setViewPager(ViewPager view, int initialPosition) {

    }

    @Override
    public void setCurrentItem(int item) {

    }

    @Override
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {

    }

    @Override
    public void notifyDataSetChanged() {

    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
