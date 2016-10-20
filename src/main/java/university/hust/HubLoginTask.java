package university.hust;

import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import util.BuilderFactory;
import util.LoginTask;

import java.io.IOException;

/**
 * Created by CoXier on 2016/10/19
 */
public class HubLoginTask implements LoginTask {
    String indexUrl = "http://hub.hust.edu.cn/index.jsp";
    String firstLoginUrl = "http://hub.hust.edu.cn/hublogin.action";
    String secondLoginUrl = "http://s.hub.hust.edu.cn/hublogin.action";
    String ln;

    public int execute(OkHttpClient client, String userName, String password) {
        getLn(client);
        Document form = firstLogin(userName, password, client);
        secondLogin(form, client);
        return 0;
    }

    private void getLn(OkHttpClient client) {
        Request request = new Request.Builder().url(indexUrl).build();
        try {
            Response response = client.newCall(request).execute();
            ln = Jsoup.parse(response.body().string()).getElementsByTag("input").get(5).val();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Document firstLogin(String name, String password, OkHttpClient client) {
        String encodePassword = it.sauronsoftware.base64.Base64.encode(password);
        RequestBody requestBody = new FormBody.Builder()
                .add("ln", ln)
                .add("password", encodePassword)
                .add("username", name)
                .build();
        Request request = new BuilderFactory()
                .url(firstLoginUrl)
                .host("hub.hust.edu.cn")
                .referer("http://hub.hust.edu.cn/index.jsp")
                .create()
                .post(requestBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return Jsoup.parse(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void secondLogin(Document form, OkHttpClient client) {
        String userType = form.getElementsByTag("input").get(0).val();
        String userName = form.getElementsByTag("input").get(1).val();
        String password = form.getElementsByTag("input").get(2).val();
        String url = form.getElementsByTag("input").get(3).val();
        String key1 = form.getElementsByTag("input").get(4).val();
        String key2 = form.getElementsByTag("input").get(5).val();
        String FAPP = form.getElementsByTag("input").get(6).val();
        RequestBody requestBody = new FormBody.Builder()
                .add("usertype",userType)
                .add("username",userName)
                .add("password",password)
                .add("url",url)
                .add("key1",key1)
                .add("key2",key2)
                .add("F_App",FAPP)
                .build();
        Request request = new BuilderFactory()
                .url(secondLoginUrl)
                .host("s.hub.hust.edu.cn")
                .referer("http://hub.hust.edu.cn/hublogin.action")
                .create()
                .post(requestBody)
                .build();
        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
