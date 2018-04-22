package com.example.a19233.eventbusdemo;

/**
 * Created by 19233 on 2018/4/22 14:19.
 */

public class Bean {
    public String msg;
    public String id;
    public String time;

    public Bean(String msg, String id, String time) {
        this.msg = msg;
        this.id = id;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "msg='" + msg + '\'' +
                ", id='" + id + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
