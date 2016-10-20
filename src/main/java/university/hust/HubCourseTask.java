package university.hust;

import okhttp3.*;
import sun.net.www.http.HttpClient;
import util.BuilderFactory;
import util.CourseTask;

import java.io.IOException;

/**
 * Created by CoXier on 2016/10/19
 */
public class HubCourseTask implements CourseTask {
    String url = "http://s.hub.hust.edu.cn:80/aam/score/CourseInquiry_ido.action";

    public String execute(OkHttpClient client, String start, String end) {
        RequestBody requestBody = new FormBody.Builder()
                .add("start", start)
                .add("end", end)
                .build();
        Request request = new BuilderFactory()
                .url(url)
                .host("s.hub.hust.edu.cn")
                .referer("http://s.hub.hust.edu.cn/hublogin.action")
                .create()
                .post(requestBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
