package university.whut;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import util.BuilderFactory;
import util.CourseTask;

import java.io.IOException;

/**
 * Created by CoXier on 2016/10/19
 */
public class WHUTCourseTask implements CourseTask {
    public String execute(OkHttpClient client, String start, String end) {
        String url = "http://202.114.90.176:8080/DailyMgt/kbcx.do?_="+System.currentTimeMillis();
        gotoCoursePage(client);
        Request request = new BuilderFactory()
                .url(url)
                .host("202.114.90.176:8080")
                .create()
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void gotoCoursePage(OkHttpClient client) {
        String url = "http://202.114.90.176:8080/DailyMgt";
        Request request = new BuilderFactory()
                .url(url)
                .host("202.114.90.176:8080")
                .create()
                .build();
        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
