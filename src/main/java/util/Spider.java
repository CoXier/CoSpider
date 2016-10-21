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

/**
 * Created by CoXier on 2016/10/18
 */
public class Spider {
    private String userName;
    private String password;
    private String start;
    private String end;

    private Spider(){

    }
    public String execute(Task task) {
        return task.execute(userName, password, start, end);
    }

    public Spider(Builder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
        this.start = builder.start;
        this.end = builder.end;
    }

    public static class Builder {
        String userName;
        String password;
        String start;
        String end;


        public Builder addName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder addPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder addStart(String start) {
            this.start = start;
            return this;
        }

        public Builder addEnd(String end) {
            this.end = end;
            return this;
        }

        public Spider build() {
            return new Spider(this);
        }

    }


}

