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
