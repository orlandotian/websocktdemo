package hello;

import java.util.Date;

/**
 * Created by tiansai on 16/6/27.
 */
public class HelloMessage {
    private String name;
    private String content;
    private String time;

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }
}
