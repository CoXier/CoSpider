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
