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
