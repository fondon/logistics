package com.github.monocc.logistic;

/**
 * 快递跟踪，跟踪快递的状态
 */
public class Trace {
    private String time;
    private String content;
    private String remark;

    public Trace(String time, String content) {
        this(time, content, null);
    }

    public Trace(String time, String content, String remark) {
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
