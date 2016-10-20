package test;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import university.hust.HubCourseTask;
import university.hust.HubLoginTask;
import util.Spider;
import util.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by CoXier on 2016/10/19
 */
public class HubTest {
    public static void main(String[] args) {
        // 为了隐私，学号和密码没贴出来
        Spider spider = new Spider.Builder()
                .addName("username")
                .addPassword("password")
                .addStart("2016-10-19")
                .addEnd("2016-10-20")
                .build();
        HubLoginTask loginTask = new HubLoginTask();
        HubCourseTask courseTask = new HubCourseTask();
        Task task = new Task(loginTask, courseTask);
        System.out.println(spider.execute(task));
    }
}
