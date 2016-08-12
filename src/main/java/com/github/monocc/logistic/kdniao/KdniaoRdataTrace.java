package com.github.monocc.logistic.kdniao;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 快递鸟返回的跟踪细节数据
 */
public class KdniaoRdataTrace {
    @JSONField(name="AcceptTime")
    private String acceptTime;
    @JSONField(name="AcceptStation")
    private String acceptStation;

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getAcceptStation() {
        return acceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        this.acceptStation = acceptStation;
    }
}
