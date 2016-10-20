package util;


import okhttp3.OkHttpClient;

/**
 * Created by CoXier on 2016/10/19
 */
public interface LoginTask {
    int execute(OkHttpClient client, String userName, String password);
}
