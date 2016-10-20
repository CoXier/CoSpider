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
                .cookieJar(new CookieJar() {
                    private final HashMap<String, List<Cookie>> cookieStore = new HashMap<String, List<Cookie>>();

                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                        cookieStore.put(url.host(), cookies);
                    }

                    public List<Cookie> loadForRequest(HttpUrl url) {
                        List<Cookie> cookies = cookieStore.get(url.host());
                        return cookies != null ? cookies : new ArrayList<Cookie>();
                    }
                }).build();
        loginTask.execute(client, userName, password);
        return courseTask.execute(client, start, end);
    }
}
