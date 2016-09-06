package hello.common;

/**
 * Created by tiansai on 16/5/21.
 */
public class Result {
    public final static int STATUS_ERROR = 0;
    public final static int STATUS_SUCCESS = 1;
    public final static int STATUS_TIMEOUT = -1;

    public final static String MSG_ERROR = "error";
    public final static String MSG_SUCCESS = "success";
    public final static String MSG_TIMEOUT = "timeout";

    private int status = STATUS_SUCCESS;
    private String msg = MSG_SUCCESS;
    private Object content;

    public Result(int status, String msg, Object content) {
        this.status = status;
        this.msg = msg;
        this.content = content;
    }

    public Result(Object content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
