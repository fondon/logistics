package com.github.monocc.logistic;

/**
 * Created by chongdi.yang on 2016/8/8.
 */
public class SimpleTrace implements Trace {
    private String time;
    private String content;
    private String remark;

    public SimpleTrace(String time, String content) {
        this(time, content, null);
    }

    public SimpleTrace(String time, String content, String remark) {
        this.time = time;
        this.content = content;
        this.remark = remark;
    }
    
    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public String getRemark() {
        return remark;
    }
}
