/*
 * Copyright 2016 coxier. https://github.com/coxier
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package util;


import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by CoXier on 2016/10/19
 */
public class Task {
    private LoginTask loginTask;
    private CourseTask courseTask;


    public Task(LoginTask loginTask, CourseTask courseTask) {
        this.loginTask = loginTask;
        this.courseTask = courseTask;
    }

    String execute(String userName, String password, String start, String end) {
        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(new CustomCookieJar()).build();
        loginTask.execute(client, userName, password);
        return courseTask.execute(client, start, end);
    }
}
