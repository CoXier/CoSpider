## CoSpider
CoSpider是一个专注中国大学**课表**的爬虫，类似于超级课程表,目前能爬取华中科技大学、武汉理工大学的个人课表

## For  Developer

### 工具
- 网络工具：Firefox + Firebug
- 开发工具：IDEA
- 构建工具： gradle

### 依赖库
- OkHttp3.0
- Jsoup

### 开发
想借鉴此库来爬取你们学校的课表吗？
一般来说爬课表，关键的是模拟登陆，让服务器认为你是浏览器，使用`OkHttp3.0`管理Cookie即可，这一点请参考
`CustomCookieJar`
开发步骤：

- 实现`LoginTask`接口，完成登录步骤
- 实现`CouseTask`接口，完成爬取课表步骤

```java
//new a login task implemnts the interface
class YourLoginTask implements LoginTask{
     int execute(OkHttpClient client, String userName, String password){
        // just try to login
     }
}


// couser task
class YourCourseTask implements CourseTask{
     String execute(OkHttpClient client, String start, String end){
        // get course and return it
     }
}

```

## For User
使用方法(以爬取华科课表为例)：

```java
Spider spider = new Spider.Builder()
                .addName("username")
                .addPassword("password")
                .addStart("2016-10-19")
                .addEnd("2016-10-20")
                .build();
HubLoginTask loginTask = new HubLoginTask();
HubCourseTask courseTask = new HubCourseTask();
Task task = new Task(loginTask, courseTask);
String result = spider.execute(task);
```

## Tip
* 华中科技大学HUB系统：密码采用Base64加密，而且使用了中转登录机制
* 对于武大和华农之类需要验证码的：在手机端或者Pc端存储验证码图片，然后手动填写验证码

## License
Copyright 2016 coxier.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.