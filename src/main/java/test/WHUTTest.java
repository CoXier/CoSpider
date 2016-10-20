package test;

import university.whut.WHUTCourseTask;
import university.whut.WHUTLoginTask;
import util.Spider;
import util.Task;

/**
 * Created by CoXier on 2016/10/19
 */
public class WHUTTest {
    public static void main(String[] args) {
        String userName = "";
        String password = "";

        Spider spider = new Spider.Builder()
                .addName(userName)
                .addPassword(password)
                .addStart("2016-10-19")
                .addEnd("2016-10-20")
                .build();
        Task task = new Task(new WHUTLoginTask(),new WHUTCourseTask());
        spider.execute(task);
    }
}
