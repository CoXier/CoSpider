package university.whut;

import okhttp3.*;
import util.BuilderFactory;
import util.LoginTask;

import java.io.IOException;
import java.util.Date;

/**
 * Created by CoXier on 2016/10/19
 */
public class WHUTLoginTask implements LoginTask {
    String url = "http://sso.jwc.whut.edu.cn/Certification/login.do";
    public int execute(OkHttpClient client, String userName, String password) {
        RequestBody requestBody = new FormBody.Builder()
                .add("imageField.x","70")
                .add("imageField.y","28")
                .add("password",password)
                .add("systemId","")
                .add("type","xs")
                .add("userName",userName)
                .add("xmlmsg","")
                .build();
        Request request = new BuilderFactory()
                .url(url)
                .referer("http://sso.jwc.whut.edu.cn/Certification/toLogin.do")
                .host("sso.jwc.whut.edu.cn")
                .create()
                .post(requestBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
