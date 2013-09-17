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
package com.coldmn3.ccq.ui.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.coldmn3.ccq.CCQConstants;
import com.coldmn3.ccq.R;
import com.coldmn3.young.utils.AndroidUtils;
import com.coldmn3.young.utils.StringUtils;
import net.tsz.afinal.FinalHttp;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 登录
 *
 * @version 1.0
 * @author： session
 * @date：2013-9-17 上午11:46
 */
public class LoginActivity extends Activity {

    private ImageView btn_back;
    private Button btn_login_submit;
    private EditText edt_login_name;
    private EditText edt_login_password;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initViews();
        setListeners();
    }

    private void initViews() {
        btn_back = (ImageView) findViewById(R.id.actionbar_btn_back);
        btn_login_submit = (Button) findViewById(R.id.login_submit);
        edt_login_name = (EditText) findViewById(R.id.login_input_name);
        edt_login_password = (EditText) findViewById(R.id.login_input_password);
    }

    private void setListeners() {
        btn_back.setOnClickListener(listener);
        btn_login_submit.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            int id = v.getId();

            switch (id) {
                case R.id.actionbar_btn_back:
                    LoginActivity.this.finish();
                    break;
                case R.id.login_submit:
                    try {
                        handleLogin();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
            }
        }
    };

    private void handleLogin() throws UnsupportedEncodingException {
        String name = edt_login_name.getEditableText().toString();
        String password = edt_login_password.getEditableText().toString();

        if (StringUtils.isEmpty(name)) {
            AndroidUtils.Toast(this, R.string.login_name_empty);
            return;
        }
        if (StringUtils.isEmpty(password)) {
            AndroidUtils.Toast(this, R.string.login_password_empty);
            return;
        }

        StringBuffer body = new StringBuffer();
        body.append(CCQConstants.SEGMENT_LOGIN_BODY);
        body.append(URLEncoder.encode(name, CCQConstants.CHARSET_UTF8));
        body.append(CCQConstants.SEGMENT_LOGIN_BODY2);
        body.append(URLEncoder.encode(password, CCQConstants.CHARSET_UTF8));

        LoginTask task = new LoginTask(LoginActivity.this);
        task.execute(CCQConstants.LOGIN_URL, body.toString(), name);
    }


}