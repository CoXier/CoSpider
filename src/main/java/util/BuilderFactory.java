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

import okhttp3.Request;

/**
 * Created by CoXier on 2016/10/19
 */
public class BuilderFactory {
    private Request.Builder builder;

    public BuilderFactory url(String url) {
        if (builder == null) {
            builder = new Request.Builder();
        }
        builder = builder.url(url);
        return this;
    }

    public BuilderFactory host(String host) {
        if (builder == null) {
            builder = new Request.Builder();
        }
        builder = builder.addHeader("Host", host);
        return this;
    }

    public BuilderFactory referer(String referer) {
        if (builder == null) {
            builder = new Request.Builder();
        }
        builder = builder.addHeader("Referer", referer);
        return this;
    }

    public Request.Builder create() {
        builder.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                .addHeader("Connection", "keep-alive")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0");
        return builder;
    }
}
