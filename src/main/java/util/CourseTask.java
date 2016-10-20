package util;


import okhttp3.OkHttpClient;

/**
 * Created by CoXier on 2016/10/19
 */
public interface CourseTask {
    String execute(OkHttpClient client, String start, String end);
}
