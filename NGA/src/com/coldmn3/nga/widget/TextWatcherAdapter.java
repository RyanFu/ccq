/*
 * 文件名：TextWatcherAdapter.java
 * 版权：(C)版权所有2013-2013宇龄信息科技(无锡)有限公司
 * 描述：
 * 修改人：wuhai
 * 修改时间：2013-7-10 下午5:37:28
 */
package com.coldmn3.nga.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author wuhai
 * @version 1.0
 * @date 2013-7-10 下午5:37:28
 */
public class TextWatcherAdapter implements TextWatcher {

	public interface TextWatcherListener {

		void onTextChanged(EditText view, String text);

	}

	private final EditText view;
	private final TextWatcherListener listener;

	public TextWatcherAdapter(EditText editText, TextWatcherListener listener) {
		this.view = editText;
		this.listener = listener;
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		listener.onTextChanged(view, s.toString());
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// pass
	}

	@Override
	public void afterTextChanged(Editable s) {
		// pass
	}

}