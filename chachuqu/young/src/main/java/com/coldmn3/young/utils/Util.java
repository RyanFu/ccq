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

import java.io.Closeable;
import java.io.IOException;

/**
 * 项目工具类<br>
 * 项目工具类,提供一些工具方法，例如网络连接是否开启，关闭输入输出流等
 *
 * @version 1.0
 * @author： session
 * @date：2013-9-4 下午4:09
 */
public class Util {

    public static void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
                stream = null;
            } catch (IOException e) {
                ULog.error(e.getMessage());
            } finally {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e) {
                        stream = null;
                        ULog.error(e.getMessage());
                    }
                    stream = null;
                }
            }
        }
    }

}
