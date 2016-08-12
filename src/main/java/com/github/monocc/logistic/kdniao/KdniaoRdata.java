package com.github.monocc.logistic.kdniao;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 快递鸟接口返回数据
 */
public class KdniaoRdata {

    @JSONField(name="EBusinessID")
    private String eBusinessID;
    @JSONField(name="ShipperCode")
    private String shipperCode;
    @JSONField(name="Success")
    private boolean success;
    @JSONField(name="Reason")
    private String reason;
    @JSONField(name="LogisticCode")
    private String logisticCode;
    @JSONField(name="State")
    private String state;
    @JSONField(name="Traces")
    private List<KdniaoRdataTrace> traces;

    public String geteBusinessID() {
        return eBusinessID;
    }

    public void seteBusinessID(String eBusinessID) {
        this.eBusinessID = eBusinessID;
    }

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getLogisticCode() {
        return logisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<KdniaoRdataTrace> getTraces() {
        return traces;
    }

    public void setTraces(List<KdniaoRdataTrace> traces) {
        this.traces = traces;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
