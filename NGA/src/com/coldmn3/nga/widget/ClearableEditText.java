/*
 * 文件名：DEditText.java
 * 版权：(C)版权所有2013-2013宇龄信息科技(无锡)有限公司
 * 描述：
 * 修改人：wuhai
 * 修改时间：2013-7-10 下午5:22:00
 */
package com.coldmn3.nga.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;

import com.coldmn3.nga.utils.StringUtils;
import com.coldmn3.nga.widget.TextWatcherAdapter.TextWatcherListener;

/**
 * <带删除功能的EditText> <输入文字后会在EditText最后显示删除按钮，点击后会删除所输入的所有文字>
 * 
 * @author wuhai
 * @version 1.0
 * @date 2013-7-10 下午5:22:00
 */
public class ClearableEditText extends EditText implements OnTouchListener, OnFocusChangeListener, TextWatcherListener {

	public interface Listener {
		void didClearText();
	}

	private Drawable xD;
	private Listener listener;

	public ClearableEditText(Context context) {
		super(context);
		init();
	}

	public ClearableEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public ClearableEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		xD = getCompoundDrawables()[2];
		if (xD == null) {
			xD = getResources().getDrawable(android.R.drawable.presence_offline);
		}
		xD.setBounds(0, 0, xD.getIntrinsicWidth(), xD.getIntrinsicHeight());
		setClearIconVisible(false);
		super.setOnTouchListener(this);
		super.setOnFocusChangeListener(this);
		addTextChangedListener(new TextWatcherAdapter(this, this));
	}

	public void setListener(Listener listener) {
		this.listener = listener;
	}

	@Override
	public void setOnTouchListener(OnTouchListener l) {
		this.l = l;
	}

	@Override
	public void setOnFocusChangeListener(OnFocusChangeListener f) {
		this.f = f;
	}

	private OnTouchListener l;
	private OnFocusChangeListener f;

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (getCompoundDrawables()[2] != null) {
			if (event.getAction() == MotionEvent.ACTION_UP) {
				boolean tappedX = event.getX() > (getWidth() - getPaddingRight() - xD.getIntrinsicWidth());
				if (tappedX) {
					setText("");
					if (listener != null) {
						listener.didClearText();
					}
					return true;
				}
			}
		}
		if (l != null) {
			return l.onTouch(v, event);
		}
		return false;
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		if (hasFocus) {
			setClearIconVisible(StringUtils.isNotEmpty(getText()));
		} else {
			setClearIconVisible(false);
		}
		if (f != null) {
			f.onFocusChange(v, hasFocus);
		}
	}

	@Override
	public void onTextChanged(EditText view, String text) {
		if (isFocused()) {
			setClearIconVisible(StringUtils.isNotEmpty(text));
		}
	}

	protected void setClearIconVisible(boolean visible) {
		Drawable x = visible ? xD : null;
		setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], x, getCompoundDrawables()[3]);
	}
}
