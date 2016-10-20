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

